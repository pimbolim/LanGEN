package com.stripe.android.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.model.StripeIntent;
import java.io.ByteArrayInputStream;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001$B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B'\b\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\nHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0018HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001J\u0019\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000f¨\u0006%"}, d2 = {"Lcom/stripe/android/model/Stripe3ds2Fingerprint;", "Landroid/os/Parcelable;", "sdkData", "Lcom/stripe/android/model/StripeIntent$NextActionData$SdkData$Use3DS2;", "(Lcom/stripe/android/model/StripeIntent$NextActionData$SdkData$Use3DS2;)V", "source", "", "directoryServerName", "serverTransactionId", "directoryServerEncryption", "Lcom/stripe/android/model/Stripe3ds2Fingerprint$DirectoryServerEncryption;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/model/Stripe3ds2Fingerprint$DirectoryServerEncryption;)V", "getDirectoryServerEncryption", "()Lcom/stripe/android/model/Stripe3ds2Fingerprint$DirectoryServerEncryption;", "getDirectoryServerName", "()Ljava/lang/String;", "getServerTransactionId", "getSource", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "DirectoryServerEncryption", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Stripe3ds2Fingerprint.kt */
public final class Stripe3ds2Fingerprint implements Parcelable {
    public static final Parcelable.Creator<Stripe3ds2Fingerprint> CREATOR = new Creator();
    private final DirectoryServerEncryption directoryServerEncryption;
    private final String directoryServerName;
    private final String serverTransactionId;
    private final String source;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Stripe3ds2Fingerprint.kt */
    public static final class Creator implements Parcelable.Creator<Stripe3ds2Fingerprint> {
        public final Stripe3ds2Fingerprint createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new Stripe3ds2Fingerprint(parcel.readString(), parcel.readString(), parcel.readString(), DirectoryServerEncryption.CREATOR.createFromParcel(parcel));
        }

