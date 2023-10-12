package androidx.compose.material;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextField.kt */
final class TextFieldKt$TextField$2$1 extends Lambda implements Function1<TextFieldValue, Unit> {
    final /* synthetic */ Function1<String, Unit> $onValueChange;
    final /* synthetic */ MutableState<TextFieldValue> $textFieldValueState$delegate;
    final /* synthetic */ String $value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldKt$TextField$2$1(String str, Function1<? super String, Unit> function1, MutableState<TextFieldValue> mutableState) {
        super(1);
        this.$value = str;
        this.$onValueChange = function1;
        this.$textFieldValueState$delegate = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TextFieldValue) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(TextFieldValue textFieldValue) {
        Intrinsics.checkNotNullParameter(textFieldValue, "it");
        TextFieldKt.m1172TextField$lambda3(this.$textFieldValueState$delegate, textFieldValue);
        if (!Intrinsics.areEqual((Object) this.$value, (Object) textFieldValue.getText())) {
            this.$onValueChange.invoke(textFieldValue.getText());
        }
    }
}
