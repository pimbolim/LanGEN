package com.google.android.gms.identity.intents;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.identity.zze;

/* compiled from: com.google.android.gms:play-services-identity@@17.0.1 */
final class zzb extends zzc {
    final /* synthetic */ UserAddressRequest zza;
    final /* synthetic */ int zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzb(GoogleApiClient googleApiClient, UserAddressRequest userAddressRequest, int i) {
        super(googleApiClient);
        this.zza = userAddressRequest;
        this.zzb = i;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zze) anyClient).zzp(this.zza, this.zzb);
        setResult(Status.RESULT_SUCCESS);
    }
}
