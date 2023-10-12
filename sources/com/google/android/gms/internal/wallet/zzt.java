package com.google.android.gms.internal.wallet;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wallet.FullWallet;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.PaymentCardRecognitionIntentResponse;
import com.google.android.gms.wallet.PaymentData;
import com.google.android.gms.wallet.zzau;

/* compiled from: com.google.android.gms:play-services-wallet@@19.1.0 */
public abstract class zzt extends zzb implements zzu {
    public zzt() {
        super("com.google.android.gms.wallet.internal.IWalletServiceCallbacks");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zzd(parcel.readInt(), (MaskedWallet) zzc.zza(parcel, MaskedWallet.CREATOR), (Bundle) zzc.zza(parcel, Bundle.CREATOR));
                return true;
            case 2:
                zzb(parcel.readInt(), (FullWallet) zzc.zza(parcel, FullWallet.CREATOR), (Bundle) zzc.zza(parcel, Bundle.CREATOR));
                return true;
            case 3:
                zzg(parcel.readInt(), zzc.zzd(parcel), (Bundle) zzc.zza(parcel, Bundle.CREATOR));
                return true;
            case 4:
                zzh(parcel.readInt(), (Bundle) zzc.zza(parcel, Bundle.CREATOR));
                return true;
            case 6:
                parcel.readInt();
                zzc.zzd(parcel);
                Bundle bundle = (Bundle) zzc.zza(parcel, Bundle.CREATOR);
                return true;
            case 7:
                Status status = (Status) zzc.zza(parcel, Status.CREATOR);
                zzi zzi = (zzi) zzc.zza(parcel, zzi.CREATOR);
                Bundle bundle2 = (Bundle) zzc.zza(parcel, Bundle.CREATOR);
                return true;
            case 8:
                Status status2 = (Status) zzc.zza(parcel, Status.CREATOR);
                Bundle bundle3 = (Bundle) zzc.zza(parcel, Bundle.CREATOR);
                return true;
            case 9:
                zzc((Status) zzc.zza(parcel, Status.CREATOR), zzc.zzd(parcel), (Bundle) zzc.zza(parcel, Bundle.CREATOR));
                return true;
            case 10:
                Status status3 = (Status) zzc.zza(parcel, Status.CREATOR);
                zzk zzk = (zzk) zzc.zza(parcel, zzk.CREATOR);
                Bundle bundle4 = (Bundle) zzc.zza(parcel, Bundle.CREATOR);
                return true;
            case 11:
                Status status4 = (Status) zzc.zza(parcel, Status.CREATOR);
                Bundle bundle5 = (Bundle) zzc.zza(parcel, Bundle.CREATOR);
                return true;
            case 12:
                Status status5 = (Status) zzc.zza(parcel, Status.CREATOR);
                zzau zzau = (zzau) zzc.zza(parcel, zzau.CREATOR);
                Bundle bundle6 = (Bundle) zzc.zza(parcel, Bundle.CREATOR);
                return true;
            case 13:
                Status status6 = (Status) zzc.zza(parcel, Status.CREATOR);
                Bundle bundle7 = (Bundle) zzc.zza(parcel, Bundle.CREATOR);
                return true;
            case 14:
                zzf((Status) zzc.zza(parcel, Status.CREATOR), (PaymentData) zzc.zza(parcel, PaymentData.CREATOR), (Bundle) zzc.zza(parcel, Bundle.CREATOR));
                return true;
            case 15:
                Status status7 = (Status) zzc.zza(parcel, Status.CREATOR);
                zzq zzq = (zzq) zzc.zza(parcel, zzq.CREATOR);
                Bundle bundle8 = (Bundle) zzc.zza(parcel, Bundle.CREATOR);
                return true;
            case 16:
                Status status8 = (Status) zzc.zza(parcel, Status.CREATOR);
                zzm zzm = (zzm) zzc.zza(parcel, zzm.CREATOR);
                Bundle bundle9 = (Bundle) zzc.zza(parcel, Bundle.CREATOR);
                return true;
            case 17:
                Status status9 = (Status) zzc.zza(parcel, Status.CREATOR);
                zzo zzo = (zzo) zzc.zza(parcel, zzo.CREATOR);
                Bundle bundle10 = (Bundle) zzc.zza(parcel, Bundle.CREATOR);
                return true;
            case 18:
                parcel.readInt();
                Bundle bundle11 = (Bundle) zzc.zza(parcel, Bundle.CREATOR);
                return true;
            case 19:
                zze((Status) zzc.zza(parcel, Status.CREATOR), (PaymentCardRecognitionIntentResponse) zzc.zza(parcel, PaymentCardRecognitionIntentResponse.CREATOR), (Bundle) zzc.zza(parcel, Bundle.CREATOR));
                return true;
            default:
                return false;
        }
    }
}
