package com.stripe.android.connections.model.serializer;

import com.stripe.android.connections.model.BankAccount;
import com.stripe.android.connections.model.LinkedAccount;
import com.stripe.android.connections.model.PaymentAccount;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.json.JsonContentPolymorphicSerializer;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonPrimitive;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0014R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/stripe/android/connections/model/serializer/PaymentAccountSerializer;", "Lkotlinx/serialization/json/JsonContentPolymorphicSerializer;", "Lcom/stripe/android/connections/model/PaymentAccount;", "()V", "objectValue", "", "Lkotlinx/serialization/json/JsonElement;", "getObjectValue", "(Lkotlinx/serialization/json/JsonElement;)Ljava/lang/String;", "selectDeserializer", "Lkotlinx/serialization/KSerializer;", "element", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentAccountSerializer.kt */
public final class PaymentAccountSerializer extends JsonContentPolymorphicSerializer<PaymentAccount> {
    public static final PaymentAccountSerializer INSTANCE = new PaymentAccountSerializer();

    private PaymentAccountSerializer() {
        super(Reflection.getOrCreateKotlinClass(PaymentAccount.class));
    }

    /* access modifiers changed from: protected */
    public KSerializer<? extends PaymentAccount> selectDeserializer(JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(jsonElement, "element");
        if (Intrinsics.areEqual((Object) getObjectValue(jsonElement), (Object) LinkedAccount.OBJECT)) {
            return LinkedAccount.Companion.serializer();
        }
        return BankAccount.Companion.serializer();
    }

    private final String getObjectValue(JsonElement jsonElement) {
        JsonPrimitive jsonPrimitive;
        JsonElement jsonElement2 = (JsonElement) JsonElementKt.getJsonObject(jsonElement).get((Object) "object");
        if (jsonElement2 == null || (jsonPrimitive = JsonElementKt.getJsonPrimitive(jsonElement2)) == null) {
            return null;
        }
        return jsonPrimitive.getContent();
    }
}
