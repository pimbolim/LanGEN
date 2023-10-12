package com.google.firebase.analytics.connector;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.analytics.connector.internal.zza;
import com.google.firebase.analytics.connector.internal.zzc;
import com.google.firebase.analytics.connector.internal.zzd;
import com.google.firebase.analytics.connector.internal.zze;
import com.google.firebase.events.Event;
import com.google.firebase.events.Subscriber;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class AnalyticsConnectorImpl implements AnalyticsConnector {
    private static volatile AnalyticsConnector zzacb;
    private final AppMeasurement zzacc;
    final Map<String, zza> zzacd = new ConcurrentHashMap();

    private AnalyticsConnectorImpl(AppMeasurement appMeasurement) {
        Preconditions.checkNotNull(appMeasurement);
        this.zzacc = appMeasurement;
    }

    public static AnalyticsConnector getInstance(FirebaseApp firebaseApp, Context context, Subscriber subscriber) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(subscriber);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzacb == null) {
            synchronized (AnalyticsConnectorImpl.class) {
                if (zzacb == null) {
                    Bundle bundle = new Bundle(1);
                    if (firebaseApp.isDefaultApp()) {
                        subscriber.subscribe(DataCollectionDefaultChange.class, zzb.zzacf, zza.zzace);
                        bundle.putBoolean("dataCollectionDefaultEnabled", firebaseApp.isDataCollectionDefaultEnabled());
                    }
                    zzacb = new AnalyticsConnectorImpl(AppMeasurement.zza(context, bundle));
                }
            }
        }
        return zzacb;
    }

    public static AnalyticsConnector getInstance() {
        return getInstance(FirebaseApp.getInstance());
    }

    public static AnalyticsConnector getInstance(FirebaseApp firebaseApp) {
        return (AnalyticsConnector) firebaseApp.get(AnalyticsConnector.class);
    }

    public void logEvent(String str, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (zzd.zzdj(str) && zzd.zza(str2, bundle) && zzd.zzb(str, str2, bundle)) {
            this.zzacc.logEventInternal(str, str2, bundle);
        }
    }

    public void setUserProperty(String str, String str2, Object obj) {
        if (zzd.zzdj(str) && zzd.zzu(str, str2)) {
            this.zzacc.setUserPropertyInternal(str, str2, obj);
        }
    }

    public Map<String, Object> getUserProperties(boolean z) {
        return this.zzacc.getUserProperties(z);
    }

    public AnalyticsConnector.AnalyticsConnectorHandle registerAnalyticsConnectorListener(final String str, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        Object obj;
        Preconditions.checkNotNull(analyticsConnectorListener);
        if (!zzd.zzdj(str) || zzdi(str)) {
            return null;
        }
        AppMeasurement appMeasurement = this.zzacc;
        if ("fiam".equals(str)) {
            obj = new zzc(appMeasurement, analyticsConnectorListener);
        } else {
            obj = "crash".equals(str) ? new zze(appMeasurement, analyticsConnectorListener) : null;
        }
        if (obj == null) {
            return null;
        }
        this.zzacd.put(str, obj);
        return new AnalyticsConnector.AnalyticsConnectorHandle() {
            public void unregister() {
                if (AnalyticsConnectorImpl.this.zzdi(str)) {
                    AnalyticsConnector.AnalyticsConnectorListener zzrr = AnalyticsConnectorImpl.this.zzacd.get(str).zzrr();
                    if (zzrr != null) {
                        zzrr.onMessageTriggered(0, (Bundle) null);
                    }
                    AnalyticsConnectorImpl.this.zzacd.remove(str);
                }
            }

            public void registerEventNames(Set<String> set) {
                if (AnalyticsConnectorImpl.this.zzdi(str) && str.equals("fiam") && set != null && !set.isEmpty()) {
                    AnalyticsConnectorImpl.this.zzacd.get(str).registerEventNames(set);
                }
            }

            public void unregisterEventNames() {
                if (AnalyticsConnectorImpl.this.zzdi(str) && str.equals("fiam")) {
                    AnalyticsConnectorImpl.this.zzacd.get(str).unregisterEventNames();
                }
            }
        };
    }

    public void setConditionalUserProperty(AnalyticsConnector.ConditionalUserProperty conditionalUserProperty) {
        if (zzd.zza(conditionalUserProperty)) {
            this.zzacc.setConditionalUserProperty(zzd.zzb(conditionalUserProperty));
        }
    }

    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        if (str2 == null || zzd.zza(str2, bundle)) {
            this.zzacc.clearConditionalUserProperty(str, str2, bundle);
        }
    }

    public List<AnalyticsConnector.ConditionalUserProperty> getConditionalUserProperties(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        for (AppMeasurement.ConditionalUserProperty zzb : this.zzacc.getConditionalUserProperties(str, str2)) {
            arrayList.add(zzd.zzb(zzb));
        }
        return arrayList;
    }

    public int getMaxUserProperties(String str) {
        return this.zzacc.getMaxUserProperties(str);
    }

    /* access modifiers changed from: private */
    public final boolean zzdi(String str) {
        return !str.isEmpty() && this.zzacd.containsKey(str) && this.zzacd.get(str) != null;
    }

    static final /* synthetic */ void zza(Event event) {
        boolean z = ((DataCollectionDefaultChange) event.getPayload()).enabled;
        synchronized (AnalyticsConnectorImpl.class) {
            ((AnalyticsConnectorImpl) zzacb).zzacc.zza(z);
        }
    }
}
