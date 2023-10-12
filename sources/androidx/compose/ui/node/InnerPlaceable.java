package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.focus.FocusStateImpl;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.input.nestedscroll.NestedScrollDelegatingWrapper;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 x2\u00020\u00012\u00020\u0002:\u0001xB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\n\u0010\u001f\u001a\u0004\u0018\u00010\u001bH\u0016J\n\u0010 \u001a\u0004\u0018\u00010!H\u0016J\n\u0010\"\u001a\u0004\u0018\u00010\u0019H\u0016J\n\u0010#\u001a\u0004\u0018\u00010\u001bH\u0016J\n\u0010$\u001a\u0004\u0018\u00010!H\u0016J\b\u0010%\u001a\u00020&H\u0014Jy\u0010'\u001a\u00020(\"\u0004\b\u0000\u0010)2\u0006\u0010*\u001a\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u0002H)0-2\u0006\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\u001e25\u00100\u001a1\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020+\u0012\n\u0012\b\u0012\u0004\u0012\u0002H)0-\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020(01¢\u0006\u0002\b2H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b3\u00104J;\u0010'\u001a\u00020(2\u0006\u0010*\u001a\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u0002050-2\u0006\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\u001eH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b6\u00107J3\u00108\u001a\u00020(2\u0006\u0010*\u001a\u00020+2\f\u00109\u001a\b\u0012\u0004\u0012\u00020:0-2\u0006\u0010/\u001a\u00020\u001eH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b;\u0010<J\u0010\u0010=\u001a\u00020\u00152\u0006\u0010>\u001a\u00020\u0015H\u0016J\u0010\u0010?\u001a\u00020\u00152\u0006\u0010@\u001a\u00020\u0015H\u0016J\u001d\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bE\u0010FJ\u0010\u0010G\u001a\u00020\u00152\u0006\u0010>\u001a\u00020\u0015H\u0016J\u0010\u0010H\u001a\u00020\u00152\u0006\u0010@\u001a\u00020\u0015H\u0016J\u0010\u0010I\u001a\u00020(2\u0006\u0010J\u001a\u00020KH\u0016J@\u0010L\u001a\u00020(2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020\u00072\u0019\u0010P\u001a\u0015\u0012\u0004\u0012\u00020R\u0012\u0004\u0012\u00020(\u0018\u00010Q¢\u0006\u0002\b2H\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bS\u0010TJ\u0010\u0010U\u001a\u00020(2\u0006\u0010V\u001a\u00020WH\u0016J\b\u0010X\u001a\u00020\u001eH\u0016J\u001a\u0010Y\u001a\u00020\u0015*\u00020ZH\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b[\u0010\\J\u001a\u0010Y\u001a\u00020\u0015*\u00020]H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b^\u0010_J\u001a\u0010`\u001a\u00020Z*\u00020]H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\ba\u0010bJ\u001d\u0010`\u001a\u00020Z*\u00020\u0007H\u0001ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\bc\u0010dJ\u001d\u0010`\u001a\u00020Z*\u00020\u0015H\u0001ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\bc\u0010eJ\u001a\u0010f\u001a\u00020g*\u00020hH\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bi\u0010jJ\u001a\u0010k\u001a\u00020\u0007*\u00020ZH\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bl\u0010dJ\u001a\u0010k\u001a\u00020\u0007*\u00020]H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bm\u0010bJ\r\u0010n\u001a\u00020o*\u00020pH\u0001J\u001a\u0010q\u001a\u00020h*\u00020gH\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\br\u0010jJ\u001a\u0010s\u001a\u00020]*\u00020ZH\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bt\u0010uJ\u001d\u0010s\u001a\u00020]*\u00020\u0007H\u0001ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\bv\u0010uJ\u001d\u0010s\u001a\u00020]*\u00020\u0015H\u0001ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\bv\u0010wR\u0014\u0010\u0006\u001a\u00020\u00078\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006y"}, d2 = {"Landroidx/compose/ui/node/InnerPlaceable;", "Landroidx/compose/ui/node/LayoutNodeWrapper;", "Landroidx/compose/ui/unit/Density;", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "density", "", "getDensity", "()F", "fontScale", "getFontScale", "measureScope", "Landroidx/compose/ui/layout/MeasureScope;", "getMeasureScope", "()Landroidx/compose/ui/layout/MeasureScope;", "parentData", "", "getParentData", "()Ljava/lang/Object;", "calculateAlignmentLine", "", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "findLastFocusWrapper", "Landroidx/compose/ui/node/ModifiedFocusNode;", "findLastKeyInputWrapper", "Landroidx/compose/ui/node/ModifiedKeyInputNode;", "findNextFocusWrapper", "excludeDeactivated", "", "findNextKeyInputWrapper", "findNextNestedScrollWrapper", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDelegatingWrapper;", "findPreviousFocusWrapper", "findPreviousKeyInputWrapper", "findPreviousNestedScrollWrapper", "getWrappedByCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "hitTest", "", "T", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "isTouchEvent", "isInLayer", "childHitTest", "Lkotlin/Function5;", "Lkotlin/ExtensionFunctionType;", "hitTest-ULxng0E", "(JLandroidx/compose/ui/node/HitTestResult;ZZLkotlin/jvm/functions/Function5;)V", "Landroidx/compose/ui/input/pointer/PointerInputFilter;", "hitTest-M_7yMNQ", "(JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "hitTestSemantics", "hitSemanticsWrappers", "Landroidx/compose/ui/semantics/SemanticsWrapper;", "hitTestSemantics-9KIMszo", "(JLandroidx/compose/ui/node/HitTestResult;Z)V", "maxIntrinsicHeight", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicHeight", "minIntrinsicWidth", "performDraw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "placeAt", "position", "Landroidx/compose/ui/unit/IntOffset;", "zIndex", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "propagateFocusEvent", "focusState", "Landroidx/compose/ui/focus/FocusState;", "shouldSharePointerInputWithSiblings", "roundToPx", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "Companion", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: InnerPlaceable.kt */
public final class InnerPlaceable extends LayoutNodeWrapper implements Density {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Paint innerBoundsPaint;
    private final /* synthetic */ MeasureScope $$delegate_0;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: InnerPlaceable.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FocusStateImpl.values().length];
            iArr[FocusStateImpl.Active.ordinal()] = 1;
            iArr[FocusStateImpl.ActiveParent.ordinal()] = 2;
            iArr[FocusStateImpl.Captured.ordinal()] = 3;
            iArr[FocusStateImpl.DeactivatedParent.ordinal()] = 4;
            iArr[FocusStateImpl.Deactivated.ordinal()] = 5;
            iArr[FocusStateImpl.Inactive.ordinal()] = 6;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ModifiedFocusNode findNextFocusWrapper(boolean z) {
        return null;
    }

    public ModifiedKeyInputNode findNextKeyInputWrapper() {
        return null;
    }

    public NestedScrollDelegatingWrapper findNextNestedScrollWrapper() {
        return null;
    }

    public float getDensity() {
        return this.$$delegate_0.getDensity();
    }

    public float getFontScale() {
        return this.$$delegate_0.getFontScale();
    }

    public Object getParentData() {
        return null;
    }

    /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
    public int m3265roundToPxR2X_6o(long j) {
        return this.$$delegate_0.m3821roundToPxR2X_6o(j);
    }

    /* renamed from: roundToPx-0680j_4  reason: not valid java name */
    public int m3266roundToPx0680j_4(float f) {
        return this.$$delegate_0.m3822roundToPx0680j_4(f);
    }

    public boolean shouldSharePointerInputWithSiblings() {
        return false;
    }

    /* renamed from: toDp-GaN1DYA  reason: not valid java name */
    public float m3267toDpGaN1DYA(long j) {
        return this.$$delegate_0.m3823toDpGaN1DYA(j);
    }

    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    public float m3268toDpu2uoSUM(float f) {
        return this.$$delegate_0.m3824toDpu2uoSUM(f);
    }

    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    public float m3269toDpu2uoSUM(int i) {
        return this.$$delegate_0.m3825toDpu2uoSUM(i);
    }

    /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
    public long m3270toDpSizekrfVVM(long j) {
        return this.$$delegate_0.m3826toDpSizekrfVVM(j);
    }

    /* renamed from: toPx--R2X_6o  reason: not valid java name */
    public float m3271toPxR2X_6o(long j) {
        return this.$$delegate_0.m3827toPxR2X_6o(j);
    }

    /* renamed from: toPx-0680j_4  reason: not valid java name */
    public float m3272toPx0680j_4(float f) {
        return this.$$delegate_0.m3828toPx0680j_4(f);
    }

    public Rect toRect(DpRect dpRect) {
        Intrinsics.checkNotNullParameter(dpRect, "<this>");
        return this.$$delegate_0.toRect(dpRect);
    }

    /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
    public long m3273toSizeXkaWNTQ(long j) {
        return this.$$delegate_0.m3829toSizeXkaWNTQ(j);
    }

    /* renamed from: toSp-0xMU5do  reason: not valid java name */
    public long m3274toSp0xMU5do(float f) {
        return this.$$delegate_0.m3830toSp0xMU5do(f);
    }

    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    public long m3275toSpkPz2Gy4(float f) {
        return this.$$delegate_0.m3831toSpkPz2Gy4(f);
    }

    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    public long m3276toSpkPz2Gy4(int i) {
        return this.$$delegate_0.m3832toSpkPz2Gy4(i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InnerPlaceable(LayoutNode layoutNode) {
        super(layoutNode);
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        this.$$delegate_0 = layoutNode.getMeasureScope$ui_release();
    }

    public MeasureScope getMeasureScope() {
        return getLayoutNode$ui_release().getMeasureScope$ui_release();
    }

    /* renamed from: measure-BRTryo0  reason: not valid java name */
    public Placeable m3263measureBRTryo0(long j) {
        m3177setMeasurementConstraintsBRTryo0(j);
        MutableVector<LayoutNode> mutableVector = getLayoutNode$ui_release().get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            int i = 0;
            Object[] content = mutableVector.getContent();
            do {
                ((LayoutNode) content[i]).setMeasuredByParent$ui_release(LayoutNode.UsageByParent.NotUsed);
                i++;
            } while (i < size);
        }
        getLayoutNode$ui_release().handleMeasureResult$ui_release(getLayoutNode$ui_release().getMeasurePolicy().m3152measure3p2s80s(getLayoutNode$ui_release().getMeasureScope$ui_release(), getLayoutNode$ui_release().getChildren$ui_release(), j));
        return this;
    }

    public ModifiedFocusNode findPreviousFocusWrapper() {
        LayoutNodeWrapper wrappedBy$ui_release = getWrappedBy$ui_release();
        if (wrappedBy$ui_release == null) {
            return null;
        }
        return wrappedBy$ui_release.findPreviousFocusWrapper();
    }

    public ModifiedFocusNode findLastFocusWrapper() {
        return findPreviousFocusWrapper();
    }

    public void propagateFocusEvent(FocusState focusState) {
        Intrinsics.checkNotNullParameter(focusState, "focusState");
        int i = 0;
        List<ModifiedFocusNode> focusableChildren = focusableChildren(false);
        int size = focusableChildren.size();
        FocusStateImpl focusStateImpl = null;
        ModifiedFocusNode modifiedFocusNode = null;
        boolean z = null;
        while (i < size) {
            int i2 = i + 1;
            ModifiedFocusNode modifiedFocusNode2 = focusableChildren.get(i);
            switch (WhenMappings.$EnumSwitchMapping$0[modifiedFocusNode2.getFocusState().ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                    modifiedFocusNode = modifiedFocusNode2;
                    break;
                case 5:
                    if (z == null) {
                        z = true;
                        break;
                    } else {
                        continue;
                    }
                case 6:
                    break;
            }
            z = false;
            i = i2;
        }
        if (modifiedFocusNode != null) {
            focusStateImpl = modifiedFocusNode.getFocusState();
        }
        if (focusStateImpl == null) {
            focusStateImpl = Intrinsics.areEqual((Object) z, (Object) true) ? FocusStateImpl.Deactivated : FocusStateImpl.Inactive;
        }
        super.propagateFocusEvent(focusStateImpl);
    }

    public ModifiedKeyInputNode findPreviousKeyInputWrapper() {
        LayoutNodeWrapper wrappedBy$ui_release = getWrappedBy$ui_release();
        if (wrappedBy$ui_release == null) {
            return null;
        }
        return wrappedBy$ui_release.findPreviousKeyInputWrapper();
    }

    public NestedScrollDelegatingWrapper findPreviousNestedScrollWrapper() {
        LayoutNodeWrapper wrappedBy$ui_release = getWrappedBy$ui_release();
        if (wrappedBy$ui_release == null) {
            return null;
        }
        return wrappedBy$ui_release.findPreviousNestedScrollWrapper();
    }

    public ModifiedKeyInputNode findLastKeyInputWrapper() {
        return findPreviousKeyInputWrapper();
    }

    public int minIntrinsicWidth(int i) {
        return getLayoutNode$ui_release().getIntrinsicsPolicy$ui_release().minIntrinsicWidth(i);
    }

    public int minIntrinsicHeight(int i) {
        return getLayoutNode$ui_release().getIntrinsicsPolicy$ui_release().minIntrinsicHeight(i);
    }

    public int maxIntrinsicWidth(int i) {
        return getLayoutNode$ui_release().getIntrinsicsPolicy$ui_release().maxIntrinsicWidth(i);
    }

    public int maxIntrinsicHeight(int i) {
        return getLayoutNode$ui_release().getIntrinsicsPolicy$ui_release().maxIntrinsicHeight(i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: placeAt-f8xVGno  reason: not valid java name */
    public void m3264placeAtf8xVGno(long j, float f, Function1<? super GraphicsLayerScope, Unit> function1) {
        super.m3352placeAtf8xVGno(j, f, function1);
        LayoutNodeWrapper wrappedBy$ui_release = getWrappedBy$ui_release();
        boolean z = false;
        if (wrappedBy$ui_release != null && wrappedBy$ui_release.isShallowPlacing()) {
            z = true;
        }
        if (!z) {
            getLayoutNode$ui_release().onNodePlaced$ui_release();
        }
    }

    public int calculateAlignmentLine(AlignmentLine alignmentLine) {
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        Integer num = getLayoutNode$ui_release().calculateAlignmentLines$ui_release().get(alignmentLine);
        if (num == null) {
            return Integer.MIN_VALUE;
        }
        return num.intValue();
    }

    public void performDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Owner requireOwner = LayoutNodeKt.requireOwner(getLayoutNode$ui_release());
        MutableVector<LayoutNode> zSortedChildren = getLayoutNode$ui_release().getZSortedChildren();
        int size = zSortedChildren.getSize();
        if (size > 0) {
            int i = 0;
            Object[] content = zSortedChildren.getContent();
            do {
                LayoutNode layoutNode = (LayoutNode) content[i];
                if (layoutNode.isPlaced()) {
                    layoutNode.draw$ui_release(canvas);
                }
                i++;
            } while (i < size);
        }
        if (requireOwner.getShowLayoutBounds()) {
            drawBorder(canvas, innerBoundsPaint);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0092 A[EDGE_INSN: B:35:0x0092->B:34:0x0092 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* renamed from: hitTest-ULxng0E  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <T> void m3260hitTestULxng0E(long r17, androidx.compose.ui.node.HitTestResult<T> r19, boolean r20, boolean r21, kotlin.jvm.functions.Function5<? super androidx.compose.ui.node.LayoutNode, ? super androidx.compose.ui.geometry.Offset, ? super androidx.compose.ui.node.HitTestResult<T>, ? super java.lang.Boolean, ? super java.lang.Boolean, kotlin.Unit> r22) {
        /*
            r16 = this;
            boolean r0 = r16.m3355withinLayerBoundsk4lQ0M(r17)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0010
            r0 = r16
            r5 = r17
            r3 = r21
        L_0x000e:
            r4 = 1
            goto L_0x0038
        L_0x0010:
            if (r20 == 0) goto L_0x0031
            long r3 = r16.m3342getMinimumTouchTargetSizeNHjbRc()
            r0 = r16
            r5 = r17
            float r3 = r0.m3340distanceInMinimumTouchTargettz77jQw(r5, r3)
            boolean r4 = java.lang.Float.isInfinite(r3)
            if (r4 != 0) goto L_0x002c
            boolean r3 = java.lang.Float.isNaN(r3)
            if (r3 != 0) goto L_0x002c
            r3 = 1
            goto L_0x002d
        L_0x002c:
            r3 = 0
        L_0x002d:
            if (r3 == 0) goto L_0x0035
            r3 = 0
            goto L_0x000e
        L_0x0031:
            r0 = r16
            r5 = r17
        L_0x0035:
            r3 = r21
            r4 = 0
        L_0x0038:
            if (r4 == 0) goto L_0x0097
            int r4 = r19.hitDepth
            androidx.compose.ui.node.LayoutNode r7 = r16.getLayoutNode$ui_release()
            androidx.compose.runtime.collection.MutableVector r7 = r7.getZSortedChildren()
            int r8 = r7.getSize()
            if (r8 <= 0) goto L_0x0092
            int r8 = r8 - r2
            java.lang.Object[] r7 = r7.getContent()
        L_0x0051:
            r9 = r7[r8]
            androidx.compose.ui.node.LayoutNode r9 = (androidx.compose.ui.node.LayoutNode) r9
            boolean r10 = r9.isPlaced()
            if (r10 == 0) goto L_0x008a
            androidx.compose.ui.geometry.Offset r12 = androidx.compose.ui.geometry.Offset.m1342boximpl(r17)
            java.lang.Boolean r14 = java.lang.Boolean.valueOf(r20)
            java.lang.Boolean r15 = java.lang.Boolean.valueOf(r3)
            r10 = r22
            r11 = r9
            r13 = r19
            r10.invoke(r11, r12, r13, r14, r15)
            boolean r10 = r19.hasHit()
            if (r10 != 0) goto L_0x0077
        L_0x0075:
            r9 = 1
            goto L_0x0086
        L_0x0077:
            androidx.compose.ui.node.LayoutNodeWrapper r9 = r9.getOuterLayoutNodeWrapper$ui_release()
            boolean r9 = r9.shouldSharePointerInputWithSiblings()
            if (r9 == 0) goto L_0x0085
            r19.acceptHits()
            goto L_0x0075
        L_0x0085:
            r9 = 0
        L_0x0086:
            if (r9 != 0) goto L_0x008a
            r9 = 1
            goto L_0x008b
        L_0x008a:
            r9 = 0
        L_0x008b:
            if (r9 == 0) goto L_0x008e
            goto L_0x0092
        L_0x008e:
            int r8 = r8 + -1
            if (r8 >= 0) goto L_0x0051
        L_0x0092:
            r1 = r19
            r1.hitDepth = r4
        L_0x0097:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.InnerPlaceable.m3260hitTestULxng0E(long, androidx.compose.ui.node.HitTestResult, boolean, boolean, kotlin.jvm.functions.Function5):void");
    }

    /* access modifiers changed from: protected */
    public LayoutCoordinates getWrappedByCoordinates() {
        return this;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/node/InnerPlaceable$Companion;", "", "()V", "innerBoundsPaint", "Landroidx/compose/ui/graphics/Paint;", "getInnerBoundsPaint", "()Landroidx/compose/ui/graphics/Paint;", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: InnerPlaceable.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Paint getInnerBoundsPaint() {
            return InnerPlaceable.innerBoundsPaint;
        }
    }

    static {
        Paint Paint = AndroidPaint_androidKt.Paint();
        Paint.m1803setColor8_81llA(Color.Companion.m1630getRed0d7_KjU());
        Paint.setStrokeWidth(1.0f);
        Paint.m1807setStylek9PVt8s(PaintingStyle.Companion.m1816getStrokeTiuSbCo());
        innerBoundsPaint = Paint;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0095 A[EDGE_INSN: B:34:0x0095->B:33:0x0095 ?: BREAK  , SYNTHETIC] */
    /* renamed from: hitTest-M_7yMNQ  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m3261hitTestM_7yMNQ(long r18, androidx.compose.ui.node.HitTestResult<androidx.compose.ui.input.pointer.PointerInputFilter> r20, boolean r21, boolean r22) {
        /*
            r17 = this;
            r6 = r20
            java.lang.String r0 = "hitTestResult"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            boolean r0 = r17.m3355withinLayerBoundsk4lQ0M(r18)
            r7 = 0
            r8 = 1
            if (r0 == 0) goto L_0x0017
            r9 = r17
            r10 = r18
            r12 = r22
            r0 = 1
            goto L_0x0040
        L_0x0017:
            if (r21 == 0) goto L_0x0039
            long r0 = r17.m3342getMinimumTouchTargetSizeNHjbRc()
            r9 = r17
            r10 = r18
            float r0 = r9.m3340distanceInMinimumTouchTargettz77jQw(r10, r0)
            boolean r1 = java.lang.Float.isInfinite(r0)
            if (r1 != 0) goto L_0x0033
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L_0x0033
            r0 = 1
            goto L_0x0034
        L_0x0033:
            r0 = 0
        L_0x0034:
            if (r0 == 0) goto L_0x003d
            r0 = 1
            r12 = 0
            goto L_0x0040
        L_0x0039:
            r9 = r17
            r10 = r18
        L_0x003d:
            r12 = r22
            r0 = 0
        L_0x0040:
            if (r0 == 0) goto L_0x0098
            int r13 = r20.hitDepth
            androidx.compose.ui.node.LayoutNode r0 = r17.getLayoutNode$ui_release()
            androidx.compose.runtime.collection.MutableVector r0 = r0.getZSortedChildren()
            int r1 = r0.getSize()
            if (r1 <= 0) goto L_0x0095
            int r1 = r1 - r8
            java.lang.Object[] r14 = r0.getContent()
            r15 = r1
        L_0x005a:
            r0 = r14[r15]
            r16 = r0
            androidx.compose.ui.node.LayoutNode r16 = (androidx.compose.ui.node.LayoutNode) r16
            boolean r0 = r16.isPlaced()
            if (r0 == 0) goto L_0x008d
            r0 = r16
            r1 = r18
            r3 = r20
            r4 = r21
            r5 = r12
            r0.m3282hitTestM_7yMNQ$ui_release(r1, r3, r4, r5)
            boolean r0 = r20.hasHit()
            if (r0 != 0) goto L_0x007a
        L_0x0078:
            r0 = 1
            goto L_0x0089
        L_0x007a:
            androidx.compose.ui.node.LayoutNodeWrapper r0 = r16.getOuterLayoutNodeWrapper$ui_release()
            boolean r0 = r0.shouldSharePointerInputWithSiblings()
            if (r0 == 0) goto L_0x0088
            r20.acceptHits()
            goto L_0x0078
        L_0x0088:
            r0 = 0
        L_0x0089:
            if (r0 != 0) goto L_0x008d
            r0 = 1
            goto L_0x008e
        L_0x008d:
            r0 = 0
        L_0x008e:
            if (r0 == 0) goto L_0x0091
            goto L_0x0095
        L_0x0091:
            int r15 = r15 + -1
            if (r15 >= 0) goto L_0x005a
        L_0x0095:
            r6.hitDepth = r13
        L_0x0098:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.InnerPlaceable.m3261hitTestM_7yMNQ(long, androidx.compose.ui.node.HitTestResult, boolean, boolean):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x008e A[EDGE_INSN: B:32:0x008e->B:31:0x008e ?: BREAK  , SYNTHETIC] */
    /* renamed from: hitTestSemantics-9KIMszo  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m3262hitTestSemantics9KIMszo(long r18, androidx.compose.ui.node.HitTestResult<androidx.compose.ui.semantics.SemanticsWrapper> r20, boolean r21) {
        /*
            r17 = this;
            r6 = r20
            java.lang.String r0 = "hitSemanticsWrappers"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            boolean r0 = r17.m3355withinLayerBoundsk4lQ0M(r18)
            r7 = 0
            r8 = 1
            if (r0 == 0) goto L_0x0017
            r9 = r17
            r10 = r18
            r12 = r21
            r0 = 1
            goto L_0x003a
        L_0x0017:
            long r0 = r17.m3342getMinimumTouchTargetSizeNHjbRc()
            r9 = r17
            r10 = r18
            float r0 = r9.m3340distanceInMinimumTouchTargettz77jQw(r10, r0)
            boolean r1 = java.lang.Float.isInfinite(r0)
            if (r1 != 0) goto L_0x0031
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L_0x0031
            r0 = 1
            goto L_0x0032
        L_0x0031:
            r0 = 0
        L_0x0032:
            if (r0 == 0) goto L_0x0037
            r0 = 1
            r12 = 0
            goto L_0x003a
        L_0x0037:
            r12 = r21
            r0 = 0
        L_0x003a:
            if (r0 == 0) goto L_0x0091
            int r13 = r20.hitDepth
            androidx.compose.ui.node.LayoutNode r0 = r17.getLayoutNode$ui_release()
            androidx.compose.runtime.collection.MutableVector r0 = r0.getZSortedChildren()
            int r1 = r0.getSize()
            if (r1 <= 0) goto L_0x008e
            int r1 = r1 - r8
            java.lang.Object[] r14 = r0.getContent()
            r15 = r1
        L_0x0054:
            r0 = r14[r15]
            r16 = r0
            androidx.compose.ui.node.LayoutNode r16 = (androidx.compose.ui.node.LayoutNode) r16
            boolean r0 = r16.isPlaced()
            if (r0 == 0) goto L_0x0086
            r4 = 1
            r0 = r16
            r1 = r18
            r3 = r20
            r5 = r12
            r0.m3283hitTestSemanticsM_7yMNQ$ui_release(r1, r3, r4, r5)
            boolean r0 = r20.hasHit()
            if (r0 != 0) goto L_0x0073
        L_0x0071:
            r0 = 1
            goto L_0x0082
        L_0x0073:
            androidx.compose.ui.node.LayoutNodeWrapper r0 = r16.getOuterLayoutNodeWrapper$ui_release()
            boolean r0 = r0.shouldSharePointerInputWithSiblings()
            if (r0 == 0) goto L_0x0081
            r20.acceptHits()
            goto L_0x0071
        L_0x0081:
            r0 = 0
        L_0x0082:
            if (r0 != 0) goto L_0x0086
            r0 = 1
            goto L_0x0087
        L_0x0086:
            r0 = 0
        L_0x0087:
            if (r0 == 0) goto L_0x008a
            goto L_0x008e
        L_0x008a:
            int r15 = r15 + -1
            if (r15 >= 0) goto L_0x0054
        L_0x008e:
            r6.hitDepth = r13
        L_0x0091:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.InnerPlaceable.m3262hitTestSemantics9KIMszo(long, androidx.compose.ui.node.HitTestResult, boolean):void");
    }
}
