package com.stripe.android.model;

import com.paypal.android.sdk.onetouch.core.PayPalLineItem;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/stripe/android/model/CardFunding;", "", "code", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getCode", "()Ljava/lang/String;", "Credit", "Debit", "Prepaid", "Unknown", "Companion", "payments-model_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CardFunding.kt */
public enum CardFunding {
    Credit(PayPalLineItem.KIND_CREDIT),
    Debit(PayPalLineItem.KIND_DEBIT),
    Prepaid("prepaid"),
    Unknown("unknown");
    
    public static final Companion Companion = null;
    private final String code;

    private CardFunding(String str) {
        this.code = str;
    }

    public final String getCode() {
        return this.code;
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/model/CardFunding$Companion;", "", "()V", "fromCode", "Lcom/stripe/android/model/CardFunding;", "code", "", "payments-model_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CardFunding.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CardFunding fromCode(String str) {
            CardFunding[] values = CardFunding.values();
            int length = values.length;
            int i = 0;
            while (i < length) {
                CardFunding cardFunding = values[i];
                i++;
                if (Intrinsics.areEqual((Object) cardFunding.getCode(), (Object) str)) {
                    return cardFunding;
                }
            }
            return null;
        }
    }
}
