package androidx.compose.foundation;

import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.Role;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Clickable.kt */
final class ClickableKt$clickable$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Function0<Unit> $onClick;
    final /* synthetic */ String $onClickLabel;
    final /* synthetic */ Role $role;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ClickableKt$clickable$2(boolean z, String str, Role role, Function0<Unit> function0) {
        super(3);
        this.$enabled = z;
        this.$onClickLabel = str;
        this.$role = role;
        this.$onClick = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    public final Modifier invoke(Modifier modifier, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer.startReplaceableGroup(1841979210);
        ComposerKt.sourceInformation(composer, "C92@3840L7,93@3877L39:Clickable.kt#71ulvw");
        Modifier.Companion companion = Modifier.Companion;
        ComposerKt.sourceInformationMarkerStart(composer, 103361330, "C:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(IndicationKt.getLocalIndication());
        ComposerKt.sourceInformationMarkerEnd(composer);
        Indication indication = (Indication) consume;
        composer.startReplaceableGroup(-3687241);
        ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = InteractionSourceKt.MutableInteractionSource();
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        Modifier r8 = ClickableKt.m177clickableO2vRcR0(companion, (MutableInteractionSource) rememberedValue, indication, this.$enabled, this.$onClickLabel, this.$role, this.$onClick);
        composer.endReplaceableGroup();
        return r8;
    }
}
