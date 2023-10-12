package com.stripe.android.ui.core.elements;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import com.stripe.android.model.CardBrand;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/stripe/android/ui/core/elements/CardNumberVisualTransformation;", "Landroidx/compose/ui/text/input/VisualTransformation;", "separator", "", "(C)V", "binBasedMaxPan", "", "getBinBasedMaxPan$payments_ui_core_release", "()Ljava/lang/Integer;", "setBinBasedMaxPan$payments_ui_core_release", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "filter", "Landroidx/compose/ui/text/input/TransformedText;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "space4and11", "space4and9and14", "space4and9and14and19", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CardNumberVisualTransformation.kt */
public final class CardNumberVisualTransformation implements VisualTransformation {
    private Integer binBasedMaxPan;
    private final char separator;

    public CardNumberVisualTransformation(char c) {
        this.separator = c;
    }

    public final Integer getBinBasedMaxPan$payments_ui_core_release() {
        return this.binBasedMaxPan;
    }

    public final void setBinBasedMaxPan$payments_ui_core_release(Integer num) {
        this.binBasedMaxPan = num;
    }

    public TransformedText filter(AnnotatedString annotatedString) {
        Intrinsics.checkNotNullParameter(annotatedString, "text");
        CardBrand fromCardNumber = CardBrand.Companion.fromCardNumber(annotatedString.getText());
        Integer num = this.binBasedMaxPan;
        int maxLengthForCardNumber = num == null ? fromCardNumber.getMaxLengthForCardNumber(annotatedString.getText()) : num.intValue();
        if (maxLengthForCardNumber == 19) {
            return space4and9and14and19(annotatedString);
        }
        switch (maxLengthForCardNumber) {
            case 14:
            case 15:
                return space4and11(annotatedString);
            case 16:
                return space4and9and14(annotatedString);
            default:
                return space4and9and14(annotatedString);
        }
    }

    private final TransformedText space4and11(AnnotatedString annotatedString) {
        int length = annotatedString.length();
        int i = 0;
        String str = "";
        while (i < length) {
            int i2 = i + 1;
            String stringPlus = Intrinsics.stringPlus(str, Character.valueOf(annotatedString.charAt(i)));
            if (i == 3 || i == 9) {
                str = Intrinsics.stringPlus(stringPlus, Character.valueOf(this.separator));
            } else {
                str = stringPlus;
            }
            i = i2;
        }
        return new TransformedText(new AnnotatedString(str, (List) null, (List) null, 6, (DefaultConstructorMarker) null), new CardNumberVisualTransformation$space4and11$creditCardOffsetTranslator$1());
    }

    private final TransformedText space4and9and14(AnnotatedString annotatedString) {
        int length = annotatedString.length();
        int i = 0;
        String str = "";
        while (i < length) {
            int i2 = i + 1;
            str = Intrinsics.stringPlus(str, Character.valueOf(annotatedString.charAt(i)));
            if (i % 4 == 3 && i < 15) {
                str = Intrinsics.stringPlus(str, Character.valueOf(this.separator));
            }
            i = i2;
        }
        return new TransformedText(new AnnotatedString(str, (List) null, (List) null, 6, (DefaultConstructorMarker) null), new CardNumberVisualTransformation$space4and9and14$creditCardOffsetTranslator$1());
    }

    private final TransformedText space4and9and14and19(AnnotatedString annotatedString) {
        int length = annotatedString.length();
        int i = 0;
        String str = "";
        while (i < length) {
            int i2 = i + 1;
            str = Intrinsics.stringPlus(str, Character.valueOf(annotatedString.charAt(i)));
            if (i % 4 == 3 && i < 19) {
                str = Intrinsics.stringPlus(str, Character.valueOf(this.separator));
            }
            i = i2;
        }
        return new TransformedText(new AnnotatedString(str, (List) null, (List) null, 6, (DefaultConstructorMarker) null), new CardNumberVisualTransformation$space4and9and14and19$creditCardOffsetTranslator$1());
    }
}
