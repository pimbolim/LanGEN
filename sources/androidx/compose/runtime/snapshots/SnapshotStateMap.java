package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u00020\u0004:\u0001KB\u0005¢\u0006\u0002\u0010\u0005J1\u0010&\u001a\u00020'2\u001e\u0010(\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010*\u0012\u0004\u0012\u00020'0)H\bø\u0001\u0000¢\u0006\u0002\b+J1\u0010,\u001a\u00020'2\u001e\u0010(\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010*\u0012\u0004\u0012\u00020'0)H\bø\u0001\u0000¢\u0006\u0002\b-J\b\u0010.\u001a\u00020/H\u0016J\u0015\u00100\u001a\u00020'2\u0006\u00101\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00102J\u0015\u00103\u001a\u00020'2\u0006\u00104\u001a\u00028\u0001H\u0016¢\u0006\u0002\u00102J\u0018\u00105\u001a\u0004\u0018\u00018\u00012\u0006\u00101\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00106J\b\u00107\u001a\u00020'H\u0016J4\u00108\u001a\u0002H9\"\u0004\b\u0002\u001092\u001e\u0010:\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003\u0012\u0004\u0012\u0002H90)H\b¢\u0006\u0002\u0010;J\u0010\u0010<\u001a\u00020/2\u0006\u00104\u001a\u00020\u0011H\u0016J\u001f\u0010=\u001a\u0004\u0018\u00018\u00012\u0006\u00101\u001a\u00028\u00002\u0006\u00104\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010>J\u001e\u0010?\u001a\u00020/2\u0014\u0010@\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007H\u0016J\u0017\u0010A\u001a\u0004\u0018\u00018\u00012\u0006\u00101\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00106J1\u0010B\u001a\u00020'2\u001e\u0010(\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r\u0012\u0004\u0012\u00020'0)H\bø\u0001\u0000¢\u0006\u0002\bCJ\u0017\u0010D\u001a\u00020'2\u0006\u00104\u001a\u00028\u0001H\u0000¢\u0006\u0004\bE\u00102J5\u0010F\u001a\u00020/2*\u0010:\u001a&\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010G\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010G0)H\bJ9\u0010H\u001a\u0002H9\"\u0004\b\u0002\u001092#\u0010:\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001c\u0012\u0004\u0012\u0002H90)¢\u0006\u0002\bIH\b¢\u0006\u0002\u0010;J9\u0010J\u001a\u0002H9\"\u0004\b\u0002\u001092#\u0010:\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001c\u0012\u0004\u0012\u0002H90)¢\u0006\u0002\bIH\b¢\u0006\u0002\u0010;R&\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00078AX\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\nR&\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r0\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0014\u0010\u0017\u001a\u00020\u00188@X\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR&\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001c8@X\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0005\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u00188VX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u001aR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00010#X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%\u0002\u0007\n\u0005\b20\u0001¨\u0006L"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "K", "V", "", "Landroidx/compose/runtime/snapshots/StateObject;", "()V", "debuggerDisplayValue", "", "getDebuggerDisplayValue$annotations", "getDebuggerDisplayValue", "()Ljava/util/Map;", "entries", "", "", "getEntries", "()Ljava/util/Set;", "<set-?>", "Landroidx/compose/runtime/snapshots/StateRecord;", "firstStateRecord", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "keys", "getKeys", "modification", "", "getModification$runtime_release", "()I", "readable", "Landroidx/compose/runtime/snapshots/SnapshotStateMap$StateMapStateRecord;", "getReadable$runtime_release$annotations", "getReadable$runtime_release", "()Landroidx/compose/runtime/snapshots/SnapshotStateMap$StateMapStateRecord;", "size", "getSize", "values", "", "getValues", "()Ljava/util/Collection;", "all", "", "predicate", "Lkotlin/Function1;", "", "all$runtime_release", "any", "any$runtime_release", "clear", "", "containsKey", "key", "(Ljava/lang/Object;)Z", "containsValue", "value", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "isEmpty", "mutate", "R", "block", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "prependStateRecord", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putAll", "from", "remove", "removeIf", "removeIf$runtime_release", "removeValue", "removeValue$runtime_release", "update", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "withCurrent", "Lkotlin/ExtensionFunctionType;", "writable", "StateMapStateRecord", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SnapshotStateMap.kt */
public final class SnapshotStateMap<K, V> implements Map<K, V>, StateObject, KMutableMap {
    private final Set<Map.Entry<K, V>> entries = new SnapshotMapEntrySet(this);
    private StateRecord firstStateRecord = new StateMapStateRecord(ExtensionsKt.persistentHashMapOf());
    private final Set<K> keys = new SnapshotMapKeySet(this);
    private final Collection<V> values = new SnapshotMapValueSet(this);

