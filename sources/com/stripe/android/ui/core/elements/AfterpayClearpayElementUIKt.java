package com.stripe.android.ui.core.elements;

import android.content.Context;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.unit.Dp;
import com.google.accompanist.flowlayout.FlowCrossAxisAlignment;
import com.google.accompanist.flowlayout.FlowKt;
import com.google.accompanist.flowlayout.MainAxisAlignment;
import com.google.accompanist.flowlayout.SizeMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"AfterpayClearpayElementUI", "", "enabled", "", "element", "Lcom/stripe/android/ui/core/elements/AfterpayClearpayHeaderElement;", "(ZLcom/stripe/android/ui/core/elements/AfterpayClearpayHeaderElement;Landroidx/compose/runtime/Composer;I)V", "payments-ui-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: AfterpayClearpayElementUI.kt */
public final class AfterpayClearpayElementUIKt {
    public static final void AfterpayClearpayElementUI(boolean z, AfterpayClearpayHeaderElement afterpayClearpayHeaderElement, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(afterpayClearpayHeaderElement, "element");
        Composer startRestartGroup = composer.startRestartGroup(1439399728);
        ComposerKt.sourceInformation(startRestartGroup, "C(AfterpayClearpayElementUI)P(1)");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changed((Object) afterpayClearpayHeaderElement) ? 32 : 16;
        }
        if (((i2 & 91) ^ 18) != 0 || !startRestartGroup.getSkipping()) {
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            float f = (float) 4;
            FlowKt.m4243FlowRow07r0xoM(PaddingKt.m434paddingqDBjuR0(Modifier.Companion, Dp.m3859constructorimpl(f), Dp.m3859constructorimpl((float) 8), Dp.m3859constructorimpl(f), Dp.m3859constructorimpl(f)), (SizeMode) null, (MainAxisAlignment) null, 0.0f, FlowCrossAxisAlignment.Center, 0.0f, (MainAxisAlignment) null, ComposableLambdaKt.composableLambda(startRestartGroup, -819895505, true, new AfterpayClearpayElementUIKt$AfterpayClearpayElementUI$1(afterpayClearpayHeaderElement, (Context) consume, z, i2)), startRestartGroup, 12607494, 110);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AfterpayClearpayElementUIKt$AfterpayClearpayElementUI$2(z, afterpayClearpayHeaderElement, i));
        }
    }
}
