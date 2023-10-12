package com.stripe.android.ui.core.elements;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextFieldUI.kt */
final class TextFieldUIKt$TextField$9 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ int $imeAction;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ TextFieldController $textFieldController;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldUIKt$TextField$9(TextFieldController textFieldController, Modifier modifier, int i, boolean z, int i2, int i3) {
        super(2);
        this.$textFieldController = textFieldController;
        this.$modifier = modifier;
        this.$imeAction = i;
        this.$enabled = z;
        this.$$changed = i2;
        this.$$default = i3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        TextFieldUIKt.m4607TextField6fMdlN4(this.$textFieldController, this.$modifier, this.$imeAction, this.$enabled, composer, this.$$changed | 1, this.$$default);
    }
}
