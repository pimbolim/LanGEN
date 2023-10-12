package com.stripe.android.core.exception;

import com.stripe.android.core.StripeError;
import com.stripe.android.core.exception.APIConnectionException;
import java.io.IOException;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0006\b'\u0018\u0000 \u001d2\u00060\u0001j\u0002`\u0002:\u0001\u001dB?\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\fJ\u0013\u0010\u0016\u001a\u00020\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\b\u0010\u0019\u001a\u00020\bH\u0016J\b\u0010\u001a\u001a\u00020\u0006H\u0016J\u0010\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u0000H\u0002R\u0016\u0010\r\u001a\u00020\u000e8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001e"}, d2 = {"Lcom/stripe/android/core/exception/StripeException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "stripeError", "Lcom/stripe/android/core/StripeError;", "requestId", "", "statusCode", "", "cause", "", "message", "(Lcom/stripe/android/core/StripeError;Ljava/lang/String;ILjava/lang/Throwable;Ljava/lang/String;)V", "isClientError", "", "()Z", "getRequestId", "()Ljava/lang/String;", "getStatusCode", "()I", "getStripeError", "()Lcom/stripe/android/core/StripeError;", "equals", "other", "", "hashCode", "toString", "typedEquals", "ex", "Companion", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StripeException.kt */
public abstract class StripeException extends Exception {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final boolean isClientError;
    private final String requestId;
    private final int statusCode;
    private final StripeError stripeError;

    public StripeException() {
        this((StripeError) null, (String) null, 0, (Throwable) null, (String) null, 31, (DefaultConstructorMarker) null);
    }

    public final StripeError getStripeError() {
        return this.stripeError;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ StripeException(com.stripe.android.core.StripeError r5, java.lang.String r6, int r7, java.lang.Throwable r8, java.lang.String r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 0
            if (r11 == 0) goto L_0x0007
            r11 = r0
            goto L_0x0008
        L_0x0007:
            r11 = r5
        L_0x0008:
            r5 = r10 & 2
            if (r5 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r6
        L_0x000f:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0016
            r7 = 0
            r2 = 0
            goto L_0x0017
        L_0x0016:
            r2 = r7
        L_0x0017:
            r5 = r10 & 8
            if (r5 == 0) goto L_0x001d
            r3 = r0
            goto L_0x001e
        L_0x001d:
            r3 = r8
        L_0x001e:
            r5 = r10 & 16
            if (r5 == 0) goto L_0x002b
            if (r11 != 0) goto L_0x0026
            r9 = r0
            goto L_0x002b
        L_0x0026:
            java.lang.String r5 = r11.getMessage()
            r9 = r5
        L_0x002b:
            r10 = r9
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.core.exception.StripeException.<init>(com.stripe.android.core.StripeError, java.lang.String, int, java.lang.Throwable, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public StripeException(StripeError stripeError2, String str, int i, Throwable th, String str2) {
        super(str2, th);
        this.stripeError = stripeError2;
        this.requestId = str;
        this.statusCode = i;
        boolean z = false;
        if (400 <= i && i < 500) {
            z = true;
        }
        this.isClientError = z;
    }

    public final boolean isClientError() {
        return this.isClientError;
    }

    public String toString() {
        String[] strArr = new String[2];
        String str = this.requestId;
        strArr[0] = str == null ? null : Intrinsics.stringPlus("Request-id: ", str);
        strArr[1] = super.toString();
        return CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull((T[]) strArr), "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StripeException) {
            return typedEquals((StripeException) obj);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.stripeError, this.requestId, Integer.valueOf(this.statusCode), getMessage()});
    }

    private final boolean typedEquals(StripeException stripeException) {
        return Intrinsics.areEqual((Object) this.stripeError, (Object) stripeException.stripeError) && Intrinsics.areEqual((Object) this.requestId, (Object) stripeException.requestId) && this.statusCode == stripeException.statusCode && Intrinsics.areEqual((Object) getMessage(), (Object) stripeException.getMessage());
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/core/exception/StripeException$Companion;", "", "()V", "create", "Lcom/stripe/android/core/exception/StripeException;", "throwable", "", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StripeException.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final StripeException create(Throwable th) {
            Intrinsics.checkNotNullParameter(th, "throwable");
            if (th instanceof StripeException) {
                return (StripeException) th;
            }
            if (th instanceof JSONException) {
                return new APIException(th);
            }
            if (th instanceof IOException) {
                return APIConnectionException.Companion.create$default(APIConnectionException.Companion, (IOException) th, (String) null, 2, (Object) null);
            }
            if (th instanceof IllegalArgumentException) {
                return new InvalidRequestException((StripeError) null, (String) null, 0, th.getMessage(), th, 7, (DefaultConstructorMarker) null);
            }
            return new APIException(th);
        }
    }
}
