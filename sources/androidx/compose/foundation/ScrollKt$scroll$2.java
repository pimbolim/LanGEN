package androidx.compose.foundation;

import androidx.compose.foundation.gestures.AndroidOverScrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.OverScrollController;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Scroll.kt */
final class ScrollKt$scroll$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ FlingBehavior $flingBehavior;
    final /* synthetic */ boolean $isScrollable;
    final /* synthetic */ boolean $isVertical;
    final /* synthetic */ boolean $reverseScrolling;
    final /* synthetic */ ScrollState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScrollKt$scroll$2(boolean z, ScrollState scrollState, boolean z2, FlingBehavior flingBehavior, boolean z3) {
        super(3);
        this.$isVertical = z;
        this.$state = scrollState;
        this.$isScrollable = z2;
        this.$flingBehavior = flingBehavior;
        this.$reverseScrolling = z3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    public final Modifier invoke(Modifier modifier, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer.startReplaceableGroup(-1641237764);
        ComposerKt.sourceInformation(composer, "C264@9959L30,265@10019L24,*300@11775L7:Scroll.kt#71ulvw");
        boolean z = false;
        OverScrollController rememberOverScrollController = AndroidOverScrollKt.rememberOverScrollController(composer, 0);
        composer.startReplaceableGroup(-723524056);
        ComposerKt.sourceInformation(composer, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
        composer.startReplaceableGroup(-3687241);
        ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer));
            composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
            rememberedValue = compositionScopedCoroutineScopeCanceller;
        }
        composer.endReplaceableGroup();
        CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
        composer.endReplaceableGroup();
        Modifier semantics$default = SemanticsModifierKt.semantics$default(Modifier.Companion, false, new ScrollKt$scroll$2$semantics$1(this.$isScrollable, this.$reverseScrolling, this.$isVertical, this.$state, coroutineScope), 1, (Object) null);
        Modifier.Companion companion = Modifier.Companion;
        Orientation orientation = this.$isVertical ? Orientation.Vertical : Orientation.Horizontal;
        boolean z2 = this.$reverseScrolling;
        boolean z3 = this.$isVertical;
        boolean z4 = !z2;
        ComposerKt.sourceInformationMarkerStart(composer, 103361330, "C:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (consume == LayoutDirection.Rtl) {
            z = true;
        }
        Modifier then = ScrollKt.clipScrollableContainer(semantics$default, this.$isVertical).then(ScrollableKt.scrollable(companion, this.$state, orientation, rememberOverScrollController, this.$isScrollable, (!z || z3) ? z4 : !z4, this.$flingBehavior, this.$state.getInternalInteractionSource$foundation_release())).then(new ScrollingLayoutModifier(this.$state, this.$reverseScrolling, this.$isVertical, rememberOverScrollController));
        composer.endReplaceableGroup();
        return then;
    }
}
