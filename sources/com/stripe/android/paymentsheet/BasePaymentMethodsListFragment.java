package com.stripe.android.paymentsheet;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnit;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import com.stripe.android.paymentsheet.PaymentOptionsAdapter;
import com.stripe.android.paymentsheet.databinding.FragmentPaymentsheetPaymentMethodsListBinding;
import com.stripe.android.paymentsheet.model.FragmentConfig;
import com.stripe.android.paymentsheet.model.PaymentSelection;
import com.stripe.android.paymentsheet.viewmodels.BaseSheetViewModel;
import com.stripe.android.ui.core.PaymentsThemeDefaults;
import com.stripe.android.ui.core.PaymentsThemeKt;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u0000 62\u00020\u0001:\u00016B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0012\u0010\u001e\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0018\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u000eH\u0016J\u0018\u0010'\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0003H\u0016J\b\u0010+\u001a\u00020\u001bH\u0016J\u0010\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020 H\u0016J\u001a\u0010.\u001a\u00020\u001b2\u0006\u0010/\u001a\u0002002\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u00101\u001a\u00020\u001bH\u0002J\u0010\u00102\u001a\u00020\u001b2\u0006\u00103\u001a\u000204H\u0002J\b\u00105\u001a\u00020\u001bH&R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R,\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00038\u0000@@X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0004R\u0016\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u00067"}, d2 = {"Lcom/stripe/android/paymentsheet/BasePaymentMethodsListFragment;", "Landroidx/fragment/app/Fragment;", "canClickSelectedItem", "", "(Z)V", "adapter", "Lcom/stripe/android/paymentsheet/PaymentOptionsAdapter;", "config", "Lcom/stripe/android/paymentsheet/model/FragmentConfig;", "getConfig", "()Lcom/stripe/android/paymentsheet/model/FragmentConfig;", "setConfig", "(Lcom/stripe/android/paymentsheet/model/FragmentConfig;)V", "editMenuItem", "Landroid/view/MenuItem;", "value", "isEditing", "isEditing$paymentsheet_release$annotations", "()V", "isEditing$paymentsheet_release", "()Z", "setEditing$paymentsheet_release", "sheetViewModel", "Lcom/stripe/android/paymentsheet/viewmodels/BaseSheetViewModel;", "getSheetViewModel", "()Lcom/stripe/android/paymentsheet/viewmodels/BaseSheetViewModel;", "deletePaymentMethod", "", "item", "Lcom/stripe/android/paymentsheet/PaymentOptionsAdapter$Item$SavedPaymentMethod;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onOptionsItemSelected", "onPaymentOptionSelected", "paymentSelection", "Lcom/stripe/android/paymentsheet/model/PaymentSelection;", "isClick", "onResume", "onSaveInstanceState", "outState", "onViewCreated", "view", "Landroid/view/View;", "setEditMenuText", "setupRecyclerView", "viewBinding", "Lcom/stripe/android/paymentsheet/databinding/FragmentPaymentsheetPaymentMethodsListBinding;", "transitionToAddPaymentMethod", "Companion", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BasePaymentMethodsListFragment.kt */
public abstract class BasePaymentMethodsListFragment extends Fragment {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final String IS_EDITING = "is_editing";
    private PaymentOptionsAdapter adapter;
    private final boolean canClickSelectedItem;
    protected FragmentConfig config;
    private MenuItem editMenuItem;
    private boolean isEditing;

    public static /* synthetic */ void isEditing$paymentsheet_release$annotations() {
    }

    public abstract BaseSheetViewModel<?> getSheetViewModel();

    public abstract void transitionToAddPaymentMethod();

    public BasePaymentMethodsListFragment(boolean z) {
        super(R.layout.fragment_paymentsheet_payment_methods_list);
        this.canClickSelectedItem = z;
    }

    /* access modifiers changed from: protected */
    public final FragmentConfig getConfig() {
        FragmentConfig fragmentConfig = this.config;
        if (fragmentConfig != null) {
            return fragmentConfig;
        }
        Intrinsics.throwUninitializedPropertyAccessException("config");
        return null;
    }

    /* access modifiers changed from: protected */
    public final void setConfig(FragmentConfig fragmentConfig) {
        Intrinsics.checkNotNullParameter(fragmentConfig, "<set-?>");
        this.config = fragmentConfig;
    }

    public final boolean isEditing$paymentsheet_release() {
        return this.isEditing;
    }

    public final void setEditing$paymentsheet_release(boolean z) {
        this.isEditing = z;
        PaymentOptionsAdapter paymentOptionsAdapter = this.adapter;
        if (paymentOptionsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            paymentOptionsAdapter = null;
        }
        paymentOptionsAdapter.setEditing(z);
        setEditMenuText();
        getSheetViewModel().setEditing(z);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        FragmentConfig fragmentConfig = arguments == null ? null : (FragmentConfig) arguments.getParcelable("com.stripe.android.paymentsheet.extra_fragment_config");
        if (fragmentConfig == null) {
            getSheetViewModel().onFatal(new IllegalArgumentException("Failed to start existing payment options fragment."));
            return;
        }
        setConfig(fragmentConfig);
        Collection value = getSheetViewModel().getPaymentMethods$paymentsheet_release().getValue();
        setHasOptionsMenu(!(value == null || value.isEmpty()));
        getSheetViewModel().getEventReporter$paymentsheet_release().onShowExistingPaymentOptions();
    }

    public void onViewCreated(View view, Bundle bundle) {
        boolean z;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        FragmentPaymentsheetPaymentMethodsListBinding bind = FragmentPaymentsheetPaymentMethodsListBinding.bind(view);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(view)");
        setupRecyclerView(bind);
        if (bundle == null) {
            z = false;
        } else {
            z = bundle.getBoolean(IS_EDITING);
        }
        setEditing$paymentsheet_release(z);
    }

