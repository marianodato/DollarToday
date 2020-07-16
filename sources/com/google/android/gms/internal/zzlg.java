package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.signin.internal.AuthAccountResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

public class zzlg implements zzlj {
    /* access modifiers changed from: private */
    public final Context mContext;
    /* access modifiers changed from: private */
    public final GoogleApiAvailability zzaaP;
    private final com.google.android.gms.common.api.Api.zza<? extends zzqw, zzqx> zzaaQ;
    private final Set<com.google.android.gms.common.api.Api.zzc> zzabA = new HashSet();
    /* access modifiers changed from: private */
    public zzqw zzabB;
    private int zzabC;
    /* access modifiers changed from: private */
    public boolean zzabD;
    private boolean zzabE;
    /* access modifiers changed from: private */
    public zzp zzabF;
    private boolean zzabG;
    private boolean zzabH;
    private final com.google.android.gms.common.internal.zzf zzabI;
    private final Map<Api<?>, Integer> zzabJ;
    private ArrayList<Future<?>> zzabK = new ArrayList<>();
    /* access modifiers changed from: private */
    public final zzli zzabr;
    /* access modifiers changed from: private */
    public final Lock zzabt;
    private ConnectionResult zzabu;
    private int zzabv;
    private int zzabw = 0;
    private boolean zzabx = false;
    private int zzaby;
    private final Bundle zzabz = new Bundle();

    private static class zza extends com.google.android.gms.signin.internal.zzb {
        private final WeakReference<zzlg> zzabM;

        zza(zzlg zzlg) {
            this.zzabM = new WeakReference<>(zzlg);
        }

        public void zza(final ConnectionResult connectionResult, AuthAccountResult authAccountResult) {
            final zzlg zzlg = (zzlg) this.zzabM.get();
            if (zzlg != null) {
                zzlg.zzabr.zza((zzb) new zzb(zzlg) {
                    public void zznO() {
                        zzlg.zzc(connectionResult);
                    }
                });
            }
        }
    }

    private static class zzb extends com.google.android.gms.common.internal.zzt.zza {
        private final WeakReference<zzlg> zzabM;

        zzb(zzlg zzlg) {
            this.zzabM = new WeakReference<>(zzlg);
        }

        public void zzb(final ResolveAccountResponse resolveAccountResponse) {
            final zzlg zzlg = (zzlg) this.zzabM.get();
            if (zzlg != null) {
                zzlg.zzabr.zza((zzb) new zzb(zzlg) {
                    public void zznO() {
                        zzlg.zza(resolveAccountResponse);
                    }
                });
            }
        }
    }

    private class zzc extends zzi {
        private zzc() {
            super();
        }

        public void zznO() {
            zzlg.this.zzabB.zza(zzlg.this.zzabF, zzlg.this.zzabr.zzaci, new zza(zzlg.this));
        }
    }

    private static class zzd implements com.google.android.gms.common.api.GoogleApiClient.zza {
        private final WeakReference<zzlg> zzabM;
        private final Api<?> zzabS;
        private final int zzabT;

        public zzd(zzlg zzlg, Api<?> api, int i) {
            this.zzabM = new WeakReference<>(zzlg);
            this.zzabS = api;
            this.zzabT = i;
        }

        public void zza(ConnectionResult connectionResult) {
            boolean z = false;
            zzlg zzlg = (zzlg) this.zzabM.get();
            if (zzlg != null) {
                if (Looper.myLooper() == zzlg.zzabr.getLooper()) {
                    z = true;
                }
                zzx.zza(z, (Object) "onReportServiceBinding must be called on the GoogleApiClient handler thread");
                zzlg.zzabt.lock();
                try {
                    if (zzlg.zzbn(0)) {
                        if (!connectionResult.isSuccess()) {
                            zzlg.zzb(connectionResult, this.zzabS, this.zzabT);
                        }
                        if (zzlg.zznP()) {
                            zzlg.zznQ();
                        }
                        zzlg.zzabt.unlock();
                    }
                } finally {
                    zzlg.zzabt.unlock();
                }
            }
        }

