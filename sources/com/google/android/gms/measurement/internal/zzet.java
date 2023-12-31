package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Preconditions;

public final class zzet {
    private long value;
    private final String zzjj;
    private boolean zzmi;
    private final /* synthetic */ zzeo zzmj;
    private final long zzmo;

    public zzet(zzeo zzeo, String str, long j) {
        this.zzmj = zzeo;
        Preconditions.checkNotEmpty(str);
        this.zzjj = str;
        this.zzmo = j;
    }

    public final long get() {
        if (!this.zzmi) {
            this.zzmi = true;
            this.value = this.zzmj.zzhb().getLong(this.zzjj, this.zzmo);
        }
        return this.value;
    }

    public final void set(long j) {
        SharedPreferences.Editor edit = this.zzmj.zzhb().edit();
        edit.putLong(this.zzjj, j);
        edit.apply();
        this.value = j;
    }
}
