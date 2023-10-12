package androidx.compose.ui.text.input;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputContentInfo;
import androidx.compose.ui.text.TextRange;
import com.braintreepayments.api.models.PostalAddressParser;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0010H\u0002J\b\u0010 \u001a\u00020\u0007H\u0016J\b\u0010!\u001a\u00020\u0007H\u0002J\u0010\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\fH\u0016J\b\u0010$\u001a\u00020\u001eH\u0016J\u0012\u0010%\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\"\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\f2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0012\u0010.\u001a\u00020\u00072\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u001a\u00101\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u00020\fH\u0016J\u0018\u00104\u001a\u00020\u00072\u0006\u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020\fH\u0016J\u0018\u00107\u001a\u00020\u00072\u0006\u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020\fH\u0016J\b\u00108\u001a\u00020\u0007H\u0016J\b\u00109\u001a\u00020\u0007H\u0002J\u0017\u0010:\u001a\u00020\u00072\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u001e0<H\bJ\b\u0010=\u001a\u00020\u0007H\u0016J\u0010\u0010>\u001a\u00020\f2\u0006\u0010?\u001a\u00020\fH\u0016J\u001a\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010C2\u0006\u0010+\u001a\u00020\fH\u0016J\n\u0010D\u001a\u0004\u0018\u00010EH\u0016J\u0012\u0010F\u001a\u0004\u0018\u0001022\u0006\u0010+\u001a\u00020\fH\u0016J\u0018\u0010G\u001a\u0002022\u0006\u0010H\u001a\u00020\f2\u0006\u0010+\u001a\u00020\fH\u0016J\u0018\u0010I\u001a\u0002022\u0006\u0010H\u001a\u00020\f2\u0006\u0010+\u001a\u00020\fH\u0016J\u0010\u0010J\u001a\u00020\u001e2\u0006\u0010K\u001a\u00020LH\u0002J\u0010\u0010M\u001a\u00020\u00072\u0006\u0010N\u001a\u00020\fH\u0016J\u0010\u0010O\u001a\u00020\u00072\u0006\u0010P\u001a\u00020\fH\u0016J\u001c\u0010Q\u001a\u00020\u00072\b\u0010R\u001a\u0004\u0018\u00010L2\b\u0010S\u001a\u0004\u0018\u00010-H\u0016J\u0010\u0010T\u001a\u00020\u00072\u0006\u0010U\u001a\u00020\u0007H\u0016J\u0010\u0010V\u001a\u00020\u00072\u0006\u0010W\u001a\u00020\fH\u0016J\u0010\u0010X\u001a\u00020\u00072\u0006\u0010Y\u001a\u00020ZH\u0016J\u0018\u0010[\u001a\u00020\u00072\u0006\u0010\\\u001a\u00020\f2\u0006\u0010]\u001a\u00020\fH\u0016J\u001a\u0010^\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u00020\fH\u0016J\u0018\u0010_\u001a\u00020\u00072\u0006\u0010\\\u001a\u00020\f2\u0006\u0010]\u001a\u00020\fH\u0016J\u001e\u0010`\u001a\u00020\u001e2\u0006\u0010a\u001a\u00020\u00032\u0006\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R,\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00038\u0000@@X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006f"}, d2 = {"Landroidx/compose/ui/text/input/RecordingInputConnection;", "Landroid/view/inputmethod/InputConnection;", "initState", "Landroidx/compose/ui/text/input/TextFieldValue;", "eventCallback", "Landroidx/compose/ui/text/input/InputEventCallback2;", "autoCorrect", "", "(Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/ui/text/input/InputEventCallback2;Z)V", "getAutoCorrect", "()Z", "batchDepth", "", "currentExtractedTextRequestToken", "editCommands", "", "Landroidx/compose/ui/text/input/EditCommand;", "getEventCallback", "()Landroidx/compose/ui/text/input/InputEventCallback2;", "extractedTextMonitorMode", "isActive", "value", "mTextFieldValue", "getMTextFieldValue$ui_release$annotations", "()V", "getMTextFieldValue$ui_release", "()Landroidx/compose/ui/text/input/TextFieldValue;", "setMTextFieldValue$ui_release", "(Landroidx/compose/ui/text/input/TextFieldValue;)V", "addEditCommandWithBatch", "", "editCommand", "beginBatchEdit", "beginBatchEditInternal", "clearMetaKeyStates", "states", "closeConnection", "commitCompletion", "text", "Landroid/view/inputmethod/CompletionInfo;", "commitContent", "inputContentInfo", "Landroid/view/inputmethod/InputContentInfo;", "flags", "opts", "Landroid/os/Bundle;", "commitCorrection", "correctionInfo", "Landroid/view/inputmethod/CorrectionInfo;", "commitText", "", "newCursorPosition", "deleteSurroundingText", "beforeLength", "afterLength", "deleteSurroundingTextInCodePoints", "endBatchEdit", "endBatchEditInternal", "ensureActive", "block", "Lkotlin/Function0;", "finishComposingText", "getCursorCapsMode", "reqModes", "getExtractedText", "Landroid/view/inputmethod/ExtractedText;", "request", "Landroid/view/inputmethod/ExtractedTextRequest;", "getHandler", "Landroid/os/Handler;", "getSelectedText", "getTextAfterCursor", "maxChars", "getTextBeforeCursor", "logDebug", "message", "", "performContextMenuAction", "id", "performEditorAction", "editorAction", "performPrivateCommand", "action", "data", "reportFullscreenMode", "enabled", "requestCursorUpdates", "cursorUpdateMode", "sendKeyEvent", "event", "Landroid/view/KeyEvent;", "setComposingRegion", "start", "end", "setComposingText", "setSelection", "updateInputState", "state", "inputMethodManager", "Landroidx/compose/ui/text/input/InputMethodManager;", "view", "Landroid/view/View;", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RecordingInputConnection.android.kt */
public final class RecordingInputConnection implements InputConnection {
    private final boolean autoCorrect;
    private int batchDepth;
    private int currentExtractedTextRequestToken;
    private final List<EditCommand> editCommands = new ArrayList();
    private final InputEventCallback2 eventCallback;
    private boolean extractedTextMonitorMode;
    private boolean isActive = true;
    private TextFieldValue mTextFieldValue;

    public static /* synthetic */ void getMTextFieldValue$ui_release$annotations() {
    }

    private final void logDebug(String str) {
    }

    public Handler getHandler() {
        return null;
    }

    public boolean reportFullscreenMode(boolean z) {
        return false;
    }

    public RecordingInputConnection(TextFieldValue textFieldValue, InputEventCallback2 inputEventCallback2, boolean z) {
        Intrinsics.checkNotNullParameter(textFieldValue, "initState");
        Intrinsics.checkNotNullParameter(inputEventCallback2, "eventCallback");
        this.eventCallback = inputEventCallback2;
        this.autoCorrect = z;
        this.mTextFieldValue = textFieldValue;
    }

    public final InputEventCallback2 getEventCallback() {
        return this.eventCallback;
    }

    public final boolean getAutoCorrect() {
        return this.autoCorrect;
    }

    public final TextFieldValue getMTextFieldValue$ui_release() {
        return this.mTextFieldValue;
    }

    public final void setMTextFieldValue$ui_release(TextFieldValue textFieldValue) {
        Intrinsics.checkNotNullParameter(textFieldValue, "value");
        this.mTextFieldValue = textFieldValue;
    }

    private final boolean ensureActive(Function0<Unit> function0) {
        boolean z = this.isActive;
        if (z) {
            function0.invoke();
        }
        return z;
    }

    public final void updateInputState(TextFieldValue textFieldValue, InputMethodManager inputMethodManager, View view) {
        Intrinsics.checkNotNullParameter(textFieldValue, PostalAddressParser.REGION_KEY);
        Intrinsics.checkNotNullParameter(inputMethodManager, "inputMethodManager");
        Intrinsics.checkNotNullParameter(view, "view");
        if (this.isActive) {
            setMTextFieldValue$ui_release(textFieldValue);
            if (this.extractedTextMonitorMode) {
                inputMethodManager.updateExtractedText(view, this.currentExtractedTextRequestToken, InputState_androidKt.toExtractedText(textFieldValue));
            }
            TextRange r0 = textFieldValue.m3687getCompositionMzsxiRA();
            int r6 = r0 == null ? -1 : TextRange.m3569getMinimpl(r0.m3575unboximpl());
            TextRange r02 = textFieldValue.m3687getCompositionMzsxiRA();
            inputMethodManager.updateSelection(view, TextRange.m3569getMinimpl(textFieldValue.m3688getSelectiond9O1mEE()), TextRange.m3568getMaximpl(textFieldValue.m3688getSelectiond9O1mEE()), r6, r02 == null ? -1 : TextRange.m3568getMaximpl(r02.m3575unboximpl()));
        }
    }

    private final void addEditCommandWithBatch(EditCommand editCommand) {
        beginBatchEditInternal();
        try {
            this.editCommands.add(editCommand);
        } finally {
            endBatchEditInternal();
        }
    }

    private final boolean beginBatchEditInternal() {
        this.batchDepth++;
        return true;
    }

    public boolean endBatchEdit() {
        return endBatchEditInternal();
    }

    private final boolean endBatchEditInternal() {
        int i = this.batchDepth - 1;
        this.batchDepth = i;
        if (i == 0 && (!this.editCommands.isEmpty())) {
            this.eventCallback.onEditCommands(CollectionsKt.toMutableList(this.editCommands));
            this.editCommands.clear();
        }
        if (this.batchDepth > 0) {
            return true;
        }
        return false;
    }

    public void closeConnection() {
        this.editCommands.clear();
        this.batchDepth = 0;
        this.isActive = false;
    }

    public CharSequence getTextBeforeCursor(int i, int i2) {
        return TextFieldValueKt.getTextBeforeSelection(this.mTextFieldValue, i).toString();
    }

    public CharSequence getTextAfterCursor(int i, int i2) {
        return TextFieldValueKt.getTextAfterSelection(this.mTextFieldValue, i).toString();
    }

    public CharSequence getSelectedText(int i) {
        if (TextRange.m3565getCollapsedimpl(this.mTextFieldValue.m3688getSelectiond9O1mEE())) {
            return null;
        }
        return TextFieldValueKt.getSelectedText(this.mTextFieldValue).toString();
    }

    public ExtractedText getExtractedText(ExtractedTextRequest extractedTextRequest, int i) {
        boolean z = true;
        int i2 = 0;
        if ((i & 1) == 0) {
            z = false;
        }
        this.extractedTextMonitorMode = z;
        if (z) {
            if (extractedTextRequest != null) {
                i2 = extractedTextRequest.token;
            }
            this.currentExtractedTextRequestToken = i2;
        }
        return InputState_androidKt.toExtractedText(this.mTextFieldValue);
    }

    public int getCursorCapsMode(int i) {
        return TextUtils.getCapsMode(this.mTextFieldValue.getText(), TextRange.m3569getMinimpl(this.mTextFieldValue.m3688getSelectiond9O1mEE()), i);
    }

    public boolean beginBatchEdit() {
        boolean z = this.isActive;
        return z ? beginBatchEditInternal() : z;
    }

    public boolean commitText(CharSequence charSequence, int i) {
        boolean z = this.isActive;
        if (z) {
            addEditCommandWithBatch(new CommitTextCommand(String.valueOf(charSequence), i));
        }
        return z;
    }

    public boolean setComposingRegion(int i, int i2) {
        boolean z = this.isActive;
        if (z) {
            addEditCommandWithBatch(new SetComposingRegionCommand(i, i2));
        }
        return z;
    }

    public boolean setComposingText(CharSequence charSequence, int i) {
        boolean z = this.isActive;
        if (z) {
            addEditCommandWithBatch(new SetComposingTextCommand(String.valueOf(charSequence), i));
        }
        return z;
    }

    public boolean deleteSurroundingTextInCodePoints(int i, int i2) {
        boolean z = this.isActive;
        if (!z) {
            return z;
        }
        addEditCommandWithBatch(new DeleteSurroundingTextInCodePointsCommand(i, i2));
        return true;
    }

    public boolean deleteSurroundingText(int i, int i2) {
        boolean z = this.isActive;
        if (!z) {
            return z;
        }
        addEditCommandWithBatch(new DeleteSurroundingTextCommand(i, i2));
        return true;
    }

    public boolean setSelection(int i, int i2) {
        boolean z = this.isActive;
        if (!z) {
            return z;
        }
        addEditCommandWithBatch(new SetSelectionCommand(i, i2));
        return true;
    }

    public boolean finishComposingText() {
        boolean z = this.isActive;
        if (!z) {
            return z;
        }
        addEditCommandWithBatch(new FinishComposingTextCommand());
        return true;
    }

    public boolean sendKeyEvent(KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "event");
        boolean z = this.isActive;
        if (!z) {
            return z;
        }
        getEventCallback().onKeyEvent(keyEvent);
        return true;
    }

    public boolean requestCursorUpdates(int i) {
        boolean z = this.isActive;
        if (!z) {
            return z;
        }
        Log.w(RecordingInputConnection_androidKt.TAG, "requestCursorUpdates is not supported");
        return false;
    }

    public boolean performContextMenuAction(int i) {
        boolean z = this.isActive;
        if (!z) {
            return z;
        }
        Log.w(RecordingInputConnection_androidKt.TAG, "performContextMenuAction is not supported");
        return false;
    }

    public boolean performEditorAction(int i) {
        int i2;
        boolean z = this.isActive;
        if (!z) {
            return z;
        }
        if (i != 0) {
            switch (i) {
                case 2:
                    i2 = ImeAction.Companion.m3644getGoeUduSuo();
                    break;
                case 3:
                    i2 = ImeAction.Companion.m3648getSearcheUduSuo();
                    break;
                case 4:
                    i2 = ImeAction.Companion.m3649getSendeUduSuo();
                    break;
                case 5:
                    i2 = ImeAction.Companion.m3645getNexteUduSuo();
                    break;
                case 6:
                    i2 = ImeAction.Companion.m3643getDoneeUduSuo();
                    break;
                case 7:
                    i2 = ImeAction.Companion.m3647getPreviouseUduSuo();
                    break;
                default:
                    Log.w(RecordingInputConnection_androidKt.TAG, Intrinsics.stringPlus("IME sends unsupported Editor Action: ", Integer.valueOf(i)));
                    i2 = ImeAction.Companion.m3642getDefaulteUduSuo();
                    break;
            }
        } else {
            i2 = ImeAction.Companion.m3642getDefaulteUduSuo();
        }
        getEventCallback().m3656onImeActionKlQnJC8(i2);
        return true;
    }

    public boolean commitCompletion(CompletionInfo completionInfo) {
        boolean z = this.isActive;
        if (z) {
            return false;
        }
        return z;
    }

    public boolean commitCorrection(CorrectionInfo correctionInfo) {
        boolean z = this.isActive;
        return z ? getAutoCorrect() : z;
    }

    public boolean clearMetaKeyStates(int i) {
        boolean z = this.isActive;
        if (z) {
            return false;
        }
        return z;
    }

    public boolean performPrivateCommand(String str, Bundle bundle) {
        boolean z = this.isActive;
        if (z) {
            return true;
        }
        return z;
    }

    public boolean commitContent(InputContentInfo inputContentInfo, int i, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inputContentInfo, "inputContentInfo");
        boolean z = this.isActive;
        if (z) {
            return false;
        }
        return z;
    }
}