        public void zzb(ConnectionResult connectionResult) {
            boolean z = true;
            zzlg zzlg = (zzlg) this.zzabM.get();
            if (zzlg != null) {
                if (Looper.myLooper() != zzlg.zzabr.getLooper()) {
                    z = false;
                }
                zzx.zza(z, (Object) "onReportAccountValidation must be called on the GoogleApiClient handler thread");
                zzlg.zzabt.lock();
                try {
                    if (zzlg.zzbn(1)) {
                        if (!connectionResult.isSuccess()) {
                            zzlg.zzb(connectionResult, this.zzabS, this.zzabT);
                        }
                        if (zzlg.zznP()) {
                            zzlg.zznS();
                        }
                        zzlg.zzabt.unlock();
                    }
                } finally {
                    zzlg.zzabt.unlock();
                }
            }
        }
    }

    private class zze extends zzi {
        private final Map<com.google.android.gms.common.api.Api.zzb, com.google.android.gms.common.api.GoogleApiClient.zza> zzabU;

        public zze(Map<com.google.android.gms.common.api.Api.zzb, com.google.android.gms.common.api.GoogleApiClient.zza> map) {
            super();
            this.zzabU = map;
        }

        public void zznO() {
            int isGooglePlayServicesAvailable = zzlg.this.zzaaP.isGooglePlayServicesAvailable(zzlg.this.mContext);
            if (isGooglePlayServicesAvailable != 0) {
                final ConnectionResult connectionResult = new ConnectionResult(isGooglePlayServicesAvailable, null);
                zzlg.this.zzabr.zza((zzb) new zzb(zzlg.this) {
                    public void zznO() {
                        zzlg.this.zzf(connectionResult);
                    }
                });
                return;
            }
            if (zzlg.this.zzabD) {
                zzlg.this.zzabB.connect();
            }
            for (com.google.android.gms.common.api.Api.zzb zzb : this.zzabU.keySet()) {
                zzb.zza((com.google.android.gms.common.api.GoogleApiClient.zza) this.zzabU.get(zzb));
            }
        }
    }

    private class zzf extends zzi {
        private final ArrayList<com.google.android.gms.common.api.Api.zzb> zzabX;

        public zzf(ArrayList<com.google.android.gms.common.api.Api.zzb> arrayList) {
            super();
            this.zzabX = arrayList;
        }

        public void zznO() {
            Set<Scope> set = zzlg.this.zzabr.zzaci;
            Set<Scope> set2 = set.isEmpty() ? zzlg.this.zznX() : set;
            Iterator it = this.zzabX.iterator();
            while (it.hasNext()) {
                ((com.google.android.gms.common.api.Api.zzb) it.next()).zza(zzlg.this.zzabF, set2);
            }
        }
    }

    private class zzg implements ConnectionCallbacks, OnConnectionFailedListener {
        private zzg() {
        }

        public void onConnected(Bundle connectionHint) {
            zzlg.this.zzabB.zza(new zzb(zzlg.this));
        }

        public void onConnectionFailed(ConnectionResult result) {
            zzlg.this.zzabt.lock();
            try {
                if (zzlg.this.zze(result)) {
                    zzlg.this.zznV();
                    zzlg.this.zznT();
                } else {
                    zzlg.this.zzf(result);
                }
            } finally {
                zzlg.this.zzabt.unlock();
            }
        }

        public void onConnectionSuspended(int cause) {
        }
    }

    private class zzh extends zzi {
        private final ArrayList<com.google.android.gms.common.api.Api.zzb> zzabX;

        public zzh(ArrayList<com.google.android.gms.common.api.Api.zzb> arrayList) {
            super();
            this.zzabX = arrayList;
        }

        public void zznO() {
            Iterator it = this.zzabX.iterator();
            while (it.hasNext()) {
                ((com.google.android.gms.common.api.Api.zzb) it.next()).zza(zzlg.this.zzabF);
            }
        }
    }

