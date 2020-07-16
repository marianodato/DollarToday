package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class BinderWrapper implements Parcelable {
    public static final Creator<BinderWrapper> CREATOR = new Creator<BinderWrapper>() {
        /* renamed from: zzaj */
        public BinderWrapper createFromParcel(Parcel parcel) {
            return new BinderWrapper(parcel);
        }

        /* renamed from: zzbC */
        public BinderWrapper[] newArray(int i) {
            return new BinderWrapper[i];
        }
    };
    private IBinder zzaeJ;

    public BinderWrapper() {
        this.zzaeJ = null;
    }

    public BinderWrapper(IBinder binder) {
        this.zzaeJ = null;
        this.zzaeJ = binder;
    }

    private BinderWrapper(Parcel in) {
        this.zzaeJ = null;
        this.zzaeJ = in.readStrongBinder();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStrongBinder(this.zzaeJ);
    }
}
