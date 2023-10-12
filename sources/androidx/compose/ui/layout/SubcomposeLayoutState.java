package androidx.compose.ui.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.Wrapper_androidKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001:\u0003RSTB\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J*\u0010*\u001a\u00020+2\u001d\u0010,\u001a\u0019\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\u001d¢\u0006\u0002\b!H\u0002ø\u0001\u0000J\u0010\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020\u0004H\u0002J\u0010\u0010/\u001a\u00020\"2\u0006\u0010\u0010\u001a\u00020\u0004H\u0002J\r\u00100\u001a\u00020\"H\u0000¢\u0006\u0002\b1J\u0010\u00102\u001a\u00020\"2\u0006\u00103\u001a\u00020\tH\u0002J\r\u00104\u001a\u00020\"H\u0000¢\u0006\u0002\b5J\u0017\u00106\u001a\u00020\"2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\"07H\bJ\b\u00108\u001a\u00020\"H\u0002J\"\u00109\u001a\u00020\"2\u0006\u0010:\u001a\u00020\u00042\u0006\u0010;\u001a\u00020\u00042\b\b\u0002\u0010<\u001a\u00020\u0004H\u0002J(\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010\u00012\u0011\u0010@\u001a\r\u0012\u0004\u0012\u00020\"07¢\u0006\u0002\bA¢\u0006\u0002\u0010BJ\u0018\u0010C\u001a\u00020\"2\u0006\u00103\u001a\u00020\t2\u0006\u0010D\u001a\u00020\u0013H\u0002J2\u0010C\u001a\u00020\"2\u0006\u00103\u001a\u00020\t2\b\u0010?\u001a\u0004\u0018\u00010\u00012\u0011\u0010@\u001a\r\u0012\u0004\u0012\u00020\"07¢\u0006\u0002\bAH\u0002¢\u0006\u0002\u0010EJ2\u0010C\u001a\b\u0012\u0004\u0012\u00020G0F2\b\u0010?\u001a\u0004\u0018\u00010\u00012\u0011\u0010@\u001a\r\u0012\u0004\u0012\u00020\"07¢\u0006\u0002\bAH\u0000¢\u0006\u0004\bH\u0010IJ:\u0010J\u001a\u00020K2\b\u0010L\u001a\u0004\u0018\u00010K2\u0006\u0010M\u001a\u00020\t2\u0006\u0010N\u001a\u00020\u000b2\u0011\u0010O\u001a\r\u0012\u0004\u0012\u00020\"07¢\u0006\u0002\bAH\u0002¢\u0006\u0002\u0010PJ\u0012\u0010Q\u001a\u00020\t2\b\u0010?\u001a\u0004\u0018\u00010\u0001H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00130\u0012X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\t0\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\t8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0012\u0010\u001a\u001a\u00060\u001bR\u00020\u0000X\u0004¢\u0006\u0002\n\u0000RE\u0010\u001c\u001a0\u0012\u0004\u0012\u00020\t\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\u001d¢\u0006\u0002\b!\u0012\u0004\u0012\u00020\"0\u001d¢\u0006\u0002\b!X\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R%\u0010%\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\"0&¢\u0006\u0002\b!X\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u001c\u0010)\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\t0\u0012X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006U"}, d2 = {"Landroidx/compose/ui/layout/SubcomposeLayoutState;", "", "()V", "maxSlotsToRetainForReuse", "", "(I)V", "NoIntrinsicsMessage", "", "_root", "Landroidx/compose/ui/node/LayoutNode;", "compositionContext", "Landroidx/compose/runtime/CompositionContext;", "getCompositionContext$ui_release", "()Landroidx/compose/runtime/CompositionContext;", "setCompositionContext$ui_release", "(Landroidx/compose/runtime/CompositionContext;)V", "currentIndex", "nodeToNodeState", "", "Landroidx/compose/ui/layout/SubcomposeLayoutState$NodeState;", "precomposeMap", "precomposedCount", "reusableCount", "root", "getRoot", "()Landroidx/compose/ui/node/LayoutNode;", "scope", "Landroidx/compose/ui/layout/SubcomposeLayoutState$Scope;", "setMeasurePolicy", "Lkotlin/Function2;", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "Lkotlin/ExtensionFunctionType;", "", "getSetMeasurePolicy$ui_release", "()Lkotlin/jvm/functions/Function2;", "setRoot", "Lkotlin/Function1;", "getSetRoot$ui_release", "()Lkotlin/jvm/functions/Function1;", "slotIdToNode", "createMeasurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "block", "createNodeAt", "index", "disposeAfterIndex", "disposeCurrentNodes", "disposeCurrentNodes$ui_release", "disposeNode", "node", "forceRecomposeChildren", "forceRecomposeChildren$ui_release", "ignoreRemeasureRequests", "Lkotlin/Function0;", "makeSureStateIsConsistent", "move", "from", "to", "count", "precompose", "Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "slotId", "content", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "subcompose", "nodeState", "(Landroidx/compose/ui/node/LayoutNode;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "", "Landroidx/compose/ui/layout/Measurable;", "subcompose$ui_release", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "subcomposeInto", "Landroidx/compose/runtime/Composition;", "existing", "container", "parent", "composable", "(Landroidx/compose/runtime/Composition;Landroidx/compose/ui/node/LayoutNode;Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function2;)Landroidx/compose/runtime/Composition;", "takeNodeFromReusables", "NodeState", "PrecomposedSlotHandle", "Scope", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SubcomposeLayout.kt */
public final class SubcomposeLayoutState {
    public static final int $stable = 8;
    private final String NoIntrinsicsMessage;
    /* access modifiers changed from: private */
    public LayoutNode _root;
    private CompositionContext compositionContext;
    /* access modifiers changed from: private */
    public int currentIndex;
    /* access modifiers changed from: private */
    public final int maxSlotsToRetainForReuse;
    private final Map<LayoutNode, NodeState> nodeToNodeState;
    /* access modifiers changed from: private */
    public final Map<Object, LayoutNode> precomposeMap;
    /* access modifiers changed from: private */
    public int precomposedCount;
    /* access modifiers changed from: private */
    public int reusableCount;
    /* access modifiers changed from: private */
    public final Scope scope;
    private final Function2<LayoutNode, Function2<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult>, Unit> setMeasurePolicy;
    private final Function1<LayoutNode, Unit> setRoot;
    private final Map<Object, LayoutNode> slotIdToNode;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "", "dispose", "", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SubcomposeLayout.kt */
    public interface PrecomposedSlotHandle {
        void dispose();
    }

    public SubcomposeLayoutState(int i) {
        this.maxSlotsToRetainForReuse = i;
        this.setRoot = new SubcomposeLayoutState$setRoot$1(this);
        this.setMeasurePolicy = new SubcomposeLayoutState$setMeasurePolicy$1(this);
        this.nodeToNodeState = new LinkedHashMap();
        this.slotIdToNode = new LinkedHashMap();
        this.scope = new Scope(this);
        this.precomposeMap = new LinkedHashMap();
        this.NoIntrinsicsMessage = "Asking for intrinsic measurements of SubcomposeLayout layouts is not supported. This includes components that are built on top of SubcomposeLayout, such as lazy lists, BoxWithConstraints, TabRow, etc. To mitigate this:\n- if intrinsic measurements are used to achieve 'match parent' sizing,, consider replacing the parent of the component with a custom layout which controls the order in which children are measured, making intrinsic measurement not needed\n- adding a size modifier to the component, in order to fast return the queried intrinsic measurement.";
    }

    public SubcomposeLayoutState() {
        this(0);
    }

    public final CompositionContext getCompositionContext$ui_release() {
        return this.compositionContext;
    }

    public final void setCompositionContext$ui_release(CompositionContext compositionContext2) {
        this.compositionContext = compositionContext2;
    }

    public final Function1<LayoutNode, Unit> getSetRoot$ui_release() {
        return this.setRoot;
    }

    public final Function2<LayoutNode, Function2<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult>, Unit> getSetMeasurePolicy$ui_release() {
        return this.setMeasurePolicy;
    }

    /* access modifiers changed from: private */
    public final LayoutNode getRoot() {
        LayoutNode layoutNode = this._root;
        if (layoutNode != null) {
            return layoutNode;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final List<Measurable> subcompose$ui_release(Object obj, Function2<? super Composer, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "content");
        makeSureStateIsConsistent();
        LayoutNode.LayoutState layoutState$ui_release = getRoot().getLayoutState$ui_release();
        boolean z = false;
        if (layoutState$ui_release == LayoutNode.LayoutState.Measuring || layoutState$ui_release == LayoutNode.LayoutState.LayingOut) {
            Map<Object, LayoutNode> map = this.slotIdToNode;
            LayoutNode layoutNode = map.get(obj);
            if (layoutNode == null) {
                layoutNode = this.precomposeMap.remove(obj);
                if (layoutNode != null) {
                    int i = this.precomposedCount;
                    if (i > 0) {
                        z = true;
                    }
                    if (z) {
                        this.precomposedCount = i - 1;
                    } else {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                } else if (this.reusableCount > 0) {
                    layoutNode = takeNodeFromReusables(obj);
                } else {
                    layoutNode = createNodeAt(this.currentIndex);
                }
                map.put(obj, layoutNode);
            }
            LayoutNode layoutNode2 = layoutNode;
            int indexOf = getRoot().getFoldedChildren$ui_release().indexOf(layoutNode2);
            int i2 = this.currentIndex;
            if (indexOf >= i2) {
                if (i2 != indexOf) {
                    move$default(this, indexOf, i2, 0, 4, (Object) null);
                }
                this.currentIndex++;
                subcompose(layoutNode2, obj, function2);
                return layoutNode2.getChildren$ui_release();
            }
            throw new IllegalArgumentException("Key " + obj + " was already used. If you are using LazyColumn/Row please make sure you provide a unique key for each item.");
        }
        throw new IllegalStateException("subcompose can only be used inside the measure or layout blocks".toString());
    }

    private final void subcompose(LayoutNode layoutNode, Object obj, Function2<? super Composer, ? super Integer, Unit> function2) {
        Map<LayoutNode, NodeState> map = this.nodeToNodeState;
        NodeState nodeState = map.get(layoutNode);
        if (nodeState == null) {
            nodeState = new NodeState(obj, ComposableSingletons$SubcomposeLayoutKt.INSTANCE.m3097getLambda1$ui_release(), (Composition) null, 4, (DefaultConstructorMarker) null);
            map.put(layoutNode, nodeState);
        }
        NodeState nodeState2 = nodeState;
        Composition composition = nodeState2.getComposition();
        boolean hasInvalidations = composition == null ? true : composition.getHasInvalidations();
        if (nodeState2.getContent() != function2 || hasInvalidations || nodeState2.getForceRecompose()) {
            nodeState2.setContent(function2);
            subcompose(layoutNode, nodeState2);
            nodeState2.setForceRecompose(false);
        }
    }

    private final void subcompose(LayoutNode layoutNode, NodeState nodeState) {
        layoutNode.withNoSnapshotReadObservation$ui_release(new SubcomposeLayoutState$subcompose$2(this, nodeState, layoutNode));
    }

    /* access modifiers changed from: private */
    public final Composition subcomposeInto(Composition composition, LayoutNode layoutNode, CompositionContext compositionContext2, Function2<? super Composer, ? super Integer, Unit> function2) {
        if (composition == null || composition.isDisposed()) {
            composition = Wrapper_androidKt.createSubcomposition(layoutNode, compositionContext2);
        }
        composition.setContent(function2);
        return composition;
    }

    /* access modifiers changed from: private */
    public final void disposeAfterIndex(int i) {
        int size = getRoot().getFoldedChildren$ui_release().size() - this.precomposedCount;
        int max = Math.max(i, size - this.maxSlotsToRetainForReuse);
        int i2 = size - max;
        this.reusableCount = i2;
        int i3 = i2 + max;
        int i4 = max;
        while (i4 < i3) {
            int i5 = i4 + 1;
            NodeState nodeState = this.nodeToNodeState.get(getRoot().getFoldedChildren$ui_release().get(i4));
            Intrinsics.checkNotNull(nodeState);
            this.slotIdToNode.remove(nodeState.getSlotId());
            i4 = i5;
        }
        int i6 = max - i;
        if (i6 > 0) {
            LayoutNode access$getRoot = getRoot();
            access$getRoot.ignoreRemeasureRequests = true;
            int i7 = i + i6;
            for (int i8 = i; i8 < i7; i8++) {
                disposeNode(getRoot().getFoldedChildren$ui_release().get(i8));
            }
            getRoot().removeAt$ui_release(i, i6);
            access$getRoot.ignoreRemeasureRequests = false;
        }
        makeSureStateIsConsistent();
    }

    private final void makeSureStateIsConsistent() {
        if (!(this.nodeToNodeState.size() == getRoot().getFoldedChildren$ui_release().size())) {
            throw new IllegalArgumentException(("Inconsistency between the count of nodes tracked by the state (" + this.nodeToNodeState.size() + ") and the children count on the SubcomposeLayout (" + getRoot().getFoldedChildren$ui_release().size() + "). Are you trying to use the state of the disposed SubcomposeLayout?").toString());
        }
    }

    private final LayoutNode takeNodeFromReusables(Object obj) {
        if (this.reusableCount > 0) {
            int size = getRoot().getFoldedChildren$ui_release().size() - this.precomposedCount;
            int i = size - this.reusableCount;
            int i2 = i;
            while (true) {
                NodeState nodeState = (NodeState) MapsKt.getValue(this.nodeToNodeState, getRoot().getFoldedChildren$ui_release().get(i2));
                if (Intrinsics.areEqual(nodeState.getSlotId(), obj)) {
                    break;
                } else if (i2 == size - 1) {
                    nodeState.setSlotId(obj);
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 != i) {
                move(i2, i, 1);
            }
            this.reusableCount--;
            return getRoot().getFoldedChildren$ui_release().get(i);
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    /* access modifiers changed from: private */
    public final void disposeNode(LayoutNode layoutNode) {
        NodeState remove = this.nodeToNodeState.remove(layoutNode);
        Intrinsics.checkNotNull(remove);
        NodeState nodeState = remove;
        Composition composition = nodeState.getComposition();
        Intrinsics.checkNotNull(composition);
        composition.dispose();
        this.slotIdToNode.remove(nodeState.getSlotId());
    }

    /* access modifiers changed from: private */
    public final MeasurePolicy createMeasurePolicy(Function2<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult> function2) {
        return new SubcomposeLayoutState$createMeasurePolicy$1(this, function2, this.NoIntrinsicsMessage);
    }

    public final void disposeCurrentNodes$ui_release() {
        for (NodeState composition : this.nodeToNodeState.values()) {
            Composition composition2 = composition.getComposition();
            if (composition2 != null) {
                composition2.dispose();
            }
        }
        this.nodeToNodeState.clear();
        this.slotIdToNode.clear();
    }

    public final PrecomposedSlotHandle precompose(Object obj, Function2<? super Composer, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "content");
        makeSureStateIsConsistent();
        if (!this.slotIdToNode.containsKey(obj)) {
            Map<Object, LayoutNode> map = this.precomposeMap;
            LayoutNode layoutNode = map.get(obj);
            if (layoutNode == null) {
                if (this.reusableCount > 0) {
                    layoutNode = takeNodeFromReusables(obj);
                    move(getRoot().getFoldedChildren$ui_release().indexOf(layoutNode), getRoot().getFoldedChildren$ui_release().size(), 1);
                    this.precomposedCount++;
                } else {
                    layoutNode = createNodeAt(getRoot().getFoldedChildren$ui_release().size());
                    this.precomposedCount++;
                }
                map.put(obj, layoutNode);
            }
            subcompose(layoutNode, obj, function2);
        }
        return new SubcomposeLayoutState$precompose$1(this, obj);
    }

    public final void forceRecomposeChildren$ui_release() {
        LayoutNode layoutNode = this._root;
        if (layoutNode != null) {
            for (Map.Entry<LayoutNode, NodeState> value : this.nodeToNodeState.entrySet()) {
                ((NodeState) value.getValue()).setForceRecompose(true);
            }
            if (layoutNode.getLayoutState$ui_release() != LayoutNode.LayoutState.NeedsRemeasure) {
                layoutNode.requestRemeasure$ui_release();
            }
        }
    }

    private final LayoutNode createNodeAt(int i) {
        LayoutNode layoutNode = new LayoutNode(true);
        LayoutNode access$getRoot = getRoot();
        access$getRoot.ignoreRemeasureRequests = true;
        getRoot().insertAt$ui_release(i, layoutNode);
        access$getRoot.ignoreRemeasureRequests = false;
        return layoutNode;
    }

    static /* synthetic */ void move$default(SubcomposeLayoutState subcomposeLayoutState, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i3 = 1;
        }
        subcomposeLayoutState.move(i, i2, i3);
    }

    private final void ignoreRemeasureRequests(Function0<Unit> function0) {
        LayoutNode access$getRoot = getRoot();
        access$getRoot.ignoreRemeasureRequests = true;
        function0.invoke();
        access$getRoot.ignoreRemeasureRequests = false;
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B.\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\u0011\u0010\u0003\u001a\r\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR'\u0010\u0003\u001a\r\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Landroidx/compose/ui/layout/SubcomposeLayoutState$NodeState;", "", "slotId", "content", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "composition", "Landroidx/compose/runtime/Composition;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composition;)V", "getComposition", "()Landroidx/compose/runtime/Composition;", "setComposition", "(Landroidx/compose/runtime/Composition;)V", "getContent", "()Lkotlin/jvm/functions/Function2;", "setContent", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "forceRecompose", "", "getForceRecompose", "()Z", "setForceRecompose", "(Z)V", "getSlotId", "()Ljava/lang/Object;", "setSlotId", "(Ljava/lang/Object;)V", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SubcomposeLayout.kt */
    private static final class NodeState {
        private Composition composition;
        private Function2<? super Composer, ? super Integer, Unit> content;
        private boolean forceRecompose;
        private Object slotId;

        public NodeState(Object obj, Function2<? super Composer, ? super Integer, Unit> function2, Composition composition2) {
            Intrinsics.checkNotNullParameter(function2, "content");
            this.slotId = obj;
            this.content = function2;
            this.composition = composition2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ NodeState(Object obj, Function2 function2, Composition composition2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(obj, function2, (i & 4) != 0 ? null : composition2);
        }

        public final Object getSlotId() {
            return this.slotId;
        }

        public final void setSlotId(Object obj) {
            this.slotId = obj;
        }

        public final Function2<Composer, Integer, Unit> getContent() {
            return this.content;
        }

        public final void setContent(Function2<? super Composer, ? super Integer, Unit> function2) {
            Intrinsics.checkNotNullParameter(function2, "<set-?>");
            this.content = function2;
        }

        public final Composition getComposition() {
            return this.composition;
        }

        public final void setComposition(Composition composition2) {
            this.composition = composition2;
        }

        public final boolean getForceRecompose() {
            return this.forceRecompose;
        }

        public final void setForceRecompose(boolean z) {
            this.forceRecompose = z;
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00190\u0018¢\u0006\u0002\b\u001aH\u0016¢\u0006\u0002\u0010\u001bR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Landroidx/compose/ui/layout/SubcomposeLayoutState$Scope;", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "(Landroidx/compose/ui/layout/SubcomposeLayoutState;)V", "density", "", "getDensity", "()F", "setDensity", "(F)V", "fontScale", "getFontScale", "setFontScale", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "subcompose", "", "Landroidx/compose/ui/layout/Measurable;", "slotId", "", "content", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SubcomposeLayout.kt */
    private final class Scope implements SubcomposeMeasureScope {
        private float density;
        private float fontScale;
        private LayoutDirection layoutDirection = LayoutDirection.Rtl;
        final /* synthetic */ SubcomposeLayoutState this$0;

        public Scope(SubcomposeLayoutState subcomposeLayoutState) {
            Intrinsics.checkNotNullParameter(subcomposeLayoutState, "this$0");
            this.this$0 = subcomposeLayoutState;
        }

        public MeasureResult layout(int i, int i2, Map<AlignmentLine, Integer> map, Function1<? super Placeable.PlacementScope, Unit> function1) {
            return SubcomposeMeasureScope.DefaultImpls.layout(this, i, i2, map, function1);
        }

        /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
        public int m3215roundToPxR2X_6o(long j) {
            return SubcomposeMeasureScope.DefaultImpls.m3228roundToPxR2X_6o(this, j);
        }

        /* renamed from: roundToPx-0680j_4  reason: not valid java name */
        public int m3216roundToPx0680j_4(float f) {
            return SubcomposeMeasureScope.DefaultImpls.m3229roundToPx0680j_4(this, f);
        }

        /* renamed from: toDp-GaN1DYA  reason: not valid java name */
        public float m3217toDpGaN1DYA(long j) {
            return SubcomposeMeasureScope.DefaultImpls.m3230toDpGaN1DYA(this, j);
        }

        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public float m3218toDpu2uoSUM(float f) {
            return SubcomposeMeasureScope.DefaultImpls.m3231toDpu2uoSUM((SubcomposeMeasureScope) this, f);
        }

        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public float m3219toDpu2uoSUM(int i) {
            return SubcomposeMeasureScope.DefaultImpls.m3232toDpu2uoSUM((SubcomposeMeasureScope) this, i);
        }

        /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
        public long m3220toDpSizekrfVVM(long j) {
            return SubcomposeMeasureScope.DefaultImpls.m3233toDpSizekrfVVM(this, j);
        }

        /* renamed from: toPx--R2X_6o  reason: not valid java name */
        public float m3221toPxR2X_6o(long j) {
            return SubcomposeMeasureScope.DefaultImpls.m3234toPxR2X_6o(this, j);
        }

        /* renamed from: toPx-0680j_4  reason: not valid java name */
        public float m3222toPx0680j_4(float f) {
            return SubcomposeMeasureScope.DefaultImpls.m3235toPx0680j_4(this, f);
        }

        public Rect toRect(DpRect dpRect) {
            return SubcomposeMeasureScope.DefaultImpls.toRect(this, dpRect);
        }

        /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
        public long m3223toSizeXkaWNTQ(long j) {
            return SubcomposeMeasureScope.DefaultImpls.m3236toSizeXkaWNTQ(this, j);
        }

        /* renamed from: toSp-0xMU5do  reason: not valid java name */
        public long m3224toSp0xMU5do(float f) {
            return SubcomposeMeasureScope.DefaultImpls.m3237toSp0xMU5do(this, f);
        }

        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public long m3225toSpkPz2Gy4(float f) {
            return SubcomposeMeasureScope.DefaultImpls.m3238toSpkPz2Gy4((SubcomposeMeasureScope) this, f);
        }

        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public long m3226toSpkPz2Gy4(int i) {
            return SubcomposeMeasureScope.DefaultImpls.m3239toSpkPz2Gy4((SubcomposeMeasureScope) this, i);
        }

        public LayoutDirection getLayoutDirection() {
            return this.layoutDirection;
        }

        public void setLayoutDirection(LayoutDirection layoutDirection2) {
            Intrinsics.checkNotNullParameter(layoutDirection2, "<set-?>");
            this.layoutDirection = layoutDirection2;
        }

        public float getDensity() {
            return this.density;
        }

        public void setDensity(float f) {
            this.density = f;
        }

        public float getFontScale() {
            return this.fontScale;
        }

        public void setFontScale(float f) {
            this.fontScale = f;
        }

        public List<Measurable> subcompose(Object obj, Function2<? super Composer, ? super Integer, Unit> function2) {
            Intrinsics.checkNotNullParameter(function2, "content");
            return this.this$0.subcompose$ui_release(obj, function2);
        }
    }

    /* access modifiers changed from: private */
    public final void move(int i, int i2, int i3) {
        LayoutNode access$getRoot = getRoot();
        access$getRoot.ignoreRemeasureRequests = true;
        getRoot().move$ui_release(i, i2, i3);
        access$getRoot.ignoreRemeasureRequests = false;
    }
}
