package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-wallet@@19.1.0 */
public final class zzq implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        ArrayList<Integer> arrayList = null;
        String str = null;
        String str2 = null;
        ArrayList<Integer> arrayList2 = null;
        String str3 = null;
        boolean z = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    arrayList = SafeParcelReader.createIntegerList(parcel, readHeader);
                    break;
                case 4:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 5:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 6:
                    arrayList2 = SafeParcelReader.createIntegerList(parcel, readHeader);
                    break;
                case 7:
                    z = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 8:
                    str3 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new IsReadyToPayRequest(arrayList, str, str2, arrayList2, z, str3);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new IsReadyToPayRequest[i];
    }
}
