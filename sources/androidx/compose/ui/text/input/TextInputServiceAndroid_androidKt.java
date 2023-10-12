package androidx.compose.ui.text.input;

import android.view.inputmethod.EditorInfo;
import androidx.compose.ui.text.TextRange;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.view.inputmethod.EditorInfoCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u001a\u001c\u0010\u0007\u001a\u00020\b*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"DEBUG_CLASS", "", "hasFlag", "", "bits", "", "flag", "update", "", "Landroid/view/inputmethod/EditorInfo;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "textFieldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "ui_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextInputServiceAndroid.android.kt */
public final class TextInputServiceAndroid_androidKt {
    private static final String DEBUG_CLASS = "TextInputServiceAndroid";

    private static final boolean hasFlag(int i, int i2) {
        return (i & i2) == i2;
    }

    public static final void update(EditorInfo editorInfo, ImeOptions imeOptions, TextFieldValue textFieldValue) {
        Intrinsics.checkNotNullParameter(editorInfo, "<this>");
        Intrinsics.checkNotNullParameter(imeOptions, "imeOptions");
        Intrinsics.checkNotNullParameter(textFieldValue, "textFieldValue");
        int r0 = imeOptions.m3653getImeActioneUduSuo();
        int i = 6;
        if (ImeAction.m3638equalsimpl0(r0, ImeAction.Companion.m3642getDefaulteUduSuo())) {
            if (!imeOptions.getSingleLine()) {
                i = 0;
            }
        } else if (ImeAction.m3638equalsimpl0(r0, ImeAction.Companion.m3646getNoneeUduSuo())) {
            i = 1;
        } else if (ImeAction.m3638equalsimpl0(r0, ImeAction.Companion.m3644getGoeUduSuo())) {
            i = 2;
        } else if (ImeAction.m3638equalsimpl0(r0, ImeAction.Companion.m3645getNexteUduSuo())) {
            i = 5;
        } else if (ImeAction.m3638equalsimpl0(r0, ImeAction.Companion.m3647getPreviouseUduSuo())) {
            i = 7;
        } else if (ImeAction.m3638equalsimpl0(r0, ImeAction.Companion.m3648getSearcheUduSuo())) {
            i = 3;
        } else if (ImeAction.m3638equalsimpl0(r0, ImeAction.Companion.m3649getSendeUduSuo())) {
            i = 4;
        } else if (!ImeAction.m3638equalsimpl0(r0, ImeAction.Companion.m3643getDoneeUduSuo())) {
            throw new IllegalStateException("invalid ImeAction".toString());
        }
        editorInfo.imeOptions = i;
        int r02 = imeOptions.m3654getKeyboardTypePjHm6EE();
        if (KeyboardType.m3671equalsimpl0(r02, KeyboardType.Companion.m3681getTextPjHm6EE())) {
            editorInfo.inputType = 1;
        } else if (KeyboardType.m3671equalsimpl0(r02, KeyboardType.Companion.m3675getAsciiPjHm6EE())) {
            editorInfo.inputType = 1;
            editorInfo.imeOptions |= Integer.MIN_VALUE;
        } else if (KeyboardType.m3671equalsimpl0(r02, KeyboardType.Companion.m3677getNumberPjHm6EE())) {
            editorInfo.inputType = 2;
        } else if (KeyboardType.m3671equalsimpl0(r02, KeyboardType.Companion.m3680getPhonePjHm6EE())) {
            editorInfo.inputType = 3;
        } else if (KeyboardType.m3671equalsimpl0(r02, KeyboardType.Companion.m3682getUriPjHm6EE())) {
            editorInfo.inputType = 17;
        } else if (KeyboardType.m3671equalsimpl0(r02, KeyboardType.Companion.m3676getEmailPjHm6EE())) {
            editorInfo.inputType = 33;
        } else if (KeyboardType.m3671equalsimpl0(r02, KeyboardType.Companion.m3679getPasswordPjHm6EE())) {
            editorInfo.inputType = 129;
        } else if (KeyboardType.m3671equalsimpl0(r02, KeyboardType.Companion.m3678getNumberPasswordPjHm6EE())) {
            editorInfo.inputType = 18;
        } else {
            throw new IllegalStateException("Invalid Keyboard Type".toString());
        }
        if (!imeOptions.getSingleLine() && hasFlag(editorInfo.inputType, 1)) {
            editorInfo.inputType |= 131072;
            if (ImeAction.m3638equalsimpl0(imeOptions.m3653getImeActioneUduSuo(), ImeAction.Companion.m3642getDefaulteUduSuo())) {
                editorInfo.imeOptions |= BasicMeasure.EXACTLY;
            }
        }
        if (hasFlag(editorInfo.inputType, 1)) {
            int r03 = imeOptions.m3652getCapitalizationIUNYP9k();
            if (KeyboardCapitalization.m3660equalsimpl0(r03, KeyboardCapitalization.Companion.m3664getCharactersIUNYP9k())) {
                editorInfo.inputType |= 4096;
            } else if (KeyboardCapitalization.m3660equalsimpl0(r03, KeyboardCapitalization.Companion.m3667getWordsIUNYP9k())) {
                editorInfo.inputType |= 8192;
            } else if (KeyboardCapitalization.m3660equalsimpl0(r03, KeyboardCapitalization.Companion.m3666getSentencesIUNYP9k())) {
                editorInfo.inputType |= 16384;
            }
            if (imeOptions.getAutoCorrect()) {
                editorInfo.inputType |= 32768;
            }
        }
        editorInfo.initialSelStart = TextRange.m3571getStartimpl(textFieldValue.m3688getSelectiond9O1mEE());
        editorInfo.initialSelEnd = TextRange.m3566getEndimpl(textFieldValue.m3688getSelectiond9O1mEE());
        EditorInfoCompat.setInitialSurroundingText(editorInfo, textFieldValue.getText());
        editorInfo.imeOptions |= 33554432;
    }
}
