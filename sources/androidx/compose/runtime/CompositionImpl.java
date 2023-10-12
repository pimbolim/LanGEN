package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArrayMap;
import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.collection.IdentityScopeMap;
import androidx.compose.runtime.snapshots.StateObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0000\u0018\u00002\u00020\u0001:\u0001eB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010E\u001a\u00020\u001b2\f\u0010F\u001a\b\u0012\u0004\u0012\u0002030GH\u0002J\b\u0010H\u001a\u00020\u001bH\u0016J \u0010I\u001a\u00020\u001b2\u0011\u0010J\u001a\r\u0012\u0004\u0012\u00020\u001b0\u001e¢\u0006\u0002\b\u001fH\u0016¢\u0006\u0002\u0010#J\b\u0010K\u001a\u00020\u001bH\u0016J\b\u0010L\u001a\u00020\u001bH\u0002J\b\u0010M\u001a\u00020\u001bH\u0002J\u0018\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u0002012\b\u0010Q\u001a\u0004\u0018\u000103J\b\u0010R\u001a\u00020\u001bH\u0016J\u0010\u0010S\u001a\u00020\u001b2\u0006\u0010T\u001a\u000203H\u0002J\u0016\u0010U\u001a\u00020\u000f2\f\u0010F\u001a\b\u0012\u0004\u0012\u0002030GH\u0016J\u0016\u0010V\u001a\u00020\u001b2\f\u0010W\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001eH\u0016J\b\u0010X\u001a\u00020\u000fH\u0016J\u0016\u0010Y\u001a\u00020\u001b2\f\u0010F\u001a\b\u0012\u0004\u0012\u0002030GH\u0016J\u0010\u0010Z\u001a\u00020\u001b2\u0006\u0010T\u001a\u000203H\u0016J\u0010\u0010[\u001a\u00020\u001b2\u0006\u0010T\u001a\u000203H\u0016J\u001d\u0010\\\u001a\u00020\u001b2\u0006\u0010Q\u001a\u0002032\u0006\u0010P\u001a\u000201H\u0000¢\u0006\u0002\b]J \u0010^\u001a\u00020\u001b2\u0011\u0010J\u001a\r\u0012\u0004\u0012\u00020\u001b0\u001e¢\u0006\u0002\b\u001fH\u0016¢\u0006\u0002\u0010#J\u001c\u0010_\u001a\u0016\u0012\u0004\u0012\u000201\u0012\f\u0012\n\u0012\u0004\u0012\u000203\u0018\u00010200H\u0002J\"\u0010`\u001a\u0002Ha\"\u0004\b\u0000\u0010a2\f\u0010W\u001a\b\u0012\u0004\u0012\u0002Ha0\u001eH\b¢\u0006\u0002\u0010bJ\u0010\u0010c\u001a\u00020\u001b2\u0006\u0010C\u001a\u00020DH\u0002J\b\u0010d\u001a\u00020\u001bH\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011Ra\u0010\u0012\u001aU\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0005¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b0\u0014j\u0002`\u001c0\u0013X\u0004¢\u0006\u0002\n\u0000R'\u0010\u001d\u001a\r\u0012\u0004\u0012\u00020\u001b0\u001e¢\u0006\u0002\b\u001fX\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010%\u001a\u00020&X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010'\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030)0(X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\u00020\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\u0011R\u0014\u0010-\u001a\u00020\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u0011R\"\u0010/\u001a\u0016\u0012\u0004\u0012\u000201\u0012\f\u0012\n\u0012\u0004\u0012\u000203\u0018\u00010200X\u000e¢\u0006\u0002\n\u0000R\u0014\u00104\u001a\u00020\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b4\u0010\u0011R\u0014\u00105\u001a\u00020\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b5\u0010\u0011R\u0011\u00106\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u0011R\u000e\u00107\u001a\u000203X\u0004¢\u0006\u0002\n\u0000R\u0014\u00108\u001a\b\u0012\u0004\u0012\u0002010(X\u0004¢\u0006\u0002\n\u0000R\u0014\u00109\u001a\b\u0012\u0004\u0012\u0002010(X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010:\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0011\"\u0004\b<\u0010=R\"\u0010>\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u0001030?j\n\u0012\u0006\u0012\u0004\u0018\u000103`@X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\bA\u0010BR\u000e\u0010C\u001a\u00020DX\u0004¢\u0006\u0002\n\u0000¨\u0006f"}, d2 = {"Landroidx/compose/runtime/CompositionImpl;", "Landroidx/compose/runtime/ControlledComposition;", "parent", "Landroidx/compose/runtime/CompositionContext;", "applier", "Landroidx/compose/runtime/Applier;", "recomposeContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroidx/compose/runtime/CompositionContext;Landroidx/compose/runtime/Applier;Lkotlin/coroutines/CoroutineContext;)V", "_recomposeContext", "abandonSet", "Ljava/util/HashSet;", "Landroidx/compose/runtime/RememberObserver;", "Lkotlin/collections/HashSet;", "areChildrenComposing", "", "getAreChildrenComposing", "()Z", "changes", "", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "", "Landroidx/compose/runtime/Change;", "composable", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "getComposable", "()Lkotlin/jvm/functions/Function2;", "setComposable", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "composer", "Landroidx/compose/runtime/ComposerImpl;", "derivedStates", "Landroidx/compose/runtime/collection/IdentityScopeMap;", "Landroidx/compose/runtime/DerivedState;", "disposed", "hasInvalidations", "getHasInvalidations", "hasPendingChanges", "getHasPendingChanges", "invalidations", "Landroidx/compose/runtime/collection/IdentityArrayMap;", "Landroidx/compose/runtime/RecomposeScopeImpl;", "Landroidx/compose/runtime/collection/IdentityArraySet;", "", "isComposing", "isDisposed", "isRoot", "lock", "observations", "observationsProcessed", "pendingInvalidScopes", "getPendingInvalidScopes$runtime_release", "setPendingInvalidScopes$runtime_release", "(Z)V", "pendingModifications", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/runtime/AtomicReference;", "getRecomposeContext", "()Lkotlin/coroutines/CoroutineContext;", "slotTable", "Landroidx/compose/runtime/SlotTable;", "addPendingInvalidationsLocked", "values", "", "applyChanges", "composeContent", "content", "dispose", "drainPendingModificationsForCompositionLocked", "drainPendingModificationsLocked", "invalidate", "Landroidx/compose/runtime/InvalidationResult;", "scope", "instance", "invalidateAll", "invalidateScopeOfLocked", "value", "observesAnyOf", "prepareCompose", "block", "recompose", "recordModificationsOf", "recordReadOf", "recordWriteOf", "removeObservation", "removeObservation$runtime_release", "setContent", "takeInvalidations", "trackAbandonedValues", "T", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "validateRecomposeScopeAnchors", "verifyConsistent", "RememberEventDispatcher", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Composition.kt */
public final class CompositionImpl implements ControlledComposition {
    private final CoroutineContext _recomposeContext;
    private final HashSet<RememberObserver> abandonSet;
    private final Applier<?> applier;
    private final List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> changes;
    private Function2<? super Composer, ? super Integer, Unit> composable;
    private final ComposerImpl composer;
    private final IdentityScopeMap<DerivedState<?>> derivedStates;
    private boolean disposed;
    private IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> invalidations;
    private final boolean isRoot;
    private final Object lock;
    private final IdentityScopeMap<RecomposeScopeImpl> observations;
    private final IdentityScopeMap<RecomposeScopeImpl> observationsProcessed;
    private final CompositionContext parent;
    private boolean pendingInvalidScopes;
    private final AtomicReference<Object> pendingModifications;
    private final SlotTable slotTable;

