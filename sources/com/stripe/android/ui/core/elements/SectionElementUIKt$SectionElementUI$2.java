package com.stripe.android.ui.core.elements;

import androidx.compose.runtime.Composer;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SectionElementUI.kt */
final class SectionElementUIKt$SectionElementUI$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ SectionElement $element;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ List<IdentifierSpec> $hiddenIdentifiers;
    final /* synthetic */ IdentifierSpec $lastTextFieldIdentifier;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SectionElementUIKt$SectionElementUI$2(boolean z, SectionElement sectionElement, List<? extends IdentifierSpec> list, IdentifierSpec identifierSpec, int i) {
        super(2);
        this.$enabled = z;
        this.$element = sectionElement;
        this.$hiddenIdentifiers = list;
        this.$lastTextFieldIdentifier = identifierSpec;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        SectionElementUIKt.SectionElementUI(this.$enabled, this.$element, this.$hiddenIdentifiers, this.$lastTextFieldIdentifier, composer, this.$$changed | 1);
    }
}
