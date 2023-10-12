package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.TextUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Landroidx/compose/runtime/saveable/SaverScope;", "it", "Landroidx/compose/ui/text/ParagraphStyle;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Savers.kt */
final class SaversKt$ParagraphStyleSaver$1 extends Lambda implements Function2<SaverScope, ParagraphStyle, Object> {
    public static final SaversKt$ParagraphStyleSaver$1 INSTANCE = new SaversKt$ParagraphStyleSaver$1();

    SaversKt$ParagraphStyleSaver$1() {
        super(2);
    }

    public final Object invoke(SaverScope saverScope, ParagraphStyle paragraphStyle) {
        Intrinsics.checkNotNullParameter(saverScope, "$this$Saver");
        Intrinsics.checkNotNullParameter(paragraphStyle, "it");
        return CollectionsKt.arrayListOf(SaversKt.save(paragraphStyle.m3507getTextAlignbuA522U()), SaversKt.save(paragraphStyle.m3508getTextDirectionmmuk1to()), SaversKt.save(TextUnit.m4030boximpl(paragraphStyle.m3506getLineHeightXSAIIZE()), SaversKt.getSaver(TextUnit.Companion), saverScope), SaversKt.save(paragraphStyle.getTextIndent(), SaversKt.getSaver(TextIndent.Companion), saverScope));
    }
}
