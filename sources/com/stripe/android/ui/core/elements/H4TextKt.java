package com.stripe.android.ui.core.elements;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"H4Text", "", "text", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "payments-ui-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: H4Text.kt */
public final class H4TextKt {
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void H4Text(java.lang.String r26, androidx.compose.ui.Modifier r27, androidx.compose.runtime.Composer r28, int r29, int r30) {
        /*
            r1 = r26
            r0 = r29
            r15 = r30
            java.lang.String r2 = "text"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            r2 = 404455785(0x181b8169, float:2.0098616E-24)
            r3 = r28
            androidx.compose.runtime.Composer r13 = r3.startRestartGroup(r2)
            java.lang.String r2 = "C(H4Text)P(1)"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r2)
            r2 = r15 & 1
            if (r2 == 0) goto L_0x0020
            r2 = r0 | 6
            goto L_0x0030
        L_0x0020:
            r2 = r0 & 14
            if (r2 != 0) goto L_0x002f
            boolean r2 = r13.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x002c
            r2 = 4
            goto L_0x002d
        L_0x002c:
            r2 = 2
        L_0x002d:
            r2 = r2 | r0
            goto L_0x0030
        L_0x002f:
            r2 = r0
        L_0x0030:
            r3 = r15 & 2
            if (r3 == 0) goto L_0x0037
            r2 = r2 | 48
            goto L_0x004a
        L_0x0037:
            r4 = r0 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x004a
            r4 = r27
            boolean r5 = r13.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0046
            r5 = 32
            goto L_0x0048
        L_0x0046:
            r5 = 16
        L_0x0048:
            r2 = r2 | r5
            goto L_0x004c
        L_0x004a:
            r4 = r27
        L_0x004c:
            r20 = r2
            r2 = r20 & 91
            r2 = r2 ^ 18
            if (r2 != 0) goto L_0x0061
            boolean r2 = r13.getSkipping()
            if (r2 != 0) goto L_0x005b
            goto L_0x0061
        L_0x005b:
            r13.skipToGroupEnd()
            r25 = r13
            goto L_0x00b2
        L_0x0061:
            if (r3 == 0) goto L_0x006a
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            r24 = r2
            goto L_0x006c
        L_0x006a:
            r24 = r4
        L_0x006c:
            com.stripe.android.ui.core.PaymentsTheme r2 = com.stripe.android.ui.core.PaymentsTheme.INSTANCE
            r4 = 8
            com.stripe.android.ui.core.PaymentsComposeColors r2 = r2.getColors(r13, r4)
            androidx.compose.material.Colors r2 = r2.getMaterial()
            long r2 = r2.m913getOnSurface0d7_KjU()
            com.stripe.android.ui.core.PaymentsTheme r5 = com.stripe.android.ui.core.PaymentsTheme.INSTANCE
            androidx.compose.material.Typography r4 = r5.getTypography(r13, r4)
            androidx.compose.ui.text.TextStyle r19 = r4.getH4()
            r4 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 0
            r12 = 0
            r16 = 0
            r25 = r13
            r13 = r16
            r16 = 0
            r15 = r16
            r17 = 0
            r18 = 0
            r21 = r20 & 14
            r20 = r20 & 112(0x70, float:1.57E-43)
            r21 = r21 | r20
            r22 = 0
            r23 = 32760(0x7ff8, float:4.5907E-41)
            r0 = r26
            r1 = r24
            r20 = r25
            androidx.compose.material.TextKt.m1189TextfLXpl1I(r0, r1, r2, r4, r6, r7, r8, r9, r11, r12, r13, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            r4 = r24
        L_0x00b2:
            androidx.compose.runtime.ScopeUpdateScope r0 = r25.endRestartGroup()
            if (r0 != 0) goto L_0x00b9
            goto L_0x00c9
        L_0x00b9:
            com.stripe.android.ui.core.elements.H4TextKt$H4Text$1 r1 = new com.stripe.android.ui.core.elements.H4TextKt$H4Text$1
            r2 = r26
            r3 = r29
            r5 = r30
            r1.<init>(r2, r4, r3, r5)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r0.updateScope(r1)
        L_0x00c9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.ui.core.elements.H4TextKt.H4Text(java.lang.String, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }
}
