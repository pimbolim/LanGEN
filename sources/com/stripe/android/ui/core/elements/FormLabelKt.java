package com.stripe.android.ui.core.elements;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"FormLabel", "", "text", "", "enabled", "", "(Ljava/lang/String;ZLandroidx/compose/runtime/Composer;II)V", "payments-ui-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: FormLabel.kt */
public final class FormLabelKt {
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void FormLabel(java.lang.String r28, boolean r29, androidx.compose.runtime.Composer r30, int r31, int r32) {
        /*
            r2 = r28
            r3 = r31
            r0 = r32
            java.lang.String r1 = "text"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)
            r1 = 857923473(0x3322df91, float:3.7921897E-8)
            r4 = r30
            androidx.compose.runtime.Composer r15 = r4.startRestartGroup(r1)
            r1 = r0 & 1
            if (r1 == 0) goto L_0x001b
            r1 = r3 | 6
            goto L_0x002b
        L_0x001b:
            r1 = r3 & 14
            if (r1 != 0) goto L_0x002a
            boolean r1 = r15.changed((java.lang.Object) r2)
            if (r1 == 0) goto L_0x0027
            r1 = 4
            goto L_0x0028
        L_0x0027:
            r1 = 2
        L_0x0028:
            r1 = r1 | r3
            goto L_0x002b
        L_0x002a:
            r1 = r3
        L_0x002b:
            r4 = r0 & 2
            if (r4 == 0) goto L_0x0032
            r1 = r1 | 48
            goto L_0x0045
        L_0x0032:
            r5 = r3 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x0045
            r5 = r29
            boolean r6 = r15.changed((boolean) r5)
            if (r6 == 0) goto L_0x0041
            r6 = 32
            goto L_0x0043
        L_0x0041:
            r6 = 16
        L_0x0043:
            r1 = r1 | r6
            goto L_0x0047
        L_0x0045:
            r5 = r29
        L_0x0047:
            r20 = r1
            r1 = r20 & 91
            r1 = r1 ^ 18
            if (r1 != 0) goto L_0x005c
            boolean r1 = r15.getSkipping()
            if (r1 != 0) goto L_0x0056
            goto L_0x005c
        L_0x0056:
            r15.skipToGroupEnd()
            r27 = r15
            goto L_0x00bf
        L_0x005c:
            if (r4 == 0) goto L_0x0062
            r1 = 1
            r24 = 1
            goto L_0x0064
        L_0x0062:
            r24 = r5
        L_0x0064:
            com.stripe.android.ui.core.PaymentsTheme r1 = com.stripe.android.ui.core.PaymentsTheme.INSTANCE
            r4 = 8
            com.stripe.android.ui.core.PaymentsComposeColors r1 = r1.getColors(r15, r4)
            long r5 = r1.m4506getPlaceholderText0d7_KjU()
            r1 = 857923617(0x3322e021, float:3.792241E-8)
            r15.startReplaceableGroup(r1)
            if (r24 == 0) goto L_0x0079
            goto L_0x0089
        L_0x0079:
            androidx.compose.material.ContentAlpha r1 = androidx.compose.material.ContentAlpha.INSTANCE
            float r7 = r1.getDisabled(r15, r4)
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 14
            r12 = 0
            long r5 = androidx.compose.ui.graphics.Color.m1595copywmQWz5c$default(r5, r7, r8, r9, r10, r11, r12)
        L_0x0089:
            r25 = r5
            r15.endReplaceableGroup()
            com.stripe.android.ui.core.PaymentsTheme r1 = com.stripe.android.ui.core.PaymentsTheme.INSTANCE
            androidx.compose.material.Typography r1 = r1.getTypography(r15, r4)
            androidx.compose.ui.text.TextStyle r19 = r1.getSubtitle1()
            r1 = 0
            r4 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r16 = 0
            r27 = r15
            r15 = r16
            r17 = 0
            r18 = 0
            r21 = r20 & 14
            r22 = 0
            r23 = 32762(0x7ffa, float:4.591E-41)
            r0 = r28
            r2 = r25
            r20 = r27
            androidx.compose.material.TextKt.m1189TextfLXpl1I(r0, r1, r2, r4, r6, r7, r8, r9, r11, r12, r13, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            r5 = r24
        L_0x00bf:
            androidx.compose.runtime.ScopeUpdateScope r0 = r27.endRestartGroup()
            if (r0 != 0) goto L_0x00c6
            goto L_0x00d6
        L_0x00c6:
            com.stripe.android.ui.core.elements.FormLabelKt$FormLabel$1 r1 = new com.stripe.android.ui.core.elements.FormLabelKt$FormLabel$1
            r2 = r28
            r3 = r31
            r4 = r32
            r1.<init>(r2, r5, r3, r4)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r0.updateScope(r1)
        L_0x00d6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.ui.core.elements.FormLabelKt.FormLabel(java.lang.String, boolean, androidx.compose.runtime.Composer, int, int):void");
    }
}
