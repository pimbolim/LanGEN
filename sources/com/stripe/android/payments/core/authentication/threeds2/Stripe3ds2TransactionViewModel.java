package com.stripe.android.payments.core.authentication.threeds2;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.stripe.android.StripePaymentController;
import com.stripe.android.auth.PaymentBrowserAuthContract;
import com.stripe.android.core.exception.StripeException;
import com.stripe.android.core.injection.IOContext;
import com.stripe.android.core.networking.AnalyticsRequestExecutor;
import com.stripe.android.core.networking.ApiRequest;
import com.stripe.android.model.Source;
import com.stripe.android.model.Stripe3ds2AuthResult;
import com.stripe.android.model.Stripe3ds2Fingerprint;
import com.stripe.android.model.Token;
import com.stripe.android.networking.PaymentAnalyticsEvent;
import com.stripe.android.networking.PaymentAnalyticsRequestFactory;
import com.stripe.android.networking.StripeRepository;
import com.stripe.android.payments.PaymentFlowResult;
import com.stripe.android.payments.core.authentication.threeds2.NextStep;
import com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionContract;
import com.stripe.android.stripe3ds2.init.ui.StripeToolbarCustomization;
import com.stripe.android.stripe3ds2.service.StripeThreeDs2Service;
import com.stripe.android.stripe3ds2.transaction.ChallengeResult;
import com.stripe.android.stripe3ds2.transaction.InitChallengeArgs;
import com.stripe.android.stripe3ds2.transaction.InitChallengeRepository;
import com.stripe.android.stripe3ds2.transaction.InitChallengeResult;
import com.stripe.android.stripe3ds2.transaction.MessageVersionRegistry;
import com.stripe.android.stripe3ds2.transaction.Transaction;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 G2\u00020\u0001:\u0001GBc\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0001\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0001\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u0018J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H@ø\u0001\u0000¢\u0006\u0002\u0010\"J\u0019\u0010#\u001a\u00020$2\u0006\u0010\u0002\u001a\u00020%H@ø\u0001\u0000¢\u0006\u0002\u0010&J\u0010\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020)H\u0002J3\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020)2\u0006\u00100\u001a\u000201H@ø\u0001\u0000¢\u0006\u0004\b2\u00103J1\u00104\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010 \u001a\u00020!2\u0006\u00105\u001a\u0002062\u0006\u00100\u001a\u000201H@ø\u0001\u0000¢\u0006\u0002\u00107J\u0019\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H@ø\u0001\u0000¢\u0006\u0002\u0010<J\u0011\u0010=\u001a\u00020\u001fH@ø\u0001\u0000¢\u0006\u0002\u0010>J3\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020B2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020)2\u0006\u0010C\u001a\u000201H@ø\u0001\u0000¢\u0006\u0004\bD\u0010EJ\b\u0010F\u001a\u00020\u001fH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006H"}, d2 = {"Lcom/stripe/android/payments/core/authentication/threeds2/Stripe3ds2TransactionViewModel;", "Landroidx/lifecycle/ViewModel;", "args", "Lcom/stripe/android/payments/core/authentication/threeds2/Stripe3ds2TransactionContract$Args;", "stripeRepository", "Lcom/stripe/android/networking/StripeRepository;", "analyticsRequestExecutor", "Lcom/stripe/android/core/networking/AnalyticsRequestExecutor;", "paymentAnalyticsRequestFactory", "Lcom/stripe/android/networking/PaymentAnalyticsRequestFactory;", "threeDs2Service", "Lcom/stripe/android/stripe3ds2/service/StripeThreeDs2Service;", "messageVersionRegistry", "Lcom/stripe/android/stripe3ds2/transaction/MessageVersionRegistry;", "challengeResultProcessor", "Lcom/stripe/android/payments/core/authentication/threeds2/Stripe3ds2ChallengeResultProcessor;", "initChallengeRepository", "Lcom/stripe/android/stripe3ds2/transaction/InitChallengeRepository;", "workContext", "Lkotlin/coroutines/CoroutineContext;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "isInstantApp", "", "(Lcom/stripe/android/payments/core/authentication/threeds2/Stripe3ds2TransactionContract$Args;Lcom/stripe/android/networking/StripeRepository;Lcom/stripe/android/core/networking/AnalyticsRequestExecutor;Lcom/stripe/android/networking/PaymentAnalyticsRequestFactory;Lcom/stripe/android/stripe3ds2/service/StripeThreeDs2Service;Lcom/stripe/android/stripe3ds2/transaction/MessageVersionRegistry;Lcom/stripe/android/payments/core/authentication/threeds2/Stripe3ds2ChallengeResultProcessor;Lcom/stripe/android/stripe3ds2/transaction/InitChallengeRepository;Lkotlin/coroutines/CoroutineContext;Landroidx/lifecycle/SavedStateHandle;Z)V", "hasCompleted", "getHasCompleted", "()Z", "setHasCompleted", "(Z)V", "begin3ds2Auth", "Lcom/stripe/android/payments/core/authentication/threeds2/NextStep;", "stripe3ds2Fingerprint", "Lcom/stripe/android/model/Stripe3ds2Fingerprint;", "(Lcom/stripe/android/model/Stripe3ds2Fingerprint;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initChallenge", "Lcom/stripe/android/stripe3ds2/transaction/InitChallengeResult;", "Lcom/stripe/android/stripe3ds2/transaction/InitChallengeArgs;", "(Lcom/stripe/android/stripe3ds2/transaction/InitChallengeArgs;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "on3ds2AuthFallback", "fallbackRedirectUrl", "", "on3ds2AuthSuccess", "result", "Lcom/stripe/android/model/Stripe3ds2AuthResult;", "transaction", "Lcom/stripe/android/stripe3ds2/transaction/Transaction;", "sourceId", "timeout", "", "on3ds2AuthSuccess$payments_core_release", "(Lcom/stripe/android/model/Stripe3ds2AuthResult;Lcom/stripe/android/stripe3ds2/transaction/Transaction;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "perform3ds2AuthenticationRequest", "requestOptions", "Lcom/stripe/android/core/networking/ApiRequest$Options;", "(Lcom/stripe/android/stripe3ds2/transaction/Transaction;Lcom/stripe/android/model/Stripe3ds2Fingerprint;Lcom/stripe/android/core/networking/ApiRequest$Options;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processChallengeResult", "Lcom/stripe/android/payments/PaymentFlowResult$Unvalidated;", "challengeResult", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeResult;", "(Lcom/stripe/android/stripe3ds2/transaction/ChallengeResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "start3ds2Flow", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startChallengeFlow", "Lcom/stripe/android/payments/core/authentication/threeds2/NextStep$StartChallenge;", "ares", "Lcom/stripe/android/model/Stripe3ds2AuthResult$Ares;", "maxTimeout", "startChallengeFlow$payments_core_release", "(Lcom/stripe/android/model/Stripe3ds2AuthResult$Ares;Lcom/stripe/android/stripe3ds2/transaction/Transaction;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startFrictionlessFlow", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Stripe3ds2TransactionViewModel.kt */
public final class Stripe3ds2TransactionViewModel extends ViewModel {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final String KEY_HAS_COMPLETED = "key_next_step";
    private final AnalyticsRequestExecutor analyticsRequestExecutor;
    /* access modifiers changed from: private */
    public final Stripe3ds2TransactionContract.Args args;
    private final Stripe3ds2ChallengeResultProcessor challengeResultProcessor;
    private boolean hasCompleted;
    private final InitChallengeRepository initChallengeRepository;
    private final boolean isInstantApp;
    private final MessageVersionRegistry messageVersionRegistry;
    private final PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory;
    private final SavedStateHandle savedStateHandle;
    /* access modifiers changed from: private */
    public final StripeRepository stripeRepository;
    private final StripeThreeDs2Service threeDs2Service;
    private final CoroutineContext workContext;

    @Inject
    public Stripe3ds2TransactionViewModel(Stripe3ds2TransactionContract.Args args2, StripeRepository stripeRepository2, AnalyticsRequestExecutor analyticsRequestExecutor2, PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory2, StripeThreeDs2Service stripeThreeDs2Service, MessageVersionRegistry messageVersionRegistry2, Stripe3ds2ChallengeResultProcessor stripe3ds2ChallengeResultProcessor, InitChallengeRepository initChallengeRepository2, @IOContext CoroutineContext coroutineContext, SavedStateHandle savedStateHandle2, @Named("isInstantApp") boolean z) {
        Intrinsics.checkNotNullParameter(args2, "args");
        Intrinsics.checkNotNullParameter(stripeRepository2, "stripeRepository");
        Intrinsics.checkNotNullParameter(analyticsRequestExecutor2, "analyticsRequestExecutor");
        Intrinsics.checkNotNullParameter(paymentAnalyticsRequestFactory2, "paymentAnalyticsRequestFactory");
        Intrinsics.checkNotNullParameter(stripeThreeDs2Service, "threeDs2Service");
        Intrinsics.checkNotNullParameter(messageVersionRegistry2, "messageVersionRegistry");
        Intrinsics.checkNotNullParameter(stripe3ds2ChallengeResultProcessor, "challengeResultProcessor");
        Intrinsics.checkNotNullParameter(initChallengeRepository2, "initChallengeRepository");
        Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
        Intrinsics.checkNotNullParameter(savedStateHandle2, "savedStateHandle");
        this.args = args2;
        this.stripeRepository = stripeRepository2;
        this.analyticsRequestExecutor = analyticsRequestExecutor2;
        this.paymentAnalyticsRequestFactory = paymentAnalyticsRequestFactory2;
        this.threeDs2Service = stripeThreeDs2Service;
        this.messageVersionRegistry = messageVersionRegistry2;
        this.challengeResultProcessor = stripe3ds2ChallengeResultProcessor;
        this.initChallengeRepository = initChallengeRepository2;
        this.workContext = coroutineContext;
        this.savedStateHandle = savedStateHandle2;
        this.isInstantApp = z;
        this.hasCompleted = savedStateHandle2.contains(KEY_HAS_COMPLETED);
    }

    public final boolean getHasCompleted() {
        return this.hasCompleted;
    }

    public final void setHasCompleted(boolean z) {
        this.hasCompleted = z;
    }

    public final Object processChallengeResult(ChallengeResult challengeResult, Continuation<? super PaymentFlowResult.Unvalidated> continuation) {
        return this.challengeResultProcessor.process(challengeResult, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object start3ds2Flow(kotlin.coroutines.Continuation<? super com.stripe.android.payments.core.authentication.threeds2.NextStep> r15) {
        /*
            r14 = this;
            boolean r0 = r15 instanceof com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionViewModel$start3ds2Flow$1
            if (r0 == 0) goto L_0x0014
            r0 = r15
            com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionViewModel$start3ds2Flow$1 r0 = (com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionViewModel$start3ds2Flow$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L_0x0019
        L_0x0014:
            com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionViewModel$start3ds2Flow$1 r0 = new com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionViewModel$start3ds2Flow$1
            r0.<init>(r14, r15)
        L_0x0019:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0038
            if (r2 != r3) goto L_0x0030
            java.lang.Object r0 = r0.L$0
            com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionViewModel r0 = (com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionViewModel) r0
            kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ all -> 0x002e }
            goto L_0x006b
        L_0x002e:
            r15 = move-exception
            goto L_0x0074
        L_0x0030:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r15)
            com.stripe.android.core.networking.AnalyticsRequestExecutor r15 = r14.analyticsRequestExecutor
            com.stripe.android.networking.PaymentAnalyticsRequestFactory r4 = r14.paymentAnalyticsRequestFactory
            com.stripe.android.networking.PaymentAnalyticsEvent r5 = com.stripe.android.networking.PaymentAnalyticsEvent.Auth3ds2Fingerprint
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 30
            r11 = 0
            com.stripe.android.core.networking.AnalyticsRequest r2 = com.stripe.android.networking.PaymentAnalyticsRequestFactory.createRequest$payments_core_release$default(r4, r5, r6, r7, r8, r9, r10, r11)
            r15.executeAsync(r2)
            kotlin.Result$Companion r15 = kotlin.Result.Companion     // Catch:{ all -> 0x0072 }
            r15 = r14
            com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionViewModel r15 = (com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionViewModel) r15     // Catch:{ all -> 0x0072 }
            com.stripe.android.model.Stripe3ds2Fingerprint r2 = new com.stripe.android.model.Stripe3ds2Fingerprint     // Catch:{ all -> 0x0072 }
            com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionContract$Args r4 = r15.args     // Catch:{ all -> 0x0072 }
            com.stripe.android.model.StripeIntent$NextActionData$SdkData$Use3DS2 r4 = r4.getNextActionData()     // Catch:{ all -> 0x0072 }
            r2.<init>(r4)     // Catch:{ all -> 0x0072 }
            r0.L$0 = r14     // Catch:{ all -> 0x0072 }
            r0.label = r3     // Catch:{ all -> 0x0072 }
            java.lang.Object r15 = r15.begin3ds2Auth(r2, r0)     // Catch:{ all -> 0x0072 }
            if (r15 != r1) goto L_0x006a
            return r1
        L_0x006a:
            r0 = r14
        L_0x006b:
            com.stripe.android.payments.core.authentication.threeds2.NextStep r15 = (com.stripe.android.payments.core.authentication.threeds2.NextStep) r15     // Catch:{ all -> 0x002e }
            java.lang.Object r15 = kotlin.Result.m4709constructorimpl(r15)     // Catch:{ all -> 0x002e }
            goto L_0x007e
        L_0x0072:
            r15 = move-exception
            r0 = r14
        L_0x0074:
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r15 = kotlin.ResultKt.createFailure(r15)
            java.lang.Object r15 = kotlin.Result.m4709constructorimpl(r15)
        L_0x007e:
            java.lang.Throwable r1 = kotlin.Result.m4712exceptionOrNullimpl(r15)
            if (r1 != 0) goto L_0x0085
            goto L_0x00b3
        L_0x0085:
            com.stripe.android.core.networking.AnalyticsRequestExecutor r15 = r0.analyticsRequestExecutor
            com.stripe.android.networking.PaymentAnalyticsRequestFactory r4 = r0.paymentAnalyticsRequestFactory
            com.stripe.android.networking.PaymentAnalyticsEvent r5 = com.stripe.android.networking.PaymentAnalyticsEvent.Auth3ds2RequestParamsFailed
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 30
            r11 = 0
            com.stripe.android.core.networking.AnalyticsRequest r2 = com.stripe.android.networking.PaymentAnalyticsRequestFactory.createRequest$payments_core_release$default(r4, r5, r6, r7, r8, r9, r10, r11)
            r15.executeAsync(r2)
            com.stripe.android.payments.core.authentication.threeds2.NextStep$Complete r15 = new com.stripe.android.payments.core.authentication.threeds2.NextStep$Complete
            com.stripe.android.payments.PaymentFlowResult$Unvalidated r2 = new com.stripe.android.payments.PaymentFlowResult$Unvalidated
            r5 = 0
            r6 = 0
            com.stripe.android.core.exception.StripeException$Companion r4 = com.stripe.android.core.exception.StripeException.Companion
            com.stripe.android.core.exception.StripeException r7 = r4.create(r1)
            r8 = 0
            r10 = 0
            r12 = 123(0x7b, float:1.72E-43)
            r13 = 0
            r4 = r2
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13)
            r15.<init>(r2)
            com.stripe.android.payments.core.authentication.threeds2.NextStep r15 = (com.stripe.android.payments.core.authentication.threeds2.NextStep) r15
        L_0x00b3:
            r1 = r15
            com.stripe.android.payments.core.authentication.threeds2.NextStep r1 = (com.stripe.android.payments.core.authentication.threeds2.NextStep) r1
            androidx.lifecycle.SavedStateHandle r1 = r0.savedStateHandle
            java.lang.Boolean r2 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            java.lang.String r4 = "key_next_step"
            r1.set(r4, r2)
            r0.setHasCompleted(r3)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionViewModel.start3ds2Flow(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object begin3ds2Auth(com.stripe.android.model.Stripe3ds2Fingerprint r22, kotlin.coroutines.Continuation<? super com.stripe.android.payments.core.authentication.threeds2.NextStep> r23) {
        /*
            r21 = this;
            r1 = r21
            r0 = r23
            boolean r2 = r0 instanceof com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionViewModel$begin3ds2Auth$1
            if (r2 == 0) goto L_0x0018
            r2 = r0
            com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionViewModel$begin3ds2Auth$1 r2 = (com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionViewModel$begin3ds2Auth$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r0 = r2.label
            int r0 = r0 - r4
            r2.label = r0
            goto L_0x001d
        L_0x0018:
            com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionViewModel$begin3ds2Auth$1 r2 = new com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionViewModel$begin3ds2Auth$1
            r2.<init>(r1, r0)
        L_0x001d:
            java.lang.Object r0 = r2.result
            java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r2.label
            r10 = 2
            r4 = 1
            if (r3 == 0) goto L_0x0052
            if (r3 == r4) goto L_0x003a
            if (r3 != r10) goto L_0x0032
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x010f
        L_0x0032:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x003a:
            int r3 = r2.I$0
            java.lang.Object r4 = r2.L$2
            com.stripe.android.stripe3ds2.transaction.Transaction r4 = (com.stripe.android.stripe3ds2.transaction.Transaction) r4
            java.lang.Object r5 = r2.L$1
            com.stripe.android.model.Stripe3ds2Fingerprint r5 = (com.stripe.android.model.Stripe3ds2Fingerprint) r5
            java.lang.Object r6 = r2.L$0
            com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionViewModel r6 = (com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionViewModel) r6
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x004e }
            r13 = r5
            goto L_0x00d3
        L_0x004e:
            r0 = move-exception
            r13 = r5
            goto L_0x00e4
        L_0x0052:
            kotlin.ResultKt.throwOnFailure(r0)
            com.stripe.android.stripe3ds2.service.StripeThreeDs2Service r11 = r1.threeDs2Service
            com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionContract$Args r0 = r1.args
            com.stripe.android.stripe3ds2.transaction.SdkTransactionId r12 = r0.getSdkTransactionId()
            com.stripe.android.model.Stripe3ds2Fingerprint$DirectoryServerEncryption r0 = r22.getDirectoryServerEncryption()
            java.lang.String r13 = r0.getDirectoryServerId()
            com.stripe.android.stripe3ds2.transaction.MessageVersionRegistry r0 = r1.messageVersionRegistry
            java.lang.String r14 = r0.getCurrent()
            com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionContract$Args r0 = r1.args
            com.stripe.android.model.StripeIntent r0 = r0.getStripeIntent()
            boolean r15 = r0.isLiveMode()
            java.lang.String r16 = r22.getDirectoryServerName()
            com.stripe.android.model.Stripe3ds2Fingerprint$DirectoryServerEncryption r0 = r22.getDirectoryServerEncryption()
            java.util.List r17 = r0.getRootCerts()
            com.stripe.android.model.Stripe3ds2Fingerprint$DirectoryServerEncryption r0 = r22.getDirectoryServerEncryption()
            java.security.PublicKey r18 = r0.getDirectoryServerPublicKey()
            com.stripe.android.model.Stripe3ds2Fingerprint$DirectoryServerEncryption r0 = r22.getDirectoryServerEncryption()
            java.lang.String r19 = r0.getKeyId()
            com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionContract$Args r0 = r1.args
            com.stripe.android.PaymentAuthConfig$Stripe3ds2Config r0 = r0.getConfig()
            com.stripe.android.PaymentAuthConfig$Stripe3ds2UiCustomization r0 = r0.getUiCustomization$payments_core_release()
            com.stripe.android.stripe3ds2.init.ui.StripeUiCustomization r20 = r0.getUiCustomization()
            com.stripe.android.stripe3ds2.transaction.Transaction r11 = r11.createTransaction(r12, r13, r14, r15, r16, r17, r18, r19, r20)
            com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionContract$Args r0 = r1.args
            com.stripe.android.PaymentAuthConfig$Stripe3ds2Config r0 = r0.getConfig()
            int r12 = r0.getTimeout$payments_core_release()
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x00de }
            r3 = r1
            com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionViewModel r3 = (com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionViewModel) r3     // Catch:{ all -> 0x00de }
            com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionContract$Args r0 = r3.args     // Catch:{ all -> 0x00de }
            com.stripe.android.core.networking.ApiRequest$Options r6 = r0.getRequestOptions()     // Catch:{ all -> 0x00de }
            r2.L$0 = r1     // Catch:{ all -> 0x00de }
            r13 = r22
            r2.L$1 = r13     // Catch:{ all -> 0x00dc }
            r2.L$2 = r11     // Catch:{ all -> 0x00dc }
            r2.I$0 = r12     // Catch:{ all -> 0x00dc }
            r2.label = r4     // Catch:{ all -> 0x00dc }
            r4 = r11
            r5 = r22
            r7 = r12
            r8 = r2
            java.lang.Object r0 = r3.perform3ds2AuthenticationRequest(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x00dc }
            if (r0 != r9) goto L_0x00d0
            return r9
        L_0x00d0:
            r6 = r1
            r4 = r11
            r3 = r12
        L_0x00d3:
            com.stripe.android.model.Stripe3ds2AuthResult r0 = (com.stripe.android.model.Stripe3ds2AuthResult) r0     // Catch:{ all -> 0x00da }
            java.lang.Object r0 = kotlin.Result.m4709constructorimpl(r0)     // Catch:{ all -> 0x00da }
            goto L_0x00ee
        L_0x00da:
            r0 = move-exception
            goto L_0x00e4
        L_0x00dc:
            r0 = move-exception
            goto L_0x00e1
        L_0x00de:
            r0 = move-exception
            r13 = r22
        L_0x00e1:
            r6 = r1
            r4 = r11
            r3 = r12
        L_0x00e4:
            kotlin.Result$Companion r5 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m4709constructorimpl(r0)
        L_0x00ee:
            r7 = r3
            r5 = r4
            r3 = r6
            java.lang.Throwable r4 = kotlin.Result.m4712exceptionOrNullimpl(r0)
            if (r4 != 0) goto L_0x0112
            r4 = r0
            com.stripe.android.model.Stripe3ds2AuthResult r4 = (com.stripe.android.model.Stripe3ds2AuthResult) r4
            java.lang.String r6 = r13.getSource()
            r0 = 0
            r2.L$0 = r0
            r2.L$1 = r0
            r2.L$2 = r0
            r2.label = r10
            r8 = r2
            java.lang.Object r0 = r3.on3ds2AuthSuccess$payments_core_release(r4, r5, r6, r7, r8)
            if (r0 != r9) goto L_0x010f
            return r9
        L_0x010f:
            com.stripe.android.payments.core.authentication.threeds2.NextStep r0 = (com.stripe.android.payments.core.authentication.threeds2.NextStep) r0
            goto L_0x012e
        L_0x0112:
            com.stripe.android.payments.core.authentication.threeds2.NextStep$Complete r0 = new com.stripe.android.payments.core.authentication.threeds2.NextStep$Complete
            com.stripe.android.payments.PaymentFlowResult$Unvalidated r2 = new com.stripe.android.payments.PaymentFlowResult$Unvalidated
            r6 = 0
            r7 = 0
            com.stripe.android.core.exception.StripeException$Companion r3 = com.stripe.android.core.exception.StripeException.Companion
            com.stripe.android.core.exception.StripeException r8 = r3.create(r4)
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 123(0x7b, float:1.72E-43)
            r14 = 0
            r5 = r2
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14)
            r0.<init>(r2)
            com.stripe.android.payments.core.authentication.threeds2.NextStep r0 = (com.stripe.android.payments.core.authentication.threeds2.NextStep) r0
        L_0x012e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionViewModel.begin3ds2Auth(com.stripe.android.model.Stripe3ds2Fingerprint, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Object perform3ds2AuthenticationRequest(Transaction transaction, Stripe3ds2Fingerprint stripe3ds2Fingerprint, ApiRequest.Options options, int i, Continuation<? super Stripe3ds2AuthResult> continuation) {
        return BuildersKt.withContext(this.workContext, new Stripe3ds2TransactionViewModel$perform3ds2AuthenticationRequest$2(transaction, stripe3ds2Fingerprint, i, this, options, (Continuation<? super Stripe3ds2TransactionViewModel$perform3ds2AuthenticationRequest$2>) null), continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object on3ds2AuthSuccess$payments_core_release(com.stripe.android.model.Stripe3ds2AuthResult r11, com.stripe.android.stripe3ds2.transaction.Transaction r12, java.lang.String r13, int r14, kotlin.coroutines.Continuation<? super com.stripe.android.payments.core.authentication.threeds2.NextStep> r15) {
        /*
            r10 = this;
            boolean r0 = r15 instanceof com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionViewModel$on3ds2AuthSuccess$1
            if (r0 == 0) goto L_0x0014
            r0 = r15
            com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionViewModel$on3ds2AuthSuccess$1 r0 = (com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionViewModel$on3ds2AuthSuccess$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L_0x0019
        L_0x0014:
            com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionViewModel$on3ds2AuthSuccess$1 r0 = new com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionViewModel$on3ds2AuthSuccess$1
            r0.<init>(r10, r15)
        L_0x0019:
            r6 = r0
            java.lang.Object r15 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L_0x0033
            if (r1 != r2) goto L_0x002b
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x0050
        L_0x002b:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0033:
            kotlin.ResultKt.throwOnFailure(r15)
            com.stripe.android.model.Stripe3ds2AuthResult$Ares r15 = r11.getAres()
            if (r15 == 0) goto L_0x005a
            boolean r11 = r15.isChallenge()
            if (r11 == 0) goto L_0x0054
            r6.label = r2
            r1 = r10
            r2 = r15
            r3 = r12
            r4 = r13
            r5 = r14
            java.lang.Object r15 = r1.startChallengeFlow$payments_core_release(r2, r3, r4, r5, r6)
            if (r15 != r0) goto L_0x0050
            return r0
        L_0x0050:
            com.stripe.android.payments.core.authentication.threeds2.NextStep r15 = (com.stripe.android.payments.core.authentication.threeds2.NextStep) r15
            goto L_0x00ef
        L_0x0054:
            com.stripe.android.payments.core.authentication.threeds2.NextStep r15 = r10.startFrictionlessFlow()
            goto L_0x00ef
        L_0x005a:
            java.lang.String r12 = r11.getFallbackRedirectUrl()
            if (r12 == 0) goto L_0x006a
            java.lang.String r11 = r11.getFallbackRedirectUrl()
            com.stripe.android.payments.core.authentication.threeds2.NextStep r15 = r10.on3ds2AuthFallback(r11)
            goto L_0x00ef
        L_0x006a:
            com.stripe.android.model.Stripe3ds2AuthResult$ThreeDS2Error r11 = r11.getError()
            java.lang.String r12 = "Invalid 3DS2 authentication response"
            if (r11 != 0) goto L_0x0073
            goto L_0x00c5
        L_0x0073:
            r13 = 4
            java.lang.String[] r13 = new java.lang.String[r13]
            r14 = 0
            java.lang.String r15 = r11.getErrorCode()
            java.lang.String r0 = "Code: "
            java.lang.String r15 = kotlin.jvm.internal.Intrinsics.stringPlus(r0, r15)
            r13[r14] = r15
            java.lang.String r14 = r11.getErrorDetail()
            java.lang.String r15 = "Detail: "
            java.lang.String r14 = kotlin.jvm.internal.Intrinsics.stringPlus(r15, r14)
            r13[r2] = r14
            r14 = 2
            java.lang.String r15 = r11.getErrorDescription()
            java.lang.String r0 = "Description: "
            java.lang.String r15 = kotlin.jvm.internal.Intrinsics.stringPlus(r0, r15)
            r13[r14] = r15
            r14 = 3
            java.lang.String r11 = r11.getErrorComponent()
            java.lang.String r15 = "Component: "
            java.lang.String r11 = kotlin.jvm.internal.Intrinsics.stringPlus(r15, r11)
            r13[r14] = r11
            java.util.List r11 = kotlin.collections.CollectionsKt.listOf(r13)
            r0 = r11
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.lang.String r11 = ", "
            r1 = r11
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 62
            r8 = 0
            java.lang.String r11 = kotlin.collections.CollectionsKt.joinToString$default(r0, r1, r2, r3, r4, r5, r6, r7, r8)
            if (r11 != 0) goto L_0x00c4
            goto L_0x00c5
        L_0x00c4:
            r12 = r11
        L_0x00c5:
            com.stripe.android.payments.core.authentication.threeds2.NextStep$Complete r11 = new com.stripe.android.payments.core.authentication.threeds2.NextStep$Complete
            com.stripe.android.payments.PaymentFlowResult$Unvalidated r13 = new com.stripe.android.payments.PaymentFlowResult$Unvalidated
            r1 = 0
            r2 = 0
            com.stripe.android.core.exception.StripeException$Companion r14 = com.stripe.android.core.exception.StripeException.Companion
            java.lang.RuntimeException r15 = new java.lang.RuntimeException
            java.lang.String r0 = "Error encountered during 3DS2 authentication request. "
            java.lang.String r12 = kotlin.jvm.internal.Intrinsics.stringPlus(r0, r12)
            r15.<init>(r12)
            java.lang.Throwable r15 = (java.lang.Throwable) r15
            com.stripe.android.core.exception.StripeException r3 = r14.create(r15)
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 123(0x7b, float:1.72E-43)
            r9 = 0
            r0 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r11.<init>(r13)
            r15 = r11
            com.stripe.android.payments.core.authentication.threeds2.NextStep r15 = (com.stripe.android.payments.core.authentication.threeds2.NextStep) r15
        L_0x00ef:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionViewModel.on3ds2AuthSuccess$payments_core_release(com.stripe.android.model.Stripe3ds2AuthResult, com.stripe.android.stripe3ds2.transaction.Transaction, java.lang.String, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final NextStep on3ds2AuthFallback(String str) {
        String str2;
        this.analyticsRequestExecutor.executeAsync(PaymentAnalyticsRequestFactory.createRequest$payments_core_release$default(this.paymentAnalyticsRequestFactory, PaymentAnalyticsEvent.Auth3ds2Fallback, (Set) null, (String) null, (Token.Type) null, (PaymentAnalyticsRequestFactory.ThreeDS2UiType) null, 30, (Object) null));
        String id = this.args.getStripeIntent().getId();
        String str3 = id == null ? "" : id;
        int requestCode$payments_core_release = StripePaymentController.Companion.getRequestCode$payments_core_release(this.args.getStripeIntent());
        String clientSecret = this.args.getStripeIntent().getClientSecret();
        if (clientSecret == null) {
            str2 = "";
        } else {
            str2 = clientSecret;
        }
        PaymentBrowserAuthContract.Args args2 = r2;
        PaymentBrowserAuthContract.Args args3 = new PaymentBrowserAuthContract.Args(str3, requestCode$payments_core_release, str2, str, (String) null, this.args.getEnableLogging(), (StripeToolbarCustomization) null, this.args.getRequestOptions().getStripeAccount(), true, false, (Integer) null, this.args.getPublishableKey(), this.isInstantApp, 1600, (DefaultConstructorMarker) null);
        return new NextStep.StartFallback(args2);
    }

    private final NextStep startFrictionlessFlow() {
        this.analyticsRequestExecutor.executeAsync(PaymentAnalyticsRequestFactory.createRequest$payments_core_release$default(this.paymentAnalyticsRequestFactory, PaymentAnalyticsEvent.Auth3ds2Frictionless, (Set) null, (String) null, (Token.Type) null, (PaymentAnalyticsRequestFactory.ThreeDS2UiType) null, 30, (Object) null));
        return new NextStep.Complete(new PaymentFlowResult.Unvalidated(this.args.getStripeIntent().getClientSecret(), 0, (StripeException) null, false, (String) null, (Source) null, this.args.getRequestOptions().getStripeAccount(), 62, (DefaultConstructorMarker) null));
    }

    public final Object initChallenge(InitChallengeArgs initChallengeArgs, Continuation<? super InitChallengeResult> continuation) {
        return this.initChallengeRepository.startChallenge(initChallengeArgs, continuation);
    }

    public final Object startChallengeFlow$payments_core_release(Stripe3ds2AuthResult.Ares ares, Transaction transaction, String str, int i, Continuation<? super NextStep.StartChallenge> continuation) {
        return BuildersKt.withContext(this.workContext, new Stripe3ds2TransactionViewModel$startChallengeFlow$2(ares, transaction, i, this, str, (Continuation<? super Stripe3ds2TransactionViewModel$startChallengeFlow$2>) null), continuation);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/payments/core/authentication/threeds2/Stripe3ds2TransactionViewModel$Companion;", "", "()V", "KEY_HAS_COMPLETED", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Stripe3ds2TransactionViewModel.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
