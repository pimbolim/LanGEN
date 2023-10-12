package com.stripe.android.link;

import android.app.Application;
import androidx.activity.result.ActivityResultCaller;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.stripe.android.core.injection.Injectable;
import com.stripe.android.link.LinkActivityContract;
import com.stripe.android.link.LinkActivityResult;
import com.stripe.android.link.LinkScreen;
import com.stripe.android.link.account.CookieStore;
import com.stripe.android.link.account.LinkAccountManager;
import com.stripe.android.link.confirmation.ConfirmationManager;
import com.stripe.android.link.injection.DaggerLinkViewModelFactoryComponent;
import com.stripe.android.link.injection.LinkViewModelFactoryComponent;
import com.stripe.android.link.injection.NonFallbackInjector;
import com.stripe.android.link.model.LinkAccount;
import com.stripe.android.link.model.Navigator;
import com.stripe.android.model.PaymentIntent;
import com.stripe.android.model.StripeIntent;
import com.stripe.android.payments.core.injection.NamedConstantsKt;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001&B/\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\u000e\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020\u001fR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006'"}, d2 = {"Lcom/stripe/android/link/LinkActivityViewModel;", "Landroidx/lifecycle/ViewModel;", "args", "Lcom/stripe/android/link/LinkActivityContract$Args;", "linkAccountManager", "Lcom/stripe/android/link/account/LinkAccountManager;", "cookieStore", "Lcom/stripe/android/link/account/CookieStore;", "navigator", "Lcom/stripe/android/link/model/Navigator;", "confirmationManager", "Lcom/stripe/android/link/confirmation/ConfirmationManager;", "(Lcom/stripe/android/link/LinkActivityContract$Args;Lcom/stripe/android/link/account/LinkAccountManager;Lcom/stripe/android/link/account/CookieStore;Lcom/stripe/android/link/model/Navigator;Lcom/stripe/android/link/confirmation/ConfirmationManager;)V", "injector", "Lcom/stripe/android/link/injection/NonFallbackInjector;", "getInjector", "()Lcom/stripe/android/link/injection/NonFallbackInjector;", "setInjector", "(Lcom/stripe/android/link/injection/NonFallbackInjector;)V", "linkAccount", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/stripe/android/link/model/LinkAccount;", "getLinkAccount", "()Lkotlinx/coroutines/flow/StateFlow;", "getNavigator", "()Lcom/stripe/android/link/model/Navigator;", "startDestination", "", "getStartDestination", "()Ljava/lang/String;", "assertStripeIntentIsValid", "", "stripeIntent", "Lcom/stripe/android/model/StripeIntent;", "setupPaymentLauncher", "activityResultCaller", "Landroidx/activity/result/ActivityResultCaller;", "unregisterFromActivity", "Factory", "link_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LinkActivityViewModel.kt */
public final class LinkActivityViewModel extends ViewModel {
    private final ConfirmationManager confirmationManager;
    private final CookieStore cookieStore;
    public NonFallbackInjector injector;
    private final StateFlow<LinkAccount> linkAccount;
    /* access modifiers changed from: private */
    public final LinkAccountManager linkAccountManager;
    private final Navigator navigator;
    private final String startDestination;

    public final Navigator getNavigator() {
        return this.navigator;
    }

