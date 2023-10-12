package com.stripe.android.ui.core.elements;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import androidx.compose.ui.res.StringResources_androidKt;
import com.stripe.android.ui.core.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextFieldUI.kt */
final class TextFieldUIKt$TextField$8 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ State<Integer> $label$delegate;
    final /* synthetic */ TextFieldController $textFieldController;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldUIKt$TextField$8(TextFieldController textFieldController, State<Integer> state) {
        super(2);
        this.$textFieldController = textFieldController;
        this.$label$delegate = state;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        String str;
        if (((i & 11) ^ 2) != 0 || !composer.getSkipping()) {
            String str2 = "";
            String str3 = null;
            if (this.$textFieldController.getShowOptionalLabel()) {
                composer.startReplaceableGroup(-342678871);
                int i2 = R.string.form_label_optional;
                Object[] objArr = new Object[1];
                Integer r5 = TextFieldUIKt.m4617TextField_6fMdlN4$lambda8(this.$label$delegate);
                if (r5 != null) {
                    str3 = StringResources_androidKt.stringResource(r5.intValue(), composer, 0);
                }
                if (str3 != null) {
                    str2 = str3;
                }
                objArr[0] = str2;
                str = StringResources_androidKt.stringResource(i2, objArr, composer, 64);
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(-342678670);
                Integer r8 = TextFieldUIKt.m4617TextField_6fMdlN4$lambda8(this.$label$delegate);
                if (r8 != null) {
                    str3 = StringResources_androidKt.stringResource(r8.intValue(), composer, 0);
                }
                if (str3 != null) {
                    str2 = str3;
                }
                composer.endReplaceableGroup();
                str = str2;
            }
            FormLabelKt.FormLabel(str, false, composer, 0, 2);
            return;
        }
        composer.skipToGroupEnd();
    }
}
