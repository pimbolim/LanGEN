package androidx.compose.ui.modifier;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002R\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/compose/ui/modifier/ModifierLocalProvider;", "T", "Landroidx/compose/ui/Modifier$Element;", "key", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "getKey", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "value", "getValue", "()Ljava/lang/Object;", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ModifierLocalProvider.kt */
public interface ModifierLocalProvider<T> extends Modifier.Element {
    ProvidableModifierLocal<T> getKey();

    T getValue();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ModifierLocalProvider.kt */
    public static final class DefaultImpls {
        public static <T> boolean all(ModifierLocalProvider<T> modifierLocalProvider, Function1<? super Modifier.Element, Boolean> function1) {
            Intrinsics.checkNotNullParameter(modifierLocalProvider, "this");
            Intrinsics.checkNotNullParameter(function1, "predicate");
            return Modifier.Element.DefaultImpls.all(modifierLocalProvider, function1);
        }

        public static <T> boolean any(ModifierLocalProvider<T> modifierLocalProvider, Function1<? super Modifier.Element, Boolean> function1) {
            Intrinsics.checkNotNullParameter(modifierLocalProvider, "this");
            Intrinsics.checkNotNullParameter(function1, "predicate");
            return Modifier.Element.DefaultImpls.any(modifierLocalProvider, function1);
        }

        public static <T, R> R foldIn(ModifierLocalProvider<T> modifierLocalProvider, R r, Function2<? super R, ? super Modifier.Element, ? extends R> function2) {
            Intrinsics.checkNotNullParameter(modifierLocalProvider, "this");
            Intrinsics.checkNotNullParameter(function2, "operation");
            return Modifier.Element.DefaultImpls.foldIn(modifierLocalProvider, r, function2);
        }

        public static <T, R> R foldOut(ModifierLocalProvider<T> modifierLocalProvider, R r, Function2<? super Modifier.Element, ? super R, ? extends R> function2) {
            Intrinsics.checkNotNullParameter(modifierLocalProvider, "this");
            Intrinsics.checkNotNullParameter(function2, "operation");
            return Modifier.Element.DefaultImpls.foldOut(modifierLocalProvider, r, function2);
        }

        public static <T> Modifier then(ModifierLocalProvider<T> modifierLocalProvider, Modifier modifier) {
            Intrinsics.checkNotNullParameter(modifierLocalProvider, "this");
            Intrinsics.checkNotNullParameter(modifier, "other");
            return Modifier.Element.DefaultImpls.then(modifierLocalProvider, modifier);
        }
    }
}
