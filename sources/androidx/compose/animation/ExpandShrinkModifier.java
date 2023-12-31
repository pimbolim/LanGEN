package androidx.compose.animation;

import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001Bt\u0012\u001c\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003R\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\u0003R\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b\u0012\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b\u0012\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000bø\u0001\u0000¢\u0006\u0002\u0010\u0010J#\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b'\u0010(J#\u0010)\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010(J)\u0010+\u001a\u00020,*\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b2\u00103R\u0019\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0019\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R*\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\u0003R\b\u0012\u0004\u0012\u00020\u00070\u0006ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R*\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003R\b\u0012\u0004\u0012\u00020\u00070\u0006ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR1\u0010\u001d\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040 0\u001e¢\u0006\u0002\b!ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00064"}, d2 = {"Landroidx/compose/animation/ExpandShrinkModifier;", "Landroidx/compose/animation/LayoutModifierWithPassThroughIntrinsics;", "sizeAnimation", "Landroidx/compose/animation/core/Transition$DeferredAnimation;", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/animation/core/AnimationVector2D;", "Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/EnterExitState;", "offsetAnimation", "Landroidx/compose/ui/unit/IntOffset;", "expand", "Landroidx/compose/runtime/State;", "Landroidx/compose/animation/ChangeSize;", "shrink", "alignment", "Landroidx/compose/ui/Alignment;", "(Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/runtime/State;Landroidx/compose/runtime/State;Landroidx/compose/runtime/State;)V", "getAlignment", "()Landroidx/compose/runtime/State;", "currentAlignment", "getCurrentAlignment", "()Landroidx/compose/ui/Alignment;", "setCurrentAlignment", "(Landroidx/compose/ui/Alignment;)V", "getExpand", "getOffsetAnimation", "()Landroidx/compose/animation/core/Transition$DeferredAnimation;", "getShrink", "getSizeAnimation", "sizeTransitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Lkotlin/ExtensionFunctionType;", "getSizeTransitionSpec", "()Lkotlin/jvm/functions/Function1;", "sizeByState", "targetState", "fullSize", "sizeByState-Uzc_VyU", "(Landroidx/compose/animation/EnterExitState;J)J", "targetOffsetByState", "targetOffsetByState-oFUgxo0", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "animation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EnterExitTransition.kt */
final class ExpandShrinkModifier extends LayoutModifierWithPassThroughIntrinsics {
    private final State<Alignment> alignment;
    private Alignment currentAlignment;
    private final State<ChangeSize> expand;
    private final Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> offsetAnimation;
    private final State<ChangeSize> shrink;
    private final Transition<EnterExitState>.DeferredAnimation<IntSize, AnimationVector2D> sizeAnimation;
    private final Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntSize>> sizeTransitionSpec = new ExpandShrinkModifier$sizeTransitionSpec$1(this);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: EnterExitTransition.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EnterExitState.values().length];
            iArr[EnterExitState.Visible.ordinal()] = 1;
            iArr[EnterExitState.PreEnter.ordinal()] = 2;
            iArr[EnterExitState.PostExit.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final Transition<EnterExitState>.DeferredAnimation<IntSize, AnimationVector2D> getSizeAnimation() {
        return this.sizeAnimation;
    }

    public final Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> getOffsetAnimation() {
        return this.offsetAnimation;
    }

    public final State<ChangeSize> getExpand() {
        return this.expand;
    }

    public final State<ChangeSize> getShrink() {
        return this.shrink;
    }

    public final State<Alignment> getAlignment() {
        return this.alignment;
    }

    public ExpandShrinkModifier(Transition<EnterExitState>.DeferredAnimation<IntSize, AnimationVector2D> deferredAnimation, Transition<EnterExitState>.DeferredAnimation<IntOffset, AnimationVector2D> deferredAnimation2, State<ChangeSize> state, State<ChangeSize> state2, State<? extends Alignment> state3) {
        Intrinsics.checkNotNullParameter(deferredAnimation, "sizeAnimation");
        Intrinsics.checkNotNullParameter(deferredAnimation2, "offsetAnimation");
        Intrinsics.checkNotNullParameter(state, "expand");
        Intrinsics.checkNotNullParameter(state2, "shrink");
        Intrinsics.checkNotNullParameter(state3, "alignment");
        this.sizeAnimation = deferredAnimation;
        this.offsetAnimation = deferredAnimation2;
        this.expand = state;
        this.shrink = state2;
        this.alignment = state3;
    }

    public final Alignment getCurrentAlignment() {
        return this.currentAlignment;
    }

    public final void setCurrentAlignment(Alignment alignment2) {
        this.currentAlignment = alignment2;
    }

    public final Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<IntSize>> getSizeTransitionSpec() {
        return this.sizeTransitionSpec;
    }

    /* renamed from: sizeByState-Uzc_VyU  reason: not valid java name */
    public final long m78sizeByStateUzc_VyU(EnterExitState enterExitState, long j) {
        Intrinsics.checkNotNullParameter(enterExitState, "targetState");
        ChangeSize value = this.expand.getValue();
        long r0 = value == null ? j : value.getSize().invoke(IntSize.m4011boximpl(j)).m4023unboximpl();
        ChangeSize value2 = this.shrink.getValue();
        long r2 = value2 == null ? j : value2.getSize().invoke(IntSize.m4011boximpl(j)).m4023unboximpl();
        int i = WhenMappings.$EnumSwitchMapping$0[enterExitState.ordinal()];
        if (i == 1) {
            return j;
        }
        if (i == 2) {
            return r0;
        }
        if (i == 3) {
            return r2;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* renamed from: targetOffsetByState-oFUgxo0  reason: not valid java name */
    public final long m79targetOffsetByStateoFUgxo0(EnterExitState enterExitState, long j) {
        IntOffset intOffset;
        Intrinsics.checkNotNullParameter(enterExitState, "targetState");
        if (this.currentAlignment == null) {
            return IntOffset.Companion.m3987getZeronOccac();
        }
        if (this.alignment.getValue() == null) {
            return IntOffset.Companion.m3987getZeronOccac();
        }
        if (Intrinsics.areEqual((Object) this.currentAlignment, (Object) this.alignment.getValue())) {
            return IntOffset.Companion.m3987getZeronOccac();
        }
        int i = WhenMappings.$EnumSwitchMapping$0[enterExitState.ordinal()];
        if (i == 1) {
            return IntOffset.Companion.m3987getZeronOccac();
        }
        if (i == 2) {
            return IntOffset.Companion.m3987getZeronOccac();
        }
        if (i == 3) {
            ChangeSize value = this.shrink.getValue();
            if (value == null) {
                intOffset = null;
            } else {
                long r6 = value.getSize().invoke(IntSize.m4011boximpl(j)).m4023unboximpl();
                Alignment value2 = getAlignment().getValue();
                Intrinsics.checkNotNull(value2);
                long j2 = j;
                long j3 = r6;
                long r8 = value2.m1253alignKFBX0sM(j2, j3, LayoutDirection.Ltr);
                Alignment currentAlignment2 = getCurrentAlignment();
                Intrinsics.checkNotNull(currentAlignment2);
                long r11 = currentAlignment2.m1253alignKFBX0sM(j2, j3, LayoutDirection.Ltr);
                intOffset = IntOffset.m3968boximpl(IntOffsetKt.IntOffset(IntOffset.m3977getXimpl(r8) - IntOffset.m3977getXimpl(r11), IntOffset.m3978getYimpl(r8) - IntOffset.m3978getYimpl(r11)));
            }
            return intOffset == null ? IntOffset.Companion.m3987getZeronOccac() : intOffset.m3986unboximpl();
        }
        throw new NoWhenBranchMatchedException();
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m77measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        IntOffset intOffset;
        long j2;
        Intrinsics.checkNotNullParameter(measureScope, "$receiver");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        Placeable r4 = measurable.m3151measureBRTryo0(j);
        long IntSize = IntSizeKt.IntSize(r4.getWidth(), r4.getHeight());
        long r11 = this.sizeAnimation.animate(this.sizeTransitionSpec, new ExpandShrinkModifier$measure$currentSize$1(this, IntSize)).getValue().m4023unboximpl();
        long r13 = this.offsetAnimation.animate(ExpandShrinkModifier$measure$offsetDelta$1.INSTANCE, new ExpandShrinkModifier$measure$offsetDelta$2(this, IntSize)).getValue().m3986unboximpl();
        Alignment alignment2 = this.currentAlignment;
        if (alignment2 == null) {
            intOffset = null;
        } else {
            intOffset = IntOffset.m3968boximpl(alignment2.m1253alignKFBX0sM(IntSize, r11, LayoutDirection.Ltr));
        }
        if (intOffset == null) {
            j2 = IntOffset.Companion.m3987getZeronOccac();
        } else {
            j2 = intOffset.m3986unboximpl();
        }
        int r1 = IntSize.m4019getWidthimpl(r11);
        return MeasureScope.DefaultImpls.layout$default(measureScope, r1, IntSize.m4018getHeightimpl(r11), (Map) null, new ExpandShrinkModifier$measure$1(r4, j2, r13), 4, (Object) null);
    }
}
