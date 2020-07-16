package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import com.google.android.gms.common.GoogleApiAvailability;

abstract class zzll extends BroadcastReceiver {
    protected Context mContext;

    zzll() {
    }

    public static <T extends zzll> T zza(Context context, T t) {
        return zza(context, t, GoogleApiAvailability.getInstance());
    }

    public static <T extends zzll> T zza(Context context, T t, GoogleApiAvailability googleApiAvailability) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        context.registerReceiver(t, intentFilter);
        t.mContext = context;
        if (googleApiAvailability.zzj(context, "com.google.android.gms")) {
            return t;
        }
        t.zzoi();
        t.unregister();
        return null;
    }

    public void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        String str = null;
        if (data != null) {
            str = data.getSchemeSpecificPart();
        }
        if ("com.google.android.gms".equals(str)) {
            zzoi();
            unregister();
        }
    }

    public synchronized void unregister() {
        if (this.mContext != null) {
            this.mContext.unregisterReceiver(this);
        }
        this.mContext = null;
    }

    /* access modifiers changed from: protected */
    public abstract void zzoi();
}
