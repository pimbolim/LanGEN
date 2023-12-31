package androidx.compose.material;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0014\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u0010\u0010\r\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Landroidx/compose/material/Strings;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@JvmInline
/* compiled from: Strings.kt */
public final class Strings {
    /* access modifiers changed from: private */
    public static final int CloseDrawer = m1111constructorimpl(1);
    /* access modifiers changed from: private */
    public static final int CloseSheet = m1111constructorimpl(2);
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int DefaultErrorMessage = m1111constructorimpl(3);
    /* access modifiers changed from: private */
    public static final int ExposedDropdownMenu = m1111constructorimpl(4);
    /* access modifiers changed from: private */
    public static final int NavigationMenu = m1111constructorimpl(0);
    private final int value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Strings m1110boximpl(int i) {
        return new Strings(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    private static int m1111constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m1112equalsimpl(int i, Object obj) {
        return (obj instanceof Strings) && i == ((Strings) obj).m1116unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m1113equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m1114hashCodeimpl(int i) {
        return i;
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m1115toStringimpl(int i) {
        return "Strings(value=" + i + ')';
    }

    public boolean equals(Object obj) {
        return m1112equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1114hashCodeimpl(this.value);
    }

    public String toString() {
        return m1115toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m1116unboximpl() {
        return this.value;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u001c\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000f\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0010"}, d2 = {"Landroidx/compose/material/Strings$Companion;", "", "()V", "CloseDrawer", "Landroidx/compose/material/Strings;", "getCloseDrawer-UdPEhr4", "()I", "I", "CloseSheet", "getCloseSheet-UdPEhr4", "DefaultErrorMessage", "getDefaultErrorMessage-UdPEhr4", "ExposedDropdownMenu", "getExposedDropdownMenu-UdPEhr4", "NavigationMenu", "getNavigationMenu-UdPEhr4", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Strings.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getNavigationMenu-UdPEhr4  reason: not valid java name */
        public final int m1121getNavigationMenuUdPEhr4() {
            return Strings.NavigationMenu;
        }

        /* renamed from: getCloseDrawer-UdPEhr4  reason: not valid java name */
        public final int m1117getCloseDrawerUdPEhr4() {
            return Strings.CloseDrawer;
        }

        /* renamed from: getCloseSheet-UdPEhr4  reason: not valid java name */
        public final int m1118getCloseSheetUdPEhr4() {
            return Strings.CloseSheet;
        }

        /* renamed from: getDefaultErrorMessage-UdPEhr4  reason: not valid java name */
        public final int m1119getDefaultErrorMessageUdPEhr4() {
            return Strings.DefaultErrorMessage;
        }

        /* renamed from: getExposedDropdownMenu-UdPEhr4  reason: not valid java name */
        public final int m1120getExposedDropdownMenuUdPEhr4() {
            return Strings.ExposedDropdownMenu;
        }
    }

    private /* synthetic */ Strings(int i) {
        this.value = i;
    }
}
