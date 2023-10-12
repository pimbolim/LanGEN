package com.stripe.android.paymentsheet;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.result.contract.ActivityResultContract;
import com.braintreepayments.api.internal.GraphQLConstants;
import com.stripe.android.core.injection.InjectorKey;
import com.stripe.android.model.PaymentMethod;
import com.stripe.android.model.StripeIntent;
import com.stripe.android.payments.core.injection.NamedConstantsKt;
import com.stripe.android.paymentsheet.PaymentSheet;
import com.stripe.android.paymentsheet.model.PaymentSelection;
import com.stripe.android.view.ActivityStarter;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u0000 \u000f2\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001:\u0002\u000e\u000fB\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u001c\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0010"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentOptionContract;", "Landroidx/activity/result/contract/ActivityResultContract;", "Lcom/stripe/android/paymentsheet/PaymentOptionContract$Args;", "Lcom/stripe/android/paymentsheet/PaymentOptionResult;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "parseResult", "resultCode", "", "intent", "Args", "Companion", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentOptionContract.kt */
public final class PaymentOptionContract extends ActivityResultContract<Args, PaymentOptionResult> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EXTRA_ARGS = "extra_activity_args";

    public Intent createIntent(Context context, Args args) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(args, GraphQLConstants.Keys.INPUT);
        Intent putExtra = new Intent(context, PaymentOptionsActivity.class).putExtra("extra_activity_args", args);
        Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(context, PaymentO…tExtra(EXTRA_ARGS, input)");
        return putExtra;
    }

    public PaymentOptionResult parseResult(int i, Intent intent) {
        return PaymentOptionResult.Companion.fromIntent$paymentsheet_release(intent);
    }

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b \n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 <2\u00020\u0001:\u0001<Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0001\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\n\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u0013¢\u0006\u0002\u0010\u0014J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u000f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010)\u001a\u00020\nHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\"J\t\u0010,\u001a\u00020\u0010HÆ\u0003J\t\u0010-\u001a\u00020\nHÆ\u0003J\u000f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00100\u0013HÆ\u0003Jz\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0003\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\n2\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u0013HÆ\u0001¢\u0006\u0002\u00100J\t\u00101\u001a\u00020\u000eHÖ\u0001J\u0013\u00102\u001a\u00020\n2\b\u00103\u001a\u0004\u0018\u000104HÖ\u0003J\t\u00105\u001a\u00020\u000eHÖ\u0001J\t\u00106\u001a\u00020\u0010HÖ\u0001J\u0019\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u000eHÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0011\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0018R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u0006="}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentOptionContract$Args;", "Lcom/stripe/android/view/ActivityStarter$Args;", "stripeIntent", "Lcom/stripe/android/model/StripeIntent;", "paymentMethods", "", "Lcom/stripe/android/model/PaymentMethod;", "config", "Lcom/stripe/android/paymentsheet/PaymentSheet$Configuration;", "isGooglePayReady", "", "newCard", "Lcom/stripe/android/paymentsheet/model/PaymentSelection$New$Card;", "statusBarColor", "", "injectorKey", "", "enableLogging", "productUsage", "", "(Lcom/stripe/android/model/StripeIntent;Ljava/util/List;Lcom/stripe/android/paymentsheet/PaymentSheet$Configuration;ZLcom/stripe/android/paymentsheet/model/PaymentSelection$New$Card;Ljava/lang/Integer;Ljava/lang/String;ZLjava/util/Set;)V", "getConfig", "()Lcom/stripe/android/paymentsheet/PaymentSheet$Configuration;", "getEnableLogging", "()Z", "getInjectorKey", "()Ljava/lang/String;", "getNewCard", "()Lcom/stripe/android/paymentsheet/model/PaymentSelection$New$Card;", "getPaymentMethods", "()Ljava/util/List;", "getProductUsage", "()Ljava/util/Set;", "getStatusBarColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getStripeIntent", "()Lcom/stripe/android/model/StripeIntent;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lcom/stripe/android/model/StripeIntent;Ljava/util/List;Lcom/stripe/android/paymentsheet/PaymentSheet$Configuration;ZLcom/stripe/android/paymentsheet/model/PaymentSelection$New$Card;Ljava/lang/Integer;Ljava/lang/String;ZLjava/util/Set;)Lcom/stripe/android/paymentsheet/PaymentOptionContract$Args;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentOptionContract.kt */
    public static final class Args implements ActivityStarter.Args {
        public static final Parcelable.Creator<Args> CREATOR = new Creator();
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final PaymentSheet.Configuration config;
        private final boolean enableLogging;
        private final String injectorKey;
        private final boolean isGooglePayReady;
        private final PaymentSelection.New.Card newCard;
        private final List<PaymentMethod> paymentMethods;
        private final Set<String> productUsage;
        private final Integer statusBarColor;
        private final StripeIntent stripeIntent;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentOptionContract.kt */
        public static final class Creator implements Parcelable.Creator<Args> {
            public final Args createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                StripeIntent stripeIntent = (StripeIntent) parcel.readParcelable(Args.class.getClassLoader());
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                for (int i = 0; i != readInt; i++) {
                    arrayList.add(parcel.readParcelable(Args.class.getClassLoader()));
                }
                List list = arrayList;
                PaymentSheet.Configuration createFromParcel = parcel.readInt() == 0 ? null : PaymentSheet.Configuration.CREATOR.createFromParcel(parcel);
                boolean z = parcel.readInt() != 0;
                PaymentSelection.New.Card createFromParcel2 = parcel.readInt() == 0 ? null : PaymentSelection.New.Card.CREATOR.createFromParcel(parcel);
                Integer valueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
                String readString = parcel.readString();
                boolean z2 = parcel.readInt() != 0;
                int readInt2 = parcel.readInt();
                LinkedHashSet linkedHashSet = new LinkedHashSet(readInt2);
                for (int i2 = 0; i2 != readInt2; i2++) {
                    linkedHashSet.add(parcel.readString());
                }
                return new Args(stripeIntent, list, createFromParcel, z, createFromParcel2, valueOf, readString, z2, linkedHashSet);
            }

            public final Args[] newArray(int i) {
                return new Args[i];
            }
        }

        public static /* synthetic */ Args copy$default(Args args, StripeIntent stripeIntent2, List list, PaymentSheet.Configuration configuration, boolean z, PaymentSelection.New.Card card, Integer num, String str, boolean z2, Set set, int i, Object obj) {
            Args args2 = args;
            int i2 = i;
            return args.copy((i2 & 1) != 0 ? args2.stripeIntent : stripeIntent2, (i2 & 2) != 0 ? args2.paymentMethods : list, (i2 & 4) != 0 ? args2.config : configuration, (i2 & 8) != 0 ? args2.isGooglePayReady : z, (i2 & 16) != 0 ? args2.newCard : card, (i2 & 32) != 0 ? args2.statusBarColor : num, (i2 & 64) != 0 ? args2.injectorKey : str, (i2 & 128) != 0 ? args2.enableLogging : z2, (i2 & 256) != 0 ? args2.productUsage : set);
        }

        public final StripeIntent component1() {
            return this.stripeIntent;
        }

        public final List<PaymentMethod> component2() {
            return this.paymentMethods;
        }

        public final PaymentSheet.Configuration component3() {
            return this.config;
        }

        public final boolean component4() {
            return this.isGooglePayReady;
        }

        public final PaymentSelection.New.Card component5() {
            return this.newCard;
        }

        public final Integer component6() {
            return this.statusBarColor;
        }

        public final String component7() {
            return this.injectorKey;
        }

        public final boolean component8() {
            return this.enableLogging;
        }

        public final Set<String> component9() {
            return this.productUsage;
        }

        public final Args copy(StripeIntent stripeIntent2, List<PaymentMethod> list, PaymentSheet.Configuration configuration, boolean z, PaymentSelection.New.Card card, Integer num, @InjectorKey String str, boolean z2, Set<String> set) {
            Intrinsics.checkNotNullParameter(stripeIntent2, "stripeIntent");
            Intrinsics.checkNotNullParameter(list, "paymentMethods");
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "injectorKey");
            Set<String> set2 = set;
            Intrinsics.checkNotNullParameter(set2, NamedConstantsKt.PRODUCT_USAGE);
            return new Args(stripeIntent2, list, configuration, z, card, num, str2, z2, set2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Args)) {
                return false;
            }
            Args args = (Args) obj;
            return Intrinsics.areEqual((Object) this.stripeIntent, (Object) args.stripeIntent) && Intrinsics.areEqual((Object) this.paymentMethods, (Object) args.paymentMethods) && Intrinsics.areEqual((Object) this.config, (Object) args.config) && this.isGooglePayReady == args.isGooglePayReady && Intrinsics.areEqual((Object) this.newCard, (Object) args.newCard) && Intrinsics.areEqual((Object) this.statusBarColor, (Object) args.statusBarColor) && Intrinsics.areEqual((Object) this.injectorKey, (Object) args.injectorKey) && this.enableLogging == args.enableLogging && Intrinsics.areEqual((Object) this.productUsage, (Object) args.productUsage);
        }

        public int hashCode() {
            int hashCode = ((this.stripeIntent.hashCode() * 31) + this.paymentMethods.hashCode()) * 31;
            PaymentSheet.Configuration configuration = this.config;
            int i = 0;
            int hashCode2 = (hashCode + (configuration == null ? 0 : configuration.hashCode())) * 31;
            boolean z = this.isGooglePayReady;
            boolean z2 = true;
            if (z) {
                z = true;
            }
            int i2 = (hashCode2 + (z ? 1 : 0)) * 31;
            PaymentSelection.New.Card card = this.newCard;
            int hashCode3 = (i2 + (card == null ? 0 : card.hashCode())) * 31;
            Integer num = this.statusBarColor;
            if (num != null) {
                i = num.hashCode();
            }
            int hashCode4 = (((hashCode3 + i) * 31) + this.injectorKey.hashCode()) * 31;
            boolean z3 = this.enableLogging;
            if (!z3) {
                z2 = z3;
            }
            return ((hashCode4 + (z2 ? 1 : 0)) * 31) + this.productUsage.hashCode();
        }

        public String toString() {
            return "Args(stripeIntent=" + this.stripeIntent + ", paymentMethods=" + this.paymentMethods + ", config=" + this.config + ", isGooglePayReady=" + this.isGooglePayReady + ", newCard=" + this.newCard + ", statusBarColor=" + this.statusBarColor + ", injectorKey=" + this.injectorKey + ", enableLogging=" + this.enableLogging + ", productUsage=" + this.productUsage + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeParcelable(this.stripeIntent, i);
            List<PaymentMethod> list = this.paymentMethods;
            parcel.writeInt(list.size());
            for (PaymentMethod writeParcelable : list) {
                parcel.writeParcelable(writeParcelable, i);
            }
            PaymentSheet.Configuration configuration = this.config;
            if (configuration == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                configuration.writeToParcel(parcel, i);
            }
            parcel.writeInt(this.isGooglePayReady ? 1 : 0);
            PaymentSelection.New.Card card = this.newCard;
            if (card == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                card.writeToParcel(parcel, i);
            }
            Integer num = this.statusBarColor;
            if (num == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeInt(num.intValue());
            }
            parcel.writeString(this.injectorKey);
            parcel.writeInt(this.enableLogging ? 1 : 0);
            Set<String> set = this.productUsage;
            parcel.writeInt(set.size());
            for (String writeString : set) {
                parcel.writeString(writeString);
            }
        }

        public Args(StripeIntent stripeIntent2, List<PaymentMethod> list, PaymentSheet.Configuration configuration, boolean z, PaymentSelection.New.Card card, Integer num, @InjectorKey String str, boolean z2, Set<String> set) {
            Intrinsics.checkNotNullParameter(stripeIntent2, "stripeIntent");
            Intrinsics.checkNotNullParameter(list, "paymentMethods");
            Intrinsics.checkNotNullParameter(str, "injectorKey");
            Intrinsics.checkNotNullParameter(set, NamedConstantsKt.PRODUCT_USAGE);
            this.stripeIntent = stripeIntent2;
            this.paymentMethods = list;
            this.config = configuration;
            this.isGooglePayReady = z;
            this.newCard = card;
            this.statusBarColor = num;
            this.injectorKey = str;
            this.enableLogging = z2;
            this.productUsage = set;
        }

        public final StripeIntent getStripeIntent() {
            return this.stripeIntent;
        }

        public final List<PaymentMethod> getPaymentMethods() {
            return this.paymentMethods;
        }

        public final PaymentSheet.Configuration getConfig() {
            return this.config;
        }

        public final boolean isGooglePayReady() {
            return this.isGooglePayReady;
        }

        public final PaymentSelection.New.Card getNewCard() {
            return this.newCard;
        }

        public final Integer getStatusBarColor() {
            return this.statusBarColor;
        }

        public final String getInjectorKey() {
            return this.injectorKey;
        }

        public final boolean getEnableLogging() {
            return this.enableLogging;
        }

        public final Set<String> getProductUsage() {
            return this.productUsage;
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentOptionContract$Args$Companion;", "", "()V", "fromIntent", "Lcom/stripe/android/paymentsheet/PaymentOptionContract$Args;", "intent", "Landroid/content/Intent;", "fromIntent$paymentsheet_release", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentOptionContract.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Args fromIntent$paymentsheet_release(Intent intent) {
                Intrinsics.checkNotNullParameter(intent, "intent");
                return (Args) intent.getParcelableExtra("extra_activity_args");
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentOptionContract$Companion;", "", "()V", "EXTRA_ARGS", "", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentOptionContract.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
