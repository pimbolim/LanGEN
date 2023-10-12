package com.stripe.android.paymentsheet.injection;

import android.content.Context;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.stripe.android.core.injection.IOContext;
import com.stripe.android.paymentsheet.PaymentSheet;
import com.stripe.android.paymentsheet.PrefsRepository;
import com.stripe.android.paymentsheet.analytics.EventReporter;
import com.stripe.android.paymentsheet.flowcontroller.DefaultFlowControllerInitializer;
import com.stripe.android.paymentsheet.flowcontroller.FlowControllerInitializer;
import com.stripe.android.paymentsheet.flowcontroller.FlowControllerViewModel;
import com.stripe.android.paymentsheet.model.ClientSecret;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import java.util.Set;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b!\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H'¨\u0006\b"}, d2 = {"Lcom/stripe/android/paymentsheet/injection/FlowControllerModule;", "", "()V", "bindsFlowControllerInitializer", "Lcom/stripe/android/paymentsheet/flowcontroller/FlowControllerInitializer;", "defaultFlowControllerInitializer", "Lcom/stripe/android/paymentsheet/flowcontroller/DefaultFlowControllerInitializer;", "Companion", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module(subcomponents = {PaymentOptionsViewModelSubcomponent.class, FormViewModelSubcomponent.class})
/* compiled from: FlowControllerModule.kt */
public abstract class FlowControllerModule {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Binds
    public abstract FlowControllerInitializer bindsFlowControllerInitializer(DefaultFlowControllerInitializer defaultFlowControllerInitializer);

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\bH\u0007J(\u0010\t\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\u0010H\u0007J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0007J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0016H\u0007¨\u0006\u0017"}, d2 = {"Lcom/stripe/android/paymentsheet/injection/FlowControllerModule$Companion;", "", "()V", "provideClientSecret", "Lcom/stripe/android/paymentsheet/model/ClientSecret;", "viewModel", "Lcom/stripe/android/paymentsheet/flowcontroller/FlowControllerViewModel;", "provideEventReporterMode", "Lcom/stripe/android/paymentsheet/analytics/EventReporter$Mode;", "providePrefsRepositoryFactory", "Lkotlin/Function1;", "Lcom/stripe/android/paymentsheet/PaymentSheet$CustomerConfiguration;", "Lcom/stripe/android/paymentsheet/PrefsRepository;", "appContext", "Landroid/content/Context;", "workContext", "Lkotlin/coroutines/CoroutineContext;", "provideProductUsageTokens", "", "", "provideViewModel", "viewModelStoreOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FlowControllerModule.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Provides
        public final ClientSecret provideClientSecret(FlowControllerViewModel flowControllerViewModel) {
            Intrinsics.checkNotNullParameter(flowControllerViewModel, "viewModel");
            return flowControllerViewModel.getInitData().getClientSecret();
        }

        @Singleton
        @Provides
        public final Function1<PaymentSheet.CustomerConfiguration, PrefsRepository> providePrefsRepositoryFactory(Context context, @IOContext CoroutineContext coroutineContext) {
            Intrinsics.checkNotNullParameter(context, "appContext");
            Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
            return new FlowControllerModule$Companion$providePrefsRepositoryFactory$1(context, coroutineContext);
        }

        @Singleton
        @Provides
        public final EventReporter.Mode provideEventReporterMode() {
            return EventReporter.Mode.Custom;
        }

        @Named("productUsage")
        @Singleton
        @Provides
        public final Set<String> provideProductUsageTokens() {
            return SetsKt.setOf("PaymentSheet.FlowController");
        }

        @Singleton
        @Provides
        public final FlowControllerViewModel provideViewModel(ViewModelStoreOwner viewModelStoreOwner) {
            Intrinsics.checkNotNullParameter(viewModelStoreOwner, "viewModelStoreOwner");
            return (FlowControllerViewModel) new ViewModelProvider(viewModelStoreOwner).get(FlowControllerViewModel.class);
        }
    }
}
