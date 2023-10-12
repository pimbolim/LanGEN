package io.invertase.firebase.admob;

import androidx.autofill.HintConstants;
import com.braintreepayments.api.internal.GraphQLConstants;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.VideoOptions;
import com.stripe.android.model.PaymentMethodOptionsParams;
import io.invertase.firebase.Utils;
import java.util.Iterator;

class RNFirebaseAdMobUtils {
    RNFirebaseAdMobUtils() {
    }

    static WritableMap errorCodeToMap(int i) {
        WritableMap createMap = Arguments.createMap();
        if (i == 0) {
            createMap.putString(PaymentMethodOptionsParams.Blik.PARAM_CODE, "admob/error-code-internal-error");
            createMap.putString(GraphQLConstants.Keys.MESSAGE, "Something happened internally; for instance, an invalid response was received from the ad server.");
        } else if (i == 1) {
            createMap.putString(PaymentMethodOptionsParams.Blik.PARAM_CODE, "admob/error-code-invalid-request");
            createMap.putString(GraphQLConstants.Keys.MESSAGE, "The ad request was invalid; for instance, the ad unit ID was incorrect.");
        } else if (i == 2) {
            createMap.putString(PaymentMethodOptionsParams.Blik.PARAM_CODE, "admob/error-code-network-error");
            createMap.putString(GraphQLConstants.Keys.MESSAGE, "The ad request was unsuccessful due to network connectivity.");
        } else if (i == 3) {
            createMap.putString(PaymentMethodOptionsParams.Blik.PARAM_CODE, "admob/error-code-no-fill");
            createMap.putString(GraphQLConstants.Keys.MESSAGE, "The ad request was successful, but no ad was returned due to lack of ad inventory.");
        }
        return createMap;
    }

