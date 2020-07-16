package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class RegisterSectionInfo implements SafeParcelable {
    public static final zzi CREATOR = new zzi();
    final int mVersionCode;
    public final String name;
    public final int weight;
    public final String zzQF;
    public final boolean zzQG;
    public final boolean zzQH;
    public final String zzQI;
    public final Feature[] zzQJ;
    final int[] zzQK;
    public final String zzQL;

    public static final class zza {
        private final String mName;
        private String zzQM;
        private boolean zzQN;
        private int zzQO = 1;
        private boolean zzQP;
        private String zzQQ;
        private final List<Feature> zzQR = new ArrayList();
        private BitSet zzQS;
        private String zzQT;

        public zza(String str) {
            this.mName = str;
        }

        public zza zzM(boolean z) {
            this.zzQN = z;
            return this;
        }

        public zza zzN(boolean z) {
            this.zzQP = z;
            return this;
        }

        public zza zzal(int i) {
            if (this.zzQS == null) {
                this.zzQS = new BitSet();
            }
            this.zzQS.set(i);
            return this;
        }

        public zza zzbA(String str) {
            this.zzQM = str;
            return this;
        }

        public zza zzbB(String str) {
            this.zzQT = str;
            return this;
        }

        public RegisterSectionInfo zzlt() {
            int i = 0;
            int[] iArr = null;
            if (this.zzQS != null) {
                iArr = new int[this.zzQS.cardinality()];
                int nextSetBit = this.zzQS.nextSetBit(0);
                while (nextSetBit >= 0) {
                    int i2 = i + 1;
                    iArr[i] = nextSetBit;
                    nextSetBit = this.zzQS.nextSetBit(nextSetBit + 1);
                    i = i2;
                }
            }
            return new RegisterSectionInfo(this.mName, this.zzQM, this.zzQN, this.zzQO, this.zzQP, this.zzQQ, (Feature[]) this.zzQR.toArray(new Feature[this.zzQR.size()]), iArr, this.zzQT);
        }
    }

    RegisterSectionInfo(int versionCode, String name2, String format, boolean noIndex, int weight2, boolean indexPrefixes, String subsectionSeparator, Feature[] features, int[] semanticLabels, String schemaOrgProperty) {
        this.mVersionCode = versionCode;
        this.name = name2;
        this.zzQF = format;
        this.zzQG = noIndex;
        this.weight = weight2;
        this.zzQH = indexPrefixes;
        this.zzQI = subsectionSeparator;
        this.zzQJ = features;
        this.zzQK = semanticLabels;
        this.zzQL = schemaOrgProperty;
    }

    RegisterSectionInfo(String name2, String format, boolean noIndex, int weight2, boolean indexPrefixes, String subsectionSeparator, Feature[] features, int[] semanticLabels, String schemaOrgProperty) {
        this(2, name2, format, noIndex, weight2, indexPrefixes, subsectionSeparator, features, semanticLabels, schemaOrgProperty);
    }

    public int describeContents() {
        zzi zzi = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzi zzi = CREATOR;
        zzi.zza(this, out, flags);
    }
}
