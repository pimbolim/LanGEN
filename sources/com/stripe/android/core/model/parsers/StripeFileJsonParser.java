package com.stripe.android.core.model.parsers;

import com.stripe.android.core.model.StripeFile;
import com.stripe.android.core.model.StripeFilePurpose;
import com.stripe.android.core.model.StripeJsonUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/stripe/android/core/model/parsers/StripeFileJsonParser;", "Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "Lcom/stripe/android/core/model/StripeFile;", "()V", "parse", "json", "Lorg/json/JSONObject;", "Companion", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StripeFileJsonParser.kt */
public final class StripeFileJsonParser implements ModelJsonParser<StripeFile> {
    public static final int $stable = 0;
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final String FIELD_CREATED = "created";
    @Deprecated
    private static final String FIELD_FILENAME = "filename";
    @Deprecated
    private static final String FIELD_ID = "id";
    @Deprecated
    private static final String FIELD_PURPOSE = "purpose";
    @Deprecated
    private static final String FIELD_SIZE = "size";
    @Deprecated
    private static final String FIELD_TITLE = "title";
    @Deprecated
    private static final String FIELD_TYPE = "type";
    @Deprecated
    private static final String FIELD_URL = "url";

    public StripeFile parse(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "json");
        return new StripeFile(StripeJsonUtils.optString(jSONObject, "id"), StripeJsonUtils.INSTANCE.optLong(jSONObject, FIELD_CREATED), StripeJsonUtils.optString(jSONObject, FIELD_FILENAME), StripeFilePurpose.Companion.fromCode(StripeJsonUtils.optString(jSONObject, FIELD_PURPOSE)), StripeJsonUtils.INSTANCE.optInteger(jSONObject, FIELD_SIZE), StripeJsonUtils.optString(jSONObject, "title"), StripeJsonUtils.optString(jSONObject, "type"), StripeJsonUtils.optString(jSONObject, "url"));
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/stripe/android/core/model/parsers/StripeFileJsonParser$Companion;", "", "()V", "FIELD_CREATED", "", "FIELD_FILENAME", "FIELD_ID", "FIELD_PURPOSE", "FIELD_SIZE", "FIELD_TITLE", "FIELD_TYPE", "FIELD_URL", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StripeFileJsonParser.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
