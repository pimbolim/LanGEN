package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000=\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001d\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007J7\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013J/\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u001f\u001a\u00020\u0003H\u0016J\b\u0010 \u001a\u00020\u001cH\u0016J\f\u0010!\u001a\u00020\u0003*\u00020\"H\u0016\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006#"}, d2 = {"androidx/compose/foundation/gestures/AndroidOverScrollKt$NoOpOverscrollController$1", "Landroidx/compose/foundation/gestures/OverScrollController;", "consumePostFling", "", "velocity", "Landroidx/compose/ui/unit/Velocity;", "consumePostFling-TH1AsA0", "(J)V", "consumePostScroll", "initialDragDelta", "Landroidx/compose/ui/geometry/Offset;", "overScrollDelta", "pointerPosition", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "consumePostScroll-l7mfB5k", "(JJLandroidx/compose/ui/geometry/Offset;I)V", "consumePreFling", "consumePreFling-AH228Gc", "(J)J", "consumePreScroll", "scrollDelta", "consumePreScroll-A0NYTsA", "(JLandroidx/compose/ui/geometry/Offset;I)J", "refreshContainerInfo", "size", "Landroidx/compose/ui/geometry/Size;", "isContentScrolls", "", "refreshContainerInfo-TmRCtEA", "(JZ)V", "release", "stopOverscrollAnimation", "drawOverScroll", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AndroidOverScroll.kt */
public final class AndroidOverScrollKt$NoOpOverscrollController$1 implements OverScrollController {
    /* renamed from: consumePostFling-TH1AsA0  reason: not valid java name */
    public void m237consumePostFlingTH1AsA0(long j) {
    }

    /* renamed from: consumePostScroll-l7mfB5k  reason: not valid java name */
    public void m238consumePostScrolll7mfB5k(long j, long j2, Offset offset, int i) {
    }

    public void drawOverScroll(DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
    }

    /* renamed from: refreshContainerInfo-TmRCtEA  reason: not valid java name */
    public void m241refreshContainerInfoTmRCtEA(long j, boolean z) {
    }

    public void release() {
    }

    public boolean stopOverscrollAnimation() {
        return false;
    }

    AndroidOverScrollKt$NoOpOverscrollController$1() {
    }

    /* renamed from: consumePreScroll-A0NYTsA  reason: not valid java name */
    public long m240consumePreScrollA0NYTsA(long j, Offset offset, int i) {
        return Offset.Companion.m1369getZeroF1C5BW0();
    }

    /* renamed from: consumePreFling-AH228Gc  reason: not valid java name */
    public long m239consumePreFlingAH228Gc(long j) {
        return Velocity.Companion.m4095getZero9UxMQ8M();
    }
}
