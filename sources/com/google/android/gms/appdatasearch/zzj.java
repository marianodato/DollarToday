package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0524zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzj implements Creator<UsageInfo> {
    static void zza(UsageInfo usageInfo, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zza(parcel, 1, (Parcelable) usageInfo.zzQU, i, false);
        zzb.zzc(parcel, CredentialsApi.ACTIVITY_RESULT_ADD_ACCOUNT, usageInfo.mVersionCode);
        zzb.zza(parcel, 2, usageInfo.zzQV);
        zzb.zzc(parcel, 3, usageInfo.zzQW);
        zzb.zza(parcel, 4, usageInfo.zzub, false);
        zzb.zza(parcel, 5, (Parcelable) usageInfo.zzQX, i, false);
        zzb.zza(parcel, 6, usageInfo.zzQY);
        zzb.zzc(parcel, 7, usageInfo.zzQZ);
        zzb.zzc(parcel, 8, usageInfo.zzRa);
        zzb.zzI(parcel, zzaq);
    }

    /* renamed from: zzap */
    public UsageInfo[] newArray(int i) {
        return new UsageInfo[i];
    }

    /* renamed from: zzy */
    public UsageInfo createFromParcel(Parcel parcel) {
        DocumentContents documentContents = null;
        int i = 0;
        int zzap = zza.zzap(parcel);
        long j = 0;
        int i2 = -1;
        boolean z = false;
        String str = null;
        int i3 = 0;
        DocumentId documentId = null;
        int i4 = 0;
        while (parcel.dataPosition() < zzap) {
            int zzao = zza.zzao(parcel);
            switch (zza.zzbM(zzao)) {
                case 1:
                    documentId = (DocumentId) zza.zza(parcel, zzao, (Creator<T>) DocumentId.CREATOR);
                    break;
                case 2:
                    j = zza.zzi(parcel, zzao);
                    break;
                case 3:
                    i3 = zza.zzg(parcel, zzao);
                    break;
                case 4:
                    str = zza.zzp(parcel, zzao);
                    break;
                case 5:
                    documentContents = (DocumentContents) zza.zza(parcel, zzao, (Creator<T>) DocumentContents.CREATOR);
                    break;
                case 6:
                    z = zza.zzc(parcel, zzao);
                    break;
                case 7:
                    i2 = zza.zzg(parcel, zzao);
                    break;
                case 8:
                    i = zza.zzg(parcel, zzao);
                    break;
                case CredentialsApi.ACTIVITY_RESULT_ADD_ACCOUNT /*1000*/:
                    i4 = zza.zzg(parcel, zzao);
                    break;
                default:
                    zza.zzb(parcel, zzao);
                    break;
            }
        }
        if (parcel.dataPosition() == zzap) {
            return new UsageInfo(i4, documentId, j, i3, str, documentContents, z, i2, i);
        }
        throw new C0524zza("Overread allowed size end=" + zzap, parcel);
    }
}
