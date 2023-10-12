package androidx.compose.material;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;

@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001ae\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00072\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\n0\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001a\u001aq\u0010\u001b\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\n0\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u0001\u0010\u001f\u001a\u00020\n2\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\n0!¢\u0006\u0002\b\u00172\b\b\u0002\u0010\u0013\u001a\u00020\u00072\u0015\b\u0002\u0010\"\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010!¢\u0006\u0002\b\u00172\u001e\b\u0002\u0010#\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\n0\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u0001H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010%\u001ae\u0010\u001f\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\n0\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b&\u0010'\u001a\u0019\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020)H\b\u001a,\u0010,\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)0-2\u0006\u0010.\u001a\u00020)2\u0006\u0010+\u001a\u00020)2\u0006\u0010/\u001a\u00020)H\u0000\u001a\u0011\u00100\u001a\u00020)2\u0006\u00101\u001a\u00020)H\b\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0005\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00062"}, d2 = {"AppBarHeight", "Landroidx/compose/ui/unit/Dp;", "F", "AppBarHorizontalPadding", "BottomAppBarCutoutOffset", "BottomAppBarRoundedEdgeRadius", "TitleIconModifier", "Landroidx/compose/ui/Modifier;", "TitleInsetWithoutIcon", "AppBar", "", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "shape", "Landroidx/compose/ui/graphics/Shape;", "modifier", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "AppBar-celAv9A", "(JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomAppBar", "cutoutShape", "BottomAppBar-Y1yfwus", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/graphics/Shape;FLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "TopAppBar", "title", "Lkotlin/Function0;", "navigationIcon", "actions", "TopAppBar-xWeB9-s", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;JJFLandroidx/compose/runtime/Composer;II)V", "TopAppBar-HsRjFd4", "(Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "calculateCutoutCircleYIntercept", "", "cutoutRadius", "verticalOffset", "calculateRoundedEdgeIntercept", "Lkotlin/Pair;", "controlPointX", "radius", "square", "x", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: AppBar.kt */
public final class AppBarKt {
    /* access modifiers changed from: private */
    public static final float AppBarHeight = Dp.m3859constructorimpl((float) 56);
    /* access modifiers changed from: private */
    public static final float AppBarHorizontalPadding;
    /* access modifiers changed from: private */
    public static final float BottomAppBarCutoutOffset = Dp.m3859constructorimpl((float) 8);
    /* access modifiers changed from: private */
    public static final float BottomAppBarRoundedEdgeRadius;
    /* access modifiers changed from: private */
    public static final Modifier TitleIconModifier;
    /* access modifiers changed from: private */
    public static final Modifier TitleInsetWithoutIcon;

    private static final float square(float f) {
        return f * f;
    }

    /* JADX WARNING: Removed duplicated region for block: B:109:0x01ae  */
    /* JADX WARNING: Removed duplicated region for block: B:111:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00f8  */
    /* renamed from: TopAppBar-xWeB9-s  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m835TopAppBarxWeB9s(kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r27, androidx.compose.ui.Modifier r28, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, long r31, long r33, float r35, androidx.compose.runtime.Composer r36, int r37, int r38) {
        /*
            r1 = r27
            r10 = r37
            java.lang.String r0 = "title"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            r0 = 404499380(0x181c2bb4, float:2.0184592E-24)
            r2 = r36
            androidx.compose.runtime.Composer r0 = r2.startRestartGroup(r0)
            java.lang.String r2 = "C(TopAppBar)P(6,4,5!1,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.unit.Dp)81@3902L6,82@3951L32,85@4047L1254:AppBar.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r2)
            r2 = r38 & 1
            if (r2 == 0) goto L_0x001f
            r2 = r10 | 6
            goto L_0x002f
        L_0x001f:
            r2 = r10 & 14
            if (r2 != 0) goto L_0x002e
            boolean r2 = r0.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x002b
            r2 = 4
            goto L_0x002c
        L_0x002b:
            r2 = 2
        L_0x002c:
            r2 = r2 | r10
            goto L_0x002f
        L_0x002e:
            r2 = r10
        L_0x002f:
            r3 = r38 & 2
            if (r3 == 0) goto L_0x0036
            r2 = r2 | 48
            goto L_0x0049
        L_0x0036:
            r4 = r10 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x0049
            r4 = r28
            boolean r5 = r0.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0045
            r5 = 32
            goto L_0x0047
        L_0x0045:
            r5 = 16
        L_0x0047:
            r2 = r2 | r5
            goto L_0x004b
        L_0x0049:
            r4 = r28
        L_0x004b:
            r5 = r38 & 4
            if (r5 == 0) goto L_0x0052
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0065
        L_0x0052:
            r6 = r10 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x0065
            r6 = r29
            boolean r7 = r0.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0061
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0063
        L_0x0061:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0063:
            r2 = r2 | r7
            goto L_0x0067
        L_0x0065:
            r6 = r29
        L_0x0067:
            r7 = r38 & 8
            if (r7 == 0) goto L_0x006e
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x0081
        L_0x006e:
            r8 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x0081
            r8 = r30
            boolean r9 = r0.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x007d
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x007f
        L_0x007d:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x007f:
            r2 = r2 | r9
            goto L_0x0083
        L_0x0081:
            r8 = r30
        L_0x0083:
            r9 = 57344(0xe000, float:8.0356E-41)
            r9 = r9 & r10
            if (r9 != 0) goto L_0x009c
            r9 = r38 & 16
            r11 = r31
            if (r9 != 0) goto L_0x0098
            boolean r9 = r0.changed((long) r11)
            if (r9 == 0) goto L_0x0098
            r9 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009a
        L_0x0098:
            r9 = 8192(0x2000, float:1.14794E-41)
        L_0x009a:
            r2 = r2 | r9
            goto L_0x009e
        L_0x009c:
            r11 = r31
        L_0x009e:
            r9 = 458752(0x70000, float:6.42848E-40)
            r13 = r10 & r9
            if (r13 != 0) goto L_0x00b9
            r13 = r38 & 32
            if (r13 != 0) goto L_0x00b3
            r13 = r33
            boolean r15 = r0.changed((long) r13)
            if (r15 == 0) goto L_0x00b5
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b7
        L_0x00b3:
            r13 = r33
        L_0x00b5:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00b7:
            r2 = r2 | r15
            goto L_0x00bb
        L_0x00b9:
            r13 = r33
        L_0x00bb:
            r15 = r38 & 64
            if (r15 == 0) goto L_0x00c6
            r16 = 1572864(0x180000, float:2.204052E-39)
            r2 = r2 | r16
            r9 = r35
            goto L_0x00db
        L_0x00c6:
            r16 = 3670016(0x380000, float:5.142788E-39)
            r16 = r10 & r16
            r9 = r35
            if (r16 != 0) goto L_0x00db
            boolean r16 = r0.changed((float) r9)
            if (r16 == 0) goto L_0x00d7
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d9
        L_0x00d7:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00d9:
            r2 = r2 | r16
        L_0x00db:
            r16 = 2995931(0x2db6db, float:4.198194E-39)
            r16 = r2 & r16
            r17 = 599186(0x92492, float:8.39638E-40)
            r16 = r16 ^ r17
            if (r16 != 0) goto L_0x00f8
            boolean r16 = r0.getSkipping()
            if (r16 != 0) goto L_0x00ee
            goto L_0x00f8
        L_0x00ee:
            r0.skipToGroupEnd()
            r2 = r4
            r3 = r6
            r4 = r8
            r5 = r11
            r7 = r13
            goto L_0x01a7
        L_0x00f8:
            r0.startDefaults()
            r16 = r10 & 1
            r17 = -458753(0xfffffffffff8ffff, float:NaN)
            r18 = -57345(0xffffffffffff1fff, float:NaN)
            if (r16 == 0) goto L_0x0120
            boolean r16 = r0.getDefaultsInvalid()
            if (r16 == 0) goto L_0x010c
            goto L_0x0120
        L_0x010c:
            r0.skipToGroupEnd()
            r3 = r38 & 16
            if (r3 == 0) goto L_0x0115
            r2 = r2 & r18
        L_0x0115:
            r3 = r38 & 32
            if (r3 == 0) goto L_0x011b
            r2 = r2 & r17
        L_0x011b:
            r5 = r2
        L_0x011c:
            r2 = r11
            r23 = r13
            goto L_0x015e
        L_0x0120:
            if (r3 == 0) goto L_0x0127
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            r4 = r3
        L_0x0127:
            if (r5 == 0) goto L_0x012b
            r3 = 0
            r6 = r3
        L_0x012b:
            if (r7 == 0) goto L_0x0134
            androidx.compose.material.ComposableSingletons$AppBarKt r3 = androidx.compose.material.ComposableSingletons$AppBarKt.INSTANCE
            kotlin.jvm.functions.Function3 r3 = r3.m937getLambda1$material_release()
            r8 = r3
        L_0x0134:
            r3 = r38 & 16
            if (r3 == 0) goto L_0x0145
            androidx.compose.material.MaterialTheme r3 = androidx.compose.material.MaterialTheme.INSTANCE
            r5 = 6
            androidx.compose.material.Colors r3 = r3.getColors(r0, r5)
            long r11 = androidx.compose.material.ColorsKt.getPrimarySurface(r3)
            r2 = r2 & r18
        L_0x0145:
            r3 = r38 & 32
            if (r3 == 0) goto L_0x0153
            int r3 = r2 >> 12
            r3 = r3 & 14
            long r13 = androidx.compose.material.ColorsKt.m932contentColorForek8zF_U(r11, r0, r3)
            r2 = r2 & r17
        L_0x0153:
            if (r15 == 0) goto L_0x011b
            androidx.compose.material.AppBarDefaults r3 = androidx.compose.material.AppBarDefaults.INSTANCE
            float r3 = r3.m831getTopAppBarElevationD9Ej5fM()
            r5 = r2
            r9 = r3
            goto L_0x011c
        L_0x015e:
            r0.endDefaults()
            androidx.compose.material.AppBarDefaults r7 = androidx.compose.material.AppBarDefaults.INSTANCE
            androidx.compose.foundation.layout.PaddingValues r16 = r7.getContentPadding()
            androidx.compose.ui.graphics.Shape r17 = androidx.compose.ui.graphics.RectangleShapeKt.getRectangleShape()
            r7 = -819890463(0xffffffffcf2176e1, float:-2.70892262E9)
            androidx.compose.material.AppBarKt$TopAppBar$1 r11 = new androidx.compose.material.AppBarKt$TopAppBar$1
            r11.<init>(r6, r5, r1, r8)
            r12 = 1
            androidx.compose.runtime.internal.ComposableLambda r7 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r7, r12, r11)
            r19 = r7
            kotlin.jvm.functions.Function3 r19 = (kotlin.jvm.functions.Function3) r19
            r7 = 1600512(0x186c00, float:2.242795E-39)
            int r11 = r5 >> 12
            r12 = r11 & 14
            r7 = r7 | r12
            r12 = r11 & 112(0x70, float:1.57E-43)
            r7 = r7 | r12
            r11 = r11 & 896(0x380, float:1.256E-42)
            r7 = r7 | r11
            int r5 = r5 << 12
            r11 = 458752(0x70000, float:6.42848E-40)
            r5 = r5 & r11
            r21 = r7 | r5
            r22 = 0
            r11 = r2
            r13 = r23
            r15 = r9
            r18 = r4
            r20 = r0
            m832AppBarcelAv9A(r11, r13, r15, r16, r17, r18, r19, r20, r21, r22)
            r25 = r2
            r2 = r4
            r3 = r6
            r4 = r8
            r7 = r23
            r5 = r25
        L_0x01a7:
            androidx.compose.runtime.ScopeUpdateScope r12 = r0.endRestartGroup()
            if (r12 != 0) goto L_0x01ae
            goto L_0x01bf
        L_0x01ae:
            androidx.compose.material.AppBarKt$TopAppBar$2 r13 = new androidx.compose.material.AppBarKt$TopAppBar$2
            r0 = r13
            r1 = r27
            r10 = r37
            r11 = r38
            r0.<init>(r1, r2, r3, r4, r5, r7, r9, r10, r11)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r12.updateScope(r13)
        L_0x01bf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.AppBarKt.m835TopAppBarxWeB9s(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, long, long, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x018c  */
    /* renamed from: TopAppBar-HsRjFd4  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m834TopAppBarHsRjFd4(androidx.compose.ui.Modifier r23, long r24, long r26, float r28, androidx.compose.foundation.layout.PaddingValues r29, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, androidx.compose.runtime.Composer r31, int r32, int r33) {
        /*
            r12 = r30
            r13 = r32
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = 404502591(0x181c383f, float:2.0190924E-24)
            r1 = r31
            androidx.compose.runtime.Composer r14 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(TopAppBar)P(5,0:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp,3)156@6973L6,157@7022L32,162@7231L182:AppBar.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r0)
            r0 = r33 & 1
            if (r0 == 0) goto L_0x0021
            r1 = r13 | 6
            r2 = r1
            r1 = r23
            goto L_0x0035
        L_0x0021:
            r1 = r13 & 14
            if (r1 != 0) goto L_0x0032
            r1 = r23
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
            r1 = r23
            r2 = r13
        L_0x0035:
            r3 = r13 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x004e
            r3 = r33 & 2
            if (r3 != 0) goto L_0x0048
            r3 = r24
            boolean r5 = r14.changed((long) r3)
            if (r5 == 0) goto L_0x004a
            r5 = 32
            goto L_0x004c
        L_0x0048:
            r3 = r24
        L_0x004a:
            r5 = 16
        L_0x004c:
            r2 = r2 | r5
            goto L_0x0050
        L_0x004e:
            r3 = r24
        L_0x0050:
            r5 = r13 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x0069
            r5 = r33 & 4
            if (r5 != 0) goto L_0x0063
            r5 = r26
            boolean r7 = r14.changed((long) r5)
            if (r7 == 0) goto L_0x0065
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0067
        L_0x0063:
            r5 = r26
        L_0x0065:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0067:
            r2 = r2 | r7
            goto L_0x006b
        L_0x0069:
            r5 = r26
        L_0x006b:
            r7 = r33 & 8
            if (r7 == 0) goto L_0x0072
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x0085
        L_0x0072:
            r8 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x0085
            r8 = r28
            boolean r9 = r14.changed((float) r8)
            if (r9 == 0) goto L_0x0081
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x0083
        L_0x0081:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x0083:
            r2 = r2 | r9
            goto L_0x0087
        L_0x0085:
            r8 = r28
        L_0x0087:
            r9 = r33 & 16
            if (r9 == 0) goto L_0x008e
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a3
        L_0x008e:
            r10 = 57344(0xe000, float:8.0356E-41)
            r10 = r10 & r13
            if (r10 != 0) goto L_0x00a3
            r10 = r29
            boolean r11 = r14.changed((java.lang.Object) r10)
            if (r11 == 0) goto L_0x009f
            r11 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a1
        L_0x009f:
            r11 = 8192(0x2000, float:1.14794E-41)
        L_0x00a1:
            r2 = r2 | r11
            goto L_0x00a5
        L_0x00a3:
            r10 = r29
        L_0x00a5:
            r11 = r33 & 32
            r15 = 458752(0x70000, float:6.42848E-40)
            if (r11 == 0) goto L_0x00af
            r11 = 196608(0x30000, float:2.75506E-40)
        L_0x00ad:
            r2 = r2 | r11
            goto L_0x00bf
        L_0x00af:
            r11 = r13 & r15
            if (r11 != 0) goto L_0x00bf
            boolean r11 = r14.changed((java.lang.Object) r12)
            if (r11 == 0) goto L_0x00bc
            r11 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00ad
        L_0x00bc:
            r11 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00ad
        L_0x00bf:
            r11 = 374491(0x5b6db, float:5.24774E-40)
            r11 = r11 & r2
            r16 = 74898(0x12492, float:1.04954E-40)
            r11 = r11 ^ r16
            if (r11 != 0) goto L_0x00da
            boolean r11 = r14.getSkipping()
            if (r11 != 0) goto L_0x00d1
            goto L_0x00da
        L_0x00d1:
            r14.skipToGroupEnd()
            r2 = r3
            r4 = r5
            r6 = r8
            r7 = r10
            goto L_0x0185
        L_0x00da:
            r14.startDefaults()
            r11 = r13 & 1
            if (r11 == 0) goto L_0x0102
            boolean r11 = r14.getDefaultsInvalid()
            if (r11 == 0) goto L_0x00e8
            goto L_0x0102
        L_0x00e8:
            r14.skipToGroupEnd()
            r0 = r33 & 2
            if (r0 == 0) goto L_0x00f1
            r2 = r2 & -113(0xffffffffffffff8f, float:NaN)
        L_0x00f1:
            r0 = r33 & 4
            if (r0 == 0) goto L_0x00f7
            r2 = r2 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00f7:
            r16 = r1
        L_0x00f9:
            r17 = r3
            r19 = r5
            r21 = r8
            r22 = r10
            goto L_0x0149
        L_0x0102:
            if (r0 == 0) goto L_0x0109
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x010a
        L_0x0109:
            r0 = r1
        L_0x010a:
            r1 = r33 & 2
            if (r1 == 0) goto L_0x011b
            androidx.compose.material.MaterialTheme r1 = androidx.compose.material.MaterialTheme.INSTANCE
            r3 = 6
            androidx.compose.material.Colors r1 = r1.getColors(r14, r3)
            long r3 = androidx.compose.material.ColorsKt.getPrimarySurface(r1)
            r2 = r2 & -113(0xffffffffffffff8f, float:NaN)
        L_0x011b:
            r1 = r33 & 4
            if (r1 == 0) goto L_0x012a
            int r1 = r2 >> 3
            r1 = r1 & 14
            long r5 = androidx.compose.material.ColorsKt.m932contentColorForek8zF_U(r3, r14, r1)
            r1 = r2 & -897(0xfffffffffffffc7f, float:NaN)
            r2 = r1
        L_0x012a:
            if (r7 == 0) goto L_0x0133
            androidx.compose.material.AppBarDefaults r1 = androidx.compose.material.AppBarDefaults.INSTANCE
            float r1 = r1.m831getTopAppBarElevationD9Ej5fM()
            r8 = r1
        L_0x0133:
            if (r9 == 0) goto L_0x0146
            androidx.compose.material.AppBarDefaults r1 = androidx.compose.material.AppBarDefaults.INSTANCE
            androidx.compose.foundation.layout.PaddingValues r1 = r1.getContentPadding()
            r16 = r0
            r22 = r1
            r17 = r3
            r19 = r5
            r21 = r8
            goto L_0x0149
        L_0x0146:
            r16 = r0
            goto L_0x00f9
        L_0x0149:
            r14.endDefaults()
            androidx.compose.ui.graphics.Shape r6 = androidx.compose.ui.graphics.RectangleShapeKt.getRectangleShape()
            int r0 = r2 >> 3
            r1 = r0 & 14
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r3 = r0 & 112(0x70, float:1.57E-43)
            r1 = r1 | r3
            r3 = r0 & 896(0x380, float:1.256E-42)
            r1 = r1 | r3
            r0 = r0 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            int r1 = r2 << 15
            r1 = r1 & r15
            r0 = r0 | r1
            r1 = 3670016(0x380000, float:5.142788E-39)
            int r2 = r2 << 3
            r1 = r1 & r2
            r10 = r0 | r1
            r11 = 0
            r0 = r17
            r2 = r19
            r4 = r21
            r5 = r22
            r7 = r16
            r8 = r30
            r9 = r14
            m832AppBarcelAv9A(r0, r2, r4, r5, r6, r7, r8, r9, r10, r11)
            r1 = r16
            r2 = r17
            r4 = r19
            r6 = r21
            r7 = r22
        L_0x0185:
            androidx.compose.runtime.ScopeUpdateScope r11 = r14.endRestartGroup()
            if (r11 != 0) goto L_0x018c
            goto L_0x019d
        L_0x018c:
            androidx.compose.material.AppBarKt$TopAppBar$3 r14 = new androidx.compose.material.AppBarKt$TopAppBar$3
            r0 = r14
            r8 = r30
            r9 = r32
            r10 = r33
            r0.<init>(r1, r2, r4, r6, r7, r8, r9, r10)
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            r11.updateScope(r14)
        L_0x019d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.AppBarKt.m834TopAppBarHsRjFd4(androidx.compose.ui.Modifier, long, long, float, androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:120:0x01ef  */
    /* JADX WARNING: Removed duplicated region for block: B:122:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00fd  */
    /* renamed from: BottomAppBar-Y1yfwus  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m833BottomAppBarY1yfwus(androidx.compose.ui.Modifier r24, long r25, long r27, androidx.compose.ui.graphics.Shape r29, float r30, androidx.compose.foundation.layout.PaddingValues r31, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, androidx.compose.runtime.Composer r33, int r34, int r35) {
        /*
            r12 = r32
            r13 = r34
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = 25805707(0x189c38b, float:5.060644E-38)
            r1 = r33
            androidx.compose.runtime.Composer r14 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(BottomAppBar)P(6,0:c#ui.graphics.Color,2:c#ui.graphics.Color,4,5:c#ui.unit.Dp,3)216@9902L6,217@9951L32,223@10232L7,229@10422L152:AppBar.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r0)
            r0 = r35 & 1
            if (r0 == 0) goto L_0x0021
            r1 = r13 | 6
            r2 = r1
            r1 = r24
            goto L_0x0035
        L_0x0021:
            r1 = r13 & 14
            if (r1 != 0) goto L_0x0032
            r1 = r24
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
            r1 = r24
            r2 = r13
        L_0x0035:
            r3 = r13 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x004e
            r3 = r35 & 2
            if (r3 != 0) goto L_0x0048
            r3 = r25
            boolean r5 = r14.changed((long) r3)
            if (r5 == 0) goto L_0x004a
            r5 = 32
            goto L_0x004c
        L_0x0048:
            r3 = r25
        L_0x004a:
            r5 = 16
        L_0x004c:
            r2 = r2 | r5
            goto L_0x0050
        L_0x004e:
            r3 = r25
        L_0x0050:
            r5 = r13 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x0069
            r5 = r35 & 4
            if (r5 != 0) goto L_0x0063
            r5 = r27
            boolean r7 = r14.changed((long) r5)
            if (r7 == 0) goto L_0x0065
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0067
        L_0x0063:
            r5 = r27
        L_0x0065:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0067:
            r2 = r2 | r7
            goto L_0x006b
        L_0x0069:
            r5 = r27
        L_0x006b:
            r7 = r35 & 8
            if (r7 == 0) goto L_0x0072
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x0085
        L_0x0072:
            r8 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x0085
            r8 = r29
            boolean r9 = r14.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0081
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x0083
        L_0x0081:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x0083:
            r2 = r2 | r9
            goto L_0x0087
        L_0x0085:
            r8 = r29
        L_0x0087:
            r9 = r35 & 16
            if (r9 == 0) goto L_0x008e
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a3
        L_0x008e:
            r10 = 57344(0xe000, float:8.0356E-41)
            r10 = r10 & r13
            if (r10 != 0) goto L_0x00a3
            r10 = r30
            boolean r11 = r14.changed((float) r10)
            if (r11 == 0) goto L_0x009f
            r11 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a1
        L_0x009f:
            r11 = 8192(0x2000, float:1.14794E-41)
        L_0x00a1:
            r2 = r2 | r11
            goto L_0x00a5
        L_0x00a3:
            r10 = r30
        L_0x00a5:
            r11 = r35 & 32
            r15 = 458752(0x70000, float:6.42848E-40)
            if (r11 == 0) goto L_0x00b2
            r16 = 196608(0x30000, float:2.75506E-40)
            r2 = r2 | r16
            r15 = r31
            goto L_0x00c5
        L_0x00b2:
            r16 = r13 & r15
            r15 = r31
            if (r16 != 0) goto L_0x00c5
            boolean r16 = r14.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00c1
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c3
        L_0x00c1:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00c3:
            r2 = r2 | r16
        L_0x00c5:
            r16 = r35 & 64
            r17 = 3670016(0x380000, float:5.142788E-39)
            if (r16 == 0) goto L_0x00d0
            r16 = 1572864(0x180000, float:2.204052E-39)
        L_0x00cd:
            r2 = r2 | r16
            goto L_0x00e0
        L_0x00d0:
            r16 = r13 & r17
            if (r16 != 0) goto L_0x00e0
            boolean r16 = r14.changed((java.lang.Object) r12)
            if (r16 == 0) goto L_0x00dd
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00cd
        L_0x00dd:
            r16 = 524288(0x80000, float:7.34684E-40)
            goto L_0x00cd
        L_0x00e0:
            r16 = 2995931(0x2db6db, float:4.198194E-39)
            r16 = r2 & r16
            r18 = 599186(0x92492, float:8.39638E-40)
            r16 = r16 ^ r18
            if (r16 != 0) goto L_0x00fd
            boolean r16 = r14.getSkipping()
            if (r16 != 0) goto L_0x00f3
            goto L_0x00fd
        L_0x00f3:
            r14.skipToGroupEnd()
            r2 = r3
            r4 = r5
            r6 = r8
            r7 = r10
            r8 = r15
            goto L_0x01e8
        L_0x00fd:
            r14.startDefaults()
            r16 = r13 & 1
            if (r16 == 0) goto L_0x0125
            boolean r16 = r14.getDefaultsInvalid()
            if (r16 == 0) goto L_0x010b
            goto L_0x0125
        L_0x010b:
            r14.skipToGroupEnd()
            r0 = r35 & 2
            if (r0 == 0) goto L_0x0114
            r2 = r2 & -113(0xffffffffffffff8f, float:NaN)
        L_0x0114:
            r0 = r35 & 4
            if (r0 == 0) goto L_0x011a
            r2 = r2 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x011a:
            r18 = r3
            r20 = r5
            r11 = r8
            r16 = r10
            r22 = r15
            r15 = r1
            goto L_0x0177
        L_0x0125:
            if (r0 == 0) goto L_0x012c
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x012d
        L_0x012c:
            r0 = r1
        L_0x012d:
            r1 = r35 & 2
            if (r1 == 0) goto L_0x013e
            androidx.compose.material.MaterialTheme r1 = androidx.compose.material.MaterialTheme.INSTANCE
            r3 = 6
            androidx.compose.material.Colors r1 = r1.getColors(r14, r3)
            long r3 = androidx.compose.material.ColorsKt.getPrimarySurface(r1)
            r2 = r2 & -113(0xffffffffffffff8f, float:NaN)
        L_0x013e:
            r1 = r35 & 4
            if (r1 == 0) goto L_0x014d
            int r1 = r2 >> 3
            r1 = r1 & 14
            long r5 = androidx.compose.material.ColorsKt.m932contentColorForek8zF_U(r3, r14, r1)
            r1 = r2 & -897(0xfffffffffffffc7f, float:NaN)
            r2 = r1
        L_0x014d:
            if (r7 == 0) goto L_0x0151
            r1 = 0
            r8 = r1
        L_0x0151:
            if (r9 == 0) goto L_0x015a
            androidx.compose.material.AppBarDefaults r1 = androidx.compose.material.AppBarDefaults.INSTANCE
            float r1 = r1.m830getBottomAppBarElevationD9Ej5fM()
            r10 = r1
        L_0x015a:
            if (r11 == 0) goto L_0x016d
            androidx.compose.material.AppBarDefaults r1 = androidx.compose.material.AppBarDefaults.INSTANCE
            androidx.compose.foundation.layout.PaddingValues r1 = r1.getContentPadding()
            r15 = r0
            r22 = r1
            r18 = r3
            r20 = r5
            r11 = r8
            r16 = r10
            goto L_0x0177
        L_0x016d:
            r18 = r3
            r20 = r5
            r11 = r8
            r16 = r10
            r22 = r15
            r15 = r0
        L_0x0177:
            r14.endDefaults()
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.material.ScaffoldKt.getLocalFabPlacement()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 103361330(0x6292b32, float:3.1817102E-35)
            java.lang.String r3 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r1, r3)
            java.lang.Object r0 = r14.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.material.FabPlacement r0 = (androidx.compose.material.FabPlacement) r0
            if (r11 == 0) goto L_0x01aa
            r1 = 0
            r3 = 1
            if (r0 != 0) goto L_0x0198
            goto L_0x019f
        L_0x0198:
            boolean r4 = r0.isDocked()
            if (r4 != r3) goto L_0x019f
            r1 = 1
        L_0x019f:
            if (r1 == 0) goto L_0x01aa
            androidx.compose.material.BottomAppBarCutoutShape r1 = new androidx.compose.material.BottomAppBarCutoutShape
            r1.<init>(r11, r0)
            androidx.compose.ui.graphics.Shape r1 = (androidx.compose.ui.graphics.Shape) r1
            r6 = r1
            goto L_0x01af
        L_0x01aa:
            androidx.compose.ui.graphics.Shape r0 = androidx.compose.ui.graphics.RectangleShapeKt.getRectangleShape()
            r6 = r0
        L_0x01af:
            int r0 = r2 >> 3
            r1 = r0 & 14
            r0 = r0 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            int r1 = r2 >> 6
            r3 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r3
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            int r1 = r2 << 15
            r3 = 458752(0x70000, float:6.42848E-40)
            r1 = r1 & r3
            r0 = r0 | r1
            r1 = r2 & r17
            r10 = r0 | r1
            r17 = 0
            r0 = r18
            r2 = r20
            r4 = r16
            r5 = r22
            r7 = r15
            r8 = r32
            r9 = r14
            r23 = r11
            r11 = r17
            m832AppBarcelAv9A(r0, r2, r4, r5, r6, r7, r8, r9, r10, r11)
            r1 = r15
            r7 = r16
            r2 = r18
            r4 = r20
            r8 = r22
            r6 = r23
        L_0x01e8:
            androidx.compose.runtime.ScopeUpdateScope r14 = r14.endRestartGroup()
            if (r14 != 0) goto L_0x01ef
            goto L_0x0200
        L_0x01ef:
            androidx.compose.material.AppBarKt$BottomAppBar$1 r15 = new androidx.compose.material.AppBarKt$BottomAppBar$1
            r0 = r15
            r9 = r32
            r10 = r34
            r11 = r35
            r0.<init>(r1, r2, r4, r6, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r15 = (kotlin.jvm.functions.Function2) r15
            r14.updateScope(r15)
        L_0x0200:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.AppBarKt.m833BottomAppBarY1yfwus(androidx.compose.ui.Modifier, long, long, androidx.compose.ui.graphics.Shape, float, androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final float calculateCutoutCircleYIntercept(float f, float f2) {
        return -((float) Math.sqrt((double) ((f * f) - (f2 * f2))));
    }

    public static final Pair<Float, Float> calculateRoundedEdgeIntercept(float f, float f2, float f3) {
        Pair pair;
        Float f4;
        Float f5;
        Float f6;
        Float f7;
        float f8 = f2 * f2;
        float f9 = f3 * f3;
        float f10 = (f * f) + f8;
        float f11 = f8 * f9 * (f10 - f9);
        float f12 = f * f9;
        double d = (double) f11;
        float sqrt = (f12 - ((float) Math.sqrt(d))) / f10;
        float sqrt2 = (f12 + ((float) Math.sqrt(d))) / f10;
        float sqrt3 = (float) Math.sqrt((double) (f9 - (sqrt * sqrt)));
        float sqrt4 = (float) Math.sqrt((double) (f9 - (sqrt2 * sqrt2)));
        if (f2 > 0.0f) {
            if (sqrt3 > sqrt4) {
                f7 = Float.valueOf(sqrt);
                f6 = Float.valueOf(sqrt3);
            } else {
                f7 = Float.valueOf(sqrt2);
                f6 = Float.valueOf(sqrt4);
            }
            pair = TuplesKt.to(f7, f6);
        } else {
            if (sqrt3 < sqrt4) {
                f5 = Float.valueOf(sqrt);
                f4 = Float.valueOf(sqrt3);
            } else {
                f5 = Float.valueOf(sqrt2);
                f4 = Float.valueOf(sqrt4);
            }
            pair = TuplesKt.to(f5, f4);
        }
        float floatValue = ((Number) pair.component1()).floatValue();
        float floatValue2 = ((Number) pair.component2()).floatValue();
        if (floatValue < f) {
            floatValue2 = -floatValue2;
        }
        return TuplesKt.to(Float.valueOf(floatValue), Float.valueOf(floatValue2));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:88:? A[RETURN, SYNTHETIC] */
    /* renamed from: AppBar-celAv9A  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m832AppBarcelAv9A(long r24, long r26, float r28, androidx.compose.foundation.layout.PaddingValues r29, androidx.compose.ui.graphics.Shape r30, androidx.compose.ui.Modifier r31, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, androidx.compose.runtime.Composer r33, int r34, int r35) {
        /*
            r6 = r29
            r9 = r32
            r10 = r34
            r0 = -1459316785(0xffffffffa90497cf, float:-2.944156E-14)
            r1 = r33
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(AppBar)P(0:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp,3,6,5)513@22344L583:AppBar.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            r1 = r35 & 1
            if (r1 == 0) goto L_0x001e
            r1 = r10 | 6
            r3 = r1
            r1 = r24
            goto L_0x0032
        L_0x001e:
            r1 = r10 & 14
            if (r1 != 0) goto L_0x002f
            r1 = r24
            boolean r3 = r0.changed((long) r1)
            if (r3 == 0) goto L_0x002c
            r3 = 4
            goto L_0x002d
        L_0x002c:
            r3 = 2
        L_0x002d:
            r3 = r3 | r10
            goto L_0x0032
        L_0x002f:
            r1 = r24
            r3 = r10
        L_0x0032:
            r4 = r35 & 2
            if (r4 == 0) goto L_0x0039
            r3 = r3 | 48
            goto L_0x004c
        L_0x0039:
            r4 = r10 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x004c
            r4 = r26
            boolean r7 = r0.changed((long) r4)
            if (r7 == 0) goto L_0x0048
            r7 = 32
            goto L_0x004a
        L_0x0048:
            r7 = 16
        L_0x004a:
            r3 = r3 | r7
            goto L_0x004e
        L_0x004c:
            r4 = r26
        L_0x004e:
            r7 = r35 & 4
            if (r7 == 0) goto L_0x0055
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0068
        L_0x0055:
            r7 = r10 & 896(0x380, float:1.256E-42)
            if (r7 != 0) goto L_0x0068
            r7 = r28
            boolean r8 = r0.changed((float) r7)
            if (r8 == 0) goto L_0x0064
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x0066
        L_0x0064:
            r8 = 128(0x80, float:1.794E-43)
        L_0x0066:
            r3 = r3 | r8
            goto L_0x006a
        L_0x0068:
            r7 = r28
        L_0x006a:
            r8 = r35 & 8
            if (r8 == 0) goto L_0x0071
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0081
        L_0x0071:
            r8 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x0081
            boolean r8 = r0.changed((java.lang.Object) r6)
            if (r8 == 0) goto L_0x007e
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x0080
        L_0x007e:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x0080:
            r3 = r3 | r8
        L_0x0081:
            r8 = r35 & 16
            if (r8 == 0) goto L_0x0088
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009d
        L_0x0088:
            r8 = 57344(0xe000, float:8.0356E-41)
            r8 = r8 & r10
            if (r8 != 0) goto L_0x009d
            r8 = r30
            boolean r11 = r0.changed((java.lang.Object) r8)
            if (r11 == 0) goto L_0x0099
            r11 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009b
        L_0x0099:
            r11 = 8192(0x2000, float:1.14794E-41)
        L_0x009b:
            r3 = r3 | r11
            goto L_0x009f
        L_0x009d:
            r8 = r30
        L_0x009f:
            r11 = r35 & 32
            r12 = 458752(0x70000, float:6.42848E-40)
            if (r11 == 0) goto L_0x00a9
            r13 = 196608(0x30000, float:2.75506E-40)
            r3 = r3 | r13
            goto L_0x00bc
        L_0x00a9:
            r13 = r10 & r12
            if (r13 != 0) goto L_0x00bc
            r13 = r31
            boolean r14 = r0.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x00b8
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00ba
        L_0x00b8:
            r14 = 65536(0x10000, float:9.18355E-41)
        L_0x00ba:
            r3 = r3 | r14
            goto L_0x00be
        L_0x00bc:
            r13 = r31
        L_0x00be:
            r14 = r35 & 64
            r15 = 1572864(0x180000, float:2.204052E-39)
            if (r14 == 0) goto L_0x00c6
            r3 = r3 | r15
            goto L_0x00d7
        L_0x00c6:
            r14 = 3670016(0x380000, float:5.142788E-39)
            r14 = r14 & r10
            if (r14 != 0) goto L_0x00d7
            boolean r14 = r0.changed((java.lang.Object) r9)
            if (r14 == 0) goto L_0x00d4
            r14 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d6
        L_0x00d4:
            r14 = 524288(0x80000, float:7.34684E-40)
        L_0x00d6:
            r3 = r3 | r14
        L_0x00d7:
            r14 = 2995931(0x2db6db, float:4.198194E-39)
            r14 = r14 & r3
            r16 = 599186(0x92492, float:8.39638E-40)
            r14 = r14 ^ r16
            if (r14 != 0) goto L_0x00ef
            boolean r14 = r0.getSkipping()
            if (r14 != 0) goto L_0x00e9
            goto L_0x00ef
        L_0x00e9:
            r0.skipToGroupEnd()
            r23 = r13
            goto L_0x0135
        L_0x00ef:
            if (r11 == 0) goto L_0x00f8
            androidx.compose.ui.Modifier$Companion r11 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r11 = (androidx.compose.ui.Modifier) r11
            r23 = r11
            goto L_0x00fa
        L_0x00f8:
            r23 = r13
        L_0x00fa:
            r17 = 0
            r11 = -819908255(0xffffffffcf213161, float:-2.70436787E9)
            androidx.compose.material.AppBarKt$AppBar$1 r13 = new androidx.compose.material.AppBarKt$AppBar$1
            r13.<init>(r6, r9, r3)
            r14 = 1
            androidx.compose.runtime.internal.ComposableLambda r11 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r11, r14, r13)
            r19 = r11
            kotlin.jvm.functions.Function2 r19 = (kotlin.jvm.functions.Function2) r19
            int r11 = r3 >> 15
            r11 = r11 & 14
            r11 = r11 | r15
            int r13 = r3 >> 9
            r13 = r13 & 112(0x70, float:1.57E-43)
            r11 = r11 | r13
            int r13 = r3 << 6
            r14 = r13 & 896(0x380, float:1.256E-42)
            r11 = r11 | r14
            r13 = r13 & 7168(0x1c00, float:1.0045E-41)
            r11 = r11 | r13
            int r3 = r3 << 9
            r3 = r3 & r12
            r21 = r11 | r3
            r22 = 16
            r11 = r23
            r12 = r30
            r13 = r24
            r15 = r26
            r18 = r28
            r20 = r0
            androidx.compose.material.SurfaceKt.m1125SurfaceFjzlyU((androidx.compose.ui.Modifier) r11, (androidx.compose.ui.graphics.Shape) r12, (long) r13, (long) r15, (androidx.compose.foundation.BorderStroke) r17, (float) r18, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r19, (androidx.compose.runtime.Composer) r20, (int) r21, (int) r22)
        L_0x0135:
            androidx.compose.runtime.ScopeUpdateScope r12 = r0.endRestartGroup()
            if (r12 != 0) goto L_0x013c
            goto L_0x0159
        L_0x013c:
            androidx.compose.material.AppBarKt$AppBar$2 r13 = new androidx.compose.material.AppBarKt$AppBar$2
            r0 = r13
            r1 = r24
            r3 = r26
            r5 = r28
            r6 = r29
            r7 = r30
            r8 = r23
            r9 = r32
            r10 = r34
            r11 = r35
            r0.<init>(r1, r3, r5, r6, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r12.updateScope(r13)
        L_0x0159:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.AppBarKt.m832AppBarcelAv9A(long, long, float, androidx.compose.foundation.layout.PaddingValues, androidx.compose.ui.graphics.Shape, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    static {
        float f = (float) 4;
        float r1 = Dp.m3859constructorimpl(f);
        AppBarHorizontalPadding = r1;
        TitleInsetWithoutIcon = SizeKt.m497width3ABfNKs(Modifier.Companion, Dp.m3859constructorimpl(Dp.m3859constructorimpl((float) 16) - r1));
        TitleIconModifier = SizeKt.m497width3ABfNKs(SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.m3859constructorimpl(Dp.m3859constructorimpl((float) 72) - r1));
        BottomAppBarRoundedEdgeRadius = Dp.m3859constructorimpl(f);
    }
}
