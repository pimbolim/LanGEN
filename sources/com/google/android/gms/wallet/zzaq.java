package com.google.android.gms.wallet;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.internal.wallet.zzac;

/* compiled from: com.google.android.gms:play-services-wallet@@19.1.0 */
public abstract class zzaq extends BaseImplementation.ApiMethodImpl {
    public zzaq(GoogleApiClient googleApiClient) {
        super((Api<?>) Wallet.API, googleApiClient);
    }

    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        super.setResult((Result) obj);
    }

    /* access modifiers changed from: protected */
    /* renamed from: zza */
    public abstract void doExecute(zzac zzac) throws RemoteException;
}
