package com.google.android.gms.internal;

import java.io.IOException;

public interface zzox {

    public static final class zza extends zzry<zza> {
        public C0544zza[] zzaCU;

        /* renamed from: com.google.android.gms.internal.zzox$zza$zza reason: collision with other inner class name */
        public static final class C0544zza extends zzry<C0544zza> {
            private static volatile C0544zza[] zzaCV;
            public int viewId;
            public String zzaCW;
            public String zzaCX;

            public C0544zza() {
                zzwe();
            }

            public static C0544zza[] zzwd() {
                if (zzaCV == null) {
                    synchronized (zzsc.zzbiu) {
                        if (zzaCV == null) {
                            zzaCV = new C0544zza[0];
                        }
                    }
                }
                return zzaCV;
            }

            public boolean equals(Object o) {
                if (o == this) {
                    return true;
                }
                if (!(o instanceof C0544zza)) {
                    return false;
                }
                C0544zza zza = (C0544zza) o;
                if (this.zzaCW == null) {
                    if (zza.zzaCW != null) {
                        return false;
                    }
                } else if (!this.zzaCW.equals(zza.zzaCW)) {
                    return false;
                }
                if (this.zzaCX == null) {
                    if (zza.zzaCX != null) {
                        return false;
                    }
                } else if (!this.zzaCX.equals(zza.zzaCX)) {
                    return false;
                }
                if (this.viewId != zza.viewId) {
                    return false;
                }
                if (this.zzbik == null || this.zzbik.isEmpty()) {
                    return zza.zzbik == null || zza.zzbik.isEmpty();
                }
                return this.zzbik.equals(zza.zzbik);
            }

