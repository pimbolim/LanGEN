package com.nimbusds.jose.util;

import java.util.List;
import java.util.Map;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public abstract class AbstractRestrictedResourceRetriever implements RestrictedResourceRetriever {
    private int connectTimeout;
    private Map<String, List<String>> headers;
    private int readTimeout;
    private int sizeLimit;

    public AbstractRestrictedResourceRetriever(int i, int i2, int i3) {
        setConnectTimeout(i);
        setReadTimeout(i2);
        setSizeLimit(i3);
    }

    public int getConnectTimeout() {
        return this.connectTimeout;
    }

    public void setConnectTimeout(int i) {
        if (i >= 0) {
            this.connectTimeout = i;
            return;
        }
        throw new IllegalArgumentException("The connect timeout must not be negative");
    }

    public int getReadTimeout() {
        return this.readTimeout;
    }

    public void setReadTimeout(int i) {
        if (i >= 0) {
            this.readTimeout = i;
            return;
        }
        throw new IllegalArgumentException("The read timeout must not be negative");
    }

    public int getSizeLimit() {
        return this.sizeLimit;
    }

    public void setSizeLimit(int i) {
        if (i >= 0) {
            this.sizeLimit = i;
            return;
        }
        throw new IllegalArgumentException("The size limit must not be negative");
    }

    public Map<String, List<String>> getHeaders() {
        return this.headers;
    }

    public void setHeaders(Map<String, List<String>> map) {
        this.headers = map;
    }
}
