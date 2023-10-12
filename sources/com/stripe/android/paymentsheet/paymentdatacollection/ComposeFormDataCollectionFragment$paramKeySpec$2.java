package com.stripe.android.paymentsheet.paymentdatacollection;

import com.stripe.android.paymentsheet.model.SupportedPaymentMethod;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ComposeFormDataCollectionFragment.kt */
final class ComposeFormDataCollectionFragment$paramKeySpec$2 extends Lambda implements Function0<Map<String, Object>> {
    final /* synthetic */ ComposeFormDataCollectionFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ComposeFormDataCollectionFragment$paramKeySpec$2(ComposeFormDataCollectionFragment composeFormDataCollectionFragment) {
        super(0);
        this.this$0 = composeFormDataCollectionFragment;
    }

    public final Map<String, Object> invoke() {
        SupportedPaymentMethod paymentMethod;
        FormFragmentArguments formFragmentArguments = (FormFragmentArguments) this.this$0.requireArguments().getParcelable(ComposeFormDataCollectionFragment.EXTRA_CONFIG);
        Map<String, Object> map = null;
        if (!(formFragmentArguments == null || (paymentMethod = formFragmentArguments.getPaymentMethod()) == null)) {
            map = paymentMethod.getParamKey();
        }
        if (map != null) {
            return map;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
