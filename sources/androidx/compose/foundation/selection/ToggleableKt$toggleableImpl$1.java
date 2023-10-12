package androidx.compose.foundation.selection;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Clickable_androidKt;
import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.HoverableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.state.ToggleableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Toggleable.kt */
final class ToggleableKt$toggleableImpl$1 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Indication $indication;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ Function0<Unit> $onClick;
    final /* synthetic */ Role $role;
    final /* synthetic */ ToggleableState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ToggleableKt$toggleableImpl$1(Function0<Unit> function0, boolean z, MutableInteractionSource mutableInteractionSource, Indication indication, Role role, ToggleableState toggleableState) {
        super(3);
        this.$onClick = function0;
        this.$enabled = z;
        this.$interactionSource = mutableInteractionSource;
        this.$indication = indication;
        this.$role = role;
        this.$state = toggleableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    public final Modifier invoke(Modifier modifier, Composer composer, int i) {
        Modifier modifier2 = modifier;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(modifier2, "$this$composed");
        composer2.startReplaceableGroup(-2134919645);
        ComposerKt.sourceInformation(composer2, "C246@9835L58,259@10255L29,263@10436L36,264@10517L33,265@10583L109,285@11237L410:Toggleable.kt#gro6r2");
        composer2.startReplaceableGroup(-3687241);
        ComposerKt.sourceInformation(composer2, "C(remember):Composables.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
            composer2.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) rememberedValue;
        Modifier semantics = SemanticsModifierKt.semantics(Modifier.Companion, true, new ToggleableKt$toggleableImpl$1$semantics$1(this.$role, this.$state, this.$enabled, this.$onClick));
        State<T> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(this.$onClick, composer2, 0);
        composer2.startReplaceableGroup(-2134919160);
        ComposerKt.sourceInformation(composer2, "261@10312L79");
        if (this.$enabled) {
            ClickableKt.PressedInteractionSourceDisposableEffect(this.$interactionSource, mutableState, composer2, 48);
        }
        composer.endReplaceableGroup();
        Function0<Boolean> isComposeRootInScrollableContainer = Clickable_androidKt.isComposeRootInScrollableContainer(composer2, 0);
        composer2.startReplaceableGroup(-3687241);
        ComposerKt.sourceInformation(composer2, "C(remember):Composables.kt#9igjgp");
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, (SnapshotMutationPolicy) null, 2, (Object) null);
            composer2.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        MutableState mutableState2 = (MutableState) rememberedValue2;
        State rememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(new ToggleableKt$toggleableImpl$1$delayPressInteraction$1(mutableState2, isComposeRootInScrollableContainer), composer2, 0);
        Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion, this.$interactionSource, Boolean.valueOf(this.$enabled), new ToggleableKt$toggleableImpl$1$gestures$1(this.$enabled, this.$interactionSource, mutableState, rememberUpdatedState2, rememberUpdatedState, (Continuation<? super ToggleableKt$toggleableImpl$1$gestures$1>) null));
        composer2.startReplaceableGroup(-3687241);
        ComposerKt.sourceInformation(composer2, "C(remember):Composables.kt#9igjgp");
        Object rememberedValue3 = composer.rememberedValue();
        if (rememberedValue3 == Composer.Companion.getEmpty()) {
            rememberedValue3 = new ToggleableKt$toggleableImpl$1$1$1(mutableState2);
            composer2.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceableGroup();
        Modifier then = FocusableKt.focusableInNonTouchMode(HoverableKt.hoverable(IndicationKt.indication(modifier2.then((Modifier) rememberedValue3).then(semantics), this.$interactionSource, this.$indication), this.$interactionSource, this.$enabled), this.$enabled, this.$interactionSource).then(pointerInput);
        composer.endReplaceableGroup();
        return then;
    }
}
