package com.stripe.android.link.ui.signup;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SignUpScreen.kt */
final class SignUpScreenKt$PhoneCollectionSection$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ Function1<String, Unit> $onSignUpClick;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SignUpScreenKt$PhoneCollectionSection$2(Function1<? super String, Unit> function1, int i) {
        super(2);
        this.$onSignUpClick = function1;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        SignUpScreenKt.PhoneCollectionSection(this.$onSignUpClick, composer, this.$$changed | 1);
    }
}
