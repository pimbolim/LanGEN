package androidx.compose.ui.graphics.vector;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: VectorCompose.kt */
final class VectorComposeKt$Path$2$7 extends Lambda implements Function2<PathComponent, Float, Unit> {
    public static final VectorComposeKt$Path$2$7 INSTANCE = new VectorComposeKt$Path$2$7();

    VectorComposeKt$Path$2$7() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((PathComponent) obj, ((Number) obj2).floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(PathComponent pathComponent, float f) {
        Intrinsics.checkNotNullParameter(pathComponent, "$this$set");
        pathComponent.setStrokeAlpha(f);
    }
}
