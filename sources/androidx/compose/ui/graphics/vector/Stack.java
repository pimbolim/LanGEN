package androidx.compose.ui.graphics.vector;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0002\b\u0003\b@\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B$\u0012\u0018\b\u0002\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u000bJ\r\u0010\u0017\u001a\u00020\u0011¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\u0011¢\u0006\u0004\b\u001b\u0010\u0019J\r\u0010\u001c\u001a\u00028\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00028\u0000¢\u0006\u0004\b \u0010\u001eJ\u0015\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00028\u0000¢\u0006\u0004\b#\u0010\u0014J\u0010\u0010$\u001a\u00020%HÖ\u0001¢\u0006\u0004\b&\u0010'R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u0001\u0003\u0001\u0012\u0012\u0004\u0012\u0002H\u00010\u0004j\b\u0012\u0004\u0012\u0002H\u0001`\u0005ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006("}, d2 = {"Landroidx/compose/ui/graphics/vector/Stack;", "T", "", "backing", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "constructor-impl", "(Ljava/util/ArrayList;)Ljava/util/ArrayList;", "size", "", "getSize-impl", "(Ljava/util/ArrayList;)I", "clear", "", "clear-impl", "(Ljava/util/ArrayList;)V", "equals", "", "other", "equals-impl", "(Ljava/util/ArrayList;Ljava/lang/Object;)Z", "hashCode", "hashCode-impl", "isEmpty", "isEmpty-impl", "(Ljava/util/ArrayList;)Z", "isNotEmpty", "isNotEmpty-impl", "peek", "peek-impl", "(Ljava/util/ArrayList;)Ljava/lang/Object;", "pop", "pop-impl", "push", "value", "push-impl", "toString", "", "toString-impl", "(Ljava/util/ArrayList;)Ljava/lang/String;", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@JvmInline
/* compiled from: ImageVector.kt */
final class Stack<T> {
    private final ArrayList<T> backing;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Stack m2200boximpl(ArrayList arrayList) {
        return new Stack(arrayList);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static <T> ArrayList<T> m2202constructorimpl(ArrayList<T> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "backing");
        return arrayList;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m2204equalsimpl(ArrayList<T> arrayList, Object obj) {
        return (obj instanceof Stack) && Intrinsics.areEqual((Object) arrayList, (Object) ((Stack) obj).m2214unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m2205equalsimpl0(ArrayList<?> arrayList, ArrayList<?> arrayList2) {
        return Intrinsics.areEqual((Object) arrayList, (Object) arrayList2);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m2207hashCodeimpl(ArrayList<T> arrayList) {
        return arrayList.hashCode();
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m2213toStringimpl(ArrayList<T> arrayList) {
        return "Stack(backing=" + arrayList + ')';
    }

    public boolean equals(Object obj) {
        return m2204equalsimpl(this.backing, obj);
    }

    public int hashCode() {
        return m2207hashCodeimpl(this.backing);
    }

    public String toString() {
        return m2213toStringimpl(this.backing);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ ArrayList m2214unboximpl() {
        return this.backing;
    }

    private /* synthetic */ Stack(ArrayList arrayList) {
        this.backing = arrayList;
    }

    /* renamed from: constructor-impl$default  reason: not valid java name */
    public static /* synthetic */ ArrayList m2203constructorimpl$default(ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            arrayList = new ArrayList();
        }
        return m2202constructorimpl(arrayList);
    }

    /* renamed from: getSize-impl  reason: not valid java name */
    public static final int m2206getSizeimpl(ArrayList<T> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "arg0");
        return arrayList.size();
    }

    /* renamed from: push-impl  reason: not valid java name */
    public static final boolean m2212pushimpl(ArrayList<T> arrayList, T t) {
        Intrinsics.checkNotNullParameter(arrayList, "arg0");
        return arrayList.add(t);
    }

    /* renamed from: pop-impl  reason: not valid java name */
    public static final T m2211popimpl(ArrayList<T> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "arg0");
        return arrayList.remove(m2206getSizeimpl(arrayList) - 1);
    }

    /* renamed from: peek-impl  reason: not valid java name */
    public static final T m2210peekimpl(ArrayList<T> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "arg0");
        return arrayList.get(m2206getSizeimpl(arrayList) - 1);
    }

    /* renamed from: isEmpty-impl  reason: not valid java name */
    public static final boolean m2208isEmptyimpl(ArrayList<T> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "arg0");
        return arrayList.isEmpty();
    }

    /* renamed from: isNotEmpty-impl  reason: not valid java name */
    public static final boolean m2209isNotEmptyimpl(ArrayList<T> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "arg0");
        return !m2208isEmptyimpl(arrayList);
    }

    /* renamed from: clear-impl  reason: not valid java name */
    public static final void m2201clearimpl(ArrayList<T> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "arg0");
        arrayList.clear();
    }
}
