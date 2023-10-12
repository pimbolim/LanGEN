package com.google.android.gms.internal.wallet;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wallet.CreateWalletObjectsRequest;
import com.google.android.gms.wallet.zzas;

/* compiled from: com.google.android.gms:play-services-wallet@@19.1.0 */
final class zzae extends zzas {
    final /* synthetic */ CreateWalletObjectsRequest zza;
    final /* synthetic */ int zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzae(zzaf zzaf, GoogleApiClient googleApiClient, CreateWalletObjectsRequest createWalletObjectsRequest, int i) {
        super(googleApiClient);
        this.zza = createWalletObjectsRequest;
        this.zzb = i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: zza */
    public final void doExecute(zzac zzac) {
        zzac.zzp(this.zza, this.zzb);
        setResult(Status.RESULT_SUCCESS);
    }
}
