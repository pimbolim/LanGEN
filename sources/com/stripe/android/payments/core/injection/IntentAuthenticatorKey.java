package com.stripe.android.payments.core.injection;

import com.stripe.android.model.StripeIntent;
import dagger.MapKey;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Retention;

@Target({ElementType.METHOD})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.FUNCTION})
@MapKey
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0010\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003R\u0017\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/payments/core/injection/IntentAuthenticatorKey;", "", "value", "Lkotlin/reflect/KClass;", "Lcom/stripe/android/model/StripeIntent$NextActionData;", "()Ljava/lang/Class;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Retention(AnnotationRetention.RUNTIME)
@java.lang.annotation.Retention(RetentionPolicy.RUNTIME)
/* compiled from: AuthenticationAnnotations.kt */
public @interface IntentAuthenticatorKey {
    Class<? extends StripeIntent.NextActionData> value();
}
