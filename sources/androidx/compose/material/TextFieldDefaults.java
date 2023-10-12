package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jç\u0001\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u00112\b\b\u0002\u0010\u0016\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00112\b\b\u0002\u0010\u0018\u001a\u00020\u00112\b\b\u0002\u0010\u0019\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u00112\b\b\u0002\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u00112\b\b\u0002\u0010\u001d\u001a\u00020\u00112\b\b\u0002\u0010\u001e\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u00112\b\b\u0002\u0010 \u001a\u00020\u00112\b\b\u0002\u0010!\u001a\u00020\u00112\b\b\u0002\u0010\"\u001a\u00020\u00112\b\b\u0002\u0010#\u001a\u00020\u00112\b\b\u0002\u0010$\u001a\u00020\u00112\b\b\u0002\u0010%\u001a\u00020\u0011H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b&\u0010'Jç\u0001\u0010(\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u00112\b\b\u0002\u0010)\u001a\u00020\u00112\b\b\u0002\u0010*\u001a\u00020\u00112\b\b\u0002\u0010+\u001a\u00020\u00112\b\b\u0002\u0010,\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u00112\b\b\u0002\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u00112\b\b\u0002\u0010\u001d\u001a\u00020\u00112\b\b\u0002\u0010\u001e\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u00112\b\b\u0002\u0010 \u001a\u00020\u00112\b\b\u0002\u0010!\u001a\u00020\u00112\b\b\u0002\u0010\"\u001a\u00020\u00112\b\b\u0002\u0010#\u001a\u00020\u00112\b\b\u0002\u0010$\u001a\u00020\u00112\b\b\u0002\u0010%\u001a\u00020\u0011H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b-\u0010'R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\tR\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006."}, d2 = {"Landroidx/compose/material/TextFieldDefaults;", "", "()V", "BackgroundOpacity", "", "IconOpacity", "MinHeight", "Landroidx/compose/ui/unit/Dp;", "getMinHeight-D9Ej5fM", "()F", "F", "MinWidth", "getMinWidth-D9Ej5fM", "UnfocusedIndicatorLineOpacity", "outlinedTextFieldColors", "Landroidx/compose/material/TextFieldColors;", "textColor", "Landroidx/compose/ui/graphics/Color;", "disabledTextColor", "backgroundColor", "cursorColor", "errorCursorColor", "focusedBorderColor", "unfocusedBorderColor", "disabledBorderColor", "errorBorderColor", "leadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "trailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "placeholderColor", "disabledPlaceholderColor", "outlinedTextFieldColors-dx8h9Zs", "(JJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIII)Landroidx/compose/material/TextFieldColors;", "textFieldColors", "focusedIndicatorColor", "unfocusedIndicatorColor", "disabledIndicatorColor", "errorIndicatorColor", "textFieldColors-dx8h9Zs", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextFieldDefaults.kt */
public final class TextFieldDefaults {
    public static final int $stable = 0;
    public static final float BackgroundOpacity = 0.12f;
    public static final TextFieldDefaults INSTANCE = new TextFieldDefaults();
    public static final float IconOpacity = 0.54f;
    private static final float MinHeight = Dp.m3859constructorimpl((float) 56);
    private static final float MinWidth = Dp.m3859constructorimpl((float) 280);
    public static final float UnfocusedIndicatorLineOpacity = 0.42f;

    private TextFieldDefaults() {
    }

    /* renamed from: getMinHeight-D9Ej5fM  reason: not valid java name */
    public final float m1163getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* renamed from: getMinWidth-D9Ej5fM  reason: not valid java name */
    public final float m1164getMinWidthD9Ej5fM() {
        return MinWidth;
    }

    /* renamed from: textFieldColors-dx8h9Zs  reason: not valid java name */
    public final TextFieldColors m1166textFieldColorsdx8h9Zs(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, Composer composer, int i, int i2, int i3, int i4) {
        long j22;
        Composer composer2 = composer;
        int i5 = i4;
        composer2.startReplaceableGroup(137434936);
        ComposerKt.sourceInformation(composer2, "C(textFieldColors)P(17:c#ui.graphics.Color,6:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,8:c#ui.graphics.Color,13:c#ui.graphics.Color,19:c#ui.graphics.Color,2:c#ui.graphics.Color,9:c#ui.graphics.Color,15:c#ui.graphics.Color,4:c#ui.graphics.Color,11:c#ui.graphics.Color,18:c#ui.graphics.Color,7:c#ui.graphics.Color,12:c#ui.graphics.Color,14:c#ui.graphics.Color,20:c#ui.graphics.Color,3:c#ui.graphics.Color,10:c#ui.graphics.Color,16:c#ui.graphics.Color,5:c#ui.graphics.Color)206@7234L7,206@7265L7,207@7338L8,208@7396L6,209@7489L6,210@7553L6,212@7632L6,212@7673L4,214@7747L6,215@7899L8,216@7961L6,218@8035L6,219@8164L8,222@8293L6,223@8424L8,224@8489L6,226@8564L6,226@8605L4,227@8663L6,227@8698L6,228@8781L8,229@8839L6,230@8901L6,230@8936L6,231@9022L8:TextFieldDefaults.kt#jmzs0o");
        if ((i5 & 1) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer2, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume = composer2.consume(ContentColorKt.getLocalContentColor());
            ComposerKt.sourceInformationMarkerEnd(composer);
            long r5 = ((Color) consume).m1606unboximpl();
            ComposerKt.sourceInformationMarkerStart(composer2, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = composer2.consume(ContentAlphaKt.getLocalContentAlpha());
            ComposerKt.sourceInformationMarkerEnd(composer);
            j22 = Color.m1595copywmQWz5c$default(r5, ((Number) consume2).floatValue(), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j22 = j;
        }
        long r7 = (i5 & 2) != 0 ? Color.m1595copywmQWz5c$default(j22, ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j2;
        long r33 = (i5 & 4) != 0 ? Color.m1595copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m913getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j3;
        long r9 = (i5 & 8) != 0 ? MaterialTheme.INSTANCE.getColors(composer2, 6).m914getPrimary0d7_KjU() : j4;
        long r13 = (i5 & 16) != 0 ? MaterialTheme.INSTANCE.getColors(composer2, 6).m908getError0d7_KjU() : j5;
        long r15 = (i5 & 32) != 0 ? Color.m1595copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m914getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j6;
        long r17 = (i5 & 64) != 0 ? Color.m1595copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m913getOnSurface0d7_KjU(), 0.42f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j7;
        long r19 = (i5 & 128) != 0 ? Color.m1595copywmQWz5c$default(r17, ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j8;
        long r21 = (i5 & 256) != 0 ? MaterialTheme.INSTANCE.getColors(composer2, 6).m908getError0d7_KjU() : j9;
        long r23 = (i5 & 512) != 0 ? Color.m1595copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m913getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j10;
        long r25 = (i5 & 1024) != 0 ? Color.m1595copywmQWz5c$default(r23, ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j11;
        long j23 = (i5 & 2048) != 0 ? r23 : j12;
        long r29 = (i5 & 4096) != 0 ? Color.m1595copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m913getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j13;
        long r31 = (i5 & 8192) != 0 ? Color.m1595copywmQWz5c$default(r29, ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j14;
        long r35 = (i5 & 16384) != 0 ? MaterialTheme.INSTANCE.getColors(composer2, 6).m908getError0d7_KjU() : j15;
        long r37 = (32768 & i5) != 0 ? Color.m1595copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m914getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j16;
        long r39 = (65536 & i5) != 0 ? Color.m1595copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m913getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j17;
        long r41 = (131072 & i5) != 0 ? Color.m1595copywmQWz5c$default(r39, ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j18;
        long r43 = (262144 & i5) != 0 ? MaterialTheme.INSTANCE.getColors(composer2, 6).m908getError0d7_KjU() : j19;
        long r45 = (524288 & i5) != 0 ? Color.m1595copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m913getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j20;
        DefaultTextFieldColors defaultTextFieldColors = new DefaultTextFieldColors(j22, r7, r9, r13, r15, r17, r21, r19, r23, r25, j23, r29, r31, r35, r33, r37, r39, r41, r43, r45, (i5 & 1048576) != 0 ? Color.m1595copywmQWz5c$default(r45, ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j21, (DefaultConstructorMarker) null);
        composer.endReplaceableGroup();
        return defaultTextFieldColors;
    }

    /* renamed from: outlinedTextFieldColors-dx8h9Zs  reason: not valid java name */
    public final TextFieldColors m1165outlinedTextFieldColorsdx8h9Zs(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, Composer composer, int i, int i2, int i3, int i4) {
        long j22;
        Composer composer2 = composer;
        int i5 = i4;
        composer2.startReplaceableGroup(-429563994);
        ComposerKt.sourceInformation(composer2, "C(outlinedTextFieldColors)P(17:c#ui.graphics.Color,6:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,9:c#ui.graphics.Color,13:c#ui.graphics.Color,19:c#ui.graphics.Color,2:c#ui.graphics.Color,8:c#ui.graphics.Color,15:c#ui.graphics.Color,4:c#ui.graphics.Color,11:c#ui.graphics.Color,18:c#ui.graphics.Color,7:c#ui.graphics.Color,12:c#ui.graphics.Color,14:c#ui.graphics.Color,20:c#ui.graphics.Color,3:c#ui.graphics.Color,10:c#ui.graphics.Color,16:c#ui.graphics.Color,5:c#ui.graphics.Color)264@10550L7,264@10581L7,265@10654L8,267@10760L6,268@10824L6,270@10900L6,270@10941L4,272@11012L6,272@11055L8,273@11150L8,274@11209L6,276@11283L6,277@11412L8,280@11541L6,281@11672L8,282@11737L6,284@11812L6,284@11853L4,285@11911L6,285@11946L6,286@12029L8,287@12087L6,288@12149L6,288@12184L6,289@12270L8:TextFieldDefaults.kt#jmzs0o");
        if ((i5 & 1) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer2, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume = composer2.consume(ContentColorKt.getLocalContentColor());
            ComposerKt.sourceInformationMarkerEnd(composer);
            long r5 = ((Color) consume).m1606unboximpl();
            ComposerKt.sourceInformationMarkerStart(composer2, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = composer2.consume(ContentAlphaKt.getLocalContentAlpha());
            ComposerKt.sourceInformationMarkerEnd(composer);
            j22 = Color.m1595copywmQWz5c$default(r5, ((Number) consume2).floatValue(), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j22 = j;
        }
        long r7 = (i5 & 2) != 0 ? Color.m1595copywmQWz5c$default(j22, ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j2;
        long r33 = (i5 & 4) != 0 ? Color.Companion.m1631getTransparent0d7_KjU() : j3;
        long r9 = (i5 & 8) != 0 ? MaterialTheme.INSTANCE.getColors(composer2, 6).m914getPrimary0d7_KjU() : j4;
        long r13 = (i5 & 16) != 0 ? MaterialTheme.INSTANCE.getColors(composer2, 6).m908getError0d7_KjU() : j5;
        long r15 = (i5 & 32) != 0 ? Color.m1595copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m914getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j6;
        long r17 = (i5 & 64) != 0 ? Color.m1595copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m913getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j7;
        long r19 = (i5 & 128) != 0 ? Color.m1595copywmQWz5c$default(r17, ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j8;
        long r21 = (i5 & 256) != 0 ? MaterialTheme.INSTANCE.getColors(composer2, 6).m908getError0d7_KjU() : j9;
        long r23 = (i5 & 512) != 0 ? Color.m1595copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m913getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j10;
        long r25 = (i5 & 1024) != 0 ? Color.m1595copywmQWz5c$default(r23, ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j11;
        long j23 = (i5 & 2048) != 0 ? r23 : j12;
        long r29 = (i5 & 4096) != 0 ? Color.m1595copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m913getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j13;
        long r31 = (i5 & 8192) != 0 ? Color.m1595copywmQWz5c$default(r29, ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j14;
        long r35 = (i5 & 16384) != 0 ? MaterialTheme.INSTANCE.getColors(composer2, 6).m908getError0d7_KjU() : j15;
        long r37 = (32768 & i5) != 0 ? Color.m1595copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m914getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j16;
        long r39 = (65536 & i5) != 0 ? Color.m1595copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m913getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j17;
        long r41 = (131072 & i5) != 0 ? Color.m1595copywmQWz5c$default(r39, ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j18;
        long r43 = (262144 & i5) != 0 ? MaterialTheme.INSTANCE.getColors(composer2, 6).m908getError0d7_KjU() : j19;
        long r45 = (524288 & i5) != 0 ? Color.m1595copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m913getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j20;
        DefaultTextFieldColors defaultTextFieldColors = new DefaultTextFieldColors(j22, r7, r9, r13, r15, r17, r21, r19, r23, r25, j23, r29, r31, r35, r33, r37, r39, r41, r43, r45, (i5 & 1048576) != 0 ? Color.m1595copywmQWz5c$default(r45, ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j21, (DefaultConstructorMarker) null);
        composer.endReplaceableGroup();
        return defaultTextFieldColors;
    }
}
