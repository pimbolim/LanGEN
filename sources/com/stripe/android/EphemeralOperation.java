package com.stripe.android;

import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.model.PaymentMethod;
import com.stripe.android.model.ShippingInformation;
import com.stripe.android.payments.core.injection.NamedConstantsKt;
import com.stripe.android.stripe3ds2.transactions.MessageExtension;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0003\u000b\f\rB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X \u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\bX \u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0001\u0003\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/stripe/android/EphemeralOperation;", "Landroid/os/Parcelable;", "()V", "id", "", "getId$payments_core_release", "()Ljava/lang/String;", "productUsage", "", "getProductUsage$payments_core_release", "()Ljava/util/Set;", "Customer", "Issuing", "RetrieveKey", "Lcom/stripe/android/EphemeralOperation$RetrieveKey;", "Lcom/stripe/android/EphemeralOperation$Customer;", "Lcom/stripe/android/EphemeralOperation$Issuing;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EphemeralOperation.kt */
public abstract class EphemeralOperation implements Parcelable {
    public /* synthetic */ EphemeralOperation(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract String getId$payments_core_release();

    public abstract Set<String> getProductUsage$payments_core_release();

    private EphemeralOperation() {
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000b\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\fJ\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÀ\u0003¢\u0006\u0002\b\u000eJ#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0011HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001d"}, d2 = {"Lcom/stripe/android/EphemeralOperation$RetrieveKey;", "Lcom/stripe/android/EphemeralOperation;", "id", "", "productUsage", "", "(Ljava/lang/String;Ljava/util/Set;)V", "getId$payments_core_release", "()Ljava/lang/String;", "getProductUsage$payments_core_release", "()Ljava/util/Set;", "component1", "component1$payments_core_release", "component2", "component2$payments_core_release", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: EphemeralOperation.kt */
    public static final class RetrieveKey extends EphemeralOperation {
        public static final Parcelable.Creator<RetrieveKey> CREATOR = new Creator();
        private final String id;
        private final Set<String> productUsage;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: EphemeralOperation.kt */
        public static final class Creator implements Parcelable.Creator<RetrieveKey> {
            public final RetrieveKey createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                String readString = parcel.readString();
                int readInt = parcel.readInt();
                LinkedHashSet linkedHashSet = new LinkedHashSet(readInt);
                for (int i = 0; i != readInt; i++) {
                    linkedHashSet.add(parcel.readString());
                }
                return new RetrieveKey(readString, linkedHashSet);
            }

            public final RetrieveKey[] newArray(int i) {
                return new RetrieveKey[i];
            }
        }

        public static /* synthetic */ RetrieveKey copy$default(RetrieveKey retrieveKey, String str, Set<String> set, int i, Object obj) {
            if ((i & 1) != 0) {
                str = retrieveKey.getId$payments_core_release();
            }
            if ((i & 2) != 0) {
                set = retrieveKey.getProductUsage$payments_core_release();
            }
            return retrieveKey.copy(str, set);
        }

        public final String component1$payments_core_release() {
            return getId$payments_core_release();
        }

        public final Set<String> component2$payments_core_release() {
            return getProductUsage$payments_core_release();
        }

        public final RetrieveKey copy(String str, Set<String> set) {
            Intrinsics.checkNotNullParameter(str, MessageExtension.FIELD_ID);
            Intrinsics.checkNotNullParameter(set, NamedConstantsKt.PRODUCT_USAGE);
            return new RetrieveKey(str, set);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RetrieveKey)) {
                return false;
            }
            RetrieveKey retrieveKey = (RetrieveKey) obj;
            return Intrinsics.areEqual((Object) getId$payments_core_release(), (Object) retrieveKey.getId$payments_core_release()) && Intrinsics.areEqual((Object) getProductUsage$payments_core_release(), (Object) retrieveKey.getProductUsage$payments_core_release());
        }

        public int hashCode() {
            return (getId$payments_core_release().hashCode() * 31) + getProductUsage$payments_core_release().hashCode();
        }

