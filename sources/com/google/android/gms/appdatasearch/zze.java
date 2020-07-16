package com.google.android.gms.appdatasearch;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0524zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Creator<Feature> {
    static void zza(Feature feature, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, feature.f17id);
        zzb.zzc(parcel, CredentialsApi.ACTIVITY_RESULT_ADD_ACCOUNT, feature.mVersionCode);
        zzb.zza(parcel, 2, feature.zzQn, false);
        zzb.zzI(parcel, zzaq);
    }

    /* renamed from: zzah */
    public Feature[] newArray(int i) {
        return new Feature[i];
    }

    /* renamed from: zzu */
    public Feature createFromParcel(Parcel parcel) {
        int i = 0;
        int zzap = zza.zzap(parcel);
        Bundle bundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzap) {
            int zzao = zza.zzao(parcel);
            switch (zza.zzbM(zzao)) {
                case 1:
                    i = zza.zzg(parcel, zzao);
                    break;
                case 2:
                    bundle = zza.zzr(parcel, zzao);
                    break;
                case CredentialsApi.ACTIVITY_RESULT_ADD_ACCOUNT /*1000*/:
                    i2 = zza.zzg(parcel, zzao);
                    break;
                default:
                    zza.zzb(parcel, zzao);
                    break;
            }
        }
        if (parcel.dataPosition() == zzap) {
            return new Feature(i2, i, bundle);
        }
        throw new C0524zza("Overread allowed size end=" + zzap, parcel);
    }
}
