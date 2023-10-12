package androidx.compose.ui.graphics;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.graphics.Path;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J \u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!H\u0016J \u0010#\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020!H\u0016J\u0010\u0010&\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001cH\u0016J%\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\u00012\u0006\u0010)\u001a\u00020*H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u000200H\u0016J(\u00101\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u00102\u001a\u00020\u000fH\u0016J\b\u00103\u001a\u00020\u001eH\u0016J8\u00104\u001a\u00020\u001e2\u0006\u00105\u001a\u00020!2\u0006\u00106\u001a\u00020!2\u0006\u00107\u001a\u00020!2\u0006\u00108\u001a\u00020!2\u0006\u00109\u001a\u00020!2\u0006\u0010:\u001a\u00020!H\u0016J\b\u0010;\u001a\u00020\u001cH\u0016J\u0018\u0010<\u001a\u00020\u001e2\u0006\u0010=\u001a\u00020!2\u0006\u0010>\u001a\u00020!H\u0016J\u0018\u0010?\u001a\u00020\u001e2\u0006\u0010=\u001a\u00020!2\u0006\u0010>\u001a\u00020!H\u0016J-\u0010@\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020\u00012\u0006\u0010B\u001a\u00020\u00012\u0006\u0010C\u001a\u00020DH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bE\u0010FJ(\u0010G\u001a\u00020\u001e2\u0006\u00105\u001a\u00020!2\u0006\u00106\u001a\u00020!2\u0006\u00107\u001a\u00020!2\u0006\u00108\u001a\u00020!H\u0016J8\u0010H\u001a\u00020\u001e2\u0006\u0010I\u001a\u00020!2\u0006\u0010J\u001a\u00020!2\u0006\u0010K\u001a\u00020!2\u0006\u0010L\u001a\u00020!2\u0006\u0010M\u001a\u00020!2\u0006\u0010N\u001a\u00020!H\u0016J\u0018\u0010O\u001a\u00020\u001e2\u0006\u0010P\u001a\u00020!2\u0006\u0010Q\u001a\u00020!H\u0016J\u0018\u0010R\u001a\u00020\u001e2\u0006\u0010P\u001a\u00020!2\u0006\u0010Q\u001a\u00020!H\u0016J(\u0010S\u001a\u00020\u001e2\u0006\u0010I\u001a\u00020!2\u0006\u0010J\u001a\u00020!2\u0006\u0010K\u001a\u00020!2\u0006\u0010L\u001a\u00020!H\u0016J\b\u0010T\u001a\u00020\u001eH\u0016J\u001d\u0010U\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020*H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bV\u0010WR-\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000f8VX\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0012R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006X"}, d2 = {"Landroidx/compose/ui/graphics/AndroidPath;", "Landroidx/compose/ui/graphics/Path;", "internalPath", "Landroid/graphics/Path;", "(Landroid/graphics/Path;)V", "value", "Landroidx/compose/ui/graphics/PathFillType;", "fillType", "getFillType-Rg-k1Os", "()I", "setFillType-oQ8Xj4U", "(I)V", "getInternalPath", "()Landroid/graphics/Path;", "isConvex", "", "isConvex$annotations", "()V", "()Z", "isEmpty", "mMatrix", "Landroid/graphics/Matrix;", "radii", "", "rectF", "Landroid/graphics/RectF;", "_rectIsValid", "rect", "Landroidx/compose/ui/geometry/Rect;", "addArc", "", "oval", "startAngleDegrees", "", "sweepAngleDegrees", "addArcRad", "startAngleRadians", "sweepAngleRadians", "addOval", "addPath", "path", "offset", "Landroidx/compose/ui/geometry/Offset;", "addPath-Uv8p0NA", "(Landroidx/compose/ui/graphics/Path;J)V", "addRect", "addRoundRect", "roundRect", "Landroidx/compose/ui/geometry/RoundRect;", "arcTo", "forceMoveTo", "close", "cubicTo", "x1", "y1", "x2", "y2", "x3", "y3", "getBounds", "lineTo", "x", "y", "moveTo", "op", "path1", "path2", "operation", "Landroidx/compose/ui/graphics/PathOperation;", "op-N5in7k0", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/Path;I)Z", "quadraticBezierTo", "relativeCubicTo", "dx1", "dy1", "dx2", "dy2", "dx3", "dy3", "relativeLineTo", "dx", "dy", "relativeMoveTo", "relativeQuadraticBezierTo", "reset", "translate", "translate-k-4lQ0M", "(J)V", "ui-graphics_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AndroidPath.android.kt */
public final class AndroidPath implements Path {
    private final Path internalPath;
    private final Matrix mMatrix;
    private final float[] radii;
    private final RectF rectF;

