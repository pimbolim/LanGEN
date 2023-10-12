package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NestedScrollModifier.kt */
public interface NestedScrollConnection {
    /* renamed from: onPostFling-RZ2iAVY  reason: not valid java name */
    Object m2864onPostFlingRZ2iAVY(long j, long j2, Continuation<? super Velocity> continuation);

    /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
    long m2865onPostScrollDzOQY0M(long j, long j2, int i);

    /* renamed from: onPreFling-QWom1Mo  reason: not valid java name */
    Object m2866onPreFlingQWom1Mo(long j, Continuation<? super Velocity> continuation);

    /* renamed from: onPreScroll-OzD1aCk  reason: not valid java name */
    long m2867onPreScrollOzD1aCk(long j, int i);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: NestedScrollModifier.kt */
    public static final class DefaultImpls {
        /* renamed from: onPreScroll-OzD1aCk  reason: not valid java name */
        public static long m2871onPreScrollOzD1aCk(NestedScrollConnection nestedScrollConnection, long j, int i) {
            Intrinsics.checkNotNullParameter(nestedScrollConnection, "this");
            return Offset.Companion.m1369getZeroF1C5BW0();
        }

        /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
        public static long m2869onPostScrollDzOQY0M(NestedScrollConnection nestedScrollConnection, long j, long j2, int i) {
            Intrinsics.checkNotNullParameter(nestedScrollConnection, "this");
            return Offset.Companion.m1369getZeroF1C5BW0();
        }

        /* renamed from: onPreFling-QWom1Mo  reason: not valid java name */
        public static Object m2870onPreFlingQWom1Mo(NestedScrollConnection nestedScrollConnection, long j, Continuation<? super Velocity> continuation) {
            return Velocity.m4075boximpl(Velocity.Companion.m4095getZero9UxMQ8M());
        }

        /* renamed from: onPostFling-RZ2iAVY  reason: not valid java name */
        public static Object m2868onPostFlingRZ2iAVY(NestedScrollConnection nestedScrollConnection, long j, long j2, Continuation<? super Velocity> continuation) {
            return Velocity.m4075boximpl(Velocity.Companion.m4095getZero9UxMQ8M());
        }
    }
}
