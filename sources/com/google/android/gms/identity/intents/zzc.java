package com.google.android.gms.identity.intents;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.internal.identity.zze;

/* compiled from: com.google.android.gms:play-services-identity@@17.0.1 */
abstract class zzc extends BaseImplementation.ApiMethodImpl<Status, zze> {
    public zzc(GoogleApiClient googleApiClient) {
        super((Api<?>) Address.API, googleApiClient);
    }

    public final /* bridge */ /* synthetic */ Result createFailedResult(Status status) {
        return status;
    }

    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        super.setResult((Result) obj);
    }
}
