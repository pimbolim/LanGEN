package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class zzcs implements zzce {
    static final Map<String, zzcs> zzabd = new HashMap();
    private final Object zzaaj = new Object();
    private volatile Map<String, ?> zzaak;
    private final List<zzcf> zzaal = new ArrayList();
    private final SharedPreferences zzabe;
    private final SharedPreferences.OnSharedPreferenceChangeListener zzabf;

    static zzcs zze(Context context, String str) {
        zzcs zzcs;
        SharedPreferences sharedPreferences;
        if (!((!zzcb.zzri() || str.startsWith("direct_boot:")) ? true : zzcb.isUserUnlocked(context))) {
            return null;
        }
        synchronized (zzcs.class) {
            Map<String, zzcs> map = zzabd;
            zzcs = map.get(str);
            if (zzcs == null) {
                if (str.startsWith("direct_boot:")) {
                    if (zzcb.zzri()) {
                        context = context.createDeviceProtectedStorageContext();
                    }
                    sharedPreferences = context.getSharedPreferences(str.substring(12), 0);
                } else {
                    sharedPreferences = context.getSharedPreferences(str, 0);
                }
                zzcs = new zzcs(sharedPreferences);
                map.put(str, zzcs);
            }
        }
        return zzcs;
    }

    private zzcs(SharedPreferences sharedPreferences) {
        zzcv zzcv = new zzcv(this);
        this.zzabf = zzcv;
        this.zzabe = sharedPreferences;
        sharedPreferences.registerOnSharedPreferenceChangeListener(zzcv);
    }

    public final Object zzdd(String str) {
        Map<String, ?> map = this.zzaak;
        if (map == null) {
            synchronized (this.zzaaj) {
                map = this.zzaak;
                if (map == null) {
                    map = this.zzabe.getAll();
                    this.zzaak = map;
                }
            }
        }
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(SharedPreferences sharedPreferences, String str) {
        synchronized (this.zzaaj) {
            this.zzaak = null;
            zzcm.zzrl();
        }
        synchronized (this) {
            for (zzcf zzrk : this.zzaal) {
                zzrk.zzrk();
            }
        }
    }
}
