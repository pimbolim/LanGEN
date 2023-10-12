package com.nimbusds.jose;

import com.nimbusds.jose.util.Base64URL;

public interface CompletableJWSObjectSigning {
    Base64URL complete() throws JOSEException;
}
