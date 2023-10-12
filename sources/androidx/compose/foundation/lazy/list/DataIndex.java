package androidx.compose.foundation.lazy.list;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0003\b@\u0018\u00002\u00020\u0001B\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\f\u001a\u00020\u0000H\nø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\r\u0010\u0005J\u001a\u0010\u000e\u001a\u00020\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0005J\u0019\u0010\u0014\u001a\u00020\u0000H\nø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0005J\u001e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0000H\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u000bJ!\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0003H\nø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u000bJ!\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0003H\nø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u000bJ\u0010\u0010\u001c\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0001\u0002ø\u0001\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006 "}, d2 = {"Landroidx/compose/foundation/lazy/list/DataIndex;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "compareTo", "other", "compareTo-oA9-DU0", "(II)I", "dec", "dec-AUyieIw", "equals", "", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "inc", "inc-AUyieIw", "minus", "i", "minus-cCpjGZE", "minus-MUqiCgg", "plus", "plus-MUqiCgg", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@JvmInline
/* compiled from: DataIndex.kt */
public final class DataIndex {
    private final int value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ DataIndex m533boximpl(int i) {
        return new DataIndex(i);
    }

    /* renamed from: compareTo-oA9-DU0  reason: not valid java name */
    public static final int m534compareTooA9DU0(int i, int i2) {
        return i - i2;
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m535constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m537equalsimpl(int i, Object obj) {
        return (obj instanceof DataIndex) && i == ((DataIndex) obj).m545unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m538equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m539hashCodeimpl(int i) {
        return i;
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m544toStringimpl(int i) {
        return "DataIndex(value=" + i + ')';
    }

    public boolean equals(Object obj) {
        return m537equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m539hashCodeimpl(this.value);
    }

    public String toString() {
        return m544toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m545unboximpl() {
        return this.value;
    }

    private /* synthetic */ DataIndex(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }

    /* renamed from: inc-AUyieIw  reason: not valid java name */
    public static final int m540incAUyieIw(int i) {
        return m535constructorimpl(i + 1);
    }

    /* renamed from: dec-AUyieIw  reason: not valid java name */
    public static final int m536decAUyieIw(int i) {
        return m535constructorimpl(i - 1);
    }

    /* renamed from: plus-MUqiCgg  reason: not valid java name */
    public static final int m543plusMUqiCgg(int i, int i2) {
        return m535constructorimpl(i + i2);
    }

    /* renamed from: minus-MUqiCgg  reason: not valid java name */
    public static final int m541minusMUqiCgg(int i, int i2) {
        return m535constructorimpl(i - i2);
    }

    /* renamed from: minus-cCpjGZE  reason: not valid java name */
    public static final int m542minuscCpjGZE(int i, int i2) {
        return m535constructorimpl(i - i2);
    }
}
