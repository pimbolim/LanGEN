package com.stripe.android.link.theme;

import androidx.compose.material.MaterialTheme;
import androidx.compose.material.TextFieldColors;
import androidx.compose.material.TextFieldDefaults;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a*\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0015¢\u0006\u0002\b\u0016H\u0001¢\u0006\u0002\u0010\u0017\u001a\r\u0010\u0018\u001a\u00020\u0019H\u0001¢\u0006\u0002\u0010\u001a\"\u0019\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\"\u0019\u0010\u0005\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0006\u0010\u0003\"\u0019\u0010\u0007\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\b\u0010\u0003\"\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000\"\u0018\u0010\f\u001a\u00020\u000b*\u00020\r8AX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"AppBarHeight", "Landroidx/compose/ui/unit/Dp;", "getAppBarHeight", "()F", "F", "CloseIconWidth", "getCloseIconWidth", "HorizontalPadding", "getHorizontalPadding", "LocalColors", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Lcom/stripe/android/link/theme/LinkColors;", "linkColors", "Landroidx/compose/material/MaterialTheme;", "getLinkColors", "(Landroidx/compose/material/MaterialTheme;Landroidx/compose/runtime/Composer;I)Lcom/stripe/android/link/theme/LinkColors;", "DefaultLinkTheme", "", "darkTheme", "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "linkTextFieldColors", "Landroidx/compose/material/TextFieldColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material/TextFieldColors;", "link_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Theme.kt */
public final class ThemeKt {
    private static final float AppBarHeight = Dp.m3859constructorimpl((float) 56);
    private static final float CloseIconWidth = Dp.m3859constructorimpl((float) 24);
    private static final float HorizontalPadding = Dp.m3859constructorimpl((float) 20);
    private static final ProvidableCompositionLocal<LinkColors> LocalColors = CompositionLocalKt.staticCompositionLocalOf(ThemeKt$LocalColors$1.INSTANCE);

    public static final float getCloseIconWidth() {
        return CloseIconWidth;
    }

    public static final float getAppBarHeight() {
        return AppBarHeight;
    }

    public static final float getHorizontalPadding() {
        return HorizontalPadding;
    }

    public static final TextFieldColors linkTextFieldColors(Composer composer, int i) {
        Composer composer2 = composer;
        composer2.startReplaceableGroup(-327103516);
        TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
        long r5 = MaterialTheme.INSTANCE.getColors(composer2, 8).m907getBackground0d7_KjU();
        long r11 = Color.Companion.m1631getTransparent0d7_KjU();
        long r15 = Color.Companion.m1631getTransparent0d7_KjU();
        TextFieldColors r0 = textFieldDefaults.m1166textFieldColorsdx8h9Zs(0, 0, r5, 0, 0, r11, Color.Companion.m1631getTransparent0d7_KjU(), r15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, composer, 14352384, 0, 64, 2096923);
        composer.endReplaceableGroup();
        return r0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x005c, code lost:
        if ((r10 & 1) != 0) goto L_0x0067;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void DefaultLinkTheme(boolean r6, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r7, androidx.compose.runtime.Composer r8, int r9, int r10) {
        /*
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = -1354420935(0xffffffffaf452d39, float:-1.7933112E-10)
            androidx.compose.runtime.Composer r8 = r8.startRestartGroup(r0)
            r0 = r9 & 14
            if (r0 != 0) goto L_0x001f
            r0 = r10 & 1
            if (r0 != 0) goto L_0x001c
            boolean r0 = r8.changed((boolean) r6)
            if (r0 == 0) goto L_0x001c
            r0 = 4
            goto L_0x001d
        L_0x001c:
            r0 = 2
        L_0x001d:
            r0 = r0 | r9
            goto L_0x0020
        L_0x001f:
            r0 = r9
        L_0x0020:
            r1 = r10 & 2
            if (r1 == 0) goto L_0x0027
            r0 = r0 | 48
            goto L_0x0037
        L_0x0027:
            r1 = r9 & 112(0x70, float:1.57E-43)
            if (r1 != 0) goto L_0x0037
            boolean r1 = r8.changed((java.lang.Object) r7)
            if (r1 == 0) goto L_0x0034
            r1 = 32
            goto L_0x0036
        L_0x0034:
            r1 = 16
        L_0x0036:
            r0 = r0 | r1
        L_0x0037:
            r1 = r0 & 91
            r1 = r1 ^ 18
            if (r1 != 0) goto L_0x0048
            boolean r1 = r8.getSkipping()
            if (r1 != 0) goto L_0x0044
            goto L_0x0048
        L_0x0044:
            r8.skipToGroupEnd()
            goto L_0x0090
        L_0x0048:
            r8.startDefaults()
            r1 = r9 & 1
            r2 = 0
            if (r1 == 0) goto L_0x005f
            boolean r1 = r8.getDefaultsInvalid()
            if (r1 == 0) goto L_0x0057
            goto L_0x005f
        L_0x0057:
            r8.skipToGroupEnd()
            r1 = r10 & 1
            if (r1 == 0) goto L_0x0069
            goto L_0x0067
        L_0x005f:
            r1 = r10 & 1
            if (r1 == 0) goto L_0x0069
            boolean r6 = androidx.compose.foundation.DarkThemeKt.isSystemInDarkTheme(r8, r2)
        L_0x0067:
            r0 = r0 & -15
        L_0x0069:
            r8.endDefaults()
            com.stripe.android.link.theme.LinkThemeConfig r1 = com.stripe.android.link.theme.LinkThemeConfig.INSTANCE
            com.stripe.android.link.theme.LinkColors r1 = r1.colors(r6)
            r3 = 1
            androidx.compose.runtime.ProvidedValue[] r4 = new androidx.compose.runtime.ProvidedValue[r3]
            androidx.compose.runtime.ProvidableCompositionLocal<com.stripe.android.link.theme.LinkColors> r5 = LocalColors
            androidx.compose.runtime.ProvidedValue r5 = r5.provides(r1)
            r4[r2] = r5
            r2 = -819895737(0xffffffffcf216247, float:-2.70757248E9)
            com.stripe.android.link.theme.ThemeKt$DefaultLinkTheme$1 r5 = new com.stripe.android.link.theme.ThemeKt$DefaultLinkTheme$1
            r5.<init>(r1, r7, r0)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r8, r2, r3, r5)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = 56
            androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider((androidx.compose.runtime.ProvidedValue<?>[]) r4, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r0, (androidx.compose.runtime.Composer) r8, (int) r1)
        L_0x0090:
            androidx.compose.runtime.ScopeUpdateScope r8 = r8.endRestartGroup()
            if (r8 != 0) goto L_0x0097
            goto L_0x00a1
        L_0x0097:
            com.stripe.android.link.theme.ThemeKt$DefaultLinkTheme$2 r0 = new com.stripe.android.link.theme.ThemeKt$DefaultLinkTheme$2
            r0.<init>(r6, r7, r9, r10)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r8.updateScope(r0)
        L_0x00a1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.link.theme.ThemeKt.DefaultLinkTheme(boolean, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final LinkColors getLinkColors(MaterialTheme materialTheme, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(materialTheme, "<this>");
        ComposerKt.sourceInformationMarkerStart(composer, 103361330, "C:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(LocalColors);
        ComposerKt.sourceInformationMarkerEnd(composer);
        return (LinkColors) consume;
    }
}
