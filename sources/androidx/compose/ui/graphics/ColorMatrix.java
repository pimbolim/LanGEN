package androidx.compose.ui.graphics;

import com.brentvatne.react.ReactVideoViewManager;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000e\n\u0002\b\u0003\b@\u0018\u00002\u00020\u0001B\u0014\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000bJ5\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0012H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ \u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\n¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b \u0010!J\r\u0010\"\u001a\u00020\t¢\u0006\u0004\b#\u0010\u000bJP\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u000f26\u0010&\u001a2\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\t0'H\b¢\u0006\u0004\b,\u0010-J\u001b\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u00101J(\u0010.\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u00102\u001a\u00020\u000fH\n¢\u0006\u0004\b3\u00104J\u0015\u00105\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u000f¢\u0006\u0004\b6\u00107J\u0015\u00108\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u000f¢\u0006\u0004\b9\u00107J\u0015\u0010:\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u000f¢\u0006\u0004\b;\u00107J\u0015\u0010<\u001a\u00020\t2\u0006\u0010=\u001a\u00020\u000f¢\u0006\u0004\b>\u00107J-\u0010?\u001a\u00020\t2\u0006\u0010@\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020\u000f2\u0006\u0010B\u001a\u00020\u000f2\u0006\u0010C\u001a\u00020\u000f¢\u0006\u0004\bD\u0010EJ\u001e\u0010F\u001a\u00020\t2\u0006\u0010G\u001a\u00020\u0000H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bH\u00101J\u0010\u0010I\u001a\u00020JHÖ\u0001¢\u0006\u0004\bK\u0010LR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0001\u0002ø\u0001\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006M"}, d2 = {"Landroidx/compose/ui/graphics/ColorMatrix;", "", "values", "", "constructor-impl", "([F)[F", "getValues", "()[F", "convertRgbToYuv", "", "convertRgbToYuv-impl", "([F)V", "convertYuvToRgb", "convertYuvToRgb-impl", "dot", "", "m1", "row", "", "m2", "column", "dot-Me4OoYI", "([F[FI[FI)F", "equals", "", "other", "equals-impl", "([FLjava/lang/Object;)Z", "get", "get-impl", "([FII)F", "hashCode", "hashCode-impl", "([F)I", "reset", "reset-impl", "rotateInternal", "degrees", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "cosine", "sine", "rotateInternal-impl", "([FFLkotlin/jvm/functions/Function2;)V", "set", "src", "set-jHG-Opc", "([F[F)V", "v", "set-impl", "([FIIF)V", "setToRotateBlue", "setToRotateBlue-impl", "([FF)V", "setToRotateGreen", "setToRotateGreen-impl", "setToRotateRed", "setToRotateRed-impl", "setToSaturation", "sat", "setToSaturation-impl", "setToScale", "redScale", "greenScale", "blueScale", "alphaScale", "setToScale-impl", "([FFFFF)V", "timesAssign", "colorMatrix", "timesAssign-jHG-Opc", "toString", "", "toString-impl", "([F)Ljava/lang/String;", "ui-graphics_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@JvmInline
/* compiled from: ColorMatrix.kt */
public final class ColorMatrix {
    private final float[] values;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ ColorMatrix m1652boximpl(float[] fArr) {
        return new ColorMatrix(fArr);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static float[] m1653constructorimpl(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "values");
        return fArr;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m1658equalsimpl(float[] fArr, Object obj) {
        return (obj instanceof ColorMatrix) && Intrinsics.areEqual((Object) fArr, (Object) ((ColorMatrix) obj).m1673unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m1659equalsimpl0(float[] fArr, float[] fArr2) {
        return Intrinsics.areEqual((Object) fArr, (Object) fArr2);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m1661hashCodeimpl(float[] fArr) {
        return Arrays.hashCode(fArr);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m1672toStringimpl(float[] fArr) {
        return "ColorMatrix(values=" + Arrays.toString(fArr) + ')';
    }

    public boolean equals(Object obj) {
        return m1658equalsimpl(this.values, obj);
    }

    public int hashCode() {
        return m1661hashCodeimpl(this.values);
    }

    public String toString() {
        return m1672toStringimpl(this.values);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ float[] m1673unboximpl() {
        return this.values;
    }

    private /* synthetic */ ColorMatrix(float[] fArr) {
        this.values = fArr;
    }

    public final float[] getValues() {
        return this.values;
    }

    /* renamed from: constructor-impl$default  reason: not valid java name */
    public static /* synthetic */ float[] m1654constructorimpl$default(float[] fArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            fArr = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
        }
        return m1653constructorimpl(fArr);
    }

    /* renamed from: get-impl  reason: not valid java name */
    public static final float m1660getimpl(float[] fArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(fArr, "arg0");
        return fArr[(i * 5) + i2];
    }

    /* renamed from: set-impl  reason: not valid java name */
    public static final void m1664setimpl(float[] fArr, int i, int i2, float f) {
        Intrinsics.checkNotNullParameter(fArr, "arg0");
        fArr[(i * 5) + i2] = f;
    }

    /* renamed from: reset-impl  reason: not valid java name */
    public static final void m1662resetimpl(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "arg0");
        ArraysKt.fill$default(fArr, 0.0f, 0, 0, 6, (Object) null);
        fArr[0] = 1.0f;
        fArr[12] = 1.0f;
        fArr[6] = 1.0f;
        fArr[18] = 1.0f;
    }

    /* renamed from: set-jHG-Opc  reason: not valid java name */
    public static final void m1665setjHGOpc(float[] fArr, float[] fArr2) {
        Intrinsics.checkNotNullParameter(fArr, "arg0");
        Intrinsics.checkNotNullParameter(fArr2, ReactVideoViewManager.PROP_SRC);
        ArraysKt.copyInto$default(fArr2, fArr, 0, 0, 0, 14, (Object) null);
    }

    /* renamed from: rotateInternal-impl  reason: not valid java name */
    private static final void m1663rotateInternalimpl(float[] fArr, float f, Function2<? super Float, ? super Float, Unit> function2) {
        m1662resetimpl(fArr);
        double d = (((double) f) * 3.141592653589793d) / 180.0d;
        function2.invoke(Float.valueOf((float) Math.cos(d)), Float.valueOf((float) Math.sin(d)));
    }

    /* renamed from: timesAssign-jHG-Opc  reason: not valid java name */
    public static final void m1671timesAssignjHGOpc(float[] fArr, float[] fArr2) {
        float[] fArr3 = fArr;
        float[] fArr4 = fArr2;
        Intrinsics.checkNotNullParameter(fArr3, "arg0");
        Intrinsics.checkNotNullParameter(fArr4, "colorMatrix");
        float r3 = m1657dotMe4OoYI(fArr3, fArr3, 0, fArr4, 0);
        float r5 = m1657dotMe4OoYI(fArr3, fArr3, 0, fArr4, 1);
        float r7 = m1657dotMe4OoYI(fArr3, fArr3, 0, fArr4, 2);
        float r9 = m1657dotMe4OoYI(fArr3, fArr3, 0, fArr4, 3);
        float f = (fArr3[0] * fArr4[4]) + (fArr3[1] * fArr4[9]) + (fArr3[2] * fArr4[14]) + (fArr3[3] * fArr4[19]) + fArr3[4];
        float r12 = m1657dotMe4OoYI(fArr3, fArr3, 1, fArr4, 0);
        float r16 = m1657dotMe4OoYI(fArr3, fArr3, 1, fArr4, 1);
        float r17 = m1657dotMe4OoYI(fArr3, fArr3, 1, fArr4, 2);
        float r18 = m1657dotMe4OoYI(fArr3, fArr3, 1, fArr4, 3);
        float f2 = (fArr3[5] * fArr4[4]) + (fArr3[6] * fArr4[9]) + (fArr3[7] * fArr4[14]) + (fArr3[8] * fArr4[19]) + fArr3[9];
        float r24 = m1657dotMe4OoYI(fArr3, fArr3, 2, fArr4, 0);
        float r25 = m1657dotMe4OoYI(fArr3, fArr3, 2, fArr4, 1);
        float r26 = m1657dotMe4OoYI(fArr3, fArr3, 2, fArr4, 2);
        float r27 = m1657dotMe4OoYI(fArr3, fArr3, 2, fArr4, 3);
        float f3 = (fArr3[10] * fArr4[4]) + (fArr3[11] * fArr4[9]) + (fArr3[12] * fArr4[14]) + (fArr3[13] * fArr4[19]) + fArr3[14];
        float r33 = m1657dotMe4OoYI(fArr3, fArr3, 3, fArr4, 0);
        float r34 = m1657dotMe4OoYI(fArr3, fArr3, 3, fArr4, 1);
        float r35 = m1657dotMe4OoYI(fArr3, fArr3, 3, fArr4, 2);
        float r36 = m1657dotMe4OoYI(fArr3, fArr3, 3, fArr4, 3);
        fArr3[0] = r3;
        fArr3[1] = r5;
        fArr3[2] = r7;
        fArr3[3] = r9;
        fArr3[4] = f;
        fArr3[5] = r12;
        fArr3[6] = r16;
        fArr3[7] = r17;
        fArr3[8] = r18;
        fArr3[9] = f2;
        fArr3[10] = r24;
        fArr3[11] = r25;
        fArr3[12] = r26;
        fArr3[13] = r27;
        fArr3[14] = f3;
        fArr3[15] = r33;
        fArr3[16] = r34;
        fArr3[17] = r35;
        fArr3[18] = r36;
        fArr3[19] = (fArr3[15] * fArr4[4]) + (fArr3[16] * fArr4[9]) + (fArr3[17] * fArr4[14]) + (fArr3[18] * fArr4[19]) + fArr3[19];
    }

    /* renamed from: setToSaturation-impl  reason: not valid java name */
    public static final void m1669setToSaturationimpl(float[] fArr, float f) {
        Intrinsics.checkNotNullParameter(fArr, "arg0");
        m1662resetimpl(fArr);
        float f2 = ((float) 1) - f;
        float f3 = 0.213f * f2;
        float f4 = 0.715f * f2;
        float f5 = f2 * 0.072f;
        fArr[0] = f3 + f;
        fArr[1] = f4;
        fArr[2] = f5;
        fArr[5] = f3;
        fArr[6] = f4 + f;
        fArr[7] = f5;
        fArr[10] = f3;
        fArr[11] = f4;
        fArr[12] = f5 + f;
    }

    /* renamed from: setToScale-impl  reason: not valid java name */
    public static final void m1670setToScaleimpl(float[] fArr, float f, float f2, float f3, float f4) {
        Intrinsics.checkNotNullParameter(fArr, "arg0");
        m1662resetimpl(fArr);
        fArr[0] = f;
        fArr[6] = f2;
        fArr[12] = f3;
        fArr[18] = f4;
    }

    /* renamed from: convertRgbToYuv-impl  reason: not valid java name */
    public static final void m1655convertRgbToYuvimpl(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "arg0");
        m1662resetimpl(fArr);
        fArr[0] = 0.299f;
        fArr[1] = 0.587f;
        fArr[2] = 0.114f;
        fArr[5] = -0.16874f;
        fArr[6] = -0.33126f;
        fArr[7] = 0.5f;
        fArr[10] = 0.5f;
        fArr[11] = -0.41869f;
        fArr[12] = -0.08131f;
    }

    /* renamed from: convertYuvToRgb-impl  reason: not valid java name */
    public static final void m1656convertYuvToRgbimpl(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "arg0");
        m1662resetimpl(fArr);
        fArr[2] = 1.402f;
        fArr[5] = 1.0f;
        fArr[6] = -0.34414f;
        fArr[7] = -0.71414f;
        fArr[10] = 1.0f;
        fArr[11] = 1.772f;
        fArr[12] = 0.0f;
    }

    /* renamed from: dot-Me4OoYI  reason: not valid java name */
    private static final float m1657dotMe4OoYI(float[] fArr, float[] fArr2, int i, float[] fArr3, int i2) {
        int i3 = i * 5;
        return (fArr2[i3 + 0] * fArr3[0 + i2]) + (fArr2[i3 + 1] * fArr3[5 + i2]) + (fArr2[i3 + 2] * fArr3[10 + i2]) + (fArr2[i3 + 3] * fArr3[15 + i2]);
    }

    /* renamed from: setToRotateRed-impl  reason: not valid java name */
    public static final void m1668setToRotateRedimpl(float[] fArr, float f) {
        Intrinsics.checkNotNullParameter(fArr, "arg0");
        m1662resetimpl(fArr);
        double d = (((double) f) * 3.141592653589793d) / 180.0d;
        float cos = (float) Math.cos(d);
        float sin = (float) Math.sin(d);
        fArr[12] = cos;
        fArr[6] = cos;
        fArr[7] = sin;
        fArr[11] = -sin;
    }

    /* renamed from: setToRotateGreen-impl  reason: not valid java name */
    public static final void m1667setToRotateGreenimpl(float[] fArr, float f) {
        Intrinsics.checkNotNullParameter(fArr, "arg0");
        m1662resetimpl(fArr);
        double d = (((double) f) * 3.141592653589793d) / 180.0d;
        float cos = (float) Math.cos(d);
        float sin = (float) Math.sin(d);
        fArr[12] = cos;
        fArr[0] = cos;
        fArr[2] = -sin;
        fArr[10] = sin;
    }

    /* renamed from: setToRotateBlue-impl  reason: not valid java name */
    public static final void m1666setToRotateBlueimpl(float[] fArr, float f) {
        Intrinsics.checkNotNullParameter(fArr, "arg0");
        m1662resetimpl(fArr);
        double d = (((double) f) * 3.141592653589793d) / 180.0d;
        float cos = (float) Math.cos(d);
        float sin = (float) Math.sin(d);
        fArr[6] = cos;
        fArr[0] = cos;
        fArr[1] = sin;
        fArr[5] = -sin;
    }
}
