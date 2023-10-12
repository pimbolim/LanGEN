package com.stripe.android.ui.core.elements;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import com.stripe.android.ui.core.PaymentsTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"MandateTextUI", "", "element", "Lcom/stripe/android/ui/core/elements/MandateTextElement;", "(Lcom/stripe/android/ui/core/elements/MandateTextElement;Landroidx/compose/runtime/Composer;I)V", "payments-ui-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: MandateTextUI.kt */
public final class MandateTextUIKt {
    public static final void MandateTextUI(MandateTextElement mandateTextElement, Composer composer, int i) {
        int i2;
        MandateTextElement mandateTextElement2 = mandateTextElement;
        int i3 = i;
        Intrinsics.checkNotNullParameter(mandateTextElement2, "element");
        Composer startRestartGroup = composer.startRestartGroup(-1800603127);
        ComposerKt.sourceInformation(startRestartGroup, "C(MandateTextUI)");
        if ((i3 & 14) == 0) {
            i2 = (startRestartGroup.changed((Object) mandateTextElement2) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if (((i2 & 11) ^ 2) != 0 || !startRestartGroup.getSkipping()) {
            int stringResId = mandateTextElement.getStringResId();
            Object[] objArr = new Object[1];
            String merchantName = mandateTextElement.getMerchantName();
            if (merchantName == null) {
                merchantName = "";
            }
            objArr[0] = merchantName;
            TextKt.m1189TextfLXpl1I(StringResources_androidKt.stringResource(stringResId, objArr, startRestartGroup, 64), SemanticsModifierKt.semantics(PaddingKt.m433paddingVpY3zN4$default(Modifier.Companion, 0.0f, Dp.m3859constructorimpl((float) 8), 1, (Object) null), true, MandateTextUIKt$MandateTextUI$1.INSTANCE), PaymentsTheme.INSTANCE.getColors(startRestartGroup, 8).m4507getSubtitle0d7_KjU(), 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, (Function1<? super TextLayoutResult, Unit>) null, PaymentsTheme.INSTANCE.getTypography(startRestartGroup, 8).getBody2(), startRestartGroup, 0, 0, 32760);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new MandateTextUIKt$MandateTextUI$2(mandateTextElement2, i3));
        }
    }
}
