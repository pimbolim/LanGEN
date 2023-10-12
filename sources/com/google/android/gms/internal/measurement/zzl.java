package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.util.Log;
import com.nimbusds.jose.jwk.JWKParameterNames;
import java.util.concurrent.atomic.AtomicReference;

public final class zzl extends zzo {
    private final AtomicReference<Bundle> zzp = new AtomicReference<>();
    private boolean zzq;

    public final void zzb(Bundle bundle) {
        synchronized (this.zzp) {
            try {
                this.zzp.set(bundle);
                this.zzq = true;
                this.zzp.notify();
            } catch (Throwable th) {
                this.zzp.notify();
                throw th;
            }
        }
    }

    public final String zza(long j) {
        return (String) zza(zzb(j), String.class);
    }

    public final Bundle zzb(long j) {
        Bundle bundle;
        synchronized (this.zzp) {
            if (!this.zzq) {
                try {
                    this.zzp.wait(j);
                } catch (InterruptedException unused) {
                    return null;
                }
            }
            bundle = this.zzp.get();
        }
        return bundle;
    }

    public static <T> T zza(Bundle bundle, Class<T> cls) {
        Object obj;
        if (bundle == null || (obj = bundle.get(JWKParameterNames.RSA_OTHER_PRIMES__PRIME_FACTOR)) == null) {
            return null;
        }
        try {
            return cls.cast(obj);
        } catch (ClassCastException e) {
            String canonicalName = cls.getCanonicalName();
            String canonicalName2 = obj.getClass().getCanonicalName();
            Log.w("AM", String.format("Unexpected object type. Expected, Received".concat(": %s, %s"), new Object[]{canonicalName, canonicalName2}), e);
            throw e;
        }
    }
}
