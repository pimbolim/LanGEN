package androidx.compose.foundation;

import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H\u0001¢\u0006\u0002\u0010\u0007\u001aW\u0010\b\u001a\u00020\t*\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u0013ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\u0014\u001aE\u0010\b\u001a\u00020\t*\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u0013ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\u0015\u001a\u0001\u0010\u0016\u001a\u00020\t*\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000f2\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00132\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00132\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u0013H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\u001a\u001aw\u0010\u0016\u001a\u00020\t*\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000f2\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00132\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00132\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u0013H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\u001b\u001a\u0010\u001c\u001a\u00020\t*\u00020\t2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000f2\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00132\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u0013H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\u001e\u001aQ\u0010\u001f\u001a\u00020\u0001*\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0012\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00130$H@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b%\u0010&\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006'"}, d2 = {"PressedInteractionSourceDisposableEffect", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "pressedInteraction", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/Composer;I)V", "clickable", "Landroidx/compose/ui/Modifier;", "indication", "Landroidx/compose/foundation/Indication;", "enabled", "", "onClickLabel", "", "role", "Landroidx/compose/ui/semantics/Role;", "onClick", "Lkotlin/Function0;", "clickable-O2vRcR0", "clickable-XHw0xAI", "combinedClickable", "onLongClickLabel", "onLongClick", "onDoubleClick", "combinedClickable-XVZzFYc", "combinedClickable-cJG_KMw", "genericClickableWithoutGesture", "gestureModifiers", "genericClickableWithoutGesture-BI-LeDI", "handlePressInteraction", "Landroidx/compose/foundation/gestures/PressGestureScope;", "pressPoint", "Landroidx/compose/ui/geometry/Offset;", "delayPressInteraction", "Landroidx/compose/runtime/State;", "handlePressInteraction-EPk0efs", "(Landroidx/compose/foundation/gestures/PressGestureScope;JLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/State;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Clickable.kt */
public final class ClickableKt {
    /* renamed from: clickable-XHw0xAI$default  reason: not valid java name */
    public static /* synthetic */ Modifier m180clickableXHw0xAI$default(Modifier modifier, boolean z, String str, Role role, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            role = null;
        }
        return m179clickableXHw0xAI(modifier, z, str, role, function0);
    }

    /* renamed from: clickable-O2vRcR0$default  reason: not valid java name */
    public static /* synthetic */ Modifier m178clickableO2vRcR0$default(Modifier modifier, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z, String str, Role role, Function0 function0, int i, Object obj) {
        return m177clickableO2vRcR0(modifier, mutableInteractionSource, indication, (i & 4) != 0 ? true : z, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : role, function0);
    }

    /* renamed from: combinedClickable-cJG_KMw$default  reason: not valid java name */
    public static /* synthetic */ Modifier m184combinedClickablecJG_KMw$default(Modifier modifier, boolean z, String str, Role role, String str2, Function0 function0, Function0 function02, Function0 function03, int i, Object obj) {
        return m183combinedClickablecJG_KMw(modifier, (i & 1) != 0 ? true : z, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : role, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : function0, (i & 32) != 0 ? null : function02, function03);
    }

    /* renamed from: combinedClickable-XVZzFYc$default  reason: not valid java name */
    public static /* synthetic */ Modifier m182combinedClickableXVZzFYc$default(Modifier modifier, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z, String str, Role role, String str2, Function0 function0, Function0 function02, Function0 function03, int i, Object obj) {
        int i2 = i;
        return m181combinedClickableXVZzFYc(modifier, mutableInteractionSource, indication, (i2 & 4) != 0 ? true : z, (i2 & 8) != 0 ? null : str, (i2 & 16) != 0 ? null : role, (i2 & 32) != 0 ? null : str2, (i2 & 64) != 0 ? null : function0, (i2 & 128) != 0 ? null : function02, function03);
    }

    public static final void PressedInteractionSourceDisposableEffect(MutableInteractionSource mutableInteractionSource, MutableState<PressInteraction.Press> mutableState, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(mutableInteractionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(mutableState, "pressedInteraction");
        Composer startRestartGroup = composer.startRestartGroup(1115975634);
        ComposerKt.sourceInformation(startRestartGroup, "C(PressedInteractionSourceDisposableEffect)385@16369L278,385@16333L314:Clickable.kt#71ulvw");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed((Object) mutableInteractionSource) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changed((Object) mutableState) ? 32 : 16;
        }
        if (((i2 & 91) ^ 18) != 0 || !startRestartGroup.getSkipping()) {
            startRestartGroup.startReplaceableGroup(-3686552);
            ComposerKt.sourceInformation(startRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
            boolean changed = startRestartGroup.changed((Object) mutableState) | startRestartGroup.changed((Object) mutableInteractionSource);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new ClickableKt$PressedInteractionSourceDisposableEffect$1$1(mutableState, mutableInteractionSource);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            EffectsKt.DisposableEffect((Object) mutableInteractionSource, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) (Function1) rememberedValue, startRestartGroup, i2 & 14);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ClickableKt$PressedInteractionSourceDisposableEffect$2(mutableInteractionSource, mutableState, i));
        }
    }

    /* renamed from: handlePressInteraction-EPk0efs  reason: not valid java name */
    public static final Object m187handlePressInteractionEPk0efs(PressGestureScope pressGestureScope, long j, MutableInteractionSource mutableInteractionSource, MutableState<PressInteraction.Press> mutableState, State<? extends Function0<Boolean>> state, Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new ClickableKt$handlePressInteraction$2(pressGestureScope, j, mutableInteractionSource, mutableState, state, (Continuation<? super ClickableKt$handlePressInteraction$2>) null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    /* renamed from: genericClickableWithoutGesture-BI-LeDI$default  reason: not valid java name */
    public static /* synthetic */ Modifier m186genericClickableWithoutGestureBILeDI$default(Modifier modifier, Modifier modifier2, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z, String str, Role role, String str2, Function0 function0, Function0 function02, int i, Object obj) {
        int i2 = i;
        return m185genericClickableWithoutGestureBILeDI(modifier, modifier2, mutableInteractionSource, indication, (i2 & 8) != 0 ? true : z, (i2 & 16) != 0 ? null : str, (i2 & 32) != 0 ? null : role, (i2 & 64) != 0 ? null : str2, (i2 & 128) != 0 ? null : function0, function02);
    }

    private static final Modifier genericClickableWithoutGesture_BI_LeDI$clickSemantics(Modifier modifier, Role role, String str, Function0<Unit> function0, String str2, boolean z, Function0<Unit> function02) {
        return SemanticsModifierKt.semantics(modifier, true, new ClickableKt$genericClickableWithoutGesture$clickSemantics$1(role, str, function0, str2, z, function02));
    }

    private static final Modifier genericClickableWithoutGesture_BI_LeDI$detectClickFromKey(Modifier modifier, boolean z, Function0<Unit> function0) {
        return KeyInputModifierKt.onKeyEvent(modifier, new ClickableKt$genericClickableWithoutGesture$detectClickFromKey$1(z, function0));
    }

    /* renamed from: genericClickableWithoutGesture-BI-LeDI  reason: not valid java name */
    public static final Modifier m185genericClickableWithoutGestureBILeDI(Modifier modifier, Modifier modifier2, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z, String str, Role role, String str2, Function0<Unit> function0, Function0<Unit> function02) {
        Modifier modifier3 = modifier2;
        boolean z2 = z;
        Function0<Unit> function03 = function02;
        Modifier modifier4 = modifier;
        Intrinsics.checkNotNullParameter(modifier, "$this$genericClickableWithoutGesture");
        Intrinsics.checkNotNullParameter(modifier2, "gestureModifiers");
        Intrinsics.checkNotNullParameter(mutableInteractionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(function03, "onClick");
        Indication indication2 = indication;
        return FocusableKt.focusableInNonTouchMode(HoverableKt.hoverable(IndicationKt.indication(genericClickableWithoutGesture_BI_LeDI$detectClickFromKey(genericClickableWithoutGesture_BI_LeDI$clickSemantics(modifier, role, str, function0, str2, z, function02), z, function03), mutableInteractionSource, indication), mutableInteractionSource, z), z, mutableInteractionSource).then(modifier2);
    }

    /* renamed from: clickable-XHw0xAI  reason: not valid java name */
    public static final Modifier m179clickableXHw0xAI(Modifier modifier, boolean z, String str, Role role, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(modifier, "$this$clickable");
        Intrinsics.checkNotNullParameter(function0, "onClick");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ClickableKt$clickableXHw0xAI$$inlined$debugInspectorInfo$1(z, str, role, function0) : InspectableValueKt.getNoInspectorInfo(), new ClickableKt$clickable$2(z, str, role, function0));
    }

    /* renamed from: clickable-O2vRcR0  reason: not valid java name */
    public static final Modifier m177clickableO2vRcR0(Modifier modifier, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z, String str, Role role, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(modifier, "$this$clickable");
        Intrinsics.checkNotNullParameter(mutableInteractionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(function0, "onClick");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ClickableKt$clickableO2vRcR0$$inlined$debugInspectorInfo$1(z, str, role, function0, indication, mutableInteractionSource) : InspectableValueKt.getNoInspectorInfo(), new ClickableKt$clickable$4(function0, z, mutableInteractionSource, indication, str, role));
    }

    @ExperimentalFoundationApi
    /* renamed from: combinedClickable-cJG_KMw  reason: not valid java name */
    public static final Modifier m183combinedClickablecJG_KMw(Modifier modifier, boolean z, String str, Role role, String str2, Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03) {
        Modifier modifier2 = modifier;
        Intrinsics.checkNotNullParameter(modifier, "$this$combinedClickable");
        Intrinsics.checkNotNullParameter(function03, "onClick");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ClickableKt$combinedClickablecJG_KMw$$inlined$debugInspectorInfo$1(z, str, role, function03, function02, function0, str2) : InspectableValueKt.getNoInspectorInfo(), new ClickableKt$combinedClickable$2(z, str, role, str2, function0, function02, function03));
    }

    @ExperimentalFoundationApi
    /* renamed from: combinedClickable-XVZzFYc  reason: not valid java name */
    public static final Modifier m181combinedClickableXVZzFYc(Modifier modifier, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z, String str, Role role, String str2, Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03) {
        Modifier modifier2 = modifier;
        Intrinsics.checkNotNullParameter(modifier, "$this$combinedClickable");
        Intrinsics.checkNotNullParameter(mutableInteractionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(function03, "onClick");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ClickableKt$combinedClickableXVZzFYc$$inlined$debugInspectorInfo$1(z, str, role, function03, function02, function0, str2, indication, mutableInteractionSource) : InspectableValueKt.getNoInspectorInfo(), new ClickableKt$combinedClickable$4(function03, function0, function02, z, mutableInteractionSource, indication, str, role, str2));
    }
}
