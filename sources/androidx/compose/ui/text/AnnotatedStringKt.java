package androidx.compose.ui.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.intl.LocaleList;
import com.nimbusds.jose.HeaderParameterNames;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000l\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0016\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a\"\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u001a%\u0010\t\u001a\u00020\u00012\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\bø\u0001\u0000\u001a(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012H\u0000\u001a\b\u0010\u0016\u001a\u00020\u0001H\u0000\u001a@\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001a0\u00190\u0018\"\u0004\b\u0000\u0010\u001a2\u0014\u0010\u001b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u0002H\u001a0\u00190\u00182\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0012H\u0002\u001a(\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u0012H\u0000\u001a\u0014\u0010#\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010$\u001a\u00020%\u001a\u0014\u0010&\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010$\u001a\u00020%\u001a(\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00190\u0018*\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0012H\u0002\u001ad\u0010(\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u0018\"\u0004\b\u0000\u0010\u001a*\u00020\u00012\u0006\u0010)\u001a\u00020\u00062>\b\u0004\u0010*\u001a8\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00060\u0019¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u0002H\u001a0+H\bø\u0001\u0000\u001a \u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00190\u0018*\u00020\u00012\u0006\u0010)\u001a\u00020\u0006H\u0000\u001a\u001c\u00100\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0012H\u0002\u001a\u0014\u00101\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010$\u001a\u00020%\u001a\u0014\u00102\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010$\u001a\u00020%\u001aB\u00103\u001a\u0002H4\"\b\b\u0000\u00104*\u000205*\u00020\f2\u0006\u00106\u001a\u0002072\u0019\b\u0004\u0010*\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002H40\u000b¢\u0006\u0002\b\u000eH\bø\u0001\u0000¢\u0006\u0002\u00108\u001aJ\u00103\u001a\u0002H4\"\b\b\u0000\u00104*\u000205*\u00020\f2\u0006\u00109\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u00042\u0019\b\u0004\u0010*\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002H40\u000b¢\u0006\u0002\b\u000eH\bø\u0001\u0000¢\u0006\u0002\u0010;\u001aB\u0010<\u001a\u0002H4\"\b\b\u0000\u00104*\u000205*\u00020\f2\u0006\u0010=\u001a\u00020\u00062\u0019\b\u0004\u0010*\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002H40\u000b¢\u0006\u0002\b\u000eH\bø\u0001\u0000¢\u0006\u0002\u0010>\u001aB\u0010<\u001a\u0002H4\"\b\b\u0000\u00104*\u000205*\u00020\f2\u0006\u0010=\u001a\u00020\b2\u0019\b\u0004\u0010*\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002H40\u000b¢\u0006\u0002\b\u000eH\bø\u0001\u0000¢\u0006\u0002\u0010?\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006@"}, d2 = {"EmptyAnnotatedString", "Landroidx/compose/ui/text/AnnotatedString;", "AnnotatedString", "text", "", "paragraphStyle", "Landroidx/compose/ui/text/ParagraphStyle;", "spanStyle", "Landroidx/compose/ui/text/SpanStyle;", "buildAnnotatedString", "builder", "Lkotlin/Function1;", "Landroidx/compose/ui/text/AnnotatedString$Builder;", "", "Lkotlin/ExtensionFunctionType;", "contains", "", "baseStart", "", "baseEnd", "targetStart", "targetEnd", "emptyAnnotatedString", "filterRanges", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "T", "ranges", "start", "end", "intersect", "lStart", "lEnd", "rStart", "rEnd", "capitalize", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "decapitalize", "getLocalStyles", "mapEachParagraphStyle", "defaultParagraphStyle", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "annotatedString", "normalizedParagraphStyles", "substringWithoutParagraphStyles", "toLowerCase", "toUpperCase", "withAnnotation", "R", "", "ttsAnnotation", "Landroidx/compose/ui/text/TtsAnnotation;", "(Landroidx/compose/ui/text/AnnotatedString$Builder;Landroidx/compose/ui/text/TtsAnnotation;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "tag", "annotation", "(Landroidx/compose/ui/text/AnnotatedString$Builder;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "withStyle", "style", "(Landroidx/compose/ui/text/AnnotatedString$Builder;Landroidx/compose/ui/text/ParagraphStyle;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Landroidx/compose/ui/text/AnnotatedString$Builder;Landroidx/compose/ui/text/SpanStyle;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "ui-text_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: AnnotatedString.kt */
public final class AnnotatedStringKt {
    private static final AnnotatedString EmptyAnnotatedString = new AnnotatedString("", (List) null, (List) null, 6, (DefaultConstructorMarker) null);

    public static final boolean contains(int i, int i2, int i3, int i4) {
        if (i <= i3 && i4 <= i2) {
            if (i2 != i4) {
                return true;
            }
            if ((i3 == i4) == (i == i2)) {
                return true;
            }
        }
        return false;
    }

    public static final List<AnnotatedString.Range<ParagraphStyle>> normalizedParagraphStyles(AnnotatedString annotatedString, ParagraphStyle paragraphStyle) {
        Intrinsics.checkNotNullParameter(annotatedString, "<this>");
        Intrinsics.checkNotNullParameter(paragraphStyle, "defaultParagraphStyle");
        int length = annotatedString.getText().length();
        List<AnnotatedString.Range<ParagraphStyle>> paragraphStyles = annotatedString.getParagraphStyles();
        List<AnnotatedString.Range<ParagraphStyle>> arrayList = new ArrayList<>();
        int size = paragraphStyles.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3 = i + 1;
            AnnotatedString.Range range = paragraphStyles.get(i);
            ParagraphStyle paragraphStyle2 = (ParagraphStyle) range.component1();
            int component2 = range.component2();
            int component3 = range.component3();
            if (component2 != i2) {
                arrayList.add(new AnnotatedString.Range(paragraphStyle, i2, component2));
            }
            arrayList.add(new AnnotatedString.Range(paragraphStyle.merge(paragraphStyle2), component2, component3));
            i2 = component3;
            i = i3;
        }
        if (i2 != length) {
            arrayList.add(new AnnotatedString.Range(paragraphStyle, i2, length));
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new AnnotatedString.Range(paragraphStyle, 0, 0));
        }
        return arrayList;
    }

    private static final List<AnnotatedString.Range<SpanStyle>> getLocalStyles(AnnotatedString annotatedString, int i, int i2) {
        if (i == i2) {
            return CollectionsKt.emptyList();
        }
        if (i == 0 && i2 >= annotatedString.getText().length()) {
            return annotatedString.getSpanStyles();
        }
        List<AnnotatedString.Range<SpanStyle>> spanStyles = annotatedString.getSpanStyles();
        ArrayList arrayList = new ArrayList(spanStyles.size());
        int size = spanStyles.size();
        int i3 = 0;
        int i4 = 0;
        while (i4 < size) {
            int i5 = i4 + 1;
            AnnotatedString.Range<SpanStyle> range = spanStyles.get(i4);
            AnnotatedString.Range range2 = range;
            if (intersect(i, i2, range2.getStart(), range2.getEnd())) {
                arrayList.add(range);
            }
            i4 = i5;
        }
        List list = arrayList;
        ArrayList arrayList2 = new ArrayList(list.size());
        int size2 = list.size();
        while (i3 < size2) {
            int i6 = i3 + 1;
            AnnotatedString.Range range3 = (AnnotatedString.Range) list.get(i3);
            arrayList2.add(new AnnotatedString.Range(range3.getItem(), RangesKt.coerceIn(range3.getStart(), i, i2) - i, RangesKt.coerceIn(range3.getEnd(), i, i2) - i));
            i3 = i6;
        }
        return arrayList2;
    }

    /* access modifiers changed from: private */
    public static final AnnotatedString substringWithoutParagraphStyles(AnnotatedString annotatedString, int i, int i2) {
        String str;
        if (i != i2) {
            str = annotatedString.getText().substring(i, i2);
            Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String…ing(startIndex, endIndex)");
        } else {
            str = "";
        }
        return new AnnotatedString(str, getLocalStyles(annotatedString, i, i2), (List) null, 4, (DefaultConstructorMarker) null);
    }

    public static final <T> List<T> mapEachParagraphStyle(AnnotatedString annotatedString, ParagraphStyle paragraphStyle, Function2<? super AnnotatedString, ? super AnnotatedString.Range<ParagraphStyle>, ? extends T> function2) {
        Intrinsics.checkNotNullParameter(annotatedString, "<this>");
        Intrinsics.checkNotNullParameter(paragraphStyle, "defaultParagraphStyle");
        Intrinsics.checkNotNullParameter(function2, "block");
        List<AnnotatedString.Range<ParagraphStyle>> normalizedParagraphStyles = normalizedParagraphStyles(annotatedString, paragraphStyle);
        ArrayList arrayList = new ArrayList(normalizedParagraphStyles.size());
        int size = normalizedParagraphStyles.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            AnnotatedString.Range range = normalizedParagraphStyles.get(i);
            arrayList.add(function2.invoke(substringWithoutParagraphStyles(annotatedString, range.getStart(), range.getEnd()), range));
            i = i2;
        }
        return arrayList;
    }

    public static /* synthetic */ AnnotatedString toUpperCase$default(AnnotatedString annotatedString, LocaleList localeList, int i, Object obj) {
        if ((i & 1) != 0) {
            localeList = LocaleList.Companion.getCurrent();
        }
        return toUpperCase(annotatedString, localeList);
    }

    public static final AnnotatedString toUpperCase(AnnotatedString annotatedString, LocaleList localeList) {
        Intrinsics.checkNotNullParameter(annotatedString, "<this>");
        Intrinsics.checkNotNullParameter(localeList, "localeList");
        return JvmAnnotatedString_jvmKt.transform(annotatedString, new AnnotatedStringKt$toUpperCase$1(localeList));
    }

    public static /* synthetic */ AnnotatedString toLowerCase$default(AnnotatedString annotatedString, LocaleList localeList, int i, Object obj) {
        if ((i & 1) != 0) {
            localeList = LocaleList.Companion.getCurrent();
        }
        return toLowerCase(annotatedString, localeList);
    }

    public static final AnnotatedString toLowerCase(AnnotatedString annotatedString, LocaleList localeList) {
        Intrinsics.checkNotNullParameter(annotatedString, "<this>");
        Intrinsics.checkNotNullParameter(localeList, "localeList");
        return JvmAnnotatedString_jvmKt.transform(annotatedString, new AnnotatedStringKt$toLowerCase$1(localeList));
    }

    public static /* synthetic */ AnnotatedString capitalize$default(AnnotatedString annotatedString, LocaleList localeList, int i, Object obj) {
        if ((i & 1) != 0) {
            localeList = LocaleList.Companion.getCurrent();
        }
        return capitalize(annotatedString, localeList);
    }

    public static final AnnotatedString capitalize(AnnotatedString annotatedString, LocaleList localeList) {
        Intrinsics.checkNotNullParameter(annotatedString, "<this>");
        Intrinsics.checkNotNullParameter(localeList, "localeList");
        return JvmAnnotatedString_jvmKt.transform(annotatedString, new AnnotatedStringKt$capitalize$1(localeList));
    }

    public static /* synthetic */ AnnotatedString decapitalize$default(AnnotatedString annotatedString, LocaleList localeList, int i, Object obj) {
        if ((i & 1) != 0) {
            localeList = LocaleList.Companion.getCurrent();
        }
        return decapitalize(annotatedString, localeList);
    }

    public static final AnnotatedString decapitalize(AnnotatedString annotatedString, LocaleList localeList) {
        Intrinsics.checkNotNullParameter(annotatedString, "<this>");
        Intrinsics.checkNotNullParameter(localeList, "localeList");
        return JvmAnnotatedString_jvmKt.transform(annotatedString, new AnnotatedStringKt$decapitalize$1(localeList));
    }

    public static final <R> R withStyle(AnnotatedString.Builder builder, SpanStyle spanStyle, Function1<? super AnnotatedString.Builder, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(spanStyle, "style");
        Intrinsics.checkNotNullParameter(function1, "block");
        int pushStyle = builder.pushStyle(spanStyle);
        try {
            return function1.invoke(builder);
        } finally {
            InlineMarker.finallyStart(1);
            builder.pop(pushStyle);
            InlineMarker.finallyEnd(1);
        }
    }

    public static final <R> R withStyle(AnnotatedString.Builder builder, ParagraphStyle paragraphStyle, Function1<? super AnnotatedString.Builder, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(paragraphStyle, "style");
        Intrinsics.checkNotNullParameter(function1, "block");
        int pushStyle = builder.pushStyle(paragraphStyle);
        try {
            return function1.invoke(builder);
        } finally {
            InlineMarker.finallyStart(1);
            builder.pop(pushStyle);
            InlineMarker.finallyEnd(1);
        }
    }

    @ExperimentalTextApi
    public static final <R> R withAnnotation(AnnotatedString.Builder builder, String str, String str2, Function1<? super AnnotatedString.Builder, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(str, HeaderParameterNames.AUTHENTICATION_TAG);
        Intrinsics.checkNotNullParameter(str2, "annotation");
        Intrinsics.checkNotNullParameter(function1, "block");
        int pushStringAnnotation = builder.pushStringAnnotation(str, str2);
        try {
            return function1.invoke(builder);
        } finally {
            InlineMarker.finallyStart(1);
            builder.pop(pushStringAnnotation);
            InlineMarker.finallyEnd(1);
        }
    }

    @ExperimentalTextApi
    public static final <R> R withAnnotation(AnnotatedString.Builder builder, TtsAnnotation ttsAnnotation, Function1<? super AnnotatedString.Builder, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(ttsAnnotation, "ttsAnnotation");
        Intrinsics.checkNotNullParameter(function1, "block");
        int pushTtsAnnotation = builder.pushTtsAnnotation(ttsAnnotation);
        try {
            return function1.invoke(builder);
        } finally {
            InlineMarker.finallyStart(1);
            builder.pop(pushTtsAnnotation);
            InlineMarker.finallyEnd(1);
        }
    }

    public static /* synthetic */ AnnotatedString AnnotatedString$default(String str, SpanStyle spanStyle, ParagraphStyle paragraphStyle, int i, Object obj) {
        if ((i & 4) != 0) {
            paragraphStyle = null;
        }
        return AnnotatedString(str, spanStyle, paragraphStyle);
    }

    public static final AnnotatedString AnnotatedString(String str, SpanStyle spanStyle, ParagraphStyle paragraphStyle) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(spanStyle, "spanStyle");
        return new AnnotatedString(str, CollectionsKt.listOf(new AnnotatedString.Range(spanStyle, 0, str.length())), paragraphStyle == null ? CollectionsKt.emptyList() : CollectionsKt.listOf(new AnnotatedString.Range(paragraphStyle, 0, str.length())));
    }

    public static final AnnotatedString AnnotatedString(String str, ParagraphStyle paragraphStyle) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(paragraphStyle, "paragraphStyle");
        return new AnnotatedString(str, CollectionsKt.emptyList(), CollectionsKt.listOf(new AnnotatedString.Range(paragraphStyle, 0, str.length())));
    }

    public static final AnnotatedString buildAnnotatedString(Function1<? super AnnotatedString.Builder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "builder");
        AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, (DefaultConstructorMarker) null);
        function1.invoke(builder);
        return builder.toAnnotatedString();
    }

    public static final boolean intersect(int i, int i2, int i3, int i4) {
        return Math.max(i, i3) < Math.min(i2, i4) || contains(i, i2, i3, i4) || contains(i3, i4, i, i2);
    }

    public static final AnnotatedString emptyAnnotatedString() {
        return EmptyAnnotatedString;
    }

    /* access modifiers changed from: private */
    public static final <T> List<AnnotatedString.Range<T>> filterRanges(List<? extends AnnotatedString.Range<? extends T>> list, int i, int i2) {
        int i3 = 0;
        if (i <= i2) {
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            int i4 = 0;
            while (i4 < size) {
                int i5 = i4 + 1;
                Object obj = list.get(i4);
                AnnotatedString.Range range = (AnnotatedString.Range) obj;
                if (intersect(i, i2, range.getStart(), range.getEnd())) {
                    arrayList.add(obj);
                }
                i4 = i5;
            }
            List list2 = arrayList;
            ArrayList arrayList2 = new ArrayList(list2.size());
            int size2 = list2.size();
            while (i3 < size2) {
                int i6 = i3 + 1;
                AnnotatedString.Range range2 = (AnnotatedString.Range) list2.get(i3);
                arrayList2.add(new AnnotatedString.Range(range2.getItem(), Math.max(i, range2.getStart()) - i, Math.min(i2, range2.getEnd()) - i, range2.getTag()));
                i3 = i6;
            }
            return arrayList2;
        }
        throw new IllegalArgumentException(("start (" + i + ") should be less than or equal to end (" + i2 + ')').toString());
    }
}
