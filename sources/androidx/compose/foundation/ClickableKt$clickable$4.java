package androidx.compose.foundation;

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
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Clickable.kt */
final class ClickableKt$clickable$4 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Indication $indication;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ Function0<Unit> $onClick;
    final /* synthetic */ String $onClickLabel;
    final /* synthetic */ Role $role;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ClickableKt$clickable$4(Function0<Unit> function0, boolean z, MutableInteractionSource mutableInteractionSource, Indication indication, String str, Role role) {
        super(3);
        this.$onClick = function0;
        this.$enabled = z;
        this.$interactionSource = mutableInteractionSource;
        this.$indication = indication;
        this.$onClickLabel = str;
        this.$role = role;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    public final Modifier invoke(Modifier modifier, Composer composer, int i) {
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer2.startReplaceableGroup(1841981045);
        ComposerKt.sourceInformation(composer2, "C130@5529L29,131@5592L58,135@5818L36,136@5902L33,137@5972L116,157@6708L445:Clickable.kt#71ulvw");
        State<T> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(this.$onClick, composer2, 0);
        composer2.startReplaceableGroup(-3687241);
        ComposerKt.sourceInformation(composer2, "C(remember):Composables.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
            composer2.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) rememberedValue;
        composer2.startReplaceableGroup(1841981204);
        ComposerKt.sourceInformation(composer2, "133@5686L79");
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
        Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion, this.$interactionSource, Boolean.valueOf(this.$enabled), new ClickableKt$clickable$4$gesture$1(this.$enabled, this.$interactionSource, mutableState, SnapshotStateKt.rememberUpdatedState(new ClickableKt$clickable$4$delayPressInteraction$1(mutableState2, isComposeRootInScrollableContainer), composer2, 0), rememberUpdatedState, (Continuation<? super ClickableKt$clickable$4$gesture$1>) null));
        Modifier.Companion companion = Modifier.Companion;
        composer2.startReplaceableGroup(-3687241);
        ComposerKt.sourceInformation(composer2, "C(remember):Composables.kt#9igjgp");
        Object rememberedValue3 = composer.rememberedValue();
        if (rememberedValue3 == Composer.Companion.getEmpty()) {
            rememberedValue3 = new ClickableKt$clickable$4$1$1(mutableState2);
            composer2.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceableGroup();
        Modifier r2 = ClickableKt.m185genericClickableWithoutGestureBILeDI(companion.then((Modifier) rememberedValue3), pointerInput, this.$interactionSource, this.$indication, this.$enabled, this.$onClickLabel, this.$role, (String) null, (Function0<Unit>) null, this.$onClick);
        composer.endReplaceableGroup();
        return r2;
    }
}
