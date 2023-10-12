package com.reactnativestripesdk;

import com.facebook.react.bridge.Promise;
import com.nimbusds.jose.jwk.JWKParameterNames;
import com.stripe.android.ApiResultCallback;
import com.stripe.android.model.SetupIntent;
import com.stripe.android.model.StripeIntent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0014\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"com/reactnativestripesdk/PaymentLauncherFragment$retrieveSetupIntent$1", "Lcom/stripe/android/ApiResultCallback;", "Lcom/stripe/android/model/SetupIntent;", "onError", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "result", "stripe_stripe-react-native_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: PaymentLauncherFragment.kt */
public final class PaymentLauncherFragment$retrieveSetupIntent$1 implements ApiResultCallback<SetupIntent> {
    final /* synthetic */ Promise $promise;
    final /* synthetic */ PaymentLauncherFragment this$0;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* compiled from: PaymentLauncherFragment.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StripeIntent.Status.values().length];
            iArr[StripeIntent.Status.Succeeded.ordinal()] = 1;
            iArr[StripeIntent.Status.Processing.ordinal()] = 2;
            iArr[StripeIntent.Status.RequiresConfirmation.ordinal()] = 3;
            iArr[StripeIntent.Status.RequiresCapture.ordinal()] = 4;
            iArr[StripeIntent.Status.RequiresAction.ordinal()] = 5;
            iArr[StripeIntent.Status.RequiresPaymentMethod.ordinal()] = 6;
            iArr[StripeIntent.Status.Canceled.ordinal()] = 7;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    PaymentLauncherFragment$retrieveSetupIntent$1(Promise promise, PaymentLauncherFragment paymentLauncherFragment) {
        this.$promise = promise;
        this.this$0 = paymentLauncherFragment;
    }

    public void onError(Exception exc) {
        Intrinsics.checkNotNullParameter(exc, JWKParameterNames.RSA_EXPONENT);
        this.$promise.resolve(ErrorsKt.createError(ConfirmSetupIntentErrorType.Failed.toString(), exc));
    }

    public void onSuccess(SetupIntent setupIntent) {
        Unit unit;
        Intrinsics.checkNotNullParameter(setupIntent, "result");
        StripeIntent.Status status = setupIntent.getStatus();
        switch (status == null ? -1 : WhenMappings.$EnumSwitchMapping$0[status.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                this.$promise.resolve(MappersKt.createResult("setupIntent", MappersKt.mapFromSetupIntentResult(setupIntent)));
                return;
            case 5:
                if (this.this$0.isNextActionSuccessState(setupIntent.getNextActionType())) {
                    this.$promise.resolve(MappersKt.createResult("setupIntent", MappersKt.mapFromSetupIntentResult(setupIntent)));
                    return;
                }
                SetupIntent.Error lastSetupError = setupIntent.getLastSetupError();
                if (lastSetupError == null) {
                    unit = null;
                } else {
                    this.$promise.resolve(ErrorsKt.createError(ConfirmSetupIntentErrorType.Canceled.toString(), lastSetupError));
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    PaymentLauncherFragment$retrieveSetupIntent$1 paymentLauncherFragment$retrieveSetupIntent$1 = this;
                    this.$promise.resolve(ErrorsKt.createError(ConfirmSetupIntentErrorType.Canceled.toString(), "Setup has been canceled"));
                    return;
                }
                return;
            case 6:
                this.$promise.resolve(ErrorsKt.createError(ConfirmSetupIntentErrorType.Failed.toString(), setupIntent.getLastSetupError()));
                return;
            case 7:
                this.$promise.resolve(ErrorsKt.createError(ConfirmSetupIntentErrorType.Canceled.toString(), setupIntent.getLastSetupError()));
                return;
            default:
                this.$promise.resolve(ErrorsKt.createError(ConfirmSetupIntentErrorType.Unknown.toString(), Intrinsics.stringPlus("unhandled error: ", setupIntent.getStatus())));
                return;
        }
    }
}
