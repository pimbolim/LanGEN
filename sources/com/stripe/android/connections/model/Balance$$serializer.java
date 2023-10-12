package com.stripe.android.connections.model;

import com.paypal.android.sdk.onetouch.core.PayPalLineItem;
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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/stripe/android/connections/model/Balance.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/stripe/android/connections/model/Balance;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* compiled from: Balance.kt */
public final class Balance$$serializer implements GeneratedSerializer<Balance> {
    public static final Balance$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        Balance$$serializer balance$$serializer = new Balance$$serializer();
        INSTANCE = balance$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.stripe.android.connections.model.Balance", balance$$serializer, 5);
        pluginGeneratedSerialDescriptor.addElement("as_of", false);
        pluginGeneratedSerialDescriptor.addElement("current", false);
        pluginGeneratedSerialDescriptor.addElement("type", true);
        pluginGeneratedSerialDescriptor.addElement("cash", true);
        pluginGeneratedSerialDescriptor.addElement(PayPalLineItem.KIND_CREDIT, true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private Balance$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{IntSerializer.INSTANCE, new LinkedHashMapSerializer(StringSerializer.INSTANCE, IntSerializer.INSTANCE), Balance$Type$$serializer.INSTANCE, BuiltinSerializersKt.getNullable(CashBalance$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(CreditBalance$$serializer.INSTANCE)};
    }

    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.stripe.android.connections.model.Balance deserialize(kotlinx.serialization.encoding.Decoder r23) {
        /*
            r22 = this;
            r0 = r23
            java.lang.String r1 = "decoder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r22.getDescriptor()
            kotlinx.serialization.encoding.CompositeDecoder r0 = r0.beginStructure(r1)
            boolean r2 = r0.decodeSequentially()
            r3 = 3
            r4 = 4
            r5 = 2
            r6 = 0
            r7 = 0
            r8 = 1
            if (r2 == 0) goto L_0x0052
            int r2 = r0.decodeIntElement(r1, r7)
            kotlinx.serialization.internal.LinkedHashMapSerializer r7 = new kotlinx.serialization.internal.LinkedHashMapSerializer
            kotlinx.serialization.internal.StringSerializer r9 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.KSerializer r9 = (kotlinx.serialization.KSerializer) r9
            kotlinx.serialization.internal.IntSerializer r10 = kotlinx.serialization.internal.IntSerializer.INSTANCE
            kotlinx.serialization.KSerializer r10 = (kotlinx.serialization.KSerializer) r10
            r7.<init>(r9, r10)
            kotlinx.serialization.DeserializationStrategy r7 = (kotlinx.serialization.DeserializationStrategy) r7
            java.lang.Object r7 = r0.decodeSerializableElement(r1, r8, r7, r6)
            com.stripe.android.connections.model.Balance$Type$$serializer r8 = com.stripe.android.connections.model.Balance$Type$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r8 = (kotlinx.serialization.DeserializationStrategy) r8
            java.lang.Object r5 = r0.decodeSerializableElement(r1, r5, r8, r6)
            com.stripe.android.connections.model.CashBalance$$serializer r8 = com.stripe.android.connections.model.CashBalance$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r8 = (kotlinx.serialization.DeserializationStrategy) r8
            java.lang.Object r3 = r0.decodeNullableSerializableElement(r1, r3, r8, r6)
            com.stripe.android.connections.model.CreditBalance$$serializer r8 = com.stripe.android.connections.model.CreditBalance$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r8 = (kotlinx.serialization.DeserializationStrategy) r8
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r8, r6)
            r6 = 31
            r16 = r2
            r15 = 31
            goto L_0x00bc
        L_0x0052:
            r9 = r6
            r10 = r9
            r11 = r10
            r12 = r11
            r2 = 0
            r6 = 0
            r13 = 1
        L_0x0059:
            if (r13 == 0) goto L_0x00b5
            int r14 = r0.decodeElementIndex(r1)
            r15 = -1
            if (r14 == r15) goto L_0x00b3
            if (r14 == 0) goto L_0x00ab
            if (r14 == r8) goto L_0x0093
            if (r14 == r5) goto L_0x0088
            if (r14 == r3) goto L_0x007d
            if (r14 != r4) goto L_0x0077
            com.stripe.android.connections.model.CreditBalance$$serializer r14 = com.stripe.android.connections.model.CreditBalance$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r14 = (kotlinx.serialization.DeserializationStrategy) r14
            java.lang.Object r12 = r0.decodeNullableSerializableElement(r1, r4, r14, r12)
            r6 = r6 | 16
            goto L_0x0059
        L_0x0077:
            kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
            r0.<init>((int) r14)
            throw r0
        L_0x007d:
            com.stripe.android.connections.model.CashBalance$$serializer r14 = com.stripe.android.connections.model.CashBalance$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r14 = (kotlinx.serialization.DeserializationStrategy) r14
            java.lang.Object r11 = r0.decodeNullableSerializableElement(r1, r3, r14, r11)
            r6 = r6 | 8
            goto L_0x0059
        L_0x0088:
            com.stripe.android.connections.model.Balance$Type$$serializer r14 = com.stripe.android.connections.model.Balance$Type$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r14 = (kotlinx.serialization.DeserializationStrategy) r14
            java.lang.Object r10 = r0.decodeSerializableElement(r1, r5, r14, r10)
            r6 = r6 | 4
            goto L_0x0059
        L_0x0093:
            kotlinx.serialization.internal.LinkedHashMapSerializer r14 = new kotlinx.serialization.internal.LinkedHashMapSerializer
            kotlinx.serialization.internal.StringSerializer r15 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.KSerializer r15 = (kotlinx.serialization.KSerializer) r15
            kotlinx.serialization.internal.IntSerializer r16 = kotlinx.serialization.internal.IntSerializer.INSTANCE
            r3 = r16
            kotlinx.serialization.KSerializer r3 = (kotlinx.serialization.KSerializer) r3
            r14.<init>(r15, r3)
            kotlinx.serialization.DeserializationStrategy r14 = (kotlinx.serialization.DeserializationStrategy) r14
            java.lang.Object r9 = r0.decodeSerializableElement(r1, r8, r14, r9)
            r6 = r6 | 2
            goto L_0x00b1
        L_0x00ab:
            int r2 = r0.decodeIntElement(r1, r7)
            r6 = r6 | 1
        L_0x00b1:
            r3 = 3
            goto L_0x0059
        L_0x00b3:
            r13 = 0
            goto L_0x0059
        L_0x00b5:
            r16 = r2
            r15 = r6
            r7 = r9
            r5 = r10
            r3 = r11
            r4 = r12
        L_0x00bc:
            r0.endStructure(r1)
            com.stripe.android.connections.model.Balance r0 = new com.stripe.android.connections.model.Balance
            r17 = r7
            java.util.Map r17 = (java.util.Map) r17
            r18 = r5
            com.stripe.android.connections.model.Balance$Type r18 = (com.stripe.android.connections.model.Balance.Type) r18
            r19 = r3
            com.stripe.android.connections.model.CashBalance r19 = (com.stripe.android.connections.model.CashBalance) r19
            r20 = r4
            com.stripe.android.connections.model.CreditBalance r20 = (com.stripe.android.connections.model.CreditBalance) r20
            r21 = 0
            r14 = r0
            r14.<init>((int) r15, (int) r16, (java.util.Map) r17, (com.stripe.android.connections.model.Balance.Type) r18, (com.stripe.android.connections.model.CashBalance) r19, (com.stripe.android.connections.model.CreditBalance) r20, (kotlinx.serialization.internal.SerializationConstructorMarker) r21)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.connections.model.Balance$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):com.stripe.android.connections.model.Balance");
    }

    public void serialize(Encoder encoder, Balance balance) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(balance, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        Balance.write$Self(balance, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
