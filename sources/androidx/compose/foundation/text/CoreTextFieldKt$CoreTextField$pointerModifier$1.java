package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CoreTextField.kt */
final class CoreTextFieldKt$CoreTextField$pointerModifier$1 extends Lambda implements Function1<Offset, Unit> {
    final /* synthetic */ FocusRequester $focusRequester;
    final /* synthetic */ TextFieldSelectionManager $manager;
    final /* synthetic */ OffsetMapping $offsetMapping;
    final /* synthetic */ Function1<TextFieldValue, Unit> $onValueChangeWrapper;
    final /* synthetic */ boolean $readOnly;
    final /* synthetic */ TextFieldState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoreTextFieldKt$CoreTextField$pointerModifier$1(TextFieldState textFieldState, FocusRequester focusRequester, boolean z, TextFieldSelectionManager textFieldSelectionManager, OffsetMapping offsetMapping, Function1<? super TextFieldValue, Unit> function1) {
        super(1);
        this.$state = textFieldState;
        this.$focusRequester = focusRequester;
        this.$readOnly = z;
        this.$manager = textFieldSelectionManager;
        this.$offsetMapping = offsetMapping;
        this.$onValueChangeWrapper = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m637invokek4lQ0M(((Offset) obj).m1363unboximpl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-k-4lQ0M  reason: not valid java name */
    public final void m637invokek4lQ0M(long j) {
        boolean z = true;
        CoreTextFieldKt.tapToFocus(this.$state, this.$focusRequester, !this.$readOnly);
        if (!this.$state.getHasFocus()) {
            return;
        }
        if (this.$state.getHandleState() != HandleState.Selection) {
            TextLayoutResultProxy layoutResult = this.$state.getLayoutResult();
            if (layoutResult != null) {
                TextFieldState textFieldState = this.$state;
                long j2 = j;
                TextFieldDelegate.Companion.m703setCursorOffsetULxng0E$foundation_release(j2, layoutResult, textFieldState.getProcessor(), this.$offsetMapping, this.$onValueChangeWrapper);
                if (textFieldState.getTextDelegate().getText().length() <= 0) {
                    z = false;
                }
                if (z) {
                    textFieldState.setHandleState(HandleState.Cursor);
                    return;
                }
                return;
            }
            return;
        }
        this.$manager.m809deselect_kEHs6E$foundation_release(Offset.m1342boximpl(j));
    }
}
