package com.stripe.android.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.brentvatne.react.ReactVideoView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.stripe.android.core.model.StripeModel;
import java.util.Currency;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.jcajce.util.AnnotatedPrivateKey;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tB3\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u000bHÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J=\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u001cHÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\u0019\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012¨\u0006("}, d2 = {"Lcom/stripe/android/model/ShippingMethod;", "Lcom/stripe/android/core/model/StripeModel;", "label", "", "identifier", "amount", "", "currencyCode", "detail", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "currency", "Ljava/util/Currency;", "(Ljava/lang/String;Ljava/lang/String;JLjava/util/Currency;Ljava/lang/String;)V", "getAmount", "()J", "getCurrency", "()Ljava/util/Currency;", "getDetail", "()Ljava/lang/String;", "getIdentifier", "getLabel", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShippingMethod.kt */
public final class ShippingMethod implements StripeModel {
    public static final int $stable = 8;
    public static final Parcelable.Creator<ShippingMethod> CREATOR = new Creator();
    private final long amount;
    private final Currency currency;
    private final String detail;
    private final String identifier;
    private final String label;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ShippingMethod.kt */
    public static final class Creator implements Parcelable.Creator<ShippingMethod> {
        public final ShippingMethod createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ShippingMethod(parcel.readString(), parcel.readString(), parcel.readLong(), (Currency) parcel.readSerializable(), parcel.readString());
        }

        public final ShippingMethod[] newArray(int i) {
            return new ShippingMethod[i];
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ShippingMethod(String str, String str2, long j, String str3) {
        this(str, str2, j, str3, (String) null, 16, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, AnnotatedPrivateKey.LABEL);
        Intrinsics.checkNotNullParameter(str2, ReactVideoView.EVENT_PROP_METADATA_IDENTIFIER);
        Intrinsics.checkNotNullParameter(str3, "currencyCode");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ShippingMethod(String str, String str2, long j, Currency currency2) {
        this(str, str2, j, currency2, (String) null, 16, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, AnnotatedPrivateKey.LABEL);
        Intrinsics.checkNotNullParameter(str2, ReactVideoView.EVENT_PROP_METADATA_IDENTIFIER);
        Intrinsics.checkNotNullParameter(currency2, FirebaseAnalytics.Param.CURRENCY);
    }

    public static /* synthetic */ ShippingMethod copy$default(ShippingMethod shippingMethod, String str, String str2, long j, Currency currency2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = shippingMethod.label;
        }
        if ((i & 2) != 0) {
            str2 = shippingMethod.identifier;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            j = shippingMethod.amount;
        }
        long j2 = j;
        if ((i & 8) != 0) {
            currency2 = shippingMethod.currency;
        }
        Currency currency3 = currency2;
        if ((i & 16) != 0) {
            str3 = shippingMethod.detail;
        }
        return shippingMethod.copy(str, str4, j2, currency3, str3);
    }

    public final String component1() {
        return this.label;
    }

    public final String component2() {
        return this.identifier;
    }

    public final long component3() {
        return this.amount;
    }

    public final Currency component4() {
        return this.currency;
    }

    public final String component5() {
        return this.detail;
    }

    public final ShippingMethod copy(String str, String str2, long j, Currency currency2, String str3) {
        Intrinsics.checkNotNullParameter(str, AnnotatedPrivateKey.LABEL);
        Intrinsics.checkNotNullParameter(str2, ReactVideoView.EVENT_PROP_METADATA_IDENTIFIER);
        Intrinsics.checkNotNullParameter(currency2, FirebaseAnalytics.Param.CURRENCY);
        return new ShippingMethod(str, str2, j, currency2, str3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShippingMethod)) {
            return false;
        }
        ShippingMethod shippingMethod = (ShippingMethod) obj;
        return Intrinsics.areEqual((Object) this.label, (Object) shippingMethod.label) && Intrinsics.areEqual((Object) this.identifier, (Object) shippingMethod.identifier) && this.amount == shippingMethod.amount && Intrinsics.areEqual((Object) this.currency, (Object) shippingMethod.currency) && Intrinsics.areEqual((Object) this.detail, (Object) shippingMethod.detail);
    }

    public int hashCode() {
        int hashCode = ((((((this.label.hashCode() * 31) + this.identifier.hashCode()) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.amount)) * 31) + this.currency.hashCode()) * 31;
        String str = this.detail;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "ShippingMethod(label=" + this.label + ", identifier=" + this.identifier + ", amount=" + this.amount + ", currency=" + this.currency + ", detail=" + this.detail + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.label);
        parcel.writeString(this.identifier);
        parcel.writeLong(this.amount);
        parcel.writeSerializable(this.currency);
        parcel.writeString(this.detail);
    }

    public ShippingMethod(String str, String str2, long j, Currency currency2, String str3) {
        Intrinsics.checkNotNullParameter(str, AnnotatedPrivateKey.LABEL);
        Intrinsics.checkNotNullParameter(str2, ReactVideoView.EVENT_PROP_METADATA_IDENTIFIER);
        Intrinsics.checkNotNullParameter(currency2, FirebaseAnalytics.Param.CURRENCY);
        this.label = str;
        this.identifier = str2;
        this.amount = j;
        this.currency = currency2;
        this.detail = str3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShippingMethod(String str, String str2, long j, Currency currency2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, j, currency2, (i & 16) != 0 ? null : str3);
    }

    public final String getLabel() {
        return this.label;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final long getAmount() {
        return this.amount;
    }

    public final Currency getCurrency() {
        return this.currency;
    }

    public final String getDetail() {
        return this.detail;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShippingMethod(String str, String str2, long j, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, j, str3, (i & 16) != 0 ? null : str4);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ShippingMethod(java.lang.String r9, java.lang.String r10, long r11, java.lang.String r13, java.lang.String r14) {
        /*
            r8 = this;
            java.lang.String r0 = "label"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "identifier"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "currencyCode"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.util.Currency r6 = java.util.Currency.getInstance(r13)
            java.lang.String r13 = "getInstance(currencyCode)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r13)
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r11
            r7 = r14
            r1.<init>((java.lang.String) r2, (java.lang.String) r3, (long) r4, (java.util.Currency) r6, (java.lang.String) r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.model.ShippingMethod.<init>(java.lang.String, java.lang.String, long, java.lang.String, java.lang.String):void");
    }
}
