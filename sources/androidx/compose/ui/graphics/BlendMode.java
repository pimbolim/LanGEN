package androidx.compose.ui.graphics;

import androidx.exifinterface.media.ExifInterface;
import com.braintreepayments.api.models.BinData;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0014\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/graphics/BlendMode;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@JvmInline
/* compiled from: BlendMode.kt */
public final class BlendMode {
    /* access modifiers changed from: private */
    public static final int Clear = m1501constructorimpl(0);
    /* access modifiers changed from: private */
    public static final int Color = m1501constructorimpl(27);
    /* access modifiers changed from: private */
    public static final int ColorBurn = m1501constructorimpl(19);
    /* access modifiers changed from: private */
    public static final int ColorDodge = m1501constructorimpl(18);
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int Darken = m1501constructorimpl(16);
    /* access modifiers changed from: private */
    public static final int Difference = m1501constructorimpl(22);
    /* access modifiers changed from: private */
    public static final int Dst = m1501constructorimpl(2);
    /* access modifiers changed from: private */
    public static final int DstAtop = m1501constructorimpl(10);
    /* access modifiers changed from: private */
    public static final int DstIn = m1501constructorimpl(6);
    /* access modifiers changed from: private */
    public static final int DstOut = m1501constructorimpl(8);
    /* access modifiers changed from: private */
    public static final int DstOver = m1501constructorimpl(4);
    /* access modifiers changed from: private */
    public static final int Exclusion = m1501constructorimpl(23);
    /* access modifiers changed from: private */
    public static final int Hardlight = m1501constructorimpl(20);
    /* access modifiers changed from: private */
    public static final int Hue = m1501constructorimpl(25);
    /* access modifiers changed from: private */
    public static final int Lighten = m1501constructorimpl(17);
    /* access modifiers changed from: private */
    public static final int Luminosity = m1501constructorimpl(28);
    /* access modifiers changed from: private */
    public static final int Modulate = m1501constructorimpl(13);
    /* access modifiers changed from: private */
    public static final int Multiply = m1501constructorimpl(24);
    /* access modifiers changed from: private */
    public static final int Overlay = m1501constructorimpl(15);
    /* access modifiers changed from: private */
    public static final int Plus = m1501constructorimpl(12);
    /* access modifiers changed from: private */
    public static final int Saturation = m1501constructorimpl(26);
    /* access modifiers changed from: private */
    public static final int Screen = m1501constructorimpl(14);
    /* access modifiers changed from: private */
    public static final int Softlight = m1501constructorimpl(21);
    /* access modifiers changed from: private */
    public static final int Src = m1501constructorimpl(1);
    /* access modifiers changed from: private */
    public static final int SrcAtop = m1501constructorimpl(9);
    /* access modifiers changed from: private */
    public static final int SrcIn = m1501constructorimpl(5);
    /* access modifiers changed from: private */
    public static final int SrcOut = m1501constructorimpl(7);
    /* access modifiers changed from: private */
    public static final int SrcOver = m1501constructorimpl(3);
    /* access modifiers changed from: private */
    public static final int Xor = m1501constructorimpl(11);
    private final int value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ BlendMode m1500boximpl(int i) {
        return new BlendMode(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m1501constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m1502equalsimpl(int i, Object obj) {
        return (obj instanceof BlendMode) && i == ((BlendMode) obj).m1506unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m1503equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m1504hashCodeimpl(int i) {
        return i;
    }

    public boolean equals(Object obj) {
        return m1502equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1504hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m1506unboximpl() {
        return this.value;
    }

    private /* synthetic */ BlendMode(int i) {
        this.value = i;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b<\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u001c\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0010\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0012\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0013\u0010\u0006R\u001c\u0010\u0014\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0015\u0010\u0006R\u001c\u0010\u0016\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0017\u0010\u0006R\u001c\u0010\u0018\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0019\u0010\u0006R\u001c\u0010\u001a\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u001b\u0010\u0006R\u001c\u0010\u001c\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u001d\u0010\u0006R\u001c\u0010\u001e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u001f\u0010\u0006R\u001c\u0010 \u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b!\u0010\u0006R\u001c\u0010\"\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b#\u0010\u0006R\u001c\u0010$\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b%\u0010\u0006R\u001c\u0010&\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b'\u0010\u0006R\u001c\u0010(\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b)\u0010\u0006R\u001c\u0010*\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b+\u0010\u0006R\u001c\u0010,\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b-\u0010\u0006R\u001c\u0010.\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b/\u0010\u0006R\u001c\u00100\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b1\u0010\u0006R\u001c\u00102\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b3\u0010\u0006R\u001c\u00104\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b5\u0010\u0006R\u001c\u00106\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b7\u0010\u0006R\u001c\u00108\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b9\u0010\u0006R\u001c\u0010:\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b;\u0010\u0006R\u001c\u0010<\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b=\u0010\u0006R\u001c\u0010>\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b?\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006@"}, d2 = {"Landroidx/compose/ui/graphics/BlendMode$Companion;", "", "()V", "Clear", "Landroidx/compose/ui/graphics/BlendMode;", "getClear-0nO6VwU", "()I", "I", "Color", "getColor-0nO6VwU", "ColorBurn", "getColorBurn-0nO6VwU", "ColorDodge", "getColorDodge-0nO6VwU", "Darken", "getDarken-0nO6VwU", "Difference", "getDifference-0nO6VwU", "Dst", "getDst-0nO6VwU", "DstAtop", "getDstAtop-0nO6VwU", "DstIn", "getDstIn-0nO6VwU", "DstOut", "getDstOut-0nO6VwU", "DstOver", "getDstOver-0nO6VwU", "Exclusion", "getExclusion-0nO6VwU", "Hardlight", "getHardlight-0nO6VwU", "Hue", "getHue-0nO6VwU", "Lighten", "getLighten-0nO6VwU", "Luminosity", "getLuminosity-0nO6VwU", "Modulate", "getModulate-0nO6VwU", "Multiply", "getMultiply-0nO6VwU", "Overlay", "getOverlay-0nO6VwU", "Plus", "getPlus-0nO6VwU", "Saturation", "getSaturation-0nO6VwU", "Screen", "getScreen-0nO6VwU", "Softlight", "getSoftlight-0nO6VwU", "Src", "getSrc-0nO6VwU", "SrcAtop", "getSrcAtop-0nO6VwU", "SrcIn", "getSrcIn-0nO6VwU", "SrcOut", "getSrcOut-0nO6VwU", "SrcOver", "getSrcOver-0nO6VwU", "Xor", "getXor-0nO6VwU", "ui-graphics_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BlendMode.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getClear-0nO6VwU  reason: not valid java name */
        public final int m1507getClear0nO6VwU() {
            return BlendMode.Clear;
        }

        /* renamed from: getSrc-0nO6VwU  reason: not valid java name */
        public final int m1530getSrc0nO6VwU() {
            return BlendMode.Src;
        }

        /* renamed from: getDst-0nO6VwU  reason: not valid java name */
        public final int m1513getDst0nO6VwU() {
            return BlendMode.Dst;
        }

        /* renamed from: getSrcOver-0nO6VwU  reason: not valid java name */
        public final int m1534getSrcOver0nO6VwU() {
            return BlendMode.SrcOver;
        }

        /* renamed from: getDstOver-0nO6VwU  reason: not valid java name */
        public final int m1517getDstOver0nO6VwU() {
            return BlendMode.DstOver;
        }

        /* renamed from: getSrcIn-0nO6VwU  reason: not valid java name */
        public final int m1532getSrcIn0nO6VwU() {
            return BlendMode.SrcIn;
        }

        /* renamed from: getDstIn-0nO6VwU  reason: not valid java name */
        public final int m1515getDstIn0nO6VwU() {
            return BlendMode.DstIn;
        }

        /* renamed from: getSrcOut-0nO6VwU  reason: not valid java name */
        public final int m1533getSrcOut0nO6VwU() {
            return BlendMode.SrcOut;
        }

        /* renamed from: getDstOut-0nO6VwU  reason: not valid java name */
        public final int m1516getDstOut0nO6VwU() {
            return BlendMode.DstOut;
        }

        /* renamed from: getSrcAtop-0nO6VwU  reason: not valid java name */
        public final int m1531getSrcAtop0nO6VwU() {
            return BlendMode.SrcAtop;
        }

        /* renamed from: getDstAtop-0nO6VwU  reason: not valid java name */
        public final int m1514getDstAtop0nO6VwU() {
            return BlendMode.DstAtop;
        }

        /* renamed from: getXor-0nO6VwU  reason: not valid java name */
        public final int m1535getXor0nO6VwU() {
            return BlendMode.Xor;
        }

        /* renamed from: getPlus-0nO6VwU  reason: not valid java name */
        public final int m1526getPlus0nO6VwU() {
            return BlendMode.Plus;
        }

        /* renamed from: getModulate-0nO6VwU  reason: not valid java name */
        public final int m1523getModulate0nO6VwU() {
            return BlendMode.Modulate;
        }

        /* renamed from: getScreen-0nO6VwU  reason: not valid java name */
        public final int m1528getScreen0nO6VwU() {
            return BlendMode.Screen;
        }

        /* renamed from: getOverlay-0nO6VwU  reason: not valid java name */
        public final int m1525getOverlay0nO6VwU() {
            return BlendMode.Overlay;
        }

        /* renamed from: getDarken-0nO6VwU  reason: not valid java name */
        public final int m1511getDarken0nO6VwU() {
            return BlendMode.Darken;
        }

        /* renamed from: getLighten-0nO6VwU  reason: not valid java name */
        public final int m1521getLighten0nO6VwU() {
            return BlendMode.Lighten;
        }

        /* renamed from: getColorDodge-0nO6VwU  reason: not valid java name */
        public final int m1510getColorDodge0nO6VwU() {
            return BlendMode.ColorDodge;
        }

        /* renamed from: getColorBurn-0nO6VwU  reason: not valid java name */
        public final int m1509getColorBurn0nO6VwU() {
            return BlendMode.ColorBurn;
        }

        /* renamed from: getHardlight-0nO6VwU  reason: not valid java name */
        public final int m1519getHardlight0nO6VwU() {
            return BlendMode.Hardlight;
        }

        /* renamed from: getSoftlight-0nO6VwU  reason: not valid java name */
        public final int m1529getSoftlight0nO6VwU() {
            return BlendMode.Softlight;
        }

        /* renamed from: getDifference-0nO6VwU  reason: not valid java name */
        public final int m1512getDifference0nO6VwU() {
            return BlendMode.Difference;
        }

        /* renamed from: getExclusion-0nO6VwU  reason: not valid java name */
        public final int m1518getExclusion0nO6VwU() {
            return BlendMode.Exclusion;
        }

        /* renamed from: getMultiply-0nO6VwU  reason: not valid java name */
        public final int m1524getMultiply0nO6VwU() {
            return BlendMode.Multiply;
        }

        /* renamed from: getHue-0nO6VwU  reason: not valid java name */
        public final int m1520getHue0nO6VwU() {
            return BlendMode.Hue;
        }

        /* renamed from: getSaturation-0nO6VwU  reason: not valid java name */
        public final int m1527getSaturation0nO6VwU() {
            return BlendMode.Saturation;
        }

        /* renamed from: getColor-0nO6VwU  reason: not valid java name */
        public final int m1508getColor0nO6VwU() {
            return BlendMode.Color;
        }

        /* renamed from: getLuminosity-0nO6VwU  reason: not valid java name */
        public final int m1522getLuminosity0nO6VwU() {
            return BlendMode.Luminosity;
        }
    }

    public String toString() {
        return m1505toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m1505toStringimpl(int i) {
        if (m1503equalsimpl0(i, Clear)) {
            return "Clear";
        }
        if (m1503equalsimpl0(i, Src)) {
            return "Src";
        }
        if (m1503equalsimpl0(i, Dst)) {
            return "Dst";
        }
        if (m1503equalsimpl0(i, SrcOver)) {
            return "SrcOver";
        }
        if (m1503equalsimpl0(i, DstOver)) {
            return "DstOver";
        }
        if (m1503equalsimpl0(i, SrcIn)) {
            return "SrcIn";
        }
        if (m1503equalsimpl0(i, DstIn)) {
            return "DstIn";
        }
        if (m1503equalsimpl0(i, SrcOut)) {
            return "SrcOut";
        }
        if (m1503equalsimpl0(i, DstOut)) {
            return "DstOut";
        }
        if (m1503equalsimpl0(i, SrcAtop)) {
            return "SrcAtop";
        }
        if (m1503equalsimpl0(i, DstAtop)) {
            return "DstAtop";
        }
        if (m1503equalsimpl0(i, Xor)) {
            return "Xor";
        }
        if (m1503equalsimpl0(i, Plus)) {
            return "Plus";
        }
        if (m1503equalsimpl0(i, Modulate)) {
            return "Modulate";
        }
        if (m1503equalsimpl0(i, Screen)) {
            return "Screen";
        }
        if (m1503equalsimpl0(i, Overlay)) {
            return "Overlay";
        }
        if (m1503equalsimpl0(i, Darken)) {
            return "Darken";
        }
        if (m1503equalsimpl0(i, Lighten)) {
            return "Lighten";
        }
        if (m1503equalsimpl0(i, ColorDodge)) {
            return "ColorDodge";
        }
        if (m1503equalsimpl0(i, ColorBurn)) {
            return "ColorBurn";
        }
        if (m1503equalsimpl0(i, Hardlight)) {
            return "HardLight";
        }
        if (m1503equalsimpl0(i, Softlight)) {
            return "Softlight";
        }
        if (m1503equalsimpl0(i, Difference)) {
            return "Difference";
        }
        if (m1503equalsimpl0(i, Exclusion)) {
            return "Exclusion";
        }
        if (m1503equalsimpl0(i, Multiply)) {
            return "Multiply";
        }
        if (m1503equalsimpl0(i, Hue)) {
            return "Hue";
        }
        if (m1503equalsimpl0(i, Saturation)) {
            return ExifInterface.TAG_SATURATION;
        }
        if (m1503equalsimpl0(i, Color)) {
            return "Color";
        }
        return m1503equalsimpl0(i, Luminosity) ? "Luminosity" : BinData.UNKNOWN;
    }
}
