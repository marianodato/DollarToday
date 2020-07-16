package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.server.converter.ConverterWrapper;
import com.google.android.gms.internal.zzmk;
import com.google.android.gms.internal.zzmu;
import com.google.android.gms.internal.zzmv;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class FastJsonResponse {

    public static class Field<I, O> implements SafeParcelable {
        public static final zza CREATOR = new zza();
        private final int mVersionCode;
        protected final int zzagU;
        protected final boolean zzagV;
        protected final int zzagW;
        protected final boolean zzagX;
        protected final String zzagY;
        protected final int zzagZ;
        protected final Class<? extends FastJsonResponse> zzaha;
        protected final String zzahb;
        private FieldMappingDictionary zzahc;
        /* access modifiers changed from: private */
        public zza<I, O> zzahd;

        Field(int versionCode, int typeIn, boolean typeInArray, int typeOut, boolean typeOutArray, String outputFieldName, int safeParcelableFieldId, String concreteTypeName, ConverterWrapper wrappedConverter) {
            this.mVersionCode = versionCode;
            this.zzagU = typeIn;
            this.zzagV = typeInArray;
            this.zzagW = typeOut;
            this.zzagX = typeOutArray;
            this.zzagY = outputFieldName;
            this.zzagZ = safeParcelableFieldId;
            if (concreteTypeName == null) {
                this.zzaha = null;
                this.zzahb = null;
            } else {
                this.zzaha = SafeParcelResponse.class;
                this.zzahb = concreteTypeName;
            }
            if (wrappedConverter == null) {
                this.zzahd = null;
            } else {
                this.zzahd = wrappedConverter.zzpz();
            }
        }

        protected Field(int typeIn, boolean typeInArray, int typeOut, boolean typeOutArray, String outputFieldName, int safeParcelableFieldId, Class<? extends FastJsonResponse> concreteType, zza<I, O> converter) {
            this.mVersionCode = 1;
            this.zzagU = typeIn;
            this.zzagV = typeInArray;
            this.zzagW = typeOut;
            this.zzagX = typeOutArray;
            this.zzagY = outputFieldName;
            this.zzagZ = safeParcelableFieldId;
            this.zzaha = concreteType;
            if (concreteType == null) {
                this.zzahb = null;
            } else {
                this.zzahb = concreteType.getCanonicalName();
            }
            this.zzahd = converter;
        }

        public static Field zza(String str, int i, zza<?, ?> zza, boolean z) {
            return new Field(zza.zzpB(), z, zza.zzpC(), false, str, i, null, zza);
        }

        public static <T extends FastJsonResponse> Field<T, T> zza(String str, int i, Class<T> cls) {
            return new Field<>(11, false, 11, false, str, i, cls, null);
        }

        public static <T extends FastJsonResponse> Field<ArrayList<T>, ArrayList<T>> zzb(String str, int i, Class<T> cls) {
            return new Field<>(11, true, 11, true, str, i, cls, null);
        }

        public static Field<Integer, Integer> zzj(String str, int i) {
            return new Field<>(0, false, 0, false, str, i, null, null);
        }

        public static Field<Double, Double> zzk(String str, int i) {
            return new Field<>(4, false, 4, false, str, i, null, null);
        }

        public static Field<Boolean, Boolean> zzl(String str, int i) {
            return new Field<>(6, false, 6, false, str, i, null, null);
        }

        public static Field<String, String> zzm(String str, int i) {
            return new Field<>(7, false, 7, false, str, i, null, null);
        }

        public static Field<ArrayList<String>, ArrayList<String>> zzn(String str, int i) {
            return new Field<>(7, true, 7, true, str, i, null, null);
        }

        public I convertBack(O output) {
            return this.zzahd.convertBack(output);
        }

        public int describeContents() {
            zza zza = CREATOR;
            return 0;
        }

        public int getVersionCode() {
            return this.mVersionCode;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Field\n");
            sb.append("            versionCode=").append(this.mVersionCode).append(10);
            sb.append("                 typeIn=").append(this.zzagU).append(10);
            sb.append("            typeInArray=").append(this.zzagV).append(10);
            sb.append("                typeOut=").append(this.zzagW).append(10);
            sb.append("           typeOutArray=").append(this.zzagX).append(10);
            sb.append("        outputFieldName=").append(this.zzagY).append(10);
            sb.append("      safeParcelFieldId=").append(this.zzagZ).append(10);
            sb.append("       concreteTypeName=").append(zzpM()).append(10);
            if (zzpL() != null) {
                sb.append("     concreteType.class=").append(zzpL().getCanonicalName()).append(10);
            }
            sb.append("          converterName=").append(this.zzahd == null ? "null" : this.zzahd.getClass().getCanonicalName()).append(10);
            return sb.toString();
        }

        public void writeToParcel(Parcel out, int flags) {
            zza zza = CREATOR;
            zza.zza(this, out, flags);
        }

        public void zza(FieldMappingDictionary fieldMappingDictionary) {
            this.zzahc = fieldMappingDictionary;
        }

        public int zzpB() {
            return this.zzagU;
        }

        public int zzpC() {
            return this.zzagW;
        }

        public Field<I, O> zzpG() {
            return new Field<>(this.mVersionCode, this.zzagU, this.zzagV, this.zzagW, this.zzagX, this.zzagY, this.zzagZ, this.zzahb, zzpO());
        }

        public boolean zzpH() {
            return this.zzagV;
        }

        public boolean zzpI() {
            return this.zzagX;
        }

        public String zzpJ() {
            return this.zzagY;
        }

        public int zzpK() {
            return this.zzagZ;
        }

        public Class<? extends FastJsonResponse> zzpL() {
            return this.zzaha;
        }

        /* access modifiers changed from: 0000 */
        public String zzpM() {
            if (this.zzahb == null) {
                return null;
            }
            return this.zzahb;
        }

        public boolean zzpN() {
            return this.zzahd != null;
        }

        /* access modifiers changed from: 0000 */
        public ConverterWrapper zzpO() {
            if (this.zzahd == null) {
                return null;
            }
            return ConverterWrapper.zza(this.zzahd);
        }

        public Map<String, Field<?, ?>> zzpP() {
            zzx.zzw(this.zzahb);
            zzx.zzw(this.zzahc);
            return this.zzahc.zzcw(this.zzahb);
        }
    }

    public interface zza<I, O> {
        I convertBack(O o);

        int zzpB();

        int zzpC();
    }

    private void zza(StringBuilder sb, Field field, Object obj) {
        if (field.zzpB() == 11) {
            sb.append(((FastJsonResponse) field.zzpL().cast(obj)).toString());
        } else if (field.zzpB() == 7) {
            sb.append("\"");
            sb.append(zzmu.zzcz((String) obj));
            sb.append("\"");
        } else {
            sb.append(obj);
        }
    }

    private void zza(StringBuilder sb, Field field, ArrayList<Object> arrayList) {
        sb.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append(",");
            }
            Object obj = arrayList.get(i);
            if (obj != null) {
                zza(sb, field, obj);
            }
        }
        sb.append("]");
    }

    public String toString() {
        Map zzpD = zzpD();
        StringBuilder sb = new StringBuilder(100);
        for (String str : zzpD.keySet()) {
            Field field = (Field) zzpD.get(str);
            if (zza(field)) {
                Object zza2 = zza(field, zzb(field));
                if (sb.length() == 0) {
                    sb.append("{");
                } else {
                    sb.append(",");
                }
                sb.append("\"").append(str).append("\":");
                if (zza2 != null) {
                    switch (field.zzpC()) {
                        case 8:
                            sb.append("\"").append(zzmk.zzi((byte[]) zza2)).append("\"");
                            break;
                        case 9:
                            sb.append("\"").append(zzmk.zzj((byte[]) zza2)).append("\"");
                            break;
                        case 10:
                            zzmv.zza(sb, (HashMap) zza2);
                            break;
                        default:
                            if (!field.zzpH()) {
                                zza(sb, field, zza2);
                                break;
                            } else {
                                zza(sb, field, (ArrayList) zza2);
                                break;
                            }
                    }
                } else {
                    sb.append("null");
                }
            }
        }
        if (sb.length() > 0) {
            sb.append("}");
        } else {
            sb.append("{}");
        }
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public <O, I> I zza(Field<I, O> field, Object obj) {
        return field.zzahd != null ? field.convertBack(obj) : obj;
    }

    /* access modifiers changed from: protected */
    public boolean zza(Field field) {
        return field.zzpC() == 11 ? field.zzpI() ? zzcv(field.zzpJ()) : zzcu(field.zzpJ()) : zzct(field.zzpJ());
    }

    /* access modifiers changed from: protected */
    public Object zzb(Field field) {
        String zzpJ = field.zzpJ();
        if (field.zzpL() == null) {
            return zzcs(field.zzpJ());
        }
        zzx.zza(zzcs(field.zzpJ()) == null, "Concrete field shouldn't be value object: %s", field.zzpJ());
        HashMap zzpE = field.zzpI() ? zzpF() : zzpE();
        if (zzpE != null) {
            return zzpE.get(zzpJ);
        }
        try {
            return getClass().getMethod("get" + Character.toUpperCase(zzpJ.charAt(0)) + zzpJ.substring(1), new Class[0]).invoke(this, new Object[0]);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /* access modifiers changed from: protected */
    public abstract Object zzcs(String str);

    /* access modifiers changed from: protected */
    public abstract boolean zzct(String str);

    /* access modifiers changed from: protected */
    public boolean zzcu(String str) {
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    /* access modifiers changed from: protected */
    public boolean zzcv(String str) {
        throw new UnsupportedOperationException("Concrete type arrays not supported");
    }

    public abstract Map<String, Field<?, ?>> zzpD();

    public HashMap<String, Object> zzpE() {
        return null;
    }

    public HashMap<String, Object> zzpF() {
        return null;
    }
}
