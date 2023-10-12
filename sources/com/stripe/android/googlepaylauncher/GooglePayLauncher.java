package com.stripe.android.googlepaylauncher;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.result.ActivityResultLauncher;
import com.brentvatne.react.ReactVideoView;
import com.stripe.android.core.networking.AnalyticsRequestExecutor;
import com.stripe.android.googlepaylauncher.GooglePayLauncherContract;
import com.stripe.android.model.Token;
import com.stripe.android.networking.PaymentAnalyticsEvent;
import com.stripe.android.networking.PaymentAnalyticsRequestFactory;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u0000 %2\u00020\u0001:\u0006$%&'()B'\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB'\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\rBQ\b\u0000\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u001a¢\u0006\u0002\u0010\u001bJ\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!J\u0016\u0010\"\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010#\u001a\u00020!R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/stripe/android/googlepaylauncher/GooglePayLauncher;", "", "activity", "Landroidx/activity/ComponentActivity;", "config", "Lcom/stripe/android/googlepaylauncher/GooglePayLauncher$Config;", "readyCallback", "Lcom/stripe/android/googlepaylauncher/GooglePayLauncher$ReadyCallback;", "resultCallback", "Lcom/stripe/android/googlepaylauncher/GooglePayLauncher$ResultCallback;", "(Landroidx/activity/ComponentActivity;Lcom/stripe/android/googlepaylauncher/GooglePayLauncher$Config;Lcom/stripe/android/googlepaylauncher/GooglePayLauncher$ReadyCallback;Lcom/stripe/android/googlepaylauncher/GooglePayLauncher$ResultCallback;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;Lcom/stripe/android/googlepaylauncher/GooglePayLauncher$Config;Lcom/stripe/android/googlepaylauncher/GooglePayLauncher$ReadyCallback;Lcom/stripe/android/googlepaylauncher/GooglePayLauncher$ResultCallback;)V", "lifecycleScope", "Lkotlinx/coroutines/CoroutineScope;", "activityResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Lcom/stripe/android/googlepaylauncher/GooglePayLauncherContract$Args;", "googlePayRepositoryFactory", "Lkotlin/Function1;", "Lcom/stripe/android/googlepaylauncher/GooglePayEnvironment;", "Lcom/stripe/android/googlepaylauncher/GooglePayRepository;", "paymentAnalyticsRequestFactory", "Lcom/stripe/android/networking/PaymentAnalyticsRequestFactory;", "analyticsRequestExecutor", "Lcom/stripe/android/core/networking/AnalyticsRequestExecutor;", "(Lkotlinx/coroutines/CoroutineScope;Lcom/stripe/android/googlepaylauncher/GooglePayLauncher$Config;Lcom/stripe/android/googlepaylauncher/GooglePayLauncher$ReadyCallback;Landroidx/activity/result/ActivityResultLauncher;Lkotlin/jvm/functions/Function1;Lcom/stripe/android/networking/PaymentAnalyticsRequestFactory;Lcom/stripe/android/core/networking/AnalyticsRequestExecutor;)V", "isReady", "", "presentForPaymentIntent", "", "clientSecret", "", "presentForSetupIntent", "currencyCode", "BillingAddressConfig", "Companion", "Config", "ReadyCallback", "Result", "ResultCallback", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GooglePayLauncher.kt */
public final class GooglePayLauncher {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String PRODUCT_USAGE = "GooglePayLauncher";
    private final ActivityResultLauncher<GooglePayLauncherContract.Args> activityResultLauncher;
    /* access modifiers changed from: private */
    public final Config config;
    /* access modifiers changed from: private */
    public final Function1<GooglePayEnvironment, GooglePayRepository> googlePayRepositoryFactory;
    /* access modifiers changed from: private */
    public boolean isReady;
    /* access modifiers changed from: private */
    public final ReadyCallback readyCallback;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/googlepaylauncher/GooglePayLauncher$ReadyCallback;", "", "onReady", "", "isReady", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GooglePayLauncher.kt */
    public interface ReadyCallback {
        void onReady(boolean z);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/googlepaylauncher/GooglePayLauncher$ResultCallback;", "", "onResult", "", "result", "Lcom/stripe/android/googlepaylauncher/GooglePayLauncher$Result;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GooglePayLauncher.kt */
    public interface ResultCallback {
        void onResult(Result result);
    }

