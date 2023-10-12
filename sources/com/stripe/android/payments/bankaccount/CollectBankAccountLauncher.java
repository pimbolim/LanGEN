package com.stripe.android.payments.bankaccount;

import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import com.stripe.android.payments.bankaccount.CollectBankAccountLauncher;
import com.stripe.android.payments.bankaccount.navigation.CollectBankAccountContract;
import com.stripe.android.payments.bankaccount.navigation.CollectBankAccountResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \n2\u00020\u0001:\u0001\nJ \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J \u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/payments/bankaccount/CollectBankAccountLauncher;", "", "presentWithPaymentIntent", "", "publishableKey", "", "clientSecret", "configuration", "Lcom/stripe/android/payments/bankaccount/CollectBankAccountConfiguration;", "presentWithSetupIntent", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectBankAccountLauncher.kt */
public interface CollectBankAccountLauncher {
    public static final Companion Companion = Companion.$$INSTANCE;

    void presentWithPaymentIntent(String str, String str2, CollectBankAccountConfiguration collectBankAccountConfiguration);

    void presentWithSetupIntent(String str, String str2, CollectBankAccountConfiguration collectBankAccountConfiguration);

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bJ\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¨\u0006\r"}, d2 = {"Lcom/stripe/android/payments/bankaccount/CollectBankAccountLauncher$Companion;", "", "()V", "create", "Lcom/stripe/android/payments/bankaccount/CollectBankAccountLauncher;", "activity", "Landroidx/activity/ComponentActivity;", "callback", "Lkotlin/Function1;", "Lcom/stripe/android/payments/bankaccount/navigation/CollectBankAccountResult;", "", "fragment", "Landroidx/fragment/app/Fragment;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CollectBankAccountLauncher.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final CollectBankAccountLauncher create(ComponentActivity componentActivity, Function1<? super CollectBankAccountResult, Unit> function1) {
            Intrinsics.checkNotNullParameter(componentActivity, "activity");
            Intrinsics.checkNotNullParameter(function1, "callback");
            ActivityResultLauncher registerForActivityResult = componentActivity.registerForActivityResult(new CollectBankAccountContract(), new ActivityResultCallback() {
                public final void onActivityResult(Object obj) {
                    CollectBankAccountLauncher.Companion.m4369create$lambda0(Function1.this, (CollectBankAccountResult) obj);
                }
            });
            Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "activity.registerForActi…ack(it)\n                }");
            return new StripeCollectBankAccountLauncher(registerForActivityResult);
        }

        /* access modifiers changed from: private */
        /* renamed from: create$lambda-0  reason: not valid java name */
        public static final void m4369create$lambda0(Function1 function1, CollectBankAccountResult collectBankAccountResult) {
            Intrinsics.checkNotNullParameter(function1, "$callback");
            Intrinsics.checkNotNullExpressionValue(collectBankAccountResult, "it");
            function1.invoke(collectBankAccountResult);
        }

        public final CollectBankAccountLauncher create(Fragment fragment, Function1<? super CollectBankAccountResult, Unit> function1) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            Intrinsics.checkNotNullParameter(function1, "callback");
            ActivityResultLauncher registerForActivityResult = fragment.registerForActivityResult(new CollectBankAccountContract(), new ActivityResultCallback() {
                public final void onActivityResult(Object obj) {
                    CollectBankAccountLauncher.Companion.m4370create$lambda1(Function1.this, (CollectBankAccountResult) obj);
                }
            });
            Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "fragment.registerForActi…ack(it)\n                }");
            return new StripeCollectBankAccountLauncher(registerForActivityResult);
        }

        /* access modifiers changed from: private */
        /* renamed from: create$lambda-1  reason: not valid java name */
        public static final void m4370create$lambda1(Function1 function1, CollectBankAccountResult collectBankAccountResult) {
            Intrinsics.checkNotNullParameter(function1, "$callback");
            Intrinsics.checkNotNullExpressionValue(collectBankAccountResult, "it");
            function1.invoke(collectBankAccountResult);
        }
    }
}
