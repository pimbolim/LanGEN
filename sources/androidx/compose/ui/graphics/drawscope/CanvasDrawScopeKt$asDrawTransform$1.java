package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Path;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J%\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010J=\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000eH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018J(\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0013H\u0016J%\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0003H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ-\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0003H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010#J\u001d\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020&H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b'\u0010(J\u0018\u0010)\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016R\u001d\u0010\u0002\u001a\u00020\u00038VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001d\u0010\u0006\u001a\u00020\u00078VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\b\u0010\u0005\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006*"}, d2 = {"androidx/compose/ui/graphics/drawscope/CanvasDrawScopeKt$asDrawTransform$1", "Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "center", "Landroidx/compose/ui/geometry/Offset;", "getCenter-F1C5BW0", "()J", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "clipPath", "", "path", "Landroidx/compose/ui/graphics/Path;", "clipOp", "Landroidx/compose/ui/graphics/ClipOp;", "clipPath-mtrdD-E", "(Landroidx/compose/ui/graphics/Path;I)V", "clipRect", "left", "", "top", "right", "bottom", "clipRect-N_I0leg", "(FFFFI)V", "inset", "rotate", "degrees", "pivot", "rotate-Uv8p0NA", "(FJ)V", "scale", "scaleX", "scaleY", "scale-0AR0LA0", "(FFJ)V", "transform", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "transform-58bKbWc", "([F)V", "translate", "ui-graphics_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CanvasDrawScope.kt */
public final class CanvasDrawScopeKt$asDrawTransform$1 implements DrawTransform {
    final /* synthetic */ DrawContext $this_asDrawTransform;

    CanvasDrawScopeKt$asDrawTransform$1(DrawContext drawContext) {
        this.$this_asDrawTransform = drawContext;
    }

    /* renamed from: getSize-NH-jbRc  reason: not valid java name */
    public long m2051getSizeNHjbRc() {
        return this.$this_asDrawTransform.m2070getSizeNHjbRc();
    }

    /* renamed from: getCenter-F1C5BW0  reason: not valid java name */
    public long m2050getCenterF1C5BW0() {
        return SizeKt.m1432getCenteruvyYCjk(m2051getSizeNHjbRc());
    }

    public void inset(float f, float f2, float f3, float f4) {
        Canvas canvas = this.$this_asDrawTransform.getCanvas();
        DrawContext drawContext = this.$this_asDrawTransform;
        long Size = SizeKt.Size(Size.m1422getWidthimpl(m2051getSizeNHjbRc()) - (f3 + f), Size.m1419getHeightimpl(m2051getSizeNHjbRc()) - (f4 + f2));
        if (Size.m1422getWidthimpl(Size) >= 0.0f && Size.m1419getHeightimpl(Size) >= 0.0f) {
            drawContext.m2071setSizeuvyYCjk(Size);
            canvas.translate(f, f2);
            return;
        }
        throw new IllegalArgumentException("Width and height must be greater than or equal to zero".toString());
    }

    /* renamed from: clipRect-N_I0leg  reason: not valid java name */
    public void m2049clipRectN_I0leg(float f, float f2, float f3, float f4, int i) {
        this.$this_asDrawTransform.getCanvas().m1562clipRectN_I0leg(f, f2, f3, f4, i);
    }

    /* renamed from: clipPath-mtrdD-E  reason: not valid java name */
    public void m2048clipPathmtrdDE(Path path, int i) {
        Intrinsics.checkNotNullParameter(path, ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH);
        this.$this_asDrawTransform.getCanvas().m1561clipPathmtrdDE(path, i);
    }

    public void translate(float f, float f2) {
        this.$this_asDrawTransform.getCanvas().translate(f, f2);
    }

    /* renamed from: rotate-Uv8p0NA  reason: not valid java name */
    public void m2052rotateUv8p0NA(float f, long j) {
        Canvas canvas = this.$this_asDrawTransform.getCanvas();
        canvas.translate(Offset.m1353getXimpl(j), Offset.m1354getYimpl(j));
        canvas.rotate(f);
        canvas.translate(-Offset.m1353getXimpl(j), -Offset.m1354getYimpl(j));
    }

    /* renamed from: scale-0AR0LA0  reason: not valid java name */
    public void m2053scale0AR0LA0(float f, float f2, long j) {
        Canvas canvas = this.$this_asDrawTransform.getCanvas();
        canvas.translate(Offset.m1353getXimpl(j), Offset.m1354getYimpl(j));
        canvas.scale(f, f2);
        canvas.translate(-Offset.m1353getXimpl(j), -Offset.m1354getYimpl(j));
    }

    /* renamed from: transform-58bKbWc  reason: not valid java name */
    public void m2054transform58bKbWc(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "matrix");
        this.$this_asDrawTransform.getCanvas().m1564concat58bKbWc(fArr);
    }
}
