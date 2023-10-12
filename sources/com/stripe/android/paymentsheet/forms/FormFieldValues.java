package com.stripe.android.paymentsheet.forms;

import com.stripe.android.paymentsheet.model.PaymentSelection;
import com.stripe.android.ui.core.elements.IdentifierSpec;
import com.stripe.android.ui.core.forms.FormFieldEntry;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B+\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/stripe/android/paymentsheet/forms/FormFieldValues;", "", "fieldValuePairs", "", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "Lcom/stripe/android/ui/core/forms/FormFieldEntry;", "showsMandate", "", "userRequestedReuse", "Lcom/stripe/android/paymentsheet/model/PaymentSelection$CustomerRequestedSave;", "(Ljava/util/Map;ZLcom/stripe/android/paymentsheet/model/PaymentSelection$CustomerRequestedSave;)V", "getFieldValuePairs", "()Ljava/util/Map;", "getShowsMandate", "()Z", "getUserRequestedReuse", "()Lcom/stripe/android/paymentsheet/model/PaymentSelection$CustomerRequestedSave;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FormFieldValues.kt */
public final class FormFieldValues {
    private final Map<IdentifierSpec, FormFieldEntry> fieldValuePairs;
    private final boolean showsMandate;
    private final PaymentSelection.CustomerRequestedSave userRequestedReuse;

    public FormFieldValues(Map<IdentifierSpec, FormFieldEntry> map, boolean z, PaymentSelection.CustomerRequestedSave customerRequestedSave) {
        Intrinsics.checkNotNullParameter(map, "fieldValuePairs");
        Intrinsics.checkNotNullParameter(customerRequestedSave, "userRequestedReuse");
        this.fieldValuePairs = map;
        this.showsMandate = z;
        this.userRequestedReuse = customerRequestedSave;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FormFieldValues(Map map, boolean z, PaymentSelection.CustomerRequestedSave customerRequestedSave, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? MapsKt.emptyMap() : map, z, customerRequestedSave);
    }

    public final Map<IdentifierSpec, FormFieldEntry> getFieldValuePairs() {
        return this.fieldValuePairs;
    }

    public final boolean getShowsMandate() {
        return this.showsMandate;
    }

    public final PaymentSelection.CustomerRequestedSave getUserRequestedReuse() {
        return this.userRequestedReuse;
    }
}
