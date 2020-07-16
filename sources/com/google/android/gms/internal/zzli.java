package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.support.p000v4.app.FragmentActivity;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.common.internal.zzx;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class zzli extends GoogleApiClient {
    private final Context mContext;
    /* access modifiers changed from: private */
    public final int zzaaM;
    private final Looper zzaaO;
    private final GoogleApiAvailability zzaaP;
    final com.google.android.gms.common.api.Api.zza<? extends zzqw, zzqx> zzaaQ;
    final com.google.android.gms.common.internal.zzf zzabI;
    final Map<Api<?>, Integer> zzabJ;
    private final Condition zzabY;
    final zzk zzabZ;
    /* access modifiers changed from: private */
    public final Lock zzabt = new ReentrantLock();
    final Queue<zzf<?>> zzaca = new LinkedList();
    private volatile boolean zzacb;
    private long zzacc = 120000;
    private long zzacd = 5000;
    private final zza zzace;
    zzd zzacf;
    final Map<com.google.android.gms.common.api.Api.zzc<?>, com.google.android.gms.common.api.Api.zzb> zzacg = new HashMap();
    final Map<com.google.android.gms.common.api.Api.zzc<?>, ConnectionResult> zzach = new HashMap();
    Set<Scope> zzaci = new HashSet();
    /* access modifiers changed from: private */
    public volatile zzlj zzacj;
    private ConnectionResult zzack = null;
    private final Set<zzlm<?>> zzacl = Collections.newSetFromMap(new WeakHashMap());
    final Set<zzf<?>> zzacm = Collections.newSetFromMap(new ConcurrentHashMap(16, 0.75f, 2));
    /* access modifiers changed from: private */
    public com.google.android.gms.common.api.zza zzacn;
    private final zze zzaco = new zze() {
        public void zzc(zzf<?> zzf) {
            zzli.this.zzacm.remove(zzf);
            if (zzf.zznF() != null && zzli.this.zzacn != null) {
                zzli.this.zzacn.remove(zzf.zznF().intValue());
            }
        }
    };
    private final ConnectionCallbacks zzacp = new ConnectionCallbacks() {
        public void onConnected(Bundle connectionHint) {
            zzli.this.zzabt.lock();
            try {
                zzli.this.zzacj.onConnected(connectionHint);
            } finally {
                zzli.this.zzabt.unlock();
            }
        }

        public void onConnectionSuspended(int cause) {
            zzli.this.zzabt.lock();
            try {
                zzli.this.zzacj.onConnectionSuspended(cause);
            } finally {
                zzli.this.zzabt.unlock();
            }
        }
    };
    private final com.google.android.gms.common.internal.zzk.zza zzacq = new com.google.android.gms.common.internal.zzk.zza() {
        public boolean isConnected() {
            return zzli.this.isConnected();
        }

        public Bundle zzmS() {
            return null;
        }
    };

    final class zza extends Handler {
        zza(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    zzli.this.zzod();
                    return;
                case 2:
                    zzli.this.resume();
                    return;
                case 3:
                    ((zzb) msg.obj).zzg(zzli.this);
                    return;
                case 4:
                    throw ((RuntimeException) msg.obj);
                default:
                    Log.w("GoogleApiClientImpl", "Unknown message id: " + msg.what);
                    return;
            }
        }
    }

    static abstract class zzb {
        private final zzlj zzacy;

        protected zzb(zzlj zzlj) {
            this.zzacy = zzlj;
        }

        public final void zzg(zzli zzli) {
            zzli.zzabt.lock();
            try {
                if (zzli.zzacj == this.zzacy) {
                    zznO();
                    zzli.zzabt.unlock();
                }
            } finally {
                zzli.zzabt.unlock();
            }
        }

        /* access modifiers changed from: protected */
        public abstract void zznO();
    }

    private static class zzc implements DeathRecipient, zze {
        private final WeakReference<com.google.android.gms.common.api.zza> zzacA;
        private final WeakReference<IBinder> zzacB;
        private final WeakReference<zzf<?>> zzacz;

        private zzc(zzf zzf, com.google.android.gms.common.api.zza zza, IBinder iBinder) {
            this.zzacA = new WeakReference<>(zza);
            this.zzacz = new WeakReference<>(zzf);
            this.zzacB = new WeakReference<>(iBinder);
        }

        private void zzoh() {
            zzf zzf = (zzf) this.zzacz.get();
            com.google.android.gms.common.api.zza zza = (com.google.android.gms.common.api.zza) this.zzacA.get();
            if (!(zza == null || zzf == null)) {
                zza.remove(zzf.zznF().intValue());
            }
            IBinder iBinder = (IBinder) this.zzacB.get();
            if (this.zzacB != null) {
                iBinder.unlinkToDeath(this, 0);
            }
        }

        public void binderDied() {
            zzoh();
        }

        public void zzc(zzf<?> zzf) {
            zzoh();
        }
    }

    static class zzd extends zzll {
        private WeakReference<zzli> zzacC;

        zzd(zzli zzli) {
            this.zzacC = new WeakReference<>(zzli);
        }

        public void zzoi() {
            zzli zzli = (zzli) this.zzacC.get();
            if (zzli != null) {
                zzli.resume();
            }
        }
    }

    interface zze {
        void zzc(zzf<?> zzf);
    }

    interface zzf<A extends com.google.android.gms.common.api.Api.zzb> {
        void cancel();

        boolean isReady();

        void zza(zze zze);

        void zzb(A a) throws DeadObjectException;

        Integer zznF();

        void zznJ();

        int zznK();

        com.google.android.gms.common.api.Api.zzc<A> zznx();

        void zzv(Status status);

        void zzw(Status status);
    }

    public zzli(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzf2, GoogleApiAvailability googleApiAvailability, com.google.android.gms.common.api.Api.zza<? extends zzqw, zzqx> zza2, Map<Api<?>, ApiOptions> map, ArrayList<ConnectionCallbacks> arrayList, ArrayList<OnConnectionFailedListener> arrayList2, int i) {
        int i2;
        this.mContext = context;
        this.zzabZ = new zzk(looper, this.zzacq);
        this.zzaaO = looper;
        this.zzace = new zza(looper);
        this.zzaaP = googleApiAvailability;
        this.zzaaM = i;
        this.zzabJ = new HashMap();
        this.zzabY = this.zzabt.newCondition();
        this.zzacj = new zzlh(this);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.zzabZ.registerConnectionCallbacks((ConnectionCallbacks) it.next());
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            this.zzabZ.registerConnectionFailedListener((OnConnectionFailedListener) it2.next());
        }
        Map zzoM = zzf2.zzoM();
        for (Api api : map.keySet()) {
            Object obj = map.get(api);
            if (zzoM.get(api) != null) {
                i2 = ((com.google.android.gms.common.internal.zzf.zza) zzoM.get(api)).zzafk ? 1 : 2;
            } else {
                i2 = 0;
            }
            this.zzabJ.put(api, Integer.valueOf(i2));
            this.zzacg.put(api.zznx(), api.zzny() ? zza(api.zznw(), obj, context, looper, zzf2, this.zzacp, zza(api, i2)) : zza(api.zznv(), obj, context, looper, zzf2, this.zzacp, zza(api, i2)));
        }
        this.zzabI = zzf2;
        this.zzaaQ = zza2;
    }

    /* access modifiers changed from: private */
    public void resume() {
        this.zzabt.lock();
        try {
            if (zzoc()) {
                connect();
            }
        } finally {
            this.zzabt.unlock();
        }
    }

    private static <C extends com.google.android.gms.common.api.Api.zzb, O> C zza(com.google.android.gms.common.api.Api.zza<C, O> zza2, Object obj, Context context, Looper looper, com.google.android.gms.common.internal.zzf zzf2, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        return zza2.zza(context, looper, zzf2, obj, connectionCallbacks, onConnectionFailedListener);
    }

    private OnConnectionFailedListener zza(final Api<?> api, final int i) {
        return new OnConnectionFailedListener() {
            public void onConnectionFailed(ConnectionResult result) {
                zzli.this.zzabt.lock();
                try {
                    zzli.this.zzacj.zza(result, api, i);
                } finally {
                    zzli.this.zzabt.unlock();
                }
            }
        };
    }

    private static <C extends com.google.android.gms.common.api.Api.zzd, O> zzac zza(com.google.android.gms.common.api.Api.zze<C, O> zze2, Object obj, Context context, Looper looper, com.google.android.gms.common.internal.zzf zzf2, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        return new zzac(context, looper, zze2.zznA(), connectionCallbacks, onConnectionFailedListener, zzf2, zze2.zzn(obj));
    }

    /* access modifiers changed from: private */
    public void zza(final GoogleApiClient googleApiClient, final zzlo zzlo, final boolean z) {
        zzlx.zzagw.zzb(googleApiClient).setResultCallback(new ResultCallback<Status>() {
            /* renamed from: zzo */
            public void onResult(Status status) {
                if (status.isSuccess() && zzli.this.isConnected()) {
                    zzli.this.reconnect();
                }
                zzlo.zzb(status);
                if (z) {
                    googleApiClient.disconnect();
                }
            }
        });
    }

    private static void zza(zzf<?> zzf2, com.google.android.gms.common.api.zza zza2, IBinder iBinder) {
        if (zzf2.isReady()) {
            zzf2.zza(new zzc(zzf2, zza2, iBinder));
        } else if (iBinder == null || !iBinder.isBinderAlive()) {
            zzf2.zza(null);
            zzf2.cancel();
            zza2.remove(zzf2.zznF().intValue());
        } else {
            zzc zzc2 = new zzc(zzf2, zza2, iBinder);
            zzf2.zza(zzc2);
            try {
                iBinder.linkToDeath(zzc2, 0);
            } catch (RemoteException e) {
                zzf2.cancel();
                zza2.remove(zzf2.zznF().intValue());
            }
        }
    }

    /* access modifiers changed from: private */
    public void zzod() {
        this.zzabt.lock();
        try {
            if (zzof()) {
                connect();
            }
        } finally {
            this.zzabt.unlock();
        }
    }

    public ConnectionResult blockingConnect() {
        ConnectionResult connectionResult;
        zzx.zza(Looper.myLooper() != Looper.getMainLooper(), (Object) "blockingConnect must not be called on the UI thread");
        this.zzabt.lock();
        try {
            connect();
            while (isConnecting()) {
                this.zzabY.await();
            }
            if (isConnected()) {
                connectionResult = ConnectionResult.zzZY;
            } else if (this.zzack != null) {
                connectionResult = this.zzack;
                this.zzabt.unlock();
            } else {
                connectionResult = new ConnectionResult(13, null);
                this.zzabt.unlock();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            connectionResult = new ConnectionResult(15, null);
        } finally {
            this.zzabt.unlock();
        }
        return connectionResult;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005d, code lost:
        if (isConnected() == false) goto L_0x0067;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005f, code lost:
        r0 = com.google.android.gms.common.ConnectionResult.zzZY;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0069, code lost:
        if (r5.zzack == null) goto L_0x0073;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006b, code lost:
        r0 = r5.zzack;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x006d, code lost:
        r5.zzabt.unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r0 = new com.google.android.gms.common.ConnectionResult(13, null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x007b, code lost:
        r5.zzabt.unlock();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.common.ConnectionResult blockingConnect(long r6, java.util.concurrent.TimeUnit r8) {
        /*
            r5 = this;
            android.os.Looper r0 = android.os.Looper.myLooper()
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            if (r0 == r1) goto L_0x0041
            r0 = 1
        L_0x000b:
            java.lang.String r1 = "blockingConnect must not be called on the UI thread"
            com.google.android.gms.common.internal.zzx.zza(r0, r1)
            java.lang.String r0 = "TimeUnit must not be null"
            com.google.android.gms.common.internal.zzx.zzb(r8, r0)
            java.util.concurrent.locks.Lock r0 = r5.zzabt
            r0.lock()
            r5.connect()     // Catch:{ all -> 0x0081 }
            long r0 = r8.toNanos(r6)     // Catch:{ all -> 0x0081 }
        L_0x0021:
            boolean r2 = r5.isConnecting()     // Catch:{ all -> 0x0081 }
            if (r2 == 0) goto L_0x0059
            java.util.concurrent.locks.Condition r2 = r5.zzabY     // Catch:{ InterruptedException -> 0x0043 }
            long r0 = r2.awaitNanos(r0)     // Catch:{ InterruptedException -> 0x0043 }
            r2 = 0
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 > 0) goto L_0x0021
            com.google.android.gms.common.ConnectionResult r0 = new com.google.android.gms.common.ConnectionResult     // Catch:{ InterruptedException -> 0x0043 }
            r1 = 14
            r2 = 0
            r0.<init>(r1, r2)     // Catch:{ InterruptedException -> 0x0043 }
            java.util.concurrent.locks.Lock r1 = r5.zzabt
            r1.unlock()
        L_0x0040:
            return r0
        L_0x0041:
            r0 = 0
            goto L_0x000b
        L_0x0043:
            r0 = move-exception
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0081 }
            r0.interrupt()     // Catch:{ all -> 0x0081 }
            com.google.android.gms.common.ConnectionResult r0 = new com.google.android.gms.common.ConnectionResult     // Catch:{ all -> 0x0081 }
            r1 = 15
            r2 = 0
            r0.<init>(r1, r2)     // Catch:{ all -> 0x0081 }
            java.util.concurrent.locks.Lock r1 = r5.zzabt
            r1.unlock()
            goto L_0x0040
        L_0x0059:
            boolean r0 = r5.isConnected()     // Catch:{ all -> 0x0081 }
            if (r0 == 0) goto L_0x0067
            com.google.android.gms.common.ConnectionResult r0 = com.google.android.gms.common.ConnectionResult.zzZY     // Catch:{ all -> 0x0081 }
            java.util.concurrent.locks.Lock r1 = r5.zzabt
            r1.unlock()
            goto L_0x0040
        L_0x0067:
            com.google.android.gms.common.ConnectionResult r0 = r5.zzack     // Catch:{ all -> 0x0081 }
            if (r0 == 0) goto L_0x0073
            com.google.android.gms.common.ConnectionResult r0 = r5.zzack     // Catch:{ all -> 0x0081 }
            java.util.concurrent.locks.Lock r1 = r5.zzabt
            r1.unlock()
            goto L_0x0040
        L_0x0073:
            com.google.android.gms.common.ConnectionResult r0 = new com.google.android.gms.common.ConnectionResult     // Catch:{ all -> 0x0081 }
            r1 = 13
            r2 = 0
            r0.<init>(r1, r2)     // Catch:{ all -> 0x0081 }
            java.util.concurrent.locks.Lock r1 = r5.zzabt
            r1.unlock()
            goto L_0x0040
        L_0x0081:
            r0 = move-exception
            java.util.concurrent.locks.Lock r1 = r5.zzabt
            r1.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzli.blockingConnect(long, java.util.concurrent.TimeUnit):com.google.android.gms.common.ConnectionResult");
    }

    public PendingResult<Status> clearDefaultAccountAndReconnect() {
        zzx.zza(isConnected(), (Object) "GoogleApiClient is not connected yet.");
        final zzlo zzlo = new zzlo((GoogleApiClient) this);
        if (this.zzacg.containsKey(zzlx.zzRk)) {
            zza((GoogleApiClient) this, zzlo, false);
        } else {
            final AtomicReference atomicReference = new AtomicReference();
            C04925 r2 = new ConnectionCallbacks() {
                public void onConnected(Bundle connectionHint) {
                    zzli.this.zza((GoogleApiClient) atomicReference.get(), zzlo, true);
                }

                public void onConnectionSuspended(int cause) {
                }
            };
            GoogleApiClient build = new Builder(this.mContext).addApi(zzlx.API).addConnectionCallbacks(r2).addOnConnectionFailedListener(new OnConnectionFailedListener() {
                public void onConnectionFailed(ConnectionResult result) {
                    zzlo.zzb(new Status(8));
                }
            }).setHandler(this.zzace).build();
            atomicReference.set(build);
            build.connect();
        }
        return zzlo;
    }

    public void connect() {
        this.zzabt.lock();
        try {
            this.zzacj.connect();
        } finally {
            this.zzabt.unlock();
        }
    }

    public void disconnect() {
        this.zzabt.lock();
        try {
            zzof();
            this.zzacj.disconnect();
        } finally {
            this.zzabt.unlock();
        }
    }

    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        writer.append(prefix).append("mState=").append(this.zzacj.getName());
        writer.append(" mResuming=").print(this.zzacb);
        writer.append(" mWorkQueue.size()=").print(this.zzaca.size());
        writer.append(" mUnconsumedRunners.size()=").println(this.zzacm.size());
        String str = prefix + "  ";
        for (Api api : this.zzabJ.keySet()) {
            writer.append(prefix).append(api.getName()).println(":");
            ((com.google.android.gms.common.api.Api.zzb) this.zzacg.get(api.zznx())).dump(str, fd, writer, args);
        }
    }

    public ConnectionResult getConnectionResult(Api<?> api) {
        ConnectionResult connectionResult;
        com.google.android.gms.common.api.Api.zzc zznx = api.zznx();
        this.zzabt.lock();
        try {
            if (!isConnected() && !zzoc()) {
                throw new IllegalStateException("Cannot invoke getConnectionResult unless GoogleApiClient is connected");
            } else if (this.zzacg.containsKey(zznx)) {
                if (((com.google.android.gms.common.api.Api.zzb) this.zzacg.get(zznx)).isConnected()) {
                    connectionResult = ConnectionResult.zzZY;
                } else if (this.zzach.containsKey(zznx)) {
                    connectionResult = (ConnectionResult) this.zzach.get(zznx);
                    this.zzabt.unlock();
                } else {
                    Log.i("GoogleApiClientImpl", zzog());
                    Log.wtf("GoogleApiClientImpl", api.getName() + " requested in getConnectionResult" + " is not connected but is not present in the failed connections map", new Exception());
                    connectionResult = new ConnectionResult(8, null);
                    this.zzabt.unlock();
                }
                return connectionResult;
            } else {
                this.zzabt.unlock();
                throw new IllegalArgumentException(api.getName() + " was never registered with GoogleApiClient");
            }
        } finally {
            this.zzabt.unlock();
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public Looper getLooper() {
        return this.zzaaO;
    }

    public int getSessionId() {
        return System.identityHashCode(this);
    }

    public boolean hasConnectedApi(Api<?> api) {
        com.google.android.gms.common.api.Api.zzb zzb2 = (com.google.android.gms.common.api.Api.zzb) this.zzacg.get(api.zznx());
        return zzb2 != null && zzb2.isConnected();
    }

    public boolean isConnected() {
        return this.zzacj instanceof zzlf;
    }

    public boolean isConnecting() {
        return this.zzacj instanceof zzlg;
    }

    public boolean isConnectionCallbacksRegistered(ConnectionCallbacks listener) {
        return this.zzabZ.isConnectionCallbacksRegistered(listener);
    }

    public boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener listener) {
        return this.zzabZ.isConnectionFailedListenerRegistered(listener);
    }

    public void reconnect() {
        disconnect();
        connect();
    }

    public void registerConnectionCallbacks(ConnectionCallbacks listener) {
        this.zzabZ.registerConnectionCallbacks(listener);
    }

    public void registerConnectionFailedListener(OnConnectionFailedListener listener) {
        this.zzabZ.registerConnectionFailedListener(listener);
    }

    public void stopAutoManage(final FragmentActivity lifecycleActivity) {
        if (this.zzaaM >= 0) {
            zzlp zza2 = zzlp.zza(lifecycleActivity);
            if (zza2 == null) {
                new Handler(this.mContext.getMainLooper()).post(new Runnable() {
                    public void run() {
                        if (!lifecycleActivity.isFinishing() && !lifecycleActivity.getSupportFragmentManager().isDestroyed()) {
                            zzlp.zzb(lifecycleActivity).zzbp(zzli.this.zzaaM);
                        }
                    }
                });
            } else {
                zza2.zzbp(this.zzaaM);
            }
        } else {
            throw new IllegalStateException("Called stopAutoManage but automatic lifecycle management is not enabled.");
        }
    }

    public void unregisterConnectionCallbacks(ConnectionCallbacks listener) {
        this.zzabZ.unregisterConnectionCallbacks(listener);
    }

    public void unregisterConnectionFailedListener(OnConnectionFailedListener listener) {
        this.zzabZ.unregisterConnectionFailedListener(listener);
    }

    public <C extends com.google.android.gms.common.api.Api.zzb> C zza(com.google.android.gms.common.api.Api.zzc<C> zzc2) {
        C c = (com.google.android.gms.common.api.Api.zzb) this.zzacg.get(zzc2);
        zzx.zzb(c, (Object) "Appropriate Api was not requested.");
        return c;
    }

    public <A extends com.google.android.gms.common.api.Api.zzb, R extends Result, T extends com.google.android.gms.internal.zzlb.zza<R, A>> T zza(T t) {
        zzx.zzb(t.zznx() != null, (Object) "This task can not be enqueued (it's probably a Batch or malformed)");
        zzx.zzb(this.zzacg.containsKey(t.zznx()), (Object) "GoogleApiClient is not configured to use the API required for this call.");
        this.zzabt.lock();
        try {
            return this.zzacj.zza(t);
        } finally {
            this.zzabt.unlock();
        }
    }

    /* access modifiers changed from: 0000 */
    public void zza(zzb zzb2) {
        this.zzace.sendMessage(this.zzace.obtainMessage(3, zzb2));
    }

    /* access modifiers changed from: 0000 */
    public void zza(RuntimeException runtimeException) {
        this.zzace.sendMessage(this.zzace.obtainMessage(4, runtimeException));
    }

    public boolean zza(Api<?> api) {
        return this.zzacg.containsKey(api.zznx());
    }

    public <A extends com.google.android.gms.common.api.Api.zzb, T extends com.google.android.gms.internal.zzlb.zza<? extends Result, A>> T zzb(T t) {
        zzx.zzb(t.zznx() != null, (Object) "This task can not be executed (it's probably a Batch or malformed)");
        this.zzabt.lock();
        try {
            if (zzoc()) {
                this.zzaca.add(t);
                while (!this.zzaca.isEmpty()) {
                    zzf zzf2 = (zzf) this.zzaca.remove();
                    zzb(zzf2);
                    zzf2.zzv(Status.zzabd);
                }
            } else {
                t = this.zzacj.zzb(t);
                this.zzabt.unlock();
            }
            return t;
        } finally {
            this.zzabt.unlock();
        }
    }

    /* access modifiers changed from: 0000 */
    public <A extends com.google.android.gms.common.api.Api.zzb> void zzb(zzf<A> zzf2) {
        this.zzacm.add(zzf2);
        zzf2.zza(this.zzaco);
    }

    /* access modifiers changed from: 0000 */
    public void zzg(ConnectionResult connectionResult) {
        this.zzabt.lock();
        try {
            this.zzack = connectionResult;
            this.zzacj = new zzlh(this);
            this.zzacj.begin();
            this.zzabY.signalAll();
        } finally {
            this.zzabt.unlock();
        }
    }

    /* access modifiers changed from: 0000 */
    public void zznY() {
        for (zzf zzf2 : this.zzacm) {
            zzf2.zza(null);
            if (zzf2.zznF() == null) {
                zzf2.cancel();
            } else {
                zzf2.zznJ();
                zza(zzf2, this.zzacn, zza(zzf2.zznx()).zznz());
            }
        }
        this.zzacm.clear();
        for (zzlm clear : this.zzacl) {
            clear.clear();
        }
        this.zzacl.clear();
    }

    /* access modifiers changed from: 0000 */
    public void zznZ() {
        for (com.google.android.gms.common.api.Api.zzb disconnect : this.zzacg.values()) {
            disconnect.disconnect();
        }
    }

    public <L> zzlm<L> zzo(L l) {
        zzx.zzb(l, (Object) "Listener must not be null");
        this.zzabt.lock();
        try {
            zzlm<L> zzlm = new zzlm<>(this.zzaaO, l);
            this.zzacl.add(zzlm);
            return zzlm;
        } finally {
            this.zzabt.unlock();
        }
    }

    /* access modifiers changed from: 0000 */
    public void zzoa() {
        this.zzabt.lock();
        try {
            this.zzacj = new zzlg(this, this.zzabI, this.zzabJ, this.zzaaP, this.zzaaQ, this.zzabt, this.mContext);
            this.zzacj.begin();
            this.zzabY.signalAll();
        } finally {
            this.zzabt.unlock();
        }
    }

    /* access modifiers changed from: 0000 */
    public void zzob() {
        this.zzabt.lock();
        try {
            zzof();
            this.zzacj = new zzlf(this);
            this.zzacj.begin();
            this.zzabY.signalAll();
        } finally {
            this.zzabt.unlock();
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean zzoc() {
        return this.zzacb;
    }

    /* access modifiers changed from: 0000 */
    public void zzoe() {
        if (!zzoc()) {
            this.zzacb = true;
            if (this.zzacf == null) {
                this.zzacf = (zzd) zzll.zza(this.mContext.getApplicationContext(), new zzd(this), this.zzaaP);
            }
            this.zzace.sendMessageDelayed(this.zzace.obtainMessage(1), this.zzacc);
            this.zzace.sendMessageDelayed(this.zzace.obtainMessage(2), this.zzacd);
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean zzof() {
        if (!zzoc()) {
            return false;
        }
        this.zzacb = false;
        this.zzace.removeMessages(2);
        this.zzace.removeMessages(1);
        if (this.zzacf != null) {
            this.zzacf.unregister();
            this.zzacf = null;
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    public String zzog() {
        StringWriter stringWriter = new StringWriter();
        dump("", null, new PrintWriter(stringWriter), null);
        return stringWriter.toString();
    }
}
