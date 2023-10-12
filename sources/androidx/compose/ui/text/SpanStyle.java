package androidx.compose.ui.text;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B¨\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bø\u0001\u0000¢\u0006\u0002\u0010\u001cJ³\u0001\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b8\u00109J\u0013\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010=\u001a\u00020>H\u0016J\u0014\u0010?\u001a\u00020\u00002\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0000H\u0007J\u0011\u0010@\u001a\u00020\u00002\u0006\u0010<\u001a\u00020\u0000H\u0002J\b\u0010A\u001a\u00020\u000fH\u0016R\u001c\u0010\u0017\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\"\u0010\u001eR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u001c\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b'\u0010\u001eR\u001c\u0010\b\u001a\u0004\u0018\u00010\tø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u001c\u0010\u0010\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b.\u0010\u001eR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b5\u00106\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006B"}, d2 = {"Landroidx/compose/ui/text/SpanStyle;", "", "color", "Landroidx/compose/ui/graphics/Color;", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "fontFeatureSettings", "", "letterSpacing", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "textGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "background", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBackground-0d7_KjU", "()J", "J", "getBaselineShift-5SSeXJ0", "()Landroidx/compose/ui/text/style/BaselineShift;", "getColor-0d7_KjU", "getFontFamily", "()Landroidx/compose/ui/text/font/FontFamily;", "getFontFeatureSettings", "()Ljava/lang/String;", "getFontSize-XSAIIZE", "getFontStyle-4Lr2A7w", "()Landroidx/compose/ui/text/font/FontStyle;", "getFontSynthesis-ZQGJjVo", "()Landroidx/compose/ui/text/font/FontSynthesis;", "getFontWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "getLetterSpacing-XSAIIZE", "getLocaleList", "()Landroidx/compose/ui/text/intl/LocaleList;", "getShadow", "()Landroidx/compose/ui/graphics/Shadow;", "getTextDecoration", "()Landroidx/compose/ui/text/style/TextDecoration;", "getTextGeometricTransform", "()Landroidx/compose/ui/text/style/TextGeometricTransform;", "copy", "copy-IuqyXdg", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;)Landroidx/compose/ui/text/SpanStyle;", "equals", "", "other", "hashCode", "", "merge", "plus", "toString", "ui-text_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SpanStyle.kt */
public final class SpanStyle {
    private final long background;
    private final BaselineShift baselineShift;
    private final long color;
    private final FontFamily fontFamily;
    private final String fontFeatureSettings;
    private final long fontSize;
    private final FontStyle fontStyle;
    private final FontSynthesis fontSynthesis;
    private final FontWeight fontWeight;
    private final long letterSpacing;
    private final LocaleList localeList;
    private final Shadow shadow;
    private final TextDecoration textDecoration;
    private final TextGeometricTransform textGeometricTransform;

    public /* synthetic */ SpanStyle(long j, long j2, FontWeight fontWeight2, FontStyle fontStyle2, FontSynthesis fontSynthesis2, FontFamily fontFamily2, String str, long j3, BaselineShift baselineShift2, TextGeometricTransform textGeometricTransform2, LocaleList localeList2, long j4, TextDecoration textDecoration2, Shadow shadow2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, fontWeight2, fontStyle2, fontSynthesis2, fontFamily2, str, j3, baselineShift2, textGeometricTransform2, localeList2, j4, textDecoration2, shadow2);
    }

    private SpanStyle(long j, long j2, FontWeight fontWeight2, FontStyle fontStyle2, FontSynthesis fontSynthesis2, FontFamily fontFamily2, String str, long j3, BaselineShift baselineShift2, TextGeometricTransform textGeometricTransform2, LocaleList localeList2, long j4, TextDecoration textDecoration2, Shadow shadow2) {
        this.color = j;
        this.fontSize = j2;
        this.fontWeight = fontWeight2;
        this.fontStyle = fontStyle2;
        this.fontSynthesis = fontSynthesis2;
        this.fontFamily = fontFamily2;
        this.fontFeatureSettings = str;
        this.letterSpacing = j3;
        this.baselineShift = baselineShift2;
        this.textGeometricTransform = textGeometricTransform2;
        this.localeList = localeList2;
        this.background = j4;
        this.textDecoration = textDecoration2;
        this.shadow = shadow2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SpanStyle(long r20, long r22, androidx.compose.ui.text.font.FontWeight r24, androidx.compose.ui.text.font.FontStyle r25, androidx.compose.ui.text.font.FontSynthesis r26, androidx.compose.ui.text.font.FontFamily r27, java.lang.String r28, long r29, androidx.compose.ui.text.style.BaselineShift r31, androidx.compose.ui.text.style.TextGeometricTransform r32, androidx.compose.ui.text.intl.LocaleList r33, long r34, androidx.compose.ui.text.style.TextDecoration r36, androidx.compose.ui.graphics.Shadow r37, int r38, kotlin.jvm.internal.DefaultConstructorMarker r39) {
        /*
            r19 = this;
            r0 = r38
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000d
            androidx.compose.ui.graphics.Color$Companion r1 = androidx.compose.ui.graphics.Color.Companion
            long r1 = r1.m1632getUnspecified0d7_KjU()
            goto L_0x000f
        L_0x000d:
            r1 = r20
        L_0x000f:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x001a
            androidx.compose.ui.unit.TextUnit$Companion r3 = androidx.compose.ui.unit.TextUnit.Companion
            long r3 = r3.m4051getUnspecifiedXSAIIZE()
            goto L_0x001c
        L_0x001a:
            r3 = r22
        L_0x001c:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x0022
            r5 = 0
            goto L_0x0024
        L_0x0022:
            r5 = r24
        L_0x0024:
            r7 = r0 & 8
            if (r7 == 0) goto L_0x002a
            r7 = 0
            goto L_0x002c
        L_0x002a:
            r7 = r25
        L_0x002c:
            r8 = r0 & 16
            if (r8 == 0) goto L_0x0032
            r8 = 0
            goto L_0x0034
        L_0x0032:
            r8 = r26
        L_0x0034:
            r9 = r0 & 32
            if (r9 == 0) goto L_0x003a
            r9 = 0
            goto L_0x003c
        L_0x003a:
            r9 = r27
        L_0x003c:
            r10 = r0 & 64
            if (r10 == 0) goto L_0x0042
            r10 = 0
            goto L_0x0044
        L_0x0042:
            r10 = r28
        L_0x0044:
            r11 = r0 & 128(0x80, float:1.794E-43)
            if (r11 == 0) goto L_0x004f
            androidx.compose.ui.unit.TextUnit$Companion r11 = androidx.compose.ui.unit.TextUnit.Companion
            long r11 = r11.m4051getUnspecifiedXSAIIZE()
            goto L_0x0051
        L_0x004f:
            r11 = r29
        L_0x0051:
            r13 = r0 & 256(0x100, float:3.59E-43)
            if (r13 == 0) goto L_0x0057
            r13 = 0
            goto L_0x0059
        L_0x0057:
            r13 = r31
        L_0x0059:
            r14 = r0 & 512(0x200, float:7.175E-43)
            if (r14 == 0) goto L_0x005f
            r14 = 0
            goto L_0x0061
        L_0x005f:
            r14 = r32
        L_0x0061:
            r15 = r0 & 1024(0x400, float:1.435E-42)
            if (r15 == 0) goto L_0x0067
            r15 = 0
            goto L_0x0069
        L_0x0067:
            r15 = r33
        L_0x0069:
            r6 = r0 & 2048(0x800, float:2.87E-42)
            if (r6 == 0) goto L_0x0074
            androidx.compose.ui.graphics.Color$Companion r6 = androidx.compose.ui.graphics.Color.Companion
            long r16 = r6.m1632getUnspecified0d7_KjU()
            goto L_0x0076
        L_0x0074:
            r16 = r34
        L_0x0076:
            r6 = r0 & 4096(0x1000, float:5.74E-42)
            if (r6 == 0) goto L_0x007c
            r6 = 0
            goto L_0x007e
        L_0x007c:
            r6 = r36
        L_0x007e:
            r0 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x0084
            r0 = 0
            goto L_0x0086
        L_0x0084:
            r0 = r37
        L_0x0086:
            r18 = 0
            r39 = r18
            r20 = r19
            r21 = r1
            r23 = r3
            r25 = r5
            r26 = r7
            r27 = r8
            r28 = r9
            r29 = r10
            r30 = r11
            r32 = r13
            r33 = r14
            r34 = r15
            r35 = r16
            r37 = r6
            r38 = r0
            r20.<init>(r21, r23, r25, r26, r27, r28, r29, r30, r32, r33, r34, r35, r37, r38, r39)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.SpanStyle.<init>(long, long, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontSynthesis, androidx.compose.ui.text.font.FontFamily, java.lang.String, long, androidx.compose.ui.text.style.BaselineShift, androidx.compose.ui.text.style.TextGeometricTransform, androidx.compose.ui.text.intl.LocaleList, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.graphics.Shadow, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* renamed from: getColor-0d7_KjU  reason: not valid java name */
    public final long m3542getColor0d7_KjU() {
        return this.color;
    }

    /* renamed from: getFontSize-XSAIIZE  reason: not valid java name */
    public final long m3543getFontSizeXSAIIZE() {
        return this.fontSize;
    }

    public final FontWeight getFontWeight() {
        return this.fontWeight;
    }

    /* renamed from: getFontStyle-4Lr2A7w  reason: not valid java name */
    public final FontStyle m3544getFontStyle4Lr2A7w() {
        return this.fontStyle;
    }

    /* renamed from: getFontSynthesis-ZQGJjVo  reason: not valid java name */
    public final FontSynthesis m3545getFontSynthesisZQGJjVo() {
        return this.fontSynthesis;
    }

    public final FontFamily getFontFamily() {
        return this.fontFamily;
    }

    public final String getFontFeatureSettings() {
        return this.fontFeatureSettings;
    }

    /* renamed from: getLetterSpacing-XSAIIZE  reason: not valid java name */
    public final long m3546getLetterSpacingXSAIIZE() {
        return this.letterSpacing;
    }

    /* renamed from: getBaselineShift-5SSeXJ0  reason: not valid java name */
    public final BaselineShift m3541getBaselineShift5SSeXJ0() {
        return this.baselineShift;
    }

    public final TextGeometricTransform getTextGeometricTransform() {
        return this.textGeometricTransform;
    }

    public final LocaleList getLocaleList() {
        return this.localeList;
    }

    /* renamed from: getBackground-0d7_KjU  reason: not valid java name */
    public final long m3540getBackground0d7_KjU() {
        return this.background;
    }

    public final TextDecoration getTextDecoration() {
        return this.textDecoration;
    }

    public final Shadow getShadow() {
        return this.shadow;
    }

    public static /* synthetic */ SpanStyle merge$default(SpanStyle spanStyle, SpanStyle spanStyle2, int i, Object obj) {
        if ((i & 1) != 0) {
            spanStyle2 = null;
        }
        return spanStyle.merge(spanStyle2);
    }

    public final SpanStyle merge(SpanStyle spanStyle) {
        long j;
        SpanStyle spanStyle2 = spanStyle;
        if (spanStyle2 == null) {
            return this;
        }
        long r2 = spanStyle.m3542getColor0d7_KjU();
        boolean z = true;
        if (!(r2 != Color.Companion.m1632getUnspecified0d7_KjU())) {
            r2 = m3542getColor0d7_KjU();
        }
        long j2 = r2;
        FontFamily fontFamily2 = spanStyle2.fontFamily;
        if (fontFamily2 == null) {
            fontFamily2 = this.fontFamily;
        }
        FontFamily fontFamily3 = fontFamily2;
        long r11 = !TextUnitKt.m4058isUnspecifiedR2X_6o(spanStyle.m3543getFontSizeXSAIIZE()) ? spanStyle.m3543getFontSizeXSAIIZE() : m3543getFontSizeXSAIIZE();
        FontWeight fontWeight2 = spanStyle2.fontWeight;
        if (fontWeight2 == null) {
            fontWeight2 = this.fontWeight;
        }
        FontWeight fontWeight3 = fontWeight2;
        FontStyle r22 = spanStyle.m3544getFontStyle4Lr2A7w();
        if (r22 == null) {
            r22 = m3544getFontStyle4Lr2A7w();
        }
        FontStyle fontStyle2 = r22;
        FontSynthesis r23 = spanStyle.m3545getFontSynthesisZQGJjVo();
        if (r23 == null) {
            r23 = m3545getFontSynthesisZQGJjVo();
        }
        FontSynthesis fontSynthesis2 = r23;
        String str = spanStyle2.fontFeatureSettings;
        if (str == null) {
            str = this.fontFeatureSettings;
        }
        String str2 = str;
        if (!TextUnitKt.m4058isUnspecifiedR2X_6o(spanStyle.m3546getLetterSpacingXSAIIZE())) {
            j = spanStyle.m3546getLetterSpacingXSAIIZE();
        } else {
            j = m3546getLetterSpacingXSAIIZE();
        }
        long j3 = j;
        BaselineShift r24 = spanStyle.m3541getBaselineShift5SSeXJ0();
        if (r24 == null) {
            r24 = m3541getBaselineShift5SSeXJ0();
        }
        BaselineShift baselineShift2 = r24;
        TextGeometricTransform textGeometricTransform2 = spanStyle2.textGeometricTransform;
        if (textGeometricTransform2 == null) {
            textGeometricTransform2 = this.textGeometricTransform;
        }
        TextGeometricTransform textGeometricTransform3 = textGeometricTransform2;
        LocaleList localeList2 = spanStyle2.localeList;
        if (localeList2 == null) {
            localeList2 = this.localeList;
        }
        LocaleList localeList3 = localeList2;
        long r25 = spanStyle.m3540getBackground0d7_KjU();
        if (r25 == Color.Companion.m1632getUnspecified0d7_KjU()) {
            z = false;
        }
        if (!z) {
            r25 = m3540getBackground0d7_KjU();
        }
        long j4 = r25;
        TextDecoration textDecoration2 = spanStyle2.textDecoration;
        if (textDecoration2 == null) {
            textDecoration2 = this.textDecoration;
        }
        TextDecoration textDecoration3 = textDecoration2;
        Shadow shadow2 = spanStyle2.shadow;
        if (shadow2 == null) {
            shadow2 = this.shadow;
        }
        return new SpanStyle(j2, r11, fontWeight3, fontStyle2, fontSynthesis2, fontFamily3, str2, j3, baselineShift2, textGeometricTransform3, localeList3, j4, textDecoration3, shadow2, (DefaultConstructorMarker) null);
    }

    public final SpanStyle plus(SpanStyle spanStyle) {
        Intrinsics.checkNotNullParameter(spanStyle, "other");
        return merge(spanStyle);
    }

    /* renamed from: copy-IuqyXdg$default  reason: not valid java name */
    public static /* synthetic */ SpanStyle m3538copyIuqyXdg$default(SpanStyle spanStyle, long j, long j2, FontWeight fontWeight2, FontStyle fontStyle2, FontSynthesis fontSynthesis2, FontFamily fontFamily2, String str, long j3, BaselineShift baselineShift2, TextGeometricTransform textGeometricTransform2, LocaleList localeList2, long j4, TextDecoration textDecoration2, Shadow shadow2, int i, Object obj) {
        FontSynthesis fontSynthesis3;
        BaselineShift baselineShift3;
        TextGeometricTransform textGeometricTransform3;
        long j5;
        SpanStyle spanStyle2 = spanStyle;
        int i2 = i;
        long r2 = (i2 & 1) != 0 ? spanStyle.m3542getColor0d7_KjU() : j;
        long r4 = (i2 & 2) != 0 ? spanStyle.m3543getFontSizeXSAIIZE() : j2;
        FontWeight fontWeight3 = (i2 & 4) != 0 ? spanStyle2.fontWeight : fontWeight2;
        FontStyle r7 = (i2 & 8) != 0 ? spanStyle.m3544getFontStyle4Lr2A7w() : fontStyle2;
        if ((i2 & 16) != 0) {
            fontSynthesis3 = spanStyle.m3545getFontSynthesisZQGJjVo();
        } else {
            fontSynthesis3 = fontSynthesis2;
        }
        FontFamily fontFamily3 = (i2 & 32) != 0 ? spanStyle2.fontFamily : fontFamily2;
        String str2 = (i2 & 64) != 0 ? spanStyle2.fontFeatureSettings : str;
        long r11 = (i2 & 128) != 0 ? spanStyle.m3546getLetterSpacingXSAIIZE() : j3;
        if ((i2 & 256) != 0) {
            baselineShift3 = spanStyle.m3541getBaselineShift5SSeXJ0();
        } else {
            baselineShift3 = baselineShift2;
        }
        if ((i2 & 512) != 0) {
            textGeometricTransform3 = spanStyle2.textGeometricTransform;
        } else {
            textGeometricTransform3 = textGeometricTransform2;
        }
        LocaleList localeList3 = (i2 & 1024) != 0 ? spanStyle2.localeList : localeList2;
        if ((i2 & 2048) != 0) {
            j5 = spanStyle.m3540getBackground0d7_KjU();
        } else {
            j5 = j4;
        }
        return spanStyle.m3539copyIuqyXdg(r2, r4, fontWeight3, r7, fontSynthesis3, fontFamily3, str2, r11, baselineShift3, textGeometricTransform3, localeList3, j5, (i2 & 4096) != 0 ? spanStyle2.textDecoration : textDecoration2, (i2 & 8192) != 0 ? spanStyle2.shadow : shadow2);
    }

    /* renamed from: copy-IuqyXdg  reason: not valid java name */
    public final SpanStyle m3539copyIuqyXdg(long j, long j2, FontWeight fontWeight2, FontStyle fontStyle2, FontSynthesis fontSynthesis2, FontFamily fontFamily2, String str, long j3, BaselineShift baselineShift2, TextGeometricTransform textGeometricTransform2, LocaleList localeList2, long j4, TextDecoration textDecoration2, Shadow shadow2) {
        return new SpanStyle(j, j2, fontWeight2, fontStyle2, fontSynthesis2, fontFamily2, str, j3, baselineShift2, textGeometricTransform2, localeList2, j4, textDecoration2, shadow2, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SpanStyle)) {
            return false;
        }
        SpanStyle spanStyle = (SpanStyle) obj;
        return Color.m1597equalsimpl0(m3542getColor0d7_KjU(), spanStyle.m3542getColor0d7_KjU()) && TextUnit.m4037equalsimpl0(m3543getFontSizeXSAIIZE(), spanStyle.m3543getFontSizeXSAIIZE()) && Intrinsics.areEqual((Object) this.fontWeight, (Object) spanStyle.fontWeight) && Intrinsics.areEqual((Object) m3544getFontStyle4Lr2A7w(), (Object) spanStyle.m3544getFontStyle4Lr2A7w()) && Intrinsics.areEqual((Object) m3545getFontSynthesisZQGJjVo(), (Object) spanStyle.m3545getFontSynthesisZQGJjVo()) && Intrinsics.areEqual((Object) this.fontFamily, (Object) spanStyle.fontFamily) && Intrinsics.areEqual((Object) this.fontFeatureSettings, (Object) spanStyle.fontFeatureSettings) && TextUnit.m4037equalsimpl0(m3546getLetterSpacingXSAIIZE(), spanStyle.m3546getLetterSpacingXSAIIZE()) && Intrinsics.areEqual((Object) m3541getBaselineShift5SSeXJ0(), (Object) spanStyle.m3541getBaselineShift5SSeXJ0()) && Intrinsics.areEqual((Object) this.textGeometricTransform, (Object) spanStyle.textGeometricTransform) && Intrinsics.areEqual((Object) this.localeList, (Object) spanStyle.localeList) && Color.m1597equalsimpl0(m3540getBackground0d7_KjU(), spanStyle.m3540getBackground0d7_KjU()) && Intrinsics.areEqual((Object) this.textDecoration, (Object) spanStyle.textDecoration) && Intrinsics.areEqual((Object) this.shadow, (Object) spanStyle.shadow);
    }

    public int hashCode() {
        int r0 = ((Color.m1603hashCodeimpl(m3542getColor0d7_KjU()) * 31) + TextUnit.m4041hashCodeimpl(m3543getFontSizeXSAIIZE())) * 31;
        FontWeight fontWeight2 = this.fontWeight;
        int i = 0;
        int hashCode = (r0 + (fontWeight2 == null ? 0 : fontWeight2.hashCode())) * 31;
        FontStyle r1 = m3544getFontStyle4Lr2A7w();
        int r02 = (hashCode + (r1 == null ? 0 : FontStyle.m3613hashCodeimpl(r1.m3615unboximpl()))) * 31;
        FontSynthesis r12 = m3545getFontSynthesisZQGJjVo();
        int r03 = (r02 + (r12 == null ? 0 : FontSynthesis.m3622hashCodeimpl(r12.m3626unboximpl()))) * 31;
        FontFamily fontFamily2 = this.fontFamily;
        int hashCode2 = (r03 + (fontFamily2 == null ? 0 : fontFamily2.hashCode())) * 31;
        String str = this.fontFeatureSettings;
        int hashCode3 = (((hashCode2 + (str == null ? 0 : str.hashCode())) * 31) + TextUnit.m4041hashCodeimpl(m3546getLetterSpacingXSAIIZE())) * 31;
        BaselineShift r13 = m3541getBaselineShift5SSeXJ0();
        int r04 = (hashCode3 + (r13 == null ? 0 : BaselineShift.m3739hashCodeimpl(r13.m3741unboximpl()))) * 31;
        TextGeometricTransform textGeometricTransform2 = this.textGeometricTransform;
        int hashCode4 = (r04 + (textGeometricTransform2 == null ? 0 : textGeometricTransform2.hashCode())) * 31;
        LocaleList localeList2 = this.localeList;
        int hashCode5 = (((hashCode4 + (localeList2 == null ? 0 : localeList2.hashCode())) * 31) + Color.m1603hashCodeimpl(m3540getBackground0d7_KjU())) * 31;
        TextDecoration textDecoration2 = this.textDecoration;
        int hashCode6 = (hashCode5 + (textDecoration2 == null ? 0 : textDecoration2.hashCode())) * 31;
        Shadow shadow2 = this.shadow;
        if (shadow2 != null) {
            i = shadow2.hashCode();
        }
        return hashCode6 + i;
    }

    public String toString() {
        return "SpanStyle(color=" + Color.m1604toStringimpl(m3542getColor0d7_KjU()) + ", fontSize=" + TextUnit.m4047toStringimpl(m3543getFontSizeXSAIIZE()) + ", fontWeight=" + this.fontWeight + ", fontStyle=" + m3544getFontStyle4Lr2A7w() + ", fontSynthesis=" + m3545getFontSynthesisZQGJjVo() + ", fontFamily=" + this.fontFamily + ", fontFeatureSettings=" + this.fontFeatureSettings + ", letterSpacing=" + TextUnit.m4047toStringimpl(m3546getLetterSpacingXSAIIZE()) + ", baselineShift=" + m3541getBaselineShift5SSeXJ0() + ", textGeometricTransform=" + this.textGeometricTransform + ", localeList=" + this.localeList + ", background=" + Color.m1604toStringimpl(m3540getBackground0d7_KjU()) + ", textDecoration=" + this.textDecoration + ", shadow=" + this.shadow + ')';
    }
}
