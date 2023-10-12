package com.stripe.android.link.ui;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LinkButton.kt */
final class LinkViewButton$Content$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ LinkViewButton $tmp0_rcvr;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LinkViewButton$Content$1(LinkViewButton linkViewButton, int i) {
        super(2);
        this.$tmp0_rcvr = linkViewButton;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        this.$tmp0_rcvr.Content(composer, this.$$changed | 1);
    }
}
