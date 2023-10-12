package com.nimbusds.jose;

public class KeyLengthException extends KeyException {
    private final Algorithm alg;
    private final int expectedLength;

    public KeyLengthException(String str) {
        super(str);
        this.expectedLength = 0;
        this.alg = null;
    }

    public KeyLengthException(Algorithm algorithm) {
        this(0, algorithm);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public KeyLengthException(int r4, com.nimbusds.jose.Algorithm r5) {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            if (r4 <= 0) goto L_0x001e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "The expected key length is "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r2 = " bits"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            goto L_0x0020
        L_0x001e:
            java.lang.String r1 = "Unexpected key length"
        L_0x0020:
            r0.append(r1)
            if (r5 == 0) goto L_0x003c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = " (for "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r2 = " algorithm)"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            goto L_0x003e
        L_0x003c:
            java.lang.String r1 = ""
        L_0x003e:
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r3.<init>(r0)
            r3.expectedLength = r4
            r3.alg = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nimbusds.jose.KeyLengthException.<init>(int, com.nimbusds.jose.Algorithm):void");
    }

    public int getExpectedKeyLength() {
        return this.expectedLength;
    }

    public Algorithm getAlgorithm() {
        return this.alg;
    }
}
