package com.stripe.android.paymentsheet.injection;

import android.content.Context;
import androidx.activity.result.ActivityResultCaller;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import com.stripe.android.core.injection.CoroutineContextModule;
import com.stripe.android.core.injection.InjectorKey;
import com.stripe.android.core.injection.LoggingModule;
import com.stripe.android.googlepaylauncher.injection.GooglePayLauncherModule;
import com.stripe.android.payments.core.injection.StripeRepositoryModule;
import com.stripe.android.paymentsheet.PaymentOptionCallback;
import com.stripe.android.paymentsheet.PaymentOptionsViewModel;
import com.stripe.android.paymentsheet.PaymentSheetResultCallback;
import com.stripe.android.paymentsheet.flowcontroller.DefaultFlowController;
import com.stripe.android.paymentsheet.forms.FormViewModel;
import com.stripe.android.paymentsheet.model.PaymentOptionFactory;
import dagger.BindsInstance;
import dagger.Component;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScope;

@Component(modules = {StripeRepositoryModule.class, PaymentSheetCommonModule.class, FlowControllerModule.class, GooglePayLauncherModule.class, CoroutineContextModule.class, LoggingModule.class})
@Singleton
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\ba\u0018\u00002\u00020\u0001:\u0001\fJ\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\r"}, d2 = {"Lcom/stripe/android/paymentsheet/injection/FlowControllerComponent;", "", "flowController", "Lcom/stripe/android/paymentsheet/flowcontroller/DefaultFlowController;", "getFlowController", "()Lcom/stripe/android/paymentsheet/flowcontroller/DefaultFlowController;", "inject", "", "paymentOptionsViewModel", "Lcom/stripe/android/paymentsheet/PaymentOptionsViewModel$Factory;", "factory", "Lcom/stripe/android/paymentsheet/forms/FormViewModel$Factory;", "Builder", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowControllerComponent.kt */
public interface FlowControllerComponent {

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003H'J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005H'J\b\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\b\u001a\u00020\u00002\b\b\u0001\u0010\b\u001a\u00020\tH'J\u0010\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fH'J\u0010\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eH'J\u0010\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010H'J\u0010\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0012H'J\u0010\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0014H'J\u0018\u0010\u0015\u001a\u00020\u00002\u000e\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016H'J\u0010\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0019H'¨\u0006\u001a"}, d2 = {"Lcom/stripe/android/paymentsheet/injection/FlowControllerComponent$Builder;", "", "activityResultCaller", "Landroidx/activity/result/ActivityResultCaller;", "appContext", "Landroid/content/Context;", "build", "Lcom/stripe/android/paymentsheet/injection/FlowControllerComponent;", "injectorKey", "", "lifeCycleOwner", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleScope", "Lkotlinx/coroutines/CoroutineScope;", "paymentOptionCallback", "Lcom/stripe/android/paymentsheet/PaymentOptionCallback;", "paymentOptionFactory", "Lcom/stripe/android/paymentsheet/model/PaymentOptionFactory;", "paymentResultCallback", "Lcom/stripe/android/paymentsheet/PaymentSheetResultCallback;", "statusBarColor", "Lkotlin/Function0;", "", "viewModelStoreOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Component.Builder
    /* compiled from: FlowControllerComponent.kt */
    public interface Builder {
        @BindsInstance
        Builder activityResultCaller(ActivityResultCaller activityResultCaller);

        @BindsInstance
        Builder appContext(Context context);

        FlowControllerComponent build();

        @BindsInstance
        Builder injectorKey(@InjectorKey String str);

        @BindsInstance
        Builder lifeCycleOwner(LifecycleOwner lifecycleOwner);

        @BindsInstance
        Builder lifecycleScope(CoroutineScope coroutineScope);

        @BindsInstance
        Builder paymentOptionCallback(PaymentOptionCallback paymentOptionCallback);

        @BindsInstance
        Builder paymentOptionFactory(PaymentOptionFactory paymentOptionFactory);

        @BindsInstance
        Builder paymentResultCallback(PaymentSheetResultCallback paymentSheetResultCallback);

        @BindsInstance
        Builder statusBarColor(Function0<Integer> function0);

        @BindsInstance
        Builder viewModelStoreOwner(ViewModelStoreOwner viewModelStoreOwner);
    }

    DefaultFlowController getFlowController();

    void inject(PaymentOptionsViewModel.Factory factory);

    void inject(FormViewModel.Factory factory);
}
