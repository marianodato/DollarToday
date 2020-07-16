package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import java.util.regex.Pattern;

public final class zzml {
    private static Pattern zzaij = null;

    public static boolean zzan(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
    }

    public static int zzca(int i) {
        return i / CredentialsApi.ACTIVITY_RESULT_ADD_ACCOUNT;
    }

    @Deprecated
    public static boolean zzcb(int i) {
        return false;
    }
}
