package androidx.compose.ui.node;

import androidx.compose.ui.input.pointer.PointerInputFilter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "inLayer", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PointerInputDelegatingWrapper.kt */
final class PointerInputDelegatingWrapper$hitTest$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ HitTestResult<PointerInputFilter> $hitTestResult;
    final /* synthetic */ boolean $isTouchEvent;
    final /* synthetic */ long $pointerPosition;
    final /* synthetic */ PointerInputDelegatingWrapper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PointerInputDelegatingWrapper$hitTest$1(PointerInputDelegatingWrapper pointerInputDelegatingWrapper, long j, HitTestResult<PointerInputFilter> hitTestResult, boolean z) {
        super(1);
        this.this$0 = pointerInputDelegatingWrapper;
        this.$pointerPosition = j;
        this.$hitTestResult = hitTestResult;
        this.$isTouchEvent = z;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        this.this$0.m3376hitTestChildM_7yMNQ(this.$pointerPosition, this.$hitTestResult, this.$isTouchEvent, z);
    }
}
