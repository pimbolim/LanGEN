package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"rememberLazyLayoutState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutState;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/layout/LazyLayoutState;", "foundation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: LazyLayoutState.kt */
public final class LazyLayoutStateKt {
    public static final LazyLayoutState rememberLazyLayoutState(Composer composer, int i) {
        composer.startReplaceableGroup(-1458691983);
        ComposerKt.sourceInformation(composer, "C(rememberLazyLayoutState)30@1103L30:LazyLayoutState.kt#wow0x6");
        composer.startReplaceableGroup(-3687241);
        ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new LazyLayoutState();
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        LazyLayoutState lazyLayoutState = (LazyLayoutState) rememberedValue;
        composer.endReplaceableGroup();
        return lazyLayoutState;
    }
}
