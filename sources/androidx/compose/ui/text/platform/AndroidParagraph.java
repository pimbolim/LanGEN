package androidx.compose.ui.text.platform;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.Paragraph;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.android.TextLayout;
import androidx.compose.ui.text.android.selection.WordBoundary;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.text.style.TextDecoration;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001Bg\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007\u0012\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\b0\u0007\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016B%\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0019J\u0010\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020\rH\u0016J\u0010\u0010O\u001a\u0002082\u0006\u0010N\u001a\u00020\rH\u0016J\u0010\u0010P\u001a\u0002082\u0006\u0010N\u001a\u00020\rH\u0016J\u0018\u0010Q\u001a\u00020\u00112\u0006\u0010N\u001a\u00020\r2\u0006\u0010R\u001a\u00020\u000fH\u0016J\u0010\u0010S\u001a\u00020\u00112\u0006\u0010T\u001a\u00020\rH\u0016J\u0018\u0010U\u001a\u00020\r2\u0006\u0010T\u001a\u00020\r2\u0006\u0010V\u001a\u00020\u000fH\u0016J\u0010\u0010W\u001a\u00020\r2\u0006\u0010N\u001a\u00020\rH\u0016J\u0010\u0010X\u001a\u00020\r2\u0006\u0010Y\u001a\u00020\u0011H\u0016J\u0010\u0010Z\u001a\u00020\u00112\u0006\u0010T\u001a\u00020\rH\u0016J\u0010\u0010[\u001a\u00020\u00112\u0006\u0010T\u001a\u00020\rH\u0016J\u0010\u0010\\\u001a\u00020\u00112\u0006\u0010T\u001a\u00020\rH\u0016J\u0010\u0010]\u001a\u00020\r2\u0006\u0010T\u001a\u00020\rH\u0016J\u0010\u0010^\u001a\u00020\u00112\u0006\u0010T\u001a\u00020\rH\u0016J\u0010\u0010_\u001a\u00020\u00112\u0006\u0010T\u001a\u00020\rH\u0016J\u001d\u0010`\u001a\u00020\r2\u0006\u0010a\u001a\u00020bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bc\u0010dJ\u0010\u0010e\u001a\u00020M2\u0006\u0010N\u001a\u00020\rH\u0016J\u0018\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020\r2\u0006\u0010i\u001a\u00020\rH\u0016J \u0010H\u001a\u00020j2\u0006\u0010N\u001a\u00020\rH\u0016ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\bk\u0010lJ\u0015\u0010m\u001a\u00020\u000f2\u0006\u0010T\u001a\u00020\rH\u0001¢\u0006\u0002\bnJ\u0010\u0010o\u001a\u00020\u000f2\u0006\u0010T\u001a\u00020\rH\u0016J9\u0010p\u001a\u00020q2\u0006\u0010r\u001a\u00020s2\u0006\u0010t\u001a\u00020u2\b\u0010v\u001a\u0004\u0018\u00010w2\b\u0010x\u001a\u0004\u0018\u00010yH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bz\u0010{R\u001a\u0010\u001a\u001a\u00020\u001b8@X\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0014\u0010$\u001a\u00020\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010&R\u0014\u0010)\u001a\u00020\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b*\u0010&R\u000e\u0010+\u001a\u00020,X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010-\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0014\u00100\u001a\u00020\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b1\u0010&R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b2\u0010/R\u0014\u00103\u001a\u00020\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b4\u0010&R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u001c\u00107\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001080\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u001a\u0010;\u001a\u00020<8@X\u0004¢\u0006\f\u0012\u0004\b=\u0010\u001d\u001a\u0004\b>\u0010?R\u001a\u0010@\u001a\u00020A8@X\u0004¢\u0006\f\u0012\u0004\bB\u0010\u001d\u001a\u0004\bC\u0010DR\u0014\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010&R\u001b\u0010F\u001a\u00020G8BX\u0002¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bH\u0010I\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006|"}, d2 = {"Landroidx/compose/ui/text/platform/AndroidParagraph;", "Landroidx/compose/ui/text/Paragraph;", "text", "", "style", "Landroidx/compose/ui/text/TextStyle;", "spanStyles", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/SpanStyle;", "placeholders", "Landroidx/compose/ui/text/Placeholder;", "maxLines", "", "ellipsis", "", "width", "", "typefaceAdapter", "Landroidx/compose/ui/text/platform/TypefaceAdapter;", "density", "Landroidx/compose/ui/unit/Density;", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;Ljava/util/List;IZFLandroidx/compose/ui/text/platform/TypefaceAdapter;Landroidx/compose/ui/unit/Density;)V", "paragraphIntrinsics", "Landroidx/compose/ui/text/platform/AndroidParagraphIntrinsics;", "(Landroidx/compose/ui/text/platform/AndroidParagraphIntrinsics;IZF)V", "charSequence", "", "getCharSequence$ui_text_release$annotations", "()V", "getCharSequence$ui_text_release", "()Ljava/lang/CharSequence;", "didExceedMaxLines", "getDidExceedMaxLines", "()Z", "getEllipsis", "firstBaseline", "getFirstBaseline", "()F", "height", "getHeight", "lastBaseline", "getLastBaseline", "layout", "Landroidx/compose/ui/text/android/TextLayout;", "lineCount", "getLineCount", "()I", "maxIntrinsicWidth", "getMaxIntrinsicWidth", "getMaxLines", "minIntrinsicWidth", "getMinIntrinsicWidth", "getParagraphIntrinsics", "()Landroidx/compose/ui/text/platform/AndroidParagraphIntrinsics;", "placeholderRects", "Landroidx/compose/ui/geometry/Rect;", "getPlaceholderRects", "()Ljava/util/List;", "textLocale", "Ljava/util/Locale;", "getTextLocale$ui_text_release$annotations", "getTextLocale$ui_text_release", "()Ljava/util/Locale;", "textPaint", "Landroidx/compose/ui/text/platform/AndroidTextPaint;", "getTextPaint$ui_text_release$annotations", "getTextPaint$ui_text_release", "()Landroidx/compose/ui/text/platform/AndroidTextPaint;", "getWidth", "wordBoundary", "Landroidx/compose/ui/text/android/selection/WordBoundary;", "getWordBoundary", "()Landroidx/compose/ui/text/android/selection/WordBoundary;", "wordBoundary$delegate", "Lkotlin/Lazy;", "getBidiRunDirection", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "offset", "getBoundingBox", "getCursorRect", "getHorizontalPosition", "usePrimaryDirection", "getLineBottom", "lineIndex", "getLineEnd", "visibleEnd", "getLineForOffset", "getLineForVerticalPosition", "vertical", "getLineHeight", "getLineLeft", "getLineRight", "getLineStart", "getLineTop", "getLineWidth", "getOffsetForPosition", "position", "Landroidx/compose/ui/geometry/Offset;", "getOffsetForPosition-k-4lQ0M", "(J)I", "getParagraphDirection", "getPathForRange", "Landroidx/compose/ui/graphics/Path;", "start", "end", "Landroidx/compose/ui/text/TextRange;", "getWordBoundary--jx7JFs", "(I)J", "isEllipsisApplied", "isEllipsisApplied$ui_text_release", "isLineEllipsized", "paint", "", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "color", "Landroidx/compose/ui/graphics/Color;", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "paint-RPmYEkk", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;)V", "ui-text_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AndroidParagraph.android.kt */
public final class AndroidParagraph implements Paragraph {
    private final boolean ellipsis;
    /* access modifiers changed from: private */
    public final TextLayout layout;
    private final int maxLines;
    private final AndroidParagraphIntrinsics paragraphIntrinsics;
    private final List<Rect> placeholderRects;
    private final float width;
    private final Lazy wordBoundary$delegate;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AndroidParagraph.android.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ResolvedTextDirection.values().length];
            iArr[ResolvedTextDirection.Ltr.ordinal()] = 1;
            iArr[ResolvedTextDirection.Rtl.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ void getCharSequence$ui_text_release$annotations() {
    }

    public static /* synthetic */ void getTextLocale$ui_text_release$annotations() {
    }

    public static /* synthetic */ void getTextPaint$ui_text_release$annotations() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: java.util.List<androidx.compose.ui.geometry.Rect>} */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0173, code lost:
        r10 = r10 + r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x019e, code lost:
        r10 = r9 - ((float) r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x01a1, code lost:
        r9 = new androidx.compose.ui.geometry.Rect(r7, r10, r8, ((float) r6.getHeightPx()) + r10);
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AndroidParagraph(androidx.compose.ui.text.platform.AndroidParagraphIntrinsics r26, int r27, boolean r28, float r29) {
        /*
            r25 = this;
            r0 = r25
            r1 = r26
            r12 = r27
            r2 = r28
            java.lang.String r3 = "paragraphIntrinsics"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            r25.<init>()
            r0.paragraphIntrinsics = r1
            r0.maxLines = r12
            r0.ellipsis = r2
            r3 = r29
            r0.width = r3
            r15 = 0
            r7 = 1
            if (r12 < r7) goto L_0x0020
            r3 = 1
            goto L_0x0021
        L_0x0020:
            r3 = 0
        L_0x0021:
            if (r3 == 0) goto L_0x01d7
            float r3 = r25.getWidth()
            r4 = 0
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 < 0) goto L_0x002e
            r3 = 1
            goto L_0x002f
        L_0x002e:
            r3 = 0
        L_0x002f:
            if (r3 == 0) goto L_0x01ca
            androidx.compose.ui.text.TextStyle r3 = r26.getStyle()
            androidx.compose.ui.text.style.TextAlign r4 = r3.m3589getTextAlignbuA522U()
            int r6 = androidx.compose.ui.text.platform.AndroidParagraph_androidKt.m3707toLayoutAlignAMY3VfE(r4)
            androidx.compose.ui.text.style.TextAlign r3 = r3.m3589getTextAlignbuA522U()
            androidx.compose.ui.text.style.TextAlign$Companion r4 = androidx.compose.ui.text.style.TextAlign.Companion
            int r4 = r4.m3758getJustifye0LSkKk()
            if (r3 != 0) goto L_0x004c
            r21 = 0
            goto L_0x0056
        L_0x004c:
            int r3 = r3.m3755unboximpl()
            boolean r3 = androidx.compose.ui.text.style.TextAlign.m3752equalsimpl0(r3, r4)
            r21 = r3
        L_0x0056:
            r22 = 0
            if (r2 == 0) goto L_0x005d
            android.text.TextUtils$TruncateAt r2 = android.text.TextUtils.TruncateAt.END
            goto L_0x0061
        L_0x005d:
            r2 = r22
            android.text.TextUtils$TruncateAt r2 = (android.text.TextUtils.TruncateAt) r2
        L_0x0061:
            r23 = r2
            java.lang.CharSequence r3 = r26.getCharSequence$ui_text_release()
            float r4 = r25.getWidth()
            androidx.compose.ui.text.platform.AndroidTextPaint r5 = r25.getTextPaint$ui_text_release()
            int r8 = r26.getTextDirectionHeuristic$ui_text_release()
            androidx.compose.ui.text.android.LayoutIntrinsics r18 = r26.getLayoutIntrinsics$ui_text_release()
            androidx.compose.ui.text.android.TextLayout r14 = new androidx.compose.ui.text.android.TextLayout
            r2 = r14
            android.text.TextPaint r5 = (android.text.TextPaint) r5
            r9 = 1065353216(0x3f800000, float:1.0)
            r10 = 0
            r11 = 0
            r13 = 0
            r16 = 0
            r24 = r14
            r14 = r16
            r16 = 0
            r17 = 0
            r19 = 28032(0x6d80, float:3.9281E-41)
            r20 = 0
            r7 = r23
            r12 = r27
            r1 = 0
            r15 = r21
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            r2 = r24
            r0.layout = r2
            java.lang.CharSequence r2 = r26.getCharSequence$ui_text_release()
            boolean r3 = r2 instanceof android.text.Spanned
            if (r3 != 0) goto L_0x00ab
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
            goto L_0x01b8
        L_0x00ab:
            r3 = r2
            android.text.Spanned r3 = (android.text.Spanned) r3
            int r2 = r2.length()
            java.lang.Class<androidx.compose.ui.text.android.style.PlaceholderSpan> r4 = androidx.compose.ui.text.android.style.PlaceholderSpan.class
            java.lang.Object[] r2 = r3.getSpans(r1, r2, r4)
            java.lang.String r4 = "getSpans(0, length, PlaceholderSpan::class.java)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            java.util.ArrayList r4 = new java.util.ArrayList
            int r5 = r2.length
            r4.<init>(r5)
            java.util.Collection r4 = (java.util.Collection) r4
            int r5 = r2.length
            r15 = 0
        L_0x00c7:
            if (r15 >= r5) goto L_0x01b5
            r6 = r2[r15]
            int r15 = r15 + 1
            androidx.compose.ui.text.android.style.PlaceholderSpan r6 = (androidx.compose.ui.text.android.style.PlaceholderSpan) r6
            int r7 = r3.getSpanStart(r6)
            int r8 = r3.getSpanEnd(r6)
            androidx.compose.ui.text.android.TextLayout r9 = r0.layout
            int r9 = r9.getLineForOffset(r7)
            androidx.compose.ui.text.android.TextLayout r10 = r0.layout
            int r10 = r10.getLineEllipsisCount(r9)
            if (r10 <= 0) goto L_0x00ef
            androidx.compose.ui.text.android.TextLayout r10 = r0.layout
            int r10 = r10.getLineEllipsisOffset(r9)
            if (r8 <= r10) goto L_0x00ef
            r10 = 1
            goto L_0x00f0
        L_0x00ef:
            r10 = 0
        L_0x00f0:
            androidx.compose.ui.text.android.TextLayout r11 = r0.layout
            int r11 = r11.getLineEnd(r9)
            if (r8 <= r11) goto L_0x00fa
            r8 = 1
            goto L_0x00fb
        L_0x00fa:
            r8 = 0
        L_0x00fb:
            if (r10 != 0) goto L_0x01ad
            if (r8 == 0) goto L_0x0101
            goto L_0x01ad
        L_0x0101:
            androidx.compose.ui.text.style.ResolvedTextDirection r8 = r0.getBidiRunDirection(r7)
            int[] r10 = androidx.compose.ui.text.platform.AndroidParagraph.WhenMappings.$EnumSwitchMapping$0
            int r8 = r8.ordinal()
            r8 = r10[r8]
            r10 = 2
            r11 = 1
            if (r8 == r11) goto L_0x0124
            if (r8 != r10) goto L_0x011e
            float r7 = r0.getHorizontalPosition(r7, r11)
            int r8 = r6.getWidthPx()
            float r8 = (float) r8
            float r7 = r7 - r8
            goto L_0x0128
        L_0x011e:
            kotlin.NoWhenBranchMatchedException r1 = new kotlin.NoWhenBranchMatchedException
            r1.<init>()
            throw r1
        L_0x0124:
            float r7 = r0.getHorizontalPosition(r7, r11)
        L_0x0128:
            int r8 = r6.getWidthPx()
            float r8 = (float) r8
            float r8 = r8 + r7
            androidx.compose.ui.text.android.TextLayout r12 = r0.layout
            int r13 = r6.getVerticalAlign()
            switch(r13) {
                case 0: goto L_0x0196;
                case 1: goto L_0x0191;
                case 2: goto L_0x0188;
                case 3: goto L_0x0175;
                case 4: goto L_0x0168;
                case 5: goto L_0x0155;
                case 6: goto L_0x0140;
                default: goto L_0x0137;
            }
        L_0x0137:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "unexpected verticalAlignment"
            r1.<init>(r2)
            throw r1
        L_0x0140:
            android.graphics.Paint$FontMetricsInt r13 = r6.getFontMetrics()
            int r14 = r13.ascent
            int r13 = r13.descent
            int r14 = r14 + r13
            int r13 = r6.getHeightPx()
            int r14 = r14 - r13
            int r14 = r14 / r10
            float r10 = (float) r14
            float r9 = r12.getLineBaseline(r9)
            goto L_0x0173
        L_0x0155:
            android.graphics.Paint$FontMetricsInt r10 = r6.getFontMetrics()
            int r10 = r10.descent
            float r10 = (float) r10
            float r9 = r12.getLineBaseline(r9)
            float r10 = r10 + r9
            int r9 = r6.getHeightPx()
            float r9 = (float) r9
            float r10 = r10 - r9
            goto L_0x01a1
        L_0x0168:
            android.graphics.Paint$FontMetricsInt r10 = r6.getFontMetrics()
            int r10 = r10.ascent
            float r10 = (float) r10
            float r9 = r12.getLineBaseline(r9)
        L_0x0173:
            float r10 = r10 + r9
            goto L_0x01a1
        L_0x0175:
            float r13 = r12.getLineTop(r9)
            float r9 = r12.getLineBottom(r9)
            float r13 = r13 + r9
            int r9 = r6.getHeightPx()
            float r9 = (float) r9
            float r13 = r13 - r9
            float r9 = (float) r10
            float r10 = r13 / r9
            goto L_0x01a1
        L_0x0188:
            float r9 = r12.getLineBottom(r9)
            int r10 = r6.getHeightPx()
            goto L_0x019e
        L_0x0191:
            float r10 = r12.getLineTop(r9)
            goto L_0x01a1
        L_0x0196:
            float r9 = r12.getLineBaseline(r9)
            int r10 = r6.getHeightPx()
        L_0x019e:
            float r10 = (float) r10
            float r10 = r9 - r10
        L_0x01a1:
            int r6 = r6.getHeightPx()
            float r6 = (float) r6
            float r6 = r6 + r10
            androidx.compose.ui.geometry.Rect r9 = new androidx.compose.ui.geometry.Rect
            r9.<init>(r7, r10, r8, r6)
            goto L_0x01b0
        L_0x01ad:
            r11 = 1
            r9 = r22
        L_0x01b0:
            r4.add(r9)
            goto L_0x00c7
        L_0x01b5:
            r1 = r4
            java.util.List r1 = (java.util.List) r1
        L_0x01b8:
            r0.placeholderRects = r1
            kotlin.LazyThreadSafetyMode r1 = kotlin.LazyThreadSafetyMode.NONE
            androidx.compose.ui.text.platform.AndroidParagraph$wordBoundary$2 r2 = new androidx.compose.ui.text.platform.AndroidParagraph$wordBoundary$2
            r2.<init>(r0)
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            kotlin.Lazy r1 = kotlin.LazyKt.lazy((kotlin.LazyThreadSafetyMode) r1, r2)
            r0.wordBoundary$delegate = r1
            return
        L_0x01ca:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "width should not be negative"
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x01d7:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "maxLines should be greater than 0"
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.platform.AndroidParagraph.<init>(androidx.compose.ui.text.platform.AndroidParagraphIntrinsics, int, boolean, float):void");
    }

    public final AndroidParagraphIntrinsics getParagraphIntrinsics() {
        return this.paragraphIntrinsics;
    }

    public final int getMaxLines() {
        return this.maxLines;
    }

    public final boolean getEllipsis() {
        return this.ellipsis;
    }

    public float getWidth() {
        return this.width;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AndroidParagraph(java.lang.String r9, androidx.compose.ui.text.TextStyle r10, java.util.List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.SpanStyle>> r11, java.util.List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.Placeholder>> r12, int r13, boolean r14, float r15, androidx.compose.ui.text.platform.TypefaceAdapter r16, androidx.compose.ui.unit.Density r17) {
        /*
            r8 = this;
            java.lang.String r0 = "text"
            r2 = r9
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "style"
            r3 = r10
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "spanStyles"
            r4 = r11
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "placeholders"
            r5 = r12
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "typefaceAdapter"
            r6 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "density"
            r7 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            androidx.compose.ui.text.platform.AndroidParagraphIntrinsics r0 = new androidx.compose.ui.text.platform.AndroidParagraphIntrinsics
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7)
            r1 = r8
            r2 = r13
            r3 = r14
            r4 = r15
            r8.<init>(r0, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.platform.AndroidParagraph.<init>(java.lang.String, androidx.compose.ui.text.TextStyle, java.util.List, java.util.List, int, boolean, float, androidx.compose.ui.text.platform.TypefaceAdapter, androidx.compose.ui.unit.Density):void");
    }

    public float getHeight() {
        return (float) this.layout.getHeight();
    }

    public float getMaxIntrinsicWidth() {
        return this.paragraphIntrinsics.getMaxIntrinsicWidth();
    }

    public float getMinIntrinsicWidth() {
        return this.paragraphIntrinsics.getMinIntrinsicWidth();
    }

    public float getFirstBaseline() {
        return this.layout.getLineBaseline(0);
    }

    public float getLastBaseline() {
        if (this.maxLines < getLineCount()) {
            return this.layout.getLineBaseline(this.maxLines - 1);
        }
        return this.layout.getLineBaseline(getLineCount() - 1);
    }

    public boolean getDidExceedMaxLines() {
        return this.layout.getDidExceedMaxLines();
    }

    public final Locale getTextLocale$ui_text_release() {
        Locale textLocale = this.paragraphIntrinsics.getTextPaint$ui_text_release().getTextLocale();
        Intrinsics.checkNotNullExpressionValue(textLocale, "paragraphIntrinsics.textPaint.textLocale");
        return textLocale;
    }

    public int getLineCount() {
        return this.layout.getLineCount();
    }

    public List<Rect> getPlaceholderRects() {
        return this.placeholderRects;
    }

    public final CharSequence getCharSequence$ui_text_release() {
        return this.paragraphIntrinsics.getCharSequence$ui_text_release();
    }

    public final AndroidTextPaint getTextPaint$ui_text_release() {
        return this.paragraphIntrinsics.getTextPaint$ui_text_release();
    }

    public int getLineForVerticalPosition(float f) {
        return this.layout.getLineForVertical((int) f);
    }

    /* renamed from: getOffsetForPosition-k-4lQ0M  reason: not valid java name */
    public int m3701getOffsetForPositionk4lQ0M(long j) {
        return this.layout.getOffsetForHorizontal(this.layout.getLineForVertical((int) Offset.m1354getYimpl(j)), Offset.m1353getXimpl(j));
    }

    public Rect getBoundingBox(int i) {
        float primaryHorizontal = this.layout.getPrimaryHorizontal(i);
        float primaryHorizontal2 = this.layout.getPrimaryHorizontal(i + 1);
        int lineForOffset = this.layout.getLineForOffset(i);
        return new Rect(primaryHorizontal, this.layout.getLineTop(lineForOffset), primaryHorizontal2, this.layout.getLineBottom(lineForOffset));
    }

    public Path getPathForRange(int i, int i2) {
        boolean z = false;
        if (i >= 0 && i <= i2) {
            z = true;
        }
        if (!z || i2 > getCharSequence$ui_text_release().length()) {
            throw new AssertionError("Start(" + i + ") or End(" + i2 + ") is out of Range(0.." + getCharSequence$ui_text_release().length() + "), or start > end!");
        }
        android.graphics.Path path = new android.graphics.Path();
        this.layout.getSelectionPath(i, i2, path);
        return AndroidPath_androidKt.asComposePath(path);
    }

    public Rect getCursorRect(int i) {
        boolean z = false;
        if (i >= 0 && i <= getCharSequence$ui_text_release().length()) {
            z = true;
        }
        if (z) {
            float primaryHorizontal = this.layout.getPrimaryHorizontal(i);
            int lineForOffset = this.layout.getLineForOffset(i);
            return new Rect(primaryHorizontal, this.layout.getLineTop(lineForOffset), primaryHorizontal, this.layout.getLineBottom(lineForOffset));
        }
        throw new AssertionError("offset(" + i + ") is out of bounds (0," + getCharSequence$ui_text_release().length());
    }

    private final WordBoundary getWordBoundary() {
        return (WordBoundary) this.wordBoundary$delegate.getValue();
    }

    /* renamed from: getWordBoundary--jx7JFs  reason: not valid java name */
    public long m3702getWordBoundaryjx7JFs(int i) {
        return TextRangeKt.TextRange(getWordBoundary().getWordStart(i), getWordBoundary().getWordEnd(i));
    }

    public float getLineLeft(int i) {
        return this.layout.getLineLeft(i);
    }

    public float getLineRight(int i) {
        return this.layout.getLineRight(i);
    }

    public float getLineTop(int i) {
        return this.layout.getLineTop(i);
    }

    public float getLineBottom(int i) {
        return this.layout.getLineBottom(i);
    }

    public float getLineHeight(int i) {
        return this.layout.getLineHeight(i);
    }

    public float getLineWidth(int i) {
        return this.layout.getLineWidth(i);
    }

    public int getLineStart(int i) {
        return this.layout.getLineStart(i);
    }

    public int getLineEnd(int i, boolean z) {
        if (z) {
            return this.layout.getLineVisibleEnd(i);
        }
        return this.layout.getLineEnd(i);
    }

    public boolean isLineEllipsized(int i) {
        return this.layout.isLineEllipsized(i);
    }

    public int getLineForOffset(int i) {
        return this.layout.getLineForOffset(i);
    }

    public float getHorizontalPosition(int i, boolean z) {
        if (z) {
            return this.layout.getPrimaryHorizontal(i);
        }
        return this.layout.getSecondaryHorizontal(i);
    }

    public ResolvedTextDirection getParagraphDirection(int i) {
        return this.layout.getParagraphDirection(this.layout.getLineForOffset(i)) == 1 ? ResolvedTextDirection.Ltr : ResolvedTextDirection.Rtl;
    }

    public ResolvedTextDirection getBidiRunDirection(int i) {
        if (this.layout.isRtlCharAt(i)) {
            return ResolvedTextDirection.Rtl;
        }
        return ResolvedTextDirection.Ltr;
    }

    public final boolean isEllipsisApplied$ui_text_release(int i) {
        return this.layout.isEllipsisApplied(i);
    }

    /* renamed from: paint-RPmYEkk  reason: not valid java name */
    public void m3703paintRPmYEkk(Canvas canvas, long j, Shadow shadow, TextDecoration textDecoration) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        getTextPaint$ui_text_release().m3708setColor8_81llA(j);
        getTextPaint$ui_text_release().setShadow(shadow);
        getTextPaint$ui_text_release().setTextDecoration(textDecoration);
        android.graphics.Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
        if (getDidExceedMaxLines()) {
            nativeCanvas.save();
            nativeCanvas.clipRect(0.0f, 0.0f, getWidth(), getHeight());
        }
        this.layout.paint(nativeCanvas);
        if (getDidExceedMaxLines()) {
            nativeCanvas.restore();
        }
    }
}
