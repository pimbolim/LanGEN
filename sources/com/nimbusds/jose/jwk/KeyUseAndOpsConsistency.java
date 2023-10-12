package com.nimbusds.jose.jwk;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class KeyUseAndOpsConsistency {
    static final Map<KeyUse, Set<KeyOperation>> MAP;

    KeyUseAndOpsConsistency() {
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(KeyUse.SIGNATURE, new HashSet(Arrays.asList(new KeyOperation[]{KeyOperation.SIGN, KeyOperation.VERIFY})));
        hashMap.put(KeyUse.ENCRYPTION, new HashSet(Arrays.asList(new KeyOperation[]{KeyOperation.ENCRYPT, KeyOperation.DECRYPT, KeyOperation.WRAP_KEY, KeyOperation.UNWRAP_KEY})));
        MAP = Collections.unmodifiableMap(hashMap);
    }

    static boolean areConsistent(KeyUse keyUse, Set<KeyOperation> set) {
        if (keyUse == null || set == null) {
            return true;
        }
        Map<KeyUse, Set<KeyOperation>> map = MAP;
        return !map.containsKey(keyUse) || map.get(keyUse).containsAll(set);
    }
}
