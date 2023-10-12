package androidx.compose.runtime;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.runtime.snapshots.StateRecord;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001#B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010\u0006J2\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020!2\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J\b\u0010\"\u001a\u00020\u001fH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00028\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\u0004\u0018\u00018\u00008G¢\u0006\f\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\tR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00028\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\t¨\u0006$"}, d2 = {"Landroidx/compose/runtime/DerivedSnapshotState;", "T", "Landroidx/compose/runtime/snapshots/StateObject;", "Landroidx/compose/runtime/DerivedState;", "calculation", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "currentValue", "getCurrentValue", "()Ljava/lang/Object;", "debuggerDisplayValue", "getDebuggerDisplayValue$annotations", "()V", "getDebuggerDisplayValue", "dependencies", "", "getDependencies", "()Ljava/util/Set;", "first", "Landroidx/compose/runtime/DerivedSnapshotState$ResultRecord;", "firstStateRecord", "Landroidx/compose/runtime/snapshots/StateRecord;", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "value", "getValue", "currentRecord", "readable", "snapshot", "Landroidx/compose/runtime/snapshots/Snapshot;", "displayValue", "", "prependStateRecord", "", "toString", "ResultRecord", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DerivedState.kt */
final class DerivedSnapshotState<T> implements StateObject, DerivedState<T> {
    private final Function0<T> calculation;
    private ResultRecord<T> first = new ResultRecord<>();

    public static /* synthetic */ void getDebuggerDisplayValue$annotations() {
    }

