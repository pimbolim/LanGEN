package com.stripe.android.connections.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
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

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 &2\u00020\u0001:\u0002%&B1\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u000e\u001a\u00020\u0005HÂ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÂ\u0003J\u001f\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00150\u0018J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J!\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 HÇ\u0001J\u0019\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\r\u0010\f¨\u0006'"}, d2 = {"Lcom/stripe/android/connections/model/ListLinkedAccountParams;", "Landroid/os/Parcelable;", "seen1", "", "clientSecret", "", "startingAfterAccountId", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;)V", "getClientSecret$annotations", "()V", "getStartingAfterAccountId$annotations", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toParamMap", "", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "$serializer", "Companion", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Serializable
/* compiled from: ListLinkedAccountParams.kt */
public final class ListLinkedAccountParams implements Parcelable {
    public static final Parcelable.Creator<ListLinkedAccountParams> CREATOR = new Creator();
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final String PARAM_CLIENT_SECRET = "client_secret";
    @Deprecated
    private static final String PARAM_STARTING_AFTER = "starting_after";
    private final String clientSecret;
    private final String startingAfterAccountId;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ListLinkedAccountParams.kt */
    public static final class Creator implements Parcelable.Creator<ListLinkedAccountParams> {
        public final ListLinkedAccountParams createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ListLinkedAccountParams(parcel.readString(), parcel.readString());
        }

        public final ListLinkedAccountParams[] newArray(int i) {
            return new ListLinkedAccountParams[i];
        }
    }

    private final String component1() {
        return this.clientSecret;
    }

    private final String component2() {
        return this.startingAfterAccountId;
    }

    public static /* synthetic */ ListLinkedAccountParams copy$default(ListLinkedAccountParams listLinkedAccountParams, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = listLinkedAccountParams.clientSecret;
        }
        if ((i & 2) != 0) {
            str2 = listLinkedAccountParams.startingAfterAccountId;
        }
        return listLinkedAccountParams.copy(str, str2);
    }

    @SerialName("client_secret")
    private static /* synthetic */ void getClientSecret$annotations() {
    }

    @SerialName("starting_after")
    private static /* synthetic */ void getStartingAfterAccountId$annotations() {
    }

    public final ListLinkedAccountParams copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "clientSecret");
        return new ListLinkedAccountParams(str, str2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ListLinkedAccountParams)) {
            return false;
        }
        ListLinkedAccountParams listLinkedAccountParams = (ListLinkedAccountParams) obj;
        return Intrinsics.areEqual((Object) this.clientSecret, (Object) listLinkedAccountParams.clientSecret) && Intrinsics.areEqual((Object) this.startingAfterAccountId, (Object) listLinkedAccountParams.startingAfterAccountId);
    }

    public int hashCode() {
        int hashCode = this.clientSecret.hashCode() * 31;
        String str = this.startingAfterAccountId;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "ListLinkedAccountParams(clientSecret=" + this.clientSecret + ", startingAfterAccountId=" + this.startingAfterAccountId + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.clientSecret);
        parcel.writeString(this.startingAfterAccountId);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ ListLinkedAccountParams(int i, @SerialName("client_secret") String str, @SerialName("starting_after") String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, ListLinkedAccountParams$$serializer.INSTANCE.getDescriptor());
        }
        this.clientSecret = str;
        this.startingAfterAccountId = str2;
    }

    public ListLinkedAccountParams(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "clientSecret");
        this.clientSecret = str;
        this.startingAfterAccountId = str2;
    }

    @JvmStatic
    public static final void write$Self(ListLinkedAccountParams listLinkedAccountParams, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(listLinkedAccountParams, "self");
        Intrinsics.checkNotNullParameter(compositeEncoder, "output");
        Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
        compositeEncoder.encodeStringElement(serialDescriptor, 0, listLinkedAccountParams.clientSecret);
        compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, listLinkedAccountParams.startingAfterAccountId);
    }

    public final Map<String, Object> toParamMap() {
        Map map;
        Pair[] pairArr = {TuplesKt.to("client_secret", this.clientSecret), TuplesKt.to(PARAM_STARTING_AFTER, this.startingAfterAccountId)};
        Map<String, Object> emptyMap = MapsKt.emptyMap();
        for (Pair pair : CollectionsKt.listOf(pairArr)) {
            String str = (String) pair.component1();
            String str2 = (String) pair.component2();
            if (str2 == null) {
                map = null;
            } else {
                map = MapsKt.mapOf(TuplesKt.to(str, str2));
            }
            if (map == null) {
                map = MapsKt.emptyMap();
            }
            emptyMap = MapsKt.plus(emptyMap, (Map<String, Object>) map);
        }
        return emptyMap;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/stripe/android/connections/model/ListLinkedAccountParams$Companion;", "", "()V", "PARAM_CLIENT_SECRET", "", "PARAM_STARTING_AFTER", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/stripe/android/connections/model/ListLinkedAccountParams;", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ListLinkedAccountParams.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ListLinkedAccountParams> serializer() {
            return ListLinkedAccountParams$$serializer.INSTANCE;
        }
    }
}
