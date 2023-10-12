package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.gestures.ScrollableStateKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextFieldScroll.kt */
final class TextFieldScrollKt$textFieldScrollable$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ TextFieldScrollerPosition $scrollerPosition;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldScrollKt$textFieldScrollable$2(TextFieldScrollerPosition textFieldScrollerPosition, boolean z, MutableInteractionSource mutableInteractionSource) {
        super(3);
        this.$scrollerPosition = textFieldScrollerPosition;
        this.$enabled = z;
        this.$interactionSource = mutableInteractionSource;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    public final Modifier invoke(Modifier modifier, Composer composer, int i) {
        boolean z;
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer.startReplaceableGroup(994171470);
        ComposerKt.sourceInformation(composer, "C64@2701L7,66@2841L412:TextFieldScroll.kt#423gt5");
        ComposerKt.sourceInformationMarkerStart(composer, 103361330, "C:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ComposerKt.sourceInformationMarkerEnd(composer);
        boolean z2 = this.$scrollerPosition.getOrientation() == Orientation.Vertical || !(consume == LayoutDirection.Rtl);
        ScrollableState rememberScrollableState = ScrollableStateKt.rememberScrollableState(new TextFieldScrollKt$textFieldScrollable$2$controller$1(this.$scrollerPosition), composer, 0);
        Modifier.Companion companion = Modifier.Companion;
        Orientation orientation = this.$scrollerPosition.getOrientation();
        if (this.$enabled) {
            if (!(this.$scrollerPosition.getMaximum() == 0.0f)) {
                z = true;
                Modifier scrollable$default = ScrollableKt.scrollable$default(companion, rememberScrollableState, orientation, z, z2, (FlingBehavior) null, this.$interactionSource, 16, (Object) null);
                composer.endReplaceableGroup();
                return scrollable$default;
            }
        }
        z = false;
        Modifier scrollable$default2 = ScrollableKt.scrollable$default(companion, rememberScrollableState, orientation, z, z2, (FlingBehavior) null, this.$interactionSource, 16, (Object) null);
        composer.endReplaceableGroup();
        return scrollable$default2;
    }
}