    public static /* synthetic */ void getDebuggerDisplayValue$annotations() {
    }

    public static /* synthetic */ void getReadable$runtime_release$annotations() {
    }

    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    public final /* bridge */ Set<K> keySet() {
        return getKeys();
    }

    public StateRecord mergeRecords(StateRecord stateRecord, StateRecord stateRecord2, StateRecord stateRecord3) {
        return StateObject.DefaultImpls.mergeRecords(this, stateRecord, stateRecord2, stateRecord3);
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    public final /* bridge */ Collection<V> values() {
        return getValues();
    }

    public StateRecord getFirstStateRecord() {
        return this.firstStateRecord;
    }

    public void prependStateRecord(StateRecord stateRecord) {
        Intrinsics.checkNotNullParameter(stateRecord, "value");
        this.firstStateRecord = (StateMapStateRecord) stateRecord;
    }

    public int getSize() {
        return getReadable$runtime_release().getMap$runtime_release().size();
    }

    public boolean containsKey(Object obj) {
        return getReadable$runtime_release().getMap$runtime_release().containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return getReadable$runtime_release().getMap$runtime_release().containsValue(obj);
    }

    public V get(Object obj) {
        return getReadable$runtime_release().getMap$runtime_release().get(obj);
    }

    public boolean isEmpty() {
        return getReadable$runtime_release().getMap$runtime_release().isEmpty();
    }

    public Set<Map.Entry<K, V>> getEntries() {
        return this.entries;
    }

    public Set<K> getKeys() {
        return this.keys;
    }

    public Collection<V> getValues() {
        return this.values;
    }

    public final int getModification$runtime_release() {
        return getReadable$runtime_release().getModification$runtime_release();
    }

    public final boolean removeValue$runtime_release(V v) {
        Object obj;
        Iterator it = entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((Map.Entry) obj).getValue(), (Object) v)) {
                break;
            }
        }
        Map.Entry entry = (Map.Entry) obj;
        if (entry == null) {
            return false;
        }
        remove(entry.getKey());
        return true;
    }

    public final StateMapStateRecord<K, V> getReadable$runtime_release() {
        return (StateMapStateRecord) SnapshotKt.readable((StateMapStateRecord) getFirstStateRecord(), this);
    }

    public final boolean any$runtime_release(Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (Map.Entry invoke : (ImmutableSet) getReadable$runtime_release().getMap$runtime_release().entrySet()) {
            if (function1.invoke(invoke).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public final boolean all$runtime_release(Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (Map.Entry invoke : (ImmutableSet) getReadable$runtime_release().getMap$runtime_release().entrySet()) {
            if (!function1.invoke(invoke).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    private final <R> R withCurrent(Function1<? super StateMapStateRecord<K, V>, ? extends R> function1) {
        return function1.invoke(SnapshotKt.current((StateMapStateRecord) getFirstStateRecord(), Snapshot.Companion.getCurrent()));
    }

    private final <R> R writable(Function1<? super StateMapStateRecord<K, V>, ? extends R> function1) {
        Snapshot current;
        R invoke;
        StateRecord stateRecord = (StateMapStateRecord) getFirstStateRecord();
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

    private final <R> R mutate(Function1<? super Map<K, V>, ? extends R> function1) {
        PersistentMap map$runtime_release;
        int modification$runtime_release;
        R invoke;
        Snapshot current;
        boolean z;
        do {
            synchronized (SnapshotStateMapKt.sync) {
                try {
                    StateMapStateRecord stateMapStateRecord = (StateMapStateRecord) SnapshotKt.current((StateMapStateRecord) getFirstStateRecord(), Snapshot.Companion.getCurrent());
                    map$runtime_release = stateMapStateRecord.getMap$runtime_release();
                    modification$runtime_release = stateMapStateRecord.getModification$runtime_release();
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                } finally {
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                }
            }
            InlineMarker.finallyEnd(1);
            Intrinsics.checkNotNull(map$runtime_release);
            PersistentMap.Builder builder = map$runtime_release.builder();
            invoke = function1.invoke(builder);
            PersistentMap build = builder.build();
            if (Intrinsics.areEqual((Object) build, (Object) map$runtime_release)) {
                break;
            }
            synchronized (SnapshotStateMapKt.sync) {
                try {
                    StateRecord stateRecord = (StateMapStateRecord) getFirstStateRecord();
                    SnapshotKt.getSnapshotInitializer();
                    synchronized (SnapshotKt.getLock()) {
                        current = Snapshot.Companion.getCurrent();
                        StateMapStateRecord stateMapStateRecord2 = (StateMapStateRecord) SnapshotKt.writableRecord(stateRecord, this, current);
                        if (stateMapStateRecord2.getModification$runtime_release() == modification$runtime_release) {
                            stateMapStateRecord2.setMap$runtime_release(build);
                            stateMapStateRecord2.setModification$runtime_release(stateMapStateRecord2.getModification$runtime_release() + 1);
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

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003B\u001b\b\u0000\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016R&\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateMap$StateMapStateRecord;", "K", "V", "Landroidx/compose/runtime/snapshots/StateRecord;", "map", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;)V", "getMap$runtime_release", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "setMap$runtime_release", "modification", "", "getModification$runtime_release", "()I", "setModification$runtime_release", "(I)V", "assign", "", "value", "create", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SnapshotStateMap.kt */
    public static final class StateMapStateRecord<K, V> extends StateRecord {
        private PersistentMap<K, ? extends V> map;
        private int modification;

        public final PersistentMap<K, V> getMap$runtime_release() {
            return this.map;
        }

        public final void setMap$runtime_release(PersistentMap<K, ? extends V> persistentMap) {
            Intrinsics.checkNotNullParameter(persistentMap, "<set-?>");
            this.map = persistentMap;
        }

        public StateMapStateRecord(PersistentMap<K, ? extends V> persistentMap) {
            Intrinsics.checkNotNullParameter(persistentMap, "map");
            this.map = persistentMap;
        }

        public final int getModification$runtime_release() {
            return this.modification;
        }

        public final void setModification$runtime_release(int i) {
            this.modification = i;
        }

        public void assign(StateRecord stateRecord) {
            Intrinsics.checkNotNullParameter(stateRecord, "value");
            StateMapStateRecord stateMapStateRecord = (StateMapStateRecord) stateRecord;
            synchronized (SnapshotStateMapKt.sync) {
                setMap$runtime_release(stateMapStateRecord.getMap$runtime_release());
                setModification$runtime_release(stateMapStateRecord.getModification$runtime_release());
                Unit unit = Unit.INSTANCE;
            }
        }

        public StateRecord create() {
            return new StateMapStateRecord(this.map);
        }
    }

    public void clear() {
        Snapshot current;
        StateMapStateRecord stateMapStateRecord = (StateMapStateRecord) SnapshotKt.current((StateMapStateRecord) getFirstStateRecord(), Snapshot.Companion.getCurrent());
        stateMapStateRecord.getMap$runtime_release();
        PersistentMap persistentHashMapOf = ExtensionsKt.persistentHashMapOf();
        if (persistentHashMapOf != stateMapStateRecord.getMap$runtime_release()) {
            synchronized (SnapshotStateMapKt.sync) {
                StateRecord stateRecord = (StateMapStateRecord) getFirstStateRecord();
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = Snapshot.Companion.getCurrent();
                    StateMapStateRecord stateMapStateRecord2 = (StateMapStateRecord) SnapshotKt.writableRecord(stateRecord, this, current);
                    stateMapStateRecord2.setMap$runtime_release(persistentHashMapOf);
                    stateMapStateRecord2.setModification$runtime_release(stateMapStateRecord2.getModification$runtime_release() + 1);
                }
                SnapshotKt.notifyWrite(current, this);
            }
        }
    }

    public V put(K k, V v) {
        PersistentMap map$runtime_release;
        int modification$runtime_release;
        V put;
        Snapshot current;
        boolean z;
        do {
            synchronized (SnapshotStateMapKt.sync) {
                StateMapStateRecord stateMapStateRecord = (StateMapStateRecord) SnapshotKt.current((StateMapStateRecord) getFirstStateRecord(), Snapshot.Companion.getCurrent());
                map$runtime_release = stateMapStateRecord.getMap$runtime_release();
                modification$runtime_release = stateMapStateRecord.getModification$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(map$runtime_release);
            PersistentMap.Builder builder = map$runtime_release.builder();
            put = builder.put(k, v);
            PersistentMap build = builder.build();
            if (Intrinsics.areEqual((Object) build, (Object) map$runtime_release)) {
                break;
            }
            synchronized (SnapshotStateMapKt.sync) {
                StateRecord stateRecord = (StateMapStateRecord) getFirstStateRecord();
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = Snapshot.Companion.getCurrent();
                    StateMapStateRecord stateMapStateRecord2 = (StateMapStateRecord) SnapshotKt.writableRecord(stateRecord, this, current);
                    z = true;
                    if (stateMapStateRecord2.getModification$runtime_release() == modification$runtime_release) {
                        stateMapStateRecord2.setMap$runtime_release(build);
                        stateMapStateRecord2.setModification$runtime_release(stateMapStateRecord2.getModification$runtime_release() + 1);
                    } else {
                        z = false;
                    }
                }
                SnapshotKt.notifyWrite(current, this);
            }
        } while (!z);
        return put;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        PersistentMap map$runtime_release;
        int modification$runtime_release;
        Snapshot current;
        boolean z;
        Intrinsics.checkNotNullParameter(map, TypedValues.TransitionType.S_FROM);
        do {
            synchronized (SnapshotStateMapKt.sync) {
                StateMapStateRecord stateMapStateRecord = (StateMapStateRecord) SnapshotKt.current((StateMapStateRecord) getFirstStateRecord(), Snapshot.Companion.getCurrent());
                map$runtime_release = stateMapStateRecord.getMap$runtime_release();
                modification$runtime_release = stateMapStateRecord.getModification$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(map$runtime_release);
            PersistentMap.Builder builder = map$runtime_release.builder();
            builder.putAll(map);
            Unit unit2 = Unit.INSTANCE;
            PersistentMap build = builder.build();
            if (!Intrinsics.areEqual((Object) build, (Object) map$runtime_release)) {
                synchronized (SnapshotStateMapKt.sync) {
                    StateRecord stateRecord = (StateMapStateRecord) getFirstStateRecord();
                    SnapshotKt.getSnapshotInitializer();
                    synchronized (SnapshotKt.getLock()) {
                        current = Snapshot.Companion.getCurrent();
                        StateMapStateRecord stateMapStateRecord2 = (StateMapStateRecord) SnapshotKt.writableRecord(stateRecord, this, current);
                        z = true;
                        if (stateMapStateRecord2.getModification$runtime_release() == modification$runtime_release) {
                            stateMapStateRecord2.setMap$runtime_release(build);
                            stateMapStateRecord2.setModification$runtime_release(stateMapStateRecord2.getModification$runtime_release() + 1);
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

    public V remove(Object obj) {
        PersistentMap map$runtime_release;
        int modification$runtime_release;
        V remove;
        Snapshot current;
        boolean z;
        do {
            synchronized (SnapshotStateMapKt.sync) {
                StateMapStateRecord stateMapStateRecord = (StateMapStateRecord) SnapshotKt.current((StateMapStateRecord) getFirstStateRecord(), Snapshot.Companion.getCurrent());
                map$runtime_release = stateMapStateRecord.getMap$runtime_release();
                modification$runtime_release = stateMapStateRecord.getModification$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(map$runtime_release);
            PersistentMap.Builder builder = map$runtime_release.builder();
            remove = builder.remove(obj);
            PersistentMap build = builder.build();
            if (Intrinsics.areEqual((Object) build, (Object) map$runtime_release)) {
                break;
            }
            synchronized (SnapshotStateMapKt.sync) {
                StateRecord stateRecord = (StateMapStateRecord) getFirstStateRecord();
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = Snapshot.Companion.getCurrent();
                    StateMapStateRecord stateMapStateRecord2 = (StateMapStateRecord) SnapshotKt.writableRecord(stateRecord, this, current);
                    z = true;
                    if (stateMapStateRecord2.getModification$runtime_release() == modification$runtime_release) {
                        stateMapStateRecord2.setMap$runtime_release(build);
                        stateMapStateRecord2.setModification$runtime_release(stateMapStateRecord2.getModification$runtime_release() + 1);
                    } else {
                        z = false;
                    }
                }
                SnapshotKt.notifyWrite(current, this);
            }
        } while (!z);
        return remove;
    }

    public final boolean removeIf$runtime_release(Function1<? super Map.Entry<K, V>, Boolean> function1) {
        PersistentMap map$runtime_release;
        int modification$runtime_release;
        Snapshot current;
        boolean z;
        Intrinsics.checkNotNullParameter(function1, "predicate");
        boolean z2 = false;
        do {
            synchronized (SnapshotStateMapKt.sync) {
                try {
                    StateMapStateRecord stateMapStateRecord = (StateMapStateRecord) SnapshotKt.current((StateMapStateRecord) getFirstStateRecord(), Snapshot.Companion.getCurrent());
                    map$runtime_release = stateMapStateRecord.getMap$runtime_release();
                    modification$runtime_release = stateMapStateRecord.getModification$runtime_release();
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                } finally {
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                }
            }
            InlineMarker.finallyEnd(1);
            Intrinsics.checkNotNull(map$runtime_release);
            PersistentMap.Builder builder = map$runtime_release.builder();
            Map map = builder;
            for (Map.Entry entry : entrySet()) {
                if (function1.invoke(entry).booleanValue()) {
                    map.remove(entry.getKey());
                    z2 = true;
                }
            }
            Unit unit2 = Unit.INSTANCE;
            PersistentMap build = builder.build();
            if (Intrinsics.areEqual((Object) build, (Object) map$runtime_release)) {
                break;
            }
            synchronized (SnapshotStateMapKt.sync) {
                try {
                    StateRecord stateRecord = (StateMapStateRecord) getFirstStateRecord();
                    SnapshotKt.getSnapshotInitializer();
                    synchronized (SnapshotKt.getLock()) {
                        current = Snapshot.Companion.getCurrent();
                        StateMapStateRecord stateMapStateRecord2 = (StateMapStateRecord) SnapshotKt.writableRecord(stateRecord, this, current);
                        if (stateMapStateRecord2.getModification$runtime_release() == modification$runtime_release) {
                            stateMapStateRecord2.setMap$runtime_release(build);
                            stateMapStateRecord2.setModification$runtime_release(stateMapStateRecord2.getModification$runtime_release() + 1);
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
        return z2;
    }

    public final Map<K, V> getDebuggerDisplayValue() {
        return ((StateMapStateRecord) SnapshotKt.current((StateMapStateRecord) getFirstStateRecord(), Snapshot.Companion.getCurrent())).getMap$runtime_release();
    }

    private final void update(Function1<? super PersistentMap<K, ? extends V>, ? extends PersistentMap<K, ? extends V>> function1) {
        Snapshot current;
        StateMapStateRecord stateMapStateRecord = (StateMapStateRecord) SnapshotKt.current((StateMapStateRecord) getFirstStateRecord(), Snapshot.Companion.getCurrent());
        PersistentMap persistentMap = (PersistentMap) function1.invoke(stateMapStateRecord.getMap$runtime_release());
        if (persistentMap != stateMapStateRecord.getMap$runtime_release()) {
            synchronized (SnapshotStateMapKt.sync) {
                try {
                    StateRecord stateRecord = (StateMapStateRecord) getFirstStateRecord();
                    SnapshotKt.getSnapshotInitializer();
                    synchronized (SnapshotKt.getLock()) {
                        current = Snapshot.Companion.getCurrent();
                        StateMapStateRecord stateMapStateRecord2 = (StateMapStateRecord) SnapshotKt.writableRecord(stateRecord, this, current);
                        stateMapStateRecord2.setMap$runtime_release(persistentMap);
                        stateMapStateRecord2.setModification$runtime_release(stateMapStateRecord2.getModification$runtime_release() + 1);
                        InlineMarker.finallyStart(1);
                    }
                    InlineMarker.finallyEnd(1);
                    SnapshotKt.notifyWrite(current, this);
                    InlineMarker.finallyStart(1);
                } catch (Throwable th) {
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                    throw th;
                }
            }
            InlineMarker.finallyEnd(1);
        }
    }
}
