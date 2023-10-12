package com.stripe.android.core.networking;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¨\u0006\u0004"}, d2 = {"responseJson", "Lorg/json/JSONObject;", "Lcom/stripe/android/core/networking/StripeResponse;", "", "stripe-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: StripeResponseKtx.kt */
public final class StripeResponseKtxKt {
    /* JADX WARNING: type inference failed for: r1v5, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final org.json.JSONObject responseJson(com.stripe.android.core.networking.StripeResponse<java.lang.String> r12) throws com.stripe.android.core.exception.APIException {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.Object r0 = r12.getBody()
            java.lang.String r0 = (java.lang.String) r0
            r1 = 0
            if (r0 != 0) goto L_0x000f
            goto L_0x0015
        L_0x000f:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x001d }
            r2.<init>(r0)     // Catch:{ JSONException -> 0x001d }
            r1 = r2
        L_0x0015:
            if (r1 != 0) goto L_0x001c
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
        L_0x001c:
            return r1
        L_0x001d:
            r2 = move-exception
            com.stripe.android.core.exception.APIException r11 = new com.stripe.android.core.exception.APIException
            r4 = 0
            r5 = 0
            r6 = 0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r7 = "\n                    Exception while parsing response body.\n                      Status code: "
            r3.append(r7)
            int r7 = r12.getCode()
            r3.append(r7)
            java.lang.String r7 = "\n                      Request-Id: "
            r3.append(r7)
            com.stripe.android.core.networking.RequestId r7 = r12.getRequestId()
            r3.append(r7)
            java.lang.String r7 = "\n                      Content-Type: "
            r3.append(r7)
            java.lang.String r7 = "Content-Type"
            java.util.List r12 = r12.getHeaderValue(r7)
            if (r12 != 0) goto L_0x004e
            goto L_0x0055
        L_0x004e:
            java.lang.Object r12 = kotlin.collections.CollectionsKt.firstOrNull(r12)
            r1 = r12
            java.lang.String r1 = (java.lang.String) r1
        L_0x0055:
            r3.append(r1)
            java.lang.String r12 = "\n                      Body: \""
            r3.append(r12)
            r3.append(r0)
            java.lang.String r12 = "\"\n                "
            r3.append(r12)
            java.lang.String r12 = r3.toString()
            java.lang.String r7 = kotlin.text.StringsKt.trimIndent(r12)
            r8 = r2
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            r9 = 7
            r10 = 0
            r3 = r11
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.core.networking.StripeResponseKtxKt.responseJson(com.stripe.android.core.networking.StripeResponse):org.json.JSONObject");
    }
}
