package androidx.compose.foundation.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/text/Handle;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextFieldMagnifier.kt */
final class TextFieldMagnifierKt$textFieldMagnifierAndroidImpl$1 extends Lambda implements Function0<Handle> {
    final /* synthetic */ TextFieldState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldMagnifierKt$textFieldMagnifierAndroidImpl$1(TextFieldState textFieldState) {
        super(0);
        this.$state = textFieldState;
    }

    public final Handle invoke() {
        return this.$state.getDraggingHandle();
    }
}
