package androidx.compose.runtime.saveable;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: RememberSaveable.kt */
final class RememberSaveableKt$rememberSaveable$1$valueProvider$1 extends Lambda implements Function0<Object> {
    final /* synthetic */ SaveableStateRegistry $registry;
    final /* synthetic */ MutableState<Saver<T, Object>> $saverHolder;
    final /* synthetic */ T $value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RememberSaveableKt$rememberSaveable$1$valueProvider$1(MutableState<Saver<T, Object>> mutableState, T t, SaveableStateRegistry saveableStateRegistry) {
        super(0);
        this.$saverHolder = mutableState;
        this.$value = t;
        this.$registry = saveableStateRegistry;
    }

    public final Object invoke() {
        return this.$saverHolder.getValue().save(new RememberSaveableKt$rememberSaveable$1$valueProvider$1$1$1(this.$registry), this.$value);
    }
}
