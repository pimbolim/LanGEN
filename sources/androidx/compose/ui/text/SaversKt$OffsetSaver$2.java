package androidx.compose.ui.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/geometry/Offset;", "it", "", "invoke-x-9fifI"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Savers.kt */
final class SaversKt$OffsetSaver$2 extends Lambda implements Function1<Object, Offset> {
    public static final SaversKt$OffsetSaver$2 INSTANCE = new SaversKt$OffsetSaver$2();

    SaversKt$OffsetSaver$2() {
        super(1);
    }

    /* renamed from: invoke-x-9fifI  reason: not valid java name */
    public final Offset invoke(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "it");
        if (Intrinsics.areEqual(obj, (Object) false)) {
            return Offset.m1342boximpl(Offset.Companion.m1368getUnspecifiedF1C5BW0());
        }
        List list = (List) obj;
        Object obj2 = list.get(0);
        Float f = null;
        Float f2 = obj2 == null ? null : (Float) obj2;
        Intrinsics.checkNotNull(f2);
        float floatValue = f2.floatValue();
        Object obj3 = list.get(1);
        if (obj3 != null) {
            f = (Float) obj3;
        }
        Intrinsics.checkNotNull(f);
        return Offset.m1342boximpl(OffsetKt.Offset(floatValue, f.floatValue()));
    }
}
