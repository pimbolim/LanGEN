package net.time4j.format.expert;

import java.util.AbstractSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import net.time4j.PlainDate;
import net.time4j.PlainTime;
import net.time4j.engine.ChronoElement;

class ParsedValues extends ParsedEntity<ParsedValues> {
    private static final Set<ChronoElement<?>> INDEXED_ELEMENTS;
    private static final int INT_PHI = -1640531527;
    private static final float LOAD_FACTOR = 0.75f;
    /* access modifiers changed from: private */
    public int count;
    private boolean duplicateKeysAllowed = false;
    private int[] ints;
    /* access modifiers changed from: private */
    public Object[] keys;
    /* access modifiers changed from: private */
    public int len;
    private Map<ChronoElement<?>, Object> map;
    private int mask;
    private int position = -1;
    private int threshold;
    private Object[] values;

    private static int mix(int i) {
        int i2 = i * INT_PHI;
        return i2 ^ (i2 >>> 16);
    }

    private static int nextPowerOfTwo(int i) {
        if (i == 0) {
            return 1;
        }
        int i2 = i - 1;
        int i3 = i2 | (i2 >> 1);
        int i4 = i3 | (i3 >> 2);
        int i5 = i4 | (i4 >> 4);
        int i6 = i5 | (i5 >> 8);
        return (i6 | (i6 >> 16)) + 1;
    }

    /* access modifiers changed from: package-private */
    public <E> E getResult() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public void setResult(Object obj) {
    }

    static {
        HashSet hashSet = new HashSet();
        hashSet.add(PlainDate.YEAR);
        hashSet.add(PlainDate.MONTH_AS_NUMBER);
        hashSet.add(PlainDate.DAY_OF_MONTH);
        hashSet.add(PlainTime.DIGITAL_HOUR_OF_DAY);
        hashSet.add(PlainTime.MINUTE_OF_HOUR);
        hashSet.add(PlainTime.SECOND_OF_MINUTE);
        hashSet.add(PlainTime.NANO_OF_SECOND);
        INDEXED_ELEMENTS = Collections.unmodifiableSet(hashSet);
    }

    ParsedValues(int i, boolean z) {
        if (z) {
            this.len = Integer.MIN_VALUE;
            this.mask = Integer.MIN_VALUE;
            this.threshold = Integer.MIN_VALUE;
            this.count = Integer.MIN_VALUE;
            this.keys = null;
            this.values = null;
            this.ints = new int[3];
            for (int i2 = 0; i2 < 3; i2++) {
                this.ints[i2] = Integer.MIN_VALUE;
            }
        } else {
            int arraySize = arraySize(i);
            this.len = arraySize;
            this.mask = arraySize - 1;
            this.threshold = maxFill(arraySize);
            int i3 = this.len;
            this.keys = new Object[i3];
            this.values = null;
            this.ints = new int[i3];
            this.count = 0;
        }
        this.map = null;
    }

