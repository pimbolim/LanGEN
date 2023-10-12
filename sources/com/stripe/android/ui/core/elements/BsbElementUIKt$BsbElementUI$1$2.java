package com.stripe.android.ui.core.elements;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.input.ImeAction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BsbElementUI.kt */
final class BsbElementUIKt$BsbElementUI$1$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ BsbElement $element;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ IdentifierSpec $lastTextFieldIdentifier;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BsbElementUIKt$BsbElementUI$1$2(BsbElement bsbElement, IdentifierSpec identifierSpec, boolean z, int i) {
        super(2);
        this.$element = bsbElement;
        this.$lastTextFieldIdentifier = identifierSpec;
        this.$enabled = z;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        int i2;
        if (((i & 11) ^ 2) != 0 || !composer.getSkipping()) {
            TextFieldController controller = this.$element.getTextElement$payments_ui_core_release().getController();
            if (Intrinsics.areEqual((Object) this.$lastTextFieldIdentifier, (Object) this.$element.getIdentifier())) {
                i2 = ImeAction.Companion.m3643getDoneeUduSuo();
            } else {
                i2 = ImeAction.Companion.m3645getNexteUduSuo();
            }
            TextFieldUIKt.m4607TextField6fMdlN4(controller, (Modifier) null, i2, this.$enabled, composer, (this.$$dirty << 9) & 7168, 2);
            return;
        }
        composer.skipToGroupEnd();
    }
}
