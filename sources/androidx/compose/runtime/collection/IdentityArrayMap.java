package androidx.compose.runtime.collection;

import androidx.compose.runtime.ActualJvm_jvmKt;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u00032\u00020\u0002B\u000f\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0018J\u0012\u0010\u0019\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u0002J\"\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001c\u001a\u00020\u0005H\u0002JD\u0010\u001d\u001a\u00020\u001e26\u0010\u001f\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u001e0 H\bø\u0001\u0000J\u0018\u0010$\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0017\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010%J\u0006\u0010&\u001a\u00020\u0016J\u0006\u0010'\u001a\u00020\u0016J\u0013\u0010(\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00028\u0000¢\u0006\u0002\u0010\u0018J/\u0010)\u001a\u00020\u001e2!\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u00160*H\bø\u0001\u0000J\u001e\u0010+\u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00028\u00002\u0006\u0010#\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010,R$\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\bX\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0006R$\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\bX\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f\u0002\u0007\n\u0005\b20\u0001¨\u0006-"}, d2 = {"Landroidx/compose/runtime/collection/IdentityArrayMap;", "Key", "", "Value", "capacity", "", "(I)V", "keys", "", "getKeys$runtime_release", "()[Ljava/lang/Object;", "setKeys$runtime_release", "([Ljava/lang/Object;)V", "[Ljava/lang/Object;", "size", "getSize$runtime_release", "()I", "setSize$runtime_release", "values", "getValues$runtime_release", "setValues$runtime_release", "contains", "", "key", "(Ljava/lang/Object;)Z", "find", "findExactIndex", "midIndex", "keyHash", "forEach", "", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "value", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "isEmpty", "isNotEmpty", "remove", "removeValueIf", "Lkotlin/Function1;", "set", "(Ljava/lang/Object;Ljava/lang/Object;)V", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IdentityArrayMap.kt */
public final class IdentityArrayMap<Key, Value> {
    private Object[] keys;
    private int size;
    private Object[] values;

    public IdentityArrayMap() {
        this(0, 1, (DefaultConstructorMarker) null);
    }

    public IdentityArrayMap(int i) {
        this.keys = new Object[i];
        this.values = new Object[i];
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ IdentityArrayMap(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 16 : i);
    }

    public final Object[] getKeys$runtime_release() {
        return this.keys;
    }

    public final void setKeys$runtime_release(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<set-?>");
        this.keys = objArr;
    }

    public final Object[] getValues$runtime_release() {
        return this.values;
    }

    public final void setValues$runtime_release(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<set-?>");
        this.values = objArr;
    }

    public final int getSize$runtime_release() {
        return this.size;
    }

    public final void setSize$runtime_release(int i) {
        this.size = i;
    }

    public final boolean isEmpty() {
        return this.size == 0;
    }

    public final boolean isNotEmpty() {
        return this.size > 0;
    }

    public final boolean contains(Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return find(key) >= 0;
    }

    public final Value get(Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        int find = find(key);
        if (find >= 0) {
            return this.values[find];
        }
        return null;
    }

    public final void set(Key key, Value value) {
        Object[] objArr;
        Intrinsics.checkNotNullParameter(key, "key");
        int find = find(key);
        if (find >= 0) {
            this.values[find] = value;
            return;
        }
        int i = -(find + 1);
        int i2 = this.size;
        Object[] objArr2 = this.keys;
        boolean z = i2 == objArr2.length;
        Object[] objArr3 = z ? new Object[(i2 * 2)] : objArr2;
        int i3 = i + 1;
        ArraysKt.copyInto((T[]) objArr2, (T[]) objArr3, i3, i, i2);
        if (z) {
            ArraysKt.copyInto$default(this.keys, objArr3, 0, 0, i, 6, (Object) null);
        }
        objArr3[i] = key;
        this.keys = objArr3;
        if (z) {
            objArr = new Object[(this.size * 2)];
        } else {
            objArr = this.values;
        }
        ArraysKt.copyInto((T[]) this.values, (T[]) objArr, i3, i, this.size);
        if (z) {
            ArraysKt.copyInto$default(this.values, objArr, 0, 0, i, 6, (Object) null);
        }
        objArr[i] = value;
        this.values = objArr;
        this.size++;
    }

    public final boolean remove(Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        int find = find(key);
        if (find < 0) {
            return false;
        }
        int i = this.size;
        Object[] objArr = this.keys;
        Object[] objArr2 = this.values;
        int i2 = find + 1;
        ArraysKt.copyInto((T[]) objArr, (T[]) objArr, find, i2, i);
        ArraysKt.copyInto((T[]) objArr2, (T[]) objArr2, find, i2, i);
        int i3 = i - 1;
        objArr[i3] = null;
        objArr2[i3] = null;
        this.size = i3;
        return true;
    }

    public final void removeValueIf(Function1<? super Value, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        int size$runtime_release = getSize$runtime_release();
        int i = 0;
        int i2 = 0;
        while (i < size$runtime_release) {
            int i3 = i + 1;
            Object obj = getValues$runtime_release()[i];
            if (!function1.invoke(obj).booleanValue()) {
                if (i2 != i) {
                    getKeys$runtime_release()[i2] = getKeys$runtime_release()[i];
                    getValues$runtime_release()[i2] = obj;
                }
                i2++;
            }
            i = i3;
        }
        if (getSize$runtime_release() > i2) {
            int size$runtime_release2 = getSize$runtime_release();
            for (int i4 = i2; i4 < size$runtime_release2; i4++) {
                getKeys$runtime_release()[i4] = null;
                getValues$runtime_release()[i4] = null;
            }
            setSize$runtime_release(i2);
        }
    }

    public final void forEach(Function2<? super Key, ? super Value, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        int size$runtime_release = getSize$runtime_release();
        for (int i = 0; i < size$runtime_release; i++) {
            Object obj = getKeys$runtime_release()[i];
            Objects.requireNonNull(obj, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");
            function2.invoke(obj, getValues$runtime_release()[i]);
        }
    }

    private final int find(Object obj) {
        int identityHashCode = ActualJvm_jvmKt.identityHashCode(obj);
        int i = this.size - 1;
        int i2 = 0;
        while (i2 <= i) {
            int i3 = (i2 + i) >>> 1;
            Object obj2 = this.keys[i3];
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
                Object obj2 = this.keys[i3];
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
            Object obj3 = this.keys[i5];
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
