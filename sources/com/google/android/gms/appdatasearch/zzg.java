package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.appdatasearch.GetRecentContextCall.Response;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0524zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzg implements Creator<Response> {
    static void zza(Response response, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zzc(parcel, CredentialsApi.ACTIVITY_RESULT_ADD_ACCOUNT, response.mVersionCode);
        zzb.zza(parcel, 1, (Parcelable) response.zzQA, i, false);
        zzb.zzc(parcel, 2, response.zzQB, false);
        zzb.zza(parcel, 3, response.zzQC, false);
        zzb.zzI(parcel, zzaq);
    }

    /* renamed from: zzaj */
    public Response[] newArray(int i) {
        return new Response[i];
    }

    /* renamed from: zzw */
    public Response createFromParcel(Parcel parcel) {
        String[] zzB;
        List list;
        Status status;
        int i;
        String[] strArr = null;
        int zzap = zza.zzap(parcel);
        int i2 = 0;
        List list2 = null;
        Status status2 = null;
        while (parcel.dataPosition() < zzap) {
            int zzao = zza.zzao(parcel);
            switch (zza.zzbM(zzao)) {
                case 1:
                    i = i2;
                    List list3 = list2;
                    status = (Status) zza.zza(parcel, zzao, Status.CREATOR);
                    zzB = strArr;
                    list = list3;
                    break;
                case 2:
                    status = status2;
                    i = i2;
                    String[] strArr2 = strArr;
                    list = zza.zzc(parcel, zzao, UsageInfo.CREATOR);
                    zzB = strArr2;
                    break;
                case 3:
                    zzB = zza.zzB(parcel, zzao);
                    list = list2;
                    status = status2;
                    i = i2;
                    break;
                case CredentialsApi.ACTIVITY_RESULT_ADD_ACCOUNT /*1000*/:
                    String[] strArr3 = strArr;
                    list = list2;
                    status = status2;
                    i = zza.zzg(parcel, zzao);
                    zzB = strArr3;
                    break;
                default:
                    zza.zzb(parcel, zzao);
                    zzB = strArr;
                    list = list2;
                    status = status2;
                    i = i2;
                    break;
            }
            i2 = i;
            status2 = status;
            list2 = list;
            strArr = zzB;
        }
        if (parcel.dataPosition() == zzap) {
            return new Response(i2, status2, list2, strArr);
        }
        throw new C0524zza("Overread allowed size end=" + zzap, parcel);
    }
}
