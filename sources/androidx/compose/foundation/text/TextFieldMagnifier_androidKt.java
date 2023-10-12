package androidx.compose.foundation.text;

import androidx.compose.foundation.MagnifierStyle;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, d2 = {"textFieldMagnifier", "Landroidx/compose/ui/Modifier;", "manager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "foundation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextFieldMagnifier.android.kt */
public final class TextFieldMagnifier_androidKt {
    public static final Modifier textFieldMagnifier(Modifier modifier, TextFieldSelectionManager textFieldSelectionManager) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(textFieldSelectionManager, "manager");
        if (!MagnifierStyle.Companion.getTextDefault().isSupported()) {
            return Modifier.Companion;
        }
        return TextFieldMagnifierKt.textFieldMagnifierAndroidImpl$default(modifier, textFieldSelectionManager, TextFieldMagnifier_androidKt$textFieldMagnifier$1.INSTANCE, false, 4, (Object) null);
    }
}
