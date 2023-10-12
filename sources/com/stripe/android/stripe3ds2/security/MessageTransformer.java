package com.stripe.android.stripe3ds2.security;

import com.nimbusds.jose.JOSEException;
import com.stripe.android.stripe3ds2.transactions.ChallengeResponseParseException;
import java.io.Serializable;
import java.text.ParseException;
import javax.crypto.SecretKey;
import kotlin.Metadata;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\n"}, d2 = {"Lcom/stripe/android/stripe3ds2/security/MessageTransformer;", "Ljava/io/Serializable;", "decrypt", "Lorg/json/JSONObject;", "message", "", "secretKey", "Ljavax/crypto/SecretKey;", "encrypt", "challengeRequest", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageTransformer.kt */
public interface MessageTransformer extends Serializable {
    JSONObject decrypt(String str, SecretKey secretKey) throws ParseException, JOSEException, JSONException, ChallengeResponseParseException;

    String encrypt(JSONObject jSONObject, SecretKey secretKey) throws JSONException, JOSEException;
}
