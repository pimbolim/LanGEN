package com.google.android.gms.internal.firebase_messaging;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Objects;

final class zzo extends WeakReference<Throwable> {
    private final int zzm;

    public zzo(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        Objects.requireNonNull(th, "The referent cannot be null");
        this.zzm = System.identityHashCode(th);
    }

    public final int hashCode() {
        return this.zzm;
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            if (this == obj) {
                return true;
            }
            zzo zzo = (zzo) obj;
            return this.zzm == zzo.zzm && get() == zzo.get();
        }
    }
}