    @Inject
    public LinkActivityViewModel(LinkActivityContract.Args args, LinkAccountManager linkAccountManager2, CookieStore cookieStore2, Navigator navigator2, ConfirmationManager confirmationManager2) {
        String route;
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(linkAccountManager2, "linkAccountManager");
        Intrinsics.checkNotNullParameter(cookieStore2, "cookieStore");
        Intrinsics.checkNotNullParameter(navigator2, "navigator");
        Intrinsics.checkNotNullParameter(confirmationManager2, "confirmationManager");
        this.linkAccountManager = linkAccountManager2;
        this.cookieStore = cookieStore2;
        this.navigator = navigator2;
        this.confirmationManager = confirmationManager2;
        String customerEmail$link_release = args.getCustomerEmail$link_release();
        String str = LinkScreen.SignUp.route;
        if (customerEmail$link_release != null) {
            if (!((cookieStore2.isEmailLoggedOut(customerEmail$link_release) ? null : customerEmail$link_release) == null || (route = LinkScreen.Loading.INSTANCE.getRoute()) == null)) {
                str = route;
            }
        }
        this.startDestination = str;
        this.linkAccount = linkAccountManager2.getLinkAccount();
        assertStripeIntentIsValid(args.getStripeIntent$link_release());
        if (Intrinsics.areEqual((Object) str, (Object) LinkScreen.Loading.INSTANCE.getRoute())) {
            final String customerEmail$link_release2 = args.getCustomerEmail$link_release();
            if (customerEmail$link_release2 != null) {
                Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this, (Continuation<? super AnonymousClass1>) null), 3, (Object) null);
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    public final NonFallbackInjector getInjector() {
        NonFallbackInjector nonFallbackInjector = this.injector;
        if (nonFallbackInjector != null) {
            return nonFallbackInjector;
        }
        Intrinsics.throwUninitializedPropertyAccessException("injector");
        return null;
    }

    public final void setInjector(NonFallbackInjector nonFallbackInjector) {
        Intrinsics.checkNotNullParameter(nonFallbackInjector, "<set-?>");
        this.injector = nonFallbackInjector;
    }

    public final String getStartDestination() {
        return this.startDestination;
    }

    public final StateFlow<LinkAccount> getLinkAccount() {
        return this.linkAccount;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.stripe.android.link.LinkActivityViewModel$1", f = "LinkActivityViewModel.kt", i = {}, l = {60}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stripe.android.link.LinkActivityViewModel$1  reason: invalid class name */
    /* compiled from: LinkActivityViewModel.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ LinkActivityViewModel this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, customerEmail$link_release2, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object obj2;
            Navigator navigator;
            LinkScreen linkScreen;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Navigator navigator2 = this.this$0.getNavigator();
                this.L$0 = navigator2;
                this.label = 1;
                Object r1 = this.this$0.linkAccountManager.m4308lookupConsumergIAlus(customerEmail$link_release2, this);
                if (r1 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                navigator = navigator2;
                obj2 = r1;
            } else if (i == 1) {
                navigator = (Navigator) this.L$0;
                ResultKt.throwOnFailure(obj);
                obj2 = ((Result) obj).m4718unboximpl();
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            String str = customerEmail$link_release2;
            if (Result.m4712exceptionOrNullimpl(obj2) == null) {
                LinkAccount linkAccount = (LinkAccount) obj2;
                if (linkAccount == null) {
                    linkScreen = null;
                } else if (linkAccount.isVerified()) {
                    linkScreen = LinkScreen.Wallet.INSTANCE;
                } else {
                    linkScreen = LinkScreen.Verification.INSTANCE;
                }
                if (linkScreen == null) {
                    linkScreen = new LinkScreen.SignUp(str);
                }
            } else {
                linkScreen = new LinkScreen.SignUp(str);
            }
            navigator.navigateTo(linkScreen, true);
            return Unit.INSTANCE;
        }
    }

    public final void setupPaymentLauncher(ActivityResultCaller activityResultCaller) {
        Intrinsics.checkNotNullParameter(activityResultCaller, "activityResultCaller");
        this.confirmationManager.setupPaymentLauncher(activityResultCaller);
    }

    public final void unregisterFromActivity() {
        this.confirmationManager.invalidatePaymentLauncher();
    }

    private final void assertStripeIntentIsValid(StripeIntent stripeIntent) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            LinkActivityViewModel linkActivityViewModel = this;
            if (stripeIntent.getId() == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            } else if (stripeIntent.getClientSecret() != null) {
                String str = null;
                if ((stripeIntent instanceof PaymentIntent ? (PaymentIntent) stripeIntent : null) != null) {
                    if (((PaymentIntent) stripeIntent).getAmount() != null) {
                        str = ((PaymentIntent) stripeIntent).getCurrency();
                        if (str == null) {
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                    } else {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                }
                obj = Result.m4709constructorimpl(str);
                Throwable r4 = Result.m4712exceptionOrNullimpl(obj);
                if (r4 != null) {
                    getNavigator().dismiss(new LinkActivityResult.Failed(r4));
                }
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m4709constructorimpl(ResultKt.createFailure(th));
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u001bB\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ%\u0010\u0012\u001a\u0002H\u0013\"\b\b\u0000\u0010\u0013*\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0016H\u0016¢\u0006\u0002\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/stripe/android/link/LinkActivityViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Lcom/stripe/android/core/injection/Injectable;", "Lcom/stripe/android/link/LinkActivityViewModel$Factory$FallbackInitializeParam;", "application", "Landroid/app/Application;", "starterArgsSupplier", "Lkotlin/Function0;", "Lcom/stripe/android/link/LinkActivityContract$Args;", "(Landroid/app/Application;Lkotlin/jvm/functions/Function0;)V", "injector", "Lcom/stripe/android/link/injection/NonFallbackInjector;", "viewModel", "Lcom/stripe/android/link/LinkActivityViewModel;", "getViewModel", "()Lcom/stripe/android/link/LinkActivityViewModel;", "setViewModel", "(Lcom/stripe/android/link/LinkActivityViewModel;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "fallbackInitialize", "", "arg", "FallbackInitializeParam", "link_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LinkActivityViewModel.kt */
    public static final class Factory implements ViewModelProvider.Factory, Injectable<FallbackInitializeParam> {
        private final Application application;
        private NonFallbackInjector injector;
        private final Function0<LinkActivityContract.Args> starterArgsSupplier;
        @Inject
        public LinkActivityViewModel viewModel;

        public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
            return ViewModelProvider.Factory.CC.$default$create(this, cls, creationExtras);
        }

        public Factory(Application application2, Function0<LinkActivityContract.Args> function0) {
            Intrinsics.checkNotNullParameter(application2, "application");
            Intrinsics.checkNotNullParameter(function0, "starterArgsSupplier");
            this.application = application2;
            this.starterArgsSupplier = function0;
        }

        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\f¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\fHÆ\u0003JM\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\fHÆ\u0001J\u0013\u0010 \u001a\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015¨\u0006%"}, d2 = {"Lcom/stripe/android/link/LinkActivityViewModel$Factory$FallbackInitializeParam;", "", "application", "Landroid/app/Application;", "starterArgs", "Lcom/stripe/android/link/LinkActivityContract$Args;", "enableLogging", "", "publishableKey", "", "stripeAccountId", "productUsage", "", "(Landroid/app/Application;Lcom/stripe/android/link/LinkActivityContract$Args;ZLjava/lang/String;Ljava/lang/String;Ljava/util/Set;)V", "getApplication", "()Landroid/app/Application;", "getEnableLogging", "()Z", "getProductUsage", "()Ljava/util/Set;", "getPublishableKey", "()Ljava/lang/String;", "getStarterArgs", "()Lcom/stripe/android/link/LinkActivityContract$Args;", "getStripeAccountId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "link_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: LinkActivityViewModel.kt */
        public static final class FallbackInitializeParam {
            private final Application application;
            private final boolean enableLogging;
            private final Set<String> productUsage;
            private final String publishableKey;
            private final LinkActivityContract.Args starterArgs;
            private final String stripeAccountId;

            public static /* synthetic */ FallbackInitializeParam copy$default(FallbackInitializeParam fallbackInitializeParam, Application application2, LinkActivityContract.Args args, boolean z, String str, String str2, Set<String> set, int i, Object obj) {
                if ((i & 1) != 0) {
                    application2 = fallbackInitializeParam.application;
                }
                if ((i & 2) != 0) {
                    args = fallbackInitializeParam.starterArgs;
                }
                LinkActivityContract.Args args2 = args;
                if ((i & 4) != 0) {
                    z = fallbackInitializeParam.enableLogging;
                }
                boolean z2 = z;
                if ((i & 8) != 0) {
                    str = fallbackInitializeParam.publishableKey;
                }
                String str3 = str;
                if ((i & 16) != 0) {
                    str2 = fallbackInitializeParam.stripeAccountId;
                }
                String str4 = str2;
                if ((i & 32) != 0) {
                    set = fallbackInitializeParam.productUsage;
                }
                return fallbackInitializeParam.copy(application2, args2, z2, str3, str4, set);
            }

            public final Application component1() {
                return this.application;
            }

            public final LinkActivityContract.Args component2() {
                return this.starterArgs;
            }

            public final boolean component3() {
                return this.enableLogging;
            }

            public final String component4() {
                return this.publishableKey;
            }

            public final String component5() {
                return this.stripeAccountId;
            }

            public final Set<String> component6() {
                return this.productUsage;
            }

            public final FallbackInitializeParam copy(Application application2, LinkActivityContract.Args args, boolean z, String str, String str2, Set<String> set) {
                Intrinsics.checkNotNullParameter(application2, "application");
                Intrinsics.checkNotNullParameter(args, "starterArgs");
                Intrinsics.checkNotNullParameter(str, "publishableKey");
                Intrinsics.checkNotNullParameter(set, NamedConstantsKt.PRODUCT_USAGE);
                return new FallbackInitializeParam(application2, args, z, str, str2, set);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof FallbackInitializeParam)) {
                    return false;
                }
                FallbackInitializeParam fallbackInitializeParam = (FallbackInitializeParam) obj;
                return Intrinsics.areEqual((Object) this.application, (Object) fallbackInitializeParam.application) && Intrinsics.areEqual((Object) this.starterArgs, (Object) fallbackInitializeParam.starterArgs) && this.enableLogging == fallbackInitializeParam.enableLogging && Intrinsics.areEqual((Object) this.publishableKey, (Object) fallbackInitializeParam.publishableKey) && Intrinsics.areEqual((Object) this.stripeAccountId, (Object) fallbackInitializeParam.stripeAccountId) && Intrinsics.areEqual((Object) this.productUsage, (Object) fallbackInitializeParam.productUsage);
            }

            public int hashCode() {
                int hashCode = ((this.application.hashCode() * 31) + this.starterArgs.hashCode()) * 31;
                boolean z = this.enableLogging;
                if (z) {
                    z = true;
                }
                int hashCode2 = (((hashCode + (z ? 1 : 0)) * 31) + this.publishableKey.hashCode()) * 31;
                String str = this.stripeAccountId;
                return ((hashCode2 + (str == null ? 0 : str.hashCode())) * 31) + this.productUsage.hashCode();
            }

            public String toString() {
                return "FallbackInitializeParam(application=" + this.application + ", starterArgs=" + this.starterArgs + ", enableLogging=" + this.enableLogging + ", publishableKey=" + this.publishableKey + ", stripeAccountId=" + this.stripeAccountId + ", productUsage=" + this.productUsage + ')';
            }

            public FallbackInitializeParam(Application application2, LinkActivityContract.Args args, boolean z, String str, String str2, Set<String> set) {
                Intrinsics.checkNotNullParameter(application2, "application");
                Intrinsics.checkNotNullParameter(args, "starterArgs");
                Intrinsics.checkNotNullParameter(str, "publishableKey");
                Intrinsics.checkNotNullParameter(set, NamedConstantsKt.PRODUCT_USAGE);
                this.application = application2;
                this.starterArgs = args;
                this.enableLogging = z;
                this.publishableKey = str;
                this.stripeAccountId = str2;
                this.productUsage = set;
            }

            public final Application getApplication() {
                return this.application;
            }

            public final LinkActivityContract.Args getStarterArgs() {
                return this.starterArgs;
            }

            public final boolean getEnableLogging() {
                return this.enableLogging;
            }

            public final String getPublishableKey() {
                return this.publishableKey;
            }

            public final String getStripeAccountId() {
                return this.stripeAccountId;
            }

            public final Set<String> getProductUsage() {
                return this.productUsage;
            }
        }

