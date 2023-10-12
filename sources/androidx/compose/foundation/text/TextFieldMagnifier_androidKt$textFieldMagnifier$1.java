package androidx.compose.foundation.text;

import androidx.compose.foundation.MagnifierKt;
import androidx.compose.foundation.MagnifierStyle;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "center", "Lkotlin/Function0;", "Landroidx/compose/ui/geometry/Offset;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextFieldMagnifier.android.kt */
final class TextFieldMagnifier_androidKt$textFieldMagnifier$1 extends Lambda implements Function1<Function0<? extends Offset>, Modifier> {
    public static final TextFieldMagnifier_androidKt$textFieldMagnifier$1 INSTANCE = new TextFieldMagnifier_androidKt$textFieldMagnifier$1();

    TextFieldMagnifier_androidKt$textFieldMagnifier$1() {
        super(1);
    }

    public final Modifier invoke(final Function0<Offset> function0) {
        Intrinsics.checkNotNullParameter(function0, "center");
        return MagnifierKt.magnifier$default(Modifier.Companion, new Function1<Density, Offset>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return Offset.m1342boximpl(m716invoketuRUvjQ((Density) obj));
            }

            /* renamed from: invoke-tuRUvjQ  reason: not valid java name */
            public final long m716invoketuRUvjQ(Density density) {
                Intrinsics.checkNotNullParameter(density, "$this$magnifier");
                return function0.invoke().m1363unboximpl();
            }
        }, (Function1) null, 0.0f, MagnifierStyle.Companion.getTextDefault(), 6, (Object) null);
    }
}