            public int hashCode() {
                int i = 0;
                int hashCode = ((((this.zzaCX == null ? 0 : this.zzaCX.hashCode()) + (((this.zzaCW == null ? 0 : this.zzaCW.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31) + this.viewId) * 31;
                if (this.zzbik != null && !this.zzbik.isEmpty()) {
                    i = this.zzbik.hashCode();
                }
                return hashCode + i;
            }

            /* access modifiers changed from: protected */
            public int zzB() {
                int zzB = super.zzB();
                if (!this.zzaCW.equals("")) {
                    zzB += zzrx.zzn(1, this.zzaCW);
                }
                if (!this.zzaCX.equals("")) {
                    zzB += zzrx.zzn(2, this.zzaCX);
                }
                return this.viewId != 0 ? zzB + zzrx.zzA(3, this.viewId) : zzB;
            }

            public void zza(zzrx zzrx) throws IOException {
                if (!this.zzaCW.equals("")) {
                    zzrx.zzb(1, this.zzaCW);
                }
                if (!this.zzaCX.equals("")) {
                    zzrx.zzb(2, this.zzaCX);
                }
                if (this.viewId != 0) {
                    zzrx.zzy(3, this.viewId);
                }
                super.zza(zzrx);
            }

            /* renamed from: zzq */
            public C0544zza zzb(zzrw zzrw) throws IOException {
                while (true) {
                    int zzFo = zzrw.zzFo();
                    switch (zzFo) {
                        case 0:
                            break;
                        case 10:
                            this.zzaCW = zzrw.readString();
                            continue;
                        case 18:
                            this.zzaCX = zzrw.readString();
                            continue;
                        case 24:
                            this.viewId = zzrw.zzFr();
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

            public C0544zza zzwe() {
                this.zzaCW = "";
                this.zzaCX = "";
                this.viewId = 0;
                this.zzbik = null;
                this.zzbiv = -1;
                return this;
            }
        }

        public zza() {
            zzwc();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zza)) {
                return false;
            }
            zza zza = (zza) o;
            if (!zzsc.equals((Object[]) this.zzaCU, (Object[]) zza.zzaCU)) {
                return false;
            }
            if (this.zzbik == null || this.zzbik.isEmpty()) {
                return zza.zzbik == null || zza.zzbik.isEmpty();
            }
            return this.zzbik.equals(zza.zzbik);
        }

        public int hashCode() {
            return ((this.zzbik == null || this.zzbik.isEmpty()) ? 0 : this.zzbik.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + zzsc.hashCode((Object[]) this.zzaCU)) * 31);
        }

        /* access modifiers changed from: protected */
        public int zzB() {
            int zzB = super.zzB();
            if (this.zzaCU != null && this.zzaCU.length > 0) {
                for (C0544zza zza : this.zzaCU) {
                    if (zza != null) {
                        zzB += zzrx.zzc(1, (zzse) zza);
                    }
                }
            }
            return zzB;
        }

        public void zza(zzrx zzrx) throws IOException {
            if (this.zzaCU != null && this.zzaCU.length > 0) {
                for (C0544zza zza : this.zzaCU) {
                    if (zza != null) {
                        zzrx.zza(1, (zzse) zza);
                    }
                }
            }
            super.zza(zzrx);
        }

        /* renamed from: zzp */
        public zza zzb(zzrw zzrw) throws IOException {
            while (true) {
                int zzFo = zzrw.zzFo();
                switch (zzFo) {
                    case 0:
                        break;
                    case 10:
                        int zzc = zzsh.zzc(zzrw, 10);
                        int length = this.zzaCU == null ? 0 : this.zzaCU.length;
                        C0544zza[] zzaArr = new C0544zza[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzaCU, 0, zzaArr, 0, length);
                        }
                        while (length < zzaArr.length - 1) {
                            zzaArr[length] = new C0544zza();
                            zzrw.zza(zzaArr[length]);
                            zzrw.zzFo();
                            length++;
                        }
                        zzaArr[length] = new C0544zza();
                        zzrw.zza(zzaArr[length]);
                        this.zzaCU = zzaArr;
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

        public zza zzwc() {
            this.zzaCU = C0544zza.zzwd();
            this.zzbik = null;
            this.zzbiv = -1;
            return this;
        }
    }

    public static final class zzb extends zzry<zzb> {
        private static volatile zzb[] zzaCY;
        public String name;
        public zzd zzaCZ;

        public zzb() {
            zzwg();
        }

        public static zzb[] zzwf() {
            if (zzaCY == null) {
                synchronized (zzsc.zzbiu) {
                    if (zzaCY == null) {
                        zzaCY = new zzb[0];
                    }
                }
            }
            return zzaCY;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzb)) {
                return false;
            }
            zzb zzb = (zzb) o;
            if (this.name == null) {
                if (zzb.name != null) {
                    return false;
                }
            } else if (!this.name.equals(zzb.name)) {
                return false;
            }
            if (this.zzaCZ == null) {
                if (zzb.zzaCZ != null) {
                    return false;
                }
            } else if (!this.zzaCZ.equals(zzb.zzaCZ)) {
                return false;
            }
            if (this.zzbik == null || this.zzbik.isEmpty()) {
                return zzb.zzbik == null || zzb.zzbik.isEmpty();
            }
            return this.zzbik.equals(zzb.zzbik);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzaCZ == null ? 0 : this.zzaCZ.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
            if (this.zzbik != null && !this.zzbik.isEmpty()) {
                i = this.zzbik.hashCode();
            }
            return hashCode + i;
        }

        /* access modifiers changed from: protected */
        public int zzB() {
            int zzB = super.zzB();
            if (!this.name.equals("")) {
                zzB += zzrx.zzn(1, this.name);
            }
            return this.zzaCZ != null ? zzB + zzrx.zzc(2, (zzse) this.zzaCZ) : zzB;
        }

        public void zza(zzrx zzrx) throws IOException {
            if (!this.name.equals("")) {
                zzrx.zzb(1, this.name);
            }
            if (this.zzaCZ != null) {
                zzrx.zza(2, (zzse) this.zzaCZ);
            }
            super.zza(zzrx);
        }

        /* renamed from: zzr */
        public zzb zzb(zzrw zzrw) throws IOException {
            while (true) {
                int zzFo = zzrw.zzFo();
                switch (zzFo) {
                    case 0:
                        break;
                    case 10:
                        this.name = zzrw.readString();
                        continue;
                    case 18:
                        if (this.zzaCZ == null) {
                            this.zzaCZ = new zzd();
                        }
                        zzrw.zza(this.zzaCZ);
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

        public zzb zzwg() {
            this.name = "";
            this.zzaCZ = null;
            this.zzbik = null;
            this.zzbiv = -1;
            return this;
        }
    }

    public static final class zzc extends zzry<zzc> {
        public String type;
        public zzb[] zzaDa;

        public zzc() {
            zzwh();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzc)) {
                return false;
            }
            zzc zzc = (zzc) o;
            if (this.type == null) {
                if (zzc.type != null) {
                    return false;
                }
            } else if (!this.type.equals(zzc.type)) {
                return false;
            }
            if (!zzsc.equals((Object[]) this.zzaDa, (Object[]) zzc.zzaDa)) {
                return false;
            }
            if (this.zzbik == null || this.zzbik.isEmpty()) {
                return zzc.zzbik == null || zzc.zzbik.isEmpty();
            }
            return this.zzbik.equals(zzc.zzbik);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((this.type == null ? 0 : this.type.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + zzsc.hashCode((Object[]) this.zzaDa)) * 31;
            if (this.zzbik != null && !this.zzbik.isEmpty()) {
                i = this.zzbik.hashCode();
            }
            return hashCode + i;
        }

        /* access modifiers changed from: protected */
        public int zzB() {
            int zzB = super.zzB();
            if (!this.type.equals("")) {
                zzB += zzrx.zzn(1, this.type);
            }
            if (this.zzaDa == null || this.zzaDa.length <= 0) {
                return zzB;
            }
            int i = zzB;
            for (zzb zzb : this.zzaDa) {
                if (zzb != null) {
                    i += zzrx.zzc(2, (zzse) zzb);
                }
            }
            return i;
        }

        public void zza(zzrx zzrx) throws IOException {
            if (!this.type.equals("")) {
                zzrx.zzb(1, this.type);
            }
            if (this.zzaDa != null && this.zzaDa.length > 0) {
                for (zzb zzb : this.zzaDa) {
                    if (zzb != null) {
                        zzrx.zza(2, (zzse) zzb);
                    }
                }
            }
            super.zza(zzrx);
        }

        /* renamed from: zzs */
        public zzc zzb(zzrw zzrw) throws IOException {
            while (true) {
                int zzFo = zzrw.zzFo();
                switch (zzFo) {
                    case 0:
                        break;
                    case 10:
                        this.type = zzrw.readString();
                        continue;
                    case 18:
                        int zzc = zzsh.zzc(zzrw, 18);
                        int length = this.zzaDa == null ? 0 : this.zzaDa.length;
                        zzb[] zzbArr = new zzb[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzaDa, 0, zzbArr, 0, length);
                        }
                        while (length < zzbArr.length - 1) {
                            zzbArr[length] = new zzb();
                            zzrw.zza(zzbArr[length]);
                            zzrw.zzFo();
                            length++;
                        }
                        zzbArr[length] = new zzb();
                        zzrw.zza(zzbArr[length]);
                        this.zzaDa = zzbArr;
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

        public zzc zzwh() {
            this.type = "";
            this.zzaDa = zzb.zzwf();
            this.zzbik = null;
            this.zzbiv = -1;
            return this;
        }
    }

    public static final class zzd extends zzry<zzd> {
        public boolean zzaDb;
        public long zzaDc;
        public double zzaDd;
        public zzc zzaDe;
        public String zzagS;

        public zzd() {
            zzwi();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzd)) {
                return false;
            }
            zzd zzd = (zzd) o;
            if (this.zzaDb != zzd.zzaDb) {
                return false;
            }
            if (this.zzagS == null) {
                if (zzd.zzagS != null) {
                    return false;
                }
            } else if (!this.zzagS.equals(zzd.zzagS)) {
                return false;
            }
            if (this.zzaDc != zzd.zzaDc || Double.doubleToLongBits(this.zzaDd) != Double.doubleToLongBits(zzd.zzaDd)) {
                return false;
            }
            if (this.zzaDe == null) {
                if (zzd.zzaDe != null) {
                    return false;
                }
            } else if (!this.zzaDe.equals(zzd.zzaDe)) {
                return false;
            }
            if (this.zzbik == null || this.zzbik.isEmpty()) {
                return zzd.zzbik == null || zzd.zzbik.isEmpty();
            }
            return this.zzbik.equals(zzd.zzbik);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = (((this.zzagS == null ? 0 : this.zzagS.hashCode()) + (((this.zzaDb ? 1231 : 1237) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31) + ((int) (this.zzaDc ^ (this.zzaDc >>> 32)));
            long doubleToLongBits = Double.doubleToLongBits(this.zzaDd);
            int hashCode2 = ((this.zzaDe == null ? 0 : this.zzaDe.hashCode()) + (((hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31)) * 31;
            if (this.zzbik != null && !this.zzbik.isEmpty()) {
                i = this.zzbik.hashCode();
            }
            return hashCode2 + i;
        }

        /* access modifiers changed from: protected */
        public int zzB() {
            int zzB = super.zzB();
            if (this.zzaDb) {
                zzB += zzrx.zzc(1, this.zzaDb);
            }
            if (!this.zzagS.equals("")) {
                zzB += zzrx.zzn(2, this.zzagS);
            }
            if (this.zzaDc != 0) {
                zzB += zzrx.zzd(3, this.zzaDc);
            }
            if (Double.doubleToLongBits(this.zzaDd) != Double.doubleToLongBits(0.0d)) {
                zzB += zzrx.zzb(4, this.zzaDd);
            }
            return this.zzaDe != null ? zzB + zzrx.zzc(5, (zzse) this.zzaDe) : zzB;
        }

        public void zza(zzrx zzrx) throws IOException {
            if (this.zzaDb) {
                zzrx.zzb(1, this.zzaDb);
            }
            if (!this.zzagS.equals("")) {
                zzrx.zzb(2, this.zzagS);
            }
            if (this.zzaDc != 0) {
                zzrx.zzb(3, this.zzaDc);
            }
            if (Double.doubleToLongBits(this.zzaDd) != Double.doubleToLongBits(0.0d)) {
                zzrx.zza(4, this.zzaDd);
            }
            if (this.zzaDe != null) {
                zzrx.zza(5, (zzse) this.zzaDe);
            }
            super.zza(zzrx);
        }

        /* renamed from: zzt */
        public zzd zzb(zzrw zzrw) throws IOException {
            while (true) {
                int zzFo = zzrw.zzFo();
                switch (zzFo) {
                    case 0:
                        break;
                    case 8:
                        this.zzaDb = zzrw.zzFs();
                        continue;
                    case 18:
                        this.zzagS = zzrw.readString();
                        continue;
                    case 24:
                        this.zzaDc = zzrw.zzFq();
                        continue;
                    case 33:
                        this.zzaDd = zzrw.readDouble();
                        continue;
                    case 42:
                        if (this.zzaDe == null) {
                            this.zzaDe = new zzc();
                        }
                        zzrw.zza(this.zzaDe);
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

        public zzd zzwi() {
            this.zzaDb = false;
            this.zzagS = "";
            this.zzaDc = 0;
            this.zzaDd = 0.0d;
            this.zzaDe = null;
            this.zzbik = null;
            this.zzbiv = -1;
            return this;
        }
    }
}
