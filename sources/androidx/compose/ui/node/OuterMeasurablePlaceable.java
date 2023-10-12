package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.ClassUtils;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0011\u0010-\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u00100\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u001dH\u0016J\u0010\u00102\u001a\u00020\u001d2\u0006\u00103\u001a\u00020\u001dH\u0016J\u001d\u00104\u001a\u00020\u00022\u0006\u00105\u001a\u00020\u000fH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b6\u00107J\u0010\u00108\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u001dH\u0016J\u0010\u00109\u001a\u00020\u001d2\u0006\u00103\u001a\u00020\u001dH\u0016J\b\u0010:\u001a\u00020\u0015H\u0002J@\u0010;\u001a\u00020\u00152\u0006\u0010<\u001a\u00020\u00182\u0006\u0010=\u001a\u00020\u001b2\u0019\u0010>\u001a\u0015\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0013¢\u0006\u0002\b\u0016H\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b?\u0010@J@\u0010A\u001a\u00020\u00152\u0006\u0010<\u001a\u00020\u00182\u0006\u0010=\u001a\u00020\u001b2\u0019\u0010>\u001a\u0015\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0013¢\u0006\u0002\b\u0016H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bB\u0010@J\u0006\u0010C\u001a\u00020\u0015J\u001b\u0010D\u001a\u00020\t2\u0006\u00105\u001a\u00020\u000fø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bE\u0010FJ\u0006\u0010G\u001a\u00020\u0015R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000f8Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R!\u0010\u0012\u001a\u0015\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0013¢\u0006\u0002\b\u0016X\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u0017\u001a\u00020\u0018X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u00020\u001d8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\u00020\u001d8VX\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u001fR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010)\u001a\u0004\u0018\u00010(2\b\u0010'\u001a\u0004\u0018\u00010(@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006H"}, d2 = {"Landroidx/compose/ui/node/OuterMeasurablePlaceable;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/layout/Placeable;", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "outerWrapper", "Landroidx/compose/ui/node/LayoutNodeWrapper;", "(Landroidx/compose/ui/node/LayoutNode;Landroidx/compose/ui/node/LayoutNodeWrapper;)V", "duringAlignmentLinesQuery", "", "getDuringAlignmentLinesQuery$ui_release", "()Z", "setDuringAlignmentLinesQuery$ui_release", "(Z)V", "lastConstraints", "Landroidx/compose/ui/unit/Constraints;", "getLastConstraints-DWUhwKw", "()Landroidx/compose/ui/unit/Constraints;", "lastLayerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "", "Lkotlin/ExtensionFunctionType;", "lastPosition", "Landroidx/compose/ui/unit/IntOffset;", "J", "lastZIndex", "", "measuredHeight", "", "getMeasuredHeight", "()I", "measuredOnce", "measuredWidth", "getMeasuredWidth", "getOuterWrapper", "()Landroidx/compose/ui/node/LayoutNodeWrapper;", "setOuterWrapper", "(Landroidx/compose/ui/node/LayoutNodeWrapper;)V", "<set-?>", "", "parentData", "getParentData", "()Ljava/lang/Object;", "placedOnce", "get", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "maxIntrinsicHeight", "width", "maxIntrinsicWidth", "height", "measure", "constraints", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicHeight", "minIntrinsicWidth", "onIntrinsicsQueried", "placeAt", "position", "zIndex", "layerBlock", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "placeOuterWrapper", "placeOuterWrapper-f8xVGno", "recalculateParentData", "remeasure", "remeasure-BRTryo0", "(J)Z", "replace", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OuterMeasurablePlaceable.kt */
public final class OuterMeasurablePlaceable extends Placeable implements Measurable {
    private boolean duringAlignmentLinesQuery;
    private Function1<? super GraphicsLayerScope, Unit> lastLayerBlock;
    private long lastPosition = IntOffset.Companion.m3987getZeronOccac();
    private float lastZIndex;
    private final LayoutNode layoutNode;
    private boolean measuredOnce;
    private LayoutNodeWrapper outerWrapper;
    private Object parentData;
    private boolean placedOnce;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: OuterMeasurablePlaceable.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutNode.LayoutState.values().length];
            iArr[LayoutNode.LayoutState.Measuring.ordinal()] = 1;
            iArr[LayoutNode.LayoutState.LayingOut.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final LayoutNodeWrapper getOuterWrapper() {
        return this.outerWrapper;
    }

    public final void setOuterWrapper(LayoutNodeWrapper layoutNodeWrapper) {
        Intrinsics.checkNotNullParameter(layoutNodeWrapper, "<set-?>");
        this.outerWrapper = layoutNodeWrapper;
    }

    public OuterMeasurablePlaceable(LayoutNode layoutNode2, LayoutNodeWrapper layoutNodeWrapper) {
        Intrinsics.checkNotNullParameter(layoutNode2, "layoutNode");
        Intrinsics.checkNotNullParameter(layoutNodeWrapper, "outerWrapper");
        this.layoutNode = layoutNode2;
        this.outerWrapper = layoutNodeWrapper;
    }

    /* renamed from: getLastConstraints-DWUhwKw  reason: not valid java name */
    public final Constraints m3363getLastConstraintsDWUhwKw() {
        if (this.measuredOnce) {
            return Constraints.m3791boximpl(m3174getMeasurementConstraintsmsEJaDk());
        }
        return null;
    }

    public final boolean getDuringAlignmentLinesQuery$ui_release() {
        return this.duringAlignmentLinesQuery;
    }

    public final void setDuringAlignmentLinesQuery$ui_release(boolean z) {
        this.duringAlignmentLinesQuery = z;
    }

    public Object getParentData() {
        return this.parentData;
    }

    /* renamed from: measure-BRTryo0  reason: not valid java name */
    public Placeable m3364measureBRTryo0(long j) {
        LayoutNode.UsageByParent usageByParent;
        LayoutNode parent$ui_release = this.layoutNode.getParent$ui_release();
        if (parent$ui_release != null) {
            if (this.layoutNode.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.NotUsed || this.layoutNode.getCanMultiMeasure$ui_release()) {
                LayoutNode layoutNode2 = this.layoutNode;
                int i = WhenMappings.$EnumSwitchMapping$0[parent$ui_release.getLayoutState$ui_release().ordinal()];
                if (i == 1) {
                    usageByParent = LayoutNode.UsageByParent.InMeasureBlock;
                } else if (i == 2) {
                    usageByParent = LayoutNode.UsageByParent.InLayoutBlock;
                } else {
                    throw new IllegalStateException(Intrinsics.stringPlus("Measurable could be only measured from the parent's measure or layout block.Parents state is ", parent$ui_release.getLayoutState$ui_release()));
                }
                layoutNode2.setMeasuredByParent$ui_release(usageByParent);
            } else {
                throw new IllegalStateException(("measure() may not be called multiple times on the same Measurable. Current state " + this.layoutNode.getMeasuredByParent$ui_release() + ". Parent state " + parent$ui_release.getLayoutState$ui_release() + ClassUtils.PACKAGE_SEPARATOR_CHAR).toString());
            }
        } else {
            this.layoutNode.setMeasuredByParent$ui_release(LayoutNode.UsageByParent.NotUsed);
        }
        m3366remeasureBRTryo0(j);
        return this;
    }

    /* renamed from: remeasure-BRTryo0  reason: not valid java name */
    public final boolean m3366remeasureBRTryo0(long j) {
        Owner requireOwner = LayoutNodeKt.requireOwner(this.layoutNode);
        LayoutNode parent$ui_release = this.layoutNode.getParent$ui_release();
        LayoutNode layoutNode2 = this.layoutNode;
        boolean z = true;
        layoutNode2.setCanMultiMeasure$ui_release(layoutNode2.getCanMultiMeasure$ui_release() || (parent$ui_release != null && parent$ui_release.getCanMultiMeasure$ui_release()));
        if (this.layoutNode.getLayoutState$ui_release() == LayoutNode.LayoutState.NeedsRemeasure || !Constraints.m3796equalsimpl0(m3174getMeasurementConstraintsmsEJaDk(), j)) {
            this.layoutNode.getAlignmentLines$ui_release().setUsedByModifierMeasurement$ui_release(false);
            MutableVector<LayoutNode> mutableVector = this.layoutNode.get_children$ui_release();
            int size = mutableVector.getSize();
            if (size > 0) {
                Object[] content = mutableVector.getContent();
                int i = 0;
                do {
                    ((LayoutNode) content[i]).getAlignmentLines$ui_release().setUsedDuringParentMeasurement$ui_release(false);
                    i++;
                } while (i < size);
            }
            this.measuredOnce = true;
            this.layoutNode.setLayoutState$ui_release(LayoutNode.LayoutState.Measuring);
            m3177setMeasurementConstraintsBRTryo0(j);
            long r1 = this.outerWrapper.m3344getSizeYbymL2g();
            requireOwner.getSnapshotObserver().observeMeasureSnapshotReads$ui_release(this.layoutNode, new OuterMeasurablePlaceable$remeasure$2(this, j));
            if (this.layoutNode.getLayoutState$ui_release() == LayoutNode.LayoutState.Measuring) {
                this.layoutNode.setLayoutState$ui_release(LayoutNode.LayoutState.NeedsRelayout);
            }
            if (IntSize.m4017equalsimpl0(this.outerWrapper.m3344getSizeYbymL2g(), r1) && this.outerWrapper.getWidth() == getWidth() && this.outerWrapper.getHeight() == getHeight()) {
                z = false;
            }
            m3176setMeasuredSizeozmzZPI(IntSizeKt.IntSize(this.outerWrapper.getWidth(), this.outerWrapper.getHeight()));
            return z;
        }
        requireOwner.forceMeasureTheSubtree(this.layoutNode);
        return false;
    }

    public int getMeasuredWidth() {
        return this.outerWrapper.getMeasuredWidth();
    }

    public int getMeasuredHeight() {
        return this.outerWrapper.getMeasuredHeight();
    }

    public int get(AlignmentLine alignmentLine) {
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        LayoutNode parent$ui_release = this.layoutNode.getParent$ui_release();
        LayoutNode.LayoutState layoutState = null;
        if ((parent$ui_release == null ? null : parent$ui_release.getLayoutState$ui_release()) == LayoutNode.LayoutState.Measuring) {
            this.layoutNode.getAlignmentLines$ui_release().setUsedDuringParentMeasurement$ui_release(true);
        } else {
            LayoutNode parent$ui_release2 = this.layoutNode.getParent$ui_release();
            if (parent$ui_release2 != null) {
                layoutState = parent$ui_release2.getLayoutState$ui_release();
            }
            if (layoutState == LayoutNode.LayoutState.LayingOut) {
                this.layoutNode.getAlignmentLines$ui_release().setUsedDuringParentLayout$ui_release(true);
            }
        }
        this.duringAlignmentLinesQuery = true;
        int i = this.outerWrapper.get(alignmentLine);
        this.duringAlignmentLinesQuery = false;
        return i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: placeAt-f8xVGno  reason: not valid java name */
    public void m3365placeAtf8xVGno(long j, float f, Function1<? super GraphicsLayerScope, Unit> function1) {
        this.lastPosition = j;
        this.lastZIndex = f;
        this.lastLayerBlock = function1;
        LayoutNodeWrapper wrappedBy$ui_release = this.outerWrapper.getWrappedBy$ui_release();
        if (wrappedBy$ui_release != null && wrappedBy$ui_release.isShallowPlacing()) {
            m3362placeOuterWrapperf8xVGno(j, f, function1);
            return;
        }
        this.placedOnce = true;
        this.layoutNode.getAlignmentLines$ui_release().setUsedByModifierLayout$ui_release(false);
        LayoutNodeKt.requireOwner(this.layoutNode).getSnapshotObserver().observeLayoutModifierSnapshotReads$ui_release(this.layoutNode, new OuterMeasurablePlaceable$placeAt$1(this, j, f, function1));
    }

    /* access modifiers changed from: private */
    /* renamed from: placeOuterWrapper-f8xVGno  reason: not valid java name */
    public final void m3362placeOuterWrapperf8xVGno(long j, float f, Function1<? super GraphicsLayerScope, Unit> function1) {
        Placeable.PlacementScope.Companion companion = Placeable.PlacementScope.Companion;
        if (function1 == null) {
            companion.m3182place70tqf50(getOuterWrapper(), j, f);
        } else {
            companion.m3187placeWithLayeraW9wM(getOuterWrapper(), j, f, function1);
        }
    }

    public final void replace() {
        if (this.placedOnce) {
            m3365placeAtf8xVGno(this.lastPosition, this.lastZIndex, this.lastLayerBlock);
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public int minIntrinsicWidth(int i) {
        onIntrinsicsQueried();
        return this.outerWrapper.minIntrinsicWidth(i);
    }

    public int maxIntrinsicWidth(int i) {
        onIntrinsicsQueried();
        return this.outerWrapper.maxIntrinsicWidth(i);
    }

    public int minIntrinsicHeight(int i) {
        onIntrinsicsQueried();
        return this.outerWrapper.minIntrinsicHeight(i);
    }

    public int maxIntrinsicHeight(int i) {
        onIntrinsicsQueried();
        return this.outerWrapper.maxIntrinsicHeight(i);
    }

    private final void onIntrinsicsQueried() {
        this.layoutNode.requestRemeasure$ui_release();
    }

    public final void recalculateParentData() {
        this.parentData = this.outerWrapper.getParentData();
    }
}
