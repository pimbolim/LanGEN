package com.stripe.android.link.ui;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a7\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0001¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"PrimaryButton", "", "label", "", "state", "Lcom/stripe/android/link/ui/PrimaryButtonState;", "icon", "", "onButtonClick", "Lkotlin/Function0;", "(Ljava/lang/String;Lcom/stripe/android/link/ui/PrimaryButtonState;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "link_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: PrimaryButton.kt */
public final class PrimaryButtonKt {
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void PrimaryButton(java.lang.String r16, com.stripe.android.link.ui.PrimaryButtonState r17, java.lang.Integer r18, kotlin.jvm.functions.Function0<kotlin.Unit> r19, androidx.compose.runtime.Composer r20, int r21, int r22) {
        /*
            r7 = r16
            r8 = r17
            r9 = r19
            r10 = r21
            java.lang.String r0 = "label"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "onButtonClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r0 = 1179852444(0x46531e9c, float:13511.652)
            r1 = r20
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            r0 = r22 & 1
            if (r0 == 0) goto L_0x0027
            r0 = r10 | 6
            goto L_0x0037
        L_0x0027:
            r0 = r10 & 14
            if (r0 != 0) goto L_0x0036
            boolean r0 = r11.changed((java.lang.Object) r7)
            if (r0 == 0) goto L_0x0033
            r0 = 4
            goto L_0x0034
        L_0x0033:
            r0 = 2
        L_0x0034:
            r0 = r0 | r10
            goto L_0x0037
        L_0x0036:
            r0 = r10
        L_0x0037:
            r1 = r22 & 2
            if (r1 == 0) goto L_0x003e
            r0 = r0 | 48
            goto L_0x004e
        L_0x003e:
            r1 = r10 & 112(0x70, float:1.57E-43)
            if (r1 != 0) goto L_0x004e
            boolean r1 = r11.changed((java.lang.Object) r8)
            if (r1 == 0) goto L_0x004b
            r1 = 32
            goto L_0x004d
        L_0x004b:
            r1 = 16
        L_0x004d:
            r0 = r0 | r1
        L_0x004e:
            r1 = r22 & 4
            if (r1 == 0) goto L_0x0055
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0068
        L_0x0055:
            r2 = r10 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x0068
            r2 = r18
            boolean r3 = r11.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x0064
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x0066
        L_0x0064:
            r3 = 128(0x80, float:1.794E-43)
        L_0x0066:
            r0 = r0 | r3
            goto L_0x006a
        L_0x0068:
            r2 = r18
        L_0x006a:
            r3 = r22 & 8
            if (r3 == 0) goto L_0x0071
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0081
        L_0x0071:
            r3 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r3 != 0) goto L_0x0081
            boolean r3 = r11.changed((java.lang.Object) r9)
            if (r3 == 0) goto L_0x007e
            r3 = 2048(0x800, float:2.87E-42)
            goto L_0x0080
        L_0x007e:
            r3 = 1024(0x400, float:1.435E-42)
        L_0x0080:
            r0 = r0 | r3
        L_0x0081:
            r3 = r0
            r0 = r3 & 5851(0x16db, float:8.199E-42)
            r0 = r0 ^ 1170(0x492, float:1.64E-42)
            if (r0 != 0) goto L_0x0094
            boolean r0 = r11.getSkipping()
            if (r0 != 0) goto L_0x008f
            goto L_0x0094
        L_0x008f:
            r11.skipToGroupEnd()
            r3 = r2
            goto L_0x00f1
        L_0x0094:
            if (r1 == 0) goto L_0x0099
            r0 = 0
            r12 = r0
            goto L_0x009a
        L_0x0099:
            r12 = r2
        L_0x009a:
            com.stripe.android.link.ui.PrimaryButtonState r0 = com.stripe.android.link.ui.PrimaryButtonState.Enabled
            r1 = 0
            r13 = 1
            if (r8 != r0) goto L_0x00a2
            r2 = 1
            goto L_0x00a3
        L_0x00a2:
            r2 = 0
        L_0x00a3:
            androidx.compose.runtime.ProvidedValue[] r14 = new androidx.compose.runtime.ProvidedValue[r13]
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.material.ContentAlphaKt.getLocalContentAlpha()
            r4 = 8
            if (r2 == 0) goto L_0x00ba
            r5 = 1179852733(0x46531fbd, float:13511.935)
            r11.startReplaceableGroup(r5)
            androidx.compose.material.ContentAlpha r5 = androidx.compose.material.ContentAlpha.INSTANCE
            float r4 = r5.getHigh(r11, r4)
            goto L_0x00c6
        L_0x00ba:
            r5 = 1179852756(0x46531fd4, float:13511.957)
            r11.startReplaceableGroup(r5)
            androidx.compose.material.ContentAlpha r5 = androidx.compose.material.ContentAlpha.INSTANCE
            float r4 = r5.getDisabled(r11, r4)
        L_0x00c6:
            r11.endReplaceableGroup()
            java.lang.Float r4 = java.lang.Float.valueOf(r4)
            androidx.compose.runtime.ProvidedValue r0 = r0.provides(r4)
            r14[r1] = r0
            r15 = -819895439(0xffffffffcf216371, float:-2.70764877E9)
            com.stripe.android.link.ui.PrimaryButtonKt$PrimaryButton$1 r6 = new com.stripe.android.link.ui.PrimaryButtonKt$PrimaryButton$1
            r0 = r6
            r1 = r19
            r4 = r12
            r5 = r17
            r13 = r6
            r6 = r16
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r0 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r11, r15, r0, r13)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = 56
            androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider((androidx.compose.runtime.ProvidedValue<?>[]) r14, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r0, (androidx.compose.runtime.Composer) r11, (int) r1)
            r3 = r12
        L_0x00f1:
            androidx.compose.runtime.ScopeUpdateScope r11 = r11.endRestartGroup()
            if (r11 != 0) goto L_0x00f8
            goto L_0x010d
        L_0x00f8:
            com.stripe.android.link.ui.PrimaryButtonKt$PrimaryButton$2 r12 = new com.stripe.android.link.ui.PrimaryButtonKt$PrimaryButton$2
            r0 = r12
            r1 = r16
            r2 = r17
            r4 = r19
            r5 = r21
            r6 = r22
            r0.<init>(r1, r2, r3, r4, r5, r6)
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r11.updateScope(r12)
        L_0x010d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.link.ui.PrimaryButtonKt.PrimaryButton(java.lang.String, com.stripe.android.link.ui.PrimaryButtonState, java.lang.Integer, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }
}
