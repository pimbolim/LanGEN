package androidx.compose.runtime;

import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.CompositionGroup;
import com.nimbusds.jose.shaded.ow2asm.signature.SignatureVisitor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0005¢\u0006\u0002\u0010\u0004J\u000e\u0010+\u001a\u00020\u00152\u0006\u0010,\u001a\u00020\u0007J\u0006\u0010-\u001a\u00020.J\u0015\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0000¢\u0006\u0002\b3JW\u0010/\u001a\u0002002\u0006\u0010)\u001a\u0002042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00152\u000e\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001d2\u0006\u0010#\u001a\u00020\u00152\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bH\u0000¢\u0006\u0004\b3\u00105J\u000e\u00106\u001a\b\u0012\u0004\u0012\u00020\u001507H\u0002J\u000e\u00108\u001a\b\u0012\u0004\u0012\u00020\u001507H\u0002J\u000f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00030:H\u0002J\u000e\u0010;\u001a\b\u0012\u0004\u0012\u00020\u001507H\u0002J\u000e\u0010<\u001a\b\u0012\u0004\u0012\u00020\u001507H\u0002J\u0006\u0010=\u001a\u000202J\u0006\u0010>\u001a\u000204J\u000e\u0010?\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020\u0007J\u000e\u0010@\u001a\b\u0012\u0004\u0012\u00020\u001507H\u0002J:\u0010A\u001a\u0002HB\"\u0004\b\u0000\u0010B2!\u0010C\u001a\u001d\u0012\u0013\u0012\u001102¢\u0006\f\bE\u0012\b\bF\u0012\u0004\b\b(1\u0012\u0004\u0012\u0002HB0DH\bø\u0001\u0000¢\u0006\u0002\u0010GJO\u0010H\u001a\u0002002\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00152\u000e\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001d2\u0006\u0010#\u001a\u00020\u00152\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bH\u0000¢\u0006\u0004\bI\u0010JJ\u001d\u0010K\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e072\u0006\u0010L\u001a\u00020\u0015H\u0000¢\u0006\u0002\bMJ\u0006\u0010N\u001a\u000200J:\u0010O\u001a\u0002HB\"\u0004\b\u0000\u0010B2!\u0010C\u001a\u001d\u0012\u0013\u0012\u001104¢\u0006\f\bE\u0012\b\bF\u0012\u0004\b\b()\u0012\u0004\u0012\u0002HB0DH\bø\u0001\u0000¢\u0006\u0002\u0010GJ \u0010P\u001a\u00020\u0015*\u00060Qj\u0002`R2\u0006\u0010S\u001a\u00020\u00152\u0006\u0010T\u001a\u00020\u0015H\u0002R*\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0015@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R0\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001d2\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001d@BX\u000e¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u001e\u0010#\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0015@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0018R\u001a\u0010%\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0018\"\u0004\b'\u0010(R\u001e\u0010)\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u001a@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001b\u0002\u0007\n\u0005\b20\u0001¨\u0006U"}, d2 = {"Landroidx/compose/runtime/SlotTable;", "Landroidx/compose/runtime/tooling/CompositionData;", "", "Landroidx/compose/runtime/tooling/CompositionGroup;", "()V", "anchors", "Ljava/util/ArrayList;", "Landroidx/compose/runtime/Anchor;", "Lkotlin/collections/ArrayList;", "getAnchors$runtime_release", "()Ljava/util/ArrayList;", "setAnchors$runtime_release", "(Ljava/util/ArrayList;)V", "compositionGroups", "getCompositionGroups", "()Ljava/lang/Iterable;", "<set-?>", "", "groups", "getGroups", "()[I", "", "groupsSize", "getGroupsSize", "()I", "isEmpty", "", "()Z", "readers", "", "", "slots", "getSlots", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "slotsSize", "getSlotsSize", "version", "getVersion$runtime_release", "setVersion$runtime_release", "(I)V", "writer", "getWriter$runtime_release", "anchorIndex", "anchor", "asString", "", "close", "", "reader", "Landroidx/compose/runtime/SlotReader;", "close$runtime_release", "Landroidx/compose/runtime/SlotWriter;", "(Landroidx/compose/runtime/SlotWriter;[II[Ljava/lang/Object;ILjava/util/ArrayList;)V", "dataIndexes", "", "groupSizes", "iterator", "", "keys", "nodes", "openReader", "openWriter", "ownsAnchor", "parentIndexes", "read", "T", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "setTo", "setTo$runtime_release", "([II[Ljava/lang/Object;ILjava/util/ArrayList;)V", "slotsOf", "group", "slotsOf$runtime_release", "verifyWellFormed", "write", "emitGroup", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "index", "level", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SlotTable.kt */
public final class SlotTable implements CompositionData, Iterable<CompositionGroup>, KMappedMarker {
    private ArrayList<Anchor> anchors = new ArrayList<>();
    private int[] groups = new int[0];
    private int groupsSize;
    private int readers;
    private Object[] slots = new Object[0];
    private int slotsSize;
    private int version;
    private boolean writer;

