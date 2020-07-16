package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0524zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Creator<DocumentId> {
    static void zza(DocumentId documentId, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zza(parcel, 1, documentId.zzQe, false);
        zzb.zzc(parcel, CredentialsApi.ACTIVITY_RESULT_ADD_ACCOUNT, documentId.mVersionCode);
        zzb.zza(parcel, 2, documentId.zzQf, false);
        zzb.zza(parcel, 3, documentId.zzQg, false);
        zzb.zzI(parcel, zzaq);
    }

    /* renamed from: zzaf */
    public DocumentId[] newArray(int i) {
        return new DocumentId[i];
    }

    /* renamed from: zzs */
    public DocumentId createFromParcel(Parcel parcel) {
        String str = null;
        int zzap = zza.zzap(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < zzap) {
            int zzao = zza.zzao(parcel);
            switch (zza.zzbM(zzao)) {
                case 1:
                    str3 = zza.zzp(parcel, zzao);
                    break;
                case 2:
                    str2 = zza.zzp(parcel, zzao);
                    break;
                case 3:
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
            return new DocumentId(i, str3, str2, str);
        }
        throw new C0524zza("Overread allowed size end=" + zzap, parcel);
    }
}
