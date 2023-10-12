package com.stripe.android.ui.core.elements;

import androidx.compose.ui.focus.FocusProperties;
import androidx.compose.ui.input.InputMode;
import androidx.compose.ui.input.InputModeManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: DropdownFieldUI.kt */
final class DropdownFieldUIKt$DropDown$1$1 extends Lambda implements Function1<FocusProperties, Unit> {
    final /* synthetic */ InputModeManager $inputModeManager;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DropdownFieldUIKt$DropDown$1$1(InputModeManager inputModeManager) {
        super(1);
        this.$inputModeManager = inputModeManager;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((FocusProperties) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(FocusProperties focusProperties) {
        Intrinsics.checkNotNullParameter(focusProperties, "$this$focusProperties");
        focusProperties.setCanFocus(!InputMode.m2246equalsimpl0(this.$inputModeManager.m2252getInputModeaOaMEAU(), InputMode.Companion.m2251getTouchaOaMEAU()));
    }
}
