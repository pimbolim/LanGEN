package androidx.compose.ui.geometry;

import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a \u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001a-\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0011H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019\u001a+\u0010\u001a\u001a\u00020\u0002*\u00020\u00022\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u001cH\bø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001e\u001a\"\u0010\u001f\u001a\u00020\u0002*\u00020 2\u0006\u0010!\u001a\u00020\u0002H\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010#\u001a\"\u0010\u001f\u001a\u00020\u0002*\u00020\u00112\u0006\u0010!\u001a\u00020\u0002H\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010$\u001a\"\u0010\u001f\u001a\u00020\u0002*\u00020%2\u0006\u0010!\u001a\u00020\u0002H\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010&\u001a\u0019\u0010'\u001a\u00020(*\u00020\u0002H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010*\"!\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\"\u0010\u0007\u001a\u00020\b*\u00020\u00028Æ\u0002X\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u000b\"\"\u0010\f\u001a\u00020\b*\u00020\u00028Æ\u0002X\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u000b\u0002\u0012\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0005\b20\u0001¨\u0006+"}, d2 = {"center", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/ui/geometry/Size;", "getCenter-uvyYCjk$annotations", "(J)V", "getCenter-uvyYCjk", "(J)J", "isSpecified", "", "isSpecified-uvyYCjk$annotations", "isSpecified-uvyYCjk", "(J)Z", "isUnspecified", "isUnspecified-uvyYCjk$annotations", "isUnspecified-uvyYCjk", "Size", "width", "", "height", "(FF)J", "lerp", "start", "stop", "fraction", "lerp-VgWVRYQ", "(JJF)J", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse-TmRCtEA", "(JLkotlin/jvm/functions/Function0;)J", "times", "", "size", "times-d16Qtg0", "(DJ)J", "(FJ)J", "", "(IJ)J", "toRect", "Landroidx/compose/ui/geometry/Rect;", "toRect-uvyYCjk", "(J)Landroidx/compose/ui/geometry/Rect;", "ui-geometry_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Size.kt */
public final class SizeKt {
    /* renamed from: getCenter-uvyYCjk$annotations  reason: not valid java name */
    public static /* synthetic */ void m1433getCenteruvyYCjk$annotations(long j) {
    }

    /* renamed from: isSpecified-uvyYCjk$annotations  reason: not valid java name */
    public static /* synthetic */ void m1435isSpecifieduvyYCjk$annotations(long j) {
    }

    /* renamed from: isUnspecified-uvyYCjk$annotations  reason: not valid java name */
    public static /* synthetic */ void m1437isUnspecifieduvyYCjk$annotations(long j) {
    }

    /* renamed from: isSpecified-uvyYCjk  reason: not valid java name */
    public static final boolean m1434isSpecifieduvyYCjk(long j) {
        return j != Size.Companion.m1430getUnspecifiedNHjbRc();
    }

    /* renamed from: isUnspecified-uvyYCjk  reason: not valid java name */
    public static final boolean m1436isUnspecifieduvyYCjk(long j) {
        return j == Size.Companion.m1430getUnspecifiedNHjbRc();
    }

    /* renamed from: lerp-VgWVRYQ  reason: not valid java name */
    public static final long m1438lerpVgWVRYQ(long j, long j2, float f) {
        return Size(MathHelpersKt.lerp(Size.m1422getWidthimpl(j), Size.m1422getWidthimpl(j2), f), MathHelpersKt.lerp(Size.m1419getHeightimpl(j), Size.m1419getHeightimpl(j2), f));
    }

    /* renamed from: times-d16Qtg0  reason: not valid java name */
    public static final long m1442timesd16Qtg0(int i, long j) {
        return Size.m1425times7Ah8Wj8(j, (float) i);
    }

    /* renamed from: times-d16Qtg0  reason: not valid java name */
    public static final long m1440timesd16Qtg0(double d, long j) {
        return Size.m1425times7Ah8Wj8(j, (float) d);
    }

    /* renamed from: toRect-uvyYCjk  reason: not valid java name */
    public static final Rect m1443toRectuvyYCjk(long j) {
        return RectKt.m1393Recttz77jQw(Offset.Companion.m1369getZeroF1C5BW0(), j);
    }

    /* renamed from: times-d16Qtg0  reason: not valid java name */
    public static final long m1441timesd16Qtg0(float f, long j) {
        return Size.m1425times7Ah8Wj8(j, f);
    }

    /* renamed from: getCenter-uvyYCjk  reason: not valid java name */
    public static final long m1432getCenteruvyYCjk(long j) {
        return OffsetKt.Offset(Size.m1422getWidthimpl(j) / 2.0f, Size.m1419getHeightimpl(j) / 2.0f);
    }

    public static final long Size(float f, float f2) {
        long floatToIntBits = (long) Float.floatToIntBits(f);
        return Size.m1413constructorimpl((((long) Float.floatToIntBits(f2)) & 4294967295L) | (floatToIntBits << 32));
    }

    /* renamed from: takeOrElse-TmRCtEA  reason: not valid java name */
    public static final long m1439takeOrElseTmRCtEA(long j, Function0<Size> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        return (j > Size.Companion.m1430getUnspecifiedNHjbRc() ? 1 : (j == Size.Companion.m1430getUnspecifiedNHjbRc() ? 0 : -1)) != 0 ? j : function0.invoke().m1427unboximpl();
    }
}
