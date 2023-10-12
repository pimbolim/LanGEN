package com.stripe.android.stripe3ds2.transaction;

import com.stripe.android.stripe3ds2.observability.ErrorReporter;
import com.stripe.android.stripe3ds2.transaction.ChallengeRequestExecutor;
import com.stripe.android.stripe3ds2.transactions.ChallengeRequestData;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001:\u0001\u0007J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/ChallengeActionHandler;", "", "submit", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeRequestResult;", "action", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeAction;", "(Lcom/stripe/android/stripe3ds2/transaction/ChallengeAction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Default", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChallengeActionHandler.kt */
public interface ChallengeActionHandler {
    Object submit(ChallengeAction challengeAction, Continuation<? super ChallengeRequestResult> continuation);

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B'\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB'\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\rJ\u0019\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u0019\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H@ø\u0001\u0000¢\u0006\u0002\u0010\u0014R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/ChallengeActionHandler$Default;", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeActionHandler;", "creqData", "Lcom/stripe/android/stripe3ds2/transactions/ChallengeRequestData;", "errorReporter", "Lcom/stripe/android/stripe3ds2/observability/ErrorReporter;", "creqExecutorFactory", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeRequestExecutor$Factory;", "workContext", "Lkotlin/coroutines/CoroutineContext;", "(Lcom/stripe/android/stripe3ds2/transactions/ChallengeRequestData;Lcom/stripe/android/stripe3ds2/observability/ErrorReporter;Lcom/stripe/android/stripe3ds2/transaction/ChallengeRequestExecutor$Factory;Lkotlin/coroutines/CoroutineContext;)V", "challengeRequestExecutor", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeRequestExecutor;", "(Lcom/stripe/android/stripe3ds2/transactions/ChallengeRequestData;Lcom/stripe/android/stripe3ds2/observability/ErrorReporter;Lcom/stripe/android/stripe3ds2/transaction/ChallengeRequestExecutor;Lkotlin/coroutines/CoroutineContext;)V", "executeChallengeRequest", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeRequestResult;", "(Lcom/stripe/android/stripe3ds2/transactions/ChallengeRequestData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "submit", "action", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeAction;", "(Lcom/stripe/android/stripe3ds2/transaction/ChallengeAction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ChallengeActionHandler.kt */
    public static final class Default implements ChallengeActionHandler {
        /* access modifiers changed from: private */
        public static final long CREQ_DELAY = TimeUnit.SECONDS.toMillis(1);
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final ChallengeRequestExecutor challengeRequestExecutor;
        /* access modifiers changed from: private */
        public final ChallengeRequestData creqData;
        private final ErrorReporter errorReporter;
        private final CoroutineContext workContext;

        public Default(ChallengeRequestData challengeRequestData, ErrorReporter errorReporter2, ChallengeRequestExecutor challengeRequestExecutor2, CoroutineContext coroutineContext) {
            Intrinsics.checkNotNullParameter(challengeRequestData, "creqData");
            Intrinsics.checkNotNullParameter(errorReporter2, "errorReporter");
            Intrinsics.checkNotNullParameter(challengeRequestExecutor2, "challengeRequestExecutor");
            Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
            this.creqData = challengeRequestData;
            this.errorReporter = errorReporter2;
            this.challengeRequestExecutor = challengeRequestExecutor2;
            this.workContext = coroutineContext;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Default(ChallengeRequestData challengeRequestData, ErrorReporter errorReporter2, ChallengeRequestExecutor.Factory factory, CoroutineContext coroutineContext) {
            this(challengeRequestData, errorReporter2, factory.create(errorReporter2, coroutineContext), coroutineContext);
            Intrinsics.checkNotNullParameter(challengeRequestData, "creqData");
            Intrinsics.checkNotNullParameter(errorReporter2, "errorReporter");
            Intrinsics.checkNotNullParameter(factory, "creqExecutorFactory");
            Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
        }

        public Object submit(ChallengeAction challengeAction, Continuation<? super ChallengeRequestResult> continuation) {
            return BuildersKt.withContext(this.workContext, new ChallengeActionHandler$Default$submit$2(this, challengeAction, (Continuation<? super ChallengeActionHandler$Default$submit$2>) null), continuation);
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x004b  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0071 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0072  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x008d  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x00be  */
        /* JADX WARNING: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object executeChallengeRequest(com.stripe.android.stripe3ds2.transactions.ChallengeRequestData r8, kotlin.coroutines.Continuation<? super com.stripe.android.stripe3ds2.transaction.ChallengeRequestResult> r9) {
            /*
                r7 = this;
                boolean r0 = r9 instanceof com.stripe.android.stripe3ds2.transaction.ChallengeActionHandler$Default$executeChallengeRequest$1
                if (r0 == 0) goto L_0x0014
                r0 = r9
                com.stripe.android.stripe3ds2.transaction.ChallengeActionHandler$Default$executeChallengeRequest$1 r0 = (com.stripe.android.stripe3ds2.transaction.ChallengeActionHandler$Default$executeChallengeRequest$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r1 = r1 & r2
                if (r1 == 0) goto L_0x0014
                int r9 = r0.label
                int r9 = r9 - r2
                r0.label = r9
                goto L_0x0019
            L_0x0014:
                com.stripe.android.stripe3ds2.transaction.ChallengeActionHandler$Default$executeChallengeRequest$1 r0 = new com.stripe.android.stripe3ds2.transaction.ChallengeActionHandler$Default$executeChallengeRequest$1
                r0.<init>(r7, r9)
            L_0x0019:
                java.lang.Object r9 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L_0x004b
                if (r2 == r4) goto L_0x003f
                if (r2 != r3) goto L_0x0037
                java.lang.Object r8 = r0.L$1
                com.stripe.android.stripe3ds2.transactions.ChallengeRequestData r8 = (com.stripe.android.stripe3ds2.transactions.ChallengeRequestData) r8
                java.lang.Object r0 = r0.L$0
                com.stripe.android.stripe3ds2.transaction.ChallengeActionHandler$Default r0 = (com.stripe.android.stripe3ds2.transaction.ChallengeActionHandler.Default) r0
                kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ all -> 0x0035 }
                goto L_0x0073
            L_0x0035:
                r9 = move-exception
                goto L_0x007c
            L_0x0037:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L_0x003f:
                java.lang.Object r8 = r0.L$1
                com.stripe.android.stripe3ds2.transactions.ChallengeRequestData r8 = (com.stripe.android.stripe3ds2.transactions.ChallengeRequestData) r8
                java.lang.Object r2 = r0.L$0
                com.stripe.android.stripe3ds2.transaction.ChallengeActionHandler$Default r2 = (com.stripe.android.stripe3ds2.transaction.ChallengeActionHandler.Default) r2
                kotlin.ResultKt.throwOnFailure(r9)
                goto L_0x005e
            L_0x004b:
                kotlin.ResultKt.throwOnFailure(r9)
                long r5 = CREQ_DELAY
                r0.L$0 = r7
                r0.L$1 = r8
                r0.label = r4
                java.lang.Object r9 = kotlinx.coroutines.DelayKt.delay(r5, r0)
                if (r9 != r1) goto L_0x005d
                return r1
            L_0x005d:
                r2 = r7
            L_0x005e:
                kotlin.Result$Companion r9 = kotlin.Result.Companion     // Catch:{ all -> 0x007a }
                r9 = r2
                com.stripe.android.stripe3ds2.transaction.ChallengeActionHandler$Default r9 = (com.stripe.android.stripe3ds2.transaction.ChallengeActionHandler.Default) r9     // Catch:{ all -> 0x007a }
                com.stripe.android.stripe3ds2.transaction.ChallengeRequestExecutor r9 = r9.challengeRequestExecutor     // Catch:{ all -> 0x007a }
                r0.L$0 = r2     // Catch:{ all -> 0x007a }
                r0.L$1 = r8     // Catch:{ all -> 0x007a }
                r0.label = r3     // Catch:{ all -> 0x007a }
                java.lang.Object r9 = r9.execute(r8, r0)     // Catch:{ all -> 0x007a }
                if (r9 != r1) goto L_0x0072
                return r1
            L_0x0072:
                r0 = r2
            L_0x0073:
                com.stripe.android.stripe3ds2.transaction.ChallengeRequestResult r9 = (com.stripe.android.stripe3ds2.transaction.ChallengeRequestResult) r9     // Catch:{ all -> 0x0035 }
                java.lang.Object r9 = kotlin.Result.m4709constructorimpl(r9)     // Catch:{ all -> 0x0035 }
                goto L_0x0086
            L_0x007a:
                r9 = move-exception
                r0 = r2
            L_0x007c:
                kotlin.Result$Companion r1 = kotlin.Result.Companion
                java.lang.Object r9 = kotlin.ResultKt.createFailure(r9)
                java.lang.Object r9 = kotlin.Result.m4709constructorimpl(r9)
            L_0x0086:
                java.lang.Throwable r1 = kotlin.Result.m4712exceptionOrNullimpl(r9)
                if (r1 != 0) goto L_0x008d
                goto L_0x00b7
            L_0x008d:
                com.stripe.android.stripe3ds2.observability.ErrorReporter r0 = r0.errorReporter
                java.lang.RuntimeException r2 = new java.lang.RuntimeException
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "\n                            Failed to execute challenge request.\n\n                            CReq = "
                r3.append(r4)
                com.stripe.android.stripe3ds2.transactions.ChallengeRequestData r8 = r8.sanitize$3ds2sdk_release()
                r3.append(r8)
                java.lang.String r8 = "\n                        "
                r3.append(r8)
                java.lang.String r8 = r3.toString()
                java.lang.String r8 = kotlin.text.StringsKt.trimIndent(r8)
                r2.<init>(r8, r1)
                java.lang.Throwable r2 = (java.lang.Throwable) r2
                r0.reportError(r2)
            L_0x00b7:
                java.lang.Throwable r8 = kotlin.Result.m4712exceptionOrNullimpl(r9)
                if (r8 != 0) goto L_0x00be
                goto L_0x00c5
            L_0x00be:
                com.stripe.android.stripe3ds2.transaction.ChallengeRequestResult$RuntimeError r9 = new com.stripe.android.stripe3ds2.transaction.ChallengeRequestResult$RuntimeError
                r9.<init>(r8)
                com.stripe.android.stripe3ds2.transaction.ChallengeRequestResult r9 = (com.stripe.android.stripe3ds2.transaction.ChallengeRequestResult) r9
            L_0x00c5:
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.stripe3ds2.transaction.ChallengeActionHandler.Default.executeChallengeRequest(com.stripe.android.stripe3ds2.transactions.ChallengeRequestData, kotlin.coroutines.Continuation):java.lang.Object");
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/ChallengeActionHandler$Default$Companion;", "", "()V", "CREQ_DELAY", "", "getCREQ_DELAY$3ds2sdk_release", "()J", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: ChallengeActionHandler.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final long getCREQ_DELAY$3ds2sdk_release() {
                return Default.CREQ_DELAY;
            }
        }
    }
}
