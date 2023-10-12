package com.stripe.android.paymentsheet.forms;

import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003\"\u0014\u0010\u0006\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0003\"\u0014\u0010\b\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0003\"\u0014\u0010\n\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0003\"\u0014\u0010\f\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0003\"\u0014\u0010\u000e\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0003\"\u0014\u0010\u0010\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0003\"\u0014\u0010\u0012\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0003\"\u0014\u0010\u0014\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0003\"\u0014\u0010\u0016\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0003\"\u0014\u0010\u0018\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0003\"\u0014\u0010\u001a\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0003¨\u0006\u001c"}, d2 = {"AffirmRequirement", "Lcom/stripe/android/paymentsheet/forms/PaymentMethodRequirements;", "getAffirmRequirement", "()Lcom/stripe/android/paymentsheet/forms/PaymentMethodRequirements;", "AfterpayClearpayRequirement", "getAfterpayClearpayRequirement", "AuBecsDebitRequirement", "getAuBecsDebitRequirement", "BancontactRequirement", "getBancontactRequirement", "CardRequirement", "getCardRequirement", "EpsRequirement", "getEpsRequirement", "GiropayRequirement", "getGiropayRequirement", "IdealRequirement", "getIdealRequirement", "KlarnaRequirement", "getKlarnaRequirement", "P24Requirement", "getP24Requirement", "PaypalRequirement", "getPaypalRequirement", "SepaDebitRequirement", "getSepaDebitRequirement", "SofortRequirement", "getSofortRequirement", "paymentsheet_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentMethodRequirements.kt */
public final class PaymentMethodRequirementsKt {
    private static final PaymentMethodRequirements AffirmRequirement = new PaymentMethodRequirements(SetsKt.setOf(ShippingAddress.INSTANCE), (Set<? extends SIRequirement>) null, (Boolean) null);
    private static final PaymentMethodRequirements AfterpayClearpayRequirement = new PaymentMethodRequirements(SetsKt.setOf(ShippingAddress.INSTANCE), (Set<? extends SIRequirement>) null, (Boolean) null);
    private static final PaymentMethodRequirements AuBecsDebitRequirement = new PaymentMethodRequirements(SetsKt.setOf(Delayed.INSTANCE), (Set<? extends SIRequirement>) null, (Boolean) null);
    private static final PaymentMethodRequirements BancontactRequirement = new PaymentMethodRequirements(SetsKt.emptySet(), (Set<? extends SIRequirement>) null, false);
    private static final PaymentMethodRequirements CardRequirement = new PaymentMethodRequirements(SetsKt.emptySet(), SetsKt.emptySet(), true);
    private static final PaymentMethodRequirements EpsRequirement = new PaymentMethodRequirements(SetsKt.emptySet(), (Set<? extends SIRequirement>) null, (Boolean) null);
    private static final PaymentMethodRequirements GiropayRequirement = new PaymentMethodRequirements(SetsKt.emptySet(), (Set<? extends SIRequirement>) null, (Boolean) null);
    private static final PaymentMethodRequirements IdealRequirement = new PaymentMethodRequirements(SetsKt.emptySet(), (Set<? extends SIRequirement>) null, false);
    private static final PaymentMethodRequirements KlarnaRequirement = new PaymentMethodRequirements(SetsKt.emptySet(), (Set<? extends SIRequirement>) null, (Boolean) null);
    private static final PaymentMethodRequirements P24Requirement = new PaymentMethodRequirements(SetsKt.emptySet(), (Set<? extends SIRequirement>) null, (Boolean) null);
    private static final PaymentMethodRequirements PaypalRequirement = new PaymentMethodRequirements(SetsKt.emptySet(), (Set<? extends SIRequirement>) null, (Boolean) null);
    private static final PaymentMethodRequirements SepaDebitRequirement = new PaymentMethodRequirements(SetsKt.setOf(Delayed.INSTANCE), (Set<? extends SIRequirement>) null, false);
    private static final PaymentMethodRequirements SofortRequirement = new PaymentMethodRequirements(SetsKt.setOf(Delayed.INSTANCE), (Set<? extends SIRequirement>) null, false);

    public static final PaymentMethodRequirements getCardRequirement() {
        return CardRequirement;
    }

    public static final PaymentMethodRequirements getBancontactRequirement() {
        return BancontactRequirement;
    }

    public static final PaymentMethodRequirements getSofortRequirement() {
        return SofortRequirement;
    }

    public static final PaymentMethodRequirements getIdealRequirement() {
        return IdealRequirement;
    }

    public static final PaymentMethodRequirements getSepaDebitRequirement() {
        return SepaDebitRequirement;
    }

    public static final PaymentMethodRequirements getEpsRequirement() {
        return EpsRequirement;
    }

    public static final PaymentMethodRequirements getP24Requirement() {
        return P24Requirement;
    }

    public static final PaymentMethodRequirements getGiropayRequirement() {
        return GiropayRequirement;
    }

    public static final PaymentMethodRequirements getAfterpayClearpayRequirement() {
        return AfterpayClearpayRequirement;
    }

    public static final PaymentMethodRequirements getKlarnaRequirement() {
        return KlarnaRequirement;
    }

    public static final PaymentMethodRequirements getPaypalRequirement() {
        return PaypalRequirement;
    }

    public static final PaymentMethodRequirements getAffirmRequirement() {
        return AffirmRequirement;
    }

    public static final PaymentMethodRequirements getAuBecsDebitRequirement() {
        return AuBecsDebitRequirement;
    }
}
