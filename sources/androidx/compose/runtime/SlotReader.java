package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u00109\u001a\u00020:2\b\b\u0002\u0010;\u001a\u00020\u0006J\u0006\u0010<\u001a\u00020=J\u0006\u0010>\u001a\u00020=J\u0006\u0010?\u001a\u00020=J\u0006\u0010@\u001a\u00020=J\f\u0010A\u001a\b\u0012\u0004\u0012\u00020C0BJ\u0010\u0010D\u001a\u0004\u0018\u00010\u00012\u0006\u0010;\u001a\u00020\u0006J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00012\u0006\u0010;\u001a\u00020\u0006J\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u0006J\u0010\u0010E\u001a\u0004\u0018\u00010\u00012\u0006\u0010;\u001a\u00020\u0006J\u000e\u0010\u0014\u001a\u00020\u00062\u0006\u00109\u001a\u00020:J\u000e\u0010\u0014\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u0006J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u00012\u0006\u0010;\u001a\u00020\u0006J\u000e\u0010\u001a\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u0006J\u000e\u0010F\u001a\u00020$2\u0006\u0010;\u001a\u00020\u0006J\u000e\u0010(\u001a\u00020$2\u0006\u0010;\u001a\u00020\u0006J\b\u0010G\u001a\u0004\u0018\u00010\u0001J\u0010\u0010H\u001a\u0004\u0018\u00010\u00012\u0006\u0010;\u001a\u00020\u0006J\u000e\u0010)\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u0006J\u000e\u0010+\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u0006J\u000e\u0010I\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u0006J\u000e\u0010J\u001a\u00020=2\u0006\u0010;\u001a\u00020\u0006J\u000e\u0010K\u001a\u00020=2\u0006\u0010;\u001a\u00020\u0006J\u0006\u0010L\u001a\u00020\u0006J\u0006\u0010M\u001a\u00020=J\u0006\u0010N\u001a\u00020=J\u0006\u0010O\u001a\u00020=J\u0016\u0010P\u001a\u0004\u0018\u00010\u0001*\u00020!2\u0006\u0010;\u001a\u00020\u0006H\u0002J\u0016\u0010H\u001a\u0004\u0018\u00010\u0001*\u00020!2\u0006\u0010;\u001a\u00020\u0006H\u0002J\u0016\u0010Q\u001a\u0004\u0018\u00010\u0001*\u00020!2\u0006\u0010;\u001a\u00020\u0006H\u0002R\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u000e\u0010\f\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\tR\u0011\u0010\u0014\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\tR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0011R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0011R\u0011\u0010\u001a\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\tR\u0011\u0010\u001c\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\tR\u0011\u0010\u001e\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\tR\u000e\u0010 \u001a\u00020!X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010#\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\b'\u0010&R\u0011\u0010(\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\b(\u0010&R\u0011\u0010)\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b*\u0010\tR\u001e\u0010+\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\tR\u0011\u0010-\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b.\u0010\tR\u0011\u0010/\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b0\u0010\tR\u0011\u00101\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b2\u0010\tR\u0018\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000104X\u0004¢\u0006\u0004\n\u0002\u00105R\u000e\u00106\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00108¨\u0006R"}, d2 = {"Landroidx/compose/runtime/SlotReader;", "", "table", "Landroidx/compose/runtime/SlotTable;", "(Landroidx/compose/runtime/SlotTable;)V", "<set-?>", "", "currentEnd", "getCurrentEnd", "()I", "currentGroup", "getCurrentGroup", "currentSlot", "currentSlotEnd", "emptyCount", "groupAux", "getGroupAux", "()Ljava/lang/Object;", "groupEnd", "getGroupEnd", "groupKey", "getGroupKey", "groupNode", "getGroupNode", "groupObjectKey", "getGroupObjectKey", "groupSize", "getGroupSize", "groupSlotCount", "getGroupSlotCount", "groupSlotIndex", "getGroupSlotIndex", "groups", "", "groupsSize", "inEmpty", "", "getInEmpty", "()Z", "isGroupEnd", "isNode", "nodeCount", "getNodeCount", "parent", "getParent", "parentNodes", "getParentNodes", "size", "getSize", "slot", "getSlot", "slots", "", "[Ljava/lang/Object;", "slotsSize", "getTable$runtime_release", "()Landroidx/compose/runtime/SlotTable;", "anchor", "Landroidx/compose/runtime/Anchor;", "index", "beginEmpty", "", "close", "endEmpty", "endGroup", "extractKeys", "", "Landroidx/compose/runtime/KeyInfo;", "get", "groupGet", "hasObjectKey", "next", "node", "parentOf", "reposition", "restoreParent", "skipGroup", "skipToGroupEnd", "startGroup", "startNode", "aux", "objectKey", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SlotTable.kt */
public final class SlotReader {
    private int currentEnd;
    private int currentGroup;
    private int currentSlot;
    private int currentSlotEnd;
    private int emptyCount;
    private final int[] groups;
    private final int groupsSize;
    private int parent = -1;
    private final Object[] slots;
    private final int slotsSize;
    private final SlotTable table;

