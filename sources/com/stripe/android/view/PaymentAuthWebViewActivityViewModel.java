package com.stripe.android.view;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.stripe.android.auth.PaymentBrowserAuthContract;
import com.stripe.android.core.Logger;
import com.stripe.android.core.exception.StripeException;
import com.stripe.android.core.networking.AnalyticsRequest;
import com.stripe.android.core.networking.AnalyticsRequestExecutor;
import com.stripe.android.core.networking.DefaultAnalyticsRequestExecutor;
import com.stripe.android.model.Source;
import com.stripe.android.model.Token;
import com.stripe.android.networking.PaymentAnalyticsEvent;
import com.stripe.android.networking.PaymentAnalyticsRequestFactory;
import com.stripe.android.payments.PaymentFlowResult;
import com.stripe.android.stripe3ds2.init.ui.StripeToolbarCustomization;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001:\u0002()B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\u0006\u0010%\u001a\u00020\"J\u0006\u0010&\u001a\u00020\"J\u0006\u0010'\u001a\u00020\"R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8@X\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R'\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u00128FX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u00188@X\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\fR\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006*"}, d2 = {"Lcom/stripe/android/view/PaymentAuthWebViewActivityViewModel;", "Landroidx/lifecycle/ViewModel;", "args", "Lcom/stripe/android/auth/PaymentBrowserAuthContract$Args;", "analyticsRequestExecutor", "Lcom/stripe/android/core/networking/AnalyticsRequestExecutor;", "paymentAnalyticsRequestFactory", "Lcom/stripe/android/networking/PaymentAnalyticsRequestFactory;", "(Lcom/stripe/android/auth/PaymentBrowserAuthContract$Args;Lcom/stripe/android/core/networking/AnalyticsRequestExecutor;Lcom/stripe/android/networking/PaymentAnalyticsRequestFactory;)V", "buttonText", "", "getButtonText$payments_core_release", "()Ljava/lang/String;", "cancellationResult", "Landroid/content/Intent;", "getCancellationResult$payments_core_release", "()Landroid/content/Intent;", "extraHeaders", "", "getExtraHeaders", "()Ljava/util/Map;", "extraHeaders$delegate", "Lkotlin/Lazy;", "paymentResult", "Lcom/stripe/android/payments/PaymentFlowResult$Unvalidated;", "getPaymentResult$payments_core_release", "()Lcom/stripe/android/payments/PaymentFlowResult$Unvalidated;", "toolbarBackgroundColor", "getToolbarBackgroundColor$payments_core_release", "toolbarTitle", "Lcom/stripe/android/view/PaymentAuthWebViewActivityViewModel$ToolbarTitleData;", "getToolbarTitle$payments_core_release", "()Lcom/stripe/android/view/PaymentAuthWebViewActivityViewModel$ToolbarTitleData;", "fireAnalytics", "", "request", "Lcom/stripe/android/core/networking/AnalyticsRequest;", "logComplete", "logError", "logStart", "Factory", "ToolbarTitleData", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentAuthWebViewActivityViewModel.kt */
public final class PaymentAuthWebViewActivityViewModel extends ViewModel {
    private final AnalyticsRequestExecutor analyticsRequestExecutor;
    private final PaymentBrowserAuthContract.Args args;
    private final /* synthetic */ String buttonText;
    private final Lazy extraHeaders$delegate = LazyKt.lazy(PaymentAuthWebViewActivityViewModel$extraHeaders$2.INSTANCE);
    private final PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory;
    private final /* synthetic */ String toolbarBackgroundColor;
    private final /* synthetic */ ToolbarTitleData toolbarTitle;

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0040, code lost:
        if ((r2 == null || kotlin.text.StringsKt.isBlank(r2)) == false) goto L_0x0042;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0071  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PaymentAuthWebViewActivityViewModel(com.stripe.android.auth.PaymentBrowserAuthContract.Args r5, com.stripe.android.core.networking.AnalyticsRequestExecutor r6, com.stripe.android.networking.PaymentAnalyticsRequestFactory r7) {
        /*
            r4 = this;
            java.lang.String r0 = "args"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "analyticsRequestExecutor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "paymentAnalyticsRequestFactory"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r4.<init>()
            r4.args = r5
            r4.analyticsRequestExecutor = r6
            r4.paymentAnalyticsRequestFactory = r7
            com.stripe.android.view.PaymentAuthWebViewActivityViewModel$extraHeaders$2 r6 = com.stripe.android.view.PaymentAuthWebViewActivityViewModel$extraHeaders$2.INSTANCE
            kotlin.jvm.functions.Function0 r6 = (kotlin.jvm.functions.Function0) r6
            kotlin.Lazy r6 = kotlin.LazyKt.lazy(r6)
            r4.extraHeaders$delegate = r6
            com.stripe.android.stripe3ds2.init.ui.StripeToolbarCustomization r6 = r5.getToolbarCustomization()
            r7 = 0
            r0 = 1
            r1 = 0
            if (r6 != 0) goto L_0x002d
        L_0x002b:
            r6 = r1
            goto L_0x0042
        L_0x002d:
            java.lang.String r6 = r6.getButtonText()
            r2 = r6
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x003f
            boolean r2 = kotlin.text.StringsKt.isBlank(r2)
            if (r2 == 0) goto L_0x003d
            goto L_0x003f
        L_0x003d:
            r2 = 0
            goto L_0x0040
        L_0x003f:
            r2 = 1
        L_0x0040:
            if (r2 != 0) goto L_0x002b
        L_0x0042:
            r4.buttonText = r6
            com.stripe.android.stripe3ds2.init.ui.StripeToolbarCustomization r6 = r5.getToolbarCustomization()
            if (r6 != 0) goto L_0x004c
        L_0x004a:
            r7 = r1
            goto L_0x0068
        L_0x004c:
            java.lang.String r2 = r6.getHeaderText()
            r3 = r2
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            if (r3 == 0) goto L_0x005b
            boolean r3 = kotlin.text.StringsKt.isBlank(r3)
            if (r3 == 0) goto L_0x005c
        L_0x005b:
            r7 = 1
        L_0x005c:
            if (r7 != 0) goto L_0x005f
            goto L_0x0060
        L_0x005f:
            r2 = r1
        L_0x0060:
            if (r2 != 0) goto L_0x0063
            goto L_0x004a
        L_0x0063:
            com.stripe.android.view.PaymentAuthWebViewActivityViewModel$ToolbarTitleData r7 = new com.stripe.android.view.PaymentAuthWebViewActivityViewModel$ToolbarTitleData
            r7.<init>(r2, r6)
        L_0x0068:
            r4.toolbarTitle = r7
            com.stripe.android.stripe3ds2.init.ui.StripeToolbarCustomization r5 = r5.getToolbarCustomization()
            if (r5 != 0) goto L_0x0071
            goto L_0x0075
        L_0x0071:
            java.lang.String r1 = r5.getBackgroundColor()
        L_0x0075:
            r4.toolbarBackgroundColor = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.view.PaymentAuthWebViewActivityViewModel.<init>(com.stripe.android.auth.PaymentBrowserAuthContract$Args, com.stripe.android.core.networking.AnalyticsRequestExecutor, com.stripe.android.networking.PaymentAnalyticsRequestFactory):void");
    }

    public final Map<String, String> getExtraHeaders() {
        return (Map) this.extraHeaders$delegate.getValue();
    }

    public final String getButtonText$payments_core_release() {
        return this.buttonText;
    }

    public final ToolbarTitleData getToolbarTitle$payments_core_release() {
        return this.toolbarTitle;
    }

    public final String getToolbarBackgroundColor$payments_core_release() {
        return this.toolbarBackgroundColor;
    }

    public final /* synthetic */ PaymentFlowResult.Unvalidated getPaymentResult$payments_core_release() {
        String clientSecret = this.args.getClientSecret();
        String lastPathSegment = Uri.parse(this.args.getUrl()).getLastPathSegment();
        if (lastPathSegment == null) {
            lastPathSegment = "";
        }
        return new PaymentFlowResult.Unvalidated(clientSecret, 0, (StripeException) null, false, lastPathSegment, (Source) null, this.args.getStripeAccountId(), 46, (DefaultConstructorMarker) null);
    }

    public final /* synthetic */ Intent getCancellationResult$payments_core_release() {
        Intent putExtras = new Intent().putExtras(PaymentFlowResult.Unvalidated.copy$default(getPaymentResult$payments_core_release(), (String) null, this.args.getShouldCancelIntentOnUserNavigation() ? 3 : 1, (StripeException) null, this.args.getShouldCancelSource(), (String) null, (Source) null, (String) null, 117, (Object) null).toBundle());
        Intrinsics.checkNotNullExpressionValue(putExtras, "Intent().putExtras(\n    ….toBundle()\n            )");
        return putExtras;
    }

    public final void logStart() {
        fireAnalytics(PaymentAnalyticsRequestFactory.createRequest$payments_core_release$default(this.paymentAnalyticsRequestFactory, PaymentAnalyticsEvent.Auth3ds1ChallengeStart, (Set) null, (String) null, (Token.Type) null, (PaymentAnalyticsRequestFactory.ThreeDS2UiType) null, 30, (Object) null));
        fireAnalytics(PaymentAnalyticsRequestFactory.createRequest$payments_core_release$default(this.paymentAnalyticsRequestFactory, PaymentAnalyticsEvent.AuthWithWebView, (Set) null, (String) null, (Token.Type) null, (PaymentAnalyticsRequestFactory.ThreeDS2UiType) null, 30, (Object) null));
    }

    public final void logError() {
        fireAnalytics(PaymentAnalyticsRequestFactory.createRequest$payments_core_release$default(this.paymentAnalyticsRequestFactory, PaymentAnalyticsEvent.Auth3ds1ChallengeError, (Set) null, (String) null, (Token.Type) null, (PaymentAnalyticsRequestFactory.ThreeDS2UiType) null, 30, (Object) null));
    }

    public final void logComplete() {
        fireAnalytics(PaymentAnalyticsRequestFactory.createRequest$payments_core_release$default(this.paymentAnalyticsRequestFactory, PaymentAnalyticsEvent.Auth3ds1ChallengeComplete, (Set) null, (String) null, (Token.Type) null, (PaymentAnalyticsRequestFactory.ThreeDS2UiType) null, 30, (Object) null));
    }

    private final void fireAnalytics(AnalyticsRequest analyticsRequest) {
        this.analyticsRequestExecutor.executeAsync(analyticsRequest);
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000b\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\fJ\u000e\u0010\r\u001a\u00020\u0005HÀ\u0003¢\u0006\u0002\b\u000eJ\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/stripe/android/view/PaymentAuthWebViewActivityViewModel$ToolbarTitleData;", "", "text", "", "toolbarCustomization", "Lcom/stripe/android/stripe3ds2/init/ui/StripeToolbarCustomization;", "(Ljava/lang/String;Lcom/stripe/android/stripe3ds2/init/ui/StripeToolbarCustomization;)V", "getText$payments_core_release", "()Ljava/lang/String;", "getToolbarCustomization$payments_core_release", "()Lcom/stripe/android/stripe3ds2/init/ui/StripeToolbarCustomization;", "component1", "component1$payments_core_release", "component2", "component2$payments_core_release", "copy", "equals", "", "other", "hashCode", "", "toString", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentAuthWebViewActivityViewModel.kt */
    public static final class ToolbarTitleData {
        private final String text;
        private final StripeToolbarCustomization toolbarCustomization;

        public static /* synthetic */ ToolbarTitleData copy$default(ToolbarTitleData toolbarTitleData, String str, StripeToolbarCustomization stripeToolbarCustomization, int i, Object obj) {
            if ((i & 1) != 0) {
                str = toolbarTitleData.text;
            }
            if ((i & 2) != 0) {
                stripeToolbarCustomization = toolbarTitleData.toolbarCustomization;
            }
            return toolbarTitleData.copy(str, stripeToolbarCustomization);
        }

        public final String component1$payments_core_release() {
            return this.text;
        }

        public final StripeToolbarCustomization component2$payments_core_release() {
            return this.toolbarCustomization;
        }

        public final ToolbarTitleData copy(String str, StripeToolbarCustomization stripeToolbarCustomization) {
            Intrinsics.checkNotNullParameter(str, "text");
            Intrinsics.checkNotNullParameter(stripeToolbarCustomization, "toolbarCustomization");
            return new ToolbarTitleData(str, stripeToolbarCustomization);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ToolbarTitleData)) {
                return false;
            }
            ToolbarTitleData toolbarTitleData = (ToolbarTitleData) obj;
            return Intrinsics.areEqual((Object) this.text, (Object) toolbarTitleData.text) && Intrinsics.areEqual((Object) this.toolbarCustomization, (Object) toolbarTitleData.toolbarCustomization);
        }

        public int hashCode() {
            return (this.text.hashCode() * 31) + this.toolbarCustomization.hashCode();
        }

        public String toString() {
            return "ToolbarTitleData(text=" + this.text + ", toolbarCustomization=" + this.toolbarCustomization + ')';
        }

        public ToolbarTitleData(String str, StripeToolbarCustomization stripeToolbarCustomization) {
            Intrinsics.checkNotNullParameter(str, "text");
            Intrinsics.checkNotNullParameter(stripeToolbarCustomization, "toolbarCustomization");
            this.text = str;
            this.toolbarCustomization = stripeToolbarCustomization;
        }

        public final String getText$payments_core_release() {
            return this.text;
        }

        public final StripeToolbarCustomization getToolbarCustomization$payments_core_release() {
            return this.toolbarCustomization;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ%\u0010\t\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\n0\rH\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/stripe/android/view/PaymentAuthWebViewActivityViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "application", "Landroid/app/Application;", "logger", "Lcom/stripe/android/core/Logger;", "args", "Lcom/stripe/android/auth/PaymentBrowserAuthContract$Args;", "(Landroid/app/Application;Lcom/stripe/android/core/Logger;Lcom/stripe/android/auth/PaymentBrowserAuthContract$Args;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentAuthWebViewActivityViewModel.kt */
    public static final class Factory implements ViewModelProvider.Factory {
        private final Application application;
        private final PaymentBrowserAuthContract.Args args;
        private final Logger logger;

        public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
            return ViewModelProvider.Factory.CC.$default$create(this, cls, creationExtras);
        }

        public Factory(Application application2, Logger logger2, PaymentBrowserAuthContract.Args args2) {
            Intrinsics.checkNotNullParameter(application2, "application");
            Intrinsics.checkNotNullParameter(logger2, "logger");
            Intrinsics.checkNotNullParameter(args2, "args");
            this.application = application2;
            this.logger = logger2;
            this.args = args2;
        }

        public <T extends ViewModel> T create(Class<T> cls) {
            Intrinsics.checkNotNullParameter(cls, "modelClass");
            return (ViewModel) new PaymentAuthWebViewActivityViewModel(this.args, new DefaultAnalyticsRequestExecutor(this.logger, Dispatchers.getIO()), new PaymentAnalyticsRequestFactory((Context) this.application, this.args.getPublishableKey(), (Set<String>) SetsKt.setOf("PaymentAuthWebViewActivity")));
        }
    }
}