        public final LinkActivityViewModel getViewModel() {
            LinkActivityViewModel linkActivityViewModel = this.viewModel;
            if (linkActivityViewModel != null) {
                return linkActivityViewModel;
            }
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            return null;
        }

        public final void setViewModel(LinkActivityViewModel linkActivityViewModel) {
            Intrinsics.checkNotNullParameter(linkActivityViewModel, "<set-?>");
            this.viewModel = linkActivityViewModel;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0056  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x00d8  */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x00de  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public <T extends androidx.lifecycle.ViewModel> T create(java.lang.Class<T> r11) {
            /*
                r10 = this;
                java.lang.String r0 = "modelClass"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
                com.stripe.android.core.Logger$Companion r11 = com.stripe.android.core.Logger.Companion
                r0 = 0
                com.stripe.android.core.Logger r11 = r11.getInstance(r0)
                kotlin.jvm.functions.Function0<com.stripe.android.link.LinkActivityContract$Args> r1 = r10.starterArgsSupplier
                java.lang.Object r1 = r1.invoke()
                r4 = r1
                com.stripe.android.link.LinkActivityContract$Args r4 = (com.stripe.android.link.LinkActivityContract.Args) r4
                com.stripe.android.link.LinkActivityContract$Args$InjectionParams r1 = r4.getInjectionParams$link_release()
                r9 = 0
                if (r1 != 0) goto L_0x001e
            L_0x001c:
                r1 = r9
                goto L_0x0054
            L_0x001e:
                java.lang.String r1 = r1.getInjectorKey()
                if (r1 != 0) goto L_0x0025
                goto L_0x001c
            L_0x0025:
                com.stripe.android.core.injection.WeakMapInjectorRegistry r2 = com.stripe.android.core.injection.WeakMapInjectorRegistry.INSTANCE
                com.stripe.android.core.injection.Injector r1 = r2.retrieve(r1)
                if (r1 != 0) goto L_0x002e
                goto L_0x001c
            L_0x002e:
                boolean r2 = r1 instanceof com.stripe.android.link.injection.NonFallbackInjector
                if (r2 == 0) goto L_0x0035
                com.stripe.android.link.injection.NonFallbackInjector r1 = (com.stripe.android.link.injection.NonFallbackInjector) r1
                goto L_0x0036
            L_0x0035:
                r1 = r9
            L_0x0036:
                if (r1 != 0) goto L_0x0039
                goto L_0x001c
            L_0x0039:
                java.lang.Class r2 = r10.getClass()
                java.lang.String r2 = r2.getCanonicalName()
                java.lang.String r3 = "Injector available, injecting dependencies into "
                java.lang.String r2 = kotlin.jvm.internal.Intrinsics.stringPlus(r3, r2)
                r11.info(r2)
                r10.injector = r1
                r2 = r10
                com.stripe.android.core.injection.Injectable r2 = (com.stripe.android.core.injection.Injectable) r2
                r1.inject(r2)
                kotlin.Unit r1 = kotlin.Unit.INSTANCE
            L_0x0054:
                if (r1 != 0) goto L_0x00d0
                r1 = r10
                com.stripe.android.link.LinkActivityViewModel$Factory r1 = (com.stripe.android.link.LinkActivityViewModel.Factory) r1
                java.lang.Class r2 = r1.getClass()
                java.lang.String r2 = r2.getCanonicalName()
                java.lang.String r3 = "Injector unavailable, initializing dependencies of "
                java.lang.String r2 = kotlin.jvm.internal.Intrinsics.stringPlus(r3, r2)
                r11.info(r2)
                com.stripe.android.link.LinkActivityViewModel$Factory$FallbackInitializeParam r11 = new com.stripe.android.link.LinkActivityViewModel$Factory$FallbackInitializeParam
                android.app.Application r3 = r1.application
                com.stripe.android.link.LinkActivityContract$Args$InjectionParams r2 = r4.getInjectionParams$link_release()
                if (r2 != 0) goto L_0x0076
                r5 = 0
                goto L_0x007b
            L_0x0076:
                boolean r0 = r2.getEnableLogging()
                r5 = r0
            L_0x007b:
                com.stripe.android.link.LinkActivityContract$Args$InjectionParams r0 = r4.getInjectionParams$link_release()
                if (r0 != 0) goto L_0x0083
                r0 = r9
                goto L_0x0087
            L_0x0083:
                java.lang.String r0 = r0.getPublishableKey()
            L_0x0087:
                if (r0 != 0) goto L_0x0097
                com.stripe.android.PaymentConfiguration$Companion r0 = com.stripe.android.PaymentConfiguration.Companion
                android.app.Application r2 = r1.application
                android.content.Context r2 = (android.content.Context) r2
                com.stripe.android.PaymentConfiguration r0 = r0.getInstance(r2)
                java.lang.String r0 = r0.getPublishableKey()
            L_0x0097:
                r6 = r0
                com.stripe.android.link.LinkActivityContract$Args$InjectionParams r0 = r4.getInjectionParams$link_release()
                if (r0 == 0) goto L_0x00a7
                com.stripe.android.link.LinkActivityContract$Args$InjectionParams r0 = r4.getInjectionParams$link_release()
                java.lang.String r0 = r0.getStripeAccountId()
                goto L_0x00b5
            L_0x00a7:
                com.stripe.android.PaymentConfiguration$Companion r0 = com.stripe.android.PaymentConfiguration.Companion
                android.app.Application r2 = r1.application
                android.content.Context r2 = (android.content.Context) r2
                com.stripe.android.PaymentConfiguration r0 = r0.getInstance(r2)
                java.lang.String r0 = r0.getStripeAccountId()
            L_0x00b5:
                r7 = r0
                com.stripe.android.link.LinkActivityContract$Args$InjectionParams r0 = r4.getInjectionParams$link_release()
                if (r0 != 0) goto L_0x00be
                r0 = r9
                goto L_0x00c2
            L_0x00be:
                java.util.Set r0 = r0.getProductUsage()
            L_0x00c2:
                if (r0 != 0) goto L_0x00c8
                java.util.Set r0 = kotlin.collections.SetsKt.emptySet()
            L_0x00c8:
                r8 = r0
                r2 = r11
                r2.<init>(r3, r4, r5, r6, r7, r8)
                r1.fallbackInitialize((com.stripe.android.link.LinkActivityViewModel.Factory.FallbackInitializeParam) r11)
            L_0x00d0:
                com.stripe.android.link.LinkActivityViewModel r11 = r10.getViewModel()
                com.stripe.android.link.injection.NonFallbackInjector r0 = r10.injector
                if (r0 != 0) goto L_0x00de
                java.lang.String r0 = "injector"
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
                goto L_0x00df
            L_0x00de:
                r9 = r0
            L_0x00df:
                r11.setInjector(r9)
                com.stripe.android.link.LinkActivityViewModel r11 = r10.getViewModel()
                androidx.lifecycle.ViewModel r11 = (androidx.lifecycle.ViewModel) r11
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.link.LinkActivityViewModel.Factory.create(java.lang.Class):androidx.lifecycle.ViewModel");
        }

        public void fallbackInitialize(FallbackInitializeParam fallbackInitializeParam) {
            Intrinsics.checkNotNullParameter(fallbackInitializeParam, "arg");
            LinkViewModelFactoryComponent build = DaggerLinkViewModelFactoryComponent.builder().context(fallbackInitializeParam.getApplication()).enableLogging(fallbackInitializeParam.getEnableLogging()).publishableKeyProvider(new LinkActivityViewModel$Factory$fallbackInitialize$viewModelComponent$1(fallbackInitializeParam)).stripeAccountIdProvider(new LinkActivityViewModel$Factory$fallbackInitialize$viewModelComponent$2(fallbackInitializeParam)).productUsage(fallbackInitializeParam.getProductUsage()).starterArgs(fallbackInitializeParam.getStarterArgs()).build();
            this.injector = new LinkActivityViewModel$Factory$fallbackInitialize$1(build);
            build.inject(this);
        }
    }
}
