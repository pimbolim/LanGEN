package com.stripe.android.connections.model;

import com.stripe.android.stripe3ds2.transactions.MessageExtension;
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
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/stripe/android/connections/model/BankAccount.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/stripe/android/connections/model/BankAccount;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* compiled from: BankAccount.kt */
public final class BankAccount$$serializer implements GeneratedSerializer<BankAccount> {
    public static final BankAccount$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        BankAccount$$serializer bankAccount$$serializer = new BankAccount$$serializer();
        INSTANCE = bankAccount$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.stripe.android.connections.model.BankAccount", bankAccount$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement(MessageExtension.FIELD_ID, false);
        pluginGeneratedSerialDescriptor.addElement("last4", false);
        pluginGeneratedSerialDescriptor.addElement("bank_name", true);
        pluginGeneratedSerialDescriptor.addElement("routing_number", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private BankAccount$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StringSerializer.INSTANCE, StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.stripe.android.connections.model.BankAccount deserialize(kotlinx.serialization.encoding.Decoder r20) {
        /*
            r19 = this;
            r0 = r20
            java.lang.String r1 = "decoder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r19.getDescriptor()
            kotlinx.serialization.encoding.CompositeDecoder r0 = r0.beginStructure(r1)
            boolean r2 = r0.decodeSequentially()
            r3 = 3
            r4 = 2
            r5 = 0
            r6 = 0
            r7 = 1
            if (r2 == 0) goto L_0x0039
            java.lang.String r2 = r0.decodeStringElement(r1, r6)
            java.lang.String r6 = r0.decodeStringElement(r1, r7)
            kotlinx.serialization.internal.StringSerializer r7 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r7 = (kotlinx.serialization.DeserializationStrategy) r7
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r7, r5)
            kotlinx.serialization.internal.StringSerializer r7 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r7 = (kotlinx.serialization.DeserializationStrategy) r7
            java.lang.Object r3 = r0.decodeNullableSerializableElement(r1, r3, r7, r5)
            r5 = 15
            r14 = r2
            r15 = r6
            r13 = 15
            goto L_0x0081
        L_0x0039:
            r2 = r5
            r8 = r2
            r9 = r8
            r10 = r9
            r5 = 0
            r11 = 1
        L_0x003f:
            if (r11 == 0) goto L_0x007c
            int r12 = r0.decodeElementIndex(r1)
            r13 = -1
            if (r12 == r13) goto L_0x007a
            if (r12 == 0) goto L_0x0073
            if (r12 == r7) goto L_0x006c
            if (r12 == r4) goto L_0x0061
            if (r12 != r3) goto L_0x005b
            kotlinx.serialization.internal.StringSerializer r12 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r12 = (kotlinx.serialization.DeserializationStrategy) r12
            java.lang.Object r10 = r0.decodeNullableSerializableElement(r1, r3, r12, r10)
            r5 = r5 | 8
            goto L_0x003f
        L_0x005b:
            kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
            r0.<init>((int) r12)
            throw r0
        L_0x0061:
            kotlinx.serialization.internal.StringSerializer r12 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r12 = (kotlinx.serialization.DeserializationStrategy) r12
            java.lang.Object r9 = r0.decodeNullableSerializableElement(r1, r4, r12, r9)
            r5 = r5 | 4
            goto L_0x003f
        L_0x006c:
            java.lang.String r8 = r0.decodeStringElement(r1, r7)
            r5 = r5 | 2
            goto L_0x003f
        L_0x0073:
            java.lang.String r2 = r0.decodeStringElement(r1, r6)
            r5 = r5 | 1
            goto L_0x003f
        L_0x007a:
            r11 = 0
            goto L_0x003f
        L_0x007c:
            r14 = r2
            r13 = r5
            r15 = r8
            r4 = r9
            r3 = r10
        L_0x0081:
            r0.endStructure(r1)
            com.stripe.android.connections.model.BankAccount r0 = new com.stripe.android.connections.model.BankAccount
            r16 = r4
            java.lang.String r16 = (java.lang.String) r16
            r17 = r3
            java.lang.String r17 = (java.lang.String) r17
            r18 = 0
            r12 = r0
            r12.<init>((int) r13, (java.lang.String) r14, (java.lang.String) r15, (java.lang.String) r16, (java.lang.String) r17, (kotlinx.serialization.internal.SerializationConstructorMarker) r18)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.connections.model.BankAccount$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):com.stripe.android.connections.model.BankAccount");
    }

    public void serialize(Encoder encoder, BankAccount bankAccount) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(bankAccount, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        BankAccount.write$Self(bankAccount, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
