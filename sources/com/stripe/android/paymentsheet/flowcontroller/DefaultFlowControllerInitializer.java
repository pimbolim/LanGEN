package com.stripe.android.paymentsheet.flowcontroller;

import com.stripe.android.core.Logger;
import com.stripe.android.core.injection.IOContext;
import com.stripe.android.googlepaylauncher.GooglePayEnvironment;
import com.stripe.android.googlepaylauncher.GooglePayRepository;
import com.stripe.android.paymentsheet.PaymentSheet;
import com.stripe.android.paymentsheet.PrefsRepository;
import com.stripe.android.paymentsheet.flowcontroller.FlowControllerInitializer;
import com.stripe.android.paymentsheet.model.ClientSecret;
import com.stripe.android.paymentsheet.model.StripeIntentValidator;
import com.stripe.android.paymentsheet.repositories.CustomerRepository;
import com.stripe.android.paymentsheet.repositories.StripeIntentRepository;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

@Singleton
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001Be\b\u0007\u0012\u0019\u0010\u0002\u001a\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006\u0012\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0003¢\u0006\u0002\b\u0006\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0001\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J3\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ+\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH@ø\u0001\u0000¢\u0006\u0002\u0010 J#\u0010!\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\"\u001a\u0004\u0018\u00010\u001bH@ø\u0001\u0000¢\u0006\u0002\u0010#J\u001b\u0010\u001c\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010\u001bH@ø\u0001\u0000¢\u0006\u0002\u0010$J\u0019\u0010%\u001a\u00020&2\u0006\u0010\u0017\u001a\u00020\u0018H@ø\u0001\u0000¢\u0006\u0002\u0010'J/\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,H@ø\u0001\u0000¢\u0006\u0002\u0010.R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0003¢\u0006\u0002\b\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R!\u0010\u0002\u001a\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006/"}, d2 = {"Lcom/stripe/android/paymentsheet/flowcontroller/DefaultFlowControllerInitializer;", "Lcom/stripe/android/paymentsheet/flowcontroller/FlowControllerInitializer;", "prefsRepositoryFactory", "Lkotlin/Function1;", "Lcom/stripe/android/paymentsheet/PaymentSheet$CustomerConfiguration;", "Lcom/stripe/android/paymentsheet/PrefsRepository;", "Lkotlin/jvm/JvmSuppressWildcards;", "googlePayRepositoryFactory", "Lcom/stripe/android/googlepaylauncher/GooglePayEnvironment;", "Lcom/stripe/android/googlepaylauncher/GooglePayRepository;", "stripeIntentRepository", "Lcom/stripe/android/paymentsheet/repositories/StripeIntentRepository;", "stripeIntentValidator", "Lcom/stripe/android/paymentsheet/model/StripeIntentValidator;", "customerRepository", "Lcom/stripe/android/paymentsheet/repositories/CustomerRepository;", "logger", "Lcom/stripe/android/core/Logger;", "workContext", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lcom/stripe/android/paymentsheet/repositories/StripeIntentRepository;Lcom/stripe/android/paymentsheet/model/StripeIntentValidator;Lcom/stripe/android/paymentsheet/repositories/CustomerRepository;Lcom/stripe/android/core/Logger;Lkotlin/coroutines/CoroutineContext;)V", "createWithCustomer", "Lcom/stripe/android/paymentsheet/flowcontroller/FlowControllerInitializer$InitResult;", "clientSecret", "Lcom/stripe/android/paymentsheet/model/ClientSecret;", "customerConfig", "config", "Lcom/stripe/android/paymentsheet/PaymentSheet$Configuration;", "isGooglePayReady", "", "(Lcom/stripe/android/paymentsheet/model/ClientSecret;Lcom/stripe/android/paymentsheet/PaymentSheet$CustomerConfiguration;Lcom/stripe/android/paymentsheet/PaymentSheet$Configuration;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createWithoutCustomer", "(Lcom/stripe/android/paymentsheet/model/ClientSecret;Lcom/stripe/android/paymentsheet/PaymentSheet$Configuration;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "init", "paymentSheetConfiguration", "(Lcom/stripe/android/paymentsheet/model/ClientSecret;Lcom/stripe/android/paymentsheet/PaymentSheet$Configuration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lcom/stripe/android/paymentsheet/PaymentSheet$Configuration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "retrieveStripeIntent", "Lcom/stripe/android/model/StripeIntent;", "(Lcom/stripe/android/paymentsheet/model/ClientSecret;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setLastSavedPaymentMethod", "", "prefsRepository", "paymentMethods", "", "Lcom/stripe/android/model/PaymentMethod;", "(Lcom/stripe/android/paymentsheet/PrefsRepository;ZLjava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DefaultFlowControllerInitializer.kt */
public final class DefaultFlowControllerInitializer implements FlowControllerInitializer {
    private final CustomerRepository customerRepository;
    private final Function1<GooglePayEnvironment, GooglePayRepository> googlePayRepositoryFactory;
    private final Logger logger;
    private final Function1<PaymentSheet.CustomerConfiguration, PrefsRepository> prefsRepositoryFactory;
    private final StripeIntentRepository stripeIntentRepository;
    private final StripeIntentValidator stripeIntentValidator;
    private final CoroutineContext workContext;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DefaultFlowControllerInitializer.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PaymentSheet.GooglePayConfiguration.Environment.values().length];
            iArr[PaymentSheet.GooglePayConfiguration.Environment.Production.ordinal()] = 1;
            iArr[PaymentSheet.GooglePayConfiguration.Environment.Test.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public DefaultFlowControllerInitializer(Function1<PaymentSheet.CustomerConfiguration, PrefsRepository> function1, Function1<GooglePayEnvironment, GooglePayRepository> function12, StripeIntentRepository stripeIntentRepository2, StripeIntentValidator stripeIntentValidator2, CustomerRepository customerRepository2, Logger logger2, @IOContext CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(function1, "prefsRepositoryFactory");
        Intrinsics.checkNotNullParameter(function12, "googlePayRepositoryFactory");
        Intrinsics.checkNotNullParameter(stripeIntentRepository2, "stripeIntentRepository");
        Intrinsics.checkNotNullParameter(stripeIntentValidator2, "stripeIntentValidator");
        Intrinsics.checkNotNullParameter(customerRepository2, "customerRepository");
        Intrinsics.checkNotNullParameter(logger2, "logger");
        Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
        this.prefsRepositoryFactory = function1;
        this.googlePayRepositoryFactory = function12;
        this.stripeIntentRepository = stripeIntentRepository2;
        this.stripeIntentValidator = stripeIntentValidator2;
        this.customerRepository = customerRepository2;
        this.logger = logger2;
        this.workContext = coroutineContext;
    }

    public Object init(ClientSecret clientSecret, PaymentSheet.Configuration configuration, Continuation<? super FlowControllerInitializer.InitResult> continuation) {
        return BuildersKt.withContext(this.workContext, new DefaultFlowControllerInitializer$init$2(this, configuration, clientSecret, (Continuation<? super DefaultFlowControllerInitializer$init$2>) null), continuation);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object isGooglePayReady(com.stripe.android.paymentsheet.PaymentSheet.Configuration r6, kotlin.coroutines.Continuation<? super java.lang.Boolean> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.stripe.android.paymentsheet.flowcontroller.DefaultFlowControllerInitializer$isGooglePayReady$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.stripe.android.paymentsheet.flowcontroller.DefaultFlowControllerInitializer$isGooglePayReady$1 r0 = (com.stripe.android.paymentsheet.flowcontroller.DefaultFlowControllerInitializer$isGooglePayReady$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.stripe.android.paymentsheet.flowcontroller.DefaultFlowControllerInitializer$isGooglePayReady$1 r0 = new com.stripe.android.paymentsheet.flowcontroller.DefaultFlowControllerInitializer$isGooglePayReady$1
            r0.<init>(r5, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0033
            if (r2 != r3) goto L_0x002b
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x007a
        L_0x002b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0033:
            kotlin.ResultKt.throwOnFailure(r7)
            if (r6 != 0) goto L_0x0039
            goto L_0x0083
        L_0x0039:
            com.stripe.android.paymentsheet.PaymentSheet$GooglePayConfiguration r6 = r6.getGooglePay()
            if (r6 != 0) goto L_0x0040
            goto L_0x0083
        L_0x0040:
            com.stripe.android.paymentsheet.PaymentSheet$GooglePayConfiguration$Environment r6 = r6.getEnvironment()
            if (r6 != 0) goto L_0x0047
            goto L_0x0083
        L_0x0047:
            kotlin.jvm.functions.Function1<com.stripe.android.googlepaylauncher.GooglePayEnvironment, com.stripe.android.googlepaylauncher.GooglePayRepository> r7 = r5.googlePayRepositoryFactory
            int[] r2 = com.stripe.android.paymentsheet.flowcontroller.DefaultFlowControllerInitializer.WhenMappings.$EnumSwitchMapping$0
            int r6 = r6.ordinal()
            r6 = r2[r6]
            if (r6 == r3) goto L_0x005f
            r2 = 2
            if (r6 != r2) goto L_0x0059
            com.stripe.android.googlepaylauncher.GooglePayEnvironment r6 = com.stripe.android.googlepaylauncher.GooglePayEnvironment.Test
            goto L_0x0061
        L_0x0059:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        L_0x005f:
            com.stripe.android.googlepaylauncher.GooglePayEnvironment r6 = com.stripe.android.googlepaylauncher.GooglePayEnvironment.Production
        L_0x0061:
            java.lang.Object r6 = r7.invoke(r6)
            com.stripe.android.googlepaylauncher.GooglePayRepository r6 = (com.stripe.android.googlepaylauncher.GooglePayRepository) r6
            if (r6 != 0) goto L_0x006a
            goto L_0x0083
        L_0x006a:
            kotlinx.coroutines.flow.Flow r6 = r6.isReady()
            if (r6 != 0) goto L_0x0071
            goto L_0x0083
        L_0x0071:
            r0.label = r3
            java.lang.Object r7 = kotlinx.coroutines.flow.FlowKt.first(r6, r0)
            if (r7 != r1) goto L_0x007a
            return r1
        L_0x007a:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            if (r7 != 0) goto L_0x007f
            goto L_0x0083
        L_0x007f:
            boolean r4 = r7.booleanValue()
        L_0x0083:
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.paymentsheet.flowcontroller.DefaultFlowControllerInitializer.isGooglePayReady(com.stripe.android.paymentsheet.PaymentSheet$Configuration, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01b8 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01b9  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01d2 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01d3  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01e8  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object createWithCustomer(com.stripe.android.paymentsheet.model.ClientSecret r19, com.stripe.android.paymentsheet.PaymentSheet.CustomerConfiguration r20, com.stripe.android.paymentsheet.PaymentSheet.Configuration r21, boolean r22, kotlin.coroutines.Continuation<? super com.stripe.android.paymentsheet.flowcontroller.FlowControllerInitializer.InitResult> r23) {
        /*
            r18 = this;
            r1 = r18
            r2 = r19
            r3 = r20
            r0 = r23
            boolean r4 = r0 instanceof com.stripe.android.paymentsheet.flowcontroller.DefaultFlowControllerInitializer$createWithCustomer$1
            if (r4 == 0) goto L_0x001c
            r4 = r0
            com.stripe.android.paymentsheet.flowcontroller.DefaultFlowControllerInitializer$createWithCustomer$1 r4 = (com.stripe.android.paymentsheet.flowcontroller.DefaultFlowControllerInitializer$createWithCustomer$1) r4
            int r5 = r4.label
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r5 & r6
            if (r5 == 0) goto L_0x001c
            int r0 = r4.label
            int r0 = r0 - r6
            r4.label = r0
            goto L_0x0021
        L_0x001c:
            com.stripe.android.paymentsheet.flowcontroller.DefaultFlowControllerInitializer$createWithCustomer$1 r4 = new com.stripe.android.paymentsheet.flowcontroller.DefaultFlowControllerInitializer$createWithCustomer$1
            r4.<init>(r1, r0)
        L_0x0021:
            java.lang.Object r0 = r4.result
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r6 = r4.label
            r7 = 4
            r8 = 3
            r9 = 2
            r10 = 1
            if (r6 == 0) goto L_0x00c0
            if (r6 == r10) goto L_0x0095
            if (r6 == r9) goto L_0x007a
            if (r6 == r8) goto L_0x005d
            if (r6 != r7) goto L_0x0055
            boolean r2 = r4.Z$0
            java.lang.Object r3 = r4.L$3
            com.stripe.android.paymentsheet.PaymentSheet$Configuration r3 = (com.stripe.android.paymentsheet.PaymentSheet.Configuration) r3
            java.lang.Object r5 = r4.L$2
            com.stripe.android.paymentsheet.model.ClientSecret r5 = (com.stripe.android.paymentsheet.model.ClientSecret) r5
            java.lang.Object r6 = r4.L$1
            com.stripe.android.model.StripeIntent r6 = (com.stripe.android.model.StripeIntent) r6
            java.lang.Object r4 = r4.L$0
            java.util.List r4 = (java.util.List) r4
            kotlin.ResultKt.throwOnFailure(r0)
            r8 = r2
            r16 = r6
            r6 = r4
            r4 = r5
            r5 = r16
            goto L_0x01d7
        L_0x0055:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x005d:
            boolean r2 = r4.Z$0
            java.lang.Object r3 = r4.L$4
            java.util.List r3 = (java.util.List) r3
            java.lang.Object r6 = r4.L$3
            com.stripe.android.model.StripeIntent r6 = (com.stripe.android.model.StripeIntent) r6
            java.lang.Object r8 = r4.L$2
            com.stripe.android.paymentsheet.PrefsRepository r8 = (com.stripe.android.paymentsheet.PrefsRepository) r8
            java.lang.Object r9 = r4.L$1
            com.stripe.android.paymentsheet.PaymentSheet$Configuration r9 = (com.stripe.android.paymentsheet.PaymentSheet.Configuration) r9
            java.lang.Object r10 = r4.L$0
            com.stripe.android.paymentsheet.model.ClientSecret r10 = (com.stripe.android.paymentsheet.model.ClientSecret) r10
            kotlin.ResultKt.throwOnFailure(r0)
            r12 = r3
        L_0x0077:
            r3 = r9
            goto L_0x01bd
        L_0x007a:
            boolean r2 = r4.Z$0
            java.lang.Object r3 = r4.L$4
            com.stripe.android.model.StripeIntent r3 = (com.stripe.android.model.StripeIntent) r3
            java.lang.Object r6 = r4.L$3
            com.stripe.android.paymentsheet.PrefsRepository r6 = (com.stripe.android.paymentsheet.PrefsRepository) r6
            java.lang.Object r9 = r4.L$2
            com.stripe.android.paymentsheet.PaymentSheet$Configuration r9 = (com.stripe.android.paymentsheet.PaymentSheet.Configuration) r9
            java.lang.Object r10 = r4.L$1
            com.stripe.android.paymentsheet.model.ClientSecret r10 = (com.stripe.android.paymentsheet.model.ClientSecret) r10
            java.lang.Object r11 = r4.L$0
            com.stripe.android.paymentsheet.flowcontroller.DefaultFlowControllerInitializer r11 = (com.stripe.android.paymentsheet.flowcontroller.DefaultFlowControllerInitializer) r11
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x017e
        L_0x0095:
            boolean r2 = r4.Z$0
            java.lang.Object r3 = r4.L$4
            com.stripe.android.paymentsheet.PrefsRepository r3 = (com.stripe.android.paymentsheet.PrefsRepository) r3
            java.lang.Object r6 = r4.L$3
            com.stripe.android.paymentsheet.PaymentSheet$Configuration r6 = (com.stripe.android.paymentsheet.PaymentSheet.Configuration) r6
            java.lang.Object r10 = r4.L$2
            com.stripe.android.paymentsheet.PaymentSheet$CustomerConfiguration r10 = (com.stripe.android.paymentsheet.PaymentSheet.CustomerConfiguration) r10
            java.lang.Object r11 = r4.L$1
            com.stripe.android.paymentsheet.model.ClientSecret r11 = (com.stripe.android.paymentsheet.model.ClientSecret) r11
            java.lang.Object r12 = r4.L$0
            com.stripe.android.paymentsheet.flowcontroller.DefaultFlowControllerInitializer r12 = (com.stripe.android.paymentsheet.flowcontroller.DefaultFlowControllerInitializer) r12
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x00b4 }
            r16 = r12
            r12 = r2
            r2 = r16
            goto L_0x00ef
        L_0x00b4:
            r0 = move-exception
            r16 = r10
            r10 = r0
            r0 = r12
            r12 = r2
        L_0x00ba:
            r2 = r11
            r11 = r6
            r6 = r3
            r3 = r16
            goto L_0x0112
        L_0x00c0:
            kotlin.ResultKt.throwOnFailure(r0)
            kotlin.jvm.functions.Function1<com.stripe.android.paymentsheet.PaymentSheet$CustomerConfiguration, com.stripe.android.paymentsheet.PrefsRepository> r0 = r1.prefsRepositoryFactory
            java.lang.Object r0 = r0.invoke(r3)
            r6 = r0
            com.stripe.android.paymentsheet.PrefsRepository r6 = (com.stripe.android.paymentsheet.PrefsRepository) r6
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x010b }
            r0 = r1
            com.stripe.android.paymentsheet.flowcontroller.DefaultFlowControllerInitializer r0 = (com.stripe.android.paymentsheet.flowcontroller.DefaultFlowControllerInitializer) r0     // Catch:{ all -> 0x010b }
            r4.L$0 = r1     // Catch:{ all -> 0x010b }
            r4.L$1 = r2     // Catch:{ all -> 0x010b }
            r4.L$2 = r3     // Catch:{ all -> 0x010b }
            r11 = r21
            r4.L$3 = r11     // Catch:{ all -> 0x0109 }
            r4.L$4 = r6     // Catch:{ all -> 0x0109 }
            r12 = r22
            r4.Z$0 = r12     // Catch:{ all -> 0x0107 }
            r4.label = r10     // Catch:{ all -> 0x0107 }
            java.lang.Object r0 = r0.retrieveStripeIntent(r2, r4)     // Catch:{ all -> 0x0107 }
            if (r0 != r5) goto L_0x00ea
            return r5
        L_0x00ea:
            r10 = r3
            r3 = r6
            r6 = r11
            r11 = r2
            r2 = r1
        L_0x00ef:
            com.stripe.android.model.StripeIntent r0 = (com.stripe.android.model.StripeIntent) r0     // Catch:{ all -> 0x0101 }
            java.lang.Object r0 = kotlin.Result.m4709constructorimpl(r0)     // Catch:{ all -> 0x0101 }
            r16 = r12
            r12 = r2
            r2 = r16
            r17 = r11
            r11 = r6
            r6 = r10
            r10 = r17
            goto L_0x0128
        L_0x0101:
            r0 = move-exception
            r16 = r10
            r10 = r0
            r0 = r2
            goto L_0x00ba
        L_0x0107:
            r0 = move-exception
            goto L_0x0110
        L_0x0109:
            r0 = move-exception
            goto L_0x010e
        L_0x010b:
            r0 = move-exception
            r11 = r21
        L_0x010e:
            r12 = r22
        L_0x0110:
            r10 = r0
            r0 = r1
        L_0x0112:
            kotlin.Result$Companion r13 = kotlin.Result.Companion
            java.lang.Object r10 = kotlin.ResultKt.createFailure(r10)
            java.lang.Object r10 = kotlin.Result.m4709constructorimpl(r10)
            r16 = r12
            r12 = r0
            r0 = r10
            r10 = r2
            r2 = r16
            r17 = r6
            r6 = r3
            r3 = r17
        L_0x0128:
            java.lang.Throwable r13 = kotlin.Result.m4712exceptionOrNullimpl(r0)
            if (r13 != 0) goto L_0x01e8
            com.stripe.android.model.StripeIntent r0 = (com.stripe.android.model.StripeIntent) r0
            com.stripe.android.paymentsheet.model.SupportedPaymentMethod$Companion r13 = com.stripe.android.paymentsheet.model.SupportedPaymentMethod.Companion
            java.util.List r13 = r13.getSupportedSavedCustomerPMs$paymentsheet_release(r0, r11)
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.util.ArrayList r14 = new java.util.ArrayList
            r15 = 10
            int r15 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r13, r15)
            r14.<init>(r15)
            java.util.Collection r14 = (java.util.Collection) r14
            java.util.Iterator r13 = r13.iterator()
        L_0x0149:
            boolean r15 = r13.hasNext()
            if (r15 == 0) goto L_0x015d
            java.lang.Object r15 = r13.next()
            com.stripe.android.paymentsheet.model.SupportedPaymentMethod r15 = (com.stripe.android.paymentsheet.model.SupportedPaymentMethod) r15
            com.stripe.android.model.PaymentMethod$Type r15 = r15.getType()
            r14.add(r15)
            goto L_0x0149
        L_0x015d:
            java.util.List r14 = (java.util.List) r14
            com.stripe.android.paymentsheet.repositories.CustomerRepository r13 = r12.customerRepository
            r4.L$0 = r12
            r4.L$1 = r10
            r4.L$2 = r11
            r4.L$3 = r3
            r4.L$4 = r0
            r4.Z$0 = r2
            r4.label = r9
            java.lang.Object r6 = r13.getPaymentMethods(r6, r14, r4)
            if (r6 != r5) goto L_0x0176
            return r5
        L_0x0176:
            r9 = r11
            r11 = r12
            r16 = r3
            r3 = r0
            r0 = r6
            r6 = r16
        L_0x017e:
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            java.util.Collection r12 = (java.util.Collection) r12
            java.util.Iterator r0 = r0.iterator()
        L_0x018b:
            boolean r13 = r0.hasNext()
            if (r13 == 0) goto L_0x01a2
            java.lang.Object r13 = r0.next()
            r14 = r13
            com.stripe.android.model.PaymentMethod r14 = (com.stripe.android.model.PaymentMethod) r14
            boolean r14 = r14.hasExpectedDetails()
            if (r14 == 0) goto L_0x018b
            r12.add(r13)
            goto L_0x018b
        L_0x01a2:
            java.util.List r12 = (java.util.List) r12
            r4.L$0 = r10
            r4.L$1 = r9
            r4.L$2 = r6
            r4.L$3 = r3
            r4.L$4 = r12
            r4.Z$0 = r2
            r4.label = r8
            java.lang.Object r0 = r11.setLastSavedPaymentMethod(r6, r2, r12, r4)
            if (r0 != r5) goto L_0x01b9
            return r5
        L_0x01b9:
            r8 = r6
            r6 = r3
            goto L_0x0077
        L_0x01bd:
            r4.L$0 = r12
            r4.L$1 = r6
            r4.L$2 = r10
            r4.L$3 = r3
            r0 = 0
            r4.L$4 = r0
            r4.Z$0 = r2
            r4.label = r7
            java.lang.Object r0 = r8.getSavedSelection(r2, r4)
            if (r0 != r5) goto L_0x01d3
            return r5
        L_0x01d3:
            r8 = r2
            r5 = r6
            r4 = r10
            r6 = r12
        L_0x01d7:
            r7 = r0
            com.stripe.android.paymentsheet.model.SavedSelection r7 = (com.stripe.android.paymentsheet.model.SavedSelection) r7
            com.stripe.android.paymentsheet.flowcontroller.InitData r0 = new com.stripe.android.paymentsheet.flowcontroller.InitData
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8)
            com.stripe.android.paymentsheet.flowcontroller.FlowControllerInitializer$InitResult$Success r2 = new com.stripe.android.paymentsheet.flowcontroller.FlowControllerInitializer$InitResult$Success
            r2.<init>(r0)
            com.stripe.android.paymentsheet.flowcontroller.FlowControllerInitializer$InitResult r2 = (com.stripe.android.paymentsheet.flowcontroller.FlowControllerInitializer.InitResult) r2
            goto L_0x01f7
        L_0x01e8:
            com.stripe.android.core.Logger r0 = r12.logger
            java.lang.String r2 = "Failure initializing FlowController"
            r0.error(r2, r13)
            com.stripe.android.paymentsheet.flowcontroller.FlowControllerInitializer$InitResult$Failure r0 = new com.stripe.android.paymentsheet.flowcontroller.FlowControllerInitializer$InitResult$Failure
            r0.<init>(r13)
            r2 = r0
            com.stripe.android.paymentsheet.flowcontroller.FlowControllerInitializer$InitResult r2 = (com.stripe.android.paymentsheet.flowcontroller.FlowControllerInitializer.InitResult) r2
        L_0x01f7:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.paymentsheet.flowcontroller.DefaultFlowControllerInitializer.createWithCustomer(com.stripe.android.paymentsheet.model.ClientSecret, com.stripe.android.paymentsheet.PaymentSheet$CustomerConfiguration, com.stripe.android.paymentsheet.PaymentSheet$Configuration, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v16, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v9, resolved type: com.stripe.android.paymentsheet.PaymentSheet$Configuration} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object createWithoutCustomer(com.stripe.android.paymentsheet.model.ClientSecret r9, com.stripe.android.paymentsheet.PaymentSheet.Configuration r10, boolean r11, kotlin.coroutines.Continuation<? super com.stripe.android.paymentsheet.flowcontroller.FlowControllerInitializer.InitResult> r12) {
        /*
            r8 = this;
            boolean r0 = r12 instanceof com.stripe.android.paymentsheet.flowcontroller.DefaultFlowControllerInitializer$createWithoutCustomer$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            com.stripe.android.paymentsheet.flowcontroller.DefaultFlowControllerInitializer$createWithoutCustomer$1 r0 = (com.stripe.android.paymentsheet.flowcontroller.DefaultFlowControllerInitializer$createWithoutCustomer$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            com.stripe.android.paymentsheet.flowcontroller.DefaultFlowControllerInitializer$createWithoutCustomer$1 r0 = new com.stripe.android.paymentsheet.flowcontroller.DefaultFlowControllerInitializer$createWithoutCustomer$1
            r0.<init>(r8, r12)
        L_0x0019:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0043
            if (r2 != r3) goto L_0x003b
            boolean r11 = r0.Z$0
            java.lang.Object r9 = r0.L$2
            r10 = r9
            com.stripe.android.paymentsheet.PaymentSheet$Configuration r10 = (com.stripe.android.paymentsheet.PaymentSheet.Configuration) r10
            java.lang.Object r9 = r0.L$1
            com.stripe.android.paymentsheet.model.ClientSecret r9 = (com.stripe.android.paymentsheet.model.ClientSecret) r9
            java.lang.Object r0 = r0.L$0
            com.stripe.android.paymentsheet.flowcontroller.DefaultFlowControllerInitializer r0 = (com.stripe.android.paymentsheet.flowcontroller.DefaultFlowControllerInitializer) r0
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x0039 }
            goto L_0x005d
        L_0x0039:
            r12 = move-exception
            goto L_0x0066
        L_0x003b:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0043:
            kotlin.ResultKt.throwOnFailure(r12)
            kotlin.Result$Companion r12 = kotlin.Result.Companion     // Catch:{ all -> 0x0064 }
            r12 = r8
            com.stripe.android.paymentsheet.flowcontroller.DefaultFlowControllerInitializer r12 = (com.stripe.android.paymentsheet.flowcontroller.DefaultFlowControllerInitializer) r12     // Catch:{ all -> 0x0064 }
            r0.L$0 = r8     // Catch:{ all -> 0x0064 }
            r0.L$1 = r9     // Catch:{ all -> 0x0064 }
            r0.L$2 = r10     // Catch:{ all -> 0x0064 }
            r0.Z$0 = r11     // Catch:{ all -> 0x0064 }
            r0.label = r3     // Catch:{ all -> 0x0064 }
            java.lang.Object r12 = r12.retrieveStripeIntent(r9, r0)     // Catch:{ all -> 0x0064 }
            if (r12 != r1) goto L_0x005c
            return r1
        L_0x005c:
            r0 = r8
        L_0x005d:
            com.stripe.android.model.StripeIntent r12 = (com.stripe.android.model.StripeIntent) r12     // Catch:{ all -> 0x0039 }
            java.lang.Object r12 = kotlin.Result.m4709constructorimpl(r12)     // Catch:{ all -> 0x0039 }
            goto L_0x0070
        L_0x0064:
            r12 = move-exception
            r0 = r8
        L_0x0066:
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r12 = kotlin.ResultKt.createFailure(r12)
            java.lang.Object r12 = kotlin.Result.m4709constructorimpl(r12)
        L_0x0070:
            r3 = r9
            r2 = r10
            r7 = r11
            java.lang.Throwable r9 = kotlin.Result.m4712exceptionOrNullimpl(r12)
            if (r9 != 0) goto L_0x009a
            r4 = r12
            com.stripe.android.model.StripeIntent r4 = (com.stripe.android.model.StripeIntent) r4
            if (r7 == 0) goto L_0x0083
            com.stripe.android.paymentsheet.model.SavedSelection$GooglePay r9 = com.stripe.android.paymentsheet.model.SavedSelection.GooglePay.INSTANCE
            com.stripe.android.paymentsheet.model.SavedSelection r9 = (com.stripe.android.paymentsheet.model.SavedSelection) r9
            goto L_0x0087
        L_0x0083:
            com.stripe.android.paymentsheet.model.SavedSelection$None r9 = com.stripe.android.paymentsheet.model.SavedSelection.None.INSTANCE
            com.stripe.android.paymentsheet.model.SavedSelection r9 = (com.stripe.android.paymentsheet.model.SavedSelection) r9
        L_0x0087:
            r6 = r9
            com.stripe.android.paymentsheet.flowcontroller.FlowControllerInitializer$InitResult$Success r9 = new com.stripe.android.paymentsheet.flowcontroller.FlowControllerInitializer$InitResult$Success
            com.stripe.android.paymentsheet.flowcontroller.InitData r10 = new com.stripe.android.paymentsheet.flowcontroller.InitData
            java.util.List r5 = kotlin.collections.CollectionsKt.emptyList()
            r1 = r10
            r1.<init>(r2, r3, r4, r5, r6, r7)
            r9.<init>(r10)
            com.stripe.android.paymentsheet.flowcontroller.FlowControllerInitializer$InitResult r9 = (com.stripe.android.paymentsheet.flowcontroller.FlowControllerInitializer.InitResult) r9
            goto L_0x00a9
        L_0x009a:
            com.stripe.android.core.Logger r10 = r0.logger
            java.lang.String r11 = "Failure initializing FlowController"
            r10.error(r11, r9)
            com.stripe.android.paymentsheet.flowcontroller.FlowControllerInitializer$InitResult$Failure r10 = new com.stripe.android.paymentsheet.flowcontroller.FlowControllerInitializer$InitResult$Failure
            r10.<init>(r9)
            r9 = r10
            com.stripe.android.paymentsheet.flowcontroller.FlowControllerInitializer$InitResult r9 = (com.stripe.android.paymentsheet.flowcontroller.FlowControllerInitializer.InitResult) r9
        L_0x00a9:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.paymentsheet.flowcontroller.DefaultFlowControllerInitializer.createWithoutCustomer(com.stripe.android.paymentsheet.model.ClientSecret, com.stripe.android.paymentsheet.PaymentSheet$Configuration, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: java.util.List<com.stripe.android.model.PaymentMethod>} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setLastSavedPaymentMethod(com.stripe.android.paymentsheet.PrefsRepository r5, boolean r6, java.util.List<com.stripe.android.model.PaymentMethod> r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.stripe.android.paymentsheet.flowcontroller.DefaultFlowControllerInitializer$setLastSavedPaymentMethod$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.stripe.android.paymentsheet.flowcontroller.DefaultFlowControllerInitializer$setLastSavedPaymentMethod$1 r0 = (com.stripe.android.paymentsheet.flowcontroller.DefaultFlowControllerInitializer$setLastSavedPaymentMethod$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.stripe.android.paymentsheet.flowcontroller.DefaultFlowControllerInitializer$setLastSavedPaymentMethod$1 r0 = new com.stripe.android.paymentsheet.flowcontroller.DefaultFlowControllerInitializer$setLastSavedPaymentMethod$1
            r0.<init>(r4, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 != r3) goto L_0x0035
            boolean r6 = r0.Z$0
            java.lang.Object r5 = r0.L$1
            r7 = r5
            java.util.List r7 = (java.util.List) r7
            java.lang.Object r5 = r0.L$0
            com.stripe.android.paymentsheet.PrefsRepository r5 = (com.stripe.android.paymentsheet.PrefsRepository) r5
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x004f
        L_0x0035:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r8)
            r0.L$0 = r5
            r0.L$1 = r7
            r0.Z$0 = r6
            r0.label = r3
            java.lang.Object r8 = r5.getSavedSelection(r6, r0)
            if (r8 != r1) goto L_0x004f
            return r1
        L_0x004f:
            com.stripe.android.paymentsheet.model.SavedSelection$None r0 = com.stripe.android.paymentsheet.model.SavedSelection.None.INSTANCE
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r0)
            if (r8 == 0) goto L_0x007f
            r8 = r7
            java.util.Collection r8 = (java.util.Collection) r8
            boolean r8 = r8.isEmpty()
            r8 = r8 ^ r3
            if (r8 == 0) goto L_0x006f
            com.stripe.android.paymentsheet.model.PaymentSelection$Saved r6 = new com.stripe.android.paymentsheet.model.PaymentSelection$Saved
            java.lang.Object r7 = kotlin.collections.CollectionsKt.first(r7)
            com.stripe.android.model.PaymentMethod r7 = (com.stripe.android.model.PaymentMethod) r7
            r6.<init>(r7)
            com.stripe.android.paymentsheet.model.PaymentSelection r6 = (com.stripe.android.paymentsheet.model.PaymentSelection) r6
            goto L_0x0079
        L_0x006f:
            if (r6 == 0) goto L_0x0076
            com.stripe.android.paymentsheet.model.PaymentSelection$GooglePay r6 = com.stripe.android.paymentsheet.model.PaymentSelection.GooglePay.INSTANCE
            com.stripe.android.paymentsheet.model.PaymentSelection r6 = (com.stripe.android.paymentsheet.model.PaymentSelection) r6
            goto L_0x0079
        L_0x0076:
            r6 = 0
            com.stripe.android.paymentsheet.model.PaymentSelection r6 = (com.stripe.android.paymentsheet.model.PaymentSelection) r6
        L_0x0079:
            if (r6 != 0) goto L_0x007c
            goto L_0x007f
        L_0x007c:
            r5.savePaymentSelection(r6)
        L_0x007f:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.paymentsheet.flowcontroller.DefaultFlowControllerInitializer.setLastSavedPaymentMethod(com.stripe.android.paymentsheet.PrefsRepository, boolean, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object retrieveStripeIntent(com.stripe.android.paymentsheet.model.ClientSecret r6, kotlin.coroutines.Continuation<? super com.stripe.android.model.StripeIntent> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.stripe.android.paymentsheet.flowcontroller.DefaultFlowControllerInitializer$retrieveStripeIntent$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.stripe.android.paymentsheet.flowcontroller.DefaultFlowControllerInitializer$retrieveStripeIntent$1 r0 = (com.stripe.android.paymentsheet.flowcontroller.DefaultFlowControllerInitializer$retrieveStripeIntent$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.stripe.android.paymentsheet.flowcontroller.DefaultFlowControllerInitializer$retrieveStripeIntent$1 r0 = new com.stripe.android.paymentsheet.flowcontroller.DefaultFlowControllerInitializer$retrieveStripeIntent$1
            r0.<init>(r5, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r6 = r0.L$0
            com.stripe.android.paymentsheet.model.StripeIntentValidator r6 = (com.stripe.android.paymentsheet.model.StripeIntentValidator) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x004b
        L_0x002e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r7)
            com.stripe.android.paymentsheet.model.StripeIntentValidator r7 = r5.stripeIntentValidator
            com.stripe.android.paymentsheet.repositories.StripeIntentRepository r2 = r5.stripeIntentRepository
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r6 = r2.get(r6, r0)
            if (r6 != r1) goto L_0x0048
            return r1
        L_0x0048:
            r4 = r7
            r7 = r6
            r6 = r4
        L_0x004b:
            com.stripe.android.model.StripeIntent r7 = (com.stripe.android.model.StripeIntent) r7
            com.stripe.android.model.StripeIntent r6 = r6.requireValid(r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.paymentsheet.flowcontroller.DefaultFlowControllerInitializer.retrieveStripeIntent(com.stripe.android.paymentsheet.model.ClientSecret, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
