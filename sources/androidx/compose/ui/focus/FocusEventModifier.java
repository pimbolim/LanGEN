package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Landroidx/compose/ui/focus/FocusEventModifier;", "Landroidx/compose/ui/Modifier$Element;", "onFocusEvent", "", "focusState", "Landroidx/compose/ui/focus/FocusState;", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FocusEventModifier.kt */
public interface FocusEventModifier extends Modifier.Element {
    void onFocusEvent(FocusState focusState);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FocusEventModifier.kt */
    public static final class DefaultImpls {
        public static boolean all(FocusEventModifier focusEventModifier, Function1<? super Modifier.Element, Boolean> function1) {
            Intrinsics.checkNotNullParameter(focusEventModifier, "this");
            Intrinsics.checkNotNullParameter(function1, "predicate");
            return Modifier.Element.DefaultImpls.all(focusEventModifier, function1);
        }

        public static boolean any(FocusEventModifier focusEventModifier, Function1<? super Modifier.Element, Boolean> function1) {
            Intrinsics.checkNotNullParameter(focusEventModifier, "this");
            Intrinsics.checkNotNullParameter(function1, "predicate");
            return Modifier.Element.DefaultImpls.any(focusEventModifier, function1);
        }

        public static <R> R foldIn(FocusEventModifier focusEventModifier, R r, Function2<? super R, ? super Modifier.Element, ? extends R> function2) {
            Intrinsics.checkNotNullParameter(focusEventModifier, "this");
            Intrinsics.checkNotNullParameter(function2, "operation");
            return Modifier.Element.DefaultImpls.foldIn(focusEventModifier, r, function2);
        }

        public static <R> R foldOut(FocusEventModifier focusEventModifier, R r, Function2<? super Modifier.Element, ? super R, ? extends R> function2) {
            Intrinsics.checkNotNullParameter(focusEventModifier, "this");
            Intrinsics.checkNotNullParameter(function2, "operation");
            return Modifier.Element.DefaultImpls.foldOut(focusEventModifier, r, function2);
        }

        public static Modifier then(FocusEventModifier focusEventModifier, Modifier modifier) {
            Intrinsics.checkNotNullParameter(focusEventModifier, "this");
            Intrinsics.checkNotNullParameter(modifier, "other");
            return Modifier.Element.DefaultImpls.then(focusEventModifier, modifier);
        }
    }
}
