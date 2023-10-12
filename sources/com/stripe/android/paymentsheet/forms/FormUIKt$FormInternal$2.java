package com.stripe.android.paymentsheet.forms;

import androidx.compose.runtime.Composer;
import com.stripe.android.ui.core.elements.FormElement;
import com.stripe.android.ui.core.elements.IdentifierSpec;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.flow.Flow;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FormUI.kt */
final class FormUIKt$FormInternal$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ Flow<List<FormElement>> $elementsFlow;
    final /* synthetic */ Flow<Boolean> $enabledFlow;
    final /* synthetic */ Flow<List<IdentifierSpec>> $hiddenIdentifiersFlow;
    final /* synthetic */ Flow<IdentifierSpec> $lastTextFieldIdentifierFlow;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FormUIKt$FormInternal$2(Flow<? extends List<? extends IdentifierSpec>> flow, Flow<Boolean> flow2, Flow<? extends List<? extends FormElement>> flow3, Flow<? extends IdentifierSpec> flow4, int i) {
        super(2);
        this.$hiddenIdentifiersFlow = flow;
        this.$enabledFlow = flow2;
        this.$elementsFlow = flow3;
        this.$lastTextFieldIdentifierFlow = flow4;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        FormUIKt.FormInternal(this.$hiddenIdentifiersFlow, this.$enabledFlow, this.$elementsFlow, this.$lastTextFieldIdentifierFlow, composer, this.$$changed | 1);
    }
}
