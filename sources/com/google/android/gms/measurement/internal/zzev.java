package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Preconditions;

public final class zzev {
    private String value;
    private final String zzjj;
    private boolean zzmi;
    private final /* synthetic */ zzeo zzmj;
    private final String zzmp = null;

    public zzev(zzeo zzeo, String str, String str2) {
        this.zzmj = zzeo;
        Preconditions.checkNotEmpty(str);
        this.zzjj = str;
    }

    public final String zzho() {
        if (!this.zzmi) {
            this.zzmi = true;
            this.value = this.zzmj.zzhb().getString(this.zzjj, (String) null);
        }
        return this.value;
    }

    public final void zzau(String str) {
        if (!zzjs.zzs(str, this.value)) {
            SharedPreferences.Editor edit = this.zzmj.zzhb().edit();
            edit.putString(this.zzjj, str);
            edit.apply();
            this.value = str;
        }
    }
}
