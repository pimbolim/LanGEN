package com.stripe.android.link.ui.wallet;

import android.content.res.Resources;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.stripe.android.core.Logger;
import com.stripe.android.link.LinkActivityContract;
import com.stripe.android.link.LinkActivityResult;
import com.stripe.android.link.LinkScreen;
import com.stripe.android.link.R;
import com.stripe.android.link.account.LinkAccountManager;
import com.stripe.android.link.confirmation.ConfirmationManager;
import com.stripe.android.link.injection.NonFallbackInjectable;
import com.stripe.android.link.injection.NonFallbackInjector;
import com.stripe.android.link.injection.SignedInViewModelSubcomponent;
import com.stripe.android.link.model.ConfirmStripeIntentParamsFactory;
import com.stripe.android.link.model.LinkAccount;
import com.stripe.android.link.model.Navigator;
import com.stripe.android.link.repositories.LinkRepository;
import com.stripe.android.model.ConsumerPaymentDetails;
import com.stripe.android.model.PaymentIntent;
import com.stripe.android.model.SetupIntent;
import com.stripe.android.model.StripeIntent;
import com.stripe.android.ui.core.Amount;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001.B?\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0006\u0010\"\u001a\u00020#J\u000e\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u0014J\u0010\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020(H\u0002J\u0006\u0010)\u001a\u00020#J\u000e\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-R\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0015\u001a\u0010\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00170\u00170\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020!X\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/stripe/android/link/ui/wallet/WalletViewModel;", "Landroidx/lifecycle/ViewModel;", "args", "Lcom/stripe/android/link/LinkActivityContract$Args;", "linkAccount", "Lcom/stripe/android/link/model/LinkAccount;", "linkRepository", "Lcom/stripe/android/link/repositories/LinkRepository;", "linkAccountManager", "Lcom/stripe/android/link/account/LinkAccountManager;", "navigator", "Lcom/stripe/android/link/model/Navigator;", "confirmationManager", "Lcom/stripe/android/link/confirmation/ConfirmationManager;", "logger", "Lcom/stripe/android/core/Logger;", "(Lcom/stripe/android/link/LinkActivityContract$Args;Lcom/stripe/android/link/model/LinkAccount;Lcom/stripe/android/link/repositories/LinkRepository;Lcom/stripe/android/link/account/LinkAccountManager;Lcom/stripe/android/link/model/Navigator;Lcom/stripe/android/link/confirmation/ConfirmationManager;Lcom/stripe/android/core/Logger;)V", "_paymentDetails", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/stripe/android/model/ConsumerPaymentDetails$PaymentDetails;", "isProcessing", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "()Landroidx/lifecycle/MutableLiveData;", "getLinkAccount", "()Lcom/stripe/android/link/model/LinkAccount;", "paymentDetails", "Lkotlinx/coroutines/flow/StateFlow;", "getPaymentDetails", "()Lkotlinx/coroutines/flow/StateFlow;", "stripeIntent", "Lcom/stripe/android/model/StripeIntent;", "addNewPaymentMethod", "", "completePayment", "selectedPaymentDetails", "onError", "error", "", "payAnotherWay", "payButtonLabel", "", "resources", "Landroid/content/res/Resources;", "Factory", "link_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WalletViewModel.kt */
public final class WalletViewModel extends ViewModel {
    /* access modifiers changed from: private */
    public final MutableStateFlow<List<ConsumerPaymentDetails.PaymentDetails>> _paymentDetails;
    private final ConfirmationManager confirmationManager;
    private final MutableLiveData<Boolean> isProcessing = new MutableLiveData<>(false);
    private final LinkAccount linkAccount;
    private final LinkAccountManager linkAccountManager;
    /* access modifiers changed from: private */
    public final LinkRepository linkRepository;
    private final Logger logger;
    /* access modifiers changed from: private */
    public final Navigator navigator;
    private final StateFlow<List<ConsumerPaymentDetails.PaymentDetails>> paymentDetails;
    private final StripeIntent stripeIntent;

    public final LinkAccount getLinkAccount() {
        return this.linkAccount;
    }

