package com.stripe.android.stripe3ds2.transaction;

import com.stripe.android.model.parsers.AccountRangeJsonParser;
import com.stripe.android.stripe3ds2.security.EphemeralKeyPairGenerator;
import com.stripe.android.stripe3ds2.views.Brand;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJH\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/DefaultTransactionFactory;", "Lcom/stripe/android/stripe3ds2/transaction/TransactionFactory;", "areqParamsFactory", "Lcom/stripe/android/stripe3ds2/transaction/AuthenticationRequestParametersFactory;", "ephemeralKeyPairGenerator", "Lcom/stripe/android/stripe3ds2/security/EphemeralKeyPairGenerator;", "sdkReferenceNumber", "", "(Lcom/stripe/android/stripe3ds2/transaction/AuthenticationRequestParametersFactory;Lcom/stripe/android/stripe3ds2/security/EphemeralKeyPairGenerator;Ljava/lang/String;)V", "create", "Lcom/stripe/android/stripe3ds2/transaction/Transaction;", "directoryServerId", "rootCerts", "", "Ljava/security/cert/X509Certificate;", "directoryServerPublicKey", "Ljava/security/PublicKey;", "keyId", "sdkTransactionId", "Lcom/stripe/android/stripe3ds2/transaction/SdkTransactionId;", "isLiveMode", "", "brand", "Lcom/stripe/android/stripe3ds2/views/Brand;", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TransactionFactory.kt */
public final class DefaultTransactionFactory implements TransactionFactory {
    private final AuthenticationRequestParametersFactory areqParamsFactory;
    private final EphemeralKeyPairGenerator ephemeralKeyPairGenerator;
    private final String sdkReferenceNumber;

    public DefaultTransactionFactory(AuthenticationRequestParametersFactory authenticationRequestParametersFactory, EphemeralKeyPairGenerator ephemeralKeyPairGenerator2, String str) {
        Intrinsics.checkNotNullParameter(authenticationRequestParametersFactory, "areqParamsFactory");
        Intrinsics.checkNotNullParameter(ephemeralKeyPairGenerator2, "ephemeralKeyPairGenerator");
        Intrinsics.checkNotNullParameter(str, "sdkReferenceNumber");
        this.areqParamsFactory = authenticationRequestParametersFactory;
        this.ephemeralKeyPairGenerator = ephemeralKeyPairGenerator2;
        this.sdkReferenceNumber = str;
    }

    public Transaction create(String str, List<? extends X509Certificate> list, PublicKey publicKey, String str2, SdkTransactionId sdkTransactionId, boolean z, Brand brand) {
        Intrinsics.checkNotNullParameter(str, "directoryServerId");
        Intrinsics.checkNotNullParameter(list, "rootCerts");
        Intrinsics.checkNotNullParameter(publicKey, "directoryServerPublicKey");
        Intrinsics.checkNotNullParameter(sdkTransactionId, "sdkTransactionId");
        Intrinsics.checkNotNullParameter(brand, AccountRangeJsonParser.FIELD_BRAND);
        return new StripeTransaction(this.areqParamsFactory, str, publicKey, str2, sdkTransactionId, this.ephemeralKeyPairGenerator.generate(), this.sdkReferenceNumber);
    }
}
