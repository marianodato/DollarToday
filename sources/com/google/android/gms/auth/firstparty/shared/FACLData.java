package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class FACLData implements SafeParcelable {
    public static final zzb CREATOR = new zzb();
    final int version;
    FACLConfig zzTD;
    String zzTE;
    boolean zzTF;
    String zzTG;

    FACLData(int version2, FACLConfig faclConfig, String activityText, boolean isSpeedbumpNeeded, String speedbumpText) {
        this.version = version2;
        this.zzTD = faclConfig;
        this.zzTE = activityText;
        this.zzTF = isSpeedbumpNeeded;
        this.zzTG = speedbumpText;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzb.zza(this, dest, flags);
    }
}
