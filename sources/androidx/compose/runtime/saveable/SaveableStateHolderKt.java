package androidx.compose.runtime.saveable;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"rememberSaveableStateHolder", "Landroidx/compose/runtime/saveable/SaveableStateHolder;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/saveable/SaveableStateHolder;", "runtime-saveable_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: SaveableStateHolder.kt */
public final class SaveableStateHolderKt {
    public static final SaveableStateHolder rememberSaveableStateHolder(Composer composer, int i) {
        composer.startReplaceableGroup(-579869653);
        ComposerKt.sourceInformation(composer, "C(rememberSaveableStateHolder)*59@2369L111,64@2554L7:SaveableStateHolder.kt#r2ddri");
        SaveableStateHolderImpl saveableStateHolderImpl = (SaveableStateHolderImpl) RememberSaveableKt.rememberSaveable(new Object[0], SaveableStateHolderImpl.Companion.getSaver(), (String) null, SaveableStateHolderKt$rememberSaveableStateHolder$1.INSTANCE, composer, 8, 4);
        ComposerKt.sourceInformationMarkerStart(composer, 103361330, "C:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(SaveableStateRegistryKt.getLocalSaveableStateRegistry());
        ComposerKt.sourceInformationMarkerEnd(composer);
        saveableStateHolderImpl.setParentSaveableStateRegistry((SaveableStateRegistry) consume);
        composer.endReplaceableGroup();
        return saveableStateHolderImpl;
    }
}
