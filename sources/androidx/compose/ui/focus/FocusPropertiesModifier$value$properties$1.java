package androidx.compose.ui.focus;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"androidx/compose/ui/focus/FocusPropertiesModifier$value$properties$1", "Landroidx/compose/ui/focus/FocusProperties;", "canFocus", "", "getCanFocus", "()Z", "setCanFocus", "(Z)V", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FocusProperties.kt */
public final class FocusPropertiesModifier$value$properties$1 implements FocusProperties {
    private boolean canFocus = DefaultFocusProperties.INSTANCE.getCanFocus();

    FocusPropertiesModifier$value$properties$1() {
    }

    public boolean getCanFocus() {
        return this.canFocus;
    }

    public void setCanFocus(boolean z) {
        this.canFocus = z;
    }
}
