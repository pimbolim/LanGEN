package com.nimbusds.jose.jwk;

public interface PasswordLookup {
    char[] lookupPassword(String str);
}
