package com.google.android.gms.internal;

import java.util.Map;

public class zzmi<K, V> {
    static Object[] mBaseCache;
    static int mBaseCacheSize;
    static Object[] mTwiceBaseCache;
    static int mTwiceBaseCacheSize;
    Object[] mArray;
    int[] mHashes;
    int mSize;

    public zzmi() {
        this.mHashes = zzmf.EMPTY_INTS;
        this.mArray = zzmf.EMPTY_OBJECTS;
        this.mSize = 0;
    }

    public zzmi(int i) {
        if (i == 0) {
            this.mHashes = zzmf.EMPTY_INTS;
            this.mArray = zzmf.EMPTY_OBJECTS;
        } else {
            zzbO(i);
        }
        this.mSize = 0;
    }

    private static void zza(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (zzme.class) {
                if (mTwiceBaseCacheSize < 10) {
                    objArr[0] = mTwiceBaseCache;
                    objArr[1] = iArr;
                    for (int i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    mTwiceBaseCache = objArr;
                    mTwiceBaseCacheSize++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (zzme.class) {
                if (mBaseCacheSize < 10) {
                    objArr[0] = mBaseCache;
                    objArr[1] = iArr;
                    for (int i3 = (i << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    mBaseCache = objArr;
                    mBaseCacheSize++;
                }
            }
        }
    }

    private void zzbO(int i) {
        if (i == 8) {
            synchronized (zzme.class) {
                if (mTwiceBaseCache != null) {
                    Object[] objArr = mTwiceBaseCache;
                    this.mArray = objArr;
                    mTwiceBaseCache = (Object[]) objArr[0];
                    this.mHashes = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    mTwiceBaseCacheSize--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (zzme.class) {
                if (mBaseCache != null) {
                    Object[] objArr2 = mBaseCache;
                    this.mArray = objArr2;
                    mBaseCache = (Object[]) objArr2[0];
                    this.mHashes = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    mBaseCacheSize--;
                    return;
                }
            }
        }
        this.mHashes = new int[i];
        this.mArray = new Object[(i << 1)];
    }

    public void clear() {
        if (this.mSize != 0) {
            zza(this.mHashes, this.mArray, this.mSize);
            this.mHashes = zzmf.EMPTY_INTS;
            this.mArray = zzmf.EMPTY_OBJECTS;
            this.mSize = 0;
        }
    }

    public boolean containsKey(Object key) {
        return key == null ? indexOfNull() >= 0 : indexOf(key, key.hashCode()) >= 0;
    }

    public boolean containsValue(Object value) {
        return indexOfValue(value) >= 0;
    }

    public void ensureCapacity(int minimumCapacity) {
        if (this.mHashes.length < minimumCapacity) {
            int[] iArr = this.mHashes;
            Object[] objArr = this.mArray;
            zzbO(minimumCapacity);
            if (this.mSize > 0) {
                System.arraycopy(iArr, 0, this.mHashes, 0, this.mSize);
                System.arraycopy(objArr, 0, this.mArray, 0, this.mSize << 1);
            }
            zza(iArr, objArr, this.mSize);
        }
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Map)) {
            return false;
        }
        Map map = (Map) object;
        if (size() != map.size()) {
            return false;
        }
        int i = 0;
        while (i < this.mSize) {
            try {
                Object keyAt = keyAt(i);
                Object valueAt = valueAt(i);
                Object obj = map.get(keyAt);
                if (valueAt == null) {
                    if (obj != null || !map.containsKey(keyAt)) {
                        return false;
                    }
                } else if (!valueAt.equals(obj)) {
                    return false;
                }
                i++;
            } catch (NullPointerException e) {
                return false;
            } catch (ClassCastException e2) {
                return false;
            }
        }
        return true;
    }

    public V get(Object key) {
        int indexOf = key == null ? indexOfNull() : indexOf(key, key.hashCode());
        if (indexOf >= 0) {
            return this.mArray[(indexOf << 1) + 1];
        }
        return null;
    }

    public int hashCode() {
        int[] iArr = this.mHashes;
        Object[] objArr = this.mArray;
        int i = this.mSize;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            i4 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return i4;
    }

    /* access modifiers changed from: 0000 */
    public int indexOf(Object key, int hash) {
        int i = this.mSize;
        if (i == 0) {
            return -1;
        }
        int binarySearch = zzmf.binarySearch(this.mHashes, i, hash);
        if (binarySearch < 0 || key.equals(this.mArray[binarySearch << 1])) {
            return binarySearch;
        }
        int i2 = binarySearch + 1;
        while (i2 < i && this.mHashes[i2] == hash) {
            if (key.equals(this.mArray[i2 << 1])) {
                return i2;
            }
            i2++;
        }
        int i3 = binarySearch - 1;
        while (i3 >= 0 && this.mHashes[i3] == hash) {
            if (key.equals(this.mArray[i3 << 1])) {
                return i3;
            }
            i3--;
        }
        return i2 ^ -1;
    }

    /* access modifiers changed from: 0000 */
    public int indexOfNull() {
        int i = this.mSize;
        if (i == 0) {
            return -1;
        }
        int binarySearch = zzmf.binarySearch(this.mHashes, i, 0);
        if (binarySearch < 0 || this.mArray[binarySearch << 1] == null) {
            return binarySearch;
        }
        int i2 = binarySearch + 1;
        while (i2 < i && this.mHashes[i2] == 0) {
            if (this.mArray[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        int i3 = binarySearch - 1;
        while (i3 >= 0 && this.mHashes[i3] == 0) {
            if (this.mArray[i3 << 1] == null) {
                return i3;
            }
            i3--;
        }
        return i2 ^ -1;
    }

    /* access modifiers changed from: 0000 */
    public int indexOfValue(Object value) {
        int i = 1;
        int i2 = this.mSize * 2;
        Object[] objArr = this.mArray;
        if (value == null) {
            while (i < i2) {
                if (objArr[i] == null) {
                    return i >> 1;
                }
                i += 2;
            }
        } else {
            while (i < i2) {
                if (value.equals(objArr[i])) {
                    return i >> 1;
                }
                i += 2;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.mSize <= 0;
    }

    public K keyAt(int index) {
        return this.mArray[index << 1];
    }

    public V put(K key, V value) {
        int hashCode;
        int indexOf;
        int i = 8;
        if (key == null) {
            indexOf = indexOfNull();
            hashCode = 0;
        } else {
            hashCode = key.hashCode();
            indexOf = indexOf(key, hashCode);
        }
        if (indexOf >= 0) {
            int i2 = (indexOf << 1) + 1;
            V v = this.mArray[i2];
            this.mArray[i2] = value;
            return v;
        }
        int i3 = indexOf ^ -1;
        if (this.mSize >= this.mHashes.length) {
            if (this.mSize >= 8) {
                i = this.mSize + (this.mSize >> 1);
            } else if (this.mSize < 4) {
                i = 4;
            }
            int[] iArr = this.mHashes;
            Object[] objArr = this.mArray;
            zzbO(i);
            if (this.mHashes.length > 0) {
                System.arraycopy(iArr, 0, this.mHashes, 0, iArr.length);
                System.arraycopy(objArr, 0, this.mArray, 0, objArr.length);
            }
            zza(iArr, objArr, this.mSize);
        }
        if (i3 < this.mSize) {
            System.arraycopy(this.mHashes, i3, this.mHashes, i3 + 1, this.mSize - i3);
            System.arraycopy(this.mArray, i3 << 1, this.mArray, (i3 + 1) << 1, (this.mSize - i3) << 1);
        }
        this.mHashes[i3] = hashCode;
        this.mArray[i3 << 1] = key;
        this.mArray[(i3 << 1) + 1] = value;
        this.mSize++;
        return null;
    }

    public V remove(Object key) {
        int indexOf = key == null ? indexOfNull() : indexOf(key, key.hashCode());
        if (indexOf >= 0) {
            return removeAt(indexOf);
        }
        return null;
    }

    public V removeAt(int index) {
        int i = 8;
        V v = this.mArray[(index << 1) + 1];
        if (this.mSize <= 1) {
            zza(this.mHashes, this.mArray, this.mSize);
            this.mHashes = zzmf.EMPTY_INTS;
            this.mArray = zzmf.EMPTY_OBJECTS;
            this.mSize = 0;
        } else if (this.mHashes.length <= 8 || this.mSize >= this.mHashes.length / 3) {
            this.mSize--;
            if (index < this.mSize) {
                System.arraycopy(this.mHashes, index + 1, this.mHashes, index, this.mSize - index);
                System.arraycopy(this.mArray, (index + 1) << 1, this.mArray, index << 1, (this.mSize - index) << 1);
            }
            this.mArray[this.mSize << 1] = null;
            this.mArray[(this.mSize << 1) + 1] = null;
        } else {
            if (this.mSize > 8) {
                i = this.mSize + (this.mSize >> 1);
            }
            int[] iArr = this.mHashes;
            Object[] objArr = this.mArray;
            zzbO(i);
            this.mSize--;
            if (index > 0) {
                System.arraycopy(iArr, 0, this.mHashes, 0, index);
                System.arraycopy(objArr, 0, this.mArray, 0, index << 1);
            }
            if (index < this.mSize) {
                System.arraycopy(iArr, index + 1, this.mHashes, index, this.mSize - index);
                System.arraycopy(objArr, (index + 1) << 1, this.mArray, index << 1, (this.mSize - index) << 1);
            }
        }
        return v;
    }

    public V setValueAt(int index, V value) {
        int index2 = (index << 1) + 1;
        V v = this.mArray[index2];
        this.mArray[index2] = value;
        return v;
    }

    public int size() {
        return this.mSize;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.mSize * 28);
        sb.append('{');
        for (int i = 0; i < this.mSize; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            Object keyAt = keyAt(i);
            if (keyAt != this) {
                sb.append(keyAt);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object valueAt = valueAt(i);
            if (valueAt != this) {
                sb.append(valueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public V valueAt(int index) {
        return this.mArray[(index << 1) + 1];
    }
}
