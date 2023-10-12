package androidx.compose.foundation.gestures;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.EdgeEffect;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Velocity;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001d\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010\u0012J7\u0010+\u001a\u00020'2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-2\b\u0010/\u001a\u0004\u0018\u00010-2\u0006\u00100\u001a\u000201H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b2\u00103J\u001d\u00104\u001a\u00020)2\u0006\u0010(\u001a\u00020)H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b5\u00106J/\u00107\u001a\u00020-2\u0006\u00108\u001a\u00020-2\b\u0010/\u001a\u0004\u0018\u00010-2\u0006\u00100\u001a\u000201H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b9\u0010:J\b\u0010;\u001a\u00020\u0015H\u0002J\b\u0010<\u001a\u00020'H\u0002J%\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020-2\u0006\u0010@\u001a\u00020-H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bA\u0010BJ%\u0010C\u001a\u00020>2\u0006\u0010?\u001a\u00020-2\u0006\u0010@\u001a\u00020-H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bD\u0010BJ%\u0010E\u001a\u00020>2\u0006\u0010?\u001a\u00020-2\u0006\u0010@\u001a\u00020-H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bF\u0010BJ%\u0010G\u001a\u00020>2\u0006\u0010?\u001a\u00020-2\u0006\u0010@\u001a\u00020-H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bH\u0010BJ%\u0010I\u001a\u00020'2\u0006\u0010J\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bK\u0010LJ\b\u0010M\u001a\u00020'H\u0016J\u001d\u0010N\u001a\u00020\u00152\u0006\u0010O\u001a\u00020-H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bP\u0010QJ\b\u0010R\u001a\u00020\u0015H\u0016J \u0010S\u001a\u00020\u0015*\u00020T2\u0006\u0010U\u001a\u00020\t2\n\u0010V\u001a\u00060Wj\u0002`XH\u0002J \u0010Y\u001a\u00020\u0015*\u00020T2\u0006\u0010Z\u001a\u00020\t2\n\u0010V\u001a\u00060Wj\u0002`XH\u0002J\f\u0010[\u001a\u00020'*\u00020TH\u0016J \u0010\\\u001a\u00020\u0015*\u00020T2\u0006\u0010]\u001a\u00020\t2\n\u0010V\u001a\u00060Wj\u0002`XH\u0002J \u0010^\u001a\u00020\u0015*\u00020T2\u0006\u0010_\u001a\u00020\t2\n\u0010V\u001a\u00060Wj\u0002`XH\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R4\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8B@BX\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R+\u0010\u0016\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u00158B@BX\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006`"}, d2 = {"Landroidx/compose/foundation/gestures/AndroidEdgeEffectOverScrollController;", "Landroidx/compose/foundation/gestures/OverScrollController;", "context", "Landroid/content/Context;", "overScrollConfig", "Landroidx/compose/foundation/gestures/OverScrollConfiguration;", "(Landroid/content/Context;Landroidx/compose/foundation/gestures/OverScrollConfiguration;)V", "allEffects", "", "Landroid/widget/EdgeEffect;", "bottomEffect", "bottomEffectNegation", "<set-?>", "Landroidx/compose/ui/geometry/Size;", "containerSize", "getContainerSize-NH-jbRc", "()J", "setContainerSize-uvyYCjk", "(J)V", "containerSize$delegate", "Landroidx/compose/runtime/MutableState;", "", "isContentScrolls", "()Z", "setContentScrolls", "(Z)V", "isContentScrolls$delegate", "leftEffect", "leftEffectNegation", "getOverScrollConfig", "()Landroidx/compose/foundation/gestures/OverScrollConfiguration;", "redrawSignal", "Landroidx/compose/runtime/MutableState;", "", "rightEffect", "rightEffectNegation", "topEffect", "topEffectNegation", "consumePostFling", "", "velocity", "Landroidx/compose/ui/unit/Velocity;", "consumePostFling-TH1AsA0", "consumePostScroll", "initialDragDelta", "Landroidx/compose/ui/geometry/Offset;", "overScrollDelta", "pointerPosition", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "consumePostScroll-l7mfB5k", "(JJLandroidx/compose/ui/geometry/Offset;I)V", "consumePreFling", "consumePreFling-AH228Gc", "(J)J", "consumePreScroll", "scrollDelta", "consumePreScroll-A0NYTsA", "(JLandroidx/compose/ui/geometry/Offset;I)J", "ignoreOverscroll", "invalidateOverScroll", "pullBottom", "", "scroll", "displacement", "pullBottom-0a9Yr6o", "(JJ)F", "pullLeft", "pullLeft-0a9Yr6o", "pullRight", "pullRight-0a9Yr6o", "pullTop", "pullTop-0a9Yr6o", "refreshContainerInfo", "size", "refreshContainerInfo-TmRCtEA", "(JZ)V", "release", "releaseOppositeOverscroll", "delta", "releaseOppositeOverscroll-k-4lQ0M", "(J)Z", "stopOverscrollAnimation", "drawBottom", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "bottom", "canvas", "Landroid/graphics/Canvas;", "Landroidx/compose/ui/graphics/NativeCanvas;", "drawLeft", "left", "drawOverScroll", "drawRight", "right", "drawTop", "top", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AndroidOverScroll.kt */
final class AndroidEdgeEffectOverScrollController implements OverScrollController {
    private final List<EdgeEffect> allEffects;
    private final EdgeEffect bottomEffect;
    private final EdgeEffect bottomEffectNegation;
    private final MutableState containerSize$delegate;
    private final MutableState isContentScrolls$delegate;
    private final EdgeEffect leftEffect;
    private final EdgeEffect leftEffectNegation;
    private final OverScrollConfiguration overScrollConfig;
    private final MutableState<Integer> redrawSignal;
    private final EdgeEffect rightEffect;
    private final EdgeEffect rightEffectNegation;
    private final EdgeEffect topEffect;
    private final EdgeEffect topEffectNegation;

    public AndroidEdgeEffectOverScrollController(Context context, OverScrollConfiguration overScrollConfiguration) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(overScrollConfiguration, "overScrollConfig");
        this.overScrollConfig = overScrollConfiguration;
        EdgeEffect create = EdgeEffectCompat.INSTANCE.create(context, (AttributeSet) null);
        this.topEffect = create;
        EdgeEffect create2 = EdgeEffectCompat.INSTANCE.create(context, (AttributeSet) null);
        this.bottomEffect = create2;
        EdgeEffect create3 = EdgeEffectCompat.INSTANCE.create(context, (AttributeSet) null);
        this.leftEffect = create3;
        EdgeEffect create4 = EdgeEffectCompat.INSTANCE.create(context, (AttributeSet) null);
        this.rightEffect = create4;
        List<EdgeEffect> listOf = CollectionsKt.listOf(create3, create, create4, create2);
        this.allEffects = listOf;
        this.topEffectNegation = EdgeEffectCompat.INSTANCE.create(context, (AttributeSet) null);
        this.bottomEffectNegation = EdgeEffectCompat.INSTANCE.create(context, (AttributeSet) null);
        this.leftEffectNegation = EdgeEffectCompat.INSTANCE.create(context, (AttributeSet) null);
        this.rightEffectNegation = EdgeEffectCompat.INSTANCE.create(context, (AttributeSet) null);
        int size = listOf.size();
        for (int i = 0; i < size; i++) {
            listOf.get(i).setColor(ColorKt.m1651toArgb8_81llA(getOverScrollConfig().m277getGlowColor0d7_KjU()));
        }
        this.redrawSignal = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.containerSize$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Size.m1410boximpl(Size.Companion.m1431getZeroNHjbRc()), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.isContentScrolls$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    public final OverScrollConfiguration getOverScrollConfig() {
        return this.overScrollConfig;
    }

    private final void invalidateOverScroll() {
        MutableState<Integer> mutableState = this.redrawSignal;
        mutableState.setValue(Integer.valueOf(mutableState.getValue().intValue() + 1));
    }

    public void release() {
        if (!ignoreOverscroll()) {
            List<EdgeEffect> list = this.allEffects;
            int size = list.size();
            int i = 0;
            boolean z = false;
            while (i < size) {
                int i2 = i + 1;
                EdgeEffect edgeEffect = list.get(i);
                edgeEffect.onRelease();
                z = edgeEffect.isFinished() || z;
                i = i2;
            }
            if (z) {
                invalidateOverScroll();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0101  */
    /* renamed from: consumePreScroll-A0NYTsA  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long m235consumePreScrollA0NYTsA(long r7, androidx.compose.ui.geometry.Offset r9, int r10) {
        /*
            r6 = this;
            boolean r0 = r6.ignoreOverscroll()
            if (r0 != 0) goto L_0x0105
            androidx.compose.ui.input.nestedscroll.NestedScrollSource$Companion r0 = androidx.compose.ui.input.nestedscroll.NestedScrollSource.Companion
            int r0 = r0.m2888getDragWNlRxjI()
            boolean r10 = androidx.compose.ui.input.nestedscroll.NestedScrollSource.m2883equalsimpl0(r10, r0)
            if (r10 != 0) goto L_0x0014
            goto L_0x0105
        L_0x0014:
            if (r9 != 0) goto L_0x001f
            long r9 = r6.m225getContainerSizeNHjbRc()
            long r9 = androidx.compose.ui.geometry.SizeKt.m1432getCenteruvyYCjk(r9)
            goto L_0x0023
        L_0x001f:
            long r9 = r9.m1363unboximpl()
        L_0x0023:
            float r0 = androidx.compose.ui.geometry.Offset.m1354getYimpl(r7)
            r1 = 1
            r2 = 0
            r3 = 0
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x0030
            r0 = 1
            goto L_0x0031
        L_0x0030:
            r0 = 0
        L_0x0031:
            if (r0 == 0) goto L_0x0035
        L_0x0033:
            r0 = 0
            goto L_0x008c
        L_0x0035:
            androidx.compose.foundation.gestures.EdgeEffectCompat r0 = androidx.compose.foundation.gestures.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r4 = r6.topEffect
            float r0 = r0.getDistanceCompat(r4)
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x0043
            r0 = 1
            goto L_0x0044
        L_0x0043:
            r0 = 0
        L_0x0044:
            if (r0 != 0) goto L_0x0061
            float r0 = r6.m229pullTop0a9Yr6o(r7, r9)
            androidx.compose.foundation.gestures.EdgeEffectCompat r4 = androidx.compose.foundation.gestures.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r5 = r6.topEffect
            float r4 = r4.getDistanceCompat(r5)
            int r4 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r4 != 0) goto L_0x0058
            r4 = 1
            goto L_0x0059
        L_0x0058:
            r4 = 0
        L_0x0059:
            if (r4 == 0) goto L_0x008c
            android.widget.EdgeEffect r4 = r6.topEffect
            r4.onRelease()
            goto L_0x008c
        L_0x0061:
            androidx.compose.foundation.gestures.EdgeEffectCompat r0 = androidx.compose.foundation.gestures.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r4 = r6.bottomEffect
            float r0 = r0.getDistanceCompat(r4)
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x006f
            r0 = 1
            goto L_0x0070
        L_0x006f:
            r0 = 0
        L_0x0070:
            if (r0 != 0) goto L_0x0033
            float r0 = r6.m226pullBottom0a9Yr6o(r7, r9)
            androidx.compose.foundation.gestures.EdgeEffectCompat r4 = androidx.compose.foundation.gestures.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r5 = r6.bottomEffect
            float r4 = r4.getDistanceCompat(r5)
            int r4 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r4 != 0) goto L_0x0084
            r4 = 1
            goto L_0x0085
        L_0x0084:
            r4 = 0
        L_0x0085:
            if (r4 == 0) goto L_0x008c
            android.widget.EdgeEffect r4 = r6.bottomEffect
            r4.onRelease()
        L_0x008c:
            float r4 = androidx.compose.ui.geometry.Offset.m1353getXimpl(r7)
            int r4 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r4 != 0) goto L_0x0096
            r4 = 1
            goto L_0x0097
        L_0x0096:
            r4 = 0
        L_0x0097:
            if (r4 == 0) goto L_0x009a
            goto L_0x00f1
        L_0x009a:
            androidx.compose.foundation.gestures.EdgeEffectCompat r4 = androidx.compose.foundation.gestures.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r5 = r6.leftEffect
            float r4 = r4.getDistanceCompat(r5)
            int r4 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r4 != 0) goto L_0x00a8
            r4 = 1
            goto L_0x00a9
        L_0x00a8:
            r4 = 0
        L_0x00a9:
            if (r4 != 0) goto L_0x00c6
            float r7 = r6.m227pullLeft0a9Yr6o(r7, r9)
            androidx.compose.foundation.gestures.EdgeEffectCompat r8 = androidx.compose.foundation.gestures.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r9 = r6.leftEffect
            float r8 = r8.getDistanceCompat(r9)
            int r8 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r8 != 0) goto L_0x00bc
            goto L_0x00bd
        L_0x00bc:
            r1 = 0
        L_0x00bd:
            if (r1 == 0) goto L_0x00c4
            android.widget.EdgeEffect r8 = r6.leftEffect
            r8.onRelease()
        L_0x00c4:
            r3 = r7
            goto L_0x00f1
        L_0x00c6:
            androidx.compose.foundation.gestures.EdgeEffectCompat r4 = androidx.compose.foundation.gestures.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r5 = r6.rightEffect
            float r4 = r4.getDistanceCompat(r5)
            int r4 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r4 != 0) goto L_0x00d4
            r4 = 1
            goto L_0x00d5
        L_0x00d4:
            r4 = 0
        L_0x00d5:
            if (r4 != 0) goto L_0x00f1
            float r7 = r6.m228pullRight0a9Yr6o(r7, r9)
            androidx.compose.foundation.gestures.EdgeEffectCompat r8 = androidx.compose.foundation.gestures.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r9 = r6.rightEffect
            float r8 = r8.getDistanceCompat(r9)
            int r8 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r8 != 0) goto L_0x00e8
            goto L_0x00e9
        L_0x00e8:
            r1 = 0
        L_0x00e9:
            if (r1 == 0) goto L_0x00c4
            android.widget.EdgeEffect r8 = r6.rightEffect
            r8.onRelease()
            goto L_0x00c4
        L_0x00f1:
            long r7 = androidx.compose.ui.geometry.OffsetKt.Offset(r3, r0)
            androidx.compose.ui.geometry.Offset$Companion r9 = androidx.compose.ui.geometry.Offset.Companion
            long r9 = r9.m1369getZeroF1C5BW0()
            boolean r9 = androidx.compose.ui.geometry.Offset.m1350equalsimpl0(r7, r9)
            if (r9 != 0) goto L_0x0104
            r6.invalidateOverScroll()
        L_0x0104:
            return r7
        L_0x0105:
            androidx.compose.ui.geometry.Offset$Companion r7 = androidx.compose.ui.geometry.Offset.Companion
            long r7 = r7.m1369getZeroF1C5BW0()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.AndroidEdgeEffectOverScrollController.m235consumePreScrollA0NYTsA(long, androidx.compose.ui.geometry.Offset, int):long");
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* renamed from: consumePostScroll-l7mfB5k  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m233consumePostScrolll7mfB5k(long r5, long r7, androidx.compose.ui.geometry.Offset r9, int r10) {
        /*
            r4 = this;
            boolean r0 = r4.ignoreOverscroll()
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            androidx.compose.ui.input.nestedscroll.NestedScrollSource$Companion r0 = androidx.compose.ui.input.nestedscroll.NestedScrollSource.Companion
            int r0 = r0.m2888getDragWNlRxjI()
            boolean r10 = androidx.compose.ui.input.nestedscroll.NestedScrollSource.m2883equalsimpl0(r10, r0)
            r0 = 1
            r1 = 0
            if (r10 == 0) goto L_0x0062
            if (r9 != 0) goto L_0x0020
            long r9 = r4.m225getContainerSizeNHjbRc()
            long r9 = androidx.compose.ui.geometry.SizeKt.m1432getCenteruvyYCjk(r9)
            goto L_0x0024
        L_0x0020:
            long r9 = r9.m1363unboximpl()
        L_0x0024:
            float r2 = androidx.compose.ui.geometry.Offset.m1353getXimpl(r7)
            r3 = 0
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 <= 0) goto L_0x0031
            r4.m227pullLeft0a9Yr6o(r7, r9)
            goto L_0x003c
        L_0x0031:
            float r2 = androidx.compose.ui.geometry.Offset.m1353getXimpl(r7)
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 >= 0) goto L_0x003c
            r4.m228pullRight0a9Yr6o(r7, r9)
        L_0x003c:
            float r2 = androidx.compose.ui.geometry.Offset.m1354getYimpl(r7)
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 <= 0) goto L_0x0048
            r4.m229pullTop0a9Yr6o(r7, r9)
            goto L_0x0053
        L_0x0048:
            float r2 = androidx.compose.ui.geometry.Offset.m1354getYimpl(r7)
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 >= 0) goto L_0x0053
            r4.m226pullBottom0a9Yr6o(r7, r9)
        L_0x0053:
            androidx.compose.ui.geometry.Offset$Companion r9 = androidx.compose.ui.geometry.Offset.Companion
            long r9 = r9.m1369getZeroF1C5BW0()
            boolean r7 = androidx.compose.ui.geometry.Offset.m1350equalsimpl0(r7, r9)
            if (r7 == 0) goto L_0x0060
            goto L_0x0062
        L_0x0060:
            r7 = 1
            goto L_0x0063
        L_0x0062:
            r7 = 0
        L_0x0063:
            boolean r5 = r4.m230releaseOppositeOverscrollk4lQ0M(r5)
            if (r5 != 0) goto L_0x006d
            if (r7 == 0) goto L_0x006c
            goto L_0x006d
        L_0x006c:
            r0 = 0
        L_0x006d:
            if (r0 == 0) goto L_0x0072
            r4.invalidateOverScroll()
        L_0x0072:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.AndroidEdgeEffectOverScrollController.m233consumePostScrolll7mfB5k(long, long, androidx.compose.ui.geometry.Offset, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d5  */
    /* renamed from: consumePreFling-AH228Gc  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long m234consumePreFlingAH228Gc(long r7) {
        /*
            r6 = this;
            boolean r0 = r6.ignoreOverscroll()
            if (r0 == 0) goto L_0x000d
            androidx.compose.ui.unit.Velocity$Companion r7 = androidx.compose.ui.unit.Velocity.Companion
            long r7 = r7.m4095getZero9UxMQ8M()
            return r7
        L_0x000d:
            float r0 = androidx.compose.ui.unit.Velocity.m4084getXimpl(r7)
            r1 = 1
            r2 = 0
            r3 = 0
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x003d
            androidx.compose.foundation.gestures.EdgeEffectCompat r0 = androidx.compose.foundation.gestures.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r4 = r6.leftEffect
            float r0 = r0.getDistanceCompat(r4)
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x0026
            r0 = 1
            goto L_0x0027
        L_0x0026:
            r0 = 0
        L_0x0027:
            if (r0 != 0) goto L_0x003d
            androidx.compose.foundation.gestures.EdgeEffectCompat r0 = androidx.compose.foundation.gestures.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r4 = r6.leftEffect
            float r5 = androidx.compose.ui.unit.Velocity.m4084getXimpl(r7)
            int r5 = kotlin.math.MathKt.roundToInt((float) r5)
            r0.onAbsorbCompat(r4, r5)
            float r0 = androidx.compose.ui.unit.Velocity.m4084getXimpl(r7)
            goto L_0x006c
        L_0x003d:
            float r0 = androidx.compose.ui.unit.Velocity.m4084getXimpl(r7)
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x006b
            androidx.compose.foundation.gestures.EdgeEffectCompat r0 = androidx.compose.foundation.gestures.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r4 = r6.rightEffect
            float r0 = r0.getDistanceCompat(r4)
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x0053
            r0 = 1
            goto L_0x0054
        L_0x0053:
            r0 = 0
        L_0x0054:
            if (r0 != 0) goto L_0x006b
            androidx.compose.foundation.gestures.EdgeEffectCompat r0 = androidx.compose.foundation.gestures.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r4 = r6.rightEffect
            float r5 = androidx.compose.ui.unit.Velocity.m4084getXimpl(r7)
            int r5 = kotlin.math.MathKt.roundToInt((float) r5)
            int r5 = -r5
            r0.onAbsorbCompat(r4, r5)
            float r0 = androidx.compose.ui.unit.Velocity.m4084getXimpl(r7)
            goto L_0x006c
        L_0x006b:
            r0 = 0
        L_0x006c:
            float r4 = androidx.compose.ui.unit.Velocity.m4085getYimpl(r7)
            int r4 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r4 <= 0) goto L_0x0099
            androidx.compose.foundation.gestures.EdgeEffectCompat r4 = androidx.compose.foundation.gestures.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r5 = r6.topEffect
            float r4 = r4.getDistanceCompat(r5)
            int r4 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r4 != 0) goto L_0x0082
            r4 = 1
            goto L_0x0083
        L_0x0082:
            r4 = 0
        L_0x0083:
            if (r4 != 0) goto L_0x0099
            androidx.compose.foundation.gestures.EdgeEffectCompat r1 = androidx.compose.foundation.gestures.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r2 = r6.topEffect
            float r3 = androidx.compose.ui.unit.Velocity.m4085getYimpl(r7)
            int r3 = kotlin.math.MathKt.roundToInt((float) r3)
            r1.onAbsorbCompat(r2, r3)
            float r3 = androidx.compose.ui.unit.Velocity.m4085getYimpl(r7)
            goto L_0x00c5
        L_0x0099:
            float r4 = androidx.compose.ui.unit.Velocity.m4085getYimpl(r7)
            int r4 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r4 >= 0) goto L_0x00c5
            androidx.compose.foundation.gestures.EdgeEffectCompat r4 = androidx.compose.foundation.gestures.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r5 = r6.bottomEffect
            float r4 = r4.getDistanceCompat(r5)
            int r4 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r4 != 0) goto L_0x00ae
            goto L_0x00af
        L_0x00ae:
            r1 = 0
        L_0x00af:
            if (r1 != 0) goto L_0x00c5
            androidx.compose.foundation.gestures.EdgeEffectCompat r1 = androidx.compose.foundation.gestures.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r2 = r6.bottomEffect
            float r3 = androidx.compose.ui.unit.Velocity.m4085getYimpl(r7)
            int r3 = kotlin.math.MathKt.roundToInt((float) r3)
            int r3 = -r3
            r1.onAbsorbCompat(r2, r3)
            float r3 = androidx.compose.ui.unit.Velocity.m4085getYimpl(r7)
        L_0x00c5:
            long r7 = androidx.compose.ui.unit.VelocityKt.Velocity(r0, r3)
            androidx.compose.ui.unit.Velocity$Companion r0 = androidx.compose.ui.unit.Velocity.Companion
            long r0 = r0.m4095getZero9UxMQ8M()
            boolean r0 = androidx.compose.ui.unit.Velocity.m4083equalsimpl0(r7, r0)
            if (r0 != 0) goto L_0x00d8
            r6.invalidateOverScroll()
        L_0x00d8:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.AndroidEdgeEffectOverScrollController.m234consumePreFlingAH228Gc(long):long");
    }

    /* renamed from: consumePostFling-TH1AsA0  reason: not valid java name */
    public void m232consumePostFlingTH1AsA0(long j) {
        if (!ignoreOverscroll()) {
            if (Velocity.m4084getXimpl(j) > 0.0f) {
                EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.leftEffect, MathKt.roundToInt(Velocity.m4084getXimpl(j)));
            } else if (Velocity.m4084getXimpl(j) < 0.0f) {
                EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.rightEffect, -MathKt.roundToInt(Velocity.m4084getXimpl(j)));
            }
            if (Velocity.m4085getYimpl(j) > 0.0f) {
                EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.topEffect, MathKt.roundToInt(Velocity.m4085getYimpl(j)));
            } else if (Velocity.m4085getYimpl(j) < 0.0f) {
                EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.bottomEffect, -MathKt.roundToInt(Velocity.m4085getYimpl(j)));
            }
            if (!Velocity.m4083equalsimpl0(j, Velocity.Companion.m4095getZero9UxMQ8M())) {
                invalidateOverScroll();
            }
        }
    }

    /* renamed from: getContainerSize-NH-jbRc  reason: not valid java name */
    private final long m225getContainerSizeNHjbRc() {
        return ((Size) this.containerSize$delegate.getValue()).m1427unboximpl();
    }

    /* renamed from: setContainerSize-uvyYCjk  reason: not valid java name */
    private final void m231setContainerSizeuvyYCjk(long j) {
        this.containerSize$delegate.setValue(Size.m1410boximpl(j));
    }

    private final boolean isContentScrolls() {
        return ((Boolean) this.isContentScrolls$delegate.getValue()).booleanValue();
    }

    private final void setContentScrolls(boolean z) {
        this.isContentScrolls$delegate.setValue(Boolean.valueOf(z));
    }

    /* renamed from: refreshContainerInfo-TmRCtEA  reason: not valid java name */
    public void m236refreshContainerInfoTmRCtEA(long j, boolean z) {
        boolean z2 = true;
        boolean z3 = !Size.m1418equalsimpl0(j, m225getContainerSizeNHjbRc());
        if (isContentScrolls() == z) {
            z2 = false;
        }
        m231setContainerSizeuvyYCjk(j);
        setContentScrolls(z);
        if (z3) {
            this.topEffect.setSize(MathKt.roundToInt(Size.m1422getWidthimpl(j)), MathKt.roundToInt(Size.m1419getHeightimpl(j)));
            this.bottomEffect.setSize(MathKt.roundToInt(Size.m1422getWidthimpl(j)), MathKt.roundToInt(Size.m1419getHeightimpl(j)));
            this.leftEffect.setSize(MathKt.roundToInt(Size.m1419getHeightimpl(j)), MathKt.roundToInt(Size.m1422getWidthimpl(j)));
            this.rightEffect.setSize(MathKt.roundToInt(Size.m1419getHeightimpl(j)), MathKt.roundToInt(Size.m1422getWidthimpl(j)));
            this.topEffectNegation.setSize(MathKt.roundToInt(Size.m1422getWidthimpl(j)), MathKt.roundToInt(Size.m1419getHeightimpl(j)));
            this.bottomEffectNegation.setSize(MathKt.roundToInt(Size.m1422getWidthimpl(j)), MathKt.roundToInt(Size.m1419getHeightimpl(j)));
            this.leftEffectNegation.setSize(MathKt.roundToInt(Size.m1419getHeightimpl(j)), MathKt.roundToInt(Size.m1422getWidthimpl(j)));
            this.rightEffectNegation.setSize(MathKt.roundToInt(Size.m1419getHeightimpl(j)), MathKt.roundToInt(Size.m1422getWidthimpl(j)));
        }
        if (z2 || z3) {
            release();
        }
    }

    private final boolean drawLeft(DrawScope drawScope, EdgeEffect edgeEffect, Canvas canvas) {
        int save = canvas.save();
        canvas.rotate(270.0f);
        canvas.translate(-Size.m1419getHeightimpl(m225getContainerSizeNHjbRc()), drawScope.m3828toPx0680j_4(this.overScrollConfig.getDrawPadding().m442calculateLeftPaddingu2uoSUM(drawScope.getLayoutDirection())));
        boolean draw = edgeEffect.draw(canvas);
        canvas.restoreToCount(save);
        return draw;
    }

    private final boolean drawTop(DrawScope drawScope, EdgeEffect edgeEffect, Canvas canvas) {
        int save = canvas.save();
        canvas.translate(0.0f, drawScope.m3828toPx0680j_4(this.overScrollConfig.getDrawPadding().m444calculateTopPaddingD9Ej5fM()));
        boolean draw = edgeEffect.draw(canvas);
        canvas.restoreToCount(save);
        return draw;
    }

    private final boolean drawRight(DrawScope drawScope, EdgeEffect edgeEffect, Canvas canvas) {
        int save = canvas.save();
        int roundToInt = MathKt.roundToInt(Size.m1422getWidthimpl(m225getContainerSizeNHjbRc()));
        float r2 = this.overScrollConfig.getDrawPadding().m443calculateRightPaddingu2uoSUM(drawScope.getLayoutDirection());
        canvas.rotate(90.0f);
        canvas.translate(0.0f, (-((float) roundToInt)) + drawScope.m3828toPx0680j_4(r2));
        boolean draw = edgeEffect.draw(canvas);
        canvas.restoreToCount(save);
        return draw;
    }

    private final boolean drawBottom(DrawScope drawScope, EdgeEffect edgeEffect, Canvas canvas) {
        int save = canvas.save();
        canvas.rotate(180.0f);
        canvas.translate(-Size.m1422getWidthimpl(m225getContainerSizeNHjbRc()), (-Size.m1419getHeightimpl(m225getContainerSizeNHjbRc())) + drawScope.m3828toPx0680j_4(this.overScrollConfig.getDrawPadding().m441calculateBottomPaddingD9Ej5fM()));
        boolean draw = edgeEffect.draw(canvas);
        canvas.restoreToCount(save);
        return draw;
    }

    public boolean stopOverscrollAnimation() {
        boolean z;
        long r0 = SizeKt.m1432getCenteruvyYCjk(m225getContainerSizeNHjbRc());
        boolean z2 = false;
        if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(this.leftEffect) == 0.0f)) {
            m227pullLeft0a9Yr6o(Offset.Companion.m1369getZeroF1C5BW0(), r0);
            z = true;
        } else {
            z = false;
        }
        if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(this.rightEffect) == 0.0f)) {
            m228pullRight0a9Yr6o(Offset.Companion.m1369getZeroF1C5BW0(), r0);
            z = true;
        }
        if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(this.topEffect) == 0.0f)) {
            m229pullTop0a9Yr6o(Offset.Companion.m1369getZeroF1C5BW0(), r0);
            z = true;
        }
        if (EdgeEffectCompat.INSTANCE.getDistanceCompat(this.bottomEffect) == 0.0f) {
            z2 = true;
        }
        if (z2) {
            return z;
        }
        m226pullBottom0a9Yr6o(Offset.Companion.m1369getZeroF1C5BW0(), r0);
        return true;
    }

    /* renamed from: releaseOppositeOverscroll-k-4lQ0M  reason: not valid java name */
    private final boolean m230releaseOppositeOverscrollk4lQ0M(long j) {
        boolean z;
        boolean z2 = false;
        if (this.leftEffect.isFinished() || Offset.m1353getXimpl(j) >= 0.0f) {
            z = false;
        } else {
            this.leftEffect.onRelease();
            z = this.leftEffect.isFinished();
        }
        if (!this.rightEffect.isFinished() && Offset.m1353getXimpl(j) > 0.0f) {
            this.rightEffect.onRelease();
            z = z || this.rightEffect.isFinished();
        }
        if (!this.topEffect.isFinished() && Offset.m1354getYimpl(j) < 0.0f) {
            this.topEffect.onRelease();
            z = z || this.topEffect.isFinished();
        }
        if (this.bottomEffect.isFinished() || Offset.m1354getYimpl(j) <= 0.0f) {
            return z;
        }
        this.bottomEffect.onRelease();
        if (z || this.bottomEffect.isFinished()) {
            z2 = true;
        }
        return z2;
    }

    /* renamed from: pullTop-0a9Yr6o  reason: not valid java name */
    private final float m229pullTop0a9Yr6o(long j, long j2) {
        float r5 = Offset.m1353getXimpl(j2) / Size.m1422getWidthimpl(m225getContainerSizeNHjbRc());
        return EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.topEffect, Offset.m1354getYimpl(j) / Size.m1419getHeightimpl(m225getContainerSizeNHjbRc()), r5) * Size.m1419getHeightimpl(m225getContainerSizeNHjbRc());
    }

    /* renamed from: pullBottom-0a9Yr6o  reason: not valid java name */
    private final float m226pullBottom0a9Yr6o(long j, long j2) {
        float r5 = Offset.m1353getXimpl(j2) / Size.m1422getWidthimpl(m225getContainerSizeNHjbRc());
        return (-EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.bottomEffect, -(Offset.m1354getYimpl(j) / Size.m1419getHeightimpl(m225getContainerSizeNHjbRc())), ((float) 1) - r5)) * Size.m1419getHeightimpl(m225getContainerSizeNHjbRc());
    }

    /* renamed from: pullLeft-0a9Yr6o  reason: not valid java name */
    private final float m227pullLeft0a9Yr6o(long j, long j2) {
        float r5 = Offset.m1354getYimpl(j2) / Size.m1419getHeightimpl(m225getContainerSizeNHjbRc());
        return EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.leftEffect, Offset.m1353getXimpl(j) / Size.m1422getWidthimpl(m225getContainerSizeNHjbRc()), ((float) 1) - r5) * Size.m1422getWidthimpl(m225getContainerSizeNHjbRc());
    }

    /* renamed from: pullRight-0a9Yr6o  reason: not valid java name */
    private final float m228pullRight0a9Yr6o(long j, long j2) {
        return (-EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.rightEffect, -(Offset.m1353getXimpl(j) / Size.m1422getWidthimpl(m225getContainerSizeNHjbRc())), Offset.m1354getYimpl(j2) / Size.m1419getHeightimpl(m225getContainerSizeNHjbRc()))) * Size.m1422getWidthimpl(m225getContainerSizeNHjbRc());
    }

    private final boolean ignoreOverscroll() {
        return !this.overScrollConfig.getForceShowAlways() && !isContentScrolls();
    }

    public void drawOverScroll(DrawScope drawScope) {
        boolean z;
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        androidx.compose.ui.graphics.Canvas canvas = drawScope.getDrawContext().getCanvas();
        this.redrawSignal.getValue();
        if (!ignoreOverscroll()) {
            Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
            boolean z2 = true;
            if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(this.leftEffectNegation) == 0.0f)) {
                drawRight(drawScope, this.leftEffectNegation, nativeCanvas);
                this.leftEffectNegation.finish();
            }
            if (!this.leftEffect.isFinished()) {
                z = drawLeft(drawScope, this.leftEffect, nativeCanvas);
                EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.leftEffectNegation, EdgeEffectCompat.INSTANCE.getDistanceCompat(this.leftEffect), 0.0f);
            } else {
                z = false;
            }
            if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(this.topEffectNegation) == 0.0f)) {
                drawBottom(drawScope, this.topEffectNegation, nativeCanvas);
                this.topEffectNegation.finish();
            }
            if (!this.topEffect.isFinished()) {
                z = drawTop(drawScope, this.topEffect, nativeCanvas) || z;
                EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.topEffectNegation, EdgeEffectCompat.INSTANCE.getDistanceCompat(this.topEffect), 0.0f);
            }
            if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(this.rightEffectNegation) == 0.0f)) {
                drawLeft(drawScope, this.rightEffectNegation, nativeCanvas);
                this.rightEffectNegation.finish();
            }
            if (!this.rightEffect.isFinished()) {
                z = drawRight(drawScope, this.rightEffect, nativeCanvas) || z;
                EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.rightEffectNegation, EdgeEffectCompat.INSTANCE.getDistanceCompat(this.rightEffect), 0.0f);
            }
            if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(this.bottomEffectNegation) == 0.0f)) {
                drawTop(drawScope, this.bottomEffectNegation, nativeCanvas);
                this.bottomEffectNegation.finish();
            }
            if (!this.bottomEffect.isFinished()) {
                if (!drawBottom(drawScope, this.bottomEffect, nativeCanvas) && !z) {
                    z2 = false;
                }
                EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.bottomEffectNegation, EdgeEffectCompat.INSTANCE.getDistanceCompat(this.bottomEffect), 0.0f);
                z = z2;
            }
            if (z) {
                invalidateOverScroll();
            }
        }
    }
}
