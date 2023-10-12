package com.stripe.android.ui.core.elements;

import android.content.Context;
import com.henninghall.date_picker.props.DateProp;
import com.stripe.android.ui.core.elements.IdentifierSpec;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001c\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u0013X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/stripe/android/ui/core/elements/CardDetailsController;", "Lcom/stripe/android/ui/core/elements/SectionFieldErrorController;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "cvcElement", "Lcom/stripe/android/ui/core/elements/CvcElement;", "getCvcElement", "()Lcom/stripe/android/ui/core/elements/CvcElement;", "error", "Lkotlinx/coroutines/flow/Flow;", "Lcom/stripe/android/ui/core/elements/FieldError;", "getError", "()Lkotlinx/coroutines/flow/Flow;", "expirationDateElement", "Lcom/stripe/android/ui/core/elements/SimpleTextElement;", "getExpirationDateElement", "()Lcom/stripe/android/ui/core/elements/SimpleTextElement;", "fields", "", "Lcom/stripe/android/ui/core/elements/SectionFieldElement;", "getFields", "()Ljava/util/List;", "label", "", "getLabel", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "numberElement", "Lcom/stripe/android/ui/core/elements/CardNumberElement;", "getNumberElement", "()Lcom/stripe/android/ui/core/elements/CardNumberElement;", "rowFields", "Lcom/stripe/android/ui/core/elements/SectionSingleFieldElement;", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CardDetailsController.kt */
public final class CardDetailsController implements SectionFieldErrorController {
    private final CvcElement cvcElement;
    private final Flow<FieldError> error;
    private final SimpleTextElement expirationDateElement;
    private final List<SectionFieldElement> fields;
    private final Integer label;
    private final CardNumberElement numberElement;
    private final List<SectionSingleFieldElement> rowFields;

    public CardDetailsController(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        CardNumberElement cardNumberElement = new CardNumberElement(IdentifierSpec.CardNumber.INSTANCE, new CardNumberController(new CardNumberConfig(), context));
        this.numberElement = cardNumberElement;
        CvcElement cvcElement2 = new CvcElement(new IdentifierSpec.Generic("cvc"), new CvcController(new CvcConfig(), cardNumberElement.getController().getCardBrandFlow$payments_ui_core_release(), false, 4, (DefaultConstructorMarker) null));
        this.cvcElement = cvcElement2;
        SimpleTextElement simpleTextElement = new SimpleTextElement(new IdentifierSpec.Generic(DateProp.name), new SimpleTextFieldController(new DateConfig(), false, (String) null, 6, (DefaultConstructorMarker) null));
        this.expirationDateElement = simpleTextElement;
        List<SectionSingleFieldElement> listOf = CollectionsKt.listOf(simpleTextElement, cvcElement2);
        this.rowFields = listOf;
        this.fields = CollectionsKt.listOf(cardNumberElement, new RowElement(new IdentifierSpec.Generic(Intrinsics.stringPlus("row_", Long.valueOf(UUID.randomUUID().getLeastSignificantBits()))), listOf, new RowController(listOf)));
        Iterable<SectionSingleFieldElement> listOf2 = CollectionsKt.listOf(cardNumberElement, simpleTextElement, cvcElement2);
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listOf2, 10));
        for (SectionSingleFieldElement controller : listOf2) {
            arrayList.add(controller.getController());
        }
        Iterable<InputController> iterable = (List) arrayList;
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (InputController error2 : iterable) {
            arrayList2.add(error2.getError());
        }
        Object[] array = CollectionsKt.toList((List) arrayList2).toArray(new Flow[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        this.error = new CardDetailsController$special$$inlined$combine$1((Flow[]) array);
    }

    public final Integer getLabel() {
        return this.label;
    }

    public final CardNumberElement getNumberElement() {
        return this.numberElement;
    }

    public final CvcElement getCvcElement() {
        return this.cvcElement;
    }

    public final SimpleTextElement getExpirationDateElement() {
        return this.expirationDateElement;
    }

    public final List<SectionFieldElement> getFields() {
        return this.fields;
    }

    public Flow<FieldError> getError() {
        return this.error;
    }
}