    private abstract class zzi implements Runnable {
        private zzi() {
        }

        public void run() {
            zzlg.this.zzabt.lock();
            try {
                if (!Thread.interrupted()) {
                    zznO();
                    zzlg.this.zzabt.unlock();
                }
            } catch (RuntimeException e) {
                zzlg.this.zzabr.zza(e);
            } finally {
                zzlg.this.zzabt.unlock();
            }
        }

        /* access modifiers changed from: protected */
        public abstract void zznO();
    }

    public zzlg(zzli zzli, com.google.android.gms.common.internal.zzf zzf2, Map<Api<?>, Integer> map, GoogleApiAvailability googleApiAvailability, com.google.android.gms.common.api.Api.zza<? extends zzqw, zzqx> zza2, Lock lock, Context context) {
        this.zzabr = zzli;
        this.zzabI = zzf2;
        this.zzabJ = map;
        this.zzaaP = googleApiAvailability;
        this.zzaaQ = zza2;
        this.zzabt = lock;
        this.mContext = context;
    }

    private void zzY(boolean z) {
        if (this.zzabB != null) {
            if (this.zzabB.isConnected() && z) {
                this.zzabB.zzCe();
            }
            this.zzabB.disconnect();
            this.zzabF = null;
        }
    }

    /* access modifiers changed from: private */
    public void zza(ResolveAccountResponse resolveAccountResponse) {
        if (zzbn(0)) {
            ConnectionResult zzpr = resolveAccountResponse.zzpr();
            if (zzpr.isSuccess()) {
                this.zzabF = resolveAccountResponse.zzpq();
                this.zzabE = true;
                this.zzabG = resolveAccountResponse.zzps();
                this.zzabH = resolveAccountResponse.zzpt();
                zznQ();
            } else if (zze(zzpr)) {
                zznV();
                zznQ();
            } else {
                zzf(zzpr);
            }
        }
    }

