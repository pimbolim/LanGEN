package androidx.compose.foundation.layout;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aI\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u000b¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"BoxWithConstraints", "", "modifier", "Landroidx/compose/ui/Modifier;", "contentAlignment", "Landroidx/compose/ui/Alignment;", "propagateMinConstraints", "", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/BoxWithConstraintsScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;ZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "foundation-layout_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: BoxWithConstraints.kt */
public final class BoxWithConstraintsKt {
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void BoxWithConstraints(androidx.compose.ui.Modifier r11, androidx.compose.ui.Alignment r12, boolean r13, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.BoxWithConstraintsScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r14, androidx.compose.runtime.Composer r15, int r16, int r17) {
        /*
            r4 = r14
            r5 = r16
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = 482290720(0x1cbf2c20, float:1.2650726E-21)
            r1 = r15
            androidx.compose.runtime.Composer r0 = r15.startRestartGroup(r0)
            java.lang.String r1 = "C(BoxWithConstraints)P(2,1,3)62@3110L67,63@3209L218,63@3182L245:BoxWithConstraints.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            r1 = r17 & 1
            if (r1 == 0) goto L_0x001e
            r2 = r5 | 6
            r3 = r2
            r2 = r11
            goto L_0x0030
        L_0x001e:
            r2 = r5 & 14
            if (r2 != 0) goto L_0x002e
            r2 = r11
            boolean r3 = r0.changed((java.lang.Object) r11)
            if (r3 == 0) goto L_0x002b
            r3 = 4
            goto L_0x002c
        L_0x002b:
            r3 = 2
        L_0x002c:
            r3 = r3 | r5
            goto L_0x0030
        L_0x002e:
            r2 = r11
            r3 = r5
        L_0x0030:
            r6 = r17 & 2
            if (r6 == 0) goto L_0x0037
            r3 = r3 | 48
            goto L_0x0049
        L_0x0037:
            r7 = r5 & 112(0x70, float:1.57E-43)
            if (r7 != 0) goto L_0x0049
            r7 = r12
            boolean r8 = r0.changed((java.lang.Object) r12)
            if (r8 == 0) goto L_0x0045
            r8 = 32
            goto L_0x0047
        L_0x0045:
            r8 = 16
        L_0x0047:
            r3 = r3 | r8
            goto L_0x004a
        L_0x0049:
            r7 = r12
        L_0x004a:
            r8 = r17 & 4
            if (r8 == 0) goto L_0x0051
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0063
        L_0x0051:
            r9 = r5 & 896(0x380, float:1.256E-42)
            if (r9 != 0) goto L_0x0063
            r9 = r13
            boolean r10 = r0.changed((boolean) r13)
            if (r10 == 0) goto L_0x005f
            r10 = 256(0x100, float:3.59E-43)
            goto L_0x0061
        L_0x005f:
            r10 = 128(0x80, float:1.794E-43)
        L_0x0061:
            r3 = r3 | r10
            goto L_0x0064
        L_0x0063:
            r9 = r13
        L_0x0064:
            r10 = r17 & 8
            if (r10 == 0) goto L_0x006b
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x007b
        L_0x006b:
            r10 = r5 & 7168(0x1c00, float:1.0045E-41)
            if (r10 != 0) goto L_0x007b
            boolean r10 = r0.changed((java.lang.Object) r14)
            if (r10 == 0) goto L_0x0078
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x007a
        L_0x0078:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x007a:
            r3 = r3 | r10
        L_0x007b:
            r10 = r3 & 5851(0x16db, float:8.199E-42)
            r10 = r10 ^ 1170(0x492, float:1.64E-42)
            if (r10 != 0) goto L_0x008f
            boolean r10 = r0.getSkipping()
            if (r10 != 0) goto L_0x0088
            goto L_0x008f
        L_0x0088:
            r0.skipToGroupEnd()
            r1 = r2
            r2 = r7
        L_0x008d:
            r3 = r9
            goto L_0x00e8
        L_0x008f:
            if (r1 == 0) goto L_0x0096
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x0097
        L_0x0096:
            r1 = r2
        L_0x0097:
            if (r6 == 0) goto L_0x00a0
            androidx.compose.ui.Alignment$Companion r2 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r2 = r2.getTopStart()
            goto L_0x00a1
        L_0x00a0:
            r2 = r7
        L_0x00a1:
            r6 = 0
            if (r8 == 0) goto L_0x00a5
            r9 = 0
        L_0x00a5:
            int r7 = r3 >> 3
            r8 = r7 & 14
            r7 = r7 & 112(0x70, float:1.57E-43)
            r7 = r7 | r8
            androidx.compose.ui.layout.MeasurePolicy r7 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r2, r9, r0, r7)
            r8 = -3686552(0xffffffffffc7bf68, float:NaN)
            r0.startReplaceableGroup(r8)
            java.lang.String r8 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r8)
            boolean r8 = r0.changed((java.lang.Object) r14)
            boolean r10 = r0.changed((java.lang.Object) r7)
            r8 = r8 | r10
            java.lang.Object r10 = r0.rememberedValue()
            if (r8 != 0) goto L_0x00d2
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r10 != r8) goto L_0x00dd
        L_0x00d2:
            androidx.compose.foundation.layout.BoxWithConstraintsKt$BoxWithConstraints$1$1 r8 = new androidx.compose.foundation.layout.BoxWithConstraintsKt$BoxWithConstraints$1$1
            r8.<init>(r7, r14, r3)
            r10 = r8
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r0.updateRememberedValue(r10)
        L_0x00dd:
            r0.endReplaceableGroup()
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r3 = r3 & 14
            androidx.compose.ui.layout.SubcomposeLayoutKt.SubcomposeLayout(r1, r10, r0, r3, r6)
            goto L_0x008d
        L_0x00e8:
            androidx.compose.runtime.ScopeUpdateScope r7 = r0.endRestartGroup()
            if (r7 != 0) goto L_0x00ef
            goto L_0x00ff
        L_0x00ef:
            androidx.compose.foundation.layout.BoxWithConstraintsKt$BoxWithConstraints$2 r8 = new androidx.compose.foundation.layout.BoxWithConstraintsKt$BoxWithConstraints$2
            r0 = r8
            r4 = r14
            r5 = r16
            r6 = r17
            r0.<init>(r1, r2, r3, r4, r5, r6)
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r7.updateScope(r8)
        L_0x00ff:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.BoxWithConstraintsKt.BoxWithConstraints(androidx.compose.ui.Modifier, androidx.compose.ui.Alignment, boolean, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }
}
