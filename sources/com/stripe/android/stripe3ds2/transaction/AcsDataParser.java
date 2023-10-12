package com.stripe.android.stripe3ds2.transaction;

import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bà\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/AcsDataParser;", "", "parse", "Lcom/stripe/android/stripe3ds2/transaction/AcsData;", "payloadJson", "Lorg/json/JSONObject;", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AcsDataParser.kt */
public interface AcsDataParser {
    AcsData parse(JSONObject jSONObject);
}
