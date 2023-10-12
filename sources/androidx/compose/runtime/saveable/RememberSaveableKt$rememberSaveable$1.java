package androidx.compose.runtime.saveable;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: RememberSaveable.kt */
final class RememberSaveableKt$rememberSaveable$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ String $finalKey;
    final /* synthetic */ SaveableStateRegistry $registry;
    final /* synthetic */ MutableState<Saver<T, Object>> $saverHolder;
    final /* synthetic */ T $value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RememberSaveableKt$rememberSaveable$1(SaveableStateRegistry saveableStateRegistry, String str, MutableState<Saver<T, Object>> mutableState, T t) {
        super(1);
        this.$registry = saveableStateRegistry;
        this.$finalKey = str;
        this.$saverHolder = mutableState;
        this.$value = t;
    }

    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        Function0 rememberSaveableKt$rememberSaveable$1$valueProvider$1 = new RememberSaveableKt$rememberSaveable$1$valueProvider$1(this.$saverHolder, this.$value, this.$registry);
        RememberSaveableKt.requireCanBeSaved(this.$registry, rememberSaveableKt$rememberSaveable$1$valueProvider$1.invoke());
        return new RememberSaveableKt$rememberSaveable$1$invoke$$inlined$onDispose$1(this.$registry.registerProvider(this.$finalKey, rememberSaveableKt$rememberSaveable$1$valueProvider$1));
    }
}
