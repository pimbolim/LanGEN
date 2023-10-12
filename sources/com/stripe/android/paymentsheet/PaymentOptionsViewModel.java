package com.stripe.android.paymentsheet;

import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.savedstate.SavedStateRegistryOwner;
import com.stripe.android.core.injection.Injectable;
import com.stripe.android.core.injection.InjectableKtxKt;
import com.stripe.android.link.LinkActivityResult;
import com.stripe.android.payments.core.injection.NamedConstantsKt;
import com.stripe.android.paymentsheet.PaymentOptionContract;
import com.stripe.android.paymentsheet.PaymentOptionResult;
import com.stripe.android.paymentsheet.injection.DaggerPaymentOptionsViewModelFactoryComponent;
import com.stripe.android.paymentsheet.injection.PaymentOptionsViewModelSubcomponent;
import com.stripe.android.paymentsheet.model.FragmentConfig;
import com.stripe.android.paymentsheet.model.PaymentSelection;
import com.stripe.android.paymentsheet.viewmodels.BaseSheetViewModel;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002CDBq\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0014\u0010\u0005\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\b\u0001\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0001\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u001a¢\u0006\u0002\u0010\u001bJ\u0010\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u000203H\u0016J\u0010\u00107\u001a\u0002032\u0006\u00108\u001a\u000209H\u0016J\b\u0010:\u001a\u000203H\u0016J\u0006\u0010;\u001a\u000203J\u0010\u0010<\u001a\u0002032\u0006\u0010=\u001a\u00020>H\u0002J\u0010\u0010?\u001a\u0002032\u0006\u0010=\u001a\u00020>H\u0002J\u000e\u0010@\u001a\u0002032\u0006\u0010A\u001a\u00020BR\"\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001e0,X\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0014\u0010/\u001a\u00020$8BX\u0004¢\u0006\u0006\u001a\u0004\b0\u00101¨\u0006E"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentOptionsViewModel;", "Lcom/stripe/android/paymentsheet/viewmodels/BaseSheetViewModel;", "Lcom/stripe/android/paymentsheet/PaymentOptionsViewModel$TransitionTarget;", "args", "Lcom/stripe/android/paymentsheet/PaymentOptionContract$Args;", "prefsRepositoryFactory", "Lkotlin/Function1;", "Lcom/stripe/android/paymentsheet/PaymentSheet$CustomerConfiguration;", "Lcom/stripe/android/paymentsheet/PrefsRepository;", "eventReporter", "Lcom/stripe/android/paymentsheet/analytics/EventReporter;", "customerRepository", "Lcom/stripe/android/paymentsheet/repositories/CustomerRepository;", "workContext", "Lkotlin/coroutines/CoroutineContext;", "application", "Landroid/app/Application;", "logger", "Lcom/stripe/android/core/Logger;", "injectorKey", "", "resourceRepository", "Lcom/stripe/android/ui/core/forms/resources/ResourceRepository;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "linkPaymentLauncherFactory", "Lcom/stripe/android/link/injection/LinkPaymentLauncherFactory;", "(Lcom/stripe/android/paymentsheet/PaymentOptionContract$Args;Lkotlin/jvm/functions/Function1;Lcom/stripe/android/paymentsheet/analytics/EventReporter;Lcom/stripe/android/paymentsheet/repositories/CustomerRepository;Lkotlin/coroutines/CoroutineContext;Landroid/app/Application;Lcom/stripe/android/core/Logger;Ljava/lang/String;Lcom/stripe/android/ui/core/forms/resources/ResourceRepository;Landroidx/lifecycle/SavedStateHandle;Lcom/stripe/android/link/injection/LinkPaymentLauncherFactory;)V", "_paymentOptionResult", "Landroidx/lifecycle/MutableLiveData;", "Lcom/stripe/android/paymentsheet/PaymentOptionResult;", "get_paymentOptionResult$paymentsheet_release$annotations", "()V", "get_paymentOptionResult$paymentsheet_release", "()Landroidx/lifecycle/MutableLiveData;", "hasTransitionToUnsavedCard", "", "newCard", "Lcom/stripe/android/paymentsheet/model/PaymentSelection$New$Card;", "getNewCard", "()Lcom/stripe/android/paymentsheet/model/PaymentSelection$New$Card;", "setNewCard", "(Lcom/stripe/android/paymentsheet/model/PaymentSelection$New$Card;)V", "paymentOptionResult", "Landroidx/lifecycle/LiveData;", "getPaymentOptionResult$paymentsheet_release", "()Landroidx/lifecycle/LiveData;", "shouldTransitionToUnsavedCard", "getShouldTransitionToUnsavedCard", "()Z", "onFatal", "", "throwable", "", "onLinkLaunched", "onLinkPaymentResult", "result", "Lcom/stripe/android/link/LinkActivityResult;", "onUserCancel", "onUserSelection", "processExistingCard", "paymentSelection", "Lcom/stripe/android/paymentsheet/model/PaymentSelection;", "processNewCard", "resolveTransitionTarget", "config", "Lcom/stripe/android/paymentsheet/model/FragmentConfig;", "Factory", "TransitionTarget", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentOptionsViewModel.kt */
public final class PaymentOptionsViewModel extends BaseSheetViewModel<TransitionTarget> {
    private final MutableLiveData<PaymentOptionResult> _paymentOptionResult;
    private boolean hasTransitionToUnsavedCard;
    private PaymentSelection.New.Card newCard;
    private final LiveData<PaymentOptionResult> paymentOptionResult;

