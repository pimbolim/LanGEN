package androidx.compose.material;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aG\u0010\u0005\u001a\u00020\u0006*\f\u0012\u0004\u0012\u00020\u0002\u0012\u0002\b\u00030\u00072\u0006\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\r\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\"\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\"\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u000e"}, d2 = {"DefaultIncomingSpec", "Landroidx/compose/animation/core/TweenSpec;", "Landroidx/compose/ui/unit/Dp;", "DefaultOutgoingSpec", "HoveredOutgoingSpec", "animateElevation", "", "Landroidx/compose/animation/core/Animatable;", "target", "from", "Landroidx/compose/foundation/interaction/Interaction;", "to", "animateElevation-rAjV9yQ", "(Landroidx/compose/animation/core/Animatable;FLandroidx/compose/foundation/interaction/Interaction;Landroidx/compose/foundation/interaction/Interaction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Elevation.kt */
public final class ElevationKt {
    /* access modifiers changed from: private */
    public static final TweenSpec<Dp> DefaultIncomingSpec = new TweenSpec(120, 0, EasingKt.getFastOutSlowInEasing(), 2, (DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final TweenSpec<Dp> DefaultOutgoingSpec = new TweenSpec(150, 0, new CubicBezierEasing(0.4f, 0.0f, 0.6f, 1.0f), 2, (DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final TweenSpec<Dp> HoveredOutgoingSpec = new TweenSpec(120, 0, new CubicBezierEasing(0.4f, 0.0f, 0.6f, 1.0f), 2, (DefaultConstructorMarker) null);

    /* renamed from: animateElevation-rAjV9yQ$default  reason: not valid java name */
    public static /* synthetic */ Object m981animateElevationrAjV9yQ$default(Animatable animatable, float f, Interaction interaction, Interaction interaction2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            interaction = null;
        }
        if ((i & 4) != 0) {
            interaction2 = null;
        }
        return m980animateElevationrAjV9yQ(animatable, f, interaction, interaction2, continuation);
    }

    /* renamed from: animateElevation-rAjV9yQ  reason: not valid java name */
    public static final Object m980animateElevationrAjV9yQ(Animatable<Dp, ?> animatable, float f, Interaction interaction, Interaction interaction2, Continuation<? super Unit> continuation) {
        AnimationSpec<Dp> outgoingAnimationSpecForInteraction;
        if (interaction2 != null) {
            outgoingAnimationSpecForInteraction = ElevationDefaults.INSTANCE.incomingAnimationSpecForInteraction(interaction2);
        } else {
            outgoingAnimationSpecForInteraction = interaction != null ? ElevationDefaults.INSTANCE.outgoingAnimationSpecForInteraction(interaction) : null;
        }
        AnimationSpec<Dp> animationSpec = outgoingAnimationSpecForInteraction;
        if (animationSpec != null) {
            Object animateTo$default = Animatable.animateTo$default(animatable, Dp.m3857boximpl(f), animationSpec, (Object) null, (Function1) null, continuation, 12, (Object) null);
            return animateTo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$default : Unit.INSTANCE;
        }
        Object snapTo = animatable.snapTo(Dp.m3857boximpl(f), continuation);
        return snapTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? snapTo : Unit.INSTANCE;
    }
}
