package androidx.compose.foundation.lazy;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\r\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\b\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/foundation/lazy/LazyItemScope;", "it", "", "invoke", "(Landroidx/compose/foundation/lazy/LazyItemScope;I)Lkotlin/jvm/functions/Function2;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LazyGrid.kt */
final class LazyGridScopeImpl$items$1 extends Lambda implements Function2<LazyItemScope, Integer, Function2<? super Composer, ? super Integer, ? extends Unit>> {
    final /* synthetic */ Function4<LazyItemScope, Integer, Composer, Integer, Unit> $itemContent;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyGridScopeImpl$items$1(Function4<? super LazyItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4) {
        super(2);
        this.$itemContent = function4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke((LazyItemScope) obj, ((Number) obj2).intValue());
    }

    public final Function2<Composer, Integer, Unit> invoke(final LazyItemScope lazyItemScope, final int i) {
        Intrinsics.checkNotNullParameter(lazyItemScope, "$this$$receiver");
        final Function4<LazyItemScope, Integer, Composer, Integer, Unit> function4 = this.$itemContent;
        return ComposableLambdaKt.composableLambdaInstance(-985549940, true, new Function2<Composer, Integer, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i) {
                ComposerKt.sourceInformation(composer, "C434@17105L15:LazyGrid.kt#428nma");
                if (((i & 11) ^ 2) != 0 || !composer.getSkipping()) {
                    function4.invoke(lazyItemScope, Integer.valueOf(i), composer, 0);
                } else {
                    composer.skipToGroupEnd();
                }
            }
        });
    }
}
