package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

final class zzm extends zzl implements Callback {
    private final Handler mHandler;
    /* access modifiers changed from: private */
    public final HashMap<zza, zzb> zzafY = new HashMap<>();
    /* access modifiers changed from: private */
    public final com.google.android.gms.common.stats.zzb zzafZ;
    private final long zzaga;
    /* access modifiers changed from: private */
    public final Context zzqZ;

    private static final class zza {
        private final String zzPp;
        private final ComponentName zzagb;

        public zza(ComponentName componentName) {
            this.zzPp = null;
            this.zzagb = (ComponentName) zzx.zzw(componentName);
        }

        public zza(String str) {
            this.zzPp = zzx.zzcr(str);
            this.zzagb = null;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof zza)) {
                return false;
            }
            zza zza = (zza) o;
            return zzw.equal(this.zzPp, zza.zzPp) && zzw.equal(this.zzagb, zza.zzagb);
        }

        public int hashCode() {
            return zzw.hashCode(this.zzPp, this.zzagb);
        }

        public String toString() {
            return this.zzPp == null ? this.zzagb.flattenToString() : this.zzPp;
        }

        public Intent zzpm() {
            return this.zzPp != null ? new Intent(this.zzPp).setPackage("com.google.android.gms") : new Intent().setComponent(this.zzagb);
        }
    }

    private final class zzb {
        /* access modifiers changed from: private */
        public int mState = 2;
        /* access modifiers changed from: private */
        public IBinder zzaeJ;
        /* access modifiers changed from: private */
        public ComponentName zzagb;
        private final zza zzagc = new zza();
        /* access modifiers changed from: private */
        public final Set<ServiceConnection> zzagd = new HashSet();
        private boolean zzage;
        /* access modifiers changed from: private */
        public final zza zzagf;

        public class zza implements ServiceConnection {
            public zza() {
            }

            public void onServiceConnected(ComponentName component, IBinder binder) {
                synchronized (zzm.this.zzafY) {
                    zzb.this.zzaeJ = binder;
                    zzb.this.zzagb = component;
                    for (ServiceConnection onServiceConnected : zzb.this.zzagd) {
                        onServiceConnected.onServiceConnected(component, binder);
                    }
                    zzb.this.mState = 1;
                }
            }

            public void onServiceDisconnected(ComponentName component) {
                synchronized (zzm.this.zzafY) {
                    zzb.this.zzaeJ = null;
                    zzb.this.zzagb = component;
                    for (ServiceConnection onServiceDisconnected : zzb.this.zzagd) {
                        onServiceDisconnected.onServiceDisconnected(component);
                    }
                    zzb.this.mState = 2;
                }
            }
        }

        public zzb(zza zza2) {
            this.zzagf = zza2;
        }

        public IBinder getBinder() {
            return this.zzaeJ;
        }

        public ComponentName getComponentName() {
            return this.zzagb;
        }

        public int getState() {
            return this.mState;
        }

        public boolean isBound() {
            return this.zzage;
        }

        public void zza(ServiceConnection serviceConnection, String str) {
            zzm.this.zzafZ.zza(zzm.this.zzqZ, serviceConnection, str, this.zzagf.zzpm());
            this.zzagd.add(serviceConnection);
        }

        public boolean zza(ServiceConnection serviceConnection) {
            return this.zzagd.contains(serviceConnection);
        }

        public void zzb(ServiceConnection serviceConnection, String str) {
            zzm.this.zzafZ.zzb(zzm.this.zzqZ, serviceConnection);
            this.zzagd.remove(serviceConnection);
        }

        public void zzcm(String str) {
            this.mState = 3;
            this.zzage = zzm.this.zzafZ.zza(zzm.this.zzqZ, str, this.zzagf.zzpm(), (ServiceConnection) this.zzagc, 129);
            if (!this.zzage) {
                this.mState = 2;
                try {
                    zzm.this.zzafZ.zza(zzm.this.zzqZ, this.zzagc);
                } catch (IllegalArgumentException e) {
                }
            }
        }

        public void zzcn(String str) {
            zzm.this.zzafZ.zza(zzm.this.zzqZ, this.zzagc);
            this.zzage = false;
            this.mState = 2;
        }

        public boolean zzpn() {
            return this.zzagd.isEmpty();
        }
    }

    zzm(Context context) {
        this.zzqZ = context.getApplicationContext();
        this.mHandler = new Handler(context.getMainLooper(), this);
        this.zzafZ = com.google.android.gms.common.stats.zzb.zzqh();
        this.zzaga = 5000;
    }

    private boolean zza(zza zza2, ServiceConnection serviceConnection, String str) {
        boolean isBound;
        zzx.zzb(serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.zzafY) {
            zzb zzb2 = (zzb) this.zzafY.get(zza2);
            if (zzb2 != null) {
                this.mHandler.removeMessages(0, zzb2);
                if (!zzb2.zza(serviceConnection)) {
                    zzb2.zza(serviceConnection, str);
                    switch (zzb2.getState()) {
                        case 1:
                            serviceConnection.onServiceConnected(zzb2.getComponentName(), zzb2.getBinder());
                            break;
                        case 2:
                            zzb2.zzcm(str);
                            break;
                    }
                } else {
                    throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + zza2);
                }
            } else {
                zzb2 = new zzb(zza2);
                zzb2.zza(serviceConnection, str);
                zzb2.zzcm(str);
                this.zzafY.put(zza2, zzb2);
            }
            isBound = zzb2.isBound();
        }
        return isBound;
    }

    private void zzb(zza zza2, ServiceConnection serviceConnection, String str) {
        zzx.zzb(serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.zzafY) {
            zzb zzb2 = (zzb) this.zzafY.get(zza2);
            if (zzb2 == null) {
                throw new IllegalStateException("Nonexistent connection status for service config: " + zza2);
            } else if (!zzb2.zza(serviceConnection)) {
                throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + zza2);
            } else {
                zzb2.zzb(serviceConnection, str);
                if (zzb2.zzpn()) {
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0, zzb2), this.zzaga);
                }
            }
        }
    }

    public boolean handleMessage(Message msg) {
        switch (msg.what) {
            case 0:
                zzb zzb2 = (zzb) msg.obj;
                synchronized (this.zzafY) {
                    if (zzb2.zzpn()) {
                        if (zzb2.isBound()) {
                            zzb2.zzcn("GmsClientSupervisor");
                        }
                        this.zzafY.remove(zzb2.zzagf);
                    }
                }
                return true;
            default:
                return false;
        }
    }

    public boolean zza(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        return zza(new zza(componentName), serviceConnection, str);
    }

    public boolean zza(String str, ServiceConnection serviceConnection, String str2) {
        return zza(new zza(str), serviceConnection, str2);
    }

    public void zzb(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        zzb(new zza(componentName), serviceConnection, str);
    }

    public void zzb(String str, ServiceConnection serviceConnection, String str2) {
        zzb(new zza(str), serviceConnection, str2);
    }
}
