package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.Modifier.Element;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.input.nestedscroll.NestedScrollDelegatingWrapper;
import androidx.compose.ui.input.pointer.PointerInputFilter;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.JvmActuals_jvmKt;
import androidx.compose.ui.semantics.SemanticsWrapper;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0010\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0002\u0010\u0006J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\n\u0010%\u001a\u0004\u0018\u00010&H\u0016J\n\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0012\u0010)\u001a\u0004\u0018\u00010&2\u0006\u0010*\u001a\u00020\bH\u0016J\n\u0010+\u001a\u0004\u0018\u00010(H\u0016J\n\u0010,\u001a\u0004\u0018\u00010-H\u0016J\n\u0010.\u001a\u0004\u0018\u00010&H\u0016J\n\u0010/\u001a\u0004\u0018\u00010(H\u0016J\n\u00100\u001a\u0004\u0018\u00010-H\u0016J;\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\f\u00105\u001a\b\u0012\u0004\u0012\u000207062\u0006\u00108\u001a\u00020\b2\u0006\u00109\u001a\u00020\bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b:\u0010;Je\u0010<\u001a\u000202\"\u0004\b\u0001\u0010\u00012\u0006\u00103\u001a\u0002042\f\u00105\u001a\b\u0012\u0004\u0012\u0002H\u0001062\u0006\u0010=\u001a\u00020\b2\u0006\u0010>\u001a\u00020\b2\u0006\u00109\u001a\u00020\b2\u0006\u0010?\u001a\u0002H\u00012\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u0002020AH\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bB\u0010CJ3\u0010D\u001a\u0002022\u0006\u00103\u001a\u0002042\f\u0010E\u001a\b\u0012\u0004\u0012\u00020F062\u0006\u00109\u001a\u00020\bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bG\u0010HJ\u0010\u0010I\u001a\u00020\"2\u0006\u0010J\u001a\u00020\"H\u0016J\u0010\u0010K\u001a\u00020\"2\u0006\u0010L\u001a\u00020\"H\u0016J\u001d\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020PH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bQ\u0010RJ\u0010\u0010S\u001a\u00020\"2\u0006\u0010J\u001a\u00020\"H\u0016J\u0010\u0010T\u001a\u00020\"2\u0006\u0010L\u001a\u00020\"H\u0016J\b\u0010U\u001a\u000202H\u0016J\u0010\u0010V\u001a\u0002022\u0006\u0010W\u001a\u00020XH\u0016J@\u0010Y\u001a\u0002022\u0006\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020]2\u0019\u0010^\u001a\u0015\u0012\u0004\u0012\u00020_\u0012\u0004\u0012\u000202\u0018\u00010A¢\u0006\u0002\b`H\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\ba\u0010bJ\u000e\u0010c\u001a\u0002022\u0006\u0010\u0005\u001a\u00020\u0002J\b\u0010d\u001a\u00020\bH\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0005\u001a\u00028\u0000X\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00168VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\t\"\u0004\b\u001b\u0010\u000bR$\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0003@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006e"}, d2 = {"Landroidx/compose/ui/node/DelegatingLayoutNodeWrapper;", "T", "Landroidx/compose/ui/Modifier$Element;", "Landroidx/compose/ui/node/LayoutNodeWrapper;", "wrapped", "modifier", "(Landroidx/compose/ui/node/LayoutNodeWrapper;Landroidx/compose/ui/Modifier$Element;)V", "isChained", "", "()Z", "setChained", "(Z)V", "measureScope", "Landroidx/compose/ui/layout/MeasureScope;", "getMeasureScope", "()Landroidx/compose/ui/layout/MeasureScope;", "getModifier", "()Landroidx/compose/ui/Modifier$Element;", "setModifier", "(Landroidx/compose/ui/Modifier$Element;)V", "Landroidx/compose/ui/Modifier$Element;", "parentData", "", "getParentData", "()Ljava/lang/Object;", "toBeReusedForSameModifier", "getToBeReusedForSameModifier", "setToBeReusedForSameModifier", "<set-?>", "getWrapped$ui_release", "()Landroidx/compose/ui/node/LayoutNodeWrapper;", "setWrapped", "(Landroidx/compose/ui/node/LayoutNodeWrapper;)V", "calculateAlignmentLine", "", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "findLastFocusWrapper", "Landroidx/compose/ui/node/ModifiedFocusNode;", "findLastKeyInputWrapper", "Landroidx/compose/ui/node/ModifiedKeyInputNode;", "findNextFocusWrapper", "excludeDeactivated", "findNextKeyInputWrapper", "findNextNestedScrollWrapper", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDelegatingWrapper;", "findPreviousFocusWrapper", "findPreviousKeyInputWrapper", "findPreviousNestedScrollWrapper", "hitTest", "", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "Landroidx/compose/ui/input/pointer/PointerInputFilter;", "isTouchEvent", "isInLayer", "hitTest-M_7yMNQ", "(JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "hitTestInMinimumTouchTarget", "forceParentIntercept", "useTouchSize", "content", "block", "Lkotlin/Function1;", "hitTestInMinimumTouchTarget-7362WCg", "(JLandroidx/compose/ui/node/HitTestResult;ZZZLjava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "hitTestSemantics", "hitSemanticsWrappers", "Landroidx/compose/ui/semantics/SemanticsWrapper;", "hitTestSemantics-9KIMszo", "(JLandroidx/compose/ui/node/HitTestResult;Z)V", "maxIntrinsicHeight", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicHeight", "minIntrinsicWidth", "onInitialize", "performDraw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "placeAt", "position", "Landroidx/compose/ui/unit/IntOffset;", "zIndex", "", "layerBlock", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "setModifierTo", "shouldSharePointerInputWithSiblings", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DelegatingLayoutNodeWrapper.kt */
public class DelegatingLayoutNodeWrapper<T extends Modifier.Element> extends LayoutNodeWrapper {
    private boolean isChained;
    private T modifier;
    private boolean toBeReusedForSameModifier;
    private LayoutNodeWrapper wrapped;

    public LayoutNodeWrapper getWrapped$ui_release() {
        return this.wrapped;
    }

    public void setWrapped(LayoutNodeWrapper layoutNodeWrapper) {
        Intrinsics.checkNotNullParameter(layoutNodeWrapper, "<set-?>");
        this.wrapped = layoutNodeWrapper;
    }

    public T getModifier() {
        return this.modifier;
    }

    public void setModifier(T t) {
        Intrinsics.checkNotNullParameter(t, "<set-?>");
        this.modifier = t;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DelegatingLayoutNodeWrapper(LayoutNodeWrapper layoutNodeWrapper, T t) {
        super(layoutNodeWrapper.getLayoutNode$ui_release());
        Intrinsics.checkNotNullParameter(layoutNodeWrapper, "wrapped");
        Intrinsics.checkNotNullParameter(t, "modifier");
        this.wrapped = layoutNodeWrapper;
        this.modifier = t;
    }

    public MeasureScope getMeasureScope() {
        return getWrapped$ui_release().getMeasureScope();
    }

    public final boolean isChained() {
        return this.isChained;
    }

    public final void setChained(boolean z) {
        this.isChained = z;
    }

    public final boolean getToBeReusedForSameModifier() {
        return this.toBeReusedForSameModifier;
    }

    public final void setToBeReusedForSameModifier(boolean z) {
        this.toBeReusedForSameModifier = z;
    }

    public final void setModifierTo(Modifier.Element element) {
        Intrinsics.checkNotNullParameter(element, "modifier");
        if (element == getModifier()) {
            return;
        }
        if (Intrinsics.areEqual(JvmActuals_jvmKt.nativeClass(element), JvmActuals_jvmKt.nativeClass(getModifier()))) {
            setModifier(element);
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public void onInitialize() {
        super.onInitialize();
        getWrapped$ui_release().setWrappedBy$ui_release(this);
    }

    public void performDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        getWrapped$ui_release().draw(canvas);
    }

    /* renamed from: hitTest-M_7yMNQ  reason: not valid java name */
    public void m3242hitTestM_7yMNQ(long j, HitTestResult<PointerInputFilter> hitTestResult, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(hitTestResult, "hitTestResult");
        boolean r0 = m3355withinLayerBoundsk4lQ0M(j);
        if (!r0) {
            if (z) {
                float r3 = m3340distanceInMinimumTouchTargettz77jQw(j, m3342getMinimumTouchTargetSizeNHjbRc());
                if (!(!Float.isInfinite(r3) && !Float.isNaN(r3))) {
                    return;
                }
            } else {
                return;
            }
        }
        getWrapped$ui_release().m3345hitTestM_7yMNQ(getWrapped$ui_release().m3341fromParentPositionMKHz9U(j), hitTestResult, z, z2 && r0);
    }

    /* renamed from: hitTestSemantics-9KIMszo  reason: not valid java name */
    public void m3244hitTestSemantics9KIMszo(long j, HitTestResult<SemanticsWrapper> hitTestResult, boolean z) {
        Intrinsics.checkNotNullParameter(hitTestResult, "hitSemanticsWrappers");
        boolean r0 = m3355withinLayerBoundsk4lQ0M(j);
        boolean z2 = true;
        if (!r0) {
            float r3 = m3340distanceInMinimumTouchTargettz77jQw(j, m3342getMinimumTouchTargetSizeNHjbRc());
            if (!(!Float.isInfinite(r3) && !Float.isNaN(r3))) {
                return;
            }
        }
        long r6 = getWrapped$ui_release().m3341fromParentPositionMKHz9U(j);
        if (!z || !r0) {
            z2 = false;
        }
        getWrapped$ui_release().m3346hitTestSemantics9KIMszo(r6, hitTestResult, z2);
    }

    public int calculateAlignmentLine(AlignmentLine alignmentLine) {
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        return getWrapped$ui_release().get(alignmentLine);
    }

    /* access modifiers changed from: protected */
    /* renamed from: placeAt-f8xVGno  reason: not valid java name */
    public void m3246placeAtf8xVGno(long j, float f, Function1<? super GraphicsLayerScope, Unit> function1) {
        super.m3352placeAtf8xVGno(j, f, function1);
        LayoutNodeWrapper wrappedBy$ui_release = getWrappedBy$ui_release();
        boolean z = false;
        if (wrappedBy$ui_release != null && wrappedBy$ui_release.isShallowPlacing()) {
            z = true;
        }
        if (!z) {
            onPlaced();
            Placeable.PlacementScope.Companion companion = Placeable.PlacementScope.Companion;
            int r4 = IntSize.m4019getWidthimpl(m3173getMeasuredSizeYbymL2g());
            LayoutDirection layoutDirection = getMeasureScope().getLayoutDirection();
            int access$getParentWidth = Placeable.PlacementScope.Companion.getParentWidth();
            LayoutDirection access$getParentLayoutDirection = Placeable.PlacementScope.Companion.getParentLayoutDirection();
            Placeable.PlacementScope.Companion companion2 = Placeable.PlacementScope.Companion;
            Placeable.PlacementScope.parentWidth = r4;
            Placeable.PlacementScope.Companion companion3 = Placeable.PlacementScope.Companion;
            Placeable.PlacementScope.parentLayoutDirection = layoutDirection;
            Placeable.PlacementScope placementScope = companion;
            getMeasureResult().placeChildren();
            Placeable.PlacementScope.Companion companion4 = Placeable.PlacementScope.Companion;
            Placeable.PlacementScope.parentWidth = access$getParentWidth;
            Placeable.PlacementScope.Companion companion5 = Placeable.PlacementScope.Companion;
            Placeable.PlacementScope.parentLayoutDirection = access$getParentLayoutDirection;
        }
    }

    /* renamed from: measure-BRTryo0  reason: not valid java name */
    public Placeable m3245measureBRTryo0(long j) {
        m3177setMeasurementConstraintsBRTryo0(j);
        setMeasureResult$ui_release(new DelegatingLayoutNodeWrapper$measure$1$1(this, getWrapped$ui_release().m3151measureBRTryo0(j)));
        return this;
    }

    public ModifiedFocusNode findPreviousFocusWrapper() {
        LayoutNodeWrapper wrappedBy$ui_release = getWrappedBy$ui_release();
        if (wrappedBy$ui_release == null) {
            return null;
        }
        return wrappedBy$ui_release.findPreviousFocusWrapper();
    }

    public ModifiedFocusNode findNextFocusWrapper(boolean z) {
        return getWrapped$ui_release().findNextFocusWrapper(z);
    }

    public ModifiedFocusNode findLastFocusWrapper() {
        ModifiedFocusNode modifiedFocusNode = null;
        for (ModifiedFocusNode findNextFocusWrapper = findNextFocusWrapper(false); findNextFocusWrapper != null; findNextFocusWrapper = findNextFocusWrapper.getWrapped$ui_release().findNextFocusWrapper(false)) {
            modifiedFocusNode = findNextFocusWrapper;
        }
        return modifiedFocusNode;
    }

    public NestedScrollDelegatingWrapper findPreviousNestedScrollWrapper() {
        LayoutNodeWrapper wrappedBy$ui_release = getWrappedBy$ui_release();
        if (wrappedBy$ui_release == null) {
            return null;
        }
        return wrappedBy$ui_release.findPreviousNestedScrollWrapper();
    }

    public NestedScrollDelegatingWrapper findNextNestedScrollWrapper() {
        return getWrapped$ui_release().findNextNestedScrollWrapper();
    }

    public ModifiedKeyInputNode findPreviousKeyInputWrapper() {
        LayoutNodeWrapper wrappedBy$ui_release = getWrappedBy$ui_release();
        if (wrappedBy$ui_release == null) {
            return null;
        }
        return wrappedBy$ui_release.findPreviousKeyInputWrapper();
    }

    public ModifiedKeyInputNode findNextKeyInputWrapper() {
        return getWrapped$ui_release().findNextKeyInputWrapper();
    }

    public ModifiedKeyInputNode findLastKeyInputWrapper() {
        ModifiedKeyInputNode findPreviousKeyInputWrapper = getLayoutNode$ui_release().getInnerLayoutNodeWrapper$ui_release().findPreviousKeyInputWrapper();
        if (findPreviousKeyInputWrapper != this) {
            return findPreviousKeyInputWrapper;
        }
        return null;
    }

    public int minIntrinsicWidth(int i) {
        return getWrapped$ui_release().minIntrinsicWidth(i);
    }

    public int maxIntrinsicWidth(int i) {
        return getWrapped$ui_release().maxIntrinsicWidth(i);
    }

    public int minIntrinsicHeight(int i) {
        return getWrapped$ui_release().minIntrinsicHeight(i);
    }

    public int maxIntrinsicHeight(int i) {
        return getWrapped$ui_release().maxIntrinsicHeight(i);
    }

    public Object getParentData() {
        return getWrapped$ui_release().getParentData();
    }

    public boolean shouldSharePointerInputWithSiblings() {
        return getWrapped$ui_release().shouldSharePointerInputWithSiblings();
    }

    /* access modifiers changed from: protected */
    /* renamed from: hitTestInMinimumTouchTarget-7362WCg  reason: not valid java name */
    public final <T> void m3243hitTestInMinimumTouchTarget7362WCg(long j, HitTestResult<T> hitTestResult, boolean z, boolean z2, boolean z3, T t, Function1<? super Boolean, Unit> function1) {
        float f;
        Intrinsics.checkNotNullParameter(hitTestResult, "hitTestResult");
        Intrinsics.checkNotNullParameter(function1, "block");
        boolean z4 = true;
        if (!m3355withinLayerBoundsk4lQ0M(j)) {
            if (z2) {
                float r6 = m3340distanceInMinimumTouchTargettz77jQw(j, m3342getMinimumTouchTargetSizeNHjbRc());
                if (Float.isInfinite(r6) || Float.isNaN(r6)) {
                    z4 = false;
                }
                if (z4 && hitTestResult.isHitInMinimumTouchTargetBetter(r6, false)) {
                    hitTestResult.hitInMinimumTouchTarget(t, r6, false, new DelegatingLayoutNodeWrapper$hitTestInMinimumTouchTarget$1(function1));
                }
            }
        } else if (m3347isPointerInBoundsk4lQ0M(j)) {
            hitTestResult.hit(t, z3, new DelegatingLayoutNodeWrapper$hitTestInMinimumTouchTarget$2(function1, z3));
        } else {
            if (!z2) {
                f = Float.POSITIVE_INFINITY;
            } else {
                f = m3340distanceInMinimumTouchTargettz77jQw(j, m3342getMinimumTouchTargetSizeNHjbRc());
            }
            if (Float.isInfinite(f) || Float.isNaN(f)) {
                z4 = false;
            }
            if (z4 && hitTestResult.isHitInMinimumTouchTargetBetter(f, z3)) {
                hitTestResult.hitInMinimumTouchTarget(t, f, z3, new DelegatingLayoutNodeWrapper$hitTestInMinimumTouchTarget$3(function1, z3));
            } else if (z) {
                hitTestResult.speculativeHit(t, f, z3, new DelegatingLayoutNodeWrapper$hitTestInMinimumTouchTarget$4(function1, z3));
            } else {
                function1.invoke(Boolean.valueOf(z3));
            }
        }
    }
}
