package com.google.android.gms.auth.api.proxy;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ProxyResponse implements SafeParcelable {
    public static final Creator<ProxyResponse> CREATOR = new zzc();
    public static final int STATUS_CODE_NO_CONNECTION = -1;
    public final byte[] body;
    public final int googlePlayServicesStatusCode;
    public final PendingIntent recoveryAction;
    public final int statusCode;
    final int versionCode;
    final Bundle zzSK;

    ProxyResponse(int version, int googlePlayServicesStatusCode2, PendingIntent recoveryAction2, int statusCode2, Bundle headers, byte[] body2) {
        this.versionCode = version;
        this.googlePlayServicesStatusCode = googlePlayServicesStatusCode2;
        this.statusCode = statusCode2;
        this.zzSK = headers;
        this.body = body2;
        this.recoveryAction = recoveryAction2;
    }

    public ProxyResponse(int googlePlayServicesStatusCode2, PendingIntent recoveryAction2, int statusCode2, Bundle headers, byte[] body2) {
        this(1, googlePlayServicesStatusCode2, recoveryAction2, statusCode2, headers, body2);
    }

    private ProxyResponse(int responseCode, Bundle headers, byte[] body2) {
        this(1, 0, null, responseCode, headers, body2);
    }

    public ProxyResponse(int responseCode, Map<String, String> headers, byte[] body2) {
        this(responseCode, zzE(headers), body2);
    }

    public static ProxyResponse createErrorProxyResponse(int googlePlayServicesStatusCode2, PendingIntent recoveryAction2, int statusCode2, Map<String, String> headers, byte[] body2) {
        return new ProxyResponse(1, googlePlayServicesStatusCode2, recoveryAction2, statusCode2, zzE(headers), body2);
    }

    private static Bundle zzE(Map<String, String> map) {
        Bundle bundle = new Bundle();
        if (map == null) {
            return bundle;
        }
        for (Entry entry : map.entrySet()) {
            bundle.putString((String) entry.getKey(), (String) entry.getValue());
        }
        return bundle;
    }

    public int describeContents() {
        return 0;
    }

    public Map<String, String> getHeaders() {
        HashMap hashMap = new HashMap();
        for (String str : this.zzSK.keySet()) {
            hashMap.put(str, this.zzSK.getString(str));
        }
        return hashMap;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzc.zza(this, parcel, flags);
    }
}
