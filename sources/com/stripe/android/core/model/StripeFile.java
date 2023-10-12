package com.stripe.android.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Bg\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jn\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010&J\t\u0010'\u001a\u00020\nHÖ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020\nHÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001J\u0019\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\nHÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013¨\u00063"}, d2 = {"Lcom/stripe/android/core/model/StripeFile;", "Lcom/stripe/android/core/model/StripeModel;", "id", "", "created", "", "filename", "purpose", "Lcom/stripe/android/core/model/StripeFilePurpose;", "size", "", "title", "type", "url", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Lcom/stripe/android/core/model/StripeFilePurpose;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCreated", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getFilename", "()Ljava/lang/String;", "getId", "getPurpose", "()Lcom/stripe/android/core/model/StripeFilePurpose;", "getSize", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTitle", "getType", "getUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Lcom/stripe/android/core/model/StripeFilePurpose;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/stripe/android/core/model/StripeFile;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StripeFile.kt */
public final class StripeFile implements StripeModel {
    public static final int $stable = 8;
    public static final Parcelable.Creator<StripeFile> CREATOR = new Creator();
    private final Long created;
    private final String filename;
    private final String id;
    private final StripeFilePurpose purpose;
    private final Integer size;
    private final String title;
    private final String type;
    private final String url;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StripeFile.kt */
    public static final class Creator implements Parcelable.Creator<StripeFile> {
        public final StripeFile createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new StripeFile(parcel.readString(), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readString(), parcel.readInt() == 0 ? null : StripeFilePurpose.valueOf(parcel.readString()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString(), parcel.readString());
        }

        public final StripeFile[] newArray(int i) {
            return new StripeFile[i];
        }
    }

    public StripeFile() {
        this((String) null, (Long) null, (String) null, (StripeFilePurpose) null, (Integer) null, (String) null, (String) null, (String) null, 255, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ StripeFile copy$default(StripeFile stripeFile, String str, Long l, String str2, StripeFilePurpose stripeFilePurpose, Integer num, String str3, String str4, String str5, int i, Object obj) {
        StripeFile stripeFile2 = stripeFile;
        int i2 = i;
        return stripeFile.copy((i2 & 1) != 0 ? stripeFile2.id : str, (i2 & 2) != 0 ? stripeFile2.created : l, (i2 & 4) != 0 ? stripeFile2.filename : str2, (i2 & 8) != 0 ? stripeFile2.purpose : stripeFilePurpose, (i2 & 16) != 0 ? stripeFile2.size : num, (i2 & 32) != 0 ? stripeFile2.title : str3, (i2 & 64) != 0 ? stripeFile2.type : str4, (i2 & 128) != 0 ? stripeFile2.url : str5);
    }

    public final String component1() {
        return this.id;
    }

    public final Long component2() {
        return this.created;
    }

    public final String component3() {
        return this.filename;
    }

    public final StripeFilePurpose component4() {
        return this.purpose;
    }

    public final Integer component5() {
        return this.size;
    }

    public final String component6() {
        return this.title;
    }

    public final String component7() {
        return this.type;
    }

    public final String component8() {
        return this.url;
    }

    public final StripeFile copy(String str, Long l, String str2, StripeFilePurpose stripeFilePurpose, Integer num, String str3, String str4, String str5) {
        return new StripeFile(str, l, str2, stripeFilePurpose, num, str3, str4, str5);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StripeFile)) {
            return false;
        }
        StripeFile stripeFile = (StripeFile) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) stripeFile.id) && Intrinsics.areEqual((Object) this.created, (Object) stripeFile.created) && Intrinsics.areEqual((Object) this.filename, (Object) stripeFile.filename) && this.purpose == stripeFile.purpose && Intrinsics.areEqual((Object) this.size, (Object) stripeFile.size) && Intrinsics.areEqual((Object) this.title, (Object) stripeFile.title) && Intrinsics.areEqual((Object) this.type, (Object) stripeFile.type) && Intrinsics.areEqual((Object) this.url, (Object) stripeFile.url);
    }

    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Long l = this.created;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        String str2 = this.filename;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        StripeFilePurpose stripeFilePurpose = this.purpose;
        int hashCode4 = (hashCode3 + (stripeFilePurpose == null ? 0 : stripeFilePurpose.hashCode())) * 31;
        Integer num = this.size;
        int hashCode5 = (hashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        String str3 = this.title;
        int hashCode6 = (hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.type;
        int hashCode7 = (hashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.url;
        if (str5 != null) {
            i = str5.hashCode();
        }
        return hashCode7 + i;
    }

    public String toString() {
        return "StripeFile(id=" + this.id + ", created=" + this.created + ", filename=" + this.filename + ", purpose=" + this.purpose + ", size=" + this.size + ", title=" + this.title + ", type=" + this.type + ", url=" + this.url + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.id);
        Long l = this.created;
        if (l == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
        }
        parcel.writeString(this.filename);
        StripeFilePurpose stripeFilePurpose = this.purpose;
        if (stripeFilePurpose == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(stripeFilePurpose.name());
        }
        Integer num = this.size;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        parcel.writeString(this.title);
        parcel.writeString(this.type);
        parcel.writeString(this.url);
    }

    public StripeFile(String str, Long l, String str2, StripeFilePurpose stripeFilePurpose, Integer num, String str3, String str4, String str5) {
        this.id = str;
        this.created = l;
        this.filename = str2;
        this.purpose = stripeFilePurpose;
        this.size = num;
        this.title = str3;
        this.type = str4;
        this.url = str5;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ StripeFile(java.lang.String r10, java.lang.Long r11, java.lang.String r12, com.stripe.android.core.model.StripeFilePurpose r13, java.lang.Integer r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r9 = this;
            r0 = r18
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r10
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r11
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0018
        L_0x0017:
            r4 = r12
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001e
            r5 = r2
            goto L_0x001f
        L_0x001e:
            r5 = r13
        L_0x001f:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0025
            r6 = r2
            goto L_0x0026
        L_0x0025:
            r6 = r14
        L_0x0026:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002c
            r7 = r2
            goto L_0x002d
        L_0x002c:
            r7 = r15
        L_0x002d:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0033
            r8 = r2
            goto L_0x0035
        L_0x0033:
            r8 = r16
        L_0x0035:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x003a
            goto L_0x003c
        L_0x003a:
            r2 = r17
        L_0x003c:
            r10 = r9
            r11 = r1
            r12 = r3
            r13 = r4
            r14 = r5
            r15 = r6
            r16 = r7
            r17 = r8
            r18 = r2
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.core.model.StripeFile.<init>(java.lang.String, java.lang.Long, java.lang.String, com.stripe.android.core.model.StripeFilePurpose, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getId() {
        return this.id;
    }

    public final Long getCreated() {
        return this.created;
    }

    public final String getFilename() {
        return this.filename;
    }

    public final StripeFilePurpose getPurpose() {
        return this.purpose;
    }

    public final Integer getSize() {
        return this.size;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.url;
    }
}
