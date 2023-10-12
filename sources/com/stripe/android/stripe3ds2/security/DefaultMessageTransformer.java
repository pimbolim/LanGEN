package com.stripe.android.stripe3ds2.security;

import com.braintreepayments.api.internal.GraphQLConstants;
import com.nimbusds.jose.EncryptionMethod;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.JWEObject;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.crypto.DirectDecrypter;
import com.stripe.android.stripe3ds2.transactions.ChallengeRequestData;
import com.stripe.android.stripe3ds2.transactions.ChallengeResponseParseException;
import com.stripe.android.stripe3ds2.transactions.ProtocolError;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Locale;
import javax.crypto.SecretKey;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\b\u0018\u0000 ,2\u00020\u0001:\u0001,B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001f\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\t\u0010\t\u001a\u00020\u0003HÂ\u0003J\t\u0010\n\u001a\u00020\u0006HÂ\u0003J\t\u0010\u000b\u001a\u00020\u0006HÂ\u0003J'\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0015\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0001¢\u0006\u0002\b\u0011J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u001d\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0001¢\u0006\u0002\b\u0018J\u0018\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0013\u0010\u001b\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\u001d\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010 \u001a\u00020!H\u0001¢\u0006\u0002\b\"J\u001d\u0010#\u001a\u00020\u001f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010 \u001a\u00020!H\u0001¢\u0006\u0002\b$J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0010HÖ\u0001J\u0015\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0013H\u0001¢\u0006\u0002\b+R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/stripe/android/stripe3ds2/security/DefaultMessageTransformer;", "Lcom/stripe/android/stripe3ds2/security/MessageTransformer;", "isLiveMode", "", "(Z)V", "counterSdkToAcs", "", "counterAcsToSdk", "(ZBB)V", "component1", "component2", "component3", "copy", "createEncryptionHeader", "Lcom/nimbusds/jose/JWEHeader;", "keyId", "", "createEncryptionHeader$3ds2sdk_release", "decrypt", "Lorg/json/JSONObject;", "message", "secretKey", "Ljavax/crypto/SecretKey;", "decryptMessage", "decryptMessage$3ds2sdk_release", "encrypt", "challengeRequest", "equals", "other", "", "getDecryptionKey", "", "encryptionMethod", "Lcom/nimbusds/jose/EncryptionMethod;", "getDecryptionKey$3ds2sdk_release", "getEncryptionKey", "getEncryptionKey$3ds2sdk_release", "hashCode", "", "toString", "validateAcsToSdkCounter", "", "cres", "validateAcsToSdkCounter$3ds2sdk_release", "Companion", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DefaultMessageTransformer.kt */
public final class DefaultMessageTransformer implements MessageTransformer {
    public static final int BITS_IN_BYTE = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final EncryptionMethod ENCRYPTION_METHOD = EncryptionMethod.A128CBC_HS256;
    public static final String FIELD_ACS_COUNTER_ACS_TO_SDK = "acsCounterAtoS";
    public static final String FIELD_SDK_COUNTER_SDK_TO_ACS = "sdkCounterStoA";
    private byte counterAcsToSdk;
    private byte counterSdkToAcs;
    private final boolean isLiveMode;

    private final boolean component1() {
        return this.isLiveMode;
    }

    private final byte component2() {
        return this.counterSdkToAcs;
    }

    private final byte component3() {
        return this.counterAcsToSdk;
    }

