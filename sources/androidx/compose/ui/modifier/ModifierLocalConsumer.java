package androidx.compose.ui.modifier;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Landroidx/compose/ui/modifier/ModifierLocalConsumer;", "Landroidx/compose/ui/Modifier$Element;", "onModifierLocalsUpdated", "", "scope", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ModifierLocalConsumer.kt */
public interface ModifierLocalConsumer extends Modifier.Element {
    void onModifierLocalsUpdated(ModifierLocalReadScope modifierLocalReadScope);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ModifierLocalConsumer.kt */
    public static final class DefaultImpls {
        public static boolean all(ModifierLocalConsumer modifierLocalConsumer, Function1<? super Modifier.Element, Boolean> function1) {
            Intrinsics.checkNotNullParameter(modifierLocalConsumer, "this");
            Intrinsics.checkNotNullParameter(function1, "predicate");
            return Modifier.Element.DefaultImpls.all(modifierLocalConsumer, function1);
        }

        public static boolean any(ModifierLocalConsumer modifierLocalConsumer, Function1<? super Modifier.Element, Boolean> function1) {
            Intrinsics.checkNotNullParameter(modifierLocalConsumer, "this");
            Intrinsics.checkNotNullParameter(function1, "predicate");
            return Modifier.Element.DefaultImpls.any(modifierLocalConsumer, function1);
        }

        public static <R> R foldIn(ModifierLocalConsumer modifierLocalConsumer, R r, Function2<? super R, ? super Modifier.Element, ? extends R> function2) {
            Intrinsics.checkNotNullParameter(modifierLocalConsumer, "this");
            Intrinsics.checkNotNullParameter(function2, "operation");
            return Modifier.Element.DefaultImpls.foldIn(modifierLocalConsumer, r, function2);
        }

        public static <R> R foldOut(ModifierLocalConsumer modifierLocalConsumer, R r, Function2<? super Modifier.Element, ? super R, ? extends R> function2) {
            Intrinsics.checkNotNullParameter(modifierLocalConsumer, "this");
            Intrinsics.checkNotNullParameter(function2, "operation");
            return Modifier.Element.DefaultImpls.foldOut(modifierLocalConsumer, r, function2);
        }

        public static Modifier then(ModifierLocalConsumer modifierLocalConsumer, Modifier modifier) {
            Intrinsics.checkNotNullParameter(modifierLocalConsumer, "this");
            Intrinsics.checkNotNullParameter(modifier, "other");
            return Modifier.Element.DefaultImpls.then(modifierLocalConsumer, modifier);
        }
    }
}
