package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnit;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/text/SpanStyle;", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Savers.kt */
final class SaversKt$SpanStyleSaver$2 extends Lambda implements Function1<Object, SpanStyle> {
    public static final SaversKt$SpanStyleSaver$2 INSTANCE = new SaversKt$SpanStyleSaver$2();

    SaversKt$SpanStyleSaver$2() {
        super(1);
    }

    public final SpanStyle invoke(Object obj) {
        Color color;
        TextUnit textUnit;
        FontWeight fontWeight;
        TextUnit textUnit2;
        BaselineShift baselineShift;
        TextGeometricTransform textGeometricTransform;
        LocaleList localeList;
        Color color2;
        TextDecoration textDecoration;
        Shadow shadow;
        Shadow shadow2;
        TextDecoration textDecoration2;
        LocaleList localeList2;
        TextGeometricTransform textGeometricTransform2;
        BaselineShift baselineShift2;
        FontWeight fontWeight2;
        Object obj2 = obj;
        Intrinsics.checkNotNullParameter(obj2, "it");
        List list = (List) obj2;
        Object obj3 = list.get(0);
        Saver<Color, Object> saver = SaversKt.getSaver(Color.Companion);
        if (!Intrinsics.areEqual(obj3, (Object) false) && obj3 != null) {
            color = saver.restore(obj3);
        } else {
            color = null;
        }
        Intrinsics.checkNotNull(color);
        long r3 = color.m1606unboximpl();
        Object obj4 = list.get(1);
        Saver<TextUnit, Object> saver2 = SaversKt.getSaver(TextUnit.Companion);
        if (!Intrinsics.areEqual(obj4, (Object) false) && obj4 != null) {
            textUnit = saver2.restore(obj4);
        } else {
            textUnit = null;
        }
        Intrinsics.checkNotNull(textUnit);
        long r6 = textUnit.m4049unboximpl();
        Object obj5 = list.get(2);
        Saver<FontWeight, Object> saver3 = SaversKt.getSaver(FontWeight.Companion);
        if (Intrinsics.areEqual(obj5, (Object) false)) {
            fontWeight = null;
        } else {
            if (obj5 == null) {
                fontWeight2 = null;
            } else {
                fontWeight2 = saver3.restore(obj5);
            }
            fontWeight = fontWeight2;
        }
        Object obj6 = list.get(3);
        FontStyle fontStyle = obj6 == null ? null : (FontStyle) obj6;
        Object obj7 = list.get(4);
        FontSynthesis fontSynthesis = obj7 == null ? null : (FontSynthesis) obj7;
        Object obj8 = list.get(6);
        String str = obj8 == null ? null : (String) obj8;
        Object obj9 = list.get(7);
        Saver<TextUnit, Object> saver4 = SaversKt.getSaver(TextUnit.Companion);
        if (!Intrinsics.areEqual(obj9, (Object) false) && obj9 != null) {
            textUnit2 = saver4.restore(obj9);
        } else {
            textUnit2 = null;
        }
        Intrinsics.checkNotNull(textUnit2);
        long r13 = textUnit2.m4049unboximpl();
        Object obj10 = list.get(8);
        Saver<BaselineShift, Object> saver5 = SaversKt.getSaver(BaselineShift.Companion);
        if (Intrinsics.areEqual(obj10, (Object) false)) {
            baselineShift = null;
        } else {
            if (obj10 == null) {
                baselineShift2 = null;
            } else {
                baselineShift2 = saver5.restore(obj10);
            }
            baselineShift = baselineShift2;
        }
        Object obj11 = list.get(9);
        Saver<TextGeometricTransform, Object> saver6 = SaversKt.getSaver(TextGeometricTransform.Companion);
        if (Intrinsics.areEqual(obj11, (Object) false)) {
            textGeometricTransform = null;
        } else {
            if (obj11 == null) {
                textGeometricTransform2 = null;
            } else {
                textGeometricTransform2 = saver6.restore(obj11);
            }
            textGeometricTransform = textGeometricTransform2;
        }
        Object obj12 = list.get(10);
        Saver<LocaleList, Object> saver7 = SaversKt.getSaver(LocaleList.Companion);
        if (Intrinsics.areEqual(obj12, (Object) false)) {
            localeList = null;
        } else {
            if (obj12 == null) {
                localeList2 = null;
            } else {
                localeList2 = saver7.restore(obj12);
            }
            localeList = localeList2;
        }
        Object obj13 = list.get(11);
        Saver<Color, Object> saver8 = SaversKt.getSaver(Color.Companion);
        if (!Intrinsics.areEqual(obj13, (Object) false) && obj13 != null) {
            color2 = saver8.restore(obj13);
        } else {
            color2 = null;
        }
        Intrinsics.checkNotNull(color2);
        long r18 = color2.m1606unboximpl();
        Object obj14 = list.get(12);
        Saver<TextDecoration, Object> saver9 = SaversKt.getSaver(TextDecoration.Companion);
        if (Intrinsics.areEqual(obj14, (Object) false)) {
            textDecoration = null;
        } else {
            if (obj14 == null) {
                textDecoration2 = null;
            } else {
                textDecoration2 = saver9.restore(obj14);
            }
            textDecoration = textDecoration2;
        }
        Object obj15 = list.get(13);
        Saver<Shadow, Object> saver10 = SaversKt.getSaver(Shadow.Companion);
        if (Intrinsics.areEqual(obj15, (Object) false)) {
            shadow = null;
        } else {
            if (obj15 == null) {
                shadow2 = null;
            } else {
                shadow2 = saver10.restore(obj15);
            }
            shadow = shadow2;
        }
        return new SpanStyle(r3, r6, fontWeight, fontStyle, fontSynthesis, (FontFamily) null, str, r13, baselineShift, textGeometricTransform, localeList, r18, textDecoration, shadow, 32, (DefaultConstructorMarker) null);
    }
}
