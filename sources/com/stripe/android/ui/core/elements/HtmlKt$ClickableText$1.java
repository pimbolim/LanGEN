package com.stripe.android.ui.core.elements;

import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Html.kt */
final class HtmlKt$ClickableText$1 extends Lambda implements Function1<TextLayoutResult, Unit> {
    public static final HtmlKt$ClickableText$1 INSTANCE = new HtmlKt$ClickableText$1();

    HtmlKt$ClickableText$1() {
        super(1);
    }

    public final void invoke(TextLayoutResult textLayoutResult) {
        Intrinsics.checkNotNullParameter(textLayoutResult, "it");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TextLayoutResult) obj);
        return Unit.INSTANCE;
    }
}
