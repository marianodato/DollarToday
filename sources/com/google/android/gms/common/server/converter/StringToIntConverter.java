package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse.zza;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class StringToIntConverter implements SafeParcelable, zza<String, Integer> {
    public static final zzb CREATOR = new zzb();
    private final int mVersionCode;
    private final HashMap<String, Integer> zzagP;
    private final HashMap<Integer, String> zzagQ;
    private final ArrayList<Entry> zzagR;

    public static final class Entry implements SafeParcelable {
        public static final zzc CREATOR = new zzc();
        final int versionCode;
        final String zzagS;
        final int zzagT;

        Entry(int versionCode2, String stringValue, int intValue) {
            this.versionCode = versionCode2;
            this.zzagS = stringValue;
            this.zzagT = intValue;
        }

        Entry(String stringValue, int intValue) {
            this.versionCode = 1;
            this.zzagS = stringValue;
            this.zzagT = intValue;
        }

        public int describeContents() {
            zzc zzc = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            zzc zzc = CREATOR;
            zzc.zza(this, out, flags);
        }
    }

    public StringToIntConverter() {
        this.mVersionCode = 1;
        this.zzagP = new HashMap<>();
        this.zzagQ = new HashMap<>();
        this.zzagR = null;
    }

    StringToIntConverter(int versionCode, ArrayList<Entry> serializedMap) {
        this.mVersionCode = versionCode;
        this.zzagP = new HashMap<>();
        this.zzagQ = new HashMap<>();
        this.zzagR = null;
        zzb(serializedMap);
    }

    private void zzb(ArrayList<Entry> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            zzi(entry.zzagS, entry.zzagT);
        }
    }

    public int describeContents() {
        zzb zzb = CREATOR;
        return 0;
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzb zzb = CREATOR;
        zzb.zza(this, out, flags);
    }

    /* renamed from: zzb */
    public String convertBack(Integer num) {
        String str = (String) this.zzagQ.get(num);
        return (str != null || !this.zzagP.containsKey("gms_unknown")) ? str : "gms_unknown";
    }

    public StringToIntConverter zzi(String str, int i) {
        this.zzagP.put(str, Integer.valueOf(i));
        this.zzagQ.put(Integer.valueOf(i), str);
        return this;
    }

    /* access modifiers changed from: 0000 */
    public ArrayList<Entry> zzpA() {
        ArrayList<Entry> arrayList = new ArrayList<>();
        for (String str : this.zzagP.keySet()) {
            arrayList.add(new Entry(str, ((Integer) this.zzagP.get(str)).intValue()));
        }
        return arrayList;
    }

    public int zzpB() {
        return 7;
    }

    public int zzpC() {
        return 0;
    }
}
