package com.stripe.android.paymentsheet.model;

import com.stripe.android.paymentsheet.viewmodels.BaseSheetViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0003\u0007\b\tB\u0013\b\u0004\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0001\u0003\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/stripe/android/paymentsheet/model/PaymentSheetViewState;", "", "errorMessage", "Lcom/stripe/android/paymentsheet/viewmodels/BaseSheetViewModel$UserErrorMessage;", "(Lcom/stripe/android/paymentsheet/viewmodels/BaseSheetViewModel$UserErrorMessage;)V", "getErrorMessage", "()Lcom/stripe/android/paymentsheet/viewmodels/BaseSheetViewModel$UserErrorMessage;", "FinishProcessing", "Reset", "StartProcessing", "Lcom/stripe/android/paymentsheet/model/PaymentSheetViewState$Reset;", "Lcom/stripe/android/paymentsheet/model/PaymentSheetViewState$StartProcessing;", "Lcom/stripe/android/paymentsheet/model/PaymentSheetViewState$FinishProcessing;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentSheetViewState.kt */
public abstract class PaymentSheetViewState {
    private final BaseSheetViewModel.UserErrorMessage errorMessage;

    public /* synthetic */ PaymentSheetViewState(BaseSheetViewModel.UserErrorMessage userErrorMessage, DefaultConstructorMarker defaultConstructorMarker) {
        this(userErrorMessage);
    }

    private PaymentSheetViewState(BaseSheetViewModel.UserErrorMessage userErrorMessage) {
        this.errorMessage = userErrorMessage;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PaymentSheetViewState(BaseSheetViewModel.UserErrorMessage userErrorMessage, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : userErrorMessage, (DefaultConstructorMarker) null);
    }

    public final BaseSheetViewModel.UserErrorMessage getErrorMessage() {
        return this.errorMessage;
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u0015\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/stripe/android/paymentsheet/model/PaymentSheetViewState$Reset;", "Lcom/stripe/android/paymentsheet/model/PaymentSheetViewState;", "message", "Lcom/stripe/android/paymentsheet/viewmodels/BaseSheetViewModel$UserErrorMessage;", "(Lcom/stripe/android/paymentsheet/viewmodels/BaseSheetViewModel$UserErrorMessage;)V", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentSheetViewState.kt */
    public static final class Reset extends PaymentSheetViewState {
        public static final int $stable = 0;
        private final BaseSheetViewModel.UserErrorMessage message;

        public Reset() {
            this((BaseSheetViewModel.UserErrorMessage) null, 1, (DefaultConstructorMarker) null);
        }

        private final BaseSheetViewModel.UserErrorMessage component1() {
            return this.message;
        }

        public static /* synthetic */ Reset copy$default(Reset reset, BaseSheetViewModel.UserErrorMessage userErrorMessage, int i, Object obj) {
            if ((i & 1) != 0) {
                userErrorMessage = reset.message;
            }
            return reset.copy(userErrorMessage);
        }

        public final Reset copy(BaseSheetViewModel.UserErrorMessage userErrorMessage) {
            return new Reset(userErrorMessage);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Reset) && Intrinsics.areEqual((Object) this.message, (Object) ((Reset) obj).message);
        }

        public int hashCode() {
            BaseSheetViewModel.UserErrorMessage userErrorMessage = this.message;
            if (userErrorMessage == null) {
                return 0;
            }
            return userErrorMessage.hashCode();
        }

        public String toString() {
            return "Reset(message=" + this.message + ')';
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Reset(BaseSheetViewModel.UserErrorMessage userErrorMessage, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : userErrorMessage);
        }

        public Reset(BaseSheetViewModel.UserErrorMessage userErrorMessage) {
            super(userErrorMessage, (DefaultConstructorMarker) null);
            this.message = userErrorMessage;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/stripe/android/paymentsheet/model/PaymentSheetViewState$StartProcessing;", "Lcom/stripe/android/paymentsheet/model/PaymentSheetViewState;", "()V", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentSheetViewState.kt */
    public static final class StartProcessing extends PaymentSheetViewState {
        public static final int $stable = 0;
        public static final StartProcessing INSTANCE = new StartProcessing();

        private StartProcessing() {
            super((BaseSheetViewModel.UserErrorMessage) null, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/stripe/android/paymentsheet/model/PaymentSheetViewState$FinishProcessing;", "Lcom/stripe/android/paymentsheet/model/PaymentSheetViewState;", "onComplete", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "getOnComplete", "()Lkotlin/jvm/functions/Function0;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentSheetViewState.kt */
    public static final class FinishProcessing extends PaymentSheetViewState {
        public static final int $stable = 0;
        private final Function0<Unit> onComplete;

        public static /* synthetic */ FinishProcessing copy$default(FinishProcessing finishProcessing, Function0<Unit> function0, int i, Object obj) {
            if ((i & 1) != 0) {
                function0 = finishProcessing.onComplete;
            }
            return finishProcessing.copy(function0);
        }

        public final Function0<Unit> component1() {
            return this.onComplete;
        }

        public final FinishProcessing copy(Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, "onComplete");
            return new FinishProcessing(function0);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof FinishProcessing) && Intrinsics.areEqual((Object) this.onComplete, (Object) ((FinishProcessing) obj).onComplete);
        }

        public int hashCode() {
            return this.onComplete.hashCode();
        }

        public String toString() {
            return "FinishProcessing(onComplete=" + this.onComplete + ')';
        }

        public final Function0<Unit> getOnComplete() {
            return this.onComplete;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FinishProcessing(Function0<Unit> function0) {
            super((BaseSheetViewModel.UserErrorMessage) null, 1, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(function0, "onComplete");
            this.onComplete = function0;
        }
    }
}
