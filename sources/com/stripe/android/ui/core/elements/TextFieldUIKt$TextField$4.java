package com.stripe.android.ui.core.elements;

import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.ui.focus.FocusManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextFieldUI.kt */
final class TextFieldUIKt$TextField$4 extends Lambda implements Function1<KeyboardActionScope, Unit> {
    final /* synthetic */ FocusManager $focusManager;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldUIKt$TextField$4(FocusManager focusManager) {
        super(1);
        this.$focusManager = focusManager;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((KeyboardActionScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(KeyboardActionScope keyboardActionScope) {
        Intrinsics.checkNotNullParameter(keyboardActionScope, "$this$$receiver");
        this.$focusManager.clearFocus(true);
    }
}
