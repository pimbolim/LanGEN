package androidx.compose.foundation.text.selection;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextFieldSelectionManager.kt */
final class TextFieldSelectionManager$showSelectionToolbar$copy$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ TextFieldSelectionManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldSelectionManager$showSelectionToolbar$copy$1(TextFieldSelectionManager textFieldSelectionManager) {
        super(0);
        this.this$0 = textFieldSelectionManager;
    }

    public final void invoke() {
        TextFieldSelectionManager.copy$foundation_release$default(this.this$0, false, 1, (Object) null);
        this.this$0.hideSelectionToolbar$foundation_release();
    }
}