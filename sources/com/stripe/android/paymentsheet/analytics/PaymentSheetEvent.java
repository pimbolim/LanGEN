package com.stripe.android.paymentsheet.analytics;

import com.henninghall.date_picker.props.ModeProp;
import com.stripe.android.paymentsheet.PaymentSheet;
import com.stripe.android.paymentsheet.analytics.EventReporter;
import com.stripe.android.paymentsheet.model.PaymentSelection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 \n2\u00020\u0001:\u0007\n\u000b\f\r\u000e\u000f\u0010B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\u0006H\u0016R\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0006\u0011\u0012\u0013\u0014\u0015\u0016¨\u0006\u0017"}, d2 = {"Lcom/stripe/android/paymentsheet/analytics/PaymentSheetEvent;", "", "mode", "Lcom/stripe/android/paymentsheet/analytics/EventReporter$Mode;", "(Lcom/stripe/android/paymentsheet/analytics/EventReporter$Mode;)V", "event", "", "getEvent", "()Ljava/lang/String;", "toString", "Companion", "Dismiss", "Init", "Payment", "SelectPaymentOption", "ShowExistingPaymentOptions", "ShowNewPaymentOptionForm", "Lcom/stripe/android/paymentsheet/analytics/PaymentSheetEvent$Init;", "Lcom/stripe/android/paymentsheet/analytics/PaymentSheetEvent$Dismiss;", "Lcom/stripe/android/paymentsheet/analytics/PaymentSheetEvent$ShowNewPaymentOptionForm;", "Lcom/stripe/android/paymentsheet/analytics/PaymentSheetEvent$ShowExistingPaymentOptions;", "Lcom/stripe/android/paymentsheet/analytics/PaymentSheetEvent$SelectPaymentOption;", "Lcom/stripe/android/paymentsheet/analytics/PaymentSheetEvent$Payment;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentSheetEvent.kt */
public abstract class PaymentSheetEvent {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final EventReporter.Mode mode;

    public /* synthetic */ PaymentSheetEvent(EventReporter.Mode mode2, DefaultConstructorMarker defaultConstructorMarker) {
        this(mode2);
    }

    public abstract String getEvent();

