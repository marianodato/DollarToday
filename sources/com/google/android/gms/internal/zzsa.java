package com.google.android.gms.internal;

public final class zzsa implements Cloneable {
    private static final zzsb zzbin = new zzsb();
    private int mSize;
    private boolean zzbio;
    private int[] zzbip;
    private zzsb[] zzbiq;

    zzsa() {
        this(10);
    }

    zzsa(int i) {
        this.zzbio = false;
        int idealIntArraySize = idealIntArraySize(i);
        this.zzbip = new int[idealIntArraySize];
        this.zzbiq = new zzsb[idealIntArraySize];
        this.mSize = 0;
    }

    /* renamed from: gc */
    private void m19gc() {
        int i = this.mSize;
        int[] iArr = this.zzbip;
        zzsb[] zzsbArr = this.zzbiq;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            zzsb zzsb = zzsbArr[i3];
            if (zzsb != zzbin) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    zzsbArr[i2] = zzsb;
                    zzsbArr[i3] = null;
                }
                i2++;
            }
        }
        this.zzbio = false;
        this.mSize = i2;
    }

    private int idealByteArraySize(int need) {
        for (int i = 4; i < 32; i++) {
            if (need <= (1 << i) - 12) {
                return (1 << i) - 12;
            }
        }
        return need;
    }

    private int idealIntArraySize(int need) {
        return idealByteArraySize(need * 4) / 4;
    }

    private boolean zza(int[] iArr, int[] iArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private boolean zza(zzsb[] zzsbArr, zzsb[] zzsbArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (!zzsbArr[i2].equals(zzsbArr2[i2])) {
                return false;
            }
        }
        return true;
    }

    private int zzlT(int i) {
        int i2 = 0;
        int i3 = this.mSize - 1;
        while (i2 <= i3) {
            int i4 = (i2 + i3) >>> 1;
            int i5 = this.zzbip[i4];
            if (i5 < i) {
                i2 = i4 + 1;
            } else if (i5 <= i) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return i2 ^ -1;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzsa)) {
            return false;
        }
        zzsa zzsa = (zzsa) o;
        if (size() != zzsa.size()) {
            return false;
        }
        return zza(this.zzbip, zzsa.zzbip, this.mSize) && zza(this.zzbiq, zzsa.zzbiq, this.mSize);
    }

    public int hashCode() {
        if (this.zzbio) {
            m19gc();
        }
        int i = 17;
        for (int i2 = 0; i2 < this.mSize; i2++) {
            i = (((i * 31) + this.zzbip[i2]) * 31) + this.zzbiq[i2].hashCode();
        }
        return i;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    /* access modifiers changed from: 0000 */
    public int size() {
        if (this.zzbio) {
            m19gc();
        }
        return this.mSize;
    }

    /* renamed from: zzFH */
    public final zzsa clone() {
        int size = size();
        zzsa zzsa = new zzsa(size);
        System.arraycopy(this.zzbip, 0, zzsa.zzbip, 0, size);
        for (int i = 0; i < size; i++) {
            if (this.zzbiq[i] != null) {
                zzsa.zzbiq[i] = this.zzbiq[i].clone();
            }
        }
        zzsa.mSize = size;
        return zzsa;
    }

    /* access modifiers changed from: 0000 */
    public void zza(int i, zzsb zzsb) {
        int zzlT = zzlT(i);
        if (zzlT >= 0) {
            this.zzbiq[zzlT] = zzsb;
            return;
        }
        int i2 = zzlT ^ -1;
        if (i2 >= this.mSize || this.zzbiq[i2] != zzbin) {
            if (this.zzbio && this.mSize >= this.zzbip.length) {
                m19gc();
                i2 = zzlT(i) ^ -1;
            }
            if (this.mSize >= this.zzbip.length) {
                int idealIntArraySize = idealIntArraySize(this.mSize + 1);
                int[] iArr = new int[idealIntArraySize];
                zzsb[] zzsbArr = new zzsb[idealIntArraySize];
                System.arraycopy(this.zzbip, 0, iArr, 0, this.zzbip.length);
                System.arraycopy(this.zzbiq, 0, zzsbArr, 0, this.zzbiq.length);
                this.zzbip = iArr;
                this.zzbiq = zzsbArr;
            }
            if (this.mSize - i2 != 0) {
                System.arraycopy(this.zzbip, i2, this.zzbip, i2 + 1, this.mSize - i2);
                System.arraycopy(this.zzbiq, i2, this.zzbiq, i2 + 1, this.mSize - i2);
            }
            this.zzbip[i2] = i;
            this.zzbiq[i2] = zzsb;
            this.mSize++;
            return;
        }
        this.zzbip[i2] = i;
        this.zzbiq[i2] = zzsb;
    }

    /* access modifiers changed from: 0000 */
    public zzsb zzlR(int i) {
        int zzlT = zzlT(i);
        if (zzlT < 0 || this.zzbiq[zzlT] == zzbin) {
            return null;
        }
        return this.zzbiq[zzlT];
    }

    /* access modifiers changed from: 0000 */
    public zzsb zzlS(int i) {
        if (this.zzbio) {
            m19gc();
        }
        return this.zzbiq[i];
    }
}