    @Inject
    public WalletViewModel(LinkActivityContract.Args args, LinkAccount linkAccount2, LinkRepository linkRepository2, LinkAccountManager linkAccountManager2, Navigator navigator2, ConfirmationManager confirmationManager2, Logger logger2) {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(linkAccount2, "linkAccount");
        Intrinsics.checkNotNullParameter(linkRepository2, "linkRepository");
        Intrinsics.checkNotNullParameter(linkAccountManager2, "linkAccountManager");
        Intrinsics.checkNotNullParameter(navigator2, "navigator");
        Intrinsics.checkNotNullParameter(confirmationManager2, "confirmationManager");
        Intrinsics.checkNotNullParameter(logger2, "logger");
        this.linkAccount = linkAccount2;
        this.linkRepository = linkRepository2;
        this.linkAccountManager = linkAccountManager2;
        this.navigator = navigator2;
        this.confirmationManager = confirmationManager2;
        this.logger = logger2;
        this.stripeIntent = args.getStripeIntent$link_release();
        MutableStateFlow<List<ConsumerPaymentDetails.PaymentDetails>> MutableStateFlow = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this._paymentDetails = MutableStateFlow;
        this.paymentDetails = MutableStateFlow;
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this, (Continuation<? super AnonymousClass1>) null), 3, (Object) null);
    }

    public final StateFlow<List<ConsumerPaymentDetails.PaymentDetails>> getPaymentDetails() {
        return this.paymentDetails;
    }

    public final MutableLiveData<Boolean> isProcessing() {
        return this.isProcessing;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.stripe.android.link.ui.wallet.WalletViewModel$1", f = "WalletViewModel.kt", i = {}, l = {52}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stripe.android.link.ui.wallet.WalletViewModel$1  reason: invalid class name */
    /* compiled from: WalletViewModel.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ WalletViewModel this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object obj2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj2 = this.this$0.linkRepository.m4320listPaymentDetailsgIAlus(this.this$0.getLinkAccount().getClientSecret(), this);
                if (obj2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
                obj2 = ((Result) obj).m4718unboximpl();
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            WalletViewModel walletViewModel = this.this$0;
            Throwable r1 = Result.m4712exceptionOrNullimpl(obj2);
            if (r1 == null) {
                Collection arrayList = new ArrayList();
                for (Object next : ((ConsumerPaymentDetails) obj2).getPaymentDetails()) {
                    if (next instanceof ConsumerPaymentDetails.Card) {
                        arrayList.add(next);
                    }
                }
                List list = (List) arrayList;
                Unit unit = null;
                if (!(!list.isEmpty())) {
                    list = null;
                }
                if (list != null) {
                    walletViewModel._paymentDetails.setValue(list);
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    walletViewModel.addNewPaymentMethod();
                }
            } else {
                walletViewModel.onError(r1);
            }
            return Unit.INSTANCE;
        }
    }

    public final String payButtonLabel(Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        StripeIntent stripeIntent2 = this.stripeIntent;
        if (stripeIntent2 instanceof PaymentIntent) {
            Long amount = ((PaymentIntent) stripeIntent2).getAmount();
            if (amount != null) {
                long longValue = amount.longValue();
                String currency = ((PaymentIntent) this.stripeIntent).getCurrency();
                if (currency != null) {
                    return new Amount(longValue, currency).buildPayButtonLabel(resources);
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        } else if (stripeIntent2 instanceof SetupIntent) {
            String string = resources.getString(R.string.stripe_setup_button_label);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…tripe_setup_button_label)");
            return string;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final void completePayment(ConsumerPaymentDetails.PaymentDetails paymentDetails2) {
        Intrinsics.checkNotNullParameter(paymentDetails2, "selectedPaymentDetails");
        this.isProcessing.setValue(true);
        this.confirmationManager.confirmStripeIntent(ConfirmStripeIntentParamsFactory.Companion.createFactory(this.stripeIntent).create(this.linkAccount.getClientSecret(), paymentDetails2), new WalletViewModel$completePayment$1(this));
    }

    public final void payAnotherWay() {
        Navigator.dismiss$default(this.navigator, (LinkActivityResult) null, 1, (Object) null);
        this.linkAccountManager.logout();
    }

    public final void addNewPaymentMethod() {
        Navigator.navigateTo$default(this.navigator, LinkScreen.PaymentMethod.INSTANCE, false, 2, (Object) null);
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

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J%\u0010\u000f\u001a\u0002H\u0010\"\b\b\u0000\u0010\u0010*\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0013H\u0016¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R$\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/stripe/android/link/ui/wallet/WalletViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Lcom/stripe/android/link/injection/NonFallbackInjectable;", "linkAccount", "Lcom/stripe/android/link/model/LinkAccount;", "injector", "Lcom/stripe/android/link/injection/NonFallbackInjector;", "(Lcom/stripe/android/link/model/LinkAccount;Lcom/stripe/android/link/injection/NonFallbackInjector;)V", "subComponentBuilderProvider", "Ljavax/inject/Provider;", "Lcom/stripe/android/link/injection/SignedInViewModelSubcomponent$Builder;", "getSubComponentBuilderProvider", "()Ljavax/inject/Provider;", "setSubComponentBuilderProvider", "(Ljavax/inject/Provider;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "link_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: WalletViewModel.kt */
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
            return getSubComponentBuilderProvider().get().linkAccount(this.linkAccount).build().getWalletViewModel();
        }
    }
}
