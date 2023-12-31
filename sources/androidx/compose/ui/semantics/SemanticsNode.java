package androidx.compose.ui.semantics;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LayoutInfo;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.node.RootForTest;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010D\u001a\u00020E2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00000GH\u0002J6\u0010H\u001a\u00020\u00002\b\u0010I\u001a\u0004\u0018\u00010J2\u0017\u0010K\u001a\u0013\u0012\u0004\u0012\u00020M\u0012\u0004\u0012\u00020E0L¢\u0006\u0002\bNH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\bOJ(\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00000\u000e2\u000e\b\u0002\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00000G2\b\b\u0002\u0010R\u001a\u00020\u0005H\u0002J\r\u0010S\u001a\u00020\u0003H\u0000¢\u0006\u0002\bTJ\u000e\u0010U\u001a\u00020\u00172\u0006\u0010V\u001a\u00020WJ&\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00000\u000e2\u0006\u0010R\u001a\u00020\u00052\u0006\u0010X\u001a\u00020\u00052\u0006\u0010Y\u001a\u00020\u0005H\u0002J\u0010\u0010Z\u001a\u00020E2\u0006\u0010[\u001a\u00020\u0012H\u0002J'\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00000\u000e2\b\b\u0002\u0010R\u001a\u00020\u00052\b\b\u0002\u0010Y\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\\R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00000\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0000X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\u00058BX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001cR\u0011\u0010 \u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b \u0010\u001cR\u0011\u0010!\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020&X\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001cR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0013\u0010,\u001a\u0004\u0018\u00010\u00008F¢\u0006\u0006\u001a\u0004\b-\u0010.R\u001a\u0010/\u001a\u0002008Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b1\u00102R\u001a\u00103\u001a\u0002008Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b4\u00102R\u001a\u00105\u001a\b\u0012\u0004\u0012\u00020\u00000\u000e8@X\u0004¢\u0006\u0006\u001a\u0004\b6\u0010\u0010R\u001a\u00107\u001a\b\u0012\u0004\u0012\u00020\u00000\u000e8@X\u0004¢\u0006\u0006\u001a\u0004\b8\u0010\u0010R\u0013\u00109\u001a\u0004\u0018\u00010:8F¢\u0006\u0006\u001a\u0004\b;\u0010<R\u001a\u0010=\u001a\u00020>8Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b?\u00102R\u0011\u0010@\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\bA\u0010\nR\u0014\u0010B\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\u0014\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006]"}, d2 = {"Landroidx/compose/ui/semantics/SemanticsNode;", "", "outerSemanticsNodeWrapper", "Landroidx/compose/ui/semantics/SemanticsWrapper;", "mergingEnabled", "", "(Landroidx/compose/ui/semantics/SemanticsWrapper;Z)V", "boundsInRoot", "Landroidx/compose/ui/geometry/Rect;", "getBoundsInRoot", "()Landroidx/compose/ui/geometry/Rect;", "boundsInWindow", "getBoundsInWindow", "children", "", "getChildren", "()Ljava/util/List;", "config", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "getConfig", "()Landroidx/compose/ui/semantics/SemanticsConfiguration;", "fakeNodeParent", "id", "", "getId", "()I", "isFake", "isFake$ui_release", "()Z", "setFake$ui_release", "(Z)V", "isMergingSemanticsOfDescendants", "isRoot", "layoutInfo", "Landroidx/compose/ui/layout/LayoutInfo;", "getLayoutInfo", "()Landroidx/compose/ui/layout/LayoutInfo;", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "getLayoutNode$ui_release", "()Landroidx/compose/ui/node/LayoutNode;", "getMergingEnabled", "getOuterSemanticsNodeWrapper$ui_release", "()Landroidx/compose/ui/semantics/SemanticsWrapper;", "parent", "getParent", "()Landroidx/compose/ui/semantics/SemanticsNode;", "positionInRoot", "Landroidx/compose/ui/geometry/Offset;", "getPositionInRoot-F1C5BW0", "()J", "positionInWindow", "getPositionInWindow-F1C5BW0", "replacedChildren", "getReplacedChildren$ui_release", "replacedChildrenSortedByBounds", "getReplacedChildrenSortedByBounds$ui_release", "root", "Landroidx/compose/ui/node/RootForTest;", "getRoot", "()Landroidx/compose/ui/node/RootForTest;", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "touchBoundsInRoot", "getTouchBoundsInRoot", "unmergedConfig", "getUnmergedConfig$ui_release", "emitFakeNodes", "", "unmergedChildren", "", "fakeSemanticsNode", "role", "Landroidx/compose/ui/semantics/Role;", "properties", "Lkotlin/Function1;", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "Lkotlin/ExtensionFunctionType;", "fakeSemanticsNode-ypyhhiA", "findOneLayerOfMergingSemanticsNodes", "list", "sortByBounds", "findWrapperToGetBounds", "findWrapperToGetBounds$ui_release", "getAlignmentLinePosition", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "includeReplacedSemantics", "includeFakeNodes", "mergeConfig", "mergedConfig", "unmergedChildren$ui_release", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SemanticsNode.kt */
public final class SemanticsNode {
    public static final int $stable = 8;
    private SemanticsNode fakeNodeParent;
    private final int id;
    private boolean isFake;
    private final LayoutNode layoutNode;
    private final boolean mergingEnabled;
    private final SemanticsWrapper outerSemanticsNodeWrapper;
    private final SemanticsConfiguration unmergedConfig;

    public SemanticsNode(SemanticsWrapper semanticsWrapper, boolean z) {
        Intrinsics.checkNotNullParameter(semanticsWrapper, "outerSemanticsNodeWrapper");
        this.outerSemanticsNodeWrapper = semanticsWrapper;
        this.mergingEnabled = z;
        this.unmergedConfig = semanticsWrapper.collapsedSemanticsConfiguration();
        this.id = ((SemanticsModifier) semanticsWrapper.getModifier()).getId();
        this.layoutNode = semanticsWrapper.getLayoutNode$ui_release();
    }

    public final SemanticsWrapper getOuterSemanticsNodeWrapper$ui_release() {
        return this.outerSemanticsNodeWrapper;
    }

    public final boolean getMergingEnabled() {
        return this.mergingEnabled;
    }

    public final boolean isFake$ui_release() {
        return this.isFake;
    }

    public final void setFake$ui_release(boolean z) {
        this.isFake = z;
    }

    public final SemanticsConfiguration getUnmergedConfig$ui_release() {
        return this.unmergedConfig;
    }

    public final int getId() {
        return this.id;
    }

    public final LayoutInfo getLayoutInfo() {
        return this.layoutNode;
    }

    public final RootForTest getRoot() {
        Owner owner$ui_release = this.layoutNode.getOwner$ui_release();
        if (owner$ui_release == null) {
            return null;
        }
        return owner$ui_release.getRootForTest();
    }

    public final LayoutNode getLayoutNode$ui_release() {
        return this.layoutNode;
    }

    public final Rect getTouchBoundsInRoot() {
        return findWrapperToGetBounds$ui_release().touchBoundsInRoot();
    }

    /* renamed from: getSize-YbymL2g  reason: not valid java name */
    public final long m3486getSizeYbymL2g() {
        return findWrapperToGetBounds$ui_release().m3344getSizeYbymL2g();
    }

    public final Rect getBoundsInRoot() {
        if (!this.layoutNode.isAttached()) {
            return Rect.Companion.getZero();
        }
        return LayoutCoordinatesKt.boundsInRoot(findWrapperToGetBounds$ui_release());
    }

    /* renamed from: getPositionInRoot-F1C5BW0  reason: not valid java name */
    public final long m3484getPositionInRootF1C5BW0() {
        if (!this.layoutNode.isAttached()) {
            return Offset.Companion.m1369getZeroF1C5BW0();
        }
        return LayoutCoordinatesKt.positionInRoot(findWrapperToGetBounds$ui_release());
    }

    public final Rect getBoundsInWindow() {
        if (!this.layoutNode.isAttached()) {
            return Rect.Companion.getZero();
        }
        return LayoutCoordinatesKt.boundsInWindow(findWrapperToGetBounds$ui_release());
    }

    /* renamed from: getPositionInWindow-F1C5BW0  reason: not valid java name */
    public final long m3485getPositionInWindowF1C5BW0() {
        if (!this.layoutNode.isAttached()) {
            return Offset.Companion.m1369getZeroF1C5BW0();
        }
        return LayoutCoordinatesKt.positionInWindow(findWrapperToGetBounds$ui_release());
    }

    public final int getAlignmentLinePosition(AlignmentLine alignmentLine) {
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        return findWrapperToGetBounds$ui_release().get(alignmentLine);
    }

    public final SemanticsConfiguration getConfig() {
        if (!isMergingSemanticsOfDescendants()) {
            return this.unmergedConfig;
        }
        SemanticsConfiguration copy = this.unmergedConfig.copy();
        mergeConfig(copy);
        return copy;
    }

    private final void mergeConfig(SemanticsConfiguration semanticsConfiguration) {
        if (!this.unmergedConfig.isClearingSemantics()) {
            int i = 0;
            List unmergedChildren$ui_release$default = unmergedChildren$ui_release$default(this, false, false, 3, (Object) null);
            int size = unmergedChildren$ui_release$default.size();
            while (i < size) {
                int i2 = i + 1;
                SemanticsNode semanticsNode = (SemanticsNode) unmergedChildren$ui_release$default.get(i);
                if (!semanticsNode.isMergingSemanticsOfDescendants()) {
                    semanticsConfiguration.mergeChild$ui_release(semanticsNode.getUnmergedConfig$ui_release());
                    semanticsNode.mergeConfig(semanticsConfiguration);
                }
                i = i2;
            }
        }
    }

    private final boolean isMergingSemanticsOfDescendants() {
        return this.mergingEnabled && this.unmergedConfig.isMergingSemanticsOfDescendants();
    }

    public static /* synthetic */ List unmergedChildren$ui_release$default(SemanticsNode semanticsNode, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        return semanticsNode.unmergedChildren$ui_release(z, z2);
    }

    public final List<SemanticsNode> unmergedChildren$ui_release(boolean z, boolean z2) {
        List list;
        if (this.isFake) {
            return CollectionsKt.emptyList();
        }
        List<SemanticsNode> arrayList = new ArrayList<>();
        if (z) {
            list = SemanticsSortKt.findOneLayerOfSemanticsWrappersSortedByBounds$default(this.layoutNode, (List) null, 1, (Object) null);
        } else {
            list = SemanticsNodeKt.findOneLayerOfSemanticsWrappers$default(this.layoutNode, (List) null, 1, (Object) null);
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(new SemanticsNode((SemanticsWrapper) list.get(i), getMergingEnabled()));
        }
        if (z2) {
            emitFakeNodes(arrayList);
        }
        return arrayList;
    }

    public final List<SemanticsNode> getChildren() {
        return getChildren(false, !this.mergingEnabled, false);
    }

    public final List<SemanticsNode> getReplacedChildren$ui_release() {
        return getChildren(false, false, true);
    }

    public final List<SemanticsNode> getReplacedChildrenSortedByBounds$ui_release() {
        return getChildren(true, false, true);
    }

    private final List<SemanticsNode> getChildren(boolean z, boolean z2, boolean z3) {
        if (!z2 && this.unmergedConfig.isClearingSemantics()) {
            return CollectionsKt.emptyList();
        }
        if (isMergingSemanticsOfDescendants()) {
            return findOneLayerOfMergingSemanticsNodes$default(this, (List) null, z, 1, (Object) null);
        }
        return unmergedChildren$ui_release(z, z3);
    }

    public final boolean isRoot() {
        return getParent() == null;
    }

    public final SemanticsNode getParent() {
        SemanticsWrapper semanticsWrapper;
        SemanticsNode semanticsNode = this.fakeNodeParent;
        if (semanticsNode != null) {
            return semanticsNode;
        }
        LayoutNode access$findClosestParentNode = this.mergingEnabled ? SemanticsNodeKt.findClosestParentNode(this.layoutNode, SemanticsNode$parent$1.INSTANCE) : null;
        if (access$findClosestParentNode == null) {
            access$findClosestParentNode = SemanticsNodeKt.findClosestParentNode(this.layoutNode, SemanticsNode$parent$2.INSTANCE);
        }
        if (access$findClosestParentNode == null) {
            semanticsWrapper = null;
        } else {
            semanticsWrapper = SemanticsNodeKt.getOuterSemantics(access$findClosestParentNode);
        }
        if (semanticsWrapper == null) {
            return null;
        }
        return new SemanticsNode(semanticsWrapper, this.mergingEnabled);
    }

    static /* synthetic */ List findOneLayerOfMergingSemanticsNodes$default(SemanticsNode semanticsNode, List list, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            list = new ArrayList();
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return semanticsNode.findOneLayerOfMergingSemanticsNodes(list, z);
    }

    private final List<SemanticsNode> findOneLayerOfMergingSemanticsNodes(List<SemanticsNode> list, boolean z) {
        List unmergedChildren$ui_release$default = unmergedChildren$ui_release$default(this, z, false, 2, (Object) null);
        int size = unmergedChildren$ui_release$default.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            SemanticsNode semanticsNode = (SemanticsNode) unmergedChildren$ui_release$default.get(i);
            if (semanticsNode.isMergingSemanticsOfDescendants()) {
                list.add(semanticsNode);
            } else if (!semanticsNode.getUnmergedConfig$ui_release().isClearingSemantics()) {
                findOneLayerOfMergingSemanticsNodes$default(semanticsNode, list, false, 2, (Object) null);
            }
            i = i2;
        }
        return list;
    }

    public final SemanticsWrapper findWrapperToGetBounds$ui_release() {
        if (!this.unmergedConfig.isMergingSemanticsOfDescendants()) {
            return this.outerSemanticsNodeWrapper;
        }
        SemanticsWrapper outerMergingSemantics = SemanticsNodeKt.getOuterMergingSemantics(this.layoutNode);
        if (outerMergingSemantics == null) {
            return this.outerSemanticsNodeWrapper;
        }
        return outerMergingSemantics;
    }

    private final void emitFakeNodes(List<SemanticsNode> list) {
        Role access$getRole = SemanticsNodeKt.getRole(this);
        if (access$getRole != null && this.unmergedConfig.isMergingSemanticsOfDescendants() && (!list.isEmpty())) {
            list.add(m3483fakeSemanticsNodeypyhhiA(access$getRole, new SemanticsNode$emitFakeNodes$fakeNode$1(access$getRole)));
        }
        if (this.unmergedConfig.contains(SemanticsProperties.INSTANCE.getContentDescription()) && (!list.isEmpty()) && this.unmergedConfig.isMergingSemanticsOfDescendants()) {
            List list2 = (List) SemanticsConfigurationKt.getOrNull(this.unmergedConfig, SemanticsProperties.INSTANCE.getContentDescription());
            String str = list2 == null ? null : (String) CollectionsKt.firstOrNull(list2);
            if (str != null) {
                list.add(0, m3483fakeSemanticsNodeypyhhiA((Role) null, new SemanticsNode$emitFakeNodes$fakeNode$2(str)));
            }
        }
    }

    /* renamed from: fakeSemanticsNode-ypyhhiA  reason: not valid java name */
    private final SemanticsNode m3483fakeSemanticsNodeypyhhiA(Role role, Function1<? super SemanticsPropertyReceiver, Unit> function1) {
        SemanticsNode semanticsNode = new SemanticsNode(new SemanticsWrapper(new LayoutNode(true).getInnerLayoutNodeWrapper$ui_release(), new SemanticsModifierCore(role != null ? SemanticsNodeKt.roleFakeNodeId(this) : SemanticsNodeKt.contentDescriptionFakeNodeId(this), false, false, function1)), false);
        semanticsNode.isFake = true;
        semanticsNode.fakeNodeParent = this;
        return semanticsNode;
    }
}
