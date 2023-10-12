package androidx.compose.foundation.text;

import android.view.KeyEvent;
import androidx.compose.foundation.text.selection.TextFieldPreparedSelection;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextPreparedSelectionState;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.FinishComposingTextCommand;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import com.braintreepayments.api.models.PostalAddressParser;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J!\u0010#\u001a\u00020$2\u0017\u0010%\u001a\u0013\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020$0&¢\u0006\u0002\b(H\u0002J\u001b\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020+ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010-J\u001f\u0010.\u001a\u0004\u0018\u00010/2\u0006\u0010*\u001a\u00020+H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u00101J\f\u00102\u001a\u00020$*\u000203H\u0002R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00064"}, d2 = {"Landroidx/compose/foundation/text/TextFieldKeyInput;", "", "state", "Landroidx/compose/foundation/text/TextFieldState;", "selectionManager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "editable", "", "singleLine", "preparedSelectionState", "Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "undoManager", "Landroidx/compose/foundation/text/UndoManager;", "keyMapping", "Landroidx/compose/foundation/text/KeyMapping;", "(Landroidx/compose/foundation/text/TextFieldState;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Landroidx/compose/ui/text/input/TextFieldValue;ZZLandroidx/compose/foundation/text/selection/TextPreparedSelectionState;Landroidx/compose/ui/text/input/OffsetMapping;Landroidx/compose/foundation/text/UndoManager;Landroidx/compose/foundation/text/KeyMapping;)V", "getEditable", "()Z", "getOffsetMapping", "()Landroidx/compose/ui/text/input/OffsetMapping;", "getPreparedSelectionState", "()Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;", "getSelectionManager", "()Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "getSingleLine", "getState", "()Landroidx/compose/foundation/text/TextFieldState;", "getUndoManager", "()Landroidx/compose/foundation/text/UndoManager;", "getValue", "()Landroidx/compose/ui/text/input/TextFieldValue;", "commandExecutionContext", "", "block", "Lkotlin/Function1;", "Landroidx/compose/foundation/text/selection/TextFieldPreparedSelection;", "Lkotlin/ExtensionFunctionType;", "process", "event", "Landroidx/compose/ui/input/key/KeyEvent;", "process-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "typedCommand", "Landroidx/compose/ui/text/input/CommitTextCommand;", "typedCommand-ZmokQxo", "(Landroid/view/KeyEvent;)Landroidx/compose/ui/text/input/CommitTextCommand;", "apply", "Landroidx/compose/ui/text/input/EditCommand;", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextFieldKeyInput.kt */
public final class TextFieldKeyInput {
    private final boolean editable;
    private final KeyMapping keyMapping;
    private final OffsetMapping offsetMapping;
    private final TextPreparedSelectionState preparedSelectionState;
    private final TextFieldSelectionManager selectionManager;
    private final boolean singleLine;
    private final TextFieldState state;
    private final UndoManager undoManager;
    private final TextFieldValue value;

    public TextFieldKeyInput(TextFieldState textFieldState, TextFieldSelectionManager textFieldSelectionManager, TextFieldValue textFieldValue, boolean z, boolean z2, TextPreparedSelectionState textPreparedSelectionState, OffsetMapping offsetMapping2, UndoManager undoManager2, KeyMapping keyMapping2) {
        Intrinsics.checkNotNullParameter(textFieldState, PostalAddressParser.REGION_KEY);
        Intrinsics.checkNotNullParameter(textFieldSelectionManager, "selectionManager");
        Intrinsics.checkNotNullParameter(textFieldValue, "value");
        Intrinsics.checkNotNullParameter(textPreparedSelectionState, "preparedSelectionState");
        Intrinsics.checkNotNullParameter(offsetMapping2, "offsetMapping");
        Intrinsics.checkNotNullParameter(keyMapping2, "keyMapping");
        this.state = textFieldState;
        this.selectionManager = textFieldSelectionManager;
        this.value = textFieldValue;
        this.editable = z;
        this.singleLine = z2;
        this.preparedSelectionState = textPreparedSelectionState;
        this.offsetMapping = offsetMapping2;
        this.undoManager = undoManager2;
        this.keyMapping = keyMapping2;
    }

    public final TextFieldState getState() {
        return this.state;
    }

