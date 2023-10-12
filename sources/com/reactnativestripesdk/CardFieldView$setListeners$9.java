package com.reactnativestripesdk;

import android.text.Editable;
import android.text.TextWatcher;
import kotlin.Metadata;
import kotlin.text.StringsKt;
import org.apache.commons.lang3.StringUtils;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH\u0016¨\u0006\u0011"}, d2 = {"com/reactnativestripesdk/CardFieldView$setListeners$9", "Landroid/text/TextWatcher;", "afterTextChanged", "", "p0", "Landroid/text/Editable;", "beforeTextChanged", "", "p1", "", "p2", "p3", "onTextChanged", "var1", "var2", "var3", "var4", "stripe_stripe-react-native_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CardFieldView.kt */
public final class CardFieldView$setListeners$9 implements TextWatcher {
    final /* synthetic */ CardFieldView this$0;

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    CardFieldView$setListeners$9(CardFieldView cardFieldView) {
        this.this$0 = cardFieldView;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.this$0.dangerouslyGetFullCardDetails) {
            this.this$0.getCardDetails().put("number", StringsKt.replace$default(String.valueOf(charSequence), StringUtils.SPACE, "", false, 4, (Object) null));
        }
        this.this$0.sendCardDetailsEvent();
    }
}
