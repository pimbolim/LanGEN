package com.stripe.android.connections.model;

import com.stripe.android.connections.model.serializer.PaymentAccountSerializer;
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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/stripe/android/connections/model/LinkAccountSession.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/stripe/android/connections/model/LinkAccountSession;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* compiled from: LinkAccountSession.kt */
public final class LinkAccountSession$$serializer implements GeneratedSerializer<LinkAccountSession> {
    public static final LinkAccountSession$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        LinkAccountSession$$serializer linkAccountSession$$serializer = new LinkAccountSession$$serializer();
        INSTANCE = linkAccountSession$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.stripe.android.connections.model.LinkAccountSession", linkAccountSession$$serializer, 6);
        pluginGeneratedSerialDescriptor.addElement("client_secret", false);
        pluginGeneratedSerialDescriptor.addElement(MessageExtension.FIELD_ID, false);
        pluginGeneratedSerialDescriptor.addElement("linked_accounts", false);
        pluginGeneratedSerialDescriptor.addElement("livemode", false);
        pluginGeneratedSerialDescriptor.addElement("payment_account", true);
        pluginGeneratedSerialDescriptor.addElement("return_url", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private LinkAccountSession$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StringSerializer.INSTANCE, StringSerializer.INSTANCE, LinkedAccountList$$serializer.INSTANCE, BooleanSerializer.INSTANCE, BuiltinSerializersKt.getNullable(PaymentAccountSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.stripe.android.connections.model.LinkAccountSession deserialize(kotlinx.serialization.encoding.Decoder r20) {
        /*
            r19 = this;
            r0 = r20
            java.lang.String r1 = "decoder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r19.getDescriptor()
            kotlinx.serialization.encoding.CompositeDecoder r0 = r0.beginStructure(r1)
            boolean r2 = r0.decodeSequentially()
            r3 = 5
            r4 = 3
            r5 = 4
            r6 = 2
            r7 = 1
            r8 = 0
            r9 = 0
            if (r2 == 0) goto L_0x0049
            java.lang.String r2 = r0.decodeStringElement(r1, r9)
            java.lang.String r7 = r0.decodeStringElement(r1, r7)
            com.stripe.android.connections.model.LinkedAccountList$$serializer r9 = com.stripe.android.connections.model.LinkedAccountList$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            java.lang.Object r6 = r0.decodeSerializableElement(r1, r6, r9, r8)
            boolean r4 = r0.decodeBooleanElement(r1, r4)
            com.stripe.android.connections.model.serializer.PaymentAccountSerializer r9 = com.stripe.android.connections.model.serializer.PaymentAccountSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            java.lang.Object r5 = r0.decodeNullableSerializableElement(r1, r5, r9, r8)
            kotlinx.serialization.internal.StringSerializer r9 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            java.lang.Object r3 = r0.decodeNullableSerializableElement(r1, r3, r9, r8)
            r8 = 63
            r12 = r2
            r15 = r4
            r13 = r7
            r11 = 63
            goto L_0x00a2
        L_0x0049:
            r10 = r8
            r11 = r10
            r12 = r11
            r13 = r12
            r14 = r13
            r2 = 0
            r8 = 0
            r15 = 1
        L_0x0051:
            if (r15 == 0) goto L_0x009b
            int r9 = r0.decodeElementIndex(r1)
            switch(r9) {
                case -1: goto L_0x0098;
                case 0: goto L_0x0090;
                case 1: goto L_0x0088;
                case 2: goto L_0x007d;
                case 3: goto L_0x0076;
                case 4: goto L_0x006b;
                case 5: goto L_0x0060;
                default: goto L_0x005a;
            }
        L_0x005a:
            kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
            r0.<init>((int) r9)
            throw r0
        L_0x0060:
            kotlinx.serialization.internal.StringSerializer r9 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            java.lang.Object r14 = r0.decodeNullableSerializableElement(r1, r3, r9, r14)
            r8 = r8 | 32
            goto L_0x008e
        L_0x006b:
            com.stripe.android.connections.model.serializer.PaymentAccountSerializer r9 = com.stripe.android.connections.model.serializer.PaymentAccountSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            java.lang.Object r13 = r0.decodeNullableSerializableElement(r1, r5, r9, r13)
            r8 = r8 | 16
            goto L_0x008e
        L_0x0076:
            boolean r2 = r0.decodeBooleanElement(r1, r4)
            r8 = r8 | 8
            goto L_0x008e
        L_0x007d:
            com.stripe.android.connections.model.LinkedAccountList$$serializer r9 = com.stripe.android.connections.model.LinkedAccountList$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            java.lang.Object r12 = r0.decodeSerializableElement(r1, r6, r9, r12)
            r8 = r8 | 4
            goto L_0x008e
        L_0x0088:
            java.lang.String r11 = r0.decodeStringElement(r1, r7)
            r8 = r8 | 2
        L_0x008e:
            r9 = 0
            goto L_0x0051
        L_0x0090:
            r9 = 0
            java.lang.String r10 = r0.decodeStringElement(r1, r9)
            r8 = r8 | 1
            goto L_0x0051
        L_0x0098:
            r9 = 0
            r15 = 0
            goto L_0x0051
        L_0x009b:
            r15 = r2
            r6 = r12
            r5 = r13
            r3 = r14
            r12 = r10
            r13 = r11
            r11 = r8
        L_0x00a2:
            r0.endStructure(r1)
            com.stripe.android.connections.model.LinkAccountSession r0 = new com.stripe.android.connections.model.LinkAccountSession
            r14 = r6
            com.stripe.android.connections.model.LinkedAccountList r14 = (com.stripe.android.connections.model.LinkedAccountList) r14
            r16 = r5
            com.stripe.android.connections.model.PaymentAccount r16 = (com.stripe.android.connections.model.PaymentAccount) r16
            r17 = r3
            java.lang.String r17 = (java.lang.String) r17
            r18 = 0
            r10 = r0
            r10.<init>((int) r11, (java.lang.String) r12, (java.lang.String) r13, (com.stripe.android.connections.model.LinkedAccountList) r14, (boolean) r15, (com.stripe.android.connections.model.PaymentAccount) r16, (java.lang.String) r17, (kotlinx.serialization.internal.SerializationConstructorMarker) r18)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.connections.model.LinkAccountSession$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):com.stripe.android.connections.model.LinkAccountSession");
    }

    public void serialize(Encoder encoder, LinkAccountSession linkAccountSession) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(linkAccountSession, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        LinkAccountSession.write$Self(linkAccountSession, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
