package com.stripe.android.ui.core.elements;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: DropdownFieldUI.kt */
final class DropdownFieldUIKt$DropDown$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ DropdownFieldController $controller;
    final /* synthetic */ boolean $enabled;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DropdownFieldUIKt$DropDown$2(DropdownFieldController dropdownFieldController, boolean z, int i) {
        super(2);
        this.$controller = dropdownFieldController;
        this.$enabled = z;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        DropdownFieldUIKt.DropDown(this.$controller, this.$enabled, composer, this.$$changed | 1);
    }
}
