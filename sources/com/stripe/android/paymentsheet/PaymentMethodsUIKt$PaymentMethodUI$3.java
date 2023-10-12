package com.stripe.android.paymentsheet;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentMethodsUI.kt */
final class PaymentMethodsUIKt$PaymentMethodUI$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ int $iconRes;
    final /* synthetic */ boolean $isEnabled;
    final /* synthetic */ boolean $isSelected;
    final /* synthetic */ int $itemIndex;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function1<Integer, Unit> $onItemSelectedListener;
    final /* synthetic */ boolean $tintOnSelected;
    final /* synthetic */ String $title;
    final /* synthetic */ float $viewWidth;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaymentMethodsUIKt$PaymentMethodUI$3(float f, int i, String str, boolean z, boolean z2, boolean z3, int i2, Modifier modifier, Function1<? super Integer, Unit> function1, int i3, int i4) {
        super(2);
        this.$viewWidth = f;
        this.$iconRes = i;
        this.$title = str;
        this.$isSelected = z;
        this.$isEnabled = z2;
        this.$tintOnSelected = z3;
        this.$itemIndex = i2;
        this.$modifier = modifier;
        this.$onItemSelectedListener = function1;
        this.$$changed = i3;
        this.$$default = i4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        PaymentMethodsUIKt.m4395PaymentMethodUIZ3Oy47U(this.$viewWidth, this.$iconRes, this.$title, this.$isSelected, this.$isEnabled, this.$tintOnSelected, this.$itemIndex, this.$modifier, this.$onItemSelectedListener, composer, this.$$changed | 1, this.$$default);
    }
}
