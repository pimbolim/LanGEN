package com.nimbusds.jose;

import com.nimbusds.jose.util.Base64URL;
import com.nimbusds.jose.util.JSONArrayUtils;
import com.nimbusds.jose.util.JSONObjectUtils;
import java.text.ParseException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import net.jcip.annotations.Immutable;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class JWSObjectJSON extends JOSEObjectJSON {
    private static final long serialVersionUID = 1;
    private final List<Signature> signatures;

    public enum State {
        UNSIGNED,
        SIGNED,
        VERIFIED
    }

    @Immutable
    public static final class Signature {
        private final JWSHeader header;
        private final Payload payload;
        private final Base64URL signature;
        private final UnprotectedHeader unprotectedHeader;
        private final AtomicBoolean verified;

        private Signature(Payload payload2, JWSHeader jWSHeader, UnprotectedHeader unprotectedHeader2, Base64URL base64URL) {
            this.verified = new AtomicBoolean(false);
            Objects.requireNonNull(payload2);
            this.payload = payload2;
            this.header = jWSHeader;
            this.unprotectedHeader = unprotectedHeader2;
            Objects.requireNonNull(base64URL);
            this.signature = base64URL;
        }

        public JWSHeader getHeader() {
            return this.header;
        }

        public UnprotectedHeader getUnprotectedHeader() {
            return this.unprotectedHeader;
        }

        public Base64URL getSignature() {
            return this.signature;
        }

        /* access modifiers changed from: private */
        public Map<String, Object> toJSONObject() {
            Map<String, Object> newJSONObject = JSONObjectUtils.newJSONObject();
            JWSHeader jWSHeader = this.header;
            if (jWSHeader != null) {
                newJSONObject.put("protected", jWSHeader.toBase64URL().toString());
            }
            UnprotectedHeader unprotectedHeader2 = this.unprotectedHeader;
            if (unprotectedHeader2 != null && !unprotectedHeader2.getIncludedParams().isEmpty()) {
                newJSONObject.put("header", this.unprotectedHeader.toJSONObject());
            }
            newJSONObject.put("signature", this.signature.toString());
            return newJSONObject;
        }

        public JWSObject toJWSObject() {
            try {
                return new JWSObject(this.header.toBase64URL(), this.payload.toBase64URL(), this.signature);
            } catch (ParseException unused) {
                throw new IllegalStateException();
            }
        }

        public boolean isVerified() {
            return this.verified.get();
        }

        public synchronized boolean verify(JWSVerifier jWSVerifier) throws JOSEException {
            try {
                this.verified.set(toJWSObject().verify(jWSVerifier));
            } catch (JOSEException e) {
                throw e;
            } catch (Exception e2) {
                throw new JOSEException(e2.getMessage(), e2);
            }
            return this.verified.get();
        }
    }

    public JWSObjectJSON(Payload payload) {
        super(payload);
        this.signatures = new LinkedList();
        Objects.requireNonNull(payload, "The payload must not be null");
    }

    private JWSObjectJSON(Payload payload, List<Signature> list) {
        super(payload);
        LinkedList linkedList = new LinkedList();
        this.signatures = linkedList;
        Objects.requireNonNull(payload, "The payload must not be null");
        if (!list.isEmpty()) {
            linkedList.addAll(list);
            return;
        }
        throw new IllegalArgumentException("At least one signature required");
    }

    public List<Signature> getSignatures() {
        return Collections.unmodifiableList(this.signatures);
    }

    public synchronized void sign(JWSHeader jWSHeader, JWSSigner jWSSigner) throws JOSEException {
        sign(jWSHeader, (UnprotectedHeader) null, jWSSigner);
    }

    public synchronized void sign(JWSHeader jWSHeader, UnprotectedHeader unprotectedHeader, JWSSigner jWSSigner) throws JOSEException {
        try {
            HeaderValidation.ensureDisjoint(jWSHeader, unprotectedHeader);
            JWSObject jWSObject = new JWSObject(jWSHeader, getPayload());
            jWSObject.sign(jWSSigner);
            this.signatures.add(new Signature(getPayload(), jWSHeader, unprotectedHeader, jWSObject.getSignature()));
        } catch (IllegalHeaderException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

    public State getState() {
        if (getSignatures().isEmpty()) {
            return State.UNSIGNED;
        }
        for (Signature isVerified : getSignatures()) {
            if (!isVerified.isVerified()) {
                return State.SIGNED;
            }
        }
        return State.VERIFIED;
    }

    public Map<String, Object> toGeneralJSONObject() {
        if (this.signatures.size() >= 1) {
            Map<String, Object> newJSONObject = JSONObjectUtils.newJSONObject();
            newJSONObject.put("payload", getPayload().toBase64URL().toString());
            List<Object> newJSONArray = JSONArrayUtils.newJSONArray();
            for (Signature access$100 : getSignatures()) {
                newJSONArray.add(access$100.toJSONObject());
            }
            newJSONObject.put("signatures", newJSONArray);
            return newJSONObject;
        }
        throw new IllegalStateException("The general JWS JSON serialization requires at least one signature");
    }

    public Map<String, Object> toFlattenedJSONObject() {
        if (this.signatures.size() == 1) {
            Map<String, Object> newJSONObject = JSONObjectUtils.newJSONObject();
            newJSONObject.put("payload", getPayload().toBase64URL().toString());
            newJSONObject.putAll(getSignatures().get(0).toJSONObject());
            return newJSONObject;
        }
        throw new IllegalStateException("The flattened JWS JSON serialization requires exactly one signature");
    }

    public String serializeGeneral() {
        return JSONObjectUtils.toJSONString(toGeneralJSONObject());
    }

    public String serializeFlattened() {
        return JSONObjectUtils.toJSONString(toFlattenedJSONObject());
    }

    private static JWSHeader parseJWSHeader(Map<String, Object> map) throws ParseException {
        Base64URL base64URL = JSONObjectUtils.getBase64URL(map, "protected");
        if (base64URL != null) {
            try {
                return JWSHeader.parse(base64URL);
            } catch (ParseException e) {
                if ("Not a JWS header".equals(e.getMessage())) {
                    throw new ParseException("Missing JWS \"alg\" parameter in protected header (required by this library)", 0);
                }
                throw e;
            }
        } else {
            throw new ParseException("Missing protected header (required by this library)", 0);
        }
    }

    public static JWSObjectJSON parse(Map<String, Object> map) throws ParseException {
        Base64URL base64URL = JSONObjectUtils.getBase64URL(map, "payload");
        if (base64URL != null) {
            Payload payload = new Payload(base64URL);
            Base64URL base64URL2 = JSONObjectUtils.getBase64URL(map, "signature");
            boolean z = base64URL2 != null;
            LinkedList linkedList = new LinkedList();
            if (z) {
                JWSHeader parseJWSHeader = parseJWSHeader(map);
                UnprotectedHeader parse = UnprotectedHeader.parse(JSONObjectUtils.getJSONObject(map, "header"));
                if (map.get("signatures") == null) {
                    try {
                        HeaderValidation.ensureDisjoint(parseJWSHeader, parse);
                        linkedList.add(new Signature(payload, parseJWSHeader, parse, base64URL2));
                    } catch (IllegalHeaderException e) {
                        throw new ParseException(e.getMessage(), 0);
                    }
                } else {
                    throw new ParseException("The \"signatures\" member must not be present in flattened JWS JSON serialization", 0);
                }
            } else {
                Map[] jSONObjectArray = JSONObjectUtils.getJSONObjectArray(map, "signatures");
                if (jSONObjectArray == null || jSONObjectArray.length == 0) {
                    throw new ParseException("The \"signatures\" member must be present in general JSON Serialization", 0);
                }
                int length = jSONObjectArray.length;
                int i = 0;
                while (i < length) {
                    Map map2 = jSONObjectArray[i];
                    JWSHeader parseJWSHeader2 = parseJWSHeader(map2);
                    UnprotectedHeader parse2 = UnprotectedHeader.parse(JSONObjectUtils.getJSONObject(map2, "header"));
                    try {
                        HeaderValidation.ensureDisjoint(parseJWSHeader2, parse2);
                        Base64URL base64URL3 = JSONObjectUtils.getBase64URL(map2, "signature");
                        if (base64URL3 != null) {
                            linkedList.add(new Signature(payload, parseJWSHeader2, parse2, base64URL3));
                            i++;
                        } else {
                            throw new ParseException("Missing \"signature\" member", 0);
                        }
                    } catch (IllegalHeaderException e2) {
                        throw new ParseException(e2.getMessage(), 0);
                    }
                }
            }
            return new JWSObjectJSON(payload, linkedList);
        }
        throw new ParseException("Missing payload", 0);
    }

    public static JWSObjectJSON parse(String str) throws ParseException {
        return parse(JSONObjectUtils.parse(str));
    }
}