    public SlotReader(SlotTable slotTable) {
        Intrinsics.checkNotNullParameter(slotTable, "table");
        this.table = slotTable;
        this.groups = slotTable.getGroups();
        int groupsSize2 = slotTable.getGroupsSize();
        this.groupsSize = groupsSize2;
        this.slots = slotTable.getSlots();
        this.slotsSize = slotTable.getSlotsSize();
        this.currentEnd = groupsSize2;
    }

    public final SlotTable getTable$runtime_release() {
        return this.table;
    }

    public final int getCurrentGroup() {
        return this.currentGroup;
    }

    public final int getCurrentEnd() {
        return this.currentEnd;
    }

    public final int getParent() {
        return this.parent;
    }

    public final int getSize() {
        return this.groupsSize;
    }

    public final int getSlot() {
        return this.currentSlot - SlotTableKt.slotAnchor(this.groups, this.parent);
    }

    public final int parent(int i) {
        return SlotTableKt.parentAnchor(this.groups, i);
    }

    public final boolean isNode() {
        return SlotTableKt.isNode(this.groups, this.currentGroup);
    }

    public final boolean isNode(int i) {
        return SlotTableKt.isNode(this.groups, i);
    }

    public final int getNodeCount() {
        return SlotTableKt.nodeCount(this.groups, this.currentGroup);
    }

    public final int nodeCount(int i) {
        return SlotTableKt.nodeCount(this.groups, i);
    }

    public final Object node(int i) {
        if (SlotTableKt.isNode(this.groups, i)) {
            return node(this.groups, i);
        }
        return null;
    }

    public final boolean isGroupEnd() {
        return getInEmpty() || this.currentGroup == this.currentEnd;
    }

    public final boolean getInEmpty() {
        return this.emptyCount > 0;
    }

    public final int getGroupSize() {
        return SlotTableKt.groupSize(this.groups, this.currentGroup);
    }

    public final int groupSize(int i) {
        return SlotTableKt.groupSize(this.groups, i);
    }

    public final int getGroupEnd() {
        return this.currentEnd;
    }

    public final int groupEnd(int i) {
        return i + SlotTableKt.groupSize(this.groups, i);
    }

    public final int getGroupKey() {
        int i = this.currentGroup;
        if (i < this.currentEnd) {
            return SlotTableKt.key(this.groups, i);
        }
        return 0;
    }

    public final int groupKey(int i) {
        return SlotTableKt.key(this.groups, i);
    }

    public final int getGroupSlotIndex() {
        return this.currentSlot - SlotTableKt.slotAnchor(this.groups, this.parent);
    }

    public final boolean hasObjectKey(int i) {
        return SlotTableKt.hasObjectKey(this.groups, i);
    }

    public final Object getGroupObjectKey() {
        int i = this.currentGroup;
        if (i < this.currentEnd) {
            return objectKey(this.groups, i);
        }
        return null;
    }

    public final Object groupObjectKey(int i) {
        return objectKey(this.groups, i);
    }

    public final Object getGroupAux() {
        int i = this.currentGroup;
        if (i < this.currentEnd) {
            return aux(this.groups, i);
        }
        return 0;
    }

