package androidx.compose.foundation.text;

import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001ay\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u000f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u000fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0014"}, d2 = {"ClickableText", "", "text", "Landroidx/compose/ui/text/AnnotatedString;", "modifier", "Landroidx/compose/ui/Modifier;", "style", "Landroidx/compose/ui/text/TextStyle;", "softWrap", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "maxLines", "", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "onClick", "ClickableText-4YKlhWE", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;ZIILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "foundation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClickableText.kt */
public final class ClickableTextKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0231  */
    /* JADX WARNING: Removed duplicated region for block: B:125:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0123  */
    /* renamed from: ClickableText-4YKlhWE  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m629ClickableText4YKlhWE(androidx.compose.ui.text.AnnotatedString r24, androidx.compose.ui.Modifier r25, androidx.compose.ui.text.TextStyle r26, boolean r27, int r28, int r29, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r30, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> r31, androidx.compose.runtime.Composer r32, int r33, int r34) {
        /*
            r11 = r24
            r12 = r31
            r13 = r33
            r14 = r34
            java.lang.String r0 = "text"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = 48323887(0x2e15d2f, float:3.3114263E-37)
            r1 = r32
            androidx.compose.runtime.Composer r15 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(ClickableText)P(7,1,6,5,4:c#ui.text.style.TextOverflow!1,3)73@3340L52,74@3449L184,89@3854L76,82@3639L297:ClickableText.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r0)
            r0 = r14 & 1
            if (r0 == 0) goto L_0x0028
            r0 = r13 | 6
            goto L_0x0038
        L_0x0028:
            r0 = r13 & 14
            if (r0 != 0) goto L_0x0037
            boolean r0 = r15.changed((java.lang.Object) r11)
            if (r0 == 0) goto L_0x0034
            r0 = 4
            goto L_0x0035
        L_0x0034:
            r0 = 2
        L_0x0035:
            r0 = r0 | r13
            goto L_0x0038
        L_0x0037:
            r0 = r13
        L_0x0038:
            r2 = r14 & 2
            if (r2 == 0) goto L_0x003f
            r0 = r0 | 48
            goto L_0x0052
        L_0x003f:
            r3 = r13 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0052
            r3 = r25
            boolean r4 = r15.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x004e
            r4 = 32
            goto L_0x0050
        L_0x004e:
            r4 = 16
        L_0x0050:
            r0 = r0 | r4
            goto L_0x0054
        L_0x0052:
            r3 = r25
        L_0x0054:
            r4 = r14 & 4
            if (r4 == 0) goto L_0x005b
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x006e
        L_0x005b:
            r5 = r13 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x006e
            r5 = r26
            boolean r6 = r15.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x006a
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x006c
        L_0x006a:
            r6 = 128(0x80, float:1.794E-43)
        L_0x006c:
            r0 = r0 | r6
            goto L_0x0070
        L_0x006e:
            r5 = r26
        L_0x0070:
            r6 = r14 & 8
            if (r6 == 0) goto L_0x0077
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x008a
        L_0x0077:
            r7 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x008a
            r7 = r27
            boolean r8 = r15.changed((boolean) r7)
            if (r8 == 0) goto L_0x0086
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x0088
        L_0x0086:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x0088:
            r0 = r0 | r8
            goto L_0x008c
        L_0x008a:
            r7 = r27
        L_0x008c:
            r8 = r14 & 16
            r9 = 57344(0xe000, float:8.0356E-41)
            if (r8 == 0) goto L_0x0096
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00aa
        L_0x0096:
            r10 = r13 & r9
            if (r10 != 0) goto L_0x00aa
            r10 = r28
            boolean r16 = r15.changed((int) r10)
            if (r16 == 0) goto L_0x00a5
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a7
        L_0x00a5:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x00a7:
            r0 = r0 | r16
            goto L_0x00ac
        L_0x00aa:
            r10 = r28
        L_0x00ac:
            r16 = r14 & 32
            r17 = 458752(0x70000, float:6.42848E-40)
            if (r16 == 0) goto L_0x00b9
            r18 = 196608(0x30000, float:2.75506E-40)
            r0 = r0 | r18
            r9 = r29
            goto L_0x00cc
        L_0x00b9:
            r18 = r13 & r17
            r9 = r29
            if (r18 != 0) goto L_0x00cc
            boolean r18 = r15.changed((int) r9)
            if (r18 == 0) goto L_0x00c8
            r18 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00ca
        L_0x00c8:
            r18 = 65536(0x10000, float:9.18355E-41)
        L_0x00ca:
            r0 = r0 | r18
        L_0x00cc:
            r18 = r14 & 64
            r19 = 3670016(0x380000, float:5.142788E-39)
            if (r18 == 0) goto L_0x00d9
            r20 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r20
            r1 = r30
            goto L_0x00ec
        L_0x00d9:
            r20 = r13 & r19
            r1 = r30
            if (r20 != 0) goto L_0x00ec
            boolean r21 = r15.changed((java.lang.Object) r1)
            if (r21 == 0) goto L_0x00e8
            r21 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00ea
        L_0x00e8:
            r21 = 524288(0x80000, float:7.34684E-40)
        L_0x00ea:
            r0 = r0 | r21
        L_0x00ec:
            r1 = r14 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x00f4
            r1 = 12582912(0xc00000, float:1.7632415E-38)
        L_0x00f2:
            r0 = r0 | r1
            goto L_0x0105
        L_0x00f4:
            r1 = 29360128(0x1c00000, float:7.052966E-38)
            r1 = r1 & r13
            if (r1 != 0) goto L_0x0105
            boolean r1 = r15.changed((java.lang.Object) r12)
            if (r1 == 0) goto L_0x0102
            r1 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f2
        L_0x0102:
            r1 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x00f2
        L_0x0105:
            r1 = 23967451(0x16db6db, float:4.3661218E-38)
            r1 = r1 & r0
            r21 = 4793490(0x492492, float:6.71711E-39)
            r1 = r1 ^ r21
            if (r1 != 0) goto L_0x0123
            boolean r1 = r15.getSkipping()
            if (r1 != 0) goto L_0x0117
            goto L_0x0123
        L_0x0117:
            r15.skipToGroupEnd()
            r2 = r3
            r3 = r5
            r4 = r7
            r6 = r9
            r5 = r10
            r7 = r30
            goto L_0x022a
        L_0x0123:
            if (r2 == 0) goto L_0x012a
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r3 = r1
        L_0x012a:
            if (r4 == 0) goto L_0x0135
            androidx.compose.ui.text.TextStyle$Companion r1 = androidx.compose.ui.text.TextStyle.Companion
            androidx.compose.ui.text.TextStyle r1 = r1.getDefault()
            r21 = r1
            goto L_0x0137
        L_0x0135:
            r21 = r5
        L_0x0137:
            if (r6 == 0) goto L_0x013d
            r1 = 1
            r22 = 1
            goto L_0x013f
        L_0x013d:
            r22 = r7
        L_0x013f:
            if (r8 == 0) goto L_0x014a
            androidx.compose.ui.text.style.TextOverflow$Companion r1 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r1 = r1.m3788getClipgIe3tQ8()
            r23 = r1
            goto L_0x014c
        L_0x014a:
            r23 = r10
        L_0x014c:
            if (r16 == 0) goto L_0x0155
            r1 = 2147483647(0x7fffffff, float:NaN)
            r16 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x0157
        L_0x0155:
            r16 = r9
        L_0x0157:
            if (r18 == 0) goto L_0x015f
            androidx.compose.foundation.text.ClickableTextKt$ClickableText$1 r1 = androidx.compose.foundation.text.ClickableTextKt$ClickableText$1.INSTANCE
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r10 = r1
            goto L_0x0161
        L_0x015f:
            r10 = r30
        L_0x0161:
            r1 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r15.startReplaceableGroup(r1)
            java.lang.String r1 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r1)
            java.lang.Object r1 = r15.rememberedValue()
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            r4 = 0
            if (r1 != r2) goto L_0x0181
            r2 = 2
            androidx.compose.runtime.MutableState r1 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r4, r4, r2, r4)
            r15.updateRememberedValue(r1)
        L_0x0181:
            r15.endReplaceableGroup()
            androidx.compose.runtime.MutableState r1 = (androidx.compose.runtime.MutableState) r1
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            r5 = -3686552(0xffffffffffc7bf68, float:NaN)
            r15.startReplaceableGroup(r5)
            java.lang.String r6 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r6)
            boolean r7 = r15.changed((java.lang.Object) r1)
            boolean r8 = r15.changed((java.lang.Object) r12)
            r7 = r7 | r8
            java.lang.Object r8 = r15.rememberedValue()
            if (r7 != 0) goto L_0x01ac
            androidx.compose.runtime.Composer$Companion r7 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r7.getEmpty()
            if (r8 != r7) goto L_0x01b7
        L_0x01ac:
            androidx.compose.foundation.text.ClickableTextKt$ClickableText$pressIndicator$1$1 r7 = new androidx.compose.foundation.text.ClickableTextKt$ClickableText$pressIndicator$1$1
            r7.<init>(r1, r12, r4)
            r8 = r7
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r15.updateRememberedValue(r8)
        L_0x01b7:
            r15.endReplaceableGroup()
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt.pointerInput((androidx.compose.ui.Modifier) r2, (java.lang.Object) r12, (kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r8)
            androidx.compose.ui.Modifier r2 = r3.then(r2)
            r15.startReplaceableGroup(r5)
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r6)
            boolean r4 = r15.changed((java.lang.Object) r1)
            boolean r5 = r15.changed((java.lang.Object) r10)
            r4 = r4 | r5
            java.lang.Object r5 = r15.rememberedValue()
            if (r4 != 0) goto L_0x01e1
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r5 != r4) goto L_0x01ec
        L_0x01e1:
            androidx.compose.foundation.text.ClickableTextKt$ClickableText$2$1 r4 = new androidx.compose.foundation.text.ClickableTextKt$ClickableText$2$1
            r4.<init>(r1, r10)
            r5 = r4
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r15.updateRememberedValue(r5)
        L_0x01ec:
            r15.endReplaceableGroup()
            r4 = r5
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r7 = 0
            r1 = r0 & 14
            r5 = r0 & 896(0x380, float:1.256E-42)
            r1 = r1 | r5
            r5 = 57344(0xe000, float:8.0356E-41)
            r5 = r5 & r0
            r1 = r1 | r5
            int r5 = r0 << 6
            r5 = r5 & r17
            r1 = r1 | r5
            int r0 = r0 << 3
            r0 = r0 & r19
            r9 = r1 | r0
            r17 = 128(0x80, float:1.794E-43)
            r0 = r24
            r1 = r2
            r2 = r21
            r18 = r3
            r3 = r4
            r4 = r23
            r5 = r22
            r6 = r16
            r8 = r15
            r19 = r10
            r10 = r17
            androidx.compose.foundation.text.BasicTextKt.m627BasicText4YKlhWE(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r2 = r18
            r7 = r19
            r3 = r21
            r4 = r22
            r5 = r23
        L_0x022a:
            androidx.compose.runtime.ScopeUpdateScope r15 = r15.endRestartGroup()
            if (r15 != 0) goto L_0x0231
            goto L_0x0247
        L_0x0231:
            androidx.compose.foundation.text.ClickableTextKt$ClickableText$3 r16 = new androidx.compose.foundation.text.ClickableTextKt$ClickableText$3
            r0 = r16
            r1 = r24
            r8 = r31
            r9 = r33
            r10 = r34
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r15.updateScope(r0)
        L_0x0247:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.ClickableTextKt.m629ClickableText4YKlhWE(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.Modifier, androidx.compose.ui.text.TextStyle, boolean, int, int, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }
}
