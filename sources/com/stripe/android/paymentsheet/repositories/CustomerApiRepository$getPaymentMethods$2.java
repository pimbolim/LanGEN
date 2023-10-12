package com.stripe.android.paymentsheet.repositories;

import com.stripe.android.model.PaymentMethod;
import com.stripe.android.paymentsheet.PaymentSheet;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.SupervisorKt;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "Lcom/stripe/android/model/PaymentMethod;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.paymentsheet.repositories.CustomerApiRepository$getPaymentMethods$2", f = "CustomerApiRepository.kt", i = {}, l = {37}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: CustomerApiRepository.kt */
final class CustomerApiRepository$getPaymentMethods$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends PaymentMethod>>, Object> {
    final /* synthetic */ PaymentSheet.CustomerConfiguration $customerConfig;
    final /* synthetic */ List<PaymentMethod.Type> $types;
    int label;
    final /* synthetic */ CustomerApiRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CustomerApiRepository$getPaymentMethods$2(List<? extends PaymentMethod.Type> list, CustomerApiRepository customerApiRepository, PaymentSheet.CustomerConfiguration customerConfiguration, Continuation<? super CustomerApiRepository$getPaymentMethods$2> continuation) {
        super(2, continuation);
        this.$types = list;
        this.this$0 = customerApiRepository;
        this.$customerConfig = customerConfiguration;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CustomerApiRepository$getPaymentMethods$2(this.$types, this.this$0, this.$customerConfig, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<PaymentMethod>> continuation) {
        return ((CustomerApiRepository$getPaymentMethods$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "Lcom/stripe/android/model/PaymentMethod;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.stripe.android.paymentsheet.repositories.CustomerApiRepository$getPaymentMethods$2$1", f = "CustomerApiRepository.kt", i = {0, 0}, l = {55}, m = "invokeSuspend", n = {"$this$supervisorScope", "destination$iv$iv"}, s = {"L$0", "L$2"})
    /* renamed from: com.stripe.android.paymentsheet.repositories.CustomerApiRepository$getPaymentMethods$2$1  reason: invalid class name */
    /* compiled from: CustomerApiRepository.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends PaymentMethod>>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(list, customerApiRepository, customerConfiguration, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<PaymentMethod>> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x009f  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x00e5  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x00f8  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x0105  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                r13 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r13.label
                r2 = 1
                if (r1 == 0) goto L_0x003d
                if (r1 != r2) goto L_0x0035
                java.lang.Object r1 = r13.L$4
                java.util.Collection r1 = (java.util.Collection) r1
                java.lang.Object r3 = r13.L$3
                java.util.Iterator r3 = (java.util.Iterator) r3
                java.lang.Object r4 = r13.L$2
                java.util.Collection r4 = (java.util.Collection) r4
                java.lang.Object r5 = r13.L$1
                com.stripe.android.paymentsheet.repositories.CustomerApiRepository r5 = (com.stripe.android.paymentsheet.repositories.CustomerApiRepository) r5
                java.lang.Object r6 = r13.L$0
                kotlinx.coroutines.CoroutineScope r6 = (kotlinx.coroutines.CoroutineScope) r6
                kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ all -> 0x002b }
                r7 = r6
                r6 = r5
                r5 = r4
                r4 = r3
                r3 = r1
                r1 = r0
                r0 = r13
                goto L_0x00c2
            L_0x002b:
                r14 = move-exception
                r7 = r6
                r6 = r5
                r5 = r4
                r4 = r3
                r3 = r1
                r1 = r0
                r0 = r13
                goto L_0x00d4
            L_0x0035:
                java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r14.<init>(r0)
                throw r14
            L_0x003d:
                kotlin.ResultKt.throwOnFailure(r14)
                java.lang.Object r14 = r13.L$0
                kotlinx.coroutines.CoroutineScope r14 = (kotlinx.coroutines.CoroutineScope) r14
                java.util.List<com.stripe.android.model.PaymentMethod$Type> r1 = r1
                java.lang.Iterable r1 = (java.lang.Iterable) r1
                com.stripe.android.paymentsheet.repositories.CustomerApiRepository r9 = r3
                com.stripe.android.paymentsheet.PaymentSheet$CustomerConfiguration r10 = r4
                java.util.ArrayList r3 = new java.util.ArrayList
                r11 = 10
                int r4 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r1, r11)
                r3.<init>(r4)
                r12 = r3
                java.util.Collection r12 = (java.util.Collection) r12
                java.util.Iterator r1 = r1.iterator()
            L_0x005e:
                boolean r3 = r1.hasNext()
                if (r3 == 0) goto L_0x007f
                java.lang.Object r3 = r1.next()
                com.stripe.android.model.PaymentMethod$Type r3 = (com.stripe.android.model.PaymentMethod.Type) r3
                r4 = 0
                r5 = 0
                com.stripe.android.paymentsheet.repositories.CustomerApiRepository$getPaymentMethods$2$1$1$1 r6 = new com.stripe.android.paymentsheet.repositories.CustomerApiRepository$getPaymentMethods$2$1$1$1
                r7 = 0
                r6.<init>(r9, r10, r3, r7)
                kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
                r7 = 3
                r8 = 0
                r3 = r14
                kotlinx.coroutines.Deferred r3 = kotlinx.coroutines.BuildersKt__Builders_commonKt.async$default(r3, r4, r5, r6, r7, r8)
                r12.add(r3)
                goto L_0x005e
            L_0x007f:
                java.util.List r12 = (java.util.List) r12
                java.lang.Iterable r12 = (java.lang.Iterable) r12
                com.stripe.android.paymentsheet.repositories.CustomerApiRepository r1 = r3
                java.util.ArrayList r3 = new java.util.ArrayList
                int r4 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r12, r11)
                r3.<init>(r4)
                java.util.Collection r3 = (java.util.Collection) r3
                java.util.Iterator r4 = r12.iterator()
                r6 = r14
                r5 = r1
                r1 = r3
                r3 = r4
                r14 = r13
            L_0x0099:
                boolean r4 = r3.hasNext()
                if (r4 == 0) goto L_0x0105
                java.lang.Object r4 = r3.next()
                kotlinx.coroutines.Deferred r4 = (kotlinx.coroutines.Deferred) r4
                kotlin.Result$Companion r7 = kotlin.Result.Companion     // Catch:{ all -> 0x00cb }
                r14.L$0 = r6     // Catch:{ all -> 0x00cb }
                r14.L$1 = r5     // Catch:{ all -> 0x00cb }
                r14.L$2 = r1     // Catch:{ all -> 0x00cb }
                r14.L$3 = r3     // Catch:{ all -> 0x00cb }
                r14.L$4 = r1     // Catch:{ all -> 0x00cb }
                r14.label = r2     // Catch:{ all -> 0x00cb }
                java.lang.Object r4 = r4.await(r14)     // Catch:{ all -> 0x00cb }
                if (r4 != r0) goto L_0x00ba
                return r0
            L_0x00ba:
                r7 = r6
                r6 = r5
                r5 = r1
                r1 = r0
                r0 = r14
                r14 = r4
                r4 = r3
                r3 = r5
            L_0x00c2:
                java.util.List r14 = (java.util.List) r14     // Catch:{ all -> 0x00c9 }
                java.lang.Object r14 = kotlin.Result.m4709constructorimpl(r14)     // Catch:{ all -> 0x00c9 }
                goto L_0x00de
            L_0x00c9:
                r14 = move-exception
                goto L_0x00d4
            L_0x00cb:
                r4 = move-exception
                r7 = r6
                r6 = r5
                r5 = r1
                r1 = r0
                r0 = r14
                r14 = r4
                r4 = r3
                r3 = r5
            L_0x00d4:
                kotlin.Result$Companion r8 = kotlin.Result.Companion
                java.lang.Object r14 = kotlin.ResultKt.createFailure(r14)
                java.lang.Object r14 = kotlin.Result.m4709constructorimpl(r14)
            L_0x00de:
                java.lang.Throwable r8 = kotlin.Result.m4712exceptionOrNullimpl(r14)
                if (r8 != 0) goto L_0x00e5
                goto L_0x00ee
            L_0x00e5:
                com.stripe.android.core.Logger r9 = r6.logger
                java.lang.String r10 = "Failed to retrieve payment methods."
                r9.error(r10, r8)
            L_0x00ee:
                java.util.List r8 = kotlin.collections.CollectionsKt.emptyList()
                boolean r9 = kotlin.Result.m4715isFailureimpl(r14)
                if (r9 == 0) goto L_0x00f9
                r14 = r8
            L_0x00f9:
                java.util.List r14 = (java.util.List) r14
                r3.add(r14)
                r14 = r0
                r0 = r1
                r3 = r4
                r1 = r5
                r5 = r6
                r6 = r7
                goto L_0x0099
            L_0x0105:
                java.util.List r1 = (java.util.List) r1
                java.lang.Iterable r1 = (java.lang.Iterable) r1
                java.util.List r14 = kotlin.collections.CollectionsKt.flatten(r1)
                return r14
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.paymentsheet.repositories.CustomerApiRepository$getPaymentMethods$2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final List<PaymentMethod.Type> list = this.$types;
            final CustomerApiRepository customerApiRepository = this.this$0;
            final PaymentSheet.CustomerConfiguration customerConfiguration = this.$customerConfig;
            this.label = 1;
            obj = SupervisorKt.supervisorScope(new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