    public final int[] getGroups() {
        return this.groups;
    }

    public final int getGroupsSize() {
        return this.groupsSize;
    }

    public final Object[] getSlots() {
        return this.slots;
    }

    public final int getSlotsSize() {
        return this.slotsSize;
    }

    public final boolean getWriter$runtime_release() {
        return this.writer;
    }

    public final int getVersion$runtime_release() {
        return this.version;
    }

    public final void setVersion$runtime_release(int i) {
        this.version = i;
    }

    public final ArrayList<Anchor> getAnchors$runtime_release() {
        return this.anchors;
    }

    public final void setAnchors$runtime_release(ArrayList<Anchor> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.anchors = arrayList;
    }

    public boolean isEmpty() {
        return this.groupsSize == 0;
    }

    public final <T> T read(Function1<? super SlotReader, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        SlotReader openReader = openReader();
        try {
            return function1.invoke(openReader);
        } finally {
            InlineMarker.finallyStart(1);
            openReader.close();
            InlineMarker.finallyEnd(1);
        }
    }

    public final <T> T write(Function1<? super SlotWriter, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        SlotWriter openWriter = openWriter();
        try {
            return function1.invoke(openWriter);
        } finally {
            InlineMarker.finallyStart(1);
            openWriter.close();
            InlineMarker.finallyEnd(1);
        }
    }

    public final SlotReader openReader() {
        if (!this.writer) {
            this.readers++;
            return new SlotReader(this);
        }
        throw new IllegalStateException("Cannot read while a writer is pending".toString());
    }

    public final SlotWriter openWriter() {
        if (!this.writer) {
            if (this.readers <= 0) {
                this.writer = true;
                this.version++;
                return new SlotWriter(this);
            }
            ComposerKt.composeRuntimeError("Cannot start a writer when a reader is pending".toString());
            throw new KotlinNothingValueException();
        }
        ComposerKt.composeRuntimeError("Cannot start a writer when another writer is pending".toString());
        throw new KotlinNothingValueException();
    }

