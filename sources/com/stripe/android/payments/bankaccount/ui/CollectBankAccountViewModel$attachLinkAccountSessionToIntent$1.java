package com.stripe.android.payments.bankaccount.ui;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.payments.bankaccount.ui.CollectBankAccountViewModel$attachLinkAccountSessionToIntent$1", f = "CollectBankAccountViewModel.kt", i = {}, l = {98, 103, 112, 114}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: CollectBankAccountViewModel.kt */
final class CollectBankAccountViewModel$attachLinkAccountSessionToIntent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $linkedAccountSessionId;
    Object L$0;
    int label;
    final /* synthetic */ CollectBankAccountViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CollectBankAccountViewModel$attachLinkAccountSessionToIntent$1(CollectBankAccountViewModel collectBankAccountViewModel, String str, Continuation<? super CollectBankAccountViewModel$attachLinkAccountSessionToIntent$1> continuation) {
        super(2, continuation);
        this.this$0 = collectBankAccountViewModel;
        this.$linkedAccountSessionId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CollectBankAccountViewModel$attachLinkAccountSessionToIntent$1(this.this$0, this.$linkedAccountSessionId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CollectBankAccountViewModel$attachLinkAccountSessionToIntent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00e2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L_0x0032
            if (r1 == r5) goto L_0x0028
            if (r1 == r4) goto L_0x0028
            if (r1 == r3) goto L_0x0021
            if (r1 != r2) goto L_0x0019
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x00ed
        L_0x0019:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0021:
            java.lang.Object r1 = r8.L$0
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x00d9
        L_0x0028:
            kotlin.ResultKt.throwOnFailure(r9)
            kotlin.Result r9 = (kotlin.Result) r9
            java.lang.Object r9 = r9.m4718unboximpl()
            goto L_0x0093
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r9)
            com.stripe.android.payments.bankaccount.ui.CollectBankAccountViewModel r9 = r8.this$0
            com.stripe.android.payments.bankaccount.navigation.CollectBankAccountContract$Args r9 = r9.args
            boolean r1 = r9 instanceof com.stripe.android.payments.bankaccount.navigation.CollectBankAccountContract.Args.ForPaymentIntent
            if (r1 == 0) goto L_0x0067
            com.stripe.android.payments.bankaccount.ui.CollectBankAccountViewModel r9 = r8.this$0
            com.stripe.android.payments.bankaccount.domain.AttachLinkAccountSession r9 = r9.attachLinkAccountSession
            com.stripe.android.payments.bankaccount.ui.CollectBankAccountViewModel r1 = r8.this$0
            com.stripe.android.payments.bankaccount.navigation.CollectBankAccountContract$Args r1 = r1.args
            java.lang.String r1 = r1.getPublishableKey()
            com.stripe.android.payments.bankaccount.ui.CollectBankAccountViewModel r4 = r8.this$0
            com.stripe.android.payments.bankaccount.navigation.CollectBankAccountContract$Args r4 = r4.args
            java.lang.String r4 = r4.getClientSecret()
            java.lang.String r6 = r8.$linkedAccountSessionId
            r7 = r8
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r8.label = r5
            java.lang.Object r9 = r9.m4371forPaymentIntentBWLJW6A(r1, r6, r4, r7)
            if (r9 != r0) goto L_0x0093
            return r0
        L_0x0067:
            boolean r9 = r9 instanceof com.stripe.android.payments.bankaccount.navigation.CollectBankAccountContract.Args.ForSetupIntent
            if (r9 == 0) goto L_0x00f0
            com.stripe.android.payments.bankaccount.ui.CollectBankAccountViewModel r9 = r8.this$0
            com.stripe.android.payments.bankaccount.domain.AttachLinkAccountSession r9 = r9.attachLinkAccountSession
            com.stripe.android.payments.bankaccount.ui.CollectBankAccountViewModel r1 = r8.this$0
            com.stripe.android.payments.bankaccount.navigation.CollectBankAccountContract$Args r1 = r1.args
            java.lang.String r1 = r1.getPublishableKey()
            com.stripe.android.payments.bankaccount.ui.CollectBankAccountViewModel r5 = r8.this$0
            com.stripe.android.payments.bankaccount.navigation.CollectBankAccountContract$Args r5 = r5.args
            java.lang.String r5 = r5.getClientSecret()
            java.lang.String r6 = r8.$linkedAccountSessionId
            r7 = r8
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r8.label = r4
            java.lang.Object r9 = r9.m4372forSetupIntentBWLJW6A(r1, r6, r5, r7)
            if (r9 != r0) goto L_0x0093
            return r0
        L_0x0093:
            boolean r1 = kotlin.Result.m4716isSuccessimpl(r9)
            if (r1 == 0) goto L_0x00b3
            kotlin.Result$Companion r1 = kotlin.Result.Companion     // Catch:{ all -> 0x00ac }
            com.stripe.android.model.StripeIntent r9 = (com.stripe.android.model.StripeIntent) r9     // Catch:{ all -> 0x00ac }
            com.stripe.android.payments.bankaccount.navigation.CollectBankAccountResult$Completed r1 = new com.stripe.android.payments.bankaccount.navigation.CollectBankAccountResult$Completed     // Catch:{ all -> 0x00ac }
            com.stripe.android.payments.bankaccount.navigation.CollectBankAccountResponse r4 = new com.stripe.android.payments.bankaccount.navigation.CollectBankAccountResponse     // Catch:{ all -> 0x00ac }
            r4.<init>(r9)     // Catch:{ all -> 0x00ac }
            r1.<init>(r4)     // Catch:{ all -> 0x00ac }
            java.lang.Object r9 = kotlin.Result.m4709constructorimpl(r1)     // Catch:{ all -> 0x00ac }
            goto L_0x00b7
        L_0x00ac:
            r9 = move-exception
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r9 = kotlin.ResultKt.createFailure(r9)
        L_0x00b3:
            java.lang.Object r9 = kotlin.Result.m4709constructorimpl(r9)
        L_0x00b7:
            r1 = r9
            com.stripe.android.payments.bankaccount.ui.CollectBankAccountViewModel r9 = r8.this$0
            boolean r4 = kotlin.Result.m4716isSuccessimpl(r1)
            if (r4 == 0) goto L_0x00d9
            r4 = r1
            com.stripe.android.payments.bankaccount.navigation.CollectBankAccountResult$Completed r4 = (com.stripe.android.payments.bankaccount.navigation.CollectBankAccountResult.Completed) r4
            com.stripe.android.core.Logger r5 = r9.logger
            java.lang.String r6 = "Bank account session attached to  intent!!"
            r5.debug(r6)
            com.stripe.android.payments.bankaccount.navigation.CollectBankAccountResult r4 = (com.stripe.android.payments.bankaccount.navigation.CollectBankAccountResult) r4
            r8.L$0 = r1
            r8.label = r3
            java.lang.Object r9 = r9.finishWithResult(r4, r8)
            if (r9 != r0) goto L_0x00d9
            return r0
        L_0x00d9:
            com.stripe.android.payments.bankaccount.ui.CollectBankAccountViewModel r9 = r8.this$0
            java.lang.Throwable r3 = kotlin.Result.m4712exceptionOrNullimpl(r1)
            if (r3 != 0) goto L_0x00e2
            goto L_0x00ed
        L_0x00e2:
            r8.L$0 = r1
            r8.label = r2
            java.lang.Object r9 = r9.finishWithError(r3, r8)
            if (r9 != r0) goto L_0x00ed
            return r0
        L_0x00ed:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L_0x00f0:
            kotlin.NoWhenBranchMatchedException r9 = new kotlin.NoWhenBranchMatchedException
            r9.<init>()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.payments.bankaccount.ui.CollectBankAccountViewModel$attachLinkAccountSessionToIntent$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
