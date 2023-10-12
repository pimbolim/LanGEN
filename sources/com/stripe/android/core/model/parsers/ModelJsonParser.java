package com.stripe.android.core.model.parsers;

import com.stripe.android.core.model.StripeModel;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000 \b*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u0003:\u0001\bJ\u0017\u0010\u0004\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0005\u001a\u00020\u0006H&¢\u0006\u0002\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "ModelType", "Lcom/stripe/android/core/model/StripeModel;", "", "parse", "json", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)Lcom/stripe/android/core/model/StripeModel;", "Companion", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ModelJsonParser.kt */
public interface ModelJsonParser<ModelType extends StripeModel> {
    public static final Companion Companion = Companion.$$INSTANCE;

    ModelType parse(JSONObject jSONObject);

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lcom/stripe/android/core/model/parsers/ModelJsonParser$Companion;", "", "()V", "jsonArrayToList", "", "", "jsonArray", "Lorg/json/JSONArray;", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ModelJsonParser.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.util.Collection} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.util.List<java.lang.String>} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.util.List<java.lang.String> jsonArrayToList(org.json.JSONArray r4) {
            /*
                r3 = this;
                if (r4 != 0) goto L_0x0004
                r4 = 0
                goto L_0x0038
            L_0x0004:
                r0 = 0
                int r1 = r4.length()
                kotlin.ranges.IntRange r0 = kotlin.ranges.RangesKt.until((int) r0, (int) r1)
                java.lang.Iterable r0 = (java.lang.Iterable) r0
                java.util.ArrayList r1 = new java.util.ArrayList
                r2 = 10
                int r2 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, r2)
                r1.<init>(r2)
                java.util.Collection r1 = (java.util.Collection) r1
                java.util.Iterator r0 = r0.iterator()
            L_0x0020:
                boolean r2 = r0.hasNext()
                if (r2 == 0) goto L_0x0035
                r2 = r0
                kotlin.collections.IntIterator r2 = (kotlin.collections.IntIterator) r2
                int r2 = r2.nextInt()
                java.lang.String r2 = r4.getString(r2)
                r1.add(r2)
                goto L_0x0020
            L_0x0035:
                r4 = r1
                java.util.List r4 = (java.util.List) r4
            L_0x0038:
                if (r4 != 0) goto L_0x003e
                java.util.List r4 = kotlin.collections.CollectionsKt.emptyList()
            L_0x003e:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.core.model.parsers.ModelJsonParser.Companion.jsonArrayToList(org.json.JSONArray):java.util.List");
        }
    }
}
