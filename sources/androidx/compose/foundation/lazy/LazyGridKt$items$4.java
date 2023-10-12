package androidx.compose.foundation.lazy;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u000b¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "T", "Landroidx/compose/foundation/lazy/LazyItemScope;", "it", "", "invoke", "(Landroidx/compose/foundation/lazy/LazyItemScope;ILandroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 6, 0}, xi = 176)
/* compiled from: LazyGrid.kt */
public final class LazyGridKt$items$4 extends Lambda implements Function4<LazyItemScope, Integer, Composer, Integer, Unit> {
    final /* synthetic */ Function4<LazyItemScope, T, Composer, Integer, Unit> $itemContent;
    final /* synthetic */ T[] $items;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyGridKt$items$4(Function4<? super LazyItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4, T[] tArr) {
        super(4);
        this.$itemContent = function4;
        this.$items = tArr;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        invoke((LazyItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(LazyItemScope lazyItemScope, int i, Composer composer, int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(lazyItemScope, "$this$items");
        ComposerKt.sourceInformation(composer, "C212@8029L22:LazyGrid.kt#428nma");
        if ((i2 & 14) == 0) {
            i3 = (composer.changed((Object) lazyItemScope) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 112) == 0) {
            i3 |= composer.changed(i) ? 32 : 16;
        }
        if (((i3 & 731) ^ 146) != 0 || !composer.getSkipping()) {
            this.$itemContent.invoke(lazyItemScope, this.$items[i], composer, Integer.valueOf(i3 & 14));
        } else {
            composer.skipToGroupEnd();
        }
    }
}
