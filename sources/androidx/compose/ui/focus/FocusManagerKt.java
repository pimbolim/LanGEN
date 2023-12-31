package androidx.compose.ui.focus;

import androidx.compose.ui.node.ModifiedFocusNode;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, d2 = {"updateProperties", "", "Landroidx/compose/ui/node/ModifiedFocusNode;", "ui_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: FocusManager.kt */
public final class FocusManagerKt {
    /* access modifiers changed from: private */
    public static final void updateProperties(ModifiedFocusNode modifiedFocusNode) {
        FocusPropertiesKt.setUpdatedProperties(modifiedFocusNode, (FocusProperties) ((FocusModifier) modifiedFocusNode.getModifier()).getModifierLocalReadScope().getCurrent(FocusPropertiesKt.getModifierLocalFocusProperties()));
        List<ModifiedFocusNode> focusableChildren = modifiedFocusNode.focusableChildren(false);
        int size = focusableChildren.size();
        for (int i = 0; i < size; i++) {
            updateProperties(focusableChildren.get(i));
        }
    }
}
