package com.stripe.android.ui.core.elements;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.stripe.android.ui.core.PaymentsTheme;
import com.stripe.android.ui.core.R;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"AffirmElementUI", "", "(Landroidx/compose/runtime/Composer;I)V", "payments-ui-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: AffirmElementUI.kt */
public final class AffirmElementUIKt {
    public static final void AffirmElementUI(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(1428309844);
        ComposerKt.sourceInformation(startRestartGroup, "C(AffirmElementUI)");
        if (i != 0 || !startRestartGroup.getSkipping()) {
            HtmlKt.m4582HtmluDo3WH8(StringResources_androidKt.stringResource(R.string.affirm_buy_now_pay_later, startRestartGroup, 0), MapsKt.mapOf(TuplesKt.to("affirm", new EmbeddableImage(R.drawable.stripe_ic_affirm_logo, R.string.affirm))), PaddingKt.m435paddingqDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, Dp.m3859constructorimpl((float) 4), 7, (Object) null), PaymentsTheme.INSTANCE.getColors(startRestartGroup, 8).m4507getSubtitle0d7_KjU(), PaymentsTheme.INSTANCE.getTypography(startRestartGroup, 8).getH6(), startRestartGroup, 448, 0);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AffirmElementUIKt$AffirmElementUI$1(i));
        }
    }
}
