package com.stripe.android.model;

import com.braintreepayments.api.internal.GraphQLConstants;
import com.stripe.android.view.DateUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/model/ExpirationDate;", "", "()V", "Unvalidated", "Validated", "Lcom/stripe/android/model/ExpirationDate$Unvalidated;", "Lcom/stripe/android/model/ExpirationDate$Validated;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ExpirationDate.kt */
public abstract class ExpirationDate {
    public static final int $stable = 0;

    public /* synthetic */ ExpirationDate(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ExpirationDate() {
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0006\u0012\u0006\u0010\u0004\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\u001d\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00062\b\b\u0002\u0010\u0004\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\u0006\u0010\u0018\u001a\u00020\u0006J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cR\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/stripe/android/model/ExpirationDate$Unvalidated;", "Lcom/stripe/android/model/ExpirationDate;", "month", "", "year", "(II)V", "", "(Ljava/lang/String;Ljava/lang/String;)V", "isComplete", "", "isComplete$payments_core_release", "()Z", "isMonthValid", "isPartialEntry", "isPartialEntry$payments_core_release", "getMonth", "()Ljava/lang/String;", "getYear", "component1", "component2", "copy", "equals", "other", "", "getDisplayString", "hashCode", "toString", "validate", "Lcom/stripe/android/model/ExpirationDate$Validated;", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ExpirationDate.kt */
    public static final class Unvalidated extends ExpirationDate {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */
        public static final Unvalidated EMPTY = new Unvalidated("", "");
        private final boolean isComplete;
        private final boolean isMonthValid;
        private final boolean isPartialEntry;
        private final String month;
        private final String year;

        public static /* synthetic */ Unvalidated copy$default(Unvalidated unvalidated, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = unvalidated.month;
            }
            if ((i & 2) != 0) {
                str2 = unvalidated.year;
            }
            return unvalidated.copy(str, str2);
        }

        public final String component1() {
            return this.month;
        }

        public final String component2() {
            return this.year;
        }

        public final Unvalidated copy(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "month");
            Intrinsics.checkNotNullParameter(str2, "year");
            return new Unvalidated(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Unvalidated)) {
                return false;
            }
            Unvalidated unvalidated = (Unvalidated) obj;
            return Intrinsics.areEqual((Object) this.month, (Object) unvalidated.month) && Intrinsics.areEqual((Object) this.year, (Object) unvalidated.year);
        }

        public int hashCode() {
            return (this.month.hashCode() * 31) + this.year.hashCode();
        }

        public String toString() {
            return "Unvalidated(month=" + this.month + ", year=" + this.year + ')';
        }

        public final String getMonth() {
            return this.month;
        }

        public final String getYear() {
            return this.year;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Unvalidated(String str, String str2) {
            super((DefaultConstructorMarker) null);
            Boolean bool;
            Intrinsics.checkNotNullParameter(str, "month");
            Intrinsics.checkNotNullParameter(str2, "year");
            this.month = str;
            this.year = str2;
            boolean z = true;
            try {
                Result.Companion companion = Result.Companion;
                int parseInt = Integer.parseInt(getMonth());
                bool = Result.m4709constructorimpl(Boolean.valueOf(1 <= parseInt && parseInt < 13));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                bool = Result.m4709constructorimpl(ResultKt.createFailure(th));
            }
            this.isMonthValid = ((Boolean) (Result.m4715isFailureimpl(bool) ? false : bool)).booleanValue();
            boolean z2 = this.month.length() + this.year.length() == 4;
            this.isComplete = z2;
            this.isPartialEntry = (z2 || this.month.length() + this.year.length() <= 0) ? false : z;
        }

        public final boolean isMonthValid() {
            return this.isMonthValid;
        }

        public Unvalidated(int i, int i2) {
            this(String.valueOf(i), String.valueOf(i2));
        }

        public final Validated validate() {
            Object obj;
            String str = this.month;
            String str2 = this.year;
            try {
                Result.Companion companion = Result.Companion;
                Unvalidated unvalidated = this;
                obj = Result.m4709constructorimpl(new Validated(Integer.parseInt(str), DateUtils.INSTANCE.convertTwoDigitYearToFour(Integer.parseInt(str2))));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m4709constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m4715isFailureimpl(obj)) {
                obj = null;
            }
            return (Validated) obj;
        }

        public final String getDisplayString() {
            if (this.year.length() == 3) {
                return "";
            }
            return CollectionsKt.joinToString$default(CollectionsKt.listOf(StringsKt.padStart(this.month, 2, '0'), StringsKt.padStart(StringsKt.takeLast(this.year, 2), 2, '0')), "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        }

        public final boolean isComplete$payments_core_release() {
            return this.isComplete;
        }

        public final boolean isPartialEntry$payments_core_release() {
            return this.isPartialEntry;
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/stripe/android/model/ExpirationDate$Unvalidated$Companion;", "", "()V", "EMPTY", "Lcom/stripe/android/model/ExpirationDate$Unvalidated;", "getEMPTY", "()Lcom/stripe/android/model/ExpirationDate$Unvalidated;", "create", "input", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: ExpirationDate.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Unvalidated create(String str) {
                boolean z;
                Intrinsics.checkNotNullParameter(str, GraphQLConstants.Keys.INPUT);
                CharSequence charSequence = str;
                int i = 0;
                int i2 = 0;
                while (true) {
                    z = true;
                    if (i2 >= charSequence.length()) {
                        break;
                    }
                    char charAt = charSequence.charAt(i2);
                    i2++;
                    if (!Character.isDigit(charAt) && !CharsKt.isWhitespace(charAt) && charAt != '/') {
                        z = false;
                        continue;
                    }
                    if (!z) {
                        z = false;
                        break;
                    }
                }
                if (!z) {
                    return getEMPTY();
                }
                Appendable sb = new StringBuilder();
                int length = charSequence.length();
                while (i < length) {
                    int i3 = i + 1;
                    char charAt2 = charSequence.charAt(i);
                    if (Character.isDigit(charAt2)) {
                        sb.append(charAt2);
                    }
                    i = i3;
                }
                String sb2 = ((StringBuilder) sb).toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "filterTo(StringBuilder(), predicate).toString()");
                return new Unvalidated(StringsKt.take(sb2, 2), StringsKt.drop(sb2, 2));
            }

            public final Unvalidated getEMPTY() {
                return Unvalidated.EMPTY;
            }
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/stripe/android/model/ExpirationDate$Validated;", "Lcom/stripe/android/model/ExpirationDate;", "month", "", "year", "(II)V", "getMonth", "()I", "getYear", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ExpirationDate.kt */
    public static final class Validated extends ExpirationDate {
        public static final int $stable = 0;
        private final int month;
        private final int year;

        public static /* synthetic */ Validated copy$default(Validated validated, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = validated.month;
            }
            if ((i3 & 2) != 0) {
                i2 = validated.year;
            }
            return validated.copy(i, i2);
        }

        public final int component1() {
            return this.month;
        }

        public final int component2() {
            return this.year;
        }

        public final Validated copy(int i, int i2) {
            return new Validated(i, i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Validated)) {
                return false;
            }
            Validated validated = (Validated) obj;
            return this.month == validated.month && this.year == validated.year;
        }

        public int hashCode() {
            return (this.month * 31) + this.year;
        }

        public String toString() {
            return "Validated(month=" + this.month + ", year=" + this.year + ')';
        }

        public final int getMonth() {
            return this.month;
        }

        public final int getYear() {
            return this.year;
        }

        public Validated(int i, int i2) {
            super((DefaultConstructorMarker) null);
            this.month = i;
            this.year = i2;
        }
    }
}
