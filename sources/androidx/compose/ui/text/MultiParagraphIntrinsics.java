package androidx.compose.ui.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.Density;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010\u0004\u001a\u00020 2\u0006\u0010!\u001a\u00020 H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0015\u001a\u00020\u00168VX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001b\u001a\u00020\u00168VX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001a\u001a\u0004\b\u001c\u0010\u0018R\u001d\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014¨\u0006\""}, d2 = {"Landroidx/compose/ui/text/MultiParagraphIntrinsics;", "Landroidx/compose/ui/text/ParagraphIntrinsics;", "annotatedString", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "density", "Landroidx/compose/ui/unit/Density;", "resourceLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/Font$ResourceLoader;)V", "getAnnotatedString", "()Landroidx/compose/ui/text/AnnotatedString;", "infoList", "Landroidx/compose/ui/text/ParagraphIntrinsicInfo;", "getInfoList$ui_text_release", "()Ljava/util/List;", "maxIntrinsicWidth", "", "getMaxIntrinsicWidth", "()F", "maxIntrinsicWidth$delegate", "Lkotlin/Lazy;", "minIntrinsicWidth", "getMinIntrinsicWidth", "minIntrinsicWidth$delegate", "getPlaceholders", "resolveTextDirection", "Landroidx/compose/ui/text/ParagraphStyle;", "defaultStyle", "ui-text_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MultiParagraphIntrinsics.kt */
public final class MultiParagraphIntrinsics implements ParagraphIntrinsics {
    private final AnnotatedString annotatedString;
    private final List<ParagraphIntrinsicInfo> infoList;
    private final Lazy maxIntrinsicWidth$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new MultiParagraphIntrinsics$maxIntrinsicWidth$2(this));
    private final Lazy minIntrinsicWidth$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new MultiParagraphIntrinsics$minIntrinsicWidth$2(this));
    private final List<AnnotatedString.Range<Placeholder>> placeholders;

    public MultiParagraphIntrinsics(AnnotatedString annotatedString2, TextStyle textStyle, List<AnnotatedString.Range<Placeholder>> list, Density density, Font.ResourceLoader resourceLoader) {
        AnnotatedString annotatedString3 = annotatedString2;
        TextStyle textStyle2 = textStyle;
        List<AnnotatedString.Range<Placeholder>> list2 = list;
        Intrinsics.checkNotNullParameter(annotatedString3, "annotatedString");
        Intrinsics.checkNotNullParameter(textStyle2, "style");
        Intrinsics.checkNotNullParameter(list2, "placeholders");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(resourceLoader, "resourceLoader");
        this.annotatedString = annotatedString3;
        this.placeholders = list2;
        ParagraphStyle paragraphStyle = textStyle.toParagraphStyle();
        List<AnnotatedString.Range<ParagraphStyle>> normalizedParagraphStyles = AnnotatedStringKt.normalizedParagraphStyles(annotatedString3, paragraphStyle);
        ArrayList arrayList = new ArrayList(normalizedParagraphStyles.size());
        int size = normalizedParagraphStyles.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            AnnotatedString.Range range = normalizedParagraphStyles.get(i);
            AnnotatedString access$substringWithoutParagraphStyles = AnnotatedStringKt.substringWithoutParagraphStyles(annotatedString3, range.getStart(), range.getEnd());
            ParagraphStyle access$resolveTextDirection = resolveTextDirection((ParagraphStyle) range.getItem(), paragraphStyle);
            arrayList.add(new ParagraphIntrinsicInfo(ParagraphIntrinsicsKt.ParagraphIntrinsics(access$substringWithoutParagraphStyles.getText(), textStyle2.merge(access$resolveTextDirection), access$substringWithoutParagraphStyles.getSpanStyles(), MultiParagraphIntrinsicsKt.getLocalPlaceholders(getPlaceholders(), range.getStart(), range.getEnd()), density, resourceLoader), range.getStart(), range.getEnd()));
            annotatedString3 = annotatedString2;
            textStyle2 = textStyle;
            i = i2;
        }
        this.infoList = arrayList;
    }

    public final AnnotatedString getAnnotatedString() {
        return this.annotatedString;
    }

    public final List<AnnotatedString.Range<Placeholder>> getPlaceholders() {
        return this.placeholders;
    }

    public float getMinIntrinsicWidth() {
        return ((Number) this.minIntrinsicWidth$delegate.getValue()).floatValue();
    }

    public float getMaxIntrinsicWidth() {
        return ((Number) this.maxIntrinsicWidth$delegate.getValue()).floatValue();
    }

    public final List<ParagraphIntrinsicInfo> getInfoList$ui_text_release() {
        return this.infoList;
    }

    /* access modifiers changed from: private */
    public final ParagraphStyle resolveTextDirection(ParagraphStyle paragraphStyle, ParagraphStyle paragraphStyle2) {
        ParagraphStyle paragraphStyle3;
        TextDirection r0 = paragraphStyle.m3508getTextDirectionmmuk1to();
        if (r0 == null) {
            paragraphStyle3 = null;
        } else {
            r0.m3768unboximpl();
            paragraphStyle3 = paragraphStyle;
        }
        if (paragraphStyle3 != null) {
            return paragraphStyle3;
        }
        return ParagraphStyle.m3504copyElsmlbk$default(paragraphStyle, (TextAlign) null, paragraphStyle2.m3508getTextDirectionmmuk1to(), 0, (TextIndent) null, 13, (Object) null);
    }
}
