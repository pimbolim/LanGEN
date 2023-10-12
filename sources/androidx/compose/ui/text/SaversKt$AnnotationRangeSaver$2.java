package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.text.AnnotatedString;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0002\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/text/AnnotatedString$Range;", "", "it", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Savers.kt */
final class SaversKt$AnnotationRangeSaver$2 extends Lambda implements Function1<Object, AnnotatedString.Range<? extends Object>> {
    public static final SaversKt$AnnotationRangeSaver$2 INSTANCE = new SaversKt$AnnotationRangeSaver$2();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Savers.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AnnotationType.values().length];
            iArr[AnnotationType.Paragraph.ordinal()] = 1;
            iArr[AnnotationType.Span.ordinal()] = 2;
            iArr[AnnotationType.VerbatimTts.ordinal()] = 3;
            iArr[AnnotationType.String.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    SaversKt$AnnotationRangeSaver$2() {
        super(1);
    }

    public final AnnotatedString.Range<? extends Object> invoke(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "it");
        List list = (List) obj;
        Object obj2 = list.get(0);
        Object obj3 = null;
        AnnotationType annotationType = obj2 == null ? null : (AnnotationType) obj2;
        Intrinsics.checkNotNull(annotationType);
        Object obj4 = list.get(2);
        Integer num = obj4 == null ? null : (Integer) obj4;
        Intrinsics.checkNotNull(num);
        int intValue = num.intValue();
        Object obj5 = list.get(3);
        Integer num2 = obj5 == null ? null : (Integer) obj5;
        Intrinsics.checkNotNull(num2);
        int intValue2 = num2.intValue();
        Object obj6 = list.get(4);
        String str = obj6 == null ? null : (String) obj6;
        Intrinsics.checkNotNull(str);
        int i = WhenMappings.$EnumSwitchMapping$0[annotationType.ordinal()];
        if (i == 1) {
            Object obj7 = list.get(1);
            Saver<ParagraphStyle, Object> paragraphStyleSaver = SaversKt.getParagraphStyleSaver();
            if (!Intrinsics.areEqual(obj7, (Object) false) && obj7 != null) {
                obj3 = (ParagraphStyle) paragraphStyleSaver.restore(obj7);
            }
            Intrinsics.checkNotNull(obj3);
            return new AnnotatedString.Range<>(obj3, intValue, intValue2, str);
        } else if (i == 2) {
            Object obj8 = list.get(1);
            Saver<SpanStyle, Object> spanStyleSaver = SaversKt.getSpanStyleSaver();
            if (!Intrinsics.areEqual(obj8, (Object) false) && obj8 != null) {
                obj3 = (SpanStyle) spanStyleSaver.restore(obj8);
            }
            Intrinsics.checkNotNull(obj3);
            return new AnnotatedString.Range<>(obj3, intValue, intValue2, str);
        } else if (i == 3) {
            Object obj9 = list.get(1);
            Saver access$getVerbatimTtsAnnotationSaver$p = SaversKt.VerbatimTtsAnnotationSaver;
            if (!Intrinsics.areEqual(obj9, (Object) false) && obj9 != null) {
                obj3 = (VerbatimTtsAnnotation) access$getVerbatimTtsAnnotationSaver$p.restore(obj9);
            }
            Intrinsics.checkNotNull(obj3);
            return new AnnotatedString.Range<>(obj3, intValue, intValue2, str);
        } else if (i == 4) {
            Object obj10 = list.get(1);
            if (obj10 != null) {
                obj3 = (String) obj10;
            }
            Intrinsics.checkNotNull(obj3);
            return new AnnotatedString.Range<>(obj3, intValue, intValue2, str);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
