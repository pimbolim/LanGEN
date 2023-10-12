package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import com.braintreepayments.api.models.PostalAddressParser;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aD\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0000¨\u0006\u000f"}, d2 = {"textFieldKeyInput", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/text/TextFieldState;", "manager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "editable", "", "singleLine", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "undoManager", "Landroidx/compose/foundation/text/UndoManager;", "foundation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextFieldKeyInput.kt */
public final class TextFieldKeyInputKt {
    public static final Modifier textFieldKeyInput(Modifier modifier, TextFieldState textFieldState, TextFieldSelectionManager textFieldSelectionManager, TextFieldValue textFieldValue, boolean z, boolean z2, OffsetMapping offsetMapping, UndoManager undoManager) {
        Modifier modifier2 = modifier;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(textFieldState, PostalAddressParser.REGION_KEY);
        Intrinsics.checkNotNullParameter(textFieldSelectionManager, "manager");
        Intrinsics.checkNotNullParameter(textFieldValue, "value");
        OffsetMapping offsetMapping2 = offsetMapping;
        Intrinsics.checkNotNullParameter(offsetMapping2, "offsetMapping");
        UndoManager undoManager2 = undoManager;
        Intrinsics.checkNotNullParameter(undoManager2, "undoManager");
        return ComposedModifierKt.composed$default(modifier, (Function1) null, new TextFieldKeyInputKt$textFieldKeyInput$1(textFieldState, textFieldSelectionManager, textFieldValue, z, z2, offsetMapping2, undoManager2), 1, (Object) null);
    }
}
