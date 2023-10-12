package androidx.compose.runtime.collection;

import androidx.compose.runtime.ActualJvm_jvmKt;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001b\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00022\u0006\u0010%\u001a\u00028\u0000¢\u0006\u0002\u0010&J\u0006\u0010'\u001a\u00020(J\u0011\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020\u0002H\u0002J\u0012\u0010+\u001a\u00020\u000e2\b\u0010$\u001a\u0004\u0018\u00010\u0002H\u0002J\"\u0010,\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\u000e2\b\u0010$\u001a\u0004\u0018\u00010\u00022\u0006\u0010.\u001a\u00020\u000eH\u0002J7\u0010/\u001a\u00020(2\u0006\u0010$\u001a\u00020\u00022!\u00100\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020(01H\bø\u0001\u0000J\u0016\u00104\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010$\u001a\u00020\u0002H\u0002J\u001b\u00105\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00022\u0006\u0010%\u001a\u00028\u0000¢\u0006\u0002\u0010&J/\u00106\u001a\u00020(2!\u00107\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020#01H\bø\u0001\u0000J\u0016\u00108\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u00109\u001a\u00020\u000eH\u0002J\u0011\u0010:\u001a\u00020\u00022\u0006\u00109\u001a\u00020\u000eH\bR4\u0010\u0004\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00060\u00058\u0000@\u0000X\u000e¢\u0006\u0016\n\u0002\u0010\f\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\u000e8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000f\u0010\u0003\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0014\u001a\u00020\u00158\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0016\u0010\u0003\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR.\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00058\u0000@\u0000X\u000e¢\u0006\u0016\n\u0002\u0010!\u0012\u0004\b\u001c\u0010\u0003\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u0002\u0007\n\u0005\b20\u0001¨\u0006;"}, d2 = {"Landroidx/compose/runtime/collection/IdentityScopeMap;", "T", "", "()V", "scopeSets", "", "Landroidx/compose/runtime/collection/IdentityArraySet;", "getScopeSets$annotations", "getScopeSets", "()[Landroidx/compose/runtime/collection/IdentityArraySet;", "setScopeSets", "([Landroidx/compose/runtime/collection/IdentityArraySet;)V", "[Landroidx/compose/runtime/collection/IdentityArraySet;", "size", "", "getSize$annotations", "getSize", "()I", "setSize", "(I)V", "valueOrder", "", "getValueOrder$annotations", "getValueOrder", "()[I", "setValueOrder", "([I)V", "values", "getValues$annotations", "getValues", "()[Ljava/lang/Object;", "setValues", "([Ljava/lang/Object;)V", "[Ljava/lang/Object;", "add", "", "value", "scope", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "clear", "", "contains", "element", "find", "findExactIndex", "midIndex", "valueHash", "forEachScopeOf", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "getOrCreateIdentitySet", "remove", "removeValueIf", "predicate", "scopeSetAt", "index", "valueAt", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IdentityScopeMap.kt */
public final class IdentityScopeMap<T> {
    private IdentityArraySet<T>[] scopeSets;
    private int size;
    private int[] valueOrder;
    private Object[] values;

    public static /* synthetic */ void getScopeSets$annotations() {
    }

    public static /* synthetic */ void getSize$annotations() {
    }

    public static /* synthetic */ void getValueOrder$annotations() {
    }

    public static /* synthetic */ void getValues$annotations() {
    }

    public IdentityScopeMap() {
        int[] iArr = new int[50];
        for (int i = 0; i < 50; i++) {
            iArr[i] = i;
        }
        this.valueOrder = iArr;
        this.values = new Object[50];
        this.scopeSets = new IdentityArraySet[50];
    }

    public final int[] getValueOrder() {
        return this.valueOrder;
    }

    public final void setValueOrder(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<set-?>");
        this.valueOrder = iArr;
    }

    public final Object[] getValues() {
        return this.values;
    }

    public final void setValues(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<set-?>");
        this.values = objArr;
    }

    public final IdentityArraySet<T>[] getScopeSets() {
        return this.scopeSets;
    }

    public final void setScopeSets(IdentityArraySet<T>[] identityArraySetArr) {
        Intrinsics.checkNotNullParameter(identityArraySetArr, "<set-?>");
        this.scopeSets = identityArraySetArr;
    }

