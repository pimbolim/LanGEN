package androidx.constraintlayout.compose;

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
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParser;
import androidx.constraintlayout.core.parser.CLParsingException;
import com.facebook.react.uimanager.ViewProps;
import com.nimbusds.jose.shaded.ow2asm.Opcodes;
import java.util.EnumSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001ay\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u001e\b\u0004\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00030\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\bø\u0001\u0000¢\u0006\u0002\u0010\u0017\u001a\u0001\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u001e\b\u0004\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00030\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\bø\u0001\u0000¢\u0006\u0002\u0010\u001a\u001ae\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u001e\b\u0004\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00030\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\bø\u0001\u0000¢\u0006\u0002\u0010\u001d\u001a\u0001\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001c2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\n0!2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0010\b\n\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010#2\u001e\b\u0004\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00030\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\bø\u0001\u0000¢\u0006\u0002\u0010$\u001a\u0001\u0010%\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u001e\b\u0004\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00030\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\bø\u0001\u0000¢\u0006\u0002\u0010\u001a\u001ae\u0010%\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u001e\b\u0004\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00030\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\bø\u0001\u0000¢\u0006\u0002\u0010\u001d\u001a\u0001\u0010%\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001c2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\n0!2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0010\b\n\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010#2\u001e\b\u0004\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00030\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\bø\u0001\u0000¢\u0006\u0002\u0010$\u001a\u0017\u0010&\u001a\u00020\u001c2\b\b\u0001\u0010\u0012\u001a\u00020\u001fH\u0007¢\u0006\u0002\u0010'\u001a\u0019\u0010(\u001a\u0004\u0018\u00010\b2\b\b\u0001\u0010\u0012\u001a\u00020\u001fH\u0007¢\u0006\u0002\u0010)\u001a[\u0010*\u001a\u00020+2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n002\u0006\u00101\u001a\u000202H\u0001¢\u0006\u0002\u00103\"\u000e\u0010\u0000\u001a\u00020\u0001XD¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b20\u0001¨\u00064"}, d2 = {"DEBUG", "", "MotionLayout", "", "start", "Landroidx/constraintlayout/compose/ConstraintSet;", "end", "transition", "Landroidx/constraintlayout/compose/Transition;", "progress", "", "debug", "Ljava/util/EnumSet;", "Landroidx/constraintlayout/compose/MotionLayoutDebugFlags;", "modifier", "Landroidx/compose/ui/Modifier;", "optimizationLevel", "", "content", "Lkotlin/Function1;", "Landroidx/constraintlayout/compose/MotionLayoutScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/constraintlayout/compose/ConstraintSet;Landroidx/constraintlayout/compose/ConstraintSet;Landroidx/constraintlayout/compose/Transition;FLjava/util/EnumSet;Landroidx/compose/ui/Modifier;ILkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "informationReceiver", "Landroidx/constraintlayout/compose/LayoutInformationReceiver;", "(Landroidx/constraintlayout/compose/ConstraintSet;Landroidx/constraintlayout/compose/ConstraintSet;Landroidx/constraintlayout/compose/Transition;FLjava/util/EnumSet;Landroidx/constraintlayout/compose/LayoutInformationReceiver;Landroidx/compose/ui/Modifier;ILkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "motionScene", "Landroidx/constraintlayout/compose/MotionScene;", "(Landroidx/constraintlayout/compose/MotionScene;FLjava/util/EnumSet;Landroidx/compose/ui/Modifier;ILkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "constraintSetName", "", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "finishedAnimationListener", "Lkotlin/Function0;", "(Landroidx/constraintlayout/compose/MotionScene;Ljava/lang/String;Landroidx/compose/animation/core/AnimationSpec;Ljava/util/EnumSet;Landroidx/compose/ui/Modifier;ILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "MotionLayoutCore", "MotionScene", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/constraintlayout/compose/MotionScene;", "Transition", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/constraintlayout/compose/Transition;", "rememberMotionLayoutMeasurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "needsUpdate", "", "constraintSetStart", "constraintSetEnd", "Landroidx/compose/runtime/MutableState;", "measurer", "Landroidx/constraintlayout/compose/MotionMeasurer;", "(ILjava/util/EnumSet;JLandroidx/constraintlayout/compose/ConstraintSet;Landroidx/constraintlayout/compose/ConstraintSet;Landroidx/constraintlayout/compose/Transition;Landroidx/compose/runtime/MutableState;Landroidx/constraintlayout/compose/MotionMeasurer;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MeasurePolicy;", "compose_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* compiled from: MotionLayout.kt */
public final class MotionLayoutKt {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = false;

