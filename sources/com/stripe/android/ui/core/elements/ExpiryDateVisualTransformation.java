package com.stripe.android.ui.core.elements;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/stripe/android/ui/core/elements/ExpiryDateVisualTransformation;", "Landroidx/compose/ui/text/input/VisualTransformation;", "()V", "separator", "", "filter", "Landroidx/compose/ui/text/input/TransformedText;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ExpiryDateVisualTransformation.kt */
public final class ExpiryDateVisualTransformation implements VisualTransformation {
    /* access modifiers changed from: private */
    public final String separator = " / ";

    public TransformedText filter(AnnotatedString annotatedString) {
        Intrinsics.checkNotNullParameter(annotatedString, "text");
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = 1;
        int i = 0;
        if ((!StringsKt.isBlank(annotatedString)) && annotatedString.charAt(0) != '0' && annotatedString.charAt(0) != '1') {
            intRef.element = 0;
        } else if (annotatedString.length() > 1 && annotatedString.charAt(0) == '1' && CharsKt.digitToInt(annotatedString.charAt(1)) > 2) {
            intRef.element = 0;
        }
        int length = annotatedString.length();
        String str = "";
        while (i < length) {
            int i2 = i + 1;
            str = Intrinsics.stringPlus(str, Character.valueOf(annotatedString.charAt(i)));
            if (i == intRef.element) {
                str = Intrinsics.stringPlus(str, this.separator);
            }
            i = i2;
        }
        return new TransformedText(new AnnotatedString(str, (List) null, (List) null, 6, (DefaultConstructorMarker) null), new ExpiryDateVisualTransformation$filter$offsetTranslator$1(intRef, this));
    }
}
