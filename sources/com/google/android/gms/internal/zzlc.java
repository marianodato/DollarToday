package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class zzlc<R extends Result> extends PendingResult<R> {
    private boolean zzL;
    private volatile R zzaaX;
    private final Object zzabh = new Object();
    protected final zza<R> zzabi;
    private final ArrayList<com.google.android.gms.common.api.PendingResult.zza> zzabj = new ArrayList<>();
    private ResultCallback<? super R> zzabk;
    private volatile boolean zzabl;
    private boolean zzabm;
    private zzq zzabn;
    private Integer zzabo;
    private volatile zzlq<R> zzabp;
    private final CountDownLatch zzoS = new CountDownLatch(1);

    public static class zza<R extends Result> extends Handler {
        public zza() {
            this(Looper.getMainLooper());
        }

        public zza(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    Pair pair = (Pair) msg.obj;
                    zzb((ResultCallback) pair.first, (Result) pair.second);
                    return;
                case 2:
                    ((zzlc) msg.obj).zzw(Status.zzabe);
                    return;
                default:
                    Log.wtf("BasePendingResult", "Don't know how to handle message: " + msg.what, new Exception());
                    return;
            }
        }

        public void zza(ResultCallback<? super R> resultCallback, R r) {
            sendMessage(obtainMessage(1, new Pair(resultCallback, r)));
        }

        public void zza(zzlc<R> zzlc, long j) {
            sendMessageDelayed(obtainMessage(2, zzlc), j);
        }

        /* access modifiers changed from: protected */
        public void zzb(ResultCallback<? super R> resultCallback, R r) {
            try {
                resultCallback.onResult(r);
            } catch (RuntimeException e) {
                zzlc.zzd(r);
                throw e;
            }
        }

        public void zznM() {
            removeMessages(2);
        }
    }

    @Deprecated
    protected zzlc(Looper looper) {
        this.zzabi = new zza<>(looper);
    }

    protected zzlc(GoogleApiClient googleApiClient) {
        this.zzabi = new zza<>(googleApiClient != null ? googleApiClient.getLooper() : Looper.getMainLooper());
    }

    private R get() {
        R r;
        boolean z = true;
        synchronized (this.zzabh) {
            if (this.zzabl) {
                z = false;
            }
            zzx.zza(z, (Object) "Result has already been consumed.");
            zzx.zza(isReady(), (Object) "Result is not ready.");
            r = this.zzaaX;
            this.zzaaX = null;
            this.zzabk = null;
            this.zzabl = true;
        }
        zznL();
        return r;
    }

    private void zzc(R r) {
        this.zzaaX = r;
        this.zzabn = null;
        this.zzoS.countDown();
        Status status = this.zzaaX.getStatus();
        if (this.zzabk != null) {
            this.zzabi.zznM();
            if (!this.zzL) {
                this.zzabi.zza(this.zzabk, get());
            }
        }
        Iterator it = this.zzabj.iterator();
        while (it.hasNext()) {
            ((com.google.android.gms.common.api.PendingResult.zza) it.next()).zzt(status);
        }
        this.zzabj.clear();
    }

    public static void zzd(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException e) {
                Log.w("BasePendingResult", "Unable to release " + result, e);
            }
        }
    }

    public final R await() {
        boolean z = true;
        zzx.zza(Looper.myLooper() != Looper.getMainLooper(), (Object) "await must not be called on the UI thread");
        zzx.zza(!this.zzabl, (Object) "Result has already been consumed");
        if (this.zzabp != null) {
            z = false;
        }
        zzx.zza(z, (Object) "Cannot await if then() has been called.");
        try {
            this.zzoS.await();
        } catch (InterruptedException e) {
            zzw(Status.zzabc);
        }
        zzx.zza(isReady(), (Object) "Result is not ready.");
        return get();
    }

    public final R await(long time, TimeUnit units) {
        boolean z = true;
        zzx.zza(time <= 0 || Looper.myLooper() != Looper.getMainLooper(), (Object) "await must not be called on the UI thread when time is greater than zero.");
        zzx.zza(!this.zzabl, (Object) "Result has already been consumed.");
        if (this.zzabp != null) {
            z = false;
        }
        zzx.zza(z, (Object) "Cannot await if then() has been called.");
        try {
            if (!this.zzoS.await(time, units)) {
                zzw(Status.zzabe);
            }
        } catch (InterruptedException e) {
            zzw(Status.zzabc);
        }
        zzx.zza(isReady(), (Object) "Result is not ready.");
        return get();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void cancel() {
        /*
            r2 = this;
            java.lang.Object r1 = r2.zzabh
            monitor-enter(r1)
            boolean r0 = r2.zzL     // Catch:{ all -> 0x002c }
            if (r0 != 0) goto L_0x000b
            boolean r0 = r2.zzabl     // Catch:{ all -> 0x002c }
            if (r0 == 0) goto L_0x000d
        L_0x000b:
            monitor-exit(r1)     // Catch:{ all -> 0x002c }
        L_0x000c:
            return
        L_0x000d:
            com.google.android.gms.common.internal.zzq r0 = r2.zzabn     // Catch:{ all -> 0x002c }
            if (r0 == 0) goto L_0x0016
            com.google.android.gms.common.internal.zzq r0 = r2.zzabn     // Catch:{ RemoteException -> 0x002f }
            r0.cancel()     // Catch:{ RemoteException -> 0x002f }
        L_0x0016:
            R r0 = r2.zzaaX     // Catch:{ all -> 0x002c }
            zzd(r0)     // Catch:{ all -> 0x002c }
            r0 = 0
            r2.zzabk = r0     // Catch:{ all -> 0x002c }
            r0 = 1
            r2.zzL = r0     // Catch:{ all -> 0x002c }
            com.google.android.gms.common.api.Status r0 = com.google.android.gms.common.api.Status.zzabf     // Catch:{ all -> 0x002c }
            com.google.android.gms.common.api.Result r0 = r2.zzb(r0)     // Catch:{ all -> 0x002c }
            r2.zzc(r0)     // Catch:{ all -> 0x002c }
            monitor-exit(r1)     // Catch:{ all -> 0x002c }
            goto L_0x000c
        L_0x002c:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x002c }
            throw r0
        L_0x002f:
            r0 = move-exception
            goto L_0x0016
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzlc.cancel():void");
    }

    public boolean isCanceled() {
        boolean z;
        synchronized (this.zzabh) {
            z = this.zzL;
        }
        return z;
    }

    public final boolean isReady() {
        return this.zzoS.getCount() == 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setResultCallback(com.google.android.gms.common.api.ResultCallback<? super R> r5) {
        /*
            r4 = this;
            r1 = 1
            r2 = 0
            boolean r0 = r4.zzabl
            if (r0 != 0) goto L_0x0020
            r0 = r1
        L_0x0007:
            java.lang.String r3 = "Result has already been consumed."
            com.google.android.gms.common.internal.zzx.zza(r0, r3)
            java.lang.Object r3 = r4.zzabh
            monitor-enter(r3)
            com.google.android.gms.internal.zzlq<R> r0 = r4.zzabp     // Catch:{ all -> 0x0035 }
            if (r0 != 0) goto L_0x0022
        L_0x0013:
            java.lang.String r0 = "Cannot set callbacks if then() has been called."
            com.google.android.gms.common.internal.zzx.zza(r1, r0)     // Catch:{ all -> 0x0035 }
            boolean r0 = r4.isCanceled()     // Catch:{ all -> 0x0035 }
            if (r0 == 0) goto L_0x0024
            monitor-exit(r3)     // Catch:{ all -> 0x0035 }
        L_0x001f:
            return
        L_0x0020:
            r0 = r2
            goto L_0x0007
        L_0x0022:
            r1 = r2
            goto L_0x0013
        L_0x0024:
            boolean r0 = r4.isReady()     // Catch:{ all -> 0x0035 }
            if (r0 == 0) goto L_0x0038
            com.google.android.gms.internal.zzlc$zza<R> r0 = r4.zzabi     // Catch:{ all -> 0x0035 }
            com.google.android.gms.common.api.Result r1 = r4.get()     // Catch:{ all -> 0x0035 }
            r0.zza(r5, r1)     // Catch:{ all -> 0x0035 }
        L_0x0033:
            monitor-exit(r3)     // Catch:{ all -> 0x0035 }
            goto L_0x001f
        L_0x0035:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0035 }
            throw r0
        L_0x0038:
            r4.zzabk = r5     // Catch:{ all -> 0x0035 }
            goto L_0x0033
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzlc.setResultCallback(com.google.android.gms.common.api.ResultCallback):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setResultCallback(com.google.android.gms.common.api.ResultCallback<? super R> r7, long r8, java.util.concurrent.TimeUnit r10) {
        /*
            r6 = this;
            r1 = 1
            r2 = 0
            boolean r0 = r6.zzabl
            if (r0 != 0) goto L_0x0020
            r0 = r1
        L_0x0007:
            java.lang.String r3 = "Result has already been consumed."
            com.google.android.gms.common.internal.zzx.zza(r0, r3)
            java.lang.Object r3 = r6.zzabh
            monitor-enter(r3)
            com.google.android.gms.internal.zzlq<R> r0 = r6.zzabp     // Catch:{ all -> 0x0035 }
            if (r0 != 0) goto L_0x0022
        L_0x0013:
            java.lang.String r0 = "Cannot set callbacks if then() has been called."
            com.google.android.gms.common.internal.zzx.zza(r1, r0)     // Catch:{ all -> 0x0035 }
            boolean r0 = r6.isCanceled()     // Catch:{ all -> 0x0035 }
            if (r0 == 0) goto L_0x0024
            monitor-exit(r3)     // Catch:{ all -> 0x0035 }
        L_0x001f:
            return
        L_0x0020:
            r0 = r2
            goto L_0x0007
        L_0x0022:
            r1 = r2
            goto L_0x0013
        L_0x0024:
            boolean r0 = r6.isReady()     // Catch:{ all -> 0x0035 }
            if (r0 == 0) goto L_0x0038
            com.google.android.gms.internal.zzlc$zza<R> r0 = r6.zzabi     // Catch:{ all -> 0x0035 }
            com.google.android.gms.common.api.Result r1 = r6.get()     // Catch:{ all -> 0x0035 }
            r0.zza(r7, r1)     // Catch:{ all -> 0x0035 }
        L_0x0033:
            monitor-exit(r3)     // Catch:{ all -> 0x0035 }
            goto L_0x001f
        L_0x0035:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0035 }
            throw r0
        L_0x0038:
            r6.zzabk = r7     // Catch:{ all -> 0x0035 }
            com.google.android.gms.internal.zzlc$zza<R> r0 = r6.zzabi     // Catch:{ all -> 0x0035 }
            long r4 = r10.toMillis(r8)     // Catch:{ all -> 0x0035 }
            r0.zza(r6, r4)     // Catch:{ all -> 0x0035 }
            goto L_0x0033
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzlc.setResultCallback(com.google.android.gms.common.api.ResultCallback, long, java.util.concurrent.TimeUnit):void");
    }

    public final void zza(com.google.android.gms.common.api.PendingResult.zza zza2) {
        boolean z = true;
        zzx.zza(!this.zzabl, (Object) "Result has already been consumed.");
        if (zza2 == null) {
            z = false;
        }
        zzx.zzb(z, (Object) "Callback cannot be null.");
        synchronized (this.zzabh) {
            if (isReady()) {
                zza2.zzt(this.zzaaX.getStatus());
            } else {
                this.zzabj.add(zza2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void zza(zzq zzq) {
        synchronized (this.zzabh) {
            this.zzabn = zzq;
        }
    }

    /* access modifiers changed from: protected */
    public abstract R zzb(Status status);

    public final void zzb(R r) {
        boolean z = true;
        synchronized (this.zzabh) {
            if (this.zzabm || this.zzL) {
                zzd(r);
                return;
            }
            zzx.zza(!isReady(), (Object) "Results have already been set");
            if (this.zzabl) {
                z = false;
            }
            zzx.zza(z, (Object) "Result has already been consumed");
            zzc(r);
        }
    }

    public Integer zznF() {
        return this.zzabo;
    }

    /* access modifiers changed from: protected */
    public void zznL() {
    }

    public final void zzw(Status status) {
        synchronized (this.zzabh) {
            if (!isReady()) {
                zzb((R) zzb(status));
                this.zzabm = true;
            }
        }
    }
}
