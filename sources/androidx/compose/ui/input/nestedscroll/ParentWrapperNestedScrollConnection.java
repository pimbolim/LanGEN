package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0002\u0010\u0004J)\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010J-\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u0017\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0002\u001a\u00020\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00020\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\b\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001d"}, d2 = {"Landroidx/compose/ui/input/nestedscroll/ParentWrapperNestedScrollConnection;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "parent", "self", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;)V", "getParent", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "setParent", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;)V", "getSelf", "setSelf", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NestedScrollDelegatingWrapper.kt */
final class ParentWrapperNestedScrollConnection implements NestedScrollConnection {
    private NestedScrollConnection parent;
    private NestedScrollConnection self;

    public ParentWrapperNestedScrollConnection(NestedScrollConnection nestedScrollConnection, NestedScrollConnection nestedScrollConnection2) {
        Intrinsics.checkNotNullParameter(nestedScrollConnection, "parent");
        Intrinsics.checkNotNullParameter(nestedScrollConnection2, "self");
        this.parent = nestedScrollConnection;
        this.self = nestedScrollConnection2;
    }

    public final NestedScrollConnection getParent() {
        return this.parent;
    }

    public final void setParent(NestedScrollConnection nestedScrollConnection) {
        Intrinsics.checkNotNullParameter(nestedScrollConnection, "<set-?>");
        this.parent = nestedScrollConnection;
    }

    public final NestedScrollConnection getSelf() {
        return this.self;
    }

    public final void setSelf(NestedScrollConnection nestedScrollConnection) {
        Intrinsics.checkNotNullParameter(nestedScrollConnection, "<set-?>");
        this.self = nestedScrollConnection;
    }

    /* renamed from: onPreScroll-OzD1aCk  reason: not valid java name */
    public long m2894onPreScrollOzD1aCk(long j, int i) {
        long r0 = this.parent.m2867onPreScrollOzD1aCk(j, i);
        return Offset.m1358plusMKHz9U(r0, this.self.m2867onPreScrollOzD1aCk(Offset.m1357minusMKHz9U(j, r0), i));
    }

