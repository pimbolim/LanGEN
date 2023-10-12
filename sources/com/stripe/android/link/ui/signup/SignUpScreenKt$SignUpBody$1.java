package com.stripe.android.link.ui.signup;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SignUpScreen.kt */
/* synthetic */ class SignUpScreenKt$SignUpBody$1 extends FunctionReferenceImpl implements Function1<String, Unit> {
    SignUpScreenKt$SignUpBody$1(Object obj) {
        super(1, obj, SignUpViewModel.class, "onSignUpClick", "onSignUpClick(Ljava/lang/String;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "p0");
        ((SignUpViewModel) this.receiver).onSignUpClick(str);
    }
}
