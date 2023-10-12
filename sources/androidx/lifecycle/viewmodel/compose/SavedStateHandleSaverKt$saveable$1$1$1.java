package androidx.lifecycle.viewmodel.compose;

import androidx.compose.runtime.saveable.SaverScope;
import androidx.lifecycle.SavedStateHandle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "T", "", "it"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SavedStateHandleSaver.kt */
final class SavedStateHandleSaverKt$saveable$1$1$1 implements SaverScope {
    final /* synthetic */ T $value;

    SavedStateHandleSaverKt$saveable$1$1$1(T t) {
        this.$value = t;
    }

    public final boolean canBeSaved(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "it");
        return SavedStateHandle.Companion.validateValue(this.$value);
    }
}
