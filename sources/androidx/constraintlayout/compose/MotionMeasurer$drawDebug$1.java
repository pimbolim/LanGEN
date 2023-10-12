package androidx.constraintlayout.compose;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.constraintlayout.core.state.WidgetFrame;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: MotionLayout.kt */
final class MotionMeasurer$drawDebug$1 extends Lambda implements Function1<DrawScope, Unit> {
    final /* synthetic */ MotionMeasurer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MotionMeasurer$drawDebug$1(MotionMeasurer motionMeasurer) {
        super(1);
        this.this$0 = motionMeasurer;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$Canvas");
        PathEffect dashPathEffect = PathEffect.Companion.dashPathEffect(new float[]{10.0f, 10.0f}, 0.0f);
        Iterator<ConstraintWidget> it = this.this$0.getRoot().getChildren().iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            WidgetFrame start = this.this$0.getTransition().getStart(next);
            WidgetFrame end = this.this$0.getTransition().getEnd(next);
            MotionMeasurer motionMeasurer = this.this$0;
            drawScope.getDrawContext().getTransform().translate(2.0f, 2.0f);
            float r5 = Size.m1422getWidthimpl(drawScope.m2092getSizeNHjbRc());
            float r6 = Size.m1419getHeightimpl(drawScope.m2092getSizeNHjbRc());
            Intrinsics.checkNotNullExpressionValue(start, "startFrame");
            Intrinsics.checkNotNullExpressionValue(end, "endFrame");
            WidgetFrame widgetFrame = end;
            PathEffect pathEffect = dashPathEffect;
            motionMeasurer.m4207drawFrameDebugPE3pjmc(drawScope, r5, r6, start, widgetFrame, pathEffect, Color.Companion.m1633getWhite0d7_KjU());
            drawScope.getDrawContext().getTransform().translate(-2.0f, -2.0f);
            this.this$0.m4207drawFrameDebugPE3pjmc(drawScope, Size.m1422getWidthimpl(drawScope.m2092getSizeNHjbRc()), Size.m1419getHeightimpl(drawScope.m2092getSizeNHjbRc()), start, widgetFrame, pathEffect, Color.Companion.m1623getBlue0d7_KjU());
        }
    }
}
