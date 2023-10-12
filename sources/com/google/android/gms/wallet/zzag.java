package com.google.android.gms.wallet;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.internal.wallet.zzac;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-wallet@@19.1.0 */
public final /* synthetic */ class zzag implements RemoteCall {
    public final /* synthetic */ IsReadyToPayRequest zza;

    public /* synthetic */ zzag(IsReadyToPayRequest isReadyToPayRequest) {
        this.zza = isReadyToPayRequest;
    }

    public final void accept(Object obj, Object obj2) {
        int i = PaymentsClient.zza;
        ((zzac) obj).zzs(this.zza, (TaskCompletionSource) obj2);
    }
}
