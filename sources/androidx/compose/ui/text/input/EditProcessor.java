package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.AnnotatedStringKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\f\u001a\u00020\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0006\u0010\u0015\u001a\u00020\bR\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/text/input/EditProcessor;", "", "()V", "<set-?>", "Landroidx/compose/ui/text/input/EditingBuffer;", "mBuffer", "getMBuffer$ui_text_release", "()Landroidx/compose/ui/text/input/EditingBuffer;", "Landroidx/compose/ui/text/input/TextFieldValue;", "mBufferState", "getMBufferState$ui_text_release", "()Landroidx/compose/ui/text/input/TextFieldValue;", "apply", "editCommands", "", "Landroidx/compose/ui/text/input/EditCommand;", "reset", "", "value", "textInputSession", "Landroidx/compose/ui/text/input/TextInputSession;", "toTextFieldValue", "ui-text_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EditProcessor.kt */
public final class EditProcessor {
    private EditingBuffer mBuffer = new EditingBuffer(this.mBufferState.getAnnotatedString(), this.mBufferState.m3688getSelectiond9O1mEE(), (DefaultConstructorMarker) null);
    private TextFieldValue mBufferState = new TextFieldValue(AnnotatedStringKt.emptyAnnotatedString(), TextRange.Companion.m3576getZerod9O1mEE(), (TextRange) null, (DefaultConstructorMarker) null);

    public final TextFieldValue getMBufferState$ui_text_release() {
        return this.mBufferState;
    }

    public final EditingBuffer getMBuffer$ui_text_release() {
        return this.mBuffer;
    }

    public final void reset(TextFieldValue textFieldValue, TextInputSession textInputSession) {
        Intrinsics.checkNotNullParameter(textFieldValue, "value");
        if (!Intrinsics.areEqual((Object) this.mBufferState.getAnnotatedString(), (Object) textFieldValue.getAnnotatedString())) {
            this.mBuffer = new EditingBuffer(textFieldValue.getAnnotatedString(), textFieldValue.m3688getSelectiond9O1mEE(), (DefaultConstructorMarker) null);
        } else if (!TextRange.m3564equalsimpl0(this.mBufferState.m3688getSelectiond9O1mEE(), textFieldValue.m3688getSelectiond9O1mEE())) {
            this.mBuffer.setSelection$ui_text_release(TextRange.m3569getMinimpl(textFieldValue.m3688getSelectiond9O1mEE()), TextRange.m3568getMaximpl(textFieldValue.m3688getSelectiond9O1mEE()));
        }
        if (textFieldValue.m3687getCompositionMzsxiRA() == null) {
            this.mBuffer.commitComposition$ui_text_release();
        } else if (!TextRange.m3565getCollapsedimpl(textFieldValue.m3687getCompositionMzsxiRA().m3575unboximpl())) {
            this.mBuffer.setComposition$ui_text_release(TextRange.m3569getMinimpl(textFieldValue.m3687getCompositionMzsxiRA().m3575unboximpl()), TextRange.m3568getMaximpl(textFieldValue.m3687getCompositionMzsxiRA().m3575unboximpl()));
        }
        TextFieldValue textFieldValue2 = this.mBufferState;
        this.mBufferState = textFieldValue;
        if (textInputSession != null) {
            textInputSession.updateState(textFieldValue2, textFieldValue);
        }
    }

    public final TextFieldValue toTextFieldValue() {
        return this.mBufferState;
    }

    public final TextFieldValue apply(List<? extends EditCommand> list) {
        TextRange textRange;
        Intrinsics.checkNotNullParameter(list, "editCommands");
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ((EditCommand) list.get(i)).applyTo(getMBuffer$ui_text_release());
        }
        AnnotatedString annotatedString$ui_text_release = this.mBuffer.toAnnotatedString$ui_text_release();
        long TextRange = TextRangeKt.TextRange(this.mBuffer.getSelectionStart$ui_text_release(), this.mBuffer.getSelectionEnd$ui_text_release());
        if (this.mBuffer.hasComposition$ui_text_release()) {
            textRange = TextRange.m3559boximpl(TextRangeKt.TextRange(this.mBuffer.getCompositionStart$ui_text_release(), this.mBuffer.getCompositionEnd$ui_text_release()));
        } else {
            textRange = null;
        }
        TextFieldValue textFieldValue = new TextFieldValue(annotatedString$ui_text_release, TextRange, textRange, (DefaultConstructorMarker) null);
        this.mBufferState = textFieldValue;
        return textFieldValue;
    }
}
