package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001f\u0010\u0011\u001a\u00020\u00002\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0002\b\u0015J\u0006\u0010\u0016\u001a\u00020\u0000J\u0006\u0010\u0017\u001a\u00020\u0000J\u0014\u0010\u0018\u001a\u00020\u0019*\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0019H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\f¨\u0006\u001b"}, d2 = {"Landroidx/compose/foundation/text/selection/TextFieldPreparedSelection;", "Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection;", "currentValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "layoutResultProxy", "Landroidx/compose/foundation/text/TextLayoutResultProxy;", "state", "Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;", "(Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/ui/text/input/OffsetMapping;Landroidx/compose/foundation/text/TextLayoutResultProxy;Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;)V", "getCurrentValue", "()Landroidx/compose/ui/text/input/TextFieldValue;", "getLayoutResultProxy", "()Landroidx/compose/foundation/text/TextLayoutResultProxy;", "value", "getValue", "deleteIfSelectedOr", "or", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "moveCursorDownByPage", "moveCursorUpByPage", "jumpByPagesOffset", "", "pagesAmount", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextPreparedSelection.kt */
public final class TextFieldPreparedSelection extends BaseTextPreparedSelection<TextFieldPreparedSelection> {
    private final TextFieldValue currentValue;
    private final TextLayoutResultProxy layoutResultProxy;

