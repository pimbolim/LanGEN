package com.stripe.android.model.parsers;

import com.stripe.android.EphemeralKey;
import com.stripe.android.core.model.parsers.ModelJsonParser;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/stripe/android/model/parsers/EphemeralKeyJsonParser;", "Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "Lcom/stripe/android/EphemeralKey;", "()V", "parse", "json", "Lorg/json/JSONObject;", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EphemeralKeyJsonParser.kt */
public final class EphemeralKeyJsonParser implements ModelJsonParser<EphemeralKey> {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final String FIELD_ASSOCIATED_OBJECTS = "associated_objects";
    @Deprecated
    private static final String FIELD_CREATED = "created";
    @Deprecated
    private static final String FIELD_EXPIRES = "expires";
    @Deprecated
    private static final String FIELD_ID = "id";
    @Deprecated
    private static final String FIELD_LIVEMODE = "livemode";
    @Deprecated
    private static final String FIELD_OBJECT = "object";
    @Deprecated
    private static final String FIELD_SECRET = "secret";
    @Deprecated
    private static final String FIELD_TYPE = "type";

    public EphemeralKey parse(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "json");
        long j = jSONObject.getLong(FIELD_CREATED);
        long j2 = jSONObject.getLong(FIELD_EXPIRES);
        String string = jSONObject.getString("id");
        boolean z = jSONObject.getBoolean(FIELD_LIVEMODE);
        String string2 = jSONObject.getString(FIELD_OBJECT);
        String string3 = jSONObject.getString(FIELD_SECRET);
        JSONObject jSONObject2 = jSONObject.getJSONArray(FIELD_ASSOCIATED_OBJECTS).getJSONObject(0);
        String string4 = jSONObject2.getString("type");
        String string5 = jSONObject2.getString("id");
        Intrinsics.checkNotNullExpressionValue(string5, "objectId");
        Intrinsics.checkNotNullExpressionValue(string, "id");
        Intrinsics.checkNotNullExpressionValue(string2, "objectType");
        Intrinsics.checkNotNullExpressionValue(string3, FIELD_SECRET);
        Intrinsics.checkNotNullExpressionValue(string4, "type");
        return new EphemeralKey(string5, j, j2, string, z, string2, string3, string4);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/stripe/android/model/parsers/EphemeralKeyJsonParser$Companion;", "", "()V", "FIELD_ASSOCIATED_OBJECTS", "", "FIELD_CREATED", "FIELD_EXPIRES", "FIELD_ID", "FIELD_LIVEMODE", "FIELD_OBJECT", "FIELD_SECRET", "FIELD_TYPE", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: EphemeralKeyJsonParser.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
