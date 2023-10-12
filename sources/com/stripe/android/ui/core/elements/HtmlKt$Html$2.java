package com.stripe.android.ui.core.elements;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.compose.ui.text.AnnotatedString;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Html.kt */
final class HtmlKt$Html$2 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ AnnotatedString $annotatedText;
    final /* synthetic */ Context $context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HtmlKt$Html$2(AnnotatedString annotatedString, Context context) {
        super(1);
        this.$annotatedText = annotatedString;
        this.$context = context;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        AnnotatedString.Range range = (AnnotatedString.Range) CollectionsKt.firstOrNull(this.$annotatedText.getStringAnnotations("URL", i, i));
        if (range != null) {
            Context context = this.$context;
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse((String) range.getItem()));
            context.startActivity(intent);
        }
    }
}
