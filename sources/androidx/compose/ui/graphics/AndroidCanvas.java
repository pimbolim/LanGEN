package androidx.compose.ui.graphics;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Region;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J%\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ=\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010#J\u001d\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020&H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b'\u0010(J\b\u0010)\u001a\u00020\u0015H\u0016JH\u0010*\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0016J-\u00101\u001a\u00020\u00152\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u001e2\u0006\u0010/\u001a\u000200H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b5\u00106J-\u00107\u001a\u00020\u00152\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u0002032\u0006\u0010/\u001a\u000200H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b;\u0010<JE\u0010=\u001a\u00020\u00152\u0006\u00108\u001a\u0002092\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020?2\u0006\u0010C\u001a\u00020A2\u0006\u0010/\u001a\u000200H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bD\u0010EJ-\u0010F\u001a\u00020\u00152\u0006\u0010G\u001a\u0002032\u0006\u0010H\u001a\u0002032\u0006\u0010/\u001a\u000200H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bI\u0010JJ)\u0010K\u001a\u00020\u00152\f\u0010L\u001a\b\u0012\u0004\u0012\u0002030M2\u0006\u0010/\u001a\u0002002\u0006\u0010N\u001a\u00020OH\u0002ø\u0001\u0000J0\u0010P\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u001e2\u0006\u0010/\u001a\u000200H\u0016J\u0018\u0010Q\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010/\u001a\u000200H\u0016J3\u0010R\u001a\u00020\u00152\u0006\u0010S\u001a\u00020T2\f\u0010L\u001a\b\u0012\u0004\u0012\u0002030M2\u0006\u0010/\u001a\u000200H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bU\u0010VJ!\u0010R\u001a\u00020\u00152\f\u0010L\u001a\b\u0012\u0004\u0012\u0002030M2\u0006\u0010/\u001a\u000200H\u0002ø\u0001\u0000J \u0010W\u001a\u00020\u00152\u0006\u0010L\u001a\u00020X2\u0006\u0010/\u001a\u0002002\u0006\u0010N\u001a\u00020OH\u0002J-\u0010Y\u001a\u00020\u00152\u0006\u0010S\u001a\u00020T2\u0006\u0010L\u001a\u00020X2\u0006\u0010/\u001a\u000200H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bZ\u0010[J \u0010Y\u001a\u00020\u00152\u0006\u0010L\u001a\u00020X2\u0006\u0010/\u001a\u0002002\u0006\u0010N\u001a\u00020OH\u0002J0\u0010\\\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u001e2\u0006\u0010/\u001a\u000200H\u0016J@\u0010]\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u001e2\u0006\u0010^\u001a\u00020\u001e2\u0006\u0010_\u001a\u00020\u001e2\u0006\u0010/\u001a\u000200H\u0016J-\u0010`\u001a\u00020\u00152\u0006\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020d2\u0006\u0010/\u001a\u000200H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\be\u0010fJ\b\u0010g\u001a\u00020\u0015H\u0016J\b\u0010h\u001a\u00020\u0015H\u0016J\u0010\u0010i\u001a\u00020\u00152\u0006\u0010j\u001a\u00020\u001eH\u0016J\b\u0010k\u001a\u00020\u0015H\u0016J\u0018\u0010l\u001a\u00020\u00152\u0006\u0010m\u001a\u00020n2\u0006\u0010/\u001a\u000200H\u0016J\u0018\u0010o\u001a\u00020\u00152\u0006\u0010p\u001a\u00020\u001e2\u0006\u0010q\u001a\u00020\u001eH\u0016J\u0018\u0010r\u001a\u00020\u00152\u0006\u0010p\u001a\u00020\u001e2\u0006\u0010q\u001a\u00020\u001eH\u0016J\u0018\u0010s\u001a\u00020\u00152\u0006\u0010t\u001a\u00020\u001e2\u0006\u0010u\u001a\u00020\u001eH\u0016J\u0017\u0010v\u001a\u00020w*\u00020\u0019ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bx\u0010yR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R(\u0010\t\u001a\u00060\nj\u0002`\u000b8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\f\u0010\u0002\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\b\u001a\u0004\b\u0012\u0010\u0006\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006z"}, d2 = {"Landroidx/compose/ui/graphics/AndroidCanvas;", "Landroidx/compose/ui/graphics/Canvas;", "()V", "dstRect", "Landroid/graphics/Rect;", "getDstRect", "()Landroid/graphics/Rect;", "dstRect$delegate", "Lkotlin/Lazy;", "internalCanvas", "Landroid/graphics/Canvas;", "Landroidx/compose/ui/graphics/NativeCanvas;", "getInternalCanvas$annotations", "getInternalCanvas", "()Landroid/graphics/Canvas;", "setInternalCanvas", "(Landroid/graphics/Canvas;)V", "srcRect", "getSrcRect", "srcRect$delegate", "clipPath", "", "path", "Landroidx/compose/ui/graphics/Path;", "clipOp", "Landroidx/compose/ui/graphics/ClipOp;", "clipPath-mtrdD-E", "(Landroidx/compose/ui/graphics/Path;I)V", "clipRect", "left", "", "top", "right", "bottom", "clipRect-N_I0leg", "(FFFFI)V", "concat", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "concat-58bKbWc", "([F)V", "disableZ", "drawArc", "startAngle", "sweepAngle", "useCenter", "", "paint", "Landroidx/compose/ui/graphics/Paint;", "drawCircle", "center", "Landroidx/compose/ui/geometry/Offset;", "radius", "drawCircle-9KIMszo", "(JFLandroidx/compose/ui/graphics/Paint;)V", "drawImage", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "topLeftOffset", "drawImage-d-4ec7I", "(Landroidx/compose/ui/graphics/ImageBitmap;JLandroidx/compose/ui/graphics/Paint;)V", "drawImageRect", "srcOffset", "Landroidx/compose/ui/unit/IntOffset;", "srcSize", "Landroidx/compose/ui/unit/IntSize;", "dstOffset", "dstSize", "drawImageRect-HPBpro0", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJLandroidx/compose/ui/graphics/Paint;)V", "drawLine", "p1", "p2", "drawLine-Wko1d7g", "(JJLandroidx/compose/ui/graphics/Paint;)V", "drawLines", "points", "", "stepBy", "", "drawOval", "drawPath", "drawPoints", "pointMode", "Landroidx/compose/ui/graphics/PointMode;", "drawPoints-O7TthRY", "(ILjava/util/List;Landroidx/compose/ui/graphics/Paint;)V", "drawRawLines", "", "drawRawPoints", "drawRawPoints-O7TthRY", "(I[FLandroidx/compose/ui/graphics/Paint;)V", "drawRect", "drawRoundRect", "radiusX", "radiusY", "drawVertices", "vertices", "Landroidx/compose/ui/graphics/Vertices;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawVertices-TPEHhCM", "(Landroidx/compose/ui/graphics/Vertices;ILandroidx/compose/ui/graphics/Paint;)V", "enableZ", "restore", "rotate", "degrees", "save", "saveLayer", "bounds", "Landroidx/compose/ui/geometry/Rect;", "scale", "sx", "sy", "skew", "translate", "dx", "dy", "toRegionOp", "Landroid/graphics/Region$Op;", "toRegionOp--7u2Bmg", "(I)Landroid/graphics/Region$Op;", "ui-graphics_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AndroidCanvas.android.kt */
public final class AndroidCanvas implements Canvas {
    private final Lazy dstRect$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, AndroidCanvas$dstRect$2.INSTANCE);
    private Canvas internalCanvas = AndroidCanvas_androidKt.EmptyCanvas;
    private final Lazy srcRect$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, AndroidCanvas$srcRect$2.INSTANCE);

    public static /* synthetic */ void getInternalCanvas$annotations() {
    }

    /* renamed from: clipRect-mtrdD-E  reason: not valid java name */
    public void m1449clipRectmtrdDE(Rect rect, int i) {
        Canvas.DefaultImpls.m1574clipRectmtrdDE(this, rect, i);
    }

    public void drawArc(Rect rect, float f, float f2, boolean z, Paint paint) {
        Canvas.DefaultImpls.drawArc(this, rect, f, f2, z, paint);
    }

    public void drawArcRad(Rect rect, float f, float f2, boolean z, Paint paint) {
        Canvas.DefaultImpls.drawArcRad(this, rect, f, f2, z, paint);
    }

    public void drawOval(Rect rect, Paint paint) {
        Canvas.DefaultImpls.drawOval(this, rect, paint);
    }

    public void drawRect(Rect rect, Paint paint) {
        Canvas.DefaultImpls.drawRect(this, rect, paint);
    }

    public void skewRad(float f, float f2) {
        Canvas.DefaultImpls.skewRad(this, f, f2);
    }

    public final android.graphics.Canvas getInternalCanvas() {
        return this.internalCanvas;
    }

    public final void setInternalCanvas(android.graphics.Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "<set-?>");
        this.internalCanvas = canvas;
    }

    private final android.graphics.Rect getSrcRect() {
        return (android.graphics.Rect) this.srcRect$delegate.getValue();
    }

    private final android.graphics.Rect getDstRect() {
        return (android.graphics.Rect) this.dstRect$delegate.getValue();
    }

    public void save() {
        this.internalCanvas.save();
    }

    public void restore() {
        this.internalCanvas.restore();
    }

    public void saveLayer(Rect rect, Paint paint) {
        Intrinsics.checkNotNullParameter(rect, "bounds");
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.internalCanvas.saveLayer(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), paint.asFrameworkPaint(), 31);
    }

    public void translate(float f, float f2) {
        this.internalCanvas.translate(f, f2);
    }

    public void scale(float f, float f2) {
        this.internalCanvas.scale(f, f2);
    }

    public void rotate(float f) {
        this.internalCanvas.rotate(f);
    }

    public void skew(float f, float f2) {
        this.internalCanvas.skew(f, f2);
    }

    /* renamed from: concat-58bKbWc  reason: not valid java name */
    public void m1450concat58bKbWc(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "matrix");
        if (!MatrixKt.m1791isIdentity58bKbWc(fArr)) {
            Matrix matrix = new Matrix();
            AndroidMatrixConversions_androidKt.m1465setFromEL8BTi8(matrix, fArr);
            this.internalCanvas.concat(matrix);
        }
    }

    /* renamed from: clipRect-N_I0leg  reason: not valid java name */
    public void m1448clipRectN_I0leg(float f, float f2, float f3, float f4, int i) {
        this.internalCanvas.clipRect(f, f2, f3, f4, m1458toRegionOp7u2Bmg(i));
    }

    /* renamed from: clipPath-mtrdD-E  reason: not valid java name */
    public void m1447clipPathmtrdDE(Path path, int i) {
        Intrinsics.checkNotNullParameter(path, ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH);
        android.graphics.Canvas canvas = this.internalCanvas;
        if (path instanceof AndroidPath) {
            canvas.clipPath(((AndroidPath) path).getInternalPath(), m1458toRegionOp7u2Bmg(i));
            return;
        }
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    /* renamed from: toRegionOp--7u2Bmg  reason: not valid java name */
    public final Region.Op m1458toRegionOp7u2Bmg(int i) {
        if (ClipOp.m1580equalsimpl0(i, ClipOp.Companion.m1584getDifferencertfAjoo())) {
            return Region.Op.DIFFERENCE;
        }
        return Region.Op.INTERSECT;
    }

    /* renamed from: drawLine-Wko1d7g  reason: not valid java name */
    public void m1454drawLineWko1d7g(long j, long j2, Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.internalCanvas.drawLine(Offset.m1353getXimpl(j), Offset.m1354getYimpl(j), Offset.m1353getXimpl(j2), Offset.m1354getYimpl(j2), paint.asFrameworkPaint());
    }

    public void drawRect(float f, float f2, float f3, float f4, Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.internalCanvas.drawRect(f, f2, f3, f4, paint.asFrameworkPaint());
    }

    public void drawRoundRect(float f, float f2, float f3, float f4, float f5, float f6, Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.internalCanvas.drawRoundRect(f, f2, f3, f4, f5, f6, paint.asFrameworkPaint());
    }

    public void drawOval(float f, float f2, float f3, float f4, Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.internalCanvas.drawOval(f, f2, f3, f4, paint.asFrameworkPaint());
    }

    /* renamed from: drawCircle-9KIMszo  reason: not valid java name */
    public void m1451drawCircle9KIMszo(long j, float f, Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.internalCanvas.drawCircle(Offset.m1353getXimpl(j), Offset.m1354getYimpl(j), f, paint.asFrameworkPaint());
    }

    public void drawArc(float f, float f2, float f3, float f4, float f5, float f6, boolean z, Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.internalCanvas.drawArc(f, f2, f3, f4, f5, f6, z, paint.asFrameworkPaint());
    }

    public void drawPath(Path path, Paint paint) {
        Intrinsics.checkNotNullParameter(path, ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH);
        Intrinsics.checkNotNullParameter(paint, "paint");
        android.graphics.Canvas canvas = this.internalCanvas;
        if (path instanceof AndroidPath) {
            canvas.drawPath(((AndroidPath) path).getInternalPath(), paint.asFrameworkPaint());
            return;
        }
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    /* renamed from: drawImage-d-4ec7I  reason: not valid java name */
    public void m1452drawImaged4ec7I(ImageBitmap imageBitmap, long j, Paint paint) {
        Intrinsics.checkNotNullParameter(imageBitmap, "image");
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.internalCanvas.drawBitmap(AndroidImageBitmap_androidKt.asAndroidBitmap(imageBitmap), Offset.m1353getXimpl(j), Offset.m1354getYimpl(j), paint.asFrameworkPaint());
    }

    /* renamed from: drawImageRect-HPBpro0  reason: not valid java name */
    public void m1453drawImageRectHPBpro0(ImageBitmap imageBitmap, long j, long j2, long j3, long j4, Paint paint) {
        Intrinsics.checkNotNullParameter(imageBitmap, "image");
        Intrinsics.checkNotNullParameter(paint, "paint");
        android.graphics.Canvas canvas = this.internalCanvas;
        Bitmap asAndroidBitmap = AndroidImageBitmap_androidKt.asAndroidBitmap(imageBitmap);
        android.graphics.Rect srcRect = getSrcRect();
        srcRect.left = IntOffset.m3977getXimpl(j);
        srcRect.top = IntOffset.m3978getYimpl(j);
        srcRect.right = IntOffset.m3977getXimpl(j) + IntSize.m4019getWidthimpl(j2);
        srcRect.bottom = IntOffset.m3978getYimpl(j) + IntSize.m4018getHeightimpl(j2);
        Unit unit = Unit.INSTANCE;
        android.graphics.Rect dstRect = getDstRect();
        dstRect.left = IntOffset.m3977getXimpl(j3);
        dstRect.top = IntOffset.m3978getYimpl(j3);
        dstRect.right = IntOffset.m3977getXimpl(j3) + IntSize.m4019getWidthimpl(j4);
        dstRect.bottom = IntOffset.m3978getYimpl(j3) + IntSize.m4018getHeightimpl(j4);
        Unit unit2 = Unit.INSTANCE;
        canvas.drawBitmap(asAndroidBitmap, srcRect, dstRect, paint.asFrameworkPaint());
    }

    /* renamed from: drawPoints-O7TthRY  reason: not valid java name */
    public void m1455drawPointsO7TthRY(int i, List<Offset> list, Paint paint) {
        Intrinsics.checkNotNullParameter(list, "points");
        Intrinsics.checkNotNullParameter(paint, "paint");
        if (PointMode.m1850equalsimpl0(i, PointMode.Companion.m1854getLinesr_lszbg())) {
            drawLines(list, paint, 2);
        } else if (PointMode.m1850equalsimpl0(i, PointMode.Companion.m1856getPolygonr_lszbg())) {
            drawLines(list, paint, 1);
        } else if (PointMode.m1850equalsimpl0(i, PointMode.Companion.m1855getPointsr_lszbg())) {
            drawPoints(list, paint);
        }
    }

    public void enableZ() {
        CanvasUtils.INSTANCE.enableZ(this.internalCanvas, true);
    }

    public void disableZ() {
        CanvasUtils.INSTANCE.enableZ(this.internalCanvas, false);
    }

    private final void drawLines(List<Offset> list, Paint paint, int i) {
        List<Offset> list2 = list;
        if (list.size() >= 2) {
            IntProgression step = RangesKt.step((IntProgression) RangesKt.until(0, list.size() - 1), i);
            int first = step.getFirst();
            int last = step.getLast();
            int step2 = step.getStep();
            if ((step2 > 0 && first <= last) || (step2 < 0 && last <= first)) {
                while (true) {
                    int i2 = first + step2;
                    long r5 = list2.get(first).m1363unboximpl();
                    long r7 = list2.get(first + 1).m1363unboximpl();
                    this.internalCanvas.drawLine(Offset.m1353getXimpl(r5), Offset.m1354getYimpl(r5), Offset.m1353getXimpl(r7), Offset.m1354getYimpl(r7), paint.asFrameworkPaint());
                    if (first != last) {
                        first = i2;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    /* renamed from: drawRawPoints-O7TthRY  reason: not valid java name */
    public void m1456drawRawPointsO7TthRY(int i, float[] fArr, Paint paint) {
        Intrinsics.checkNotNullParameter(fArr, "points");
        Intrinsics.checkNotNullParameter(paint, "paint");
        if (fArr.length % 2 != 0) {
            throw new IllegalArgumentException("points must have an even number of values");
        } else if (PointMode.m1850equalsimpl0(i, PointMode.Companion.m1854getLinesr_lszbg())) {
            drawRawLines(fArr, paint, 2);
        } else if (PointMode.m1850equalsimpl0(i, PointMode.Companion.m1856getPolygonr_lszbg())) {
            drawRawLines(fArr, paint, 1);
        } else if (PointMode.m1850equalsimpl0(i, PointMode.Companion.m1855getPointsr_lszbg())) {
            drawRawPoints(fArr, paint, 2);
        }
    }

    private final void drawRawPoints(float[] fArr, Paint paint, int i) {
        if (fArr.length % 2 == 0) {
            IntProgression step = RangesKt.step((IntProgression) RangesKt.until(0, fArr.length - 1), i);
            int first = step.getFirst();
            int last = step.getLast();
            int step2 = step.getStep();
            if ((step2 > 0 && first <= last) || (step2 < 0 && last <= first)) {
                while (true) {
                    int i2 = first + step2;
                    this.internalCanvas.drawPoint(fArr[first], fArr[first + 1], paint.asFrameworkPaint());
                    if (first != last) {
                        first = i2;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    private final void drawRawLines(float[] fArr, Paint paint, int i) {
        if (fArr.length >= 4 && fArr.length % 2 == 0) {
            IntProgression step = RangesKt.step((IntProgression) RangesKt.until(0, fArr.length - 3), i * 2);
            int first = step.getFirst();
            int last = step.getLast();
            int step2 = step.getStep();
            if ((step2 > 0 && first <= last) || (step2 < 0 && last <= first)) {
                while (true) {
                    int i2 = first + step2;
                    this.internalCanvas.drawLine(fArr[first], fArr[first + 1], fArr[first + 2], fArr[first + 3], paint.asFrameworkPaint());
                    if (first != last) {
                        first = i2;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    /* renamed from: drawVertices-TPEHhCM  reason: not valid java name */
    public void m1457drawVerticesTPEHhCM(Vertices vertices, int i, Paint paint) {
        Intrinsics.checkNotNullParameter(vertices, "vertices");
        Intrinsics.checkNotNullParameter(paint, "paint");
        android.graphics.Canvas canvas = this.internalCanvas;
        Canvas.VertexMode r4 = AndroidVertexMode_androidKt.m1498toAndroidVertexModeJOOmi9M(vertices.m1966getVertexModec2xauaI());
        int length = vertices.getPositions().length;
        float[] positions = vertices.getPositions();
        canvas.drawVertices(r4, length, positions, 0, vertices.getTextureCoordinates(), 0, vertices.getColors(), 0, vertices.getIndices(), 0, vertices.getIndices().length, paint.asFrameworkPaint());
    }

    private final void drawPoints(List<Offset> list, Paint paint) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            long r3 = list.get(i).m1363unboximpl();
            getInternalCanvas().drawPoint(Offset.m1353getXimpl(r3), Offset.m1354getYimpl(r3), paint.asFrameworkPaint());
        }
    }
}