    public static /* synthetic */ void get_paymentOptionResult$paymentsheet_release$annotations() {
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @javax.inject.Inject
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PaymentOptionsViewModel(com.stripe.android.paymentsheet.PaymentOptionContract.Args r16, kotlin.jvm.functions.Function1<com.stripe.android.paymentsheet.PaymentSheet.CustomerConfiguration, com.stripe.android.paymentsheet.PrefsRepository> r17, com.stripe.android.paymentsheet.analytics.EventReporter r18, com.stripe.android.paymentsheet.repositories.CustomerRepository r19, @com.stripe.android.core.injection.IOContext kotlin.coroutines.CoroutineContext r20, android.app.Application r21, com.stripe.android.core.Logger r22, @com.stripe.android.core.injection.InjectorKey java.lang.String r23, com.stripe.android.ui.core.forms.resources.ResourceRepository r24, androidx.lifecycle.SavedStateHandle r25, com.stripe.android.link.injection.LinkPaymentLauncherFactory r26) {
        /*
            r15 = this;
            r12 = r15
            r0 = r17
            r13 = r25
            java.lang.String r1 = "args"
            r14 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r1)
            java.lang.String r1 = "prefsRepositoryFactory"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            java.lang.String r1 = "eventReporter"
            r3 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r1)
            java.lang.String r1 = "customerRepository"
            r4 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r1)
            java.lang.String r1 = "workContext"
            r6 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r1)
            java.lang.String r1 = "application"
            r2 = r21
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)
            java.lang.String r1 = "logger"
            r7 = r22
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r1)
            java.lang.String r1 = "injectorKey"
            r8 = r23
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r1)
            java.lang.String r1 = "resourceRepository"
            r9 = r24
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r1)
            java.lang.String r1 = "savedStateHandle"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r1)
            java.lang.String r1 = "linkPaymentLauncherFactory"
            r11 = r26
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r1)
            com.stripe.android.paymentsheet.PaymentSheet$Configuration r5 = r16.getConfig()
            com.stripe.android.paymentsheet.PaymentSheet$Configuration r1 = r16.getConfig()
            if (r1 != 0) goto L_0x005a
            r1 = 0
            goto L_0x005e
        L_0x005a:
            com.stripe.android.paymentsheet.PaymentSheet$CustomerConfiguration r1 = r1.getCustomer()
        L_0x005e:
            java.lang.Object r0 = r0.invoke(r1)
            r10 = r0
            com.stripe.android.paymentsheet.PrefsRepository r10 = (com.stripe.android.paymentsheet.PrefsRepository) r10
            r0 = r15
            r1 = r21
            r2 = r5
            r3 = r18
            r4 = r19
            r5 = r10
            r6 = r20
            r7 = r22
            r8 = r23
            r9 = r24
            r10 = r25
            r11 = r26
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            androidx.lifecycle.MutableLiveData r0 = new androidx.lifecycle.MutableLiveData
            r0.<init>()
            r12._paymentOptionResult = r0
            androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
            r12.paymentOptionResult = r0
            com.stripe.android.paymentsheet.model.PaymentSelection$New$Card r0 = r16.getNewCard()
            r12.newCard = r0
            boolean r0 = r16.isGooglePayReady()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            java.lang.String r1 = "google_pay_ready"
            r13.set(r1, r0)
            com.stripe.android.model.StripeIntent r0 = r16.getStripeIntent()
            r15.setupLink(r0)
            com.stripe.android.model.StripeIntent r0 = r16.getStripeIntent()
            r15.setStripeIntent(r0)
            java.util.List r0 = r16.getPaymentMethods()
            java.lang.String r1 = "customer_payment_methods"
            r13.set(r1, r0)
            r0 = 0
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            java.lang.String r1 = "processing"
            r13.set(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.paymentsheet.PaymentOptionsViewModel.<init>(com.stripe.android.paymentsheet.PaymentOptionContract$Args, kotlin.jvm.functions.Function1, com.stripe.android.paymentsheet.analytics.EventReporter, com.stripe.android.paymentsheet.repositories.CustomerRepository, kotlin.coroutines.CoroutineContext, android.app.Application, com.stripe.android.core.Logger, java.lang.String, com.stripe.android.ui.core.forms.resources.ResourceRepository, androidx.lifecycle.SavedStateHandle, com.stripe.android.link.injection.LinkPaymentLauncherFactory):void");
    }

    public final MutableLiveData<PaymentOptionResult> get_paymentOptionResult$paymentsheet_release() {
        return this._paymentOptionResult;
    }

    public final LiveData<PaymentOptionResult> getPaymentOptionResult$paymentsheet_release() {
        return this.paymentOptionResult;
    }

    public PaymentSelection.New.Card getNewCard() {
        return this.newCard;
    }

    public void setNewCard(PaymentSelection.New.Card card) {
        this.newCard = card;
    }

    private final boolean getShouldTransitionToUnsavedCard() {
        boolean z;
        if (!this.hasTransitionToUnsavedCard) {
            PaymentSelection.New.Card newCard2 = getNewCard();
            PaymentSelection.New newR = newCard2 instanceof PaymentSelection.New ? newCard2 : null;
            if (newR == null || newR.getCustomerRequestedSave() == PaymentSelection.CustomerRequestedSave.RequestReuse) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    public void onFatal(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "throwable");
        get_fatal().setValue(th);
        this._paymentOptionResult.setValue(new PaymentOptionResult.Failed(th));
    }

    public void onUserCancel() {
        this._paymentOptionResult.setValue(new PaymentOptionResult.Canceled(get_fatal().getValue()));
    }

    public final void onUserSelection() {
        PaymentSelection value = getSelection$paymentsheet_release().getValue();
        if (value != null) {
            getEventReporter$paymentsheet_release().onSelectPaymentOption(value);
            if (value instanceof PaymentSelection.Saved ? true : Intrinsics.areEqual((Object) value, (Object) PaymentSelection.GooglePay.INSTANCE)) {
                processExistingCard(value);
            } else if (value instanceof PaymentSelection.New) {
                processNewCard(value);
            }
        }
    }

    public void onLinkLaunched() {
        get_processing$paymentsheet_release().setValue(true);
    }

    public void onLinkPaymentResult(LinkActivityResult linkActivityResult) {
        Intrinsics.checkNotNullParameter(linkActivityResult, "result");
        get_processing$paymentsheet_release().setValue(false);
    }

    private final void processExistingCard(PaymentSelection paymentSelection) {
        getPrefsRepository().savePaymentSelection(paymentSelection);
        this._paymentOptionResult.setValue(new PaymentOptionResult.Succeeded(paymentSelection));
    }

    private final void processNewCard(PaymentSelection paymentSelection) {
        getPrefsRepository().savePaymentSelection(paymentSelection);
        this._paymentOptionResult.setValue(new PaymentOptionResult.Succeeded(paymentSelection));
    }

    public final void resolveTransitionTarget(FragmentConfig fragmentConfig) {
        Intrinsics.checkNotNullParameter(fragmentConfig, "config");
        if (getShouldTransitionToUnsavedCard()) {
            this.hasTransitionToUnsavedCard = true;
            transitionTo(new TransitionTarget.AddPaymentMethodFull(fragmentConfig));
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0003\u0007\b\tB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0001\u0003\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentOptionsViewModel$TransitionTarget;", "", "()V", "fragmentConfig", "Lcom/stripe/android/paymentsheet/model/FragmentConfig;", "getFragmentConfig", "()Lcom/stripe/android/paymentsheet/model/FragmentConfig;", "AddPaymentMethodFull", "AddPaymentMethodSheet", "SelectSavedPaymentMethod", "Lcom/stripe/android/paymentsheet/PaymentOptionsViewModel$TransitionTarget$SelectSavedPaymentMethod;", "Lcom/stripe/android/paymentsheet/PaymentOptionsViewModel$TransitionTarget$AddPaymentMethodFull;", "Lcom/stripe/android/paymentsheet/PaymentOptionsViewModel$TransitionTarget$AddPaymentMethodSheet;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentOptionsViewModel.kt */
    public static abstract class TransitionTarget {
        public /* synthetic */ TransitionTarget(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public abstract FragmentConfig getFragmentConfig();

        private TransitionTarget() {
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentOptionsViewModel$TransitionTarget$SelectSavedPaymentMethod;", "Lcom/stripe/android/paymentsheet/PaymentOptionsViewModel$TransitionTarget;", "fragmentConfig", "Lcom/stripe/android/paymentsheet/model/FragmentConfig;", "(Lcom/stripe/android/paymentsheet/model/FragmentConfig;)V", "getFragmentConfig", "()Lcom/stripe/android/paymentsheet/model/FragmentConfig;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentOptionsViewModel.kt */
        public static final class SelectSavedPaymentMethod extends TransitionTarget {
            public static final int $stable = 8;
            private final FragmentConfig fragmentConfig;

            public static /* synthetic */ SelectSavedPaymentMethod copy$default(SelectSavedPaymentMethod selectSavedPaymentMethod, FragmentConfig fragmentConfig2, int i, Object obj) {
                if ((i & 1) != 0) {
                    fragmentConfig2 = selectSavedPaymentMethod.getFragmentConfig();
                }
                return selectSavedPaymentMethod.copy(fragmentConfig2);
            }

            public final FragmentConfig component1() {
                return getFragmentConfig();
            }

            public final SelectSavedPaymentMethod copy(FragmentConfig fragmentConfig2) {
                Intrinsics.checkNotNullParameter(fragmentConfig2, "fragmentConfig");
                return new SelectSavedPaymentMethod(fragmentConfig2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof SelectSavedPaymentMethod) && Intrinsics.areEqual((Object) getFragmentConfig(), (Object) ((SelectSavedPaymentMethod) obj).getFragmentConfig());
            }

            public int hashCode() {
                return getFragmentConfig().hashCode();
            }

            public String toString() {
                return "SelectSavedPaymentMethod(fragmentConfig=" + getFragmentConfig() + ')';
            }

            public FragmentConfig getFragmentConfig() {
                return this.fragmentConfig;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public SelectSavedPaymentMethod(FragmentConfig fragmentConfig2) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(fragmentConfig2, "fragmentConfig");
                this.fragmentConfig = fragmentConfig2;
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentOptionsViewModel$TransitionTarget$AddPaymentMethodFull;", "Lcom/stripe/android/paymentsheet/PaymentOptionsViewModel$TransitionTarget;", "fragmentConfig", "Lcom/stripe/android/paymentsheet/model/FragmentConfig;", "(Lcom/stripe/android/paymentsheet/model/FragmentConfig;)V", "getFragmentConfig", "()Lcom/stripe/android/paymentsheet/model/FragmentConfig;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentOptionsViewModel.kt */
        public static final class AddPaymentMethodFull extends TransitionTarget {
            public static final int $stable = 8;
            private final FragmentConfig fragmentConfig;

            public static /* synthetic */ AddPaymentMethodFull copy$default(AddPaymentMethodFull addPaymentMethodFull, FragmentConfig fragmentConfig2, int i, Object obj) {
                if ((i & 1) != 0) {
                    fragmentConfig2 = addPaymentMethodFull.getFragmentConfig();
                }
                return addPaymentMethodFull.copy(fragmentConfig2);
            }

            public final FragmentConfig component1() {
                return getFragmentConfig();
            }

            public final AddPaymentMethodFull copy(FragmentConfig fragmentConfig2) {
                Intrinsics.checkNotNullParameter(fragmentConfig2, "fragmentConfig");
                return new AddPaymentMethodFull(fragmentConfig2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof AddPaymentMethodFull) && Intrinsics.areEqual((Object) getFragmentConfig(), (Object) ((AddPaymentMethodFull) obj).getFragmentConfig());
            }

            public int hashCode() {
                return getFragmentConfig().hashCode();
            }

            public String toString() {
                return "AddPaymentMethodFull(fragmentConfig=" + getFragmentConfig() + ')';
            }

            public FragmentConfig getFragmentConfig() {
                return this.fragmentConfig;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public AddPaymentMethodFull(FragmentConfig fragmentConfig2) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(fragmentConfig2, "fragmentConfig");
                this.fragmentConfig = fragmentConfig2;
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentOptionsViewModel$TransitionTarget$AddPaymentMethodSheet;", "Lcom/stripe/android/paymentsheet/PaymentOptionsViewModel$TransitionTarget;", "fragmentConfig", "Lcom/stripe/android/paymentsheet/model/FragmentConfig;", "(Lcom/stripe/android/paymentsheet/model/FragmentConfig;)V", "getFragmentConfig", "()Lcom/stripe/android/paymentsheet/model/FragmentConfig;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentOptionsViewModel.kt */
        public static final class AddPaymentMethodSheet extends TransitionTarget {
            public static final int $stable = 8;
            private final FragmentConfig fragmentConfig;

            public static /* synthetic */ AddPaymentMethodSheet copy$default(AddPaymentMethodSheet addPaymentMethodSheet, FragmentConfig fragmentConfig2, int i, Object obj) {
                if ((i & 1) != 0) {
                    fragmentConfig2 = addPaymentMethodSheet.getFragmentConfig();
                }
                return addPaymentMethodSheet.copy(fragmentConfig2);
            }

            public final FragmentConfig component1() {
                return getFragmentConfig();
            }

            public final AddPaymentMethodSheet copy(FragmentConfig fragmentConfig2) {
                Intrinsics.checkNotNullParameter(fragmentConfig2, "fragmentConfig");
                return new AddPaymentMethodSheet(fragmentConfig2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof AddPaymentMethodSheet) && Intrinsics.areEqual((Object) getFragmentConfig(), (Object) ((AddPaymentMethodSheet) obj).getFragmentConfig());
            }

            public int hashCode() {
                return getFragmentConfig().hashCode();
            }

            public String toString() {
                return "AddPaymentMethodSheet(fragmentConfig=" + getFragmentConfig() + ')';
            }

            public FragmentConfig getFragmentConfig() {
                return this.fragmentConfig;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public AddPaymentMethodSheet(FragmentConfig fragmentConfig2) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(fragmentConfig2, "fragmentConfig");
                this.fragmentConfig = fragmentConfig2;
            }
        }
    }

    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\"B5\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ5\u0010\u0015\u001a\u0002H\u0016\"\b\b\u0000\u0010\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00160\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0014¢\u0006\u0002\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0003H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0004¢\u0006\u0002\n\u0000R$\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006#"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentOptionsViewModel$Factory;", "Landroidx/lifecycle/AbstractSavedStateViewModelFactory;", "Lcom/stripe/android/core/injection/Injectable;", "Lcom/stripe/android/paymentsheet/PaymentOptionsViewModel$Factory$FallbackInitializeParam;", "applicationSupplier", "Lkotlin/Function0;", "Landroid/app/Application;", "starterArgsSupplier", "Lcom/stripe/android/paymentsheet/PaymentOptionContract$Args;", "owner", "Landroidx/savedstate/SavedStateRegistryOwner;", "defaultArgs", "Landroid/os/Bundle;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/savedstate/SavedStateRegistryOwner;Landroid/os/Bundle;)V", "subComponentBuilderProvider", "Ljavax/inject/Provider;", "Lcom/stripe/android/paymentsheet/injection/PaymentOptionsViewModelSubcomponent$Builder;", "getSubComponentBuilderProvider", "()Ljavax/inject/Provider;", "setSubComponentBuilderProvider", "(Ljavax/inject/Provider;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "key", "", "modelClass", "Ljava/lang/Class;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "(Ljava/lang/String;Ljava/lang/Class;Landroidx/lifecycle/SavedStateHandle;)Landroidx/lifecycle/ViewModel;", "fallbackInitialize", "", "arg", "FallbackInitializeParam", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentOptionsViewModel.kt */
    public static final class Factory extends AbstractSavedStateViewModelFactory implements Injectable<FallbackInitializeParam> {
        private final Function0<Application> applicationSupplier;
        private final Function0<PaymentOptionContract.Args> starterArgsSupplier;
        @Inject
        public Provider<PaymentOptionsViewModelSubcomponent.Builder> subComponentBuilderProvider;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Factory(Function0 function0, Function0 function02, SavedStateRegistryOwner savedStateRegistryOwner, Bundle bundle, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(function0, function02, savedStateRegistryOwner, (i & 8) != 0 ? null : bundle);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Factory(Function0<Application> function0, Function0<PaymentOptionContract.Args> function02, SavedStateRegistryOwner savedStateRegistryOwner, Bundle bundle) {
            super(savedStateRegistryOwner, bundle);
            Intrinsics.checkNotNullParameter(function0, "applicationSupplier");
            Intrinsics.checkNotNullParameter(function02, "starterArgsSupplier");
            Intrinsics.checkNotNullParameter(savedStateRegistryOwner, "owner");
            this.applicationSupplier = function0;
            this.starterArgsSupplier = function02;
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentOptionsViewModel$Factory$FallbackInitializeParam;", "", "application", "Landroid/app/Application;", "productUsage", "", "", "(Landroid/app/Application;Ljava/util/Set;)V", "getApplication", "()Landroid/app/Application;", "getProductUsage", "()Ljava/util/Set;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentOptionsViewModel.kt */
        public static final class FallbackInitializeParam {
            private final Application application;
            private final Set<String> productUsage;

            public static /* synthetic */ FallbackInitializeParam copy$default(FallbackInitializeParam fallbackInitializeParam, Application application2, Set<String> set, int i, Object obj) {
                if ((i & 1) != 0) {
                    application2 = fallbackInitializeParam.application;
                }
                if ((i & 2) != 0) {
                    set = fallbackInitializeParam.productUsage;
                }
                return fallbackInitializeParam.copy(application2, set);
            }

            public final Application component1() {
                return this.application;
            }

            public final Set<String> component2() {
                return this.productUsage;
            }

            public final FallbackInitializeParam copy(Application application2, Set<String> set) {
                Intrinsics.checkNotNullParameter(application2, "application");
                Intrinsics.checkNotNullParameter(set, NamedConstantsKt.PRODUCT_USAGE);
                return new FallbackInitializeParam(application2, set);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof FallbackInitializeParam)) {
                    return false;
                }
                FallbackInitializeParam fallbackInitializeParam = (FallbackInitializeParam) obj;
                return Intrinsics.areEqual((Object) this.application, (Object) fallbackInitializeParam.application) && Intrinsics.areEqual((Object) this.productUsage, (Object) fallbackInitializeParam.productUsage);
            }

            public int hashCode() {
                return (this.application.hashCode() * 31) + this.productUsage.hashCode();
            }

            public String toString() {
                return "FallbackInitializeParam(application=" + this.application + ", productUsage=" + this.productUsage + ')';
            }

            public FallbackInitializeParam(Application application2, Set<String> set) {
                Intrinsics.checkNotNullParameter(application2, "application");
                Intrinsics.checkNotNullParameter(set, NamedConstantsKt.PRODUCT_USAGE);
                this.application = application2;
                this.productUsage = set;
            }

            public final Application getApplication() {
                return this.application;
            }

            public final Set<String> getProductUsage() {
                return this.productUsage;
            }
        }

        public void fallbackInitialize(FallbackInitializeParam fallbackInitializeParam) {
            Intrinsics.checkNotNullParameter(fallbackInitializeParam, "arg");
            DaggerPaymentOptionsViewModelFactoryComponent.builder().context(fallbackInitializeParam.getApplication()).productUsage(fallbackInitializeParam.getProductUsage()).build().inject(this);
        }

        public final Provider<PaymentOptionsViewModelSubcomponent.Builder> getSubComponentBuilderProvider() {
            Provider<PaymentOptionsViewModelSubcomponent.Builder> provider = this.subComponentBuilderProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("subComponentBuilderProvider");
            return null;
        }

        public final void setSubComponentBuilderProvider(Provider<PaymentOptionsViewModelSubcomponent.Builder> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.subComponentBuilderProvider = provider;
        }

        /* access modifiers changed from: protected */
        public <T extends ViewModel> T create(String str, Class<T> cls, SavedStateHandle savedStateHandle) {
            Intrinsics.checkNotNullParameter(str, "key");
            Intrinsics.checkNotNullParameter(cls, "modelClass");
            Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
            Application invoke = this.applicationSupplier.invoke();
            PaymentOptionContract.Args invoke2 = this.starterArgsSupplier.invoke();
            InjectableKtxKt.injectWithFallback(this, this.starterArgsSupplier.invoke().getInjectorKey(), new FallbackInitializeParam(invoke, invoke2.getProductUsage()));
            return getSubComponentBuilderProvider().get().application(invoke).args(invoke2).savedStateHandle(savedStateHandle).build().getViewModel();
        }
    }
}
