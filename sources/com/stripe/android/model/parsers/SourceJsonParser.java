package com.stripe.android.model.parsers;

import com.stripe.android.core.model.StripeJsonUtils;
import com.stripe.android.core.model.parsers.ModelJsonParser;
import com.stripe.android.model.Address;
import com.stripe.android.model.Source;
import com.stripe.android.model.SourceOrder;
import com.stripe.android.model.WeChat;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0006\u0007\b\t\n\u000b\fB\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\r"}, d2 = {"Lcom/stripe/android/model/parsers/SourceJsonParser;", "Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "Lcom/stripe/android/model/Source;", "()V", "parse", "json", "Lorg/json/JSONObject;", "CodeVerificationJsonParser", "Companion", "KlarnaJsonParser", "OwnerJsonParser", "ReceiverJsonParser", "RedirectJsonParser", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SourceJsonParser.kt */
public final class SourceJsonParser implements ModelJsonParser<Source> {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final String FIELD_AMOUNT = "amount";
    @Deprecated
    private static final String FIELD_CLIENT_SECRET = "client_secret";
    @Deprecated
    private static final String FIELD_CODE_VERIFICATION = "code_verification";
    @Deprecated
    private static final String FIELD_CREATED = "created";
    @Deprecated
    private static final String FIELD_CURRENCY = "currency";
    @Deprecated
    private static final String FIELD_FLOW = "flow";
    @Deprecated
    private static final String FIELD_ID = "id";
    @Deprecated
    private static final String FIELD_KLARNA = "klarna";
    @Deprecated
    private static final String FIELD_LIVEMODE = "livemode";
    @Deprecated
    private static final String FIELD_OBJECT = "object";
    @Deprecated
    private static final String FIELD_OWNER = "owner";
    @Deprecated
    private static final String FIELD_RECEIVER = "receiver";
    @Deprecated
    private static final String FIELD_REDIRECT = "redirect";
    @Deprecated
    private static final String FIELD_SOURCE_ORDER = "source_order";
    @Deprecated
    private static final String FIELD_STATEMENT_DESCRIPTOR = "statement_descriptor";
    @Deprecated
    private static final String FIELD_STATUS = "status";
    @Deprecated
    private static final String FIELD_TYPE = "type";
    @Deprecated
    private static final String FIELD_USAGE = "usage";
    @Deprecated
    private static final String FIELD_WECHAT = "wechat";
    /* access modifiers changed from: private */
    @Deprecated
    public static final Set<String> MODELED_TYPES = SetsKt.setOf("card", "sepa_debit");
    @Deprecated
    private static final String VALUE_CARD = "card";
    @Deprecated
    private static final String VALUE_SOURCE = "source";

    public Source parse(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "json");
        String optString = jSONObject.optString(FIELD_OBJECT);
        if (Intrinsics.areEqual((Object) optString, (Object) "card")) {
            return Companion.fromCardJson(jSONObject);
        }
        if (Intrinsics.areEqual((Object) optString, (Object) "source")) {
            return Companion.fromSourceJson(jSONObject);
        }
        return null;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/stripe/android/model/parsers/SourceJsonParser$RedirectJsonParser;", "Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "Lcom/stripe/android/model/Source$Redirect;", "()V", "parse", "json", "Lorg/json/JSONObject;", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SourceJsonParser.kt */
    public static final class RedirectJsonParser implements ModelJsonParser<Source.Redirect> {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private static final String FIELD_RETURN_URL = "return_url";
        private static final String FIELD_STATUS = "status";
        private static final String FIELD_URL = "url";

