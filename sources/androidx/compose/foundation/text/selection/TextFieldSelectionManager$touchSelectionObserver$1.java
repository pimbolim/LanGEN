package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u001d\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\bJ\b\u0010\f\u001a\u00020\u0003H\u0016\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\r"}, d2 = {"androidx/compose/foundation/text/selection/TextFieldSelectionManager$touchSelectionObserver$1", "Landroidx/compose/foundation/text/TextDragObserver;", "onCancel", "", "onDrag", "delta", "Landroidx/compose/ui/geometry/Offset;", "onDrag-k-4lQ0M", "(J)V", "onStart", "startPoint", "onStart-k-4lQ0M", "onStop", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextFieldSelectionManager.kt */
public final class TextFieldSelectionManager$touchSelectionObserver$1 implements TextDragObserver {
    final /* synthetic */ TextFieldSelectionManager this$0;

    public void onCancel() {
    }

    TextFieldSelectionManager$touchSelectionObserver$1(TextFieldSelectionManager textFieldSelectionManager) {
        this.this$0 = textFieldSelectionManager;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001c, code lost:
        r0 = r0.getLayoutResult();
     */
    /* renamed from: onStart-k-4lQ0M  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m820onStartk4lQ0M(long r9) {
        /*
            r8 = this;
            androidx.compose.foundation.text.selection.TextFieldSelectionManager r0 = r8.this$0
            androidx.compose.foundation.text.TextFieldState r0 = r0.getState$foundation_release()
            if (r0 != 0) goto L_0x0009
            goto L_0x0010
        L_0x0009:
            androidx.compose.foundation.text.Handle r0 = r0.getDraggingHandle()
            if (r0 == 0) goto L_0x0010
            return
        L_0x0010:
            androidx.compose.foundation.text.selection.TextFieldSelectionManager r0 = r8.this$0
            androidx.compose.foundation.text.TextFieldState r0 = r0.getState$foundation_release()
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x001c
        L_0x001a:
            r0 = 0
            goto L_0x002a
        L_0x001c:
            androidx.compose.foundation.text.TextLayoutResultProxy r0 = r0.getLayoutResult()
            if (r0 != 0) goto L_0x0023
            goto L_0x001a
        L_0x0023:
            boolean r0 = r0.m731isPositionOnTextk4lQ0M(r9)
            if (r0 != r1) goto L_0x001a
            r0 = 1
        L_0x002a:
            if (r0 != 0) goto L_0x007f
            androidx.compose.foundation.text.selection.TextFieldSelectionManager r0 = r8.this$0
            androidx.compose.foundation.text.TextFieldState r0 = r0.getState$foundation_release()
            if (r0 != 0) goto L_0x0035
            goto L_0x007f
        L_0x0035:
            androidx.compose.foundation.text.TextLayoutResultProxy r0 = r0.getLayoutResult()
            if (r0 != 0) goto L_0x003c
            goto L_0x007f
        L_0x003c:
            androidx.compose.foundation.text.selection.TextFieldSelectionManager r1 = r8.this$0
            androidx.compose.ui.text.input.OffsetMapping r3 = r1.getOffsetMapping$foundation_release()
            float r9 = androidx.compose.ui.geometry.Offset.m1354getYimpl(r9)
            int r9 = r0.getLineForVerticalPosition(r9)
            r10 = 2
            r4 = 0
            int r9 = androidx.compose.foundation.text.TextLayoutResultProxy.getLineEnd$default(r0, r9, r2, r10, r4)
            int r9 = r3.transformedToOriginal(r9)
            androidx.compose.ui.hapticfeedback.HapticFeedback r10 = r1.getHapticFeedBack()
            if (r10 != 0) goto L_0x005b
            goto L_0x0064
        L_0x005b:
            androidx.compose.ui.hapticfeedback.HapticFeedbackType$Companion r0 = androidx.compose.ui.hapticfeedback.HapticFeedbackType.Companion
            int r0 = r0.m2239getTextHandleMove5zf0vsI()
            r10.m2230performHapticFeedbackCdsT49E(r0)
        L_0x0064:
            androidx.compose.ui.text.input.TextFieldValue r10 = r1.getValue$foundation_release()
            androidx.compose.ui.text.AnnotatedString r10 = r10.getAnnotatedString()
            long r2 = androidx.compose.ui.text.TextRangeKt.TextRange(r9, r9)
            androidx.compose.ui.text.input.TextFieldValue r9 = r1.m807createTextFieldValueFDrldGo(r10, r2)
            r1.enterSelectionMode$foundation_release()
            kotlin.jvm.functions.Function1 r10 = r1.getOnValueChange$foundation_release()
            r10.invoke(r9)
            return
        L_0x007f:
            androidx.compose.foundation.text.selection.TextFieldSelectionManager r0 = r8.this$0
            androidx.compose.ui.text.input.TextFieldValue r0 = r0.getValue$foundation_release()
            java.lang.String r0 = r0.getText()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0092
            goto L_0x0093
        L_0x0092:
            r1 = 0
        L_0x0093:
            if (r1 == 0) goto L_0x0096
            return
        L_0x0096:
            androidx.compose.foundation.text.selection.TextFieldSelectionManager r0 = r8.this$0
            r0.enterSelectionMode$foundation_release()
            androidx.compose.foundation.text.selection.TextFieldSelectionManager r0 = r8.this$0
            androidx.compose.foundation.text.TextFieldState r0 = r0.getState$foundation_release()
            if (r0 != 0) goto L_0x00a4
            goto L_0x00cd
        L_0x00a4:
            androidx.compose.foundation.text.TextLayoutResultProxy r1 = r0.getLayoutResult()
            if (r1 != 0) goto L_0x00ab
            goto L_0x00cd
        L_0x00ab:
            androidx.compose.foundation.text.selection.TextFieldSelectionManager r0 = r8.this$0
            r4 = 0
            r5 = 2
            r6 = 0
            r2 = r9
            int r1 = androidx.compose.foundation.text.TextLayoutResultProxy.m728getOffsetForPosition3MmeM6k$default(r1, r2, r4, r5, r6)
            androidx.compose.ui.text.input.TextFieldValue r3 = r0.getValue$foundation_release()
            r6 = 0
            androidx.compose.foundation.text.selection.SelectionAdjustment$Companion r2 = androidx.compose.foundation.text.selection.SelectionAdjustment.Companion
            androidx.compose.foundation.text.selection.SelectionAdjustment r7 = r2.getWord()
            r2 = r0
            r4 = r1
            r5 = r1
            r2.updateSelection(r3, r4, r5, r6, r7)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.dragBeginOffsetInText = r1
        L_0x00cd:
            androidx.compose.foundation.text.selection.TextFieldSelectionManager r0 = r8.this$0
            r0.dragBeginPosition = r9
            androidx.compose.foundation.text.selection.TextFieldSelectionManager r9 = r8.this$0
            androidx.compose.ui.geometry.Offset$Companion r10 = androidx.compose.ui.geometry.Offset.Companion
            long r0 = r10.m1369getZeroF1C5BW0()
            r9.dragTotalDistance = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.TextFieldSelectionManager$touchSelectionObserver$1.m820onStartk4lQ0M(long):void");
    }

    /* renamed from: onDrag-k-4lQ0M  reason: not valid java name */
    public void m819onDragk4lQ0M(long j) {
        TextLayoutResultProxy layoutResult;
        if (!(this.this$0.getValue$foundation_release().getText().length() == 0)) {
            TextFieldSelectionManager textFieldSelectionManager = this.this$0;
            textFieldSelectionManager.dragTotalDistance = Offset.m1358plusMKHz9U(textFieldSelectionManager.dragTotalDistance, j);
            TextFieldState state$foundation_release = this.this$0.getState$foundation_release();
            if (!(state$foundation_release == null || (layoutResult = state$foundation_release.getLayoutResult()) == null)) {
                TextFieldSelectionManager textFieldSelectionManager2 = this.this$0;
                Integer access$getDragBeginOffsetInText$p = textFieldSelectionManager2.dragBeginOffsetInText;
                textFieldSelectionManager2.updateSelection(textFieldSelectionManager2.getValue$foundation_release(), access$getDragBeginOffsetInText$p == null ? layoutResult.m730getOffsetForPosition3MmeM6k(textFieldSelectionManager2.dragBeginPosition, false) : access$getDragBeginOffsetInText$p.intValue(), layoutResult.m730getOffsetForPosition3MmeM6k(Offset.m1358plusMKHz9U(textFieldSelectionManager2.dragBeginPosition, textFieldSelectionManager2.dragTotalDistance), false), false, SelectionAdjustment.Companion.getWord());
            }
            TextFieldState state$foundation_release2 = this.this$0.getState$foundation_release();
            if (state$foundation_release2 != null) {
                state$foundation_release2.setShowFloatingToolbar(false);
            }
        }
    }

    public void onStop() {
        TextFieldState state$foundation_release = this.this$0.getState$foundation_release();
        if (state$foundation_release != null) {
            state$foundation_release.setShowFloatingToolbar(true);
        }
        TextToolbar textToolbar = this.this$0.getTextToolbar();
        if ((textToolbar == null ? null : textToolbar.getStatus()) == TextToolbarStatus.Hidden) {
            this.this$0.showSelectionToolbar$foundation_release();
        }
        this.this$0.dragBeginOffsetInText = null;
    }
}
