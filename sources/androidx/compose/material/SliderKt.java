package androidx.compose.material;

import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.HoverableKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.ProgressSemanticsKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aE\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\u0006\u0010\u0019\u001a\u00020\bH\u0003¢\u0006\u0002\u0010\u001a\u001a\u0010\u001b\u001a\u00020\u00122\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\u0018\u0010\u001d\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0016\u0012\u0004\u0012\u00020\u00120\u00142\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020 2\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\b\b\u0002\u0010!\u001a\u00020\"2\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010$2\b\b\u0002\u0010%\u001a\u00020&H\u0007¢\u0006\u0002\u0010'\u001a[\u0010(\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\b2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\b0,2\u0006\u0010%\u001a\u00020&2\u0006\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/2\u0006\u0010\u001e\u001a\u00020\u0001H\u0003¢\u0006\u0002\u00101\u001a}\u00102\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\b2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00120\u00142\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020 2\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\b\b\u0002\u0010!\u001a\u00020\"2\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010$2\b\b\u0002\u00103\u001a\u00020/2\b\b\u0002\u0010%\u001a\u00020&H\u0007¢\u0006\u0002\u00104\u001aK\u00105\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 2\u0006\u00106\u001a\u00020\b2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\b0,2\u0006\u0010%\u001a\u00020&2\u0006\u0010-\u001a\u00020\b2\u0006\u00103\u001a\u00020/2\u0006\u0010\u001e\u001a\u00020\u0001H\u0003¢\u0006\u0002\u00107\u001aE\u00108\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u00012\u0006\u00109\u001a\u00020\u00032\u0006\u00103\u001a\u00020/2\u0006\u0010%\u001a\u00020&2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010:\u001a\u00020\u0003H\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b;\u0010<\u001aS\u0010=\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u00012\u0006\u0010%\u001a\u00020&2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\b2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\b0,2\u0006\u0010>\u001a\u00020\b2\u0006\u0010?\u001a\u00020\bH\u0003¢\u0006\u0002\u0010@\u001a1\u0010A\u001a\u00020\u00122\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\b2\u0006\u0010E\u001a\u00020\b2\u0006\u0010F\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010G\u001a \u0010H\u001a\u00020\b2\u0006\u0010I\u001a\u00020\b2\u0006\u0010J\u001a\u00020\b2\u0006\u0010K\u001a\u00020\bH\u0002\u001a0\u0010L\u001a\u00020\b2\u0006\u0010M\u001a\u00020\b2\u0006\u0010N\u001a\u00020\b2\u0006\u0010O\u001a\u00020\b2\u0006\u0010P\u001a\u00020\b2\u0006\u0010Q\u001a\u00020\bH\u0002\u001a<\u0010L\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\u0006\u0010M\u001a\u00020\b2\u0006\u0010N\u001a\u00020\b2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\u0006\u0010P\u001a\u00020\b2\u0006\u0010Q\u001a\u00020\bH\u0002\u001a.\u0010S\u001a\u00020\b2\u0006\u0010D\u001a\u00020\b2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\b0,2\u0006\u0010T\u001a\u00020\b2\u0006\u0010U\u001a\u00020\bH\u0002\u001a\u0016\u0010V\u001a\b\u0012\u0004\u0012\u00020\b0,2\u0006\u0010!\u001a\u00020\"H\u0002\u001a;\u0010W\u001a\u0010\u0012\u0004\u0012\u00020Y\u0012\u0004\u0012\u00020\b\u0018\u00010X*\u00020Z2\u0006\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020^H@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b_\u0010`\u001a\u0001\u0010a\u001a\u00020\u0001*\u00020\u00012\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/2\f\u0010b\u001a\b\u0012\u0004\u0012\u00020\b0c2\f\u0010d\u001a\b\u0012\u0004\u0012\u00020\b0c2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010e\u001a\u00020 2\u0006\u0010U\u001a\u00020\b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\u0018\u0010f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00120\u00140c2\u0018\u0010g\u001a\u0014\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00120hH\u0002\u001a\\\u0010i\u001a\u00020\u0001*\u00020\u00012\u0006\u0010B\u001a\u00020C2\u0006\u00103\u001a\u00020/2\u0006\u0010U\u001a\u00020\b2\u0006\u0010e\u001a\u00020 2\f\u0010j\u001a\b\u0012\u0004\u0012\u00020\b0c2\u0018\u0010f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00120\u00140c2\u0006\u0010\u001f\u001a\u00020 H\u0002\u001aX\u0010k\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0019\u001a\u00020\b2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\b0,2\u0006\u0010\u001f\u001a\u00020 2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00120\u00142\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\b\b\u0002\u0010!\u001a\u00020\"H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\t\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\n\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0019\u0010\u000b\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\f\u0010\r\"\u0013\u0010\u000e\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0019\u0010\u000f\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0010\u0010\r\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006l"}, d2 = {"DefaultSliderConstraints", "Landroidx/compose/ui/Modifier;", "SliderHeight", "Landroidx/compose/ui/unit/Dp;", "F", "SliderMinWidth", "SliderToTickAnimation", "Landroidx/compose/animation/core/TweenSpec;", "", "ThumbDefaultElevation", "ThumbPressedElevation", "ThumbRadius", "getThumbRadius", "()F", "ThumbRippleRadius", "TrackHeight", "getTrackHeight", "CorrectValueSideEffect", "", "scaleToOffset", "Lkotlin/Function1;", "valueRange", "Lkotlin/ranges/ClosedFloatingPointRange;", "valueState", "Landroidx/compose/runtime/MutableState;", "value", "(Lkotlin/jvm/functions/Function1;Lkotlin/ranges/ClosedFloatingPointRange;Landroidx/compose/runtime/MutableState;FLandroidx/compose/runtime/Composer;I)V", "RangeSlider", "values", "onValueChange", "modifier", "enabled", "", "steps", "", "onValueChangeFinished", "Lkotlin/Function0;", "colors", "Landroidx/compose/material/SliderColors;", "(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/material/SliderColors;Landroidx/compose/runtime/Composer;II)V", "RangeSliderImpl", "positionFractionStart", "positionFractionEnd", "tickFractions", "", "width", "startInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "endInteractionSource", "(ZFFLjava/util/List;Landroidx/compose/material/SliderColors;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "Slider", "interactionSource", "(FLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/SliderColors;Landroidx/compose/runtime/Composer;II)V", "SliderImpl", "positionFraction", "(ZFLjava/util/List;Landroidx/compose/material/SliderColors;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "SliderThumb", "offset", "thumbSize", "SliderThumb-gNmqVrs", "(Landroidx/compose/ui/Modifier;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/SliderColors;ZFLandroidx/compose/runtime/Composer;I)V", "Track", "thumbPx", "trackStrokeWidth", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material/SliderColors;ZFFLjava/util/List;FFLandroidx/compose/runtime/Composer;I)V", "animateToTarget", "draggableState", "Landroidx/compose/foundation/gestures/DraggableState;", "current", "target", "velocity", "(Landroidx/compose/foundation/gestures/DraggableState;FFFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calcFraction", "a", "b", "pos", "scale", "a1", "b1", "x1", "a2", "b2", "x", "snapValueToTick", "minPx", "maxPx", "stepsToTickFractions", "awaitSlop", "Lkotlin/Pair;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "id", "Landroidx/compose/ui/input/pointer/PointerId;", "type", "Landroidx/compose/ui/input/pointer/PointerType;", "awaitSlop-8vUncbI", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rangeSliderPressDragModifier", "rawOffsetStart", "Landroidx/compose/runtime/State;", "rawOffsetEnd", "isRtl", "gestureEndAction", "onDrag", "Lkotlin/Function2;", "sliderPressModifier", "rawOffset", "sliderSemantics", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Slider.kt */
public final class SliderKt {
    private static final Modifier DefaultSliderConstraints;
    private static final float SliderHeight;
    private static final float SliderMinWidth;
    /* access modifiers changed from: private */
    public static final TweenSpec<Float> SliderToTickAnimation = new TweenSpec(100, 0, (Easing) null, 6, (DefaultConstructorMarker) null);
    private static final float ThumbDefaultElevation = Dp.m3859constructorimpl((float) 1);
    private static final float ThumbPressedElevation = Dp.m3859constructorimpl((float) 6);
    private static final float ThumbRadius = Dp.m3859constructorimpl((float) 10);
    private static final float ThumbRippleRadius = Dp.m3859constructorimpl((float) 24);
    private static final float TrackHeight = Dp.m3859constructorimpl((float) 4);

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v0, resolved type: java.util.List} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x02c3  */
    /* JADX WARNING: Removed duplicated region for block: B:155:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x011c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Slider(float r39, kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> r40, androidx.compose.ui.Modifier r41, boolean r42, kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r43, int r44, kotlin.jvm.functions.Function0<kotlin.Unit> r45, androidx.compose.foundation.interaction.MutableInteractionSource r46, androidx.compose.material.SliderColors r47, androidx.compose.runtime.Composer r48, int r49, int r50) {
        /*
            r2 = r40
            r10 = r49
            r11 = r50
            java.lang.String r0 = "onValueChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            r0 = 1510867760(0x5a0e0330, float:9.9932378E15)
            r1 = r48
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(Slider)P(7,4,3,1,8,6,5,2)147@7142L39,148@7225L8,151@7318L35,152@7378L59,155@7442L2805:Slider.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            r1 = r11 & 1
            if (r1 == 0) goto L_0x0023
            r1 = r10 | 6
            r4 = r1
            r1 = r39
            goto L_0x0037
        L_0x0023:
            r1 = r10 & 14
            if (r1 != 0) goto L_0x0034
            r1 = r39
            boolean r4 = r0.changed((float) r1)
            if (r4 == 0) goto L_0x0031
            r4 = 4
            goto L_0x0032
        L_0x0031:
            r4 = 2
        L_0x0032:
            r4 = r4 | r10
            goto L_0x0037
        L_0x0034:
            r1 = r39
            r4 = r10
        L_0x0037:
            r5 = r11 & 2
            if (r5 == 0) goto L_0x003e
            r4 = r4 | 48
            goto L_0x004e
        L_0x003e:
            r5 = r10 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x004e
            boolean r5 = r0.changed((java.lang.Object) r2)
            if (r5 == 0) goto L_0x004b
            r5 = 32
            goto L_0x004d
        L_0x004b:
            r5 = 16
        L_0x004d:
            r4 = r4 | r5
        L_0x004e:
            r5 = r11 & 4
            if (r5 == 0) goto L_0x0055
            r4 = r4 | 384(0x180, float:5.38E-43)
            goto L_0x0068
        L_0x0055:
            r6 = r10 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x0068
            r6 = r41
            boolean r7 = r0.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0064
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0066
        L_0x0064:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0066:
            r4 = r4 | r7
            goto L_0x006a
        L_0x0068:
            r6 = r41
        L_0x006a:
            r7 = r11 & 8
            if (r7 == 0) goto L_0x0071
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x0084
        L_0x0071:
            r8 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x0084
            r8 = r42
            boolean r9 = r0.changed((boolean) r8)
            if (r9 == 0) goto L_0x0080
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x0082
        L_0x0080:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x0082:
            r4 = r4 | r9
            goto L_0x0086
        L_0x0084:
            r8 = r42
        L_0x0086:
            r9 = 57344(0xe000, float:8.0356E-41)
            r9 = r9 & r10
            if (r9 != 0) goto L_0x00a1
            r9 = r11 & 16
            if (r9 != 0) goto L_0x009b
            r9 = r43
            boolean r12 = r0.changed((java.lang.Object) r9)
            if (r12 == 0) goto L_0x009d
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009f
        L_0x009b:
            r9 = r43
        L_0x009d:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x009f:
            r4 = r4 | r12
            goto L_0x00a3
        L_0x00a1:
            r9 = r43
        L_0x00a3:
            r12 = r11 & 32
            if (r12 == 0) goto L_0x00ab
            r13 = 196608(0x30000, float:2.75506E-40)
            r4 = r4 | r13
            goto L_0x00bf
        L_0x00ab:
            r13 = 458752(0x70000, float:6.42848E-40)
            r13 = r13 & r10
            if (r13 != 0) goto L_0x00bf
            r13 = r44
            boolean r14 = r0.changed((int) r13)
            if (r14 == 0) goto L_0x00bb
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bd
        L_0x00bb:
            r14 = 65536(0x10000, float:9.18355E-41)
        L_0x00bd:
            r4 = r4 | r14
            goto L_0x00c1
        L_0x00bf:
            r13 = r44
        L_0x00c1:
            r14 = r11 & 64
            if (r14 == 0) goto L_0x00c9
            r15 = 1572864(0x180000, float:2.204052E-39)
            r4 = r4 | r15
            goto L_0x00de
        L_0x00c9:
            r15 = 3670016(0x380000, float:5.142788E-39)
            r15 = r15 & r10
            if (r15 != 0) goto L_0x00de
            r15 = r45
            boolean r16 = r0.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00d9
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00db
        L_0x00d9:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00db:
            r4 = r4 | r16
            goto L_0x00e0
        L_0x00de:
            r15 = r45
        L_0x00e0:
            r3 = r11 & 128(0x80, float:1.794E-43)
            if (r3 == 0) goto L_0x00eb
            r16 = 12582912(0xc00000, float:1.7632415E-38)
            r4 = r4 | r16
            r1 = r46
            goto L_0x0100
        L_0x00eb:
            r16 = 29360128(0x1c00000, float:7.052966E-38)
            r16 = r10 & r16
            r1 = r46
            if (r16 != 0) goto L_0x0100
            boolean r16 = r0.changed((java.lang.Object) r1)
            if (r16 == 0) goto L_0x00fc
            r16 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00fe
        L_0x00fc:
            r16 = 4194304(0x400000, float:5.877472E-39)
        L_0x00fe:
            r4 = r4 | r16
        L_0x0100:
            r16 = 234881024(0xe000000, float:1.5777218E-30)
            r16 = r10 & r16
            if (r16 != 0) goto L_0x011c
            r1 = r11 & 256(0x100, float:3.59E-43)
            if (r1 != 0) goto L_0x0115
            r1 = r47
            boolean r16 = r0.changed((java.lang.Object) r1)
            if (r16 == 0) goto L_0x0117
            r16 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0119
        L_0x0115:
            r1 = r47
        L_0x0117:
            r16 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0119:
            r4 = r4 | r16
            goto L_0x011e
        L_0x011c:
            r1 = r47
        L_0x011e:
            r16 = 191739611(0xb6db6db, float:4.5782105E-32)
            r16 = r4 & r16
            r17 = 38347922(0x2492492, float:1.4777643E-37)
            r16 = r16 ^ r17
            if (r16 != 0) goto L_0x013e
            boolean r16 = r0.getSkipping()
            if (r16 != 0) goto L_0x0131
            goto L_0x013e
        L_0x0131:
            r0.skipToGroupEnd()
            r3 = r6
            r4 = r8
            r5 = r9
            r6 = r13
            r7 = r15
            r8 = r46
        L_0x013b:
            r9 = r1
            goto L_0x02bc
        L_0x013e:
            r0.startDefaults()
            r16 = r10 & 1
            r37 = 0
            r38 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r17 = -57345(0xffffffffffff1fff, float:NaN)
            r15 = 1
            if (r16 == 0) goto L_0x0178
            boolean r16 = r0.getDefaultsInvalid()
            if (r16 == 0) goto L_0x0155
            goto L_0x0178
        L_0x0155:
            r0.skipToGroupEnd()
            r3 = r11 & 16
            if (r3 == 0) goto L_0x015e
            r4 = r4 & r17
        L_0x015e:
            r3 = r11 & 256(0x100, float:3.59E-43)
            if (r3 == 0) goto L_0x016e
            r3 = r4 & r38
            r14 = r3
            r5 = r6
            r6 = r9
            r7 = r13
            r9 = r45
            r3 = r46
            goto L_0x01f5
        L_0x016e:
            r3 = r46
            r14 = r4
            r5 = r6
            r6 = r9
            r7 = r13
            r9 = r45
            goto L_0x01f5
        L_0x0178:
            if (r5 == 0) goto L_0x017f
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            goto L_0x0180
        L_0x017f:
            r5 = r6
        L_0x0180:
            if (r7 == 0) goto L_0x0183
            r8 = 1
        L_0x0183:
            r6 = r11 & 16
            if (r6 == 0) goto L_0x0191
            r6 = 0
            r7 = 1065353216(0x3f800000, float:1.0)
            kotlin.ranges.ClosedFloatingPointRange r6 = kotlin.ranges.RangesKt.rangeTo((float) r6, (float) r7)
            r4 = r4 & r17
            goto L_0x0192
        L_0x0191:
            r6 = r9
        L_0x0192:
            if (r12 == 0) goto L_0x0196
            r7 = 0
            goto L_0x0197
        L_0x0196:
            r7 = r13
        L_0x0197:
            if (r14 == 0) goto L_0x019b
            r9 = 0
            goto L_0x019d
        L_0x019b:
            r9 = r45
        L_0x019d:
            if (r3 == 0) goto L_0x01c3
            r3 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r0.startReplaceableGroup(r3)
            java.lang.String r3 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r3)
            java.lang.Object r3 = r0.rememberedValue()
            androidx.compose.runtime.Composer$Companion r12 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r12 = r12.getEmpty()
            if (r3 != r12) goto L_0x01bd
            androidx.compose.foundation.interaction.MutableInteractionSource r3 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r0.updateRememberedValue(r3)
        L_0x01bd:
            r0.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r3 = (androidx.compose.foundation.interaction.MutableInteractionSource) r3
            goto L_0x01c5
        L_0x01c3:
            r3 = r46
        L_0x01c5:
            r12 = r11 & 256(0x100, float:3.59E-43)
            if (r12 == 0) goto L_0x01f4
            androidx.compose.material.SliderDefaults r12 = androidx.compose.material.SliderDefaults.INSTANCE
            r13 = 0
            r16 = 0
            r1 = 1
            r15 = r16
            r17 = 0
            r19 = 0
            r21 = 0
            r23 = 0
            r25 = 0
            r27 = 0
            r29 = 0
            r31 = 0
            r34 = 0
            r35 = 6
            r36 = 1023(0x3ff, float:1.434E-42)
            r33 = r0
            androidx.compose.material.SliderColors r12 = r12.m1100colorsq0g_0yA(r13, r15, r17, r19, r21, r23, r25, r27, r29, r31, r33, r34, r35, r36)
            r4 = r4 & r38
            r14 = r4
            r1 = r12
            r15 = 1
            goto L_0x01f5
        L_0x01f4:
            r14 = r4
        L_0x01f5:
            r0.endDefaults()
            if (r7 < 0) goto L_0x01fc
            r37 = 1
        L_0x01fc:
            if (r37 == 0) goto L_0x02d7
            int r4 = r14 >> 3
            r4 = r4 & 14
            androidx.compose.runtime.State r20 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r2, r0, r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r7)
            r12 = -3686930(0xffffffffffc7bdee, float:NaN)
            r0.startReplaceableGroup(r12)
            java.lang.String r12 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r12)
            boolean r4 = r0.changed((java.lang.Object) r4)
            java.lang.Object r12 = r0.rememberedValue()
            if (r4 != 0) goto L_0x0227
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r12 != r4) goto L_0x022e
        L_0x0227:
            java.util.List r12 = stepsToTickFractions(r7)
            r0.updateRememberedValue(r12)
        L_0x022e:
            r0.endReplaceableGroup()
            r18 = r12
            java.util.List r18 = (java.util.List) r18
            androidx.compose.ui.Modifier r4 = androidx.compose.material.TouchTargetKt.minimumTouchTargetSize(r5)
            float r12 = ThumbRadius
            r13 = 2
            float r13 = (float) r13
            float r16 = r12 * r13
            float r16 = androidx.compose.ui.unit.Dp.m3859constructorimpl(r16)
            float r12 = r12 * r13
            float r12 = androidx.compose.ui.unit.Dp.m3859constructorimpl(r12)
            r13 = 0
            r17 = 0
            r19 = 12
            r21 = 0
            r41 = r4
            r42 = r16
            r43 = r12
            r44 = r13
            r45 = r17
            r46 = r19
            r47 = r21
            androidx.compose.ui.Modifier r4 = androidx.compose.foundation.layout.SizeKt.m488requiredSizeInqDBjuR0$default(r41, r42, r43, r44, r45, r46, r47)
            r41 = r4
            r42 = r39
            r43 = r18
            r44 = r8
            r45 = r40
            r46 = r6
            r47 = r7
            androidx.compose.ui.Modifier r4 = sliderSemantics(r41, r42, r43, r44, r45, r46, r47)
            androidx.compose.ui.Modifier r4 = androidx.compose.foundation.FocusableKt.focusable(r4, r8, r3)
            r22 = 0
            r23 = 0
            r13 = -819889977(0xffffffffcf2178c7, float:-2.70904704E9)
            androidx.compose.material.SliderKt$Slider$3 r12 = new androidx.compose.material.SliderKt$Slider$3
            r41 = r12
            r2 = -819889977(0xffffffffcf2178c7, float:-2.70904704E9)
            r13 = r6
            r2 = 1
            r15 = r39
            r16 = r3
            r17 = r8
            r19 = r1
            r21 = r9
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21)
            r13 = r41
            r12 = -819889977(0xffffffffcf2178c7, float:-2.70904704E9)
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r12, r2, r13)
            kotlin.jvm.functions.Function3 r2 = (kotlin.jvm.functions.Function3) r2
            r12 = 3072(0xc00, float:4.305E-42)
            r13 = 6
            r41 = r4
            r42 = r22
            r43 = r23
            r44 = r2
            r45 = r0
            r46 = r12
            r47 = r13
            androidx.compose.foundation.layout.BoxWithConstraintsKt.BoxWithConstraints(r41, r42, r43, r44, r45, r46, r47)
            r4 = r8
            r8 = r3
            r3 = r5
            r5 = r6
            r6 = r7
            r7 = r9
            goto L_0x013b
        L_0x02bc:
            androidx.compose.runtime.ScopeUpdateScope r12 = r0.endRestartGroup()
            if (r12 != 0) goto L_0x02c3
            goto L_0x02d6
        L_0x02c3:
            androidx.compose.material.SliderKt$Slider$4 r13 = new androidx.compose.material.SliderKt$Slider$4
            r0 = r13
            r1 = r39
            r2 = r40
            r10 = r49
            r11 = r50
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r12.updateScope(r13)
        L_0x02d6:
            return
        L_0x02d7:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "steps should be >= 0"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SliderKt.Slider(float, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, kotlin.ranges.ClosedFloatingPointRange, int, kotlin.jvm.functions.Function0, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.material.SliderColors, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: java.util.List} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x01e0  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x01ef  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x01f3  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x027a  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x028e  */
    /* JADX WARNING: Removed duplicated region for block: B:142:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x011a  */
    @androidx.compose.material.ExperimentalMaterialApi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void RangeSlider(kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r43, kotlin.jvm.functions.Function1<? super kotlin.ranges.ClosedFloatingPointRange<java.lang.Float>, kotlin.Unit> r44, androidx.compose.ui.Modifier r45, boolean r46, kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r47, int r48, kotlin.jvm.functions.Function0<kotlin.Unit> r49, androidx.compose.material.SliderColors r50, androidx.compose.runtime.Composer r51, int r52, int r53) {
        /*
            r12 = r43
            r13 = r44
            r14 = r52
            r15 = r53
            java.lang.String r0 = "values"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "onValueChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            r0 = 982566358(0x3a90c5d6, float:0.0011045288)
            r1 = r51
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(RangeSlider)P(7,3,2,1,6,5,4)269@12591L8,271@12663L39,272@12760L39,275@12881L35,276@12941L59,280@13006L3376:Slider.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r0)
            r0 = r15 & 1
            if (r0 == 0) goto L_0x0028
            r0 = r14 | 6
            goto L_0x0038
        L_0x0028:
            r0 = r14 & 14
            if (r0 != 0) goto L_0x0037
            boolean r0 = r11.changed((java.lang.Object) r12)
            if (r0 == 0) goto L_0x0034
            r0 = 4
            goto L_0x0035
        L_0x0034:
            r0 = 2
        L_0x0035:
            r0 = r0 | r14
            goto L_0x0038
        L_0x0037:
            r0 = r14
        L_0x0038:
            r1 = r15 & 2
            if (r1 == 0) goto L_0x003f
            r0 = r0 | 48
            goto L_0x004f
        L_0x003f:
            r1 = r14 & 112(0x70, float:1.57E-43)
            if (r1 != 0) goto L_0x004f
            boolean r1 = r11.changed((java.lang.Object) r13)
            if (r1 == 0) goto L_0x004c
            r1 = 32
            goto L_0x004e
        L_0x004c:
            r1 = 16
        L_0x004e:
            r0 = r0 | r1
        L_0x004f:
            r1 = r15 & 4
            if (r1 == 0) goto L_0x0056
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0069
        L_0x0056:
            r2 = r14 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x0069
            r2 = r45
            boolean r3 = r11.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x0065
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x0067
        L_0x0065:
            r3 = 128(0x80, float:1.794E-43)
        L_0x0067:
            r0 = r0 | r3
            goto L_0x006b
        L_0x0069:
            r2 = r45
        L_0x006b:
            r3 = r15 & 8
            if (r3 == 0) goto L_0x0072
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0085
        L_0x0072:
            r4 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x0085
            r4 = r46
            boolean r5 = r11.changed((boolean) r4)
            if (r5 == 0) goto L_0x0081
            r5 = 2048(0x800, float:2.87E-42)
            goto L_0x0083
        L_0x0081:
            r5 = 1024(0x400, float:1.435E-42)
        L_0x0083:
            r0 = r0 | r5
            goto L_0x0087
        L_0x0085:
            r4 = r46
        L_0x0087:
            r5 = 57344(0xe000, float:8.0356E-41)
            r5 = r5 & r14
            if (r5 != 0) goto L_0x00a2
            r5 = r15 & 16
            if (r5 != 0) goto L_0x009c
            r5 = r47
            boolean r6 = r11.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x009e
            r6 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a0
        L_0x009c:
            r5 = r47
        L_0x009e:
            r6 = 8192(0x2000, float:1.14794E-41)
        L_0x00a0:
            r0 = r0 | r6
            goto L_0x00a4
        L_0x00a2:
            r5 = r47
        L_0x00a4:
            r6 = r15 & 32
            if (r6 == 0) goto L_0x00ac
            r7 = 196608(0x30000, float:2.75506E-40)
            r0 = r0 | r7
            goto L_0x00c0
        L_0x00ac:
            r7 = 458752(0x70000, float:6.42848E-40)
            r7 = r7 & r14
            if (r7 != 0) goto L_0x00c0
            r7 = r48
            boolean r8 = r11.changed((int) r7)
            if (r8 == 0) goto L_0x00bc
            r8 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00be
        L_0x00bc:
            r8 = 65536(0x10000, float:9.18355E-41)
        L_0x00be:
            r0 = r0 | r8
            goto L_0x00c2
        L_0x00c0:
            r7 = r48
        L_0x00c2:
            r8 = r15 & 64
            if (r8 == 0) goto L_0x00ca
            r9 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r9
            goto L_0x00de
        L_0x00ca:
            r9 = 3670016(0x380000, float:5.142788E-39)
            r9 = r9 & r14
            if (r9 != 0) goto L_0x00de
            r9 = r49
            boolean r10 = r11.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x00da
            r10 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00dc
        L_0x00da:
            r10 = 524288(0x80000, float:7.34684E-40)
        L_0x00dc:
            r0 = r0 | r10
            goto L_0x00e0
        L_0x00de:
            r9 = r49
        L_0x00e0:
            r10 = 29360128(0x1c00000, float:7.052966E-38)
            r10 = r10 & r14
            if (r10 != 0) goto L_0x00fb
            r10 = r15 & 128(0x80, float:1.794E-43)
            if (r10 != 0) goto L_0x00f4
            r10 = r50
            boolean r16 = r11.changed((java.lang.Object) r10)
            if (r16 == 0) goto L_0x00f6
            r16 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f8
        L_0x00f4:
            r10 = r50
        L_0x00f6:
            r16 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f8:
            r0 = r0 | r16
            goto L_0x00fd
        L_0x00fb:
            r10 = r50
        L_0x00fd:
            r16 = 23967451(0x16db6db, float:4.3661218E-38)
            r16 = r0 & r16
            r17 = 4793490(0x492492, float:6.71711E-39)
            r16 = r16 ^ r17
            if (r16 != 0) goto L_0x011a
            boolean r16 = r11.getSkipping()
            if (r16 != 0) goto L_0x0110
            goto L_0x011a
        L_0x0110:
            r11.skipToGroupEnd()
            r3 = r2
            r6 = r7
            r7 = r9
            r8 = r10
            r13 = r11
            goto L_0x0273
        L_0x011a:
            r11.startDefaults()
            r16 = r14 & 1
            r41 = 0
            r42 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r17 = -57345(0xffffffffffff1fff, float:NaN)
            if (r16 == 0) goto L_0x014d
            boolean r16 = r11.getDefaultsInvalid()
            if (r16 == 0) goto L_0x0130
            goto L_0x014d
        L_0x0130:
            r11.skipToGroupEnd()
            r1 = r15 & 16
            if (r1 == 0) goto L_0x0139
            r0 = r0 & r17
        L_0x0139:
            r1 = r15 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x013f
            r0 = r0 & r42
        L_0x013f:
            r3 = r0
            r16 = r2
        L_0x0142:
            r17 = r4
            r18 = r5
            r19 = r7
            r20 = r9
            r21 = r10
            goto L_0x01a7
        L_0x014d:
            if (r1 == 0) goto L_0x0154
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x0155
        L_0x0154:
            r1 = r2
        L_0x0155:
            if (r3 == 0) goto L_0x0158
            r4 = 1
        L_0x0158:
            r2 = r15 & 16
            if (r2 == 0) goto L_0x0166
            r2 = 0
            r3 = 1065353216(0x3f800000, float:1.0)
            kotlin.ranges.ClosedFloatingPointRange r2 = kotlin.ranges.RangesKt.rangeTo((float) r2, (float) r3)
            r0 = r0 & r17
            r5 = r2
        L_0x0166:
            if (r6 == 0) goto L_0x0169
            r7 = 0
        L_0x0169:
            if (r8 == 0) goto L_0x016d
            r2 = 0
            r9 = r2
        L_0x016d:
            r2 = r15 & 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x01a3
            androidx.compose.material.SliderDefaults r16 = androidx.compose.material.SliderDefaults.INSTANCE
            r17 = 0
            r19 = 0
            r21 = 0
            r23 = 0
            r25 = 0
            r27 = 0
            r29 = 0
            r31 = 0
            r33 = 0
            r35 = 0
            r38 = 0
            r39 = 6
            r40 = 1023(0x3ff, float:1.434E-42)
            r37 = r11
            androidx.compose.material.SliderColors r2 = r16.m1100colorsq0g_0yA(r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, r38, r39, r40)
            r0 = r0 & r42
            r3 = r0
            r16 = r1
            r21 = r2
            r17 = r4
            r18 = r5
            r19 = r7
            r20 = r9
            goto L_0x01a7
        L_0x01a3:
            r3 = r0
            r16 = r1
            goto L_0x0142
        L_0x01a7:
            r11.endDefaults()
            r0 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r11.startReplaceableGroup(r0)
            java.lang.String r1 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            java.lang.Object r2 = r11.rememberedValue()
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r2 != r4) goto L_0x01c8
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r11.updateRememberedValue(r2)
        L_0x01c8:
            r11.endReplaceableGroup()
            r5 = r2
            androidx.compose.foundation.interaction.MutableInteractionSource r5 = (androidx.compose.foundation.interaction.MutableInteractionSource) r5
            r11.startReplaceableGroup(r0)
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            java.lang.Object r0 = r11.rememberedValue()
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r0 != r1) goto L_0x01e7
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r11.updateRememberedValue(r0)
        L_0x01e7:
            r11.endReplaceableGroup()
            r6 = r0
            androidx.compose.foundation.interaction.MutableInteractionSource r6 = (androidx.compose.foundation.interaction.MutableInteractionSource) r6
            if (r19 < 0) goto L_0x01f1
            r41 = 1
        L_0x01f1:
            if (r41 == 0) goto L_0x028e
            int r0 = r3 >> 3
            r0 = r0 & 14
            androidx.compose.runtime.State r8 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r13, r11, r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r19)
            r1 = -3686930(0xffffffffffc7bdee, float:NaN)
            r11.startReplaceableGroup(r1)
            java.lang.String r1 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            boolean r0 = r11.changed((java.lang.Object) r0)
            java.lang.Object r1 = r11.rememberedValue()
            if (r0 != 0) goto L_0x021c
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r1 != r0) goto L_0x0223
        L_0x021c:
            java.util.List r1 = stepsToTickFractions(r19)
            r11.updateRememberedValue(r1)
        L_0x0223:
            r11.endReplaceableGroup()
            r9 = r1
            java.util.List r9 = (java.util.List) r9
            r22 = 0
            r23 = 0
            r24 = 0
            r10 = -819899281(0xffffffffcf21546f, float:-2.70666522E9)
            androidx.compose.material.SliderKt$RangeSlider$2 r7 = new androidx.compose.material.SliderKt$RangeSlider$2
            r0 = r7
            r1 = r18
            r2 = r43
            r4 = r16
            r12 = r7
            r7 = r17
            r13 = -819899281(0xffffffffcf21546f, float:-2.70666522E9)
            r10 = r21
            r13 = r11
            r11 = r20
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r0 = -819899281(0xffffffffcf21546f, float:-2.70666522E9)
            r1 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r13, r0, r1, r12)
            kotlin.jvm.functions.Function3 r0 = (kotlin.jvm.functions.Function3) r0
            r1 = 3072(0xc00, float:4.305E-42)
            r2 = 7
            r45 = r22
            r46 = r23
            r47 = r24
            r48 = r0
            r49 = r13
            r50 = r1
            r51 = r2
            androidx.compose.foundation.layout.BoxWithConstraintsKt.BoxWithConstraints(r45, r46, r47, r48, r49, r50, r51)
            r3 = r16
            r4 = r17
            r5 = r18
            r6 = r19
            r7 = r20
            r8 = r21
        L_0x0273:
            androidx.compose.runtime.ScopeUpdateScope r11 = r13.endRestartGroup()
            if (r11 != 0) goto L_0x027a
            goto L_0x028d
        L_0x027a:
            androidx.compose.material.SliderKt$RangeSlider$3 r12 = new androidx.compose.material.SliderKt$RangeSlider$3
            r0 = r12
            r1 = r43
            r2 = r44
            r9 = r52
            r10 = r53
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r11.updateScope(r12)
        L_0x028d:
            return
        L_0x028e:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "steps should be >= 0"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SliderKt.RangeSlider(kotlin.ranges.ClosedFloatingPointRange, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, kotlin.ranges.ClosedFloatingPointRange, int, kotlin.jvm.functions.Function0, androidx.compose.material.SliderColors, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final void SliderImpl(boolean z, float f, List<Float> list, SliderColors sliderColors, float f2, MutableInteractionSource mutableInteractionSource, Modifier modifier, Composer composer, int i) {
        int i2 = i;
        Composer startRestartGroup = composer.startRestartGroup(1568553907);
        ComposerKt.sourceInformation(startRestartGroup, "C(SliderImpl)P(1,4,5!1,6)508@22201L781:Slider.kt#jmzs0o");
        Modifier then = modifier.then(DefaultSliderConstraints);
        startRestartGroup.startReplaceableGroup(-1990474327);
        ComposerKt.sourceInformation(startRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(1376089394);
        ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)72@2847L7,73@2902L7,74@2961L7,75@2973L460:Layout.kt#80mrfh");
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
        Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        Density density = (Density) consume;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
        Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        LayoutDirection layoutDirection = (LayoutDirection) consume2;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
        Object consume3 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ViewConfiguration viewConfiguration = (ViewConfiguration) consume3;
        Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(then);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
            startRestartGroup.createNode(constructor);
        } else {
            startRestartGroup.useNode();
        }
        startRestartGroup.disableReusing();
        Composer r11 = Updater.m1234constructorimpl(startRestartGroup);
        Updater.m1241setimpl(r11, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m1241setimpl(r11, density, ComposeUiNode.Companion.getSetDensity());
        Updater.m1241setimpl(r11, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
        Updater.m1241setimpl(r11, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
        startRestartGroup.enableReusing();
        materializerOf.invoke(SkippableUpdater.m1225boximpl(SkippableUpdater.m1226constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        startRestartGroup.startReplaceableGroup(-1253629305);
        ComposerKt.sourceInformation(startRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
        startRestartGroup.startReplaceableGroup(618021226);
        ComposerKt.sourceInformation(startRestartGroup, "C*512@22361L7,522@22679L214,532@22902L74:Slider.kt#jmzs0o");
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
        Object consume4 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        Density density2 = (Density) consume4;
        float r16 = density2.m3828toPx0680j_4(getTrackHeight());
        float r15 = density2.m3828toPx0680j_4(getThumbRadius());
        float r2 = density2.m3824toDpu2uoSUM(f2);
        float r3 = Dp.m3859constructorimpl(getThumbRadius() * ((float) 2));
        float r22 = Dp.m3859constructorimpl(Dp.m3859constructorimpl(r2 - r3) * f);
        Modifier align = BoxScopeInstance.INSTANCE.align(Modifier.Companion, Alignment.Companion.getCenterStart());
        Track(SizeKt.fillMaxSize$default(align, 0.0f, 1, (Object) null), sliderColors, z, 0.0f, f, list, r15, r16, startRestartGroup, 265216 | ((i2 >> 6) & 112) | ((i2 << 6) & 896) | ((i2 << 9) & 57344));
        m1101SliderThumbgNmqVrs(align, r22, mutableInteractionSource, sliderColors, z, r3, startRestartGroup, 196608 | ((i2 >> 9) & 896) | (i2 & 7168) | ((i2 << 12) & 57344));
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SliderKt$SliderImpl$2(z, f, list, sliderColors, f2, mutableInteractionSource, modifier, i));
        }
    }

    /* access modifiers changed from: private */
    public static final void RangeSliderImpl(boolean z, float f, float f2, List<Float> list, SliderColors sliderColors, float f3, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, Modifier modifier, Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-1161720378);
        ComposerKt.sourceInformation(startRestartGroup, "C(RangeSliderImpl)P(1,5,4,7!1,8,6)549@23329L1178:Slider.kt#jmzs0o");
        Modifier then = modifier.then(DefaultSliderConstraints);
        startRestartGroup.startReplaceableGroup(-1990474327);
        ComposerKt.sourceInformation(startRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(1376089394);
        ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)72@2847L7,73@2902L7,74@2961L7,75@2973L460:Layout.kt#80mrfh");
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
        Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        Density density = (Density) consume;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
        Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        LayoutDirection layoutDirection = (LayoutDirection) consume2;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
        Object consume3 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ViewConfiguration viewConfiguration = (ViewConfiguration) consume3;
        Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(then);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
            startRestartGroup.createNode(constructor);
        } else {
            startRestartGroup.useNode();
        }
        startRestartGroup.disableReusing();
        Composer r9 = Updater.m1234constructorimpl(startRestartGroup);
        Updater.m1241setimpl(r9, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m1241setimpl(r9, density, ComposeUiNode.Companion.getSetDensity());
        Updater.m1241setimpl(r9, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
        Updater.m1241setimpl(r9, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
        startRestartGroup.enableReusing();
        materializerOf.invoke(SkippableUpdater.m1225boximpl(SkippableUpdater.m1226constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        startRestartGroup.startReplaceableGroup(-1253629305);
        ComposerKt.sourceInformation(startRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
        BoxScope boxScope = BoxScopeInstance.INSTANCE;
        startRestartGroup.startReplaceableGroup(-1690176159);
        ComposerKt.sourceInformation(startRestartGroup, "C*553@23489L7,562@23825L267,573@24102L197,581@24308L193:Slider.kt#jmzs0o");
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
        Object consume4 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        Density density2 = (Density) consume4;
        float r8 = density2.m3828toPx0680j_4(getTrackHeight());
        float r7 = density2.m3828toPx0680j_4(getThumbRadius());
        float r1 = density2.m3824toDpu2uoSUM(f3);
        float r14 = Dp.m3859constructorimpl(getThumbRadius() * ((float) 2));
        float f4 = r1 - r14;
        float r15 = Dp.m3859constructorimpl(Dp.m3859constructorimpl(f4) * f);
        float r16 = Dp.m3859constructorimpl(Dp.m3859constructorimpl(f4) * f2);
        int i2 = i << 6;
        Track(SizeKt.fillMaxSize$default(boxScope.align(Modifier.Companion, Alignment.Companion.getCenterStart()), 0.0f, 1, (Object) null), sliderColors, z, f, f2, list, r7, r8, startRestartGroup, 262144 | ((i >> 9) & 112) | (i2 & 896) | (i2 & 7168) | (i2 & 57344));
        int i3 = (i >> 3) & 7168;
        int i4 = (i << 12) & 57344;
        SliderColors sliderColors2 = sliderColors;
        boolean z2 = z;
        float f5 = r14;
        Composer composer2 = startRestartGroup;
        m1101SliderThumbgNmqVrs(boxScope.align(Modifier.Companion, Alignment.Companion.getCenterStart()), r15, mutableInteractionSource, sliderColors2, z2, f5, composer2, ((i >> 12) & 896) | 196608 | i3 | i4);
        m1101SliderThumbgNmqVrs(boxScope.align(Modifier.Companion, Alignment.Companion.getCenterStart()), r16, mutableInteractionSource2, sliderColors2, z2, f5, composer2, ((i >> 15) & 896) | 196608 | i3 | i4);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SliderKt$RangeSliderImpl$2(z, f, f2, list, sliderColors, f3, mutableInteractionSource, mutableInteractionSource2, modifier, i));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: SliderThumb-gNmqVrs  reason: not valid java name */
    public static final void m1101SliderThumbgNmqVrs(Modifier modifier, float f, MutableInteractionSource mutableInteractionSource, SliderColors sliderColors, boolean z, float f2, Composer composer, int i) {
        int i2;
        float f3;
        MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
        SliderColors sliderColors2 = sliderColors;
        boolean z2 = z;
        float f4 = f2;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(1690330084);
        ComposerKt.sourceInformation(startRestartGroup, "C(SliderThumb)P(3,4:c#ui.unit.Dp,2!,5:c#ui.unit.Dp)601@24711L1489:Slider.kt#jmzs0o");
        if ((i3 & 14) == 0) {
            i2 = (startRestartGroup.changed((Object) modifier) ? 4 : 2) | i3;
        } else {
            Modifier modifier2 = modifier;
            i2 = i3;
        }
        float f5 = f;
        if ((i3 & 112) == 0) {
            i2 |= startRestartGroup.changed(f5) ? 32 : 16;
        }
        if ((i3 & 896) == 0) {
            i2 |= startRestartGroup.changed((Object) mutableInteractionSource2) ? 256 : 128;
        }
        if ((i3 & 7168) == 0) {
            i2 |= startRestartGroup.changed((Object) sliderColors2) ? 2048 : 1024;
        }
        if ((57344 & i3) == 0) {
            i2 |= startRestartGroup.changed(z2) ? 16384 : 8192;
        }
        if ((458752 & i3) == 0) {
            i2 |= startRestartGroup.changed(f4) ? 131072 : 65536;
        }
        int i4 = i2;
        if (((i4 & 374491) ^ 74898) != 0 || !startRestartGroup.getSkipping()) {
            Modifier r8 = PaddingKt.m435paddingqDBjuR0$default(modifier, f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
            startRestartGroup.startReplaceableGroup(-1990474327);
            ComposerKt.sourceInformation(startRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(1376089394);
            ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)72@2847L7,73@2902L7,74@2961L7,75@2973L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Density density = (Density) consume;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection = (LayoutDirection) consume2;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ViewConfiguration viewConfiguration = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(r8);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer r11 = Updater.m1234constructorimpl(startRestartGroup);
            Updater.m1241setimpl(r11, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1241setimpl(r11, density, ComposeUiNode.Companion.getSetDensity());
            Updater.m1241setimpl(r11, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1241setimpl(r11, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m1225boximpl(SkippableUpdater.m1226constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-1253629305);
            ComposerKt.sourceInformation(startRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            startRestartGroup.startReplaceableGroup(-528165527);
            ComposerKt.sourceInformation(startRestartGroup, "C602@24778L46,603@24867L658,603@24833L692,626@25881L59,630@26145L19,621@25687L507:Slider.kt#jmzs0o");
            startRestartGroup.startReplaceableGroup(-3687241);
            ComposerKt.sourceInformation(startRestartGroup, "C(remember):Composables.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = SnapshotStateKt.mutableStateListOf();
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            SnapshotStateList snapshotStateList = (SnapshotStateList) rememberedValue;
            int i5 = i4 >> 6;
            int i6 = i5 & 14;
            startRestartGroup.startReplaceableGroup(-3686552);
            ComposerKt.sourceInformation(startRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
            boolean changed = startRestartGroup.changed((Object) mutableInteractionSource2) | startRestartGroup.changed((Object) snapshotStateList);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new SliderKt$SliderThumb$1$1$1(mutableInteractionSource2, snapshotStateList, (Continuation<? super SliderKt$SliderThumb$1$1$1>) null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            EffectsKt.LaunchedEffect((Object) mutableInteractionSource2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) rememberedValue2, startRestartGroup, i6);
            if (!snapshotStateList.isEmpty()) {
                f3 = ThumbPressedElevation;
            } else {
                f3 = ThumbDefaultElevation;
            }
            Modifier hoverable$default = HoverableKt.hoverable$default(IndicationKt.indication(SizeKt.m494sizeVpY3zN4(Modifier.Companion, f4, f4), mutableInteractionSource2, RippleKt.m1214rememberRipple9IZ8Weo(false, ThumbRippleRadius, 0, startRestartGroup, 54, 4)), mutableInteractionSource2, false, 2, (Object) null);
            if (!z2) {
                f3 = Dp.m3859constructorimpl((float) 0);
            }
            SpacerKt.Spacer(BackgroundKt.m161backgroundbw27NRU(ShadowKt.m1290shadowziNgDLE(hoverable$default, f3, RoundedCornerShapeKt.getCircleShape(), false), sliderColors2.thumbColor(z2, startRestartGroup, ((i4 >> 12) & 14) | (i5 & 112)).getValue().m1606unboximpl(), RoundedCornerShapeKt.getCircleShape()), startRestartGroup, 0);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SliderKt$SliderThumb$2(modifier, f, mutableInteractionSource, sliderColors, z, f2, i));
        }
    }

    /* access modifiers changed from: private */
    public static final void Track(Modifier modifier, SliderColors sliderColors, boolean z, float f, float f2, List<Float> list, float f3, float f4, Composer composer, int i) {
        SliderColors sliderColors2 = sliderColors;
        boolean z2 = z;
        Composer startRestartGroup = composer.startRestartGroup(1052526059);
        ComposerKt.sourceInformation(startRestartGroup, "C(Track)P(2!2,4!1,6)646@26493L35,647@26563L34,648@26633L34,649@26701L33,650@26739L1514:Slider.kt#jmzs0o");
        int i2 = ((i >> 6) & 14) | 48 | ((i << 3) & 896);
        Modifier modifier2 = modifier;
        CanvasKt.Canvas(modifier, new SliderKt$Track$1(f3, sliderColors2.trackColor(z2, false, startRestartGroup, i2), f4, f2, f, sliderColors2.trackColor(z2, true, startRestartGroup, i2), list, sliderColors2.tickColor(z2, false, startRestartGroup, i2), sliderColors2.tickColor(z2, true, startRestartGroup, i2)), startRestartGroup, i & 14);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SliderKt$Track$2(modifier, sliderColors, z, f, f2, list, f3, f4, i));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.Number} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final float snapValueToTick(float r5, java.util.List<java.lang.Float> r6, float r7, float r8) {
        /*
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r6 = r6.iterator()
            boolean r0 = r6.hasNext()
            if (r0 != 0) goto L_0x000e
            r6 = 0
            goto L_0x004d
        L_0x000e:
            java.lang.Object r0 = r6.next()
            boolean r1 = r6.hasNext()
            if (r1 != 0) goto L_0x001a
        L_0x0018:
            r6 = r0
            goto L_0x004d
        L_0x001a:
            r1 = r0
            java.lang.Number r1 = (java.lang.Number) r1
            float r1 = r1.floatValue()
            float r1 = androidx.compose.ui.util.MathHelpersKt.lerp((float) r7, (float) r8, (float) r1)
            float r1 = r1 - r5
            float r1 = java.lang.Math.abs(r1)
        L_0x002a:
            java.lang.Object r2 = r6.next()
            r3 = r2
            java.lang.Number r3 = (java.lang.Number) r3
            float r3 = r3.floatValue()
            float r3 = androidx.compose.ui.util.MathHelpersKt.lerp((float) r7, (float) r8, (float) r3)
            float r3 = r3 - r5
            float r3 = java.lang.Math.abs(r3)
            int r4 = java.lang.Float.compare(r1, r3)
            if (r4 <= 0) goto L_0x0046
            r0 = r2
            r1 = r3
        L_0x0046:
            boolean r2 = r6.hasNext()
            if (r2 != 0) goto L_0x002a
            goto L_0x0018
        L_0x004d:
            java.lang.Float r6 = (java.lang.Float) r6
            if (r6 != 0) goto L_0x0052
            goto L_0x005c
        L_0x0052:
            java.lang.Number r6 = (java.lang.Number) r6
            float r5 = r6.floatValue()
            float r5 = androidx.compose.ui.util.MathHelpersKt.lerp((float) r7, (float) r8, (float) r5)
        L_0x005c:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SliderKt.snapValueToTick(float, java.util.List, float, float):float");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0067 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* renamed from: awaitSlop-8vUncbI  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m1104awaitSlop8vUncbI(androidx.compose.ui.input.pointer.AwaitPointerEventScope r8, long r9, int r11, kotlin.coroutines.Continuation<? super kotlin.Pair<androidx.compose.ui.input.pointer.PointerInputChange, java.lang.Float>> r12) {
        /*
            boolean r0 = r12 instanceof androidx.compose.material.SliderKt$awaitSlop$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            androidx.compose.material.SliderKt$awaitSlop$1 r0 = (androidx.compose.material.SliderKt$awaitSlop$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            androidx.compose.material.SliderKt$awaitSlop$1 r0 = new androidx.compose.material.SliderKt$awaitSlop$1
            r0.<init>(r12)
        L_0x0019:
            r6 = r0
            java.lang.Object r12 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L_0x0037
            if (r1 != r2) goto L_0x002f
            java.lang.Object r8 = r6.L$0
            kotlin.jvm.internal.Ref$FloatRef r8 = (kotlin.jvm.internal.Ref.FloatRef) r8
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0058
        L_0x002f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r12)
            kotlin.jvm.internal.Ref$FloatRef r12 = new kotlin.jvm.internal.Ref$FloatRef
            r12.<init>()
            androidx.compose.material.SliderKt$awaitSlop$postPointerSlop$1 r1 = new androidx.compose.material.SliderKt$awaitSlop$postPointerSlop$1
            r1.<init>(r12)
            r5 = r1
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r6.L$0 = r12
            r6.label = r2
            r1 = r8
            r2 = r9
            r4 = r11
            java.lang.Object r8 = androidx.compose.material.DragGestureDetectorCopyKt.m955awaitHorizontalPointerSlopOrCancellationgDDlDlE(r1, r2, r4, r5, r6)
            if (r8 != r0) goto L_0x0055
            return r0
        L_0x0055:
            r7 = r12
            r12 = r8
            r8 = r7
        L_0x0058:
            androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12
            if (r12 == 0) goto L_0x0067
            float r8 = r8.element
            java.lang.Float r8 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r8)
            kotlin.Pair r8 = kotlin.TuplesKt.to(r12, r8)
            goto L_0x0068
        L_0x0067:
            r8 = 0
        L_0x0068:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SliderKt.m1104awaitSlop8vUncbI(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final List<Float> stepsToTickFractions(int i) {
        if (i == 0) {
            return CollectionsKt.emptyList();
        }
        int i2 = i + 2;
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList.add(Float.valueOf(((float) i3) / ((float) (i + 1))));
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public static final float scale(float f, float f2, float f3, float f4, float f5) {
        return MathHelpersKt.lerp(f4, f5, calcFraction(f, f2, f3));
    }

    /* access modifiers changed from: private */
    public static final ClosedFloatingPointRange<Float> scale(float f, float f2, ClosedFloatingPointRange<Float> closedFloatingPointRange, float f3, float f4) {
        return RangesKt.rangeTo(scale(f, f2, closedFloatingPointRange.getStart().floatValue(), f3, f4), scale(f, f2, closedFloatingPointRange.getEndInclusive().floatValue(), f3, f4));
    }

    /* access modifiers changed from: private */
    public static final float calcFraction(float f, float f2, float f3) {
        float f4 = f2 - f;
        return RangesKt.coerceIn((f4 > 0.0f ? 1 : (f4 == 0.0f ? 0 : -1)) == 0 ? 0.0f : (f3 - f) / f4, 0.0f, 1.0f);
    }

    /* access modifiers changed from: private */
    public static final void CorrectValueSideEffect(Function1<? super Float, Float> function1, ClosedFloatingPointRange<Float> closedFloatingPointRange, MutableState<Float> mutableState, float f, Composer composer, int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(1481631656);
        ComposerKt.sourceInformation(startRestartGroup, "C(CorrectValueSideEffect)P(!1,2,3)744@30072L220,744@30061L231:Slider.kt#jmzs0o");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed((Object) function1) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changed((Object) closedFloatingPointRange) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= startRestartGroup.changed((Object) mutableState) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= startRestartGroup.changed(f) ? 2048 : 1024;
        }
        if (((i2 & 5851) ^ 1170) != 0 || !startRestartGroup.getSkipping()) {
            Object[] objArr = {closedFloatingPointRange, function1, Float.valueOf(f), mutableState};
            startRestartGroup.startReplaceableGroup(-3685570);
            ComposerKt.sourceInformation(startRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
            int i3 = 0;
            boolean z = false;
            while (i3 < 4) {
                Object obj = objArr[i3];
                i3++;
                z |= startRestartGroup.changed(obj);
            }
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new SliderKt$CorrectValueSideEffect$1$1(closedFloatingPointRange, function1, f, mutableState);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            EffectsKt.SideEffect((Function0) rememberedValue, startRestartGroup, 0);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SliderKt$CorrectValueSideEffect$2(function1, closedFloatingPointRange, mutableState, f, i));
        }
    }

    static /* synthetic */ Modifier sliderSemantics$default(Modifier modifier, float f, List list, boolean z, Function1 function1, ClosedFloatingPointRange<Float> closedFloatingPointRange, int i, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            closedFloatingPointRange = RangesKt.rangeTo(0.0f, 1.0f);
        }
        return sliderSemantics(modifier, f, list, z, function1, closedFloatingPointRange, (i2 & 32) != 0 ? 0 : i);
    }

    private static final Modifier sliderSemantics(Modifier modifier, float f, List<Float> list, boolean z, Function1<? super Float, Unit> function1, ClosedFloatingPointRange<Float> closedFloatingPointRange, int i) {
        return ProgressSemanticsKt.progressSemantics(SemanticsModifierKt.semantics$default(modifier, false, new SliderKt$sliderSemantics$1(z, closedFloatingPointRange, i, list, RangesKt.coerceIn(f, closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue()), function1), 1, (Object) null), f, closedFloatingPointRange, i);
    }

    /* access modifiers changed from: private */
    public static final Modifier sliderPressModifier(Modifier modifier, DraggableState draggableState, MutableInteractionSource mutableInteractionSource, float f, boolean z, State<Float> state, State<? extends Function1<? super Float, Unit>> state2, boolean z2) {
        if (!z2) {
            return modifier;
        }
        Modifier modifier2 = modifier;
        return SuspendingPointerInputFilterKt.pointerInput(modifier, new Object[]{draggableState, mutableInteractionSource, Float.valueOf(f), Boolean.valueOf(z)}, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new SliderKt$sliderPressModifier$1(draggableState, mutableInteractionSource, state2, z, f, state, (Continuation<? super SliderKt$sliderPressModifier$1>) null));
    }

    /* access modifiers changed from: private */
    public static final Object animateToTarget(DraggableState draggableState, float f, float f2, float f3, Continuation<? super Unit> continuation) {
        Object drag$default = DraggableState.DefaultImpls.drag$default(draggableState, (MutatePriority) null, new SliderKt$animateToTarget$2(f, f2, f3, (Continuation<? super SliderKt$animateToTarget$2>) null), continuation, 1, (Object) null);
        return drag$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? drag$default : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Modifier rangeSliderPressDragModifier(Modifier modifier, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, State<Float> state, State<Float> state2, boolean z, boolean z2, float f, ClosedFloatingPointRange<Float> closedFloatingPointRange, State<? extends Function1<? super Boolean, Unit>> state3, Function2<? super Boolean, ? super Float, Unit> function2) {
        if (!z) {
            return modifier;
        }
        Modifier modifier2 = modifier;
        return SuspendingPointerInputFilterKt.pointerInput(modifier, new Object[]{mutableInteractionSource, mutableInteractionSource2, Float.valueOf(f), Boolean.valueOf(z2), closedFloatingPointRange}, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new SliderKt$rangeSliderPressDragModifier$1(mutableInteractionSource, mutableInteractionSource2, state, state2, function2, z2, f, state3, (Continuation<? super SliderKt$rangeSliderPressDragModifier$1>) null));
    }

    public static final float getThumbRadius() {
        return ThumbRadius;
    }

    public static final float getTrackHeight() {
        return TrackHeight;
    }

    static {
        float r1 = Dp.m3859constructorimpl((float) 48);
        SliderHeight = r1;
        float r2 = Dp.m3859constructorimpl((float) 144);
        SliderMinWidth = r2;
        DefaultSliderConstraints = SizeKt.m480heightInVpY3zN4$default(SizeKt.m499widthInVpY3zN4$default(Modifier.Companion, r2, 0.0f, 2, (Object) null), 0.0f, r1, 1, (Object) null);
    }
}
