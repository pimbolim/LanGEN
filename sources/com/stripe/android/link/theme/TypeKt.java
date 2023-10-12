package com.stripe.android.link.theme;

import androidx.compose.material.Typography;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.SystemFontFamily;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Typography", "Landroidx/compose/material/Typography;", "getTypography", "()Landroidx/compose/material/Typography;", "link_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Type.kt */
public final class TypeKt {
    private static final Typography Typography;

    static {
        SystemFontFamily systemFontFamily = FontFamily.Companion.getDefault();
        TextStyle textStyle = r18;
        TextStyle textStyle2 = new TextStyle(0, TextUnitKt.getSp(24), FontWeight.Companion.getBold(), (FontStyle) null, (FontSynthesis) null, systemFontFamily, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, TextUnitKt.getSp(32), (TextIndent) null, 196569, (DefaultConstructorMarker) null);
        SystemFontFamily systemFontFamily2 = FontFamily.Companion.getDefault();
        TextStyle textStyle3 = r18;
        TextStyle textStyle4 = new TextStyle(0, TextUnitKt.getSp(16), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, systemFontFamily2, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, TextUnitKt.getSp(24), (TextIndent) null, 196569, (DefaultConstructorMarker) null);
        SystemFontFamily systemFontFamily3 = FontFamily.Companion.getDefault();
        TextStyle textStyle5 = r18;
        TextStyle textStyle6 = new TextStyle(0, TextUnitKt.getSp(14), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, systemFontFamily3, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, TextUnitKt.getSp(20), (TextIndent) null, 196569, (DefaultConstructorMarker) null);
        SystemFontFamily systemFontFamily4 = FontFamily.Companion.getDefault();
        TextStyle textStyle7 = r18;
        TextStyle textStyle8 = new TextStyle(0, TextUnitKt.getSp(16), FontWeight.Companion.getMedium(), (FontStyle) null, (FontSynthesis) null, systemFontFamily4, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, TextUnitKt.getSp(24), (TextIndent) null, 196569, (DefaultConstructorMarker) null);
        SystemFontFamily systemFontFamily5 = FontFamily.Companion.getDefault();
        TextStyle textStyle9 = r18;
        TextStyle textStyle10 = new TextStyle(0, TextUnitKt.getSp(12), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, systemFontFamily5, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, TextUnitKt.getSp(18), (TextIndent) null, 196569, (DefaultConstructorMarker) null);
        Typography = new Typography((FontFamily) null, (TextStyle) null, textStyle, (TextStyle) null, (TextStyle) null, (TextStyle) null, (TextStyle) null, (TextStyle) null, (TextStyle) null, textStyle3, textStyle5, textStyle7, textStyle9, (TextStyle) null, 8699, (DefaultConstructorMarker) null);
    }

    public static final Typography getTypography() {
        return Typography;
    }
}
