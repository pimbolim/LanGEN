package com.stripe.android.ui.core.elements;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material.DividerKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import com.stripe.android.ui.core.PaymentsTheme;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u001a7\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0001¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"CardDetailsElementUI", "", "enabled", "", "controller", "Lcom/stripe/android/ui/core/elements/CardDetailsController;", "hiddenIdentifiers", "", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "lastTextFieldIdentifier", "(ZLcom/stripe/android/ui/core/elements/CardDetailsController;Ljava/util/List;Lcom/stripe/android/ui/core/elements/IdentifierSpec;Landroidx/compose/runtime/Composer;I)V", "payments-ui-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: CardDetailsElementUI.kt */
public final class CardDetailsElementUIKt {
    public static final void CardDetailsElementUI(boolean z, CardDetailsController cardDetailsController, List<? extends IdentifierSpec> list, IdentifierSpec identifierSpec, Composer composer, int i) {
        CardDetailsController cardDetailsController2 = cardDetailsController;
        Intrinsics.checkNotNullParameter(cardDetailsController, "controller");
        Composer startRestartGroup = composer.startRestartGroup(-1194314064);
        int i2 = 0;
        for (Object next : cardDetailsController.getFields()) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            boolean z2 = z;
            SectionFieldElementUIKt.SectionFieldElementUI(z2, (SectionFieldElement) next, (Modifier) null, list, identifierSpec, startRestartGroup, (i & 14) | 4096 | (57344 & (i << 3)), 4);
            if (i2 != CollectionsKt.getLastIndex(cardDetailsController.getFields())) {
                DividerKt.m954DivideroMI9zvI(PaddingKt.m433paddingVpY3zN4$default(Modifier.Companion, PaymentsTheme.INSTANCE.getShapes(startRestartGroup, 8).m4512getBorderStrokeWidthD9Ej5fM(), 0.0f, 2, (Object) null), PaymentsTheme.INSTANCE.getColors(startRestartGroup, 8).m4502getColorComponentDivider0d7_KjU(), PaymentsTheme.INSTANCE.getShapes(startRestartGroup, 8).m4512getBorderStrokeWidthD9Ej5fM(), 0.0f, startRestartGroup, 0, 8);
            }
            i2 = i3;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new CardDetailsElementUIKt$CardDetailsElementUI$2(z, cardDetailsController, list, identifierSpec, i));
        }
    }
}