    public final int anchorIndex(Anchor anchor) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        if (!(!this.writer)) {
            ComposerKt.composeRuntimeError("Use active SlotWriter to determine anchor location instead".toString());
            throw new KotlinNothingValueException();
        } else if (anchor.getValid()) {
            return anchor.getLocation$runtime_release();
        } else {
            throw new IllegalArgumentException("Anchor refers to a group that was removed".toString());
        }
    }

    public final boolean ownsAnchor(Anchor anchor) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        if (anchor.getValid()) {
            int access$search = SlotTableKt.search(this.anchors, anchor.getLocation$runtime_release(), this.groupsSize);
            if (access$search >= 0 && Intrinsics.areEqual((Object) getAnchors$runtime_release().get(access$search), (Object) anchor)) {
                return true;
            }
        }
        return false;
    }

    public final void close$runtime_release(SlotReader slotReader) {
        Intrinsics.checkNotNullParameter(slotReader, "reader");
        if (slotReader.getTable$runtime_release() == this && this.readers > 0) {
            this.readers--;
            return;
        }
        throw new IllegalArgumentException("Unexpected reader close()".toString());
    }

    public final void close$runtime_release(SlotWriter slotWriter, int[] iArr, int i, Object[] objArr, int i2, ArrayList<Anchor> arrayList) {
        Intrinsics.checkNotNullParameter(slotWriter, "writer");
        Intrinsics.checkNotNullParameter(iArr, "groups");
        Intrinsics.checkNotNullParameter(objArr, "slots");
        Intrinsics.checkNotNullParameter(arrayList, "anchors");
        if (slotWriter.getTable$runtime_release() == this && this.writer) {
            this.writer = false;
            setTo$runtime_release(iArr, i, objArr, i2, arrayList);
            return;
        }
        throw new IllegalArgumentException("Unexpected writer close()".toString());
    }

    public final void setTo$runtime_release(int[] iArr, int i, Object[] objArr, int i2, ArrayList<Anchor> arrayList) {
        Intrinsics.checkNotNullParameter(iArr, "groups");
        Intrinsics.checkNotNullParameter(objArr, "slots");
        Intrinsics.checkNotNullParameter(arrayList, "anchors");
        this.groups = iArr;
        this.groupsSize = i;
        this.slots = objArr;
        this.slotsSize = i2;
        this.anchors = arrayList;
    }

    public final void verifyWellFormed() {
        Ref.IntRef intRef = new Ref.IntRef();
        int i = -1;
        if (this.groupsSize > 0) {
            while (intRef.element < this.groupsSize) {
                verifyWellFormed$validateGroup(intRef, this, -1, intRef.element + SlotTableKt.groupSize(this.groups, intRef.element));
            }
            if (!(intRef.element == this.groupsSize)) {
                throw new IllegalStateException(("Incomplete group at root " + intRef.element + " expected to be " + getGroupsSize()).toString());
            }
        }
        List list = this.anchors;
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            int i3 = i2 + 1;
            int indexFor = ((Anchor) list.get(i2)).toIndexFor(this);
            if (indexFor >= 0 && indexFor <= getGroupsSize()) {
                if (i < indexFor) {
                    i = indexFor;
                    i2 = i3;
                } else {
                    throw new IllegalArgumentException("Anchor is out of order".toString());
                }
            } else {
                throw new IllegalArgumentException("Location out of bound".toString());
            }
        }
    }

    private static final int verifyWellFormed$validateGroup(Ref.IntRef intRef, SlotTable slotTable, int i, int i2) {
        int i3 = intRef.element;
        int i4 = i3 + 1;
        intRef.element = i4;
        int access$parentAnchor = SlotTableKt.parentAnchor(slotTable.groups, i3);
        boolean z = false;
        if (access$parentAnchor == i) {
            int access$groupSize = SlotTableKt.groupSize(slotTable.groups, i3) + i3;
            if (access$groupSize <= slotTable.groupsSize) {
                if (access$groupSize <= i2) {
                    int access$dataAnchor = SlotTableKt.dataAnchor(slotTable.groups, i3);
                    int access$dataAnchor2 = i3 >= slotTable.groupsSize - 1 ? slotTable.slotsSize : SlotTableKt.dataAnchor(slotTable.groups, i4);
                    if (access$dataAnchor2 <= slotTable.slots.length) {
                        if (access$dataAnchor <= access$dataAnchor2) {
                            if (SlotTableKt.slotAnchor(slotTable.groups, i3) <= access$dataAnchor2) {
                                if (access$dataAnchor2 - access$dataAnchor >= ((SlotTableKt.isNode(slotTable.groups, i3) ? 1 : 0) + (SlotTableKt.hasObjectKey(slotTable.groups, i3) ? 1 : 0)) + (SlotTableKt.hasAux(slotTable.groups, i3) ? 1 : 0)) {
                                    boolean access$isNode = SlotTableKt.isNode(slotTable.groups, i3);
                                    if (!access$isNode || slotTable.slots[SlotTableKt.nodeIndex(slotTable.groups, i3)] != null) {
                                        int i5 = 0;
                                        while (intRef.element < access$groupSize) {
                                            i5 += verifyWellFormed$validateGroup(intRef, slotTable, i3, access$groupSize);
                                        }
                                        int access$nodeCount = SlotTableKt.nodeCount(slotTable.groups, i3);
                                        int access$groupSize2 = SlotTableKt.groupSize(slotTable.groups, i3);
                                        if (access$nodeCount == i5) {
                                            int i6 = intRef.element - i3;
                                            if (access$groupSize2 == i6) {
                                                z = true;
                                            }
                                            if (!z) {
                                                throw new IllegalStateException(("Incorrect slot count detected at " + i3 + ", expected " + access$groupSize2 + ", received " + i6).toString());
                                            } else if (access$isNode) {
                                                return 1;
                                            } else {
                                                return i5;
                                            }
                                        } else {
                                            throw new IllegalStateException(("Incorrect node count detected at " + i3 + ", expected " + access$nodeCount + ", received " + i5).toString());
                                        }
                                    } else {
                                        throw new IllegalStateException(Intrinsics.stringPlus("No node recorded for a node group at ", Integer.valueOf(i3)).toString());
                                    }
                                } else {
                                    throw new IllegalStateException(Intrinsics.stringPlus("Not enough slots added for group ", Integer.valueOf(i3)).toString());
                                }
                            } else {
                                throw new IllegalStateException(Intrinsics.stringPlus("Slots start out of range at ", Integer.valueOf(i3)).toString());
                            }
                        } else {
                            throw new IllegalStateException(Intrinsics.stringPlus("Invalid data anchor at ", Integer.valueOf(i3)).toString());
                        }
                    } else {
                        throw new IllegalStateException(("Slots for " + i3 + " extend past the end of the slot table").toString());
                    }
                } else {
                    throw new IllegalStateException(Intrinsics.stringPlus("A group extends past its parent group at ", Integer.valueOf(i3)).toString());
                }
            } else {
                throw new IllegalStateException(Intrinsics.stringPlus("A group extends past the end of the table at ", Integer.valueOf(i3)).toString());
            }
        } else {
            throw new IllegalStateException(("Invalid parent index detected at " + i3 + ", expected parent index to be " + i + " found " + access$parentAnchor).toString());
        }
    }

    public final String asString() {
        if (this.writer) {
            return super.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(10);
        int groupsSize2 = getGroupsSize();
        if (groupsSize2 > 0) {
            int i = 0;
            while (i < groupsSize2) {
                i += emitGroup(sb, i, 0);
            }
        } else {
            sb.append("<EMPTY>");
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    private final int emitGroup(StringBuilder sb, int i, int i2) {
        boolean z = false;
        int i3 = 0;
        while (i3 < i2) {
            i3++;
            sb.append(' ');
        }
        sb.append("Group(");
        sb.append(i);
        sb.append(") key=");
        sb.append(SlotTableKt.key(this.groups, i));
        int access$groupSize = SlotTableKt.groupSize(this.groups, i);
        sb.append(", nodes=");
        sb.append(SlotTableKt.nodeCount(this.groups, i));
        sb.append(", size=");
        sb.append(access$groupSize);
        int emitGroup$dataIndex = emitGroup$dataIndex(this, i);
        int i4 = i + 1;
        int emitGroup$dataIndex2 = emitGroup$dataIndex(this, i4);
        if (emitGroup$dataIndex >= 0 && emitGroup$dataIndex <= emitGroup$dataIndex2) {
            z = true;
        }
        if (!z || emitGroup$dataIndex2 > this.slotsSize) {
            sb.append(", *invalid data offsets " + emitGroup$dataIndex + SignatureVisitor.SUPER + emitGroup$dataIndex2 + '*');
        } else {
            if (SlotTableKt.hasObjectKey(this.groups, i)) {
                sb.append(Intrinsics.stringPlus(" objectKey=", this.slots[SlotTableKt.objectKeyIndex(this.groups, i)]));
            }
            if (SlotTableKt.isNode(this.groups, i)) {
                sb.append(Intrinsics.stringPlus(" node=", this.slots[SlotTableKt.nodeIndex(this.groups, i)]));
            }
            if (SlotTableKt.hasAux(this.groups, i)) {
                sb.append(Intrinsics.stringPlus(" aux=", this.slots[SlotTableKt.auxIndex(this.groups, i)]));
            }
            int access$slotAnchor = SlotTableKt.slotAnchor(this.groups, i);
            if (access$slotAnchor < emitGroup$dataIndex2) {
                sb.append(", slots=[");
                sb.append(access$slotAnchor);
                sb.append(": ");
                int i5 = access$slotAnchor;
                while (i5 < emitGroup$dataIndex2) {
                    int i6 = i5 + 1;
                    if (i5 != access$slotAnchor) {
                        sb.append(", ");
                    }
                    sb.append(String.valueOf(this.slots[i5]));
                    i5 = i6;
                }
                sb.append("]");
            }
        }
        sb.append(10);
        int i7 = i + access$groupSize;
        while (i4 < i7) {
            i4 += emitGroup(sb, i4, i2 + 1);
        }
        return access$groupSize;
    }

    private static final int emitGroup$dataIndex(SlotTable slotTable, int i) {
        return i >= slotTable.groupsSize ? slotTable.slotsSize : SlotTableKt.dataAnchor(slotTable.groups, i);
    }

    private final List<Integer> keys() {
        return SlotTableKt.keys(this.groups, this.groupsSize * 5);
    }

    private final List<Integer> nodes() {
        return SlotTableKt.nodeCounts(this.groups, this.groupsSize * 5);
    }

    private final List<Integer> parentIndexes() {
        return SlotTableKt.parentAnchors(this.groups, this.groupsSize * 5);
    }

    private final List<Integer> dataIndexes() {
        return SlotTableKt.dataAnchors(this.groups, this.groupsSize * 5);
    }

    private final List<Integer> groupSizes() {
        return SlotTableKt.groupSizes(this.groups, this.groupsSize * 5);
    }

    public final List<Object> slotsOf$runtime_release(int i) {
        int access$dataAnchor = SlotTableKt.dataAnchor(this.groups, i);
        int i2 = i + 1;
        return ArraysKt.toList((T[]) this.slots).subList(access$dataAnchor, i2 < this.groupsSize ? SlotTableKt.dataAnchor(this.groups, i2) : this.slots.length);
    }

    public Iterable<CompositionGroup> getCompositionGroups() {
        return this;
    }

    public Iterator<CompositionGroup> iterator() {
        return new GroupIterator(this, 0, this.groupsSize);
    }
}
