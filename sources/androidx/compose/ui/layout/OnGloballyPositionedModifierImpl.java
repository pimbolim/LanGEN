package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.OnGloballyPositionedModifier;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B2\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\t¢\u0006\u0002\u0010\nJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0005H\u0016R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/layout/OnGloballyPositionedModifierImpl;", "Landroidx/compose/ui/layout/OnGloballyPositionedModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "callback", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "", "inspectorInfo", "Landroidx/compose/ui/platform/InspectorInfo;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getCallback", "()Lkotlin/jvm/functions/Function1;", "equals", "", "other", "", "hashCode", "", "onGloballyPositioned", "coordinates", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OnGloballyPositionedModifier.kt */
final class OnGloballyPositionedModifierImpl extends InspectorValueInfo implements OnGloballyPositionedModifier {
    private final Function1<LayoutCoordinates, Unit> callback;

    public boolean all(Function1<? super Modifier.Element, Boolean> function1) {
        return OnGloballyPositionedModifier.DefaultImpls.all(this, function1);
    }

    public boolean any(Function1<? super Modifier.Element, Boolean> function1) {
        return OnGloballyPositionedModifier.DefaultImpls.any(this, function1);
    }

    public <R> R foldIn(R r, Function2<? super R, ? super Modifier.Element, ? extends R> function2) {
        return OnGloballyPositionedModifier.DefaultImpls.foldIn(this, r, function2);
    }

    public <R> R foldOut(R r, Function2<? super Modifier.Element, ? super R, ? extends R> function2) {
        return OnGloballyPositionedModifier.DefaultImpls.foldOut(this, r, function2);
    }

    public Modifier then(Modifier modifier) {
        return OnGloballyPositionedModifier.DefaultImpls.then(this, modifier);
    }

    public final Function1<LayoutCoordinates, Unit> getCallback() {
        return this.callback;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OnGloballyPositionedModifierImpl(Function1<? super LayoutCoordinates, Unit> function1, Function1<? super InspectorInfo, Unit> function12) {
        super(function12);
        Intrinsics.checkNotNullParameter(function1, "callback");
        Intrinsics.checkNotNullParameter(function12, "inspectorInfo");
        this.callback = function1;
    }

    public void onGloballyPositioned(LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "coordinates");
        this.callback.invoke(layoutCoordinates);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OnGloballyPositionedModifierImpl)) {
            return false;
        }
        return Intrinsics.areEqual((Object) this.callback, (Object) ((OnGloballyPositionedModifierImpl) obj).callback);
    }

    public int hashCode() {
        return this.callback.hashCode();
    }
}
