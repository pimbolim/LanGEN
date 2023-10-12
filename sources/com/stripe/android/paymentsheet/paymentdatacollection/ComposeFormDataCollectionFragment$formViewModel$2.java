package com.stripe.android.paymentsheet.paymentdatacollection;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import androidx.lifecycle.ViewModelProvider;
import com.stripe.android.paymentsheet.forms.FormViewModel;
import com.stripe.android.ui.core.elements.LayoutSpec;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ComposeFormDataCollectionFragment.kt */
final class ComposeFormDataCollectionFragment$formViewModel$2 extends Lambda implements Function0<ViewModelProvider.Factory> {
    final /* synthetic */ ComposeFormDataCollectionFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ComposeFormDataCollectionFragment$formViewModel$2(ComposeFormDataCollectionFragment composeFormDataCollectionFragment) {
        super(0);
        this.this$0 = composeFormDataCollectionFragment;
    }

    public final ViewModelProvider.Factory invoke() {
        Resources resources = this.this$0.getResources();
        LayoutSpec access$getFormLayout = this.this$0.getFormLayout();
        Parcelable parcelable = this.this$0.requireArguments().getParcelable(ComposeFormDataCollectionFragment.EXTRA_CONFIG);
        if (parcelable != null) {
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            final ComposeFormDataCollectionFragment composeFormDataCollectionFragment = this.this$0;
            return new FormViewModel.Factory((FormFragmentArguments) parcelable, resources, access$getFormLayout, new Function0<Context>() {
                public final Context invoke() {
                    Context requireContext = composeFormDataCollectionFragment.requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                    return requireContext;
                }
            });
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
