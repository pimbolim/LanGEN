package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/ui/focus/FocusRequesterModifier;", "Landroidx/compose/ui/Modifier$Element;", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "getFocusRequester", "()Landroidx/compose/ui/focus/FocusRequester;", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FocusRequesterModifier.kt */
public interface FocusRequesterModifier extends Modifier.Element {
    FocusRequester getFocusRequester();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FocusRequesterModifier.kt */
    public static final class DefaultImpls {
        public static boolean all(FocusRequesterModifier focusRequesterModifier, Function1<? super Modifier.Element, Boolean> function1) {
            Intrinsics.checkNotNullParameter(focusRequesterModifier, "this");
            Intrinsics.checkNotNullParameter(function1, "predicate");
            return Modifier.Element.DefaultImpls.all(focusRequesterModifier, function1);
        }

        public static boolean any(FocusRequesterModifier focusRequesterModifier, Function1<? super Modifier.Element, Boolean> function1) {
            Intrinsics.checkNotNullParameter(focusRequesterModifier, "this");
            Intrinsics.checkNotNullParameter(function1, "predicate");
            return Modifier.Element.DefaultImpls.any(focusRequesterModifier, function1);
        }

        public static <R> R foldIn(FocusRequesterModifier focusRequesterModifier, R r, Function2<? super R, ? super Modifier.Element, ? extends R> function2) {
            Intrinsics.checkNotNullParameter(focusRequesterModifier, "this");
            Intrinsics.checkNotNullParameter(function2, "operation");
            return Modifier.Element.DefaultImpls.foldIn(focusRequesterModifier, r, function2);
        }

        public static <R> R foldOut(FocusRequesterModifier focusRequesterModifier, R r, Function2<? super Modifier.Element, ? super R, ? extends R> function2) {
            Intrinsics.checkNotNullParameter(focusRequesterModifier, "this");
            Intrinsics.checkNotNullParameter(function2, "operation");
            return Modifier.Element.DefaultImpls.foldOut(focusRequesterModifier, r, function2);
        }

        public static Modifier then(FocusRequesterModifier focusRequesterModifier, Modifier modifier) {
            Intrinsics.checkNotNullParameter(focusRequesterModifier, "this");
            Intrinsics.checkNotNullParameter(modifier, "other");
            return Modifier.Element.DefaultImpls.then(focusRequesterModifier, modifier);
        }
    }
}