    public DerivedSnapshotState(Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "calculation");
        this.calculation = function0;
    }

    public StateRecord mergeRecords(StateRecord stateRecord, StateRecord stateRecord2, StateRecord stateRecord3) {
        return StateObject.DefaultImpls.mergeRecords(this, stateRecord, stateRecord2, stateRecord3);
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0002H\u0016J\b\u0010\u001b\u001a\u00020\u0002H\u0016J\u001a\u0010\u001c\u001a\u00020\u001d2\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001f2\u0006\u0010 \u001a\u00020!J\u001a\u0010\"\u001a\u00020\u00132\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001f2\u0006\u0010 \u001a\u00020!R.\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u0004\u0018\u00018\u0001X\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006#"}, d2 = {"Landroidx/compose/runtime/DerivedSnapshotState$ResultRecord;", "T", "Landroidx/compose/runtime/snapshots/StateRecord;", "()V", "dependencies", "Ljava/util/HashSet;", "Landroidx/compose/runtime/snapshots/StateObject;", "Lkotlin/collections/HashSet;", "getDependencies", "()Ljava/util/HashSet;", "setDependencies", "(Ljava/util/HashSet;)V", "result", "getResult", "()Ljava/lang/Object;", "setResult", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "resultHash", "", "getResultHash", "()I", "setResultHash", "(I)V", "assign", "", "value", "create", "isValid", "", "derivedState", "Landroidx/compose/runtime/DerivedState;", "snapshot", "Landroidx/compose/runtime/snapshots/Snapshot;", "readableHash", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DerivedState.kt */
    private static final class ResultRecord<T> extends StateRecord {
        private HashSet<StateObject> dependencies;
        private T result;
        private int resultHash;

        public final HashSet<StateObject> getDependencies() {
            return this.dependencies;
        }

        public final void setDependencies(HashSet<StateObject> hashSet) {
            this.dependencies = hashSet;
        }

        public final T getResult() {
            return this.result;
        }

        public final void setResult(T t) {
            this.result = t;
        }

        public final int getResultHash() {
            return this.resultHash;
        }

        public final void setResultHash(int i) {
            this.resultHash = i;
        }

        public void assign(StateRecord stateRecord) {
            Intrinsics.checkNotNullParameter(stateRecord, "value");
            ResultRecord resultRecord = (ResultRecord) stateRecord;
            this.dependencies = resultRecord.dependencies;
            this.result = resultRecord.result;
            this.resultHash = resultRecord.resultHash;
        }

        public StateRecord create() {
            return new ResultRecord();
        }

        public final boolean isValid(DerivedState<?> derivedState, Snapshot snapshot) {
            Intrinsics.checkNotNullParameter(derivedState, "derivedState");
            Intrinsics.checkNotNullParameter(snapshot, "snapshot");
            return this.result != null && this.resultHash == readableHash(derivedState, snapshot);
        }

        /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public final int readableHash(androidx.compose.runtime.DerivedState<?> r8, androidx.compose.runtime.snapshots.Snapshot r9) {
            /*
                r7 = this;
                java.lang.String r0 = "derivedState"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
                java.lang.String r0 = "snapshot"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
                java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
                monitor-enter(r0)
                java.util.HashSet r1 = r7.getDependencies()     // Catch:{ all -> 0x00a9 }
                monitor-exit(r0)
                r0 = 7
                if (r1 == 0) goto L_0x00a8
                androidx.compose.runtime.SnapshotThreadLocal r2 = androidx.compose.runtime.SnapshotStateKt__DerivedStateKt.derivedStateObservers
                java.lang.Object r2 = r2.get()
                androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r2 = (androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList) r2
                if (r2 != 0) goto L_0x0028
                androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r2 = androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.persistentListOf()
            L_0x0028:
                java.util.List r2 = (java.util.List) r2
                int r3 = r2.size()
                r4 = 0
                r5 = 0
            L_0x0030:
                if (r5 >= r3) goto L_0x0045
                int r6 = r5 + 1
                java.lang.Object r5 = r2.get(r5)
                kotlin.Pair r5 = (kotlin.Pair) r5
                java.lang.Object r5 = r5.component1()
                kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
                r5.invoke(r8)
                r5 = r6
                goto L_0x0030
            L_0x0045:
                java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x008d }
            L_0x0049:
                boolean r3 = r1.hasNext()     // Catch:{ all -> 0x008d }
                if (r3 == 0) goto L_0x0072
                java.lang.Object r3 = r1.next()     // Catch:{ all -> 0x008d }
                androidx.compose.runtime.snapshots.StateObject r3 = (androidx.compose.runtime.snapshots.StateObject) r3     // Catch:{ all -> 0x008d }
                androidx.compose.runtime.snapshots.StateRecord r5 = r3.getFirstStateRecord()     // Catch:{ all -> 0x008d }
                java.lang.String r6 = "stateObject"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r6)     // Catch:{ all -> 0x008d }
                androidx.compose.runtime.snapshots.StateRecord r3 = androidx.compose.runtime.snapshots.SnapshotKt.readable(r5, (androidx.compose.runtime.snapshots.StateObject) r3, (androidx.compose.runtime.snapshots.Snapshot) r9)     // Catch:{ all -> 0x008d }
                int r0 = r0 * 31
                int r5 = androidx.compose.runtime.ActualJvm_jvmKt.identityHashCode(r3)     // Catch:{ all -> 0x008d }
                int r0 = r0 + r5
                int r0 = r0 * 31
                int r3 = r3.getSnapshotId$runtime_release()     // Catch:{ all -> 0x008d }
                int r0 = r0 + r3
                goto L_0x0049
            L_0x0072:
                kotlin.Unit r9 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x008d }
                int r9 = r2.size()
            L_0x0078:
                if (r4 >= r9) goto L_0x00a8
                int r1 = r4 + 1
                java.lang.Object r3 = r2.get(r4)
                kotlin.Pair r3 = (kotlin.Pair) r3
                java.lang.Object r3 = r3.component2()
                kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
                r3.invoke(r8)
                r4 = r1
                goto L_0x0078
            L_0x008d:
                r9 = move-exception
                int r0 = r2.size()
            L_0x0092:
                if (r4 >= r0) goto L_0x00a7
                int r1 = r4 + 1
                java.lang.Object r3 = r2.get(r4)
                kotlin.Pair r3 = (kotlin.Pair) r3
                java.lang.Object r3 = r3.component2()
                kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
                r3.invoke(r8)
                r4 = r1
                goto L_0x0092
            L_0x00a7:
                throw r9
            L_0x00a8:
                return r0
            L_0x00a9:
                r8 = move-exception
                monitor-exit(r0)
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.DerivedSnapshotState.ResultRecord.readableHash(androidx.compose.runtime.DerivedState, androidx.compose.runtime.snapshots.Snapshot):int");
        }
    }

    private final ResultRecord<T> currentRecord(ResultRecord<T> resultRecord, Snapshot snapshot, Function0<? extends T> function0) {
        ResultRecord<T> resultRecord2;
        DerivedState derivedState = this;
        if (resultRecord.isValid(derivedState, snapshot)) {
            return resultRecord;
        }
        Boolean bool = (Boolean) SnapshotStateKt__DerivedStateKt.isCalculationBlockRunning.get();
        int i = 0;
        boolean booleanValue = bool == null ? false : bool.booleanValue();
        HashSet hashSet = new HashSet();
        PersistentList persistentList = (PersistentList) SnapshotStateKt__DerivedStateKt.derivedStateObservers.get();
        if (persistentList == null) {
            persistentList = ExtensionsKt.persistentListOf();
        }
        List list = persistentList;
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((Function1) ((Pair) list.get(i2)).component1()).invoke(derivedState);
        }
        if (!booleanValue) {
            try {
                SnapshotStateKt__DerivedStateKt.isCalculationBlockRunning.set(true);
            } catch (Throwable th) {
                int size2 = list.size();
                while (i < size2) {
                    ((Function1) ((Pair) list.get(i)).component2()).invoke(derivedState);
                    i++;
                }
                throw th;
            }
        }
        Object observe = Snapshot.Companion.observe(new DerivedSnapshotState$currentRecord$result$1$result$1(this, hashSet), (Function1<Object, Unit>) null, function0);
        if (!booleanValue) {
            SnapshotStateKt__DerivedStateKt.isCalculationBlockRunning.set(false);
        }
        int size3 = list.size();
        while (i < size3) {
            ((Function1) ((Pair) list.get(i)).component2()).invoke(derivedState);
            i++;
        }
        synchronized (SnapshotKt.getLock()) {
            Snapshot current = Snapshot.Companion.getCurrent();
            resultRecord2 = (ResultRecord) SnapshotKt.newWritableRecord(this.first, this, current);
            resultRecord2.setDependencies(hashSet);
            resultRecord2.setResultHash(resultRecord2.readableHash(this, current));
            resultRecord2.setResult(observe);
        }
        if (!booleanValue) {
            Snapshot.Companion.notifyObjectsInitialized();
        }
        return resultRecord2;
    }

    public StateRecord getFirstStateRecord() {
        return this.first;
    }

    public void prependStateRecord(StateRecord stateRecord) {
        Intrinsics.checkNotNullParameter(stateRecord, "value");
        this.first = (ResultRecord) stateRecord;
    }

    public T getValue() {
        Function1<Object, Unit> readObserver$runtime_release = Snapshot.Companion.getCurrent().getReadObserver$runtime_release();
        if (readObserver$runtime_release != null) {
            readObserver$runtime_release.invoke(this);
        }
        return getCurrentValue();
    }

    public T getCurrentValue() {
        return currentRecord((ResultRecord) SnapshotKt.current(this.first, Snapshot.Companion.getCurrent()), Snapshot.Companion.getCurrent(), this.calculation).getResult();
    }

    public Set<StateObject> getDependencies() {
        HashSet<StateObject> dependencies = currentRecord((ResultRecord) SnapshotKt.current(this.first, Snapshot.Companion.getCurrent()), Snapshot.Companion.getCurrent(), this.calculation).getDependencies();
        return dependencies == null ? SetsKt.emptySet() : dependencies;
    }

    public String toString() {
        ResultRecord resultRecord = (ResultRecord) SnapshotKt.current(this.first, Snapshot.Companion.getCurrent());
        return "DerivedState(value=" + displayValue() + ")@" + hashCode();
    }

    public final T getDebuggerDisplayValue() {
        ResultRecord resultRecord = (ResultRecord) SnapshotKt.current(this.first, Snapshot.Companion.getCurrent());
        if (resultRecord.isValid(this, Snapshot.Companion.getCurrent())) {
            return resultRecord.getResult();
        }
        return null;
    }

    private final String displayValue() {
        ResultRecord resultRecord = (ResultRecord) SnapshotKt.current(this.first, Snapshot.Companion.getCurrent());
        return resultRecord.isValid(this, Snapshot.Companion.getCurrent()) ? String.valueOf(resultRecord.getResult()) : "<Not calculated>";
    }
}
