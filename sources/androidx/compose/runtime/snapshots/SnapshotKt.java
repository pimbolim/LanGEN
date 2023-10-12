package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.SnapshotThreadLocal;
import com.braintreepayments.api.models.PostalAddressParser;
import com.nimbusds.jose.jwk.JWKParameterNames;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a\b\u0010\"\u001a\u00020\bH\u0002\u001a6\u0010\"\u001a\u0002H#\"\u0004\b\u0000\u0010#2!\u0010$\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u0002H#0\u000fH\u0002¢\u0006\u0002\u0010%\u001a'\u0010&\u001a\u0002H#\"\b\b\u0000\u0010#*\u00020'2\u0006\u0010(\u001a\u0002H#2\u0006\u0010)\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010*\u001a\b\u0010+\u001a\u00020\u0007H\u0000\u001aB\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f2\u0014\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f2\u0014\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u000fH\u0002\u001aB\u0010/\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f2\u0014\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f2\u0014\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u000fH\u0002\u001a\u0018\u00101\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u00072\u0006\u00102\u001a\u000203H\u0001\u001a.\u00104\u001a\u0010\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020'\u0018\u0001052\u0006\u0010+\u001a\u0002062\u0006\u00107\u001a\u0002062\u0006\u00108\u001a\u00020\u0010H\u0002\u001a\b\u00109\u001a\u00020:H\u0002\u001a1\u0010;\u001a\u0004\u0018\u0001H#\"\b\b\u0000\u0010#*\u00020'2\u0006\u0010(\u001a\u0002H#2\u0006\u0010<\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0010H\u0002¢\u0006\u0002\u0010=\u001a\b\u0010>\u001a\u00020:H\u0002\u001a%\u0010?\u001a\u0002H#\"\u0004\b\u0000\u0010#2\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H#0@H\bø\u0001\u0000¢\u0006\u0002\u0010A\u001a>\u0010B\u001a\u0002H#\"\u0004\b\u0000\u0010#2\u0006\u0010C\u001a\u00020\u00072!\u0010$\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u0002H#0\u000fH\u0002¢\u0006\u0002\u0010D\u001a:\u0010E\u001a\u0002H#\"\b\b\u0000\u0010#*\u00020\u00072!\u0010$\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u0002H#0\u000fH\u0002¢\u0006\u0002\u0010F\u001a\"\u0010G\u001a\u0004\u0018\u00010'2\u0006\u00102\u001a\u0002032\u0006\u0010<\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0010H\u0002\u001a \u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020'2\u0006\u0010)\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0010H\u0002\u001a \u0010H\u001a\u00020I2\u0006\u0010+\u001a\u00020\u00012\u0006\u0010K\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0010H\u0002\u001a\u0010\u0010L\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u0007H\u0002\u001a\u001c\u0010M\u001a\u00020\u0010*\u00020\u00102\u0006\u0010N\u001a\u00020\u00012\u0006\u0010O\u001a\u00020\u0001H\u0000\u001a+\u0010P\u001a\u0002H#\"\b\b\u0000\u0010#*\u00020'*\u0002H#2\u0006\u00102\u001a\u0002032\u0006\u0010)\u001a\u00020\u0007H\u0000¢\u0006\u0002\u0010Q\u001a+\u0010R\u001a\u0002H#\"\b\b\u0000\u0010#*\u00020'*\u0002H#2\u0006\u00102\u001a\u0002032\u0006\u0010)\u001a\u00020\u0007H\u0000¢\u0006\u0002\u0010Q\u001aN\u0010S\u001a\u0002HT\"\b\b\u0000\u0010#*\u00020'\"\u0004\b\u0001\u0010T*\u0002H#2\u0006\u00102\u001a\u0002032\u0006\u0010U\u001a\u0002H#2\u0017\u0010$\u001a\u0013\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u0002HT0\u000f¢\u0006\u0002\bVH\bø\u0001\u0000¢\u0006\u0002\u0010W\u001a3\u0010X\u001a\u0002H#\"\b\b\u0000\u0010#*\u00020'*\u0002H#2\u0006\u00102\u001a\u0002032\u0006\u0010)\u001a\u00020\u00072\u0006\u0010U\u001a\u0002H#H\u0000¢\u0006\u0002\u0010Y\u001a!\u0010;\u001a\u0002H#\"\b\b\u0000\u0010#*\u00020'*\u0002H#2\u0006\u00102\u001a\u000203¢\u0006\u0002\u0010Z\u001a)\u0010;\u001a\u0002H#\"\b\b\u0000\u0010#*\u00020'*\u0002H#2\u0006\u00102\u001a\u0002032\u0006\u0010)\u001a\u00020\u0007¢\u0006\u0002\u0010Q\u001aH\u0010[\u001a\u0002HT\"\b\b\u0000\u0010#*\u00020'\"\u0004\b\u0001\u0010T*\u0002H#2!\u0010$\u001a\u001d\u0012\u0013\u0012\u0011H#¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b((\u0012\u0004\u0012\u0002HT0\u000fH\bø\u0001\u0000¢\u0006\u0002\u0010\\\u001aF\u0010]\u001a\u0002HT\"\b\b\u0000\u0010#*\u00020'\"\u0004\b\u0001\u0010T*\u0002H#2\u0006\u00102\u001a\u0002032\u0017\u0010$\u001a\u0013\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u0002HT0\u000f¢\u0006\u0002\bVH\bø\u0001\u0000¢\u0006\u0002\u0010^\u001aN\u0010]\u001a\u0002HT\"\b\b\u0000\u0010#*\u00020'\"\u0004\b\u0001\u0010T*\u0002H#2\u0006\u00102\u001a\u0002032\u0006\u0010)\u001a\u00020\u00072\u0017\u0010$\u001a\u0013\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u0002HT0\u000f¢\u0006\u0002\bVH\bø\u0001\u0000¢\u0006\u0002\u0010_\u001a+\u0010`\u001a\u0002H#\"\b\b\u0000\u0010#*\u00020'*\u0002H#2\u0006\u00102\u001a\u0002032\u0006\u0010)\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010Q\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\",\u0010\u0002\u001a \u0012\u001c\u0012\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00040\u0003X\u0004¢\u0006\u0002\n\u0000\".\u0010\t\u001a\"\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\nj\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b`\rX\u0004¢\u0006\u0002\n\u0000\")\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\b0\u000fX\u0004¢\u0006\u0002\n\u0000\" \u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u000f0\u0003X\u0004¢\u0006\u0002\n\u0000\"\u001c\u0010\u0015\u001a\u00020\u00068\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u000e\u0010\u001a\u001a\u00020\u0001X\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000\"\u001c\u0010\u001c\u001a\u00020\u00078\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0017\u001a\u0004\b\u001e\u0010\u001f\"\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070!X\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006a"}, d2 = {"INVALID_SNAPSHOT", "", "applyObservers", "", "Lkotlin/Function2;", "", "", "Landroidx/compose/runtime/snapshots/Snapshot;", "", "currentGlobalSnapshot", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/runtime/snapshots/GlobalSnapshot;", "kotlin.jvm.PlatformType", "Landroidx/compose/runtime/AtomicReference;", "emptyLambda", "Lkotlin/Function1;", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "Lkotlin/ParameterName;", "name", "invalid", "globalWriteObservers", "lock", "getLock$annotations", "()V", "getLock", "()Ljava/lang/Object;", "nextSnapshotId", "openSnapshots", "snapshotInitializer", "getSnapshotInitializer$annotations", "getSnapshotInitializer", "()Landroidx/compose/runtime/snapshots/Snapshot;", "threadSnapshot", "Landroidx/compose/runtime/SnapshotThreadLocal;", "advanceGlobalSnapshot", "T", "block", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "current", "Landroidx/compose/runtime/snapshots/StateRecord;", "r", "snapshot", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/Snapshot;)Landroidx/compose/runtime/snapshots/StateRecord;", "currentSnapshot", "mergedReadObserver", "readObserver", "parentObserver", "mergedWriteObserver", "writeObserver", "notifyWrite", "state", "Landroidx/compose/runtime/snapshots/StateObject;", "optimisticMerges", "", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "applyingSnapshot", "invalidSnapshots", "readError", "", "readable", "id", "(Landroidx/compose/runtime/snapshots/StateRecord;ILandroidx/compose/runtime/snapshots/SnapshotIdSet;)Landroidx/compose/runtime/snapshots/StateRecord;", "reportReadonlySnapshotWrite", "sync", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "takeNewGlobalSnapshot", "previousGlobalSnapshot", "(Landroidx/compose/runtime/snapshots/Snapshot;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "takeNewSnapshot", "(Lkotlin/jvm/functions/Function1;)Landroidx/compose/runtime/snapshots/Snapshot;", "used", "valid", "", "data", "candidateSnapshot", "validateOpen", "addRange", "from", "until", "newOverwritableRecord", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Landroidx/compose/runtime/snapshots/Snapshot;)Landroidx/compose/runtime/snapshots/StateRecord;", "newWritableRecord", "overwritable", "R", "candidate", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Landroidx/compose/runtime/snapshots/StateRecord;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "overwritableRecord", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Landroidx/compose/runtime/snapshots/Snapshot;Landroidx/compose/runtime/snapshots/StateRecord;)Landroidx/compose/runtime/snapshots/StateRecord;", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;)Landroidx/compose/runtime/snapshots/StateRecord;", "withCurrent", "(Landroidx/compose/runtime/snapshots/StateRecord;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "writable", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Landroidx/compose/runtime/snapshots/Snapshot;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "writableRecord", "runtime_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Snapshot.kt */
public final class SnapshotKt {
    private static final int INVALID_SNAPSHOT = 0;
    /* access modifiers changed from: private */
    public static final List<Function2<Set<? extends Object>, Snapshot, Unit>> applyObservers = new ArrayList();
    /* access modifiers changed from: private */
    public static final AtomicReference<GlobalSnapshot> currentGlobalSnapshot;
    /* access modifiers changed from: private */
    public static final Function1<SnapshotIdSet, Unit> emptyLambda = SnapshotKt$emptyLambda$1.INSTANCE;
    /* access modifiers changed from: private */
    public static final List<Function1<Object, Unit>> globalWriteObservers = new ArrayList();
    private static final Object lock = new Object();
    /* access modifiers changed from: private */
    public static int nextSnapshotId;
    /* access modifiers changed from: private */
    public static SnapshotIdSet openSnapshots;
    private static final Snapshot snapshotInitializer;
    /* access modifiers changed from: private */
    public static final SnapshotThreadLocal<Snapshot> threadSnapshot = new SnapshotThreadLocal<>();