    public static /* synthetic */ DefaultMessageTransformer copy$default(DefaultMessageTransformer defaultMessageTransformer, boolean z, byte b, byte b2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = defaultMessageTransformer.isLiveMode;
        }
        if ((i & 2) != 0) {
            b = defaultMessageTransformer.counterSdkToAcs;
        }
        if ((i & 4) != 0) {
            b2 = defaultMessageTransformer.counterAcsToSdk;
        }
        return defaultMessageTransformer.copy(z, b, b2);
    }

    public final DefaultMessageTransformer copy(boolean z, byte b, byte b2) {
        return new DefaultMessageTransformer(z, b, b2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DefaultMessageTransformer)) {
            return false;
        }
        DefaultMessageTransformer defaultMessageTransformer = (DefaultMessageTransformer) obj;
        return this.isLiveMode == defaultMessageTransformer.isLiveMode && this.counterSdkToAcs == defaultMessageTransformer.counterSdkToAcs && this.counterAcsToSdk == defaultMessageTransformer.counterAcsToSdk;
    }

    public int hashCode() {
        boolean z = this.isLiveMode;
        if (z) {
            z = true;
        }
        return ((((z ? 1 : 0) * true) + this.counterSdkToAcs) * 31) + this.counterAcsToSdk;
    }

    public String toString() {
        return "DefaultMessageTransformer(isLiveMode=" + this.isLiveMode + ", counterSdkToAcs=" + this.counterSdkToAcs + ", counterAcsToSdk=" + this.counterAcsToSdk + ')';
    }

    public DefaultMessageTransformer(boolean z, byte b, byte b2) {
        this.isLiveMode = z;
        this.counterSdkToAcs = b;
        this.counterAcsToSdk = b2;
    }

    public DefaultMessageTransformer(boolean z) {
        this(z, (byte) 0, (byte) 0);
    }

    public String encrypt(JSONObject jSONObject, SecretKey secretKey) throws JOSEException, JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "challengeRequest");
        Intrinsics.checkNotNullParameter(secretKey, "secretKey");
        String string = jSONObject.getString(ChallengeRequestData.FIELD_ACS_TRANS_ID);
        Intrinsics.checkNotNullExpressionValue(string, "challengeRequest.getStri…tData.FIELD_ACS_TRANS_ID)");
        JWEHeader createEncryptionHeader$3ds2sdk_release = createEncryptionHeader$3ds2sdk_release(string);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        boolean z = true;
        String format = String.format(Locale.ROOT, "%03d", Arrays.copyOf(new Object[]{Byte.valueOf(this.counterSdkToAcs)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
        jSONObject.put(FIELD_SDK_COUNTER_SDK_TO_ACS, format);
        JWEObject jWEObject = new JWEObject(createEncryptionHeader$3ds2sdk_release, new Payload(jSONObject.toString()));
        EncryptionMethod encryptionMethod = createEncryptionHeader$3ds2sdk_release.getEncryptionMethod();
        Intrinsics.checkNotNullExpressionValue(encryptionMethod, "header.encryptionMethod");
        jWEObject.encrypt(new TransactionEncrypter(getEncryptionKey$3ds2sdk_release(secretKey, encryptionMethod), this.counterSdkToAcs));
        byte b = (byte) (this.counterSdkToAcs + 1);
        this.counterSdkToAcs = b;
        if (b == 0) {
            z = false;
        }
        if (z) {
            String serialize = jWEObject.serialize();
            Intrinsics.checkNotNullExpressionValue(serialize, "jweObject.serialize()");
            return serialize;
        }
        throw new IllegalArgumentException("SDK to ACS counter is zero".toString());
    }

    public JSONObject decrypt(String str, SecretKey secretKey) throws ParseException, JOSEException, JSONException, ChallengeResponseParseException {
        Intrinsics.checkNotNullParameter(str, GraphQLConstants.Keys.MESSAGE);
        Intrinsics.checkNotNullParameter(secretKey, "secretKey");
        JSONObject decryptMessage$3ds2sdk_release = decryptMessage$3ds2sdk_release(str, secretKey);
        validateAcsToSdkCounter$3ds2sdk_release(decryptMessage$3ds2sdk_release);
        boolean z = true;
        byte b = (byte) (this.counterAcsToSdk + 1);
        this.counterAcsToSdk = b;
        if (b == 0) {
            z = false;
        }
        if (z) {
            return decryptMessage$3ds2sdk_release;
        }
        throw new IllegalArgumentException("ACS to SDK counter is zero".toString());
    }

    public final void validateAcsToSdkCounter$3ds2sdk_release(JSONObject jSONObject) throws ChallengeResponseParseException, JSONException {
        Object obj;
        Intrinsics.checkNotNullParameter(jSONObject, "cres");
        if (this.isLiveMode) {
            if (jSONObject.has(FIELD_ACS_COUNTER_ACS_TO_SDK)) {
                try {
                    Result.Companion companion = Result.Companion;
                    DefaultMessageTransformer defaultMessageTransformer = this;
                    String string = jSONObject.getString(FIELD_ACS_COUNTER_ACS_TO_SDK);
                    Intrinsics.checkNotNullExpressionValue(string, "cres.getString(FIELD_ACS_COUNTER_ACS_TO_SDK)");
                    obj = Result.m4709constructorimpl(Byte.valueOf(Byte.parseByte(string)));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.m4709constructorimpl(ResultKt.createFailure(th));
                }
                if (Result.m4712exceptionOrNullimpl(obj) == null) {
                    byte byteValue = ((Number) obj).byteValue();
                    if (this.counterAcsToSdk != byteValue) {
                        ProtocolError protocolError = ProtocolError.DataDecryptionFailure;
                        throw new ChallengeResponseParseException(protocolError, "Counters are not equal. SDK counter: " + this.counterAcsToSdk + ", ACS counter: " + byteValue);
                    }
                    return;
                }
                throw ChallengeResponseParseException.Companion.createInvalidDataElementFormat(FIELD_ACS_COUNTER_ACS_TO_SDK);
            }
            throw ChallengeResponseParseException.Companion.createRequiredDataElementMissing(FIELD_ACS_COUNTER_ACS_TO_SDK);
        }
    }

    public final JSONObject decryptMessage$3ds2sdk_release(String str, SecretKey secretKey) throws ParseException, JOSEException, JSONException {
        Intrinsics.checkNotNullParameter(str, GraphQLConstants.Keys.MESSAGE);
        Intrinsics.checkNotNullParameter(secretKey, "secretKey");
        JWEObject parse = JWEObject.parse(str);
        EncryptionMethod encryptionMethod = parse.getHeader().getEncryptionMethod();
        Intrinsics.checkNotNullExpressionValue(encryptionMethod, "jweObject.header.encryptionMethod");
        parse.decrypt(new DirectDecrypter(getDecryptionKey$3ds2sdk_release(secretKey, encryptionMethod)));
        return new JSONObject(parse.getPayload().toString());
    }

    public final JWEHeader createEncryptionHeader$3ds2sdk_release(String str) {
        Intrinsics.checkNotNullParameter(str, "keyId");
        JWEHeader build = new JWEHeader.Builder(JWEAlgorithm.DIR, ENCRYPTION_METHOD).keyID(str).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder(JWEAlgorithm.DIR…yId)\n            .build()");
        return build;
    }

    public final byte[] getDecryptionKey$3ds2sdk_release(SecretKey secretKey, EncryptionMethod encryptionMethod) {
        Intrinsics.checkNotNullParameter(secretKey, "secretKey");
        Intrinsics.checkNotNullParameter(encryptionMethod, "encryptionMethod");
        byte[] encoded = secretKey.getEncoded();
        if (EncryptionMethod.A128GCM == encryptionMethod) {
            byte[] copyOfRange = Arrays.copyOfRange(encoded, encoded.length - (EncryptionMethod.A128GCM.cekBitLength() / 8), encoded.length);
            Intrinsics.checkNotNullExpressionValue(copyOfRange, "{\n            Arrays.cop…e\n            )\n        }");
            return copyOfRange;
        }
        Intrinsics.checkNotNullExpressionValue(encoded, "{\n            encodedKey\n        }");
        return encoded;
    }

    public final byte[] getEncryptionKey$3ds2sdk_release(SecretKey secretKey, EncryptionMethod encryptionMethod) {
        Intrinsics.checkNotNullParameter(secretKey, "secretKey");
        Intrinsics.checkNotNullParameter(encryptionMethod, "encryptionMethod");
        byte[] encoded = secretKey.getEncoded();
        if (EncryptionMethod.A128GCM == encryptionMethod) {
            byte[] copyOfRange = Arrays.copyOfRange(encoded, 0, EncryptionMethod.A128GCM.cekBitLength() / 8);
            Intrinsics.checkNotNullExpressionValue(copyOfRange, "{\n            Arrays.cop…E\n            )\n        }");
            return copyOfRange;
        }
        Intrinsics.checkNotNullExpressionValue(encoded, "{\n            encodedKey\n        }");
        return encoded;
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/stripe3ds2/security/DefaultMessageTransformer$Companion;", "", "()V", "BITS_IN_BYTE", "", "ENCRYPTION_METHOD", "Lcom/nimbusds/jose/EncryptionMethod;", "kotlin.jvm.PlatformType", "FIELD_ACS_COUNTER_ACS_TO_SDK", "", "FIELD_SDK_COUNTER_SDK_TO_ACS", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DefaultMessageTransformer.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
