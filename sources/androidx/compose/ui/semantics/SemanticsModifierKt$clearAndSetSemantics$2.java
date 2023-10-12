package androidx.compose.ui.semantics;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SemanticsModifier.kt */
final class SemanticsModifierKt$clearAndSetSemantics$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ Function1<SemanticsPropertyReceiver, Unit> $properties;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SemanticsModifierKt$clearAndSetSemantics$2(Function1<? super SemanticsPropertyReceiver, Unit> function1) {
        super(3);
        this.$properties = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    public final Modifier invoke(Modifier modifier, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer.startReplaceableGroup(-852248145);
        ComposerKt.sourceInformation(composer, "C143@5932L56:SemanticsModifier.kt#x0n4us");
        composer.startReplaceableGroup(-3687241);
        ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = Integer.valueOf(SemanticsModifierCore.Companion.generateSemanticsId());
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        SemanticsModifierCore semanticsModifierCore = new SemanticsModifierCore(((Number) rememberedValue).intValue(), false, true, this.$properties);
        composer.endReplaceableGroup();
        return semanticsModifierCore;
    }
}