    static AdRequest.Builder buildRequest(ReadableMap readableMap) {
        AdRequest.Builder builder = new AdRequest.Builder();
        if (readableMap.hasKey("isDesignedForFamilies")) {
            builder.setIsDesignedForFamilies(readableMap.getBoolean("isDesignedForFamilies"));
        }
        if (readableMap.hasKey("tagForChildDirectedTreatment")) {
            builder.tagForChildDirectedTreatment(readableMap.getBoolean("tagForChildDirectedTreatment"));
        }
        if (readableMap.hasKey("contentUrl")) {
            builder.setContentUrl(readableMap.getString("contentUrl"));
        }
        if (readableMap.hasKey("requestAgent")) {
            builder.setRequestAgent(readableMap.getString("requestAgent"));
        }
        if (readableMap.hasKey(HintConstants.AUTOFILL_HINT_GENDER)) {
            String string = readableMap.getString(HintConstants.AUTOFILL_HINT_GENDER);
            string.hashCode();
            char c = 65535;
            switch (string.hashCode()) {
                case -1278174388:
                    if (string.equals("female")) {
                        c = 0;
                        break;
                    }
                    break;
                case -284840886:
                    if (string.equals("unknown")) {
                        c = 1;
                        break;
                    }
                    break;
                case 3343885:
                    if (string.equals("male")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    builder.setGender(2);
                    break;
                case 1:
                    builder.setGender(0);
                    break;
                case 2:
                    builder.setGender(1);
                    break;
            }
        }
        for (Object next : Utils.recursivelyDeconstructReadableArray(readableMap.getArray("testDevices"))) {
            if (next == "DEVICE_ID_EMULATOR") {
                builder.addTestDevice("B3EEABB8EE11C2BE770B684D95219ECB");
            } else {
                builder.addTestDevice((String) next);
            }
        }
        Iterator<Object> it = Utils.recursivelyDeconstructReadableArray(readableMap.getArray("keywords")).iterator();
        while (it.hasNext()) {
            builder.addKeyword((String) it.next());
        }
        return builder;
    }

    static VideoOptions.Builder buildVideoOptions(ReadableMap readableMap) {
        VideoOptions.Builder builder = new VideoOptions.Builder();
        builder.setStartMuted(readableMap.getBoolean("startMuted"));
        return builder;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0077, code lost:
        if (r4.equals("LARGE_BANNER") != false) goto L_0x007b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.google.android.gms.ads.AdSize stringToAdSize(java.lang.String r4) {
        /*
            java.lang.String r0 = "([0-9]+)x([0-9]+)"
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)
            java.util.regex.Matcher r0 = r0.matcher(r4)
            boolean r1 = r0.find()
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0028
            java.lang.String r4 = r0.group(r3)
            int r4 = java.lang.Integer.parseInt(r4)
            java.lang.String r0 = r0.group(r2)
            int r0 = java.lang.Integer.parseInt(r0)
            com.google.android.gms.ads.AdSize r1 = new com.google.android.gms.ads.AdSize
            r1.<init>(r4, r0)
            return r1
        L_0x0028:
            java.lang.String r4 = r4.toUpperCase()
            r0 = -1
            int r1 = r4.hashCode()
            switch(r1) {
                case -1966536496: goto L_0x0071;
                case -1008851236: goto L_0x0067;
                case -140586366: goto L_0x005d;
                case -96588539: goto L_0x0053;
                case 446888797: goto L_0x0049;
                case 1669469470: goto L_0x003f;
                case 1951953708: goto L_0x0035;
                default: goto L_0x0034;
            }
        L_0x0034:
            goto L_0x007a
        L_0x0035:
            java.lang.String r1 = "BANNER"
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L_0x007a
            r2 = 1
            goto L_0x007b
        L_0x003f:
            java.lang.String r1 = "SMART_BANNER_LANDSCAPE"
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L_0x007a
            r2 = 7
            goto L_0x007b
        L_0x0049:
            java.lang.String r1 = "LEADERBOARD"
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L_0x007a
            r2 = 5
            goto L_0x007b
        L_0x0053:
            java.lang.String r1 = "MEDIUM_RECTANGLE"
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L_0x007a
            r2 = 3
            goto L_0x007b
        L_0x005d:
            java.lang.String r1 = "SMART_BANNER"
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L_0x007a
            r2 = 6
            goto L_0x007b
        L_0x0067:
            java.lang.String r1 = "FULL_BANNER"
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L_0x007a
            r2 = 4
            goto L_0x007b
        L_0x0071:
            java.lang.String r1 = "LARGE_BANNER"
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L_0x007a
            goto L_0x007b
        L_0x007a:
            r2 = -1
        L_0x007b:
            switch(r2) {
                case 2: goto L_0x0090;
                case 3: goto L_0x008d;
                case 4: goto L_0x008a;
                case 5: goto L_0x0087;
                case 6: goto L_0x0084;
                case 7: goto L_0x0081;
                default: goto L_0x007e;
            }
        L_0x007e:
            com.google.android.gms.ads.AdSize r4 = com.google.android.gms.ads.AdSize.BANNER
            return r4
        L_0x0081:
            com.google.android.gms.ads.AdSize r4 = com.google.android.gms.ads.AdSize.SMART_BANNER
            return r4
        L_0x0084:
            com.google.android.gms.ads.AdSize r4 = com.google.android.gms.ads.AdSize.SMART_BANNER
            return r4
        L_0x0087:
            com.google.android.gms.ads.AdSize r4 = com.google.android.gms.ads.AdSize.LEADERBOARD
            return r4
        L_0x008a:
            com.google.android.gms.ads.AdSize r4 = com.google.android.gms.ads.AdSize.FULL_BANNER
            return r4
        L_0x008d:
            com.google.android.gms.ads.AdSize r4 = com.google.android.gms.ads.AdSize.MEDIUM_RECTANGLE
            return r4
        L_0x0090:
            com.google.android.gms.ads.AdSize r4 = com.google.android.gms.ads.AdSize.LARGE_BANNER
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.invertase.firebase.admob.RNFirebaseAdMobUtils.stringToAdSize(java.lang.String):com.google.android.gms.ads.AdSize");
    }
}
