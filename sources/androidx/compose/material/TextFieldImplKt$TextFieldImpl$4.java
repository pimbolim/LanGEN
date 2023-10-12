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
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextFieldImpl.kt */
final class TextFieldImplKt$TextFieldImpl$4 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$changed1;
    final /* synthetic */ int $$default;
    final /* synthetic */ TextFieldColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ boolean $isError;
    final /* synthetic */ KeyboardActions $keyboardActions;
    final /* synthetic */ KeyboardOptions $keyboardOptions;
    final /* synthetic */ Function2<Composer, Integer, Unit> $label;
    final /* synthetic */ Function2<Composer, Integer, Unit> $leading;
    final /* synthetic */ int $maxLines;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function1<TextFieldValue, Unit> $onValueChange;
    final /* synthetic */ Function2<Composer, Integer, Unit> $placeholder;
    final /* synthetic */ boolean $readOnly;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ boolean $singleLine;
    final /* synthetic */ TextStyle $textStyle;
    final /* synthetic */ Function2<Composer, Integer, Unit> $trailing;
    final /* synthetic */ TextFieldType $type;
    final /* synthetic */ TextFieldValue $value;
    final /* synthetic */ VisualTransformation $visualTransformation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldImplKt$TextFieldImpl$4(TextFieldType textFieldType, boolean z, boolean z2, TextFieldValue textFieldValue, Function1<? super TextFieldValue, Unit> function1, Modifier modifier, boolean z3, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, boolean z4, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, int i, MutableInteractionSource mutableInteractionSource, Shape shape, TextFieldColors textFieldColors, int i2, int i3, int i4) {
        super(2);
        this.$type = textFieldType;
        this.$enabled = z;
        this.$readOnly = z2;
        this.$value = textFieldValue;
        this.$onValueChange = function1;
        this.$modifier = modifier;
        this.$singleLine = z3;
        this.$textStyle = textStyle;
        this.$label = function2;
        this.$placeholder = function22;
        this.$leading = function23;
        this.$trailing = function24;
        this.$isError = z4;
        this.$visualTransformation = visualTransformation;
        this.$keyboardOptions = keyboardOptions;
        this.$keyboardActions = keyboardActions;
        this.$maxLines = i;
        this.$interactionSource = mutableInteractionSource;
        this.$shape = shape;
        this.$colors = textFieldColors;
        this.$$changed = i2;
        this.$$changed1 = i3;
        this.$$default = i4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        Composer composer2 = composer;
        TextFieldType textFieldType = this.$type;
        TextFieldType textFieldType2 = textFieldType;
        TextFieldImplKt.TextFieldImpl(textFieldType2, this.$enabled, this.$readOnly, this.$value, this.$onValueChange, this.$modifier, this.$singleLine, this.$textStyle, this.$label, this.$placeholder, this.$leading, this.$trailing, this.$isError, this.$visualTransformation, this.$keyboardOptions, this.$keyboardActions, this.$maxLines, this.$interactionSource, this.$shape, this.$colors, composer2, this.$$changed | 1, this.$$changed1, this.$$default);
    }
}
