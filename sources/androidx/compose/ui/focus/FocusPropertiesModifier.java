package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004B7\u0012\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\b\u0012\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\b¢\u0006\u0002\u0010\u000bJ\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001eH\u0016R\"\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001f"}, d2 = {"Landroidx/compose/ui/focus/FocusPropertiesModifier;", "Landroidx/compose/ui/modifier/ModifierLocalConsumer;", "Landroidx/compose/ui/modifier/ModifierLocalProvider;", "Landroidx/compose/ui/focus/FocusProperties;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "focusPropertiesScope", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "inspectorInfo", "Landroidx/compose/ui/platform/InspectorInfo;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getFocusPropertiesScope", "()Lkotlin/jvm/functions/Function1;", "key", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "getKey", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "parentFocusProperties", "value", "getValue", "()Landroidx/compose/ui/focus/FocusProperties;", "equals", "", "other", "", "hashCode", "", "onModifierLocalsUpdated", "scope", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FocusProperties.kt */
public final class FocusPropertiesModifier extends InspectorValueInfo implements ModifierLocalConsumer, ModifierLocalProvider<FocusProperties> {
    private final Function1<FocusProperties, Unit> focusPropertiesScope;
    private final ProvidableModifierLocal<FocusProperties> key = FocusPropertiesKt.getModifierLocalFocusProperties();
    private FocusProperties parentFocusProperties;

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

    public final Function1<FocusProperties, Unit> getFocusPropertiesScope() {
        return this.focusPropertiesScope;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FocusPropertiesModifier(Function1<? super FocusProperties, Unit> function1, Function1<? super InspectorInfo, Unit> function12) {
        super(function12);
        Intrinsics.checkNotNullParameter(function1, "focusPropertiesScope");
        Intrinsics.checkNotNullParameter(function12, "inspectorInfo");
        this.focusPropertiesScope = function1;
    }

    public void onModifierLocalsUpdated(ModifierLocalReadScope modifierLocalReadScope) {
        Intrinsics.checkNotNullParameter(modifierLocalReadScope, "scope");
        this.parentFocusProperties = (FocusProperties) modifierLocalReadScope.getCurrent(FocusPropertiesKt.getModifierLocalFocusProperties());
    }

    public ProvidableModifierLocal<FocusProperties> getKey() {
        return this.key;
    }

    public FocusProperties getValue() {
        FocusPropertiesModifier$value$properties$1 focusPropertiesModifier$value$properties$1 = new FocusPropertiesModifier$value$properties$1();
        this.focusPropertiesScope.invoke(focusPropertiesModifier$value$properties$1);
        FocusProperties focusProperties = this.parentFocusProperties;
        if (focusProperties != null && !Intrinsics.areEqual((Object) focusProperties, (Object) DefaultFocusProperties.INSTANCE)) {
            focusPropertiesModifier$value$properties$1.setCanFocus(focusProperties.getCanFocus());
        }
        return focusPropertiesModifier$value$properties$1;
    }

    public boolean equals(Object obj) {
        return (obj instanceof FocusPropertiesModifier) && Intrinsics.areEqual((Object) this.focusPropertiesScope, (Object) ((FocusPropertiesModifier) obj).focusPropertiesScope);
    }

    public int hashCode() {
        return this.focusPropertiesScope.hashCode();
    }
}
