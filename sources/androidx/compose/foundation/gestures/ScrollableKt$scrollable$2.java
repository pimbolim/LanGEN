package androidx.compose.foundation.gestures;

import androidx.compose.foundation.interaction.MutableInteractionSource;
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
/* compiled from: Scrollable.kt */
final class ScrollableKt$scrollable$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ FlingBehavior $flingBehavior;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ Orientation $orientation;
    final /* synthetic */ OverScrollController $overScrollController;
    final /* synthetic */ boolean $reverseDirection;
    final /* synthetic */ ScrollableState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScrollableKt$scrollable$2(OverScrollController overScrollController, Orientation orientation, ScrollableState scrollableState, boolean z, boolean z2, MutableInteractionSource mutableInteractionSource, FlingBehavior flingBehavior) {
        super(3);
        this.$overScrollController = overScrollController;
        this.$orientation = orientation;
        this.$state = scrollableState;
        this.$reverseDirection = z;
        this.$enabled = z2;
        this.$interactionSource = mutableInteractionSource;
        this.$flingBehavior = flingBehavior;
    }

    /* access modifiers changed from: private */
    public static final float invoke$reverseIfNeeded(float f, boolean z) {
        return z ? f * ((float) -1) : f;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    public final Modifier invoke(Modifier modifier, Composer composer, int i) {
        Modifier modifier2;
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer.startReplaceableGroup(536297813);
        ComposerKt.sourceInformation(composer, "C119@5550L131,134@6039L244:Scrollable.kt#8bwon0");
        OverScrollController overScrollController = this.$overScrollController;
        Modifier overScroll = overScrollController == null ? null : AndroidOverScrollKt.overScroll(Modifier.Companion, overScrollController);
        if (overScroll == null) {
            overScroll = Modifier.Companion;
        }
        Orientation orientation = this.$orientation;
        ScrollableState scrollableState = this.$state;
        Boolean valueOf = Boolean.valueOf(this.$reverseDirection);
        Orientation orientation2 = this.$orientation;
        ScrollableState scrollableState2 = this.$state;
        boolean z = this.$reverseDirection;
        composer.startReplaceableGroup(-3686095);
        ComposerKt.sourceInformation(composer, "C(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean changed = composer.changed((Object) orientation) | composer.changed((Object) scrollableState) | composer.changed((Object) valueOf);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new BringIntoViewResponder(orientation2, scrollableState2, z);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        BringIntoViewResponder bringIntoViewResponder = (BringIntoViewResponder) rememberedValue;
        if (this.$enabled) {
            modifier2 = ModifierLocalScrollableContainerProvider.INSTANCE;
        } else {
            modifier2 = Modifier.Companion;
        }
        Modifier access$touchScrollable = ScrollableKt.touchScrollable(Modifier.Companion.then(bringIntoViewResponder).then(overScroll), this.$interactionSource, this.$orientation, this.$reverseDirection, this.$state, this.$flingBehavior, this.$overScrollController, this.$enabled, composer, 0);
        Orientation orientation3 = this.$orientation;
        final ScrollableState scrollableState3 = this.$state;
        final boolean z2 = this.$reverseDirection;
        Modifier then = AndroidScrollable_androidKt.mouseScrollable(access$touchScrollable, orientation3, new Function1<Float, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(float f) {
                scrollableState3.dispatchRawDelta(ScrollableKt$scrollable$2.invoke$reverseIfNeeded(f, z2));
            }
        }).then(modifier2);
        composer.endReplaceableGroup();
        return then;
    }
}
