package com.google.android.gms.internal;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class zzme<K, V> extends zzmi<K, V> implements Map<K, V> {
    zzmh<K, V> zzagz;

    private zzmh<K, V> zzpx() {
        if (this.zzagz == null) {
            this.zzagz = new zzmh<K, V>() {
                /* access modifiers changed from: protected */
                public void colClear() {
                    zzme.this.clear();
                }

                /* access modifiers changed from: protected */
                public Object colGetEntry(int index, int offset) {
                    return zzme.this.mArray[(index << 1) + offset];
                }

                /* access modifiers changed from: protected */
                public Map<K, V> colGetMap() {
                    return zzme.this;
                }

                /* access modifiers changed from: protected */
                public int colGetSize() {
                    return zzme.this.mSize;
                }

                /* access modifiers changed from: protected */
                public int colIndexOfKey(Object key) {
                    return key == null ? zzme.this.indexOfNull() : zzme.this.indexOf(key, key.hashCode());
                }

                /* access modifiers changed from: protected */
                public int colIndexOfValue(Object value) {
                    return zzme.this.indexOfValue(value);
                }

                /* access modifiers changed from: protected */
                public void colPut(K key, V value) {
                    zzme.this.put(key, value);
                }

                /* access modifiers changed from: protected */
                public void colRemoveAt(int index) {
                    zzme.this.removeAt(index);
                }

                /* access modifiers changed from: protected */
                public V colSetValue(int index, V value) {
                    return zzme.this.setValueAt(index, value);
                }
            };
        }
        return this.zzagz;
    }

    public Set<Entry<K, V>> entrySet() {
        return zzpx().getEntrySet();
    }

    public Set<K> keySet() {
        return zzpx().getKeySet();
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        ensureCapacity(this.mSize + map.size());
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public Collection<V> values() {
        return zzpx().getValues();
    }
}
