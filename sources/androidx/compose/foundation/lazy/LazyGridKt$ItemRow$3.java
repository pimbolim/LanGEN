package androidx.compose.foundation.lazy;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.runtime.Composer;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LazyGrid.kt */
final class LazyGridKt$ItemRow$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ Arrangement.Horizontal $horizontalArrangement;
    final /* synthetic */ int $nColumns;
    final /* synthetic */ List<Pair<Function2<Composer, Integer, Unit>, Integer>> $rowContent;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyGridKt$ItemRow$3(int i, Arrangement.Horizontal horizontal, List<? extends Pair<? extends Function2<? super Composer, ? super Integer, Unit>, Integer>> list, int i2) {
        super(2);
        this.$nColumns = i;
        this.$horizontalArrangement = horizontal;
        this.$rowContent = list;
        this.$$changed = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        LazyGridKt.ItemRow(this.$nColumns, this.$horizontalArrangement, this.$rowContent, composer, this.$$changed | 1);
    }
}
