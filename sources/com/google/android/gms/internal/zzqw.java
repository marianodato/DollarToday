package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.signin.internal.zze;
import java.util.Set;

public interface zzqw extends zzb {
    void connect();

    void zzCe();

    void zza(zzp zzp, Set<Scope> set, zze zze);

    void zza(zzp zzp, boolean z);

    void zza(zzt zzt);
}
