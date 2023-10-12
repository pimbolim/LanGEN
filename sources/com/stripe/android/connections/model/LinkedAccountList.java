package com.stripe.android.connections.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.core.model.StripeModel;
import java.util.ArrayList;
import java.util.List;
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
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 ;2\u00020\u00012\u00020\u0002:\u0002:;BY\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0010\b\u0001\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010B;\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0011J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010#\u001a\u00020\tHÆ\u0003J\t\u0010$\u001a\u00020\u000bHÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010&\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0015JJ\u0010'\u001a\u00020\u00002\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010(J\t\u0010)\u001a\u00020\u0004HÖ\u0001J\u0013\u0010*\u001a\u00020\t2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020\u0004HÖ\u0001J\t\u0010.\u001a\u00020\u000bHÖ\u0001J!\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00002\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205HÇ\u0001J\u0019\u00106\u001a\u0002002\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u0004HÖ\u0001R \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\u0010\n\u0002\u0010\u0016\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\b\u001a\u00020\t8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0019R\"\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u001b\u0010\u001cR \u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\u0010\n\u0002\u0010\u0016\u0012\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001e\u0010\u0015R\u001c\u0010\n\u001a\u00020\u000b8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0013\u001a\u0004\b \u0010!¨\u0006<"}, d2 = {"Lcom/stripe/android/connections/model/LinkedAccountList;", "Lcom/stripe/android/core/model/StripeModel;", "Landroid/os/Parcelable;", "seen1", "", "linkedAccounts", "", "Lcom/stripe/android/connections/model/LinkedAccount;", "hasMore", "", "url", "", "count", "totalCount", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;ZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/util/List;ZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getCount$annotations", "()V", "getCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHasMore$annotations", "getHasMore", "()Z", "getLinkedAccounts$annotations", "getLinkedAccounts", "()Ljava/util/List;", "getTotalCount$annotations", "getTotalCount", "getUrl$annotations", "getUrl", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/util/List;ZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/stripe/android/connections/model/LinkedAccountList;", "describeContents", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "$serializer", "Companion", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Serializable
/* compiled from: LinkedAccountList.kt */
public final class LinkedAccountList implements StripeModel, Parcelable {
    public static final Parcelable.Creator<LinkedAccountList> CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Integer count;
    private final boolean hasMore;
    private final List<LinkedAccount> linkedAccounts;
    private final Integer totalCount;
    private final String url;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LinkedAccountList.kt */
    public static final class Creator implements Parcelable.Creator<LinkedAccountList> {
        public final LinkedAccountList createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i = 0; i != readInt; i++) {
                arrayList.add(LinkedAccount.CREATOR.createFromParcel(parcel));
            }
            return new LinkedAccountList(arrayList, parcel.readInt() != 0, parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
        }

