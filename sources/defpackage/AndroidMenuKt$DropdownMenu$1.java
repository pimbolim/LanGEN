package defpackage;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.TransformOrigin;
import com.stripe.android.ui.core.elements.menu.MenuKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* renamed from: AndroidMenuKt$DropdownMenu$1  reason: default package */
/* compiled from: AndroidMenu.kt */
final class AndroidMenuKt$DropdownMenu$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function1<LazyListScope, Unit> $content;
    final /* synthetic */ MutableTransitionState<Boolean> $expandedStates;
    final /* synthetic */ int $initialFirstVisibleItemIndex;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ MutableState<TransformOrigin> $transformOriginState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidMenuKt$DropdownMenu$1(MutableTransitionState<Boolean> mutableTransitionState, MutableState<TransformOrigin> mutableState, int i, Modifier modifier, Function1<? super LazyListScope, Unit> function1, int i2) {
        super(2);
        this.$expandedStates = mutableTransitionState;
        this.$transformOriginState = mutableState;
        this.$initialFirstVisibleItemIndex = i;
        this.$modifier = modifier;
        this.$content = function1;
        this.$$dirty = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if (((i & 11) ^ 2) != 0 || !composer.getSkipping()) {
            MutableTransitionState<Boolean> mutableTransitionState = this.$expandedStates;
            MutableState<TransformOrigin> mutableState = this.$transformOriginState;
            int i2 = this.$initialFirstVisibleItemIndex;
            Modifier modifier = this.$modifier;
            Function1<LazyListScope, Unit> function1 = this.$content;
            int i3 = this.$$dirty;
            MenuKt.DropdownMenuContent(mutableTransitionState, mutableState, i2, modifier, function1, composer, MutableTransitionState.$stable | 48 | ((i3 << 3) & 896) | (i3 & 7168) | ((i3 >> 6) & 57344), 0);
            return;
        }
        composer.skipToGroupEnd();
    }
}
