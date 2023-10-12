package com.stripe.android.cards;

import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 \u00032\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/stripe/android/cards/Cvc;", "", "()V", "Companion", "Unvalidated", "Validated", "Lcom/stripe/android/cards/Cvc$Unvalidated;", "Lcom/stripe/android/cards/Cvc$Validated;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Cvc.kt */
public abstract class Cvc {
    @Deprecated
    private static final int COMMON_LENGTH = 3;
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public /* synthetic */ Cvc(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private Cvc() {
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000fH\u0002J\u000e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000fJ\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0011\u001a\u00020\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/stripe/android/cards/Cvc$Unvalidated;", "Lcom/stripe/android/cards/Cvc;", "denormalized", "", "(Ljava/lang/String;)V", "normalized", "getNormalized$payments_core_release", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "isComplete", "maxLength", "isPartialEntry", "toString", "validate", "Lcom/stripe/android/cards/Cvc$Validated;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Cvc.kt */
    public static final class Unvalidated extends Cvc {
        private final String denormalized;
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
            int length = charSequence.length();
            int i = 0;
            while (i < length) {
                int i2 = i + 1;
                char charAt = charSequence.charAt(i);
                if (Character.isDigit(charAt)) {
                    sb.append(charAt);
                }
                i = i2;
            }
            String sb2 = ((StringBuilder) sb).toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "filterTo(StringBuilder(), predicate).toString()");
            this.normalized = sb2;
        }

        public final String getNormalized$payments_core_release() {
            return this.normalized;
        }

        public final Validated validate(int i) {
            if (isComplete(i)) {
                return new Validated(this.normalized);
            }
            return null;
        }

        private final boolean isComplete(int i) {
            return SetsKt.setOf(3, Integer.valueOf(i)).contains(Integer.valueOf(this.normalized.length()));
        }

        public final boolean isPartialEntry(int i) {
            return (StringsKt.isBlank(this.normalized) ^ true) && !isComplete(i);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\bJ\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/stripe/android/cards/Cvc$Validated;", "Lcom/stripe/android/cards/Cvc;", "value", "", "(Ljava/lang/String;)V", "getValue$payments_core_release", "()Ljava/lang/String;", "component1", "component1$payments_core_release", "copy", "equals", "", "other", "", "hashCode", "", "toString", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Cvc.kt */
    public static final class Validated extends Cvc {
        private final String value;

        public static /* synthetic */ Validated copy$default(Validated validated, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = validated.value;
            }
            return validated.copy(str);
        }

        public final String component1$payments_core_release() {
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

        public final String getValue$payments_core_release() {
            return this.value;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Validated(String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "value");
            this.value = str;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/cards/Cvc$Companion;", "", "()V", "COMMON_LENGTH", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Cvc.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
