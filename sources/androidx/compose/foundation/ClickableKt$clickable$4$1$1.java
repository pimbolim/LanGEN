package androidx.compose.foundation;

import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Clickable.kt */
public final class ClickableKt$clickable$4$1$1 implements ModifierLocalConsumer {
    final /* synthetic */ MutableState<Boolean> $isClickableInScrollableContainer;

    ClickableKt$clickable$4$1$1(MutableState<Boolean> mutableState) {
        this.$isClickableInScrollableContainer = mutableState;
    }

    public boolean all(Function1<? super Modifier.Element, Boolean> function1) {
        return ModifierLocalConsumer.DefaultImpls.all(this, function1);
    }

    public boolean any(Function1<? super Modifier.Element, Boolean> function1) {
        return ModifierLocalConsumer.DefaultImpls.any(this, function1);
    }

    public <R> R foldIn(R r, Function2<? super R, ? super Modifier.Element, ? extends R> function2) {
        return ModifierLocalConsumer.DefaultImpls.foldIn(this, r, function2);
    }

    public <R> R foldOut(R r, Function2<? super Modifier.Element, ? super R, ? extends R> function2) {
        return ModifierLocalConsumer.DefaultImpls.foldOut(this, r, function2);
    }

    public Modifier then(Modifier modifier) {
        return ModifierLocalConsumer.DefaultImpls.then(this, modifier);
    }

    public void onModifierLocalsUpdated(ModifierLocalReadScope modifierLocalReadScope) {
        Intrinsics.checkNotNullParameter(modifierLocalReadScope, "scope");
        this.$isClickableInScrollableContainer.setValue(modifierLocalReadScope.getCurrent(ScrollableKt.getModifierLocalScrollableContainer()));
    }
}