    private boolean zza(int i, int i2, ConnectionResult connectionResult) {
        if (i2 != 1 || zzd(connectionResult)) {
            return this.zzabu == null || i < this.zzabv;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void zzb(ConnectionResult connectionResult, Api<?> api, int i) {
        if (i != 2) {
            int priority = api.zznv().getPriority();
            if (zza(priority, i, connectionResult)) {
                this.zzabu = connectionResult;
                this.zzabv = priority;
            }
        }
        this.zzabr.zzach.put(api.zznx(), connectionResult);
    }

    /* access modifiers changed from: private */
    public boolean zzbn(int i) {
        if (this.zzabw == i) {
            return true;
        }
        Log.i("GoogleApiClientConnecting", this.zzabr.zzog());
        Log.wtf("GoogleApiClientConnecting", "GoogleApiClient connecting is in step " + zzbo(this.zzabw) + " but received callback for step " + zzbo(i), new Exception());
        zzf(new ConnectionResult(8, null));
        return false;
    }

    private String zzbo(int i) {
        switch (i) {
            case 0:
                return "STEP_GETTING_SERVICE_BINDINGS";
            case 1:
                return "STEP_VALIDATING_ACCOUNT";
            case 2:
                return "STEP_AUTHENTICATING";
            case 3:
                return "STEP_GETTING_REMOTE_SERVICE";
            default:
                return "UNKNOWN";
        }
    }

    /* access modifiers changed from: private */
    public void zzc(ConnectionResult connectionResult) {
        if (zzbn(2)) {
            if (connectionResult.isSuccess()) {
                zznT();
            } else if (zze(connectionResult)) {
                zznV();
                zznT();
            } else {
                zzf(connectionResult);
            }
        }
    }

    private boolean zzd(ConnectionResult connectionResult) {
        return connectionResult.hasResolution() || this.zzaaP.zzbi(connectionResult.getErrorCode()) != null;
    }

    /* access modifiers changed from: private */
    public boolean zze(ConnectionResult connectionResult) {
        if (this.zzabC != 2) {
            return this.zzabC == 1 && !connectionResult.hasResolution();
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void zzf(ConnectionResult connectionResult) {
        zznW();
        zzY(!connectionResult.hasResolution());
        this.zzabr.zzach.clear();
        this.zzabr.zzg(connectionResult);
        if (!this.zzaaP.zzd(this.mContext, connectionResult.getErrorCode())) {
            this.zzabr.zzof();
        }
        if (!this.zzabx && !this.zzabr.zzoc()) {
            this.zzabr.zzabZ.zzi(connectionResult);
        }
        this.zzabx = false;
        this.zzabr.zzabZ.zzpk();
    }

    /* access modifiers changed from: private */
    public boolean zznP() {
        this.zzaby--;
        if (this.zzaby > 0) {
            return false;
        }
        if (this.zzaby < 0) {
            Log.i("GoogleApiClientConnecting", this.zzabr.zzog());
            Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            zzf(new ConnectionResult(8, null));
            return false;
        } else if (this.zzabu == null) {
            return true;
        } else {
            zzf(this.zzabu);
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void zznQ() {
        if (this.zzaby == 0) {
            if (!this.zzabD) {
                zznT();
            } else if (this.zzabE) {
                zznR();
            }
        }
    }

    private void zznR() {
        ArrayList arrayList = new ArrayList();
        this.zzabw = 1;
        this.zzaby = this.zzabr.zzacg.size();
        for (com.google.android.gms.common.api.Api.zzc zzc2 : this.zzabr.zzacg.keySet()) {
            if (!this.zzabr.zzach.containsKey(zzc2)) {
                arrayList.add(this.zzabr.zzacg.get(zzc2));
            } else if (zznP()) {
                zznS();
            }
        }
        if (!arrayList.isEmpty()) {
            this.zzabK.add(zzlk.zzoj().submit(new zzh(arrayList)));
        }
    }

    /* access modifiers changed from: private */
    public void zznS() {
        this.zzabw = 2;
        this.zzabr.zzaci = zznX();
        this.zzabK.add(zzlk.zzoj().submit(new zzc()));
    }

    /* access modifiers changed from: private */
    public void zznT() {
        ArrayList arrayList = new ArrayList();
        this.zzabw = 3;
        this.zzaby = this.zzabr.zzacg.size();
        for (com.google.android.gms.common.api.Api.zzc zzc2 : this.zzabr.zzacg.keySet()) {
            if (!this.zzabr.zzach.containsKey(zzc2)) {
                arrayList.add(this.zzabr.zzacg.get(zzc2));
            } else if (zznP()) {
                zznU();
            }
        }
        if (!arrayList.isEmpty()) {
            this.zzabK.add(zzlk.zzoj().submit(new zzf(arrayList)));
        }
    }

    private void zznU() {
        this.zzabr.zzob();
        zzlk.zzoj().execute(new Runnable() {
            public void run() {
                zzlg.this.zzaaP.zzac(zzlg.this.mContext);
            }
        });
        if (this.zzabB != null) {
            if (this.zzabG) {
                this.zzabB.zza(this.zzabF, this.zzabH);
            }
            zzY(false);
        }
        for (com.google.android.gms.common.api.Api.zzc zzc2 : this.zzabr.zzach.keySet()) {
            ((com.google.android.gms.common.api.Api.zzb) this.zzabr.zzacg.get(zzc2)).disconnect();
        }
        if (this.zzabx) {
            this.zzabx = false;
            disconnect();
            return;
        }
        this.zzabr.zzabZ.zzh(this.zzabz.isEmpty() ? null : this.zzabz);
    }

    /* access modifiers changed from: private */
    public void zznV() {
        this.zzabD = false;
        this.zzabr.zzaci = Collections.emptySet();
        for (com.google.android.gms.common.api.Api.zzc zzc2 : this.zzabA) {
            if (!this.zzabr.zzach.containsKey(zzc2)) {
                this.zzabr.zzach.put(zzc2, new ConnectionResult(17, null));
            }
        }
    }

    private void zznW() {
        Iterator it = this.zzabK.iterator();
        while (it.hasNext()) {
            ((Future) it.next()).cancel(true);
        }
        this.zzabK.clear();
    }

    /* access modifiers changed from: private */
    public Set<Scope> zznX() {
        HashSet hashSet = new HashSet(this.zzabI.zzoK());
        Map zzoM = this.zzabI.zzoM();
        for (Api api : zzoM.keySet()) {
            if (!this.zzabr.zzach.containsKey(api.zznx())) {
                hashSet.addAll(((com.google.android.gms.common.internal.zzf.zza) zzoM.get(api)).zzTm);
            }
        }
        return hashSet;
    }

    public void begin() {
        this.zzabr.zzabZ.zzpl();
        this.zzabr.zzach.clear();
        this.zzabx = false;
        this.zzabD = false;
        this.zzabu = null;
        this.zzabw = 0;
        this.zzabC = 2;
        this.zzabE = false;
        this.zzabG = false;
        HashMap hashMap = new HashMap();
        boolean z = false;
        for (Api api : this.zzabJ.keySet()) {
            com.google.android.gms.common.api.Api.zzb zzb2 = (com.google.android.gms.common.api.Api.zzb) this.zzabr.zzacg.get(api.zznx());
            int intValue = ((Integer) this.zzabJ.get(api)).intValue();
            boolean z2 = (api.zznv().getPriority() == 1) | z;
            if (zzb2.zzlN()) {
                this.zzabD = true;
                if (intValue < this.zzabC) {
                    this.zzabC = intValue;
                }
                if (intValue != 0) {
                    this.zzabA.add(api.zznx());
                }
            }
            hashMap.put(zzb2, new zzd(this, api, intValue));
            z = z2;
        }
        if (z) {
            this.zzabD = false;
        }
        if (this.zzabD) {
            this.zzabI.zza(Integer.valueOf(this.zzabr.getSessionId()));
            zzg zzg2 = new zzg();
            this.zzabB = (zzqw) this.zzaaQ.zza(this.mContext, this.zzabr.getLooper(), this.zzabI, this.zzabI.zzoQ(), zzg2, zzg2);
        }
        this.zzaby = this.zzabr.zzacg.size();
        this.zzabK.add(zzlk.zzoj().submit(new zze(hashMap)));
    }

    public void connect() {
        this.zzabx = false;
    }

    public void disconnect() {
        Iterator it = this.zzabr.zzaca.iterator();
        while (it.hasNext()) {
            zzf zzf2 = (zzf) it.next();
            if (zzf2.zznK() != 1) {
                zzf2.cancel();
                it.remove();
            }
        }
        this.zzabr.zznY();
        if (this.zzabu != null || this.zzabr.zzaca.isEmpty()) {
            zznW();
            zzY(true);
            this.zzabr.zzach.clear();
            this.zzabr.zzg(null);
            this.zzabr.zzabZ.zzpk();
            return;
        }
        this.zzabx = true;
    }

    public String getName() {
        return "CONNECTING";
    }

    public void onConnected(Bundle connectionHint) {
        if (zzbn(3)) {
            if (connectionHint != null) {
                this.zzabz.putAll(connectionHint);
            }
            if (zznP()) {
                zznU();
            }
        }
    }

    public void onConnectionSuspended(int cause) {
        zzf(new ConnectionResult(8, null));
    }

    public <A extends com.google.android.gms.common.api.Api.zzb, R extends Result, T extends com.google.android.gms.internal.zzlb.zza<R, A>> T zza(T t) {
        this.zzabr.zzaca.add(t);
        return t;
    }

    public void zza(ConnectionResult connectionResult, Api<?> api, int i) {
        if (zzbn(3)) {
            zzb(connectionResult, api, i);
            if (zznP()) {
                zznU();
            }
        }
    }

    public <A extends com.google.android.gms.common.api.Api.zzb, T extends com.google.android.gms.internal.zzlb.zza<? extends Result, A>> T zzb(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }
}
