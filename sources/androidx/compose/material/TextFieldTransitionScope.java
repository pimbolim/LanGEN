package androidx.compose.material;

import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JÊ\u0001\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u000b¢\u0006\u0002\b\f2\u0006\u0010\r\u001a\u00020\u000e2z\u0010\u000f\u001av\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00040\u0010¢\u0006\u0002\b\fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u001b\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, d2 = {"Landroidx/compose/material/TextFieldTransitionScope;", "", "()V", "Transition", "", "inputState", "Landroidx/compose/material/InputPhase;", "focusedTextStyleColor", "Landroidx/compose/ui/graphics/Color;", "unfocusedTextStyleColor", "contentColor", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "showLabel", "", "content", "Lkotlin/Function5;", "", "Lkotlin/ParameterName;", "name", "labelProgress", "labelTextStyleColor", "labelContentColor", "Landroidx/compose/ui/unit/Dp;", "indicatorWidth", "placeholderOpacity", "Transition-DTcfvLk", "(Landroidx/compose/material/InputPhase;JJLkotlin/jvm/functions/Function3;ZLkotlin/jvm/functions/Function7;Landroidx/compose/runtime/Composer;I)V", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextFieldImpl.kt */
final class TextFieldTransitionScope {
    public static final TextFieldTransitionScope INSTANCE = new TextFieldTransitionScope();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TextFieldImpl.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[InputPhase.values().length];
            iArr[InputPhase.Focused.ordinal()] = 1;
            iArr[InputPhase.UnfocusedEmpty.ordinal()] = 2;
            iArr[InputPhase.UnfocusedNotEmpty.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private TextFieldTransitionScope() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v3, resolved type: androidx.compose.animation.core.TwoWayConverter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v5, resolved type: androidx.compose.animation.core.TwoWayConverter} */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x028f, code lost:
        if (r8 != false) goto L_0x0294;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x025f, code lost:
        if (r8 != false) goto L_0x0257;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0282  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x02e6  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x02e9  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0345  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0348  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0368  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x036b  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01a0  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01b6  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01d8  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01ee  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0251  */
    /* renamed from: Transition-DTcfvLk  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m1187TransitionDTcfvLk(androidx.compose.material.InputPhase r26, long r27, long r29, kotlin.jvm.functions.Function3<? super androidx.compose.material.InputPhase, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, androidx.compose.ui.graphics.Color> r31, boolean r32, kotlin.jvm.functions.Function7<? super java.lang.Float, ? super androidx.compose.ui.graphics.Color, ? super androidx.compose.ui.graphics.Color, ? super androidx.compose.ui.unit.Dp, ? super java.lang.Float, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, androidx.compose.runtime.Composer r34, int r35) {
        /*
            r25 = this;
            r2 = r26
            r7 = r31
            r8 = r32
            r5 = r33
            r6 = r35
            java.lang.String r0 = "inputState"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "contentColor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r0 = -1836666808(0xffffffff9286b048, float:-8.500046E-28)
            r1 = r34
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(Transition)P(3,2:c#ui.graphics.Color,5:c#ui.graphics.Color,1,4)288@11890L59,290@11991L325,301@12359L384,312@12790L1101,340@13939L299,350@14284L186,356@14480L168:TextFieldImpl.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            r1 = r6 & 14
            if (r1 != 0) goto L_0x0036
            boolean r1 = r0.changed((java.lang.Object) r2)
            if (r1 == 0) goto L_0x0033
            r1 = 4
            goto L_0x0034
        L_0x0033:
            r1 = 2
        L_0x0034:
            r1 = r1 | r6
            goto L_0x0037
        L_0x0036:
            r1 = r6
        L_0x0037:
            r4 = r6 & 112(0x70, float:1.57E-43)
            r14 = r27
            if (r4 != 0) goto L_0x0049
            boolean r4 = r0.changed((long) r14)
            if (r4 == 0) goto L_0x0046
            r4 = 32
            goto L_0x0048
        L_0x0046:
            r4 = 16
        L_0x0048:
            r1 = r1 | r4
        L_0x0049:
            r4 = r6 & 896(0x380, float:1.256E-42)
            r12 = r29
            if (r4 != 0) goto L_0x005b
            boolean r4 = r0.changed((long) r12)
            if (r4 == 0) goto L_0x0058
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x005a
        L_0x0058:
            r4 = 128(0x80, float:1.794E-43)
        L_0x005a:
            r1 = r1 | r4
        L_0x005b:
            r4 = r6 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x006b
            boolean r4 = r0.changed((java.lang.Object) r7)
            if (r4 == 0) goto L_0x0068
            r4 = 2048(0x800, float:2.87E-42)
            goto L_0x006a
        L_0x0068:
            r4 = 1024(0x400, float:1.435E-42)
        L_0x006a:
            r1 = r1 | r4
        L_0x006b:
            r4 = 57344(0xe000, float:8.0356E-41)
            r9 = r6 & r4
            if (r9 != 0) goto L_0x007e
            boolean r9 = r0.changed((boolean) r8)
            if (r9 == 0) goto L_0x007b
            r9 = 16384(0x4000, float:2.2959E-41)
            goto L_0x007d
        L_0x007b:
            r9 = 8192(0x2000, float:1.14794E-41)
        L_0x007d:
            r1 = r1 | r9
        L_0x007e:
            r17 = 458752(0x70000, float:6.42848E-40)
            r9 = r6 & r17
            if (r9 != 0) goto L_0x0090
            boolean r9 = r0.changed((java.lang.Object) r5)
            if (r9 == 0) goto L_0x008d
            r9 = 131072(0x20000, float:1.83671E-40)
            goto L_0x008f
        L_0x008d:
            r9 = 65536(0x10000, float:9.18355E-41)
        L_0x008f:
            r1 = r1 | r9
        L_0x0090:
            r9 = 374491(0x5b6db, float:5.24774E-40)
            r9 = r9 & r1
            r10 = 74898(0x12492, float:1.04954E-40)
            r9 = r9 ^ r10
            if (r9 != 0) goto L_0x00a6
            boolean r9 = r0.getSkipping()
            if (r9 != 0) goto L_0x00a1
            goto L_0x00a6
        L_0x00a1:
            r0.skipToGroupEnd()
            goto L_0x0493
        L_0x00a6:
            r9 = r1 & 14
            r9 = r9 | 48
            java.lang.String r10 = "TextFieldInputState"
            r11 = 0
            androidx.compose.animation.core.Transition r18 = androidx.compose.animation.core.TransitionKt.updateTransition(r2, (java.lang.String) r10, (androidx.compose.runtime.Composer) r0, (int) r9, (int) r11)
            androidx.compose.material.TextFieldTransitionScope$Transition$labelProgress$2 r9 = androidx.compose.material.TextFieldTransitionScope$Transition$labelProgress$2.INSTANCE
            kotlin.jvm.functions.Function3 r9 = (kotlin.jvm.functions.Function3) r9
            r10 = 1399891485(0x5370a61d, float:1.03357907E12)
            r0.startReplaceableGroup(r10)
            java.lang.String r4 = "C(animateFloat)P(2)925@36712L78:Transition.kt#pdpnli"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r4)
            kotlin.jvm.internal.FloatCompanionObject r16 = kotlin.jvm.internal.FloatCompanionObject.INSTANCE
            androidx.compose.animation.core.TwoWayConverter r16 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((kotlin.jvm.internal.FloatCompanionObject) r16)
            r11 = 1847725064(0x6e220c08, float:1.2537779E28)
            r0.startReplaceableGroup(r11)
            java.lang.String r3 = "C(animateValue)P(3,2)843@33302L32,844@33357L31,845@33413L23,847@33449L89:Transition.kt#pdpnli"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r3)
            java.lang.Object r20 = r18.getCurrentState()
            androidx.compose.material.InputPhase r20 = (androidx.compose.material.InputPhase) r20
            r10 = 337280661(0x141a7e95, float:7.799977E-27)
            r0.startReplaceableGroup(r10)
            java.lang.String r10 = "C:TextFieldImpl.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r10)
            int[] r23 = androidx.compose.material.TextFieldTransitionScope.WhenMappings.$EnumSwitchMapping$0
            int r20 = r20.ordinal()
            r11 = r23[r20]
            r20 = 0
            r23 = 1065353216(0x3f800000, float:1.0)
            r2 = 1
            if (r11 == r2) goto L_0x0100
            r2 = 2
            if (r11 == r2) goto L_0x00fe
            r2 = 3
            if (r11 != r2) goto L_0x00f8
            goto L_0x0100
        L_0x00f8:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x00fe:
            r2 = 0
            goto L_0x0102
        L_0x0100:
            r2 = 1065353216(0x3f800000, float:1.0)
        L_0x0102:
            r0.endReplaceableGroup()
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            java.lang.Object r11 = r18.getTargetState()
            androidx.compose.material.InputPhase r11 = (androidx.compose.material.InputPhase) r11
            r5 = 337280661(0x141a7e95, float:7.799977E-27)
            r0.startReplaceableGroup(r5)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r10)
            int[] r5 = androidx.compose.material.TextFieldTransitionScope.WhenMappings.$EnumSwitchMapping$0
            int r11 = r11.ordinal()
            r5 = r5[r11]
            r11 = 1
            if (r5 == r11) goto L_0x0132
            r11 = 2
            if (r5 == r11) goto L_0x0130
            r11 = 3
            if (r5 != r11) goto L_0x012a
            goto L_0x0132
        L_0x012a:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x0130:
            r5 = 0
            goto L_0x0134
        L_0x0132:
            r5 = 1065353216(0x3f800000, float:1.0)
        L_0x0134:
            r0.endReplaceableGroup()
            java.lang.Float r11 = java.lang.Float.valueOf(r5)
            androidx.compose.animation.core.Transition$Segment r5 = r18.getSegment()
            r19 = 0
            java.lang.Integer r6 = java.lang.Integer.valueOf(r19)
            java.lang.Object r5 = r9.invoke(r5, r0, r6)
            androidx.compose.animation.core.FiniteAnimationSpec r5 = (androidx.compose.animation.core.FiniteAnimationSpec) r5
            r6 = 196608(0x30000, float:2.75506E-40)
            java.lang.String r22 = "LabelProgress"
            r9 = r18
            r24 = r10
            r10 = r2
            r2 = 1847725064(0x6e220c08, float:1.2537779E28)
            r12 = r5
            r13 = r16
            r14 = r22
            r15 = r0
            r16 = r6
            androidx.compose.runtime.State r5 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r9, r10, r11, r12, r13, r14, r15, r16)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            androidx.compose.material.TextFieldTransitionScope$Transition$indicatorWidth$2 r9 = androidx.compose.material.TextFieldTransitionScope$Transition$indicatorWidth$2.INSTANCE
            kotlin.jvm.functions.Function3 r9 = (kotlin.jvm.functions.Function3) r9
            r10 = -307431328(0xffffffffedacf860, float:-6.691461E27)
            r0.startReplaceableGroup(r10)
            java.lang.String r10 = "C(animateDp)P(2)956@38426L75:Transition.kt#pdpnli"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r10)
            androidx.compose.ui.unit.Dp$Companion r10 = androidx.compose.ui.unit.Dp.Companion
            androidx.compose.animation.core.TwoWayConverter r13 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((androidx.compose.ui.unit.Dp.Companion) r10)
            r0.startReplaceableGroup(r2)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r3)
            java.lang.Object r10 = r18.getCurrentState()
            androidx.compose.material.InputPhase r10 = (androidx.compose.material.InputPhase) r10
            r11 = 337281027(0x141a8003, float:7.800259E-27)
            r0.startReplaceableGroup(r11)
            r15 = r24
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r15)
            int[] r12 = androidx.compose.material.TextFieldTransitionScope.WhenMappings.$EnumSwitchMapping$0
            int r10 = r10.ordinal()
            r10 = r12[r10]
            r12 = 1
            if (r10 == r12) goto L_0x01b6
            r12 = 2
            if (r10 == r12) goto L_0x01b1
            r12 = 3
            if (r10 != r12) goto L_0x01ab
            float r10 = androidx.compose.material.TextFieldImplKt.IndicatorUnfocusedWidth
            goto L_0x01ba
        L_0x01ab:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x01b1:
            float r10 = androidx.compose.material.TextFieldImplKt.IndicatorUnfocusedWidth
            goto L_0x01ba
        L_0x01b6:
            float r10 = androidx.compose.material.TextFieldImplKt.IndicatorFocusedWidth
        L_0x01ba:
            r0.endReplaceableGroup()
            androidx.compose.ui.unit.Dp r10 = androidx.compose.ui.unit.Dp.m3857boximpl(r10)
            java.lang.Object r12 = r18.getTargetState()
            androidx.compose.material.InputPhase r12 = (androidx.compose.material.InputPhase) r12
            r0.startReplaceableGroup(r11)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r15)
            int[] r11 = androidx.compose.material.TextFieldTransitionScope.WhenMappings.$EnumSwitchMapping$0
            int r12 = r12.ordinal()
            r11 = r11[r12]
            r12 = 1
            if (r11 == r12) goto L_0x01ee
            r12 = 2
            if (r11 == r12) goto L_0x01e9
            r12 = 3
            if (r11 != r12) goto L_0x01e3
            float r11 = androidx.compose.material.TextFieldImplKt.IndicatorUnfocusedWidth
            goto L_0x01f2
        L_0x01e3:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x01e9:
            float r11 = androidx.compose.material.TextFieldImplKt.IndicatorUnfocusedWidth
            goto L_0x01f2
        L_0x01ee:
            float r11 = androidx.compose.material.TextFieldImplKt.IndicatorFocusedWidth
        L_0x01f2:
            r0.endReplaceableGroup()
            androidx.compose.ui.unit.Dp r11 = androidx.compose.ui.unit.Dp.m3857boximpl(r11)
            androidx.compose.animation.core.Transition$Segment r12 = r18.getSegment()
            r14 = 0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r14)
            java.lang.Object r2 = r9.invoke(r12, r0, r2)
            r12 = r2
            androidx.compose.animation.core.FiniteAnimationSpec r12 = (androidx.compose.animation.core.FiniteAnimationSpec) r12
            java.lang.String r14 = "IndicatorWidth"
            r9 = r18
            r2 = r15
            r15 = r0
            r16 = r6
            androidx.compose.runtime.State r21 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r9, r10, r11, r12, r13, r14, r15, r16)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            androidx.compose.material.TextFieldTransitionScope$Transition$placeholderOpacity$2 r9 = androidx.compose.material.TextFieldTransitionScope$Transition$placeholderOpacity$2.INSTANCE
            kotlin.jvm.functions.Function3 r9 = (kotlin.jvm.functions.Function3) r9
            r10 = 1399891485(0x5370a61d, float:1.03357907E12)
            r0.startReplaceableGroup(r10)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r4)
            kotlin.jvm.internal.FloatCompanionObject r4 = kotlin.jvm.internal.FloatCompanionObject.INSTANCE
            androidx.compose.animation.core.TwoWayConverter r13 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((kotlin.jvm.internal.FloatCompanionObject) r4)
            r4 = 1847725064(0x6e220c08, float:1.2537779E28)
            r0.startReplaceableGroup(r4)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r3)
            java.lang.Object r4 = r18.getCurrentState()
            androidx.compose.material.InputPhase r4 = (androidx.compose.material.InputPhase) r4
            r10 = 337282213(0x141a84a5, float:7.8011726E-27)
            r0.startReplaceableGroup(r10)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r2)
            int[] r11 = androidx.compose.material.TextFieldTransitionScope.WhenMappings.$EnumSwitchMapping$0
            int r4 = r4.ordinal()
            r4 = r11[r4]
            r11 = 1
            if (r4 == r11) goto L_0x0262
            r11 = 2
            if (r4 == r11) goto L_0x025f
            r11 = 3
            if (r4 != r11) goto L_0x0259
        L_0x0257:
            r4 = 0
            goto L_0x0264
        L_0x0259:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x025f:
            if (r8 == 0) goto L_0x0262
            goto L_0x0257
        L_0x0262:
            r4 = 1065353216(0x3f800000, float:1.0)
        L_0x0264:
            r0.endReplaceableGroup()
            java.lang.Float r4 = java.lang.Float.valueOf(r4)
            java.lang.Object r11 = r18.getTargetState()
            androidx.compose.material.InputPhase r11 = (androidx.compose.material.InputPhase) r11
            r0.startReplaceableGroup(r10)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r2)
            int[] r10 = androidx.compose.material.TextFieldTransitionScope.WhenMappings.$EnumSwitchMapping$0
            int r11 = r11.ordinal()
            r10 = r10[r11]
            r11 = 1
            if (r10 == r11) goto L_0x0292
            r11 = 2
            if (r10 == r11) goto L_0x028f
            r11 = 3
            if (r10 != r11) goto L_0x0289
            goto L_0x0294
        L_0x0289:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x028f:
            if (r8 == 0) goto L_0x0292
            goto L_0x0294
        L_0x0292:
            r20 = 1065353216(0x3f800000, float:1.0)
        L_0x0294:
            r0.endReplaceableGroup()
            java.lang.Float r11 = java.lang.Float.valueOf(r20)
            androidx.compose.animation.core.Transition$Segment r10 = r18.getSegment()
            r12 = 0
            java.lang.Integer r14 = java.lang.Integer.valueOf(r12)
            java.lang.Object r9 = r9.invoke(r10, r0, r14)
            r12 = r9
            androidx.compose.animation.core.FiniteAnimationSpec r12 = (androidx.compose.animation.core.FiniteAnimationSpec) r12
            java.lang.String r14 = "PlaceholderOpacity"
            r9 = r18
            r10 = r4
            r15 = r0
            r16 = r6
            androidx.compose.runtime.State r4 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r9, r10, r11, r12, r13, r14, r15, r16)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            androidx.compose.material.TextFieldTransitionScope$Transition$labelTextStyleColor$2 r6 = androidx.compose.material.TextFieldTransitionScope$Transition$labelTextStyleColor$2.INSTANCE
            kotlin.jvm.functions.Function3 r6 = (kotlin.jvm.functions.Function3) r6
            r15 = -1462136984(0xffffffffa8d98f68, float:-2.4154032E-14)
            r0.startReplaceableGroup(r15)
            java.lang.String r9 = "C(animateColor)P(2)68@3224L31,69@3291L70,73@3374L70:Transition.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r9)
            java.lang.Object r9 = r18.getTargetState()
            androidx.compose.material.InputPhase r9 = (androidx.compose.material.InputPhase) r9
            r10 = 337282615(0x141a8637, float:7.801482E-27)
            r0.startReplaceableGroup(r10)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r2)
            int[] r11 = androidx.compose.material.TextFieldTransitionScope.WhenMappings.$EnumSwitchMapping$0
            int r9 = r9.ordinal()
            r9 = r11[r9]
            r11 = 1
            if (r9 != r11) goto L_0x02e9
            r11 = r27
            goto L_0x02eb
        L_0x02e9:
            r11 = r29
        L_0x02eb:
            r0.endReplaceableGroup()
            androidx.compose.ui.graphics.colorspace.ColorSpace r9 = androidx.compose.ui.graphics.Color.m1600getColorSpaceimpl(r11)
            r11 = -3686930(0xffffffffffc7bdee, float:NaN)
            r0.startReplaceableGroup(r11)
            java.lang.String r11 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r11)
            boolean r11 = r0.changed((java.lang.Object) r9)
            java.lang.Object r12 = r0.rememberedValue()
            if (r11 != 0) goto L_0x030f
            androidx.compose.runtime.Composer$Companion r11 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r11 = r11.getEmpty()
            if (r12 != r11) goto L_0x031f
        L_0x030f:
            androidx.compose.ui.graphics.Color$Companion r11 = androidx.compose.ui.graphics.Color.Companion
            kotlin.jvm.functions.Function1 r11 = androidx.compose.animation.ColorVectorConverterKt.getVectorConverter(r11)
            java.lang.Object r9 = r11.invoke(r9)
            r12 = r9
            androidx.compose.animation.core.TwoWayConverter r12 = (androidx.compose.animation.core.TwoWayConverter) r12
            r0.updateRememberedValue(r12)
        L_0x031f:
            r0.endReplaceableGroup()
            r13 = r12
            androidx.compose.animation.core.TwoWayConverter r13 = (androidx.compose.animation.core.TwoWayConverter) r13
            r9 = 1847725064(0x6e220c08, float:1.2537779E28)
            r0.startReplaceableGroup(r9)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r3)
            java.lang.Object r9 = r18.getCurrentState()
            androidx.compose.material.InputPhase r9 = (androidx.compose.material.InputPhase) r9
            r0.startReplaceableGroup(r10)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r2)
            int[] r11 = androidx.compose.material.TextFieldTransitionScope.WhenMappings.$EnumSwitchMapping$0
            int r9 = r9.ordinal()
            r9 = r11[r9]
            r11 = 1
            if (r9 != r11) goto L_0x0348
            r11 = r27
            goto L_0x034a
        L_0x0348:
            r11 = r29
        L_0x034a:
            r0.endReplaceableGroup()
            androidx.compose.ui.graphics.Color r11 = androidx.compose.ui.graphics.Color.m1586boximpl(r11)
            java.lang.Object r9 = r18.getTargetState()
            androidx.compose.material.InputPhase r9 = (androidx.compose.material.InputPhase) r9
            r0.startReplaceableGroup(r10)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r2)
            int[] r2 = androidx.compose.material.TextFieldTransitionScope.WhenMappings.$EnumSwitchMapping$0
            int r9 = r9.ordinal()
            r2 = r2[r9]
            r9 = 1
            if (r2 != r9) goto L_0x036b
            r9 = r27
            goto L_0x036d
        L_0x036b:
            r9 = r29
        L_0x036d:
            r0.endReplaceableGroup()
            androidx.compose.ui.graphics.Color r2 = androidx.compose.ui.graphics.Color.m1586boximpl(r9)
            androidx.compose.animation.core.Transition$Segment r9 = r18.getSegment()
            r10 = 0
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            java.lang.Object r6 = r6.invoke(r9, r0, r10)
            r12 = r6
            androidx.compose.animation.core.FiniteAnimationSpec r12 = (androidx.compose.animation.core.FiniteAnimationSpec) r12
            r16 = 229376(0x38000, float:3.21424E-40)
            java.lang.String r14 = "LabelTextStyleColor"
            r9 = r18
            r10 = r11
            r11 = r2
            r2 = -1462136984(0xffffffffa8d98f68, float:-2.4154032E-14)
            r15 = r0
            androidx.compose.runtime.State r6 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r9, r10, r11, r12, r13, r14, r15, r16)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            androidx.compose.material.TextFieldTransitionScope$Transition$labelContentColor$2 r9 = androidx.compose.material.TextFieldTransitionScope$Transition$labelContentColor$2.INSTANCE
            kotlin.jvm.functions.Function3 r9 = (kotlin.jvm.functions.Function3) r9
            r10 = r1 & 7168(0x1c00, float:1.0045E-41)
            r10 = r10 | 384(0x180, float:5.38E-43)
            r0.startReplaceableGroup(r2)
            java.lang.String r2 = "C(animateColor)P(2)68@3224L31,69@3291L70,73@3374L70:Transition.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r2)
            java.lang.Object r2 = r18.getTargetState()
            int r11 = r10 >> 6
            r11 = r11 & 112(0x70, float:1.57E-43)
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            java.lang.Object r2 = r7.invoke(r2, r0, r11)
            androidx.compose.ui.graphics.Color r2 = (androidx.compose.ui.graphics.Color) r2
            long r11 = r2.m1606unboximpl()
            androidx.compose.ui.graphics.colorspace.ColorSpace r2 = androidx.compose.ui.graphics.Color.m1600getColorSpaceimpl(r11)
            r11 = -3686930(0xffffffffffc7bdee, float:NaN)
            r0.startReplaceableGroup(r11)
            java.lang.String r11 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r11)
            boolean r11 = r0.changed((java.lang.Object) r2)
            java.lang.Object r12 = r0.rememberedValue()
            if (r11 != 0) goto L_0x03e2
            androidx.compose.runtime.Composer$Companion r11 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r11 = r11.getEmpty()
            if (r12 != r11) goto L_0x03f2
        L_0x03e2:
            androidx.compose.ui.graphics.Color$Companion r11 = androidx.compose.ui.graphics.Color.Companion
            kotlin.jvm.functions.Function1 r11 = androidx.compose.animation.ColorVectorConverterKt.getVectorConverter(r11)
            java.lang.Object r2 = r11.invoke(r2)
            r12 = r2
            androidx.compose.animation.core.TwoWayConverter r12 = (androidx.compose.animation.core.TwoWayConverter) r12
            r0.updateRememberedValue(r12)
        L_0x03f2:
            r0.endReplaceableGroup()
            r13 = r12
            androidx.compose.animation.core.TwoWayConverter r13 = (androidx.compose.animation.core.TwoWayConverter) r13
            r2 = r10 & 14
            r2 = r2 | 64
            r11 = 3
            int r10 = r10 << r11
            r11 = r10 & 896(0x380, float:1.256E-42)
            r2 = r2 | r11
            r11 = r10 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | r11
            r11 = 57344(0xe000, float:8.0356E-41)
            r10 = r10 & r11
            r2 = r2 | r10
            r10 = 1847725064(0x6e220c08, float:1.2537779E28)
            r0.startReplaceableGroup(r10)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r3)
            java.lang.Object r3 = r18.getCurrentState()
            int r10 = r2 >> 9
            r10 = r10 & 112(0x70, float:1.57E-43)
            java.lang.Integer r11 = java.lang.Integer.valueOf(r10)
            java.lang.Object r3 = r7.invoke(r3, r0, r11)
            java.lang.Object r11 = r18.getTargetState()
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            java.lang.Object r11 = r7.invoke(r11, r0, r10)
            androidx.compose.animation.core.Transition$Segment r10 = r18.getSegment()
            int r12 = r2 >> 3
            r12 = r12 & 112(0x70, float:1.57E-43)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            java.lang.Object r9 = r9.invoke(r10, r0, r12)
            r12 = r9
            androidx.compose.animation.core.FiniteAnimationSpec r12 = (androidx.compose.animation.core.FiniteAnimationSpec) r12
            r9 = r2 & 14
            int r10 = r2 << 9
            r14 = 57344(0xe000, float:8.0356E-41)
            r10 = r10 & r14
            r9 = r9 | r10
            int r2 = r2 << 6
            r2 = r2 & r17
            r16 = r9 | r2
            java.lang.String r14 = "LabelContentColor"
            r9 = r18
            r10 = r3
            r15 = r0
            androidx.compose.runtime.State r2 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r9, r10, r11, r12, r13, r14, r15, r16)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            float r3 = m1182Transition_DTcfvLk$lambda1(r5)
            java.lang.Float r10 = java.lang.Float.valueOf(r3)
            long r5 = m1185Transition_DTcfvLk$lambda7(r6)
            androidx.compose.ui.graphics.Color r11 = androidx.compose.ui.graphics.Color.m1586boximpl(r5)
            long r2 = m1186Transition_DTcfvLk$lambda8(r2)
            androidx.compose.ui.graphics.Color r12 = androidx.compose.ui.graphics.Color.m1586boximpl(r2)
            float r2 = m1183Transition_DTcfvLk$lambda3(r21)
            androidx.compose.ui.unit.Dp r13 = androidx.compose.ui.unit.Dp.m3857boximpl(r2)
            float r2 = m1184Transition_DTcfvLk$lambda5(r4)
            java.lang.Float r14 = java.lang.Float.valueOf(r2)
            r1 = r1 & r17
            java.lang.Integer r16 = java.lang.Integer.valueOf(r1)
            r9 = r33
            r9.invoke(r10, r11, r12, r13, r14, r15, r16)
        L_0x0493:
            androidx.compose.runtime.ScopeUpdateScope r11 = r0.endRestartGroup()
            if (r11 != 0) goto L_0x049a
            goto L_0x04b5
        L_0x049a:
            androidx.compose.material.TextFieldTransitionScope$Transition$1 r12 = new androidx.compose.material.TextFieldTransitionScope$Transition$1
            r0 = r12
            r1 = r25
            r2 = r26
            r3 = r27
            r5 = r29
            r7 = r31
            r8 = r32
            r9 = r33
            r10 = r35
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10)
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r11.updateScope(r12)
        L_0x04b5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldTransitionScope.m1187TransitionDTcfvLk(androidx.compose.material.InputPhase, long, long, kotlin.jvm.functions.Function3, boolean, kotlin.jvm.functions.Function7, androidx.compose.runtime.Composer, int):void");
    }

    /* renamed from: Transition_DTcfvLk$lambda-1  reason: not valid java name */
    private static final float m1182Transition_DTcfvLk$lambda1(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* renamed from: Transition_DTcfvLk$lambda-3  reason: not valid java name */
    private static final float m1183Transition_DTcfvLk$lambda3(State<Dp> state) {
        return state.getValue().m3873unboximpl();
    }

    /* renamed from: Transition_DTcfvLk$lambda-5  reason: not valid java name */
    private static final float m1184Transition_DTcfvLk$lambda5(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* renamed from: Transition_DTcfvLk$lambda-7  reason: not valid java name */
    private static final long m1185Transition_DTcfvLk$lambda7(State<Color> state) {
        return state.getValue().m1606unboximpl();
    }

    /* renamed from: Transition_DTcfvLk$lambda-8  reason: not valid java name */
    private static final long m1186Transition_DTcfvLk$lambda8(State<Color> state) {
        return state.getValue().m1606unboximpl();
    }
}
