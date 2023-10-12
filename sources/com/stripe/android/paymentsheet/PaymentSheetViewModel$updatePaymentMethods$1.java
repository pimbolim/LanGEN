package com.stripe.android.paymentsheet;

import com.stripe.android.model.StripeIntent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.paymentsheet.PaymentSheetViewModel$updatePaymentMethods$1", f = "PaymentSheetViewModel.kt", i = {}, l = {271}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: PaymentSheetViewModel.kt */
final class PaymentSheetViewModel$updatePaymentMethods$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ StripeIntent $stripeIntent;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PaymentSheetViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaymentSheetViewModel$updatePaymentMethods$1(PaymentSheetViewModel paymentSheetViewModel, StripeIntent stripeIntent, Continuation<? super PaymentSheetViewModel$updatePaymentMethods$1> continuation) {
        super(2, continuation);
        this.this$0 = paymentSheetViewModel;
        this.$stripeIntent = stripeIntent;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PaymentSheetViewModel$updatePaymentMethods$1 paymentSheetViewModel$updatePaymentMethods$1 = new PaymentSheetViewModel$updatePaymentMethods$1(this.this$0, this.$stripeIntent, continuation);
        paymentSheetViewModel$updatePaymentMethods$1.L$0 = obj;
        return paymentSheetViewModel$updatePaymentMethods$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PaymentSheetViewModel$updatePaymentMethods$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b2 A[Catch:{ all -> 0x00bb }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00e2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.label
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x001c
            if (r1 != r2) goto L_0x0014
            java.lang.Object r0 = r9.L$0
            com.stripe.android.paymentsheet.PaymentSheetViewModel r0 = (com.stripe.android.paymentsheet.PaymentSheetViewModel) r0
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x00bb }
            goto L_0x0076
        L_0x0014:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x001c:
            kotlin.ResultKt.throwOnFailure(r10)
            java.lang.Object r10 = r9.L$0
            kotlinx.coroutines.CoroutineScope r10 = (kotlinx.coroutines.CoroutineScope) r10
            com.stripe.android.paymentsheet.PaymentSheetViewModel r10 = r9.this$0
            com.stripe.android.model.StripeIntent r1 = r9.$stripeIntent
            kotlin.Result$Companion r4 = kotlin.Result.Companion     // Catch:{ all -> 0x00bb }
            com.stripe.android.paymentsheet.PaymentSheet$CustomerConfiguration r4 = r10.getCustomerConfig$paymentsheet_release()     // Catch:{ all -> 0x00bb }
            if (r4 != 0) goto L_0x0032
            r1 = r3
            goto L_0x00b0
        L_0x0032:
            com.stripe.android.paymentsheet.model.SupportedPaymentMethod$Companion r5 = com.stripe.android.paymentsheet.model.SupportedPaymentMethod.Companion     // Catch:{ all -> 0x00bb }
            com.stripe.android.paymentsheet.PaymentSheet$Configuration r6 = r10.getConfig$paymentsheet_release()     // Catch:{ all -> 0x00bb }
            java.util.List r1 = r5.getSupportedSavedCustomerPMs$paymentsheet_release(r1, r6)     // Catch:{ all -> 0x00bb }
            java.lang.Iterable r1 = (java.lang.Iterable) r1     // Catch:{ all -> 0x00bb }
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x00bb }
            r6 = 10
            int r6 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r1, r6)     // Catch:{ all -> 0x00bb }
            r5.<init>(r6)     // Catch:{ all -> 0x00bb }
            java.util.Collection r5 = (java.util.Collection) r5     // Catch:{ all -> 0x00bb }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x00bb }
        L_0x004f:
            boolean r6 = r1.hasNext()     // Catch:{ all -> 0x00bb }
            if (r6 == 0) goto L_0x0063
            java.lang.Object r6 = r1.next()     // Catch:{ all -> 0x00bb }
            com.stripe.android.paymentsheet.model.SupportedPaymentMethod r6 = (com.stripe.android.paymentsheet.model.SupportedPaymentMethod) r6     // Catch:{ all -> 0x00bb }
            com.stripe.android.model.PaymentMethod$Type r6 = r6.getType()     // Catch:{ all -> 0x00bb }
            r5.add(r6)     // Catch:{ all -> 0x00bb }
            goto L_0x004f
        L_0x0063:
            java.util.List r5 = (java.util.List) r5     // Catch:{ all -> 0x00bb }
            com.stripe.android.paymentsheet.repositories.CustomerRepository r1 = r10.getCustomerRepository()     // Catch:{ all -> 0x00bb }
            r9.L$0 = r10     // Catch:{ all -> 0x00bb }
            r9.label = r2     // Catch:{ all -> 0x00bb }
            java.lang.Object r1 = r1.getPaymentMethods(r4, r5, r9)     // Catch:{ all -> 0x00bb }
            if (r1 != r0) goto L_0x0074
            return r0
        L_0x0074:
            r0 = r10
            r10 = r1
        L_0x0076:
            java.util.List r10 = (java.util.List) r10     // Catch:{ all -> 0x00bb }
            java.lang.Iterable r10 = (java.lang.Iterable) r10     // Catch:{ all -> 0x00bb }
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x00bb }
            r1.<init>()     // Catch:{ all -> 0x00bb }
            java.util.Collection r1 = (java.util.Collection) r1     // Catch:{ all -> 0x00bb }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ all -> 0x00bb }
        L_0x0085:
            boolean r4 = r10.hasNext()     // Catch:{ all -> 0x00bb }
            if (r4 == 0) goto L_0x00ae
            java.lang.Object r4 = r10.next()     // Catch:{ all -> 0x00bb }
            r5 = r4
            com.stripe.android.model.PaymentMethod r5 = (com.stripe.android.model.PaymentMethod) r5     // Catch:{ all -> 0x00bb }
            boolean r6 = r5.hasExpectedDetails()     // Catch:{ all -> 0x00bb }
            if (r6 != 0) goto L_0x00a8
            com.stripe.android.core.Logger r7 = r0.getLogger()     // Catch:{ all -> 0x00bb }
            java.lang.String r8 = "Discarding invalid payment method "
            java.lang.String r5 = r5.id     // Catch:{ all -> 0x00bb }
            java.lang.String r5 = kotlin.jvm.internal.Intrinsics.stringPlus(r8, r5)     // Catch:{ all -> 0x00bb }
            r8 = 2
            com.stripe.android.core.Logger.DefaultImpls.error$default(r7, r5, r3, r8, r3)     // Catch:{ all -> 0x00bb }
        L_0x00a8:
            if (r6 == 0) goto L_0x0085
            r1.add(r4)     // Catch:{ all -> 0x00bb }
            goto L_0x0085
        L_0x00ae:
            java.util.List r1 = (java.util.List) r1     // Catch:{ all -> 0x00bb }
        L_0x00b0:
            if (r1 != 0) goto L_0x00b6
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()     // Catch:{ all -> 0x00bb }
        L_0x00b6:
            java.lang.Object r10 = kotlin.Result.m4709constructorimpl(r1)     // Catch:{ all -> 0x00bb }
            goto L_0x00c6
        L_0x00bb:
            r10 = move-exception
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r10 = kotlin.ResultKt.createFailure(r10)
            java.lang.Object r10 = kotlin.Result.m4709constructorimpl(r10)
        L_0x00c6:
            com.stripe.android.paymentsheet.PaymentSheetViewModel r0 = r9.this$0
            com.stripe.android.model.StripeIntent r1 = r9.$stripeIntent
            java.lang.Throwable r4 = kotlin.Result.m4712exceptionOrNullimpl(r10)
            if (r4 != 0) goto L_0x00e2
            java.util.List r10 = (java.util.List) r10
            androidx.lifecycle.SavedStateHandle r4 = r0.getSavedStateHandle()
            java.lang.String r5 = "customer_payment_methods"
            r4.set(r5, r10)
            r0.setStripeIntent(r1)
            com.stripe.android.paymentsheet.PaymentSheetViewModel.resetViewState$default(r0, r3, r2, r3)
            goto L_0x00e5
        L_0x00e2:
            r0.onFatal(r4)
        L_0x00e5:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.paymentsheet.PaymentSheetViewModel$updatePaymentMethods$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
