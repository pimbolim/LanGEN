package androidx.compose.ui.text.platform.extensions;

import android.os.Build;
import android.text.Spannable;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.LeadingMarginSpan;
import android.text.style.LocaleSpan;
import android.text.style.MetricAffectingSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.ScaleXSpan;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.AnnotatedStringKt;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.android.style.BaselineShiftSpan;
import androidx.compose.ui.text.android.style.FontFeatureSpan;
import androidx.compose.ui.text.android.style.LetterSpacingSpanEm;
import androidx.compose.ui.text.android.style.LetterSpacingSpanPx;
import androidx.compose.ui.text.android.style.LineHeightSpan;
import androidx.compose.ui.text.android.style.ShadowSpan;
import androidx.compose.ui.text.android.style.SkewXSpan;
import androidx.compose.ui.text.android.style.TextDecorationSpan;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.platform.TypefaceAdapter;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000®\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a'\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007\u001aF\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u000e0\r2\u001e\u0010\u000f\u001a\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\t0\u0010H\u0000\u001a\f\u0010\u0012\u001a\u00020\u0013*\u00020\u0014H\u0002\u001a\u0016\u0010\u0015\u001a\u00020\u000b*\u0004\u0018\u00010\u000b2\u0006\u0010\u0016\u001a\u00020\u000bH\u0002\u001a1\u0010\u0017\u001a\u00020\t*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0011H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001e\u001a1\u0010\u001f\u001a\u00020\t*\u00020\u00182\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0011H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\"\u001a1\u0010#\u001a\u00020\t*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0011H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010\u001e\u001a0\u0010%\u001a\u00020\t*\u00020\u00182\u0006\u0010&\u001a\u00020\u00142\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u000e0\r2\u0006\u0010'\u001a\u00020(H\u0002\u001a&\u0010)\u001a\u00020\t*\u00020\u00182\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0011H\u0002\u001a9\u0010,\u001a\u00020\t*\u00020\u00182\u0006\u0010-\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0011H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b.\u0010/\u001a&\u00100\u001a\u00020\t*\u00020\u00182\b\u00101\u001a\u0004\u0018\u0001022\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0011H\u0002\u001a1\u00103\u001a\u00020\t*\u00020\u00182\u0006\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u0002062\u0006\u0010\u0004\u001a\u00020\u0005H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b7\u00108\u001a&\u00109\u001a\u00020\t*\u00020\u00182\b\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0011H\u0000\u001a&\u0010<\u001a\u00020\t*\u00020\u00182\b\u0010=\u001a\u0004\u0018\u00010>2\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0011H\u0002\u001a$\u0010?\u001a\u00020\t*\u00020\u00182\u0006\u0010@\u001a\u00020A2\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0011H\u0000\u001a:\u0010B\u001a\u00020\t*\u00020\u00182\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0016\u0010D\u001a\u0012\u0012\u0004\u0012\u00020F0Ej\b\u0012\u0004\u0012\u00020F`GH\u0002\u001a8\u0010H\u001a\u00020\t*\u00020\u00182\u0006\u0010&\u001a\u00020\u00142\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u000e0\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010'\u001a\u00020(H\u0000\u001a&\u0010I\u001a\u00020\t*\u00020\u00182\b\u0010J\u001a\u0004\u0018\u00010K2\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0011H\u0000\u001a&\u0010L\u001a\u00020\t*\u00020\u00182\b\u0010M\u001a\u0004\u0018\u00010N2\u0006\u00105\u001a\u0002062\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006O"}, d2 = {"createLetterSpacingSpan", "Landroid/text/style/MetricAffectingSpan;", "letterSpacing", "Landroidx/compose/ui/unit/TextUnit;", "density", "Landroidx/compose/ui/unit/Density;", "createLetterSpacingSpan-eAf_CNQ", "(JLandroidx/compose/ui/unit/Density;)Landroid/text/style/MetricAffectingSpan;", "flattenFontStylesAndApply", "", "contextFontSpanStyle", "Landroidx/compose/ui/text/SpanStyle;", "spanStyles", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "block", "Lkotlin/Function3;", "", "hasFontAttributes", "", "Landroidx/compose/ui/text/TextStyle;", "merge", "spanStyle", "setBackground", "Landroid/text/Spannable;", "color", "Landroidx/compose/ui/graphics/Color;", "start", "end", "setBackground-RPmYEkk", "(Landroid/text/Spannable;JII)V", "setBaselineShift", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "setBaselineShift-0ocSgnM", "setColor", "setColor-RPmYEkk", "setFontAttributes", "contextTextStyle", "typefaceAdapter", "Landroidx/compose/ui/text/platform/TypefaceAdapter;", "setFontFeatureSettings", "fontFeatureSettings", "", "setFontSize", "fontSize", "setFontSize-KmRG4DE", "(Landroid/text/Spannable;JLandroidx/compose/ui/unit/Density;II)V", "setGeometricTransform", "textGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "setLineHeight", "lineHeight", "contextFontSize", "", "setLineHeight-r9BaKPg", "(Landroid/text/Spannable;JFLandroidx/compose/ui/unit/Density;)V", "setLocaleList", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "setShadow", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "setSpan", "span", "", "setSpanStyle", "spanStyleRange", "lowPrioritySpans", "Ljava/util/ArrayList;", "Landroidx/compose/ui/text/platform/extensions/SpanRange;", "Lkotlin/collections/ArrayList;", "setSpanStyles", "setTextDecoration", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "setTextIndent", "textIndent", "Landroidx/compose/ui/text/style/TextIndent;", "ui-text_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: SpannableExtensions.android.kt */
public final class SpannableExtensions_androidKt {
    public static final void setSpan(Spannable spannable, Object obj, int i, int i2) {
        Intrinsics.checkNotNullParameter(spannable, "<this>");
        Intrinsics.checkNotNullParameter(obj, "span");
        spannable.setSpan(obj, i, i2, 33);
    }

    public static final void setTextIndent(Spannable spannable, TextIndent textIndent, float f, Density density) {
        float f2;
        Intrinsics.checkNotNullParameter(spannable, "<this>");
        Intrinsics.checkNotNullParameter(density, "density");
        if (textIndent != null) {
            if ((!TextUnit.m4037equalsimpl0(textIndent.m3776getFirstLineXSAIIZE(), TextUnitKt.getSp(0)) || !TextUnit.m4037equalsimpl0(textIndent.m3777getRestLineXSAIIZE(), TextUnitKt.getSp(0))) && !TextUnitKt.m4058isUnspecifiedR2X_6o(textIndent.m3776getFirstLineXSAIIZE()) && !TextUnitKt.m4058isUnspecifiedR2X_6o(textIndent.m3777getRestLineXSAIIZE())) {
                long r0 = TextUnit.m4039getTypeUIouoOA(textIndent.m3776getFirstLineXSAIIZE());
                float f3 = 0.0f;
                if (TextUnitType.m4068equalsimpl0(r0, TextUnitType.Companion.m4073getSpUIouoOA())) {
                    f2 = density.m3827toPxR2X_6o(textIndent.m3776getFirstLineXSAIIZE());
                } else {
                    f2 = TextUnitType.m4068equalsimpl0(r0, TextUnitType.Companion.m4072getEmUIouoOA()) ? TextUnit.m4040getValueimpl(textIndent.m3776getFirstLineXSAIIZE()) * f : 0.0f;
                }
                long r5 = TextUnit.m4039getTypeUIouoOA(textIndent.m3777getRestLineXSAIIZE());
                if (TextUnitType.m4068equalsimpl0(r5, TextUnitType.Companion.m4073getSpUIouoOA())) {
                    f3 = density.m3827toPxR2X_6o(textIndent.m3777getRestLineXSAIIZE());
                } else if (TextUnitType.m4068equalsimpl0(r5, TextUnitType.Companion.m4072getEmUIouoOA())) {
                    f3 = TextUnit.m4040getValueimpl(textIndent.m3777getRestLineXSAIIZE()) * f;
                }
                setSpan(spannable, new LeadingMarginSpan.Standard((int) ((float) Math.ceil((double) f2)), (int) ((float) Math.ceil((double) f3))), 0, spannable.length());
            }
        }
    }

    /* renamed from: setLineHeight-r9BaKPg  reason: not valid java name */
    public static final void m3734setLineHeightr9BaKPg(Spannable spannable, long j, float f, Density density) {
        Intrinsics.checkNotNullParameter(spannable, "$this$setLineHeight");
        Intrinsics.checkNotNullParameter(density, "density");
        long r0 = TextUnit.m4039getTypeUIouoOA(j);
        if (TextUnitType.m4068equalsimpl0(r0, TextUnitType.Companion.m4073getSpUIouoOA())) {
            setSpan(spannable, new LineHeightSpan((int) ((float) Math.ceil((double) density.m3827toPxR2X_6o(j)))), 0, spannable.length());
        } else if (TextUnitType.m4068equalsimpl0(r0, TextUnitType.Companion.m4072getEmUIouoOA())) {
            setSpan(spannable, new LineHeightSpan((int) ((float) Math.ceil((double) (TextUnit.m4040getValueimpl(j) * f)))), 0, spannable.length());
        }
    }

    public static final void setSpanStyles(Spannable spannable, TextStyle textStyle, List<AnnotatedString.Range<SpanStyle>> list, Density density, TypefaceAdapter typefaceAdapter) {
        Intrinsics.checkNotNullParameter(spannable, "<this>");
        Intrinsics.checkNotNullParameter(textStyle, "contextTextStyle");
        Intrinsics.checkNotNullParameter(list, "spanStyles");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(typefaceAdapter, "typefaceAdapter");
        setFontAttributes(spannable, textStyle, list, typefaceAdapter);
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            AnnotatedString.Range range = list.get(i);
            int start = range.getStart();
            int end = range.getEnd();
            if (start >= 0 && start < spannable.length() && end > start && end <= spannable.length()) {
                setSpanStyle(spannable, range, density, arrayList);
            }
            i = i2;
        }
        List list2 = arrayList;
        int size2 = list2.size();
        for (int i3 = 0; i3 < size2; i3++) {
            SpanRange spanRange = (SpanRange) list2.get(i3);
            setSpan(spannable, spanRange.component1(), spanRange.component2(), spanRange.component3());
        }
    }

    private static final void setSpanStyle(Spannable spannable, AnnotatedString.Range<SpanStyle> range, Density density, ArrayList<SpanRange> arrayList) {
        int start = range.getStart();
        int end = range.getEnd();
        SpanStyle item = range.getItem();
        m3731setBaselineShift0ocSgnM(spannable, item.m3541getBaselineShift5SSeXJ0(), start, end);
        m3732setColorRPmYEkk(spannable, item.m3542getColor0d7_KjU(), start, end);
        setTextDecoration(spannable, item.getTextDecoration(), start, end);
        m3733setFontSizeKmRG4DE(spannable, item.m3543getFontSizeXSAIIZE(), density, start, end);
        setFontFeatureSettings(spannable, item.getFontFeatureSettings(), start, end);
        setGeometricTransform(spannable, item.getTextGeometricTransform(), start, end);
        setLocaleList(spannable, item.getLocaleList(), start, end);
        m3730setBackgroundRPmYEkk(spannable, item.m3540getBackground0d7_KjU(), start, end);
        setShadow(spannable, item.getShadow(), start, end);
        MetricAffectingSpan r8 = m3729createLetterSpacingSpaneAf_CNQ(item.m3546getLetterSpacingXSAIIZE(), density);
        if (r8 != null) {
            arrayList.add(new SpanRange(r8, start, end));
        }
    }

    public static final void flattenFontStylesAndApply(SpanStyle spanStyle, List<AnnotatedString.Range<SpanStyle>> list, Function3<? super SpanStyle, ? super Integer, ? super Integer, Unit> function3) {
        Intrinsics.checkNotNullParameter(list, "spanStyles");
        Intrinsics.checkNotNullParameter(function3, "block");
        if (list.size() > 1) {
            int size = list.size();
            int i = size * 2;
            Integer[] numArr = new Integer[i];
            for (int i2 = 0; i2 < i; i2++) {
                numArr[i2] = 0;
            }
            int size2 = list.size();
            for (int i3 = 0; i3 < size2; i3++) {
                AnnotatedString.Range range = list.get(i3);
                numArr[i3] = Integer.valueOf(range.getStart());
                numArr[i3 + size] = Integer.valueOf(range.getEnd());
            }
            ArraysKt.sort((T[]) (Comparable[]) numArr);
            int intValue = ((Number) ArraysKt.first((T[]) numArr)).intValue();
            int i4 = 0;
            while (i4 < i) {
                int intValue2 = numArr[i4].intValue();
                i4++;
                if (intValue2 != intValue) {
                    int size3 = list.size();
                    SpanStyle spanStyle2 = spanStyle;
                    int i5 = 0;
                    while (i5 < size3) {
                        int i6 = i5 + 1;
                        AnnotatedString.Range range2 = list.get(i5);
                        if (AnnotatedStringKt.intersect(intValue, intValue2, range2.getStart(), range2.getEnd())) {
                            spanStyle2 = merge(spanStyle2, (SpanStyle) range2.getItem());
                        }
                        i5 = i6;
                    }
                    if (spanStyle2 != null) {
                        function3.invoke(spanStyle2, Integer.valueOf(intValue), Integer.valueOf(intValue2));
                    }
                    intValue = intValue2;
                }
            }
        } else if (!list.isEmpty()) {
            function3.invoke(merge(spanStyle, (SpanStyle) list.get(0).getItem()), Integer.valueOf(list.get(0).getStart()), Integer.valueOf(list.get(0).getEnd()));
        }
    }

    /* renamed from: createLetterSpacingSpan-eAf_CNQ  reason: not valid java name */
    private static final MetricAffectingSpan m3729createLetterSpacingSpaneAf_CNQ(long j, Density density) {
        long r0 = TextUnit.m4039getTypeUIouoOA(j);
        if (TextUnitType.m4068equalsimpl0(r0, TextUnitType.Companion.m4073getSpUIouoOA())) {
            return new LetterSpacingSpanPx(density.m3827toPxR2X_6o(j));
        }
        if (TextUnitType.m4068equalsimpl0(r0, TextUnitType.Companion.m4072getEmUIouoOA())) {
            return new LetterSpacingSpanEm(TextUnit.m4040getValueimpl(j));
        }
        return null;
    }

    private static final void setShadow(Spannable spannable, Shadow shadow, int i, int i2) {
        if (shadow != null) {
            setSpan(spannable, new ShadowSpan(ColorKt.m1651toArgb8_81llA(shadow.m1893getColor0d7_KjU()), Offset.m1353getXimpl(shadow.m1894getOffsetF1C5BW0()), Offset.m1354getYimpl(shadow.m1894getOffsetF1C5BW0()), shadow.getBlurRadius()), i, i2);
        }
    }

    public static final void setLocaleList(Spannable spannable, LocaleList localeList, int i, int i2) {
        Object obj;
        Intrinsics.checkNotNullParameter(spannable, "<this>");
        if (localeList != null) {
            if (Build.VERSION.SDK_INT >= 24) {
                obj = LocaleListHelperMethods.INSTANCE.localeSpan(localeList);
            } else {
                obj = new LocaleSpan(LocaleExtensions_androidKt.toJavaLocale(localeList.isEmpty() ? Locale.Companion.getCurrent() : localeList.get(0)));
            }
            setSpan(spannable, obj, i, i2);
        }
    }

    private static final void setGeometricTransform(Spannable spannable, TextGeometricTransform textGeometricTransform, int i, int i2) {
        if (textGeometricTransform != null) {
            setSpan(spannable, new ScaleXSpan(textGeometricTransform.getScaleX()), i, i2);
            setSpan(spannable, new SkewXSpan(textGeometricTransform.getSkewX()), i, i2);
        }
    }

    private static final void setFontFeatureSettings(Spannable spannable, String str, int i, int i2) {
        if (str != null) {
            setSpan(spannable, new FontFeatureSpan(str), i, i2);
        }
    }

    /* renamed from: setFontSize-KmRG4DE  reason: not valid java name */
    public static final void m3733setFontSizeKmRG4DE(Spannable spannable, long j, Density density, int i, int i2) {
        Intrinsics.checkNotNullParameter(spannable, "$this$setFontSize");
        Intrinsics.checkNotNullParameter(density, "density");
        long r0 = TextUnit.m4039getTypeUIouoOA(j);
        if (TextUnitType.m4068equalsimpl0(r0, TextUnitType.Companion.m4073getSpUIouoOA())) {
            setSpan(spannable, new AbsoluteSizeSpan(MathKt.roundToInt(density.m3827toPxR2X_6o(j)), false), i, i2);
        } else if (TextUnitType.m4068equalsimpl0(r0, TextUnitType.Companion.m4072getEmUIouoOA())) {
            setSpan(spannable, new RelativeSizeSpan(TextUnit.m4040getValueimpl(j)), i, i2);
        }
    }

    public static final void setTextDecoration(Spannable spannable, TextDecoration textDecoration, int i, int i2) {
        Intrinsics.checkNotNullParameter(spannable, "<this>");
        if (textDecoration != null) {
            setSpan(spannable, new TextDecorationSpan(textDecoration.contains(TextDecoration.Companion.getUnderline()), textDecoration.contains(TextDecoration.Companion.getLineThrough())), i, i2);
        }
    }

    /* renamed from: setBaselineShift-0ocSgnM  reason: not valid java name */
    private static final void m3731setBaselineShift0ocSgnM(Spannable spannable, BaselineShift baselineShift, int i, int i2) {
        if (baselineShift != null) {
            setSpan(spannable, new BaselineShiftSpan(baselineShift.m3741unboximpl()), i, i2);
        }
    }

    private static final boolean hasFontAttributes(TextStyle textStyle) {
        return TextPaintExtensions_androidKt.hasFontAttributes(textStyle.toSpanStyle()) || textStyle.m3586getFontSynthesisZQGJjVo() != null;
    }

    private static final SpanStyle merge(SpanStyle spanStyle, SpanStyle spanStyle2) {
        return spanStyle == null ? spanStyle2 : spanStyle.merge(spanStyle2);
    }

    private static final void setFontAttributes(Spannable spannable, TextStyle textStyle, List<AnnotatedString.Range<SpanStyle>> list, TypefaceAdapter typefaceAdapter) {
        SpanStyle spanStyle;
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            AnnotatedString.Range<SpanStyle> range = list.get(i);
            AnnotatedString.Range range2 = range;
            if (TextPaintExtensions_androidKt.hasFontAttributes((SpanStyle) range2.getItem()) || ((SpanStyle) range2.getItem()).m3545getFontSynthesisZQGJjVo() != null) {
                arrayList.add(range);
            }
            i = i2;
        }
        List list2 = arrayList;
        if (hasFontAttributes(textStyle)) {
            spanStyle = new SpanStyle(0, 0, textStyle.getFontWeight(), textStyle.m3585getFontStyle4Lr2A7w(), textStyle.m3586getFontSynthesisZQGJjVo(), textStyle.getFontFamily(), (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, 16323, (DefaultConstructorMarker) null);
        } else {
            spanStyle = null;
        }
        flattenFontStylesAndApply(spanStyle, list2, new SpannableExtensions_androidKt$setFontAttributes$1(spannable, typefaceAdapter));
    }

    /* renamed from: setBackground-RPmYEkk  reason: not valid java name */
    public static final void m3730setBackgroundRPmYEkk(Spannable spannable, long j, int i, int i2) {
        Intrinsics.checkNotNullParameter(spannable, "$this$setBackground");
        if (j != Color.Companion.m1632getUnspecified0d7_KjU()) {
            setSpan(spannable, new BackgroundColorSpan(ColorKt.m1651toArgb8_81llA(j)), i, i2);
        }
    }

    /* renamed from: setColor-RPmYEkk  reason: not valid java name */
    public static final void m3732setColorRPmYEkk(Spannable spannable, long j, int i, int i2) {
        Intrinsics.checkNotNullParameter(spannable, "$this$setColor");
        if (j != Color.Companion.m1632getUnspecified0d7_KjU()) {
            setSpan(spannable, new ForegroundColorSpan(ColorKt.m1651toArgb8_81llA(j)), i, i2);
        }
    }
}
