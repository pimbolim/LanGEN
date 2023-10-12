package com.stripe.android.model.parsers;

import com.stripe.android.cards.Bin;
import com.stripe.android.core.model.parsers.ModelJsonParser;
import com.stripe.android.model.AccountRange;
import com.stripe.android.model.CardMetadata;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/model/parsers/CardMetadataJsonParser;", "Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "Lcom/stripe/android/model/CardMetadata;", "bin", "Lcom/stripe/android/cards/Bin;", "(Lcom/stripe/android/cards/Bin;)V", "accountRangeJsonParser", "Lcom/stripe/android/model/parsers/AccountRangeJsonParser;", "parse", "json", "Lorg/json/JSONObject;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CardMetadataJsonParser.kt */
public final class CardMetadataJsonParser implements ModelJsonParser<CardMetadata> {
    private final AccountRangeJsonParser accountRangeJsonParser = new AccountRangeJsonParser();
    private final Bin bin;

    public CardMetadataJsonParser(Bin bin2) {
        Intrinsics.checkNotNullParameter(bin2, "bin");
        this.bin = bin2;
    }

    public CardMetadata parse(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "json");
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
        }
        Collection arrayList = new ArrayList();
        Iterator it = RangesKt.until(0, optJSONArray.length()).iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            AccountRangeJsonParser accountRangeJsonParser2 = this.accountRangeJsonParser;
            JSONObject jSONObject2 = optJSONArray.getJSONObject(nextInt);
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "data.getJSONObject(it)");
            AccountRange parse = accountRangeJsonParser2.parse(jSONObject2);
            if (parse != null) {
                arrayList.add(parse);
            }
        }
        return new CardMetadata(this.bin, (List) arrayList);
    }
}
