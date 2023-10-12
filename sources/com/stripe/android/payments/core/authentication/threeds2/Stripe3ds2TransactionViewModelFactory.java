package com.stripe.android.payments.core.authentication.threeds2;

import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.savedstate.SavedStateRegistryOwner;
import com.google.android.instantapps.InstantApps;
import com.stripe.android.core.injection.Injectable;
import com.stripe.android.core.injection.InjectableKtxKt;
import com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionContract;
import com.stripe.android.payments.core.injection.DaggerStripe3ds2TransactionViewModelFactoryComponent;
import com.stripe.android.payments.core.injection.NamedConstantsKt;
import com.stripe.android.payments.core.injection.Stripe3ds2TransactionViewModelSubcomponent;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u001fB)\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0002\u0010\u000bJ7\u0010\u0012\u001a\u0002H\u0013\"\n\b\u0000\u0010\u0013*\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00130\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0014¢\u0006\u0002\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0003H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006 "}, d2 = {"Lcom/stripe/android/payments/core/authentication/threeds2/Stripe3ds2TransactionViewModelFactory;", "Landroidx/lifecycle/AbstractSavedStateViewModelFactory;", "Lcom/stripe/android/core/injection/Injectable;", "Lcom/stripe/android/payments/core/authentication/threeds2/Stripe3ds2TransactionViewModelFactory$FallbackInitializeParam;", "applicationSupplier", "Lkotlin/Function0;", "Landroid/app/Application;", "owner", "Landroidx/savedstate/SavedStateRegistryOwner;", "argsSupplier", "Lcom/stripe/android/payments/core/authentication/threeds2/Stripe3ds2TransactionContract$Args;", "(Lkotlin/jvm/functions/Function0;Landroidx/savedstate/SavedStateRegistryOwner;Lkotlin/jvm/functions/Function0;)V", "subComponentBuilder", "Lcom/stripe/android/payments/core/injection/Stripe3ds2TransactionViewModelSubcomponent$Builder;", "getSubComponentBuilder", "()Lcom/stripe/android/payments/core/injection/Stripe3ds2TransactionViewModelSubcomponent$Builder;", "setSubComponentBuilder", "(Lcom/stripe/android/payments/core/injection/Stripe3ds2TransactionViewModelSubcomponent$Builder;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "key", "", "modelClass", "Ljava/lang/Class;", "handle", "Landroidx/lifecycle/SavedStateHandle;", "(Ljava/lang/String;Ljava/lang/Class;Landroidx/lifecycle/SavedStateHandle;)Landroidx/lifecycle/ViewModel;", "fallbackInitialize", "", "arg", "FallbackInitializeParam", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Stripe3ds2TransactionViewModel.kt */
public final class Stripe3ds2TransactionViewModelFactory extends AbstractSavedStateViewModelFactory implements Injectable<FallbackInitializeParam> {
    private final Function0<Application> applicationSupplier;
    private final Function0<Stripe3ds2TransactionContract.Args> argsSupplier;
    @Inject
    public Stripe3ds2TransactionViewModelSubcomponent.Builder subComponentBuilder;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Stripe3ds2TransactionViewModelFactory(Function0<? extends Application> function0, SavedStateRegistryOwner savedStateRegistryOwner, Function0<Stripe3ds2TransactionContract.Args> function02) {
        super(savedStateRegistryOwner, (Bundle) null);
        Intrinsics.checkNotNullParameter(function0, "applicationSupplier");
        Intrinsics.checkNotNullParameter(savedStateRegistryOwner, "owner");
        Intrinsics.checkNotNullParameter(function02, "argsSupplier");
        this.applicationSupplier = function0;
        this.argsSupplier = function02;
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\tHÆ\u0003J7\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/stripe/android/payments/core/authentication/threeds2/Stripe3ds2TransactionViewModelFactory$FallbackInitializeParam;", "", "application", "Landroid/app/Application;", "enableLogging", "", "publishableKey", "", "productUsage", "", "(Landroid/app/Application;ZLjava/lang/String;Ljava/util/Set;)V", "getApplication", "()Landroid/app/Application;", "getEnableLogging", "()Z", "getProductUsage", "()Ljava/util/Set;", "getPublishableKey", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Stripe3ds2TransactionViewModel.kt */
    public static final class FallbackInitializeParam {
        private final Application application;
        private final boolean enableLogging;
        private final Set<String> productUsage;
        private final String publishableKey;

        public static /* synthetic */ FallbackInitializeParam copy$default(FallbackInitializeParam fallbackInitializeParam, Application application2, boolean z, String str, Set<String> set, int i, Object obj) {
            if ((i & 1) != 0) {
                application2 = fallbackInitializeParam.application;
            }
            if ((i & 2) != 0) {
                z = fallbackInitializeParam.enableLogging;
            }
            if ((i & 4) != 0) {
                str = fallbackInitializeParam.publishableKey;
            }
            if ((i & 8) != 0) {
                set = fallbackInitializeParam.productUsage;
            }
            return fallbackInitializeParam.copy(application2, z, str, set);
        }

        public final Application component1() {
            return this.application;
        }

        public final boolean component2() {
            return this.enableLogging;
        }

        public final String component3() {
            return this.publishableKey;
        }

        public final Set<String> component4() {
            return this.productUsage;
        }

        public final FallbackInitializeParam copy(Application application2, boolean z, String str, Set<String> set) {
            Intrinsics.checkNotNullParameter(application2, "application");
            Intrinsics.checkNotNullParameter(str, "publishableKey");
            Intrinsics.checkNotNullParameter(set, NamedConstantsKt.PRODUCT_USAGE);
            return new FallbackInitializeParam(application2, z, str, set);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FallbackInitializeParam)) {
                return false;
            }
            FallbackInitializeParam fallbackInitializeParam = (FallbackInitializeParam) obj;
            return Intrinsics.areEqual((Object) this.application, (Object) fallbackInitializeParam.application) && this.enableLogging == fallbackInitializeParam.enableLogging && Intrinsics.areEqual((Object) this.publishableKey, (Object) fallbackInitializeParam.publishableKey) && Intrinsics.areEqual((Object) this.productUsage, (Object) fallbackInitializeParam.productUsage);
        }

        public int hashCode() {
            int hashCode = this.application.hashCode() * 31;
            boolean z = this.enableLogging;
            if (z) {
                z = true;
            }
            return ((((hashCode + (z ? 1 : 0)) * 31) + this.publishableKey.hashCode()) * 31) + this.productUsage.hashCode();
        }

        public String toString() {
            return "FallbackInitializeParam(application=" + this.application + ", enableLogging=" + this.enableLogging + ", publishableKey=" + this.publishableKey + ", productUsage=" + this.productUsage + ')';
        }

        public FallbackInitializeParam(Application application2, boolean z, String str, Set<String> set) {
            Intrinsics.checkNotNullParameter(application2, "application");
            Intrinsics.checkNotNullParameter(str, "publishableKey");
            Intrinsics.checkNotNullParameter(set, NamedConstantsKt.PRODUCT_USAGE);
            this.application = application2;
            this.enableLogging = z;
            this.publishableKey = str;
            this.productUsage = set;
        }

        public final Application getApplication() {
            return this.application;
        }

        public final boolean getEnableLogging() {
            return this.enableLogging;
        }

        public final String getPublishableKey() {
            return this.publishableKey;
        }

        public final Set<String> getProductUsage() {
            return this.productUsage;
        }
    }

    public final Stripe3ds2TransactionViewModelSubcomponent.Builder getSubComponentBuilder() {
        Stripe3ds2TransactionViewModelSubcomponent.Builder builder = this.subComponentBuilder;
        if (builder != null) {
            return builder;
        }
        Intrinsics.throwUninitializedPropertyAccessException("subComponentBuilder");
        return null;
    }

    public final void setSubComponentBuilder(Stripe3ds2TransactionViewModelSubcomponent.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<set-?>");
        this.subComponentBuilder = builder;
    }

    public void fallbackInitialize(FallbackInitializeParam fallbackInitializeParam) {
        Intrinsics.checkNotNullParameter(fallbackInitializeParam, "arg");
        DaggerStripe3ds2TransactionViewModelFactoryComponent.builder().context(fallbackInitializeParam.getApplication()).enableLogging(fallbackInitializeParam.getEnableLogging()).publishableKeyProvider(new Stripe3ds2TransactionViewModelFactory$fallbackInitialize$1(fallbackInitializeParam)).productUsage(fallbackInitializeParam.getProductUsage()).isInstantApp(InstantApps.isInstantApp(fallbackInitializeParam.getApplication())).build().inject(this);
    }

    /* access modifiers changed from: protected */
    public <T extends ViewModel> T create(String str, Class<T> cls, SavedStateHandle savedStateHandle) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        Intrinsics.checkNotNullParameter(savedStateHandle, "handle");
        Stripe3ds2TransactionContract.Args invoke = this.argsSupplier.invoke();
        Application invoke2 = this.applicationSupplier.invoke();
        InjectableKtxKt.injectWithFallback(this, invoke.getInjectorKey(), new FallbackInitializeParam(invoke2, invoke.getEnableLogging(), invoke.getPublishableKey(), invoke.getProductUsage()));
        return getSubComponentBuilder().args(invoke).savedStateHandle(savedStateHandle).application(invoke2).build().getViewModel();
    }
}
