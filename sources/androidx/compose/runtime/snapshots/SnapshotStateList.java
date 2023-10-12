package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.runtime.snapshots.StateObject;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableList;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003:\u0001MB\u0005¢\u0006\u0002\u0010\u0004J\u0015\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001dJ\u001d\u0010\u001a\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010 J\u001e\u0010!\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u00102\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J\u0016\u0010!\u001a\u00020\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J\b\u0010$\u001a\u00020\u001eH\u0016J)\u0010%\u001a\u00020\u001b2\u001e\u0010&\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000(\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000(0'H\bJ\u0016\u0010)\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001dJ\u0016\u0010*\u001a\u00020\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J\u0016\u0010+\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\u0010H\u0002¢\u0006\u0002\u0010,J\u0015\u0010-\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010.J\b\u0010/\u001a\u00020\u001bH\u0016J\u000f\u00100\u001a\b\u0012\u0004\u0012\u00028\u000001H\u0002J\u0015\u00102\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010.J\u000e\u00103\u001a\b\u0012\u0004\u0012\u00028\u000004H\u0016J\u0016\u00103\u001a\b\u0012\u0004\u0012\u00028\u0000042\u0006\u0010\u001f\u001a\u00020\u0010H\u0016J.\u00105\u001a\u0002H6\"\u0004\b\u0001\u001062\u0018\u0010&\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u0002H60'H\b¢\u0006\u0002\u00107J\"\u00108\u001a\u00020\u001b2\u0018\u0010&\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00020\u001b0'H\u0002J\u0010\u00109\u001a\u00020\u001e2\u0006\u0010:\u001a\u00020\u000bH\u0016J\u0015\u0010;\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001dJ\u0016\u0010<\u001a\u00020\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J\u0015\u0010=\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\u0010H\u0016¢\u0006\u0002\u0010,J\u0016\u0010>\u001a\u00020\u001e2\u0006\u0010?\u001a\u00020\u00102\u0006\u0010@\u001a\u00020\u0010J\u0016\u0010A\u001a\u00020\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J+\u0010B\u001a\u00020\u00102\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#2\u0006\u0010C\u001a\u00020\u00102\u0006\u0010D\u001a\u00020\u0010H\u0000¢\u0006\u0002\bEJ\u001e\u0010F\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010GJ\u001e\u0010H\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010?\u001a\u00020\u00102\u0006\u0010@\u001a\u00020\u0010H\u0016J)\u0010I\u001a\u00020\u001e2\u001e\u0010&\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000(\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000(0'H\bJ3\u0010J\u001a\u0002H6\"\u0004\b\u0001\u001062\u001d\u0010&\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0014\u0012\u0004\u0012\u0002H60'¢\u0006\u0002\bKH\b¢\u0006\u0002\u00107J3\u0010L\u001a\u0002H6\"\u0004\b\u0001\u001062\u001d\u0010&\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0014\u0012\u0004\u0012\u0002H60'¢\u0006\u0002\bKH\b¢\u0006\u0002\u00107R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068AX\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\tR\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108@X\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00148@X\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0012¨\u0006N"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateList;", "T", "", "Landroidx/compose/runtime/snapshots/StateObject;", "()V", "debuggerDisplayValue", "", "getDebuggerDisplayValue$annotations", "getDebuggerDisplayValue", "()Ljava/util/List;", "<set-?>", "Landroidx/compose/runtime/snapshots/StateRecord;", "firstStateRecord", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "modification", "", "getModification$runtime_release", "()I", "readable", "Landroidx/compose/runtime/snapshots/SnapshotStateList$StateListStateRecord;", "getReadable$runtime_release$annotations", "getReadable$runtime_release", "()Landroidx/compose/runtime/snapshots/SnapshotStateList$StateListStateRecord;", "size", "getSize", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "clear", "conditionalUpdate", "block", "Lkotlin/Function1;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "contains", "containsAll", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "mutate", "R", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "mutateBoolean", "prependStateRecord", "value", "remove", "removeAll", "removeAt", "removeRange", "fromIndex", "toIndex", "retainAll", "retainAllInRange", "start", "end", "retainAllInRange$runtime_release", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "update", "withCurrent", "Lkotlin/ExtensionFunctionType;", "writable", "StateListStateRecord", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SnapshotStateList.kt */
public final class SnapshotStateList<T> implements List<T>, StateObject, KMutableList {
    private StateRecord firstStateRecord = new StateListStateRecord(ExtensionsKt.persistentListOf());

    public static /* synthetic */ void getDebuggerDisplayValue$annotations() {
    }

    public static /* synthetic */ void getReadable$runtime_release$annotations() {
    }

    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    public <T> T[] toArray(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "array");
        return CollectionToArray.toArray(this, tArr);
    }

    public StateRecord mergeRecords(StateRecord stateRecord, StateRecord stateRecord2, StateRecord stateRecord3) {
        return StateObject.DefaultImpls.mergeRecords(this, stateRecord, stateRecord2, stateRecord3);
    }

    public final /* bridge */ T remove(int i) {
        return removeAt(i);
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    public StateRecord getFirstStateRecord() {
        return this.firstStateRecord;
    }

    public void prependStateRecord(StateRecord stateRecord) {
        Intrinsics.checkNotNullParameter(stateRecord, "value");
        stateRecord.setNext$runtime_release(getFirstStateRecord());
        this.firstStateRecord = (StateListStateRecord) stateRecord;
    }

    public final StateListStateRecord<T> getReadable$runtime_release() {
        return (StateListStateRecord) SnapshotKt.readable((StateListStateRecord) getFirstStateRecord(), this);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\u0015\b\u0000\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateList$StateListStateRecord;", "T", "Landroidx/compose/runtime/snapshots/StateRecord;", "list", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;)V", "getList$runtime_release", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "setList$runtime_release", "modification", "", "getModification$runtime_release", "()I", "setModification$runtime_release", "(I)V", "assign", "", "value", "create", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SnapshotStateList.kt */
    public static final class StateListStateRecord<T> extends StateRecord {
        private PersistentList<? extends T> list;
        private int modification;

        public final PersistentList<T> getList$runtime_release() {
            return this.list;
        }

        public final void setList$runtime_release(PersistentList<? extends T> persistentList) {
            Intrinsics.checkNotNullParameter(persistentList, "<set-?>");
            this.list = persistentList;
        }

        public StateListStateRecord(PersistentList<? extends T> persistentList) {
            Intrinsics.checkNotNullParameter(persistentList, "list");
            this.list = persistentList;
        }

        public final int getModification$runtime_release() {
            return this.modification;
        }

        public final void setModification$runtime_release(int i) {
            this.modification = i;
        }

        public void assign(StateRecord stateRecord) {
            Intrinsics.checkNotNullParameter(stateRecord, "value");
            synchronized (SnapshotStateListKt.sync) {
                setList$runtime_release(((StateListStateRecord) stateRecord).getList$runtime_release());
                setModification$runtime_release(((StateListStateRecord) stateRecord).getModification$runtime_release());
                Unit unit = Unit.INSTANCE;
            }
        }

        public StateRecord create() {
            return new StateListStateRecord(this.list);
        }
    }

    public int getSize() {
        return getReadable$runtime_release().getList$runtime_release().size();
    }

    public boolean contains(Object obj) {
        return getReadable$runtime_release().getList$runtime_release().contains(obj);
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return getReadable$runtime_release().getList$runtime_release().containsAll(collection);
    }

    public T get(int i) {
        return getReadable$runtime_release().getList$runtime_release().get(i);
    }

    public int indexOf(Object obj) {
        return getReadable$runtime_release().getList$runtime_release().indexOf(obj);
    }

    public boolean isEmpty() {
        return getReadable$runtime_release().getList$runtime_release().isEmpty();
    }

    public Iterator<T> iterator() {
        return listIterator();
    }

    public int lastIndexOf(Object obj) {
        return getReadable$runtime_release().getList$runtime_release().lastIndexOf(obj);
    }

    public ListIterator<T> listIterator() {
        return new StateListIterator<>(this, 0);
    }

    public ListIterator<T> listIterator(int i) {
        return new StateListIterator<>(this, i);
    }

    public List<T> subList(int i, int i2) {
        boolean z = true;
        if (!(i >= 0 && i <= i2) || i2 > size()) {
            z = false;
        }
        if (z) {
            return new SubList<>(this, i, i2);
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public boolean addAll(int i, Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return mutateBoolean(new SnapshotStateList$addAll$1(i, collection));
    }

    public void clear() {
        Snapshot current;
        synchronized (SnapshotStateListKt.sync) {
            StateRecord stateRecord = (StateListStateRecord) getFirstStateRecord();
            SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                current = Snapshot.Companion.getCurrent();
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.writableRecord(stateRecord, this, current);
                stateListStateRecord.setList$runtime_release(ExtensionsKt.persistentListOf());
                stateListStateRecord.setModification$runtime_release(stateListStateRecord.getModification$runtime_release() + 1);
            }
            SnapshotKt.notifyWrite(current, this);
        }
    }

    public T removeAt(int i) {
        int modification$runtime_release;
        PersistentList list$runtime_release;
        Snapshot current;
        boolean z;
        T t = get(i);
        SnapshotStateList snapshotStateList = this;
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) snapshotStateList.getFirstStateRecord(), Snapshot.Companion.getCurrent());
                modification$runtime_release = stateListStateRecord.getModification$runtime_release();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList removeAt = list$runtime_release.removeAt(i);
            if (Intrinsics.areEqual((Object) removeAt, (Object) list$runtime_release)) {
                break;
            }
            synchronized (SnapshotStateListKt.sync) {
                StateRecord stateRecord = (StateListStateRecord) snapshotStateList.getFirstStateRecord();
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = Snapshot.Companion.getCurrent();
                    StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.writableRecord(stateRecord, snapshotStateList, current);
                    z = true;
                    if (stateListStateRecord2.getModification$runtime_release() == modification$runtime_release) {
                        stateListStateRecord2.setList$runtime_release(removeAt);
                        stateListStateRecord2.setModification$runtime_release(stateListStateRecord2.getModification$runtime_release() + 1);
                    } else {
                        z = false;
                    }
                }
                SnapshotKt.notifyWrite(current, snapshotStateList);
            }
        } while (!z);
        return t;
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return mutateBoolean(new SnapshotStateList$retainAll$1(collection));
    }

    public T set(int i, T t) {
        int modification$runtime_release;
        PersistentList list$runtime_release;
        Snapshot current;
        boolean z;
        T t2 = get(i);
        SnapshotStateList snapshotStateList = this;
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) snapshotStateList.getFirstStateRecord(), Snapshot.Companion.getCurrent());
                modification$runtime_release = stateListStateRecord.getModification$runtime_release();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList persistentList = list$runtime_release.set(i, t);
            if (Intrinsics.areEqual((Object) persistentList, (Object) list$runtime_release)) {
                break;
            }
            synchronized (SnapshotStateListKt.sync) {
                StateRecord stateRecord = (StateListStateRecord) snapshotStateList.getFirstStateRecord();
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = Snapshot.Companion.getCurrent();
                    StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.writableRecord(stateRecord, snapshotStateList, current);
                    z = true;
                    if (stateListStateRecord2.getModification$runtime_release() == modification$runtime_release) {
                        stateListStateRecord2.setList$runtime_release(persistentList);
                        stateListStateRecord2.setModification$runtime_release(stateListStateRecord2.getModification$runtime_release() + 1);
                    } else {
                        z = false;
                    }
                }
                SnapshotKt.notifyWrite(current, snapshotStateList);
            }
        } while (!z);
        return t2;
    }

    public final int retainAllInRange$runtime_release(Collection<? extends T> collection, int i, int i2) {
        int modification$runtime_release;
        PersistentList list$runtime_release;
        Snapshot current;
        boolean z;
        Intrinsics.checkNotNullParameter(collection, "elements");
        int size = size();
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) getFirstStateRecord(), Snapshot.Companion.getCurrent());
                modification$runtime_release = stateListStateRecord.getModification$runtime_release();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList.Builder builder = list$runtime_release.builder();
            builder.subList(i, i2).retainAll(collection);
            Unit unit2 = Unit.INSTANCE;
            PersistentList build = builder.build();
            if (Intrinsics.areEqual((Object) build, (Object) list$runtime_release)) {
                break;
            }
            synchronized (SnapshotStateListKt.sync) {
                StateRecord stateRecord = (StateListStateRecord) getFirstStateRecord();
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = Snapshot.Companion.getCurrent();
                    StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.writableRecord(stateRecord, this, current);
                    z = true;
                    if (stateListStateRecord2.getModification$runtime_release() == modification$runtime_release) {
                        stateListStateRecord2.setList$runtime_release(build);
                        stateListStateRecord2.setModification$runtime_release(stateListStateRecord2.getModification$runtime_release() + 1);
                    } else {
                        z = false;
                    }
                }
                SnapshotKt.notifyWrite(current, this);
            }
        } while (!z);
        return size - size();
    }

    private final <R> R writable(Function1<? super StateListStateRecord<T>, ? extends R> function1) {
        Snapshot current;
        R invoke;
        StateRecord stateRecord = (StateListStateRecord) getFirstStateRecord();
        SnapshotKt.getSnapshotInitializer();
        synchronized (SnapshotKt.getLock()) {
            try {
                current = Snapshot.Companion.getCurrent();
                invoke = function1.invoke(SnapshotKt.writableRecord(stateRecord, this, current));
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
        SnapshotKt.notifyWrite(current, this);
        return invoke;
    }

    private final <R> R withCurrent(Function1<? super StateListStateRecord<T>, ? extends R> function1) {
        return function1.invoke(SnapshotKt.current((StateListStateRecord) getFirstStateRecord(), Snapshot.Companion.getCurrent()));
    }

    private final <R> R mutate(Function1<? super List<T>, ? extends R> function1) {
        int modification$runtime_release;
        PersistentList list$runtime_release;
        R invoke;
        Snapshot current;
        boolean z;
        do {
            synchronized (SnapshotStateListKt.sync) {
                try {
                    StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) getFirstStateRecord(), Snapshot.Companion.getCurrent());
                    modification$runtime_release = stateListStateRecord.getModification$runtime_release();
                    list$runtime_release = stateListStateRecord.getList$runtime_release();
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                } finally {
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                }
            }
            InlineMarker.finallyEnd(1);
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList.Builder builder = list$runtime_release.builder();
            invoke = function1.invoke(builder);
            PersistentList build = builder.build();
            if (Intrinsics.areEqual((Object) build, (Object) list$runtime_release)) {
                break;
            }
            synchronized (SnapshotStateListKt.sync) {
                try {
                    StateRecord stateRecord = (StateListStateRecord) getFirstStateRecord();
                    SnapshotKt.getSnapshotInitializer();
                    synchronized (SnapshotKt.getLock()) {
                        current = Snapshot.Companion.getCurrent();
                        StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.writableRecord(stateRecord, this, current);
                        if (stateListStateRecord2.getModification$runtime_release() == modification$runtime_release) {
                            stateListStateRecord2.setList$runtime_release(build);
                            stateListStateRecord2.setModification$runtime_release(stateListStateRecord2.getModification$runtime_release() + 1);
                            z = true;
                        } else {
                            z = false;
                        }
                        InlineMarker.finallyStart(1);
                    }
                    InlineMarker.finallyEnd(1);
                    SnapshotKt.notifyWrite(current, this);
                    InlineMarker.finallyStart(1);
                } catch (Throwable th) {
                    throw th;
                }
            }
            InlineMarker.finallyEnd(1);
        } while (!z);
        return invoke;
    }

    private final boolean conditionalUpdate(Function1<? super PersistentList<? extends T>, ? extends PersistentList<? extends T>> function1) {
        int modification$runtime_release;
        PersistentList list$runtime_release;
        boolean z;
        Snapshot current;
        SnapshotStateList snapshotStateList = this;
        do {
            synchronized (SnapshotStateListKt.sync) {
                try {
                    StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) snapshotStateList.getFirstStateRecord(), Snapshot.Companion.getCurrent());
                    modification$runtime_release = stateListStateRecord.getModification$runtime_release();
                    list$runtime_release = stateListStateRecord.getList$runtime_release();
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                } finally {
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                }
            }
            InlineMarker.finallyEnd(1);
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList persistentList = (PersistentList) function1.invoke(list$runtime_release);
            z = false;
            if (Intrinsics.areEqual((Object) persistentList, (Object) list$runtime_release)) {
                return false;
            }
            synchronized (SnapshotStateListKt.sync) {
                try {
                    StateRecord stateRecord = (StateListStateRecord) snapshotStateList.getFirstStateRecord();
                    SnapshotKt.getSnapshotInitializer();
                    synchronized (SnapshotKt.getLock()) {
                        current = Snapshot.Companion.getCurrent();
                        StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.writableRecord(stateRecord, snapshotStateList, current);
                        if (stateListStateRecord2.getModification$runtime_release() == modification$runtime_release) {
                            stateListStateRecord2.setList$runtime_release(persistentList);
                            stateListStateRecord2.setModification$runtime_release(stateListStateRecord2.getModification$runtime_release() + 1);
                            z = true;
                        }
                        InlineMarker.finallyStart(1);
                    }
                    InlineMarker.finallyEnd(1);
                    SnapshotKt.notifyWrite(current, snapshotStateList);
                    InlineMarker.finallyStart(1);
                } catch (Throwable th) {
                    throw th;
                }
            }
            InlineMarker.finallyEnd(1);
        } while (!z);
        return true;
    }

    public final int getModification$runtime_release() {
        return ((StateListStateRecord) SnapshotKt.current((StateListStateRecord) getFirstStateRecord(), Snapshot.Companion.getCurrent())).getModification$runtime_release();
    }

    public boolean add(T t) {
        int modification$runtime_release;
        PersistentList list$runtime_release;
        boolean z;
        Snapshot current;
        SnapshotStateList snapshotStateList = this;
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) snapshotStateList.getFirstStateRecord(), Snapshot.Companion.getCurrent());
                modification$runtime_release = stateListStateRecord.getModification$runtime_release();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList add = list$runtime_release.add(t);
            z = false;
            if (Intrinsics.areEqual((Object) add, (Object) list$runtime_release)) {
                return false;
            }
            synchronized (SnapshotStateListKt.sync) {
                StateRecord stateRecord = (StateListStateRecord) snapshotStateList.getFirstStateRecord();
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = Snapshot.Companion.getCurrent();
                    StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.writableRecord(stateRecord, snapshotStateList, current);
                    if (stateListStateRecord2.getModification$runtime_release() == modification$runtime_release) {
                        stateListStateRecord2.setList$runtime_release(add);
                        stateListStateRecord2.setModification$runtime_release(stateListStateRecord2.getModification$runtime_release() + 1);
                        z = true;
                    }
                }
                SnapshotKt.notifyWrite(current, snapshotStateList);
            }
        } while (!z);
        return true;
    }

    public void add(int i, T t) {
        int modification$runtime_release;
        PersistentList list$runtime_release;
        Snapshot current;
        boolean z;
        SnapshotStateList snapshotStateList = this;
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) snapshotStateList.getFirstStateRecord(), Snapshot.Companion.getCurrent());
                modification$runtime_release = stateListStateRecord.getModification$runtime_release();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList add = list$runtime_release.add(i, t);
            if (!Intrinsics.areEqual((Object) add, (Object) list$runtime_release)) {
                synchronized (SnapshotStateListKt.sync) {
                    StateRecord stateRecord = (StateListStateRecord) snapshotStateList.getFirstStateRecord();
                    SnapshotKt.getSnapshotInitializer();
                    synchronized (SnapshotKt.getLock()) {
                        current = Snapshot.Companion.getCurrent();
                        StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.writableRecord(stateRecord, snapshotStateList, current);
                        z = true;
                        if (stateListStateRecord2.getModification$runtime_release() == modification$runtime_release) {
                            stateListStateRecord2.setList$runtime_release(add);
                            stateListStateRecord2.setModification$runtime_release(stateListStateRecord2.getModification$runtime_release() + 1);
                        } else {
                            z = false;
                        }
                    }
                    SnapshotKt.notifyWrite(current, snapshotStateList);
                }
            } else {
                return;
            }
        } while (!z);
    }

    public boolean addAll(Collection<? extends T> collection) {
        int modification$runtime_release;
        PersistentList list$runtime_release;
        boolean z;
        Snapshot current;
        Intrinsics.checkNotNullParameter(collection, "elements");
        SnapshotStateList snapshotStateList = this;
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) snapshotStateList.getFirstStateRecord(), Snapshot.Companion.getCurrent());
                modification$runtime_release = stateListStateRecord.getModification$runtime_release();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList<? extends T> addAll = list$runtime_release.addAll(collection);
            z = false;
            if (Intrinsics.areEqual((Object) addAll, (Object) list$runtime_release)) {
                return false;
            }
            synchronized (SnapshotStateListKt.sync) {
                StateRecord stateRecord = (StateListStateRecord) snapshotStateList.getFirstStateRecord();
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = Snapshot.Companion.getCurrent();
                    StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.writableRecord(stateRecord, snapshotStateList, current);
                    if (stateListStateRecord2.getModification$runtime_release() == modification$runtime_release) {
                        stateListStateRecord2.setList$runtime_release(addAll);
                        stateListStateRecord2.setModification$runtime_release(stateListStateRecord2.getModification$runtime_release() + 1);
                        z = true;
                    }
                }
                SnapshotKt.notifyWrite(current, snapshotStateList);
            }
        } while (!z);
        return true;
    }

    public boolean remove(Object obj) {
        int modification$runtime_release;
        PersistentList list$runtime_release;
        boolean z;
        Snapshot current;
        SnapshotStateList snapshotStateList = this;
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) snapshotStateList.getFirstStateRecord(), Snapshot.Companion.getCurrent());
                modification$runtime_release = stateListStateRecord.getModification$runtime_release();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList remove = list$runtime_release.remove(obj);
            z = false;
            if (Intrinsics.areEqual((Object) remove, (Object) list$runtime_release)) {
                return false;
            }
            synchronized (SnapshotStateListKt.sync) {
                StateRecord stateRecord = (StateListStateRecord) snapshotStateList.getFirstStateRecord();
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = Snapshot.Companion.getCurrent();
                    StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.writableRecord(stateRecord, snapshotStateList, current);
                    if (stateListStateRecord2.getModification$runtime_release() == modification$runtime_release) {
                        stateListStateRecord2.setList$runtime_release(remove);
                        stateListStateRecord2.setModification$runtime_release(stateListStateRecord2.getModification$runtime_release() + 1);
                        z = true;
                    }
                }
                SnapshotKt.notifyWrite(current, snapshotStateList);
            }
        } while (!z);
        return true;
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        int modification$runtime_release;
        PersistentList list$runtime_release;
        boolean z;
        Snapshot current;
        Intrinsics.checkNotNullParameter(collection, "elements");
        SnapshotStateList snapshotStateList = this;
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) snapshotStateList.getFirstStateRecord(), Snapshot.Companion.getCurrent());
                modification$runtime_release = stateListStateRecord.getModification$runtime_release();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList<? extends Object> removeAll = list$runtime_release.removeAll(collection);
            z = false;
            if (Intrinsics.areEqual((Object) removeAll, (Object) list$runtime_release)) {
                return false;
            }
            synchronized (SnapshotStateListKt.sync) {
                StateRecord stateRecord = (StateListStateRecord) snapshotStateList.getFirstStateRecord();
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = Snapshot.Companion.getCurrent();
                    StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.writableRecord(stateRecord, snapshotStateList, current);
                    if (stateListStateRecord2.getModification$runtime_release() == modification$runtime_release) {
                        stateListStateRecord2.setList$runtime_release(removeAll);
                        stateListStateRecord2.setModification$runtime_release(stateListStateRecord2.getModification$runtime_release() + 1);
                        z = true;
                    }
                }
                SnapshotKt.notifyWrite(current, snapshotStateList);
            }
        } while (!z);
        return true;
    }

    public final void removeRange(int i, int i2) {
        int modification$runtime_release;
        PersistentList list$runtime_release;
        Snapshot current;
        boolean z;
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) getFirstStateRecord(), Snapshot.Companion.getCurrent());
                modification$runtime_release = stateListStateRecord.getModification$runtime_release();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList.Builder builder = list$runtime_release.builder();
            builder.subList(i, i2).clear();
            Unit unit2 = Unit.INSTANCE;
            PersistentList build = builder.build();
            if (!Intrinsics.areEqual((Object) build, (Object) list$runtime_release)) {
                synchronized (SnapshotStateListKt.sync) {
                    StateRecord stateRecord = (StateListStateRecord) getFirstStateRecord();
                    SnapshotKt.getSnapshotInitializer();
                    synchronized (SnapshotKt.getLock()) {
                        current = Snapshot.Companion.getCurrent();
                        StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.writableRecord(stateRecord, this, current);
                        z = true;
                        if (stateListStateRecord2.getModification$runtime_release() == modification$runtime_release) {
                            stateListStateRecord2.setList$runtime_release(build);
                            stateListStateRecord2.setModification$runtime_release(stateListStateRecord2.getModification$runtime_release() + 1);
                        } else {
                            z = false;
                        }
                    }
                    SnapshotKt.notifyWrite(current, this);
                }
            } else {
                return;
            }
        } while (!z);
    }

    public final List<T> getDebuggerDisplayValue() {
        return ((StateListStateRecord) SnapshotKt.current((StateListStateRecord) getFirstStateRecord(), Snapshot.Companion.getCurrent())).getList$runtime_release();
    }

    private final boolean mutateBoolean(Function1<? super List<T>, Boolean> function1) {
        int modification$runtime_release;
        PersistentList list$runtime_release;
        Boolean invoke;
        Snapshot current;
        boolean z;
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) getFirstStateRecord(), Snapshot.Companion.getCurrent());
                modification$runtime_release = stateListStateRecord.getModification$runtime_release();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList.Builder builder = list$runtime_release.builder();
            invoke = function1.invoke(builder);
            PersistentList build = builder.build();
            if (Intrinsics.areEqual((Object) build, (Object) list$runtime_release)) {
                break;
            }
            synchronized (SnapshotStateListKt.sync) {
                StateRecord stateRecord = (StateListStateRecord) getFirstStateRecord();
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = Snapshot.Companion.getCurrent();
                    StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.writableRecord(stateRecord, this, current);
                    z = true;
                    if (stateListStateRecord2.getModification$runtime_release() == modification$runtime_release) {
                        stateListStateRecord2.setList$runtime_release(build);
                        stateListStateRecord2.setModification$runtime_release(stateListStateRecord2.getModification$runtime_release() + 1);
                    } else {
                        z = false;
                    }
                }
                SnapshotKt.notifyWrite(current, this);
            }
        } while (!z);
        return invoke.booleanValue();
    }

    private final void update(Function1<? super PersistentList<? extends T>, ? extends PersistentList<? extends T>> function1) {
        int modification$runtime_release;
        PersistentList list$runtime_release;
        Snapshot current;
        boolean z;
        SnapshotStateList snapshotStateList = this;
        do {
            synchronized (SnapshotStateListKt.sync) {
                try {
                    StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) snapshotStateList.getFirstStateRecord(), Snapshot.Companion.getCurrent());
                    modification$runtime_release = stateListStateRecord.getModification$runtime_release();
                    list$runtime_release = stateListStateRecord.getList$runtime_release();
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                } finally {
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                }
            }
            InlineMarker.finallyEnd(1);
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList persistentList = (PersistentList) function1.invoke(list$runtime_release);
            if (!Intrinsics.areEqual((Object) persistentList, (Object) list$runtime_release)) {
                synchronized (SnapshotStateListKt.sync) {
                    try {
                        StateRecord stateRecord = (StateListStateRecord) snapshotStateList.getFirstStateRecord();
                        SnapshotKt.getSnapshotInitializer();
                        synchronized (SnapshotKt.getLock()) {
                            current = Snapshot.Companion.getCurrent();
                            StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.writableRecord(stateRecord, snapshotStateList, current);
                            if (stateListStateRecord2.getModification$runtime_release() == modification$runtime_release) {
                                stateListStateRecord2.setList$runtime_release(persistentList);
                                stateListStateRecord2.setModification$runtime_release(stateListStateRecord2.getModification$runtime_release() + 1);
                                z = true;
                            } else {
                                z = false;
                            }
                            InlineMarker.finallyStart(1);
                        }
                        InlineMarker.finallyEnd(1);
                        SnapshotKt.notifyWrite(current, snapshotStateList);
                        InlineMarker.finallyStart(1);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                InlineMarker.finallyEnd(1);
            } else {
                return;
            }
        } while (!z);
    }
}
