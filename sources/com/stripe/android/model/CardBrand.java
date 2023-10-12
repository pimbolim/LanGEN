package com.stripe.android.model;

import com.braintreepayments.api.models.BinData;
import com.drew.metadata.iptc.IptcDirectory;
import com.stripe.payments.model.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0001\u0018\u0000 .2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001.B\u0001\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0003\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0003\u0010\b\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\u000f\u0012\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00060\u000f¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0003H\u0007J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001e\u001a\u00020\u0003H\u0002J\u0010\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0003J\u0010\u0010#\u001a\u00020!2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0003J\u000e\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u000b\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0011\u0010\u001b\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0015R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\u000fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00060\u000fX\u0004¢\u0006\u0002\n\u0000j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-¨\u0006/"}, d2 = {"Lcom/stripe/android/model/CardBrand;", "", "code", "", "displayName", "icon", "", "cvcIcon", "errorIcon", "cvcLength", "", "defaultMaxLength", "pattern", "Ljava/util/regex/Pattern;", "partialPatterns", "", "variantMaxLength", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;IIILjava/util/Set;ILjava/util/regex/Pattern;Ljava/util/Map;Ljava/util/Map;)V", "getCode", "()Ljava/lang/String;", "getCvcIcon", "()I", "getCvcLength", "()Ljava/util/Set;", "getDisplayName", "getErrorIcon", "getIcon", "maxCvcLength", "getMaxCvcLength", "getMaxLengthForCardNumber", "cardNumber", "getPatternForLength", "isMaxCvc", "", "cvcText", "isValidCardNumberLength", "isValidCvc", "cvc", "AmericanExpress", "Discover", "JCB", "DinersClub", "Visa", "MasterCard", "UnionPay", "Unknown", "Companion", "payments-model_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CardBrand.kt */
public enum CardBrand {
    AmericanExpress("amex", "American Express", R.drawable.stripe_ic_amex, R.drawable.stripe_ic_cvc_amex, 0, SetsKt.setOf(3, 4), 15, Pattern.compile("^(34|37)[0-9]*$"), MapsKt.mapOf(TuplesKt.to(1, Pattern.compile("^3$"))), (Pattern) null, 528, (Map) null),
    Discover("discover", "Discover", R.drawable.stripe_ic_discover, 0, 0, (int) null, 0, Pattern.compile("^(60|64|65)[0-9]*$"), MapsKt.mapOf(TuplesKt.to(1, Pattern.compile("^6$"))), (Pattern) null, IptcDirectory.TAG_CAPTION, (Map) null),
    JCB("jcb", "JCB", R.drawable.stripe_ic_jcb, 0, 0, (int) null, 0, Pattern.compile("^(352[89]|35[3-8][0-9])[0-9]*$"), MapsKt.mapOf(TuplesKt.to(1, Pattern.compile("^3$")), TuplesKt.to(2, Pattern.compile("^(35)$")), TuplesKt.to(3, Pattern.compile("^(35[2-8])$"))), (Pattern) null, IptcDirectory.TAG_CAPTION, (Map) null),
    DinersClub("diners", "Diners Club", R.drawable.stripe_ic_diners, 0, 0, (int) null, 16, Pattern.compile("^(36|30|38|39)[0-9]*$"), MapsKt.mapOf(TuplesKt.to(1, Pattern.compile("^3$"))), MapsKt.mapOf(TuplesKt.to(Pattern.compile("^(36)[0-9]*$"), 14)), 56, (Map) null),
    Visa("visa", "Visa", R.drawable.stripe_ic_visa, 0, 0, (int) null, 0, Pattern.compile("^(4)[0-9]*$"), MapsKt.mapOf(TuplesKt.to(1, Pattern.compile("^4$"))), (Pattern) null, IptcDirectory.TAG_CAPTION, (Map) null),
    MasterCard("mastercard", "Mastercard", R.drawable.stripe_ic_mastercard, 0, 0, (int) null, 0, Pattern.compile("^(2221|2222|2223|2224|2225|2226|2227|2228|2229|222|223|224|225|226|227|228|229|23|24|25|26|270|271|2720|50|51|52|53|54|55|56|57|58|59|67)[0-9]*$"), MapsKt.mapOf(TuplesKt.to(1, Pattern.compile("^2|5|6$")), TuplesKt.to(2, Pattern.compile("^(22|23|24|25|26|27|50|51|52|53|54|55|56|57|58|59|67)$"))), (Pattern) null, IptcDirectory.TAG_CAPTION, (Map) null),
    UnionPay("unionpay", "UnionPay", R.drawable.stripe_ic_unionpay, 0, 0, (int) null, 0, Pattern.compile("^(62|81)[0-9]*$"), MapsKt.mapOf(TuplesKt.to(1, Pattern.compile("^6|8$"))), (Pattern) null, IptcDirectory.TAG_CAPTION, (Map) null),
    Unknown("unknown", BinData.UNKNOWN, R.drawable.stripe_ic_unknown, 0, 0, SetsKt.setOf(3, 4), 0, (Set) null, MapsKt.emptyMap(), (Pattern) null, 728, (Map) null);
    
