package com.google.android.gms.auth.api.signin;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0524zza;
import java.util.ArrayList;

public class zzb implements Creator<FacebookSignInConfig> {
    static void zza(FacebookSignInConfig facebookSignInConfig, Parcel parcel, int i) {
        int zzaq = com.google.android.gms.common.internal.safeparcel.zzb.zzaq(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, facebookSignInConfig.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) facebookSignInConfig.zzlR(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, 3, facebookSignInConfig.zzlS(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, zzaq);
    }

    /* renamed from: zzP */
    public FacebookSignInConfig createFromParcel(Parcel parcel) {
        ArrayList zzD;
        Intent intent;
        int i;
        ArrayList arrayList = null;
        int zzap = zza.zzap(parcel);
        int i2 = 0;
        Intent intent2 = null;
        while (parcel.dataPosition() < zzap) {
            int zzao = zza.zzao(parcel);
            switch (zza.zzbM(zzao)) {
                case 1:
                    ArrayList arrayList2 = arrayList;
                    intent = intent2;
                    i = zza.zzg(parcel, zzao);
                    zzD = arrayList2;
                    break;
                case 2:
                    i = i2;
                    Intent intent3 = (Intent) zza.zza(parcel, zzao, Intent.CREATOR);
                    zzD = arrayList;
                    intent = intent3;
                    break;
                case 3:
                    zzD = zza.zzD(parcel, zzao);
                    intent = intent2;
                    i = i2;
                    break;
                default:
                    zza.zzb(parcel, zzao);
                    zzD = arrayList;
                    intent = intent2;
                    i = i2;
                    break;
            }
            i2 = i;
            intent2 = intent;
            arrayList = zzD;
        }
        if (parcel.dataPosition() == zzap) {
            return new FacebookSignInConfig(i2, intent2, arrayList);
        }
        throw new C0524zza("Overread allowed size end=" + zzap, parcel);
    }

    /* renamed from: zzaG */
    public FacebookSignInConfig[] newArray(int i) {
        return new FacebookSignInConfig[i];
    }
}
