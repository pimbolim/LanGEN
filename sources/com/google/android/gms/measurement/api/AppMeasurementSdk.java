package com.google.android.gms.measurement.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzz;
import com.google.android.gms.measurement.internal.zzgk;
import com.google.android.gms.measurement.internal.zzgn;
import java.util.List;
import java.util.Map;

public class AppMeasurementSdk {
    private final zzz zzo;

    public static final class ConditionalUserProperty {
        public static final String ACTIVE = "active";
        public static final String CREATION_TIMESTAMP = "creation_timestamp";
        public static final String EXPIRED_EVENT_NAME = "expired_event_name";
        public static final String EXPIRED_EVENT_PARAMS = "expired_event_params";
        public static final String NAME = "name";
        public static final String ORIGIN = "origin";
        public static final String TIMED_OUT_EVENT_NAME = "timed_out_event_name";
        public static final String TIMED_OUT_EVENT_PARAMS = "timed_out_event_params";
        public static final String TIME_TO_LIVE = "time_to_live";
        public static final String TRIGGERED_EVENT_NAME = "triggered_event_name";
        public static final String TRIGGERED_EVENT_PARAMS = "triggered_event_params";
        public static final String TRIGGERED_TIMESTAMP = "triggered_timestamp";
        public static final String TRIGGER_EVENT_NAME = "trigger_event_name";
        public static final String TRIGGER_TIMEOUT = "trigger_timeout";
        public static final String VALUE = "value";

        private ConditionalUserProperty() {
        }
    }

    public interface EventInterceptor extends zzgk {
        void interceptEvent(String str, String str2, Bundle bundle, long j);
    }

    public interface OnEventListener extends zzgn {
        void onEvent(String str, String str2, Bundle bundle, long j);
    }

    public static AppMeasurementSdk getInstance(Context context) {
        return zzz.zza(context).zzg();
    }

    public static AppMeasurementSdk getInstance(Context context, String str, String str2, String str3, Bundle bundle) {
        return zzz.zza(context, str, str2, str3, bundle).zzg();
    }

    public AppMeasurementSdk(zzz zzz) {
        this.zzo = zzz;
    }

    public void setMeasurementEnabled(boolean z) {
        this.zzo.setMeasurementEnabled(z);
    }

    public void logEvent(String str, String str2, Bundle bundle) {
        this.zzo.logEventInternal(str, str2, bundle);
    }

    public void logEventNoInterceptor(String str, String str2, Bundle bundle, long j) {
        this.zzo.logEventInternalNoInterceptor(str, str2, bundle, j);
    }

    public void setUserProperty(String str, String str2, Object obj) {
        this.zzo.setUserPropertyInternal(str, str2, obj);
    }

    public Map<String, Object> getUserProperties(String str, String str2, boolean z) {
        return this.zzo.getUserProperties(str, str2, z);
    }

    public void setConditionalUserProperty(Bundle bundle) {
        this.zzo.setConditionalUserProperty(bundle);
    }

    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        this.zzo.clearConditionalUserProperty(str, str2, bundle);
    }

    public List<Bundle> getConditionalUserProperties(String str, String str2) {
        return this.zzo.getConditionalUserProperties(str, str2);
    }

    public String getCurrentScreenName() {
        return this.zzo.getCurrentScreenName();
    }

    public String getCurrentScreenClass() {
        return this.zzo.getCurrentScreenClass();
    }

    public String getAppInstanceId() {
        return this.zzo.zzi();
    }

    public String getGmpAppId() {
        return this.zzo.getGmpAppId();
    }

    public long generateEventId() {
        return this.zzo.generateEventId();
    }

    public void beginAdUnitExposure(String str) {
        this.zzo.beginAdUnitExposure(str);
    }

    public void endAdUnitExposure(String str) {
        this.zzo.endAdUnitExposure(str);
    }

    public void setEventInterceptor(EventInterceptor eventInterceptor) {
        this.zzo.zza((zzgk) eventInterceptor);
    }

    public void registerOnMeasurementEventListener(OnEventListener onEventListener) {
        this.zzo.zza((zzgn) onEventListener);
    }

    public void unregisterOnMeasurementEventListener(OnEventListener onEventListener) {
        this.zzo.zzb((zzgn) onEventListener);
    }

    public Bundle performActionWithResponse(Bundle bundle) {
        return this.zzo.zza(bundle, true);
    }

    public void performAction(Bundle bundle) {
        this.zzo.zza(bundle, false);
    }

    public int getMaxUserProperties(String str) {
        return this.zzo.getMaxUserProperties(str);
    }

    public void setCurrentScreen(Activity activity, String str, String str2) {
        this.zzo.setCurrentScreen(activity, str, str2);
    }

    public String getAppIdOrigin() {
        return this.zzo.getAppIdOrigin();
    }
}
