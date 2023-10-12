package com.stripe.android.ui.core.elements.menu;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a?\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Checkbox", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/runtime/Composer;II)V", "payments-ui-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Checkbox.kt */
public final class CheckboxKt {
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Checkbox(boolean r22, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r23, androidx.compose.ui.Modifier r24, boolean r25, androidx.compose.runtime.Composer r26, int r27, int r28) {
        /*
            r5 = r27
            r0 = 413935999(0x18ac297f, float:4.450286E-24)
            r1 = r26
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(Checkbox)P(!1,3,2)"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            r1 = r28 & 1
            if (r1 == 0) goto L_0x001a
            r1 = r5 | 6
            r2 = r1
            r1 = r22
            goto L_0x002e
        L_0x001a:
            r1 = r5 & 14
            if (r1 != 0) goto L_0x002b
            r1 = r22
            boolean r2 = r0.changed((boolean) r1)
            if (r2 == 0) goto L_0x0028
            r2 = 4
            goto L_0x0029
        L_0x0028:
            r2 = 2
        L_0x0029:
            r2 = r2 | r5
            goto L_0x002e
        L_0x002b:
            r1 = r22
            r2 = r5
        L_0x002e:
            r3 = r28 & 2
            if (r3 == 0) goto L_0x0035
            r2 = r2 | 48
            goto L_0x0048
        L_0x0035:
            r3 = r5 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0048
            r3 = r23
            boolean r4 = r0.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0044
            r4 = 32
            goto L_0x0046
        L_0x0044:
            r4 = 16
        L_0x0046:
            r2 = r2 | r4
            goto L_0x004a
        L_0x0048:
            r3 = r23
        L_0x004a:
            r4 = r28 & 4
            if (r4 == 0) goto L_0x0051
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0064
        L_0x0051:
            r6 = r5 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x0064
            r6 = r24
            boolean r7 = r0.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0060
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0062
        L_0x0060:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0062:
            r2 = r2 | r7
            goto L_0x0066
        L_0x0064:
            r6 = r24
        L_0x0066:
            r7 = r28 & 8
            if (r7 == 0) goto L_0x006d
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x0080
        L_0x006d:
            r8 = r5 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x0080
            r8 = r25
            boolean r9 = r0.changed((boolean) r8)
            if (r9 == 0) goto L_0x007c
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x007e
        L_0x007c:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x007e:
            r2 = r2 | r9
            goto L_0x0082
        L_0x0080:
            r8 = r25
        L_0x0082:
            r9 = r2 & 5851(0x16db, float:8.199E-42)
            r9 = r9 ^ 1170(0x492, float:1.64E-42)
            if (r9 != 0) goto L_0x0097
            boolean r9 = r0.getSkipping()
            if (r9 != 0) goto L_0x008f
            goto L_0x0097
        L_0x008f:
            r0.skipToGroupEnd()
            r4 = r6
            r20 = r8
            goto L_0x0103
        L_0x0097:
            if (r4 == 0) goto L_0x009e
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            goto L_0x009f
        L_0x009e:
            r4 = r6
        L_0x009f:
            if (r7 == 0) goto L_0x00a5
            r6 = 1
            r20 = 1
            goto L_0x00a7
        L_0x00a5:
            r20 = r8
        L_0x00a7:
            androidx.compose.material.CheckboxDefaults r6 = androidx.compose.material.CheckboxDefaults.INSTANCE
            com.stripe.android.ui.core.PaymentsTheme r7 = com.stripe.android.ui.core.PaymentsTheme.INSTANCE
            r8 = 8
            com.stripe.android.ui.core.PaymentsComposeColors r7 = r7.getColors(r0, r8)
            androidx.compose.material.Colors r7 = r7.getMaterial()
            long r9 = r7.m914getPrimary0d7_KjU()
            com.stripe.android.ui.core.PaymentsTheme r7 = com.stripe.android.ui.core.PaymentsTheme.INSTANCE
            com.stripe.android.ui.core.PaymentsComposeColors r7 = r7.getColors(r0, r8)
            long r11 = r7.m4507getSubtitle0d7_KjU()
            com.stripe.android.ui.core.PaymentsTheme r7 = com.stripe.android.ui.core.PaymentsTheme.INSTANCE
            com.stripe.android.ui.core.PaymentsComposeColors r7 = r7.getColors(r0, r8)
            androidx.compose.material.Colors r7 = r7.getMaterial()
            long r13 = r7.m918getSurface0d7_KjU()
            r15 = 0
            r17 = 0
            r19 = 262144(0x40000, float:3.67342E-40)
            r21 = 24
            r7 = r9
            r9 = r11
            r11 = r13
            r13 = r15
            r15 = r17
            r17 = r0
            r18 = r19
            r19 = r21
            androidx.compose.material.CheckboxColors r11 = r6.m890colorszjMxDiM(r7, r9, r11, r13, r15, r17, r18, r19)
            r10 = 0
            r6 = r2 & 14
            r7 = r2 & 112(0x70, float:1.57E-43)
            r6 = r6 | r7
            r7 = r2 & 896(0x380, float:1.256E-42)
            r6 = r6 | r7
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r13 = r6 | r2
            r14 = 16
            r6 = r22
            r7 = r23
            r8 = r4
            r9 = r20
            r12 = r0
            androidx.compose.material.CheckboxKt.Checkbox(r6, r7, r8, r9, r10, r11, r12, r13, r14)
        L_0x0103:
            androidx.compose.runtime.ScopeUpdateScope r7 = r0.endRestartGroup()
            if (r7 != 0) goto L_0x010a
            goto L_0x0120
        L_0x010a:
            com.stripe.android.ui.core.elements.menu.CheckboxKt$Checkbox$1 r8 = new com.stripe.android.ui.core.elements.menu.CheckboxKt$Checkbox$1
            r0 = r8
            r1 = r22
            r2 = r23
            r3 = r4
            r4 = r20
            r5 = r27
            r6 = r28
            r0.<init>(r1, r2, r3, r4, r5, r6)
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r7.updateScope(r8)
        L_0x0120:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.ui.core.elements.menu.CheckboxKt.Checkbox(boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, androidx.compose.runtime.Composer, int, int):void");
    }
}