    public static /* synthetic */ void getLock$annotations() {
    }

    public static /* synthetic */ void getSnapshotInitializer$annotations() {
    }

    public static final Snapshot currentSnapshot() {
        Snapshot snapshot = threadSnapshot.get();
        if (snapshot != null) {
            return snapshot;
        }
        GlobalSnapshot globalSnapshot = currentGlobalSnapshot.get();
        Intrinsics.checkNotNullExpressionValue(globalSnapshot, "currentGlobalSnapshot.get()");
        return globalSnapshot;
    }

    static {
        openSnapshots = SnapshotIdSet.Companion.getEMPTY();
        nextSnapshotId = 1;
        int i = nextSnapshotId;
        nextSnapshotId = i + 1;
        GlobalSnapshot globalSnapshot = new GlobalSnapshot(i, SnapshotIdSet.Companion.getEMPTY());
        openSnapshots = openSnapshots.set(globalSnapshot.getId());
        AtomicReference<GlobalSnapshot> atomicReference = new AtomicReference<>(globalSnapshot);
        currentGlobalSnapshot = atomicReference;
        GlobalSnapshot globalSnapshot2 = atomicReference.get();
        Intrinsics.checkNotNullExpressionValue(globalSnapshot2, "currentGlobalSnapshot.get()");
        snapshotInitializer = globalSnapshot2;
    }

