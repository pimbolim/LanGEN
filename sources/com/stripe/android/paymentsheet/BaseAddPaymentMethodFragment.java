package com.stripe.android.paymentsheet;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.ViewCompositionStrategy;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentOnAttachListener;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.stripe.android.core.injection.InjectorKey;
import com.stripe.android.model.CardBrand;
import com.stripe.android.model.PaymentMethodCreateParams;
import com.stripe.android.model.StripeIntent;
import com.stripe.android.paymentsheet.PaymentSheet;
import com.stripe.android.paymentsheet.databinding.FragmentPaymentsheetAddPaymentMethodBinding;
import com.stripe.android.paymentsheet.forms.FormFieldValues;
import com.stripe.android.paymentsheet.forms.FormViewModel;
import com.stripe.android.paymentsheet.model.PaymentSelection;
import com.stripe.android.paymentsheet.model.SupportedPaymentMethod;
import com.stripe.android.paymentsheet.paymentdatacollection.ComposeFormDataCollectionFragment;
import com.stripe.android.paymentsheet.paymentdatacollection.FormFragmentArguments;
import com.stripe.android.paymentsheet.paymentdatacollection.TransformToPaymentMethodCreateParams;
import com.stripe.android.paymentsheet.ui.AnimationConstants;
import com.stripe.android.paymentsheet.viewmodels.BaseSheetViewModel;
import com.stripe.android.ui.core.Amount;
import com.stripe.android.ui.core.elements.IdentifierSpec;
import com.stripe.android.ui.core.elements.LayoutFormDescriptor;
import com.stripe.android.ui.core.forms.FormFieldEntry;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\b \u0018\u0000 $2\u00020\u0001:\u0001$B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0001H\u0002J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0002J&\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0015\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0001¢\u0006\u0002\b\u001aJ\u001a\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J&\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00190\"2\u0006\u0010#\u001a\u00020\u0019H\u0002R\u0016\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006%"}, d2 = {"Lcom/stripe/android/paymentsheet/BaseAddPaymentMethodFragment;", "Landroidx/fragment/app/Fragment;", "()V", "sheetViewModel", "Lcom/stripe/android/paymentsheet/viewmodels/BaseSheetViewModel;", "getSheetViewModel", "()Lcom/stripe/android/paymentsheet/viewmodels/BaseSheetViewModel;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "attachComposeFragmentViewModel", "", "fragment", "getFragment", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPaymentMethodSelected", "paymentMethod", "Lcom/stripe/android/paymentsheet/model/SupportedPaymentMethod;", "onPaymentMethodSelected$paymentsheet_release", "onViewCreated", "view", "replacePaymentMethodFragment", "setupRecyclerView", "viewBinding", "Lcom/stripe/android/paymentsheet/databinding/FragmentPaymentsheetAddPaymentMethodBinding;", "paymentMethods", "", "initialSelectedItem", "Companion", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BaseAddPaymentMethodFragment.kt */
public abstract class BaseAddPaymentMethodFragment extends Fragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final TransformToPaymentMethodCreateParams transformToPaymentMethodCreateParams = new TransformToPaymentMethodCreateParams();

    public abstract BaseSheetViewModel<?> getSheetViewModel();

    public abstract ViewModelProvider.Factory getViewModelFactory();

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.cloneInContext(new ContextThemeWrapper((Context) requireActivity(), R.style.StripePaymentSheetAddPaymentMethodTheme)).inflate(R.layout.fragment_paymentsheet_add_payment_method, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        FragmentPaymentsheetAddPaymentMethodBinding bind = FragmentPaymentsheetAddPaymentMethodBinding.bind(view);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(view)");
        List<SupportedPaymentMethod> supportedPaymentMethods$paymentsheet_release = getSheetViewModel().getSupportedPaymentMethods$paymentsheet_release();
        getSheetViewModel().getHeaderText$paymentsheet_release().setValue(getString(R.string.stripe_paymentsheet_add_payment_method_title));
        Integer valueOf = Integer.valueOf(CollectionsKt.indexOf(supportedPaymentMethods$paymentsheet_release, getSheetViewModel().getAddFragmentSelectedLpm().getValue()));
        int i = 0;
        if (valueOf.intValue() == -1) {
            valueOf = null;
        }
        if (valueOf != null) {
            i = valueOf.intValue();
        }
        if (supportedPaymentMethods$paymentsheet_release.size() > 1) {
            setupRecyclerView(bind, supportedPaymentMethods$paymentsheet_release, getSheetViewModel().getAddFragmentSelectedLpmValue());
        }
        if ((!supportedPaymentMethods$paymentsheet_release.isEmpty()) && bundle == null) {
            replacePaymentMethodFragment(supportedPaymentMethods$paymentsheet_release.get(i));
        }
        getSheetViewModel().getProcessing().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                BaseAddPaymentMethodFragment.m4385onViewCreated$lambda1(BaseAddPaymentMethodFragment.this, (Boolean) obj);
            }
        });
        List<Fragment> fragments = getChildFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "childFragmentManager.fragments");
        for (Fragment fragment : fragments) {
            Intrinsics.checkNotNullExpressionValue(fragment, "fragment");
            attachComposeFragmentViewModel(fragment);
        }
        getChildFragmentManager().addFragmentOnAttachListener(new FragmentOnAttachListener() {
            public final void onAttachFragment(FragmentManager fragmentManager, Fragment fragment) {
                BaseAddPaymentMethodFragment.m4386onViewCreated$lambda3(BaseAddPaymentMethodFragment.this, fragmentManager, fragment);
            }
        });
        getSheetViewModel().getEventReporter$paymentsheet_release().onShowNewPaymentOptionForm();
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-1  reason: not valid java name */
    public static final void m4385onViewCreated$lambda1(BaseAddPaymentMethodFragment baseAddPaymentMethodFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(baseAddPaymentMethodFragment, "this$0");
        Fragment fragment = baseAddPaymentMethodFragment.getFragment();
        ComposeFormDataCollectionFragment composeFormDataCollectionFragment = fragment instanceof ComposeFormDataCollectionFragment ? (ComposeFormDataCollectionFragment) fragment : null;
        if (composeFormDataCollectionFragment != null) {
            Intrinsics.checkNotNullExpressionValue(bool, "isProcessing");
            composeFormDataCollectionFragment.setProcessing(bool.booleanValue());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-3  reason: not valid java name */
    public static final void m4386onViewCreated$lambda3(BaseAddPaymentMethodFragment baseAddPaymentMethodFragment, FragmentManager fragmentManager, Fragment fragment) {
        Intrinsics.checkNotNullParameter(baseAddPaymentMethodFragment, "this$0");
        Intrinsics.checkNotNullParameter(fragmentManager, "$noName_0");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        baseAddPaymentMethodFragment.attachComposeFragmentViewModel(fragment);
    }

    private final void attachComposeFragmentViewModel(Fragment fragment) {
        ComposeFormDataCollectionFragment composeFormDataCollectionFragment = fragment instanceof ComposeFormDataCollectionFragment ? (ComposeFormDataCollectionFragment) fragment : null;
        if (composeFormDataCollectionFragment != null) {
            FormViewModel formViewModel = composeFormDataCollectionFragment.getFormViewModel();
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
            Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new BaseAddPaymentMethodFragment$attachComposeFragmentViewModel$1$1(formViewModel, this, composeFormDataCollectionFragment, (Continuation<? super BaseAddPaymentMethodFragment$attachComposeFragmentViewModel$1$1>) null), 3, (Object) null);
        }
    }

    private final void setupRecyclerView(FragmentPaymentsheetAddPaymentMethodBinding fragmentPaymentsheetAddPaymentMethodBinding, List<? extends SupportedPaymentMethod> list, SupportedPaymentMethod supportedPaymentMethod) {
        ComposeView composeView = fragmentPaymentsheetAddPaymentMethodBinding.paymentMethodsRecycler;
        Intrinsics.checkNotNullExpressionValue(composeView, "viewBinding.paymentMethodsRecycler");
        composeView.setVisibility(0);
        ComposeView composeView2 = fragmentPaymentsheetAddPaymentMethodBinding.paymentMethodsRecycler;
        composeView2.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed.INSTANCE);
        composeView2.setContent(ComposableLambdaKt.composableLambdaInstance(-985537436, true, new BaseAddPaymentMethodFragment$setupRecyclerView$1$1(this, supportedPaymentMethod, list)));
    }

    public final void onPaymentMethodSelected$paymentsheet_release(SupportedPaymentMethod supportedPaymentMethod) {
        Intrinsics.checkNotNullParameter(supportedPaymentMethod, "paymentMethod");
        WindowInsetsControllerCompat windowInsetsController = ViewCompat.getWindowInsetsController(requireView());
        if (windowInsetsController != null) {
            windowInsetsController.hide(WindowInsetsCompat.Type.ime());
        }
        replacePaymentMethodFragment(supportedPaymentMethod);
    }

    private final void replacePaymentMethodFragment(SupportedPaymentMethod supportedPaymentMethod) {
        getSheetViewModel().setAddFragmentSelectedLPM(supportedPaymentMethod);
        Bundle requireArguments = requireArguments();
        Intrinsics.checkNotNullExpressionValue(requireArguments, "requireArguments()");
        Companion companion = Companion;
        StripeIntent value = getSheetViewModel().getStripeIntent$paymentsheet_release().getValue();
        if (value != null) {
            requireArguments.putParcelable(ComposeFormDataCollectionFragment.EXTRA_CONFIG, companion.getFormArguments$paymentsheet_release(supportedPaymentMethod, value, getSheetViewModel().getConfig$paymentsheet_release(), getSheetViewModel().getMerchantName$paymentsheet_release(), getSheetViewModel().getAmount$paymentsheet_release().getValue(), getSheetViewModel().getInjectorKey()));
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            FragmentTransaction beginTransaction = childFragmentManager.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction()");
            beginTransaction.setCustomAnimations(AnimationConstants.INSTANCE.getFADE_IN(), AnimationConstants.INSTANCE.getFADE_OUT(), AnimationConstants.INSTANCE.getFADE_IN(), AnimationConstants.INSTANCE.getFADE_OUT());
            beginTransaction.replace(R.id.payment_method_fragment_container, (Class<? extends Fragment>) ComposeFormDataCollectionFragment.class, requireArguments);
            beginTransaction.commit();
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final Fragment getFragment() {
        return getChildFragmentManager().findFragmentById(R.id.payment_method_fragment_container);
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JE\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0001\u0010\u0011\u001a\u00020\u000eH\u0001¢\u0006\u0002\b\u0012J7\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00182\u0006\u0010\u0019\u001a\u00020\bH\u0001¢\u0006\u0002\b\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/stripe/android/paymentsheet/BaseAddPaymentMethodFragment$Companion;", "", "()V", "transformToPaymentMethodCreateParams", "Lcom/stripe/android/paymentsheet/paymentdatacollection/TransformToPaymentMethodCreateParams;", "getFormArguments", "Lcom/stripe/android/paymentsheet/paymentdatacollection/FormFragmentArguments;", "showPaymentMethod", "Lcom/stripe/android/paymentsheet/model/SupportedPaymentMethod;", "stripeIntent", "Lcom/stripe/android/model/StripeIntent;", "config", "Lcom/stripe/android/paymentsheet/PaymentSheet$Configuration;", "merchantName", "", "amount", "Lcom/stripe/android/ui/core/Amount;", "injectorKey", "getFormArguments$paymentsheet_release", "transformToPaymentSelection", "Lcom/stripe/android/paymentsheet/model/PaymentSelection$New;", "formFieldValues", "Lcom/stripe/android/paymentsheet/forms/FormFieldValues;", "paramKey", "", "selectedPaymentMethodResources", "transformToPaymentSelection$paymentsheet_release", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BaseAddPaymentMethodFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PaymentSelection.New transformToPaymentSelection$paymentsheet_release(FormFieldValues formFieldValues, Map<String, ? extends Object> map, SupportedPaymentMethod supportedPaymentMethod) {
            PaymentMethodCreateParams transform;
            PaymentSelection.New newR;
            Intrinsics.checkNotNullParameter(map, "paramKey");
            Intrinsics.checkNotNullParameter(supportedPaymentMethod, "selectedPaymentMethodResources");
            String str = null;
            if (formFieldValues == null || (transform = BaseAddPaymentMethodFragment.transformToPaymentMethodCreateParams.transform(formFieldValues, map)) == null) {
                return null;
            }
            if (Intrinsics.areEqual((Object) transform.getTypeCode(), (Object) "card")) {
                CardBrand.Companion companion = CardBrand.Companion;
                FormFieldEntry formFieldEntry = formFieldValues.getFieldValuePairs().get(IdentifierSpec.CardBrand.INSTANCE);
                if (formFieldEntry != null) {
                    str = formFieldEntry.getValue();
                }
                newR = new PaymentSelection.New.Card(transform, companion.fromCode(str), formFieldValues.getUserRequestedReuse());
            } else {
                newR = new PaymentSelection.New.GenericPaymentMethod(supportedPaymentMethod.getDisplayNameResource(), supportedPaymentMethod.getIconResource(), transform, formFieldValues.getUserRequestedReuse());
            }
            return newR;
        }

        public static /* synthetic */ FormFragmentArguments getFormArguments$paymentsheet_release$default(Companion companion, SupportedPaymentMethod supportedPaymentMethod, StripeIntent stripeIntent, PaymentSheet.Configuration configuration, String str, Amount amount, String str2, int i, Object obj) {
            if ((i & 16) != 0) {
                amount = null;
            }
            return companion.getFormArguments$paymentsheet_release(supportedPaymentMethod, stripeIntent, configuration, str, amount, str2);
        }

        public final FormFragmentArguments getFormArguments$paymentsheet_release(SupportedPaymentMethod supportedPaymentMethod, StripeIntent stripeIntent, PaymentSheet.Configuration configuration, String str, Amount amount, @InjectorKey String str2) {
            PaymentSheet.BillingDetails billingDetails;
            Intrinsics.checkNotNullParameter(supportedPaymentMethod, "showPaymentMethod");
            Intrinsics.checkNotNullParameter(stripeIntent, "stripeIntent");
            Intrinsics.checkNotNullParameter(str, "merchantName");
            Intrinsics.checkNotNullParameter(str2, "injectorKey");
            LayoutFormDescriptor pMAddForm = supportedPaymentMethod.getPMAddForm(stripeIntent, configuration);
            boolean showCheckbox = pMAddForm.getShowCheckbox();
            boolean showCheckboxControlledFields = pMAddForm.getShowCheckboxControlledFields();
            if (configuration == null) {
                billingDetails = null;
            } else {
                billingDetails = configuration.getDefaultBillingDetails();
            }
            return new FormFragmentArguments(supportedPaymentMethod, showCheckbox, showCheckboxControlledFields, str, amount, billingDetails, str2);
        }
    }
}
