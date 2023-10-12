package com.stripe.android;

import com.stripe.android.core.exception.APIConnectionException;
import com.stripe.android.core.exception.APIException;
import com.stripe.android.core.exception.AuthenticationException;
import com.stripe.android.core.exception.InvalidRequestException;
import com.stripe.android.core.exception.StripeException;
import com.stripe.android.core.model.StripeFileParams;
import com.stripe.android.core.model.StripeModel;
import com.stripe.android.exception.CardException;
import com.stripe.android.model.AccountParams;
import com.stripe.android.model.BankAccountTokenParams;
import com.stripe.android.model.CardParams;
import com.stripe.android.model.ConfirmPaymentIntentParams;
import com.stripe.android.model.ConfirmSetupIntentParams;
import com.stripe.android.model.PaymentMethodCreateParams;
import com.stripe.android.model.PersonTokenParams;
import com.stripe.android.model.SourceParams;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.ClassUtils;

@Metadata(d1 = {"\u0000Â\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u001a*\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0004H\b¢\u0006\u0002\u0010\u0005\u001a3\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004H\bø\u0001\u0000¢\u0006\u0002\u0010\b\u001a1\u0010\t\u001a\u00020\n*\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H@ø\u0001\u0001¢\u0006\u0002\u0010\u0012\u001a)\u0010\u0013\u001a\u00020\u0014*\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0011H@ø\u0001\u0001¢\u0006\u0002\u0010\u0016\u001a)\u0010\u0017\u001a\u00020\u0018*\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0011H@ø\u0001\u0001¢\u0006\u0002\u0010\u001b\u001a)\u0010\u001c\u001a\u00020\u001d*\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H@ø\u0001\u0001¢\u0006\u0002\u0010\u0016\u001a5\u0010\u001e\u001a\u00020\u001f*\u00020\u000b2\u0006\u0010 \u001a\u00020!2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H@ø\u0001\u0001¢\u0006\u0002\u0010\"\u001a5\u0010#\u001a\u00020\u001f*\u00020\u000b2\u0006\u0010$\u001a\u00020%2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H@ø\u0001\u0001¢\u0006\u0002\u0010&\u001a5\u0010'\u001a\u00020\u001f*\u00020\u000b2\u0006\u0010(\u001a\u00020)2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H@ø\u0001\u0001¢\u0006\u0002\u0010*\u001a7\u0010+\u001a\u00020\u001f*\u00020\u000b2\b\b\u0001\u0010,\u001a\u00020\u00112\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H@ø\u0001\u0001¢\u0006\u0002\u0010-\u001a5\u0010.\u001a\u00020/*\u00020\u000b2\u0006\u00100\u001a\u0002012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H@ø\u0001\u0001¢\u0006\u0002\u00102\u001a5\u00103\u001a\u000204*\u00020\u000b2\u0006\u00105\u001a\u0002062\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H@ø\u0001\u0001¢\u0006\u0002\u00107\u001a5\u00108\u001a\u00020\u001f*\u00020\u000b2\u0006\u00109\u001a\u00020:2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H@ø\u0001\u0001¢\u0006\u0002\u0010;\u001a5\u0010<\u001a\u00020\u001f*\u00020\u000b2\u0006\u0010=\u001a\u00020\u00112\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H@ø\u0001\u0001¢\u0006\u0002\u0010-\u001a\u0015\u0010>\u001a\u00020?*\u00020\u000bH@ø\u0001\u0001¢\u0006\u0002\u0010@\u001a5\u0010A\u001a\u00020B*\u00020\u000b2\u0006\u0010C\u001a\u00020D2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H@ø\u0001\u0001¢\u0006\u0002\u0010E\u001a%\u0010F\u001a\u00020B*\u00020\u000b2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020JH@ø\u0001\u0001¢\u0006\u0002\u0010K\u001a%\u0010L\u001a\u00020\n*\u00020\u000b2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020JH@ø\u0001\u0001¢\u0006\u0002\u0010K\u001a%\u0010M\u001a\u00020N*\u00020\u000b2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020JH@ø\u0001\u0001¢\u0006\u0002\u0010K\u001a)\u0010O\u001a\u00020\u0014*\u00020\u000b2\u0006\u0010P\u001a\u00020\u00112\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H@ø\u0001\u0001¢\u0006\u0002\u0010Q\u001a)\u0010R\u001a\u00020\u0018*\u00020\u000b2\u0006\u0010P\u001a\u00020\u00112\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H@ø\u0001\u0001¢\u0006\u0002\u0010Q\u001a5\u0010S\u001a\u00020B*\u00020\u000b2\b\b\u0001\u0010T\u001a\u00020\u00112\b\b\u0001\u0010P\u001a\u00020\u00112\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H@ø\u0001\u0001¢\u0006\u0002\u0010-\u001a-\u0010U\u001a\u00020\u0014*\u00020\u000b2\u0006\u0010P\u001a\u00020\u00112\u0006\u0010V\u001a\u00020H2\u0006\u0010W\u001a\u00020HH@ø\u0001\u0001¢\u0006\u0002\u0010X\u001a%\u0010U\u001a\u00020\u0014*\u00020\u000b2\u0006\u0010P\u001a\u00020\u00112\u0006\u0010Y\u001a\u00020\u0011H@ø\u0001\u0001¢\u0006\u0002\u0010Q\u001a-\u0010Z\u001a\u00020\u0018*\u00020\u000b2\u0006\u0010P\u001a\u00020\u00112\u0006\u0010V\u001a\u00020H2\u0006\u0010W\u001a\u00020HH@ø\u0001\u0001¢\u0006\u0002\u0010X\u001a%\u0010Z\u001a\u00020\u0018*\u00020\u000b2\u0006\u0010P\u001a\u00020\u00112\u0006\u0010Y\u001a\u00020\u0011H@ø\u0001\u0001¢\u0006\u0002\u0010Q\u0002\u000b\n\u0005\b20\u0001\n\u0002\b\u0019¨\u0006["}, d2 = {"runApiRequest", "ApiObject", "Lcom/stripe/android/core/model/StripeModel;", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Lcom/stripe/android/core/model/StripeModel;", "isValidParam", "", "(ZLkotlin/jvm/functions/Function0;)Lcom/stripe/android/core/model/StripeModel;", "confirmAlipayPayment", "Lcom/stripe/android/PaymentIntentResult;", "Lcom/stripe/android/Stripe;", "confirmPaymentIntentParams", "Lcom/stripe/android/model/ConfirmPaymentIntentParams;", "authenticator", "Lcom/stripe/android/AlipayAuthenticator;", "stripeAccountId", "", "(Lcom/stripe/android/Stripe;Lcom/stripe/android/model/ConfirmPaymentIntentParams;Lcom/stripe/android/AlipayAuthenticator;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmPaymentIntent", "Lcom/stripe/android/model/PaymentIntent;", "idempotencyKey", "(Lcom/stripe/android/Stripe;Lcom/stripe/android/model/ConfirmPaymentIntentParams;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmSetupIntent", "Lcom/stripe/android/model/SetupIntent;", "confirmSetupIntentParams", "Lcom/stripe/android/model/ConfirmSetupIntentParams;", "(Lcom/stripe/android/Stripe;Lcom/stripe/android/model/ConfirmSetupIntentParams;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmWeChatPayPayment", "Lcom/stripe/android/model/WeChatPayNextAction;", "createAccountToken", "Lcom/stripe/android/model/Token;", "accountParams", "Lcom/stripe/android/model/AccountParams;", "(Lcom/stripe/android/Stripe;Lcom/stripe/android/model/AccountParams;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createBankAccountToken", "bankAccountTokenParams", "Lcom/stripe/android/model/BankAccountTokenParams;", "(Lcom/stripe/android/Stripe;Lcom/stripe/android/model/BankAccountTokenParams;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createCardToken", "cardParams", "Lcom/stripe/android/model/CardParams;", "(Lcom/stripe/android/Stripe;Lcom/stripe/android/model/CardParams;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createCvcUpdateToken", "cvc", "(Lcom/stripe/android/Stripe;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createFile", "Lcom/stripe/android/core/model/StripeFile;", "fileParams", "Lcom/stripe/android/core/model/StripeFileParams;", "(Lcom/stripe/android/Stripe;Lcom/stripe/android/core/model/StripeFileParams;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createPaymentMethod", "Lcom/stripe/android/model/PaymentMethod;", "paymentMethodCreateParams", "Lcom/stripe/android/model/PaymentMethodCreateParams;", "(Lcom/stripe/android/Stripe;Lcom/stripe/android/model/PaymentMethodCreateParams;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createPersonToken", "params", "Lcom/stripe/android/model/PersonTokenParams;", "(Lcom/stripe/android/Stripe;Lcom/stripe/android/model/PersonTokenParams;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createPiiToken", "personalId", "createRadarSession", "Lcom/stripe/android/model/RadarSession;", "(Lcom/stripe/android/Stripe;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createSource", "Lcom/stripe/android/model/Source;", "sourceParams", "Lcom/stripe/android/model/SourceParams;", "(Lcom/stripe/android/Stripe;Lcom/stripe/android/model/SourceParams;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAuthenticateSourceResult", "requestCode", "", "data", "Landroid/content/Intent;", "(Lcom/stripe/android/Stripe;ILandroid/content/Intent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPaymentIntentResult", "getSetupIntentResult", "Lcom/stripe/android/SetupIntentResult;", "retrievePaymentIntent", "clientSecret", "(Lcom/stripe/android/Stripe;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "retrieveSetupIntent", "retrieveSource", "sourceId", "verifyPaymentIntentWithMicrodeposits", "firstAmount", "secondAmount", "(Lcom/stripe/android/Stripe;Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "descriptorCode", "verifySetupIntentWithMicrodeposits", "payments-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: StripeKtx.kt */
public final class StripeKtxKt {
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0056 A[Catch:{ all -> 0x0083 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005d A[Catch:{ all -> 0x0083 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object confirmAlipayPayment(com.stripe.android.Stripe r10, com.stripe.android.model.ConfirmPaymentIntentParams r11, com.stripe.android.AlipayAuthenticator r12, java.lang.String r13, kotlin.coroutines.Continuation<? super com.stripe.android.PaymentIntentResult> r14) throws com.stripe.android.core.exception.AuthenticationException, com.stripe.android.core.exception.InvalidRequestException, com.stripe.android.core.exception.APIConnectionException, com.stripe.android.core.exception.APIException {
        /*
            boolean r0 = r14 instanceof com.stripe.android.StripeKtxKt$confirmAlipayPayment$1
            if (r0 == 0) goto L_0x0014
            r0 = r14
            com.stripe.android.StripeKtxKt$confirmAlipayPayment$1 r0 = (com.stripe.android.StripeKtxKt$confirmAlipayPayment$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L_0x0019
        L_0x0014:
            com.stripe.android.StripeKtxKt$confirmAlipayPayment$1 r0 = new com.stripe.android.StripeKtxKt$confirmAlipayPayment$1
            r0.<init>(r14)
        L_0x0019:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ all -> 0x0083 }
            goto L_0x0052
        L_0x002a:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r14)
            kotlin.Result$Companion r14 = kotlin.Result.Companion     // Catch:{ all -> 0x0083 }
            com.stripe.android.PaymentController r14 = r10.getPaymentController$payments_core_release()     // Catch:{ all -> 0x0083 }
            com.stripe.android.core.networking.ApiRequest$Options r2 = new com.stripe.android.core.networking.ApiRequest$Options     // Catch:{ all -> 0x0083 }
            java.lang.String r5 = r10.getPublishableKey$payments_core_release()     // Catch:{ all -> 0x0083 }
            r7 = 0
            r8 = 4
            r9 = 0
            r4 = r2
            r6 = r13
            r4.<init>(r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0083 }
            r0.label = r3     // Catch:{ all -> 0x0083 }
            java.lang.Object r14 = r14.confirmAndAuthenticateAlipay(r11, r12, r2, r0)     // Catch:{ all -> 0x0083 }
            if (r14 != r1) goto L_0x0052
            return r1
        L_0x0052:
            com.stripe.android.PaymentIntentResult r14 = (com.stripe.android.PaymentIntentResult) r14     // Catch:{ all -> 0x0083 }
            if (r14 == 0) goto L_0x005d
            com.stripe.android.core.model.StripeModel r14 = (com.stripe.android.core.model.StripeModel) r14     // Catch:{ all -> 0x0083 }
            java.lang.Object r10 = kotlin.Result.m4709constructorimpl(r14)     // Catch:{ all -> 0x0083 }
            goto L_0x008e
        L_0x005d:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0083 }
            r10.<init>()     // Catch:{ all -> 0x0083 }
            java.lang.String r11 = "Failed to parse "
            r10.append(r11)     // Catch:{ all -> 0x0083 }
            java.lang.Class<com.stripe.android.PaymentIntentResult> r11 = com.stripe.android.PaymentIntentResult.class
            java.lang.String r11 = r11.getSimpleName()     // Catch:{ all -> 0x0083 }
            r10.append(r11)     // Catch:{ all -> 0x0083 }
            r11 = 46
            r10.append(r11)     // Catch:{ all -> 0x0083 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x0083 }
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0083 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x0083 }
            r11.<init>(r10)     // Catch:{ all -> 0x0083 }
            throw r11     // Catch:{ all -> 0x0083 }
        L_0x0083:
            r10 = move-exception
            kotlin.Result$Companion r11 = kotlin.Result.Companion
            java.lang.Object r10 = kotlin.ResultKt.createFailure(r10)
            java.lang.Object r10 = kotlin.Result.m4709constructorimpl(r10)
        L_0x008e:
            java.lang.Throwable r11 = kotlin.Result.m4712exceptionOrNullimpl(r10)
            if (r11 != 0) goto L_0x0097
            com.stripe.android.core.model.StripeModel r10 = (com.stripe.android.core.model.StripeModel) r10
            return r10
        L_0x0097:
            com.stripe.android.core.exception.StripeException$Companion r10 = com.stripe.android.core.exception.StripeException.Companion
            com.stripe.android.core.exception.StripeException r10 = r10.create(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.StripeKtxKt.confirmAlipayPayment(com.stripe.android.Stripe, com.stripe.android.model.ConfirmPaymentIntentParams, com.stripe.android.AlipayAuthenticator, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object confirmAlipayPayment$default(Stripe stripe, ConfirmPaymentIntentParams confirmPaymentIntentParams, AlipayAuthenticator alipayAuthenticator, String str, Continuation continuation, int i, Object obj) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException {
        if ((i & 4) != 0) {
            str = stripe.getStripeAccountId$payments_core_release();
        }
        return confirmAlipayPayment(stripe, confirmPaymentIntentParams, alipayAuthenticator, str, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0051 A[Catch:{ all -> 0x007e }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0058 A[Catch:{ all -> 0x007e }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object createPaymentMethod(com.stripe.android.Stripe r4, com.stripe.android.model.PaymentMethodCreateParams r5, java.lang.String r6, java.lang.String r7, kotlin.coroutines.Continuation<? super com.stripe.android.model.PaymentMethod> r8) throws com.stripe.android.core.exception.AuthenticationException, com.stripe.android.core.exception.InvalidRequestException, com.stripe.android.core.exception.APIConnectionException, com.stripe.android.core.exception.APIException {
        /*
            boolean r0 = r8 instanceof com.stripe.android.StripeKtxKt$createPaymentMethod$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.stripe.android.StripeKtxKt$createPaymentMethod$1 r0 = (com.stripe.android.StripeKtxKt$createPaymentMethod$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.stripe.android.StripeKtxKt$createPaymentMethod$1 r0 = new com.stripe.android.StripeKtxKt$createPaymentMethod$1
            r0.<init>(r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x007e }
            goto L_0x004d
        L_0x002a:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.Result$Companion r8 = kotlin.Result.Companion     // Catch:{ all -> 0x007e }
            com.stripe.android.networking.StripeRepository r8 = r4.getStripeRepository$payments_core_release()     // Catch:{ all -> 0x007e }
            com.stripe.android.core.networking.ApiRequest$Options r2 = new com.stripe.android.core.networking.ApiRequest$Options     // Catch:{ all -> 0x007e }
            java.lang.String r4 = r4.getPublishableKey$payments_core_release()     // Catch:{ all -> 0x007e }
            r2.<init>(r4, r7, r6)     // Catch:{ all -> 0x007e }
            r0.label = r3     // Catch:{ all -> 0x007e }
            java.lang.Object r8 = r8.createPaymentMethod(r5, r2, r0)     // Catch:{ all -> 0x007e }
            if (r8 != r1) goto L_0x004d
            return r1
        L_0x004d:
            com.stripe.android.model.PaymentMethod r8 = (com.stripe.android.model.PaymentMethod) r8     // Catch:{ all -> 0x007e }
            if (r8 == 0) goto L_0x0058
            com.stripe.android.core.model.StripeModel r8 = (com.stripe.android.core.model.StripeModel) r8     // Catch:{ all -> 0x007e }
            java.lang.Object r4 = kotlin.Result.m4709constructorimpl(r8)     // Catch:{ all -> 0x007e }
            goto L_0x0089
        L_0x0058:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x007e }
            r4.<init>()     // Catch:{ all -> 0x007e }
            java.lang.String r5 = "Failed to parse "
            r4.append(r5)     // Catch:{ all -> 0x007e }
            java.lang.Class<com.stripe.android.model.PaymentMethod> r5 = com.stripe.android.model.PaymentMethod.class
            java.lang.String r5 = r5.getSimpleName()     // Catch:{ all -> 0x007e }
            r4.append(r5)     // Catch:{ all -> 0x007e }
            r5 = 46
            r4.append(r5)     // Catch:{ all -> 0x007e }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x007e }
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x007e }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x007e }
            r5.<init>(r4)     // Catch:{ all -> 0x007e }
            throw r5     // Catch:{ all -> 0x007e }
        L_0x007e:
            r4 = move-exception
            kotlin.Result$Companion r5 = kotlin.Result.Companion
            java.lang.Object r4 = kotlin.ResultKt.createFailure(r4)
            java.lang.Object r4 = kotlin.Result.m4709constructorimpl(r4)
        L_0x0089:
            java.lang.Throwable r5 = kotlin.Result.m4712exceptionOrNullimpl(r4)
            if (r5 != 0) goto L_0x0092
            com.stripe.android.core.model.StripeModel r4 = (com.stripe.android.core.model.StripeModel) r4
            return r4
        L_0x0092:
            com.stripe.android.core.exception.StripeException$Companion r4 = com.stripe.android.core.exception.StripeException.Companion
            com.stripe.android.core.exception.StripeException r4 = r4.create(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.StripeKtxKt.createPaymentMethod(com.stripe.android.Stripe, com.stripe.android.model.PaymentMethodCreateParams, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object createPaymentMethod$default(Stripe stripe, PaymentMethodCreateParams paymentMethodCreateParams, String str, String str2, Continuation continuation, int i, Object obj) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = stripe.getStripeAccountId$payments_core_release();
        }
        return createPaymentMethod(stripe, paymentMethodCreateParams, str, str2, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0051 A[Catch:{ all -> 0x007e }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0058 A[Catch:{ all -> 0x007e }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object createSource(com.stripe.android.Stripe r4, com.stripe.android.model.SourceParams r5, java.lang.String r6, java.lang.String r7, kotlin.coroutines.Continuation<? super com.stripe.android.model.Source> r8) throws com.stripe.android.core.exception.AuthenticationException, com.stripe.android.core.exception.InvalidRequestException, com.stripe.android.core.exception.APIConnectionException, com.stripe.android.core.exception.APIException {
        /*
            boolean r0 = r8 instanceof com.stripe.android.StripeKtxKt$createSource$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.stripe.android.StripeKtxKt$createSource$1 r0 = (com.stripe.android.StripeKtxKt$createSource$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.stripe.android.StripeKtxKt$createSource$1 r0 = new com.stripe.android.StripeKtxKt$createSource$1
            r0.<init>(r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x007e }
            goto L_0x004d
        L_0x002a:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.Result$Companion r8 = kotlin.Result.Companion     // Catch:{ all -> 0x007e }
            com.stripe.android.networking.StripeRepository r8 = r4.getStripeRepository$payments_core_release()     // Catch:{ all -> 0x007e }
            com.stripe.android.core.networking.ApiRequest$Options r2 = new com.stripe.android.core.networking.ApiRequest$Options     // Catch:{ all -> 0x007e }
            java.lang.String r4 = r4.getPublishableKey$payments_core_release()     // Catch:{ all -> 0x007e }
            r2.<init>(r4, r7, r6)     // Catch:{ all -> 0x007e }
            r0.label = r3     // Catch:{ all -> 0x007e }
            java.lang.Object r8 = r8.createSource$payments_core_release(r5, r2, r0)     // Catch:{ all -> 0x007e }
            if (r8 != r1) goto L_0x004d
            return r1
        L_0x004d:
            com.stripe.android.model.Source r8 = (com.stripe.android.model.Source) r8     // Catch:{ all -> 0x007e }
            if (r8 == 0) goto L_0x0058
            com.stripe.android.core.model.StripeModel r8 = (com.stripe.android.core.model.StripeModel) r8     // Catch:{ all -> 0x007e }
            java.lang.Object r4 = kotlin.Result.m4709constructorimpl(r8)     // Catch:{ all -> 0x007e }
            goto L_0x0089
        L_0x0058:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x007e }
            r4.<init>()     // Catch:{ all -> 0x007e }
            java.lang.String r5 = "Failed to parse "
            r4.append(r5)     // Catch:{ all -> 0x007e }
            java.lang.Class<com.stripe.android.model.Source> r5 = com.stripe.android.model.Source.class
            java.lang.String r5 = r5.getSimpleName()     // Catch:{ all -> 0x007e }
            r4.append(r5)     // Catch:{ all -> 0x007e }
            r5 = 46
            r4.append(r5)     // Catch:{ all -> 0x007e }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x007e }
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x007e }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x007e }
            r5.<init>(r4)     // Catch:{ all -> 0x007e }
            throw r5     // Catch:{ all -> 0x007e }
        L_0x007e:
            r4 = move-exception
            kotlin.Result$Companion r5 = kotlin.Result.Companion
            java.lang.Object r4 = kotlin.ResultKt.createFailure(r4)
            java.lang.Object r4 = kotlin.Result.m4709constructorimpl(r4)
        L_0x0089:
            java.lang.Throwable r5 = kotlin.Result.m4712exceptionOrNullimpl(r4)
            if (r5 != 0) goto L_0x0092
            com.stripe.android.core.model.StripeModel r4 = (com.stripe.android.core.model.StripeModel) r4
            return r4
        L_0x0092:
            com.stripe.android.core.exception.StripeException$Companion r4 = com.stripe.android.core.exception.StripeException.Companion
            com.stripe.android.core.exception.StripeException r4 = r4.create(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.StripeKtxKt.createSource(com.stripe.android.Stripe, com.stripe.android.model.SourceParams, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object createSource$default(Stripe stripe, SourceParams sourceParams, String str, String str2, Continuation continuation, int i, Object obj) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = stripe.getStripeAccountId$payments_core_release();
        }
        return createSource(stripe, sourceParams, str, str2, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0053 A[Catch:{ all -> 0x0080 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005a A[Catch:{ all -> 0x0080 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object createAccountToken(com.stripe.android.Stripe r4, com.stripe.android.model.AccountParams r5, java.lang.String r6, java.lang.String r7, kotlin.coroutines.Continuation<? super com.stripe.android.model.Token> r8) throws com.stripe.android.core.exception.AuthenticationException, com.stripe.android.core.exception.InvalidRequestException, com.stripe.android.core.exception.APIConnectionException, com.stripe.android.core.exception.APIException {
        /*
            boolean r0 = r8 instanceof com.stripe.android.StripeKtxKt$createAccountToken$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.stripe.android.StripeKtxKt$createAccountToken$1 r0 = (com.stripe.android.StripeKtxKt$createAccountToken$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.stripe.android.StripeKtxKt$createAccountToken$1 r0 = new com.stripe.android.StripeKtxKt$createAccountToken$1
            r0.<init>(r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x0080 }
            goto L_0x004f
        L_0x002a:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.Result$Companion r8 = kotlin.Result.Companion     // Catch:{ all -> 0x0080 }
            com.stripe.android.networking.StripeRepository r8 = r4.getStripeRepository$payments_core_release()     // Catch:{ all -> 0x0080 }
            com.stripe.android.model.TokenParams r5 = (com.stripe.android.model.TokenParams) r5     // Catch:{ all -> 0x0080 }
            com.stripe.android.core.networking.ApiRequest$Options r2 = new com.stripe.android.core.networking.ApiRequest$Options     // Catch:{ all -> 0x0080 }
            java.lang.String r4 = r4.getPublishableKey$payments_core_release()     // Catch:{ all -> 0x0080 }
            r2.<init>(r4, r7, r6)     // Catch:{ all -> 0x0080 }
            r0.label = r3     // Catch:{ all -> 0x0080 }
            java.lang.Object r8 = r8.createToken$payments_core_release(r5, r2, r0)     // Catch:{ all -> 0x0080 }
            if (r8 != r1) goto L_0x004f
            return r1
        L_0x004f:
            com.stripe.android.model.Token r8 = (com.stripe.android.model.Token) r8     // Catch:{ all -> 0x0080 }
            if (r8 == 0) goto L_0x005a
            com.stripe.android.core.model.StripeModel r8 = (com.stripe.android.core.model.StripeModel) r8     // Catch:{ all -> 0x0080 }
            java.lang.Object r4 = kotlin.Result.m4709constructorimpl(r8)     // Catch:{ all -> 0x0080 }
            goto L_0x008b
        L_0x005a:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0080 }
            r4.<init>()     // Catch:{ all -> 0x0080 }
            java.lang.String r5 = "Failed to parse "
            r4.append(r5)     // Catch:{ all -> 0x0080 }
            java.lang.Class<com.stripe.android.model.Token> r5 = com.stripe.android.model.Token.class
            java.lang.String r5 = r5.getSimpleName()     // Catch:{ all -> 0x0080 }
            r4.append(r5)     // Catch:{ all -> 0x0080 }
            r5 = 46
            r4.append(r5)     // Catch:{ all -> 0x0080 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0080 }
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0080 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0080 }
            r5.<init>(r4)     // Catch:{ all -> 0x0080 }
            throw r5     // Catch:{ all -> 0x0080 }
        L_0x0080:
            r4 = move-exception
            kotlin.Result$Companion r5 = kotlin.Result.Companion
            java.lang.Object r4 = kotlin.ResultKt.createFailure(r4)
            java.lang.Object r4 = kotlin.Result.m4709constructorimpl(r4)
        L_0x008b:
            java.lang.Throwable r5 = kotlin.Result.m4712exceptionOrNullimpl(r4)
            if (r5 != 0) goto L_0x0094
            com.stripe.android.core.model.StripeModel r4 = (com.stripe.android.core.model.StripeModel) r4
            return r4
        L_0x0094:
            com.stripe.android.core.exception.StripeException$Companion r4 = com.stripe.android.core.exception.StripeException.Companion
            com.stripe.android.core.exception.StripeException r4 = r4.create(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.StripeKtxKt.createAccountToken(com.stripe.android.Stripe, com.stripe.android.model.AccountParams, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object createAccountToken$default(Stripe stripe, AccountParams accountParams, String str, String str2, Continuation continuation, int i, Object obj) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = stripe.getStripeAccountId$payments_core_release();
        }
        return createAccountToken(stripe, accountParams, str, str2, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0053 A[Catch:{ all -> 0x0080 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005a A[Catch:{ all -> 0x0080 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object createBankAccountToken(com.stripe.android.Stripe r4, com.stripe.android.model.BankAccountTokenParams r5, java.lang.String r6, java.lang.String r7, kotlin.coroutines.Continuation<? super com.stripe.android.model.Token> r8) throws com.stripe.android.core.exception.AuthenticationException, com.stripe.android.core.exception.InvalidRequestException, com.stripe.android.core.exception.APIConnectionException, com.stripe.android.core.exception.APIException {
        /*
            boolean r0 = r8 instanceof com.stripe.android.StripeKtxKt$createBankAccountToken$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.stripe.android.StripeKtxKt$createBankAccountToken$1 r0 = (com.stripe.android.StripeKtxKt$createBankAccountToken$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.stripe.android.StripeKtxKt$createBankAccountToken$1 r0 = new com.stripe.android.StripeKtxKt$createBankAccountToken$1
            r0.<init>(r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x0080 }
            goto L_0x004f
        L_0x002a:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.Result$Companion r8 = kotlin.Result.Companion     // Catch:{ all -> 0x0080 }
            com.stripe.android.networking.StripeRepository r8 = r4.getStripeRepository$payments_core_release()     // Catch:{ all -> 0x0080 }
            com.stripe.android.model.TokenParams r5 = (com.stripe.android.model.TokenParams) r5     // Catch:{ all -> 0x0080 }
            com.stripe.android.core.networking.ApiRequest$Options r2 = new com.stripe.android.core.networking.ApiRequest$Options     // Catch:{ all -> 0x0080 }
            java.lang.String r4 = r4.getPublishableKey$payments_core_release()     // Catch:{ all -> 0x0080 }
            r2.<init>(r4, r7, r6)     // Catch:{ all -> 0x0080 }
            r0.label = r3     // Catch:{ all -> 0x0080 }
            java.lang.Object r8 = r8.createToken$payments_core_release(r5, r2, r0)     // Catch:{ all -> 0x0080 }
            if (r8 != r1) goto L_0x004f
            return r1
        L_0x004f:
            com.stripe.android.model.Token r8 = (com.stripe.android.model.Token) r8     // Catch:{ all -> 0x0080 }
            if (r8 == 0) goto L_0x005a
            com.stripe.android.core.model.StripeModel r8 = (com.stripe.android.core.model.StripeModel) r8     // Catch:{ all -> 0x0080 }
            java.lang.Object r4 = kotlin.Result.m4709constructorimpl(r8)     // Catch:{ all -> 0x0080 }
            goto L_0x008b
        L_0x005a:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0080 }
            r4.<init>()     // Catch:{ all -> 0x0080 }
            java.lang.String r5 = "Failed to parse "
            r4.append(r5)     // Catch:{ all -> 0x0080 }
            java.lang.Class<com.stripe.android.model.Token> r5 = com.stripe.android.model.Token.class
            java.lang.String r5 = r5.getSimpleName()     // Catch:{ all -> 0x0080 }
            r4.append(r5)     // Catch:{ all -> 0x0080 }
            r5 = 46
            r4.append(r5)     // Catch:{ all -> 0x0080 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0080 }
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0080 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0080 }
            r5.<init>(r4)     // Catch:{ all -> 0x0080 }
            throw r5     // Catch:{ all -> 0x0080 }
        L_0x0080:
            r4 = move-exception
            kotlin.Result$Companion r5 = kotlin.Result.Companion
            java.lang.Object r4 = kotlin.ResultKt.createFailure(r4)
            java.lang.Object r4 = kotlin.Result.m4709constructorimpl(r4)
        L_0x008b:
            java.lang.Throwable r5 = kotlin.Result.m4712exceptionOrNullimpl(r4)
            if (r5 != 0) goto L_0x0094
            com.stripe.android.core.model.StripeModel r4 = (com.stripe.android.core.model.StripeModel) r4
            return r4
        L_0x0094:
            com.stripe.android.core.exception.StripeException$Companion r4 = com.stripe.android.core.exception.StripeException.Companion
            com.stripe.android.core.exception.StripeException r4 = r4.create(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.StripeKtxKt.createBankAccountToken(com.stripe.android.Stripe, com.stripe.android.model.BankAccountTokenParams, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object createBankAccountToken$default(Stripe stripe, BankAccountTokenParams bankAccountTokenParams, String str, String str2, Continuation continuation, int i, Object obj) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = stripe.getStripeAccountId$payments_core_release();
        }
        return createBankAccountToken(stripe, bankAccountTokenParams, str, str2, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0058 A[Catch:{ all -> 0x0085 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005f A[Catch:{ all -> 0x0085 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object createPiiToken(com.stripe.android.Stripe r4, java.lang.String r5, java.lang.String r6, java.lang.String r7, kotlin.coroutines.Continuation<? super com.stripe.android.model.Token> r8) throws com.stripe.android.core.exception.AuthenticationException, com.stripe.android.core.exception.InvalidRequestException, com.stripe.android.core.exception.APIConnectionException, com.stripe.android.core.exception.APIException {
        /*
            boolean r0 = r8 instanceof com.stripe.android.StripeKtxKt$createPiiToken$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.stripe.android.StripeKtxKt$createPiiToken$1 r0 = (com.stripe.android.StripeKtxKt$createPiiToken$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.stripe.android.StripeKtxKt$createPiiToken$1 r0 = new com.stripe.android.StripeKtxKt$createPiiToken$1
            r0.<init>(r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x0085 }
            goto L_0x0054
        L_0x002a:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.Result$Companion r8 = kotlin.Result.Companion     // Catch:{ all -> 0x0085 }
            com.stripe.android.networking.StripeRepository r8 = r4.getStripeRepository$payments_core_release()     // Catch:{ all -> 0x0085 }
            com.stripe.android.model.PiiTokenParams r2 = new com.stripe.android.model.PiiTokenParams     // Catch:{ all -> 0x0085 }
            r2.<init>(r5)     // Catch:{ all -> 0x0085 }
            com.stripe.android.model.TokenParams r2 = (com.stripe.android.model.TokenParams) r2     // Catch:{ all -> 0x0085 }
            com.stripe.android.core.networking.ApiRequest$Options r5 = new com.stripe.android.core.networking.ApiRequest$Options     // Catch:{ all -> 0x0085 }
            java.lang.String r4 = r4.getPublishableKey$payments_core_release()     // Catch:{ all -> 0x0085 }
            r5.<init>(r4, r7, r6)     // Catch:{ all -> 0x0085 }
            r0.label = r3     // Catch:{ all -> 0x0085 }
            java.lang.Object r8 = r8.createToken$payments_core_release(r2, r5, r0)     // Catch:{ all -> 0x0085 }
            if (r8 != r1) goto L_0x0054
            return r1
        L_0x0054:
            com.stripe.android.model.Token r8 = (com.stripe.android.model.Token) r8     // Catch:{ all -> 0x0085 }
            if (r8 == 0) goto L_0x005f
            com.stripe.android.core.model.StripeModel r8 = (com.stripe.android.core.model.StripeModel) r8     // Catch:{ all -> 0x0085 }
            java.lang.Object r4 = kotlin.Result.m4709constructorimpl(r8)     // Catch:{ all -> 0x0085 }
            goto L_0x0090
        L_0x005f:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0085 }
            r4.<init>()     // Catch:{ all -> 0x0085 }
            java.lang.String r5 = "Failed to parse "
            r4.append(r5)     // Catch:{ all -> 0x0085 }
            java.lang.Class<com.stripe.android.model.Token> r5 = com.stripe.android.model.Token.class
            java.lang.String r5 = r5.getSimpleName()     // Catch:{ all -> 0x0085 }
            r4.append(r5)     // Catch:{ all -> 0x0085 }
            r5 = 46
            r4.append(r5)     // Catch:{ all -> 0x0085 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0085 }
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0085 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0085 }
            r5.<init>(r4)     // Catch:{ all -> 0x0085 }
            throw r5     // Catch:{ all -> 0x0085 }
        L_0x0085:
            r4 = move-exception
            kotlin.Result$Companion r5 = kotlin.Result.Companion
            java.lang.Object r4 = kotlin.ResultKt.createFailure(r4)
            java.lang.Object r4 = kotlin.Result.m4709constructorimpl(r4)
        L_0x0090:
            java.lang.Throwable r5 = kotlin.Result.m4712exceptionOrNullimpl(r4)
            if (r5 != 0) goto L_0x0099
            com.stripe.android.core.model.StripeModel r4 = (com.stripe.android.core.model.StripeModel) r4
            return r4
        L_0x0099:
            com.stripe.android.core.exception.StripeException$Companion r4 = com.stripe.android.core.exception.StripeException.Companion
            com.stripe.android.core.exception.StripeException r4 = r4.create(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.StripeKtxKt.createPiiToken(com.stripe.android.Stripe, java.lang.String, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object createPiiToken$default(Stripe stripe, String str, String str2, String str3, Continuation continuation, int i, Object obj) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = stripe.getStripeAccountId$payments_core_release();
        }
        return createPiiToken(stripe, str, str2, str3, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0053 A[Catch:{ all -> 0x0080 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005a A[Catch:{ all -> 0x0080 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object createCardToken(com.stripe.android.Stripe r4, com.stripe.android.model.CardParams r5, java.lang.String r6, java.lang.String r7, kotlin.coroutines.Continuation<? super com.stripe.android.model.Token> r8) throws com.stripe.android.core.exception.AuthenticationException, com.stripe.android.core.exception.InvalidRequestException, com.stripe.android.core.exception.APIConnectionException, com.stripe.android.core.exception.APIException, com.stripe.android.exception.CardException {
        /*
            boolean r0 = r8 instanceof com.stripe.android.StripeKtxKt$createCardToken$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.stripe.android.StripeKtxKt$createCardToken$1 r0 = (com.stripe.android.StripeKtxKt$createCardToken$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.stripe.android.StripeKtxKt$createCardToken$1 r0 = new com.stripe.android.StripeKtxKt$createCardToken$1
            r0.<init>(r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x0080 }
            goto L_0x004f
        L_0x002a:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.Result$Companion r8 = kotlin.Result.Companion     // Catch:{ all -> 0x0080 }
            com.stripe.android.networking.StripeRepository r8 = r4.getStripeRepository$payments_core_release()     // Catch:{ all -> 0x0080 }
            com.stripe.android.model.TokenParams r5 = (com.stripe.android.model.TokenParams) r5     // Catch:{ all -> 0x0080 }
            com.stripe.android.core.networking.ApiRequest$Options r2 = new com.stripe.android.core.networking.ApiRequest$Options     // Catch:{ all -> 0x0080 }
            java.lang.String r4 = r4.getPublishableKey$payments_core_release()     // Catch:{ all -> 0x0080 }
            r2.<init>(r4, r7, r6)     // Catch:{ all -> 0x0080 }
            r0.label = r3     // Catch:{ all -> 0x0080 }
            java.lang.Object r8 = r8.createToken$payments_core_release(r5, r2, r0)     // Catch:{ all -> 0x0080 }
            if (r8 != r1) goto L_0x004f
            return r1
        L_0x004f:
            com.stripe.android.model.Token r8 = (com.stripe.android.model.Token) r8     // Catch:{ all -> 0x0080 }
            if (r8 == 0) goto L_0x005a
            com.stripe.android.core.model.StripeModel r8 = (com.stripe.android.core.model.StripeModel) r8     // Catch:{ all -> 0x0080 }
            java.lang.Object r4 = kotlin.Result.m4709constructorimpl(r8)     // Catch:{ all -> 0x0080 }
            goto L_0x008b
        L_0x005a:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0080 }
            r4.<init>()     // Catch:{ all -> 0x0080 }
            java.lang.String r5 = "Failed to parse "
            r4.append(r5)     // Catch:{ all -> 0x0080 }
            java.lang.Class<com.stripe.android.model.Token> r5 = com.stripe.android.model.Token.class
            java.lang.String r5 = r5.getSimpleName()     // Catch:{ all -> 0x0080 }
            r4.append(r5)     // Catch:{ all -> 0x0080 }
            r5 = 46
            r4.append(r5)     // Catch:{ all -> 0x0080 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0080 }
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0080 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0080 }
            r5.<init>(r4)     // Catch:{ all -> 0x0080 }
            throw r5     // Catch:{ all -> 0x0080 }
        L_0x0080:
            r4 = move-exception
            kotlin.Result$Companion r5 = kotlin.Result.Companion
            java.lang.Object r4 = kotlin.ResultKt.createFailure(r4)
            java.lang.Object r4 = kotlin.Result.m4709constructorimpl(r4)
        L_0x008b:
            java.lang.Throwable r5 = kotlin.Result.m4712exceptionOrNullimpl(r4)
            if (r5 != 0) goto L_0x0094
            com.stripe.android.core.model.StripeModel r4 = (com.stripe.android.core.model.StripeModel) r4
            return r4
        L_0x0094:
            com.stripe.android.core.exception.StripeException$Companion r4 = com.stripe.android.core.exception.StripeException.Companion
            com.stripe.android.core.exception.StripeException r4 = r4.create(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.StripeKtxKt.createCardToken(com.stripe.android.Stripe, com.stripe.android.model.CardParams, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object createCardToken$default(Stripe stripe, CardParams cardParams, String str, String str2, Continuation continuation, int i, Object obj) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException, CardException {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = stripe.getStripeAccountId$payments_core_release();
        }
        return createCardToken(stripe, cardParams, str, str2, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0058 A[Catch:{ all -> 0x0085 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005f A[Catch:{ all -> 0x0085 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object createCvcUpdateToken(com.stripe.android.Stripe r4, java.lang.String r5, java.lang.String r6, java.lang.String r7, kotlin.coroutines.Continuation<? super com.stripe.android.model.Token> r8) throws com.stripe.android.core.exception.AuthenticationException, com.stripe.android.core.exception.InvalidRequestException, com.stripe.android.core.exception.APIConnectionException, com.stripe.android.core.exception.APIException {
        /*
            boolean r0 = r8 instanceof com.stripe.android.StripeKtxKt$createCvcUpdateToken$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.stripe.android.StripeKtxKt$createCvcUpdateToken$1 r0 = (com.stripe.android.StripeKtxKt$createCvcUpdateToken$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.stripe.android.StripeKtxKt$createCvcUpdateToken$1 r0 = new com.stripe.android.StripeKtxKt$createCvcUpdateToken$1
            r0.<init>(r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x0085 }
            goto L_0x0054
        L_0x002a:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.Result$Companion r8 = kotlin.Result.Companion     // Catch:{ all -> 0x0085 }
            com.stripe.android.networking.StripeRepository r8 = r4.getStripeRepository$payments_core_release()     // Catch:{ all -> 0x0085 }
            com.stripe.android.model.CvcTokenParams r2 = new com.stripe.android.model.CvcTokenParams     // Catch:{ all -> 0x0085 }
            r2.<init>(r5)     // Catch:{ all -> 0x0085 }
            com.stripe.android.model.TokenParams r2 = (com.stripe.android.model.TokenParams) r2     // Catch:{ all -> 0x0085 }
            com.stripe.android.core.networking.ApiRequest$Options r5 = new com.stripe.android.core.networking.ApiRequest$Options     // Catch:{ all -> 0x0085 }
            java.lang.String r4 = r4.getPublishableKey$payments_core_release()     // Catch:{ all -> 0x0085 }
            r5.<init>(r4, r7, r6)     // Catch:{ all -> 0x0085 }
            r0.label = r3     // Catch:{ all -> 0x0085 }
            java.lang.Object r8 = r8.createToken$payments_core_release(r2, r5, r0)     // Catch:{ all -> 0x0085 }
            if (r8 != r1) goto L_0x0054
            return r1
        L_0x0054:
            com.stripe.android.model.Token r8 = (com.stripe.android.model.Token) r8     // Catch:{ all -> 0x0085 }
            if (r8 == 0) goto L_0x005f
            com.stripe.android.core.model.StripeModel r8 = (com.stripe.android.core.model.StripeModel) r8     // Catch:{ all -> 0x0085 }
            java.lang.Object r4 = kotlin.Result.m4709constructorimpl(r8)     // Catch:{ all -> 0x0085 }
            goto L_0x0090
        L_0x005f:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0085 }
            r4.<init>()     // Catch:{ all -> 0x0085 }
            java.lang.String r5 = "Failed to parse "
            r4.append(r5)     // Catch:{ all -> 0x0085 }
            java.lang.Class<com.stripe.android.model.Token> r5 = com.stripe.android.model.Token.class
            java.lang.String r5 = r5.getSimpleName()     // Catch:{ all -> 0x0085 }
            r4.append(r5)     // Catch:{ all -> 0x0085 }
            r5 = 46
            r4.append(r5)     // Catch:{ all -> 0x0085 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0085 }
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0085 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0085 }
            r5.<init>(r4)     // Catch:{ all -> 0x0085 }
            throw r5     // Catch:{ all -> 0x0085 }
        L_0x0085:
            r4 = move-exception
            kotlin.Result$Companion r5 = kotlin.Result.Companion
            java.lang.Object r4 = kotlin.ResultKt.createFailure(r4)
            java.lang.Object r4 = kotlin.Result.m4709constructorimpl(r4)
        L_0x0090:
            java.lang.Throwable r5 = kotlin.Result.m4712exceptionOrNullimpl(r4)
            if (r5 != 0) goto L_0x0099
            com.stripe.android.core.model.StripeModel r4 = (com.stripe.android.core.model.StripeModel) r4
            return r4
        L_0x0099:
            com.stripe.android.core.exception.StripeException$Companion r4 = com.stripe.android.core.exception.StripeException.Companion
            com.stripe.android.core.exception.StripeException r4 = r4.create(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.StripeKtxKt.createCvcUpdateToken(com.stripe.android.Stripe, java.lang.String, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object createCvcUpdateToken$default(Stripe stripe, String str, String str2, String str3, Continuation continuation, int i, Object obj) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = stripe.getStripeAccountId$payments_core_release();
        }
        return createCvcUpdateToken(stripe, str, str2, str3, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0053 A[Catch:{ all -> 0x0080 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005a A[Catch:{ all -> 0x0080 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object createPersonToken(com.stripe.android.Stripe r4, com.stripe.android.model.PersonTokenParams r5, java.lang.String r6, java.lang.String r7, kotlin.coroutines.Continuation<? super com.stripe.android.model.Token> r8) throws com.stripe.android.core.exception.AuthenticationException, com.stripe.android.core.exception.InvalidRequestException, com.stripe.android.core.exception.APIConnectionException, com.stripe.android.core.exception.APIException {
        /*
            boolean r0 = r8 instanceof com.stripe.android.StripeKtxKt$createPersonToken$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.stripe.android.StripeKtxKt$createPersonToken$1 r0 = (com.stripe.android.StripeKtxKt$createPersonToken$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.stripe.android.StripeKtxKt$createPersonToken$1 r0 = new com.stripe.android.StripeKtxKt$createPersonToken$1
            r0.<init>(r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x0080 }
            goto L_0x004f
        L_0x002a:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.Result$Companion r8 = kotlin.Result.Companion     // Catch:{ all -> 0x0080 }
            com.stripe.android.networking.StripeRepository r8 = r4.getStripeRepository$payments_core_release()     // Catch:{ all -> 0x0080 }
            com.stripe.android.model.TokenParams r5 = (com.stripe.android.model.TokenParams) r5     // Catch:{ all -> 0x0080 }
            com.stripe.android.core.networking.ApiRequest$Options r2 = new com.stripe.android.core.networking.ApiRequest$Options     // Catch:{ all -> 0x0080 }
            java.lang.String r4 = r4.getPublishableKey$payments_core_release()     // Catch:{ all -> 0x0080 }
            r2.<init>(r4, r7, r6)     // Catch:{ all -> 0x0080 }
            r0.label = r3     // Catch:{ all -> 0x0080 }
            java.lang.Object r8 = r8.createToken$payments_core_release(r5, r2, r0)     // Catch:{ all -> 0x0080 }
            if (r8 != r1) goto L_0x004f
            return r1
        L_0x004f:
            com.stripe.android.model.Token r8 = (com.stripe.android.model.Token) r8     // Catch:{ all -> 0x0080 }
            if (r8 == 0) goto L_0x005a
            com.stripe.android.core.model.StripeModel r8 = (com.stripe.android.core.model.StripeModel) r8     // Catch:{ all -> 0x0080 }
            java.lang.Object r4 = kotlin.Result.m4709constructorimpl(r8)     // Catch:{ all -> 0x0080 }
            goto L_0x008b
        L_0x005a:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0080 }
            r4.<init>()     // Catch:{ all -> 0x0080 }
            java.lang.String r5 = "Failed to parse "
            r4.append(r5)     // Catch:{ all -> 0x0080 }
            java.lang.Class<com.stripe.android.model.Token> r5 = com.stripe.android.model.Token.class
            java.lang.String r5 = r5.getSimpleName()     // Catch:{ all -> 0x0080 }
            r4.append(r5)     // Catch:{ all -> 0x0080 }
            r5 = 46
            r4.append(r5)     // Catch:{ all -> 0x0080 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0080 }
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0080 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0080 }
            r5.<init>(r4)     // Catch:{ all -> 0x0080 }
            throw r5     // Catch:{ all -> 0x0080 }
        L_0x0080:
            r4 = move-exception
            kotlin.Result$Companion r5 = kotlin.Result.Companion
            java.lang.Object r4 = kotlin.ResultKt.createFailure(r4)
            java.lang.Object r4 = kotlin.Result.m4709constructorimpl(r4)
        L_0x008b:
            java.lang.Throwable r5 = kotlin.Result.m4712exceptionOrNullimpl(r4)
            if (r5 != 0) goto L_0x0094
            com.stripe.android.core.model.StripeModel r4 = (com.stripe.android.core.model.StripeModel) r4
            return r4
        L_0x0094:
            com.stripe.android.core.exception.StripeException$Companion r4 = com.stripe.android.core.exception.StripeException.Companion
            com.stripe.android.core.exception.StripeException r4 = r4.create(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.StripeKtxKt.createPersonToken(com.stripe.android.Stripe, com.stripe.android.model.PersonTokenParams, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object createPersonToken$default(Stripe stripe, PersonTokenParams personTokenParams, String str, String str2, Continuation continuation, int i, Object obj) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = stripe.getStripeAccountId$payments_core_release();
        }
        return createPersonToken(stripe, personTokenParams, str, str2, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0051 A[Catch:{ all -> 0x007e }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0058 A[Catch:{ all -> 0x007e }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object createFile(com.stripe.android.Stripe r4, com.stripe.android.core.model.StripeFileParams r5, java.lang.String r6, java.lang.String r7, kotlin.coroutines.Continuation<? super com.stripe.android.core.model.StripeFile> r8) throws com.stripe.android.core.exception.AuthenticationException, com.stripe.android.core.exception.InvalidRequestException, com.stripe.android.core.exception.APIConnectionException, com.stripe.android.core.exception.APIException, com.stripe.android.exception.CardException {
        /*
            boolean r0 = r8 instanceof com.stripe.android.StripeKtxKt$createFile$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.stripe.android.StripeKtxKt$createFile$1 r0 = (com.stripe.android.StripeKtxKt$createFile$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.stripe.android.StripeKtxKt$createFile$1 r0 = new com.stripe.android.StripeKtxKt$createFile$1
            r0.<init>(r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x007e }
            goto L_0x004d
        L_0x002a:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.Result$Companion r8 = kotlin.Result.Companion     // Catch:{ all -> 0x007e }
            com.stripe.android.networking.StripeRepository r8 = r4.getStripeRepository$payments_core_release()     // Catch:{ all -> 0x007e }
            com.stripe.android.core.networking.ApiRequest$Options r2 = new com.stripe.android.core.networking.ApiRequest$Options     // Catch:{ all -> 0x007e }
            java.lang.String r4 = r4.getPublishableKey$payments_core_release()     // Catch:{ all -> 0x007e }
            r2.<init>(r4, r7, r6)     // Catch:{ all -> 0x007e }
            r0.label = r3     // Catch:{ all -> 0x007e }
            java.lang.Object r8 = r8.createFile$payments_core_release(r5, r2, r0)     // Catch:{ all -> 0x007e }
            if (r8 != r1) goto L_0x004d
            return r1
        L_0x004d:
            com.stripe.android.core.model.StripeFile r8 = (com.stripe.android.core.model.StripeFile) r8     // Catch:{ all -> 0x007e }
            if (r8 == 0) goto L_0x0058
            com.stripe.android.core.model.StripeModel r8 = (com.stripe.android.core.model.StripeModel) r8     // Catch:{ all -> 0x007e }
            java.lang.Object r4 = kotlin.Result.m4709constructorimpl(r8)     // Catch:{ all -> 0x007e }
            goto L_0x0089
        L_0x0058:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x007e }
            r4.<init>()     // Catch:{ all -> 0x007e }
            java.lang.String r5 = "Failed to parse "
            r4.append(r5)     // Catch:{ all -> 0x007e }
            java.lang.Class<com.stripe.android.core.model.StripeFile> r5 = com.stripe.android.core.model.StripeFile.class
            java.lang.String r5 = r5.getSimpleName()     // Catch:{ all -> 0x007e }
            r4.append(r5)     // Catch:{ all -> 0x007e }
            r5 = 46
            r4.append(r5)     // Catch:{ all -> 0x007e }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x007e }
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x007e }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x007e }
            r5.<init>(r4)     // Catch:{ all -> 0x007e }
            throw r5     // Catch:{ all -> 0x007e }
        L_0x007e:
            r4 = move-exception
            kotlin.Result$Companion r5 = kotlin.Result.Companion
            java.lang.Object r4 = kotlin.ResultKt.createFailure(r4)
            java.lang.Object r4 = kotlin.Result.m4709constructorimpl(r4)
        L_0x0089:
            java.lang.Throwable r5 = kotlin.Result.m4712exceptionOrNullimpl(r4)
            if (r5 != 0) goto L_0x0092
            com.stripe.android.core.model.StripeModel r4 = (com.stripe.android.core.model.StripeModel) r4
            return r4
        L_0x0092:
            com.stripe.android.core.exception.StripeException$Companion r4 = com.stripe.android.core.exception.StripeException.Companion
            com.stripe.android.core.exception.StripeException r4 = r4.create(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.StripeKtxKt.createFile(com.stripe.android.Stripe, com.stripe.android.core.model.StripeFileParams, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object createFile$default(Stripe stripe, StripeFileParams stripeFileParams, String str, String str2, Continuation continuation, int i, Object obj) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException, CardException {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = stripe.getStripeAccountId$payments_core_release();
        }
        return createFile(stripe, stripeFileParams, str, str2, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0059 A[Catch:{ all -> 0x0086 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0060 A[Catch:{ all -> 0x0086 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object createRadarSession(com.stripe.android.Stripe r10, kotlin.coroutines.Continuation<? super com.stripe.android.model.RadarSession> r11) throws com.stripe.android.core.exception.AuthenticationException, com.stripe.android.core.exception.InvalidRequestException, com.stripe.android.core.exception.APIConnectionException, com.stripe.android.core.exception.APIException {
        /*
            boolean r0 = r11 instanceof com.stripe.android.StripeKtxKt$createRadarSession$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            com.stripe.android.StripeKtxKt$createRadarSession$1 r0 = (com.stripe.android.StripeKtxKt$createRadarSession$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            com.stripe.android.StripeKtxKt$createRadarSession$1 r0 = new com.stripe.android.StripeKtxKt$createRadarSession$1
            r0.<init>(r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x0086 }
            goto L_0x0055
        L_0x002a:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r11)
            kotlin.Result$Companion r11 = kotlin.Result.Companion     // Catch:{ all -> 0x0086 }
            com.stripe.android.networking.StripeRepository r11 = r10.getStripeRepository$payments_core_release()     // Catch:{ all -> 0x0086 }
            com.stripe.android.core.networking.ApiRequest$Options r2 = new com.stripe.android.core.networking.ApiRequest$Options     // Catch:{ all -> 0x0086 }
            java.lang.String r5 = r10.getPublishableKey$payments_core_release()     // Catch:{ all -> 0x0086 }
            java.lang.String r6 = r10.getStripeAccountId$payments_core_release()     // Catch:{ all -> 0x0086 }
            r7 = 0
            r8 = 4
            r9 = 0
            r4 = r2
            r4.<init>(r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0086 }
            r0.label = r3     // Catch:{ all -> 0x0086 }
            java.lang.Object r11 = r11.createRadarSession$payments_core_release(r2, r0)     // Catch:{ all -> 0x0086 }
            if (r11 != r1) goto L_0x0055
            return r1
        L_0x0055:
            com.stripe.android.model.RadarSession r11 = (com.stripe.android.model.RadarSession) r11     // Catch:{ all -> 0x0086 }
            if (r11 == 0) goto L_0x0060
            com.stripe.android.core.model.StripeModel r11 = (com.stripe.android.core.model.StripeModel) r11     // Catch:{ all -> 0x0086 }
            java.lang.Object r10 = kotlin.Result.m4709constructorimpl(r11)     // Catch:{ all -> 0x0086 }
            goto L_0x0091
        L_0x0060:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0086 }
            r10.<init>()     // Catch:{ all -> 0x0086 }
            java.lang.String r11 = "Failed to parse "
            r10.append(r11)     // Catch:{ all -> 0x0086 }
            java.lang.Class<com.stripe.android.model.RadarSession> r11 = com.stripe.android.model.RadarSession.class
            java.lang.String r11 = r11.getSimpleName()     // Catch:{ all -> 0x0086 }
            r10.append(r11)     // Catch:{ all -> 0x0086 }
            r11 = 46
            r10.append(r11)     // Catch:{ all -> 0x0086 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x0086 }
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0086 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x0086 }
            r11.<init>(r10)     // Catch:{ all -> 0x0086 }
            throw r11     // Catch:{ all -> 0x0086 }
        L_0x0086:
            r10 = move-exception
            kotlin.Result$Companion r11 = kotlin.Result.Companion
            java.lang.Object r10 = kotlin.ResultKt.createFailure(r10)
            java.lang.Object r10 = kotlin.Result.m4709constructorimpl(r10)
        L_0x0091:
            java.lang.Throwable r11 = kotlin.Result.m4712exceptionOrNullimpl(r10)
            if (r11 != 0) goto L_0x009a
            com.stripe.android.core.model.StripeModel r10 = (com.stripe.android.core.model.StripeModel) r10
            return r10
        L_0x009a:
            com.stripe.android.core.exception.StripeException$Companion r10 = com.stripe.android.core.exception.StripeException.Companion
            com.stripe.android.core.exception.StripeException r10 = r10.create(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.StripeKtxKt.createRadarSession(com.stripe.android.Stripe, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005b A[Catch:{ all -> 0x0088 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0062 A[Catch:{ all -> 0x0088 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object retrievePaymentIntent(com.stripe.android.Stripe r12, java.lang.String r13, java.lang.String r14, kotlin.coroutines.Continuation<? super com.stripe.android.model.PaymentIntent> r15) throws com.stripe.android.core.exception.AuthenticationException, com.stripe.android.core.exception.InvalidRequestException, com.stripe.android.core.exception.APIConnectionException, com.stripe.android.core.exception.APIException {
        /*
            boolean r0 = r15 instanceof com.stripe.android.StripeKtxKt$retrievePaymentIntent$1
            if (r0 == 0) goto L_0x0014
            r0 = r15
            com.stripe.android.StripeKtxKt$retrievePaymentIntent$1 r0 = (com.stripe.android.StripeKtxKt$retrievePaymentIntent$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L_0x0019
        L_0x0014:
            com.stripe.android.StripeKtxKt$retrievePaymentIntent$1 r0 = new com.stripe.android.StripeKtxKt$retrievePaymentIntent$1
            r0.<init>(r15)
        L_0x0019:
            r5 = r0
            java.lang.Object r15 = r5.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 1
            if (r1 == 0) goto L_0x0033
            if (r1 != r2) goto L_0x002b
            kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ all -> 0x0088 }
            goto L_0x0057
        L_0x002b:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0033:
            kotlin.ResultKt.throwOnFailure(r15)
            kotlin.Result$Companion r15 = kotlin.Result.Companion     // Catch:{ all -> 0x0088 }
            com.stripe.android.networking.StripeRepository r1 = r12.getStripeRepository$payments_core_release()     // Catch:{ all -> 0x0088 }
            com.stripe.android.core.networking.ApiRequest$Options r3 = new com.stripe.android.core.networking.ApiRequest$Options     // Catch:{ all -> 0x0088 }
            java.lang.String r7 = r12.getPublishableKey$payments_core_release()     // Catch:{ all -> 0x0088 }
            r9 = 0
            r10 = 4
            r11 = 0
            r6 = r3
            r8 = r14
            r6.<init>(r7, r8, r9, r10, r11)     // Catch:{ all -> 0x0088 }
            r4 = 0
            r6 = 4
            r7 = 0
            r5.label = r2     // Catch:{ all -> 0x0088 }
            r2 = r13
            java.lang.Object r15 = com.stripe.android.networking.StripeRepository.retrievePaymentIntent$default(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0088 }
            if (r15 != r0) goto L_0x0057
            return r0
        L_0x0057:
            com.stripe.android.model.PaymentIntent r15 = (com.stripe.android.model.PaymentIntent) r15     // Catch:{ all -> 0x0088 }
            if (r15 == 0) goto L_0x0062
            com.stripe.android.core.model.StripeModel r15 = (com.stripe.android.core.model.StripeModel) r15     // Catch:{ all -> 0x0088 }
            java.lang.Object r12 = kotlin.Result.m4709constructorimpl(r15)     // Catch:{ all -> 0x0088 }
            goto L_0x0093
        L_0x0062:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0088 }
            r12.<init>()     // Catch:{ all -> 0x0088 }
            java.lang.String r13 = "Failed to parse "
            r12.append(r13)     // Catch:{ all -> 0x0088 }
            java.lang.Class<com.stripe.android.model.PaymentIntent> r13 = com.stripe.android.model.PaymentIntent.class
            java.lang.String r13 = r13.getSimpleName()     // Catch:{ all -> 0x0088 }
            r12.append(r13)     // Catch:{ all -> 0x0088 }
            r13 = 46
            r12.append(r13)     // Catch:{ all -> 0x0088 }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x0088 }
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0088 }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x0088 }
            r13.<init>(r12)     // Catch:{ all -> 0x0088 }
            throw r13     // Catch:{ all -> 0x0088 }
        L_0x0088:
            r12 = move-exception
            kotlin.Result$Companion r13 = kotlin.Result.Companion
            java.lang.Object r12 = kotlin.ResultKt.createFailure(r12)
            java.lang.Object r12 = kotlin.Result.m4709constructorimpl(r12)
        L_0x0093:
            java.lang.Throwable r13 = kotlin.Result.m4712exceptionOrNullimpl(r12)
            if (r13 != 0) goto L_0x009c
            com.stripe.android.core.model.StripeModel r12 = (com.stripe.android.core.model.StripeModel) r12
            return r12
        L_0x009c:
            com.stripe.android.core.exception.StripeException$Companion r12 = com.stripe.android.core.exception.StripeException.Companion
            com.stripe.android.core.exception.StripeException r12 = r12.create(r13)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.StripeKtxKt.retrievePaymentIntent(com.stripe.android.Stripe, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object retrievePaymentIntent$default(Stripe stripe, String str, String str2, Continuation continuation, int i, Object obj) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException {
        if ((i & 2) != 0) {
            str2 = stripe.getStripeAccountId$payments_core_release();
        }
        return retrievePaymentIntent(stripe, str, str2, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005b A[Catch:{ all -> 0x0088 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0062 A[Catch:{ all -> 0x0088 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object retrieveSetupIntent(com.stripe.android.Stripe r12, java.lang.String r13, java.lang.String r14, kotlin.coroutines.Continuation<? super com.stripe.android.model.SetupIntent> r15) throws com.stripe.android.core.exception.AuthenticationException, com.stripe.android.core.exception.InvalidRequestException, com.stripe.android.core.exception.APIConnectionException, com.stripe.android.core.exception.APIException {
        /*
            boolean r0 = r15 instanceof com.stripe.android.StripeKtxKt$retrieveSetupIntent$1
            if (r0 == 0) goto L_0x0014
            r0 = r15
            com.stripe.android.StripeKtxKt$retrieveSetupIntent$1 r0 = (com.stripe.android.StripeKtxKt$retrieveSetupIntent$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L_0x0019
        L_0x0014:
            com.stripe.android.StripeKtxKt$retrieveSetupIntent$1 r0 = new com.stripe.android.StripeKtxKt$retrieveSetupIntent$1
            r0.<init>(r15)
        L_0x0019:
            r5 = r0
            java.lang.Object r15 = r5.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 1
            if (r1 == 0) goto L_0x0033
            if (r1 != r2) goto L_0x002b
            kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ all -> 0x0088 }
            goto L_0x0057
        L_0x002b:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0033:
            kotlin.ResultKt.throwOnFailure(r15)
            kotlin.Result$Companion r15 = kotlin.Result.Companion     // Catch:{ all -> 0x0088 }
            com.stripe.android.networking.StripeRepository r1 = r12.getStripeRepository$payments_core_release()     // Catch:{ all -> 0x0088 }
            com.stripe.android.core.networking.ApiRequest$Options r3 = new com.stripe.android.core.networking.ApiRequest$Options     // Catch:{ all -> 0x0088 }
            java.lang.String r7 = r12.getPublishableKey$payments_core_release()     // Catch:{ all -> 0x0088 }
            r9 = 0
            r10 = 4
            r11 = 0
            r6 = r3
            r8 = r14
            r6.<init>(r7, r8, r9, r10, r11)     // Catch:{ all -> 0x0088 }
            r4 = 0
            r6 = 4
            r7 = 0
            r5.label = r2     // Catch:{ all -> 0x0088 }
            r2 = r13
            java.lang.Object r15 = com.stripe.android.networking.StripeRepository.retrieveSetupIntent$default(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0088 }
            if (r15 != r0) goto L_0x0057
            return r0
        L_0x0057:
            com.stripe.android.model.SetupIntent r15 = (com.stripe.android.model.SetupIntent) r15     // Catch:{ all -> 0x0088 }
            if (r15 == 0) goto L_0x0062
            com.stripe.android.core.model.StripeModel r15 = (com.stripe.android.core.model.StripeModel) r15     // Catch:{ all -> 0x0088 }
            java.lang.Object r12 = kotlin.Result.m4709constructorimpl(r15)     // Catch:{ all -> 0x0088 }
            goto L_0x0093
        L_0x0062:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0088 }
            r12.<init>()     // Catch:{ all -> 0x0088 }
            java.lang.String r13 = "Failed to parse "
            r12.append(r13)     // Catch:{ all -> 0x0088 }
            java.lang.Class<com.stripe.android.model.SetupIntent> r13 = com.stripe.android.model.SetupIntent.class
            java.lang.String r13 = r13.getSimpleName()     // Catch:{ all -> 0x0088 }
            r12.append(r13)     // Catch:{ all -> 0x0088 }
            r13 = 46
            r12.append(r13)     // Catch:{ all -> 0x0088 }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x0088 }
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0088 }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x0088 }
            r13.<init>(r12)     // Catch:{ all -> 0x0088 }
            throw r13     // Catch:{ all -> 0x0088 }
        L_0x0088:
            r12 = move-exception
            kotlin.Result$Companion r13 = kotlin.Result.Companion
            java.lang.Object r12 = kotlin.ResultKt.createFailure(r12)
            java.lang.Object r12 = kotlin.Result.m4709constructorimpl(r12)
        L_0x0093:
            java.lang.Throwable r13 = kotlin.Result.m4712exceptionOrNullimpl(r12)
            if (r13 != 0) goto L_0x009c
            com.stripe.android.core.model.StripeModel r12 = (com.stripe.android.core.model.StripeModel) r12
            return r12
        L_0x009c:
            com.stripe.android.core.exception.StripeException$Companion r12 = com.stripe.android.core.exception.StripeException.Companion
            com.stripe.android.core.exception.StripeException r12 = r12.create(r13)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.StripeKtxKt.retrieveSetupIntent(com.stripe.android.Stripe, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object retrieveSetupIntent$default(Stripe stripe, String str, String str2, Continuation continuation, int i, Object obj) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException {
        if ((i & 2) != 0) {
            str2 = stripe.getStripeAccountId$payments_core_release();
        }
        return retrieveSetupIntent(stripe, str, str2, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0056 A[Catch:{ all -> 0x0083 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005d A[Catch:{ all -> 0x0083 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object retrieveSource(com.stripe.android.Stripe r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, kotlin.coroutines.Continuation<? super com.stripe.android.model.Source> r14) throws com.stripe.android.core.exception.AuthenticationException, com.stripe.android.core.exception.InvalidRequestException, com.stripe.android.core.exception.APIConnectionException, com.stripe.android.core.exception.APIException {
        /*
            boolean r0 = r14 instanceof com.stripe.android.StripeKtxKt$retrieveSource$1
            if (r0 == 0) goto L_0x0014
            r0 = r14
            com.stripe.android.StripeKtxKt$retrieveSource$1 r0 = (com.stripe.android.StripeKtxKt$retrieveSource$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L_0x0019
        L_0x0014:
            com.stripe.android.StripeKtxKt$retrieveSource$1 r0 = new com.stripe.android.StripeKtxKt$retrieveSource$1
            r0.<init>(r14)
        L_0x0019:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ all -> 0x0083 }
            goto L_0x0052
        L_0x002a:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r14)
            kotlin.Result$Companion r14 = kotlin.Result.Companion     // Catch:{ all -> 0x0083 }
            com.stripe.android.networking.StripeRepository r14 = r10.getStripeRepository$payments_core_release()     // Catch:{ all -> 0x0083 }
            com.stripe.android.core.networking.ApiRequest$Options r2 = new com.stripe.android.core.networking.ApiRequest$Options     // Catch:{ all -> 0x0083 }
            java.lang.String r5 = r10.getPublishableKey$payments_core_release()     // Catch:{ all -> 0x0083 }
            r7 = 0
            r8 = 4
            r9 = 0
            r4 = r2
            r6 = r13
            r4.<init>(r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0083 }
            r0.label = r3     // Catch:{ all -> 0x0083 }
            java.lang.Object r14 = r14.retrieveSource$payments_core_release(r11, r12, r2, r0)     // Catch:{ all -> 0x0083 }
            if (r14 != r1) goto L_0x0052
            return r1
        L_0x0052:
            com.stripe.android.model.Source r14 = (com.stripe.android.model.Source) r14     // Catch:{ all -> 0x0083 }
            if (r14 == 0) goto L_0x005d
            com.stripe.android.core.model.StripeModel r14 = (com.stripe.android.core.model.StripeModel) r14     // Catch:{ all -> 0x0083 }
            java.lang.Object r10 = kotlin.Result.m4709constructorimpl(r14)     // Catch:{ all -> 0x0083 }
            goto L_0x008e
        L_0x005d:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0083 }
            r10.<init>()     // Catch:{ all -> 0x0083 }
            java.lang.String r11 = "Failed to parse "
            r10.append(r11)     // Catch:{ all -> 0x0083 }
            java.lang.Class<com.stripe.android.model.Source> r11 = com.stripe.android.model.Source.class
            java.lang.String r11 = r11.getSimpleName()     // Catch:{ all -> 0x0083 }
            r10.append(r11)     // Catch:{ all -> 0x0083 }
            r11 = 46
            r10.append(r11)     // Catch:{ all -> 0x0083 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x0083 }
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0083 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x0083 }
            r11.<init>(r10)     // Catch:{ all -> 0x0083 }
            throw r11     // Catch:{ all -> 0x0083 }
        L_0x0083:
            r10 = move-exception
            kotlin.Result$Companion r11 = kotlin.Result.Companion
            java.lang.Object r10 = kotlin.ResultKt.createFailure(r10)
            java.lang.Object r10 = kotlin.Result.m4709constructorimpl(r10)
        L_0x008e:
            java.lang.Throwable r11 = kotlin.Result.m4712exceptionOrNullimpl(r10)
            if (r11 != 0) goto L_0x0097
            com.stripe.android.core.model.StripeModel r10 = (com.stripe.android.core.model.StripeModel) r10
            return r10
        L_0x0097:
            com.stripe.android.core.exception.StripeException$Companion r10 = com.stripe.android.core.exception.StripeException.Companion
            com.stripe.android.core.exception.StripeException r10 = r10.create(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.StripeKtxKt.retrieveSource(com.stripe.android.Stripe, java.lang.String, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object retrieveSource$default(Stripe stripe, String str, String str2, String str3, Continuation continuation, int i, Object obj) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException {
        if ((i & 4) != 0) {
            str3 = stripe.getStripeAccountId$payments_core_release();
        }
        return retrieveSource(stripe, str, str2, str3, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005a A[Catch:{ all -> 0x0087 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0061 A[Catch:{ all -> 0x0087 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object confirmSetupIntent(com.stripe.android.Stripe r8, com.stripe.android.model.ConfirmSetupIntentParams r9, java.lang.String r10, kotlin.coroutines.Continuation<? super com.stripe.android.model.SetupIntent> r11) throws com.stripe.android.core.exception.AuthenticationException, com.stripe.android.core.exception.InvalidRequestException, com.stripe.android.core.exception.APIConnectionException, com.stripe.android.core.exception.APIException {
        /*
            boolean r0 = r11 instanceof com.stripe.android.StripeKtxKt$confirmSetupIntent$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            com.stripe.android.StripeKtxKt$confirmSetupIntent$1 r0 = (com.stripe.android.StripeKtxKt$confirmSetupIntent$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            com.stripe.android.StripeKtxKt$confirmSetupIntent$1 r0 = new com.stripe.android.StripeKtxKt$confirmSetupIntent$1
            r0.<init>(r11)
        L_0x0019:
            r5 = r0
            java.lang.Object r11 = r5.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 1
            if (r1 == 0) goto L_0x0033
            if (r1 != r2) goto L_0x002b
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x0087 }
            goto L_0x0056
        L_0x002b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0033:
            kotlin.ResultKt.throwOnFailure(r11)
            kotlin.Result$Companion r11 = kotlin.Result.Companion     // Catch:{ all -> 0x0087 }
            com.stripe.android.networking.StripeRepository r1 = r8.getStripeRepository$payments_core_release()     // Catch:{ all -> 0x0087 }
            com.stripe.android.core.networking.ApiRequest$Options r3 = new com.stripe.android.core.networking.ApiRequest$Options     // Catch:{ all -> 0x0087 }
            java.lang.String r11 = r8.getPublishableKey$payments_core_release()     // Catch:{ all -> 0x0087 }
            java.lang.String r8 = r8.getStripeAccountId$payments_core_release()     // Catch:{ all -> 0x0087 }
            r3.<init>(r11, r8, r10)     // Catch:{ all -> 0x0087 }
            r4 = 0
            r6 = 4
            r7 = 0
            r5.label = r2     // Catch:{ all -> 0x0087 }
            r2 = r9
            java.lang.Object r11 = com.stripe.android.networking.StripeRepository.confirmSetupIntent$payments_core_release$default(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0087 }
            if (r11 != r0) goto L_0x0056
            return r0
        L_0x0056:
            com.stripe.android.model.SetupIntent r11 = (com.stripe.android.model.SetupIntent) r11     // Catch:{ all -> 0x0087 }
            if (r11 == 0) goto L_0x0061
            com.stripe.android.core.model.StripeModel r11 = (com.stripe.android.core.model.StripeModel) r11     // Catch:{ all -> 0x0087 }
            java.lang.Object r8 = kotlin.Result.m4709constructorimpl(r11)     // Catch:{ all -> 0x0087 }
            goto L_0x0092
        L_0x0061:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0087 }
            r8.<init>()     // Catch:{ all -> 0x0087 }
            java.lang.String r9 = "Failed to parse "
            r8.append(r9)     // Catch:{ all -> 0x0087 }
            java.lang.Class<com.stripe.android.model.SetupIntent> r9 = com.stripe.android.model.SetupIntent.class
            java.lang.String r9 = r9.getSimpleName()     // Catch:{ all -> 0x0087 }
            r8.append(r9)     // Catch:{ all -> 0x0087 }
            r9 = 46
            r8.append(r9)     // Catch:{ all -> 0x0087 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0087 }
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0087 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0087 }
            r9.<init>(r8)     // Catch:{ all -> 0x0087 }
            throw r9     // Catch:{ all -> 0x0087 }
        L_0x0087:
            r8 = move-exception
            kotlin.Result$Companion r9 = kotlin.Result.Companion
            java.lang.Object r8 = kotlin.ResultKt.createFailure(r8)
            java.lang.Object r8 = kotlin.Result.m4709constructorimpl(r8)
        L_0x0092:
            java.lang.Throwable r9 = kotlin.Result.m4712exceptionOrNullimpl(r8)
            if (r9 != 0) goto L_0x009b
            com.stripe.android.core.model.StripeModel r8 = (com.stripe.android.core.model.StripeModel) r8
            return r8
        L_0x009b:
            com.stripe.android.core.exception.StripeException$Companion r8 = com.stripe.android.core.exception.StripeException.Companion
            com.stripe.android.core.exception.StripeException r8 = r8.create(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.StripeKtxKt.confirmSetupIntent(com.stripe.android.Stripe, com.stripe.android.model.ConfirmSetupIntentParams, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object confirmSetupIntent$default(Stripe stripe, ConfirmSetupIntentParams confirmSetupIntentParams, String str, Continuation continuation, int i, Object obj) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException {
        if ((i & 2) != 0) {
            str = null;
        }
        return confirmSetupIntent(stripe, confirmSetupIntentParams, str, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object confirmWeChatPayPayment(com.stripe.android.Stripe r10, com.stripe.android.model.ConfirmPaymentIntentParams r11, java.lang.String r12, kotlin.coroutines.Continuation<? super com.stripe.android.model.WeChatPayNextAction> r13) {
        /*
            boolean r0 = r13 instanceof com.stripe.android.StripeKtxKt$confirmWeChatPayPayment$1
            if (r0 == 0) goto L_0x0014
            r0 = r13
            com.stripe.android.StripeKtxKt$confirmWeChatPayPayment$1 r0 = (com.stripe.android.StripeKtxKt$confirmWeChatPayPayment$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L_0x0019
        L_0x0014:
            com.stripe.android.StripeKtxKt$confirmWeChatPayPayment$1 r0 = new com.stripe.android.StripeKtxKt$confirmWeChatPayPayment$1
            r0.<init>(r13)
        L_0x0019:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ all -> 0x0059 }
            goto L_0x0052
        L_0x002a:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r13)
            kotlin.Result$Companion r13 = kotlin.Result.Companion     // Catch:{ all -> 0x0059 }
            com.stripe.android.PaymentController r13 = r10.getPaymentController$payments_core_release()     // Catch:{ all -> 0x0059 }
            com.stripe.android.core.networking.ApiRequest$Options r2 = new com.stripe.android.core.networking.ApiRequest$Options     // Catch:{ all -> 0x0059 }
            java.lang.String r5 = r10.getPublishableKey$payments_core_release()     // Catch:{ all -> 0x0059 }
            r7 = 0
            r8 = 4
            r9 = 0
            r4 = r2
            r6 = r12
            r4.<init>(r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0059 }
            r0.label = r3     // Catch:{ all -> 0x0059 }
            java.lang.Object r13 = r13.confirmWeChatPay(r11, r2, r0)     // Catch:{ all -> 0x0059 }
            if (r13 != r1) goto L_0x0052
            return r1
        L_0x0052:
            com.stripe.android.model.WeChatPayNextAction r13 = (com.stripe.android.model.WeChatPayNextAction) r13     // Catch:{ all -> 0x0059 }
            java.lang.Object r10 = kotlin.Result.m4709constructorimpl(r13)     // Catch:{ all -> 0x0059 }
            goto L_0x0064
        L_0x0059:
            r10 = move-exception
            kotlin.Result$Companion r11 = kotlin.Result.Companion
            java.lang.Object r10 = kotlin.ResultKt.createFailure(r10)
            java.lang.Object r10 = kotlin.Result.m4709constructorimpl(r10)
        L_0x0064:
            java.lang.Throwable r11 = kotlin.Result.m4712exceptionOrNullimpl(r10)
            if (r11 != 0) goto L_0x006b
            return r10
        L_0x006b:
            com.stripe.android.core.exception.StripeException$Companion r10 = com.stripe.android.core.exception.StripeException.Companion
            com.stripe.android.core.exception.StripeException r10 = r10.create(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.StripeKtxKt.confirmWeChatPayPayment(com.stripe.android.Stripe, com.stripe.android.model.ConfirmPaymentIntentParams, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object confirmWeChatPayPayment$default(Stripe stripe, ConfirmPaymentIntentParams confirmPaymentIntentParams, String str, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            str = stripe.getStripeAccountId$payments_core_release();
        }
        return confirmWeChatPayPayment(stripe, confirmPaymentIntentParams, str, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005a A[Catch:{ all -> 0x0087 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0061 A[Catch:{ all -> 0x0087 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object confirmPaymentIntent(com.stripe.android.Stripe r8, com.stripe.android.model.ConfirmPaymentIntentParams r9, java.lang.String r10, kotlin.coroutines.Continuation<? super com.stripe.android.model.PaymentIntent> r11) throws com.stripe.android.core.exception.AuthenticationException, com.stripe.android.core.exception.InvalidRequestException, com.stripe.android.core.exception.APIConnectionException, com.stripe.android.core.exception.APIException {
        /*
            boolean r0 = r11 instanceof com.stripe.android.StripeKtxKt$confirmPaymentIntent$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            com.stripe.android.StripeKtxKt$confirmPaymentIntent$1 r0 = (com.stripe.android.StripeKtxKt$confirmPaymentIntent$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            com.stripe.android.StripeKtxKt$confirmPaymentIntent$1 r0 = new com.stripe.android.StripeKtxKt$confirmPaymentIntent$1
            r0.<init>(r11)
        L_0x0019:
            r5 = r0
            java.lang.Object r11 = r5.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 1
            if (r1 == 0) goto L_0x0033
            if (r1 != r2) goto L_0x002b
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x0087 }
            goto L_0x0056
        L_0x002b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0033:
            kotlin.ResultKt.throwOnFailure(r11)
            kotlin.Result$Companion r11 = kotlin.Result.Companion     // Catch:{ all -> 0x0087 }
            com.stripe.android.networking.StripeRepository r1 = r8.getStripeRepository$payments_core_release()     // Catch:{ all -> 0x0087 }
            com.stripe.android.core.networking.ApiRequest$Options r3 = new com.stripe.android.core.networking.ApiRequest$Options     // Catch:{ all -> 0x0087 }
            java.lang.String r11 = r8.getPublishableKey$payments_core_release()     // Catch:{ all -> 0x0087 }
            java.lang.String r8 = r8.getStripeAccountId$payments_core_release()     // Catch:{ all -> 0x0087 }
            r3.<init>(r11, r8, r10)     // Catch:{ all -> 0x0087 }
            r4 = 0
            r6 = 4
            r7 = 0
            r5.label = r2     // Catch:{ all -> 0x0087 }
            r2 = r9
            java.lang.Object r11 = com.stripe.android.networking.StripeRepository.confirmPaymentIntent$payments_core_release$default(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0087 }
            if (r11 != r0) goto L_0x0056
            return r0
        L_0x0056:
            com.stripe.android.model.PaymentIntent r11 = (com.stripe.android.model.PaymentIntent) r11     // Catch:{ all -> 0x0087 }
            if (r11 == 0) goto L_0x0061
            com.stripe.android.core.model.StripeModel r11 = (com.stripe.android.core.model.StripeModel) r11     // Catch:{ all -> 0x0087 }
            java.lang.Object r8 = kotlin.Result.m4709constructorimpl(r11)     // Catch:{ all -> 0x0087 }
            goto L_0x0092
        L_0x0061:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0087 }
            r8.<init>()     // Catch:{ all -> 0x0087 }
            java.lang.String r9 = "Failed to parse "
            r8.append(r9)     // Catch:{ all -> 0x0087 }
            java.lang.Class<com.stripe.android.model.PaymentIntent> r9 = com.stripe.android.model.PaymentIntent.class
            java.lang.String r9 = r9.getSimpleName()     // Catch:{ all -> 0x0087 }
            r8.append(r9)     // Catch:{ all -> 0x0087 }
            r9 = 46
            r8.append(r9)     // Catch:{ all -> 0x0087 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0087 }
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0087 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0087 }
            r9.<init>(r8)     // Catch:{ all -> 0x0087 }
            throw r9     // Catch:{ all -> 0x0087 }
        L_0x0087:
            r8 = move-exception
            kotlin.Result$Companion r9 = kotlin.Result.Companion
            java.lang.Object r8 = kotlin.ResultKt.createFailure(r8)
            java.lang.Object r8 = kotlin.Result.m4709constructorimpl(r8)
        L_0x0092:
            java.lang.Throwable r9 = kotlin.Result.m4712exceptionOrNullimpl(r8)
            if (r9 != 0) goto L_0x009b
            com.stripe.android.core.model.StripeModel r8 = (com.stripe.android.core.model.StripeModel) r8
            return r8
        L_0x009b:
            com.stripe.android.core.exception.StripeException$Companion r8 = com.stripe.android.core.exception.StripeException.Companion
            com.stripe.android.core.exception.StripeException r8 = r8.create(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.StripeKtxKt.confirmPaymentIntent(com.stripe.android.Stripe, com.stripe.android.model.ConfirmPaymentIntentParams, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object confirmPaymentIntent$default(Stripe stripe, ConfirmPaymentIntentParams confirmPaymentIntentParams, String str, Continuation continuation, int i, Object obj) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException {
        if ((i & 2) != 0) {
            str = null;
        }
        return confirmPaymentIntent(stripe, confirmPaymentIntentParams, str, continuation);
    }

    private static final /* synthetic */ <ApiObject extends StripeModel> ApiObject runApiRequest(Function0<? extends ApiObject> function0) {
        ApiObject apiobject;
        try {
            Result.Companion companion = Result.Companion;
            Object invoke = function0.invoke();
            if (invoke != null) {
                apiobject = Result.m4709constructorimpl((StripeModel) invoke);
                Throwable r0 = Result.m4712exceptionOrNullimpl(apiobject);
                if (r0 == null) {
                    return (StripeModel) apiobject;
                }
                throw StripeException.Companion.create(r0);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to parse ");
            Intrinsics.reifiedOperationMarker(4, "ApiObject");
            sb.append(StripeModel.class.getSimpleName());
            sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
            throw new IllegalArgumentException(sb.toString().toString());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            apiobject = Result.m4709constructorimpl(ResultKt.createFailure(th));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object getPaymentIntentResult(com.stripe.android.Stripe r4, int r5, android.content.Intent r6, kotlin.coroutines.Continuation<? super com.stripe.android.PaymentIntentResult> r7) throws com.stripe.android.core.exception.AuthenticationException, com.stripe.android.core.exception.InvalidRequestException, com.stripe.android.core.exception.APIConnectionException, com.stripe.android.core.exception.APIException {
        /*
            boolean r0 = r7 instanceof com.stripe.android.StripeKtxKt$getPaymentIntentResult$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.stripe.android.StripeKtxKt$getPaymentIntentResult$1 r0 = (com.stripe.android.StripeKtxKt$getPaymentIntentResult$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.stripe.android.StripeKtxKt$getPaymentIntentResult$1 r0 = new com.stripe.android.StripeKtxKt$getPaymentIntentResult$1
            r0.<init>(r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ all -> 0x0079 }
            goto L_0x004a
        L_0x002a:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r7)
            boolean r5 = r4.isPaymentResult(r5, r6)
            kotlin.Result$Companion r7 = kotlin.Result.Companion     // Catch:{ all -> 0x0079 }
            if (r5 == 0) goto L_0x0053
            com.stripe.android.PaymentController r4 = r4.getPaymentController$payments_core_release()     // Catch:{ all -> 0x0079 }
            r0.label = r3     // Catch:{ all -> 0x0079 }
            java.lang.Object r7 = r4.getPaymentIntentResult(r6, r0)     // Catch:{ all -> 0x0079 }
            if (r7 != r1) goto L_0x004a
            return r1
        L_0x004a:
            com.stripe.android.PaymentIntentResult r7 = (com.stripe.android.PaymentIntentResult) r7     // Catch:{ all -> 0x0079 }
            com.stripe.android.core.model.StripeModel r7 = (com.stripe.android.core.model.StripeModel) r7     // Catch:{ all -> 0x0079 }
            java.lang.Object r4 = kotlin.Result.m4709constructorimpl(r7)     // Catch:{ all -> 0x0079 }
            goto L_0x0084
        L_0x0053:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0079 }
            r4.<init>()     // Catch:{ all -> 0x0079 }
            java.lang.String r5 = "Incorrect requestCode and data for "
            r4.append(r5)     // Catch:{ all -> 0x0079 }
            java.lang.Class<com.stripe.android.PaymentIntentResult> r5 = com.stripe.android.PaymentIntentResult.class
            java.lang.String r5 = r5.getSimpleName()     // Catch:{ all -> 0x0079 }
            r4.append(r5)     // Catch:{ all -> 0x0079 }
            r5 = 46
            r4.append(r5)     // Catch:{ all -> 0x0079 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0079 }
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0079 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0079 }
            r5.<init>(r4)     // Catch:{ all -> 0x0079 }
            throw r5     // Catch:{ all -> 0x0079 }
        L_0x0079:
            r4 = move-exception
            kotlin.Result$Companion r5 = kotlin.Result.Companion
            java.lang.Object r4 = kotlin.ResultKt.createFailure(r4)
            java.lang.Object r4 = kotlin.Result.m4709constructorimpl(r4)
        L_0x0084:
            java.lang.Throwable r5 = kotlin.Result.m4712exceptionOrNullimpl(r4)
            if (r5 != 0) goto L_0x008d
            com.stripe.android.core.model.StripeModel r4 = (com.stripe.android.core.model.StripeModel) r4
            return r4
        L_0x008d:
            com.stripe.android.core.exception.StripeException$Companion r4 = com.stripe.android.core.exception.StripeException.Companion
            com.stripe.android.core.exception.StripeException r4 = r4.create(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.StripeKtxKt.getPaymentIntentResult(com.stripe.android.Stripe, int, android.content.Intent, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object getSetupIntentResult(com.stripe.android.Stripe r4, int r5, android.content.Intent r6, kotlin.coroutines.Continuation<? super com.stripe.android.SetupIntentResult> r7) throws com.stripe.android.core.exception.AuthenticationException, com.stripe.android.core.exception.InvalidRequestException, com.stripe.android.core.exception.APIConnectionException, com.stripe.android.core.exception.APIException, java.lang.IllegalArgumentException {
        /*
            boolean r0 = r7 instanceof com.stripe.android.StripeKtxKt$getSetupIntentResult$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.stripe.android.StripeKtxKt$getSetupIntentResult$1 r0 = (com.stripe.android.StripeKtxKt$getSetupIntentResult$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.stripe.android.StripeKtxKt$getSetupIntentResult$1 r0 = new com.stripe.android.StripeKtxKt$getSetupIntentResult$1
            r0.<init>(r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ all -> 0x0079 }
            goto L_0x004a
        L_0x002a:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r7)
            boolean r5 = r4.isSetupResult(r5, r6)
            kotlin.Result$Companion r7 = kotlin.Result.Companion     // Catch:{ all -> 0x0079 }
            if (r5 == 0) goto L_0x0053
            com.stripe.android.PaymentController r4 = r4.getPaymentController$payments_core_release()     // Catch:{ all -> 0x0079 }
            r0.label = r3     // Catch:{ all -> 0x0079 }
            java.lang.Object r7 = r4.getSetupIntentResult(r6, r0)     // Catch:{ all -> 0x0079 }
            if (r7 != r1) goto L_0x004a
            return r1
        L_0x004a:
            com.stripe.android.SetupIntentResult r7 = (com.stripe.android.SetupIntentResult) r7     // Catch:{ all -> 0x0079 }
            com.stripe.android.core.model.StripeModel r7 = (com.stripe.android.core.model.StripeModel) r7     // Catch:{ all -> 0x0079 }
            java.lang.Object r4 = kotlin.Result.m4709constructorimpl(r7)     // Catch:{ all -> 0x0079 }
            goto L_0x0084
        L_0x0053:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0079 }
            r4.<init>()     // Catch:{ all -> 0x0079 }
            java.lang.String r5 = "Incorrect requestCode and data for "
            r4.append(r5)     // Catch:{ all -> 0x0079 }
            java.lang.Class<com.stripe.android.SetupIntentResult> r5 = com.stripe.android.SetupIntentResult.class
            java.lang.String r5 = r5.getSimpleName()     // Catch:{ all -> 0x0079 }
            r4.append(r5)     // Catch:{ all -> 0x0079 }
            r5 = 46
            r4.append(r5)     // Catch:{ all -> 0x0079 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0079 }
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0079 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0079 }
            r5.<init>(r4)     // Catch:{ all -> 0x0079 }
            throw r5     // Catch:{ all -> 0x0079 }
        L_0x0079:
            r4 = move-exception
            kotlin.Result$Companion r5 = kotlin.Result.Companion
            java.lang.Object r4 = kotlin.ResultKt.createFailure(r4)
            java.lang.Object r4 = kotlin.Result.m4709constructorimpl(r4)
        L_0x0084:
            java.lang.Throwable r5 = kotlin.Result.m4712exceptionOrNullimpl(r4)
            if (r5 != 0) goto L_0x008d
            com.stripe.android.core.model.StripeModel r4 = (com.stripe.android.core.model.StripeModel) r4
            return r4
        L_0x008d:
            com.stripe.android.core.exception.StripeException$Companion r4 = com.stripe.android.core.exception.StripeException.Companion
            com.stripe.android.core.exception.StripeException r4 = r4.create(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.StripeKtxKt.getSetupIntentResult(com.stripe.android.Stripe, int, android.content.Intent, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object getAuthenticateSourceResult(com.stripe.android.Stripe r4, int r5, android.content.Intent r6, kotlin.coroutines.Continuation<? super com.stripe.android.model.Source> r7) throws com.stripe.android.core.exception.AuthenticationException, com.stripe.android.core.exception.InvalidRequestException, com.stripe.android.core.exception.APIConnectionException, com.stripe.android.core.exception.APIException {
        /*
            boolean r0 = r7 instanceof com.stripe.android.StripeKtxKt$getAuthenticateSourceResult$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.stripe.android.StripeKtxKt$getAuthenticateSourceResult$1 r0 = (com.stripe.android.StripeKtxKt$getAuthenticateSourceResult$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.stripe.android.StripeKtxKt$getAuthenticateSourceResult$1 r0 = new com.stripe.android.StripeKtxKt$getAuthenticateSourceResult$1
            r0.<init>(r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ all -> 0x0079 }
            goto L_0x004a
        L_0x002a:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r7)
            boolean r5 = r4.isAuthenticateSourceResult(r5, r6)
            kotlin.Result$Companion r7 = kotlin.Result.Companion     // Catch:{ all -> 0x0079 }
            if (r5 == 0) goto L_0x0053
            com.stripe.android.PaymentController r4 = r4.getPaymentController$payments_core_release()     // Catch:{ all -> 0x0079 }
            r0.label = r3     // Catch:{ all -> 0x0079 }
            java.lang.Object r7 = r4.getAuthenticateSourceResult(r6, r0)     // Catch:{ all -> 0x0079 }
            if (r7 != r1) goto L_0x004a
            return r1
        L_0x004a:
            com.stripe.android.model.Source r7 = (com.stripe.android.model.Source) r7     // Catch:{ all -> 0x0079 }
            com.stripe.android.core.model.StripeModel r7 = (com.stripe.android.core.model.StripeModel) r7     // Catch:{ all -> 0x0079 }
            java.lang.Object r4 = kotlin.Result.m4709constructorimpl(r7)     // Catch:{ all -> 0x0079 }
            goto L_0x0084
        L_0x0053:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0079 }
            r4.<init>()     // Catch:{ all -> 0x0079 }
            java.lang.String r5 = "Incorrect requestCode and data for "
            r4.append(r5)     // Catch:{ all -> 0x0079 }
            java.lang.Class<com.stripe.android.model.Source> r5 = com.stripe.android.model.Source.class
            java.lang.String r5 = r5.getSimpleName()     // Catch:{ all -> 0x0079 }
            r4.append(r5)     // Catch:{ all -> 0x0079 }
            r5 = 46
            r4.append(r5)     // Catch:{ all -> 0x0079 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0079 }
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0079 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0079 }
            r5.<init>(r4)     // Catch:{ all -> 0x0079 }
            throw r5     // Catch:{ all -> 0x0079 }
        L_0x0079:
            r4 = move-exception
            kotlin.Result$Companion r5 = kotlin.Result.Companion
            java.lang.Object r4 = kotlin.ResultKt.createFailure(r4)
            java.lang.Object r4 = kotlin.Result.m4709constructorimpl(r4)
        L_0x0084:
            java.lang.Throwable r5 = kotlin.Result.m4712exceptionOrNullimpl(r4)
            if (r5 != 0) goto L_0x008d
            com.stripe.android.core.model.StripeModel r4 = (com.stripe.android.core.model.StripeModel) r4
            return r4
        L_0x008d:
            com.stripe.android.core.exception.StripeException$Companion r4 = com.stripe.android.core.exception.StripeException.Companion
            com.stripe.android.core.exception.StripeException r4 = r4.create(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.StripeKtxKt.getAuthenticateSourceResult(com.stripe.android.Stripe, int, android.content.Intent, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final /* synthetic */ <ApiObject extends StripeModel> ApiObject runApiRequest(boolean z, Function0<? extends ApiObject> function0) {
        ApiObject apiobject;
        Intrinsics.checkNotNullParameter(function0, "block");
        try {
            Result.Companion companion = Result.Companion;
            if (z) {
                apiobject = Result.m4709constructorimpl((StripeModel) function0.invoke());
                Throwable r2 = Result.m4712exceptionOrNullimpl(apiobject);
                if (r2 == null) {
                    return (StripeModel) apiobject;
                }
                throw StripeException.Companion.create(r2);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Incorrect requestCode and data for ");
            Intrinsics.reifiedOperationMarker(4, "ApiObject");
            sb.append(StripeModel.class.getSimpleName());
            sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
            throw new IllegalArgumentException(sb.toString().toString());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            apiobject = Result.m4709constructorimpl(ResultKt.createFailure(th));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0061 A[Catch:{ all -> 0x008e }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0068 A[Catch:{ all -> 0x008e }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object verifyPaymentIntentWithMicrodeposits(com.stripe.android.Stripe r14, java.lang.String r15, int r16, int r17, kotlin.coroutines.Continuation<? super com.stripe.android.model.PaymentIntent> r18) throws com.stripe.android.core.exception.AuthenticationException, com.stripe.android.core.exception.InvalidRequestException, com.stripe.android.core.exception.APIConnectionException, com.stripe.android.core.exception.APIException {
        /*
            r0 = r18
            boolean r1 = r0 instanceof com.stripe.android.StripeKtxKt$verifyPaymentIntentWithMicrodeposits$1
            if (r1 == 0) goto L_0x0016
            r1 = r0
            com.stripe.android.StripeKtxKt$verifyPaymentIntentWithMicrodeposits$1 r1 = (com.stripe.android.StripeKtxKt$verifyPaymentIntentWithMicrodeposits$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L_0x001b
        L_0x0016:
            com.stripe.android.StripeKtxKt$verifyPaymentIntentWithMicrodeposits$1 r1 = new com.stripe.android.StripeKtxKt$verifyPaymentIntentWithMicrodeposits$1
            r1.<init>(r0)
        L_0x001b:
            r7 = r1
            java.lang.Object r0 = r7.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r7.label
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x008e }
            goto L_0x005d
        L_0x002d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r0)
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x008e }
            com.stripe.android.networking.StripeRepository r2 = r14.getStripeRepository$payments_core_release()     // Catch:{ all -> 0x008e }
            com.stripe.android.core.networking.ApiRequest$Options r6 = new com.stripe.android.core.networking.ApiRequest$Options     // Catch:{ all -> 0x008e }
            java.lang.String r9 = r14.getPublishableKey$payments_core_release()     // Catch:{ all -> 0x008e }
            java.lang.String r10 = r14.getStripeAccountId$payments_core_release()     // Catch:{ all -> 0x008e }
            r11 = 0
            r12 = 4
            r13 = 0
            r8 = r6
            r8.<init>(r9, r10, r11, r12, r13)     // Catch:{ all -> 0x008e }
            r7.label = r3     // Catch:{ all -> 0x008e }
            r3 = r15
            r4 = r16
            r5 = r17
            java.lang.Object r0 = r2.verifyPaymentIntentWithMicrodeposits(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x008e }
            if (r0 != r1) goto L_0x005d
            return r1
        L_0x005d:
            com.stripe.android.model.PaymentIntent r0 = (com.stripe.android.model.PaymentIntent) r0     // Catch:{ all -> 0x008e }
            if (r0 == 0) goto L_0x0068
            com.stripe.android.core.model.StripeModel r0 = (com.stripe.android.core.model.StripeModel) r0     // Catch:{ all -> 0x008e }
            java.lang.Object r0 = kotlin.Result.m4709constructorimpl(r0)     // Catch:{ all -> 0x008e }
            goto L_0x0099
        L_0x0068:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x008e }
            r0.<init>()     // Catch:{ all -> 0x008e }
            java.lang.String r1 = "Failed to parse "
            r0.append(r1)     // Catch:{ all -> 0x008e }
            java.lang.Class<com.stripe.android.model.PaymentIntent> r1 = com.stripe.android.model.PaymentIntent.class
            java.lang.String r1 = r1.getSimpleName()     // Catch:{ all -> 0x008e }
            r0.append(r1)     // Catch:{ all -> 0x008e }
            r1 = 46
            r0.append(r1)     // Catch:{ all -> 0x008e }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x008e }
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x008e }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x008e }
            r1.<init>(r0)     // Catch:{ all -> 0x008e }
            throw r1     // Catch:{ all -> 0x008e }
        L_0x008e:
            r0 = move-exception
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m4709constructorimpl(r0)
        L_0x0099:
            java.lang.Throwable r1 = kotlin.Result.m4712exceptionOrNullimpl(r0)
            if (r1 != 0) goto L_0x00a2
            com.stripe.android.core.model.StripeModel r0 = (com.stripe.android.core.model.StripeModel) r0
            return r0
        L_0x00a2:
            com.stripe.android.core.exception.StripeException$Companion r0 = com.stripe.android.core.exception.StripeException.Companion
            com.stripe.android.core.exception.StripeException r0 = r0.create(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.StripeKtxKt.verifyPaymentIntentWithMicrodeposits(com.stripe.android.Stripe, java.lang.String, int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0059 A[Catch:{ all -> 0x0086 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0060 A[Catch:{ all -> 0x0086 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object verifyPaymentIntentWithMicrodeposits(com.stripe.android.Stripe r10, java.lang.String r11, java.lang.String r12, kotlin.coroutines.Continuation<? super com.stripe.android.model.PaymentIntent> r13) throws com.stripe.android.core.exception.AuthenticationException, com.stripe.android.core.exception.InvalidRequestException, com.stripe.android.core.exception.APIConnectionException, com.stripe.android.core.exception.APIException {
        /*
            boolean r0 = r13 instanceof com.stripe.android.StripeKtxKt$verifyPaymentIntentWithMicrodeposits$3
            if (r0 == 0) goto L_0x0014
            r0 = r13
            com.stripe.android.StripeKtxKt$verifyPaymentIntentWithMicrodeposits$3 r0 = (com.stripe.android.StripeKtxKt$verifyPaymentIntentWithMicrodeposits$3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L_0x0019
        L_0x0014:
            com.stripe.android.StripeKtxKt$verifyPaymentIntentWithMicrodeposits$3 r0 = new com.stripe.android.StripeKtxKt$verifyPaymentIntentWithMicrodeposits$3
            r0.<init>(r13)
        L_0x0019:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ all -> 0x0086 }
            goto L_0x0055
        L_0x002a:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r13)
            kotlin.Result$Companion r13 = kotlin.Result.Companion     // Catch:{ all -> 0x0086 }
            com.stripe.android.networking.StripeRepository r13 = r10.getStripeRepository$payments_core_release()     // Catch:{ all -> 0x0086 }
            com.stripe.android.core.networking.ApiRequest$Options r2 = new com.stripe.android.core.networking.ApiRequest$Options     // Catch:{ all -> 0x0086 }
            java.lang.String r5 = r10.getPublishableKey$payments_core_release()     // Catch:{ all -> 0x0086 }
            java.lang.String r6 = r10.getStripeAccountId$payments_core_release()     // Catch:{ all -> 0x0086 }
            r7 = 0
            r8 = 4
            r9 = 0
            r4 = r2
            r4.<init>(r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0086 }
            r0.label = r3     // Catch:{ all -> 0x0086 }
            java.lang.Object r13 = r13.verifyPaymentIntentWithMicrodeposits(r11, r12, r2, r0)     // Catch:{ all -> 0x0086 }
            if (r13 != r1) goto L_0x0055
            return r1
        L_0x0055:
            com.stripe.android.model.PaymentIntent r13 = (com.stripe.android.model.PaymentIntent) r13     // Catch:{ all -> 0x0086 }
            if (r13 == 0) goto L_0x0060
            com.stripe.android.core.model.StripeModel r13 = (com.stripe.android.core.model.StripeModel) r13     // Catch:{ all -> 0x0086 }
            java.lang.Object r10 = kotlin.Result.m4709constructorimpl(r13)     // Catch:{ all -> 0x0086 }
            goto L_0x0091
        L_0x0060:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0086 }
            r10.<init>()     // Catch:{ all -> 0x0086 }
            java.lang.String r11 = "Failed to parse "
            r10.append(r11)     // Catch:{ all -> 0x0086 }
            java.lang.Class<com.stripe.android.model.PaymentIntent> r11 = com.stripe.android.model.PaymentIntent.class
            java.lang.String r11 = r11.getSimpleName()     // Catch:{ all -> 0x0086 }
            r10.append(r11)     // Catch:{ all -> 0x0086 }
            r11 = 46
            r10.append(r11)     // Catch:{ all -> 0x0086 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x0086 }
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0086 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x0086 }
            r11.<init>(r10)     // Catch:{ all -> 0x0086 }
            throw r11     // Catch:{ all -> 0x0086 }
        L_0x0086:
            r10 = move-exception
            kotlin.Result$Companion r11 = kotlin.Result.Companion
            java.lang.Object r10 = kotlin.ResultKt.createFailure(r10)
            java.lang.Object r10 = kotlin.Result.m4709constructorimpl(r10)
        L_0x0091:
            java.lang.Throwable r11 = kotlin.Result.m4712exceptionOrNullimpl(r10)
            if (r11 != 0) goto L_0x009a
            com.stripe.android.core.model.StripeModel r10 = (com.stripe.android.core.model.StripeModel) r10
            return r10
        L_0x009a:
            com.stripe.android.core.exception.StripeException$Companion r10 = com.stripe.android.core.exception.StripeException.Companion
            com.stripe.android.core.exception.StripeException r10 = r10.create(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.StripeKtxKt.verifyPaymentIntentWithMicrodeposits(com.stripe.android.Stripe, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0061 A[Catch:{ all -> 0x008e }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0068 A[Catch:{ all -> 0x008e }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object verifySetupIntentWithMicrodeposits(com.stripe.android.Stripe r14, java.lang.String r15, int r16, int r17, kotlin.coroutines.Continuation<? super com.stripe.android.model.SetupIntent> r18) throws com.stripe.android.core.exception.AuthenticationException, com.stripe.android.core.exception.InvalidRequestException, com.stripe.android.core.exception.APIConnectionException, com.stripe.android.core.exception.APIException {
        /*
            r0 = r18
            boolean r1 = r0 instanceof com.stripe.android.StripeKtxKt$verifySetupIntentWithMicrodeposits$1
            if (r1 == 0) goto L_0x0016
            r1 = r0
            com.stripe.android.StripeKtxKt$verifySetupIntentWithMicrodeposits$1 r1 = (com.stripe.android.StripeKtxKt$verifySetupIntentWithMicrodeposits$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L_0x001b
        L_0x0016:
            com.stripe.android.StripeKtxKt$verifySetupIntentWithMicrodeposits$1 r1 = new com.stripe.android.StripeKtxKt$verifySetupIntentWithMicrodeposits$1
            r1.<init>(r0)
        L_0x001b:
            r7 = r1
            java.lang.Object r0 = r7.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r7.label
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x008e }
            goto L_0x005d
        L_0x002d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r0)
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x008e }
            com.stripe.android.networking.StripeRepository r2 = r14.getStripeRepository$payments_core_release()     // Catch:{ all -> 0x008e }
            com.stripe.android.core.networking.ApiRequest$Options r6 = new com.stripe.android.core.networking.ApiRequest$Options     // Catch:{ all -> 0x008e }
            java.lang.String r9 = r14.getPublishableKey$payments_core_release()     // Catch:{ all -> 0x008e }
            java.lang.String r10 = r14.getStripeAccountId$payments_core_release()     // Catch:{ all -> 0x008e }
            r11 = 0
            r12 = 4
            r13 = 0
            r8 = r6
            r8.<init>(r9, r10, r11, r12, r13)     // Catch:{ all -> 0x008e }
            r7.label = r3     // Catch:{ all -> 0x008e }
            r3 = r15
            r4 = r16
            r5 = r17
            java.lang.Object r0 = r2.verifySetupIntentWithMicrodeposits(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x008e }
            if (r0 != r1) goto L_0x005d
            return r1
        L_0x005d:
            com.stripe.android.model.SetupIntent r0 = (com.stripe.android.model.SetupIntent) r0     // Catch:{ all -> 0x008e }
            if (r0 == 0) goto L_0x0068
            com.stripe.android.core.model.StripeModel r0 = (com.stripe.android.core.model.StripeModel) r0     // Catch:{ all -> 0x008e }
            java.lang.Object r0 = kotlin.Result.m4709constructorimpl(r0)     // Catch:{ all -> 0x008e }
            goto L_0x0099
        L_0x0068:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x008e }
            r0.<init>()     // Catch:{ all -> 0x008e }
            java.lang.String r1 = "Failed to parse "
            r0.append(r1)     // Catch:{ all -> 0x008e }
            java.lang.Class<com.stripe.android.model.SetupIntent> r1 = com.stripe.android.model.SetupIntent.class
            java.lang.String r1 = r1.getSimpleName()     // Catch:{ all -> 0x008e }
            r0.append(r1)     // Catch:{ all -> 0x008e }
            r1 = 46
            r0.append(r1)     // Catch:{ all -> 0x008e }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x008e }
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x008e }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x008e }
            r1.<init>(r0)     // Catch:{ all -> 0x008e }
            throw r1     // Catch:{ all -> 0x008e }
        L_0x008e:
            r0 = move-exception
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m4709constructorimpl(r0)
        L_0x0099:
            java.lang.Throwable r1 = kotlin.Result.m4712exceptionOrNullimpl(r0)
            if (r1 != 0) goto L_0x00a2
            com.stripe.android.core.model.StripeModel r0 = (com.stripe.android.core.model.StripeModel) r0
            return r0
        L_0x00a2:
            com.stripe.android.core.exception.StripeException$Companion r0 = com.stripe.android.core.exception.StripeException.Companion
            com.stripe.android.core.exception.StripeException r0 = r0.create(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.StripeKtxKt.verifySetupIntentWithMicrodeposits(com.stripe.android.Stripe, java.lang.String, int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0059 A[Catch:{ all -> 0x0086 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0060 A[Catch:{ all -> 0x0086 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object verifySetupIntentWithMicrodeposits(com.stripe.android.Stripe r10, java.lang.String r11, java.lang.String r12, kotlin.coroutines.Continuation<? super com.stripe.android.model.SetupIntent> r13) throws com.stripe.android.core.exception.AuthenticationException, com.stripe.android.core.exception.InvalidRequestException, com.stripe.android.core.exception.APIConnectionException, com.stripe.android.core.exception.APIException {
        /*
            boolean r0 = r13 instanceof com.stripe.android.StripeKtxKt$verifySetupIntentWithMicrodeposits$3
            if (r0 == 0) goto L_0x0014
            r0 = r13
            com.stripe.android.StripeKtxKt$verifySetupIntentWithMicrodeposits$3 r0 = (com.stripe.android.StripeKtxKt$verifySetupIntentWithMicrodeposits$3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L_0x0019
        L_0x0014:
            com.stripe.android.StripeKtxKt$verifySetupIntentWithMicrodeposits$3 r0 = new com.stripe.android.StripeKtxKt$verifySetupIntentWithMicrodeposits$3
            r0.<init>(r13)
        L_0x0019:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ all -> 0x0086 }
            goto L_0x0055
        L_0x002a:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r13)
            kotlin.Result$Companion r13 = kotlin.Result.Companion     // Catch:{ all -> 0x0086 }
            com.stripe.android.networking.StripeRepository r13 = r10.getStripeRepository$payments_core_release()     // Catch:{ all -> 0x0086 }
            com.stripe.android.core.networking.ApiRequest$Options r2 = new com.stripe.android.core.networking.ApiRequest$Options     // Catch:{ all -> 0x0086 }
            java.lang.String r5 = r10.getPublishableKey$payments_core_release()     // Catch:{ all -> 0x0086 }
            java.lang.String r6 = r10.getStripeAccountId$payments_core_release()     // Catch:{ all -> 0x0086 }
            r7 = 0
            r8 = 4
            r9 = 0
            r4 = r2
            r4.<init>(r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0086 }
            r0.label = r3     // Catch:{ all -> 0x0086 }
            java.lang.Object r13 = r13.verifySetupIntentWithMicrodeposits(r11, r12, r2, r0)     // Catch:{ all -> 0x0086 }
            if (r13 != r1) goto L_0x0055
            return r1
        L_0x0055:
            com.stripe.android.model.SetupIntent r13 = (com.stripe.android.model.SetupIntent) r13     // Catch:{ all -> 0x0086 }
            if (r13 == 0) goto L_0x0060
            com.stripe.android.core.model.StripeModel r13 = (com.stripe.android.core.model.StripeModel) r13     // Catch:{ all -> 0x0086 }
            java.lang.Object r10 = kotlin.Result.m4709constructorimpl(r13)     // Catch:{ all -> 0x0086 }
            goto L_0x0091
        L_0x0060:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0086 }
            r10.<init>()     // Catch:{ all -> 0x0086 }
            java.lang.String r11 = "Failed to parse "
            r10.append(r11)     // Catch:{ all -> 0x0086 }
            java.lang.Class<com.stripe.android.model.SetupIntent> r11 = com.stripe.android.model.SetupIntent.class
            java.lang.String r11 = r11.getSimpleName()     // Catch:{ all -> 0x0086 }
            r10.append(r11)     // Catch:{ all -> 0x0086 }
            r11 = 46
            r10.append(r11)     // Catch:{ all -> 0x0086 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x0086 }
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0086 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x0086 }
            r11.<init>(r10)     // Catch:{ all -> 0x0086 }
            throw r11     // Catch:{ all -> 0x0086 }
        L_0x0086:
            r10 = move-exception
            kotlin.Result$Companion r11 = kotlin.Result.Companion
            java.lang.Object r10 = kotlin.ResultKt.createFailure(r10)
            java.lang.Object r10 = kotlin.Result.m4709constructorimpl(r10)
        L_0x0091:
            java.lang.Throwable r11 = kotlin.Result.m4712exceptionOrNullimpl(r10)
            if (r11 != 0) goto L_0x009a
            com.stripe.android.core.model.StripeModel r10 = (com.stripe.android.core.model.StripeModel) r10
            return r10
        L_0x009a:
            com.stripe.android.core.exception.StripeException$Companion r10 = com.stripe.android.core.exception.StripeException.Companion
            com.stripe.android.core.exception.StripeException r10 = r10.create(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.StripeKtxKt.verifySetupIntentWithMicrodeposits(com.stripe.android.Stripe, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
