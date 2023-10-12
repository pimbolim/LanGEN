package com.stripe.android.paymentsheet.flowcontroller;

import android.content.Context;
import androidx.activity.result.ActivityResultCaller;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import com.stripe.android.paymentsheet.PaymentOptionCallback;
import com.stripe.android.paymentsheet.PaymentSheet;
import com.stripe.android.paymentsheet.PaymentSheetResultCallback;
import com.stripe.android.paymentsheet.model.PaymentOptionFactory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u001f\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bBU\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u000e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u001bJ\u0006\u0010\u001c\u001a\u00020\u001dR\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/stripe/android/paymentsheet/flowcontroller/FlowControllerFactory;", "", "activity", "Landroidx/activity/ComponentActivity;", "paymentOptionCallback", "Lcom/stripe/android/paymentsheet/PaymentOptionCallback;", "paymentResultCallback", "Lcom/stripe/android/paymentsheet/PaymentSheetResultCallback;", "(Landroidx/activity/ComponentActivity;Lcom/stripe/android/paymentsheet/PaymentOptionCallback;Lcom/stripe/android/paymentsheet/PaymentSheetResultCallback;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;Lcom/stripe/android/paymentsheet/PaymentOptionCallback;Lcom/stripe/android/paymentsheet/PaymentSheetResultCallback;)V", "viewModelStoreOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "lifecycleScope", "Lkotlinx/coroutines/CoroutineScope;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "appContext", "Landroid/content/Context;", "activityResultCaller", "Landroidx/activity/result/ActivityResultCaller;", "statusBarColor", "Lkotlin/Function0;", "", "paymentOptionFactory", "Lcom/stripe/android/paymentsheet/model/PaymentOptionFactory;", "(Landroidx/lifecycle/ViewModelStoreOwner;Lkotlinx/coroutines/CoroutineScope;Landroidx/lifecycle/LifecycleOwner;Landroid/content/Context;Landroidx/activity/result/ActivityResultCaller;Lkotlin/jvm/functions/Function0;Lcom/stripe/android/paymentsheet/model/PaymentOptionFactory;Lcom/stripe/android/paymentsheet/PaymentOptionCallback;Lcom/stripe/android/paymentsheet/PaymentSheetResultCallback;)V", "create", "Lcom/stripe/android/paymentsheet/PaymentSheet$FlowController;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowControllerFactory.kt */
public final class FlowControllerFactory {
    private final ActivityResultCaller activityResultCaller;
    private final Context appContext;
    private final LifecycleOwner lifecycleOwner;
    private final CoroutineScope lifecycleScope;
    private final PaymentOptionCallback paymentOptionCallback;
    private final PaymentOptionFactory paymentOptionFactory;
    private final PaymentSheetResultCallback paymentResultCallback;
    private final Function0<Integer> statusBarColor;
    private final ViewModelStoreOwner viewModelStoreOwner;

