package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0524zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zze implements Creator<GoogleSignInConfig> {
    static void zza(GoogleSignInConfig googleSignInConfig, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, googleSignInConfig.versionCode);
        zzb.zzc(parcel, 2, googleSignInConfig.zzlS(), false);
        zzb.zza(parcel, 3, (Parcelable) googleSignInConfig.getAccount(), i, false);
        zzb.zza(parcel, 4, googleSignInConfig.zzlY());
        zzb.zza(parcel, 5, googleSignInConfig.zzlZ());
        zzb.zza(parcel, 6, googleSignInConfig.zzma());
        zzb.zza(parcel, 7, googleSignInConfig.zzmb(), false);
        zzb.zzI(parcel, zzaq);
    }

    /* renamed from: zzR */
    public GoogleSignInConfig createFromParcel(Parcel parcel) {
        String str = null;
        boolean z = false;
        int zzap = zza.zzap(parcel);
        boolean z2 = false;
        boolean z3 = false;
        Account account = null;
        ArrayList arrayList = null;
        int i = 0;
        while (parcel.dataPosition() < zzap) {
            int zzao = zza.zzao(parcel);
            switch (zza.zzbM(zzao)) {
                case 1:
                    i = zza.zzg(parcel, zzao);
                    break;
                case 2:
                    arrayList = zza.zzc(parcel, zzao, Scope.CREATOR);
                    break;
                case 3:
                    account = (Account) zza.zza(parcel, zzao, Account.CREATOR);
                    break;
                case 4:
                    z3 = zza.zzc(parcel, zzao);
                    break;
                case 5:
                    z2 = zza.zzc(parcel, zzao);
                    break;
                case 6:
                    z = zza.zzc(parcel, zzao);
                    break;
                case 7:
                    str = zza.zzp(parcel, zzao);
                    break;
                default:
                    zza.zzb(parcel, zzao);
                    break;
            }
        }
        if (parcel.dataPosition() == zzap) {
            return new GoogleSignInConfig(i, arrayList, account, z3, z2, z, str);
        }
        throw new C0524zza("Overread allowed size end=" + zzap, parcel);
    }

    /* renamed from: zzaI */
    public GoogleSignInConfig[] newArray(int i) {
        return new GoogleSignInConfig[i];
    }
}
