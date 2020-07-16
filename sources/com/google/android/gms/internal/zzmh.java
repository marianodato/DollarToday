package com.google.android.gms.internal;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

abstract class zzmh<K, V> {
    zzb zzagI;
    zzc zzagJ;
    zze zzagK;

    final class zza<T> implements Iterator<T> {
        boolean mCanRemove = false;
        int mIndex;
        final int mOffset;
        int mSize;

        zza(int i) {
            this.mOffset = i;
            this.mSize = zzmh.this.colGetSize();
        }

        public boolean hasNext() {
            return this.mIndex < this.mSize;
        }

        public T next() {
            T colGetEntry = zzmh.this.colGetEntry(this.mIndex, this.mOffset);
            this.mIndex++;
            this.mCanRemove = true;
            return colGetEntry;
        }

        public void remove() {
            if (!this.mCanRemove) {
                throw new IllegalStateException();
            }
            this.mIndex--;
            this.mSize--;
            this.mCanRemove = false;
            zzmh.this.colRemoveAt(this.mIndex);
        }
    }

    final class zzb implements Set<Entry<K, V>> {
        zzb() {
        }

        public boolean add(Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends Entry<K, V>> collection) {
            int colGetSize = zzmh.this.colGetSize();
            for (Entry entry : collection) {
                zzmh.this.colPut(entry.getKey(), entry.getValue());
            }
            return colGetSize != zzmh.this.colGetSize();
        }

        public void clear() {
            zzmh.this.colClear();
        }

        public boolean contains(Object o) {
            if (!(o instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) o;
            int colIndexOfKey = zzmh.this.colIndexOfKey(entry.getKey());
            if (colIndexOfKey >= 0) {
                return zzmf.equal(zzmh.this.colGetEntry(colIndexOfKey, 1), entry.getValue());
            }
            return false;
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean equals(Object object) {
            return zzmh.equalsSetHelper(this, object);
        }

        public int hashCode() {
            int colGetSize = zzmh.this.colGetSize() - 1;
            int i = 0;
            while (colGetSize >= 0) {
                Object colGetEntry = zzmh.this.colGetEntry(colGetSize, 0);
                Object colGetEntry2 = zzmh.this.colGetEntry(colGetSize, 1);
                colGetSize--;
                i += (colGetEntry2 == null ? 0 : colGetEntry2.hashCode()) ^ (colGetEntry == null ? 0 : colGetEntry.hashCode());
            }
            return i;
        }

        public boolean isEmpty() {
            return zzmh.this.colGetSize() == 0;
        }

        public Iterator<Entry<K, V>> iterator() {
            return new zzd();
        }

        public boolean remove(Object object) {
            throw new UnsupportedOperationException();
        }

        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public int size() {
            return zzmh.this.colGetSize();
        }

        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }
    }

    final class zzc implements Set<K> {
        zzc() {
        }

        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            zzmh.this.colClear();
        }

        public boolean contains(Object object) {
            return zzmh.this.colIndexOfKey(object) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            return zzmh.containsAllHelper(zzmh.this.colGetMap(), collection);
        }

        public boolean equals(Object object) {
            return zzmh.equalsSetHelper(this, object);
        }

        public int hashCode() {
            int i = 0;
            for (int colGetSize = zzmh.this.colGetSize() - 1; colGetSize >= 0; colGetSize--) {
                Object colGetEntry = zzmh.this.colGetEntry(colGetSize, 0);
                i += colGetEntry == null ? 0 : colGetEntry.hashCode();
            }
            return i;
        }

        public boolean isEmpty() {
            return zzmh.this.colGetSize() == 0;
        }

        public Iterator<K> iterator() {
            return new zza(0);
        }

        public boolean remove(Object object) {
            int colIndexOfKey = zzmh.this.colIndexOfKey(object);
            if (colIndexOfKey < 0) {
                return false;
            }
            zzmh.this.colRemoveAt(colIndexOfKey);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            return zzmh.removeAllHelper(zzmh.this.colGetMap(), collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return zzmh.retainAllHelper(zzmh.this.colGetMap(), collection);
        }

        public int size() {
            return zzmh.this.colGetSize();
        }

        public Object[] toArray() {
            return zzmh.this.toArrayHelper(0);
        }

        public <T> T[] toArray(T[] array) {
            return zzmh.this.toArrayHelper(array, 0);
        }
    }

    final class zzd implements Iterator<Entry<K, V>>, Entry<K, V> {
        int mEnd;
        boolean mEntryValid = false;
        int mIndex;

        zzd() {
            this.mEnd = zzmh.this.colGetSize() - 1;
            this.mIndex = -1;
        }

        public final boolean equals(Object o) {
            boolean z = true;
            if (!this.mEntryValid) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else if (!(o instanceof Entry)) {
                return false;
            } else {
                Entry entry = (Entry) o;
                if (!zzmf.equal(entry.getKey(), zzmh.this.colGetEntry(this.mIndex, 0)) || !zzmf.equal(entry.getValue(), zzmh.this.colGetEntry(this.mIndex, 1))) {
                    z = false;
                }
                return z;
            }
        }

