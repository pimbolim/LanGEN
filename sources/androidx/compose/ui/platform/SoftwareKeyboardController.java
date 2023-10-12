package androidx.compose.ui.platform;

import androidx.compose.ui.ExperimentalComposeUiApi;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

@ExperimentalComposeUiApi
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H\u0017J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H\u0017¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/platform/SoftwareKeyboardController;", "", "hide", "", "hideSoftwareKeyboard", "show", "showSoftwareKeyboard", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SoftwareKeyboardController.kt */
public interface SoftwareKeyboardController {
    void hide();

    @Deprecated(message = "Use hide instead.", replaceWith = @ReplaceWith(expression = "hide()", imports = {}))
    void hideSoftwareKeyboard();

    void show();

    @Deprecated(message = "Use show instead.", replaceWith = @ReplaceWith(expression = "show()", imports = {}))
    void showSoftwareKeyboard();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SoftwareKeyboardController.kt */
    public static final class DefaultImpls {
        @Deprecated(message = "Use show instead.", replaceWith = @ReplaceWith(expression = "show()", imports = {}))
        public static void showSoftwareKeyboard(SoftwareKeyboardController softwareKeyboardController) {
            Intrinsics.checkNotNullParameter(softwareKeyboardController, "this");
            softwareKeyboardController.show();
        }

        @Deprecated(message = "Use hide instead.", replaceWith = @ReplaceWith(expression = "hide()", imports = {}))
        public static void hideSoftwareKeyboard(SoftwareKeyboardController softwareKeyboardController) {
            Intrinsics.checkNotNullParameter(softwareKeyboardController, "this");
            softwareKeyboardController.hide();
        }
    }
}
