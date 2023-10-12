package com.stripe.android.model.parsers;

import com.stripe.android.core.model.StripeJsonUtils;
import com.stripe.android.core.model.parsers.ModelJsonParser;
import com.stripe.android.model.ConsumerSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\n"}, d2 = {"Lcom/stripe/android/model/parsers/ConsumerSessionJsonParser;", "Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "Lcom/stripe/android/model/ConsumerSession;", "()V", "parse", "json", "Lorg/json/JSONObject;", "parseVerificationSession", "Lcom/stripe/android/model/ConsumerSession$VerificationSession;", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConsumerSessionJsonParser.kt */
public final class ConsumerSessionJsonParser implements ModelJsonParser<ConsumerSession> {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final String FIELD_CONSUMER_SESSION = "consumer_session";
    @Deprecated
    private static final String FIELD_CONSUMER_SESSION_AUTH_SESSION_SECRET = "auth_session_client_secret";
    @Deprecated
    private static final String FIELD_CONSUMER_SESSION_EMAIL = "email_address";
    @Deprecated
    private static final String FIELD_CONSUMER_SESSION_PHONE = "redacted_phone_number";
    @Deprecated
    private static final String FIELD_CONSUMER_SESSION_SECRET = "client_secret";
    @Deprecated
    private static final String FIELD_CONSUMER_SESSION_VERIFICATION_SESSIONS = "verification_sessions";
    @Deprecated
    private static final String FIELD_VERIFICATION_SESSION_STATE = "state";
    @Deprecated
    private static final String FIELD_VERIFICATION_SESSION_TYPE = "type";

    public ConsumerSession parse(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "json");
        JSONObject optJSONObject = jSONObject.optJSONObject(FIELD_CONSUMER_SESSION);
        List list = null;
        if (optJSONObject == null) {
            return null;
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray(FIELD_CONSUMER_SESSION_VERIFICATION_SESSIONS);
        if (optJSONArray != null) {
            Iterable until = RangesKt.until(0, optJSONArray.length());
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
            Iterator it = until.iterator();
            while (it.hasNext()) {
                arrayList.add(optJSONArray.getJSONObject(((IntIterator) it).nextInt()));
            }
            Collection arrayList2 = new ArrayList();
            for (JSONObject jSONObject2 : (List) arrayList) {
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "it");
                ConsumerSession.VerificationSession parseVerificationSession = parseVerificationSession(jSONObject2);
                if (parseVerificationSession != null) {
                    arrayList2.add(parseVerificationSession);
                }
            }
            list = (List) arrayList2;
        }
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        String string = optJSONObject.getString("client_secret");
        Intrinsics.checkNotNullExpressionValue(string, "consumerSessionJson.getS…_CONSUMER_SESSION_SECRET)");
        String string2 = optJSONObject.getString(FIELD_CONSUMER_SESSION_EMAIL);
        Intrinsics.checkNotNullExpressionValue(string2, "consumerSessionJson.getS…D_CONSUMER_SESSION_EMAIL)");
        String string3 = optJSONObject.getString(FIELD_CONSUMER_SESSION_PHONE);
        Intrinsics.checkNotNullExpressionValue(string3, "consumerSessionJson.getS…D_CONSUMER_SESSION_PHONE)");
        return new ConsumerSession(string, string2, string3, list, StripeJsonUtils.optString(jSONObject, FIELD_CONSUMER_SESSION_AUTH_SESSION_SECRET));
    }

    private final ConsumerSession.VerificationSession parseVerificationSession(JSONObject jSONObject) {
        ConsumerSession.VerificationSession.SessionType.Companion companion = ConsumerSession.VerificationSession.SessionType.Companion;
        String string = jSONObject.getString("type");
        Intrinsics.checkNotNullExpressionValue(string, "json.getString(FIELD_VERIFICATION_SESSION_TYPE)");
        String lowerCase = string.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        ConsumerSession.VerificationSession.SessionType fromValue = companion.fromValue(lowerCase);
        ConsumerSession.VerificationSession.SessionState.Companion companion2 = ConsumerSession.VerificationSession.SessionState.Companion;
        String string2 = jSONObject.getString("state");
        Intrinsics.checkNotNullExpressionValue(string2, "json.getString(FIELD_VERIFICATION_SESSION_STATE)");
        String lowerCase2 = string2.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return new ConsumerSession.VerificationSession(fromValue, companion2.fromValue(lowerCase2));
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/stripe/android/model/parsers/ConsumerSessionJsonParser$Companion;", "", "()V", "FIELD_CONSUMER_SESSION", "", "FIELD_CONSUMER_SESSION_AUTH_SESSION_SECRET", "FIELD_CONSUMER_SESSION_EMAIL", "FIELD_CONSUMER_SESSION_PHONE", "FIELD_CONSUMER_SESSION_SECRET", "FIELD_CONSUMER_SESSION_VERIFICATION_SESSIONS", "FIELD_VERIFICATION_SESSION_STATE", "FIELD_VERIFICATION_SESSION_TYPE", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConsumerSessionJsonParser.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
