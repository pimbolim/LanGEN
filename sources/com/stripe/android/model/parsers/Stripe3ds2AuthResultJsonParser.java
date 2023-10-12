package com.stripe.android.model.parsers;

import com.stripe.android.core.model.StripeJsonUtils;
import com.stripe.android.core.model.parsers.ModelJsonParser;
import com.stripe.android.model.Stripe3ds2AuthResult;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u0007\b\t\nB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/model/parsers/Stripe3ds2AuthResultJsonParser;", "Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "Lcom/stripe/android/model/Stripe3ds2AuthResult;", "()V", "parse", "json", "Lorg/json/JSONObject;", "AresJsonParser", "Companion", "MessageExtensionJsonParser", "ThreeDS2ErrorJsonParser", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Stripe3ds2AuthResultJsonParser.kt */
public final class Stripe3ds2AuthResultJsonParser implements ModelJsonParser<Stripe3ds2AuthResult> {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final String FIELD_ARES = "ares";
    @Deprecated
    private static final String FIELD_CREATED = "created";
    @Deprecated
    private static final String FIELD_CREQ = "creq";
    @Deprecated
    private static final String FIELD_ERROR = "error";
    @Deprecated
    private static final String FIELD_FALLBACK_REDIRECT_URL = "fallback_redirect_url";
    @Deprecated
    private static final String FIELD_ID = "id";
    @Deprecated
    private static final String FIELD_LIVEMODE = "livemode";
    @Deprecated
    private static final String FIELD_SOURCE = "source";
    @Deprecated
    private static final String FIELD_STATE = "state";

