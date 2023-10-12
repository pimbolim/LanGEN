package com.stripe.android.link.ui;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.ContentAlphaKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.ProgressIndicatorKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import com.stripe.android.link.theme.ThemeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PrimaryButton.kt */
final class PrimaryButtonKt$PrimaryButton$1$1$1 extends Lambda implements Function3<RowScope, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ String $label;
    final /* synthetic */ PrimaryButtonState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PrimaryButtonKt$PrimaryButton$1$1$1(PrimaryButtonState primaryButtonState, String str, int i) {
        super(3);
        this.$state = primaryButtonState;
        this.$label = str;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((RowScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(RowScope rowScope, Composer composer, int i) {
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(rowScope, "$this$TextButton");
        if (((i & 81) ^ 16) == 0 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else if (this.$state == PrimaryButtonState.Processing) {
            composer2.startReplaceableGroup(-1127965141);
            ProgressIndicatorKt.m1067CircularProgressIndicatoraMcp0Q(SizeKt.m492size3ABfNKs(Modifier.Companion, Dp.m3859constructorimpl((float) 18)), ThemeKt.getLinkColors(MaterialTheme.INSTANCE, composer2, 8).m4331getButtonLabel0d7_KjU(), Dp.m3859constructorimpl((float) 2), composer, 390, 0);
            composer.endReplaceableGroup();
        } else {
            composer2.startReplaceableGroup(-1127964877);
            String str = this.$label;
            long r4 = ThemeKt.getLinkColors(MaterialTheme.INSTANCE, composer2, 8).m4331getButtonLabel0d7_KjU();
            ComposerKt.sourceInformationMarkerStart(composer2, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume = composer2.consume(ContentAlphaKt.getLocalContentAlpha());
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextKt.m1189TextfLXpl1I(str, (Modifier) null, Color.m1595copywmQWz5c$default(r4, ((Number) consume).floatValue(), 0.0f, 0.0f, 0.0f, 14, (Object) null), 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, this.$$dirty & 14, 0, 65530);
            composer.endReplaceableGroup();
        }
    }
}
