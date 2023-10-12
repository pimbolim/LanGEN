package com.google.android.gms.wallet;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.identity.intents.model.UserAddress;

/* compiled from: com.google.android.gms:play-services-wallet@@19.1.0 */
public final class PaymentData extends AbstractSafeParcelable implements AutoResolvableResult {
    public static final Parcelable.Creator<PaymentData> CREATOR = new zzaa();
    String zza;
    CardInfo zzb;
    UserAddress zzc;
    PaymentMethodToken zzd;
    String zze;
    Bundle zzf;
    String zzg;
    Bundle zzh;

    private PaymentData() {
    }

    public static PaymentData fromJson(String str) {
        PaymentData paymentData = new PaymentData();
        paymentData.zzg = (String) Preconditions.checkNotNull(str, "paymentDataJson cannot be null!");
        return paymentData;
    }

    public static PaymentData getFromIntent(Intent intent) {
        return (PaymentData) SafeParcelableSerializer.deserializeFromIntentExtra(intent, "com.google.android.gms.wallet.PaymentData", CREATOR);
    }

    @Deprecated
    public CardInfo getCardInfo() {
        return this.zzb;
    }

    @Deprecated
    public String getEmail() {
        return this.zza;
    }

    @Deprecated
    public Bundle getExtraData() {
        return this.zzf;
    }

    @Deprecated
    public String getGoogleTransactionId() {
        return this.zze;
    }

    public Bundle getLastSavedState() {
        return this.zzh;
    }

    @Deprecated
    public PaymentMethodToken getPaymentMethodToken() {
        return this.zzd;
    }

    @Deprecated
    public UserAddress getShippingAddress() {
        return this.zzc;
    }

    public void putIntoIntent(Intent intent) {
        SafeParcelableSerializer.serializeToIntentExtra(this, intent, "com.google.android.gms.wallet.PaymentData");
    }

    public String toJson() {
        return this.zzg;
    }

    public PaymentData withLastSavedState(Bundle bundle) {
        this.zzh = bundle;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.writeString(parcel, 5, this.zze, false);
        SafeParcelWriter.writeBundle(parcel, 6, this.zzf, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzg, false);
        SafeParcelWriter.writeBundle(parcel, 8, this.zzh, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    PaymentData(String str, CardInfo cardInfo, UserAddress userAddress, PaymentMethodToken paymentMethodToken, String str2, Bundle bundle, String str3, Bundle bundle2) {
        this.zza = str;
        this.zzb = cardInfo;
        this.zzc = userAddress;
        this.zzd = paymentMethodToken;
        this.zze = str2;
        this.zzf = bundle;
        this.zzg = str3;
        this.zzh = bundle2;
    }
}
