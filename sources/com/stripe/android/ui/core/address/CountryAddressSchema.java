package com.stripe.android.ui.core.address;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001b\u001cB5\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fB#\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\rJ!\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aHÇ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, d2 = {"Lcom/stripe/android/ui/core/address/CountryAddressSchema;", "", "seen1", "", "type", "Lcom/stripe/android/ui/core/address/FieldType;", "required", "", "schema", "Lcom/stripe/android/ui/core/address/FieldSchema;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/stripe/android/ui/core/address/FieldType;ZLcom/stripe/android/ui/core/address/FieldSchema;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/stripe/android/ui/core/address/FieldType;ZLcom/stripe/android/ui/core/address/FieldSchema;)V", "getRequired", "()Z", "getSchema", "()Lcom/stripe/android/ui/core/address/FieldSchema;", "getType", "()Lcom/stripe/android/ui/core/address/FieldType;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Serializable
/* compiled from: TransformAddressToElement.kt */
public final class CountryAddressSchema {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final boolean required;
    private final FieldSchema schema;
    private final FieldType type;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/ui/core/address/CountryAddressSchema$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/stripe/android/ui/core/address/CountryAddressSchema;", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TransformAddressToElement.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<CountryAddressSchema> serializer() {
            return CountryAddressSchema$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ CountryAddressSchema(int i, FieldType fieldType, boolean z, FieldSchema fieldSchema, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, CountryAddressSchema$$serializer.INSTANCE.getDescriptor());
        }
        this.type = fieldType;
        this.required = z;
        if ((i & 4) == 0) {
            this.schema = null;
        } else {
            this.schema = fieldSchema;
        }
    }

    public CountryAddressSchema(FieldType fieldType, boolean z, FieldSchema fieldSchema) {
        this.type = fieldType;
        this.required = z;
        this.schema = fieldSchema;
    }

    @JvmStatic
    public static final void write$Self(CountryAddressSchema countryAddressSchema, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(countryAddressSchema, "self");
        Intrinsics.checkNotNullParameter(compositeEncoder, "output");
        Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
        boolean z = false;
        compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 0, FieldTypeAsStringSerializer.INSTANCE, countryAddressSchema.type);
        compositeEncoder.encodeBooleanElement(serialDescriptor, 1, countryAddressSchema.required);
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 2) || countryAddressSchema.schema != null) {
            z = true;
        }
        if (z) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 2, FieldSchema$$serializer.INSTANCE, countryAddressSchema.schema);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CountryAddressSchema(FieldType fieldType, boolean z, FieldSchema fieldSchema, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(fieldType, z, (i & 4) != 0 ? null : fieldSchema);
    }

    public final FieldType getType() {
        return this.type;
    }

    public final boolean getRequired() {
        return this.required;
    }

    public final FieldSchema getSchema() {
        return this.schema;
    }
}
