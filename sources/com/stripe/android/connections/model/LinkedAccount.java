package com.stripe.android.connections.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import com.paypal.android.sdk.onetouch.core.PayPalLineItem;
import com.stripe.android.core.model.StripeModel;
import com.stripe.android.stripe3ds2.transactions.MessageExtension;
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
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bB\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\b\u0018\u0000 v2\u00020\u00012\u00020\u00022\u00020\u0003:\u0007tuvwxyzBá\u0001\b\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\u0005\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0001\u0010\f\u001a\u00020\r\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0010\b\u0001\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013\u0012\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0001\u0010\u001b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\u001c\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\u001d\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\u0010\b\u0001\u0010 \u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u0013\u0012\b\u0010\"\u001a\u0004\u0018\u00010#¢\u0006\u0002\u0010$B·\u0001\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u0013¢\u0006\u0002\u0010%J\t\u0010R\u001a\u00020\u0007HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u001fHÆ\u0003J\u0011\u0010Y\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u0013HÆ\u0003J\t\u0010Z\u001a\u00020\u0005HÆ\u0003J\t\u0010[\u001a\u00020\nHÆ\u0003J\t\u0010\\\u001a\u00020\nHÆ\u0003J\t\u0010]\u001a\u00020\rHÆ\u0003J\t\u0010^\u001a\u00020\u000fHÆ\u0003J\t\u0010_\u001a\u00020\u0011HÆ\u0003J\u000f\u0010`\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0016HÆ\u0003JÅ\u0001\u0010b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u0013HÆ\u0001J\t\u0010c\u001a\u00020\u0005HÖ\u0001J\u0013\u0010d\u001a\u00020\r2\b\u0010e\u001a\u0004\u0018\u00010fHÖ\u0003J\t\u0010g\u001a\u00020\u0005HÖ\u0001J\t\u0010h\u001a\u00020\nHÖ\u0001J!\u0010i\u001a\u00020j2\u0006\u0010k\u001a\u00020\u00002\u0006\u0010l\u001a\u00020m2\u0006\u0010n\u001a\u00020oHÇ\u0001J\u0019\u0010p\u001a\u00020j2\u0006\u0010q\u001a\u00020r2\u0006\u0010s\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010'\u001a\u0004\b+\u0010,R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b-\u0010'\u001a\u0004\b.\u0010/R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010'\u001a\u0004\b1\u00102R\u001c\u0010\b\u001a\u00020\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b3\u0010'\u001a\u0004\b4\u00105R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b6\u0010'\u001a\u0004\b7\u00108R\u001c\u0010\t\u001a\u00020\n8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b9\u0010'\u001a\u0004\b:\u00108R\u001c\u0010\u000b\u001a\u00020\n8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b;\u0010'\u001a\u0004\b<\u00108R\u001e\u0010\u001c\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b=\u0010'\u001a\u0004\b>\u00108R\u001c\u0010\f\u001a\u00020\r8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b?\u0010'\u001a\u0004\b@\u0010AR\u001e\u0010\u001d\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bB\u0010'\u001a\u0004\bC\u00108R\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u001f8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bD\u0010'\u001a\u0004\bE\u0010FR$\u0010 \u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u00138\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bG\u0010'\u001a\u0004\bH\u0010IR\u001c\u0010\u000e\u001a\u00020\u000f8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bJ\u0010'\u001a\u0004\bK\u0010LR\u001c\u0010\u0010\u001a\u00020\u00118\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bM\u0010'\u001a\u0004\bN\u0010OR\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bP\u0010'\u001a\u0004\bQ\u0010I¨\u0006{"}, d2 = {"Lcom/stripe/android/connections/model/LinkedAccount;", "Lcom/stripe/android/core/model/StripeModel;", "Landroid/os/Parcelable;", "Lcom/stripe/android/connections/model/PaymentAccount;", "seen1", "", "category", "Lcom/stripe/android/connections/model/LinkedAccount$Category;", "created", "id", "", "institutionName", "livemode", "", "status", "Lcom/stripe/android/connections/model/LinkedAccount$Status;", "subcategory", "Lcom/stripe/android/connections/model/LinkedAccount$Subcategory;", "supportedPaymentMethodTypes", "", "Lcom/stripe/android/connections/model/LinkedAccount$SupportedPaymentMethodTypes;", "accountholder", "Lcom/stripe/android/connections/model/AccountHolder;", "balance", "Lcom/stripe/android/connections/model/Balance;", "balanceRefresh", "Lcom/stripe/android/connections/model/BalanceRefresh;", "displayName", "last4", "ownership", "ownershipRefresh", "Lcom/stripe/android/connections/model/OwnershipRefresh;", "permissions", "Lcom/stripe/android/connections/model/LinkedAccount$Permissions;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/stripe/android/connections/model/LinkedAccount$Category;ILjava/lang/String;Ljava/lang/String;ZLcom/stripe/android/connections/model/LinkedAccount$Status;Lcom/stripe/android/connections/model/LinkedAccount$Subcategory;Ljava/util/List;Lcom/stripe/android/connections/model/AccountHolder;Lcom/stripe/android/connections/model/Balance;Lcom/stripe/android/connections/model/BalanceRefresh;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/connections/model/OwnershipRefresh;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/stripe/android/connections/model/LinkedAccount$Category;ILjava/lang/String;Ljava/lang/String;ZLcom/stripe/android/connections/model/LinkedAccount$Status;Lcom/stripe/android/connections/model/LinkedAccount$Subcategory;Ljava/util/List;Lcom/stripe/android/connections/model/AccountHolder;Lcom/stripe/android/connections/model/Balance;Lcom/stripe/android/connections/model/BalanceRefresh;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/connections/model/OwnershipRefresh;Ljava/util/List;)V", "getAccountholder$annotations", "()V", "getAccountholder", "()Lcom/stripe/android/connections/model/AccountHolder;", "getBalance$annotations", "getBalance", "()Lcom/stripe/android/connections/model/Balance;", "getBalanceRefresh$annotations", "getBalanceRefresh", "()Lcom/stripe/android/connections/model/BalanceRefresh;", "getCategory$annotations", "getCategory", "()Lcom/stripe/android/connections/model/LinkedAccount$Category;", "getCreated$annotations", "getCreated", "()I", "getDisplayName$annotations", "getDisplayName", "()Ljava/lang/String;", "getId$annotations", "getId", "getInstitutionName$annotations", "getInstitutionName", "getLast4$annotations", "getLast4", "getLivemode$annotations", "getLivemode", "()Z", "getOwnership$annotations", "getOwnership", "getOwnershipRefresh$annotations", "getOwnershipRefresh", "()Lcom/stripe/android/connections/model/OwnershipRefresh;", "getPermissions$annotations", "getPermissions", "()Ljava/util/List;", "getStatus$annotations", "getStatus", "()Lcom/stripe/android/connections/model/LinkedAccount$Status;", "getSubcategory$annotations", "getSubcategory", "()Lcom/stripe/android/connections/model/LinkedAccount$Subcategory;", "getSupportedPaymentMethodTypes$annotations", "getSupportedPaymentMethodTypes", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "$serializer", "Category", "Companion", "Permissions", "Status", "Subcategory", "SupportedPaymentMethodTypes", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Serializable
/* compiled from: LinkedAccount.kt */
public final class LinkedAccount extends PaymentAccount implements StripeModel, Parcelable {
    public static final Parcelable.Creator<LinkedAccount> CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String OBJECT = "linked_account";
    private final AccountHolder accountholder;
    private final Balance balance;
    private final BalanceRefresh balanceRefresh;
    private final Category category;
    private final int created;
    private final String displayName;
    private final String id;
    private final String institutionName;
    private final String last4;
    private final boolean livemode;
    private final String ownership;
    private final OwnershipRefresh ownershipRefresh;
    private final List<Permissions> permissions;
    private final Status status;
    private final Subcategory subcategory;
    private final List<SupportedPaymentMethodTypes> supportedPaymentMethodTypes;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LinkedAccount.kt */
    public static final class Creator implements Parcelable.Creator<LinkedAccount> {
        public final LinkedAccount createFromParcel(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "parcel");
            Category valueOf = Category.valueOf(parcel.readString());
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            boolean z = parcel.readInt() != 0;
            Status valueOf2 = Status.valueOf(parcel.readString());
            Subcategory valueOf3 = Subcategory.valueOf(parcel.readString());
            int readInt2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt2);
            for (int i = 0; i != readInt2; i++) {
                arrayList.add(SupportedPaymentMethodTypes.valueOf(parcel.readString()));
            }
            List list = arrayList;
            ArrayList arrayList2 = null;
            AccountHolder createFromParcel = parcel.readInt() == 0 ? null : AccountHolder.CREATOR.createFromParcel(parcel2);
            Balance createFromParcel2 = parcel.readInt() == 0 ? null : Balance.CREATOR.createFromParcel(parcel2);
            BalanceRefresh createFromParcel3 = parcel.readInt() == 0 ? null : BalanceRefresh.CREATOR.createFromParcel(parcel2);
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            OwnershipRefresh createFromParcel4 = parcel.readInt() == 0 ? null : OwnershipRefresh.CREATOR.createFromParcel(parcel2);
            if (parcel.readInt() != 0) {
                int readInt3 = parcel.readInt();
                arrayList2 = new ArrayList(readInt3);
                int i2 = 0;
                while (i2 != readInt3) {
                    arrayList2.add(Permissions.valueOf(parcel.readString()));
                    i2++;
                    readInt3 = readInt3;
                }
            }
            return new LinkedAccount(valueOf, readInt, readString, readString2, z, valueOf2, valueOf3, list, createFromParcel, createFromParcel2, createFromParcel3, readString3, readString4, readString5, createFromParcel4, arrayList2);
        }

        public final LinkedAccount[] newArray(int i) {
            return new LinkedAccount[i];
        }
    }

    public static /* synthetic */ LinkedAccount copy$default(LinkedAccount linkedAccount, Category category2, int i, String str, String str2, boolean z, Status status2, Subcategory subcategory2, List list, AccountHolder accountHolder, Balance balance2, BalanceRefresh balanceRefresh2, String str3, String str4, String str5, OwnershipRefresh ownershipRefresh2, List list2, int i2, Object obj) {
        LinkedAccount linkedAccount2 = linkedAccount;
        int i3 = i2;
        return linkedAccount.copy((i3 & 1) != 0 ? linkedAccount2.category : category2, (i3 & 2) != 0 ? linkedAccount2.created : i, (i3 & 4) != 0 ? linkedAccount2.id : str, (i3 & 8) != 0 ? linkedAccount2.institutionName : str2, (i3 & 16) != 0 ? linkedAccount2.livemode : z, (i3 & 32) != 0 ? linkedAccount2.status : status2, (i3 & 64) != 0 ? linkedAccount2.subcategory : subcategory2, (i3 & 128) != 0 ? linkedAccount2.supportedPaymentMethodTypes : list, (i3 & 256) != 0 ? linkedAccount2.accountholder : accountHolder, (i3 & 512) != 0 ? linkedAccount2.balance : balance2, (i3 & 1024) != 0 ? linkedAccount2.balanceRefresh : balanceRefresh2, (i3 & 2048) != 0 ? linkedAccount2.displayName : str3, (i3 & 4096) != 0 ? linkedAccount2.last4 : str4, (i3 & 8192) != 0 ? linkedAccount2.ownership : str5, (i3 & 16384) != 0 ? linkedAccount2.ownershipRefresh : ownershipRefresh2, (i3 & 32768) != 0 ? linkedAccount2.permissions : list2);
    }

    @SerialName("accountholder")
    public static /* synthetic */ void getAccountholder$annotations() {
    }

    @SerialName("balance")
    public static /* synthetic */ void getBalance$annotations() {
    }

    @SerialName("balance_refresh")
    public static /* synthetic */ void getBalanceRefresh$annotations() {
    }

    @SerialName("category")
    public static /* synthetic */ void getCategory$annotations() {
    }

    @SerialName("created")
    public static /* synthetic */ void getCreated$annotations() {
    }

    @SerialName("display_name")
    public static /* synthetic */ void getDisplayName$annotations() {
    }

    @SerialName("id")
    public static /* synthetic */ void getId$annotations() {
    }

    @SerialName("institution_name")
    public static /* synthetic */ void getInstitutionName$annotations() {
    }

    @SerialName("last4")
    public static /* synthetic */ void getLast4$annotations() {
    }

    @SerialName("livemode")
    public static /* synthetic */ void getLivemode$annotations() {
    }

    @SerialName("ownership")
    public static /* synthetic */ void getOwnership$annotations() {
    }

    @SerialName("ownership_refresh")
    public static /* synthetic */ void getOwnershipRefresh$annotations() {
    }

    @SerialName("permissions")
    public static /* synthetic */ void getPermissions$annotations() {
    }

    @SerialName("status")
    public static /* synthetic */ void getStatus$annotations() {
    }

    @SerialName("subcategory")
    public static /* synthetic */ void getSubcategory$annotations() {
    }

    @SerialName("supported_payment_method_types")
    public static /* synthetic */ void getSupportedPaymentMethodTypes$annotations() {
    }

    public final Category component1() {
        return this.category;
    }

    public final Balance component10() {
        return this.balance;
    }

    public final BalanceRefresh component11() {
        return this.balanceRefresh;
    }

    public final String component12() {
        return this.displayName;
    }

    public final String component13() {
        return this.last4;
    }

    public final String component14() {
        return this.ownership;
    }

    public final OwnershipRefresh component15() {
        return this.ownershipRefresh;
    }

    public final List<Permissions> component16() {
        return this.permissions;
    }

    public final int component2() {
        return this.created;
    }

    public final String component3() {
        return this.id;
    }

    public final String component4() {
        return this.institutionName;
    }

    public final boolean component5() {
        return this.livemode;
    }

    public final Status component6() {
        return this.status;
    }

    public final Subcategory component7() {
        return this.subcategory;
    }

    public final List<SupportedPaymentMethodTypes> component8() {
        return this.supportedPaymentMethodTypes;
    }

    public final AccountHolder component9() {
        return this.accountholder;
    }

    public final LinkedAccount copy(Category category2, int i, String str, String str2, boolean z, Status status2, Subcategory subcategory2, List<? extends SupportedPaymentMethodTypes> list, AccountHolder accountHolder, Balance balance2, BalanceRefresh balanceRefresh2, String str3, String str4, String str5, OwnershipRefresh ownershipRefresh2, List<? extends Permissions> list2) {
        Category category3 = category2;
        Intrinsics.checkNotNullParameter(category3, "category");
        Intrinsics.checkNotNullParameter(str, MessageExtension.FIELD_ID);
        Intrinsics.checkNotNullParameter(str2, "institutionName");
        Intrinsics.checkNotNullParameter(status2, NotificationCompat.CATEGORY_STATUS);
        Intrinsics.checkNotNullParameter(subcategory2, "subcategory");
        Intrinsics.checkNotNullParameter(list, "supportedPaymentMethodTypes");
        return new LinkedAccount(category3, i, str, str2, z, status2, subcategory2, list, accountHolder, balance2, balanceRefresh2, str3, str4, str5, ownershipRefresh2, list2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LinkedAccount)) {
            return false;
        }
        LinkedAccount linkedAccount = (LinkedAccount) obj;
        return this.category == linkedAccount.category && this.created == linkedAccount.created && Intrinsics.areEqual((Object) this.id, (Object) linkedAccount.id) && Intrinsics.areEqual((Object) this.institutionName, (Object) linkedAccount.institutionName) && this.livemode == linkedAccount.livemode && this.status == linkedAccount.status && this.subcategory == linkedAccount.subcategory && Intrinsics.areEqual((Object) this.supportedPaymentMethodTypes, (Object) linkedAccount.supportedPaymentMethodTypes) && Intrinsics.areEqual((Object) this.accountholder, (Object) linkedAccount.accountholder) && Intrinsics.areEqual((Object) this.balance, (Object) linkedAccount.balance) && Intrinsics.areEqual((Object) this.balanceRefresh, (Object) linkedAccount.balanceRefresh) && Intrinsics.areEqual((Object) this.displayName, (Object) linkedAccount.displayName) && Intrinsics.areEqual((Object) this.last4, (Object) linkedAccount.last4) && Intrinsics.areEqual((Object) this.ownership, (Object) linkedAccount.ownership) && Intrinsics.areEqual((Object) this.ownershipRefresh, (Object) linkedAccount.ownershipRefresh) && Intrinsics.areEqual((Object) this.permissions, (Object) linkedAccount.permissions);
    }

    public int hashCode() {
        int hashCode = ((((((this.category.hashCode() * 31) + this.created) * 31) + this.id.hashCode()) * 31) + this.institutionName.hashCode()) * 31;
        boolean z = this.livemode;
        if (z) {
            z = true;
        }
        int hashCode2 = (((((((hashCode + (z ? 1 : 0)) * 31) + this.status.hashCode()) * 31) + this.subcategory.hashCode()) * 31) + this.supportedPaymentMethodTypes.hashCode()) * 31;
        AccountHolder accountHolder = this.accountholder;
        int i = 0;
        int hashCode3 = (hashCode2 + (accountHolder == null ? 0 : accountHolder.hashCode())) * 31;
        Balance balance2 = this.balance;
        int hashCode4 = (hashCode3 + (balance2 == null ? 0 : balance2.hashCode())) * 31;
        BalanceRefresh balanceRefresh2 = this.balanceRefresh;
        int hashCode5 = (hashCode4 + (balanceRefresh2 == null ? 0 : balanceRefresh2.hashCode())) * 31;
        String str = this.displayName;
        int hashCode6 = (hashCode5 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.last4;
        int hashCode7 = (hashCode6 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.ownership;
        int hashCode8 = (hashCode7 + (str3 == null ? 0 : str3.hashCode())) * 31;
        OwnershipRefresh ownershipRefresh2 = this.ownershipRefresh;
        int hashCode9 = (hashCode8 + (ownershipRefresh2 == null ? 0 : ownershipRefresh2.hashCode())) * 31;
        List<Permissions> list = this.permissions;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode9 + i;
    }

    public String toString() {
        return "LinkedAccount(category=" + this.category + ", created=" + this.created + ", id=" + this.id + ", institutionName=" + this.institutionName + ", livemode=" + this.livemode + ", status=" + this.status + ", subcategory=" + this.subcategory + ", supportedPaymentMethodTypes=" + this.supportedPaymentMethodTypes + ", accountholder=" + this.accountholder + ", balance=" + this.balance + ", balanceRefresh=" + this.balanceRefresh + ", displayName=" + this.displayName + ", last4=" + this.last4 + ", ownership=" + this.ownership + ", ownershipRefresh=" + this.ownershipRefresh + ", permissions=" + this.permissions + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.category.name());
        parcel.writeInt(this.created);
        parcel.writeString(this.id);
        parcel.writeString(this.institutionName);
        parcel.writeInt(this.livemode ? 1 : 0);
        parcel.writeString(this.status.name());
        parcel.writeString(this.subcategory.name());
        List<SupportedPaymentMethodTypes> list = this.supportedPaymentMethodTypes;
        parcel.writeInt(list.size());
        for (SupportedPaymentMethodTypes name : list) {
            parcel.writeString(name.name());
        }
        AccountHolder accountHolder = this.accountholder;
        if (accountHolder == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            accountHolder.writeToParcel(parcel, i);
        }
        Balance balance2 = this.balance;
        if (balance2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            balance2.writeToParcel(parcel, i);
        }
        BalanceRefresh balanceRefresh2 = this.balanceRefresh;
        if (balanceRefresh2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            balanceRefresh2.writeToParcel(parcel, i);
        }
        parcel.writeString(this.displayName);
        parcel.writeString(this.last4);
        parcel.writeString(this.ownership);
        OwnershipRefresh ownershipRefresh2 = this.ownershipRefresh;
        if (ownershipRefresh2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            ownershipRefresh2.writeToParcel(parcel, i);
        }
        List<Permissions> list2 = this.permissions;
        if (list2 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(list2.size());
        for (Permissions name2 : list2) {
            parcel.writeString(name2.name());
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ LinkedAccount(int i, @SerialName("category") Category category2, @SerialName("created") int i2, @SerialName("id") String str, @SerialName("institution_name") String str2, @SerialName("livemode") boolean z, @SerialName("status") Status status2, @SerialName("subcategory") Subcategory subcategory2, @SerialName("supported_payment_method_types") List list, @SerialName("accountholder") AccountHolder accountHolder, @SerialName("balance") Balance balance2, @SerialName("balance_refresh") BalanceRefresh balanceRefresh2, @SerialName("display_name") String str3, @SerialName("last4") String str4, @SerialName("ownership") String str5, @SerialName("ownership_refresh") OwnershipRefresh ownershipRefresh2, @SerialName("permissions") List list2, SerializationConstructorMarker serializationConstructorMarker) {
        super((DefaultConstructorMarker) null);
        Category category3;
        Status status3;
        Subcategory subcategory3;
        int i3 = i;
        if (158 != (i3 & 158)) {
            PluginExceptionsKt.throwMissingFieldException(i, 158, LinkedAccount$$serializer.INSTANCE.getDescriptor());
        }
        if ((i3 & 1) == 0) {
            category3 = Category.UNKNOWN;
        } else {
            category3 = category2;
        }
        this.category = category3;
        this.created = i2;
        this.id = str;
        this.institutionName = str2;
        this.livemode = z;
        if ((i3 & 32) == 0) {
            status3 = Status.UNKNOWN;
        } else {
            status3 = status2;
        }
        this.status = status3;
        if ((i3 & 64) == 0) {
            subcategory3 = Subcategory.UNKNOWN;
        } else {
            subcategory3 = subcategory2;
        }
        this.subcategory = subcategory3;
        this.supportedPaymentMethodTypes = list;
        if ((i3 & 256) == 0) {
            this.accountholder = null;
        } else {
            this.accountholder = accountHolder;
        }
        if ((i3 & 512) == 0) {
            this.balance = null;
        } else {
            this.balance = balance2;
        }
        if ((i3 & 1024) == 0) {
            this.balanceRefresh = null;
        } else {
            this.balanceRefresh = balanceRefresh2;
        }
        if ((i3 & 2048) == 0) {
            this.displayName = null;
        } else {
            this.displayName = str3;
        }
        if ((i3 & 4096) == 0) {
            this.last4 = null;
        } else {
            this.last4 = str4;
        }
        if ((i3 & 8192) == 0) {
            this.ownership = null;
        } else {
            this.ownership = str5;
        }
        if ((i3 & 16384) == 0) {
            this.ownershipRefresh = null;
        } else {
            this.ownershipRefresh = ownershipRefresh2;
        }
        if ((i3 & 32768) == 0) {
            this.permissions = null;
        } else {
            this.permissions = list2;
        }
    }

    @JvmStatic
    public static final void write$Self(LinkedAccount linkedAccount, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(linkedAccount, "self");
        Intrinsics.checkNotNullParameter(compositeEncoder, "output");
        Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
        boolean z3 = false;
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 0) || linkedAccount.category != Category.UNKNOWN) {
            compositeEncoder.encodeSerializableElement(serialDescriptor, 0, LinkedAccount$Category$$serializer.INSTANCE, linkedAccount.category);
        }
        compositeEncoder.encodeIntElement(serialDescriptor, 1, linkedAccount.created);
        compositeEncoder.encodeStringElement(serialDescriptor, 2, linkedAccount.id);
        compositeEncoder.encodeStringElement(serialDescriptor, 3, linkedAccount.institutionName);
        compositeEncoder.encodeBooleanElement(serialDescriptor, 4, linkedAccount.livemode);
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 5) && linkedAccount.status == Status.UNKNOWN) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            compositeEncoder.encodeSerializableElement(serialDescriptor, 5, LinkedAccount$Status$$serializer.INSTANCE, linkedAccount.status);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 6) && linkedAccount.subcategory == Subcategory.UNKNOWN) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            compositeEncoder.encodeSerializableElement(serialDescriptor, 6, LinkedAccount$Subcategory$$serializer.INSTANCE, linkedAccount.subcategory);
        }
        compositeEncoder.encodeSerializableElement(serialDescriptor, 7, new ArrayListSerializer(LinkedAccount$SupportedPaymentMethodTypes$$serializer.INSTANCE), linkedAccount.supportedPaymentMethodTypes);
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 8) || linkedAccount.accountholder != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 8, AccountHolder$$serializer.INSTANCE, linkedAccount.accountholder);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 9) || linkedAccount.balance != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 9, Balance$$serializer.INSTANCE, linkedAccount.balance);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 10) || linkedAccount.balanceRefresh != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 10, BalanceRefresh$$serializer.INSTANCE, linkedAccount.balanceRefresh);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 11) || linkedAccount.displayName != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 11, StringSerializer.INSTANCE, linkedAccount.displayName);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 12) || linkedAccount.last4 != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 12, StringSerializer.INSTANCE, linkedAccount.last4);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 13) || linkedAccount.ownership != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 13, StringSerializer.INSTANCE, linkedAccount.ownership);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 14) || linkedAccount.ownershipRefresh != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 14, OwnershipRefresh$$serializer.INSTANCE, linkedAccount.ownershipRefresh);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 15) || linkedAccount.permissions != null) {
            z3 = true;
        }
        if (z3) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 15, new ArrayListSerializer(LinkedAccount$Permissions$$serializer.INSTANCE), linkedAccount.permissions);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ LinkedAccount(com.stripe.android.connections.model.LinkedAccount.Category r20, int r21, java.lang.String r22, java.lang.String r23, boolean r24, com.stripe.android.connections.model.LinkedAccount.Status r25, com.stripe.android.connections.model.LinkedAccount.Subcategory r26, java.util.List r27, com.stripe.android.connections.model.AccountHolder r28, com.stripe.android.connections.model.Balance r29, com.stripe.android.connections.model.BalanceRefresh r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, com.stripe.android.connections.model.OwnershipRefresh r34, java.util.List r35, int r36, kotlin.jvm.internal.DefaultConstructorMarker r37) {
        /*
            r19 = this;
            r0 = r36
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000a
            com.stripe.android.connections.model.LinkedAccount$Category r1 = com.stripe.android.connections.model.LinkedAccount.Category.UNKNOWN
            r3 = r1
            goto L_0x000c
        L_0x000a:
            r3 = r20
        L_0x000c:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0014
            com.stripe.android.connections.model.LinkedAccount$Status r1 = com.stripe.android.connections.model.LinkedAccount.Status.UNKNOWN
            r8 = r1
            goto L_0x0016
        L_0x0014:
            r8 = r25
        L_0x0016:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x001e
            com.stripe.android.connections.model.LinkedAccount$Subcategory r1 = com.stripe.android.connections.model.LinkedAccount.Subcategory.UNKNOWN
            r9 = r1
            goto L_0x0020
        L_0x001e:
            r9 = r26
        L_0x0020:
            r1 = r0 & 256(0x100, float:3.59E-43)
            r2 = 0
            if (r1 == 0) goto L_0x0027
            r11 = r2
            goto L_0x0029
        L_0x0027:
            r11 = r28
        L_0x0029:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x002f
            r12 = r2
            goto L_0x0031
        L_0x002f:
            r12 = r29
        L_0x0031:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x0037
            r13 = r2
            goto L_0x0039
        L_0x0037:
            r13 = r30
        L_0x0039:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x003f
            r14 = r2
            goto L_0x0041
        L_0x003f:
            r14 = r31
        L_0x0041:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x0047
            r15 = r2
            goto L_0x0049
        L_0x0047:
            r15 = r32
        L_0x0049:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x0050
            r16 = r2
            goto L_0x0052
        L_0x0050:
            r16 = r33
        L_0x0052:
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x0059
            r17 = r2
            goto L_0x005b
        L_0x0059:
            r17 = r34
        L_0x005b:
            r1 = 32768(0x8000, float:4.5918E-41)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0064
            r18 = r2
            goto L_0x0066
        L_0x0064:
            r18 = r35
        L_0x0066:
            r2 = r19
            r4 = r21
            r5 = r22
            r6 = r23
            r7 = r24
            r10 = r27
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.connections.model.LinkedAccount.<init>(com.stripe.android.connections.model.LinkedAccount$Category, int, java.lang.String, java.lang.String, boolean, com.stripe.android.connections.model.LinkedAccount$Status, com.stripe.android.connections.model.LinkedAccount$Subcategory, java.util.List, com.stripe.android.connections.model.AccountHolder, com.stripe.android.connections.model.Balance, com.stripe.android.connections.model.BalanceRefresh, java.lang.String, java.lang.String, java.lang.String, com.stripe.android.connections.model.OwnershipRefresh, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Category getCategory() {
        return this.category;
    }

    public final int getCreated() {
        return this.created;
    }

    public final String getId() {
        return this.id;
    }

    public final String getInstitutionName() {
        return this.institutionName;
    }

    public final boolean getLivemode() {
        return this.livemode;
    }

    public final Status getStatus() {
        return this.status;
    }

    public final Subcategory getSubcategory() {
        return this.subcategory;
    }

    public final List<SupportedPaymentMethodTypes> getSupportedPaymentMethodTypes() {
        return this.supportedPaymentMethodTypes;
    }

    public final AccountHolder getAccountholder() {
        return this.accountholder;
    }

    public final Balance getBalance() {
        return this.balance;
    }

    public final BalanceRefresh getBalanceRefresh() {
        return this.balanceRefresh;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getLast4() {
        return this.last4;
    }

    public final String getOwnership() {
        return this.ownership;
    }

    public final OwnershipRefresh getOwnershipRefresh() {
        return this.ownershipRefresh;
    }

    public final List<Permissions> getPermissions() {
        return this.permissions;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LinkedAccount(Category category2, int i, String str, String str2, boolean z, Status status2, Subcategory subcategory2, List<? extends SupportedPaymentMethodTypes> list, AccountHolder accountHolder, Balance balance2, BalanceRefresh balanceRefresh2, String str3, String str4, String str5, OwnershipRefresh ownershipRefresh2, List<? extends Permissions> list2) {
        super((DefaultConstructorMarker) null);
        List<? extends SupportedPaymentMethodTypes> list3 = list;
        Intrinsics.checkNotNullParameter(category2, "category");
        Intrinsics.checkNotNullParameter(str, MessageExtension.FIELD_ID);
        Intrinsics.checkNotNullParameter(str2, "institutionName");
        Intrinsics.checkNotNullParameter(status2, NotificationCompat.CATEGORY_STATUS);
        Intrinsics.checkNotNullParameter(subcategory2, "subcategory");
        Intrinsics.checkNotNullParameter(list3, "supportedPaymentMethodTypes");
        this.category = category2;
        this.created = i;
        this.id = str;
        this.institutionName = str2;
        this.livemode = z;
        this.status = status2;
        this.subcategory = subcategory2;
        this.supportedPaymentMethodTypes = list3;
        this.accountholder = accountHolder;
        this.balance = balance2;
        this.balanceRefresh = balanceRefresh2;
        this.displayName = str3;
        this.last4 = str4;
        this.ownership = str5;
        this.ownershipRefresh = ownershipRefresh2;
        this.permissions = list2;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\f\rB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\u000e"}, d2 = {"Lcom/stripe/android/connections/model/LinkedAccount$Category;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CASH", "CREDIT", "INVESTMENT", "OTHER", "UNKNOWN", "$serializer", "Companion", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Serializable
    /* compiled from: LinkedAccount.kt */
    public enum Category {
        CASH("cash"),
        CREDIT(PayPalLineItem.KIND_CREDIT),
        INVESTMENT("investment"),
        OTHER("other"),
        UNKNOWN("unknown");
        
        public static final Companion Companion = null;
        private final String value;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/connections/model/LinkedAccount$Category$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/stripe/android/connections/model/LinkedAccount$Category;", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: LinkedAccount.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Category> serializer() {
                return LinkedAccount$Category$$serializer.INSTANCE;
            }
        }

        private Category(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u000b\fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\r"}, d2 = {"Lcom/stripe/android/connections/model/LinkedAccount$Status;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "ACTIVE", "DISCONNECTED", "INACTIVE", "UNKNOWN", "$serializer", "Companion", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Serializable
    /* compiled from: LinkedAccount.kt */
    public enum Status {
        ACTIVE("active"),
        DISCONNECTED("disconnected"),
        INACTIVE("inactive"),
        UNKNOWN("unknown");
        
        public static final Companion Companion = null;
        private final String value;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/connections/model/LinkedAccount$Status$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/stripe/android/connections/model/LinkedAccount$Status;", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: LinkedAccount.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Status> serializer() {
                return LinkedAccount$Status$$serializer.INSTANCE;
            }
        }

        private Status(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0001\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u000e\u000fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u0010"}, d2 = {"Lcom/stripe/android/connections/model/LinkedAccount$Subcategory;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CHECKING", "CREDIT_CARD", "LINE_OF_CREDIT", "MORTGAGE", "OTHER", "SAVINGS", "UNKNOWN", "$serializer", "Companion", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Serializable
    /* compiled from: LinkedAccount.kt */
    public enum Subcategory {
        CHECKING("checking"),
        CREDIT_CARD("credit_card"),
        LINE_OF_CREDIT("line_of_credit"),
        MORTGAGE("mortgage"),
        OTHER("other"),
        SAVINGS("savings"),
        UNKNOWN("unknown");
        
        public static final Companion Companion = null;
        private final String value;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/connections/model/LinkedAccount$Subcategory$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/stripe/android/connections/model/LinkedAccount$Subcategory;", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: LinkedAccount.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Subcategory> serializer() {
                return LinkedAccount$Subcategory$$serializer.INSTANCE;
            }
        }

        private Subcategory(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\n\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\f"}, d2 = {"Lcom/stripe/android/connections/model/LinkedAccount$SupportedPaymentMethodTypes;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "LINK", "US_BANK_ACCOUNT", "UNKNOWN", "$serializer", "Companion", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Serializable
    /* compiled from: LinkedAccount.kt */
    public enum SupportedPaymentMethodTypes {
        LINK("link"),
        US_BANK_ACCOUNT("us_bank_account"),
        UNKNOWN("unknown");
        
        public static final Companion Companion = null;
        private final String value;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/connections/model/LinkedAccount$SupportedPaymentMethodTypes$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/stripe/android/connections/model/LinkedAccount$SupportedPaymentMethodTypes;", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: LinkedAccount.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<SupportedPaymentMethodTypes> serializer() {
                return LinkedAccount$SupportedPaymentMethodTypes$$serializer.INSTANCE;
            }
        }

        private SupportedPaymentMethodTypes(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0001\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\r\u000eB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000f"}, d2 = {"Lcom/stripe/android/connections/model/LinkedAccount$Permissions;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "BALANCES", "IDENTITY", "OWNERSHIP", "PAYMENT_METHOD", "TRANSACTIONS", "UNKNOWN", "$serializer", "Companion", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Serializable
    /* compiled from: LinkedAccount.kt */
    public enum Permissions {
        BALANCES("balances"),
        IDENTITY(InterpolationAnimatedNode.EXTRAPOLATE_TYPE_IDENTITY),
        OWNERSHIP("ownership"),
        PAYMENT_METHOD("payment_method"),
        TRANSACTIONS("transactions"),
        UNKNOWN("unknown");
        
        public static final Companion Companion = null;
        private final String value;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/connections/model/LinkedAccount$Permissions$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/stripe/android/connections/model/LinkedAccount$Permissions;", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: LinkedAccount.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Permissions> serializer() {
                return LinkedAccount$Permissions$$serializer.INSTANCE;
            }
        }

        private Permissions(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/stripe/android/connections/model/LinkedAccount$Companion;", "", "()V", "OBJECT", "", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/stripe/android/connections/model/LinkedAccount;", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LinkedAccount.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<LinkedAccount> serializer() {
            return LinkedAccount$$serializer.INSTANCE;
        }
    }
}
