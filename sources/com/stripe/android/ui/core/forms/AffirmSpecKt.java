package com.stripe.android.ui.core.forms;

import com.stripe.android.ui.core.elements.AffirmTextSpec;
import com.stripe.android.ui.core.elements.IdentifierSpec;
import com.stripe.android.ui.core.elements.LayoutSpec;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0016\u0010\u0000\u001a\u00020\u00018\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"$\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\"\u0014\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"AffirmForm", "Lcom/stripe/android/ui/core/elements/LayoutSpec;", "getAffirmForm", "()Lcom/stripe/android/ui/core/elements/LayoutSpec;", "AffirmParamKey", "", "", "", "getAffirmParamKey", "()Ljava/util/Map;", "affirmHeader", "Lcom/stripe/android/ui/core/elements/AffirmTextSpec;", "getAffirmHeader", "()Lcom/stripe/android/ui/core/elements/AffirmTextSpec;", "payments-ui-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: AffirmSpec.kt */
public final class AffirmSpecKt {
    private static final LayoutSpec AffirmForm;
    private static final Map<String, Object> AffirmParamKey = MapsKt.mutableMapOf(TuplesKt.to("type", "affirm"));
    private static final AffirmTextSpec affirmHeader;

    public static final Map<String, Object> getAffirmParamKey() {
        return AffirmParamKey;
    }

    static {
        AffirmTextSpec affirmTextSpec = new AffirmTextSpec(new IdentifierSpec.Generic("affirm_header"));
        affirmHeader = affirmTextSpec;
        AffirmForm = LayoutSpec.Companion.create(affirmTextSpec);
    }

    public static final AffirmTextSpec getAffirmHeader() {
        return affirmHeader;
    }

    public static final LayoutSpec getAffirmForm() {
        return AffirmForm;
    }
}
