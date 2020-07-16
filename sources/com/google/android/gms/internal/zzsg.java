package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

final class zzsg {
    final int tag;
    final byte[] zzbiw;

    zzsg(int i, byte[] bArr) {
        this.tag = i;
        this.zzbiw = bArr;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzsg)) {
            return false;
        }
        zzsg zzsg = (zzsg) o;
        return this.tag == zzsg.tag && Arrays.equals(this.zzbiw, zzsg.zzbiw);
    }

    public int hashCode() {
        return ((this.tag + 527) * 31) + Arrays.hashCode(this.zzbiw);
    }

    /* access modifiers changed from: 0000 */
    public int zzB() {
        return 0 + zzrx.zzlO(this.tag) + this.zzbiw.length;
    }

    /* access modifiers changed from: 0000 */
    public void zza(zzrx zzrx) throws IOException {
        zzrx.zzlN(this.tag);
        zzrx.zzF(this.zzbiw);
    }
}