    /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
    public long m2892onPostScrollDzOQY0M(long j, long j2, int i) {
        long r0 = this.self.m2865onPostScrollDzOQY0M(j, j2, i);
        return Offset.m1358plusMKHz9U(r0, this.parent.m2865onPostScrollDzOQY0M(Offset.m1358plusMKHz9U(j, r0), Offset.m1357minusMKHz9U(j2, r0), i));
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0071 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* renamed from: onPreFling-QWom1Mo  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object m2893onPreFlingQWom1Mo(long r7, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof androidx.compose.ui.input.nestedscroll.ParentWrapperNestedScrollConnection$onPreFling$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            androidx.compose.ui.input.nestedscroll.ParentWrapperNestedScrollConnection$onPreFling$1 r0 = (androidx.compose.ui.input.nestedscroll.ParentWrapperNestedScrollConnection$onPreFling$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            androidx.compose.ui.input.nestedscroll.ParentWrapperNestedScrollConnection$onPreFling$1 r0 = new androidx.compose.ui.input.nestedscroll.ParentWrapperNestedScrollConnection$onPreFling$1
            r0.<init>(r6, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0041
            if (r2 == r4) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            long r7 = r0.J$0
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0073
        L_0x002f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0037:
            long r7 = r0.J$0
            java.lang.Object r2 = r0.L$0
            androidx.compose.ui.input.nestedscroll.ParentWrapperNestedScrollConnection r2 = (androidx.compose.ui.input.nestedscroll.ParentWrapperNestedScrollConnection) r2
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0056
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r9)
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r9 = r6.getParent()
            r0.L$0 = r6
            r0.J$0 = r7
            r0.label = r4
            java.lang.Object r9 = r9.m2866onPreFlingQWom1Mo(r7, r0)
            if (r9 != r1) goto L_0x0055
            return r1
        L_0x0055:
            r2 = r6
        L_0x0056:
            androidx.compose.ui.unit.Velocity r9 = (androidx.compose.ui.unit.Velocity) r9
            long r4 = r9.m4093unboximpl()
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r9 = r2.getSelf()
            long r7 = androidx.compose.ui.unit.Velocity.m4087minusAH228Gc(r7, r4)
            r2 = 0
            r0.L$0 = r2
            r0.J$0 = r4
            r0.label = r3
            java.lang.Object r9 = r9.m2866onPreFlingQWom1Mo(r7, r0)
            if (r9 != r1) goto L_0x0072
            return r1
        L_0x0072:
            r7 = r4
        L_0x0073:
            androidx.compose.ui.unit.Velocity r9 = (androidx.compose.ui.unit.Velocity) r9
            long r0 = r9.m4093unboximpl()
            long r7 = androidx.compose.ui.unit.Velocity.m4088plusAH228Gc(r7, r0)
            androidx.compose.ui.unit.Velocity r7 = androidx.compose.ui.unit.Velocity.m4075boximpl(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.nestedscroll.ParentWrapperNestedScrollConnection.m2893onPreFlingQWom1Mo(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x008b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* renamed from: onPostFling-RZ2iAVY  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object m2891onPostFlingRZ2iAVY(long r16, long r18, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r20) {
        /*
            r15 = this;
            r0 = r15
            r1 = r20
            boolean r2 = r1 instanceof androidx.compose.ui.input.nestedscroll.ParentWrapperNestedScrollConnection$onPostFling$1
            if (r2 == 0) goto L_0x0017
            r2 = r1
            androidx.compose.ui.input.nestedscroll.ParentWrapperNestedScrollConnection$onPostFling$1 r2 = (androidx.compose.ui.input.nestedscroll.ParentWrapperNestedScrollConnection$onPostFling$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0017
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001c
        L_0x0017:
            androidx.compose.ui.input.nestedscroll.ParentWrapperNestedScrollConnection$onPostFling$1 r2 = new androidx.compose.ui.input.nestedscroll.ParentWrapperNestedScrollConnection$onPostFling$1
            r2.<init>(r15, r1)
        L_0x001c:
            java.lang.Object r1 = r2.result
            java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r2.label
            r10 = 2
            r4 = 1
            if (r3 == 0) goto L_0x0048
            if (r3 == r4) goto L_0x003a
            if (r3 != r10) goto L_0x0032
            long r2 = r2.J$0
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x008d
        L_0x0032:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x003a:
            long r3 = r2.J$1
            long r5 = r2.J$0
            java.lang.Object r7 = r2.L$0
            androidx.compose.ui.input.nestedscroll.ParentWrapperNestedScrollConnection r7 = (androidx.compose.ui.input.nestedscroll.ParentWrapperNestedScrollConnection) r7
            kotlin.ResultKt.throwOnFailure(r1)
            r13 = r3
            r11 = r5
            goto L_0x0068
        L_0x0048:
            kotlin.ResultKt.throwOnFailure(r1)
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r3 = r15.getSelf()
            r2.L$0 = r0
            r11 = r16
            r2.J$0 = r11
            r13 = r18
            r2.J$1 = r13
            r2.label = r4
            r4 = r16
            r6 = r18
            r8 = r2
            java.lang.Object r1 = r3.m2864onPostFlingRZ2iAVY(r4, r6, r8)
            if (r1 != r9) goto L_0x0067
            return r9
        L_0x0067:
            r7 = r0
        L_0x0068:
            androidx.compose.ui.unit.Velocity r1 = (androidx.compose.ui.unit.Velocity) r1
            long r4 = r1.m4093unboximpl()
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r3 = r7.getParent()
            long r6 = androidx.compose.ui.unit.Velocity.m4088plusAH228Gc(r11, r4)
            long r11 = androidx.compose.ui.unit.Velocity.m4087minusAH228Gc(r13, r4)
            r1 = 0
            r2.L$0 = r1
            r2.J$0 = r4
            r2.label = r10
            r13 = r4
            r4 = r6
            r6 = r11
            r8 = r2
            java.lang.Object r1 = r3.m2864onPostFlingRZ2iAVY(r4, r6, r8)
            if (r1 != r9) goto L_0x008c
            return r9
        L_0x008c:
            r2 = r13
        L_0x008d:
            androidx.compose.ui.unit.Velocity r1 = (androidx.compose.ui.unit.Velocity) r1
            long r4 = r1.m4093unboximpl()
            long r1 = androidx.compose.ui.unit.Velocity.m4088plusAH228Gc(r2, r4)
            androidx.compose.ui.unit.Velocity r1 = androidx.compose.ui.unit.Velocity.m4075boximpl(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.nestedscroll.ParentWrapperNestedScrollConnection.m2891onPostFlingRZ2iAVY(long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
