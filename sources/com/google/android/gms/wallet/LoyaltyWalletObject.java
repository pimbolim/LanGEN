package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.wallet.wobs.LabelValueRow;
import com.google.android.gms.wallet.wobs.LoyaltyPoints;
import com.google.android.gms.wallet.wobs.TextModuleData;
import com.google.android.gms.wallet.wobs.TimeInterval;
import com.google.android.gms.wallet.wobs.UriData;
import com.google.android.gms.wallet.wobs.WalletObjectMessage;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: com.google.android.gms:play-services-wallet@@19.1.0 */
public final class LoyaltyWalletObject extends AbstractSafeParcelable {
    public static final Parcelable.Creator<LoyaltyWalletObject> CREATOR = new zzs();
    String zza;
    String zzb;
    String zzc;
    String zzd;
    String zze;
    String zzf;
    String zzg;
    String zzh;
    @Deprecated
    String zzi;
    String zzj;
    int zzk;
    ArrayList zzl;
    TimeInterval zzm;
    ArrayList zzn;
    @Deprecated
    String zzo;
    @Deprecated
    String zzp;
    ArrayList zzq;
    boolean zzr;
    ArrayList zzs;
    ArrayList zzt;
    ArrayList zzu;
    LoyaltyPoints zzv;

    /* compiled from: com.google.android.gms:play-services-wallet@@19.1.0 */
    public final class Builder {
        /* synthetic */ Builder(zzr zzr) {
        }

        public Builder addImageModuleDataMainImageUri(UriData uriData) {
            LoyaltyWalletObject.this.zzs.add(uriData);
            return this;
        }

        public Builder addImageModuleDataMainImageUris(Collection<UriData> collection) {
            LoyaltyWalletObject.this.zzs.addAll(collection);
            return this;
        }

        public Builder addInfoModuleDataLabeValueRow(LabelValueRow labelValueRow) {
            LoyaltyWalletObject.this.zzq.add(labelValueRow);
            return this;
        }

        public Builder addInfoModuleDataLabelValueRows(Collection<LabelValueRow> collection) {
            LoyaltyWalletObject.this.zzq.addAll(collection);
            return this;
        }

        public Builder addLinksModuleDataUri(UriData uriData) {
            LoyaltyWalletObject.this.zzu.add(uriData);
            return this;
        }

        public Builder addLinksModuleDataUris(Collection<UriData> collection) {
            LoyaltyWalletObject.this.zzu.addAll(collection);
            return this;
        }

        public Builder addLocation(LatLng latLng) {
            LoyaltyWalletObject.this.zzn.add(latLng);
            return this;
        }

        public Builder addLocations(Collection<LatLng> collection) {
            LoyaltyWalletObject.this.zzn.addAll(collection);
            return this;
        }

        public Builder addMessage(WalletObjectMessage walletObjectMessage) {
            LoyaltyWalletObject.this.zzl.add(walletObjectMessage);
            return this;
        }

        public Builder addMessages(Collection<WalletObjectMessage> collection) {
            LoyaltyWalletObject.this.zzl.addAll(collection);
            return this;
        }

        public Builder addTextModuleData(TextModuleData textModuleData) {
            LoyaltyWalletObject.this.zzt.add(textModuleData);
            return this;
        }

        public Builder addTextModulesData(Collection<TextModuleData> collection) {
            LoyaltyWalletObject.this.zzt.addAll(collection);
            return this;
        }

        public LoyaltyWalletObject build() {
            return LoyaltyWalletObject.this;
        }

        public Builder setAccountId(String str) {
            LoyaltyWalletObject.this.zzb = str;
            return this;
        }

        public Builder setAccountName(String str) {
            LoyaltyWalletObject.this.zze = str;
            return this;
        }

        public Builder setBarcodeAlternateText(String str) {
            LoyaltyWalletObject.this.zzf = str;
            return this;
        }

        @Deprecated
        public Builder setBarcodeLabel(String str) {
            LoyaltyWalletObject.this.zzi = str;
            return this;
        }

        public Builder setBarcodeType(String str) {
            LoyaltyWalletObject.this.zzg = str;
            return this;
        }

        public Builder setBarcodeValue(String str) {
            LoyaltyWalletObject.this.zzh = str;
            return this;
        }

        public Builder setClassId(String str) {
            LoyaltyWalletObject.this.zzj = str;
            return this;
        }

        public Builder setId(String str) {
            LoyaltyWalletObject.this.zza = str;
            return this;
        }

        @Deprecated
        public Builder setInfoModuleDataHexBackgroundColor(String str) {
            LoyaltyWalletObject.this.zzp = str;
            return this;
        }

        @Deprecated
        public Builder setInfoModuleDataHexFontColor(String str) {
            LoyaltyWalletObject.this.zzo = str;
            return this;
        }

        public Builder setInfoModuleDataShowLastUpdateTime(boolean z) {
            LoyaltyWalletObject.this.zzr = z;
            return this;
        }

        public Builder setIssuerName(String str) {
            LoyaltyWalletObject.this.zzc = str;
            return this;
        }

