package com.nimbusds.jose.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class DefaultResourceRetriever extends AbstractRestrictedResourceRetriever implements RestrictedResourceRetriever {
    private boolean disconnectAfterUse;
    private Proxy proxy;
    private final SSLSocketFactory sslSocketFactory;

    public DefaultResourceRetriever() {
        this(0, 0);
    }

    public DefaultResourceRetriever(int i, int i2) {
        this(i, i2, 0);
    }

    public DefaultResourceRetriever(int i, int i2, int i3) {
        this(i, i2, i3, true);
    }

    public DefaultResourceRetriever(int i, int i2, int i3, boolean z) {
        this(i, i2, i3, z, (SSLSocketFactory) null);
    }

    public DefaultResourceRetriever(int i, int i2, int i3, boolean z, SSLSocketFactory sSLSocketFactory) {
        super(i, i2, i3);
        this.disconnectAfterUse = z;
        this.sslSocketFactory = sSLSocketFactory;
    }

    public boolean disconnectsAfterUse() {
        return this.disconnectAfterUse;
    }

    public void setDisconnectsAfterUse(boolean z) {
        this.disconnectAfterUse = z;
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void setProxy(Proxy proxy2) {
        this.proxy = proxy2;
    }

    public Resource retrieveResource(URL url) throws IOException {
        InputStream inputStream;
        HttpURLConnection httpURLConnection = null;
        try {
            httpURLConnection = openConnection(url);
            httpURLConnection.setConnectTimeout(getConnectTimeout());
            httpURLConnection.setReadTimeout(getReadTimeout());
            SSLSocketFactory sSLSocketFactory = this.sslSocketFactory;
            if (sSLSocketFactory != null && (httpURLConnection instanceof HttpsURLConnection)) {
                ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLSocketFactory);
            }
            if (getHeaders() != null && !getHeaders().isEmpty()) {
                for (Map.Entry next : getHeaders().entrySet()) {
                    for (String addRequestProperty : (List) next.getValue()) {
                        httpURLConnection.addRequestProperty((String) next.getKey(), addRequestProperty);
                    }
                }
            }
            inputStream = getInputStream(httpURLConnection, getSizeLimit());
            String readInputStreamToString = IOUtils.readInputStreamToString(inputStream, StandardCharset.UTF_8);
            if (inputStream != null) {
                inputStream.close();
            }
            int responseCode = httpURLConnection.getResponseCode();
            String responseMessage = httpURLConnection.getResponseMessage();
            if (responseCode > 299 || responseCode < 200) {
                throw new IOException("HTTP " + responseCode + ": " + responseMessage);
            }
            Resource resource = new Resource(readInputStreamToString, httpURLConnection.getContentType());
            if (this.disconnectAfterUse && httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return resource;
        } catch (ClassCastException e) {
            try {
                throw new IOException("Couldn't open HTTP(S) connection: " + e.getMessage(), e);
            } catch (Throwable th) {
                if (this.disconnectAfterUse && httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    /* access modifiers changed from: protected */
    public HttpURLConnection openConnection(URL url) throws IOException {
        Proxy proxy2 = this.proxy;
        if (proxy2 != null) {
            return (HttpURLConnection) url.openConnection(proxy2);
        }
        return (HttpURLConnection) url.openConnection();
    }

    private InputStream getInputStream(HttpURLConnection httpURLConnection, int i) throws IOException {
        InputStream inputStream = httpURLConnection.getInputStream();
        return i > 0 ? new BoundedInputStream(inputStream, (long) getSizeLimit()) : inputStream;
    }
}