    /* access modifiers changed from: private */
    public static final Function1<Object, Unit> mergedReadObserver(Function1<Object, Unit> function1, Function1<Object, Unit> function12) {
        if (function1 == null || function12 == null || Intrinsics.areEqual((Object) function1, (Object) function12)) {
            return function1 == null ? function12 : function1;
        }
        return new SnapshotKt$mergedReadObserver$1(function1, function12);
    }

    /* access modifiers changed from: private */
    public static final Function1<Object, Unit> mergedWriteObserver(Function1<Object, Unit> function1, Function1<Object, Unit> function12) {
        if (function1 == null || function12 == null || Intrinsics.areEqual((Object) function1, (Object) function12)) {
            return function1 == null ? function12 : function1;
        }
        return new SnapshotKt$mergedWriteObserver$1(function1, function12);
    }

    public static final Object getLock() {
        return lock;
    }

    public static final <T> T sync(Function0<? extends T> function0) {
        T invoke;
        Intrinsics.checkNotNullParameter(function0, "block");
        synchronized (getLock()) {
            try {
                invoke = function0.invoke();
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
        return invoke;
    }

    public static final Snapshot getSnapshotInitializer() {
        return snapshotInitializer;
    }

    /* access modifiers changed from: private */
    public static final <T> T takeNewGlobalSnapshot(Snapshot snapshot, Function1<? super SnapshotIdSet, ? extends T> function1) {
        T invoke = function1.invoke(openSnapshots.clear(snapshot.getId()));
        synchronized (getLock()) {
            int i = nextSnapshotId;
            nextSnapshotId = i + 1;
            openSnapshots = openSnapshots.clear(snapshot.getId());
            currentGlobalSnapshot.set(new GlobalSnapshot(i, openSnapshots));
            openSnapshots = openSnapshots.set(i);
            Unit unit = Unit.INSTANCE;
        }
        return invoke;
    }

    /* access modifiers changed from: private */
    public static final <T> T advanceGlobalSnapshot(Function1<? super SnapshotIdSet, ? extends T> function1) {
        T takeNewGlobalSnapshot;
        List mutableList;
        GlobalSnapshot globalSnapshot = currentGlobalSnapshot.get();
        synchronized (getLock()) {
            Intrinsics.checkNotNullExpressionValue(globalSnapshot, "previousGlobalSnapshot");
            takeNewGlobalSnapshot = takeNewGlobalSnapshot(globalSnapshot, function1);
        }
        Set<StateObject> modified$runtime_release = globalSnapshot.getModified$runtime_release();
        if (modified$runtime_release != null) {
            synchronized (getLock()) {
                mutableList = CollectionsKt.toMutableList(applyObservers);
            }
            int size = mutableList.size();
            for (int i = 0; i < size; i++) {
                ((Function2) mutableList.get(i)).invoke(modified$runtime_release, globalSnapshot);
            }
        }
        return takeNewGlobalSnapshot;
    }

    /* access modifiers changed from: private */
    public static final void advanceGlobalSnapshot() {
        advanceGlobalSnapshot(SnapshotKt$advanceGlobalSnapshot$2.INSTANCE);
    }

    /* access modifiers changed from: private */
    public static final <T extends Snapshot> T takeNewSnapshot(Function1<? super SnapshotIdSet, ? extends T> function1) {
        return (Snapshot) advanceGlobalSnapshot(new SnapshotKt$takeNewSnapshot$1(function1));
    }

    /* access modifiers changed from: private */
    public static final void validateOpen(Snapshot snapshot) {
        if (!openSnapshots.get(snapshot.getId())) {
            throw new IllegalStateException("Snapshot is not open".toString());
        }
    }

    private static final boolean valid(int i, int i2, SnapshotIdSet snapshotIdSet) {
        return i2 != 0 && i2 <= i && !snapshotIdSet.get(i2);
    }

    private static final boolean valid(StateRecord stateRecord, int i, SnapshotIdSet snapshotIdSet) {
        return valid(i, stateRecord.getSnapshotId$runtime_release(), snapshotIdSet);
    }

    /* access modifiers changed from: private */
    public static final <T extends StateRecord> T readable(T t, int i, SnapshotIdSet snapshotIdSet) {
        T t2 = null;
        while (t != null) {
            if (valid((StateRecord) t, i, snapshotIdSet) && (t2 == null || t2.getSnapshotId$runtime_release() < t.getSnapshotId$runtime_release())) {
                t2 = t;
            }
            t = t.getNext$runtime_release();
        }
        if (t2 != null) {
            return t2;
        }
        return null;
    }

    public static final <T extends StateRecord> T readable(T t, StateObject stateObject) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(stateObject, PostalAddressParser.REGION_KEY);
        return readable(t, stateObject, currentSnapshot());
    }

    public static final <T extends StateRecord> T readable(T t, StateObject stateObject, Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(stateObject, PostalAddressParser.REGION_KEY);
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        Function1<Object, Unit> readObserver$runtime_release = snapshot.getReadObserver$runtime_release();
        if (readObserver$runtime_release != null) {
            readObserver$runtime_release.invoke(stateObject);
        }
        T readable = readable(t, snapshot.getId(), snapshot.getInvalid$runtime_release());
        if (readable != null) {
            return readable;
        }
        readError();
        throw new KotlinNothingValueException();
    }

    /* access modifiers changed from: private */
    public static final Void readError() {
        throw new IllegalStateException("Reading a state that was created after the snapshot was taken or in a snapshot that has not yet been applied".toString());
    }

    private static final StateRecord used(StateObject stateObject, int i, SnapshotIdSet snapshotIdSet) {
        int lowest = snapshotIdSet.lowest(i);
        StateRecord stateRecord = null;
        for (StateRecord firstStateRecord = stateObject.getFirstStateRecord(); firstStateRecord != null; firstStateRecord = firstStateRecord.getNext$runtime_release()) {
            if (firstStateRecord.getSnapshotId$runtime_release() == 0) {
                return firstStateRecord;
            }
            if (valid(firstStateRecord, lowest, snapshotIdSet)) {
                if (stateRecord != null) {
                    return firstStateRecord.getSnapshotId$runtime_release() < stateRecord.getSnapshotId$runtime_release() ? firstStateRecord : stateRecord;
                }
                stateRecord = firstStateRecord;
            }
        }
        return null;
    }

    public static final <T extends StateRecord> T writableRecord(T t, StateObject stateObject, Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(stateObject, PostalAddressParser.REGION_KEY);
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        if (snapshot.getReadOnly()) {
            snapshot.recordModified$runtime_release(stateObject);
        }
        T readable = readable(t, snapshot.getId(), snapshot.getInvalid$runtime_release());
        if (readable == null) {
            readError();
            throw new KotlinNothingValueException();
        } else if (readable.getSnapshotId$runtime_release() == snapshot.getId()) {
            return readable;
        } else {
            T newWritableRecord = newWritableRecord(readable, stateObject, snapshot);
            snapshot.recordModified$runtime_release(stateObject);
            return newWritableRecord;
        }
    }

    public static final <T extends StateRecord> T overwritableRecord(T t, StateObject stateObject, Snapshot snapshot, T t2) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(stateObject, PostalAddressParser.REGION_KEY);
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        Intrinsics.checkNotNullParameter(t2, "candidate");
        if (snapshot.getReadOnly()) {
            snapshot.recordModified$runtime_release(stateObject);
        }
        int id = snapshot.getId();
        if (t2.getSnapshotId$runtime_release() == id) {
            return t2;
        }
        T newOverwritableRecord = newOverwritableRecord(t, stateObject, snapshot);
        newOverwritableRecord.setSnapshotId$runtime_release(id);
        snapshot.recordModified$runtime_release(stateObject);
        return newOverwritableRecord;
    }

