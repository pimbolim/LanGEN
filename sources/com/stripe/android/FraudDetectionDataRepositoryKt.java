package com.stripe.android;

import com.stripe.android.core.networking.StripeResponse;
import com.stripe.android.core.networking.StripeResponseKtxKt;
import com.stripe.android.model.parsers.FraudDetectionDataJsonParser;
import com.stripe.android.networking.FraudDetectionData;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u001a\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"fraudDetectionJsonParser", "Lcom/stripe/android/model/parsers/FraudDetectionDataJsonParser;", "timestampSupplier", "Lkotlin/Function0;", "", "fraudDetectionData", "Lcom/stripe/android/networking/FraudDetectionData;", "Lcom/stripe/android/core/networking/StripeResponse;", "", "payments-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: FraudDetectionDataRepository.kt */
public final class FraudDetectionDataRepositoryKt {
    private static final FraudDetectionDataJsonParser fraudDetectionJsonParser;
    /* access modifiers changed from: private */
    public static final Function0<Long> timestampSupplier;

    static {
        Function0<Long> function0 = FraudDetectionDataRepositoryKt$timestampSupplier$1.INSTANCE;
        timestampSupplier = function0;
        fraudDetectionJsonParser = new FraudDetectionDataJsonParser(function0);
    }

    /* access modifiers changed from: private */
    public static final FraudDetectionData fraudDetectionData(StripeResponse<String> stripeResponse) {
        if (!stripeResponse.isOk()) {
            stripeResponse = null;
        }
        if (stripeResponse == null) {
            return null;
        }
        return fraudDetectionJsonParser.parse(StripeResponseKtxKt.responseJson(stripeResponse));
    }
}
