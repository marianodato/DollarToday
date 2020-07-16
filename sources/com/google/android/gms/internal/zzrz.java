package com.google.android.gms.internal;

import com.google.android.gms.internal.zzry;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class zzrz<M extends zzry<M>, T> {
    public final int tag;
    protected final int type;
    protected final Class<T> zzbil;
    protected final boolean zzbim;

    private zzrz(int i, Class<T> cls, int i2, boolean z) {
        this.type = i;
        this.zzbil = cls;
        this.tag = i2;
        this.zzbim = z;
    }

    private T zzF(List<zzsg> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            zzsg zzsg = (zzsg) list.get(i);
            if (zzsg.zzbiw.length != 0) {
                zza(zzsg, (List<Object>) arrayList);
            }
        }
        int size = arrayList.size();
        if (size == 0) {
            return null;
        }
        T cast = this.zzbil.cast(Array.newInstance(this.zzbil.getComponentType(), size));
        for (int i2 = 0; i2 < size; i2++) {
            Array.set(cast, i2, arrayList.get(i2));
        }
        return cast;
    }

    private T zzG(List<zzsg> list) {
        if (list.isEmpty()) {
            return null;
        }
        return this.zzbil.cast(zzF(zzrw.zzB(((zzsg) list.get(list.size() - 1)).zzbiw)));
    }

    public static <M extends zzry<M>, T extends zzse> zzrz<M, T> zza(int i, Class<T> cls, long j) {
        return new zzrz<>(i, cls, (int) j, false);
    }

    /* access modifiers changed from: 0000 */
    public final T zzE(List<zzsg> list) {
        if (list == null) {
            return null;
        }
        return this.zzbim ? zzF(list) : zzG(list);
    }

    /* access modifiers changed from: protected */
    public Object zzF(zzrw zzrw) {
        Class<T> cls = this.zzbim ? this.zzbil.getComponentType() : this.zzbil;
        try {
            switch (this.type) {
                case 10:
                    zzse zzse = (zzse) cls.newInstance();
                    zzrw.zza(zzse, zzsh.zzlV(this.tag));
                    return zzse;
                case 11:
                    zzse zzse2 = (zzse) cls.newInstance();
                    zzrw.zza(zzse2);
                    return zzse2;
                default:
                    throw new IllegalArgumentException("Unknown type " + this.type);
            }
        } catch (InstantiationException e) {
            throw new IllegalArgumentException("Error creating instance of class " + cls, e);
        } catch (IllegalAccessException e2) {
            throw new IllegalArgumentException("Error creating instance of class " + cls, e2);
        } catch (IOException e3) {
            throw new IllegalArgumentException("Error reading extension field", e3);
        }
    }

    /* access modifiers changed from: 0000 */
    public int zzX(Object obj) {
        return this.zzbim ? zzY(obj) : zzZ(obj);
    }

    /* access modifiers changed from: protected */
    public int zzY(Object obj) {
        int i = 0;
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            if (Array.get(obj, i2) != null) {
                i += zzZ(Array.get(obj, i2));
            }
        }
        return i;
    }

    /* access modifiers changed from: protected */
    public int zzZ(Object obj) {
        int zzlV = zzsh.zzlV(this.tag);
        switch (this.type) {
            case 10:
                return zzrx.zzb(zzlV, (zzse) obj);
            case 11:
                return zzrx.zzc(zzlV, (zzse) obj);
            default:
                throw new IllegalArgumentException("Unknown type " + this.type);
        }
    }

    /* access modifiers changed from: protected */
    public void zza(zzsg zzsg, List<Object> list) {
        list.add(zzF(zzrw.zzB(zzsg.zzbiw)));
    }

    /* access modifiers changed from: 0000 */
    public void zza(Object obj, zzrx zzrx) throws IOException {
        if (this.zzbim) {
            zzc(obj, zzrx);
        } else {
            zzb(obj, zzrx);
        }
    }

    /* access modifiers changed from: protected */
    public void zzb(Object obj, zzrx zzrx) {
        try {
            zzrx.zzlN(this.tag);
            switch (this.type) {
                case 10:
                    zzse zzse = (zzse) obj;
                    int zzlV = zzsh.zzlV(this.tag);
                    zzrx.zzb(zzse);
                    zzrx.zzC(zzlV, 4);
                    return;
                case 11:
                    zzrx.zzc((zzse) obj);
                    return;
                default:
                    throw new IllegalArgumentException("Unknown type " + this.type);
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        throw new IllegalStateException(e);
    }

    /* access modifiers changed from: protected */
    public void zzc(Object obj, zzrx zzrx) {
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            Object obj2 = Array.get(obj, i);
            if (obj2 != null) {
                zzb(obj2, zzrx);
            }
        }
    }
}
