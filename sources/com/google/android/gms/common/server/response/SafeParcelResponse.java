package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.C0524zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.internal.zzmj;
import com.google.android.gms.internal.zzmk;
import com.google.android.gms.internal.zzmu;
import com.google.android.gms.internal.zzmv;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SafeParcelResponse extends FastJsonResponse implements SafeParcelable {
    public static final zze CREATOR = new zze();
    private final String mClassName;
    private final int mVersionCode;
    private final FieldMappingDictionary zzahc;
    private final Parcel zzahj;
    private final int zzahk;
    private int zzahl;
    private int zzahm;

    SafeParcelResponse(int versionCode, Parcel parcel, FieldMappingDictionary fieldMappingDictionary) {
        this.mVersionCode = versionCode;
        this.zzahj = (Parcel) zzx.zzw(parcel);
        this.zzahk = 2;
        this.zzahc = fieldMappingDictionary;
        if (this.zzahc == null) {
            this.mClassName = null;
        } else {
            this.mClassName = this.zzahc.zzpT();
        }
        this.zzahl = 2;
    }

    private SafeParcelResponse(SafeParcelable safeParcelable, FieldMappingDictionary dictionary, String className) {
        this.mVersionCode = 1;
        this.zzahj = Parcel.obtain();
        safeParcelable.writeToParcel(this.zzahj, 0);
        this.zzahk = 1;
        this.zzahc = (FieldMappingDictionary) zzx.zzw(dictionary);
        this.mClassName = (String) zzx.zzw(className);
        this.zzahl = 2;
    }

    private static HashMap<Integer, Entry<String, Field<?, ?>>> zzG(Map<String, Field<?, ?>> map) {
        HashMap<Integer, Entry<String, Field<?, ?>>> hashMap = new HashMap<>();
        for (Entry entry : map.entrySet()) {
            hashMap.put(Integer.valueOf(((Field) entry.getValue()).zzpK()), entry);
        }
        return hashMap;
    }

    public static <T extends FastJsonResponse & SafeParcelable> SafeParcelResponse zza(T t) {
        String canonicalName = t.getClass().getCanonicalName();
        return new SafeParcelResponse((SafeParcelable) t, zzb(t), canonicalName);
    }

    private static void zza(FieldMappingDictionary fieldMappingDictionary, FastJsonResponse fastJsonResponse) {
        Class cls = fastJsonResponse.getClass();
        if (!fieldMappingDictionary.zzb(cls)) {
            Map zzpD = fastJsonResponse.zzpD();
            fieldMappingDictionary.zza(cls, zzpD);
            for (String str : zzpD.keySet()) {
                Field field = (Field) zzpD.get(str);
                Class zzpL = field.zzpL();
                if (zzpL != null) {
                    try {
                        zza(fieldMappingDictionary, (FastJsonResponse) zzpL.newInstance());
                    } catch (InstantiationException e) {
                        throw new IllegalStateException("Could not instantiate an object of type " + field.zzpL().getCanonicalName(), e);
                    } catch (IllegalAccessException e2) {
                        throw new IllegalStateException("Could not access object of type " + field.zzpL().getCanonicalName(), e2);
                    }
                }
            }
        }
    }

    private void zza(StringBuilder sb, int i, Object obj) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                sb.append(obj);
                return;
            case 7:
                sb.append("\"").append(zzmu.zzcz(obj.toString())).append("\"");
                return;
            case 8:
                sb.append("\"").append(zzmk.zzi((byte[]) obj)).append("\"");
                return;
            case 9:
                sb.append("\"").append(zzmk.zzj((byte[]) obj));
                sb.append("\"");
                return;
            case 10:
                zzmv.zza(sb, (HashMap) obj);
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown type = " + i);
        }
    }

    private void zza(StringBuilder sb, Field<?, ?> field, Parcel parcel, int i) {
        switch (field.zzpC()) {
            case 0:
                zzb(sb, field, zza(field, Integer.valueOf(zza.zzg(parcel, i))));
                return;
            case 1:
                zzb(sb, field, zza(field, zza.zzk(parcel, i)));
                return;
            case 2:
                zzb(sb, field, zza(field, Long.valueOf(zza.zzi(parcel, i))));
                return;
            case 3:
                zzb(sb, field, zza(field, Float.valueOf(zza.zzl(parcel, i))));
                return;
            case 4:
                zzb(sb, field, zza(field, Double.valueOf(zza.zzn(parcel, i))));
                return;
            case 5:
                zzb(sb, field, zza(field, zza.zzo(parcel, i)));
                return;
            case 6:
                zzb(sb, field, zza(field, Boolean.valueOf(zza.zzc(parcel, i))));
                return;
            case 7:
                zzb(sb, field, zza(field, zza.zzp(parcel, i)));
                return;
            case 8:
            case 9:
                zzb(sb, field, zza(field, zza.zzs(parcel, i)));
                return;
            case 10:
                zzb(sb, field, zza(field, zzi(zza.zzr(parcel, i))));
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown field out type = " + field.zzpC());
        }
    }

    private void zza(StringBuilder sb, String str, Field<?, ?> field, Parcel parcel, int i) {
        sb.append("\"").append(str).append("\":");
        if (field.zzpN()) {
            zza(sb, field, parcel, i);
        } else {
            zzb(sb, field, parcel, i);
        }
    }

    private void zza(StringBuilder sb, Map<String, Field<?, ?>> map, Parcel parcel) {
        HashMap zzG = zzG(map);
        sb.append('{');
        int zzap = zza.zzap(parcel);
        boolean z = false;
        while (parcel.dataPosition() < zzap) {
            int zzao = zza.zzao(parcel);
            Entry entry = (Entry) zzG.get(Integer.valueOf(zza.zzbM(zzao)));
            if (entry != null) {
                if (z) {
                    sb.append(",");
                }
                zza(sb, (String) entry.getKey(), (Field) entry.getValue(), parcel, zzao);
                z = true;
            }
        }
        if (parcel.dataPosition() != zzap) {
            throw new C0524zza("Overread allowed size end=" + zzap, parcel);
        }
        sb.append('}');
    }

    private static FieldMappingDictionary zzb(FastJsonResponse fastJsonResponse) {
        FieldMappingDictionary fieldMappingDictionary = new FieldMappingDictionary(fastJsonResponse.getClass());
        zza(fieldMappingDictionary, fastJsonResponse);
        fieldMappingDictionary.zzpR();
        fieldMappingDictionary.zzpQ();
        return fieldMappingDictionary;
    }

    private void zzb(StringBuilder sb, Field<?, ?> field, Parcel parcel, int i) {
        if (field.zzpI()) {
            sb.append("[");
            switch (field.zzpC()) {
                case 0:
                    zzmj.zza(sb, zza.zzv(parcel, i));
                    break;
                case 1:
                    zzmj.zza(sb, (T[]) zza.zzx(parcel, i));
                    break;
                case 2:
                    zzmj.zza(sb, zza.zzw(parcel, i));
                    break;
                case 3:
                    zzmj.zza(sb, zza.zzy(parcel, i));
                    break;
                case 4:
                    zzmj.zza(sb, zza.zzz(parcel, i));
                    break;
                case 5:
                    zzmj.zza(sb, (T[]) zza.zzA(parcel, i));
                    break;
                case 6:
                    zzmj.zza(sb, zza.zzu(parcel, i));
                    break;
                case 7:
                    zzmj.zza(sb, zza.zzB(parcel, i));
                    break;
                case 8:
                case 9:
                case 10:
                    throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                case 11:
                    Parcel[] zzF = zza.zzF(parcel, i);
                    int length = zzF.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        if (i2 > 0) {
                            sb.append(",");
                        }
                        zzF[i2].setDataPosition(0);
                        zza(sb, field.zzpP(), zzF[i2]);
                    }
                    break;
                default:
                    throw new IllegalStateException("Unknown field type out.");
            }
            sb.append("]");
            return;
        }
        switch (field.zzpC()) {
            case 0:
                sb.append(zza.zzg(parcel, i));
                return;
            case 1:
                sb.append(zza.zzk(parcel, i));
                return;
            case 2:
                sb.append(zza.zzi(parcel, i));
                return;
            case 3:
                sb.append(zza.zzl(parcel, i));
                return;
            case 4:
                sb.append(zza.zzn(parcel, i));
                return;
            case 5:
                sb.append(zza.zzo(parcel, i));
                return;
            case 6:
                sb.append(zza.zzc(parcel, i));
                return;
            case 7:
                sb.append("\"").append(zzmu.zzcz(zza.zzp(parcel, i))).append("\"");
                return;
            case 8:
                sb.append("\"").append(zzmk.zzi(zza.zzs(parcel, i))).append("\"");
                return;
            case 9:
                sb.append("\"").append(zzmk.zzj(zza.zzs(parcel, i)));
                sb.append("\"");
                return;
            case 10:
                Bundle zzr = zza.zzr(parcel, i);
                Set<String> keySet = zzr.keySet();
                keySet.size();
                sb.append("{");
                boolean z = true;
                for (String str : keySet) {
                    if (!z) {
                        sb.append(",");
                    }
                    sb.append("\"").append(str).append("\"");
                    sb.append(":");
                    sb.append("\"").append(zzmu.zzcz(zzr.getString(str))).append("\"");
                    z = false;
                }
                sb.append("}");
                return;
            case 11:
                Parcel zzE = zza.zzE(parcel, i);
                zzE.setDataPosition(0);
                zza(sb, field.zzpP(), zzE);
                return;
            default:
                throw new IllegalStateException("Unknown field type out");
        }
    }

    private void zzb(StringBuilder sb, Field<?, ?> field, Object obj) {
        if (field.zzpH()) {
            zzb(sb, field, (ArrayList) obj);
        } else {
            zza(sb, field.zzpB(), obj);
        }
    }

    private void zzb(StringBuilder sb, Field<?, ?> field, ArrayList<?> arrayList) {
        sb.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                sb.append(",");
            }
            zza(sb, field.zzpB(), arrayList.get(i));
        }
        sb.append("]");
    }

    public static HashMap<String, String> zzi(Bundle bundle) {
        HashMap<String, String> hashMap = new HashMap<>();
        for (String str : bundle.keySet()) {
            hashMap.put(str, bundle.getString(str));
        }
        return hashMap;
    }

    public int describeContents() {
        zze zze = CREATOR;
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        zzx.zzb(this.zzahc, (Object) "Cannot convert to JSON on client side.");
        Parcel zzpV = zzpV();
        zzpV.setDataPosition(0);
        StringBuilder sb = new StringBuilder(100);
        zza(sb, this.zzahc.zzcw(this.mClassName), zzpV);
        return sb.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zze zze = CREATOR;
        zze.zza(this, out, flags);
    }

    /* access modifiers changed from: protected */
    public Object zzcs(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    /* access modifiers changed from: protected */
    public boolean zzct(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public Map<String, Field<?, ?>> zzpD() {
        if (this.zzahc == null) {
            return null;
        }
        return this.zzahc.zzcw(this.mClassName);
    }

    public Parcel zzpV() {
        switch (this.zzahl) {
            case 0:
                this.zzahm = zzb.zzaq(this.zzahj);
                zzb.zzI(this.zzahj, this.zzahm);
                this.zzahl = 2;
                break;
            case 1:
                zzb.zzI(this.zzahj, this.zzahm);
                this.zzahl = 2;
                break;
        }
        return this.zzahj;
    }

    /* access modifiers changed from: 0000 */
    public FieldMappingDictionary zzpW() {
        switch (this.zzahk) {
            case 0:
                return null;
            case 1:
                return this.zzahc;
            case 2:
                return this.zzahc;
            default:
                throw new IllegalStateException("Invalid creation type: " + this.zzahk);
        }
    }
}
