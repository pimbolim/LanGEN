package com.stripe.android.payments.paymentlauncher;

import android.content.Context;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.result.ActivityResultLauncher;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.fragment.app.Fragment;
import com.stripe.android.model.ConfirmPaymentIntentParams;
import com.stripe.android.model.ConfirmSetupIntentParams;
import com.stripe.android.payments.paymentlauncher.PaymentLauncherContract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u0000 \u000b2\u00020\u0001:\u0002\u000b\fJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&¨\u0006\r"}, d2 = {"Lcom/stripe/android/payments/paymentlauncher/PaymentLauncher;", "", "confirm", "", "params", "Lcom/stripe/android/model/ConfirmPaymentIntentParams;", "Lcom/stripe/android/model/ConfirmSetupIntentParams;", "handleNextActionForPaymentIntent", "clientSecret", "", "handleNextActionForSetupIntent", "Companion", "PaymentResultCallback", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentLauncher.kt */
public interface PaymentLauncher {
    public static final Companion Companion = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/payments/paymentlauncher/PaymentLauncher$PaymentResultCallback;", "", "onPaymentResult", "", "paymentResult", "Lcom/stripe/android/payments/paymentlauncher/PaymentResult;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentLauncher.kt */
    public interface PaymentResultCallback {
        void onPaymentResult(PaymentResult paymentResult);
    }

    void confirm(ConfirmPaymentIntentParams confirmPaymentIntentParams);

    void confirm(ConfirmSetupIntentParams confirmSetupIntentParams);

    void handleNextActionForPaymentIntent(String str);

    void handleNextActionForSetupIntent(String str);

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000bJ*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000bJ)\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/stripe/android/payments/paymentlauncher/PaymentLauncher$Companion;", "", "()V", "create", "Lcom/stripe/android/payments/paymentlauncher/PaymentLauncher;", "activity", "Landroidx/activity/ComponentActivity;", "publishableKey", "", "stripeAccountId", "callback", "Lcom/stripe/android/payments/paymentlauncher/PaymentLauncher$PaymentResultCallback;", "fragment", "Landroidx/fragment/app/Fragment;", "createForCompose", "(Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/payments/paymentlauncher/PaymentLauncher$PaymentResultCallback;Landroidx/compose/runtime/Composer;II)Lcom/stripe/android/payments/paymentlauncher/PaymentLauncher;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentLauncher.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public static /* synthetic */ PaymentLauncher create$default(Companion companion, ComponentActivity componentActivity, String str, String str2, PaymentResultCallback paymentResultCallback, int i, Object obj) {
            if ((i & 4) != 0) {
                str2 = null;
            }
            return companion.create(componentActivity, str, str2, paymentResultCallback);
        }

        public final PaymentLauncher create(ComponentActivity componentActivity, String str, String str2, PaymentResultCallback paymentResultCallback) {
            Intrinsics.checkNotNullParameter(componentActivity, "activity");
            Intrinsics.checkNotNullParameter(str, "publishableKey");
            Intrinsics.checkNotNullParameter(paymentResultCallback, "callback");
            return new PaymentLauncherFactory(componentActivity, paymentResultCallback).create(str, str2);
        }

        public static /* synthetic */ PaymentLauncher create$default(Companion companion, Fragment fragment, String str, String str2, PaymentResultCallback paymentResultCallback, int i, Object obj) {
            if ((i & 4) != 0) {
                str2 = null;
            }
            return companion.create(fragment, str, str2, paymentResultCallback);
        }

        public final PaymentLauncher create(Fragment fragment, String str, String str2, PaymentResultCallback paymentResultCallback) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            Intrinsics.checkNotNullParameter(str, "publishableKey");
            Intrinsics.checkNotNullParameter(paymentResultCallback, "callback");
            return new PaymentLauncherFactory(fragment, paymentResultCallback).create(str, str2);
        }

        public final PaymentLauncher createForCompose(String str, String str2, PaymentResultCallback paymentResultCallback, Composer composer, int i, int i2) {
            Intrinsics.checkNotNullParameter(str, "publishableKey");
            Intrinsics.checkNotNullParameter(paymentResultCallback, "callback");
            composer.startReplaceableGroup(47442728);
            ComposerKt.sourceInformation(composer, "C(createForCompose)P(1,2)");
            if ((i2 & 2) != 0) {
                str2 = null;
            }
            ComposerKt.sourceInformationMarkerStart(composer, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            ComposerKt.sourceInformationMarkerEnd(composer);
            PaymentLauncher create = new PaymentLauncherFactory((Context) consume, (ActivityResultLauncher<PaymentLauncherContract.Args>) ActivityResultRegistryKt.rememberLauncherForActivityResult(new PaymentLauncherContract(), new PaymentLauncher$Companion$createForCompose$1(paymentResultCallback), composer, 0)).create(str, str2);
            composer.endReplaceableGroup();
            return create;
        }
    }
}
