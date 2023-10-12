package androidx.compose.ui.node;

import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B.\u0012'\u0010\u0002\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\tJ\u0015\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0001H\u0000¢\u0006\u0002\b\u0012J\r\u0010\u0013\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u0014J#\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\r2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¢\u0006\u0002\b\u0018J#\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\r2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¢\u0006\u0002\b\u001aJ#\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\r2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¢\u0006\u0002\b\u001cJC\u0010\u001d\u001a\u00020\u0005\"\b\b\u0000\u0010\u001e*\u00020\u001f2\u0006\u0010\u0011\u001a\u0002H\u001e2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\u00050\u00032\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¢\u0006\u0004\b!\u0010\"J\r\u0010#\u001a\u00020\u0005H\u0000¢\u0006\u0002\b$J\r\u0010%\u001a\u00020\u0005H\u0000¢\u0006\u0002\b&J\u001b\u0010'\u001a\u00020\u00052\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¢\u0006\u0002\b(R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Landroidx/compose/ui/node/OwnerSnapshotObserver;", "", "onChangedExecutor", "Lkotlin/Function1;", "Lkotlin/Function0;", "", "Lkotlin/ParameterName;", "name", "callback", "(Lkotlin/jvm/functions/Function1;)V", "observer", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "onCommitAffectingLayout", "Landroidx/compose/ui/node/LayoutNode;", "onCommitAffectingLayoutModifier", "onCommitAffectingMeasure", "clear", "target", "clear$ui_release", "clearInvalidObservations", "clearInvalidObservations$ui_release", "observeLayoutModifierSnapshotReads", "node", "block", "observeLayoutModifierSnapshotReads$ui_release", "observeLayoutSnapshotReads", "observeLayoutSnapshotReads$ui_release", "observeMeasureSnapshotReads", "observeMeasureSnapshotReads$ui_release", "observeReads", "T", "Landroidx/compose/ui/node/OwnerScope;", "onChanged", "observeReads$ui_release", "(Landroidx/compose/ui/node/OwnerScope;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "startObserving", "startObserving$ui_release", "stopObserving", "stopObserving$ui_release", "withNoSnapshotReadObservation", "withNoSnapshotReadObservation$ui_release", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OwnerSnapshotObserver.kt */
public final class OwnerSnapshotObserver {
    private final SnapshotStateObserver observer;
    private final Function1<LayoutNode, Unit> onCommitAffectingLayout = OwnerSnapshotObserver$onCommitAffectingLayout$1.INSTANCE;
    private final Function1<LayoutNode, Unit> onCommitAffectingLayoutModifier = OwnerSnapshotObserver$onCommitAffectingLayoutModifier$1.INSTANCE;
    private final Function1<LayoutNode, Unit> onCommitAffectingMeasure = OwnerSnapshotObserver$onCommitAffectingMeasure$1.INSTANCE;

    public OwnerSnapshotObserver(Function1<? super Function0<Unit>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onChangedExecutor");
        this.observer = new SnapshotStateObserver(function1);
    }

    public final void withNoSnapshotReadObservation$ui_release(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        this.observer.withNoObservations(function0);
    }

    public final void observeLayoutSnapshotReads$ui_release(LayoutNode layoutNode, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(layoutNode, "node");
        Intrinsics.checkNotNullParameter(function0, "block");
        observeReads$ui_release(layoutNode, this.onCommitAffectingLayout, function0);
    }

    public final void observeLayoutModifierSnapshotReads$ui_release(LayoutNode layoutNode, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(layoutNode, "node");
        Intrinsics.checkNotNullParameter(function0, "block");
        observeReads$ui_release(layoutNode, this.onCommitAffectingLayoutModifier, function0);
    }

    public final void observeMeasureSnapshotReads$ui_release(LayoutNode layoutNode, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(layoutNode, "node");
        Intrinsics.checkNotNullParameter(function0, "block");
        observeReads$ui_release(layoutNode, this.onCommitAffectingMeasure, function0);
    }

    public final <T extends OwnerScope> void observeReads$ui_release(T t, Function1<? super T, Unit> function1, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(t, "target");
        Intrinsics.checkNotNullParameter(function1, "onChanged");
        Intrinsics.checkNotNullParameter(function0, "block");
        this.observer.observeReads(t, function1, function0);
    }

    public final void clearInvalidObservations$ui_release() {
        this.observer.clearIf(OwnerSnapshotObserver$clearInvalidObservations$1.INSTANCE);
    }

    public final void clear$ui_release(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "target");
        this.observer.clear(obj);
    }

    public final void startObserving$ui_release() {
        this.observer.start();
    }

    public final void stopObserving$ui_release() {
        this.observer.stop();
        this.observer.clear();
    }
}
