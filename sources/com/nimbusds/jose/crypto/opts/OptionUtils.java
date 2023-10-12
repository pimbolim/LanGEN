package com.nimbusds.jose.crypto.opts;

import com.nimbusds.jose.JWSSignerOption;
import java.util.Set;

public class OptionUtils {
    public static <T extends JWSSignerOption> boolean optionIsPresent(Set<JWSSignerOption> set, Class<T> cls) {
        if (set != null && !set.isEmpty()) {
            for (JWSSignerOption jWSSignerOption : set) {
                if (jWSSignerOption.getClass().isAssignableFrom(cls)) {
                    return true;
                }
            }
        }
        return false;
    }
}
