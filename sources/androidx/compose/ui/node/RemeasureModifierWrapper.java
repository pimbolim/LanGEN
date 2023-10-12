package androidx.compose.ui.node;

import androidx.compose.ui.layout.OnRemeasuredModifier;
import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\u001d\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\r"}, d2 = {"Landroidx/compose/ui/node/RemeasureModifierWrapper;", "Landroidx/compose/ui/node/DelegatingLayoutNodeWrapper;", "Landroidx/compose/ui/layout/OnRemeasuredModifier;", "wrapped", "Landroidx/compose/ui/node/LayoutNodeWrapper;", "modifier", "(Landroidx/compose/ui/node/LayoutNodeWrapper;Landroidx/compose/ui/layout/OnRemeasuredModifier;)V", "measure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RemeasureModifierWrapper.kt */
public final class RemeasureModifierWrapper extends DelegatingLayoutNodeWrapper<OnRemeasuredModifier> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RemeasureModifierWrapper(LayoutNodeWrapper layoutNodeWrapper, OnRemeasuredModifier onRemeasuredModifier) {
        super(layoutNodeWrapper, onRemeasuredModifier);
        Intrinsics.checkNotNullParameter(layoutNodeWrapper, "wrapped");
        Intrinsics.checkNotNullParameter(onRemeasuredModifier, "modifier");
    }

    /* renamed from: measure-BRTryo0  reason: not valid java name */
    public Placeable m3379measureBRTryo0(long j) {
        OwnerSnapshotObserver snapshotObserver;
        Placeable r3 = super.m3245measureBRTryo0(j);
        Function0 remeasureModifierWrapper$measure$invokeRemeasureCallbacks$1 = new RemeasureModifierWrapper$measure$invokeRemeasureCallbacks$1(this);
        Owner owner$ui_release = getLayoutNode$ui_release().getOwner$ui_release();
        Unit unit = null;
        if (!(owner$ui_release == null || (snapshotObserver = owner$ui_release.getSnapshotObserver()) == null)) {
            snapshotObserver.withNoSnapshotReadObservation$ui_release(remeasureModifierWrapper$measure$invokeRemeasureCallbacks$1);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            remeasureModifierWrapper$measure$invokeRemeasureCallbacks$1.invoke();
        }
        return r3;
    }
}
