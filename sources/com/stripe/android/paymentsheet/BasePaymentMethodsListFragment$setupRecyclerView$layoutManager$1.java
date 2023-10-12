package com.stripe.android.paymentsheet;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\b\u001a\u00020\u0003H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"com/stripe/android/paymentsheet/BasePaymentMethodsListFragment$setupRecyclerView$layoutManager$1", "Landroidx/recyclerview/widget/LinearLayoutManager;", "canScroll", "", "getCanScroll", "()Z", "setCanScroll", "(Z)V", "canScrollHorizontally", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BasePaymentMethodsListFragment.kt */
public final class BasePaymentMethodsListFragment$setupRecyclerView$layoutManager$1 extends LinearLayoutManager {
    private boolean canScroll = true;

    BasePaymentMethodsListFragment$setupRecyclerView$layoutManager$1(FragmentActivity fragmentActivity) {
        super(fragmentActivity, 0, false);
    }

    public final boolean getCanScroll() {
        return this.canScroll;
    }

    public final void setCanScroll(boolean z) {
        this.canScroll = z;
    }

    public boolean canScrollHorizontally() {
        return this.canScroll && super.canScrollHorizontally();
    }
}
