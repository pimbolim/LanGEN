package com.stripe.android.connections.model;

import android.os.Parcel;
import android.os.Parcelable;
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

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 +2\u00020\u0001:\u0002*+B=\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J'\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J!\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%HÇ\u0001J\u0019\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0007\u001a\u00020\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f¨\u0006,"}, d2 = {"Lcom/stripe/android/connections/model/LinkAccountSessionManifest;", "Landroid/os/Parcelable;", "seen1", "", "hostedAuthUrl", "", "successUrl", "cancelUrl", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCancelUrl$annotations", "()V", "getCancelUrl", "()Ljava/lang/String;", "getHostedAuthUrl$annotations", "getHostedAuthUrl", "getSuccessUrl$annotations", "getSuccessUrl", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "$serializer", "Companion", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Serializable
/* compiled from: LinkAccountSessionManifest.kt */
public final class LinkAccountSessionManifest implements Parcelable {
    public static final Parcelable.Creator<LinkAccountSessionManifest> CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String cancelUrl;
    private final String hostedAuthUrl;
    private final String successUrl;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LinkAccountSessionManifest.kt */
    public static final class Creator implements Parcelable.Creator<LinkAccountSessionManifest> {
        public final LinkAccountSessionManifest createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new LinkAccountSessionManifest(parcel.readString(), parcel.readString(), parcel.readString());
        }

        public final LinkAccountSessionManifest[] newArray(int i) {
            return new LinkAccountSessionManifest[i];
        }
    }

    public static /* synthetic */ LinkAccountSessionManifest copy$default(LinkAccountSessionManifest linkAccountSessionManifest, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = linkAccountSessionManifest.hostedAuthUrl;
        }
        if ((i & 2) != 0) {
            str2 = linkAccountSessionManifest.successUrl;
        }
        if ((i & 4) != 0) {
            str3 = linkAccountSessionManifest.cancelUrl;
        }
        return linkAccountSessionManifest.copy(str, str2, str3);
    }

    @SerialName("cancel_url")
    public static /* synthetic */ void getCancelUrl$annotations() {
    }

    @SerialName("hosted_auth_url")
    public static /* synthetic */ void getHostedAuthUrl$annotations() {
    }

    @SerialName("success_url")
    public static /* synthetic */ void getSuccessUrl$annotations() {
    }

    public final String component1() {
        return this.hostedAuthUrl;
    }

    public final String component2() {
        return this.successUrl;
    }

    public final String component3() {
        return this.cancelUrl;
    }

    public final LinkAccountSessionManifest copy(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "hostedAuthUrl");
        Intrinsics.checkNotNullParameter(str2, "successUrl");
        Intrinsics.checkNotNullParameter(str3, "cancelUrl");
        return new LinkAccountSessionManifest(str, str2, str3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LinkAccountSessionManifest)) {
            return false;
        }
        LinkAccountSessionManifest linkAccountSessionManifest = (LinkAccountSessionManifest) obj;
        return Intrinsics.areEqual((Object) this.hostedAuthUrl, (Object) linkAccountSessionManifest.hostedAuthUrl) && Intrinsics.areEqual((Object) this.successUrl, (Object) linkAccountSessionManifest.successUrl) && Intrinsics.areEqual((Object) this.cancelUrl, (Object) linkAccountSessionManifest.cancelUrl);
    }

    public int hashCode() {
        return (((this.hostedAuthUrl.hashCode() * 31) + this.successUrl.hashCode()) * 31) + this.cancelUrl.hashCode();
    }

    public String toString() {
        return "LinkAccountSessionManifest(hostedAuthUrl=" + this.hostedAuthUrl + ", successUrl=" + this.successUrl + ", cancelUrl=" + this.cancelUrl + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.hostedAuthUrl);
        parcel.writeString(this.successUrl);
        parcel.writeString(this.cancelUrl);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/connections/model/LinkAccountSessionManifest$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/stripe/android/connections/model/LinkAccountSessionManifest;", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LinkAccountSessionManifest.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<LinkAccountSessionManifest> serializer() {
            return LinkAccountSessionManifest$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ LinkAccountSessionManifest(int i, @SerialName("hosted_auth_url") String str, @SerialName("success_url") String str2, @SerialName("cancel_url") String str3, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i, 7, LinkAccountSessionManifest$$serializer.INSTANCE.getDescriptor());
        }
        this.hostedAuthUrl = str;
        this.successUrl = str2;
        this.cancelUrl = str3;
    }

    public LinkAccountSessionManifest(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "hostedAuthUrl");
        Intrinsics.checkNotNullParameter(str2, "successUrl");
        Intrinsics.checkNotNullParameter(str3, "cancelUrl");
        this.hostedAuthUrl = str;
        this.successUrl = str2;
        this.cancelUrl = str3;
    }

    @JvmStatic
    public static final void write$Self(LinkAccountSessionManifest linkAccountSessionManifest, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(linkAccountSessionManifest, "self");
        Intrinsics.checkNotNullParameter(compositeEncoder, "output");
        Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
        compositeEncoder.encodeStringElement(serialDescriptor, 0, linkAccountSessionManifest.hostedAuthUrl);
        compositeEncoder.encodeStringElement(serialDescriptor, 1, linkAccountSessionManifest.successUrl);
        compositeEncoder.encodeStringElement(serialDescriptor, 2, linkAccountSessionManifest.cancelUrl);
    }

    public final String getHostedAuthUrl() {
        return this.hostedAuthUrl;
    }

    public final String getSuccessUrl() {
        return this.successUrl;
    }

    public final String getCancelUrl() {
        return this.cancelUrl;
    }
}