    public void onResume() {
        super.onResume();
        getSheetViewModel().getHeaderText$paymentsheet_release().setValue(getString(R.string.stripe_paymentsheet_select_payment_method));
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(menuInflater, "inflater");
        menuInflater.inflate(R.menu.paymentsheet_payment_methods_list, menu);
        this.editMenuItem = menu.findItem(R.id.edit);
        setEditMenuText();
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    private final void setEditMenuText() {
        Context context;
        MenuItem menuItem = this.editMenuItem;
        if (menuItem != null && (context = getContext()) != null) {
            menuItem.setTitle(PaymentsThemeKt.m4515createTextSpanFromTextStyleqhTmNto(getString(isEditing$paymentsheet_release() ? R.string.done : R.string.edit), context, Dp.m3859constructorimpl(PaymentsThemeDefaults.INSTANCE.getTypography().getFontSizeMultiplier() * TextUnit.m4040getValueimpl(PaymentsThemeDefaults.INSTANCE.getTypography().m4527getSmallFontSizeXSAIIZE())), PaymentsThemeDefaults.INSTANCE.colors(PaymentsThemeKt.isSystemDarkTheme(context)).m4480getAppBarIcon0d7_KjU(), PaymentsThemeDefaults.INSTANCE.getTypography().getFontFamily()));
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        if (menuItem.getItemId() != R.id.edit) {
            return super.onOptionsItemSelected(menuItem);
        }
        setEditing$paymentsheet_release(!this.isEditing);
        return true;
    }

    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        bundle.putBoolean(IS_EDITING, this.isEditing);
        super.onSaveInstanceState(bundle);
    }

    private final void setupRecyclerView(FragmentPaymentsheetPaymentMethodsListBinding fragmentPaymentsheetPaymentMethodsListBinding) {
        BasePaymentMethodsListFragment$setupRecyclerView$layoutManager$1 basePaymentMethodsListFragment$setupRecyclerView$layoutManager$1 = new BasePaymentMethodsListFragment$setupRecyclerView$layoutManager$1(getActivity());
        fragmentPaymentsheetPaymentMethodsListBinding.recycler.setLayoutManager(basePaymentMethodsListFragment$setupRecyclerView$layoutManager$1);
        PaymentOptionsAdapter paymentOptionsAdapter = new PaymentOptionsAdapter(this.canClickSelectedItem, new BasePaymentMethodsListFragment$setupRecyclerView$1(this), new BasePaymentMethodsListFragment$setupRecyclerView$2(this), new BasePaymentMethodsListFragment$setupRecyclerView$3(this));
        fragmentPaymentsheetPaymentMethodsListBinding.recycler.setAdapter(paymentOptionsAdapter);
        this.adapter = paymentOptionsAdapter;
        if (paymentOptionsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            paymentOptionsAdapter = null;
        }
        FragmentConfig config2 = getConfig();
        List value = getSheetViewModel().getPaymentMethods$paymentsheet_release().getValue();
        if (value == null) {
            value = CollectionsKt.emptyList();
        }
        paymentOptionsAdapter.setItems(config2, value, getSheetViewModel() instanceof PaymentOptionsViewModel, getSheetViewModel().getSelection$paymentsheet_release().getValue());
        getSheetViewModel().getProcessing().observe(getViewLifecycleOwner(), new Observer(basePaymentMethodsListFragment$setupRecyclerView$layoutManager$1) {
            public final /* synthetic */ BasePaymentMethodsListFragment$setupRecyclerView$layoutManager$1 f$1;

            {
                this.f$1 = r2;
            }

            public final void onChanged(Object obj) {
                BasePaymentMethodsListFragment.m4390setupRecyclerView$lambda4(BasePaymentMethodsListFragment.this, this.f$1, (Boolean) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: setupRecyclerView$lambda-4  reason: not valid java name */
    public static final void m4390setupRecyclerView$lambda4(BasePaymentMethodsListFragment basePaymentMethodsListFragment, BasePaymentMethodsListFragment$setupRecyclerView$layoutManager$1 basePaymentMethodsListFragment$setupRecyclerView$layoutManager$1, Boolean bool) {
        Intrinsics.checkNotNullParameter(basePaymentMethodsListFragment, "this$0");
        Intrinsics.checkNotNullParameter(basePaymentMethodsListFragment$setupRecyclerView$layoutManager$1, "$layoutManager");
        PaymentOptionsAdapter paymentOptionsAdapter = basePaymentMethodsListFragment.adapter;
        if (paymentOptionsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            paymentOptionsAdapter = null;
        }
        paymentOptionsAdapter.setEnabled$paymentsheet_release(!bool.booleanValue());
        basePaymentMethodsListFragment$setupRecyclerView$layoutManager$1.setCanScroll(!bool.booleanValue());
    }

    public void onPaymentOptionSelected(PaymentSelection paymentSelection, boolean z) {
        Intrinsics.checkNotNullParameter(paymentSelection, "paymentSelection");
        getSheetViewModel().updateSelection(paymentSelection);
    }

    /* access modifiers changed from: private */
    public final void deletePaymentMethod(PaymentOptionsAdapter.Item.SavedPaymentMethod savedPaymentMethod) {
        PaymentOptionsAdapter paymentOptionsAdapter = this.adapter;
        if (paymentOptionsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            paymentOptionsAdapter = null;
        }
        paymentOptionsAdapter.removeItem(savedPaymentMethod);
        getSheetViewModel().removePaymentMethod(savedPaymentMethod.getPaymentMethod());
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/paymentsheet/BasePaymentMethodsListFragment$Companion;", "", "()V", "IS_EDITING", "", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BasePaymentMethodsListFragment.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
