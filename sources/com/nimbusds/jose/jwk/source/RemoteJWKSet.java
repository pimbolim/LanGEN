package com.nimbusds.jose.jwk.source;

import com.nimbusds.jose.KeySourceException;
import com.nimbusds.jose.RemoteKeySourceException;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKMatcher;
import com.nimbusds.jose.jwk.JWKSelector;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.proc.SecurityContext;
import com.nimbusds.jose.util.DefaultResourceRetriever;
import com.nimbusds.jose.util.ResourceRetriever;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.List;
import java.util.Set;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class RemoteJWKSet<C extends SecurityContext> implements JWKSource<C> {
    public static final int DEFAULT_HTTP_CONNECT_TIMEOUT = 500;
    public static final int DEFAULT_HTTP_READ_TIMEOUT = 500;
    public static final int DEFAULT_HTTP_SIZE_LIMIT = 51200;
    private final JWKSource<C> failoverJWKSource;
    private final JWKSetCache jwkSetCache;
    private final ResourceRetriever jwkSetRetriever;
    private final URL jwkSetURL;

    public static int resolveDefaultHTTPConnectTimeout() {
        return resolveDefault(RemoteJWKSet.class.getName() + ".defaultHttpConnectTimeout", 500);
    }

    public static int resolveDefaultHTTPReadTimeout() {
        return resolveDefault(RemoteJWKSet.class.getName() + ".defaultHttpReadTimeout", 500);
    }

    public static int resolveDefaultHTTPSizeLimit() {
        return resolveDefault(RemoteJWKSet.class.getName() + ".defaultHttpSizeLimit", DEFAULT_HTTP_SIZE_LIMIT);
    }

    private static int resolveDefault(String str, int i) {
        String property = System.getProperty(str);
        if (property == null) {
            return i;
        }
        try {
            return Integer.parseInt(property);
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public RemoteJWKSet(URL url) {
        this(url, (JWKSource) null);
    }

    public RemoteJWKSet(URL url, JWKSource<C> jWKSource) {
        this(url, jWKSource, (ResourceRetriever) null, (JWKSetCache) null);
    }

    public RemoteJWKSet(URL url, ResourceRetriever resourceRetriever) {
        this(url, resourceRetriever, (JWKSetCache) null);
    }

    public RemoteJWKSet(URL url, ResourceRetriever resourceRetriever, JWKSetCache jWKSetCache) {
        this(url, (JWKSource) null, resourceRetriever, jWKSetCache);
    }

    public RemoteJWKSet(URL url, JWKSource<C> jWKSource, ResourceRetriever resourceRetriever, JWKSetCache jWKSetCache) {
        if (url != null) {
            this.jwkSetURL = url;
            this.failoverJWKSource = jWKSource;
            if (resourceRetriever != null) {
                this.jwkSetRetriever = resourceRetriever;
            } else {
                this.jwkSetRetriever = new DefaultResourceRetriever(resolveDefaultHTTPConnectTimeout(), resolveDefaultHTTPReadTimeout(), resolveDefaultHTTPSizeLimit());
            }
            if (jWKSetCache != null) {
                this.jwkSetCache = jWKSetCache;
            } else {
                this.jwkSetCache = new DefaultJWKSetCache();
            }
        } else {
            throw new IllegalArgumentException("The JWK set URL must not be null");
        }
    }

    private JWKSet updateJWKSetFromURL() throws RemoteKeySourceException {
        try {
            try {
                JWKSet parse = JWKSet.parse(this.jwkSetRetriever.retrieveResource(this.jwkSetURL).getContent());
                this.jwkSetCache.put(parse);
                return parse;
            } catch (ParseException e) {
                throw new RemoteKeySourceException("Couldn't parse remote JWK set: " + e.getMessage(), e);
            }
        } catch (IOException e2) {
            throw new RemoteKeySourceException("Couldn't retrieve remote JWK set: " + e2.getMessage(), e2);
        }
    }

    public URL getJWKSetURL() {
        return this.jwkSetURL;
    }

    public JWKSource<C> getFailoverJWKSource() {
        return this.failoverJWKSource;
    }

    public ResourceRetriever getResourceRetriever() {
        return this.jwkSetRetriever;
    }

    public JWKSetCache getJWKSetCache() {
        return this.jwkSetCache;
    }

    public JWKSet getCachedJWKSet() {
        return this.jwkSetCache.get();
    }

    protected static String getFirstSpecifiedKeyID(JWKMatcher jWKMatcher) {
        Set<String> keyIDs = jWKMatcher.getKeyIDs();
        if (keyIDs != null && !keyIDs.isEmpty()) {
            for (String next : keyIDs) {
                if (next != null) {
                    return next;
                }
            }
        }
        return null;
    }

    private List<JWK> failover(Exception exc, JWKSelector jWKSelector, C c) throws RemoteKeySourceException {
        if (getFailoverJWKSource() == null) {
            return null;
        }
        try {
            return getFailoverJWKSource().get(jWKSelector, c);
        } catch (KeySourceException e) {
            throw new RemoteKeySourceException(exc.getMessage() + "; Failover JWK source retrieval failed with: " + e.getMessage(), e);
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public java.util.List<com.nimbusds.jose.jwk.JWK> get(com.nimbusds.jose.jwk.JWKSelector r4, C r5) throws com.nimbusds.jose.RemoteKeySourceException {
        /*
            r3 = this;
            com.nimbusds.jose.jwk.source.JWKSetCache r0 = r3.jwkSetCache
            com.nimbusds.jose.jwk.JWKSet r0 = r0.get()
            com.nimbusds.jose.jwk.source.JWKSetCache r1 = r3.jwkSetCache
            boolean r1 = r1.requiresRefresh()
            if (r1 != 0) goto L_0x0010
            if (r0 != 0) goto L_0x0034
        L_0x0010:
            monitor-enter(r3)     // Catch:{ Exception -> 0x002a }
            com.nimbusds.jose.jwk.source.JWKSetCache r1 = r3.jwkSetCache     // Catch:{ all -> 0x0027 }
            com.nimbusds.jose.jwk.JWKSet r0 = r1.get()     // Catch:{ all -> 0x0027 }
            com.nimbusds.jose.jwk.source.JWKSetCache r1 = r3.jwkSetCache     // Catch:{ all -> 0x0027 }
            boolean r1 = r1.requiresRefresh()     // Catch:{ all -> 0x0027 }
            if (r1 != 0) goto L_0x0021
            if (r0 != 0) goto L_0x0025
        L_0x0021:
            com.nimbusds.jose.jwk.JWKSet r0 = r3.updateJWKSetFromURL()     // Catch:{ all -> 0x0027 }
        L_0x0025:
            monitor-exit(r3)     // Catch:{ all -> 0x0027 }
            goto L_0x0034
        L_0x0027:
            r1 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0027 }
            throw r1     // Catch:{ Exception -> 0x002a }
        L_0x002a:
            r1 = move-exception
            java.util.List r2 = r3.failover(r1, r4, r5)
            if (r2 == 0) goto L_0x0032
            return r2
        L_0x0032:
            if (r0 == 0) goto L_0x0086
        L_0x0034:
            java.util.List r1 = r4.select(r0)
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto L_0x003f
            return r1
        L_0x003f:
            com.nimbusds.jose.jwk.JWKMatcher r1 = r4.getMatcher()
            java.lang.String r1 = getFirstSpecifiedKeyID(r1)
            if (r1 != 0) goto L_0x004e
            java.util.List r4 = java.util.Collections.emptyList()
            return r4
        L_0x004e:
            com.nimbusds.jose.jwk.JWK r1 = r0.getKeyByKeyId(r1)
            if (r1 == 0) goto L_0x0059
            java.util.List r4 = java.util.Collections.emptyList()
            return r4
        L_0x0059:
            monitor-enter(r3)     // Catch:{ KeySourceException -> 0x007d }
            com.nimbusds.jose.jwk.source.JWKSetCache r1 = r3.jwkSetCache     // Catch:{ all -> 0x007a }
            com.nimbusds.jose.jwk.JWKSet r1 = r1.get()     // Catch:{ all -> 0x007a }
            if (r0 != r1) goto L_0x0067
            com.nimbusds.jose.jwk.JWKSet r0 = r3.updateJWKSetFromURL()     // Catch:{ all -> 0x007a }
            goto L_0x006d
        L_0x0067:
            com.nimbusds.jose.jwk.source.JWKSetCache r0 = r3.jwkSetCache     // Catch:{ all -> 0x007a }
            com.nimbusds.jose.jwk.JWKSet r0 = r0.get()     // Catch:{ all -> 0x007a }
        L_0x006d:
            monitor-exit(r3)     // Catch:{ all -> 0x007a }
            if (r0 != 0) goto L_0x0075
            java.util.List r4 = java.util.Collections.emptyList()
            return r4
        L_0x0075:
            java.util.List r4 = r4.select(r0)
            return r4
        L_0x007a:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x007a }
            throw r0     // Catch:{ KeySourceException -> 0x007d }
        L_0x007d:
            r0 = move-exception
            java.util.List r4 = r3.failover(r0, r4, r5)
            if (r4 == 0) goto L_0x0085
            return r4
        L_0x0085:
            throw r0
        L_0x0086:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nimbusds.jose.jwk.source.RemoteJWKSet.get(com.nimbusds.jose.jwk.JWKSelector, com.nimbusds.jose.proc.SecurityContext):java.util.List");
    }
}
