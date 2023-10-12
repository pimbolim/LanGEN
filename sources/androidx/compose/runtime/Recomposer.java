package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import androidx.compose.runtime.snapshots.MutableSnapshot;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotApplyResult;
import androidx.compose.runtime.tooling.CompositionData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 \u00012\u00020\u0001:\b\u0001\u0001\u0001\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010E\u001a\u00020D2\u0006\u0010F\u001a\u00020GH\u0002J\u0006\u0010H\u001a\u00020IJ\u0011\u0010J\u001a\u00020DH@ø\u0001\u0000¢\u0006\u0002\u0010KJ\u0011\u0010L\u001a\u00020DH@ø\u0001\u0000¢\u0006\u0002\u0010KJ\u0006\u0010M\u001a\u00020DJ\u0006\u0010N\u001a\u00020DJ*\u0010O\u001a\u00020D2\u0006\u0010P\u001a\u00020\u00172\u0011\u0010Q\u001a\r\u0012\u0004\u0012\u00020D0R¢\u0006\u0002\bSH\u0010¢\u0006\u0004\bT\u0010UJ:\u0010V\u001a\u0002HW\"\u0004\b\u0000\u0010W2\u0006\u0010P\u001a\u00020\u00172\u000e\u0010X\u001a\n\u0012\u0004\u0012\u00020:\u0018\u00010Y2\f\u0010Z\u001a\b\u0012\u0004\u0012\u0002HW0RH\b¢\u0006\u0002\u0010[J\u0010\u0010\\\u001a\n\u0012\u0004\u0012\u00020D\u0018\u00010CH\u0002J\u0015\u0010]\u001a\u00020D2\u0006\u0010P\u001a\u00020\u0017H\u0010¢\u0006\u0002\b^J\u0015\u0010_\u001a\u00020D2\u0006\u0010`\u001a\u00020aH\u0010¢\u0006\u0002\bbJ\u0011\u0010c\u001a\u00020DH@ø\u0001\u0000¢\u0006\u0002\u0010KJ\"\u0010d\u001a\u0004\u0018\u00010\u00172\u0006\u0010P\u001a\u00020\u00172\u000e\u0010X\u001a\n\u0012\u0004\u0012\u00020:\u0018\u00010YH\u0002J\u001c\u0010e\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020D0f2\u0006\u0010P\u001a\u00020\u0017H\u0002JO\u0010g\u001a\u00020D2<\u0010Z\u001a8\b\u0001\u0012\u0004\u0012\u00020i\u0012\u0013\u0012\u00110j¢\u0006\f\bk\u0012\b\bl\u0012\u0004\b\b(m\u0012\n\u0012\b\u0012\u0004\u0012\u00020D0n\u0012\u0006\u0012\u0004\u0018\u00010:0h¢\u0006\u0002\boH@ø\u0001\u0000¢\u0006\u0002\u0010pJ\b\u0010q\u001a\u00020DH\u0002J\u001d\u0010q\u001a\u00020D2\u0012\u0010r\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020D0fH\bJ\u001b\u0010s\u001a\u00020D2\f\u0010t\u001a\b\u0012\u0004\u0012\u00020v0uH\u0010¢\u0006\u0002\bwJ\u0015\u0010x\u001a\u00020D2\u0006\u0010P\u001a\u00020\u0017H\u0010¢\u0006\u0002\byJ\u0010\u0010z\u001a\u00020D2\u0006\u0010{\u001a\u000205H\u0002J!\u0010|\u001a\u00020D2\u0006\u0010m\u001a\u00020j2\u0006\u0010}\u001a\u00020~H@ø\u0001\u0000¢\u0006\u0002\u0010J\u0012\u0010\u0001\u001a\u00020DH@ø\u0001\u0000¢\u0006\u0002\u0010KJ\u001b\u0010\u0001\u001a\u00020D2\u0006\u00100\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J\u0017\u0010\u0001\u001a\u00020D2\u0006\u0010P\u001a\u00020\u0017H\u0010¢\u0006\u0003\b\u0001J-\u0010\u0001\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020D0f2\u0006\u0010P\u001a\u00020\u00172\u000e\u0010X\u001a\n\u0012\u0004\u0012\u00020:\u0018\u00010YH\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128PX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u00020\u001a8PX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\u001f8F¢\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020%X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\u00020\u00128BX\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u0014R\u0014\u0010(\u001a\u00020\u00128BX\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u0014R\u0011\u0010*\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b+\u0010\u0014R\u0014\u0010,\u001a\u00020\u00128BX\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\u0014R\u000e\u0010.\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0004¢\u0006\u0002\n\u0000R\u0014\u00100\u001a\u00020\u00038PX\u0004¢\u0006\u0006\u001a\u0004\b1\u0010#R\u0012\u00102\u001a\u000603R\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u000e¢\u0006\u0002\n\u0000R\u0014\u00106\u001a\u00020\u00128BX\u0004¢\u0006\u0006\u001a\u0004\b7\u0010\u0014R\u001a\u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020:090\u0016X\u0004¢\u0006\u0002\n\u0000R \u0010;\u001a\b\u0012\u0004\u0012\u00020\u00070<8FX\u0004¢\u0006\f\u0012\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u000e\u0010A\u001a\u00020:X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010B\u001a\n\u0012\u0004\u0012\u00020D\u0018\u00010CX\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0001"}, d2 = {"Landroidx/compose/runtime/Recomposer;", "Landroidx/compose/runtime/CompositionContext;", "effectCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/compose/runtime/Recomposer$State;", "broadcastFrameClock", "Landroidx/compose/runtime/BroadcastFrameClock;", "<set-?>", "", "changeCount", "getChangeCount", "()J", "closeCause", "", "collectingParameterInformation", "", "getCollectingParameterInformation$runtime_release", "()Z", "compositionInvalidations", "", "Landroidx/compose/runtime/ControlledComposition;", "compositionsAwaitingApply", "compoundHashKey", "", "getCompoundHashKey$runtime_release", "()I", "concurrentCompositionsOutstanding", "currentState", "Lkotlinx/coroutines/flow/StateFlow;", "getCurrentState", "()Lkotlinx/coroutines/flow/StateFlow;", "getEffectCoroutineContext$runtime_release", "()Lkotlin/coroutines/CoroutineContext;", "effectJob", "Lkotlinx/coroutines/CompletableJob;", "hasConcurrentFrameWorkLocked", "getHasConcurrentFrameWorkLocked", "hasFrameWorkLocked", "getHasFrameWorkLocked", "hasPendingWork", "getHasPendingWork", "hasSchedulingWork", "getHasSchedulingWork", "isClosed", "knownCompositions", "recomposeCoroutineContext", "getRecomposeCoroutineContext$runtime_release", "recomposerInfo", "Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "runnerJob", "Lkotlinx/coroutines/Job;", "shouldKeepRecomposing", "getShouldKeepRecomposing", "snapshotInvalidations", "", "", "state", "Lkotlinx/coroutines/flow/Flow;", "getState$annotations", "()V", "getState", "()Lkotlinx/coroutines/flow/Flow;", "stateLock", "workContinuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "applyAndCheck", "snapshot", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "asRecomposerInfo", "Landroidx/compose/runtime/RecomposerInfo;", "awaitIdle", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitWorkAvailable", "cancel", "close", "composeInitial", "composition", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "composeInitial$runtime_release", "(Landroidx/compose/runtime/ControlledComposition;Lkotlin/jvm/functions/Function2;)V", "composing", "T", "modifiedValues", "Landroidx/compose/runtime/collection/IdentityArraySet;", "block", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/compose/runtime/collection/IdentityArraySet;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "deriveStateLocked", "invalidate", "invalidate$runtime_release", "invalidateScope", "scope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "invalidateScope$runtime_release", "join", "performRecompose", "readObserverOf", "Lkotlin/Function1;", "recompositionRunner", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/runtime/MonotonicFrameClock;", "Lkotlin/ParameterName;", "name", "parentFrameClock", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recordComposerModificationsLocked", "onEachInvalidComposition", "recordInspectionTable", "table", "", "Landroidx/compose/runtime/tooling/CompositionData;", "recordInspectionTable$runtime_release", "registerComposition", "registerComposition$runtime_release", "registerRunnerJob", "callingJob", "runFrameLoop", "frameSignal", "Landroidx/compose/runtime/ProduceFrameSignal;", "(Landroidx/compose/runtime/MonotonicFrameClock;Landroidx/compose/runtime/ProduceFrameSignal;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runRecomposeAndApplyChanges", "runRecomposeConcurrentlyAndApplyChanges", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unregisterComposition", "unregisterComposition$runtime_release", "writeObserverOf", "Companion", "HotReloadable", "RecomposerInfoImpl", "State", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Recomposer.kt */
public final class Recomposer extends CompositionContext {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final MutableStateFlow<PersistentSet<RecomposerInfoImpl>> _runningRecomposers = StateFlowKt.MutableStateFlow(ExtensionsKt.persistentSetOf());
    /* access modifiers changed from: private */
    public final MutableStateFlow<State> _state = StateFlowKt.MutableStateFlow(State.Inactive);
    /* access modifiers changed from: private */
    public final BroadcastFrameClock broadcastFrameClock;
    /* access modifiers changed from: private */
    public long changeCount;
    /* access modifiers changed from: private */
    public Throwable closeCause;
    /* access modifiers changed from: private */
    public final List<ControlledComposition> compositionInvalidations = new ArrayList();
    /* access modifiers changed from: private */
    public final List<ControlledComposition> compositionsAwaitingApply = new ArrayList();
    /* access modifiers changed from: private */
    public int concurrentCompositionsOutstanding;
    private final CoroutineContext effectCoroutineContext;
    private final CompletableJob effectJob;
    /* access modifiers changed from: private */
    public boolean isClosed;
    /* access modifiers changed from: private */
    public final List<ControlledComposition> knownCompositions = new ArrayList();
    /* access modifiers changed from: private */
    public final RecomposerInfoImpl recomposerInfo = new RecomposerInfoImpl(this);
    /* access modifiers changed from: private */
    public Job runnerJob;
    /* access modifiers changed from: private */
    public final List<Set<Object>> snapshotInvalidations = new ArrayList();
    /* access modifiers changed from: private */
    public final Object stateLock = new Object();
    /* access modifiers changed from: private */
    public CancellableContinuation<? super Unit> workContinuation;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Landroidx/compose/runtime/Recomposer$State;", "", "(Ljava/lang/String;I)V", "ShutDown", "ShuttingDown", "Inactive", "InactivePendingWork", "Idle", "PendingWork", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Recomposer.kt */
    public enum State {
        ShutDown,
        ShuttingDown,
        Inactive,
        InactivePendingWork,
        Idle,
        PendingWork
    }

    @Deprecated(message = "Replaced by currentState as a StateFlow", replaceWith = @ReplaceWith(expression = "currentState", imports = {}))
    public static /* synthetic */ void getState$annotations() {
    }

    public boolean getCollectingParameterInformation$runtime_release() {
        return false;
    }

    public int getCompoundHashKey$runtime_release() {
        return 1000;
    }

    public void recordInspectionTable$runtime_release(Set<CompositionData> set) {
        Intrinsics.checkNotNullParameter(set, "table");
    }

    public void registerComposition$runtime_release(ControlledComposition controlledComposition) {
        Intrinsics.checkNotNullParameter(controlledComposition, "composition");
    }

    public Recomposer(CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(coroutineContext, "effectCoroutineContext");
        BroadcastFrameClock broadcastFrameClock2 = new BroadcastFrameClock(new Recomposer$broadcastFrameClock$1(this));
        this.broadcastFrameClock = broadcastFrameClock2;
        CompletableJob Job = JobKt.Job((Job) coroutineContext.get(Job.Key));
        Job.invokeOnCompletion(new Recomposer$effectJob$1$1(this));
        this.effectJob = Job;
        this.effectCoroutineContext = coroutineContext.plus(broadcastFrameClock2).plus(Job);
    }

    public final long getChangeCount() {
        return this.changeCount;
    }

    public CoroutineContext getEffectCoroutineContext$runtime_release() {
        return this.effectCoroutineContext;
    }

    public CoroutineContext getRecomposeCoroutineContext$runtime_release() {
        return EmptyCoroutineContext.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final CancellableContinuation<Unit> deriveStateLocked() {
        State state;
        if (this._state.getValue().compareTo(State.ShuttingDown) <= 0) {
            this.knownCompositions.clear();
            this.snapshotInvalidations.clear();
            this.compositionInvalidations.clear();
            this.compositionsAwaitingApply.clear();
            CancellableContinuation<? super Unit> cancellableContinuation = this.workContinuation;
            if (cancellableContinuation != null) {
                CancellableContinuation.DefaultImpls.cancel$default(cancellableContinuation, (Throwable) null, 1, (Object) null);
            }
            this.workContinuation = null;
            return null;
        }
        if (this.runnerJob == null) {
            this.snapshotInvalidations.clear();
            this.compositionInvalidations.clear();
            state = this.broadcastFrameClock.getHasAwaiters() ? State.InactivePendingWork : State.Inactive;
        } else if ((!this.compositionInvalidations.isEmpty()) || (!this.snapshotInvalidations.isEmpty()) || (!this.compositionsAwaitingApply.isEmpty()) || this.concurrentCompositionsOutstanding > 0 || this.broadcastFrameClock.getHasAwaiters()) {
            state = State.PendingWork;
        } else {
            state = State.Idle;
        }
        this._state.setValue(state);
        if (state != State.PendingWork) {
            return null;
        }
        CancellableContinuation<? super Unit> cancellableContinuation2 = this.workContinuation;
        this.workContinuation = null;
        return cancellableContinuation2;
    }

    /* access modifiers changed from: private */
    public final boolean getShouldKeepRecomposing() {
        boolean z;
        boolean z2;
        synchronized (this.stateLock) {
            z = !this.isClosed;
        }
        if (z) {
            return true;
        }
        Iterator<Job> it = this.effectJob.getChildren().iterator();
        while (true) {
            if (it.hasNext()) {
                if (it.next().isActive()) {
                    z2 = true;
                    break;
                }
            } else {
                z2 = false;
                break;
            }
        }
        if (z2) {
            return true;
        }
        return false;
    }

    public final Flow<State> getState() {
        return getCurrentState();
    }

    public final StateFlow<State> getCurrentState() {
        return this._state;
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "Landroidx/compose/runtime/RecomposerInfo;", "(Landroidx/compose/runtime/Recomposer;)V", "changeCount", "", "getChangeCount", "()J", "hasPendingWork", "", "getHasPendingWork", "()Z", "state", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/compose/runtime/Recomposer$State;", "getState", "()Lkotlinx/coroutines/flow/Flow;", "saveStateAndDisposeForHotReload", "", "Landroidx/compose/runtime/Recomposer$HotReloadable;", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Recomposer.kt */
    private final class RecomposerInfoImpl implements RecomposerInfo {
        final /* synthetic */ Recomposer this$0;

        public RecomposerInfoImpl(Recomposer recomposer) {
            Intrinsics.checkNotNullParameter(recomposer, "this$0");
            this.this$0 = recomposer;
        }

        public Flow<State> getState() {
            return this.this$0.getCurrentState();
        }

        public boolean getHasPendingWork() {
            return this.this$0.getHasPendingWork();
        }

        public long getChangeCount() {
            return this.this$0.getChangeCount();
        }

        public final List<HotReloadable> saveStateAndDisposeForHotReload() {
            List mutableList;
            Object access$getStateLock$p = this.this$0.stateLock;
            Recomposer recomposer = this.this$0;
            synchronized (access$getStateLock$p) {
                mutableList = CollectionsKt.toMutableList(recomposer.knownCompositions);
            }
            ArrayList arrayList = new ArrayList(mutableList.size());
            int size = mutableList.size();
            int i = 0;
            while (i < size) {
                int i2 = i + 1;
                ControlledComposition controlledComposition = (ControlledComposition) mutableList.get(i);
                CompositionImpl compositionImpl = controlledComposition instanceof CompositionImpl ? (CompositionImpl) controlledComposition : null;
                if (compositionImpl != null) {
                    arrayList.add(compositionImpl);
                }
                i = i2;
            }
            List list = arrayList;
            ArrayList arrayList2 = new ArrayList(list.size());
            int size2 = list.size();
            for (int i3 = 0; i3 < size2; i3++) {
                HotReloadable hotReloadable = new HotReloadable((CompositionImpl) list.get(i3));
                hotReloadable.clearContent();
                arrayList2.add(hotReloadable);
            }
            return arrayList2;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\u0007J\u0006\u0010\f\u001a\u00020\u0007R\u001b\u0010\u0005\u001a\r\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bX\u000e¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/compose/runtime/Recomposer$HotReloadable;", "", "composition", "Landroidx/compose/runtime/CompositionImpl;", "(Landroidx/compose/runtime/CompositionImpl;)V", "composable", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/jvm/functions/Function2;", "clearContent", "recompose", "resetContent", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Recomposer.kt */
    private static final class HotReloadable {
        private Function2<? super Composer, ? super Integer, Unit> composable;
        private final CompositionImpl composition;

        public HotReloadable(CompositionImpl compositionImpl) {
            Intrinsics.checkNotNullParameter(compositionImpl, "composition");
            this.composition = compositionImpl;
            this.composable = compositionImpl.getComposable();
        }

        public final void clearContent() {
            if (this.composition.isRoot()) {
                this.composition.setContent(ComposableSingletons$RecomposerKt.INSTANCE.m1224getLambda1$runtime_release());
            }
        }

        public final void resetContent() {
            this.composition.setComposable(this.composable);
        }

        public final void recompose() {
            if (this.composition.isRoot()) {
                this.composition.setContent(this.composable);
            }
        }
    }

    public final RecomposerInfo asRecomposerInfo() {
        return this.recomposerInfo;
    }

    /* access modifiers changed from: private */
    public final void recordComposerModificationsLocked() {
        if (!this.snapshotInvalidations.isEmpty()) {
            List<Set<Object>> list = this.snapshotInvalidations;
            int size = list.size();
            int i = 0;
            while (i < size) {
                int i2 = i + 1;
                Set set = list.get(i);
                List<ControlledComposition> list2 = this.knownCompositions;
                int size2 = list2.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    list2.get(i3).recordModificationsOf(set);
                }
                i = i2;
            }
            this.snapshotInvalidations.clear();
            if (deriveStateLocked() != null) {
                throw new IllegalStateException("called outside of runRecomposeAndApplyChanges".toString());
            }
        }
    }

    private final void recordComposerModificationsLocked(Function1<? super ControlledComposition, Unit> function1) {
        if (!this.snapshotInvalidations.isEmpty()) {
            List access$getSnapshotInvalidations$p = this.snapshotInvalidations;
            int size = access$getSnapshotInvalidations$p.size();
            int i = 0;
            while (i < size) {
                int i2 = i + 1;
                Set set = (Set) access$getSnapshotInvalidations$p.get(i);
                List access$getKnownCompositions$p = this.knownCompositions;
                int size2 = access$getKnownCompositions$p.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    ((ControlledComposition) access$getKnownCompositions$p.get(i3)).recordModificationsOf(set);
                }
                i = i2;
            }
            this.snapshotInvalidations.clear();
        }
        List access$getCompositionInvalidations$p = this.compositionInvalidations;
        int size3 = access$getCompositionInvalidations$p.size();
        for (int i4 = 0; i4 < size3; i4++) {
            function1.invoke(access$getCompositionInvalidations$p.get(i4));
        }
        this.compositionInvalidations.clear();
        if (deriveStateLocked() != null) {
            throw new IllegalStateException("called outside of runRecomposeAndApplyChanges".toString());
        }
    }

    /* access modifiers changed from: private */
    public final void registerRunnerJob(Job job) {
        synchronized (this.stateLock) {
            Throwable th = this.closeCause;
            if (th != null) {
                throw th;
            } else if (this._state.getValue().compareTo(State.ShuttingDown) <= 0) {
                throw new IllegalStateException("Recomposer shut down".toString());
            } else if (this.runnerJob == null) {
                this.runnerJob = job;
                deriveStateLocked();
            } else {
                throw new IllegalStateException("Recomposer already running".toString());
            }
        }
    }

    public final Object runRecomposeAndApplyChanges(Continuation<? super Unit> continuation) {
        Object recompositionRunner = recompositionRunner(new Recomposer$runRecomposeAndApplyChanges$2(this, (Continuation<? super Recomposer$runRecomposeAndApplyChanges$2>) null), continuation);
        return recompositionRunner == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? recompositionRunner : Unit.INSTANCE;
    }

    @ExperimentalComposeApi
    public final Object runRecomposeConcurrentlyAndApplyChanges(CoroutineContext coroutineContext, Continuation<? super Unit> continuation) {
        Object recompositionRunner = recompositionRunner(new Recomposer$runRecomposeConcurrentlyAndApplyChanges$2(coroutineContext, this, (Continuation<? super Recomposer$runRecomposeConcurrentlyAndApplyChanges$2>) null), continuation);
        return recompositionRunner == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? recompositionRunner : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x008c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00ab A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object runFrameLoop(androidx.compose.runtime.MonotonicFrameClock r8, androidx.compose.runtime.ProduceFrameSignal r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof androidx.compose.runtime.Recomposer$runFrameLoop$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            androidx.compose.runtime.Recomposer$runFrameLoop$1 r0 = (androidx.compose.runtime.Recomposer$runFrameLoop$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            androidx.compose.runtime.Recomposer$runFrameLoop$1 r0 = new androidx.compose.runtime.Recomposer$runFrameLoop$1
            r0.<init>(r7, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0066
            if (r2 == r4) goto L_0x004e
            if (r2 != r3) goto L_0x0046
            java.lang.Object r8 = r0.L$4
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r9 = r0.L$3
            java.util.List r9 = (java.util.List) r9
            java.lang.Object r2 = r0.L$2
            androidx.compose.runtime.ProduceFrameSignal r2 = (androidx.compose.runtime.ProduceFrameSignal) r2
            java.lang.Object r5 = r0.L$1
            androidx.compose.runtime.MonotonicFrameClock r5 = (androidx.compose.runtime.MonotonicFrameClock) r5
            java.lang.Object r6 = r0.L$0
            androidx.compose.runtime.Recomposer r6 = (androidx.compose.runtime.Recomposer) r6
            kotlin.ResultKt.throwOnFailure(r10)
        L_0x0040:
            r10 = r9
            r9 = r2
            r2 = r8
            r8 = r5
            r5 = r6
            goto L_0x0078
        L_0x0046:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x004e:
            java.lang.Object r8 = r0.L$4
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r9 = r0.L$3
            java.util.List r9 = (java.util.List) r9
            java.lang.Object r2 = r0.L$2
            androidx.compose.runtime.ProduceFrameSignal r2 = (androidx.compose.runtime.ProduceFrameSignal) r2
            java.lang.Object r5 = r0.L$1
            androidx.compose.runtime.MonotonicFrameClock r5 = (androidx.compose.runtime.MonotonicFrameClock) r5
            java.lang.Object r6 = r0.L$0
            androidx.compose.runtime.Recomposer r6 = (androidx.compose.runtime.Recomposer) r6
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0092
        L_0x0066:
            kotlin.ResultKt.throwOnFailure(r10)
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.List r10 = (java.util.List) r10
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.List r2 = (java.util.List) r2
            r5 = r7
        L_0x0078:
            java.lang.Object r6 = r5.stateLock
            r0.L$0 = r5
            r0.L$1 = r8
            r0.L$2 = r9
            r0.L$3 = r10
            r0.L$4 = r2
            r0.label = r4
            java.lang.Object r6 = r9.awaitFrameRequest(r6, r0)
            if (r6 != r1) goto L_0x008d
            return r1
        L_0x008d:
            r6 = r5
            r5 = r8
            r8 = r2
            r2 = r9
            r9 = r10
        L_0x0092:
            androidx.compose.runtime.Recomposer$runFrameLoop$2 r10 = new androidx.compose.runtime.Recomposer$runFrameLoop$2
            r10.<init>(r6, r9, r8, r2)
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            r0.L$0 = r6
            r0.L$1 = r5
            r0.L$2 = r2
            r0.L$3 = r9
            r0.L$4 = r8
            r0.label = r3
            java.lang.Object r10 = r5.withFrameNanos(r10, r0)
            if (r10 != r1) goto L_0x0040
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.runFrameLoop(androidx.compose.runtime.MonotonicFrameClock, androidx.compose.runtime.ProduceFrameSignal, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final boolean getHasSchedulingWork() {
        boolean z;
        synchronized (this.stateLock) {
            z = true;
            if (!(!this.snapshotInvalidations.isEmpty()) && !(!this.compositionInvalidations.isEmpty()) && !this.broadcastFrameClock.getHasAwaiters()) {
                z = false;
            }
        }
        return z;
    }

    /* access modifiers changed from: private */
    public final Object awaitWorkAvailable(Continuation<? super Unit> continuation) {
        if (getHasSchedulingWork()) {
            return Unit.INSTANCE;
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
        synchronized (this.stateLock) {
            if (getHasSchedulingWork()) {
                Result.Companion companion = Result.Companion;
                cancellableContinuation.resumeWith(Result.m4709constructorimpl(Unit.INSTANCE));
            } else {
                this.workContinuation = cancellableContinuation;
            }
            Unit unit = Unit.INSTANCE;
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final Object recompositionRunner(Function3<? super CoroutineScope, ? super MonotonicFrameClock, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.broadcastFrameClock, new Recomposer$recompositionRunner$2(this, function3, MonotonicFrameClockKt.getMonotonicFrameClock(continuation.getContext()), (Continuation<? super Recomposer$recompositionRunner$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final void cancel() {
        synchronized (this.stateLock) {
            if (this._state.getValue().compareTo(State.Idle) >= 0) {
                this._state.setValue(State.ShuttingDown);
            }
            Unit unit = Unit.INSTANCE;
        }
        Job.DefaultImpls.cancel$default((Job) this.effectJob, (CancellationException) null, 1, (Object) null);
    }

    public final void close() {
        if (this.effectJob.complete()) {
            synchronized (this.stateLock) {
                this.isClosed = true;
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final Object join(Continuation<? super Unit> continuation) {
        Object first = FlowKt.first(getCurrentState(), new Recomposer$join$2((Continuation<? super Recomposer$join$2>) null), continuation);
        return first == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? first : Unit.INSTANCE;
    }

    public void composeInitial$runtime_release(ControlledComposition controlledComposition, Function2<? super Composer, ? super Integer, Unit> function2) {
        Snapshot snapshot;
        Snapshot makeCurrent;
        Intrinsics.checkNotNullParameter(controlledComposition, "composition");
        Intrinsics.checkNotNullParameter(function2, "content");
        boolean isComposing = controlledComposition.isComposing();
        MutableSnapshot takeMutableSnapshot = Snapshot.Companion.takeMutableSnapshot(readObserverOf(controlledComposition), writeObserverOf(controlledComposition, (IdentityArraySet<Object>) null));
        try {
            snapshot = takeMutableSnapshot;
            makeCurrent = snapshot.makeCurrent();
            controlledComposition.composeContent(function2);
            Unit unit = Unit.INSTANCE;
            snapshot.restoreCurrent(makeCurrent);
            applyAndCheck(takeMutableSnapshot);
            if (!isComposing) {
                Snapshot.Companion.notifyObjectsInitialized();
            }
            synchronized (this.stateLock) {
                if (this._state.getValue().compareTo(State.ShuttingDown) > 0 && !this.knownCompositions.contains(controlledComposition)) {
                    this.knownCompositions.add(controlledComposition);
                }
                Unit unit2 = Unit.INSTANCE;
            }
            controlledComposition.applyChanges();
            if (!isComposing) {
                Snapshot.Companion.notifyObjectsInitialized();
            }
        } catch (Throwable th) {
            applyAndCheck(takeMutableSnapshot);
            throw th;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002d, code lost:
        if (r9.isNotEmpty() == true) goto L_0x002f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.runtime.ControlledComposition performRecompose(androidx.compose.runtime.ControlledComposition r8, androidx.compose.runtime.collection.IdentityArraySet<java.lang.Object> r9) {
        /*
            r7 = this;
            boolean r0 = r8.isComposing()
            r1 = 0
            if (r0 != 0) goto L_0x0054
            boolean r0 = r8.isDisposed()
            if (r0 == 0) goto L_0x000e
            goto L_0x0054
        L_0x000e:
            androidx.compose.runtime.snapshots.Snapshot$Companion r0 = androidx.compose.runtime.snapshots.Snapshot.Companion
            kotlin.jvm.functions.Function1 r2 = r7.readObserverOf(r8)
            kotlin.jvm.functions.Function1 r3 = r7.writeObserverOf(r8, r9)
            androidx.compose.runtime.snapshots.MutableSnapshot r0 = r0.takeMutableSnapshot(r2, r3)
            r2 = r0
            androidx.compose.runtime.snapshots.Snapshot r2 = (androidx.compose.runtime.snapshots.Snapshot) r2     // Catch:{ all -> 0x004f }
            androidx.compose.runtime.snapshots.Snapshot r3 = r2.makeCurrent()     // Catch:{ all -> 0x004f }
            r4 = 1
            r5 = 0
            if (r9 != 0) goto L_0x0029
        L_0x0027:
            r4 = 0
            goto L_0x002f
        L_0x0029:
            boolean r6 = r9.isNotEmpty()     // Catch:{ all -> 0x004a }
            if (r6 != r4) goto L_0x0027
        L_0x002f:
            if (r4 == 0) goto L_0x003b
            androidx.compose.runtime.Recomposer$performRecompose$1$1 r4 = new androidx.compose.runtime.Recomposer$performRecompose$1$1     // Catch:{ all -> 0x004a }
            r4.<init>(r9, r8)     // Catch:{ all -> 0x004a }
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4     // Catch:{ all -> 0x004a }
            r8.prepareCompose(r4)     // Catch:{ all -> 0x004a }
        L_0x003b:
            boolean r9 = r8.recompose()     // Catch:{ all -> 0x004a }
            r2.restoreCurrent(r3)     // Catch:{ all -> 0x004f }
            r7.applyAndCheck(r0)
            if (r9 == 0) goto L_0x0048
            goto L_0x0049
        L_0x0048:
            r8 = r1
        L_0x0049:
            return r8
        L_0x004a:
            r8 = move-exception
            r2.restoreCurrent(r3)     // Catch:{ all -> 0x004f }
            throw r8     // Catch:{ all -> 0x004f }
        L_0x004f:
            r8 = move-exception
            r7.applyAndCheck(r0)
            throw r8
        L_0x0054:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.performRecompose(androidx.compose.runtime.ControlledComposition, androidx.compose.runtime.collection.IdentityArraySet):androidx.compose.runtime.ControlledComposition");
    }

    private final Function1<Object, Unit> readObserverOf(ControlledComposition controlledComposition) {
        return new Recomposer$readObserverOf$1(controlledComposition);
    }

    private final Function1<Object, Unit> writeObserverOf(ControlledComposition controlledComposition, IdentityArraySet<Object> identityArraySet) {
        return new Recomposer$writeObserverOf$1(controlledComposition, identityArraySet);
    }

    private final <T> T composing(ControlledComposition controlledComposition, IdentityArraySet<Object> identityArraySet, Function0<? extends T> function0) {
        Snapshot snapshot;
        Snapshot makeCurrent;
        MutableSnapshot takeMutableSnapshot = Snapshot.Companion.takeMutableSnapshot(readObserverOf(controlledComposition), writeObserverOf(controlledComposition, identityArraySet));
        try {
            snapshot = takeMutableSnapshot;
            makeCurrent = snapshot.makeCurrent();
            T invoke = function0.invoke();
            InlineMarker.finallyStart(1);
            snapshot.restoreCurrent(makeCurrent);
            InlineMarker.finallyEnd(1);
            InlineMarker.finallyStart(1);
            applyAndCheck(takeMutableSnapshot);
            InlineMarker.finallyEnd(1);
            return invoke;
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            applyAndCheck(takeMutableSnapshot);
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }

    private final void applyAndCheck(MutableSnapshot mutableSnapshot) {
        try {
            if (mutableSnapshot.apply() instanceof SnapshotApplyResult.Failure) {
                throw new IllegalStateException("Unsupported concurrent change during composition. A state object was modified by composition as well as being modified outside composition.".toString());
            }
        } finally {
            mutableSnapshot.dispose();
        }
    }

    public final boolean getHasPendingWork() {
        boolean z;
        synchronized (this.stateLock) {
            z = true;
            if (!(!this.snapshotInvalidations.isEmpty()) && !(!this.compositionInvalidations.isEmpty()) && this.concurrentCompositionsOutstanding <= 0 && !(!this.compositionsAwaitingApply.isEmpty()) && !this.broadcastFrameClock.getHasAwaiters()) {
                z = false;
            }
        }
        return z;
    }

    /* access modifiers changed from: private */
    public final boolean getHasFrameWorkLocked() {
        return (this.compositionInvalidations.isEmpty() ^ true) || this.broadcastFrameClock.getHasAwaiters();
    }

    /* access modifiers changed from: private */
    public final boolean getHasConcurrentFrameWorkLocked() {
        return (this.compositionsAwaitingApply.isEmpty() ^ true) || this.broadcastFrameClock.getHasAwaiters();
    }

    public final Object awaitIdle(Continuation<? super Unit> continuation) {
        Object collect = FlowKt.collect(FlowKt.takeWhile(getCurrentState(), new Recomposer$awaitIdle$2((Continuation<? super Recomposer$awaitIdle$2>) null)), continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    public void unregisterComposition$runtime_release(ControlledComposition controlledComposition) {
        Intrinsics.checkNotNullParameter(controlledComposition, "composition");
        synchronized (this.stateLock) {
            this.knownCompositions.remove(controlledComposition);
            Unit unit = Unit.INSTANCE;
        }
    }

    public void invalidate$runtime_release(ControlledComposition controlledComposition) {
        CancellableContinuation<Unit> cancellableContinuation;
        Intrinsics.checkNotNullParameter(controlledComposition, "composition");
        synchronized (this.stateLock) {
            if (!this.compositionInvalidations.contains(controlledComposition)) {
                this.compositionInvalidations.add(controlledComposition);
                cancellableContinuation = deriveStateLocked();
            } else {
                cancellableContinuation = null;
            }
        }
        if (cancellableContinuation != null) {
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m4709constructorimpl(Unit.INSTANCE));
        }
    }

    public void invalidateScope$runtime_release(RecomposeScopeImpl recomposeScopeImpl) {
        CancellableContinuation<Unit> deriveStateLocked;
        Intrinsics.checkNotNullParameter(recomposeScopeImpl, "scope");
        synchronized (this.stateLock) {
            this.snapshotInvalidations.add(SetsKt.setOf(recomposeScopeImpl));
            deriveStateLocked = deriveStateLocked();
        }
        if (deriveStateLocked != null) {
            Result.Companion companion = Result.Companion;
            deriveStateLocked.resumeWith(Result.m4709constructorimpl(Unit.INSTANCE));
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u00060\u0006R\u00020\u0007H\u0002J\u0015\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0001H\u0000¢\u0006\u0002\b\u0013J\u0014\u0010\u0014\u001a\u00020\u000f2\n\u0010\u0010\u001a\u00060\u0006R\u00020\u0007H\u0002J\r\u0010\u0015\u001a\u00020\u0001H\u0000¢\u0006\u0002\b\u0016R\u001e\u0010\u0003\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0006R\u00020\u00070\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t8F¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Landroidx/compose/runtime/Recomposer$Companion;", "", "()V", "_runningRecomposers", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "Landroidx/compose/runtime/Recomposer;", "runningRecomposers", "Lkotlinx/coroutines/flow/StateFlow;", "", "Landroidx/compose/runtime/RecomposerInfo;", "getRunningRecomposers", "()Lkotlinx/coroutines/flow/StateFlow;", "addRunning", "", "info", "loadStateAndComposeForHotReload", "token", "loadStateAndComposeForHotReload$runtime_release", "removeRunning", "saveStateAndDisposeForHotReload", "saveStateAndDisposeForHotReload$runtime_release", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Recomposer.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final StateFlow<Set<RecomposerInfo>> getRunningRecomposers() {
            return Recomposer._runningRecomposers;
        }

        /* access modifiers changed from: private */
        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public final void addRunning(androidx.compose.runtime.Recomposer.RecomposerInfoImpl r4) {
            /*
                r3 = this;
            L_0x0000:
                kotlinx.coroutines.flow.MutableStateFlow r0 = androidx.compose.runtime.Recomposer._runningRecomposers
                java.lang.Object r0 = r0.getValue()
                androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet r0 = (androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet) r0
                androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet r1 = r0.add(r4)
                if (r0 == r1) goto L_0x001a
                kotlinx.coroutines.flow.MutableStateFlow r2 = androidx.compose.runtime.Recomposer._runningRecomposers
                boolean r0 = r2.compareAndSet(r0, r1)
                if (r0 == 0) goto L_0x0000
            L_0x001a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.Companion.addRunning(androidx.compose.runtime.Recomposer$RecomposerInfoImpl):void");
        }

        /* access modifiers changed from: private */
        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public final void removeRunning(androidx.compose.runtime.Recomposer.RecomposerInfoImpl r4) {
            /*
                r3 = this;
            L_0x0000:
                kotlinx.coroutines.flow.MutableStateFlow r0 = androidx.compose.runtime.Recomposer._runningRecomposers
                java.lang.Object r0 = r0.getValue()
                androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet r0 = (androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet) r0
                androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet r1 = r0.remove(r4)
                if (r0 == r1) goto L_0x001a
                kotlinx.coroutines.flow.MutableStateFlow r2 = androidx.compose.runtime.Recomposer._runningRecomposers
                boolean r0 = r2.compareAndSet(r0, r1)
                if (r0 == 0) goto L_0x0000
            L_0x001a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.Companion.removeRunning(androidx.compose.runtime.Recomposer$RecomposerInfoImpl):void");
        }

        public final Object saveStateAndDisposeForHotReload$runtime_release() {
            Collection arrayList = new ArrayList();
            for (RecomposerInfoImpl saveStateAndDisposeForHotReload : (Iterable) Recomposer._runningRecomposers.getValue()) {
                CollectionsKt.addAll(arrayList, saveStateAndDisposeForHotReload.saveStateAndDisposeForHotReload());
            }
            return (List) arrayList;
        }

        public final void loadStateAndComposeForHotReload$runtime_release(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "token");
            List list = (List) obj;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ((HotReloadable) list.get(i)).resetContent();
            }
            int size2 = list.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ((HotReloadable) list.get(i2)).recompose();
            }
        }
    }
}
