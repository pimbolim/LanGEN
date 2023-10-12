package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: OutlinedTextField.kt */
final class OutlinedTextFieldKt$IconsWithTextFieldLayout$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$changed1;
    final /* synthetic */ float $animationProgress;
    final /* synthetic */ long $borderColor;
    final /* synthetic */ float $borderWidth;
    final /* synthetic */ Function2<Composer, Integer, Unit> $label;
    final /* synthetic */ long $labelSize;
    final /* synthetic */ Function2<Composer, Integer, Unit> $leading;
    final /* synthetic */ long $leadingColor;
    final /* synthetic */ Function1<Size, Unit> $onLabelMeasured;
    final /* synthetic */ Function3<Modifier, Composer, Integer, Unit> $placeholder;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ boolean $singleLine;
    final /* synthetic */ Function2<Composer, Integer, Unit> $textField;
    final /* synthetic */ Function2<Composer, Integer, Unit> $trailing;
    final /* synthetic */ long $trailingColor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OutlinedTextFieldKt$IconsWithTextFieldLayout$2(Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, boolean z, long j, long j2, float f, Function1<? super Size, Unit> function1, Shape shape, float f2, long j3, long j4, int i, int i2) {
        super(2);
        this.$textField = function2;
        this.$placeholder = function3;
        this.$label = function22;
        this.$leading = function23;
        this.$trailing = function24;
        this.$singleLine = z;
        this.$leadingColor = j;
        this.$trailingColor = j2;
        this.$animationProgress = f;
        this.$onLabelMeasured = function1;
        this.$shape = shape;
        this.$borderWidth = f2;
        this.$borderColor = j3;
        this.$labelSize = j4;
        this.$$changed = i;
        this.$$changed1 = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        Composer composer2 = composer;
        Function2<Composer, Integer, Unit> function2 = this.$textField;
        Function2<Composer, Integer, Unit> function22 = function2;
        OutlinedTextFieldKt.m1051IconsWithTextFieldLayoutT2E5_Oc(function22, this.$placeholder, this.$label, this.$leading, this.$trailing, this.$singleLine, this.$leadingColor, this.$trailingColor, this.$animationProgress, this.$onLabelMeasured, this.$shape, this.$borderWidth, this.$borderColor, this.$labelSize, composer2, this.$$changed | 1, this.$$changed1);
    }
}
