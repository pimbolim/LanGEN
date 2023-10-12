package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.layout.RemeasurementModifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\r\u0010\"\u001a\u0004\u0018\u00010#¢\u0006\u0002\u0010$R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\r\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006%"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutState;", "", "()V", "itemsProvider", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemsProvider;", "getItemsProvider$foundation_release", "()Lkotlin/jvm/functions/Function0;", "setItemsProvider$foundation_release", "(Lkotlin/jvm/functions/Function0;)V", "layoutInfo", "Landroidx/compose/foundation/lazy/layout/LazyLayoutInfo;", "getLayoutInfo", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutInfo;", "layoutInfoNonObservable", "getLayoutInfoNonObservable$foundation_release", "setLayoutInfoNonObservable$foundation_release", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutInfo;)V", "layoutInfoState", "Landroidx/compose/runtime/MutableState;", "getLayoutInfoState$foundation_release", "()Landroidx/compose/runtime/MutableState;", "onPostMeasureListener", "Landroidx/compose/foundation/lazy/layout/LazyLayoutOnPostMeasureListener;", "getOnPostMeasureListener$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutOnPostMeasureListener;", "setOnPostMeasureListener$foundation_release", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutOnPostMeasureListener;)V", "remeasurement", "Landroidx/compose/ui/layout/Remeasurement;", "remeasurementModifier", "Landroidx/compose/ui/layout/RemeasurementModifier;", "getRemeasurementModifier$foundation_release", "()Landroidx/compose/ui/layout/RemeasurementModifier;", "remeasure", "", "()Lkotlin/Unit;", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LazyLayoutState.kt */
public final class LazyLayoutState {
    private Function0<? extends LazyLayoutItemsProvider> itemsProvider = LazyLayoutState$itemsProvider$1.INSTANCE;
    private LazyLayoutInfo layoutInfoNonObservable = EmptyLazyLayoutInfo.INSTANCE;
    private final MutableState<LazyLayoutInfo> layoutInfoState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(EmptyLazyLayoutInfo.INSTANCE, (SnapshotMutationPolicy) null, 2, (Object) null);
    private LazyLayoutOnPostMeasureListener onPostMeasureListener;
    /* access modifiers changed from: private */
    public Remeasurement remeasurement;
    private final RemeasurementModifier remeasurementModifier = new LazyLayoutState$remeasurementModifier$1(this);

    public final LazyLayoutInfo getLayoutInfo() {
        return this.layoutInfoState.getValue();
    }

    public final MutableState<LazyLayoutInfo> getLayoutInfoState$foundation_release() {
        return this.layoutInfoState;
    }

    public final LazyLayoutInfo getLayoutInfoNonObservable$foundation_release() {
        return this.layoutInfoNonObservable;
    }

    public final void setLayoutInfoNonObservable$foundation_release(LazyLayoutInfo lazyLayoutInfo) {
        Intrinsics.checkNotNullParameter(lazyLayoutInfo, "<set-?>");
        this.layoutInfoNonObservable = lazyLayoutInfo;
    }

    public final Unit remeasure() {
        Remeasurement remeasurement2 = this.remeasurement;
        if (remeasurement2 == null) {
            return null;
        }
        remeasurement2.forceRemeasure();
        return Unit.INSTANCE;
    }

    public final RemeasurementModifier getRemeasurementModifier$foundation_release() {
        return this.remeasurementModifier;
    }

    public final Function0<LazyLayoutItemsProvider> getItemsProvider$foundation_release() {
        return this.itemsProvider;
    }

    public final void setItemsProvider$foundation_release(Function0<? extends LazyLayoutItemsProvider> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.itemsProvider = function0;
    }

    public final LazyLayoutOnPostMeasureListener getOnPostMeasureListener$foundation_release() {
        return this.onPostMeasureListener;
    }

    public final void setOnPostMeasureListener$foundation_release(LazyLayoutOnPostMeasureListener lazyLayoutOnPostMeasureListener) {
        this.onPostMeasureListener = lazyLayoutOnPostMeasureListener;
    }
}
