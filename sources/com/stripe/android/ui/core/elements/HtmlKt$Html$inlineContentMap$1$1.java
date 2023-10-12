package com.stripe.android.ui.core.elements;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.res.StringResources_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Html.kt */
final class HtmlKt$Html$inlineContentMap$1$1 extends Lambda implements Function3<String, Composer, Integer, Unit> {
    final /* synthetic */ Painter $painter;
    final /* synthetic */ EmbeddableImage $value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HtmlKt$Html$inlineContentMap$1$1(EmbeddableImage embeddableImage, Painter painter) {
        super(3);
        this.$value = embeddableImage;
        this.$painter = painter;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((String) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(String str, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(str, "it");
        if (((i & 81) ^ 16) != 0 || !composer.getSkipping()) {
            Modifier fillMaxHeight$default = SizeKt.fillMaxHeight$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, 1, (Object) null);
            ImageKt.Image(this.$painter, StringResources_androidKt.stringResource(this.$value.getContentDescription(), composer, 0), fillMaxHeight$default, (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composer, 392, 120);
            return;
        }
        composer.skipToGroupEnd();
    }
}
