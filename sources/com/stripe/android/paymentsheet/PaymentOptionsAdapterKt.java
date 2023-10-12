package com.stripe.android.paymentsheet;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u000fH\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0014"}, d2 = {"PaymentOptionUi", "", "viewWidth", "Landroidx/compose/ui/unit/Dp;", "isSelected", "", "isEditing", "isEnabled", "iconRes", "", "labelText", "", "removePmDialogTitle", "description", "onRemoveListener", "Lkotlin/Function0;", "onRemoveAccessibilityDescription", "onItemSelectedListener", "PaymentOptionUi-jFuDa88", "(FZZZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;III)V", "paymentsheet_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentOptionsAdapter.kt */
public final class PaymentOptionsAdapterKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x016d  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x017a  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x02f5  */
    /* JADX WARNING: Removed duplicated region for block: B:158:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0122  */
    /* renamed from: PaymentOptionUi-jFuDa88  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m4405PaymentOptionUijFuDa88(float r31, boolean r32, boolean r33, boolean r34, int r35, java.lang.String r36, java.lang.String r37, java.lang.String r38, kotlin.jvm.functions.Function0<kotlin.Unit> r39, java.lang.String r40, kotlin.jvm.functions.Function0<kotlin.Unit> r41, androidx.compose.runtime.Composer r42, int r43, int r44, int r45) {
        /*
            r1 = r31
            r0 = r34
            r15 = r38
            r14 = r41
            r13 = r43
            r12 = r45
            java.lang.String r2 = "description"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r2)
            java.lang.String r2 = "onItemSelectedListener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r2)
            r2 = 896557684(0x35706274, float:8.9550235E-7)
            r3 = r42
            androidx.compose.runtime.Composer r11 = r3.startRestartGroup(r2)
            r2 = r12 & 1
            if (r2 == 0) goto L_0x0026
            r2 = r13 | 6
            goto L_0x0036
        L_0x0026:
            r2 = r13 & 14
            if (r2 != 0) goto L_0x0035
            boolean r2 = r11.changed((float) r1)
            if (r2 == 0) goto L_0x0032
            r2 = 4
            goto L_0x0033
        L_0x0032:
            r2 = 2
        L_0x0033:
            r2 = r2 | r13
            goto L_0x0036
        L_0x0035:
            r2 = r13
        L_0x0036:
            r4 = r12 & 2
            if (r4 == 0) goto L_0x003f
            r2 = r2 | 48
            r10 = r32
            goto L_0x0051
        L_0x003f:
            r4 = r13 & 112(0x70, float:1.57E-43)
            r10 = r32
            if (r4 != 0) goto L_0x0051
            boolean r4 = r11.changed((boolean) r10)
            if (r4 == 0) goto L_0x004e
            r4 = 32
            goto L_0x0050
        L_0x004e:
            r4 = 16
        L_0x0050:
            r2 = r2 | r4
        L_0x0051:
            r4 = r12 & 4
            if (r4 == 0) goto L_0x005a
            r2 = r2 | 384(0x180, float:5.38E-43)
            r8 = r33
            goto L_0x006c
        L_0x005a:
            r4 = r13 & 896(0x380, float:1.256E-42)
            r8 = r33
            if (r4 != 0) goto L_0x006c
            boolean r4 = r11.changed((boolean) r8)
            if (r4 == 0) goto L_0x0069
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x006b
        L_0x0069:
            r4 = 128(0x80, float:1.794E-43)
        L_0x006b:
            r2 = r2 | r4
        L_0x006c:
            r4 = r12 & 8
            if (r4 == 0) goto L_0x0073
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x0083
        L_0x0073:
            r4 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x0083
            boolean r4 = r11.changed((boolean) r0)
            if (r4 == 0) goto L_0x0080
            r4 = 2048(0x800, float:2.87E-42)
            goto L_0x0082
        L_0x0080:
            r4 = 1024(0x400, float:1.435E-42)
        L_0x0082:
            r2 = r2 | r4
        L_0x0083:
            r4 = r12 & 16
            if (r4 == 0) goto L_0x008c
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            r7 = r35
            goto L_0x00a0
        L_0x008c:
            r4 = 57344(0xe000, float:8.0356E-41)
            r4 = r4 & r13
            r7 = r35
            if (r4 != 0) goto L_0x00a0
            boolean r4 = r11.changed((int) r7)
            if (r4 == 0) goto L_0x009d
            r4 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009f
        L_0x009d:
            r4 = 8192(0x2000, float:1.14794E-41)
        L_0x009f:
            r2 = r2 | r4
        L_0x00a0:
            r4 = r12 & 32
            if (r4 == 0) goto L_0x00a8
            r5 = 196608(0x30000, float:2.75506E-40)
            r2 = r2 | r5
            goto L_0x00bc
        L_0x00a8:
            r5 = 458752(0x70000, float:6.42848E-40)
            r5 = r5 & r13
            if (r5 != 0) goto L_0x00bc
            r5 = r36
            boolean r6 = r11.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x00b8
            r6 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00ba
        L_0x00b8:
            r6 = 65536(0x10000, float:9.18355E-41)
        L_0x00ba:
            r2 = r2 | r6
            goto L_0x00be
        L_0x00bc:
            r5 = r36
        L_0x00be:
            r6 = r12 & 64
            if (r6 == 0) goto L_0x00c9
            r16 = 1572864(0x180000, float:2.204052E-39)
            r2 = r2 | r16
            r3 = r37
            goto L_0x00de
        L_0x00c9:
            r16 = 3670016(0x380000, float:5.142788E-39)
            r16 = r13 & r16
            r3 = r37
            if (r16 != 0) goto L_0x00de
            boolean r16 = r11.changed((java.lang.Object) r3)
            if (r16 == 0) goto L_0x00da
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00dc
        L_0x00da:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00dc:
            r2 = r2 | r16
        L_0x00de:
            r9 = r12 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x00e6
            r9 = 12582912(0xc00000, float:1.7632415E-38)
        L_0x00e4:
            r2 = r2 | r9
            goto L_0x00f7
        L_0x00e6:
            r9 = 29360128(0x1c00000, float:7.052966E-38)
            r9 = r9 & r13
            if (r9 != 0) goto L_0x00f7
            boolean r9 = r11.changed((java.lang.Object) r15)
            if (r9 == 0) goto L_0x00f4
            r9 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00e4
        L_0x00f4:
            r9 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x00e4
        L_0x00f7:
            r9 = r12 & 256(0x100, float:3.59E-43)
            if (r9 == 0) goto L_0x0102
            r17 = 100663296(0x6000000, float:2.4074124E-35)
            r2 = r2 | r17
            r3 = r39
            goto L_0x0117
        L_0x0102:
            r17 = 234881024(0xe000000, float:1.5777218E-30)
            r17 = r13 & r17
            r3 = r39
            if (r17 != 0) goto L_0x0117
            boolean r17 = r11.changed((java.lang.Object) r3)
            if (r17 == 0) goto L_0x0113
            r17 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0115
        L_0x0113:
            r17 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0115:
            r2 = r2 | r17
        L_0x0117:
            r3 = r12 & 512(0x200, float:7.175E-43)
            if (r3 == 0) goto L_0x0122
            r17 = 805306368(0x30000000, float:4.656613E-10)
            r2 = r2 | r17
            r5 = r40
            goto L_0x0137
        L_0x0122:
            r17 = 1879048192(0x70000000, float:1.58456325E29)
            r17 = r13 & r17
            r5 = r40
            if (r17 != 0) goto L_0x0137
            boolean r17 = r11.changed((java.lang.Object) r5)
            if (r17 == 0) goto L_0x0133
            r17 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0135
        L_0x0133:
            r17 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0135:
            r2 = r2 | r17
        L_0x0137:
            r17 = r2
            r2 = r12 & 1024(0x400, float:1.435E-42)
            if (r2 == 0) goto L_0x0140
            r2 = r44 | 6
            goto L_0x0152
        L_0x0140:
            r2 = r44 & 14
            if (r2 != 0) goto L_0x0150
            boolean r2 = r11.changed((java.lang.Object) r14)
            if (r2 == 0) goto L_0x014c
            r2 = 4
            goto L_0x014d
        L_0x014c:
            r2 = 2
        L_0x014d:
            r2 = r44 | r2
            goto L_0x0152
        L_0x0150:
            r2 = r44
        L_0x0152:
            r18 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r18 = r17 & r18
            r19 = 306783378(0x12492492, float:6.3469493E-28)
            r18 = r18 ^ r19
            if (r18 != 0) goto L_0x017a
            r2 = r2 & 11
            r16 = 2
            r2 = r2 ^ 2
            if (r2 != 0) goto L_0x017a
            boolean r2 = r11.getSkipping()
            if (r2 != 0) goto L_0x016d
            goto L_0x017a
        L_0x016d:
            r11.skipToGroupEnd()
            r6 = r36
            r7 = r37
            r9 = r39
            r10 = r5
            r2 = r11
            goto L_0x02ee
        L_0x017a:
            java.lang.String r2 = ""
            if (r4 == 0) goto L_0x0181
            r18 = r2
            goto L_0x0183
        L_0x0181:
            r18 = r36
        L_0x0183:
            if (r6 == 0) goto L_0x0188
            r19 = r2
            goto L_0x018a
        L_0x0188:
            r19 = r37
        L_0x018a:
            r6 = 0
            if (r9 == 0) goto L_0x0190
            r20 = r6
            goto L_0x0192
        L_0x0190:
            r20 = r39
        L_0x0192:
            if (r3 == 0) goto L_0x0197
            r21 = r2
            goto L_0x0199
        L_0x0197:
            r21 = r5
        L_0x0199:
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            r22 = r2
            androidx.compose.ui.Modifier r22 = (androidx.compose.ui.Modifier) r22
            r23 = 0
            r2 = 12
            float r2 = (float) r2
            float r24 = androidx.compose.ui.unit.Dp.m3859constructorimpl(r2)
            r25 = 0
            r26 = 0
            r27 = 13
            r28 = 0
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.PaddingKt.m435paddingqDBjuR0$default(r22, r23, r24, r25, r26, r27, r28)
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m497width3ABfNKs(r2, r1)
            if (r0 == 0) goto L_0x01bd
            r3 = 1065353216(0x3f800000, float:1.0)
            goto L_0x01c0
        L_0x01bd:
            r3 = 1058642330(0x3f19999a, float:0.6)
        L_0x01c0:
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.draw.AlphaKt.alpha(r2, r3)
            r5 = 0
            r3 = -3686930(0xffffffffffc7bdee, float:NaN)
            r11.startReplaceableGroup(r3)
            java.lang.String r3 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r3)
            boolean r3 = r11.changed((java.lang.Object) r14)
            java.lang.Object r4 = r11.rememberedValue()
            if (r3 != 0) goto L_0x01e2
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r4 != r3) goto L_0x01ed
        L_0x01e2:
            com.stripe.android.paymentsheet.PaymentOptionsAdapterKt$PaymentOptionUi$1$1 r3 = new com.stripe.android.paymentsheet.PaymentOptionsAdapterKt$PaymentOptionUi$1$1
            r3.<init>(r14)
            r4 = r3
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            r11.updateRememberedValue(r4)
        L_0x01ed:
            r11.endReplaceableGroup()
            r9 = r4
            kotlin.jvm.functions.Function0 r9 = (kotlin.jvm.functions.Function0) r9
            r22 = 4
            r23 = 0
            r3 = r32
            r4 = r34
            r6 = r9
            r7 = r22
            r8 = r23
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.selection.SelectableKt.m579selectableXHw0xAI$default(r2, r3, r4, r5, r6, r7, r8)
            r3 = -270267499(0xffffffffefe40b95, float:-1.4115317E29)
            r11.startReplaceableGroup(r3)
            java.lang.String r3 = "C(ConstraintLayout)P(1,2)"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r3)
            r3 = 257(0x101, float:3.6E-43)
            r4 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r11.startReplaceableGroup(r4)
            java.lang.String r5 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r5)
            java.lang.Object r6 = r11.rememberedValue()
            androidx.compose.runtime.Composer$Companion r7 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r7.getEmpty()
            if (r6 != r7) goto L_0x0230
            androidx.constraintlayout.compose.Measurer r6 = new androidx.constraintlayout.compose.Measurer
            r6.<init>()
            r11.updateRememberedValue(r6)
        L_0x0230:
            r11.endReplaceableGroup()
            r9 = r6
            androidx.constraintlayout.compose.Measurer r9 = (androidx.constraintlayout.compose.Measurer) r9
            r11.startReplaceableGroup(r4)
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r5)
            java.lang.Object r6 = r11.rememberedValue()
            androidx.compose.runtime.Composer$Companion r7 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r7.getEmpty()
            if (r6 != r7) goto L_0x0250
            androidx.constraintlayout.compose.ConstraintLayoutScope r6 = new androidx.constraintlayout.compose.ConstraintLayoutScope
            r6.<init>()
            r11.updateRememberedValue(r6)
        L_0x0250:
            r11.endReplaceableGroup()
            r22 = r6
            androidx.constraintlayout.compose.ConstraintLayoutScope r22 = (androidx.constraintlayout.compose.ConstraintLayoutScope) r22
            r11.startReplaceableGroup(r4)
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r5)
            java.lang.Object r4 = r11.rememberedValue()
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            r8 = 0
            if (r4 != r5) goto L_0x0278
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r8)
            r5 = 2
            r7 = 0
            androidx.compose.runtime.MutableState r4 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r4, r7, r5, r7)
            r11.updateRememberedValue(r4)
            goto L_0x0279
        L_0x0278:
            r7 = 0
        L_0x0279:
            r11.endReplaceableGroup()
            r5 = r4
            androidx.compose.runtime.MutableState r5 = (androidx.compose.runtime.MutableState) r5
            r16 = 4544(0x11c0, float:6.368E-42)
            r4 = r22
            r6 = r9
            r7 = r11
            r0 = 0
            r8 = r16
            kotlin.Pair r3 = androidx.constraintlayout.compose.ConstraintLayoutKt.rememberConstraintLayoutMeasurePolicy((int) r3, (androidx.constraintlayout.compose.ConstraintLayoutScope) r4, (androidx.compose.runtime.MutableState<java.lang.Boolean>) r5, (androidx.constraintlayout.compose.Measurer) r6, (androidx.compose.runtime.Composer) r7, (int) r8)
            java.lang.Object r4 = r3.component1()
            r16 = r4
            androidx.compose.ui.layout.MeasurePolicy r16 = (androidx.compose.ui.layout.MeasurePolicy) r16
            java.lang.Object r3 = r3.component2()
            r5 = r3
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            com.stripe.android.paymentsheet.PaymentOptionsAdapterKt$PaymentOptionUi-jFuDa88$$inlined$ConstraintLayout$1 r3 = new com.stripe.android.paymentsheet.PaymentOptionsAdapterKt$PaymentOptionUi-jFuDa88$$inlined$ConstraintLayout$1
            r3.<init>(r9)
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r9 = 1
            r4 = 0
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r2, r0, r3, r9, r4)
            r8 = -819893854(0xffffffffcf2169a2, float:-2.70805453E9)
            com.stripe.android.paymentsheet.PaymentOptionsAdapterKt$PaymentOptionUi-jFuDa88$$inlined$ConstraintLayout$2 r7 = new com.stripe.android.paymentsheet.PaymentOptionsAdapterKt$PaymentOptionUi-jFuDa88$$inlined$ConstraintLayout$2
            r4 = 0
            r2 = r7
            r3 = r22
            r6 = r32
            r29 = r7
            r7 = r17
            r8 = r33
            r9 = r20
            r10 = r19
            r30 = r11
            r11 = r38
            r12 = r21
            r13 = r18
            r14 = r34
            r15 = r35
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r4 = r29
            r2 = r30
            r3 = -819893854(0xffffffffcf2169a2, float:-2.70805453E9)
            r5 = 1
            androidx.compose.runtime.internal.ComposableLambda r3 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r2, r3, r5, r4)
            r4 = r3
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r7 = 48
            r8 = 0
            r3 = r0
            r5 = r16
            r6 = r2
            androidx.compose.ui.layout.LayoutKt.MultiMeasureLayout(r3, r4, r5, r6, r7, r8)
            r2.endReplaceableGroup()
            r6 = r18
            r7 = r19
            r10 = r21
        L_0x02ee:
            androidx.compose.runtime.ScopeUpdateScope r15 = r2.endRestartGroup()
            if (r15 != 0) goto L_0x02f5
            goto L_0x0317
        L_0x02f5:
            com.stripe.android.paymentsheet.PaymentOptionsAdapterKt$PaymentOptionUi$3 r16 = new com.stripe.android.paymentsheet.PaymentOptionsAdapterKt$PaymentOptionUi$3
            r0 = r16
            r1 = r31
            r2 = r32
            r3 = r33
            r4 = r34
            r5 = r35
            r8 = r38
            r11 = r41
            r12 = r43
            r13 = r44
            r14 = r45
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r15.updateScope(r0)
        L_0x0317:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.paymentsheet.PaymentOptionsAdapterKt.m4405PaymentOptionUijFuDa88(float, boolean, boolean, boolean, int, java.lang.String, java.lang.String, java.lang.String, kotlin.jvm.functions.Function0, java.lang.String, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int, int):void");
    }
}
