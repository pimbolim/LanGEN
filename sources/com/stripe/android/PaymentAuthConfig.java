package com.stripe.android;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.stripe3ds2.init.ui.ButtonCustomization;
import com.stripe.android.stripe3ds2.init.ui.LabelCustomization;
import com.stripe.android.stripe3ds2.init.ui.StripeButtonCustomization;
import com.stripe.android.stripe3ds2.init.ui.StripeLabelCustomization;
import com.stripe.android.stripe3ds2.init.ui.StripeTextBoxCustomization;
import com.stripe.android.stripe3ds2.init.ui.StripeToolbarCustomization;
import com.stripe.android.stripe3ds2.init.ui.StripeUiCustomization;
import com.stripe.android.stripe3ds2.init.ui.TextBoxCustomization;
import com.stripe.android.stripe3ds2.init.ui.ToolbarCustomization;
import com.stripe.android.stripe3ds2.init.ui.UiCustomization;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 \b2\u00020\u0001:\b\u0007\b\t\n\u000b\f\r\u000eB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/stripe/android/PaymentAuthConfig;", "", "stripe3ds2Config", "Lcom/stripe/android/PaymentAuthConfig$Stripe3ds2Config;", "(Lcom/stripe/android/PaymentAuthConfig$Stripe3ds2Config;)V", "getStripe3ds2Config$payments_core_release", "()Lcom/stripe/android/PaymentAuthConfig$Stripe3ds2Config;", "Builder", "Companion", "Stripe3ds2ButtonCustomization", "Stripe3ds2Config", "Stripe3ds2LabelCustomization", "Stripe3ds2TextBoxCustomization", "Stripe3ds2ToolbarCustomization", "Stripe3ds2UiCustomization", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentAuthConfig.kt */
public final class PaymentAuthConfig {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final PaymentAuthConfig DEFAULT = new Builder().set3ds2Config(new Stripe3ds2Config.Builder().build()).build();
    /* access modifiers changed from: private */
    public static PaymentAuthConfig instance;
    private final Stripe3ds2Config stripe3ds2Config;

    public /* synthetic */ PaymentAuthConfig(Stripe3ds2Config stripe3ds2Config2, DefaultConstructorMarker defaultConstructorMarker) {
        this(stripe3ds2Config2);
    }

    @JvmStatic
    public static final PaymentAuthConfig get() {
        return Companion.get();
    }

    @JvmStatic
    public static final void init(PaymentAuthConfig paymentAuthConfig) {
        Companion.init(paymentAuthConfig);
    }

    private PaymentAuthConfig(Stripe3ds2Config stripe3ds2Config2) {
        this.stripe3ds2Config = stripe3ds2Config2;
    }

