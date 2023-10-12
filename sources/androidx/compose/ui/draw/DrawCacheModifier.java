package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Landroidx/compose/ui/draw/DrawCacheModifier;", "Landroidx/compose/ui/draw/DrawModifier;", "onBuildCache", "", "params", "Landroidx/compose/ui/draw/BuildDrawCacheParams;", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DrawModifier.kt */
public interface DrawCacheModifier extends DrawModifier {
    void onBuildCache(BuildDrawCacheParams buildDrawCacheParams);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DrawModifier.kt */
    public static final class DefaultImpls {
        public static boolean all(DrawCacheModifier drawCacheModifier, Function1<? super Modifier.Element, Boolean> function1) {
            Intrinsics.checkNotNullParameter(drawCacheModifier, "this");
            Intrinsics.checkNotNullParameter(function1, "predicate");
            return DrawModifier.DefaultImpls.all(drawCacheModifier, function1);
        }

        public static boolean any(DrawCacheModifier drawCacheModifier, Function1<? super Modifier.Element, Boolean> function1) {
            Intrinsics.checkNotNullParameter(drawCacheModifier, "this");
            Intrinsics.checkNotNullParameter(function1, "predicate");
            return DrawModifier.DefaultImpls.any(drawCacheModifier, function1);
        }

        public static <R> R foldIn(DrawCacheModifier drawCacheModifier, R r, Function2<? super R, ? super Modifier.Element, ? extends R> function2) {
            Intrinsics.checkNotNullParameter(drawCacheModifier, "this");
            Intrinsics.checkNotNullParameter(function2, "operation");
            return DrawModifier.DefaultImpls.foldIn(drawCacheModifier, r, function2);
        }

        public static <R> R foldOut(DrawCacheModifier drawCacheModifier, R r, Function2<? super Modifier.Element, ? super R, ? extends R> function2) {
            Intrinsics.checkNotNullParameter(drawCacheModifier, "this");
            Intrinsics.checkNotNullParameter(function2, "operation");
            return DrawModifier.DefaultImpls.foldOut(drawCacheModifier, r, function2);
        }

        public static Modifier then(DrawCacheModifier drawCacheModifier, Modifier modifier) {
            Intrinsics.checkNotNullParameter(drawCacheModifier, "this");
            Intrinsics.checkNotNullParameter(modifier, "other");
            return DrawModifier.DefaultImpls.then(drawCacheModifier, modifier);
        }
    }
}
