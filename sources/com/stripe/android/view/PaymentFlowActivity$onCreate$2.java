package com.stripe.android.view;

import androidx.viewpager.widget.ViewPager;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u000b"}, d2 = {"com/stripe/android/view/PaymentFlowActivity$onCreate$2", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "onPageScrollStateChanged", "", "i", "", "onPageScrolled", "v", "", "i1", "onPageSelected", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentFlowActivity.kt */
public final class PaymentFlowActivity$onCreate$2 implements ViewPager.OnPageChangeListener {
    final /* synthetic */ PaymentFlowActivity this$0;

    public void onPageScrollStateChanged(int i) {
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    PaymentFlowActivity$onCreate$2(PaymentFlowActivity paymentFlowActivity) {
        this.this$0 = paymentFlowActivity;
    }

    public void onPageSelected(int i) {
        PaymentFlowActivity paymentFlowActivity = this.this$0;
        paymentFlowActivity.setTitle(paymentFlowActivity.getPaymentFlowPagerAdapter().getPageTitle(i));
        if (this.this$0.getPaymentFlowPagerAdapter().getPageAt$payments_core_release(i) == PaymentFlowPage.ShippingInfo) {
            this.this$0.getViewModel().setShippingInfoSubmitted$payments_core_release(false);
            this.this$0.getPaymentFlowPagerAdapter().setShippingInfoSubmitted$payments_core_release(false);
        }
    }
}
