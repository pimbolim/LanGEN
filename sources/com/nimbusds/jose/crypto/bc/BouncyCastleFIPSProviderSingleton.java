package com.nimbusds.jose.crypto.bc;

import org.bouncycastle.jcajce.provider.BouncyCastleFipsProvider;

public final class BouncyCastleFIPSProviderSingleton {
    private static BouncyCastleFipsProvider bouncyCastleFIPSProvider;

    private BouncyCastleFIPSProviderSingleton() {
    }

    public static BouncyCastleFipsProvider getInstance() {
        if (bouncyCastleFIPSProvider == null) {
            bouncyCastleFIPSProvider = new BouncyCastleFipsProvider();
        }
        return bouncyCastleFIPSProvider;
    }
}
