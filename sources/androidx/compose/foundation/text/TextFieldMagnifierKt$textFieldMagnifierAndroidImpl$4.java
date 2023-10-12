package androidx.compose.foundation.text;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/geometry/Rect;", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextFieldMagnifier.kt */
final class TextFieldMagnifierKt$textFieldMagnifierAndroidImpl$4 extends Lambda implements Function1<Integer, Rect> {
    final /* synthetic */ TextFieldState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldMagnifierKt$textFieldMagnifierAndroidImpl$4(TextFieldState textFieldState) {
        super(1);
        this.$state = textFieldState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }

    public final Rect invoke(int i) {
        TextLayoutResult value;
        TextLayoutResultProxy layoutResult = this.$state.getLayoutResult();
        if (layoutResult == null || (value = layoutResult.getValue()) == null) {
            return null;
        }
        return value.getCursorRect(i);
    }
}
