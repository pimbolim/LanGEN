package androidx.compose.foundation.gestures;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/gestures/PointerAwareDraggableState;", "invoke", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/gestures/PointerAwareDraggableState;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Draggable.kt */
final class DraggableKt$draggable$3 extends Lambda implements Function2<Composer, Integer, PointerAwareDraggableState> {
    final /* synthetic */ DraggableState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DraggableKt$draggable$3(DraggableState draggableState) {
        super(2);
        this.$state = draggableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke((Composer) obj, ((Number) obj2).intValue());
    }

    public final PointerAwareDraggableState invoke(Composer composer, int i) {
        composer.startReplaceableGroup(-1197727804);
        ComposerKt.sourceInformation(composer, "C183@8488L54:Draggable.kt#8bwon0");
        DraggableState draggableState = this.$state;
        composer.startReplaceableGroup(-3686930);
        ComposerKt.sourceInformation(composer, "C(remember)P(1):Composables.kt#9igjgp");
        boolean changed = composer.changed((Object) draggableState);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new IgnorePointerDraggableState(draggableState);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return (IgnorePointerDraggableState) rememberedValue;
    }
}
