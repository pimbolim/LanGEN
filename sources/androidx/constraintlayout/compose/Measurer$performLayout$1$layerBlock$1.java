package androidx.constraintlayout.compose;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.constraintlayout.core.state.WidgetFrame;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/GraphicsLayerScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: ConstraintLayout.kt */
final class Measurer$performLayout$1$layerBlock$1 extends Lambda implements Function1<GraphicsLayerScope, Unit> {
    final /* synthetic */ WidgetFrame $frame;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Measurer$performLayout$1$layerBlock$1(WidgetFrame widgetFrame) {
        super(1);
        this.$frame = widgetFrame;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GraphicsLayerScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(GraphicsLayerScope graphicsLayerScope) {
        Intrinsics.checkNotNullParameter(graphicsLayerScope, "$this$null");
        if (!Float.isNaN(this.$frame.pivotX) || !Float.isNaN(this.$frame.pivotY)) {
            float f = 0.5f;
            float f2 = Float.isNaN(this.$frame.pivotX) ? 0.5f : this.$frame.pivotX;
            if (!Float.isNaN(this.$frame.pivotY)) {
                f = this.$frame.pivotY;
            }
            graphicsLayerScope.m1735setTransformOrigin__ExYCQ(TransformOriginKt.TransformOrigin(f2, f));
        }
        if (!Float.isNaN(this.$frame.rotationX)) {
            graphicsLayerScope.setRotationX(this.$frame.rotationX);
        }
        if (!Float.isNaN(this.$frame.rotationY)) {
            graphicsLayerScope.setRotationY(this.$frame.rotationY);
        }
        if (!Float.isNaN(this.$frame.rotationZ)) {
            graphicsLayerScope.setRotationZ(this.$frame.rotationZ);
        }
        if (!Float.isNaN(this.$frame.translationX)) {
            graphicsLayerScope.setTranslationX(this.$frame.translationX);
        }
        if (!Float.isNaN(this.$frame.translationY)) {
            graphicsLayerScope.setTranslationY(this.$frame.translationY);
        }
        if (!Float.isNaN(this.$frame.translationZ)) {
            graphicsLayerScope.setShadowElevation(this.$frame.translationZ);
        }
        if (!Float.isNaN(this.$frame.scaleX) || !Float.isNaN(this.$frame.scaleY)) {
            float f3 = 1.0f;
            graphicsLayerScope.setScaleX(Float.isNaN(this.$frame.scaleX) ? 1.0f : this.$frame.scaleX);
            if (!Float.isNaN(this.$frame.scaleY)) {
                f3 = this.$frame.scaleY;
            }
            graphicsLayerScope.setScaleY(f3);
        }
        if (!Float.isNaN(this.$frame.alpha)) {
            graphicsLayerScope.setAlpha(this.$frame.alpha);
        }
    }
}
