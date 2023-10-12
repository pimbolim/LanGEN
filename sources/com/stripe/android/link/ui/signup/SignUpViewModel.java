package com.stripe.android.link.ui.signup;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.stripe.android.core.Logger;
import com.stripe.android.link.LinkActivityContract;
import com.stripe.android.link.LinkScreen;
import com.stripe.android.link.account.LinkAccountManager;
import com.stripe.android.link.injection.NonFallbackInjectable;
import com.stripe.android.link.injection.NonFallbackInjector;
import com.stripe.android.link.injection.SignUpViewModelSubcomponent;
import com.stripe.android.link.model.LinkAccount;
import com.stripe.android.link.model.Navigator;
import com.stripe.android.ui.core.elements.EmailSpec;
import com.stripe.android.ui.core.elements.SectionFieldElement;
import java.util.concurrent.CancellationException;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\b\u0000\u0018\u0000 *2\u00020\u0001:\u0002*+B3\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010!J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020'H\u0002J\u000e\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020\u0005R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0011X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0018\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d\u0002\u0004\n\u0002\b\u0019¨\u0006,"}, d2 = {"Lcom/stripe/android/link/ui/signup/SignUpViewModel;", "Landroidx/lifecycle/ViewModel;", "args", "Lcom/stripe/android/link/LinkActivityContract$Args;", "prefilledEmail", "", "linkAccountManager", "Lcom/stripe/android/link/account/LinkAccountManager;", "navigator", "Lcom/stripe/android/link/model/Navigator;", "logger", "Lcom/stripe/android/core/Logger;", "(Lcom/stripe/android/link/LinkActivityContract$Args;Ljava/lang/String;Lcom/stripe/android/link/account/LinkAccountManager;Lcom/stripe/android/link/model/Navigator;Lcom/stripe/android/core/Logger;)V", "_signUpStatus", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/stripe/android/link/ui/signup/SignUpState;", "consumerEmail", "Lkotlinx/coroutines/flow/StateFlow;", "emailElement", "Lcom/stripe/android/ui/core/elements/SectionFieldElement;", "getEmailElement", "()Lcom/stripe/android/ui/core/elements/SectionFieldElement;", "lookupJob", "Lkotlinx/coroutines/Job;", "merchantName", "getMerchantName", "()Ljava/lang/String;", "signUpState", "getSignUpState", "()Lkotlinx/coroutines/flow/StateFlow;", "lookupConsumerEmail", "", "email", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onAccountFetched", "linkAccount", "Lcom/stripe/android/link/model/LinkAccount;", "onError", "error", "", "onSignUpClick", "phone", "Companion", "Factory", "link_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SignUpViewModel.kt */
public final class SignUpViewModel extends ViewModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long LOOKUP_DEBOUNCE_MS = 700;
    public static final String PREFILLED_EMAIL = "prefilled_email";
    /* access modifiers changed from: private */
    public final MutableStateFlow<SignUpState> _signUpStatus;
    /* access modifiers changed from: private */
    public final StateFlow<String> consumerEmail;
    private final SectionFieldElement emailElement;
    /* access modifiers changed from: private */
    public final LinkAccountManager linkAccountManager;
    private final Logger logger;
    /* access modifiers changed from: private */
    public Job lookupJob;
    private final String merchantName;
    private final Navigator navigator;
    /* access modifiers changed from: private */
    public final String prefilledEmail;
    private final StateFlow<SignUpState> signUpState;

    @Inject
    public SignUpViewModel(LinkActivityContract.Args args, @Named("prefilled_email") String str, LinkAccountManager linkAccountManager2, Navigator navigator2, Logger logger2) {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(linkAccountManager2, "linkAccountManager");
        Intrinsics.checkNotNullParameter(navigator2, "navigator");
        Intrinsics.checkNotNullParameter(logger2, "logger");
        this.prefilledEmail = str;
        this.linkAccountManager = linkAccountManager2;
        this.navigator = navigator2;
        this.logger = logger2;
        this.merchantName = args.getMerchantName$link_release();
        SectionFieldElement transform = EmailSpec.INSTANCE.transform(str);
        this.emailElement = transform;
        ViewModel viewModel = this;
        this.consumerEmail = FlowKt.stateIn(new SignUpViewModel$special$$inlined$map$1(transform.getFormFieldValueFlow()), ViewModelKt.getViewModelScope(viewModel), SharingStarted.Companion.getLazily(), str);
        MutableStateFlow<SignUpState> MutableStateFlow = StateFlowKt.MutableStateFlow(SignUpState.InputtingEmail);
        this._signUpStatus = MutableStateFlow;
        this.signUpState = MutableStateFlow;
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(viewModel), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this, (Continuation<? super AnonymousClass1>) null), 3, (Object) null);
    }

    public final String getMerchantName() {
        return this.merchantName;
    }

    public final SectionFieldElement getEmailElement() {
        return this.emailElement;
    }

    public final StateFlow<SignUpState> getSignUpState() {
        return this.signUpState;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.stripe.android.link.ui.signup.SignUpViewModel$1", f = "SignUpViewModel.kt", i = {}, l = {65}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stripe.android.link.ui.signup.SignUpViewModel$1  reason: invalid class name */
    /* compiled from: SignUpViewModel.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ SignUpViewModel this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                StateFlow access$getConsumerEmail$p = this.this$0.consumerEmail;
                final SignUpViewModel signUpViewModel = this.this$0;
                this.label = 1;
                if (access$getConsumerEmail$p.collect(new FlowCollector<String>() {
                    public final Object emit(String str, Continuation<? super Unit> continuation) {
                        if (!Intrinsics.areEqual((Object) str, (Object) signUpViewModel.prefilledEmail) || signUpViewModel.lookupJob != null) {
                            Job access$getLookupJob$p = signUpViewModel.lookupJob;
                            if (access$getLookupJob$p != null) {
                                Job.DefaultImpls.cancel$default(access$getLookupJob$p, (CancellationException) null, 1, (Object) null);
                            }
                            if (str != null) {
                                SignUpViewModel signUpViewModel = signUpViewModel;
                                signUpViewModel.lookupJob = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new SignUpViewModel$1$1$emit$2(signUpViewModel, str, (Continuation<? super SignUpViewModel$1$1$emit$2>) null), 3, (Object) null);
                            } else {
                                signUpViewModel._signUpStatus.setValue(SignUpState.InputtingEmail);
                            }
                            return Unit.INSTANCE;
                        }
                        if (str != null) {
                            signUpViewModel._signUpStatus.setValue(SignUpState.InputtingPhone);
                        }
                        return Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    public final void onSignUpClick(String str) {
        Intrinsics.checkNotNullParameter(str, "phone");
        String value = this.consumerEmail.getValue();
        if (value != null) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new SignUpViewModel$onSignUpClick$1(this, value, str, (Continuation<? super SignUpViewModel$onSignUpClick$1>) null), 3, (Object) null);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object lookupConsumerEmail(java.lang.String r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stripe.android.link.ui.signup.SignUpViewModel$lookupConsumerEmail$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.stripe.android.link.ui.signup.SignUpViewModel$lookupConsumerEmail$1 r0 = (com.stripe.android.link.ui.signup.SignUpViewModel$lookupConsumerEmail$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.stripe.android.link.ui.signup.SignUpViewModel$lookupConsumerEmail$1 r0 = new com.stripe.android.link.ui.signup.SignUpViewModel$lookupConsumerEmail$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            java.lang.Object r5 = r0.L$0
            com.stripe.android.link.ui.signup.SignUpViewModel r5 = (com.stripe.android.link.ui.signup.SignUpViewModel) r5
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            java.lang.Object r6 = r6.m4718unboximpl()
            goto L_0x004d
        L_0x0034:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r6)
            com.stripe.android.link.account.LinkAccountManager r6 = r4.linkAccountManager
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r6 = r6.m4308lookupConsumergIAlus(r5, r0)
            if (r6 != r1) goto L_0x004c
            return r1
        L_0x004c:
            r5 = r4
        L_0x004d:
            java.lang.Throwable r0 = kotlin.Result.m4712exceptionOrNullimpl(r6)
            if (r0 != 0) goto L_0x0063
            com.stripe.android.link.model.LinkAccount r6 = (com.stripe.android.link.model.LinkAccount) r6
            if (r6 == 0) goto L_0x005b
            r5.onAccountFetched(r6)
            goto L_0x0066
        L_0x005b:
            kotlinx.coroutines.flow.MutableStateFlow<com.stripe.android.link.ui.signup.SignUpState> r5 = r5._signUpStatus
            com.stripe.android.link.ui.signup.SignUpState r6 = com.stripe.android.link.ui.signup.SignUpState.InputtingPhone
            r5.setValue(r6)
            goto L_0x0066
        L_0x0063:
            r5.onError(r0)
        L_0x0066:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.link.ui.signup.SignUpViewModel.lookupConsumerEmail(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final void onAccountFetched(LinkAccount linkAccount) {
        if (linkAccount.isVerified()) {
            this.navigator.navigateTo(LinkScreen.Wallet.INSTANCE, true);
            return;
        }
        Navigator.navigateTo$default(this.navigator, LinkScreen.Verification.INSTANCE, false, 2, (Object) null);
        this.emailElement.setRawValue(MapsKt.mapOf(TuplesKt.to(EmailSpec.INSTANCE.getIdentifier(), "")));
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

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J%\u0010\u000f\u001a\u0002H\u0010\"\b\b\u0000\u0010\u0010*\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0013H\u0016¢\u0006\u0002\u0010\u0014R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R$\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/stripe/android/link/ui/signup/SignUpViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Lcom/stripe/android/link/injection/NonFallbackInjectable;", "injector", "Lcom/stripe/android/link/injection/NonFallbackInjector;", "email", "", "(Lcom/stripe/android/link/injection/NonFallbackInjector;Ljava/lang/String;)V", "subComponentBuilderProvider", "Ljavax/inject/Provider;", "Lcom/stripe/android/link/injection/SignUpViewModelSubcomponent$Builder;", "getSubComponentBuilderProvider", "()Ljavax/inject/Provider;", "setSubComponentBuilderProvider", "(Ljavax/inject/Provider;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "link_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SignUpViewModel.kt */
    public static final class Factory implements ViewModelProvider.Factory, NonFallbackInjectable {
        private final String email;
        private final NonFallbackInjector injector;
        @Inject
        public Provider<SignUpViewModelSubcomponent.Builder> subComponentBuilderProvider;

        public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
            return ViewModelProvider.Factory.CC.$default$create(this, cls, creationExtras);
        }

        public Factory(NonFallbackInjector nonFallbackInjector, String str) {
            Intrinsics.checkNotNullParameter(nonFallbackInjector, "injector");
            this.injector = nonFallbackInjector;
            this.email = str;
        }

        public Void fallbackInitialize(Unit unit) {
            return NonFallbackInjectable.DefaultImpls.fallbackInitialize(this, unit);
        }

        public final Provider<SignUpViewModelSubcomponent.Builder> getSubComponentBuilderProvider() {
            Provider<SignUpViewModelSubcomponent.Builder> provider = this.subComponentBuilderProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("subComponentBuilderProvider");
            return null;
        }

        public final void setSubComponentBuilderProvider(Provider<SignUpViewModelSubcomponent.Builder> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.subComponentBuilderProvider = provider;
        }

        public <T extends ViewModel> T create(Class<T> cls) {
            Intrinsics.checkNotNullParameter(cls, "modelClass");
            this.injector.inject(this);
            return getSubComponentBuilderProvider().get().prefilledEmail(this.email).build().getSignUpViewModel();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/link/ui/signup/SignUpViewModel$Companion;", "", "()V", "LOOKUP_DEBOUNCE_MS", "", "PREFILLED_EMAIL", "", "link_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SignUpViewModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
