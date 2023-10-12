package com.stripe.android.stripe3ds2.security;

import com.nimbusds.jose.jwk.KeyUse;
import com.stripe.android.stripe3ds2.exceptions.SDKRuntimeException;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\f\b\u0001\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001dB1\b\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001c¨\u0006\u001e"}, d2 = {"Lcom/stripe/android/stripe3ds2/security/DirectoryServer;", "", "ids", "", "", "algorithm", "Lcom/stripe/android/stripe3ds2/security/Algorithm;", "fileName", "keyUse", "Lcom/nimbusds/jose/jwk/KeyUse;", "(Ljava/lang/String;ILjava/util/List;Lcom/stripe/android/stripe3ds2/security/Algorithm;Ljava/lang/String;Lcom/nimbusds/jose/jwk/KeyUse;)V", "getAlgorithm", "()Lcom/stripe/android/stripe3ds2/security/Algorithm;", "getFileName", "()Ljava/lang/String;", "getIds", "()Ljava/util/List;", "isCertificate", "", "()Z", "getKeyUse", "()Lcom/nimbusds/jose/jwk/KeyUse;", "TestRsa", "TestEc", "Visa", "Mastercard", "Amex", "Discover", "CartesBancaires", "Companion", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DirectoryServer.kt */
public enum DirectoryServer {
    TestRsa(CollectionsKt.listOf("F055545342"), Algorithm.RSA, "ds-test-rsa.txt", (Algorithm) null, 8, (KeyUse) null),
    TestEc(CollectionsKt.listOf("F155545342"), Algorithm.EC, "ds-test-ec.txt", (Algorithm) null, 8, (KeyUse) null),
    Visa(CollectionsKt.listOf("A000000003"), Algorithm.RSA, "ds-visa.crt", (Algorithm) null, 8, (KeyUse) null),
    Mastercard(CollectionsKt.listOf("A000000004"), Algorithm.RSA, "ds-mastercard.crt", (Algorithm) null, 8, (KeyUse) null),
    Amex(CollectionsKt.listOf("A000000025"), Algorithm.RSA, "ds-amex.pem", (Algorithm) null, 8, (KeyUse) null),
    Discover(CollectionsKt.listOf("A000000152", "A000000324"), Algorithm.RSA, "ds-discover.cer", (Algorithm) null),
    CartesBancaires(CollectionsKt.listOf("A000000042"), Algorithm.RSA, "ds-cartesbancaires.pem", (Algorithm) null, 8, (KeyUse) null);
    
    private static final Set<String> CERTIFICATE_EXTENSIONS = null;
    public static final Companion Companion = null;
    private final Algorithm algorithm;
    private final String fileName;
    private final List<String> ids;
    private final KeyUse keyUse;

    private DirectoryServer(List<String> list, Algorithm algorithm2, String str, KeyUse keyUse2) {
        this.ids = list;
        this.algorithm = algorithm2;
        this.fileName = str;
        this.keyUse = keyUse2;
    }

    public final List<String> getIds() {
        return this.ids;
    }

    public final Algorithm getAlgorithm() {
        return this.algorithm;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final KeyUse getKeyUse() {
        return this.keyUse;
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
        CERTIFICATE_EXTENSIONS = SetsKt.setOf(".crt", ".cer", ".pem");
    }

    public final boolean isCertificate() {
        Iterable<String> iterable = CERTIFICATE_EXTENSIONS;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return false;
        }
        for (String endsWith$default : iterable) {
            if (StringsKt.endsWith$default(getFileName(), endsWith$default, false, 2, (Object) null)) {
                return true;
            }
        }
        return false;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/stripe/android/stripe3ds2/security/DirectoryServer$Companion;", "", "()V", "CERTIFICATE_EXTENSIONS", "", "", "lookup", "Lcom/stripe/android/stripe3ds2/security/DirectoryServer;", "directoryServerId", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DirectoryServer.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DirectoryServer lookup(String str) {
            DirectoryServer directoryServer;
            Intrinsics.checkNotNullParameter(str, "directoryServerId");
            DirectoryServer[] values = DirectoryServer.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    directoryServer = null;
                    break;
                }
                directoryServer = values[i];
                i++;
                if (directoryServer.getIds().contains(str)) {
                    break;
                }
            }
            if (directoryServer != null) {
                return directoryServer;
            }
            throw new SDKRuntimeException(new IllegalArgumentException(Intrinsics.stringPlus("Unknown directory server id: ", str)));
        }
    }
}
