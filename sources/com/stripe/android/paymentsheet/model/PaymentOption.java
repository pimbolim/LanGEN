package com.stripe.android.paymentsheet.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.jcajce.util.AnnotatedPrivateKey;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/stripe/android/paymentsheet/model/PaymentOption;", "", "drawableResourceId", "", "label", "", "(ILjava/lang/String;)V", "getDrawableResourceId", "()I", "getLabel", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentOption.kt */
public final class PaymentOption {
    public static final int $stable = 0;
    private final int drawableResourceId;
    private final String label;

    public static /* synthetic */ PaymentOption copy$default(PaymentOption paymentOption, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = paymentOption.drawableResourceId;
        }
        if ((i2 & 2) != 0) {
            str = paymentOption.label;
        }
        return paymentOption.copy(i, str);
    }

    public final int component1() {
        return this.drawableResourceId;
    }

    public final String component2() {
        return this.label;
    }

    public final PaymentOption copy(int i, String str) {
        Intrinsics.checkNotNullParameter(str, AnnotatedPrivateKey.LABEL);
        return new PaymentOption(i, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaymentOption)) {
            return false;
        }
        PaymentOption paymentOption = (PaymentOption) obj;
        return this.drawableResourceId == paymentOption.drawableResourceId && Intrinsics.areEqual((Object) this.label, (Object) paymentOption.label);
    }

    public int hashCode() {
        return (this.drawableResourceId * 31) + this.label.hashCode();
    }

    public String toString() {
        return "PaymentOption(drawableResourceId=" + this.drawableResourceId + ", label=" + this.label + ')';
    }

    public PaymentOption(int i, String str) {
        Intrinsics.checkNotNullParameter(str, AnnotatedPrivateKey.LABEL);
        this.drawableResourceId = i;
        this.label = str;
    }

    public final int getDrawableResourceId() {
        return this.drawableResourceId;
    }

    public final String getLabel() {
        return this.label;
    }
}
