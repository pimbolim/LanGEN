package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u001d\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\bJ\b\u0010\f\u001a\u00020\u0003H\u0016\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\r"}, d2 = {"androidx/compose/foundation/text/selection/SelectionManager$handleDragObserver$1", "Landroidx/compose/foundation/text/TextDragObserver;", "onCancel", "", "onDrag", "delta", "Landroidx/compose/ui/geometry/Offset;", "onDrag-k-4lQ0M", "(J)V", "onStart", "startPoint", "onStart-k-4lQ0M", "onStop", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SelectionManager.kt */
public final class SelectionManager$handleDragObserver$1 implements TextDragObserver {
    final /* synthetic */ boolean $isStartHandle;
    final /* synthetic */ SelectionManager this$0;

    SelectionManager$handleDragObserver$1(SelectionManager selectionManager, boolean z) {
        this.this$0 = selectionManager;
        this.$isStartHandle = z;
    }

    /* renamed from: onStart-k-4lQ0M  reason: not valid java name */
    public void m790onStartk4lQ0M(long j) {
        long j2;
        this.this$0.hideSelectionToolbar$foundation_release();
        Selection selection = this.this$0.getSelection();
        Intrinsics.checkNotNull(selection);
        Selectable selectable = this.this$0.selectionRegistrar.getSelectableMap$foundation_release().get(Long.valueOf(selection.getStart().getSelectableId()));
        Selectable selectable2 = this.this$0.selectionRegistrar.getSelectableMap$foundation_release().get(Long.valueOf(selection.getEnd().getSelectableId()));
        LayoutCoordinates layoutCoordinates = null;
        if (this.$isStartHandle) {
            if (selectable != null) {
                layoutCoordinates = selectable.getLayoutCoordinates();
            }
            Intrinsics.checkNotNull(layoutCoordinates);
        } else {
            if (selectable2 != null) {
                layoutCoordinates = selectable2.getLayoutCoordinates();
            }
            Intrinsics.checkNotNull(layoutCoordinates);
        }
        if (this.$isStartHandle) {
            Intrinsics.checkNotNull(selectable);
            j2 = selectable.m756getHandlePositiondBAh8RU(selection, true);
        } else {
            Intrinsics.checkNotNull(selectable2);
            j2 = selectable2.m756getHandlePositiondBAh8RU(selection, false);
        }
        long r4 = SelectionHandlesKt.m773getAdjustedCoordinatesk4lQ0M(j2);
        SelectionManager selectionManager = this.this$0;
        selectionManager.dragBeginPosition = selectionManager.requireContainerCoordinates$foundation_release().m3141localPositionOfR5De75A(layoutCoordinates, r4);
        this.this$0.dragTotalDistance = Offset.Companion.m1369getZeroF1C5BW0();
    }

    /* renamed from: onDrag-k-4lQ0M  reason: not valid java name */
    public void m789onDragk4lQ0M(long j) {
        SelectionManager selectionManager = this.this$0;
        selectionManager.dragTotalDistance = Offset.m1358plusMKHz9U(selectionManager.dragTotalDistance, j);
        long r6 = Offset.m1358plusMKHz9U(this.this$0.dragBeginPosition, this.this$0.dragTotalDistance);
        if (this.this$0.m786updateSelectionRHHTvR4$foundation_release(Offset.m1342boximpl(r6), Offset.m1342boximpl(this.this$0.dragBeginPosition), this.$isStartHandle, SelectionAdjustment.Companion.getCharacterWithWordAccelerate())) {
            this.this$0.dragBeginPosition = r6;
            this.this$0.dragTotalDistance = Offset.Companion.m1369getZeroF1C5BW0();
        }
    }

    public void onStop() {
        this.this$0.showSelectionToolbar$foundation_release();
    }

    public void onCancel() {
        this.this$0.showSelectionToolbar$foundation_release();
    }
}
