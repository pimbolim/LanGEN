package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import java.security.MessageDigest;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

final class DataCacheKey implements Key {
    private final Key signature;
    private final Key sourceKey;

    DataCacheKey(Key key, Key key2) {
        this.sourceKey = key;
        this.signature = key2;
    }

    /* access modifiers changed from: package-private */
    public Key getSourceKey() {
        return this.sourceKey;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DataCacheKey)) {
            return false;
        }
        DataCacheKey dataCacheKey = (DataCacheKey) obj;
        if (!this.sourceKey.equals(dataCacheKey.sourceKey) || !this.signature.equals(dataCacheKey.signature)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.sourceKey.hashCode() * 31) + this.signature.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.sourceKey + ", signature=" + this.signature + AbstractJsonLexerKt.END_OBJ;
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        this.sourceKey.updateDiskCacheKey(messageDigest);
        this.signature.updateDiskCacheKey(messageDigest);
    }
}
