package androidx.compose.foundation.lazy.layout;

import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.layout.SubcomposeLayoutState;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.braintreepayments.api.models.PostalAddressParser;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0001¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"LazyLayoutPrefetcher", "", "prefetchPolicy", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchPolicy;", "state", "Landroidx/compose/foundation/lazy/layout/LazyLayoutState;", "itemContentFactory", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;", "subcomposeLayoutState", "Landroidx/compose/ui/layout/SubcomposeLayoutState;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchPolicy;Landroidx/compose/foundation/lazy/layout/LazyLayoutState;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;Landroidx/compose/ui/layout/SubcomposeLayoutState;Landroidx/compose/runtime/Composer;I)V", "foundation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: LazyLayoutPrefetcher.android.kt */
public final class LazyLayoutPrefetcher_androidKt {
    public static final void LazyLayoutPrefetcher(LazyLayoutPrefetchPolicy lazyLayoutPrefetchPolicy, LazyLayoutState lazyLayoutState, LazyLayoutItemContentFactory lazyLayoutItemContentFactory, SubcomposeLayoutState subcomposeLayoutState, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(lazyLayoutPrefetchPolicy, "prefetchPolicy");
        Intrinsics.checkNotNullParameter(lazyLayoutState, PostalAddressParser.REGION_KEY);
        Intrinsics.checkNotNullParameter(lazyLayoutItemContentFactory, "itemContentFactory");
        Intrinsics.checkNotNullParameter(subcomposeLayoutState, "subcomposeLayoutState");
        Composer startRestartGroup = composer.startRestartGroup(-649386156);
        ComposerKt.sourceInformation(startRestartGroup, "C(LazyLayoutPrefetcher)P(1,2)38@1442L7,39@1454L232:LazyLayoutPrefetcher.android.kt#wow0x6");
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
        Object consume = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalView());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        View view = (View) consume;
        int i2 = SubcomposeLayoutState.$stable;
        startRestartGroup.startReplaceableGroup(-3686095);
        ComposerKt.sourceInformation(startRestartGroup, "C(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean changed = startRestartGroup.changed((Object) subcomposeLayoutState) | startRestartGroup.changed((Object) lazyLayoutPrefetchPolicy) | startRestartGroup.changed((Object) view);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            startRestartGroup.updateRememberedValue(new LazyLayoutPrefetcher(lazyLayoutPrefetchPolicy, lazyLayoutState, subcomposeLayoutState, lazyLayoutItemContentFactory, view));
        }
        startRestartGroup.endReplaceableGroup();
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new LazyLayoutPrefetcher_androidKt$LazyLayoutPrefetcher$2(lazyLayoutPrefetchPolicy, lazyLayoutState, lazyLayoutItemContentFactory, subcomposeLayoutState, i));
        }
    }
}