    public GooglePayLauncher(CoroutineScope coroutineScope, Config config2, ReadyCallback readyCallback2, ActivityResultLauncher<GooglePayLauncherContract.Args> activityResultLauncher2, Function1<? super GooglePayEnvironment, ? extends GooglePayRepository> function1, PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory, AnalyticsRequestExecutor analyticsRequestExecutor) {
        Config config3 = config2;
        ReadyCallback readyCallback3 = readyCallback2;
        ActivityResultLauncher<GooglePayLauncherContract.Args> activityResultLauncher3 = activityResultLauncher2;
        Function1<? super GooglePayEnvironment, ? extends GooglePayRepository> function12 = function1;
        AnalyticsRequestExecutor analyticsRequestExecutor2 = analyticsRequestExecutor;
        Intrinsics.checkNotNullParameter(coroutineScope, "lifecycleScope");
        Intrinsics.checkNotNullParameter(config3, "config");
        Intrinsics.checkNotNullParameter(readyCallback3, "readyCallback");
        Intrinsics.checkNotNullParameter(activityResultLauncher3, "activityResultLauncher");
        Intrinsics.checkNotNullParameter(function12, "googlePayRepositoryFactory");
        PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory2 = paymentAnalyticsRequestFactory;
        Intrinsics.checkNotNullParameter(paymentAnalyticsRequestFactory2, "paymentAnalyticsRequestFactory");
        Intrinsics.checkNotNullParameter(analyticsRequestExecutor2, "analyticsRequestExecutor");
        this.config = config3;
        this.readyCallback = readyCallback3;
        this.activityResultLauncher = activityResultLauncher3;
        this.googlePayRepositoryFactory = function12;
        analyticsRequestExecutor2.executeAsync(PaymentAnalyticsRequestFactory.createRequest$payments_core_release$default(paymentAnalyticsRequestFactory2, PaymentAnalyticsEvent.GooglePayLauncherInit, (Set) null, (String) null, (Token.Type) null, (PaymentAnalyticsRequestFactory.ThreeDS2UiType) null, 30, (Object) null));
        Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass5(this, (Continuation<? super AnonymousClass5>) null), 3, (Object) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GooglePayLauncher(final androidx.activity.ComponentActivity r10, final com.stripe.android.googlepaylauncher.GooglePayLauncher.Config r11, com.stripe.android.googlepaylauncher.GooglePayLauncher.ReadyCallback r12, com.stripe.android.googlepaylauncher.GooglePayLauncher.ResultCallback r13) {
        /*
            r9 = this;
            java.lang.String r0 = "activity"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "config"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "readyCallback"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "resultCallback"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            r0 = r10
            androidx.lifecycle.LifecycleOwner r0 = (androidx.lifecycle.LifecycleOwner) r0
            androidx.lifecycle.LifecycleCoroutineScope r0 = androidx.lifecycle.LifecycleOwnerKt.getLifecycleScope(r0)
            r2 = r0
            kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
            com.stripe.android.googlepaylauncher.GooglePayLauncherContract r0 = new com.stripe.android.googlepaylauncher.GooglePayLauncherContract
            r0.<init>()
            androidx.activity.result.contract.ActivityResultContract r0 = (androidx.activity.result.contract.ActivityResultContract) r0
            com.stripe.android.googlepaylauncher.-$$Lambda$GooglePayLauncher$FDd7GBILFjrKi3cb9AYXTH1smhI r1 = new com.stripe.android.googlepaylauncher.-$$Lambda$GooglePayLauncher$FDd7GBILFjrKi3cb9AYXTH1smhI
            r1.<init>()
            androidx.activity.result.ActivityResultLauncher r5 = r10.registerForActivityResult(r0, r1)
            java.lang.String r13 = "activity.registerForActi…ck.onResult(it)\n        }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r13)
            com.stripe.android.googlepaylauncher.GooglePayLauncher$2 r13 = new com.stripe.android.googlepaylauncher.GooglePayLauncher$2
            r13.<init>(r10, r11)
            r6 = r13
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            com.stripe.android.networking.PaymentAnalyticsRequestFactory r7 = new com.stripe.android.networking.PaymentAnalyticsRequestFactory
            android.content.Context r10 = (android.content.Context) r10
            com.stripe.android.PaymentConfiguration$Companion r13 = com.stripe.android.PaymentConfiguration.Companion
            com.stripe.android.PaymentConfiguration r13 = r13.getInstance(r10)
            java.lang.String r13 = r13.getPublishableKey()
            java.lang.String r0 = "GooglePayLauncher"
            java.util.Set r0 = kotlin.collections.SetsKt.setOf(r0)
            r7.<init>((android.content.Context) r10, (java.lang.String) r13, (java.util.Set<java.lang.String>) r0)
            com.stripe.android.core.networking.DefaultAnalyticsRequestExecutor r10 = new com.stripe.android.core.networking.DefaultAnalyticsRequestExecutor
            r10.<init>()
            r8 = r10
            com.stripe.android.core.networking.AnalyticsRequestExecutor r8 = (com.stripe.android.core.networking.AnalyticsRequestExecutor) r8
            r1 = r9
            r3 = r11
            r4 = r12
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.googlepaylauncher.GooglePayLauncher.<init>(androidx.activity.ComponentActivity, com.stripe.android.googlepaylauncher.GooglePayLauncher$Config, com.stripe.android.googlepaylauncher.GooglePayLauncher$ReadyCallback, com.stripe.android.googlepaylauncher.GooglePayLauncher$ResultCallback):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m4290_init_$lambda0(ResultCallback resultCallback, Result result) {
        Intrinsics.checkNotNullParameter(resultCallback, "$resultCallback");
        Intrinsics.checkNotNullExpressionValue(result, "it");
        resultCallback.onResult(result);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GooglePayLauncher(final androidx.fragment.app.Fragment r10, final com.stripe.android.googlepaylauncher.GooglePayLauncher.Config r11, com.stripe.android.googlepaylauncher.GooglePayLauncher.ReadyCallback r12, com.stripe.android.googlepaylauncher.GooglePayLauncher.ResultCallback r13) {
        /*
            r9 = this;
            java.lang.String r0 = "fragment"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "config"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "readyCallback"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "resultCallback"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            androidx.lifecycle.LifecycleOwner r0 = r10.getViewLifecycleOwner()
            java.lang.String r1 = "fragment.viewLifecycleOwner"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            androidx.lifecycle.LifecycleCoroutineScope r0 = androidx.lifecycle.LifecycleOwnerKt.getLifecycleScope(r0)
            r2 = r0
            kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
            com.stripe.android.googlepaylauncher.GooglePayLauncherContract r0 = new com.stripe.android.googlepaylauncher.GooglePayLauncherContract
            r0.<init>()
            androidx.activity.result.contract.ActivityResultContract r0 = (androidx.activity.result.contract.ActivityResultContract) r0
            com.stripe.android.googlepaylauncher.-$$Lambda$GooglePayLauncher$4w1BcWn-rNMxahZd2gHVsG54bIM r1 = new com.stripe.android.googlepaylauncher.-$$Lambda$GooglePayLauncher$4w1BcWn-rNMxahZd2gHVsG54bIM
            r1.<init>()
            androidx.activity.result.ActivityResultLauncher r5 = r10.registerForActivityResult(r0, r1)
            java.lang.String r13 = "fragment.registerForActi…ck.onResult(it)\n        }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r13)
            com.stripe.android.googlepaylauncher.GooglePayLauncher$4 r13 = new com.stripe.android.googlepaylauncher.GooglePayLauncher$4
            r13.<init>(r10, r11)
            r6 = r13
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            com.stripe.android.networking.PaymentAnalyticsRequestFactory r7 = new com.stripe.android.networking.PaymentAnalyticsRequestFactory
            android.content.Context r13 = r10.requireContext()
            java.lang.String r0 = "fragment.requireContext()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r0)
            com.stripe.android.PaymentConfiguration$Companion r1 = com.stripe.android.PaymentConfiguration.Companion
            android.content.Context r10 = r10.requireContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r0)
            com.stripe.android.PaymentConfiguration r10 = r1.getInstance(r10)
            java.lang.String r10 = r10.getPublishableKey()
            java.lang.String r0 = "GooglePayLauncher"
            java.util.Set r0 = kotlin.collections.SetsKt.setOf(r0)
            r7.<init>((android.content.Context) r13, (java.lang.String) r10, (java.util.Set<java.lang.String>) r0)
            com.stripe.android.core.networking.DefaultAnalyticsRequestExecutor r10 = new com.stripe.android.core.networking.DefaultAnalyticsRequestExecutor
            r10.<init>()
            r8 = r10
            com.stripe.android.core.networking.AnalyticsRequestExecutor r8 = (com.stripe.android.core.networking.AnalyticsRequestExecutor) r8
            r1 = r9
            r3 = r11
            r4 = r12
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.googlepaylauncher.GooglePayLauncher.<init>(androidx.fragment.app.Fragment, com.stripe.android.googlepaylauncher.GooglePayLauncher$Config, com.stripe.android.googlepaylauncher.GooglePayLauncher$ReadyCallback, com.stripe.android.googlepaylauncher.GooglePayLauncher$ResultCallback):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m4291_init_$lambda1(ResultCallback resultCallback, Result result) {
        Intrinsics.checkNotNullParameter(resultCallback, "$resultCallback");
        Intrinsics.checkNotNullExpressionValue(result, "it");
        resultCallback.onResult(result);
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.stripe.android.googlepaylauncher.GooglePayLauncher$5", f = "GooglePayLauncher.kt", i = {}, l = {131}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stripe.android.googlepaylauncher.GooglePayLauncher$5  reason: invalid class name */
    /* compiled from: GooglePayLauncher.kt */
    static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ GooglePayLauncher this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass5(this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            ReadyCallback readyCallback;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ReadyCallback access$getReadyCallback$p = this.this$0.readyCallback;
                this.L$0 = access$getReadyCallback$p;
                this.label = 1;
                obj = FlowKt.first(((GooglePayRepository) this.this$0.googlePayRepositoryFactory.invoke(this.this$0.config.getEnvironment())).isReady(), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                readyCallback = access$getReadyCallback$p;
            } else if (i == 1) {
                readyCallback = (ReadyCallback) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Boolean bool = (Boolean) obj;
            this.this$0.isReady = bool.booleanValue();
            readyCallback.onReady(bool.booleanValue());
            return Unit.INSTANCE;
        }
    }

    public final void presentForPaymentIntent(String str) {
        Intrinsics.checkNotNullParameter(str, "clientSecret");
        if (this.isReady) {
            this.activityResultLauncher.launch(new GooglePayLauncherContract.PaymentIntentArgs(str, this.config));
            return;
        }
        throw new IllegalStateException("presentForPaymentIntent() may only be called when Google Pay is available on this device.".toString());
    }

    public final void presentForSetupIntent(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "clientSecret");
        Intrinsics.checkNotNullParameter(str2, "currencyCode");
        if (this.isReady) {
            this.activityResultLauncher.launch(new GooglePayLauncherContract.SetupIntentArgs(str, this.config, str2));
            return;
        }
        throw new IllegalStateException("presentForSetupIntent() may only be called when Google Pay is available on this device.".toString());
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B=\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b¢\u0006\u0002\u0010\fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J\t\u0010!\u001a\u00020\nHÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003JE\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\bHÆ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001J\u0013\u0010&\u001a\u00020\b2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020%HÖ\u0001J\t\u0010*\u001a\u00020\u0005HÖ\u0001J\u0019\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020%HÖ\u0001R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u000b\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u0014\"\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\b8@X\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001b¨\u00060"}, d2 = {"Lcom/stripe/android/googlepaylauncher/GooglePayLauncher$Config;", "Landroid/os/Parcelable;", "environment", "Lcom/stripe/android/googlepaylauncher/GooglePayEnvironment;", "merchantCountryCode", "", "merchantName", "isEmailRequired", "", "billingAddressConfig", "Lcom/stripe/android/googlepaylauncher/GooglePayLauncher$BillingAddressConfig;", "existingPaymentMethodRequired", "(Lcom/stripe/android/googlepaylauncher/GooglePayEnvironment;Ljava/lang/String;Ljava/lang/String;ZLcom/stripe/android/googlepaylauncher/GooglePayLauncher$BillingAddressConfig;Z)V", "getBillingAddressConfig", "()Lcom/stripe/android/googlepaylauncher/GooglePayLauncher$BillingAddressConfig;", "setBillingAddressConfig", "(Lcom/stripe/android/googlepaylauncher/GooglePayLauncher$BillingAddressConfig;)V", "getEnvironment", "()Lcom/stripe/android/googlepaylauncher/GooglePayEnvironment;", "getExistingPaymentMethodRequired", "()Z", "setExistingPaymentMethodRequired", "(Z)V", "setEmailRequired", "isJcbEnabled", "isJcbEnabled$payments_core_release", "getMerchantCountryCode", "()Ljava/lang/String;", "getMerchantName", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GooglePayLauncher.kt */
    public static final class Config implements Parcelable {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Config> CREATOR = new Creator();
        private BillingAddressConfig billingAddressConfig;
        private final GooglePayEnvironment environment;
        private boolean existingPaymentMethodRequired;
        private boolean isEmailRequired;
        private final String merchantCountryCode;
        private final String merchantName;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: GooglePayLauncher.kt */
        public static final class Creator implements Parcelable.Creator<Config> {
            public final Config createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Config(GooglePayEnvironment.valueOf(parcel.readString()), parcel.readString(), parcel.readString(), parcel.readInt() != 0, BillingAddressConfig.CREATOR.createFromParcel(parcel), parcel.readInt() != 0);
            }

            public final Config[] newArray(int i) {
                return new Config[i];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Config(GooglePayEnvironment googlePayEnvironment, String str, String str2) {
            this(googlePayEnvironment, str, str2, false, (BillingAddressConfig) null, false, 56, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(googlePayEnvironment, "environment");
            Intrinsics.checkNotNullParameter(str, "merchantCountryCode");
            Intrinsics.checkNotNullParameter(str2, "merchantName");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Config(GooglePayEnvironment googlePayEnvironment, String str, String str2, boolean z) {
            this(googlePayEnvironment, str, str2, z, (BillingAddressConfig) null, false, 48, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(googlePayEnvironment, "environment");
            Intrinsics.checkNotNullParameter(str, "merchantCountryCode");
            Intrinsics.checkNotNullParameter(str2, "merchantName");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Config(GooglePayEnvironment googlePayEnvironment, String str, String str2, boolean z, BillingAddressConfig billingAddressConfig2) {
            this(googlePayEnvironment, str, str2, z, billingAddressConfig2, false, 32, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(googlePayEnvironment, "environment");
            Intrinsics.checkNotNullParameter(str, "merchantCountryCode");
            Intrinsics.checkNotNullParameter(str2, "merchantName");
            Intrinsics.checkNotNullParameter(billingAddressConfig2, "billingAddressConfig");
        }

        public static /* synthetic */ Config copy$default(Config config, GooglePayEnvironment googlePayEnvironment, String str, String str2, boolean z, BillingAddressConfig billingAddressConfig2, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                googlePayEnvironment = config.environment;
            }
            if ((i & 2) != 0) {
                str = config.merchantCountryCode;
            }
            String str3 = str;
            if ((i & 4) != 0) {
                str2 = config.merchantName;
            }
            String str4 = str2;
            if ((i & 8) != 0) {
                z = config.isEmailRequired;
            }
            boolean z3 = z;
            if ((i & 16) != 0) {
                billingAddressConfig2 = config.billingAddressConfig;
            }
            BillingAddressConfig billingAddressConfig3 = billingAddressConfig2;
            if ((i & 32) != 0) {
                z2 = config.existingPaymentMethodRequired;
            }
            return config.copy(googlePayEnvironment, str3, str4, z3, billingAddressConfig3, z2);
        }

        public final GooglePayEnvironment component1() {
            return this.environment;
        }

        public final String component2() {
            return this.merchantCountryCode;
        }

        public final String component3() {
            return this.merchantName;
        }

        public final boolean component4() {
            return this.isEmailRequired;
        }

        public final BillingAddressConfig component5() {
            return this.billingAddressConfig;
        }

        public final boolean component6() {
            return this.existingPaymentMethodRequired;
        }

        public final Config copy(GooglePayEnvironment googlePayEnvironment, String str, String str2, boolean z, BillingAddressConfig billingAddressConfig2, boolean z2) {
            Intrinsics.checkNotNullParameter(googlePayEnvironment, "environment");
            Intrinsics.checkNotNullParameter(str, "merchantCountryCode");
            Intrinsics.checkNotNullParameter(str2, "merchantName");
            Intrinsics.checkNotNullParameter(billingAddressConfig2, "billingAddressConfig");
            return new Config(googlePayEnvironment, str, str2, z, billingAddressConfig2, z2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Config)) {
                return false;
            }
            Config config = (Config) obj;
            return this.environment == config.environment && Intrinsics.areEqual((Object) this.merchantCountryCode, (Object) config.merchantCountryCode) && Intrinsics.areEqual((Object) this.merchantName, (Object) config.merchantName) && this.isEmailRequired == config.isEmailRequired && Intrinsics.areEqual((Object) this.billingAddressConfig, (Object) config.billingAddressConfig) && this.existingPaymentMethodRequired == config.existingPaymentMethodRequired;
        }

        public int hashCode() {
            int hashCode = ((((this.environment.hashCode() * 31) + this.merchantCountryCode.hashCode()) * 31) + this.merchantName.hashCode()) * 31;
            boolean z = this.isEmailRequired;
            boolean z2 = true;
            if (z) {
                z = true;
            }
            int hashCode2 = (((hashCode + (z ? 1 : 0)) * 31) + this.billingAddressConfig.hashCode()) * 31;
            boolean z3 = this.existingPaymentMethodRequired;
            if (!z3) {
                z2 = z3;
            }
            return hashCode2 + (z2 ? 1 : 0);
        }

        public String toString() {
            return "Config(environment=" + this.environment + ", merchantCountryCode=" + this.merchantCountryCode + ", merchantName=" + this.merchantName + ", isEmailRequired=" + this.isEmailRequired + ", billingAddressConfig=" + this.billingAddressConfig + ", existingPaymentMethodRequired=" + this.existingPaymentMethodRequired + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.environment.name());
            parcel.writeString(this.merchantCountryCode);
            parcel.writeString(this.merchantName);
            parcel.writeInt(this.isEmailRequired ? 1 : 0);
            this.billingAddressConfig.writeToParcel(parcel, i);
            parcel.writeInt(this.existingPaymentMethodRequired ? 1 : 0);
        }

        public Config(GooglePayEnvironment googlePayEnvironment, String str, String str2, boolean z, BillingAddressConfig billingAddressConfig2, boolean z2) {
            Intrinsics.checkNotNullParameter(googlePayEnvironment, "environment");
            Intrinsics.checkNotNullParameter(str, "merchantCountryCode");
            Intrinsics.checkNotNullParameter(str2, "merchantName");
            Intrinsics.checkNotNullParameter(billingAddressConfig2, "billingAddressConfig");
            this.environment = googlePayEnvironment;
            this.merchantCountryCode = str;
            this.merchantName = str2;
            this.isEmailRequired = z;
            this.billingAddressConfig = billingAddressConfig2;
            this.existingPaymentMethodRequired = z2;
        }

        public final GooglePayEnvironment getEnvironment() {
            return this.environment;
        }

        public final String getMerchantCountryCode() {
            return this.merchantCountryCode;
        }

        public final String getMerchantName() {
            return this.merchantName;
        }

        public final boolean isEmailRequired() {
            return this.isEmailRequired;
        }

        public final void setEmailRequired(boolean z) {
            this.isEmailRequired = z;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Config(GooglePayEnvironment googlePayEnvironment, String str, String str2, boolean z, BillingAddressConfig billingAddressConfig2, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(googlePayEnvironment, str, str2, (i & 8) != 0 ? false : z, (i & 16) != 0 ? new BillingAddressConfig(false, (BillingAddressConfig.Format) null, false, 7, (DefaultConstructorMarker) null) : billingAddressConfig2, (i & 32) != 0 ? true : z2);
        }

        public final BillingAddressConfig getBillingAddressConfig() {
            return this.billingAddressConfig;
        }

        public final void setBillingAddressConfig(BillingAddressConfig billingAddressConfig2) {
            Intrinsics.checkNotNullParameter(billingAddressConfig2, "<set-?>");
            this.billingAddressConfig = billingAddressConfig2;
        }

        public final boolean getExistingPaymentMethodRequired() {
            return this.existingPaymentMethodRequired;
        }

        public final void setExistingPaymentMethodRequired(boolean z) {
            this.existingPaymentMethodRequired = z;
        }

        public final boolean isJcbEnabled$payments_core_release() {
            return StringsKt.equals(this.merchantCountryCode, Locale.JAPAN.getCountry(), true);
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001!B%\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u000e\u0010\r\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u000eJ\u000e\u0010\u000f\u001a\u00020\u0005HÀ\u0003¢\u0006\u0002\b\u0010J\u000e\u0010\u0011\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u0012J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0015HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0015HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0006\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\""}, d2 = {"Lcom/stripe/android/googlepaylauncher/GooglePayLauncher$BillingAddressConfig;", "Landroid/os/Parcelable;", "isRequired", "", "format", "Lcom/stripe/android/googlepaylauncher/GooglePayLauncher$BillingAddressConfig$Format;", "isPhoneNumberRequired", "(ZLcom/stripe/android/googlepaylauncher/GooglePayLauncher$BillingAddressConfig$Format;Z)V", "getFormat$payments_core_release", "()Lcom/stripe/android/googlepaylauncher/GooglePayLauncher$BillingAddressConfig$Format;", "isPhoneNumberRequired$payments_core_release", "()Z", "isRequired$payments_core_release", "component1", "component1$payments_core_release", "component2", "component2$payments_core_release", "component3", "component3$payments_core_release", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Format", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GooglePayLauncher.kt */
    public static final class BillingAddressConfig implements Parcelable {
        public static final int $stable = 8;
        public static final Parcelable.Creator<BillingAddressConfig> CREATOR = new Creator();
        private final Format format;
        private final boolean isPhoneNumberRequired;
        private final boolean isRequired;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: GooglePayLauncher.kt */
        public static final class Creator implements Parcelable.Creator<BillingAddressConfig> {
            public final BillingAddressConfig createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                boolean z = true;
                boolean z2 = parcel.readInt() != 0;
                Format valueOf = Format.valueOf(parcel.readString());
                if (parcel.readInt() == 0) {
                    z = false;
                }
                return new BillingAddressConfig(z2, valueOf, z);
            }

            public final BillingAddressConfig[] newArray(int i) {
                return new BillingAddressConfig[i];
            }
        }

        public BillingAddressConfig() {
            this(false, (Format) null, false, 7, (DefaultConstructorMarker) null);
        }

        public BillingAddressConfig(boolean z) {
            this(z, (Format) null, false, 6, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public BillingAddressConfig(boolean z, Format format2) {
            this(z, format2, false, 4, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(format2, "format");
        }

        public static /* synthetic */ BillingAddressConfig copy$default(BillingAddressConfig billingAddressConfig, boolean z, Format format2, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                z = billingAddressConfig.isRequired;
            }
            if ((i & 2) != 0) {
                format2 = billingAddressConfig.format;
            }
            if ((i & 4) != 0) {
                z2 = billingAddressConfig.isPhoneNumberRequired;
            }
            return billingAddressConfig.copy(z, format2, z2);
        }

        public final boolean component1$payments_core_release() {
            return this.isRequired;
        }

        public final Format component2$payments_core_release() {
            return this.format;
        }

        public final boolean component3$payments_core_release() {
            return this.isPhoneNumberRequired;
        }

        public final BillingAddressConfig copy(boolean z, Format format2, boolean z2) {
            Intrinsics.checkNotNullParameter(format2, "format");
            return new BillingAddressConfig(z, format2, z2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BillingAddressConfig)) {
                return false;
            }
            BillingAddressConfig billingAddressConfig = (BillingAddressConfig) obj;
            return this.isRequired == billingAddressConfig.isRequired && this.format == billingAddressConfig.format && this.isPhoneNumberRequired == billingAddressConfig.isPhoneNumberRequired;
        }

        public int hashCode() {
            boolean z = this.isRequired;
            boolean z2 = true;
            if (z) {
                z = true;
            }
            int hashCode = (((z ? 1 : 0) * true) + this.format.hashCode()) * 31;
            boolean z3 = this.isPhoneNumberRequired;
            if (!z3) {
                z2 = z3;
            }
            return hashCode + (z2 ? 1 : 0);
        }

        public String toString() {
            return "BillingAddressConfig(isRequired=" + this.isRequired + ", format=" + this.format + ", isPhoneNumberRequired=" + this.isPhoneNumberRequired + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(this.isRequired ? 1 : 0);
            parcel.writeString(this.format.name());
            parcel.writeInt(this.isPhoneNumberRequired ? 1 : 0);
        }

        public BillingAddressConfig(boolean z, Format format2, boolean z2) {
            Intrinsics.checkNotNullParameter(format2, "format");
            this.isRequired = z;
            this.format = format2;
            this.isPhoneNumberRequired = z2;
        }

        public final boolean isRequired$payments_core_release() {
            return this.isRequired;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ BillingAddressConfig(boolean z, Format format2, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? Format.Min : format2, (i & 4) != 0 ? false : z2);
        }

        public final Format getFormat$payments_core_release() {
            return this.format;
        }

        public final boolean isPhoneNumberRequired$payments_core_release() {
            return this.isPhoneNumberRequired;
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/stripe/android/googlepaylauncher/GooglePayLauncher$BillingAddressConfig$Format;", "", "code", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getCode$payments_core_release", "()Ljava/lang/String;", "Min", "Full", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: GooglePayLauncher.kt */
        public enum Format {
            Min("MIN"),
            Full("FULL");
            
            private final String code;

            private Format(String str) {
                this.code = str;
            }

            public final String getCode$payments_core_release() {
                return this.code;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/stripe/android/googlepaylauncher/GooglePayLauncher$Result;", "Landroid/os/Parcelable;", "()V", "Canceled", "Completed", "Failed", "Lcom/stripe/android/googlepaylauncher/GooglePayLauncher$Result$Completed;", "Lcom/stripe/android/googlepaylauncher/GooglePayLauncher$Result$Failed;", "Lcom/stripe/android/googlepaylauncher/GooglePayLauncher$Result$Canceled;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GooglePayLauncher.kt */
    public static abstract class Result implements Parcelable {
        public static final int $stable = 0;

        public /* synthetic */ Result(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Result() {
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, d2 = {"Lcom/stripe/android/googlepaylauncher/GooglePayLauncher$Result$Completed;", "Lcom/stripe/android/googlepaylauncher/GooglePayLauncher$Result;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: GooglePayLauncher.kt */
        public static final class Completed extends Result {
            public static final int $stable = 8;
            public static final Parcelable.Creator<Completed> CREATOR = new Creator();
            public static final Completed INSTANCE = new Completed();

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* compiled from: GooglePayLauncher.kt */
            public static final class Creator implements Parcelable.Creator<Completed> {
                public final Completed createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    parcel.readInt();
                    return Completed.INSTANCE;
                }

                public final Completed[] newArray(int i) {
                    return new Completed[i];
                }
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeInt(1);
            }

            private Completed() {
                super((DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/stripe/android/googlepaylauncher/GooglePayLauncher$Result$Failed;", "Lcom/stripe/android/googlepaylauncher/GooglePayLauncher$Result;", "error", "", "(Ljava/lang/Throwable;)V", "getError", "()Ljava/lang/Throwable;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: GooglePayLauncher.kt */
        public static final class Failed extends Result {
            public static final int $stable = 8;
            public static final Parcelable.Creator<Failed> CREATOR = new Creator();
            private final Throwable error;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* compiled from: GooglePayLauncher.kt */
            public static final class Creator implements Parcelable.Creator<Failed> {
                public final Failed createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new Failed((Throwable) parcel.readSerializable());
                }

                public final Failed[] newArray(int i) {
                    return new Failed[i];
                }
            }

            public static /* synthetic */ Failed copy$default(Failed failed, Throwable th, int i, Object obj) {
                if ((i & 1) != 0) {
                    th = failed.error;
                }
                return failed.copy(th);
            }

            public final Throwable component1() {
                return this.error;
            }

            public final Failed copy(Throwable th) {
                Intrinsics.checkNotNullParameter(th, ReactVideoView.EVENT_PROP_ERROR);
                return new Failed(th);
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Failed) && Intrinsics.areEqual((Object) this.error, (Object) ((Failed) obj).error);
            }

            public int hashCode() {
                return this.error.hashCode();
            }

            public String toString() {
                return "Failed(error=" + this.error + ')';
            }

            public void writeToParcel(Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeSerializable(this.error);
            }

            public final Throwable getError() {
                return this.error;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Failed(Throwable th) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(th, ReactVideoView.EVENT_PROP_ERROR);
                this.error = th;
            }
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, d2 = {"Lcom/stripe/android/googlepaylauncher/GooglePayLauncher$Result$Canceled;", "Lcom/stripe/android/googlepaylauncher/GooglePayLauncher$Result;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: GooglePayLauncher.kt */
        public static final class Canceled extends Result {
            public static final int $stable = 8;
            public static final Parcelable.Creator<Canceled> CREATOR = new Creator();
            public static final Canceled INSTANCE = new Canceled();

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* compiled from: GooglePayLauncher.kt */
            public static final class Creator implements Parcelable.Creator<Canceled> {
                public final Canceled createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    parcel.readInt();
                    return Canceled.INSTANCE;
                }

                public final Canceled[] newArray(int i) {
                    return new Canceled[i];
                }
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeInt(1);
            }

            private Canceled() {
                super((DefaultConstructorMarker) null);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/googlepaylauncher/GooglePayLauncher$Companion;", "", "()V", "PRODUCT_USAGE", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GooglePayLauncher.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