    public Stripe3ds2AuthResult parse(JSONObject jSONObject) {
        Stripe3ds2AuthResult.Ares ares;
        Intrinsics.checkNotNullParameter(jSONObject, "json");
        String string = jSONObject.getString("id");
        long j = jSONObject.getLong(FIELD_CREATED);
        boolean z = jSONObject.getBoolean(FIELD_LIVEMODE);
        String string2 = jSONObject.getString("source");
        String optString = jSONObject.optString("state");
        JSONObject optJSONObject = jSONObject.optJSONObject(FIELD_ARES);
        Stripe3ds2AuthResult.ThreeDS2Error threeDS2Error = null;
        if (optJSONObject == null) {
            ares = null;
        } else {
            ares = new AresJsonParser().parse(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("error");
        if (optJSONObject2 != null) {
            threeDS2Error = new ThreeDS2ErrorJsonParser().parse(optJSONObject2);
        }
        return new Stripe3ds2AuthResult(string, ares, Long.valueOf(j), string2, optString, z, threeDS2Error, StripeJsonUtils.optString(jSONObject, FIELD_FALLBACK_REDIRECT_URL), StripeJsonUtils.optString(jSONObject, FIELD_CREQ));
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/stripe/android/model/parsers/Stripe3ds2AuthResultJsonParser$AresJsonParser;", "Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "Lcom/stripe/android/model/Stripe3ds2AuthResult$Ares;", "()V", "parse", "json", "Lorg/json/JSONObject;", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Stripe3ds2AuthResultJsonParser.kt */
    public static final class AresJsonParser implements ModelJsonParser<Stripe3ds2AuthResult.Ares> {
        private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @Deprecated
        private static final String FIELD_ACS_CHALLENGE_MANDATED = "acsChallengeMandated";
        @Deprecated
        private static final String FIELD_ACS_SIGNED_CONTENT = "acsSignedContent";
        @Deprecated
        private static final String FIELD_ACS_TRANS_ID = "acsTransID";
        @Deprecated
        private static final String FIELD_ACS_URL = "acsURL";
        @Deprecated
        private static final String FIELD_AUTHENTICATION_TYPE = "authenticationType";
        @Deprecated
        private static final String FIELD_CARDHOLDER_INFO = "cardholderInfo";
        @Deprecated
        private static final String FIELD_MESSAGE_EXTENSION = "messageExtension";
        @Deprecated
        private static final String FIELD_MESSAGE_TYPE = "messageType";
        @Deprecated
        private static final String FIELD_MESSAGE_VERSION = "messageVersion";
        @Deprecated
        private static final String FIELD_SDK_TRANS_ID = "sdkTransID";
        @Deprecated
        private static final String FIELD_THREE_DS_SERVER_TRANS_ID = "threeDSServerTransID";
        @Deprecated
        private static final String FIELD_TRANS_STATUS = "transStatus";

        public Stripe3ds2AuthResult.Ares parse(JSONObject jSONObject) {
            List<Stripe3ds2AuthResult.MessageExtension> list;
            Intrinsics.checkNotNullParameter(jSONObject, "json");
            String optString = StripeJsonUtils.optString(jSONObject, "threeDSServerTransID");
            String optString2 = StripeJsonUtils.optString(jSONObject, FIELD_ACS_CHALLENGE_MANDATED);
            String optString3 = StripeJsonUtils.optString(jSONObject, FIELD_ACS_SIGNED_CONTENT);
            String string = jSONObject.getString("acsTransID");
            String optString4 = StripeJsonUtils.optString(jSONObject, "acsURL");
            String optString5 = StripeJsonUtils.optString(jSONObject, FIELD_AUTHENTICATION_TYPE);
            String optString6 = StripeJsonUtils.optString(jSONObject, FIELD_CARDHOLDER_INFO);
            String string2 = jSONObject.getString("messageType");
            String string3 = jSONObject.getString("messageVersion");
            String optString7 = StripeJsonUtils.optString(jSONObject, "sdkTransID");
            String optString8 = StripeJsonUtils.optString(jSONObject, FIELD_TRANS_STATUS);
            JSONArray optJSONArray = jSONObject.optJSONArray(FIELD_MESSAGE_EXTENSION);
            if (optJSONArray == null) {
                list = null;
            } else {
                list = new MessageExtensionJsonParser().parse(optJSONArray);
            }
            return new Stripe3ds2AuthResult.Ares(optString, optString2, optString3, string, optString4, optString5, optString6, list, string2, string3, optString7, optString8);
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/stripe/android/model/parsers/Stripe3ds2AuthResultJsonParser$AresJsonParser$Companion;", "", "()V", "FIELD_ACS_CHALLENGE_MANDATED", "", "FIELD_ACS_SIGNED_CONTENT", "FIELD_ACS_TRANS_ID", "FIELD_ACS_URL", "FIELD_AUTHENTICATION_TYPE", "FIELD_CARDHOLDER_INFO", "FIELD_MESSAGE_EXTENSION", "FIELD_MESSAGE_TYPE", "FIELD_MESSAGE_VERSION", "FIELD_SDK_TRANS_ID", "FIELD_THREE_DS_SERVER_TRANS_ID", "FIELD_TRANS_STATUS", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Stripe3ds2AuthResultJsonParser.kt */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u0005¢\u0006\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/model/parsers/Stripe3ds2AuthResultJsonParser$MessageExtensionJsonParser;", "Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "Lcom/stripe/android/model/Stripe3ds2AuthResult$MessageExtension;", "()V", "parse", "", "jsonArray", "Lorg/json/JSONArray;", "json", "Lorg/json/JSONObject;", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Stripe3ds2AuthResultJsonParser.kt */
    public static final class MessageExtensionJsonParser implements ModelJsonParser<Stripe3ds2AuthResult.MessageExtension> {
        private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @Deprecated
        private static final String FIELD_CRITICALITY_INDICATOR = "criticalityIndicator";
        @Deprecated
        private static final String FIELD_DATA = "data";
        @Deprecated
        private static final String FIELD_ID = "id";
        @Deprecated
        private static final String FIELD_NAME = "name";

        public final List<Stripe3ds2AuthResult.MessageExtension> parse(JSONArray jSONArray) {
            Intrinsics.checkNotNullParameter(jSONArray, "jsonArray");
            Collection arrayList = new ArrayList();
            Iterator it = RangesKt.until(0, jSONArray.length()).iterator();
            while (it.hasNext()) {
                JSONObject optJSONObject = jSONArray.optJSONObject(((IntIterator) it).nextInt());
                if (optJSONObject != null) {
                    arrayList.add(optJSONObject);
                }
            }
            Iterable<JSONObject> iterable = (List) arrayList;
            Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (JSONObject parse : iterable) {
                arrayList2.add(parse(parse));
            }
            return (List) arrayList2;
        }

        public Stripe3ds2AuthResult.MessageExtension parse(JSONObject jSONObject) {
            Map map;
            Intrinsics.checkNotNullParameter(jSONObject, "json");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                JSONArray names = optJSONObject.names();
                if (names == null) {
                    names = new JSONArray();
                }
                Iterable until = RangesKt.until(0, names.length());
                Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
                Iterator it = until.iterator();
                while (it.hasNext()) {
                    arrayList.add(names.getString(((IntIterator) it).nextInt()));
                }
                Iterable<String> iterable = (List) arrayList;
                Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                for (String str : iterable) {
                    arrayList2.add(MapsKt.mapOf(TuplesKt.to(str, optJSONObject.getString(str))));
                }
                map = MapsKt.emptyMap();
                for (Map plus : (List) arrayList2) {
                    map = MapsKt.plus(map, plus);
                }
            } else {
                map = MapsKt.emptyMap();
            }
            return new Stripe3ds2AuthResult.MessageExtension(StripeJsonUtils.optString(jSONObject, "name"), jSONObject.optBoolean("criticalityIndicator"), StripeJsonUtils.optString(jSONObject, "id"), MapsKt.toMap(map));
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/stripe/android/model/parsers/Stripe3ds2AuthResultJsonParser$MessageExtensionJsonParser$Companion;", "", "()V", "FIELD_CRITICALITY_INDICATOR", "", "FIELD_DATA", "FIELD_ID", "FIELD_NAME", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Stripe3ds2AuthResultJsonParser.kt */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/stripe/android/model/parsers/Stripe3ds2AuthResultJsonParser$ThreeDS2ErrorJsonParser;", "Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "Lcom/stripe/android/model/Stripe3ds2AuthResult$ThreeDS2Error;", "()V", "parse", "json", "Lorg/json/JSONObject;", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Stripe3ds2AuthResultJsonParser.kt */
    public static final class ThreeDS2ErrorJsonParser implements ModelJsonParser<Stripe3ds2AuthResult.ThreeDS2Error> {
        private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @Deprecated
        private static final String FIELD_ACS_TRANS_ID = "acsTransID";
        @Deprecated
        private static final String FIELD_DS_TRANS_ID = "dsTransID";
        @Deprecated
        private static final String FIELD_ERROR_CODE = "errorCode";
        @Deprecated
        private static final String FIELD_ERROR_COMPONENT = "errorComponent";
        @Deprecated
        private static final String FIELD_ERROR_DESCRIPTION = "errorDescription";
        @Deprecated
        private static final String FIELD_ERROR_DETAIL = "errorDetail";
        @Deprecated
        private static final String FIELD_ERROR_MESSAGE_TYPE = "errorMessageType";
        @Deprecated
        private static final String FIELD_MESSAGE_TYPE = "messageType";
        @Deprecated
        private static final String FIELD_MESSAGE_VERSION = "messageVersion";
        @Deprecated
        private static final String FIELD_SDK_TRANS_ID = "sdkTransID";
        @Deprecated
        private static final String FIELD_THREE_DS_SERVER_TRANS_ID = "threeDSServerTransID";

        public Stripe3ds2AuthResult.ThreeDS2Error parse(JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(jSONObject, "json");
            return new Stripe3ds2AuthResult.ThreeDS2Error(jSONObject.getString("threeDSServerTransID"), StripeJsonUtils.optString(jSONObject, "acsTransID"), StripeJsonUtils.optString(jSONObject, FIELD_DS_TRANS_ID), jSONObject.getString(FIELD_ERROR_CODE), jSONObject.getString(FIELD_ERROR_COMPONENT), jSONObject.getString(FIELD_ERROR_DESCRIPTION), jSONObject.getString(FIELD_ERROR_DETAIL), StripeJsonUtils.optString(jSONObject, FIELD_ERROR_MESSAGE_TYPE), jSONObject.getString("messageType"), jSONObject.getString("messageVersion"), StripeJsonUtils.optString(jSONObject, "sdkTransID"));
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/stripe/android/model/parsers/Stripe3ds2AuthResultJsonParser$ThreeDS2ErrorJsonParser$Companion;", "", "()V", "FIELD_ACS_TRANS_ID", "", "FIELD_DS_TRANS_ID", "FIELD_ERROR_CODE", "FIELD_ERROR_COMPONENT", "FIELD_ERROR_DESCRIPTION", "FIELD_ERROR_DETAIL", "FIELD_ERROR_MESSAGE_TYPE", "FIELD_MESSAGE_TYPE", "FIELD_MESSAGE_VERSION", "FIELD_SDK_TRANS_ID", "FIELD_THREE_DS_SERVER_TRANS_ID", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Stripe3ds2AuthResultJsonParser.kt */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/stripe/android/model/parsers/Stripe3ds2AuthResultJsonParser$Companion;", "", "()V", "FIELD_ARES", "", "FIELD_CREATED", "FIELD_CREQ", "FIELD_ERROR", "FIELD_FALLBACK_REDIRECT_URL", "FIELD_ID", "FIELD_LIVEMODE", "FIELD_SOURCE", "FIELD_STATE", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Stripe3ds2AuthResultJsonParser.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
