package com.stripe.android.paymentsheet;

import android.app.Application;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.savedstate.SavedStateRegistryOwner;
import com.stripe.android.paymentsheet.PaymentOptionContract;
import com.stripe.android.paymentsheet.PaymentOptionsViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentOptionsListFragment.kt */
final class PaymentOptionsListFragment$activityViewModel$2 extends Lambda implements Function0<ViewModelProvider.Factory> {
    final /* synthetic */ PaymentOptionsListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaymentOptionsListFragment$activityViewModel$2(PaymentOptionsListFragment paymentOptionsListFragment) {
        super(0);
        this.this$0 = paymentOptionsListFragment;
    }

    public final ViewModelProvider.Factory invoke() {
        final PaymentOptionsListFragment paymentOptionsListFragment = this.this$0;
        Function0 r1 = new Function0<Application>() {
            public final Application invoke() {
                Application application = paymentOptionsListFragment.requireActivity().getApplication();
                Intrinsics.checkNotNullExpressionValue(application, "requireActivity().application");
                return application;
            }
        };
        final PaymentOptionsListFragment paymentOptionsListFragment2 = this.this$0;
        Function0 r2 = new Function0<PaymentOptionContract.Args>() {
            public final PaymentOptionContract.Args invoke() {
                Parcelable parcelable = paymentOptionsListFragment2.requireArguments().getParcelable("com.stripe.android.paymentsheet.extra_starter_args");
                if (parcelable != null) {
                    return (PaymentOptionContract.Args) parcelable;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        };
        FragmentActivity activity = this.this$0.getActivity();
        SavedStateRegistryOwner savedStateRegistryOwner = activity instanceof AppCompatActivity ? (AppCompatActivity) activity : null;
        if (savedStateRegistryOwner == null) {
            savedStateRegistryOwner = this.this$0;
        }
        return new PaymentOptionsViewModel.Factory(r1, r2, savedStateRegistryOwner, (Bundle) null, 8, (DefaultConstructorMarker) null);
    }
}
