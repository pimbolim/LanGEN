package androidx.compose.ui.platform;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\rB\u001e\u0012\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007¢\u0006\u0002\u0010\bR\u0015\u0010\t\u001a\u00060\nR\u00020\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/platform/InspectableModifier;", "Landroidx/compose/ui/Modifier$Element;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)V", "end", "Landroidx/compose/ui/platform/InspectableModifier$End;", "getEnd", "()Landroidx/compose/ui/platform/InspectableModifier$End;", "End", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: InspectableValue.kt */
public final class InspectableModifier extends InspectorValueInfo implements Modifier.Element {
    public static final int $stable = 0;
    private final End end = new End(this);

    public boolean all(Function1<? super Modifier.Element, Boolean> function1) {
        return Modifier.Element.DefaultImpls.all(this, function1);
    }

    public boolean any(Function1<? super Modifier.Element, Boolean> function1) {
        return Modifier.Element.DefaultImpls.any(this, function1);
    }

    public <R> R foldIn(R r, Function2<? super R, ? super Modifier.Element, ? extends R> function2) {
        return Modifier.Element.DefaultImpls.foldIn(this, r, function2);
    }

    public <R> R foldOut(R r, Function2<? super Modifier.Element, ? super R, ? extends R> function2) {
        return Modifier.Element.DefaultImpls.foldOut(this, r, function2);
    }

    public Modifier then(Modifier modifier) {
        return Modifier.Element.DefaultImpls.then(this, modifier);
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Landroidx/compose/ui/platform/InspectableModifier$End;", "Landroidx/compose/ui/Modifier$Element;", "(Landroidx/compose/ui/platform/InspectableModifier;)V", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: InspectableValue.kt */
    public final class End implements Modifier.Element {
        final /* synthetic */ InspectableModifier this$0;

        public End(InspectableModifier inspectableModifier) {
            Intrinsics.checkNotNullParameter(inspectableModifier, "this$0");
            this.this$0 = inspectableModifier;
        }

        public boolean all(Function1<? super Modifier.Element, Boolean> function1) {
            return Modifier.Element.DefaultImpls.all(this, function1);
        }

        public boolean any(Function1<? super Modifier.Element, Boolean> function1) {
            return Modifier.Element.DefaultImpls.any(this, function1);
        }

        public <R> R foldIn(R r, Function2<? super R, ? super Modifier.Element, ? extends R> function2) {
            return Modifier.Element.DefaultImpls.foldIn(this, r, function2);
        }

        public <R> R foldOut(R r, Function2<? super Modifier.Element, ? super R, ? extends R> function2) {
            return Modifier.Element.DefaultImpls.foldOut(this, r, function2);
        }

        public Modifier then(Modifier modifier) {
            return Modifier.Element.DefaultImpls.then(this, modifier);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InspectableModifier(Function1<? super InspectorInfo, Unit> function1) {
        super(function1);
        Intrinsics.checkNotNullParameter(function1, "inspectorInfo");
    }

    public final End getEnd() {
        return this.end;
    }
}
