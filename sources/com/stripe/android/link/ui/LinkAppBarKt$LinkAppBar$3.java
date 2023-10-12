package com.stripe.android.link.ui;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LinkAppBar.kt */
final class LinkAppBarKt$LinkAppBar$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ String $email;
    final /* synthetic */ Function0<Unit> $onCloseButtonClick;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LinkAppBarKt$LinkAppBar$3(String str, Function0<Unit> function0, int i) {
        super(2);
        this.$email = str;
        this.$onCloseButtonClick = function0;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        LinkAppBarKt.LinkAppBar(this.$email, this.$onCloseButtonClick, composer, this.$$changed | 1);
    }
}
