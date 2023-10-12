package com.stripe.android.view;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.core.model.StripeJsonUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0002\u0010\u0011B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u001d\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\u0010\u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\u000fR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/stripe/android/view/BecsDebitBanks;", "", "context", "Landroid/content/Context;", "shouldIncludeTestBank", "", "(Landroid/content/Context;Z)V", "banks", "", "Lcom/stripe/android/view/BecsDebitBanks$Bank;", "(Ljava/util/List;Z)V", "getBanks$payments_core_release", "()Ljava/util/List;", "byPrefix", "bsb", "", "Bank", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BecsDebitBanks.kt */
public final class BecsDebitBanks {
    public static final int $stable = 8;
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final Bank STRIPE_TEST_BANK = new Bank("00", "Stripe Test Bank");
    private final List<Bank> banks;
    private final boolean shouldIncludeTestBank;

    public BecsDebitBanks(List<Bank> list, boolean z) {
        Intrinsics.checkNotNullParameter(list, "banks");
        this.banks = list;
        this.shouldIncludeTestBank = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BecsDebitBanks(List list, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((List<Bank>) list, (i & 2) != 0 ? true : z);
    }

    public final List<Bank> getBanks$payments_core_release() {
        return this.banks;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BecsDebitBanks(Context context, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? true : z);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BecsDebitBanks(Context context, boolean z) {
        this((List<Bank>) Companion.createBanksData(context), z);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.stripe.android.view.BecsDebitBanks$Bank} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.stripe.android.view.BecsDebitBanks$Bank} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: com.stripe.android.view.BecsDebitBanks$Bank} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.stripe.android.view.BecsDebitBanks$Bank} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.stripe.android.view.BecsDebitBanks.Bank byPrefix(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = "bsb"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.util.List<com.stripe.android.view.BecsDebitBanks$Bank> r0 = r6.banks
            java.util.Collection r0 = (java.util.Collection) r0
            com.stripe.android.view.BecsDebitBanks$Bank r1 = STRIPE_TEST_BANK
            boolean r2 = r6.shouldIncludeTestBank
            r3 = 0
            if (r2 == 0) goto L_0x0011
            goto L_0x0012
        L_0x0011:
            r1 = r3
        L_0x0012:
            java.util.List r1 = kotlin.collections.CollectionsKt.listOfNotNull(r1)
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.List r0 = kotlin.collections.CollectionsKt.plus(r0, r1)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0022:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x003c
            java.lang.Object r1 = r0.next()
            r2 = r1
            com.stripe.android.view.BecsDebitBanks$Bank r2 = (com.stripe.android.view.BecsDebitBanks.Bank) r2
            java.lang.String r2 = r2.getPrefix()
            r4 = 0
            r5 = 2
            boolean r2 = kotlin.text.StringsKt.startsWith$default(r7, r2, r4, r5, r3)
            if (r2 == 0) goto L_0x0022
            r3 = r1
        L_0x003c:
            com.stripe.android.view.BecsDebitBanks$Bank r3 = (com.stripe.android.view.BecsDebitBanks.Bank) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.view.BecsDebitBanks.byPrefix(java.lang.String):com.stripe.android.view.BecsDebitBanks$Bank");
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/stripe/android/view/BecsDebitBanks$Bank;", "Landroid/os/Parcelable;", "prefix", "", "name", "(Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getPrefix", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BecsDebitBanks.kt */
    public static final class Bank implements Parcelable {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Bank> CREATOR = new Creator();
        private final String name;
        private final String prefix;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: BecsDebitBanks.kt */
        public static final class Creator implements Parcelable.Creator<Bank> {
            public final Bank createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Bank(parcel.readString(), parcel.readString());
            }

            public final Bank[] newArray(int i) {
                return new Bank[i];
            }
        }

        public static /* synthetic */ Bank copy$default(Bank bank, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = bank.prefix;
            }
            if ((i & 2) != 0) {
                str2 = bank.name;
            }
            return bank.copy(str, str2);
        }

        public final String component1() {
            return this.prefix;
        }

        public final String component2() {
            return this.name;
        }

        public final Bank copy(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "prefix");
            Intrinsics.checkNotNullParameter(str2, "name");
            return new Bank(str, str2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Bank)) {
                return false;
            }
            Bank bank = (Bank) obj;
            return Intrinsics.areEqual((Object) this.prefix, (Object) bank.prefix) && Intrinsics.areEqual((Object) this.name, (Object) bank.name);
        }

        public int hashCode() {
            return (this.prefix.hashCode() * 31) + this.name.hashCode();
        }

        public String toString() {
            return "Bank(prefix=" + this.prefix + ", name=" + this.name + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.prefix);
            parcel.writeString(this.name);
        }

        public Bank(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "prefix");
            Intrinsics.checkNotNullParameter(str2, "name");
            this.prefix = str;
            this.name = str2;
        }

        public final String getPrefix() {
            return this.prefix;
        }

        public final String getName() {
            return this.name;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/view/BecsDebitBanks$Companion;", "", "()V", "STRIPE_TEST_BANK", "Lcom/stripe/android/view/BecsDebitBanks$Bank;", "createBanksData", "", "context", "Landroid/content/Context;", "readFile", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BecsDebitBanks.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final List<Bank> createBanksData(Context context) {
            Map jsonObjectToMap = StripeJsonUtils.INSTANCE.jsonObjectToMap(new JSONObject(readFile(context)));
            if (jsonObjectToMap == null) {
                jsonObjectToMap = MapsKt.emptyMap();
            }
            Collection arrayList = new ArrayList(jsonObjectToMap.size());
            for (Map.Entry entry : jsonObjectToMap.entrySet()) {
                arrayList.add(new Bank((String) entry.getKey(), String.valueOf(entry.getValue())));
            }
            return (List) arrayList;
        }

        private final String readFile(Context context) {
            String next = new Scanner(context.getResources().getAssets().open("au_becs_bsb.json")).useDelimiter("\\A").next();
            Intrinsics.checkNotNullExpressionValue(next, "Scanner(\n               …seDelimiter(\"\\\\A\").next()");
            return next;
        }
    }
}
