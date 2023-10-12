package com.stripe.android.payments;

import android.content.Context;
import com.stripe.android.SetupIntentResult;
import com.stripe.android.core.Logger;
import com.stripe.android.core.StripeError;
import com.stripe.android.core.exception.InvalidRequestException;
import com.stripe.android.core.injection.IOContext;
import com.stripe.android.core.networking.ApiRequest;
import com.stripe.android.model.SetupIntent;
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
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\b\u0001\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B9\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0001\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\b\u0001\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ+\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\"\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\bH\u0014J!\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013H@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ1\u0010\u001d\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u001fH@ø\u0001\u0000¢\u0006\u0002\u0010 \u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"Lcom/stripe/android/payments/SetupIntentFlowResultProcessor;", "Lcom/stripe/android/payments/PaymentFlowResultProcessor;", "Lcom/stripe/android/model/SetupIntent;", "Lcom/stripe/android/SetupIntentResult;", "context", "Landroid/content/Context;", "publishableKeyProvider", "Lkotlin/Function0;", "", "stripeRepository", "Lcom/stripe/android/networking/StripeRepository;", "logger", "Lcom/stripe/android/core/Logger;", "workContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroid/content/Context;Lkotlin/jvm/functions/Function0;Lcom/stripe/android/networking/StripeRepository;Lcom/stripe/android/core/Logger;Lkotlin/coroutines/CoroutineContext;)V", "cancelStripeIntentSource", "stripeIntent", "requestOptions", "Lcom/stripe/android/core/networking/ApiRequest$Options;", "sourceId", "(Lcom/stripe/android/model/SetupIntent;Lcom/stripe/android/core/networking/ApiRequest$Options;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createStripeIntentResult", "outcomeFromFlow", "", "failureMessage", "refreshStripeIntentUntilTerminalState", "clientSecret", "(Ljava/lang/String;Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "retrieveStripeIntent", "expandFields", "", "(Ljava/lang/String;Lcom/stripe/android/core/networking/ApiRequest$Options;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentFlowResultProcessor.kt */
public final class SetupIntentFlowResultProcessor extends PaymentFlowResultProcessor<SetupIntent, SetupIntentResult> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public SetupIntentFlowResultProcessor(Context context, @Named("publishableKey") Function0<String> function0, StripeRepository stripeRepository, Logger logger, @IOContext CoroutineContext coroutineContext) {
        super(context, 
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0024: CONSTRUCTOR  
              (r9v0 'context' android.content.Context)
              (wrap: com.stripe.android.payments.-$$Lambda$SetupIntentFlowResultProcessor$_9-9jV_2RMGyVnxX3DxSuCYP5hA : 0x001b: CONSTRUCTOR  (r3v0 com.stripe.android.payments.-$$Lambda$SetupIntentFlowResultProcessor$_9-9jV_2RMGyVnxX3DxSuCYP5hA) = 
              (r10v0 'function0' kotlin.jvm.functions.Function0<java.lang.String>)
             call: com.stripe.android.payments.-$$Lambda$SetupIntentFlowResultProcessor$_9-9jV_2RMGyVnxX3DxSuCYP5hA.<init>(kotlin.jvm.functions.Function0):void type: CONSTRUCTOR)
              (r11v0 'stripeRepository' com.stripe.android.networking.StripeRepository)
              (r12v0 'logger' com.stripe.android.core.Logger)
              (r13v0 'coroutineContext' kotlin.coroutines.CoroutineContext)
              (null kotlin.jvm.internal.DefaultConstructorMarker)
             call: com.stripe.android.payments.PaymentFlowResultProcessor.<init>(android.content.Context, javax.inject.Provider, com.stripe.android.networking.StripeRepository, com.stripe.android.core.Logger, kotlin.coroutines.CoroutineContext, kotlin.jvm.internal.DefaultConstructorMarker):void type: SUPER in method: com.stripe.android.payments.SetupIntentFlowResultProcessor.<init>(android.content.Context, kotlin.jvm.functions.Function0, com.stripe.android.networking.StripeRepository, com.stripe.android.core.Logger, kotlin.coroutines.CoroutineContext):void, dex: classes4.dex
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
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x001b: CONSTRUCTOR  (r3v0 com.stripe.android.payments.-$$Lambda$SetupIntentFlowResultProcessor$_9-9jV_2RMGyVnxX3DxSuCYP5hA) = 
              (r10v0 'function0' kotlin.jvm.functions.Function0<java.lang.String>)
             call: com.stripe.android.payments.-$$Lambda$SetupIntentFlowResultProcessor$_9-9jV_2RMGyVnxX3DxSuCYP5hA.<init>(kotlin.jvm.functions.Function0):void type: CONSTRUCTOR in method: com.stripe.android.payments.SetupIntentFlowResultProcessor.<init>(android.content.Context, kotlin.jvm.functions.Function0, com.stripe.android.networking.StripeRepository, com.stripe.android.core.Logger, kotlin.coroutines.CoroutineContext):void, dex: classes4.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:640)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
            	... 29 more
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.stripe.android.payments.-$$Lambda$SetupIntentFlowResultProcessor$_9-9jV_2RMGyVnxX3DxSuCYP5hA, state: NOT_LOADED
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
            com.stripe.android.payments.-$$Lambda$SetupIntentFlowResultProcessor$_9-9jV_2RMGyVnxX3DxSuCYP5hA r3 = new com.stripe.android.payments.-$$Lambda$SetupIntentFlowResultProcessor$_9-9jV_2RMGyVnxX3DxSuCYP5hA
            r3.<init>(r10)
            r7 = 0
            r1 = r8
            r2 = r9
            r4 = r11
            r5 = r12
            r6 = r13
            r1.<init>(r2, r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.payments.SetupIntentFlowResultProcessor.<init>(android.content.Context, kotlin.jvm.functions.Function0, com.stripe.android.networking.StripeRepository, com.stripe.android.core.Logger, kotlin.coroutines.CoroutineContext):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final String m4367_init_$lambda0(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "$tmp0");
        return (String) function0.invoke();
    }

    /* access modifiers changed from: protected */
    public Object retrieveStripeIntent(String str, ApiRequest.Options options, List<String> list, Continuation<? super SetupIntent> continuation) {
        return getStripeRepository().retrieveSetupIntent(str, options, list, continuation);
    }

    /* access modifiers changed from: protected */
    public Object refreshStripeIntentUntilTerminalState(String str, ApiRequest.Options options, Continuation<? super SetupIntent> continuation) {
        throw new InvalidRequestException((StripeError) null, (String) null, 0, Intrinsics.stringPlus("refresh endpoint is not available for SetupIntent. client_secret: ", str), (Throwable) null, 23, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: protected */
    public Object cancelStripeIntentSource(SetupIntent setupIntent, ApiRequest.Options options, String str, Continuation<? super SetupIntent> continuation) {
        StripeRepository stripeRepository = getStripeRepository();
        String id = setupIntent.getId();
        if (id == null) {
            id = "";
        }
        return stripeRepository.cancelSetupIntentSource$payments_core_release(id, str, options, continuation);
    }

    /* access modifiers changed from: protected */
    public SetupIntentResult createStripeIntentResult(SetupIntent setupIntent, int i, String str) {
        Intrinsics.checkNotNullParameter(setupIntent, "stripeIntent");
        return new SetupIntentResult(setupIntent, i, str);
    }
}