    public final TextFieldValue getCurrentValue() {
        return this.currentValue;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TextFieldPreparedSelection(TextFieldValue textFieldValue, OffsetMapping offsetMapping, TextLayoutResultProxy textLayoutResultProxy, TextPreparedSelectionState textPreparedSelectionState, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(textFieldValue, (i & 2) != 0 ? OffsetMapping.Companion.getIdentity() : offsetMapping, textLayoutResultProxy, (i & 8) != 0 ? new TextPreparedSelectionState() : textPreparedSelectionState);
    }

    public final TextLayoutResultProxy getLayoutResultProxy() {
        return this.layoutResultProxy;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TextFieldPreparedSelection(androidx.compose.ui.text.input.TextFieldValue r10, androidx.compose.ui.text.input.OffsetMapping r11, androidx.compose.foundation.text.TextLayoutResultProxy r12, androidx.compose.foundation.text.selection.TextPreparedSelectionState r13) {
        /*
            r9 = this;
            java.lang.String r0 = "currentValue"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "offsetMapping"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            androidx.compose.ui.text.AnnotatedString r2 = r10.getAnnotatedString()
            long r3 = r10.m3688getSelectiond9O1mEE()
            if (r12 != 0) goto L_0x001c
            r0 = 0
            goto L_0x0020
        L_0x001c:
            androidx.compose.ui.text.TextLayoutResult r0 = r12.getValue()
        L_0x0020:
            r5 = r0
            r8 = 0
            r1 = r9
            r6 = r11
            r7 = r13
            r1.<init>(r2, r3, r5, r6, r7, r8)
            r9.currentValue = r10
            r9.layoutResultProxy = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.TextFieldPreparedSelection.<init>(androidx.compose.ui.text.input.TextFieldValue, androidx.compose.ui.text.input.OffsetMapping, androidx.compose.foundation.text.TextLayoutResultProxy, androidx.compose.foundation.text.selection.TextPreparedSelectionState):void");
    }

    public final TextFieldValue getValue() {
        return TextFieldValue.m3683copy3r_uNRQ$default(this.currentValue, getAnnotatedString(), m742getSelectiond9O1mEE(), (TextRange) null, 4, (Object) null);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: CodeShrinkVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x0015: MOVE  (r1v5 androidx.compose.foundation.text.selection.TextFieldPreparedSelection) = 
          (r4v0 'this' androidx.compose.foundation.text.selection.TextFieldPreparedSelection A[THIS])
        
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.visit(CodeShrinkVisitor.java:35)
        */
    public final androidx.compose.foundation.text.selection.TextFieldPreparedSelection moveCursorUpByPage() {
        /*
            r4 = this;
            r0 = r4
            androidx.compose.foundation.text.selection.BaseTextPreparedSelection r0 = (androidx.compose.foundation.text.selection.BaseTextPreparedSelection) r0
            java.lang.String r1 = r0.getText$foundation_release()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r1 = r1.length()
            if (r1 <= 0) goto L_0x0011
            r1 = 1
            goto L_0x0012
        L_0x0011:
            r1 = 0
        L_0x0012:
            if (r1 == 0) goto L_0x0026
            r1 = r4
            androidx.compose.foundation.text.selection.TextFieldPreparedSelection r1 = (androidx.compose.foundation.text.selection.TextFieldPreparedSelection) r1
            androidx.compose.foundation.text.TextLayoutResultProxy r2 = r1.getLayoutResultProxy()
            if (r2 != 0) goto L_0x001e
            goto L_0x0026
        L_0x001e:
            r3 = -1
            int r2 = r1.jumpByPagesOffset(r2, r3)
            r1.setCursor(r2)
        L_0x0026:
            androidx.compose.foundation.text.selection.TextFieldPreparedSelection r0 = (androidx.compose.foundation.text.selection.TextFieldPreparedSelection) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.TextFieldPreparedSelection.moveCursorUpByPage():androidx.compose.foundation.text.selection.TextFieldPreparedSelection");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: CodeShrinkVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x0016: MOVE  (r1v5 androidx.compose.foundation.text.selection.TextFieldPreparedSelection) = 
          (r4v0 'this' androidx.compose.foundation.text.selection.TextFieldPreparedSelection A[THIS])
        
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.visit(CodeShrinkVisitor.java:35)
        */
    public final androidx.compose.foundation.text.selection.TextFieldPreparedSelection moveCursorDownByPage() {
        /*
            r4 = this;
            r0 = r4
            androidx.compose.foundation.text.selection.BaseTextPreparedSelection r0 = (androidx.compose.foundation.text.selection.BaseTextPreparedSelection) r0
            java.lang.String r1 = r0.getText$foundation_release()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r1 = r1.length()
            r2 = 1
            if (r1 <= 0) goto L_0x0012
            r1 = 1
            goto L_0x0013
        L_0x0012:
            r1 = 0
        L_0x0013:
            if (r1 == 0) goto L_0x0026
            r1 = r4
            androidx.compose.foundation.text.selection.TextFieldPreparedSelection r1 = (androidx.compose.foundation.text.selection.TextFieldPreparedSelection) r1
            androidx.compose.foundation.text.TextLayoutResultProxy r3 = r1.getLayoutResultProxy()
            if (r3 != 0) goto L_0x001f
            goto L_0x0026
        L_0x001f:
            int r2 = r1.jumpByPagesOffset(r3, r2)
            r1.setCursor(r2)
        L_0x0026:
            androidx.compose.foundation.text.selection.TextFieldPreparedSelection r0 = (androidx.compose.foundation.text.selection.TextFieldPreparedSelection) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.TextFieldPreparedSelection.moveCursorDownByPage():androidx.compose.foundation.text.selection.TextFieldPreparedSelection");
    }

    private final int jumpByPagesOffset(TextLayoutResultProxy textLayoutResultProxy, int i) {
        LayoutCoordinates decorationBoxCoordinates;
        LayoutCoordinates innerTextFieldCoordinates = textLayoutResultProxy.getInnerTextFieldCoordinates();
        Rect rect = null;
        if (!(innerTextFieldCoordinates == null || (decorationBoxCoordinates = textLayoutResultProxy.getDecorationBoxCoordinates()) == null)) {
            rect = LayoutCoordinates.DefaultImpls.localBoundingBoxOf$default(decorationBoxCoordinates, innerTextFieldCoordinates, false, 2, (Object) null);
        }
        if (rect == null) {
            rect = Rect.Companion.getZero();
        }
        Rect cursorRect = textLayoutResultProxy.getValue().getCursorRect(getOffsetMapping().originalToTransformed(TextRange.m3566getEndimpl(this.currentValue.m3688getSelectiond9O1mEE())));
        return getOffsetMapping().transformedToOriginal(textLayoutResultProxy.getValue().m3554getOffsetForPositionk4lQ0M(OffsetKt.Offset(cursorRect.getLeft(), cursorRect.getTop() + (Size.m1419getHeightimpl(rect.m1386getSizeNHjbRc()) * ((float) i)))));
    }

    public final TextFieldPreparedSelection deleteIfSelectedOr(Function1<? super TextFieldPreparedSelection, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "or");
        BaseTextPreparedSelection baseTextPreparedSelection = this;
        baseTextPreparedSelection.getState().resetCachedX();
        if (baseTextPreparedSelection.getText$foundation_release().length() > 0) {
            TextFieldPreparedSelection textFieldPreparedSelection = this;
            if (TextRange.m3565getCollapsedimpl(textFieldPreparedSelection.m742getSelectiond9O1mEE())) {
                function1.invoke(textFieldPreparedSelection);
            } else {
                textFieldPreparedSelection.deleteSelected();
            }
        }
        return (TextFieldPreparedSelection) baseTextPreparedSelection;
    }
}
