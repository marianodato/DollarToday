package com.google.android.gms.auth.api.proxy;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ProxyGrpcRequest implements SafeParcelable {
    public static final Creator<ProxyGrpcRequest> CREATOR = new zza();
    public final byte[] body;
    public final String hostname;
    public final String method;
    public final int port;
    public final long timeoutMillis;
    final int versionCode;

    ProxyGrpcRequest(int version, String hostname2, int port2, long timeoutMillis2, byte[] body2, String method2) {
        this.versionCode = version;
        this.hostname = hostname2;
        this.port = port2;
        this.timeoutMillis = timeoutMillis2;
        this.body = body2;
        this.method = method2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zza.zza(this, parcel, flags);
    }
}
