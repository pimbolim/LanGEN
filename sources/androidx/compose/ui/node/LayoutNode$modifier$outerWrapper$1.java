package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifier;
import androidx.compose.ui.focus.FocusEventModifier;
import androidx.compose.ui.focus.FocusModifier;
import androidx.compose.ui.focus.FocusOrderModifier;
import androidx.compose.ui.focus.FocusRequesterModifier;
import androidx.compose.ui.input.key.KeyInputModifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollDelegatingWrapper;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifier;
import androidx.compose.ui.input.pointer.PointerInputModifier;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.OnGloballyPositionedModifier;
import androidx.compose.ui.layout.OnPlacedModifier;
import androidx.compose.ui.layout.OnRemeasuredModifier;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.layout.RemeasurementModifier;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.semantics.SemanticsModifier;
import androidx.compose.ui.semantics.SemanticsWrapper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Landroidx/compose/ui/node/LayoutNodeWrapper;", "mod", "Landroidx/compose/ui/Modifier$Element;", "toWrap", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LayoutNode.kt */
final class LayoutNode$modifier$outerWrapper$1 extends Lambda implements Function2<Modifier.Element, LayoutNodeWrapper, LayoutNodeWrapper> {
    final /* synthetic */ LayoutNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LayoutNode$modifier$outerWrapper$1(LayoutNode layoutNode) {
        super(2);
        this.this$0 = layoutNode;
    }

