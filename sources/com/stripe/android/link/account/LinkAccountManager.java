package com.stripe.android.link.account;

import com.stripe.android.link.model.LinkAccount;
import com.stripe.android.link.repositories.LinkRepository;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Singleton
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0001\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J*\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u00112\u0006\u0010\u0012\u001a\u00020\u0013H@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J,\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00112\u0006\u0010\u001a\u001a\u00020\u0013H@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u001b\u0010\u0015J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0014\u0010\u001d\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J:\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\u00112\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u0013H@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b!\u0010\"J\"\u0010#\u001a\b\u0012\u0004\u0012\u00020\t0\u0011H@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b$\u0010%R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006&"}, d2 = {"Lcom/stripe/android/link/account/LinkAccountManager;", "", "linkRepository", "Lcom/stripe/android/link/repositories/LinkRepository;", "cookieStore", "Lcom/stripe/android/link/account/CookieStore;", "(Lcom/stripe/android/link/repositories/LinkRepository;Lcom/stripe/android/link/account/CookieStore;)V", "_linkAccount", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/stripe/android/link/model/LinkAccount;", "linkAccount", "Lkotlinx/coroutines/flow/StateFlow;", "getLinkAccount", "()Lkotlinx/coroutines/flow/StateFlow;", "setLinkAccount", "(Lkotlinx/coroutines/flow/StateFlow;)V", "confirmVerification", "Lkotlin/Result;", "code", "", "confirmVerification-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cookie", "logout", "Lkotlinx/coroutines/Job;", "lookupConsumer", "email", "lookupConsumer-gIAlu-s", "setAndReturn", "setAndReturnNullable", "signUp", "phone", "country", "signUp-BWLJW6A", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startVerification", "startVerification-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "link_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LinkAccountManager.kt */
public final class LinkAccountManager {
    private final MutableStateFlow<LinkAccount> _linkAccount;
    private final CookieStore cookieStore;
    private StateFlow<LinkAccount> linkAccount;
    /* access modifiers changed from: private */
    public final LinkRepository linkRepository;

    @Inject
    public LinkAccountManager(LinkRepository linkRepository2, CookieStore cookieStore2) {
        Intrinsics.checkNotNullParameter(linkRepository2, "linkRepository");
        Intrinsics.checkNotNullParameter(cookieStore2, "cookieStore");
        this.linkRepository = linkRepository2;
        this.cookieStore = cookieStore2;
        MutableStateFlow<LinkAccount> MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this._linkAccount = MutableStateFlow;
        this.linkAccount = MutableStateFlow;
    }

    public final StateFlow<LinkAccount> getLinkAccount() {
        return this.linkAccount;
    }

    public final void setLinkAccount(StateFlow<LinkAccount> stateFlow) {
        Intrinsics.checkNotNullParameter(stateFlow, "<set-?>");
        this.linkAccount = stateFlow;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008c A[SYNTHETIC, Splitter:B:30:0x008c] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* renamed from: lookupConsumer-gIAlu-s  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m4308lookupConsumergIAlus(java.lang.String r7, kotlin.coroutines.Continuation<? super kotlin.Result<com.stripe.android.link.model.LinkAccount>> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.stripe.android.link.account.LinkAccountManager$lookupConsumer$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.stripe.android.link.account.LinkAccountManager$lookupConsumer$1 r0 = (com.stripe.android.link.account.LinkAccountManager$lookupConsumer$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.stripe.android.link.account.LinkAccountManager$lookupConsumer$1 r0 = new com.stripe.android.link.account.LinkAccountManager$lookupConsumer$1
            r0.<init>(r6, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0052
            if (r2 == r5) goto L_0x0044
            if (r2 != r4) goto L_0x003c
            java.lang.Object r7 = r0.L$0
            com.stripe.android.link.account.LinkAccountManager r7 = (com.stripe.android.link.account.LinkAccountManager) r7
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x0039 }
            kotlin.Result r8 = (kotlin.Result) r8     // Catch:{ all -> 0x0039 }
            java.lang.Object r8 = r8.m4718unboximpl()     // Catch:{ all -> 0x0039 }
            goto L_0x00b0
        L_0x0039:
            r7 = move-exception
            goto L_0x00c4
        L_0x003c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0044:
            java.lang.Object r7 = r0.L$0
            com.stripe.android.link.account.LinkAccountManager r7 = (com.stripe.android.link.account.LinkAccountManager) r7
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.Result r8 = (kotlin.Result) r8
            java.lang.Object r8 = r8.m4718unboximpl()
            goto L_0x0067
        L_0x0052:
            kotlin.ResultKt.throwOnFailure(r8)
            com.stripe.android.link.repositories.LinkRepository r8 = r6.linkRepository
            java.lang.String r2 = r6.cookie()
            r0.L$0 = r6
            r0.label = r5
            java.lang.Object r8 = r8.m4322lookupConsumer0E7RQCE(r7, r2, r0)
            if (r8 != r1) goto L_0x0066
            return r1
        L_0x0066:
            r7 = r6
        L_0x0067:
            boolean r2 = kotlin.Result.m4716isSuccessimpl(r8)
            if (r2 == 0) goto L_0x0082
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            com.stripe.android.model.ConsumerSessionLookup r8 = (com.stripe.android.model.ConsumerSessionLookup) r8
            com.stripe.android.model.ConsumerSession r8 = r8.getConsumerSession()
            if (r8 != 0) goto L_0x0079
            r2 = r3
            goto L_0x007e
        L_0x0079:
            com.stripe.android.link.model.LinkAccount r2 = new com.stripe.android.link.model.LinkAccount
            r2.<init>(r8)
        L_0x007e:
            com.stripe.android.link.model.LinkAccount r8 = r7.setAndReturnNullable(r2)
        L_0x0082:
            java.lang.Object r8 = kotlin.Result.m4709constructorimpl(r8)
            boolean r2 = kotlin.Result.m4716isSuccessimpl(r8)
            if (r2 == 0) goto L_0x00cf
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch:{ all -> 0x0039 }
            com.stripe.android.link.model.LinkAccount r8 = (com.stripe.android.link.model.LinkAccount) r8     // Catch:{ all -> 0x0039 }
            if (r8 != 0) goto L_0x0093
            goto L_0x00bf
        L_0x0093:
            boolean r2 = r8.isVerified()     // Catch:{ all -> 0x0039 }
            if (r2 == 0) goto L_0x009b
            r3 = r8
            goto L_0x00bf
        L_0x009b:
            com.stripe.android.link.repositories.LinkRepository r2 = r7.linkRepository     // Catch:{ all -> 0x0039 }
            java.lang.String r8 = r8.getClientSecret()     // Catch:{ all -> 0x0039 }
            java.lang.String r3 = r7.cookie()     // Catch:{ all -> 0x0039 }
            r0.L$0 = r7     // Catch:{ all -> 0x0039 }
            r0.label = r4     // Catch:{ all -> 0x0039 }
            java.lang.Object r8 = r2.m4323startVerification0E7RQCE(r8, r3, r0)     // Catch:{ all -> 0x0039 }
            if (r8 != r1) goto L_0x00b0
            return r1
        L_0x00b0:
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x0039 }
            com.stripe.android.model.ConsumerSession r8 = (com.stripe.android.model.ConsumerSession) r8     // Catch:{ all -> 0x0039 }
            com.stripe.android.link.model.LinkAccount r0 = new com.stripe.android.link.model.LinkAccount     // Catch:{ all -> 0x0039 }
            r0.<init>(r8)     // Catch:{ all -> 0x0039 }
            com.stripe.android.link.model.LinkAccount r7 = r7.setAndReturn(r0)     // Catch:{ all -> 0x0039 }
            r3 = r7
        L_0x00bf:
            java.lang.Object r7 = kotlin.Result.m4709constructorimpl(r3)     // Catch:{ all -> 0x0039 }
            goto L_0x00d3
        L_0x00c4:
            kotlin.Result$Companion r8 = kotlin.Result.Companion
            java.lang.Object r7 = kotlin.ResultKt.createFailure(r7)
            java.lang.Object r7 = kotlin.Result.m4709constructorimpl(r7)
            goto L_0x00d3
        L_0x00cf:
            java.lang.Object r7 = kotlin.Result.m4709constructorimpl(r8)
        L_0x00d3:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.link.account.LinkAccountManager.m4308lookupConsumergIAlus(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0087 A[SYNTHETIC, Splitter:B:26:0x0087] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* renamed from: signUp-BWLJW6A  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m4309signUpBWLJW6A(java.lang.String r10, java.lang.String r11, java.lang.String r12, kotlin.coroutines.Continuation<? super kotlin.Result<com.stripe.android.link.model.LinkAccount>> r13) {
        /*
            r9 = this;
            boolean r0 = r13 instanceof com.stripe.android.link.account.LinkAccountManager$signUp$1
            if (r0 == 0) goto L_0x0014
            r0 = r13
            com.stripe.android.link.account.LinkAccountManager$signUp$1 r0 = (com.stripe.android.link.account.LinkAccountManager$signUp$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L_0x0019
        L_0x0014:
            com.stripe.android.link.account.LinkAccountManager$signUp$1 r0 = new com.stripe.android.link.account.LinkAccountManager$signUp$1
            r0.<init>(r9, r13)
        L_0x0019:
            java.lang.Object r13 = r0.result
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r8 = 2
            r2 = 1
            if (r1 == 0) goto L_0x0051
            if (r1 == r2) goto L_0x0043
            if (r1 != r8) goto L_0x003b
            java.lang.Object r10 = r0.L$0
            com.stripe.android.link.account.LinkAccountManager r10 = (com.stripe.android.link.account.LinkAccountManager) r10
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ all -> 0x0038 }
            kotlin.Result r13 = (kotlin.Result) r13     // Catch:{ all -> 0x0038 }
            java.lang.Object r11 = r13.m4718unboximpl()     // Catch:{ all -> 0x0038 }
            goto L_0x00a7
        L_0x0038:
            r10 = move-exception
            goto L_0x00ba
        L_0x003b:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0043:
            java.lang.Object r10 = r0.L$0
            com.stripe.android.link.account.LinkAccountManager r10 = (com.stripe.android.link.account.LinkAccountManager) r10
            kotlin.ResultKt.throwOnFailure(r13)
            kotlin.Result r13 = (kotlin.Result) r13
            java.lang.Object r11 = r13.m4718unboximpl()
            goto L_0x006a
        L_0x0051:
            kotlin.ResultKt.throwOnFailure(r13)
            com.stripe.android.link.repositories.LinkRepository r1 = r9.linkRepository
            java.lang.String r5 = r9.cookie()
            r0.L$0 = r9
            r0.label = r2
            r2 = r10
            r3 = r11
            r4 = r12
            r6 = r0
            java.lang.Object r11 = r1.m4319consumerSignUpyxL6bBk(r2, r3, r4, r5, r6)
            if (r11 != r7) goto L_0x0069
            return r7
        L_0x0069:
            r10 = r9
        L_0x006a:
            boolean r12 = kotlin.Result.m4716isSuccessimpl(r11)
            if (r12 == 0) goto L_0x007d
            kotlin.Result$Companion r12 = kotlin.Result.Companion
            com.stripe.android.model.ConsumerSession r11 = (com.stripe.android.model.ConsumerSession) r11
            com.stripe.android.link.model.LinkAccount r12 = new com.stripe.android.link.model.LinkAccount
            r12.<init>(r11)
            com.stripe.android.link.model.LinkAccount r11 = r10.setAndReturn(r12)
        L_0x007d:
            java.lang.Object r11 = kotlin.Result.m4709constructorimpl(r11)
            boolean r12 = kotlin.Result.m4716isSuccessimpl(r11)
            if (r12 == 0) goto L_0x00c5
            kotlin.Result$Companion r12 = kotlin.Result.Companion     // Catch:{ all -> 0x0038 }
            com.stripe.android.link.model.LinkAccount r11 = (com.stripe.android.link.model.LinkAccount) r11     // Catch:{ all -> 0x0038 }
            boolean r12 = r11.isVerified()     // Catch:{ all -> 0x0038 }
            if (r12 == 0) goto L_0x0092
            goto L_0x00b5
        L_0x0092:
            com.stripe.android.link.repositories.LinkRepository r12 = r10.linkRepository     // Catch:{ all -> 0x0038 }
            java.lang.String r11 = r11.getClientSecret()     // Catch:{ all -> 0x0038 }
            java.lang.String r13 = r10.cookie()     // Catch:{ all -> 0x0038 }
            r0.L$0 = r10     // Catch:{ all -> 0x0038 }
            r0.label = r8     // Catch:{ all -> 0x0038 }
            java.lang.Object r11 = r12.m4323startVerification0E7RQCE(r11, r13, r0)     // Catch:{ all -> 0x0038 }
            if (r11 != r7) goto L_0x00a7
            return r7
        L_0x00a7:
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x0038 }
            com.stripe.android.model.ConsumerSession r11 = (com.stripe.android.model.ConsumerSession) r11     // Catch:{ all -> 0x0038 }
            com.stripe.android.link.model.LinkAccount r12 = new com.stripe.android.link.model.LinkAccount     // Catch:{ all -> 0x0038 }
            r12.<init>(r11)     // Catch:{ all -> 0x0038 }
            com.stripe.android.link.model.LinkAccount r11 = r10.setAndReturn(r12)     // Catch:{ all -> 0x0038 }
        L_0x00b5:
            java.lang.Object r10 = kotlin.Result.m4709constructorimpl(r11)     // Catch:{ all -> 0x0038 }
            goto L_0x00c9
        L_0x00ba:
            kotlin.Result$Companion r11 = kotlin.Result.Companion
            java.lang.Object r10 = kotlin.ResultKt.createFailure(r10)
            java.lang.Object r10 = kotlin.Result.m4709constructorimpl(r10)
            goto L_0x00c9
        L_0x00c5:
            java.lang.Object r10 = kotlin.Result.m4709constructorimpl(r11)
        L_0x00c9:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.link.account.LinkAccountManager.m4309signUpBWLJW6A(java.lang.String, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: startVerification-IoAF18A  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m4310startVerificationIoAF18A(kotlin.coroutines.Continuation<? super kotlin.Result<com.stripe.android.link.model.LinkAccount>> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.stripe.android.link.account.LinkAccountManager$startVerification$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.stripe.android.link.account.LinkAccountManager$startVerification$1 r0 = (com.stripe.android.link.account.LinkAccountManager$startVerification$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.stripe.android.link.account.LinkAccountManager$startVerification$1 r0 = new com.stripe.android.link.account.LinkAccountManager$startVerification$1
            r0.<init>(r5, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            java.lang.Object r0 = r0.L$0
            com.stripe.android.link.account.LinkAccountManager r0 = (com.stripe.android.link.account.LinkAccountManager) r0
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            java.lang.Object r6 = r6.m4718unboximpl()
            goto L_0x0063
        L_0x0034:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlinx.coroutines.flow.StateFlow r6 = r5.getLinkAccount()
            java.lang.Object r6 = r6.getValue()
            com.stripe.android.link.model.LinkAccount r6 = (com.stripe.android.link.model.LinkAccount) r6
            if (r6 != 0) goto L_0x004d
            r6 = 0
            goto L_0x007e
        L_0x004d:
            com.stripe.android.link.repositories.LinkRepository r2 = r5.linkRepository
            java.lang.String r6 = r6.getClientSecret()
            java.lang.String r4 = r5.cookie()
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = r2.m4323startVerification0E7RQCE(r6, r4, r0)
            if (r6 != r1) goto L_0x0062
            return r1
        L_0x0062:
            r0 = r5
        L_0x0063:
            boolean r1 = kotlin.Result.m4716isSuccessimpl(r6)
            if (r1 == 0) goto L_0x0076
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            com.stripe.android.model.ConsumerSession r6 = (com.stripe.android.model.ConsumerSession) r6
            com.stripe.android.link.model.LinkAccount r1 = new com.stripe.android.link.model.LinkAccount
            r1.<init>(r6)
            com.stripe.android.link.model.LinkAccount r6 = r0.setAndReturn(r1)
        L_0x0076:
            java.lang.Object r6 = kotlin.Result.m4709constructorimpl(r6)
            kotlin.Result r6 = kotlin.Result.m4708boximpl(r6)
        L_0x007e:
            if (r6 != 0) goto L_0x0094
            kotlin.Result$Companion r6 = kotlin.Result.Companion
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "A non-null Link account is needed to start verification"
            r6.<init>(r0)
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            java.lang.Object r6 = kotlin.ResultKt.createFailure(r6)
            java.lang.Object r6 = kotlin.Result.m4709constructorimpl(r6)
            goto L_0x0098
        L_0x0094:
            java.lang.Object r6 = r6.m4718unboximpl()
        L_0x0098:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.link.account.LinkAccountManager.m4310startVerificationIoAF18A(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: confirmVerification-gIAlu-s  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m4307confirmVerificationgIAlus(java.lang.String r6, kotlin.coroutines.Continuation<? super kotlin.Result<com.stripe.android.link.model.LinkAccount>> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.stripe.android.link.account.LinkAccountManager$confirmVerification$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.stripe.android.link.account.LinkAccountManager$confirmVerification$1 r0 = (com.stripe.android.link.account.LinkAccountManager$confirmVerification$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.stripe.android.link.account.LinkAccountManager$confirmVerification$1 r0 = new com.stripe.android.link.account.LinkAccountManager$confirmVerification$1
            r0.<init>(r5, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            java.lang.Object r6 = r0.L$0
            com.stripe.android.link.account.LinkAccountManager r6 = (com.stripe.android.link.account.LinkAccountManager) r6
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.Result r7 = (kotlin.Result) r7
            java.lang.Object r7 = r7.m4718unboximpl()
            goto L_0x0063
        L_0x0034:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlinx.coroutines.flow.StateFlow r7 = r5.getLinkAccount()
            java.lang.Object r7 = r7.getValue()
            com.stripe.android.link.model.LinkAccount r7 = (com.stripe.android.link.model.LinkAccount) r7
            if (r7 != 0) goto L_0x004d
            r6 = 0
            goto L_0x0083
        L_0x004d:
            com.stripe.android.link.repositories.LinkRepository r2 = r5.linkRepository
            java.lang.String r7 = r7.getClientSecret()
            java.lang.String r4 = r5.cookie()
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r7 = r2.m4318confirmVerificationBWLJW6A(r7, r6, r4, r0)
            if (r7 != r1) goto L_0x0062
            return r1
        L_0x0062:
            r6 = r5
        L_0x0063:
            boolean r0 = kotlin.Result.m4716isSuccessimpl(r7)
            if (r0 == 0) goto L_0x007b
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            com.stripe.android.model.ConsumerSession r7 = (com.stripe.android.model.ConsumerSession) r7
            com.stripe.android.link.model.LinkAccount r0 = new com.stripe.android.link.model.LinkAccount
            r0.<init>(r7)
            com.stripe.android.link.model.LinkAccount r6 = r6.setAndReturn(r0)
            java.lang.Object r6 = kotlin.Result.m4709constructorimpl(r6)
            goto L_0x007f
        L_0x007b:
            java.lang.Object r6 = kotlin.Result.m4709constructorimpl(r7)
        L_0x007f:
            kotlin.Result r6 = kotlin.Result.m4708boximpl(r6)
        L_0x0083:
            if (r6 != 0) goto L_0x0099
            kotlin.Result$Companion r6 = kotlin.Result.Companion
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "A non-null Link account is needed to confirm verification"
            r6.<init>(r7)
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            java.lang.Object r6 = kotlin.ResultKt.createFailure(r6)
            java.lang.Object r6 = kotlin.Result.m4709constructorimpl(r6)
            goto L_0x009d
        L_0x0099:
            java.lang.Object r6 = r6.m4718unboximpl()
        L_0x009d:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.link.account.LinkAccountManager.m4307confirmVerificationgIAlus(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Job logout() {
        LinkAccount value = this.linkAccount.getValue();
        if (value == null) {
            return null;
        }
        String cookie = cookie();
        this.cookieStore.logout(value.getEmail());
        this._linkAccount.setValue(null);
        return BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new LinkAccountManager$logout$1$1(this, value, cookie, (Continuation<? super LinkAccountManager$logout$1$1>) null), 3, (Object) null);
    }

    private final LinkAccount setAndReturn(LinkAccount linkAccount2) {
        this._linkAccount.setValue(linkAccount2);
        this.cookieStore.updateAuthSessionCookie(linkAccount2.getAuthSessionCookie());
        return linkAccount2;
    }

    private final LinkAccount setAndReturnNullable(LinkAccount linkAccount2) {
        this._linkAccount.setValue(linkAccount2);
        this.cookieStore.updateAuthSessionCookie(linkAccount2 == null ? null : linkAccount2.getAuthSessionCookie());
        return linkAccount2;
    }

    private final String cookie() {
        return this.cookieStore.getAuthSessionCookie();
    }
}
