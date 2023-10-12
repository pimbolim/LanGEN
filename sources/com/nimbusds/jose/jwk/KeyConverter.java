package com.nimbusds.jose.jwk;

import com.nimbusds.jose.JOSEException;
import java.security.Key;
import java.security.KeyPair;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class KeyConverter {
    public static List<Key> toJavaKeys(List<JWK> list) {
        if (list == null) {
            return Collections.emptyList();
        }
        LinkedList linkedList = new LinkedList();
        for (JWK next : list) {
            try {
                if (next instanceof AsymmetricJWK) {
                    KeyPair keyPair = ((AsymmetricJWK) next).toKeyPair();
                    linkedList.add(keyPair.getPublic());
                    if (keyPair.getPrivate() != null) {
                        linkedList.add(keyPair.getPrivate());
                    }
                } else if (next instanceof SecretJWK) {
                    linkedList.add(((SecretJWK) next).toSecretKey());
                }
            } catch (JOSEException unused) {
            }
        }
        return linkedList;
    }
}
