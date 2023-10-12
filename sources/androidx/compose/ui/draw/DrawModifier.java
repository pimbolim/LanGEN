package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H&¨\u0006\u0005"}, d2 = {"Landroidx/compose/ui/draw/DrawModifier;", "Landroidx/compose/ui/Modifier$Element;", "draw", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DrawModifier.kt */
public interface DrawModifier extends Modifier.Element {
    void draw(ContentDrawScope contentDrawScope);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DrawModifier.kt */
    public static final class DefaultImpls {
        public static boolean all(DrawModifier drawModifier, Function1<? super Modifier.Element, Boolean> function1) {
            Intrinsics.checkNotNullParameter(drawModifier, "this");
            Intrinsics.checkNotNullParameter(function1, "predicate");
            return Modifier.Element.DefaultImpls.all(drawModifier, function1);
        }

        public static boolean any(DrawModifier drawModifier, Function1<? super Modifier.Element, Boolean> function1) {
            Intrinsics.checkNotNullParameter(drawModifier, "this");
            Intrinsics.checkNotNullParameter(function1, "predicate");
            return Modifier.Element.DefaultImpls.any(drawModifier, function1);
        }

        public static <R> R foldIn(DrawModifier drawModifier, R r, Function2<? super R, ? super Modifier.Element, ? extends R> function2) {
            Intrinsics.checkNotNullParameter(drawModifier, "this");
            Intrinsics.checkNotNullParameter(function2, "operation");
            return Modifier.Element.DefaultImpls.foldIn(drawModifier, r, function2);
        }

        public static <R> R foldOut(DrawModifier drawModifier, R r, Function2<? super Modifier.Element, ? super R, ? extends R> function2) {
            Intrinsics.checkNotNullParameter(drawModifier, "this");
            Intrinsics.checkNotNullParameter(function2, "operation");
            return Modifier.Element.DefaultImpls.foldOut(drawModifier, r, function2);
        }

        public static Modifier then(DrawModifier drawModifier, Modifier modifier) {
            Intrinsics.checkNotNullParameter(drawModifier, "this");
            Intrinsics.checkNotNullParameter(modifier, "other");
            return Modifier.Element.DefaultImpls.then(drawModifier, modifier);
        }
    }
}
