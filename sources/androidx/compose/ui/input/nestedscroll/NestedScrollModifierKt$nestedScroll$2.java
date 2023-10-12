package androidx.compose.ui.input.nestedscroll;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: NestedScrollModifier.kt */
final class NestedScrollModifierKt$nestedScroll$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ NestedScrollConnection $connection;
    final /* synthetic */ NestedScrollDispatcher $dispatcher;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NestedScrollModifierKt$nestedScroll$2(NestedScrollDispatcher nestedScrollDispatcher, NestedScrollConnection nestedScrollConnection) {
        super(3);
        this.$dispatcher = nestedScrollDispatcher;
        this.$connection = nestedScrollConnection;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.ui.Modifier invoke(androidx.compose.ui.Modifier r4, androidx.compose.runtime.Composer r5, int r6) {
        /*
            r3 = this;
            java.lang.String r6 = "$this$composed"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r6)
            r4 = 100476458(0x5fd262a, float:2.3806025E-35)
            r5.startReplaceableGroup(r4)
            java.lang.String r4 = "C354@16076L24,357@16227L331:NestedScrollModifier.kt#kpqmsf"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r4)
            r4 = -723524056(0xffffffffd4dfe628, float:-7.6931127E12)
            r5.startReplaceableGroup(r4)
            java.lang.String r4 = "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r4)
            r4 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r5.startReplaceableGroup(r4)
            java.lang.String r6 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r6)
            java.lang.Object r0 = r5.rememberedValue()
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r0 != r1) goto L_0x0043
            kotlin.coroutines.EmptyCoroutineContext r0 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlin.coroutines.CoroutineContext r0 = (kotlin.coroutines.CoroutineContext) r0
            kotlinx.coroutines.CoroutineScope r0 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r0, r5)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r1 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r1.<init>(r0)
            r5.updateRememberedValue(r1)
            r0 = r1
        L_0x0043:
            r5.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r0 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r0
            kotlinx.coroutines.CoroutineScope r0 = r0.getCoroutineScope()
            r5.endReplaceableGroup()
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher r1 = r3.$dispatcher
            r2 = 100476571(0x5fd269b, float:2.3806187E-35)
            r5.startReplaceableGroup(r2)
            java.lang.String r2 = "356@16185L37"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r2)
            if (r1 != 0) goto L_0x007e
            r5.startReplaceableGroup(r4)
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r6)
            java.lang.Object r4 = r5.rememberedValue()
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r4 != r6) goto L_0x0078
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher r4 = new androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher
            r4.<init>()
            r5.updateRememberedValue(r4)
        L_0x0078:
            r5.endReplaceableGroup()
            r1 = r4
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher r1 = (androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher) r1
        L_0x007e:
            r5.endReplaceableGroup()
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r4 = r3.$connection
            r6 = -3686095(0xffffffffffc7c131, float:NaN)
            r5.startReplaceableGroup(r6)
            java.lang.String r6 = "C(remember)P(1,2,3):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r6)
            boolean r6 = r5.changed((java.lang.Object) r4)
            boolean r2 = r5.changed((java.lang.Object) r1)
            r6 = r6 | r2
            boolean r2 = r5.changed((java.lang.Object) r0)
            r6 = r6 | r2
            java.lang.Object r2 = r5.rememberedValue()
            if (r6 != 0) goto L_0x00aa
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r2 != r6) goto L_0x00b2
        L_0x00aa:
            androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt$nestedScroll$2$1$1 r2 = new androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt$nestedScroll$2$1$1
            r2.<init>(r1, r4, r0)
            r5.updateRememberedValue(r2)
        L_0x00b2:
            r5.endReplaceableGroup()
            androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt$nestedScroll$2$1$1 r2 = (androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt$nestedScroll$2$1$1) r2
            r5.endReplaceableGroup()
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt$nestedScroll$2.invoke(androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int):androidx.compose.ui.Modifier");
    }
}
