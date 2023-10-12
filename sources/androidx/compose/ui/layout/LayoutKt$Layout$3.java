package androidx.compose.ui.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Layout.kt */
final class LayoutKt$Layout$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ Function3<IntrinsicMeasureScope, List<? extends IntrinsicMeasurable>, Integer, Integer> $maxIntrinsicHeightMeasureBlock;
    final /* synthetic */ Function3<IntrinsicMeasureScope, List<? extends IntrinsicMeasurable>, Integer, Integer> $maxIntrinsicWidthMeasureBlock;
    final /* synthetic */ Function3<MeasureScope, List<? extends Measurable>, Constraints, MeasureResult> $measureBlock;
    final /* synthetic */ Function3<IntrinsicMeasureScope, List<? extends IntrinsicMeasurable>, Integer, Integer> $minIntrinsicHeightMeasureBlock;
    final /* synthetic */ Function3<IntrinsicMeasureScope, List<? extends IntrinsicMeasurable>, Integer, Integer> $minIntrinsicWidthMeasureBlock;
    final /* synthetic */ Modifier $modifier;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LayoutKt$Layout$3(Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super IntrinsicMeasureScope, ? super List<? extends IntrinsicMeasurable>, ? super Integer, Integer> function3, Function3<? super IntrinsicMeasureScope, ? super List<? extends IntrinsicMeasurable>, ? super Integer, Integer> function32, Function3<? super IntrinsicMeasureScope, ? super List<? extends IntrinsicMeasurable>, ? super Integer, Integer> function33, Function3<? super IntrinsicMeasureScope, ? super List<? extends IntrinsicMeasurable>, ? super Integer, Integer> function34, Modifier modifier, Function3<? super MeasureScope, ? super List<? extends Measurable>, ? super Constraints, ? extends MeasureResult> function35, int i, int i2) {
        super(2);
        this.$content = function2;
        this.$minIntrinsicWidthMeasureBlock = function3;
        this.$minIntrinsicHeightMeasureBlock = function32;
        this.$maxIntrinsicWidthMeasureBlock = function33;
        this.$maxIntrinsicHeightMeasureBlock = function34;
        this.$modifier = modifier;
        this.$measureBlock = function35;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        LayoutKt.Layout(this.$content, this.$minIntrinsicWidthMeasureBlock, this.$minIntrinsicHeightMeasureBlock, this.$maxIntrinsicWidthMeasureBlock, this.$maxIntrinsicHeightMeasureBlock, this.$modifier, this.$measureBlock, composer, this.$$changed | 1, this.$$default);
    }
}