        public Source.Redirect parse(JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(jSONObject, "json");
            return new Source.Redirect(StripeJsonUtils.optString(jSONObject, "return_url"), Source.Redirect.Status.Companion.fromCode(StripeJsonUtils.optString(jSONObject, "status")), StripeJsonUtils.optString(jSONObject, "url"));
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/model/parsers/SourceJsonParser$RedirectJsonParser$Companion;", "", "()V", "FIELD_RETURN_URL", "", "FIELD_STATUS", "FIELD_URL", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SourceJsonParser.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/stripe/android/model/parsers/SourceJsonParser$CodeVerificationJsonParser;", "Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "Lcom/stripe/android/model/Source$CodeVerification;", "()V", "parse", "json", "Lorg/json/JSONObject;", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SourceJsonParser.kt */
    public static final class CodeVerificationJsonParser implements ModelJsonParser<Source.CodeVerification> {
        private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @Deprecated
        private static final String FIELD_ATTEMPTS_REMAINING = "attempts_remaining";
        @Deprecated
        private static final String FIELD_STATUS = "status";
        @Deprecated
        private static final int INVALID_ATTEMPTS_REMAINING = -1;

        public Source.CodeVerification parse(JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(jSONObject, "json");
            return new Source.CodeVerification(jSONObject.optInt(FIELD_ATTEMPTS_REMAINING, -1), Source.CodeVerification.Status.Companion.fromCode(StripeJsonUtils.optString(jSONObject, "status")));
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/stripe/android/model/parsers/SourceJsonParser$CodeVerificationJsonParser$Companion;", "", "()V", "FIELD_ATTEMPTS_REMAINING", "", "FIELD_STATUS", "INVALID_ATTEMPTS_REMAINING", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SourceJsonParser.kt */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/stripe/android/model/parsers/SourceJsonParser$ReceiverJsonParser;", "Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "Lcom/stripe/android/model/Source$Receiver;", "()V", "parse", "json", "Lorg/json/JSONObject;", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SourceJsonParser.kt */
    public static final class ReceiverJsonParser implements ModelJsonParser<Source.Receiver> {
        private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @Deprecated
        private static final String FIELD_ADDRESS = "address";
        @Deprecated
        private static final String FIELD_AMOUNT_CHARGED = "amount_charged";
        @Deprecated
        private static final String FIELD_AMOUNT_RECEIVED = "amount_received";
        @Deprecated
        private static final String FIELD_AMOUNT_RETURNED = "amount_returned";

        public Source.Receiver parse(JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(jSONObject, "json");
            return new Source.Receiver(StripeJsonUtils.optString(jSONObject, "address"), jSONObject.optLong(FIELD_AMOUNT_CHARGED), jSONObject.optLong(FIELD_AMOUNT_RECEIVED), jSONObject.optLong(FIELD_AMOUNT_RETURNED));
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/stripe/android/model/parsers/SourceJsonParser$ReceiverJsonParser$Companion;", "", "()V", "FIELD_ADDRESS", "", "FIELD_AMOUNT_CHARGED", "FIELD_AMOUNT_RECEIVED", "FIELD_AMOUNT_RETURNED", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SourceJsonParser.kt */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/stripe/android/model/parsers/SourceJsonParser$OwnerJsonParser;", "Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "Lcom/stripe/android/model/Source$Owner;", "()V", "parse", "json", "Lorg/json/JSONObject;", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SourceJsonParser.kt */
    public static final class OwnerJsonParser implements ModelJsonParser<Source.Owner> {
        private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @Deprecated
        private static final String FIELD_ADDRESS = "address";
        @Deprecated
        private static final String FIELD_EMAIL = "email";
        @Deprecated
        private static final String FIELD_NAME = "name";
        @Deprecated
        private static final String FIELD_PHONE = "phone";
        @Deprecated
        private static final String FIELD_VERIFIED_ADDRESS = "verified_address";
        @Deprecated
        private static final String FIELD_VERIFIED_EMAIL = "verified_email";
        @Deprecated
        private static final String FIELD_VERIFIED_NAME = "verified_name";
        @Deprecated
        private static final String FIELD_VERIFIED_PHONE = "verified_phone";

        public Source.Owner parse(JSONObject jSONObject) {
            Address address;
            Intrinsics.checkNotNullParameter(jSONObject, "json");
            JSONObject optJSONObject = jSONObject.optJSONObject("address");
            Address address2 = null;
            if (optJSONObject == null) {
                address = null;
            } else {
                address = new AddressJsonParser().parse(optJSONObject);
            }
            String optString = StripeJsonUtils.optString(jSONObject, "email");
            String optString2 = StripeJsonUtils.optString(jSONObject, "name");
            String optString3 = StripeJsonUtils.optString(jSONObject, "phone");
            JSONObject optJSONObject2 = jSONObject.optJSONObject(FIELD_VERIFIED_ADDRESS);
            if (optJSONObject2 != null) {
                address2 = new AddressJsonParser().parse(optJSONObject2);
            }
            return new Source.Owner(address, optString, optString2, optString3, address2, StripeJsonUtils.optString(jSONObject, FIELD_VERIFIED_EMAIL), StripeJsonUtils.optString(jSONObject, FIELD_VERIFIED_NAME), StripeJsonUtils.optString(jSONObject, FIELD_VERIFIED_PHONE));
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/stripe/android/model/parsers/SourceJsonParser$OwnerJsonParser$Companion;", "", "()V", "FIELD_ADDRESS", "", "FIELD_EMAIL", "FIELD_NAME", "FIELD_PHONE", "FIELD_VERIFIED_ADDRESS", "FIELD_VERIFIED_EMAIL", "FIELD_VERIFIED_NAME", "FIELD_VERIFIED_PHONE", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SourceJsonParser.kt */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¨\u0006\f"}, d2 = {"Lcom/stripe/android/model/parsers/SourceJsonParser$KlarnaJsonParser;", "Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "Lcom/stripe/android/model/Source$Klarna;", "()V", "parse", "json", "Lorg/json/JSONObject;", "parseSet", "", "", "key", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SourceJsonParser.kt */
    public static final class KlarnaJsonParser implements ModelJsonParser<Source.Klarna> {
        private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @Deprecated
        private static final String FIELD_CLIENT_TOKEN = "client_token";
        @Deprecated
        private static final String FIELD_CUSTOM_PAYMENT_METHODS = "custom_payment_methods";
        @Deprecated
        private static final String FIELD_FIRST_NAME = "first_name";
        @Deprecated
        private static final String FIELD_LAST_NAME = "last_name";
        @Deprecated
        private static final String FIELD_PAYMENT_METHOD_CATEGORIES = "payment_method_categories";
        @Deprecated
        private static final String FIELD_PAY_LATER_ASSET_URLS_DESCRIPTIVE = "pay_later_asset_urls_descriptive";
        @Deprecated
        private static final String FIELD_PAY_LATER_ASSET_URLS_STANDARD = "pay_later_asset_urls_standard";
        @Deprecated
        private static final String FIELD_PAY_LATER_NAME = "pay_later_name";
        @Deprecated
        private static final String FIELD_PAY_LATER_REDIRECT_URL = "pay_later_redirect_url";
        @Deprecated
        private static final String FIELD_PAY_NOW_ASSET_URLS_DESCRIPTIVE = "pay_now_asset_urls_descriptive";
        @Deprecated
        private static final String FIELD_PAY_NOW_ASSET_URLS_STANDARD = "pay_now_asset_urls_standard";
        @Deprecated
        private static final String FIELD_PAY_NOW_NAME = "pay_now_name";
        @Deprecated
        private static final String FIELD_PAY_NOW_REDIRECT_URL = "pay_now_redirect_url";
        @Deprecated
        private static final String FIELD_PAY_OVER_TIME_ASSET_URLS_DESCRIPTIVE = "pay_over_time_asset_urls_descriptive";
        @Deprecated
        private static final String FIELD_PAY_OVER_TIME_ASSET_URLS_STANDARD = "pay_over_time_asset_urls_standard";
        @Deprecated
        private static final String FIELD_PAY_OVER_TIME_NAME = "pay_over_time_name";
        @Deprecated
        private static final String FIELD_PAY_OVER_TIME_REDIRECT_URL = "pay_over_time_redirect_url";
        @Deprecated
        private static final String FIELD_PURCHASE_COUNTRY = "purchase_country";

        public Source.Klarna parse(JSONObject jSONObject) {
            JSONObject jSONObject2 = jSONObject;
            Intrinsics.checkNotNullParameter(jSONObject2, "json");
            return new Source.Klarna(StripeJsonUtils.optString(jSONObject2, FIELD_FIRST_NAME), StripeJsonUtils.optString(jSONObject2, FIELD_LAST_NAME), StripeJsonUtils.optString(jSONObject2, FIELD_PURCHASE_COUNTRY), StripeJsonUtils.optString(jSONObject2, FIELD_CLIENT_TOKEN), StripeJsonUtils.optString(jSONObject2, FIELD_PAY_NOW_ASSET_URLS_DESCRIPTIVE), StripeJsonUtils.optString(jSONObject2, FIELD_PAY_NOW_ASSET_URLS_STANDARD), StripeJsonUtils.optString(jSONObject2, FIELD_PAY_NOW_NAME), StripeJsonUtils.optString(jSONObject2, FIELD_PAY_NOW_REDIRECT_URL), StripeJsonUtils.optString(jSONObject2, FIELD_PAY_LATER_ASSET_URLS_DESCRIPTIVE), StripeJsonUtils.optString(jSONObject2, FIELD_PAY_LATER_ASSET_URLS_STANDARD), StripeJsonUtils.optString(jSONObject2, FIELD_PAY_LATER_NAME), StripeJsonUtils.optString(jSONObject2, FIELD_PAY_LATER_REDIRECT_URL), StripeJsonUtils.optString(jSONObject2, FIELD_PAY_OVER_TIME_ASSET_URLS_DESCRIPTIVE), StripeJsonUtils.optString(jSONObject2, FIELD_PAY_OVER_TIME_ASSET_URLS_STANDARD), StripeJsonUtils.optString(jSONObject2, FIELD_PAY_OVER_TIME_NAME), StripeJsonUtils.optString(jSONObject2, FIELD_PAY_OVER_TIME_REDIRECT_URL), parseSet(jSONObject2, FIELD_PAYMENT_METHOD_CATEGORIES), parseSet(jSONObject2, FIELD_CUSTOM_PAYMENT_METHODS));
        }

        private final Set<String> parseSet(JSONObject jSONObject, String str) {
            List split$default;
            String optString = StripeJsonUtils.optString(jSONObject, str);
            Set<String> set = null;
            if (!(optString == null || (split$default = StringsKt.split$default((CharSequence) optString, new String[]{","}, false, 0, 6, (Object) null)) == null)) {
                set = CollectionsKt.toSet(split$default);
            }
            return set == null ? SetsKt.emptySet() : set;
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/stripe/android/model/parsers/SourceJsonParser$KlarnaJsonParser$Companion;", "", "()V", "FIELD_CLIENT_TOKEN", "", "FIELD_CUSTOM_PAYMENT_METHODS", "FIELD_FIRST_NAME", "FIELD_LAST_NAME", "FIELD_PAYMENT_METHOD_CATEGORIES", "FIELD_PAY_LATER_ASSET_URLS_DESCRIPTIVE", "FIELD_PAY_LATER_ASSET_URLS_STANDARD", "FIELD_PAY_LATER_NAME", "FIELD_PAY_LATER_REDIRECT_URL", "FIELD_PAY_NOW_ASSET_URLS_DESCRIPTIVE", "FIELD_PAY_NOW_ASSET_URLS_STANDARD", "FIELD_PAY_NOW_NAME", "FIELD_PAY_NOW_REDIRECT_URL", "FIELD_PAY_OVER_TIME_ASSET_URLS_DESCRIPTIVE", "FIELD_PAY_OVER_TIME_ASSET_URLS_STANDARD", "FIELD_PAY_OVER_TIME_NAME", "FIELD_PAY_OVER_TIME_REDIRECT_URL", "FIELD_PURCHASE_COUNTRY", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SourceJsonParser.kt */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u001b\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J.\u0010\"\u001a\u0004\u0018\u0001H#\"\n\b\u0000\u0010#\u0018\u0001*\u00020$2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0001\u0010%\u001a\u00020\u0004H\b¢\u0006\u0002\u0010&R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/stripe/android/model/parsers/SourceJsonParser$Companion;", "", "()V", "FIELD_AMOUNT", "", "FIELD_CLIENT_SECRET", "FIELD_CODE_VERIFICATION", "FIELD_CREATED", "FIELD_CURRENCY", "FIELD_FLOW", "FIELD_ID", "FIELD_KLARNA", "FIELD_LIVEMODE", "FIELD_OBJECT", "FIELD_OWNER", "FIELD_RECEIVER", "FIELD_REDIRECT", "FIELD_SOURCE_ORDER", "FIELD_STATEMENT_DESCRIPTOR", "FIELD_STATUS", "FIELD_TYPE", "FIELD_USAGE", "FIELD_WECHAT", "MODELED_TYPES", "", "VALUE_CARD", "VALUE_SOURCE", "asSourceType", "sourceType", "fromCardJson", "Lcom/stripe/android/model/Source;", "jsonObject", "Lorg/json/JSONObject;", "fromSourceJson", "optStripeJsonModel", "T", "Lcom/stripe/android/core/model/StripeModel;", "key", "(Lorg/json/JSONObject;Ljava/lang/String;)Lcom/stripe/android/core/model/StripeModel;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SourceJsonParser.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final Source fromCardJson(JSONObject jSONObject) {
            JSONObject jSONObject2 = jSONObject;
            return new Source(StripeJsonUtils.optString(jSONObject2, "id"), (Long) null, (String) null, (Source.CodeVerification) null, (Long) null, (String) null, (Source.Flow) null, (Boolean) null, (Source.Owner) null, (Source.Receiver) null, (Source.Redirect) null, (Source.Status) null, (Map) null, new SourceCardDataJsonParser().parse(jSONObject2), "card", "card", (Source.Usage) null, (WeChat) null, (Source.Klarna) null, (SourceOrder) null, (String) null, 2039806, (DefaultConstructorMarker) null);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v92, resolved type: com.stripe.android.model.Source$Receiver} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v98, resolved type: com.stripe.android.model.Source$Redirect} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v104, resolved type: com.stripe.android.model.SourceTypeModel$Card} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v110, resolved type: com.stripe.android.model.Source$Owner} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v116, resolved type: com.stripe.android.model.Source$CodeVerification} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v122, resolved type: com.stripe.android.model.SourceTypeModel$SepaDebit} */
        /* access modifiers changed from: private */
        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.stripe.android.model.Source fromSourceJson(org.json.JSONObject r29) {
            /*
                r28 = this;
                r0 = r29
                java.lang.String r1 = "type"
                java.lang.String r1 = com.stripe.android.core.model.StripeJsonUtils.optString(r0, r1)
                if (r1 != 0) goto L_0x000c
                java.lang.String r1 = "unknown"
            L_0x000c:
                r15 = r28
                java.lang.String r14 = r15.asSourceType(r1)
                com.stripe.android.core.model.StripeJsonUtils r2 = com.stripe.android.core.model.StripeJsonUtils.INSTANCE
                org.json.JSONObject r3 = r0.optJSONObject(r1)
                java.util.Map r16 = r2.jsonObjectToMap(r3)
                java.util.Set r2 = com.stripe.android.model.parsers.SourceJsonParser.MODELED_TYPES
                boolean r2 = r2.contains(r1)
                java.lang.String r3 = "owner"
                java.lang.String r4 = "redirect"
                java.lang.String r5 = "receiver"
                java.lang.String r6 = "code_verification"
                r7 = 0
                if (r2 == 0) goto L_0x00fb
                boolean r2 = r0.has(r1)
                if (r2 != 0) goto L_0x0038
                r2 = r7
                goto L_0x00f8
            L_0x0038:
                int r2 = r1.hashCode()
                switch(r2) {
                    case -808719889: goto L_0x00d1;
                    case -776144932: goto L_0x00b6;
                    case 3046160: goto L_0x0099;
                    case 106164915: goto L_0x007d;
                    case 1615551277: goto L_0x0060;
                    case 1636477296: goto L_0x0041;
                    default: goto L_0x003f;
                }
            L_0x003f:
                goto L_0x00ec
            L_0x0041:
                java.lang.String r2 = "sepa_debit"
                boolean r8 = r1.equals(r2)
                if (r8 != 0) goto L_0x004b
                goto L_0x00ec
            L_0x004b:
                org.json.JSONObject r2 = r0.optJSONObject(r2)
                if (r2 != 0) goto L_0x0053
                r2 = r7
                goto L_0x005c
            L_0x0053:
                com.stripe.android.model.parsers.SourceSepaDebitDataJsonParser r8 = new com.stripe.android.model.parsers.SourceSepaDebitDataJsonParser
                r8.<init>()
                com.stripe.android.model.SourceTypeModel$SepaDebit r2 = r8.parse((org.json.JSONObject) r2)
            L_0x005c:
                com.stripe.android.core.model.StripeModel r2 = (com.stripe.android.core.model.StripeModel) r2
                goto L_0x00ef
            L_0x0060:
                boolean r2 = r1.equals(r6)
                if (r2 != 0) goto L_0x0068
                goto L_0x00ec
            L_0x0068:
                org.json.JSONObject r2 = r0.optJSONObject(r6)
                if (r2 != 0) goto L_0x0070
                r2 = r7
                goto L_0x0079
            L_0x0070:
                com.stripe.android.model.parsers.SourceJsonParser$CodeVerificationJsonParser r8 = new com.stripe.android.model.parsers.SourceJsonParser$CodeVerificationJsonParser
                r8.<init>()
                com.stripe.android.model.Source$CodeVerification r2 = r8.parse((org.json.JSONObject) r2)
            L_0x0079:
                com.stripe.android.core.model.StripeModel r2 = (com.stripe.android.core.model.StripeModel) r2
                goto L_0x00ef
            L_0x007d:
                boolean r2 = r1.equals(r3)
                if (r2 != 0) goto L_0x0085
                goto L_0x00ec
            L_0x0085:
                org.json.JSONObject r2 = r0.optJSONObject(r3)
                if (r2 != 0) goto L_0x008d
                r2 = r7
                goto L_0x0096
            L_0x008d:
                com.stripe.android.model.parsers.SourceJsonParser$OwnerJsonParser r8 = new com.stripe.android.model.parsers.SourceJsonParser$OwnerJsonParser
                r8.<init>()
                com.stripe.android.model.Source$Owner r2 = r8.parse((org.json.JSONObject) r2)
            L_0x0096:
                com.stripe.android.core.model.StripeModel r2 = (com.stripe.android.core.model.StripeModel) r2
                goto L_0x00ef
            L_0x0099:
                java.lang.String r2 = "card"
                boolean r8 = r1.equals(r2)
                if (r8 != 0) goto L_0x00a2
                goto L_0x00ec
            L_0x00a2:
                org.json.JSONObject r2 = r0.optJSONObject(r2)
                if (r2 != 0) goto L_0x00aa
                r2 = r7
                goto L_0x00b3
            L_0x00aa:
                com.stripe.android.model.parsers.SourceCardDataJsonParser r8 = new com.stripe.android.model.parsers.SourceCardDataJsonParser
                r8.<init>()
                com.stripe.android.model.SourceTypeModel$Card r2 = r8.parse((org.json.JSONObject) r2)
            L_0x00b3:
                com.stripe.android.core.model.StripeModel r2 = (com.stripe.android.core.model.StripeModel) r2
                goto L_0x00ef
            L_0x00b6:
                boolean r2 = r1.equals(r4)
                if (r2 != 0) goto L_0x00bd
                goto L_0x00ec
            L_0x00bd:
                org.json.JSONObject r2 = r0.optJSONObject(r4)
                if (r2 != 0) goto L_0x00c5
                r2 = r7
                goto L_0x00ce
            L_0x00c5:
                com.stripe.android.model.parsers.SourceJsonParser$RedirectJsonParser r8 = new com.stripe.android.model.parsers.SourceJsonParser$RedirectJsonParser
                r8.<init>()
                com.stripe.android.model.Source$Redirect r2 = r8.parse((org.json.JSONObject) r2)
            L_0x00ce:
                com.stripe.android.core.model.StripeModel r2 = (com.stripe.android.core.model.StripeModel) r2
                goto L_0x00ef
            L_0x00d1:
                boolean r2 = r1.equals(r5)
                if (r2 != 0) goto L_0x00d8
                goto L_0x00ec
            L_0x00d8:
                org.json.JSONObject r2 = r0.optJSONObject(r5)
                if (r2 != 0) goto L_0x00e0
                r2 = r7
                goto L_0x00e9
            L_0x00e0:
                com.stripe.android.model.parsers.SourceJsonParser$ReceiverJsonParser r8 = new com.stripe.android.model.parsers.SourceJsonParser$ReceiverJsonParser
                r8.<init>()
                com.stripe.android.model.Source$Receiver r2 = r8.parse((org.json.JSONObject) r2)
            L_0x00e9:
                com.stripe.android.core.model.StripeModel r2 = (com.stripe.android.core.model.StripeModel) r2
                goto L_0x00ef
            L_0x00ec:
                r2 = r7
                com.stripe.android.core.model.StripeModel r2 = (com.stripe.android.core.model.StripeModel) r2
            L_0x00ef:
                boolean r8 = r2 instanceof com.stripe.android.model.SourceTypeModel
                if (r8 != 0) goto L_0x00f4
                r2 = r7
            L_0x00f4:
                com.stripe.android.model.SourceTypeModel r2 = (com.stripe.android.model.SourceTypeModel) r2
                com.stripe.android.core.model.StripeModel r2 = (com.stripe.android.core.model.StripeModel) r2
            L_0x00f8:
                com.stripe.android.model.SourceTypeModel r2 = (com.stripe.android.model.SourceTypeModel) r2
                goto L_0x00fe
            L_0x00fb:
                r2 = r7
                com.stripe.android.model.SourceTypeModel r2 = (com.stripe.android.model.SourceTypeModel) r2
            L_0x00fe:
                r17 = r2
                java.lang.String r2 = "id"
                java.lang.String r8 = com.stripe.android.core.model.StripeJsonUtils.optString(r0, r2)
                com.stripe.android.core.model.StripeJsonUtils r2 = com.stripe.android.core.model.StripeJsonUtils.INSTANCE
                java.lang.String r9 = "amount"
                java.lang.Long r9 = r2.optLong(r0, r9)
                java.lang.String r2 = "client_secret"
                java.lang.String r11 = com.stripe.android.core.model.StripeJsonUtils.optString(r0, r2)
                boolean r2 = r0.has(r6)
                if (r2 != 0) goto L_0x011c
                r2 = r7
                goto L_0x0138
            L_0x011c:
                org.json.JSONObject r2 = r0.optJSONObject(r6)
                if (r2 != 0) goto L_0x0124
                r2 = r7
                goto L_0x012d
            L_0x0124:
                com.stripe.android.model.parsers.SourceJsonParser$CodeVerificationJsonParser r6 = new com.stripe.android.model.parsers.SourceJsonParser$CodeVerificationJsonParser
                r6.<init>()
                com.stripe.android.model.Source$CodeVerification r2 = r6.parse((org.json.JSONObject) r2)
            L_0x012d:
                com.stripe.android.core.model.StripeModel r2 = (com.stripe.android.core.model.StripeModel) r2
                boolean r6 = r2 instanceof com.stripe.android.model.Source.CodeVerification
                if (r6 != 0) goto L_0x0134
                r2 = r7
            L_0x0134:
                com.stripe.android.model.Source$CodeVerification r2 = (com.stripe.android.model.Source.CodeVerification) r2
                com.stripe.android.core.model.StripeModel r2 = (com.stripe.android.core.model.StripeModel) r2
            L_0x0138:
                r6 = r2
                com.stripe.android.model.Source$CodeVerification r6 = (com.stripe.android.model.Source.CodeVerification) r6
                com.stripe.android.core.model.StripeJsonUtils r2 = com.stripe.android.core.model.StripeJsonUtils.INSTANCE
                java.lang.String r10 = "created"
                java.lang.Long r12 = r2.optLong(r0, r10)
                java.lang.String r2 = "currency"
                java.lang.String r13 = com.stripe.android.core.model.StripeJsonUtils.optString(r0, r2)
                com.stripe.android.model.Source$Flow$Companion r2 = com.stripe.android.model.Source.Flow.Companion
                java.lang.String r10 = "flow"
                java.lang.String r10 = com.stripe.android.core.model.StripeJsonUtils.optString(r0, r10)
                com.stripe.android.model.Source$Flow r18 = r2.fromCode(r10)
                java.lang.String r2 = "livemode"
                boolean r10 = r0.optBoolean(r2)
                boolean r2 = r0.has(r3)
                if (r2 != 0) goto L_0x0163
                r2 = r7
                goto L_0x017f
            L_0x0163:
                org.json.JSONObject r2 = r0.optJSONObject(r3)
                if (r2 != 0) goto L_0x016b
                r2 = r7
                goto L_0x0174
            L_0x016b:
                com.stripe.android.model.parsers.SourceJsonParser$OwnerJsonParser r3 = new com.stripe.android.model.parsers.SourceJsonParser$OwnerJsonParser
                r3.<init>()
                com.stripe.android.model.Source$Owner r2 = r3.parse((org.json.JSONObject) r2)
            L_0x0174:
                com.stripe.android.core.model.StripeModel r2 = (com.stripe.android.core.model.StripeModel) r2
                boolean r3 = r2 instanceof com.stripe.android.model.Source.Owner
                if (r3 != 0) goto L_0x017b
                r2 = r7
            L_0x017b:
                com.stripe.android.model.Source$Owner r2 = (com.stripe.android.model.Source.Owner) r2
                com.stripe.android.core.model.StripeModel r2 = (com.stripe.android.core.model.StripeModel) r2
            L_0x017f:
                r19 = r2
                com.stripe.android.model.Source$Owner r19 = (com.stripe.android.model.Source.Owner) r19
                boolean r2 = r0.has(r5)
                if (r2 != 0) goto L_0x018b
                r2 = r7
                goto L_0x01a7
            L_0x018b:
                org.json.JSONObject r2 = r0.optJSONObject(r5)
                if (r2 != 0) goto L_0x0193
                r2 = r7
                goto L_0x019c
            L_0x0193:
                com.stripe.android.model.parsers.SourceJsonParser$ReceiverJsonParser r3 = new com.stripe.android.model.parsers.SourceJsonParser$ReceiverJsonParser
                r3.<init>()
                com.stripe.android.model.Source$Receiver r2 = r3.parse((org.json.JSONObject) r2)
            L_0x019c:
                com.stripe.android.core.model.StripeModel r2 = (com.stripe.android.core.model.StripeModel) r2
                boolean r3 = r2 instanceof com.stripe.android.model.Source.Receiver
                if (r3 != 0) goto L_0x01a3
                r2 = r7
            L_0x01a3:
                com.stripe.android.model.Source$Receiver r2 = (com.stripe.android.model.Source.Receiver) r2
                com.stripe.android.core.model.StripeModel r2 = (com.stripe.android.core.model.StripeModel) r2
            L_0x01a7:
                r20 = r2
                com.stripe.android.model.Source$Receiver r20 = (com.stripe.android.model.Source.Receiver) r20
                boolean r2 = r0.has(r4)
                if (r2 != 0) goto L_0x01b3
                r2 = r7
                goto L_0x01cf
            L_0x01b3:
                org.json.JSONObject r2 = r0.optJSONObject(r4)
                if (r2 != 0) goto L_0x01bb
                r2 = r7
                goto L_0x01c4
            L_0x01bb:
                com.stripe.android.model.parsers.SourceJsonParser$RedirectJsonParser r3 = new com.stripe.android.model.parsers.SourceJsonParser$RedirectJsonParser
                r3.<init>()
                com.stripe.android.model.Source$Redirect r2 = r3.parse((org.json.JSONObject) r2)
            L_0x01c4:
                com.stripe.android.core.model.StripeModel r2 = (com.stripe.android.core.model.StripeModel) r2
                boolean r3 = r2 instanceof com.stripe.android.model.Source.Redirect
                if (r3 != 0) goto L_0x01cb
                r2 = r7
            L_0x01cb:
                com.stripe.android.model.Source$Redirect r2 = (com.stripe.android.model.Source.Redirect) r2
                com.stripe.android.core.model.StripeModel r2 = (com.stripe.android.core.model.StripeModel) r2
            L_0x01cf:
                r21 = r2
                com.stripe.android.model.Source$Redirect r21 = (com.stripe.android.model.Source.Redirect) r21
                java.lang.String r2 = "source_order"
                org.json.JSONObject r2 = r0.optJSONObject(r2)
                if (r2 != 0) goto L_0x01de
                r22 = r7
                goto L_0x01e9
            L_0x01de:
                com.stripe.android.model.parsers.SourceOrderJsonParser r3 = new com.stripe.android.model.parsers.SourceOrderJsonParser
                r3.<init>()
                com.stripe.android.model.SourceOrder r2 = r3.parse((org.json.JSONObject) r2)
                r22 = r2
            L_0x01e9:
                java.lang.String r2 = "statement_descriptor"
                java.lang.String r23 = com.stripe.android.core.model.StripeJsonUtils.optString(r0, r2)
                com.stripe.android.model.Source$Status$Companion r2 = com.stripe.android.model.Source.Status.Companion
                java.lang.String r3 = "status"
                java.lang.String r3 = com.stripe.android.core.model.StripeJsonUtils.optString(r0, r3)
                com.stripe.android.model.Source$Status r24 = r2.fromCode(r3)
                com.stripe.android.model.Source$Usage$Companion r2 = com.stripe.android.model.Source.Usage.Companion
                java.lang.String r3 = "usage"
                java.lang.String r3 = com.stripe.android.core.model.StripeJsonUtils.optString(r0, r3)
                com.stripe.android.model.Source$Usage r25 = r2.fromCode(r3)
                java.lang.String r2 = "wechat"
                boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r14)
                if (r3 == 0) goto L_0x0224
                com.stripe.android.model.parsers.WeChatJsonParser r3 = new com.stripe.android.model.parsers.WeChatJsonParser
                r3.<init>()
                org.json.JSONObject r2 = r0.optJSONObject(r2)
                if (r2 != 0) goto L_0x021f
                org.json.JSONObject r2 = new org.json.JSONObject
                r2.<init>()
            L_0x021f:
                com.stripe.android.model.WeChat r2 = r3.parse((org.json.JSONObject) r2)
                goto L_0x0227
            L_0x0224:
                r2 = r7
                com.stripe.android.model.WeChat r2 = (com.stripe.android.model.WeChat) r2
            L_0x0227:
                r26 = r2
                java.lang.String r2 = "klarna"
                boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r14)
                if (r3 == 0) goto L_0x0246
                com.stripe.android.model.parsers.SourceJsonParser$KlarnaJsonParser r3 = new com.stripe.android.model.parsers.SourceJsonParser$KlarnaJsonParser
                r3.<init>()
                org.json.JSONObject r0 = r0.optJSONObject(r2)
                if (r0 != 0) goto L_0x0241
                org.json.JSONObject r0 = new org.json.JSONObject
                r0.<init>()
            L_0x0241:
                com.stripe.android.model.Source$Klarna r0 = r3.parse((org.json.JSONObject) r0)
                goto L_0x0249
            L_0x0246:
                com.stripe.android.model.Source$Klarna r7 = (com.stripe.android.model.Source.Klarna) r7
                r0 = r7
            L_0x0249:
                com.stripe.android.model.Source r27 = new com.stripe.android.model.Source
                r2 = r27
                java.lang.Boolean r10 = java.lang.Boolean.valueOf(r10)
                r3 = r8
                r4 = r9
                r5 = r11
                r7 = r12
                r8 = r13
                r9 = r18
                r11 = r19
                r12 = r20
                r13 = r21
                r18 = r14
                r14 = r24
                r15 = r16
                r16 = r17
                r17 = r18
                r18 = r1
                r19 = r25
                r20 = r26
                r21 = r0
                r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
                return r27
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.model.parsers.SourceJsonParser.Companion.fromSourceJson(org.json.JSONObject):com.stripe.android.model.Source");
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final /* synthetic */ <T extends com.stripe.android.core.model.StripeModel> T optStripeJsonModel(org.json.JSONObject r3, java.lang.String r4) {
            /*
                r2 = this;
                boolean r0 = r3.has(r4)
                r1 = 0
                if (r0 != 0) goto L_0x0008
                return r1
            L_0x0008:
                int r0 = r4.hashCode()
                switch(r0) {
                    case -808719889: goto L_0x00bc;
                    case -776144932: goto L_0x009b;
                    case 3046160: goto L_0x007a;
                    case 106164915: goto L_0x0057;
                    case 1615551277: goto L_0x0034;
                    case 1636477296: goto L_0x0011;
                    default: goto L_0x000f;
                }
            L_0x000f:
                goto L_0x00dd
            L_0x0011:
                java.lang.String r0 = "sepa_debit"
                boolean r4 = r4.equals(r0)
                if (r4 != 0) goto L_0x001b
                goto L_0x00dd
            L_0x001b:
                org.json.JSONObject r3 = r3.optJSONObject(r0)
                if (r3 != 0) goto L_0x0022
                goto L_0x0030
            L_0x0022:
                org.json.JSONObject r3 = (org.json.JSONObject) r3
                com.stripe.android.model.parsers.SourceSepaDebitDataJsonParser r4 = new com.stripe.android.model.parsers.SourceSepaDebitDataJsonParser
                r4.<init>()
                com.stripe.android.model.SourceTypeModel$SepaDebit r3 = r4.parse((org.json.JSONObject) r3)
                r1 = r3
                com.stripe.android.model.SourceTypeModel$SepaDebit r1 = (com.stripe.android.model.SourceTypeModel.SepaDebit) r1
            L_0x0030:
                com.stripe.android.core.model.StripeModel r1 = (com.stripe.android.core.model.StripeModel) r1
                goto L_0x00df
            L_0x0034:
                java.lang.String r0 = "code_verification"
                boolean r4 = r4.equals(r0)
                if (r4 != 0) goto L_0x003e
                goto L_0x00dd
            L_0x003e:
                org.json.JSONObject r3 = r3.optJSONObject(r0)
                if (r3 != 0) goto L_0x0045
                goto L_0x0053
            L_0x0045:
                org.json.JSONObject r3 = (org.json.JSONObject) r3
                com.stripe.android.model.parsers.SourceJsonParser$CodeVerificationJsonParser r4 = new com.stripe.android.model.parsers.SourceJsonParser$CodeVerificationJsonParser
                r4.<init>()
                com.stripe.android.model.Source$CodeVerification r3 = r4.parse((org.json.JSONObject) r3)
                r1 = r3
                com.stripe.android.model.Source$CodeVerification r1 = (com.stripe.android.model.Source.CodeVerification) r1
            L_0x0053:
                com.stripe.android.core.model.StripeModel r1 = (com.stripe.android.core.model.StripeModel) r1
                goto L_0x00df
            L_0x0057:
                java.lang.String r0 = "owner"
                boolean r4 = r4.equals(r0)
                if (r4 != 0) goto L_0x0061
                goto L_0x00dd
            L_0x0061:
                org.json.JSONObject r3 = r3.optJSONObject(r0)
                if (r3 != 0) goto L_0x0068
                goto L_0x0076
            L_0x0068:
                org.json.JSONObject r3 = (org.json.JSONObject) r3
                com.stripe.android.model.parsers.SourceJsonParser$OwnerJsonParser r4 = new com.stripe.android.model.parsers.SourceJsonParser$OwnerJsonParser
                r4.<init>()
                com.stripe.android.model.Source$Owner r3 = r4.parse((org.json.JSONObject) r3)
                r1 = r3
                com.stripe.android.model.Source$Owner r1 = (com.stripe.android.model.Source.Owner) r1
            L_0x0076:
                com.stripe.android.core.model.StripeModel r1 = (com.stripe.android.core.model.StripeModel) r1
                goto L_0x00df
            L_0x007a:
                java.lang.String r0 = "card"
                boolean r4 = r4.equals(r0)
                if (r4 != 0) goto L_0x0083
                goto L_0x00dd
            L_0x0083:
                org.json.JSONObject r3 = r3.optJSONObject(r0)
                if (r3 != 0) goto L_0x008a
                goto L_0x0098
            L_0x008a:
                org.json.JSONObject r3 = (org.json.JSONObject) r3
                com.stripe.android.model.parsers.SourceCardDataJsonParser r4 = new com.stripe.android.model.parsers.SourceCardDataJsonParser
                r4.<init>()
                com.stripe.android.model.SourceTypeModel$Card r3 = r4.parse((org.json.JSONObject) r3)
                r1 = r3
                com.stripe.android.model.SourceTypeModel$Card r1 = (com.stripe.android.model.SourceTypeModel.Card) r1
            L_0x0098:
                com.stripe.android.core.model.StripeModel r1 = (com.stripe.android.core.model.StripeModel) r1
                goto L_0x00df
            L_0x009b:
                java.lang.String r0 = "redirect"
                boolean r4 = r4.equals(r0)
                if (r4 != 0) goto L_0x00a4
                goto L_0x00dd
            L_0x00a4:
                org.json.JSONObject r3 = r3.optJSONObject(r0)
                if (r3 != 0) goto L_0x00ab
                goto L_0x00b9
            L_0x00ab:
                org.json.JSONObject r3 = (org.json.JSONObject) r3
                com.stripe.android.model.parsers.SourceJsonParser$RedirectJsonParser r4 = new com.stripe.android.model.parsers.SourceJsonParser$RedirectJsonParser
                r4.<init>()
                com.stripe.android.model.Source$Redirect r3 = r4.parse((org.json.JSONObject) r3)
                r1 = r3
                com.stripe.android.model.Source$Redirect r1 = (com.stripe.android.model.Source.Redirect) r1
            L_0x00b9:
                com.stripe.android.core.model.StripeModel r1 = (com.stripe.android.core.model.StripeModel) r1
                goto L_0x00df
            L_0x00bc:
                java.lang.String r0 = "receiver"
                boolean r4 = r4.equals(r0)
                if (r4 != 0) goto L_0x00c5
                goto L_0x00dd
            L_0x00c5:
                org.json.JSONObject r3 = r3.optJSONObject(r0)
                if (r3 != 0) goto L_0x00cc
                goto L_0x00da
            L_0x00cc:
                org.json.JSONObject r3 = (org.json.JSONObject) r3
                com.stripe.android.model.parsers.SourceJsonParser$ReceiverJsonParser r4 = new com.stripe.android.model.parsers.SourceJsonParser$ReceiverJsonParser
                r4.<init>()
                com.stripe.android.model.Source$Receiver r3 = r4.parse((org.json.JSONObject) r3)
                r1 = r3
                com.stripe.android.model.Source$Receiver r1 = (com.stripe.android.model.Source.Receiver) r1
            L_0x00da:
                com.stripe.android.core.model.StripeModel r1 = (com.stripe.android.core.model.StripeModel) r1
                goto L_0x00df
            L_0x00dd:
                com.stripe.android.core.model.StripeModel r1 = (com.stripe.android.core.model.StripeModel) r1
            L_0x00df:
                r3 = 2
                java.lang.String r4 = "T"
                kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(r3, r4)
                com.stripe.android.core.model.StripeModel r1 = (com.stripe.android.core.model.StripeModel) r1
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.model.parsers.SourceJsonParser.Companion.optStripeJsonModel(org.json.JSONObject, java.lang.String):com.stripe.android.core.model.StripeModel");
        }

        private final String asSourceType(String str) {
            String str2 = str;
            if (str2 != null) {
                switch (str.hashCode()) {
                    case -1920743119:
                        if (str2.equals("bancontact")) {
                            return "bancontact";
                        }
                        break;
                    case -1414960566:
                        if (str2.equals("alipay")) {
                            return "alipay";
                        }
                        break;
                    case -1128905083:
                        if (str2.equals("klarna")) {
                            return "klarna";
                        }
                        break;
                    case -896955097:
                        if (str2.equals("sofort")) {
                            return "sofort";
                        }
                        break;
                    case -825238221:
                        if (str2.equals("three_d_secure")) {
                            return "three_d_secure";
                        }
                        break;
                    case -791770330:
                        if (str2.equals("wechat")) {
                            return "wechat";
                        }
                        break;
                    case -284840886:
                        boolean equals = str2.equals("unknown");
                        break;
                    case 100648:
                        if (str2.equals("eps")) {
                            return "eps";
                        }
                        break;
                    case 109234:
                        if (str2.equals("p24")) {
                            return "p24";
                        }
                        break;
                    case 3046160:
                        if (str2.equals("card")) {
                            return "card";
                        }
                        break;
                    case 38358441:
                        if (str2.equals("giropay")) {
                            return "giropay";
                        }
                        break;
                    case 100048981:
                        if (str2.equals("ideal")) {
                            return "ideal";
                        }
                        break;
                    case 1251821346:
                        if (str2.equals("multibanco")) {
                            return "multibanco";
                        }
                        break;
                    case 1636477296:
                        if (str2.equals("sepa_debit")) {
                            return "sepa_debit";
                        }
                        break;
                }
            }
            return "unknown";
        }
    }
}
