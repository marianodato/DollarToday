package com.google.android.gms.internal;

import android.support.p000v4.media.TransportMediator;
import java.io.IOException;
import java.util.Arrays;

public interface zzsi {

    public static final class zza extends zzry<zza> {
        public String[] zzbiF;
        public String[] zzbiG;
        public int[] zzbiH;
        public long[] zzbiI;

        public zza() {
            zzFS();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zza)) {
                return false;
            }
            zza zza = (zza) o;
            if (!zzsc.equals((Object[]) this.zzbiF, (Object[]) zza.zzbiF) || !zzsc.equals((Object[]) this.zzbiG, (Object[]) zza.zzbiG) || !zzsc.equals(this.zzbiH, zza.zzbiH) || !zzsc.equals(this.zzbiI, zza.zzbiI)) {
                return false;
            }
            if (this.zzbik == null || this.zzbik.isEmpty()) {
                return zza.zzbik == null || zza.zzbik.isEmpty();
            }
            return this.zzbik.equals(zza.zzbik);
        }

        public int hashCode() {
            return ((this.zzbik == null || this.zzbik.isEmpty()) ? 0 : this.zzbik.hashCode()) + ((((((((((getClass().getName().hashCode() + 527) * 31) + zzsc.hashCode((Object[]) this.zzbiF)) * 31) + zzsc.hashCode((Object[]) this.zzbiG)) * 31) + zzsc.hashCode(this.zzbiH)) * 31) + zzsc.hashCode(this.zzbiI)) * 31);
        }

        /* access modifiers changed from: protected */
        public int zzB() {
            int i;
            int zzB = super.zzB();
            if (this.zzbiF == null || this.zzbiF.length <= 0) {
                i = zzB;
            } else {
                int i2 = 0;
                int i3 = 0;
                for (String str : this.zzbiF) {
                    if (str != null) {
                        i3++;
                        i2 += zzrx.zzfA(str);
                    }
                }
                i = zzB + i2 + (i3 * 1);
            }
            if (this.zzbiG != null && this.zzbiG.length > 0) {
                int i4 = 0;
                int i5 = 0;
                for (String str2 : this.zzbiG) {
                    if (str2 != null) {
                        i5++;
                        i4 += zzrx.zzfA(str2);
                    }
                }
                i = i + i4 + (i5 * 1);
            }
            if (this.zzbiH != null && this.zzbiH.length > 0) {
                int i6 = 0;
                for (int zzlJ : this.zzbiH) {
                    i6 += zzrx.zzlJ(zzlJ);
                }
                i = i + i6 + (this.zzbiH.length * 1);
            }
            if (this.zzbiI == null || this.zzbiI.length <= 0) {
                return i;
            }
            int i7 = 0;
            for (long zzaa : this.zzbiI) {
                i7 += zzrx.zzaa(zzaa);
            }
            return i + i7 + (this.zzbiI.length * 1);
        }

        public zza zzFS() {
            this.zzbiF = zzsh.zzbiC;
            this.zzbiG = zzsh.zzbiC;
            this.zzbiH = zzsh.zzbix;
            this.zzbiI = zzsh.zzbiy;
            this.zzbik = null;
            this.zzbiv = -1;
            return this;
        }

        /* renamed from: zzG */
        public zza zzb(zzrw zzrw) throws IOException {
            while (true) {
                int zzFo = zzrw.zzFo();
                switch (zzFo) {
                    case 0:
                        break;
                    case 10:
                        int zzc = zzsh.zzc(zzrw, 10);
                        int length = this.zzbiF == null ? 0 : this.zzbiF.length;
                        String[] strArr = new String[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzbiF, 0, strArr, 0, length);
                        }
                        while (length < strArr.length - 1) {
                            strArr[length] = zzrw.readString();
                            zzrw.zzFo();
                            length++;
                        }
                        strArr[length] = zzrw.readString();
                        this.zzbiF = strArr;
                        continue;
                    case 18:
                        int zzc2 = zzsh.zzc(zzrw, 18);
                        int length2 = this.zzbiG == null ? 0 : this.zzbiG.length;
                        String[] strArr2 = new String[(zzc2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zzbiG, 0, strArr2, 0, length2);
                        }
                        while (length2 < strArr2.length - 1) {
                            strArr2[length2] = zzrw.readString();
                            zzrw.zzFo();
                            length2++;
                        }
                        strArr2[length2] = zzrw.readString();
                        this.zzbiG = strArr2;
                        continue;
                    case 24:
                        int zzc3 = zzsh.zzc(zzrw, 24);
                        int length3 = this.zzbiH == null ? 0 : this.zzbiH.length;
                        int[] iArr = new int[(zzc3 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.zzbiH, 0, iArr, 0, length3);
                        }
                        while (length3 < iArr.length - 1) {
                            iArr[length3] = zzrw.zzFr();
                            zzrw.zzFo();
                            length3++;
                        }
                        iArr[length3] = zzrw.zzFr();
                        this.zzbiH = iArr;
                        continue;
                    case 26:
                        int zzlC = zzrw.zzlC(zzrw.zzFv());
                        int position = zzrw.getPosition();
                        int i = 0;
                        while (zzrw.zzFA() > 0) {
                            zzrw.zzFr();
                            i++;
                        }
                        zzrw.zzlE(position);
                        int length4 = this.zzbiH == null ? 0 : this.zzbiH.length;
                        int[] iArr2 = new int[(i + length4)];
                        if (length4 != 0) {
                            System.arraycopy(this.zzbiH, 0, iArr2, 0, length4);
                        }
                        while (length4 < iArr2.length) {
                            iArr2[length4] = zzrw.zzFr();
                            length4++;
                        }
                        this.zzbiH = iArr2;
                        zzrw.zzlD(zzlC);
                        continue;
                    case 32:
                        int zzc4 = zzsh.zzc(zzrw, 32);
                        int length5 = this.zzbiI == null ? 0 : this.zzbiI.length;
                        long[] jArr = new long[(zzc4 + length5)];
                        if (length5 != 0) {
                            System.arraycopy(this.zzbiI, 0, jArr, 0, length5);
                        }
                        while (length5 < jArr.length - 1) {
                            jArr[length5] = zzrw.zzFq();
                            zzrw.zzFo();
                            length5++;
                        }
                        jArr[length5] = zzrw.zzFq();
                        this.zzbiI = jArr;
                        continue;
                    case 34:
                        int zzlC2 = zzrw.zzlC(zzrw.zzFv());
                        int position2 = zzrw.getPosition();
                        int i2 = 0;
                        while (zzrw.zzFA() > 0) {
                            zzrw.zzFq();
                            i2++;
                        }
                        zzrw.zzlE(position2);
                        int length6 = this.zzbiI == null ? 0 : this.zzbiI.length;
                        long[] jArr2 = new long[(i2 + length6)];
                        if (length6 != 0) {
                            System.arraycopy(this.zzbiI, 0, jArr2, 0, length6);
                        }
                        while (length6 < jArr2.length) {
                            jArr2[length6] = zzrw.zzFq();
                            length6++;
                        }
                        this.zzbiI = jArr2;
                        zzrw.zzlD(zzlC2);
                        continue;
                    default:
                        if (!zza(zzrw, zzFo)) {
                            break;
                        } else {
                            continue;
                        }
                }
            }
            return this;
        }

        public void zza(zzrx zzrx) throws IOException {
            if (this.zzbiF != null && this.zzbiF.length > 0) {
                for (String str : this.zzbiF) {
                    if (str != null) {
                        zzrx.zzb(1, str);
                    }
                }
            }
            if (this.zzbiG != null && this.zzbiG.length > 0) {
                for (String str2 : this.zzbiG) {
                    if (str2 != null) {
                        zzrx.zzb(2, str2);
                    }
                }
            }
            if (this.zzbiH != null && this.zzbiH.length > 0) {
                for (int zzy : this.zzbiH) {
                    zzrx.zzy(3, zzy);
                }
            }
            if (this.zzbiI != null && this.zzbiI.length > 0) {
                for (long zzb : this.zzbiI) {
                    zzrx.zzb(4, zzb);
                }
            }
            super.zza(zzrx);
        }
    }

    public static final class zzb extends zzry<zzb> {
        public String version;
        public int zzbiJ;
        public String zzbiK;

        public zzb() {
            zzFT();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzb)) {
                return false;
            }
            zzb zzb = (zzb) o;
            if (this.zzbiJ != zzb.zzbiJ) {
                return false;
            }
            if (this.zzbiK == null) {
                if (zzb.zzbiK != null) {
                    return false;
                }
            } else if (!this.zzbiK.equals(zzb.zzbiK)) {
                return false;
            }
            if (this.version == null) {
                if (zzb.version != null) {
                    return false;
                }
            } else if (!this.version.equals(zzb.version)) {
                return false;
            }
            if (this.zzbik == null || this.zzbik.isEmpty()) {
                return zzb.zzbik == null || zzb.zzbik.isEmpty();
            }
            return this.zzbik.equals(zzb.zzbik);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.version == null ? 0 : this.version.hashCode()) + (((this.zzbiK == null ? 0 : this.zzbiK.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + this.zzbiJ) * 31)) * 31)) * 31;
            if (this.zzbik != null && !this.zzbik.isEmpty()) {
                i = this.zzbik.hashCode();
            }
            return hashCode + i;
        }

        /* access modifiers changed from: protected */
        public int zzB() {
            int zzB = super.zzB();
            if (this.zzbiJ != 0) {
                zzB += zzrx.zzA(1, this.zzbiJ);
            }
            if (!this.zzbiK.equals("")) {
                zzB += zzrx.zzn(2, this.zzbiK);
            }
            return !this.version.equals("") ? zzB + zzrx.zzn(3, this.version) : zzB;
        }

        public zzb zzFT() {
            this.zzbiJ = 0;
            this.zzbiK = "";
            this.version = "";
            this.zzbik = null;
            this.zzbiv = -1;
            return this;
        }

        /* renamed from: zzH */
        public zzb zzb(zzrw zzrw) throws IOException {
            while (true) {
                int zzFo = zzrw.zzFo();
                switch (zzFo) {
                    case 0:
                        break;
                    case 8:
                        int zzFr = zzrw.zzFr();
                        switch (zzFr) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                            case 9:
                            case 10:
                            case 11:
                            case 12:
                            case 13:
                            case 14:
                            case 15:
                            case 16:
                            case 17:
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                                this.zzbiJ = zzFr;
                                break;
                            default:
                                continue;
                        }
                    case 18:
                        this.zzbiK = zzrw.readString();
                        continue;
                    case 26:
                        this.version = zzrw.readString();
                        continue;
                    default:
                        if (!zza(zzrw, zzFo)) {
                            break;
                        } else {
                            continue;
                        }
                }
            }
            return this;
        }

        public void zza(zzrx zzrx) throws IOException {
            if (this.zzbiJ != 0) {
                zzrx.zzy(1, this.zzbiJ);
            }
            if (!this.zzbiK.equals("")) {
                zzrx.zzb(2, this.zzbiK);
            }
            if (!this.version.equals("")) {
                zzrx.zzb(3, this.version);
            }
            super.zza(zzrx);
        }
    }

    public static final class zzc extends zzry<zzc> {
        public byte[] zzbiL;
        public byte[][] zzbiM;
        public boolean zzbiN;

        public zzc() {
            zzFU();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzc)) {
                return false;
            }
            zzc zzc = (zzc) o;
            if (!Arrays.equals(this.zzbiL, zzc.zzbiL) || !zzsc.zza(this.zzbiM, zzc.zzbiM) || this.zzbiN != zzc.zzbiN) {
                return false;
            }
            if (this.zzbik == null || this.zzbik.isEmpty()) {
                return zzc.zzbik == null || zzc.zzbik.isEmpty();
            }
            return this.zzbik.equals(zzc.zzbik);
        }

        public int hashCode() {
            return ((this.zzbik == null || this.zzbik.isEmpty()) ? 0 : this.zzbik.hashCode()) + (((this.zzbiN ? 1231 : 1237) + ((((((getClass().getName().hashCode() + 527) * 31) + Arrays.hashCode(this.zzbiL)) * 31) + zzsc.zza(this.zzbiM)) * 31)) * 31);
        }

        /* access modifiers changed from: protected */
        public int zzB() {
            int zzB = super.zzB();
            if (!Arrays.equals(this.zzbiL, zzsh.zzbiE)) {
                zzB += zzrx.zzb(1, this.zzbiL);
            }
            if (this.zzbiM != null && this.zzbiM.length > 0) {
                int i = 0;
                int i2 = 0;
                for (byte[] bArr : this.zzbiM) {
                    if (bArr != null) {
                        i2++;
                        i += zzrx.zzE(bArr);
                    }
                }
                zzB = zzB + i + (i2 * 1);
            }
            return this.zzbiN ? zzB + zzrx.zzc(3, this.zzbiN) : zzB;
        }

        public zzc zzFU() {
            this.zzbiL = zzsh.zzbiE;
            this.zzbiM = zzsh.zzbiD;
            this.zzbiN = false;
            this.zzbik = null;
            this.zzbiv = -1;
            return this;
        }

        /* renamed from: zzI */
        public zzc zzb(zzrw zzrw) throws IOException {
            while (true) {
                int zzFo = zzrw.zzFo();
                switch (zzFo) {
                    case 0:
                        break;
                    case 10:
                        this.zzbiL = zzrw.readBytes();
                        continue;
                    case 18:
                        int zzc = zzsh.zzc(zzrw, 18);
                        int length = this.zzbiM == null ? 0 : this.zzbiM.length;
                        byte[][] bArr = new byte[(zzc + length)][];
                        if (length != 0) {
                            System.arraycopy(this.zzbiM, 0, bArr, 0, length);
                        }
                        while (length < bArr.length - 1) {
                            bArr[length] = zzrw.readBytes();
                            zzrw.zzFo();
                            length++;
                        }
                        bArr[length] = zzrw.readBytes();
                        this.zzbiM = bArr;
                        continue;
                    case 24:
                        this.zzbiN = zzrw.zzFs();
                        continue;
                    default:
                        if (!zza(zzrw, zzFo)) {
                            break;
                        } else {
                            continue;
                        }
                }
            }
            return this;
        }

        public void zza(zzrx zzrx) throws IOException {
            if (!Arrays.equals(this.zzbiL, zzsh.zzbiE)) {
                zzrx.zza(1, this.zzbiL);
            }
            if (this.zzbiM != null && this.zzbiM.length > 0) {
                for (byte[] bArr : this.zzbiM) {
                    if (bArr != null) {
                        zzrx.zza(2, bArr);
                    }
                }
            }
            if (this.zzbiN) {
                zzrx.zzb(3, this.zzbiN);
            }
            super.zza(zzrx);
        }
    }

    public static final class zzd extends zzry<zzd> {
        public String tag;
        public long zzbiO;
        public long zzbiP;
        public int zzbiQ;
        public int zzbiR;
        public boolean zzbiS;
        public zze[] zzbiT;
        public zzb zzbiU;
        public byte[] zzbiV;
        public byte[] zzbiW;
        public byte[] zzbiX;
        public zza zzbiY;
        public String zzbiZ;
        public long zzbja;
        public zzc zzbjb;
        public byte[] zzbjc;
        public int zzbjd;
        public int[] zzbje;

        public zzd() {
            zzFV();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzd)) {
                return false;
            }
            zzd zzd = (zzd) o;
            if (this.zzbiO != zzd.zzbiO || this.zzbiP != zzd.zzbiP) {
                return false;
            }
            if (this.tag == null) {
                if (zzd.tag != null) {
                    return false;
                }
            } else if (!this.tag.equals(zzd.tag)) {
                return false;
            }
            if (this.zzbiQ != zzd.zzbiQ || this.zzbiR != zzd.zzbiR || this.zzbiS != zzd.zzbiS || !zzsc.equals((Object[]) this.zzbiT, (Object[]) zzd.zzbiT)) {
                return false;
            }
            if (this.zzbiU == null) {
                if (zzd.zzbiU != null) {
                    return false;
                }
            } else if (!this.zzbiU.equals(zzd.zzbiU)) {
                return false;
            }
            if (!Arrays.equals(this.zzbiV, zzd.zzbiV) || !Arrays.equals(this.zzbiW, zzd.zzbiW) || !Arrays.equals(this.zzbiX, zzd.zzbiX)) {
                return false;
            }
            if (this.zzbiY == null) {
                if (zzd.zzbiY != null) {
                    return false;
                }
            } else if (!this.zzbiY.equals(zzd.zzbiY)) {
                return false;
            }
            if (this.zzbiZ == null) {
                if (zzd.zzbiZ != null) {
                    return false;
                }
            } else if (!this.zzbiZ.equals(zzd.zzbiZ)) {
                return false;
            }
            if (this.zzbja != zzd.zzbja) {
                return false;
            }
            if (this.zzbjb == null) {
                if (zzd.zzbjb != null) {
                    return false;
                }
            } else if (!this.zzbjb.equals(zzd.zzbjb)) {
                return false;
            }
            if (!Arrays.equals(this.zzbjc, zzd.zzbjc) || this.zzbjd != zzd.zzbjd || !zzsc.equals(this.zzbje, zzd.zzbje)) {
                return false;
            }
            if (this.zzbik == null || this.zzbik.isEmpty()) {
                return zzd.zzbik == null || zzd.zzbik.isEmpty();
            }
            return this.zzbik.equals(zzd.zzbik);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((((((this.zzbjb == null ? 0 : this.zzbjb.hashCode()) + (((((this.zzbiZ == null ? 0 : this.zzbiZ.hashCode()) + (((this.zzbiY == null ? 0 : this.zzbiY.hashCode()) + (((((((((this.zzbiU == null ? 0 : this.zzbiU.hashCode()) + (((((this.zzbiS ? 1231 : 1237) + (((((((this.tag == null ? 0 : this.tag.hashCode()) + ((((((getClass().getName().hashCode() + 527) * 31) + ((int) (this.zzbiO ^ (this.zzbiO >>> 32)))) * 31) + ((int) (this.zzbiP ^ (this.zzbiP >>> 32)))) * 31)) * 31) + this.zzbiQ) * 31) + this.zzbiR) * 31)) * 31) + zzsc.hashCode((Object[]) this.zzbiT)) * 31)) * 31) + Arrays.hashCode(this.zzbiV)) * 31) + Arrays.hashCode(this.zzbiW)) * 31) + Arrays.hashCode(this.zzbiX)) * 31)) * 31)) * 31) + ((int) (this.zzbja ^ (this.zzbja >>> 32)))) * 31)) * 31) + Arrays.hashCode(this.zzbjc)) * 31) + this.zzbjd) * 31) + zzsc.hashCode(this.zzbje)) * 31;
            if (this.zzbik != null && !this.zzbik.isEmpty()) {
                i = this.zzbik.hashCode();
            }
            return hashCode + i;
        }

        /* access modifiers changed from: protected */
        public int zzB() {
            int zzB = super.zzB();
            if (this.zzbiO != 0) {
                zzB += zzrx.zzd(1, this.zzbiO);
            }
            if (!this.tag.equals("")) {
                zzB += zzrx.zzn(2, this.tag);
            }
            if (this.zzbiT != null && this.zzbiT.length > 0) {
                int i = zzB;
                for (zze zze : this.zzbiT) {
                    if (zze != null) {
                        i += zzrx.zzc(3, (zzse) zze);
                    }
                }
                zzB = i;
            }
            if (!Arrays.equals(this.zzbiV, zzsh.zzbiE)) {
                zzB += zzrx.zzb(6, this.zzbiV);
            }
            if (this.zzbiY != null) {
                zzB += zzrx.zzc(7, (zzse) this.zzbiY);
            }
            if (!Arrays.equals(this.zzbiW, zzsh.zzbiE)) {
                zzB += zzrx.zzb(8, this.zzbiW);
            }
            if (this.zzbiU != null) {
                zzB += zzrx.zzc(9, (zzse) this.zzbiU);
            }
            if (this.zzbiS) {
                zzB += zzrx.zzc(10, this.zzbiS);
            }
            if (this.zzbiQ != 0) {
                zzB += zzrx.zzA(11, this.zzbiQ);
            }
            if (this.zzbiR != 0) {
                zzB += zzrx.zzA(12, this.zzbiR);
            }
            if (!Arrays.equals(this.zzbiX, zzsh.zzbiE)) {
                zzB += zzrx.zzb(13, this.zzbiX);
            }
            if (!this.zzbiZ.equals("")) {
                zzB += zzrx.zzn(14, this.zzbiZ);
            }
            if (this.zzbja != 180000) {
                zzB += zzrx.zze(15, this.zzbja);
            }
            if (this.zzbjb != null) {
                zzB += zzrx.zzc(16, (zzse) this.zzbjb);
            }
            if (this.zzbiP != 0) {
                zzB += zzrx.zzd(17, this.zzbiP);
            }
            if (!Arrays.equals(this.zzbjc, zzsh.zzbiE)) {
                zzB += zzrx.zzb(18, this.zzbjc);
            }
            if (this.zzbjd != 0) {
                zzB += zzrx.zzA(19, this.zzbjd);
            }
            if (this.zzbje == null || this.zzbje.length <= 0) {
                return zzB;
            }
            int i2 = 0;
            for (int zzlJ : this.zzbje) {
                i2 += zzrx.zzlJ(zzlJ);
            }
            return zzB + i2 + (this.zzbje.length * 2);
        }

        public zzd zzFV() {
            this.zzbiO = 0;
            this.zzbiP = 0;
            this.tag = "";
            this.zzbiQ = 0;
            this.zzbiR = 0;
            this.zzbiS = false;
            this.zzbiT = zze.zzFW();
            this.zzbiU = null;
            this.zzbiV = zzsh.zzbiE;
            this.zzbiW = zzsh.zzbiE;
            this.zzbiX = zzsh.zzbiE;
            this.zzbiY = null;
            this.zzbiZ = "";
            this.zzbja = 180000;
            this.zzbjb = null;
            this.zzbjc = zzsh.zzbiE;
            this.zzbjd = 0;
            this.zzbje = zzsh.zzbix;
            this.zzbik = null;
            this.zzbiv = -1;
            return this;
        }

        /* renamed from: zzJ */
        public zzd zzb(zzrw zzrw) throws IOException {
            while (true) {
                int zzFo = zzrw.zzFo();
                switch (zzFo) {
                    case 0:
                        break;
                    case 8:
                        this.zzbiO = zzrw.zzFq();
                        continue;
                    case 18:
                        this.tag = zzrw.readString();
                        continue;
                    case 26:
                        int zzc = zzsh.zzc(zzrw, 26);
                        int length = this.zzbiT == null ? 0 : this.zzbiT.length;
                        zze[] zzeArr = new zze[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzbiT, 0, zzeArr, 0, length);
                        }
                        while (length < zzeArr.length - 1) {
                            zzeArr[length] = new zze();
                            zzrw.zza(zzeArr[length]);
                            zzrw.zzFo();
                            length++;
                        }
                        zzeArr[length] = new zze();
                        zzrw.zza(zzeArr[length]);
                        this.zzbiT = zzeArr;
                        continue;
                    case 50:
                        this.zzbiV = zzrw.readBytes();
                        continue;
                    case 58:
                        if (this.zzbiY == null) {
                            this.zzbiY = new zza();
                        }
                        zzrw.zza(this.zzbiY);
                        continue;
                    case 66:
                        this.zzbiW = zzrw.readBytes();
                        continue;
                    case 74:
                        if (this.zzbiU == null) {
                            this.zzbiU = new zzb();
                        }
                        zzrw.zza(this.zzbiU);
                        continue;
                    case 80:
                        this.zzbiS = zzrw.zzFs();
                        continue;
                    case 88:
                        this.zzbiQ = zzrw.zzFr();
                        continue;
                    case 96:
                        this.zzbiR = zzrw.zzFr();
                        continue;
                    case 106:
                        this.zzbiX = zzrw.readBytes();
                        continue;
                    case 114:
                        this.zzbiZ = zzrw.readString();
                        continue;
                    case 120:
                        this.zzbja = zzrw.zzFu();
                        continue;
                    case TransportMediator.KEYCODE_MEDIA_RECORD /*130*/:
                        if (this.zzbjb == null) {
                            this.zzbjb = new zzc();
                        }
                        zzrw.zza(this.zzbjb);
                        continue;
                    case 136:
                        this.zzbiP = zzrw.zzFq();
                        continue;
                    case 146:
                        this.zzbjc = zzrw.readBytes();
                        continue;
                    case 152:
                        int zzFr = zzrw.zzFr();
                        switch (zzFr) {
                            case 0:
                            case 1:
                            case 2:
                                this.zzbjd = zzFr;
                                break;
                            default:
                                continue;
                        }
                    case 160:
                        int zzc2 = zzsh.zzc(zzrw, 160);
                        int length2 = this.zzbje == null ? 0 : this.zzbje.length;
                        int[] iArr = new int[(zzc2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zzbje, 0, iArr, 0, length2);
                        }
                        while (length2 < iArr.length - 1) {
                            iArr[length2] = zzrw.zzFr();
                            zzrw.zzFo();
                            length2++;
                        }
                        iArr[length2] = zzrw.zzFr();
                        this.zzbje = iArr;
                        continue;
                    case 162:
                        int zzlC = zzrw.zzlC(zzrw.zzFv());
                        int position = zzrw.getPosition();
                        int i = 0;
                        while (zzrw.zzFA() > 0) {
                            zzrw.zzFr();
                            i++;
                        }
                        zzrw.zzlE(position);
                        int length3 = this.zzbje == null ? 0 : this.zzbje.length;
                        int[] iArr2 = new int[(i + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.zzbje, 0, iArr2, 0, length3);
                        }
                        while (length3 < iArr2.length) {
                            iArr2[length3] = zzrw.zzFr();
                            length3++;
                        }
                        this.zzbje = iArr2;
                        zzrw.zzlD(zzlC);
                        continue;
                    default:
                        if (!zza(zzrw, zzFo)) {
                            break;
                        } else {
                            continue;
                        }
                }
            }
            return this;
        }

        public void zza(zzrx zzrx) throws IOException {
            if (this.zzbiO != 0) {
                zzrx.zzb(1, this.zzbiO);
            }
            if (!this.tag.equals("")) {
                zzrx.zzb(2, this.tag);
            }
            if (this.zzbiT != null && this.zzbiT.length > 0) {
                for (zze zze : this.zzbiT) {
                    if (zze != null) {
                        zzrx.zza(3, (zzse) zze);
                    }
                }
            }
            if (!Arrays.equals(this.zzbiV, zzsh.zzbiE)) {
                zzrx.zza(6, this.zzbiV);
            }
            if (this.zzbiY != null) {
                zzrx.zza(7, (zzse) this.zzbiY);
            }
            if (!Arrays.equals(this.zzbiW, zzsh.zzbiE)) {
                zzrx.zza(8, this.zzbiW);
            }
            if (this.zzbiU != null) {
                zzrx.zza(9, (zzse) this.zzbiU);
            }
            if (this.zzbiS) {
                zzrx.zzb(10, this.zzbiS);
            }
            if (this.zzbiQ != 0) {
                zzrx.zzy(11, this.zzbiQ);
            }
            if (this.zzbiR != 0) {
                zzrx.zzy(12, this.zzbiR);
            }
            if (!Arrays.equals(this.zzbiX, zzsh.zzbiE)) {
                zzrx.zza(13, this.zzbiX);
            }
            if (!this.zzbiZ.equals("")) {
                zzrx.zzb(14, this.zzbiZ);
            }
            if (this.zzbja != 180000) {
                zzrx.zzc(15, this.zzbja);
            }
            if (this.zzbjb != null) {
                zzrx.zza(16, (zzse) this.zzbjb);
            }
            if (this.zzbiP != 0) {
                zzrx.zzb(17, this.zzbiP);
            }
            if (!Arrays.equals(this.zzbjc, zzsh.zzbiE)) {
                zzrx.zza(18, this.zzbjc);
            }
            if (this.zzbjd != 0) {
                zzrx.zzy(19, this.zzbjd);
            }
            if (this.zzbje != null && this.zzbje.length > 0) {
                for (int zzy : this.zzbje) {
                    zzrx.zzy(20, zzy);
                }
            }
            super.zza(zzrx);
        }
    }

    public static final class zze extends zzry<zze> {
        private static volatile zze[] zzbjf;
        public String key;
        public String value;

        public zze() {
            zzFX();
        }

        public static zze[] zzFW() {
            if (zzbjf == null) {
                synchronized (zzsc.zzbiu) {
                    if (zzbjf == null) {
                        zzbjf = new zze[0];
                    }
                }
            }
            return zzbjf;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zze)) {
                return false;
            }
            zze zze = (zze) o;
            if (this.key == null) {
                if (zze.key != null) {
                    return false;
                }
            } else if (!this.key.equals(zze.key)) {
                return false;
            }
            if (this.value == null) {
                if (zze.value != null) {
                    return false;
                }
            } else if (!this.value.equals(zze.value)) {
                return false;
            }
            if (this.zzbik == null || this.zzbik.isEmpty()) {
                return zze.zzbik == null || zze.zzbik.isEmpty();
            }
            return this.zzbik.equals(zze.zzbik);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.value == null ? 0 : this.value.hashCode()) + (((this.key == null ? 0 : this.key.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
            if (this.zzbik != null && !this.zzbik.isEmpty()) {
                i = this.zzbik.hashCode();
            }
            return hashCode + i;
        }

        /* access modifiers changed from: protected */
        public int zzB() {
            int zzB = super.zzB();
            if (!this.key.equals("")) {
                zzB += zzrx.zzn(1, this.key);
            }
            return !this.value.equals("") ? zzB + zzrx.zzn(2, this.value) : zzB;
        }

        public zze zzFX() {
            this.key = "";
            this.value = "";
            this.zzbik = null;
            this.zzbiv = -1;
            return this;
        }

        /* renamed from: zzK */
        public zze zzb(zzrw zzrw) throws IOException {
            while (true) {
                int zzFo = zzrw.zzFo();
                switch (zzFo) {
                    case 0:
                        break;
                    case 10:
                        this.key = zzrw.readString();
                        continue;
                    case 18:
                        this.value = zzrw.readString();
                        continue;
                    default:
                        if (!zza(zzrw, zzFo)) {
                            break;
                        } else {
                            continue;
                        }
                }
            }
            return this;
        }

        public void zza(zzrx zzrx) throws IOException {
            if (!this.key.equals("")) {
                zzrx.zzb(1, this.key);
            }
            if (!this.value.equals("")) {
                zzrx.zzb(2, this.value);
            }
            super.zza(zzrx);
        }
    }
}
