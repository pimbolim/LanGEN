package androidx.compose.ui.text;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u0000 W2\u00020\u0001:\u0001WB\u0017\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006BÖ\u0001\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\n\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010%\u001a\u00020\n\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'ø\u0001\u0000¢\u0006\u0002\u0010(Já\u0001\u0010J\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\n2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010%\u001a\u00020\n2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bK\u0010LJ\u0013\u0010M\u001a\u00020N2\b\u0010O\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010P\u001a\u00020QH\u0016J\u0010\u0010R\u001a\u00020\u00002\u0006\u0010O\u001a\u00020\u0005H\u0007J\u0010\u0010R\u001a\u00020\u00002\u0006\u0010O\u001a\u00020\u0003H\u0007J\u0014\u0010R\u001a\u00020\u00002\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u0000H\u0007J\u0011\u0010S\u001a\u00020\u00002\u0006\u0010O\u001a\u00020\u0005H\u0002J\u0011\u0010S\u001a\u00020\u00002\u0006\u0010O\u001a\u00020\u0003H\u0002J\u0011\u0010S\u001a\u00020\u00002\u0006\u0010O\u001a\u00020\u0000H\u0002J\b\u0010T\u001a\u00020\u0005H\u0007J\b\u0010U\u001a\u00020\u0003H\u0007J\b\u0010V\u001a\u00020\u0014H\u0016R\u001c\u0010\u001c\u001a\u00020\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010+\u001a\u0004\b)\u0010*R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u001c\u0010\u0007\u001a\u00020\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010+\u001a\u0004\b.\u0010*R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u001c\u0010\t\u001a\u00020\nø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010+\u001a\u0004\b3\u0010*R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u001c\u0010\u0015\u001a\u00020\nø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010+\u001a\u0004\b:\u0010*R\u001c\u0010%\u001a\u00020\nø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010+\u001a\u0004\b;\u0010*R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0013\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u001c\u0010!\u001a\u0004\u0018\u00010\"ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u001c\u0010#\u001a\u0004\u0018\u00010$ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u0013\u0010&\u001a\u0004\u0018\u00010'¢\u0006\b\n\u0000\u001a\u0004\bH\u0010I\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006X"}, d2 = {"Landroidx/compose/ui/text/TextStyle;", "", "spanStyle", "Landroidx/compose/ui/text/SpanStyle;", "paragraphStyle", "Landroidx/compose/ui/text/ParagraphStyle;", "(Landroidx/compose/ui/text/SpanStyle;Landroidx/compose/ui/text/ParagraphStyle;)V", "color", "Landroidx/compose/ui/graphics/Color;", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "fontFeatureSettings", "", "letterSpacing", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "textGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "background", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "textDirection", "Landroidx/compose/ui/text/style/TextDirection;", "lineHeight", "textIndent", "Landroidx/compose/ui/text/style/TextIndent;", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBackground-0d7_KjU", "()J", "J", "getBaselineShift-5SSeXJ0", "()Landroidx/compose/ui/text/style/BaselineShift;", "getColor-0d7_KjU", "getFontFamily", "()Landroidx/compose/ui/text/font/FontFamily;", "getFontFeatureSettings", "()Ljava/lang/String;", "getFontSize-XSAIIZE", "getFontStyle-4Lr2A7w", "()Landroidx/compose/ui/text/font/FontStyle;", "getFontSynthesis-ZQGJjVo", "()Landroidx/compose/ui/text/font/FontSynthesis;", "getFontWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "getLetterSpacing-XSAIIZE", "getLineHeight-XSAIIZE", "getLocaleList", "()Landroidx/compose/ui/text/intl/LocaleList;", "getShadow", "()Landroidx/compose/ui/graphics/Shadow;", "getTextAlign-buA522U", "()Landroidx/compose/ui/text/style/TextAlign;", "getTextDecoration", "()Landroidx/compose/ui/text/style/TextDecoration;", "getTextDirection-mmuk1to", "()Landroidx/compose/ui/text/style/TextDirection;", "getTextGeometricTransform", "()Landroidx/compose/ui/text/style/TextGeometricTransform;", "getTextIndent", "()Landroidx/compose/ui/text/style/TextIndent;", "copy", "copy-HL5avdY", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;)Landroidx/compose/ui/text/TextStyle;", "equals", "", "other", "hashCode", "", "merge", "plus", "toParagraphStyle", "toSpanStyle", "toString", "Companion", "ui-text_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextStyle.kt */
public final class TextStyle {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final TextStyle Default = new TextStyle(0, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 262143, (DefaultConstructorMarker) null);
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
    private final long lineHeight;
    private final LocaleList localeList;
    private final Shadow shadow;
    private final TextAlign textAlign;
    private final TextDecoration textDecoration;
    private final TextDirection textDirection;
    private final TextGeometricTransform textGeometricTransform;
    private final TextIndent textIndent;