    public final Stripe3ds2Config getStripe3ds2Config$payments_core_release() {
        return this.stripe3ds2Config;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/stripe/android/PaymentAuthConfig$Builder;", "Lcom/stripe/android/ObjectBuilder;", "Lcom/stripe/android/PaymentAuthConfig;", "()V", "stripe3ds2Config", "Lcom/stripe/android/PaymentAuthConfig$Stripe3ds2Config;", "build", "set3ds2Config", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentAuthConfig.kt */
    public static final class Builder implements ObjectBuilder<PaymentAuthConfig> {
        public static final int $stable = 8;
        private Stripe3ds2Config stripe3ds2Config;

        public final Builder set3ds2Config(Stripe3ds2Config stripe3ds2Config2) {
            Intrinsics.checkNotNullParameter(stripe3ds2Config2, "stripe3ds2Config");
            Builder builder = this;
            builder.stripe3ds2Config = stripe3ds2Config2;
            return builder;
        }

        public PaymentAuthConfig build() {
            Stripe3ds2Config stripe3ds2Config2 = this.stripe3ds2Config;
            if (stripe3ds2Config2 != null) {
                return new PaymentAuthConfig(stripe3ds2Config2, (DefaultConstructorMarker) null);
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001e\u001fB\u0019\b\u0000\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u000e\u0010\r\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u000eJ\u000e\u0010\u000f\u001a\u00020\u0005HÀ\u0003¢\u0006\u0002\b\u0010J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006 "}, d2 = {"Lcom/stripe/android/PaymentAuthConfig$Stripe3ds2Config;", "Landroid/os/Parcelable;", "timeout", "", "uiCustomization", "Lcom/stripe/android/PaymentAuthConfig$Stripe3ds2UiCustomization;", "(ILcom/stripe/android/PaymentAuthConfig$Stripe3ds2UiCustomization;)V", "getTimeout$payments_core_release", "()I", "getUiCustomization$payments_core_release", "()Lcom/stripe/android/PaymentAuthConfig$Stripe3ds2UiCustomization;", "checkValidTimeout", "", "component1", "component1$payments_core_release", "component2", "component2$payments_core_release", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "Builder", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentAuthConfig.kt */
    public static final class Stripe3ds2Config implements Parcelable {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Stripe3ds2Config> CREATOR = new Creator();
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public static final int DEFAULT_TIMEOUT = 5;
        private final int timeout;
        private final Stripe3ds2UiCustomization uiCustomization;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentAuthConfig.kt */
        public static final class Creator implements Parcelable.Creator<Stripe3ds2Config> {
            public final Stripe3ds2Config createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Stripe3ds2Config(parcel.readInt(), Stripe3ds2UiCustomization.CREATOR.createFromParcel(parcel));
            }

            public final Stripe3ds2Config[] newArray(int i) {
                return new Stripe3ds2Config[i];
            }
        }

        public static /* synthetic */ Stripe3ds2Config copy$default(Stripe3ds2Config stripe3ds2Config, int i, Stripe3ds2UiCustomization stripe3ds2UiCustomization, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = stripe3ds2Config.timeout;
            }
            if ((i2 & 2) != 0) {
                stripe3ds2UiCustomization = stripe3ds2Config.uiCustomization;
            }
            return stripe3ds2Config.copy(i, stripe3ds2UiCustomization);
        }

        public final int component1$payments_core_release() {
            return this.timeout;
        }

        public final Stripe3ds2UiCustomization component2$payments_core_release() {
            return this.uiCustomization;
        }

        public final Stripe3ds2Config copy(int i, Stripe3ds2UiCustomization stripe3ds2UiCustomization) {
            Intrinsics.checkNotNullParameter(stripe3ds2UiCustomization, "uiCustomization");
            return new Stripe3ds2Config(i, stripe3ds2UiCustomization);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Stripe3ds2Config)) {
                return false;
            }
            Stripe3ds2Config stripe3ds2Config = (Stripe3ds2Config) obj;
            return this.timeout == stripe3ds2Config.timeout && Intrinsics.areEqual((Object) this.uiCustomization, (Object) stripe3ds2Config.uiCustomization);
        }

        public int hashCode() {
            return (this.timeout * 31) + this.uiCustomization.hashCode();
        }

        public String toString() {
            return "Stripe3ds2Config(timeout=" + this.timeout + ", uiCustomization=" + this.uiCustomization + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(this.timeout);
            this.uiCustomization.writeToParcel(parcel, i);
        }

        public Stripe3ds2Config(int i, Stripe3ds2UiCustomization stripe3ds2UiCustomization) {
            Intrinsics.checkNotNullParameter(stripe3ds2UiCustomization, "uiCustomization");
            this.timeout = i;
            this.uiCustomization = stripe3ds2UiCustomization;
            checkValidTimeout(i);
        }

        public final int getTimeout$payments_core_release() {
            return this.timeout;
        }

        public final Stripe3ds2UiCustomization getUiCustomization$payments_core_release() {
            return this.uiCustomization;
        }

        private final void checkValidTimeout(int i) {
            if (!(i >= 5 && i <= 99)) {
                throw new IllegalArgumentException("Timeout value must be between 5 and 99, inclusive".toString());
            }
        }

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00002\b\b\u0001\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/PaymentAuthConfig$Stripe3ds2Config$Builder;", "Lcom/stripe/android/ObjectBuilder;", "Lcom/stripe/android/PaymentAuthConfig$Stripe3ds2Config;", "()V", "timeout", "", "uiCustomization", "Lcom/stripe/android/PaymentAuthConfig$Stripe3ds2UiCustomization;", "build", "setTimeout", "setUiCustomization", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentAuthConfig.kt */
        public static final class Builder implements ObjectBuilder<Stripe3ds2Config> {
            public static final int $stable = 8;
            private int timeout = 5;
            private Stripe3ds2UiCustomization uiCustomization = new Stripe3ds2UiCustomization.Builder().build();

            public final Builder setTimeout(int i) {
                Builder builder = this;
                builder.timeout = i;
                return builder;
            }

            public final Builder setUiCustomization(Stripe3ds2UiCustomization stripe3ds2UiCustomization) {
                Intrinsics.checkNotNullParameter(stripe3ds2UiCustomization, "uiCustomization");
                Builder builder = this;
                builder.uiCustomization = stripe3ds2UiCustomization;
                return builder;
            }

            public Stripe3ds2Config build() {
                return new Stripe3ds2Config(this.timeout, this.uiCustomization);
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/PaymentAuthConfig$Stripe3ds2Config$Companion;", "", "()V", "DEFAULT_TIMEOUT", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentAuthConfig.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0011B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\bJ\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/stripe/android/PaymentAuthConfig$Stripe3ds2ButtonCustomization;", "", "buttonCustomization", "Lcom/stripe/android/stripe3ds2/init/ui/ButtonCustomization;", "(Lcom/stripe/android/stripe3ds2/init/ui/ButtonCustomization;)V", "getButtonCustomization$payments_core_release", "()Lcom/stripe/android/stripe3ds2/init/ui/ButtonCustomization;", "component1", "component1$payments_core_release", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Builder", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentAuthConfig.kt */
    public static final class Stripe3ds2ButtonCustomization {
        public static final int $stable = 8;
        private final ButtonCustomization buttonCustomization;

        public static /* synthetic */ Stripe3ds2ButtonCustomization copy$default(Stripe3ds2ButtonCustomization stripe3ds2ButtonCustomization, ButtonCustomization buttonCustomization2, int i, Object obj) {
            if ((i & 1) != 0) {
                buttonCustomization2 = stripe3ds2ButtonCustomization.buttonCustomization;
            }
            return stripe3ds2ButtonCustomization.copy(buttonCustomization2);
        }

        public final ButtonCustomization component1$payments_core_release() {
            return this.buttonCustomization;
        }

        public final Stripe3ds2ButtonCustomization copy(ButtonCustomization buttonCustomization2) {
            Intrinsics.checkNotNullParameter(buttonCustomization2, "buttonCustomization");
            return new Stripe3ds2ButtonCustomization(buttonCustomization2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Stripe3ds2ButtonCustomization) && Intrinsics.areEqual((Object) this.buttonCustomization, (Object) ((Stripe3ds2ButtonCustomization) obj).buttonCustomization);
        }

        public int hashCode() {
            return this.buttonCustomization.hashCode();
        }

        public String toString() {
            return "Stripe3ds2ButtonCustomization(buttonCustomization=" + this.buttonCustomization + ')';
        }

        public Stripe3ds2ButtonCustomization(ButtonCustomization buttonCustomization2) {
            Intrinsics.checkNotNullParameter(buttonCustomization2, "buttonCustomization");
            this.buttonCustomization = buttonCustomization2;
        }

        public final ButtonCustomization getButtonCustomization$payments_core_release() {
            return this.buttonCustomization;
        }

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\tJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/stripe/android/PaymentAuthConfig$Stripe3ds2ButtonCustomization$Builder;", "Lcom/stripe/android/ObjectBuilder;", "Lcom/stripe/android/PaymentAuthConfig$Stripe3ds2ButtonCustomization;", "()V", "buttonCustomization", "Lcom/stripe/android/stripe3ds2/init/ui/ButtonCustomization;", "build", "setBackgroundColor", "hexColor", "", "setCornerRadius", "cornerRadius", "", "setTextColor", "setTextFontName", "fontName", "setTextFontSize", "fontSize", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentAuthConfig.kt */
        public static final class Builder implements ObjectBuilder<Stripe3ds2ButtonCustomization> {
            public static final int $stable = 8;
            private final ButtonCustomization buttonCustomization = new StripeButtonCustomization();

            public final Builder setBackgroundColor(String str) throws RuntimeException {
                Intrinsics.checkNotNullParameter(str, "hexColor");
                Builder builder = this;
                builder.buttonCustomization.setBackgroundColor(str);
                return builder;
            }

            public final Builder setCornerRadius(int i) throws RuntimeException {
                Builder builder = this;
                builder.buttonCustomization.setCornerRadius(i);
                return builder;
            }

            public final Builder setTextFontName(String str) throws RuntimeException {
                Intrinsics.checkNotNullParameter(str, "fontName");
                Builder builder = this;
                builder.buttonCustomization.setTextFontName(str);
                return builder;
            }

            public final Builder setTextColor(String str) throws RuntimeException {
                Intrinsics.checkNotNullParameter(str, "hexColor");
                Builder builder = this;
                builder.buttonCustomization.setTextColor(str);
                return builder;
            }

            public final Builder setTextFontSize(int i) throws RuntimeException {
                Builder builder = this;
                builder.buttonCustomization.setTextFontSize(i);
                return builder;
            }

            public Stripe3ds2ButtonCustomization build() {
                return new Stripe3ds2ButtonCustomization(this.buttonCustomization);
            }
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0011B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\bJ\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/stripe/android/PaymentAuthConfig$Stripe3ds2LabelCustomization;", "", "labelCustomization", "Lcom/stripe/android/stripe3ds2/init/ui/LabelCustomization;", "(Lcom/stripe/android/stripe3ds2/init/ui/LabelCustomization;)V", "getLabelCustomization$payments_core_release", "()Lcom/stripe/android/stripe3ds2/init/ui/LabelCustomization;", "component1", "component1$payments_core_release", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Builder", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentAuthConfig.kt */
    public static final class Stripe3ds2LabelCustomization {
        public static final int $stable = 8;
        private final LabelCustomization labelCustomization;

        public static /* synthetic */ Stripe3ds2LabelCustomization copy$default(Stripe3ds2LabelCustomization stripe3ds2LabelCustomization, LabelCustomization labelCustomization2, int i, Object obj) {
            if ((i & 1) != 0) {
                labelCustomization2 = stripe3ds2LabelCustomization.labelCustomization;
            }
            return stripe3ds2LabelCustomization.copy(labelCustomization2);
        }

        public final LabelCustomization component1$payments_core_release() {
            return this.labelCustomization;
        }

        public final Stripe3ds2LabelCustomization copy(LabelCustomization labelCustomization2) {
            Intrinsics.checkNotNullParameter(labelCustomization2, "labelCustomization");
            return new Stripe3ds2LabelCustomization(labelCustomization2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Stripe3ds2LabelCustomization) && Intrinsics.areEqual((Object) this.labelCustomization, (Object) ((Stripe3ds2LabelCustomization) obj).labelCustomization);
        }

        public int hashCode() {
            return this.labelCustomization.hashCode();
        }

        public String toString() {
            return "Stripe3ds2LabelCustomization(labelCustomization=" + this.labelCustomization + ')';
        }

        public Stripe3ds2LabelCustomization(LabelCustomization labelCustomization2) {
            Intrinsics.checkNotNullParameter(labelCustomization2, "labelCustomization");
            this.labelCustomization = labelCustomization2;
        }

        public final LabelCustomization getLabelCustomization$payments_core_release() {
            return this.labelCustomization;
        }

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\tJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\tJ\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/stripe/android/PaymentAuthConfig$Stripe3ds2LabelCustomization$Builder;", "Lcom/stripe/android/ObjectBuilder;", "Lcom/stripe/android/PaymentAuthConfig$Stripe3ds2LabelCustomization;", "()V", "labelCustomization", "Lcom/stripe/android/stripe3ds2/init/ui/LabelCustomization;", "build", "setHeadingTextColor", "hexColor", "", "setHeadingTextFontName", "fontName", "setHeadingTextFontSize", "fontSize", "", "setTextColor", "setTextFontName", "setTextFontSize", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentAuthConfig.kt */
        public static final class Builder implements ObjectBuilder<Stripe3ds2LabelCustomization> {
            public static final int $stable = 8;
            private final LabelCustomization labelCustomization = new StripeLabelCustomization();

            public final Builder setHeadingTextColor(String str) throws RuntimeException {
                Intrinsics.checkNotNullParameter(str, "hexColor");
                Builder builder = this;
                builder.labelCustomization.setHeadingTextColor(str);
                return builder;
            }

            public final Builder setHeadingTextFontName(String str) throws RuntimeException {
                Intrinsics.checkNotNullParameter(str, "fontName");
                Builder builder = this;
                builder.labelCustomization.setHeadingTextFontName(str);
                return builder;
            }

            public final Builder setHeadingTextFontSize(int i) throws RuntimeException {
                Builder builder = this;
                builder.labelCustomization.setHeadingTextFontSize(i);
                return builder;
            }

            public final Builder setTextFontName(String str) throws RuntimeException {
                Intrinsics.checkNotNullParameter(str, "fontName");
                Builder builder = this;
                builder.labelCustomization.setTextFontName(str);
                return builder;
            }

            public final Builder setTextColor(String str) throws RuntimeException {
                Intrinsics.checkNotNullParameter(str, "hexColor");
                Builder builder = this;
                builder.labelCustomization.setTextColor(str);
                return builder;
            }

            public final Builder setTextFontSize(int i) throws RuntimeException {
                Builder builder = this;
                builder.labelCustomization.setTextFontSize(i);
                return builder;
            }

            public Stripe3ds2LabelCustomization build() {
                return new Stripe3ds2LabelCustomization(this.labelCustomization);
            }
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0011B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\bJ\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/stripe/android/PaymentAuthConfig$Stripe3ds2TextBoxCustomization;", "", "textBoxCustomization", "Lcom/stripe/android/stripe3ds2/init/ui/TextBoxCustomization;", "(Lcom/stripe/android/stripe3ds2/init/ui/TextBoxCustomization;)V", "getTextBoxCustomization$payments_core_release", "()Lcom/stripe/android/stripe3ds2/init/ui/TextBoxCustomization;", "component1", "component1$payments_core_release", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Builder", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentAuthConfig.kt */
    public static final class Stripe3ds2TextBoxCustomization {
        public static final int $stable = 8;
        private final TextBoxCustomization textBoxCustomization;

        public static /* synthetic */ Stripe3ds2TextBoxCustomization copy$default(Stripe3ds2TextBoxCustomization stripe3ds2TextBoxCustomization, TextBoxCustomization textBoxCustomization2, int i, Object obj) {
            if ((i & 1) != 0) {
                textBoxCustomization2 = stripe3ds2TextBoxCustomization.textBoxCustomization;
            }
            return stripe3ds2TextBoxCustomization.copy(textBoxCustomization2);
        }

        public final TextBoxCustomization component1$payments_core_release() {
            return this.textBoxCustomization;
        }

        public final Stripe3ds2TextBoxCustomization copy(TextBoxCustomization textBoxCustomization2) {
            Intrinsics.checkNotNullParameter(textBoxCustomization2, "textBoxCustomization");
            return new Stripe3ds2TextBoxCustomization(textBoxCustomization2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Stripe3ds2TextBoxCustomization) && Intrinsics.areEqual((Object) this.textBoxCustomization, (Object) ((Stripe3ds2TextBoxCustomization) obj).textBoxCustomization);
        }

        public int hashCode() {
            return this.textBoxCustomization.hashCode();
        }

        public String toString() {
            return "Stripe3ds2TextBoxCustomization(textBoxCustomization=" + this.textBoxCustomization + ')';
        }

        public Stripe3ds2TextBoxCustomization(TextBoxCustomization textBoxCustomization2) {
            Intrinsics.checkNotNullParameter(textBoxCustomization2, "textBoxCustomization");
            this.textBoxCustomization = textBoxCustomization2;
        }

        public final TextBoxCustomization getTextBoxCustomization$payments_core_release() {
            return this.textBoxCustomization;
        }

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\fJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\tJ\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/stripe/android/PaymentAuthConfig$Stripe3ds2TextBoxCustomization$Builder;", "Lcom/stripe/android/ObjectBuilder;", "Lcom/stripe/android/PaymentAuthConfig$Stripe3ds2TextBoxCustomization;", "()V", "textBoxCustomization", "Lcom/stripe/android/stripe3ds2/init/ui/TextBoxCustomization;", "build", "setBorderColor", "hexColor", "", "setBorderWidth", "borderWidth", "", "setCornerRadius", "cornerRadius", "setTextColor", "setTextFontName", "fontName", "setTextFontSize", "fontSize", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentAuthConfig.kt */
        public static final class Builder implements ObjectBuilder<Stripe3ds2TextBoxCustomization> {
            public static final int $stable = 8;
            private final TextBoxCustomization textBoxCustomization = new StripeTextBoxCustomization();

            public final Builder setBorderWidth(int i) throws RuntimeException {
                Builder builder = this;
                builder.textBoxCustomization.setBorderWidth(i);
                return builder;
            }

            public final Builder setBorderColor(String str) throws RuntimeException {
                Intrinsics.checkNotNullParameter(str, "hexColor");
                Builder builder = this;
                builder.textBoxCustomization.setBorderColor(str);
                return builder;
            }

            public final Builder setCornerRadius(int i) throws RuntimeException {
                Builder builder = this;
                builder.textBoxCustomization.setCornerRadius(i);
                return builder;
            }

            public final Builder setTextFontName(String str) throws RuntimeException {
                Intrinsics.checkNotNullParameter(str, "fontName");
                Builder builder = this;
                builder.textBoxCustomization.setTextFontName(str);
                return builder;
            }

            public final Builder setTextColor(String str) throws RuntimeException {
                Intrinsics.checkNotNullParameter(str, "hexColor");
                Builder builder = this;
                builder.textBoxCustomization.setTextColor(str);
                return builder;
            }

            public final Builder setTextFontSize(int i) throws RuntimeException {
                Builder builder = this;
                builder.textBoxCustomization.setTextFontSize(i);
                return builder;
            }

            public Stripe3ds2TextBoxCustomization build() {
                return new Stripe3ds2TextBoxCustomization(this.textBoxCustomization);
            }
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0011B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\bJ\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/stripe/android/PaymentAuthConfig$Stripe3ds2ToolbarCustomization;", "", "toolbarCustomization", "Lcom/stripe/android/stripe3ds2/init/ui/ToolbarCustomization;", "(Lcom/stripe/android/stripe3ds2/init/ui/ToolbarCustomization;)V", "getToolbarCustomization$payments_core_release", "()Lcom/stripe/android/stripe3ds2/init/ui/ToolbarCustomization;", "component1", "component1$payments_core_release", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Builder", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentAuthConfig.kt */
    public static final class Stripe3ds2ToolbarCustomization {
        public static final int $stable = 8;
        private final ToolbarCustomization toolbarCustomization;

        public static /* synthetic */ Stripe3ds2ToolbarCustomization copy$default(Stripe3ds2ToolbarCustomization stripe3ds2ToolbarCustomization, ToolbarCustomization toolbarCustomization2, int i, Object obj) {
            if ((i & 1) != 0) {
                toolbarCustomization2 = stripe3ds2ToolbarCustomization.toolbarCustomization;
            }
            return stripe3ds2ToolbarCustomization.copy(toolbarCustomization2);
        }

        public final ToolbarCustomization component1$payments_core_release() {
            return this.toolbarCustomization;
        }

        public final Stripe3ds2ToolbarCustomization copy(ToolbarCustomization toolbarCustomization2) {
            Intrinsics.checkNotNullParameter(toolbarCustomization2, "toolbarCustomization");
            return new Stripe3ds2ToolbarCustomization(toolbarCustomization2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Stripe3ds2ToolbarCustomization) && Intrinsics.areEqual((Object) this.toolbarCustomization, (Object) ((Stripe3ds2ToolbarCustomization) obj).toolbarCustomization);
        }

        public int hashCode() {
            return this.toolbarCustomization.hashCode();
        }

        public String toString() {
            return "Stripe3ds2ToolbarCustomization(toolbarCustomization=" + this.toolbarCustomization + ')';
        }

        public Stripe3ds2ToolbarCustomization(ToolbarCustomization toolbarCustomization2) {
            Intrinsics.checkNotNullParameter(toolbarCustomization2, "toolbarCustomization");
            this.toolbarCustomization = toolbarCustomization2;
        }

        public final ToolbarCustomization getToolbarCustomization$payments_core_release() {
            return this.toolbarCustomization;
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\tJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\tJ\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/stripe/android/PaymentAuthConfig$Stripe3ds2ToolbarCustomization$Builder;", "Lcom/stripe/android/ObjectBuilder;", "Lcom/stripe/android/PaymentAuthConfig$Stripe3ds2ToolbarCustomization;", "()V", "toolbarCustomization", "Lcom/stripe/android/stripe3ds2/init/ui/ToolbarCustomization;", "build", "setBackgroundColor", "hexColor", "", "setButtonText", "buttonText", "setHeaderText", "headerText", "setStatusBarColor", "setTextColor", "setTextFontName", "fontName", "setTextFontSize", "fontSize", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentAuthConfig.kt */
        public static final class Builder implements ObjectBuilder<Stripe3ds2ToolbarCustomization> {
            public static final int $stable = 8;
            private final ToolbarCustomization toolbarCustomization = new StripeToolbarCustomization();

            public final Builder setBackgroundColor(String str) throws RuntimeException {
                Intrinsics.checkNotNullParameter(str, "hexColor");
                Builder builder = this;
                builder.toolbarCustomization.setBackgroundColor(str);
                return builder;
            }

            public final Builder setStatusBarColor(String str) throws RuntimeException {
                Intrinsics.checkNotNullParameter(str, "hexColor");
                Builder builder = this;
                builder.toolbarCustomization.setStatusBarColor(str);
                return builder;
            }

            public final Builder setHeaderText(String str) throws RuntimeException {
                Intrinsics.checkNotNullParameter(str, "headerText");
                Builder builder = this;
                builder.toolbarCustomization.setHeaderText(str);
                return builder;
            }

            public final Builder setButtonText(String str) throws RuntimeException {
                Intrinsics.checkNotNullParameter(str, "buttonText");
                Builder builder = this;
                builder.toolbarCustomization.setButtonText(str);
                return builder;
            }

            public final Builder setTextFontName(String str) throws RuntimeException {
                Intrinsics.checkNotNullParameter(str, "fontName");
                Builder builder = this;
                builder.toolbarCustomization.setTextFontName(str);
                return builder;
            }

            public final Builder setTextColor(String str) throws RuntimeException {
                Intrinsics.checkNotNullParameter(str, "hexColor");
                Builder builder = this;
                builder.toolbarCustomization.setTextColor(str);
                return builder;
            }

            public final Builder setTextFontSize(int i) throws RuntimeException {
                Builder builder = this;
                builder.toolbarCustomization.setTextFontSize(i);
                return builder;
            }

            public Stripe3ds2ToolbarCustomization build() {
                return new Stripe3ds2ToolbarCustomization(this.toolbarCustomization);
            }
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001:\u0002\u0017\u0018B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0019"}, d2 = {"Lcom/stripe/android/PaymentAuthConfig$Stripe3ds2UiCustomization;", "Landroid/os/Parcelable;", "uiCustomization", "Lcom/stripe/android/stripe3ds2/init/ui/StripeUiCustomization;", "(Lcom/stripe/android/stripe3ds2/init/ui/StripeUiCustomization;)V", "getUiCustomization", "()Lcom/stripe/android/stripe3ds2/init/ui/StripeUiCustomization;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Builder", "ButtonType", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentAuthConfig.kt */
    public static final class Stripe3ds2UiCustomization implements Parcelable {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Stripe3ds2UiCustomization> CREATOR = new Creator();
        private final StripeUiCustomization uiCustomization;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/stripe/android/PaymentAuthConfig$Stripe3ds2UiCustomization$ButtonType;", "", "(Ljava/lang/String;I)V", "SUBMIT", "CONTINUE", "NEXT", "CANCEL", "RESEND", "SELECT", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentAuthConfig.kt */
        public enum ButtonType {
            SUBMIT,
            CONTINUE,
            NEXT,
            CANCEL,
            RESEND,
            SELECT
        }

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentAuthConfig.kt */
        public static final class Creator implements Parcelable.Creator<Stripe3ds2UiCustomization> {
            public final Stripe3ds2UiCustomization createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Stripe3ds2UiCustomization((StripeUiCustomization) parcel.readParcelable(Stripe3ds2UiCustomization.class.getClassLoader()));
            }

            public final Stripe3ds2UiCustomization[] newArray(int i) {
                return new Stripe3ds2UiCustomization[i];
            }
        }

        public static /* synthetic */ Stripe3ds2UiCustomization copy$default(Stripe3ds2UiCustomization stripe3ds2UiCustomization, StripeUiCustomization stripeUiCustomization, int i, Object obj) {
            if ((i & 1) != 0) {
                stripeUiCustomization = stripe3ds2UiCustomization.uiCustomization;
            }
            return stripe3ds2UiCustomization.copy(stripeUiCustomization);
        }

        public final StripeUiCustomization component1() {
            return this.uiCustomization;
        }

        public final Stripe3ds2UiCustomization copy(StripeUiCustomization stripeUiCustomization) {
            Intrinsics.checkNotNullParameter(stripeUiCustomization, "uiCustomization");
            return new Stripe3ds2UiCustomization(stripeUiCustomization);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Stripe3ds2UiCustomization) && Intrinsics.areEqual((Object) this.uiCustomization, (Object) ((Stripe3ds2UiCustomization) obj).uiCustomization);
        }

        public int hashCode() {
            return this.uiCustomization.hashCode();
        }

        public String toString() {
            return "Stripe3ds2UiCustomization(uiCustomization=" + this.uiCustomization + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeParcelable(this.uiCustomization, i);
        }

        public Stripe3ds2UiCustomization(StripeUiCustomization stripeUiCustomization) {
            Intrinsics.checkNotNullParameter(stripeUiCustomization, "uiCustomization");
            this.uiCustomization = stripeUiCustomization;
        }

        public final StripeUiCustomization getUiCustomization() {
            return this.uiCustomization;
        }

        @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB\u0007\b\u0016¢\u0006\u0002\u0010\u0003B\u000f\b\u0012\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001dR\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/stripe/android/PaymentAuthConfig$Stripe3ds2UiCustomization$Builder;", "Lcom/stripe/android/ObjectBuilder;", "Lcom/stripe/android/PaymentAuthConfig$Stripe3ds2UiCustomization;", "()V", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "uiCustomization", "Lcom/stripe/android/stripe3ds2/init/ui/StripeUiCustomization;", "(Lcom/stripe/android/stripe3ds2/init/ui/StripeUiCustomization;)V", "build", "getUiButtonType", "Lcom/stripe/android/stripe3ds2/init/ui/UiCustomization$ButtonType;", "buttonType", "Lcom/stripe/android/PaymentAuthConfig$Stripe3ds2UiCustomization$ButtonType;", "setAccentColor", "hexColor", "", "setButtonCustomization", "buttonCustomization", "Lcom/stripe/android/PaymentAuthConfig$Stripe3ds2ButtonCustomization;", "setLabelCustomization", "labelCustomization", "Lcom/stripe/android/PaymentAuthConfig$Stripe3ds2LabelCustomization;", "setTextBoxCustomization", "textBoxCustomization", "Lcom/stripe/android/PaymentAuthConfig$Stripe3ds2TextBoxCustomization;", "setToolbarCustomization", "toolbarCustomization", "Lcom/stripe/android/PaymentAuthConfig$Stripe3ds2ToolbarCustomization;", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentAuthConfig.kt */
        public static final class Builder implements ObjectBuilder<Stripe3ds2UiCustomization> {
            public static final int $stable = 8;
            public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
            private final StripeUiCustomization uiCustomization;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* compiled from: PaymentAuthConfig.kt */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[ButtonType.values().length];
                    iArr[ButtonType.SUBMIT.ordinal()] = 1;
                    iArr[ButtonType.CONTINUE.ordinal()] = 2;
                    iArr[ButtonType.NEXT.ordinal()] = 3;
                    iArr[ButtonType.CANCEL.ordinal()] = 4;
                    iArr[ButtonType.RESEND.ordinal()] = 5;
                    iArr[ButtonType.SELECT.ordinal()] = 6;
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            public /* synthetic */ Builder(Activity activity, DefaultConstructorMarker defaultConstructorMarker) {
                this(activity);
            }

            @JvmStatic
            public static final Builder createWithAppTheme(Activity activity) {
                return Companion.createWithAppTheme(activity);
            }

            private Builder(StripeUiCustomization stripeUiCustomization) {
                this.uiCustomization = stripeUiCustomization;
            }

            public Builder() {
                this(new StripeUiCustomization());
            }

            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private Builder(android.app.Activity r2) {
                /*
                    r1 = this;
                    com.stripe.android.stripe3ds2.init.ui.StripeUiCustomization r2 = com.stripe.android.stripe3ds2.init.ui.StripeUiCustomization.createWithAppTheme(r2)
                    java.lang.String r0 = "createWithAppTheme(activity)"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
                    r1.<init>((com.stripe.android.stripe3ds2.init.ui.StripeUiCustomization) r2)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.PaymentAuthConfig.Stripe3ds2UiCustomization.Builder.<init>(android.app.Activity):void");
            }

            private final UiCustomization.ButtonType getUiButtonType(ButtonType buttonType) throws RuntimeException {
                switch (WhenMappings.$EnumSwitchMapping$0[buttonType.ordinal()]) {
                    case 1:
                        return UiCustomization.ButtonType.SUBMIT;
                    case 2:
                        return UiCustomization.ButtonType.CONTINUE;
                    case 3:
                        return UiCustomization.ButtonType.NEXT;
                    case 4:
                        return UiCustomization.ButtonType.CANCEL;
                    case 5:
                        return UiCustomization.ButtonType.RESEND;
                    case 6:
                        return UiCustomization.ButtonType.SELECT;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            }

            public final Builder setButtonCustomization(Stripe3ds2ButtonCustomization stripe3ds2ButtonCustomization, ButtonType buttonType) throws RuntimeException {
                Intrinsics.checkNotNullParameter(stripe3ds2ButtonCustomization, "buttonCustomization");
                Intrinsics.checkNotNullParameter(buttonType, "buttonType");
                Builder builder = this;
                builder.uiCustomization.setButtonCustomization(stripe3ds2ButtonCustomization.getButtonCustomization$payments_core_release(), builder.getUiButtonType(buttonType));
                return builder;
            }

            public final Builder setToolbarCustomization(Stripe3ds2ToolbarCustomization stripe3ds2ToolbarCustomization) throws RuntimeException {
                Intrinsics.checkNotNullParameter(stripe3ds2ToolbarCustomization, "toolbarCustomization");
                Builder builder = this;
                builder.uiCustomization.setToolbarCustomization(stripe3ds2ToolbarCustomization.getToolbarCustomization$payments_core_release());
                return builder;
            }

            public final Builder setLabelCustomization(Stripe3ds2LabelCustomization stripe3ds2LabelCustomization) throws RuntimeException {
                Intrinsics.checkNotNullParameter(stripe3ds2LabelCustomization, "labelCustomization");
                Builder builder = this;
                builder.uiCustomization.setLabelCustomization(stripe3ds2LabelCustomization.getLabelCustomization$payments_core_release());
                return builder;
            }

            public final Builder setTextBoxCustomization(Stripe3ds2TextBoxCustomization stripe3ds2TextBoxCustomization) throws RuntimeException {
                Intrinsics.checkNotNullParameter(stripe3ds2TextBoxCustomization, "textBoxCustomization");
                Builder builder = this;
                builder.uiCustomization.setTextBoxCustomization(stripe3ds2TextBoxCustomization.getTextBoxCustomization$payments_core_release());
                return builder;
            }

            public final Builder setAccentColor(String str) throws RuntimeException {
                Intrinsics.checkNotNullParameter(str, "hexColor");
                Builder builder = this;
                builder.uiCustomization.setAccentColor(str);
                return builder;
            }

            public Stripe3ds2UiCustomization build() {
                return new Stripe3ds2UiCustomization(this.uiCustomization);
            }

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/PaymentAuthConfig$Stripe3ds2UiCustomization$Builder$Companion;", "", "()V", "createWithAppTheme", "Lcom/stripe/android/PaymentAuthConfig$Stripe3ds2UiCustomization$Builder;", "activity", "Landroid/app/Activity;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
            /* compiled from: PaymentAuthConfig.kt */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                @JvmStatic
                public final Builder createWithAppTheme(Activity activity) {
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    return new Builder(activity, (DefaultConstructorMarker) null);
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0007J\r\u0010\n\u001a\u00020\bH\u0000¢\u0006\u0002\b\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/stripe/android/PaymentAuthConfig$Companion;", "", "()V", "DEFAULT", "Lcom/stripe/android/PaymentAuthConfig;", "instance", "get", "init", "", "config", "reset", "reset$payments_core_release", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentAuthConfig.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final void init(PaymentAuthConfig paymentAuthConfig) {
            Intrinsics.checkNotNullParameter(paymentAuthConfig, "config");
            PaymentAuthConfig.instance = paymentAuthConfig;
        }

        @JvmStatic
        public final PaymentAuthConfig get() {
            PaymentAuthConfig access$getInstance$cp = PaymentAuthConfig.instance;
            return access$getInstance$cp == null ? PaymentAuthConfig.DEFAULT : access$getInstance$cp;
        }

        public final /* synthetic */ void reset$payments_core_release() {
            PaymentAuthConfig.instance = null;
        }
    }
}
