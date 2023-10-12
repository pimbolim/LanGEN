package com.google.android.gms.internal.wallet;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.wallet.CreateWalletObjectsRequest;
import com.google.android.gms.wallet.wobs.WalletObjects;

/* compiled from: com.google.android.gms:play-services-wallet@@19.1.0 */
public final class zzaf implements WalletObjects {
    public final void createWalletObjects(GoogleApiClient googleApiClient, CreateWalletObjectsRequest createWalletObjectsRequest, int i) {
        googleApiClient.enqueue(new zzae(this, googleApiClient, createWalletObjectsRequest, i));
    }
}
