package androidx.compose.ui.window;

import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AndroidPopup.android.kt */
public final class AndroidPopup_androidKt$SimpleStack$1$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    public static final AndroidPopup_androidKt$SimpleStack$1$measure$1 INSTANCE = new AndroidPopup_androidKt$SimpleStack$1$measure$1();

    public AndroidPopup_androidKt$SimpleStack$1$measure$1() {
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
