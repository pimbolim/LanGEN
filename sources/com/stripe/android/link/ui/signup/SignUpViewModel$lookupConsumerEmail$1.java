package com.stripe.android.link.ui.signup;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.link.ui.signup.SignUpViewModel", f = "SignUpViewModel.kt", i = {0}, l = {108}, m = "lookupConsumerEmail", n = {"this"}, s = {"L$0"})
/* compiled from: SignUpViewModel.kt */
final class SignUpViewModel$lookupConsumerEmail$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SignUpViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SignUpViewModel$lookupConsumerEmail$1(SignUpViewModel signUpViewModel, Continuation<? super SignUpViewModel$lookupConsumerEmail$1> continuation) {
        super(continuation);
        this.this$0 = signUpViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.lookupConsumerEmail((String) null, this);
    }
}
