package com.stripe.android.payments.bankaccount.domain;

import com.stripe.android.networking.StripeRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JD\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\tH@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\r\u0010\u000eJD\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\tH@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0010\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0011"}, d2 = {"Lcom/stripe/android/payments/bankaccount/domain/CreateLinkAccountSession;", "", "stripeRepository", "Lcom/stripe/android/networking/StripeRepository;", "(Lcom/stripe/android/networking/StripeRepository;)V", "forPaymentIntent", "Lkotlin/Result;", "Lcom/stripe/android/model/BankConnectionsLinkedAccountSession;", "publishableKey", "", "clientSecret", "customerName", "customerEmail", "forPaymentIntent-yxL6bBk", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "forSetupIntent", "forSetupIntent-yxL6bBk", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CreateLinkAccountSession.kt */
public final class CreateLinkAccountSession {
    private final StripeRepository stripeRepository;

    @Inject
    public CreateLinkAccountSession(StripeRepository stripeRepository2) {
        Intrinsics.checkNotNullParameter(stripeRepository2, "stripeRepository");
        this.stripeRepository = stripeRepository2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x007c A[SYNTHETIC, Splitter:B:23:0x007c] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* renamed from: forPaymentIntent-yxL6bBk  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m4373forPaymentIntentyxL6bBk(java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, kotlin.coroutines.Continuation<? super kotlin.Result<com.stripe.android.model.BankConnectionsLinkedAccountSession>> r19) {
        /*
            r14 = this;
            r1 = r14
            r0 = r16
            r2 = r19
            boolean r3 = r2 instanceof com.stripe.android.payments.bankaccount.domain.CreateLinkAccountSession$forPaymentIntent$1
            if (r3 == 0) goto L_0x0019
            r3 = r2
            com.stripe.android.payments.bankaccount.domain.CreateLinkAccountSession$forPaymentIntent$1 r3 = (com.stripe.android.payments.bankaccount.domain.CreateLinkAccountSession$forPaymentIntent$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x0019
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001e
        L_0x0019:
            com.stripe.android.payments.bankaccount.domain.CreateLinkAccountSession$forPaymentIntent$1 r3 = new com.stripe.android.payments.bankaccount.domain.CreateLinkAccountSession$forPaymentIntent$1
            r3.<init>(r14, r2)
        L_0x001e:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 1
            if (r5 == 0) goto L_0x0037
            if (r5 != r6) goto L_0x002f
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ all -> 0x006b }
            goto L_0x0064
        L_0x002f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r2)
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch:{ all -> 0x006b }
            com.stripe.android.networking.StripeRepository r2 = r1.stripeRepository     // Catch:{ all -> 0x006b }
            com.stripe.android.model.PaymentIntent$ClientSecret r5 = new com.stripe.android.model.PaymentIntent$ClientSecret     // Catch:{ all -> 0x006b }
            r5.<init>(r0)     // Catch:{ all -> 0x006b }
            java.lang.String r5 = r5.getPaymentIntentId$payments_core_release()     // Catch:{ all -> 0x006b }
            com.stripe.android.model.CreateLinkAccountSessionParams r7 = new com.stripe.android.model.CreateLinkAccountSessionParams     // Catch:{ all -> 0x006b }
            r8 = r17
            r9 = r18
            r7.<init>(r0, r8, r9)     // Catch:{ all -> 0x006b }
            com.stripe.android.core.networking.ApiRequest$Options r0 = new com.stripe.android.core.networking.ApiRequest$Options     // Catch:{ all -> 0x006b }
            r10 = 0
            r11 = 0
            r12 = 6
            r13 = 0
            r8 = r0
            r9 = r15
            r8.<init>(r9, r10, r11, r12, r13)     // Catch:{ all -> 0x006b }
            r3.label = r6     // Catch:{ all -> 0x006b }
            java.lang.Object r2 = r2.createPaymentIntentLinkAccountSession$payments_core_release(r5, r7, r0, r3)     // Catch:{ all -> 0x006b }
            if (r2 != r4) goto L_0x0064
            return r4
        L_0x0064:
            com.stripe.android.model.BankConnectionsLinkedAccountSession r2 = (com.stripe.android.model.BankConnectionsLinkedAccountSession) r2     // Catch:{ all -> 0x006b }
            java.lang.Object r0 = kotlin.Result.m4709constructorimpl(r2)     // Catch:{ all -> 0x006b }
            goto L_0x0076
        L_0x006b:
            r0 = move-exception
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m4709constructorimpl(r0)
        L_0x0076:
            boolean r2 = kotlin.Result.m4716isSuccessimpl(r0)
            if (r2 == 0) goto L_0x0096
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch:{ all -> 0x008f }
            com.stripe.android.model.BankConnectionsLinkedAccountSession r0 = (com.stripe.android.model.BankConnectionsLinkedAccountSession) r0     // Catch:{ all -> 0x008f }
            if (r0 == 0) goto L_0x0087
            java.lang.Object r0 = kotlin.Result.m4709constructorimpl(r0)     // Catch:{ all -> 0x008f }
            goto L_0x009a
        L_0x0087:
            java.lang.InternalError r0 = new java.lang.InternalError     // Catch:{ all -> 0x008f }
            java.lang.String r2 = "Error creating session for PaymentIntent"
            r0.<init>(r2)     // Catch:{ all -> 0x008f }
            throw r0     // Catch:{ all -> 0x008f }
        L_0x008f:
            r0 = move-exception
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
        L_0x0096:
            java.lang.Object r0 = kotlin.Result.m4709constructorimpl(r0)
        L_0x009a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.payments.bankaccount.domain.CreateLinkAccountSession.m4373forPaymentIntentyxL6bBk(java.lang.String, java.lang.String, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x007c A[SYNTHETIC, Splitter:B:23:0x007c] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* renamed from: forSetupIntent-yxL6bBk  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m4374forSetupIntentyxL6bBk(java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, kotlin.coroutines.Continuation<? super kotlin.Result<com.stripe.android.model.BankConnectionsLinkedAccountSession>> r19) {
        /*
            r14 = this;
            r1 = r14
            r0 = r16
            r2 = r19
            boolean r3 = r2 instanceof com.stripe.android.payments.bankaccount.domain.CreateLinkAccountSession$forSetupIntent$1
            if (r3 == 0) goto L_0x0019
            r3 = r2
            com.stripe.android.payments.bankaccount.domain.CreateLinkAccountSession$forSetupIntent$1 r3 = (com.stripe.android.payments.bankaccount.domain.CreateLinkAccountSession$forSetupIntent$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x0019
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001e
        L_0x0019:
            com.stripe.android.payments.bankaccount.domain.CreateLinkAccountSession$forSetupIntent$1 r3 = new com.stripe.android.payments.bankaccount.domain.CreateLinkAccountSession$forSetupIntent$1
            r3.<init>(r14, r2)
        L_0x001e:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 1
            if (r5 == 0) goto L_0x0037
            if (r5 != r6) goto L_0x002f
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ all -> 0x006b }
            goto L_0x0064
        L_0x002f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r2)
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch:{ all -> 0x006b }
            com.stripe.android.networking.StripeRepository r2 = r1.stripeRepository     // Catch:{ all -> 0x006b }
            com.stripe.android.model.SetupIntent$ClientSecret r5 = new com.stripe.android.model.SetupIntent$ClientSecret     // Catch:{ all -> 0x006b }
            r5.<init>(r0)     // Catch:{ all -> 0x006b }
            java.lang.String r5 = r5.getSetupIntentId$payments_core_release()     // Catch:{ all -> 0x006b }
            com.stripe.android.model.CreateLinkAccountSessionParams r7 = new com.stripe.android.model.CreateLinkAccountSessionParams     // Catch:{ all -> 0x006b }
            r8 = r17
            r9 = r18
            r7.<init>(r0, r8, r9)     // Catch:{ all -> 0x006b }
            com.stripe.android.core.networking.ApiRequest$Options r0 = new com.stripe.android.core.networking.ApiRequest$Options     // Catch:{ all -> 0x006b }
            r10 = 0
            r11 = 0
            r12 = 6
            r13 = 0
            r8 = r0
            r9 = r15
            r8.<init>(r9, r10, r11, r12, r13)     // Catch:{ all -> 0x006b }
            r3.label = r6     // Catch:{ all -> 0x006b }
            java.lang.Object r2 = r2.createSetupIntentLinkAccountSession$payments_core_release(r5, r7, r0, r3)     // Catch:{ all -> 0x006b }
            if (r2 != r4) goto L_0x0064
            return r4
        L_0x0064:
            com.stripe.android.model.BankConnectionsLinkedAccountSession r2 = (com.stripe.android.model.BankConnectionsLinkedAccountSession) r2     // Catch:{ all -> 0x006b }
            java.lang.Object r0 = kotlin.Result.m4709constructorimpl(r2)     // Catch:{ all -> 0x006b }
            goto L_0x0076
        L_0x006b:
            r0 = move-exception
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m4709constructorimpl(r0)
        L_0x0076:
            boolean r2 = kotlin.Result.m4716isSuccessimpl(r0)
            if (r2 == 0) goto L_0x0096
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch:{ all -> 0x008f }
            com.stripe.android.model.BankConnectionsLinkedAccountSession r0 = (com.stripe.android.model.BankConnectionsLinkedAccountSession) r0     // Catch:{ all -> 0x008f }
            if (r0 == 0) goto L_0x0087
            java.lang.Object r0 = kotlin.Result.m4709constructorimpl(r0)     // Catch:{ all -> 0x008f }
            goto L_0x009a
        L_0x0087:
            java.lang.InternalError r0 = new java.lang.InternalError     // Catch:{ all -> 0x008f }
            java.lang.String r2 = "Error creating session for SetupIntent"
            r0.<init>(r2)     // Catch:{ all -> 0x008f }
            throw r0     // Catch:{ all -> 0x008f }
        L_0x008f:
            r0 = move-exception
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
        L_0x0096:
            java.lang.Object r0 = kotlin.Result.m4709constructorimpl(r0)
        L_0x009a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.payments.bankaccount.domain.CreateLinkAccountSession.m4374forSetupIntentyxL6bBk(java.lang.String, java.lang.String, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
