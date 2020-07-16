package com.google.android.gms.appdatasearch;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class Feature implements SafeParcelable {
    public static final zze CREATOR = new zze();

    /* renamed from: id */
    public final int f17id;
    final int mVersionCode;
    final Bundle zzQn;

    Feature(int versionCode, int id, Bundle parameters) {
        this.mVersionCode = versionCode;
        this.f17id = id;
        this.zzQn = parameters;
    }

    public int describeContents() {
        zze zze = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zze zze = CREATOR;
        zze.zza(this, dest, flags);
    }
}
