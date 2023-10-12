package com.stripe.android.ui.core.address;

import androidx.compose.ui.text.input.KeyboardCapitalization;
import com.braintreepayments.api.models.PostalAddressParser;
import com.stripe.android.ui.core.R;
import com.stripe.android.ui.core.elements.IdentifierSpec;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0001\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0019B,\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\tø\u0001\u0000¢\u0006\u0002\u0010\nR\u001c\u0010\b\u001a\u00020\tø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001a"}, d2 = {"Lcom/stripe/android/ui/core/address/FieldType;", "", "serializedValue", "", "identifierSpec", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "defaultLabel", "", "capitalization", "Landroidx/compose/ui/text/input/KeyboardCapitalization;", "(Ljava/lang/String;ILjava/lang/String;Lcom/stripe/android/ui/core/elements/IdentifierSpec;II)V", "getCapitalization-IUNYP9k", "()I", "I", "getDefaultLabel", "getIdentifierSpec", "()Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "getSerializedValue", "()Ljava/lang/String;", "AddressLine1", "AddressLine2", "Locality", "PostalCode", "AdministrativeArea", "Name", "Companion", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Serializable(with = FieldTypeAsStringSerializer.class)
/* compiled from: TransformAddressToElement.kt */
public enum FieldType {
    AddressLine1("addressLine1", IdentifierSpec.Line1.INSTANCE, R.string.address_label_address_line1, KeyboardCapitalization.Companion.m3667getWordsIUNYP9k()),
    AddressLine2("addressLine2", IdentifierSpec.Line2.INSTANCE, R.string.address_label_address_line2, KeyboardCapitalization.Companion.m3667getWordsIUNYP9k()),
    Locality(PostalAddressParser.USER_ADDRESS_LOCALITY_KEY, IdentifierSpec.City.INSTANCE, R.string.address_label_city, KeyboardCapitalization.Companion.m3667getWordsIUNYP9k()),
    PostalCode("postalCode", IdentifierSpec.PostalCode.INSTANCE, R.string.address_label_postal_code, KeyboardCapitalization.Companion.m3665getNoneIUNYP9k()),
    AdministrativeArea(PostalAddressParser.USER_ADDRESS_ADMINISTRATIVE_AREA_KEY, IdentifierSpec.State.INSTANCE, NameType.state.getStringResId(), KeyboardCapitalization.Companion.m3667getWordsIUNYP9k()),
    Name("name", IdentifierSpec.Name.INSTANCE, R.string.address_label_name, KeyboardCapitalization.Companion.m3667getWordsIUNYP9k());
    
    public static final Companion Companion = null;
    private final int capitalization;
    private final int defaultLabel;
    private final IdentifierSpec identifierSpec;
    private final String serializedValue;

    private FieldType(String str, IdentifierSpec identifierSpec2, int i, int i2) {
        this.serializedValue = str;
        this.identifierSpec = identifierSpec2;
        this.defaultLabel = i;
        this.capitalization = i2;
    }

    public final String getSerializedValue() {
        return this.serializedValue;
    }

    public final IdentifierSpec getIdentifierSpec() {
        return this.identifierSpec;
    }

    public final int getDefaultLabel() {
        return this.defaultLabel;
    }

    /* renamed from: getCapitalization-IUNYP9k  reason: not valid java name */
    public final int m4549getCapitalizationIUNYP9k() {
        return this.capitalization;
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\bHÆ\u0001¨\u0006\t"}, d2 = {"Lcom/stripe/android/ui/core/address/FieldType$Companion;", "", "()V", "from", "Lcom/stripe/android/ui/core/address/FieldType;", "value", "", "serializer", "Lkotlinx/serialization/KSerializer;", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TransformAddressToElement.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<FieldType> serializer() {
            return FieldTypeAsStringSerializer.INSTANCE;
        }

        public final FieldType from(String str) {
            Intrinsics.checkNotNullParameter(str, "value");
            FieldType[] values = FieldType.values();
            int length = values.length;
            int i = 0;
            while (i < length) {
                FieldType fieldType = values[i];
                i++;
                if (Intrinsics.areEqual((Object) fieldType.getSerializedValue(), (Object) str)) {
                    return fieldType;
                }
            }
            return null;
        }
    }
}