    public final TextFieldSelectionManager getSelectionManager() {
        return this.selectionManager;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TextFieldKeyInput(androidx.compose.foundation.text.TextFieldState r20, androidx.compose.foundation.text.selection.TextFieldSelectionManager r21, androidx.compose.ui.text.input.TextFieldValue r22, boolean r23, boolean r24, androidx.compose.foundation.text.selection.TextPreparedSelectionState r25, androidx.compose.ui.text.input.OffsetMapping r26, androidx.compose.foundation.text.UndoManager r27, androidx.compose.foundation.text.KeyMapping r28, int r29, kotlin.jvm.internal.DefaultConstructorMarker r30) {
        /*
            r19 = this;
            r0 = r29
            r1 = r0 & 4
            if (r1 == 0) goto L_0x0014
            androidx.compose.ui.text.input.TextFieldValue r1 = new androidx.compose.ui.text.input.TextFieldValue
            r3 = 0
            r4 = 0
            r6 = 0
            r7 = 7
            r8 = 0
            r2 = r1
            r2.<init>((java.lang.String) r3, (long) r4, (androidx.compose.ui.text.TextRange) r6, (int) r7, (kotlin.jvm.internal.DefaultConstructorMarker) r8)
            r12 = r1
            goto L_0x0016
        L_0x0014:
            r12 = r22
        L_0x0016:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x001d
            r1 = 1
            r13 = 1
            goto L_0x001f
        L_0x001d:
            r13 = r23
        L_0x001f:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0026
            r1 = 0
            r14 = 0
            goto L_0x0028
        L_0x0026:
            r14 = r24
        L_0x0028:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0035
            androidx.compose.ui.text.input.OffsetMapping$Companion r1 = androidx.compose.ui.text.input.OffsetMapping.Companion
            androidx.compose.ui.text.input.OffsetMapping r1 = r1.getIdentity()
            r16 = r1
            goto L_0x0037
        L_0x0035:
            r16 = r26
        L_0x0037:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x003f
            r1 = 0
            r17 = r1
            goto L_0x0041
        L_0x003f:
            r17 = r27
        L_0x0041:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x004c
            androidx.compose.foundation.text.KeyMapping r0 = androidx.compose.foundation.text.KeyMapping_androidKt.getPlatformDefaultKeyMapping()
            r18 = r0
            goto L_0x004e
        L_0x004c:
            r18 = r28
        L_0x004e:
            r9 = r19
            r10 = r20
            r11 = r21
            r15 = r25
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.TextFieldKeyInput.<init>(androidx.compose.foundation.text.TextFieldState, androidx.compose.foundation.text.selection.TextFieldSelectionManager, androidx.compose.ui.text.input.TextFieldValue, boolean, boolean, androidx.compose.foundation.text.selection.TextPreparedSelectionState, androidx.compose.ui.text.input.OffsetMapping, androidx.compose.foundation.text.UndoManager, androidx.compose.foundation.text.KeyMapping, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final TextFieldValue getValue() {
        return this.value;
    }

    public final boolean getEditable() {
        return this.editable;
    }

    public final boolean getSingleLine() {
        return this.singleLine;
    }

    public final TextPreparedSelectionState getPreparedSelectionState() {
        return this.preparedSelectionState;
    }

    public final OffsetMapping getOffsetMapping() {
        return this.offsetMapping;
    }

    public final UndoManager getUndoManager() {
        return this.undoManager;
    }

    /* access modifiers changed from: private */
    public final void apply(EditCommand editCommand) {
        TextFieldValue apply = this.state.getProcessor().apply(CollectionsKt.listOf(new FinishComposingTextCommand(), editCommand));
        if (!Intrinsics.areEqual((Object) apply.getAnnotatedString().getText(), (Object) this.state.getTextDelegate().getText().getText())) {
            this.state.setHandleState(HandleState.None);
        }
        this.state.getOnValueChange().invoke(apply);
    }

    /* renamed from: typedCommand-ZmokQxo  reason: not valid java name */
    private final CommitTextCommand m704typedCommandZmokQxo(KeyEvent keyEvent) {
        if (!TextFieldKeyInput_androidKt.m707isTypedEventZmokQxo(keyEvent)) {
            return null;
        }
        String sb = StringHelpers_jvmKt.appendCodePointX(new StringBuilder(), KeyEvent_androidKt.m2857getUtf16CodePointZmokQxo(keyEvent)).toString();
        Intrinsics.checkNotNullExpressionValue(sb, "StringBuilder().appendCo…              .toString()");
        return new CommitTextCommand(sb, 1);
    }

    /* renamed from: process-ZmokQxo  reason: not valid java name */
    public final boolean m705processZmokQxo(KeyEvent keyEvent) {
        KeyCommand r5;
        Intrinsics.checkNotNullParameter(keyEvent, "event");
        CommitTextCommand r0 = m704typedCommandZmokQxo(keyEvent);
        if (r0 == null) {
            if (!KeyEventType.m2848equalsimpl0(KeyEvent_androidKt.m2856getTypeZmokQxo(keyEvent), KeyEventType.Companion.m2852getKeyDownCS__XNY()) || (r5 = this.keyMapping.m646mapZmokQxo(keyEvent)) == null || (r5.getEditsText() && !this.editable)) {
                return false;
            }
            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            booleanRef.element = true;
            commandExecutionContext(new TextFieldKeyInput$process$2(r5, this, booleanRef));
            UndoManager undoManager2 = this.undoManager;
            if (undoManager2 != null) {
                undoManager2.forceNextSnapshot();
            }
            return booleanRef.element;
        } else if (!getEditable()) {
            return false;
        } else {
            apply(r0);
            getPreparedSelectionState().resetCachedX();
            return true;
        }
    }

    private final void commandExecutionContext(Function1<? super TextFieldPreparedSelection, Unit> function1) {
        TextFieldPreparedSelection textFieldPreparedSelection = new TextFieldPreparedSelection(this.value, this.offsetMapping, this.state.getLayoutResult(), this.preparedSelectionState);
        function1.invoke(textFieldPreparedSelection);
        if (!TextRange.m3564equalsimpl0(textFieldPreparedSelection.m742getSelectiond9O1mEE(), this.value.m3688getSelectiond9O1mEE()) || !Intrinsics.areEqual((Object) textFieldPreparedSelection.getAnnotatedString(), (Object) this.value.getAnnotatedString())) {
            this.state.getOnValueChange().invoke(textFieldPreparedSelection.getValue());
        }
    }
}
