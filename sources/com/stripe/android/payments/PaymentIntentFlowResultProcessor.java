package com.stripe.android.payments;

import android.content.Context;
import com.stripe.android.PaymentIntentResult;
import com.stripe.android.core.Logger;
import com.stripe.android.core.injection.IOContext;
import com.stripe.android.core.networking.ApiRequest;
import com.stripe.android.core.networking.RetryDelaySupplier;
import com.stripe.android.model.PaymentIntent;
import com.stripe.android.networking.StripeRepository;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\b\u0001\u0018\u0000 %2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001%BA\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0001\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\b\u0001\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J+\u0010\u0014\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\"\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\bH\u0014J!\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017H@ø\u0001\u0000¢\u0006\u0002\u0010 J1\u0010!\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\b0#H@ø\u0001\u0000¢\u0006\u0002\u0010$R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u0002\u0004\n\u0002\b\u0019¨\u0006&"}, d2 = {"Lcom/stripe/android/payments/PaymentIntentFlowResultProcessor;", "Lcom/stripe/android/payments/PaymentFlowResultProcessor;", "Lcom/stripe/android/model/PaymentIntent;", "Lcom/stripe/android/PaymentIntentResult;", "context", "Landroid/content/Context;", "publishableKeyProvider", "Lkotlin/Function0;", "", "stripeRepository", "Lcom/stripe/android/networking/StripeRepository;", "logger", "Lcom/stripe/android/core/Logger;", "workContext", "Lkotlin/coroutines/CoroutineContext;", "retryDelaySupplier", "Lcom/stripe/android/core/networking/RetryDelaySupplier;", "(Landroid/content/Context;Lkotlin/jvm/functions/Function0;Lcom/stripe/android/networking/StripeRepository;Lcom/stripe/android/core/Logger;Lkotlin/coroutines/CoroutineContext;Lcom/stripe/android/core/networking/RetryDelaySupplier;)V", "getRetryDelaySupplier", "()Lcom/stripe/android/core/networking/RetryDelaySupplier;", "cancelStripeIntentSource", "stripeIntent", "requestOptions", "Lcom/stripe/android/core/networking/ApiRequest$Options;", "sourceId", "(Lcom/stripe/android/model/PaymentIntent;Lcom/stripe/android/core/networking/ApiRequest$Options;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createStripeIntentResult", "outcomeFromFlow", "", "failureMessage", "refreshStripeIntentUntilTerminalState", "clientSecret", "(Ljava/lang/String;Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "retrieveStripeIntent", "expandFields", "", "(Ljava/lang/String;Lcom/stripe/android/core/networking/ApiRequest$Options;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentFlowResultProcessor.kt */
public final class PaymentIntentFlowResultProcessor extends PaymentFlowResultProcessor<PaymentIntent, PaymentIntentResult> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int MAX_RETRIES = 3;
    private final RetryDelaySupplier retryDelaySupplier;

    public final RetryDelaySupplier getRetryDelaySupplier() {
        return this.retryDelaySupplier;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public PaymentIntentFlowResultProcessor(Context context, @Named("publishableKey") Function0<String> function0, StripeRepository stripeRepository, Logger logger, @IOContext CoroutineContext coroutineContext, RetryDelaySupplier retryDelaySupplier2) {
        super(context, 
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0029: CONSTRUCTOR  
              (r9v0 'context' android.content.Context)
              (wrap: com.stripe.android.payments.-$$Lambda$PaymentIntentFlowResultProcessor$CmbI-coAqry29IxmMPtbbqlav00 : 0x0020: CONSTRUCTOR  (r3v0 com.stripe.android.payments.-$$Lambda$PaymentIntentFlowResultProcessor$CmbI-coAqry29IxmMPtbbqlav00) = 
              (r10v0 'function0' kotlin.jvm.functions.Function0<java.lang.String>)
             call: com.stripe.android.payments.-$$Lambda$PaymentIntentFlowResultProcessor$CmbI-coAqry29IxmMPtbbqlav00.<init>(kotlin.jvm.functions.Function0):void type: CONSTRUCTOR)
              (r11v0 'stripeRepository' com.stripe.android.networking.StripeRepository)
              (r12v0 'logger' com.stripe.android.core.Logger)
              (r13v0 'coroutineContext' kotlin.coroutines.CoroutineContext)
              (null kotlin.jvm.internal.DefaultConstructorMarker)
             call: com.stripe.android.payments.PaymentFlowResultProcessor.<init>(android.content.Context, javax.inject.Provider, com.stripe.android.networking.StripeRepository, com.stripe.android.core.Logger, kotlin.coroutines.CoroutineContext, kotlin.jvm.internal.DefaultConstructorMarker):void type: SUPER in method: com.stripe.android.payments.PaymentIntentFlowResultProcessor.<init>(android.content.Context, kotlin.jvm.functions.Function0, com.stripe.android.networking.StripeRepository, com.stripe.android.core.Logger, kotlin.coroutines.CoroutineContext, com.stripe.android.core.networking.RetryDelaySupplier):void, dex: classes4.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
            	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
            	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
            	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
            	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0020: CONSTRUCTOR  (r3v0 com.stripe.android.payments.-$$Lambda$PaymentIntentFlowResultProcessor$CmbI-coAqry29IxmMPtbbqlav00) = 
              (r10v0 'function0' kotlin.jvm.functions.Function0<java.lang.String>)
             call: com.stripe.android.payments.-$$Lambda$PaymentIntentFlowResultProcessor$CmbI-coAqry29IxmMPtbbqlav00.<init>(kotlin.jvm.functions.Function0):void type: CONSTRUCTOR in method: com.stripe.android.payments.PaymentIntentFlowResultProcessor.<init>(android.content.Context, kotlin.jvm.functions.Function0, com.stripe.android.networking.StripeRepository, com.stripe.android.core.Logger, kotlin.coroutines.CoroutineContext, com.stripe.android.core.networking.RetryDelaySupplier):void, dex: classes4.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:640)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
            	... 29 more
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.stripe.android.payments.-$$Lambda$PaymentIntentFlowResultProcessor$CmbI-coAqry29IxmMPtbbqlav00, state: NOT_LOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:260)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:606)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
            	... 35 more
            */
        /*
            this = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "publishableKeyProvider"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "stripeRepository"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "logger"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "workContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "retryDelaySupplier"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            com.stripe.android.payments.-$$Lambda$PaymentIntentFlowResultProcessor$CmbI-coAqry29IxmMPtbbqlav00 r3 = new com.stripe.android.payments.-$$Lambda$PaymentIntentFlowResultProcessor$CmbI-coAqry29IxmMPtbbqlav00
            r3.<init>(r10)
            r7 = 0
            r1 = r8
            r2 = r9
            r4 = r11
            r5 = r12
            r6 = r13
            r1.<init>(r2, r3, r4, r5, r6, r7)
            r8.retryDelaySupplier = r14
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.payments.PaymentIntentFlowResultProcessor.<init>(android.content.Context, kotlin.jvm.functions.Function0, com.stripe.android.networking.StripeRepository, com.stripe.android.core.Logger, kotlin.coroutines.CoroutineContext, com.stripe.android.core.networking.RetryDelaySupplier):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final String m4365_init_$lambda0(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "$tmp0");
        return (String) function0.invoke();
    }

    /* access modifiers changed from: protected */
    public Object retrieveStripeIntent(String str, ApiRequest.Options options, List<String> list, Continuation<? super PaymentIntent> continuation) {
        return getStripeRepository().retrievePaymentIntent(str, options, list, continuation);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00c1 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00d9 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object refreshStripeIntentUntilTerminalState(java.lang.String r11, com.stripe.android.core.networking.ApiRequest.Options r12, kotlin.coroutines.Continuation<? super com.stripe.android.model.PaymentIntent> r13) {
        /*
            r10 = this;
            boolean r0 = r13 instanceof com.stripe.android.payments.PaymentIntentFlowResultProcessor$refreshStripeIntentUntilTerminalState$1
            if (r0 == 0) goto L_0x0014
            r0 = r13
            com.stripe.android.payments.PaymentIntentFlowResultProcessor$refreshStripeIntentUntilTerminalState$1 r0 = (com.stripe.android.payments.PaymentIntentFlowResultProcessor$refreshStripeIntentUntilTerminalState$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L_0x0019
        L_0x0014:
            com.stripe.android.payments.PaymentIntentFlowResultProcessor$refreshStripeIntentUntilTerminalState$1 r0 = new com.stripe.android.payments.PaymentIntentFlowResultProcessor$refreshStripeIntentUntilTerminalState$1
            r0.<init>(r10, r13)
        L_0x0019:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            java.lang.String r3 = "Required value was null."
            r4 = 2
            r5 = 3
            r6 = 1
            if (r2 == 0) goto L_0x006d
            if (r2 == r6) goto L_0x005b
            if (r2 == r4) goto L_0x0049
            if (r2 != r5) goto L_0x0041
            int r11 = r0.I$0
            java.lang.Object r12 = r0.L$2
            com.stripe.android.core.networking.ApiRequest$Options r12 = (com.stripe.android.core.networking.ApiRequest.Options) r12
            java.lang.Object r2 = r0.L$1
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r7 = r0.L$0
            com.stripe.android.payments.PaymentIntentFlowResultProcessor r7 = (com.stripe.android.payments.PaymentIntentFlowResultProcessor) r7
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x00c2
        L_0x0041:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0049:
            int r11 = r0.I$0
            java.lang.Object r12 = r0.L$2
            com.stripe.android.core.networking.ApiRequest$Options r12 = (com.stripe.android.core.networking.ApiRequest.Options) r12
            java.lang.Object r2 = r0.L$1
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r7 = r0.L$0
            com.stripe.android.payments.PaymentIntentFlowResultProcessor r7 = (com.stripe.android.payments.PaymentIntentFlowResultProcessor) r7
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x00ad
        L_0x005b:
            int r11 = r0.I$0
            java.lang.Object r12 = r0.L$2
            com.stripe.android.core.networking.ApiRequest$Options r12 = (com.stripe.android.core.networking.ApiRequest.Options) r12
            java.lang.Object r2 = r0.L$1
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r7 = r0.L$0
            com.stripe.android.payments.PaymentIntentFlowResultProcessor r7 = (com.stripe.android.payments.PaymentIntentFlowResultProcessor) r7
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0088
        L_0x006d:
            kotlin.ResultKt.throwOnFailure(r13)
            com.stripe.android.networking.StripeRepository r13 = r10.getStripeRepository()
            r0.L$0 = r10
            r0.L$1 = r11
            r0.L$2 = r12
            r0.I$0 = r5
            r0.label = r6
            java.lang.Object r13 = r13.refreshPaymentIntent$payments_core_release(r11, r12, r0)
            if (r13 != r1) goto L_0x0085
            return r1
        L_0x0085:
            r7 = r10
            r2 = r11
            r11 = 3
        L_0x0088:
            if (r13 == 0) goto L_0x00e1
            com.stripe.android.model.PaymentIntent r13 = (com.stripe.android.model.PaymentIntent) r13
        L_0x008c:
            boolean r8 = r13.requiresAction()
            if (r8 == 0) goto L_0x00d3
            if (r11 <= r6) goto L_0x00d3
            com.stripe.android.core.networking.RetryDelaySupplier r13 = r7.getRetryDelaySupplier()
            long r8 = r13.getDelayMillis(r5, r11)
            r0.L$0 = r7
            r0.L$1 = r2
            r0.L$2 = r12
            r0.I$0 = r11
            r0.label = r4
            java.lang.Object r13 = kotlinx.coroutines.DelayKt.delay(r8, r0)
            if (r13 != r1) goto L_0x00ad
            return r1
        L_0x00ad:
            com.stripe.android.networking.StripeRepository r13 = r7.getStripeRepository()
            r0.L$0 = r7
            r0.L$1 = r2
            r0.L$2 = r12
            r0.I$0 = r11
            r0.label = r5
            java.lang.Object r13 = r13.refreshPaymentIntent$payments_core_release(r2, r12, r0)
            if (r13 != r1) goto L_0x00c2
            return r1
        L_0x00c2:
            if (r13 == 0) goto L_0x00c9
            com.stripe.android.model.PaymentIntent r13 = (com.stripe.android.model.PaymentIntent) r13
            int r11 = r11 + -1
            goto L_0x008c
        L_0x00c9:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.String r12 = r3.toString()
            r11.<init>(r12)
            throw r11
        L_0x00d3:
            boolean r11 = r13.requiresAction()
            if (r11 != 0) goto L_0x00da
            return r13
        L_0x00da:
            com.stripe.android.core.exception.MaxRetryReachedException r11 = new com.stripe.android.core.exception.MaxRetryReachedException
            r12 = 0
            r11.<init>(r12, r6, r12)
            throw r11
        L_0x00e1:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.String r12 = r3.toString()
            r11.<init>(r12)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.payments.PaymentIntentFlowResultProcessor.refreshStripeIntentUntilTerminalState(java.lang.String, com.stripe.android.core.networking.ApiRequest$Options, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    public Object cancelStripeIntentSource(PaymentIntent paymentIntent, ApiRequest.Options options, String str, Continuation<? super PaymentIntent> continuation) {
        StripeRepository stripeRepository = getStripeRepository();
        String id = paymentIntent.getId();
        if (id == null) {
            id = "";
        }
        return stripeRepository.cancelPaymentIntentSource$payments_core_release(id, str, options, continuation);
    }

    /* access modifiers changed from: protected */
    public PaymentIntentResult createStripeIntentResult(PaymentIntent paymentIntent, int i, String str) {
        Intrinsics.checkNotNullParameter(paymentIntent, "stripeIntent");
        return new PaymentIntentResult(paymentIntent, i, str);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/payments/PaymentIntentFlowResultProcessor$Companion;", "", "()V", "MAX_RETRIES", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentFlowResultProcessor.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
