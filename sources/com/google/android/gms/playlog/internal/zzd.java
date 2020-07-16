package com.google.android.gms.playlog.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.zzqd.zza;

public class zzd implements ConnectionCallbacks, OnConnectionFailedListener {
    private zzf zzaRE = null;
    private final zza zzaRP;
    private boolean zzaRQ = true;

    public zzd(zza zza) {
        this.zzaRP = zza;
    }

    public void onConnected(Bundle connectionHint) {
        this.zzaRE.zzap(false);
        if (this.zzaRQ && this.zzaRP != null) {
            this.zzaRP.zzBr();
        }
        this.zzaRQ = false;
    }

    public void onConnectionFailed(ConnectionResult result) {
        this.zzaRE.zzap(true);
        if (this.zzaRQ && this.zzaRP != null) {
            if (result.hasResolution()) {
                this.zzaRP.zzf(result.getResolution());
            } else {
                this.zzaRP.zzBs();
            }
        }
        this.zzaRQ = false;
    }

    public void onConnectionSuspended(int cause) {
        this.zzaRE.zzap(true);
    }

    public void zza(zzf zzf) {
        this.zzaRE = zzf;
    }

    public void zzao(boolean z) {
        this.zzaRQ = z;
    }
}
