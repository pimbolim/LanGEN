package com.stripe.android;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.stripe.android.PaymentSessionViewModel;
import com.stripe.android.view.ActivityStarter;
import com.stripe.android.view.PaymentFlowActivity;
import com.stripe.android.view.PaymentFlowActivityStarter;
import com.stripe.android.view.PaymentMethodsActivity;
import com.stripe.android.view.PaymentMethodsActivityStarter;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000«\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003*\u0001!\b\u0007\u0018\u0000 B2\u00020\u0001:\u0002BCB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0017\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tBq\b\u0001\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0017\u0012\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u0017\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001e¢\u0006\u0002\u0010\u001fJ\u0006\u0010-\u001a\u00020.J\u0012\u0010/\u001a\u00020.2\b\b\u0002\u00100\u001a\u000201H\u0002J \u00102\u001a\u0002012\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002042\b\u00106\u001a\u0004\u0018\u000107J\u000e\u00108\u001a\u00020.2\u0006\u0010#\u001a\u00020$J\u0006\u00109\u001a\u00020.J\u0010\u0010:\u001a\u00020.2\u0006\u00106\u001a\u000207H\u0002J\u0012\u0010;\u001a\u00020.2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010=J\u0006\u0010>\u001a\u00020.J\u0010\u0010?\u001a\u00020.2\b\b\u0001\u0010@\u001a\u00020AR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u00020!X\u0004¢\u0006\u0004\n\u0002\u0010\"R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u0017X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0017X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010)\u001a\u00020*X\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,¨\u0006D"}, d2 = {"Lcom/stripe/android/PaymentSession;", "", "activity", "Landroidx/activity/ComponentActivity;", "config", "Lcom/stripe/android/PaymentSessionConfig;", "(Landroidx/activity/ComponentActivity;Lcom/stripe/android/PaymentSessionConfig;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;Lcom/stripe/android/PaymentSessionConfig;)V", "context", "Landroid/content/Context;", "application", "Landroid/app/Application;", "viewModelStoreOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "savedStateRegistryOwner", "Landroidx/savedstate/SavedStateRegistryOwner;", "customerSession", "Lcom/stripe/android/CustomerSession;", "paymentMethodsActivityStarter", "Lcom/stripe/android/view/ActivityStarter;", "Lcom/stripe/android/view/PaymentMethodsActivity;", "Lcom/stripe/android/view/PaymentMethodsActivityStarter$Args;", "paymentFlowActivityStarter", "Lcom/stripe/android/view/PaymentFlowActivity;", "Lcom/stripe/android/view/PaymentFlowActivityStarter$Args;", "paymentSessionData", "Lcom/stripe/android/PaymentSessionData;", "(Landroid/content/Context;Landroid/app/Application;Landroidx/lifecycle/ViewModelStoreOwner;Landroidx/lifecycle/LifecycleOwner;Landroidx/savedstate/SavedStateRegistryOwner;Lcom/stripe/android/PaymentSessionConfig;Lcom/stripe/android/CustomerSession;Lcom/stripe/android/view/ActivityStarter;Lcom/stripe/android/view/ActivityStarter;Lcom/stripe/android/PaymentSessionData;)V", "lifecycleObserver", "com/stripe/android/PaymentSession$lifecycleObserver$1", "Lcom/stripe/android/PaymentSession$lifecycleObserver$1;", "listener", "Lcom/stripe/android/PaymentSession$PaymentSessionListener;", "getListener$payments_core_release", "()Lcom/stripe/android/PaymentSession$PaymentSessionListener;", "setListener$payments_core_release", "(Lcom/stripe/android/PaymentSession$PaymentSessionListener;)V", "viewModel", "Lcom/stripe/android/PaymentSessionViewModel;", "getViewModel$payments_core_release", "()Lcom/stripe/android/PaymentSessionViewModel;", "clearPaymentMethod", "", "fetchCustomer", "isInitialFetch", "", "handlePaymentData", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "init", "onCompleted", "onPaymentMethodResult", "presentPaymentMethodSelection", "selectedPaymentMethodId", "", "presentShippingFlow", "setCartTotal", "cartTotal", "", "Companion", "PaymentSessionListener", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentSession.kt */
public final class PaymentSession {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EXTRA_PAYMENT_SESSION_DATA = "extra_payment_session_data";
    public static final String PRODUCT_TOKEN = "PaymentSession";
    /* access modifiers changed from: private */
    public static final Set<Integer> VALID_REQUEST_CODES = SetsKt.setOf(Integer.valueOf(PaymentMethodsActivityStarter.REQUEST_CODE), Integer.valueOf(PaymentFlowActivityStarter.REQUEST_CODE));
    private final PaymentSessionConfig config;
    private final Context context;
    private final PaymentSession$lifecycleObserver$1 lifecycleObserver;
    private final LifecycleOwner lifecycleOwner;
    private /* synthetic */ PaymentSessionListener listener;
    private final ActivityStarter<PaymentFlowActivity, PaymentFlowActivityStarter.Args> paymentFlowActivityStarter;
    private final ActivityStarter<PaymentMethodsActivity, PaymentMethodsActivityStarter.Args> paymentMethodsActivityStarter;
    private final PaymentSessionViewModel viewModel;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&¨\u0006\u000e"}, d2 = {"Lcom/stripe/android/PaymentSession$PaymentSessionListener;", "", "onCommunicatingStateChanged", "", "isCommunicating", "", "onError", "errorCode", "", "errorMessage", "", "onPaymentSessionDataChanged", "data", "Lcom/stripe/android/PaymentSessionData;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentSession.kt */
    public interface PaymentSessionListener {
        void onCommunicatingStateChanged(boolean z);

