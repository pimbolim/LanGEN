package com.stripe.android.model.parsers;

import com.stripe.android.core.model.StripeJsonUtils;
import com.stripe.android.core.model.parsers.ModelJsonParser;
import com.stripe.android.model.BankStatuses;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/stripe/android/model/parsers/FpxBankStatusesJsonParser;", "Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "Lcom/stripe/android/model/BankStatuses;", "()V", "parse", "json", "Lorg/json/JSONObject;", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FpxBankStatusesJsonParser.kt */
public final class FpxBankStatusesJsonParser implements ModelJsonParser<BankStatuses> {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final String FIELD_PARSED_BANK_STATUS = "parsed_bank_status";

    public BankStatuses parse(JSONObject jSONObject) {
        BankStatuses bankStatuses;
        Intrinsics.checkNotNullParameter(jSONObject, "json");
        Map optMap = StripeJsonUtils.INSTANCE.optMap(jSONObject, FIELD_PARSED_BANK_STATUS);
        if (optMap == null || optMap.isEmpty()) {
            optMap = null;
        }
        if (optMap == null) {
            bankStatuses = null;
        } else {
            bankStatuses = new BankStatuses(optMap);
        }
        return bankStatuses == null ? new BankStatuses((Map) null, 1, (DefaultConstructorMarker) null) : bankStatuses;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/model/parsers/FpxBankStatusesJsonParser$Companion;", "", "()V", "FIELD_PARSED_BANK_STATUS", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FpxBankStatusesJsonParser.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
