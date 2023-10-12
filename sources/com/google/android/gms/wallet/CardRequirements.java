package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: com.google.android.gms:play-services-wallet@@19.1.0 */
public final class CardRequirements extends AbstractSafeParcelable {
    public static final Parcelable.Creator<CardRequirements> CREATOR = new zzg();
    ArrayList zza;
    boolean zzb;
    boolean zzc;
    int zzd;

    /* compiled from: com.google.android.gms:play-services-wallet@@19.1.0 */
    public final class Builder {
        /* synthetic */ Builder(zzf zzf) {
        }

        public Builder addAllowedCardNetwork(int i) {
            CardRequirements cardRequirements = CardRequirements.this;
            if (cardRequirements.zza == null) {
                cardRequirements.zza = new ArrayList();
            }
            CardRequirements.this.zza.add(Integer.valueOf(i));
            return this;
        }

        public Builder addAllowedCardNetworks(Collection<Integer> collection) {
            boolean z = false;
            if (collection != null && !collection.isEmpty()) {
                z = true;
            }
            Preconditions.checkArgument(z, "allowedCardNetworks can't be null or empty! You must provide a valid value from WalletConstants.CardNetwork.");
            CardRequirements cardRequirements = CardRequirements.this;
            if (cardRequirements.zza == null) {
                cardRequirements.zza = new ArrayList();
            }
            CardRequirements.this.zza.addAll(collection);
            return this;
        }

        public CardRequirements build() {
            Preconditions.checkNotNull(CardRequirements.this.zza, "Allowed card networks must be non-empty! You can set it through addAllowedCardNetwork() or addAllowedCardNetworks() in the CardRequirements Builder.");
            return CardRequirements.this;
        }

        public Builder setAllowPrepaidCards(boolean z) {
            CardRequirements.this.zzb = z;
            return this;
        }

        public Builder setBillingAddressFormat(int i) {
            CardRequirements.this.zzd = i;
            return this;
        }

        public Builder setBillingAddressRequired(boolean z) {
            CardRequirements.this.zzc = z;
            return this;
        }
    }

    private CardRequirements() {
        this.zzb = true;
    }

    public static Builder newBuilder() {
        return new Builder((zzf) null);
    }

    public boolean allowPrepaidCards() {
        return this.zzb;
    }

    public ArrayList<Integer> getAllowedCardNetworks() {
        return this.zza;
    }

    public int getBillingAddressFormat() {
        return this.zzd;
    }

    public boolean isBillingAddressRequired() {
        return this.zzc;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIntegerList(parcel, 1, this.zza, false);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzb);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzc);
        SafeParcelWriter.writeInt(parcel, 4, this.zzd);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    CardRequirements(ArrayList arrayList, boolean z, boolean z2, int i) {
        this.zza = arrayList;
        this.zzb = z;
        this.zzc = z2;
        this.zzd = i;
    }
}
