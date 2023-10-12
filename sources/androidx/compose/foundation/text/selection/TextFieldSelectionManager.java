package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.HandleState;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.foundation.text.UndoManager;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextFieldValueKt;
import androidx.compose.ui.text.input.VisualTransformation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0017\u0010X\u001a\u0002052\b\b\u0002\u0010Y\u001a\u00020\u0013H\u0000¢\u0006\u0002\bZJ%\u0010[\u001a\u0002022\u0006\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020_H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b`\u0010aJ\r\u0010b\u001a\u00020GH\u0000¢\u0006\u0002\bcJ\r\u0010d\u001a\u000205H\u0000¢\u0006\u0002\beJ\u001f\u0010f\u001a\u0002052\n\b\u0002\u0010g\u001a\u0004\u0018\u00010\u000fH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\bhJ\r\u0010i\u001a\u000205H\u0000¢\u0006\u0002\bjJ\r\u0010k\u001a\u000205H\u0000¢\u0006\u0002\blJ\b\u0010m\u001a\u00020nH\u0002J \u0010o\u001a\u00020\u000f2\u0006\u0010p\u001a\u00020\u0013H\u0000ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\bq\u0010rJ\u0015\u0010s\u001a\u00020G2\u0006\u0010p\u001a\u00020\u0013H\u0000¢\u0006\u0002\btJ\r\u0010u\u001a\u000205H\u0000¢\u0006\u0002\bvJ\r\u0010w\u001a\u00020\u0013H\u0000¢\u0006\u0002\bxJ\r\u0010y\u001a\u000205H\u0000¢\u0006\u0002\bzJ\r\u0010{\u001a\u000205H\u0000¢\u0006\u0002\b|J\u0010\u0010}\u001a\u0002052\u0006\u0010~\u001a\u00020H\u0002J\u000f\u0010\u0001\u001a\u000205H\u0000¢\u0006\u0003\b\u0001J5\u0010\u0001\u001a\u0002052\u0006\u0010L\u001a\u0002022\u0007\u0010\u0001\u001a\u00020\f2\u0007\u0010\u0001\u001a\u00020\f2\u0006\u0010p\u001a\u00020\u00132\b\u0010\u0001\u001a\u00030\u0001H\u0002R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0019\u0010\u000e\u001a\u00020\u000fX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0010R\u0019\u0010\u0011\u001a\u00020\u000fX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0010R+\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00138F@FX\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020(X\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020,X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u000e\u00101\u001a\u000202X\u000e¢\u0006\u0002\n\u0000R&\u00103\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020504X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001c\u0010:\u001a\u0004\u0018\u00010;X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001c\u0010@\u001a\u0004\u0018\u00010AX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u0014\u0010F\u001a\u00020GX\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR+\u0010L\u001a\u0002022\u0006\u0010\u0012\u001a\u0002028@@@X\u0002¢\u0006\u0012\n\u0004\bQ\u0010\u001a\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u001a\u0010R\u001a\u00020SX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010U\"\u0004\bV\u0010W\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "", "undoManager", "Landroidx/compose/foundation/text/UndoManager;", "(Landroidx/compose/foundation/text/UndoManager;)V", "clipboardManager", "Landroidx/compose/ui/platform/ClipboardManager;", "getClipboardManager$foundation_release", "()Landroidx/compose/ui/platform/ClipboardManager;", "setClipboardManager$foundation_release", "(Landroidx/compose/ui/platform/ClipboardManager;)V", "dragBeginOffsetInText", "", "Ljava/lang/Integer;", "dragBeginPosition", "Landroidx/compose/ui/geometry/Offset;", "J", "dragTotalDistance", "<set-?>", "", "editable", "getEditable", "()Z", "setEditable", "(Z)V", "editable$delegate", "Landroidx/compose/runtime/MutableState;", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "getFocusRequester", "()Landroidx/compose/ui/focus/FocusRequester;", "setFocusRequester", "(Landroidx/compose/ui/focus/FocusRequester;)V", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "getHapticFeedBack", "()Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "setHapticFeedBack", "(Landroidx/compose/ui/hapticfeedback/HapticFeedback;)V", "mouseSelectionObserver", "Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "getMouseSelectionObserver$foundation_release", "()Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "getOffsetMapping$foundation_release", "()Landroidx/compose/ui/text/input/OffsetMapping;", "setOffsetMapping$foundation_release", "(Landroidx/compose/ui/text/input/OffsetMapping;)V", "oldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "", "getOnValueChange$foundation_release", "()Lkotlin/jvm/functions/Function1;", "setOnValueChange$foundation_release", "(Lkotlin/jvm/functions/Function1;)V", "state", "Landroidx/compose/foundation/text/TextFieldState;", "getState$foundation_release", "()Landroidx/compose/foundation/text/TextFieldState;", "setState$foundation_release", "(Landroidx/compose/foundation/text/TextFieldState;)V", "textToolbar", "Landroidx/compose/ui/platform/TextToolbar;", "getTextToolbar", "()Landroidx/compose/ui/platform/TextToolbar;", "setTextToolbar", "(Landroidx/compose/ui/platform/TextToolbar;)V", "touchSelectionObserver", "Landroidx/compose/foundation/text/TextDragObserver;", "getTouchSelectionObserver$foundation_release", "()Landroidx/compose/foundation/text/TextDragObserver;", "getUndoManager", "()Landroidx/compose/foundation/text/UndoManager;", "value", "getValue$foundation_release", "()Landroidx/compose/ui/text/input/TextFieldValue;", "setValue$foundation_release", "(Landroidx/compose/ui/text/input/TextFieldValue;)V", "value$delegate", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "getVisualTransformation$foundation_release", "()Landroidx/compose/ui/text/input/VisualTransformation;", "setVisualTransformation$foundation_release", "(Landroidx/compose/ui/text/input/VisualTransformation;)V", "copy", "cancelSelection", "copy$foundation_release", "createTextFieldValue", "annotatedString", "Landroidx/compose/ui/text/AnnotatedString;", "selection", "Landroidx/compose/ui/text/TextRange;", "createTextFieldValue-FDrldGo", "(Landroidx/compose/ui/text/AnnotatedString;J)Landroidx/compose/ui/text/input/TextFieldValue;", "cursorDragObserver", "cursorDragObserver$foundation_release", "cut", "cut$foundation_release", "deselect", "position", "deselect-_kEHs6E$foundation_release", "enterSelectionMode", "enterSelectionMode$foundation_release", "exitSelectionMode", "exitSelectionMode$foundation_release", "getContentRect", "Landroidx/compose/ui/geometry/Rect;", "getHandlePosition", "isStartHandle", "getHandlePosition-tuRUvjQ$foundation_release", "(Z)J", "handleDragObserver", "handleDragObserver$foundation_release", "hideSelectionToolbar", "hideSelectionToolbar$foundation_release", "isTextChanged", "isTextChanged$foundation_release", "paste", "paste$foundation_release", "selectAll", "selectAll$foundation_release", "setHandleState", "handleState", "Landroidx/compose/foundation/text/HandleState;", "showSelectionToolbar", "showSelectionToolbar$foundation_release", "updateSelection", "transformedStartOffset", "transformedEndOffset", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextFieldSelectionManager.kt */
public final class TextFieldSelectionManager {
    private ClipboardManager clipboardManager;
    /* access modifiers changed from: private */
    public Integer dragBeginOffsetInText;
    /* access modifiers changed from: private */
    public long dragBeginPosition;
    /* access modifiers changed from: private */
    public long dragTotalDistance;
    private final MutableState editable$delegate;
    private FocusRequester focusRequester;
    private HapticFeedback hapticFeedBack;
    private final MouseSelectionObserver mouseSelectionObserver;
    private OffsetMapping offsetMapping;
    private TextFieldValue oldValue;
    private Function1<? super TextFieldValue, Unit> onValueChange;
    private TextFieldState state;
    private TextToolbar textToolbar;
    private final TextDragObserver touchSelectionObserver;
    private final UndoManager undoManager;
    private final MutableState value$delegate;
    private VisualTransformation visualTransformation;

    public TextFieldSelectionManager() {
        this((UndoManager) null, 1, (DefaultConstructorMarker) null);
    }

    public TextFieldSelectionManager(UndoManager undoManager2) {
        this.undoManager = undoManager2;
        this.offsetMapping = OffsetMapping.Companion.getIdentity();
        this.onValueChange = TextFieldSelectionManager$onValueChange$1.INSTANCE;
        this.value$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue((String) null, 0, (TextRange) null, 7, (DefaultConstructorMarker) null), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.visualTransformation = VisualTransformation.Companion.getNone();
        this.editable$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.dragBeginPosition = Offset.Companion.m1369getZeroF1C5BW0();
        this.dragTotalDistance = Offset.Companion.m1369getZeroF1C5BW0();
        this.oldValue = new TextFieldValue((String) null, 0, (TextRange) null, 7, (DefaultConstructorMarker) null);
        this.touchSelectionObserver = new TextFieldSelectionManager$touchSelectionObserver$1(this);
        this.mouseSelectionObserver = new TextFieldSelectionManager$mouseSelectionObserver$1(this);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TextFieldSelectionManager(UndoManager undoManager2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : undoManager2);
    }

    public final UndoManager getUndoManager() {
        return this.undoManager;
    }

    public final OffsetMapping getOffsetMapping$foundation_release() {
        return this.offsetMapping;
    }

    public final void setOffsetMapping$foundation_release(OffsetMapping offsetMapping2) {
        Intrinsics.checkNotNullParameter(offsetMapping2, "<set-?>");
        this.offsetMapping = offsetMapping2;
    }

    public final Function1<TextFieldValue, Unit> getOnValueChange$foundation_release() {
        return this.onValueChange;
    }

    public final void setOnValueChange$foundation_release(Function1<? super TextFieldValue, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onValueChange = function1;
    }

    public final TextFieldState getState$foundation_release() {
        return this.state;
    }

    public final void setState$foundation_release(TextFieldState textFieldState) {
        this.state = textFieldState;
    }

    public final TextFieldValue getValue$foundation_release() {
        return (TextFieldValue) this.value$delegate.getValue();
    }

    public final void setValue$foundation_release(TextFieldValue textFieldValue) {
        Intrinsics.checkNotNullParameter(textFieldValue, "<set-?>");
        this.value$delegate.setValue(textFieldValue);
    }

    public final VisualTransformation getVisualTransformation$foundation_release() {
        return this.visualTransformation;
    }

    public final void setVisualTransformation$foundation_release(VisualTransformation visualTransformation2) {
        Intrinsics.checkNotNullParameter(visualTransformation2, "<set-?>");
        this.visualTransformation = visualTransformation2;
    }

    public final ClipboardManager getClipboardManager$foundation_release() {
        return this.clipboardManager;
    }

    public final void setClipboardManager$foundation_release(ClipboardManager clipboardManager2) {
        this.clipboardManager = clipboardManager2;
    }

    public final TextToolbar getTextToolbar() {
        return this.textToolbar;
    }

    public final void setTextToolbar(TextToolbar textToolbar2) {
        this.textToolbar = textToolbar2;
    }

    public final HapticFeedback getHapticFeedBack() {
        return this.hapticFeedBack;
    }

    public final void setHapticFeedBack(HapticFeedback hapticFeedback) {
        this.hapticFeedBack = hapticFeedback;
    }

    public final FocusRequester getFocusRequester() {
        return this.focusRequester;
    }

    public final void setFocusRequester(FocusRequester focusRequester2) {
        this.focusRequester = focusRequester2;
    }

    public final boolean getEditable() {
        return ((Boolean) this.editable$delegate.getValue()).booleanValue();
    }

    public final void setEditable(boolean z) {
        this.editable$delegate.setValue(Boolean.valueOf(z));
    }

    public final TextDragObserver getTouchSelectionObserver$foundation_release() {
        return this.touchSelectionObserver;
    }

    public final MouseSelectionObserver getMouseSelectionObserver$foundation_release() {
        return this.mouseSelectionObserver;
    }

    public final TextDragObserver handleDragObserver$foundation_release(boolean z) {
        return new TextFieldSelectionManager$handleDragObserver$1(this, z);
    }

    public final TextDragObserver cursorDragObserver$foundation_release() {
        return new TextFieldSelectionManager$cursorDragObserver$1(this);
    }

    public final void enterSelectionMode$foundation_release() {
        FocusRequester focusRequester2;
        TextFieldState textFieldState = this.state;
        boolean z = false;
        if (textFieldState != null && !textFieldState.getHasFocus()) {
            z = true;
        }
        if (z && (focusRequester2 = this.focusRequester) != null) {
            focusRequester2.requestFocus();
        }
        this.oldValue = getValue$foundation_release();
        TextFieldState textFieldState2 = this.state;
        if (textFieldState2 != null) {
            textFieldState2.setShowFloatingToolbar(true);
        }
        setHandleState(HandleState.Selection);
    }

    public final void exitSelectionMode$foundation_release() {
        TextFieldState textFieldState = this.state;
        if (textFieldState != null) {
            textFieldState.setShowFloatingToolbar(false);
        }
        setHandleState(HandleState.None);
    }

    /* renamed from: deselect-_kEHs6E$foundation_release$default  reason: not valid java name */
    public static /* synthetic */ void m808deselect_kEHs6E$foundation_release$default(TextFieldSelectionManager textFieldSelectionManager, Offset offset, int i, Object obj) {
        if ((i & 1) != 0) {
            offset = null;
        }
        textFieldSelectionManager.m809deselect_kEHs6E$foundation_release(offset);
    }

    /* renamed from: deselect-_kEHs6E$foundation_release  reason: not valid java name */
    public final void m809deselect_kEHs6E$foundation_release(Offset offset) {
        HandleState handleState;
        int i;
        if (!TextRange.m3565getCollapsedimpl(getValue$foundation_release().m3688getSelectiond9O1mEE())) {
            TextFieldState textFieldState = this.state;
            TextLayoutResultProxy layoutResult = textFieldState == null ? null : textFieldState.getLayoutResult();
            if (offset == null || layoutResult == null) {
                i = TextRange.m3568getMaximpl(getValue$foundation_release().m3688getSelectiond9O1mEE());
            } else {
                i = this.offsetMapping.transformedToOriginal(TextLayoutResultProxy.m728getOffsetForPosition3MmeM6k$default(layoutResult, offset.m1363unboximpl(), false, 2, (Object) null));
            }
            this.onValueChange.invoke(TextFieldValue.m3683copy3r_uNRQ$default(getValue$foundation_release(), (AnnotatedString) null, TextRangeKt.TextRange(i), (TextRange) null, 5, (Object) null));
        }
        if (offset != null) {
            if (getValue$foundation_release().getText().length() > 0) {
                handleState = HandleState.Cursor;
                setHandleState(handleState);
                hideSelectionToolbar$foundation_release();
            }
        }
        handleState = HandleState.None;
        setHandleState(handleState);
        hideSelectionToolbar$foundation_release();
    }

    public static /* synthetic */ void copy$foundation_release$default(TextFieldSelectionManager textFieldSelectionManager, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        textFieldSelectionManager.copy$foundation_release(z);
    }

    public final void copy$foundation_release(boolean z) {
        if (!TextRange.m3565getCollapsedimpl(getValue$foundation_release().m3688getSelectiond9O1mEE())) {
            ClipboardManager clipboardManager2 = this.clipboardManager;
            if (clipboardManager2 != null) {
                clipboardManager2.setText(TextFieldValueKt.getSelectedText(getValue$foundation_release()));
            }
            if (z) {
                int r4 = TextRange.m3568getMaximpl(getValue$foundation_release().m3688getSelectiond9O1mEE());
                this.onValueChange.invoke(m807createTextFieldValueFDrldGo(getValue$foundation_release().getAnnotatedString(), TextRangeKt.TextRange(r4, r4)));
                setHandleState(HandleState.None);
            }
        }
    }

    public final void paste$foundation_release() {
        ClipboardManager clipboardManager2 = this.clipboardManager;
        AnnotatedString text = clipboardManager2 == null ? null : clipboardManager2.getText();
        if (text != null) {
            AnnotatedString plus = TextFieldValueKt.getTextBeforeSelection(getValue$foundation_release(), getValue$foundation_release().getText().length()).plus(text).plus(TextFieldValueKt.getTextAfterSelection(getValue$foundation_release(), getValue$foundation_release().getText().length()));
            int r2 = TextRange.m3569getMinimpl(getValue$foundation_release().m3688getSelectiond9O1mEE()) + text.length();
            this.onValueChange.invoke(m807createTextFieldValueFDrldGo(plus, TextRangeKt.TextRange(r2, r2)));
            setHandleState(HandleState.None);
            UndoManager undoManager2 = this.undoManager;
            if (undoManager2 != null) {
                undoManager2.forceNextSnapshot();
            }
        }
    }

    public final void cut$foundation_release() {
        if (!TextRange.m3565getCollapsedimpl(getValue$foundation_release().m3688getSelectiond9O1mEE())) {
            ClipboardManager clipboardManager2 = this.clipboardManager;
            if (clipboardManager2 != null) {
                clipboardManager2.setText(TextFieldValueKt.getSelectedText(getValue$foundation_release()));
            }
            AnnotatedString plus = TextFieldValueKt.getTextBeforeSelection(getValue$foundation_release(), getValue$foundation_release().getText().length()).plus(TextFieldValueKt.getTextAfterSelection(getValue$foundation_release(), getValue$foundation_release().getText().length()));
            int r1 = TextRange.m3569getMinimpl(getValue$foundation_release().m3688getSelectiond9O1mEE());
            this.onValueChange.invoke(m807createTextFieldValueFDrldGo(plus, TextRangeKt.TextRange(r1, r1)));
            setHandleState(HandleState.None);
            UndoManager undoManager2 = this.undoManager;
            if (undoManager2 != null) {
                undoManager2.forceNextSnapshot();
            }
        }
    }

    public final void selectAll$foundation_release() {
        setHandleState(HandleState.None);
        TextFieldValue r0 = m807createTextFieldValueFDrldGo(getValue$foundation_release().getAnnotatedString(), TextRangeKt.TextRange(0, getValue$foundation_release().getText().length()));
        this.onValueChange.invoke(r0);
        this.oldValue = TextFieldValue.m3683copy3r_uNRQ$default(this.oldValue, (AnnotatedString) null, r0.m3688getSelectiond9O1mEE(), (TextRange) null, 5, (Object) null);
        hideSelectionToolbar$foundation_release();
        TextFieldState textFieldState = this.state;
        if (textFieldState != null) {
            textFieldState.setShowFloatingToolbar(true);
        }
        showSelectionToolbar$foundation_release();
    }

    /* renamed from: getHandlePosition-tuRUvjQ$foundation_release  reason: not valid java name */
    public final long m810getHandlePositiontuRUvjQ$foundation_release(boolean z) {
        long r0 = getValue$foundation_release().m3688getSelectiond9O1mEE();
        int r02 = z ? TextRange.m3571getStartimpl(r0) : TextRange.m3566getEndimpl(r0);
        TextFieldState textFieldState = this.state;
        TextLayoutResultProxy layoutResult = textFieldState == null ? null : textFieldState.getLayoutResult();
        Intrinsics.checkNotNull(layoutResult);
        return TextSelectionDelegateKt.getSelectionHandleCoordinates(layoutResult.getValue(), this.offsetMapping.originalToTransformed(r02), z, TextRange.m3570getReversedimpl(getValue$foundation_release().m3688getSelectiond9O1mEE()));
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void showSelectionToolbar$foundation_release() {
        /*
            r9 = this;
            androidx.compose.ui.text.input.VisualTransformation r0 = r9.visualTransformation
            boolean r0 = r0 instanceof androidx.compose.ui.text.input.PasswordVisualTransformation
            androidx.compose.ui.text.input.TextFieldValue r1 = r9.getValue$foundation_release()
            long r1 = r1.m3688getSelectiond9O1mEE()
            boolean r1 = androidx.compose.ui.text.TextRange.m3565getCollapsedimpl(r1)
            r2 = 0
            if (r1 != 0) goto L_0x001e
            if (r0 != 0) goto L_0x001e
            androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$copy$1 r1 = new androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$copy$1
            r1.<init>(r9)
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            r5 = r1
            goto L_0x001f
        L_0x001e:
            r5 = r2
        L_0x001f:
            androidx.compose.ui.text.input.TextFieldValue r1 = r9.getValue$foundation_release()
            long r3 = r1.m3688getSelectiond9O1mEE()
            boolean r1 = androidx.compose.ui.text.TextRange.m3565getCollapsedimpl(r3)
            if (r1 != 0) goto L_0x003e
            boolean r1 = r9.getEditable()
            if (r1 == 0) goto L_0x003e
            if (r0 != 0) goto L_0x003e
            androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$cut$1 r0 = new androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$cut$1
            r0.<init>(r9)
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            r7 = r0
            goto L_0x003f
        L_0x003e:
            r7 = r2
        L_0x003f:
            boolean r0 = r9.getEditable()
            if (r0 == 0) goto L_0x005a
            androidx.compose.ui.platform.ClipboardManager r0 = r9.clipboardManager
            if (r0 != 0) goto L_0x004b
            r0 = r2
            goto L_0x004f
        L_0x004b:
            androidx.compose.ui.text.AnnotatedString r0 = r0.getText()
        L_0x004f:
            if (r0 == 0) goto L_0x005a
            androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$paste$1 r0 = new androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$paste$1
            r0.<init>(r9)
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            r6 = r0
            goto L_0x005b
        L_0x005a:
            r6 = r2
        L_0x005b:
            androidx.compose.ui.text.input.TextFieldValue r0 = r9.getValue$foundation_release()
            long r0 = r0.m3688getSelectiond9O1mEE()
            int r0 = androidx.compose.ui.text.TextRange.m3567getLengthimpl(r0)
            androidx.compose.ui.text.input.TextFieldValue r1 = r9.getValue$foundation_release()
            java.lang.String r1 = r1.getText()
            int r1 = r1.length()
            if (r0 == r1) goto L_0x0093
            androidx.compose.ui.text.input.TextFieldValue r0 = r9.oldValue
            long r0 = r0.m3688getSelectiond9O1mEE()
            int r0 = androidx.compose.ui.text.TextRange.m3567getLengthimpl(r0)
            androidx.compose.ui.text.input.TextFieldValue r1 = r9.oldValue
            java.lang.String r1 = r1.getText()
            int r1 = r1.length()
            if (r0 == r1) goto L_0x0093
            androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$selectAll$1 r0 = new androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$selectAll$1
            r0.<init>(r9)
            r2 = r0
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
        L_0x0093:
            r8 = r2
            androidx.compose.ui.platform.TextToolbar r3 = r9.textToolbar
            if (r3 != 0) goto L_0x0099
            goto L_0x00a0
        L_0x0099:
            androidx.compose.ui.geometry.Rect r4 = r9.getContentRect()
            r3.showMenu(r4, r5, r6, r7, r8)
        L_0x00a0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.TextFieldSelectionManager.showSelectionToolbar$foundation_release():void");
    }

    public final void hideSelectionToolbar$foundation_release() {
        TextToolbar textToolbar2;
        TextToolbar textToolbar3 = this.textToolbar;
        if ((textToolbar3 == null ? null : textToolbar3.getStatus()) == TextToolbarStatus.Shown && (textToolbar2 = this.textToolbar) != null) {
            textToolbar2.hide();
        }
    }

    public final boolean isTextChanged$foundation_release() {
        return !Intrinsics.areEqual((Object) this.oldValue.getText(), (Object) getValue$foundation_release().getText());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0015, code lost:
        r1 = r1.getLayoutCoordinates();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final androidx.compose.ui.geometry.Rect getContentRect() {
        /*
            r13 = this;
            androidx.compose.foundation.text.TextFieldState r0 = r13.state
            if (r0 != 0) goto L_0x000b
            androidx.compose.ui.geometry.Rect$Companion r0 = androidx.compose.ui.geometry.Rect.Companion
            androidx.compose.ui.geometry.Rect r0 = r0.getZero()
            return r0
        L_0x000b:
            androidx.compose.foundation.text.TextFieldState r1 = r13.getState$foundation_release()
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x0015
        L_0x0013:
            r1 = r3
            goto L_0x0028
        L_0x0015:
            androidx.compose.ui.layout.LayoutCoordinates r1 = r1.getLayoutCoordinates()
            if (r1 != 0) goto L_0x001c
            goto L_0x0013
        L_0x001c:
            long r4 = r13.m810getHandlePositiontuRUvjQ$foundation_release(r2)
            long r4 = r1.m3142localToRootMKHz9U(r4)
            androidx.compose.ui.geometry.Offset r1 = androidx.compose.ui.geometry.Offset.m1342boximpl(r4)
        L_0x0028:
            if (r1 != 0) goto L_0x0031
            androidx.compose.ui.geometry.Offset$Companion r1 = androidx.compose.ui.geometry.Offset.Companion
            long r4 = r1.m1369getZeroF1C5BW0()
            goto L_0x0035
        L_0x0031:
            long r4 = r1.m1363unboximpl()
        L_0x0035:
            androidx.compose.foundation.text.TextFieldState r1 = r13.getState$foundation_release()
            r6 = 0
            if (r1 != 0) goto L_0x003d
            goto L_0x0050
        L_0x003d:
            androidx.compose.ui.layout.LayoutCoordinates r1 = r1.getLayoutCoordinates()
            if (r1 != 0) goto L_0x0044
            goto L_0x0050
        L_0x0044:
            long r7 = r13.m810getHandlePositiontuRUvjQ$foundation_release(r6)
            long r7 = r1.m3142localToRootMKHz9U(r7)
            androidx.compose.ui.geometry.Offset r3 = androidx.compose.ui.geometry.Offset.m1342boximpl(r7)
        L_0x0050:
            if (r3 != 0) goto L_0x0059
            androidx.compose.ui.geometry.Offset$Companion r1 = androidx.compose.ui.geometry.Offset.Companion
            long r7 = r1.m1369getZeroF1C5BW0()
            goto L_0x005d
        L_0x0059:
            long r7 = r3.m1363unboximpl()
        L_0x005d:
            androidx.compose.foundation.text.TextFieldState r1 = r13.getState$foundation_release()
            r3 = 0
            if (r1 != 0) goto L_0x0066
        L_0x0064:
            r1 = 0
            goto L_0x00b4
        L_0x0066:
            androidx.compose.ui.layout.LayoutCoordinates r1 = r1.getLayoutCoordinates()
            if (r1 != 0) goto L_0x006d
            goto L_0x0064
        L_0x006d:
            androidx.compose.foundation.text.TextLayoutResultProxy r9 = r0.getLayoutResult()
            if (r9 != 0) goto L_0x0075
        L_0x0073:
            r9 = 0
            goto L_0x00a8
        L_0x0075:
            androidx.compose.ui.text.TextLayoutResult r9 = r9.getValue()
            if (r9 != 0) goto L_0x007c
            goto L_0x0073
        L_0x007c:
            androidx.compose.ui.text.input.TextFieldValue r10 = r13.getValue$foundation_release()
            long r10 = r10.m3688getSelectiond9O1mEE()
            int r10 = androidx.compose.ui.text.TextRange.m3571getStartimpl(r10)
            androidx.compose.ui.text.input.TextFieldValue r11 = r13.getValue$foundation_release()
            java.lang.String r11 = r11.getText()
            int r11 = r11.length()
            int r11 = r11 - r2
            int r11 = java.lang.Math.max(r6, r11)
            int r10 = kotlin.ranges.RangesKt.coerceIn((int) r10, (int) r6, (int) r11)
            androidx.compose.ui.geometry.Rect r9 = r9.getCursorRect(r10)
            if (r9 != 0) goto L_0x00a4
            goto L_0x0073
        L_0x00a4:
            float r9 = r9.getTop()
        L_0x00a8:
            long r9 = androidx.compose.ui.geometry.OffsetKt.Offset(r3, r9)
            long r9 = r1.m3142localToRootMKHz9U(r9)
            float r1 = androidx.compose.ui.geometry.Offset.m1354getYimpl(r9)
        L_0x00b4:
            androidx.compose.foundation.text.TextFieldState r9 = r13.getState$foundation_release()
            if (r9 != 0) goto L_0x00bb
            goto L_0x0109
        L_0x00bb:
            androidx.compose.ui.layout.LayoutCoordinates r9 = r9.getLayoutCoordinates()
            if (r9 != 0) goto L_0x00c2
            goto L_0x0109
        L_0x00c2:
            androidx.compose.foundation.text.TextLayoutResultProxy r10 = r0.getLayoutResult()
            if (r10 != 0) goto L_0x00ca
        L_0x00c8:
            r2 = 0
            goto L_0x00fd
        L_0x00ca:
            androidx.compose.ui.text.TextLayoutResult r10 = r10.getValue()
            if (r10 != 0) goto L_0x00d1
            goto L_0x00c8
        L_0x00d1:
            androidx.compose.ui.text.input.TextFieldValue r11 = r13.getValue$foundation_release()
            long r11 = r11.m3688getSelectiond9O1mEE()
            int r11 = androidx.compose.ui.text.TextRange.m3566getEndimpl(r11)
            androidx.compose.ui.text.input.TextFieldValue r12 = r13.getValue$foundation_release()
            java.lang.String r12 = r12.getText()
            int r12 = r12.length()
            int r12 = r12 - r2
            int r2 = java.lang.Math.max(r6, r12)
            int r2 = kotlin.ranges.RangesKt.coerceIn((int) r11, (int) r6, (int) r2)
            androidx.compose.ui.geometry.Rect r2 = r10.getCursorRect(r2)
            if (r2 != 0) goto L_0x00f9
            goto L_0x00c8
        L_0x00f9:
            float r2 = r2.getTop()
        L_0x00fd:
            long r2 = androidx.compose.ui.geometry.OffsetKt.Offset(r3, r2)
            long r2 = r9.m3142localToRootMKHz9U(r2)
            float r3 = androidx.compose.ui.geometry.Offset.m1354getYimpl(r2)
        L_0x0109:
            float r2 = androidx.compose.ui.geometry.Offset.m1353getXimpl(r4)
            float r6 = androidx.compose.ui.geometry.Offset.m1353getXimpl(r7)
            float r2 = java.lang.Math.min(r2, r6)
            float r6 = androidx.compose.ui.geometry.Offset.m1353getXimpl(r4)
            float r9 = androidx.compose.ui.geometry.Offset.m1353getXimpl(r7)
            float r6 = java.lang.Math.max(r6, r9)
            float r1 = java.lang.Math.min(r1, r3)
            float r3 = androidx.compose.ui.geometry.Offset.m1354getYimpl(r4)
            float r4 = androidx.compose.ui.geometry.Offset.m1354getYimpl(r7)
            float r3 = java.lang.Math.max(r3, r4)
            r4 = 25
            float r4 = (float) r4
            float r4 = androidx.compose.ui.unit.Dp.m3859constructorimpl(r4)
            androidx.compose.foundation.text.TextDelegate r0 = r0.getTextDelegate()
            androidx.compose.ui.unit.Density r0 = r0.getDensity()
            float r0 = r0.getDensity()
            float r4 = r4 * r0
            float r3 = r3 + r4
            androidx.compose.ui.geometry.Rect r0 = new androidx.compose.ui.geometry.Rect
            r0.<init>(r2, r1, r6, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.TextFieldSelectionManager.getContentRect():androidx.compose.ui.geometry.Rect");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0027, code lost:
        r2 = r2.getLayoutResult();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateSelection(androidx.compose.ui.text.input.TextFieldValue r11, int r12, int r13, boolean r14, androidx.compose.foundation.text.selection.SelectionAdjustment r15) {
        /*
            r10 = this;
            androidx.compose.ui.text.input.OffsetMapping r0 = r10.offsetMapping
            long r1 = r11.m3688getSelectiond9O1mEE()
            int r1 = androidx.compose.ui.text.TextRange.m3571getStartimpl(r1)
            int r0 = r0.originalToTransformed(r1)
            androidx.compose.ui.text.input.OffsetMapping r1 = r10.offsetMapping
            long r2 = r11.m3688getSelectiond9O1mEE()
            int r2 = androidx.compose.ui.text.TextRange.m3566getEndimpl(r2)
            int r1 = r1.originalToTransformed(r2)
            long r0 = androidx.compose.ui.text.TextRangeKt.TextRange(r0, r1)
            androidx.compose.foundation.text.TextFieldState r2 = r10.state
            r3 = 0
            if (r2 != 0) goto L_0x0027
        L_0x0025:
            r4 = r3
            goto L_0x0033
        L_0x0027:
            androidx.compose.foundation.text.TextLayoutResultProxy r2 = r2.getLayoutResult()
            if (r2 != 0) goto L_0x002e
            goto L_0x0025
        L_0x002e:
            androidx.compose.ui.text.TextLayoutResult r2 = r2.getValue()
            r4 = r2
        L_0x0033:
            boolean r2 = androidx.compose.ui.text.TextRange.m3565getCollapsedimpl(r0)
            if (r2 == 0) goto L_0x003a
            goto L_0x003e
        L_0x003a:
            androidx.compose.ui.text.TextRange r3 = androidx.compose.ui.text.TextRange.m3559boximpl(r0)
        L_0x003e:
            r7 = r3
            r5 = r12
            r6 = r13
            r8 = r14
            r9 = r15
            long r12 = androidx.compose.foundation.text.selection.TextFieldSelectionDelegateKt.m805getTextFieldSelectionbb3KNj8(r4, r5, r6, r7, r8, r9)
            androidx.compose.ui.text.input.OffsetMapping r14 = r10.offsetMapping
            int r15 = androidx.compose.ui.text.TextRange.m3571getStartimpl(r12)
            int r14 = r14.transformedToOriginal(r15)
            androidx.compose.ui.text.input.OffsetMapping r15 = r10.offsetMapping
            int r12 = androidx.compose.ui.text.TextRange.m3566getEndimpl(r12)
            int r12 = r15.transformedToOriginal(r12)
            long r12 = androidx.compose.ui.text.TextRangeKt.TextRange(r14, r12)
            long r14 = r11.m3688getSelectiond9O1mEE()
            boolean r14 = androidx.compose.ui.text.TextRange.m3564equalsimpl0(r12, r14)
            if (r14 == 0) goto L_0x006a
            return
        L_0x006a:
            androidx.compose.ui.hapticfeedback.HapticFeedback r14 = r10.hapticFeedBack
            if (r14 != 0) goto L_0x006f
            goto L_0x0078
        L_0x006f:
            androidx.compose.ui.hapticfeedback.HapticFeedbackType$Companion r15 = androidx.compose.ui.hapticfeedback.HapticFeedbackType.Companion
            int r15 = r15.m2239getTextHandleMove5zf0vsI()
            r14.m2230performHapticFeedbackCdsT49E(r15)
        L_0x0078:
            androidx.compose.ui.text.AnnotatedString r11 = r11.getAnnotatedString()
            androidx.compose.ui.text.input.TextFieldValue r11 = r10.m807createTextFieldValueFDrldGo(r11, r12)
            kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r12 = r10.onValueChange
            r12.invoke(r11)
            androidx.compose.foundation.text.TextFieldState r11 = r10.state
            if (r11 != 0) goto L_0x008a
            goto L_0x0092
        L_0x008a:
            r12 = 1
            boolean r12 = androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(r10, r12)
            r11.setShowSelectionHandleStart(r12)
        L_0x0092:
            androidx.compose.foundation.text.TextFieldState r11 = r10.state
            if (r11 != 0) goto L_0x0097
            goto L_0x009f
        L_0x0097:
            r12 = 0
            boolean r12 = androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(r10, r12)
            r11.setShowSelectionHandleEnd(r12)
        L_0x009f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.TextFieldSelectionManager.updateSelection(androidx.compose.ui.text.input.TextFieldValue, int, int, boolean, androidx.compose.foundation.text.selection.SelectionAdjustment):void");
    }

    private final void setHandleState(HandleState handleState) {
        TextFieldState textFieldState = this.state;
        if (textFieldState != null) {
            textFieldState.setHandleState(handleState);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: createTextFieldValue-FDrldGo  reason: not valid java name */
    public final TextFieldValue m807createTextFieldValueFDrldGo(AnnotatedString annotatedString, long j) {
        return new TextFieldValue(annotatedString, j, (TextRange) null, 4, (DefaultConstructorMarker) null);
    }
}
