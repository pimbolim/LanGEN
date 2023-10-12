package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.DeltaCounter;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0000\u0018\u0000 _*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001_B\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006¢\u0006\u0002\u0010\u0007B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ)\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u0004¢\u0006\u0002\u0010\u001cJ#\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001fJ\b\u0010 \u001a\u00020\u0004H\u0002J\u001b\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001a\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\"J\u0015\u0010#\u001a\u00020$2\u0006\u0010\u001a\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010%J\u001b\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001a\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\"J\u0016\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010(\u001a\u00020\u0004H\u0002J#\u0010)\u001a\u00020$2\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u0004¢\u0006\u0002\u0010*J\u001c\u0010+\u001a\u00020$2\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001b\u001a\u00020\u0004J\u0015\u0010-\u001a\u00028\u00002\u0006\u0010.\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010/J\u0016\u00100\u001a\u00020$2\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0002J\u0010\u00101\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u0004H\u0002J\u0015\u00102\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0000¢\u0006\u0002\b3JE\u00104\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u00105\u001a\u00020\u00042\u0006\u00106\u001a\u00028\u00002\u0006\u00107\u001a\u00020\u00042\u0006\u00108\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u00042\b\u00109\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u0010:J=\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010<\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u00042\u0006\u0010>\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u00042\b\u00109\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u0010?J3\u0010@\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010<\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u00042\u0006\u0010>\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010AJ5\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u00042\n\u0010C\u001a\u0006\u0012\u0002\b\u00030D¢\u0006\u0002\u0010EJ6\u0010F\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010G\u001a\u00020H2\n\u0010C\u001a\u0006\u0012\u0002\b\u00030DJ+\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u00109\u001a\u00020\tH\u0002¢\u0006\u0002\u0010JJ'\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001a\u001a\u00028\u00002\n\u0010C\u001a\u0006\u0012\u0002\b\u00030DH\u0002¢\u0006\u0002\u0010LJ,\u0010M\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010G\u001a\u00020H2\u0006\u00109\u001a\u00020\tH\u0002J'\u0010N\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001a\u001a\u00028\u00002\n\u0010C\u001a\u0006\u0012\u0002\b\u00030DH\u0002¢\u0006\u0002\u0010LJ(\u0010O\u001a\u0004\u0018\u00010\u00022\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010G\u001a\u00020H2\u0006\u00109\u001a\u00020\tH\u0002J\u001e\u0010P\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010(\u001a\u00020\u00042\u0006\u00109\u001a\u00020\tH\u0002J(\u0010Q\u001a\u0004\u0018\u00010\u00022\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010G\u001a\u00020H2\u0006\u00109\u001a\u00020\tH\u0002J;\u0010R\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010<\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u00042\u0006\u0010>\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u00109\u001a\u00020\tH\u0002¢\u0006\u0002\u0010?J5\u0010S\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u00042\n\u0010C\u001a\u0006\u0012\u0002\b\u00030D¢\u0006\u0002\u0010EJ2\u0010T\u001a\u0004\u0018\u00010\u00022\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010G\u001a\u00020H2\n\u0010C\u001a\u0006\u0012\u0002\b\u00030DJ&\u0010U\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010V\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u00109\u001a\u00020\tH\u0002J2\u0010W\u001a\u0004\u0018\u00010\u00022\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010G\u001a\u00020H2\n\u0010C\u001a\u0006\u0012\u0002\b\u00030DJ,\u0010X\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010Y\u001a\u00020\u00042\f\u0010Z\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u00109\u001a\u00020\tH\u0002J\u0016\u0010[\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010.\u001a\u00020\u0004H\u0002J)\u0010\\\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u0004¢\u0006\u0002\u0010\u001cJ\u001e\u0010]\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010V\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0002J$\u0010^\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010Y\u001a\u00020\u00042\f\u0010Z\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006`"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "E", "", "bitmap", "", "buffer", "", "(I[Ljava/lang/Object;)V", "ownedBy", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;", "(I[Ljava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)V", "getBitmap", "()I", "setBitmap", "(I)V", "getBuffer", "()[Ljava/lang/Object;", "setBuffer", "([Ljava/lang/Object;)V", "[Ljava/lang/Object;", "getOwnedBy", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;", "setOwnedBy", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)V", "add", "elementHash", "element", "shift", "(ILjava/lang/Object;I)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "addElementAt", "positionMask", "(ILjava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "calculateSize", "collisionAdd", "(Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "collisionContainsElement", "", "(Ljava/lang/Object;)Z", "collisionRemove", "collisionRemoveElementAtIndex", "i", "contains", "(ILjava/lang/Object;I)Z", "containsAll", "otherNode", "elementAtIndex", "index", "(I)Ljava/lang/Object;", "elementsIdentityEquals", "hasNoCellAt", "indexOfCellAt", "indexOfCellAt$runtime_release", "makeNode", "elementHash1", "element1", "elementHash2", "element2", "owner", "(ILjava/lang/Object;ILjava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "makeNodeAtIndex", "elementIndex", "newElementHash", "newElement", "(IILjava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "moveElementToNode", "(IILjava/lang/Object;I)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "mutableAdd", "mutator", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSetBuilder;", "(ILjava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSetBuilder;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "mutableAddAll", "intersectionSizeRef", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/DeltaCounter;", "mutableAddElementAt", "(ILjava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "mutableCollisionAdd", "(Ljava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSetBuilder;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "mutableCollisionAddAll", "mutableCollisionRemove", "mutableCollisionRemoveAll", "mutableCollisionRemoveElementAtIndex", "mutableCollisionRetainAll", "mutableMoveElementToNode", "mutableRemove", "mutableRemoveAll", "mutableRemoveCellAtIndex", "cellIndex", "mutableRetainAll", "mutableUpdateNodeAtIndex", "nodeIndex", "newNode", "nodeAtIndex", "remove", "removeCellAtIndex", "updateNodeAtIndex", "Companion", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TrieNode.kt */
public final class TrieNode<E> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final TrieNode EMPTY = new TrieNode(0, new Object[0]);
    private int bitmap;
    private Object[] buffer;
    private MutabilityOwnership ownedBy;

    public TrieNode(int i, Object[] objArr, MutabilityOwnership mutabilityOwnership) {
        Intrinsics.checkNotNullParameter(objArr, "buffer");
        this.bitmap = i;
        this.buffer = objArr;
        this.ownedBy = mutabilityOwnership;
    }

    public final int getBitmap() {
        return this.bitmap;
    }

    public final void setBitmap(int i) {
        this.bitmap = i;
    }

    public final Object[] getBuffer() {
        return this.buffer;
    }

    public final void setBuffer(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<set-?>");
        this.buffer = objArr;
    }

    public final MutabilityOwnership getOwnedBy() {
        return this.ownedBy;
    }

    public final void setOwnedBy(MutabilityOwnership mutabilityOwnership) {
        this.ownedBy = mutabilityOwnership;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TrieNode(int i, Object[] objArr) {
        this(i, objArr, (MutabilityOwnership) null);
        Intrinsics.checkNotNullParameter(objArr, "buffer");
    }

    private final boolean hasNoCellAt(int i) {
        return (i & this.bitmap) == 0;
    }

    public final int indexOfCellAt$runtime_release(int i) {
        return Integer.bitCount((i - 1) & this.bitmap);
    }

    private final E elementAtIndex(int i) {
        return this.buffer[i];
    }

    private final TrieNode<E> nodeAtIndex(int i) {
        Object obj = this.buffer[i];
        Objects.requireNonNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode>");
        return (TrieNode) obj;
    }

    private final TrieNode<E> addElementAt(int i, E e) {
        return new TrieNode<>(i | this.bitmap, TrieNodeKt.addElementAtIndex(this.buffer, indexOfCellAt$runtime_release(i), e));
    }

    private final TrieNode<E> mutableAddElementAt(int i, E e, MutabilityOwnership mutabilityOwnership) {
        int indexOfCellAt$runtime_release = indexOfCellAt$runtime_release(i);
        if (this.ownedBy == mutabilityOwnership) {
            this.buffer = TrieNodeKt.addElementAtIndex(this.buffer, indexOfCellAt$runtime_release, e);
            this.bitmap = i | this.bitmap;
            return this;
        }
        return new TrieNode<>(i | this.bitmap, TrieNodeKt.addElementAtIndex(this.buffer, indexOfCellAt$runtime_release, e), mutabilityOwnership);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> updateNodeAtIndex(int r5, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> r6) {
        /*
            r4 = this;
            java.lang.Object[] r0 = r6.buffer
            int r1 = r0.length
            r2 = 1
            if (r1 != r2) goto L_0x0019
            r1 = 0
            r3 = r0[r1]
            boolean r3 = r3 instanceof androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode
            if (r3 != 0) goto L_0x0019
            java.lang.Object[] r3 = r4.buffer
            int r3 = r3.length
            if (r3 != r2) goto L_0x0017
            int r5 = r4.bitmap
            r6.bitmap = r5
            return r6
        L_0x0017:
            r6 = r0[r1]
        L_0x0019:
            java.lang.Object[] r0 = r4.buffer
            int r1 = r0.length
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r1)
            java.lang.String r1 = "copyOf(this, size)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r0[r5] = r6
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r5 = new androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode
            int r6 = r4.bitmap
            r5.<init>(r6, r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.updateNodeAtIndex(int, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode):androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> mutableUpdateNodeAtIndex(int r5, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> r6, androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership r7) {
        /*
            r4 = this;
            java.lang.Object[] r0 = r6.buffer
            int r1 = r0.length
            r2 = 1
            if (r1 != r2) goto L_0x0019
            r1 = 0
            r3 = r0[r1]
            boolean r3 = r3 instanceof androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode
            if (r3 != 0) goto L_0x0019
            java.lang.Object[] r3 = r4.buffer
            int r3 = r3.length
            if (r3 != r2) goto L_0x0017
            int r5 = r4.bitmap
            r6.bitmap = r5
            return r6
        L_0x0017:
            r6 = r0[r1]
        L_0x0019:
            androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership r0 = r4.ownedBy
            if (r0 != r7) goto L_0x0022
            java.lang.Object[] r7 = r4.buffer
            r7[r5] = r6
            return r4
        L_0x0022:
            java.lang.Object[] r0 = r4.buffer
            int r1 = r0.length
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r1)
            java.lang.String r1 = "copyOf(this, size)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r0[r5] = r6
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r5 = new androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode
            int r6 = r4.bitmap
            r5.<init>(r6, r0, r7)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableUpdateNodeAtIndex(int, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode, androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership):androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode");
    }

    private final TrieNode<E> makeNodeAtIndex(int i, int i2, E e, int i3, MutabilityOwnership mutabilityOwnership) {
        int i4;
        Object elementAtIndex = elementAtIndex(i);
        if (elementAtIndex == null) {
            i4 = 0;
        } else {
            i4 = elementAtIndex.hashCode();
        }
        return makeNode(i4, elementAtIndex, i2, e, i3 + 5, mutabilityOwnership);
    }

    private final TrieNode<E> moveElementToNode(int i, int i2, E e, int i3) {
        Object[] objArr = this.buffer;
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        copyOf[i] = makeNodeAtIndex(i, i2, e, i3, (MutabilityOwnership) null);
        return new TrieNode<>(this.bitmap, copyOf);
    }

    private final TrieNode<E> mutableMoveElementToNode(int i, int i2, E e, int i3, MutabilityOwnership mutabilityOwnership) {
        if (this.ownedBy == mutabilityOwnership) {
            this.buffer[i] = makeNodeAtIndex(i, i2, e, i3, mutabilityOwnership);
            return this;
        }
        Object[] objArr = this.buffer;
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        copyOf[i] = makeNodeAtIndex(i, i2, e, i3, mutabilityOwnership);
        return new TrieNode<>(this.bitmap, copyOf, mutabilityOwnership);
    }

    private final TrieNode<E> makeNode(int i, E e, int i2, E e2, int i3, MutabilityOwnership mutabilityOwnership) {
        int i4 = i3;
        MutabilityOwnership mutabilityOwnership2 = mutabilityOwnership;
        if (i4 > 30) {
            return new TrieNode<>(0, new Object[]{e, e2}, mutabilityOwnership2);
        }
        int i5 = i;
        int indexSegment = TrieNodeKt.indexSegment(i, i4);
        int i6 = i2;
        int indexSegment2 = TrieNodeKt.indexSegment(i2, i4);
        if (indexSegment != indexSegment2) {
            return new TrieNode<>((1 << indexSegment) | (1 << indexSegment2), indexSegment < indexSegment2 ? new Object[]{e, e2} : new Object[]{e2, e}, mutabilityOwnership2);
        }
        return new TrieNode<>(1 << indexSegment, new Object[]{makeNode(i, e, i2, e2, i4 + 5, mutabilityOwnership)}, mutabilityOwnership2);
    }

    private final TrieNode<E> removeCellAtIndex(int i, int i2) {
        return new TrieNode<>(i2 ^ this.bitmap, TrieNodeKt.removeCellAtIndex(this.buffer, i));
    }

    private final TrieNode<E> mutableRemoveCellAtIndex(int i, int i2, MutabilityOwnership mutabilityOwnership) {
        if (this.ownedBy == mutabilityOwnership) {
            this.buffer = TrieNodeKt.removeCellAtIndex(this.buffer, i);
            this.bitmap ^= i2;
            return this;
        }
        return new TrieNode<>(i2 ^ this.bitmap, TrieNodeKt.removeCellAtIndex(this.buffer, i), mutabilityOwnership);
    }

    private final TrieNode<E> collisionRemoveElementAtIndex(int i) {
        return new TrieNode<>(0, TrieNodeKt.removeCellAtIndex(this.buffer, i));
    }

    private final TrieNode<E> mutableCollisionRemoveElementAtIndex(int i, MutabilityOwnership mutabilityOwnership) {
        if (this.ownedBy != mutabilityOwnership) {
            return new TrieNode<>(0, TrieNodeKt.removeCellAtIndex(this.buffer, i), mutabilityOwnership);
        }
        this.buffer = TrieNodeKt.removeCellAtIndex(this.buffer, i);
        return this;
    }

    private final boolean collisionContainsElement(E e) {
        return ArraysKt.contains((T[]) this.buffer, e);
    }

    private final TrieNode<E> collisionAdd(E e) {
        if (collisionContainsElement(e)) {
            return this;
        }
        return new TrieNode<>(0, TrieNodeKt.addElementAtIndex(this.buffer, 0, e));
    }

    private final TrieNode<E> mutableCollisionAdd(E e, PersistentHashSetBuilder<?> persistentHashSetBuilder) {
        if (collisionContainsElement(e)) {
            return this;
        }
        persistentHashSetBuilder.setSize(persistentHashSetBuilder.size() + 1);
        if (this.ownedBy != persistentHashSetBuilder.getOwnership$runtime_release()) {
            return new TrieNode<>(0, TrieNodeKt.addElementAtIndex(this.buffer, 0, e), persistentHashSetBuilder.getOwnership$runtime_release());
        }
        this.buffer = TrieNodeKt.addElementAtIndex(this.buffer, 0, e);
        return this;
    }

    private final TrieNode<E> collisionRemove(E e) {
        int indexOf = ArraysKt.indexOf((T[]) this.buffer, e);
        return indexOf != -1 ? collisionRemoveElementAtIndex(indexOf) : this;
    }

    private final TrieNode<E> mutableCollisionRemove(E e, PersistentHashSetBuilder<?> persistentHashSetBuilder) {
        int indexOf = ArraysKt.indexOf((T[]) this.buffer, e);
        if (indexOf == -1) {
            return this;
        }
        persistentHashSetBuilder.setSize(persistentHashSetBuilder.size() - 1);
        return mutableCollisionRemoveElementAtIndex(indexOf, persistentHashSetBuilder.getOwnership$runtime_release());
    }

    private final TrieNode<E> mutableCollisionAddAll(TrieNode<E> trieNode, DeltaCounter deltaCounter, MutabilityOwnership mutabilityOwnership) {
        if (this == trieNode) {
            deltaCounter.plusAssign(this.buffer.length);
            return this;
        }
        Object[] objArr = this.buffer;
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length + trieNode.buffer.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        Object[] objArr2 = trieNode.buffer;
        int length = this.buffer.length;
        int i = 0;
        int i2 = 0;
        while (i < objArr2.length) {
            boolean z = true;
            CommonFunctionsKt.m1249assert(i2 <= i);
            if (!collisionContainsElement(objArr2[i])) {
                copyOf[length + i2] = objArr2[i];
                i2++;
                if (length + i2 > copyOf.length) {
                    z = false;
                }
                CommonFunctionsKt.m1249assert(z);
            }
            i++;
        }
        int length2 = i2 + this.buffer.length;
        deltaCounter.plusAssign(copyOf.length - length2);
        if (length2 == this.buffer.length) {
            return this;
        }
        if (length2 == trieNode.buffer.length) {
            return trieNode;
        }
        if (length2 != copyOf.length) {
            copyOf = Arrays.copyOf(copyOf, length2);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        }
        if (!Intrinsics.areEqual((Object) this.ownedBy, (Object) mutabilityOwnership)) {
            return new TrieNode<>(0, copyOf, mutabilityOwnership);
        }
        this.buffer = copyOf;
        return this;
    }

    private final Object mutableCollisionRetainAll(TrieNode<E> trieNode, DeltaCounter deltaCounter, MutabilityOwnership mutabilityOwnership) {
        Object[] objArr;
        if (this == trieNode) {
            deltaCounter.plusAssign(this.buffer.length);
            return this;
        }
        if (Intrinsics.areEqual((Object) mutabilityOwnership, (Object) this.ownedBy)) {
            objArr = this.buffer;
        } else {
            objArr = new Object[Math.min(this.buffer.length, trieNode.buffer.length)];
        }
        Object[] objArr2 = this.buffer;
        int i = 0;
        int i2 = 0;
        while (true) {
            boolean z = true;
            if (i >= objArr2.length) {
                break;
            }
            CommonFunctionsKt.m1249assert(i2 <= i);
            if (trieNode.collisionContainsElement(objArr2[i])) {
                objArr[0 + i2] = objArr2[i];
                i2++;
                if (0 + i2 > objArr.length) {
                    z = false;
                }
                CommonFunctionsKt.m1249assert(z);
            }
            i++;
        }
        deltaCounter.plusAssign(i2);
        if (i2 == 0) {
            return EMPTY;
        }
        if (i2 == 1) {
            return objArr[0];
        }
        if (i2 == this.buffer.length) {
            return this;
        }
        if (i2 == trieNode.buffer.length) {
            return trieNode;
        }
        if (i2 == objArr.length) {
            return new TrieNode(0, objArr, mutabilityOwnership);
        }
        Object[] copyOf = Arrays.copyOf(objArr, i2);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        return new TrieNode(0, copyOf, mutabilityOwnership);
    }

    private final Object mutableCollisionRemoveAll(TrieNode<E> trieNode, DeltaCounter deltaCounter, MutabilityOwnership mutabilityOwnership) {
        if (this == trieNode) {
            deltaCounter.plusAssign(this.buffer.length);
            return EMPTY;
        }
        Object[] objArr = Intrinsics.areEqual((Object) mutabilityOwnership, (Object) this.ownedBy) ? this.buffer : new Object[this.buffer.length];
        Object[] objArr2 = this.buffer;
        int i = 0;
        int i2 = 0;
        while (true) {
            boolean z = true;
            if (i >= objArr2.length) {
                break;
            }
            CommonFunctionsKt.m1249assert(i2 <= i);
            if (!trieNode.collisionContainsElement(objArr2[i])) {
                objArr[0 + i2] = objArr2[i];
                i2++;
                if (0 + i2 > objArr.length) {
                    z = false;
                }
                CommonFunctionsKt.m1249assert(z);
            }
            i++;
        }
        deltaCounter.plusAssign(this.buffer.length - i2);
        if (i2 == 0) {
            return EMPTY;
        }
        if (i2 == 1) {
            return objArr[0];
        }
        if (i2 == this.buffer.length) {
            return this;
        }
        if (i2 == objArr.length) {
            return new TrieNode(0, objArr, mutabilityOwnership);
        }
        Object[] copyOf = Arrays.copyOf(objArr, i2);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        return new TrieNode(0, copyOf, mutabilityOwnership);
    }

    private final int calculateSize() {
        if (this.bitmap == 0) {
            return this.buffer.length;
        }
        Object[] objArr = this.buffer;
        int length = objArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            Object obj = objArr[i];
            i++;
            i2 += obj instanceof TrieNode ? ((TrieNode) obj).calculateSize() : 1;
        }
        return i2;
    }

    private final boolean elementsIdentityEquals(TrieNode<E> trieNode) {
        if (this == trieNode) {
            return true;
        }
        if (this.bitmap != trieNode.bitmap) {
            return false;
        }
        int length = this.buffer.length;
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            if (this.buffer[i] != trieNode.buffer[i]) {
                return false;
            }
            i = i2;
        }
        return true;
    }

    public final boolean contains(int i, E e, int i2) {
        int indexSegment = 1 << TrieNodeKt.indexSegment(i, i2);
        if (hasNoCellAt(indexSegment)) {
            return false;
        }
        int indexOfCellAt$runtime_release = indexOfCellAt$runtime_release(indexSegment);
        Object[] objArr = this.buffer;
        if (!(objArr[indexOfCellAt$runtime_release] instanceof TrieNode)) {
            return Intrinsics.areEqual((Object) e, objArr[indexOfCellAt$runtime_release]);
        }
        TrieNode nodeAtIndex = nodeAtIndex(indexOfCellAt$runtime_release);
        if (i2 == 30) {
            return nodeAtIndex.collisionContainsElement(e);
        }
        return nodeAtIndex.contains(i, e, i2 + 5);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder<?>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> mutableAddAll(androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> r20, int r21, androidx.compose.runtime.external.kotlinx.collections.immutable.internal.DeltaCounter r22, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder<?> r23) {
        /*
            r19 = this;
            r7 = r19
            r8 = r20
            r9 = r21
            r10 = r22
            r11 = r23
            java.lang.String r0 = "otherNode"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "intersectionSizeRef"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "mutator"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            if (r7 != r8) goto L_0x0028
            int r0 = r22.getCount()
            int r1 = r19.calculateSize()
            int r0 = r0 + r1
            r10.setCount(r0)
            return r7
        L_0x0028:
            r0 = 30
            if (r9 <= r0) goto L_0x0035
            androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership r0 = r23.getOwnership$runtime_release()
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r0 = r7.mutableCollisionAddAll(r8, r10, r0)
            return r0
        L_0x0035:
            int r0 = r7.bitmap
            int r1 = r8.bitmap
            r1 = r1 | r0
            if (r1 != r0) goto L_0x004a
            androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership r0 = r7.ownedBy
            androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership r2 = r23.getOwnership$runtime_release()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r2)
            if (r0 == 0) goto L_0x004a
            r12 = r7
            goto L_0x005a
        L_0x004a:
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r0 = new androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode
            int r2 = java.lang.Integer.bitCount(r1)
            java.lang.Object[] r2 = new java.lang.Object[r2]
            androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership r3 = r23.getOwnership$runtime_release()
            r0.<init>(r1, r2, r3)
            r12 = r0
        L_0x005a:
            r13 = 0
            r14 = r1
            r15 = 0
        L_0x005d:
            if (r14 == 0) goto L_0x0148
            int r6 = java.lang.Integer.lowestOneBit(r14)
            int r0 = r7.indexOfCellAt$runtime_release(r6)
            int r1 = r8.indexOfCellAt$runtime_release(r6)
            java.lang.Object[] r16 = r12.getBuffer()
            boolean r2 = r7.hasNoCellAt(r6)
            if (r2 == 0) goto L_0x007f
            java.lang.Object[] r0 = r20.getBuffer()
            r0 = r0[r1]
        L_0x007b:
            r18 = r6
            goto L_0x0140
        L_0x007f:
            boolean r2 = r8.hasNoCellAt(r6)
            if (r2 == 0) goto L_0x008c
            java.lang.Object[] r1 = r19.getBuffer()
            r0 = r1[r0]
            goto L_0x007b
        L_0x008c:
            java.lang.Object[] r2 = r19.getBuffer()
            r2 = r2[r0]
            java.lang.Object[] r0 = r20.getBuffer()
            r4 = r0[r1]
            boolean r0 = r2 instanceof androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode
            boolean r1 = r4 instanceof androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode
            java.lang.String r3 = "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableAddAll$lambda-6>"
            if (r0 == 0) goto L_0x00b3
            if (r1 == 0) goto L_0x00b3
            java.util.Objects.requireNonNull(r2, r3)
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r2 = (androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode) r2
            java.util.Objects.requireNonNull(r4, r3)
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r4 = (androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode) r4
            int r0 = r9 + 5
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r0 = r2.mutableAddAll(r4, r0, r10, r11)
            goto L_0x007b
        L_0x00b3:
            if (r0 == 0) goto L_0x00df
            java.util.Objects.requireNonNull(r2, r3)
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r2 = (androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode) r2
            int r0 = r23.size()
            if (r4 != 0) goto L_0x00c2
            r1 = 0
            goto L_0x00c6
        L_0x00c2:
            int r1 = r4.hashCode()
        L_0x00c6:
            int r3 = r9 + 5
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r1 = r2.mutableAdd(r1, r4, r3, r11)
            int r2 = r23.size()
            if (r2 != r0) goto L_0x00db
            int r0 = r22.getCount()
            int r0 = r0 + 1
            r10.setCount(r0)
        L_0x00db:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x00dd:
            r0 = r1
            goto L_0x007b
        L_0x00df:
            if (r1 == 0) goto L_0x010a
            java.util.Objects.requireNonNull(r4, r3)
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r4 = (androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode) r4
            int r0 = r23.size()
            if (r2 != 0) goto L_0x00ee
            r1 = 0
            goto L_0x00f2
        L_0x00ee:
            int r1 = r2.hashCode()
        L_0x00f2:
            int r3 = r9 + 5
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r1 = r4.mutableAdd(r1, r2, r3, r11)
            int r2 = r23.size()
            if (r2 != r0) goto L_0x0107
            int r0 = r22.getCount()
            int r0 = r0 + 1
            r10.setCount(r0)
        L_0x0107:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            goto L_0x00dd
        L_0x010a:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r4)
            if (r0 == 0) goto L_0x011e
            int r0 = r22.getCount()
            int r0 = r0 + 1
            r10.setCount(r0)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r0 = r2
            goto L_0x007b
        L_0x011e:
            if (r2 != 0) goto L_0x0122
            r1 = 0
            goto L_0x0127
        L_0x0122:
            int r0 = r2.hashCode()
            r1 = r0
        L_0x0127:
            if (r4 != 0) goto L_0x012b
            r3 = 0
            goto L_0x0130
        L_0x012b:
            int r0 = r4.hashCode()
            r3 = r0
        L_0x0130:
            int r5 = r9 + 5
            androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership r17 = r23.getOwnership$runtime_release()
            r0 = r19
            r18 = r6
            r6 = r17
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r0 = r0.makeNode(r1, r2, r3, r4, r5, r6)
        L_0x0140:
            r16[r15] = r0
            int r15 = r15 + 1
            r14 = r14 ^ r18
            goto L_0x005d
        L_0x0148:
            boolean r0 = r7.elementsIdentityEquals(r12)
            if (r0 == 0) goto L_0x0150
            r12 = r7
            goto L_0x0157
        L_0x0150:
            boolean r0 = r8.elementsIdentityEquals(r12)
            if (r0 == 0) goto L_0x0157
            r12 = r8
        L_0x0157:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableAddAll(androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode, int, androidx.compose.runtime.external.kotlinx.collections.immutable.internal.DeltaCounter, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder):androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode");
    }

    public final Object mutableRetainAll(TrieNode<E> trieNode, int i, DeltaCounter deltaCounter, PersistentHashSetBuilder<?> persistentHashSetBuilder) {
        TrieNode trieNode2;
        TrieNode trieNode3;
        int i2;
        int i3;
        TrieNode<E> trieNode4 = trieNode;
        int i4 = i;
        DeltaCounter deltaCounter2 = deltaCounter;
        PersistentHashSetBuilder<?> persistentHashSetBuilder2 = persistentHashSetBuilder;
        Intrinsics.checkNotNullParameter(trieNode4, "otherNode");
        Intrinsics.checkNotNullParameter(deltaCounter2, "intersectionSizeRef");
        Intrinsics.checkNotNullParameter(persistentHashSetBuilder2, "mutator");
        if (this == trieNode4) {
            deltaCounter2.plusAssign(calculateSize());
            return this;
        } else if (i4 > 30) {
            return mutableCollisionRetainAll(trieNode4, deltaCounter2, persistentHashSetBuilder.getOwnership$runtime_release());
        } else {
            int i5 = this.bitmap & trieNode4.bitmap;
            if (i5 == 0) {
                return EMPTY;
            }
            if (!Intrinsics.areEqual((Object) this.ownedBy, (Object) persistentHashSetBuilder.getOwnership$runtime_release()) || i5 != this.bitmap) {
                trieNode2 = new TrieNode(i5, new Object[Integer.bitCount(i5)], persistentHashSetBuilder.getOwnership$runtime_release());
            } else {
                trieNode2 = this;
            }
            int i6 = i5;
            int i7 = 0;
            int i8 = 0;
            while (i6 != 0) {
                int lowestOneBit = Integer.lowestOneBit(i6);
                int indexOfCellAt$runtime_release = indexOfCellAt$runtime_release(lowestOneBit);
                int indexOfCellAt$runtime_release2 = trieNode4.indexOfCellAt$runtime_release(lowestOneBit);
                Object obj = getBuffer()[indexOfCellAt$runtime_release];
                Object obj2 = trieNode.getBuffer()[indexOfCellAt$runtime_release2];
                boolean z = obj instanceof TrieNode;
                boolean z2 = obj2 instanceof TrieNode;
                if (z && z2) {
                    Objects.requireNonNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableRetainAll$lambda-9$lambda-8>");
                    Objects.requireNonNull(obj2, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableRetainAll$lambda-9$lambda-8>");
                    obj = ((TrieNode) obj).mutableRetainAll((TrieNode) obj2, i4 + 5, deltaCounter2, persistentHashSetBuilder2);
                } else if (z) {
                    Objects.requireNonNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableRetainAll$lambda-9$lambda-8>");
                    TrieNode trieNode5 = (TrieNode) obj;
                    if (obj2 == null) {
                        i3 = 0;
                    } else {
                        i3 = obj2.hashCode();
                    }
                    if (trieNode5.contains(i3, obj2, i4 + 5)) {
                        deltaCounter2.plusAssign(1);
                        obj = obj2;
                    } else {
                        obj = EMPTY;
                    }
                } else if (z2) {
                    Objects.requireNonNull(obj2, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableRetainAll$lambda-9$lambda-8>");
                    TrieNode trieNode6 = (TrieNode) obj2;
                    if (obj == null) {
                        i2 = 0;
                    } else {
                        i2 = obj.hashCode();
                    }
                    if (trieNode6.contains(i2, obj, i4 + 5)) {
                        deltaCounter2.plusAssign(1);
                    } else {
                        obj = EMPTY;
                    }
                } else if (Intrinsics.areEqual(obj, obj2)) {
                    deltaCounter2.plusAssign(1);
                } else {
                    obj = EMPTY;
                }
                if (obj != EMPTY) {
                    i7 |= lowestOneBit;
                }
                trieNode2.getBuffer()[i8] = obj;
                i8++;
                i6 ^= lowestOneBit;
            }
            int bitCount = Integer.bitCount(i7);
            if (i7 == 0) {
                return EMPTY;
            }
            if (i7 != i5) {
                if (bitCount != 1 || i4 == 0) {
                    Object[] objArr = new Object[bitCount];
                    Object[] objArr2 = trieNode2.buffer;
                    int i9 = 0;
                    int i10 = 0;
                    while (i9 < objArr2.length) {
                        CommonFunctionsKt.m1249assert(i10 <= i9);
                        if (objArr2[i9] != Companion.getEMPTY$runtime_release()) {
                            objArr[0 + i10] = objArr2[i9];
                            i10++;
                            CommonFunctionsKt.m1249assert(0 + i10 <= bitCount);
                        }
                        i9++;
                    }
                    trieNode3 = new TrieNode(i7, objArr, persistentHashSetBuilder.getOwnership$runtime_release());
                } else {
                    Object obj3 = trieNode2.buffer[trieNode2.indexOfCellAt$runtime_release(i7)];
                    if (!(obj3 instanceof TrieNode)) {
                        return obj3;
                    }
                    trieNode3 = new TrieNode(i7, new Object[]{obj3}, persistentHashSetBuilder.getOwnership$runtime_release());
                }
                return trieNode3;
            } else if (trieNode2.elementsIdentityEquals(this)) {
                return this;
            } else {
                if (trieNode2.elementsIdentityEquals(trieNode4)) {
                    return trieNode4;
                }
                return trieNode2;
            }
        }
    }

    public final Object mutableRemoveAll(TrieNode<E> trieNode, int i, DeltaCounter deltaCounter, PersistentHashSetBuilder<?> persistentHashSetBuilder) {
        TrieNode trieNode2;
        int i2;
        int i3;
        TrieNode<E> trieNode3 = trieNode;
        int i4 = i;
        DeltaCounter deltaCounter2 = deltaCounter;
        PersistentHashSetBuilder<?> persistentHashSetBuilder2 = persistentHashSetBuilder;
        Intrinsics.checkNotNullParameter(trieNode3, "otherNode");
        Intrinsics.checkNotNullParameter(deltaCounter2, "intersectionSizeRef");
        Intrinsics.checkNotNullParameter(persistentHashSetBuilder2, "mutator");
        if (this == trieNode3) {
            deltaCounter2.plusAssign(calculateSize());
            return EMPTY;
        } else if (i4 > 30) {
            return mutableCollisionRemoveAll(trieNode3, deltaCounter2, persistentHashSetBuilder.getOwnership$runtime_release());
        } else {
            int i5 = this.bitmap & trieNode3.bitmap;
            if (i5 == 0) {
                return this;
            }
            if (Intrinsics.areEqual((Object) this.ownedBy, (Object) persistentHashSetBuilder.getOwnership$runtime_release())) {
                trieNode2 = this;
            } else {
                int i6 = this.bitmap;
                Object[] objArr = this.buffer;
                Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
                trieNode2 = new TrieNode(i6, copyOf, persistentHashSetBuilder.getOwnership$runtime_release());
            }
            int i7 = this.bitmap;
            while (i5 != 0) {
                int lowestOneBit = Integer.lowestOneBit(i5);
                int indexOfCellAt$runtime_release = indexOfCellAt$runtime_release(lowestOneBit);
                int indexOfCellAt$runtime_release2 = trieNode3.indexOfCellAt$runtime_release(lowestOneBit);
                Object obj = getBuffer()[indexOfCellAt$runtime_release];
                Object obj2 = trieNode.getBuffer()[indexOfCellAt$runtime_release2];
                boolean z = obj instanceof TrieNode;
                boolean z2 = obj2 instanceof TrieNode;
                if (z && z2) {
                    Objects.requireNonNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableRemoveAll$lambda-11$lambda-10>");
                    Objects.requireNonNull(obj2, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableRemoveAll$lambda-11$lambda-10>");
                    obj = ((TrieNode) obj).mutableRemoveAll((TrieNode) obj2, i4 + 5, deltaCounter2, persistentHashSetBuilder2);
                } else if (z) {
                    Objects.requireNonNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableRemoveAll$lambda-11$lambda-10>");
                    TrieNode trieNode4 = (TrieNode) obj;
                    int size = persistentHashSetBuilder.size();
                    if (obj2 == null) {
                        i3 = 0;
                    } else {
                        i3 = obj2.hashCode();
                    }
                    TrieNode<?> mutableRemove = trieNode4.mutableRemove(i3, obj2, i4 + 5, persistentHashSetBuilder2);
                    if (size != persistentHashSetBuilder.size()) {
                        deltaCounter2.plusAssign(1);
                        obj = (mutableRemove.getBuffer().length != 1 || (mutableRemove.getBuffer()[0] instanceof TrieNode)) ? mutableRemove : mutableRemove.getBuffer()[0];
                    }
                } else if (z2) {
                    Objects.requireNonNull(obj2, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableRemoveAll$lambda-11$lambda-10>");
                    TrieNode trieNode5 = (TrieNode) obj2;
                    if (obj == null) {
                        i2 = 0;
                    } else {
                        i2 = obj.hashCode();
                    }
                    if (trieNode5.contains(i2, obj, i4 + 5)) {
                        deltaCounter2.plusAssign(1);
                        obj = EMPTY;
                    }
                } else if (Intrinsics.areEqual(obj, obj2)) {
                    deltaCounter2.plusAssign(1);
                    obj = EMPTY;
                }
                if (obj == EMPTY) {
                    i7 ^= lowestOneBit;
                }
                trieNode2.getBuffer()[indexOfCellAt$runtime_release] = obj;
                i5 ^= lowestOneBit;
            }
            int bitCount = Integer.bitCount(i7);
            if (i7 == 0) {
                return EMPTY;
            }
            if (i7 == this.bitmap) {
                if (trieNode2.elementsIdentityEquals(this)) {
                    return this;
                }
                return trieNode2;
            } else if (bitCount != 1 || i4 == 0) {
                Object[] objArr2 = new Object[bitCount];
                Object[] objArr3 = trieNode2.buffer;
                int i8 = 0;
                int i9 = 0;
                while (i9 < objArr3.length) {
                    CommonFunctionsKt.m1249assert(i8 <= i9);
                    if (objArr3[i9] != Companion.getEMPTY$runtime_release()) {
                        objArr2[0 + i8] = objArr3[i9];
                        i8++;
                        CommonFunctionsKt.m1249assert(0 + i8 <= bitCount);
                    }
                    i9++;
                }
                return new TrieNode(i7, objArr2, persistentHashSetBuilder.getOwnership$runtime_release());
            } else {
                Object obj3 = trieNode2.buffer[trieNode2.indexOfCellAt$runtime_release(i7)];
                if (!(obj3 instanceof TrieNode)) {
                    return obj3;
                }
                return new TrieNode(i7, new Object[]{obj3}, persistentHashSetBuilder.getOwnership$runtime_release());
            }
        }
    }

    public final boolean containsAll(TrieNode<E> trieNode, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(trieNode, "otherNode");
        if (this == trieNode) {
            return true;
        }
        if (i > 30) {
            Object[] objArr = trieNode.buffer;
            int length = objArr.length;
            int i3 = 0;
            while (i3 < length) {
                Object obj = objArr[i3];
                i3++;
                if (!ArraysKt.contains((T[]) getBuffer(), obj)) {
                    return false;
                }
            }
            return true;
        }
        int i4 = this.bitmap;
        int i5 = trieNode.bitmap;
        int i6 = i4 & i5;
        if (i6 != i5) {
            return false;
        }
        while (i6 != 0) {
            int lowestOneBit = Integer.lowestOneBit(i6);
            int indexOfCellAt$runtime_release = indexOfCellAt$runtime_release(lowestOneBit);
            int indexOfCellAt$runtime_release2 = trieNode.indexOfCellAt$runtime_release(lowestOneBit);
            Object obj2 = getBuffer()[indexOfCellAt$runtime_release];
            Object obj3 = trieNode.getBuffer()[indexOfCellAt$runtime_release2];
            boolean z = obj2 instanceof TrieNode;
            boolean z2 = obj3 instanceof TrieNode;
            if (z && z2) {
                Objects.requireNonNull(obj2, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.containsAll$lambda-13>");
                Objects.requireNonNull(obj3, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.containsAll$lambda-13>");
                if (!((TrieNode) obj2).containsAll((TrieNode) obj3, i + 5)) {
                    return false;
                }
            } else if (z) {
                Objects.requireNonNull(obj2, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.containsAll$lambda-13>");
                TrieNode trieNode2 = (TrieNode) obj2;
                if (obj3 == null) {
                    i2 = 0;
                } else {
                    i2 = obj3.hashCode();
                }
                if (!trieNode2.contains(i2, obj3, i + 5)) {
                    return false;
                }
            } else if (z2 || !Intrinsics.areEqual(obj2, obj3)) {
                return false;
            }
            i6 ^= lowestOneBit;
        }
        return true;
    }

    public final TrieNode<E> add(int i, E e, int i2) {
        TrieNode trieNode;
        int indexSegment = 1 << TrieNodeKt.indexSegment(i, i2);
        if (hasNoCellAt(indexSegment)) {
            return addElementAt(indexSegment, e);
        }
        int indexOfCellAt$runtime_release = indexOfCellAt$runtime_release(indexSegment);
        Object[] objArr = this.buffer;
        if (objArr[indexOfCellAt$runtime_release] instanceof TrieNode) {
            TrieNode nodeAtIndex = nodeAtIndex(indexOfCellAt$runtime_release);
            if (i2 == 30) {
                trieNode = nodeAtIndex.collisionAdd(e);
            } else {
                trieNode = nodeAtIndex.add(i, e, i2 + 5);
            }
            if (nodeAtIndex == trieNode) {
                return this;
            }
            return updateNodeAtIndex(indexOfCellAt$runtime_release, trieNode);
        } else if (Intrinsics.areEqual((Object) e, objArr[indexOfCellAt$runtime_release])) {
            return this;
        } else {
            return moveElementToNode(indexOfCellAt$runtime_release, i, e, i2);
        }
    }

    public final TrieNode<E> mutableAdd(int i, E e, int i2, PersistentHashSetBuilder<?> persistentHashSetBuilder) {
        TrieNode<?> trieNode;
        Intrinsics.checkNotNullParameter(persistentHashSetBuilder, "mutator");
        int indexSegment = 1 << TrieNodeKt.indexSegment(i, i2);
        if (hasNoCellAt(indexSegment)) {
            persistentHashSetBuilder.setSize(persistentHashSetBuilder.size() + 1);
            return mutableAddElementAt(indexSegment, e, persistentHashSetBuilder.getOwnership$runtime_release());
        }
        int indexOfCellAt$runtime_release = indexOfCellAt$runtime_release(indexSegment);
        Object[] objArr = this.buffer;
        if (objArr[indexOfCellAt$runtime_release] instanceof TrieNode) {
            TrieNode<?> nodeAtIndex = nodeAtIndex(indexOfCellAt$runtime_release);
            if (i2 == 30) {
                trieNode = nodeAtIndex.mutableCollisionAdd(e, persistentHashSetBuilder);
            } else {
                trieNode = nodeAtIndex.mutableAdd(i, e, i2 + 5, persistentHashSetBuilder);
            }
            if (nodeAtIndex == trieNode) {
                return this;
            }
            return mutableUpdateNodeAtIndex(indexOfCellAt$runtime_release, trieNode, persistentHashSetBuilder.getOwnership$runtime_release());
        } else if (Intrinsics.areEqual((Object) e, objArr[indexOfCellAt$runtime_release])) {
            return this;
        } else {
            persistentHashSetBuilder.setSize(persistentHashSetBuilder.size() + 1);
            return mutableMoveElementToNode(indexOfCellAt$runtime_release, i, e, i2, persistentHashSetBuilder.getOwnership$runtime_release());
        }
    }

    public final TrieNode<E> remove(int i, E e, int i2) {
        TrieNode trieNode;
        int indexSegment = 1 << TrieNodeKt.indexSegment(i, i2);
        if (hasNoCellAt(indexSegment)) {
            return this;
        }
        int indexOfCellAt$runtime_release = indexOfCellAt$runtime_release(indexSegment);
        Object[] objArr = this.buffer;
        if (!(objArr[indexOfCellAt$runtime_release] instanceof TrieNode)) {
            return Intrinsics.areEqual((Object) e, objArr[indexOfCellAt$runtime_release]) ? removeCellAtIndex(indexOfCellAt$runtime_release, indexSegment) : this;
        }
        TrieNode nodeAtIndex = nodeAtIndex(indexOfCellAt$runtime_release);
        if (i2 == 30) {
            trieNode = nodeAtIndex.collisionRemove(e);
        } else {
            trieNode = nodeAtIndex.remove(i, e, i2 + 5);
        }
        if (nodeAtIndex == trieNode) {
            return this;
        }
        return updateNodeAtIndex(indexOfCellAt$runtime_release, trieNode);
    }

    public final TrieNode<E> mutableRemove(int i, E e, int i2, PersistentHashSetBuilder<?> persistentHashSetBuilder) {
        TrieNode<?> trieNode;
        Intrinsics.checkNotNullParameter(persistentHashSetBuilder, "mutator");
        int indexSegment = 1 << TrieNodeKt.indexSegment(i, i2);
        if (hasNoCellAt(indexSegment)) {
            return this;
        }
        int indexOfCellAt$runtime_release = indexOfCellAt$runtime_release(indexSegment);
        Object[] objArr = this.buffer;
        if (objArr[indexOfCellAt$runtime_release] instanceof TrieNode) {
            TrieNode<?> nodeAtIndex = nodeAtIndex(indexOfCellAt$runtime_release);
            if (i2 == 30) {
                trieNode = nodeAtIndex.mutableCollisionRemove(e, persistentHashSetBuilder);
            } else {
                trieNode = nodeAtIndex.mutableRemove(i, e, i2 + 5, persistentHashSetBuilder);
            }
            if (this.ownedBy == persistentHashSetBuilder.getOwnership$runtime_release() || nodeAtIndex != trieNode) {
                return mutableUpdateNodeAtIndex(indexOfCellAt$runtime_release, trieNode, persistentHashSetBuilder.getOwnership$runtime_release());
            }
            return this;
        } else if (!Intrinsics.areEqual((Object) e, objArr[indexOfCellAt$runtime_release])) {
            return this;
        } else {
            persistentHashSetBuilder.setSize(persistentHashSetBuilder.size() - 1);
            return mutableRemoveCellAtIndex(indexOfCellAt$runtime_release, indexSegment, persistentHashSetBuilder.getOwnership$runtime_release());
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode$Companion;", "", "()V", "EMPTY", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "", "getEMPTY$runtime_release", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TrieNode.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TrieNode getEMPTY$runtime_release() {
            return TrieNode.EMPTY;
        }
    }
}
