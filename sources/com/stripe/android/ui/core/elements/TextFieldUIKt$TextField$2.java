package com.stripe.android.ui.core.elements;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.focus.FocusState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextFieldUI.kt */
final class TextFieldUIKt$TextField$2 extends Lambda implements Function1<FocusState, Unit> {
    final /* synthetic */ MutableState<Boolean> $hasFocus$delegate;
    final /* synthetic */ TextFieldController $textFieldController;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldUIKt$TextField$2(TextFieldController textFieldController, MutableState<Boolean> mutableState) {
        super(1);
        this.$textFieldController = textFieldController;
        this.$hasFocus$delegate = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((FocusState) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(FocusState focusState) {
        Intrinsics.checkNotNullParameter(focusState, "it");
        if (TextFieldUIKt.m4614TextField_6fMdlN4$lambda5(this.$hasFocus$delegate) != focusState.isFocused()) {
            this.$textFieldController.onFocusChange(focusState.isFocused());
        }
        TextFieldUIKt.m4615TextField_6fMdlN4$lambda6(this.$hasFocus$delegate, focusState.isFocused());
    }
}
