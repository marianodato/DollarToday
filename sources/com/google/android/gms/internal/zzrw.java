package com.google.android.gms.internal;

import java.io.IOException;

public final class zzrw {
    private final byte[] buffer;
    private int zzbia;
    private int zzbib;
    private int zzbic;
    private int zzbid;
    private int zzbie;
    private int zzbif = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int zzbig;
    private int zzbih = 64;
    private int zzbii = 67108864;

    private zzrw(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.zzbia = i;
        this.zzbib = i + i2;
        this.zzbid = i;
    }

    public static zzrw zzB(byte[] bArr) {
        return zza(bArr, 0, bArr.length);
    }

    private void zzFz() {
        this.zzbib += this.zzbic;
        int i = this.zzbib;
        if (i > this.zzbif) {
            this.zzbic = i - this.zzbif;
            this.zzbib -= this.zzbic;
            return;
        }
        this.zzbic = 0;
    }

    public static long zzX(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }

    public static zzrw zza(byte[] bArr, int i, int i2) {
        return new zzrw(bArr, i, i2);
    }

    public static int zzlB(int i) {
        return (i >>> 1) ^ (-(i & 1));
    }

    public int getPosition() {
        return this.zzbid - this.zzbia;
    }

    public byte[] readBytes() throws IOException {
        int zzFv = zzFv();
        if (zzFv > this.zzbib - this.zzbid || zzFv <= 0) {
            return zzFv == 0 ? zzsh.zzbiE : zzlF(zzFv);
        }
        byte[] bArr = new byte[zzFv];
        System.arraycopy(this.buffer, this.zzbid, bArr, 0, zzFv);
        this.zzbid = zzFv + this.zzbid;
        return bArr;
    }

    public double readDouble() throws IOException {
        return Double.longBitsToDouble(zzFy());
    }

    public float readFloat() throws IOException {
        return Float.intBitsToFloat(zzFx());
    }

    public String readString() throws IOException {
        int zzFv = zzFv();
        if (zzFv > this.zzbib - this.zzbid || zzFv <= 0) {
            return new String(zzlF(zzFv), "UTF-8");
        }
        String str = new String(this.buffer, this.zzbid, zzFv, "UTF-8");
        this.zzbid = zzFv + this.zzbid;
        return str;
    }

    public int zzFA() {
        if (this.zzbif == Integer.MAX_VALUE) {
            return -1;
        }
        return this.zzbif - this.zzbid;
    }

    public boolean zzFB() {
        return this.zzbid == this.zzbib;
    }

    public byte zzFC() throws IOException {
        if (this.zzbid == this.zzbib) {
            throw zzsd.zzFJ();
        }
        byte[] bArr = this.buffer;
        int i = this.zzbid;
        this.zzbid = i + 1;
        return bArr[i];
    }

    public int zzFo() throws IOException {
        if (zzFB()) {
            this.zzbie = 0;
            return 0;
        }
        this.zzbie = zzFv();
        if (this.zzbie != 0) {
            return this.zzbie;
        }
        throw zzsd.zzFM();
    }

    public void zzFp() throws IOException {
        int zzFo;
        do {
            zzFo = zzFo();
            if (zzFo == 0) {
                return;
            }
        } while (zzlA(zzFo));
    }

    public long zzFq() throws IOException {
        return zzFw();
    }

    public int zzFr() throws IOException {
        return zzFv();
    }

    public boolean zzFs() throws IOException {
        return zzFv() != 0;
    }

    public int zzFt() throws IOException {
        return zzlB(zzFv());
    }

    public long zzFu() throws IOException {
        return zzX(zzFw());
    }

    public int zzFv() throws IOException {
        byte zzFC = zzFC();
        if (zzFC >= 0) {
            return zzFC;
        }
        byte b = zzFC & Byte.MAX_VALUE;
        byte zzFC2 = zzFC();
        if (zzFC2 >= 0) {
            return b | (zzFC2 << 7);
        }
        byte b2 = b | ((zzFC2 & Byte.MAX_VALUE) << 7);
        byte zzFC3 = zzFC();
        if (zzFC3 >= 0) {
            return b2 | (zzFC3 << 14);
        }
        byte b3 = b2 | ((zzFC3 & Byte.MAX_VALUE) << 14);
        byte zzFC4 = zzFC();
        if (zzFC4 >= 0) {
            return b3 | (zzFC4 << 21);
        }
        byte b4 = b3 | ((zzFC4 & Byte.MAX_VALUE) << 21);
        byte zzFC5 = zzFC();
        byte b5 = b4 | (zzFC5 << 28);
        if (zzFC5 >= 0) {
            return b5;
        }
        for (int i = 0; i < 5; i++) {
            if (zzFC() >= 0) {
                return b5;
            }
        }
        throw zzsd.zzFL();
    }

