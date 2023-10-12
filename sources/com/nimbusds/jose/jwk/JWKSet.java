package com.nimbusds.jose.jwk;

import com.drew.metadata.mov.QuickTimeAtomTypes;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.util.Base64URL;
import com.nimbusds.jose.util.DefaultResourceRetriever;
import com.nimbusds.jose.util.IOUtils;
import com.nimbusds.jose.util.JSONArrayUtils;
import com.nimbusds.jose.util.JSONObjectUtils;
import com.nimbusds.jose.util.StandardCharset;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.Proxy;
import java.net.URL;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.Certificate;
import java.security.interfaces.ECPublicKey;
import java.security.interfaces.RSAPublicKey;
import java.text.ParseException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import net.jcip.annotations.Immutable;

@Immutable
public class JWKSet implements Serializable {
    public static final String MIME_TYPE = "application/jwk-set+json; charset=UTF-8";
    private static final long serialVersionUID = 1;
    private final Map<String, Object> customMembers;
    private final List<JWK> keys;

    public JWKSet() {
        this((List<JWK>) Collections.emptyList());
    }

    public JWKSet(JWK jwk) {
        this((List<JWK>) Collections.singletonList(jwk));
        if (jwk == null) {
            throw new IllegalArgumentException("The JWK must not be null");
        }
    }

    public JWKSet(List<JWK> list) {
        this(list, Collections.emptyMap());
    }

    public JWKSet(List<JWK> list, Map<String, Object> map) {
        if (list != null) {
            this.keys = Collections.unmodifiableList(list);
            this.customMembers = Collections.unmodifiableMap(map);
            return;
        }
        throw new IllegalArgumentException("The JWK list must not be null");
    }

    public List<JWK> getKeys() {
        return this.keys;
    }

    public JWK getKeyByKeyId(String str) {
        for (JWK next : getKeys()) {
            if (next.getKeyID() != null && next.getKeyID().equals(str)) {
                return next;
            }
        }
        return null;
    }

    public boolean containsJWK(JWK jwk) throws JOSEException {
        Base64URL computeThumbprint = jwk.computeThumbprint();
        for (JWK computeThumbprint2 : getKeys()) {
            if (computeThumbprint.equals(computeThumbprint2.computeThumbprint())) {
                return true;
            }
        }
        return false;
    }

    public Map<String, Object> getAdditionalMembers() {
        return this.customMembers;
    }

    public JWKSet toPublicJWKSet() {
        LinkedList linkedList = new LinkedList();
        for (JWK publicJWK : this.keys) {
            JWK publicJWK2 = publicJWK.toPublicJWK();
            if (publicJWK2 != null) {
                linkedList.add(publicJWK2);
            }
        }
        return new JWKSet(linkedList, this.customMembers);
    }

    public Map<String, Object> toJSONObject() {
        return toJSONObject(true);
    }

    public Map<String, Object> toJSONObject(boolean z) {
        Map<String, Object> newJSONObject = JSONObjectUtils.newJSONObject();
        newJSONObject.putAll(this.customMembers);
        List<Object> newJSONArray = JSONArrayUtils.newJSONArray();
        for (JWK next : this.keys) {
            if (z) {
                JWK publicJWK = next.toPublicJWK();
                if (publicJWK != null) {
                    newJSONArray.add(publicJWK.toJSONObject());
                }
            } else {
                newJSONArray.add(next.toJSONObject());
            }
        }
        newJSONObject.put(QuickTimeAtomTypes.ATOM_KEYS, newJSONArray);
        return newJSONObject;
    }

    public String toString(boolean z) {
        return JSONObjectUtils.toJSONString(toJSONObject(z));
    }

    public String toString() {
        return toString(true);
    }

    public static JWKSet parse(String str) throws ParseException {
        return parse(JSONObjectUtils.parse(str));
    }

    public static JWKSet parse(Map<String, Object> map) throws ParseException {
        List<Object> jSONArray = JSONObjectUtils.getJSONArray(map, QuickTimeAtomTypes.ATOM_KEYS);
        if (jSONArray != null) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < jSONArray.size(); i++) {
                try {
                    linkedList.add(JWK.parse((Map<String, Object>) (Map) jSONArray.get(i)));
                } catch (ClassCastException unused) {
                    throw new ParseException("The \"keys\" JSON array must contain JSON objects only", 0);
                } catch (ParseException e) {
                    if (e.getMessage() == null || !e.getMessage().startsWith("Unsupported key type")) {
                        throw new ParseException("Invalid JWK at position " + i + ": " + e.getMessage(), 0);
                    }
                }
            }
            HashMap hashMap = new HashMap();
            for (Map.Entry next : map.entrySet()) {
                if (next.getKey() != null && !((String) next.getKey()).equals(QuickTimeAtomTypes.ATOM_KEYS)) {
                    hashMap.put(next.getKey(), next.getValue());
                }
            }
            return new JWKSet(linkedList, hashMap);
        }
        throw new ParseException("Missing required \"keys\" member", 0);
    }

    public static JWKSet load(InputStream inputStream) throws IOException, ParseException {
        return parse(IOUtils.readInputStreamToString(inputStream, StandardCharset.UTF_8));
    }

    public static JWKSet load(File file) throws IOException, ParseException {
        return parse(IOUtils.readFileToString(file, StandardCharset.UTF_8));
    }

    public static JWKSet load(URL url, int i, int i2, int i3) throws IOException, ParseException {
        return load(url, i, i2, i3, (Proxy) null);
    }

    public static JWKSet load(URL url, int i, int i2, int i3, Proxy proxy) throws IOException, ParseException {
        DefaultResourceRetriever defaultResourceRetriever = new DefaultResourceRetriever(i, i2, i3);
        defaultResourceRetriever.setProxy(proxy);
        return parse(defaultResourceRetriever.retrieveResource(url).getContent());
    }

    public static JWKSet load(URL url) throws IOException, ParseException {
        return load(url, 0, 0, 0);
    }

    public static JWKSet load(KeyStore keyStore, PasswordLookup passwordLookup) throws KeyStoreException {
        LinkedList linkedList = new LinkedList();
        Enumeration<String> aliases = keyStore.aliases();
        while (aliases.hasMoreElements()) {
            String nextElement = aliases.nextElement();
            char[] charArray = passwordLookup == null ? "".toCharArray() : passwordLookup.lookupPassword(nextElement);
            Certificate certificate = keyStore.getCertificate(nextElement);
            if (certificate != null) {
                if (certificate.getPublicKey() instanceof RSAPublicKey) {
                    try {
                        RSAKey load = RSAKey.load(keyStore, nextElement, charArray);
                        if (load != null) {
                            linkedList.add(load);
                        }
                    } catch (JOSEException unused) {
                    }
                } else if (certificate.getPublicKey() instanceof ECPublicKey) {
                    ECKey load2 = ECKey.load(keyStore, nextElement, charArray);
                    if (load2 != null) {
                        linkedList.add(load2);
                    }
                }
            }
        }
        Enumeration<String> aliases2 = keyStore.aliases();
        while (aliases2.hasMoreElements()) {
            String nextElement2 = aliases2.nextElement();
            try {
                OctetSequenceKey load3 = OctetSequenceKey.load(keyStore, nextElement2, passwordLookup == null ? "".toCharArray() : passwordLookup.lookupPassword(nextElement2));
                if (load3 != null) {
                    linkedList.add(load3);
                }
            } catch (JOSEException unused2) {
            }
        }
        return new JWKSet((List<JWK>) linkedList);
    }
}
