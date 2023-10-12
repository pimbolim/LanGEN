package defpackage;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aj\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\u0011H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013\u001aa\u0010\u0014\u001a\u00020\u00012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\u001c¢\u0006\u0002\b\u0011H\u0001¢\u0006\u0002\u0010\u001d\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, d2 = {"DropdownMenu", "", "expanded", "", "initialFirstVisibleItemIndex", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "offset", "Landroidx/compose/ui/unit/DpOffset;", "properties", "Landroidx/compose/ui/window/PopupProperties;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/LazyListScope;", "Lkotlin/ExtensionFunctionType;", "DropdownMenu-x0xb5LI", "(ZILkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JLandroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "DropdownMenuItem", "onClick", "enabled", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "payments-ui-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* renamed from: AndroidMenuKt  reason: default package */
/* compiled from: AndroidMenu.kt */
public final class AndroidMenuKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v0, resolved type: kotlin.jvm.functions.Function2} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0257  */
    /* JADX WARNING: Removed duplicated region for block: B:117:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00ee  */
    /* renamed from: DropdownMenu-x0xb5LI  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m0DropdownMenux0xb5LI(boolean r25, int r26, kotlin.jvm.functions.Function0<kotlin.Unit> r27, androidx.compose.ui.Modifier r28, long r29, androidx.compose.ui.window.PopupProperties r31, kotlin.jvm.functions.Function1<? super androidx.compose.foundation.lazy.LazyListScope, kotlin.Unit> r32, androidx.compose.runtime.Composer r33, int r34, int r35) {
        /*
            r7 = r27
            r8 = r32
            r9 = r34
            java.lang.String r0 = "onDismissRequest"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r0 = -2084993782(0xffffffff83b9850a, float:-1.0903867E-36)
            r1 = r33
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            r0 = r35 & 1
            if (r0 == 0) goto L_0x0022
            r0 = r9 | 6
            r11 = r25
            goto L_0x0034
        L_0x0022:
            r0 = r9 & 14
            r11 = r25
            if (r0 != 0) goto L_0x0033
            boolean r0 = r10.changed((boolean) r11)
            if (r0 == 0) goto L_0x0030
            r0 = 4
            goto L_0x0031
        L_0x0030:
            r0 = 2
        L_0x0031:
            r0 = r0 | r9
            goto L_0x0034
        L_0x0033:
            r0 = r9
        L_0x0034:
            r2 = r35 & 2
            if (r2 == 0) goto L_0x003d
            r0 = r0 | 48
            r12 = r26
            goto L_0x004f
        L_0x003d:
            r2 = r9 & 112(0x70, float:1.57E-43)
            r12 = r26
            if (r2 != 0) goto L_0x004f
            boolean r2 = r10.changed((int) r12)
            if (r2 == 0) goto L_0x004c
            r2 = 32
            goto L_0x004e
        L_0x004c:
            r2 = 16
        L_0x004e:
            r0 = r0 | r2
        L_0x004f:
            r2 = r35 & 4
            if (r2 == 0) goto L_0x0056
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0066
        L_0x0056:
            r2 = r9 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x0066
            boolean r2 = r10.changed((java.lang.Object) r7)
            if (r2 == 0) goto L_0x0063
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x0065
        L_0x0063:
            r2 = 128(0x80, float:1.794E-43)
        L_0x0065:
            r0 = r0 | r2
        L_0x0066:
            r2 = r35 & 8
            if (r2 == 0) goto L_0x006d
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0080
        L_0x006d:
            r3 = r9 & 7168(0x1c00, float:1.0045E-41)
            if (r3 != 0) goto L_0x0080
            r3 = r28
            boolean r4 = r10.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x007c
            r4 = 2048(0x800, float:2.87E-42)
            goto L_0x007e
        L_0x007c:
            r4 = 1024(0x400, float:1.435E-42)
        L_0x007e:
            r0 = r0 | r4
            goto L_0x0082
        L_0x0080:
            r3 = r28
        L_0x0082:
            r4 = r35 & 16
            if (r4 == 0) goto L_0x0089
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009e
        L_0x0089:
            r5 = 57344(0xe000, float:8.0356E-41)
            r5 = r5 & r9
            if (r5 != 0) goto L_0x009e
            r5 = r29
            boolean r13 = r10.changed((long) r5)
            if (r13 == 0) goto L_0x009a
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009c
        L_0x009a:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x009c:
            r0 = r0 | r13
            goto L_0x00a0
        L_0x009e:
            r5 = r29
        L_0x00a0:
            r13 = 458752(0x70000, float:6.42848E-40)
            r13 = r13 & r9
            if (r13 != 0) goto L_0x00ba
            r13 = r35 & 32
            if (r13 != 0) goto L_0x00b4
            r13 = r31
            boolean r14 = r10.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x00b6
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b8
        L_0x00b4:
            r13 = r31
        L_0x00b6:
            r14 = 65536(0x10000, float:9.18355E-41)
        L_0x00b8:
            r0 = r0 | r14
            goto L_0x00bc
        L_0x00ba:
            r13 = r31
        L_0x00bc:
            r14 = r35 & 64
            if (r14 == 0) goto L_0x00c4
            r14 = 1572864(0x180000, float:2.204052E-39)
        L_0x00c2:
            r0 = r0 | r14
            goto L_0x00d5
        L_0x00c4:
            r14 = 3670016(0x380000, float:5.142788E-39)
            r14 = r14 & r9
            if (r14 != 0) goto L_0x00d5
            boolean r14 = r10.changed((java.lang.Object) r8)
            if (r14 == 0) goto L_0x00d2
            r14 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00c2
        L_0x00d2:
            r14 = 524288(0x80000, float:7.34684E-40)
            goto L_0x00c2
        L_0x00d5:
            r14 = 2995931(0x2db6db, float:4.198194E-39)
            r14 = r14 & r0
            r15 = 599186(0x92492, float:8.39638E-40)
            r14 = r14 ^ r15
            if (r14 != 0) goto L_0x00ee
            boolean r14 = r10.getSkipping()
            if (r14 != 0) goto L_0x00e6
            goto L_0x00ee
        L_0x00e6:
            r10.skipToGroupEnd()
            r4 = r3
            r22 = r13
            goto L_0x0250
        L_0x00ee:
            r10.startDefaults()
            r14 = r9 & 1
            r15 = -458753(0xfffffffffff8ffff, float:NaN)
            r1 = 0
            if (r14 == 0) goto L_0x0110
            boolean r14 = r10.getDefaultsInvalid()
            if (r14 == 0) goto L_0x0100
            goto L_0x0110
        L_0x0100:
            r10.skipToGroupEnd()
            r2 = r35 & 32
            if (r2 == 0) goto L_0x0108
            r0 = r0 & r15
        L_0x0108:
            r23 = r0
            r20 = r5
            r22 = r13
            r13 = r3
            goto L_0x0153
        L_0x0110:
            if (r2 == 0) goto L_0x0117
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x0118
        L_0x0117:
            r2 = r3
        L_0x0118:
            if (r4 == 0) goto L_0x0128
            float r3 = (float) r1
            float r4 = androidx.compose.ui.unit.Dp.m3859constructorimpl(r3)
            float r3 = androidx.compose.ui.unit.Dp.m3859constructorimpl(r3)
            long r3 = androidx.compose.ui.unit.DpKt.m3880DpOffsetYgX7TsA(r4, r3)
            r5 = r3
        L_0x0128:
            r3 = r35 & 32
            if (r3 == 0) goto L_0x014c
            androidx.compose.ui.window.PopupProperties r3 = new androidx.compose.ui.window.PopupProperties
            r17 = 1
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 62
            r24 = 0
            r16 = r3
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24)
            r0 = r0 & r15
            r23 = r0
            r13 = r2
            r22 = r3
            r20 = r5
            goto L_0x0153
        L_0x014c:
            r23 = r0
            r20 = r5
            r22 = r13
            r13 = r2
        L_0x0153:
            r10.endDefaults()
            r0 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r10.startReplaceableGroup(r0)
            java.lang.String r2 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r2)
            java.lang.Object r3 = r10.rememberedValue()
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r3 != r4) goto L_0x0179
            androidx.compose.animation.core.MutableTransitionState r3 = new androidx.compose.animation.core.MutableTransitionState
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r3.<init>(r1)
            r10.updateRememberedValue(r3)
        L_0x0179:
            r10.endReplaceableGroup()
            r1 = r3
            androidx.compose.animation.core.MutableTransitionState r1 = (androidx.compose.animation.core.MutableTransitionState) r1
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r25)
            r1.setTargetState(r3)
            java.lang.Object r3 = r1.getCurrentState()
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 != 0) goto L_0x019e
            java.lang.Object r3 = r1.getTargetState()
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x024d
        L_0x019e:
            r10.startReplaceableGroup(r0)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r2)
            java.lang.Object r0 = r10.rememberedValue()
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r0 != r2) goto L_0x01c3
            androidx.compose.ui.graphics.TransformOrigin$Companion r0 = androidx.compose.ui.graphics.TransformOrigin.Companion
            long r2 = r0.m1955getCenterSzJe1aQ()
            androidx.compose.ui.graphics.TransformOrigin r0 = androidx.compose.ui.graphics.TransformOrigin.m1942boximpl(r2)
            r2 = 0
            r3 = 2
            androidx.compose.runtime.MutableState r0 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r0, r2, r3, r2)
            r10.updateRememberedValue(r0)
        L_0x01c3:
            r10.endReplaceableGroup()
            r2 = r0
            androidx.compose.runtime.MutableState r2 = (androidx.compose.runtime.MutableState) r2
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r3 = 103361330(0x6292b32, float:3.1817102E-35)
            java.lang.String r4 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r3, r4)
            java.lang.Object r0 = r10.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            r17 = r0
            androidx.compose.ui.unit.Density r17 = (androidx.compose.ui.unit.Density) r17
            r0 = -3686930(0xffffffffffc7bdee, float:NaN)
            r10.startReplaceableGroup(r0)
            java.lang.String r0 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            boolean r0 = r10.changed((java.lang.Object) r2)
            java.lang.Object r3 = r10.rememberedValue()
            if (r0 != 0) goto L_0x01ff
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r3 != r0) goto L_0x020a
        L_0x01ff:
            AndroidMenuKt$DropdownMenu$popupPositionProvider$1$1 r0 = new AndroidMenuKt$DropdownMenu$popupPositionProvider$1$1
            r0.<init>(r2)
            r3 = r0
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r10.updateRememberedValue(r3)
        L_0x020a:
            r10.endReplaceableGroup()
            r18 = r3
            kotlin.jvm.functions.Function2 r18 = (kotlin.jvm.functions.Function2) r18
            r19 = 0
            com.stripe.android.ui.core.elements.menu.DropdownMenuPositionProvider r0 = new com.stripe.android.ui.core.elements.menu.DropdownMenuPositionProvider
            r14 = r0
            r15 = r20
            r14.<init>(r15, r17, r18, r19)
            r14 = r0
            androidx.compose.ui.window.PopupPositionProvider r14 = (androidx.compose.ui.window.PopupPositionProvider) r14
            AndroidMenuKt$DropdownMenu$1 r6 = new AndroidMenuKt$DropdownMenu$1
            r0 = r6
            r3 = r26
            r4 = r13
            r5 = r32
            r15 = r6
            r6 = r23
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r0 = 1
            r1 = -819891507(0xffffffffcf2172cd, float:-2.70865536E9)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r10, r1, r0, r15)
            r3 = r0
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            int r0 = r23 >> 3
            r0 = r0 & 112(0x70, float:1.57E-43)
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            int r1 = r23 >> 9
            r1 = r1 & 896(0x380, float:1.256E-42)
            r5 = r0 | r1
            r6 = 0
            r0 = r14
            r1 = r27
            r2 = r22
            r4 = r10
            androidx.compose.ui.window.AndroidPopup_androidKt.Popup(r0, r1, r2, r3, r4, r5, r6)
        L_0x024d:
            r4 = r13
            r5 = r20
        L_0x0250:
            androidx.compose.runtime.ScopeUpdateScope r13 = r10.endRestartGroup()
            if (r13 != 0) goto L_0x0257
            goto L_0x0270
        L_0x0257:
            AndroidMenuKt$DropdownMenu$2 r14 = new AndroidMenuKt$DropdownMenu$2
            r0 = r14
            r1 = r25
            r2 = r26
            r3 = r27
            r7 = r22
            r8 = r32
            r9 = r34
            r10 = r35
            r0.<init>(r1, r2, r3, r4, r5, r7, r8, r9, r10)
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            r13.updateScope(r14)
        L_0x0270:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.AndroidMenuKt.m0DropdownMenux0xb5LI(boolean, int, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, long, androidx.compose.ui.window.PopupProperties, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:89:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void DropdownMenuItem(kotlin.jvm.functions.Function0<kotlin.Unit> r18, androidx.compose.ui.Modifier r19, boolean r20, androidx.compose.foundation.layout.PaddingValues r21, androidx.compose.foundation.interaction.MutableInteractionSource r22, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r23, androidx.compose.runtime.Composer r24, int r25, int r26) {
        /*
            r9 = r18
            r10 = r23
            r11 = r25
            java.lang.String r0 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = 1905106226(0x718d9d32, float:1.4024776E30)
            r1 = r24
            androidx.compose.runtime.Composer r12 = r1.startRestartGroup(r0)
            r0 = r26 & 1
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
            r1 = r26 & 2
            if (r1 == 0) goto L_0x0037
            r0 = r0 | 48
            goto L_0x004a
        L_0x0037:
            r2 = r11 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x004a
            r2 = r19
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
            r2 = r19
        L_0x004c:
            r3 = r26 & 4
            if (r3 == 0) goto L_0x0053
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0066
        L_0x0053:
            r4 = r11 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0066
            r4 = r20
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
            r4 = r20
        L_0x0068:
            r5 = r26 & 8
            if (r5 == 0) goto L_0x006f
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0082
        L_0x006f:
            r6 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x0082
            r6 = r21
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
            r6 = r21
        L_0x0084:
            r7 = r26 & 16
            r8 = 57344(0xe000, float:8.0356E-41)
            if (r7 == 0) goto L_0x008e
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a1
        L_0x008e:
            r13 = r11 & r8
            if (r13 != 0) goto L_0x00a1
            r13 = r22
            boolean r14 = r12.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x009d
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009f
        L_0x009d:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x009f:
            r0 = r0 | r14
            goto L_0x00a3
        L_0x00a1:
            r13 = r22
        L_0x00a3:
            r14 = r26 & 32
            r15 = 458752(0x70000, float:6.42848E-40)
            if (r14 == 0) goto L_0x00ad
            r14 = 196608(0x30000, float:2.75506E-40)
        L_0x00ab:
            r0 = r0 | r14
            goto L_0x00bd
        L_0x00ad:
            r14 = r11 & r15
            if (r14 != 0) goto L_0x00bd
            boolean r14 = r12.changed((java.lang.Object) r10)
            if (r14 == 0) goto L_0x00ba
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00ab
        L_0x00ba:
            r14 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00ab
        L_0x00bd:
            r14 = 374491(0x5b6db, float:5.24774E-40)
            r14 = r14 & r0
            r16 = 74898(0x12492, float:1.04954E-40)
            r14 = r14 ^ r16
            if (r14 != 0) goto L_0x00d7
            boolean r14 = r12.getSkipping()
            if (r14 != 0) goto L_0x00cf
            goto L_0x00d7
        L_0x00cf:
            r12.skipToGroupEnd()
            r3 = r4
            r4 = r6
            r5 = r13
            goto L_0x0141
        L_0x00d7:
            if (r1 == 0) goto L_0x00df
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r14 = r1
            goto L_0x00e0
        L_0x00df:
            r14 = r2
        L_0x00e0:
            if (r3 == 0) goto L_0x00e6
            r1 = 1
            r16 = 1
            goto L_0x00e8
        L_0x00e6:
            r16 = r4
        L_0x00e8:
            if (r5 == 0) goto L_0x00f3
            com.stripe.android.ui.core.elements.menu.MenuDefaults r1 = com.stripe.android.ui.core.elements.menu.MenuDefaults.INSTANCE
            androidx.compose.foundation.layout.PaddingValues r1 = r1.getDropdownMenuItemContentPadding()
            r17 = r1
            goto L_0x00f5
        L_0x00f3:
            r17 = r6
        L_0x00f5:
            if (r7 == 0) goto L_0x011b
            r1 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r12.startReplaceableGroup(r1)
            java.lang.String r1 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            java.lang.Object r1 = r12.rememberedValue()
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r1 != r2) goto L_0x0115
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r12.updateRememberedValue(r1)
        L_0x0115:
            r12.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = (androidx.compose.foundation.interaction.MutableInteractionSource) r1
            r13 = r1
        L_0x011b:
            r1 = r0 & 14
            r2 = r0 & 112(0x70, float:1.57E-43)
            r1 = r1 | r2
            r2 = r0 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            r2 = r0 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            r2 = r0 & r8
            r1 = r1 | r2
            r0 = r0 & r15
            r7 = r1 | r0
            r8 = 0
            r0 = r18
            r1 = r14
            r2 = r16
            r3 = r17
            r4 = r13
            r5 = r23
            r6 = r12
            com.stripe.android.ui.core.elements.menu.MenuKt.DropdownMenuItemContent(r0, r1, r2, r3, r4, r5, r6, r7, r8)
            r5 = r13
            r2 = r14
            r3 = r16
            r4 = r17
        L_0x0141:
            androidx.compose.runtime.ScopeUpdateScope r12 = r12.endRestartGroup()
            if (r12 != 0) goto L_0x0148
            goto L_0x015b
        L_0x0148:
            AndroidMenuKt$DropdownMenuItem$2 r13 = new AndroidMenuKt$DropdownMenuItem$2
            r0 = r13
            r1 = r18
            r6 = r23
            r7 = r25
            r8 = r26
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r12.updateScope(r13)
        L_0x015b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.AndroidMenuKt.DropdownMenuItem(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }
}
