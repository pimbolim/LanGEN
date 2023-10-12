package net.time4j.calendar.bahai;

import com.nimbusds.jose.jwk.JWKParameterNames;

public enum FormattedContent {
    TRANSCRIPTION {
        /* access modifiers changed from: package-private */
        public String variant() {
            return JWKParameterNames.RSA_OTHER_PRIMES__FACTOR_CRT_COEFFICIENT;
        }
    },
    MEANING {
        /* access modifiers changed from: package-private */
        public String variant() {
            return "m";
        }
    },
    HTML {
        /* access modifiers changed from: package-private */
        public String variant() {
            return "h";
        }
    };

    /* access modifiers changed from: package-private */
    public abstract String variant();
}