    @ExperimentalMotionApi
    public static final void MotionLayout(ConstraintSet constraintSet, ConstraintSet constraintSet2, Transition transition, float f, EnumSet<MotionLayoutDebugFlags> enumSet, Modifier modifier, int i, Function3<? super MotionLayoutScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i2, int i3) {
        EnumSet<MotionLayoutDebugFlags> enumSet2;
        Composer composer2 = composer;
        int i4 = i2;
        Intrinsics.checkNotNullParameter(constraintSet, ViewProps.START);
        Intrinsics.checkNotNullParameter(constraintSet2, ViewProps.END);
        Intrinsics.checkNotNullParameter(function3, "content");
        composer2.startReplaceableGroup(-1330873931);
        ComposerKt.sourceInformation(composer2, "C(MotionLayout)P(6,2,7,5,1,3,4)");
        Transition transition2 = (i3 & 4) != 0 ? null : transition;
        if ((i3 & 16) != 0) {
            EnumSet<MotionLayoutDebugFlags> of = EnumSet.of(MotionLayoutDebugFlags.NONE);
            Intrinsics.checkNotNullExpressionValue(of, "of(MotionLayoutDebugFlags.NONE)");
            enumSet2 = of;
        } else {
            enumSet2 = enumSet;
        }
        Modifier modifier2 = (i3 & 32) != 0 ? Modifier.Companion : modifier;
        int i5 = (i3 & 64) != 0 ? 257 : i;
        int i6 = i4 << 3;
        int i7 = (i6 & 234881024) | 229376 | (i4 & 14) | (i4 & 112) | (i4 & 896) | (i4 & 7168) | (i6 & 3670016) | (i6 & 29360128);
        composer2.startReplaceableGroup(-1330871174);
        ComposerKt.sourceInformation(composer2, "C(MotionLayout)P(7,2,8,6,1,3,4,5)");
        int i8 = 32768 | (i7 & 14) | (i7 & 112) | (i7 & 896) | (i7 & 7168) | (i7 & Opcodes.ASM7) | (3670016 & i7) | (i7 & 29360128) | (i7 & 234881024);
        composer2.startReplaceableGroup(-1401223160);
        composer2.startReplaceableGroup(-3687241);
        ComposerKt.sourceInformation(composer2, "C(remember):Composables.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new MotionMeasurer();
            composer2.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        MotionMeasurer motionMeasurer = (MotionMeasurer) rememberedValue;
        composer2.startReplaceableGroup(-3687241);
        ComposerKt.sourceInformation(composer2, "C(remember):Composables.kt#9igjgp");
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new MotionLayoutScope(motionMeasurer);
            composer2.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        MotionLayoutScope motionLayoutScope = (MotionLayoutScope) rememberedValue2;
        composer2.startReplaceableGroup(-3687241);
        ComposerKt.sourceInformation(composer2, "C(remember):Composables.kt#9igjgp");
        Object rememberedValue3 = composer.rememberedValue();
        if (rememberedValue3 == Composer.Companion.getEmpty()) {
            rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), (SnapshotMutationPolicy) null, 2, (Object) null);
            composer2.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) rememberedValue3;
        EffectsKt.SideEffect(new MotionLayoutKt$MotionLayoutCore$7(mutableState, f), composer2, 0);
        int i9 = i8 << 9;
        MotionLayoutScope motionLayoutScope2 = motionLayoutScope;
        MotionMeasurer motionMeasurer2 = motionMeasurer;
        int i10 = i8;
        MeasurePolicy rememberMotionLayoutMeasurePolicy = rememberMotionLayoutMeasurePolicy(i5, enumSet2, 0, constraintSet, constraintSet2, transition2, mutableState, motionMeasurer, composer, ((i8 >> 21) & 14) | 18350528 | (i9 & 7168) | (57344 & i9) | (i9 & Opcodes.ASM7));
        motionMeasurer2.addLayoutInformationReceiver((LayoutInformationReceiver) null);
        float forcedScaleFactor = motionMeasurer2.getForcedScaleFactor();
        if (!enumSet2.contains(MotionLayoutDebugFlags.NONE) || !Float.isNaN(forcedScaleFactor)) {
            Function3<? super MotionLayoutScope, ? super Composer, ? super Integer, Unit> function32 = function3;
            MotionLayoutScope motionLayoutScope3 = motionLayoutScope2;
            int i11 = i10;
            composer2.startReplaceableGroup(-1401222019);
            if (!Float.isNaN(forcedScaleFactor)) {
                modifier2 = ScaleKt.scale(modifier2, motionMeasurer2.getForcedScaleFactor());
            }
            composer2.startReplaceableGroup(-1990474327);
            ComposerKt.sourceInformation(composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composer2, 0);
            composer2.startReplaceableGroup(1376089335);
            ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)71@2788L7,72@2843L7,73@2855L389:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(composer2, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume = composer2.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(composer);
            Density density = (Density) consume;
            ComposerKt.sourceInformationMarkerStart(composer2, 103361330, "C:CompositionLocal.kt#9igjgp");
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
            Composer r11 = Updater.m1234constructorimpl(composer);
            Updater.m1241setimpl(r11, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1241setimpl(r11, density, ComposeUiNode.Companion.getSetDensity());
            Updater.m1241setimpl(r11, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
            composer.enableReusing();
            materializerOf.invoke(SkippableUpdater.m1225boximpl(SkippableUpdater.m1226constructorimpl(composer)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            composer2.startReplaceableGroup(-1253629305);
            ComposerKt.sourceInformation(composer2, "C72@3384L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            LayoutKt.MultiMeasureLayout(SemanticsModifierKt.semantics$default(modifier2, false, new MotionLayoutKt$MotionLayoutCore$8$1(motionMeasurer2), 1, (Object) null), ComposableLambdaKt.composableLambda(composer2, -819897313, true, new MotionLayoutKt$MotionLayoutCore$8$2(function32, motionLayoutScope3, i11)), rememberMotionLayoutMeasurePolicy, composer, 48, 0);
            if (!Float.isNaN(forcedScaleFactor)) {
                composer2.startReplaceableGroup(-922832858);
                motionMeasurer2.drawDebugBounds(boxScope, forcedScaleFactor, composer2, 518);
                composer.endReplaceableGroup();
            } else {
                composer2.startReplaceableGroup(-922832784);
                composer.endReplaceableGroup();
            }
            if (!enumSet2.contains(MotionLayoutDebugFlags.NONE)) {
                composer2.startReplaceableGroup(-922832717);
                motionMeasurer2.drawDebug(boxScope, composer2, 70);
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
            LayoutKt.MultiMeasureLayout(SemanticsModifierKt.semantics$default(modifier2, false, new MotionLayoutKt$MotionLayoutCore$9(motionMeasurer2), 1, (Object) null), ComposableLambdaKt.composableLambda(composer2, -819897795, true, new MotionLayoutKt$MotionLayoutCore$10(function3, motionLayoutScope2, i10)), rememberMotionLayoutMeasurePolicy, composer, 48, 0);
            composer.endReplaceableGroup();
        }
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }

    /* JADX WARNING: Removed duplicated region for block: B:69:0x01fc  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x021e  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0241  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x024f  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x02ac  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x02eb  */
    @androidx.constraintlayout.compose.ExperimentalMotionApi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void MotionLayout(androidx.constraintlayout.compose.MotionScene r23, float r24, java.util.EnumSet<androidx.constraintlayout.compose.MotionLayoutDebugFlags> r25, androidx.compose.ui.Modifier r26, int r27, kotlin.jvm.functions.Function3<? super androidx.constraintlayout.compose.MotionLayoutScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, androidx.compose.runtime.Composer r29, int r30, int r31) {
        /*
            r0 = r23
            r1 = r24
            r2 = r28
            r14 = r29
            r3 = r30
            java.lang.String r4 = "motionScene"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r4)
            java.lang.String r4 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r4)
            r4 = -1330873040(0xffffffffb0ac7d30, float:-1.2550228E-9)
            r14.startReplaceableGroup(r4)
            java.lang.String r4 = "C(MotionLayout)P(3,5,1,2,4)"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r4)
            r4 = r31 & 4
            if (r4 == 0) goto L_0x0032
            androidx.constraintlayout.compose.MotionLayoutDebugFlags r4 = androidx.constraintlayout.compose.MotionLayoutDebugFlags.NONE
            java.lang.Enum r4 = (java.lang.Enum) r4
            java.util.EnumSet r4 = java.util.EnumSet.of(r4)
            java.lang.String r5 = "of(MotionLayoutDebugFlags.NONE)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            r15 = r4
            goto L_0x0034
        L_0x0032:
            r15 = r25
        L_0x0034:
            r4 = r31 & 8
            if (r4 == 0) goto L_0x003e
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            r13 = r4
            goto L_0x0040
        L_0x003e:
            r13 = r26
        L_0x0040:
            r4 = r31 & 16
            if (r4 == 0) goto L_0x0047
            r4 = 257(0x101, float:3.6E-43)
            goto L_0x0049
        L_0x0047:
            r4 = r27
        L_0x0049:
            r5 = r3 & 14
            r5 = r5 | 512(0x200, float:7.175E-43)
            r6 = r3 & 112(0x70, float:1.57E-43)
            r5 = r5 | r6
            r6 = r3 & 7168(0x1c00, float:1.0045E-41)
            r5 = r5 | r6
            r6 = 57344(0xe000, float:8.0356E-41)
            r6 = r6 & r3
            r5 = r5 | r6
            r6 = 458752(0x70000, float:6.42848E-40)
            r3 = r3 & r6
            r12 = r5 | r3
            r3 = -1401226724(0xffffffffac7afa1c, float:-3.5665975E-12)
            r14.startReplaceableGroup(r3)
            r3 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r14.startReplaceableGroup(r3)
            java.lang.String r5 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r5)
            java.lang.Object r6 = r29.rememberedValue()
            androidx.compose.runtime.Composer$Companion r7 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r7.getEmpty()
            r8 = 2
            r11 = 0
            if (r6 != r7) goto L_0x0089
            r6 = 0
            java.lang.Long r6 = java.lang.Long.valueOf(r6)
            androidx.compose.runtime.MutableState r6 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r6, r11, r8, r11)
            r14.updateRememberedValue(r6)
        L_0x0089:
            r29.endReplaceableGroup()
            androidx.compose.runtime.MutableState r6 = (androidx.compose.runtime.MutableState) r6
            r0.setUpdateFlag(r6)
            androidx.constraintlayout.compose.MotionLayoutDebugFlags r7 = r23.getForcedDrawDebug()
            androidx.constraintlayout.compose.MotionLayoutDebugFlags r9 = androidx.constraintlayout.compose.MotionLayoutDebugFlags.UNKNOWN
            if (r7 == r9) goto L_0x00a9
            androidx.constraintlayout.compose.MotionLayoutDebugFlags r7 = r23.getForcedDrawDebug()
            java.lang.Enum r7 = (java.lang.Enum) r7
            java.util.EnumSet r7 = java.util.EnumSet.of(r7)
            java.lang.String r9 = "of(motionScene.getForcedDrawDebug())"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r9)
            goto L_0x00aa
        L_0x00a9:
            r7 = r15
        L_0x00aa:
            java.lang.Object r9 = r6.getValue()
            r10 = -3686552(0xffffffffffc7bf68, float:NaN)
            r14.startReplaceableGroup(r10)
            java.lang.String r8 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r8)
            boolean r16 = r14.changed((java.lang.Object) r0)
            boolean r9 = r14.changed((java.lang.Object) r9)
            r9 = r16 | r9
            java.lang.Object r3 = r29.rememberedValue()
            if (r9 != 0) goto L_0x00d1
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r3 != r9) goto L_0x00da
        L_0x00d1:
            java.lang.String r3 = "default"
            java.lang.String r3 = r0.getTransition(r3)
            r14.updateRememberedValue(r3)
        L_0x00da:
            r29.endReplaceableGroup()
            java.lang.String r3 = (java.lang.String) r3
            r9 = 0
            if (r3 != 0) goto L_0x00ef
            r3 = -488329412(0xffffffffe2e4af3c, float:-2.1092423E21)
            r14.startReplaceableGroup(r3)
            r29.endReplaceableGroup()
            r3 = r11
            androidx.constraintlayout.compose.Transition r3 = (androidx.constraintlayout.compose.Transition) r3
            goto L_0x00fc
        L_0x00ef:
            r11 = -1401225883(0xffffffffac7afd65, float:-3.56678E-12)
            r14.startReplaceableGroup(r11)
            androidx.constraintlayout.compose.Transition r3 = Transition(r3, r14, r9)
            r29.endReplaceableGroup()
        L_0x00fc:
            r11 = r3
            if (r11 != 0) goto L_0x0103
            java.lang.String r3 = "start"
            goto L_0x0107
        L_0x0103:
            java.lang.String r3 = r11.getStartConstraintSetId()
        L_0x0107:
            if (r11 != 0) goto L_0x010c
            java.lang.String r16 = "end"
            goto L_0x0110
        L_0x010c:
            java.lang.String r16 = r11.getEndConstraintSetId()
        L_0x0110:
            r17 = r16
            java.lang.Object r9 = r6.getValue()
            r14.startReplaceableGroup(r10)
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r8)
            boolean r16 = r14.changed((java.lang.Object) r0)
            boolean r9 = r14.changed((java.lang.Object) r9)
            r9 = r16 | r9
            java.lang.Object r10 = r29.rememberedValue()
            if (r9 != 0) goto L_0x0134
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r10 != r9) goto L_0x0143
        L_0x0134:
            java.lang.String r3 = r0.getConstraintSet((java.lang.String) r3)
            if (r3 != 0) goto L_0x013f
            r9 = 0
            java.lang.String r3 = r0.getConstraintSet((int) r9)
        L_0x013f:
            r10 = r3
            r14.updateRememberedValue(r10)
        L_0x0143:
            r29.endReplaceableGroup()
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r3 = r6.getValue()
            r9 = -3686552(0xffffffffffc7bf68, float:NaN)
            r14.startReplaceableGroup(r9)
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r8)
            boolean r8 = r14.changed((java.lang.Object) r0)
            boolean r3 = r14.changed((java.lang.Object) r3)
            r3 = r3 | r8
            java.lang.Object r8 = r29.rememberedValue()
            r9 = 1
            if (r3 != 0) goto L_0x016d
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r8 != r3) goto L_0x017d
        L_0x016d:
            r3 = r17
            java.lang.String r3 = r0.getConstraintSet((java.lang.String) r3)
            if (r3 != 0) goto L_0x0179
            java.lang.String r3 = r0.getConstraintSet((int) r9)
        L_0x0179:
            r8 = r3
            r14.updateRememberedValue(r8)
        L_0x017d:
            r29.endReplaceableGroup()
            java.lang.String r8 = (java.lang.String) r8
            if (r10 == 0) goto L_0x0448
            if (r8 != 0) goto L_0x0188
            goto L_0x0448
        L_0x0188:
            androidx.constraintlayout.compose.ConstraintSet r10 = androidx.constraintlayout.compose.ConstraintLayoutKt.ConstraintSet((java.lang.String) r10)
            androidx.constraintlayout.compose.ConstraintSet r8 = androidx.constraintlayout.compose.ConstraintLayoutKt.ConstraintSet((java.lang.String) r8)
            r3 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r14.startReplaceableGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r5)
            java.lang.Object r3 = r29.rememberedValue()
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r16.getEmpty()
            r16 = 0
            if (r3 != r9) goto L_0x01b7
            java.lang.Float r3 = java.lang.Float.valueOf(r16)
            r17 = r13
            r9 = 2
            r13 = 0
            androidx.compose.runtime.MutableState r3 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r3, r13, r9, r13)
            r14.updateRememberedValue(r3)
            goto L_0x01b9
        L_0x01b7:
            r17 = r13
        L_0x01b9:
            r29.endReplaceableGroup()
            androidx.compose.runtime.MutableState r3 = (androidx.compose.runtime.MutableState) r3
            float r9 = r23.getForcedProgress()
            kotlin.jvm.internal.Ref$FloatRef r13 = new kotlin.jvm.internal.Ref$FloatRef
            r13.<init>()
            r13.element = r1
            boolean r18 = java.lang.Float.isNaN(r9)
            if (r18 != 0) goto L_0x01e1
            float r18 = m4184MotionLayoutCore$lambda26(r3)
            int r18 = (r18 > r1 ? 1 : (r18 == r1 ? 0 : -1))
            if (r18 != 0) goto L_0x01da
            r18 = 1
            goto L_0x01dc
        L_0x01da:
            r18 = 0
        L_0x01dc:
            if (r18 == 0) goto L_0x01e1
            r13.element = r9
            goto L_0x01e4
        L_0x01e1:
            r23.resetForcedProgress()
        L_0x01e4:
            m4185MotionLayoutCore$lambda27(r3, r1)
            r1 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r14.startReplaceableGroup(r1)
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r5)
            java.lang.Object r1 = r29.rememberedValue()
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r1 != r3) goto L_0x0204
            androidx.constraintlayout.compose.MotionMeasurer r1 = new androidx.constraintlayout.compose.MotionMeasurer
            r1.<init>()
            r14.updateRememberedValue(r1)
        L_0x0204:
            r29.endReplaceableGroup()
            androidx.constraintlayout.compose.MotionMeasurer r1 = (androidx.constraintlayout.compose.MotionMeasurer) r1
            r3 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r14.startReplaceableGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r5)
            java.lang.Object r3 = r29.rememberedValue()
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r3 != r9) goto L_0x0226
            androidx.constraintlayout.compose.MotionLayoutScope r3 = new androidx.constraintlayout.compose.MotionLayoutScope
            r3.<init>(r1)
            r14.updateRememberedValue(r3)
        L_0x0226:
            r29.endReplaceableGroup()
            r9 = r3
            androidx.constraintlayout.compose.MotionLayoutScope r9 = (androidx.constraintlayout.compose.MotionLayoutScope) r9
            r3 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r14.startReplaceableGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r5)
            java.lang.Object r3 = r29.rememberedValue()
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r3 != r5) goto L_0x024f
            java.lang.Float r3 = java.lang.Float.valueOf(r16)
            r2 = 0
            r5 = 2
            androidx.compose.runtime.MutableState r3 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r3, r2, r5, r2)
            r14.updateRememberedValue(r3)
            goto L_0x0250
        L_0x024f:
            r2 = 0
        L_0x0250:
            r29.endReplaceableGroup()
            r5 = r3
            androidx.compose.runtime.MutableState r5 = (androidx.compose.runtime.MutableState) r5
            androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$3 r3 = new androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$3
            r3.<init>(r5, r13)
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            r13 = 0
            androidx.compose.runtime.EffectsKt.SideEffect(r3, r14, r13)
            java.lang.Object r3 = r6.getValue()
            java.lang.Number r3 = (java.lang.Number) r3
            long r18 = r3.longValue()
            r3 = 18350144(0x1180040, float:2.791817E-38)
            int r6 = r12 >> 12
            r6 = r6 & 14
            r16 = r6 | r3
            r3 = r4
            r4 = r7
            r20 = r5
            r5 = r18
            r7 = r10
            r13 = r9
            r2 = 0
            r10 = 1
            r9 = r11
            r11 = 1
            r10 = r20
            r2 = 0
            r11 = r1
            r21 = r12
            r12 = r29
            r22 = r13
            r2 = r17
            r13 = r16
            androidx.compose.ui.layout.MeasurePolicy r3 = rememberMotionLayoutMeasurePolicy(r3, r4, r5, r7, r8, r9, r10, r11, r12, r13)
            androidx.constraintlayout.compose.JSONMotionScene r0 = (androidx.constraintlayout.compose.JSONMotionScene) r0
            androidx.constraintlayout.compose.LayoutInformationReceiver r0 = (androidx.constraintlayout.compose.LayoutInformationReceiver) r0
            r1.addLayoutInformationReceiver(r0)
            float r0 = r1.getForcedScaleFactor()
            androidx.constraintlayout.compose.MotionLayoutDebugFlags r4 = androidx.constraintlayout.compose.MotionLayoutDebugFlags.NONE
            boolean r4 = r15.contains(r4)
            if (r4 == 0) goto L_0x02eb
            boolean r4 = java.lang.Float.isNaN(r0)
            if (r4 != 0) goto L_0x02ac
            goto L_0x02eb
        L_0x02ac:
            r0 = -1401223448(0xffffffffac7b06e8, float:-3.567308E-12)
            r14.startReplaceableGroup(r0)
            androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$5 r0 = new androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$5
            r0.<init>(r1)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r1 = 1
            r4 = 0
            r5 = 0
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r2, r4, r0, r1, r5)
            r2 = -819899683(0xffffffffcf2152dd, float:-2.7065623E9)
            androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$6 r4 = new androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$6
            r5 = r28
            r6 = r21
            r7 = r22
            r4.<init>(r5, r7, r6)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r14, r2, r1, r4)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r2 = 48
            r4 = 0
            r23 = r0
            r24 = r1
            r25 = r3
            r26 = r29
            r27 = r2
            r28 = r4
            androidx.compose.ui.layout.LayoutKt.MultiMeasureLayout(r23, r24, r25, r26, r27, r28)
            r29.endReplaceableGroup()
            goto L_0x0444
        L_0x02eb:
            r5 = r28
            r6 = r21
            r7 = r22
            r4 = -1401224163(0xffffffffac7b041d, float:-3.5671529E-12)
            r14.startReplaceableGroup(r4)
            boolean r4 = java.lang.Float.isNaN(r0)
            if (r4 != 0) goto L_0x0306
            float r4 = r1.getForcedScaleFactor()
            androidx.compose.ui.Modifier r13 = androidx.compose.ui.draw.ScaleKt.scale(r2, r4)
            goto L_0x0307
        L_0x0306:
            r13 = r2
        L_0x0307:
            r2 = -1990474327(0xffffffff895bc5a9, float:-2.6454105E-33)
            r14.startReplaceableGroup(r2)
            java.lang.String r2 = "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r2)
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            androidx.compose.ui.Alignment$Companion r4 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r4 = r4.getTopStart()
            r8 = 0
            androidx.compose.ui.layout.MeasurePolicy r4 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r4, r8, r14, r8)
            r8 = 1376089335(0x520574f7, float:1.43298249E11)
            r14.startReplaceableGroup(r8)
            java.lang.String r8 = "C(Layout)P(!1,2)71@2788L7,72@2843L7,73@2855L389:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r8)
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            r9 = 103361330(0x6292b32, float:3.1817102E-35)
            java.lang.String r10 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r9, r10)
            java.lang.Object r8 = r14.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r29)
            androidx.compose.ui.unit.Density r8 = (androidx.compose.ui.unit.Density) r8
            androidx.compose.runtime.ProvidableCompositionLocal r11 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r9, r10)
            java.lang.Object r9 = r14.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r29)
            androidx.compose.ui.unit.LayoutDirection r9 = (androidx.compose.ui.unit.LayoutDirection) r9
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r10 = r10.getConstructor()
            kotlin.jvm.functions.Function3 r2 = androidx.compose.ui.layout.LayoutKt.materializerOf(r2)
            androidx.compose.runtime.Applier r11 = r29.getApplier()
            boolean r11 = r11 instanceof androidx.compose.runtime.Applier
            if (r11 != 0) goto L_0x036a
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x036a:
            r29.startReusableNode()
            boolean r11 = r29.getInserting()
            if (r11 == 0) goto L_0x0377
            r14.createNode(r10)
            goto L_0x037a
        L_0x0377:
            r29.useNode()
        L_0x037a:
            r29.disableReusing()
            androidx.compose.runtime.Composer r10 = androidx.compose.runtime.Updater.m1234constructorimpl(r29)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r10, r4, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetDensity()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r10, r8, r4)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r10, r9, r4)
            r29.enableReusing()
            androidx.compose.runtime.Composer r4 = androidx.compose.runtime.SkippableUpdater.m1226constructorimpl(r29)
            androidx.compose.runtime.SkippableUpdater r4 = androidx.compose.runtime.SkippableUpdater.m1225boximpl(r4)
            r8 = 0
            java.lang.Integer r9 = java.lang.Integer.valueOf(r8)
            r2.invoke(r4, r14, r9)
            r2 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r14.startReplaceableGroup(r2)
            r2 = -1253629305(0xffffffffb5472287, float:-7.418352E-7)
            r14.startReplaceableGroup(r2)
            java.lang.String r2 = "C72@3384L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r2)
            androidx.compose.foundation.layout.BoxScopeInstance r2 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r2 = (androidx.compose.foundation.layout.BoxScope) r2
            androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$4$1 r4 = new androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$4$1
            r4.<init>(r1)
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r8 = 1
            r9 = 0
            r10 = 0
            androidx.compose.ui.Modifier r4 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r13, r9, r4, r8, r10)
            r9 = -819899201(0xffffffffcf2154bf, float:-2.7066857E9)
            androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$4$2 r10 = new androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$4$2
            r10.<init>(r5, r7, r6)
            androidx.compose.runtime.internal.ComposableLambda r5 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r14, r9, r8, r10)
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r6 = 48
            r7 = 0
            r23 = r4
            r24 = r5
            r25 = r3
            r26 = r29
            r27 = r6
            r28 = r7
            androidx.compose.ui.layout.LayoutKt.MultiMeasureLayout(r23, r24, r25, r26, r27, r28)
            boolean r3 = java.lang.Float.isNaN(r0)
            if (r3 != 0) goto L_0x0407
            r3 = -922835002(0xffffffffc8fea7c6, float:-521534.2)
            r14.startReplaceableGroup(r3)
            r3 = 518(0x206, float:7.26E-43)
            r1.drawDebugBounds(r2, r0, r14, r3)
            r29.endReplaceableGroup()
            goto L_0x0410
        L_0x0407:
            r0 = -922834928(0xffffffffc8fea810, float:-521536.5)
            r14.startReplaceableGroup(r0)
            r29.endReplaceableGroup()
        L_0x0410:
            androidx.constraintlayout.compose.MotionLayoutDebugFlags r0 = androidx.constraintlayout.compose.MotionLayoutDebugFlags.NONE
            boolean r0 = r15.contains(r0)
            if (r0 != 0) goto L_0x0427
            r0 = -922834861(0xffffffffc8fea853, float:-521538.6)
            r14.startReplaceableGroup(r0)
            r0 = 70
            r1.drawDebug(r2, r14, r0)
            r29.endReplaceableGroup()
            goto L_0x0430
        L_0x0427:
            r0 = -922834810(0xffffffffc8fea886, float:-521540.2)
            r14.startReplaceableGroup(r0)
            r29.endReplaceableGroup()
        L_0x0430:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r29.endReplaceableGroup()
            r29.endReplaceableGroup()
            r29.endNode()
            r29.endReplaceableGroup()
            r29.endReplaceableGroup()
            r29.endReplaceableGroup()
        L_0x0444:
            r29.endReplaceableGroup()
            goto L_0x044b
        L_0x0448:
            r29.endReplaceableGroup()
        L_0x044b:
            r29.endReplaceableGroup()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayout(androidx.constraintlayout.compose.MotionScene, float, java.util.EnumSet, androidx.compose.ui.Modifier, int, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v11, resolved type: androidx.compose.runtime.MutableState} */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0357, code lost:
        if ((((java.lang.Number) r4.getValue()).floatValue() == ((java.lang.Number) r14.getValue()).floatValue()) != false) goto L_0x0367;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.constraintlayout.compose.ExperimentalMotionApi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void MotionLayout(androidx.constraintlayout.compose.MotionScene r32, java.lang.String r33, androidx.compose.animation.core.AnimationSpec<java.lang.Float> r34, java.util.EnumSet<androidx.constraintlayout.compose.MotionLayoutDebugFlags> r35, androidx.compose.ui.Modifier r36, int r37, kotlin.jvm.functions.Function0<kotlin.Unit> r38, kotlin.jvm.functions.Function3<? super androidx.constraintlayout.compose.MotionLayoutScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r39, androidx.compose.runtime.Composer r40, int r41, int r42) {
        /*
            r0 = r32
            r1 = r39
            r13 = r40
            java.lang.String r2 = "motionScene"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            java.lang.String r2 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            r2 = -1330872018(0xffffffffb0ac812e, float:-1.2551362E-9)
            r13.startReplaceableGroup(r2)
            java.lang.String r2 = "C(MotionLayout)P(6,1!1,3,5,7,4)"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r2)
            r2 = r42 & 2
            r14 = 0
            if (r2 == 0) goto L_0x0022
            r2 = r14
            goto L_0x0024
        L_0x0022:
            r2 = r33
        L_0x0024:
            r3 = r42 & 4
            r15 = 0
            if (r3 == 0) goto L_0x0032
            r3 = 7
            androidx.compose.animation.core.TweenSpec r3 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r15, r15, r14, r3, r14)
            androidx.compose.animation.core.AnimationSpec r3 = (androidx.compose.animation.core.AnimationSpec) r3
            r7 = r3
            goto L_0x0034
        L_0x0032:
            r7 = r34
        L_0x0034:
            r3 = r42 & 8
            if (r3 == 0) goto L_0x0046
            androidx.constraintlayout.compose.MotionLayoutDebugFlags r3 = androidx.constraintlayout.compose.MotionLayoutDebugFlags.NONE
            java.lang.Enum r3 = (java.lang.Enum) r3
            java.util.EnumSet r3 = java.util.EnumSet.of(r3)
            java.lang.String r4 = "of(MotionLayoutDebugFlags.NONE)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            goto L_0x0048
        L_0x0046:
            r3 = r35
        L_0x0048:
            r4 = r42 & 16
            if (r4 == 0) goto L_0x0052
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            r12 = r4
            goto L_0x0054
        L_0x0052:
            r12 = r36
        L_0x0054:
            r4 = r42 & 32
            if (r4 == 0) goto L_0x005d
            r4 = 257(0x101, float:3.6E-43)
            r16 = 257(0x101, float:3.6E-43)
            goto L_0x005f
        L_0x005d:
            r16 = r37
        L_0x005f:
            r4 = r42 & 64
            if (r4 == 0) goto L_0x0065
            r8 = r14
            goto L_0x0067
        L_0x0065:
            r8 = r38
        L_0x0067:
            r4 = r41 & 14
            r4 = r4 | 4608(0x1200, float:6.457E-42)
            r5 = r41 & 112(0x70, float:1.57E-43)
            r4 = r4 | r5
            r17 = 57344(0xe000, float:8.0356E-41)
            r5 = r41 & r17
            r4 = r4 | r5
            r18 = 458752(0x70000, float:6.42848E-40)
            r5 = r41 & r18
            r4 = r4 | r5
            r19 = 3670016(0x380000, float:5.142788E-39)
            r5 = r41 & r19
            r4 = r4 | r5
            r20 = 29360128(0x1c00000, float:7.052966E-38)
            r5 = r41 & r20
            r21 = r4 | r5
            r4 = -1401230599(0xffffffffac7aeaf9, float:-3.5657573E-12)
            r13.startReplaceableGroup(r4)
            r11 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r13.startReplaceableGroup(r11)
            java.lang.String r10 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r10)
            java.lang.Object r4 = r40.rememberedValue()
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            r9 = 2
            if (r4 != r5) goto L_0x00af
            r4 = 0
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            androidx.compose.runtime.MutableState r4 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r4, r14, r9, r14)
            r13.updateRememberedValue(r4)
        L_0x00af:
            r40.endReplaceableGroup()
            androidx.compose.runtime.MutableState r4 = (androidx.compose.runtime.MutableState) r4
            r0.setUpdateFlag(r4)
            androidx.constraintlayout.compose.MotionLayoutDebugFlags r5 = r32.getForcedDrawDebug()
            androidx.constraintlayout.compose.MotionLayoutDebugFlags r6 = androidx.constraintlayout.compose.MotionLayoutDebugFlags.UNKNOWN
            if (r5 == r6) goto L_0x00ce
            androidx.constraintlayout.compose.MotionLayoutDebugFlags r3 = r32.getForcedDrawDebug()
            java.lang.Enum r3 = (java.lang.Enum) r3
            java.util.EnumSet r3 = java.util.EnumSet.of(r3)
            java.lang.String r5 = "of(motionScene.getForcedDrawDebug())"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)
        L_0x00ce:
            java.lang.Object r5 = r4.getValue()
            r22 = r21 & 14
            r6 = -3686552(0xffffffffffc7bf68, float:NaN)
            r13.startReplaceableGroup(r6)
            java.lang.String r11 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r11)
            boolean r23 = r13.changed((java.lang.Object) r0)
            boolean r5 = r13.changed((java.lang.Object) r5)
            r5 = r23 | r5
            java.lang.Object r9 = r40.rememberedValue()
            if (r5 != 0) goto L_0x00f7
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r9 != r5) goto L_0x0100
        L_0x00f7:
            java.lang.String r5 = "default"
            java.lang.String r9 = r0.getTransition(r5)
            r13.updateRememberedValue(r9)
        L_0x0100:
            r40.endReplaceableGroup()
            java.lang.String r9 = (java.lang.String) r9
            if (r9 != 0) goto L_0x0114
            r5 = -488445290(0xffffffffe2e2ea96, float:-2.0929339E21)
            r13.startReplaceableGroup(r5)
            r40.endReplaceableGroup()
            r5 = r14
            androidx.constraintlayout.compose.Transition r5 = (androidx.constraintlayout.compose.Transition) r5
            goto L_0x0121
        L_0x0114:
            r5 = -1401229621(0xffffffffac7aeecb, float:-3.5659694E-12)
            r13.startReplaceableGroup(r5)
            androidx.constraintlayout.compose.Transition r5 = Transition(r9, r13, r15)
            r40.endReplaceableGroup()
        L_0x0121:
            r23 = r5
            if (r23 != 0) goto L_0x0129
            java.lang.String r5 = "start"
            goto L_0x012d
        L_0x0129:
            java.lang.String r5 = r23.getStartConstraintSetId()
        L_0x012d:
            if (r23 != 0) goto L_0x0132
            java.lang.String r9 = "end"
            goto L_0x0136
        L_0x0132:
            java.lang.String r9 = r23.getEndConstraintSetId()
        L_0x0136:
            java.lang.Object r14 = r4.getValue()
            r13.startReplaceableGroup(r6)
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r11)
            boolean r24 = r13.changed((java.lang.Object) r0)
            boolean r14 = r13.changed((java.lang.Object) r14)
            r14 = r24 | r14
            java.lang.Object r6 = r40.rememberedValue()
            if (r14 != 0) goto L_0x0158
            androidx.compose.runtime.Composer$Companion r14 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r14 = r14.getEmpty()
            if (r6 != r14) goto L_0x0166
        L_0x0158:
            java.lang.String r5 = r0.getConstraintSet((java.lang.String) r5)
            if (r5 != 0) goto L_0x0162
            java.lang.String r5 = r0.getConstraintSet((int) r15)
        L_0x0162:
            r6 = r5
            r13.updateRememberedValue(r6)
        L_0x0166:
            r40.endReplaceableGroup()
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r4 = r4.getValue()
            r5 = -3686552(0xffffffffffc7bf68, float:NaN)
            r13.startReplaceableGroup(r5)
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r11)
            boolean r5 = r13.changed((java.lang.Object) r0)
            boolean r4 = r13.changed((java.lang.Object) r4)
            r4 = r4 | r5
            java.lang.Object r5 = r40.rememberedValue()
            r14 = 1
            if (r4 != 0) goto L_0x0190
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r5 != r4) goto L_0x019e
        L_0x0190:
            java.lang.String r4 = r0.getConstraintSet((java.lang.String) r9)
            if (r4 != 0) goto L_0x019a
            java.lang.String r4 = r0.getConstraintSet((int) r14)
        L_0x019a:
            r5 = r4
            r13.updateRememberedValue(r5)
        L_0x019e:
            r40.endReplaceableGroup()
            java.lang.String r5 = (java.lang.String) r5
            r4 = -3686552(0xffffffffffc7bf68, float:NaN)
            r13.startReplaceableGroup(r4)
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r11)
            boolean r4 = r13.changed((java.lang.Object) r0)
            boolean r9 = r13.changed((java.lang.Object) r2)
            r4 = r4 | r9
            java.lang.Object r9 = r40.rememberedValue()
            if (r4 != 0) goto L_0x01c3
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r9 != r4) goto L_0x01cf
        L_0x01c3:
            if (r2 != 0) goto L_0x01c7
            r2 = 0
            goto L_0x01cb
        L_0x01c7:
            java.lang.String r2 = r0.getConstraintSet((java.lang.String) r2)
        L_0x01cb:
            r13.updateRememberedValue(r2)
            r9 = r2
        L_0x01cf:
            r40.endReplaceableGroup()
            java.lang.String r9 = (java.lang.String) r9
            if (r6 == 0) goto L_0x0611
            if (r5 != 0) goto L_0x01da
            goto L_0x0611
        L_0x01da:
            r2 = -3686930(0xffffffffffc7bdee, float:NaN)
            r13.startReplaceableGroup(r2)
            java.lang.String r4 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r4)
            boolean r11 = r13.changed((java.lang.Object) r0)
            java.lang.Object r15 = r40.rememberedValue()
            if (r11 != 0) goto L_0x01f7
            androidx.compose.runtime.Composer$Companion r11 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r11 = r11.getEmpty()
            if (r15 != r11) goto L_0x0205
        L_0x01f7:
            androidx.constraintlayout.compose.ConstraintSet r6 = androidx.constraintlayout.compose.ConstraintLayoutKt.ConstraintSet((java.lang.String) r6)
            r11 = 2
            r15 = 0
            androidx.compose.runtime.MutableState r6 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r6, r15, r11, r15)
            r13.updateRememberedValue(r6)
            r15 = r6
        L_0x0205:
            r40.endReplaceableGroup()
            androidx.compose.runtime.MutableState r15 = (androidx.compose.runtime.MutableState) r15
            r13.startReplaceableGroup(r2)
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r4)
            boolean r6 = r13.changed((java.lang.Object) r0)
            java.lang.Object r11 = r40.rememberedValue()
            if (r6 != 0) goto L_0x0222
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r11 != r6) goto L_0x0230
        L_0x0222:
            androidx.constraintlayout.compose.ConstraintSet r5 = androidx.constraintlayout.compose.ConstraintLayoutKt.ConstraintSet((java.lang.String) r5)
            r6 = 2
            r11 = 0
            androidx.compose.runtime.MutableState r5 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r5, r11, r6, r11)
            r13.updateRememberedValue(r5)
            r11 = r5
        L_0x0230:
            r40.endReplaceableGroup()
            r25 = r11
            androidx.compose.runtime.MutableState r25 = (androidx.compose.runtime.MutableState) r25
            if (r9 != 0) goto L_0x023b
            r5 = 0
            goto L_0x023f
        L_0x023b:
            androidx.constraintlayout.compose.ConstraintSet r5 = androidx.constraintlayout.compose.ConstraintLayoutKt.ConstraintSet((java.lang.String) r9)
        L_0x023f:
            r6 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r13.startReplaceableGroup(r6)
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r10)
            java.lang.Object r6 = r40.rememberedValue()
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            r11 = 0
            if (r6 != r9) goto L_0x025e
            r9 = 2
            r14 = 0
            androidx.compose.animation.core.Animatable r6 = androidx.compose.animation.core.AnimatableKt.Animatable$default(r11, r11, r9, r14)
            r13.updateRememberedValue(r6)
        L_0x025e:
            r40.endReplaceableGroup()
            r14 = r6
            androidx.compose.animation.core.Animatable r14 = (androidx.compose.animation.core.Animatable) r14
            r13.startReplaceableGroup(r2)
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r4)
            boolean r2 = r13.changed((java.lang.Object) r0)
            java.lang.Object r4 = r40.rememberedValue()
            if (r2 != 0) goto L_0x027f
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r4 != r2) goto L_0x027d
            goto L_0x027f
        L_0x027d:
            r2 = 2
            goto L_0x028d
        L_0x027f:
            r2 = 1
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r2)
            r2 = 2
            r6 = 0
            androidx.compose.runtime.MutableState r4 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r4, r6, r2, r6)
            r13.updateRememberedValue(r4)
        L_0x028d:
            r40.endReplaceableGroup()
            r9 = r4
            androidx.compose.runtime.MutableState r9 = (androidx.compose.runtime.MutableState) r9
            r6 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r13.startReplaceableGroup(r6)
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r10)
            java.lang.Object r4 = r40.rememberedValue()
            androidx.compose.runtime.Composer$Companion r26 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r26.getEmpty()
            if (r4 != r2) goto L_0x02b2
            r2 = -1
            r4 = 6
            r6 = 0
            kotlinx.coroutines.channels.Channel r4 = kotlinx.coroutines.channels.ChannelKt.Channel$default(r2, r6, r6, r4, r6)
            r13.updateRememberedValue(r4)
        L_0x02b2:
            r40.endReplaceableGroup()
            r2 = r4
            kotlinx.coroutines.channels.Channel r2 = (kotlinx.coroutines.channels.Channel) r2
            if (r5 == 0) goto L_0x02f6
            r4 = -1401228367(0xffffffffac7af3b1, float:-3.5662413E-12)
            r13.startReplaceableGroup(r4)
            androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$1 r4 = new androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$1
            r4.<init>(r2, r5)
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            r5 = 0
            androidx.compose.runtime.EffectsKt.SideEffect(r4, r13, r5)
            androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$2 r26 = new androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$2
            r27 = 0
            r4 = r26
            r5 = r2
            r28 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r6 = r14
            r29 = r10
            r10 = r15
            r33 = r3
            r3 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r28 = 0
            r11 = r25
            r30 = r12
            r12 = r27
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12)
            r4 = r26
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r5 = r22 | 64
            androidx.compose.runtime.EffectsKt.LaunchedEffect(r0, r2, r4, r13, r5)
            r40.endReplaceableGroup()
            goto L_0x030a
        L_0x02f6:
            r33 = r3
            r29 = r10
            r30 = r12
            r3 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r28 = 0
            r2 = -1401227510(0xffffffffac7af70a, float:-3.566427E-12)
            r13.startReplaceableGroup(r2)
            r40.endReplaceableGroup()
        L_0x030a:
            r13.startReplaceableGroup(r3)
            r2 = r29
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r2)
            java.lang.Object r4 = r40.rememberedValue()
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r4 != r5) goto L_0x032c
            java.lang.Float r4 = java.lang.Float.valueOf(r28)
            r5 = 2
            r6 = 0
            androidx.compose.runtime.MutableState r4 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r4, r6, r5, r6)
            r13.updateRememberedValue(r4)
            goto L_0x032d
        L_0x032c:
            r5 = 2
        L_0x032d:
            r40.endReplaceableGroup()
            androidx.compose.runtime.MutableState r4 = (androidx.compose.runtime.MutableState) r4
            float r6 = r32.getForcedProgress()
            boolean r7 = java.lang.Float.isNaN(r6)
            if (r7 != 0) goto L_0x035a
            java.lang.Object r7 = r4.getValue()
            java.lang.Number r7 = (java.lang.Number) r7
            float r7 = r7.floatValue()
            java.lang.Object r8 = r14.getValue()
            java.lang.Number r8 = (java.lang.Number) r8
            float r8 = r8.floatValue()
            int r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r7 != 0) goto L_0x0356
            r7 = 1
            goto L_0x0357
        L_0x0356:
            r7 = 0
        L_0x0357:
            if (r7 == 0) goto L_0x035a
            goto L_0x0367
        L_0x035a:
            r32.resetForcedProgress()
            java.lang.Object r6 = r14.getValue()
            java.lang.Number r6 = (java.lang.Number) r6
            float r6 = r6.floatValue()
        L_0x0367:
            java.lang.Object r7 = r14.getValue()
            r4.setValue(r7)
            androidx.constraintlayout.compose.ConstraintSet r7 = m4186MotionLayoutCore$lambda8(r15)
            androidx.constraintlayout.compose.ConstraintSet r8 = m4180MotionLayoutCore$lambda11(r25)
            boolean r4 = r0 instanceof androidx.constraintlayout.compose.JSONMotionScene
            if (r4 == 0) goto L_0x037d
            androidx.constraintlayout.compose.JSONMotionScene r0 = (androidx.constraintlayout.compose.JSONMotionScene) r0
            goto L_0x037e
        L_0x037d:
            r0 = 0
        L_0x037e:
            androidx.constraintlayout.compose.LayoutInformationReceiver r0 = (androidx.constraintlayout.compose.LayoutInformationReceiver) r0
            int r4 = r21 << 6
            r9 = r4 & r19
            r10 = 32768(0x8000, float:4.5918E-41)
            r9 = r9 | r10
            r4 = r4 & r20
            r4 = r4 | r9
            int r9 = r21 << 3
            r11 = 234881024(0xe000000, float:1.5777218E-30)
            r9 = r9 & r11
            r4 = r4 | r9
            r9 = -1330871174(0xffffffffb0ac847a, float:-1.2552299E-9)
            r13.startReplaceableGroup(r9)
            java.lang.String r9 = "C(MotionLayout)P(7,2,8,6,1,3,4,5)"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r9)
            r9 = r4 & 14
            r9 = r9 | r10
            r10 = r4 & 112(0x70, float:1.57E-43)
            r9 = r9 | r10
            r10 = r4 & 896(0x380, float:1.256E-42)
            r9 = r9 | r10
            r10 = r4 & 7168(0x1c00, float:1.0045E-41)
            r9 = r9 | r10
            r10 = r4 & r18
            r9 = r9 | r10
            r10 = r4 & r19
            r9 = r9 | r10
            r10 = r4 & r20
            r9 = r9 | r10
            r4 = r4 & r11
            r14 = r9 | r4
            r4 = -1401223160(0xffffffffac7b0808, float:-3.5673704E-12)
            r13.startReplaceableGroup(r4)
            r13.startReplaceableGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r2)
            java.lang.Object r4 = r40.rememberedValue()
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r4 != r9) goto L_0x03d4
            androidx.constraintlayout.compose.MotionMeasurer r4 = new androidx.constraintlayout.compose.MotionMeasurer
            r4.<init>()
            r13.updateRememberedValue(r4)
        L_0x03d4:
            r40.endReplaceableGroup()
            r15 = r4
            androidx.constraintlayout.compose.MotionMeasurer r15 = (androidx.constraintlayout.compose.MotionMeasurer) r15
            r13.startReplaceableGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r2)
            java.lang.Object r4 = r40.rememberedValue()
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r4 != r9) goto L_0x03f4
            androidx.constraintlayout.compose.MotionLayoutScope r4 = new androidx.constraintlayout.compose.MotionLayoutScope
            r4.<init>(r15)
            r13.updateRememberedValue(r4)
        L_0x03f4:
            r40.endReplaceableGroup()
            r12 = r4
            androidx.constraintlayout.compose.MotionLayoutScope r12 = (androidx.constraintlayout.compose.MotionLayoutScope) r12
            r13.startReplaceableGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r2)
            java.lang.Object r2 = r40.rememberedValue()
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r2 != r3) goto L_0x0418
            java.lang.Float r2 = java.lang.Float.valueOf(r28)
            r3 = 0
            androidx.compose.runtime.MutableState r2 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r2, r3, r5, r3)
            r13.updateRememberedValue(r2)
        L_0x0418:
            r40.endReplaceableGroup()
            r9 = r2
            androidx.compose.runtime.MutableState r9 = (androidx.compose.runtime.MutableState) r9
            androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$7 r2 = new androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$7
            r2.<init>(r9, r6)
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            r3 = 0
            androidx.compose.runtime.EffectsKt.SideEffect(r2, r13, r3)
            r4 = 0
            r2 = 18350528(0x11801c0, float:2.7919246E-38)
            int r3 = r14 >> 21
            r3 = r3 & 14
            r2 = r2 | r3
            int r3 = r14 << 9
            r6 = r3 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | r6
            r6 = r3 & r17
            r2 = r2 | r6
            r3 = r3 & r18
            r17 = r2 | r3
            r2 = r16
            r11 = r33
            r3 = r11
            r6 = r7
            r7 = r8
            r8 = r23
            r10 = r15
            r31 = r11
            r11 = r40
            r1 = r12
            r12 = r17
            androidx.compose.ui.layout.MeasurePolicy r2 = rememberMotionLayoutMeasurePolicy(r2, r3, r4, r6, r7, r8, r9, r10, r11, r12)
            r15.addLayoutInformationReceiver(r0)
            float r0 = r15.getForcedScaleFactor()
            androidx.constraintlayout.compose.MotionLayoutDebugFlags r3 = androidx.constraintlayout.compose.MotionLayoutDebugFlags.NONE
            r4 = r31
            boolean r3 = r4.contains(r3)
            if (r3 == 0) goto L_0x04aa
            boolean r3 = java.lang.Float.isNaN(r0)
            if (r3 != 0) goto L_0x046c
            goto L_0x04aa
        L_0x046c:
            r0 = -1401221304(0xffffffffac7b0f48, float:-3.5677728E-12)
            r13.startReplaceableGroup(r0)
            androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$9 r0 = new androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$9
            r0.<init>(r15)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r3 = r30
            r4 = 1
            r5 = 0
            r6 = 0
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r3, r5, r0, r4, r6)
            r3 = -819897795(0xffffffffcf215a3d, float:-2.70704563E9)
            androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$10 r5 = new androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$10
            r6 = r1
            r1 = r39
            r5.<init>(r1, r6, r14)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r13, r3, r4, r5)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r3 = 48
            r4 = 0
            r32 = r0
            r33 = r1
            r34 = r2
            r35 = r40
            r36 = r3
            r37 = r4
            androidx.compose.ui.layout.LayoutKt.MultiMeasureLayout(r32, r33, r34, r35, r36, r37)
            r40.endReplaceableGroup()
            goto L_0x0607
        L_0x04aa:
            r6 = r1
            r3 = r30
            r1 = r39
            r5 = -1401222019(0xffffffffac7b0c7d, float:-3.5676178E-12)
            r13.startReplaceableGroup(r5)
            boolean r5 = java.lang.Float.isNaN(r0)
            if (r5 != 0) goto L_0x04c4
            float r5 = r15.getForcedScaleFactor()
            androidx.compose.ui.Modifier r12 = androidx.compose.ui.draw.ScaleKt.scale(r3, r5)
            goto L_0x04c5
        L_0x04c4:
            r12 = r3
        L_0x04c5:
            r3 = -1990474327(0xffffffff895bc5a9, float:-2.6454105E-33)
            r13.startReplaceableGroup(r3)
            java.lang.String r3 = "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r3)
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            androidx.compose.ui.Alignment$Companion r5 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r5 = r5.getTopStart()
            r7 = 0
            androidx.compose.ui.layout.MeasurePolicy r5 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r5, r7, r13, r7)
            r7 = 1376089335(0x520574f7, float:1.43298249E11)
            r13.startReplaceableGroup(r7)
            java.lang.String r7 = "C(Layout)P(!1,2)71@2788L7,72@2843L7,73@2855L389:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r7)
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            r8 = 103361330(0x6292b32, float:3.1817102E-35)
            java.lang.String r9 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r8, r9)
            java.lang.Object r7 = r13.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r40)
            androidx.compose.ui.unit.Density r7 = (androidx.compose.ui.unit.Density) r7
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            r9 = 103361330(0x6292b32, float:3.1817102E-35)
            java.lang.String r10 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r9, r10)
            java.lang.Object r8 = r13.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r40)
            androidx.compose.ui.unit.LayoutDirection r8 = (androidx.compose.ui.unit.LayoutDirection) r8
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r9 = r9.getConstructor()
            kotlin.jvm.functions.Function3 r3 = androidx.compose.ui.layout.LayoutKt.materializerOf(r3)
            androidx.compose.runtime.Applier r10 = r40.getApplier()
            boolean r10 = r10 instanceof androidx.compose.runtime.Applier
            if (r10 != 0) goto L_0x052d
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x052d:
            r40.startReusableNode()
            boolean r10 = r40.getInserting()
            if (r10 == 0) goto L_0x053a
            r13.createNode(r9)
            goto L_0x053d
        L_0x053a:
            r40.useNode()
        L_0x053d:
            r40.disableReusing()
            androidx.compose.runtime.Composer r9 = androidx.compose.runtime.Updater.m1234constructorimpl(r40)
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r10 = r10.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r9, r5, r10)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetDensity()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r9, r7, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r9, r8, r5)
            r40.enableReusing()
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.SkippableUpdater.m1226constructorimpl(r40)
            androidx.compose.runtime.SkippableUpdater r5 = androidx.compose.runtime.SkippableUpdater.m1225boximpl(r5)
            r7 = 0
            java.lang.Integer r8 = java.lang.Integer.valueOf(r7)
            r3.invoke(r5, r13, r8)
            r3 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r13.startReplaceableGroup(r3)
            r3 = -1253629305(0xffffffffb5472287, float:-7.418352E-7)
            r13.startReplaceableGroup(r3)
            java.lang.String r3 = "C72@3384L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r3)
            androidx.compose.foundation.layout.BoxScopeInstance r3 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r3 = (androidx.compose.foundation.layout.BoxScope) r3
            androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$8$1 r5 = new androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$8$1
            r5.<init>(r15)
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r7 = 1
            r8 = 0
            r9 = 0
            androidx.compose.ui.Modifier r5 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r12, r8, r5, r7, r9)
            r8 = -819897313(0xffffffffcf215c1f, float:-2.70716902E9)
            androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$8$2 r9 = new androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$8$2
            r9.<init>(r1, r6, r14)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r13, r8, r7, r9)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r6 = 48
            r7 = 0
            r32 = r5
            r33 = r1
            r34 = r2
            r35 = r40
            r36 = r6
            r37 = r7
            androidx.compose.ui.layout.LayoutKt.MultiMeasureLayout(r32, r33, r34, r35, r36, r37)
            boolean r1 = java.lang.Float.isNaN(r0)
            if (r1 != 0) goto L_0x05ca
            r1 = -922832858(0xffffffffc8feb026, float:-521601.2)
            r13.startReplaceableGroup(r1)
            r1 = 518(0x206, float:7.26E-43)
            r15.drawDebugBounds(r3, r0, r13, r1)
            r40.endReplaceableGroup()
            goto L_0x05d3
        L_0x05ca:
            r0 = -922832784(0xffffffffc8feb070, float:-521603.5)
            r13.startReplaceableGroup(r0)
            r40.endReplaceableGroup()
        L_0x05d3:
            androidx.constraintlayout.compose.MotionLayoutDebugFlags r0 = androidx.constraintlayout.compose.MotionLayoutDebugFlags.NONE
            boolean r0 = r4.contains(r0)
            if (r0 != 0) goto L_0x05ea
            r0 = -922832717(0xffffffffc8feb0b3, float:-521605.6)
            r13.startReplaceableGroup(r0)
            r0 = 70
            r15.drawDebug(r3, r13, r0)
            r40.endReplaceableGroup()
            goto L_0x05f3
        L_0x05ea:
            r0 = -922832666(0xffffffffc8feb0e6, float:-521607.2)
            r13.startReplaceableGroup(r0)
            r40.endReplaceableGroup()
        L_0x05f3:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r40.endReplaceableGroup()
            r40.endReplaceableGroup()
            r40.endNode()
            r40.endReplaceableGroup()
            r40.endReplaceableGroup()
            r40.endReplaceableGroup()
        L_0x0607:
            r40.endReplaceableGroup()
            r40.endReplaceableGroup()
            r40.endReplaceableGroup()
            goto L_0x0614
        L_0x0611:
            r40.endReplaceableGroup()
        L_0x0614:
            r40.endReplaceableGroup()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayout(androidx.constraintlayout.compose.MotionScene, java.lang.String, androidx.compose.animation.core.AnimationSpec, java.util.EnumSet, androidx.compose.ui.Modifier, int, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    @ExperimentalMotionApi
    public static final void MotionLayout(ConstraintSet constraintSet, ConstraintSet constraintSet2, Transition transition, float f, EnumSet<MotionLayoutDebugFlags> enumSet, LayoutInformationReceiver layoutInformationReceiver, Modifier modifier, int i, Function3<? super MotionLayoutScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i2, int i3) {
        EnumSet<MotionLayoutDebugFlags> enumSet2;
        Composer composer2 = composer;
        int i4 = i2;
        int i5 = i3;
        Intrinsics.checkNotNullParameter(constraintSet, ViewProps.START);
        Intrinsics.checkNotNullParameter(constraintSet2, ViewProps.END);
        Intrinsics.checkNotNullParameter(function3, "content");
        composer2.startReplaceableGroup(-1330871174);
        ComposerKt.sourceInformation(composer2, "C(MotionLayout)P(7,2,8,6,1,3,4,5)");
        Transition transition2 = (i5 & 4) != 0 ? null : transition;
        if ((i5 & 16) != 0) {
            EnumSet<MotionLayoutDebugFlags> of = EnumSet.of(MotionLayoutDebugFlags.NONE);
            Intrinsics.checkNotNullExpressionValue(of, "of(MotionLayoutDebugFlags.NONE)");
            enumSet2 = of;
        } else {
            enumSet2 = enumSet;
        }
        LayoutInformationReceiver layoutInformationReceiver2 = (i5 & 32) != 0 ? null : layoutInformationReceiver;
        Modifier modifier2 = (i5 & 64) != 0 ? Modifier.Companion : modifier;
        int i6 = (i5 & 128) != 0 ? 257 : i;
        int i7 = 32768 | (i4 & 14) | (i4 & 112) | (i4 & 896) | (i4 & 7168) | (i4 & Opcodes.ASM7) | (3670016 & i4) | (29360128 & i4) | (i4 & 234881024);
        composer2.startReplaceableGroup(-1401223160);
        composer2.startReplaceableGroup(-3687241);
        ComposerKt.sourceInformation(composer2, "C(remember):Composables.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new MotionMeasurer();
            composer2.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        MotionMeasurer motionMeasurer = (MotionMeasurer) rememberedValue;
        composer2.startReplaceableGroup(-3687241);
        ComposerKt.sourceInformation(composer2, "C(remember):Composables.kt#9igjgp");
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new MotionLayoutScope(motionMeasurer);
            composer2.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        MotionLayoutScope motionLayoutScope = (MotionLayoutScope) rememberedValue2;
        composer2.startReplaceableGroup(-3687241);
        ComposerKt.sourceInformation(composer2, "C(remember):Composables.kt#9igjgp");
        Object rememberedValue3 = composer.rememberedValue();
        if (rememberedValue3 == Composer.Companion.getEmpty()) {
            rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), (SnapshotMutationPolicy) null, 2, (Object) null);
            composer2.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) rememberedValue3;
        EffectsKt.SideEffect(new MotionLayoutKt$MotionLayoutCore$7(mutableState, f), composer2, 0);
        int i8 = i7 << 9;
        MotionLayoutScope motionLayoutScope2 = motionLayoutScope;
        int i9 = i7;
        Modifier modifier3 = modifier2;
        MeasurePolicy rememberMotionLayoutMeasurePolicy = rememberMotionLayoutMeasurePolicy(i6, enumSet2, 0, constraintSet, constraintSet2, transition2, mutableState, motionMeasurer, composer, ((i7 >> 21) & 14) | 18350528 | (i8 & 7168) | (57344 & i8) | (i8 & Opcodes.ASM7));
        MotionMeasurer motionMeasurer2 = motionMeasurer;
        motionMeasurer2.addLayoutInformationReceiver(layoutInformationReceiver2);
        float forcedScaleFactor = motionMeasurer2.getForcedScaleFactor();
        if (!enumSet2.contains(MotionLayoutDebugFlags.NONE) || !Float.isNaN(forcedScaleFactor)) {
            Function3<? super MotionLayoutScope, ? super Composer, ? super Integer, Unit> function32 = function3;
            MotionLayoutScope motionLayoutScope3 = motionLayoutScope2;
            int i10 = i9;
            composer2.startReplaceableGroup(-1401222019);
            Modifier scale = !Float.isNaN(forcedScaleFactor) ? ScaleKt.scale(modifier3, motionMeasurer2.getForcedScaleFactor()) : modifier3;
            composer2.startReplaceableGroup(-1990474327);
            ComposerKt.sourceInformation(composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composer2, 0);
            composer2.startReplaceableGroup(1376089335);
            ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)71@2788L7,72@2843L7,73@2855L389:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(composer2, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume = composer2.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(composer);
            Density density = (Density) consume;
            ComposerKt.sourceInformationMarkerStart(composer2, 103361330, "C:CompositionLocal.kt#9igjgp");
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
            Composer r13 = Updater.m1234constructorimpl(composer);
            Updater.m1241setimpl(r13, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1241setimpl(r13, density, ComposeUiNode.Companion.getSetDensity());
            Updater.m1241setimpl(r13, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
            composer.enableReusing();
            materializerOf.invoke(SkippableUpdater.m1225boximpl(SkippableUpdater.m1226constructorimpl(composer)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            composer2.startReplaceableGroup(-1253629305);
            ComposerKt.sourceInformation(composer2, "C72@3384L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            LayoutKt.MultiMeasureLayout(SemanticsModifierKt.semantics$default(scale, false, new MotionLayoutKt$MotionLayoutCore$8$1(motionMeasurer2), 1, (Object) null), ComposableLambdaKt.composableLambda(composer2, -819897313, true, new MotionLayoutKt$MotionLayoutCore$8$2(function32, motionLayoutScope3, i10)), rememberMotionLayoutMeasurePolicy, composer, 48, 0);
            if (!Float.isNaN(forcedScaleFactor)) {
                composer2.startReplaceableGroup(-922832858);
                motionMeasurer2.drawDebugBounds(boxScope, forcedScaleFactor, composer2, 518);
                composer.endReplaceableGroup();
            } else {
                composer2.startReplaceableGroup(-922832784);
                composer.endReplaceableGroup();
            }
            if (!enumSet2.contains(MotionLayoutDebugFlags.NONE)) {
                composer2.startReplaceableGroup(-922832717);
                motionMeasurer2.drawDebug(boxScope, composer2, 70);
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
            LayoutKt.MultiMeasureLayout(SemanticsModifierKt.semantics$default(modifier3, false, new MotionLayoutKt$MotionLayoutCore$9(motionMeasurer2), 1, (Object) null), ComposableLambdaKt.composableLambda(composer2, -819897795, true, new MotionLayoutKt$MotionLayoutCore$10(function3, motionLayoutScope2, i9)), rememberMotionLayoutMeasurePolicy, composer, 48, 0);
            composer.endReplaceableGroup();
        }
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v11, resolved type: androidx.compose.runtime.MutableState} */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x032f, code lost:
        if ((((java.lang.Number) r4.getValue()).floatValue() == ((java.lang.Number) r14.getValue()).floatValue()) != false) goto L_0x033f;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void MotionLayoutCore(androidx.constraintlayout.compose.MotionScene r27, java.lang.String r28, androidx.compose.animation.core.AnimationSpec<java.lang.Float> r29, java.util.EnumSet<androidx.constraintlayout.compose.MotionLayoutDebugFlags> r30, androidx.compose.ui.Modifier r31, int r32, kotlin.jvm.functions.Function0<kotlin.Unit> r33, kotlin.jvm.functions.Function3<? super androidx.constraintlayout.compose.MotionLayoutScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r34, androidx.compose.runtime.Composer r35, int r36, int r37) {
        /*
            r0 = r27
            r1 = r34
            r13 = r35
            java.lang.String r2 = "motionScene"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            java.lang.String r2 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            r2 = -1401230599(0xffffffffac7aeaf9, float:-3.5657573E-12)
            r13.startReplaceableGroup(r2)
            r2 = r37 & 2
            r14 = 0
            if (r2 == 0) goto L_0x001d
            r2 = r14
            goto L_0x001f
        L_0x001d:
            r2 = r28
        L_0x001f:
            r3 = r37 & 4
            r15 = 0
            if (r3 == 0) goto L_0x002d
            r3 = 7
            androidx.compose.animation.core.TweenSpec r3 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r15, r15, r14, r3, r14)
            androidx.compose.animation.core.AnimationSpec r3 = (androidx.compose.animation.core.AnimationSpec) r3
            r7 = r3
            goto L_0x002f
        L_0x002d:
            r7 = r29
        L_0x002f:
            r3 = r37 & 8
            if (r3 == 0) goto L_0x0041
            androidx.constraintlayout.compose.MotionLayoutDebugFlags r3 = androidx.constraintlayout.compose.MotionLayoutDebugFlags.NONE
            java.lang.Enum r3 = (java.lang.Enum) r3
            java.util.EnumSet r3 = java.util.EnumSet.of(r3)
            java.lang.String r4 = "of(MotionLayoutDebugFlags.NONE)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            goto L_0x0043
        L_0x0041:
            r3 = r30
        L_0x0043:
            r4 = r37 & 16
            if (r4 == 0) goto L_0x004d
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            r12 = r4
            goto L_0x004f
        L_0x004d:
            r12 = r31
        L_0x004f:
            r4 = r37 & 32
            if (r4 == 0) goto L_0x0058
            r4 = 257(0x101, float:3.6E-43)
            r16 = 257(0x101, float:3.6E-43)
            goto L_0x005a
        L_0x0058:
            r16 = r32
        L_0x005a:
            r4 = r37 & 64
            if (r4 == 0) goto L_0x0060
            r8 = r14
            goto L_0x0062
        L_0x0060:
            r8 = r33
        L_0x0062:
            r11 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r13.startReplaceableGroup(r11)
            java.lang.String r10 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r10)
            java.lang.Object r4 = r35.rememberedValue()
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            r9 = 2
            if (r4 != r5) goto L_0x0087
            r4 = 0
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            androidx.compose.runtime.MutableState r4 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r4, r14, r9, r14)
            r13.updateRememberedValue(r4)
        L_0x0087:
            r35.endReplaceableGroup()
            androidx.compose.runtime.MutableState r4 = (androidx.compose.runtime.MutableState) r4
            r0.setUpdateFlag(r4)
            androidx.constraintlayout.compose.MotionLayoutDebugFlags r5 = r27.getForcedDrawDebug()
            androidx.constraintlayout.compose.MotionLayoutDebugFlags r6 = androidx.constraintlayout.compose.MotionLayoutDebugFlags.UNKNOWN
            if (r5 == r6) goto L_0x00a6
            androidx.constraintlayout.compose.MotionLayoutDebugFlags r3 = r27.getForcedDrawDebug()
            java.lang.Enum r3 = (java.lang.Enum) r3
            java.util.EnumSet r3 = java.util.EnumSet.of(r3)
            java.lang.String r5 = "of(motionScene.getForcedDrawDebug())"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)
        L_0x00a6:
            java.lang.Object r5 = r4.getValue()
            r17 = r36 & 14
            r6 = -3686552(0xffffffffffc7bf68, float:NaN)
            r13.startReplaceableGroup(r6)
            java.lang.String r11 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r11)
            boolean r18 = r13.changed((java.lang.Object) r0)
            boolean r5 = r13.changed((java.lang.Object) r5)
            r5 = r18 | r5
            java.lang.Object r9 = r35.rememberedValue()
            if (r5 != 0) goto L_0x00cf
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r9 != r5) goto L_0x00d8
        L_0x00cf:
            java.lang.String r5 = "default"
            java.lang.String r9 = r0.getTransition(r5)
            r13.updateRememberedValue(r9)
        L_0x00d8:
            r35.endReplaceableGroup()
            java.lang.String r9 = (java.lang.String) r9
            if (r9 != 0) goto L_0x00ec
            r5 = -488445290(0xffffffffe2e2ea96, float:-2.0929339E21)
            r13.startReplaceableGroup(r5)
            r35.endReplaceableGroup()
            r5 = r14
            androidx.constraintlayout.compose.Transition r5 = (androidx.constraintlayout.compose.Transition) r5
            goto L_0x00f9
        L_0x00ec:
            r5 = -1401229621(0xffffffffac7aeecb, float:-3.5659694E-12)
            r13.startReplaceableGroup(r5)
            androidx.constraintlayout.compose.Transition r5 = Transition(r9, r13, r15)
            r35.endReplaceableGroup()
        L_0x00f9:
            r18 = r5
            if (r18 != 0) goto L_0x0101
            java.lang.String r5 = "start"
            goto L_0x0105
        L_0x0101:
            java.lang.String r5 = r18.getStartConstraintSetId()
        L_0x0105:
            if (r18 != 0) goto L_0x010a
            java.lang.String r9 = "end"
            goto L_0x010e
        L_0x010a:
            java.lang.String r9 = r18.getEndConstraintSetId()
        L_0x010e:
            java.lang.Object r14 = r4.getValue()
            r13.startReplaceableGroup(r6)
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r11)
            boolean r19 = r13.changed((java.lang.Object) r0)
            boolean r14 = r13.changed((java.lang.Object) r14)
            r14 = r19 | r14
            java.lang.Object r6 = r35.rememberedValue()
            if (r14 != 0) goto L_0x0130
            androidx.compose.runtime.Composer$Companion r14 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r14 = r14.getEmpty()
            if (r6 != r14) goto L_0x013e
        L_0x0130:
            java.lang.String r5 = r0.getConstraintSet((java.lang.String) r5)
            if (r5 != 0) goto L_0x013a
            java.lang.String r5 = r0.getConstraintSet((int) r15)
        L_0x013a:
            r6 = r5
            r13.updateRememberedValue(r6)
        L_0x013e:
            r35.endReplaceableGroup()
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r4 = r4.getValue()
            r5 = -3686552(0xffffffffffc7bf68, float:NaN)
            r13.startReplaceableGroup(r5)
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r11)
            boolean r5 = r13.changed((java.lang.Object) r0)
            boolean r4 = r13.changed((java.lang.Object) r4)
            r4 = r4 | r5
            java.lang.Object r5 = r35.rememberedValue()
            r14 = 1
            if (r4 != 0) goto L_0x0168
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r5 != r4) goto L_0x0176
        L_0x0168:
            java.lang.String r4 = r0.getConstraintSet((java.lang.String) r9)
            if (r4 != 0) goto L_0x0172
            java.lang.String r4 = r0.getConstraintSet((int) r14)
        L_0x0172:
            r5 = r4
            r13.updateRememberedValue(r5)
        L_0x0176:
            r35.endReplaceableGroup()
            java.lang.String r5 = (java.lang.String) r5
            r4 = -3686552(0xffffffffffc7bf68, float:NaN)
            r13.startReplaceableGroup(r4)
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r11)
            boolean r4 = r13.changed((java.lang.Object) r0)
            boolean r9 = r13.changed((java.lang.Object) r2)
            r4 = r4 | r9
            java.lang.Object r9 = r35.rememberedValue()
            if (r4 != 0) goto L_0x019b
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r9 != r4) goto L_0x01a7
        L_0x019b:
            if (r2 != 0) goto L_0x019f
            r2 = 0
            goto L_0x01a3
        L_0x019f:
            java.lang.String r2 = r0.getConstraintSet((java.lang.String) r2)
        L_0x01a3:
            r13.updateRememberedValue(r2)
            r9 = r2
        L_0x01a7:
            r35.endReplaceableGroup()
            java.lang.String r9 = (java.lang.String) r9
            if (r6 == 0) goto L_0x05e9
            if (r5 != 0) goto L_0x01b2
            goto L_0x05e9
        L_0x01b2:
            r2 = -3686930(0xffffffffffc7bdee, float:NaN)
            r13.startReplaceableGroup(r2)
            java.lang.String r4 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r4)
            boolean r11 = r13.changed((java.lang.Object) r0)
            java.lang.Object r15 = r35.rememberedValue()
            if (r11 != 0) goto L_0x01cf
            androidx.compose.runtime.Composer$Companion r11 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r11 = r11.getEmpty()
            if (r15 != r11) goto L_0x01dd
        L_0x01cf:
            androidx.constraintlayout.compose.ConstraintSet r6 = androidx.constraintlayout.compose.ConstraintLayoutKt.ConstraintSet((java.lang.String) r6)
            r11 = 2
            r15 = 0
            androidx.compose.runtime.MutableState r6 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r6, r15, r11, r15)
            r13.updateRememberedValue(r6)
            r15 = r6
        L_0x01dd:
            r35.endReplaceableGroup()
            androidx.compose.runtime.MutableState r15 = (androidx.compose.runtime.MutableState) r15
            r13.startReplaceableGroup(r2)
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r4)
            boolean r6 = r13.changed((java.lang.Object) r0)
            java.lang.Object r11 = r35.rememberedValue()
            if (r6 != 0) goto L_0x01fa
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r11 != r6) goto L_0x0208
        L_0x01fa:
            androidx.constraintlayout.compose.ConstraintSet r5 = androidx.constraintlayout.compose.ConstraintLayoutKt.ConstraintSet((java.lang.String) r5)
            r6 = 2
            r11 = 0
            androidx.compose.runtime.MutableState r5 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r5, r11, r6, r11)
            r13.updateRememberedValue(r5)
            r11 = r5
        L_0x0208:
            r35.endReplaceableGroup()
            r20 = r11
            androidx.compose.runtime.MutableState r20 = (androidx.compose.runtime.MutableState) r20
            if (r9 != 0) goto L_0x0213
            r5 = 0
            goto L_0x0217
        L_0x0213:
            androidx.constraintlayout.compose.ConstraintSet r5 = androidx.constraintlayout.compose.ConstraintLayoutKt.ConstraintSet((java.lang.String) r9)
        L_0x0217:
            r6 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r13.startReplaceableGroup(r6)
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r10)
            java.lang.Object r6 = r35.rememberedValue()
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            r11 = 0
            if (r6 != r9) goto L_0x0236
            r9 = 2
            r14 = 0
            androidx.compose.animation.core.Animatable r6 = androidx.compose.animation.core.AnimatableKt.Animatable$default(r11, r11, r9, r14)
            r13.updateRememberedValue(r6)
        L_0x0236:
            r35.endReplaceableGroup()
            r14 = r6
            androidx.compose.animation.core.Animatable r14 = (androidx.compose.animation.core.Animatable) r14
            r13.startReplaceableGroup(r2)
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r4)
            boolean r2 = r13.changed((java.lang.Object) r0)
            java.lang.Object r4 = r35.rememberedValue()
            if (r2 != 0) goto L_0x0257
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r4 != r2) goto L_0x0255
            goto L_0x0257
        L_0x0255:
            r2 = 2
            goto L_0x0265
        L_0x0257:
            r2 = 1
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r2)
            r2 = 2
            r6 = 0
            androidx.compose.runtime.MutableState r4 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r4, r6, r2, r6)
            r13.updateRememberedValue(r4)
        L_0x0265:
            r35.endReplaceableGroup()
            r9 = r4
            androidx.compose.runtime.MutableState r9 = (androidx.compose.runtime.MutableState) r9
            r6 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r13.startReplaceableGroup(r6)
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r10)
            java.lang.Object r4 = r35.rememberedValue()
            androidx.compose.runtime.Composer$Companion r21 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r21.getEmpty()
            if (r4 != r2) goto L_0x028a
            r2 = -1
            r4 = 6
            r6 = 0
            kotlinx.coroutines.channels.Channel r4 = kotlinx.coroutines.channels.ChannelKt.Channel$default(r2, r6, r6, r4, r6)
            r13.updateRememberedValue(r4)
        L_0x028a:
            r35.endReplaceableGroup()
            r2 = r4
            kotlinx.coroutines.channels.Channel r2 = (kotlinx.coroutines.channels.Channel) r2
            if (r5 == 0) goto L_0x02ce
            r4 = -1401228367(0xffffffffac7af3b1, float:-3.5662413E-12)
            r13.startReplaceableGroup(r4)
            androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$1 r4 = new androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$1
            r4.<init>(r2, r5)
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            r5 = 0
            androidx.compose.runtime.EffectsKt.SideEffect(r4, r13, r5)
            androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$2 r21 = new androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$2
            r22 = 0
            r4 = r21
            r5 = r2
            r23 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r6 = r14
            r24 = r10
            r10 = r15
            r28 = r3
            r3 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r23 = 0
            r11 = r20
            r25 = r12
            r12 = r22
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12)
            r4 = r21
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r5 = r17 | 64
            androidx.compose.runtime.EffectsKt.LaunchedEffect(r0, r2, r4, r13, r5)
            r35.endReplaceableGroup()
            goto L_0x02e2
        L_0x02ce:
            r28 = r3
            r24 = r10
            r25 = r12
            r3 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r23 = 0
            r2 = -1401227510(0xffffffffac7af70a, float:-3.566427E-12)
            r13.startReplaceableGroup(r2)
            r35.endReplaceableGroup()
        L_0x02e2:
            r13.startReplaceableGroup(r3)
            r2 = r24
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r2)
            java.lang.Object r4 = r35.rememberedValue()
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r4 != r5) goto L_0x0304
            java.lang.Float r4 = java.lang.Float.valueOf(r23)
            r5 = 2
            r6 = 0
            androidx.compose.runtime.MutableState r4 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r4, r6, r5, r6)
            r13.updateRememberedValue(r4)
            goto L_0x0305
        L_0x0304:
            r5 = 2
        L_0x0305:
            r35.endReplaceableGroup()
            androidx.compose.runtime.MutableState r4 = (androidx.compose.runtime.MutableState) r4
            float r6 = r27.getForcedProgress()
            boolean r7 = java.lang.Float.isNaN(r6)
            if (r7 != 0) goto L_0x0332
            java.lang.Object r7 = r4.getValue()
            java.lang.Number r7 = (java.lang.Number) r7
            float r7 = r7.floatValue()
            java.lang.Object r8 = r14.getValue()
            java.lang.Number r8 = (java.lang.Number) r8
            float r8 = r8.floatValue()
            int r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r7 != 0) goto L_0x032e
            r7 = 1
            goto L_0x032f
        L_0x032e:
            r7 = 0
        L_0x032f:
            if (r7 == 0) goto L_0x0332
            goto L_0x033f
        L_0x0332:
            r27.resetForcedProgress()
            java.lang.Object r6 = r14.getValue()
            java.lang.Number r6 = (java.lang.Number) r6
            float r6 = r6.floatValue()
        L_0x033f:
            java.lang.Object r7 = r14.getValue()
            r4.setValue(r7)
            androidx.constraintlayout.compose.ConstraintSet r7 = m4186MotionLayoutCore$lambda8(r15)
            androidx.constraintlayout.compose.ConstraintSet r8 = m4180MotionLayoutCore$lambda11(r20)
            boolean r4 = r0 instanceof androidx.constraintlayout.compose.JSONMotionScene
            if (r4 == 0) goto L_0x0355
            androidx.constraintlayout.compose.JSONMotionScene r0 = (androidx.constraintlayout.compose.JSONMotionScene) r0
            goto L_0x0356
        L_0x0355:
            r0 = 0
        L_0x0356:
            androidx.constraintlayout.compose.LayoutInformationReceiver r0 = (androidx.constraintlayout.compose.LayoutInformationReceiver) r0
            int r4 = r36 << 6
            r9 = 3670016(0x380000, float:5.142788E-39)
            r10 = r4 & r9
            r11 = 32768(0x8000, float:4.5918E-41)
            r10 = r10 | r11
            r12 = 29360128(0x1c00000, float:7.052966E-38)
            r4 = r4 & r12
            r4 = r4 | r10
            int r10 = r36 << 3
            r14 = 234881024(0xe000000, float:1.5777218E-30)
            r10 = r10 & r14
            r4 = r4 | r10
            r10 = -1330871174(0xffffffffb0ac847a, float:-1.2552299E-9)
            r13.startReplaceableGroup(r10)
            java.lang.String r10 = "C(MotionLayout)P(7,2,8,6,1,3,4,5)"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r10)
            r10 = r4 & 14
            r10 = r10 | r11
            r11 = r4 & 112(0x70, float:1.57E-43)
            r10 = r10 | r11
            r11 = r4 & 896(0x380, float:1.256E-42)
            r10 = r10 | r11
            r11 = r4 & 7168(0x1c00, float:1.0045E-41)
            r10 = r10 | r11
            r11 = 458752(0x70000, float:6.42848E-40)
            r15 = r4 & r11
            r10 = r10 | r15
            r9 = r9 & r4
            r9 = r9 | r10
            r10 = r4 & r12
            r9 = r9 | r10
            r4 = r4 & r14
            r14 = r9 | r4
            r4 = -1401223160(0xffffffffac7b0808, float:-3.5673704E-12)
            r13.startReplaceableGroup(r4)
            r13.startReplaceableGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r2)
            java.lang.Object r4 = r35.rememberedValue()
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r4 != r9) goto L_0x03b0
            androidx.constraintlayout.compose.MotionMeasurer r4 = new androidx.constraintlayout.compose.MotionMeasurer
            r4.<init>()
            r13.updateRememberedValue(r4)
        L_0x03b0:
            r35.endReplaceableGroup()
            r15 = r4
            androidx.constraintlayout.compose.MotionMeasurer r15 = (androidx.constraintlayout.compose.MotionMeasurer) r15
            r13.startReplaceableGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r2)
            java.lang.Object r4 = r35.rememberedValue()
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r4 != r9) goto L_0x03d0
            androidx.constraintlayout.compose.MotionLayoutScope r4 = new androidx.constraintlayout.compose.MotionLayoutScope
            r4.<init>(r15)
            r13.updateRememberedValue(r4)
        L_0x03d0:
            r35.endReplaceableGroup()
            r12 = r4
            androidx.constraintlayout.compose.MotionLayoutScope r12 = (androidx.constraintlayout.compose.MotionLayoutScope) r12
            r13.startReplaceableGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r2)
            java.lang.Object r2 = r35.rememberedValue()
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r2 != r3) goto L_0x03f4
            java.lang.Float r2 = java.lang.Float.valueOf(r23)
            r3 = 0
            androidx.compose.runtime.MutableState r2 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r2, r3, r5, r3)
            r13.updateRememberedValue(r2)
        L_0x03f4:
            r35.endReplaceableGroup()
            r9 = r2
            androidx.compose.runtime.MutableState r9 = (androidx.compose.runtime.MutableState) r9
            androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$7 r2 = new androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$7
            r2.<init>(r9, r6)
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            r3 = 0
            androidx.compose.runtime.EffectsKt.SideEffect(r2, r13, r3)
            r4 = 0
            r2 = 18350528(0x11801c0, float:2.7919246E-38)
            int r3 = r14 >> 21
            r3 = r3 & 14
            r2 = r2 | r3
            int r3 = r14 << 9
            r6 = r3 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | r6
            r6 = 57344(0xe000, float:8.0356E-41)
            r6 = r6 & r3
            r2 = r2 | r6
            r3 = r3 & r11
            r17 = r2 | r3
            r2 = r16
            r11 = r28
            r3 = r11
            r6 = r7
            r7 = r8
            r8 = r18
            r10 = r15
            r26 = r11
            r11 = r35
            r1 = r12
            r12 = r17
            androidx.compose.ui.layout.MeasurePolicy r2 = rememberMotionLayoutMeasurePolicy(r2, r3, r4, r6, r7, r8, r9, r10, r11, r12)
            r15.addLayoutInformationReceiver(r0)
            float r0 = r15.getForcedScaleFactor()
            androidx.constraintlayout.compose.MotionLayoutDebugFlags r3 = androidx.constraintlayout.compose.MotionLayoutDebugFlags.NONE
            r4 = r26
            boolean r3 = r4.contains(r3)
            if (r3 == 0) goto L_0x0487
            boolean r3 = java.lang.Float.isNaN(r0)
            if (r3 != 0) goto L_0x0449
            goto L_0x0487
        L_0x0449:
            r0 = -1401221304(0xffffffffac7b0f48, float:-3.5677728E-12)
            r13.startReplaceableGroup(r0)
            androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$9 r0 = new androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$9
            r0.<init>(r15)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r3 = r25
            r4 = 1
            r5 = 0
            r6 = 0
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r3, r5, r0, r4, r6)
            r3 = -819897795(0xffffffffcf215a3d, float:-2.70704563E9)
            androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$10 r5 = new androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$10
            r6 = r1
            r1 = r34
            r5.<init>(r1, r6, r14)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r13, r3, r4, r5)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r3 = 48
            r4 = 0
            r27 = r0
            r28 = r1
            r29 = r2
            r30 = r35
            r31 = r3
            r32 = r4
            androidx.compose.ui.layout.LayoutKt.MultiMeasureLayout(r27, r28, r29, r30, r31, r32)
            r35.endReplaceableGroup()
            goto L_0x05df
        L_0x0487:
            r6 = r1
            r3 = r25
            r1 = r34
            r5 = -1401222019(0xffffffffac7b0c7d, float:-3.5676178E-12)
            r13.startReplaceableGroup(r5)
            boolean r5 = java.lang.Float.isNaN(r0)
            if (r5 != 0) goto L_0x04a1
            float r5 = r15.getForcedScaleFactor()
            androidx.compose.ui.Modifier r12 = androidx.compose.ui.draw.ScaleKt.scale(r3, r5)
            goto L_0x04a2
        L_0x04a1:
            r12 = r3
        L_0x04a2:
            r3 = -1990474327(0xffffffff895bc5a9, float:-2.6454105E-33)
            r13.startReplaceableGroup(r3)
            java.lang.String r3 = "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r3)
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            androidx.compose.ui.Alignment$Companion r5 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r5 = r5.getTopStart()
            r7 = 0
            androidx.compose.ui.layout.MeasurePolicy r5 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r5, r7, r13, r7)
            r7 = 1376089335(0x520574f7, float:1.43298249E11)
            r13.startReplaceableGroup(r7)
            java.lang.String r7 = "C(Layout)P(!1,2)71@2788L7,72@2843L7,73@2855L389:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r7)
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            r8 = 103361330(0x6292b32, float:3.1817102E-35)
            java.lang.String r9 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r8, r9)
            java.lang.Object r7 = r13.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r35)
            androidx.compose.ui.unit.Density r7 = (androidx.compose.ui.unit.Density) r7
            androidx.compose.runtime.ProvidableCompositionLocal r10 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r10 = (androidx.compose.runtime.CompositionLocal) r10
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r8, r9)
            java.lang.Object r8 = r13.consume(r10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r35)
            androidx.compose.ui.unit.LayoutDirection r8 = (androidx.compose.ui.unit.LayoutDirection) r8
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r9 = r9.getConstructor()
            kotlin.jvm.functions.Function3 r3 = androidx.compose.ui.layout.LayoutKt.materializerOf(r3)
            androidx.compose.runtime.Applier r10 = r35.getApplier()
            boolean r10 = r10 instanceof androidx.compose.runtime.Applier
            if (r10 != 0) goto L_0x0505
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0505:
            r35.startReusableNode()
            boolean r10 = r35.getInserting()
            if (r10 == 0) goto L_0x0512
            r13.createNode(r9)
            goto L_0x0515
        L_0x0512:
            r35.useNode()
        L_0x0515:
            r35.disableReusing()
            androidx.compose.runtime.Composer r9 = androidx.compose.runtime.Updater.m1234constructorimpl(r35)
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r10 = r10.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r9, r5, r10)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetDensity()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r9, r7, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r9, r8, r5)
            r35.enableReusing()
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.SkippableUpdater.m1226constructorimpl(r35)
            androidx.compose.runtime.SkippableUpdater r5 = androidx.compose.runtime.SkippableUpdater.m1225boximpl(r5)
            r7 = 0
            java.lang.Integer r8 = java.lang.Integer.valueOf(r7)
            r3.invoke(r5, r13, r8)
            r3 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r13.startReplaceableGroup(r3)
            r3 = -1253629305(0xffffffffb5472287, float:-7.418352E-7)
            r13.startReplaceableGroup(r3)
            java.lang.String r3 = "C72@3384L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r3)
            androidx.compose.foundation.layout.BoxScopeInstance r3 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r3 = (androidx.compose.foundation.layout.BoxScope) r3
            androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$8$1 r5 = new androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$8$1
            r5.<init>(r15)
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r7 = 1
            r8 = 0
            r9 = 0
            androidx.compose.ui.Modifier r5 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r12, r8, r5, r7, r9)
            r8 = -819897313(0xffffffffcf215c1f, float:-2.70716902E9)
            androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$8$2 r9 = new androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$8$2
            r9.<init>(r1, r6, r14)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r13, r8, r7, r9)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r6 = 48
            r7 = 0
            r27 = r5
            r28 = r1
            r29 = r2
            r30 = r35
            r31 = r6
            r32 = r7
            androidx.compose.ui.layout.LayoutKt.MultiMeasureLayout(r27, r28, r29, r30, r31, r32)
            boolean r1 = java.lang.Float.isNaN(r0)
            if (r1 != 0) goto L_0x05a2
            r1 = -922832858(0xffffffffc8feb026, float:-521601.2)
            r13.startReplaceableGroup(r1)
            r1 = 518(0x206, float:7.26E-43)
            r15.drawDebugBounds(r3, r0, r13, r1)
            r35.endReplaceableGroup()
            goto L_0x05ab
        L_0x05a2:
            r0 = -922832784(0xffffffffc8feb070, float:-521603.5)
            r13.startReplaceableGroup(r0)
            r35.endReplaceableGroup()
        L_0x05ab:
            androidx.constraintlayout.compose.MotionLayoutDebugFlags r0 = androidx.constraintlayout.compose.MotionLayoutDebugFlags.NONE
            boolean r0 = r4.contains(r0)
            if (r0 != 0) goto L_0x05c2
            r0 = -922832717(0xffffffffc8feb0b3, float:-521605.6)
            r13.startReplaceableGroup(r0)
            r0 = 70
            r15.drawDebug(r3, r13, r0)
            r35.endReplaceableGroup()
            goto L_0x05cb
        L_0x05c2:
            r0 = -922832666(0xffffffffc8feb0e6, float:-521607.2)
            r13.startReplaceableGroup(r0)
            r35.endReplaceableGroup()
        L_0x05cb:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r35.endReplaceableGroup()
            r35.endReplaceableGroup()
            r35.endNode()
            r35.endReplaceableGroup()
            r35.endReplaceableGroup()
            r35.endReplaceableGroup()
        L_0x05df:
            r35.endReplaceableGroup()
            r35.endReplaceableGroup()
            r35.endReplaceableGroup()
            return
        L_0x05e9:
            r35.endReplaceableGroup()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore(androidx.constraintlayout.compose.MotionScene, java.lang.String, androidx.compose.animation.core.AnimationSpec, java.util.EnumSet, androidx.compose.ui.Modifier, int, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: MotionLayoutCore$lambda-8  reason: not valid java name */
    public static final ConstraintSet m4186MotionLayoutCore$lambda8(MutableState<ConstraintSet> mutableState) {
        return (ConstraintSet) mutableState.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: MotionLayoutCore$lambda-11  reason: not valid java name */
    public static final ConstraintSet m4180MotionLayoutCore$lambda11(MutableState<ConstraintSet> mutableState) {
        return (ConstraintSet) mutableState.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: MotionLayoutCore$lambda-16  reason: not valid java name */
    public static final boolean m4182MotionLayoutCore$lambda16(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: MotionLayoutCore$lambda-17  reason: not valid java name */
    public static final void m4183MotionLayoutCore$lambda17(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX WARNING: Removed duplicated region for block: B:69:0x01dd  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01ff  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0222  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0232  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0293  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x02d3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void MotionLayoutCore(androidx.constraintlayout.compose.MotionScene r22, float r23, java.util.EnumSet<androidx.constraintlayout.compose.MotionLayoutDebugFlags> r24, androidx.compose.ui.Modifier r25, int r26, kotlin.jvm.functions.Function3<? super androidx.constraintlayout.compose.MotionLayoutScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r27, androidx.compose.runtime.Composer r28, int r29, int r30) {
        /*
            r0 = r22
            r1 = r23
            r2 = r27
            r14 = r28
            r15 = r29
            java.lang.String r3 = "motionScene"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            java.lang.String r3 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            r3 = -1401226724(0xffffffffac7afa1c, float:-3.5665975E-12)
            r14.startReplaceableGroup(r3)
            r3 = r30 & 4
            if (r3 == 0) goto L_0x002d
            androidx.constraintlayout.compose.MotionLayoutDebugFlags r3 = androidx.constraintlayout.compose.MotionLayoutDebugFlags.NONE
            java.lang.Enum r3 = (java.lang.Enum) r3
            java.util.EnumSet r3 = java.util.EnumSet.of(r3)
            java.lang.String r4 = "of(MotionLayoutDebugFlags.NONE)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r13 = r3
            goto L_0x002f
        L_0x002d:
            r13 = r24
        L_0x002f:
            r3 = r30 & 8
            if (r3 == 0) goto L_0x0039
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            r12 = r3
            goto L_0x003b
        L_0x0039:
            r12 = r25
        L_0x003b:
            r3 = r30 & 16
            if (r3 == 0) goto L_0x0042
            r3 = 257(0x101, float:3.6E-43)
            goto L_0x0044
        L_0x0042:
            r3 = r26
        L_0x0044:
            r4 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r14.startReplaceableGroup(r4)
            java.lang.String r5 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r5)
            java.lang.Object r6 = r28.rememberedValue()
            androidx.compose.runtime.Composer$Companion r7 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r7.getEmpty()
            r8 = 2
            r11 = 0
            if (r6 != r7) goto L_0x006a
            r6 = 0
            java.lang.Long r6 = java.lang.Long.valueOf(r6)
            androidx.compose.runtime.MutableState r6 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r6, r11, r8, r11)
            r14.updateRememberedValue(r6)
        L_0x006a:
            r28.endReplaceableGroup()
            androidx.compose.runtime.MutableState r6 = (androidx.compose.runtime.MutableState) r6
            r0.setUpdateFlag(r6)
            androidx.constraintlayout.compose.MotionLayoutDebugFlags r7 = r22.getForcedDrawDebug()
            androidx.constraintlayout.compose.MotionLayoutDebugFlags r9 = androidx.constraintlayout.compose.MotionLayoutDebugFlags.UNKNOWN
            if (r7 == r9) goto L_0x008a
            androidx.constraintlayout.compose.MotionLayoutDebugFlags r7 = r22.getForcedDrawDebug()
            java.lang.Enum r7 = (java.lang.Enum) r7
            java.util.EnumSet r7 = java.util.EnumSet.of(r7)
            java.lang.String r9 = "of(motionScene.getForcedDrawDebug())"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r9)
            goto L_0x008b
        L_0x008a:
            r7 = r13
        L_0x008b:
            java.lang.Object r9 = r6.getValue()
            r10 = -3686552(0xffffffffffc7bf68, float:NaN)
            r14.startReplaceableGroup(r10)
            java.lang.String r8 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r8)
            boolean r16 = r14.changed((java.lang.Object) r0)
            boolean r9 = r14.changed((java.lang.Object) r9)
            r9 = r16 | r9
            java.lang.Object r4 = r28.rememberedValue()
            if (r9 != 0) goto L_0x00b2
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r4 != r9) goto L_0x00bb
        L_0x00b2:
            java.lang.String r4 = "default"
            java.lang.String r4 = r0.getTransition(r4)
            r14.updateRememberedValue(r4)
        L_0x00bb:
            r28.endReplaceableGroup()
            java.lang.String r4 = (java.lang.String) r4
            r9 = 0
            if (r4 != 0) goto L_0x00d0
            r4 = -488329412(0xffffffffe2e4af3c, float:-2.1092423E21)
            r14.startReplaceableGroup(r4)
            r28.endReplaceableGroup()
            r4 = r11
            androidx.constraintlayout.compose.Transition r4 = (androidx.constraintlayout.compose.Transition) r4
            goto L_0x00dd
        L_0x00d0:
            r11 = -1401225883(0xffffffffac7afd65, float:-3.56678E-12)
            r14.startReplaceableGroup(r11)
            androidx.constraintlayout.compose.Transition r4 = Transition(r4, r14, r9)
            r28.endReplaceableGroup()
        L_0x00dd:
            r11 = r4
            if (r11 != 0) goto L_0x00e4
            java.lang.String r4 = "start"
            goto L_0x00e8
        L_0x00e4:
            java.lang.String r4 = r11.getStartConstraintSetId()
        L_0x00e8:
            if (r11 != 0) goto L_0x00ed
            java.lang.String r16 = "end"
            goto L_0x00f1
        L_0x00ed:
            java.lang.String r16 = r11.getEndConstraintSetId()
        L_0x00f1:
            r17 = r16
            java.lang.Object r9 = r6.getValue()
            r14.startReplaceableGroup(r10)
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r8)
            boolean r16 = r14.changed((java.lang.Object) r0)
            boolean r9 = r14.changed((java.lang.Object) r9)
            r9 = r16 | r9
            java.lang.Object r10 = r28.rememberedValue()
            if (r9 != 0) goto L_0x0115
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r10 != r9) goto L_0x0124
        L_0x0115:
            java.lang.String r4 = r0.getConstraintSet((java.lang.String) r4)
            if (r4 != 0) goto L_0x0120
            r9 = 0
            java.lang.String r4 = r0.getConstraintSet((int) r9)
        L_0x0120:
            r10 = r4
            r14.updateRememberedValue(r10)
        L_0x0124:
            r28.endReplaceableGroup()
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r4 = r6.getValue()
            r9 = -3686552(0xffffffffffc7bf68, float:NaN)
            r14.startReplaceableGroup(r9)
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r8)
            boolean r8 = r14.changed((java.lang.Object) r0)
            boolean r4 = r14.changed((java.lang.Object) r4)
            r4 = r4 | r8
            java.lang.Object r8 = r28.rememberedValue()
            r9 = 1
            if (r4 != 0) goto L_0x014e
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r8 != r4) goto L_0x015e
        L_0x014e:
            r4 = r17
            java.lang.String r4 = r0.getConstraintSet((java.lang.String) r4)
            if (r4 != 0) goto L_0x015a
            java.lang.String r4 = r0.getConstraintSet((int) r9)
        L_0x015a:
            r8 = r4
            r14.updateRememberedValue(r8)
        L_0x015e:
            r28.endReplaceableGroup()
            java.lang.String r8 = (java.lang.String) r8
            if (r10 == 0) goto L_0x0432
            if (r8 != 0) goto L_0x0169
            goto L_0x0432
        L_0x0169:
            androidx.constraintlayout.compose.ConstraintSet r10 = androidx.constraintlayout.compose.ConstraintLayoutKt.ConstraintSet((java.lang.String) r10)
            androidx.constraintlayout.compose.ConstraintSet r8 = androidx.constraintlayout.compose.ConstraintLayoutKt.ConstraintSet((java.lang.String) r8)
            r4 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r14.startReplaceableGroup(r4)
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r5)
            java.lang.Object r4 = r28.rememberedValue()
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r16.getEmpty()
            r16 = 0
            if (r4 != r9) goto L_0x0198
            java.lang.Float r4 = java.lang.Float.valueOf(r16)
            r18 = r12
            r9 = 2
            r12 = 0
            androidx.compose.runtime.MutableState r4 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r4, r12, r9, r12)
            r14.updateRememberedValue(r4)
            goto L_0x019a
        L_0x0198:
            r18 = r12
        L_0x019a:
            r28.endReplaceableGroup()
            androidx.compose.runtime.MutableState r4 = (androidx.compose.runtime.MutableState) r4
            float r9 = r22.getForcedProgress()
            kotlin.jvm.internal.Ref$FloatRef r12 = new kotlin.jvm.internal.Ref$FloatRef
            r12.<init>()
            r12.element = r1
            boolean r19 = java.lang.Float.isNaN(r9)
            if (r19 != 0) goto L_0x01c2
            float r19 = m4184MotionLayoutCore$lambda26(r4)
            int r19 = (r19 > r1 ? 1 : (r19 == r1 ? 0 : -1))
            if (r19 != 0) goto L_0x01bb
            r19 = 1
            goto L_0x01bd
        L_0x01bb:
            r19 = 0
        L_0x01bd:
            if (r19 == 0) goto L_0x01c2
            r12.element = r9
            goto L_0x01c5
        L_0x01c2:
            r22.resetForcedProgress()
        L_0x01c5:
            m4185MotionLayoutCore$lambda27(r4, r1)
            r1 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r14.startReplaceableGroup(r1)
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r5)
            java.lang.Object r1 = r28.rememberedValue()
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r1 != r4) goto L_0x01e5
            androidx.constraintlayout.compose.MotionMeasurer r1 = new androidx.constraintlayout.compose.MotionMeasurer
            r1.<init>()
            r14.updateRememberedValue(r1)
        L_0x01e5:
            r28.endReplaceableGroup()
            androidx.constraintlayout.compose.MotionMeasurer r1 = (androidx.constraintlayout.compose.MotionMeasurer) r1
            r4 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r14.startReplaceableGroup(r4)
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r5)
            java.lang.Object r4 = r28.rememberedValue()
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r4 != r9) goto L_0x0207
            androidx.constraintlayout.compose.MotionLayoutScope r4 = new androidx.constraintlayout.compose.MotionLayoutScope
            r4.<init>(r1)
            r14.updateRememberedValue(r4)
        L_0x0207:
            r28.endReplaceableGroup()
            r9 = r4
            androidx.constraintlayout.compose.MotionLayoutScope r9 = (androidx.constraintlayout.compose.MotionLayoutScope) r9
            r4 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r14.startReplaceableGroup(r4)
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r5)
            java.lang.Object r4 = r28.rememberedValue()
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r4 != r5) goto L_0x0232
            java.lang.Float r4 = java.lang.Float.valueOf(r16)
            r24 = r13
            r5 = 2
            r13 = 0
            androidx.compose.runtime.MutableState r4 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r4, r13, r5, r13)
            r14.updateRememberedValue(r4)
            goto L_0x0235
        L_0x0232:
            r24 = r13
            r13 = 0
        L_0x0235:
            r28.endReplaceableGroup()
            r5 = r4
            androidx.compose.runtime.MutableState r5 = (androidx.compose.runtime.MutableState) r5
            androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$3 r4 = new androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$3
            r4.<init>(r5, r12)
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            r12 = 0
            androidx.compose.runtime.EffectsKt.SideEffect(r4, r14, r12)
            java.lang.Object r4 = r6.getValue()
            java.lang.Number r4 = (java.lang.Number) r4
            long r19 = r4.longValue()
            r4 = 18350144(0x1180040, float:2.791817E-38)
            int r6 = r15 >> 12
            r6 = r6 & 14
            r16 = r6 | r4
            r4 = r7
            r21 = r5
            r5 = r19
            r7 = r10
            r12 = r9
            r2 = 0
            r10 = 1
            r9 = r11
            r11 = 1
            r10 = r21
            r2 = r13
            r13 = 1
            r11 = r1
            r15 = r12
            r2 = r18
            r12 = r28
            r23 = r15
            r2 = 1
            r15 = r24
            r13 = r16
            androidx.compose.ui.layout.MeasurePolicy r3 = rememberMotionLayoutMeasurePolicy(r3, r4, r5, r7, r8, r9, r10, r11, r12, r13)
            androidx.constraintlayout.compose.JSONMotionScene r0 = (androidx.constraintlayout.compose.JSONMotionScene) r0
            androidx.constraintlayout.compose.LayoutInformationReceiver r0 = (androidx.constraintlayout.compose.LayoutInformationReceiver) r0
            r1.addLayoutInformationReceiver(r0)
            float r0 = r1.getForcedScaleFactor()
            androidx.constraintlayout.compose.MotionLayoutDebugFlags r4 = androidx.constraintlayout.compose.MotionLayoutDebugFlags.NONE
            boolean r4 = r15.contains(r4)
            if (r4 == 0) goto L_0x02d3
            boolean r4 = java.lang.Float.isNaN(r0)
            if (r4 != 0) goto L_0x0293
            goto L_0x02d3
        L_0x0293:
            r0 = -1401223448(0xffffffffac7b06e8, float:-3.567308E-12)
            r14.startReplaceableGroup(r0)
            androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$5 r0 = new androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$5
            r0.<init>(r1)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r4 = r18
            r1 = 0
            r5 = 0
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r4, r1, r0, r2, r5)
            r1 = -819899683(0xffffffffcf2152dd, float:-2.7065623E9)
            androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$6 r4 = new androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$6
            r7 = r23
            r5 = r27
            r6 = r29
            r4.<init>(r5, r7, r6)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r14, r1, r2, r4)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r2 = 48
            r4 = 0
            r22 = r0
            r23 = r1
            r24 = r3
            r25 = r28
            r26 = r2
            r27 = r4
            androidx.compose.ui.layout.LayoutKt.MultiMeasureLayout(r22, r23, r24, r25, r26, r27)
            r28.endReplaceableGroup()
            goto L_0x042e
        L_0x02d3:
            r7 = r23
            r5 = r27
            r6 = r29
            r4 = r18
            r8 = 0
            r9 = -1401224163(0xffffffffac7b041d, float:-3.5671529E-12)
            r14.startReplaceableGroup(r9)
            boolean r9 = java.lang.Float.isNaN(r0)
            if (r9 != 0) goto L_0x02f1
            float r9 = r1.getForcedScaleFactor()
            androidx.compose.ui.Modifier r12 = androidx.compose.ui.draw.ScaleKt.scale(r4, r9)
            goto L_0x02f2
        L_0x02f1:
            r12 = r4
        L_0x02f2:
            r4 = -1990474327(0xffffffff895bc5a9, float:-2.6454105E-33)
            r14.startReplaceableGroup(r4)
            java.lang.String r4 = "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r4)
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            androidx.compose.ui.Alignment$Companion r9 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r9 = r9.getTopStart()
            androidx.compose.ui.layout.MeasurePolicy r9 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r9, r8, r14, r8)
            r10 = 1376089335(0x520574f7, float:1.43298249E11)
            r14.startReplaceableGroup(r10)
            java.lang.String r10 = "C(Layout)P(!1,2)71@2788L7,72@2843L7,73@2855L389:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r10)
            androidx.compose.runtime.ProvidableCompositionLocal r10 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r10 = (androidx.compose.runtime.CompositionLocal) r10
            r11 = 103361330(0x6292b32, float:3.1817102E-35)
            java.lang.String r13 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r11, r13)
            java.lang.Object r10 = r14.consume(r10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r28)
            androidx.compose.ui.unit.Density r10 = (androidx.compose.ui.unit.Density) r10
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            r2 = r16
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r11, r13)
            java.lang.Object r2 = r14.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r28)
            androidx.compose.ui.unit.LayoutDirection r2 = (androidx.compose.ui.unit.LayoutDirection) r2
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r11 = r11.getConstructor()
            kotlin.jvm.functions.Function3 r4 = androidx.compose.ui.layout.LayoutKt.materializerOf(r4)
            androidx.compose.runtime.Applier r13 = r28.getApplier()
            boolean r13 = r13 instanceof androidx.compose.runtime.Applier
            if (r13 != 0) goto L_0x0356
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0356:
            r28.startReusableNode()
            boolean r13 = r28.getInserting()
            if (r13 == 0) goto L_0x0363
            r14.createNode(r11)
            goto L_0x0366
        L_0x0363:
            r28.useNode()
        L_0x0366:
            r28.disableReusing()
            androidx.compose.runtime.Composer r11 = androidx.compose.runtime.Updater.m1234constructorimpl(r28)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r13 = r13.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r11, r9, r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r9 = r9.getSetDensity()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r11, r10, r9)
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r9 = r9.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r11, r2, r9)
            r28.enableReusing()
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.SkippableUpdater.m1226constructorimpl(r28)
            androidx.compose.runtime.SkippableUpdater r2 = androidx.compose.runtime.SkippableUpdater.m1225boximpl(r2)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r8)
            r4.invoke(r2, r14, r9)
            r2 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r14.startReplaceableGroup(r2)
            r2 = -1253629305(0xffffffffb5472287, float:-7.418352E-7)
            r14.startReplaceableGroup(r2)
            java.lang.String r2 = "C72@3384L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r2)
            androidx.compose.foundation.layout.BoxScopeInstance r2 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r2 = (androidx.compose.foundation.layout.BoxScope) r2
            androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$4$1 r4 = new androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$4$1
            r4.<init>(r1)
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r9 = 1
            r10 = 0
            androidx.compose.ui.Modifier r4 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r12, r8, r4, r9, r10)
            r8 = -819899201(0xffffffffcf2154bf, float:-2.7066857E9)
            androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$4$2 r10 = new androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$4$2
            r10.<init>(r5, r7, r6)
            androidx.compose.runtime.internal.ComposableLambda r5 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r14, r8, r9, r10)
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r6 = 48
            r7 = 0
            r22 = r4
            r23 = r5
            r24 = r3
            r25 = r28
            r26 = r6
            r27 = r7
            androidx.compose.ui.layout.LayoutKt.MultiMeasureLayout(r22, r23, r24, r25, r26, r27)
            boolean r3 = java.lang.Float.isNaN(r0)
            if (r3 != 0) goto L_0x03f1
            r3 = -922835002(0xffffffffc8fea7c6, float:-521534.2)
            r14.startReplaceableGroup(r3)
            r3 = 518(0x206, float:7.26E-43)
            r1.drawDebugBounds(r2, r0, r14, r3)
            r28.endReplaceableGroup()
            goto L_0x03fa
        L_0x03f1:
            r0 = -922834928(0xffffffffc8fea810, float:-521536.5)
            r14.startReplaceableGroup(r0)
            r28.endReplaceableGroup()
        L_0x03fa:
            androidx.constraintlayout.compose.MotionLayoutDebugFlags r0 = androidx.constraintlayout.compose.MotionLayoutDebugFlags.NONE
            boolean r0 = r15.contains(r0)
            if (r0 != 0) goto L_0x0411
            r0 = -922834861(0xffffffffc8fea853, float:-521538.6)
            r14.startReplaceableGroup(r0)
            r0 = 70
            r1.drawDebug(r2, r14, r0)
            r28.endReplaceableGroup()
            goto L_0x041a
        L_0x0411:
            r0 = -922834810(0xffffffffc8fea886, float:-521540.2)
            r14.startReplaceableGroup(r0)
            r28.endReplaceableGroup()
        L_0x041a:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r28.endReplaceableGroup()
            r28.endReplaceableGroup()
            r28.endNode()
            r28.endReplaceableGroup()
            r28.endReplaceableGroup()
            r28.endReplaceableGroup()
        L_0x042e:
            r28.endReplaceableGroup()
            return
        L_0x0432:
            r28.endReplaceableGroup()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore(androidx.constraintlayout.compose.MotionScene, float, java.util.EnumSet, androidx.compose.ui.Modifier, int, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: MotionLayoutCore$lambda-26  reason: not valid java name */
    public static final float m4184MotionLayoutCore$lambda26(MutableState<Float> mutableState) {
        return ((Number) mutableState.getValue()).floatValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: MotionLayoutCore$lambda-27  reason: not valid java name */
    public static final void m4185MotionLayoutCore$lambda27(MutableState<Float> mutableState, float f) {
        mutableState.setValue(Float.valueOf(f));
    }

    public static final void MotionLayoutCore(ConstraintSet constraintSet, ConstraintSet constraintSet2, Transition transition, float f, EnumSet<MotionLayoutDebugFlags> enumSet, LayoutInformationReceiver layoutInformationReceiver, Modifier modifier, int i, Function3<? super MotionLayoutScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i2, int i3) {
        EnumSet<MotionLayoutDebugFlags> enumSet2;
        Composer composer2 = composer;
        int i4 = i2;
        int i5 = i3;
        Intrinsics.checkNotNullParameter(constraintSet, ViewProps.START);
        Intrinsics.checkNotNullParameter(constraintSet2, ViewProps.END);
        Intrinsics.checkNotNullParameter(function3, "content");
        composer2.startReplaceableGroup(-1401223160);
        Transition transition2 = (i5 & 4) != 0 ? null : transition;
        if ((i5 & 16) != 0) {
            EnumSet<MotionLayoutDebugFlags> of = EnumSet.of(MotionLayoutDebugFlags.NONE);
            Intrinsics.checkNotNullExpressionValue(of, "of(MotionLayoutDebugFlags.NONE)");
            enumSet2 = of;
        } else {
            enumSet2 = enumSet;
        }
        LayoutInformationReceiver layoutInformationReceiver2 = (i5 & 32) != 0 ? null : layoutInformationReceiver;
        Modifier modifier2 = (i5 & 64) != 0 ? Modifier.Companion : modifier;
        int i6 = (i5 & 128) != 0 ? 257 : i;
        composer2.startReplaceableGroup(-3687241);
        ComposerKt.sourceInformation(composer2, "C(remember):Composables.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new MotionMeasurer();
            composer2.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        MotionMeasurer motionMeasurer = (MotionMeasurer) rememberedValue;
        composer2.startReplaceableGroup(-3687241);
        ComposerKt.sourceInformation(composer2, "C(remember):Composables.kt#9igjgp");
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new MotionLayoutScope(motionMeasurer);
            composer2.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        MotionLayoutScope motionLayoutScope = (MotionLayoutScope) rememberedValue2;
        composer2.startReplaceableGroup(-3687241);
        ComposerKt.sourceInformation(composer2, "C(remember):Composables.kt#9igjgp");
        Object rememberedValue3 = composer.rememberedValue();
        if (rememberedValue3 == Composer.Companion.getEmpty()) {
            rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), (SnapshotMutationPolicy) null, 2, (Object) null);
            composer2.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) rememberedValue3;
        EffectsKt.SideEffect(new MotionLayoutKt$MotionLayoutCore$7(mutableState, f), composer2, 0);
        int i7 = i4 << 9;
        MotionLayoutScope motionLayoutScope2 = motionLayoutScope;
        Modifier modifier3 = modifier2;
        MeasurePolicy rememberMotionLayoutMeasurePolicy = rememberMotionLayoutMeasurePolicy(i6, enumSet2, 0, constraintSet, constraintSet2, transition2, mutableState, motionMeasurer, composer, ((i4 >> 21) & 14) | 18350528 | (i7 & 7168) | (57344 & i7) | (i7 & Opcodes.ASM7));
        MotionMeasurer motionMeasurer2 = motionMeasurer;
        motionMeasurer2.addLayoutInformationReceiver(layoutInformationReceiver2);
        float forcedScaleFactor = motionMeasurer2.getForcedScaleFactor();
        if (!enumSet2.contains(MotionLayoutDebugFlags.NONE) || !Float.isNaN(forcedScaleFactor)) {
            Function3<? super MotionLayoutScope, ? super Composer, ? super Integer, Unit> function32 = function3;
            int i8 = i2;
            MotionLayoutScope motionLayoutScope3 = motionLayoutScope2;
            composer2.startReplaceableGroup(-1401222019);
            Modifier scale = !Float.isNaN(forcedScaleFactor) ? ScaleKt.scale(modifier3, motionMeasurer2.getForcedScaleFactor()) : modifier3;
            composer2.startReplaceableGroup(-1990474327);
            ComposerKt.sourceInformation(composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composer2, 0);
            composer2.startReplaceableGroup(1376089335);
            ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)71@2788L7,72@2843L7,73@2855L389:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(composer2, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume = composer2.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(composer);
            Density density = (Density) consume;
            ComposerKt.sourceInformationMarkerStart(composer2, 103361330, "C:CompositionLocal.kt#9igjgp");
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
            Composer r13 = Updater.m1234constructorimpl(composer);
            Updater.m1241setimpl(r13, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1241setimpl(r13, density, ComposeUiNode.Companion.getSetDensity());
            Updater.m1241setimpl(r13, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
            composer.enableReusing();
            materializerOf.invoke(SkippableUpdater.m1225boximpl(SkippableUpdater.m1226constructorimpl(composer)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            composer2.startReplaceableGroup(-1253629305);
            ComposerKt.sourceInformation(composer2, "C72@3384L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            LayoutKt.MultiMeasureLayout(SemanticsModifierKt.semantics$default(scale, false, new MotionLayoutKt$MotionLayoutCore$8$1(motionMeasurer2), 1, (Object) null), ComposableLambdaKt.composableLambda(composer2, -819897313, true, new MotionLayoutKt$MotionLayoutCore$8$2(function32, motionLayoutScope3, i8)), rememberMotionLayoutMeasurePolicy, composer, 48, 0);
            if (!Float.isNaN(forcedScaleFactor)) {
                composer2.startReplaceableGroup(-922832858);
                motionMeasurer2.drawDebugBounds(boxScope, forcedScaleFactor, composer2, 518);
                composer.endReplaceableGroup();
            } else {
                composer2.startReplaceableGroup(-922832784);
                composer.endReplaceableGroup();
            }
            if (!enumSet2.contains(MotionLayoutDebugFlags.NONE)) {
                composer2.startReplaceableGroup(-922832717);
                motionMeasurer2.drawDebug(boxScope, composer2, 70);
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
            LayoutKt.MultiMeasureLayout(SemanticsModifierKt.semantics$default(modifier3, false, new MotionLayoutKt$MotionLayoutCore$9(motionMeasurer2), 1, (Object) null), ComposableLambdaKt.composableLambda(composer2, -819897795, true, new MotionLayoutKt$MotionLayoutCore$10(function3, motionLayoutScope2, i2)), rememberMotionLayoutMeasurePolicy, composer, 48, 0);
            composer.endReplaceableGroup();
        }
        composer.endReplaceableGroup();
    }

    public static final MotionScene MotionScene(String str, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(str, "content");
        composer.startReplaceableGroup(1405666242);
        ComposerKt.sourceInformation(composer, "C(MotionScene)");
        composer.startReplaceableGroup(-3686930);
        ComposerKt.sourceInformation(composer, "C(remember)P(1):Composables.kt#9igjgp");
        boolean changed = composer.changed((Object) str);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new JSONMotionScene(str);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return (JSONMotionScene) rememberedValue;
    }

    public static final Transition Transition(String str, Composer composer, int i) {
        CLObject cLObject;
        MotionLayoutKt$Transition$transition$1$1 motionLayoutKt$Transition$transition$1$1;
        Intrinsics.checkNotNullParameter(str, "content");
        composer.startReplaceableGroup(811760657);
        ComposerKt.sourceInformation(composer, "C(Transition)");
        composer.startReplaceableGroup(-3686930);
        ComposerKt.sourceInformation(composer, "C(remember)P(1):Composables.kt#9igjgp");
        boolean changed = composer.changed((Object) str);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            try {
                cLObject = CLParser.parse(str);
            } catch (CLParsingException e) {
                System.err.println(Intrinsics.stringPlus("Error parsing JSON ", e));
                cLObject = null;
            }
            if (cLObject != null) {
                motionLayoutKt$Transition$transition$1$1 = new MotionLayoutKt$Transition$transition$1$1(cLObject);
            } else {
                motionLayoutKt$Transition$transition$1$1 = null;
            }
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(motionLayoutKt$Transition$transition$1$1, (SnapshotMutationPolicy) null, 2, (Object) null);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return (MotionLayoutKt$Transition$transition$1$1) ((MutableState) rememberedValue).getValue();
    }

    public static final MeasurePolicy rememberMotionLayoutMeasurePolicy(int i, EnumSet<MotionLayoutDebugFlags> enumSet, long j, ConstraintSet constraintSet, ConstraintSet constraintSet2, Transition transition, MutableState<Float> mutableState, MotionMeasurer motionMeasurer, Composer composer, int i2) {
        ConstraintSet constraintSet3 = constraintSet2;
        Transition transition2 = transition;
        MotionMeasurer motionMeasurer2 = motionMeasurer;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(enumSet, "debug");
        Intrinsics.checkNotNullParameter(constraintSet, "constraintSetStart");
        Intrinsics.checkNotNullParameter(constraintSet3, "constraintSetEnd");
        Intrinsics.checkNotNullParameter(mutableState, "progress");
        Intrinsics.checkNotNullParameter(motionMeasurer2, "measurer");
        composer2.startReplaceableGroup(-1875583928);
        int i3 = 0;
        Object[] objArr = {Integer.valueOf(i), enumSet, Long.valueOf(j), constraintSet, constraintSet3, transition2};
        composer2.startReplaceableGroup(-3685570);
        ComposerKt.sourceInformation(composer2, "C(remember)P(1):Composables.kt#9igjgp");
        boolean z = false;
        while (i3 < 6) {
            Object obj = objArr[i3];
            i3++;
            z |= composer2.changed(obj);
        }
        Object rememberedValue = composer.rememberedValue();
        if (z || rememberedValue == Composer.Companion.getEmpty()) {
            motionMeasurer2.initWith(constraintSet, constraintSet3, transition2, mutableState.getValue().floatValue());
            rememberedValue = new MotionLayoutKt$rememberMotionLayoutMeasurePolicy$1$1(motionMeasurer, constraintSet, constraintSet2, transition, i, mutableState);
            composer2.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue;
        composer.endReplaceableGroup();
        return measurePolicy;
    }

    /* access modifiers changed from: private */
    /* renamed from: MotionLayoutCore$lambda-9  reason: not valid java name */
    public static final void m4187MotionLayoutCore$lambda9(MutableState<ConstraintSet> mutableState, ConstraintSet constraintSet) {
        mutableState.setValue(constraintSet);
    }

    /* access modifiers changed from: private */
    /* renamed from: MotionLayoutCore$lambda-12  reason: not valid java name */
    public static final void m4181MotionLayoutCore$lambda12(MutableState<ConstraintSet> mutableState, ConstraintSet constraintSet) {
        mutableState.setValue(constraintSet);
    }
}
