package com.stripe.android.ui.core.elements;

import com.braintreepayments.api.internal.GraphQLConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¨\u0006\u0003"}, d2 = {"convertTo4DigitDate", "", "input", "payments-ui-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: DateUtils.kt */
public final class DateUtilsKt {
    public static final String convertTo4DigitDate(String str) {
        Intrinsics.checkNotNullParameter(str, GraphQLConstants.Keys.INPUT);
        String stringPlus = Intrinsics.stringPlus("0", str);
        boolean z = true;
        if ((!(!StringsKt.isBlank(str)) || str.charAt(0) == '0' || str.charAt(0) == '1') && (str.length() <= 1 || str.charAt(0) != '1' || CharsKt.digitToInt(str.charAt(1)) <= 2)) {
            z = false;
        }
        if (!z) {
            stringPlus = null;
        }
        return stringPlus == null ? str : stringPlus;
    }
}
