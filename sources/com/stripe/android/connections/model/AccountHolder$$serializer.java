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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/stripe/android/connections/model/AccountHolder.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/stripe/android/connections/model/AccountHolder;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* compiled from: AccountHolder.kt */
public final class AccountHolder$$serializer implements GeneratedSerializer<AccountHolder> {
    public static final AccountHolder$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        AccountHolder$$serializer accountHolder$$serializer = new AccountHolder$$serializer();
        INSTANCE = accountHolder$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.stripe.android.connections.model.AccountHolder", accountHolder$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("type", true);
        pluginGeneratedSerialDescriptor.addElement("account", true);
        pluginGeneratedSerialDescriptor.addElement("customer", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private AccountHolder$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{AccountHolder$Type$$serializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.stripe.android.connections.model.AccountHolder deserialize(kotlinx.serialization.encoding.Decoder r12) {
        /*
            r11 = this;
            java.lang.String r0 = "decoder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            kotlinx.serialization.descriptors.SerialDescriptor r0 = r11.getDescriptor()
            kotlinx.serialization.encoding.CompositeDecoder r12 = r12.beginStructure(r0)
            boolean r1 = r12.decodeSequentially()
            r2 = 0
            r3 = 2
            r4 = 0
            r5 = 1
            if (r1 == 0) goto L_0x0033
            com.stripe.android.connections.model.AccountHolder$Type$$serializer r1 = com.stripe.android.connections.model.AccountHolder$Type$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r1 = (kotlinx.serialization.DeserializationStrategy) r1
            java.lang.Object r1 = r12.decodeSerializableElement(r0, r4, r1, r2)
            kotlinx.serialization.internal.StringSerializer r4 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r4 = (kotlinx.serialization.DeserializationStrategy) r4
            java.lang.Object r4 = r12.decodeNullableSerializableElement(r0, r5, r4, r2)
            kotlinx.serialization.internal.StringSerializer r5 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r5 = (kotlinx.serialization.DeserializationStrategy) r5
            java.lang.Object r2 = r12.decodeNullableSerializableElement(r0, r3, r5, r2)
            r3 = 7
            r3 = r4
            r4 = 7
            goto L_0x0073
        L_0x0033:
            r1 = r2
            r6 = r1
            r7 = 0
            r8 = 1
        L_0x0037:
            if (r8 == 0) goto L_0x006f
            int r9 = r12.decodeElementIndex(r0)
            r10 = -1
            if (r9 == r10) goto L_0x006d
            if (r9 == 0) goto L_0x0062
            if (r9 == r5) goto L_0x0057
            if (r9 != r3) goto L_0x0051
            kotlinx.serialization.internal.StringSerializer r9 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            java.lang.Object r6 = r12.decodeNullableSerializableElement(r0, r3, r9, r6)
            r7 = r7 | 4
            goto L_0x0037
        L_0x0051:
            kotlinx.serialization.UnknownFieldException r12 = new kotlinx.serialization.UnknownFieldException
            r12.<init>((int) r9)
            throw r12
        L_0x0057:
            kotlinx.serialization.internal.StringSerializer r9 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            java.lang.Object r1 = r12.decodeNullableSerializableElement(r0, r5, r9, r1)
            r7 = r7 | 2
            goto L_0x0037
        L_0x0062:
            com.stripe.android.connections.model.AccountHolder$Type$$serializer r9 = com.stripe.android.connections.model.AccountHolder$Type$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r9 = (kotlinx.serialization.DeserializationStrategy) r9
            java.lang.Object r2 = r12.decodeSerializableElement(r0, r4, r9, r2)
            r7 = r7 | 1
            goto L_0x0037
        L_0x006d:
            r8 = 0
            goto L_0x0037
        L_0x006f:
            r3 = r1
            r1 = r2
            r2 = r6
            r4 = r7
        L_0x0073:
            r12.endStructure(r0)
            com.stripe.android.connections.model.AccountHolder r12 = new com.stripe.android.connections.model.AccountHolder
            r5 = r1
            com.stripe.android.connections.model.AccountHolder$Type r5 = (com.stripe.android.connections.model.AccountHolder.Type) r5
            r6 = r3
            java.lang.String r6 = (java.lang.String) r6
            r7 = r2
            java.lang.String r7 = (java.lang.String) r7
            r8 = 0
            r3 = r12
            r3.<init>((int) r4, (com.stripe.android.connections.model.AccountHolder.Type) r5, (java.lang.String) r6, (java.lang.String) r7, (kotlinx.serialization.internal.SerializationConstructorMarker) r8)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.connections.model.AccountHolder$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):com.stripe.android.connections.model.AccountHolder");
    }

    public void serialize(Encoder encoder, AccountHolder accountHolder) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(accountHolder, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        AccountHolder.write$Self(accountHolder, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
