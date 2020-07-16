package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class zzj<T extends IInterface> implements com.google.android.gms.common.api.Api.zzb, com.google.android.gms.common.internal.zzk.zza {
    public static final String[] zzafI = {"service_esmobile", "service_googleme"};
    private final Context mContext;
    final Handler mHandler;
    private final Account zzQd;
    /* access modifiers changed from: private */
    public final Set<Scope> zzTm;
    private final Looper zzaaO;
    private final GoogleApiAvailability zzaaP;
    private final zzf zzabI;
    private T zzafA;
    /* access modifiers changed from: private */
    public final ArrayList<zzc<?>> zzafB;
    private zze zzafC;
    private int zzafD;
    /* access modifiers changed from: private */
    public final ConnectionCallbacks zzafE;
    /* access modifiers changed from: private */
    public final OnConnectionFailedListener zzafF;
    private final int zzafG;
    protected AtomicInteger zzafH;
    private final zzl zzafx;
    /* access modifiers changed from: private */
    public zzs zzafy;
    /* access modifiers changed from: private */
    public com.google.android.gms.common.api.GoogleApiClient.zza zzafz;
    private final Object zzpd;

    private abstract class zza extends zzc<Boolean> {
        public final int statusCode;
        public final Bundle zzafJ;

        protected zza(int i, Bundle bundle) {
            super(Boolean.valueOf(true));
            this.statusCode = i;
            this.zzafJ = bundle;
        }

        /* access modifiers changed from: protected */
        /* renamed from: zzc */
        public void zzt(Boolean bool) {
            PendingIntent pendingIntent = null;
            if (bool == null) {
                zzj.this.zzb(1, null);
                return;
            }
            switch (this.statusCode) {
                case 0:
                    if (!zzpf()) {
                        zzj.this.zzb(1, null);
                        zzh(new ConnectionResult(8, null));
                        return;
                    }
                    return;
                case 10:
                    zzj.this.zzb(1, null);
                    throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
                default:
                    zzj.this.zzb(1, null);
                    if (this.zzafJ != null) {
                        pendingIntent = (PendingIntent) this.zzafJ.getParcelable("pendingIntent");
                    }
                    zzh(new ConnectionResult(this.statusCode, pendingIntent));
                    return;
            }
        }

        /* access modifiers changed from: protected */
        public abstract void zzh(ConnectionResult connectionResult);

        /* access modifiers changed from: protected */
        public abstract boolean zzpf();

        /* access modifiers changed from: protected */
        public void zzpg() {
        }
    }

    final class zzb extends Handler {
        public zzb(Looper looper) {
            super(looper);
        }

        private void zza(Message message) {
            zzc zzc = (zzc) message.obj;
            zzc.zzpg();
            zzc.unregister();
        }

        private boolean zzb(Message message) {
            return message.what == 2 || message.what == 1 || message.what == 5 || message.what == 6;
        }

        public void handleMessage(Message msg) {
            if (zzj.this.zzafH.get() != msg.arg1) {
                if (zzb(msg)) {
                    zza(msg);
                }
            } else if ((msg.what == 1 || msg.what == 5 || msg.what == 6) && !zzj.this.isConnecting()) {
                zza(msg);
            } else if (msg.what == 3) {
                ConnectionResult connectionResult = new ConnectionResult(msg.arg2, null);
                zzj.this.zzafz.zza(connectionResult);
                zzj.this.onConnectionFailed(connectionResult);
            } else if (msg.what == 4) {
                zzj.this.zzb(4, null);
                if (zzj.this.zzafE != null) {
                    zzj.this.zzafE.onConnectionSuspended(msg.arg2);
                }
                zzj.this.onConnectionSuspended(msg.arg2);
                zzj.this.zza(4, 1, null);
            } else if (msg.what == 2 && !zzj.this.isConnected()) {
                zza(msg);
            } else if (zzb(msg)) {
                ((zzc) msg.obj).zzph();
            } else {
                Log.wtf("GmsClient", "Don't know how to handle message: " + msg.what, new Exception());
            }
        }
    }

    protected abstract class zzc<TListener> {
        private TListener mListener;
        private boolean zzafL = false;

        public zzc(TListener tlistener) {
            this.mListener = tlistener;
        }

        public void unregister() {
            zzpi();
            synchronized (zzj.this.zzafB) {
                zzj.this.zzafB.remove(this);
            }
        }

        /* access modifiers changed from: protected */
        public abstract void zzpg();

        public void zzph() {
            TListener tlistener;
            synchronized (this) {
                tlistener = this.mListener;
                if (this.zzafL) {
                    Log.w("GmsClient", "Callback proxy " + this + " being reused. This is not safe.");
                }
            }
            if (tlistener != null) {
                try {
                    zzt(tlistener);
                } catch (RuntimeException e) {
                    zzpg();
                    throw e;
                }
            } else {
                zzpg();
            }
            synchronized (this) {
                this.zzafL = true;
            }
            unregister();
        }

        public void zzpi() {
            synchronized (this) {
                this.mListener = null;
            }
        }

        /* access modifiers changed from: protected */
        public abstract void zzt(TListener tlistener);
    }

    public static final class zzd extends com.google.android.gms.common.internal.zzr.zza {
        private zzj zzafM;
        private final int zzafN;

        public zzd(zzj zzj, int i) {
            this.zzafM = zzj;
            this.zzafN = i;
        }

        private void zzpj() {
            this.zzafM = null;
        }

        public void zza(int i, IBinder iBinder, Bundle bundle) {
            zzx.zzb(this.zzafM, (Object) "onPostInitComplete can be called only once per call to getRemoteService");
            this.zzafM.zza(i, iBinder, bundle, this.zzafN);
            zzpj();
        }

        public void zzb(int i, Bundle bundle) {
            zzx.zzb(this.zzafM, (Object) "onAccountValidationComplete can be called only once per call to validateAccount");
            this.zzafM.zza(i, bundle, this.zzafN);
            zzpj();
        }
    }

    public final class zze implements ServiceConnection {
        private final int zzafN;

        public zze(int i) {
            this.zzafN = i;
        }

        public void onServiceConnected(ComponentName component, IBinder binder) {
            zzx.zzb(binder, (Object) "Expecting a valid IBinder");
            zzj.this.zzafy = com.google.android.gms.common.internal.zzs.zza.zzaK(binder);
            zzj.this.zzbF(this.zzafN);
        }

        public void onServiceDisconnected(ComponentName component) {
            zzj.this.mHandler.sendMessage(zzj.this.mHandler.obtainMessage(4, this.zzafN, 1));
        }
    }

    protected class zzf implements com.google.android.gms.common.api.GoogleApiClient.zza {
        public zzf() {
        }

        public void zza(ConnectionResult connectionResult) {
            if (connectionResult.isSuccess()) {
                zzj.this.zza((zzp) null, zzj.this.zzTm);
            } else if (zzj.this.zzafF != null) {
                zzj.this.zzafF.onConnectionFailed(connectionResult);
            }
        }

        public void zzb(ConnectionResult connectionResult) {
            throw new IllegalStateException("Legacy GmsClient received onReportAccountValidation callback.");
        }
    }

    protected final class zzg extends zza {
        public final IBinder zzafO;

        public zzg(int i, IBinder iBinder, Bundle bundle) {
            super(i, bundle);
            this.zzafO = iBinder;
        }

        /* access modifiers changed from: protected */
        public void zzh(ConnectionResult connectionResult) {
            if (zzj.this.zzafF != null) {
                zzj.this.zzafF.onConnectionFailed(connectionResult);
            }
            zzj.this.onConnectionFailed(connectionResult);
        }

        /* access modifiers changed from: protected */
        public boolean zzpf() {
            try {
                String interfaceDescriptor = this.zzafO.getInterfaceDescriptor();
                if (!zzj.this.zzfL().equals(interfaceDescriptor)) {
                    Log.e("GmsClient", "service descriptor mismatch: " + zzj.this.zzfL() + " vs. " + interfaceDescriptor);
                    return false;
                }
                IInterface zzW = zzj.this.zzW(this.zzafO);
                if (zzW == null || !zzj.this.zza(2, 3, zzW)) {
                    return false;
                }
                Bundle zzmS = zzj.this.zzmS();
                if (zzj.this.zzafE != null) {
                    zzj.this.zzafE.onConnected(zzmS);
                }
                return true;
            } catch (RemoteException e) {
                Log.w("GmsClient", "service probably died");
                return false;
            }
        }
    }

    protected final class zzh extends zza {
        public zzh() {
            super(0, null);
        }

        /* access modifiers changed from: protected */
        public void zzh(ConnectionResult connectionResult) {
            zzj.this.zzafz.zza(connectionResult);
            zzj.this.onConnectionFailed(connectionResult);
        }

        /* access modifiers changed from: protected */
        public boolean zzpf() {
            zzj.this.zzafz.zza(ConnectionResult.zzZY);
            return true;
        }
    }

    protected final class zzi extends zza {
        public zzi(int i, Bundle bundle) {
            super(i, bundle);
        }

        /* access modifiers changed from: protected */
        public void zzh(ConnectionResult connectionResult) {
            zzj.this.zzafz.zzb(connectionResult);
            zzj.this.onConnectionFailed(connectionResult);
        }

        /* access modifiers changed from: protected */
        public boolean zzpf() {
            zzj.this.zzafz.zzb(ConnectionResult.zzZY);
            return true;
        }
    }

    protected zzj(Context context, Looper looper, int i, zzf zzf2, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, zzl.zzal(context), GoogleApiAvailability.getInstance(), i, zzf2, (ConnectionCallbacks) zzx.zzw(connectionCallbacks), (OnConnectionFailedListener) zzx.zzw(onConnectionFailedListener));
    }

    protected zzj(Context context, Looper looper, zzl zzl, GoogleApiAvailability googleApiAvailability, int i, zzf zzf2, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        this.zzpd = new Object();
        this.zzafB = new ArrayList<>();
        this.zzafD = 1;
        this.zzafH = new AtomicInteger(0);
        this.mContext = (Context) zzx.zzb(context, (Object) "Context must not be null");
        this.zzaaO = (Looper) zzx.zzb(looper, (Object) "Looper must not be null");
        this.zzafx = (zzl) zzx.zzb(zzl, (Object) "Supervisor must not be null");
        this.zzaaP = (GoogleApiAvailability) zzx.zzb(googleApiAvailability, (Object) "API availability must not be null");
        this.mHandler = new zzb(looper);
        this.zzafG = i;
        this.zzabI = (zzf) zzx.zzw(zzf2);
        this.zzQd = zzf2.getAccount();
        this.zzTm = zza(zzf2.zzoL());
        this.zzafE = connectionCallbacks;
        this.zzafF = onConnectionFailedListener;
    }

    private Set<Scope> zza(Set<Scope> set) {
        Set<Scope> zzb2 = zzb(set);
        if (zzb2 == null) {
            return zzb2;
        }
        for (Scope contains : zzb2) {
            if (!set.contains(contains)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return zzb2;
    }

    /* access modifiers changed from: private */
    public boolean zza(int i, int i2, T t) {
        boolean z;
        synchronized (this.zzpd) {
            if (this.zzafD != i) {
                z = false;
            } else {
                zzb(i2, t);
                z = true;
            }
        }
        return z;
    }

    /* access modifiers changed from: private */
    public void zzb(int i, T t) {
        boolean z = true;
        if ((i == 3) != (t != null)) {
            z = false;
        }
        zzx.zzaa(z);
        synchronized (this.zzpd) {
            this.zzafD = i;
            this.zzafA = t;
            zzc(i, t);
            switch (i) {
                case 1:
                    zzoY();
                    break;
                case 2:
                    zzoX();
                    break;
                case 3:
                    zzoW();
                    break;
            }
        }
    }

    private void zzoX() {
        if (this.zzafC != null) {
            Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + zzfK());
            this.zzafx.zzb(zzfK(), (ServiceConnection) this.zzafC, zzoV());
            this.zzafH.incrementAndGet();
        }
        this.zzafC = new zze<>(this.zzafH.get());
        if (!this.zzafx.zza(zzfK(), (ServiceConnection) this.zzafC, zzoV())) {
            Log.e("GmsClient", "unable to connect to service: " + zzfK());
            this.mHandler.sendMessage(this.mHandler.obtainMessage(3, this.zzafH.get(), 9));
        }
    }

    private void zzoY() {
        if (this.zzafC != null) {
            this.zzafx.zzb(zzfK(), (ServiceConnection) this.zzafC, zzoV());
            this.zzafC = null;
        }
    }

    public void disconnect() {
        this.zzafH.incrementAndGet();
        synchronized (this.zzafB) {
            int size = this.zzafB.size();
            for (int i = 0; i < size; i++) {
                ((zzc) this.zzafB.get(i)).zzpi();
            }
            this.zzafB.clear();
        }
        zzb(1, null);
    }

    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        int i;
        T t;
        synchronized (this.zzpd) {
            i = this.zzafD;
            t = this.zzafA;
        }
        writer.append(prefix).append("mConnectState=");
        switch (i) {
            case 1:
                writer.print("DISCONNECTED");
                break;
            case 2:
                writer.print("CONNECTING");
                break;
            case 3:
                writer.print("CONNECTED");
                break;
            case 4:
                writer.print("DISCONNECTING");
                break;
            default:
                writer.print("UNKNOWN");
                break;
        }
        writer.append(" mService=");
        if (t == null) {
            writer.println("null");
        } else {
            writer.append(zzfL()).append("@").println(Integer.toHexString(System.identityHashCode(t.asBinder())));
        }
    }

    public final Context getContext() {
        return this.mContext;
    }

    public final Looper getLooper() {
        return this.zzaaO;
    }

    public boolean isConnected() {
        boolean z;
        synchronized (this.zzpd) {
            z = this.zzafD == 3;
        }
        return z;
    }

    public boolean isConnecting() {
        boolean z;
        synchronized (this.zzpd) {
            z = this.zzafD == 2;
        }
        return z;
    }

    /* access modifiers changed from: protected */
    public void onConnectionFailed(ConnectionResult result) {
    }

    /* access modifiers changed from: protected */
    public void onConnectionSuspended(int cause) {
    }

    /* access modifiers changed from: protected */
    public abstract T zzW(IBinder iBinder);

    /* access modifiers changed from: protected */
    public void zza(int i, Bundle bundle, int i2) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(5, i2, -1, new zzi(i, bundle)));
    }

    /* access modifiers changed from: protected */
    public void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, i2, -1, new zzg(i, iBinder, bundle)));
    }

    public void zza(com.google.android.gms.common.api.GoogleApiClient.zza zza2) {
        this.zzafz = (com.google.android.gms.common.api.GoogleApiClient.zza) zzx.zzb(zza2, (Object) "Connection progress callbacks cannot be null.");
        zzb(2, null);
    }

    public void zza(zzp zzp) {
        try {
            this.zzafy.zza((zzr) new zzd(this, this.zzafH.get()), new ValidateAccountRequest(zzp, (Scope[]) this.zzTm.toArray(new Scope[this.zzTm.size()]), this.mContext.getPackageName(), zzpd()));
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "service died");
            zzbE(1);
        } catch (RemoteException e2) {
            Log.w("GmsClient", "Remote exception occurred", e2);
        }
    }

    public void zza(zzp zzp, Set<Scope> set) {
        try {
            GetServiceRequest zzg2 = new GetServiceRequest(this.zzafG).zzcl(this.mContext.getPackageName()).zzg(zzly());
            if (set != null) {
                zzg2.zzd(set);
            }
            if (zzlN()) {
                zzg2.zzc(zzoI()).zzc(zzp);
            } else if (zzpe()) {
                zzg2.zzc(this.zzQd);
            }
            this.zzafy.zza((zzr) new zzd(this, this.zzafH.get()), zzg2);
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "service died");
            zzbE(1);
        } catch (RemoteException e2) {
            Log.w("GmsClient", "Remote exception occurred", e2);
        }
    }

    /* access modifiers changed from: protected */
    public Set<Scope> zzb(Set<Scope> set) {
        return set;
    }

    public void zzbE(int i) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4, this.zzafH.get(), i));
    }

    /* access modifiers changed from: protected */
    public void zzbF(int i) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(6, i, -1, new zzh()));
    }

    /* access modifiers changed from: protected */
    public void zzc(int i, T t) {
    }

    /* access modifiers changed from: protected */
    public abstract String zzfK();

    /* access modifiers changed from: protected */
    public abstract String zzfL();

    public boolean zzlN() {
        return false;
    }

    /* access modifiers changed from: protected */
    public Bundle zzly() {
        return new Bundle();
    }

    public Bundle zzmS() {
        return null;
    }

    public IBinder zznz() {
        if (this.zzafy == null) {
            return null;
        }
        return this.zzafy.asBinder();
    }

    public final Account zzoI() {
        return this.zzQd != null ? this.zzQd : new Account("<<default account>>", GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE);
    }

    /* access modifiers changed from: protected */
    public final String zzoV() {
        return this.zzabI.zzoO();
    }

    /* access modifiers changed from: protected */
    public void zzoW() {
    }

    public void zzoZ() {
        int isGooglePlayServicesAvailable = this.zzaaP.isGooglePlayServicesAvailable(this.mContext);
        if (isGooglePlayServicesAvailable != 0) {
            zzb(1, null);
            this.zzafz = new zzf();
            this.mHandler.sendMessage(this.mHandler.obtainMessage(3, this.zzafH.get(), isGooglePlayServicesAvailable));
            return;
        }
        zza((com.google.android.gms.common.api.GoogleApiClient.zza) new zzf());
    }

    /* access modifiers changed from: protected */
    public final zzf zzpa() {
        return this.zzabI;
    }

    /* access modifiers changed from: protected */
    public final void zzpb() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public final T zzpc() throws DeadObjectException {
        T t;
        synchronized (this.zzpd) {
            if (this.zzafD == 4) {
                throw new DeadObjectException();
            }
            zzpb();
            zzx.zza(this.zzafA != null, (Object) "Client is connected but service is null");
            t = this.zzafA;
        }
        return t;
    }

    /* access modifiers changed from: protected */
    public Bundle zzpd() {
        return null;
    }

    public boolean zzpe() {
        return false;
    }
}
