package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.semantics.Role;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Clickable.kt */
final class ClickableKt$combinedClickable$4 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Indication $indication;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ Function0<Unit> $onClick;
    final /* synthetic */ String $onClickLabel;
    final /* synthetic */ Function0<Unit> $onDoubleClick;
    final /* synthetic */ Function0<Unit> $onLongClick;
    final /* synthetic */ String $onLongClickLabel;
    final /* synthetic */ Role $role;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ClickableKt$combinedClickable$4(Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03, boolean z, MutableInteractionSource mutableInteractionSource, Indication indication, String str, Role role, String str2) {
        super(3);
        this.$onClick = function0;
        this.$onLongClick = function02;
        this.$onDoubleClick = function03;
        this.$enabled = z;
        this.$interactionSource = mutableInteractionSource;
        this.$indication = indication;
        this.$onClickLabel = str;
        this.$role = role;
        this.$onLongClickLabel = str2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    public final Modifier invoke(Modifier modifier, Composer composer, int i) {
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer2.startReplaceableGroup(1321106475);
        ComposerKt.sourceInformation(composer2, "C290@12266L29,291@12327L33,292@12394L35,295@12561L58,310@13323L36,311@13407L33,312@13477L116,343@14729L445:Clickable.kt#71ulvw");
        State<T> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(this.$onClick, composer2, 0);
        State<T> rememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(this.$onLongClick, composer2, 0);
        State<T> rememberUpdatedState3 = SnapshotStateKt.rememberUpdatedState(this.$onDoubleClick, composer2, 0);
        boolean z = this.$onLongClick != null;
        boolean z2 = this.$onDoubleClick != null;
        composer2.startReplaceableGroup(-3687241);
        ComposerKt.sourceInformation(composer2, "C(remember):Composables.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
            composer2.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        final MutableState mutableState = (MutableState) rememberedValue;
        composer2.startReplaceableGroup(1321106866);
        ComposerKt.sourceInformation(composer2, "299@12805L373,308@13191L79");
        if (this.$enabled) {
            Boolean valueOf = Boolean.valueOf(z);
            final MutableInteractionSource mutableInteractionSource = this.$interactionSource;
            EffectsKt.DisposableEffect((Object) valueOf, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) new Function1<DisposableEffectScope, DisposableEffectResult>() {
                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                    Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
                    return new ClickableKt$combinedClickable$4$1$invoke$$inlined$onDispose$1(mutableState, mutableInteractionSource);
                }
            }, composer2, 0);
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
        MutableState mutableState3 = mutableState2;
        Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion, new Object[]{this.$interactionSource, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(this.$enabled)}, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new ClickableKt$combinedClickable$4$gesture$1(z2, this.$enabled, z, rememberUpdatedState3, rememberUpdatedState2, this.$interactionSource, mutableState, SnapshotStateKt.rememberUpdatedState(new ClickableKt$combinedClickable$4$delayPressInteraction$1(mutableState2, isComposeRootInScrollableContainer), composer2, 0), rememberUpdatedState, (Continuation<? super ClickableKt$combinedClickable$4$gesture$1>) null));
        Modifier.Companion companion = Modifier.Companion;
        composer2.startReplaceableGroup(-3687241);
        ComposerKt.sourceInformation(composer2, "C(remember):Composables.kt#9igjgp");
        Object rememberedValue3 = composer.rememberedValue();
        if (rememberedValue3 == Composer.Companion.getEmpty()) {
            rememberedValue3 = new ClickableKt$combinedClickable$4$2$1(mutableState3);
            composer2.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceableGroup();
        Modifier then = companion.then((Modifier) rememberedValue3);
        Modifier r2 = ClickableKt.m185genericClickableWithoutGestureBILeDI(then, pointerInput, this.$interactionSource, this.$indication, this.$enabled, this.$onClickLabel, this.$role, this.$onLongClickLabel, this.$onLongClick, this.$onClick);
        composer.endReplaceableGroup();
        return r2;
    }
}
