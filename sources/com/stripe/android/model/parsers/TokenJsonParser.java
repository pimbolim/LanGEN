package com.stripe.android.model.parsers;

import com.stripe.android.core.model.StripeJsonUtils;
import com.stripe.android.core.model.parsers.ModelJsonParser;
import com.stripe.android.model.BankAccount;
import com.stripe.android.model.Card;
import com.stripe.android.model.Token;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/stripe/android/model/parsers/TokenJsonParser;", "Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "Lcom/stripe/android/model/Token;", "()V", "parse", "json", "Lorg/json/JSONObject;", "Companion", "payments-model_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TokenJsonParser.kt */
public final class TokenJsonParser implements ModelJsonParser<Token> {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final String FIELD_CREATED = "created";
    @Deprecated
    private static final String FIELD_ID = "id";
    @Deprecated
    private static final String FIELD_LIVEMODE = "livemode";
    @Deprecated
    private static final String FIELD_TYPE = "type";
    @Deprecated
    private static final String FIELD_USED = "used";

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TokenJsonParser.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Token.Type.values().length];
            iArr[Token.Type.Card.ordinal()] = 1;
            iArr[Token.Type.BankAccount.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public Token parse(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "json");
        String optString = StripeJsonUtils.optString(jSONObject, "id");
        Long optLong = StripeJsonUtils.INSTANCE.optLong(jSONObject, FIELD_CREATED);
        Token.Type fromCode = Token.Type.Companion.fromCode(StripeJsonUtils.optString(jSONObject, "type"));
        if (fromCode == null || optString == null || optLong == null) {
            return null;
        }
        boolean optBoolean = StripeJsonUtils.INSTANCE.optBoolean(jSONObject, FIELD_USED);
        boolean optBoolean2 = StripeJsonUtils.INSTANCE.optBoolean(jSONObject, FIELD_LIVEMODE);
        Date date = new Date(TimeUnit.SECONDS.toMillis(optLong.longValue()));
        int i = WhenMappings.$EnumSwitchMapping$0[fromCode.ordinal()];
        if (i == 1) {
            JSONObject optJSONObject = jSONObject.optJSONObject(Token.Type.Card.getCode());
            if (optJSONObject == null) {
                return null;
            }
            return new Token(optString, Token.Type.Card, date, optBoolean2, optBoolean, (BankAccount) null, new CardJsonParser().parse(optJSONObject), 32, (DefaultConstructorMarker) null);
        } else if (i != 2) {
            return new Token(optString, fromCode, date, optBoolean2, optBoolean, (BankAccount) null, (Card) null, 96, (DefaultConstructorMarker) null);
        } else {
            JSONObject optJSONObject2 = jSONObject.optJSONObject(Token.Type.BankAccount.getCode());
            if (optJSONObject2 == null) {
                return null;
            }
            return new Token(optString, Token.Type.BankAccount, date, optBoolean2, optBoolean, new BankAccountJsonParser().parse(optJSONObject2), (Card) null, 64, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/stripe/android/model/parsers/TokenJsonParser$Companion;", "", "()V", "FIELD_CREATED", "", "FIELD_ID", "FIELD_LIVEMODE", "FIELD_TYPE", "FIELD_USED", "payments-model_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TokenJsonParser.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
