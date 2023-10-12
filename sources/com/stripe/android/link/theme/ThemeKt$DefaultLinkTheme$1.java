package com.stripe.android.link.theme;

import androidx.compose.material.MaterialThemeKt;
import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Theme.kt */
final class ThemeKt$DefaultLinkTheme$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ LinkColors $colors;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ThemeKt$DefaultLinkTheme$1(LinkColors linkColors, Function2<? super Composer, ? super Integer, Unit> function2, int i) {
        super(2);
        this.$colors = linkColors;
        this.$content = function2;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if (((i & 11) ^ 2) != 0 || !composer.getSkipping()) {
            MaterialThemeKt.MaterialTheme(this.$colors.getMaterialColors(), TypeKt.getTypography(), ShapeKt.getShapes(), this.$content, composer, ((this.$$dirty << 6) & 7168) | 432, 0);
            return;
        }
        composer.skipToGroupEnd();
    }
}
