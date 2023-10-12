package com.stripe.android.payments.bankaccount.domain;

import com.stripe.android.networking.StripeRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JB\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ:\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0011\u0010\u0012JB\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0015\u0010\u000fJ:\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0016\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, d2 = {"Lcom/stripe/android/payments/bankaccount/domain/VerifyWithMicrodeposit;", "", "stripeRepository", "Lcom/stripe/android/networking/StripeRepository;", "(Lcom/stripe/android/networking/StripeRepository;)V", "forPaymentIntent", "Lkotlin/Result;", "Lcom/stripe/android/model/PaymentIntent;", "publishableKey", "", "clientSecret", "firstAmount", "", "secondAmount", "forPaymentIntent-yxL6bBk", "(Ljava/lang/String;Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "descriptorCode", "forPaymentIntent-BWLJW6A", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "forSetupIntent", "Lcom/stripe/android/model/SetupIntent;", "forSetupIntent-yxL6bBk", "forSetupIntent-BWLJW6A", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VerifyWithMicrodeposit.kt */
public final class VerifyWithMicrodeposit {
    private final StripeRepository stripeRepository;

    @Inject
    public VerifyWithMicrodeposit(StripeRepository stripeRepository2) {
        Intrinsics.checkNotNullParameter(stripeRepository2, "stripeRepository");
        this.stripeRepository = stripeRepository2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0070 A[SYNTHETIC, Splitter:B:23:0x0070] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* renamed from: forPaymentIntent-yxL6bBk  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m4376forPaymentIntentyxL6bBk(java.lang.String r16, java.lang.String r17, int r18, int r19, kotlin.coroutines.Continuation<? super kotlin.Result<com.stripe.android.model.PaymentIntent>> r20) {
        /*
            r15 = this;
            r1 = r15
            r0 = r20
            boolean r2 = r0 instanceof com.stripe.android.payments.bankaccount.domain.VerifyWithMicrodeposit$forPaymentIntent$1
            if (r2 == 0) goto L_0x0017
            r2 = r0
            com.stripe.android.payments.bankaccount.domain.VerifyWithMicrodeposit$forPaymentIntent$1 r2 = (com.stripe.android.payments.bankaccount.domain.VerifyWithMicrodeposit$forPaymentIntent$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0017
            int r0 = r2.label
            int r0 = r0 - r4
            r2.label = r0
            goto L_0x001c
        L_0x0017:
            com.stripe.android.payments.bankaccount.domain.VerifyWithMicrodeposit$forPaymentIntent$1 r2 = new com.stripe.android.payments.bankaccount.domain.VerifyWithMicrodeposit$forPaymentIntent$1
            r2.<init>(r15, r0)
        L_0x001c:
            r8 = r2
            java.lang.Object r0 = r8.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r8.label
            r4 = 1
            if (r3 == 0) goto L_0x0036
            if (r3 != r4) goto L_0x002e
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x005f }
            goto L_0x0058
        L_0x002e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r0)
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x005f }
            com.stripe.android.networking.StripeRepository r3 = r1.stripeRepository     // Catch:{ all -> 0x005f }
            com.stripe.android.core.networking.ApiRequest$Options r7 = new com.stripe.android.core.networking.ApiRequest$Options     // Catch:{ all -> 0x005f }
            r11 = 0
            r12 = 0
            r13 = 6
            r14 = 0
            r9 = r7
            r10 = r16
            r9.<init>(r10, r11, r12, r13, r14)     // Catch:{ all -> 0x005f }
            r8.label = r4     // Catch:{ all -> 0x005f }
            r4 = r17
            r5 = r18
            r6 = r19
            java.lang.Object r0 = r3.verifyPaymentIntentWithMicrodeposits(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x005f }
            if (r0 != r2) goto L_0x0058
            return r2
        L_0x0058:
            com.stripe.android.model.PaymentIntent r0 = (com.stripe.android.model.PaymentIntent) r0     // Catch:{ all -> 0x005f }
            java.lang.Object r0 = kotlin.Result.m4709constructorimpl(r0)     // Catch:{ all -> 0x005f }
            goto L_0x006a
        L_0x005f:
            r0 = move-exception
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m4709constructorimpl(r0)
        L_0x006a:
            boolean r2 = kotlin.Result.m4716isSuccessimpl(r0)
            if (r2 == 0) goto L_0x008a
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch:{ all -> 0x0083 }
            com.stripe.android.model.PaymentIntent r0 = (com.stripe.android.model.PaymentIntent) r0     // Catch:{ all -> 0x0083 }
            if (r0 == 0) goto L_0x007b
            java.lang.Object r0 = kotlin.Result.m4709constructorimpl(r0)     // Catch:{ all -> 0x0083 }
            goto L_0x008e
        L_0x007b:
            java.lang.InternalError r0 = new java.lang.InternalError     // Catch:{ all -> 0x0083 }
            java.lang.String r2 = "Error verifying PaymentIntent with microdeposits"
            r0.<init>(r2)     // Catch:{ all -> 0x0083 }
            throw r0     // Catch:{ all -> 0x0083 }
        L_0x0083:
            r0 = move-exception
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
        L_0x008a:
            java.lang.Object r0 = kotlin.Result.m4709constructorimpl(r0)
        L_0x008e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.payments.bankaccount.domain.VerifyWithMicrodeposit.m4376forPaymentIntentyxL6bBk(java.lang.String, java.lang.String, int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0065 A[SYNTHETIC, Splitter:B:23:0x0065] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: forPaymentIntent-BWLJW6A  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m4375forPaymentIntentBWLJW6A(java.lang.String r11, java.lang.String r12, java.lang.String r13, kotlin.coroutines.Continuation<? super kotlin.Result<com.stripe.android.model.PaymentIntent>> r14) {
        /*
            r10 = this;
            boolean r0 = r14 instanceof com.stripe.android.payments.bankaccount.domain.VerifyWithMicrodeposit$forPaymentIntent$4
            if (r0 == 0) goto L_0x0014
            r0 = r14
            com.stripe.android.payments.bankaccount.domain.VerifyWithMicrodeposit$forPaymentIntent$4 r0 = (com.stripe.android.payments.bankaccount.domain.VerifyWithMicrodeposit$forPaymentIntent$4) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L_0x0019
        L_0x0014:
            com.stripe.android.payments.bankaccount.domain.VerifyWithMicrodeposit$forPaymentIntent$4 r0 = new com.stripe.android.payments.bankaccount.domain.VerifyWithMicrodeposit$forPaymentIntent$4
            r0.<init>(r10, r14)
        L_0x0019:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ all -> 0x0054 }
            goto L_0x004d
        L_0x002a:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r14)
            kotlin.Result$Companion r14 = kotlin.Result.Companion     // Catch:{ all -> 0x0054 }
            com.stripe.android.networking.StripeRepository r14 = r10.stripeRepository     // Catch:{ all -> 0x0054 }
            com.stripe.android.core.networking.ApiRequest$Options r2 = new com.stripe.android.core.networking.ApiRequest$Options     // Catch:{ all -> 0x0054 }
            r6 = 0
            r7 = 0
            r8 = 6
            r9 = 0
            r4 = r2
            r5 = r11
            r4.<init>(r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0054 }
            r0.label = r3     // Catch:{ all -> 0x0054 }
            java.lang.Object r14 = r14.verifyPaymentIntentWithMicrodeposits(r12, r13, r2, r0)     // Catch:{ all -> 0x0054 }
            if (r14 != r1) goto L_0x004d
            return r1
        L_0x004d:
            com.stripe.android.model.PaymentIntent r14 = (com.stripe.android.model.PaymentIntent) r14     // Catch:{ all -> 0x0054 }
            java.lang.Object r11 = kotlin.Result.m4709constructorimpl(r14)     // Catch:{ all -> 0x0054 }
            goto L_0x005f
        L_0x0054:
            r11 = move-exception
            kotlin.Result$Companion r12 = kotlin.Result.Companion
            java.lang.Object r11 = kotlin.ResultKt.createFailure(r11)
            java.lang.Object r11 = kotlin.Result.m4709constructorimpl(r11)
        L_0x005f:
            boolean r12 = kotlin.Result.m4716isSuccessimpl(r11)
            if (r12 == 0) goto L_0x007f
            kotlin.Result$Companion r12 = kotlin.Result.Companion     // Catch:{ all -> 0x0078 }
            com.stripe.android.model.PaymentIntent r11 = (com.stripe.android.model.PaymentIntent) r11     // Catch:{ all -> 0x0078 }
            if (r11 == 0) goto L_0x0070
            java.lang.Object r11 = kotlin.Result.m4709constructorimpl(r11)     // Catch:{ all -> 0x0078 }
            goto L_0x0083
        L_0x0070:
            java.lang.InternalError r11 = new java.lang.InternalError     // Catch:{ all -> 0x0078 }
            java.lang.String r12 = "Error verifying PaymentIntent with microdeposits"
            r11.<init>(r12)     // Catch:{ all -> 0x0078 }
            throw r11     // Catch:{ all -> 0x0078 }
        L_0x0078:
            r11 = move-exception
            kotlin.Result$Companion r12 = kotlin.Result.Companion
            java.lang.Object r11 = kotlin.ResultKt.createFailure(r11)
        L_0x007f:
            java.lang.Object r11 = kotlin.Result.m4709constructorimpl(r11)
        L_0x0083:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.payments.bankaccount.domain.VerifyWithMicrodeposit.m4375forPaymentIntentBWLJW6A(java.lang.String, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0070 A[SYNTHETIC, Splitter:B:23:0x0070] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* renamed from: forSetupIntent-yxL6bBk  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m4378forSetupIntentyxL6bBk(java.lang.String r16, java.lang.String r17, int r18, int r19, kotlin.coroutines.Continuation<? super kotlin.Result<com.stripe.android.model.SetupIntent>> r20) {
        /*
            r15 = this;
            r1 = r15
            r0 = r20
            boolean r2 = r0 instanceof com.stripe.android.payments.bankaccount.domain.VerifyWithMicrodeposit$forSetupIntent$1
            if (r2 == 0) goto L_0x0017
            r2 = r0
            com.stripe.android.payments.bankaccount.domain.VerifyWithMicrodeposit$forSetupIntent$1 r2 = (com.stripe.android.payments.bankaccount.domain.VerifyWithMicrodeposit$forSetupIntent$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0017
            int r0 = r2.label
            int r0 = r0 - r4
            r2.label = r0
            goto L_0x001c
        L_0x0017:
            com.stripe.android.payments.bankaccount.domain.VerifyWithMicrodeposit$forSetupIntent$1 r2 = new com.stripe.android.payments.bankaccount.domain.VerifyWithMicrodeposit$forSetupIntent$1
            r2.<init>(r15, r0)
        L_0x001c:
            r8 = r2
            java.lang.Object r0 = r8.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r8.label
            r4 = 1
            if (r3 == 0) goto L_0x0036
            if (r3 != r4) goto L_0x002e
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x005f }
            goto L_0x0058
        L_0x002e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r0)
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x005f }
            com.stripe.android.networking.StripeRepository r3 = r1.stripeRepository     // Catch:{ all -> 0x005f }
            com.stripe.android.core.networking.ApiRequest$Options r7 = new com.stripe.android.core.networking.ApiRequest$Options     // Catch:{ all -> 0x005f }
            r11 = 0
            r12 = 0
            r13 = 6
            r14 = 0
            r9 = r7
            r10 = r16
            r9.<init>(r10, r11, r12, r13, r14)     // Catch:{ all -> 0x005f }
            r8.label = r4     // Catch:{ all -> 0x005f }
            r4 = r17
            r5 = r18
            r6 = r19
            java.lang.Object r0 = r3.verifySetupIntentWithMicrodeposits(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x005f }
            if (r0 != r2) goto L_0x0058
            return r2
        L_0x0058:
            com.stripe.android.model.SetupIntent r0 = (com.stripe.android.model.SetupIntent) r0     // Catch:{ all -> 0x005f }
            java.lang.Object r0 = kotlin.Result.m4709constructorimpl(r0)     // Catch:{ all -> 0x005f }
            goto L_0x006a
        L_0x005f:
            r0 = move-exception
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m4709constructorimpl(r0)
        L_0x006a:
            boolean r2 = kotlin.Result.m4716isSuccessimpl(r0)
            if (r2 == 0) goto L_0x008a
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch:{ all -> 0x0083 }
            com.stripe.android.model.SetupIntent r0 = (com.stripe.android.model.SetupIntent) r0     // Catch:{ all -> 0x0083 }
            if (r0 == 0) goto L_0x007b
            java.lang.Object r0 = kotlin.Result.m4709constructorimpl(r0)     // Catch:{ all -> 0x0083 }
            goto L_0x008e
        L_0x007b:
            java.lang.InternalError r0 = new java.lang.InternalError     // Catch:{ all -> 0x0083 }
            java.lang.String r2 = "Error verifying SetupIntent with microdeposits"
            r0.<init>(r2)     // Catch:{ all -> 0x0083 }
            throw r0     // Catch:{ all -> 0x0083 }
        L_0x0083:
            r0 = move-exception
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
        L_0x008a:
            java.lang.Object r0 = kotlin.Result.m4709constructorimpl(r0)
        L_0x008e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.payments.bankaccount.domain.VerifyWithMicrodeposit.m4378forSetupIntentyxL6bBk(java.lang.String, java.lang.String, int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0065 A[SYNTHETIC, Splitter:B:23:0x0065] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: forSetupIntent-BWLJW6A  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m4377forSetupIntentBWLJW6A(java.lang.String r11, java.lang.String r12, java.lang.String r13, kotlin.coroutines.Continuation<? super kotlin.Result<com.stripe.android.model.SetupIntent>> r14) {
        /*
            r10 = this;
            boolean r0 = r14 instanceof com.stripe.android.payments.bankaccount.domain.VerifyWithMicrodeposit$forSetupIntent$4
            if (r0 == 0) goto L_0x0014
            r0 = r14
            com.stripe.android.payments.bankaccount.domain.VerifyWithMicrodeposit$forSetupIntent$4 r0 = (com.stripe.android.payments.bankaccount.domain.VerifyWithMicrodeposit$forSetupIntent$4) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L_0x0019
        L_0x0014:
            com.stripe.android.payments.bankaccount.domain.VerifyWithMicrodeposit$forSetupIntent$4 r0 = new com.stripe.android.payments.bankaccount.domain.VerifyWithMicrodeposit$forSetupIntent$4
            r0.<init>(r10, r14)
        L_0x0019:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ all -> 0x0054 }
            goto L_0x004d
        L_0x002a:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r14)
            kotlin.Result$Companion r14 = kotlin.Result.Companion     // Catch:{ all -> 0x0054 }
            com.stripe.android.networking.StripeRepository r14 = r10.stripeRepository     // Catch:{ all -> 0x0054 }
            com.stripe.android.core.networking.ApiRequest$Options r2 = new com.stripe.android.core.networking.ApiRequest$Options     // Catch:{ all -> 0x0054 }
            r6 = 0
            r7 = 0
            r8 = 6
            r9 = 0
            r4 = r2
            r5 = r11
            r4.<init>(r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0054 }
            r0.label = r3     // Catch:{ all -> 0x0054 }
            java.lang.Object r14 = r14.verifySetupIntentWithMicrodeposits(r12, r13, r2, r0)     // Catch:{ all -> 0x0054 }
            if (r14 != r1) goto L_0x004d
            return r1
        L_0x004d:
            com.stripe.android.model.SetupIntent r14 = (com.stripe.android.model.SetupIntent) r14     // Catch:{ all -> 0x0054 }
            java.lang.Object r11 = kotlin.Result.m4709constructorimpl(r14)     // Catch:{ all -> 0x0054 }
            goto L_0x005f
        L_0x0054:
            r11 = move-exception
            kotlin.Result$Companion r12 = kotlin.Result.Companion
            java.lang.Object r11 = kotlin.ResultKt.createFailure(r11)
            java.lang.Object r11 = kotlin.Result.m4709constructorimpl(r11)
        L_0x005f:
            boolean r12 = kotlin.Result.m4716isSuccessimpl(r11)
            if (r12 == 0) goto L_0x007f
            kotlin.Result$Companion r12 = kotlin.Result.Companion     // Catch:{ all -> 0x0078 }
            com.stripe.android.model.SetupIntent r11 = (com.stripe.android.model.SetupIntent) r11     // Catch:{ all -> 0x0078 }
            if (r11 == 0) goto L_0x0070
            java.lang.Object r11 = kotlin.Result.m4709constructorimpl(r11)     // Catch:{ all -> 0x0078 }
            goto L_0x0083
        L_0x0070:
            java.lang.InternalError r11 = new java.lang.InternalError     // Catch:{ all -> 0x0078 }
            java.lang.String r12 = "Error verifying SetupIntent with microdeposits"
            r11.<init>(r12)     // Catch:{ all -> 0x0078 }
            throw r11     // Catch:{ all -> 0x0078 }
        L_0x0078:
            r11 = move-exception
            kotlin.Result$Companion r12 = kotlin.Result.Companion
            java.lang.Object r11 = kotlin.ResultKt.createFailure(r11)
        L_0x007f:
            java.lang.Object r11 = kotlin.Result.m4709constructorimpl(r11)
        L_0x0083:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.payments.bankaccount.domain.VerifyWithMicrodeposit.m4377forSetupIntentBWLJW6A(java.lang.String, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
