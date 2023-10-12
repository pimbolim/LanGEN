package com.stripe.android.ui.core.elements;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.StringResources_androidKt;
import com.stripe.android.ui.core.PaymentsTheme;
import com.stripe.android.ui.core.R;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"AuBecsDebitMandateElementUI", "", "element", "Lcom/stripe/android/ui/core/elements/AuBecsDebitMandateTextElement;", "(Lcom/stripe/android/ui/core/elements/AuBecsDebitMandateTextElement;Landroidx/compose/runtime/Composer;I)V", "payments-ui-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: AuBecsDebitMandateElementUI.kt */
public final class AuBecsDebitMandateElementUIKt {
    public static final void AuBecsDebitMandateElementUI(AuBecsDebitMandateTextElement auBecsDebitMandateTextElement, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(auBecsDebitMandateTextElement, "element");
        Composer startRestartGroup = composer.startRestartGroup(1412711899);
        ComposerKt.sourceInformation(startRestartGroup, "C(AuBecsDebitMandateElementUI)");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed((Object) auBecsDebitMandateTextElement) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (((i2 & 11) ^ 2) != 0 || !startRestartGroup.getSkipping()) {
            int i3 = R.string.au_becs_mandate;
            Object[] objArr = new Object[1];
            String merchantName = auBecsDebitMandateTextElement.getMerchantName();
            if (merchantName == null) {
                merchantName = "";
            }
            objArr[0] = merchantName;
            HtmlKt.m4582HtmluDo3WH8(StringResources_androidKt.stringResource(i3, objArr, startRestartGroup, 64), MapsKt.emptyMap(), (Modifier) null, PaymentsTheme.INSTANCE.getColors(startRestartGroup, 8).m4507getSubtitle0d7_KjU(), PaymentsTheme.INSTANCE.getTypography(startRestartGroup, 8).getBody2(), startRestartGroup, 64, 4);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AuBecsDebitMandateElementUIKt$AuBecsDebitMandateElementUI$1(auBecsDebitMandateTextElement, i));
        }
    }
}
