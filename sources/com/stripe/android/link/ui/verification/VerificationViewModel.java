package com.stripe.android.link.ui.verification;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.stripe.android.core.Logger;
import com.stripe.android.link.LinkScreen;
import com.stripe.android.link.account.LinkAccountManager;
import com.stripe.android.link.injection.NonFallbackInjectable;
import com.stripe.android.link.injection.NonFallbackInjector;
import com.stripe.android.link.injection.SignedInViewModelSubcomponent;
import com.stripe.android.link.model.LinkAccount;
import com.stripe.android.link.model.Navigator;
import com.stripe.android.model.PaymentMethodOptionsParams;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0017B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0006\u0010\u0013\u001a\u00020\u000eJ\u000e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/stripe/android/link/ui/verification/VerificationViewModel;", "Landroidx/lifecycle/ViewModel;", "linkAccountManager", "Lcom/stripe/android/link/account/LinkAccountManager;", "navigator", "Lcom/stripe/android/link/model/Navigator;", "logger", "Lcom/stripe/android/core/Logger;", "linkAccount", "Lcom/stripe/android/link/model/LinkAccount;", "(Lcom/stripe/android/link/account/LinkAccountManager;Lcom/stripe/android/link/model/Navigator;Lcom/stripe/android/core/Logger;Lcom/stripe/android/link/model/LinkAccount;)V", "getLinkAccount", "()Lcom/stripe/android/link/model/LinkAccount;", "onBack", "", "onChangeEmailClicked", "onError", "error", "", "onResendCodeClicked", "onVerificationCodeEntered", "code", "", "Factory", "link_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VerificationViewModel.kt */
public final class VerificationViewModel extends ViewModel {
    private final LinkAccount linkAccount;
    /* access modifiers changed from: private */
    public final LinkAccountManager linkAccountManager;
    /* access modifiers changed from: private */
    public final Logger logger;
    /* access modifiers changed from: private */
    public final Navigator navigator;

    public final LinkAccount getLinkAccount() {
        return this.linkAccount;
    }

    @Inject
    public VerificationViewModel(LinkAccountManager linkAccountManager2, Navigator navigator2, Logger logger2, LinkAccount linkAccount2) {
        Intrinsics.checkNotNullParameter(linkAccountManager2, "linkAccountManager");
        Intrinsics.checkNotNullParameter(navigator2, "navigator");
        Intrinsics.checkNotNullParameter(logger2, "logger");
        Intrinsics.checkNotNullParameter(linkAccount2, "linkAccount");
        this.linkAccountManager = linkAccountManager2;
        this.navigator = navigator2;
        this.logger = logger2;
        this.linkAccount = linkAccount2;
    }

    public final void onVerificationCodeEntered(String str) {
        Intrinsics.checkNotNullParameter(str, PaymentMethodOptionsParams.Blik.PARAM_CODE);
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new VerificationViewModel$onVerificationCodeEntered$1(this, str, (Continuation<? super VerificationViewModel$onVerificationCodeEntered$1>) null), 3, (Object) null);
    }

    public final void onResendCodeClicked() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new VerificationViewModel$onResendCodeClicked$1(this, (Continuation<? super VerificationViewModel$onResendCodeClicked$1>) null), 3, (Object) null);
    }

    public final void onBack() {
        this.navigator.onBack();
        this.linkAccountManager.logout();
    }

    public final void onChangeEmailClicked() {
        this.navigator.navigateTo(new LinkScreen.SignUp((String) null, 1, (DefaultConstructorMarker) null), true);
        this.linkAccountManager.logout();
    }

    /* access modifiers changed from: private */
    public final void onError(Throwable th) {
        Logger logger2 = this.logger;
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            localizedMessage = "Internal error.";
        }
        Logger.DefaultImpls.error$default(logger2, localizedMessage, (Throwable) null, 2, (Object) null);
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J%\u0010\u000f\u001a\u0002H\u0010\"\b\b\u0000\u0010\u0010*\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0013H\u0016¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R$\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/stripe/android/link/ui/verification/VerificationViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Lcom/stripe/android/link/injection/NonFallbackInjectable;", "linkAccount", "Lcom/stripe/android/link/model/LinkAccount;", "injector", "Lcom/stripe/android/link/injection/NonFallbackInjector;", "(Lcom/stripe/android/link/model/LinkAccount;Lcom/stripe/android/link/injection/NonFallbackInjector;)V", "subComponentBuilderProvider", "Ljavax/inject/Provider;", "Lcom/stripe/android/link/injection/SignedInViewModelSubcomponent$Builder;", "getSubComponentBuilderProvider", "()Ljavax/inject/Provider;", "setSubComponentBuilderProvider", "(Ljavax/inject/Provider;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "link_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: VerificationViewModel.kt */
    public static final class Factory implements ViewModelProvider.Factory, NonFallbackInjectable {
        private final NonFallbackInjector injector;
        private final LinkAccount linkAccount;
        @Inject
        public Provider<SignedInViewModelSubcomponent.Builder> subComponentBuilderProvider;

        public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
            return ViewModelProvider.Factory.CC.$default$create(this, cls, creationExtras);
        }

        public Factory(LinkAccount linkAccount2, NonFallbackInjector nonFallbackInjector) {
            Intrinsics.checkNotNullParameter(linkAccount2, "linkAccount");
            Intrinsics.checkNotNullParameter(nonFallbackInjector, "injector");
            this.linkAccount = linkAccount2;
            this.injector = nonFallbackInjector;
        }

        public Void fallbackInitialize(Unit unit) {
            return NonFallbackInjectable.DefaultImpls.fallbackInitialize(this, unit);
        }

        public final Provider<SignedInViewModelSubcomponent.Builder> getSubComponentBuilderProvider() {
            Provider<SignedInViewModelSubcomponent.Builder> provider = this.subComponentBuilderProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("subComponentBuilderProvider");
            return null;
        }

        public final void setSubComponentBuilderProvider(Provider<SignedInViewModelSubcomponent.Builder> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.subComponentBuilderProvider = provider;
        }

        public <T extends ViewModel> T create(Class<T> cls) {
            Intrinsics.checkNotNullParameter(cls, "modelClass");
            this.injector.inject(this);
            return getSubComponentBuilderProvider().get().linkAccount(this.linkAccount).build().getVerificationViewModel();
        }
    }
}
