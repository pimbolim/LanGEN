package com.stripe.android.ui.core.address;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/stripe/android/ui/core/address/CountryAddressSchema.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/stripe/android/ui/core/address/CountryAddressSchema;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* compiled from: TransformAddressToElement.kt */
public final class CountryAddressSchema$$serializer implements GeneratedSerializer<CountryAddressSchema> {
    public static final int $stable = 8;
    public static final CountryAddressSchema$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        CountryAddressSchema$$serializer countryAddressSchema$$serializer = new CountryAddressSchema$$serializer();
        INSTANCE = countryAddressSchema$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.stripe.android.ui.core.address.CountryAddressSchema", countryAddressSchema$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("type", false);
        pluginGeneratedSerialDescriptor.addElement("required", false);
        pluginGeneratedSerialDescriptor.addElement("schema", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private CountryAddressSchema$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(FieldTypeAsStringSerializer.INSTANCE), BooleanSerializer.INSTANCE, BuiltinSerializersKt.getNullable(FieldSchema$$serializer.INSTANCE)};
    }

    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.stripe.android.ui.core.address.CountryAddressSchema deserialize(kotlinx.serialization.encoding.Decoder r13) {
        /*
            r12 = this;
            java.lang.String r0 = "decoder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            kotlinx.serialization.descriptors.SerialDescriptor r0 = r12.getDescriptor()
            kotlinx.serialization.encoding.CompositeDecoder r13 = r13.beginStructure(r0)
            boolean r1 = r13.decodeSequentially()
            r2 = 0
            r3 = 2
            r4 = 0
            r5 = 1
            if (r1 == 0) goto L_0x002f
            com.stripe.android.ui.core.address.FieldTypeAsStringSerializer r1 = com.stripe.android.ui.core.address.FieldTypeAsStringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r1 = (kotlinx.serialization.DeserializationStrategy) r1
            java.lang.Object r1 = r13.decodeNullableSerializableElement(r0, r4, r1, r2)
            boolean r4 = r13.decodeBooleanElement(r0, r5)
            com.stripe.android.ui.core.address.FieldSchema$$serializer r5 = com.stripe.android.ui.core.address.FieldSchema$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r5 = (kotlinx.serialization.DeserializationStrategy) r5
            java.lang.Object r2 = r13.decodeNullableSerializableElement(r0, r3, r5, r2)
            r3 = 7
            r6 = r4
            r4 = 7
            goto L_0x006c
        L_0x002f:
            r1 = r2
            r6 = 0
            r7 = 0
            r8 = 1
        L_0x0033:
            if (r8 == 0) goto L_0x0067
            int r9 = r13.decodeElementIndex(r0)
            r10 = -1
            if (r9 == r10) goto L_0x0065
            if (r9 == 0) goto L_0x005a
            if (r9 == r5) goto L_0x0053
            if (r9 != r3) goto L_0x004d
            com.stripe.android.ui.core.address.FieldSchema$$serializer r9 = com.stripe.android.ui.core.address.FieldSchema$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            java.lang.Object r1 = r13.decodeNullableSerializableElement(r0, r3, r9, r1)
            r6 = r6 | 4
            goto L_0x0033
        L_0x004d:
            kotlinx.serialization.UnknownFieldException r13 = new kotlinx.serialization.UnknownFieldException
            r13.<init>((int) r9)
            throw r13
        L_0x0053:
            boolean r7 = r13.decodeBooleanElement(r0, r5)
            r6 = r6 | 2
            goto L_0x0033
        L_0x005a:
            com.stripe.android.ui.core.address.FieldTypeAsStringSerializer r9 = com.stripe.android.ui.core.address.FieldTypeAsStringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            java.lang.Object r2 = r13.decodeNullableSerializableElement(r0, r4, r9, r2)
            r6 = r6 | 1
            goto L_0x0033
        L_0x0065:
            r8 = 0
            goto L_0x0033
        L_0x0067:
            r4 = r6
            r6 = r7
            r11 = r2
            r2 = r1
            r1 = r11
        L_0x006c:
            r13.endStructure(r0)
            com.stripe.android.ui.core.address.CountryAddressSchema r13 = new com.stripe.android.ui.core.address.CountryAddressSchema
            r5 = r1
            com.stripe.android.ui.core.address.FieldType r5 = (com.stripe.android.ui.core.address.FieldType) r5
            r7 = r2
            com.stripe.android.ui.core.address.FieldSchema r7 = (com.stripe.android.ui.core.address.FieldSchema) r7
            r8 = 0
            r3 = r13
            r3.<init>((int) r4, (com.stripe.android.ui.core.address.FieldType) r5, (boolean) r6, (com.stripe.android.ui.core.address.FieldSchema) r7, (kotlinx.serialization.internal.SerializationConstructorMarker) r8)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.ui.core.address.CountryAddressSchema$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):com.stripe.android.ui.core.address.CountryAddressSchema");
    }

    public void serialize(Encoder encoder, CountryAddressSchema countryAddressSchema) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(countryAddressSchema, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        CountryAddressSchema.write$Self(countryAddressSchema, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
