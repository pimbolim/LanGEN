package com.stripe.android.link.repositories;

import com.stripe.android.core.Logger;
import com.stripe.android.core.injection.IOContext;
import com.stripe.android.networking.StripeRepository;
import java.util.Locale;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001BM\b\u0007\u0012\u000e\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0010\b\u0001\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ<\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0015\u0010\u0016JD\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ*\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00102\u0006\u0010\u0012\u001a\u00020\u0004H@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u001f\u0010 J4\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\"\u0010#J4\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u00102\u0006\u0010\u0018\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b&\u0010#J4\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b(\u0010#R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006)"}, d2 = {"Lcom/stripe/android/link/repositories/LinkApiRepository;", "Lcom/stripe/android/link/repositories/LinkRepository;", "publishableKeyProvider", "Lkotlin/Function0;", "", "stripeAccountIdProvider", "stripeRepository", "Lcom/stripe/android/networking/StripeRepository;", "logger", "Lcom/stripe/android/core/Logger;", "workContext", "Lkotlin/coroutines/CoroutineContext;", "locale", "Ljava/util/Locale;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lcom/stripe/android/networking/StripeRepository;Lcom/stripe/android/core/Logger;Lkotlin/coroutines/CoroutineContext;Ljava/util/Locale;)V", "confirmVerification", "Lkotlin/Result;", "Lcom/stripe/android/model/ConsumerSession;", "consumerSessionClientSecret", "verificationCode", "authSessionCookie", "confirmVerification-BWLJW6A", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumerSignUp", "email", "phone", "country", "consumerSignUp-yxL6bBk", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listPaymentDetails", "Lcom/stripe/android/model/ConsumerPaymentDetails;", "listPaymentDetails-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logout", "logout-0E7RQCE", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lookupConsumer", "Lcom/stripe/android/model/ConsumerSessionLookup;", "lookupConsumer-0E7RQCE", "startVerification", "startVerification-0E7RQCE", "link_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LinkApiRepository.kt */
public final class LinkApiRepository implements LinkRepository {
    /* access modifiers changed from: private */
    public final Locale locale;
    /* access modifiers changed from: private */
    public final Logger logger;
    /* access modifiers changed from: private */
    public final Function0<String> publishableKeyProvider;
    /* access modifiers changed from: private */
    public final Function0<String> stripeAccountIdProvider;
    /* access modifiers changed from: private */
    public final StripeRepository stripeRepository;
    private final CoroutineContext workContext;

    @Inject
    public LinkApiRepository(@Named("publishableKey") Function0<String> function0, @Named("stripeAccountId") Function0<String> function02, StripeRepository stripeRepository2, Logger logger2, @IOContext CoroutineContext coroutineContext, Locale locale2) {
        Intrinsics.checkNotNullParameter(function0, "publishableKeyProvider");
        Intrinsics.checkNotNullParameter(function02, "stripeAccountIdProvider");
        Intrinsics.checkNotNullParameter(stripeRepository2, "stripeRepository");
        Intrinsics.checkNotNullParameter(logger2, "logger");
        Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
        this.publishableKeyProvider = function0;
        this.stripeAccountIdProvider = function02;
        this.stripeRepository = stripeRepository2;
        this.logger = logger2;
        this.workContext = coroutineContext;
        this.locale = locale2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: lookupConsumer-0E7RQCE  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object m4316lookupConsumer0E7RQCE(java.lang.String r6, java.lang.String r7, kotlin.coroutines.Continuation<? super kotlin.Result<com.stripe.android.model.ConsumerSessionLookup>> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.stripe.android.link.repositories.LinkApiRepository$lookupConsumer$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.stripe.android.link.repositories.LinkApiRepository$lookupConsumer$1 r0 = (com.stripe.android.link.repositories.LinkApiRepository$lookupConsumer$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.stripe.android.link.repositories.LinkApiRepository$lookupConsumer$1 r0 = new com.stripe.android.link.repositories.LinkApiRepository$lookupConsumer$1
            r0.<init>(r5, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0048
        L_0x002a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.coroutines.CoroutineContext r8 = r5.workContext
            com.stripe.android.link.repositories.LinkApiRepository$lookupConsumer$2 r2 = new com.stripe.android.link.repositories.LinkApiRepository$lookupConsumer$2
            r4 = 0
            r2.<init>(r5, r6, r7, r4)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r0.label = r3
            java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r8, r2, r0)
            if (r8 != r1) goto L_0x0048
            return r1
        L_0x0048:
            kotlin.Result r8 = (kotlin.Result) r8
            java.lang.Object r6 = r8.m4718unboximpl()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.link.repositories.LinkApiRepository.m4316lookupConsumer0E7RQCE(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* renamed from: consumerSignUp-yxL6bBk  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object m4313consumerSignUpyxL6bBk(java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, kotlin.coroutines.Continuation<? super kotlin.Result<com.stripe.android.model.ConsumerSession>> r18) {
        /*
            r13 = this;
            r7 = r13
            r0 = r18
            boolean r1 = r0 instanceof com.stripe.android.link.repositories.LinkApiRepository$consumerSignUp$1
            if (r1 == 0) goto L_0x0017
            r1 = r0
            com.stripe.android.link.repositories.LinkApiRepository$consumerSignUp$1 r1 = (com.stripe.android.link.repositories.LinkApiRepository$consumerSignUp$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0017
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L_0x001c
        L_0x0017:
            com.stripe.android.link.repositories.LinkApiRepository$consumerSignUp$1 r1 = new com.stripe.android.link.repositories.LinkApiRepository$consumerSignUp$1
            r1.<init>(r13, r0)
        L_0x001c:
            r8 = r1
            java.lang.Object r0 = r8.result
            java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r10 = 1
            if (r1 == 0) goto L_0x0036
            if (r1 != r10) goto L_0x002e
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0054
        L_0x002e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r0)
            kotlin.coroutines.CoroutineContext r11 = r7.workContext
            com.stripe.android.link.repositories.LinkApiRepository$consumerSignUp$2 r12 = new com.stripe.android.link.repositories.LinkApiRepository$consumerSignUp$2
            r6 = 0
            r0 = r12
            r1 = r13
            r2 = r14
            r3 = r15
            r4 = r16
            r5 = r17
            r0.<init>(r1, r2, r3, r4, r5, r6)
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r8.label = r10
            java.lang.Object r0 = kotlinx.coroutines.BuildersKt.withContext(r11, r12, r8)
            if (r0 != r9) goto L_0x0054
            return r9
        L_0x0054:
            kotlin.Result r0 = (kotlin.Result) r0
            java.lang.Object r0 = r0.m4718unboximpl()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.link.repositories.LinkApiRepository.m4313consumerSignUpyxL6bBk(java.lang.String, java.lang.String, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: startVerification-0E7RQCE  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object m4317startVerification0E7RQCE(java.lang.String r6, java.lang.String r7, kotlin.coroutines.Continuation<? super kotlin.Result<com.stripe.android.model.ConsumerSession>> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.stripe.android.link.repositories.LinkApiRepository$startVerification$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.stripe.android.link.repositories.LinkApiRepository$startVerification$1 r0 = (com.stripe.android.link.repositories.LinkApiRepository$startVerification$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.stripe.android.link.repositories.LinkApiRepository$startVerification$1 r0 = new com.stripe.android.link.repositories.LinkApiRepository$startVerification$1
            r0.<init>(r5, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0048
        L_0x002a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.coroutines.CoroutineContext r8 = r5.workContext
            com.stripe.android.link.repositories.LinkApiRepository$startVerification$2 r2 = new com.stripe.android.link.repositories.LinkApiRepository$startVerification$2
            r4 = 0
            r2.<init>(r5, r6, r7, r4)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r0.label = r3
            java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r8, r2, r0)
            if (r8 != r1) goto L_0x0048
            return r1
        L_0x0048:
            kotlin.Result r8 = (kotlin.Result) r8
            java.lang.Object r6 = r8.m4718unboximpl()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.link.repositories.LinkApiRepository.m4317startVerification0E7RQCE(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: confirmVerification-BWLJW6A  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object m4312confirmVerificationBWLJW6A(java.lang.String r11, java.lang.String r12, java.lang.String r13, kotlin.coroutines.Continuation<? super kotlin.Result<com.stripe.android.model.ConsumerSession>> r14) {
        /*
            r10 = this;
            boolean r0 = r14 instanceof com.stripe.android.link.repositories.LinkApiRepository$confirmVerification$1
            if (r0 == 0) goto L_0x0014
            r0 = r14
            com.stripe.android.link.repositories.LinkApiRepository$confirmVerification$1 r0 = (com.stripe.android.link.repositories.LinkApiRepository$confirmVerification$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L_0x0019
        L_0x0014:
            com.stripe.android.link.repositories.LinkApiRepository$confirmVerification$1 r0 = new com.stripe.android.link.repositories.LinkApiRepository$confirmVerification$1
            r0.<init>(r10, r14)
        L_0x0019:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x004d
        L_0x002a:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r14)
            kotlin.coroutines.CoroutineContext r14 = r10.workContext
            com.stripe.android.link.repositories.LinkApiRepository$confirmVerification$2 r2 = new com.stripe.android.link.repositories.LinkApiRepository$confirmVerification$2
            r9 = 0
            r4 = r2
            r5 = r10
            r6 = r11
            r7 = r12
            r8 = r13
            r4.<init>(r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r0.label = r3
            java.lang.Object r14 = kotlinx.coroutines.BuildersKt.withContext(r14, r2, r0)
            if (r14 != r1) goto L_0x004d
            return r1
        L_0x004d:
            kotlin.Result r14 = (kotlin.Result) r14
            java.lang.Object r11 = r14.m4718unboximpl()
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.link.repositories.LinkApiRepository.m4312confirmVerificationBWLJW6A(java.lang.String, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: logout-0E7RQCE  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object m4315logout0E7RQCE(java.lang.String r6, java.lang.String r7, kotlin.coroutines.Continuation<? super kotlin.Result<com.stripe.android.model.ConsumerSession>> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.stripe.android.link.repositories.LinkApiRepository$logout$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.stripe.android.link.repositories.LinkApiRepository$logout$1 r0 = (com.stripe.android.link.repositories.LinkApiRepository$logout$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.stripe.android.link.repositories.LinkApiRepository$logout$1 r0 = new com.stripe.android.link.repositories.LinkApiRepository$logout$1
            r0.<init>(r5, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0048
        L_0x002a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.coroutines.CoroutineContext r8 = r5.workContext
            com.stripe.android.link.repositories.LinkApiRepository$logout$2 r2 = new com.stripe.android.link.repositories.LinkApiRepository$logout$2
            r4 = 0
            r2.<init>(r5, r6, r7, r4)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r0.label = r3
            java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r8, r2, r0)
            if (r8 != r1) goto L_0x0048
            return r1
        L_0x0048:
            kotlin.Result r8 = (kotlin.Result) r8
            java.lang.Object r6 = r8.m4718unboximpl()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.link.repositories.LinkApiRepository.m4315logout0E7RQCE(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: listPaymentDetails-gIAlu-s  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object m4314listPaymentDetailsgIAlus(java.lang.String r6, kotlin.coroutines.Continuation<? super kotlin.Result<com.stripe.android.model.ConsumerPaymentDetails>> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.stripe.android.link.repositories.LinkApiRepository$listPaymentDetails$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.stripe.android.link.repositories.LinkApiRepository$listPaymentDetails$1 r0 = (com.stripe.android.link.repositories.LinkApiRepository$listPaymentDetails$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.stripe.android.link.repositories.LinkApiRepository$listPaymentDetails$1 r0 = new com.stripe.android.link.repositories.LinkApiRepository$listPaymentDetails$1
            r0.<init>(r5, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0048
        L_0x002a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.coroutines.CoroutineContext r7 = r5.workContext
            com.stripe.android.link.repositories.LinkApiRepository$listPaymentDetails$2 r2 = new com.stripe.android.link.repositories.LinkApiRepository$listPaymentDetails$2
            r4 = 0
            r2.<init>(r5, r6, r4)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r0.label = r3
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r7, r2, r0)
            if (r7 != r1) goto L_0x0048
            return r1
        L_0x0048:
            kotlin.Result r7 = (kotlin.Result) r7
            java.lang.Object r6 = r7.m4718unboximpl()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.link.repositories.LinkApiRepository.m4314listPaymentDetailsgIAlus(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
