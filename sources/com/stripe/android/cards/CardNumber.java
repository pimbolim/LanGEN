package com.stripe.android.cards;

import com.nimbusds.jose.shaded.ow2asm.signature.SignatureVisitor;
import com.stripe.android.CardUtils;
import com.stripe.android.model.CardBrand;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.lang3.StringUtils;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00032\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/stripe/android/cards/CardNumber;", "", "()V", "Companion", "Unvalidated", "Validated", "Lcom/stripe/android/cards/CardNumber$Unvalidated;", "Lcom/stripe/android/cards/CardNumber$Validated;", "payments-model_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CardNumber.kt */
public abstract class CardNumber {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int DEFAULT_PAN_LENGTH = 16;
    /* access modifiers changed from: private */
    public static final Set<Integer> DEFAULT_SPACE_POSITIONS = SetsKt.setOf(4, 9, 14);
    public static final int MAX_PAN_LENGTH = 19;
    public static final int MIN_PAN_LENGTH = 14;
    /* access modifiers changed from: private */
    public static final Map<Integer, Set<Integer>> SPACE_POSITIONS = MapsKt.mapOf(TuplesKt.to(14, SetsKt.setOf(4, 11)), TuplesKt.to(15, SetsKt.setOf(4, 11)), TuplesKt.to(16, SetsKt.setOf(4, 9, 14)), TuplesKt.to(19, SetsKt.setOf(4, 9, 14, 19)));

    public /* synthetic */ CardNumber(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private CardNumber() {
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0014\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u000eH\u0002J\u0012\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u000eH\u0007J\t\u0010\u001c\u001a\u00020\u000eHÖ\u0001J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u000eH\u0007J\b\u0010\u001e\u001a\u00020\nH\u0007J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\u0012\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\u001a\u001a\u00020\u000eH\u0007R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000bR\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006#"}, d2 = {"Lcom/stripe/android/cards/CardNumber$Unvalidated;", "Lcom/stripe/android/cards/CardNumber;", "denormalized", "", "(Ljava/lang/String;)V", "bin", "Lcom/stripe/android/cards/Bin;", "getBin", "()Lcom/stripe/android/cards/Bin;", "isMaxLength", "", "()Z", "isValidLuhn", "length", "", "getLength", "()I", "normalized", "getNormalized", "()Ljava/lang/String;", "component1", "copy", "equals", "other", "", "formatNumber", "panLength", "getFormatted", "hashCode", "isPartialEntry", "isPossibleCardBrand", "toString", "validate", "Lcom/stripe/android/cards/CardNumber$Validated;", "Companion", "payments-model_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CardNumber.kt */
    public static final class Unvalidated extends CardNumber {
        private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @Deprecated
        private static final Set<Character> REJECT_CHARS = SetsKt.setOf(Character.valueOf(SignatureVisitor.SUPER), ' ');
        private final Bin bin;
        private final String denormalized;
        private final boolean isMaxLength;
        private final boolean isValidLuhn;
        private final int length;
        private final String normalized;

        private final String component1() {
            return this.denormalized;
        }

        public static /* synthetic */ Unvalidated copy$default(Unvalidated unvalidated, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = unvalidated.denormalized;
            }
            return unvalidated.copy(str);
        }

        public final Unvalidated copy(String str) {
            Intrinsics.checkNotNullParameter(str, "denormalized");
            return new Unvalidated(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Unvalidated) && Intrinsics.areEqual((Object) this.denormalized, (Object) ((Unvalidated) obj).denormalized);
        }

        public int hashCode() {
            return this.denormalized.hashCode();
        }

        public String toString() {
            return "Unvalidated(denormalized=" + this.denormalized + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Unvalidated(String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "denormalized");
            this.denormalized = str;
            CharSequence charSequence = str;
            Appendable sb = new StringBuilder();
            boolean z = false;
            int i = 0;
            while (i < charSequence.length()) {
                char charAt = charSequence.charAt(i);
                i++;
                if (!REJECT_CHARS.contains(Character.valueOf(charAt))) {
                    sb.append(charAt);
                }
            }
            String sb2 = ((StringBuilder) sb).toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "filterNotTo(StringBuilder(), predicate).toString()");
            this.normalized = sb2;
            int length2 = sb2.length();
            this.length = length2;
            this.isMaxLength = length2 == 19 ? true : z;
            this.bin = Bin.Companion.create(sb2);
            this.isValidLuhn = CardUtils.INSTANCE.isValidLuhnNumber(sb2);
        }

        public final String getNormalized() {
            return this.normalized;
        }

        public final int getLength() {
            return this.length;
        }

        public final boolean isMaxLength() {
            return this.isMaxLength;
        }

        public final Bin getBin() {
            return this.bin;
        }

        public final boolean isValidLuhn() {
            return this.isValidLuhn;
        }

        public final Validated validate(int i) {
            if (i < 14 || this.normalized.length() != i || !this.isValidLuhn) {
                return null;
            }
            return new Validated(this.normalized);
        }

        public static /* synthetic */ String getFormatted$default(Unvalidated unvalidated, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = 16;
            }
            return unvalidated.getFormatted(i);
        }

