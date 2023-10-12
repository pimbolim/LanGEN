package androidx.compose.foundation.gestures;

import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AndroidOverScroll.kt */
final class AndroidOverScrollKt$overScroll$1 extends Lambda implements Function1<ContentDrawScope, Unit> {
    final /* synthetic */ OverScrollController $overScrollController;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidOverScrollKt$overScroll$1(OverScrollController overScrollController) {
        super(1);
        this.$overScrollController = overScrollController;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ContentDrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ContentDrawScope contentDrawScope) {
        Intrinsics.checkNotNullParameter(contentDrawScope, "$this$drawWithContent");
        contentDrawScope.drawContent();
        this.$overScrollController.drawOverScroll(contentDrawScope);
    }
}
