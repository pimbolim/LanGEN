package com.stripe.android.connections.model;

import androidx.core.app.NotificationCompat;
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
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/stripe/android/connections/model/LinkedAccount.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/stripe/android/connections/model/LinkedAccount;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* compiled from: LinkedAccount.kt */
public final class LinkedAccount$$serializer implements GeneratedSerializer<LinkedAccount> {
    public static final LinkedAccount$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        LinkedAccount$$serializer linkedAccount$$serializer = new LinkedAccount$$serializer();
        INSTANCE = linkedAccount$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.stripe.android.connections.model.LinkedAccount", linkedAccount$$serializer, 16);
        pluginGeneratedSerialDescriptor.addElement("category", true);
        pluginGeneratedSerialDescriptor.addElement("created", false);
        pluginGeneratedSerialDescriptor.addElement(MessageExtension.FIELD_ID, false);
        pluginGeneratedSerialDescriptor.addElement("institution_name", false);
        pluginGeneratedSerialDescriptor.addElement("livemode", false);
        pluginGeneratedSerialDescriptor.addElement(NotificationCompat.CATEGORY_STATUS, true);
        pluginGeneratedSerialDescriptor.addElement("subcategory", true);
        pluginGeneratedSerialDescriptor.addElement("supported_payment_method_types", false);
        pluginGeneratedSerialDescriptor.addElement("accountholder", true);
        pluginGeneratedSerialDescriptor.addElement("balance", true);
        pluginGeneratedSerialDescriptor.addElement("balance_refresh", true);
        pluginGeneratedSerialDescriptor.addElement("display_name", true);
        pluginGeneratedSerialDescriptor.addElement("last4", true);
        pluginGeneratedSerialDescriptor.addElement("ownership", true);
        pluginGeneratedSerialDescriptor.addElement("ownership_refresh", true);
        pluginGeneratedSerialDescriptor.addElement("permissions", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private LinkedAccount$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{LinkedAccount$Category$$serializer.INSTANCE, IntSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, BooleanSerializer.INSTANCE, LinkedAccount$Status$$serializer.INSTANCE, LinkedAccount$Subcategory$$serializer.INSTANCE, new ArrayListSerializer(LinkedAccount$SupportedPaymentMethodTypes$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(AccountHolder$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(Balance$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(BalanceRefresh$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(OwnershipRefresh$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(new ArrayListSerializer(LinkedAccount$Permissions$$serializer.INSTANCE))};
    }

    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.stripe.android.connections.model.LinkedAccount deserialize(kotlinx.serialization.encoding.Decoder r39) {
        /*
            r38 = this;
            r0 = r39
            java.lang.String r1 = "decoder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            kotlinx.serialization.descriptors.SerialDescriptor r1 = r38.getDescriptor()
            kotlinx.serialization.encoding.CompositeDecoder r0 = r0.beginStructure(r1)
            boolean r2 = r0.decodeSequentially()
            r8 = 10
            r9 = 9
            r10 = 7
            r11 = 6
            r12 = 5
            r13 = 3
            r14 = 8
            r15 = 4
            r3 = 2
            r4 = 1
            r5 = 0
            r6 = 0
            if (r2 == 0) goto L_0x00d0
            com.stripe.android.connections.model.LinkedAccount$Category$$serializer r2 = com.stripe.android.connections.model.LinkedAccount$Category$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r2 = (kotlinx.serialization.DeserializationStrategy) r2
            java.lang.Object r2 = r0.decodeSerializableElement(r1, r5, r2, r6)
            int r4 = r0.decodeIntElement(r1, r4)
            java.lang.String r3 = r0.decodeStringElement(r1, r3)
            java.lang.String r5 = r0.decodeStringElement(r1, r13)
            boolean r13 = r0.decodeBooleanElement(r1, r15)
            com.stripe.android.connections.model.LinkedAccount$Status$$serializer r15 = com.stripe.android.connections.model.LinkedAccount$Status$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r15 = (kotlinx.serialization.DeserializationStrategy) r15
            java.lang.Object r12 = r0.decodeSerializableElement(r1, r12, r15, r6)
            com.stripe.android.connections.model.LinkedAccount$Subcategory$$serializer r15 = com.stripe.android.connections.model.LinkedAccount$Subcategory$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r15 = (kotlinx.serialization.DeserializationStrategy) r15
            java.lang.Object r11 = r0.decodeSerializableElement(r1, r11, r15, r6)
            kotlinx.serialization.internal.ArrayListSerializer r15 = new kotlinx.serialization.internal.ArrayListSerializer
            com.stripe.android.connections.model.LinkedAccount$SupportedPaymentMethodTypes$$serializer r19 = com.stripe.android.connections.model.LinkedAccount$SupportedPaymentMethodTypes$$serializer.INSTANCE
            r7 = r19
            kotlinx.serialization.KSerializer r7 = (kotlinx.serialization.KSerializer) r7
            r15.<init>(r7)
            kotlinx.serialization.DeserializationStrategy r15 = (kotlinx.serialization.DeserializationStrategy) r15
            java.lang.Object r7 = r0.decodeSerializableElement(r1, r10, r15, r6)
            com.stripe.android.connections.model.AccountHolder$$serializer r10 = com.stripe.android.connections.model.AccountHolder$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r10 = (kotlinx.serialization.DeserializationStrategy) r10
            java.lang.Object r10 = r0.decodeNullableSerializableElement(r1, r14, r10, r6)
            com.stripe.android.connections.model.Balance$$serializer r14 = com.stripe.android.connections.model.Balance$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r14 = (kotlinx.serialization.DeserializationStrategy) r14
            java.lang.Object r9 = r0.decodeNullableSerializableElement(r1, r9, r14, r6)
            com.stripe.android.connections.model.BalanceRefresh$$serializer r14 = com.stripe.android.connections.model.BalanceRefresh$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r14 = (kotlinx.serialization.DeserializationStrategy) r14
            java.lang.Object r8 = r0.decodeNullableSerializableElement(r1, r8, r14, r6)
            kotlinx.serialization.internal.StringSerializer r14 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r14 = (kotlinx.serialization.DeserializationStrategy) r14
            r15 = 11
            java.lang.Object r14 = r0.decodeNullableSerializableElement(r1, r15, r14, r6)
            kotlinx.serialization.internal.StringSerializer r15 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r15 = (kotlinx.serialization.DeserializationStrategy) r15
            r19 = r2
            r2 = 12
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r2, r15, r6)
            kotlinx.serialization.internal.StringSerializer r15 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r15 = (kotlinx.serialization.DeserializationStrategy) r15
            r18 = r2
            r2 = 13
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r2, r15, r6)
            com.stripe.android.connections.model.OwnershipRefresh$$serializer r15 = com.stripe.android.connections.model.OwnershipRefresh$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r15 = (kotlinx.serialization.DeserializationStrategy) r15
            r17 = r2
            r2 = 14
            java.lang.Object r2 = r0.decodeNullableSerializableElement(r1, r2, r15, r6)
            kotlinx.serialization.internal.ArrayListSerializer r15 = new kotlinx.serialization.internal.ArrayListSerializer
            com.stripe.android.connections.model.LinkedAccount$Permissions$$serializer r16 = com.stripe.android.connections.model.LinkedAccount$Permissions$$serializer.INSTANCE
            r6 = r16
            kotlinx.serialization.KSerializer r6 = (kotlinx.serialization.KSerializer) r6
            r15.<init>(r6)
            kotlinx.serialization.DeserializationStrategy r15 = (kotlinx.serialization.DeserializationStrategy) r15
            r39 = r5
            r5 = 0
            r6 = 15
            java.lang.Object r5 = r0.decodeNullableSerializableElement(r1, r6, r15, r5)
            r6 = 65535(0xffff, float:9.1834E-41)
            r24 = r39
            r23 = r3
            r22 = r4
            r15 = r9
            r25 = r13
            r3 = r14
            r14 = r17
            r20 = 65535(0xffff, float:9.1834E-41)
            r9 = r2
            r2 = r19
            goto L_0x0239
        L_0x00d0:
            r5 = r6
            r2 = 0
            r2 = r5
            r3 = r2
            r4 = r3
            r7 = r4
            r8 = r7
            r9 = r8
            r10 = r9
            r11 = r10
            r12 = r11
            r13 = r12
            r14 = r13
            r15 = r14
            r19 = r15
            r21 = r19
            r5 = 0
            r6 = 0
            r33 = 0
            r34 = 1
        L_0x00e8:
            if (r34 == 0) goto L_0x0220
            r35 = r5
            int r5 = r0.decodeElementIndex(r1)
            switch(r5) {
                case -1: goto L_0x0215;
                case 0: goto L_0x01fa;
                case 1: goto L_0x01ea;
                case 2: goto L_0x01dd;
                case 3: goto L_0x01d2;
                case 4: goto L_0x01c7;
                case 5: goto L_0x01b8;
                case 6: goto L_0x01a9;
                case 7: goto L_0x0190;
                case 8: goto L_0x017f;
                case 9: goto L_0x016e;
                case 10: goto L_0x015c;
                case 11: goto L_0x014a;
                case 12: goto L_0x0138;
                case 13: goto L_0x0126;
                case 14: goto L_0x0114;
                case 15: goto L_0x00f9;
                default: goto L_0x00f3;
            }
        L_0x00f3:
            kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
            r0.<init>((int) r5)
            throw r0
        L_0x00f9:
            kotlinx.serialization.internal.ArrayListSerializer r5 = new kotlinx.serialization.internal.ArrayListSerializer
            com.stripe.android.connections.model.LinkedAccount$Permissions$$serializer r36 = com.stripe.android.connections.model.LinkedAccount$Permissions$$serializer.INSTANCE
            r37 = r7
            r7 = r36
            kotlinx.serialization.KSerializer r7 = (kotlinx.serialization.KSerializer) r7
            r5.<init>(r7)
            kotlinx.serialization.DeserializationStrategy r5 = (kotlinx.serialization.DeserializationStrategy) r5
            r7 = 15
            java.lang.Object r8 = r0.decodeNullableSerializableElement(r1, r7, r5, r8)
            r5 = 32768(0x8000, float:4.5918E-41)
            r6 = r6 | r5
            goto L_0x01e7
        L_0x0114:
            r37 = r7
            r7 = 15
            com.stripe.android.connections.model.OwnershipRefresh$$serializer r5 = com.stripe.android.connections.model.OwnershipRefresh$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r5 = (kotlinx.serialization.DeserializationStrategy) r5
            r7 = 14
            java.lang.Object r9 = r0.decodeNullableSerializableElement(r1, r7, r5, r9)
            r6 = r6 | 16384(0x4000, float:2.2959E-41)
            goto L_0x01e7
        L_0x0126:
            r37 = r7
            r7 = 14
            kotlinx.serialization.internal.StringSerializer r5 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r5 = (kotlinx.serialization.DeserializationStrategy) r5
            r7 = 13
            java.lang.Object r14 = r0.decodeNullableSerializableElement(r1, r7, r5, r14)
            r6 = r6 | 8192(0x2000, float:1.14794E-41)
            goto L_0x01e7
        L_0x0138:
            r37 = r7
            r7 = 13
            kotlinx.serialization.internal.StringSerializer r5 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r5 = (kotlinx.serialization.DeserializationStrategy) r5
            r7 = 12
            java.lang.Object r10 = r0.decodeNullableSerializableElement(r1, r7, r5, r10)
            r6 = r6 | 4096(0x1000, float:5.74E-42)
            goto L_0x01e7
        L_0x014a:
            r37 = r7
            r7 = 12
            kotlinx.serialization.internal.StringSerializer r5 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r5 = (kotlinx.serialization.DeserializationStrategy) r5
            r7 = 11
            java.lang.Object r11 = r0.decodeNullableSerializableElement(r1, r7, r5, r11)
            r6 = r6 | 2048(0x800, float:2.87E-42)
            goto L_0x01e7
        L_0x015c:
            r37 = r7
            r7 = 11
            com.stripe.android.connections.model.BalanceRefresh$$serializer r5 = com.stripe.android.connections.model.BalanceRefresh$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r5 = (kotlinx.serialization.DeserializationStrategy) r5
            r7 = 10
            java.lang.Object r12 = r0.decodeNullableSerializableElement(r1, r7, r5, r12)
            r6 = r6 | 1024(0x400, float:1.435E-42)
            goto L_0x01e7
        L_0x016e:
            r37 = r7
            r7 = 10
            com.stripe.android.connections.model.Balance$$serializer r5 = com.stripe.android.connections.model.Balance$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r5 = (kotlinx.serialization.DeserializationStrategy) r5
            r7 = 9
            java.lang.Object r15 = r0.decodeNullableSerializableElement(r1, r7, r5, r15)
            r6 = r6 | 512(0x200, float:7.175E-43)
            goto L_0x01e7
        L_0x017f:
            r37 = r7
            r7 = 9
            com.stripe.android.connections.model.AccountHolder$$serializer r5 = com.stripe.android.connections.model.AccountHolder$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r5 = (kotlinx.serialization.DeserializationStrategy) r5
            r7 = 8
            java.lang.Object r13 = r0.decodeNullableSerializableElement(r1, r7, r5, r13)
            r6 = r6 | 256(0x100, float:3.59E-43)
            goto L_0x01e7
        L_0x0190:
            r37 = r7
            r7 = 8
            kotlinx.serialization.internal.ArrayListSerializer r5 = new kotlinx.serialization.internal.ArrayListSerializer
            com.stripe.android.connections.model.LinkedAccount$SupportedPaymentMethodTypes$$serializer r30 = com.stripe.android.connections.model.LinkedAccount$SupportedPaymentMethodTypes$$serializer.INSTANCE
            r7 = r30
            kotlinx.serialization.KSerializer r7 = (kotlinx.serialization.KSerializer) r7
            r5.<init>(r7)
            kotlinx.serialization.DeserializationStrategy r5 = (kotlinx.serialization.DeserializationStrategy) r5
            r7 = 7
            java.lang.Object r3 = r0.decodeSerializableElement(r1, r7, r5, r3)
            r6 = r6 | 128(0x80, float:1.794E-43)
            goto L_0x01e7
        L_0x01a9:
            r37 = r7
            r7 = 7
            com.stripe.android.connections.model.LinkedAccount$Subcategory$$serializer r5 = com.stripe.android.connections.model.LinkedAccount$Subcategory$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r5 = (kotlinx.serialization.DeserializationStrategy) r5
            r7 = 6
            java.lang.Object r4 = r0.decodeSerializableElement(r1, r7, r5, r4)
            r6 = r6 | 64
            goto L_0x01e7
        L_0x01b8:
            r37 = r7
            r7 = 6
            com.stripe.android.connections.model.LinkedAccount$Status$$serializer r5 = com.stripe.android.connections.model.LinkedAccount$Status$$serializer.INSTANCE
            kotlinx.serialization.DeserializationStrategy r5 = (kotlinx.serialization.DeserializationStrategy) r5
            r7 = 5
            java.lang.Object r2 = r0.decodeSerializableElement(r1, r7, r5, r2)
            r6 = r6 | 32
            goto L_0x01e7
        L_0x01c7:
            r37 = r7
            r5 = 4
            r7 = 5
            boolean r33 = r0.decodeBooleanElement(r1, r5)
            r6 = r6 | 16
            goto L_0x01e7
        L_0x01d2:
            r37 = r7
            r5 = 4
            r7 = 3
            java.lang.String r21 = r0.decodeStringElement(r1, r7)
            r6 = r6 | 8
            goto L_0x01e7
        L_0x01dd:
            r37 = r7
            r5 = 4
            r7 = 2
            java.lang.String r19 = r0.decodeStringElement(r1, r7)
            r6 = r6 | 4
        L_0x01e7:
            r5 = r35
            goto L_0x01f6
        L_0x01ea:
            r37 = r7
            r5 = 4
            r7 = 1
            int r23 = r0.decodeIntElement(r1, r7)
            r6 = r6 | 2
            r5 = r23
        L_0x01f6:
            r7 = r37
            goto L_0x00e8
        L_0x01fa:
            r37 = r7
            r5 = 4
            r7 = 1
            com.stripe.android.connections.model.LinkedAccount$Category$$serializer r23 = com.stripe.android.connections.model.LinkedAccount$Category$$serializer.INSTANCE
            r5 = r23
            kotlinx.serialization.DeserializationStrategy r5 = (kotlinx.serialization.DeserializationStrategy) r5
            r22 = r2
            r7 = r37
            r2 = 0
            java.lang.Object r7 = r0.decodeSerializableElement(r1, r2, r5, r7)
            r6 = r6 | 1
            r2 = r22
            r5 = r35
            goto L_0x00e8
        L_0x0215:
            r22 = r2
            r2 = 0
            r2 = r22
            r5 = r35
            r34 = 0
            goto L_0x00e8
        L_0x0220:
            r22 = r2
            r35 = r5
            r20 = r6
            r2 = r7
            r5 = r8
            r18 = r10
            r8 = r12
            r10 = r13
            r23 = r19
            r24 = r21
            r12 = r22
            r25 = r33
            r22 = r35
            r7 = r3
            r3 = r11
            r11 = r4
        L_0x0239:
            r0.endStructure(r1)
            com.stripe.android.connections.model.LinkedAccount r0 = new com.stripe.android.connections.model.LinkedAccount
            r19 = r0
            r21 = r2
            com.stripe.android.connections.model.LinkedAccount$Category r21 = (com.stripe.android.connections.model.LinkedAccount.Category) r21
            r26 = r12
            com.stripe.android.connections.model.LinkedAccount$Status r26 = (com.stripe.android.connections.model.LinkedAccount.Status) r26
            r27 = r11
            com.stripe.android.connections.model.LinkedAccount$Subcategory r27 = (com.stripe.android.connections.model.LinkedAccount.Subcategory) r27
            r28 = r7
            java.util.List r28 = (java.util.List) r28
            r29 = r10
            com.stripe.android.connections.model.AccountHolder r29 = (com.stripe.android.connections.model.AccountHolder) r29
            r30 = r15
            com.stripe.android.connections.model.Balance r30 = (com.stripe.android.connections.model.Balance) r30
            r31 = r8
            com.stripe.android.connections.model.BalanceRefresh r31 = (com.stripe.android.connections.model.BalanceRefresh) r31
            r32 = r3
            java.lang.String r32 = (java.lang.String) r32
            r33 = r18
            java.lang.String r33 = (java.lang.String) r33
            r34 = r14
            java.lang.String r34 = (java.lang.String) r34
            r35 = r9
            com.stripe.android.connections.model.OwnershipRefresh r35 = (com.stripe.android.connections.model.OwnershipRefresh) r35
            r36 = r5
            java.util.List r36 = (java.util.List) r36
            r37 = 0
            r19.<init>((int) r20, (com.stripe.android.connections.model.LinkedAccount.Category) r21, (int) r22, (java.lang.String) r23, (java.lang.String) r24, (boolean) r25, (com.stripe.android.connections.model.LinkedAccount.Status) r26, (com.stripe.android.connections.model.LinkedAccount.Subcategory) r27, (java.util.List) r28, (com.stripe.android.connections.model.AccountHolder) r29, (com.stripe.android.connections.model.Balance) r30, (com.stripe.android.connections.model.BalanceRefresh) r31, (java.lang.String) r32, (java.lang.String) r33, (java.lang.String) r34, (com.stripe.android.connections.model.OwnershipRefresh) r35, (java.util.List) r36, (kotlinx.serialization.internal.SerializationConstructorMarker) r37)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.connections.model.LinkedAccount$$serializer.deserialize(kotlinx.serialization.encoding.Decoder):com.stripe.android.connections.model.LinkedAccount");
    }

    public void serialize(Encoder encoder, LinkedAccount linkedAccount) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(linkedAccount, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        LinkedAccount.write$Self(linkedAccount, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
