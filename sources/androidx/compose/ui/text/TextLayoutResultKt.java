package androidx.compose.ui.text;

import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a3\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\t\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\n"}, d2 = {"createTextLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "layoutInput", "Landroidx/compose/ui/text/TextLayoutInput;", "multiParagraph", "Landroidx/compose/ui/text/MultiParagraph;", "size", "Landroidx/compose/ui/unit/IntSize;", "createTextLayoutResult-H0pRuoY", "(Landroidx/compose/ui/text/TextLayoutInput;Landroidx/compose/ui/text/MultiParagraph;J)Landroidx/compose/ui/text/TextLayoutResult;", "ui-text_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextLayoutResult.kt */
public final class TextLayoutResultKt {
    /* renamed from: createTextLayoutResult-H0pRuoY$default  reason: not valid java name */
    public static /* synthetic */ TextLayoutResult m3558createTextLayoutResultH0pRuoY$default(TextLayoutInput textLayoutInput, MultiParagraph multiParagraph, long j, int i, Object obj) {
        TextLayoutInput textLayoutInput2;
        if ((i & 1) != 0) {
            textLayoutInput2 = new TextLayoutInput(new AnnotatedString("", (List) null, (List) null, 6, (DefaultConstructorMarker) null), new TextStyle(0, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 262143, (DefaultConstructorMarker) null), CollectionsKt.emptyList(), 1, false, TextOverflow.Companion.m3788getClipgIe3tQ8(), DensityKt.Density$default(1.0f, 0.0f, 2, (Object) null), LayoutDirection.Ltr, new TextLayoutResultKt$createTextLayoutResult$1(), ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, (Object) null), (DefaultConstructorMarker) null);
        } else {
            textLayoutInput2 = textLayoutInput;
        }
        return m3557createTextLayoutResultH0pRuoY(textLayoutInput2, (i & 2) != 0 ? new MultiParagraph(textLayoutInput2.getText(), textLayoutInput2.getStyle(), (List) null, 0, false, 0.0f, textLayoutInput2.getDensity(), textLayoutInput2.getResourceLoader(), 28, (DefaultConstructorMarker) null) : multiParagraph, (i & 4) != 0 ? IntSize.Companion.m4024getZeroYbymL2g() : j);
    }

    @Deprecated(message = "Unused public function which was added for testing. The function does not do anything usable for Compose text APIs. The function is now deprecated and will be removed soon")
    /* renamed from: createTextLayoutResult-H0pRuoY  reason: not valid java name */
    public static final TextLayoutResult m3557createTextLayoutResultH0pRuoY(TextLayoutInput textLayoutInput, MultiParagraph multiParagraph, long j) {
        Intrinsics.checkNotNullParameter(textLayoutInput, "layoutInput");
        Intrinsics.checkNotNullParameter(multiParagraph, "multiParagraph");
        return new TextLayoutResult(textLayoutInput, multiParagraph, j, (DefaultConstructorMarker) null);
    }
}
