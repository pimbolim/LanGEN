package com.nimbusds.jose;

public class ActionRequiredForJWSCompletionException extends JOSEException {
    private final CompletableJWSObjectSigning completableSigning;
    private final JWSSignerOption option;

    public ActionRequiredForJWSCompletionException(String str, JWSSignerOption jWSSignerOption, CompletableJWSObjectSigning completableJWSObjectSigning) {
        super(str);
        if (jWSSignerOption != null) {
            this.option = jWSSignerOption;
            if (completableJWSObjectSigning != null) {
                this.completableSigning = completableJWSObjectSigning;
                return;
            }
            throw new IllegalArgumentException("The completable signing must not be null");
        }
        throw new IllegalArgumentException("The triggering option must not be null");
    }

    public JWSSignerOption getTriggeringOption() {
        return this.option;
    }

    public CompletableJWSObjectSigning getCompletableJWSObjectSigning() {
        return this.completableSigning;
    }
}
