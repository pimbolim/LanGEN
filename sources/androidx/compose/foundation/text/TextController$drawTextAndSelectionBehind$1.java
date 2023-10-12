package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.foundation.text.selection.SelectionRegistrar;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.TextLayoutResult;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CoreText.kt */
final class TextController$drawTextAndSelectionBehind$1 extends Lambda implements Function1<DrawScope, Unit> {
    final /* synthetic */ TextController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextController$drawTextAndSelectionBehind$1(TextController textController) {
        super(1);
        this.this$0 = textController;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(DrawScope drawScope) {
        int i;
        int i2;
        Map<Long, Selection> subselections;
        Intrinsics.checkNotNullParameter(drawScope, "$this$drawBehind");
        TextLayoutResult layoutResult = this.this$0.getState().getLayoutResult();
        if (layoutResult != null) {
            TextController textController = this.this$0;
            SelectionRegistrar access$getSelectionRegistrar$p = textController.selectionRegistrar;
            Selection selection = null;
            if (!(access$getSelectionRegistrar$p == null || (subselections = access$getSelectionRegistrar$p.getSubselections()) == null)) {
                selection = subselections.get(Long.valueOf(textController.getState().getSelectableId()));
            }
            if (selection != null) {
                if (!selection.getHandlesCrossed()) {
                    i = selection.getStart().getOffset();
                } else {
                    i = selection.getEnd().getOffset();
                }
                if (!selection.getHandlesCrossed()) {
                    i2 = selection.getEnd().getOffset();
                } else {
                    i2 = selection.getStart().getOffset();
                }
                if (i != i2) {
                    DrawScope.DefaultImpls.m2108drawPathLG529CI$default(drawScope, layoutResult.getMultiParagraph().getPathForRange(i, i2), textController.getState().m735getSelectionBackgroundColor0d7_KjU(), 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 60, (Object) null);
                }
            }
            TextDelegate.Companion.paint(drawScope.getDrawContext().getCanvas(), layoutResult);
        }
    }
}
