package androidx.compose.ui.graphics;

import android.graphics.BitmapShader;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.os.Build;
import androidx.compose.ui.geometry.Offset;
import com.BV.LinearGradient.LinearGradientManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a1\u0010\u0000\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\t\u001aO\u0010\n\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000f2\u0006\u0010\u0013\u001a\u00020\u0006H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015\u001aO\u0010\u0016\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00122\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000f2\u0006\u0010\u0013\u001a\u00020\u0006H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001a\u001a?\u0010\u001b\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0017\u001a\u00020\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000fH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0019\u0010\u001e\u001a\u00020\u001f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0001ø\u0001\u0000\u001a!\u0010 \u001a\u00020!2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\"\u001a\u00020\u001fH\u0001ø\u0001\u0000\u001a3\u0010#\u001a\u0004\u0018\u00010$2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\"\u001a\u00020\u001fH\u0001ø\u0001\u0000\u001a)\u0010&\u001a\u00020'2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000fH\u0002ø\u0001\u0000*\n\u0010(\"\u00020\u00012\u00020\u0001\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006)"}, d2 = {"ActualImageShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "tileModeX", "Landroidx/compose/ui/graphics/TileMode;", "tileModeY", "ActualImageShader-F49vj9s", "(Landroidx/compose/ui/graphics/ImageBitmap;II)Landroid/graphics/Shader;", "ActualLinearGradientShader", "from", "Landroidx/compose/ui/geometry/Offset;", "to", "colors", "", "Landroidx/compose/ui/graphics/Color;", "colorStops", "", "tileMode", "ActualLinearGradientShader-VjE6UOU", "(JJLjava/util/List;Ljava/util/List;I)Landroid/graphics/Shader;", "ActualRadialGradientShader", "center", "radius", "ActualRadialGradientShader-8uybcMk", "(JFLjava/util/List;Ljava/util/List;I)Landroid/graphics/Shader;", "ActualSweepGradientShader", "ActualSweepGradientShader-9KIMszo", "(JLjava/util/List;Ljava/util/List;)Landroid/graphics/Shader;", "countTransparentColors", "", "makeTransparentColors", "", "numTransparentColors", "makeTransparentStops", "", "stops", "validateColorStops", "", "Shader", "ui-graphics_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: AndroidShader.android.kt */
public final class AndroidShader_androidKt {
    /* renamed from: ActualLinearGradientShader-VjE6UOU  reason: not valid java name */
    public static final Shader m1493ActualLinearGradientShaderVjE6UOU(long j, long j2, List<Color> list, List<Float> list2, int i) {
        List<Color> list3 = list;
        Intrinsics.checkNotNullParameter(list, LinearGradientManager.PROP_COLORS);
        validateColorStops(list, list2);
        int countTransparentColors = countTransparentColors(list);
        return new LinearGradient(Offset.m1353getXimpl(j), Offset.m1354getYimpl(j), Offset.m1353getXimpl(j2), Offset.m1354getYimpl(j2), makeTransparentColors(list, countTransparentColors), makeTransparentStops(list2, list, countTransparentColors), AndroidTileMode_androidKt.m1497toAndroidTileMode0vamqd0(i));
    }

    /* renamed from: ActualRadialGradientShader-8uybcMk  reason: not valid java name */
    public static final Shader m1494ActualRadialGradientShader8uybcMk(long j, float f, List<Color> list, List<Float> list2, int i) {
        Intrinsics.checkNotNullParameter(list, LinearGradientManager.PROP_COLORS);
        validateColorStops(list, list2);
        int countTransparentColors = countTransparentColors(list);
        return new RadialGradient(Offset.m1353getXimpl(j), Offset.m1354getYimpl(j), f, makeTransparentColors(list, countTransparentColors), makeTransparentStops(list2, list, countTransparentColors), AndroidTileMode_androidKt.m1497toAndroidTileMode0vamqd0(i));
    }

    /* renamed from: ActualSweepGradientShader-9KIMszo  reason: not valid java name */
    public static final Shader m1495ActualSweepGradientShader9KIMszo(long j, List<Color> list, List<Float> list2) {
        Intrinsics.checkNotNullParameter(list, LinearGradientManager.PROP_COLORS);
        validateColorStops(list, list2);
        int countTransparentColors = countTransparentColors(list);
        return new SweepGradient(Offset.m1353getXimpl(j), Offset.m1354getYimpl(j), makeTransparentColors(list, countTransparentColors), makeTransparentStops(list2, list, countTransparentColors));
    }

    /* renamed from: ActualImageShader-F49vj9s  reason: not valid java name */
    public static final Shader m1492ActualImageShaderF49vj9s(ImageBitmap imageBitmap, int i, int i2) {
        Intrinsics.checkNotNullParameter(imageBitmap, "image");
        return new BitmapShader(AndroidImageBitmap_androidKt.asAndroidBitmap(imageBitmap), AndroidTileMode_androidKt.m1497toAndroidTileMode0vamqd0(i), AndroidTileMode_androidKt.m1497toAndroidTileMode0vamqd0(i2));
    }

    public static final int countTransparentColors(List<Color> list) {
        Intrinsics.checkNotNullParameter(list, LinearGradientManager.PROP_COLORS);
        if (Build.VERSION.SDK_INT >= 26) {
            return 0;
        }
        int lastIndex = CollectionsKt.getLastIndex(list);
        int i = 1;
        int i2 = 0;
        while (i < lastIndex) {
            int i3 = i + 1;
            if (Color.m1598getAlphaimpl(list.get(i).m1606unboximpl()) == 0.0f) {
                i2++;
            }
            i = i3;
        }
        return i2;
    }

    public static final int[] makeTransparentColors(List<Color> list, int i) {
        int i2;
        List<Color> list2 = list;
        Intrinsics.checkNotNullParameter(list2, LinearGradientManager.PROP_COLORS);
        if (Build.VERSION.SDK_INT >= 26) {
            int size = list.size();
            int[] iArr = new int[size];
            for (int i3 = 0; i3 < size; i3++) {
                iArr[i3] = ColorKt.m1651toArgb8_81llA(list2.get(i3).m1606unboximpl());
            }
            return iArr;
        }
        int[] iArr2 = new int[(list.size() + i)];
        int lastIndex = CollectionsKt.getLastIndex(list);
        int size2 = list.size();
        int i4 = 0;
        int i5 = 0;
        while (i4 < size2) {
            int i6 = i4 + 1;
            long r8 = list2.get(i4).m1606unboximpl();
            if (!(Color.m1598getAlphaimpl(r8) == 0.0f)) {
                i2 = i5 + 1;
                iArr2[i5] = ColorKt.m1651toArgb8_81llA(r8);
            } else if (i4 == 0) {
                i2 = i5 + 1;
                iArr2[i5] = ColorKt.m1651toArgb8_81llA(Color.m1595copywmQWz5c$default(list2.get(1).m1606unboximpl(), 0.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null));
            } else {
                if (i4 == lastIndex) {
                    iArr2[i5] = ColorKt.m1651toArgb8_81llA(Color.m1595copywmQWz5c$default(list2.get(i4 - 1).m1606unboximpl(), 0.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null));
                    i5++;
                } else {
                    long r82 = list2.get(i4 - 1).m1606unboximpl();
                    int i7 = i5 + 1;
                    iArr2[i5] = ColorKt.m1651toArgb8_81llA(Color.m1595copywmQWz5c$default(r82, 0.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null));
                    i5 = i7 + 1;
                    iArr2[i7] = ColorKt.m1651toArgb8_81llA(Color.m1595copywmQWz5c$default(list2.get(i6).m1606unboximpl(), 0.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null));
                }
                i4 = i6;
            }
            i5 = i2;
            i4 = i6;
        }
        return iArr2;
    }

    public static final float[] makeTransparentStops(List<Float> list, List<Color> list2, int i) {
        float f;
        Float f2;
        Float f3;
        Float f4;
        Intrinsics.checkNotNullParameter(list2, LinearGradientManager.PROP_COLORS);
        if (i != 0) {
            float[] fArr = new float[(list2.size() + i)];
            if (list == null || (f4 = list.get(0)) == null) {
                f = 0.0f;
            } else {
                f = f4.floatValue();
            }
            fArr[0] = f;
            int lastIndex = CollectionsKt.getLastIndex(list2);
            int i2 = 1;
            int i3 = 1;
            while (i2 < lastIndex) {
                int i4 = i2 + 1;
                long r8 = list2.get(i2).m1606unboximpl();
                if (list == null) {
                    f3 = null;
                } else {
                    f3 = list.get(i2);
                }
                float lastIndex2 = f3 == null ? ((float) i2) / ((float) CollectionsKt.getLastIndex(list2)) : f3.floatValue();
                int i5 = i3 + 1;
                fArr[i3] = lastIndex2;
                if (Color.m1598getAlphaimpl(r8) == 0.0f) {
                    i3 = i5 + 1;
                    fArr[i5] = lastIndex2;
                    i2 = i4;
                } else {
                    i2 = i4;
                    i3 = i5;
                }
            }
            float f5 = 1.0f;
            if (!(list == null || (f2 = list.get(CollectionsKt.getLastIndex(list2))) == null)) {
                f5 = f2.floatValue();
            }
            fArr[i3] = f5;
            return fArr;
        } else if (list == null) {
            return null;
        } else {
            return CollectionsKt.toFloatArray(list);
        }
    }

    private static final void validateColorStops(List<Color> list, List<Float> list2) {
        if (list2 == null) {
            if (list.size() < 2) {
                throw new IllegalArgumentException("colors must have length of at least 2 if colorStops is omitted.");
            }
        } else if (list.size() != list2.size()) {
            throw new IllegalArgumentException("colors and colorStops arguments must have equal length.");
        }
    }
}
