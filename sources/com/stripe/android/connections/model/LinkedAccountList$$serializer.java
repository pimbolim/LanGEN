package com.stripe.android.connections.model;

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
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import me.leolin.shortcutbadger.impl.NewHtcHomeBadger;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/stripe/android/connections/model/LinkedAccountList.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/stripe/android/connections/model/LinkedAccountList;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* compiled from: LinkedAccountList.kt */
public final class LinkedAccountList$$serializer implements GeneratedSerializer<LinkedAccountList> {
    public static final LinkedAccountList$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        LinkedAccountList$$serializer linkedAccountList$$serializer = new LinkedAccountList$$serializer();
        INSTANCE = linkedAccountList$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.stripe.android.connections.model.LinkedAccountList", linkedAccountList$$serializer, 5);
        pluginGeneratedSerialDescriptor.addElement("data", false);
        pluginGeneratedSerialDescriptor.addElement("has_more", false);
        pluginGeneratedSerialDescriptor.addElement("url", false);
        pluginGeneratedSerialDescriptor.addElement(NewHtcHomeBadger.COUNT, true);
        pluginGeneratedSerialDescriptor.addElement("total_count", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private LinkedAccountList$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{new ArrayListSerializer(LinkedAccount$$serializer.INSTANCE), BooleanSerializer.INSTANCE, StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE)};
    }

    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.stripe.android.connections.model.LinkedAccountList deserialize(kotlinx.serialization.encoding.Decoder r17) {
        /*
            r16 = this;
            r0 = r17
            java.lang.String r1 = "decoder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r16.getDescriptor()
            kotlinx.serialization.encoding.CompositeDecoder r0 = r0.beginStructure(r1)
            boolean r2 = r0.decodeSequentially()
            r3 = 3
            r4 = 4
            r5 = 2
            r6 = 0
            r7 = 0
            r8 = 1
            if (r2 == 0) goto L_0x0047
            kotlinx.serialization.internal.ArrayListSerializer r2 = new kotlinx.serialization.internal.ArrayListSerializer
            com.stripe.android.connections.model.LinkedAccount$$serializer r9 = com.stripe.android.connections.model.LinkedAccount$$serializer.INSTANCE
            kotlinx.serialization.KSerializer r9 = (kotlinx.serialization.KSerializer) r9
            r2.<init>(r9)
            kotlinx.serialization.DeserializationStrategy r2 = (kotlinx.serialization.DeserializationStrategy) r2
            java.lang.Object r2 = r0.decodeSerializableElement(r1, r7, r2, r6)
            boolean r7 = r0.decodeBooleanElement(r1, r8)
            java.lang.String r5 = r0.decodeStringElement(r1, r5)
            kotlinx.serialization.internal.IntSerializer r8 = kotlinx.serialization.internal.IntSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r8 = (kotlinx.serialization.DeserializationStrategy) r8
            java.lang.Object r3 = r0.decodeNullableSerializableElement(r1, r3, r8, r6)
            kotlinx.serialization.internal.IntSerializer r8 = kotlinx.serialization.internal.IntSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r8 = (kotlinx.serialization.DeserializationStrategy) r8
            java.lang.Object r4 = r0.decodeNullableSerializableElement(r1, r4, r8, r6)
            r6 = 31
            r9 = r5
            r8 = r7
            goto L_0x00a2
        L_0x0047:
            r2 = r6
            r9 = r2
            r10 = r9
            r11 = r10
            r6 = 0
            r12 = 0
            r13 = 1
        L_0x004e:
            if (r13 == 0) goto L_0x009f
            int r14 = r0.decodeElementIndex(r1)
            r15 = -1
            if (r14 == r15) goto L_0x009d
            if (r14 == 0) goto L_0x008b
            if (r14 == r8) goto L_0x0084
            if (r14 == r5) goto L_0x007d
            if (r14 == r3) goto L_0x0072
            if (r14 != r4) goto L_0x006c
            kotlinx.serialization.internal.IntSerializer r14 = kotlinx.serialization.internal.IntSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r14 = (kotlinx.serialization.DeserializationStrategy) r14
            java.lang.Object r11 = r0.decodeNullableSerializableElement(r1, r4, r14, r11)
            r6 = r6 | 16
            goto L_0x004e
        L_0x006c:
            kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
            r0.<init>((int) r14)
            throw r0
        L_0x0072:
            kotlinx.serialization.internal.IntSerializer r14 = kotlinx.serialization.internal.IntSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r14 = (kotlinx.serialization.DeserializationStrategy) r14
            java.lang.Object r10 = r0.decodeNullableSerializableElement(r1, r3, r14, r10)
            r6 = r6 | 8
            goto L_0x004e
        L_0x007d:
            java.lang.String r9 = r0.decodeStringElement(r1, r5)
            r6 = r6 | 4
            goto L_0x004e
        L_0x0084:
            boolean r12 = r0.decodeBooleanElement(r1, r8)
            r6 = r6 | 2
            goto L_0x004e
        L_0x008b:
            kotlinx.serialization.internal.ArrayListSerializer r14 = new kotlinx.serialization.internal.ArrayListSerializer
            com.stripe.android.connections.model.LinkedAccount$$serializer r15 = com.stripe.android.connections.model.LinkedAccount$$serializer.INSTANCE
            kotlinx.serialization.KSerializer r15 = (kotlinx.serialization.KSerializer) r15
            r14.<init>(r15)
            kotlinx.serialization.DeserializationStrategy r14 = (kotlinx.serialization.DeserializationStrategy) r14
            java.lang.Object r2 = r0.decodeSerializableElement(r1, r7, r14, r2)
            r6 = r6 | 1
            goto L_0x004e
        L_0x009d:
            r13 = 0
            goto L_0x004e
        L_0x009f:
            r3 = r10
            r4 = r11
            r8 = r12
        L_0x00a2:
            r0.endStructure(r1)
            com.stripe.android.connections.model.LinkedAccountList r0 = new com.stripe.android.connections.model.LinkedAccountList
            r7 = r2
            java.util.List r7 = (java.util.List) r7
            r10 = r3
            java.lang.Integer r10 = (java.lang.Integer) r10
            r11 = r4
            java.lang.Integer r11 = (java.lang.Integer) r11
            r12 = 0
            r5 = r0
            r5.<init>((int) r6, (java.util.List) r7, (boolean) r8, (java.lang.String) r9, (java.lang.Integer) r10, (java.lang.Integer) r11, (kotlinx.serialization.internal.SerializationConstructorMarker) r12)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.connections.model.LinkedAccountList$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):com.stripe.android.connections.model.LinkedAccountList");
    }

    public void serialize(Encoder encoder, LinkedAccountList linkedAccountList) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(linkedAccountList, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        LinkedAccountList.write$Self(linkedAccountList, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
