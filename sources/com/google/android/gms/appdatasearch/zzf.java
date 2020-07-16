package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.appdatasearch.GetRecentContextCall.Request;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0524zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzf implements Creator<Request> {
    static void zza(Request request, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zza(parcel, 1, (Parcelable) request.zzQq, i, false);
        zzb.zzc(parcel, CredentialsApi.ACTIVITY_RESULT_ADD_ACCOUNT, request.mVersionCode);
        zzb.zza(parcel, 2, request.zzQr);
        zzb.zza(parcel, 3, request.zzQs);
        zzb.zza(parcel, 4, request.zzQt);
        zzb.zza(parcel, 5, request.zzQu, false);
        zzb.zzI(parcel, zzaq);
    }

    /* renamed from: zzai */
    public Request[] newArray(int i) {
        return new Request[i];
    }

    /* renamed from: zzv */
    public Request createFromParcel(Parcel parcel) {
        String str = null;
        boolean z = false;
        int zzap = zza.zzap(parcel);
        boolean z2 = false;
        boolean z3 = false;
        Account account = null;
        int i = 0;
        while (parcel.dataPosition() < zzap) {
            int zzao = zza.zzao(parcel);
            switch (zza.zzbM(zzao)) {
                case 1:
                    account = (Account) zza.zza(parcel, zzao, Account.CREATOR);
                    break;
                case 2:
                    z3 = zza.zzc(parcel, zzao);
                    break;
                case 3:
                    z2 = zza.zzc(parcel, zzao);
                    break;
                case 4:
                    z = zza.zzc(parcel, zzao);
                    break;
                case 5:
                    str = zza.zzp(parcel, zzao);
                    break;
                case CredentialsApi.ACTIVITY_RESULT_ADD_ACCOUNT /*1000*/:
                    i = zza.zzg(parcel, zzao);
                    break;
                default:
                    zza.zzb(parcel, zzao);
                    break;
            }
        }
        if (parcel.dataPosition() == zzap) {
            return new Request(i, account, z3, z2, z, str);
        }
        throw new C0524zza("Overread allowed size end=" + zzap, parcel);
    }
}
