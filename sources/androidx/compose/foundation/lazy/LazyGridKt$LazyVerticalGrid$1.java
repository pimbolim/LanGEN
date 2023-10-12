package androidx.compose.foundation.lazy;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.GridCells;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LazyGrid.kt */
final class LazyGridKt$LazyVerticalGrid$1 extends Lambda implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ GridCells $cells;
    final /* synthetic */ Function1<LazyGridScope, Unit> $content;
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ Arrangement.Horizontal $horizontalArrangement;
    final /* synthetic */ LazyListState $state;
    final /* synthetic */ Arrangement.Vertical $verticalArrangement;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyGridKt$LazyVerticalGrid$1(GridCells gridCells, LazyListState lazyListState, PaddingValues paddingValues, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, Function1<? super LazyGridScope, Unit> function1, int i) {
        super(3);
        this.$cells = gridCells;
        this.$state = lazyListState;
        this.$contentPadding = paddingValues;
        this.$verticalArrangement = vertical;
        this.$horizontalArrangement = horizontal;
        this.$content = function1;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((BoxWithConstraintsScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(boxWithConstraintsScope, "$this$BoxWithConstraints");
        ComposerKt.sourceInformation(composer, "C79@3364L329:LazyGrid.kt#428nma");
        if ((i & 14) == 0) {
            i |= composer.changed((Object) boxWithConstraintsScope) ? 4 : 2;
        }
        if (((i & 91) ^ 18) != 0 || !composer.getSkipping()) {
            int max = Math.max((int) (boxWithConstraintsScope.m392getMaxWidthD9Ej5fM() / ((GridCells.Adaptive) this.$cells).m510getMinSizeD9Ej5fM()), 1);
            LazyListState lazyListState = this.$state;
            PaddingValues paddingValues = this.$contentPadding;
            Arrangement.Vertical vertical = this.$verticalArrangement;
            Arrangement.Horizontal horizontal = this.$horizontalArrangement;
            Function1<LazyGridScope, Unit> function1 = this.$content;
            int i2 = this.$$dirty;
            LazyGridKt.FixedLazyGrid(max, (Modifier) null, lazyListState, paddingValues, vertical, horizontal, function1, composer, (i2 & 896) | (i2 & 7168) | (57344 & i2) | (458752 & i2) | (i2 & 3670016), 2);
            return;
        }
        composer.skipToGroupEnd();
    }
}
