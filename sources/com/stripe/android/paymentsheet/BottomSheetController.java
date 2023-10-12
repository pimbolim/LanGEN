package com.stripe.android.paymentsheet;

import android.view.ViewGroup;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0011\u001a\u00020\u000fR\u001c\u0010\u0006\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b0\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/stripe/android/paymentsheet/BottomSheetController;", "", "bottomSheetBehavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/view/ViewGroup;", "(Lcom/google/android/material/bottomsheet/BottomSheetBehavior;)V", "_shouldFinish", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "shouldFinish", "Landroidx/lifecycle/LiveData;", "getShouldFinish$paymentsheet_release", "()Landroidx/lifecycle/LiveData;", "expand", "", "hide", "setup", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BottomSheetController.kt */
public final class BottomSheetController {
    /* access modifiers changed from: private */
    public final MutableLiveData<Boolean> _shouldFinish;
    /* access modifiers changed from: private */
    public final BottomSheetBehavior<ViewGroup> bottomSheetBehavior;
    private final LiveData<Boolean> shouldFinish;

    public BottomSheetController(BottomSheetBehavior<ViewGroup> bottomSheetBehavior2) {
        Intrinsics.checkNotNullParameter(bottomSheetBehavior2, "bottomSheetBehavior");
        this.bottomSheetBehavior = bottomSheetBehavior2;
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>(false);
        this._shouldFinish = mutableLiveData;
        LiveData<Boolean> distinctUntilChanged = Transformations.distinctUntilChanged(mutableLiveData);
        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged, "distinctUntilChanged(this)");
        this.shouldFinish = distinctUntilChanged;
    }

    public final LiveData<Boolean> getShouldFinish$paymentsheet_release() {
        return this.shouldFinish;
    }

    public final void setup() {
        this.bottomSheetBehavior.setHideable(true);
        this.bottomSheetBehavior.setDraggable(false);
        this.bottomSheetBehavior.setState(5);
        this.bottomSheetBehavior.setSaveFlags(-1);
        this.bottomSheetBehavior.addBottomSheetCallback(new BottomSheetController$setup$1(this));
    }

    public final void expand() {
        this.bottomSheetBehavior.setState(3);
    }

    public final void hide() {
        if (this.bottomSheetBehavior.getState() == 5) {
            this._shouldFinish.setValue(true);
        } else {
            this.bottomSheetBehavior.setState(5);
        }
    }
}
