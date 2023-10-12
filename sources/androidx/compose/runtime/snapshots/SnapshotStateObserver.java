package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.collection.IdentityScopeMap;
import androidx.compose.runtime.collection.MutableVector;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0007\u0018\u00002\u00020\u0001:\u0001*B.\u0012'\u0010\u0002\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\tJ\b\u0010\u0018\u001a\u00020\u0005H\u0002J\u0006\u0010\u0019\u001a\u00020\u0005J\u000e\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0001J)\u0010\u001b\u001a\u00020\u00052!\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00150\u0003J,\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001e0\f\"\b\b\u0000\u0010\u001e*\u00020\u00012\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\u00050\u0003H\u0002J\u001c\u0010 \u001a\u00020\u00052\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f2\u0006\u0010\"\u001a\u00020\u0010J?\u0010#\u001a\u00020\u0005\"\b\b\u0000\u0010\u001e*\u00020\u00012\u0006\u0010\u001a\u001a\u0002H\u001e2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\u00050\u00032\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010&J\u0006\u0010'\u001a\u00020\u0005J\u0006\u0010(\u001a\u00020\u0005J\u0014\u0010)\u001a\u00020\u00052\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u0018\u0010\n\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\u000bX\u0004¢\u0006\u0002\n\u0000R&\u0010\r\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00050\u000eX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R/\u0010\u0002\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "", "onChangedExecutor", "Lkotlin/Function1;", "Lkotlin/Function0;", "", "Lkotlin/ParameterName;", "name", "callback", "(Lkotlin/jvm/functions/Function1;)V", "applyMaps", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver$ApplyMap;", "applyObserver", "Lkotlin/Function2;", "", "Landroidx/compose/runtime/snapshots/Snapshot;", "applyUnsubscribe", "Landroidx/compose/runtime/snapshots/ObserverHandle;", "currentMap", "isObserving", "", "isPaused", "readObserver", "callOnChanged", "clear", "scope", "clearIf", "predicate", "ensureMap", "T", "onChanged", "notifyChanges", "changes", "snapshot", "observeReads", "onValueChangedForScope", "block", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "start", "stop", "withNoObservations", "ApplyMap", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SnapshotStateObserver.kt */
public final class SnapshotStateObserver {
    public static final int $stable = 8;
    /* access modifiers changed from: private */
    public final MutableVector<ApplyMap<?>> applyMaps = new MutableVector<>(new ApplyMap[16], 0);
    private final Function2<Set<? extends Object>, Snapshot, Unit> applyObserver = new SnapshotStateObserver$applyObserver$1(this);
    private ObserverHandle applyUnsubscribe;
    /* access modifiers changed from: private */
    public ApplyMap<?> currentMap;
    private boolean isObserving;
    /* access modifiers changed from: private */
    public boolean isPaused;
    /* access modifiers changed from: private */
    public final Function1<Function0<Unit>, Unit> onChangedExecutor;
    private final Function1<Object, Unit> readObserver = new SnapshotStateObserver$readObserver$1(this);

    public SnapshotStateObserver(Function1<? super Function0<Unit>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onChangedExecutor");
        this.onChangedExecutor = function1;
    }

    /* JADX INFO: finally extract failed */
    public final <T> void observeReads(T t, Function1<? super T, Unit> function1, Function0<Unit> function0) {
        ApplyMap<T> ensureMap;
        T t2 = t;
        Function1<? super T, Unit> function12 = function1;
        Function0<Unit> function02 = function0;
        Intrinsics.checkNotNullParameter(t2, "scope");
        Intrinsics.checkNotNullParameter(function12, "onValueChangedForScope");
        Intrinsics.checkNotNullParameter(function02, "block");
        ApplyMap<?> applyMap = this.currentMap;
        boolean z = this.isPaused;
        synchronized (this.applyMaps) {
            try {
                ensureMap = ensureMap(function12);
            } catch (Throwable th) {
                throw th;
            }
        }
        T currentScope = ensureMap.getCurrentScope();
        ensureMap.setCurrentScope(t2);
        this.currentMap = ensureMap;
        this.isPaused = false;
        synchronized (this.applyMaps) {
            IdentityScopeMap<T> map = ensureMap.getMap();
            int size = map.getSize();
            int i = 0;
            int i2 = 0;
            while (i < size) {
                int i3 = i + 1;
                int i4 = map.getValueOrder()[i];
                IdentityArraySet identityArraySet = map.getScopeSets()[i4];
                Intrinsics.checkNotNull(identityArraySet);
                int size2 = identityArraySet.size();
                int i5 = size;
                int i6 = 0;
                int i7 = 0;
                while (i7 < size2) {
                    int i8 = i7 + 1;
                    int i9 = size2;
                    T t3 = identityArraySet.getValues()[i7];
                    if (t3 != null) {
                        if (!(t3 == t2)) {
                            if (i6 != i7) {
                                identityArraySet.getValues()[i6] = t3;
                            }
                            i6++;
                        }
                        i7 = i8;
                        size2 = i9;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                    }
                }
                int size3 = identityArraySet.size();
                for (int i10 = i6; i10 < size3; i10++) {
                    identityArraySet.getValues()[i10] = null;
                }
                identityArraySet.setSize(i6);
                if (identityArraySet.size() > 0) {
                    if (i2 != i) {
                        int i11 = map.getValueOrder()[i2];
                        map.getValueOrder()[i2] = i4;
                        map.getValueOrder()[i] = i11;
                    }
                    i2++;
                }
                i = i3;
                size = i5;
            }
            int size4 = map.getSize();
            for (int i12 = i2; i12 < size4; i12++) {
                map.getValues()[map.getValueOrder()[i12]] = null;
            }
            map.setSize(i2);
            Unit unit = Unit.INSTANCE;
        }
        if (!this.isObserving) {
            this.isObserving = true;
            try {
                Snapshot.Companion.observe(this.readObserver, (Function1<Object, Unit>) null, function02);
            } finally {
                this.isObserving = false;
            }
        } else {
            function0.invoke();
        }
        this.currentMap = applyMap;
        ensureMap.setCurrentScope(currentScope);
        this.isPaused = z;
    }

