package com.stripe.android.ui.core.elements;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material.DividerKt;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import com.stripe.android.ui.core.PaymentsTheme;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SectionElementUI.kt */
final class SectionElementUIKt$SectionElementUI$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ SectionElement $element;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ List<IdentifierSpec> $hiddenIdentifiers;
    final /* synthetic */ IdentifierSpec $lastTextFieldIdentifier;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SectionElementUIKt$SectionElementUI$1(SectionElement sectionElement, boolean z, List<? extends IdentifierSpec> list, IdentifierSpec identifierSpec, int i) {
        super(2);
        this.$element = sectionElement;
        this.$enabled = z;
        this.$hiddenIdentifiers = list;
        this.$lastTextFieldIdentifier = identifierSpec;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        Composer composer2 = composer;
        if (((i & 11) ^ 2) != 0 || !composer.getSkipping()) {
            boolean z = this.$enabled;
            List<IdentifierSpec> list = this.$hiddenIdentifiers;
            IdentifierSpec identifierSpec = this.$lastTextFieldIdentifier;
            int i2 = this.$$dirty;
            SectionElement sectionElement = this.$element;
            int i3 = 0;
            for (Object next : this.$element.getFields()) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                boolean z2 = z;
                int i5 = i3;
                SectionFieldElementUIKt.SectionFieldElementUI(z2, (SectionFieldElement) next, (Modifier) null, list, identifierSpec, composer, (i2 & 14) | 4096 | (57344 & (i2 << 3)), 4);
                if (i5 != CollectionsKt.getLastIndex(sectionElement.getFields())) {
                    DividerKt.m954DivideroMI9zvI(PaddingKt.m433paddingVpY3zN4$default(Modifier.Companion, PaymentsTheme.INSTANCE.getShapes(composer2, 8).m4512getBorderStrokeWidthD9Ej5fM(), 0.0f, 2, (Object) null), PaymentsTheme.INSTANCE.getColors(composer2, 8).m4502getColorComponentDivider0d7_KjU(), PaymentsTheme.INSTANCE.getShapes(composer2, 8).m4512getBorderStrokeWidthD9Ej5fM(), 0.0f, composer, 0, 8);
                }
                i3 = i4;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
