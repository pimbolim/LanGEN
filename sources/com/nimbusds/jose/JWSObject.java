package com.nimbusds.jose;

import com.nimbusds.jose.util.Base64URL;
import com.nimbusds.jose.util.StandardCharset;
import java.text.ParseException;
import java.util.concurrent.atomic.AtomicReference;
import net.jcip.annotations.ThreadSafe;
import org.apache.commons.lang3.ClassUtils;

@ThreadSafe
public class JWSObject extends JOSEObject {
    private static final long serialVersionUID = 1;
    private final JWSHeader header;
    /* access modifiers changed from: private */
    public Base64URL signature;
    private final String signingInputString;
    /* access modifiers changed from: private */
    public final AtomicReference<State> state;

    public enum State {
        UNSIGNED,
        SIGNED,
        VERIFIED
    }

    public JWSObject(JWSHeader jWSHeader, Payload payload) {
        AtomicReference<State> atomicReference = new AtomicReference<>();
        this.state = atomicReference;
        if (jWSHeader != null) {
            this.header = jWSHeader;
            if (payload != null) {
                setPayload(payload);
                this.signingInputString = composeSigningInput();
                this.signature = null;
                atomicReference.set(State.UNSIGNED);
                return;
            }
            throw new IllegalArgumentException("The payload must not be null");
        }
        throw new IllegalArgumentException("The JWS header must not be null");
    }

    public JWSObject(Base64URL base64URL, Base64URL base64URL2, Base64URL base64URL3) throws ParseException {
        this(base64URL, new Payload(base64URL2), base64URL3);
    }

    public JWSObject(Base64URL base64URL, Payload payload, Base64URL base64URL2) throws ParseException {
        AtomicReference<State> atomicReference = new AtomicReference<>();
        this.state = atomicReference;
        if (base64URL != null) {
            try {
                this.header = JWSHeader.parse(base64URL);
                if (payload != null) {
                    setPayload(payload);
                    this.signingInputString = composeSigningInput();
                    if (base64URL2 != null) {
                        this.signature = base64URL2;
                        atomicReference.set(State.SIGNED);
                        if (getHeader().isBase64URLEncodePayload()) {
                            setParsedParts(base64URL, payload.toBase64URL(), base64URL2);
                            return;
                        }
                        setParsedParts(base64URL, new Base64URL(""), base64URL2);
                        return;
                    }
                    throw new IllegalArgumentException("The third part must not be null");
                }
                throw new IllegalArgumentException("The payload (second part) must not be null");
            } catch (ParseException e) {
                throw new ParseException("Invalid JWS header: " + e.getMessage(), 0);
            }
        } else {
            throw new IllegalArgumentException("The first part must not be null");
        }
    }

    public JWSHeader getHeader() {
        return this.header;
    }

    private String composeSigningInput() {
        if (this.header.isBase64URLEncodePayload()) {
            return getHeader().toBase64URL().toString() + ClassUtils.PACKAGE_SEPARATOR_CHAR + getPayload().toBase64URL().toString();
        }
        return getHeader().toBase64URL().toString() + ClassUtils.PACKAGE_SEPARATOR_CHAR + getPayload().toString();
    }

    public byte[] getSigningInput() {
        return this.signingInputString.getBytes(StandardCharset.UTF_8);
    }

    public Base64URL getSignature() {
        return this.signature;
    }

    public State getState() {
        return this.state.get();
    }

    private void ensureUnsignedState() {
        if (this.state.get() != State.UNSIGNED) {
            throw new IllegalStateException("The JWS object must be in an unsigned state");
        }
    }

    private void ensureSignedOrVerifiedState() {
        if (this.state.get() != State.SIGNED && this.state.get() != State.VERIFIED) {
            throw new IllegalStateException("The JWS object must be in a signed or verified state");
        }
    }

    private void ensureJWSSignerSupport(JWSSigner jWSSigner) throws JOSEException {
        if (!jWSSigner.supportedJWSAlgorithms().contains(getHeader().getAlgorithm())) {
            throw new JOSEException("The " + getHeader().getAlgorithm() + " algorithm is not allowed or supported by the JWS signer: Supported algorithms: " + jWSSigner.supportedJWSAlgorithms());
        }
    }

    public synchronized void sign(JWSSigner jWSSigner) throws JOSEException {
        ensureUnsignedState();
        ensureJWSSignerSupport(jWSSigner);
        try {
            this.signature = jWSSigner.sign(getHeader(), getSigningInput());
            this.state.set(State.SIGNED);
        } catch (ActionRequiredForJWSCompletionException e) {
            throw new ActionRequiredForJWSCompletionException(e.getMessage(), e.getTriggeringOption(), new CompletableJWSObjectSigning() {
                public Base64URL complete() throws JOSEException {
                    Base64URL unused = JWSObject.this.signature = e.getCompletableJWSObjectSigning().complete();
                    JWSObject.this.state.set(State.SIGNED);
                    return JWSObject.this.signature;
                }
            });
        } catch (JOSEException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new JOSEException(e3.getMessage(), e3);
        }
    }

    public synchronized boolean verify(JWSVerifier jWSVerifier) throws JOSEException {
        boolean verify;
        ensureSignedOrVerifiedState();
        try {
            verify = jWSVerifier.verify(getHeader(), getSigningInput(), getSignature());
            if (verify) {
                this.state.set(State.VERIFIED);
            }
        } catch (JOSEException e) {
            throw e;
        } catch (Exception e2) {
            throw new JOSEException(e2.getMessage(), e2);
        }
        return verify;
    }

    public String serialize() {
        return serialize(false);
    }

    public String serialize(boolean z) {
        ensureSignedOrVerifiedState();
        if (z) {
            return this.header.toBase64URL().toString() + ClassUtils.PACKAGE_SEPARATOR_CHAR + ClassUtils.PACKAGE_SEPARATOR_CHAR + this.signature.toString();
        }
        return this.signingInputString + ClassUtils.PACKAGE_SEPARATOR_CHAR + this.signature.toString();
    }

    public static JWSObject parse(String str) throws ParseException {
        Base64URL[] split = JOSEObject.split(str);
        if (split.length == 3) {
            return new JWSObject(split[0], split[1], split[2]);
        }
        throw new ParseException("Unexpected number of Base64URL parts, must be three", 0);
    }

    public static JWSObject parse(String str, Payload payload) throws ParseException {
        Base64URL[] split = JOSEObject.split(str);
        if (split.length != 3) {
            throw new ParseException("Unexpected number of Base64URL parts, must be three", 0);
        } else if (split[1].toString().isEmpty()) {
            return new JWSObject(split[0], payload, split[2]);
        } else {
            throw new ParseException("The payload Base64URL part must be empty", 0);
        }
    }
}