        public K getKey() {
            if (this.mEntryValid) {
                return zzmh.this.colGetEntry(this.mIndex, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public V getValue() {
            if (this.mEntryValid) {
                return zzmh.this.colGetEntry(this.mIndex, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public boolean hasNext() {
            return this.mIndex < this.mEnd;
        }

        public final int hashCode() {
            int i = 0;
            if (!this.mEntryValid) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            Object colGetEntry = zzmh.this.colGetEntry(this.mIndex, 0);
            Object colGetEntry2 = zzmh.this.colGetEntry(this.mIndex, 1);
            int hashCode = colGetEntry == null ? 0 : colGetEntry.hashCode();
            if (colGetEntry2 != null) {
                i = colGetEntry2.hashCode();
            }
            return i ^ hashCode;
        }

        public Entry<K, V> next() {
            this.mIndex++;
            this.mEntryValid = true;
            return this;
        }

        public void remove() {
            if (!this.mEntryValid) {
                throw new IllegalStateException();
            }
            zzmh.this.colRemoveAt(this.mIndex);
            this.mIndex--;
            this.mEnd--;
            this.mEntryValid = false;
        }

        public V setValue(V object) {
            if (this.mEntryValid) {
                return zzmh.this.colSetValue(this.mIndex, object);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final String toString() {
            return getKey() + "=" + getValue();
        }
    }

    final class zze implements Collection<V> {
        zze() {
        }

        public boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            zzmh.this.colClear();
        }

        public boolean contains(Object object) {
            return zzmh.this.colIndexOfValue(object) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean isEmpty() {
            return zzmh.this.colGetSize() == 0;
        }

        public Iterator<V> iterator() {
            return new zza(1);
        }

        public boolean remove(Object object) {
            int colIndexOfValue = zzmh.this.colIndexOfValue(object);
            if (colIndexOfValue < 0) {
                return false;
            }
            zzmh.this.colRemoveAt(colIndexOfValue);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            int i = 0;
            int colGetSize = zzmh.this.colGetSize();
            boolean z = false;
            while (i < colGetSize) {
                if (collection.contains(zzmh.this.colGetEntry(i, 1))) {
                    zzmh.this.colRemoveAt(i);
                    i--;
                    colGetSize--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public boolean retainAll(Collection<?> collection) {
            int i = 0;
            int colGetSize = zzmh.this.colGetSize();
            boolean z = false;
            while (i < colGetSize) {
                if (!collection.contains(zzmh.this.colGetEntry(i, 1))) {
                    zzmh.this.colRemoveAt(i);
                    i--;
                    colGetSize--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public int size() {
            return zzmh.this.colGetSize();
        }

        public Object[] toArray() {
            return zzmh.this.toArrayHelper(1);
        }

        public <T> T[] toArray(T[] array) {
            return zzmh.this.toArrayHelper(array, 1);
        }
    }

    zzmh() {
    }

    public static <K, V> boolean containsAllHelper(Map<K, V> map, Collection<?> collection) {
        for (Object containsKey : collection) {
            if (!map.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean equalsSetHelper(Set<T> set, Object object) {
        boolean z = true;
        if (set == object) {
            return true;
        }
        if (!(object instanceof Set)) {
            return false;
        }
        Set set2 = (Set) object;
        try {
            if (set.size() != set2.size() || !set.containsAll(set2)) {
                z = false;
            }
            return z;
        } catch (ClassCastException | NullPointerException e) {
            return false;
        }
    }

    public static <K, V> boolean removeAllHelper(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        for (Object remove : collection) {
            map.remove(remove);
        }
        return size != map.size();
    }

    public static <K, V> boolean retainAllHelper(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    /* access modifiers changed from: protected */
    public abstract void colClear();

    /* access modifiers changed from: protected */
    public abstract Object colGetEntry(int i, int i2);

    /* access modifiers changed from: protected */
    public abstract Map<K, V> colGetMap();

    /* access modifiers changed from: protected */
    public abstract int colGetSize();

    /* access modifiers changed from: protected */
    public abstract int colIndexOfKey(Object obj);

    /* access modifiers changed from: protected */
    public abstract int colIndexOfValue(Object obj);

    /* access modifiers changed from: protected */
    public abstract void colPut(K k, V v);

    /* access modifiers changed from: protected */
    public abstract void colRemoveAt(int i);

    /* access modifiers changed from: protected */
    public abstract V colSetValue(int i, V v);

    public Set<Entry<K, V>> getEntrySet() {
        if (this.zzagI == null) {
            this.zzagI = new zzb<>();
        }
        return this.zzagI;
    }

    public Set<K> getKeySet() {
        if (this.zzagJ == null) {
            this.zzagJ = new zzc<>();
        }
        return this.zzagJ;
    }

    public Collection<V> getValues() {
        if (this.zzagK == null) {
            this.zzagK = new zze<>();
        }
        return this.zzagK;
    }

    public Object[] toArrayHelper(int offset) {
        int colGetSize = colGetSize();
        Object[] objArr = new Object[colGetSize];
        for (int i = 0; i < colGetSize; i++) {
            objArr[i] = colGetEntry(i, offset);
        }
        return objArr;
    }

    public <T> T[] toArrayHelper(T[] array, int offset) {
        int colGetSize = colGetSize();
        if (array.length < colGetSize) {
            array = (Object[]) ((Object[]) Array.newInstance(array.getClass().getComponentType(), colGetSize));
        }
        for (int i = 0; i < colGetSize; i++) {
            array[i] = colGetEntry(i, offset);
        }
        if (array.length > colGetSize) {
            array[colGetSize] = null;
        }
        return array;
    }
}
