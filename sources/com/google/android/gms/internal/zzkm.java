package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.proxy.ProxyApi.ProxyResult;
import com.google.android.gms.auth.api.proxy.ProxyRequest;
import com.google.android.gms.auth.api.proxy.ProxyResponse;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.zzx;

public class zzkm implements ProxyApi {
    public PendingResult<ProxyResult> performProxyRequest(GoogleApiClient client, final ProxyRequest request) {
        zzx.zzw(client);
        zzx.zzw(request);
        return client.zzb(new zzkl(client) {
            /* access modifiers changed from: protected */
            public void zza(Context context, zzkk zzkk) throws RemoteException {
                zzkk.zza((zzkj) new zzkh() {
                    public void zza(ProxyResponse proxyResponse) {
                        C04811.this.zzb(new zzkn(proxyResponse));
                    }
                }, request);
            }
        });
    }
}
