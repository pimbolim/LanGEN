package com.stripe.android.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.common.util.UriUtil;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u001bB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000f\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u0010J\u000e\u0010\u0011\u001a\u00020\u0005HÀ\u0003¢\u0006\u0002\b\u0012J\u001d\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/stripe/android/core/model/StripeFileParams;", "", "file", "Ljava/io/File;", "purpose", "Lcom/stripe/android/core/model/StripeFilePurpose;", "(Ljava/io/File;Lcom/stripe/android/core/model/StripeFilePurpose;)V", "getFile$stripe_core_release", "()Ljava/io/File;", "fileLink", "Lcom/stripe/android/core/model/StripeFileParams$FileLink;", "getFileLink$stripe_core_release", "()Lcom/stripe/android/core/model/StripeFileParams$FileLink;", "getPurpose$stripe_core_release", "()Lcom/stripe/android/core/model/StripeFilePurpose;", "component1", "component1$stripe_core_release", "component2", "component2$stripe_core_release", "copy", "equals", "", "other", "hashCode", "", "toString", "", "FileLink", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StripeFileParams.kt */
public final class StripeFileParams {
    public static final int $stable = 8;
    private final File file;
    private final FileLink fileLink;
    private final StripeFilePurpose purpose;

    public static /* synthetic */ StripeFileParams copy$default(StripeFileParams stripeFileParams, File file2, StripeFilePurpose stripeFilePurpose, int i, Object obj) {
        if ((i & 1) != 0) {
            file2 = stripeFileParams.file;
        }
        if ((i & 2) != 0) {
            stripeFilePurpose = stripeFileParams.purpose;
        }
        return stripeFileParams.copy(file2, stripeFilePurpose);
    }

    public final File component1$stripe_core_release() {
        return this.file;
    }

    public final StripeFilePurpose component2$stripe_core_release() {
        return this.purpose;
    }

