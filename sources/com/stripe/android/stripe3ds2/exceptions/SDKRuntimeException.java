package com.stripe.android.stripe3ds2.exceptions;

import com.braintreepayments.api.internal.GraphQLConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/stripe/android/stripe3ds2/exceptions/SDKRuntimeException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "t", "", "(Ljava/lang/Throwable;)V", "message", "", "cause", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SDKRuntimeException.kt */
public final class SDKRuntimeException extends RuntimeException {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SDKRuntimeException(String str, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : th);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SDKRuntimeException(String str, Throwable th) {
        super(str, th);
        Intrinsics.checkNotNullParameter(str, GraphQLConstants.Keys.MESSAGE);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SDKRuntimeException(java.lang.Throwable r2) {
        /*
            r1 = this;
            java.lang.String r0 = "t"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = r2.getMessage()
            if (r0 != 0) goto L_0x000d
            java.lang.String r0 = ""
        L_0x000d:
            java.lang.Throwable r2 = r2.getCause()
            r1.<init>(r0, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.stripe3ds2.exceptions.SDKRuntimeException.<init>(java.lang.Throwable):void");
    }
}
