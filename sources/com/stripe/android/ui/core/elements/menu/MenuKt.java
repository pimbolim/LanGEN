package com.stripe.android.ui.core.elements.menu;

import androidx.compose.runtime.State;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000j\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aW\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\u0017\u0010\u001e\u001a\u0013\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00140\u001f¢\u0006\u0002\b!H\u0001ø\u0001\u0000¢\u0006\u0002\u0010\"\u001aa\u0010#\u001a\u00020\u00142\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00140%2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010&\u001a\u00020\u00172\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*2\u001c\u0010\u001e\u001a\u0018\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u00140\u001f¢\u0006\u0002\b,¢\u0006\u0002\b!H\u0001¢\u0006\u0002\u0010-\u001a \u0010.\u001a\u00020\u001a2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000200H\u0000ø\u0001\u0000¢\u0006\u0002\u00102\"\u0019\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\"\u0019\u0010\u0005\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0006\u0010\u0003\"\u0019\u0010\u0007\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\b\u0010\u0003\"\u0019\u0010\t\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\n\u0010\u0003\"\u0019\u0010\u000b\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\f\u0010\u0003\"\u000e\u0010\r\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000\"\u0013\u0010\u000f\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0019\u0010\u0010\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0011\u0010\u0003\"\u000e\u0010\u0012\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u00063"}, d2 = {"DropdownMenuItemDefaultMaxWidth", "Landroidx/compose/ui/unit/Dp;", "getDropdownMenuItemDefaultMaxWidth", "()F", "F", "DropdownMenuItemDefaultMinHeight", "getDropdownMenuItemDefaultMinHeight", "DropdownMenuItemDefaultMinWidth", "getDropdownMenuItemDefaultMinWidth", "DropdownMenuItemHorizontalPadding", "getDropdownMenuItemHorizontalPadding", "DropdownMenuVerticalPadding", "getDropdownMenuVerticalPadding", "InTransitionDuration", "", "MenuElevation", "MenuVerticalMargin", "getMenuVerticalMargin", "OutTransitionDuration", "DropdownMenuContent", "", "expandedStates", "Landroidx/compose/animation/core/MutableTransitionState;", "", "transformOriginState", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/graphics/TransformOrigin;", "initialFirstVisibleItemIndex", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/LazyListScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/runtime/MutableState;ILandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "DropdownMenuItemContent", "onClick", "Lkotlin/Function0;", "enabled", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "calculateTransformOrigin", "parentBounds", "Landroidx/compose/ui/unit/IntRect;", "menuBounds", "(Landroidx/compose/ui/unit/IntRect;Landroidx/compose/ui/unit/IntRect;)J", "payments-ui-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Menu.kt */
public final class MenuKt {
    private static final float DropdownMenuItemDefaultMaxWidth = Dp.m3859constructorimpl((float) 280);
    private static final float DropdownMenuItemDefaultMinHeight;
    private static final float DropdownMenuItemDefaultMinWidth = Dp.m3859constructorimpl((float) 112);
    private static final float DropdownMenuItemHorizontalPadding = Dp.m3859constructorimpl((float) 16);
    private static final float DropdownMenuVerticalPadding;
    public static final int InTransitionDuration = 120;
    private static final float MenuElevation;
    private static final float MenuVerticalMargin;
    public static final int OutTransitionDuration = 75;

    /* JADX WARNING: Removed duplicated region for block: B:44:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0245  */
    /* JADX WARNING: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void DropdownMenuContent(androidx.compose.animation.core.MutableTransitionState<java.lang.Boolean> r21, androidx.compose.runtime.MutableState<androidx.compose.ui.graphics.TransformOrigin> r22, int r23, androidx.compose.ui.Modifier r24, kotlin.jvm.functions.Function1<? super androidx.compose.foundation.lazy.LazyListScope, kotlin.Unit> r25, androidx.compose.runtime.Composer r26, int r27, int r28) {
        /*
            r1 = r21
            r2 = r22
            r3 = r23
            r5 = r25
            r6 = r27
            java.lang.String r0 = "expandedStates"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "transformOriginState"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r0 = 538691465(0x201bc789, float:1.3195031E-19)
            r4 = r26
            androidx.compose.runtime.Composer r0 = r4.startRestartGroup(r0)
            r4 = r28 & 1
            if (r4 == 0) goto L_0x0029
            r4 = r6 | 6
            goto L_0x0039
        L_0x0029:
            r4 = r6 & 14
            if (r4 != 0) goto L_0x0038
            boolean r4 = r0.changed((java.lang.Object) r1)
            if (r4 == 0) goto L_0x0035
            r4 = 4
            goto L_0x0036
        L_0x0035:
            r4 = 2
        L_0x0036:
            r4 = r4 | r6
            goto L_0x0039
        L_0x0038:
            r4 = r6
        L_0x0039:
            r7 = r28 & 2
            if (r7 == 0) goto L_0x0040
            r4 = r4 | 48
            goto L_0x0050
        L_0x0040:
            r7 = r6 & 112(0x70, float:1.57E-43)
            if (r7 != 0) goto L_0x0050
            boolean r7 = r0.changed((java.lang.Object) r2)
            if (r7 == 0) goto L_0x004d
            r7 = 32
            goto L_0x004f
        L_0x004d:
            r7 = 16
        L_0x004f:
            r4 = r4 | r7
        L_0x0050:
            r7 = r28 & 4
            if (r7 == 0) goto L_0x0057
            r4 = r4 | 384(0x180, float:5.38E-43)
            goto L_0x0067
        L_0x0057:
            r7 = r6 & 896(0x380, float:1.256E-42)
            if (r7 != 0) goto L_0x0067
            boolean r7 = r0.changed((int) r3)
            if (r7 == 0) goto L_0x0064
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0066
        L_0x0064:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0066:
            r4 = r4 | r7
        L_0x0067:
            r7 = r28 & 8
            if (r7 == 0) goto L_0x006e
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x0081
        L_0x006e:
            r8 = r6 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x0081
            r8 = r24
            boolean r9 = r0.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x007d
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x007f
        L_0x007d:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x007f:
            r4 = r4 | r9
            goto L_0x0083
        L_0x0081:
            r8 = r24
        L_0x0083:
            r9 = r28 & 16
            if (r9 == 0) goto L_0x008a
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009c
        L_0x008a:
            r9 = 57344(0xe000, float:8.0356E-41)
            r9 = r9 & r6
            if (r9 != 0) goto L_0x009c
            boolean r9 = r0.changed((java.lang.Object) r5)
            if (r9 == 0) goto L_0x0099
            r9 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009b
        L_0x0099:
            r9 = 8192(0x2000, float:1.14794E-41)
        L_0x009b:
            r4 = r4 | r9
        L_0x009c:
            r9 = 46811(0xb6db, float:6.5596E-41)
            r9 = r9 & r4
            r9 = r9 ^ 9362(0x2492, float:1.3119E-41)
            if (r9 != 0) goto L_0x00b1
            boolean r9 = r0.getSkipping()
            if (r9 != 0) goto L_0x00ab
            goto L_0x00b1
        L_0x00ab:
            r0.skipToGroupEnd()
            r4 = r8
            goto L_0x023e
        L_0x00b1:
            if (r7 == 0) goto L_0x00b9
            androidx.compose.ui.Modifier$Companion r7 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r7 = (androidx.compose.ui.Modifier) r7
            r15 = r7
            goto L_0x00ba
        L_0x00b9:
            r15 = r8
        L_0x00ba:
            int r7 = androidx.compose.animation.core.MutableTransitionState.$stable
            r7 = r7 | 48
            r8 = r4 & 14
            r7 = r7 | r8
            java.lang.String r8 = "DropDownMenu"
            r14 = 0
            androidx.compose.animation.core.Transition r16 = androidx.compose.animation.core.TransitionKt.updateTransition(r1, (java.lang.String) r8, (androidx.compose.runtime.Composer) r0, (int) r7, (int) r14)
            com.stripe.android.ui.core.elements.menu.MenuKt$DropdownMenuContent$scale$2 r7 = com.stripe.android.ui.core.elements.menu.MenuKt$DropdownMenuContent$scale$2.INSTANCE
            kotlin.jvm.functions.Function3 r7 = (kotlin.jvm.functions.Function3) r7
            r13 = 1399891485(0x5370a61d, float:1.03357907E12)
            r0.startReplaceableGroup(r13)
            java.lang.String r12 = "C(animateFloat)P(2)925@36712L78:Transition.kt#pdpnli"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r12)
            kotlin.jvm.internal.FloatCompanionObject r8 = kotlin.jvm.internal.FloatCompanionObject.INSTANCE
            androidx.compose.animation.core.TwoWayConverter r11 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((kotlin.jvm.internal.FloatCompanionObject) r8)
            r10 = 1847725064(0x6e220c08, float:1.2537779E28)
            r0.startReplaceableGroup(r10)
            java.lang.String r9 = "C(animateValue)P(3,2)843@33302L32,844@33357L31,845@33413L23,847@33449L89:Transition.kt#pdpnli"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r9)
            java.lang.Object r8 = r16.getCurrentState()
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            r10 = -8441149(0xffffffffff7f32c3, float:-3.392167E38)
            r0.startReplaceableGroup(r10)
            r17 = 1061997773(0x3f4ccccd, float:0.8)
            r18 = 1065353216(0x3f800000, float:1.0)
            if (r8 == 0) goto L_0x0102
            r8 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0105
        L_0x0102:
            r8 = 1061997773(0x3f4ccccd, float:0.8)
        L_0x0105:
            r0.endReplaceableGroup()
            java.lang.Float r8 = java.lang.Float.valueOf(r8)
            java.lang.Object r19 = r16.getTargetState()
            java.lang.Boolean r19 = (java.lang.Boolean) r19
            boolean r19 = r19.booleanValue()
            r0.startReplaceableGroup(r10)
            if (r19 == 0) goto L_0x011d
            r17 = 1065353216(0x3f800000, float:1.0)
        L_0x011d:
            r0.endReplaceableGroup()
            java.lang.Float r10 = java.lang.Float.valueOf(r17)
            androidx.compose.animation.core.Transition$Segment r13 = r16.getSegment()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r14)
            java.lang.Object r1 = r7.invoke(r13, r0, r1)
            androidx.compose.animation.core.FiniteAnimationSpec r1 = (androidx.compose.animation.core.FiniteAnimationSpec) r1
            r17 = 196608(0x30000, float:2.75506E-40)
            java.lang.String r13 = "menu-scale"
            r7 = r16
            r20 = r9
            r9 = r10
            r10 = r1
            r1 = r12
            r12 = r13
            r6 = 1399891485(0x5370a61d, float:1.03357907E12)
            r13 = r0
            r19 = 0
            r14 = r17
            androidx.compose.runtime.State r14 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r7, r8, r9, r10, r11, r12, r13, r14)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            com.stripe.android.ui.core.elements.menu.MenuKt$DropdownMenuContent$alpha$2 r7 = com.stripe.android.ui.core.elements.menu.MenuKt$DropdownMenuContent$alpha$2.INSTANCE
            kotlin.jvm.functions.Function3 r7 = (kotlin.jvm.functions.Function3) r7
            r0.startReplaceableGroup(r6)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            kotlin.jvm.internal.FloatCompanionObject r1 = kotlin.jvm.internal.FloatCompanionObject.INSTANCE
            androidx.compose.animation.core.TwoWayConverter r11 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((kotlin.jvm.internal.FloatCompanionObject) r1)
            r1 = 1847725064(0x6e220c08, float:1.2537779E28)
            r0.startReplaceableGroup(r1)
            r1 = r20
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            java.lang.Object r1 = r16.getCurrentState()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            r6 = -8440618(0xffffffffff7f34d6, float:-3.3922748E38)
            r0.startReplaceableGroup(r6)
            r8 = 0
            if (r1 == 0) goto L_0x0181
            r1 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0182
        L_0x0181:
            r1 = 0
        L_0x0182:
            r0.endReplaceableGroup()
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            java.lang.Object r9 = r16.getTargetState()
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            r0.startReplaceableGroup(r6)
            if (r9 == 0) goto L_0x0199
            goto L_0x019b
        L_0x0199:
            r18 = 0
        L_0x019b:
            r0.endReplaceableGroup()
            java.lang.Float r9 = java.lang.Float.valueOf(r18)
            androidx.compose.animation.core.Transition$Segment r6 = r16.getSegment()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r19)
            java.lang.Object r6 = r7.invoke(r6, r0, r8)
            r10 = r6
            androidx.compose.animation.core.FiniteAnimationSpec r10 = (androidx.compose.animation.core.FiniteAnimationSpec) r10
            java.lang.String r12 = "menu-alpha"
            r7 = r16
            r8 = r1
            r13 = r0
            r1 = r14
            r14 = r17
            androidx.compose.runtime.State r6 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r7, r8, r9, r10, r11, r12, r13, r14)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            com.stripe.android.ui.core.PaymentsTheme r7 = com.stripe.android.ui.core.PaymentsTheme.INSTANCE
            r8 = 8
            com.stripe.android.ui.core.PaymentsComposeShapes r7 = r7.getShapes(r0, r8)
            float r7 = r7.m4512getBorderStrokeWidthD9Ej5fM()
            com.stripe.android.ui.core.PaymentsTheme r9 = com.stripe.android.ui.core.PaymentsTheme.INSTANCE
            com.stripe.android.ui.core.PaymentsComposeColors r8 = r9.getColors(r0, r8)
            long r8 = r8.m4501getColorComponentBorder0d7_KjU()
            androidx.compose.foundation.BorderStroke r13 = androidx.compose.foundation.BorderStrokeKt.m176BorderStrokecXLIe8U(r7, r8)
            androidx.compose.ui.Modifier$Companion r7 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r7 = (androidx.compose.ui.Modifier) r7
            r8 = -3686095(0xffffffffffc7c131, float:NaN)
            r0.startReplaceableGroup(r8)
            java.lang.String r8 = "C(remember)P(1,2,3):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r8)
            boolean r8 = r0.changed((java.lang.Object) r1)
            boolean r9 = r0.changed((java.lang.Object) r6)
            r8 = r8 | r9
            boolean r9 = r0.changed((java.lang.Object) r2)
            r8 = r8 | r9
            java.lang.Object r9 = r0.rememberedValue()
            if (r8 != 0) goto L_0x0209
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r9 != r8) goto L_0x0214
        L_0x0209:
            com.stripe.android.ui.core.elements.menu.MenuKt$DropdownMenuContent$1$1 r8 = new com.stripe.android.ui.core.elements.menu.MenuKt$DropdownMenuContent$1$1
            r8.<init>(r2, r1, r6)
            r9 = r8
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            r0.updateRememberedValue(r9)
        L_0x0214:
            r0.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            androidx.compose.ui.Modifier r7 = androidx.compose.ui.graphics.GraphicsLayerModifierKt.graphicsLayer(r7, r9)
            float r14 = MenuElevation
            r8 = 0
            r9 = 0
            r11 = 0
            r1 = -819890731(0xffffffffcf2175d5, float:-2.70885402E9)
            com.stripe.android.ui.core.elements.menu.MenuKt$DropdownMenuContent$2 r6 = new com.stripe.android.ui.core.elements.menu.MenuKt$DropdownMenuContent$2
            r6.<init>(r3, r4, r15, r5)
            r4 = 1
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r1, r4, r6)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r17 = 1769472(0x1b0000, float:2.479558E-39)
            r18 = 14
            r4 = r15
            r15 = r1
            r16 = r0
            androidx.compose.material.CardKt.m889CardFjzlyU(r7, r8, r9, r11, r13, r14, r15, r16, r17, r18)
        L_0x023e:
            androidx.compose.runtime.ScopeUpdateScope r8 = r0.endRestartGroup()
            if (r8 != 0) goto L_0x0245
            goto L_0x025c
        L_0x0245:
            com.stripe.android.ui.core.elements.menu.MenuKt$DropdownMenuContent$3 r9 = new com.stripe.android.ui.core.elements.menu.MenuKt$DropdownMenuContent$3
            r0 = r9
            r1 = r21
            r2 = r22
            r3 = r23
            r5 = r25
            r6 = r27
            r7 = r28
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            r8.updateScope(r9)
        L_0x025c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.ui.core.elements.menu.MenuKt.DropdownMenuContent(androidx.compose.animation.core.MutableTransitionState, androidx.compose.runtime.MutableState, int, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0277  */
    /* JADX WARNING: Removed duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void DropdownMenuItemContent(kotlin.jvm.functions.Function0<kotlin.Unit> r26, androidx.compose.ui.Modifier r27, boolean r28, androidx.compose.foundation.layout.PaddingValues r29, androidx.compose.foundation.interaction.MutableInteractionSource r30, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r31, androidx.compose.runtime.Composer r32, int r33, int r34) {
        /*
            r9 = r26
            r10 = r31
            r11 = r33
            java.lang.String r0 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = -832199380(0xffffffffce65a52c, float:-9.6320179E8)
            r1 = r32
            androidx.compose.runtime.Composer r12 = r1.startRestartGroup(r0)
            r0 = r34 & 1
            if (r0 == 0) goto L_0x0020
            r0 = r11 | 6
            goto L_0x0030
        L_0x0020:
            r0 = r11 & 14
            if (r0 != 0) goto L_0x002f
            boolean r0 = r12.changed((java.lang.Object) r9)
            if (r0 == 0) goto L_0x002c
            r0 = 4
            goto L_0x002d
        L_0x002c:
            r0 = 2
        L_0x002d:
            r0 = r0 | r11
            goto L_0x0030
        L_0x002f:
            r0 = r11
        L_0x0030:
            r1 = r34 & 2
            if (r1 == 0) goto L_0x0037
            r0 = r0 | 48
            goto L_0x004a
        L_0x0037:
            r2 = r11 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x004a
            r2 = r27
            boolean r3 = r12.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x0046
            r3 = 32
            goto L_0x0048
        L_0x0046:
            r3 = 16
        L_0x0048:
            r0 = r0 | r3
            goto L_0x004c
        L_0x004a:
            r2 = r27
        L_0x004c:
            r3 = r34 & 4
            if (r3 == 0) goto L_0x0053
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0066
        L_0x0053:
            r4 = r11 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0066
            r4 = r28
            boolean r5 = r12.changed((boolean) r4)
            if (r5 == 0) goto L_0x0062
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x0064
        L_0x0062:
            r5 = 128(0x80, float:1.794E-43)
        L_0x0064:
            r0 = r0 | r5
            goto L_0x0068
        L_0x0066:
            r4 = r28
        L_0x0068:
            r5 = r34 & 8
            if (r5 == 0) goto L_0x006f
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0082
        L_0x006f:
            r6 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x0082
            r6 = r29
            boolean r7 = r12.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x007e
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x0080
        L_0x007e:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x0080:
            r0 = r0 | r7
            goto L_0x0084
        L_0x0082:
            r6 = r29
        L_0x0084:
            r7 = r34 & 16
            if (r7 == 0) goto L_0x008b
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a0
        L_0x008b:
            r8 = 57344(0xe000, float:8.0356E-41)
            r8 = r8 & r11
            if (r8 != 0) goto L_0x00a0
            r8 = r30
            boolean r13 = r12.changed((java.lang.Object) r8)
            if (r13 == 0) goto L_0x009c
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009e
        L_0x009c:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x009e:
            r0 = r0 | r13
            goto L_0x00a2
        L_0x00a0:
            r8 = r30
        L_0x00a2:
            r13 = r34 & 32
            if (r13 == 0) goto L_0x00aa
            r13 = 196608(0x30000, float:2.75506E-40)
        L_0x00a8:
            r0 = r0 | r13
            goto L_0x00bb
        L_0x00aa:
            r13 = 458752(0x70000, float:6.42848E-40)
            r13 = r13 & r11
            if (r13 != 0) goto L_0x00bb
            boolean r13 = r12.changed((java.lang.Object) r10)
            if (r13 == 0) goto L_0x00b8
            r13 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00a8
        L_0x00b8:
            r13 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00a8
        L_0x00bb:
            r13 = r0
            r0 = 374491(0x5b6db, float:5.24774E-40)
            r0 = r0 & r13
            r14 = 74898(0x12492, float:1.04954E-40)
            r0 = r0 ^ r14
            if (r0 != 0) goto L_0x00d5
            boolean r0 = r12.getSkipping()
            if (r0 != 0) goto L_0x00cd
            goto L_0x00d5
        L_0x00cd:
            r12.skipToGroupEnd()
            r3 = r4
            r4 = r6
            r5 = r8
            goto L_0x0270
        L_0x00d5:
            if (r1 == 0) goto L_0x00dd
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r14 = r0
            goto L_0x00de
        L_0x00dd:
            r14 = r2
        L_0x00de:
            r15 = 1
            if (r3 == 0) goto L_0x00e4
            r16 = 1
            goto L_0x00e6
        L_0x00e4:
            r16 = r4
        L_0x00e6:
            if (r5 == 0) goto L_0x00ef
            com.stripe.android.ui.core.elements.menu.MenuDefaults r0 = com.stripe.android.ui.core.elements.menu.MenuDefaults.INSTANCE
            androidx.compose.foundation.layout.PaddingValues r0 = r0.getDropdownMenuItemContentPadding()
            goto L_0x00f0
        L_0x00ef:
            r0 = r6
        L_0x00f0:
            if (r7 == 0) goto L_0x0118
            r1 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r12.startReplaceableGroup(r1)
            java.lang.String r1 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            java.lang.Object r1 = r12.rememberedValue()
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r1 != r2) goto L_0x0110
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r12.updateRememberedValue(r1)
        L_0x0110:
            r12.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = (androidx.compose.foundation.interaction.MutableInteractionSource) r1
            r17 = r1
            goto L_0x011a
        L_0x0118:
            r17 = r8
        L_0x011a:
            r1 = 1
            r2 = 0
            r3 = 0
            r6 = 6
            r7 = 6
            r5 = r12
            androidx.compose.foundation.Indication r2 = androidx.compose.material.ripple.RippleKt.m1214rememberRipple9IZ8Weo(r1, r2, r3, r5, r6, r7)
            r4 = 0
            r5 = 0
            r7 = 24
            r8 = 0
            r6 = r0
            r0 = r14
            r1 = r17
            r3 = r16
            r18 = r6
            r6 = r26
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.ClickableKt.m178clickableO2vRcR0$default(r0, r1, r2, r3, r4, r5, r6, r7, r8)
            r1 = 0
            r2 = 0
            androidx.compose.ui.Modifier r19 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r0, r1, r15, r2)
            float r22 = DropdownMenuItemDefaultMaxWidth
            float r21 = DropdownMenuItemDefaultMinHeight
            r23 = 0
            r24 = 8
            r25 = 0
            r20 = r22
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m496sizeInqDBjuR0$default(r19, r20, r21, r22, r23, r24, r25)
            r6 = r18
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.PaddingKt.padding(r0, r6)
            androidx.compose.ui.Alignment$Companion r1 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r1 = r1.getCenterVertically()
            r2 = -1989997165(0xffffffff89630d93, float:-2.7330514E-33)
            r12.startReplaceableGroup(r2)
            java.lang.String r2 = "C(Row)P(2,1,3)77@3834L58,78@3897L130:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r2)
            androidx.compose.foundation.layout.Arrangement r2 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Horizontal r2 = r2.getStart()
            r7 = 48
            androidx.compose.ui.layout.MeasurePolicy r1 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r2, r1, r12, r7)
            r2 = 1376089394(0x52057532, float:1.43299215E11)
            r12.startReplaceableGroup(r2)
            java.lang.String r2 = "C(Layout)P(!1,2)72@2847L7,73@2902L7,74@2961L7,75@2973L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r2)
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r3 = 103361330(0x6292b32, float:3.1817102E-35)
            java.lang.String r4 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r3, r4)
            java.lang.Object r2 = r12.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            androidx.compose.ui.unit.Density r2 = (androidx.compose.ui.unit.Density) r2
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r3, r4)
            java.lang.Object r5 = r12.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            androidx.compose.ui.unit.LayoutDirection r5 = (androidx.compose.ui.unit.LayoutDirection) r5
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r3, r4)
            java.lang.Object r3 = r12.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            androidx.compose.ui.platform.ViewConfiguration r3 = (androidx.compose.ui.platform.ViewConfiguration) r3
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r4 = r4.getConstructor()
            kotlin.jvm.functions.Function3 r0 = androidx.compose.ui.layout.LayoutKt.materializerOf(r0)
            androidx.compose.runtime.Applier r8 = r12.getApplier()
            boolean r8 = r8 instanceof androidx.compose.runtime.Applier
            if (r8 != 0) goto L_0x01cc
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x01cc:
            r12.startReusableNode()
            boolean r8 = r12.getInserting()
            if (r8 == 0) goto L_0x01d9
            r12.createNode(r4)
            goto L_0x01dc
        L_0x01d9:
            r12.useNode()
        L_0x01dc:
            r12.disableReusing()
            androidx.compose.runtime.Composer r4 = androidx.compose.runtime.Updater.m1234constructorimpl(r12)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r4, r1, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetDensity()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r4, r2, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r4, r5, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r4, r3, r1)
            r12.enableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m1226constructorimpl(r12)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m1225boximpl(r1)
            r2 = 0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.invoke(r1, r12, r2)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r12.startReplaceableGroup(r0)
            r0 = -326682362(0xffffffffec873906, float:-1.3077942E27)
            r12.startReplaceableGroup(r0)
            java.lang.String r0 = "C79@3942L9:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r0)
            androidx.compose.foundation.layout.RowScopeInstance r0 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            r3 = r0
            androidx.compose.foundation.layout.RowScope r3 = (androidx.compose.foundation.layout.RowScope) r3
            r4 = 6
            androidx.compose.material.MaterialTheme r0 = androidx.compose.material.MaterialTheme.INSTANCE
            r1 = 8
            androidx.compose.material.Typography r0 = r0.getTypography(r12, r1)
            androidx.compose.ui.text.TextStyle r8 = r0.getSubtitle1()
            r5 = -819888375(0xffffffffcf217f09, float:-2.70945715E9)
            com.stripe.android.ui.core.elements.menu.MenuKt$DropdownMenuItemContent$2$1 r2 = new com.stripe.android.ui.core.elements.menu.MenuKt$DropdownMenuItemContent$2$1
            r0 = r2
            r1 = r16
            r7 = r2
            r2 = r31
            r15 = -819888375(0xffffffffcf217f09, float:-2.70945715E9)
            r5 = r13
            r0.<init>(r1, r2, r3, r4, r5)
            r0 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r12, r15, r0, r7)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = 48
            androidx.compose.material.TextKt.ProvideTextStyle(r8, r0, r12, r1)
            r12.endReplaceableGroup()
            r12.endReplaceableGroup()
            r12.endNode()
            r12.endReplaceableGroup()
            r12.endReplaceableGroup()
            r4 = r6
            r2 = r14
            r3 = r16
            r5 = r17
        L_0x0270:
            androidx.compose.runtime.ScopeUpdateScope r12 = r12.endRestartGroup()
            if (r12 != 0) goto L_0x0277
            goto L_0x028a
        L_0x0277:
            com.stripe.android.ui.core.elements.menu.MenuKt$DropdownMenuItemContent$3 r13 = new com.stripe.android.ui.core.elements.menu.MenuKt$DropdownMenuItemContent$3
            r0 = r13
            r1 = r26
            r6 = r31
            r7 = r33
            r8 = r34
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r12.updateScope(r13)
        L_0x028a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.ui.core.elements.menu.MenuKt.DropdownMenuItemContent(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final float getMenuVerticalMargin() {
        return MenuVerticalMargin;
    }

    public static final float getDropdownMenuItemHorizontalPadding() {
        return DropdownMenuItemHorizontalPadding;
    }

    public static final float getDropdownMenuVerticalPadding() {
        return DropdownMenuVerticalPadding;
    }

    public static final float getDropdownMenuItemDefaultMinWidth() {
        return DropdownMenuItemDefaultMinWidth;
    }

    public static final float getDropdownMenuItemDefaultMaxWidth() {
        return DropdownMenuItemDefaultMaxWidth;
    }

    public static final float getDropdownMenuItemDefaultMinHeight() {
        return DropdownMenuItemDefaultMinHeight;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0060  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long calculateTransformOrigin(androidx.compose.ui.unit.IntRect r5, androidx.compose.ui.unit.IntRect r6) {
        /*
            java.lang.String r0 = "parentBounds"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "menuBounds"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            int r0 = r6.getLeft()
            int r1 = r5.getRight()
            r2 = 1065353216(0x3f800000, float:1.0)
            r3 = 0
            if (r0 < r1) goto L_0x0019
        L_0x0017:
            r0 = 0
            goto L_0x0054
        L_0x0019:
            int r0 = r6.getRight()
            int r1 = r5.getLeft()
            if (r0 > r1) goto L_0x0026
            r0 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0054
        L_0x0026:
            int r0 = r6.getWidth()
            if (r0 != 0) goto L_0x002d
            goto L_0x0017
        L_0x002d:
            int r0 = r5.getLeft()
            int r1 = r6.getLeft()
            int r0 = java.lang.Math.max(r0, r1)
            int r1 = r5.getRight()
            int r4 = r6.getRight()
            int r1 = java.lang.Math.min(r1, r4)
            int r0 = r0 + r1
            int r0 = r0 / 2
            int r1 = r6.getLeft()
            int r0 = r0 - r1
            float r0 = (float) r0
            int r1 = r6.getWidth()
            float r1 = (float) r1
            float r0 = r0 / r1
        L_0x0054:
            int r1 = r6.getTop()
            int r4 = r5.getBottom()
            if (r1 < r4) goto L_0x0060
        L_0x005e:
            r2 = 0
            goto L_0x009a
        L_0x0060:
            int r1 = r6.getBottom()
            int r4 = r5.getTop()
            if (r1 > r4) goto L_0x006b
            goto L_0x009a
        L_0x006b:
            int r1 = r6.getHeight()
            if (r1 != 0) goto L_0x0072
            goto L_0x005e
        L_0x0072:
            int r1 = r5.getTop()
            int r2 = r6.getTop()
            int r1 = java.lang.Math.max(r1, r2)
            int r5 = r5.getBottom()
            int r2 = r6.getBottom()
            int r5 = java.lang.Math.min(r5, r2)
            int r1 = r1 + r5
            int r1 = r1 / 2
            int r5 = r6.getTop()
            int r1 = r1 - r5
            float r5 = (float) r1
            int r6 = r6.getHeight()
            float r6 = (float) r6
            float r2 = r5 / r6
        L_0x009a:
            long r5 = androidx.compose.ui.graphics.TransformOriginKt.TransformOrigin(r0, r2)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.ui.core.elements.menu.MenuKt.calculateTransformOrigin(androidx.compose.ui.unit.IntRect, androidx.compose.ui.unit.IntRect):long");
    }

    /* access modifiers changed from: private */
    /* renamed from: DropdownMenuContent$lambda-1  reason: not valid java name */
    public static final float m4631DropdownMenuContent$lambda1(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: DropdownMenuContent$lambda-3  reason: not valid java name */
    public static final float m4632DropdownMenuContent$lambda3(State<Float> state) {
        return state.getValue().floatValue();
    }

    static {
        float f = (float) 8;
        MenuElevation = Dp.m3859constructorimpl(f);
        float f2 = (float) 48;
        MenuVerticalMargin = Dp.m3859constructorimpl(f2);
        DropdownMenuVerticalPadding = Dp.m3859constructorimpl(f);
        DropdownMenuItemDefaultMinHeight = Dp.m3859constructorimpl(f2);
    }
}
