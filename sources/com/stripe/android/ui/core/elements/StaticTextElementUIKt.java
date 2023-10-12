package com.stripe.android.ui.core.elements;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"StaticElementUI", "", "element", "Lcom/stripe/android/ui/core/elements/StaticTextElement;", "(Lcom/stripe/android/ui/core/elements/StaticTextElement;Landroidx/compose/runtime/Composer;I)V", "payments-ui-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: StaticTextElementUI.kt */
public final class StaticTextElementUIKt {
    public static final void StaticElementUI(StaticTextElement staticTextElement, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(staticTextElement, "element");
        Composer startRestartGroup = composer.startRestartGroup(-612221958);
        ComposerKt.sourceInformation(startRestartGroup, "C(StaticElementUI)");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed((Object) staticTextElement) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (((i2 & 11) ^ 2) != 0 || !startRestartGroup.getSkipping()) {
            H6TextKt.H6Text(StringResources_androidKt.stringResource(staticTextElement.getStringResId(), startRestartGroup, 0), SemanticsModifierKt.semantics(PaddingKt.m433paddingVpY3zN4$default(Modifier.Companion, 0.0f, Dp.m3859constructorimpl((float) 8), 1, (Object) null), true, StaticTextElementUIKt$StaticElementUI$1.INSTANCE), startRestartGroup, 0, 0);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new StaticTextElementUIKt$StaticElementUI$2(staticTextElement, i));
        }
    }
}