    public /* synthetic */ TextStyle(long j, long j2, FontWeight fontWeight2, FontStyle fontStyle2, FontSynthesis fontSynthesis2, FontFamily fontFamily2, String str, long j3, BaselineShift baselineShift2, TextGeometricTransform textGeometricTransform2, LocaleList localeList2, long j4, TextDecoration textDecoration2, Shadow shadow2, TextAlign textAlign2, TextDirection textDirection2, long j5, TextIndent textIndent2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, fontWeight2, fontStyle2, fontSynthesis2, fontFamily2, str, j3, baselineShift2, textGeometricTransform2, localeList2, j4, textDecoration2, shadow2, textAlign2, textDirection2, j5, textIndent2);
    }

    private TextStyle(long j, long j2, FontWeight fontWeight2, FontStyle fontStyle2, FontSynthesis fontSynthesis2, FontFamily fontFamily2, String str, long j3, BaselineShift baselineShift2, TextGeometricTransform textGeometricTransform2, LocaleList localeList2, long j4, TextDecoration textDecoration2, Shadow shadow2, TextAlign textAlign2, TextDirection textDirection2, long j5, TextIndent textIndent2) {
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
        this.textAlign = textAlign2;
        this.textDirection = textDirection2;
        this.lineHeight = j5;
        this.textIndent = textIndent2;
        if (!TextUnitKt.m4058isUnspecifiedR2X_6o(m3588getLineHeightXSAIIZE())) {
            if (!(TextUnit.m4040getValueimpl(m3588getLineHeightXSAIIZE()) >= 0.0f)) {
                throw new IllegalStateException(("lineHeight can't be negative (" + TextUnit.m4040getValueimpl(m3588getLineHeightXSAIIZE()) + ')').toString());
            }
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TextStyle(long r25, long r27, androidx.compose.ui.text.font.FontWeight r29, androidx.compose.ui.text.font.FontStyle r30, androidx.compose.ui.text.font.FontSynthesis r31, androidx.compose.ui.text.font.FontFamily r32, java.lang.String r33, long r34, androidx.compose.ui.text.style.BaselineShift r36, androidx.compose.ui.text.style.TextGeometricTransform r37, androidx.compose.ui.text.intl.LocaleList r38, long r39, androidx.compose.ui.text.style.TextDecoration r41, androidx.compose.ui.graphics.Shadow r42, androidx.compose.ui.text.style.TextAlign r43, androidx.compose.ui.text.style.TextDirection r44, long r45, androidx.compose.ui.text.style.TextIndent r47, int r48, kotlin.jvm.internal.DefaultConstructorMarker r49) {
        /*
            r24 = this;
            r0 = r48
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000d
            androidx.compose.ui.graphics.Color$Companion r1 = androidx.compose.ui.graphics.Color.Companion
            long r1 = r1.m1632getUnspecified0d7_KjU()
            goto L_0x000f
        L_0x000d:
            r1 = r25
        L_0x000f:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x001a
            androidx.compose.ui.unit.TextUnit$Companion r3 = androidx.compose.ui.unit.TextUnit.Companion
            long r3 = r3.m4051getUnspecifiedXSAIIZE()
            goto L_0x001c
        L_0x001a:
            r3 = r27
        L_0x001c:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x0022
            r5 = 0
            goto L_0x0024
        L_0x0022:
            r5 = r29
        L_0x0024:
            r7 = r0 & 8
            if (r7 == 0) goto L_0x002a
            r7 = 0
            goto L_0x002c
        L_0x002a:
            r7 = r30
        L_0x002c:
            r8 = r0 & 16
            if (r8 == 0) goto L_0x0032
            r8 = 0
            goto L_0x0034
        L_0x0032:
            r8 = r31
        L_0x0034:
            r9 = r0 & 32
            if (r9 == 0) goto L_0x003a
            r9 = 0
            goto L_0x003c
        L_0x003a:
            r9 = r32
        L_0x003c:
            r10 = r0 & 64
            if (r10 == 0) goto L_0x0042
            r10 = 0
            goto L_0x0044
        L_0x0042:
            r10 = r33
        L_0x0044:
            r11 = r0 & 128(0x80, float:1.794E-43)
            if (r11 == 0) goto L_0x004f
            androidx.compose.ui.unit.TextUnit$Companion r11 = androidx.compose.ui.unit.TextUnit.Companion
            long r11 = r11.m4051getUnspecifiedXSAIIZE()
            goto L_0x0051
        L_0x004f:
            r11 = r34
        L_0x0051:
            r13 = r0 & 256(0x100, float:3.59E-43)
            if (r13 == 0) goto L_0x0057
            r13 = 0
            goto L_0x0059
        L_0x0057:
            r13 = r36
        L_0x0059:
            r14 = r0 & 512(0x200, float:7.175E-43)
            if (r14 == 0) goto L_0x005f
            r14 = 0
            goto L_0x0061
        L_0x005f:
            r14 = r37
        L_0x0061:
            r15 = r0 & 1024(0x400, float:1.435E-42)
            if (r15 == 0) goto L_0x0067
            r15 = 0
            goto L_0x0069
        L_0x0067:
            r15 = r38
        L_0x0069:
            r6 = r0 & 2048(0x800, float:2.87E-42)
            if (r6 == 0) goto L_0x0074
            androidx.compose.ui.graphics.Color$Companion r6 = androidx.compose.ui.graphics.Color.Companion
            long r16 = r6.m1632getUnspecified0d7_KjU()
            goto L_0x0076
        L_0x0074:
            r16 = r39
        L_0x0076:
            r6 = r0 & 4096(0x1000, float:5.74E-42)
            if (r6 == 0) goto L_0x007c
            r6 = 0
            goto L_0x007e
        L_0x007c:
            r6 = r41
        L_0x007e:
            r18 = r6
            r6 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r6 == 0) goto L_0x0086
            r6 = 0
            goto L_0x0088
        L_0x0086:
            r6 = r42
        L_0x0088:
            r19 = r6
            r6 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r6 == 0) goto L_0x0090
            r6 = 0
            goto L_0x0092
        L_0x0090:
            r6 = r43
        L_0x0092:
            r20 = 32768(0x8000, float:4.5918E-41)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x009c
            r20 = 0
            goto L_0x009e
        L_0x009c:
            r20 = r44
        L_0x009e:
            r21 = 65536(0x10000, float:9.18355E-41)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x00ab
            androidx.compose.ui.unit.TextUnit$Companion r21 = androidx.compose.ui.unit.TextUnit.Companion
            long r21 = r21.m4051getUnspecifiedXSAIIZE()
            goto L_0x00ad
        L_0x00ab:
            r21 = r45
        L_0x00ad:
            r23 = 131072(0x20000, float:1.83671E-40)
            r0 = r0 & r23
            if (r0 == 0) goto L_0x00b5
            r0 = 0
            goto L_0x00b7
        L_0x00b5:
            r0 = r47
        L_0x00b7:
            r23 = 0
            r49 = r23
            r25 = r24
            r26 = r1
            r28 = r3
            r30 = r5
            r31 = r7
            r32 = r8
            r33 = r9
            r34 = r10
            r35 = r11
            r37 = r13
            r38 = r14
            r39 = r15
            r40 = r16
            r42 = r18
            r43 = r19
            r44 = r6
            r45 = r20
            r46 = r21
            r48 = r0
            r25.<init>(r26, r28, r30, r31, r32, r33, r34, r35, r37, r38, r39, r40, r42, r43, r44, r45, r46, r48, r49)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.TextStyle.<init>(long, long, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontSynthesis, androidx.compose.ui.text.font.FontFamily, java.lang.String, long, androidx.compose.ui.text.style.BaselineShift, androidx.compose.ui.text.style.TextGeometricTransform, androidx.compose.ui.text.intl.LocaleList, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.graphics.Shadow, androidx.compose.ui.text.style.TextAlign, androidx.compose.ui.text.style.TextDirection, long, androidx.compose.ui.text.style.TextIndent, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* renamed from: getColor-0d7_KjU  reason: not valid java name */
    public final long m3583getColor0d7_KjU() {
        return this.color;
    }

    /* renamed from: getFontSize-XSAIIZE  reason: not valid java name */
    public final long m3584getFontSizeXSAIIZE() {
        return this.fontSize;
    }

    public final FontWeight getFontWeight() {
        return this.fontWeight;
    }

    /* renamed from: getFontStyle-4Lr2A7w  reason: not valid java name */
    public final FontStyle m3585getFontStyle4Lr2A7w() {
        return this.fontStyle;
    }

    /* renamed from: getFontSynthesis-ZQGJjVo  reason: not valid java name */
    public final FontSynthesis m3586getFontSynthesisZQGJjVo() {
        return this.fontSynthesis;
    }

    public final FontFamily getFontFamily() {
        return this.fontFamily;
    }

    public final String getFontFeatureSettings() {
        return this.fontFeatureSettings;
    }

    /* renamed from: getLetterSpacing-XSAIIZE  reason: not valid java name */
    public final long m3587getLetterSpacingXSAIIZE() {
        return this.letterSpacing;
    }

    /* renamed from: getBaselineShift-5SSeXJ0  reason: not valid java name */
    public final BaselineShift m3582getBaselineShift5SSeXJ0() {
        return this.baselineShift;
    }

    public final TextGeometricTransform getTextGeometricTransform() {
        return this.textGeometricTransform;
    }

    public final LocaleList getLocaleList() {
        return this.localeList;
    }

    /* renamed from: getBackground-0d7_KjU  reason: not valid java name */
    public final long m3581getBackground0d7_KjU() {
        return this.background;
    }

    public final TextDecoration getTextDecoration() {
        return this.textDecoration;
    }

    public final Shadow getShadow() {
        return this.shadow;
    }

    /* renamed from: getTextAlign-buA522U  reason: not valid java name */
    public final TextAlign m3589getTextAlignbuA522U() {
        return this.textAlign;
    }

    /* renamed from: getTextDirection-mmuk1to  reason: not valid java name */
    public final TextDirection m3590getTextDirectionmmuk1to() {
        return this.textDirection;
    }

    /* renamed from: getLineHeight-XSAIIZE  reason: not valid java name */
    public final long m3588getLineHeightXSAIIZE() {
        return this.lineHeight;
    }

    public final TextIndent getTextIndent() {
        return this.textIndent;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TextStyle(SpanStyle spanStyle, ParagraphStyle paragraphStyle) {
        this(spanStyle.m3542getColor0d7_KjU(), spanStyle.m3543getFontSizeXSAIIZE(), spanStyle.getFontWeight(), spanStyle.m3544getFontStyle4Lr2A7w(), spanStyle.m3545getFontSynthesisZQGJjVo(), spanStyle.getFontFamily(), spanStyle.getFontFeatureSettings(), spanStyle.m3546getLetterSpacingXSAIIZE(), spanStyle.m3541getBaselineShift5SSeXJ0(), spanStyle.getTextGeometricTransform(), spanStyle.getLocaleList(), spanStyle.m3540getBackground0d7_KjU(), spanStyle.getTextDecoration(), spanStyle.getShadow(), paragraphStyle.m3507getTextAlignbuA522U(), paragraphStyle.m3508getTextDirectionmmuk1to(), paragraphStyle.m3506getLineHeightXSAIIZE(), paragraphStyle.getTextIndent(), (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(spanStyle, "spanStyle");
        Intrinsics.checkNotNullParameter(paragraphStyle, "paragraphStyle");
    }

    public final SpanStyle toSpanStyle() {
        return new SpanStyle(m3583getColor0d7_KjU(), m3584getFontSizeXSAIIZE(), this.fontWeight, m3585getFontStyle4Lr2A7w(), m3586getFontSynthesisZQGJjVo(), this.fontFamily, this.fontFeatureSettings, m3587getLetterSpacingXSAIIZE(), m3582getBaselineShift5SSeXJ0(), this.textGeometricTransform, this.localeList, m3581getBackground0d7_KjU(), this.textDecoration, this.shadow, (DefaultConstructorMarker) null);
    }

    public final ParagraphStyle toParagraphStyle() {
        return new ParagraphStyle(m3589getTextAlignbuA522U(), m3590getTextDirectionmmuk1to(), m3588getLineHeightXSAIIZE(), this.textIndent, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ TextStyle merge$default(TextStyle textStyle, TextStyle textStyle2, int i, Object obj) {
        if ((i & 1) != 0) {
            textStyle2 = null;
        }
        return textStyle.merge(textStyle2);
    }

    public final TextStyle merge(TextStyle textStyle) {
        return (textStyle == null || Intrinsics.areEqual((Object) textStyle, (Object) Default)) ? this : new TextStyle(toSpanStyle().merge(textStyle.toSpanStyle()), toParagraphStyle().merge(textStyle.toParagraphStyle()));
    }

    public final TextStyle merge(SpanStyle spanStyle) {
        Intrinsics.checkNotNullParameter(spanStyle, "other");
        return new TextStyle(toSpanStyle().merge(spanStyle), toParagraphStyle());
    }

    public final TextStyle merge(ParagraphStyle paragraphStyle) {
        Intrinsics.checkNotNullParameter(paragraphStyle, "other");
        return new TextStyle(toSpanStyle(), toParagraphStyle().merge(paragraphStyle));
    }

    public final TextStyle plus(TextStyle textStyle) {
        Intrinsics.checkNotNullParameter(textStyle, "other");
        return merge(textStyle);
    }

    public final TextStyle plus(ParagraphStyle paragraphStyle) {
        Intrinsics.checkNotNullParameter(paragraphStyle, "other");
        return merge(paragraphStyle);
    }

    public final TextStyle plus(SpanStyle spanStyle) {
        Intrinsics.checkNotNullParameter(spanStyle, "other");
        return merge(spanStyle);
    }

    /* renamed from: copy-HL5avdY$default  reason: not valid java name */
    public static /* synthetic */ TextStyle m3579copyHL5avdY$default(TextStyle textStyle, long j, long j2, FontWeight fontWeight2, FontStyle fontStyle2, FontSynthesis fontSynthesis2, FontFamily fontFamily2, String str, long j3, BaselineShift baselineShift2, TextGeometricTransform textGeometricTransform2, LocaleList localeList2, long j4, TextDecoration textDecoration2, Shadow shadow2, TextAlign textAlign2, TextDirection textDirection2, long j5, TextIndent textIndent2, int i, Object obj) {
        FontSynthesis fontSynthesis3;
        BaselineShift baselineShift3;
        TextGeometricTransform textGeometricTransform3;
        long j6;
        TextDecoration textDecoration3;
        long j7;
        TextStyle textStyle2 = textStyle;
        int i2 = i;
        long r2 = (i2 & 1) != 0 ? textStyle.m3583getColor0d7_KjU() : j;
        long r4 = (i2 & 2) != 0 ? textStyle.m3584getFontSizeXSAIIZE() : j2;
        FontWeight fontWeight3 = (i2 & 4) != 0 ? textStyle2.fontWeight : fontWeight2;
        FontStyle r7 = (i2 & 8) != 0 ? textStyle.m3585getFontStyle4Lr2A7w() : fontStyle2;
        if ((i2 & 16) != 0) {
            fontSynthesis3 = textStyle.m3586getFontSynthesisZQGJjVo();
        } else {
            fontSynthesis3 = fontSynthesis2;
        }
        FontFamily fontFamily3 = (i2 & 32) != 0 ? textStyle2.fontFamily : fontFamily2;
        String str2 = (i2 & 64) != 0 ? textStyle2.fontFeatureSettings : str;
        long r11 = (i2 & 128) != 0 ? textStyle.m3587getLetterSpacingXSAIIZE() : j3;
        if ((i2 & 256) != 0) {
            baselineShift3 = textStyle.m3582getBaselineShift5SSeXJ0();
        } else {
            baselineShift3 = baselineShift2;
        }
        if ((i2 & 512) != 0) {
            textGeometricTransform3 = textStyle2.textGeometricTransform;
        } else {
            textGeometricTransform3 = textGeometricTransform2;
        }
        LocaleList localeList3 = (i2 & 1024) != 0 ? textStyle2.localeList : localeList2;
        if ((i2 & 2048) != 0) {
            j6 = textStyle.m3581getBackground0d7_KjU();
        } else {
            j6 = j4;
        }
        long j8 = j6;
        if ((i2 & 4096) != 0) {
            textDecoration3 = textStyle2.textDecoration;
        } else {
            textDecoration3 = textDecoration2;
        }
        TextDecoration textDecoration4 = textDecoration3;
        Shadow shadow3 = (i2 & 8192) != 0 ? textStyle2.shadow : shadow2;
        TextAlign r15 = (i2 & 16384) != 0 ? textStyle.m3589getTextAlignbuA522U() : textAlign2;
        TextDirection r16 = (i2 & 32768) != 0 ? textStyle.m3590getTextDirectionmmuk1to() : textDirection2;
        if ((i2 & 65536) != 0) {
            j7 = textStyle.m3588getLineHeightXSAIIZE();
        } else {
            j7 = j5;
        }
        return textStyle.m3580copyHL5avdY(r2, r4, fontWeight3, r7, fontSynthesis3, fontFamily3, str2, r11, baselineShift3, textGeometricTransform3, localeList3, j8, textDecoration4, shadow3, r15, r16, j7, (i2 & 131072) != 0 ? textStyle2.textIndent : textIndent2);
    }

    /* renamed from: copy-HL5avdY  reason: not valid java name */
    public final TextStyle m3580copyHL5avdY(long j, long j2, FontWeight fontWeight2, FontStyle fontStyle2, FontSynthesis fontSynthesis2, FontFamily fontFamily2, String str, long j3, BaselineShift baselineShift2, TextGeometricTransform textGeometricTransform2, LocaleList localeList2, long j4, TextDecoration textDecoration2, Shadow shadow2, TextAlign textAlign2, TextDirection textDirection2, long j5, TextIndent textIndent2) {
        return new TextStyle(j, j2, fontWeight2, fontStyle2, fontSynthesis2, fontFamily2, str, j3, baselineShift2, textGeometricTransform2, localeList2, j4, textDecoration2, shadow2, textAlign2, textDirection2, j5, textIndent2, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextStyle)) {
            return false;
        }
        TextStyle textStyle = (TextStyle) obj;
        return Color.m1597equalsimpl0(m3583getColor0d7_KjU(), textStyle.m3583getColor0d7_KjU()) && TextUnit.m4037equalsimpl0(m3584getFontSizeXSAIIZE(), textStyle.m3584getFontSizeXSAIIZE()) && Intrinsics.areEqual((Object) this.fontWeight, (Object) textStyle.fontWeight) && Intrinsics.areEqual((Object) m3585getFontStyle4Lr2A7w(), (Object) textStyle.m3585getFontStyle4Lr2A7w()) && Intrinsics.areEqual((Object) m3586getFontSynthesisZQGJjVo(), (Object) textStyle.m3586getFontSynthesisZQGJjVo()) && Intrinsics.areEqual((Object) this.fontFamily, (Object) textStyle.fontFamily) && Intrinsics.areEqual((Object) this.fontFeatureSettings, (Object) textStyle.fontFeatureSettings) && TextUnit.m4037equalsimpl0(m3587getLetterSpacingXSAIIZE(), textStyle.m3587getLetterSpacingXSAIIZE()) && Intrinsics.areEqual((Object) m3582getBaselineShift5SSeXJ0(), (Object) textStyle.m3582getBaselineShift5SSeXJ0()) && Intrinsics.areEqual((Object) this.textGeometricTransform, (Object) textStyle.textGeometricTransform) && Intrinsics.areEqual((Object) this.localeList, (Object) textStyle.localeList) && Color.m1597equalsimpl0(m3581getBackground0d7_KjU(), textStyle.m3581getBackground0d7_KjU()) && Intrinsics.areEqual((Object) this.textDecoration, (Object) textStyle.textDecoration) && Intrinsics.areEqual((Object) this.shadow, (Object) textStyle.shadow) && Intrinsics.areEqual((Object) m3589getTextAlignbuA522U(), (Object) textStyle.m3589getTextAlignbuA522U()) && Intrinsics.areEqual((Object) m3590getTextDirectionmmuk1to(), (Object) textStyle.m3590getTextDirectionmmuk1to()) && TextUnit.m4037equalsimpl0(m3588getLineHeightXSAIIZE(), textStyle.m3588getLineHeightXSAIIZE()) && Intrinsics.areEqual((Object) this.textIndent, (Object) textStyle.textIndent);
    }

    public int hashCode() {
        int r0 = ((Color.m1603hashCodeimpl(m3583getColor0d7_KjU()) * 31) + TextUnit.m4041hashCodeimpl(m3584getFontSizeXSAIIZE())) * 31;
        FontWeight fontWeight2 = this.fontWeight;
        int i = 0;
        int hashCode = (r0 + (fontWeight2 == null ? 0 : fontWeight2.hashCode())) * 31;
        FontStyle r1 = m3585getFontStyle4Lr2A7w();
        int r02 = (hashCode + (r1 == null ? 0 : FontStyle.m3613hashCodeimpl(r1.m3615unboximpl()))) * 31;
        FontSynthesis r12 = m3586getFontSynthesisZQGJjVo();
        int r03 = (r02 + (r12 == null ? 0 : FontSynthesis.m3622hashCodeimpl(r12.m3626unboximpl()))) * 31;
        FontFamily fontFamily2 = this.fontFamily;
        int hashCode2 = (r03 + (fontFamily2 == null ? 0 : fontFamily2.hashCode())) * 31;
        String str = this.fontFeatureSettings;
        int hashCode3 = (((hashCode2 + (str == null ? 0 : str.hashCode())) * 31) + TextUnit.m4041hashCodeimpl(m3587getLetterSpacingXSAIIZE())) * 31;
        BaselineShift r13 = m3582getBaselineShift5SSeXJ0();
        int r04 = (hashCode3 + (r13 == null ? 0 : BaselineShift.m3739hashCodeimpl(r13.m3741unboximpl()))) * 31;
        TextGeometricTransform textGeometricTransform2 = this.textGeometricTransform;
        int hashCode4 = (r04 + (textGeometricTransform2 == null ? 0 : textGeometricTransform2.hashCode())) * 31;
        LocaleList localeList2 = this.localeList;
        int hashCode5 = (((hashCode4 + (localeList2 == null ? 0 : localeList2.hashCode())) * 31) + Color.m1603hashCodeimpl(m3581getBackground0d7_KjU())) * 31;
        TextDecoration textDecoration2 = this.textDecoration;
        int hashCode6 = (hashCode5 + (textDecoration2 == null ? 0 : textDecoration2.hashCode())) * 31;
        Shadow shadow2 = this.shadow;
        int hashCode7 = (hashCode6 + (shadow2 == null ? 0 : shadow2.hashCode())) * 31;
        TextAlign r14 = m3589getTextAlignbuA522U();
        int r05 = (hashCode7 + (r14 == null ? 0 : TextAlign.m3753hashCodeimpl(r14.m3755unboximpl()))) * 31;
        TextDirection r15 = m3590getTextDirectionmmuk1to();
        int r06 = (((r05 + (r15 == null ? 0 : TextDirection.m3766hashCodeimpl(r15.m3768unboximpl()))) * 31) + TextUnit.m4041hashCodeimpl(m3588getLineHeightXSAIIZE())) * 31;
        TextIndent textIndent2 = this.textIndent;
        if (textIndent2 != null) {
            i = textIndent2.hashCode();
        }
        return r06 + i;
    }

    public String toString() {
        return "TextStyle(color=" + Color.m1604toStringimpl(m3583getColor0d7_KjU()) + ", fontSize=" + TextUnit.m4047toStringimpl(m3584getFontSizeXSAIIZE()) + ", fontWeight=" + this.fontWeight + ", fontStyle=" + m3585getFontStyle4Lr2A7w() + ", fontSynthesis=" + m3586getFontSynthesisZQGJjVo() + ", fontFamily=" + this.fontFamily + ", fontFeatureSettings=" + this.fontFeatureSettings + ", letterSpacing=" + TextUnit.m4047toStringimpl(m3587getLetterSpacingXSAIIZE()) + ", baselineShift=" + m3582getBaselineShift5SSeXJ0() + ", textGeometricTransform=" + this.textGeometricTransform + ", localeList=" + this.localeList + ", background=" + Color.m1604toStringimpl(m3581getBackground0d7_KjU()) + ", textDecoration=" + this.textDecoration + ", shadow=" + this.shadow + ", textAlign=" + m3589getTextAlignbuA522U() + ", textDirection=" + m3590getTextDirectionmmuk1to() + ", lineHeight=" + TextUnit.m4047toStringimpl(m3588getLineHeightXSAIIZE()) + ", textIndent=" + this.textIndent + ')';
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/ui/text/TextStyle$Companion;", "", "()V", "Default", "Landroidx/compose/ui/text/TextStyle;", "getDefault$annotations", "getDefault", "()Landroidx/compose/ui/text/TextStyle;", "ui-text_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TextStyle.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getDefault$annotations() {
        }

        private Companion() {
        }

        public final TextStyle getDefault() {
            return TextStyle.Default;
        }
    }
}
