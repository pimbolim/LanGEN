package com.stripe.android.link.ui;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material.ButtonColors;
import androidx.compose.material.ButtonDefaults;
import androidx.compose.material.ButtonElevation;
import androidx.compose.material.ButtonKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import com.drew.metadata.iptc.IptcDirectory;
import com.stripe.android.link.theme.ThemeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LinkButton.kt */
final class LinkButtonKt$LinkButton$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Function0<Unit> $onClick;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LinkButtonKt$LinkButton$3(Function0<Unit> function0, boolean z, int i) {
        super(2);
        this.$onClick = function0;
        this.$enabled = z;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if (((i & 11) ^ 2) != 0 || !composer.getSkipping()) {
            final Function0<Unit> function0 = this.$onClick;
            final boolean z = this.$enabled;
            final int i2 = this.$$dirty;
            ThemeKt.DefaultLinkTheme(false, ComposableLambdaKt.composableLambda(composer, -819895442, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    Composer composer2 = composer;
                    if (((i & 11) ^ 2) != 0 || !composer.getSkipping()) {
                        Function0<Unit> function0 = function0;
                        boolean z = z;
                        ButtonColors r8 = ButtonDefaults.INSTANCE.m876buttonColorsro_MJ88(MaterialTheme.INSTANCE.getColors(composer2, 8).m914getPrimary0d7_KjU(), 0, MaterialTheme.INSTANCE.getColors(composer2, 8).m914getPrimary0d7_KjU(), 0, composer, 32768, 10);
                        Function3<RowScope, Composer, Integer, Unit> r10 = ComposableSingletons$LinkButtonKt.INSTANCE.m4337getLambda1$link_release();
                        int i2 = i2;
                        ButtonKt.Button(function0, (Modifier) null, z, (MutableInteractionSource) null, (ButtonElevation) null, (Shape) null, (BorderStroke) null, r8, (PaddingValues) null, r10, composer, 805306368 | ((i2 >> 3) & 14) | ((i2 << 6) & 896), IptcDirectory.TAG_ARM_VERSION);
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }), composer, 48, 1);
            return;
        }
        composer.skipToGroupEnd();
    }
}
