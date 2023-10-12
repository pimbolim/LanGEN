package com.stripe.android.link.ui;

import androidx.compose.material.ContentAlpha;
import androidx.compose.material.ContentAlphaKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001a#\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0003¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"LinkButton", "", "(Landroidx/compose/runtime/Composer;I)V", "enabled", "", "onClick", "Lkotlin/Function0;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "link_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: LinkButton.kt */
public final class LinkButtonKt {
    /* access modifiers changed from: private */
    public static final void LinkButton(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-665953873);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            LinkButton(true, LinkButtonKt$LinkButton$1.INSTANCE, startRestartGroup, 54);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new LinkButtonKt$LinkButton$2(i));
        }
    }

    /* access modifiers changed from: private */
    public static final void LinkButton(boolean z, Function0<Unit> function0, Composer composer, int i) {
        int i2;
        float f;
        Composer startRestartGroup = composer.startRestartGroup(-665953764);
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changed((Object) function0) ? 32 : 16;
        }
        if (((i2 & 91) ^ 18) != 0 || !startRestartGroup.getSkipping()) {
            ProvidedValue[] providedValueArr = new ProvidedValue[1];
            ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
            if (z) {
                startRestartGroup.startReplaceableGroup(-665953607);
                f = ContentAlpha.INSTANCE.getHigh(startRestartGroup, 8);
            } else {
                startRestartGroup.startReplaceableGroup(-665953584);
                f = ContentAlpha.INSTANCE.getDisabled(startRestartGroup, 8);
            }
            startRestartGroup.endReplaceableGroup();
            providedValueArr[0] = localContentAlpha.provides(Float.valueOf(f));
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(startRestartGroup, -819895477, true, new LinkButtonKt$LinkButton$3(function0, z, i2)), startRestartGroup, 56);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new LinkButtonKt$LinkButton$4(z, function0, i));
        }
    }
}
