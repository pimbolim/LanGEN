package com.stripe.android.paymentsheet.flowcontroller;

import com.stripe.android.paymentsheet.PaymentSheet;
import com.stripe.android.paymentsheet.model.ClientSecret;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001:\u0001\tJ%\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H¦@ø\u0001\u0000¢\u0006\u0002\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/stripe/android/paymentsheet/flowcontroller/FlowControllerInitializer;", "", "init", "Lcom/stripe/android/paymentsheet/flowcontroller/FlowControllerInitializer$InitResult;", "clientSecret", "Lcom/stripe/android/paymentsheet/model/ClientSecret;", "paymentSheetConfiguration", "Lcom/stripe/android/paymentsheet/PaymentSheet$Configuration;", "(Lcom/stripe/android/paymentsheet/model/ClientSecret;Lcom/stripe/android/paymentsheet/PaymentSheet$Configuration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "InitResult", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowControllerInitializer.kt */
public interface FlowControllerInitializer {
    Object init(ClientSecret clientSecret, PaymentSheet.Configuration configuration, Continuation<? super InitResult> continuation);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FlowControllerInitializer.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ Object init$default(FlowControllerInitializer flowControllerInitializer, ClientSecret clientSecret, PaymentSheet.Configuration configuration, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    configuration = null;
                }
                return flowControllerInitializer.init(clientSecret, configuration, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: init");
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/paymentsheet/flowcontroller/FlowControllerInitializer$InitResult;", "", "()V", "Failure", "Success", "Lcom/stripe/android/paymentsheet/flowcontroller/FlowControllerInitializer$InitResult$Success;", "Lcom/stripe/android/paymentsheet/flowcontroller/FlowControllerInitializer$InitResult$Failure;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FlowControllerInitializer.kt */
    public static abstract class InitResult {
        public static final int $stable = 0;

        public /* synthetic */ InitResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private InitResult() {
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/stripe/android/paymentsheet/flowcontroller/FlowControllerInitializer$InitResult$Success;", "Lcom/stripe/android/paymentsheet/flowcontroller/FlowControllerInitializer$InitResult;", "initData", "Lcom/stripe/android/paymentsheet/flowcontroller/InitData;", "(Lcom/stripe/android/paymentsheet/flowcontroller/InitData;)V", "getInitData", "()Lcom/stripe/android/paymentsheet/flowcontroller/InitData;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: FlowControllerInitializer.kt */
        public static final class Success extends InitResult {
            public static final int $stable = 8;
            private final InitData initData;

            public static /* synthetic */ Success copy$default(Success success, InitData initData2, int i, Object obj) {
                if ((i & 1) != 0) {
                    initData2 = success.initData;
                }
                return success.copy(initData2);
            }

            public final InitData component1() {
                return this.initData;
            }

            public final Success copy(InitData initData2) {
                Intrinsics.checkNotNullParameter(initData2, "initData");
                return new Success(initData2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Success) && Intrinsics.areEqual((Object) this.initData, (Object) ((Success) obj).initData);
            }

            public int hashCode() {
                return this.initData.hashCode();
            }

            public String toString() {
                return "Success(initData=" + this.initData + ')';
            }

            public final InitData getInitData() {
                return this.initData;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Success(InitData initData2) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(initData2, "initData");
                this.initData = initData2;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/paymentsheet/flowcontroller/FlowControllerInitializer$InitResult$Failure;", "Lcom/stripe/android/paymentsheet/flowcontroller/FlowControllerInitializer$InitResult;", "throwable", "", "(Ljava/lang/Throwable;)V", "getThrowable", "()Ljava/lang/Throwable;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: FlowControllerInitializer.kt */
        public static final class Failure extends InitResult {
            public static final int $stable = 8;
            private final Throwable throwable;

            public final Throwable getThrowable() {
                return this.throwable;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Failure(Throwable th) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(th, "throwable");
                this.throwable = th;
            }
        }
    }
}
