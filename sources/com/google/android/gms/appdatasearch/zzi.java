package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0524zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi implements Creator<RegisterSectionInfo> {
    static void zza(RegisterSectionInfo registerSectionInfo, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zza(parcel, 1, registerSectionInfo.name, false);
        zzb.zzc(parcel, CredentialsApi.ACTIVITY_RESULT_ADD_ACCOUNT, registerSectionInfo.mVersionCode);
        zzb.zza(parcel, 2, registerSectionInfo.zzQF, false);
        zzb.zza(parcel, 3, registerSectionInfo.zzQG);
        zzb.zzc(parcel, 4, registerSectionInfo.weight);
        zzb.zza(parcel, 5, registerSectionInfo.zzQH);
        zzb.zza(parcel, 6, registerSectionInfo.zzQI, false);
        zzb.zza(parcel, 7, (T[]) registerSectionInfo.zzQJ, i, false);
        zzb.zza(parcel, 8, registerSectionInfo.zzQK, false);
        zzb.zza(parcel, 11, registerSectionInfo.zzQL, false);
        zzb.zzI(parcel, zzaq);
    }

    /* renamed from: zzam */
    public RegisterSectionInfo[] newArray(int i) {
        return new RegisterSectionInfo[i];
    }

    /* renamed from: zzx */
    public RegisterSectionInfo createFromParcel(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzap = zza.zzap(parcel);
        int i = 1;
        int[] iArr = null;
        Feature[] featureArr = null;
        String str2 = null;
        boolean z2 = false;
        String str3 = null;
        String str4 = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzap) {
            int zzao = zza.zzao(parcel);
            switch (zza.zzbM(zzao)) {
                case 1:
                    str4 = zza.zzp(parcel, zzao);
                    break;
                case 2:
                    str3 = zza.zzp(parcel, zzao);
                    break;
                case 3:
                    z2 = zza.zzc(parcel, zzao);
                    break;
                case 4:
                    i = zza.zzg(parcel, zzao);
                    break;
                case 5:
                    z = zza.zzc(parcel, zzao);
                    break;
                case 6:
                    str2 = zza.zzp(parcel, zzao);
                    break;
                case 7:
                    featureArr = (Feature[]) zza.zzb(parcel, zzao, Feature.CREATOR);
                    break;
                case 8:
                    iArr = zza.zzv(parcel, zzao);
                    break;
                case 11:
                    str = zza.zzp(parcel, zzao);
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
            return new RegisterSectionInfo(i2, str4, str3, z2, i, z, str2, featureArr, iArr, str);
        }
        throw new C0524zza("Overread allowed size end=" + zzap, parcel);
    }
}
