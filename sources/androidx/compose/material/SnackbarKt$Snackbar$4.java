package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Snackbar.kt */
final class SnackbarKt$Snackbar$4 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ long $actionColor;
    final /* synthetic */ boolean $actionOnNewLine;
    final /* synthetic */ long $backgroundColor;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ float $elevation;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ SnackbarData $snackbarData;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SnackbarKt$Snackbar$4(SnackbarData snackbarData, Modifier modifier, boolean z, Shape shape, long j, long j2, long j3, float f, int i, int i2) {
        super(2);
        this.$snackbarData = snackbarData;
        this.$modifier = modifier;
        this.$actionOnNewLine = z;
        this.$shape = shape;
        this.$backgroundColor = j;
        this.$contentColor = j2;
        this.$actionColor = j3;
        this.$elevation = f;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        SnackbarKt.m1107SnackbarsPrSdHI(this.$snackbarData, this.$modifier, this.$actionOnNewLine, this.$shape, this.$backgroundColor, this.$contentColor, this.$actionColor, this.$elevation, composer, this.$$changed | 1, this.$$default);
    }
}