    public final void withNoObservations(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        boolean z = this.isPaused;
        this.isPaused = true;
        try {
            function0.invoke();
        } finally {
            this.isPaused = z;
        }
    }

    public final void clear(Object obj) {
        Object obj2 = obj;
        Intrinsics.checkNotNullParameter(obj2, "scope");
        synchronized (this.applyMaps) {
            MutableVector<ApplyMap<?>> mutableVector = this.applyMaps;
            int size = mutableVector.getSize();
            if (size > 0) {
                Object[] content = mutableVector.getContent();
                int i = 0;
                while (true) {
                    IdentityScopeMap map = ((ApplyMap) content[i]).getMap();
                    int size2 = map.getSize();
                    int i2 = 0;
                    int i3 = 0;
                    while (i2 < size2) {
                        int i4 = i2 + 1;
                        int i5 = map.getValueOrder()[i2];
                        IdentityArraySet identityArraySet = map.getScopeSets()[i5];
                        Intrinsics.checkNotNull(identityArraySet);
                        int size3 = identityArraySet.size();
                        int i6 = 0;
                        int i7 = 0;
                        while (i6 < size3) {
                            int i8 = i6 + 1;
                            Object obj3 = identityArraySet.getValues()[i6];
                            if (obj3 != null) {
                                if (!(obj3 == obj2)) {
                                    if (i7 != i6) {
                                        identityArraySet.getValues()[i7] = obj3;
                                    }
                                    i7++;
                                }
                                i6 = i8;
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                            }
                        }
                        int size4 = identityArraySet.size();
                        for (int i9 = i7; i9 < size4; i9++) {
                            identityArraySet.getValues()[i9] = null;
                        }
                        identityArraySet.setSize(i7);
                        if (identityArraySet.size() > 0) {
                            if (i3 != i2) {
                                int i10 = map.getValueOrder()[i3];
                                map.getValueOrder()[i3] = i5;
                                map.getValueOrder()[i2] = i10;
                            }
                            i3++;
                        }
                        i2 = i4;
                    }
                    int size5 = map.getSize();
                    for (int i11 = i3; i11 < size5; i11++) {
                        map.getValues()[map.getValueOrder()[i11]] = null;
                    }
                    map.setSize(i3);
                    i++;
                    if (i >= size) {
                        break;
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void clearIf(Function1<Object, Boolean> function1) {
        Function1<Object, Boolean> function12 = function1;
        Intrinsics.checkNotNullParameter(function12, "predicate");
        synchronized (this.applyMaps) {
            MutableVector<ApplyMap<?>> mutableVector = this.applyMaps;
            int size = mutableVector.getSize();
            if (size > 0) {
                Object[] content = mutableVector.getContent();
                int i = 0;
                while (true) {
                    IdentityScopeMap map = ((ApplyMap) content[i]).getMap();
                    int size2 = map.getSize();
                    int i2 = 0;
                    int i3 = 0;
                    while (i2 < size2) {
                        int i4 = i2 + 1;
                        int i5 = map.getValueOrder()[i2];
                        IdentityArraySet identityArraySet = map.getScopeSets()[i5];
                        Intrinsics.checkNotNull(identityArraySet);
                        int size3 = identityArraySet.size();
                        int i6 = 0;
                        int i7 = 0;
                        while (i6 < size3) {
                            int i8 = i6 + 1;
                            Object obj = identityArraySet.getValues()[i6];
                            if (obj != null) {
                                if (!function12.invoke(obj).booleanValue()) {
                                    if (i7 != i6) {
                                        identityArraySet.getValues()[i7] = obj;
                                    }
                                    i7++;
                                }
                                i6 = i8;
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                            }
                        }
                        int size4 = identityArraySet.size();
                        for (int i9 = i7; i9 < size4; i9++) {
                            identityArraySet.getValues()[i9] = null;
                        }
                        identityArraySet.setSize(i7);
                        if (identityArraySet.size() > 0) {
                            if (i3 != i2) {
                                int i10 = map.getValueOrder()[i3];
                                map.getValueOrder()[i3] = i5;
                                map.getValueOrder()[i2] = i10;
                            }
                            i3++;
                        }
                        i2 = i4;
                    }
                    int size5 = map.getSize();
                    for (int i11 = i3; i11 < size5; i11++) {
                        map.getValues()[map.getValueOrder()[i11]] = null;
                    }
                    map.setSize(i3);
                    i++;
                    if (i >= size) {
                        break;
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void start() {
        this.applyUnsubscribe = Snapshot.Companion.registerApplyObserver(this.applyObserver);
    }

    public final void stop() {
        ObserverHandle observerHandle = this.applyUnsubscribe;
        if (observerHandle != null) {
            observerHandle.dispose();
        }
    }

    public final void notifyChanges(Set<? extends Object> set, Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(set, "changes");
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        this.applyObserver.invoke(set, snapshot);
    }

    public final void clear() {
        synchronized (this.applyMaps) {
            MutableVector<ApplyMap<?>> mutableVector = this.applyMaps;
            int size = mutableVector.getSize();
            if (size > 0) {
                int i = 0;
                Object[] content = mutableVector.getContent();
                do {
                    ((ApplyMap) content[i]).getMap().clear();
                    i++;
                } while (i < size);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* access modifiers changed from: private */
    public final void callOnChanged() {
        MutableVector<ApplyMap<?>> mutableVector = this.applyMaps;
        int size = mutableVector.getSize();
        if (size > 0) {
            int i = 0;
            Object[] content = mutableVector.getContent();
            do {
                ApplyMap applyMap = (ApplyMap) content[i];
                HashSet<Object> invalidated = applyMap.getInvalidated();
                Collection collection = invalidated;
                if (!collection.isEmpty()) {
                    applyMap.callOnChanged(collection);
                    invalidated.clear();
                }
                i++;
            } while (i < size);
        }
    }

    private final <T> ApplyMap<T> ensureMap(Function1<? super T, Unit> function1) {
        int i;
        MutableVector<ApplyMap<?>> mutableVector = this.applyMaps;
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            i = 0;
            while (true) {
                if (((ApplyMap) content[i]).getOnChanged() == function1) {
                    break;
                }
                i++;
                if (i >= size) {
                    break;
                }
            }
        } else {
            i = -1;
        }
        if (i != -1) {
            return (ApplyMap) this.applyMaps.getContent()[i];
        }
        ApplyMap<T> applyMap = new ApplyMap<>(function1);
        this.applyMaps.add(applyMap);
        return applyMap;
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u001e\n\u0000\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0002J\u0014\u0010\u001a\u001a\u00020\u00052\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u001cR\u001e\u0010\u0007\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR!\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u000ej\b\u0012\u0004\u0012\u00020\u0002`\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001d"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateObserver$ApplyMap;", "T", "", "onChanged", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "currentScope", "getCurrentScope", "()Ljava/lang/Object;", "setCurrentScope", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "invalidated", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getInvalidated", "()Ljava/util/HashSet;", "map", "Landroidx/compose/runtime/collection/IdentityScopeMap;", "getMap", "()Landroidx/compose/runtime/collection/IdentityScopeMap;", "getOnChanged", "()Lkotlin/jvm/functions/Function1;", "addValue", "value", "callOnChanged", "scopes", "", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SnapshotStateObserver.kt */
    private static final class ApplyMap<T> {
        private T currentScope;
        private final HashSet<Object> invalidated = new HashSet<>();
        private final IdentityScopeMap<T> map = new IdentityScopeMap<>();
        private final Function1<T, Unit> onChanged;

        public ApplyMap(Function1<? super T, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "onChanged");
            this.onChanged = function1;
        }

        public final Function1<T, Unit> getOnChanged() {
            return this.onChanged;
        }

        public final IdentityScopeMap<T> getMap() {
            return this.map;
        }

        public final HashSet<Object> getInvalidated() {
            return this.invalidated;
        }

        public final T getCurrentScope() {
            return this.currentScope;
        }

        public final void setCurrentScope(T t) {
            this.currentScope = t;
        }

        public final void addValue(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "value");
            IdentityScopeMap<T> identityScopeMap = this.map;
            T t = this.currentScope;
            Intrinsics.checkNotNull(t);
            identityScopeMap.add(obj, t);
        }

        public final void callOnChanged(Collection<? extends Object> collection) {
            Intrinsics.checkNotNullParameter(collection, "scopes");
            for (Object invoke : collection) {
                getOnChanged().invoke(invoke);
            }
        }
    }
}
