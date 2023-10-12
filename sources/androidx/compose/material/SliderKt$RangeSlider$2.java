package androidx.compose.material;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.ClosedFloatingPointRange;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Slider.kt */
final class SliderKt$RangeSlider$2 extends Lambda implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ SliderColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $endInteractionSource;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function0<Unit> $onValueChangeFinished;
    final /* synthetic */ State<Function1<ClosedFloatingPointRange<Float>, Unit>> $onValueChangeState;
    final /* synthetic */ MutableInteractionSource $startInteractionSource;
    final /* synthetic */ List<Float> $tickFractions;
    final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;
    final /* synthetic */ ClosedFloatingPointRange<Float> $values;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SliderKt$RangeSlider$2(ClosedFloatingPointRange<Float> closedFloatingPointRange, ClosedFloatingPointRange<Float> closedFloatingPointRange2, int i, Modifier modifier, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, boolean z, State<? extends Function1<? super ClosedFloatingPointRange<Float>, Unit>> state, List<Float> list, SliderColors sliderColors, Function0<Unit> function0) {
        super(3);
        this.$valueRange = closedFloatingPointRange;
        this.$values = closedFloatingPointRange2;
        this.$$dirty = i;
        this.$modifier = modifier;
        this.$startInteractionSource = mutableInteractionSource;
        this.$endInteractionSource = mutableInteractionSource2;
        this.$enabled = z;
        this.$onValueChangeState = state;
        this.$tickFractions = list;
        this.$colors = sliderColors;
        this.$onValueChangeFinished = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((BoxWithConstraintsScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v1, resolved type: kotlin.jvm.functions.Function2} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.foundation.layout.BoxWithConstraintsScope r30, androidx.compose.runtime.Composer r31, int r32) {
        /*
            r29 = this;
            r0 = r29
            r1 = r30
            r10 = r31
            java.lang.String r2 = "$this$BoxWithConstraints"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            java.lang.String r2 = "C281@13068L7,291@13492L56,292@13576L63,294@13649L81,295@13739L86,297@13847L24,298@13903L944,332@15159L481,352@16092L284:Slider.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r2)
            r2 = r32 & 14
            r8 = 2
            if (r2 != 0) goto L_0x0021
            boolean r2 = r10.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x001d
            r2 = 4
            goto L_0x001e
        L_0x001d:
            r2 = 2
        L_0x001e:
            r2 = r32 | r2
            goto L_0x0023
        L_0x0021:
            r2 = r32
        L_0x0023:
            r2 = r2 & 91
            r2 = r2 ^ 18
            if (r2 != 0) goto L_0x0035
            boolean r2 = r31.getSkipping()
            if (r2 != 0) goto L_0x0030
            goto L_0x0035
        L_0x0030:
            r31.skipToGroupEnd()
            goto L_0x02b9
        L_0x0035:
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r3 = 103361330(0x6292b32, float:3.1817102E-35)
            java.lang.String r4 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r3, r4)
            java.lang.Object r2 = r10.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r31)
            androidx.compose.ui.unit.LayoutDirection r3 = androidx.compose.ui.unit.LayoutDirection.Rtl
            r9 = 1
            r11 = 0
            if (r2 != r3) goto L_0x0053
            r18 = 1
            goto L_0x0055
        L_0x0053:
            r18 = 0
        L_0x0055:
            long r1 = r30.m390getConstraintsmsEJaDk()
            int r1 = androidx.compose.ui.unit.Constraints.m3803getMaxWidthimpl(r1)
            float r15 = (float) r1
            r12 = 0
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r1 = r0.$values
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r2 = r0.$valueRange
            r13 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r10.startReplaceableGroup(r13)
            java.lang.String r14 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r14)
            java.lang.Object r3 = r31.rememberedValue()
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            r5 = 0
            if (r3 != r4) goto L_0x0094
            java.lang.Comparable r1 = r1.getStart()
            java.lang.Number r1 = (java.lang.Number) r1
            float r1 = r1.floatValue()
            float r1 = invoke$scaleToOffset(r2, r12, r15, r1)
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            androidx.compose.runtime.MutableState r3 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r1, r5, r8, r5)
            r10.updateRememberedValue(r3)
        L_0x0094:
            r31.endReplaceableGroup()
            r16 = r3
            androidx.compose.runtime.MutableState r16 = (androidx.compose.runtime.MutableState) r16
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r1 = r0.$values
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r2 = r0.$valueRange
            r10.startReplaceableGroup(r13)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r14)
            java.lang.Object r3 = r31.rememberedValue()
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r3 != r4) goto L_0x00ca
            java.lang.Comparable r1 = r1.getEndInclusive()
            java.lang.Number r1 = (java.lang.Number) r1
            float r1 = r1.floatValue()
            float r1 = invoke$scaleToOffset(r2, r12, r15, r1)
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            androidx.compose.runtime.MutableState r3 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r1, r5, r8, r5)
            r10.updateRememberedValue(r3)
        L_0x00ca:
            r31.endReplaceableGroup()
            r17 = r3
            androidx.compose.runtime.MutableState r17 = (androidx.compose.runtime.MutableState) r17
            androidx.compose.material.SliderKt$RangeSlider$2$1 r1 = new androidx.compose.material.SliderKt$RangeSlider$2$1
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r2 = r0.$valueRange
            r1.<init>(r2, r12, r15)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r2 = r0.$valueRange
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r3 = r0.$values
            java.lang.Comparable r3 = r3.getStart()
            java.lang.Number r3 = (java.lang.Number) r3
            float r4 = r3.floatValue()
            int r3 = r0.$$dirty
            int r3 = r3 >> 9
            r3 = r3 & 112(0x70, float:1.57E-43)
            r6 = r3 | 384(0x180, float:5.38E-43)
            r3 = r16
            r5 = r31
            androidx.compose.material.SliderKt.CorrectValueSideEffect(r1, r2, r3, r4, r5, r6)
            androidx.compose.material.SliderKt$RangeSlider$2$2 r1 = new androidx.compose.material.SliderKt$RangeSlider$2$2
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r2 = r0.$valueRange
            r1.<init>(r2, r12, r15)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r2 = r0.$valueRange
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r3 = r0.$values
            java.lang.Comparable r3 = r3.getEndInclusive()
            java.lang.Number r3 = (java.lang.Number) r3
            float r4 = r3.floatValue()
            int r3 = r0.$$dirty
            int r3 = r3 >> 9
            r3 = r3 & 112(0x70, float:1.57E-43)
            r6 = r3 | 384(0x180, float:5.38E-43)
            r3 = r17
            androidx.compose.material.SliderKt.CorrectValueSideEffect(r1, r2, r3, r4, r5, r6)
            r1 = -723524056(0xffffffffd4dfe628, float:-7.6931127E12)
            r10.startReplaceableGroup(r1)
            java.lang.String r1 = "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            r10.startReplaceableGroup(r13)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r14)
            java.lang.Object r1 = r31.rememberedValue()
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r1 != r2) goto L_0x0149
            kotlin.coroutines.EmptyCoroutineContext r1 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1
            kotlinx.coroutines.CoroutineScope r1 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r1, r10)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r2 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r2.<init>(r1)
            r10.updateRememberedValue(r2)
            r1 = r2
        L_0x0149:
            r31.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r1 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r1
            kotlinx.coroutines.CoroutineScope r26 = r1.getCoroutineScope()
            r31.endReplaceableGroup()
            androidx.compose.material.SliderKt$RangeSlider$2$gestureEndAction$1 r1 = new androidx.compose.material.SliderKt$RangeSlider$2$gestureEndAction$1
            java.util.List<java.lang.Float> r2 = r0.$tickFractions
            kotlin.jvm.functions.Function0<kotlin.Unit> r3 = r0.$onValueChangeFinished
            androidx.compose.runtime.State<kotlin.jvm.functions.Function1<kotlin.ranges.ClosedFloatingPointRange<java.lang.Float>, kotlin.Unit>> r4 = r0.$onValueChangeState
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r5 = r0.$valueRange
            r23 = 0
            r19 = r1
            r20 = r16
            r21 = r17
            r22 = r2
            r24 = r15
            r25 = r3
            r27 = r4
            r28 = r5
            r19.<init>(r20, r21, r22, r23, r24, r25, r26, r27, r28)
            androidx.compose.runtime.State r1 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r1, r10, r11)
            androidx.compose.ui.Modifier r2 = r0.$modifier
            androidx.compose.foundation.interaction.MutableInteractionSource r13 = r0.$startInteractionSource
            androidx.compose.foundation.interaction.MutableInteractionSource r14 = r0.$endInteractionSource
            r3 = r16
            androidx.compose.runtime.State r3 = (androidx.compose.runtime.State) r3
            r4 = r17
            androidx.compose.runtime.State r4 = (androidx.compose.runtime.State) r4
            boolean r5 = r0.$enabled
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r6 = r0.$valueRange
            r7 = 6
            java.lang.Object[] r8 = new java.lang.Object[r7]
            r8[r11] = r16
            java.lang.Float r12 = java.lang.Float.valueOf(r12)
            r8[r9] = r12
            r9 = 2
            r8[r9] = r17
            r9 = 3
            java.lang.Float r12 = java.lang.Float.valueOf(r15)
            r8[r9] = r12
            androidx.compose.runtime.State<kotlin.jvm.functions.Function1<kotlin.ranges.ClosedFloatingPointRange<java.lang.Float>, kotlin.Unit>> r9 = r0.$onValueChangeState
            r12 = 4
            r8[r12] = r9
            r12 = 5
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r11 = r0.$valueRange
            r8[r12] = r11
            r12 = -3685570(0xffffffffffc7c33e, float:NaN)
            r10.startReplaceableGroup(r12)
            java.lang.String r12 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r12)
            r12 = 0
            r19 = 0
        L_0x01b7:
            if (r12 >= r7) goto L_0x01c5
            r7 = r8[r12]
            int r12 = r12 + 1
            boolean r7 = r10.changed((java.lang.Object) r7)
            r19 = r19 | r7
            r7 = 6
            goto L_0x01b7
        L_0x01c5:
            java.lang.Object r7 = r31.rememberedValue()
            if (r19 != 0) goto L_0x01d3
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r7 != r8) goto L_0x01eb
        L_0x01d3:
            androidx.compose.material.SliderKt$RangeSlider$2$pressDrag$1$1 r7 = new androidx.compose.material.SliderKt$RangeSlider$2$pressDrag$1$1
            r21 = 0
            r19 = r7
            r20 = r16
            r22 = r17
            r23 = r15
            r24 = r9
            r25 = r11
            r19.<init>(r20, r21, r22, r23, r24, r25)
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r10.updateRememberedValue(r7)
        L_0x01eb:
            r31.endReplaceableGroup()
            r22 = r7
            kotlin.jvm.functions.Function2 r22 = (kotlin.jvm.functions.Function2) r22
            r12 = r2
            r7 = r15
            r15 = r3
            r16 = r4
            r17 = r5
            r19 = r7
            r20 = r6
            r21 = r1
            androidx.compose.ui.Modifier r1 = androidx.compose.material.SliderKt.rangeSliderPressDragModifier(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r2 = r0.$values
            java.lang.Comparable r2 = r2.getStart()
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r3 = r0.$valueRange
            java.lang.Comparable r3 = r3.getStart()
            java.lang.Number r3 = (java.lang.Number) r3
            float r3 = r3.floatValue()
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r4 = r0.$values
            java.lang.Comparable r4 = r4.getEndInclusive()
            java.lang.Number r4 = (java.lang.Number) r4
            float r4 = r4.floatValue()
            float r2 = kotlin.ranges.RangesKt.coerceIn((float) r2, (float) r3, (float) r4)
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r3 = r0.$values
            java.lang.Comparable r3 = r3.getEndInclusive()
            java.lang.Number r3 = (java.lang.Number) r3
            float r3 = r3.floatValue()
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r4 = r0.$values
            java.lang.Comparable r4 = r4.getStart()
            java.lang.Number r4 = (java.lang.Number) r4
            float r4 = r4.floatValue()
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r5 = r0.$valueRange
            java.lang.Comparable r5 = r5.getEndInclusive()
            java.lang.Number r5 = (java.lang.Number) r5
            float r5 = r5.floatValue()
            float r3 = kotlin.ranges.RangesKt.coerceIn((float) r3, (float) r4, (float) r5)
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r4 = r0.$valueRange
            java.lang.Comparable r4 = r4.getStart()
            java.lang.Number r4 = (java.lang.Number) r4
            float r4 = r4.floatValue()
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r5 = r0.$valueRange
            java.lang.Comparable r5 = r5.getEndInclusive()
            java.lang.Number r5 = (java.lang.Number) r5
            float r5 = r5.floatValue()
            float r2 = androidx.compose.material.SliderKt.calcFraction(r4, r5, r2)
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r4 = r0.$valueRange
            java.lang.Comparable r4 = r4.getStart()
            java.lang.Number r4 = (java.lang.Number) r4
            float r4 = r4.floatValue()
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r5 = r0.$valueRange
            java.lang.Comparable r5 = r5.getEndInclusive()
            java.lang.Number r5 = (java.lang.Number) r5
            float r5 = r5.floatValue()
            float r3 = androidx.compose.material.SliderKt.calcFraction(r4, r5, r3)
            boolean r4 = r0.$enabled
            java.util.List<java.lang.Float> r5 = r0.$tickFractions
            androidx.compose.material.SliderColors r6 = r0.$colors
            androidx.compose.foundation.interaction.MutableInteractionSource r8 = r0.$startInteractionSource
            androidx.compose.foundation.interaction.MutableInteractionSource r9 = r0.$endInteractionSource
            androidx.compose.ui.Modifier r11 = r0.$modifier
            androidx.compose.ui.Modifier r11 = r1.then(r11)
            r1 = 14159872(0xd81000, float:1.9842207E-38)
            int r12 = r0.$$dirty
            int r13 = r12 >> 9
            r13 = r13 & 14
            r1 = r1 | r13
            r13 = 57344(0xe000, float:8.0356E-41)
            int r12 = r12 >> 9
            r12 = r12 & r13
            r12 = r12 | r1
            r1 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r11
            r10 = r31
            r11 = r12
            androidx.compose.material.SliderKt.RangeSliderImpl(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
        L_0x02b9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SliderKt$RangeSlider$2.invoke(androidx.compose.foundation.layout.BoxWithConstraintsScope, androidx.compose.runtime.Composer, int):void");
    }

    /* access modifiers changed from: private */
    public static final ClosedFloatingPointRange<Float> invoke$scaleToUserValue(float f, float f2, ClosedFloatingPointRange<Float> closedFloatingPointRange, ClosedFloatingPointRange<Float> closedFloatingPointRange2) {
        return SliderKt.scale(f, f2, closedFloatingPointRange2, closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue());
    }

    /* access modifiers changed from: private */
    public static final float invoke$scaleToOffset(ClosedFloatingPointRange<Float> closedFloatingPointRange, float f, float f2, float f3) {
        return SliderKt.scale(closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue(), f3, f, f2);
    }
}
