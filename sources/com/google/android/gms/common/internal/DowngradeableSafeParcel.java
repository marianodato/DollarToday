package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public abstract class DowngradeableSafeParcel implements SafeParcelable {
    private static final Object zzafm = new Object();
    private static ClassLoader zzafn = null;
    private static Integer zzafo = null;
    private boolean zzafp = false;

    private static boolean zza(Class<?> cls) {
        boolean z = false;
        try {
            return SafeParcelable.NULL.equals(cls.getField("NULL").get(null));
        } catch (IllegalAccessException | NoSuchFieldException e) {
            return z;
        }
    }

    protected static boolean zzck(String str) {
        ClassLoader zzoS = zzoS();
        if (zzoS == null) {
            return true;
        }
        try {
            return zza(zzoS.loadClass(str));
        } catch (Exception e) {
            return false;
        }
    }

    protected static ClassLoader zzoS() {
        ClassLoader classLoader;
        synchronized (zzafm) {
            classLoader = zzafn;
        }
        return classLoader;
    }

    protected static Integer zzoT() {
        Integer num;
        synchronized (zzafm) {
            num = zzafo;
        }
        return num;
    }

    /* access modifiers changed from: protected */
    public boolean zzoU() {
        return this.zzafp;
    }
}
