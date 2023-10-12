package com.stripe.android.ui.core.elements;

import androidx.compose.material.TextFieldColors;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextFieldUI.kt */
final class TextFieldUIKt$TextField$6$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ TextFieldColors $colors;
    final /* synthetic */ TextFieldIcon $it;
    final /* synthetic */ State<Boolean> $loading$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldUIKt$TextField$6$1(TextFieldIcon textFieldIcon, TextFieldColors textFieldColors, State<Boolean> state) {
        super(2);
        this.$it = textFieldIcon;
        this.$colors = textFieldColors;
        this.$loading$delegate = state;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if (((i & 11) ^ 2) != 0 || !composer.getSkipping()) {
            TextFieldUIKt.TrailingIcon(this.$it, this.$colors, TextFieldUIKt.m4612TextField_6fMdlN4$lambda3(this.$loading$delegate), composer, 0);
        } else {
            composer.skipToGroupEnd();
        }
    }
}
