package com.stripe.android.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.core.model.StripeModel;
import com.stripe.android.model.parsers.TokenJsonParser;
import com.stripe.android.stripe3ds2.transactions.MessageExtension;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 22\u00020\u00012\u00020\u0002:\u000223BG\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J\t\u0010!\u001a\u00020\nHÆ\u0003J\t\u0010\"\u001a\u00020\nHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u000fHÆ\u0003JS\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001J\u0013\u0010(\u001a\u00020\n2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020'HÖ\u0001J\t\u0010,\u001a\u00020\u0004HÖ\u0001J\u0019\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020'HÖ\u0001R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001a¨\u00064"}, d2 = {"Lcom/stripe/android/model/Token;", "Lcom/stripe/android/core/model/StripeModel;", "Lcom/stripe/android/model/StripePaymentSource;", "id", "", "type", "Lcom/stripe/android/model/Token$Type;", "created", "Ljava/util/Date;", "livemode", "", "used", "bankAccount", "Lcom/stripe/android/model/BankAccount;", "card", "Lcom/stripe/android/model/Card;", "(Ljava/lang/String;Lcom/stripe/android/model/Token$Type;Ljava/util/Date;ZZLcom/stripe/android/model/BankAccount;Lcom/stripe/android/model/Card;)V", "getBankAccount", "()Lcom/stripe/android/model/BankAccount;", "getCard", "()Lcom/stripe/android/model/Card;", "getCreated", "()Ljava/util/Date;", "getId", "()Ljava/lang/String;", "getLivemode", "()Z", "getType", "()Lcom/stripe/android/model/Token$Type;", "getUsed", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "Type", "payments-model_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Token.kt */
public final class Token implements StripeModel, StripePaymentSource {
    public static final Parcelable.Creator<Token> CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final BankAccount bankAccount;
    private final Card card;
    private final Date created;
    private final String id;
    private final boolean livemode;
    private final Type type;
    private final boolean used;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Token.kt */
    public static final class Creator implements Parcelable.Creator<Token> {
        public final Token createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            Type valueOf = Type.valueOf(parcel.readString());
            Date date = (Date) parcel.readSerializable();
            boolean z = false;
            boolean z2 = parcel.readInt() != 0;
            if (parcel.readInt() != 0) {
                z = true;
            }
            Card card = null;
            BankAccount createFromParcel = parcel.readInt() == 0 ? null : BankAccount.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                card = Card.CREATOR.createFromParcel(parcel);
            }
            return new Token(readString, valueOf, date, z2, z, createFromParcel, card);
        }

        public final Token[] newArray(int i) {
            return new Token[i];
        }
    }

    public static /* synthetic */ Token copy$default(Token token, String str, Type type2, Date date, boolean z, boolean z2, BankAccount bankAccount2, Card card2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = token.getId();
        }
        if ((i & 2) != 0) {
            type2 = token.type;
        }
        Type type3 = type2;
        if ((i & 4) != 0) {
            date = token.created;
        }
        Date date2 = date;
        if ((i & 8) != 0) {
            z = token.livemode;
        }
        boolean z3 = z;
        if ((i & 16) != 0) {
            z2 = token.used;
        }
        boolean z4 = z2;
        if ((i & 32) != 0) {
            bankAccount2 = token.bankAccount;
        }
        BankAccount bankAccount3 = bankAccount2;
        if ((i & 64) != 0) {
            card2 = token.card;
        }
        return token.copy(str, type3, date2, z3, z4, bankAccount3, card2);
    }

    @JvmStatic
    public static final Token fromJson(JSONObject jSONObject) {
        return Companion.fromJson(jSONObject);
    }

    public final String component1() {
        return getId();
    }

    public final Type component2() {
        return this.type;
    }

    public final Date component3() {
        return this.created;
    }

    public final boolean component4() {
        return this.livemode;
    }

    public final boolean component5() {
        return this.used;
    }

    public final BankAccount component6() {
        return this.bankAccount;
    }

    public final Card component7() {
        return this.card;
    }

    public final Token copy(String str, Type type2, Date date, boolean z, boolean z2, BankAccount bankAccount2, Card card2) {
        Intrinsics.checkNotNullParameter(str, MessageExtension.FIELD_ID);
        Intrinsics.checkNotNullParameter(type2, "type");
        Intrinsics.checkNotNullParameter(date, "created");
        return new Token(str, type2, date, z, z2, bankAccount2, card2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Token)) {
            return false;
        }
        Token token = (Token) obj;
        return Intrinsics.areEqual((Object) getId(), (Object) token.getId()) && this.type == token.type && Intrinsics.areEqual((Object) this.created, (Object) token.created) && this.livemode == token.livemode && this.used == token.used && Intrinsics.areEqual((Object) this.bankAccount, (Object) token.bankAccount) && Intrinsics.areEqual((Object) this.card, (Object) token.card);
    }

    public int hashCode() {
        int hashCode = ((((getId().hashCode() * 31) + this.type.hashCode()) * 31) + this.created.hashCode()) * 31;
        boolean z = this.livemode;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i = (hashCode + (z ? 1 : 0)) * 31;
        boolean z3 = this.used;
        if (!z3) {
            z2 = z3;
        }
        int i2 = (i + (z2 ? 1 : 0)) * 31;
        BankAccount bankAccount2 = this.bankAccount;
        int i3 = 0;
        int hashCode2 = (i2 + (bankAccount2 == null ? 0 : bankAccount2.hashCode())) * 31;
        Card card2 = this.card;
        if (card2 != null) {
            i3 = card2.hashCode();
        }
        return hashCode2 + i3;
    }

    public String toString() {
        return "Token(id=" + getId() + ", type=" + this.type + ", created=" + this.created + ", livemode=" + this.livemode + ", used=" + this.used + ", bankAccount=" + this.bankAccount + ", card=" + this.card + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.id);
        parcel.writeString(this.type.name());
        parcel.writeSerializable(this.created);
        parcel.writeInt(this.livemode ? 1 : 0);
        parcel.writeInt(this.used ? 1 : 0);
        BankAccount bankAccount2 = this.bankAccount;
        if (bankAccount2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            bankAccount2.writeToParcel(parcel, i);
        }
        Card card2 = this.card;
        if (card2 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        card2.writeToParcel(parcel, i);
    }

    public Token(String str, Type type2, Date date, boolean z, boolean z2, BankAccount bankAccount2, Card card2) {
        Intrinsics.checkNotNullParameter(str, MessageExtension.FIELD_ID);
        Intrinsics.checkNotNullParameter(type2, "type");
        Intrinsics.checkNotNullParameter(date, "created");
        this.id = str;
        this.type = type2;
        this.created = date;
        this.livemode = z;
        this.used = z2;
        this.bankAccount = bankAccount2;
        this.card = card2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Token(String str, Type type2, Date date, boolean z, boolean z2, BankAccount bankAccount2, Card card2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, type2, date, z, z2, (i & 32) != 0 ? null : bankAccount2, (i & 64) != 0 ? null : card2);
    }

    public String getId() {
        return this.id;
    }

    public final Type getType() {
        return this.type;
    }

    public final Date getCreated() {
        return this.created;
    }

    public final boolean getLivemode() {
        return this.livemode;
    }

    public final boolean getUsed() {
        return this.used;
    }

    public final BankAccount getBankAccount() {
        return this.bankAccount;
    }

    public final Card getCard() {
        return this.card;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/stripe/android/model/Token$Type;", "", "code", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getCode", "()Ljava/lang/String;", "Card", "BankAccount", "Pii", "Account", "CvcUpdate", "Person", "Companion", "payments-model_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Token.kt */
    public enum Type {
        Card("card"),
        BankAccount("bank_account"),
        Pii("pii"),
        Account("account"),
        CvcUpdate("cvc_update"),
        Person("person");
        
        public static final Companion Companion = null;
        private final String code;

        private Type(String str) {
            this.code = str;
        }

        public final String getCode() {
            return this.code;
        }

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/model/Token$Type$Companion;", "", "()V", "fromCode", "Lcom/stripe/android/model/Token$Type;", "code", "", "payments-model_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Token.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Type fromCode(String str) {
                Type[] values = Type.values();
                int length = values.length;
                int i = 0;
                while (i < length) {
                    Type type = values[i];
                    i++;
                    if (Intrinsics.areEqual((Object) type.getCode(), (Object) str)) {
                        return type;
                    }
                }
                return null;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/model/Token$Companion;", "", "()V", "fromJson", "Lcom/stripe/android/model/Token;", "jsonObject", "Lorg/json/JSONObject;", "payments-model_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Token.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Token fromJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            return new TokenJsonParser().parse(jSONObject);
        }
    }
}
