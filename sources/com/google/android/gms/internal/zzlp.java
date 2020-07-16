package com.google.android.gms.internal;

import android.app.Dialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.app.FragmentActivity;
import android.support.p000v4.app.FragmentManager;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzx;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class zzlp extends Fragment implements OnCancelListener {
    /* access modifiers changed from: private */
    public static final GoogleApiAvailability zzacJ = GoogleApiAvailability.getInstance();
    /* access modifiers changed from: private */
    public boolean mStarted;
    /* access modifiers changed from: private */
    public boolean zzacK;
    /* access modifiers changed from: private */
    public int zzacL = -1;
    /* access modifiers changed from: private */
    public ConnectionResult zzacM;
    /* access modifiers changed from: private */
    public final Handler zzacN = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public zzll zzacO;
    private final SparseArray<zza> zzacP = new SparseArray<>();

    private class zza implements OnConnectionFailedListener {
        public final int zzacQ;
        public final GoogleApiClient zzacR;
        public final OnConnectionFailedListener zzacS;

        public zza(int i, GoogleApiClient googleApiClient, OnConnectionFailedListener onConnectionFailedListener) {
            this.zzacQ = i;
            this.zzacR = googleApiClient;
            this.zzacS = onConnectionFailedListener;
            googleApiClient.registerConnectionFailedListener(this);
        }

        public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
            writer.append(prefix).append("GoogleApiClient #").print(this.zzacQ);
            writer.println(":");
            this.zzacR.dump(prefix + "  ", fd, writer, args);
        }

        public void onConnectionFailed(ConnectionResult result) {
            zzlp.this.zzacN.post(new zzb(this.zzacQ, result));
        }

        public void zzom() {
            this.zzacR.unregisterConnectionFailedListener(this);
            this.zzacR.disconnect();
        }
    }

    private class zzb implements Runnable {
        private final int zzacU;
        private final ConnectionResult zzacV;

        public zzb(int i, ConnectionResult connectionResult) {
            this.zzacU = i;
            this.zzacV = connectionResult;
        }

        public void run() {
            if (zzlp.this.mStarted && !zzlp.this.zzacK) {
                zzlp.this.zzacK = true;
                zzlp.this.zzacL = this.zzacU;
                zzlp.this.zzacM = this.zzacV;
                if (this.zzacV.hasResolution()) {
                    try {
                        this.zzacV.startResolutionForResult(zzlp.this.getActivity(), ((zzlp.this.getActivity().getSupportFragmentManager().getFragments().indexOf(zzlp.this) + 1) << 16) + 1);
                    } catch (SendIntentException e) {
                        zzlp.this.zzok();
                    }
                } else if (zzlp.zzacJ.isUserResolvableError(this.zzacV.getErrorCode())) {
                    GooglePlayServicesUtil.showErrorDialogFragment(this.zzacV.getErrorCode(), zzlp.this.getActivity(), zzlp.this, 2, zzlp.this);
                } else if (this.zzacV.getErrorCode() == 18) {
                    final Dialog zza = zzlp.zzacJ.zza(zzlp.this.getActivity(), zzlp.this);
                    zzlp.this.zzacO = zzll.zza(zzlp.this.getActivity().getApplicationContext(), new zzll() {
                        /* access modifiers changed from: protected */
                        public void zzoi() {
                            zzlp.this.zzok();
                            zza.dismiss();
                        }
                    });
                } else {
                    zzlp.this.zza(this.zzacU, this.zzacV);
                }
            }
        }
    }

    public static zzlp zza(FragmentActivity fragmentActivity) {
        zzx.zzci("Must be called from main thread of process");
        try {
            zzlp zzlp = (zzlp) fragmentActivity.getSupportFragmentManager().findFragmentByTag("GmsSupportLifecycleFragment");
            if (zzlp == null || zzlp.isRemoving()) {
                return null;
            }
            return zzlp;
        } catch (ClassCastException e) {
            throw new IllegalStateException("Fragment with tag GmsSupportLifecycleFragment is not a SupportLifecycleFragment", e);
        }
    }

    /* access modifiers changed from: private */
    public void zza(int i, ConnectionResult connectionResult) {
        Log.w("GmsSupportLifecycleFragment", "Unresolved error while connecting client. Stopping auto-manage.");
        zza zza2 = (zza) this.zzacP.get(i);
        if (zza2 != null) {
            zzbp(i);
            OnConnectionFailedListener onConnectionFailedListener = zza2.zzacS;
            if (onConnectionFailedListener != null) {
                onConnectionFailedListener.onConnectionFailed(connectionResult);
            }
        }
        zzok();
    }

    public static zzlp zzb(FragmentActivity fragmentActivity) {
        zzlp zza2 = zza(fragmentActivity);
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        if (zza2 != null) {
            return zza2;
        }
        zzlp zzlp = new zzlp();
        supportFragmentManager.beginTransaction().add((Fragment) zzlp, "GmsSupportLifecycleFragment").commitAllowingStateLoss();
        supportFragmentManager.executePendingTransactions();
        return zzlp;
    }

    /* access modifiers changed from: private */
    public void zzok() {
        int i = 0;
        this.zzacK = false;
        this.zzacL = -1;
        this.zzacM = null;
        if (this.zzacO != null) {
            this.zzacO.unregister();
            this.zzacO = null;
        }
        while (true) {
            int i2 = i;
            if (i2 < this.zzacP.size()) {
                ((zza) this.zzacP.valueAt(i2)).zzacR.connect();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        super.dump(prefix, fd, writer, args);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.zzacP.size()) {
                ((zza) this.zzacP.valueAt(i2)).dump(prefix, fd, writer, args);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0016, code lost:
        if (zzacJ.isGooglePlayServicesAvailable(getActivity()) == 0) goto L_0x0006;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r5, int r6, android.content.Intent r7) {
        /*
            r4 = this;
            r0 = 1
            r1 = 0
            switch(r5) {
                case 1: goto L_0x0019;
                case 2: goto L_0x000c;
                default: goto L_0x0005;
            }
        L_0x0005:
            r0 = r1
        L_0x0006:
            if (r0 == 0) goto L_0x0029
            r4.zzok()
        L_0x000b:
            return
        L_0x000c:
            com.google.android.gms.common.GoogleApiAvailability r2 = zzacJ
            android.support.v4.app.FragmentActivity r3 = r4.getActivity()
            int r2 = r2.isGooglePlayServicesAvailable(r3)
            if (r2 != 0) goto L_0x0005
            goto L_0x0006
        L_0x0019:
            r2 = -1
            if (r6 == r2) goto L_0x0006
            if (r6 != 0) goto L_0x0005
            com.google.android.gms.common.ConnectionResult r0 = new com.google.android.gms.common.ConnectionResult
            r2 = 13
            r3 = 0
            r0.<init>(r2, r3)
            r4.zzacM = r0
            goto L_0x0005
        L_0x0029:
            int r0 = r4.zzacL
            com.google.android.gms.common.ConnectionResult r1 = r4.zzacM
            r4.zza(r0, r1)
            goto L_0x000b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzlp.onActivityResult(int, int, android.content.Intent):void");
    }

    public void onCancel(DialogInterface dialogInterface) {
        zza(this.zzacL, new ConnectionResult(13, null));
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            this.zzacK = savedInstanceState.getBoolean("resolving_error", false);
            this.zzacL = savedInstanceState.getInt("failed_client_id", -1);
            if (this.zzacL >= 0) {
                this.zzacM = new ConnectionResult(savedInstanceState.getInt("failed_status"), (PendingIntent) savedInstanceState.getParcelable("failed_resolution"));
            }
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("resolving_error", this.zzacK);
        if (this.zzacL >= 0) {
            outState.putInt("failed_client_id", this.zzacL);
            outState.putInt("failed_status", this.zzacM.getErrorCode());
            outState.putParcelable("failed_resolution", this.zzacM.getResolution());
        }
    }

    public void onStart() {
        super.onStart();
        this.mStarted = true;
        if (!this.zzacK) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.zzacP.size()) {
                    ((zza) this.zzacP.valueAt(i2)).zzacR.connect();
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void onStop() {
        int i = 0;
        super.onStop();
        this.mStarted = false;
        while (true) {
            int i2 = i;
            if (i2 < this.zzacP.size()) {
                ((zza) this.zzacP.valueAt(i2)).zzacR.disconnect();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void zza(int i, GoogleApiClient googleApiClient, OnConnectionFailedListener onConnectionFailedListener) {
        zzx.zzb(googleApiClient, (Object) "GoogleApiClient instance cannot be null");
        zzx.zza(this.zzacP.indexOfKey(i) < 0, (Object) "Already managing a GoogleApiClient with id " + i);
        this.zzacP.put(i, new zza(i, googleApiClient, onConnectionFailedListener));
        if (this.mStarted && !this.zzacK) {
            googleApiClient.connect();
        }
    }

    public void zzbp(int i) {
        zza zza2 = (zza) this.zzacP.get(i);
        this.zzacP.remove(i);
        if (zza2 != null) {
            zza2.zzom();
        }
    }
}
