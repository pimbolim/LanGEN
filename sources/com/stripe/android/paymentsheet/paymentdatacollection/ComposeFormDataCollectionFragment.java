package com.stripe.android.paymentsheet.paymentdatacollection;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.stripe.android.paymentsheet.forms.FormViewModel;
import com.stripe.android.ui.core.elements.LayoutSpec;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u0000 !2\u00020\u0001:\u0001!B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8FX\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR)\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000f8FX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\b\u001a\u0004\b\u0012\u0010\u0013¨\u0006\""}, d2 = {"Lcom/stripe/android/paymentsheet/paymentdatacollection/ComposeFormDataCollectionFragment;", "Landroidx/fragment/app/Fragment;", "()V", "formLayout", "Lcom/stripe/android/ui/core/elements/LayoutSpec;", "getFormLayout", "()Lcom/stripe/android/ui/core/elements/LayoutSpec;", "formLayout$delegate", "Lkotlin/Lazy;", "formViewModel", "Lcom/stripe/android/paymentsheet/forms/FormViewModel;", "getFormViewModel", "()Lcom/stripe/android/paymentsheet/forms/FormViewModel;", "formViewModel$delegate", "paramKeySpec", "", "", "", "getParamKeySpec", "()Ljava/util/Map;", "paramKeySpec$delegate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setProcessing", "", "processing", "", "Companion", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ComposeFormDataCollectionFragment.kt */
public final class ComposeFormDataCollectionFragment extends Fragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EXTRA_CONFIG = "com.stripe.android.paymentsheet.extra_config";
    private final Lazy formLayout$delegate = LazyKt.lazy(new ComposeFormDataCollectionFragment$formLayout$2(this));
    private final Lazy formViewModel$delegate;
    private final Lazy paramKeySpec$delegate = LazyKt.lazy(new ComposeFormDataCollectionFragment$paramKeySpec$2(this));

    public ComposeFormDataCollectionFragment() {
        Fragment fragment = this;
        this.formViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(FormViewModel.class), new ComposeFormDataCollectionFragment$special$$inlined$viewModels$default$2(new ComposeFormDataCollectionFragment$special$$inlined$viewModels$default$1(fragment)), new ComposeFormDataCollectionFragment$formViewModel$2(this));
    }

    /* access modifiers changed from: private */
    public final LayoutSpec getFormLayout() {
        return (LayoutSpec) this.formLayout$delegate.getValue();
    }

    public final Map<String, Object> getParamKeySpec() {
        return (Map) this.paramKeySpec$delegate.getValue();
    }

    public final FormViewModel getFormViewModel() {
        return (FormViewModel) this.formViewModel$delegate.getValue();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Context context = layoutInflater.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "inflater.context");
        ComposeView composeView = new ComposeView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        composeView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        composeView.setPadding(0, 18, 0, 0);
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(-985532044, true, new ComposeFormDataCollectionFragment$onCreateView$1$1(this)));
        return composeView;
    }

    public final void setProcessing(boolean z) {
        getFormViewModel().setEnabled$paymentsheet_release(!z);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/paymentsheet/paymentdatacollection/ComposeFormDataCollectionFragment$Companion;", "", "()V", "EXTRA_CONFIG", "", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ComposeFormDataCollectionFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
