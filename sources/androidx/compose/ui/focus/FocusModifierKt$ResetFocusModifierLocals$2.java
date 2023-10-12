package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"androidx/compose/ui/focus/FocusModifierKt$ResetFocusModifierLocals$2", "Landroidx/compose/ui/modifier/ModifierLocalProvider;", "", "key", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "getKey", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "value", "getValue", "()Ljava/lang/Boolean;", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FocusModifier.kt */
public final class FocusModifierKt$ResetFocusModifierLocals$2 implements ModifierLocalProvider<Boolean> {
    FocusModifierKt$ResetFocusModifierLocals$2() {
    }

    public boolean all(Function1<? super Modifier.Element, Boolean> function1) {
        return ModifierLocalProvider.DefaultImpls.all(this, function1);
    }

    public boolean any(Function1<? super Modifier.Element, Boolean> function1) {
        return ModifierLocalProvider.DefaultImpls.any(this, function1);
    }

    public <R> R foldIn(R r, Function2<? super R, ? super Modifier.Element, ? extends R> function2) {
        return ModifierLocalProvider.DefaultImpls.foldIn(this, r, function2);
    }

    public <R> R foldOut(R r, Function2<? super Modifier.Element, ? super R, ? extends R> function2) {
        return ModifierLocalProvider.DefaultImpls.foldOut(this, r, function2);
    }

    public Modifier then(Modifier modifier) {
        return ModifierLocalProvider.DefaultImpls.then(this, modifier);
    }

    public ProvidableModifierLocal<Boolean> getKey() {
        return FocusModifierKt.getModifierLocalHasFocusEventListener();
    }

    public Boolean getValue() {
        return false;
    }
}
