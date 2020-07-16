package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzp.zza;
import java.util.Collection;

public class GetServiceRequest implements SafeParcelable {
    public static final Creator<GetServiceRequest> CREATOR = new zzi();
    final int version;
    final int zzafq;
    int zzafr;
    String zzafs;
    IBinder zzaft;
    Scope[] zzafu;
    Bundle zzafv;
    Account zzafw;

    public GetServiceRequest(int serviceId) {
        this.version = 2;
        this.zzafr = GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        this.zzafq = serviceId;
    }

    GetServiceRequest(int version2, int serviceId, int clientVersion, String callingPackage, IBinder accountAccessorBinder, Scope[] scopes, Bundle extraArgs, Account clientRequestedAccount) {
        this.version = version2;
        this.zzafq = serviceId;
        this.zzafr = clientVersion;
        this.zzafs = callingPackage;
        if (version2 < 2) {
            this.zzafw = zzaG(accountAccessorBinder);
        } else {
            this.zzaft = accountAccessorBinder;
            this.zzafw = clientRequestedAccount;
        }
        this.zzafu = scopes;
        this.zzafv = extraArgs;
    }

    private Account zzaG(IBinder iBinder) {
        if (iBinder != null) {
            return zza.zzb(zza.zzaH(iBinder));
        }
        return null;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzi.zza(this, dest, flags);
    }

    public GetServiceRequest zzc(Account account) {
        this.zzafw = account;
        return this;
    }

    public GetServiceRequest zzc(zzp zzp) {
        if (zzp != null) {
            this.zzaft = zzp.asBinder();
        }
        return this;
    }

    public GetServiceRequest zzcl(String str) {
        this.zzafs = str;
        return this;
    }

    public GetServiceRequest zzd(Collection<Scope> collection) {
        this.zzafu = (Scope[]) collection.toArray(new Scope[collection.size()]);
        return this;
    }

    public GetServiceRequest zzg(Bundle bundle) {
        this.zzafv = bundle;
        return this;
    }
}
