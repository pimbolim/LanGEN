package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.runtime.saveable.SaveableStateHolderKt;
import com.braintreepayments.api.models.PostalAddressParser;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"rememberItemContentFactory", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;", "state", "Landroidx/compose/foundation/lazy/layout/LazyLayoutState;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;", "foundation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: LazyLayoutItemContentFactory.kt */
public final class LazyLayoutItemContentFactoryKt {
    public static final LazyLayoutItemContentFactory rememberItemContentFactory(LazyLayoutState lazyLayoutState, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(lazyLayoutState, PostalAddressParser.REGION_KEY);
        composer.startReplaceableGroup(-2067463753);
        ComposerKt.sourceInformation(composer, "C(rememberItemContentFactory)31@1281L29,33@1366L104:LazyLayoutItemContentFactory.kt#wow0x6");
        SaveableStateHolder rememberSaveableStateHolder = SaveableStateHolderKt.rememberSaveableStateHolder(composer, 0);
        Function0<LazyLayoutItemsProvider> itemsProvider$foundation_release = lazyLayoutState.getItemsProvider$foundation_release();
        composer.startReplaceableGroup(-3686930);
        ComposerKt.sourceInformation(composer, "C(remember)P(1):Composables.kt#9igjgp");
        boolean changed = composer.changed((Object) itemsProvider$foundation_release);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new LazyLayoutItemContentFactory(rememberSaveableStateHolder, itemsProvider$foundation_release);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        LazyLayoutItemContentFactory lazyLayoutItemContentFactory = (LazyLayoutItemContentFactory) rememberedValue;
        composer.endReplaceableGroup();
        return lazyLayoutItemContentFactory;
    }
}