    private static final int CVC_COMMON_LENGTH = 3;
    public static final Companion Companion = null;
    private final String code;
    private final int cvcIcon;
    private final Set<Integer> cvcLength;
    private final int defaultMaxLength;
    private final String displayName;
    private final int errorIcon;
    private final int icon;
    private final Map<Integer, Pattern> partialPatterns;
    private final Pattern pattern;
    private final Map<Pattern, Integer> variantMaxLength;

    private CardBrand(String str, String str2, int i, int i2, int i3, Set<Integer> set, int i4, Pattern pattern2, Map<Integer, Pattern> map, Map<Pattern, Integer> map2) {
        this.code = str;
        this.displayName = str2;
        this.icon = i;
        this.cvcIcon = i2;
        this.errorIcon = i3;
        this.cvcLength = set;
        this.defaultMaxLength = i4;
        this.pattern = pattern2;
        this.partialPatterns = map;
        this.variantMaxLength = map2;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final int getIcon() {
        return this.icon;
    }

    public final int getCvcIcon() {
        return this.cvcIcon;
    }

    public final int getErrorIcon() {
        return this.errorIcon;
    }

    public final Set<Integer> getCvcLength() {
        return this.cvcLength;
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    public final int getMaxCvcLength() {
        Integer num = (Integer) CollectionsKt.maxOrNull(this.cvcLength);
        if (num == null) {
            return 3;
        }
        return num.intValue();
    }

    public final boolean isValidCardNumberLength(String str) {
        return (str == null || Unknown == this || str.length() != getMaxLengthForCardNumber(str)) ? false : true;
    }

    public final boolean isValidCvc(String str) {
        Intrinsics.checkNotNullParameter(str, "cvc");
        return this.cvcLength.contains(Integer.valueOf(str.length()));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0005, code lost:
        r3 = kotlin.text.StringsKt.trim((java.lang.CharSequence) r3).toString();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isMaxCvc(java.lang.String r3) {
        /*
            r2 = this;
            r0 = 0
            if (r3 != 0) goto L_0x0005
        L_0x0003:
            r3 = 0
            goto L_0x0016
        L_0x0005:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            java.lang.CharSequence r3 = kotlin.text.StringsKt.trim((java.lang.CharSequence) r3)
            java.lang.String r3 = r3.toString()
            if (r3 != 0) goto L_0x0012
            goto L_0x0003
        L_0x0012:
            int r3 = r3.length()
        L_0x0016:
            int r1 = r2.getMaxCvcLength()
            if (r1 != r3) goto L_0x001d
            r0 = 1
        L_0x001d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.model.CardBrand.isMaxCvc(java.lang.String):boolean");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.Integer} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int getMaxLengthForCardNumber(java.lang.String r6) {
        /*
            r5 = this;
            java.lang.String r0 = "cardNumber"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            com.stripe.android.cards.CardNumber$Unvalidated r0 = new com.stripe.android.cards.CardNumber$Unvalidated
            r0.<init>(r6)
            java.lang.String r6 = r0.getNormalized()
            java.util.Map<java.util.regex.Pattern, java.lang.Integer> r0 = r5.variantMaxLength
            java.util.Set r0 = r0.entrySet()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x001a:
            boolean r1 = r0.hasNext()
            r2 = 0
            if (r1 == 0) goto L_0x003c
            java.lang.Object r1 = r0.next()
            r3 = r1
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r3 = r3.getKey()
            java.util.regex.Pattern r3 = (java.util.regex.Pattern) r3
            r4 = r6
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            java.util.regex.Matcher r3 = r3.matcher(r4)
            boolean r3 = r3.matches()
            if (r3 == 0) goto L_0x001a
            goto L_0x003d
        L_0x003c:
            r1 = r2
        L_0x003d:
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            if (r1 != 0) goto L_0x0042
            goto L_0x0049
        L_0x0042:
            java.lang.Object r6 = r1.getValue()
            r2 = r6
            java.lang.Integer r2 = (java.lang.Integer) r2
        L_0x0049:
            if (r2 != 0) goto L_0x004e
            int r6 = r5.defaultMaxLength
            goto L_0x0052
        L_0x004e:
            int r6 = r2.intValue()
        L_0x0052:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.model.CardBrand.getMaxLengthForCardNumber(java.lang.String):int");
    }

    /* access modifiers changed from: private */
    public final Pattern getPatternForLength(String str) {
        Pattern pattern2 = this.partialPatterns.get(Integer.valueOf(str.length()));
        return pattern2 == null ? this.pattern : pattern2;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J\u0010\u0010\t\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\bJ\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\f2\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/stripe/android/model/CardBrand$Companion;", "", "()V", "CVC_COMMON_LENGTH", "", "fromCardNumber", "Lcom/stripe/android/model/CardBrand;", "cardNumber", "", "fromCode", "code", "getCardBrands", "", "getMatchingCards", "payments-model_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CardBrand.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CardBrand fromCardNumber(String str) {
            CharSequence charSequence = str;
            boolean z = false;
            if (charSequence == null || StringsKt.isBlank(charSequence)) {
                return CardBrand.Unknown;
            }
            List<CardBrand> matchingCards = getMatchingCards(str);
            if (matchingCards.size() == 1) {
                z = true;
            }
            if (!z) {
                matchingCards = null;
            }
            if (matchingCards == null) {
                matchingCards = CollectionsKt.listOf(CardBrand.Unknown);
            }
            return (CardBrand) CollectionsKt.first(matchingCards);
        }

        public final List<CardBrand> getCardBrands(String str) {
            CharSequence charSequence = str;
            if (charSequence == null || StringsKt.isBlank(charSequence)) {
                return CollectionsKt.listOf(CardBrand.Unknown);
            }
            List<CardBrand> matchingCards = getMatchingCards(str);
            if (!(!matchingCards.isEmpty())) {
                matchingCards = null;
            }
            return matchingCards == null ? CollectionsKt.listOf(CardBrand.Unknown) : matchingCards;
        }

        private final List<CardBrand> getMatchingCards(String str) {
            Matcher matcher;
            CardBrand[] values = CardBrand.values();
            Collection arrayList = new ArrayList();
            int length = values.length;
            int i = 0;
            while (i < length) {
                CardBrand cardBrand = values[i];
                i++;
                Pattern access$getPatternForLength = cardBrand.getPatternForLength(str);
                boolean z = true;
                if (access$getPatternForLength == null || (matcher = access$getPatternForLength.matcher(str)) == null || !matcher.matches()) {
                    z = false;
                }
                if (z) {
                    arrayList.add(cardBrand);
                }
            }
            return (List) arrayList;
        }

        public final CardBrand fromCode(String str) {
            CardBrand cardBrand;
            CardBrand[] values = CardBrand.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    cardBrand = null;
                    break;
                }
                cardBrand = values[i];
                i++;
                if (StringsKt.equals(cardBrand.getCode(), str, true)) {
                    break;
                }
            }
            return cardBrand == null ? CardBrand.Unknown : cardBrand;
        }
    }
}
