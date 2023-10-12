package com.google.android.gms.internal.identity;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.AccountType;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.identity.intents.AddressConstants;
import com.google.android.gms.identity.intents.UserAddressRequest;

/* compiled from: com.google.android.gms:play-services-identity@@17.0.1 */
public final class zze extends GmsClient<zzh> {
    private final Activity zze;
    private zzd zzf;
    private final String zzg;
    private final int zzh;

    public zze(Activity activity, Looper looper, ClientSettings clientSettings, int i, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super((Context) activity, looper, 12, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.zzg = clientSettings.getAccountName();
        this.zze = activity;
        this.zzh = i;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.identity.intents.internal.IAddressService");
        if (queryLocalInterface instanceof zzh) {
            return (zzh) queryLocalInterface;
        }
        return new zzh(iBinder);
    }

    public final void disconnect() {
        super.disconnect();
        zzd zzd = this.zzf;
        if (zzd != null) {
            zzd.zzb = null;
            this.zzf = null;
        }
    }

    public final int getMinApkVersion() {
        return GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    /* access modifiers changed from: protected */
    public final String getServiceDescriptor() {
        return "com.google.android.gms.identity.intents.internal.IAddressService";
    }

    /* access modifiers changed from: protected */
    public final String getStartServiceAction() {
        return "com.google.android.gms.identity.service.BIND";
    }

    public final boolean requiresAccount() {
        return true;
    }

    public final void zzp(UserAddressRequest userAddressRequest, int i) {
        super.checkConnected();
        this.zzf = new zzd(i, this.zze);
        try {
            Bundle bundle = new Bundle();
            bundle.putString("com.google.android.gms.identity.intents.EXTRA_CALLING_PACKAGE_NAME", getContext().getPackageName());
            if (!TextUtils.isEmpty(this.zzg)) {
                bundle.putParcelable("com.google.android.gms.identity.intents.EXTRA_ACCOUNT", new Account(this.zzg, AccountType.GOOGLE));
            }
            bundle.putInt("com.google.android.gms.identity.intents.EXTRA_THEME", this.zzh);
            ((zzh) super.getService()).zzc((zzg) Preconditions.checkNotNull(this.zzf), userAddressRequest, bundle);
        } catch (RemoteException e) {
            Log.e("AddressClientImpl", "Exception requesting user address", e);
            Bundle bundle2 = new Bundle();
            bundle2.putInt(AddressConstants.Extras.EXTRA_ERROR_CODE, AddressConstants.ErrorCodes.ERROR_CODE_NO_APPLICABLE_ADDRESSES);
            ((zzd) Preconditions.checkNotNull(this.zzf)).zzc(1, bundle2);
        }
    }
}
