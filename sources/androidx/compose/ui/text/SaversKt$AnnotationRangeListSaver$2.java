package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.text.AnnotatedString;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "", "it", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Savers.kt */
final class SaversKt$AnnotationRangeListSaver$2 extends Lambda implements Function1<Object, List<? extends AnnotatedString.Range<? extends Object>>> {
    public static final SaversKt$AnnotationRangeListSaver$2 INSTANCE = new SaversKt$AnnotationRangeListSaver$2();

    SaversKt$AnnotationRangeListSaver$2() {
        super(1);
    }

    public final List<AnnotatedString.Range<? extends Object>> invoke(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "it");
        List list = (List) obj;
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            Object obj2 = list.get(i);
            Collection collection = arrayList;
            Saver access$getAnnotationRangeSaver$p = SaversKt.AnnotationRangeSaver;
            AnnotatedString.Range range = null;
            if (!Intrinsics.areEqual(obj2, (Object) false) && obj2 != null) {
                range = (AnnotatedString.Range) access$getAnnotationRangeSaver$p.restore(obj2);
            }
            Intrinsics.checkNotNull(range);
            collection.add(range);
            i = i2;
        }
        return arrayList;
    }
}
