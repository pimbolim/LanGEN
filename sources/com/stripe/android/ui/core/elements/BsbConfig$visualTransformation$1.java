package com.stripe.android.ui.core.elements;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Landroidx/compose/ui/text/input/TransformedText;", "text", "Landroidx/compose/ui/text/AnnotatedString;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BsbConfig.kt */
final class BsbConfig$visualTransformation$1 implements VisualTransformation {
    public static final BsbConfig$visualTransformation$1 INSTANCE = new BsbConfig$visualTransformation$1();

    BsbConfig$visualTransformation$1() {
    }

    public final TransformedText filter(AnnotatedString annotatedString) {
        Intrinsics.checkNotNullParameter(annotatedString, "text");
        StringBuilder sb = new StringBuilder();
        CharSequence text = annotatedString.getText();
        int i = 0;
        int i2 = 0;
        while (i < text.length()) {
            char charAt = text.charAt(i);
            i++;
            int i3 = i2 + 1;
            sb.append(charAt);
            if (i2 == 2) {
                sb.append(" - ");
            }
            i2 = i3;
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "output.toString()");
        return new TransformedText(new AnnotatedString(sb2, (List) null, (List) null, 6, (DefaultConstructorMarker) null), new BsbConfig$visualTransformation$1$filter$2(" - "));
    }
}
