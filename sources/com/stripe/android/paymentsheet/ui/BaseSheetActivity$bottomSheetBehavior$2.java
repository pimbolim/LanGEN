package com.stripe.android.paymentsheet.ui;

import android.view.ViewGroup;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "ResultType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BaseSheetActivity.kt */
final class BaseSheetActivity$bottomSheetBehavior$2 extends Lambda implements Function0<BottomSheetBehavior<ViewGroup>> {
    final /* synthetic */ BaseSheetActivity<ResultType> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseSheetActivity$bottomSheetBehavior$2(BaseSheetActivity<ResultType> baseSheetActivity) {
        super(0);
        this.this$0 = baseSheetActivity;
    }

    public final BottomSheetBehavior<ViewGroup> invoke() {
        return BottomSheetBehavior.from(this.this$0.getBottomSheet());
    }
}
