package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010/\u001a\u00020\bH\u0002J\b\u00100\u001a\u00020\u0019H\u0016J\f\u00101\u001a\u00020\b*\u00020\u0007H\u0016J\u001c\u00101\u001a\u00020\b*\u00020\u00072\u0006\u00102\u001a\u00020&2\b\u00103\u001a\u0004\u0018\u00010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R$\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u00198F@FX\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0019\u0010\u001f\u001a\u00020 X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010!R\u0011\u0010\"\u001a\u00020#¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R$\u0010'\u001a\u00020&2\u0006\u0010\u0018\u001a\u00020&@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u0010,\u001a\u00020&2\u0006\u0010\u0018\u001a\u00020&@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010)\"\u0004\b.\u0010+\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00064"}, d2 = {"Landroidx/compose/ui/graphics/vector/VectorComponent;", "Landroidx/compose/ui/graphics/vector/VNode;", "()V", "cacheDrawScope", "Landroidx/compose/ui/graphics/vector/DrawCache;", "drawVectorBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "Lkotlin/ExtensionFunctionType;", "intrinsicColorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "getIntrinsicColorFilter$ui_release", "()Landroidx/compose/ui/graphics/ColorFilter;", "setIntrinsicColorFilter$ui_release", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "invalidateCallback", "Lkotlin/Function0;", "getInvalidateCallback$ui_release", "()Lkotlin/jvm/functions/Function0;", "setInvalidateCallback$ui_release", "(Lkotlin/jvm/functions/Function0;)V", "isDirty", "", "value", "", "name", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "previousDrawSize", "Landroidx/compose/ui/geometry/Size;", "J", "root", "Landroidx/compose/ui/graphics/vector/GroupComponent;", "getRoot", "()Landroidx/compose/ui/graphics/vector/GroupComponent;", "", "viewportHeight", "getViewportHeight", "()F", "setViewportHeight", "(F)V", "viewportWidth", "getViewportWidth", "setViewportWidth", "doInvalidate", "toString", "draw", "alpha", "colorFilter", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Vector.kt */
public final class VectorComponent extends VNode {
    private final DrawCache cacheDrawScope = new DrawCache();
    private final Function1<DrawScope, Unit> drawVectorBlock = new VectorComponent$drawVectorBlock$1(this);
    private ColorFilter intrinsicColorFilter;
    private Function0<Unit> invalidateCallback = VectorComponent$invalidateCallback$1.INSTANCE;
    private boolean isDirty = true;
    private long previousDrawSize = Size.Companion.m1430getUnspecifiedNHjbRc();
    private final GroupComponent root;
    private float viewportHeight;
    private float viewportWidth;

    public VectorComponent() {
        super((DefaultConstructorMarker) null);
        GroupComponent groupComponent = new GroupComponent();
        groupComponent.setPivotX(0.0f);
        groupComponent.setPivotY(0.0f);
        groupComponent.setInvalidateListener$ui_release(new VectorComponent$root$1$1(this));
        this.root = groupComponent;
    }

    public final GroupComponent getRoot() {
        return this.root;
    }

    public final String getName() {
        return this.root.getName();
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.root.setName(str);
    }

    /* access modifiers changed from: private */
    public final void doInvalidate() {
        this.isDirty = true;
        this.invalidateCallback.invoke();
    }

    public final Function0<Unit> getInvalidateCallback$ui_release() {
        return this.invalidateCallback;
    }

    public final void setInvalidateCallback$ui_release(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.invalidateCallback = function0;
    }

    public final ColorFilter getIntrinsicColorFilter$ui_release() {
        return this.intrinsicColorFilter;
    }

    public final void setIntrinsicColorFilter$ui_release(ColorFilter colorFilter) {
        this.intrinsicColorFilter = colorFilter;
    }

    public final float getViewportWidth() {
        return this.viewportWidth;
    }

    public final void setViewportWidth(float f) {
        if (!(this.viewportWidth == f)) {
            this.viewportWidth = f;
            doInvalidate();
        }
    }

    public final float getViewportHeight() {
        return this.viewportHeight;
    }

    public final void setViewportHeight(float f) {
        if (!(this.viewportHeight == f)) {
            this.viewportHeight = f;
            doInvalidate();
        }
    }

    public final void draw(DrawScope drawScope, float f, ColorFilter colorFilter) {
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        if (colorFilter == null) {
            colorFilter = this.intrinsicColorFilter;
        }
        if (this.isDirty || !Size.m1418equalsimpl0(this.previousDrawSize, drawScope.m2092getSizeNHjbRc())) {
            this.root.setScaleX(Size.m1422getWidthimpl(drawScope.m2092getSizeNHjbRc()) / this.viewportWidth);
            this.root.setScaleY(Size.m1419getHeightimpl(drawScope.m2092getSizeNHjbRc()) / this.viewportHeight);
            this.cacheDrawScope.m2185drawCachedImageCJJARo(IntSizeKt.IntSize((int) ((float) Math.ceil((double) Size.m1422getWidthimpl(drawScope.m2092getSizeNHjbRc()))), (int) ((float) Math.ceil((double) Size.m1419getHeightimpl(drawScope.m2092getSizeNHjbRc())))), drawScope, drawScope.getLayoutDirection(), this.drawVectorBlock);
            this.isDirty = false;
            this.previousDrawSize = drawScope.m2092getSizeNHjbRc();
        }
        this.cacheDrawScope.drawInto(drawScope, f, colorFilter);
    }

    public void draw(DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        draw(drawScope, 1.0f, (ColorFilter) null);
    }

    public String toString() {
        String str = "Params: " + "\tname: " + getName() + "\n" + "\tviewportWidth: " + getViewportWidth() + "\n" + "\tviewportHeight: " + getViewportHeight() + "\n";
        Intrinsics.checkNotNullExpressionValue(str, "StringBuilder().apply(builderAction).toString()");
        return str;
    }
}
