package androidx.compose.ui.platform;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.text.input.TextInputService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@ExperimentalComposeUiApi
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0003¢\u0006\u0002\u0010\tJ\u0019\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\f2\u0006\u0010\r\u001a\u00020\u0005H\u0004R\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00058GX\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/platform/LocalSoftwareKeyboardController;", "", "()V", "LocalSoftwareKeyboardController", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "current", "getCurrent$annotations", "getCurrent", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/platform/SoftwareKeyboardController;", "delegatingController", "provides", "Landroidx/compose/runtime/ProvidedValue;", "softwareKeyboardController", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LocalSoftwareKeyboardController.kt */
public final class LocalSoftwareKeyboardController {
    public static final int $stable = 0;
    public static final LocalSoftwareKeyboardController INSTANCE = new LocalSoftwareKeyboardController();
    private static final ProvidableCompositionLocal<SoftwareKeyboardController> LocalSoftwareKeyboardController = CompositionLocalKt.compositionLocalOf$default((SnapshotMutationPolicy) null, LocalSoftwareKeyboardController$LocalSoftwareKeyboardController$1.INSTANCE, 1, (Object) null);

    @ExperimentalComposeUiApi
    public static /* synthetic */ void getCurrent$annotations() {
    }

    private LocalSoftwareKeyboardController() {
    }

    public final SoftwareKeyboardController getCurrent(Composer composer, int i) {
        composer.startReplaceableGroup(1850767929);
        ComposerKt.sourceInformation(composer, "C41@1585L7,41@1596L22:LocalSoftwareKeyboardController.kt#itgzvw");
        ComposerKt.sourceInformationMarkerStart(composer, 103361330, "C:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(LocalSoftwareKeyboardController);
        ComposerKt.sourceInformationMarkerEnd(composer);
        SoftwareKeyboardController softwareKeyboardController = (SoftwareKeyboardController) consume;
        if (softwareKeyboardController == null) {
            softwareKeyboardController = delegatingController(composer, i & 14);
        }
        composer.endReplaceableGroup();
        return softwareKeyboardController;
    }

    private final SoftwareKeyboardController delegatingController(Composer composer, int i) {
        composer.startReplaceableGroup(1255403937);
        ComposerKt.sourceInformation(composer, "C(delegatingController)46@1769L7,47@1807L105:LocalSoftwareKeyboardController.kt#itgzvw");
        ComposerKt.sourceInformationMarkerStart(composer, 103361330, "C:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(CompositionLocalsKt.getLocalTextInputService());
        ComposerKt.sourceInformationMarkerEnd(composer);
        TextInputService textInputService = (TextInputService) consume;
        if (textInputService == null) {
            composer.endReplaceableGroup();
            return null;
        }
        composer.startReplaceableGroup(-3686930);
        ComposerKt.sourceInformation(composer, "C(remember)P(1):Composables.kt#9igjgp");
        boolean changed = composer.changed((Object) textInputService);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new DelegatingSoftwareKeyboardController(textInputService);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return (DelegatingSoftwareKeyboardController) rememberedValue;
    }

    public final ProvidedValue<SoftwareKeyboardController> provides(SoftwareKeyboardController softwareKeyboardController) {
        Intrinsics.checkNotNullParameter(softwareKeyboardController, "softwareKeyboardController");
        return LocalSoftwareKeyboardController.provides(softwareKeyboardController);
    }
}
