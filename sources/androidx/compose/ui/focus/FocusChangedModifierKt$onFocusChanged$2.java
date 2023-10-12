package androidx.compose.ui.focus;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FocusChangedModifier.kt */
final class FocusChangedModifierKt$onFocusChanged$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ Function1<FocusState, Unit> $onFocusChanged;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FocusChangedModifierKt$onFocusChanged$2(Function1<? super FocusState, Unit> function1) {
        super(3);
        this.$onFocusChanged = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    public final Modifier invoke(Modifier modifier, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer.startReplaceableGroup(-610209312);
        ComposerKt.sourceInformation(composer, "C42@1663L33:FocusChangedModifier.kt#b42af3");
        composer.startReplaceableGroup(-3687241);
        ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        final MutableState mutableState = (MutableState) rememberedValue;
        final Function1<FocusState, Unit> function1 = this.$onFocusChanged;
        Modifier onFocusEvent = FocusEventModifierKt.onFocusEvent(Modifier.Companion, new Function1<FocusState, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((FocusState) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(FocusState focusState) {
                Intrinsics.checkNotNullParameter(focusState, "it");
                if (!Intrinsics.areEqual((Object) mutableState.getValue(), (Object) focusState)) {
                    mutableState.setValue(focusState);
                    function1.invoke(focusState);
                }
            }
        });
        composer.endReplaceableGroup();
        return onFocusEvent;
    }
}
