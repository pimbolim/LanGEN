package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "parentFrameClock", "Landroidx/compose/runtime/MonotonicFrameClock;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2", f = "Recomposer.kt", i = {0, 0, 0, 1}, l = {531, 551, 552}, m = "invokeSuspend", n = {"recomposeCoroutineScope", "frameSignal", "frameLoop", "frameLoop"}, s = {"L$0", "L$1", "L$2", "L$0"})
/* compiled from: Recomposer.kt */
final class Recomposer$runRecomposeConcurrentlyAndApplyChanges$2 extends SuspendLambda implements Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> {
    final /* synthetic */ CoroutineContext $recomposeCoroutineContext;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ Recomposer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Recomposer$runRecomposeConcurrentlyAndApplyChanges$2(CoroutineContext coroutineContext, Recomposer recomposer, Continuation<? super Recomposer$runRecomposeConcurrentlyAndApplyChanges$2> continuation) {
        super(3, continuation);
        this.$recomposeCoroutineContext = coroutineContext;
        this.this$0 = recomposer;
    }

    public final Object invoke(CoroutineScope coroutineScope, MonotonicFrameClock monotonicFrameClock, Continuation<? super Unit> continuation) {
        Recomposer$runRecomposeConcurrentlyAndApplyChanges$2 recomposer$runRecomposeConcurrentlyAndApplyChanges$2 = new Recomposer$runRecomposeConcurrentlyAndApplyChanges$2(this.$recomposeCoroutineContext, this.this$0, continuation);
        recomposer$runRecomposeConcurrentlyAndApplyChanges$2.L$0 = coroutineScope;
        recomposer$runRecomposeConcurrentlyAndApplyChanges$2.L$1 = monotonicFrameClock;
        return recomposer$runRecomposeConcurrentlyAndApplyChanges$2.invokeSuspend(Unit.INSTANCE);
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public final java.lang.Object invokeSuspend(java.lang.Object r21) {
        /*
            r20 = this;
            r1 = r20
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r1.label
            r3 = 3
            r4 = 2
            r6 = 0
            r7 = 1
            if (r2 == 0) goto L_0x003e
            if (r2 == r7) goto L_0x002b
            if (r2 == r4) goto L_0x0021
            if (r2 != r3) goto L_0x0019
            kotlin.ResultKt.throwOnFailure(r21)
            goto L_0x01a6
        L_0x0019:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0021:
            java.lang.Object r2 = r1.L$0
            kotlinx.coroutines.Job r2 = (kotlinx.coroutines.Job) r2
            kotlin.ResultKt.throwOnFailure(r21)
            r10 = r1
            goto L_0x0197
        L_0x002b:
            java.lang.Object r2 = r1.L$2
            kotlinx.coroutines.Job r2 = (kotlinx.coroutines.Job) r2
            java.lang.Object r8 = r1.L$1
            androidx.compose.runtime.ProduceFrameSignal r8 = (androidx.compose.runtime.ProduceFrameSignal) r8
            java.lang.Object r9 = r1.L$0
            kotlinx.coroutines.CoroutineScope r9 = (kotlinx.coroutines.CoroutineScope) r9
            kotlin.ResultKt.throwOnFailure(r21)
            r14 = r1
            r15 = r9
            goto L_0x00b4
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r21)
            java.lang.Object r2 = r1.L$0
            r8 = r2
            kotlinx.coroutines.CoroutineScope r8 = (kotlinx.coroutines.CoroutineScope) r8
            java.lang.Object r2 = r1.L$1
            androidx.compose.runtime.MonotonicFrameClock r2 = (androidx.compose.runtime.MonotonicFrameClock) r2
            kotlin.coroutines.CoroutineContext r9 = r1.$recomposeCoroutineContext
            kotlinx.coroutines.Job$Key r10 = kotlinx.coroutines.Job.Key
            kotlin.coroutines.CoroutineContext$Key r10 = (kotlin.coroutines.CoroutineContext.Key) r10
            kotlin.coroutines.CoroutineContext$Element r9 = r9.get(r10)
            if (r9 != 0) goto L_0x0058
            r9 = 1
            goto L_0x0059
        L_0x0058:
            r9 = 0
        L_0x0059:
            kotlin.coroutines.CoroutineContext r10 = r1.$recomposeCoroutineContext
            if (r9 == 0) goto L_0x01a9
            kotlin.coroutines.CoroutineContext r9 = r8.getCoroutineContext()
            kotlin.coroutines.CoroutineContext r10 = r1.$recomposeCoroutineContext
            kotlin.coroutines.CoroutineContext r9 = r9.plus(r10)
            kotlin.coroutines.CoroutineContext r10 = r8.getCoroutineContext()
            kotlinx.coroutines.Job r10 = kotlinx.coroutines.JobKt.getJob(r10)
            kotlinx.coroutines.CompletableJob r10 = kotlinx.coroutines.JobKt.Job((kotlinx.coroutines.Job) r10)
            kotlin.coroutines.CoroutineContext r10 = (kotlin.coroutines.CoroutineContext) r10
            kotlin.coroutines.CoroutineContext r9 = r9.plus(r10)
            kotlinx.coroutines.CoroutineScope r14 = kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(r9)
            androidx.compose.runtime.ProduceFrameSignal r15 = new androidx.compose.runtime.ProduceFrameSignal
            r15.<init>()
            r9 = 0
            r10 = 0
            androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$frameLoop$1 r11 = new androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$frameLoop$1
            androidx.compose.runtime.Recomposer r12 = r1.this$0
            r11.<init>(r12, r2, r15, r6)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r12 = 3
            r13 = 0
            kotlinx.coroutines.Job r2 = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r8, r9, r10, r11, r12, r13)
            r10 = r1
            r9 = r14
            r8 = r15
        L_0x0096:
            androidx.compose.runtime.Recomposer r11 = r10.this$0
            boolean r11 = r11.getShouldKeepRecomposing()
            if (r11 == 0) goto L_0x017c
            androidx.compose.runtime.Recomposer r11 = r10.this$0
            r12 = r10
            kotlin.coroutines.Continuation r12 = (kotlin.coroutines.Continuation) r12
            r10.L$0 = r9
            r10.L$1 = r8
            r10.L$2 = r2
            r10.label = r7
            java.lang.Object r11 = r11.awaitWorkAvailable(r12)
            if (r11 != r0) goto L_0x00b2
            return r0
        L_0x00b2:
            r15 = r9
            r14 = r10
        L_0x00b4:
            androidx.compose.runtime.Recomposer r9 = r14.this$0
            java.lang.Object r16 = r9.stateLock
            androidx.compose.runtime.Recomposer r13 = r14.this$0
            monitor-enter(r16)
            java.util.List r9 = r13.snapshotInvalidations     // Catch:{ all -> 0x0179 }
            java.util.Collection r9 = (java.util.Collection) r9     // Catch:{ all -> 0x0179 }
            boolean r9 = r9.isEmpty()     // Catch:{ all -> 0x0179 }
            r9 = r9 ^ r7
            if (r9 == 0) goto L_0x0101
            java.util.List r9 = r13.snapshotInvalidations     // Catch:{ all -> 0x0179 }
            int r10 = r9.size()     // Catch:{ all -> 0x0179 }
            r11 = 0
        L_0x00d3:
            if (r11 >= r10) goto L_0x00fa
            int r12 = r11 + 1
            java.lang.Object r11 = r9.get(r11)     // Catch:{ all -> 0x0179 }
            java.util.Set r11 = (java.util.Set) r11     // Catch:{ all -> 0x0179 }
            java.util.List r5 = r13.knownCompositions     // Catch:{ all -> 0x0179 }
            int r3 = r5.size()     // Catch:{ all -> 0x0179 }
            r4 = 0
        L_0x00e6:
            if (r4 >= r3) goto L_0x00f6
            int r17 = r4 + 1
            java.lang.Object r4 = r5.get(r4)     // Catch:{ all -> 0x0179 }
            androidx.compose.runtime.ControlledComposition r4 = (androidx.compose.runtime.ControlledComposition) r4     // Catch:{ all -> 0x0179 }
            r4.recordModificationsOf(r11)     // Catch:{ all -> 0x0179 }
            r4 = r17
            goto L_0x00e6
        L_0x00f6:
            r11 = r12
            r3 = 3
            r4 = 2
            goto L_0x00d3
        L_0x00fa:
            java.util.List r3 = r13.snapshotInvalidations     // Catch:{ all -> 0x0179 }
            r3.clear()     // Catch:{ all -> 0x0179 }
        L_0x0101:
            java.util.List r3 = r13.compositionInvalidations     // Catch:{ all -> 0x0179 }
            int r4 = r3.size()     // Catch:{ all -> 0x0179 }
            r5 = 0
        L_0x010a:
            if (r5 >= r4) goto L_0x013c
            int r17 = r5 + 1
            java.lang.Object r5 = r3.get(r5)     // Catch:{ all -> 0x0179 }
            androidx.compose.runtime.ControlledComposition r5 = (androidx.compose.runtime.ControlledComposition) r5     // Catch:{ all -> 0x0179 }
            int r9 = r13.concurrentCompositionsOutstanding     // Catch:{ all -> 0x0179 }
            int r9 = r9 + r7
            r13.concurrentCompositionsOutstanding = r9     // Catch:{ all -> 0x0179 }
            kotlin.coroutines.CoroutineContext r10 = androidx.compose.runtime.CompositionKt.getRecomposeCoroutineContext(r5)     // Catch:{ all -> 0x0179 }
            r11 = 0
            androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$2$1$1 r9 = new androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$2$1$1     // Catch:{ all -> 0x0179 }
            r9.<init>(r13, r5, r6)     // Catch:{ all -> 0x0179 }
            r12 = r9
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12     // Catch:{ all -> 0x0179 }
            r5 = 2
            r18 = 0
            r9 = r15
            r19 = r13
            r13 = r5
            r5 = r14
            r14 = r18
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r9, r10, r11, r12, r13, r14)     // Catch:{ all -> 0x0179 }
            r14 = r5
            r5 = r17
            r13 = r19
            goto L_0x010a
        L_0x013c:
            r19 = r13
            r5 = r14
            java.util.List r3 = r19.compositionInvalidations     // Catch:{ all -> 0x0179 }
            r3.clear()     // Catch:{ all -> 0x0179 }
            kotlinx.coroutines.CancellableContinuation r3 = r19.deriveStateLocked()     // Catch:{ all -> 0x0179 }
            if (r3 != 0) goto L_0x016d
            boolean r3 = r19.getHasConcurrentFrameWorkLocked()     // Catch:{ all -> 0x0179 }
            if (r3 == 0) goto L_0x0157
            kotlin.coroutines.Continuation r3 = r8.requestFrameLocked()     // Catch:{ all -> 0x0179 }
            goto L_0x0158
        L_0x0157:
            r3 = r6
        L_0x0158:
            monitor-exit(r16)
            if (r3 != 0) goto L_0x015c
            goto L_0x0167
        L_0x015c:
            kotlin.Result$Companion r4 = kotlin.Result.Companion
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            java.lang.Object r4 = kotlin.Result.m4709constructorimpl(r4)
            r3.resumeWith(r4)
        L_0x0167:
            r10 = r5
            r9 = r15
            r3 = 3
            r4 = 2
            goto L_0x0096
        L_0x016d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0179 }
            java.lang.String r2 = "called outside of runRecomposeAndApplyChanges"
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0179 }
            r0.<init>(r2)     // Catch:{ all -> 0x0179 }
            throw r0     // Catch:{ all -> 0x0179 }
        L_0x0179:
            r0 = move-exception
            monitor-exit(r16)
            throw r0
        L_0x017c:
            kotlin.coroutines.CoroutineContext r3 = r9.getCoroutineContext()
            kotlinx.coroutines.Job r3 = kotlinx.coroutines.JobKt.getJob(r3)
            r4 = r10
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r10.L$0 = r2
            r10.L$1 = r6
            r10.L$2 = r6
            r5 = 2
            r10.label = r5
            java.lang.Object r3 = kotlinx.coroutines.JobKt.cancelAndJoin(r3, r4)
            if (r3 != r0) goto L_0x0197
            return r0
        L_0x0197:
            r3 = r10
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r10.L$0 = r6
            r4 = 3
            r10.label = r4
            java.lang.Object r2 = kotlinx.coroutines.JobKt.cancelAndJoin(r2, r3)
            if (r2 != r0) goto L_0x01a6
            return r0
        L_0x01a6:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x01a9:
            java.lang.String r0 = "recomposeCoroutineContext may not contain a Job; found "
            kotlinx.coroutines.Job$Key r2 = kotlinx.coroutines.Job.Key
            kotlin.coroutines.CoroutineContext$Key r2 = (kotlin.coroutines.CoroutineContext.Key) r2
            kotlin.coroutines.CoroutineContext$Element r2 = r10.get(r2)
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r0, r2)
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
