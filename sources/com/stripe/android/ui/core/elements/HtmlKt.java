package com.stripe.android.ui.core.elements;

import android.content.Context;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.StyleSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.text.InlineTextContent;
import androidx.compose.foundation.text.InlineTextContentKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.PlaceholderVerticalAlign;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.core.text.HtmlCompat;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0001\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0003\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00030\u00162\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00030\u0016H\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001a\u001aK\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00012\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u001e0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010 \u001a)\u0010!\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00012\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u001e0\u0007H\u0003¢\u0006\u0002\u0010\"\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006#"}, d2 = {"LINK_TAG", "", "ClickableText", "", "text", "Landroidx/compose/ui/text/AnnotatedString;", "inlineContent", "", "Landroidx/compose/foundation/text/InlineTextContent;", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "style", "Landroidx/compose/ui/text/TextStyle;", "softWrap", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "maxLines", "", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "onClick", "ClickableText-DauHOvk", "(Landroidx/compose/ui/text/AnnotatedString;Ljava/util/Map;Landroidx/compose/ui/Modifier;JLandroidx/compose/ui/text/TextStyle;ZIILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "Html", "html", "imageGetter", "Lcom/stripe/android/ui/core/elements/EmbeddableImage;", "Html-uDo3WH8", "(Ljava/lang/String;Ljava/util/Map;Landroidx/compose/ui/Modifier;JLandroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;II)V", "annotatedStringResource", "(Ljava/lang/String;Ljava/util/Map;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/text/AnnotatedString;", "payments-ui-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Html.kt */
public final class HtmlKt {
    private static final String LINK_TAG = "URL";

    /* renamed from: Html-uDo3WH8  reason: not valid java name */
    public static final void m4582HtmluDo3WH8(String str, Map<String, EmbeddableImage> map, Modifier modifier, long j, TextStyle textStyle, Composer composer, int i, int i2) {
        String str2 = str;
        Map<String, EmbeddableImage> map2 = map;
        int i3 = i;
        Intrinsics.checkNotNullParameter(str2, "html");
        Intrinsics.checkNotNullParameter(map2, "imageGetter");
        Intrinsics.checkNotNullParameter(textStyle, "style");
        Composer startRestartGroup = composer.startRestartGroup(176655537);
        Modifier modifier2 = (i2 & 4) != 0 ? Modifier.Companion : modifier;
        startRestartGroup.startReplaceableGroup(176655737);
        Iterable<Map.Entry> entrySet = map.entrySet();
        Map linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(entrySet, 10)), 16));
        for (Map.Entry entry : entrySet) {
            EmbeddableImage embeddableImage = (EmbeddableImage) entry.getValue();
            Painter painterResource = PainterResources_androidKt.painterResource(embeddableImage.getId(), startRestartGroup, 0);
            float r13 = Size.m1419getHeightimpl(painterResource.m2184getIntrinsicSizeNHjbRc());
            float r14 = Size.m1422getWidthimpl(painterResource.m2184getIntrinsicSizeNHjbRc());
            long r15 = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 8).getBody1().m3584getFontSizeXSAIIZE();
            TextUnitKt.m4053checkArithmeticR2X_6o(r15);
            Pair pair = TuplesKt.to((String) entry.getKey(), new InlineTextContent(new Placeholder(TextUnitKt.pack(TextUnit.m4038getRawTypeimpl(r15), TextUnit.m4040getValueimpl(r15) * (r14 / r13)), MaterialTheme.INSTANCE.getTypography(startRestartGroup, 8).getBody1().m3584getFontSizeXSAIIZE(), PlaceholderVerticalAlign.Companion.m3521getAboveBaselineJ6kI3mc(), (DefaultConstructorMarker) null), ComposableLambdaKt.composableLambda(startRestartGroup, -819893583, true, new HtmlKt$Html$inlineContentMap$1$1(embeddableImage, painterResource))));
            linkedHashMap = linkedHashMap;
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        startRestartGroup.endReplaceableGroup();
        AnnotatedString annotatedStringResource = annotatedStringResource(str2, map2, startRestartGroup, (i3 & 14) | 64);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
        Object consume = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        m4581ClickableTextDauHOvk(annotatedStringResource, linkedHashMap, SemanticsModifierKt.semantics(PaddingKt.m433paddingVpY3zN4$default(modifier2, 0.0f, Dp.m3859constructorimpl((float) 8), 1, (Object) null), true, HtmlKt$Html$1.INSTANCE), j, textStyle, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, new HtmlKt$Html$2(annotatedStringResource, (Context) consume), startRestartGroup, (i3 & 7168) | 64 | (57344 & i3), 480);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new HtmlKt$Html$3(str, map, modifier2, j, textStyle, i, i2));
        }
    }

    private static final AnnotatedString annotatedStringResource(String str, Map<String, EmbeddableImage> map, Composer composer, int i) {
        String str2 = str;
        Composer composer2 = composer;
        composer2.startReplaceableGroup(-2096753348);
        composer2.startReplaceableGroup(-3686930);
        ComposerKt.sourceInformation(composer2, "C(remember)P(1):Composables.kt#9igjgp");
        boolean changed = composer2.changed((Object) str2);
        Object rememberedValue = composer.rememberedValue();
        int i2 = 0;
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = HtmlCompat.fromHtml(str2, 0);
            composer2.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        Intrinsics.checkNotNullExpressionValue(rememberedValue, "remember(text) {\n       …M_HTML_MODE_LEGACY)\n    }");
        Spanned spanned = (Spanned) rememberedValue;
        composer2.startReplaceableGroup(-3686930);
        ComposerKt.sourceInformation(composer2, "C(remember)P(1):Composables.kt#9igjgp");
        boolean changed2 = composer2.changed((Object) spanned);
        Object rememberedValue2 = composer.rememberedValue();
        if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
            AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, (DefaultConstructorMarker) null);
            Object[] spans = spanned.getSpans(0, spanned.length(), Object.class);
            Intrinsics.checkNotNullExpressionValue(spans, "spanned.getSpans(0, span….length, Any::class.java)");
            int length = spans.length;
            int i3 = 0;
            while (i2 < length) {
                Object obj = spans[i2];
                i2++;
                int spanStart = spanned.getSpanStart(obj);
                int spanEnd = spanned.getSpanEnd(obj);
                if (i3 >= spanned.toString().length() || spanStart >= spanned.toString().length() || spanStart - i3 < 0) {
                    Map<String, EmbeddableImage> map2 = map;
                } else {
                    String substring = spanned.toString().substring(i3, spanStart);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    builder.append(substring);
                    if (obj instanceof StyleSpan) {
                        int style = ((StyleSpan) obj).getStyle();
                        if (style == 1) {
                            builder.addStyle(new SpanStyle(0, 0, FontWeight.Companion.getBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, 16379, (DefaultConstructorMarker) null), spanStart, spanEnd);
                        } else if (style == 2) {
                            builder.addStyle(new SpanStyle(0, 0, (FontWeight) null, FontStyle.m3609boximpl(FontStyle.Companion.m3616getItalic_LCdwA()), (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, 16375, (DefaultConstructorMarker) null), spanStart, spanEnd);
                        } else if (style == 3) {
                            builder.addStyle(new SpanStyle(0, 0, FontWeight.Companion.getBold(), FontStyle.m3609boximpl(FontStyle.Companion.m3616getItalic_LCdwA()), (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, 16371, (DefaultConstructorMarker) null), spanStart, spanEnd);
                        }
                    } else if (obj instanceof UnderlineSpan) {
                        builder.addStyle(new SpanStyle(0, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, TextDecoration.Companion.getUnderline(), (Shadow) null, 12287, (DefaultConstructorMarker) null), spanStart, spanEnd);
                    } else if (obj instanceof ForegroundColorSpan) {
                        builder.addStyle(new SpanStyle(ColorKt.Color(((ForegroundColorSpan) obj).getForegroundColor()), 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, 16382, (DefaultConstructorMarker) null), spanStart, spanEnd);
                    } else if (obj instanceof ImageSpan) {
                        ImageSpan imageSpan = (ImageSpan) obj;
                        if (imageSpan.getSource() == null) {
                            Map<String, EmbeddableImage> map3 = map;
                        } else {
                            String source = imageSpan.getSource();
                            Intrinsics.checkNotNull(source);
                            map.containsKey(source);
                            String source2 = imageSpan.getSource();
                            Intrinsics.checkNotNull(source2);
                            Intrinsics.checkNotNullExpressionValue(source2, "span.source!!");
                            InlineTextContentKt.appendInlineContent$default(builder, source2, (String) null, 2, (Object) null);
                        }
                        i3 = spanEnd;
                    } else {
                        Map<String, EmbeddableImage> map4 = map;
                        if (obj instanceof URLSpan) {
                            builder.addStyle(new SpanStyle(0, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, TextDecoration.Companion.getUnderline(), (Shadow) null, 12287, (DefaultConstructorMarker) null), spanStart, spanEnd);
                            String url = ((URLSpan) obj).getURL();
                            Intrinsics.checkNotNullExpressionValue(url, "span.url");
                            builder.addStringAnnotation(LINK_TAG, url, spanStart, spanEnd);
                        }
                        i3 = spanStart;
                    }
                    Map<String, EmbeddableImage> map5 = map;
                    i3 = spanStart;
                }
            }
            if (i3 != spanned.toString().length()) {
                String substring2 = spanned.toString().substring(i3);
                Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
                builder.append(substring2);
            }
            rememberedValue2 = builder.toAnnotatedString();
            composer2.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        AnnotatedString annotatedString = (AnnotatedString) rememberedValue2;
        composer.endReplaceableGroup();
        return annotatedString;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: kotlin.jvm.functions.Function1} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x022b, code lost:
        if (r13 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x0230;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x01f7  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x0223  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x022e  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x02eb  */
    /* JADX WARNING: Removed duplicated region for block: B:163:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0110  */
    /* renamed from: ClickableText-DauHOvk  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m4581ClickableTextDauHOvk(androidx.compose.ui.text.AnnotatedString r50, java.util.Map<java.lang.String, androidx.compose.foundation.text.InlineTextContent> r51, androidx.compose.ui.Modifier r52, long r53, androidx.compose.ui.text.TextStyle r55, boolean r56, int r57, int r58, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r59, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> r60, androidx.compose.runtime.Composer r61, int r62, int r63) {
        /*
            r11 = r60
            r12 = r62
            r13 = r63
            r0 = -1946013937(0xffffffff8c022f0f, float:-1.0028997E-31)
            r1 = r61
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            r1 = r13 & 1
            if (r1 == 0) goto L_0x0019
            r1 = r12 | 6
            r3 = r1
            r1 = r50
            goto L_0x002d
        L_0x0019:
            r1 = r12 & 14
            if (r1 != 0) goto L_0x002a
            r1 = r50
            boolean r3 = r0.changed((java.lang.Object) r1)
            if (r3 == 0) goto L_0x0027
            r3 = 4
            goto L_0x0028
        L_0x0027:
            r3 = 2
        L_0x0028:
            r3 = r3 | r12
            goto L_0x002d
        L_0x002a:
            r1 = r50
            r3 = r12
        L_0x002d:
            r4 = r13 & 2
            if (r4 == 0) goto L_0x0033
            r3 = r3 | 16
        L_0x0033:
            r5 = r13 & 4
            if (r5 == 0) goto L_0x003a
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x004d
        L_0x003a:
            r6 = r12 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x004d
            r6 = r52
            boolean r7 = r0.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0049
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x004b
        L_0x0049:
            r7 = 128(0x80, float:1.794E-43)
        L_0x004b:
            r3 = r3 | r7
            goto L_0x004f
        L_0x004d:
            r6 = r52
        L_0x004f:
            r7 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x0068
            r7 = r13 & 8
            if (r7 != 0) goto L_0x0062
            r7 = r53
            boolean r9 = r0.changed((long) r7)
            if (r9 == 0) goto L_0x0064
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x0066
        L_0x0062:
            r7 = r53
        L_0x0064:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x0066:
            r3 = r3 | r9
            goto L_0x006a
        L_0x0068:
            r7 = r53
        L_0x006a:
            r9 = 57344(0xe000, float:8.0356E-41)
            r10 = r12 & r9
            if (r10 != 0) goto L_0x0086
            r10 = r13 & 16
            if (r10 != 0) goto L_0x0080
            r10 = r55
            boolean r14 = r0.changed((java.lang.Object) r10)
            if (r14 == 0) goto L_0x0082
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0084
        L_0x0080:
            r10 = r55
        L_0x0082:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x0084:
            r3 = r3 | r14
            goto L_0x0088
        L_0x0086:
            r10 = r55
        L_0x0088:
            r14 = r13 & 32
            r15 = 458752(0x70000, float:6.42848E-40)
            if (r14 == 0) goto L_0x0095
            r16 = 196608(0x30000, float:2.75506E-40)
            r3 = r3 | r16
            r15 = r56
            goto L_0x00a8
        L_0x0095:
            r16 = r12 & r15
            r15 = r56
            if (r16 != 0) goto L_0x00a8
            boolean r16 = r0.changed((boolean) r15)
            if (r16 == 0) goto L_0x00a4
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00a6
        L_0x00a4:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00a6:
            r3 = r3 | r16
        L_0x00a8:
            r16 = r13 & 64
            r17 = 3670016(0x380000, float:5.142788E-39)
            if (r16 == 0) goto L_0x00b5
            r18 = 1572864(0x180000, float:2.204052E-39)
            r3 = r3 | r18
            r9 = r57
            goto L_0x00c8
        L_0x00b5:
            r18 = r12 & r17
            r9 = r57
            if (r18 != 0) goto L_0x00c8
            boolean r19 = r0.changed((int) r9)
            if (r19 == 0) goto L_0x00c4
            r19 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00c6
        L_0x00c4:
            r19 = 524288(0x80000, float:7.34684E-40)
        L_0x00c6:
            r3 = r3 | r19
        L_0x00c8:
            r2 = r13 & 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x00d3
            r20 = 12582912(0xc00000, float:1.7632415E-38)
            r3 = r3 | r20
            r1 = r58
            goto L_0x00e8
        L_0x00d3:
            r20 = 29360128(0x1c00000, float:7.052966E-38)
            r20 = r12 & r20
            r1 = r58
            if (r20 != 0) goto L_0x00e8
            boolean r20 = r0.changed((int) r1)
            if (r20 == 0) goto L_0x00e4
            r20 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00e6
        L_0x00e4:
            r20 = 4194304(0x400000, float:5.877472E-39)
        L_0x00e6:
            r3 = r3 | r20
        L_0x00e8:
            r1 = r13 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x00f3
            r20 = 100663296(0x6000000, float:2.4074124E-35)
            r3 = r3 | r20
            r6 = r59
            goto L_0x0108
        L_0x00f3:
            r20 = 234881024(0xe000000, float:1.5777218E-30)
            r20 = r12 & r20
            r6 = r59
            if (r20 != 0) goto L_0x0108
            boolean r20 = r0.changed((java.lang.Object) r6)
            if (r20 == 0) goto L_0x0104
            r20 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0106
        L_0x0104:
            r20 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0106:
            r3 = r3 | r20
        L_0x0108:
            r6 = r13 & 512(0x200, float:7.175E-43)
            if (r6 == 0) goto L_0x0110
            r6 = 805306368(0x30000000, float:4.656613E-10)
        L_0x010e:
            r3 = r3 | r6
            goto L_0x0121
        L_0x0110:
            r6 = 1879048192(0x70000000, float:1.58456325E29)
            r6 = r6 & r12
            if (r6 != 0) goto L_0x0121
            boolean r6 = r0.changed((java.lang.Object) r11)
            if (r6 == 0) goto L_0x011e
            r6 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x010e
        L_0x011e:
            r6 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x010e
        L_0x0121:
            int r6 = ~r13
            r19 = 2
            r6 = r6 & 2
            if (r6 != 0) goto L_0x014b
            r6 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r6 = r6 & r3
            r20 = 306783378(0x12492492, float:6.3469493E-28)
            r6 = r6 ^ r20
            if (r6 != 0) goto L_0x014b
            boolean r6 = r0.getSkipping()
            if (r6 != 0) goto L_0x013a
            goto L_0x014b
        L_0x013a:
            r0.skipToGroupEnd()
            r2 = r51
            r3 = r52
            r4 = r7
            r8 = r9
            r6 = r10
            r7 = r15
            r9 = r58
            r10 = r59
            goto L_0x02e4
        L_0x014b:
            r0.startDefaults()
            r6 = r12 & 1
            r20 = -57345(0xffffffffffff1fff, float:NaN)
            if (r6 == 0) goto L_0x017d
            boolean r6 = r0.getDefaultsInvalid()
            if (r6 == 0) goto L_0x015c
            goto L_0x017d
        L_0x015c:
            r0.skipToGroupEnd()
            if (r4 == 0) goto L_0x0163
            r3 = r3 & -113(0xffffffffffffff8f, float:NaN)
        L_0x0163:
            r1 = r13 & 8
            if (r1 == 0) goto L_0x0169
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0169:
            r1 = r13 & 16
            if (r1 == 0) goto L_0x016f
            r3 = r3 & r20
        L_0x016f:
            r1 = r51
            r5 = r52
            r2 = r58
            r6 = r7
            r4 = r10
            r8 = r15
        L_0x0178:
            r10 = r3
            r3 = r59
            goto L_0x01dc
        L_0x017d:
            if (r4 == 0) goto L_0x0186
            java.util.Map r4 = kotlin.collections.MapsKt.emptyMap()
            r3 = r3 & -113(0xffffffffffffff8f, float:NaN)
            goto L_0x0188
        L_0x0186:
            r4 = r51
        L_0x0188:
            if (r5 == 0) goto L_0x018f
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            goto L_0x0191
        L_0x018f:
            r5 = r52
        L_0x0191:
            r6 = r13 & 8
            r51 = r4
            r4 = 8
            if (r6 == 0) goto L_0x01a6
            com.stripe.android.ui.core.PaymentsTheme r6 = com.stripe.android.ui.core.PaymentsTheme.INSTANCE
            com.stripe.android.ui.core.PaymentsComposeColors r6 = r6.getColors(r0, r4)
            long r6 = r6.m4507getSubtitle0d7_KjU()
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
            goto L_0x01a7
        L_0x01a6:
            r6 = r7
        L_0x01a7:
            r8 = r13 & 16
            if (r8 == 0) goto L_0x01b8
            com.stripe.android.ui.core.PaymentsTheme r8 = com.stripe.android.ui.core.PaymentsTheme.INSTANCE
            androidx.compose.material.Typography r4 = r8.getTypography(r0, r4)
            androidx.compose.ui.text.TextStyle r4 = r4.getBody2()
            r3 = r3 & r20
            goto L_0x01b9
        L_0x01b8:
            r4 = r10
        L_0x01b9:
            if (r14 == 0) goto L_0x01bd
            r8 = 1
            goto L_0x01be
        L_0x01bd:
            r8 = r15
        L_0x01be:
            if (r16 == 0) goto L_0x01c6
            androidx.compose.ui.text.style.TextOverflow$Companion r9 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r9 = r9.m3788getClipgIe3tQ8()
        L_0x01c6:
            if (r2 == 0) goto L_0x01cc
            r2 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x01ce
        L_0x01cc:
            r2 = r58
        L_0x01ce:
            if (r1 == 0) goto L_0x01d9
            com.stripe.android.ui.core.elements.HtmlKt$ClickableText$1 r1 = com.stripe.android.ui.core.elements.HtmlKt$ClickableText$1.INSTANCE
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r10 = r3
            r3 = r1
            r1 = r51
            goto L_0x01dc
        L_0x01d9:
            r1 = r51
            goto L_0x0178
        L_0x01dc:
            r0.endDefaults()
            r14 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r0.startReplaceableGroup(r14)
            java.lang.String r14 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r14)
            java.lang.Object r14 = r0.rememberedValue()
            androidx.compose.runtime.Composer$Companion r15 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r15 = r15.getEmpty()
            r12 = 0
            if (r14 != r15) goto L_0x01ff
            r15 = 2
            androidx.compose.runtime.MutableState r14 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r12, r12, r15, r12)
            r0.updateRememberedValue(r14)
        L_0x01ff:
            r0.endReplaceableGroup()
            androidx.compose.runtime.MutableState r14 = (androidx.compose.runtime.MutableState) r14
            androidx.compose.ui.Modifier$Companion r15 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r15 = (androidx.compose.ui.Modifier) r15
            r12 = -3686552(0xffffffffffc7bf68, float:NaN)
            r0.startReplaceableGroup(r12)
            java.lang.String r12 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r12)
            boolean r16 = r0.changed((java.lang.Object) r14)
            boolean r19 = r0.changed((java.lang.Object) r11)
            r16 = r16 | r19
            java.lang.Object r13 = r0.rememberedValue()
            if (r16 != 0) goto L_0x022e
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            r53 = r1
            java.lang.Object r1 = r16.getEmpty()
            if (r13 != r1) goto L_0x023c
            goto L_0x0230
        L_0x022e:
            r53 = r1
        L_0x0230:
            com.stripe.android.ui.core.elements.HtmlKt$ClickableText$pressIndicator$1$1 r1 = new com.stripe.android.ui.core.elements.HtmlKt$ClickableText$pressIndicator$1$1
            r13 = 0
            r1.<init>(r14, r11, r13)
            r13 = r1
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r0.updateRememberedValue(r13)
        L_0x023c:
            r0.endReplaceableGroup()
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt.pointerInput((androidx.compose.ui.Modifier) r15, (java.lang.Object) r11, (kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r13)
            androidx.compose.ui.Modifier r15 = r5.then(r1)
            r23 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r37 = 0
            r38 = 0
            r39 = 0
            r40 = 0
            r41 = 0
            r43 = 0
            r44 = 262142(0x3fffe, float:3.67339E-40)
            r45 = 0
            r20 = r4
            r21 = r6
            androidx.compose.ui.text.TextStyle r16 = androidx.compose.ui.text.TextStyle.m3579copyHL5avdY$default(r20, r21, r23, r25, r26, r27, r28, r29, r30, r32, r33, r34, r35, r37, r38, r39, r40, r41, r43, r44, r45)
            r1 = -3686552(0xffffffffffc7bf68, float:NaN)
            r0.startReplaceableGroup(r1)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r12)
            boolean r1 = r0.changed((java.lang.Object) r14)
            boolean r12 = r0.changed((java.lang.Object) r3)
            r1 = r1 | r12
            java.lang.Object r12 = r0.rememberedValue()
            if (r1 != 0) goto L_0x0298
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r12 != r1) goto L_0x02a3
        L_0x0298:
            com.stripe.android.ui.core.elements.HtmlKt$ClickableText$2$1 r1 = new com.stripe.android.ui.core.elements.HtmlKt$ClickableText$2$1
            r1.<init>(r14, r3)
            r12 = r1
            kotlin.jvm.functions.Function1 r12 = (kotlin.jvm.functions.Function1) r12
            r0.updateRememberedValue(r12)
        L_0x02a3:
            r0.endReplaceableGroup()
            r1 = r12
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r12 = 16777216(0x1000000, float:2.3509887E-38)
            r13 = r10 & 14
            r12 = r12 | r13
            int r13 = r10 >> 6
            r14 = 57344(0xe000, float:8.0356E-41)
            r13 = r13 & r14
            r12 = r12 | r13
            r13 = 458752(0x70000, float:6.42848E-40)
            r13 = r13 & r10
            r12 = r12 | r13
            int r10 = r10 >> 3
            r10 = r10 & r17
            r23 = r12 | r10
            r24 = 0
            r14 = r50
            r17 = r1
            r18 = r9
            r19 = r8
            r20 = r2
            r21 = r53
            r22 = r0
            androidx.compose.foundation.text.BasicTextKt.m627BasicText4YKlhWE(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            r10 = r3
            r3 = r5
            r46 = r2
            r2 = r53
            r47 = r9
            r9 = r46
            r48 = r6
            r6 = r4
            r4 = r48
            r7 = r8
            r8 = r47
        L_0x02e4:
            androidx.compose.runtime.ScopeUpdateScope r14 = r0.endRestartGroup()
            if (r14 != 0) goto L_0x02eb
            goto L_0x02fe
        L_0x02eb:
            com.stripe.android.ui.core.elements.HtmlKt$ClickableText$3 r15 = new com.stripe.android.ui.core.elements.HtmlKt$ClickableText$3
            r0 = r15
            r1 = r50
            r11 = r60
            r12 = r62
            r13 = r63
            r0.<init>(r1, r2, r3, r4, r6, r7, r8, r9, r10, r11, r12, r13)
            kotlin.jvm.functions.Function2 r15 = (kotlin.jvm.functions.Function2) r15
            r14.updateScope(r15)
        L_0x02fe:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.ui.core.elements.HtmlKt.m4581ClickableTextDauHOvk(androidx.compose.ui.text.AnnotatedString, java.util.Map, androidx.compose.ui.Modifier, long, androidx.compose.ui.text.TextStyle, boolean, int, int, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }
}
