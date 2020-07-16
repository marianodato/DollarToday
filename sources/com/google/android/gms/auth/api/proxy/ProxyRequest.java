package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Patterns;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class ProxyRequest implements SafeParcelable {
    public static final Creator<ProxyRequest> CREATOR = new zzb();
    public static final int HTTP_METHOD_DELETE = 3;
    public static final int HTTP_METHOD_GET = 0;
    public static final int HTTP_METHOD_HEAD = 4;
    public static final int HTTP_METHOD_OPTIONS = 5;
    public static final int HTTP_METHOD_PATCH = 7;
    public static final int HTTP_METHOD_POST = 1;
    public static final int HTTP_METHOD_PUT = 2;
    public static final int HTTP_METHOD_TRACE = 6;
    public static final int LAST_CODE = 7;
    public static final int VERSION_CODE = 2;
    public final byte[] body;
    public final int httpMethod;
    public final long timeoutMillis;
    public final String url;
    final int versionCode;
    Bundle zzSK;

    public static class Builder {
        private String zzSL;
        private int zzSM = ProxyRequest.HTTP_METHOD_GET;
        private long zzSN = 3000;
        private byte[] zzSO = null;
        private Bundle zzSP = new Bundle();

        public Builder(String url) {
            zzx.zzcr(url);
            if (Patterns.WEB_URL.matcher(url).matches()) {
                this.zzSL = url;
                return;
            }
            throw new IllegalArgumentException("The supplied url [ " + url + "] is not match Patterns.WEB_URL!");
        }

        public ProxyRequest build() {
            if (this.zzSO == null) {
                this.zzSO = new byte[0];
            }
            return new ProxyRequest(2, this.zzSL, this.zzSM, this.zzSN, this.zzSO, this.zzSP);
        }

        public Builder putHeader(String name, String value) {
            zzx.zzh(name, "Header name cannot be null or empty!");
            Bundle bundle = this.zzSP;
            if (value == null) {
                value = "";
            }
            bundle.putString(name, value);
            return this;
        }

        public Builder setBody(byte[] body) {
            this.zzSO = body;
            return this;
        }

        public Builder setHttpMethod(int method) {
            zzx.zzb(method >= 0 && method <= ProxyRequest.LAST_CODE, (Object) "Unrecognized http method code.");
            this.zzSM = method;
            return this;
        }

        public Builder setTimeoutMillis(long timeoutMillis) {
            zzx.zzb(timeoutMillis >= 0, (Object) "The specified timeout must be non-negative.");
            this.zzSN = timeoutMillis;
            return this;
        }
    }

    ProxyRequest(int version, String googleUrl, int httpMethod2, long timeoutMillis2, byte[] body2, Bundle headers) {
        this.versionCode = version;
        this.url = googleUrl;
        this.httpMethod = httpMethod2;
        this.timeoutMillis = timeoutMillis2;
        this.body = body2;
        this.zzSK = headers;
    }

    public int describeContents() {
        return 0;
    }

    public Map<String, String> getHeaderMap() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.zzSK.size());
        for (String str : this.zzSK.keySet()) {
            linkedHashMap.put(str, this.zzSK.getString(str));
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    public String toString() {
        return "ProxyRequest[ url: " + this.url + ", method: " + this.httpMethod + " ]";
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzb.zza(this, parcel, flags);
    }
}
