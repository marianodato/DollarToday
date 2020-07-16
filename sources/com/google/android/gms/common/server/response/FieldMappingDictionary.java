package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FieldMappingDictionary implements SafeParcelable {
    public static final zzc CREATOR = new zzc();
    private final int mVersionCode;
    private final HashMap<String, Map<String, Field<?, ?>>> zzahe;
    private final ArrayList<Entry> zzahf;
    private final String zzahg;

    public static class Entry implements SafeParcelable {
        public static final zzd CREATOR = new zzd();
        final String className;
        final int versionCode;
        final ArrayList<FieldMapPair> zzahh;

        Entry(int versionCode2, String className2, ArrayList<FieldMapPair> fieldMapping) {
            this.versionCode = versionCode2;
            this.className = className2;
            this.zzahh = fieldMapping;
        }

        Entry(String className2, Map<String, Field<?, ?>> fieldMap) {
            this.versionCode = 1;
            this.className = className2;
            this.zzahh = zzF(fieldMap);
        }

        private static ArrayList<FieldMapPair> zzF(Map<String, Field<?, ?>> map) {
            if (map == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (String str : map.keySet()) {
                arrayList.add(new FieldMapPair(str, (Field) map.get(str)));
            }
            return arrayList;
        }

        public int describeContents() {
            zzd zzd = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            zzd zzd = CREATOR;
            zzd.zza(this, out, flags);
        }

        /* access modifiers changed from: 0000 */
        public HashMap<String, Field<?, ?>> zzpU() {
            HashMap<String, Field<?, ?>> hashMap = new HashMap<>();
            int size = this.zzahh.size();
            for (int i = 0; i < size; i++) {
                FieldMapPair fieldMapPair = (FieldMapPair) this.zzahh.get(i);
                hashMap.put(fieldMapPair.key, fieldMapPair.zzahi);
            }
            return hashMap;
        }
    }

    public static class FieldMapPair implements SafeParcelable {
        public static final zzb CREATOR = new zzb();
        final String key;
        final int versionCode;
        final Field<?, ?> zzahi;

        FieldMapPair(int versionCode2, String key2, Field<?, ?> value) {
            this.versionCode = versionCode2;
            this.key = key2;
            this.zzahi = value;
        }

        FieldMapPair(String key2, Field<?, ?> value) {
            this.versionCode = 1;
            this.key = key2;
            this.zzahi = value;
        }

        public int describeContents() {
            zzb zzb = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            zzb zzb = CREATOR;
            zzb.zza(this, out, flags);
        }
    }

    FieldMappingDictionary(int versionCode, ArrayList<Entry> serializedDictionary, String rootClassName) {
        this.mVersionCode = versionCode;
        this.zzahf = null;
        this.zzahe = zzc(serializedDictionary);
        this.zzahg = (String) zzx.zzw(rootClassName);
        zzpQ();
    }

    public FieldMappingDictionary(Class<? extends FastJsonResponse> rootClazz) {
        this.mVersionCode = 1;
        this.zzahf = null;
        this.zzahe = new HashMap<>();
        this.zzahg = rootClazz.getCanonicalName();
    }

    private static HashMap<String, Map<String, Field<?, ?>>> zzc(ArrayList<Entry> arrayList) {
        HashMap<String, Map<String, Field<?, ?>>> hashMap = new HashMap<>();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Entry entry = (Entry) arrayList.get(i);
            hashMap.put(entry.className, entry.zzpU());
        }
        return hashMap;
    }

    public int describeContents() {
        zzc zzc = CREATOR;
        return 0;
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String str : this.zzahe.keySet()) {
            sb.append(str).append(":\n");
            Map map = (Map) this.zzahe.get(str);
            for (String str2 : map.keySet()) {
                sb.append("  ").append(str2).append(": ");
                sb.append(map.get(str2));
            }
        }
        return sb.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zzc zzc = CREATOR;
        zzc.zza(this, out, flags);
    }

    public void zza(Class<? extends FastJsonResponse> cls, Map<String, Field<?, ?>> map) {
        this.zzahe.put(cls.getCanonicalName(), map);
    }

    public boolean zzb(Class<? extends FastJsonResponse> cls) {
        return this.zzahe.containsKey(cls.getCanonicalName());
    }

    public Map<String, Field<?, ?>> zzcw(String str) {
        return (Map) this.zzahe.get(str);
    }

    public void zzpQ() {
        for (String str : this.zzahe.keySet()) {
            Map map = (Map) this.zzahe.get(str);
            for (String str2 : map.keySet()) {
                ((Field) map.get(str2)).zza(this);
            }
        }
    }

    public void zzpR() {
        for (String str : this.zzahe.keySet()) {
            Map map = (Map) this.zzahe.get(str);
            HashMap hashMap = new HashMap();
            for (String str2 : map.keySet()) {
                hashMap.put(str2, ((Field) map.get(str2)).zzpG());
            }
            this.zzahe.put(str, hashMap);
        }
    }

    /* access modifiers changed from: 0000 */
    public ArrayList<Entry> zzpS() {
        ArrayList<Entry> arrayList = new ArrayList<>();
        for (String str : this.zzahe.keySet()) {
            arrayList.add(new Entry(str, (Map) this.zzahe.get(str)));
        }
        return arrayList;
    }

    public String zzpT() {
        return this.zzahg;
    }
}
