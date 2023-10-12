package com.stripe.android.ui.core.elements;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BsbElementUI.kt */
final class BsbElementUIKt$BsbElementUI$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ BsbElement $element;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ IdentifierSpec $lastTextFieldIdentifier;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BsbElementUIKt$BsbElementUI$2(boolean z, BsbElement bsbElement, IdentifierSpec identifierSpec, int i) {
        super(2);
        this.$enabled = z;
        this.$element = bsbElement;
        this.$lastTextFieldIdentifier = identifierSpec;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        BsbElementUIKt.BsbElementUI(this.$enabled, this.$element, this.$lastTextFieldIdentifier, composer, this.$$changed | 1);
    }
}
