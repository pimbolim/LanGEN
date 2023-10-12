package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a¬\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001c\u001af\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001e\u001ab\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u00052\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u001aH\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010 \u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006!"}, d2 = {"Surface", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/ui/graphics/Shape;", "color", "Landroidx/compose/ui/graphics/Color;", "contentColor", "border", "Landroidx/compose/foundation/BorderStroke;", "elevation", "Landroidx/compose/ui/unit/Dp;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indication", "Landroidx/compose/foundation/Indication;", "enabled", "", "onClickLabel", "", "role", "Landroidx/compose/ui/semantics/Role;", "content", "Landroidx/compose/runtime/Composable;", "Surface-9VG74zQ", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/Indication;ZLjava/lang/String;Landroidx/compose/ui/semantics/Role;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "Surface-F-jzlyU", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "clickAndSemanticsModifier", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Surface.kt */
public final class SurfaceKt {
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01c8  */
    /* JADX WARNING: Removed duplicated region for block: B:114:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00fe  */
    /* renamed from: Surface-F-jzlyU  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1125SurfaceFjzlyU(androidx.compose.ui.Modifier r25, androidx.compose.ui.graphics.Shape r26, long r27, long r29, androidx.compose.foundation.BorderStroke r31, float r32, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, androidx.compose.runtime.Composer r34, int r35, int r36) {
        /*
            r12 = r33
            r13 = r35
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = -750968235(0xffffffffd33d2255, float:-8.1232481E11)
            r1 = r34
            androidx.compose.runtime.Composer r14 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(Surface)P(5,6,1:c#ui.graphics.Color,3:c#ui.graphics.Color!1,4:c#ui.unit.Dp)103@5104L6,104@5146L22,109@5274L342:Surface.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r0)
            r0 = r36 & 1
            if (r0 == 0) goto L_0x0021
            r1 = r13 | 6
            r2 = r1
            r1 = r25
            goto L_0x0035
        L_0x0021:
            r1 = r13 & 14
            if (r1 != 0) goto L_0x0032
            r1 = r25
            boolean r2 = r14.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x002f
            r2 = 4
            goto L_0x0030
        L_0x002f:
            r2 = 2
        L_0x0030:
            r2 = r2 | r13
            goto L_0x0035
        L_0x0032:
            r1 = r25
            r2 = r13
        L_0x0035:
            r3 = r36 & 2
            if (r3 == 0) goto L_0x003c
            r2 = r2 | 48
            goto L_0x004f
        L_0x003c:
            r4 = r13 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x004f
            r4 = r26
            boolean r5 = r14.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x004b
            r5 = 32
            goto L_0x004d
        L_0x004b:
            r5 = 16
        L_0x004d:
            r2 = r2 | r5
            goto L_0x0051
        L_0x004f:
            r4 = r26
        L_0x0051:
            r5 = r13 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x006a
            r5 = r36 & 4
            if (r5 != 0) goto L_0x0064
            r5 = r27
            boolean r7 = r14.changed((long) r5)
            if (r7 == 0) goto L_0x0066
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0068
        L_0x0064:
            r5 = r27
        L_0x0066:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0068:
            r2 = r2 | r7
            goto L_0x006c
        L_0x006a:
            r5 = r27
        L_0x006c:
            r7 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x0085
            r7 = r36 & 8
            if (r7 != 0) goto L_0x007f
            r7 = r29
            boolean r9 = r14.changed((long) r7)
            if (r9 == 0) goto L_0x0081
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x0083
        L_0x007f:
            r7 = r29
        L_0x0081:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x0083:
            r2 = r2 | r9
            goto L_0x0087
        L_0x0085:
            r7 = r29
        L_0x0087:
            r9 = r36 & 16
            r10 = 57344(0xe000, float:8.0356E-41)
            if (r9 == 0) goto L_0x0091
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a4
        L_0x0091:
            r11 = r13 & r10
            if (r11 != 0) goto L_0x00a4
            r11 = r31
            boolean r15 = r14.changed((java.lang.Object) r11)
            if (r15 == 0) goto L_0x00a0
            r15 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a2
        L_0x00a0:
            r15 = 8192(0x2000, float:1.14794E-41)
        L_0x00a2:
            r2 = r2 | r15
            goto L_0x00a6
        L_0x00a4:
            r11 = r31
        L_0x00a6:
            r15 = r36 & 32
            r16 = 458752(0x70000, float:6.42848E-40)
            if (r15 == 0) goto L_0x00b3
            r17 = 196608(0x30000, float:2.75506E-40)
            r2 = r2 | r17
            r10 = r32
            goto L_0x00c6
        L_0x00b3:
            r17 = r13 & r16
            r10 = r32
            if (r17 != 0) goto L_0x00c6
            boolean r17 = r14.changed((float) r10)
            if (r17 == 0) goto L_0x00c2
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c4
        L_0x00c2:
            r17 = 65536(0x10000, float:9.18355E-41)
        L_0x00c4:
            r2 = r2 | r17
        L_0x00c6:
            r17 = r36 & 64
            if (r17 == 0) goto L_0x00cf
            r17 = 1572864(0x180000, float:2.204052E-39)
        L_0x00cc:
            r2 = r2 | r17
            goto L_0x00e1
        L_0x00cf:
            r17 = 3670016(0x380000, float:5.142788E-39)
            r17 = r13 & r17
            if (r17 != 0) goto L_0x00e1
            boolean r17 = r14.changed((java.lang.Object) r12)
            if (r17 == 0) goto L_0x00de
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00cc
        L_0x00de:
            r17 = 524288(0x80000, float:7.34684E-40)
            goto L_0x00cc
        L_0x00e1:
            r17 = 2995931(0x2db6db, float:4.198194E-39)
            r17 = r2 & r17
            r18 = 599186(0x92492, float:8.39638E-40)
            r17 = r17 ^ r18
            if (r17 != 0) goto L_0x00fe
            boolean r17 = r14.getSkipping()
            if (r17 != 0) goto L_0x00f4
            goto L_0x00fe
        L_0x00f4:
            r14.skipToGroupEnd()
            r2 = r4
            r3 = r5
            r5 = r7
            r8 = r10
            r7 = r11
            goto L_0x01c1
        L_0x00fe:
            r14.startDefaults()
            r17 = r13 & 1
            r1 = 0
            if (r17 == 0) goto L_0x0129
            boolean r17 = r14.getDefaultsInvalid()
            if (r17 == 0) goto L_0x010d
            goto L_0x0129
        L_0x010d:
            r14.skipToGroupEnd()
            r0 = r36 & 4
            if (r0 == 0) goto L_0x0116
            r2 = r2 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0116:
            r0 = r36 & 8
            if (r0 == 0) goto L_0x011c
            r2 = r2 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x011c:
            r15 = r25
        L_0x011e:
            r17 = r4
            r19 = r5
            r21 = r7
            r24 = r10
        L_0x0126:
            r23 = r11
            goto L_0x016e
        L_0x0129:
            if (r0 == 0) goto L_0x0130
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0132
        L_0x0130:
            r0 = r25
        L_0x0132:
            if (r3 == 0) goto L_0x0139
            androidx.compose.ui.graphics.Shape r3 = androidx.compose.ui.graphics.RectangleShapeKt.getRectangleShape()
            r4 = r3
        L_0x0139:
            r3 = r36 & 4
            if (r3 == 0) goto L_0x014a
            androidx.compose.material.MaterialTheme r3 = androidx.compose.material.MaterialTheme.INSTANCE
            r5 = 6
            androidx.compose.material.Colors r3 = r3.getColors(r14, r5)
            long r5 = r3.m918getSurface0d7_KjU()
            r2 = r2 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x014a:
            r3 = r36 & 8
            if (r3 == 0) goto L_0x0158
            int r3 = r2 >> 6
            r3 = r3 & 14
            long r7 = androidx.compose.material.ColorsKt.m932contentColorForek8zF_U(r5, r14, r3)
            r2 = r2 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0158:
            if (r9 == 0) goto L_0x015b
            r11 = 0
        L_0x015b:
            if (r15 == 0) goto L_0x016c
            float r3 = (float) r1
            float r3 = androidx.compose.ui.unit.Dp.m3859constructorimpl(r3)
            r15 = r0
            r24 = r3
            r17 = r4
            r19 = r5
            r21 = r7
            goto L_0x0126
        L_0x016c:
            r15 = r0
            goto L_0x011e
        L_0x016e:
            r14.endDefaults()
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            androidx.compose.material.SurfaceKt$Surface$1 r3 = androidx.compose.material.SurfaceKt$Surface$1.INSTANCE
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics(r0, r1, r3)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            androidx.compose.material.SurfaceKt$Surface$2 r3 = new androidx.compose.material.SurfaceKt$Surface$2
            r4 = 0
            r3.<init>(r4)
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            androidx.compose.ui.Modifier r8 = androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt.pointerInput((androidx.compose.ui.Modifier) r0, (java.lang.Object) r1, (kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r3)
            r0 = r2 & 14
            r1 = r2 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            r1 = r2 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            r1 = r2 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            r1 = 57344(0xe000, float:8.0356E-41)
            r1 = r1 & r2
            r0 = r0 | r1
            r1 = r2 & r16
            r0 = r0 | r1
            r1 = 29360128(0x1c00000, float:7.052966E-38)
            int r2 = r2 << 3
            r1 = r1 & r2
            r11 = r0 | r1
            r0 = r15
            r1 = r17
            r2 = r19
            r4 = r21
            r6 = r23
            r7 = r24
            r9 = r33
            r10 = r14
            m1124SurfaceFjzlyU((androidx.compose.ui.Modifier) r0, (androidx.compose.ui.graphics.Shape) r1, (long) r2, (long) r4, (androidx.compose.foundation.BorderStroke) r6, (float) r7, (androidx.compose.ui.Modifier) r8, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r9, (androidx.compose.runtime.Composer) r10, (int) r11)
            r1 = r15
            r2 = r17
            r3 = r19
            r5 = r21
            r7 = r23
            r8 = r24
        L_0x01c1:
            androidx.compose.runtime.ScopeUpdateScope r14 = r14.endRestartGroup()
            if (r14 != 0) goto L_0x01c8
            goto L_0x01d9
        L_0x01c8:
            androidx.compose.material.SurfaceKt$Surface$3 r15 = new androidx.compose.material.SurfaceKt$Surface$3
            r0 = r15
            r9 = r33
            r10 = r35
            r11 = r36
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r15 = (kotlin.jvm.functions.Function2) r15
            r14.updateScope(r15)
        L_0x01d9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SurfaceKt.m1125SurfaceFjzlyU(androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, long, long, androidx.compose.foundation.BorderStroke, float, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x016d  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x01cc  */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x0341  */
    /* JADX WARNING: Removed duplicated region for block: B:201:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0132  */
    @androidx.compose.material.ExperimentalMaterialApi
    /* renamed from: Surface-9VG74zQ  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1123Surface9VG74zQ(kotlin.jvm.functions.Function0<kotlin.Unit> r28, androidx.compose.ui.Modifier r29, androidx.compose.ui.graphics.Shape r30, long r31, long r33, androidx.compose.foundation.BorderStroke r35, float r36, androidx.compose.foundation.interaction.MutableInteractionSource r37, androidx.compose.foundation.Indication r38, boolean r39, java.lang.String r40, androidx.compose.ui.semantics.Role r41, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r42, androidx.compose.runtime.Composer r43, int r44, int r45, int r46) {
        /*
            r1 = r28
            r15 = r42
            r14 = r44
            r13 = r45
            r12 = r46
            java.lang.String r0 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            r0 = -750962911(0xffffffffd33d3721, float:-8.1267373E11)
            r2 = r43
            androidx.compose.runtime.Composer r0 = r2.startRestartGroup(r0)
            java.lang.String r2 = "C(Surface)P(9,8,12,1:c#ui.graphics.Color,3:c#ui.graphics.Color!1,4:c#ui.unit.Dp,7,6,5,10,11:c#ui.semantics.Role)203@10453L6,204@10495L22,207@10629L39,208@10716L7,214@10856L515:Surface.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r2)
            r2 = r12 & 1
            if (r2 == 0) goto L_0x0029
            r2 = r14 | 6
            goto L_0x0039
        L_0x0029:
            r2 = r14 & 14
            if (r2 != 0) goto L_0x0038
            boolean r2 = r0.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x0035
            r2 = 4
            goto L_0x0036
        L_0x0035:
            r2 = 2
        L_0x0036:
            r2 = r2 | r14
            goto L_0x0039
        L_0x0038:
            r2 = r14
        L_0x0039:
            r5 = r12 & 2
            if (r5 == 0) goto L_0x0040
            r2 = r2 | 48
            goto L_0x0053
        L_0x0040:
            r8 = r14 & 112(0x70, float:1.57E-43)
            if (r8 != 0) goto L_0x0053
            r8 = r29
            boolean r9 = r0.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x004f
            r9 = 32
            goto L_0x0051
        L_0x004f:
            r9 = 16
        L_0x0051:
            r2 = r2 | r9
            goto L_0x0055
        L_0x0053:
            r8 = r29
        L_0x0055:
            r9 = r12 & 4
            if (r9 == 0) goto L_0x005c
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0070
        L_0x005c:
            r3 = r14 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x0070
            r3 = r30
            boolean r16 = r0.changed((java.lang.Object) r3)
            if (r16 == 0) goto L_0x006b
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x006d
        L_0x006b:
            r16 = 128(0x80, float:1.794E-43)
        L_0x006d:
            r2 = r2 | r16
            goto L_0x0072
        L_0x0070:
            r3 = r30
        L_0x0072:
            r4 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x008a
            r4 = r12 & 8
            r6 = r31
            if (r4 != 0) goto L_0x0085
            boolean r18 = r0.changed((long) r6)
            if (r18 == 0) goto L_0x0085
            r18 = 2048(0x800, float:2.87E-42)
            goto L_0x0087
        L_0x0085:
            r18 = 1024(0x400, float:1.435E-42)
        L_0x0087:
            r2 = r2 | r18
            goto L_0x008c
        L_0x008a:
            r6 = r31
        L_0x008c:
            r18 = 57344(0xe000, float:8.0356E-41)
            r19 = r14 & r18
            if (r19 != 0) goto L_0x00a7
            r19 = r12 & 16
            r10 = r33
            if (r19 != 0) goto L_0x00a2
            boolean r21 = r0.changed((long) r10)
            if (r21 == 0) goto L_0x00a2
            r21 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a4
        L_0x00a2:
            r21 = 8192(0x2000, float:1.14794E-41)
        L_0x00a4:
            r2 = r2 | r21
            goto L_0x00a9
        L_0x00a7:
            r10 = r33
        L_0x00a9:
            r21 = r12 & 32
            r22 = 458752(0x70000, float:6.42848E-40)
            if (r21 == 0) goto L_0x00b6
            r23 = 196608(0x30000, float:2.75506E-40)
            r2 = r2 | r23
            r4 = r35
            goto L_0x00c9
        L_0x00b6:
            r23 = r14 & r22
            r4 = r35
            if (r23 != 0) goto L_0x00c9
            boolean r24 = r0.changed((java.lang.Object) r4)
            if (r24 == 0) goto L_0x00c5
            r24 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c7
        L_0x00c5:
            r24 = 65536(0x10000, float:9.18355E-41)
        L_0x00c7:
            r2 = r2 | r24
        L_0x00c9:
            r24 = r12 & 64
            if (r24 == 0) goto L_0x00d4
            r25 = 1572864(0x180000, float:2.204052E-39)
            r2 = r2 | r25
            r1 = r36
            goto L_0x00e9
        L_0x00d4:
            r25 = 3670016(0x380000, float:5.142788E-39)
            r25 = r14 & r25
            r1 = r36
            if (r25 != 0) goto L_0x00e9
            boolean r25 = r0.changed((float) r1)
            if (r25 == 0) goto L_0x00e5
            r25 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e7
        L_0x00e5:
            r25 = 524288(0x80000, float:7.34684E-40)
        L_0x00e7:
            r2 = r2 | r25
        L_0x00e9:
            r1 = r12 & 128(0x80, float:1.794E-43)
            r25 = 29360128(0x1c00000, float:7.052966E-38)
            if (r1 == 0) goto L_0x00f6
            r26 = 12582912(0xc00000, float:1.7632415E-38)
            r2 = r2 | r26
            r3 = r37
            goto L_0x0109
        L_0x00f6:
            r26 = r14 & r25
            r3 = r37
            if (r26 != 0) goto L_0x0109
            boolean r26 = r0.changed((java.lang.Object) r3)
            if (r26 == 0) goto L_0x0105
            r26 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0107
        L_0x0105:
            r26 = 4194304(0x400000, float:5.877472E-39)
        L_0x0107:
            r2 = r2 | r26
        L_0x0109:
            r26 = 234881024(0xe000000, float:1.5777218E-30)
            r26 = r14 & r26
            if (r26 != 0) goto L_0x0125
            r3 = r12 & 256(0x100, float:3.59E-43)
            if (r3 != 0) goto L_0x011e
            r3 = r38
            boolean r26 = r0.changed((java.lang.Object) r3)
            if (r26 == 0) goto L_0x0120
            r26 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0122
        L_0x011e:
            r3 = r38
        L_0x0120:
            r26 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0122:
            r2 = r2 | r26
            goto L_0x0127
        L_0x0125:
            r3 = r38
        L_0x0127:
            r3 = r12 & 512(0x200, float:7.175E-43)
            if (r3 == 0) goto L_0x0132
            r26 = 805306368(0x30000000, float:4.656613E-10)
            r2 = r2 | r26
            r4 = r39
            goto L_0x0147
        L_0x0132:
            r26 = 1879048192(0x70000000, float:1.58456325E29)
            r26 = r14 & r26
            r4 = r39
            if (r26 != 0) goto L_0x0147
            boolean r26 = r0.changed((boolean) r4)
            if (r26 == 0) goto L_0x0143
            r26 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0145
        L_0x0143:
            r26 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0145:
            r2 = r2 | r26
        L_0x0147:
            r4 = r12 & 1024(0x400, float:1.435E-42)
            if (r4 == 0) goto L_0x0150
            r16 = r13 | 6
            r6 = r40
            goto L_0x0166
        L_0x0150:
            r26 = r13 & 14
            r6 = r40
            if (r26 != 0) goto L_0x0164
            boolean r7 = r0.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x015f
            r16 = 4
            goto L_0x0161
        L_0x015f:
            r16 = 2
        L_0x0161:
            r16 = r13 | r16
            goto L_0x0166
        L_0x0164:
            r16 = r13
        L_0x0166:
            r7 = r12 & 2048(0x800, float:2.87E-42)
            if (r7 == 0) goto L_0x016d
            r16 = r16 | 48
            goto L_0x0180
        L_0x016d:
            r26 = r13 & 112(0x70, float:1.57E-43)
            r6 = r41
            if (r26 != 0) goto L_0x0180
            boolean r26 = r0.changed((java.lang.Object) r6)
            if (r26 == 0) goto L_0x017c
            r17 = 32
            goto L_0x017e
        L_0x017c:
            r17 = 16
        L_0x017e:
            r16 = r16 | r17
        L_0x0180:
            r6 = r16
            r8 = r12 & 4096(0x1000, float:5.74E-42)
            if (r8 == 0) goto L_0x0189
            r6 = r6 | 384(0x180, float:5.38E-43)
            goto L_0x019a
        L_0x0189:
            r8 = r13 & 896(0x380, float:1.256E-42)
            if (r8 != 0) goto L_0x019a
            boolean r8 = r0.changed((java.lang.Object) r15)
            if (r8 == 0) goto L_0x0196
            r19 = 256(0x100, float:3.59E-43)
            goto L_0x0198
        L_0x0196:
            r19 = 128(0x80, float:1.794E-43)
        L_0x0198:
            r6 = r6 | r19
        L_0x019a:
            r8 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r8 = r8 & r2
            r16 = 306783378(0x12492492, float:6.3469493E-28)
            r8 = r8 ^ r16
            if (r8 != 0) goto L_0x01cc
            r8 = r6 & 731(0x2db, float:1.024E-42)
            r8 = r8 ^ 146(0x92, float:2.05E-43)
            if (r8 != 0) goto L_0x01cc
            boolean r8 = r0.getSkipping()
            if (r8 != 0) goto L_0x01b2
            goto L_0x01cc
        L_0x01b2:
            r0.skipToGroupEnd()
            r2 = r29
            r3 = r30
            r4 = r31
            r8 = r35
            r9 = r36
            r16 = r39
            r17 = r40
            r18 = r41
            r6 = r10
            r10 = r37
            r11 = r38
            goto L_0x033a
        L_0x01cc:
            r0.startDefaults()
            r8 = r14 & 1
            r16 = 0
            if (r8 == 0) goto L_0x020d
            boolean r8 = r0.getDefaultsInvalid()
            if (r8 == 0) goto L_0x01dc
            goto L_0x020d
        L_0x01dc:
            r0.skipToGroupEnd()
            r1 = r12 & 8
            if (r1 == 0) goto L_0x01e5
            r2 = r2 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x01e5:
            r1 = r12 & 16
            if (r1 == 0) goto L_0x01ed
            r1 = -57345(0xffffffffffff1fff, float:NaN)
            r2 = r2 & r1
        L_0x01ed:
            r1 = r12 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x01f5
            r1 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r2 = r2 & r1
        L_0x01f5:
            r1 = r29
            r19 = r31
            r3 = r35
            r4 = r36
            r5 = r37
            r7 = r38
            r8 = r39
            r9 = r40
            r16 = r41
            r17 = r2
            r2 = r30
            goto L_0x02d8
        L_0x020d:
            if (r5 == 0) goto L_0x0214
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            goto L_0x0216
        L_0x0214:
            r5 = r29
        L_0x0216:
            if (r9 == 0) goto L_0x021d
            androidx.compose.ui.graphics.Shape r8 = androidx.compose.ui.graphics.RectangleShapeKt.getRectangleShape()
            goto L_0x021f
        L_0x021d:
            r8 = r30
        L_0x021f:
            r9 = r12 & 8
            if (r9 == 0) goto L_0x0237
            androidx.compose.material.MaterialTheme r9 = androidx.compose.material.MaterialTheme.INSTANCE
            r29 = r5
            r5 = 6
            androidx.compose.material.Colors r5 = r9.getColors(r0, r5)
            long r19 = r5.m918getSurface0d7_KjU()
            r2 = r2 & -7169(0xffffffffffffe3ff, float:NaN)
            r30 = r8
            r8 = r19
            goto L_0x023d
        L_0x0237:
            r29 = r5
            r30 = r8
            r8 = r31
        L_0x023d:
            r5 = r12 & 16
            if (r5 == 0) goto L_0x024d
            int r5 = r2 >> 9
            r5 = r5 & 14
            long r10 = androidx.compose.material.ColorsKt.m932contentColorForek8zF_U(r8, r0, r5)
            r5 = -57345(0xffffffffffff1fff, float:NaN)
            r2 = r2 & r5
        L_0x024d:
            if (r21 == 0) goto L_0x0252
            r5 = r16
            goto L_0x0254
        L_0x0252:
            r5 = r35
        L_0x0254:
            r31 = r5
            if (r24 == 0) goto L_0x025f
            r5 = 0
            float r5 = (float) r5
            float r5 = androidx.compose.ui.unit.Dp.m3859constructorimpl(r5)
            goto L_0x0261
        L_0x025f:
            r5 = r36
        L_0x0261:
            if (r1 == 0) goto L_0x0289
            r1 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r0.startReplaceableGroup(r1)
            java.lang.String r1 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            java.lang.Object r1 = r0.rememberedValue()
            androidx.compose.runtime.Composer$Companion r17 = androidx.compose.runtime.Composer.Companion
            r32 = r5
            java.lang.Object r5 = r17.getEmpty()
            if (r1 != r5) goto L_0x0283
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r0.updateRememberedValue(r1)
        L_0x0283:
            r0.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = (androidx.compose.foundation.interaction.MutableInteractionSource) r1
            goto L_0x028d
        L_0x0289:
            r32 = r5
            r1 = r37
        L_0x028d:
            r5 = r12 & 256(0x100, float:3.59E-43)
            if (r5 == 0) goto L_0x02b1
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.foundation.IndicationKt.getLocalIndication()
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            r33 = r1
            r1 = 103361330(0x6292b32, float:3.1817102E-35)
            r19 = r8
            java.lang.String r8 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r1, r8)
            java.lang.Object r1 = r0.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.foundation.Indication r1 = (androidx.compose.foundation.Indication) r1
            r5 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r2 = r2 & r5
            goto L_0x02b7
        L_0x02b1:
            r33 = r1
            r19 = r8
            r1 = r38
        L_0x02b7:
            if (r3 == 0) goto L_0x02bb
            r3 = 1
            goto L_0x02bd
        L_0x02bb:
            r3 = r39
        L_0x02bd:
            if (r4 == 0) goto L_0x02c2
            r4 = r16
            goto L_0x02c4
        L_0x02c2:
            r4 = r40
        L_0x02c4:
            r5 = r33
            if (r7 == 0) goto L_0x02c9
            goto L_0x02cb
        L_0x02c9:
            r16 = r41
        L_0x02cb:
            r7 = r1
            r17 = r2
            r8 = r3
            r9 = r4
            r1 = r29
            r2 = r30
            r3 = r31
            r4 = r32
        L_0x02d8:
            r0.endDefaults()
            androidx.compose.ui.Modifier r21 = androidx.compose.material.TouchTargetKt.minimumTouchTargetSize(r1)
            androidx.compose.ui.Modifier$Companion r23 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r23 = (androidx.compose.ui.Modifier) r23
            r29 = r23
            r30 = r5
            r31 = r7
            r32 = r8
            r33 = r9
            r34 = r16
            r35 = r28
            androidx.compose.ui.Modifier r23 = androidx.compose.foundation.ClickableKt.m177clickableO2vRcR0(r29, r30, r31, r32, r33, r34, r35)
            r41 = r1
            int r1 = r17 >> 3
            r17 = r1 & 112(0x70, float:1.57E-43)
            r43 = r5
            r5 = r1 & 896(0x380, float:1.256E-42)
            r5 = r17 | r5
            r17 = r7
            r7 = r1 & 7168(0x1c00, float:1.0045E-41)
            r5 = r5 | r7
            r7 = r1 & r18
            r5 = r5 | r7
            r1 = r1 & r22
            r1 = r1 | r5
            int r5 = r6 << 15
            r5 = r5 & r25
            r1 = r1 | r5
            r29 = r21
            r30 = r2
            r31 = r19
            r33 = r10
            r35 = r3
            r36 = r4
            r37 = r23
            r38 = r42
            r39 = r0
            r40 = r1
            m1124SurfaceFjzlyU((androidx.compose.ui.Modifier) r29, (androidx.compose.ui.graphics.Shape) r30, (long) r31, (long) r33, (androidx.compose.foundation.BorderStroke) r35, (float) r36, (androidx.compose.ui.Modifier) r37, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r38, (androidx.compose.runtime.Composer) r39, (int) r40)
            r6 = r10
            r18 = r16
            r11 = r17
            r10 = r43
            r16 = r8
            r17 = r9
            r8 = r3
            r9 = r4
            r4 = r19
            r3 = r2
            r2 = r41
        L_0x033a:
            androidx.compose.runtime.ScopeUpdateScope r1 = r0.endRestartGroup()
            if (r1 != 0) goto L_0x0341
            goto L_0x0363
        L_0x0341:
            androidx.compose.material.SurfaceKt$Surface$5 r19 = new androidx.compose.material.SurfaceKt$Surface$5
            r0 = r19
            r27 = r1
            r1 = r28
            r12 = r16
            r13 = r17
            r14 = r18
            r15 = r42
            r16 = r44
            r17 = r45
            r18 = r46
            r0.<init>(r1, r2, r3, r4, r6, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r0 = r19
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r27
            r1.updateScope(r0)
        L_0x0363:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SurfaceKt.m1123Surface9VG74zQ(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, long, long, androidx.compose.foundation.BorderStroke, float, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.foundation.Indication, boolean, java.lang.String, androidx.compose.ui.semantics.Role, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: Surface-F-jzlyU  reason: not valid java name */
    public static final void m1124SurfaceFjzlyU(Modifier modifier, Shape shape, long j, long j2, BorderStroke borderStroke, float f, Modifier modifier2, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        int i2;
        Composer composer2;
        long j3 = j;
        float f2 = f;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(-750961828);
        ComposerKt.sourceInformation(startRestartGroup, "C(Surface)P(6,7,2:c#ui.graphics.Color,4:c#ui.graphics.Color!1,5:c#ui.unit.Dp)244@11669L7,*245@11728L7,246@11801L6,251@11941L616:Surface.kt#jmzs0o");
        Modifier modifier3 = modifier;
        if ((i3 & 14) == 0) {
            i2 = (startRestartGroup.changed((Object) modifier3) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        Shape shape2 = shape;
        if ((i3 & 112) == 0) {
            i2 |= startRestartGroup.changed((Object) shape2) ? 32 : 16;
        }
        if ((i3 & 896) == 0) {
            i2 |= startRestartGroup.changed(j3) ? 256 : 128;
        }
        long j4 = j2;
        if ((i3 & 7168) == 0) {
            i2 |= startRestartGroup.changed(j4) ? 2048 : 1024;
        }
        BorderStroke borderStroke2 = borderStroke;
        if ((57344 & i3) == 0) {
            i2 |= startRestartGroup.changed((Object) borderStroke2) ? 16384 : 8192;
        }
        if ((458752 & i3) == 0) {
            i2 |= startRestartGroup.changed(f2) ? 131072 : 65536;
        }
        Modifier modifier4 = modifier2;
        if ((3670016 & i3) == 0) {
            i2 |= startRestartGroup.changed((Object) modifier4) ? 1048576 : 524288;
        }
        Function2<? super Composer, ? super Integer, Unit> function22 = function2;
        if ((29360128 & i3) == 0) {
            i2 |= startRestartGroup.changed((Object) function22) ? 8388608 : 4194304;
        }
        int i4 = i2;
        if (((i4 & 23967451) ^ 4793490) != 0 || !startRestartGroup.getSkipping()) {
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(ElevationOverlayKt.getLocalElevationOverlay());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ElevationOverlay elevationOverlay = (ElevationOverlay) consume;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = startRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            float r8 = Dp.m3859constructorimpl(((Dp) consume2).m3873unboximpl() + f2);
            startRestartGroup.startReplaceableGroup(-750961449);
            ComposerKt.sourceInformation(startRestartGroup, "247@11872L31");
            long r0 = (!Color.m1597equalsimpl0(j3, MaterialTheme.INSTANCE.getColors(startRestartGroup, 6).m918getSurface0d7_KjU()) || elevationOverlay == null) ? j3 : elevationOverlay.m982apply7g2Lkgo(j, r8, startRestartGroup, (i4 >> 6) & 14);
            startRestartGroup.endReplaceableGroup();
            composer2 = startRestartGroup;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m1586boximpl(j2)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m3857boximpl(r8))}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer2, -819902018, true, new SurfaceKt$Surface$6(modifier, f, shape, borderStroke, r0, modifier2, function2, i4)), composer2, 56);
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SurfaceKt$Surface$7(modifier, shape, j, j2, borderStroke, f, modifier2, function2, i));
        }
    }
}
