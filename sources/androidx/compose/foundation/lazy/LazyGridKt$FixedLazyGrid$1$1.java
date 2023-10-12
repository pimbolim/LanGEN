package androidx.compose.foundation.lazy;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LazyGrid.kt */
final class LazyGridKt$FixedLazyGrid$1$1 extends Lambda implements Function1<LazyListScope, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function1<LazyGridScope, Unit> $content;
    final /* synthetic */ Arrangement.Horizontal $horizontalArrangement;
    final /* synthetic */ int $nColumns;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyGridKt$FixedLazyGrid$1$1(int i, Function1<? super LazyGridScope, Unit> function1, Arrangement.Horizontal horizontal, int i2) {
        super(1);
        this.$nColumns = i;
        this.$content = function1;
        this.$horizontalArrangement = horizontal;
        this.$$dirty = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LazyListScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(LazyListScope lazyListScope) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(lazyListScope, "$this$LazyColumn");
        final LazyGridScopeImpl lazyGridScopeImpl = new LazyGridScopeImpl(this.$nColumns);
        this.$content.invoke(lazyGridScopeImpl);
        if (lazyGridScopeImpl.getHasCustomSpans$foundation_release()) {
            i2 = lazyGridScopeImpl.getTotalSize();
        } else if (lazyGridScopeImpl.getTotalSize() == 0) {
            i = 0;
            final int i3 = this.$nColumns;
            final Arrangement.Horizontal horizontal = this.$horizontalArrangement;
            final int i4 = this.$$dirty;
            LazyListScope.DefaultImpls.items$default(lazyListScope, i, (Function1) null, ComposableLambdaKt.composableLambdaInstance(-985540832, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    invoke((LazyItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(LazyItemScope lazyItemScope, int i, Composer composer, int i2) {
                    int i3;
                    Intrinsics.checkNotNullParameter(lazyItemScope, "$this$items");
                    ComposerKt.sourceInformation(composer, "C267@9962L52:LazyGrid.kt#428nma");
                    if ((i2 & 14) == 0) {
                        i3 = (composer.changed((Object) lazyItemScope) ? 4 : 2) | i2;
                    } else {
                        i3 = i2;
                    }
                    if ((i2 & 112) == 0) {
                        i3 |= composer.changed(i) ? 32 : 16;
                    }
                    if (((i3 & 731) ^ 146) != 0 || !composer.getSkipping()) {
                        List<Pair<Function2<Composer, Integer, Unit>, Integer>> contentFor = lazyGridScopeImpl.contentFor(i, lazyItemScope);
                        if (!contentFor.isEmpty()) {
                            int i4 = i3;
                            Arrangement.Horizontal horizontal = horizontal;
                            int i5 = i4;
                            LazyGridKt.ItemRow(i4, horizontal, contentFor, composer, ((i5 >> 12) & 112) | (i5 & 14) | 512);
                            return;
                        }
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }), 2, (Object) null);
        } else {
            i2 = ((lazyGridScopeImpl.getTotalSize() - 1) / this.$nColumns) + 1;
        }
        i = i2;
        final int i32 = this.$nColumns;
        final Arrangement.Horizontal horizontal2 = this.$horizontalArrangement;
        final int i42 = this.$$dirty;
        LazyListScope.DefaultImpls.items$default(lazyListScope, i, (Function1) null, ComposableLambdaKt.composableLambdaInstance(-985540832, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                invoke((LazyItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope lazyItemScope, int i, Composer composer, int i2) {
                int i3;
                Intrinsics.checkNotNullParameter(lazyItemScope, "$this$items");
                ComposerKt.sourceInformation(composer, "C267@9962L52:LazyGrid.kt#428nma");
                if ((i2 & 14) == 0) {
                    i3 = (composer.changed((Object) lazyItemScope) ? 4 : 2) | i2;
                } else {
                    i3 = i2;
                }
                if ((i2 & 112) == 0) {
                    i3 |= composer.changed(i) ? 32 : 16;
                }
                if (((i3 & 731) ^ 146) != 0 || !composer.getSkipping()) {
                    List<Pair<Function2<Composer, Integer, Unit>, Integer>> contentFor = lazyGridScopeImpl.contentFor(i, lazyItemScope);
                    if (!contentFor.isEmpty()) {
                        int i4 = i32;
                        Arrangement.Horizontal horizontal = horizontal2;
                        int i5 = i42;
                        LazyGridKt.ItemRow(i4, horizontal, contentFor, composer, ((i5 >> 12) & 112) | (i5 & 14) | 512);
                        return;
                    }
                    return;
                }
                composer.skipToGroupEnd();
            }
        }), 2, (Object) null);
    }
}
