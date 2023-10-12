package com.stripe.android.connections.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.connections.model.serializer.PaymentAccountSerializer;
import com.stripe.android.core.model.StripeModel;
import com.stripe.android.stripe3ds2.transactions.MessageExtension;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u0002<=B_\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0001\u0010\n\u001a\u00020\u000b\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011B?\b\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0012J\t\u0010$\u001a\u00020\u0006HÆ\u0003J\t\u0010%\u001a\u00020\u0006HÆ\u0003J\t\u0010&\u001a\u00020\tHÆ\u0003J\t\u0010'\u001a\u00020\u000bHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0006HÆ\u0003JI\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\t\u0010+\u001a\u00020\u0004HÖ\u0001J\u0013\u0010,\u001a\u00020\u000b2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u00020\u0004HÖ\u0001J\t\u00100\u001a\u00020\u0006HÖ\u0001J!\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00002\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000207HÇ\u0001J\u0019\u00108\u001a\u0002022\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u0004HÖ\u0001R\u001c\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0007\u001a\u00020\u00068\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016R\u001c\u0010\b\u001a\u00020\t8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\n\u001a\u00020\u000b8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0014\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0014\u001a\u0004\b \u0010!R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u0014\u001a\u0004\b#\u0010\u0016¨\u0006>"}, d2 = {"Lcom/stripe/android/connections/model/LinkAccountSession;", "Lcom/stripe/android/core/model/StripeModel;", "Landroid/os/Parcelable;", "seen1", "", "clientSecret", "", "id", "linkedAccounts", "Lcom/stripe/android/connections/model/LinkedAccountList;", "livemode", "", "paymentAccount", "Lcom/stripe/android/connections/model/PaymentAccount;", "returnUrl", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lcom/stripe/android/connections/model/LinkedAccountList;ZLcom/stripe/android/connections/model/PaymentAccount;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/connections/model/LinkedAccountList;ZLcom/stripe/android/connections/model/PaymentAccount;Ljava/lang/String;)V", "getClientSecret$annotations", "()V", "getClientSecret", "()Ljava/lang/String;", "getId$annotations", "getId", "getLinkedAccounts$annotations", "getLinkedAccounts", "()Lcom/stripe/android/connections/model/LinkedAccountList;", "getLivemode$annotations", "getLivemode", "()Z", "getPaymentAccount$annotations", "getPaymentAccount", "()Lcom/stripe/android/connections/model/PaymentAccount;", "getReturnUrl$annotations", "getReturnUrl", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "$serializer", "Companion", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Serializable
/* compiled from: LinkAccountSession.kt */
public final class LinkAccountSession implements StripeModel, Parcelable {
    public static final Parcelable.Creator<LinkAccountSession> CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String clientSecret;
    private final String id;
    private final LinkedAccountList linkedAccounts;
    private final boolean livemode;
    private final PaymentAccount paymentAccount;
    private final String returnUrl;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LinkAccountSession.kt */
    public static final class Creator implements Parcelable.Creator<LinkAccountSession> {
        public final LinkAccountSession createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new LinkAccountSession(parcel.readString(), parcel.readString(), LinkedAccountList.CREATOR.createFromParcel(parcel), parcel.readInt() != 0, (PaymentAccount) parcel.readParcelable(LinkAccountSession.class.getClassLoader()), parcel.readString());
        }

