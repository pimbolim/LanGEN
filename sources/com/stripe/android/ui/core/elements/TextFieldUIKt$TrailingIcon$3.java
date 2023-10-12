package com.stripe.android.ui.core.elements;

import androidx.compose.material.TextFieldColors;
import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextFieldUI.kt */
final class TextFieldUIKt$TrailingIcon$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ TextFieldColors $colors;
    final /* synthetic */ boolean $loading;
    final /* synthetic */ TextFieldIcon $trailingIcon;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldUIKt$TrailingIcon$3(TextFieldIcon textFieldIcon, TextFieldColors textFieldColors, boolean z, int i) {
        super(2);
        this.$trailingIcon = textFieldIcon;
        this.$colors = textFieldColors;
        this.$loading = z;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        TextFieldUIKt.TrailingIcon(this.$trailingIcon, this.$colors, this.$loading, composer, this.$$changed | 1);
    }
}
