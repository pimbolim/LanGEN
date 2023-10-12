package com.stripe.android.connections.model;

import android.os.Parcelable;
import com.stripe.android.connections.model.serializer.PaymentAccountSerializer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/connections/model/PaymentAccount;", "Landroid/os/Parcelable;", "()V", "Companion", "Lcom/stripe/android/connections/model/BankAccount;", "Lcom/stripe/android/connections/model/LinkedAccount;", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Serializable(with = PaymentAccountSerializer.class)
/* compiled from: LinkAccountSession.kt */
public abstract class PaymentAccount implements Parcelable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public /* synthetic */ PaymentAccount(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/connections/model/PaymentAccount$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/stripe/android/connections/model/PaymentAccount;", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LinkAccountSession.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<PaymentAccount> serializer() {
            return PaymentAccountSerializer.INSTANCE;
        }
    }

    private PaymentAccount() {
    }
}
