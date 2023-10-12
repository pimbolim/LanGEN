package com.stripe.android.ui.core.elements;

import com.stripe.android.model.CardBrand;
import com.stripe.android.ui.core.elements.IdentifierSpec;
import com.stripe.android.ui.core.forms.FormFieldEntry;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\u0010\u0000\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH@"}, d2 = {"<anonymous>", "", "Lkotlin/Pair;", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "Lcom/stripe/android/ui/core/forms/FormFieldEntry;", "number", "cvc", "expirationDate", "brand", "Lcom/stripe/android/model/CardBrand;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.ui.core.elements.CardDetailsElement$getFormFieldValueFlow$1", f = "CardDetailsElement.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: CardDetailsElement.kt */
final class CardDetailsElement$getFormFieldValueFlow$1 extends SuspendLambda implements Function5<FormFieldEntry, FormFieldEntry, FormFieldEntry, CardBrand, Continuation<? super List<? extends Pair<? extends IdentifierSpec, ? extends FormFieldEntry>>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ Object L$2;
    /* synthetic */ Object L$3;
    int label;
    final /* synthetic */ CardDetailsElement this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CardDetailsElement$getFormFieldValueFlow$1(CardDetailsElement cardDetailsElement, Continuation<? super CardDetailsElement$getFormFieldValueFlow$1> continuation) {
        super(5, continuation);
        this.this$0 = cardDetailsElement;
    }

    public final Object invoke(FormFieldEntry formFieldEntry, FormFieldEntry formFieldEntry2, FormFieldEntry formFieldEntry3, CardBrand cardBrand, Continuation<? super List<? extends Pair<? extends IdentifierSpec, FormFieldEntry>>> continuation) {
        CardDetailsElement$getFormFieldValueFlow$1 cardDetailsElement$getFormFieldValueFlow$1 = new CardDetailsElement$getFormFieldValueFlow$1(this.this$0, continuation);
        cardDetailsElement$getFormFieldValueFlow$1.L$0 = formFieldEntry;
        cardDetailsElement$getFormFieldValueFlow$1.L$1 = formFieldEntry2;
        cardDetailsElement$getFormFieldValueFlow$1.L$2 = formFieldEntry3;
        cardDetailsElement$getFormFieldValueFlow$1.L$3 = cardBrand;
        return cardDetailsElement$getFormFieldValueFlow$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            FormFieldEntry formFieldEntry = (FormFieldEntry) this.L$0;
            FormFieldEntry formFieldEntry2 = (FormFieldEntry) this.L$1;
            FormFieldEntry formFieldEntry3 = (FormFieldEntry) this.L$2;
            CardBrand cardBrand = (CardBrand) this.L$3;
            Ref.IntRef intRef = new Ref.IntRef();
            intRef.element = -1;
            Ref.IntRef intRef2 = new Ref.IntRef();
            intRef2.element = -1;
            String value = formFieldEntry3.getValue();
            if (value != null) {
                String convertTo4DigitDate = DateUtilsKt.convertTo4DigitDate(value);
                if (convertTo4DigitDate.length() == 4) {
                    Integer intOrNull = StringsKt.toIntOrNull(StringsKt.take(convertTo4DigitDate, 2));
                    if (intOrNull != null) {
                        intRef.element = intOrNull.intValue();
                        Integer intOrNull2 = StringsKt.toIntOrNull(StringsKt.takeLast(convertTo4DigitDate, 2));
                        if (intOrNull2 != null) {
                            intRef2.element = intOrNull2.intValue();
                        } else {
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                    } else {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                }
            }
            return CollectionsKt.listOf(TuplesKt.to(this.this$0.getController().getNumberElement().getIdentifier(), formFieldEntry), TuplesKt.to(this.this$0.getController().getCvcElement().getIdentifier(), formFieldEntry2), TuplesKt.to(IdentifierSpec.CardBrand.INSTANCE, new FormFieldEntry(cardBrand.getCode(), true)), TuplesKt.to(new IdentifierSpec.Generic("exp_month"), FormFieldEntry.copy$default(formFieldEntry3, String.valueOf(intRef.element), false, 2, (Object) null)), TuplesKt.to(new IdentifierSpec.Generic("exp_year"), FormFieldEntry.copy$default(formFieldEntry3, String.valueOf(intRef2.element), false, 2, (Object) null)));
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
