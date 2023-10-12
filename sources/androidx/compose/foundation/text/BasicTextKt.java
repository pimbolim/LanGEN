package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.SelectionRegistrar;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a{\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001ae\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00132\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u001e\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b0\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, d2 = {"BasicText", "", "text", "Landroidx/compose/ui/text/AnnotatedString;", "modifier", "Landroidx/compose/ui/Modifier;", "style", "Landroidx/compose/ui/text/TextStyle;", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "inlineContent", "", "", "Landroidx/compose/foundation/text/InlineTextContent;", "BasicText-4YKlhWE", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZILjava/util/Map;Landroidx/compose/runtime/Composer;II)V", "BasicText-BpD7jsM", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZILandroidx/compose/runtime/Composer;II)V", "selectionIdSaver", "Landroidx/compose/runtime/saveable/Saver;", "", "selectionRegistrar", "Landroidx/compose/foundation/text/selection/SelectionRegistrar;", "foundation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: BasicText.kt */
public final class BasicTextKt {
    /* JADX WARNING: Removed duplicated region for block: B:122:0x033f  */
    /* JADX WARNING: Removed duplicated region for block: B:126:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00fd  */
    /* renamed from: BasicText-BpD7jsM  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m628BasicTextBpD7jsM(java.lang.String r28, androidx.compose.ui.Modifier r29, androidx.compose.ui.text.TextStyle r30, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r31, int r32, boolean r33, int r34, androidx.compose.runtime.Composer r35, int r36, int r37) {
        /*
            r8 = r28
            r9 = r36
            java.lang.String r0 = "text"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r0 = 959236841(0x392ccae9, float:1.6478788E-4)
            r1 = r35
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(BasicText)P(6,1,5,2,3:c#ui.text.style.TextOverflow,4)73@3665L7,74@3704L7,75@3753L7,88@4465L193,92@4681L465,127@5771L69:BasicText.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            r0 = r37 & 1
            if (r0 == 0) goto L_0x001f
            r0 = r9 | 6
            goto L_0x002f
        L_0x001f:
            r0 = r9 & 14
            if (r0 != 0) goto L_0x002e
            boolean r0 = r10.changed((java.lang.Object) r8)
            if (r0 == 0) goto L_0x002b
            r0 = 4
            goto L_0x002c
        L_0x002b:
            r0 = 2
        L_0x002c:
            r0 = r0 | r9
            goto L_0x002f
        L_0x002e:
            r0 = r9
        L_0x002f:
            r2 = r37 & 2
            if (r2 == 0) goto L_0x0036
            r0 = r0 | 48
            goto L_0x0049
        L_0x0036:
            r3 = r9 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0049
            r3 = r29
            boolean r4 = r10.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0045
            r4 = 32
            goto L_0x0047
        L_0x0045:
            r4 = 16
        L_0x0047:
            r0 = r0 | r4
            goto L_0x004b
        L_0x0049:
            r3 = r29
        L_0x004b:
            r4 = r37 & 4
            if (r4 == 0) goto L_0x0052
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0065
        L_0x0052:
            r5 = r9 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x0065
            r5 = r30
            boolean r6 = r10.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0061
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x0063
        L_0x0061:
            r6 = 128(0x80, float:1.794E-43)
        L_0x0063:
            r0 = r0 | r6
            goto L_0x0067
        L_0x0065:
            r5 = r30
        L_0x0067:
            r6 = r37 & 8
            if (r6 == 0) goto L_0x006e
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0081
        L_0x006e:
            r7 = r9 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x0081
            r7 = r31
            boolean r11 = r10.changed((java.lang.Object) r7)
            if (r11 == 0) goto L_0x007d
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x007f
        L_0x007d:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x007f:
            r0 = r0 | r11
            goto L_0x0083
        L_0x0081:
            r7 = r31
        L_0x0083:
            r11 = r37 & 16
            if (r11 == 0) goto L_0x008a
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009f
        L_0x008a:
            r12 = 57344(0xe000, float:8.0356E-41)
            r12 = r12 & r9
            if (r12 != 0) goto L_0x009f
            r12 = r32
            boolean r13 = r10.changed((int) r12)
            if (r13 == 0) goto L_0x009b
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009d
        L_0x009b:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x009d:
            r0 = r0 | r13
            goto L_0x00a1
        L_0x009f:
            r12 = r32
        L_0x00a1:
            r13 = r37 & 32
            if (r13 == 0) goto L_0x00a9
            r14 = 196608(0x30000, float:2.75506E-40)
            r0 = r0 | r14
            goto L_0x00bd
        L_0x00a9:
            r14 = 458752(0x70000, float:6.42848E-40)
            r14 = r14 & r9
            if (r14 != 0) goto L_0x00bd
            r14 = r33
            boolean r15 = r10.changed((boolean) r14)
            if (r15 == 0) goto L_0x00b9
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bb
        L_0x00b9:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00bb:
            r0 = r0 | r15
            goto L_0x00bf
        L_0x00bd:
            r14 = r33
        L_0x00bf:
            r15 = r37 & 64
            if (r15 == 0) goto L_0x00ca
            r16 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r16
            r1 = r34
            goto L_0x00df
        L_0x00ca:
            r16 = 3670016(0x380000, float:5.142788E-39)
            r16 = r9 & r16
            r1 = r34
            if (r16 != 0) goto L_0x00df
            boolean r16 = r10.changed((int) r1)
            if (r16 == 0) goto L_0x00db
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00dd
        L_0x00db:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00dd:
            r0 = r0 | r16
        L_0x00df:
            r16 = 2995931(0x2db6db, float:4.198194E-39)
            r0 = r0 & r16
            r16 = 599186(0x92492, float:8.39638E-40)
            r0 = r0 ^ r16
            if (r0 != 0) goto L_0x00fd
            boolean r0 = r10.getSkipping()
            if (r0 != 0) goto L_0x00f2
            goto L_0x00fd
        L_0x00f2:
            r10.skipToGroupEnd()
            r2 = r3
            r3 = r5
            r4 = r7
            r5 = r12
            r6 = r14
            r7 = r1
            goto L_0x0338
        L_0x00fd:
            if (r2 == 0) goto L_0x0104
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r3 = r0
        L_0x0104:
            if (r4 == 0) goto L_0x010f
            androidx.compose.ui.text.TextStyle$Companion r0 = androidx.compose.ui.text.TextStyle.Companion
            androidx.compose.ui.text.TextStyle r0 = r0.getDefault()
            r27 = r0
            goto L_0x0111
        L_0x010f:
            r27 = r5
        L_0x0111:
            if (r6 == 0) goto L_0x0118
            androidx.compose.foundation.text.BasicTextKt$BasicText$1 r0 = androidx.compose.foundation.text.BasicTextKt$BasicText$1.INSTANCE
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r7 = r0
        L_0x0118:
            if (r11 == 0) goto L_0x0121
            androidx.compose.ui.text.style.TextOverflow$Companion r0 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r0 = r0.m3788getClipgIe3tQ8()
            r12 = r0
        L_0x0121:
            r0 = 1
            if (r13 == 0) goto L_0x0125
            r14 = 1
        L_0x0125:
            if (r15 == 0) goto L_0x012e
            r1 = 2147483647(0x7fffffff, float:NaN)
            r11 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x012f
        L_0x012e:
            r11 = r1
        L_0x012f:
            r1 = 0
            if (r11 <= 0) goto L_0x0134
            r2 = 1
            goto L_0x0135
        L_0x0134:
            r2 = 0
        L_0x0135:
            if (r2 == 0) goto L_0x0351
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.foundation.text.selection.SelectionRegistrarKt.getLocalSelectionRegistrar()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r13 = 103361330(0x6292b32, float:3.1817102E-35)
            java.lang.String r15 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r13, r15)
            java.lang.Object r2 = r10.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            r6 = r2
            androidx.compose.foundation.text.selection.SelectionRegistrar r6 = (androidx.compose.foundation.text.selection.SelectionRegistrar) r6
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r13, r15)
            java.lang.Object r2 = r10.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            r4 = r2
            androidx.compose.ui.unit.Density r4 = (androidx.compose.ui.unit.Density) r4
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalFontLoader()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r13, r15)
            java.lang.Object r2 = r10.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            r5 = r2
            androidx.compose.ui.text.font.Font$ResourceLoader r5 = (androidx.compose.ui.text.font.Font.ResourceLoader) r5
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r1] = r8
            r2[r0] = r6
            androidx.compose.runtime.saveable.Saver r0 = selectionIdSaver(r6)
            r1 = 0
            androidx.compose.foundation.text.BasicTextKt$BasicText$selectableId$1 r13 = new androidx.compose.foundation.text.BasicTextKt$BasicText$selectableId$1
            r13.<init>(r6)
            kotlin.jvm.functions.Function0 r13 = (kotlin.jvm.functions.Function0) r13
            r16 = 72
            r17 = 4
            r29 = r2
            r30 = r0
            r31 = r1
            r32 = r13
            r33 = r10
            r34 = r16
            r35 = r17
            java.lang.Object r0 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r29, r30, (java.lang.String) r31, r32, (androidx.compose.runtime.Composer) r33, (int) r34, (int) r35)
            java.lang.Number r0 = (java.lang.Number) r0
            long r0 = r0.longValue()
            r2 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r10.startReplaceableGroup(r2)
            java.lang.String r2 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r2)
            java.lang.Object r2 = r10.rememberedValue()
            androidx.compose.runtime.Composer$Companion r13 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r13 = r13.getEmpty()
            if (r2 != r13) goto L_0x01fd
            androidx.compose.foundation.text.TextController r2 = new androidx.compose.foundation.text.TextController
            androidx.compose.foundation.text.TextState r13 = new androidx.compose.foundation.text.TextState
            androidx.compose.ui.text.AnnotatedString r17 = new androidx.compose.ui.text.AnnotatedString
            r16 = 0
            r18 = 0
            r19 = 6
            r20 = 0
            r29 = r17
            r30 = r28
            r31 = r16
            r32 = r18
            r33 = r19
            r34 = r20
            r29.<init>(r30, r31, r32, r33, r34)
            r29 = r3
            androidx.compose.foundation.text.TextDelegate r3 = new androidx.compose.foundation.text.TextDelegate
            r24 = 0
            r25 = 128(0x80, float:1.794E-43)
            r26 = 0
            r16 = r3
            r18 = r27
            r19 = r11
            r20 = r14
            r21 = r12
            r22 = r4
            r23 = r5
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            r13.<init>(r3, r0)
            r2.<init>(r13)
            r10.updateRememberedValue(r2)
            goto L_0x01ff
        L_0x01fd:
            r29 = r3
        L_0x01ff:
            r10.endReplaceableGroup()
            r13 = r2
            androidx.compose.foundation.text.TextController r13 = (androidx.compose.foundation.text.TextController) r13
            androidx.compose.foundation.text.TextState r3 = r13.getState()
            boolean r0 = r10.getInserting()
            if (r0 != 0) goto L_0x022d
            androidx.compose.foundation.text.TextDelegate r0 = r3.getTextDelegate()
            r1 = r28
            r2 = r27
            r9 = r29
            r8 = r3
            r3 = r4
            r4 = r5
            r5 = r14
            r29 = r14
            r14 = r6
            r6 = r12
            r30 = r12
            r12 = r7
            r7 = r11
            androidx.compose.foundation.text.TextDelegate r0 = androidx.compose.foundation.text.CoreTextKt.m641updateTextDelegatey0kMQk(r0, r1, r2, r3, r4, r5, r6, r7)
            r8.setTextDelegate(r0)
            goto L_0x0236
        L_0x022d:
            r9 = r29
            r8 = r3
            r30 = r12
            r29 = r14
            r14 = r6
            r12 = r7
        L_0x0236:
            r8.setOnTextLayout(r12)
            r13.update(r14)
            r0 = 959239472(0x392cd530, float:1.6482617E-4)
            r10.startReplaceableGroup(r0)
            java.lang.String r0 = "124@5736L7"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            if (r14 == 0) goto L_0x0265
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.foundation.text.selection.TextSelectionColorsKt.getLocalTextSelectionColors()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 103361330(0x6292b32, float:3.1817102E-35)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r1, r15)
            java.lang.Object r0 = r10.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.foundation.text.selection.TextSelectionColors r0 = (androidx.compose.foundation.text.selection.TextSelectionColors) r0
            long r0 = r0.m821getBackgroundColor0d7_KjU()
            r8.m737setSelectionBackgroundColor8_81llA(r0)
        L_0x0265:
            r10.endReplaceableGroup()
            androidx.compose.ui.Modifier r0 = r13.getModifiers()
            androidx.compose.ui.Modifier r0 = r9.then(r0)
            androidx.compose.ui.layout.MeasurePolicy r1 = r13.getMeasurePolicy()
            r2 = 1376091099(0x52057bdb, float:1.4332715E11)
            r10.startReplaceableGroup(r2)
            java.lang.String r2 = "C(Layout)P(1)116@4515L7,117@4570L7,118@4629L7,120@4702L439:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r2)
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r3 = 103361330(0x6292b32, float:3.1817102E-35)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r3, r15)
            java.lang.Object r2 = r10.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.ui.unit.Density r2 = (androidx.compose.ui.unit.Density) r2
            androidx.compose.runtime.ProvidableCompositionLocal r4 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r4 = (androidx.compose.runtime.CompositionLocal) r4
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r3, r15)
            java.lang.Object r4 = r10.consume(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.ui.unit.LayoutDirection r4 = (androidx.compose.ui.unit.LayoutDirection) r4
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r3, r15)
            java.lang.Object r3 = r10.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.ui.platform.ViewConfiguration r3 = (androidx.compose.ui.platform.ViewConfiguration) r3
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.ComposedModifierKt.materialize(r10, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r5 = r5.getConstructor()
            r6 = 1546164872(0x5c289a88, float:1.8983082E17)
            r10.startReplaceableGroup(r6)
            java.lang.String r6 = "C(ReusableComposeNode):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r6)
            androidx.compose.runtime.Applier r6 = r10.getApplier()
            boolean r6 = r6 instanceof androidx.compose.runtime.Applier
            if (r6 != 0) goto L_0x02d8
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x02d8:
            r10.startReusableNode()
            boolean r6 = r10.getInserting()
            if (r6 == 0) goto L_0x02ec
            androidx.compose.foundation.text.BasicTextKt$BasicText-BpD7jsM$$inlined$Layout$1 r6 = new androidx.compose.foundation.text.BasicTextKt$BasicText-BpD7jsM$$inlined$Layout$1
            r6.<init>(r5)
            kotlin.jvm.functions.Function0 r6 = (kotlin.jvm.functions.Function0) r6
            r10.createNode(r6)
            goto L_0x02ef
        L_0x02ec:
            r10.useNode()
        L_0x02ef:
            r10.disableReusing()
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.Updater.m1234constructorimpl(r10)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r5, r1, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetDensity()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r5, r2, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r5, r4, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r5, r3, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetModifier()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r5, r0, r1)
            r10.enableReusing()
            r10.endNode()
            r10.endReplaceableGroup()
            r10.endReplaceableGroup()
            r6 = r29
            r5 = r30
            r2 = r9
            r7 = r11
            r4 = r12
            r3 = r27
        L_0x0338:
            androidx.compose.runtime.ScopeUpdateScope r10 = r10.endRestartGroup()
            if (r10 != 0) goto L_0x033f
            goto L_0x0350
        L_0x033f:
            androidx.compose.foundation.text.BasicTextKt$BasicText$3 r11 = new androidx.compose.foundation.text.BasicTextKt$BasicText$3
            r0 = r11
            r1 = r28
            r8 = r36
            r9 = r37
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r10.updateScope(r11)
        L_0x0350:
            return
        L_0x0351:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "maxLines should be greater than 0"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextKt.m628BasicTextBpD7jsM(java.lang.String, androidx.compose.ui.Modifier, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function1, int, boolean, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:139:0x03ce  */
    /* JADX WARNING: Removed duplicated region for block: B:143:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0112  */
    /* renamed from: BasicText-4YKlhWE  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m627BasicText4YKlhWE(androidx.compose.ui.text.AnnotatedString r37, androidx.compose.ui.Modifier r38, androidx.compose.ui.text.TextStyle r39, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r40, int r41, boolean r42, int r43, java.util.Map<java.lang.String, androidx.compose.foundation.text.InlineTextContent> r44, androidx.compose.runtime.Composer r45, int r46, int r47) {
        /*
            r10 = r37
            r11 = r46
            r12 = r47
            java.lang.String r0 = "text"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = 959241330(0x392cdc72, float:1.648532E-4)
            r1 = r45
            androidx.compose.runtime.Composer r13 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(BasicText)P(7,2,6,3,4:c#ui.text.style.TextOverflow,5,1)167@8051L7,168@8090L7,169@8139L7,170@8207L7,185@9022L193,189@9238L496,225@10329L270:BasicText.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r0)
            r0 = r12 & 1
            if (r0 == 0) goto L_0x0021
            r0 = r11 | 6
            goto L_0x0031
        L_0x0021:
            r0 = r11 & 14
            if (r0 != 0) goto L_0x0030
            boolean r0 = r13.changed((java.lang.Object) r10)
            if (r0 == 0) goto L_0x002d
            r0 = 4
            goto L_0x002e
        L_0x002d:
            r0 = 2
        L_0x002e:
            r0 = r0 | r11
            goto L_0x0031
        L_0x0030:
            r0 = r11
        L_0x0031:
            r2 = r12 & 2
            if (r2 == 0) goto L_0x0038
            r0 = r0 | 48
            goto L_0x004b
        L_0x0038:
            r3 = r11 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x004b
            r3 = r38
            boolean r4 = r13.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0047
            r4 = 32
            goto L_0x0049
        L_0x0047:
            r4 = 16
        L_0x0049:
            r0 = r0 | r4
            goto L_0x004d
        L_0x004b:
            r3 = r38
        L_0x004d:
            r4 = r12 & 4
            if (r4 == 0) goto L_0x0054
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0067
        L_0x0054:
            r6 = r11 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x0067
            r6 = r39
            boolean r7 = r13.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0063
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0065
        L_0x0063:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0065:
            r0 = r0 | r7
            goto L_0x0069
        L_0x0067:
            r6 = r39
        L_0x0069:
            r7 = r12 & 8
            if (r7 == 0) goto L_0x0070
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0083
        L_0x0070:
            r8 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x0083
            r8 = r40
            boolean r9 = r13.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x007f
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x0081
        L_0x007f:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x0081:
            r0 = r0 | r9
            goto L_0x0085
        L_0x0083:
            r8 = r40
        L_0x0085:
            r9 = r12 & 16
            if (r9 == 0) goto L_0x008c
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a1
        L_0x008c:
            r14 = 57344(0xe000, float:8.0356E-41)
            r14 = r14 & r11
            if (r14 != 0) goto L_0x00a1
            r14 = r41
            boolean r15 = r13.changed((int) r14)
            if (r15 == 0) goto L_0x009d
            r15 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009f
        L_0x009d:
            r15 = 8192(0x2000, float:1.14794E-41)
        L_0x009f:
            r0 = r0 | r15
            goto L_0x00a3
        L_0x00a1:
            r14 = r41
        L_0x00a3:
            r15 = r12 & 32
            if (r15 == 0) goto L_0x00ae
            r16 = 196608(0x30000, float:2.75506E-40)
            r0 = r0 | r16
            r1 = r42
            goto L_0x00c3
        L_0x00ae:
            r16 = 458752(0x70000, float:6.42848E-40)
            r16 = r11 & r16
            r1 = r42
            if (r16 != 0) goto L_0x00c3
            boolean r16 = r13.changed((boolean) r1)
            if (r16 == 0) goto L_0x00bf
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c1
        L_0x00bf:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00c1:
            r0 = r0 | r16
        L_0x00c3:
            r16 = r12 & 64
            if (r16 == 0) goto L_0x00ce
            r17 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r17
            r5 = r43
            goto L_0x00e3
        L_0x00ce:
            r17 = 3670016(0x380000, float:5.142788E-39)
            r17 = r11 & r17
            r5 = r43
            if (r17 != 0) goto L_0x00e3
            boolean r18 = r13.changed((int) r5)
            if (r18 == 0) goto L_0x00df
            r18 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e1
        L_0x00df:
            r18 = 524288(0x80000, float:7.34684E-40)
        L_0x00e1:
            r0 = r0 | r18
        L_0x00e3:
            r1 = r12 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x00eb
            r18 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 | r18
        L_0x00eb:
            int r3 = ~r12
            r5 = 128(0x80, float:1.794E-43)
            r3 = r3 & r5
            if (r3 != 0) goto L_0x0112
            r3 = 23967451(0x16db6db, float:4.3661218E-38)
            r3 = r3 & r0
            r5 = 4793490(0x492492, float:6.71711E-39)
            r3 = r3 ^ r5
            if (r3 != 0) goto L_0x0112
            boolean r3 = r13.getSkipping()
            if (r3 != 0) goto L_0x0102
            goto L_0x0112
        L_0x0102:
            r13.skipToGroupEnd()
            r2 = r38
            r7 = r43
            r3 = r6
            r4 = r8
            r5 = r14
            r6 = r42
            r8 = r44
            goto L_0x03c7
        L_0x0112:
            r13.startDefaults()
            r3 = r11 & 1
            r5 = 1
            if (r3 == 0) goto L_0x0139
            boolean r3 = r13.getDefaultsInvalid()
            if (r3 == 0) goto L_0x0121
            goto L_0x0139
        L_0x0121:
            r13.skipToGroupEnd()
            if (r1 == 0) goto L_0x012a
            r1 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r0 = r0 & r1
        L_0x012a:
            r17 = r42
            r18 = r43
            r7 = r0
            r15 = r6
            r9 = r8
            r16 = r14
            r14 = r38
            r8 = r44
            goto L_0x018a
        L_0x0139:
            if (r2 == 0) goto L_0x0140
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x0142
        L_0x0140:
            r2 = r38
        L_0x0142:
            if (r4 == 0) goto L_0x014b
            androidx.compose.ui.text.TextStyle$Companion r3 = androidx.compose.ui.text.TextStyle.Companion
            androidx.compose.ui.text.TextStyle r3 = r3.getDefault()
            r6 = r3
        L_0x014b:
            if (r7 == 0) goto L_0x0152
            androidx.compose.foundation.text.BasicTextKt$BasicText$4 r3 = androidx.compose.foundation.text.BasicTextKt$BasicText$4.INSTANCE
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r8 = r3
        L_0x0152:
            if (r9 == 0) goto L_0x015b
            androidx.compose.ui.text.style.TextOverflow$Companion r3 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r3 = r3.m3788getClipgIe3tQ8()
            r14 = r3
        L_0x015b:
            if (r15 == 0) goto L_0x015f
            r3 = 1
            goto L_0x0161
        L_0x015f:
            r3 = r42
        L_0x0161:
            if (r16 == 0) goto L_0x0167
            r4 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x0169
        L_0x0167:
            r4 = r43
        L_0x0169:
            if (r1 == 0) goto L_0x017e
            java.util.Map r1 = kotlin.collections.MapsKt.emptyMap()
            r7 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r0 = r0 & r7
            r7 = r0
            r17 = r3
            r18 = r4
            r15 = r6
            r9 = r8
            r16 = r14
            r8 = r1
            goto L_0x0189
        L_0x017e:
            r7 = r0
            r17 = r3
            r18 = r4
            r15 = r6
            r9 = r8
            r16 = r14
            r8 = r44
        L_0x0189:
            r14 = r2
        L_0x018a:
            r13.endDefaults()
            r19 = 0
            if (r18 <= 0) goto L_0x0193
            r0 = 1
            goto L_0x0194
        L_0x0193:
            r0 = 0
        L_0x0194:
            if (r0 == 0) goto L_0x03e0
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.foundation.text.selection.SelectionRegistrarKt.getLocalSelectionRegistrar()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r6 = 103361330(0x6292b32, float:3.1817102E-35)
            java.lang.String r4 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r6, r4)
            java.lang.Object r0 = r13.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r3 = r0
            androidx.compose.foundation.text.selection.SelectionRegistrar r3 = (androidx.compose.foundation.text.selection.SelectionRegistrar) r3
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r6, r4)
            java.lang.Object r0 = r13.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r20 = r0
            androidx.compose.ui.unit.Density r20 = (androidx.compose.ui.unit.Density) r20
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalFontLoader()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r6, r4)
            java.lang.Object r0 = r13.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r21 = r0
            androidx.compose.ui.text.font.Font$ResourceLoader r21 = (androidx.compose.ui.text.font.Font.ResourceLoader) r21
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.foundation.text.selection.TextSelectionColorsKt.getLocalTextSelectionColors()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r6, r4)
            java.lang.Object r0 = r13.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.foundation.text.selection.TextSelectionColors r0 = (androidx.compose.foundation.text.selection.TextSelectionColors) r0
            long r1 = r0.m821getBackgroundColor0d7_KjU()
            kotlin.Pair r0 = androidx.compose.foundation.text.CoreTextKt.resolveInlineContent(r10, r8)
            java.lang.Object r22 = r0.component1()
            java.util.List r22 = (java.util.List) r22
            java.lang.Object r0 = r0.component2()
            java.util.List r0 = (java.util.List) r0
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]
            r6[r19] = r10
            r6[r5] = r3
            androidx.compose.runtime.saveable.Saver r24 = selectionIdSaver(r3)
            r25 = 0
            androidx.compose.foundation.text.BasicTextKt$BasicText$selectableId$2 r5 = new androidx.compose.foundation.text.BasicTextKt$BasicText$selectableId$2
            r5.<init>(r3)
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            r26 = 72
            r27 = 4
            r38 = r6
            r39 = r24
            r40 = r25
            r41 = r5
            r42 = r13
            r43 = r26
            r44 = r27
            java.lang.Object r5 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r38, r39, (java.lang.String) r40, r41, (androidx.compose.runtime.Composer) r42, (int) r43, (int) r44)
            java.lang.Number r5 = (java.lang.Number) r5
            long r5 = r5.longValue()
            r38 = r0
            r0 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r13.startReplaceableGroup(r0)
            java.lang.String r0 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r0)
            java.lang.Object r0 = r13.rememberedValue()
            androidx.compose.runtime.Composer$Companion r24 = androidx.compose.runtime.Composer.Companion
            r39 = r1
            java.lang.Object r1 = r24.getEmpty()
            if (r0 != r1) goto L_0x028b
            androidx.compose.foundation.text.TextController r2 = new androidx.compose.foundation.text.TextController
            androidx.compose.foundation.text.TextState r1 = new androidx.compose.foundation.text.TextState
            androidx.compose.foundation.text.TextDelegate r0 = new androidx.compose.foundation.text.TextDelegate
            r24 = 0
            r41 = r38
            r38 = r0
            r28 = r39
            r30 = r1
            r1 = r37
            r31 = r2
            r2 = r15
            r32 = r3
            r3 = r18
            r33 = r4
            r4 = r17
            r34 = r5
            r6 = 1
            r5 = r16
            r6 = r20
            r36 = r7
            r7 = r21
            r23 = r8
            r8 = r22
            r11 = r9
            r9 = r24
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r3 = r38
            r2 = r30
            r0 = r34
            r2.<init>(r3, r0)
            r0 = r31
            r0.<init>(r2)
            r13.updateRememberedValue(r0)
            goto L_0x0298
        L_0x028b:
            r41 = r38
            r28 = r39
            r32 = r3
            r33 = r4
            r36 = r7
            r23 = r8
            r11 = r9
        L_0x0298:
            r13.endReplaceableGroup()
            r9 = r0
            androidx.compose.foundation.text.TextController r9 = (androidx.compose.foundation.text.TextController) r9
            androidx.compose.foundation.text.TextState r8 = r9.getState()
            boolean r0 = r13.getInserting()
            if (r0 != 0) goto L_0x02c4
            androidx.compose.foundation.text.TextDelegate r0 = r8.getTextDelegate()
            r1 = r37
            r2 = r15
            r3 = r20
            r4 = r21
            r5 = r17
            r6 = r16
            r7 = r18
            r12 = r8
            r8 = r22
            androidx.compose.foundation.text.TextDelegate r0 = androidx.compose.foundation.text.CoreTextKt.m639updateTextDelegatex_uQXYA(r0, r1, r2, r3, r4, r5, r6, r7, r8)
            r12.setTextDelegate(r0)
            goto L_0x02c5
        L_0x02c4:
            r12 = r8
        L_0x02c5:
            r12.setOnTextLayout(r11)
            r0 = r28
            r12.m737setSelectionBackgroundColor8_81llA(r0)
            r0 = r32
            r9.update(r0)
            boolean r0 = r41.isEmpty()
            if (r0 == 0) goto L_0x02df
            androidx.compose.foundation.text.ComposableSingletons$BasicTextKt r0 = androidx.compose.foundation.text.ComposableSingletons$BasicTextKt.INSTANCE
            kotlin.jvm.functions.Function2 r0 = r0.m633getLambda1$foundation_release()
            goto L_0x02f2
        L_0x02df:
            r0 = -819900852(0xffffffffcf214e4c, float:-2.70626304E9)
            androidx.compose.foundation.text.BasicTextKt$BasicText$6 r1 = new androidx.compose.foundation.text.BasicTextKt$BasicText$6
            r2 = r41
            r3 = r36
            r1.<init>(r10, r2, r3)
            r2 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r13, r0, r2, r1)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
        L_0x02f2:
            androidx.compose.ui.Modifier r1 = r9.getModifiers()
            androidx.compose.ui.Modifier r1 = r14.then(r1)
            androidx.compose.ui.layout.MeasurePolicy r2 = r9.getMeasurePolicy()
            r3 = 1376089394(0x52057532, float:1.43299215E11)
            r13.startReplaceableGroup(r3)
            java.lang.String r3 = "C(Layout)P(!1,2)72@2847L7,73@2902L7,74@2961L7,75@2973L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r3)
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r4 = r33
            r5 = 103361330(0x6292b32, float:3.1817102E-35)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r5, r4)
            java.lang.Object r3 = r13.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.ui.unit.Density r3 = (androidx.compose.ui.unit.Density) r3
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r5, r4)
            java.lang.Object r6 = r13.consume(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.ui.unit.LayoutDirection r6 = (androidx.compose.ui.unit.LayoutDirection) r6
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r5, r4)
            java.lang.Object r4 = r13.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.ui.platform.ViewConfiguration r4 = (androidx.compose.ui.platform.ViewConfiguration) r4
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r5 = r5.getConstructor()
            kotlin.jvm.functions.Function3 r1 = androidx.compose.ui.layout.LayoutKt.materializerOf(r1)
            androidx.compose.runtime.Applier r7 = r13.getApplier()
            boolean r7 = r7 instanceof androidx.compose.runtime.Applier
            if (r7 != 0) goto L_0x0359
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0359:
            r13.startReusableNode()
            boolean r7 = r13.getInserting()
            if (r7 == 0) goto L_0x0366
            r13.createNode(r5)
            goto L_0x0369
        L_0x0366:
            r13.useNode()
        L_0x0369:
            r13.disableReusing()
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.Updater.m1234constructorimpl(r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r5, r2, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetDensity()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r5, r3, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r5, r6, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r5, r4, r2)
            r13.enableReusing()
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.SkippableUpdater.m1226constructorimpl(r13)
            androidx.compose.runtime.SkippableUpdater r2 = androidx.compose.runtime.SkippableUpdater.m1225boximpl(r2)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r19)
            r1.invoke(r2, r13, r3)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r13.startReplaceableGroup(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r19)
            r0.invoke(r13, r1)
            r13.endReplaceableGroup()
            r13.endNode()
            r13.endReplaceableGroup()
            r4 = r11
            r2 = r14
            r3 = r15
            r5 = r16
            r6 = r17
            r7 = r18
            r8 = r23
        L_0x03c7:
            androidx.compose.runtime.ScopeUpdateScope r11 = r13.endRestartGroup()
            if (r11 != 0) goto L_0x03ce
            goto L_0x03df
        L_0x03ce:
            androidx.compose.foundation.text.BasicTextKt$BasicText$7 r12 = new androidx.compose.foundation.text.BasicTextKt$BasicText$7
            r0 = r12
            r1 = r37
            r9 = r46
            r10 = r47
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r11.updateScope(r12)
        L_0x03df:
            return
        L_0x03e0:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "maxLines should be greater than 0"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextKt.m627BasicText4YKlhWE(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.Modifier, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function1, int, boolean, int, java.util.Map, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final Saver<Long, Long> selectionIdSaver(SelectionRegistrar selectionRegistrar) {
        return SaverKt.Saver(new BasicTextKt$selectionIdSaver$1(selectionRegistrar), BasicTextKt$selectionIdSaver$2.INSTANCE);
    }
}
