package com.stripe.android.ui.core.elements.menu;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material.ContentAlpha;
import androidx.compose.material.ContentAlphaKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Menu.kt */
final class MenuKt$DropdownMenuItemContent$2$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $$dirty$1;
    final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> $content;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ RowScope $this_Row;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MenuKt$DropdownMenuItemContent$2$1(boolean z, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, RowScope rowScope, int i, int i2) {
        super(2);
        this.$enabled = z;
        this.$content = function3;
        this.$this_Row = rowScope;
        this.$$dirty = i;
        this.$$dirty$1 = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        float f;
        if (((i & 11) ^ 2) != 0 || !composer.getSkipping()) {
            if (this.$enabled) {
                composer.startReplaceableGroup(-1827379474);
                f = ContentAlpha.INSTANCE.getHigh(composer, 8);
            } else {
                composer.startReplaceableGroup(-1827379451);
                f = ContentAlpha.INSTANCE.getDisabled(composer, 8);
            }
            composer.endReplaceableGroup();
            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(f))};
            final Function3<RowScope, Composer, Integer, Unit> function3 = this.$content;
            final RowScope rowScope = this.$this_Row;
            final int i2 = this.$$dirty;
            final int i3 = this.$$dirty$1;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer, -819888962, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    if (((i & 11) ^ 2) != 0 || !composer.getSkipping()) {
                        function3.invoke(rowScope, composer, Integer.valueOf((i2 & 14) | ((i3 >> 12) & 112)));
                    } else {
                        composer.skipToGroupEnd();
                    }
                }
            }), composer, 56);
            return;
        }
        composer.skipToGroupEnd();
    }
}
