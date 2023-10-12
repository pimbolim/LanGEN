package com.stripe.android.link.theme;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/stripe/android/link/theme/LinkColors;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Theme.kt */
final class ThemeKt$LocalColors$1 extends Lambda implements Function0<LinkColors> {
    public static final ThemeKt$LocalColors$1 INSTANCE = new ThemeKt$LocalColors$1();

    ThemeKt$LocalColors$1() {
        super(0);
    }

    public final LinkColors invoke() {
        return LinkThemeConfig.INSTANCE.colors(false);
    }
}
