package com.stripe.android.paymentsheet;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentOptionsAdapter.kt */
final class PaymentOptionsAdapterKt$PaymentOptionUi$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$changed1;
    final /* synthetic */ int $$default;
    final /* synthetic */ String $description;
    final /* synthetic */ int $iconRes;
    final /* synthetic */ boolean $isEditing;
    final /* synthetic */ boolean $isEnabled;
    final /* synthetic */ boolean $isSelected;
    final /* synthetic */ String $labelText;
    final /* synthetic */ Function0<Unit> $onItemSelectedListener;
    final /* synthetic */ String $onRemoveAccessibilityDescription;
    final /* synthetic */ Function0<Unit> $onRemoveListener;
    final /* synthetic */ String $removePmDialogTitle;
    final /* synthetic */ float $viewWidth;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaymentOptionsAdapterKt$PaymentOptionUi$3(float f, boolean z, boolean z2, boolean z3, int i, String str, String str2, String str3, Function0<Unit> function0, String str4, Function0<Unit> function02, int i2, int i3, int i4) {
        super(2);
        this.$viewWidth = f;
        this.$isSelected = z;
        this.$isEditing = z2;
        this.$isEnabled = z3;
        this.$iconRes = i;
        this.$labelText = str;
        this.$removePmDialogTitle = str2;
        this.$description = str3;
        this.$onRemoveListener = function0;
        this.$onRemoveAccessibilityDescription = str4;
        this.$onItemSelectedListener = function02;
        this.$$changed = i2;
        this.$$changed1 = i3;
        this.$$default = i4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        PaymentOptionsAdapterKt.m4405PaymentOptionUijFuDa88(this.$viewWidth, this.$isSelected, this.$isEditing, this.$isEnabled, this.$iconRes, this.$labelText, this.$removePmDialogTitle, this.$description, this.$onRemoveListener, this.$onRemoveAccessibilityDescription, this.$onItemSelectedListener, composer, this.$$changed | 1, this.$$changed1, this.$$default);
    }
}