    public final Object groupAux(int i) {
        return aux(this.groups, i);
    }

    public final Object getGroupNode() {
        int i = this.currentGroup;
        if (i < this.currentEnd) {
            return node(this.groups, i);
        }
        return null;
    }

    public final int groupKey(Anchor anchor) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        if (anchor.getValid()) {
            return SlotTableKt.key(this.groups, this.table.anchorIndex(anchor));
        }
        return 0;
    }

    public final int getParentNodes() {
        int i = this.parent;
        if (i >= 0) {
            return SlotTableKt.nodeCount(this.groups, i);
        }
        return 0;
    }

    public final int parentOf(int i) {
        if (i >= 0 && i < this.groupsSize) {
            return SlotTableKt.parentAnchor(this.groups, i);
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("Invalid group index ", Integer.valueOf(i)).toString());
    }

    public final int getGroupSlotCount() {
        int i = this.currentGroup;
        int access$slotAnchor = SlotTableKt.slotAnchor(this.groups, i);
        int i2 = i + 1;
        return (i2 < this.groupsSize ? SlotTableKt.dataAnchor(this.groups, i2) : this.slotsSize) - access$slotAnchor;
    }

    public final Object get(int i) {
        int i2 = this.currentSlot + i;
        return i2 < this.currentSlotEnd ? this.slots[i2] : Composer.Companion.getEmpty();
    }

    public final Object groupGet(int i) {
        int i2 = this.currentGroup;
        int access$slotAnchor = SlotTableKt.slotAnchor(this.groups, i2);
        int i3 = i2 + 1;
        int i4 = access$slotAnchor + i;
        return i4 < (i3 < this.groupsSize ? SlotTableKt.dataAnchor(this.groups, i3) : this.slotsSize) ? this.slots[i4] : Composer.Companion.getEmpty();
    }

    public final Object next() {
        int i;
        if (this.emptyCount > 0 || (i = this.currentSlot) >= this.currentSlotEnd) {
            return Composer.Companion.getEmpty();
        }
        Object[] objArr = this.slots;
        this.currentSlot = i + 1;
        return objArr[i];
    }

    public final void beginEmpty() {
        this.emptyCount++;
    }

    public final void endEmpty() {
        int i = this.emptyCount;
        if (i > 0) {
            this.emptyCount = i - 1;
            return;
        }
        throw new IllegalArgumentException("Unbalanced begin/end empty".toString());
    }

    public final void close() {
        this.table.close$runtime_release(this);
    }

    public final void startGroup() {
        int i;
        if (this.emptyCount <= 0) {
            if (SlotTableKt.parentAnchor(this.groups, this.currentGroup) == this.parent) {
                int i2 = this.currentGroup;
                this.parent = i2;
                this.currentEnd = i2 + SlotTableKt.groupSize(this.groups, i2);
                int i3 = this.currentGroup;
                int i4 = i3 + 1;
                this.currentGroup = i4;
                this.currentSlot = SlotTableKt.slotAnchor(this.groups, i3);
                if (i3 >= this.groupsSize - 1) {
                    i = this.slotsSize;
                } else {
                    i = SlotTableKt.dataAnchor(this.groups, i4);
                }
                this.currentSlotEnd = i;
                return;
            }
            throw new IllegalArgumentException("Invalid slot table detected".toString());
        }
    }

    public final void startNode() {
        if (this.emptyCount > 0) {
            return;
        }
        if (SlotTableKt.isNode(this.groups, this.currentGroup)) {
            startGroup();
            return;
        }
        throw new IllegalArgumentException("Expected a node group".toString());
    }

    public final int skipGroup() {
        int i = 1;
        if (this.emptyCount == 0) {
            if (!SlotTableKt.isNode(this.groups, this.currentGroup)) {
                i = SlotTableKt.nodeCount(this.groups, this.currentGroup);
            }
            int i2 = this.currentGroup;
            this.currentGroup = i2 + SlotTableKt.groupSize(this.groups, i2);
            return i;
        }
        throw new IllegalArgumentException("Cannot skip while in an empty region".toString());
    }

    public final void skipToGroupEnd() {
        if (this.emptyCount == 0) {
            this.currentGroup = this.currentEnd;
            return;
        }
        throw new IllegalArgumentException("Cannot skip the enclosing group while in an empty region".toString());
    }

    public final void reposition(int i) {
        if (this.emptyCount == 0) {
            this.currentGroup = i;
            int access$parentAnchor = i < this.groupsSize ? SlotTableKt.parentAnchor(this.groups, i) : -1;
            this.parent = access$parentAnchor;
            if (access$parentAnchor < 0) {
                this.currentEnd = this.groupsSize;
            } else {
                this.currentEnd = access$parentAnchor + SlotTableKt.groupSize(this.groups, access$parentAnchor);
            }
            this.currentSlot = 0;
            this.currentSlotEnd = 0;
            return;
        }
        throw new IllegalArgumentException("Cannot reposition while in an empty region".toString());
    }

    public final void restoreParent(int i) {
        int access$groupSize = SlotTableKt.groupSize(this.groups, i) + i;
        int i2 = this.currentGroup;
        if (i2 >= i && i2 <= access$groupSize) {
            this.parent = i;
            this.currentEnd = access$groupSize;
            this.currentSlot = 0;
            this.currentSlotEnd = 0;
            return;
        }
        throw new IllegalArgumentException(("Index " + i + " is not a parent of " + i2).toString());
    }

    public final void endGroup() {
        int i;
        if (this.emptyCount == 0) {
            if (this.currentGroup == this.currentEnd) {
                int access$parentAnchor = SlotTableKt.parentAnchor(this.groups, this.parent);
                this.parent = access$parentAnchor;
                if (access$parentAnchor < 0) {
                    i = this.groupsSize;
                } else {
                    i = access$parentAnchor + SlotTableKt.groupSize(this.groups, access$parentAnchor);
                }
                this.currentEnd = i;
                return;
            }
            throw new IllegalArgumentException("endGroup() not called at the end of a group".toString());
        }
    }

    public final List<KeyInfo> extractKeys() {
        List<KeyInfo> arrayList = new ArrayList<>();
        if (this.emptyCount > 0) {
            return arrayList;
        }
        int i = this.currentGroup;
        int i2 = 0;
        while (i < this.currentEnd) {
            arrayList.add(new KeyInfo(SlotTableKt.key(this.groups, i), objectKey(this.groups, i), i, SlotTableKt.isNode(this.groups, i) ? 1 : SlotTableKt.nodeCount(this.groups, i), i2));
            i += SlotTableKt.groupSize(this.groups, i);
            i2++;
        }
        return arrayList;
    }

    public static /* synthetic */ Anchor anchor$default(SlotReader slotReader, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = slotReader.currentGroup;
        }
        return slotReader.anchor(i);
    }

    public final Anchor anchor(int i) {
        ArrayList<Anchor> anchors$runtime_release = this.table.getAnchors$runtime_release();
        int access$search = SlotTableKt.search(anchors$runtime_release, i, this.groupsSize);
        if (access$search < 0) {
            Anchor anchor = new Anchor(i);
            anchors$runtime_release.add(-(access$search + 1), anchor);
            return anchor;
        }
        Anchor anchor2 = anchors$runtime_release.get(access$search);
        Intrinsics.checkNotNullExpressionValue(anchor2, "get(location)");
        return anchor2;
    }

    private final Object node(int[] iArr, int i) {
        if (SlotTableKt.isNode(iArr, i)) {
            return this.slots[SlotTableKt.nodeIndex(iArr, i)];
        }
        return Composer.Companion.getEmpty();
    }

    private final Object aux(int[] iArr, int i) {
        if (SlotTableKt.hasAux(iArr, i)) {
            return this.slots[SlotTableKt.auxIndex(iArr, i)];
        }
        return Composer.Companion.getEmpty();
    }

    private final Object objectKey(int[] iArr, int i) {
        if (SlotTableKt.hasObjectKey(iArr, i)) {
            return this.slots[SlotTableKt.objectKeyIndex(iArr, i)];
        }
        return null;
    }
}
