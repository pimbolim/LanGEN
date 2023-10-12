package androidx.navigation.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.compose.DialogNavigator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: DialogHost.kt */
final class DialogHostKt$DialogHost$1$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ NavBackStackEntry $backStackEntry;
    final /* synthetic */ DialogNavigator.Destination $destination;
    final /* synthetic */ DialogNavigator $dialogNavigator;
    final /* synthetic */ SaveableStateHolder $saveableStateHolder;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DialogHostKt$DialogHost$1$2(NavBackStackEntry navBackStackEntry, SaveableStateHolder saveableStateHolder, DialogNavigator.Destination destination, DialogNavigator dialogNavigator) {
        super(2);
        this.$backStackEntry = navBackStackEntry;
        this.$saveableStateHolder = saveableStateHolder;
        this.$destination = destination;
        this.$dialogNavigator = dialogNavigator;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C51@2177L108,55@2299L167:DialogHost.kt#opm8kd");
        if ((i & 11) != 2 || !composer.getSkipping()) {
            final NavBackStackEntry navBackStackEntry = this.$backStackEntry;
            SaveableStateHolder saveableStateHolder = this.$saveableStateHolder;
            final DialogNavigator.Destination destination = this.$destination;
            NavBackStackEntryProviderKt.LocalOwnersProvider(navBackStackEntry, saveableStateHolder, ComposableLambdaKt.composableLambda(composer, -497631156, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    ComposerKt.sourceInformation(composer, "C52@2248L23:DialogHost.kt#opm8kd");
                    if ((i & 11) != 2 || !composer.getSkipping()) {
                        destination.getContent$navigation_compose_release().invoke(navBackStackEntry, composer, 8);
                    } else {
                        composer.skipToGroupEnd();
                    }
                }
            }), composer, 456);
            final NavBackStackEntry navBackStackEntry2 = this.$backStackEntry;
            final DialogNavigator dialogNavigator = this.$dialogNavigator;
            EffectsKt.DisposableEffect((Object) navBackStackEntry2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) new Function1<DisposableEffectScope, DisposableEffectResult>() {
                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                    Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
                    return new DialogHostKt$DialogHost$1$2$2$invoke$$inlined$onDispose$1(dialogNavigator, navBackStackEntry2);
                }
            }, composer, 8);
            return;
        }
        composer.skipToGroupEnd();
    }
}
