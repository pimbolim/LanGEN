package com.stripe.android.ui.core.address;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.EnumSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/stripe/android/ui/core/address/FieldSchema.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/stripe/android/ui/core/address/FieldSchema;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* compiled from: TransformAddressToElement.kt */
public final class FieldSchema$$serializer implements GeneratedSerializer<FieldSchema> {
    public static final int $stable = 8;
    public static final FieldSchema$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FieldSchema$$serializer fieldSchema$$serializer = new FieldSchema$$serializer();
        INSTANCE = fieldSchema$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.stripe.android.ui.core.address.FieldSchema", fieldSchema$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("isNumeric", true);
        pluginGeneratedSerialDescriptor.addElement("examples", true);
        pluginGeneratedSerialDescriptor.addElement("nameType", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private FieldSchema$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BooleanSerializer.INSTANCE, new ArrayListSerializer(StringSerializer.INSTANCE), new EnumSerializer("com.stripe.android.ui.core.address.NameType", (Enum[]) NameType.values())};
    }

    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.stripe.android.ui.core.address.FieldSchema deserialize(kotlinx.serialization.encoding.Decoder r18) {
        /*
            r17 = this;
            r0 = r18
            java.lang.String r1 = "decoder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r17.getDescriptor()
            kotlinx.serialization.encoding.CompositeDecoder r0 = r0.beginStructure(r1)
            boolean r2 = r0.decodeSequentially()
            java.lang.String r3 = "com.stripe.android.ui.core.address.NameType"
            r4 = 0
            r5 = 2
            r6 = 0
            r7 = 1
            if (r2 == 0) goto L_0x0043
            boolean r2 = r0.decodeBooleanElement(r1, r6)
            kotlinx.serialization.internal.ArrayListSerializer r6 = new kotlinx.serialization.internal.ArrayListSerializer
            kotlinx.serialization.internal.StringSerializer r8 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.KSerializer r8 = (kotlinx.serialization.KSerializer) r8
            r6.<init>(r8)
            kotlinx.serialization.DeserializationStrategy r6 = (kotlinx.serialization.DeserializationStrategy) r6
            java.lang.Object r6 = r0.decodeSerializableElement(r1, r7, r6, r4)
            kotlinx.serialization.internal.EnumSerializer r7 = new kotlinx.serialization.internal.EnumSerializer
            com.stripe.android.ui.core.address.NameType[] r8 = com.stripe.android.ui.core.address.NameType.values()
            java.lang.Enum[] r8 = (java.lang.Enum[]) r8
            r7.<init>(r3, r8)
            kotlinx.serialization.DeserializationStrategy r7 = (kotlinx.serialization.DeserializationStrategy) r7
            java.lang.Object r3 = r0.decodeSerializableElement(r1, r5, r7, r4)
            r4 = 7
            r13 = r2
            r12 = 7
            goto L_0x0090
        L_0x0043:
            r8 = r4
            r9 = r8
            r2 = 0
            r4 = 0
            r10 = 1
        L_0x0048:
            if (r10 == 0) goto L_0x008c
            int r11 = r0.decodeElementIndex(r1)
            r12 = -1
            if (r11 == r12) goto L_0x008a
            if (r11 == 0) goto L_0x0083
            if (r11 == r7) goto L_0x0071
            if (r11 != r5) goto L_0x006b
            kotlinx.serialization.internal.EnumSerializer r11 = new kotlinx.serialization.internal.EnumSerializer
            com.stripe.android.ui.core.address.NameType[] r12 = com.stripe.android.ui.core.address.NameType.values()
            java.lang.Enum[] r12 = (java.lang.Enum[]) r12
            r11.<init>(r3, r12)
            kotlinx.serialization.DeserializationStrategy r11 = (kotlinx.serialization.DeserializationStrategy) r11
            java.lang.Object r9 = r0.decodeSerializableElement(r1, r5, r11, r9)
            r4 = r4 | 4
            goto L_0x0048
        L_0x006b:
            kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
            r0.<init>((int) r11)
            throw r0
        L_0x0071:
            kotlinx.serialization.internal.ArrayListSerializer r11 = new kotlinx.serialization.internal.ArrayListSerializer
            kotlinx.serialization.internal.StringSerializer r12 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.KSerializer r12 = (kotlinx.serialization.KSerializer) r12
            r11.<init>(r12)
            kotlinx.serialization.DeserializationStrategy r11 = (kotlinx.serialization.DeserializationStrategy) r11
            java.lang.Object r8 = r0.decodeSerializableElement(r1, r7, r11, r8)
            r4 = r4 | 2
            goto L_0x0048
        L_0x0083:
            boolean r2 = r0.decodeBooleanElement(r1, r6)
            r4 = r4 | 1
            goto L_0x0048
        L_0x008a:
            r10 = 0
            goto L_0x0048
        L_0x008c:
            r13 = r2
            r12 = r4
            r6 = r8
            r3 = r9
        L_0x0090:
            r0.endStructure(r1)
            com.stripe.android.ui.core.address.FieldSchema r0 = new com.stripe.android.ui.core.address.FieldSchema
            r14 = r6
            java.util.List r14 = (java.util.List) r14
            r15 = r3
            com.stripe.android.ui.core.address.NameType r15 = (com.stripe.android.ui.core.address.NameType) r15
            r16 = 0
            r11 = r0
            r11.<init>((int) r12, (boolean) r13, (java.util.List) r14, (com.stripe.android.ui.core.address.NameType) r15, (kotlinx.serialization.internal.SerializationConstructorMarker) r16)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.ui.core.address.FieldSchema$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):com.stripe.android.ui.core.address.FieldSchema");
    }

    public void serialize(Encoder encoder, FieldSchema fieldSchema) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(fieldSchema, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        FieldSchema.write$Self(fieldSchema, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
