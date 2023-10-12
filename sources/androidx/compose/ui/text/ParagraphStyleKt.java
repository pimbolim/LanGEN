package androidx.compose.ui.text;

import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextIndentKt;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"lerp", "Landroidx/compose/ui/text/ParagraphStyle;", "start", "stop", "fraction", "", "ui-text_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ParagraphStyle.kt */
public final class ParagraphStyleKt {
    public static final ParagraphStyle lerp(ParagraphStyle paragraphStyle, ParagraphStyle paragraphStyle2, float f) {
        Intrinsics.checkNotNullParameter(paragraphStyle, ViewProps.START);
        Intrinsics.checkNotNullParameter(paragraphStyle2, "stop");
        TextAlign textAlign = (TextAlign) SpanStyleKt.lerpDiscrete(paragraphStyle.m3507getTextAlignbuA522U(), paragraphStyle2.m3507getTextAlignbuA522U(), f);
        TextDirection textDirection = (TextDirection) SpanStyleKt.lerpDiscrete(paragraphStyle.m3508getTextDirectionmmuk1to(), paragraphStyle2.m3508getTextDirectionmmuk1to(), f);
        long r4 = SpanStyleKt.m3547lerpTextUnitInheritableC3pnCVY(paragraphStyle.m3506getLineHeightXSAIIZE(), paragraphStyle2.m3506getLineHeightXSAIIZE(), f);
        TextIndent textIndent = paragraphStyle.getTextIndent();
        if (textIndent == null) {
            textIndent = new TextIndent(0, 0, 3, (DefaultConstructorMarker) null);
        }
        TextIndent textIndent2 = paragraphStyle2.getTextIndent();
        if (textIndent2 == null) {
            textIndent2 = new TextIndent(0, 0, 3, (DefaultConstructorMarker) null);
        }
        return new ParagraphStyle(textAlign, textDirection, r4, TextIndentKt.lerp(textIndent, textIndent2, f), (DefaultConstructorMarker) null);
    }
}
