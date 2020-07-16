package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.C0524zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Creator<EmailSignInConfig> {
    static void zza(EmailSignInConfig emailSignInConfig, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, emailSignInConfig.versionCode);
        zzb.zza(parcel, 2, (Parcelable) emailSignInConfig.zzlO(), i, false);
        zzb.zza(parcel, 3, emailSignInConfig.zzlQ(), false);
        zzb.zza(parcel, 4, (Parcelable) emailSignInConfig.zzlP(), i, false);
        zzb.zzI(parcel, zzaq);
    }

    /* renamed from: zzO */
    public EmailSignInConfig createFromParcel(Parcel parcel) {
        Uri uri;
        String str;
        Uri uri2;
        int i;
        Uri uri3 = null;
        int zzap = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        int i2 = 0;
        String str2 = null;
        Uri uri4 = null;
        while (parcel.dataPosition() < zzap) {
            int zzao = com.google.android.gms.common.internal.safeparcel.zza.zzao(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbM(zzao)) {
                case 1:
                    Uri uri5 = uri3;
                    str = str2;
                    uri2 = uri4;
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzao);
                    uri = uri5;
                    break;
                case 2:
                    i = i2;
                    String str3 = str2;
                    uri2 = (Uri) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzao, Uri.CREATOR);
                    uri = uri3;
                    str = str3;
                    break;
                case 3:
                    uri2 = uri4;
                    i = i2;
                    Uri uri6 = uri3;
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzao);
                    uri = uri6;
                    break;
                case 4:
                    uri = (Uri) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzao, Uri.CREATOR);
                    str = str2;
                    uri2 = uri4;
                    i = i2;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzao);
                    uri = uri3;
                    str = str2;
                    uri2 = uri4;
                    i = i2;
                    break;
            }
            i2 = i;
            uri4 = uri2;
            str2 = str;
            uri3 = uri;
        }
        if (parcel.dataPosition() == zzap) {
            return new EmailSignInConfig(i2, uri4, str2, uri3);
        }
        throw new C0524zza("Overread allowed size end=" + zzap, parcel);
    }

    /* renamed from: zzaF */
    public EmailSignInConfig[] newArray(int i) {
        return new EmailSignInConfig[i];
    }
}
