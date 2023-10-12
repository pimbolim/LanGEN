package com.stripe.android.paymentsheet.analytics;

import com.henninghall.date_picker.props.ModeProp;
import com.stripe.android.core.injection.IOContext;
import com.stripe.android.core.networking.AnalyticsRequestExecutor;
import com.stripe.android.networking.PaymentAnalyticsRequestFactory;
import com.stripe.android.paymentsheet.PaymentSheet;
import com.stripe.android.paymentsheet.analytics.EventReporter;
import com.stripe.android.paymentsheet.analytics.PaymentSheetEvent;
import com.stripe.android.paymentsheet.model.PaymentSelection;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Singleton
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B1\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\u0012\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u000eH\u0016J\b\u0010\u001b\u001a\u00020\u000eH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/stripe/android/paymentsheet/analytics/DefaultEventReporter;", "Lcom/stripe/android/paymentsheet/analytics/EventReporter;", "mode", "Lcom/stripe/android/paymentsheet/analytics/EventReporter$Mode;", "deviceIdRepository", "Lcom/stripe/android/paymentsheet/analytics/DeviceIdRepository;", "analyticsRequestExecutor", "Lcom/stripe/android/core/networking/AnalyticsRequestExecutor;", "paymentAnalyticsRequestFactory", "Lcom/stripe/android/networking/PaymentAnalyticsRequestFactory;", "workContext", "Lkotlin/coroutines/CoroutineContext;", "(Lcom/stripe/android/paymentsheet/analytics/EventReporter$Mode;Lcom/stripe/android/paymentsheet/analytics/DeviceIdRepository;Lcom/stripe/android/core/networking/AnalyticsRequestExecutor;Lcom/stripe/android/networking/PaymentAnalyticsRequestFactory;Lkotlin/coroutines/CoroutineContext;)V", "fireEvent", "", "event", "Lcom/stripe/android/paymentsheet/analytics/PaymentSheetEvent;", "onDismiss", "onInit", "configuration", "Lcom/stripe/android/paymentsheet/PaymentSheet$Configuration;", "onPaymentFailure", "paymentSelection", "Lcom/stripe/android/paymentsheet/model/PaymentSelection;", "onPaymentSuccess", "onSelectPaymentOption", "onShowExistingPaymentOptions", "onShowNewPaymentOptionForm", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DefaultEventReporter.kt */
public final class DefaultEventReporter implements EventReporter {
    /* access modifiers changed from: private */
    public final AnalyticsRequestExecutor analyticsRequestExecutor;
    /* access modifiers changed from: private */
    public final DeviceIdRepository deviceIdRepository;
    private final EventReporter.Mode mode;
    /* access modifiers changed from: private */
    public final PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory;
    private final CoroutineContext workContext;

    @Inject
    public DefaultEventReporter(EventReporter.Mode mode2, DeviceIdRepository deviceIdRepository2, AnalyticsRequestExecutor analyticsRequestExecutor2, PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory2, @IOContext CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(mode2, ModeProp.name);
        Intrinsics.checkNotNullParameter(deviceIdRepository2, "deviceIdRepository");
        Intrinsics.checkNotNullParameter(analyticsRequestExecutor2, "analyticsRequestExecutor");
        Intrinsics.checkNotNullParameter(paymentAnalyticsRequestFactory2, "paymentAnalyticsRequestFactory");
        Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
        this.mode = mode2;
        this.deviceIdRepository = deviceIdRepository2;
        this.analyticsRequestExecutor = analyticsRequestExecutor2;
        this.paymentAnalyticsRequestFactory = paymentAnalyticsRequestFactory2;
        this.workContext = coroutineContext;
    }

    public void onInit(PaymentSheet.Configuration configuration) {
        fireEvent(new PaymentSheetEvent.Init(this.mode, configuration));
    }

    public void onDismiss() {
        fireEvent(new PaymentSheetEvent.Dismiss(this.mode));
    }

    public void onShowExistingPaymentOptions() {
        fireEvent(new PaymentSheetEvent.ShowExistingPaymentOptions(this.mode));
    }

    public void onShowNewPaymentOptionForm() {
        fireEvent(new PaymentSheetEvent.ShowNewPaymentOptionForm(this.mode));
    }

    public void onSelectPaymentOption(PaymentSelection paymentSelection) {
        Intrinsics.checkNotNullParameter(paymentSelection, "paymentSelection");
        fireEvent(new PaymentSheetEvent.SelectPaymentOption(this.mode, paymentSelection));
    }

    public void onPaymentSuccess(PaymentSelection paymentSelection) {
        fireEvent(new PaymentSheetEvent.Payment(this.mode, PaymentSheetEvent.Payment.Result.Success, paymentSelection));
    }

    public void onPaymentFailure(PaymentSelection paymentSelection) {
        fireEvent(new PaymentSheetEvent.Payment(this.mode, PaymentSheetEvent.Payment.Result.Failure, paymentSelection));
    }

    private final void fireEvent(PaymentSheetEvent paymentSheetEvent) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.workContext), (CoroutineContext) null, (CoroutineStart) null, new DefaultEventReporter$fireEvent$1(this, paymentSheetEvent, (Continuation<? super DefaultEventReporter$fireEvent$1>) null), 3, (Object) null);
    }
}
