package com.google.android.gms.measurement.internal;

import java.util.Iterator;

final class zzag implements Iterator<String> {
    private Iterator<String> zzfr;
    private final /* synthetic */ zzah zzfs;

    zzag(zzah zzah) {
        this.zzfs = zzah;
        this.zzfr = zzah.zzft.keySet().iterator();
    }

    public final boolean hasNext() {
        return this.zzfr.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }

    public final /* synthetic */ Object next() {
        return this.zzfr.next();
    }
}