    public static final <T extends StateRecord> T newWritableRecord(T t, StateObject stateObject, Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(stateObject, PostalAddressParser.REGION_KEY);
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        T newOverwritableRecord = newOverwritableRecord(t, stateObject, snapshot);
        newOverwritableRecord.assign(t);
        newOverwritableRecord.setSnapshotId$runtime_release(snapshot.getId());
        return newOverwritableRecord;
    }

    public static final <T extends StateRecord> T newOverwritableRecord(T t, StateObject stateObject, Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(stateObject, PostalAddressParser.REGION_KEY);
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        T used = used(stateObject, snapshot.getId(), openSnapshots);
        if (used == null) {
            used = null;
        } else {
            used.setSnapshotId$runtime_release(Integer.MAX_VALUE);
        }
        if (used != null) {
            return used;
        }
        T create = t.create();
        create.setSnapshotId$runtime_release(Integer.MAX_VALUE);
        create.setNext$runtime_release(stateObject.getFirstStateRecord());
        stateObject.prependStateRecord(create);
        return create;
    }

    public static final void notifyWrite(Snapshot snapshot, StateObject stateObject) {
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        Intrinsics.checkNotNullParameter(stateObject, PostalAddressParser.REGION_KEY);
        Function1<Object, Unit> writeObserver$runtime_release = snapshot.getWriteObserver$runtime_release();
        if (writeObserver$runtime_release != null) {
            writeObserver$runtime_release.invoke(stateObject);
        }
    }