        public final Stripe3ds2Fingerprint[] newArray(int i) {
            return new Stripe3ds2Fingerprint[i];
        }
    }

    public static /* synthetic */ Stripe3ds2Fingerprint copy$default(Stripe3ds2Fingerprint stripe3ds2Fingerprint, String str, String str2, String str3, DirectoryServerEncryption directoryServerEncryption2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = stripe3ds2Fingerprint.source;
        }
        if ((i & 2) != 0) {
            str2 = stripe3ds2Fingerprint.directoryServerName;
        }
        if ((i & 4) != 0) {
            str3 = stripe3ds2Fingerprint.serverTransactionId;
        }
        if ((i & 8) != 0) {
            directoryServerEncryption2 = stripe3ds2Fingerprint.directoryServerEncryption;
        }
        return stripe3ds2Fingerprint.copy(str, str2, str3, directoryServerEncryption2);
    }

    public final String component1() {
        return this.source;
    }

    public final String component2() {
        return this.directoryServerName;
    }

    public final String component3() {
        return this.serverTransactionId;
    }

    public final DirectoryServerEncryption component4() {
        return this.directoryServerEncryption;
    }

    public final Stripe3ds2Fingerprint copy(String str, String str2, String str3, DirectoryServerEncryption directoryServerEncryption2) {
        Intrinsics.checkNotNullParameter(str, "source");
        Intrinsics.checkNotNullParameter(str2, "directoryServerName");
        Intrinsics.checkNotNullParameter(str3, "serverTransactionId");
        Intrinsics.checkNotNullParameter(directoryServerEncryption2, "directoryServerEncryption");
        return new Stripe3ds2Fingerprint(str, str2, str3, directoryServerEncryption2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Stripe3ds2Fingerprint)) {
            return false;
        }
        Stripe3ds2Fingerprint stripe3ds2Fingerprint = (Stripe3ds2Fingerprint) obj;
        return Intrinsics.areEqual((Object) this.source, (Object) stripe3ds2Fingerprint.source) && Intrinsics.areEqual((Object) this.directoryServerName, (Object) stripe3ds2Fingerprint.directoryServerName) && Intrinsics.areEqual((Object) this.serverTransactionId, (Object) stripe3ds2Fingerprint.serverTransactionId) && Intrinsics.areEqual((Object) this.directoryServerEncryption, (Object) stripe3ds2Fingerprint.directoryServerEncryption);
    }

    public int hashCode() {
        return (((((this.source.hashCode() * 31) + this.directoryServerName.hashCode()) * 31) + this.serverTransactionId.hashCode()) * 31) + this.directoryServerEncryption.hashCode();
    }

    public String toString() {
        return "Stripe3ds2Fingerprint(source=" + this.source + ", directoryServerName=" + this.directoryServerName + ", serverTransactionId=" + this.serverTransactionId + ", directoryServerEncryption=" + this.directoryServerEncryption + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.source);
        parcel.writeString(this.directoryServerName);
        parcel.writeString(this.serverTransactionId);
        this.directoryServerEncryption.writeToParcel(parcel, i);
    }

    public Stripe3ds2Fingerprint(String str, String str2, String str3, DirectoryServerEncryption directoryServerEncryption2) {
        Intrinsics.checkNotNullParameter(str, "source");
        Intrinsics.checkNotNullParameter(str2, "directoryServerName");
        Intrinsics.checkNotNullParameter(str3, "serverTransactionId");
        Intrinsics.checkNotNullParameter(directoryServerEncryption2, "directoryServerEncryption");
        this.source = str;
        this.directoryServerName = str2;
        this.serverTransactionId = str3;
        this.directoryServerEncryption = directoryServerEncryption2;
    }

    public final String getSource() {
        return this.source;
    }

    public final String getDirectoryServerName() {
        return this.directoryServerName;
    }

    public final String getServerTransactionId() {
        return this.serverTransactionId;
    }

    public final DirectoryServerEncryption getDirectoryServerEncryption() {
        return this.directoryServerEncryption;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Stripe3ds2Fingerprint(StripeIntent.NextActionData.SdkData.Use3DS2 use3DS2) throws CertificateException {
        this(use3DS2.getSource(), use3DS2.getServerName(), use3DS2.getTransactionId(), new DirectoryServerEncryption(use3DS2.getServerEncryption().getDirectoryServerId(), use3DS2.getServerEncryption().getDsCertificateData(), use3DS2.getServerEncryption().getRootCertsData(), use3DS2.getServerEncryption().getKeyId()));
        Intrinsics.checkNotNullParameter(use3DS2, "sdkData");
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 '2\u00020\u0001:\u0001'B/\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bB/\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\nHÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u0006HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u001bHÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006("}, d2 = {"Lcom/stripe/android/model/Stripe3ds2Fingerprint$DirectoryServerEncryption;", "Landroid/os/Parcelable;", "directoryServerId", "", "dsCertificateData", "rootCertsData", "", "keyId", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "directoryServerPublicKey", "Ljava/security/PublicKey;", "rootCerts", "Ljava/security/cert/X509Certificate;", "(Ljava/lang/String;Ljava/security/PublicKey;Ljava/util/List;Ljava/lang/String;)V", "getDirectoryServerId", "()Ljava/lang/String;", "getDirectoryServerPublicKey", "()Ljava/security/PublicKey;", "getKeyId", "getRootCerts", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Stripe3ds2Fingerprint.kt */
    public static final class DirectoryServerEncryption implements Parcelable {
        public static final Parcelable.Creator<DirectoryServerEncryption> CREATOR = new Creator();
        /* access modifiers changed from: private */
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final String directoryServerId;
        private final PublicKey directoryServerPublicKey;
        private final String keyId;
        private final List<X509Certificate> rootCerts;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Stripe3ds2Fingerprint.kt */
        public static final class Creator implements Parcelable.Creator<DirectoryServerEncryption> {
            public final DirectoryServerEncryption createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                String readString = parcel.readString();
                PublicKey publicKey = (PublicKey) parcel.readSerializable();
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                for (int i = 0; i != readInt; i++) {
                    arrayList.add(parcel.readSerializable());
                }
                return new DirectoryServerEncryption(readString, publicKey, (List<? extends X509Certificate>) arrayList, parcel.readString());
            }

            public final DirectoryServerEncryption[] newArray(int i) {
                return new DirectoryServerEncryption[i];
            }
        }

        public static /* synthetic */ DirectoryServerEncryption copy$default(DirectoryServerEncryption directoryServerEncryption, String str, PublicKey publicKey, List<X509Certificate> list, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = directoryServerEncryption.directoryServerId;
            }
            if ((i & 2) != 0) {
                publicKey = directoryServerEncryption.directoryServerPublicKey;
            }
            if ((i & 4) != 0) {
                list = directoryServerEncryption.rootCerts;
            }
            if ((i & 8) != 0) {
                str2 = directoryServerEncryption.keyId;
            }
            return directoryServerEncryption.copy(str, publicKey, list, str2);
        }

        public final String component1() {
            return this.directoryServerId;
        }

        public final PublicKey component2() {
            return this.directoryServerPublicKey;
        }

        public final List<X509Certificate> component3() {
            return this.rootCerts;
        }

        public final String component4() {
            return this.keyId;
        }

        public final DirectoryServerEncryption copy(String str, PublicKey publicKey, List<? extends X509Certificate> list, String str2) {
            Intrinsics.checkNotNullParameter(str, "directoryServerId");
            Intrinsics.checkNotNullParameter(publicKey, "directoryServerPublicKey");
            Intrinsics.checkNotNullParameter(list, "rootCerts");
            return new DirectoryServerEncryption(str, publicKey, list, str2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DirectoryServerEncryption)) {
                return false;
            }
            DirectoryServerEncryption directoryServerEncryption = (DirectoryServerEncryption) obj;
            return Intrinsics.areEqual((Object) this.directoryServerId, (Object) directoryServerEncryption.directoryServerId) && Intrinsics.areEqual((Object) this.directoryServerPublicKey, (Object) directoryServerEncryption.directoryServerPublicKey) && Intrinsics.areEqual((Object) this.rootCerts, (Object) directoryServerEncryption.rootCerts) && Intrinsics.areEqual((Object) this.keyId, (Object) directoryServerEncryption.keyId);
        }

        public int hashCode() {
            int hashCode = ((((this.directoryServerId.hashCode() * 31) + this.directoryServerPublicKey.hashCode()) * 31) + this.rootCerts.hashCode()) * 31;
            String str = this.keyId;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "DirectoryServerEncryption(directoryServerId=" + this.directoryServerId + ", directoryServerPublicKey=" + this.directoryServerPublicKey + ", rootCerts=" + this.rootCerts + ", keyId=" + this.keyId + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.directoryServerId);
            parcel.writeSerializable(this.directoryServerPublicKey);
            List<X509Certificate> list = this.rootCerts;
            parcel.writeInt(list.size());
            for (X509Certificate writeSerializable : list) {
                parcel.writeSerializable(writeSerializable);
            }
            parcel.writeString(this.keyId);
        }

        public DirectoryServerEncryption(String str, PublicKey publicKey, List<? extends X509Certificate> list, String str2) {
            Intrinsics.checkNotNullParameter(str, "directoryServerId");
            Intrinsics.checkNotNullParameter(publicKey, "directoryServerPublicKey");
            Intrinsics.checkNotNullParameter(list, "rootCerts");
            this.directoryServerId = str;
            this.directoryServerPublicKey = publicKey;
            this.rootCerts = list;
            this.keyId = str2;
        }

        public final String getDirectoryServerId() {
            return this.directoryServerId;
        }

        public final PublicKey getDirectoryServerPublicKey() {
            return this.directoryServerPublicKey;
        }

        public final List<X509Certificate> getRootCerts() {
            return this.rootCerts;
        }

        public final String getKeyId() {
            return this.keyId;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public DirectoryServerEncryption(java.lang.String r3, java.lang.String r4, java.util.List<java.lang.String> r5, java.lang.String r6) {
            /*
                r2 = this;
                java.lang.String r0 = "directoryServerId"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                java.lang.String r0 = "dsCertificateData"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                java.lang.String r0 = "rootCertsData"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                com.stripe.android.model.Stripe3ds2Fingerprint$DirectoryServerEncryption$Companion r0 = Companion
                java.security.cert.X509Certificate r4 = r0.generateCertificate(r4)
                java.security.PublicKey r4 = r4.getPublicKey()
                java.lang.String r1 = "generateCertificate(dsCertificateData).publicKey"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r1)
                java.util.List r5 = r0.generateCertificates(r5)
                r2.<init>((java.lang.String) r3, (java.security.PublicKey) r4, (java.util.List<? extends java.security.cert.X509Certificate>) r5, (java.lang.String) r6)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.model.Stripe3ds2Fingerprint.DirectoryServerEncryption.<init>(java.lang.String, java.lang.String, java.util.List, java.lang.String):void");
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0002¨\u0006\n"}, d2 = {"Lcom/stripe/android/model/Stripe3ds2Fingerprint$DirectoryServerEncryption$Companion;", "", "()V", "generateCertificate", "Ljava/security/cert/X509Certificate;", "certificateData", "", "generateCertificates", "", "certificatesData", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Stripe3ds2Fingerprint.kt */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* access modifiers changed from: private */
            public final List<X509Certificate> generateCertificates(List<String> list) throws CertificateException {
                Iterable<String> iterable = list;
                Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                for (String generateCertificate : iterable) {
                    arrayList.add(DirectoryServerEncryption.Companion.generateCertificate(generateCertificate));
                }
                return (List) arrayList;
            }

            /* access modifiers changed from: private */
            public final X509Certificate generateCertificate(String str) throws CertificateException {
                CertificateFactory instance = CertificateFactory.getInstance("X.509");
                byte[] bytes = str.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                Certificate generateCertificate = instance.generateCertificate(new ByteArrayInputStream(bytes));
                Objects.requireNonNull(generateCertificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                return (X509Certificate) generateCertificate;
            }
        }
    }
}
