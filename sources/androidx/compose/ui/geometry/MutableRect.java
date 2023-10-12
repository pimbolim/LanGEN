package androidx.compose.ui.geometry;

import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u001b\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001fø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b \u0010!J(\u0010\"\u001a\u00020#2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0007J&\u0010$\u001a\u00020#2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003J\b\u0010%\u001a\u00020&H\u0016R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\r\u0010\tR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\t\"\u0004\b\u0012\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR\u001a\u0010\u0015\u001a\u00020\u00168Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\t\"\u0004\b\u001a\u0010\u000bR\u0012\u0010\u001b\u001a\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001c\u0010\t\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006'"}, d2 = {"Landroidx/compose/ui/geometry/MutableRect;", "", "left", "", "top", "right", "bottom", "(FFFF)V", "getBottom", "()F", "setBottom", "(F)V", "height", "getHeight", "isEmpty", "", "()Z", "getLeft", "setLeft", "getRight", "setRight", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "()J", "getTop", "setTop", "width", "getWidth", "contains", "offset", "Landroidx/compose/ui/geometry/Offset;", "contains-k-4lQ0M", "(J)Z", "intersect", "", "set", "toString", "", "ui-geometry_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MutableRect.kt */
public final class MutableRect {
    private float bottom;
    private float left;
    private float right;
    private float top;

    public MutableRect(float f, float f2, float f3, float f4) {
        this.left = f;
        this.top = f2;
        this.right = f3;
        this.bottom = f4;
    }

    public final float getLeft() {
        return this.left;
    }

    public final void setLeft(float f) {
        this.left = f;
    }

    public final float getTop() {
        return this.top;
    }

    public final void setTop(float f) {
        this.top = f;
    }

    public final float getRight() {
        return this.right;
    }

    public final void setRight(float f) {
        this.right = f;
    }

    public final float getBottom() {
        return this.bottom;
    }

    public final void setBottom(float f) {
        this.bottom = f;
    }

    public final float getWidth() {
        return getRight() - getLeft();
    }

    public final float getHeight() {
        return getBottom() - getTop();
    }

    public final boolean isEmpty() {
        return this.left >= this.right || this.top >= this.bottom;
    }

    public final void intersect(float f, float f2, float f3, float f4) {
        this.left = Math.max(f, this.left);
        this.top = Math.max(f2, this.top);
        this.right = Math.min(f3, this.right);
        this.bottom = Math.min(f4, this.bottom);
    }

    /* renamed from: contains-k-4lQ0M  reason: not valid java name */
    public final boolean m1340containsk4lQ0M(long j) {
        return Offset.m1353getXimpl(j) >= this.left && Offset.m1353getXimpl(j) < this.right && Offset.m1354getYimpl(j) >= this.top && Offset.m1354getYimpl(j) < this.bottom;
    }

    public final void set(float f, float f2, float f3, float f4) {
        this.left = f;
        this.top = f2;
        this.right = f3;
        this.bottom = f4;
    }

    public String toString() {
        return "MutableRect(" + GeometryUtilsKt.toStringAsFixed(this.left, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.top, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.right, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.bottom, 1) + ')';
    }

    /* renamed from: getSize-NH-jbRc  reason: not valid java name */
    public final long m1341getSizeNHjbRc() {
        return SizeKt.Size(getRight() - getLeft(), getBottom() - getTop());
    }
}
