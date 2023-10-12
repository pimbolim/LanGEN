package com.stripe.android.link.ui.verification;

import androidx.compose.runtime.Composer;
import com.stripe.android.link.injection.NonFallbackInjector;
import com.stripe.android.link.model.LinkAccount;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: VerificationScreen.kt */
final class VerificationScreenKt$VerificationBody$5 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ NonFallbackInjector $injector;
    final /* synthetic */ LinkAccount $linkAccount;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VerificationScreenKt$VerificationBody$5(LinkAccount linkAccount, NonFallbackInjector nonFallbackInjector, int i) {
        super(2);
        this.$linkAccount = linkAccount;
        this.$injector = nonFallbackInjector;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        VerificationScreenKt.VerificationBody(this.$linkAccount, this.$injector, composer, this.$$changed | 1);
    }
}
