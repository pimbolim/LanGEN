package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/text/AnnotatedString;", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Savers.kt */
final class SaversKt$AnnotatedStringSaver$2 extends Lambda implements Function1<Object, AnnotatedString> {
    public static final SaversKt$AnnotatedStringSaver$2 INSTANCE = new SaversKt$AnnotatedStringSaver$2();

    SaversKt$AnnotatedStringSaver$2() {
        super(1);
    }

    public final AnnotatedString invoke(Object obj) {
        List list;
        List list2;
        Intrinsics.checkNotNullParameter(obj, "it");
        List list3 = (List) obj;
        Object obj2 = list3.get(0);
        List list4 = null;
        String str = obj2 == null ? null : (String) obj2;
        Intrinsics.checkNotNull(str);
        Object obj3 = list3.get(1);
        Saver access$getAnnotationRangeListSaver$p = SaversKt.AnnotationRangeListSaver;
        if (!Intrinsics.areEqual(obj3, (Object) false) && obj3 != null) {
            list = (List) access$getAnnotationRangeListSaver$p.restore(obj3);
        } else {
            list = null;
        }
        Intrinsics.checkNotNull(list);
        Object obj4 = list3.get(2);
        Saver access$getAnnotationRangeListSaver$p2 = SaversKt.AnnotationRangeListSaver;
        if (!Intrinsics.areEqual(obj4, (Object) false) && obj4 != null) {
            list2 = (List) access$getAnnotationRangeListSaver$p2.restore(obj4);
        } else {
            list2 = null;
        }
        Intrinsics.checkNotNull(list2);
        Object obj5 = list3.get(3);
        Saver access$getAnnotationRangeListSaver$p3 = SaversKt.AnnotationRangeListSaver;
        if (!Intrinsics.areEqual(obj5, (Object) false) && obj5 != null) {
            list4 = (List) access$getAnnotationRangeListSaver$p3.restore(obj5);
        }
        Intrinsics.checkNotNull(list4);
        return new AnnotatedString(str, list, list2, list4);
    }
}