    public CompositionImpl(CompositionContext compositionContext, Applier<?> applier2, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(compositionContext, "parent");
        Intrinsics.checkNotNullParameter(applier2, "applier");
        this.parent = compositionContext;
        this.applier = applier2;
        this.pendingModifications = new AtomicReference<>((Object) null);
        this.lock = new Object();
        HashSet<RememberObserver> hashSet = new HashSet<>();
        this.abandonSet = hashSet;
        SlotTable slotTable2 = new SlotTable();
        this.slotTable = slotTable2;
        this.observations = new IdentityScopeMap<>();
        this.derivedStates = new IdentityScopeMap<>();
        List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> arrayList = new ArrayList<>();
        this.changes = arrayList;
        this.observationsProcessed = new IdentityScopeMap<>();
        this.invalidations = new IdentityArrayMap<>(0, 1, (DefaultConstructorMarker) null);
        ComposerImpl composerImpl = new ComposerImpl(applier2, compositionContext, slotTable2, hashSet, arrayList, this);
        compositionContext.registerComposer$runtime_release(composerImpl);
        this.composer = composerImpl;
        this._recomposeContext = coroutineContext;
        this.isRoot = compositionContext instanceof Recomposer;
        this.composable = ComposableSingletons$CompositionKt.INSTANCE.m1222getLambda1$runtime_release();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CompositionImpl(CompositionContext compositionContext, Applier applier2, CoroutineContext coroutineContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(compositionContext, applier2, (i & 4) != 0 ? null : coroutineContext);
    }

    public final boolean getPendingInvalidScopes$runtime_release() {
        return this.pendingInvalidScopes;
    }

    public final void setPendingInvalidScopes$runtime_release(boolean z) {
        this.pendingInvalidScopes = z;
    }

    public final CoroutineContext getRecomposeContext() {
        CoroutineContext coroutineContext = this._recomposeContext;
        return coroutineContext == null ? this.parent.getRecomposeCoroutineContext$runtime_release() : coroutineContext;
    }

    public final boolean isRoot() {
        return this.isRoot;
    }

    private final boolean getAreChildrenComposing() {
        return this.composer.getAreChildrenComposing$runtime_release();
    }

    public final Function2<Composer, Integer, Unit> getComposable() {
        return this.composable;
    }

    public final void setComposable(Function2<? super Composer, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        this.composable = function2;
    }

    public boolean isComposing() {
        return this.composer.isComposing$runtime_release();
    }

    public boolean isDisposed() {
        return this.disposed;
    }

    public boolean getHasPendingChanges() {
        boolean hasPendingChanges$runtime_release;
        synchronized (this.lock) {
            hasPendingChanges$runtime_release = this.composer.getHasPendingChanges$runtime_release();
        }
        return hasPendingChanges$runtime_release;
    }

    public void setContent(Function2<? super Composer, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "content");
        if (!this.disposed) {
            this.composable = function2;
            this.parent.composeInitial$runtime_release(this, function2);
            return;
        }
        throw new IllegalStateException("The composition is disposed".toString());
    }