    public final StripeFileParams copy(File file2, StripeFilePurpose stripeFilePurpose) {
        Intrinsics.checkNotNullParameter(file2, UriUtil.LOCAL_FILE_SCHEME);
        Intrinsics.checkNotNullParameter(stripeFilePurpose, "purpose");
        return new StripeFileParams(file2, stripeFilePurpose);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StripeFileParams)) {
            return false;
        }
        StripeFileParams stripeFileParams = (StripeFileParams) obj;
        return Intrinsics.areEqual((Object) this.file, (Object) stripeFileParams.file) && this.purpose == stripeFileParams.purpose;
    }

    public int hashCode() {
        return (this.file.hashCode() * 31) + this.purpose.hashCode();
    }

    public String toString() {
        return "StripeFileParams(file=" + this.file + ", purpose=" + this.purpose + ')';
    }

    public StripeFileParams(File file2, StripeFilePurpose stripeFilePurpose) {
        Intrinsics.checkNotNullParameter(file2, UriUtil.LOCAL_FILE_SCHEME);
        Intrinsics.checkNotNullParameter(stripeFilePurpose, "purpose");
        this.file = file2;
        this.purpose = stripeFilePurpose;
    }

    public final File getFile$stripe_core_release() {
        return this.file;
    }

    public final StripeFilePurpose getPurpose$stripe_core_release() {
        return this.purpose;
    }

    public final FileLink getFileLink$stripe_core_release() {
        return this.fileLink;
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u000e\u0010\u0011\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÀ\u0003¢\u0006\u0004\b\u0014\u0010\rJ\u001c\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÀ\u0003¢\u0006\u0002\b\u0016J<\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0018J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0013\u0010\u001b\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001f\u001a\u00020\bHÖ\u0001J\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001aHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\"\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006%"}, d2 = {"Lcom/stripe/android/core/model/StripeFileParams$FileLink;", "Landroid/os/Parcelable;", "create", "", "expiresAt", "", "metadata", "", "", "(ZLjava/lang/Long;Ljava/util/Map;)V", "getCreate$stripe_core_release", "()Z", "getExpiresAt$stripe_core_release", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMetadata$stripe_core_release", "()Ljava/util/Map;", "component1", "component1$stripe_core_release", "component2", "component2$stripe_core_release", "component3", "component3$stripe_core_release", "copy", "(ZLjava/lang/Long;Ljava/util/Map;)Lcom/stripe/android/core/model/StripeFileParams$FileLink;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StripeFileParams.kt */
    public static final class FileLink implements Parcelable {
        public static final int $stable = 8;
        public static final Parcelable.Creator<FileLink> CREATOR = new Creator();
        private final boolean create;
        private final Long expiresAt;
        private final Map<String, String> metadata;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: StripeFileParams.kt */
        public static final class Creator implements Parcelable.Creator<FileLink> {
            public final FileLink createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                boolean z = parcel.readInt() != 0;
                LinkedHashMap linkedHashMap = null;
                Long valueOf = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
                if (parcel.readInt() != 0) {
                    int readInt = parcel.readInt();
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap(readInt);
                    for (int i = 0; i != readInt; i++) {
                        linkedHashMap2.put(parcel.readString(), parcel.readString());
                    }
                    linkedHashMap = linkedHashMap2;
                }
                return new FileLink(z, valueOf, linkedHashMap);
            }

            public final FileLink[] newArray(int i) {
                return new FileLink[i];
            }
        }

        public FileLink() {
            this(false, (Long) null, (Map) null, 7, (DefaultConstructorMarker) null);
        }

        public FileLink(boolean z) {
            this(z, (Long) null, (Map) null, 6, (DefaultConstructorMarker) null);
        }

        public FileLink(boolean z, Long l) {
            this(z, l, (Map) null, 4, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ FileLink copy$default(FileLink fileLink, boolean z, Long l, Map<String, String> map, int i, Object obj) {
            if ((i & 1) != 0) {
                z = fileLink.create;
            }
            if ((i & 2) != 0) {
                l = fileLink.expiresAt;
            }
            if ((i & 4) != 0) {
                map = fileLink.metadata;
            }
            return fileLink.copy(z, l, map);
        }

        public final boolean component1$stripe_core_release() {
            return this.create;
        }

        public final Long component2$stripe_core_release() {
            return this.expiresAt;
        }

        public final Map<String, String> component3$stripe_core_release() {
            return this.metadata;
        }

        public final FileLink copy(boolean z, Long l, Map<String, String> map) {
            return new FileLink(z, l, map);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FileLink)) {
                return false;
            }
            FileLink fileLink = (FileLink) obj;
            return this.create == fileLink.create && Intrinsics.areEqual((Object) this.expiresAt, (Object) fileLink.expiresAt) && Intrinsics.areEqual((Object) this.metadata, (Object) fileLink.metadata);
        }

        public int hashCode() {
            boolean z = this.create;
            if (z) {
                z = true;
            }
            int i = (z ? 1 : 0) * true;
            Long l = this.expiresAt;
            int i2 = 0;
            int hashCode = (i + (l == null ? 0 : l.hashCode())) * 31;
            Map<String, String> map = this.metadata;
            if (map != null) {
                i2 = map.hashCode();
            }
            return hashCode + i2;
        }

        public String toString() {
            return "FileLink(create=" + this.create + ", expiresAt=" + this.expiresAt + ", metadata=" + this.metadata + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(this.create ? 1 : 0);
            Long l = this.expiresAt;
            if (l == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeLong(l.longValue());
            }
            Map<String, String> map = this.metadata;
            if (map == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            parcel.writeInt(map.size());
            for (Map.Entry next : map.entrySet()) {
                parcel.writeString((String) next.getKey());
                parcel.writeString((String) next.getValue());
            }
        }

        public FileLink(boolean z, Long l, Map<String, String> map) {
            this.create = z;
            this.expiresAt = l;
            this.metadata = map;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ FileLink(boolean z, Long l, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : map);
        }

        public final boolean getCreate$stripe_core_release() {
            return this.create;
        }

        public final Long getExpiresAt$stripe_core_release() {
            return this.expiresAt;
        }

        public final Map<String, String> getMetadata$stripe_core_release() {
            return this.metadata;
        }
    }
}
