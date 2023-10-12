package com.stripe.android.ui.core.elements;

import androidx.compose.ui.text.input.OffsetMapping;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0006"}, d2 = {"com/stripe/android/ui/core/elements/IbanConfig$visualTransformation$1$filter$2", "Landroidx/compose/ui/text/input/OffsetMapping;", "originalToTransformed", "", "offset", "transformedToOriginal", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IbanConfig.kt */
public final class IbanConfig$visualTransformation$1$filter$2 implements OffsetMapping {
    IbanConfig$visualTransformation$1$filter$2() {
    }

    public int originalToTransformed(int i) {
        return i + (i / 4);
    }

    public int transformedToOriginal(int i) {
        return i - (i / 5);
    }
}
