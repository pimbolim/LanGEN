package androidx.compose.foundation.text;

import androidx.compose.ui.text.input.ImeAction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CoreTextField.kt */
final class CoreTextFieldKt$CoreTextField$onImeActionPerformedWrapper$1 extends Lambda implements Function1<ImeAction, Unit> {
    final /* synthetic */ TextFieldState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoreTextFieldKt$CoreTextField$onImeActionPerformedWrapper$1(TextFieldState textFieldState) {
        super(1);
        this.$state = textFieldState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m636invokeKlQnJC8(((ImeAction) obj).m3641unboximpl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-KlQnJC8  reason: not valid java name */
    public final void m636invokeKlQnJC8(int i) {
        this.$state.getKeyboardActionRunner().m650runActionKlQnJC8(i);
    }
}
