package com.stripe.android.link.ui;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LinkButton.kt */
final class LinkButtonKt$LinkButton$4 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Function0<Unit> $onClick;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LinkButtonKt$LinkButton$4(boolean z, Function0<Unit> function0, int i) {
        super(2);
        this.$enabled = z;
        this.$onClick = function0;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        LinkButtonKt.LinkButton(this.$enabled, this.$onClick, composer, this.$$changed | 1);
    }
}
