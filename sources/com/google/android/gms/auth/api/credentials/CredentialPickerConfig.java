package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class CredentialPickerConfig implements SafeParcelable {
    public static final Creator<CredentialPickerConfig> CREATOR = new zzb();
    private final boolean mShowCancelButton;
    final int mVersionCode;
    private final boolean zzSn;

    public static class Builder {
        /* access modifiers changed from: private */
        public boolean mShowCancelButton = true;
        /* access modifiers changed from: private */
        public boolean zzSn = false;

        public CredentialPickerConfig build() {
            return new CredentialPickerConfig(this);
        }

        public Builder setShowAddAccountButton(boolean showAddAccountButton) {
            this.zzSn = showAddAccountButton;
            return this;
        }

        public Builder setShowCancelButton(boolean showCancelButton) {
            this.mShowCancelButton = showCancelButton;
            return this;
        }
    }

    CredentialPickerConfig(int version, boolean showAddAccountButton, boolean showCancelButton) {
        this.mVersionCode = version;
        this.zzSn = showAddAccountButton;
        this.mShowCancelButton = showCancelButton;
    }

    private CredentialPickerConfig(Builder builder) {
        this(1, builder.zzSn, builder.mShowCancelButton);
    }

    public int describeContents() {
        return 0;
    }

    public boolean shouldShowAddAccountButton() {
        return this.zzSn;
    }

    public boolean shouldShowCancelButton() {
        return this.mShowCancelButton;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzb.zza(this, out, flags);
    }
}
