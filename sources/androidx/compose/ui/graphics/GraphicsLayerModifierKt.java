package androidx.compose.ui.graphics;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a%\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0007\u001a\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019\u001a§\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001d\u001a\f\u0010\u001e\u001a\u00020\u0001*\u00020\u0001H\u0007\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001f"}, d2 = {"graphicsLayer", "Landroidx/compose/ui/Modifier;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "", "Lkotlin/ExtensionFunctionType;", "scaleX", "", "scaleY", "alpha", "translationX", "translationY", "shadowElevation", "rotationX", "rotationY", "rotationZ", "cameraDistance", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "shape", "Landroidx/compose/ui/graphics/Shape;", "clip", "", "graphicsLayer-sKFY_QE", "(Landroidx/compose/ui/Modifier;FFFFFFFFFFJLandroidx/compose/ui/graphics/Shape;Z)Landroidx/compose/ui/Modifier;", "renderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "graphicsLayer-2Xn7asI", "(Landroidx/compose/ui/Modifier;FFFFFFFFFFJLandroidx/compose/ui/graphics/Shape;ZLandroidx/compose/ui/graphics/RenderEffect;)Landroidx/compose/ui/Modifier;", "toolingGraphicsLayer", "ui_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: GraphicsLayerModifier.kt */
public final class GraphicsLayerModifierKt {
    /* renamed from: graphicsLayer-sKFY_QE$default  reason: not valid java name */
    public static /* synthetic */ Modifier m1733graphicsLayersKFY_QE$default(Modifier modifier, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, long j, Shape shape, boolean z, int i, Object obj) {
        Shape shape2;
        int i2 = i;
        float f11 = 1.0f;
        float f12 = (i2 & 1) != 0 ? 1.0f : f;
        float f13 = (i2 & 2) != 0 ? 1.0f : f2;
        if ((i2 & 4) == 0) {
            f11 = f3;
        }
        float f14 = 0.0f;
        float f15 = (i2 & 8) != 0 ? 0.0f : f4;
        float f16 = (i2 & 16) != 0 ? 0.0f : f5;
        float f17 = (i2 & 32) != 0 ? 0.0f : f6;
        float f18 = (i2 & 64) != 0 ? 0.0f : f7;
        float f19 = (i2 & 128) != 0 ? 0.0f : f8;
        if ((i2 & 256) == 0) {
            f14 = f9;
        }
        float f20 = (i2 & 512) != 0 ? 8.0f : f10;
        long r11 = (i2 & 1024) != 0 ? TransformOrigin.Companion.m1955getCenterSzJe1aQ() : j;
        if ((i2 & 2048) != 0) {
            shape2 = RectangleShapeKt.getRectangleShape();
        } else {
            shape2 = shape;
        }
        return m1732graphicsLayersKFY_QE(modifier, f12, f13, f11, f15, f16, f17, f18, f19, f14, f20, r11, shape2, (i2 & 4096) != 0 ? false : z);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replace with graphicsLayer that consumes an optional RenderEffect parameter", replaceWith = @ReplaceWith(expression = "Modifier.graphicsLayer(scaleX, scaleY, alpha, translationX, translationY, shadowElevation, rotationX, rotationY, rotationZ, cameraDistance, transformOrigin, shape, clip, null)", imports = {"androidx.compose.ui.graphics"}))
    /* renamed from: graphicsLayer-sKFY_QE  reason: not valid java name */
    public static final /* synthetic */ Modifier m1732graphicsLayersKFY_QE(Modifier modifier, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, long j, Shape shape, boolean z) {
        Modifier modifier2 = modifier;
        Intrinsics.checkNotNullParameter(modifier2, "$this$graphicsLayer");
        Shape shape2 = shape;
        Intrinsics.checkNotNullParameter(shape2, "shape");
        return m1730graphicsLayer2Xn7asI(modifier2, f, f2, f3, f4, f5, f6, f7, f8, f9, f10, j, shape2, z, (RenderEffect) null);
    }

    /* renamed from: graphicsLayer-2Xn7asI$default  reason: not valid java name */
    public static /* synthetic */ Modifier m1731graphicsLayer2Xn7asI$default(Modifier modifier, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, long j, Shape shape, boolean z, RenderEffect renderEffect, int i, Object obj) {
        Shape shape2;
        int i2 = i;
        float f11 = 1.0f;
        float f12 = (i2 & 1) != 0 ? 1.0f : f;
        float f13 = (i2 & 2) != 0 ? 1.0f : f2;
        if ((i2 & 4) == 0) {
            f11 = f3;
        }
        float f14 = 0.0f;
        float f15 = (i2 & 8) != 0 ? 0.0f : f4;
        float f16 = (i2 & 16) != 0 ? 0.0f : f5;
        float f17 = (i2 & 32) != 0 ? 0.0f : f6;
        float f18 = (i2 & 64) != 0 ? 0.0f : f7;
        float f19 = (i2 & 128) != 0 ? 0.0f : f8;
        if ((i2 & 256) == 0) {
            f14 = f9;
        }
        float f20 = (i2 & 512) != 0 ? 8.0f : f10;
        long r11 = (i2 & 1024) != 0 ? TransformOrigin.Companion.m1955getCenterSzJe1aQ() : j;
        if ((i2 & 2048) != 0) {
            shape2 = RectangleShapeKt.getRectangleShape();
        } else {
            shape2 = shape;
        }
        return m1730graphicsLayer2Xn7asI(modifier, f12, f13, f11, f15, f16, f17, f18, f19, f14, f20, r11, shape2, (i2 & 4096) != 0 ? false : z, (i2 & 8192) != 0 ? null : renderEffect);
    }

    /* renamed from: graphicsLayer-2Xn7asI  reason: not valid java name */
    public static final Modifier m1730graphicsLayer2Xn7asI(Modifier modifier, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, long j, Shape shape, boolean z, RenderEffect renderEffect) {
        Modifier modifier2 = modifier;
        Intrinsics.checkNotNullParameter(modifier2, "$this$graphicsLayer");
        Intrinsics.checkNotNullParameter(shape, "shape");
        return modifier2.then(new SimpleGraphicsLayerModifier(f, f2, f3, f4, f5, f6, f7, f8, f9, f10, j, shape, z, renderEffect, InspectableValueKt.isDebugInspectorInfoEnabled() ? new GraphicsLayerModifierKt$graphicsLayer2Xn7asI$$inlined$debugInspectorInfo$1(f, f2, f3, f4, f5, f6, f7, f8, f9, f10, j, shape, z, renderEffect) : InspectableValueKt.getNoInspectorInfo(), (DefaultConstructorMarker) null));
    }

    public static final Modifier graphicsLayer(Modifier modifier, Function1<? super GraphicsLayerScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        return modifier.then(new BlockGraphicsLayerModifier(function1, InspectableValueKt.isDebugInspectorInfoEnabled() ? new GraphicsLayerModifierKt$graphicsLayer$$inlined$debugInspectorInfo$1(function1) : InspectableValueKt.getNoInspectorInfo()));
    }

    public static final Modifier toolingGraphicsLayer(Modifier modifier) {
        Modifier modifier2 = modifier;
        Intrinsics.checkNotNullParameter(modifier2, "<this>");
        return InspectableValueKt.isDebugInspectorInfoEnabled() ? modifier2.then(m1731graphicsLayer2Xn7asI$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, (Shape) null, false, (RenderEffect) null, 16383, (Object) null)) : modifier2;
    }
}