        void onError(int i, String str);

        void onPaymentSessionDataChanged(PaymentSessionData paymentSessionData);
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentSession.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PaymentSessionViewModel.NetworkState.values().length];
            iArr[PaymentSessionViewModel.NetworkState.Active.ordinal()] = 1;
            iArr[PaymentSessionViewModel.NetworkState.Inactive.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public PaymentSession(Context context2, Application application, ViewModelStoreOwner viewModelStoreOwner, LifecycleOwner lifecycleOwner2, SavedStateRegistryOwner savedStateRegistryOwner, PaymentSessionConfig paymentSessionConfig, CustomerSession customerSession, ActivityStarter<PaymentMethodsActivity, PaymentMethodsActivityStarter.Args> activityStarter, ActivityStarter<PaymentFlowActivity, PaymentFlowActivityStarter.Args> activityStarter2, PaymentSessionData paymentSessionData) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(viewModelStoreOwner, "viewModelStoreOwner");
        Intrinsics.checkNotNullParameter(lifecycleOwner2, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(savedStateRegistryOwner, "savedStateRegistryOwner");
        Intrinsics.checkNotNullParameter(paymentSessionConfig, "config");
        Intrinsics.checkNotNullParameter(customerSession, "customerSession");
        Intrinsics.checkNotNullParameter(activityStarter, "paymentMethodsActivityStarter");
        Intrinsics.checkNotNullParameter(activityStarter2, "paymentFlowActivityStarter");
        Intrinsics.checkNotNullParameter(paymentSessionData, "paymentSessionData");
        this.context = context2;
        this.lifecycleOwner = lifecycleOwner2;
        this.config = paymentSessionConfig;
        this.paymentMethodsActivityStarter = activityStarter;
        this.paymentFlowActivityStarter = activityStarter2;
        PaymentSessionViewModel paymentSessionViewModel = (PaymentSessionViewModel) new ViewModelProvider(viewModelStoreOwner, (ViewModelProvider.Factory) new PaymentSessionViewModel.Factory(application, savedStateRegistryOwner, paymentSessionData, customerSession)).get(PaymentSessionViewModel.class);
        this.viewModel = paymentSessionViewModel;
        PaymentSession$lifecycleObserver$1 paymentSession$lifecycleObserver$1 = new PaymentSession$lifecycleObserver$1(this);
        this.lifecycleObserver = paymentSession$lifecycleObserver$1;
        lifecycleOwner2.getLifecycle().addObserver(paymentSession$lifecycleObserver$1);
        paymentSessionViewModel.getNetworkState$payments_core_release().observe(lifecycleOwner2, new Observer() {
            public final void onChanged(Object obj) {
                PaymentSession.m4280_init_$lambda1(PaymentSession.this, (PaymentSessionViewModel.NetworkState) obj);
            }
        });
        paymentSessionViewModel.getPaymentSessionDataLiveData().observe(lifecycleOwner2, new Observer() {
            public final void onChanged(Object obj) {
                PaymentSession.m4281_init_$lambda2(PaymentSession.this, (PaymentSessionData) obj);
            }
        });
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PaymentSession(android.content.Context r13, android.app.Application r14, androidx.lifecycle.ViewModelStoreOwner r15, androidx.lifecycle.LifecycleOwner r16, androidx.savedstate.SavedStateRegistryOwner r17, com.stripe.android.PaymentSessionConfig r18, com.stripe.android.CustomerSession r19, com.stripe.android.view.ActivityStarter r20, com.stripe.android.view.ActivityStarter r21, com.stripe.android.PaymentSessionData r22, int r23, kotlin.jvm.internal.DefaultConstructorMarker r24) {
        /*
            r12 = this;
            r0 = r23
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x000f
            com.stripe.android.PaymentSessionData r0 = new com.stripe.android.PaymentSessionData
            r7 = r18
            r0.<init>(r7)
            r11 = r0
            goto L_0x0013
        L_0x000f:
            r7 = r18
            r11 = r22
        L_0x0013:
            r1 = r12
            r2 = r13
            r3 = r14
            r4 = r15
            r5 = r16
            r6 = r17
            r7 = r18
            r8 = r19
            r9 = r20
            r10 = r21
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.PaymentSession.<init>(android.content.Context, android.app.Application, androidx.lifecycle.ViewModelStoreOwner, androidx.lifecycle.LifecycleOwner, androidx.savedstate.SavedStateRegistryOwner, com.stripe.android.PaymentSessionConfig, com.stripe.android.CustomerSession, com.stripe.android.view.ActivityStarter, com.stripe.android.view.ActivityStarter, com.stripe.android.PaymentSessionData, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final PaymentSessionViewModel getViewModel$payments_core_release() {
        return this.viewModel;
    }

    public final PaymentSessionListener getListener$payments_core_release() {
        return this.listener;
    }

    public final void setListener$payments_core_release(PaymentSessionListener paymentSessionListener) {
        this.listener = paymentSessionListener;
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m4280_init_$lambda1(PaymentSession paymentSession, PaymentSessionViewModel.NetworkState networkState) {
        PaymentSessionListener listener$payments_core_release;
        Intrinsics.checkNotNullParameter(paymentSession, "this$0");
        if (networkState != null && (listener$payments_core_release = paymentSession.getListener$payments_core_release()) != null) {
            int i = WhenMappings.$EnumSwitchMapping$0[networkState.ordinal()];
            boolean z = true;
            if (i != 1) {
                if (i == 2) {
                    z = false;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
            listener$payments_core_release.onCommunicatingStateChanged(z);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-2  reason: not valid java name */
    public static final void m4281_init_$lambda2(PaymentSession paymentSession, PaymentSessionData paymentSessionData) {
        Intrinsics.checkNotNullParameter(paymentSession, "this$0");
        PaymentSessionListener paymentSessionListener = paymentSession.listener;
        if (paymentSessionListener != null) {
            Intrinsics.checkNotNullExpressionValue(paymentSessionData, "it");
            paymentSessionListener.onPaymentSessionDataChanged(paymentSessionData);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PaymentSession(androidx.activity.ComponentActivity r14, com.stripe.android.PaymentSessionConfig r15) {
        /*
            r13 = this;
            java.lang.String r1 = "activity"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r1)
            java.lang.String r1 = "config"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r1)
            android.content.Context r1 = r14.getApplicationContext()
            java.lang.String r2 = "activity.applicationContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            android.app.Application r2 = r14.getApplication()
            java.lang.String r3 = "activity.application"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            r3 = r14
            androidx.lifecycle.ViewModelStoreOwner r3 = (androidx.lifecycle.ViewModelStoreOwner) r3
            r4 = r14
            androidx.lifecycle.LifecycleOwner r4 = (androidx.lifecycle.LifecycleOwner) r4
            r5 = r14
            androidx.savedstate.SavedStateRegistryOwner r5 = (androidx.savedstate.SavedStateRegistryOwner) r5
            com.stripe.android.CustomerSession$Companion r7 = com.stripe.android.CustomerSession.Companion
            com.stripe.android.CustomerSession r7 = r7.getInstance()
            com.stripe.android.view.PaymentMethodsActivityStarter r8 = new com.stripe.android.view.PaymentMethodsActivityStarter
            r0 = r14
            android.app.Activity r0 = (android.app.Activity) r0
            r8.<init>((android.app.Activity) r0)
            com.stripe.android.view.ActivityStarter r8 = (com.stripe.android.view.ActivityStarter) r8
            com.stripe.android.view.PaymentFlowActivityStarter r9 = new com.stripe.android.view.PaymentFlowActivityStarter
            r9.<init>((android.app.Activity) r0, (com.stripe.android.PaymentSessionConfig) r15)
            com.stripe.android.view.ActivityStarter r9 = (com.stripe.android.view.ActivityStarter) r9
            r10 = 0
            r11 = 512(0x200, float:7.175E-43)
            r12 = 0
            r0 = r13
            r6 = r15
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.PaymentSession.<init>(androidx.activity.ComponentActivity, com.stripe.android.PaymentSessionConfig):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PaymentSession(androidx.fragment.app.Fragment r14, com.stripe.android.PaymentSessionConfig r15) {
        /*
            r13 = this;
            java.lang.String r1 = "fragment"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r1)
            java.lang.String r1 = "config"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r1)
            androidx.fragment.app.FragmentActivity r1 = r14.requireActivity()
            android.content.Context r1 = r1.getApplicationContext()
            java.lang.String r2 = "fragment.requireActivity().applicationContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            androidx.fragment.app.FragmentActivity r2 = r14.requireActivity()
            android.app.Application r2 = r2.getApplication()
            java.lang.String r3 = "fragment.requireActivity().application"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            r3 = r14
            androidx.lifecycle.ViewModelStoreOwner r3 = (androidx.lifecycle.ViewModelStoreOwner) r3
            r4 = r14
            androidx.lifecycle.LifecycleOwner r4 = (androidx.lifecycle.LifecycleOwner) r4
            r5 = r14
            androidx.savedstate.SavedStateRegistryOwner r5 = (androidx.savedstate.SavedStateRegistryOwner) r5
            com.stripe.android.CustomerSession$Companion r7 = com.stripe.android.CustomerSession.Companion
            com.stripe.android.CustomerSession r7 = r7.getInstance()
            com.stripe.android.view.PaymentMethodsActivityStarter r8 = new com.stripe.android.view.PaymentMethodsActivityStarter
            r8.<init>((androidx.fragment.app.Fragment) r14)
            com.stripe.android.view.ActivityStarter r8 = (com.stripe.android.view.ActivityStarter) r8
            com.stripe.android.view.PaymentFlowActivityStarter r9 = new com.stripe.android.view.PaymentFlowActivityStarter
            r9.<init>((androidx.fragment.app.Fragment) r14, (com.stripe.android.PaymentSessionConfig) r15)
            com.stripe.android.view.ActivityStarter r9 = (com.stripe.android.view.ActivityStarter) r9
            r10 = 0
            r11 = 512(0x200, float:7.175E-43)
            r12 = 0
            r0 = r13
            r6 = r15
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.PaymentSession.<init>(androidx.fragment.app.Fragment, com.stripe.android.PaymentSessionConfig):void");
    }

    public final void onCompleted() {
        this.viewModel.onCompleted();
    }

    public final boolean handlePaymentData(int i, int i2, Intent intent) {
        if (intent == null || !Companion.isValidRequestCode(i)) {
            return false;
        }
        if (i2 == -1) {
            if (i == 6000) {
                onPaymentMethodResult(intent);
            } else if (i != 6002) {
                return false;
            } else {
                PaymentSessionData paymentSessionData = (PaymentSessionData) intent.getParcelableExtra(EXTRA_PAYMENT_SESSION_DATA);
                if (paymentSessionData != null) {
                    getViewModel$payments_core_release().onPaymentFlowResult(paymentSessionData);
                }
            }
            return true;
        } else if (i2 != 0) {
            return false;
        } else {
            if (i == 6000) {
                onPaymentMethodResult(intent);
            } else {
                fetchCustomer$default(this, false, 1, (Object) null);
            }
            return false;
        }
    }

    private final void onPaymentMethodResult(Intent intent) {
        this.viewModel.onPaymentMethodResult(PaymentMethodsActivityStarter.Result.Companion.fromIntent(intent));
    }

    public final void init(PaymentSessionListener paymentSessionListener) {
        Intrinsics.checkNotNullParameter(paymentSessionListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.listener = paymentSessionListener;
        this.viewModel.onListenerAttached();
        if (this.config.getShouldPrefetchCustomer$payments_core_release()) {
            fetchCustomer(true);
        }
    }

    public static /* synthetic */ void presentPaymentMethodSelection$default(PaymentSession paymentSession, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        paymentSession.presentPaymentMethodSelection(str);
    }

    public final void presentPaymentMethodSelection(String str) {
        this.paymentMethodsActivityStarter.startForResult(new PaymentMethodsActivityStarter.Args.Builder().setInitialPaymentMethodId(this.viewModel.getSelectedPaymentMethodId(str)).setPaymentMethodsFooter(this.config.getPaymentMethodsFooterLayoutId()).setAddPaymentMethodFooter(this.config.getAddPaymentMethodFooterLayoutId()).setIsPaymentSessionActive(true).setPaymentConfiguration(PaymentConfiguration.Companion.getInstance(this.context)).setPaymentMethodTypes(this.config.getPaymentMethodTypes()).setShouldShowGooglePay(this.config.getShouldShowGooglePay()).setWindowFlags(this.config.getWindowFlags$payments_core_release()).setBillingAddressFields(this.config.getBillingAddressFields()).setUseGooglePay$payments_core_release(this.viewModel.getPaymentSessionData().getUseGooglePay()).setCanDeletePaymentMethods(this.config.getCanDeletePaymentMethods()).build());
    }

    public final void setCartTotal(long j) {
        this.viewModel.updateCartTotal(j);
    }

    public final void presentShippingFlow() {
        this.paymentFlowActivityStarter.startForResult(new PaymentFlowActivityStarter.Args(this.config, this.viewModel.getPaymentSessionData(), true, this.config.getWindowFlags$payments_core_release()));
    }

    public final void clearPaymentMethod() {
        this.viewModel.clearPaymentMethod();
    }

    static /* synthetic */ void fetchCustomer$default(PaymentSession paymentSession, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        paymentSession.fetchCustomer(z);
    }

    private final void fetchCustomer(boolean z) {
        this.viewModel.fetchCustomer(z).observe(this.lifecycleOwner, new Observer() {
            public final void onChanged(Object obj) {
                PaymentSession.m4282fetchCustomer$lambda4(PaymentSession.this, (PaymentSessionViewModel.FetchCustomerResult) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: fetchCustomer$lambda-4  reason: not valid java name */
    public static final void m4282fetchCustomer$lambda4(PaymentSession paymentSession, PaymentSessionViewModel.FetchCustomerResult fetchCustomerResult) {
        PaymentSessionListener paymentSessionListener;
        Intrinsics.checkNotNullParameter(paymentSession, "this$0");
        if ((fetchCustomerResult instanceof PaymentSessionViewModel.FetchCustomerResult.Error) && (paymentSessionListener = paymentSession.listener) != null) {
            PaymentSessionViewModel.FetchCustomerResult.Error error = (PaymentSessionViewModel.FetchCustomerResult.Error) fetchCustomerResult;
            paymentSessionListener.onError(error.getErrorCode(), error.getErrorMessage());
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/stripe/android/PaymentSession$Companion;", "", "()V", "EXTRA_PAYMENT_SESSION_DATA", "", "PRODUCT_TOKEN", "VALID_REQUEST_CODES", "", "", "isValidRequestCode", "", "requestCode", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentSession.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final boolean isValidRequestCode(int i) {
            return PaymentSession.VALID_REQUEST_CODES.contains(Integer.valueOf(i));
        }
    }
}