    public boolean contains(ChronoElement<?> chronoElement) {
        Object obj;
        if (chronoElement == null) {
            return false;
        }
        Object[] objArr = this.keys;
        if (objArr != null) {
            int mix = mix(chronoElement.hashCode()) & this.mask;
            Object obj2 = objArr[mix];
            if (obj2 == null) {
                return false;
            }
            if (chronoElement.equals(obj2)) {
                return true;
            }
            do {
                mix = (mix + 1) & this.mask;
                obj = objArr[mix];
                if (obj == null) {
                    return false;
                }
            } while (!chronoElement.equals(obj));
            return true;
        } else if (chronoElement == PlainDate.YEAR) {
            if (this.ints[0] != Integer.MIN_VALUE) {
                return true;
            }
            return false;
        } else if (chronoElement == PlainDate.MONTH_AS_NUMBER) {
            if (this.ints[1] != Integer.MIN_VALUE) {
                return true;
            }
            return false;
        } else if (chronoElement == PlainDate.DAY_OF_MONTH) {
            if (this.ints[2] != Integer.MIN_VALUE) {
                return true;
            }
            return false;
        } else if (chronoElement == PlainTime.DIGITAL_HOUR_OF_DAY) {
            if (this.len != Integer.MIN_VALUE) {
                return true;
            }
            return false;
        } else if (chronoElement == PlainTime.MINUTE_OF_HOUR) {
            if (this.mask != Integer.MIN_VALUE) {
                return true;
            }
            return false;
        } else if (chronoElement == PlainTime.SECOND_OF_MINUTE) {
            if (this.threshold != Integer.MIN_VALUE) {
                return true;
            }
            return false;
        } else if (chronoElement != PlainTime.NANO_OF_SECOND) {
            Map<ChronoElement<?>, Object> map2 = this.map;
            if (map2 == null || !map2.containsKey(chronoElement)) {
                return false;
            }
            return true;
        } else if (this.count != Integer.MIN_VALUE) {
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006c, code lost:
        r3 = mix(r6.hashCode()) & r5.mask;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <V> V get(net.time4j.engine.ChronoElement<V> r6) {
        /*
            r5 = this;
            java.lang.Class r0 = r6.getType()
            java.lang.Class<java.lang.Integer> r1 = java.lang.Integer.class
            java.lang.String r2 = "No value found for: "
            if (r0 != r1) goto L_0x0034
            int r1 = r5.getInt0(r6)
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r1 == r3) goto L_0x001b
            java.lang.Integer r6 = java.lang.Integer.valueOf(r1)
            java.lang.Object r6 = r0.cast(r6)
            return r6
        L_0x001b:
            net.time4j.engine.ChronoException r0 = new net.time4j.engine.ChronoException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r2)
            java.lang.String r6 = r6.name()
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            r0.<init>(r6)
            throw r0
        L_0x0034:
            java.lang.Object[] r1 = r5.keys
            if (r1 != 0) goto L_0x0068
            java.util.Map<net.time4j.engine.ChronoElement<?>, java.lang.Object> r0 = r5.map
            if (r0 == 0) goto L_0x004f
            boolean r1 = r0.containsKey(r6)
            if (r1 == 0) goto L_0x004f
            java.lang.Class r1 = r6.getType()
            java.lang.Object r6 = r0.get(r6)
            java.lang.Object r6 = r1.cast(r6)
            return r6
        L_0x004f:
            net.time4j.engine.ChronoException r0 = new net.time4j.engine.ChronoException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r2)
            java.lang.String r6 = r6.name()
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            r0.<init>(r6)
            throw r0
        L_0x0068:
            java.lang.Object[] r3 = r5.values
            if (r3 == 0) goto L_0x00bb
            int r3 = r6.hashCode()
            int r3 = mix(r3)
            int r4 = r5.mask
            r3 = r3 & r4
            r4 = r1[r3]
            if (r4 == 0) goto L_0x00bb
            boolean r4 = r6.equals(r4)
            if (r4 == 0) goto L_0x008a
            java.lang.Object[] r6 = r5.values
            r6 = r6[r3]
            java.lang.Object r6 = r0.cast(r6)
            return r6
        L_0x008a:
            int r3 = r3 + 1
            int r4 = r5.mask
            r3 = r3 & r4
            r4 = r1[r3]
            if (r4 == 0) goto L_0x00a2
            boolean r4 = r6.equals(r4)
            if (r4 == 0) goto L_0x008a
            java.lang.Object[] r6 = r5.values
            r6 = r6[r3]
            java.lang.Object r6 = r0.cast(r6)
            return r6
        L_0x00a2:
            net.time4j.engine.ChronoException r0 = new net.time4j.engine.ChronoException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r2)
            java.lang.String r6 = r6.name()
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            r0.<init>(r6)
            throw r0
        L_0x00bb:
            net.time4j.engine.ChronoException r0 = new net.time4j.engine.ChronoException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r2)
            java.lang.String r6 = r6.name()
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            r0.<init>(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.format.expert.ParsedValues.get(net.time4j.engine.ChronoElement):java.lang.Object");
    }

    public int getInt(ChronoElement<Integer> chronoElement) {
        return getInt0(chronoElement);
    }

    public Set<ChronoElement<?>> getRegisteredElements() {
        if (this.keys != null) {
            return new KeySet();
        }
        HashSet hashSet = new HashSet();
        if (this.ints[0] != Integer.MIN_VALUE) {
            hashSet.add(PlainDate.YEAR);
        }
        if (this.ints[1] != Integer.MIN_VALUE) {
            hashSet.add(PlainDate.MONTH_AS_NUMBER);
        }
        if (this.ints[2] != Integer.MIN_VALUE) {
            hashSet.add(PlainDate.DAY_OF_MONTH);
        }
        if (this.len != Integer.MIN_VALUE) {
            hashSet.add(PlainTime.DIGITAL_HOUR_OF_DAY);
        }
        if (this.mask != Integer.MIN_VALUE) {
            hashSet.add(PlainTime.MINUTE_OF_HOUR);
        }
        if (this.threshold != Integer.MIN_VALUE) {
            hashSet.add(PlainTime.SECOND_OF_MINUTE);
        }
        if (this.count != Integer.MIN_VALUE) {
            hashSet.add(PlainTime.NANO_OF_SECOND);
        }
        Map<ChronoElement<?>, Object> map2 = this.map;
        if (map2 != null) {
            hashSet.addAll(map2.keySet());
        }
        return Collections.unmodifiableSet(hashSet);
    }

    /* access modifiers changed from: package-private */
    public void setPosition(int i) {
        this.position = i;
    }

    /* access modifiers changed from: package-private */
    public int getPosition() {
        return this.position;
    }

    /* access modifiers changed from: package-private */
    public void setNoAmbivalentCheck() {
        this.duplicateKeysAllowed = true;
    }

    static boolean isIndexed(ChronoElement<?> chronoElement) {
        return INDEXED_ELEMENTS.contains(chronoElement);
    }

    /* access modifiers changed from: package-private */
    public void putAll(ParsedValues parsedValues) {
        int i = 0;
        if (this.keys == null) {
            int i2 = parsedValues.len;
            if (i2 != Integer.MIN_VALUE) {
                int i3 = this.len;
                if (i3 == Integer.MIN_VALUE || this.duplicateKeysAllowed || i3 == i2) {
                    this.len = i2;
                } else {
                    throw new AmbivalentValueException(PlainTime.DIGITAL_HOUR_OF_DAY);
                }
            }
            int i4 = parsedValues.mask;
            if (i4 != Integer.MIN_VALUE) {
                int i5 = this.mask;
                if (i5 == Integer.MIN_VALUE || this.duplicateKeysAllowed || i5 == i4) {
                    this.mask = i4;
                } else {
                    throw new AmbivalentValueException(PlainTime.MINUTE_OF_HOUR);
                }
            }
            int i6 = parsedValues.threshold;
            if (i6 != Integer.MIN_VALUE) {
                int i7 = this.threshold;
                if (i7 == Integer.MIN_VALUE || this.duplicateKeysAllowed || i7 == i6) {
                    this.threshold = i6;
                } else {
                    throw new AmbivalentValueException(PlainTime.SECOND_OF_MINUTE);
                }
            }
            int i8 = parsedValues.count;
            if (i8 != Integer.MIN_VALUE) {
                int i9 = this.count;
                if (i9 == Integer.MIN_VALUE || this.duplicateKeysAllowed || i9 == i8) {
                    this.count = i8;
                } else {
                    throw new AmbivalentValueException(PlainTime.NANO_OF_SECOND);
                }
            }
            while (i < 3) {
                int i10 = parsedValues.ints[i];
                if (i10 != Integer.MIN_VALUE) {
                    int[] iArr = this.ints;
                    if (iArr[i] == Integer.MIN_VALUE || this.duplicateKeysAllowed || iArr[i] == i10) {
                        iArr[i] = i10;
                    } else {
                        throw new AmbivalentValueException(getIndexedElement(i));
                    }
                }
                i++;
            }
            Map<ChronoElement<?>, Object> map2 = parsedValues.map;
            if (map2 != null) {
                for (ChronoElement next : map2.keySet()) {
                    put((ChronoElement<?>) next, map2.get(next));
                }
                return;
            }
            return;
        }
        Object[] objArr = parsedValues.keys;
        while (i < objArr.length) {
            Object obj = objArr[i];
            if (obj != null) {
                ChronoElement cast = ChronoElement.class.cast(obj);
                if (cast.getType() == Integer.class) {
                    put((ChronoElement<?>) cast, parsedValues.ints[i]);
                } else {
                    put((ChronoElement<?>) cast, parsedValues.values[i]);
                }
            }
            i++;
        }
    }

    /* access modifiers changed from: package-private */
    public void put(ChronoElement<?> chronoElement, int i) {
        Object obj;
        int i2;
        int i3;
        int i4;
        int i5;
        Object[] objArr = this.keys;
        if (objArr != null) {
            int mix = mix(chronoElement.hashCode()) & this.mask;
            Object obj2 = objArr[mix];
            if (obj2 != null) {
                if (!obj2.equals(chronoElement)) {
                    do {
                        mix = (mix + 1) & this.mask;
                        obj = objArr[mix];
                        if (obj != null) {
                        }
                    } while (!obj.equals(chronoElement));
                    if (this.duplicateKeysAllowed || this.ints[mix] == i) {
                        this.ints[mix] = i;
                        return;
                    }
                    throw new AmbivalentValueException(chronoElement);
                } else if (this.duplicateKeysAllowed || this.ints[mix] == i) {
                    this.ints[mix] = i;
                    return;
                } else {
                    throw new AmbivalentValueException(chronoElement);
                }
            }
            objArr[mix] = chronoElement;
            this.ints[mix] = i;
            int i6 = this.count;
            int i7 = i6 + 1;
            this.count = i7;
            if (i6 >= this.threshold) {
                rehash(arraySize(i7));
            }
        } else if (chronoElement == PlainDate.YEAR) {
            if (!this.duplicateKeysAllowed) {
                int[] iArr = this.ints;
                if (!(iArr[0] == Integer.MIN_VALUE || iArr[0] == i)) {
                    throw new AmbivalentValueException(chronoElement);
                }
            }
            this.ints[0] = i;
        } else if (chronoElement == PlainDate.MONTH_AS_NUMBER) {
            if (!this.duplicateKeysAllowed) {
                int[] iArr2 = this.ints;
                if (!(iArr2[1] == Integer.MIN_VALUE || iArr2[1] == i)) {
                    throw new AmbivalentValueException(chronoElement);
                }
            }
            this.ints[1] = i;
        } else if (chronoElement == PlainDate.DAY_OF_MONTH) {
            if (!this.duplicateKeysAllowed) {
                int[] iArr3 = this.ints;
                if (!(iArr3[2] == Integer.MIN_VALUE || iArr3[2] == i)) {
                    throw new AmbivalentValueException(chronoElement);
                }
            }
            this.ints[2] = i;
        } else if (chronoElement == PlainTime.DIGITAL_HOUR_OF_DAY) {
            if (this.duplicateKeysAllowed || (i5 = this.len) == Integer.MIN_VALUE || i5 == i) {
                this.len = i;
                return;
            }
            throw new AmbivalentValueException(chronoElement);
        } else if (chronoElement == PlainTime.MINUTE_OF_HOUR) {
            if (this.duplicateKeysAllowed || (i4 = this.mask) == Integer.MIN_VALUE || i4 == i) {
                this.mask = i;
                return;
            }
            throw new AmbivalentValueException(chronoElement);
        } else if (chronoElement == PlainTime.SECOND_OF_MINUTE) {
            if (this.duplicateKeysAllowed || (i3 = this.threshold) == Integer.MIN_VALUE || i3 == i) {
                this.threshold = i;
                return;
            }
            throw new AmbivalentValueException(chronoElement);
        } else if (chronoElement != PlainTime.NANO_OF_SECOND) {
            Map map2 = this.map;
            if (map2 == null) {
                map2 = new HashMap();
                this.map = map2;
            }
            Integer valueOf = Integer.valueOf(i);
            if (this.duplicateKeysAllowed || !map2.containsKey(chronoElement) || valueOf.equals(map2.get(chronoElement))) {
                map2.put(chronoElement, valueOf);
                return;
            }
            throw new AmbivalentValueException(chronoElement);
        } else if (this.duplicateKeysAllowed || (i2 = this.count) == Integer.MIN_VALUE || i2 == i) {
            this.count = i;
        } else {
            throw new AmbivalentValueException(chronoElement);
        }
    }

    /* access modifiers changed from: package-private */
    public void put(ChronoElement<?> chronoElement, Object obj) {
        Object obj2;
        if (obj == null) {
            remove(chronoElement);
        } else if (chronoElement.getType() == Integer.class) {
            put(chronoElement, Integer.class.cast(obj).intValue());
        } else {
            Object[] objArr = this.keys;
            if (objArr == null) {
                Map map2 = this.map;
                if (map2 == null) {
                    map2 = new HashMap();
                    this.map = map2;
                }
                if (this.duplicateKeysAllowed || !map2.containsKey(chronoElement) || obj.equals(map2.get(chronoElement))) {
                    map2.put(chronoElement, obj);
                    return;
                }
                throw new AmbivalentValueException(chronoElement);
            }
            if (this.values == null) {
                this.values = new Object[this.len];
            }
            int mix = mix(chronoElement.hashCode()) & this.mask;
            Object obj3 = objArr[mix];
            if (obj3 != null) {
                if (!obj3.equals(chronoElement)) {
                    do {
                        mix = (mix + 1) & this.mask;
                        obj2 = objArr[mix];
                        if (obj2 != null) {
                        }
                    } while (!obj2.equals(chronoElement));
                    if (this.duplicateKeysAllowed || obj.equals(this.values[mix])) {
                        this.values[mix] = obj;
                        return;
                    }
                    throw new AmbivalentValueException(chronoElement);
                } else if (this.duplicateKeysAllowed || obj.equals(this.values[mix])) {
                    this.values[mix] = obj;
                    return;
                } else {
                    throw new AmbivalentValueException(chronoElement);
                }
            }
            objArr[mix] = chronoElement;
            this.values[mix] = obj;
            int i = this.count;
            int i2 = i + 1;
            this.count = i2;
            if (i >= this.threshold) {
                rehash(arraySize(i2));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void reset() {
        Object[] objArr = this.keys;
        if (objArr == null) {
            this.len = Integer.MIN_VALUE;
            this.mask = Integer.MIN_VALUE;
            this.threshold = Integer.MIN_VALUE;
            this.count = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                this.ints[i] = Integer.MIN_VALUE;
            }
            this.map = null;
        } else {
            this.keys = new Object[objArr.length];
        }
        this.count = 0;
    }

    private int getInt0(ChronoElement<?> chronoElement) {
        Object obj;
        Object[] objArr = this.keys;
        if (objArr != null) {
            int mix = mix(chronoElement.hashCode()) & this.mask;
            Object obj2 = objArr[mix];
            if (obj2 == null) {
                return Integer.MIN_VALUE;
            }
            if (chronoElement.equals(obj2)) {
                return this.ints[mix];
            }
            do {
                mix = (mix + 1) & this.mask;
                obj = objArr[mix];
                if (obj == null) {
                    return Integer.MIN_VALUE;
                }
            } while (!chronoElement.equals(obj));
            return this.ints[mix];
        } else if (chronoElement == PlainDate.YEAR) {
            return this.ints[0];
        } else {
            if (chronoElement == PlainDate.MONTH_AS_NUMBER) {
                return this.ints[1];
            }
            if (chronoElement == PlainDate.DAY_OF_MONTH) {
                return this.ints[2];
            }
            if (chronoElement == PlainTime.DIGITAL_HOUR_OF_DAY) {
                return this.len;
            }
            if (chronoElement == PlainTime.MINUTE_OF_HOUR) {
                return this.mask;
            }
            if (chronoElement == PlainTime.SECOND_OF_MINUTE) {
                return this.threshold;
            }
            if (chronoElement == PlainTime.NANO_OF_SECOND) {
                return this.count;
            }
            Map map2 = this.map;
            if (map2 == null || !map2.containsKey(chronoElement)) {
                return Integer.MIN_VALUE;
            }
            return Integer.class.cast(map2.get(chronoElement)).intValue();
        }
    }

    private void remove(Object obj) {
        Object obj2;
        Object[] objArr = this.keys;
        if (objArr != null) {
            int mix = mix(obj.hashCode()) & this.mask;
            Object obj3 = objArr[mix];
            if (obj3 != null) {
                if (obj.equals(obj3)) {
                    removeEntry(mix);
                    return;
                }
                do {
                    mix = (mix + 1) & this.mask;
                    obj2 = objArr[mix];
                    if (obj2 == null) {
                        return;
                    }
                } while (!obj.equals(obj2));
                removeEntry(mix);
            }
        } else if (obj == PlainDate.YEAR) {
            this.ints[0] = Integer.MIN_VALUE;
        } else if (obj == PlainDate.MONTH_AS_NUMBER) {
            this.ints[1] = Integer.MIN_VALUE;
        } else if (obj == PlainDate.DAY_OF_MONTH) {
            this.ints[2] = Integer.MIN_VALUE;
        } else if (obj == PlainTime.DIGITAL_HOUR_OF_DAY) {
            this.len = Integer.MIN_VALUE;
        } else if (obj == PlainTime.MINUTE_OF_HOUR) {
            this.mask = Integer.MIN_VALUE;
        } else if (obj == PlainTime.SECOND_OF_MINUTE) {
            this.threshold = Integer.MIN_VALUE;
        } else if (obj == PlainTime.NANO_OF_SECOND) {
            this.count = Integer.MIN_VALUE;
        } else {
            Map<ChronoElement<?>, Object> map2 = this.map;
            if (map2 != null) {
                map2.remove(obj);
            }
        }
    }

    private void removeEntry(int i) {
        Object obj;
        this.count--;
        Object[] objArr = this.keys;
        while (true) {
            int i2 = (i + 1) & this.mask;
            while (true) {
                obj = objArr[i2];
                if (obj == null) {
                    objArr[i] = null;
                    return;
                }
                int mix = mix(obj.hashCode());
                int i3 = this.mask;
                int i4 = mix & i3;
                if (i <= i2) {
                    if (i >= i4 || i4 > i2) {
                        break;
                    }
                    i2 = (i2 + 1) & i3;
                } else {
                    if (i >= i4 && i4 > i2) {
                        break;
                    }
                    i2 = (i2 + 1) & i3;
                }
            }
            objArr[i] = obj;
            Object[] objArr2 = this.values;
            if (objArr2 != null) {
                objArr2[i] = objArr2[i2];
            }
            int[] iArr = this.ints;
            iArr[i] = iArr[i2];
            i = i2;
        }
    }

    private static int arraySize(int i) {
        return Math.max(2, nextPowerOfTwo((int) Math.ceil((double) (((float) i) / 0.75f))));
    }

    private static int maxFill(int i) {
        return Math.min((int) Math.ceil((double) (((float) i) * 0.75f)), i - 1);
    }

    private void rehash(int i) {
        Object[] objArr;
        Object[] objArr2 = this.keys;
        Object[] objArr3 = this.values;
        int[] iArr = this.ints;
        int i2 = i - 1;
        Object[] objArr4 = new Object[i];
        if (objArr3 == null) {
            objArr = null;
        } else {
            objArr = new Object[i];
        }
        int[] iArr2 = new int[i];
        int i3 = this.len;
        int i4 = this.count;
        for (int i5 = 0; i5 < i4; i5++) {
            do {
                i3--;
            } while (objArr2[i3] == null);
            int mix = mix(objArr2[i3].hashCode()) & i2;
            if (objArr4[mix] != null) {
                do {
                    mix = (mix + 1) & i2;
                } while (objArr4[mix] != null);
            }
            objArr4[mix] = objArr2[i3];
            if (objArr3 != null) {
                objArr[mix] = objArr3[i3];
            }
            iArr2[mix] = iArr[i3];
        }
        this.len = i;
        this.mask = i2;
        this.threshold = maxFill(i);
        this.keys = objArr4;
        this.values = objArr;
        this.ints = iArr2;
    }

    private static ChronoElement<Integer> getIndexedElement(int i) {
        switch (i) {
            case 0:
                return PlainDate.YEAR;
            case 1:
                return PlainDate.MONTH_AS_NUMBER;
            case 2:
                return PlainDate.DAY_OF_MONTH;
            case 3:
                return PlainTime.DIGITAL_HOUR_OF_DAY;
            case 4:
                return PlainTime.MINUTE_OF_HOUR;
            case 5:
                return PlainTime.SECOND_OF_MINUTE;
            case 6:
                return PlainTime.NANO_OF_SECOND;
            default:
                throw new IllegalStateException("No element index: " + i);
        }
    }

    private class KeyIterator implements Iterator<ChronoElement<?>> {
        int c;
        int pos;

        private KeyIterator() {
            this.pos = ParsedValues.this.len;
            this.c = ParsedValues.this.count;
        }

        public boolean hasNext() {
            return this.c > 0;
        }

        public ChronoElement<?> next() {
            int i;
            if (this.c > 0) {
                Object[] access$300 = ParsedValues.this.keys;
                do {
                    i = this.pos - 1;
                    this.pos = i;
                    if (i >= 0) {
                    }
                } while (access$300[i] == null);
                this.c--;
                return ChronoElement.class.cast(access$300[i]);
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException("remove");
        }
    }

    private class KeySet extends AbstractSet<ChronoElement<?>> {
        private KeySet() {
        }

        public Iterator<ChronoElement<?>> iterator() {
            return new KeyIterator();
        }

        public int size() {
            return ParsedValues.this.count;
        }
    }
}
