package com.stripe.android.ui.core.elements;

import android.os.Parcel;
import android.os.Parcelable;
import com.braintreepayments.api.models.PostalAddressParser;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u000e\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0001\u000e\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"¨\u0006#"}, d2 = {"Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "Landroid/os/Parcelable;", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CardBrand", "CardNumber", "City", "Country", "Email", "Generic", "Line1", "Line2", "Name", "Phone", "PostalCode", "PreFilledParameterMap", "SaveForFutureUse", "State", "Lcom/stripe/android/ui/core/elements/IdentifierSpec$Generic;", "Lcom/stripe/android/ui/core/elements/IdentifierSpec$Name;", "Lcom/stripe/android/ui/core/elements/IdentifierSpec$CardBrand;", "Lcom/stripe/android/ui/core/elements/IdentifierSpec$CardNumber;", "Lcom/stripe/android/ui/core/elements/IdentifierSpec$Email;", "Lcom/stripe/android/ui/core/elements/IdentifierSpec$Phone;", "Lcom/stripe/android/ui/core/elements/IdentifierSpec$Line1;", "Lcom/stripe/android/ui/core/elements/IdentifierSpec$Line2;", "Lcom/stripe/android/ui/core/elements/IdentifierSpec$City;", "Lcom/stripe/android/ui/core/elements/IdentifierSpec$PostalCode;", "Lcom/stripe/android/ui/core/elements/IdentifierSpec$State;", "Lcom/stripe/android/ui/core/elements/IdentifierSpec$Country;", "Lcom/stripe/android/ui/core/elements/IdentifierSpec$SaveForFutureUse;", "Lcom/stripe/android/ui/core/elements/IdentifierSpec$PreFilledParameterMap;", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IdentifierSpec.kt */
public abstract class IdentifierSpec implements Parcelable {
    public static final int $stable = 0;
    private final String value;

    public /* synthetic */ IdentifierSpec(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    private IdentifierSpec(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0005\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\bHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\bHÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/stripe/android/ui/core/elements/IdentifierSpec$Generic;", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "_value", "", "(Ljava/lang/String;)V", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IdentifierSpec.kt */
    public static final class Generic extends IdentifierSpec {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Generic> CREATOR = new Creator();
        private final String _value;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: IdentifierSpec.kt */
        public static final class Creator implements Parcelable.Creator<Generic> {
            public final Generic createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Generic(parcel.readString());
            }

            public final Generic[] newArray(int i) {
                return new Generic[i];
            }
        }

        private final String component1() {
            return this._value;
        }

        public static /* synthetic */ Generic copy$default(Generic generic, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = generic._value;
            }
            return generic.copy(str);
        }

        public final Generic copy(String str) {
            Intrinsics.checkNotNullParameter(str, "_value");
            return new Generic(str);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Generic) && Intrinsics.areEqual((Object) this._value, (Object) ((Generic) obj)._value);
        }

        public int hashCode() {
            return this._value.hashCode();
        }

        public String toString() {
            return "Generic(_value=" + this._value + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this._value);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Generic(String str) {
            super(str, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "_value");
            this._value = str;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, d2 = {"Lcom/stripe/android/ui/core/elements/IdentifierSpec$Name;", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IdentifierSpec.kt */
    public static final class Name extends IdentifierSpec {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Name> CREATOR = new Creator();
        public static final Name INSTANCE = new Name();

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: IdentifierSpec.kt */
        public static final class Creator implements Parcelable.Creator<Name> {
            public final Name createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return Name.INSTANCE;
            }

            public final Name[] newArray(int i) {
                return new Name[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(1);
        }

        private Name() {
            super("name", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, d2 = {"Lcom/stripe/android/ui/core/elements/IdentifierSpec$CardBrand;", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IdentifierSpec.kt */
    public static final class CardBrand extends IdentifierSpec {
        public static final int $stable = 8;
        public static final Parcelable.Creator<CardBrand> CREATOR = new Creator();
        public static final CardBrand INSTANCE = new CardBrand();

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: IdentifierSpec.kt */
        public static final class Creator implements Parcelable.Creator<CardBrand> {
            public final CardBrand createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return CardBrand.INSTANCE;
            }

            public final CardBrand[] newArray(int i) {
                return new CardBrand[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(1);
        }

        private CardBrand() {
            super("card_brand_code", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, d2 = {"Lcom/stripe/android/ui/core/elements/IdentifierSpec$CardNumber;", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IdentifierSpec.kt */
    public static final class CardNumber extends IdentifierSpec {
        public static final int $stable = 8;
        public static final Parcelable.Creator<CardNumber> CREATOR = new Creator();
        public static final CardNumber INSTANCE = new CardNumber();

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: IdentifierSpec.kt */
        public static final class Creator implements Parcelable.Creator<CardNumber> {
            public final CardNumber createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return CardNumber.INSTANCE;
            }

            public final CardNumber[] newArray(int i) {
                return new CardNumber[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(1);
        }

        private CardNumber() {
            super("number", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, d2 = {"Lcom/stripe/android/ui/core/elements/IdentifierSpec$Email;", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IdentifierSpec.kt */
    public static final class Email extends IdentifierSpec {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Email> CREATOR = new Creator();
        public static final Email INSTANCE = new Email();

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: IdentifierSpec.kt */
        public static final class Creator implements Parcelable.Creator<Email> {
            public final Email createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return Email.INSTANCE;
            }

            public final Email[] newArray(int i) {
                return new Email[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(1);
        }

        private Email() {
            super("email", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, d2 = {"Lcom/stripe/android/ui/core/elements/IdentifierSpec$Phone;", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IdentifierSpec.kt */
    public static final class Phone extends IdentifierSpec {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Phone> CREATOR = new Creator();
        public static final Phone INSTANCE = new Phone();

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: IdentifierSpec.kt */
        public static final class Creator implements Parcelable.Creator<Phone> {
            public final Phone createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return Phone.INSTANCE;
            }

            public final Phone[] newArray(int i) {
                return new Phone[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(1);
        }

        private Phone() {
            super("phone", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, d2 = {"Lcom/stripe/android/ui/core/elements/IdentifierSpec$Line1;", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IdentifierSpec.kt */
    public static final class Line1 extends IdentifierSpec {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Line1> CREATOR = new Creator();
        public static final Line1 INSTANCE = new Line1();

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: IdentifierSpec.kt */
        public static final class Creator implements Parcelable.Creator<Line1> {
            public final Line1 createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return Line1.INSTANCE;
            }

            public final Line1[] newArray(int i) {
                return new Line1[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(1);
        }

        private Line1() {
            super(PostalAddressParser.LINE_1_KEY, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, d2 = {"Lcom/stripe/android/ui/core/elements/IdentifierSpec$Line2;", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IdentifierSpec.kt */
    public static final class Line2 extends IdentifierSpec {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Line2> CREATOR = new Creator();
        public static final Line2 INSTANCE = new Line2();

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: IdentifierSpec.kt */
        public static final class Creator implements Parcelable.Creator<Line2> {
            public final Line2 createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return Line2.INSTANCE;
            }

            public final Line2[] newArray(int i) {
                return new Line2[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(1);
        }

        private Line2() {
            super(PostalAddressParser.LINE_2_KEY, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, d2 = {"Lcom/stripe/android/ui/core/elements/IdentifierSpec$City;", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IdentifierSpec.kt */
    public static final class City extends IdentifierSpec {
        public static final int $stable = 8;
        public static final Parcelable.Creator<City> CREATOR = new Creator();
        public static final City INSTANCE = new City();

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: IdentifierSpec.kt */
        public static final class Creator implements Parcelable.Creator<City> {
            public final City createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return City.INSTANCE;
            }

            public final City[] newArray(int i) {
                return new City[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(1);
        }

        private City() {
            super(PostalAddressParser.LOCALITY_KEY, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, d2 = {"Lcom/stripe/android/ui/core/elements/IdentifierSpec$PostalCode;", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IdentifierSpec.kt */
    public static final class PostalCode extends IdentifierSpec {
        public static final int $stable = 8;
        public static final Parcelable.Creator<PostalCode> CREATOR = new Creator();
        public static final PostalCode INSTANCE = new PostalCode();

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: IdentifierSpec.kt */
        public static final class Creator implements Parcelable.Creator<PostalCode> {
            public final PostalCode createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return PostalCode.INSTANCE;
            }

            public final PostalCode[] newArray(int i) {
                return new PostalCode[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(1);
        }

        private PostalCode() {
            super(PostalAddressParser.POSTAL_CODE_UNDERSCORE_KEY, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, d2 = {"Lcom/stripe/android/ui/core/elements/IdentifierSpec$State;", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IdentifierSpec.kt */
    public static final class State extends IdentifierSpec {
        public static final int $stable = 8;
        public static final Parcelable.Creator<State> CREATOR = new Creator();
        public static final State INSTANCE = new State();

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: IdentifierSpec.kt */
        public static final class Creator implements Parcelable.Creator<State> {
            public final State createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return State.INSTANCE;
            }

            public final State[] newArray(int i) {
                return new State[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(1);
        }

        private State() {
            super(PostalAddressParser.REGION_KEY, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, d2 = {"Lcom/stripe/android/ui/core/elements/IdentifierSpec$Country;", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IdentifierSpec.kt */
    public static final class Country extends IdentifierSpec {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Country> CREATOR = new Creator();
        public static final Country INSTANCE = new Country();

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: IdentifierSpec.kt */
        public static final class Creator implements Parcelable.Creator<Country> {
            public final Country createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return Country.INSTANCE;
            }

            public final Country[] newArray(int i) {
                return new Country[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(1);
        }

        private Country() {
            super("country", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, d2 = {"Lcom/stripe/android/ui/core/elements/IdentifierSpec$SaveForFutureUse;", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IdentifierSpec.kt */
    public static final class SaveForFutureUse extends IdentifierSpec {
        public static final int $stable = 8;
        public static final Parcelable.Creator<SaveForFutureUse> CREATOR = new Creator();
        public static final SaveForFutureUse INSTANCE = new SaveForFutureUse();

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: IdentifierSpec.kt */
        public static final class Creator implements Parcelable.Creator<SaveForFutureUse> {
            public final SaveForFutureUse createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return SaveForFutureUse.INSTANCE;
            }

            public final SaveForFutureUse[] newArray(int i) {
                return new SaveForFutureUse[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(1);
        }

        private SaveForFutureUse() {
            super("save_for_future_use", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, d2 = {"Lcom/stripe/android/ui/core/elements/IdentifierSpec$PreFilledParameterMap;", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IdentifierSpec.kt */
    public static final class PreFilledParameterMap extends IdentifierSpec {
        public static final int $stable = 8;
        public static final Parcelable.Creator<PreFilledParameterMap> CREATOR = new Creator();
        public static final PreFilledParameterMap INSTANCE = new PreFilledParameterMap();

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: IdentifierSpec.kt */
        public static final class Creator implements Parcelable.Creator<PreFilledParameterMap> {
            public final PreFilledParameterMap createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return PreFilledParameterMap.INSTANCE;
            }

            public final PreFilledParameterMap[] newArray(int i) {
                return new PreFilledParameterMap[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(1);
        }

        private PreFilledParameterMap() {
            super("save_for_future_use", (DefaultConstructorMarker) null);
        }
    }
}
