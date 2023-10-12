package androidx.compose.ui.node;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "T", "Landroidx/compose/ui/Modifier$Element;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: DelegatingLayoutNodeWrapper.kt */
final class DelegatingLayoutNodeWrapper$hitTestInMinimumTouchTarget$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function1<Boolean, Unit> $block;
    final /* synthetic */ boolean $isInLayer;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DelegatingLayoutNodeWrapper$hitTestInMinimumTouchTarget$2(Function1<? super Boolean, Unit> function1, boolean z) {
        super(0);
        this.$block = function1;
        this.$isInLayer = z;
    }

    public final void invoke() {
        this.$block.invoke(Boolean.valueOf(this.$isInLayer));
    }
}
