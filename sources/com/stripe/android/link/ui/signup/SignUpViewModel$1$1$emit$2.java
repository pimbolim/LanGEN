package com.stripe.android.link.ui.signup;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.link.ui.signup.SignUpViewModel$1$1$emit$2", f = "SignUpViewModel.kt", i = {0}, l = {80, 83}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* compiled from: SignUpViewModel.kt */
final class SignUpViewModel$1$1$emit$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $email;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SignUpViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SignUpViewModel$1$1$emit$2(SignUpViewModel signUpViewModel, String str, Continuation<? super SignUpViewModel$1$1$emit$2> continuation) {
        super(2, continuation);
        this.this$0 = signUpViewModel;
        this.$email = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SignUpViewModel$1$1$emit$2 signUpViewModel$1$1$emit$2 = new SignUpViewModel$1$1$emit$2(this.this$0, this.$email, continuation);
        signUpViewModel$1$1$emit$2.L$0 = obj;
        return signUpViewModel$1$1$emit$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SignUpViewModel$1$1$emit$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: kotlinx.coroutines.CoroutineScope} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0022
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x005e
        L_0x0012:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x001a:
            java.lang.Object r1 = r6.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x003a
        L_0x0022:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.Object r7 = r6.L$0
            r1 = r7
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            r4 = 700(0x2bc, double:3.46E-321)
            r7 = r6
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r6.L$0 = r1
            r6.label = r3
            java.lang.Object r7 = kotlinx.coroutines.DelayKt.delay(r4, r7)
            if (r7 != r0) goto L_0x003a
            return r0
        L_0x003a:
            boolean r7 = kotlinx.coroutines.CoroutineScopeKt.isActive(r1)
            if (r7 == 0) goto L_0x005e
            com.stripe.android.link.ui.signup.SignUpViewModel r7 = r6.this$0
            kotlinx.coroutines.flow.MutableStateFlow r7 = r7._signUpStatus
            com.stripe.android.link.ui.signup.SignUpState r1 = com.stripe.android.link.ui.signup.SignUpState.VerifyingEmail
            r7.setValue(r1)
            com.stripe.android.link.ui.signup.SignUpViewModel r7 = r6.this$0
            java.lang.String r1 = r6.$email
            r3 = r6
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r4 = 0
            r6.L$0 = r4
            r6.label = r2
            java.lang.Object r7 = r7.lookupConsumerEmail(r1, r3)
            if (r7 != r0) goto L_0x005e
            return r0
        L_0x005e:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.link.ui.signup.SignUpViewModel$1$1$emit$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
