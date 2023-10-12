package com.stripe.android.paymentsheet.injection;

import com.stripe.android.paymentsheet.forms.FormViewModel;
import com.stripe.android.paymentsheet.paymentdatacollection.FormFragmentArguments;
import com.stripe.android.ui.core.elements.LayoutSpec;
import dagger.BindsInstance;
import dagger.Subcomponent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\ba\u0018\u00002\u00020\u0001:\u0001\u0006R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/paymentsheet/injection/FormViewModelSubcomponent;", "", "viewModel", "Lcom/stripe/android/paymentsheet/forms/FormViewModel;", "getViewModel", "()Lcom/stripe/android/paymentsheet/forms/FormViewModel;", "Builder", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Subcomponent
/* compiled from: FormViewModelSubcomponent.kt */
public interface FormViewModelSubcomponent {

    @Subcomponent.Builder
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006H'J\u0010\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tH'¨\u0006\n"}, d2 = {"Lcom/stripe/android/paymentsheet/injection/FormViewModelSubcomponent$Builder;", "", "build", "Lcom/stripe/android/paymentsheet/injection/FormViewModelSubcomponent;", "formFragmentArguments", "config", "Lcom/stripe/android/paymentsheet/paymentdatacollection/FormFragmentArguments;", "layout", "layoutSpec", "Lcom/stripe/android/ui/core/elements/LayoutSpec;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FormViewModelSubcomponent.kt */
    public interface Builder {
        FormViewModelSubcomponent build();

        @BindsInstance
        Builder formFragmentArguments(FormFragmentArguments formFragmentArguments);

        @BindsInstance
        Builder layout(LayoutSpec layoutSpec);
    }

    FormViewModel getViewModel();
}