        public final LinkAccountSession[] newArray(int i) {
            return new LinkAccountSession[i];
        }
    }

    public static /* synthetic */ LinkAccountSession copy$default(LinkAccountSession linkAccountSession, String str, String str2, LinkedAccountList linkedAccountList, boolean z, PaymentAccount paymentAccount2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = linkAccountSession.clientSecret;
        }
        if ((i & 2) != 0) {
            str2 = linkAccountSession.id;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            linkedAccountList = linkAccountSession.linkedAccounts;
        }
        LinkedAccountList linkedAccountList2 = linkedAccountList;
        if ((i & 8) != 0) {
            z = linkAccountSession.livemode;
        }
        boolean z2 = z;
        if ((i & 16) != 0) {
            paymentAccount2 = linkAccountSession.paymentAccount;
        }
        PaymentAccount paymentAccount3 = paymentAccount2;
        if ((i & 32) != 0) {
            str3 = linkAccountSession.returnUrl;
        }
        return linkAccountSession.copy(str, str4, linkedAccountList2, z2, paymentAccount3, str3);
    }

    @SerialName("client_secret")
    public static /* synthetic */ void getClientSecret$annotations() {
    }

    @SerialName("id")
    public static /* synthetic */ void getId$annotations() {
    }

    @SerialName("linked_accounts")
    public static /* synthetic */ void getLinkedAccounts$annotations() {
    }

    @SerialName("livemode")
    public static /* synthetic */ void getLivemode$annotations() {
    }

    @SerialName("payment_account")
    public static /* synthetic */ void getPaymentAccount$annotations() {
    }

    @SerialName("return_url")
    public static /* synthetic */ void getReturnUrl$annotations() {
    }

    public final String component1() {
        return this.clientSecret;
    }

    public final String component2() {
        return this.id;
    }

    public final LinkedAccountList component3() {
        return this.linkedAccounts;
    }

    public final boolean component4() {
        return this.livemode;
    }

    public final PaymentAccount component5() {
        return this.paymentAccount;
    }

    public final String component6() {
        return this.returnUrl;
    }

    public final LinkAccountSession copy(String str, String str2, LinkedAccountList linkedAccountList, boolean z, PaymentAccount paymentAccount2, String str3) {
        Intrinsics.checkNotNullParameter(str, "clientSecret");
        Intrinsics.checkNotNullParameter(str2, MessageExtension.FIELD_ID);
        Intrinsics.checkNotNullParameter(linkedAccountList, "linkedAccounts");
        return new LinkAccountSession(str, str2, linkedAccountList, z, paymentAccount2, str3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LinkAccountSession)) {
            return false;
        }
        LinkAccountSession linkAccountSession = (LinkAccountSession) obj;
        return Intrinsics.areEqual((Object) this.clientSecret, (Object) linkAccountSession.clientSecret) && Intrinsics.areEqual((Object) this.id, (Object) linkAccountSession.id) && Intrinsics.areEqual((Object) this.linkedAccounts, (Object) linkAccountSession.linkedAccounts) && this.livemode == linkAccountSession.livemode && Intrinsics.areEqual((Object) this.paymentAccount, (Object) linkAccountSession.paymentAccount) && Intrinsics.areEqual((Object) this.returnUrl, (Object) linkAccountSession.returnUrl);
    }

    public int hashCode() {
        int hashCode = ((((this.clientSecret.hashCode() * 31) + this.id.hashCode()) * 31) + this.linkedAccounts.hashCode()) * 31;
        boolean z = this.livemode;
        if (z) {
            z = true;
        }
        int i = (hashCode + (z ? 1 : 0)) * 31;
        PaymentAccount paymentAccount2 = this.paymentAccount;
        int i2 = 0;
        int hashCode2 = (i + (paymentAccount2 == null ? 0 : paymentAccount2.hashCode())) * 31;
        String str = this.returnUrl;
        if (str != null) {
            i2 = str.hashCode();
        }
        return hashCode2 + i2;
    }

    public String toString() {
        return "LinkAccountSession(clientSecret=" + this.clientSecret + ", id=" + this.id + ", linkedAccounts=" + this.linkedAccounts + ", livemode=" + this.livemode + ", paymentAccount=" + this.paymentAccount + ", returnUrl=" + this.returnUrl + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.clientSecret);
        parcel.writeString(this.id);
        this.linkedAccounts.writeToParcel(parcel, i);
        parcel.writeInt(this.livemode ? 1 : 0);
        parcel.writeParcelable(this.paymentAccount, i);
        parcel.writeString(this.returnUrl);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/connections/model/LinkAccountSession$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/stripe/android/connections/model/LinkAccountSession;", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LinkAccountSession.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<LinkAccountSession> serializer() {
            return LinkAccountSession$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ LinkAccountSession(int i, @SerialName("client_secret") String str, @SerialName("id") String str2, @SerialName("linked_accounts") LinkedAccountList linkedAccountList, @SerialName("livemode") boolean z, @SerialName("payment_account") PaymentAccount paymentAccount2, @SerialName("return_url") String str3, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (i & 15)) {
            PluginExceptionsKt.throwMissingFieldException(i, 15, LinkAccountSession$$serializer.INSTANCE.getDescriptor());
        }
        this.clientSecret = str;
        this.id = str2;
        this.linkedAccounts = linkedAccountList;
        this.livemode = z;
        if ((i & 16) == 0) {
            this.paymentAccount = null;
        } else {
            this.paymentAccount = paymentAccount2;
        }
        if ((i & 32) == 0) {
            this.returnUrl = null;
        } else {
            this.returnUrl = str3;
        }
    }

    public LinkAccountSession(String str, String str2, LinkedAccountList linkedAccountList, boolean z, PaymentAccount paymentAccount2, String str3) {
        Intrinsics.checkNotNullParameter(str, "clientSecret");
        Intrinsics.checkNotNullParameter(str2, MessageExtension.FIELD_ID);
        Intrinsics.checkNotNullParameter(linkedAccountList, "linkedAccounts");
        this.clientSecret = str;
        this.id = str2;
        this.linkedAccounts = linkedAccountList;
        this.livemode = z;
        this.paymentAccount = paymentAccount2;
        this.returnUrl = str3;
    }

    @JvmStatic
    public static final void write$Self(LinkAccountSession linkAccountSession, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(linkAccountSession, "self");
        Intrinsics.checkNotNullParameter(compositeEncoder, "output");
        Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
        boolean z = false;
        compositeEncoder.encodeStringElement(serialDescriptor, 0, linkAccountSession.clientSecret);
        compositeEncoder.encodeStringElement(serialDescriptor, 1, linkAccountSession.id);
        compositeEncoder.encodeSerializableElement(serialDescriptor, 2, LinkedAccountList$$serializer.INSTANCE, linkAccountSession.linkedAccounts);
        compositeEncoder.encodeBooleanElement(serialDescriptor, 3, linkAccountSession.livemode);
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 4) || linkAccountSession.paymentAccount != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 4, PaymentAccountSerializer.INSTANCE, linkAccountSession.paymentAccount);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 5) || linkAccountSession.returnUrl != null) {
            z = true;
        }
        if (z) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, linkAccountSession.returnUrl);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LinkAccountSession(String str, String str2, LinkedAccountList linkedAccountList, boolean z, PaymentAccount paymentAccount2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, linkedAccountList, z, (i & 16) != 0 ? null : paymentAccount2, (i & 32) != 0 ? null : str3);
    }

    public final String getClientSecret() {
        return this.clientSecret;
    }

    public final String getId() {
        return this.id;
    }

    public final LinkedAccountList getLinkedAccounts() {
        return this.linkedAccounts;
    }

    public final boolean getLivemode() {
        return this.livemode;
    }

    public final PaymentAccount getPaymentAccount() {
        return this.paymentAccount;
    }

    public final String getReturnUrl() {
        return this.returnUrl;
    }
}
