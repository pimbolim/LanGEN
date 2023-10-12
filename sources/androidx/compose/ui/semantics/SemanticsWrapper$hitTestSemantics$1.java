package androidx.compose.ui.semantics;

import androidx.compose.ui.node.HitTestResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "inLayer", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SemanticsWrapper.kt */
final class SemanticsWrapper$hitTestSemantics$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ HitTestResult<SemanticsWrapper> $hitSemanticsWrappers;
    final /* synthetic */ long $pointerPosition;
    final /* synthetic */ SemanticsWrapper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SemanticsWrapper$hitTestSemantics$1(SemanticsWrapper semanticsWrapper, long j, HitTestResult<SemanticsWrapper> hitTestResult) {
        super(1);
        this.this$0 = semanticsWrapper;
        this.$pointerPosition = j;
        this.$hitSemanticsWrappers = hitTestResult;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        this.this$0.getWrapped$ui_release().m3346hitTestSemantics9KIMszo(this.this$0.getWrapped$ui_release().m3341fromParentPositionMKHz9U(this.$pointerPosition), this.$hitSemanticsWrappers, z);
    }
}