        public String toString() {
            return "RetrieveKey(id=" + getId$payments_core_release() + ", productUsage=" + getProductUsage$payments_core_release() + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.id);
            Set<String> set = this.productUsage;
            parcel.writeInt(set.size());
            for (String writeString : set) {
                parcel.writeString(writeString);
            }
        }

        public String getId$payments_core_release() {
            return this.id;
        }

        public Set<String> getProductUsage$payments_core_release() {
            return this.productUsage;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public RetrieveKey(String str, Set<String> set) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, MessageExtension.FIELD_ID);
            Intrinsics.checkNotNullParameter(set, NamedConstantsKt.PRODUCT_USAGE);
            this.id = str;
            this.productUsage = set;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0007\u0003\u0004\u0005\u0006\u0007\b\tB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0007\n\u000b\f\r\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/stripe/android/EphemeralOperation$Customer;", "Lcom/stripe/android/EphemeralOperation;", "()V", "AddSource", "AttachPaymentMethod", "DeleteSource", "DetachPaymentMethod", "GetPaymentMethods", "UpdateDefaultSource", "UpdateShipping", "Lcom/stripe/android/EphemeralOperation$Customer$AddSource;", "Lcom/stripe/android/EphemeralOperation$Customer$DeleteSource;", "Lcom/stripe/android/EphemeralOperation$Customer$AttachPaymentMethod;", "Lcom/stripe/android/EphemeralOperation$Customer$DetachPaymentMethod;", "Lcom/stripe/android/EphemeralOperation$Customer$GetPaymentMethods;", "Lcom/stripe/android/EphemeralOperation$Customer$UpdateShipping;", "Lcom/stripe/android/EphemeralOperation$Customer$UpdateDefaultSource;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: EphemeralOperation.kt */
    public static abstract class Customer extends EphemeralOperation {
        public /* synthetic */ Customer(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Customer() {
            super((DefaultConstructorMarker) null);
        }

        @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000e\u0010\u0011\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u0012J\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÀ\u0003¢\u0006\u0002\b\u0014J7\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0017HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0017HÖ\u0001R\u0014\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006#"}, d2 = {"Lcom/stripe/android/EphemeralOperation$Customer$AddSource;", "Lcom/stripe/android/EphemeralOperation$Customer;", "sourceId", "", "sourceType", "id", "productUsage", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;)V", "getId$payments_core_release", "()Ljava/lang/String;", "getProductUsage$payments_core_release", "()Ljava/util/Set;", "getSourceId", "getSourceType", "component1", "component2", "component3", "component3$payments_core_release", "component4", "component4$payments_core_release", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: EphemeralOperation.kt */
        public static final class AddSource extends Customer {
            public static final int $stable = 8;
            public static final Parcelable.Creator<AddSource> CREATOR = new Creator();
            private final String id;
            private final Set<String> productUsage;
            private final String sourceId;
            private final String sourceType;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* compiled from: EphemeralOperation.kt */
            public static final class Creator implements Parcelable.Creator<AddSource> {
                public final AddSource createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    String readString = parcel.readString();
                    String readString2 = parcel.readString();
                    String readString3 = parcel.readString();
                    int readInt = parcel.readInt();
                    LinkedHashSet linkedHashSet = new LinkedHashSet(readInt);
                    for (int i = 0; i != readInt; i++) {
                        linkedHashSet.add(parcel.readString());
                    }
                    return new AddSource(readString, readString2, readString3, linkedHashSet);
                }

                public final AddSource[] newArray(int i) {
                    return new AddSource[i];
                }
            }

            public static /* synthetic */ AddSource copy$default(AddSource addSource, String str, String str2, String str3, Set<String> set, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = addSource.sourceId;
                }
                if ((i & 2) != 0) {
                    str2 = addSource.sourceType;
                }
                if ((i & 4) != 0) {
                    str3 = addSource.getId$payments_core_release();
                }
                if ((i & 8) != 0) {
                    set = addSource.getProductUsage$payments_core_release();
                }
                return addSource.copy(str, str2, str3, set);
            }

            public final String component1() {
                return this.sourceId;
            }

            public final String component2() {
                return this.sourceType;
            }

            public final String component3$payments_core_release() {
                return getId$payments_core_release();
            }

            public final Set<String> component4$payments_core_release() {
                return getProductUsage$payments_core_release();
            }

            public final AddSource copy(String str, String str2, String str3, Set<String> set) {
                Intrinsics.checkNotNullParameter(str, "sourceId");
                Intrinsics.checkNotNullParameter(str2, "sourceType");
                Intrinsics.checkNotNullParameter(str3, MessageExtension.FIELD_ID);
                Intrinsics.checkNotNullParameter(set, NamedConstantsKt.PRODUCT_USAGE);
                return new AddSource(str, str2, str3, set);
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof AddSource)) {
                    return false;
                }
                AddSource addSource = (AddSource) obj;
                return Intrinsics.areEqual((Object) this.sourceId, (Object) addSource.sourceId) && Intrinsics.areEqual((Object) this.sourceType, (Object) addSource.sourceType) && Intrinsics.areEqual((Object) getId$payments_core_release(), (Object) addSource.getId$payments_core_release()) && Intrinsics.areEqual((Object) getProductUsage$payments_core_release(), (Object) addSource.getProductUsage$payments_core_release());
            }

            public int hashCode() {
                return (((((this.sourceId.hashCode() * 31) + this.sourceType.hashCode()) * 31) + getId$payments_core_release().hashCode()) * 31) + getProductUsage$payments_core_release().hashCode();
            }

            public String toString() {
                return "AddSource(sourceId=" + this.sourceId + ", sourceType=" + this.sourceType + ", id=" + getId$payments_core_release() + ", productUsage=" + getProductUsage$payments_core_release() + ')';
            }

            public void writeToParcel(Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeString(this.sourceId);
                parcel.writeString(this.sourceType);
                parcel.writeString(this.id);
                Set<String> set = this.productUsage;
                parcel.writeInt(set.size());
                for (String writeString : set) {
                    parcel.writeString(writeString);
                }
            }

            public final String getSourceId() {
                return this.sourceId;
            }

            public final String getSourceType() {
                return this.sourceType;
            }

            public String getId$payments_core_release() {
                return this.id;
            }

            public Set<String> getProductUsage$payments_core_release() {
                return this.productUsage;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public AddSource(String str, String str2, String str3, Set<String> set) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "sourceId");
                Intrinsics.checkNotNullParameter(str2, "sourceType");
                Intrinsics.checkNotNullParameter(str3, MessageExtension.FIELD_ID);
                Intrinsics.checkNotNullParameter(set, NamedConstantsKt.PRODUCT_USAGE);
                this.sourceId = str;
                this.sourceType = str2;
                this.id = str3;
                this.productUsage = set;
            }
        }

        @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000e\u0010\u000e\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u000fJ\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÀ\u0003¢\u0006\u0002\b\u0011J-\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0014HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0014HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006 "}, d2 = {"Lcom/stripe/android/EphemeralOperation$Customer$DeleteSource;", "Lcom/stripe/android/EphemeralOperation$Customer;", "sourceId", "", "id", "productUsage", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;)V", "getId$payments_core_release", "()Ljava/lang/String;", "getProductUsage$payments_core_release", "()Ljava/util/Set;", "getSourceId", "component1", "component2", "component2$payments_core_release", "component3", "component3$payments_core_release", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: EphemeralOperation.kt */
        public static final class DeleteSource extends Customer {
            public static final int $stable = 8;
            public static final Parcelable.Creator<DeleteSource> CREATOR = new Creator();
            private final String id;
            private final Set<String> productUsage;
            private final String sourceId;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* compiled from: EphemeralOperation.kt */
            public static final class Creator implements Parcelable.Creator<DeleteSource> {
                public final DeleteSource createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    String readString = parcel.readString();
                    String readString2 = parcel.readString();
                    int readInt = parcel.readInt();
                    LinkedHashSet linkedHashSet = new LinkedHashSet(readInt);
                    for (int i = 0; i != readInt; i++) {
                        linkedHashSet.add(parcel.readString());
                    }
                    return new DeleteSource(readString, readString2, linkedHashSet);
                }

                public final DeleteSource[] newArray(int i) {
                    return new DeleteSource[i];
                }
            }

            public static /* synthetic */ DeleteSource copy$default(DeleteSource deleteSource, String str, String str2, Set<String> set, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = deleteSource.sourceId;
                }
                if ((i & 2) != 0) {
                    str2 = deleteSource.getId$payments_core_release();
                }
                if ((i & 4) != 0) {
                    set = deleteSource.getProductUsage$payments_core_release();
                }
                return deleteSource.copy(str, str2, set);
            }

            public final String component1() {
                return this.sourceId;
            }

            public final String component2$payments_core_release() {
                return getId$payments_core_release();
            }

            public final Set<String> component3$payments_core_release() {
                return getProductUsage$payments_core_release();
            }

            public final DeleteSource copy(String str, String str2, Set<String> set) {
                Intrinsics.checkNotNullParameter(str, "sourceId");
                Intrinsics.checkNotNullParameter(str2, MessageExtension.FIELD_ID);
                Intrinsics.checkNotNullParameter(set, NamedConstantsKt.PRODUCT_USAGE);
                return new DeleteSource(str, str2, set);
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof DeleteSource)) {
                    return false;
                }
                DeleteSource deleteSource = (DeleteSource) obj;
                return Intrinsics.areEqual((Object) this.sourceId, (Object) deleteSource.sourceId) && Intrinsics.areEqual((Object) getId$payments_core_release(), (Object) deleteSource.getId$payments_core_release()) && Intrinsics.areEqual((Object) getProductUsage$payments_core_release(), (Object) deleteSource.getProductUsage$payments_core_release());
            }

            public int hashCode() {
                return (((this.sourceId.hashCode() * 31) + getId$payments_core_release().hashCode()) * 31) + getProductUsage$payments_core_release().hashCode();
            }

            public String toString() {
                return "DeleteSource(sourceId=" + this.sourceId + ", id=" + getId$payments_core_release() + ", productUsage=" + getProductUsage$payments_core_release() + ')';
            }

            public void writeToParcel(Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeString(this.sourceId);
                parcel.writeString(this.id);
                Set<String> set = this.productUsage;
                parcel.writeInt(set.size());
                for (String writeString : set) {
                    parcel.writeString(writeString);
                }
            }

            public final String getSourceId() {
                return this.sourceId;
            }

            public String getId$payments_core_release() {
                return this.id;
            }

            public Set<String> getProductUsage$payments_core_release() {
                return this.productUsage;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public DeleteSource(String str, String str2, Set<String> set) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "sourceId");
                Intrinsics.checkNotNullParameter(str2, MessageExtension.FIELD_ID);
                Intrinsics.checkNotNullParameter(set, NamedConstantsKt.PRODUCT_USAGE);
                this.sourceId = str;
                this.id = str2;
                this.productUsage = set;
            }
        }

        @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000e\u0010\u000e\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u000fJ\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÀ\u0003¢\u0006\u0002\b\u0011J-\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0014HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0014HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006 "}, d2 = {"Lcom/stripe/android/EphemeralOperation$Customer$AttachPaymentMethod;", "Lcom/stripe/android/EphemeralOperation$Customer;", "paymentMethodId", "", "id", "productUsage", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;)V", "getId$payments_core_release", "()Ljava/lang/String;", "getPaymentMethodId", "getProductUsage$payments_core_release", "()Ljava/util/Set;", "component1", "component2", "component2$payments_core_release", "component3", "component3$payments_core_release", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: EphemeralOperation.kt */
        public static final class AttachPaymentMethod extends Customer {
            public static final int $stable = 8;
            public static final Parcelable.Creator<AttachPaymentMethod> CREATOR = new Creator();
            private final String id;
            private final String paymentMethodId;
            private final Set<String> productUsage;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* compiled from: EphemeralOperation.kt */
            public static final class Creator implements Parcelable.Creator<AttachPaymentMethod> {
                public final AttachPaymentMethod createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    String readString = parcel.readString();
                    String readString2 = parcel.readString();
                    int readInt = parcel.readInt();
                    LinkedHashSet linkedHashSet = new LinkedHashSet(readInt);
                    for (int i = 0; i != readInt; i++) {
                        linkedHashSet.add(parcel.readString());
                    }
                    return new AttachPaymentMethod(readString, readString2, linkedHashSet);
                }

                public final AttachPaymentMethod[] newArray(int i) {
                    return new AttachPaymentMethod[i];
                }
            }

            public static /* synthetic */ AttachPaymentMethod copy$default(AttachPaymentMethod attachPaymentMethod, String str, String str2, Set<String> set, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = attachPaymentMethod.paymentMethodId;
                }
                if ((i & 2) != 0) {
                    str2 = attachPaymentMethod.getId$payments_core_release();
                }
                if ((i & 4) != 0) {
                    set = attachPaymentMethod.getProductUsage$payments_core_release();
                }
                return attachPaymentMethod.copy(str, str2, set);
            }

            public final String component1() {
                return this.paymentMethodId;
            }

            public final String component2$payments_core_release() {
                return getId$payments_core_release();
            }

            public final Set<String> component3$payments_core_release() {
                return getProductUsage$payments_core_release();
            }

            public final AttachPaymentMethod copy(String str, String str2, Set<String> set) {
                Intrinsics.checkNotNullParameter(str, "paymentMethodId");
                Intrinsics.checkNotNullParameter(str2, MessageExtension.FIELD_ID);
                Intrinsics.checkNotNullParameter(set, NamedConstantsKt.PRODUCT_USAGE);
                return new AttachPaymentMethod(str, str2, set);
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof AttachPaymentMethod)) {
                    return false;
                }
                AttachPaymentMethod attachPaymentMethod = (AttachPaymentMethod) obj;
                return Intrinsics.areEqual((Object) this.paymentMethodId, (Object) attachPaymentMethod.paymentMethodId) && Intrinsics.areEqual((Object) getId$payments_core_release(), (Object) attachPaymentMethod.getId$payments_core_release()) && Intrinsics.areEqual((Object) getProductUsage$payments_core_release(), (Object) attachPaymentMethod.getProductUsage$payments_core_release());
            }

            public int hashCode() {
                return (((this.paymentMethodId.hashCode() * 31) + getId$payments_core_release().hashCode()) * 31) + getProductUsage$payments_core_release().hashCode();
            }

            public String toString() {
                return "AttachPaymentMethod(paymentMethodId=" + this.paymentMethodId + ", id=" + getId$payments_core_release() + ", productUsage=" + getProductUsage$payments_core_release() + ')';
            }

            public void writeToParcel(Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeString(this.paymentMethodId);
                parcel.writeString(this.id);
                Set<String> set = this.productUsage;
                parcel.writeInt(set.size());
                for (String writeString : set) {
                    parcel.writeString(writeString);
                }
            }

            public final String getPaymentMethodId() {
                return this.paymentMethodId;
            }

            public String getId$payments_core_release() {
                return this.id;
            }

            public Set<String> getProductUsage$payments_core_release() {
                return this.productUsage;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public AttachPaymentMethod(String str, String str2, Set<String> set) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "paymentMethodId");
                Intrinsics.checkNotNullParameter(str2, MessageExtension.FIELD_ID);
                Intrinsics.checkNotNullParameter(set, NamedConstantsKt.PRODUCT_USAGE);
                this.paymentMethodId = str;
                this.id = str2;
                this.productUsage = set;
            }
        }

        @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000e\u0010\u000e\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u000fJ\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÀ\u0003¢\u0006\u0002\b\u0011J-\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0014HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0014HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006 "}, d2 = {"Lcom/stripe/android/EphemeralOperation$Customer$DetachPaymentMethod;", "Lcom/stripe/android/EphemeralOperation$Customer;", "paymentMethodId", "", "id", "productUsage", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;)V", "getId$payments_core_release", "()Ljava/lang/String;", "getPaymentMethodId", "getProductUsage$payments_core_release", "()Ljava/util/Set;", "component1", "component2", "component2$payments_core_release", "component3", "component3$payments_core_release", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: EphemeralOperation.kt */
        public static final class DetachPaymentMethod extends Customer {
            public static final int $stable = 8;
            public static final Parcelable.Creator<DetachPaymentMethod> CREATOR = new Creator();
            private final String id;
            private final String paymentMethodId;
            private final Set<String> productUsage;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* compiled from: EphemeralOperation.kt */
            public static final class Creator implements Parcelable.Creator<DetachPaymentMethod> {
                public final DetachPaymentMethod createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    String readString = parcel.readString();
                    String readString2 = parcel.readString();
                    int readInt = parcel.readInt();
                    LinkedHashSet linkedHashSet = new LinkedHashSet(readInt);
                    for (int i = 0; i != readInt; i++) {
                        linkedHashSet.add(parcel.readString());
                    }
                    return new DetachPaymentMethod(readString, readString2, linkedHashSet);
                }

                public final DetachPaymentMethod[] newArray(int i) {
                    return new DetachPaymentMethod[i];
                }
            }

            public static /* synthetic */ DetachPaymentMethod copy$default(DetachPaymentMethod detachPaymentMethod, String str, String str2, Set<String> set, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = detachPaymentMethod.paymentMethodId;
                }
                if ((i & 2) != 0) {
                    str2 = detachPaymentMethod.getId$payments_core_release();
                }
                if ((i & 4) != 0) {
                    set = detachPaymentMethod.getProductUsage$payments_core_release();
                }
                return detachPaymentMethod.copy(str, str2, set);
            }

            public final String component1() {
                return this.paymentMethodId;
            }

            public final String component2$payments_core_release() {
                return getId$payments_core_release();
            }

            public final Set<String> component3$payments_core_release() {
                return getProductUsage$payments_core_release();
            }

            public final DetachPaymentMethod copy(String str, String str2, Set<String> set) {
                Intrinsics.checkNotNullParameter(str, "paymentMethodId");
                Intrinsics.checkNotNullParameter(str2, MessageExtension.FIELD_ID);
                Intrinsics.checkNotNullParameter(set, NamedConstantsKt.PRODUCT_USAGE);
                return new DetachPaymentMethod(str, str2, set);
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof DetachPaymentMethod)) {
                    return false;
                }
                DetachPaymentMethod detachPaymentMethod = (DetachPaymentMethod) obj;
                return Intrinsics.areEqual((Object) this.paymentMethodId, (Object) detachPaymentMethod.paymentMethodId) && Intrinsics.areEqual((Object) getId$payments_core_release(), (Object) detachPaymentMethod.getId$payments_core_release()) && Intrinsics.areEqual((Object) getProductUsage$payments_core_release(), (Object) detachPaymentMethod.getProductUsage$payments_core_release());
            }

            public int hashCode() {
                return (((this.paymentMethodId.hashCode() * 31) + getId$payments_core_release().hashCode()) * 31) + getProductUsage$payments_core_release().hashCode();
            }

            public String toString() {
                return "DetachPaymentMethod(paymentMethodId=" + this.paymentMethodId + ", id=" + getId$payments_core_release() + ", productUsage=" + getProductUsage$payments_core_release() + ')';
            }

            public void writeToParcel(Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeString(this.paymentMethodId);
                parcel.writeString(this.id);
                Set<String> set = this.productUsage;
                parcel.writeInt(set.size());
                for (String writeString : set) {
                    parcel.writeString(writeString);
                }
            }

            public final String getPaymentMethodId() {
                return this.paymentMethodId;
            }

            public String getId$payments_core_release() {
                return this.id;
            }

            public Set<String> getProductUsage$payments_core_release() {
                return this.productUsage;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public DetachPaymentMethod(String str, String str2, Set<String> set) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "paymentMethodId");
                Intrinsics.checkNotNullParameter(str2, MessageExtension.FIELD_ID);
                Intrinsics.checkNotNullParameter(set, NamedConstantsKt.PRODUCT_USAGE);
                this.paymentMethodId = str;
                this.id = str2;
                this.productUsage = set;
            }
        }

        @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\u0010\fJ\u000e\u0010\u0018\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u0019J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÀ\u0003¢\u0006\u0004\b\u001b\u0010\u0011J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÀ\u0003¢\u0006\u0002\b\u001dJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÀ\u0003¢\u0006\u0002\b\u001fJ\u000e\u0010 \u001a\u00020\u0007HÀ\u0003¢\u0006\u0002\b!J\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bHÀ\u0003¢\u0006\u0002\b#JV\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bHÆ\u0001¢\u0006\u0002\u0010%J\t\u0010&\u001a\u00020\u0005HÖ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020\u0005HÖ\u0001J\t\u0010,\u001a\u00020\u0007HÖ\u0001J\u0019\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\t\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u00062"}, d2 = {"Lcom/stripe/android/EphemeralOperation$Customer$GetPaymentMethods;", "Lcom/stripe/android/EphemeralOperation$Customer;", "type", "Lcom/stripe/android/model/PaymentMethod$Type;", "limit", "", "endingBefore", "", "startingAfter", "id", "productUsage", "", "(Lcom/stripe/android/model/PaymentMethod$Type;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;)V", "getEndingBefore$payments_core_release", "()Ljava/lang/String;", "getId$payments_core_release", "getLimit$payments_core_release", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getProductUsage$payments_core_release", "()Ljava/util/Set;", "getStartingAfter$payments_core_release", "getType$payments_core_release", "()Lcom/stripe/android/model/PaymentMethod$Type;", "component1", "component1$payments_core_release", "component2", "component2$payments_core_release", "component3", "component3$payments_core_release", "component4", "component4$payments_core_release", "component5", "component5$payments_core_release", "component6", "component6$payments_core_release", "copy", "(Lcom/stripe/android/model/PaymentMethod$Type;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;)Lcom/stripe/android/EphemeralOperation$Customer$GetPaymentMethods;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: EphemeralOperation.kt */
        public static final class GetPaymentMethods extends Customer {
            public static final int $stable = 8;
            public static final Parcelable.Creator<GetPaymentMethods> CREATOR = new Creator();
            private final String endingBefore;
            private final String id;
            private final Integer limit;
            private final Set<String> productUsage;
            private final String startingAfter;
            private final PaymentMethod.Type type;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* compiled from: EphemeralOperation.kt */
            public static final class Creator implements Parcelable.Creator<GetPaymentMethods> {
                public final GetPaymentMethods createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    PaymentMethod.Type createFromParcel = PaymentMethod.Type.CREATOR.createFromParcel(parcel);
                    Integer valueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
                    String readString = parcel.readString();
                    String readString2 = parcel.readString();
                    String readString3 = parcel.readString();
                    int readInt = parcel.readInt();
                    LinkedHashSet linkedHashSet = new LinkedHashSet(readInt);
                    for (int i = 0; i != readInt; i++) {
                        linkedHashSet.add(parcel.readString());
                    }
                    return new GetPaymentMethods(createFromParcel, valueOf, readString, readString2, readString3, linkedHashSet);
                }

                public final GetPaymentMethods[] newArray(int i) {
                    return new GetPaymentMethods[i];
                }
            }

            public static /* synthetic */ GetPaymentMethods copy$default(GetPaymentMethods getPaymentMethods, PaymentMethod.Type type2, Integer num, String str, String str2, String str3, Set<String> set, int i, Object obj) {
                if ((i & 1) != 0) {
                    type2 = getPaymentMethods.type;
                }
                if ((i & 2) != 0) {
                    num = getPaymentMethods.limit;
                }
                Integer num2 = num;
                if ((i & 4) != 0) {
                    str = getPaymentMethods.endingBefore;
                }
                String str4 = str;
                if ((i & 8) != 0) {
                    str2 = getPaymentMethods.startingAfter;
                }
                String str5 = str2;
                if ((i & 16) != 0) {
                    str3 = getPaymentMethods.getId$payments_core_release();
                }
                String str6 = str3;
                if ((i & 32) != 0) {
                    set = getPaymentMethods.getProductUsage$payments_core_release();
                }
                return getPaymentMethods.copy(type2, num2, str4, str5, str6, set);
            }

            public final PaymentMethod.Type component1$payments_core_release() {
                return this.type;
            }

            public final Integer component2$payments_core_release() {
                return this.limit;
            }

            public final String component3$payments_core_release() {
                return this.endingBefore;
            }

            public final String component4$payments_core_release() {
                return this.startingAfter;
            }

            public final String component5$payments_core_release() {
                return getId$payments_core_release();
            }

            public final Set<String> component6$payments_core_release() {
                return getProductUsage$payments_core_release();
            }

            public final GetPaymentMethods copy(PaymentMethod.Type type2, Integer num, String str, String str2, String str3, Set<String> set) {
                Intrinsics.checkNotNullParameter(type2, "type");
                Intrinsics.checkNotNullParameter(str3, MessageExtension.FIELD_ID);
                Intrinsics.checkNotNullParameter(set, NamedConstantsKt.PRODUCT_USAGE);
                return new GetPaymentMethods(type2, num, str, str2, str3, set);
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof GetPaymentMethods)) {
                    return false;
                }
                GetPaymentMethods getPaymentMethods = (GetPaymentMethods) obj;
                return this.type == getPaymentMethods.type && Intrinsics.areEqual((Object) this.limit, (Object) getPaymentMethods.limit) && Intrinsics.areEqual((Object) this.endingBefore, (Object) getPaymentMethods.endingBefore) && Intrinsics.areEqual((Object) this.startingAfter, (Object) getPaymentMethods.startingAfter) && Intrinsics.areEqual((Object) getId$payments_core_release(), (Object) getPaymentMethods.getId$payments_core_release()) && Intrinsics.areEqual((Object) getProductUsage$payments_core_release(), (Object) getPaymentMethods.getProductUsage$payments_core_release());
            }

            public int hashCode() {
                int hashCode = this.type.hashCode() * 31;
                Integer num = this.limit;
                int i = 0;
                int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
                String str = this.endingBefore;
                int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
                String str2 = this.startingAfter;
                if (str2 != null) {
                    i = str2.hashCode();
                }
                return ((((hashCode3 + i) * 31) + getId$payments_core_release().hashCode()) * 31) + getProductUsage$payments_core_release().hashCode();
            }

            public String toString() {
                return "GetPaymentMethods(type=" + this.type + ", limit=" + this.limit + ", endingBefore=" + this.endingBefore + ", startingAfter=" + this.startingAfter + ", id=" + getId$payments_core_release() + ", productUsage=" + getProductUsage$payments_core_release() + ')';
            }

            public void writeToParcel(Parcel parcel, int i) {
                int i2;
                Intrinsics.checkNotNullParameter(parcel, "out");
                this.type.writeToParcel(parcel, i);
                Integer num = this.limit;
                if (num == null) {
                    i2 = 0;
                } else {
                    parcel.writeInt(1);
                    i2 = num.intValue();
                }
                parcel.writeInt(i2);
                parcel.writeString(this.endingBefore);
                parcel.writeString(this.startingAfter);
                parcel.writeString(this.id);
                Set<String> set = this.productUsage;
                parcel.writeInt(set.size());
                for (String writeString : set) {
                    parcel.writeString(writeString);
                }
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ GetPaymentMethods(PaymentMethod.Type type2, Integer num, String str, String str2, String str3, Set set, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(type2, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2, str3, set);
            }

            public final PaymentMethod.Type getType$payments_core_release() {
                return this.type;
            }

            public final Integer getLimit$payments_core_release() {
                return this.limit;
            }

            public final String getEndingBefore$payments_core_release() {
                return this.endingBefore;
            }

            public final String getStartingAfter$payments_core_release() {
                return this.startingAfter;
            }

            public String getId$payments_core_release() {
                return this.id;
            }

            public Set<String> getProductUsage$payments_core_release() {
                return this.productUsage;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public GetPaymentMethods(PaymentMethod.Type type2, Integer num, String str, String str2, String str3, Set<String> set) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(type2, "type");
                Intrinsics.checkNotNullParameter(str3, MessageExtension.FIELD_ID);
                Intrinsics.checkNotNullParameter(set, NamedConstantsKt.PRODUCT_USAGE);
                this.type = type2;
                this.limit = num;
                this.endingBefore = str;
                this.startingAfter = str2;
                this.id = str3;
                this.productUsage = set;
            }
        }

        @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000e\u0010\u0010\u001a\u00020\u0005HÀ\u0003¢\u0006\u0002\b\u0011J\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007HÀ\u0003¢\u0006\u0002\b\u0013J-\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0016HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0016HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\""}, d2 = {"Lcom/stripe/android/EphemeralOperation$Customer$UpdateShipping;", "Lcom/stripe/android/EphemeralOperation$Customer;", "shippingInformation", "Lcom/stripe/android/model/ShippingInformation;", "id", "", "productUsage", "", "(Lcom/stripe/android/model/ShippingInformation;Ljava/lang/String;Ljava/util/Set;)V", "getId$payments_core_release", "()Ljava/lang/String;", "getProductUsage$payments_core_release", "()Ljava/util/Set;", "getShippingInformation", "()Lcom/stripe/android/model/ShippingInformation;", "component1", "component2", "component2$payments_core_release", "component3", "component3$payments_core_release", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: EphemeralOperation.kt */
        public static final class UpdateShipping extends Customer {
            public static final int $stable = 8;
            public static final Parcelable.Creator<UpdateShipping> CREATOR = new Creator();
            private final String id;
            private final Set<String> productUsage;
            private final ShippingInformation shippingInformation;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* compiled from: EphemeralOperation.kt */
            public static final class Creator implements Parcelable.Creator<UpdateShipping> {
                public final UpdateShipping createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    ShippingInformation createFromParcel = ShippingInformation.CREATOR.createFromParcel(parcel);
                    String readString = parcel.readString();
                    int readInt = parcel.readInt();
                    LinkedHashSet linkedHashSet = new LinkedHashSet(readInt);
                    for (int i = 0; i != readInt; i++) {
                        linkedHashSet.add(parcel.readString());
                    }
                    return new UpdateShipping(createFromParcel, readString, linkedHashSet);
                }

                public final UpdateShipping[] newArray(int i) {
                    return new UpdateShipping[i];
                }
            }

            public static /* synthetic */ UpdateShipping copy$default(UpdateShipping updateShipping, ShippingInformation shippingInformation2, String str, Set<String> set, int i, Object obj) {
                if ((i & 1) != 0) {
                    shippingInformation2 = updateShipping.shippingInformation;
                }
                if ((i & 2) != 0) {
                    str = updateShipping.getId$payments_core_release();
                }
                if ((i & 4) != 0) {
                    set = updateShipping.getProductUsage$payments_core_release();
                }
                return updateShipping.copy(shippingInformation2, str, set);
            }

            public final ShippingInformation component1() {
                return this.shippingInformation;
            }

            public final String component2$payments_core_release() {
                return getId$payments_core_release();
            }

            public final Set<String> component3$payments_core_release() {
                return getProductUsage$payments_core_release();
            }

            public final UpdateShipping copy(ShippingInformation shippingInformation2, String str, Set<String> set) {
                Intrinsics.checkNotNullParameter(shippingInformation2, "shippingInformation");
                Intrinsics.checkNotNullParameter(str, MessageExtension.FIELD_ID);
                Intrinsics.checkNotNullParameter(set, NamedConstantsKt.PRODUCT_USAGE);
                return new UpdateShipping(shippingInformation2, str, set);
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof UpdateShipping)) {
                    return false;
                }
                UpdateShipping updateShipping = (UpdateShipping) obj;
                return Intrinsics.areEqual((Object) this.shippingInformation, (Object) updateShipping.shippingInformation) && Intrinsics.areEqual((Object) getId$payments_core_release(), (Object) updateShipping.getId$payments_core_release()) && Intrinsics.areEqual((Object) getProductUsage$payments_core_release(), (Object) updateShipping.getProductUsage$payments_core_release());
            }

            public int hashCode() {
                return (((this.shippingInformation.hashCode() * 31) + getId$payments_core_release().hashCode()) * 31) + getProductUsage$payments_core_release().hashCode();
            }

            public String toString() {
                return "UpdateShipping(shippingInformation=" + this.shippingInformation + ", id=" + getId$payments_core_release() + ", productUsage=" + getProductUsage$payments_core_release() + ')';
            }

            public void writeToParcel(Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                this.shippingInformation.writeToParcel(parcel, i);
                parcel.writeString(this.id);
                Set<String> set = this.productUsage;
                parcel.writeInt(set.size());
                for (String writeString : set) {
                    parcel.writeString(writeString);
                }
            }

            public final ShippingInformation getShippingInformation() {
                return this.shippingInformation;
            }

            public String getId$payments_core_release() {
                return this.id;
            }

            public Set<String> getProductUsage$payments_core_release() {
                return this.productUsage;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public UpdateShipping(ShippingInformation shippingInformation2, String str, Set<String> set) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(shippingInformation2, "shippingInformation");
                Intrinsics.checkNotNullParameter(str, MessageExtension.FIELD_ID);
                Intrinsics.checkNotNullParameter(set, NamedConstantsKt.PRODUCT_USAGE);
                this.shippingInformation = shippingInformation2;
                this.id = str;
                this.productUsage = set;
            }
        }

        @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000e\u0010\u0011\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u0012J\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÀ\u0003¢\u0006\u0002\b\u0014J7\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0017HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0017HÖ\u0001R\u0014\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006#"}, d2 = {"Lcom/stripe/android/EphemeralOperation$Customer$UpdateDefaultSource;", "Lcom/stripe/android/EphemeralOperation$Customer;", "sourceId", "", "sourceType", "id", "productUsage", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;)V", "getId$payments_core_release", "()Ljava/lang/String;", "getProductUsage$payments_core_release", "()Ljava/util/Set;", "getSourceId", "getSourceType", "component1", "component2", "component3", "component3$payments_core_release", "component4", "component4$payments_core_release", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: EphemeralOperation.kt */
        public static final class UpdateDefaultSource extends Customer {
            public static final int $stable = 8;
            public static final Parcelable.Creator<UpdateDefaultSource> CREATOR = new Creator();
            private final String id;
            private final Set<String> productUsage;
            private final String sourceId;
            private final String sourceType;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* compiled from: EphemeralOperation.kt */
            public static final class Creator implements Parcelable.Creator<UpdateDefaultSource> {
                public final UpdateDefaultSource createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    String readString = parcel.readString();
                    String readString2 = parcel.readString();
                    String readString3 = parcel.readString();
                    int readInt = parcel.readInt();
                    LinkedHashSet linkedHashSet = new LinkedHashSet(readInt);
                    for (int i = 0; i != readInt; i++) {
                        linkedHashSet.add(parcel.readString());
                    }
                    return new UpdateDefaultSource(readString, readString2, readString3, linkedHashSet);
                }

                public final UpdateDefaultSource[] newArray(int i) {
                    return new UpdateDefaultSource[i];
                }
            }

            public static /* synthetic */ UpdateDefaultSource copy$default(UpdateDefaultSource updateDefaultSource, String str, String str2, String str3, Set<String> set, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = updateDefaultSource.sourceId;
                }
                if ((i & 2) != 0) {
                    str2 = updateDefaultSource.sourceType;
                }
                if ((i & 4) != 0) {
                    str3 = updateDefaultSource.getId$payments_core_release();
                }
                if ((i & 8) != 0) {
                    set = updateDefaultSource.getProductUsage$payments_core_release();
                }
                return updateDefaultSource.copy(str, str2, str3, set);
            }

            public final String component1() {
                return this.sourceId;
            }

            public final String component2() {
                return this.sourceType;
            }

            public final String component3$payments_core_release() {
                return getId$payments_core_release();
            }

            public final Set<String> component4$payments_core_release() {
                return getProductUsage$payments_core_release();
            }

            public final UpdateDefaultSource copy(String str, String str2, String str3, Set<String> set) {
                Intrinsics.checkNotNullParameter(str, "sourceId");
                Intrinsics.checkNotNullParameter(str2, "sourceType");
                Intrinsics.checkNotNullParameter(str3, MessageExtension.FIELD_ID);
                Intrinsics.checkNotNullParameter(set, NamedConstantsKt.PRODUCT_USAGE);
                return new UpdateDefaultSource(str, str2, str3, set);
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof UpdateDefaultSource)) {
                    return false;
                }
                UpdateDefaultSource updateDefaultSource = (UpdateDefaultSource) obj;
                return Intrinsics.areEqual((Object) this.sourceId, (Object) updateDefaultSource.sourceId) && Intrinsics.areEqual((Object) this.sourceType, (Object) updateDefaultSource.sourceType) && Intrinsics.areEqual((Object) getId$payments_core_release(), (Object) updateDefaultSource.getId$payments_core_release()) && Intrinsics.areEqual((Object) getProductUsage$payments_core_release(), (Object) updateDefaultSource.getProductUsage$payments_core_release());
            }

            public int hashCode() {
                return (((((this.sourceId.hashCode() * 31) + this.sourceType.hashCode()) * 31) + getId$payments_core_release().hashCode()) * 31) + getProductUsage$payments_core_release().hashCode();
            }

            public String toString() {
                return "UpdateDefaultSource(sourceId=" + this.sourceId + ", sourceType=" + this.sourceType + ", id=" + getId$payments_core_release() + ", productUsage=" + getProductUsage$payments_core_release() + ')';
            }

            public void writeToParcel(Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeString(this.sourceId);
                parcel.writeString(this.sourceType);
                parcel.writeString(this.id);
                Set<String> set = this.productUsage;
                parcel.writeInt(set.size());
                for (String writeString : set) {
                    parcel.writeString(writeString);
                }
            }

            public final String getSourceId() {
                return this.sourceId;
            }

            public final String getSourceType() {
                return this.sourceType;
            }

            public String getId$payments_core_release() {
                return this.id;
            }

            public Set<String> getProductUsage$payments_core_release() {
                return this.productUsage;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public UpdateDefaultSource(String str, String str2, String str3, Set<String> set) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "sourceId");
                Intrinsics.checkNotNullParameter(str2, "sourceType");
                Intrinsics.checkNotNullParameter(str3, MessageExtension.FIELD_ID);
                Intrinsics.checkNotNullParameter(set, NamedConstantsKt.PRODUCT_USAGE);
                this.sourceId = str;
                this.sourceType = str2;
                this.id = str3;
                this.productUsage = set;
            }
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\b\tB\u0017\b\u0004\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Lcom/stripe/android/EphemeralOperation$Issuing;", "Lcom/stripe/android/EphemeralOperation;", "productUsage", "", "", "(Ljava/util/Set;)V", "getProductUsage$payments_core_release", "()Ljava/util/Set;", "RetrievePin", "UpdatePin", "Lcom/stripe/android/EphemeralOperation$Issuing$RetrievePin;", "Lcom/stripe/android/EphemeralOperation$Issuing$UpdatePin;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: EphemeralOperation.kt */
    public static abstract class Issuing extends EphemeralOperation {
        private final Set<String> productUsage;

        public /* synthetic */ Issuing(Set set, DefaultConstructorMarker defaultConstructorMarker) {
            this(set);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Issuing(Set set, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? SetsKt.emptySet() : set, (DefaultConstructorMarker) null);
        }

        public Set<String> getProductUsage$payments_core_release() {
            return this.productUsage;
        }

        private Issuing(Set<String> set) {
            super((DefaultConstructorMarker) null);
            this.productUsage = set;
        }

        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000e\u0010\u0010\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u0011J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0014HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0006\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006 "}, d2 = {"Lcom/stripe/android/EphemeralOperation$Issuing$RetrievePin;", "Lcom/stripe/android/EphemeralOperation$Issuing;", "cardId", "", "verificationId", "userOneTimeCode", "id", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCardId", "()Ljava/lang/String;", "getId$payments_core_release", "getUserOneTimeCode", "getVerificationId", "component1", "component2", "component3", "component4", "component4$payments_core_release", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: EphemeralOperation.kt */
        public static final class RetrievePin extends Issuing {
            public static final int $stable = 8;
            public static final Parcelable.Creator<RetrievePin> CREATOR = new Creator();
            private final String cardId;
            private final String id;
            private final String userOneTimeCode;
            private final String verificationId;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* compiled from: EphemeralOperation.kt */
            public static final class Creator implements Parcelable.Creator<RetrievePin> {
                public final RetrievePin createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new RetrievePin(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                }

                public final RetrievePin[] newArray(int i) {
                    return new RetrievePin[i];
                }
            }

            public static /* synthetic */ RetrievePin copy$default(RetrievePin retrievePin, String str, String str2, String str3, String str4, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = retrievePin.cardId;
                }
                if ((i & 2) != 0) {
                    str2 = retrievePin.verificationId;
                }
                if ((i & 4) != 0) {
                    str3 = retrievePin.userOneTimeCode;
                }
                if ((i & 8) != 0) {
                    str4 = retrievePin.getId$payments_core_release();
                }
                return retrievePin.copy(str, str2, str3, str4);
            }

            public final String component1() {
                return this.cardId;
            }

            public final String component2() {
                return this.verificationId;
            }

            public final String component3() {
                return this.userOneTimeCode;
            }

            public final String component4$payments_core_release() {
                return getId$payments_core_release();
            }

            public final RetrievePin copy(String str, String str2, String str3, String str4) {
                Intrinsics.checkNotNullParameter(str, "cardId");
                Intrinsics.checkNotNullParameter(str2, "verificationId");
                Intrinsics.checkNotNullParameter(str3, "userOneTimeCode");
                Intrinsics.checkNotNullParameter(str4, MessageExtension.FIELD_ID);
                return new RetrievePin(str, str2, str3, str4);
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof RetrievePin)) {
                    return false;
                }
                RetrievePin retrievePin = (RetrievePin) obj;
                return Intrinsics.areEqual((Object) this.cardId, (Object) retrievePin.cardId) && Intrinsics.areEqual((Object) this.verificationId, (Object) retrievePin.verificationId) && Intrinsics.areEqual((Object) this.userOneTimeCode, (Object) retrievePin.userOneTimeCode) && Intrinsics.areEqual((Object) getId$payments_core_release(), (Object) retrievePin.getId$payments_core_release());
            }

            public int hashCode() {
                return (((((this.cardId.hashCode() * 31) + this.verificationId.hashCode()) * 31) + this.userOneTimeCode.hashCode()) * 31) + getId$payments_core_release().hashCode();
            }

            public String toString() {
                return "RetrievePin(cardId=" + this.cardId + ", verificationId=" + this.verificationId + ", userOneTimeCode=" + this.userOneTimeCode + ", id=" + getId$payments_core_release() + ')';
            }

            public void writeToParcel(Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeString(this.cardId);
                parcel.writeString(this.verificationId);
                parcel.writeString(this.userOneTimeCode);
                parcel.writeString(this.id);
            }

            public final String getCardId() {
                return this.cardId;
            }

            public final String getVerificationId() {
                return this.verificationId;
            }

            public final String getUserOneTimeCode() {
                return this.userOneTimeCode;
            }

            public String getId$payments_core_release() {
                return this.id;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public RetrievePin(String str, String str2, String str3, String str4) {
                super((Set) null, 1, (DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "cardId");
                Intrinsics.checkNotNullParameter(str2, "verificationId");
                Intrinsics.checkNotNullParameter(str3, "userOneTimeCode");
                Intrinsics.checkNotNullParameter(str4, MessageExtension.FIELD_ID);
                this.cardId = str;
                this.verificationId = str2;
                this.userOneTimeCode = str3;
                this.id = str4;
            }
        }

        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000e\u0010\u0013\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u0014J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0017HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0007\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006#"}, d2 = {"Lcom/stripe/android/EphemeralOperation$Issuing$UpdatePin;", "Lcom/stripe/android/EphemeralOperation$Issuing;", "cardId", "", "newPin", "verificationId", "userOneTimeCode", "id", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCardId", "()Ljava/lang/String;", "getId$payments_core_release", "getNewPin", "getUserOneTimeCode", "getVerificationId", "component1", "component2", "component3", "component4", "component5", "component5$payments_core_release", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: EphemeralOperation.kt */
        public static final class UpdatePin extends Issuing {
            public static final int $stable = 8;
            public static final Parcelable.Creator<UpdatePin> CREATOR = new Creator();
            private final String cardId;
            private final String id;
            private final String newPin;
            private final String userOneTimeCode;
            private final String verificationId;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* compiled from: EphemeralOperation.kt */
            public static final class Creator implements Parcelable.Creator<UpdatePin> {
                public final UpdatePin createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new UpdatePin(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                }

                public final UpdatePin[] newArray(int i) {
                    return new UpdatePin[i];
                }
            }

            public static /* synthetic */ UpdatePin copy$default(UpdatePin updatePin, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = updatePin.cardId;
                }
                if ((i & 2) != 0) {
                    str2 = updatePin.newPin;
                }
                String str6 = str2;
                if ((i & 4) != 0) {
                    str3 = updatePin.verificationId;
                }
                String str7 = str3;
                if ((i & 8) != 0) {
                    str4 = updatePin.userOneTimeCode;
                }
                String str8 = str4;
                if ((i & 16) != 0) {
                    str5 = updatePin.getId$payments_core_release();
                }
                return updatePin.copy(str, str6, str7, str8, str5);
            }

            public final String component1() {
                return this.cardId;
            }

            public final String component2() {
                return this.newPin;
            }

            public final String component3() {
                return this.verificationId;
            }

            public final String component4() {
                return this.userOneTimeCode;
            }

            public final String component5$payments_core_release() {
                return getId$payments_core_release();
            }

            public final UpdatePin copy(String str, String str2, String str3, String str4, String str5) {
                Intrinsics.checkNotNullParameter(str, "cardId");
                Intrinsics.checkNotNullParameter(str2, "newPin");
                Intrinsics.checkNotNullParameter(str3, "verificationId");
                Intrinsics.checkNotNullParameter(str4, "userOneTimeCode");
                Intrinsics.checkNotNullParameter(str5, MessageExtension.FIELD_ID);
                return new UpdatePin(str, str2, str3, str4, str5);
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof UpdatePin)) {
                    return false;
                }
                UpdatePin updatePin = (UpdatePin) obj;
                return Intrinsics.areEqual((Object) this.cardId, (Object) updatePin.cardId) && Intrinsics.areEqual((Object) this.newPin, (Object) updatePin.newPin) && Intrinsics.areEqual((Object) this.verificationId, (Object) updatePin.verificationId) && Intrinsics.areEqual((Object) this.userOneTimeCode, (Object) updatePin.userOneTimeCode) && Intrinsics.areEqual((Object) getId$payments_core_release(), (Object) updatePin.getId$payments_core_release());
            }

            public int hashCode() {
                return (((((((this.cardId.hashCode() * 31) + this.newPin.hashCode()) * 31) + this.verificationId.hashCode()) * 31) + this.userOneTimeCode.hashCode()) * 31) + getId$payments_core_release().hashCode();
            }

            public String toString() {
                return "UpdatePin(cardId=" + this.cardId + ", newPin=" + this.newPin + ", verificationId=" + this.verificationId + ", userOneTimeCode=" + this.userOneTimeCode + ", id=" + getId$payments_core_release() + ')';
            }

            public void writeToParcel(Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeString(this.cardId);
                parcel.writeString(this.newPin);
                parcel.writeString(this.verificationId);
                parcel.writeString(this.userOneTimeCode);
                parcel.writeString(this.id);
            }

            public final String getCardId() {
                return this.cardId;
            }

            public final String getNewPin() {
                return this.newPin;
            }

            public final String getVerificationId() {
                return this.verificationId;
            }

            public final String getUserOneTimeCode() {
                return this.userOneTimeCode;
            }

            public String getId$payments_core_release() {
                return this.id;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public UpdatePin(String str, String str2, String str3, String str4, String str5) {
                super((Set) null, 1, (DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "cardId");
                Intrinsics.checkNotNullParameter(str2, "newPin");
                Intrinsics.checkNotNullParameter(str3, "verificationId");
                Intrinsics.checkNotNullParameter(str4, "userOneTimeCode");
                Intrinsics.checkNotNullParameter(str5, MessageExtension.FIELD_ID);
                this.cardId = str;
                this.newPin = str2;
                this.verificationId = str3;
                this.userOneTimeCode = str4;
                this.id = str5;
            }
        }
    }
}
