package androidx.constraintlayout.compose;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ScaleKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.compose.Dimension;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.braintreepayments.api.models.PostalAddressParser;
import com.nimbusds.jose.shaded.ow2asm.Opcodes;
import java.util.EnumSet;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

@Metadata(d1 = {"\u0000Ì\u0001\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aE\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001e\b\u0004\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\bø\u0001\u0000¢\u0006\u0002\u0010\u0019\u001an\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u001c\u001a\u00020\u00012\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0010\b\n\u0010 \u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010!2\u0013\b\b\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u000f0!¢\u0006\u0002\b\u0017H\bø\u0001\u0000¢\u0006\u0002\u0010\"\u001a'\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u001b2\u0017\u0010%\u001a\u0013\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u000f0\u0015¢\u0006\u0002\b\u0018\u001a\u0018\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u001b2\b\b\u0001\u0010'\u001a\u00020(\u001a\u001f\u0010#\u001a\u00020\u001b2\u0017\u0010%\u001a\u0013\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u000f0\u0015¢\u0006\u0002\b\u0018\u001a\u0010\u0010#\u001a\u00020\u001b2\b\b\u0001\u0010'\u001a\u00020(\u001a#\u0010#\u001a\u00020\u001b2\b\b\u0001\u0010\u0014\u001a\u00020(2\n\b\u0003\u0010)\u001a\u0004\u0018\u00010(H\u0007¢\u0006\u0002\u0010*\u001a\u001e\u0010+\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020-2\f\u0010.\u001a\b\u0012\u0004\u0012\u0002000/H\u0000\u001a\b\u00101\u001a\u000202H\u0000\u001a3\u00103\u001a\u0002042\u0006\u0010\u0012\u001a\u00020\u00132\f\u00105\u001a\b\u0012\u0004\u0012\u000207062\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u00108\u001a\u000209H\u0001¢\u0006\u0002\u0010:\u001aE\u00103\u001a\u0014\u0012\u0004\u0012\u000204\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0!0;2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010<\u001a\u00020\u00162\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u0001062\u0006\u00108\u001a\u000209H\u0001¢\u0006\u0002\u0010>\u001a\u001f\u0010?\u001a\u00020\u0003*\u00020\u00042\u0006\u0010@\u001a\u00020Aø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\bB\u0010C\u001a\u001f\u0010?\u001a\u00020\u0007*\u00020\b2\u0006\u0010@\u001a\u00020Aø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\bB\u0010D\u001a!\u0010\u0002\u001a\u00020\u0007*\u00020\b2\u0006\u0010@\u001a\u00020AH\u0007ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\bE\u0010D\u001a\u001f\u0010F\u001a\u00020\b*\u00020\u00042\u0006\u0010@\u001a\u00020Aø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\bG\u0010H\u001a\u001f\u0010F\u001a\u00020\u0007*\u00020\u00032\u0006\u0010@\u001a\u00020Aø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\bG\u0010I\u001a\f\u0010J\u001a\u00020(*\u00020KH\u0002\u001a\f\u0010J\u001a\u00020(*\u00020LH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XD¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0003*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"\u0015\u0010\u0002\u001a\u00020\u0007*\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\t\"\u0015\u0010\n\u001a\u00020\b*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u0015\u0010\n\u001a\u00020\u0007*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\r*\f\b\u0000\u0010M\"\u00020N2\u00020N*\f\b\u0000\u0010O\"\u00020P2\u00020P*\f\b\u0000\u0010Q\"\u00020R2\u00020R*\f\b\u0000\u0010S\"\u00020T2\u00020T\u0002\u0012\n\u0005\b20\u0001\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006U"}, d2 = {"DEBUG", "", "atLeastWrapContent", "Landroidx/constraintlayout/compose/Dimension$MaxCoercible;", "Landroidx/constraintlayout/compose/Dimension$Coercible;", "getAtLeastWrapContent", "(Landroidx/constraintlayout/compose/Dimension$Coercible;)Landroidx/constraintlayout/compose/Dimension$MaxCoercible;", "Landroidx/constraintlayout/compose/Dimension;", "Landroidx/constraintlayout/compose/Dimension$MinCoercible;", "(Landroidx/constraintlayout/compose/Dimension$MinCoercible;)Landroidx/constraintlayout/compose/Dimension;", "atMostWrapContent", "getAtMostWrapContent", "(Landroidx/constraintlayout/compose/Dimension$Coercible;)Landroidx/constraintlayout/compose/Dimension$MinCoercible;", "(Landroidx/constraintlayout/compose/Dimension$MaxCoercible;)Landroidx/constraintlayout/compose/Dimension;", "ConstraintLayout", "", "modifier", "Landroidx/compose/ui/Modifier;", "optimizationLevel", "", "content", "Lkotlin/Function1;", "Landroidx/constraintlayout/compose/ConstraintLayoutScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;ILkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "constraintSet", "Landroidx/constraintlayout/compose/ConstraintSet;", "animateChanges", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "finishedAnimationListener", "Lkotlin/Function0;", "(Landroidx/constraintlayout/compose/ConstraintSet;Landroidx/compose/ui/Modifier;IZLandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ConstraintSet", "extendConstraintSet", "description", "Landroidx/constraintlayout/compose/ConstraintSetScope;", "jsonContent", "", "overrideVariables", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/constraintlayout/compose/ConstraintSet;", "buildMapping", "state", "Landroidx/constraintlayout/compose/State;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "createId", "", "rememberConstraintLayoutMeasurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "needsUpdate", "Landroidx/compose/runtime/MutableState;", "", "measurer", "Landroidx/constraintlayout/compose/Measurer;", "(ILandroidx/compose/runtime/MutableState;Landroidx/constraintlayout/compose/ConstraintSet;Landroidx/constraintlayout/compose/Measurer;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MeasurePolicy;", "Lkotlin/Pair;", "scope", "remeasureRequesterState", "(ILandroidx/constraintlayout/compose/ConstraintLayoutScope;Landroidx/compose/runtime/MutableState;Landroidx/constraintlayout/compose/Measurer;Landroidx/compose/runtime/Composer;I)Lkotlin/Pair;", "atLeast", "dp", "Landroidx/compose/ui/unit/Dp;", "atLeast-3ABfNKs", "(Landroidx/constraintlayout/compose/Dimension$Coercible;F)Landroidx/constraintlayout/compose/Dimension$MaxCoercible;", "(Landroidx/constraintlayout/compose/Dimension$MinCoercible;F)Landroidx/constraintlayout/compose/Dimension;", "atLeastWrapContent-3ABfNKs", "atMost", "atMost-3ABfNKs", "(Landroidx/constraintlayout/compose/Dimension$Coercible;F)Landroidx/constraintlayout/compose/Dimension$MinCoercible;", "(Landroidx/constraintlayout/compose/Dimension$MaxCoercible;F)Landroidx/constraintlayout/compose/Dimension;", "toDebugString", "Landroidx/constraintlayout/core/widgets/ConstraintWidget;", "Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;", "SolverChain", "Landroidx/constraintlayout/core/state/State$Chain;", "SolverDimension", "Landroidx/constraintlayout/core/state/Dimension;", "SolverDirection", "Landroidx/constraintlayout/core/state/State$Direction;", "SolverState", "Landroidx/constraintlayout/core/state/State;", "compose_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* compiled from: ConstraintLayout.kt */
public final class ConstraintLayoutKt {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = false;

    /* access modifiers changed from: private */
    public static final String toDebugString(BasicMeasure.Measure measure) {
        return "measure strategy is ";
    }

    public static final void ConstraintLayout(Modifier modifier, int i, Function3<? super ConstraintLayoutScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i2, int i3) {
        Function3<? super ConstraintLayoutScope, ? super Composer, ? super Integer, Unit> function32 = function3;
        Composer composer2 = composer;
        int i4 = i2;
        Intrinsics.checkNotNullParameter(function32, "content");
        composer2.startReplaceableGroup(-270267499);
        ComposerKt.sourceInformation(composer2, "C(ConstraintLayout)P(1,2)");
        Modifier modifier2 = (i3 & 1) != 0 ? Modifier.Companion : modifier;
        int i5 = (i3 & 2) != 0 ? 257 : i;
        composer2.startReplaceableGroup(-3687241);
        ComposerKt.sourceInformation(composer2, "C(remember):Composables.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new Measurer();
            composer2.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        Measurer measurer = (Measurer) rememberedValue;
        composer2.startReplaceableGroup(-3687241);
        ComposerKt.sourceInformation(composer2, "C(remember):Composables.kt#9igjgp");
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new ConstraintLayoutScope();
            composer2.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        ConstraintLayoutScope constraintLayoutScope = (ConstraintLayoutScope) rememberedValue2;
        composer2.startReplaceableGroup(-3687241);
        ComposerKt.sourceInformation(composer2, "C(remember):Composables.kt#9igjgp");
        Object rememberedValue3 = composer.rememberedValue();
        if (rememberedValue3 == Composer.Companion.getEmpty()) {
            rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
            composer2.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceableGroup();
        Pair<MeasurePolicy, Function0<Unit>> rememberConstraintLayoutMeasurePolicy = rememberConstraintLayoutMeasurePolicy(i5, constraintLayoutScope, (MutableState<Boolean>) (MutableState) rememberedValue3, measurer, composer, ((i4 >> 3) & 14) | 4544);
        LayoutKt.MultiMeasureLayout(SemanticsModifierKt.semantics$default(modifier2, false, new ConstraintLayoutKt$ConstraintLayout$1(measurer), 1, (Object) null), ComposableLambdaKt.composableLambda(composer2, -819893854, true, new ConstraintLayoutKt$ConstraintLayout$2(constraintLayoutScope, function32, i4, rememberConstraintLayoutMeasurePolicy.component2())), rememberConstraintLayoutMeasurePolicy.component1(), composer, 48, 0);
        composer.endReplaceableGroup();
    }

    public static final Pair<MeasurePolicy, Function0<Unit>> rememberConstraintLayoutMeasurePolicy(int i, ConstraintLayoutScope constraintLayoutScope, MutableState<Boolean> mutableState, Measurer measurer, Composer composer, int i2) {
        Intrinsics.checkNotNullParameter(constraintLayoutScope, "scope");
        Intrinsics.checkNotNullParameter(mutableState, "remeasureRequesterState");
        Intrinsics.checkNotNullParameter(measurer, "measurer");
        composer.startReplaceableGroup(-441911663);
        composer.startReplaceableGroup(-3687241);
        ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new ConstraintSetForInlineDsl(constraintLayoutScope);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        ConstraintSetForInlineDsl constraintSetForInlineDsl = (ConstraintSetForInlineDsl) rememberedValue;
        Integer valueOf = Integer.valueOf(i);
        composer.startReplaceableGroup(-3686930);
        ComposerKt.sourceInformation(composer, "C(remember)P(1):Composables.kt#9igjgp");
        boolean changed = composer.changed((Object) valueOf);
        Object rememberedValue2 = composer.rememberedValue();
        if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = TuplesKt.to(new ConstraintLayoutKt$rememberConstraintLayoutMeasurePolicy$1$measurePolicy$1(measurer, constraintSetForInlineDsl, i, mutableState), new ConstraintLayoutKt$rememberConstraintLayoutMeasurePolicy$1$onHelpersChanged$1(mutableState, constraintSetForInlineDsl));
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        Pair<MeasurePolicy, Function0<Unit>> pair = (Pair) rememberedValue2;
        composer.endReplaceableGroup();
        return pair;
    }

    public static final void ConstraintLayout(ConstraintSet constraintSet, Modifier modifier, int i, boolean z, AnimationSpec<Float> animationSpec, Function0<Unit> function0, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i2, int i3) {
        MotionLayoutScope motionLayoutScope;
        ConstraintSet constraintSet2 = constraintSet;
        Function2<? super Composer, ? super Integer, Unit> function22 = function2;
        Composer composer2 = composer;
        int i4 = i2;
        Intrinsics.checkNotNullParameter(constraintSet2, "constraintSet");
        Intrinsics.checkNotNullParameter(function22, "content");
        composer2.startReplaceableGroup(-270262526);
        ComposerKt.sourceInformation(composer2, "C(ConstraintLayout)P(2,5,6!2,4)");
        Modifier modifier2 = (i3 & 2) != 0 ? Modifier.Companion : modifier;
        int i5 = (i3 & 4) != 0 ? 257 : i;
        boolean z2 = (i3 & 8) != 0 ? false : z;
        AnimationSpec<Float> tween$default = (i3 & 16) != 0 ? AnimationSpecKt.tween$default(0, 0, (Easing) null, 7, (Object) null) : animationSpec;
        Function0<Unit> function02 = (i3 & 32) != 0 ? null : function0;
        String str = "C(Layout)P(!1,2)71@2788L7,72@2843L7,73@2855L389:Layout.kt#80mrfh";
        if (z2) {
            composer2.startReplaceableGroup(-270262143);
            composer2.startReplaceableGroup(-3687241);
            ComposerKt.sourceInformation(composer2, "C(remember):Composables.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(constraintSet2, (SnapshotMutationPolicy) null, 2, (Object) null);
                composer2.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            MutableState mutableState = (MutableState) rememberedValue;
            composer2.startReplaceableGroup(-3687241);
            ComposerKt.sourceInformation(composer2, "C(remember):Composables.kt#9igjgp");
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(constraintSet2, (SnapshotMutationPolicy) null, 2, (Object) null);
                composer2.updateRememberedValue(rememberedValue2);
            }
            composer.endReplaceableGroup();
            MutableState mutableState2 = (MutableState) rememberedValue2;
            composer2.startReplaceableGroup(-3687241);
            ComposerKt.sourceInformation(composer2, "C(remember):Composables.kt#9igjgp");
            Object rememberedValue3 = composer.rememberedValue();
            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, (Object) null);
                composer2.updateRememberedValue(rememberedValue3);
            }
            composer.endReplaceableGroup();
            Animatable animatable = (Animatable) rememberedValue3;
            composer2.startReplaceableGroup(-3687241);
            ComposerKt.sourceInformation(composer2, "C(remember):Composables.kt#9igjgp");
            Object rememberedValue4 = composer.rememberedValue();
            if (rememberedValue4 == Composer.Companion.getEmpty()) {
                rememberedValue4 = ChannelKt.Channel$default(-1, (BufferOverflow) null, (Function1) null, 6, (Object) null);
                composer2.updateRememberedValue(rememberedValue4);
            }
            composer.endReplaceableGroup();
            Channel channel = (Channel) rememberedValue4;
            composer2.startReplaceableGroup(-3687241);
            ComposerKt.sourceInformation(composer2, "C(remember):Composables.kt#9igjgp");
            Object rememberedValue5 = composer.rememberedValue();
            if (rememberedValue5 == Composer.Companion.getEmpty()) {
                rememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(1, (SnapshotMutationPolicy) null, 2, (Object) null);
                composer2.updateRememberedValue(rememberedValue5);
            }
            composer.endReplaceableGroup();
            EffectsKt.SideEffect(new ConstraintLayoutKt$ConstraintLayout$3(channel, constraintSet2), composer2, 0);
            EffectsKt.LaunchedEffect((Object) channel, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) new ConstraintLayoutKt$ConstraintLayout$4(channel, (MutableState) rememberedValue5, animatable, tween$default, function02, mutableState, mutableState2, (Continuation<? super ConstraintLayoutKt$ConstraintLayout$4>) null), composer2, 8);
            ConstraintSet r0 = m4153ConstraintLayout$lambda6(mutableState);
            ConstraintSet r1 = m4155ConstraintLayout$lambda9(mutableState2);
            float floatValue = ((Number) animatable.getValue()).floatValue();
            int i6 = (i4 << 12) & Opcodes.ASM7;
            composer2.startReplaceableGroup(-1330873931);
            ComposerKt.sourceInformation(composer2, "C(MotionLayout)P(6,2,7,5,1,3,4)");
            EnumSet of = EnumSet.of(MotionLayoutDebugFlags.NONE);
            Intrinsics.checkNotNullExpressionValue(of, "of(MotionLayoutDebugFlags.NONE)");
            int i7 = i6 & 7168;
            int i8 = i6 << 3;
            int i9 = (i8 & 234881024) | i7 | (i6 & 14) | 229376 | (i6 & 112) | (i6 & 896) | (i8 & 3670016) | (i8 & 29360128);
            composer2.startReplaceableGroup(-1330871174);
            ComposerKt.sourceInformation(composer2, "C(MotionLayout)P(7,2,8,6,1,3,4,5)");
            int i10 = (i9 & 234881024) | (i9 & 14) | 32768 | (i9 & 112) | (i9 & 896) | (i9 & 7168) | (i9 & Opcodes.ASM7) | (3670016 & i9) | (i9 & 29360128);
            composer2.startReplaceableGroup(-1401223160);
            composer2.startReplaceableGroup(-3687241);
            ComposerKt.sourceInformation(composer2, "C(remember):Composables.kt#9igjgp");
            Object rememberedValue6 = composer.rememberedValue();
            if (rememberedValue6 == Composer.Companion.getEmpty()) {
                rememberedValue6 = new MotionMeasurer();
                composer2.updateRememberedValue(rememberedValue6);
            }
            composer.endReplaceableGroup();
            MotionMeasurer motionMeasurer = (MotionMeasurer) rememberedValue6;
            composer2.startReplaceableGroup(-3687241);
            ComposerKt.sourceInformation(composer2, "C(remember):Composables.kt#9igjgp");
            Object rememberedValue7 = composer.rememberedValue();
            if (rememberedValue7 == Composer.Companion.getEmpty()) {
                rememberedValue7 = new MotionLayoutScope(motionMeasurer);
                composer2.updateRememberedValue(rememberedValue7);
            }
            composer.endReplaceableGroup();
            MotionLayoutScope motionLayoutScope2 = (MotionLayoutScope) rememberedValue7;
            composer2.startReplaceableGroup(-3687241);
            ComposerKt.sourceInformation(composer2, "C(remember):Composables.kt#9igjgp");
            Object rememberedValue8 = composer.rememberedValue();
            if (rememberedValue8 == Composer.Companion.getEmpty()) {
                motionLayoutScope = motionLayoutScope2;
                rememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), (SnapshotMutationPolicy) null, 2, (Object) null);
                composer2.updateRememberedValue(rememberedValue8);
            } else {
                motionLayoutScope = motionLayoutScope2;
            }
            composer.endReplaceableGroup();
            MutableState mutableState3 = (MutableState) rememberedValue8;
            EffectsKt.SideEffect(new MotionLayoutKt$MotionLayoutCore$7(mutableState3, floatValue), composer2, 0);
            int i11 = i10 << 9;
            String str2 = "C:CompositionLocal.kt#9igjgp";
            String str3 = "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo";
            ConstraintSet constraintSet3 = r0;
            EnumSet enumSet = of;
            String str4 = str;
            MotionLayoutScope motionLayoutScope3 = motionLayoutScope;
            MotionMeasurer motionMeasurer2 = motionMeasurer;
            MeasurePolicy rememberMotionLayoutMeasurePolicy = MotionLayoutKt.rememberMotionLayoutMeasurePolicy(257, of, 0, constraintSet3, r1, (Transition) null, mutableState3, motionMeasurer2, composer, 18350528 | ((i10 >> 21) & 14) | (i11 & 7168) | (57344 & i11) | (i11 & Opcodes.ASM7));
            MotionMeasurer motionMeasurer3 = motionMeasurer2;
            motionMeasurer3.addLayoutInformationReceiver((LayoutInformationReceiver) null);
            float forcedScaleFactor = motionMeasurer3.getForcedScaleFactor();
            if (!enumSet.contains(MotionLayoutDebugFlags.NONE) || !Float.isNaN(forcedScaleFactor)) {
                MotionLayoutScope motionLayoutScope4 = motionLayoutScope3;
                composer2.startReplaceableGroup(-1401222019);
                if (!Float.isNaN(forcedScaleFactor)) {
                    modifier2 = ScaleKt.scale(modifier2, motionMeasurer3.getForcedScaleFactor());
                }
                composer2.startReplaceableGroup(-1990474327);
                ComposerKt.sourceInformation(composer2, str3);
                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composer2, 0);
                composer2.startReplaceableGroup(1376089335);
                ComposerKt.sourceInformation(composer2, str4);
                String str5 = str2;
                ComposerKt.sourceInformationMarkerStart(composer2, 103361330, str5);
                Object consume = composer2.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd(composer);
                Density density = (Density) consume;
                ComposerKt.sourceInformationMarkerStart(composer2, 103361330, str5);
                Object consume2 = composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ComposerKt.sourceInformationMarkerEnd(composer);
                LayoutDirection layoutDirection = (LayoutDirection) consume2;
                Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(Modifier.Companion);
                if (!(composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer.useNode();
                }
                composer.disableReusing();
                Composer r10 = Updater.m1234constructorimpl(composer);
                Updater.m1241setimpl(r10, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m1241setimpl(r10, density, ComposeUiNode.Companion.getSetDensity());
                Updater.m1241setimpl(r10, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
                composer.enableReusing();
                materializerOf.invoke(SkippableUpdater.m1225boximpl(SkippableUpdater.m1226constructorimpl(composer)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                composer2.startReplaceableGroup(-1253629305);
                ComposerKt.sourceInformation(composer2, "C72@3384L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                LayoutKt.MultiMeasureLayout(SemanticsModifierKt.semantics$default(modifier2, false, new MotionLayoutKt$MotionLayoutCore$8$1(motionMeasurer3), 1, (Object) null), ComposableLambdaKt.composableLambda(composer2, -819897313, true, new ConstraintLayoutKt$ConstraintLayout$$inlined$MotionLayout$1(motionLayoutScope4, i10, function22, i4)), rememberMotionLayoutMeasurePolicy, composer, 48, 0);
                if (!Float.isNaN(forcedScaleFactor)) {
                    composer2.startReplaceableGroup(-922832858);
                    motionMeasurer3.drawDebugBounds(boxScope, forcedScaleFactor, composer2, 518);
                    composer.endReplaceableGroup();
                } else {
                    composer2.startReplaceableGroup(-922832784);
                    composer.endReplaceableGroup();
                }
                if (!enumSet.contains(MotionLayoutDebugFlags.NONE)) {
                    composer2.startReplaceableGroup(-922832717);
                    motionMeasurer3.drawDebug(boxScope, composer2, 70);
                    composer.endReplaceableGroup();
                } else {
                    composer2.startReplaceableGroup(-922832666);
                    composer.endReplaceableGroup();
                }
                Unit unit = Unit.INSTANCE;
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
                composer.endNode();
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
            } else {
                composer2.startReplaceableGroup(-1401221304);
                LayoutKt.MultiMeasureLayout(SemanticsModifierKt.semantics$default(modifier2, false, new MotionLayoutKt$MotionLayoutCore$9(motionMeasurer3), 1, (Object) null), ComposableLambdaKt.composableLambda(composer2, -819897795, true, new ConstraintLayoutKt$ConstraintLayout$$inlined$MotionLayout$2(motionLayoutScope3, i10, function22, i4)), rememberMotionLayoutMeasurePolicy, composer, 48, 0);
                composer.endReplaceableGroup();
            }
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            Composer composer3 = composer2;
        } else {
            String str6 = str;
            String str7 = "C:CompositionLocal.kt#9igjgp";
            String str8 = "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo";
            composer2.startReplaceableGroup(-270260735);
            composer2.startReplaceableGroup(-3687241);
            ComposerKt.sourceInformation(composer2, "C(remember):Composables.kt#9igjgp");
            Object rememberedValue9 = composer.rememberedValue();
            if (rememberedValue9 == Composer.Companion.getEmpty()) {
                rememberedValue9 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0L, (SnapshotMutationPolicy) null, 2, (Object) null);
                composer2.updateRememberedValue(rememberedValue9);
            }
            composer.endReplaceableGroup();
            MutableState mutableState4 = (MutableState) rememberedValue9;
            composer2.startReplaceableGroup(-3687241);
            ComposerKt.sourceInformation(composer2, "C(remember):Composables.kt#9igjgp");
            Object rememberedValue10 = composer.rememberedValue();
            if (rememberedValue10 == Composer.Companion.getEmpty()) {
                rememberedValue10 = new Measurer();
                composer2.updateRememberedValue(rememberedValue10);
            }
            composer.endReplaceableGroup();
            Measurer measurer = (Measurer) rememberedValue10;
            Modifier modifier3 = modifier2;
            Composer composer4 = composer2;
            MeasurePolicy rememberConstraintLayoutMeasurePolicy = rememberConstraintLayoutMeasurePolicy(i5, (MutableState<Long>) mutableState4, constraintSet, measurer, composer, ((i4 >> 6) & 14) | 4144 | ((i4 << 6) & 896));
            if (constraintSet2 instanceof EditableJSONLayout) {
                ((EditableJSONLayout) constraintSet2).setUpdateFlag(mutableState4);
            }
            measurer.addLayoutInformationReceiver(constraintSet2 instanceof LayoutInformationReceiver ? (LayoutInformationReceiver) constraintSet2 : null);
            float forcedScaleFactor2 = measurer.getForcedScaleFactor();
            if (!Float.isNaN(forcedScaleFactor2)) {
                composer4.startReplaceableGroup(-270260121);
                Modifier scale = ScaleKt.scale(modifier3, measurer.getForcedScaleFactor());
                composer4.startReplaceableGroup(-1990474327);
                ComposerKt.sourceInformation(composer4, str8);
                MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composer4, 0);
                composer4.startReplaceableGroup(1376089335);
                ComposerKt.sourceInformation(composer4, str6);
                ComposerKt.sourceInformationMarkerStart(composer4, 103361330, str7);
                Object consume3 = composer4.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd(composer);
                Density density2 = (Density) consume3;
                ComposerKt.sourceInformationMarkerStart(composer4, 103361330, str7);
                Object consume4 = composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ComposerKt.sourceInformationMarkerEnd(composer);
                LayoutDirection layoutDirection2 = (LayoutDirection) consume4;
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(Modifier.Companion);
                if (!(composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer4.createNode(constructor2);
                } else {
                    composer.useNode();
                }
                composer.disableReusing();
                Composer r8 = Updater.m1234constructorimpl(composer);
                Updater.m1241setimpl(r8, rememberBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m1241setimpl(r8, density2, ComposeUiNode.Companion.getSetDensity());
                Updater.m1241setimpl(r8, layoutDirection2, ComposeUiNode.Companion.getSetLayoutDirection());
                composer.enableReusing();
                materializerOf2.invoke(SkippableUpdater.m1225boximpl(SkippableUpdater.m1226constructorimpl(composer)), composer4, 0);
                composer4.startReplaceableGroup(2058660585);
                composer4.startReplaceableGroup(-1253629305);
                ComposerKt.sourceInformation(composer4, "C72@3384L9:Box.kt#2w3rfo");
                LayoutKt.MultiMeasureLayout(SemanticsModifierKt.semantics$default(scale, false, new ConstraintLayoutKt$ConstraintLayout$6$1(measurer), 1, (Object) null), ComposableLambdaKt.composableLambda(composer4, -819901215, true, new ConstraintLayoutKt$ConstraintLayout$6$2(measurer, function22, i2)), rememberConstraintLayoutMeasurePolicy, composer, 48, 0);
                measurer.drawDebugBounds(BoxScopeInstance.INSTANCE, forcedScaleFactor2, composer4, 518);
                Unit unit2 = Unit.INSTANCE;
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
                composer.endNode();
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
            } else {
                composer4.startReplaceableGroup(-270259531);
                LayoutKt.MultiMeasureLayout(SemanticsModifierKt.semantics$default(modifier3, false, new ConstraintLayoutKt$ConstraintLayout$7(measurer), 1, (Object) null), ComposableLambdaKt.composableLambda(composer4, -819901739, true, new ConstraintLayoutKt$ConstraintLayout$8(measurer, function22, i2)), rememberConstraintLayoutMeasurePolicy, composer, 48, 0);
                composer.endReplaceableGroup();
            }
            composer.endReplaceableGroup();
        }
        composer.endReplaceableGroup();
    }

    /* access modifiers changed from: private */
    /* renamed from: ConstraintLayout$lambda-6  reason: not valid java name */
    public static final ConstraintSet m4153ConstraintLayout$lambda6(MutableState<ConstraintSet> mutableState) {
        return (ConstraintSet) mutableState.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: ConstraintLayout$lambda-9  reason: not valid java name */
    public static final ConstraintSet m4155ConstraintLayout$lambda9(MutableState<ConstraintSet> mutableState) {
        return (ConstraintSet) mutableState.getValue();
    }

    public static final MeasurePolicy rememberConstraintLayoutMeasurePolicy(int i, MutableState<Long> mutableState, ConstraintSet constraintSet, Measurer measurer, Composer composer, int i2) {
        Intrinsics.checkNotNullParameter(mutableState, "needsUpdate");
        Intrinsics.checkNotNullParameter(constraintSet, "constraintSet");
        Intrinsics.checkNotNullParameter(measurer, "measurer");
        composer.startReplaceableGroup(-441904281);
        Integer valueOf = Integer.valueOf(i);
        Long value = mutableState.getValue();
        composer.startReplaceableGroup(-3686095);
        ComposerKt.sourceInformation(composer, "C(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean changed = composer.changed((Object) value) | composer.changed((Object) valueOf) | composer.changed((Object) constraintSet);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            measurer.parseDesignElements(constraintSet);
            rememberedValue = new ConstraintLayoutKt$rememberConstraintLayoutMeasurePolicy$2$1(measurer, constraintSet, i);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue;
        composer.endReplaceableGroup();
        return measurePolicy;
    }

    public static final Object createId() {
        return new ConstraintLayoutKt$createId$1();
    }

    public static final Dimension.MaxCoercible getAtLeastWrapContent(Dimension.Coercible coercible) {
        Intrinsics.checkNotNullParameter(coercible, "<this>");
        DimensionDescription dimensionDescription = (DimensionDescription) coercible;
        dimensionDescription.setMinSymbol(androidx.constraintlayout.core.state.Dimension.WRAP_DIMENSION);
        return dimensionDescription;
    }

    /* renamed from: atLeast-3ABfNKs  reason: not valid java name */
    public static final Dimension.MaxCoercible m4160atLeast3ABfNKs(Dimension.Coercible coercible, float f) {
        Intrinsics.checkNotNullParameter(coercible, "$this$atLeast");
        DimensionDescription dimensionDescription = (DimensionDescription) coercible;
        dimensionDescription.m4173setMinYLDhkOg(Dp.m3857boximpl(f));
        return dimensionDescription;
    }

    /* renamed from: atMost-3ABfNKs  reason: not valid java name */
    public static final Dimension.MinCoercible m4163atMost3ABfNKs(Dimension.Coercible coercible, float f) {
        Intrinsics.checkNotNullParameter(coercible, "$this$atMost");
        DimensionDescription dimensionDescription = (DimensionDescription) coercible;
        dimensionDescription.m4172setMaxYLDhkOg(Dp.m3857boximpl(f));
        return dimensionDescription;
    }

    public static final Dimension.MinCoercible getAtMostWrapContent(Dimension.Coercible coercible) {
        Intrinsics.checkNotNullParameter(coercible, "<this>");
        DimensionDescription dimensionDescription = (DimensionDescription) coercible;
        dimensionDescription.setMaxSymbol(androidx.constraintlayout.core.state.Dimension.WRAP_DIMENSION);
        return dimensionDescription;
    }

    @Deprecated(message = "Unintended method name, use atLeast(dp) instead", replaceWith = @ReplaceWith(expression = "this.atLeast(dp)", imports = {"androidx.constraintlayout.compose.atLeast"}))
    /* renamed from: atLeastWrapContent-3ABfNKs  reason: not valid java name */
    public static final Dimension m4162atLeastWrapContent3ABfNKs(Dimension.MinCoercible minCoercible, float f) {
        Intrinsics.checkNotNullParameter(minCoercible, "$this$atLeastWrapContent");
        DimensionDescription dimensionDescription = (DimensionDescription) minCoercible;
        dimensionDescription.m4173setMinYLDhkOg(Dp.m3857boximpl(f));
        return dimensionDescription;
    }

    /* renamed from: atLeast-3ABfNKs  reason: not valid java name */
    public static final Dimension m4161atLeast3ABfNKs(Dimension.MinCoercible minCoercible, float f) {
        Intrinsics.checkNotNullParameter(minCoercible, "$this$atLeast");
        DimensionDescription dimensionDescription = (DimensionDescription) minCoercible;
        dimensionDescription.m4173setMinYLDhkOg(Dp.m3857boximpl(f));
        return dimensionDescription;
    }

    public static final Dimension getAtLeastWrapContent(Dimension.MinCoercible minCoercible) {
        Intrinsics.checkNotNullParameter(minCoercible, "<this>");
        DimensionDescription dimensionDescription = (DimensionDescription) minCoercible;
        dimensionDescription.setMinSymbol(androidx.constraintlayout.core.state.Dimension.WRAP_DIMENSION);
        return dimensionDescription;
    }

    /* renamed from: atMost-3ABfNKs  reason: not valid java name */
    public static final Dimension m4164atMost3ABfNKs(Dimension.MaxCoercible maxCoercible, float f) {
        Intrinsics.checkNotNullParameter(maxCoercible, "$this$atMost");
        DimensionDescription dimensionDescription = (DimensionDescription) maxCoercible;
        dimensionDescription.m4172setMaxYLDhkOg(Dp.m3857boximpl(f));
        return dimensionDescription;
    }

    public static final Dimension getAtMostWrapContent(Dimension.MaxCoercible maxCoercible) {
        Intrinsics.checkNotNullParameter(maxCoercible, "<this>");
        DimensionDescription dimensionDescription = (DimensionDescription) maxCoercible;
        dimensionDescription.setMaxSymbol(androidx.constraintlayout.core.state.Dimension.WRAP_DIMENSION);
        return dimensionDescription;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v10, resolved type: androidx.constraintlayout.compose.JSONConstraintSet} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: androidx.constraintlayout.compose.JSONConstraintSet} */
    /* JADX WARNING: type inference failed for: r9v7 */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0036, code lost:
        if (r9 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x0038;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.constraintlayout.compose.ConstraintSet ConstraintSet(java.lang.String r6, java.lang.String r7, androidx.compose.runtime.Composer r8, int r9, int r10) {
        /*
            java.lang.String r9 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r9)
            r9 = 1704604713(0x659a3429, float:9.102583E22)
            r8.startReplaceableGroup(r9)
            java.lang.String r9 = "C(ConstraintSet)"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r9)
            r9 = r10 & 2
            if (r9 == 0) goto L_0x0015
            r7 = 0
        L_0x0015:
            r2 = r7
            r7 = -3686552(0xffffffffffc7bf68, float:NaN)
            r8.startReplaceableGroup(r7)
            java.lang.String r7 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r7)
            boolean r7 = r8.changed((java.lang.Object) r6)
            boolean r9 = r8.changed((java.lang.Object) r2)
            r7 = r7 | r9
            java.lang.Object r9 = r8.rememberedValue()
            if (r7 != 0) goto L_0x0038
            androidx.compose.runtime.Composer$Companion r7 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r7.getEmpty()
            if (r9 != r7) goto L_0x0045
        L_0x0038:
            androidx.constraintlayout.compose.JSONConstraintSet r9 = new androidx.constraintlayout.compose.JSONConstraintSet
            r3 = 0
            r4 = 4
            r5 = 0
            r0 = r9
            r1 = r6
            r0.<init>(r1, r2, r3, r4, r5)
            r8.updateRememberedValue(r9)
        L_0x0045:
            r8.endReplaceableGroup()
            androidx.constraintlayout.compose.JSONConstraintSet r9 = (androidx.constraintlayout.compose.JSONConstraintSet) r9
            r8.endReplaceableGroup()
            androidx.constraintlayout.compose.ConstraintSet r9 = (androidx.constraintlayout.compose.ConstraintSet) r9
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.compose.ConstraintLayoutKt.ConstraintSet(java.lang.String, java.lang.String, androidx.compose.runtime.Composer, int, int):androidx.constraintlayout.compose.ConstraintSet");
    }

    public static final ConstraintSet ConstraintSet(String str) {
        Intrinsics.checkNotNullParameter(str, "jsonContent");
        return new JSONConstraintSet(str, (String) null, (ConstraintSet) null, 6, (DefaultConstructorMarker) null);
    }

    public static final ConstraintSet ConstraintSet(ConstraintSet constraintSet, String str) {
        Intrinsics.checkNotNullParameter(constraintSet, "extendConstraintSet");
        Intrinsics.checkNotNullParameter(str, "jsonContent");
        return new JSONConstraintSet(str, (String) null, constraintSet, 2, (DefaultConstructorMarker) null);
    }

    public static final ConstraintSet ConstraintSet(Function1<? super ConstraintSetScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "description");
        return new DslConstraintSet(function1, (ConstraintSet) null, 2, (DefaultConstructorMarker) null);
    }

    public static final ConstraintSet ConstraintSet(ConstraintSet constraintSet, Function1<? super ConstraintSetScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(constraintSet, "extendConstraintSet");
        Intrinsics.checkNotNullParameter(function1, "description");
        return new DslConstraintSet(function1, constraintSet);
    }

    /* access modifiers changed from: private */
    public static final String toDebugString(ConstraintWidget constraintWidget) {
        return constraintWidget.getDebugName() + " width " + constraintWidget.getWidth() + " minWidth " + constraintWidget.getMinWidth() + " maxWidth " + constraintWidget.getMaxWidth() + " height " + constraintWidget.getHeight() + " minHeight " + constraintWidget.getMinHeight() + " maxHeight " + constraintWidget.getMaxHeight() + " HDB " + constraintWidget.getHorizontalDimensionBehaviour() + " VDB " + constraintWidget.getVerticalDimensionBehaviour() + " MCW " + constraintWidget.mMatchConstraintDefaultWidth + " MCH " + constraintWidget.mMatchConstraintDefaultHeight + " percentW " + constraintWidget.mMatchConstraintPercentWidth + " percentH " + constraintWidget.mMatchConstraintPercentHeight;
    }

    public static final void buildMapping(State state, List<? extends Measurable> list) {
        Intrinsics.checkNotNullParameter(state, PostalAddressParser.REGION_KEY);
        Intrinsics.checkNotNullParameter(list, "measurables");
        int size = list.size() - 1;
        if (size >= 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                Measurable measurable = (Measurable) list.get(i);
                Object layoutId = LayoutIdKt.getLayoutId(measurable);
                if (layoutId == null && (layoutId = ConstraintLayoutTagKt.getConstraintLayoutId(measurable)) == null) {
                    layoutId = createId();
                }
                state.map(layoutId, measurable);
                Object constraintLayoutTag = ConstraintLayoutTagKt.getConstraintLayoutTag(measurable);
                if (constraintLayoutTag != null && (constraintLayoutTag instanceof String) && (layoutId instanceof String)) {
                    state.setTag((String) layoutId, (String) constraintLayoutTag);
                }
                if (i2 <= size) {
                    i = i2;
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ConstraintLayout$lambda-7  reason: not valid java name */
    public static final void m4154ConstraintLayout$lambda7(MutableState<ConstraintSet> mutableState, ConstraintSet constraintSet) {
        mutableState.setValue(constraintSet);
    }

    /* access modifiers changed from: private */
    /* renamed from: ConstraintLayout$lambda-10  reason: not valid java name */
    public static final void m4152ConstraintLayout$lambda10(MutableState<ConstraintSet> mutableState, ConstraintSet constraintSet) {
        mutableState.setValue(constraintSet);
    }
}