    public AndroidPath() {
        this((Path) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ void isConvex$annotations() {
    }

    public AndroidPath(Path path) {
        Intrinsics.checkNotNullParameter(path, "internalPath");
        this.internalPath = path;
        this.rectF = new RectF();
        this.radii = new float[8];
        this.mMatrix = new Matrix();
    }

    public void arcToRad(Rect rect, float f, float f2, boolean z) {
        Path.DefaultImpls.arcToRad(this, rect, f, f2, z);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AndroidPath(android.graphics.Path path, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new android.graphics.Path() : path);
    }

    public final android.graphics.Path getInternalPath() {
        return this.internalPath;
    }

    /* renamed from: getFillType-Rg-k1Os  reason: not valid java name */
    public int m1486getFillTypeRgk1Os() {
        if (this.internalPath.getFillType() == Path.FillType.EVEN_ODD) {
            return PathFillType.Companion.m1832getEvenOddRgk1Os();
        }
        return PathFillType.Companion.m1833getNonZeroRgk1Os();
    }

    /* renamed from: setFillType-oQ8Xj4U  reason: not valid java name */
    public void m1488setFillTypeoQ8Xj4U(int i) {
        Path.FillType fillType;
        android.graphics.Path path = this.internalPath;
        if (PathFillType.m1828equalsimpl0(i, PathFillType.Companion.m1832getEvenOddRgk1Os())) {
            fillType = Path.FillType.EVEN_ODD;
        } else {
            fillType = Path.FillType.WINDING;
        }
        path.setFillType(fillType);
    }

    public void moveTo(float f, float f2) {
        this.internalPath.moveTo(f, f2);
    }

    public void relativeMoveTo(float f, float f2) {
        this.internalPath.rMoveTo(f, f2);
    }

    public void lineTo(float f, float f2) {
        this.internalPath.lineTo(f, f2);
    }

    public void relativeLineTo(float f, float f2) {
        this.internalPath.rLineTo(f, f2);
    }

    public void quadraticBezierTo(float f, float f2, float f3, float f4) {
        this.internalPath.quadTo(f, f2, f3, f4);
    }

    public void relativeQuadraticBezierTo(float f, float f2, float f3, float f4) {
        this.internalPath.rQuadTo(f, f2, f3, f4);
    }

    public void cubicTo(float f, float f2, float f3, float f4, float f5, float f6) {
        this.internalPath.cubicTo(f, f2, f3, f4, f5, f6);
    }

    public void relativeCubicTo(float f, float f2, float f3, float f4, float f5, float f6) {
        this.internalPath.rCubicTo(f, f2, f3, f4, f5, f6);
    }

    public void arcTo(Rect rect, float f, float f2, boolean z) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        this.rectF.set(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom());
        this.internalPath.arcTo(this.rectF, f, f2, z);
    }

    public void addRect(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        if (_rectIsValid(rect)) {
            this.rectF.set(RectHelper_androidKt.toAndroidRectF(rect));
            this.internalPath.addRect(this.rectF, Path.Direction.CCW);
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public void addOval(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "oval");
        this.rectF.set(RectHelper_androidKt.toAndroidRect(rect));
        this.internalPath.addOval(this.rectF, Path.Direction.CCW);
    }

    public void addArcRad(Rect rect, float f, float f2) {
        Intrinsics.checkNotNullParameter(rect, "oval");
        addArc(rect, DegreesKt.degrees(f), DegreesKt.degrees(f2));
    }

    public void addArc(Rect rect, float f, float f2) {
        Intrinsics.checkNotNullParameter(rect, "oval");
        if (_rectIsValid(rect)) {
            this.rectF.set(RectHelper_androidKt.toAndroidRect(rect));
            this.internalPath.addArc(this.rectF, f, f2);
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public void addRoundRect(RoundRect roundRect) {
        Intrinsics.checkNotNullParameter(roundRect, "roundRect");
        this.rectF.set(roundRect.getLeft(), roundRect.getTop(), roundRect.getRight(), roundRect.getBottom());
        this.radii[0] = CornerRadius.m1328getXimpl(roundRect.m1403getTopLeftCornerRadiuskKHJgLs());
        this.radii[1] = CornerRadius.m1329getYimpl(roundRect.m1403getTopLeftCornerRadiuskKHJgLs());
        this.radii[2] = CornerRadius.m1328getXimpl(roundRect.m1404getTopRightCornerRadiuskKHJgLs());
        this.radii[3] = CornerRadius.m1329getYimpl(roundRect.m1404getTopRightCornerRadiuskKHJgLs());
        this.radii[4] = CornerRadius.m1328getXimpl(roundRect.m1402getBottomRightCornerRadiuskKHJgLs());
        this.radii[5] = CornerRadius.m1329getYimpl(roundRect.m1402getBottomRightCornerRadiuskKHJgLs());
        this.radii[6] = CornerRadius.m1328getXimpl(roundRect.m1401getBottomLeftCornerRadiuskKHJgLs());
        this.radii[7] = CornerRadius.m1329getYimpl(roundRect.m1401getBottomLeftCornerRadiuskKHJgLs());
        this.internalPath.addRoundRect(this.rectF, this.radii, Path.Direction.CCW);
    }

    /* renamed from: addPath-Uv8p0NA  reason: not valid java name */
    public void m1485addPathUv8p0NA(Path path, long j) {
        Intrinsics.checkNotNullParameter(path, ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH);
        android.graphics.Path path2 = this.internalPath;
        if (path instanceof AndroidPath) {
            path2.addPath(((AndroidPath) path).getInternalPath(), Offset.m1353getXimpl(j), Offset.m1354getYimpl(j));
            return;
        }
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    public void close() {
        this.internalPath.close();
    }

    public void reset() {
        this.internalPath.reset();
    }

    /* renamed from: translate-k-4lQ0M  reason: not valid java name */
    public void m1489translatek4lQ0M(long j) {
        this.mMatrix.reset();
        this.mMatrix.setTranslate(Offset.m1353getXimpl(j), Offset.m1354getYimpl(j));
        this.internalPath.transform(this.mMatrix);
    }

    public Rect getBounds() {
        this.internalPath.computeBounds(this.rectF, true);
        return new Rect(this.rectF.left, this.rectF.top, this.rectF.right, this.rectF.bottom);
    }

    /* renamed from: op-N5in7k0  reason: not valid java name */
    public boolean m1487opN5in7k0(Path path, Path path2, int i) {
        Path.Op op;
        Intrinsics.checkNotNullParameter(path, "path1");
        Intrinsics.checkNotNullParameter(path2, "path2");
        if (PathOperation.m1837equalsimpl0(i, PathOperation.Companion.m1841getDifferenceb3I0S0c())) {
            op = Path.Op.DIFFERENCE;
        } else if (PathOperation.m1837equalsimpl0(i, PathOperation.Companion.m1842getIntersectb3I0S0c())) {
            op = Path.Op.INTERSECT;
        } else if (PathOperation.m1837equalsimpl0(i, PathOperation.Companion.m1843getReverseDifferenceb3I0S0c())) {
            op = Path.Op.REVERSE_DIFFERENCE;
        } else if (PathOperation.m1837equalsimpl0(i, PathOperation.Companion.m1844getUnionb3I0S0c())) {
            op = Path.Op.UNION;
        } else {
            op = Path.Op.XOR;
        }
        android.graphics.Path path3 = this.internalPath;
        if (path instanceof AndroidPath) {
            android.graphics.Path internalPath2 = ((AndroidPath) path).getInternalPath();
            if (path2 instanceof AndroidPath) {
                return path3.op(internalPath2, ((AndroidPath) path2).getInternalPath(), op);
            }
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    public boolean isConvex() {
        return this.internalPath.isConvex();
    }

    public boolean isEmpty() {
        return this.internalPath.isEmpty();
    }

    private final boolean _rectIsValid(Rect rect) {
        if (!(!Float.isNaN(rect.getLeft()))) {
            throw new IllegalStateException("Rect.left is NaN".toString());
        } else if (!(!Float.isNaN(rect.getTop()))) {
            throw new IllegalStateException("Rect.top is NaN".toString());
        } else if (!(!Float.isNaN(rect.getRight()))) {
            throw new IllegalStateException("Rect.right is NaN".toString());
        } else if (!Float.isNaN(rect.getBottom())) {
            return true;
        } else {
            throw new IllegalStateException("Rect.bottom is NaN".toString());
        }
    }
}
