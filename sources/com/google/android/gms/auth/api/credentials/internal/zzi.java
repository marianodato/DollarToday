package com.google.android.gms.auth.api.credentials.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0524zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi implements Creator<SaveRequest> {
    static void zza(SaveRequest saveRequest, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zza(parcel, 1, (Parcelable) saveRequest.getCredential(), i, false);
        zzb.zzc(parcel, CredentialsApi.ACTIVITY_RESULT_ADD_ACCOUNT, saveRequest.mVersionCode);
        zzb.zzI(parcel, zzaq);
    }

    /* renamed from: zzK */
    public SaveRequest createFromParcel(Parcel parcel) {
        int zzap = zza.zzap(parcel);
        int i = 0;
        Credential credential = null;
        while (parcel.dataPosition() < zzap) {
            int zzao = zza.zzao(parcel);
            switch (zza.zzbM(zzao)) {
                case 1:
                    credential = (Credential) zza.zza(parcel, zzao, Credential.CREATOR);
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
            return new SaveRequest(i, credential);
        }
        throw new C0524zza("Overread allowed size end=" + zzap, parcel);
    }

    /* renamed from: zzaB */
    public SaveRequest[] newArray(int i) {
        return new SaveRequest[i];
    }
}
