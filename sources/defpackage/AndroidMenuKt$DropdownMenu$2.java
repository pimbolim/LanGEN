package defpackage;

import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.window.PopupProperties;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* renamed from: AndroidMenuKt$DropdownMenu$2  reason: default package */
/* compiled from: AndroidMenu.kt */
final class AndroidMenuKt$DropdownMenu$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Function1<LazyListScope, Unit> $content;
    final /* synthetic */ boolean $expanded;
    final /* synthetic */ int $initialFirstVisibleItemIndex;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ long $offset;
    final /* synthetic */ Function0<Unit> $onDismissRequest;
    final /* synthetic */ PopupProperties $properties;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidMenuKt$DropdownMenu$2(boolean z, int i, Function0<Unit> function0, Modifier modifier, long j, PopupProperties popupProperties, Function1<? super LazyListScope, Unit> function1, int i2, int i3) {
        super(2);
        this.$expanded = z;
        this.$initialFirstVisibleItemIndex = i;
        this.$onDismissRequest = function0;
        this.$modifier = modifier;
        this.$offset = j;
        this.$properties = popupProperties;
        this.$content = function1;
        this.$$changed = i2;
        this.$$default = i3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        AndroidMenuKt.m0DropdownMenux0xb5LI(this.$expanded, this.$initialFirstVisibleItemIndex, this.$onDismissRequest, this.$modifier, this.$offset, this.$properties, this.$content, composer, this.$$changed | 1, this.$$default);
    }
}
