package com.stripe.android.payments;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/stripe/android/payments/DefaultReturnUrl;", "", "packageName", "", "(Ljava/lang/String;)V", "value", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DefaultReturnUrl.kt */
public final class DefaultReturnUrl {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String packageName;

    private final String component1() {
        return this.packageName;
    }

    public static /* synthetic */ DefaultReturnUrl copy$default(DefaultReturnUrl defaultReturnUrl, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = defaultReturnUrl.packageName;
        }
        return defaultReturnUrl.copy(str);
    }

    public final DefaultReturnUrl copy(String str) {
        Intrinsics.checkNotNullParameter(str, "packageName");
        return new DefaultReturnUrl(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DefaultReturnUrl) && Intrinsics.areEqual((Object) this.packageName, (Object) ((DefaultReturnUrl) obj).packageName);
    }

    public int hashCode() {
        return this.packageName.hashCode();
    }

    public String toString() {
        return "DefaultReturnUrl(packageName=" + this.packageName + ')';
    }

    public DefaultReturnUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "packageName");
        this.packageName = str;
    }

    public final String getValue() {
        return Intrinsics.stringPlus("stripesdk://payment_return_url/", this.packageName);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/payments/DefaultReturnUrl$Companion;", "", "()V", "create", "Lcom/stripe/android/payments/DefaultReturnUrl;", "context", "Landroid/content/Context;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DefaultReturnUrl.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DefaultReturnUrl create(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            String packageName = context.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
            return new DefaultReturnUrl(packageName);
        }
    }
}
