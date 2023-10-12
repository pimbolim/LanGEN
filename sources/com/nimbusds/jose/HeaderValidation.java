package com.nimbusds.jose;

class HeaderValidation {
    HeaderValidation() {
    }

    static void ensureDisjoint(JWSHeader jWSHeader, UnprotectedHeader unprotectedHeader) throws IllegalHeaderException {
        if (jWSHeader != null && unprotectedHeader != null) {
            for (String contains : unprotectedHeader.getIncludedParams()) {
                if (jWSHeader.getIncludedParams().contains(contains)) {
                    throw new IllegalHeaderException("The parameters in the JWS protected header and the unprotected header must be disjoint");
                }
            }
        }
    }
}
