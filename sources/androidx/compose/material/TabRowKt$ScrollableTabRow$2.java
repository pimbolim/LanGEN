package androidx.compose.material;

import androidx.compose.runtime.Composer;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TabRow.kt */
final class TabRowKt$ScrollableTabRow$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function2<Composer, Integer, Unit> $divider;
    final /* synthetic */ float $edgePadding;
    final /* synthetic */ Function3<List<TabPosition>, Composer, Integer, Unit> $indicator;
    final /* synthetic */ int $selectedTabIndex;
    final /* synthetic */ Function2<Composer, Integer, Unit> $tabs;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TabRowKt$ScrollableTabRow$2(float f, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, int i, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, int i2) {
        super(2);
        this.$edgePadding = f;
        this.$tabs = function2;
        this.$divider = function22;
        this.$selectedTabIndex = i;
        this.$indicator = function3;
        this.$$dirty = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v0, resolved type: androidx.compose.material.ScrollableTabData} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.runtime.Composer r18, int r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            java.lang.String r2 = "C242@11818L21,243@11869L24,244@11926L185,250@12120L2577:TabRow.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            r2 = r19 & 11
            r3 = 2
            r2 = r2 ^ r3
            if (r2 != 0) goto L_0x001b
            boolean r2 = r18.getSkipping()
            if (r2 != 0) goto L_0x0016
            goto L_0x001b
        L_0x0016:
            r18.skipToGroupEnd()
            goto L_0x00ce
        L_0x001b:
            r2 = 0
            r4 = 1
            androidx.compose.foundation.ScrollState r6 = androidx.compose.foundation.ScrollKt.rememberScrollState(r2, r1, r2, r4)
            r5 = -723524056(0xffffffffd4dfe628, float:-7.6931127E12)
            r1.startReplaceableGroup(r5)
            java.lang.String r5 = "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r5)
            r5 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r1.startReplaceableGroup(r5)
            java.lang.String r5 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r5)
            java.lang.Object r5 = r18.rememberedValue()
            androidx.compose.runtime.Composer$Companion r7 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r7.getEmpty()
            if (r5 != r7) goto L_0x0054
            kotlin.coroutines.EmptyCoroutineContext r5 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlin.coroutines.CoroutineContext r5 = (kotlin.coroutines.CoroutineContext) r5
            kotlinx.coroutines.CoroutineScope r5 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r5, r1)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r7 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r7.<init>(r5)
            r1.updateRememberedValue(r7)
            r5 = r7
        L_0x0054:
            r18.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r5 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r5
            kotlinx.coroutines.CoroutineScope r5 = r5.getCoroutineScope()
            r18.endReplaceableGroup()
            r7 = -3686552(0xffffffffffc7bf68, float:NaN)
            r1.startReplaceableGroup(r7)
            java.lang.String r7 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r7)
            boolean r7 = r1.changed((java.lang.Object) r6)
            boolean r8 = r1.changed((java.lang.Object) r5)
            r7 = r7 | r8
            java.lang.Object r8 = r18.rememberedValue()
            if (r7 != 0) goto L_0x0082
            androidx.compose.runtime.Composer$Companion r7 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r7.getEmpty()
            if (r8 != r7) goto L_0x008a
        L_0x0082:
            androidx.compose.material.ScrollableTabData r8 = new androidx.compose.material.ScrollableTabData
            r8.<init>(r6, r5)
            r1.updateRememberedValue(r8)
        L_0x008a:
            r18.endReplaceableGroup()
            r13 = r8
            androidx.compose.material.ScrollableTabData r13 = (androidx.compose.material.ScrollableTabData) r13
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            r7 = 0
            r8 = 0
            androidx.compose.ui.Modifier r4 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r5, r7, r4, r8)
            androidx.compose.ui.Alignment$Companion r5 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r5 = r5.getCenterStart()
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.layout.SizeKt.wrapContentSize$default(r4, r5, r2, r3, r8)
            r7 = 0
            r9 = 0
            r10 = 14
            r11 = 0
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.ScrollKt.horizontalScroll$default(r5, r6, r7, r8, r9, r10, r11)
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.selection.SelectableGroupKt.selectableGroup(r3)
            androidx.compose.ui.Modifier r3 = androidx.compose.ui.draw.ClipKt.clipToBounds(r3)
            androidx.compose.material.TabRowKt$ScrollableTabRow$2$1 r4 = new androidx.compose.material.TabRowKt$ScrollableTabRow$2$1
            float r10 = r0.$edgePadding
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r11 = r0.$tabs
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r12 = r0.$divider
            int r14 = r0.$selectedTabIndex
            kotlin.jvm.functions.Function3<java.util.List<androidx.compose.material.TabPosition>, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r15 = r0.$indicator
            int r5 = r0.$$dirty
            r9 = r4
            r16 = r5
            r9.<init>(r10, r11, r12, r13, r14, r15, r16)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            androidx.compose.ui.layout.SubcomposeLayoutKt.SubcomposeLayout(r3, r4, r1, r2, r2)
        L_0x00ce:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TabRowKt$ScrollableTabRow$2.invoke(androidx.compose.runtime.Composer, int):void");
    }
}
