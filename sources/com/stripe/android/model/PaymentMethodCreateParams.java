package com.stripe.android.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.CardUtils;
import com.stripe.android.ObjectBuilder;
import com.stripe.android.model.PaymentMethod;
import com.stripe.android.payments.core.injection.NamedConstantsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\b\u0018\u0000 a2\u00020\u00012\u00020\u0002:\f^_`abcdefghiB/\b\u0012\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\u0010\nB/\b\u0012\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\u0010\rB/\b\u0012\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\u0010\u0010B/\b\u0012\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\u0010\u0013B-\b\u0012\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\u0010\u0016B-\b\u0012\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\u0010\u0019B/\b\u0012\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\u0010\u001cB/\b\u0012\u0012\u0006\u0010\u001d\u001a\u00020\u001e\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\u0010\u001fB/\b\u0012\u0012\u0006\u0010 \u001a\u00020!\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\u0010\"B/\b\u0012\u0012\u0006\u0010#\u001a\u00020$\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\u0010%Bä\u0001\b\u0000\u0012\u0006\u0010&\u001a\u00020'\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u000e\b\u0002\u0010*\u001a\b\u0012\u0004\u0012\u00020\t0+\u0012\u001b\b\u0002\u0010,\u001a\u0015\u0012\u0004\u0012\u00020\t\u0012\t\u0012\u00070-¢\u0006\u0002\b.\u0018\u00010\b¢\u0006\u0002\u0010/J\u000e\u0010?\u001a\u00020'HÀ\u0003¢\u0006\u0002\b@J\u000b\u0010A\u001a\u0004\u0018\u00010!HÂ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010$HÂ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010)HÂ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0017\u0010E\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÂ\u0003J\u000f\u0010F\u001a\b\u0012\u0004\u0012\u00020\t0+HÂ\u0003J\u001c\u0010G\u001a\u0015\u0012\u0004\u0012\u00020\t\u0012\t\u0012\u00070-¢\u0006\u0002\b.\u0018\u00010\bHÂ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\fHÂ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u000fHÂ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0012HÂ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0015HÂ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0018HÂ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u001bHÂ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u001eHÂ\u0003Jè\u0001\u0010P\u001a\u00020\u00002\b\b\u0002\u0010&\u001a\u00020'2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u000e\b\u0002\u0010*\u001a\b\u0012\u0004\u0012\u00020\t0+2\u001b\b\u0002\u0010,\u001a\u0015\u0012\u0004\u0012\u00020\t\u0012\t\u0012\u00070-¢\u0006\u0002\b.\u0018\u00010\bHÆ\u0001J\t\u0010Q\u001a\u00020RHÖ\u0001J\u0013\u0010S\u001a\u00020T2\b\u0010U\u001a\u0004\u0018\u00010-HÖ\u0003J\t\u0010V\u001a\u00020RHÖ\u0001J\u0014\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020-0\bH\u0016J\t\u0010X\u001a\u00020\tHÖ\u0001J\u0019\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020RHÖ\u0001R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020\t0+8@X\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0004¢\u0006\u0002\n\u0000R!\u0010,\u001a\u0015\u0012\u0004\u0012\u00020\t\u0012\t\u0012\u00070-¢\u0006\u0002\b.\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020\t0+X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\u00020'X\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0011\u00109\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b:\u0010;R \u0010<\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020-0\b8BX\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0004¢\u0006\u0002\n\u0000¨\u0006j"}, d2 = {"Lcom/stripe/android/model/PaymentMethodCreateParams;", "Lcom/stripe/android/model/StripeParamsModel;", "Landroid/os/Parcelable;", "card", "Lcom/stripe/android/model/PaymentMethodCreateParams$Card;", "billingDetails", "Lcom/stripe/android/model/PaymentMethod$BillingDetails;", "metadata", "", "", "(Lcom/stripe/android/model/PaymentMethodCreateParams$Card;Lcom/stripe/android/model/PaymentMethod$BillingDetails;Ljava/util/Map;)V", "ideal", "Lcom/stripe/android/model/PaymentMethodCreateParams$Ideal;", "(Lcom/stripe/android/model/PaymentMethodCreateParams$Ideal;Lcom/stripe/android/model/PaymentMethod$BillingDetails;Ljava/util/Map;)V", "fpx", "Lcom/stripe/android/model/PaymentMethodCreateParams$Fpx;", "(Lcom/stripe/android/model/PaymentMethodCreateParams$Fpx;Lcom/stripe/android/model/PaymentMethod$BillingDetails;Ljava/util/Map;)V", "sepaDebit", "Lcom/stripe/android/model/PaymentMethodCreateParams$SepaDebit;", "(Lcom/stripe/android/model/PaymentMethodCreateParams$SepaDebit;Lcom/stripe/android/model/PaymentMethod$BillingDetails;Ljava/util/Map;)V", "auBecsDebit", "Lcom/stripe/android/model/PaymentMethodCreateParams$AuBecsDebit;", "(Lcom/stripe/android/model/PaymentMethodCreateParams$AuBecsDebit;Lcom/stripe/android/model/PaymentMethod$BillingDetails;Ljava/util/Map;)V", "bacsDebit", "Lcom/stripe/android/model/PaymentMethodCreateParams$BacsDebit;", "(Lcom/stripe/android/model/PaymentMethodCreateParams$BacsDebit;Lcom/stripe/android/model/PaymentMethod$BillingDetails;Ljava/util/Map;)V", "sofort", "Lcom/stripe/android/model/PaymentMethodCreateParams$Sofort;", "(Lcom/stripe/android/model/PaymentMethodCreateParams$Sofort;Lcom/stripe/android/model/PaymentMethod$BillingDetails;Ljava/util/Map;)V", "upi", "Lcom/stripe/android/model/PaymentMethodCreateParams$Upi;", "(Lcom/stripe/android/model/PaymentMethodCreateParams$Upi;Lcom/stripe/android/model/PaymentMethod$BillingDetails;Ljava/util/Map;)V", "netbanking", "Lcom/stripe/android/model/PaymentMethodCreateParams$Netbanking;", "(Lcom/stripe/android/model/PaymentMethodCreateParams$Netbanking;Lcom/stripe/android/model/PaymentMethod$BillingDetails;Ljava/util/Map;)V", "usBankAccount", "Lcom/stripe/android/model/PaymentMethodCreateParams$USBankAccount;", "(Lcom/stripe/android/model/PaymentMethodCreateParams$USBankAccount;Lcom/stripe/android/model/PaymentMethod$BillingDetails;Ljava/util/Map;)V", "type", "Lcom/stripe/android/model/PaymentMethod$Type;", "link", "Lcom/stripe/android/model/PaymentMethodCreateParams$Link;", "productUsage", "", "overrideParamMap", "", "Lkotlinx/parcelize/RawValue;", "(Lcom/stripe/android/model/PaymentMethod$Type;Lcom/stripe/android/model/PaymentMethodCreateParams$Card;Lcom/stripe/android/model/PaymentMethodCreateParams$Ideal;Lcom/stripe/android/model/PaymentMethodCreateParams$Fpx;Lcom/stripe/android/model/PaymentMethodCreateParams$SepaDebit;Lcom/stripe/android/model/PaymentMethodCreateParams$AuBecsDebit;Lcom/stripe/android/model/PaymentMethodCreateParams$BacsDebit;Lcom/stripe/android/model/PaymentMethodCreateParams$Sofort;Lcom/stripe/android/model/PaymentMethodCreateParams$Upi;Lcom/stripe/android/model/PaymentMethodCreateParams$Netbanking;Lcom/stripe/android/model/PaymentMethodCreateParams$USBankAccount;Lcom/stripe/android/model/PaymentMethodCreateParams$Link;Lcom/stripe/android/model/PaymentMethod$BillingDetails;Ljava/util/Map;Ljava/util/Set;Ljava/util/Map;)V", "attribution", "getAttribution$payments_core_release", "()Ljava/util/Set;", "getBillingDetails", "()Lcom/stripe/android/model/PaymentMethod$BillingDetails;", "getCard", "()Lcom/stripe/android/model/PaymentMethodCreateParams$Card;", "getType$payments_core_release", "()Lcom/stripe/android/model/PaymentMethod$Type;", "typeCode", "getTypeCode", "()Ljava/lang/String;", "typeParams", "getTypeParams", "()Ljava/util/Map;", "component1", "component1$payments_core_release", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "", "equals", "", "other", "hashCode", "toParamMap", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "AuBecsDebit", "BacsDebit", "Card", "Companion", "Fpx", "Ideal", "Link", "Netbanking", "SepaDebit", "Sofort", "USBankAccount", "Upi", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentMethodCreateParams.kt */
public final class PaymentMethodCreateParams implements StripeParamsModel, Parcelable {
    public static final int $stable = 8;
    public static final Parcelable.Creator<PaymentMethodCreateParams> CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String PARAM_BILLING_DETAILS = "billing_details";
    private static final String PARAM_METADATA = "metadata";
    private static final String PARAM_TYPE = "type";
    private final AuBecsDebit auBecsDebit;
    private final BacsDebit bacsDebit;
    private final PaymentMethod.BillingDetails billingDetails;
    private final Card card;
    private final Fpx fpx;
    private final Ideal ideal;
    private final Link link;
    private final Map<String, String> metadata;
    private final Netbanking netbanking;
    private final Map<String, Object> overrideParamMap;
    private final Set<String> productUsage;
    private final SepaDebit sepaDebit;
    private final Sofort sofort;
    private final PaymentMethod.Type type;
    private final Upi upi;
    private final USBankAccount usBankAccount;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethodCreateParams.kt */
    public static final class Creator implements Parcelable.Creator<PaymentMethodCreateParams> {
        public final PaymentMethodCreateParams createFromParcel(Parcel parcel) {
            Link link;
            PaymentMethod.BillingDetails billingDetails;
            LinkedHashMap linkedHashMap;
            Map map;
            LinkedHashMap linkedHashMap2;
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "parcel");
            PaymentMethod.Type createFromParcel = PaymentMethod.Type.CREATOR.createFromParcel(parcel2);
            Card createFromParcel2 = parcel.readInt() == 0 ? null : Card.CREATOR.createFromParcel(parcel2);
            Ideal createFromParcel3 = parcel.readInt() == 0 ? null : Ideal.CREATOR.createFromParcel(parcel2);
            Fpx createFromParcel4 = parcel.readInt() == 0 ? null : Fpx.CREATOR.createFromParcel(parcel2);
            SepaDebit createFromParcel5 = parcel.readInt() == 0 ? null : SepaDebit.CREATOR.createFromParcel(parcel2);
            AuBecsDebit createFromParcel6 = parcel.readInt() == 0 ? null : AuBecsDebit.CREATOR.createFromParcel(parcel2);
            BacsDebit createFromParcel7 = parcel.readInt() == 0 ? null : BacsDebit.CREATOR.createFromParcel(parcel2);
            Sofort createFromParcel8 = parcel.readInt() == 0 ? null : Sofort.CREATOR.createFromParcel(parcel2);
            Upi createFromParcel9 = parcel.readInt() == 0 ? null : Upi.CREATOR.createFromParcel(parcel2);
            Netbanking createFromParcel10 = parcel.readInt() == 0 ? null : Netbanking.CREATOR.createFromParcel(parcel2);
            USBankAccount createFromParcel11 = parcel.readInt() == 0 ? null : USBankAccount.CREATOR.createFromParcel(parcel2);
            Link createFromParcel12 = parcel.readInt() == 0 ? null : Link.CREATOR.createFromParcel(parcel2);
            PaymentMethod.BillingDetails createFromParcel13 = parcel.readInt() == 0 ? null : PaymentMethod.BillingDetails.CREATOR.createFromParcel(parcel2);
            if (parcel.readInt() == 0) {
                link = createFromParcel12;
                billingDetails = createFromParcel13;
                linkedHashMap = null;
            } else {
                int readInt = parcel.readInt();
                linkedHashMap = new LinkedHashMap(readInt);
                billingDetails = createFromParcel13;
                int i = 0;
                while (i != readInt) {
                    linkedHashMap.put(parcel.readString(), parcel.readString());
                    i++;
                    readInt = readInt;
                    createFromParcel12 = createFromParcel12;
                }
                link = createFromParcel12;
            }
            Map map2 = linkedHashMap;
            int readInt2 = parcel.readInt();
            LinkedHashSet linkedHashSet = new LinkedHashSet(readInt2);
            int i2 = 0;
            while (i2 != readInt2) {
                linkedHashSet.add(parcel.readString());
                i2++;
                readInt2 = readInt2;
            }
            Set set = linkedHashSet;
            if (parcel.readInt() == 0) {
                map = map2;
                linkedHashMap2 = null;
            } else {
                int readInt3 = parcel.readInt();
                LinkedHashMap linkedHashMap3 = new LinkedHashMap(readInt3);
                int i3 = 0;
                while (i3 != readInt3) {
                    linkedHashMap3.put(parcel.readString(), parcel2.readValue(PaymentMethodCreateParams.class.getClassLoader()));
                    i3++;
                    readInt3 = readInt3;
                    map2 = map2;
                }
                map = map2;
                linkedHashMap2 = linkedHashMap3;
            }
            return new PaymentMethodCreateParams(createFromParcel, createFromParcel2, createFromParcel3, createFromParcel4, createFromParcel5, createFromParcel6, createFromParcel7, createFromParcel8, createFromParcel9, createFromParcel10, createFromParcel11, link, billingDetails, map, set, linkedHashMap2);
        }

        public final PaymentMethodCreateParams[] newArray(int i) {
            return new PaymentMethodCreateParams[i];
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethodCreateParams.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PaymentMethod.Type.values().length];
            iArr[PaymentMethod.Type.Card.ordinal()] = 1;
            iArr[PaymentMethod.Type.Ideal.ordinal()] = 2;
            iArr[PaymentMethod.Type.Fpx.ordinal()] = 3;
            iArr[PaymentMethod.Type.SepaDebit.ordinal()] = 4;
            iArr[PaymentMethod.Type.AuBecsDebit.ordinal()] = 5;
            iArr[PaymentMethod.Type.BacsDebit.ordinal()] = 6;
            iArr[PaymentMethod.Type.Sofort.ordinal()] = 7;
            iArr[PaymentMethod.Type.Upi.ordinal()] = 8;
            iArr[PaymentMethod.Type.Netbanking.ordinal()] = 9;
            iArr[PaymentMethod.Type.USBankAccount.ordinal()] = 10;
            iArr[PaymentMethod.Type.Link.ordinal()] = 11;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ PaymentMethodCreateParams(AuBecsDebit auBecsDebit2, PaymentMethod.BillingDetails billingDetails2, Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(auBecsDebit2, billingDetails2, (Map<String, String>) map);
    }

    public /* synthetic */ PaymentMethodCreateParams(BacsDebit bacsDebit2, PaymentMethod.BillingDetails billingDetails2, Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(bacsDebit2, billingDetails2, (Map<String, String>) map);
    }

    public /* synthetic */ PaymentMethodCreateParams(Card card2, PaymentMethod.BillingDetails billingDetails2, Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(card2, billingDetails2, (Map<String, String>) map);
    }

    public /* synthetic */ PaymentMethodCreateParams(Fpx fpx2, PaymentMethod.BillingDetails billingDetails2, Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(fpx2, billingDetails2, (Map<String, String>) map);
    }

    public /* synthetic */ PaymentMethodCreateParams(Ideal ideal2, PaymentMethod.BillingDetails billingDetails2, Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(ideal2, billingDetails2, (Map<String, String>) map);
    }

    public /* synthetic */ PaymentMethodCreateParams(Netbanking netbanking2, PaymentMethod.BillingDetails billingDetails2, Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(netbanking2, billingDetails2, (Map<String, String>) map);
    }

    public /* synthetic */ PaymentMethodCreateParams(SepaDebit sepaDebit2, PaymentMethod.BillingDetails billingDetails2, Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(sepaDebit2, billingDetails2, (Map<String, String>) map);
    }

    public /* synthetic */ PaymentMethodCreateParams(Sofort sofort2, PaymentMethod.BillingDetails billingDetails2, Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(sofort2, billingDetails2, (Map<String, String>) map);
    }

    public /* synthetic */ PaymentMethodCreateParams(USBankAccount uSBankAccount, PaymentMethod.BillingDetails billingDetails2, Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(uSBankAccount, billingDetails2, (Map<String, String>) map);
    }

    public /* synthetic */ PaymentMethodCreateParams(Upi upi2, PaymentMethod.BillingDetails billingDetails2, Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(upi2, billingDetails2, (Map<String, String>) map);
    }

    private final Netbanking component10() {
        return this.netbanking;
    }

    private final USBankAccount component11() {
        return this.usBankAccount;
    }

    private final Link component12() {
        return this.link;
    }

    private final Map<String, String> component14() {
        return this.metadata;
    }

    private final Set<String> component15() {
        return this.productUsage;
    }

    private final Map<String, Object> component16() {
        return this.overrideParamMap;
    }

    private final Ideal component3() {
        return this.ideal;
    }

    private final Fpx component4() {
        return this.fpx;
    }

    private final SepaDebit component5() {
        return this.sepaDebit;
    }

    private final AuBecsDebit component6() {
        return this.auBecsDebit;
    }

    private final BacsDebit component7() {
        return this.bacsDebit;
    }

    private final Sofort component8() {
        return this.sofort;
    }

    private final Upi component9() {
        return this.upi;
    }

    public static /* synthetic */ PaymentMethodCreateParams copy$default(PaymentMethodCreateParams paymentMethodCreateParams, PaymentMethod.Type type2, Card card2, Ideal ideal2, Fpx fpx2, SepaDebit sepaDebit2, AuBecsDebit auBecsDebit2, BacsDebit bacsDebit2, Sofort sofort2, Upi upi2, Netbanking netbanking2, USBankAccount uSBankAccount, Link link2, PaymentMethod.BillingDetails billingDetails2, Map map, Set set, Map map2, int i, Object obj) {
        PaymentMethodCreateParams paymentMethodCreateParams2 = paymentMethodCreateParams;
        int i2 = i;
        return paymentMethodCreateParams.copy((i2 & 1) != 0 ? paymentMethodCreateParams2.type : type2, (i2 & 2) != 0 ? paymentMethodCreateParams2.card : card2, (i2 & 4) != 0 ? paymentMethodCreateParams2.ideal : ideal2, (i2 & 8) != 0 ? paymentMethodCreateParams2.fpx : fpx2, (i2 & 16) != 0 ? paymentMethodCreateParams2.sepaDebit : sepaDebit2, (i2 & 32) != 0 ? paymentMethodCreateParams2.auBecsDebit : auBecsDebit2, (i2 & 64) != 0 ? paymentMethodCreateParams2.bacsDebit : bacsDebit2, (i2 & 128) != 0 ? paymentMethodCreateParams2.sofort : sofort2, (i2 & 256) != 0 ? paymentMethodCreateParams2.upi : upi2, (i2 & 512) != 0 ? paymentMethodCreateParams2.netbanking : netbanking2, (i2 & 1024) != 0 ? paymentMethodCreateParams2.usBankAccount : uSBankAccount, (i2 & 2048) != 0 ? paymentMethodCreateParams2.link : link2, (i2 & 4096) != 0 ? paymentMethodCreateParams2.billingDetails : billingDetails2, (i2 & 8192) != 0 ? paymentMethodCreateParams2.metadata : map, (i2 & 16384) != 0 ? paymentMethodCreateParams2.productUsage : set, (i2 & 32768) != 0 ? paymentMethodCreateParams2.overrideParamMap : map2);
    }

    @JvmStatic
    public static final PaymentMethodCreateParams create(AuBecsDebit auBecsDebit2, PaymentMethod.BillingDetails billingDetails2) {
        return Companion.create(auBecsDebit2, billingDetails2);
    }

    @JvmStatic
    public static final PaymentMethodCreateParams create(AuBecsDebit auBecsDebit2, PaymentMethod.BillingDetails billingDetails2, Map<String, String> map) {
        return Companion.create(auBecsDebit2, billingDetails2, map);
    }

    @JvmStatic
    public static final PaymentMethodCreateParams create(BacsDebit bacsDebit2, PaymentMethod.BillingDetails billingDetails2) {
        return Companion.create(bacsDebit2, billingDetails2);
    }

    @JvmStatic
    public static final PaymentMethodCreateParams create(BacsDebit bacsDebit2, PaymentMethod.BillingDetails billingDetails2, Map<String, String> map) {
        return Companion.create(bacsDebit2, billingDetails2, map);
    }

    @JvmStatic
    public static final PaymentMethodCreateParams create(Card card2) {
        return Companion.create(card2);
    }

    @JvmStatic
    public static final PaymentMethodCreateParams create(Card card2, PaymentMethod.BillingDetails billingDetails2) {
        return Companion.create(card2, billingDetails2);
    }

    @JvmStatic
    public static final PaymentMethodCreateParams create(Card card2, PaymentMethod.BillingDetails billingDetails2, Map<String, String> map) {
        return Companion.create(card2, billingDetails2, map);
    }

    @JvmStatic
    public static final PaymentMethodCreateParams create(Fpx fpx2) {
        return Companion.create(fpx2);
    }

    @JvmStatic
    public static final PaymentMethodCreateParams create(Fpx fpx2, PaymentMethod.BillingDetails billingDetails2) {
        return Companion.create(fpx2, billingDetails2);
    }

    @JvmStatic
    public static final PaymentMethodCreateParams create(Fpx fpx2, PaymentMethod.BillingDetails billingDetails2, Map<String, String> map) {
        return Companion.create(fpx2, billingDetails2, map);
    }

    @JvmStatic
    public static final PaymentMethodCreateParams create(Ideal ideal2) {
        return Companion.create(ideal2);
    }

    @JvmStatic
    public static final PaymentMethodCreateParams create(Ideal ideal2, PaymentMethod.BillingDetails billingDetails2) {
        return Companion.create(ideal2, billingDetails2);
    }

    @JvmStatic
    public static final PaymentMethodCreateParams create(Ideal ideal2, PaymentMethod.BillingDetails billingDetails2, Map<String, String> map) {
        return Companion.create(ideal2, billingDetails2, map);
    }

    @JvmStatic
    public static final PaymentMethodCreateParams create(Netbanking netbanking2) {
        return Companion.create(netbanking2);
    }

    @JvmStatic
    public static final PaymentMethodCreateParams create(Netbanking netbanking2, PaymentMethod.BillingDetails billingDetails2) {
        return Companion.create(netbanking2, billingDetails2);
    }

    @JvmStatic
    public static final PaymentMethodCreateParams create(Netbanking netbanking2, PaymentMethod.BillingDetails billingDetails2, Map<String, String> map) {
        return Companion.create(netbanking2, billingDetails2, map);
    }

    @JvmStatic
    public static final PaymentMethodCreateParams create(SepaDebit sepaDebit2) {
        return Companion.create(sepaDebit2);
    }

    @JvmStatic
    public static final PaymentMethodCreateParams create(SepaDebit sepaDebit2, PaymentMethod.BillingDetails billingDetails2) {
        return Companion.create(sepaDebit2, billingDetails2);
    }

    @JvmStatic
    public static final PaymentMethodCreateParams create(SepaDebit sepaDebit2, PaymentMethod.BillingDetails billingDetails2, Map<String, String> map) {
        return Companion.create(sepaDebit2, billingDetails2, map);
    }

    @JvmStatic
    public static final PaymentMethodCreateParams create(Sofort sofort2) {
        return Companion.create(sofort2);
    }

    @JvmStatic
    public static final PaymentMethodCreateParams create(Sofort sofort2, PaymentMethod.BillingDetails billingDetails2) {
        return Companion.create(sofort2, billingDetails2);
    }

    @JvmStatic
    public static final PaymentMethodCreateParams create(Sofort sofort2, PaymentMethod.BillingDetails billingDetails2, Map<String, String> map) {
        return Companion.create(sofort2, billingDetails2, map);
    }

    @JvmStatic
    public static final PaymentMethodCreateParams create(USBankAccount uSBankAccount) {
        return Companion.create(uSBankAccount);
    }

    @JvmStatic
    public static final PaymentMethodCreateParams create(USBankAccount uSBankAccount, PaymentMethod.BillingDetails billingDetails2) {
        return Companion.create(uSBankAccount, billingDetails2);
    }

    @JvmStatic
    public static final PaymentMethodCreateParams create(USBankAccount uSBankAccount, PaymentMethod.BillingDetails billingDetails2, Map<String, String> map) {
        return Companion.create(uSBankAccount, billingDetails2, map);
    }

    @JvmStatic
    public static final PaymentMethodCreateParams create(Upi upi2) {
        return Companion.create(upi2);
    }

    @JvmStatic
    public static final PaymentMethodCreateParams create(Upi upi2, PaymentMethod.BillingDetails billingDetails2) {
        return Companion.create(upi2, billingDetails2);
    }

    @JvmStatic
    public static final PaymentMethodCreateParams create(Upi upi2, PaymentMethod.BillingDetails billingDetails2, Map<String, String> map) {
        return Companion.create(upi2, billingDetails2, map);
    }

    @JvmStatic
    public static final PaymentMethodCreateParams createAffirm() {
        return Companion.createAffirm();
    }

    @JvmStatic
    public static final PaymentMethodCreateParams createAffirm(PaymentMethod.BillingDetails billingDetails2) {
        return Companion.createAffirm(billingDetails2);
    }

    @JvmStatic
    public static final PaymentMethodCreateParams createAffirm(PaymentMethod.BillingDetails billingDetails2, Map<String, String> map) {
        return Companion.createAffirm(billingDetails2, map);
    }

    @JvmStatic
    public static final PaymentMethodCreateParams createAfterpayClearpay() {
        return Companion.createAfterpayClearpay();
    }

    @JvmStatic
    public static final PaymentMethodCreateParams createAfterpayClearpay(PaymentMethod.BillingDetails billingDetails2) {
        return Companion.createAfterpayClearpay(billingDetails2);
    }

    @JvmStatic
    public static final PaymentMethodCreateParams createAfterpayClearpay(PaymentMethod.BillingDetails billingDetails2, Map<String, String> map) {
        return Companion.createAfterpayClearpay(billingDetails2, map);
    }

    @JvmStatic
    public static final PaymentMethodCreateParams createAlipay() {
        return Companion.createAlipay();
    }

    @JvmStatic
    public static final PaymentMethodCreateParams createAlipay(Map<String, String> map) {
        return Companion.createAlipay(map);
    }

    @JvmStatic
    public static final PaymentMethodCreateParams createBancontact(PaymentMethod.BillingDetails billingDetails2) {
        return Companion.createBancontact(billingDetails2);
    }

    @JvmStatic
    public static final PaymentMethodCreateParams createBancontact(PaymentMethod.BillingDetails billingDetails2, Map<String, String> map) {
        return Companion.createBancontact(billingDetails2, map);
    }

    @JvmStatic
    public static final PaymentMethodCreateParams createBlik() {
        return Companion.createBlik();
    }

    @JvmStatic
    public static final PaymentMethodCreateParams createBlik(PaymentMethod.BillingDetails billingDetails2) {
        return Companion.createBlik(billingDetails2);
    }

    @JvmStatic
    public static final PaymentMethodCreateParams createBlik(PaymentMethod.BillingDetails billingDetails2, Map<String, String> map) {
        return Companion.createBlik(billingDetails2, map);
    }

    @JvmStatic
    public static final PaymentMethodCreateParams createCard(CardParams cardParams) {
        return Companion.createCard(cardParams);
    }

    @JvmStatic
    public static final PaymentMethodCreateParams createEps(PaymentMethod.BillingDetails billingDetails2) {
        return Companion.createEps(billingDetails2);
    }

    @JvmStatic
    public static final PaymentMethodCreateParams createEps(PaymentMethod.BillingDetails billingDetails2, Map<String, String> map) {
        return Companion.createEps(billingDetails2, map);
    }

    @JvmStatic
    public static final PaymentMethodCreateParams createFromGooglePay(JSONObject jSONObject) throws JSONException {
        return Companion.createFromGooglePay(jSONObject);
    }

    @JvmStatic
    public static final PaymentMethodCreateParams createGiropay(PaymentMethod.BillingDetails billingDetails2) {
        return Companion.createGiropay(billingDetails2);
    }

    @JvmStatic
    public static final PaymentMethodCreateParams createGiropay(PaymentMethod.BillingDetails billingDetails2, Map<String, String> map) {
        return Companion.createGiropay(billingDetails2, map);
    }

    @JvmStatic
    public static final PaymentMethodCreateParams createGrabPay(PaymentMethod.BillingDetails billingDetails2) {
        return Companion.createGrabPay(billingDetails2);
    }

    @JvmStatic
    public static final PaymentMethodCreateParams createGrabPay(PaymentMethod.BillingDetails billingDetails2, Map<String, String> map) {
        return Companion.createGrabPay(billingDetails2, map);
    }

    @JvmStatic
    public static final PaymentMethodCreateParams createKlarna() {
        return Companion.createKlarna();
    }

    @JvmStatic
    public static final PaymentMethodCreateParams createKlarna(PaymentMethod.BillingDetails billingDetails2) {
        return Companion.createKlarna(billingDetails2);
    }

    @JvmStatic
    public static final PaymentMethodCreateParams createKlarna(PaymentMethod.BillingDetails billingDetails2, Map<String, String> map) {
        return Companion.createKlarna(billingDetails2, map);
    }

    @JvmStatic
    public static final PaymentMethodCreateParams createOxxo(PaymentMethod.BillingDetails billingDetails2) {
        return Companion.createOxxo(billingDetails2);
    }

    @JvmStatic
    public static final PaymentMethodCreateParams createOxxo(PaymentMethod.BillingDetails billingDetails2, Map<String, String> map) {
        return Companion.createOxxo(billingDetails2, map);
    }

    @JvmStatic
    public static final PaymentMethodCreateParams createP24(PaymentMethod.BillingDetails billingDetails2) {
        return Companion.createP24(billingDetails2);
    }

    @JvmStatic
    public static final PaymentMethodCreateParams createP24(PaymentMethod.BillingDetails billingDetails2, Map<String, String> map) {
        return Companion.createP24(billingDetails2, map);
    }

    @JvmStatic
    public static final PaymentMethodCreateParams createPayPal() {
        return Companion.createPayPal();
    }

    @JvmStatic
    public static final PaymentMethodCreateParams createPayPal(Map<String, String> map) {
        return Companion.createPayPal(map);
    }

    @JvmStatic
    public static final PaymentMethodCreateParams createUSBankAccount() {
        return Companion.createUSBankAccount();
    }

    @JvmStatic
    public static final PaymentMethodCreateParams createUSBankAccount(PaymentMethod.BillingDetails billingDetails2) {
        return Companion.createUSBankAccount(billingDetails2);
    }

    @JvmStatic
    public static final PaymentMethodCreateParams createUSBankAccount(PaymentMethod.BillingDetails billingDetails2, Map<String, String> map) {
        return Companion.createUSBankAccount(billingDetails2, map);
    }

    @JvmStatic
    public static final PaymentMethodCreateParams createWeChatPay() {
        return Companion.createWeChatPay();
    }

    @JvmStatic
    public static final PaymentMethodCreateParams createWeChatPay(PaymentMethod.BillingDetails billingDetails2) {
        return Companion.createWeChatPay(billingDetails2);
    }

    @JvmStatic
    public static final PaymentMethodCreateParams createWeChatPay(PaymentMethod.BillingDetails billingDetails2, Map<String, String> map) {
        return Companion.createWeChatPay(billingDetails2, map);
    }

    public final PaymentMethod.Type component1$payments_core_release() {
        return this.type;
    }

    public final PaymentMethod.BillingDetails component13() {
        return this.billingDetails;
    }

    public final Card component2() {
        return this.card;
    }

    public final PaymentMethodCreateParams copy(PaymentMethod.Type type2, Card card2, Ideal ideal2, Fpx fpx2, SepaDebit sepaDebit2, AuBecsDebit auBecsDebit2, BacsDebit bacsDebit2, Sofort sofort2, Upi upi2, Netbanking netbanking2, USBankAccount uSBankAccount, Link link2, PaymentMethod.BillingDetails billingDetails2, Map<String, String> map, Set<String> set, Map<String, ? extends Object> map2) {
        PaymentMethod.Type type3 = type2;
        Intrinsics.checkNotNullParameter(type3, "type");
        Intrinsics.checkNotNullParameter(set, NamedConstantsKt.PRODUCT_USAGE);
        return new PaymentMethodCreateParams(type3, card2, ideal2, fpx2, sepaDebit2, auBecsDebit2, bacsDebit2, sofort2, upi2, netbanking2, uSBankAccount, link2, billingDetails2, map, set, map2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaymentMethodCreateParams)) {
            return false;
        }
        PaymentMethodCreateParams paymentMethodCreateParams = (PaymentMethodCreateParams) obj;
        return this.type == paymentMethodCreateParams.type && Intrinsics.areEqual((Object) this.card, (Object) paymentMethodCreateParams.card) && Intrinsics.areEqual((Object) this.ideal, (Object) paymentMethodCreateParams.ideal) && Intrinsics.areEqual((Object) this.fpx, (Object) paymentMethodCreateParams.fpx) && Intrinsics.areEqual((Object) this.sepaDebit, (Object) paymentMethodCreateParams.sepaDebit) && Intrinsics.areEqual((Object) this.auBecsDebit, (Object) paymentMethodCreateParams.auBecsDebit) && Intrinsics.areEqual((Object) this.bacsDebit, (Object) paymentMethodCreateParams.bacsDebit) && Intrinsics.areEqual((Object) this.sofort, (Object) paymentMethodCreateParams.sofort) && Intrinsics.areEqual((Object) this.upi, (Object) paymentMethodCreateParams.upi) && Intrinsics.areEqual((Object) this.netbanking, (Object) paymentMethodCreateParams.netbanking) && Intrinsics.areEqual((Object) this.usBankAccount, (Object) paymentMethodCreateParams.usBankAccount) && Intrinsics.areEqual((Object) this.link, (Object) paymentMethodCreateParams.link) && Intrinsics.areEqual((Object) this.billingDetails, (Object) paymentMethodCreateParams.billingDetails) && Intrinsics.areEqual((Object) this.metadata, (Object) paymentMethodCreateParams.metadata) && Intrinsics.areEqual((Object) this.productUsage, (Object) paymentMethodCreateParams.productUsage) && Intrinsics.areEqual((Object) this.overrideParamMap, (Object) paymentMethodCreateParams.overrideParamMap);
    }

    public int hashCode() {
        int hashCode = this.type.hashCode() * 31;
        Card card2 = this.card;
        int i = 0;
        int hashCode2 = (hashCode + (card2 == null ? 0 : card2.hashCode())) * 31;
        Ideal ideal2 = this.ideal;
        int hashCode3 = (hashCode2 + (ideal2 == null ? 0 : ideal2.hashCode())) * 31;
        Fpx fpx2 = this.fpx;
        int hashCode4 = (hashCode3 + (fpx2 == null ? 0 : fpx2.hashCode())) * 31;
        SepaDebit sepaDebit2 = this.sepaDebit;
        int hashCode5 = (hashCode4 + (sepaDebit2 == null ? 0 : sepaDebit2.hashCode())) * 31;
        AuBecsDebit auBecsDebit2 = this.auBecsDebit;
        int hashCode6 = (hashCode5 + (auBecsDebit2 == null ? 0 : auBecsDebit2.hashCode())) * 31;
        BacsDebit bacsDebit2 = this.bacsDebit;
        int hashCode7 = (hashCode6 + (bacsDebit2 == null ? 0 : bacsDebit2.hashCode())) * 31;
        Sofort sofort2 = this.sofort;
        int hashCode8 = (hashCode7 + (sofort2 == null ? 0 : sofort2.hashCode())) * 31;
        Upi upi2 = this.upi;
        int hashCode9 = (hashCode8 + (upi2 == null ? 0 : upi2.hashCode())) * 31;
        Netbanking netbanking2 = this.netbanking;
        int hashCode10 = (hashCode9 + (netbanking2 == null ? 0 : netbanking2.hashCode())) * 31;
        USBankAccount uSBankAccount = this.usBankAccount;
        int hashCode11 = (hashCode10 + (uSBankAccount == null ? 0 : uSBankAccount.hashCode())) * 31;
        Link link2 = this.link;
        int hashCode12 = (hashCode11 + (link2 == null ? 0 : link2.hashCode())) * 31;
        PaymentMethod.BillingDetails billingDetails2 = this.billingDetails;
        int hashCode13 = (hashCode12 + (billingDetails2 == null ? 0 : billingDetails2.hashCode())) * 31;
        Map<String, String> map = this.metadata;
        int hashCode14 = (((hashCode13 + (map == null ? 0 : map.hashCode())) * 31) + this.productUsage.hashCode()) * 31;
        Map<String, Object> map2 = this.overrideParamMap;
        if (map2 != null) {
            i = map2.hashCode();
        }
        return hashCode14 + i;
    }

    public String toString() {
        return "PaymentMethodCreateParams(type=" + this.type + ", card=" + this.card + ", ideal=" + this.ideal + ", fpx=" + this.fpx + ", sepaDebit=" + this.sepaDebit + ", auBecsDebit=" + this.auBecsDebit + ", bacsDebit=" + this.bacsDebit + ", sofort=" + this.sofort + ", upi=" + this.upi + ", netbanking=" + this.netbanking + ", usBankAccount=" + this.usBankAccount + ", link=" + this.link + ", billingDetails=" + this.billingDetails + ", metadata=" + this.metadata + ", productUsage=" + this.productUsage + ", overrideParamMap=" + this.overrideParamMap + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        this.type.writeToParcel(parcel, i);
        Card card2 = this.card;
        if (card2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            card2.writeToParcel(parcel, i);
        }
        Ideal ideal2 = this.ideal;
        if (ideal2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            ideal2.writeToParcel(parcel, i);
        }
        Fpx fpx2 = this.fpx;
        if (fpx2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            fpx2.writeToParcel(parcel, i);
        }
        SepaDebit sepaDebit2 = this.sepaDebit;
        if (sepaDebit2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            sepaDebit2.writeToParcel(parcel, i);
        }
        AuBecsDebit auBecsDebit2 = this.auBecsDebit;
        if (auBecsDebit2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            auBecsDebit2.writeToParcel(parcel, i);
        }
        BacsDebit bacsDebit2 = this.bacsDebit;
        if (bacsDebit2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            bacsDebit2.writeToParcel(parcel, i);
        }
        Sofort sofort2 = this.sofort;
        if (sofort2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            sofort2.writeToParcel(parcel, i);
        }
        Upi upi2 = this.upi;
        if (upi2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            upi2.writeToParcel(parcel, i);
        }
        Netbanking netbanking2 = this.netbanking;
        if (netbanking2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            netbanking2.writeToParcel(parcel, i);
        }
        USBankAccount uSBankAccount = this.usBankAccount;
        if (uSBankAccount == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            uSBankAccount.writeToParcel(parcel, i);
        }
        Link link2 = this.link;
        if (link2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            link2.writeToParcel(parcel, i);
        }
        PaymentMethod.BillingDetails billingDetails2 = this.billingDetails;
        if (billingDetails2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            billingDetails2.writeToParcel(parcel, i);
        }
        Map<String, String> map = this.metadata;
        if (map == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(map.size());
            for (Map.Entry next : map.entrySet()) {
                parcel.writeString((String) next.getKey());
                parcel.writeString((String) next.getValue());
            }
        }
        Set<String> set = this.productUsage;
        parcel.writeInt(set.size());
        for (String writeString : set) {
            parcel.writeString(writeString);
        }
        Map<String, Object> map2 = this.overrideParamMap;
        if (map2 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(map2.size());
        for (Map.Entry next2 : map2.entrySet()) {
            parcel.writeString((String) next2.getKey());
            parcel.writeValue(next2.getValue());
        }
    }

    public PaymentMethodCreateParams(PaymentMethod.Type type2, Card card2, Ideal ideal2, Fpx fpx2, SepaDebit sepaDebit2, AuBecsDebit auBecsDebit2, BacsDebit bacsDebit2, Sofort sofort2, Upi upi2, Netbanking netbanking2, USBankAccount uSBankAccount, Link link2, PaymentMethod.BillingDetails billingDetails2, Map<String, String> map, Set<String> set, Map<String, ? extends Object> map2) {
        Set<String> set2 = set;
        Intrinsics.checkNotNullParameter(type2, "type");
        Intrinsics.checkNotNullParameter(set2, NamedConstantsKt.PRODUCT_USAGE);
        this.type = type2;
        this.card = card2;
        this.ideal = ideal2;
        this.fpx = fpx2;
        this.sepaDebit = sepaDebit2;
        this.auBecsDebit = auBecsDebit2;
        this.bacsDebit = bacsDebit2;
        this.sofort = sofort2;
        this.upi = upi2;
        this.netbanking = netbanking2;
        this.usBankAccount = uSBankAccount;
        this.link = link2;
        this.billingDetails = billingDetails2;
        this.metadata = map;
        this.productUsage = set2;
        this.overrideParamMap = map2;
    }

    public final PaymentMethod.Type getType$payments_core_release() {
        return this.type;
    }

    public final Card getCard() {
        return this.card;
    }

    public final PaymentMethod.BillingDetails getBillingDetails() {
        return this.billingDetails;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PaymentMethodCreateParams(com.stripe.android.model.PaymentMethod.Type r18, com.stripe.android.model.PaymentMethodCreateParams.Card r19, com.stripe.android.model.PaymentMethodCreateParams.Ideal r20, com.stripe.android.model.PaymentMethodCreateParams.Fpx r21, com.stripe.android.model.PaymentMethodCreateParams.SepaDebit r22, com.stripe.android.model.PaymentMethodCreateParams.AuBecsDebit r23, com.stripe.android.model.PaymentMethodCreateParams.BacsDebit r24, com.stripe.android.model.PaymentMethodCreateParams.Sofort r25, com.stripe.android.model.PaymentMethodCreateParams.Upi r26, com.stripe.android.model.PaymentMethodCreateParams.Netbanking r27, com.stripe.android.model.PaymentMethodCreateParams.USBankAccount r28, com.stripe.android.model.PaymentMethodCreateParams.Link r29, com.stripe.android.model.PaymentMethod.BillingDetails r30, java.util.Map r31, java.util.Set r32, java.util.Map r33, int r34, kotlin.jvm.internal.DefaultConstructorMarker r35) {
        /*
            r17 = this;
            r0 = r34
            r1 = r0 & 2
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000b
        L_0x0009:
            r1 = r19
        L_0x000b:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x0011
            r3 = r2
            goto L_0x0013
        L_0x0011:
            r3 = r20
        L_0x0013:
            r4 = r0 & 8
            if (r4 == 0) goto L_0x0019
            r4 = r2
            goto L_0x001b
        L_0x0019:
            r4 = r21
        L_0x001b:
            r5 = r0 & 16
            if (r5 == 0) goto L_0x0021
            r5 = r2
            goto L_0x0023
        L_0x0021:
            r5 = r22
        L_0x0023:
            r6 = r0 & 32
            if (r6 == 0) goto L_0x0029
            r6 = r2
            goto L_0x002b
        L_0x0029:
            r6 = r23
        L_0x002b:
            r7 = r0 & 64
            if (r7 == 0) goto L_0x0031
            r7 = r2
            goto L_0x0033
        L_0x0031:
            r7 = r24
        L_0x0033:
            r8 = r0 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x0039
            r8 = r2
            goto L_0x003b
        L_0x0039:
            r8 = r25
        L_0x003b:
            r9 = r0 & 256(0x100, float:3.59E-43)
            if (r9 == 0) goto L_0x0041
            r9 = r2
            goto L_0x0043
        L_0x0041:
            r9 = r26
        L_0x0043:
            r10 = r0 & 512(0x200, float:7.175E-43)
            if (r10 == 0) goto L_0x0049
            r10 = r2
            goto L_0x004b
        L_0x0049:
            r10 = r27
        L_0x004b:
            r11 = r0 & 1024(0x400, float:1.435E-42)
            if (r11 == 0) goto L_0x0051
            r11 = r2
            goto L_0x0053
        L_0x0051:
            r11 = r28
        L_0x0053:
            r12 = r0 & 2048(0x800, float:2.87E-42)
            if (r12 == 0) goto L_0x0059
            r12 = r2
            goto L_0x005b
        L_0x0059:
            r12 = r29
        L_0x005b:
            r13 = r0 & 4096(0x1000, float:5.74E-42)
            if (r13 == 0) goto L_0x0061
            r13 = r2
            goto L_0x0063
        L_0x0061:
            r13 = r30
        L_0x0063:
            r14 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r14 == 0) goto L_0x0069
            r14 = r2
            goto L_0x006b
        L_0x0069:
            r14 = r31
        L_0x006b:
            r15 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r15 == 0) goto L_0x0074
            java.util.Set r15 = kotlin.collections.SetsKt.emptySet()
            goto L_0x0076
        L_0x0074:
            r15 = r32
        L_0x0076:
            r16 = 32768(0x8000, float:4.5918E-41)
            r0 = r0 & r16
            if (r0 == 0) goto L_0x007e
            goto L_0x0080
        L_0x007e:
            r2 = r33
        L_0x0080:
            r19 = r17
            r20 = r18
            r21 = r1
            r22 = r3
            r23 = r4
            r24 = r5
            r25 = r6
            r26 = r7
            r27 = r8
            r28 = r9
            r29 = r10
            r30 = r11
            r31 = r12
            r32 = r13
            r33 = r14
            r34 = r15
            r35 = r2
            r19.<init>(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.model.PaymentMethodCreateParams.<init>(com.stripe.android.model.PaymentMethod$Type, com.stripe.android.model.PaymentMethodCreateParams$Card, com.stripe.android.model.PaymentMethodCreateParams$Ideal, com.stripe.android.model.PaymentMethodCreateParams$Fpx, com.stripe.android.model.PaymentMethodCreateParams$SepaDebit, com.stripe.android.model.PaymentMethodCreateParams$AuBecsDebit, com.stripe.android.model.PaymentMethodCreateParams$BacsDebit, com.stripe.android.model.PaymentMethodCreateParams$Sofort, com.stripe.android.model.PaymentMethodCreateParams$Upi, com.stripe.android.model.PaymentMethodCreateParams$Netbanking, com.stripe.android.model.PaymentMethodCreateParams$USBankAccount, com.stripe.android.model.PaymentMethodCreateParams$Link, com.stripe.android.model.PaymentMethod$BillingDetails, java.util.Map, java.util.Set, java.util.Map, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getTypeCode() {
        return this.type.code;
    }

    public final /* synthetic */ Set getAttribution$payments_core_release() {
        if (WhenMappings.$EnumSwitchMapping$0[this.type.ordinal()] != 1) {
            return this.productUsage;
        }
        Card card2 = this.card;
        Set<String> attribution$payments_core_release = card2 == null ? null : card2.getAttribution$payments_core_release();
        if (attribution$payments_core_release == null) {
            attribution$payments_core_release = SetsKt.emptySet();
        }
        return SetsKt.plus(attribution$payments_core_release, this.productUsage);
    }

    private PaymentMethodCreateParams(Card card2, PaymentMethod.BillingDetails billingDetails2, Map<String, String> map) {
        this(PaymentMethod.Type.Card, card2, (Ideal) null, (Fpx) null, (SepaDebit) null, (AuBecsDebit) null, (BacsDebit) null, (Sofort) null, (Upi) null, (Netbanking) null, (USBankAccount) null, (Link) null, billingDetails2, map, (Set) null, (Map) null, 53244, (DefaultConstructorMarker) null);
    }

    private PaymentMethodCreateParams(Ideal ideal2, PaymentMethod.BillingDetails billingDetails2, Map<String, String> map) {
        this(PaymentMethod.Type.Ideal, (Card) null, ideal2, (Fpx) null, (SepaDebit) null, (AuBecsDebit) null, (BacsDebit) null, (Sofort) null, (Upi) null, (Netbanking) null, (USBankAccount) null, (Link) null, billingDetails2, map, (Set) null, (Map) null, 53242, (DefaultConstructorMarker) null);
    }

    private PaymentMethodCreateParams(Fpx fpx2, PaymentMethod.BillingDetails billingDetails2, Map<String, String> map) {
        this(PaymentMethod.Type.Fpx, (Card) null, (Ideal) null, fpx2, (SepaDebit) null, (AuBecsDebit) null, (BacsDebit) null, (Sofort) null, (Upi) null, (Netbanking) null, (USBankAccount) null, (Link) null, billingDetails2, map, (Set) null, (Map) null, 53238, (DefaultConstructorMarker) null);
    }

    private PaymentMethodCreateParams(SepaDebit sepaDebit2, PaymentMethod.BillingDetails billingDetails2, Map<String, String> map) {
        this(PaymentMethod.Type.SepaDebit, (Card) null, (Ideal) null, (Fpx) null, sepaDebit2, (AuBecsDebit) null, (BacsDebit) null, (Sofort) null, (Upi) null, (Netbanking) null, (USBankAccount) null, (Link) null, billingDetails2, map, (Set) null, (Map) null, 53230, (DefaultConstructorMarker) null);
    }

    private PaymentMethodCreateParams(AuBecsDebit auBecsDebit2, PaymentMethod.BillingDetails billingDetails2, Map<String, String> map) {
        this(PaymentMethod.Type.AuBecsDebit, (Card) null, (Ideal) null, (Fpx) null, (SepaDebit) null, auBecsDebit2, (BacsDebit) null, (Sofort) null, (Upi) null, (Netbanking) null, (USBankAccount) null, (Link) null, billingDetails2, map, (Set) null, (Map) null, 53214, (DefaultConstructorMarker) null);
    }

    private PaymentMethodCreateParams(BacsDebit bacsDebit2, PaymentMethod.BillingDetails billingDetails2, Map<String, String> map) {
        this(PaymentMethod.Type.BacsDebit, (Card) null, (Ideal) null, (Fpx) null, (SepaDebit) null, (AuBecsDebit) null, bacsDebit2, (Sofort) null, (Upi) null, (Netbanking) null, (USBankAccount) null, (Link) null, billingDetails2, map, (Set) null, (Map) null, 53182, (DefaultConstructorMarker) null);
    }

    private PaymentMethodCreateParams(Sofort sofort2, PaymentMethod.BillingDetails billingDetails2, Map<String, String> map) {
        this(PaymentMethod.Type.Sofort, (Card) null, (Ideal) null, (Fpx) null, (SepaDebit) null, (AuBecsDebit) null, (BacsDebit) null, sofort2, (Upi) null, (Netbanking) null, (USBankAccount) null, (Link) null, billingDetails2, map, (Set) null, (Map) null, 53118, (DefaultConstructorMarker) null);
    }

    private PaymentMethodCreateParams(Upi upi2, PaymentMethod.BillingDetails billingDetails2, Map<String, String> map) {
        this(PaymentMethod.Type.Upi, (Card) null, (Ideal) null, (Fpx) null, (SepaDebit) null, (AuBecsDebit) null, (BacsDebit) null, (Sofort) null, upi2, (Netbanking) null, (USBankAccount) null, (Link) null, billingDetails2, map, (Set) null, (Map) null, 52990, (DefaultConstructorMarker) null);
    }

    private PaymentMethodCreateParams(Netbanking netbanking2, PaymentMethod.BillingDetails billingDetails2, Map<String, String> map) {
        this(PaymentMethod.Type.Netbanking, (Card) null, (Ideal) null, (Fpx) null, (SepaDebit) null, (AuBecsDebit) null, (BacsDebit) null, (Sofort) null, (Upi) null, netbanking2, (USBankAccount) null, (Link) null, billingDetails2, map, (Set) null, (Map) null, 52734, (DefaultConstructorMarker) null);
    }

    private PaymentMethodCreateParams(USBankAccount uSBankAccount, PaymentMethod.BillingDetails billingDetails2, Map<String, String> map) {
        this(PaymentMethod.Type.USBankAccount, (Card) null, (Ideal) null, (Fpx) null, (SepaDebit) null, (AuBecsDebit) null, (BacsDebit) null, (Sofort) null, (Upi) null, (Netbanking) null, uSBankAccount, (Link) null, billingDetails2, map, (Set) null, (Map) null, 52222, (DefaultConstructorMarker) null);
    }

    public Map<String, Object> toParamMap() {
        Map<K, V> map;
        Map<String, Object> map2 = this.overrideParamMap;
        if (map2 != null) {
            return map2;
        }
        Map mapOf = MapsKt.mapOf(TuplesKt.to("type", this.type.code));
        PaymentMethod.BillingDetails billingDetails2 = this.billingDetails;
        Map<K, V> map3 = null;
        if (billingDetails2 == null) {
            map = null;
        } else {
            map = MapsKt.mapOf(TuplesKt.to(PARAM_BILLING_DETAILS, billingDetails2.toParamMap()));
        }
        if (map == null) {
            map = MapsKt.emptyMap();
        }
        Map<K, V> plus = MapsKt.plus(MapsKt.plus(mapOf, (Map) map), (Map<K, V>) getTypeParams());
        Map<String, String> map4 = this.metadata;
        if (map4 != null) {
            map3 = MapsKt.mapOf(TuplesKt.to("metadata", map4));
        }
        if (map3 == null) {
            map3 = MapsKt.emptyMap();
        }
        return MapsKt.plus(plus, map3);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.Map<java.lang.String, java.lang.Object> getTypeParams() {
        /*
            r3 = this;
            com.stripe.android.model.PaymentMethod$Type r0 = r3.type
            int[] r1 = com.stripe.android.model.PaymentMethodCreateParams.WhenMappings.$EnumSwitchMapping$0
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 0
            switch(r0) {
                case 1: goto L_0x0077;
                case 2: goto L_0x006d;
                case 3: goto L_0x0063;
                case 4: goto L_0x0059;
                case 5: goto L_0x004f;
                case 6: goto L_0x0045;
                case 7: goto L_0x003b;
                case 8: goto L_0x0031;
                case 9: goto L_0x0027;
                case 10: goto L_0x001c;
                case 11: goto L_0x0011;
                default: goto L_0x000e;
            }
        L_0x000e:
            r0 = r1
            goto L_0x0080
        L_0x0011:
            com.stripe.android.model.PaymentMethodCreateParams$Link r0 = r3.link
            if (r0 != 0) goto L_0x0016
            goto L_0x000e
        L_0x0016:
            java.util.Map r0 = r0.toParamMap()
            goto L_0x0080
        L_0x001c:
            com.stripe.android.model.PaymentMethodCreateParams$USBankAccount r0 = r3.usBankAccount
            if (r0 != 0) goto L_0x0021
            goto L_0x000e
        L_0x0021:
            java.util.Map r0 = r0.toParamMap()
            goto L_0x0080
        L_0x0027:
            com.stripe.android.model.PaymentMethodCreateParams$Netbanking r0 = r3.netbanking
            if (r0 != 0) goto L_0x002c
            goto L_0x000e
        L_0x002c:
            java.util.Map r0 = r0.toParamMap()
            goto L_0x0080
        L_0x0031:
            com.stripe.android.model.PaymentMethodCreateParams$Upi r0 = r3.upi
            if (r0 != 0) goto L_0x0036
            goto L_0x000e
        L_0x0036:
            java.util.Map r0 = r0.toParamMap()
            goto L_0x0080
        L_0x003b:
            com.stripe.android.model.PaymentMethodCreateParams$Sofort r0 = r3.sofort
            if (r0 != 0) goto L_0x0040
            goto L_0x000e
        L_0x0040:
            java.util.Map r0 = r0.toParamMap()
            goto L_0x0080
        L_0x0045:
            com.stripe.android.model.PaymentMethodCreateParams$BacsDebit r0 = r3.bacsDebit
            if (r0 != 0) goto L_0x004a
            goto L_0x000e
        L_0x004a:
            java.util.Map r0 = r0.toParamMap()
            goto L_0x0080
        L_0x004f:
            com.stripe.android.model.PaymentMethodCreateParams$AuBecsDebit r0 = r3.auBecsDebit
            if (r0 != 0) goto L_0x0054
            goto L_0x000e
        L_0x0054:
            java.util.Map r0 = r0.toParamMap()
            goto L_0x0080
        L_0x0059:
            com.stripe.android.model.PaymentMethodCreateParams$SepaDebit r0 = r3.sepaDebit
            if (r0 != 0) goto L_0x005e
            goto L_0x000e
        L_0x005e:
            java.util.Map r0 = r0.toParamMap()
            goto L_0x0080
        L_0x0063:
            com.stripe.android.model.PaymentMethodCreateParams$Fpx r0 = r3.fpx
            if (r0 != 0) goto L_0x0068
            goto L_0x000e
        L_0x0068:
            java.util.Map r0 = r0.toParamMap()
            goto L_0x0080
        L_0x006d:
            com.stripe.android.model.PaymentMethodCreateParams$Ideal r0 = r3.ideal
            if (r0 != 0) goto L_0x0072
            goto L_0x000e
        L_0x0072:
            java.util.Map r0 = r0.toParamMap()
            goto L_0x0080
        L_0x0077:
            com.stripe.android.model.PaymentMethodCreateParams$Card r0 = r3.card
            if (r0 != 0) goto L_0x007c
            goto L_0x000e
        L_0x007c:
            java.util.Map r0 = r0.toParamMap()
        L_0x0080:
            if (r0 == 0) goto L_0x008b
            boolean r2 = r0.isEmpty()
            if (r2 == 0) goto L_0x0089
            goto L_0x008b
        L_0x0089:
            r2 = 0
            goto L_0x008c
        L_0x008b:
            r2 = 1
        L_0x008c:
            if (r2 != 0) goto L_0x008f
            goto L_0x0090
        L_0x008f:
            r0 = r1
        L_0x0090:
            if (r0 != 0) goto L_0x0093
            goto L_0x00a1
        L_0x0093:
            com.stripe.android.model.PaymentMethod$Type r1 = r3.getType$payments_core_release()
            java.lang.String r1 = r1.code
            kotlin.Pair r0 = kotlin.TuplesKt.to(r1, r0)
            java.util.Map r1 = kotlin.collections.MapsKt.mapOf(r0)
        L_0x00a1:
            if (r1 != 0) goto L_0x00a7
            java.util.Map r1 = kotlin.collections.MapsKt.emptyMap()
        L_0x00a7:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.model.PaymentMethodCreateParams.getTypeParams():java.util.Map");
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 92\u00020\u00012\u00020\u0002:\u000289BU\b\u0007\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0004HÀ\u0003¢\u0006\u0002\b\u001dJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÀ\u0003¢\u0006\u0004\b\u001f\u0010\u0016J\u0012\u0010 \u001a\u0004\u0018\u00010\u0006HÀ\u0003¢\u0006\u0004\b!\u0010\u0016J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0004HÀ\u0003¢\u0006\u0002\b#J\u000b\u0010$\u001a\u0004\u0018\u00010\u0004HÂ\u0003J\u0016\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000bHÀ\u0003¢\u0006\u0002\b&J\\\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010(J\t\u0010)\u001a\u00020\u0006HÖ\u0001J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-HÖ\u0003J\n\u0010.\u001a\u0004\u0018\u00010\u0004H\u0007J\t\u0010/\u001a\u00020\u0006HÖ\u0001J\u0014\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020-01H\u0016J\t\u00102\u001a\u00020\u0004HÖ\u0001J\u0019\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u0006HÖ\u0001R\u001c\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108@X\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\b\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0016R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00048@X\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0014R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/stripe/android/model/PaymentMethodCreateParams$Card;", "Lcom/stripe/android/model/StripeParamsModel;", "Landroid/os/Parcelable;", "number", "", "expiryMonth", "", "expiryYear", "cvc", "token", "attribution", "", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;)V", "getAttribution$payments_core_release", "()Ljava/util/Set;", "brand", "Lcom/stripe/android/model/CardBrand;", "getBrand$payments_core_release", "()Lcom/stripe/android/model/CardBrand;", "getCvc$payments_core_release", "()Ljava/lang/String;", "getExpiryMonth$payments_core_release", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getExpiryYear$payments_core_release", "last4", "getLast4$payments_core_release", "getNumber$payments_core_release", "component1", "component1$payments_core_release", "component2", "component2$payments_core_release", "component3", "component3$payments_core_release", "component4", "component4$payments_core_release", "component5", "component6", "component6$payments_core_release", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;)Lcom/stripe/android/model/PaymentMethodCreateParams$Card;", "describeContents", "equals", "", "other", "", "getLast4", "hashCode", "toParamMap", "", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Builder", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethodCreateParams.kt */
    public static final class Card implements StripeParamsModel, Parcelable {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Card> CREATOR = new Creator();
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private static final String PARAM_CVC = "cvc";
        private static final String PARAM_EXP_MONTH = "exp_month";
        private static final String PARAM_EXP_YEAR = "exp_year";
        private static final String PARAM_NUMBER = "number";
        private static final String PARAM_TOKEN = "token";
        private final Set<String> attribution;
        private final String cvc;
        private final Integer expiryMonth;
        private final Integer expiryYear;
        private final String number;
        private final String token;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethodCreateParams.kt */
        public static final class Creator implements Parcelable.Creator<Card> {
            public final Card createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                String readString = parcel.readString();
                LinkedHashSet linkedHashSet = null;
                Integer valueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
                Integer valueOf2 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
                String readString2 = parcel.readString();
                String readString3 = parcel.readString();
                if (parcel.readInt() != 0) {
                    int readInt = parcel.readInt();
                    linkedHashSet = new LinkedHashSet(readInt);
                    for (int i = 0; i != readInt; i++) {
                        linkedHashSet.add(parcel.readString());
                    }
                }
                return new Card(readString, valueOf, valueOf2, readString2, readString3, linkedHashSet);
            }

            public final Card[] newArray(int i) {
                return new Card[i];
            }
        }

        public Card() {
            this((String) null, (Integer) null, (Integer) null, (String) null, (String) null, (Set) null, 63, (DefaultConstructorMarker) null);
        }

        private final String component5() {
            return this.token;
        }

        public static /* synthetic */ Card copy$default(Card card, String str, Integer num, Integer num2, String str2, String str3, Set<String> set, int i, Object obj) {
            if ((i & 1) != 0) {
                str = card.number;
            }
            if ((i & 2) != 0) {
                num = card.expiryMonth;
            }
            Integer num3 = num;
            if ((i & 4) != 0) {
                num2 = card.expiryYear;
            }
            Integer num4 = num2;
            if ((i & 8) != 0) {
                str2 = card.cvc;
            }
            String str4 = str2;
            if ((i & 16) != 0) {
                str3 = card.token;
            }
            String str5 = str3;
            if ((i & 32) != 0) {
                set = card.attribution;
            }
            return card.copy(str, num3, num4, str4, str5, set);
        }

        @JvmStatic
        public static final Card create(String str) {
            return Companion.create(str);
        }

        public final String component1$payments_core_release() {
            return this.number;
        }

        public final Integer component2$payments_core_release() {
            return this.expiryMonth;
        }

        public final Integer component3$payments_core_release() {
            return this.expiryYear;
        }

        public final String component4$payments_core_release() {
            return this.cvc;
        }

        public final Set<String> component6$payments_core_release() {
            return this.attribution;
        }

        public final Card copy(String str, Integer num, Integer num2, String str2, String str3, Set<String> set) {
            return new Card(str, num, num2, str2, str3, set);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Card)) {
                return false;
            }
            Card card = (Card) obj;
            return Intrinsics.areEqual((Object) this.number, (Object) card.number) && Intrinsics.areEqual((Object) this.expiryMonth, (Object) card.expiryMonth) && Intrinsics.areEqual((Object) this.expiryYear, (Object) card.expiryYear) && Intrinsics.areEqual((Object) this.cvc, (Object) card.cvc) && Intrinsics.areEqual((Object) this.token, (Object) card.token) && Intrinsics.areEqual((Object) this.attribution, (Object) card.attribution);
        }

        public int hashCode() {
            String str = this.number;
            int i = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            Integer num = this.expiryMonth;
            int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.expiryYear;
            int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
            String str2 = this.cvc;
            int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.token;
            int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
            Set<String> set = this.attribution;
            if (set != null) {
                i = set.hashCode();
            }
            return hashCode5 + i;
        }

        public String toString() {
            return "Card(number=" + this.number + ", expiryMonth=" + this.expiryMonth + ", expiryYear=" + this.expiryYear + ", cvc=" + this.cvc + ", token=" + this.token + ", attribution=" + this.attribution + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.number);
            Integer num = this.expiryMonth;
            if (num == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeInt(num.intValue());
            }
            Integer num2 = this.expiryYear;
            if (num2 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeInt(num2.intValue());
            }
            parcel.writeString(this.cvc);
            parcel.writeString(this.token);
            Set<String> set = this.attribution;
            if (set == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            parcel.writeInt(set.size());
            for (String writeString : set) {
                parcel.writeString(writeString);
            }
        }

        public Card(String str, Integer num, Integer num2, String str2, String str3, Set<String> set) {
            this.number = str;
            this.expiryMonth = num;
            this.expiryYear = num2;
            this.cvc = str2;
            this.token = str3;
            this.attribution = set;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ Card(java.lang.String r6, java.lang.Integer r7, java.lang.Integer r8, java.lang.String r9, java.lang.String r10, java.util.Set r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
            /*
                r5 = this;
                r13 = r12 & 1
                r0 = 0
                if (r13 == 0) goto L_0x0007
                r13 = r0
                goto L_0x0008
            L_0x0007:
                r13 = r6
            L_0x0008:
                r6 = r12 & 2
                if (r6 == 0) goto L_0x000e
                r1 = r0
                goto L_0x000f
            L_0x000e:
                r1 = r7
            L_0x000f:
                r6 = r12 & 4
                if (r6 == 0) goto L_0x0015
                r2 = r0
                goto L_0x0016
            L_0x0015:
                r2 = r8
            L_0x0016:
                r6 = r12 & 8
                if (r6 == 0) goto L_0x001c
                r3 = r0
                goto L_0x001d
            L_0x001c:
                r3 = r9
            L_0x001d:
                r6 = r12 & 16
                if (r6 == 0) goto L_0x0023
                r4 = r0
                goto L_0x0024
            L_0x0023:
                r4 = r10
            L_0x0024:
                r6 = r12 & 32
                if (r6 == 0) goto L_0x002a
                r12 = r0
                goto L_0x002b
            L_0x002a:
                r12 = r11
            L_0x002b:
                r6 = r5
                r7 = r13
                r8 = r1
                r9 = r2
                r10 = r3
                r11 = r4
                r6.<init>(r7, r8, r9, r10, r11, r12)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.model.PaymentMethodCreateParams.Card.<init>(java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String, java.util.Set, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public final String getNumber$payments_core_release() {
            return this.number;
        }

        public final Integer getExpiryMonth$payments_core_release() {
            return this.expiryMonth;
        }

        public final Integer getExpiryYear$payments_core_release() {
            return this.expiryYear;
        }

        public final String getCvc$payments_core_release() {
            return this.cvc;
        }

        public final Set<String> getAttribution$payments_core_release() {
            return this.attribution;
        }

        public final CardBrand getBrand$payments_core_release() {
            return CardUtils.getPossibleCardBrand(this.number);
        }

        public final String getLast4$payments_core_release() {
            String str = this.number;
            if (str == null) {
                return null;
            }
            return StringsKt.takeLast(str, 4);
        }

        public final String getLast4() {
            return getLast4$payments_core_release();
        }

        public Map<String, Object> toParamMap() {
            Pair pair;
            Pair[] pairArr = {TuplesKt.to(PARAM_NUMBER, this.number), TuplesKt.to(PARAM_EXP_MONTH, this.expiryMonth), TuplesKt.to(PARAM_EXP_YEAR, this.expiryYear), TuplesKt.to(PARAM_CVC, this.cvc), TuplesKt.to(PARAM_TOKEN, this.token)};
            Collection arrayList = new ArrayList();
            for (Pair pair2 : CollectionsKt.listOf(pairArr)) {
                Object second = pair2.getSecond();
                if (second == null) {
                    pair = null;
                } else {
                    pair = TuplesKt.to(pair2.getFirst(), second);
                }
                if (pair != null) {
                    arrayList.add(pair);
                }
            }
            return MapsKt.toMap((List) arrayList);
        }

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u0015\u0010\r\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0012\u0010\t\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\n\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/stripe/android/model/PaymentMethodCreateParams$Card$Builder;", "Lcom/stripe/android/ObjectBuilder;", "Lcom/stripe/android/model/PaymentMethodCreateParams$Card;", "()V", "cvc", "", "expiryMonth", "", "Ljava/lang/Integer;", "expiryYear", "number", "build", "setCvc", "setExpiryMonth", "(Ljava/lang/Integer;)Lcom/stripe/android/model/PaymentMethodCreateParams$Card$Builder;", "setExpiryYear", "setNumber", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethodCreateParams.kt */
        public static final class Builder implements ObjectBuilder<Card> {
            public static final int $stable = 8;
            private String cvc;
            private Integer expiryMonth;
            private Integer expiryYear;
            private String number;

            public final Builder setNumber(String str) {
                Builder builder = this;
                builder.number = str;
                return builder;
            }

            public final Builder setExpiryMonth(Integer num) {
                Builder builder = this;
                builder.expiryMonth = num;
                return builder;
            }

            public final Builder setExpiryYear(Integer num) {
                Builder builder = this;
                builder.expiryYear = num;
                return builder;
            }

            public final Builder setCvc(String str) {
                Builder builder = this;
                builder.cvc = str;
                return builder;
            }

            public Card build() {
                return new Card(this.number, this.expiryMonth, this.expiryYear, this.cvc, (String) null, (Set) null, 48, (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/stripe/android/model/PaymentMethodCreateParams$Card$Companion;", "", "()V", "PARAM_CVC", "", "PARAM_EXP_MONTH", "PARAM_EXP_YEAR", "PARAM_NUMBER", "PARAM_TOKEN", "create", "Lcom/stripe/android/model/PaymentMethodCreateParams$Card;", "token", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethodCreateParams.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Card create(String str) {
                Intrinsics.checkNotNullParameter(str, Card.PARAM_TOKEN);
                return new Card((String) null, (Integer) null, (Integer) null, (String) null, str, (Set) null, 46, (DefaultConstructorMarker) null);
            }
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001a2\u00020\u00012\u00020\u0002:\u0001\u001aB\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0015\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\fHÖ\u0001J\u0014\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00100\u0013H\u0016J\t\u0010\u0014\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\fHÖ\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u001b"}, d2 = {"Lcom/stripe/android/model/PaymentMethodCreateParams$Ideal;", "Lcom/stripe/android/model/StripeParamsModel;", "Landroid/os/Parcelable;", "bank", "", "(Ljava/lang/String;)V", "getBank", "()Ljava/lang/String;", "setBank", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toParamMap", "", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethodCreateParams.kt */
    public static final class Ideal implements StripeParamsModel, Parcelable {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Ideal> CREATOR = new Creator();
        private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @Deprecated
        private static final String PARAM_BANK = "bank";
        private String bank;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethodCreateParams.kt */
        public static final class Creator implements Parcelable.Creator<Ideal> {
            public final Ideal createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Ideal(parcel.readString());
            }

            public final Ideal[] newArray(int i) {
                return new Ideal[i];
            }
        }

        public static /* synthetic */ Ideal copy$default(Ideal ideal, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = ideal.bank;
            }
            return ideal.copy(str);
        }

        public final String component1() {
            return this.bank;
        }

        public final Ideal copy(String str) {
            return new Ideal(str);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Ideal) && Intrinsics.areEqual((Object) this.bank, (Object) ((Ideal) obj).bank);
        }

        public int hashCode() {
            String str = this.bank;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "Ideal(bank=" + this.bank + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.bank);
        }

        public Ideal(String str) {
            this.bank = str;
        }

        public final String getBank() {
            return this.bank;
        }

        public final void setBank(String str) {
            this.bank = str;
        }

        public Map<String, Object> toParamMap() {
            String str = this.bank;
            Map<String, Object> mapOf = str == null ? null : MapsKt.mapOf(TuplesKt.to(PARAM_BANK, str));
            return mapOf == null ? MapsKt.emptyMap() : mapOf;
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/model/PaymentMethodCreateParams$Ideal$Companion;", "", "()V", "PARAM_BANK", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethodCreateParams.kt */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001a2\u00020\u00012\u00020\u0002:\u0001\u001aB\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0015\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\fHÖ\u0001J\u0014\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00100\u0013H\u0016J\t\u0010\u0014\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\fHÖ\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u001b"}, d2 = {"Lcom/stripe/android/model/PaymentMethodCreateParams$Fpx;", "Lcom/stripe/android/model/StripeParamsModel;", "Landroid/os/Parcelable;", "bank", "", "(Ljava/lang/String;)V", "getBank", "()Ljava/lang/String;", "setBank", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toParamMap", "", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethodCreateParams.kt */
    public static final class Fpx implements StripeParamsModel, Parcelable {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Fpx> CREATOR = new Creator();
        private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @Deprecated
        private static final String PARAM_BANK = "bank";
        private String bank;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethodCreateParams.kt */
        public static final class Creator implements Parcelable.Creator<Fpx> {
            public final Fpx createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Fpx(parcel.readString());
            }

            public final Fpx[] newArray(int i) {
                return new Fpx[i];
            }
        }

        public static /* synthetic */ Fpx copy$default(Fpx fpx, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = fpx.bank;
            }
            return fpx.copy(str);
        }

        public final String component1() {
            return this.bank;
        }

        public final Fpx copy(String str) {
            return new Fpx(str);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Fpx) && Intrinsics.areEqual((Object) this.bank, (Object) ((Fpx) obj).bank);
        }

        public int hashCode() {
            String str = this.bank;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "Fpx(bank=" + this.bank + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.bank);
        }

        public Fpx(String str) {
            this.bank = str;
        }

        public final String getBank() {
            return this.bank;
        }

        public final void setBank(String str) {
            this.bank = str;
        }

        public Map<String, Object> toParamMap() {
            Map<String, Object> map;
            String str = this.bank;
            if (str == null) {
                map = null;
            } else {
                map = MapsKt.mapOf(TuplesKt.to(PARAM_BANK, str));
            }
            return map == null ? MapsKt.emptyMap() : map;
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/model/PaymentMethodCreateParams$Fpx$Companion;", "", "()V", "PARAM_BANK", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethodCreateParams.kt */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\u0001\u0017B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0004HÂ\u0003J\u0015\u0010\u0007\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\b\u001a\u00020\tHÖ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\tHÖ\u0001J\u0014\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0\u0010H\u0016J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\tHÖ\u0001R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/stripe/android/model/PaymentMethodCreateParams$Upi;", "Lcom/stripe/android/model/StripeParamsModel;", "Landroid/os/Parcelable;", "vpa", "", "(Ljava/lang/String;)V", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toParamMap", "", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethodCreateParams.kt */
    public static final class Upi implements StripeParamsModel, Parcelable {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Upi> CREATOR = new Creator();
        private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @Deprecated
        private static final String PARAM_VPA = "vpa";
        private final String vpa;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethodCreateParams.kt */
        public static final class Creator implements Parcelable.Creator<Upi> {
            public final Upi createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Upi(parcel.readString());
            }

            public final Upi[] newArray(int i) {
                return new Upi[i];
            }
        }

        private final String component1() {
            return this.vpa;
        }

        public static /* synthetic */ Upi copy$default(Upi upi, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = upi.vpa;
            }
            return upi.copy(str);
        }

        public final Upi copy(String str) {
            return new Upi(str);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Upi) && Intrinsics.areEqual((Object) this.vpa, (Object) ((Upi) obj).vpa);
        }

        public int hashCode() {
            String str = this.vpa;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "Upi(vpa=" + this.vpa + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.vpa);
        }

        public Upi(String str) {
            this.vpa = str;
        }

        public Map<String, Object> toParamMap() {
            Map<String, Object> map;
            String str = this.vpa;
            if (str == null) {
                map = null;
            } else {
                map = MapsKt.mapOf(TuplesKt.to(PARAM_VPA, str));
            }
            return map == null ? MapsKt.emptyMap() : map;
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/model/PaymentMethodCreateParams$Upi$Companion;", "", "()V", "PARAM_VPA", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethodCreateParams.kt */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001a2\u00020\u00012\u00020\u0002:\u0001\u001aB\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0015\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\fHÖ\u0001J\u0014\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00100\u0013H\u0016J\t\u0010\u0014\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\fHÖ\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u001b"}, d2 = {"Lcom/stripe/android/model/PaymentMethodCreateParams$SepaDebit;", "Lcom/stripe/android/model/StripeParamsModel;", "Landroid/os/Parcelable;", "iban", "", "(Ljava/lang/String;)V", "getIban", "()Ljava/lang/String;", "setIban", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toParamMap", "", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethodCreateParams.kt */
    public static final class SepaDebit implements StripeParamsModel, Parcelable {
        public static final int $stable = 8;
        public static final Parcelable.Creator<SepaDebit> CREATOR = new Creator();
        private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @Deprecated
        private static final String PARAM_IBAN = "iban";
        private String iban;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethodCreateParams.kt */
        public static final class Creator implements Parcelable.Creator<SepaDebit> {
            public final SepaDebit createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new SepaDebit(parcel.readString());
            }

            public final SepaDebit[] newArray(int i) {
                return new SepaDebit[i];
            }
        }

        public static /* synthetic */ SepaDebit copy$default(SepaDebit sepaDebit, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = sepaDebit.iban;
            }
            return sepaDebit.copy(str);
        }

        public final String component1() {
            return this.iban;
        }

        public final SepaDebit copy(String str) {
            return new SepaDebit(str);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SepaDebit) && Intrinsics.areEqual((Object) this.iban, (Object) ((SepaDebit) obj).iban);
        }

        public int hashCode() {
            String str = this.iban;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "SepaDebit(iban=" + this.iban + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.iban);
        }

        public SepaDebit(String str) {
            this.iban = str;
        }

        public final String getIban() {
            return this.iban;
        }

        public final void setIban(String str) {
            this.iban = str;
        }

        public Map<String, Object> toParamMap() {
            Map<String, Object> map;
            String str = this.iban;
            if (str == null) {
                map = null;
            } else {
                map = MapsKt.mapOf(TuplesKt.to(PARAM_IBAN, str));
            }
            return map == null ? MapsKt.emptyMap() : map;
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/model/PaymentMethodCreateParams$SepaDebit$Companion;", "", "()V", "PARAM_IBAN", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethodCreateParams.kt */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u001fB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0011HÖ\u0001J\u0014\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00150\u0018H\u0016J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0011HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006 "}, d2 = {"Lcom/stripe/android/model/PaymentMethodCreateParams$AuBecsDebit;", "Lcom/stripe/android/model/StripeParamsModel;", "Landroid/os/Parcelable;", "bsbNumber", "", "accountNumber", "(Ljava/lang/String;Ljava/lang/String;)V", "getAccountNumber", "()Ljava/lang/String;", "setAccountNumber", "(Ljava/lang/String;)V", "getBsbNumber", "setBsbNumber", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toParamMap", "", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethodCreateParams.kt */
    public static final class AuBecsDebit implements StripeParamsModel, Parcelable {
        public static final int $stable = 8;
        public static final Parcelable.Creator<AuBecsDebit> CREATOR = new Creator();
        private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @Deprecated
        private static final String PARAM_ACCOUNT_NUMBER = "account_number";
        @Deprecated
        private static final String PARAM_BSB_NUMBER = "bsb_number";
        private String accountNumber;
        private String bsbNumber;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethodCreateParams.kt */
        public static final class Creator implements Parcelable.Creator<AuBecsDebit> {
            public final AuBecsDebit createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new AuBecsDebit(parcel.readString(), parcel.readString());
            }

            public final AuBecsDebit[] newArray(int i) {
                return new AuBecsDebit[i];
            }
        }

        public static /* synthetic */ AuBecsDebit copy$default(AuBecsDebit auBecsDebit, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = auBecsDebit.bsbNumber;
            }
            if ((i & 2) != 0) {
                str2 = auBecsDebit.accountNumber;
            }
            return auBecsDebit.copy(str, str2);
        }

        public final String component1() {
            return this.bsbNumber;
        }

        public final String component2() {
            return this.accountNumber;
        }

        public final AuBecsDebit copy(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "bsbNumber");
            Intrinsics.checkNotNullParameter(str2, "accountNumber");
            return new AuBecsDebit(str, str2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AuBecsDebit)) {
                return false;
            }
            AuBecsDebit auBecsDebit = (AuBecsDebit) obj;
            return Intrinsics.areEqual((Object) this.bsbNumber, (Object) auBecsDebit.bsbNumber) && Intrinsics.areEqual((Object) this.accountNumber, (Object) auBecsDebit.accountNumber);
        }

        public int hashCode() {
            return (this.bsbNumber.hashCode() * 31) + this.accountNumber.hashCode();
        }

        public String toString() {
            return "AuBecsDebit(bsbNumber=" + this.bsbNumber + ", accountNumber=" + this.accountNumber + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.bsbNumber);
            parcel.writeString(this.accountNumber);
        }

        public AuBecsDebit(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "bsbNumber");
            Intrinsics.checkNotNullParameter(str2, "accountNumber");
            this.bsbNumber = str;
            this.accountNumber = str2;
        }

        public final String getBsbNumber() {
            return this.bsbNumber;
        }

        public final void setBsbNumber(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.bsbNumber = str;
        }

        public final String getAccountNumber() {
            return this.accountNumber;
        }

        public final void setAccountNumber(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.accountNumber = str;
        }

        public Map<String, Object> toParamMap() {
            return MapsKt.mapOf(TuplesKt.to(PARAM_BSB_NUMBER, this.bsbNumber), TuplesKt.to(PARAM_ACCOUNT_NUMBER, this.accountNumber));
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/model/PaymentMethodCreateParams$AuBecsDebit$Companion;", "", "()V", "PARAM_ACCOUNT_NUMBER", "", "PARAM_BSB_NUMBER", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethodCreateParams.kt */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u001fB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0011HÖ\u0001J\u0014\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00150\u0018H\u0016J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0011HÖ\u0001R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006 "}, d2 = {"Lcom/stripe/android/model/PaymentMethodCreateParams$BacsDebit;", "Lcom/stripe/android/model/StripeParamsModel;", "Landroid/os/Parcelable;", "accountNumber", "", "sortCode", "(Ljava/lang/String;Ljava/lang/String;)V", "getAccountNumber", "()Ljava/lang/String;", "setAccountNumber", "(Ljava/lang/String;)V", "getSortCode", "setSortCode", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toParamMap", "", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethodCreateParams.kt */
    public static final class BacsDebit implements StripeParamsModel, Parcelable {
        public static final int $stable = 8;
        public static final Parcelable.Creator<BacsDebit> CREATOR = new Creator();
        private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @Deprecated
        private static final String PARAM_ACCOUNT_NUMBER = "account_number";
        @Deprecated
        private static final String PARAM_SORT_CODE = "sort_code";
        private String accountNumber;
        private String sortCode;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethodCreateParams.kt */
        public static final class Creator implements Parcelable.Creator<BacsDebit> {
            public final BacsDebit createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new BacsDebit(parcel.readString(), parcel.readString());
            }

            public final BacsDebit[] newArray(int i) {
                return new BacsDebit[i];
            }
        }

        public static /* synthetic */ BacsDebit copy$default(BacsDebit bacsDebit, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = bacsDebit.accountNumber;
            }
            if ((i & 2) != 0) {
                str2 = bacsDebit.sortCode;
            }
            return bacsDebit.copy(str, str2);
        }

        public final String component1() {
            return this.accountNumber;
        }

        public final String component2() {
            return this.sortCode;
        }

        public final BacsDebit copy(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "accountNumber");
            Intrinsics.checkNotNullParameter(str2, "sortCode");
            return new BacsDebit(str, str2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BacsDebit)) {
                return false;
            }
            BacsDebit bacsDebit = (BacsDebit) obj;
            return Intrinsics.areEqual((Object) this.accountNumber, (Object) bacsDebit.accountNumber) && Intrinsics.areEqual((Object) this.sortCode, (Object) bacsDebit.sortCode);
        }

        public int hashCode() {
            return (this.accountNumber.hashCode() * 31) + this.sortCode.hashCode();
        }

        public String toString() {
            return "BacsDebit(accountNumber=" + this.accountNumber + ", sortCode=" + this.sortCode + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.accountNumber);
            parcel.writeString(this.sortCode);
        }

        public BacsDebit(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "accountNumber");
            Intrinsics.checkNotNullParameter(str2, "sortCode");
            this.accountNumber = str;
            this.sortCode = str2;
        }

        public final String getAccountNumber() {
            return this.accountNumber;
        }

        public final void setAccountNumber(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.accountNumber = str;
        }

        public final String getSortCode() {
            return this.sortCode;
        }

        public final void setSortCode(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.sortCode = str;
        }

        public Map<String, Object> toParamMap() {
            return MapsKt.mapOf(TuplesKt.to(PARAM_ACCOUNT_NUMBER, this.accountNumber), TuplesKt.to(PARAM_SORT_CODE, this.sortCode));
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/model/PaymentMethodCreateParams$BacsDebit$Companion;", "", "()V", "PARAM_ACCOUNT_NUMBER", "", "PARAM_SORT_CODE", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethodCreateParams.kt */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0001\u001bB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\t\u001a\u00020\u0004HÀ\u0003¢\u0006\u0002\b\nJ\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\u0014\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110\u0014H\u0016J\t\u0010\u0015\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\rHÖ\u0001R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u001c"}, d2 = {"Lcom/stripe/android/model/PaymentMethodCreateParams$Sofort;", "Lcom/stripe/android/model/StripeParamsModel;", "Landroid/os/Parcelable;", "country", "", "(Ljava/lang/String;)V", "getCountry$payments_core_release", "()Ljava/lang/String;", "setCountry$payments_core_release", "component1", "component1$payments_core_release", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toParamMap", "", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethodCreateParams.kt */
    public static final class Sofort implements StripeParamsModel, Parcelable {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Sofort> CREATOR = new Creator();
        private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @Deprecated
        private static final String PARAM_COUNTRY = "country";
        private String country;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethodCreateParams.kt */
        public static final class Creator implements Parcelable.Creator<Sofort> {
            public final Sofort createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Sofort(parcel.readString());
            }

            public final Sofort[] newArray(int i) {
                return new Sofort[i];
            }
        }

        public static /* synthetic */ Sofort copy$default(Sofort sofort, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = sofort.country;
            }
            return sofort.copy(str);
        }

        public final String component1$payments_core_release() {
            return this.country;
        }

        public final Sofort copy(String str) {
            Intrinsics.checkNotNullParameter(str, "country");
            return new Sofort(str);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Sofort) && Intrinsics.areEqual((Object) this.country, (Object) ((Sofort) obj).country);
        }

        public int hashCode() {
            return this.country.hashCode();
        }

        public String toString() {
            return "Sofort(country=" + this.country + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.country);
        }

        public Sofort(String str) {
            Intrinsics.checkNotNullParameter(str, "country");
            this.country = str;
        }

        public final String getCountry$payments_core_release() {
            return this.country;
        }

        public final void setCountry$payments_core_release(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.country = str;
        }

        public Map<String, Object> toParamMap() {
            String upperCase = this.country.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            return MapsKt.mapOf(TuplesKt.to("country", upperCase));
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/model/PaymentMethodCreateParams$Sofort$Companion;", "", "()V", "PARAM_COUNTRY", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethodCreateParams.kt */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0001\u001bB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\t\u001a\u00020\u0004HÀ\u0003¢\u0006\u0002\b\nJ\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\u0014\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110\u0014H\u0016J\t\u0010\u0015\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\rHÖ\u0001R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u001c"}, d2 = {"Lcom/stripe/android/model/PaymentMethodCreateParams$Netbanking;", "Lcom/stripe/android/model/StripeParamsModel;", "Landroid/os/Parcelable;", "bank", "", "(Ljava/lang/String;)V", "getBank$payments_core_release", "()Ljava/lang/String;", "setBank$payments_core_release", "component1", "component1$payments_core_release", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toParamMap", "", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethodCreateParams.kt */
    public static final class Netbanking implements StripeParamsModel, Parcelable {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Netbanking> CREATOR = new Creator();
        private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @Deprecated
        private static final String PARAM_BANK = "bank";
        private String bank;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethodCreateParams.kt */
        public static final class Creator implements Parcelable.Creator<Netbanking> {
            public final Netbanking createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Netbanking(parcel.readString());
            }

            public final Netbanking[] newArray(int i) {
                return new Netbanking[i];
            }
        }

        public static /* synthetic */ Netbanking copy$default(Netbanking netbanking, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = netbanking.bank;
            }
            return netbanking.copy(str);
        }

        public final String component1$payments_core_release() {
            return this.bank;
        }

        public final Netbanking copy(String str) {
            Intrinsics.checkNotNullParameter(str, PARAM_BANK);
            return new Netbanking(str);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Netbanking) && Intrinsics.areEqual((Object) this.bank, (Object) ((Netbanking) obj).bank);
        }

        public int hashCode() {
            return this.bank.hashCode();
        }

        public String toString() {
            return "Netbanking(bank=" + this.bank + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.bank);
        }

        public Netbanking(String str) {
            Intrinsics.checkNotNullParameter(str, PARAM_BANK);
            this.bank = str;
        }

        public final String getBank$payments_core_release() {
            return this.bank;
        }

        public final void setBank$payments_core_release(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.bank = str;
        }

        public Map<String, Object> toParamMap() {
            String lowerCase = this.bank.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            return MapsKt.mapOf(TuplesKt.to(PARAM_BANK, lowerCase));
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/model/PaymentMethodCreateParams$Netbanking$Companion;", "", "()V", "PARAM_BANK", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethodCreateParams.kt */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 12\u00020\u00012\u00020\u0002:\u00011B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u0019\u001a\u00020\u0004HÀ\u0003¢\u0006\u0002\b\u001aJ\u000e\u0010\u001b\u001a\u00020\u0004HÀ\u0003¢\u0006\u0002\b\u001cJ\u000e\u0010\u001d\u001a\u00020\u0007HÀ\u0003¢\u0006\u0002\b\u001eJ\u000e\u0010\u001f\u001a\u00020\tHÀ\u0003¢\u0006\u0002\b J1\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020#HÖ\u0001J\u0014\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020'0*H\u0016J\t\u0010+\u001a\u00020\u0004HÖ\u0001J\u0019\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020#HÖ\u0001R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012¨\u00062"}, d2 = {"Lcom/stripe/android/model/PaymentMethodCreateParams$USBankAccount;", "Lcom/stripe/android/model/StripeParamsModel;", "Landroid/os/Parcelable;", "accountNumber", "", "routingNumber", "accountType", "Lcom/stripe/android/model/PaymentMethod$USBankAccount$USBankAccountType;", "accountHolderType", "Lcom/stripe/android/model/PaymentMethod$USBankAccount$USBankAccountHolderType;", "(Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/model/PaymentMethod$USBankAccount$USBankAccountType;Lcom/stripe/android/model/PaymentMethod$USBankAccount$USBankAccountHolderType;)V", "getAccountHolderType$payments_core_release", "()Lcom/stripe/android/model/PaymentMethod$USBankAccount$USBankAccountHolderType;", "setAccountHolderType$payments_core_release", "(Lcom/stripe/android/model/PaymentMethod$USBankAccount$USBankAccountHolderType;)V", "getAccountNumber$payments_core_release", "()Ljava/lang/String;", "setAccountNumber$payments_core_release", "(Ljava/lang/String;)V", "getAccountType$payments_core_release", "()Lcom/stripe/android/model/PaymentMethod$USBankAccount$USBankAccountType;", "setAccountType$payments_core_release", "(Lcom/stripe/android/model/PaymentMethod$USBankAccount$USBankAccountType;)V", "getRoutingNumber$payments_core_release", "setRoutingNumber$payments_core_release", "component1", "component1$payments_core_release", "component2", "component2$payments_core_release", "component3", "component3$payments_core_release", "component4", "component4$payments_core_release", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toParamMap", "", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethodCreateParams.kt */
    public static final class USBankAccount implements StripeParamsModel, Parcelable {
        public static final int $stable = 8;
        public static final Parcelable.Creator<USBankAccount> CREATOR = new Creator();
        private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @Deprecated
        private static final String PARAM_ACCOUNT_HOLDER_TYPE = "account_holder_type";
        @Deprecated
        private static final String PARAM_ACCOUNT_NUMBER = "account_number";
        @Deprecated
        private static final String PARAM_ACCOUNT_TYPE = "account_type";
        @Deprecated
        private static final String PARAM_ROUTING_NUMBER = "routing_number";
        private PaymentMethod.USBankAccount.USBankAccountHolderType accountHolderType;
        private String accountNumber;
        private PaymentMethod.USBankAccount.USBankAccountType accountType;
        private String routingNumber;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethodCreateParams.kt */
        public static final class Creator implements Parcelable.Creator<USBankAccount> {
            public final USBankAccount createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new USBankAccount(parcel.readString(), parcel.readString(), PaymentMethod.USBankAccount.USBankAccountType.CREATOR.createFromParcel(parcel), PaymentMethod.USBankAccount.USBankAccountHolderType.CREATOR.createFromParcel(parcel));
            }

            public final USBankAccount[] newArray(int i) {
                return new USBankAccount[i];
            }
        }

        public static /* synthetic */ USBankAccount copy$default(USBankAccount uSBankAccount, String str, String str2, PaymentMethod.USBankAccount.USBankAccountType uSBankAccountType, PaymentMethod.USBankAccount.USBankAccountHolderType uSBankAccountHolderType, int i, Object obj) {
            if ((i & 1) != 0) {
                str = uSBankAccount.accountNumber;
            }
            if ((i & 2) != 0) {
                str2 = uSBankAccount.routingNumber;
            }
            if ((i & 4) != 0) {
                uSBankAccountType = uSBankAccount.accountType;
            }
            if ((i & 8) != 0) {
                uSBankAccountHolderType = uSBankAccount.accountHolderType;
            }
            return uSBankAccount.copy(str, str2, uSBankAccountType, uSBankAccountHolderType);
        }

        public final String component1$payments_core_release() {
            return this.accountNumber;
        }

        public final String component2$payments_core_release() {
            return this.routingNumber;
        }

        public final PaymentMethod.USBankAccount.USBankAccountType component3$payments_core_release() {
            return this.accountType;
        }

        public final PaymentMethod.USBankAccount.USBankAccountHolderType component4$payments_core_release() {
            return this.accountHolderType;
        }

        public final USBankAccount copy(String str, String str2, PaymentMethod.USBankAccount.USBankAccountType uSBankAccountType, PaymentMethod.USBankAccount.USBankAccountHolderType uSBankAccountHolderType) {
            Intrinsics.checkNotNullParameter(str, "accountNumber");
            Intrinsics.checkNotNullParameter(str2, "routingNumber");
            Intrinsics.checkNotNullParameter(uSBankAccountType, "accountType");
            Intrinsics.checkNotNullParameter(uSBankAccountHolderType, "accountHolderType");
            return new USBankAccount(str, str2, uSBankAccountType, uSBankAccountHolderType);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof USBankAccount)) {
                return false;
            }
            USBankAccount uSBankAccount = (USBankAccount) obj;
            return Intrinsics.areEqual((Object) this.accountNumber, (Object) uSBankAccount.accountNumber) && Intrinsics.areEqual((Object) this.routingNumber, (Object) uSBankAccount.routingNumber) && this.accountType == uSBankAccount.accountType && this.accountHolderType == uSBankAccount.accountHolderType;
        }

        public int hashCode() {
            return (((((this.accountNumber.hashCode() * 31) + this.routingNumber.hashCode()) * 31) + this.accountType.hashCode()) * 31) + this.accountHolderType.hashCode();
        }

        public String toString() {
            return "USBankAccount(accountNumber=" + this.accountNumber + ", routingNumber=" + this.routingNumber + ", accountType=" + this.accountType + ", accountHolderType=" + this.accountHolderType + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.accountNumber);
            parcel.writeString(this.routingNumber);
            this.accountType.writeToParcel(parcel, i);
            this.accountHolderType.writeToParcel(parcel, i);
        }

        public USBankAccount(String str, String str2, PaymentMethod.USBankAccount.USBankAccountType uSBankAccountType, PaymentMethod.USBankAccount.USBankAccountHolderType uSBankAccountHolderType) {
            Intrinsics.checkNotNullParameter(str, "accountNumber");
            Intrinsics.checkNotNullParameter(str2, "routingNumber");
            Intrinsics.checkNotNullParameter(uSBankAccountType, "accountType");
            Intrinsics.checkNotNullParameter(uSBankAccountHolderType, "accountHolderType");
            this.accountNumber = str;
            this.routingNumber = str2;
            this.accountType = uSBankAccountType;
            this.accountHolderType = uSBankAccountHolderType;
        }

        public final String getAccountNumber$payments_core_release() {
            return this.accountNumber;
        }

        public final void setAccountNumber$payments_core_release(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.accountNumber = str;
        }

        public final String getRoutingNumber$payments_core_release() {
            return this.routingNumber;
        }

        public final void setRoutingNumber$payments_core_release(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.routingNumber = str;
        }

        public final PaymentMethod.USBankAccount.USBankAccountType getAccountType$payments_core_release() {
            return this.accountType;
        }

        public final void setAccountType$payments_core_release(PaymentMethod.USBankAccount.USBankAccountType uSBankAccountType) {
            Intrinsics.checkNotNullParameter(uSBankAccountType, "<set-?>");
            this.accountType = uSBankAccountType;
        }

        public final PaymentMethod.USBankAccount.USBankAccountHolderType getAccountHolderType$payments_core_release() {
            return this.accountHolderType;
        }

        public final void setAccountHolderType$payments_core_release(PaymentMethod.USBankAccount.USBankAccountHolderType uSBankAccountHolderType) {
            Intrinsics.checkNotNullParameter(uSBankAccountHolderType, "<set-?>");
            this.accountHolderType = uSBankAccountHolderType;
        }

        public Map<String, Object> toParamMap() {
            return MapsKt.mapOf(TuplesKt.to(PARAM_ACCOUNT_NUMBER, this.accountNumber), TuplesKt.to(PARAM_ROUTING_NUMBER, this.routingNumber), TuplesKt.to(PARAM_ACCOUNT_TYPE, this.accountType.getValue()), TuplesKt.to(PARAM_ACCOUNT_HOLDER_TYPE, this.accountHolderType.getValue()));
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/stripe/android/model/PaymentMethodCreateParams$USBankAccount$Companion;", "", "()V", "PARAM_ACCOUNT_HOLDER_TYPE", "", "PARAM_ACCOUNT_NUMBER", "PARAM_ACCOUNT_TYPE", "PARAM_ROUTING_NUMBER", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethodCreateParams.kt */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0001(B9\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\"\b\u0002\u0010\u0006\u001a\u001c\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0007\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u0013\u001a\u00020\u0004HÀ\u0003¢\u0006\u0002\b\u0014J\u000e\u0010\u0015\u001a\u00020\u0004HÀ\u0003¢\u0006\u0002\b\u0016J(\u0010\u0017\u001a\u001c\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0007\u0018\u00010\u0007HÀ\u0003¢\u0006\u0002\b\u0018JA\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\"\b\u0002\u0010\u0006\u001a\u001c\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0007\u0018\u00010\u0007HÆ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u001bHÖ\u0001J\u0014\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001f0\u0007H\u0016J\t\u0010\"\u001a\u00020\u0004HÖ\u0001J\u0019\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001bHÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR4\u0010\u0006\u001a\u001c\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0007\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006)"}, d2 = {"Lcom/stripe/android/model/PaymentMethodCreateParams$Link;", "Lcom/stripe/android/model/StripeParamsModel;", "Landroid/os/Parcelable;", "paymentDetailsId", "", "consumerSessionClientSecret", "paymentMethodOptions", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getConsumerSessionClientSecret$payments_core_release", "()Ljava/lang/String;", "setConsumerSessionClientSecret$payments_core_release", "(Ljava/lang/String;)V", "getPaymentDetailsId$payments_core_release", "setPaymentDetailsId$payments_core_release", "getPaymentMethodOptions$payments_core_release", "()Ljava/util/Map;", "setPaymentMethodOptions$payments_core_release", "(Ljava/util/Map;)V", "component1", "component1$payments_core_release", "component2", "component2$payments_core_release", "component3", "component3$payments_core_release", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toParamMap", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethodCreateParams.kt */
    public static final class Link implements StripeParamsModel, Parcelable {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Link> CREATOR = new Creator();
        private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @Deprecated
        private static final String PARAM_CONSUMER_SESSION_CLIENT_SECRET = "consumer_session_client_secret";
        @Deprecated
        private static final String PARAM_CREDENTIALS = "credentials";
        @Deprecated
        private static final String PARAM_PAYMENT_DETAILS_ID = "payment_details_id";
        @Deprecated
        private static final String PARAM_PAYMENT_METHOD_OPTIONS = "payment_method_options";
        private String consumerSessionClientSecret;
        private String paymentDetailsId;
        private Map<String, ? extends Map<String, String>> paymentMethodOptions;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethodCreateParams.kt */
        public static final class Creator implements Parcelable.Creator<Link> {
            public final Link createFromParcel(Parcel parcel) {
                LinkedHashMap linkedHashMap;
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                if (parcel.readInt() == 0) {
                    linkedHashMap = null;
                } else {
                    int readInt = parcel.readInt();
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap(readInt);
                    for (int i = 0; i != readInt; i++) {
                        String readString3 = parcel.readString();
                        int readInt2 = parcel.readInt();
                        LinkedHashMap linkedHashMap3 = new LinkedHashMap(readInt2);
                        for (int i2 = 0; i2 != readInt2; i2++) {
                            linkedHashMap3.put(parcel.readString(), parcel.readString());
                        }
                        linkedHashMap2.put(readString3, linkedHashMap3);
                    }
                    linkedHashMap = linkedHashMap2;
                }
                return new Link(readString, readString2, linkedHashMap);
            }

            public final Link[] newArray(int i) {
                return new Link[i];
            }
        }

        public static /* synthetic */ Link copy$default(Link link, String str, String str2, Map<String, ? extends Map<String, String>> map, int i, Object obj) {
            if ((i & 1) != 0) {
                str = link.paymentDetailsId;
            }
            if ((i & 2) != 0) {
                str2 = link.consumerSessionClientSecret;
            }
            if ((i & 4) != 0) {
                map = link.paymentMethodOptions;
            }
            return link.copy(str, str2, map);
        }

        public final String component1$payments_core_release() {
            return this.paymentDetailsId;
        }

        public final String component2$payments_core_release() {
            return this.consumerSessionClientSecret;
        }

        public final Map<String, Map<String, String>> component3$payments_core_release() {
            return this.paymentMethodOptions;
        }

        public final Link copy(String str, String str2, Map<String, ? extends Map<String, String>> map) {
            Intrinsics.checkNotNullParameter(str, "paymentDetailsId");
            Intrinsics.checkNotNullParameter(str2, "consumerSessionClientSecret");
            return new Link(str, str2, map);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Link)) {
                return false;
            }
            Link link = (Link) obj;
            return Intrinsics.areEqual((Object) this.paymentDetailsId, (Object) link.paymentDetailsId) && Intrinsics.areEqual((Object) this.consumerSessionClientSecret, (Object) link.consumerSessionClientSecret) && Intrinsics.areEqual((Object) this.paymentMethodOptions, (Object) link.paymentMethodOptions);
        }

        public int hashCode() {
            int hashCode = ((this.paymentDetailsId.hashCode() * 31) + this.consumerSessionClientSecret.hashCode()) * 31;
            Map<String, ? extends Map<String, String>> map = this.paymentMethodOptions;
            return hashCode + (map == null ? 0 : map.hashCode());
        }

        public String toString() {
            return "Link(paymentDetailsId=" + this.paymentDetailsId + ", consumerSessionClientSecret=" + this.consumerSessionClientSecret + ", paymentMethodOptions=" + this.paymentMethodOptions + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.paymentDetailsId);
            parcel.writeString(this.consumerSessionClientSecret);
            Map<String, ? extends Map<String, String>> map = this.paymentMethodOptions;
            if (map == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            parcel.writeInt(map.size());
            for (Map.Entry next : map.entrySet()) {
                parcel.writeString((String) next.getKey());
                Map map2 = (Map) next.getValue();
                parcel.writeInt(map2.size());
                for (Map.Entry entry : map2.entrySet()) {
                    parcel.writeString((String) entry.getKey());
                    parcel.writeString((String) entry.getValue());
                }
            }
        }

        public Link(String str, String str2, Map<String, ? extends Map<String, String>> map) {
            Intrinsics.checkNotNullParameter(str, "paymentDetailsId");
            Intrinsics.checkNotNullParameter(str2, "consumerSessionClientSecret");
            this.paymentDetailsId = str;
            this.consumerSessionClientSecret = str2;
            this.paymentMethodOptions = map;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Link(String str, String str2, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i & 4) != 0 ? null : map);
        }

        public final String getPaymentDetailsId$payments_core_release() {
            return this.paymentDetailsId;
        }

        public final void setPaymentDetailsId$payments_core_release(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.paymentDetailsId = str;
        }

        public final String getConsumerSessionClientSecret$payments_core_release() {
            return this.consumerSessionClientSecret;
        }

        public final void setConsumerSessionClientSecret$payments_core_release(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.consumerSessionClientSecret = str;
        }

        public final Map<String, Map<String, String>> getPaymentMethodOptions$payments_core_release() {
            return this.paymentMethodOptions;
        }

        public final void setPaymentMethodOptions$payments_core_release(Map<String, ? extends Map<String, String>> map) {
            this.paymentMethodOptions = map;
        }

        public Map<String, Object> toParamMap() {
            Map<K, V> map;
            Map mapOf = MapsKt.mapOf(TuplesKt.to(PARAM_PAYMENT_DETAILS_ID, this.paymentDetailsId), TuplesKt.to(PARAM_CREDENTIALS, MapsKt.mapOf(TuplesKt.to(PARAM_CONSUMER_SESSION_CLIENT_SECRET, this.consumerSessionClientSecret))));
            Map<String, ? extends Map<String, String>> map2 = this.paymentMethodOptions;
            if (map2 == null) {
                map = null;
            } else {
                map = MapsKt.mapOf(TuplesKt.to(PARAM_PAYMENT_METHOD_OPTIONS, map2));
            }
            if (map == null) {
                map = MapsKt.emptyMap();
            }
            return MapsKt.plus(mapOf, (Map) map);
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/stripe/android/model/PaymentMethodCreateParams$Link$Companion;", "", "()V", "PARAM_CONSUMER_SESSION_CLIENT_SECRET", "", "PARAM_CREDENTIALS", "PARAM_PAYMENT_DETAILS_ID", "PARAM_PAYMENT_METHOD_OPTIONS", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethodCreateParams.kt */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000eH\u0007J0\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000eH\u0007J4\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000eH\u0007J4\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000eH\u0007J4\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000eH\u0007J4\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000eH\u0007J4\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000eH\u0007J4\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001c2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000eH\u0007J4\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001e2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000eH\u0007J4\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020 2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000eH\u0007J,\u0010!\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000eH\u0007J,\u0010\"\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000eH\u0007J \u0010#\u001a\u00020\b2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000eH\u0007J(\u0010$\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000eH\u0007J,\u0010%\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000eH\u0007J\u0010\u0010&\u001a\u00020\b2\u0006\u0010'\u001a\u00020(H\u0007J(\u0010)\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000eH\u0007J\u0010\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020,H\u0007J(\u0010-\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000eH\u0007J(\u0010.\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000eH\u0007J,\u0010/\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000eH\u0007J<\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u00042\"\b\u0002\u00103\u001a\u001c\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000e\u0018\u00010\u000eH\u0007J(\u00104\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000eH\u0007J(\u00105\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000eH\u0007J \u00106\u001a\u00020\b2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000eH\u0007J,\u00107\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000eH\u0007J,\u00108\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000eH\u0007J9\u00109\u001a\u00020\b2\u0006\u0010:\u001a\u00020;2\u0019\u0010<\u001a\u0015\u0012\u0004\u0012\u00020\u0004\u0012\t\u0012\u00070\u0001¢\u0006\u0002\b=\u0018\u00010\u000e2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00040?H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/stripe/android/model/PaymentMethodCreateParams$Companion;", "", "()V", "PARAM_BILLING_DETAILS", "", "PARAM_METADATA", "PARAM_TYPE", "create", "Lcom/stripe/android/model/PaymentMethodCreateParams;", "auBecsDebit", "Lcom/stripe/android/model/PaymentMethodCreateParams$AuBecsDebit;", "billingDetails", "Lcom/stripe/android/model/PaymentMethod$BillingDetails;", "metadata", "", "bacsDebit", "Lcom/stripe/android/model/PaymentMethodCreateParams$BacsDebit;", "card", "Lcom/stripe/android/model/PaymentMethodCreateParams$Card;", "fpx", "Lcom/stripe/android/model/PaymentMethodCreateParams$Fpx;", "ideal", "Lcom/stripe/android/model/PaymentMethodCreateParams$Ideal;", "netbanking", "Lcom/stripe/android/model/PaymentMethodCreateParams$Netbanking;", "sepaDebit", "Lcom/stripe/android/model/PaymentMethodCreateParams$SepaDebit;", "sofort", "Lcom/stripe/android/model/PaymentMethodCreateParams$Sofort;", "usBankAccount", "Lcom/stripe/android/model/PaymentMethodCreateParams$USBankAccount;", "upi", "Lcom/stripe/android/model/PaymentMethodCreateParams$Upi;", "createAffirm", "createAfterpayClearpay", "createAlipay", "createBancontact", "createBlik", "createCard", "cardParams", "Lcom/stripe/android/model/CardParams;", "createEps", "createFromGooglePay", "googlePayPaymentData", "Lorg/json/JSONObject;", "createGiropay", "createGrabPay", "createKlarna", "createLink", "paymentDetailsId", "consumerSessionClientSecret", "paymentMethodOptions", "createOxxo", "createP24", "createPayPal", "createUSBankAccount", "createWeChatPay", "createWithOverride", "type", "Lcom/stripe/android/model/PaymentMethod$Type;", "overrideParamMap", "Lkotlinx/parcelize/RawValue;", "productUsage", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethodCreateParams.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final PaymentMethodCreateParams create(AuBecsDebit auBecsDebit, PaymentMethod.BillingDetails billingDetails) {
            Intrinsics.checkNotNullParameter(auBecsDebit, "auBecsDebit");
            Intrinsics.checkNotNullParameter(billingDetails, "billingDetails");
            return create$default(this, auBecsDebit, billingDetails, (Map) null, 4, (Object) null);
        }

        @JvmStatic
        public final PaymentMethodCreateParams create(BacsDebit bacsDebit, PaymentMethod.BillingDetails billingDetails) {
            Intrinsics.checkNotNullParameter(bacsDebit, "bacsDebit");
            Intrinsics.checkNotNullParameter(billingDetails, "billingDetails");
            return create$default(this, bacsDebit, billingDetails, (Map) null, 4, (Object) null);
        }

        @JvmStatic
        public final PaymentMethodCreateParams create(Card card) {
            Intrinsics.checkNotNullParameter(card, "card");
            return create$default(this, card, (PaymentMethod.BillingDetails) null, (Map) null, 6, (Object) null);
        }

        @JvmStatic
        public final PaymentMethodCreateParams create(Card card, PaymentMethod.BillingDetails billingDetails) {
            Intrinsics.checkNotNullParameter(card, "card");
            return create$default(this, card, billingDetails, (Map) null, 4, (Object) null);
        }

        @JvmStatic
        public final PaymentMethodCreateParams create(Fpx fpx) {
            Intrinsics.checkNotNullParameter(fpx, "fpx");
            return create$default(this, fpx, (PaymentMethod.BillingDetails) null, (Map) null, 6, (Object) null);
        }

        @JvmStatic
        public final PaymentMethodCreateParams create(Fpx fpx, PaymentMethod.BillingDetails billingDetails) {
            Intrinsics.checkNotNullParameter(fpx, "fpx");
            return create$default(this, fpx, billingDetails, (Map) null, 4, (Object) null);
        }

        @JvmStatic
        public final PaymentMethodCreateParams create(Ideal ideal) {
            Intrinsics.checkNotNullParameter(ideal, "ideal");
            return create$default(this, ideal, (PaymentMethod.BillingDetails) null, (Map) null, 6, (Object) null);
        }

        @JvmStatic
        public final PaymentMethodCreateParams create(Ideal ideal, PaymentMethod.BillingDetails billingDetails) {
            Intrinsics.checkNotNullParameter(ideal, "ideal");
            return create$default(this, ideal, billingDetails, (Map) null, 4, (Object) null);
        }

        @JvmStatic
        public final PaymentMethodCreateParams create(Netbanking netbanking) {
            Intrinsics.checkNotNullParameter(netbanking, "netbanking");
            return create$default(this, netbanking, (PaymentMethod.BillingDetails) null, (Map) null, 6, (Object) null);
        }

        @JvmStatic
        public final PaymentMethodCreateParams create(Netbanking netbanking, PaymentMethod.BillingDetails billingDetails) {
            Intrinsics.checkNotNullParameter(netbanking, "netbanking");
            return create$default(this, netbanking, billingDetails, (Map) null, 4, (Object) null);
        }

        @JvmStatic
        public final PaymentMethodCreateParams create(SepaDebit sepaDebit) {
            Intrinsics.checkNotNullParameter(sepaDebit, "sepaDebit");
            return create$default(this, sepaDebit, (PaymentMethod.BillingDetails) null, (Map) null, 6, (Object) null);
        }

        @JvmStatic
        public final PaymentMethodCreateParams create(SepaDebit sepaDebit, PaymentMethod.BillingDetails billingDetails) {
            Intrinsics.checkNotNullParameter(sepaDebit, "sepaDebit");
            return create$default(this, sepaDebit, billingDetails, (Map) null, 4, (Object) null);
        }

        @JvmStatic
        public final PaymentMethodCreateParams create(Sofort sofort) {
            Intrinsics.checkNotNullParameter(sofort, "sofort");
            return create$default(this, sofort, (PaymentMethod.BillingDetails) null, (Map) null, 6, (Object) null);
        }

        @JvmStatic
        public final PaymentMethodCreateParams create(Sofort sofort, PaymentMethod.BillingDetails billingDetails) {
            Intrinsics.checkNotNullParameter(sofort, "sofort");
            return create$default(this, sofort, billingDetails, (Map) null, 4, (Object) null);
        }

        @JvmStatic
        public final PaymentMethodCreateParams create(USBankAccount uSBankAccount) {
            Intrinsics.checkNotNullParameter(uSBankAccount, "usBankAccount");
            return create$default(this, uSBankAccount, (PaymentMethod.BillingDetails) null, (Map) null, 6, (Object) null);
        }

        @JvmStatic
        public final PaymentMethodCreateParams create(USBankAccount uSBankAccount, PaymentMethod.BillingDetails billingDetails) {
            Intrinsics.checkNotNullParameter(uSBankAccount, "usBankAccount");
            return create$default(this, uSBankAccount, billingDetails, (Map) null, 4, (Object) null);
        }

        @JvmStatic
        public final PaymentMethodCreateParams create(Upi upi) {
            Intrinsics.checkNotNullParameter(upi, "upi");
            return create$default(this, upi, (PaymentMethod.BillingDetails) null, (Map) null, 6, (Object) null);
        }

        @JvmStatic
        public final PaymentMethodCreateParams create(Upi upi, PaymentMethod.BillingDetails billingDetails) {
            Intrinsics.checkNotNullParameter(upi, "upi");
            return create$default(this, upi, billingDetails, (Map) null, 4, (Object) null);
        }

        @JvmStatic
        public final PaymentMethodCreateParams createAffirm() {
            return createAffirm$default(this, (PaymentMethod.BillingDetails) null, (Map) null, 3, (Object) null);
        }

        @JvmStatic
        public final PaymentMethodCreateParams createAffirm(PaymentMethod.BillingDetails billingDetails) {
            return createAffirm$default(this, billingDetails, (Map) null, 2, (Object) null);
        }

        @JvmStatic
        public final PaymentMethodCreateParams createAfterpayClearpay() {
            return createAfterpayClearpay$default(this, (PaymentMethod.BillingDetails) null, (Map) null, 3, (Object) null);
        }

        @JvmStatic
        public final PaymentMethodCreateParams createAfterpayClearpay(PaymentMethod.BillingDetails billingDetails) {
            return createAfterpayClearpay$default(this, billingDetails, (Map) null, 2, (Object) null);
        }

        @JvmStatic
        public final PaymentMethodCreateParams createAlipay() {
            return createAlipay$default(this, (Map) null, 1, (Object) null);
        }

        @JvmStatic
        public final PaymentMethodCreateParams createBancontact(PaymentMethod.BillingDetails billingDetails) {
            Intrinsics.checkNotNullParameter(billingDetails, "billingDetails");
            return createBancontact$default(this, billingDetails, (Map) null, 2, (Object) null);
        }

        @JvmStatic
        public final PaymentMethodCreateParams createBlik() {
            return createBlik$default(this, (PaymentMethod.BillingDetails) null, (Map) null, 3, (Object) null);
        }

        @JvmStatic
        public final PaymentMethodCreateParams createBlik(PaymentMethod.BillingDetails billingDetails) {
            return createBlik$default(this, billingDetails, (Map) null, 2, (Object) null);
        }

        @JvmStatic
        public final PaymentMethodCreateParams createEps(PaymentMethod.BillingDetails billingDetails) {
            Intrinsics.checkNotNullParameter(billingDetails, "billingDetails");
            return createEps$default(this, billingDetails, (Map) null, 2, (Object) null);
        }

        @JvmStatic
        public final PaymentMethodCreateParams createGiropay(PaymentMethod.BillingDetails billingDetails) {
            Intrinsics.checkNotNullParameter(billingDetails, "billingDetails");
            return createGiropay$default(this, billingDetails, (Map) null, 2, (Object) null);
        }

        @JvmStatic
        public final PaymentMethodCreateParams createGrabPay(PaymentMethod.BillingDetails billingDetails) {
            Intrinsics.checkNotNullParameter(billingDetails, "billingDetails");
            return createGrabPay$default(this, billingDetails, (Map) null, 2, (Object) null);
        }

        @JvmStatic
        public final PaymentMethodCreateParams createKlarna() {
            return createKlarna$default(this, (PaymentMethod.BillingDetails) null, (Map) null, 3, (Object) null);
        }

        @JvmStatic
        public final PaymentMethodCreateParams createKlarna(PaymentMethod.BillingDetails billingDetails) {
            return createKlarna$default(this, billingDetails, (Map) null, 2, (Object) null);
        }

        @JvmStatic
        public final PaymentMethodCreateParams createOxxo(PaymentMethod.BillingDetails billingDetails) {
            Intrinsics.checkNotNullParameter(billingDetails, "billingDetails");
            return createOxxo$default(this, billingDetails, (Map) null, 2, (Object) null);
        }

        @JvmStatic
        public final PaymentMethodCreateParams createP24(PaymentMethod.BillingDetails billingDetails) {
            Intrinsics.checkNotNullParameter(billingDetails, "billingDetails");
            return createP24$default(this, billingDetails, (Map) null, 2, (Object) null);
        }

        @JvmStatic
        public final PaymentMethodCreateParams createPayPal() {
            return createPayPal$default(this, (Map) null, 1, (Object) null);
        }

        @JvmStatic
        public final PaymentMethodCreateParams createUSBankAccount() {
            return createUSBankAccount$default(this, (PaymentMethod.BillingDetails) null, (Map) null, 3, (Object) null);
        }

        @JvmStatic
        public final PaymentMethodCreateParams createUSBankAccount(PaymentMethod.BillingDetails billingDetails) {
            return createUSBankAccount$default(this, billingDetails, (Map) null, 2, (Object) null);
        }

        @JvmStatic
        public final PaymentMethodCreateParams createWeChatPay() {
            return createWeChatPay$default(this, (PaymentMethod.BillingDetails) null, (Map) null, 3, (Object) null);
        }

        @JvmStatic
        public final PaymentMethodCreateParams createWeChatPay(PaymentMethod.BillingDetails billingDetails) {
            return createWeChatPay$default(this, billingDetails, (Map) null, 2, (Object) null);
        }

        private Companion() {
        }

        @JvmStatic
        public final PaymentMethodCreateParams createCard(CardParams cardParams) {
            Intrinsics.checkNotNullParameter(cardParams, "cardParams");
            return create(new Card(cardParams.getNumber$payments_core_release(), Integer.valueOf(cardParams.getExpMonth$payments_core_release()), Integer.valueOf(cardParams.getExpYear$payments_core_release()), cardParams.getCvc$payments_core_release(), (String) null, cardParams.getAttribution(), 16, (DefaultConstructorMarker) null), new PaymentMethod.BillingDetails(cardParams.getAddress(), (String) null, cardParams.getName(), (String) null, 10, (DefaultConstructorMarker) null), cardParams.getMetadata());
        }

        public static /* synthetic */ PaymentMethodCreateParams create$default(Companion companion, Card card, PaymentMethod.BillingDetails billingDetails, Map map, int i, Object obj) {
            if ((i & 2) != 0) {
                billingDetails = null;
            }
            if ((i & 4) != 0) {
                map = null;
            }
            return companion.create(card, billingDetails, (Map<String, String>) map);
        }

        @JvmStatic
        public final PaymentMethodCreateParams create(Card card, PaymentMethod.BillingDetails billingDetails, Map<String, String> map) {
            Intrinsics.checkNotNullParameter(card, "card");
            return new PaymentMethodCreateParams(card, billingDetails, (Map) map, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ PaymentMethodCreateParams create$default(Companion companion, Ideal ideal, PaymentMethod.BillingDetails billingDetails, Map map, int i, Object obj) {
            if ((i & 2) != 0) {
                billingDetails = null;
            }
            if ((i & 4) != 0) {
                map = null;
            }
            return companion.create(ideal, billingDetails, (Map<String, String>) map);
        }

        @JvmStatic
        public final PaymentMethodCreateParams create(Ideal ideal, PaymentMethod.BillingDetails billingDetails, Map<String, String> map) {
            Intrinsics.checkNotNullParameter(ideal, "ideal");
            return new PaymentMethodCreateParams(ideal, billingDetails, (Map) map, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ PaymentMethodCreateParams create$default(Companion companion, Fpx fpx, PaymentMethod.BillingDetails billingDetails, Map map, int i, Object obj) {
            if ((i & 2) != 0) {
                billingDetails = null;
            }
            if ((i & 4) != 0) {
                map = null;
            }
            return companion.create(fpx, billingDetails, (Map<String, String>) map);
        }

        @JvmStatic
        public final PaymentMethodCreateParams create(Fpx fpx, PaymentMethod.BillingDetails billingDetails, Map<String, String> map) {
            Intrinsics.checkNotNullParameter(fpx, "fpx");
            return new PaymentMethodCreateParams(fpx, billingDetails, (Map) map, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ PaymentMethodCreateParams create$default(Companion companion, SepaDebit sepaDebit, PaymentMethod.BillingDetails billingDetails, Map map, int i, Object obj) {
            if ((i & 2) != 0) {
                billingDetails = null;
            }
            if ((i & 4) != 0) {
                map = null;
            }
            return companion.create(sepaDebit, billingDetails, (Map<String, String>) map);
        }

        @JvmStatic
        public final PaymentMethodCreateParams create(SepaDebit sepaDebit, PaymentMethod.BillingDetails billingDetails, Map<String, String> map) {
            Intrinsics.checkNotNullParameter(sepaDebit, "sepaDebit");
            return new PaymentMethodCreateParams(sepaDebit, billingDetails, (Map) map, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ PaymentMethodCreateParams create$default(Companion companion, AuBecsDebit auBecsDebit, PaymentMethod.BillingDetails billingDetails, Map map, int i, Object obj) {
            if ((i & 4) != 0) {
                map = null;
            }
            return companion.create(auBecsDebit, billingDetails, (Map<String, String>) map);
        }

        @JvmStatic
        public final PaymentMethodCreateParams create(AuBecsDebit auBecsDebit, PaymentMethod.BillingDetails billingDetails, Map<String, String> map) {
            Intrinsics.checkNotNullParameter(auBecsDebit, "auBecsDebit");
            Intrinsics.checkNotNullParameter(billingDetails, "billingDetails");
            return new PaymentMethodCreateParams(auBecsDebit, billingDetails, (Map) map, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ PaymentMethodCreateParams create$default(Companion companion, BacsDebit bacsDebit, PaymentMethod.BillingDetails billingDetails, Map map, int i, Object obj) {
            if ((i & 4) != 0) {
                map = null;
            }
            return companion.create(bacsDebit, billingDetails, (Map<String, String>) map);
        }

        @JvmStatic
        public final PaymentMethodCreateParams create(BacsDebit bacsDebit, PaymentMethod.BillingDetails billingDetails, Map<String, String> map) {
            Intrinsics.checkNotNullParameter(bacsDebit, "bacsDebit");
            Intrinsics.checkNotNullParameter(billingDetails, "billingDetails");
            return new PaymentMethodCreateParams(bacsDebit, billingDetails, (Map) map, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ PaymentMethodCreateParams create$default(Companion companion, Sofort sofort, PaymentMethod.BillingDetails billingDetails, Map map, int i, Object obj) {
            if ((i & 2) != 0) {
                billingDetails = null;
            }
            if ((i & 4) != 0) {
                map = null;
            }
            return companion.create(sofort, billingDetails, (Map<String, String>) map);
        }

        @JvmStatic
        public final PaymentMethodCreateParams create(Sofort sofort, PaymentMethod.BillingDetails billingDetails, Map<String, String> map) {
            Intrinsics.checkNotNullParameter(sofort, "sofort");
            return new PaymentMethodCreateParams(sofort, billingDetails, (Map) map, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ PaymentMethodCreateParams create$default(Companion companion, Upi upi, PaymentMethod.BillingDetails billingDetails, Map map, int i, Object obj) {
            if ((i & 2) != 0) {
                billingDetails = null;
            }
            if ((i & 4) != 0) {
                map = null;
            }
            return companion.create(upi, billingDetails, (Map<String, String>) map);
        }

        @JvmStatic
        public final PaymentMethodCreateParams create(Upi upi, PaymentMethod.BillingDetails billingDetails, Map<String, String> map) {
            Intrinsics.checkNotNullParameter(upi, "upi");
            return new PaymentMethodCreateParams(upi, billingDetails, (Map) map, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ PaymentMethodCreateParams create$default(Companion companion, USBankAccount uSBankAccount, PaymentMethod.BillingDetails billingDetails, Map map, int i, Object obj) {
            if ((i & 2) != 0) {
                billingDetails = null;
            }
            if ((i & 4) != 0) {
                map = null;
            }
            return companion.create(uSBankAccount, billingDetails, (Map<String, String>) map);
        }

        @JvmStatic
        public final PaymentMethodCreateParams create(USBankAccount uSBankAccount, PaymentMethod.BillingDetails billingDetails, Map<String, String> map) {
            Intrinsics.checkNotNullParameter(uSBankAccount, "usBankAccount");
            return new PaymentMethodCreateParams(uSBankAccount, billingDetails, (Map) map, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ PaymentMethodCreateParams create$default(Companion companion, Netbanking netbanking, PaymentMethod.BillingDetails billingDetails, Map map, int i, Object obj) {
            if ((i & 2) != 0) {
                billingDetails = null;
            }
            if ((i & 4) != 0) {
                map = null;
            }
            return companion.create(netbanking, billingDetails, (Map<String, String>) map);
        }

        @JvmStatic
        public final PaymentMethodCreateParams create(Netbanking netbanking, PaymentMethod.BillingDetails billingDetails, Map<String, String> map) {
            Intrinsics.checkNotNullParameter(netbanking, "netbanking");
            return new PaymentMethodCreateParams(netbanking, billingDetails, (Map) map, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ PaymentMethodCreateParams createP24$default(Companion companion, PaymentMethod.BillingDetails billingDetails, Map map, int i, Object obj) {
            if ((i & 2) != 0) {
                map = null;
            }
            return companion.createP24(billingDetails, map);
        }

        @JvmStatic
        public final PaymentMethodCreateParams createP24(PaymentMethod.BillingDetails billingDetails, Map<String, String> map) {
            Intrinsics.checkNotNullParameter(billingDetails, "billingDetails");
            return new PaymentMethodCreateParams(PaymentMethod.Type.P24, (Card) null, (Ideal) null, (Fpx) null, (SepaDebit) null, (AuBecsDebit) null, (BacsDebit) null, (Sofort) null, (Upi) null, (Netbanking) null, (USBankAccount) null, (Link) null, billingDetails, map, (Set) null, (Map) null, 53246, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ PaymentMethodCreateParams createBancontact$default(Companion companion, PaymentMethod.BillingDetails billingDetails, Map map, int i, Object obj) {
            if ((i & 2) != 0) {
                map = null;
            }
            return companion.createBancontact(billingDetails, map);
        }

        @JvmStatic
        public final PaymentMethodCreateParams createBancontact(PaymentMethod.BillingDetails billingDetails, Map<String, String> map) {
            Intrinsics.checkNotNullParameter(billingDetails, "billingDetails");
            return new PaymentMethodCreateParams(PaymentMethod.Type.Bancontact, (Card) null, (Ideal) null, (Fpx) null, (SepaDebit) null, (AuBecsDebit) null, (BacsDebit) null, (Sofort) null, (Upi) null, (Netbanking) null, (USBankAccount) null, (Link) null, billingDetails, map, (Set) null, (Map) null, 53246, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ PaymentMethodCreateParams createGiropay$default(Companion companion, PaymentMethod.BillingDetails billingDetails, Map map, int i, Object obj) {
            if ((i & 2) != 0) {
                map = null;
            }
            return companion.createGiropay(billingDetails, map);
        }

        @JvmStatic
        public final PaymentMethodCreateParams createGiropay(PaymentMethod.BillingDetails billingDetails, Map<String, String> map) {
            Intrinsics.checkNotNullParameter(billingDetails, "billingDetails");
            return new PaymentMethodCreateParams(PaymentMethod.Type.Giropay, (Card) null, (Ideal) null, (Fpx) null, (SepaDebit) null, (AuBecsDebit) null, (BacsDebit) null, (Sofort) null, (Upi) null, (Netbanking) null, (USBankAccount) null, (Link) null, billingDetails, map, (Set) null, (Map) null, 53246, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ PaymentMethodCreateParams createGrabPay$default(Companion companion, PaymentMethod.BillingDetails billingDetails, Map map, int i, Object obj) {
            if ((i & 2) != 0) {
                map = null;
            }
            return companion.createGrabPay(billingDetails, map);
        }

        @JvmStatic
        public final PaymentMethodCreateParams createGrabPay(PaymentMethod.BillingDetails billingDetails, Map<String, String> map) {
            Intrinsics.checkNotNullParameter(billingDetails, "billingDetails");
            return new PaymentMethodCreateParams(PaymentMethod.Type.GrabPay, (Card) null, (Ideal) null, (Fpx) null, (SepaDebit) null, (AuBecsDebit) null, (BacsDebit) null, (Sofort) null, (Upi) null, (Netbanking) null, (USBankAccount) null, (Link) null, billingDetails, map, (Set) null, (Map) null, 53246, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ PaymentMethodCreateParams createEps$default(Companion companion, PaymentMethod.BillingDetails billingDetails, Map map, int i, Object obj) {
            if ((i & 2) != 0) {
                map = null;
            }
            return companion.createEps(billingDetails, map);
        }

        @JvmStatic
        public final PaymentMethodCreateParams createEps(PaymentMethod.BillingDetails billingDetails, Map<String, String> map) {
            Intrinsics.checkNotNullParameter(billingDetails, "billingDetails");
            return new PaymentMethodCreateParams(PaymentMethod.Type.Eps, (Card) null, (Ideal) null, (Fpx) null, (SepaDebit) null, (AuBecsDebit) null, (BacsDebit) null, (Sofort) null, (Upi) null, (Netbanking) null, (USBankAccount) null, (Link) null, billingDetails, map, (Set) null, (Map) null, 53246, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ PaymentMethodCreateParams createOxxo$default(Companion companion, PaymentMethod.BillingDetails billingDetails, Map map, int i, Object obj) {
            if ((i & 2) != 0) {
                map = null;
            }
            return companion.createOxxo(billingDetails, map);
        }

        @JvmStatic
        public final PaymentMethodCreateParams createOxxo(PaymentMethod.BillingDetails billingDetails, Map<String, String> map) {
            Intrinsics.checkNotNullParameter(billingDetails, "billingDetails");
            return new PaymentMethodCreateParams(PaymentMethod.Type.Oxxo, (Card) null, (Ideal) null, (Fpx) null, (SepaDebit) null, (AuBecsDebit) null, (BacsDebit) null, (Sofort) null, (Upi) null, (Netbanking) null, (USBankAccount) null, (Link) null, billingDetails, map, (Set) null, (Map) null, 53246, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ PaymentMethodCreateParams createAlipay$default(Companion companion, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                map = null;
            }
            return companion.createAlipay(map);
        }

        @JvmStatic
        public final PaymentMethodCreateParams createAlipay(Map<String, String> map) {
            return new PaymentMethodCreateParams(PaymentMethod.Type.Alipay, (Card) null, (Ideal) null, (Fpx) null, (SepaDebit) null, (AuBecsDebit) null, (BacsDebit) null, (Sofort) null, (Upi) null, (Netbanking) null, (USBankAccount) null, (Link) null, (PaymentMethod.BillingDetails) null, map, (Set) null, (Map) null, 57342, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ PaymentMethodCreateParams createPayPal$default(Companion companion, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                map = null;
            }
            return companion.createPayPal(map);
        }

        @JvmStatic
        public final PaymentMethodCreateParams createPayPal(Map<String, String> map) {
            return new PaymentMethodCreateParams(PaymentMethod.Type.PayPal, (Card) null, (Ideal) null, (Fpx) null, (SepaDebit) null, (AuBecsDebit) null, (BacsDebit) null, (Sofort) null, (Upi) null, (Netbanking) null, (USBankAccount) null, (Link) null, (PaymentMethod.BillingDetails) null, map, (Set) null, (Map) null, 57342, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ PaymentMethodCreateParams createAfterpayClearpay$default(Companion companion, PaymentMethod.BillingDetails billingDetails, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                billingDetails = null;
            }
            if ((i & 2) != 0) {
                map = null;
            }
            return companion.createAfterpayClearpay(billingDetails, map);
        }

        @JvmStatic
        public final PaymentMethodCreateParams createAfterpayClearpay(PaymentMethod.BillingDetails billingDetails, Map<String, String> map) {
            return new PaymentMethodCreateParams(PaymentMethod.Type.AfterpayClearpay, (Card) null, (Ideal) null, (Fpx) null, (SepaDebit) null, (AuBecsDebit) null, (BacsDebit) null, (Sofort) null, (Upi) null, (Netbanking) null, (USBankAccount) null, (Link) null, billingDetails, map, (Set) null, (Map) null, 53246, (DefaultConstructorMarker) null);
        }

        @JvmStatic
        public final PaymentMethodCreateParams createFromGooglePay(JSONObject jSONObject) throws JSONException {
            String str;
            Card card;
            TokenizationMethod tokenizationMethod;
            Intrinsics.checkNotNullParameter(jSONObject, "googlePayPaymentData");
            GooglePayResult fromJson = GooglePayResult.Companion.fromJson(jSONObject);
            Token token = fromJson.getToken();
            String str2 = null;
            if (token == null) {
                str = null;
            } else {
                str = token.getId();
            }
            if (str == null) {
                str = "";
            }
            String str3 = str;
            if (!(token == null || (card = token.getCard()) == null || (tokenizationMethod = card.getTokenizationMethod()) == null)) {
                str2 = tokenizationMethod.toString();
            }
            return create$default(this, new Card((String) null, (Integer) null, (Integer) null, (String) null, str3, SetsKt.setOfNotNull(str2), 15, (DefaultConstructorMarker) null), new PaymentMethod.BillingDetails(fromJson.getAddress(), fromJson.getEmail(), fromJson.getName(), fromJson.getPhoneNumber()), (Map) null, 4, (Object) null);
        }

        public static /* synthetic */ PaymentMethodCreateParams createBlik$default(Companion companion, PaymentMethod.BillingDetails billingDetails, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                billingDetails = null;
            }
            if ((i & 2) != 0) {
                map = null;
            }
            return companion.createBlik(billingDetails, map);
        }

        @JvmStatic
        public final PaymentMethodCreateParams createBlik(PaymentMethod.BillingDetails billingDetails, Map<String, String> map) {
            return new PaymentMethodCreateParams(PaymentMethod.Type.Blik, (Card) null, (Ideal) null, (Fpx) null, (SepaDebit) null, (AuBecsDebit) null, (BacsDebit) null, (Sofort) null, (Upi) null, (Netbanking) null, (USBankAccount) null, (Link) null, billingDetails, map, (Set) null, (Map) null, 53246, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ PaymentMethodCreateParams createWeChatPay$default(Companion companion, PaymentMethod.BillingDetails billingDetails, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                billingDetails = null;
            }
            if ((i & 2) != 0) {
                map = null;
            }
            return companion.createWeChatPay(billingDetails, map);
        }

        @JvmStatic
        public final PaymentMethodCreateParams createWeChatPay(PaymentMethod.BillingDetails billingDetails, Map<String, String> map) {
            return new PaymentMethodCreateParams(PaymentMethod.Type.WeChatPay, (Card) null, (Ideal) null, (Fpx) null, (SepaDebit) null, (AuBecsDebit) null, (BacsDebit) null, (Sofort) null, (Upi) null, (Netbanking) null, (USBankAccount) null, (Link) null, billingDetails, map, (Set) null, (Map) null, 53246, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ PaymentMethodCreateParams createKlarna$default(Companion companion, PaymentMethod.BillingDetails billingDetails, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                billingDetails = null;
            }
            if ((i & 2) != 0) {
                map = null;
            }
            return companion.createKlarna(billingDetails, map);
        }

        @JvmStatic
        public final PaymentMethodCreateParams createKlarna(PaymentMethod.BillingDetails billingDetails, Map<String, String> map) {
            return new PaymentMethodCreateParams(PaymentMethod.Type.Klarna, (Card) null, (Ideal) null, (Fpx) null, (SepaDebit) null, (AuBecsDebit) null, (BacsDebit) null, (Sofort) null, (Upi) null, (Netbanking) null, (USBankAccount) null, (Link) null, billingDetails, map, (Set) null, (Map) null, 53246, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ PaymentMethodCreateParams createAffirm$default(Companion companion, PaymentMethod.BillingDetails billingDetails, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                billingDetails = null;
            }
            if ((i & 2) != 0) {
                map = null;
            }
            return companion.createAffirm(billingDetails, map);
        }

        @JvmStatic
        public final PaymentMethodCreateParams createAffirm(PaymentMethod.BillingDetails billingDetails, Map<String, String> map) {
            return new PaymentMethodCreateParams(PaymentMethod.Type.Affirm, (Card) null, (Ideal) null, (Fpx) null, (SepaDebit) null, (AuBecsDebit) null, (BacsDebit) null, (Sofort) null, (Upi) null, (Netbanking) null, (USBankAccount) null, (Link) null, billingDetails, map, (Set) null, (Map) null, 53246, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ PaymentMethodCreateParams createUSBankAccount$default(Companion companion, PaymentMethod.BillingDetails billingDetails, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                billingDetails = null;
            }
            if ((i & 2) != 0) {
                map = null;
            }
            return companion.createUSBankAccount(billingDetails, map);
        }

        @JvmStatic
        public final PaymentMethodCreateParams createUSBankAccount(PaymentMethod.BillingDetails billingDetails, Map<String, String> map) {
            return new PaymentMethodCreateParams(PaymentMethod.Type.USBankAccount, (Card) null, (Ideal) null, (Fpx) null, (SepaDebit) null, (AuBecsDebit) null, (BacsDebit) null, (Sofort) null, (Upi) null, (Netbanking) null, (USBankAccount) null, (Link) null, billingDetails, map, (Set) null, (Map) null, 53246, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ PaymentMethodCreateParams createLink$default(Companion companion, String str, String str2, Map map, int i, Object obj) {
            if ((i & 4) != 0) {
                map = null;
            }
            return companion.createLink(str, str2, map);
        }

        public final PaymentMethodCreateParams createLink(String str, String str2, Map<String, ? extends Map<String, String>> map) {
            String str3 = str;
            String str4 = str2;
            Intrinsics.checkNotNullParameter(str3, "paymentDetailsId");
            Intrinsics.checkNotNullParameter(str4, "consumerSessionClientSecret");
            PaymentMethod.Type type = PaymentMethod.Type.Link;
            Link link = r5;
            Link link2 = new Link(str3, str4, map);
            return new PaymentMethodCreateParams(type, (Card) null, (Ideal) null, (Fpx) null, (SepaDebit) null, (AuBecsDebit) null, (BacsDebit) null, (Sofort) null, (Upi) null, (Netbanking) null, (USBankAccount) null, link, (PaymentMethod.BillingDetails) null, (Map) null, (Set) null, (Map) null, 63486, (DefaultConstructorMarker) null);
        }

        public final PaymentMethodCreateParams createWithOverride(PaymentMethod.Type type, Map<String, ? extends Object> map, Set<String> set) {
            Set<String> set2 = set;
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(set, NamedConstantsKt.PRODUCT_USAGE);
            return new PaymentMethodCreateParams(type, (Card) null, (Ideal) null, (Fpx) null, (SepaDebit) null, (AuBecsDebit) null, (BacsDebit) null, (Sofort) null, (Upi) null, (Netbanking) null, (USBankAccount) null, (Link) null, (PaymentMethod.BillingDetails) null, (Map) null, set2, map, 16382, (DefaultConstructorMarker) null);
        }
    }
}
