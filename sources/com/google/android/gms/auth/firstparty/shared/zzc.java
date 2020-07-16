package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0524zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzc implements Creator<ScopeDetail> {
    static void zza(ScopeDetail scopeDetail, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, scopeDetail.version);
        zzb.zza(parcel, 2, scopeDetail.description, false);
        zzb.zza(parcel, 3, scopeDetail.zzTH, false);
        zzb.zza(parcel, 4, scopeDetail.zzTI, false);
        zzb.zza(parcel, 5, scopeDetail.zzTJ, false);
        zzb.zza(parcel, 6, scopeDetail.zzTK, false);
        zzb.zzb(parcel, 7, scopeDetail.zzTL, false);
        zzb.zza(parcel, 8, (Parcelable) scopeDetail.zzTM, i, false);
        zzb.zzI(parcel, zzaq);
    }

    /* renamed from: zzV */
    public ScopeDetail createFromParcel(Parcel parcel) {
        FACLData fACLData = null;
        int zzap = zza.zzap(parcel);
        int i = 0;
        ArrayList arrayList = new ArrayList();
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        while (parcel.dataPosition() < zzap) {
            int zzao = zza.zzao(parcel);
            switch (zza.zzbM(zzao)) {
                case 1:
                    i = zza.zzg(parcel, zzao);
                    break;
                case 2:
                    str5 = zza.zzp(parcel, zzao);
                    break;
                case 3:
                    str4 = zza.zzp(parcel, zzao);
                    break;
                case 4:
                    str3 = zza.zzp(parcel, zzao);
                    break;
                case 5:
                    str2 = zza.zzp(parcel, zzao);
                    break;
                case 6:
                    str = zza.zzp(parcel, zzao);
                    break;
                case 7:
                    arrayList = zza.zzD(parcel, zzao);
                    break;
                case 8:
                    fACLData = (FACLData) zza.zza(parcel, zzao, (Creator<T>) FACLData.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzao);
                    break;
            }
        }
        if (parcel.dataPosition() == zzap) {
            return new ScopeDetail(i, str5, str4, str3, str2, str, arrayList, fACLData);
        }
        throw new C0524zza("Overread allowed size end=" + zzap, parcel);
    }

    /* renamed from: zzaM */
    public ScopeDetail[] newArray(int i) {
        return new ScopeDetail[i];
    }
}
