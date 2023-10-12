package com.stripe.android.ui.core.elements;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SectionFieldElementUI.kt */
final class SectionFieldElementUIKt$SectionFieldElementUI$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ SectionFieldElement $field;
    final /* synthetic */ List<IdentifierSpec> $hiddenIdentifiers;
    final /* synthetic */ IdentifierSpec $lastTextFieldIdentifier;
    final /* synthetic */ Modifier $modifier;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SectionFieldElementUIKt$SectionFieldElementUI$1(boolean z, SectionFieldElement sectionFieldElement, Modifier modifier, List<? extends IdentifierSpec> list, IdentifierSpec identifierSpec, int i, int i2) {
        super(2);
        this.$enabled = z;
        this.$field = sectionFieldElement;
        this.$modifier = modifier;
        this.$hiddenIdentifiers = list;
        this.$lastTextFieldIdentifier = identifierSpec;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        SectionFieldElementUIKt.SectionFieldElementUI(this.$enabled, this.$field, this.$modifier, this.$hiddenIdentifiers, this.$lastTextFieldIdentifier, composer, this.$$changed | 1, this.$$default);
    }
}
