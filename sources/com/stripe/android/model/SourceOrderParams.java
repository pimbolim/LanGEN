package com.stripe.android.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\b\u0018\u0000  2\u00020\u00012\u00020\u0002:\u0003 !\"B%\b\u0007\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0011HÖ\u0001J\u0014\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00150\u0018H\u0016J\t\u0010\u001a\u001a\u00020\u0019HÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0011HÖ\u0001R\u0019\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006#"}, d2 = {"Lcom/stripe/android/model/SourceOrderParams;", "Lcom/stripe/android/model/StripeParamsModel;", "Landroid/os/Parcelable;", "items", "", "Lcom/stripe/android/model/SourceOrderParams$Item;", "shipping", "Lcom/stripe/android/model/SourceOrderParams$Shipping;", "(Ljava/util/List;Lcom/stripe/android/model/SourceOrderParams$Shipping;)V", "getItems", "()Ljava/util/List;", "getShipping", "()Lcom/stripe/android/model/SourceOrderParams$Shipping;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toParamMap", "", "", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "Item", "Shipping", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SourceOrderParams.kt */
public final class SourceOrderParams implements StripeParamsModel, Parcelable {
    public static final int $stable = 8;
    public static final Parcelable.Creator<SourceOrderParams> CREATOR = new Creator();
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final String PARAM_ITEMS = "items";
    @Deprecated
    private static final String PARAM_SHIPPING = "shipping";
    private final List<Item> items;
    private final Shipping shipping;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SourceOrderParams.kt */
    public static final class Creator implements Parcelable.Creator<SourceOrderParams> {
        public final SourceOrderParams createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            Shipping shipping = null;
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                for (int i = 0; i != readInt; i++) {
                    arrayList.add(Item.CREATOR.createFromParcel(parcel));
                }
            }
            List list = arrayList;
            if (parcel.readInt() != 0) {
                shipping = Shipping.CREATOR.createFromParcel(parcel);
            }
            return new SourceOrderParams(list, shipping);
        }

        public final SourceOrderParams[] newArray(int i) {
            return new SourceOrderParams[i];
        }
    }

    public SourceOrderParams() {
        this((List) null, (Shipping) null, 3, (DefaultConstructorMarker) null);
    }

    public SourceOrderParams(List<Item> list) {
        this(list, (Shipping) null, 2, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ SourceOrderParams copy$default(SourceOrderParams sourceOrderParams, List<Item> list, Shipping shipping2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = sourceOrderParams.items;
        }
        if ((i & 2) != 0) {
            shipping2 = sourceOrderParams.shipping;
        }
        return sourceOrderParams.copy(list, shipping2);
    }

    public final List<Item> component1() {
        return this.items;
    }

    public final Shipping component2() {
        return this.shipping;
    }

    public final SourceOrderParams copy(List<Item> list, Shipping shipping2) {
        return new SourceOrderParams(list, shipping2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SourceOrderParams)) {
            return false;
        }
        SourceOrderParams sourceOrderParams = (SourceOrderParams) obj;
        return Intrinsics.areEqual((Object) this.items, (Object) sourceOrderParams.items) && Intrinsics.areEqual((Object) this.shipping, (Object) sourceOrderParams.shipping);
    }

    public int hashCode() {
        List<Item> list = this.items;
        int i = 0;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        Shipping shipping2 = this.shipping;
        if (shipping2 != null) {
            i = shipping2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "SourceOrderParams(items=" + this.items + ", shipping=" + this.shipping + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        List<Item> list = this.items;
        if (list == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            for (Item writeToParcel : list) {
                writeToParcel.writeToParcel(parcel, i);
            }
        }
        Shipping shipping2 = this.shipping;
        if (shipping2 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        shipping2.writeToParcel(parcel, i);
    }

    public SourceOrderParams(List<Item> list, Shipping shipping2) {
        this.items = list;
        this.shipping = shipping2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SourceOrderParams(List list, Shipping shipping2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : shipping2);
    }

    public final List<Item> getItems() {
        return this.items;
    }

    public final Shipping getShipping() {
        return this.shipping;
    }

    public Map<String, Object> toParamMap() {
        Map map;
        Map emptyMap = MapsKt.emptyMap();
        List<Item> list = this.items;
        Map<K, V> map2 = null;
        if (list == null) {
            map = null;
        } else {
            Iterable<Item> iterable = list;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (Item paramMap : iterable) {
                arrayList.add(paramMap.toParamMap());
            }
            map = MapsKt.mapOf(TuplesKt.to(PARAM_ITEMS, (List) arrayList));
        }
        if (map == null) {
            map = MapsKt.emptyMap();
        }
        Map plus = MapsKt.plus(emptyMap, map);
        Shipping shipping2 = this.shipping;
        if (shipping2 != null) {
            map2 = MapsKt.mapOf(TuplesKt.to("shipping", shipping2.toParamMap()));
        }
        if (map2 == null) {
            map2 = MapsKt.emptyMap();
        }
        return MapsKt.plus(plus, (Map) map2);
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0002-.BM\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJV\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u001eJ\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u0006HÖ\u0001J\u0014\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020#0&H\u0016J\t\u0010'\u001a\u00020\bHÖ\u0001J\u0019\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0006HÖ\u0001R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0014\u0010\u000eR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006/"}, d2 = {"Lcom/stripe/android/model/SourceOrderParams$Item;", "Lcom/stripe/android/model/StripeParamsModel;", "Landroid/os/Parcelable;", "type", "Lcom/stripe/android/model/SourceOrderParams$Item$Type;", "amount", "", "currency", "", "description", "parent", "quantity", "(Lcom/stripe/android/model/SourceOrderParams$Item$Type;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getAmount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCurrency", "()Ljava/lang/String;", "getDescription", "getParent", "getQuantity", "getType", "()Lcom/stripe/android/model/SourceOrderParams$Item$Type;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Lcom/stripe/android/model/SourceOrderParams$Item$Type;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/stripe/android/model/SourceOrderParams$Item;", "describeContents", "equals", "", "other", "", "hashCode", "toParamMap", "", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "Type", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SourceOrderParams.kt */
    public static final class Item implements StripeParamsModel, Parcelable {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Item> CREATOR = new Creator();
        private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @Deprecated
        private static final String PARAM_AMOUNT = "amount";
        @Deprecated
        private static final String PARAM_CURRENCY = "currency";
        @Deprecated
        private static final String PARAM_DESCRIPTION = "description";
        @Deprecated
        private static final String PARAM_PARENT = "parent";
        @Deprecated
        private static final String PARAM_QUANTITY = "quantity";
        @Deprecated
        private static final String PARAM_TYPE = "type";
        private final Integer amount;
        private final String currency;
        private final String description;
        private final String parent;
        private final Integer quantity;
        private final Type type;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SourceOrderParams.kt */
        public static final class Creator implements Parcelable.Creator<Item> {
            public final Item createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Item(parcel.readInt() == 0 ? null : Type.valueOf(parcel.readString()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
            }

            public final Item[] newArray(int i) {
                return new Item[i];
            }
        }

        public Item() {
            this((Type) null, (Integer) null, (String) null, (String) null, (String) null, (Integer) null, 63, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ Item copy$default(Item item, Type type2, Integer num, String str, String str2, String str3, Integer num2, int i, Object obj) {
            if ((i & 1) != 0) {
                type2 = item.type;
            }
            if ((i & 2) != 0) {
                num = item.amount;
            }
            Integer num3 = num;
            if ((i & 4) != 0) {
                str = item.currency;
            }
            String str4 = str;
            if ((i & 8) != 0) {
                str2 = item.description;
            }
            String str5 = str2;
            if ((i & 16) != 0) {
                str3 = item.parent;
            }
            String str6 = str3;
            if ((i & 32) != 0) {
                num2 = item.quantity;
            }
            return item.copy(type2, num3, str4, str5, str6, num2);
        }

        public final Type component1() {
            return this.type;
        }

        public final Integer component2() {
            return this.amount;
        }

        public final String component3() {
            return this.currency;
        }

        public final String component4() {
            return this.description;
        }

        public final String component5() {
            return this.parent;
        }

        public final Integer component6() {
            return this.quantity;
        }

        public final Item copy(Type type2, Integer num, String str, String str2, String str3, Integer num2) {
            return new Item(type2, num, str, str2, str3, num2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Item)) {
                return false;
            }
            Item item = (Item) obj;
            return this.type == item.type && Intrinsics.areEqual((Object) this.amount, (Object) item.amount) && Intrinsics.areEqual((Object) this.currency, (Object) item.currency) && Intrinsics.areEqual((Object) this.description, (Object) item.description) && Intrinsics.areEqual((Object) this.parent, (Object) item.parent) && Intrinsics.areEqual((Object) this.quantity, (Object) item.quantity);
        }

        public int hashCode() {
            Type type2 = this.type;
            int i = 0;
            int hashCode = (type2 == null ? 0 : type2.hashCode()) * 31;
            Integer num = this.amount;
            int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
            String str = this.currency;
            int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.description;
            int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.parent;
            int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
            Integer num2 = this.quantity;
            if (num2 != null) {
                i = num2.hashCode();
            }
            return hashCode5 + i;
        }

        public String toString() {
            return "Item(type=" + this.type + ", amount=" + this.amount + ", currency=" + this.currency + ", description=" + this.description + ", parent=" + this.parent + ", quantity=" + this.quantity + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            Type type2 = this.type;
            if (type2 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeString(type2.name());
            }
            Integer num = this.amount;
            if (num == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeInt(num.intValue());
            }
            parcel.writeString(this.currency);
            parcel.writeString(this.description);
            parcel.writeString(this.parent);
            Integer num2 = this.quantity;
            if (num2 == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        }

        public Item(Type type2, Integer num, String str, String str2, String str3, Integer num2) {
            this.type = type2;
            this.amount = num;
            this.currency = str;
            this.description = str2;
            this.parent = str3;
            this.quantity = num2;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ Item(com.stripe.android.model.SourceOrderParams.Item.Type r6, java.lang.Integer r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.Integer r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
            /*
                r5 = this;
                r13 = r12 & 1
                r0 = 0
                if (r13 == 0) goto L_0x0007
                r13 = r0
                goto L_0x0008
            L_0x0007:
                r13 = r6
            L_0x0008:
                r6 = r12 & 2
                if (r6 == 0) goto L_0x000e
                r1 = r0
                goto L_0x000f
            L_0x000e:
                r1 = r7
            L_0x000f:
                r6 = r12 & 4
                if (r6 == 0) goto L_0x0015
                r2 = r0
                goto L_0x0016
            L_0x0015:
                r2 = r8
            L_0x0016:
                r6 = r12 & 8
                if (r6 == 0) goto L_0x001c
                r3 = r0
                goto L_0x001d
            L_0x001c:
                r3 = r9
            L_0x001d:
                r6 = r12 & 16
                if (r6 == 0) goto L_0x0023
                r4 = r0
                goto L_0x0024
            L_0x0023:
                r4 = r10
            L_0x0024:
                r6 = r12 & 32
                if (r6 == 0) goto L_0x002a
                r12 = r0
                goto L_0x002b
            L_0x002a:
                r12 = r11
            L_0x002b:
                r6 = r5
                r7 = r13
                r8 = r1
                r9 = r2
                r10 = r3
                r11 = r4
                r6.<init>(r7, r8, r9, r10, r11, r12)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.model.SourceOrderParams.Item.<init>(com.stripe.android.model.SourceOrderParams$Item$Type, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public final Type getType() {
            return this.type;
        }

        public final Integer getAmount() {
            return this.amount;
        }

        public final String getCurrency() {
            return this.currency;
        }

        public final String getDescription() {
            return this.description;
        }

        public final String getParent() {
            return this.parent;
        }

        public final Integer getQuantity() {
            return this.quantity;
        }

        public Map<String, Object> toParamMap() {
            Map emptyMap = MapsKt.emptyMap();
            Integer num = this.amount;
            Map map = null;
            Map mapOf = num == null ? null : MapsKt.mapOf(TuplesKt.to("amount", Integer.valueOf(num.intValue())));
            if (mapOf == null) {
                mapOf = MapsKt.emptyMap();
            }
            Map plus = MapsKt.plus(emptyMap, mapOf);
            String str = this.currency;
            Map mapOf2 = str == null ? null : MapsKt.mapOf(TuplesKt.to("currency", str));
            if (mapOf2 == null) {
                mapOf2 = MapsKt.emptyMap();
            }
            Map plus2 = MapsKt.plus(plus, mapOf2);
            String str2 = this.description;
            Map mapOf3 = str2 == null ? null : MapsKt.mapOf(TuplesKt.to(PARAM_DESCRIPTION, str2));
            if (mapOf3 == null) {
                mapOf3 = MapsKt.emptyMap();
            }
            Map plus3 = MapsKt.plus(plus2, mapOf3);
            String str3 = this.parent;
            Map mapOf4 = str3 == null ? null : MapsKt.mapOf(TuplesKt.to(PARAM_PARENT, str3));
            if (mapOf4 == null) {
                mapOf4 = MapsKt.emptyMap();
            }
            Map plus4 = MapsKt.plus(plus3, mapOf4);
            Integer num2 = this.quantity;
            Map mapOf5 = num2 == null ? null : MapsKt.mapOf(TuplesKt.to("quantity", Integer.valueOf(num2.intValue())));
            if (mapOf5 == null) {
                mapOf5 = MapsKt.emptyMap();
            }
            Map plus5 = MapsKt.plus(plus4, mapOf5);
            Type type2 = this.type;
            if (type2 != null) {
                map = MapsKt.mapOf(TuplesKt.to("type", type2.getCode$payments_core_release()));
            }
            if (map == null) {
                map = MapsKt.emptyMap();
            }
            return MapsKt.plus(plus5, map);
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/stripe/android/model/SourceOrderParams$Item$Type;", "", "code", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getCode$payments_core_release", "()Ljava/lang/String;", "Sku", "Tax", "Shipping", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SourceOrderParams.kt */
        public enum Type {
            Sku("sku"),
            Tax(FirebaseAnalytics.Param.TAX),
            Shipping("shipping");
            
            private final String code;

            private Type(String str) {
                this.code = str;
            }

            public final String getCode$payments_core_release() {
                return this.code;
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/stripe/android/model/SourceOrderParams$Item$Companion;", "", "()V", "PARAM_AMOUNT", "", "PARAM_CURRENCY", "PARAM_DESCRIPTION", "PARAM_PARENT", "PARAM_QUANTITY", "PARAM_TYPE", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SourceOrderParams.kt */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001'B=\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003JC\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0019HÖ\u0001J\u0014\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001d0 H\u0016J\t\u0010!\u001a\u00020\u0006HÖ\u0001J\u0019\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006("}, d2 = {"Lcom/stripe/android/model/SourceOrderParams$Shipping;", "Lcom/stripe/android/model/StripeParamsModel;", "Landroid/os/Parcelable;", "address", "Lcom/stripe/android/model/Address;", "carrier", "", "name", "phone", "trackingNumber", "(Lcom/stripe/android/model/Address;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAddress", "()Lcom/stripe/android/model/Address;", "getCarrier", "()Ljava/lang/String;", "getName", "getPhone", "getTrackingNumber", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toParamMap", "", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SourceOrderParams.kt */
    public static final class Shipping implements StripeParamsModel, Parcelable {
        public static final int $stable = 0;
        public static final Parcelable.Creator<Shipping> CREATOR = new Creator();
        private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @Deprecated
        private static final String PARAM_ADDRESS = "address";
        @Deprecated
        private static final String PARAM_CARRIER = "carrier";
        @Deprecated
        private static final String PARAM_NAME = "name";
        @Deprecated
        private static final String PARAM_PHONE = "phone";
        @Deprecated
        private static final String PARAM_TRACKING_NUMBER = "tracking_number";
        private final Address address;
        private final String carrier;
        private final String name;
        private final String phone;
        private final String trackingNumber;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SourceOrderParams.kt */
        public static final class Creator implements Parcelable.Creator<Shipping> {
            public final Shipping createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Shipping(Address.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
            }

            public final Shipping[] newArray(int i) {
                return new Shipping[i];
            }
        }

        public static /* synthetic */ Shipping copy$default(Shipping shipping, Address address2, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                address2 = shipping.address;
            }
            if ((i & 2) != 0) {
                str = shipping.carrier;
            }
            String str5 = str;
            if ((i & 4) != 0) {
                str2 = shipping.name;
            }
            String str6 = str2;
            if ((i & 8) != 0) {
                str3 = shipping.phone;
            }
            String str7 = str3;
            if ((i & 16) != 0) {
                str4 = shipping.trackingNumber;
            }
            return shipping.copy(address2, str5, str6, str7, str4);
        }

        public final Address component1() {
            return this.address;
        }

        public final String component2() {
            return this.carrier;
        }

        public final String component3() {
            return this.name;
        }

        public final String component4() {
            return this.phone;
        }

        public final String component5() {
            return this.trackingNumber;
        }

        public final Shipping copy(Address address2, String str, String str2, String str3, String str4) {
            Intrinsics.checkNotNullParameter(address2, "address");
            return new Shipping(address2, str, str2, str3, str4);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Shipping)) {
                return false;
            }
            Shipping shipping = (Shipping) obj;
            return Intrinsics.areEqual((Object) this.address, (Object) shipping.address) && Intrinsics.areEqual((Object) this.carrier, (Object) shipping.carrier) && Intrinsics.areEqual((Object) this.name, (Object) shipping.name) && Intrinsics.areEqual((Object) this.phone, (Object) shipping.phone) && Intrinsics.areEqual((Object) this.trackingNumber, (Object) shipping.trackingNumber);
        }

        public int hashCode() {
            int hashCode = this.address.hashCode() * 31;
            String str = this.carrier;
            int i = 0;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.name;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.phone;
            int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.trackingNumber;
            if (str4 != null) {
                i = str4.hashCode();
            }
            return hashCode4 + i;
        }

        public String toString() {
            return "Shipping(address=" + this.address + ", carrier=" + this.carrier + ", name=" + this.name + ", phone=" + this.phone + ", trackingNumber=" + this.trackingNumber + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            this.address.writeToParcel(parcel, i);
            parcel.writeString(this.carrier);
            parcel.writeString(this.name);
            parcel.writeString(this.phone);
            parcel.writeString(this.trackingNumber);
        }

        public Shipping(Address address2, String str, String str2, String str3, String str4) {
            Intrinsics.checkNotNullParameter(address2, "address");
            this.address = address2;
            this.carrier = str;
            this.name = str2;
            this.phone = str3;
            this.trackingNumber = str4;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Shipping(Address address2, String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(address2, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4);
        }

        public final Address getAddress() {
            return this.address;
        }

        public final String getCarrier() {
            return this.carrier;
        }

        public final String getName() {
            return this.name;
        }

        public final String getPhone() {
            return this.phone;
        }

        public final String getTrackingNumber() {
            return this.trackingNumber;
        }

        public Map<String, Object> toParamMap() {
            Map<K, V> mapOf = MapsKt.mapOf(TuplesKt.to("address", this.address.toParamMap()));
            String str = this.carrier;
            Map map = null;
            Map mapOf2 = str == null ? null : MapsKt.mapOf(TuplesKt.to(PARAM_CARRIER, str));
            if (mapOf2 == null) {
                mapOf2 = MapsKt.emptyMap();
            }
            Map<K, V> plus = MapsKt.plus(mapOf, (Map<K, V>) mapOf2);
            String str2 = this.name;
            Map mapOf3 = str2 == null ? null : MapsKt.mapOf(TuplesKt.to("name", str2));
            if (mapOf3 == null) {
                mapOf3 = MapsKt.emptyMap();
            }
            Map<K, V> plus2 = MapsKt.plus(plus, (Map<K, V>) mapOf3);
            String str3 = this.phone;
            Map mapOf4 = str3 == null ? null : MapsKt.mapOf(TuplesKt.to("phone", str3));
            if (mapOf4 == null) {
                mapOf4 = MapsKt.emptyMap();
            }
            Map<K, V> plus3 = MapsKt.plus(plus2, (Map<K, V>) mapOf4);
            String str4 = this.trackingNumber;
            if (str4 != null) {
                map = MapsKt.mapOf(TuplesKt.to(PARAM_TRACKING_NUMBER, str4));
            }
            if (map == null) {
                map = MapsKt.emptyMap();
            }
            return MapsKt.plus(plus3, (Map<K, V>) map);
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/stripe/android/model/SourceOrderParams$Shipping$Companion;", "", "()V", "PARAM_ADDRESS", "", "PARAM_CARRIER", "PARAM_NAME", "PARAM_PHONE", "PARAM_TRACKING_NUMBER", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SourceOrderParams.kt */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/model/SourceOrderParams$Companion;", "", "()V", "PARAM_ITEMS", "", "PARAM_SHIPPING", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SourceOrderParams.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
