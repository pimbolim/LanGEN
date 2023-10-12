package com.stripe.android.paymentsheet.repositories;

import com.stripe.android.model.StripeIntent;
import com.stripe.android.paymentsheet.model.ClientSecret;
import com.stripe.android.paymentsheet.repositories.StripeIntentRepository;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Lcom/stripe/android/model/StripeIntent;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.paymentsheet.repositories.StripeIntentRepository$Api$get$2", f = "StripeIntentRepository.kt", i = {}, l = {56, 61, 73, 78}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: StripeIntentRepository.kt */
final class StripeIntentRepository$Api$get$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super StripeIntent>, Object> {
    final /* synthetic */ ClientSecret $clientSecret;
    int label;
    final /* synthetic */ StripeIntentRepository.Api this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StripeIntentRepository$Api$get$2(ClientSecret clientSecret, StripeIntentRepository.Api api, Continuation<? super StripeIntentRepository$Api$get$2> continuation) {
        super(2, continuation);
        this.$clientSecret = clientSecret;
        this.this$0 = api;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StripeIntentRepository$Api$get$2(this.$clientSecret, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super StripeIntent> continuation) {
        return ((StripeIntentRepository$Api$get$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00f0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            java.lang.String r2 = "payment_method"
            r3 = 0
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            if (r1 == 0) goto L_0x0031
            if (r1 == r7) goto L_0x002d
            if (r1 == r6) goto L_0x0029
            if (r1 == r5) goto L_0x0024
            if (r1 != r4) goto L_0x001c
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x00e8
        L_0x001c:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0024:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x00c1
        L_0x0029:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0083
        L_0x002d:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x005c
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r9)
            com.stripe.android.paymentsheet.model.ClientSecret r9 = r8.$clientSecret
            boolean r1 = r9 instanceof com.stripe.android.paymentsheet.model.PaymentIntentClientSecret
            if (r1 == 0) goto L_0x0097
            com.stripe.android.paymentsheet.repositories.StripeIntentRepository$Api r9 = r8.this$0
            java.util.Locale r9 = r9.locale
            if (r9 != 0) goto L_0x0043
            goto L_0x005f
        L_0x0043:
            com.stripe.android.paymentsheet.repositories.StripeIntentRepository$Api r1 = r8.this$0
            com.stripe.android.paymentsheet.model.ClientSecret r3 = r8.$clientSecret
            com.stripe.android.networking.StripeRepository r4 = r1.stripeRepository
            java.lang.String r3 = r3.getValue()
            com.stripe.android.core.networking.ApiRequest$Options r1 = r1.getRequestOptions()
            r8.label = r7
            java.lang.Object r9 = r4.retrievePaymentIntentWithOrderedPaymentMethods(r3, r1, r9, r8)
            if (r9 != r0) goto L_0x005c
            return r0
        L_0x005c:
            r3 = r9
            com.stripe.android.model.PaymentIntent r3 = (com.stripe.android.model.PaymentIntent) r3
        L_0x005f:
            if (r3 != 0) goto L_0x0086
            com.stripe.android.paymentsheet.repositories.StripeIntentRepository$Api r9 = r8.this$0
            com.stripe.android.networking.StripeRepository r9 = r9.stripeRepository
            com.stripe.android.paymentsheet.model.ClientSecret r1 = r8.$clientSecret
            java.lang.String r1 = r1.getValue()
            com.stripe.android.paymentsheet.repositories.StripeIntentRepository$Api r3 = r8.this$0
            com.stripe.android.core.networking.ApiRequest$Options r3 = r3.getRequestOptions()
            java.util.List r2 = kotlin.collections.CollectionsKt.listOf(r2)
            r4 = r8
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r8.label = r6
            java.lang.Object r9 = r9.retrievePaymentIntent(r1, r3, r2, r4)
            if (r9 != r0) goto L_0x0083
            return r0
        L_0x0083:
            r3 = r9
            com.stripe.android.model.PaymentIntent r3 = (com.stripe.android.model.PaymentIntent) r3
        L_0x0086:
            if (r3 == 0) goto L_0x008b
            com.stripe.android.model.StripeIntent r3 = (com.stripe.android.model.StripeIntent) r3
            goto L_0x00ef
        L_0x008b:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Could not parse PaymentIntent."
            java.lang.String r0 = r0.toString()
            r9.<init>(r0)
            throw r9
        L_0x0097:
            boolean r9 = r9 instanceof com.stripe.android.paymentsheet.model.SetupIntentClientSecret
            if (r9 == 0) goto L_0x00fc
            com.stripe.android.paymentsheet.repositories.StripeIntentRepository$Api r9 = r8.this$0
            java.util.Locale r9 = r9.locale
            if (r9 != 0) goto L_0x00a4
            goto L_0x00c4
        L_0x00a4:
            com.stripe.android.paymentsheet.repositories.StripeIntentRepository$Api r9 = r8.this$0
            com.stripe.android.paymentsheet.model.ClientSecret r1 = r8.$clientSecret
            com.stripe.android.networking.StripeRepository r3 = r9.stripeRepository
            java.lang.String r1 = r1.getValue()
            com.stripe.android.core.networking.ApiRequest$Options r6 = r9.getRequestOptions()
            java.util.Locale r9 = r9.locale
            r8.label = r5
            java.lang.Object r9 = r3.retrieveSetupIntentWithOrderedPaymentMethods(r1, r6, r9, r8)
            if (r9 != r0) goto L_0x00c1
            return r0
        L_0x00c1:
            r3 = r9
            com.stripe.android.model.SetupIntent r3 = (com.stripe.android.model.SetupIntent) r3
        L_0x00c4:
            if (r3 != 0) goto L_0x00eb
            com.stripe.android.paymentsheet.repositories.StripeIntentRepository$Api r9 = r8.this$0
            com.stripe.android.networking.StripeRepository r9 = r9.stripeRepository
            com.stripe.android.paymentsheet.model.ClientSecret r1 = r8.$clientSecret
            java.lang.String r1 = r1.getValue()
            com.stripe.android.paymentsheet.repositories.StripeIntentRepository$Api r3 = r8.this$0
            com.stripe.android.core.networking.ApiRequest$Options r3 = r3.getRequestOptions()
            java.util.List r2 = kotlin.collections.CollectionsKt.listOf(r2)
            r5 = r8
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r8.label = r4
            java.lang.Object r9 = r9.retrieveSetupIntent(r1, r3, r2, r5)
            if (r9 != r0) goto L_0x00e8
            return r0
        L_0x00e8:
            r3 = r9
            com.stripe.android.model.SetupIntent r3 = (com.stripe.android.model.SetupIntent) r3
        L_0x00eb:
            if (r3 == 0) goto L_0x00f0
            com.stripe.android.model.StripeIntent r3 = (com.stripe.android.model.StripeIntent) r3
        L_0x00ef:
            return r3
        L_0x00f0:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Could not parse SetupIntent."
            java.lang.String r0 = r0.toString()
            r9.<init>(r0)
            throw r9
        L_0x00fc:
            kotlin.NoWhenBranchMatchedException r9 = new kotlin.NoWhenBranchMatchedException
            r9.<init>()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.paymentsheet.repositories.StripeIntentRepository$Api$get$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
