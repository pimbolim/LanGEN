package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.Constraints;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\bJ\u0010\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u0003H\u0002J\u000e\u0010!\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u0003J\u0018\u0010\"\u001a\u00020\b2\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010$J\u000e\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u0003J\u0010\u0010'\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u0003H\u0002J\u000e\u0010(\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u0003J\u000e\u0010)\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u0003J\u001b\u0010*\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020\u0018ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010-R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR \u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8F@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0002\n\u0000R\u0018\u0010\u0019\u001a\u00020\b*\u00020\u00038BX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006."}, d2 = {"Landroidx/compose/ui/node/MeasureAndLayoutDelegate;", "", "root", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "consistencyChecker", "Landroidx/compose/ui/node/LayoutTreeConsistencyChecker;", "duringMeasureLayout", "", "hasPendingMeasureOrLayout", "getHasPendingMeasureOrLayout", "()Z", "<set-?>", "", "measureIteration", "getMeasureIteration", "()J", "onPositionedDispatcher", "Landroidx/compose/ui/node/OnPositionedDispatcher;", "postponedMeasureRequests", "", "relayoutNodes", "Landroidx/compose/ui/node/DepthSortedSet;", "rootConstraints", "Landroidx/compose/ui/unit/Constraints;", "canAffectParent", "getCanAffectParent", "(Landroidx/compose/ui/node/LayoutNode;)Z", "dispatchOnPositionedCallbacks", "", "forceDispatch", "doRemeasure", "layoutNode", "forceMeasureTheSubtree", "measureAndLayout", "onLayout", "Lkotlin/Function0;", "onNodeDetached", "node", "remeasureAndRelayoutIfNeeded", "requestRelayout", "requestRemeasure", "updateRootConstraints", "constraints", "updateRootConstraints-BRTryo0", "(J)V", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MeasureAndLayoutDelegate.kt */
public final class MeasureAndLayoutDelegate {
    private final LayoutTreeConsistencyChecker consistencyChecker;
    private boolean duringMeasureLayout;
    private long measureIteration = 1;
    private final OnPositionedDispatcher onPositionedDispatcher = new OnPositionedDispatcher();
    private final List<LayoutNode> postponedMeasureRequests;
    private final DepthSortedSet relayoutNodes;
    /* access modifiers changed from: private */
    public final LayoutNode root;
    private Constraints rootConstraints;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MeasureAndLayoutDelegate.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutNode.LayoutState.values().length];
            iArr[LayoutNode.LayoutState.Measuring.ordinal()] = 1;
            iArr[LayoutNode.LayoutState.NeedsRemeasure.ordinal()] = 2;
            iArr[LayoutNode.LayoutState.LayingOut.ordinal()] = 3;
            iArr[LayoutNode.LayoutState.NeedsRelayout.ordinal()] = 4;
            iArr[LayoutNode.LayoutState.Ready.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public MeasureAndLayoutDelegate(LayoutNode layoutNode) {
        LayoutTreeConsistencyChecker layoutTreeConsistencyChecker;
        Intrinsics.checkNotNullParameter(layoutNode, "root");
        this.root = layoutNode;
        DepthSortedSet depthSortedSet = new DepthSortedSet(Owner.Companion.getEnableExtraAssertions());
        this.relayoutNodes = depthSortedSet;
        List<LayoutNode> arrayList = new ArrayList<>();
        this.postponedMeasureRequests = arrayList;
        if (Owner.Companion.getEnableExtraAssertions()) {
            layoutTreeConsistencyChecker = new LayoutTreeConsistencyChecker(layoutNode, depthSortedSet, arrayList);
        } else {
            layoutTreeConsistencyChecker = null;
        }
        this.consistencyChecker = layoutTreeConsistencyChecker;
    }

    public final boolean getHasPendingMeasureOrLayout() {
        return !this.relayoutNodes.isEmpty();
    }

    public final long getMeasureIteration() {
        if (this.duringMeasureLayout) {
            return this.measureIteration;
        }
        throw new IllegalArgumentException("measureIteration should be only used during the measure/layout pass".toString());
    }

    /* renamed from: updateRootConstraints-BRTryo0  reason: not valid java name */
    public final void m3356updateRootConstraintsBRTryo0(long j) {
        Constraints constraints = this.rootConstraints;
        if (constraints == null ? false : Constraints.m3796equalsimpl0(constraints.m3809unboximpl(), j)) {
            return;
        }
        if (!this.duringMeasureLayout) {
            this.rootConstraints = Constraints.m3791boximpl(j);
            this.root.setLayoutState$ui_release(LayoutNode.LayoutState.NeedsRemeasure);
            this.relayoutNodes.add(this.root);
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public final boolean requestRemeasure(LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        int i = WhenMappings.$EnumSwitchMapping$0[layoutNode.getLayoutState$ui_release().ordinal()];
        if (!(i == 1 || i == 2)) {
            if (i == 3) {
                this.postponedMeasureRequests.add(layoutNode);
                LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.consistencyChecker;
                if (layoutTreeConsistencyChecker != null) {
                    layoutTreeConsistencyChecker.assertConsistent();
                }
            } else if (i == 4 || i == 5) {
                layoutNode.setLayoutState$ui_release(LayoutNode.LayoutState.NeedsRemeasure);
                if (layoutNode.isPlaced() || getCanAffectParent(layoutNode)) {
                    LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
                    if ((parent$ui_release == null ? null : parent$ui_release.getLayoutState$ui_release()) != LayoutNode.LayoutState.NeedsRemeasure) {
                        this.relayoutNodes.add(layoutNode);
                    }
                }
                if (!this.duringMeasureLayout) {
                    return true;
                }
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        return false;
    }

    public final boolean requestRelayout(LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        int i = WhenMappings.$EnumSwitchMapping$0[layoutNode.getLayoutState$ui_release().ordinal()];
        if (i == 1 || i == 2 || i == 3 || i == 4) {
            LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.consistencyChecker;
            if (layoutTreeConsistencyChecker == null) {
                return false;
            }
            layoutTreeConsistencyChecker.assertConsistent();
            return false;
        } else if (i == 5) {
            layoutNode.setLayoutState$ui_release(LayoutNode.LayoutState.NeedsRelayout);
            if (layoutNode.isPlaced()) {
                LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
                LayoutNode.LayoutState layoutState$ui_release = parent$ui_release == null ? null : parent$ui_release.getLayoutState$ui_release();
                if (!(layoutState$ui_release == LayoutNode.LayoutState.NeedsRemeasure || layoutState$ui_release == LayoutNode.LayoutState.NeedsRelayout)) {
                    this.relayoutNodes.add(layoutNode);
                }
            }
            if (!this.duringMeasureLayout) {
                return true;
            }
            return false;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final boolean doRemeasure(LayoutNode layoutNode) {
        boolean z;
        boolean z2 = true;
        if (layoutNode == this.root) {
            Constraints constraints = this.rootConstraints;
            Intrinsics.checkNotNull(constraints);
            z = layoutNode.m3285remeasure_Sx5XlM$ui_release(constraints);
        } else {
            z = LayoutNode.m3281remeasure_Sx5XlM$ui_release$default(layoutNode, (Constraints) null, 1, (Object) null);
        }
        LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
        if (z && parent$ui_release != null) {
            if (layoutNode.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.InMeasureBlock) {
                requestRemeasure(parent$ui_release);
            } else {
                if (layoutNode.getMeasuredByParent$ui_release() != LayoutNode.UsageByParent.InLayoutBlock) {
                    z2 = false;
                }
                if (z2) {
                    requestRelayout(parent$ui_release);
                } else {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
            }
        }
        return z;
    }

    public static /* synthetic */ boolean measureAndLayout$default(MeasureAndLayoutDelegate measureAndLayoutDelegate, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        return measureAndLayoutDelegate.measureAndLayout(function0);
    }

    /* JADX INFO: finally extract failed */
    public final boolean measureAndLayout(Function0<Unit> function0) {
        if (!this.root.isAttached()) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (!this.root.isPlaced()) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (!(!this.duringMeasureLayout)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (this.rootConstraints == null || !(!this.relayoutNodes.isEmpty())) {
            return false;
        } else {
            this.duringMeasureLayout = true;
            try {
                DepthSortedSet depthSortedSet = this.relayoutNodes;
                boolean z = false;
                while (!depthSortedSet.isEmpty()) {
                    LayoutNode pop = depthSortedSet.pop();
                    boolean access$remeasureAndRelayoutIfNeeded = remeasureAndRelayoutIfNeeded(pop);
                    if (pop == this.root && access$remeasureAndRelayoutIfNeeded) {
                        z = true;
                    }
                }
                this.duringMeasureLayout = false;
                LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.consistencyChecker;
                if (layoutTreeConsistencyChecker != null) {
                    layoutTreeConsistencyChecker.assertConsistent();
                }
                if (function0 != null) {
                    function0.invoke();
                }
                return z;
            } catch (Throwable th) {
                this.duringMeasureLayout = false;
                throw th;
            }
        }
    }

    /* access modifiers changed from: private */
    public final boolean remeasureAndRelayoutIfNeeded(LayoutNode layoutNode) {
        int i = 0;
        if (!layoutNode.isPlaced() && !getCanAffectParent(layoutNode) && !layoutNode.getAlignmentLines$ui_release().getRequired$ui_release()) {
            return false;
        }
        boolean doRemeasure = layoutNode.getLayoutState$ui_release() == LayoutNode.LayoutState.NeedsRemeasure ? doRemeasure(layoutNode) : false;
        if (layoutNode.getLayoutState$ui_release() == LayoutNode.LayoutState.NeedsRelayout && layoutNode.isPlaced()) {
            if (layoutNode == this.root) {
                layoutNode.place$ui_release(0, 0);
            } else {
                layoutNode.replace$ui_release();
            }
            this.onPositionedDispatcher.onNodePositioned(layoutNode);
            LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.consistencyChecker;
            if (layoutTreeConsistencyChecker != null) {
                layoutTreeConsistencyChecker.assertConsistent();
            }
        }
        if (!this.postponedMeasureRequests.isEmpty()) {
            List<LayoutNode> list = this.postponedMeasureRequests;
            int size = list.size();
            while (i < size) {
                int i2 = i + 1;
                LayoutNode layoutNode2 = list.get(i);
                if (layoutNode2.isAttached()) {
                    requestRemeasure(layoutNode2);
                }
                i = i2;
            }
            this.postponedMeasureRequests.clear();
        }
        return doRemeasure;
    }

    public final void forceMeasureTheSubtree(LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        if (!this.relayoutNodes.isEmpty()) {
            if (this.duringMeasureLayout) {
                int i = 0;
                if (layoutNode.getLayoutState$ui_release() != LayoutNode.LayoutState.NeedsRemeasure) {
                    MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui_release();
                    int size = mutableVector.getSize();
                    if (size > 0) {
                        Object[] content = mutableVector.getContent();
                        do {
                            LayoutNode layoutNode2 = (LayoutNode) content[i];
                            if (layoutNode2.getLayoutState$ui_release() == LayoutNode.LayoutState.NeedsRemeasure && this.relayoutNodes.remove(layoutNode2)) {
                                remeasureAndRelayoutIfNeeded(layoutNode2);
                            }
                            if (layoutNode2.getLayoutState$ui_release() != LayoutNode.LayoutState.NeedsRemeasure) {
                                forceMeasureTheSubtree(layoutNode2);
                            }
                            i++;
                        } while (i < size);
                    }
                    if (layoutNode.getLayoutState$ui_release() == LayoutNode.LayoutState.NeedsRemeasure && this.relayoutNodes.remove(layoutNode)) {
                        remeasureAndRelayoutIfNeeded(layoutNode);
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    public static /* synthetic */ void dispatchOnPositionedCallbacks$default(MeasureAndLayoutDelegate measureAndLayoutDelegate, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        measureAndLayoutDelegate.dispatchOnPositionedCallbacks(z);
    }

    public final void dispatchOnPositionedCallbacks(boolean z) {
        if (z) {
            this.onPositionedDispatcher.onRootNodePositioned(this.root);
        }
        this.onPositionedDispatcher.dispatch();
    }

    public final void onNodeDetached(LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "node");
        this.relayoutNodes.remove(layoutNode);
    }

    private final boolean getCanAffectParent(LayoutNode layoutNode) {
        return layoutNode.getLayoutState$ui_release() == LayoutNode.LayoutState.NeedsRemeasure && (layoutNode.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.InMeasureBlock || layoutNode.getAlignmentLines$ui_release().getRequired$ui_release());
    }
}
