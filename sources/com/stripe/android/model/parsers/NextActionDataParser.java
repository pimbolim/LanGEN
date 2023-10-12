package com.stripe.android.model.parsers;

import android.net.Uri;
import com.stripe.android.core.model.StripeJsonUtils;
import com.stripe.android.core.model.parsers.ModelJsonParser;
import com.stripe.android.model.MicrodepositType;
import com.stripe.android.model.StripeIntent;
import com.stripe.android.model.WeChat;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\b\u0007\b\t\n\u000b\f\r\u000eB\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u000f"}, d2 = {"Lcom/stripe/android/model/parsers/NextActionDataParser;", "Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "Lcom/stripe/android/model/StripeIntent$NextActionData;", "()V", "parse", "json", "Lorg/json/JSONObject;", "AlipayRedirectParser", "BlikAuthorizeParser", "Companion", "DisplayOxxoDetailsJsonParser", "RedirectToUrlParser", "SdkDataJsonParser", "VerifyWithMicrodepositsParser", "WeChatPayRedirectParser", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NextActionDataParser.kt */
public final class NextActionDataParser implements ModelJsonParser<StripeIntent.NextActionData> {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final String FIELD_NEXT_ACTION_TYPE = "type";

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: NextActionDataParser.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StripeIntent.NextActionType.values().length];
            iArr[StripeIntent.NextActionType.DisplayOxxoDetails.ordinal()] = 1;
            iArr[StripeIntent.NextActionType.RedirectToUrl.ordinal()] = 2;
            iArr[StripeIntent.NextActionType.UseStripeSdk.ordinal()] = 3;
            iArr[StripeIntent.NextActionType.AlipayRedirect.ordinal()] = 4;
            iArr[StripeIntent.NextActionType.BlikAuthorize.ordinal()] = 5;
            iArr[StripeIntent.NextActionType.WeChatPayRedirect.ordinal()] = 6;
            iArr[StripeIntent.NextActionType.VerifyWithMicrodeposits.ordinal()] = 7;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public StripeIntent.NextActionData parse(JSONObject jSONObject) {
        int i;
        ModelJsonParser modelJsonParser;
        Intrinsics.checkNotNullParameter(jSONObject, "json");
        StripeIntent.NextActionType fromCode$payments_core_release = StripeIntent.NextActionType.Companion.fromCode$payments_core_release(jSONObject.optString("type"));
        if (fromCode$payments_core_release == null) {
            i = -1;
        } else {
            i = WhenMappings.$EnumSwitchMapping$0[fromCode$payments_core_release.ordinal()];
        }
        switch (i) {
            case 1:
                modelJsonParser = new DisplayOxxoDetailsJsonParser();
                break;
            case 2:
                modelJsonParser = new RedirectToUrlParser();
                break;
            case 3:
                modelJsonParser = new SdkDataJsonParser();
                break;
            case 4:
                modelJsonParser = new AlipayRedirectParser();
                break;
            case 5:
                modelJsonParser = new BlikAuthorizeParser();
                break;
            case 6:
                modelJsonParser = new WeChatPayRedirectParser();
                break;
            case 7:
                modelJsonParser = new VerifyWithMicrodepositsParser();
                break;
            default:
                return null;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject(fromCode$payments_core_release.getCode());
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        return (StripeIntent.NextActionData) modelJsonParser.parse(optJSONObject);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/stripe/android/model/parsers/NextActionDataParser$DisplayOxxoDetailsJsonParser;", "Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "Lcom/stripe/android/model/StripeIntent$NextActionData$DisplayOxxoDetails;", "()V", "parse", "json", "Lorg/json/JSONObject;", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: NextActionDataParser.kt */
    private static final class DisplayOxxoDetailsJsonParser implements ModelJsonParser<StripeIntent.NextActionData.DisplayOxxoDetails> {
        private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @Deprecated
        private static final String FIELD_EXPIRES_AFTER = "expires_after";
        @Deprecated
        private static final String FIELD_HOSTED_VOUCHER_URL = "hosted_voucher_url";
        @Deprecated
        private static final String FIELD_NUMBER = "number";

        public StripeIntent.NextActionData.DisplayOxxoDetails parse(JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(jSONObject, "json");
            return new StripeIntent.NextActionData.DisplayOxxoDetails(jSONObject.optInt(FIELD_EXPIRES_AFTER), StripeJsonUtils.optString(jSONObject, FIELD_NUMBER), StripeJsonUtils.optString(jSONObject, FIELD_HOSTED_VOUCHER_URL));
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/model/parsers/NextActionDataParser$DisplayOxxoDetailsJsonParser$Companion;", "", "()V", "FIELD_EXPIRES_AFTER", "", "FIELD_HOSTED_VOUCHER_URL", "FIELD_NUMBER", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: NextActionDataParser.kt */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/stripe/android/model/parsers/NextActionDataParser$RedirectToUrlParser;", "Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "Lcom/stripe/android/model/StripeIntent$NextActionData$RedirectToUrl;", "()V", "parse", "json", "Lorg/json/JSONObject;", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: NextActionDataParser.kt */
    public static final class RedirectToUrlParser implements ModelJsonParser<StripeIntent.NextActionData.RedirectToUrl> {
        private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @Deprecated
        public static final String FIELD_RETURN_URL = "return_url";
        @Deprecated
        public static final String FIELD_URL = "url";

        public StripeIntent.NextActionData.RedirectToUrl parse(JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(jSONObject, "json");
            if (!jSONObject.has("url")) {
                return null;
            }
            Uri parse = Uri.parse(jSONObject.getString("url"));
            Intrinsics.checkNotNullExpressionValue(parse, "parse(json.getString(FIELD_URL))");
            return new StripeIntent.NextActionData.RedirectToUrl(parse, jSONObject.optString("return_url"));
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/model/parsers/NextActionDataParser$RedirectToUrlParser$Companion;", "", "()V", "FIELD_RETURN_URL", "", "FIELD_URL", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: NextActionDataParser.kt */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/stripe/android/model/parsers/NextActionDataParser$AlipayRedirectParser;", "Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "Lcom/stripe/android/model/StripeIntent$NextActionData$AlipayRedirect;", "()V", "parse", "json", "Lorg/json/JSONObject;", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: NextActionDataParser.kt */
    public static final class AlipayRedirectParser implements ModelJsonParser<StripeIntent.NextActionData.AlipayRedirect> {
        private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @Deprecated
        public static final String FIELD_NATIVE_DATA = "native_data";
        @Deprecated
        public static final String FIELD_RETURN_URL = "return_url";
        @Deprecated
        public static final String FIELD_URL = "url";

        public StripeIntent.NextActionData.AlipayRedirect parse(JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(jSONObject, "json");
            String string = jSONObject.getString(FIELD_NATIVE_DATA);
            Intrinsics.checkNotNullExpressionValue(string, "json.getString(FIELD_NATIVE_DATA)");
            String string2 = jSONObject.getString("url");
            Intrinsics.checkNotNullExpressionValue(string2, "json.getString(FIELD_URL)");
            return new StripeIntent.NextActionData.AlipayRedirect(string, string2, StripeJsonUtils.optString(jSONObject, "return_url"));
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/model/parsers/NextActionDataParser$AlipayRedirectParser$Companion;", "", "()V", "FIELD_NATIVE_DATA", "", "FIELD_RETURN_URL", "FIELD_URL", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: NextActionDataParser.kt */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\n"}, d2 = {"Lcom/stripe/android/model/parsers/NextActionDataParser$SdkDataJsonParser;", "Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "Lcom/stripe/android/model/StripeIntent$NextActionData$SdkData;", "()V", "parse", "json", "Lorg/json/JSONObject;", "parseDirectoryServerEncryption", "Lcom/stripe/android/model/StripeIntent$NextActionData$SdkData$Use3DS2$DirectoryServerEncryption;", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: NextActionDataParser.kt */
    private static final class SdkDataJsonParser implements ModelJsonParser<StripeIntent.NextActionData.SdkData> {
        private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @Deprecated
        private static final String FIELD_CERTIFICATE = "certificate";
        @Deprecated
        private static final String FIELD_DIRECTORY_SERVER_ENCRYPTION = "directory_server_encryption";
        @Deprecated
        private static final String FIELD_DIRECTORY_SERVER_ID = "directory_server_id";
        @Deprecated
        private static final String FIELD_DIRECTORY_SERVER_NAME = "directory_server_name";
        @Deprecated
        private static final String FIELD_KEY_ID = "key_id";
        @Deprecated
        private static final String FIELD_ROOT_CAS = "root_certificate_authorities";
        @Deprecated
        private static final String FIELD_SERVER_TRANSACTION_ID = "server_transaction_id";
        @Deprecated
        private static final String FIELD_STRIPE_JS = "stripe_js";
        @Deprecated
        private static final String FIELD_THREE_D_SECURE_2_SOURCE = "three_d_secure_2_source";
        @Deprecated
        private static final String FIELD_TYPE = "type";
        @Deprecated
        private static final String TYPE_3DS1 = "three_d_secure_redirect";
        @Deprecated
        private static final String TYPE_3DS2 = "stripe_3ds2_fingerprint";

        public StripeIntent.NextActionData.SdkData parse(JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(jSONObject, "json");
            String optString = StripeJsonUtils.optString(jSONObject, "type");
            if (Intrinsics.areEqual((Object) optString, (Object) TYPE_3DS1)) {
                String optString2 = jSONObject.optString(FIELD_STRIPE_JS);
                Intrinsics.checkNotNullExpressionValue(optString2, "json.optString(FIELD_STRIPE_JS)");
                return new StripeIntent.NextActionData.SdkData.Use3DS1(optString2);
            } else if (!Intrinsics.areEqual((Object) optString, (Object) TYPE_3DS2)) {
                return null;
            } else {
                String optString3 = jSONObject.optString(FIELD_THREE_D_SECURE_2_SOURCE);
                Intrinsics.checkNotNullExpressionValue(optString3, "json.optString(FIELD_THREE_D_SECURE_2_SOURCE)");
                String optString4 = jSONObject.optString(FIELD_DIRECTORY_SERVER_NAME);
                Intrinsics.checkNotNullExpressionValue(optString4, "json.optString(FIELD_DIRECTORY_SERVER_NAME)");
                String optString5 = jSONObject.optString(FIELD_SERVER_TRANSACTION_ID);
                Intrinsics.checkNotNullExpressionValue(optString5, "json.optString(FIELD_SERVER_TRANSACTION_ID)");
                JSONObject optJSONObject = jSONObject.optJSONObject(FIELD_DIRECTORY_SERVER_ENCRYPTION);
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
                return new StripeIntent.NextActionData.SdkData.Use3DS2(optString3, optString4, optString5, parseDirectoryServerEncryption(optJSONObject));
            }
        }

        private final StripeIntent.NextActionData.SdkData.Use3DS2.DirectoryServerEncryption parseDirectoryServerEncryption(JSONObject jSONObject) {
            List list;
            List jsonArrayToList = StripeJsonUtils.INSTANCE.jsonArrayToList(jSONObject.optJSONArray(FIELD_ROOT_CAS));
            if (jsonArrayToList == null) {
                list = null;
            } else {
                List emptyList = CollectionsKt.emptyList();
                for (Object next : jsonArrayToList) {
                    if (next instanceof String) {
                        emptyList = CollectionsKt.plus(emptyList, next);
                    }
                }
                list = emptyList;
            }
            if (list == null) {
                list = CollectionsKt.emptyList();
            }
            String optString = jSONObject.optString(FIELD_DIRECTORY_SERVER_ID);
            Intrinsics.checkNotNullExpressionValue(optString, "json.optString(FIELD_DIRECTORY_SERVER_ID)");
            String optString2 = jSONObject.optString(FIELD_CERTIFICATE);
            Intrinsics.checkNotNullExpressionValue(optString2, "json.optString(FIELD_CERTIFICATE)");
            return new StripeIntent.NextActionData.SdkData.Use3DS2.DirectoryServerEncryption(optString, optString2, list, jSONObject.optString(FIELD_KEY_ID));
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/stripe/android/model/parsers/NextActionDataParser$SdkDataJsonParser$Companion;", "", "()V", "FIELD_CERTIFICATE", "", "FIELD_DIRECTORY_SERVER_ENCRYPTION", "FIELD_DIRECTORY_SERVER_ID", "FIELD_DIRECTORY_SERVER_NAME", "FIELD_KEY_ID", "FIELD_ROOT_CAS", "FIELD_SERVER_TRANSACTION_ID", "FIELD_STRIPE_JS", "FIELD_THREE_D_SECURE_2_SOURCE", "FIELD_TYPE", "TYPE_3DS1", "TYPE_3DS2", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: NextActionDataParser.kt */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/model/parsers/NextActionDataParser$BlikAuthorizeParser;", "Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "Lcom/stripe/android/model/StripeIntent$NextActionData$BlikAuthorize;", "()V", "parse", "json", "Lorg/json/JSONObject;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: NextActionDataParser.kt */
    public static final class BlikAuthorizeParser implements ModelJsonParser<StripeIntent.NextActionData.BlikAuthorize> {
        public StripeIntent.NextActionData.BlikAuthorize parse(JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(jSONObject, "json");
            return StripeIntent.NextActionData.BlikAuthorize.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/stripe/android/model/parsers/NextActionDataParser$WeChatPayRedirectParser;", "Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "Lcom/stripe/android/model/StripeIntent$NextActionData$WeChatPayRedirect;", "()V", "parse", "json", "Lorg/json/JSONObject;", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: NextActionDataParser.kt */
    public static final class WeChatPayRedirectParser implements ModelJsonParser<StripeIntent.NextActionData.WeChatPayRedirect> {
        @Deprecated
        private static final String APP_ID = "app_id";
        private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @Deprecated
        private static final String NONCE_STR = "nonce_str";
        @Deprecated
        private static final String PACKAGE = "package";
        @Deprecated
        private static final String PARTNER_ID = "partner_id";
        @Deprecated
        private static final String PREPAY_ID = "prepay_id";
        @Deprecated
        private static final String SIGN = "sign";
        @Deprecated
        private static final String TIMESTAMP = "timestamp";

        public StripeIntent.NextActionData.WeChatPayRedirect parse(JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(jSONObject, "json");
            return new StripeIntent.NextActionData.WeChatPayRedirect(new WeChat((String) null, jSONObject.optString("app_id"), jSONObject.optString(NONCE_STR), jSONObject.optString(PACKAGE), jSONObject.optString(PARTNER_ID), jSONObject.optString(PREPAY_ID), jSONObject.optString(SIGN), jSONObject.optString("timestamp"), (String) null, 257, (DefaultConstructorMarker) null));
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/model/parsers/NextActionDataParser$WeChatPayRedirectParser$Companion;", "", "()V", "APP_ID", "", "NONCE_STR", "PACKAGE", "PARTNER_ID", "PREPAY_ID", "SIGN", "TIMESTAMP", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: NextActionDataParser.kt */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\n"}, d2 = {"Lcom/stripe/android/model/parsers/NextActionDataParser$VerifyWithMicrodepositsParser;", "Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "Lcom/stripe/android/model/StripeIntent$NextActionData$VerifyWithMicrodeposits;", "()V", "parse", "json", "Lorg/json/JSONObject;", "parseMicrodepositType", "Lcom/stripe/android/model/MicrodepositType;", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: NextActionDataParser.kt */
    public static final class VerifyWithMicrodepositsParser implements ModelJsonParser<StripeIntent.NextActionData.VerifyWithMicrodeposits> {
        @Deprecated
        private static final String ARRIVAL_DATE = "arrival_date";
        private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @Deprecated
        private static final String HOSTED_VERIFICATION_URL = "hosted_verification_url";
        @Deprecated
        private static final String MICRODEPOSIT_TYPE = "microdeposit_type";

        public StripeIntent.NextActionData.VerifyWithMicrodeposits parse(JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(jSONObject, "json");
            long optLong = jSONObject.optLong(ARRIVAL_DATE);
            String optString = jSONObject.optString(HOSTED_VERIFICATION_URL);
            Intrinsics.checkNotNullExpressionValue(optString, "json.optString(HOSTED_VERIFICATION_URL)");
            return new StripeIntent.NextActionData.VerifyWithMicrodeposits(optLong, optString, parseMicrodepositType(jSONObject));
        }

        private final MicrodepositType parseMicrodepositType(JSONObject jSONObject) {
            MicrodepositType microdepositType;
            MicrodepositType[] values = MicrodepositType.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    microdepositType = null;
                    break;
                }
                microdepositType = values[i];
                i++;
                if (Intrinsics.areEqual((Object) microdepositType.getValue(), (Object) jSONObject.optString(MICRODEPOSIT_TYPE))) {
                    break;
                }
            }
            return microdepositType == null ? MicrodepositType.UNKNOWN : microdepositType;
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/model/parsers/NextActionDataParser$VerifyWithMicrodepositsParser$Companion;", "", "()V", "ARRIVAL_DATE", "", "HOSTED_VERIFICATION_URL", "MICRODEPOSIT_TYPE", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: NextActionDataParser.kt */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/model/parsers/NextActionDataParser$Companion;", "", "()V", "FIELD_NEXT_ACTION_TYPE", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: NextActionDataParser.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
