package com.stripe.android.link.ui.signup;

import androidx.compose.runtime.Composer;
import com.stripe.android.link.injection.NonFallbackInjector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SignUpScreen.kt */
final class SignUpScreenKt$SignUpBody$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ String $email;
    final /* synthetic */ NonFallbackInjector $injector;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SignUpScreenKt$SignUpBody$2(NonFallbackInjector nonFallbackInjector, String str, int i) {
        super(2);
        this.$injector = nonFallbackInjector;
        this.$email = str;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        SignUpScreenKt.SignUpBody(this.$injector, this.$email, composer, this.$$changed | 1);
    }
}
