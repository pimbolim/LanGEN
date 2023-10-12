package com.stripe.android.paymentsheet.ui;

import android.view.ViewGroup;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.stripe.android.paymentsheet.BottomSheetController;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/stripe/android/paymentsheet/BottomSheetController;", "ResultType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BaseSheetActivity.kt */
final class BaseSheetActivity$bottomSheetController$2 extends Lambda implements Function0<BottomSheetController> {
    final /* synthetic */ BaseSheetActivity<ResultType> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseSheetActivity$bottomSheetController$2(BaseSheetActivity<ResultType> baseSheetActivity) {
        super(0);
        this.this$0 = baseSheetActivity;
    }

    public final BottomSheetController invoke() {
        BottomSheetBehavior<ViewGroup> bottomSheetBehavior$paymentsheet_release = this.this$0.getBottomSheetBehavior$paymentsheet_release();
        Intrinsics.checkNotNullExpressionValue(bottomSheetBehavior$paymentsheet_release, "bottomSheetBehavior");
        return new BottomSheetController(bottomSheetBehavior$paymentsheet_release);
    }
}