        public Builder setLoyaltyPoints(LoyaltyPoints loyaltyPoints) {
            LoyaltyWalletObject.this.zzv = loyaltyPoints;
            return this;
        }

        public Builder setProgramName(String str) {
            LoyaltyWalletObject.this.zzd = str;
            return this;
        }

        public Builder setState(int i) {
            LoyaltyWalletObject.this.zzk = i;
            return this;
        }

        public Builder setValidTimeInterval(TimeInterval timeInterval) {
            LoyaltyWalletObject.this.zzm = timeInterval;
            return this;
        }
    }

    LoyaltyWalletObject() {
        this.zzl = ArrayUtils.newArrayList();
        this.zzn = ArrayUtils.newArrayList();
        this.zzq = ArrayUtils.newArrayList();
        this.zzs = ArrayUtils.newArrayList();
        this.zzt = ArrayUtils.newArrayList();
        this.zzu = ArrayUtils.newArrayList();
    }

    public static Builder newBuilder() {
        return new Builder((zzr) null);
    }

    public String getAccountId() {
        return this.zzb;
    }

    public String getAccountName() {
        return this.zze;
    }

    public String getBarcodeAlternateText() {
        return this.zzf;
    }

    @Deprecated
    public String getBarcodeLabel() {
        return this.zzi;
    }

    public String getBarcodeType() {
        return this.zzg;
    }

    public String getBarcodeValue() {
        return this.zzh;
    }

    public String getClassId() {
        return this.zzj;
    }

    public String getId() {
        return this.zza;
    }

    public ArrayList<UriData> getImageModuleDataMainImageUris() {
        return this.zzs;
    }

    @Deprecated
    public String getInfoModuleDataHexBackgroundColor() {
        return this.zzp;
    }

    @Deprecated
    public String getInfoModuleDataHexFontColor() {
        return this.zzo;
    }

    public ArrayList<LabelValueRow> getInfoModuleDataLabelValueRows() {
        return this.zzq;
    }

    public boolean getInfoModuleDataShowLastUpdateTime() {
        return this.zzr;
    }

    public String getIssuerName() {
        return this.zzc;
    }

    public ArrayList<UriData> getLinksModuleDataUris() {
        return this.zzu;
    }

    public ArrayList<LatLng> getLocations() {
        return this.zzn;
    }

    public LoyaltyPoints getLoyaltyPoints() {
        return this.zzv;
    }

    public ArrayList<WalletObjectMessage> getMessages() {
        return this.zzl;
    }

    public String getProgramName() {
        return this.zzd;
    }

    public int getState() {
        return this.zzk;
    }

    public ArrayList<TextModuleData> getTextModulesData() {
        return this.zzt;
    }

    public TimeInterval getValidTimeInterval() {
        return this.zzm;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzd, false);
        SafeParcelWriter.writeString(parcel, 6, this.zze, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzf, false);
        SafeParcelWriter.writeString(parcel, 8, this.zzg, false);
        SafeParcelWriter.writeString(parcel, 9, this.zzh, false);
        SafeParcelWriter.writeString(parcel, 10, this.zzi, false);
        SafeParcelWriter.writeString(parcel, 11, this.zzj, false);
        SafeParcelWriter.writeInt(parcel, 12, this.zzk);
        SafeParcelWriter.writeTypedList(parcel, 13, this.zzl, false);
        SafeParcelWriter.writeParcelable(parcel, 14, this.zzm, i, false);
        SafeParcelWriter.writeTypedList(parcel, 15, this.zzn, false);
        SafeParcelWriter.writeString(parcel, 16, this.zzo, false);
        SafeParcelWriter.writeString(parcel, 17, this.zzp, false);
        SafeParcelWriter.writeTypedList(parcel, 18, this.zzq, false);
        SafeParcelWriter.writeBoolean(parcel, 19, this.zzr);
        SafeParcelWriter.writeTypedList(parcel, 20, this.zzs, false);
        SafeParcelWriter.writeTypedList(parcel, 21, this.zzt, false);
        SafeParcelWriter.writeTypedList(parcel, 22, this.zzu, false);
        SafeParcelWriter.writeParcelable(parcel, 23, this.zzv, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    LoyaltyWalletObject(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i, ArrayList arrayList, TimeInterval timeInterval, ArrayList arrayList2, String str11, String str12, ArrayList arrayList3, boolean z, ArrayList arrayList4, ArrayList arrayList5, ArrayList arrayList6, LoyaltyPoints loyaltyPoints) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
        this.zze = str5;
        this.zzf = str6;
        this.zzg = str7;
        this.zzh = str8;
        this.zzi = str9;
        this.zzj = str10;
        this.zzk = i;
        this.zzl = arrayList;
        this.zzm = timeInterval;
        this.zzn = arrayList2;
        this.zzo = str11;
        this.zzp = str12;
        this.zzq = arrayList3;
        this.zzr = z;
        this.zzs = arrayList4;
        this.zzt = arrayList5;
        this.zzu = arrayList6;
        this.zzv = loyaltyPoints;
    }
}
