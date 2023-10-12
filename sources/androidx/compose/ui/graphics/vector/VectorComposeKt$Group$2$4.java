package androidx.compose.ui.graphics.vector;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: VectorCompose.kt */
final class VectorComposeKt$Group$2$4 extends Lambda implements Function2<GroupComponent, Float, Unit> {
    public static final VectorComposeKt$Group$2$4 INSTANCE = new VectorComposeKt$Group$2$4();

    VectorComposeKt$Group$2$4() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((GroupComponent) obj, ((Number) obj2).floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(GroupComponent groupComponent, float f) {
        Intrinsics.checkNotNullParameter(groupComponent, "$this$set");
        groupComponent.setPivotY(f);
    }
}