        public final String getFormatted(int i) {
            return formatNumber(i);
        }

        private final String formatNumber(int i) {
            Set<Integer> spacePositions = CardNumber.Companion.getSpacePositions(i);
            String take = StringsKt.take(this.normalized, i);
            int size = spacePositions.size() + 1;
            String[] strArr = new String[size];
            int length2 = take.length();
            int i2 = 0;
            int i3 = 0;
            for (Object next : CollectionsKt.sorted(CollectionsKt.toList(spacePositions))) {
                int i4 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                int intValue = ((Number) next).intValue() - i2;
                if (length2 > intValue) {
                    String substring = take.substring(i3, intValue);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    strArr[i2] = substring;
                    i3 = intValue;
                }
                i2 = i4;
            }
            int i5 = 0;
            while (true) {
                if (i5 >= size) {
                    i5 = -1;
                    break;
                }
                int i6 = i5 + 1;
                if (strArr[i5] == null) {
                    break;
                }
                i5 = i6;
            }
            Integer valueOf = Integer.valueOf(i5);
            if (!(valueOf.intValue() != -1)) {
                valueOf = null;
            }
            if (valueOf != null) {
                int intValue2 = valueOf.intValue();
                String substring2 = take.substring(i3);
                Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
                strArr[intValue2] = substring2;
            }
            ArrayList arrayList = new ArrayList();
            int i7 = 0;
            while (i7 < size) {
                String str = strArr[i7];
                i7++;
                if (!(str != null)) {
                    break;
                }
                arrayList.add(str);
            }
            return CollectionsKt.joinToString$default(arrayList, StringUtils.SPACE, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        }

        public final boolean isPartialEntry(int i) {
            return this.normalized.length() != i && (StringsKt.isBlank(this.normalized) ^ true);
        }

        public final boolean isPossibleCardBrand() {
            if (!(!StringsKt.isBlank(this.normalized)) || CollectionsKt.first(CardBrand.Companion.getCardBrands(this.normalized)) == CardBrand.Unknown) {
                return false;
            }
            return true;
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\f\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/cards/CardNumber$Unvalidated$Companion;", "", "()V", "REJECT_CHARS", "", "", "payments-model_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: CardNumber.kt */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/stripe/android/cards/CardNumber$Validated;", "Lcom/stripe/android/cards/CardNumber;", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "payments-model_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CardNumber.kt */
    public static final class Validated extends CardNumber {
        private final String value;

        public static /* synthetic */ Validated copy$default(Validated validated, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = validated.value;
            }
            return validated.copy(str);
        }

        public final String component1() {
            return this.value;
        }

        public final Validated copy(String str) {
            Intrinsics.checkNotNullParameter(str, "value");
            return new Validated(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Validated) && Intrinsics.areEqual((Object) this.value, (Object) ((Validated) obj).value);
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return "Validated(value=" + this.value + ')';
        }

        public final String getValue() {
            return this.value;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Validated(String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "value");
            this.value = str;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\f\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00048\u0006XT¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00048\u0006XT¢\u0006\u0002\n\u0000R \u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00060\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/stripe/android/cards/CardNumber$Companion;", "", "()V", "DEFAULT_PAN_LENGTH", "", "DEFAULT_SPACE_POSITIONS", "", "MAX_PAN_LENGTH", "MIN_PAN_LENGTH", "SPACE_POSITIONS", "", "getSpacePositions", "panLength", "payments-model_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CardNumber.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Set<Integer> getSpacePositions(int i) {
            Set<Integer> set = (Set) CardNumber.SPACE_POSITIONS.get(Integer.valueOf(i));
            return set == null ? CardNumber.DEFAULT_SPACE_POSITIONS : set;
        }
    }
}
