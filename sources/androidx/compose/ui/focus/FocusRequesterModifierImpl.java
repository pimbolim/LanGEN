package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequesterModifier;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B&\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\t¢\u0006\u0002\u0010\nR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroidx/compose/ui/focus/FocusRequesterModifierImpl;", "Landroidx/compose/ui/focus/FocusRequesterModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/focus/FocusRequester;Lkotlin/jvm/functions/Function1;)V", "getFocusRequester", "()Landroidx/compose/ui/focus/FocusRequester;", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FocusRequesterModifier.kt */
public final class FocusRequesterModifierImpl extends InspectorValueInfo implements FocusRequesterModifier {
    private final FocusRequester focusRequester;

    public boolean all(Function1<? super Modifier.Element, Boolean> function1) {
        return FocusRequesterModifier.DefaultImpls.all(this, function1);
    }

    public boolean any(Function1<? super Modifier.Element, Boolean> function1) {
        return FocusRequesterModifier.DefaultImpls.any(this, function1);
    }

    public <R> R foldIn(R r, Function2<? super R, ? super Modifier.Element, ? extends R> function2) {
        return FocusRequesterModifier.DefaultImpls.foldIn(this, r, function2);
    }

    public <R> R foldOut(R r, Function2<? super Modifier.Element, ? super R, ? extends R> function2) {
        return FocusRequesterModifier.DefaultImpls.foldOut(this, r, function2);
    }

    public Modifier then(Modifier modifier) {
        return FocusRequesterModifier.DefaultImpls.then(this, modifier);
    }

    public FocusRequester getFocusRequester() {
        return this.focusRequester;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FocusRequesterModifierImpl(FocusRequester focusRequester2, Function1<? super InspectorInfo, Unit> function1) {
        super(function1);
        Intrinsics.checkNotNullParameter(focusRequester2, "focusRequester");
        Intrinsics.checkNotNullParameter(function1, "inspectorInfo");
        this.focusRequester = focusRequester2;
    }
}
