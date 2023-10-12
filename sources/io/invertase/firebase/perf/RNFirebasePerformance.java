package io.invertase.firebase.perf;

import android.util.Log;
import androidx.browser.trusted.sharing.ShareTarget;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.metrics.HttpMetric;
import com.google.firebase.perf.metrics.Trace;
import java.util.HashMap;
import java.util.Map;

public class RNFirebasePerformance extends ReactContextBaseJavaModule {
    private static final String TAG = "RNFirebasePerformance";
    private HashMap<String, HttpMetric> httpMetrics = new HashMap<>();
    private HashMap<String, Trace> traces = new HashMap<>();

    public String getName() {
        return TAG;
    }

    public RNFirebasePerformance(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        Log.d(TAG, "New instance");
    }

    @ReactMethod
    public void setPerformanceCollectionEnabled(Boolean bool, Promise promise) {
        FirebasePerformance.getInstance().setPerformanceCollectionEnabled(bool.booleanValue());
        promise.resolve((Object) null);
    }

    @ReactMethod
    public void getTraceAttribute(String str, String str2, Promise promise) {
        promise.resolve(getOrCreateTrace(str).getAttribute(str2));
    }

    @ReactMethod
    public void getTraceAttributes(String str, Promise promise) {
        Map attributes = getOrCreateTrace(str).getAttributes();
        WritableMap createMap = Arguments.createMap();
        for (Map.Entry entry : attributes.entrySet()) {
            createMap.putString((String) entry.getKey(), (String) entry.getValue());
        }
        promise.resolve(createMap);
    }

    @ReactMethod
    public void getTraceLongMetric(String str, String str2, Promise promise) {
        promise.resolve(Integer.valueOf(Long.valueOf(getOrCreateTrace(str).getLongMetric(str2)).intValue()));
    }

    @ReactMethod
    public void incrementTraceMetric(String str, String str2, Integer num, Promise promise) {
        getOrCreateTrace(str).incrementMetric(str2, num.longValue());
        promise.resolve((Object) null);
    }

    @ReactMethod
    public void putTraceAttribute(String str, String str2, String str3, Promise promise) {
        getOrCreateTrace(str).putAttribute(str2, str3);
        if (getOrCreateTrace(str).getAttributes().containsKey(str2)) {
            promise.resolve(true);
        } else {
            promise.resolve(false);
        }
    }

    @ReactMethod
    public void putTraceMetric(String str, String str2, Integer num, Promise promise) {
        getOrCreateTrace(str).putMetric(str2, num.longValue());
        promise.resolve((Object) null);
    }

    @ReactMethod
    public void removeTraceAttribute(String str, String str2, Promise promise) {
        getOrCreateTrace(str).removeAttribute(str2);
        promise.resolve((Object) null);
    }

    @ReactMethod
    public void startTrace(String str, Promise promise) {
        getOrCreateTrace(str).start();
        promise.resolve((Object) null);
    }

    @ReactMethod
    public void stopTrace(String str, Promise promise) {
        getOrCreateTrace(str).stop();
        this.traces.remove(str);
        promise.resolve((Object) null);
    }

    @ReactMethod
    public void getHttpMetricAttribute(String str, String str2, String str3, Promise promise) {
        promise.resolve(getOrCreateHttpMetric(str, str2).getAttribute(str3));
    }

    @ReactMethod
    public void getHttpMetricAttributes(String str, String str2, Promise promise) {
        Map attributes = getOrCreateHttpMetric(str, str2).getAttributes();
        WritableMap createMap = Arguments.createMap();
        for (Map.Entry entry : attributes.entrySet()) {
            createMap.putString((String) entry.getKey(), (String) entry.getValue());
        }
        promise.resolve(createMap);
    }

    @ReactMethod
    public void putHttpMetricAttribute(String str, String str2, String str3, String str4, Promise promise) {
        getOrCreateHttpMetric(str, str2).putAttribute(str3, str4);
        if (getOrCreateHttpMetric(str, str2).getAttributes().containsKey(str3)) {
            promise.resolve(true);
        } else {
            promise.resolve(false);
        }
    }

