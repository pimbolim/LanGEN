package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.TextUnit;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/text/ParagraphStyle;", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Savers.kt */
final class SaversKt$ParagraphStyleSaver$2 extends Lambda implements Function1<Object, ParagraphStyle> {
    public static final SaversKt$ParagraphStyleSaver$2 INSTANCE = new SaversKt$ParagraphStyleSaver$2();

    SaversKt$ParagraphStyleSaver$2() {
        super(1);
    }

    public final ParagraphStyle invoke(Object obj) {
        TextUnit textUnit;
        Intrinsics.checkNotNullParameter(obj, "it");
        List list = (List) obj;
        Object obj2 = list.get(0);
        TextIndent textIndent = null;
        TextAlign textAlign = obj2 == null ? null : (TextAlign) obj2;
        Object obj3 = list.get(1);
        TextDirection textDirection = obj3 == null ? null : (TextDirection) obj3;
        Object obj4 = list.get(2);
        Saver<TextUnit, Object> saver = SaversKt.getSaver(TextUnit.Companion);
        if (!Intrinsics.areEqual(obj4, (Object) false) && obj4 != null) {
            textUnit = saver.restore(obj4);
        } else {
            textUnit = null;
        }
        Intrinsics.checkNotNull(textUnit);
        long r5 = textUnit.m4049unboximpl();
        Object obj5 = list.get(3);
        Saver<TextIndent, Object> saver2 = SaversKt.getSaver(TextIndent.Companion);
        if (!Intrinsics.areEqual(obj5, (Object) false) && obj5 != null) {
            textIndent = saver2.restore(obj5);
        }
        return new ParagraphStyle(textAlign, textDirection, r5, textIndent, (DefaultConstructorMarker) null);
    }
}
