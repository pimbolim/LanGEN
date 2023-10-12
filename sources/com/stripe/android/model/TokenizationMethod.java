package com.stripe.android.model;

import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0015\b\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/model/TokenizationMethod;", "", "code", "", "", "(Ljava/lang/String;ILjava/util/Set;)V", "ApplePay", "GooglePay", "Masterpass", "VisaCheckout", "Companion", "payments-model_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TokenizationMethod.kt */
public enum TokenizationMethod {
    ApplePay(SetsKt.setOf("apple_pay")),
    GooglePay(SetsKt.setOf("android_pay", "google")),
    Masterpass(SetsKt.setOf("masterpass")),
    VisaCheckout(SetsKt.setOf("visa_checkout"));
    
    public static final Companion Companion = null;
    /* access modifiers changed from: private */
    public final Set<String> code;

    private TokenizationMethod(Set<String> set) {
        this.code = set;
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/model/TokenizationMethod$Companion;", "", "()V", "fromCode", "Lcom/stripe/android/model/TokenizationMethod;", "code", "", "payments-model_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TokenizationMethod.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TokenizationMethod fromCode(String str) {
            TokenizationMethod[] values = TokenizationMethod.values();
            int length = values.length;
            int i = 0;
            while (i < length) {
                TokenizationMethod tokenizationMethod = values[i];
                i++;
                if (CollectionsKt.contains(tokenizationMethod.code, str)) {
                    return tokenizationMethod;
                }
            }
            return null;
        }
    }
}