        public final LinkedAccountList[] newArray(int i) {
            return new LinkedAccountList[i];
        }
    }

    public static /* synthetic */ LinkedAccountList copy$default(LinkedAccountList linkedAccountList, List<LinkedAccount> list, boolean z, String str, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = linkedAccountList.linkedAccounts;
        }
        if ((i & 2) != 0) {
            z = linkedAccountList.hasMore;
        }
        boolean z2 = z;
        if ((i & 4) != 0) {
            str = linkedAccountList.url;
        }
        String str2 = str;
        if ((i & 8) != 0) {
            num = linkedAccountList.count;
        }
        Integer num3 = num;
        if ((i & 16) != 0) {
            num2 = linkedAccountList.totalCount;
        }
        return linkedAccountList.copy(list, z2, str2, num3, num2);
    }

    @SerialName("count")
    public static /* synthetic */ void getCount$annotations() {
    }

    @SerialName("has_more")
    public static /* synthetic */ void getHasMore$annotations() {
    }

    @SerialName("data")
    public static /* synthetic */ void getLinkedAccounts$annotations() {
    }

    @SerialName("total_count")
    public static /* synthetic */ void getTotalCount$annotations() {
    }

    @SerialName("url")
    public static /* synthetic */ void getUrl$annotations() {
    }

    public final List<LinkedAccount> component1() {
        return this.linkedAccounts;
    }

    public final boolean component2() {
        return this.hasMore;
    }

    public final String component3() {
        return this.url;
    }

    public final Integer component4() {
        return this.count;
    }

    public final Integer component5() {
        return this.totalCount;
    }

    public final LinkedAccountList copy(List<LinkedAccount> list, boolean z, String str, Integer num, Integer num2) {
        Intrinsics.checkNotNullParameter(list, "linkedAccounts");
        Intrinsics.checkNotNullParameter(str, "url");
        return new LinkedAccountList(list, z, str, num, num2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LinkedAccountList)) {
            return false;
        }
        LinkedAccountList linkedAccountList = (LinkedAccountList) obj;
        return Intrinsics.areEqual((Object) this.linkedAccounts, (Object) linkedAccountList.linkedAccounts) && this.hasMore == linkedAccountList.hasMore && Intrinsics.areEqual((Object) this.url, (Object) linkedAccountList.url) && Intrinsics.areEqual((Object) this.count, (Object) linkedAccountList.count) && Intrinsics.areEqual((Object) this.totalCount, (Object) linkedAccountList.totalCount);
    }

    public int hashCode() {
        int hashCode = this.linkedAccounts.hashCode() * 31;
        boolean z = this.hasMore;
        if (z) {
            z = true;
        }
        int hashCode2 = (((hashCode + (z ? 1 : 0)) * 31) + this.url.hashCode()) * 31;
        Integer num = this.count;
        int i = 0;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.totalCount;
        if (num2 != null) {
            i = num2.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "LinkedAccountList(linkedAccounts=" + this.linkedAccounts + ", hasMore=" + this.hasMore + ", url=" + this.url + ", count=" + this.count + ", totalCount=" + this.totalCount + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        List<LinkedAccount> list = this.linkedAccounts;
        parcel.writeInt(list.size());
        for (LinkedAccount writeToParcel : list) {
            writeToParcel.writeToParcel(parcel, i);
        }
        parcel.writeInt(this.hasMore ? 1 : 0);
        parcel.writeString(this.url);
        Integer num = this.count;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        Integer num2 = this.totalCount;
        if (num2 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(num2.intValue());
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/connections/model/LinkedAccountList$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/stripe/android/connections/model/LinkedAccountList;", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LinkedAccountList.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<LinkedAccountList> serializer() {
            return LinkedAccountList$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ LinkedAccountList(int i, @SerialName("data") List list, @SerialName("has_more") boolean z, @SerialName("url") String str, @SerialName("count") Integer num, @SerialName("total_count") Integer num2, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i, 7, LinkedAccountList$$serializer.INSTANCE.getDescriptor());
        }
        this.linkedAccounts = list;
        this.hasMore = z;
        this.url = str;
        if ((i & 8) == 0) {
            this.count = null;
        } else {
            this.count = num;
        }
        if ((i & 16) == 0) {
            this.totalCount = null;
        } else {
            this.totalCount = num2;
        }
    }

    public LinkedAccountList(List<LinkedAccount> list, boolean z, String str, Integer num, Integer num2) {
        Intrinsics.checkNotNullParameter(list, "linkedAccounts");
        Intrinsics.checkNotNullParameter(str, "url");
        this.linkedAccounts = list;
        this.hasMore = z;
        this.url = str;
        this.count = num;
        this.totalCount = num2;
    }

    @JvmStatic
    public static final void write$Self(LinkedAccountList linkedAccountList, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(linkedAccountList, "self");
        Intrinsics.checkNotNullParameter(compositeEncoder, "output");
        Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
        boolean z = false;
        compositeEncoder.encodeSerializableElement(serialDescriptor, 0, new ArrayListSerializer(LinkedAccount$$serializer.INSTANCE), linkedAccountList.linkedAccounts);
        compositeEncoder.encodeBooleanElement(serialDescriptor, 1, linkedAccountList.hasMore);
        compositeEncoder.encodeStringElement(serialDescriptor, 2, linkedAccountList.url);
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 3) || linkedAccountList.count != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 3, IntSerializer.INSTANCE, linkedAccountList.count);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 4) || linkedAccountList.totalCount != null) {
            z = true;
        }
        if (z) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 4, IntSerializer.INSTANCE, linkedAccountList.totalCount);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LinkedAccountList(List list, boolean z, String str, Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, z, str, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : num2);
    }

    public final List<LinkedAccount> getLinkedAccounts() {
        return this.linkedAccounts;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final String getUrl() {
        return this.url;
    }

    public final Integer getCount() {
        return this.count;
    }

    public final Integer getTotalCount() {
        return this.totalCount;
    }
}
