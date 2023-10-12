package androidx.compose.runtime;

import com.nimbusds.jose.shaded.ow2asm.signature.SignatureVisitor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0017\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b0\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\nJ\u0010\u00102\u001a\u00020\u00072\b\b\u0002\u00103\u001a\u00020\nJ\u000e\u00104\u001a\u00020\n2\u0006\u00102\u001a\u00020\u0007J\u0006\u00105\u001a\u000200J\u0006\u00106\u001a\u000200J \u00107\u001a\u00020\n2\u0006\u00102\u001a\u00020\n2\u0006\u00108\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u00109\u001a\u00020\n2\u0006\u00103\u001a\u00020\nH\u0002J\u0010\u0010:\u001a\u00020\n2\u0006\u00109\u001a\u00020\nH\u0002J(\u0010;\u001a\u00020\n2\u0006\u00103\u001a\u00020\n2\u0006\u0010<\u001a\u00020\n2\u0006\u00108\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0006\u0010=\u001a\u00020\nJ\u0006\u0010>\u001a\u000200J\u000e\u0010?\u001a\u0002002\u0006\u00102\u001a\u00020\u0007J\u000e\u0010?\u001a\u0002002\u0006\u00103\u001a\u00020\nJ \u0010@\u001a\u0002002\u0006\u0010\"\u001a\u00020\n2\u0006\u0010=\u001a\u00020\n2\u0006\u0010A\u001a\u00020\nH\u0002J\u0010\u0010B\u001a\u0004\u0018\u00010\u00012\u0006\u00103\u001a\u00020\nJ\u0010\u0010C\u001a\u00020\n2\u0006\u00103\u001a\u00020\nH\u0002J\u000e\u0010D\u001a\u00020\n2\u0006\u00103\u001a\u00020\nJ\u0010\u0010E\u001a\u0004\u0018\u00010\u00012\u0006\u00103\u001a\u00020\nJ\u000e\u0010F\u001a\u00020\n2\u0006\u00103\u001a\u00020\nJ\u000e\u0010G\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010HJ\u0006\u0010I\u001a\u00020JJ\u0010\u0010K\u001a\u0002002\b\u0010L\u001a\u0004\u0018\u00010\u0001J\u0010\u0010M\u001a\u0002002\u0006\u0010$\u001a\u00020\nH\u0002J\u0018\u0010N\u001a\u0002002\u0006\u0010$\u001a\u00020\n2\u0006\u0010O\u001a\u00020\nH\u0002J\u000e\u0010P\u001a\b\u0012\u0004\u0012\u00020\n0QH\u0002J \u0010R\u001a\u0002002\u0006\u0010S\u001a\u00020\n2\u0006\u0010T\u001a\u00020\n2\u0006\u0010$\u001a\u00020\nH\u0002J\u001c\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00070Q2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00103\u001a\u00020\nJ\u000e\u0010V\u001a\u0002002\u0006\u0010W\u001a\u00020\nJ\u0010\u0010X\u001a\u0002002\u0006\u00103\u001a\u00020\nH\u0002J\u0018\u0010Y\u001a\u0002002\u0006\u00103\u001a\u00020\n2\u0006\u0010O\u001a\u00020\nH\u0002J\u0010\u0010Z\u001a\u0004\u0018\u00010\u00012\u0006\u00102\u001a\u00020\u0007J\u0010\u0010Z\u001a\u0004\u0018\u00010\u00012\u0006\u00103\u001a\u00020\nJ\u000e\u0010\"\u001a\u00020\n2\u0006\u00102\u001a\u00020\u0007J\u000e\u0010\"\u001a\u00020\n2\u0006\u00103\u001a\u00020\nJ\u0010\u0010[\u001a\u00020\n2\u0006\u00103\u001a\u00020\nH\u0002J\u0018\u0010\\\u001a\u00020\n2\u0006\u00103\u001a\u00020\n2\u0006\u0010<\u001a\u00020\nH\u0002J\u0018\u0010]\u001a\u00020\u000e2\u0006\u0010<\u001a\u00020\n2\u0006\u0010$\u001a\u00020\nH\u0002J\u0006\u0010^\u001a\u00020\u000eJ\u0018\u0010_\u001a\u00020\u000e2\u0006\u0010`\u001a\u00020\n2\u0006\u0010a\u001a\u00020\nH\u0002J \u0010b\u001a\u0002002\u0006\u0010`\u001a\u00020\n2\u0006\u0010a\u001a\u00020\n2\u0006\u0010O\u001a\u00020\nH\u0002J\b\u0010c\u001a\u00020\nH\u0002J\b\u0010d\u001a\u000200H\u0002J\u000e\u0010e\u001a\u0002002\u0006\u00102\u001a\u00020\u0007J\u0010\u0010f\u001a\u0002002\b\u0010L\u001a\u0004\u0018\u00010\u0001J\u001a\u0010f\u001a\u0004\u0018\u00010\u00012\u0006\u00103\u001a\u00020\n2\b\u0010L\u001a\u0004\u0018\u00010\u0001J\b\u0010g\u001a\u0004\u0018\u00010\u0001J\u0006\u0010h\u001a\u00020\nJ\u0006\u0010i\u001a\u000200J\u0018\u0010j\u001a\u0002002\u0006\u0010k\u001a\u00020\n2\b\u0010l\u001a\u0004\u0018\u00010\u0001J\"\u0010j\u001a\u0002002\u0006\u0010k\u001a\u00020\n2\b\u0010m\u001a\u0004\u0018\u00010\u00012\b\u0010l\u001a\u0004\u0018\u00010\u0001J\u0006\u0010n\u001a\u000200J\u000e\u0010n\u001a\u0002002\u0006\u0010k\u001a\u00020\nJ\u0018\u0010n\u001a\u0002002\u0006\u0010k\u001a\u00020\n2\b\u0010o\u001a\u0004\u0018\u00010\u0001J,\u0010n\u001a\u0002002\u0006\u0010k\u001a\u00020\n2\b\u0010m\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001f\u001a\u00020\u000e2\b\u0010l\u001a\u0004\u0018\u00010\u0001H\u0002J\u0010\u0010p\u001a\u0002002\b\u0010k\u001a\u0004\u0018\u00010\u0001J\u001a\u0010p\u001a\u0002002\b\u0010k\u001a\u0004\u0018\u00010\u00012\b\u0010Z\u001a\u0004\u0018\u00010\u0001J\b\u0010q\u001a\u00020JH\u0016J\u0012\u0010r\u001a\u0004\u0018\u00010\u00012\b\u0010L\u001a\u0004\u0018\u00010\u0001J\u0018\u0010s\u001a\u0002002\u0006\u0010t\u001a\u00020\n2\u0006\u0010u\u001a\u00020\nH\u0002J\u0010\u0010v\u001a\u0002002\b\u0010L\u001a\u0004\u0018\u00010\u0001J\u0018\u0010w\u001a\u0002002\u0006\u00102\u001a\u00020\u00072\b\u0010L\u001a\u0004\u0018\u00010\u0001J\u0010\u0010w\u001a\u0002002\b\u0010L\u001a\u0004\u0018\u00010\u0001J\u001a\u0010x\u001a\u0002002\u0006\u00103\u001a\u00020\n2\b\u0010L\u001a\u0004\u0018\u00010\u0001H\u0002J\u0010\u0010y\u001a\u0002002\b\u0010L\u001a\u0004\u0018\u00010\u0001J\r\u0010z\u001a\u000200H\u0000¢\u0006\u0002\b{J\r\u0010|\u001a\u000200H\u0000¢\u0006\u0002\b}J\u0014\u0010~\u001a\u00020\n*\u00020\u001c2\u0006\u0010\u001a\u00020\nH\u0002J\u0014\u00109\u001a\u00020\n*\u00020\u001c2\u0006\u0010\u001a\u00020\nH\u0002J\u0013\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\n0Q*\u00020\u001cH\u0002J\u001b\u0010\u0001\u001a\u000200*\b0\u0001j\u0003`\u00012\u0006\u00103\u001a\u00020\nH\u0002J\u0015\u0010\u0001\u001a\u00020\n*\u00020\u001c2\u0006\u0010\u001a\u00020\nH\u0002J\u0014\u0010\"\u001a\u00020\n*\u00020\u001c2\u0006\u00103\u001a\u00020\nH\u0002J\u0015\u0010\u0001\u001a\u00020\n*\u00020\u001c2\u0006\u0010\u001a\u00020\nH\u0002J\u001d\u0010\u0001\u001a\u000200*\u00020\u001c2\u0006\u0010\u001a\u00020\n2\u0006\u00109\u001a\u00020\nH\u0002R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\fR\u000e\u0010\u0014\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001e\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0011R\u0011\u0010\u001f\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0011R\u000e\u0010 \u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\"\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\fR\u0014\u0010$\u001a\u00020\n8@X\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\fR\u0018\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010'X\u000e¢\u0006\u0004\n\u0002\u0010(R\u000e\u0010)\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.¨\u0006\u0001"}, d2 = {"Landroidx/compose/runtime/SlotWriter;", "", "table", "Landroidx/compose/runtime/SlotTable;", "(Landroidx/compose/runtime/SlotTable;)V", "anchors", "Ljava/util/ArrayList;", "Landroidx/compose/runtime/Anchor;", "Lkotlin/collections/ArrayList;", "capacity", "", "getCapacity", "()I", "<set-?>", "", "closed", "getClosed", "()Z", "currentGroup", "getCurrentGroup", "currentGroupEnd", "currentSlot", "currentSlotEnd", "endStack", "Landroidx/compose/runtime/IntStack;", "groupGapLen", "groupGapStart", "groups", "", "insertCount", "isGroupEnd", "isNode", "nodeCount", "nodeCountStack", "parent", "getParent", "size", "getSize$runtime_release", "slots", "", "[Ljava/lang/Object;", "slotsGapLen", "slotsGapOwner", "slotsGapStart", "startStack", "getTable$runtime_release", "()Landroidx/compose/runtime/SlotTable;", "advanceBy", "", "amount", "anchor", "index", "anchorIndex", "beginInsert", "close", "dataAnchorToDataIndex", "gapLen", "dataIndex", "dataIndexToDataAddress", "dataIndexToDataAnchor", "gapStart", "endGroup", "endInsert", "ensureStarted", "fixParentAnchorsFor", "firstChild", "groupAux", "groupIndexToAddress", "groupKey", "groupObjectKey", "groupSize", "groupSlots", "", "groupsAsString", "", "insertAux", "value", "insertGroups", "insertSlots", "group", "keys", "", "moveAnchors", "originalLocation", "newLocation", "moveFrom", "moveGroup", "offset", "moveGroupGapTo", "moveSlotGapTo", "node", "parentAnchorToIndex", "parentIndexToAnchor", "removeAnchors", "removeGroup", "removeGroups", "start", "len", "removeSlots", "restoreCurrentGroupEnd", "saveCurrentGroupEnd", "seek", "set", "skip", "skipGroup", "skipToGroupEnd", "startData", "key", "aux", "objectKey", "startGroup", "dataKey", "startNode", "toString", "update", "updateAnchors", "previousGapStart", "newGapStart", "updateAux", "updateNode", "updateNodeOfGroup", "updateParentNode", "verifyDataAnchors", "verifyDataAnchors$runtime_release", "verifyParentAnchors", "verifyParentAnchors$runtime_release", "auxIndex", "address", "dataIndexes", "groupAsString", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "nodeIndex", "slotIndex", "updateDataIndex", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SlotTable.kt */
public final class SlotWriter {
    private ArrayList<Anchor> anchors;
    private boolean closed;
    private int currentGroup;
    private int currentGroupEnd;
    private int currentSlot;
    private int currentSlotEnd;
    private final IntStack endStack = new IntStack();
    private int groupGapLen;
    private int groupGapStart;
    private int[] groups;
    private int insertCount;
    private int nodeCount;
    private final IntStack nodeCountStack = new IntStack();
    private int parent = -1;
    /* access modifiers changed from: private */
    public Object[] slots;
    private int slotsGapLen;
    private int slotsGapOwner;
    private int slotsGapStart;
    private final IntStack startStack = new IntStack();
    private final SlotTable table;

    private final int dataAnchorToDataIndex(int i, int i2, int i3) {
        return i < 0 ? (i3 - i2) + i + 1 : i;
    }

    private final int dataIndexToDataAnchor(int i, int i2, int i3, int i4) {
        return i > i2 ? -(((i4 - i3) - i) + 1) : i;
    }

    public SlotWriter(SlotTable slotTable) {
        Intrinsics.checkNotNullParameter(slotTable, "table");
        this.table = slotTable;
        this.groups = slotTable.getGroups();
        this.slots = slotTable.getSlots();
        this.anchors = slotTable.getAnchors$runtime_release();
        this.groupGapStart = slotTable.getGroupsSize();
        this.groupGapLen = (this.groups.length / 5) - slotTable.getGroupsSize();
        this.currentGroupEnd = slotTable.getGroupsSize();
        this.slotsGapStart = slotTable.getSlotsSize();
        this.slotsGapLen = this.slots.length - slotTable.getSlotsSize();
        this.slotsGapOwner = slotTable.getGroupsSize();
    }

    public final SlotTable getTable$runtime_release() {
        return this.table;
    }

    public final int getCurrentGroup() {
        return this.currentGroup;
    }

    public final boolean isGroupEnd() {
        return this.currentGroup == this.currentGroupEnd;
    }

    public final boolean isNode() {
        int i = this.currentGroup;
        return i < this.currentGroupEnd && SlotTableKt.isNode(this.groups, groupIndexToAddress(i));
    }

    public final int groupKey(int i) {
        return SlotTableKt.key(this.groups, groupIndexToAddress(i));
    }

    public final Object groupObjectKey(int i) {
        int groupIndexToAddress = groupIndexToAddress(i);
        if (SlotTableKt.hasObjectKey(this.groups, groupIndexToAddress)) {
            return this.slots[SlotTableKt.objectKeyIndex(this.groups, groupIndexToAddress)];
        }
        return null;
    }

    public final int groupSize(int i) {
        return SlotTableKt.groupSize(this.groups, groupIndexToAddress(i));
    }

    public final Object groupAux(int i) {
        int groupIndexToAddress = groupIndexToAddress(i);
        return SlotTableKt.hasAux(this.groups, groupIndexToAddress) ? this.slots[auxIndex(this.groups, groupIndexToAddress)] : Composer.Companion.getEmpty();
    }

    public final Object node(int i) {
        int groupIndexToAddress = groupIndexToAddress(i);
        if (SlotTableKt.isNode(this.groups, groupIndexToAddress)) {
            return this.slots[dataIndexToDataAddress(nodeIndex(this.groups, groupIndexToAddress))];
        }
        return null;
    }

    public final Object node(Anchor anchor) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        return node(anchor.toIndexFor(this));
    }

    public final int getParent() {
        return this.parent;
    }

    public final int parent(int i) {
        return parent(this.groups, i);
    }

    public final int parent(Anchor anchor) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        if (anchor.getValid()) {
            return parent(this.groups, anchorIndex(anchor));
        }
        return -1;
    }

    public final boolean getClosed() {
        return this.closed;
    }

    public final void close() {
        this.closed = true;
        moveGroupGapTo(getSize$runtime_release());
        moveSlotGapTo(this.slots.length - this.slotsGapLen, this.groupGapStart);
        this.table.close$runtime_release(this, this.groups, this.groupGapStart, this.slots, this.slotsGapStart, this.anchors);
    }

    public final Object update(Object obj) {
        Object skip = skip();
        set(obj);
        return skip;
    }

    public final void updateAux(Object obj) {
        int groupIndexToAddress = groupIndexToAddress(this.currentGroup);
        if (SlotTableKt.hasAux(this.groups, groupIndexToAddress)) {
            this.slots[dataIndexToDataAddress(auxIndex(this.groups, groupIndexToAddress))] = obj;
        } else {
            ComposerKt.composeRuntimeError("Updating the data of a group that was not created with a data slot".toString());
            throw new KotlinNothingValueException();
        }
    }

    public final void insertAux(Object obj) {
        boolean z = false;
        if (this.insertCount >= 0) {
            int i = this.parent;
            int groupIndexToAddress = groupIndexToAddress(i);
            if (!SlotTableKt.hasAux(this.groups, groupIndexToAddress)) {
                insertSlots(1, i);
                int auxIndex = auxIndex(this.groups, groupIndexToAddress);
                int dataIndexToDataAddress = dataIndexToDataAddress(auxIndex);
                int i2 = this.currentSlot;
                if (i2 > auxIndex) {
                    int i3 = i2 - auxIndex;
                    if (i3 < 3) {
                        z = true;
                    }
                    if (z) {
                        if (i3 > 1) {
                            Object[] objArr = this.slots;
                            objArr[dataIndexToDataAddress + 2] = objArr[dataIndexToDataAddress + 1];
                        }
                        Object[] objArr2 = this.slots;
                        objArr2[dataIndexToDataAddress + 1] = objArr2[dataIndexToDataAddress];
                    } else {
                        throw new IllegalStateException("Moving more than two slot not supported".toString());
                    }
                }
                SlotTableKt.addAux(this.groups, groupIndexToAddress);
                this.slots[dataIndexToDataAddress] = obj;
                this.currentSlot++;
                return;
            }
            ComposerKt.composeRuntimeError("Group already has auxiliary data".toString());
            throw new KotlinNothingValueException();
        }
        ComposerKt.composeRuntimeError("Cannot insert auxiliary data when not inserting".toString());
        throw new KotlinNothingValueException();
    }

    public final void updateNode(Object obj) {
        updateNodeOfGroup(this.currentGroup, obj);
    }

    public final void updateNode(Anchor anchor, Object obj) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        updateNodeOfGroup(anchor.toIndexFor(this), obj);
    }

    public final void updateParentNode(Object obj) {
        updateNodeOfGroup(this.parent, obj);
    }

    public final void set(Object obj) {
        int i = this.currentSlot;
        if (i <= this.currentSlotEnd) {
            this.slots[dataIndexToDataAddress(i - 1)] = obj;
        } else {
            ComposerKt.composeRuntimeError("Writing to an invalid slot".toString());
            throw new KotlinNothingValueException();
        }
    }

    public final Object set(int i, Object obj) {
        int slotIndex = slotIndex(this.groups, groupIndexToAddress(this.currentGroup));
        boolean z = true;
        int dataIndex = dataIndex(this.groups, groupIndexToAddress(this.currentGroup + 1));
        int i2 = slotIndex + i;
        if (i2 < slotIndex || i2 >= dataIndex) {
            z = false;
        }
        if (z) {
            int dataIndexToDataAddress = dataIndexToDataAddress(i2);
            Object[] objArr = this.slots;
            Object obj2 = objArr[dataIndexToDataAddress];
            objArr[dataIndexToDataAddress] = obj;
            return obj2;
        }
        ComposerKt.composeRuntimeError(("Write to an invalid slot index " + i + " for group " + getCurrentGroup()).toString());
        throw new KotlinNothingValueException();
    }

    public final Object skip() {
        if (this.insertCount > 0) {
            insertSlots(1, this.parent);
        }
        Object[] objArr = this.slots;
        int i = this.currentSlot;
        this.currentSlot = i + 1;
        return objArr[dataIndexToDataAddress(i)];
    }

    public final void advanceBy(int i) {
        boolean z = true;
        if (i >= 0) {
            if (this.insertCount <= 0) {
                int i2 = this.currentGroup + i;
                if (i2 < this.parent || i2 > this.currentGroupEnd) {
                    z = false;
                }
                if (z) {
                    this.currentGroup = i2;
                    int dataIndex = dataIndex(this.groups, groupIndexToAddress(i2));
                    this.currentSlot = dataIndex;
                    this.currentSlotEnd = dataIndex;
                    return;
                }
                ComposerKt.composeRuntimeError(("Cannot seek outside the current group (" + getParent() + SignatureVisitor.SUPER + this.currentGroupEnd + ')').toString());
                throw new KotlinNothingValueException();
            }
            throw new IllegalStateException("Cannot call seek() while inserting".toString());
        }
        throw new IllegalArgumentException("Cannot seek backwards".toString());
    }

    public final void seek(Anchor anchor) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        advanceBy(anchor.toIndexFor(this) - this.currentGroup);
    }

    public final void skipToGroupEnd() {
        int i = this.currentGroupEnd;
        this.currentGroup = i;
        this.currentSlot = dataIndex(this.groups, groupIndexToAddress(i));
    }

    public final void beginInsert() {
        int i = this.insertCount;
        this.insertCount = i + 1;
        if (i == 0) {
            saveCurrentGroupEnd();
        }
    }

    public final void endInsert() {
        int i = this.insertCount;
        boolean z = true;
        if (i > 0) {
            int i2 = i - 1;
            this.insertCount = i2;
            if (i2 == 0) {
                if (this.nodeCountStack.getSize() != this.startStack.getSize()) {
                    z = false;
                }
                if (z) {
                    restoreCurrentGroupEnd();
                } else {
                    ComposerKt.composeRuntimeError("startGroup/endGroup mismatch while inserting".toString());
                    throw new KotlinNothingValueException();
                }
            }
        } else {
            throw new IllegalStateException("Unbalanced begin/end insert".toString());
        }
    }

    public final void startGroup() {
        if (this.insertCount == 0) {
            startGroup(0, Composer.Companion.getEmpty(), false, Composer.Companion.getEmpty());
            return;
        }
        throw new IllegalArgumentException("Key must be supplied when inserting".toString());
    }

    public final void startGroup(int i) {
        startGroup(i, Composer.Companion.getEmpty(), false, Composer.Companion.getEmpty());
    }

    public final void startGroup(int i, Object obj) {
        startGroup(i, obj, false, Composer.Companion.getEmpty());
    }

    public final void startNode(Object obj) {
        startGroup(125, obj, true, Composer.Companion.getEmpty());
    }

    public final void startNode(Object obj, Object obj2) {
        startGroup(125, obj, true, obj2);
    }

    public final void startData(int i, Object obj, Object obj2) {
        startGroup(i, obj, false, obj2);
    }

    public final void startData(int i, Object obj) {
        startGroup(i, Composer.Companion.getEmpty(), false, obj);
    }

    private final void startGroup(int i, Object obj, boolean z, Object obj2) {
        int i2;
        Object obj3 = obj;
        Object obj4 = obj2;
        boolean z2 = this.insertCount > 0;
        this.nodeCountStack.push(this.nodeCount);
        if (z2) {
            insertGroups(1);
            int i3 = this.currentGroup;
            int groupIndexToAddress = groupIndexToAddress(i3);
            boolean z3 = obj3 != Composer.Companion.getEmpty();
            boolean z4 = !z && obj4 != Composer.Companion.getEmpty();
            SlotTableKt.initGroup(this.groups, groupIndexToAddress, i, z, z3, z4, this.parent, this.currentSlot);
            this.currentSlotEnd = this.currentSlot;
            int i4 = (z ? 1 : 0) + (z3 ? 1 : 0) + (z4 ? 1 : 0);
            if (i4 > 0) {
                insertSlots(i4, i3);
                Object[] objArr = this.slots;
                int i5 = this.currentSlot;
                if (z) {
                    objArr[i5] = obj4;
                    i5++;
                }
                if (z3) {
                    objArr[i5] = obj3;
                    i5++;
                }
                if (z4) {
                    objArr[i5] = obj4;
                    i5++;
                }
                this.currentSlot = i5;
            }
            this.nodeCount = 0;
            i2 = i3 + 1;
            this.parent = i3;
            this.currentGroup = i2;
        } else {
            this.startStack.push(this.parent);
            saveCurrentGroupEnd();
            int i6 = this.currentGroup;
            int groupIndexToAddress2 = groupIndexToAddress(i6);
            if (!Intrinsics.areEqual(obj4, Composer.Companion.getEmpty())) {
                if (z) {
                    updateNode(obj4);
                } else {
                    updateAux(obj4);
                }
            }
            this.currentSlot = slotIndex(this.groups, groupIndexToAddress2);
            this.currentSlotEnd = dataIndex(this.groups, groupIndexToAddress(this.currentGroup + 1));
            this.nodeCount = SlotTableKt.nodeCount(this.groups, groupIndexToAddress2);
            this.parent = i6;
            this.currentGroup = i6 + 1;
            i2 = i6 + SlotTableKt.groupSize(this.groups, groupIndexToAddress2);
        }
        this.currentGroupEnd = i2;
    }

    public final int endGroup() {
        int i = 1;
        int i2 = 0;
        boolean z = this.insertCount > 0;
        int i3 = this.currentGroup;
        int i4 = this.currentGroupEnd;
        int i5 = this.parent;
        int groupIndexToAddress = groupIndexToAddress(i5);
        int i6 = this.nodeCount;
        int i7 = i3 - i5;
        boolean access$isNode = SlotTableKt.isNode(this.groups, groupIndexToAddress);
        if (z) {
            SlotTableKt.updateGroupSize(this.groups, groupIndexToAddress, i7);
            SlotTableKt.updateNodeCount(this.groups, groupIndexToAddress, i6);
            int pop = this.nodeCountStack.pop();
            if (!access$isNode) {
                i = i6;
            }
            this.nodeCount = pop + i;
            this.parent = parent(this.groups, i5);
        } else {
            if (i3 != i4) {
                i = 0;
            }
            if (i != 0) {
                int access$groupSize = SlotTableKt.groupSize(this.groups, groupIndexToAddress);
                int access$nodeCount = SlotTableKt.nodeCount(this.groups, groupIndexToAddress);
                SlotTableKt.updateGroupSize(this.groups, groupIndexToAddress, i7);
                SlotTableKt.updateNodeCount(this.groups, groupIndexToAddress, i6);
                int pop2 = this.startStack.pop();
                restoreCurrentGroupEnd();
                this.parent = pop2;
                int parent2 = parent(this.groups, i5);
                int pop3 = this.nodeCountStack.pop();
                this.nodeCount = pop3;
                if (parent2 == pop2) {
                    if (!access$isNode) {
                        i2 = i6 - access$nodeCount;
                    }
                    this.nodeCount = pop3 + i2;
                } else {
                    int i8 = i7 - access$groupSize;
                    int i9 = access$isNode ? 0 : i6 - access$nodeCount;
                    if (!(i8 == 0 && i9 == 0)) {
                        while (parent2 != 0 && parent2 != pop2 && (i9 != 0 || i8 != 0)) {
                            int groupIndexToAddress2 = groupIndexToAddress(parent2);
                            if (i8 != 0) {
                                SlotTableKt.updateGroupSize(this.groups, groupIndexToAddress2, SlotTableKt.groupSize(this.groups, groupIndexToAddress2) + i8);
                            }
                            if (i9 != 0) {
                                int[] iArr = this.groups;
                                SlotTableKt.updateNodeCount(iArr, groupIndexToAddress2, SlotTableKt.nodeCount(iArr, groupIndexToAddress2) + i9);
                            }
                            if (SlotTableKt.isNode(this.groups, groupIndexToAddress2)) {
                                i9 = 0;
                            }
                            parent2 = parent(this.groups, parent2);
                        }
                    }
                    this.nodeCount += i9;
                }
            } else {
                throw new IllegalArgumentException("Expected to be at the end of a group".toString());
            }
        }
        return i6;
    }

    public final void ensureStarted(int i) {
        boolean z = true;
        if (this.insertCount <= 0) {
            int i2 = this.parent;
            if (i2 != i) {
                if (i < i2 || i >= this.currentGroupEnd) {
                    z = false;
                }
                if (z) {
                    int i3 = this.currentGroup;
                    int i4 = this.currentSlot;
                    int i5 = this.currentSlotEnd;
                    this.currentGroup = i;
                    startGroup();
                    this.currentGroup = i3;
                    this.currentSlot = i4;
                    this.currentSlotEnd = i5;
                    return;
                }
                throw new IllegalArgumentException(Intrinsics.stringPlus("Started group must be a subgroup of the group at ", Integer.valueOf(i2)).toString());
            }
            return;
        }
        throw new IllegalArgumentException("Cannot call ensureStarted() while inserting".toString());
    }

    public final void ensureStarted(Anchor anchor) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        ensureStarted(anchor.toIndexFor(this));
    }

    public final int skipGroup() {
        int groupIndexToAddress = groupIndexToAddress(this.currentGroup);
        int access$groupSize = this.currentGroup + SlotTableKt.groupSize(this.groups, groupIndexToAddress);
        this.currentGroup = access$groupSize;
        this.currentSlot = dataIndex(this.groups, groupIndexToAddress(access$groupSize));
        if (SlotTableKt.isNode(this.groups, groupIndexToAddress)) {
            return 1;
        }
        return SlotTableKt.nodeCount(this.groups, groupIndexToAddress);
    }

    public final boolean removeGroup() {
        if (this.insertCount == 0) {
            int i = this.currentGroup;
            int i2 = this.currentSlot;
            int skipGroup = skipGroup();
            boolean removeGroups = removeGroups(i, this.currentGroup - i);
            removeSlots(i2, this.currentSlot - i2, i - 1);
            this.currentGroup = i;
            this.currentSlot = i2;
            this.nodeCount -= skipGroup;
            return removeGroups;
        }
        throw new IllegalArgumentException("Cannot remove group while inserting".toString());
    }

    public final Iterator<Object> groupSlots() {
        int dataIndex = dataIndex(this.groups, groupIndexToAddress(this.currentGroup));
        int[] iArr = this.groups;
        int i = this.currentGroup;
        return new SlotWriter$groupSlots$1(dataIndex, dataIndex(iArr, groupIndexToAddress(i + groupSize(i))), this);
    }

    public final void moveGroup(int i) {
        if (this.insertCount == 0) {
            if (!(i >= 0)) {
                throw new IllegalArgumentException("Parameter offset is out of bounds".toString());
            } else if (i != 0) {
                int i2 = this.currentGroup;
                int i3 = this.parent;
                int i4 = this.currentGroupEnd;
                int i5 = i;
                int i6 = i2;
                while (i5 > 0) {
                    i6 += SlotTableKt.groupSize(this.groups, groupIndexToAddress(i6));
                    if (i6 <= i4) {
                        i5--;
                    } else {
                        throw new IllegalArgumentException("Parameter offset is out of bounds".toString());
                    }
                }
                int access$groupSize = SlotTableKt.groupSize(this.groups, groupIndexToAddress(i6));
                int i7 = this.currentSlot;
                int dataIndex = dataIndex(this.groups, groupIndexToAddress(i6));
                int i8 = i6 + access$groupSize;
                int dataIndex2 = dataIndex(this.groups, groupIndexToAddress(i8));
                int i9 = dataIndex2 - dataIndex;
                insertSlots(i9, Math.max(this.currentGroup - 1, 0));
                insertGroups(access$groupSize);
                int[] iArr = this.groups;
                int groupIndexToAddress = groupIndexToAddress(i8) * 5;
                ArraysKt.copyInto(iArr, iArr, groupIndexToAddress(i2) * 5, groupIndexToAddress, (access$groupSize * 5) + groupIndexToAddress);
                if (i9 > 0) {
                    Object[] objArr = this.slots;
                    ArraysKt.copyInto((T[]) objArr, (T[]) objArr, i7, dataIndexToDataAddress(dataIndex + i9), dataIndexToDataAddress(dataIndex2 + i9));
                }
                int i10 = dataIndex + i9;
                int i11 = i10 - i7;
                int i12 = this.slotsGapStart;
                int i13 = this.slotsGapLen;
                int length = this.slots.length;
                int i14 = this.slotsGapOwner;
                int i15 = i2 + access$groupSize;
                int i16 = i2;
                while (i16 < i15) {
                    int i17 = i16 + 1;
                    int groupIndexToAddress2 = groupIndexToAddress(i16);
                    int i18 = i11;
                    updateDataIndex(iArr, groupIndexToAddress2, dataIndexToDataAnchor(dataIndex(iArr, groupIndexToAddress2) - i11, i14 < groupIndexToAddress2 ? 0 : i12, i13, length));
                    i11 = i18;
                    i16 = i17;
                }
                moveAnchors(i8, i2, access$groupSize);
                if (!removeGroups(i8, access$groupSize)) {
                    fixParentAnchorsFor(i3, this.currentGroupEnd, i2);
                    if (i9 > 0) {
                        removeSlots(i10, i9, i8 - 1);
                        return;
                    }
                    return;
                }
                ComposerKt.composeRuntimeError("Unexpectedly removed anchors".toString());
                throw new KotlinNothingValueException();
            }
        } else {
            throw new IllegalArgumentException("Cannot move a group while inserting".toString());
        }
    }

    public final List<Anchor> moveFrom(SlotTable slotTable, int i) {
        List<Anchor> list;
        int i2;
        int i3;
        int i4 = i;
        Intrinsics.checkNotNullParameter(slotTable, "table");
        if (!(this.insertCount > 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (i4 == 0 && this.currentGroup == 0 && this.table.getGroupsSize() == 0) {
            int[] iArr = this.groups;
            Object[] objArr = this.slots;
            ArrayList<Anchor> arrayList = this.anchors;
            int[] groups2 = slotTable.getGroups();
            int groupsSize = slotTable.getGroupsSize();
            Object[] slots2 = slotTable.getSlots();
            int slotsSize = slotTable.getSlotsSize();
            this.groups = groups2;
            this.slots = slots2;
            this.anchors = slotTable.getAnchors$runtime_release();
            this.groupGapStart = groupsSize;
            this.groupGapLen = (groups2.length / 5) - groupsSize;
            this.slotsGapStart = slotsSize;
            this.slotsGapLen = slots2.length - slotsSize;
            this.slotsGapOwner = groupsSize;
            slotTable.setTo$runtime_release(iArr, 0, objArr, 0, arrayList);
            return this.anchors;
        } else {
            SlotWriter openWriter = slotTable.openWriter();
            try {
                int groupSize = openWriter.groupSize(i4);
                int i5 = i4 + groupSize;
                int dataIndex = openWriter.dataIndex(i4);
                int dataIndex2 = openWriter.dataIndex(i5);
                int i6 = dataIndex2 - dataIndex;
                insertGroups(groupSize);
                insertSlots(i6, getCurrentGroup());
                int[] iArr2 = this.groups;
                int currentGroup2 = getCurrentGroup();
                ArraysKt.copyInto(openWriter.groups, iArr2, currentGroup2 * 5, i4 * 5, i5 * 5);
                Object[] objArr2 = this.slots;
                int i7 = this.currentSlot;
                ArraysKt.copyInto((T[]) openWriter.slots, (T[]) objArr2, i7, dataIndex, dataIndex2);
                SlotTableKt.updateParentAnchor(iArr2, currentGroup2, getParent());
                int i8 = currentGroup2 - i4;
                int i9 = groupSize + currentGroup2;
                int dataIndex3 = i7 - dataIndex(iArr2, currentGroup2);
                int i10 = this.slotsGapOwner;
                int i11 = this.slotsGapLen;
                int length = objArr2.length;
                int i12 = currentGroup2;
                while (i12 < i9) {
                    int i13 = i12 + 1;
                    if (i12 != currentGroup2) {
                        SlotTableKt.updateParentAnchor(iArr2, i12, SlotTableKt.parentAnchor(iArr2, i12) + i8);
                    }
                    int dataIndex4 = dataIndex(iArr2, i12) + dataIndex3;
                    if (i10 < i12) {
                        i2 = dataIndex3;
                        i3 = 0;
                    } else {
                        i2 = dataIndex3;
                        i3 = this.slotsGapStart;
                    }
                    SlotTableKt.updateDataAnchor(iArr2, i12, dataIndexToDataAnchor(dataIndex4, i3, i11, length));
                    if (i12 == i10) {
                        i10++;
                    }
                    SlotTable slotTable2 = slotTable;
                    i12 = i13;
                    dataIndex3 = i2;
                }
                this.slotsGapOwner = i10;
                int access$locationOf = SlotTableKt.locationOf(slotTable.getAnchors$runtime_release(), i4, slotTable.getGroupsSize());
                int access$locationOf2 = SlotTableKt.locationOf(slotTable.getAnchors$runtime_release(), i5, slotTable.getGroupsSize());
                if (access$locationOf < access$locationOf2) {
                    ArrayList<Anchor> anchors$runtime_release = slotTable.getAnchors$runtime_release();
                    ArrayList arrayList2 = new ArrayList(access$locationOf2 - access$locationOf);
                    int i14 = access$locationOf;
                    while (i14 < access$locationOf2) {
                        int i15 = i14 + 1;
                        Anchor anchor = anchors$runtime_release.get(i14);
                        Intrinsics.checkNotNullExpressionValue(anchor, "sourceAnchors[anchorIndex]");
                        Anchor anchor2 = anchor;
                        anchor2.setLocation$runtime_release(anchor2.getLocation$runtime_release() + i8);
                        arrayList2.add(anchor2);
                        i14 = i15;
                    }
                    getTable$runtime_release().getAnchors$runtime_release().addAll(SlotTableKt.locationOf(this.anchors, getCurrentGroup(), getSize$runtime_release()), arrayList2);
                    anchors$runtime_release.subList(access$locationOf, access$locationOf2).clear();
                    list = arrayList2;
                } else {
                    list = CollectionsKt.emptyList();
                }
                int parent2 = openWriter.parent(i4);
                if (parent2 >= 0) {
                    openWriter.startGroup();
                    openWriter.advanceBy(parent2 - openWriter.getCurrentGroup());
                    openWriter.startGroup();
                }
                openWriter.advanceBy(i4 - openWriter.getCurrentGroup());
                boolean removeGroup = openWriter.removeGroup();
                if (parent2 >= 0) {
                    openWriter.skipToGroupEnd();
                    openWriter.endGroup();
                    openWriter.skipToGroupEnd();
                    openWriter.endGroup();
                }
                if (!removeGroup) {
                    this.nodeCount += SlotTableKt.isNode(iArr2, currentGroup2) ? 1 : SlotTableKt.nodeCount(iArr2, currentGroup2);
                    this.currentGroup = i9;
                    this.currentSlot = i7 + i6;
                    return list;
                }
                ComposerKt.composeRuntimeError("Unexpectedly removed anchors".toString());
                throw new KotlinNothingValueException();
            } finally {
                openWriter.close();
            }
        }
    }

    public static /* synthetic */ Anchor anchor$default(SlotWriter slotWriter, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = slotWriter.currentGroup;
        }
        return slotWriter.anchor(i);
    }

    public final Anchor anchor(int i) {
        ArrayList<Anchor> arrayList = this.anchors;
        int access$search = SlotTableKt.search(arrayList, i, getSize$runtime_release());
        if (access$search < 0) {
            if (i > this.groupGapStart) {
                i = -(getSize$runtime_release() - i);
            }
            Anchor anchor = new Anchor(i);
            arrayList.add(-(access$search + 1), anchor);
            return anchor;
        }
        Anchor anchor2 = arrayList.get(access$search);
        Intrinsics.checkNotNullExpressionValue(anchor2, "get(location)");
        return anchor2;
    }

    public final int anchorIndex(Anchor anchor) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        int location$runtime_release = anchor.getLocation$runtime_release();
        return location$runtime_release < 0 ? location$runtime_release + getSize$runtime_release() : location$runtime_release;
    }

    public String toString() {
        return "SlotWriter(current = " + this.currentGroup + " end=" + this.currentGroupEnd + " size = " + getSize$runtime_release() + " gap=" + this.groupGapStart + SignatureVisitor.SUPER + (this.groupGapStart + this.groupGapLen) + ')';
    }

    private final void saveCurrentGroupEnd() {
        this.endStack.push((getCapacity() - this.groupGapLen) - this.currentGroupEnd);
    }

    private final int restoreCurrentGroupEnd() {
        int capacity = (getCapacity() - this.groupGapLen) - this.endStack.pop();
        this.currentGroupEnd = capacity;
        return capacity;
    }

    private final void fixParentAnchorsFor(int i, int i2, int i3) {
        int parentIndexToAnchor = parentIndexToAnchor(i, this.groupGapStart);
        while (i3 < i2) {
            SlotTableKt.updateParentAnchor(this.groups, groupIndexToAddress(i3), parentIndexToAnchor);
            int access$groupSize = SlotTableKt.groupSize(this.groups, groupIndexToAddress(i3)) + i3;
            fixParentAnchorsFor(i3, access$groupSize, i3 + 1);
            i3 = access$groupSize;
        }
    }

    private final void moveGroupGapTo(int i) {
        int i2;
        int i3 = this.groupGapLen;
        int i4 = this.groupGapStart;
        if (i4 != i) {
            boolean z = true;
            if (!this.anchors.isEmpty()) {
                updateAnchors(i4, i);
            }
            if (i3 > 0) {
                int[] iArr = this.groups;
                int i5 = i * 5;
                int i6 = i3 * 5;
                int i7 = i4 * 5;
                if (i < i4) {
                    ArraysKt.copyInto(iArr, iArr, i6 + i5, i5, i7);
                } else {
                    ArraysKt.copyInto(iArr, iArr, i7, i7 + i6, i5 + i6);
                }
            }
            if (i < i4) {
                i4 = i + i3;
            }
            int capacity = getCapacity();
            if (i2 >= capacity) {
                z = false;
            }
            ComposerKt.runtimeCheck(z);
            while (i2 < capacity) {
                int access$parentAnchor = SlotTableKt.parentAnchor(this.groups, i2);
                int parentIndexToAnchor = parentIndexToAnchor(parentAnchorToIndex(access$parentAnchor), i);
                if (parentIndexToAnchor != access$parentAnchor) {
                    SlotTableKt.updateParentAnchor(this.groups, i2, parentIndexToAnchor);
                }
                i2++;
                if (i2 == i) {
                    i2 += i3;
                }
            }
        }
        this.groupGapStart = i;
    }

    private final void moveSlotGapTo(int i, int i2) {
        int i3 = this.slotsGapLen;
        int i4 = this.slotsGapStart;
        int i5 = this.slotsGapOwner;
        if (i4 != i) {
            Object[] objArr = this.slots;
            if (i < i4) {
                ArraysKt.copyInto((T[]) objArr, (T[]) objArr, i + i3, i, i4);
            } else {
                ArraysKt.copyInto((T[]) objArr, (T[]) objArr, i4, i4 + i3, i + i3);
            }
            ArraysKt.fill((T[]) objArr, null, i, i + i3);
        }
        int min = Math.min(i2 + 1, getSize$runtime_release());
        if (i5 != min) {
            int length = this.slots.length - i3;
            if (min < i5) {
                int groupIndexToAddress = groupIndexToAddress(min);
                int groupIndexToAddress2 = groupIndexToAddress(i5);
                int i6 = this.groupGapStart;
                while (groupIndexToAddress < groupIndexToAddress2) {
                    int access$dataAnchor = SlotTableKt.dataAnchor(this.groups, groupIndexToAddress);
                    if (access$dataAnchor >= 0) {
                        SlotTableKt.updateDataAnchor(this.groups, groupIndexToAddress, -((length - access$dataAnchor) + 1));
                        groupIndexToAddress++;
                        if (groupIndexToAddress == i6) {
                            groupIndexToAddress += this.groupGapLen;
                        }
                    } else {
                        ComposerKt.composeRuntimeError("Unexpected anchor value, expected a positive anchor".toString());
                        throw new KotlinNothingValueException();
                    }
                }
            } else {
                int groupIndexToAddress3 = groupIndexToAddress(i5);
                int groupIndexToAddress4 = groupIndexToAddress(min);
                while (groupIndexToAddress3 < groupIndexToAddress4) {
                    int access$dataAnchor2 = SlotTableKt.dataAnchor(this.groups, groupIndexToAddress3);
                    if (access$dataAnchor2 < 0) {
                        SlotTableKt.updateDataAnchor(this.groups, groupIndexToAddress3, access$dataAnchor2 + length + 1);
                        groupIndexToAddress3++;
                        if (groupIndexToAddress3 == this.groupGapStart) {
                            groupIndexToAddress3 += this.groupGapLen;
                        }
                    } else {
                        ComposerKt.composeRuntimeError("Unexpected anchor value, expected a negative anchor".toString());
                        throw new KotlinNothingValueException();
                    }
                }
            }
            this.slotsGapOwner = min;
        }
        this.slotsGapStart = i;
    }

    private final void insertGroups(int i) {
        if (i > 0) {
            int i2 = this.currentGroup;
            moveGroupGapTo(i2);
            int i3 = this.groupGapStart;
            int i4 = this.groupGapLen;
            int[] iArr = this.groups;
            int length = iArr.length / 5;
            int i5 = length - i4;
            int i6 = 0;
            if (i4 < i) {
                int max = Math.max(Math.max(length * 2, i5 + i), 32);
                int[] iArr2 = new int[(max * 5)];
                int i7 = max - i5;
                ArraysKt.copyInto(iArr, iArr2, 0, 0, i3 * 5);
                ArraysKt.copyInto(iArr, iArr2, (i3 + i7) * 5, (i4 + i3) * 5, length * 5);
                this.groups = iArr2;
                i4 = i7;
            }
            int i8 = this.currentGroupEnd;
            if (i8 >= i3) {
                this.currentGroupEnd = i8 + i;
            }
            int i9 = i3 + i;
            this.groupGapStart = i9;
            this.groupGapLen = i4 - i;
            int dataIndex = i5 > 0 ? dataIndex(i2 + i) : 0;
            if (this.slotsGapOwner >= i3) {
                i6 = this.slotsGapStart;
            }
            int dataIndexToDataAnchor = dataIndexToDataAnchor(dataIndex, i6, this.slotsGapLen, this.slots.length);
            for (int i10 = i3; i10 < i9; i10++) {
                SlotTableKt.updateDataAnchor(this.groups, i10, dataIndexToDataAnchor);
            }
            int i11 = this.slotsGapOwner;
            if (i11 >= i3) {
                this.slotsGapOwner = i11 + i;
            }
        }
    }

    private final void insertSlots(int i, int i2) {
        if (i > 0) {
            moveSlotGapTo(this.currentSlot, i2);
            int i3 = this.slotsGapStart;
            int i4 = this.slotsGapLen;
            if (i4 < i) {
                Object[] objArr = this.slots;
                int length = objArr.length;
                int i5 = length - i4;
                int max = Math.max(Math.max(length * 2, i5 + i), 32);
                Object[] objArr2 = new Object[max];
                for (int i6 = 0; i6 < max; i6++) {
                    objArr2[i6] = null;
                }
                int i7 = max - i5;
                ArraysKt.copyInto((T[]) objArr, (T[]) objArr2, 0, 0, i3);
                ArraysKt.copyInto((T[]) objArr, (T[]) objArr2, i3 + i7, i4 + i3, length);
                this.slots = objArr2;
                i4 = i7;
            }
            int i8 = this.currentSlotEnd;
            if (i8 >= i3) {
                this.currentSlotEnd = i8 + i;
            }
            this.slotsGapStart = i3 + i;
            this.slotsGapLen = i4 - i;
        }
    }

    private final boolean removeGroups(int i, int i2) {
        boolean z = false;
        if (i2 > 0) {
            ArrayList<Anchor> arrayList = this.anchors;
            moveGroupGapTo(i);
            if (!arrayList.isEmpty()) {
                z = removeAnchors(i, i2);
            }
            this.groupGapStart = i;
            this.groupGapLen += i2;
            int i3 = this.slotsGapOwner;
            if (i3 > i) {
                this.slotsGapOwner = i3 - i2;
            }
            int i4 = this.currentGroupEnd;
            if (i4 >= i) {
                this.currentGroupEnd = i4 - i2;
            }
        }
        return z;
    }

    private final void removeSlots(int i, int i2, int i3) {
        if (i2 > 0) {
            int i4 = this.slotsGapLen;
            int i5 = i + i2;
            moveSlotGapTo(i5, i3);
            this.slotsGapStart = i;
            this.slotsGapLen = i4 + i2;
            ArraysKt.fill((T[]) this.slots, null, i, i5);
            int i6 = this.currentSlotEnd;
            if (i6 >= i) {
                this.currentSlotEnd = i6 - i2;
            }
        }
    }

    private final void updateNodeOfGroup(int i, Object obj) {
        int groupIndexToAddress = groupIndexToAddress(i);
        int[] iArr = this.groups;
        if (groupIndexToAddress < iArr.length && SlotTableKt.isNode(iArr, groupIndexToAddress)) {
            this.slots[dataIndexToDataAddress(nodeIndex(this.groups, groupIndexToAddress))] = obj;
            return;
        }
        ComposerKt.composeRuntimeError(("Updating the node of a group at " + i + " that was not created with as a node group").toString());
        throw new KotlinNothingValueException();
    }

    private final void updateAnchors(int i, int i2) {
        int i3;
        int capacity = getCapacity() - this.groupGapLen;
        if (i < i2) {
            int access$locationOf = SlotTableKt.locationOf(this.anchors, i, capacity);
            while (access$locationOf < this.anchors.size()) {
                Anchor anchor = this.anchors.get(access$locationOf);
                Intrinsics.checkNotNullExpressionValue(anchor, "anchors[index]");
                Anchor anchor2 = anchor;
                int location$runtime_release = anchor2.getLocation$runtime_release();
                if (location$runtime_release < 0 && (i3 = location$runtime_release + capacity) < i2) {
                    anchor2.setLocation$runtime_release(i3);
                    access$locationOf++;
                } else {
                    return;
                }
            }
            return;
        }
        int access$locationOf2 = SlotTableKt.locationOf(this.anchors, i2, capacity);
        while (access$locationOf2 < this.anchors.size()) {
            Anchor anchor3 = this.anchors.get(access$locationOf2);
            Intrinsics.checkNotNullExpressionValue(anchor3, "anchors[index]");
            Anchor anchor4 = anchor3;
            int location$runtime_release2 = anchor4.getLocation$runtime_release();
            if (location$runtime_release2 >= 0) {
                anchor4.setLocation$runtime_release(-(capacity - location$runtime_release2));
                access$locationOf2++;
            } else {
                return;
            }
        }
    }

    private final boolean removeAnchors(int i, int i2) {
        int i3 = i2 + i;
        int access$locationOf = SlotTableKt.locationOf(this.anchors, i3, getCapacity() - this.groupGapLen);
        if (access$locationOf >= this.anchors.size()) {
            access$locationOf--;
        }
        int i4 = access$locationOf + 1;
        boolean z = false;
        int i5 = 0;
        while (access$locationOf >= 0) {
            Anchor anchor = this.anchors.get(access$locationOf);
            Intrinsics.checkNotNullExpressionValue(anchor, "anchors[index]");
            Anchor anchor2 = anchor;
            int anchorIndex = anchorIndex(anchor2);
            if (anchorIndex < i) {
                break;
            }
            if (anchorIndex < i3) {
                anchor2.setLocation$runtime_release(Integer.MIN_VALUE);
                if (i5 == 0) {
                    i5 = access$locationOf + 1;
                }
                i4 = access$locationOf;
            }
            access$locationOf--;
        }
        if (i4 < i5) {
            z = true;
        }
        if (z) {
            this.anchors.subList(i4, i5).clear();
        }
        return z;
    }

    private final void moveAnchors(int i, int i2, int i3) {
        int i4 = i3 + i;
        int size$runtime_release = getSize$runtime_release();
        int access$locationOf = SlotTableKt.locationOf(this.anchors, i, size$runtime_release);
        List arrayList = new ArrayList();
        if (access$locationOf >= 0) {
            while (access$locationOf < this.anchors.size()) {
                Anchor anchor = this.anchors.get(access$locationOf);
                Intrinsics.checkNotNullExpressionValue(anchor, "anchors[index]");
                Anchor anchor2 = anchor;
                int anchorIndex = anchorIndex(anchor2);
                if (anchorIndex < i || anchorIndex >= i4) {
                    break;
                }
                arrayList.add(anchor2);
                this.anchors.remove(access$locationOf);
            }
        }
        int i5 = i2 - i;
        int i6 = 0;
        int size = arrayList.size();
        while (i6 < size) {
            int i7 = i6 + 1;
            Anchor anchor3 = (Anchor) arrayList.get(i6);
            int anchorIndex2 = anchorIndex(anchor3) + i5;
            if (anchorIndex2 >= this.groupGapStart) {
                anchor3.setLocation$runtime_release(-(size$runtime_release - anchorIndex2));
            } else {
                anchor3.setLocation$runtime_release(anchorIndex2);
            }
            this.anchors.add(SlotTableKt.locationOf(this.anchors, anchorIndex2, size$runtime_release), anchor3);
            i6 = i7;
        }
    }

    public final String groupsAsString() {
        StringBuilder sb = new StringBuilder();
        int size$runtime_release = getSize$runtime_release();
        for (int i = 0; i < size$runtime_release; i++) {
            groupAsString(sb, i);
            sb.append(10);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    private final void groupAsString(StringBuilder sb, int i) {
        int groupIndexToAddress = groupIndexToAddress(i);
        sb.append("Group(");
        if (i < 10) {
            sb.append(' ');
        }
        if (i < 100) {
            sb.append(' ');
        }
        if (i < 1000) {
            sb.append(' ');
        }
        sb.append(i);
        sb.append('#');
        sb.append(SlotTableKt.groupSize(this.groups, groupIndexToAddress));
        sb.append('^');
        sb.append(parentAnchorToIndex(SlotTableKt.parentAnchor(this.groups, groupIndexToAddress)));
        sb.append(": key=");
        sb.append(SlotTableKt.key(this.groups, groupIndexToAddress));
        sb.append(", nodes=");
        sb.append(SlotTableKt.nodeCount(this.groups, groupIndexToAddress));
        sb.append(", dataAnchor=");
        sb.append(SlotTableKt.dataAnchor(this.groups, groupIndexToAddress));
        sb.append(", parentAnchor=");
        sb.append(SlotTableKt.parentAnchor(this.groups, groupIndexToAddress));
        sb.append(")");
    }

    public final void verifyDataAnchors$runtime_release() {
        int i = this.slotsGapOwner;
        int length = this.slots.length - this.slotsGapLen;
        int size$runtime_release = getSize$runtime_release();
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        while (i2 < size$runtime_release) {
            int i4 = i2 + 1;
            int groupIndexToAddress = groupIndexToAddress(i2);
            int access$dataAnchor = SlotTableKt.dataAnchor(this.groups, groupIndexToAddress);
            int dataIndex = dataIndex(this.groups, groupIndexToAddress);
            if (dataIndex >= i3) {
                if (dataIndex <= length) {
                    if (access$dataAnchor < 0 && !z) {
                        if (i == i2) {
                            z = true;
                        } else {
                            throw new IllegalStateException(("Expected the slot gap owner to be " + i + " found gap at " + i2).toString());
                        }
                    }
                    i2 = i4;
                    i3 = dataIndex;
                } else {
                    throw new IllegalStateException(("Data index, " + dataIndex + ", out of bound at " + i2).toString());
                }
            } else {
                throw new IllegalStateException(("Data index out of order at " + i2 + ", previous = " + i3 + ", current = " + dataIndex).toString());
            }
        }
    }

    public final void verifyParentAnchors$runtime_release() {
        int i = this.groupGapStart;
        int i2 = this.groupGapLen;
        int capacity = getCapacity();
        int i3 = 0;
        while (true) {
            boolean z = true;
            if (i3 < i) {
                int i4 = i3 + 1;
                if (SlotTableKt.parentAnchor(this.groups, i3) <= -2) {
                    z = false;
                }
                if (z) {
                    i3 = i4;
                } else {
                    throw new IllegalStateException(Intrinsics.stringPlus("Expected a start relative anchor at ", Integer.valueOf(i3)).toString());
                }
            } else {
                int i5 = i2 + i;
                while (i5 < capacity) {
                    int i6 = i5 + 1;
                    int access$parentAnchor = SlotTableKt.parentAnchor(this.groups, i5);
                    if (parentAnchorToIndex(access$parentAnchor) < i) {
                        if (!(access$parentAnchor > -2)) {
                            throw new IllegalStateException(Intrinsics.stringPlus("Expected a start relative anchor at ", Integer.valueOf(i5)).toString());
                        }
                    } else {
                        if (!(access$parentAnchor <= -2)) {
                            throw new IllegalStateException(Intrinsics.stringPlus("Expected an end relative anchor at ", Integer.valueOf(i5)).toString());
                        }
                    }
                    i5 = i6;
                }
                return;
            }
        }
    }

    public final int getSize$runtime_release() {
        return getCapacity() - this.groupGapLen;
    }

    private final int getCapacity() {
        return this.groups.length / 5;
    }

    private final int groupIndexToAddress(int i) {
        return i < this.groupGapStart ? i : i + this.groupGapLen;
    }

    /* access modifiers changed from: private */
    public final int dataIndexToDataAddress(int i) {
        return i < this.slotsGapStart ? i : i + this.slotsGapLen;
    }

    private final int parent(int[] iArr, int i) {
        return parentAnchorToIndex(SlotTableKt.parentAnchor(iArr, groupIndexToAddress(i)));
    }

    private final int dataIndex(int i) {
        return dataIndex(this.groups, groupIndexToAddress(i));
    }

    private final int dataIndex(int[] iArr, int i) {
        if (i >= getCapacity()) {
            return this.slots.length - this.slotsGapLen;
        }
        return dataAnchorToDataIndex(SlotTableKt.dataAnchor(iArr, i), this.slotsGapLen, this.slots.length);
    }

    private final int slotIndex(int[] iArr, int i) {
        if (i >= getCapacity()) {
            return this.slots.length - this.slotsGapLen;
        }
        return dataAnchorToDataIndex(SlotTableKt.slotAnchor(iArr, i), this.slotsGapLen, this.slots.length);
    }

    private final void updateDataIndex(int[] iArr, int i, int i2) {
        SlotTableKt.updateDataAnchor(iArr, i, dataIndexToDataAnchor(i2, this.slotsGapStart, this.slotsGapLen, this.slots.length));
    }

    private final int nodeIndex(int[] iArr, int i) {
        return dataIndex(iArr, i);
    }

    private final int auxIndex(int[] iArr, int i) {
        return dataIndex(iArr, i) + SlotTableKt.countOneBits(SlotTableKt.groupInfo(iArr, i) >> 29);
    }

    private final List<Integer> dataIndexes(int[] iArr) {
        List dataAnchors$default = SlotTableKt.dataAnchors$default(this.groups, 0, 1, (Object) null);
        List plus = CollectionsKt.plus(CollectionsKt.slice(dataAnchors$default, RangesKt.until(0, this.groupGapStart)), CollectionsKt.slice(dataAnchors$default, RangesKt.until(this.groupGapStart + this.groupGapLen, iArr.length / 5)));
        ArrayList arrayList = new ArrayList(plus.size());
        int size = plus.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(Integer.valueOf(dataAnchorToDataIndex(((Number) plus.get(i)).intValue(), this.slotsGapLen, this.slots.length)));
        }
        return arrayList;
    }

    private final List<Integer> keys() {
        List keys$default = SlotTableKt.keys$default(this.groups, 0, 1, (Object) null);
        ArrayList arrayList = new ArrayList(keys$default.size());
        int size = keys$default.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            Object obj = keys$default.get(i);
            ((Number) obj).intValue();
            int i3 = this.groupGapStart;
            if (i < i3 || i >= i3 + this.groupGapLen) {
                arrayList.add(obj);
            }
            i = i2;
        }
        return arrayList;
    }

    private final int parentIndexToAnchor(int i, int i2) {
        return i < i2 ? i : -((getSize$runtime_release() - i) + 2);
    }

    private final int parentAnchorToIndex(int i) {
        return i > -2 ? i : getSize$runtime_release() + i + 2;
    }
}