    @ReactMethod
    public void removeHttpMetricAttribute(String str, String str2, String str3, Promise promise) {
        getOrCreateHttpMetric(str, str2).removeAttribute(str3);
        promise.resolve((Object) null);
    }

    @ReactMethod
    public void setHttpMetricResponseCode(String str, String str2, Integer num, Promise promise) {
        getOrCreateHttpMetric(str, str2).setHttpResponseCode(num.intValue());
        promise.resolve((Object) null);
    }

    @ReactMethod
    public void setHttpMetricRequestPayloadSize(String str, String str2, Integer num, Promise promise) {
        getOrCreateHttpMetric(str, str2).setRequestPayloadSize(num.longValue());
        promise.resolve((Object) null);
    }

    @ReactMethod
    public void setHttpMetricResponseContentType(String str, String str2, String str3, Promise promise) {
        getOrCreateHttpMetric(str, str2).setResponseContentType(str3);
        promise.resolve((Object) null);
    }

    @ReactMethod
    public void setHttpMetricResponsePayloadSize(String str, String str2, Integer num, Promise promise) {
        getOrCreateHttpMetric(str, str2).setResponsePayloadSize(num.longValue());
        promise.resolve((Object) null);
    }

    @ReactMethod
    public void startHttpMetric(String str, String str2, Promise promise) {
        getOrCreateHttpMetric(str, str2).start();
        promise.resolve((Object) null);
    }

    @ReactMethod
    public void stopHttpMetric(String str, String str2, Promise promise) {
        getOrCreateHttpMetric(str, str2).stop();
        HashMap<String, HttpMetric> hashMap = this.httpMetrics;
        hashMap.remove(str + str2);
        promise.resolve((Object) null);
    }

    private Trace getOrCreateTrace(String str) {
        if (this.traces.containsKey(str)) {
            return this.traces.get(str);
        }
        Trace newTrace = FirebasePerformance.getInstance().newTrace(str);
        this.traces.put(str, newTrace);
        return newTrace;
    }

    private HttpMetric getOrCreateHttpMetric(String str, String str2) {
        String str3 = str + str2;
        if (this.httpMetrics.containsKey(str3)) {
            return this.httpMetrics.get(str3);
        }
        HttpMetric newHttpMetric = FirebasePerformance.getInstance().newHttpMetric(str, mapStringToMethod(str2));
        this.httpMetrics.put(str3, newHttpMetric);
        return newHttpMetric;
    }

    private String mapStringToMethod(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -531492226:
                if (str.equals("OPTIONS")) {
                    c = 0;
                    break;
                }
                break;
            case 70454:
                if (str.equals(ShareTarget.METHOD_GET)) {
                    c = 1;
                    break;
                }
                break;
            case 79599:
                if (str.equals("PUT")) {
                    c = 2;
                    break;
                }
                break;
            case 2213344:
                if (str.equals("HEAD")) {
                    c = 3;
                    break;
                }
                break;
            case 2461856:
                if (str.equals(ShareTarget.METHOD_POST)) {
                    c = 4;
                    break;
                }
                break;
            case 75900968:
                if (str.equals("PATCH")) {
                    c = 5;
                    break;
                }
                break;
            case 80083237:
                if (str.equals("TRACE")) {
                    c = 6;
                    break;
                }
                break;
            case 1669334218:
                if (str.equals("CONNECT")) {
                    c = 7;
                    break;
                }
                break;
            case 2012838315:
                if (str.equals("DELETE")) {
                    c = 8;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return "OPTIONS";
            case 1:
                return ShareTarget.METHOD_GET;
            case 2:
                return "PUT";
            case 3:
                return "HEAD";
            case 4:
                return ShareTarget.METHOD_POST;
            case 5:
                return "PATCH";
            case 6:
                return "TRACE";
            case 7:
                return "CONNECT";
            case 8:
                return "DELETE";
            default:
                return "";
        }
    }
}