    public final LayoutNodeWrapper invoke(Modifier.Element element, LayoutNodeWrapper layoutNodeWrapper) {
        LayoutNodeWrapper layoutNodeWrapper2;
        Intrinsics.checkNotNullParameter(element, "mod");
        Intrinsics.checkNotNullParameter(layoutNodeWrapper, "toWrap");
        if (element instanceof RemeasurementModifier) {
            ((RemeasurementModifier) element).onRemeasurementAvailable(this.this$0);
        }
        if (element instanceof DrawModifier) {
            DrawEntity drawEntity = new DrawEntity(layoutNodeWrapper, (DrawModifier) element);
            drawEntity.setNext(layoutNodeWrapper.getDrawEntityHead());
            layoutNodeWrapper.setDrawEntityHead(drawEntity);
            drawEntity.onInitialize();
        }
        DelegatingLayoutNodeWrapper access$reuseLayoutNodeWrapper = this.this$0.reuseLayoutNodeWrapper(element, layoutNodeWrapper);
        if (access$reuseLayoutNodeWrapper != null) {
            return access$reuseLayoutNodeWrapper;
        }
        if (element instanceof ModifierLocalProvider) {
            DelegatingLayoutNodeWrapper modifierLocalProviderNode = new ModifierLocalProviderNode(layoutNodeWrapper, (ModifierLocalProvider) element);
            modifierLocalProviderNode.onInitialize();
            if (layoutNodeWrapper != modifierLocalProviderNode.getWrapped$ui_release()) {
                ((DelegatingLayoutNodeWrapper) modifierLocalProviderNode.getWrapped$ui_release()).setChained(true);
            }
            layoutNodeWrapper2 = modifierLocalProviderNode;
        } else {
            layoutNodeWrapper2 = layoutNodeWrapper;
        }
        if (element instanceof ModifierLocalConsumer) {
            DelegatingLayoutNodeWrapper modifierLocalConsumerNode = new ModifierLocalConsumerNode(layoutNodeWrapper2, (ModifierLocalConsumer) element);
            modifierLocalConsumerNode.onInitialize();
            if (layoutNodeWrapper != modifierLocalConsumerNode.getWrapped$ui_release()) {
                ((DelegatingLayoutNodeWrapper) modifierLocalConsumerNode.getWrapped$ui_release()).setChained(true);
            }
            layoutNodeWrapper2 = modifierLocalConsumerNode;
        }
        if (element instanceof FocusModifier) {
            DelegatingLayoutNodeWrapper modifiedFocusNode = new ModifiedFocusNode(layoutNodeWrapper2, (FocusModifier) element);
            modifiedFocusNode.onInitialize();
            if (layoutNodeWrapper != modifiedFocusNode.getWrapped$ui_release()) {
                ((DelegatingLayoutNodeWrapper) modifiedFocusNode.getWrapped$ui_release()).setChained(true);
            }
            layoutNodeWrapper2 = modifiedFocusNode;
        }
        if (element instanceof FocusEventModifier) {
            DelegatingLayoutNodeWrapper modifiedFocusEventNode = new ModifiedFocusEventNode(layoutNodeWrapper2, (FocusEventModifier) element);
            modifiedFocusEventNode.onInitialize();
            if (layoutNodeWrapper != modifiedFocusEventNode.getWrapped$ui_release()) {
                ((DelegatingLayoutNodeWrapper) modifiedFocusEventNode.getWrapped$ui_release()).setChained(true);
            }
            layoutNodeWrapper2 = modifiedFocusEventNode;
        }
        if (element instanceof FocusRequesterModifier) {
            DelegatingLayoutNodeWrapper modifiedFocusRequesterNode = new ModifiedFocusRequesterNode(layoutNodeWrapper2, (FocusRequesterModifier) element);
            modifiedFocusRequesterNode.onInitialize();
            if (layoutNodeWrapper != modifiedFocusRequesterNode.getWrapped$ui_release()) {
                ((DelegatingLayoutNodeWrapper) modifiedFocusRequesterNode.getWrapped$ui_release()).setChained(true);
            }
            layoutNodeWrapper2 = modifiedFocusRequesterNode;
        }
        if (element instanceof FocusOrderModifier) {
            DelegatingLayoutNodeWrapper modifiedFocusOrderNode = new ModifiedFocusOrderNode(layoutNodeWrapper2, (FocusOrderModifier) element);
            modifiedFocusOrderNode.onInitialize();
            if (layoutNodeWrapper != modifiedFocusOrderNode.getWrapped$ui_release()) {
                ((DelegatingLayoutNodeWrapper) modifiedFocusOrderNode.getWrapped$ui_release()).setChained(true);
            }
            layoutNodeWrapper2 = modifiedFocusOrderNode;
        }
        if (element instanceof KeyInputModifier) {
            DelegatingLayoutNodeWrapper modifiedKeyInputNode = new ModifiedKeyInputNode(layoutNodeWrapper2, (KeyInputModifier) element);
            modifiedKeyInputNode.onInitialize();
            if (layoutNodeWrapper != modifiedKeyInputNode.getWrapped$ui_release()) {
                ((DelegatingLayoutNodeWrapper) modifiedKeyInputNode.getWrapped$ui_release()).setChained(true);
            }
            layoutNodeWrapper2 = modifiedKeyInputNode;
        }
        if (element instanceof PointerInputModifier) {
            DelegatingLayoutNodeWrapper pointerInputDelegatingWrapper = new PointerInputDelegatingWrapper(layoutNodeWrapper2, (PointerInputModifier) element);
            pointerInputDelegatingWrapper.onInitialize();
            if (layoutNodeWrapper != pointerInputDelegatingWrapper.getWrapped$ui_release()) {
                ((DelegatingLayoutNodeWrapper) pointerInputDelegatingWrapper.getWrapped$ui_release()).setChained(true);
            }
            layoutNodeWrapper2 = pointerInputDelegatingWrapper;
        }
        if (element instanceof NestedScrollModifier) {
            DelegatingLayoutNodeWrapper nestedScrollDelegatingWrapper = new NestedScrollDelegatingWrapper(layoutNodeWrapper2, (NestedScrollModifier) element);
            nestedScrollDelegatingWrapper.onInitialize();
            if (layoutNodeWrapper != nestedScrollDelegatingWrapper.getWrapped$ui_release()) {
                ((DelegatingLayoutNodeWrapper) nestedScrollDelegatingWrapper.getWrapped$ui_release()).setChained(true);
            }
            layoutNodeWrapper2 = nestedScrollDelegatingWrapper;
        }
        if (element instanceof LayoutModifier) {
            DelegatingLayoutNodeWrapper modifiedLayoutNode = new ModifiedLayoutNode(layoutNodeWrapper2, (LayoutModifier) element);
            modifiedLayoutNode.onInitialize();
            if (layoutNodeWrapper != modifiedLayoutNode.getWrapped$ui_release()) {
                ((DelegatingLayoutNodeWrapper) modifiedLayoutNode.getWrapped$ui_release()).setChained(true);
            }
            layoutNodeWrapper2 = modifiedLayoutNode;
        }
        if (element instanceof ParentDataModifier) {
            DelegatingLayoutNodeWrapper modifiedParentDataNode = new ModifiedParentDataNode(layoutNodeWrapper2, (ParentDataModifier) element);
            modifiedParentDataNode.onInitialize();
            if (layoutNodeWrapper != modifiedParentDataNode.getWrapped$ui_release()) {
                ((DelegatingLayoutNodeWrapper) modifiedParentDataNode.getWrapped$ui_release()).setChained(true);
            }
            layoutNodeWrapper2 = modifiedParentDataNode;
        }
        if (element instanceof SemanticsModifier) {
            DelegatingLayoutNodeWrapper semanticsWrapper = new SemanticsWrapper(layoutNodeWrapper2, (SemanticsModifier) element);
            semanticsWrapper.onInitialize();
            if (layoutNodeWrapper != semanticsWrapper.getWrapped$ui_release()) {
                ((DelegatingLayoutNodeWrapper) semanticsWrapper.getWrapped$ui_release()).setChained(true);
            }
            layoutNodeWrapper2 = semanticsWrapper;
        }
        if (element instanceof OnRemeasuredModifier) {
            DelegatingLayoutNodeWrapper remeasureModifierWrapper = new RemeasureModifierWrapper(layoutNodeWrapper2, (OnRemeasuredModifier) element);
            remeasureModifierWrapper.onInitialize();
            if (layoutNodeWrapper != remeasureModifierWrapper.getWrapped$ui_release()) {
                ((DelegatingLayoutNodeWrapper) remeasureModifierWrapper.getWrapped$ui_release()).setChained(true);
            }
            layoutNodeWrapper2 = remeasureModifierWrapper;
        }
        if (element instanceof OnPlacedModifier) {
            DelegatingLayoutNodeWrapper onPlacedModifierWrapper = new OnPlacedModifierWrapper(layoutNodeWrapper2, (OnPlacedModifier) element);
            onPlacedModifierWrapper.onInitialize();
            if (layoutNodeWrapper != onPlacedModifierWrapper.getWrapped$ui_release()) {
                ((DelegatingLayoutNodeWrapper) onPlacedModifierWrapper.getWrapped$ui_release()).setChained(true);
            }
            layoutNodeWrapper2 = onPlacedModifierWrapper;
        }
        if (!(element instanceof OnGloballyPositionedModifier)) {
            return layoutNodeWrapper2;
        }
        DelegatingLayoutNodeWrapper onGloballyPositionedModifierWrapper = new OnGloballyPositionedModifierWrapper(layoutNodeWrapper2, (OnGloballyPositionedModifier) element);
        onGloballyPositionedModifierWrapper.onInitialize();
        if (layoutNodeWrapper != onGloballyPositionedModifierWrapper.getWrapped$ui_release()) {
            ((DelegatingLayoutNodeWrapper) onGloballyPositionedModifierWrapper.getWrapped$ui_release()).setChained(true);
        }
        return onGloballyPositionedModifierWrapper;
    }
}
