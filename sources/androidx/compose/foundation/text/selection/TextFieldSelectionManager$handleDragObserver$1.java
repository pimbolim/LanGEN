package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u001d\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\bJ\b\u0010\f\u001a\u00020\u0003H\u0016\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\r"}, d2 = {"androidx/compose/foundation/text/selection/TextFieldSelectionManager$handleDragObserver$1", "Landroidx/compose/foundation/text/TextDragObserver;", "onCancel", "", "onDrag", "delta", "Landroidx/compose/ui/geometry/Offset;", "onDrag-k-4lQ0M", "(J)V", "onStart", "startPoint", "onStart-k-4lQ0M", "onStop", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextFieldSelectionManager.kt */
public final class TextFieldSelectionManager$handleDragObserver$1 implements TextDragObserver {
    final /* synthetic */ boolean $isStartHandle;
    final /* synthetic */ TextFieldSelectionManager this$0;

    public void onCancel() {
    }

    TextFieldSelectionManager$handleDragObserver$1(TextFieldSelectionManager textFieldSelectionManager, boolean z) {
        this.this$0 = textFieldSelectionManager;
        this.$isStartHandle = z;
    }

    /* renamed from: onStart-k-4lQ0M  reason: not valid java name */
    public void m814onStartk4lQ0M(long j) {
        TextFieldSelectionManager textFieldSelectionManager = this.this$0;
        textFieldSelectionManager.dragBeginPosition = SelectionHandlesKt.m773getAdjustedCoordinatesk4lQ0M(textFieldSelectionManager.m810getHandlePositiontuRUvjQ$foundation_release(this.$isStartHandle));
        this.this$0.dragTotalDistance = Offset.Companion.m1369getZeroF1C5BW0();
        TextFieldState state$foundation_release = this.this$0.getState$foundation_release();
        if (state$foundation_release != null) {
            state$foundation_release.setDraggingHandle(this.$isStartHandle ? Handle.SelectionStart : Handle.SelectionEnd);
        }
        TextFieldState state$foundation_release2 = this.this$0.getState$foundation_release();
        if (state$foundation_release2 != null) {
            state$foundation_release2.setShowFloatingToolbar(false);
        }
    }

    /* renamed from: onDrag-k-4lQ0M  reason: not valid java name */
    public void m813onDragk4lQ0M(long j) {
        TextLayoutResultProxy layoutResult;
        TextLayoutResult value;
        int i;
        int i2;
        TextFieldSelectionManager textFieldSelectionManager = this.this$0;
        textFieldSelectionManager.dragTotalDistance = Offset.m1358plusMKHz9U(textFieldSelectionManager.dragTotalDistance, j);
        TextFieldState state$foundation_release = this.this$0.getState$foundation_release();
        if (!(state$foundation_release == null || (layoutResult = state$foundation_release.getLayoutResult()) == null || (value = layoutResult.getValue()) == null)) {
            boolean z = this.$isStartHandle;
            TextFieldSelectionManager textFieldSelectionManager2 = this.this$0;
            if (z) {
                i = value.m3554getOffsetForPositionk4lQ0M(Offset.m1358plusMKHz9U(textFieldSelectionManager2.dragBeginPosition, textFieldSelectionManager2.dragTotalDistance));
            } else {
                i = textFieldSelectionManager2.getOffsetMapping$foundation_release().originalToTransformed(TextRange.m3571getStartimpl(textFieldSelectionManager2.getValue$foundation_release().m3688getSelectiond9O1mEE()));
            }
            int i3 = i;
            if (z) {
                i2 = textFieldSelectionManager2.getOffsetMapping$foundation_release().originalToTransformed(TextRange.m3566getEndimpl(textFieldSelectionManager2.getValue$foundation_release().m3688getSelectiond9O1mEE()));
            } else {
                i2 = value.m3554getOffsetForPositionk4lQ0M(Offset.m1358plusMKHz9U(textFieldSelectionManager2.dragBeginPosition, textFieldSelectionManager2.dragTotalDistance));
            }
            textFieldSelectionManager2.updateSelection(textFieldSelectionManager2.getValue$foundation_release(), i3, i2, z, SelectionAdjustment.Companion.getCharacter());
        }
        TextFieldState state$foundation_release2 = this.this$0.getState$foundation_release();
        if (state$foundation_release2 != null) {
            state$foundation_release2.setShowFloatingToolbar(false);
        }
    }

    public void onStop() {
        TextFieldState state$foundation_release = this.this$0.getState$foundation_release();
        TextToolbarStatus textToolbarStatus = null;
        if (state$foundation_release != null) {
            state$foundation_release.setDraggingHandle((Handle) null);
        }
        TextFieldState state$foundation_release2 = this.this$0.getState$foundation_release();
        if (state$foundation_release2 != null) {
            state$foundation_release2.setShowFloatingToolbar(true);
        }
        TextToolbar textToolbar = this.this$0.getTextToolbar();
        if (textToolbar != null) {
            textToolbarStatus = textToolbar.getStatus();
        }
        if (textToolbarStatus == TextToolbarStatus.Hidden) {
            this.this$0.showSelectionToolbar$foundation_release();
        }
    }
}
