package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;

public class zza extends com.google.android.gms.common.internal.zzp.zza {
    private Context mContext;
    private Account zzQd;
    int zzaeG;

    public static Account zzb(zzp zzp) {
        Account account = null;
        if (zzp != null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                account = zzp.getAccount();
            } catch (RemoteException e) {
                Log.w("AccountAccessor", "Remote account accessor probably died");
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
        return account;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof zza)) {
            return false;
        }
        return this.zzQd.equals(((zza) o).zzQd);
    }

    public Account getAccount() {
        int callingUid = Binder.getCallingUid();
        if (callingUid == this.zzaeG) {
            return this.zzQd;
        }
        if (GooglePlayServicesUtil.zze(this.mContext, callingUid)) {
            this.zzaeG = callingUid;
            return this.zzQd;
        }
        throw new SecurityException("Caller is not GooglePlayServices");
    }
}
