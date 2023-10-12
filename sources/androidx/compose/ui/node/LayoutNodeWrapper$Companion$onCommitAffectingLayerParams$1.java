package androidx.compose.ui.node;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "wrapper", "Landroidx/compose/ui/node/LayoutNodeWrapper;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LayoutNodeWrapper.kt */
final class LayoutNodeWrapper$Companion$onCommitAffectingLayerParams$1 extends Lambda implements Function1<LayoutNodeWrapper, Unit> {
    public static final LayoutNodeWrapper$Companion$onCommitAffectingLayerParams$1 INSTANCE = new LayoutNodeWrapper$Companion$onCommitAffectingLayerParams$1();

    LayoutNodeWrapper$Companion$onCommitAffectingLayerParams$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LayoutNodeWrapper) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(LayoutNodeWrapper layoutNodeWrapper) {
        Intrinsics.checkNotNullParameter(layoutNodeWrapper, "wrapper");
        if (layoutNodeWrapper.isValid()) {
            layoutNodeWrapper.updateLayerParameters();
        }
    }
}
