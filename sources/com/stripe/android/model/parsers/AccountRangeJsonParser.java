package com.stripe.android.model.parsers;

import com.stripe.android.core.model.StripeJsonUtils;
import com.stripe.android.core.model.parsers.ModelJsonParser;
import com.stripe.android.model.AccountRange;
import com.stripe.android.model.BinRange;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002¨\u0006\n"}, d2 = {"Lcom/stripe/android/model/parsers/AccountRangeJsonParser;", "Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "Lcom/stripe/android/model/AccountRange;", "()V", "parse", "json", "Lorg/json/JSONObject;", "serialize", "accountRange", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AccountRangeJsonParser.kt */
public final class AccountRangeJsonParser implements ModelJsonParser<AccountRange> {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    public static final String FIELD_ACCOUNT_RANGE_HIGH = "account_range_high";
    @Deprecated
    public static final String FIELD_ACCOUNT_RANGE_LOW = "account_range_low";
    @Deprecated
    public static final String FIELD_BRAND = "brand";
    @Deprecated
    public static final String FIELD_COUNTRY = "country";
    @Deprecated
    public static final String FIELD_PAN_LENGTH = "pan_length";

    public AccountRange parse(JSONObject jSONObject) {
        AccountRange.BrandInfo brandInfo;
        Intrinsics.checkNotNullParameter(jSONObject, "json");
        String optString = StripeJsonUtils.optString(jSONObject, FIELD_ACCOUNT_RANGE_HIGH);
        String optString2 = StripeJsonUtils.optString(jSONObject, FIELD_ACCOUNT_RANGE_LOW);
        Integer optInteger = StripeJsonUtils.INSTANCE.optInteger(jSONObject, FIELD_PAN_LENGTH);
        String optString3 = StripeJsonUtils.optString(jSONObject, FIELD_BRAND);
        AccountRange.BrandInfo[] values = AccountRange.BrandInfo.values();
        int length = values.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                brandInfo = null;
                break;
            }
            brandInfo = values[i];
            i++;
            if (Intrinsics.areEqual((Object) brandInfo.getBrandName(), (Object) optString3)) {
                break;
            }
        }
        if (optString == null || optString2 == null || optInteger == null || brandInfo == null) {
            return null;
        }
        return new AccountRange(new BinRange(optString2, optString), optInteger.intValue(), brandInfo, StripeJsonUtils.optString(jSONObject, "country"));
    }

    public final JSONObject serialize(AccountRange accountRange) {
        Intrinsics.checkNotNullParameter(accountRange, "accountRange");
        JSONObject put = new JSONObject().put(FIELD_ACCOUNT_RANGE_LOW, accountRange.getBinRange().getLow()).put(FIELD_ACCOUNT_RANGE_HIGH, accountRange.getBinRange().getHigh()).put(FIELD_PAN_LENGTH, accountRange.getPanLength()).put(FIELD_BRAND, accountRange.getBrandInfo().getBrandName()).put("country", accountRange.getCountry());
        Intrinsics.checkNotNullExpressionValue(put, "JSONObject()\n           …RY, accountRange.country)");
        return put;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/stripe/android/model/parsers/AccountRangeJsonParser$Companion;", "", "()V", "FIELD_ACCOUNT_RANGE_HIGH", "", "FIELD_ACCOUNT_RANGE_LOW", "FIELD_BRAND", "FIELD_COUNTRY", "FIELD_PAN_LENGTH", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AccountRangeJsonParser.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
