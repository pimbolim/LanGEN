package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.SelectionRegistrar;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BasicText.kt */
final class BasicTextKt$BasicText$selectableId$1 extends Lambda implements Function0<Long> {
    final /* synthetic */ SelectionRegistrar $selectionRegistrar;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BasicTextKt$BasicText$selectableId$1(SelectionRegistrar selectionRegistrar) {
        super(0);
        this.$selectionRegistrar = selectionRegistrar;
    }

    public final Long invoke() {
        SelectionRegistrar selectionRegistrar = this.$selectionRegistrar;
        return Long.valueOf(selectionRegistrar == null ? 0 : selectionRegistrar.nextSelectableId());
    }
}
