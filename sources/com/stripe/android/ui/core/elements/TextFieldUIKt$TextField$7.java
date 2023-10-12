package com.stripe.android.ui.core.elements;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextFieldUI.kt */
final class TextFieldUIKt$TextField$7 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ TextFieldController $textFieldController;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldUIKt$TextField$7(TextFieldController textFieldController) {
        super(1);
        this.$textFieldController = textFieldController;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        this.$textFieldController.onValueChange(str);
    }
}
