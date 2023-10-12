package com.google.android.gms.wallet;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wallet.Wallet;

/* compiled from: com.google.android.gms:play-services-wallet@@19.1.0 */
public class PaymentsClient extends GoogleApi<Wallet.WalletOptions> {
    public static final /* synthetic */ int zza = 0;

    PaymentsClient(Activity activity, Wallet.WalletOptions walletOptions) {
        super(activity, Wallet.API, walletOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    public Task<PaymentCardRecognitionIntentResponse> getPaymentCardRecognitionIntent(PaymentCardRecognitionIntentRequest paymentCardRecognitionIntentRequest) {
        return doRead(TaskApiCall.builder().run(new zzah(paymentCardRecognitionIntentRequest)).setFeatures(zzk.zzg).setAutoResolveMissingFeatures(true).setMethodKey(23716).build());
    }

    public Task<Boolean> isReadyToPay(IsReadyToPayRequest isReadyToPayRequest) {
        return doRead(TaskApiCall.builder().setMethodKey(23705).run(new zzag(isReadyToPayRequest)).build());
    }

    public Task<PaymentData> loadPaymentData(PaymentDataRequest paymentDataRequest) {
        return doWrite(TaskApiCall.builder().run(new zzai(paymentDataRequest)).setFeatures(zzk.zzc).setAutoResolveMissingFeatures(true).setMethodKey(23707).build());
    }

    PaymentsClient(Context context, Wallet.WalletOptions walletOptions) {
        super(context, Wallet.API, walletOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
    }
}
