package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/compose/ui/text/input/TextFieldValue;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextFieldMagnifier.kt */
final class TextFieldMagnifierKt$textFieldMagnifierAndroidImpl$2 extends Lambda implements Function0<TextFieldValue> {
    final /* synthetic */ TextFieldSelectionManager $manager;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldMagnifierKt$textFieldMagnifierAndroidImpl$2(TextFieldSelectionManager textFieldSelectionManager) {
        super(0);
        this.$manager = textFieldSelectionManager;
    }

    public final TextFieldValue invoke() {
        return this.$manager.getValue$foundation_release();
    }
}