    public long zzFw() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzFC = zzFC();
            j |= ((long) (zzFC & Byte.MAX_VALUE)) << i;
            if ((zzFC & 128) == 0) {
                return j;
            }
        }
        throw zzsd.zzFL();
    }

    public int zzFx() throws IOException {
        return (zzFC() & 255) | ((zzFC() & 255) << 8) | ((zzFC() & 255) << 16) | ((zzFC() & 255) << 24);
    }

    public long zzFy() throws IOException {
        byte zzFC = zzFC();
        byte zzFC2 = zzFC();
        return ((((long) zzFC2) & 255) << 8) | (((long) zzFC) & 255) | ((((long) zzFC()) & 255) << 16) | ((((long) zzFC()) & 255) << 24) | ((((long) zzFC()) & 255) << 32) | ((((long) zzFC()) & 255) << 40) | ((((long) zzFC()) & 255) << 48) | ((((long) zzFC()) & 255) << 56);
    }

    public void zza(zzse zzse) throws IOException {
        int zzFv = zzFv();
        if (this.zzbig >= this.zzbih) {
            throw zzsd.zzFP();
        }
        int zzlC = zzlC(zzFv);
        this.zzbig++;
        zzse.zzb(this);
        zzlz(0);
        this.zzbig--;
        zzlD(zzlC);
    }

    public void zza(zzse zzse, int i) throws IOException {
        if (this.zzbig >= this.zzbih) {
            throw zzsd.zzFP();
        }
        this.zzbig++;
        zzse.zzb(this);
        zzlz(zzsh.zzD(i, 4));
        this.zzbig--;
    }

    public boolean zzlA(int i) throws IOException {
        switch (zzsh.zzlU(i)) {
            case 0:
                zzFr();
                return true;
            case 1:
                zzFy();
                return true;
            case 2:
                zzlG(zzFv());
                return true;
            case 3:
                zzFp();
                zzlz(zzsh.zzD(zzsh.zzlV(i), 4));
                return true;
            case 4:
                return false;
            case 5:
                zzFx();
                return true;
            default:
                throw zzsd.zzFO();
        }
    }

    public int zzlC(int i) throws zzsd {
        if (i < 0) {
            throw zzsd.zzFK();
        }
        int i2 = this.zzbid + i;
        int i3 = this.zzbif;
        if (i2 > i3) {
            throw zzsd.zzFJ();
        }
        this.zzbif = i2;
        zzFz();
        return i3;
    }

    public void zzlD(int i) {
        this.zzbif = i;
        zzFz();
    }

    public void zzlE(int i) {
        if (i > this.zzbid - this.zzbia) {
            throw new IllegalArgumentException("Position " + i + " is beyond current " + (this.zzbid - this.zzbia));
        } else if (i < 0) {
            throw new IllegalArgumentException("Bad position " + i);
        } else {
            this.zzbid = this.zzbia + i;
        }
    }

    public byte[] zzlF(int i) throws IOException {
        if (i < 0) {
            throw zzsd.zzFK();
        } else if (this.zzbid + i > this.zzbif) {
            zzlG(this.zzbif - this.zzbid);
            throw zzsd.zzFJ();
        } else if (i <= this.zzbib - this.zzbid) {
            byte[] bArr = new byte[i];
            System.arraycopy(this.buffer, this.zzbid, bArr, 0, i);
            this.zzbid += i;
            return bArr;
        } else {
            throw zzsd.zzFJ();
        }
    }

    public void zzlG(int i) throws IOException {
        if (i < 0) {
            throw zzsd.zzFK();
        } else if (this.zzbid + i > this.zzbif) {
            zzlG(this.zzbif - this.zzbid);
            throw zzsd.zzFJ();
        } else if (i <= this.zzbib - this.zzbid) {
            this.zzbid += i;
        } else {
            throw zzsd.zzFJ();
        }
    }

    public void zzlz(int i) throws zzsd {
        if (this.zzbie != i) {
            throw zzsd.zzFN();
        }
    }

    public byte[] zzx(int i, int i2) {
        if (i2 == 0) {
            return zzsh.zzbiE;
        }
        byte[] bArr = new byte[i2];
        System.arraycopy(this.buffer, this.zzbia + i, bArr, 0, i2);
        return bArr;
    }
}
