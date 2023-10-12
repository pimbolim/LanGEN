package androidx.compose.foundation.text;

import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CoreTextField.kt */
final class CoreTextFieldKt$CoreTextField$4$1$1$2$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    public static final CoreTextFieldKt$CoreTextField$4$1$1$2$measure$1 INSTANCE = new CoreTextFieldKt$CoreTextField$4$1$1$2$measure$1();

    CoreTextFieldKt$CoreTextField$4$1$1$2$measure$1() {
        super(1);
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }
}
