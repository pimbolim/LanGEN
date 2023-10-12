package com.paypal.android.sdk.onetouch.core.fpti;

import android.os.Handler;
import android.os.Looper;
import com.braintreepayments.api.interfaces.HttpResponseCallback;
import com.nimbusds.jose.jwk.JWKParameterNames;
import com.nimbusds.jose.shaded.ow2asm.Opcodes;
import com.paypal.android.sdk.data.collector.InstallationIdentifier;
import com.paypal.android.sdk.onetouch.core.base.ContextInspector;
import com.paypal.android.sdk.onetouch.core.base.DeviceInspector;
import com.paypal.android.sdk.onetouch.core.base.URLEncoderHelper;
import com.paypal.android.sdk.onetouch.core.enums.Protocol;
import com.paypal.android.sdk.onetouch.core.network.EnvironmentManager;
import com.paypal.android.sdk.onetouch.core.network.PayPalHttpClient;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

public class FptiManager {
    private final ContextInspector mContextInspector;
    /* access modifiers changed from: private */
    public final PayPalHttpClient mHttpClient;
    private FptiToken mToken;

    public FptiManager(ContextInspector contextInspector, PayPalHttpClient payPalHttpClient) {
        this.mContextInspector = contextInspector;
        this.mHttpClient = payPalHttpClient;
    }

    public void trackFpti(TrackingPoint trackingPoint, String str, Map<String, String> map, Protocol protocol) {
        if (!EnvironmentManager.isMock(str)) {
            FptiToken fptiToken = this.mToken;
            if (fptiToken == null || !fptiToken.isValid()) {
                this.mToken = new FptiToken();
            }
            long currentTimeMillis = System.currentTimeMillis();
            String encode = URLEncoderHelper.encode(InstallationIdentifier.getInstallationGUID(this.mContextInspector.getContext()));
            StringBuilder sb = new StringBuilder();
            sb.append("mobile:otc:");
            sb.append(trackingPoint.getCd());
            sb.append(":");
            String str2 = "";
            sb.append(protocol != null ? protocol.name() : str2);
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sb2);
            sb3.append(":");
            sb3.append("Android:" + str + ":");
            if (trackingPoint.hasError()) {
                str2 = "|error";
            }
            sb3.append(str2);
            String sb4 = sb3.toString();
            HashMap hashMap = new HashMap(map);
            hashMap.put("apid", DeviceInspector.getApplicationInfoName(this.mContextInspector.getContext()) + "|" + "3.14.1" + "|" + this.mContextInspector.getContext().getPackageName());
            hashMap.put("bchn", "otc");
            hashMap.put("bzsr", "mobile");
            hashMap.put("dsid", encode);
            hashMap.put(JWKParameterNames.RSA_EXPONENT, "im");
            hashMap.put("g", getGmtOffsetInMinutes());
            hashMap.put("lgin", "out");
            hashMap.put("mapv", "3.14.1");
            hashMap.put("mcar", DeviceInspector.getSimOperatorName(this.mContextInspector.getContext()));
            hashMap.put("mdvs", DeviceInspector.getDeviceName());
            hashMap.put("mosv", DeviceInspector.getOs());
            hashMap.put("page", sb4);
            hashMap.put("pgrp", sb2);
            hashMap.put("rsta", Locale.getDefault().toString());
            hashMap.put("srce", "otc");
            hashMap.put("sv", "mobile");
            hashMap.put(JWKParameterNames.RSA_OTHER_PRIMES__FACTOR_CRT_COEFFICIENT, Long.toString(currentTimeMillis - ((long) getGMTOffset())));
            hashMap.put("vers", "Android:" + str + ":");
            hashMap.put("vid", this.mToken.mToken);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.accumulate("tracking_visitor_id", encode);
                jSONObject.accumulate("tracking_visit_id", this.mToken.mToken);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.accumulate("actor", jSONObject);
                jSONObject2.accumulate("channel", "mobile");
                jSONObject2.accumulate("tracking_event", Long.toString(currentTimeMillis));
                jSONObject2.accumulate("event_params", getEventParams(hashMap));
                sendRequest(new JSONObject().accumulate("events", jSONObject2).toString());
            } catch (JSONException unused) {
            }
        }
    }

    private JSONObject getEventParams(Map<String, String> map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String next : map.keySet()) {
            jSONObject.accumulate(next, map.get(next));
        }
        return jSONObject;
    }

    /* access modifiers changed from: package-private */
    public void sendRequest(final String str) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            public void run() {
                FptiManager.this.mHttpClient.post("tracking/events", str, (HttpResponseCallback) null);
            }
        }, (long) ((new Random().nextInt(Opcodes.ARRAYLENGTH) + 10) * 1000));
    }

    private int getGMTOffset() {
        return new GregorianCalendar().getTimeZone().getRawOffset();
    }

    private String getGmtOffsetInMinutes() {
        return Integer.toString((getGMTOffset() / 1000) / 60);
    }
}
