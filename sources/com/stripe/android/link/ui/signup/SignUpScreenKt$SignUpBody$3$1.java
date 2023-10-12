package com.stripe.android.link.ui.signup;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SignUpScreen.kt */
final class SignUpScreenKt$SignUpBody$3$1 extends Lambda implements Function3<AnimatedVisibilityScope, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function1<String, Unit> $onSignUpClick;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SignUpScreenKt$SignUpBody$3$1(Function1<? super String, Unit> function1, int i) {
        super(3);
        this.$onSignUpClick = function1;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((AnimatedVisibilityScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(animatedVisibilityScope, "$this$AnimatedVisibility");
        SignUpScreenKt.PhoneCollectionSection(this.$onSignUpClick, composer, (this.$$dirty >> 9) & 14);
    }
}
