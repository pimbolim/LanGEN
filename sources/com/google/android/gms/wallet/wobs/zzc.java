package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-wallet@@19.1.0 */
public final class zzc implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        ArrayList<WalletObjectMessage> newArrayList = ArrayUtils.newArrayList();
        ArrayList<LatLng> newArrayList2 = ArrayUtils.newArrayList();
        ArrayList<LabelValueRow> newArrayList3 = ArrayUtils.newArrayList();
        ArrayList<WalletObjectMessage> arrayList = newArrayList;
        ArrayList<LatLng> arrayList2 = newArrayList2;
        ArrayList<LabelValueRow> arrayList3 = newArrayList3;
        ArrayList<UriData> newArrayList4 = ArrayUtils.newArrayList();
        ArrayList<TextModuleData> newArrayList5 = ArrayUtils.newArrayList();
        ArrayList<UriData> newArrayList6 = ArrayUtils.newArrayList();
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        TimeInterval timeInterval = null;
        String str9 = null;
        String str10 = null;
        int i = 0;
        boolean z = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    str = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 3:
                    str2 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 4:
                    str3 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 5:
                    str4 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 6:
                    str5 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 7:
                    str6 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 8:
                    str7 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 9:
                    str8 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 10:
                    i = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 11:
                    arrayList = SafeParcelReader.createTypedList(parcel2, readHeader, WalletObjectMessage.CREATOR);
                    break;
                case 12:
                    timeInterval = (TimeInterval) SafeParcelReader.createParcelable(parcel2, readHeader, TimeInterval.CREATOR);
                    break;
                case 13:
                    arrayList2 = SafeParcelReader.createTypedList(parcel2, readHeader, LatLng.CREATOR);
                    break;
                case 14:
                    str9 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 15:
                    str10 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 16:
                    arrayList3 = SafeParcelReader.createTypedList(parcel2, readHeader, LabelValueRow.CREATOR);
                    break;
                case 17:
                    z = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 18:
                    newArrayList4 = SafeParcelReader.createTypedList(parcel2, readHeader, UriData.CREATOR);
                    break;
                case 19:
                    newArrayList5 = SafeParcelReader.createTypedList(parcel2, readHeader, TextModuleData.CREATOR);
                    break;
                case 20:
                    newArrayList6 = SafeParcelReader.createTypedList(parcel2, readHeader, UriData.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new CommonWalletObject(str, str2, str3, str4, str5, str6, str7, str8, i, arrayList, timeInterval, arrayList2, str9, str10, arrayList3, z, newArrayList4, newArrayList5, newArrayList6);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new CommonWalletObject[i];
    }
}
