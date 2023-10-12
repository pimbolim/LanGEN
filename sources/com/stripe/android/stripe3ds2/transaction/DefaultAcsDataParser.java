package com.stripe.android.stripe3ds2.transaction;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.ECKey;
import com.nimbusds.jose.util.JSONObjectUtils;
import com.stripe.android.stripe3ds2.observability.ErrorReporter;
import java.security.interfaces.ECPublicKey;
import java.text.ParseException;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u0000 \r2\u00020\u0001:\u0001\rB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/DefaultAcsDataParser;", "Lcom/stripe/android/stripe3ds2/transaction/AcsDataParser;", "errorReporter", "Lcom/stripe/android/stripe3ds2/observability/ErrorReporter;", "(Lcom/stripe/android/stripe3ds2/observability/ErrorReporter;)V", "parse", "Lcom/stripe/android/stripe3ds2/transaction/AcsData;", "payloadJson", "Lorg/json/JSONObject;", "parsePublicKey", "Ljava/security/interfaces/ECPublicKey;", "ephemPubkey", "", "Companion", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AcsDataParser.kt */
public final class DefaultAcsDataParser implements AcsDataParser {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String FIELD_ACS_EPHEM_PUB_KEY = "acsEphemPubKey";
    public static final String FIELD_ACS_URL = "acsURL";
    public static final String FIELD_SDK_EPHEM_PUB_KEY = "sdkEphemPubKey";
    private final ErrorReporter errorReporter;

    public DefaultAcsDataParser(ErrorReporter errorReporter2) {
        Intrinsics.checkNotNullParameter(errorReporter2, "errorReporter");
        this.errorReporter = errorReporter2;
    }

    public AcsData parse(JSONObject jSONObject) throws JSONException, ParseException, JOSEException {
        Object obj;
        Intrinsics.checkNotNullParameter(jSONObject, "payloadJson");
        try {
            Result.Companion companion = Result.Companion;
            DefaultAcsDataParser defaultAcsDataParser = this;
            Map<String, Object> parse = JSONObjectUtils.parse(jSONObject.toString());
            Intrinsics.checkNotNullExpressionValue(parse, "parse(payloadJson.toString())");
            Map<String, Object> map = MapsKt.toMap(parse);
            obj = Result.m4709constructorimpl(new AcsData(String.valueOf(map.get(FIELD_ACS_URL)), defaultAcsDataParser.parsePublicKey(map.get(FIELD_ACS_EPHEM_PUB_KEY)), defaultAcsDataParser.parsePublicKey(map.get(FIELD_SDK_EPHEM_PUB_KEY))));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m4709constructorimpl(ResultKt.createFailure(th));
        }
        Throwable r1 = Result.m4712exceptionOrNullimpl(obj);
        if (r1 != null) {
            this.errorReporter.reportError(new IllegalArgumentException(Intrinsics.stringPlus("Failed to parse ACS data: ", jSONObject), r1));
        }
        ResultKt.throwOnFailure(obj);
        return (AcsData) obj;
    }

    private final ECPublicKey parsePublicKey(Object obj) {
        ECKey eCKey;
        String str;
        if (obj instanceof Map) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
            eCKey = ECKey.parse((Map<String, Object>) (Map) obj);
        } else {
            if (obj == null) {
                str = null;
            } else {
                str = obj.toString();
            }
            if (str == null) {
                str = "";
            }
            eCKey = ECKey.parse(str);
        }
        ECPublicKey eCPublicKey = eCKey.toECPublicKey();
        Intrinsics.checkNotNullExpressionValue(eCPublicKey, "when (ephemPubkey) {\n   …        }.toECPublicKey()");
        return eCPublicKey;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/DefaultAcsDataParser$Companion;", "", "()V", "FIELD_ACS_EPHEM_PUB_KEY", "", "FIELD_ACS_URL", "FIELD_SDK_EPHEM_PUB_KEY", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AcsDataParser.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
