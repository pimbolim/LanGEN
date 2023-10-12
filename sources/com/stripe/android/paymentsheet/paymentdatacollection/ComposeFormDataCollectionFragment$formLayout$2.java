package com.stripe.android.paymentsheet.paymentdatacollection;

import com.stripe.android.paymentsheet.model.SupportedPaymentMethod;
import com.stripe.android.ui.core.elements.LayoutSpec;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/stripe/android/ui/core/elements/LayoutSpec;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ComposeFormDataCollectionFragment.kt */
final class ComposeFormDataCollectionFragment$formLayout$2 extends Lambda implements Function0<LayoutSpec> {
    final /* synthetic */ ComposeFormDataCollectionFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ComposeFormDataCollectionFragment$formLayout$2(ComposeFormDataCollectionFragment composeFormDataCollectionFragment) {
        super(0);
        this.this$0 = composeFormDataCollectionFragment;
    }

    public final LayoutSpec invoke() {
        SupportedPaymentMethod paymentMethod;
        FormFragmentArguments formFragmentArguments = (FormFragmentArguments) this.this$0.requireArguments().getParcelable(ComposeFormDataCollectionFragment.EXTRA_CONFIG);
        LayoutSpec layoutSpec = null;
        if (!(formFragmentArguments == null || (paymentMethod = formFragmentArguments.getPaymentMethod()) == null)) {
            layoutSpec = paymentMethod.getFormSpec();
        }
        if (layoutSpec != null) {
            return layoutSpec;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
