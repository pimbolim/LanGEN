package androidx.compose.foundation.text;

import androidx.compose.runtime.RecomposeScope;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CoreTextField.kt */
final class CoreTextFieldKt$CoreTextField$onValueChangeWrapper$1 extends Lambda implements Function1<TextFieldValue, Unit> {
    final /* synthetic */ RecomposeScope $scope;
    final /* synthetic */ TextFieldState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoreTextFieldKt$CoreTextField$onValueChangeWrapper$1(TextFieldState textFieldState, RecomposeScope recomposeScope) {
        super(1);
        this.$state = textFieldState;
        this.$scope = recomposeScope;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TextFieldValue) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(TextFieldValue textFieldValue) {
        Intrinsics.checkNotNullParameter(textFieldValue, "it");
        if (!Intrinsics.areEqual((Object) textFieldValue.getText(), (Object) this.$state.getTextDelegate().getText().getText())) {
            this.$state.setHandleState(HandleState.None);
        }
        this.$state.getOnValueChange().invoke(textFieldValue);
        this.$scope.invalidate();
    }
}
