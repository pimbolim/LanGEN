package androidx.compose.ui.focus;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R*\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048V@VX\u000e¢\u0006\u0012\u0012\u0004\b\u0006\u0010\u0002\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/focus/DefaultFocusProperties;", "Landroidx/compose/ui/focus/FocusProperties;", "()V", "value", "", "canFocus", "getCanFocus$annotations", "getCanFocus", "()Z", "setCanFocus", "(Z)V", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FocusProperties.kt */
public final class DefaultFocusProperties implements FocusProperties {
    public static final DefaultFocusProperties INSTANCE = new DefaultFocusProperties();

    public static /* synthetic */ void getCanFocus$annotations() {
    }

    public boolean getCanFocus() {
        return true;
    }

    private DefaultFocusProperties() {
    }

    public void setCanFocus(boolean z) {
        throw new IllegalStateException("Attempting to change DefaultFocusProperties".toString());
    }
}
