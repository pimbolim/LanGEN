package androidx.compose.ui.text.platform;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ScaleXSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.InternalTextApi;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TtsAnnotation;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontMatcher;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.GenericFontFamily;
import androidx.compose.ui.text.platform.extensions.SpannableExtensions_androidKt;
import androidx.compose.ui.text.platform.extensions.TtsAnnotationExtensions_androidKt;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a4\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a\u001c\u0010\f\u001a\u00020\u0002*\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007¨\u0006\u0010"}, d2 = {"setSpanStyle", "", "Landroid/text/SpannableString;", "spanStyle", "Landroidx/compose/ui/text/SpanStyle;", "start", "", "end", "density", "Landroidx/compose/ui/unit/Density;", "typefaceAdapter", "Landroidx/compose/ui/text/platform/TypefaceAdapter;", "toAccessibilitySpannableString", "Landroidx/compose/ui/text/AnnotatedString;", "resourceLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "ui-text_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: AndroidAccessibilitySpannableString.android.kt */
public final class AndroidAccessibilitySpannableString_androidKt {
    @InternalTextApi
    public static final SpannableString toAccessibilitySpannableString(AnnotatedString annotatedString, Density density, Font.ResourceLoader resourceLoader) {
        Intrinsics.checkNotNullParameter(annotatedString, "<this>");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(resourceLoader, "resourceLoader");
        SpannableString spannableString = new SpannableString(annotatedString.getText());
        TypefaceAdapter typefaceAdapter = new TypefaceAdapter((FontMatcher) null, resourceLoader, 1, (DefaultConstructorMarker) null);
        List<AnnotatedString.Range<SpanStyle>> spanStyles = annotatedString.getSpanStyles();
        int size = spanStyles.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            AnnotatedString.Range range = spanStyles.get(i);
            int component2 = range.component2();
            int component3 = range.component3();
            setSpanStyle(spannableString, (SpanStyle) range.component1(), component2, component3, density, typefaceAdapter);
            i = i2;
        }
        List<AnnotatedString.Range<TtsAnnotation>> ttsAnnotations = annotatedString.getTtsAnnotations(0, annotatedString.length());
        int size2 = ttsAnnotations.size();
        for (int i3 = 0; i3 < size2; i3++) {
            AnnotatedString.Range range2 = ttsAnnotations.get(i3);
            spannableString.setSpan(TtsAnnotationExtensions_androidKt.toSpan((TtsAnnotation) range2.component1()), range2.component2(), range2.component3(), 33);
        }
        return spannableString;
    }

    private static final void setSpanStyle(SpannableString spannableString, SpanStyle spanStyle, int i, int i2, Density density, TypefaceAdapter typefaceAdapter) {
        SpannableString spannableString2 = spannableString;
        int i3 = i;
        int i4 = i2;
        Spannable spannable = spannableString2;
        SpannableExtensions_androidKt.m3732setColorRPmYEkk(spannable, spanStyle.m3542getColor0d7_KjU(), i3, i4);
        SpannableExtensions_androidKt.m3733setFontSizeKmRG4DE(spannable, spanStyle.m3543getFontSizeXSAIIZE(), density, i, i2);
        if (!(spanStyle.getFontWeight() == null && spanStyle.m3544getFontStyle4Lr2A7w() == null)) {
            FontWeight fontWeight = spanStyle.getFontWeight();
            if (fontWeight == null) {
                fontWeight = FontWeight.Companion.getNormal();
            }
            FontStyle r3 = spanStyle.m3544getFontStyle4Lr2A7w();
            spannableString2.setSpan(new StyleSpan(TypefaceAdapter.Companion.m3723getTypefaceStyleFO1MlWM(fontWeight, r3 == null ? FontStyle.Companion.m3617getNormal_LCdwA() : r3.m3615unboximpl())), i3, i4, 33);
        }
        if (spanStyle.getFontFamily() != null) {
            if (spanStyle.getFontFamily() instanceof GenericFontFamily) {
                spannableString2.setSpan(new TypefaceSpan(((GenericFontFamily) spanStyle.getFontFamily()).getName()), i3, i4, 33);
            } else if (Build.VERSION.SDK_INT >= 28) {
                FontFamily fontFamily = spanStyle.getFontFamily();
                FontSynthesis r1 = spanStyle.m3545getFontSynthesisZQGJjVo();
                spannableString2.setSpan(Api28Impl.INSTANCE.createTypefaceSpan(TypefaceAdapter.m3711createDPcqOEQ$default(typefaceAdapter, fontFamily, (FontWeight) null, 0, r1 == null ? FontSynthesis.Companion.m3627getAllGVVA2EU() : r1.m3626unboximpl(), 6, (Object) null)), i3, i4, 33);
            }
        }
        if (spanStyle.getTextDecoration() != null) {
            if (spanStyle.getTextDecoration().contains(TextDecoration.Companion.getUnderline())) {
                spannableString2.setSpan(new UnderlineSpan(), i3, i4, 33);
            }
            if (spanStyle.getTextDecoration().contains(TextDecoration.Companion.getLineThrough())) {
                spannableString2.setSpan(new StrikethroughSpan(), i3, i4, 33);
            }
        }
        if (spanStyle.getTextGeometricTransform() != null) {
            spannableString2.setSpan(new ScaleXSpan(spanStyle.getTextGeometricTransform().getScaleX()), i3, i4, 33);
        }
        SpannableExtensions_androidKt.setLocaleList(spannable, spanStyle.getLocaleList(), i3, i4);
        SpannableExtensions_androidKt.m3730setBackgroundRPmYEkk(spannable, spanStyle.m3540getBackground0d7_KjU(), i3, i4);
    }
}