    public FlowControllerFactory(ViewModelStoreOwner viewModelStoreOwner2, CoroutineScope coroutineScope, LifecycleOwner lifecycleOwner2, Context context, ActivityResultCaller activityResultCaller2, Function0<Integer> function0, PaymentOptionFactory paymentOptionFactory2, PaymentOptionCallback paymentOptionCallback2, PaymentSheetResultCallback paymentSheetResultCallback) {
        Intrinsics.checkNotNullParameter(viewModelStoreOwner2, "viewModelStoreOwner");
        Intrinsics.checkNotNullParameter(coroutineScope, "lifecycleScope");
        Intrinsics.checkNotNullParameter(lifecycleOwner2, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(context, "appContext");
        Intrinsics.checkNotNullParameter(activityResultCaller2, "activityResultCaller");
        Intrinsics.checkNotNullParameter(function0, "statusBarColor");
        Intrinsics.checkNotNullParameter(paymentOptionFactory2, "paymentOptionFactory");
        Intrinsics.checkNotNullParameter(paymentOptionCallback2, "paymentOptionCallback");
        Intrinsics.checkNotNullParameter(paymentSheetResultCallback, "paymentResultCallback");
        this.viewModelStoreOwner = viewModelStoreOwner2;
        this.lifecycleScope = coroutineScope;
        this.lifecycleOwner = lifecycleOwner2;
        this.appContext = context;
        this.activityResultCaller = activityResultCaller2;
        this.statusBarColor = function0;
        this.paymentOptionFactory = paymentOptionFactory2;
        this.paymentOptionCallback = paymentOptionCallback2;
        this.paymentResultCallback = paymentSheetResultCallback;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public FlowControllerFactory(final androidx.activity.ComponentActivity r12, com.stripe.android.paymentsheet.PaymentOptionCallback r13, com.stripe.android.paymentsheet.PaymentSheetResultCallback r14) {
        /*
            r11 = this;
            java.lang.String r0 = "activity"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "paymentOptionCallback"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "paymentResultCallback"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r2 = r12
            androidx.lifecycle.ViewModelStoreOwner r2 = (androidx.lifecycle.ViewModelStoreOwner) r2
            r4 = r12
            androidx.lifecycle.LifecycleOwner r4 = (androidx.lifecycle.LifecycleOwner) r4
            androidx.lifecycle.LifecycleCoroutineScope r0 = androidx.lifecycle.LifecycleOwnerKt.getLifecycleScope(r4)
            r3 = r0
            kotlinx.coroutines.CoroutineScope r3 = (kotlinx.coroutines.CoroutineScope) r3
            android.content.Context r5 = r12.getApplicationContext()
            java.lang.String r0 = "activity.applicationContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            r6 = r12
            androidx.activity.result.ActivityResultCaller r6 = (androidx.activity.result.ActivityResultCaller) r6
            com.stripe.android.paymentsheet.flowcontroller.FlowControllerFactory$1 r0 = new com.stripe.android.paymentsheet.flowcontroller.FlowControllerFactory$1
            r0.<init>(r12)
            r7 = r0
            kotlin.jvm.functions.Function0 r7 = (kotlin.jvm.functions.Function0) r7
            com.stripe.android.paymentsheet.model.PaymentOptionFactory r8 = new com.stripe.android.paymentsheet.model.PaymentOptionFactory
            android.content.res.Resources r12 = r12.getResources()
            java.lang.String r0 = "activity.resources"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r0)
            r8.<init>(r12)
            r1 = r11
            r9 = r13
            r10 = r14
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.paymentsheet.flowcontroller.FlowControllerFactory.<init>(androidx.activity.ComponentActivity, com.stripe.android.paymentsheet.PaymentOptionCallback, com.stripe.android.paymentsheet.PaymentSheetResultCallback):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public FlowControllerFactory(final androidx.fragment.app.Fragment r12, com.stripe.android.paymentsheet.PaymentOptionCallback r13, com.stripe.android.paymentsheet.PaymentSheetResultCallback r14) {
        /*
            r11 = this;
            java.lang.String r0 = "fragment"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "paymentOptionCallback"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "paymentResultCallback"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r2 = r12
            androidx.lifecycle.ViewModelStoreOwner r2 = (androidx.lifecycle.ViewModelStoreOwner) r2
            r4 = r12
            androidx.lifecycle.LifecycleOwner r4 = (androidx.lifecycle.LifecycleOwner) r4
            androidx.lifecycle.LifecycleCoroutineScope r0 = androidx.lifecycle.LifecycleOwnerKt.getLifecycleScope(r4)
            r3 = r0
            kotlinx.coroutines.CoroutineScope r3 = (kotlinx.coroutines.CoroutineScope) r3
            android.content.Context r5 = r12.requireContext()
            java.lang.String r0 = "fragment.requireContext()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            r6 = r12
            androidx.activity.result.ActivityResultCaller r6 = (androidx.activity.result.ActivityResultCaller) r6
            com.stripe.android.paymentsheet.flowcontroller.FlowControllerFactory$2 r0 = new com.stripe.android.paymentsheet.flowcontroller.FlowControllerFactory$2
            r0.<init>(r12)
            r7 = r0
            kotlin.jvm.functions.Function0 r7 = (kotlin.jvm.functions.Function0) r7
            com.stripe.android.paymentsheet.model.PaymentOptionFactory r8 = new com.stripe.android.paymentsheet.model.PaymentOptionFactory
            android.content.res.Resources r12 = r12.getResources()
            java.lang.String r0 = "fragment.resources"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r0)
            r8.<init>(r12)
            r1 = r11
            r9 = r13
            r10 = r14
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.paymentsheet.flowcontroller.FlowControllerFactory.<init>(androidx.fragment.app.Fragment, com.stripe.android.paymentsheet.PaymentOptionCallback, com.stripe.android.paymentsheet.PaymentSheetResultCallback):void");
    }

    public final PaymentSheet.FlowController create() {
        return DefaultFlowController.Companion.getInstance(this.appContext, this.viewModelStoreOwner, this.lifecycleScope, this.lifecycleOwner, this.activityResultCaller, this.statusBarColor, this.paymentOptionFactory, this.paymentOptionCallback, this.paymentResultCallback);
    }
}
