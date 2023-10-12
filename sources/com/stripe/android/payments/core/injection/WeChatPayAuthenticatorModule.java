package com.stripe.android.payments.core.injection;

import dagger.Module;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001b\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/stripe/android/payments/core/injection/WeChatPayAuthenticatorModule;", "", "()V", "provideWeChatAuthenticator", "Lcom/stripe/android/payments/core/authentication/PaymentAuthenticator;", "Lcom/stripe/android/model/StripeIntent;", "unsupportedAuthenticator", "Lcom/stripe/android/payments/core/authentication/UnsupportedAuthenticator;", "provideWeChatAuthenticator$payments_core_release", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* compiled from: WeChatPayAuthenticatorModule.kt */
public final class WeChatPayAuthenticatorModule {
    /* JADX WARNING: Incorrect type for immutable var: ssa=com.stripe.android.payments.core.authentication.UnsupportedAuthenticator, code=java.lang.Object, for r4v0, types: [com.stripe.android.payments.core.authentication.UnsupportedAuthenticator, java.lang.Object] */
    @com.stripe.android.payments.core.injection.IntentAuthenticatorMap
    @dagger.multibindings.IntoMap
    @com.stripe.android.payments.core.injection.IntentAuthenticatorKey(com.stripe.android.model.StripeIntent.NextActionData.WeChatPayRedirect.class)
    @dagger.Provides
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.stripe.android.payments.core.authentication.PaymentAuthenticator<com.stripe.android.model.StripeIntent> provideWeChatAuthenticator$payments_core_release(java.lang.Object r4) {
        /*
            r3 = this;
            java.lang.String r0 = "unsupportedAuthenticator"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x002e }
            r0 = r3
            com.stripe.android.payments.core.injection.WeChatPayAuthenticatorModule r0 = (com.stripe.android.payments.core.injection.WeChatPayAuthenticatorModule) r0     // Catch:{ all -> 0x002e }
            java.lang.String r0 = "com.stripe.android.payments.wechatpay.WeChatPayAuthenticator"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ all -> 0x002e }
            r1 = 0
            java.lang.Class[] r2 = new java.lang.Class[r1]     // Catch:{ all -> 0x002e }
            java.lang.reflect.Constructor r0 = r0.getConstructor(r2)     // Catch:{ all -> 0x002e }
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x002e }
            java.lang.Object r0 = r0.newInstance(r1)     // Catch:{ all -> 0x002e }
            if (r0 == 0) goto L_0x0026
            com.stripe.android.payments.core.authentication.PaymentAuthenticator r0 = (com.stripe.android.payments.core.authentication.PaymentAuthenticator) r0     // Catch:{ all -> 0x002e }
            java.lang.Object r0 = kotlin.Result.m4709constructorimpl(r0)     // Catch:{ all -> 0x002e }
            goto L_0x0039
        L_0x0026:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException     // Catch:{ all -> 0x002e }
            java.lang.String r1 = "null cannot be cast to non-null type com.stripe.android.payments.core.authentication.PaymentAuthenticator<com.stripe.android.model.StripeIntent>"
            r0.<init>(r1)     // Catch:{ all -> 0x002e }
            throw r0     // Catch:{ all -> 0x002e }
        L_0x002e:
            r0 = move-exception
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m4709constructorimpl(r0)
        L_0x0039:
            boolean r1 = kotlin.Result.m4715isFailureimpl(r0)
            if (r1 == 0) goto L_0x0040
            goto L_0x0041
        L_0x0040:
            r4 = r0
        L_0x0041:
            com.stripe.android.payments.core.authentication.PaymentAuthenticator r4 = (com.stripe.android.payments.core.authentication.PaymentAuthenticator) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.payments.core.injection.WeChatPayAuthenticatorModule.provideWeChatAuthenticator$payments_core_release(com.stripe.android.payments.core.authentication.UnsupportedAuthenticator):com.stripe.android.payments.core.authentication.PaymentAuthenticator");
    }
}
