package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0524zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzy implements Creator<ResolveAccountRequest> {
    static void zza(ResolveAccountRequest resolveAccountRequest, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, resolveAccountRequest.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) resolveAccountRequest.getAccount(), i, false);
        zzb.zzc(parcel, 3, resolveAccountRequest.getSessionId());
        zzb.zzI(parcel, zzaq);
    }

    /* renamed from: zzal */
    public ResolveAccountRequest createFromParcel(Parcel parcel) {
        int zzg;
        Account account;
        int i;
        int i2 = 0;
        int zzap = zza.zzap(parcel);
        Account account2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzap) {
            int zzao = zza.zzao(parcel);
            switch (zza.zzbM(zzao)) {
                case 1:
                    int i4 = i2;
                    account = account2;
                    i = zza.zzg(parcel, zzao);
                    zzg = i4;
                    break;
                case 2:
                    i = i3;
                    Account account3 = (Account) zza.zza(parcel, zzao, Account.CREATOR);
                    zzg = i2;
                    account = account3;
                    break;
                case 3:
                    zzg = zza.zzg(parcel, zzao);
                    account = account2;
                    i = i3;
                    break;
                default:
                    zza.zzb(parcel, zzao);
                    zzg = i2;
                    account = account2;
                    i = i3;
                    break;
            }
            i3 = i;
            account2 = account;
            i2 = zzg;
        }
        if (parcel.dataPosition() == zzap) {
            return new ResolveAccountRequest(i3, account2, i2);
        }
        throw new C0524zza("Overread allowed size end=" + zzap, parcel);
    }

    /* renamed from: zzbJ */
    public ResolveAccountRequest[] newArray(int i) {
        return new ResolveAccountRequest[i];
    }
}