    private PaymentSheetEvent(EventReporter.Mode mode2) {
        this.mode = mode2;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/paymentsheet/analytics/PaymentSheetEvent$Init;", "Lcom/stripe/android/paymentsheet/analytics/PaymentSheetEvent;", "mode", "Lcom/stripe/android/paymentsheet/analytics/EventReporter$Mode;", "configuration", "Lcom/stripe/android/paymentsheet/PaymentSheet$Configuration;", "(Lcom/stripe/android/paymentsheet/analytics/EventReporter$Mode;Lcom/stripe/android/paymentsheet/PaymentSheet$Configuration;)V", "event", "", "getEvent", "()Ljava/lang/String;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentSheetEvent.kt */
    public static final class Init extends PaymentSheetEvent {
        public static final int $stable = 8;
        private final PaymentSheet.Configuration configuration;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Init(EventReporter.Mode mode, PaymentSheet.Configuration configuration2) {
            super(mode, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(mode, ModeProp.name);
            this.configuration = configuration2;
        }

        public String getEvent() {
            String joinToString$default;
            String[] strArr = new String[2];
            PaymentSheet.Configuration configuration2 = this.configuration;
            List list = null;
            boolean z = false;
            strArr[0] = (configuration2 == null ? null : configuration2.getCustomer()) != null ? "customer" : null;
            PaymentSheet.Configuration configuration3 = this.configuration;
            if ((configuration3 == null ? null : configuration3.getGooglePay()) != null) {
                z = true;
            }
            strArr[1] = z ? "googlepay" : null;
            List listOfNotNull = CollectionsKt.listOfNotNull((T[]) strArr);
            if (!listOfNotNull.isEmpty()) {
                list = listOfNotNull;
            }
            String str = "default";
            if (!(list == null || (joinToString$default = CollectionsKt.joinToString$default(list, "_", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null)) == null)) {
                str = joinToString$default;
            }
            return Intrinsics.stringPlus("init_", str);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stripe/android/paymentsheet/analytics/PaymentSheetEvent$Dismiss;", "Lcom/stripe/android/paymentsheet/analytics/PaymentSheetEvent;", "mode", "Lcom/stripe/android/paymentsheet/analytics/EventReporter$Mode;", "(Lcom/stripe/android/paymentsheet/analytics/EventReporter$Mode;)V", "event", "", "getEvent", "()Ljava/lang/String;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentSheetEvent.kt */
    public static final class Dismiss extends PaymentSheetEvent {
        public static final int $stable = 0;
        private final String event = "dismiss";

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Dismiss(EventReporter.Mode mode) {
            super(mode, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(mode, ModeProp.name);
        }

        public String getEvent() {
            return this.event;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stripe/android/paymentsheet/analytics/PaymentSheetEvent$ShowNewPaymentOptionForm;", "Lcom/stripe/android/paymentsheet/analytics/PaymentSheetEvent;", "mode", "Lcom/stripe/android/paymentsheet/analytics/EventReporter$Mode;", "(Lcom/stripe/android/paymentsheet/analytics/EventReporter$Mode;)V", "event", "", "getEvent", "()Ljava/lang/String;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentSheetEvent.kt */
    public static final class ShowNewPaymentOptionForm extends PaymentSheetEvent {
        public static final int $stable = 0;
        private final String event = "sheet_newpm_show";

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ShowNewPaymentOptionForm(EventReporter.Mode mode) {
            super(mode, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(mode, ModeProp.name);
        }

        public String getEvent() {
            return this.event;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stripe/android/paymentsheet/analytics/PaymentSheetEvent$ShowExistingPaymentOptions;", "Lcom/stripe/android/paymentsheet/analytics/PaymentSheetEvent;", "mode", "Lcom/stripe/android/paymentsheet/analytics/EventReporter$Mode;", "(Lcom/stripe/android/paymentsheet/analytics/EventReporter$Mode;)V", "event", "", "getEvent", "()Ljava/lang/String;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentSheetEvent.kt */
    public static final class ShowExistingPaymentOptions extends PaymentSheetEvent {
        public static final int $stable = 0;
        private final String event = "sheet_savedpm_show";

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ShowExistingPaymentOptions(EventReporter.Mode mode) {
            super(mode, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(mode, ModeProp.name);
        }

        public String getEvent() {
            return this.event;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/paymentsheet/analytics/PaymentSheetEvent$SelectPaymentOption;", "Lcom/stripe/android/paymentsheet/analytics/PaymentSheetEvent;", "mode", "Lcom/stripe/android/paymentsheet/analytics/EventReporter$Mode;", "paymentSelection", "Lcom/stripe/android/paymentsheet/model/PaymentSelection;", "(Lcom/stripe/android/paymentsheet/analytics/EventReporter$Mode;Lcom/stripe/android/paymentsheet/model/PaymentSelection;)V", "event", "", "getEvent", "()Ljava/lang/String;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentSheetEvent.kt */
    public static final class SelectPaymentOption extends PaymentSheetEvent {
        public static final int $stable = 0;
        private final String event;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SelectPaymentOption(EventReporter.Mode mode, PaymentSelection paymentSelection) {
            super(mode, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(mode, ModeProp.name);
            this.event = "paymentoption_" + PaymentSheetEvent.Companion.analyticsValue(paymentSelection) + "_select";
        }

        public String getEvent() {
            return this.event;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\rB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/stripe/android/paymentsheet/analytics/PaymentSheetEvent$Payment;", "Lcom/stripe/android/paymentsheet/analytics/PaymentSheetEvent;", "mode", "Lcom/stripe/android/paymentsheet/analytics/EventReporter$Mode;", "result", "Lcom/stripe/android/paymentsheet/analytics/PaymentSheetEvent$Payment$Result;", "paymentSelection", "Lcom/stripe/android/paymentsheet/model/PaymentSelection;", "(Lcom/stripe/android/paymentsheet/analytics/EventReporter$Mode;Lcom/stripe/android/paymentsheet/analytics/PaymentSheetEvent$Payment$Result;Lcom/stripe/android/paymentsheet/model/PaymentSelection;)V", "event", "", "getEvent", "()Ljava/lang/String;", "Result", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentSheetEvent.kt */
    public static final class Payment extends PaymentSheetEvent {
        public static final int $stable = 0;
        private final String event;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Payment(EventReporter.Mode mode, Result result, PaymentSelection paymentSelection) {
            super(mode, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(mode, ModeProp.name);
            Intrinsics.checkNotNullParameter(result, "result");
            this.event = "payment_" + PaymentSheetEvent.Companion.analyticsValue(paymentSelection) + '_' + result;
        }

        public String getEvent() {
            return this.event;
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stripe/android/paymentsheet/analytics/PaymentSheetEvent$Payment$Result;", "", "code", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toString", "Success", "Failure", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentSheetEvent.kt */
        public enum Result {
            Success("success"),
            Failure("failure");
            
            private final String code;

            private Result(String str) {
                this.code = str;
            }

            public String toString() {
                return this.code;
            }
        }
    }

    public String toString() {
        return "mc_" + this.mode + '_' + getEvent();
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/paymentsheet/analytics/PaymentSheetEvent$Companion;", "", "()V", "analyticsValue", "", "paymentSelection", "Lcom/stripe/android/paymentsheet/model/PaymentSelection;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentSheetEvent.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final String analyticsValue(PaymentSelection paymentSelection) {
            if (Intrinsics.areEqual((Object) paymentSelection, (Object) PaymentSelection.GooglePay.INSTANCE)) {
                return "googlepay";
            }
            if (paymentSelection instanceof PaymentSelection.Saved) {
                return "savedpm";
            }
            return paymentSelection instanceof PaymentSelection.New ? "newpm" : "unknown";
        }
    }
}
