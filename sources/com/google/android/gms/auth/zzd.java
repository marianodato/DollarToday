package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0524zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzd implements Creator<TokenData> {
    static void zza(TokenData tokenData, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, tokenData.mVersionCode);
        zzb.zza(parcel, 2, tokenData.getToken(), false);
        zzb.zza(parcel, 3, tokenData.zzlA(), false);
        zzb.zza(parcel, 4, tokenData.zzlB());
        zzb.zza(parcel, 5, tokenData.zzlC());
        zzb.zzb(parcel, 6, tokenData.zzlD(), false);
        zzb.zzI(parcel, zzaq);
    }

    /* renamed from: zzC */
    public TokenData createFromParcel(Parcel parcel) {
        ArrayList arrayList = null;
        boolean z = false;
        int zzap = zza.zzap(parcel);
        boolean z2 = false;
        Long l = null;
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < zzap) {
            int zzao = zza.zzao(parcel);
            switch (zza.zzbM(zzao)) {
                case 1:
                    i = zza.zzg(parcel, zzao);
                    break;
                case 2:
                    str = zza.zzp(parcel, zzao);
                    break;
                case 3:
                    l = zza.zzj(parcel, zzao);
                    break;
                case 4:
                    z2 = zza.zzc(parcel, zzao);
                    break;
                case 5:
                    z = zza.zzc(parcel, zzao);
                    break;
                case 6:
                    arrayList = zza.zzD(parcel, zzao);
                    break;
                default:
                    zza.zzb(parcel, zzao);
                    break;
            }
        }
        if (parcel.dataPosition() == zzap) {
            return new TokenData(i, str, l, z2, z, arrayList);
        }
        throw new C0524zza("Overread allowed size end=" + zzap, parcel);
    }

    /* renamed from: zzat */
    public TokenData[] newArray(int i) {
        return new TokenData[i];
    }
}
