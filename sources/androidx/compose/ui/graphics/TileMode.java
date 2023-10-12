package androidx.compose.ui.graphics;

import com.braintreepayments.api.models.BinData;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0014\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/graphics/TileMode;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@JvmInline
/* compiled from: TileMode.kt */
public final class TileMode {
    /* access modifiers changed from: private */
    public static final int Clamp = m1931constructorimpl(0);
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int Decal = m1931constructorimpl(3);
    /* access modifiers changed from: private */
    public static final int Mirror = m1931constructorimpl(2);
    /* access modifiers changed from: private */
    public static final int Repeated = m1931constructorimpl(1);
    private final int value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ TileMode m1930boximpl(int i) {
        return new TileMode(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m1931constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m1932equalsimpl(int i, Object obj) {
        return (obj instanceof TileMode) && i == ((TileMode) obj).m1936unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m1933equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m1934hashCodeimpl(int i) {
        return i;
    }

    public boolean equals(Object obj) {
        return m1932equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1934hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m1936unboximpl() {
        return this.value;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u001c\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/graphics/TileMode$Companion;", "", "()V", "Clamp", "Landroidx/compose/ui/graphics/TileMode;", "getClamp-3opZhB0", "()I", "I", "Decal", "getDecal-3opZhB0", "Mirror", "getMirror-3opZhB0", "Repeated", "getRepeated-3opZhB0", "ui-graphics_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TileMode.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getClamp-3opZhB0  reason: not valid java name */
        public final int m1937getClamp3opZhB0() {
            return TileMode.Clamp;
        }

        /* renamed from: getRepeated-3opZhB0  reason: not valid java name */
        public final int m1940getRepeated3opZhB0() {
            return TileMode.Repeated;
        }

        /* renamed from: getMirror-3opZhB0  reason: not valid java name */
        public final int m1939getMirror3opZhB0() {
            return TileMode.Mirror;
        }

        /* renamed from: getDecal-3opZhB0  reason: not valid java name */
        public final int m1938getDecal3opZhB0() {
            return TileMode.Decal;
        }
    }

    private /* synthetic */ TileMode(int i) {
        this.value = i;
    }

    public String toString() {
        return m1935toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m1935toStringimpl(int i) {
        if (m1933equalsimpl0(i, Clamp)) {
            return "Clamp";
        }
        if (m1933equalsimpl0(i, Repeated)) {
            return "Repeated";
        }
        if (m1933equalsimpl0(i, Mirror)) {
            return "Mirror";
        }
        return m1933equalsimpl0(i, Decal) ? "Decal" : BinData.UNKNOWN;
    }
}
