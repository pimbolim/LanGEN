package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BottomSheetScaffold.kt */
final class BottomSheetScaffoldKt$BottomSheetScaffoldStack$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ Function2<Composer, Integer, Unit> $body;
    final /* synthetic */ Function2<Composer, Integer, Unit> $bottomSheet;
    final /* synthetic */ State<Float> $bottomSheetOffset;
    final /* synthetic */ Function2<Composer, Integer, Unit> $floatingActionButton;
    final /* synthetic */ int $floatingActionButtonPosition;
    final /* synthetic */ Function2<Composer, Integer, Unit> $snackbarHost;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BottomSheetScaffoldKt$BottomSheetScaffoldStack$3(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, State<Float> state, int i, int i2) {
        super(2);
        this.$body = function2;
        this.$bottomSheet = function22;
        this.$floatingActionButton = function23;
        this.$snackbarHost = function24;
        this.$bottomSheetOffset = state;
        this.$floatingActionButtonPosition = i;
        this.$$changed = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        BottomSheetScaffoldKt.m869BottomSheetScaffoldStackSlNgfk0(this.$body, this.$bottomSheet, this.$floatingActionButton, this.$snackbarHost, this.$bottomSheetOffset, this.$floatingActionButtonPosition, composer, this.$$changed | 1);
    }
}
