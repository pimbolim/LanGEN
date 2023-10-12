package androidx.compose.ui.viewinterop;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.Region;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.input.pointer.PointerInteropFilter_androidKt;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.WindowRecomposer_androidKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\b \u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010H\u001a\u00020\u000f2\b\u0010I\u001a\u0004\u0018\u00010JH\u0016J\n\u0010K\u001a\u0004\u0018\u00010LH\u0016J\u001e\u0010M\u001a\u0004\u0018\u00010N2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010O\u001a\u0004\u0018\u00010PH\u0016J \u0010Q\u001a\u00020\u00112\u0006\u0010R\u001a\u00020\u00112\u0006\u0010S\u001a\u00020\u00112\u0006\u0010T\u001a\u00020\u0011H\u0002J\b\u0010U\u001a\u00020'H\u0014J\u0018\u0010V\u001a\u00020'2\u0006\u0010W\u001a\u00020B2\u0006\u0010X\u001a\u00020BH\u0016J\b\u0010Y\u001a\u00020'H\u0014J0\u0010Z\u001a\u00020'2\u0006\u0010[\u001a\u00020\u000f2\u0006\u0010\\\u001a\u00020\u00112\u0006\u0010]\u001a\u00020\u00112\u0006\u0010^\u001a\u00020\u00112\u0006\u0010_\u001a\u00020\u0011H\u0014J\u0018\u0010`\u001a\u00020'2\u0006\u0010a\u001a\u00020\u00112\u0006\u0010b\u001a\u00020\u0011H\u0014J\u0006\u0010c\u001a\u00020'J\u0010\u0010d\u001a\u00020'2\u0006\u0010e\u001a\u00020\u000fH\u0016J\b\u0010f\u001a\u00020\u000fH\u0016R$\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R(\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0007\u001a\u0004\u0018\u00010\u0017@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R$\u0010 \u001a\u00020\u001f2\u0006\u0010\u0007\u001a\u00020\u001f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020'0&X\u0004¢\u0006\u0002\n\u0000R(\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020'\u0018\u00010&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R(\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020'\u0018\u00010&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010*\"\u0004\b/\u0010,R(\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020'\u0018\u00010&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010*\"\u0004\b2\u0010,R\u0014\u00103\u001a\b\u0012\u0004\u0012\u00020'04X\u0004¢\u0006\u0002\n\u0000R(\u00106\u001a\u0004\u0018\u0001052\b\u0010\u0007\u001a\u0004\u0018\u000105@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u000e\u0010;\u001a\u00020<X\u0004¢\u0006\u0002\n\u0000R0\u0010=\u001a\b\u0012\u0004\u0012\u00020'042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020'04@DX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR(\u0010C\u001a\u0004\u0018\u00010B2\b\u0010\u0007\u001a\u0004\u0018\u00010B@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010G¨\u0006g"}, d2 = {"Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "parentContext", "Landroidx/compose/runtime/CompositionContext;", "(Landroid/content/Context;Landroidx/compose/runtime/CompositionContext;)V", "value", "Landroidx/compose/ui/unit/Density;", "density", "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "hasUpdateBlock", "", "lastHeightMeasureSpec", "", "lastWidthMeasureSpec", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "setLifecycleOwner", "(Landroidx/lifecycle/LifecycleOwner;)V", "location", "", "Landroidx/compose/ui/Modifier;", "modifier", "getModifier", "()Landroidx/compose/ui/Modifier;", "setModifier", "(Landroidx/compose/ui/Modifier;)V", "onCommitAffectingUpdate", "Lkotlin/Function1;", "", "onDensityChanged", "getOnDensityChanged$ui_release", "()Lkotlin/jvm/functions/Function1;", "setOnDensityChanged$ui_release", "(Lkotlin/jvm/functions/Function1;)V", "onModifierChanged", "getOnModifierChanged$ui_release", "setOnModifierChanged$ui_release", "onRequestDisallowInterceptTouchEvent", "getOnRequestDisallowInterceptTouchEvent$ui_release", "setOnRequestDisallowInterceptTouchEvent$ui_release", "runUpdate", "Lkotlin/Function0;", "Landroidx/savedstate/SavedStateRegistryOwner;", "savedStateRegistryOwner", "getSavedStateRegistryOwner", "()Landroidx/savedstate/SavedStateRegistryOwner;", "setSavedStateRegistryOwner", "(Landroidx/savedstate/SavedStateRegistryOwner;)V", "snapshotObserver", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "update", "getUpdate", "()Lkotlin/jvm/functions/Function0;", "setUpdate", "(Lkotlin/jvm/functions/Function0;)V", "Landroid/view/View;", "view", "getView", "()Landroid/view/View;", "setView$ui_release", "(Landroid/view/View;)V", "gatherTransparentRegion", "region", "Landroid/graphics/Region;", "getLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "invalidateChildInParent", "Landroid/view/ViewParent;", "dirty", "Landroid/graphics/Rect;", "obtainMeasureSpec", "min", "max", "preferred", "onAttachedToWindow", "onDescendantInvalidated", "child", "target", "onDetachedFromWindow", "onLayout", "changed", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "remeasure", "requestDisallowInterceptTouchEvent", "disallowIntercept", "shouldDelayChildPressedState", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AndroidViewHolder.android.kt */
public abstract class AndroidViewHolder extends ViewGroup {
    private Density density;
    /* access modifiers changed from: private */
    public boolean hasUpdateBlock;
    private int lastHeightMeasureSpec;
    private int lastWidthMeasureSpec;
    private final LayoutNode layoutNode;
    private LifecycleOwner lifecycleOwner;
    private final int[] location;
    private Modifier modifier;
    /* access modifiers changed from: private */
    public final Function1<AndroidViewHolder, Unit> onCommitAffectingUpdate;
    private Function1<? super Density, Unit> onDensityChanged;
    private Function1<? super Modifier, Unit> onModifierChanged;
    private Function1<? super Boolean, Unit> onRequestDisallowInterceptTouchEvent;
    /* access modifiers changed from: private */
    public final Function0<Unit> runUpdate;
    private SavedStateRegistryOwner savedStateRegistryOwner;
    /* access modifiers changed from: private */
    public final SnapshotStateObserver snapshotObserver;
    private Function0<Unit> update;
    private View view;

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidViewHolder(Context context, CompositionContext compositionContext) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        if (compositionContext != null) {
            WindowRecomposer_androidKt.setCompositionContext(this, compositionContext);
        }
        setSaveFromParentEnabled(false);
        this.update = AndroidViewHolder$update$1.INSTANCE;
        this.modifier = Modifier.Companion;
        this.density = DensityKt.Density$default(1.0f, 0.0f, 2, (Object) null);
        this.snapshotObserver = new SnapshotStateObserver(new AndroidViewHolder$snapshotObserver$1(this));
        this.onCommitAffectingUpdate = new AndroidViewHolder$onCommitAffectingUpdate$1(this);
        this.runUpdate = new AndroidViewHolder$runUpdate$1(this);
        this.location = new int[2];
        this.lastWidthMeasureSpec = Integer.MIN_VALUE;
        this.lastHeightMeasureSpec = Integer.MIN_VALUE;
        AndroidViewHolder androidViewHolder = this;
        LayoutNode layoutNode2 = new LayoutNode(false, 1, (DefaultConstructorMarker) null);
        Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(DrawModifierKt.drawBehind(PointerInteropFilter_androidKt.pointerInteropFilter(Modifier.Companion, androidViewHolder), new AndroidViewHolder$layoutNode$1$coreModifier$1(layoutNode2, this)), new AndroidViewHolder$layoutNode$1$coreModifier$2(androidViewHolder, layoutNode2));
        layoutNode2.setModifier(androidViewHolder.getModifier().then(onGloballyPositioned));
        androidViewHolder.setOnModifierChanged$ui_release(new AndroidViewHolder$layoutNode$1$1(layoutNode2, onGloballyPositioned));
        layoutNode2.setDensity(androidViewHolder.getDensity());
        androidViewHolder.setOnDensityChanged$ui_release(new AndroidViewHolder$layoutNode$1$2(layoutNode2));
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        layoutNode2.setOnAttach$ui_release(new AndroidViewHolder$layoutNode$1$3(androidViewHolder, layoutNode2, objectRef));
        layoutNode2.setOnDetach$ui_release(new AndroidViewHolder$layoutNode$1$4(androidViewHolder, objectRef));
        layoutNode2.setMeasurePolicy(new AndroidViewHolder$layoutNode$1$5(androidViewHolder, layoutNode2));
        this.layoutNode = layoutNode2;
    }

    public final View getView() {
        return this.view;
    }

    public final void setView$ui_release(View view2) {
        if (view2 != this.view) {
            this.view = view2;
            removeAllViews();
            if (view2 != null) {
                addView(view2);
                this.runUpdate.invoke();
            }
        }
    }

    public final Function0<Unit> getUpdate() {
        return this.update;
    }

    /* access modifiers changed from: protected */
    public final void setUpdate(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "value");
        this.update = function0;
        this.hasUpdateBlock = true;
        this.runUpdate.invoke();
    }

    public final Modifier getModifier() {
        return this.modifier;
    }

    public final void setModifier(Modifier modifier2) {
        Intrinsics.checkNotNullParameter(modifier2, "value");
        if (modifier2 != this.modifier) {
            this.modifier = modifier2;
            Function1<? super Modifier, Unit> function1 = this.onModifierChanged;
            if (function1 != null) {
                function1.invoke(modifier2);
            }
        }
    }

    public final Function1<Modifier, Unit> getOnModifierChanged$ui_release() {
        return this.onModifierChanged;
    }

    public final void setOnModifierChanged$ui_release(Function1<? super Modifier, Unit> function1) {
        this.onModifierChanged = function1;
    }

    public final Density getDensity() {
        return this.density;
    }

    public final void setDensity(Density density2) {
        Intrinsics.checkNotNullParameter(density2, "value");
        if (density2 != this.density) {
            this.density = density2;
            Function1<? super Density, Unit> function1 = this.onDensityChanged;
            if (function1 != null) {
                function1.invoke(density2);
            }
        }
    }

    public final Function1<Density, Unit> getOnDensityChanged$ui_release() {
        return this.onDensityChanged;
    }

    public final void setOnDensityChanged$ui_release(Function1<? super Density, Unit> function1) {
        this.onDensityChanged = function1;
    }

    public final LifecycleOwner getLifecycleOwner() {
        return this.lifecycleOwner;
    }

    public final void setLifecycleOwner(LifecycleOwner lifecycleOwner2) {
        if (lifecycleOwner2 != this.lifecycleOwner) {
            this.lifecycleOwner = lifecycleOwner2;
            ViewTreeLifecycleOwner.set(this, lifecycleOwner2);
        }
    }

    public final SavedStateRegistryOwner getSavedStateRegistryOwner() {
        return this.savedStateRegistryOwner;
    }

    public final void setSavedStateRegistryOwner(SavedStateRegistryOwner savedStateRegistryOwner2) {
        if (savedStateRegistryOwner2 != this.savedStateRegistryOwner) {
            this.savedStateRegistryOwner = savedStateRegistryOwner2;
            ViewTreeSavedStateRegistryOwner.set(this, savedStateRegistryOwner2);
        }
    }

    public final Function1<Boolean, Unit> getOnRequestDisallowInterceptTouchEvent$ui_release() {
        return this.onRequestDisallowInterceptTouchEvent;
    }

    public final void setOnRequestDisallowInterceptTouchEvent$ui_release(Function1<? super Boolean, Unit> function1) {
        this.onRequestDisallowInterceptTouchEvent = function1;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        View view2 = this.view;
        if (view2 != null) {
            view2.measure(i, i2);
        }
        View view3 = this.view;
        int i3 = 0;
        int measuredWidth = view3 == null ? 0 : view3.getMeasuredWidth();
        View view4 = this.view;
        if (view4 != null) {
            i3 = view4.getMeasuredHeight();
        }
        setMeasuredDimension(measuredWidth, i3);
        this.lastWidthMeasureSpec = i;
        this.lastHeightMeasureSpec = i2;
    }

    public final void remeasure() {
        int i;
        int i2 = this.lastWidthMeasureSpec;
        if (i2 != Integer.MIN_VALUE && (i = this.lastHeightMeasureSpec) != Integer.MIN_VALUE) {
            measure(i2, i);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View view2 = this.view;
        if (view2 != null) {
            view2.layout(0, 0, i3 - i, i4 - i2);
        }
    }

    public ViewGroup.LayoutParams getLayoutParams() {
        View view2 = this.view;
        ViewGroup.LayoutParams layoutParams = view2 == null ? null : view2.getLayoutParams();
        return layoutParams == null ? new ViewGroup.LayoutParams(-1, -1) : layoutParams;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        Function1<? super Boolean, Unit> function1 = this.onRequestDisallowInterceptTouchEvent;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(z));
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.snapshotObserver.start();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.snapshotObserver.stop();
        this.snapshotObserver.clear();
    }

    public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
        super.invalidateChildInParent(iArr, rect);
        this.layoutNode.invalidateLayer$ui_release();
        return null;
    }

    public void onDescendantInvalidated(View view2, View view3) {
        Intrinsics.checkNotNullParameter(view2, "child");
        Intrinsics.checkNotNullParameter(view3, "target");
        super.onDescendantInvalidated(view2, view3);
        this.layoutNode.invalidateLayer$ui_release();
    }

    public boolean gatherTransparentRegion(Region region) {
        if (region == null) {
            return true;
        }
        getLocationInWindow(this.location);
        int[] iArr = this.location;
        region.op(iArr[0], iArr[1], iArr[0] + getWidth(), this.location[1] + getHeight(), Region.Op.DIFFERENCE);
        return true;
    }

    public final LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    /* access modifiers changed from: private */
    public final int obtainMeasureSpec(int i, int i2, int i3) {
        if (i3 >= 0 || i == i2) {
            return View.MeasureSpec.makeMeasureSpec(RangesKt.coerceIn(i3, i, i2), BasicMeasure.EXACTLY);
        }
        if (i3 == -2 && i2 != Integer.MAX_VALUE) {
            return View.MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE);
        }
        if (i3 != -1 || i2 == Integer.MAX_VALUE) {
            return View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        return View.MeasureSpec.makeMeasureSpec(i2, BasicMeasure.EXACTLY);
    }
}