    public static final <T extends StateRecord, R> R writable(T t, StateObject stateObject, Function1<? super T, ? extends R> function1) {
        Snapshot current;
        R invoke;
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(stateObject, PostalAddressParser.REGION_KEY);
        Intrinsics.checkNotNullParameter(function1, "block");
        getSnapshotInitializer();
        synchronized (getLock()) {
            try {
                current = Snapshot.Companion.getCurrent();
                invoke = function1.invoke(writableRecord(t, stateObject, current));
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
        notifyWrite(current, stateObject);
        return invoke;
    }

    public static final <T extends StateRecord, R> R overwritable(T t, StateObject stateObject, T t2, Function1<? super T, ? extends R> function1) {
        Snapshot current;
        R invoke;
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(stateObject, PostalAddressParser.REGION_KEY);
        Intrinsics.checkNotNullParameter(t2, "candidate");
        Intrinsics.checkNotNullParameter(function1, "block");
        getSnapshotInitializer();
        synchronized (getLock()) {
            try {
                current = Snapshot.Companion.getCurrent();
                invoke = function1.invoke(overwritableRecord(t, stateObject, current, t2));
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
        notifyWrite(current, stateObject);
        return invoke;
    }

    /* access modifiers changed from: private */
    public static final Map<StateRecord, StateRecord> optimisticMerges(MutableSnapshot mutableSnapshot, MutableSnapshot mutableSnapshot2, SnapshotIdSet snapshotIdSet) {
        StateRecord readable;
        Set<StateObject> modified$runtime_release = mutableSnapshot2.getModified$runtime_release();
        int id = mutableSnapshot.getId();
        if (modified$runtime_release == null) {
            return null;
        }
        SnapshotIdSet or = mutableSnapshot2.getInvalid$runtime_release().set(mutableSnapshot2.getId()).or(mutableSnapshot2.getPreviousIds$runtime_release());
        HashMap hashMap = null;
        for (StateObject next : modified$runtime_release) {
            StateRecord firstStateRecord = next.getFirstStateRecord();
            StateRecord readable2 = readable(firstStateRecord, id, snapshotIdSet);
            if (!(readable2 == null || (readable = readable(firstStateRecord, id, or)) == null || Intrinsics.areEqual((Object) readable2, (Object) readable))) {
                StateRecord readable3 = readable(firstStateRecord, mutableSnapshot2.getId(), mutableSnapshot2.getInvalid$runtime_release());
                if (readable3 != null) {
                    StateRecord mergeRecords = next.mergeRecords(readable, readable2, readable3);
                    if (mergeRecords == null) {
                        return null;
                    }
                    Map map = hashMap;
                    if (map == null) {
                        hashMap = new HashMap();
                        map = hashMap;
                    }
                    map.put(readable2, mergeRecords);
                } else {
                    readError();
                    throw new KotlinNothingValueException();
                }
            }
        }
        return hashMap;
    }

    /* access modifiers changed from: private */
    public static final Void reportReadonlySnapshotWrite() {
        throw new IllegalStateException("Cannot modify a state object in a read-only snapshot".toString());
    }

    public static final <T extends StateRecord> T current(T t, Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(t, JWKParameterNames.RSA_OTHER_PRIMES__PRIME_FACTOR);
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        T readable = readable(t, snapshot.getId(), snapshot.getInvalid$runtime_release());
        if (readable != null) {
            return readable;
        }
        readError();
        throw new KotlinNothingValueException();
    }

    public static final <T extends StateRecord, R> R withCurrent(T t, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        return function1.invoke(current(t, Snapshot.Companion.getCurrent()));
    }

    public static final SnapshotIdSet addRange(SnapshotIdSet snapshotIdSet, int i, int i2) {
        Intrinsics.checkNotNullParameter(snapshotIdSet, "<this>");
        while (i < i2) {
            snapshotIdSet = snapshotIdSet.set(i);
            i++;
        }
        return snapshotIdSet;
    }

    public static final <T extends StateRecord, R> R writable(T t, StateObject stateObject, Snapshot snapshot, Function1<? super T, ? extends R> function1) {
        R invoke;
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(stateObject, PostalAddressParser.REGION_KEY);
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        Intrinsics.checkNotNullParameter(function1, "block");
        synchronized (getLock()) {
            try {
                invoke = function1.invoke(writableRecord(t, stateObject, snapshot));
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
        notifyWrite(snapshot, stateObject);
        return invoke;
    }
}
