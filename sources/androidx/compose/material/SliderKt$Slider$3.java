package androidx.compose.material;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
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
final class SliderKt$Slider$3 extends Lambda implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ SliderColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ Function0<Unit> $onValueChangeFinished;
    final /* synthetic */ State<Function1<Float, Unit>> $onValueChangeState;
    final /* synthetic */ List<Float> $tickFractions;
    final /* synthetic */ float $value;
    final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SliderKt$Slider$3(ClosedFloatingPointRange<Float> closedFloatingPointRange, int i, float f, MutableInteractionSource mutableInteractionSource, boolean z, List<Float> list, SliderColors sliderColors, State<? extends Function1<? super Float, Unit>> state, Function0<Unit> function0) {
        super(3);
        this.$valueRange = closedFloatingPointRange;
        this.$$dirty = i;
        this.$value = f;
        this.$interactionSource = mutableInteractionSource;
        this.$enabled = z;
        this.$tickFractions = list;
        this.$colors = sliderColors;
        this.$onValueChangeState = state;
        this.$onValueChangeFinished = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((BoxWithConstraintsScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v0, resolved type: androidx.compose.material.SliderDraggableState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v3, resolved type: kotlin.jvm.functions.Function3} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.foundation.layout.BoxWithConstraintsScope r21, androidx.compose.runtime.Composer r22, int r23) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r8 = r22
            java.lang.String r2 = "$this$BoxWithConstraints"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            java.lang.String r2 = "C162@7796L7,172@8185L24,173@8234L49,174@8313L258,181@8581L69,183@8683L618,206@9699L55,213@10040L201:Slider.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r2)
            r2 = r23 & 14
            r3 = 2
            if (r2 != 0) goto L_0x0021
            boolean r2 = r8.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x001d
            r2 = 4
            goto L_0x001e
        L_0x001d:
            r2 = 2
        L_0x001e:
            r2 = r23 | r2
            goto L_0x0023
        L_0x0021:
            r2 = r23
        L_0x0023:
            r2 = r2 & 91
            r2 = r2 ^ 18
            if (r2 != 0) goto L_0x0035
            boolean r2 = r22.getSkipping()
            if (r2 != 0) goto L_0x0030
            goto L_0x0035
        L_0x0030:
            r22.skipToGroupEnd()
            goto L_0x0226
        L_0x0035:
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r4 = 103361330(0x6292b32, float:3.1817102E-35)
            java.lang.String r5 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r4, r5)
            java.lang.Object r2 = r8.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r22)
            androidx.compose.ui.unit.LayoutDirection r4 = androidx.compose.ui.unit.LayoutDirection.Rtl
            r7 = 0
            if (r2 != r4) goto L_0x0053
            r2 = 1
            r17 = 1
            goto L_0x0055
        L_0x0053:
            r17 = 0
        L_0x0055:
            long r1 = r21.m390getConstraintsmsEJaDk()
            int r1 = androidx.compose.ui.unit.Constraints.m3803getMaxWidthimpl(r1)
            float r15 = (float) r1
            r1 = 0
            r2 = -723524056(0xffffffffd4dfe628, float:-7.6931127E12)
            r8.startReplaceableGroup(r2)
            java.lang.String r2 = "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r2)
            r2 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r8.startReplaceableGroup(r2)
            java.lang.String r4 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r4)
            java.lang.Object r5 = r22.rememberedValue()
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r5 != r6) goto L_0x0092
            kotlin.coroutines.EmptyCoroutineContext r5 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlin.coroutines.CoroutineContext r5 = (kotlin.coroutines.CoroutineContext) r5
            kotlinx.coroutines.CoroutineScope r5 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r5, r8)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r6 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r6.<init>(r5)
            r8.updateRememberedValue(r6)
            r5 = r6
        L_0x0092:
            r22.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r5 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r5
            kotlinx.coroutines.CoroutineScope r16 = r5.getCoroutineScope()
            r22.endReplaceableGroup()
            float r5 = r0.$value
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r6 = r0.$valueRange
            r8.startReplaceableGroup(r2)
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r4)
            java.lang.Object r2 = r22.rememberedValue()
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            r14 = 0
            if (r2 != r4) goto L_0x00c4
            float r2 = invoke$scaleToOffset(r6, r1, r15, r5)
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            androidx.compose.runtime.MutableState r2 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r2, r14, r3, r14)
            r8.updateRememberedValue(r2)
        L_0x00c4:
            r22.endReplaceableGroup()
            r18 = r2
            androidx.compose.runtime.MutableState r18 = (androidx.compose.runtime.MutableState) r18
            java.lang.Float r2 = java.lang.Float.valueOf(r1)
            java.lang.Float r3 = java.lang.Float.valueOf(r15)
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r4 = r0.$valueRange
            androidx.compose.runtime.State<kotlin.jvm.functions.Function1<java.lang.Float, kotlin.Unit>> r13 = r0.$onValueChangeState
            r5 = -3686095(0xffffffffffc7c131, float:NaN)
            r8.startReplaceableGroup(r5)
            java.lang.String r5 = "C(remember)P(1,2,3):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r5)
            boolean r2 = r8.changed((java.lang.Object) r2)
            boolean r3 = r8.changed((java.lang.Object) r3)
            r2 = r2 | r3
            boolean r3 = r8.changed((java.lang.Object) r4)
            r2 = r2 | r3
            java.lang.Object r3 = r22.rememberedValue()
            if (r2 != 0) goto L_0x0101
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r3 != r2) goto L_0x00ff
            goto L_0x0101
        L_0x00ff:
            r6 = r14
            goto L_0x0117
        L_0x0101:
            androidx.compose.material.SliderDraggableState r3 = new androidx.compose.material.SliderDraggableState
            androidx.compose.material.SliderKt$Slider$3$draggableState$1$1 r2 = new androidx.compose.material.SliderKt$Slider$3$draggableState$1$1
            r11 = 0
            r9 = r2
            r10 = r18
            r12 = r15
            r6 = r14
            r14 = r4
            r9.<init>(r10, r11, r12, r13, r14)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r3.<init>(r2)
            r8.updateRememberedValue(r3)
        L_0x0117:
            r22.endReplaceableGroup()
            r19 = r3
            androidx.compose.material.SliderDraggableState r19 = (androidx.compose.material.SliderDraggableState) r19
            androidx.compose.material.SliderKt$Slider$3$1 r2 = new androidx.compose.material.SliderKt$Slider$3$1
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r3 = r0.$valueRange
            r2.<init>(r3, r1, r15)
            r1 = r2
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r2 = r0.$valueRange
            float r4 = r0.$value
            int r3 = r0.$$dirty
            int r5 = r3 >> 9
            r5 = r5 & 112(0x70, float:1.57E-43)
            r5 = r5 | 384(0x180, float:5.38E-43)
            int r3 = r3 << 9
            r3 = r3 & 7168(0x1c00, float:1.0045E-41)
            r9 = r5 | r3
            r3 = r18
            r5 = r22
            r14 = r6
            r6 = r9
            androidx.compose.material.SliderKt.CorrectValueSideEffect(r1, r2, r3, r4, r5, r6)
            androidx.compose.material.SliderKt$Slider$3$gestureEndAction$1 r1 = new androidx.compose.material.SliderKt$Slider$3$gestureEndAction$1
            java.util.List<java.lang.Float> r11 = r0.$tickFractions
            kotlin.jvm.functions.Function0<kotlin.Unit> r2 = r0.$onValueChangeFinished
            r12 = 0
            r9 = r1
            r10 = r18
            r13 = r15
            r3 = r14
            r14 = r16
            r5 = r15
            r15 = r19
            r16 = r2
            r9.<init>(r10, r11, r12, r13, r14, r15, r16)
            androidx.compose.runtime.State r1 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r1, r8, r7)
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            r9 = r2
            androidx.compose.ui.Modifier r9 = (androidx.compose.ui.Modifier) r9
            r2 = r19
            androidx.compose.foundation.gestures.DraggableState r2 = (androidx.compose.foundation.gestures.DraggableState) r2
            androidx.compose.foundation.interaction.MutableInteractionSource r11 = r0.$interactionSource
            r14 = r18
            androidx.compose.runtime.State r14 = (androidx.compose.runtime.State) r14
            boolean r4 = r0.$enabled
            r10 = r2
            r12 = r5
            r13 = r17
            r15 = r1
            r16 = r4
            androidx.compose.ui.Modifier r4 = androidx.compose.material.SliderKt.sliderPressModifier(r9, r10, r11, r12, r13, r14, r15, r16)
            androidx.compose.ui.Modifier$Companion r6 = androidx.compose.ui.Modifier.Companion
            androidx.compose.foundation.gestures.Orientation r11 = androidx.compose.foundation.gestures.Orientation.Horizontal
            boolean r14 = r19.isDragging()
            r9 = r6
            androidx.compose.ui.Modifier r9 = (androidx.compose.ui.Modifier) r9
            boolean r12 = r0.$enabled
            androidx.compose.foundation.interaction.MutableInteractionSource r13 = r0.$interactionSource
            r15 = 0
            r6 = -3686930(0xffffffffffc7bdee, float:NaN)
            r8.startReplaceableGroup(r6)
            java.lang.String r6 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r6)
            boolean r6 = r8.changed((java.lang.Object) r1)
            java.lang.Object r7 = r22.rememberedValue()
            if (r6 != 0) goto L_0x01a6
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r7 != r6) goto L_0x01b1
        L_0x01a6:
            androidx.compose.material.SliderKt$Slider$3$drag$1$1 r6 = new androidx.compose.material.SliderKt$Slider$3$drag$1$1
            r6.<init>(r1, r3)
            r7 = r6
            kotlin.jvm.functions.Function3 r7 = (kotlin.jvm.functions.Function3) r7
            r8.updateRememberedValue(r7)
        L_0x01b1:
            r22.endReplaceableGroup()
            r16 = r7
            kotlin.jvm.functions.Function3 r16 = (kotlin.jvm.functions.Function3) r16
            r18 = 32
            r19 = 0
            r10 = r2
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.gestures.DraggableKt.draggable$default(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            float r2 = r0.$value
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r3 = r0.$valueRange
            java.lang.Comparable r3 = r3.getStart()
            java.lang.Number r3 = (java.lang.Number) r3
            float r3 = r3.floatValue()
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r6 = r0.$valueRange
            java.lang.Comparable r6 = r6.getEndInclusive()
            java.lang.Number r6 = (java.lang.Number) r6
            float r6 = r6.floatValue()
            float r2 = kotlin.ranges.RangesKt.coerceIn((float) r2, (float) r3, (float) r6)
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r3 = r0.$valueRange
            java.lang.Comparable r3 = r3.getStart()
            java.lang.Number r3 = (java.lang.Number) r3
            float r3 = r3.floatValue()
            kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r6 = r0.$valueRange
            java.lang.Comparable r6 = r6.getEndInclusive()
            java.lang.Number r6 = (java.lang.Number) r6
            float r6 = r6.floatValue()
            float r2 = androidx.compose.material.SliderKt.calcFraction(r3, r6, r2)
            boolean r3 = r0.$enabled
            java.util.List<java.lang.Float> r6 = r0.$tickFractions
            androidx.compose.material.SliderColors r7 = r0.$colors
            androidx.compose.foundation.interaction.MutableInteractionSource r9 = r0.$interactionSource
            androidx.compose.ui.Modifier r10 = r4.then(r1)
            int r1 = r0.$$dirty
            int r4 = r1 >> 9
            r4 = r4 & 14
            r4 = r4 | 512(0x200, float:7.175E-43)
            int r11 = r1 >> 15
            r11 = r11 & 7168(0x1c00, float:1.0045E-41)
            r4 = r4 | r11
            r11 = 458752(0x70000, float:6.42848E-40)
            int r1 = r1 >> 6
            r1 = r1 & r11
            r11 = r4 | r1
            r1 = r3
            r3 = r6
            r4 = r7
            r6 = r9
            r7 = r10
            r8 = r22
            r9 = r11
            androidx.compose.material.SliderKt.SliderImpl(r1, r2, r3, r4, r5, r6, r7, r8, r9)
        L_0x0226:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SliderKt$Slider$3.invoke(androidx.compose.foundation.layout.BoxWithConstraintsScope, androidx.compose.runtime.Composer, int):void");
    }

    /* access modifiers changed from: private */
    public static final float invoke$scaleToUserValue(float f, float f2, ClosedFloatingPointRange<Float> closedFloatingPointRange, float f3) {
        return SliderKt.scale(f, f2, f3, closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue());
    }

    /* access modifiers changed from: private */
    public static final float invoke$scaleToOffset(ClosedFloatingPointRange<Float> closedFloatingPointRange, float f, float f2, float f3) {
        return SliderKt.scale(closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue(), f3, f, f2);
    }
}
