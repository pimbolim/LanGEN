package androidx.compose.material;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: OutlinedTextField.kt */
final class OutlinedTextFieldKt$OutlinedTextFieldLayout$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$changed1;
    final /* synthetic */ int $$changed2;
    final /* synthetic */ int $$default;
    final /* synthetic */ long $backgroundColor;
    final /* synthetic */ long $cursorColor;
    final /* synthetic */ Function2<Composer, Integer, Unit> $decoratedLabel;
    final /* synthetic */ Function3<Modifier, Composer, Integer, Unit> $decoratedPlaceholder;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ long $indicatorColor;
    final /* synthetic */ float $indicatorWidth;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ KeyboardActions $keyboardActions;
    final /* synthetic */ KeyboardOptions $keyboardOptions;
    final /* synthetic */ float $labelProgress;
    final /* synthetic */ Function2<Composer, Integer, Unit> $leading;
    final /* synthetic */ long $leadingColor;
    final /* synthetic */ int $maxLines;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function1<TextFieldValue, Unit> $onValueChange;
    final /* synthetic */ boolean $readOnly;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ boolean $singleLine;
    final /* synthetic */ TextStyle $textStyle;
    final /* synthetic */ Function2<Composer, Integer, Unit> $trailing;
    final /* synthetic */ long $trailingColor;
    final /* synthetic */ TextFieldValue $value;
    final /* synthetic */ VisualTransformation $visualTransformation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OutlinedTextFieldKt$OutlinedTextFieldLayout$2(Modifier modifier, TextFieldValue textFieldValue, Function1<? super TextFieldValue, Unit> function1, boolean z, boolean z2, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, TextStyle textStyle, boolean z3, int i, VisualTransformation visualTransformation, MutableInteractionSource mutableInteractionSource, Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, long j, long j2, float f, float f2, long j3, long j4, long j5, Shape shape, int i2, int i3, int i4, int i5) {
        super(2);
        this.$modifier = modifier;
        this.$value = textFieldValue;
        this.$onValueChange = function1;
        this.$enabled = z;
        this.$readOnly = z2;
        this.$keyboardOptions = keyboardOptions;
        this.$keyboardActions = keyboardActions;
        this.$textStyle = textStyle;
        this.$singleLine = z3;
        this.$maxLines = i;
        this.$visualTransformation = visualTransformation;
        this.$interactionSource = mutableInteractionSource;
        this.$decoratedPlaceholder = function3;
        this.$decoratedLabel = function2;
        this.$leading = function22;
        this.$trailing = function23;
        this.$leadingColor = j;
        this.$trailingColor = j2;
        this.$labelProgress = f;
        this.$indicatorWidth = f2;
        this.$indicatorColor = j3;
        this.$cursorColor = j4;
        this.$backgroundColor = j5;
        this.$shape = shape;
        this.$$changed = i2;
        this.$$changed1 = i3;
        this.$$changed2 = i4;
        this.$$default = i5;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        Composer composer2 = composer;
        Modifier modifier = this.$modifier;
        Modifier modifier2 = modifier;
        OutlinedTextFieldKt.m1054OutlinedTextFieldLayoutuBqXD2s(modifier2, this.$value, this.$onValueChange, this.$enabled, this.$readOnly, this.$keyboardOptions, this.$keyboardActions, this.$textStyle, this.$singleLine, this.$maxLines, this.$visualTransformation, this.$interactionSource, this.$decoratedPlaceholder, this.$decoratedLabel, this.$leading, this.$trailing, this.$leadingColor, this.$trailingColor, this.$labelProgress, this.$indicatorWidth, this.$indicatorColor, this.$cursorColor, this.$backgroundColor, this.$shape, composer2, this.$$changed | 1, this.$$changed1, this.$$changed2, this.$$default);
    }
}