    private final void drainPendingModificationsForCompositionLocked() {
        Object andSet = this.pendingModifications.getAndSet(CompositionKt.PendingApplyNoModifications);
        if (andSet != null) {
            if (Intrinsics.areEqual(andSet, CompositionKt.PendingApplyNoModifications)) {
                throw new IllegalStateException("pending composition has not been applied".toString());
            } else if (andSet instanceof Set) {
                addPendingInvalidationsLocked((Set) andSet);
            } else if (andSet instanceof Object[]) {
                Set[] setArr = (Set[]) andSet;
                int i = 0;
                int length = setArr.length;
                while (i < length) {
                    Set set = setArr[i];
                    i++;
                    addPendingInvalidationsLocked(set);
                }
            } else {
                throw new IllegalStateException(Intrinsics.stringPlus("corrupt pendingModifications drain: ", this.pendingModifications).toString());
            }
        }
    }

    private final void drainPendingModificationsLocked() {
        Object andSet = this.pendingModifications.getAndSet((Object) null);
        if (!Intrinsics.areEqual(andSet, CompositionKt.PendingApplyNoModifications)) {
            if (andSet instanceof Set) {
                addPendingInvalidationsLocked((Set) andSet);
            } else if (andSet instanceof Object[]) {
                Set[] setArr = (Set[]) andSet;
                int i = 0;
                int length = setArr.length;
                while (i < length) {
                    Set set = setArr[i];
                    i++;
                    addPendingInvalidationsLocked(set);
                }
            } else if (andSet == null) {
                throw new IllegalStateException("calling recordModificationsOf and applyChanges concurrently is not supported".toString());
            } else {
                throw new IllegalStateException(Intrinsics.stringPlus("corrupt pendingModifications drain: ", this.pendingModifications).toString());
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001d, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0028, code lost:
        if ((!r3.abandonSet.isEmpty()) != false) goto L_0x002a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002a, code lost:
        new androidx.compose.runtime.CompositionImpl.RememberEventDispatcher(r3.abandonSet).dispatchAbandons();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0036, code lost:
        throw r4;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void composeContent(kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r4) {
        /*
            r3 = this;
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.Object r0 = r3.lock     // Catch:{ all -> 0x001d }
            monitor-enter(r0)     // Catch:{ all -> 0x001d }
            r3.drainPendingModificationsForCompositionLocked()     // Catch:{ all -> 0x001a }
            androidx.compose.runtime.ComposerImpl r1 = r3.composer     // Catch:{ all -> 0x001a }
            androidx.compose.runtime.collection.IdentityArrayMap r2 = r3.takeInvalidations()     // Catch:{ all -> 0x001a }
            r1.composeContent$runtime_release(r2, r4)     // Catch:{ all -> 0x001a }
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x001a }
            monitor-exit(r0)     // Catch:{ all -> 0x001d }
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x001d }
            return
        L_0x001a:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001d }
            throw r4     // Catch:{ all -> 0x001d }
        L_0x001d:
            r4 = move-exception
            java.util.HashSet<androidx.compose.runtime.RememberObserver> r0 = r3.abandonSet
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ 1
            if (r0 == 0) goto L_0x0036
            androidx.compose.runtime.CompositionImpl$RememberEventDispatcher r0 = new androidx.compose.runtime.CompositionImpl$RememberEventDispatcher
            java.util.HashSet<androidx.compose.runtime.RememberObserver> r1 = r3.abandonSet
            java.util.Set r1 = (java.util.Set) r1
            r0.<init>(r1)
            r0.dispatchAbandons()
        L_0x0036:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.composeContent(kotlin.jvm.functions.Function2):void");
    }

    /* JADX INFO: finally extract failed */
    public void dispose() {
        synchronized (this.lock) {
            if (!this.disposed) {
                this.disposed = true;
                setComposable(ComposableSingletons$CompositionKt.INSTANCE.m1223getLambda2$runtime_release());
                boolean z = this.slotTable.getGroupsSize() > 0;
                if (z || (true ^ this.abandonSet.isEmpty())) {
                    RememberEventDispatcher rememberEventDispatcher = new RememberEventDispatcher(this.abandonSet);
                    if (z) {
                        SlotWriter openWriter = this.slotTable.openWriter();
                        try {
                            ComposerKt.removeCurrentGroup(openWriter, rememberEventDispatcher);
                            Unit unit = Unit.INSTANCE;
                            openWriter.close();
                            this.applier.clear();
                            rememberEventDispatcher.dispatchRememberObservers();
                        } catch (Throwable th) {
                            openWriter.close();
                            throw th;
                        }
                    }
                    rememberEventDispatcher.dispatchAbandons();
                }
                this.composer.dispose$runtime_release();
            }
            Unit unit2 = Unit.INSTANCE;
        }
        this.parent.unregisterComposition$runtime_release(this);
    }

    public boolean getHasInvalidations() {
        boolean z;
        synchronized (this.lock) {
            z = this.invalidations.getSize$runtime_release() > 0;
        }
        return z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.util.Set<? extends java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.util.Set<? extends java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.util.Set<? extends java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: java.util.Set<? extends java.lang.Object>} */
    /* JADX WARNING: type inference failed for: r2v5, types: [java.util.Set[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void recordModificationsOf(java.util.Set<? extends java.lang.Object> r6) {
        /*
            r5 = this;
            java.lang.String r0 = "values"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
        L_0x0006:
            java.util.concurrent.atomic.AtomicReference<java.lang.Object> r0 = r5.pendingModifications
            java.lang.Object r0 = r0.get()
            r1 = 1
            if (r0 != 0) goto L_0x0011
            r2 = 1
            goto L_0x0019
        L_0x0011:
            java.lang.Object r2 = androidx.compose.runtime.CompositionKt.PendingApplyNoModifications
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r2)
        L_0x0019:
            if (r2 == 0) goto L_0x001d
            r2 = r6
            goto L_0x003d
        L_0x001d:
            boolean r2 = r0 instanceof java.util.Set
            if (r2 == 0) goto L_0x002d
            r2 = 2
            java.util.Set[] r2 = new java.util.Set[r2]
            r3 = 0
            r4 = r0
            java.util.Set r4 = (java.util.Set) r4
            r2[r3] = r4
            r2[r1] = r6
            goto L_0x003d
        L_0x002d:
            boolean r1 = r0 instanceof java.lang.Object[]
            if (r1 == 0) goto L_0x0055
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Array<kotlin.collections.Set<kotlin.Any>>"
            java.util.Objects.requireNonNull(r0, r1)
            r1 = r0
            java.util.Set[] r1 = (java.util.Set[]) r1
            java.lang.Object[] r2 = kotlin.collections.ArraysKt.plus((T[]) r1, r6)
        L_0x003d:
            java.util.concurrent.atomic.AtomicReference<java.lang.Object> r1 = r5.pendingModifications
            boolean r1 = r1.compareAndSet(r0, r2)
            if (r1 == 0) goto L_0x0006
            if (r0 != 0) goto L_0x0054
            java.lang.Object r6 = r5.lock
            monitor-enter(r6)
            r5.drainPendingModificationsLocked()     // Catch:{ all -> 0x0051 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0051 }
            monitor-exit(r6)
            goto L_0x0054
        L_0x0051:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        L_0x0054:
            return
        L_0x0055:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "corrupt pendingModifications: "
            java.util.concurrent.atomic.AtomicReference<java.lang.Object> r1 = r5.pendingModifications
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r0, r1)
            java.lang.String r0 = r0.toString()
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.recordModificationsOf(java.util.Set):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0010  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean observesAnyOf(java.util.Set<? extends java.lang.Object> r3) {
        /*
            r2 = this;
            java.lang.String r0 = "values"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.util.Iterator r3 = r3.iterator()
        L_0x000a:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x0026
            java.lang.Object r0 = r3.next()
            androidx.compose.runtime.collection.IdentityScopeMap<androidx.compose.runtime.RecomposeScopeImpl> r1 = r2.observations
            boolean r1 = r1.contains(r0)
            if (r1 != 0) goto L_0x0024
            androidx.compose.runtime.collection.IdentityScopeMap<androidx.compose.runtime.DerivedState<?>> r1 = r2.derivedStates
            boolean r0 = r1.contains(r0)
            if (r0 == 0) goto L_0x000a
        L_0x0024:
            r3 = 1
            return r3
        L_0x0026:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.observesAnyOf(java.util.Set):boolean");
    }

    public void prepareCompose(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        this.composer.prepareCompose$runtime_release(function0);
    }

    private final void addPendingInvalidationsLocked(Set<? extends Object> set) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        for (Object next : set) {
            if (next instanceof RecomposeScopeImpl) {
                ((RecomposeScopeImpl) next).invalidateForResult((Object) null);
            } else {
                addPendingInvalidationsLocked$invalidate(this, objectRef, next);
                IdentityScopeMap<DerivedState<?>> identityScopeMap = this.derivedStates;
                int access$find = identityScopeMap.find(next);
                if (access$find >= 0) {
                    for (DerivedState addPendingInvalidationsLocked$invalidate : identityScopeMap.scopeSetAt(access$find)) {
                        addPendingInvalidationsLocked$invalidate(this, objectRef, addPendingInvalidationsLocked$invalidate);
                    }
                }
            }
        }
        HashSet hashSet = (HashSet) objectRef.element;
        if (hashSet != null) {
            IdentityScopeMap<RecomposeScopeImpl> identityScopeMap2 = this.observations;
            int size = identityScopeMap2.getSize();
            int i = 0;
            int i2 = 0;
            while (i < size) {
                int i3 = i + 1;
                int i4 = identityScopeMap2.getValueOrder()[i];
                IdentityArraySet identityArraySet = identityScopeMap2.getScopeSets()[i4];
                Intrinsics.checkNotNull(identityArraySet);
                int size2 = identityArraySet.size();
                int i5 = 0;
                int i6 = 0;
                while (i5 < size2) {
                    int i7 = i5 + 1;
                    Object obj = identityArraySet.getValues()[i5];
                    Objects.requireNonNull(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                    if (!hashSet.contains((RecomposeScopeImpl) obj)) {
                        if (i6 != i5) {
                            identityArraySet.getValues()[i6] = obj;
                        }
                        i6++;
                    }
                    i5 = i7;
                }
                int size3 = identityArraySet.size();
                for (int i8 = i6; i8 < size3; i8++) {
                    identityArraySet.getValues()[i8] = null;
                }
                identityArraySet.setSize(i6);
                if (identityArraySet.size() > 0) {
                    if (i2 != i) {
                        int i9 = identityScopeMap2.getValueOrder()[i2];
                        identityScopeMap2.getValueOrder()[i2] = i4;
                        identityScopeMap2.getValueOrder()[i] = i9;
                    }
                    i2++;
                }
                i = i3;
            }
            int size4 = identityScopeMap2.getSize();
            for (int i10 = i2; i10 < size4; i10++) {
                identityScopeMap2.getValues()[identityScopeMap2.getValueOrder()[i10]] = null;
            }
            identityScopeMap2.setSize(i2);
        }
    }

    private static final void addPendingInvalidationsLocked$invalidate(CompositionImpl compositionImpl, Ref.ObjectRef<HashSet<RecomposeScopeImpl>> objectRef, Object obj) {
        IdentityScopeMap<RecomposeScopeImpl> identityScopeMap = compositionImpl.observations;
        int access$find = identityScopeMap.find(obj);
        if (access$find >= 0) {
            for (RecomposeScopeImpl recomposeScopeImpl : identityScopeMap.scopeSetAt(access$find)) {
                if (!compositionImpl.observationsProcessed.remove(obj, recomposeScopeImpl) && recomposeScopeImpl.invalidateForResult(obj) != InvalidationResult.IGNORED) {
                    T t = (HashSet) objectRef.element;
                    if (t == null) {
                        t = new HashSet();
                        objectRef.element = t;
                    }
                    t.add(recomposeScopeImpl);
                }
            }
        }
    }

    public void recordReadOf(Object obj) {
        RecomposeScopeImpl currentRecomposeScope$runtime_release;
        Intrinsics.checkNotNullParameter(obj, "value");
        if (!getAreChildrenComposing() && (currentRecomposeScope$runtime_release = this.composer.getCurrentRecomposeScope$runtime_release()) != null) {
            currentRecomposeScope$runtime_release.setUsed(true);
            this.observations.add(obj, currentRecomposeScope$runtime_release);
            if (obj instanceof DerivedState) {
                for (StateObject add : ((DerivedState) obj).getDependencies()) {
                    this.derivedStates.add(add, obj);
                }
            }
            currentRecomposeScope$runtime_release.recordRead(obj);
        }
    }

    private final void invalidateScopeOfLocked(Object obj) {
        IdentityScopeMap<RecomposeScopeImpl> identityScopeMap = this.observations;
        int access$find = identityScopeMap.find(obj);
        if (access$find >= 0) {
            for (RecomposeScopeImpl recomposeScopeImpl : identityScopeMap.scopeSetAt(access$find)) {
                if (recomposeScopeImpl.invalidateForResult(obj) == InvalidationResult.IMMINENT) {
                    this.observationsProcessed.add(obj, recomposeScopeImpl);
                }
            }
        }
    }

    public void recordWriteOf(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "value");
        synchronized (this.lock) {
            invalidateScopeOfLocked(obj);
            IdentityScopeMap<DerivedState<?>> identityScopeMap = this.derivedStates;
            int access$find = identityScopeMap.find(obj);
            if (access$find >= 0) {
                for (DerivedState invalidateScopeOfLocked : identityScopeMap.scopeSetAt(access$find)) {
                    invalidateScopeOfLocked(invalidateScopeOfLocked);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public boolean recompose() {
        boolean recompose$runtime_release;
        synchronized (this.lock) {
            drainPendingModificationsForCompositionLocked();
            try {
                recompose$runtime_release = this.composer.recompose$runtime_release(takeInvalidations());
                if (!recompose$runtime_release) {
                    drainPendingModificationsLocked();
                }
            } catch (Throwable th) {
                if (!this.abandonSet.isEmpty()) {
                    new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                }
                throw th;
            }
        }
        return recompose$runtime_release;
    }

    public void applyChanges() {
        SlotWriter openWriter;
        synchronized (this.lock) {
            RememberEventDispatcher rememberEventDispatcher = new RememberEventDispatcher(this.abandonSet);
            try {
                this.applier.onBeginChanges();
                openWriter = this.slotTable.openWriter();
                Applier<?> applier2 = this.applier;
                List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> list = this.changes;
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    list.get(i).invoke(applier2, openWriter, rememberEventDispatcher);
                }
                this.changes.clear();
                Unit unit = Unit.INSTANCE;
                openWriter.close();
                this.applier.onEndChanges();
                rememberEventDispatcher.dispatchRememberObservers();
                rememberEventDispatcher.dispatchSideEffects();
                if (getPendingInvalidScopes$runtime_release()) {
                    setPendingInvalidScopes$runtime_release(false);
                    IdentityScopeMap<RecomposeScopeImpl> identityScopeMap = this.observations;
                    int size2 = identityScopeMap.getSize();
                    int i2 = 0;
                    int i3 = 0;
                    while (i2 < size2) {
                        int i4 = i2 + 1;
                        int i5 = identityScopeMap.getValueOrder()[i2];
                        IdentityArraySet identityArraySet = identityScopeMap.getScopeSets()[i5];
                        Intrinsics.checkNotNull(identityArraySet);
                        int size3 = identityArraySet.size();
                        int i6 = 0;
                        int i7 = 0;
                        while (i6 < size3) {
                            int i8 = i6 + 1;
                            Object obj = identityArraySet.getValues()[i6];
                            if (obj != null) {
                                if (!(!((RecomposeScopeImpl) obj).getValid())) {
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
                                int i10 = identityScopeMap.getValueOrder()[i3];
                                identityScopeMap.getValueOrder()[i3] = i5;
                                identityScopeMap.getValueOrder()[i2] = i10;
                            }
                            i3++;
                        }
                        i2 = i4;
                    }
                    int size5 = identityScopeMap.getSize();
                    for (int i11 = i3; i11 < size5; i11++) {
                        identityScopeMap.getValues()[identityScopeMap.getValueOrder()[i11]] = null;
                    }
                    identityScopeMap.setSize(i3);
                    IdentityScopeMap<DerivedState<?>> identityScopeMap2 = this.derivedStates;
                    int size6 = identityScopeMap2.getSize();
                    int i12 = 0;
                    int i13 = 0;
                    while (i12 < size6) {
                        int i14 = i12 + 1;
                        int i15 = identityScopeMap2.getValueOrder()[i12];
                        IdentityArraySet identityArraySet2 = identityScopeMap2.getScopeSets()[i15];
                        Intrinsics.checkNotNull(identityArraySet2);
                        int size7 = identityArraySet2.size();
                        int i16 = 0;
                        int i17 = 0;
                        while (i16 < size7) {
                            int i18 = i16 + 1;
                            Object obj2 = identityArraySet2.getValues()[i16];
                            if (obj2 != null) {
                                if (!(!this.observations.contains((DerivedState) obj2))) {
                                    if (i17 != i16) {
                                        identityArraySet2.getValues()[i17] = obj2;
                                    }
                                    i17++;
                                }
                                i16 = i18;
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                            }
                        }
                        int size8 = identityArraySet2.size();
                        for (int i19 = i17; i19 < size8; i19++) {
                            identityArraySet2.getValues()[i19] = null;
                        }
                        identityArraySet2.setSize(i17);
                        if (identityArraySet2.size() > 0) {
                            if (i13 != i12) {
                                int i20 = identityScopeMap2.getValueOrder()[i13];
                                identityScopeMap2.getValueOrder()[i13] = i15;
                                identityScopeMap2.getValueOrder()[i12] = i20;
                            }
                            i13++;
                        }
                        i12 = i14;
                    }
                    int size9 = identityScopeMap2.getSize();
                    for (int i21 = i13; i21 < size9; i21++) {
                        identityScopeMap2.getValues()[identityScopeMap2.getValueOrder()[i21]] = null;
                    }
                    identityScopeMap2.setSize(i13);
                }
                rememberEventDispatcher.dispatchAbandons();
                drainPendingModificationsLocked();
                Unit unit2 = Unit.INSTANCE;
            } catch (Throwable th) {
                rememberEventDispatcher.dispatchAbandons();
                throw th;
            }
        }
    }

    public void invalidateAll() {
        synchronized (this.lock) {
            Object[] slots = this.slotTable.getSlots();
            int i = 0;
            int length = slots.length;
            while (i < length) {
                Object obj = slots[i];
                i++;
                RecomposeScopeImpl recomposeScopeImpl = obj instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) obj : null;
                if (recomposeScopeImpl != null) {
                    recomposeScopeImpl.invalidate();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public void verifyConsistent() {
        synchronized (this.lock) {
            if (!isComposing()) {
                this.slotTable.verifyWellFormed();
                validateRecomposeScopeAnchors(this.slotTable);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final InvalidationResult invalidate(RecomposeScopeImpl recomposeScopeImpl, Object obj) {
        Intrinsics.checkNotNullParameter(recomposeScopeImpl, "scope");
        if (recomposeScopeImpl.getDefaultsInScope()) {
            recomposeScopeImpl.setDefaultsInvalid(true);
        }
        Anchor anchor = recomposeScopeImpl.getAnchor();
        if (anchor == null || !this.slotTable.ownsAnchor(anchor) || !anchor.getValid()) {
            return InvalidationResult.IGNORED;
        }
        if (anchor.toIndexFor(this.slotTable) < 0) {
            return InvalidationResult.IGNORED;
        }
        if (isComposing() && this.composer.tryImminentInvalidation$runtime_release(recomposeScopeImpl, obj)) {
            return InvalidationResult.IMMINENT;
        }
        if (obj == null) {
            this.invalidations.set(recomposeScopeImpl, null);
        } else {
            CompositionKt.addValue(this.invalidations, recomposeScopeImpl, obj);
        }
        this.parent.invalidate$runtime_release(this);
        return isComposing() ? InvalidationResult.DEFERRED : InvalidationResult.SCHEDULED;
    }

    public final void removeObservation$runtime_release(Object obj, RecomposeScopeImpl recomposeScopeImpl) {
        Intrinsics.checkNotNullParameter(obj, "instance");
        Intrinsics.checkNotNullParameter(recomposeScopeImpl, "scope");
        this.observations.remove(obj, recomposeScopeImpl);
    }

    private final IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> takeInvalidations() {
        IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> identityArrayMap = this.invalidations;
        this.invalidations = new IdentityArrayMap<>(0, 1, (DefaultConstructorMarker) null);
        return identityArrayMap;
    }

    private final void validateRecomposeScopeAnchors(SlotTable slotTable2) {
        Object[] slots = slotTable2.getSlots();
        Collection arrayList = new ArrayList();
        int length = slots.length;
        int i = 0;
        int i2 = 0;
        while (i2 < length) {
            Object obj = slots[i2];
            i2++;
            RecomposeScopeImpl recomposeScopeImpl = obj instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) obj : null;
            if (recomposeScopeImpl != null) {
                arrayList.add(recomposeScopeImpl);
            }
        }
        List list = (List) arrayList;
        int size = list.size();
        while (i < size) {
            int i3 = i + 1;
            RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) list.get(i);
            Anchor anchor = recomposeScopeImpl2.getAnchor();
            if (anchor != null && !slotTable2.slotsOf$runtime_release(anchor.toIndexFor(slotTable2)).contains(recomposeScopeImpl2)) {
                int indexOf = ArraysKt.indexOf((T[]) slotTable2.getSlots(), recomposeScopeImpl2);
                throw new IllegalStateException(("Misaligned anchor " + anchor + " in scope " + recomposeScopeImpl2 + " encountered, scope found at " + indexOf).toString());
            }
            i = i3;
        }
    }

    private final <T> T trackAbandonedValues(Function0<? extends T> function0) {
        try {
            T invoke = function0.invoke();
            InlineMarker.finallyStart(1);
            InlineMarker.finallyEnd(1);
            return invoke;
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            if (!this.abandonSet.isEmpty()) {
                new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
            }
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u000bJ\u0010\u0010\u0006\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\u0016\u0010\u0010\u001a\u00020\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/compose/runtime/CompositionImpl$RememberEventDispatcher;", "Landroidx/compose/runtime/RememberManager;", "abandoning", "", "Landroidx/compose/runtime/RememberObserver;", "(Ljava/util/Set;)V", "forgetting", "", "remembering", "sideEffects", "Lkotlin/Function0;", "", "dispatchAbandons", "dispatchRememberObservers", "dispatchSideEffects", "instance", "sideEffect", "effect", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Composition.kt */
    private static final class RememberEventDispatcher implements RememberManager {
        private final Set<RememberObserver> abandoning;
        private final List<RememberObserver> forgetting = new ArrayList();
        private final List<RememberObserver> remembering = new ArrayList();
        private final List<Function0<Unit>> sideEffects = new ArrayList();

        public RememberEventDispatcher(Set<RememberObserver> set) {
            Intrinsics.checkNotNullParameter(set, "abandoning");
            this.abandoning = set;
        }

        public void remembering(RememberObserver rememberObserver) {
            Intrinsics.checkNotNullParameter(rememberObserver, "instance");
            int lastIndexOf = this.forgetting.lastIndexOf(rememberObserver);
            if (lastIndexOf >= 0) {
                this.forgetting.remove(lastIndexOf);
                this.abandoning.remove(rememberObserver);
                return;
            }
            this.remembering.add(rememberObserver);
        }

        public void forgetting(RememberObserver rememberObserver) {
            Intrinsics.checkNotNullParameter(rememberObserver, "instance");
            int lastIndexOf = this.remembering.lastIndexOf(rememberObserver);
            if (lastIndexOf >= 0) {
                this.remembering.remove(lastIndexOf);
                this.abandoning.remove(rememberObserver);
                return;
            }
            this.forgetting.add(rememberObserver);
        }

        public void sideEffect(Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, "effect");
            this.sideEffects.add(function0);
        }

        public final void dispatchRememberObservers() {
            int i;
            if ((!this.forgetting.isEmpty()) && this.forgetting.size() - 1 >= 0) {
                while (true) {
                    int i2 = i - 1;
                    RememberObserver rememberObserver = this.forgetting.get(i);
                    if (!this.abandoning.contains(rememberObserver)) {
                        rememberObserver.onForgotten();
                    }
                    if (i2 < 0) {
                        break;
                    }
                    i = i2;
                }
            }
            if (!this.remembering.isEmpty()) {
                List<RememberObserver> list = this.remembering;
                int i3 = 0;
                int size = list.size();
                while (i3 < size) {
                    int i4 = i3 + 1;
                    RememberObserver rememberObserver2 = list.get(i3);
                    this.abandoning.remove(rememberObserver2);
                    rememberObserver2.onRemembered();
                    i3 = i4;
                }
            }
        }

        public final void dispatchSideEffects() {
            if (!this.sideEffects.isEmpty()) {
                List<Function0<Unit>> list = this.sideEffects;
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    list.get(i).invoke();
                }
                this.sideEffects.clear();
            }
        }

        public final void dispatchAbandons() {
            if (!this.abandoning.isEmpty()) {
                Iterator<RememberObserver> it = this.abandoning.iterator();
                while (it.hasNext()) {
                    it.remove();
                    it.next().onAbandoned();
                }
            }
        }
    }
}
