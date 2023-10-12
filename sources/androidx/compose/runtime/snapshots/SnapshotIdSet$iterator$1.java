package androidx.compose.runtime.snapshots;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", ""}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.runtime.snapshots.SnapshotIdSet$iterator$1", f = "SnapshotIdSet.kt", i = {0, 0, 1, 2}, l = {268, 273, 280}, m = "invokeSuspend", n = {"$this$sequence", "belowBound", "$this$sequence", "$this$sequence"}, s = {"L$0", "L$1", "L$0", "L$0"})
/* compiled from: SnapshotIdSet.kt */
final class SnapshotIdSet$iterator$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Integer>, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ SnapshotIdSet this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SnapshotIdSet$iterator$1(SnapshotIdSet snapshotIdSet, Continuation<? super SnapshotIdSet$iterator$1> continuation) {
        super(2, continuation);
        this.this$0 = snapshotIdSet;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SnapshotIdSet$iterator$1 snapshotIdSet$iterator$1 = new SnapshotIdSet$iterator$1(this.this$0, continuation);
        snapshotIdSet$iterator$1.L$0 = obj;
        return snapshotIdSet$iterator$1;
    }

    public final Object invoke(SequenceScope<? super Integer> sequenceScope, Continuation<? super Unit> continuation) {
        return ((SnapshotIdSet$iterator$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00d4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) {
        /*
            r19 = this;
            r0 = r19
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            r6 = 3
            r7 = 2
            r8 = 64
            r10 = 0
            r12 = 1
            if (r2 == 0) goto L_0x004d
            if (r2 == r12) goto L_0x003c
            if (r2 == r7) goto L_0x0030
            if (r2 != r6) goto L_0x0028
            int r2 = r0.I$0
            java.lang.Object r7 = r0.L$0
            kotlin.sequences.SequenceScope r7 = (kotlin.sequences.SequenceScope) r7
            kotlin.ResultKt.throwOnFailure(r20)
            r9 = r2
            r13 = 3
            r2 = r0
            goto L_0x00d2
        L_0x0028:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0030:
            int r2 = r0.I$0
            java.lang.Object r12 = r0.L$0
            kotlin.sequences.SequenceScope r12 = (kotlin.sequences.SequenceScope) r12
            kotlin.ResultKt.throwOnFailure(r20)
            r9 = r0
            r13 = 2
            goto L_0x0092
        L_0x003c:
            int r2 = r0.I$1
            int r13 = r0.I$0
            java.lang.Object r14 = r0.L$1
            int[] r14 = (int[]) r14
            java.lang.Object r15 = r0.L$0
            kotlin.sequences.SequenceScope r15 = (kotlin.sequences.SequenceScope) r15
            kotlin.ResultKt.throwOnFailure(r20)
            r9 = r0
            goto L_0x0080
        L_0x004d:
            kotlin.ResultKt.throwOnFailure(r20)
            java.lang.Object r2 = r0.L$0
            kotlin.sequences.SequenceScope r2 = (kotlin.sequences.SequenceScope) r2
            androidx.compose.runtime.snapshots.SnapshotIdSet r13 = r0.this$0
            int[] r13 = r13.belowBound
            if (r13 == 0) goto L_0x0085
            int r14 = r13.length
            r9 = r0
            r15 = r2
            r2 = r14
            r14 = r13
            r13 = 0
        L_0x0062:
            if (r13 >= r2) goto L_0x0083
            r16 = r14[r13]
            int r13 = r13 + 1
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r16)
            r7 = r9
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r9.L$0 = r15
            r9.L$1 = r14
            r9.I$0 = r13
            r9.I$1 = r2
            r9.label = r12
            java.lang.Object r6 = r15.yield(r6, r7)
            if (r6 != r1) goto L_0x0080
            return r1
        L_0x0080:
            r6 = 3
            r7 = 2
            goto L_0x0062
        L_0x0083:
            r2 = r15
            goto L_0x0086
        L_0x0085:
            r9 = r0
        L_0x0086:
            androidx.compose.runtime.snapshots.SnapshotIdSet r6 = r9.this$0
            long r6 = r6.lowerSet
            int r12 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r12 == 0) goto L_0x00c5
            r12 = r2
            r2 = 0
        L_0x0092:
            if (r2 >= r8) goto L_0x00c4
            int r6 = r2 + 1
            androidx.compose.runtime.snapshots.SnapshotIdSet r7 = r9.this$0
            long r13 = r7.lowerSet
            long r17 = r4 << r2
            long r13 = r13 & r17
            int r7 = (r13 > r10 ? 1 : (r13 == r10 ? 0 : -1))
            if (r7 == 0) goto L_0x00c2
            androidx.compose.runtime.snapshots.SnapshotIdSet r7 = r9.this$0
            int r7 = r7.lowerBound
            int r2 = r2 + r7
            java.lang.Integer r2 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r2)
            r7 = r9
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r9.L$0 = r12
            r9.L$1 = r3
            r9.I$0 = r6
            r13 = 2
            r9.label = r13
            java.lang.Object r2 = r12.yield(r2, r7)
            if (r2 != r1) goto L_0x00c2
            return r1
        L_0x00c2:
            r2 = r6
            goto L_0x0092
        L_0x00c4:
            r2 = r12
        L_0x00c5:
            androidx.compose.runtime.snapshots.SnapshotIdSet r6 = r9.this$0
            long r6 = r6.upperSet
            int r12 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r12 == 0) goto L_0x0105
            r7 = r2
            r2 = r9
            r9 = 0
        L_0x00d2:
            if (r9 >= r8) goto L_0x0105
            int r6 = r9 + 1
            androidx.compose.runtime.snapshots.SnapshotIdSet r12 = r2.this$0
            long r12 = r12.upperSet
            long r14 = r4 << r9
            long r12 = r12 & r14
            int r14 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r14 == 0) goto L_0x0103
            int r9 = r9 + 64
            androidx.compose.runtime.snapshots.SnapshotIdSet r12 = r2.this$0
            int r12 = r12.lowerBound
            int r9 = r9 + r12
            java.lang.Integer r9 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r9)
            r12 = r2
            kotlin.coroutines.Continuation r12 = (kotlin.coroutines.Continuation) r12
            r2.L$0 = r7
            r2.L$1 = r3
            r2.I$0 = r6
            r13 = 3
            r2.label = r13
            java.lang.Object r9 = r7.yield(r9, r12)
            if (r9 != r1) goto L_0x0103
            return r1
        L_0x0103:
            r9 = r6
            goto L_0x00d2
        L_0x0105:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotIdSet$iterator$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