    public final int getSize() {
        return this.size;
    }

    public final void setSize(int i) {
        this.size = i;
    }

    private final Object valueAt(int i) {
        Object obj = getValues()[getValueOrder()[i]];
        Intrinsics.checkNotNull(obj);
        return obj;
    }

    /* access modifiers changed from: private */
    public final IdentityArraySet<T> scopeSetAt(int i) {
        IdentityArraySet<T> identityArraySet = this.scopeSets[this.valueOrder[i]];
        Intrinsics.checkNotNull(identityArraySet);
        return identityArraySet;
    }

    public final boolean add(Object obj, T t) {
        Intrinsics.checkNotNullParameter(obj, "value");
        Intrinsics.checkNotNullParameter(t, "scope");
        return getOrCreateIdentitySet(obj).add(t);
    }

    public final boolean contains(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "element");
        return find(obj) >= 0;
    }

    public final void forEachScopeOf(Object obj, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(obj, "value");
        Intrinsics.checkNotNullParameter(function1, "block");
        int access$find = find(obj);
        if (access$find >= 0) {
            for (Object invoke : scopeSetAt(access$find)) {
                function1.invoke(invoke);
            }
        }
    }

    private final IdentityArraySet<T> getOrCreateIdentitySet(Object obj) {
        int i;
        if (this.size > 0) {
            i = find(obj);
            if (i >= 0) {
                return scopeSetAt(i);
            }
        } else {
            i = -1;
        }
        int i2 = -(i + 1);
        int i3 = this.size;
        int[] iArr = this.valueOrder;
        if (i3 < iArr.length) {
            int i4 = iArr[i3];
            this.values[i4] = obj;
            IdentityArraySet<T> identityArraySet = this.scopeSets[i4];
            if (identityArraySet == null) {
                identityArraySet = new IdentityArraySet<>();
                getScopeSets()[i4] = identityArraySet;
            }
            int i5 = this.size;
            if (i2 < i5) {
                int[] iArr2 = this.valueOrder;
                ArraysKt.copyInto(iArr2, iArr2, i2 + 1, i2, i5);
            }
            this.valueOrder[i2] = i4;
            this.size++;
            return identityArraySet;
        }
        int length = iArr.length * 2;
        Object[] copyOf = Arrays.copyOf(this.scopeSets, length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        this.scopeSets = (IdentityArraySet[]) copyOf;
        IdentityArraySet<T> identityArraySet2 = new IdentityArraySet<>();
        this.scopeSets[i3] = identityArraySet2;
        Object[] copyOf2 = Arrays.copyOf(this.values, length);
        Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(this, newSize)");
        this.values = copyOf2;
        copyOf2[i3] = obj;
        int[] iArr3 = new int[length];
        for (int i6 = this.size + 1; i6 < length; i6++) {
            iArr3[i6] = i6;
        }
        int i7 = this.size;
        if (i2 < i7) {
            ArraysKt.copyInto(this.valueOrder, iArr3, i2 + 1, i2, i7);
        }
        iArr3[i2] = i3;
        if (i2 > 0) {
            ArraysKt.copyInto$default(this.valueOrder, iArr3, 0, 0, i2, 6, (Object) null);
        }
        this.valueOrder = iArr3;
        this.size++;
        return identityArraySet2;
    }

    public final void clear() {
        int length = this.scopeSets.length;
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            IdentityArraySet<T> identityArraySet = this.scopeSets[i];
            if (identityArraySet != null) {
                identityArraySet.clear();
            }
            this.valueOrder[i] = i;
            this.values[i] = null;
            i = i2;
        }
        this.size = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0012, code lost:
        r1 = r4.valueOrder[r5];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean remove(java.lang.Object r5, T r6) {
        /*
            r4 = this;
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "scope"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            int r5 = r4.find(r5)
            r0 = 0
            if (r5 < 0) goto L_0x0044
            int[] r1 = r4.valueOrder
            r1 = r1[r5]
            androidx.compose.runtime.collection.IdentityArraySet<T>[] r2 = r4.scopeSets
            r2 = r2[r1]
            if (r2 != 0) goto L_0x001d
            return r0
        L_0x001d:
            boolean r6 = r2.remove(r6)
            int r0 = r2.size()
            if (r0 != 0) goto L_0x0043
            int r0 = r5 + 1
            int r2 = r4.size
            if (r0 >= r2) goto L_0x0032
            int[] r3 = r4.valueOrder
            kotlin.collections.ArraysKt.copyInto((int[]) r3, (int[]) r3, (int) r5, (int) r0, (int) r2)
        L_0x0032:
            int[] r5 = r4.valueOrder
            int r0 = r4.size
            int r2 = r0 + -1
            r5[r2] = r1
            java.lang.Object[] r5 = r4.values
            r2 = 0
            r5[r1] = r2
            int r0 = r0 + -1
            r4.size = r0
        L_0x0043:
            return r6
        L_0x0044:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.collection.IdentityScopeMap.remove(java.lang.Object, java.lang.Object):boolean");
    }

    public final void removeValueIf(Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int size2 = getSize();
        int i = 0;
        int i2 = 0;
        while (i < size2) {
            int i3 = i + 1;
            int i4 = getValueOrder()[i];
            IdentityArraySet identityArraySet = getScopeSets()[i4];
            Intrinsics.checkNotNull(identityArraySet);
            int size3 = identityArraySet.size();
            int i5 = 0;
            int i6 = 0;
            while (i5 < size3) {
                int i7 = i5 + 1;
                Object obj = identityArraySet.getValues()[i5];
                Objects.requireNonNull(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                if (!function1.invoke(obj).booleanValue()) {
                    if (i6 != i5) {
                        identityArraySet.getValues()[i6] = obj;
                    }
                    i6++;
                }
                i5 = i7;
            }
            int size4 = identityArraySet.size();
            for (int i8 = i6; i8 < size4; i8++) {
                identityArraySet.getValues()[i8] = null;
            }
            identityArraySet.setSize(i6);
            if (identityArraySet.size() > 0) {
                if (i2 != i) {
                    int i9 = getValueOrder()[i2];
                    getValueOrder()[i2] = i4;
                    getValueOrder()[i] = i9;
                }
                i2++;
            }
            i = i3;
        }
        int size5 = getSize();
        for (int i10 = i2; i10 < size5; i10++) {
            getValues()[getValueOrder()[i10]] = null;
        }
        setSize(i2);
    }

    /* access modifiers changed from: private */
    public final int find(Object obj) {
        int identityHashCode = ActualJvm_jvmKt.identityHashCode(obj);
        int i = this.size - 1;
        int i2 = 0;
        while (i2 <= i) {
            int i3 = (i2 + i) >>> 1;
            Object obj2 = getValues()[getValueOrder()[i3]];
            Intrinsics.checkNotNull(obj2);
            int identityHashCode2 = ActualJvm_jvmKt.identityHashCode(obj2) - identityHashCode;
            if (identityHashCode2 < 0) {
                i2 = i3 + 1;
            } else if (identityHashCode2 > 0) {
                i = i3 - 1;
            } else if (obj == obj2) {
                return i3;
            } else {
                return findExactIndex(i3, obj, identityHashCode);
            }
        }
        return -(i2 + 1);
    }

    private final int findExactIndex(int i, Object obj, int i2) {
        int i3 = i - 1;
        if (i3 >= 0) {
            while (true) {
                int i4 = i3 - 1;
                Object obj2 = getValues()[getValueOrder()[i3]];
                Intrinsics.checkNotNull(obj2);
                if (obj2 != obj) {
                    if (ActualJvm_jvmKt.identityHashCode(obj2) != i2 || i4 < 0) {
                        break;
                    }
                    i3 = i4;
                } else {
                    return i3;
                }
            }
        }
        int i5 = i + 1;
        int i6 = this.size;
        while (i5 < i6) {
            int i7 = i5 + 1;
            Object obj3 = getValues()[getValueOrder()[i5]];
            Intrinsics.checkNotNull(obj3);
            if (obj3 == obj) {
                return i5;
            }
            if (ActualJvm_jvmKt.identityHashCode(obj3) != i2) {
                return -i7;
            }
            i5 = i7;
        }
        return -(this.size + 1);
    }
}
