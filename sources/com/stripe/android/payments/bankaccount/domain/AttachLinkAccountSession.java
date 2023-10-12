package com.stripe.android.payments.bankaccount.domain;

import com.stripe.android.networking.StripeRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J:\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\f\u0010\rJ:\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0010\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0011"}, d2 = {"Lcom/stripe/android/payments/bankaccount/domain/AttachLinkAccountSession;", "", "stripeRepository", "Lcom/stripe/android/networking/StripeRepository;", "(Lcom/stripe/android/networking/StripeRepository;)V", "forPaymentIntent", "Lkotlin/Result;", "Lcom/stripe/android/model/PaymentIntent;", "publishableKey", "", "linkedAccountSessionId", "clientSecret", "forPaymentIntent-BWLJW6A", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "forSetupIntent", "Lcom/stripe/android/model/SetupIntent;", "forSetupIntent-BWLJW6A", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AttachLinkAccountSession.kt */
public final class AttachLinkAccountSession {
    private final StripeRepository stripeRepository;

    @Inject
    public AttachLinkAccountSession(StripeRepository stripeRepository2) {
        Intrinsics.checkNotNullParameter(stripeRepository2, "stripeRepository");
        this.stripeRepository = stripeRepository2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x007a A[SYNTHETIC, Splitter:B:23:0x007a] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* renamed from: forPaymentIntent-BWLJW6A  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m4371forPaymentIntentBWLJW6A(java.lang.String r16, java.lang.String r17, java.lang.String r18, kotlin.coroutines.Continuation<? super kotlin.Result<com.stripe.android.model.PaymentIntent>> r19) {
        /*
            r15 = this;
            r1 = r15
            r0 = r19
            boolean r2 = r0 instanceof com.stripe.android.payments.bankaccount.domain.AttachLinkAccountSession$forPaymentIntent$1
            if (r2 == 0) goto L_0x0017
            r2 = r0
            com.stripe.android.payments.bankaccount.domain.AttachLinkAccountSession$forPaymentIntent$1 r2 = (com.stripe.android.payments.bankaccount.domain.AttachLinkAccountSession$forPaymentIntent$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0017
            int r0 = r2.label
            int r0 = r0 - r4
            r2.label = r0
            goto L_0x001c
        L_0x0017:
            com.stripe.android.payments.bankaccount.domain.AttachLinkAccountSession$forPaymentIntent$1 r2 = new com.stripe.android.payments.bankaccount.domain.AttachLinkAccountSession$forPaymentIntent$1
            r2.<init>(r15, r0)
        L_0x001c:
            r8 = r2
            java.lang.Object r0 = r8.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r8.label
            r4 = 1
            if (r3 == 0) goto L_0x0036
            if (r3 != r4) goto L_0x002e
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x0069 }
            goto L_0x0062
        L_0x002e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r0)
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0069 }
            com.stripe.android.networking.StripeRepository r3 = r1.stripeRepository     // Catch:{ all -> 0x0069 }
            com.stripe.android.model.PaymentIntent$ClientSecret r0 = new com.stripe.android.model.PaymentIntent$ClientSecret     // Catch:{ all -> 0x0069 }
            r5 = r18
            r0.<init>(r5)     // Catch:{ all -> 0x0069 }
            java.lang.String r0 = r0.getPaymentIntentId$payments_core_release()     // Catch:{ all -> 0x0069 }
            com.stripe.android.core.networking.ApiRequest$Options r7 = new com.stripe.android.core.networking.ApiRequest$Options     // Catch:{ all -> 0x0069 }
            r11 = 0
            r12 = 0
            r13 = 6
            r14 = 0
            r9 = r7
            r10 = r16
            r9.<init>(r10, r11, r12, r13, r14)     // Catch:{ all -> 0x0069 }
            r8.label = r4     // Catch:{ all -> 0x0069 }
            r4 = r18
            r5 = r0
            r6 = r17
            java.lang.Object r0 = r3.attachLinkAccountSessionToPaymentIntent(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0069 }
            if (r0 != r2) goto L_0x0062
            return r2
        L_0x0062:
            com.stripe.android.model.PaymentIntent r0 = (com.stripe.android.model.PaymentIntent) r0     // Catch:{ all -> 0x0069 }
            java.lang.Object r0 = kotlin.Result.m4709constructorimpl(r0)     // Catch:{ all -> 0x0069 }
            goto L_0x0074
        L_0x0069:
            r0 = move-exception
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m4709constructorimpl(r0)
        L_0x0074:
            boolean r2 = kotlin.Result.m4716isSuccessimpl(r0)
            if (r2 == 0) goto L_0x0094
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch:{ all -> 0x008d }
            com.stripe.android.model.PaymentIntent r0 = (com.stripe.android.model.PaymentIntent) r0     // Catch:{ all -> 0x008d }
            if (r0 == 0) goto L_0x0085
            java.lang.Object r0 = kotlin.Result.m4709constructorimpl(r0)     // Catch:{ all -> 0x008d }
            goto L_0x0098
        L_0x0085:
            java.lang.InternalError r0 = new java.lang.InternalError     // Catch:{ all -> 0x008d }
            java.lang.String r2 = "Error attaching session to PaymentIntent"
            r0.<init>(r2)     // Catch:{ all -> 0x008d }
            throw r0     // Catch:{ all -> 0x008d }
        L_0x008d:
            r0 = move-exception
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
        L_0x0094:
            java.lang.Object r0 = kotlin.Result.m4709constructorimpl(r0)
        L_0x0098:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.payments.bankaccount.domain.AttachLinkAccountSession.m4371forPaymentIntentBWLJW6A(java.lang.String, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x007a A[SYNTHETIC, Splitter:B:23:0x007a] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* renamed from: forSetupIntent-BWLJW6A  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m4372forSetupIntentBWLJW6A(java.lang.String r16, java.lang.String r17, java.lang.String r18, kotlin.coroutines.Continuation<? super kotlin.Result<com.stripe.android.model.SetupIntent>> r19) {
        /*
            r15 = this;
            r1 = r15
            r0 = r19
            boolean r2 = r0 instanceof com.stripe.android.payments.bankaccount.domain.AttachLinkAccountSession$forSetupIntent$1
            if (r2 == 0) goto L_0x0017
            r2 = r0
            com.stripe.android.payments.bankaccount.domain.AttachLinkAccountSession$forSetupIntent$1 r2 = (com.stripe.android.payments.bankaccount.domain.AttachLinkAccountSession$forSetupIntent$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0017
            int r0 = r2.label
            int r0 = r0 - r4
            r2.label = r0
            goto L_0x001c
        L_0x0017:
            com.stripe.android.payments.bankaccount.domain.AttachLinkAccountSession$forSetupIntent$1 r2 = new com.stripe.android.payments.bankaccount.domain.AttachLinkAccountSession$forSetupIntent$1
            r2.<init>(r15, r0)
        L_0x001c:
            r8 = r2
            java.lang.Object r0 = r8.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r8.label
            r4 = 1
            if (r3 == 0) goto L_0x0036
            if (r3 != r4) goto L_0x002e
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x0069 }
            goto L_0x0062
        L_0x002e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r0)
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0069 }
            com.stripe.android.networking.StripeRepository r3 = r1.stripeRepository     // Catch:{ all -> 0x0069 }
            com.stripe.android.model.SetupIntent$ClientSecret r0 = new com.stripe.android.model.SetupIntent$ClientSecret     // Catch:{ all -> 0x0069 }
            r5 = r18
            r0.<init>(r5)     // Catch:{ all -> 0x0069 }
            java.lang.String r0 = r0.getSetupIntentId$payments_core_release()     // Catch:{ all -> 0x0069 }
            com.stripe.android.core.networking.ApiRequest$Options r7 = new com.stripe.android.core.networking.ApiRequest$Options     // Catch:{ all -> 0x0069 }
            r11 = 0
            r12 = 0
            r13 = 6
            r14 = 0
            r9 = r7
            r10 = r16
            r9.<init>(r10, r11, r12, r13, r14)     // Catch:{ all -> 0x0069 }
            r8.label = r4     // Catch:{ all -> 0x0069 }
            r4 = r18
            r5 = r0
            r6 = r17
            java.lang.Object r0 = r3.attachLinkAccountSessionToSetupIntent(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0069 }
            if (r0 != r2) goto L_0x0062
            return r2
        L_0x0062:
            com.stripe.android.model.SetupIntent r0 = (com.stripe.android.model.SetupIntent) r0     // Catch:{ all -> 0x0069 }
            java.lang.Object r0 = kotlin.Result.m4709constructorimpl(r0)     // Catch:{ all -> 0x0069 }
            goto L_0x0074
        L_0x0069:
            r0 = move-exception
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m4709constructorimpl(r0)
        L_0x0074:
            boolean r2 = kotlin.Result.m4716isSuccessimpl(r0)
            if (r2 == 0) goto L_0x0094
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch:{ all -> 0x008d }
            com.stripe.android.model.SetupIntent r0 = (com.stripe.android.model.SetupIntent) r0     // Catch:{ all -> 0x008d }
            if (r0 == 0) goto L_0x0085
            java.lang.Object r0 = kotlin.Result.m4709constructorimpl(r0)     // Catch:{ all -> 0x008d }
            goto L_0x0098
        L_0x0085:
            java.lang.InternalError r0 = new java.lang.InternalError     // Catch:{ all -> 0x008d }
            java.lang.String r2 = "Error attaching session to SetupIntent"
            r0.<init>(r2)     // Catch:{ all -> 0x008d }
            throw r0     // Catch:{ all -> 0x008d }
        L_0x008d:
            r0 = move-exception
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
        L_0x0094:
            java.lang.Object r0 = kotlin.Result.m4709constructorimpl(r0)
        L_0x0098:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.payments.bankaccount.domain.AttachLinkAccountSession.m4372forSetupIntentBWLJW6A(java.lang.String, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
