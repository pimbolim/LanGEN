package com.stripe.android.ui.core.elements;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a[\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0007¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"SimpleDialogElementUI", "", "openDialog", "Landroidx/compose/runtime/MutableState;", "", "titleText", "", "messageText", "confirmText", "dismissText", "onConfirmListener", "Lkotlin/Function0;", "onDismissListener", "(Landroidx/compose/runtime/MutableState;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "payments-ui-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: SimpleDialogElementUI.kt */
public final class SimpleDialogElementUIKt {
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:92:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void SimpleDialogElementUI(androidx.compose.runtime.MutableState<java.lang.Boolean> r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, kotlin.jvm.functions.Function0<kotlin.Unit> r23, kotlin.jvm.functions.Function0<kotlin.Unit> r24, androidx.compose.runtime.Composer r25, int r26, int r27) {
        /*
            r9 = r18
            r10 = r19
            r11 = r20
            r12 = r21
            r13 = r22
            r14 = r26
            java.lang.String r0 = "openDialog"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "titleText"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "messageText"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "confirmText"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "dismissText"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            r0 = 1314555116(0x4e5a84ec, float:9.1653606E8)
            r1 = r25
            androidx.compose.runtime.Composer r15 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(SimpleDialogElementUI)P(5,6,2)"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r0)
            r0 = r27 & 1
            if (r0 == 0) goto L_0x003a
            r0 = r14 | 6
            goto L_0x004a
        L_0x003a:
            r0 = r14 & 14
            if (r0 != 0) goto L_0x0049
            boolean r0 = r15.changed((java.lang.Object) r9)
            if (r0 == 0) goto L_0x0046
            r0 = 4
            goto L_0x0047
        L_0x0046:
            r0 = 2
        L_0x0047:
            r0 = r0 | r14
            goto L_0x004a
        L_0x0049:
            r0 = r14
        L_0x004a:
            r1 = r27 & 2
            if (r1 == 0) goto L_0x0051
            r0 = r0 | 48
            goto L_0x0061
        L_0x0051:
            r1 = r14 & 112(0x70, float:1.57E-43)
            if (r1 != 0) goto L_0x0061
            boolean r1 = r15.changed((java.lang.Object) r10)
            if (r1 == 0) goto L_0x005e
            r1 = 32
            goto L_0x0060
        L_0x005e:
            r1 = 16
        L_0x0060:
            r0 = r0 | r1
        L_0x0061:
            r1 = r27 & 4
            if (r1 == 0) goto L_0x0068
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0078
        L_0x0068:
            r1 = r14 & 896(0x380, float:1.256E-42)
            if (r1 != 0) goto L_0x0078
            boolean r1 = r15.changed((java.lang.Object) r11)
            if (r1 == 0) goto L_0x0075
            r1 = 256(0x100, float:3.59E-43)
            goto L_0x0077
        L_0x0075:
            r1 = 128(0x80, float:1.794E-43)
        L_0x0077:
            r0 = r0 | r1
        L_0x0078:
            r1 = r27 & 8
            if (r1 == 0) goto L_0x007f
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x008f
        L_0x007f:
            r1 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r1 != 0) goto L_0x008f
            boolean r1 = r15.changed((java.lang.Object) r12)
            if (r1 == 0) goto L_0x008c
            r1 = 2048(0x800, float:2.87E-42)
            goto L_0x008e
        L_0x008c:
            r1 = 1024(0x400, float:1.435E-42)
        L_0x008e:
            r0 = r0 | r1
        L_0x008f:
            r1 = r27 & 16
            if (r1 == 0) goto L_0x0096
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a8
        L_0x0096:
            r1 = 57344(0xe000, float:8.0356E-41)
            r1 = r1 & r14
            if (r1 != 0) goto L_0x00a8
            boolean r1 = r15.changed((java.lang.Object) r13)
            if (r1 == 0) goto L_0x00a5
            r1 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a7
        L_0x00a5:
            r1 = 8192(0x2000, float:1.14794E-41)
        L_0x00a7:
            r0 = r0 | r1
        L_0x00a8:
            r1 = r27 & 32
            if (r1 == 0) goto L_0x00b0
            r2 = 196608(0x30000, float:2.75506E-40)
            r0 = r0 | r2
            goto L_0x00c4
        L_0x00b0:
            r2 = 458752(0x70000, float:6.42848E-40)
            r2 = r2 & r14
            if (r2 != 0) goto L_0x00c4
            r2 = r23
            boolean r3 = r15.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x00c0
            r3 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c2
        L_0x00c0:
            r3 = 65536(0x10000, float:9.18355E-41)
        L_0x00c2:
            r0 = r0 | r3
            goto L_0x00c6
        L_0x00c4:
            r2 = r23
        L_0x00c6:
            r3 = r27 & 64
            if (r3 == 0) goto L_0x00ce
            r4 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r4
            goto L_0x00e2
        L_0x00ce:
            r4 = 3670016(0x380000, float:5.142788E-39)
            r4 = r4 & r14
            if (r4 != 0) goto L_0x00e2
            r4 = r24
            boolean r5 = r15.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x00de
            r5 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e0
        L_0x00de:
            r5 = 524288(0x80000, float:7.34684E-40)
        L_0x00e0:
            r0 = r0 | r5
            goto L_0x00e4
        L_0x00e2:
            r4 = r24
        L_0x00e4:
            r5 = r0
            r0 = 2995931(0x2db6db, float:4.198194E-39)
            r0 = r0 & r5
            r6 = 599186(0x92492, float:8.39638E-40)
            r0 = r0 ^ r6
            if (r0 != 0) goto L_0x00fc
            boolean r0 = r15.getSkipping()
            if (r0 != 0) goto L_0x00f6
            goto L_0x00fc
        L_0x00f6:
            r15.skipToGroupEnd()
            r6 = r2
            r7 = r4
            goto L_0x0149
        L_0x00fc:
            if (r1 == 0) goto L_0x0105
            com.stripe.android.ui.core.elements.SimpleDialogElementUIKt$SimpleDialogElementUI$1 r0 = com.stripe.android.ui.core.elements.SimpleDialogElementUIKt$SimpleDialogElementUI$1.INSTANCE
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            r16 = r0
            goto L_0x0107
        L_0x0105:
            r16 = r2
        L_0x0107:
            if (r3 == 0) goto L_0x0110
            com.stripe.android.ui.core.elements.SimpleDialogElementUIKt$SimpleDialogElementUI$2 r0 = com.stripe.android.ui.core.elements.SimpleDialogElementUIKt$SimpleDialogElementUI$2.INSTANCE
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            r17 = r0
            goto L_0x0112
        L_0x0110:
            r17 = r4
        L_0x0112:
            java.lang.Object r0 = r18.getValue()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0145
            r8 = -819895217(0xffffffffcf21644f, float:-2.7077056E9)
            com.stripe.android.ui.core.elements.SimpleDialogElementUIKt$SimpleDialogElementUI$3 r7 = new com.stripe.android.ui.core.elements.SimpleDialogElementUIKt$SimpleDialogElementUI$3
            r0 = r7
            r1 = r18
            r2 = r5
            r3 = r16
            r4 = r21
            r5 = r17
            r6 = r22
            r9 = r7
            r7 = r19
            r10 = -819895217(0xffffffffcf21644f, float:-2.7077056E9)
            r8 = r20
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r15, r10, r0, r9)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = 6
            com.stripe.android.ui.core.PaymentsThemeKt.PaymentsTheme(r0, r15, r1)
        L_0x0145:
            r6 = r16
            r7 = r17
        L_0x0149:
            androidx.compose.runtime.ScopeUpdateScope r10 = r15.endRestartGroup()
            if (r10 != 0) goto L_0x0150
            goto L_0x0169
        L_0x0150:
            com.stripe.android.ui.core.elements.SimpleDialogElementUIKt$SimpleDialogElementUI$4 r15 = new com.stripe.android.ui.core.elements.SimpleDialogElementUIKt$SimpleDialogElementUI$4
            r0 = r15
            r1 = r18
            r2 = r19
            r3 = r20
            r4 = r21
            r5 = r22
            r8 = r26
            r9 = r27
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r15 = (kotlin.jvm.functions.Function2) r15
            r10.updateScope(r15)
        L_0x0169:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.ui.core.elements.SimpleDialogElementUIKt.SimpleDialogElementUI(androidx.compose.runtime.MutableState, java.lang.String, java.lang.String, java.lang.String, java.lang.String, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }
}
