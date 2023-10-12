package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u0012\u001a©\u0001\u0010\u0013\u001a\u00020\u00012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u00052\b\b\u0002\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\u00052\b\b\u0002\u0010$\u001a\u00020\u0005H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b%\u0010&\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006'"}, d2 = {"Group", "", "name", "", "rotation", "", "pivotX", "pivotY", "scaleX", "scaleY", "translationX", "translationY", "clipPathData", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/String;FFFFFFFLjava/util/List;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Path", "pathData", "pathFillType", "Landroidx/compose/ui/graphics/PathFillType;", "fill", "Landroidx/compose/ui/graphics/Brush;", "fillAlpha", "stroke", "strokeAlpha", "strokeLineWidth", "strokeLineCap", "Landroidx/compose/ui/graphics/StrokeCap;", "strokeLineJoin", "Landroidx/compose/ui/graphics/StrokeJoin;", "strokeLineMiter", "trimPathStart", "trimPathEnd", "trimPathOffset", "Path-9cdaXJ4", "(Ljava/util/List;ILjava/lang/String;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Brush;FFIIFFFFLandroidx/compose/runtime/Composer;III)V", "ui_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: VectorCompose.kt */
public final class VectorComposeKt {
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x01cb  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x01d7  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x01db  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x0271  */
    /* JADX WARNING: Removed duplicated region for block: B:150:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x011a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Group(java.lang.String r19, float r20, float r21, float r22, float r23, float r24, float r25, float r26, java.util.List<? extends androidx.compose.ui.graphics.vector.PathNode> r27, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, androidx.compose.runtime.Composer r29, int r30, int r31) {
        /*
            r10 = r28
            r11 = r30
            r12 = r31
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = 383574212(0x16dce0c4, float:3.5684764E-25)
            r1 = r29
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(Group)P(2,5,3,4,6,7,8,9)39@1405L585:VectorCompose.kt#huu6hf"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            r1 = r12 & 1
            if (r1 == 0) goto L_0x0023
            r2 = r11 | 6
            r3 = r2
            r2 = r19
            goto L_0x0037
        L_0x0023:
            r2 = r11 & 14
            if (r2 != 0) goto L_0x0034
            r2 = r19
            boolean r3 = r0.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x0031
            r3 = 4
            goto L_0x0032
        L_0x0031:
            r3 = 2
        L_0x0032:
            r3 = r3 | r11
            goto L_0x0037
        L_0x0034:
            r2 = r19
            r3 = r11
        L_0x0037:
            r4 = r12 & 2
            if (r4 == 0) goto L_0x003e
            r3 = r3 | 48
            goto L_0x0051
        L_0x003e:
            r5 = r11 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x0051
            r5 = r20
            boolean r6 = r0.changed((float) r5)
            if (r6 == 0) goto L_0x004d
            r6 = 32
            goto L_0x004f
        L_0x004d:
            r6 = 16
        L_0x004f:
            r3 = r3 | r6
            goto L_0x0053
        L_0x0051:
            r5 = r20
        L_0x0053:
            r6 = r12 & 4
            if (r6 == 0) goto L_0x005a
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x006d
        L_0x005a:
            r8 = r11 & 896(0x380, float:1.256E-42)
            if (r8 != 0) goto L_0x006d
            r8 = r21
            boolean r9 = r0.changed((float) r8)
            if (r9 == 0) goto L_0x0069
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x006b
        L_0x0069:
            r9 = 128(0x80, float:1.794E-43)
        L_0x006b:
            r3 = r3 | r9
            goto L_0x006f
        L_0x006d:
            r8 = r21
        L_0x006f:
            r9 = r12 & 8
            if (r9 == 0) goto L_0x0076
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0089
        L_0x0076:
            r13 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r13 != 0) goto L_0x0089
            r13 = r22
            boolean r14 = r0.changed((float) r13)
            if (r14 == 0) goto L_0x0085
            r14 = 2048(0x800, float:2.87E-42)
            goto L_0x0087
        L_0x0085:
            r14 = 1024(0x400, float:1.435E-42)
        L_0x0087:
            r3 = r3 | r14
            goto L_0x008b
        L_0x0089:
            r13 = r22
        L_0x008b:
            r14 = r12 & 16
            if (r14 == 0) goto L_0x0092
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a8
        L_0x0092:
            r15 = 57344(0xe000, float:8.0356E-41)
            r15 = r15 & r11
            if (r15 != 0) goto L_0x00a8
            r15 = r23
            boolean r16 = r0.changed((float) r15)
            if (r16 == 0) goto L_0x00a3
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a5
        L_0x00a3:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x00a5:
            r3 = r3 | r16
            goto L_0x00aa
        L_0x00a8:
            r15 = r23
        L_0x00aa:
            r16 = r12 & 32
            if (r16 == 0) goto L_0x00b5
            r17 = 196608(0x30000, float:2.75506E-40)
            r3 = r3 | r17
            r7 = r24
            goto L_0x00ca
        L_0x00b5:
            r17 = 458752(0x70000, float:6.42848E-40)
            r17 = r11 & r17
            r7 = r24
            if (r17 != 0) goto L_0x00ca
            boolean r17 = r0.changed((float) r7)
            if (r17 == 0) goto L_0x00c6
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c8
        L_0x00c6:
            r17 = 65536(0x10000, float:9.18355E-41)
        L_0x00c8:
            r3 = r3 | r17
        L_0x00ca:
            r17 = r12 & 64
            if (r17 == 0) goto L_0x00d5
            r18 = 1572864(0x180000, float:2.204052E-39)
            r3 = r3 | r18
            r2 = r25
            goto L_0x00ea
        L_0x00d5:
            r18 = 3670016(0x380000, float:5.142788E-39)
            r18 = r11 & r18
            r2 = r25
            if (r18 != 0) goto L_0x00ea
            boolean r18 = r0.changed((float) r2)
            if (r18 == 0) goto L_0x00e6
            r18 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e8
        L_0x00e6:
            r18 = 524288(0x80000, float:7.34684E-40)
        L_0x00e8:
            r3 = r3 | r18
        L_0x00ea:
            r2 = r12 & 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x00f5
            r18 = 12582912(0xc00000, float:1.7632415E-38)
            r3 = r3 | r18
            r5 = r26
            goto L_0x010a
        L_0x00f5:
            r18 = 29360128(0x1c00000, float:7.052966E-38)
            r18 = r11 & r18
            r5 = r26
            if (r18 != 0) goto L_0x010a
            boolean r18 = r0.changed((float) r5)
            if (r18 == 0) goto L_0x0106
            r18 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0108
        L_0x0106:
            r18 = 4194304(0x400000, float:5.877472E-39)
        L_0x0108:
            r3 = r3 | r18
        L_0x010a:
            r5 = r12 & 256(0x100, float:3.59E-43)
            if (r5 == 0) goto L_0x0112
            r18 = 33554432(0x2000000, float:9.403955E-38)
            r3 = r3 | r18
        L_0x0112:
            r7 = r12 & 512(0x200, float:7.175E-43)
            if (r7 == 0) goto L_0x011a
            r7 = 805306368(0x30000000, float:4.656613E-10)
        L_0x0118:
            r3 = r3 | r7
            goto L_0x012b
        L_0x011a:
            r7 = 1879048192(0x70000000, float:1.58456325E29)
            r7 = r7 & r11
            if (r7 != 0) goto L_0x012b
            boolean r7 = r0.changed((java.lang.Object) r10)
            if (r7 == 0) goto L_0x0128
            r7 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0118
        L_0x0128:
            r7 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x0118
        L_0x012b:
            int r7 = ~r12
            r8 = 256(0x100, float:3.59E-43)
            r7 = r7 & r8
            if (r7 != 0) goto L_0x0157
            r7 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r7 = r7 & r3
            r8 = 306783378(0x12492492, float:6.3469493E-28)
            r7 = r7 ^ r8
            if (r7 != 0) goto L_0x0157
            boolean r7 = r0.getSkipping()
            if (r7 != 0) goto L_0x0142
            goto L_0x0157
        L_0x0142:
            r0.skipToGroupEnd()
            r1 = r19
            r2 = r20
            r3 = r21
            r6 = r24
            r7 = r25
            r8 = r26
            r9 = r27
            r4 = r13
            r5 = r15
            goto L_0x026a
        L_0x0157:
            r0.startDefaults()
            r7 = r11 & 1
            r8 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            if (r7 == 0) goto L_0x017d
            boolean r7 = r0.getDefaultsInvalid()
            if (r7 == 0) goto L_0x0168
            goto L_0x017d
        L_0x0168:
            r0.skipToGroupEnd()
            if (r5 == 0) goto L_0x016e
            r3 = r3 & r8
        L_0x016e:
            r1 = r19
            r4 = r20
            r6 = r21
            r9 = r24
            r14 = r25
            r7 = r26
        L_0x017a:
            r2 = r27
            goto L_0x01b1
        L_0x017d:
            if (r1 == 0) goto L_0x0182
            java.lang.String r1 = ""
            goto L_0x0184
        L_0x0182:
            r1 = r19
        L_0x0184:
            r7 = 0
            if (r4 == 0) goto L_0x0189
            r4 = 0
            goto L_0x018b
        L_0x0189:
            r4 = r20
        L_0x018b:
            if (r6 == 0) goto L_0x018f
            r6 = 0
            goto L_0x0191
        L_0x018f:
            r6 = r21
        L_0x0191:
            if (r9 == 0) goto L_0x0194
            r13 = 0
        L_0x0194:
            r9 = 1065353216(0x3f800000, float:1.0)
            if (r14 == 0) goto L_0x019a
            r15 = 1065353216(0x3f800000, float:1.0)
        L_0x019a:
            if (r16 == 0) goto L_0x019d
            goto L_0x019f
        L_0x019d:
            r9 = r24
        L_0x019f:
            if (r17 == 0) goto L_0x01a3
            r14 = 0
            goto L_0x01a5
        L_0x01a3:
            r14 = r25
        L_0x01a5:
            if (r2 == 0) goto L_0x01a8
            goto L_0x01aa
        L_0x01a8:
            r7 = r26
        L_0x01aa:
            if (r5 == 0) goto L_0x017a
            java.util.List r2 = androidx.compose.ui.graphics.vector.VectorKt.getEmptyPath()
            r3 = r3 & r8
        L_0x01b1:
            r0.endDefaults()
            androidx.compose.ui.graphics.vector.VectorComposeKt$Group$1 r5 = androidx.compose.ui.graphics.vector.VectorComposeKt$Group$1.INSTANCE
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            r8 = -2103248186(0xffffffff82a2fac6, float:-2.3947697E-37)
            r0.startReplaceableGroup(r8)
            java.lang.String r8 = "C(ComposeNode)P(1,2)305@11141L9:Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r8)
            androidx.compose.runtime.Applier r8 = r0.getApplier()
            boolean r8 = r8 instanceof androidx.compose.ui.graphics.vector.VectorApplier
            if (r8 != 0) goto L_0x01ce
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x01ce:
            r0.startNode()
            boolean r8 = r0.getInserting()
            if (r8 == 0) goto L_0x01db
            r0.createNode(r5)
            goto L_0x01de
        L_0x01db:
            r0.useNode()
        L_0x01de:
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.Updater.m1234constructorimpl(r0)
            androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1 r8 = androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1.INSTANCE
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r5, r1, r8)
            java.lang.Float r8 = java.lang.Float.valueOf(r4)
            androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2 r16 = androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2.INSTANCE
            r17 = r1
            r1 = r16
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r5, r8, r1)
            java.lang.Float r1 = java.lang.Float.valueOf(r6)
            androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3 r8 = androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3.INSTANCE
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r5, r1, r8)
            java.lang.Float r1 = java.lang.Float.valueOf(r13)
            androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4 r8 = androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4.INSTANCE
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r5, r1, r8)
            java.lang.Float r1 = java.lang.Float.valueOf(r15)
            androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5 r8 = androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5.INSTANCE
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r5, r1, r8)
            java.lang.Float r1 = java.lang.Float.valueOf(r9)
            androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6 r8 = androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6.INSTANCE
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r5, r1, r8)
            java.lang.Float r1 = java.lang.Float.valueOf(r14)
            androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7 r8 = androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7.INSTANCE
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r5, r1, r8)
            java.lang.Float r1 = java.lang.Float.valueOf(r7)
            androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8 r8 = androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8.INSTANCE
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r5, r1, r8)
            androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9 r1 = androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9.INSTANCE
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r5, r2, r1)
            r1 = -1894407238(0xffffffff8f15a3ba, float:-7.3778E-30)
            r0.startReplaceableGroup(r1)
            java.lang.String r1 = "C53@1975L9:VectorCompose.kt#huu6hf"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            int r1 = r3 >> 27
            r1 = r1 & 14
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r10.invoke(r0, r1)
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r3 = r6
            r8 = r7
            r6 = r9
            r7 = r14
            r5 = r15
            r1 = r17
            r9 = r2
            r2 = r4
            r4 = r13
        L_0x026a:
            androidx.compose.runtime.ScopeUpdateScope r13 = r0.endRestartGroup()
            if (r13 != 0) goto L_0x0271
            goto L_0x0282
        L_0x0271:
            androidx.compose.ui.graphics.vector.VectorComposeKt$Group$4 r14 = new androidx.compose.ui.graphics.vector.VectorComposeKt$Group$4
            r0 = r14
            r10 = r28
            r11 = r30
            r12 = r31
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            r13.updateScope(r14)
        L_0x0282:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.VectorComposeKt.Group(java.lang.String, float, float, float, float, float, float, float, java.util.List, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: Path-9cdaXJ4  reason: not valid java name */
    public static final void m2215Path9cdaXJ4(List<? extends PathNode> list, int i, String str, Brush brush, float f, Brush brush2, float f2, float f3, int i2, int i3, float f4, float f5, float f6, float f7, Composer composer, int i4, int i5, int i6) {
        List<? extends PathNode> list2 = list;
        int i7 = i6;
        Intrinsics.checkNotNullParameter(list2, "pathData");
        Composer startRestartGroup = composer.startRestartGroup(435826864);
        ComposerKt.sourceInformation(startRestartGroup, "C(Path)P(3,4:c#ui.graphics.PathFillType,2!4,10,7:c#ui.graphics.StrokeCap,8:c#ui.graphics.StrokeJoin!1,13)74@2611L876:VectorCompose.kt#huu6hf");
        int defaultFillType = (i7 & 2) != 0 ? VectorKt.getDefaultFillType() : i;
        String str2 = (i7 & 4) != 0 ? "" : str;
        Brush brush3 = (i7 & 8) != 0 ? null : brush;
        float f8 = (i7 & 16) != 0 ? 1.0f : f;
        Brush brush4 = (i7 & 32) != 0 ? null : brush2;
        float f9 = (i7 & 64) != 0 ? 1.0f : f2;
        float f10 = (i7 & 128) != 0 ? 0.0f : f3;
        int defaultStrokeLineCap = (i7 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : i2;
        int defaultStrokeLineJoin = (i7 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : i3;
        float f11 = (i7 & 1024) != 0 ? 4.0f : f4;
        float f12 = (i7 & 2048) != 0 ? 0.0f : f5;
        float f13 = (i7 & 4096) != 0 ? 1.0f : f6;
        float f14 = (i7 & 8192) != 0 ? 0.0f : f7;
        Function0 function0 = VectorComposeKt$Path$1.INSTANCE;
        startRestartGroup.startReplaceableGroup(-2103250935);
        ComposerKt.sourceInformation(startRestartGroup, "C(ComposeNode):Composables.kt#9igjgp");
        if (!(startRestartGroup.getApplier() instanceof VectorApplier)) {
            ComposablesKt.invalidApplier();
        }
        startRestartGroup.startNode();
        if (startRestartGroup.getInserting()) {
            startRestartGroup.createNode(new VectorComposeKt$Path9cdaXJ4$$inlined$ComposeNode$1(function0));
        } else {
            startRestartGroup.useNode();
        }
        Composer r5 = Updater.m1234constructorimpl(startRestartGroup);
        Updater.m1241setimpl(r5, str2, VectorComposeKt$Path$2$1.INSTANCE);
        Updater.m1241setimpl(r5, list2, VectorComposeKt$Path$2$2.INSTANCE);
        Updater.m1241setimpl(r5, PathFillType.m1825boximpl(defaultFillType), VectorComposeKt$Path$2$3.INSTANCE);
        Updater.m1241setimpl(r5, brush3, VectorComposeKt$Path$2$4.INSTANCE);
        Updater.m1241setimpl(r5, Float.valueOf(f8), VectorComposeKt$Path$2$5.INSTANCE);
        Updater.m1241setimpl(r5, brush4, VectorComposeKt$Path$2$6.INSTANCE);
        Updater.m1241setimpl(r5, Float.valueOf(f9), VectorComposeKt$Path$2$7.INSTANCE);
        Updater.m1241setimpl(r5, Float.valueOf(f10), VectorComposeKt$Path$2$8.INSTANCE);
        Updater.m1241setimpl(r5, StrokeJoin.m1919boximpl(defaultStrokeLineJoin), VectorComposeKt$Path$2$9.INSTANCE);
        Updater.m1241setimpl(r5, StrokeCap.m1909boximpl(defaultStrokeLineCap), VectorComposeKt$Path$2$10.INSTANCE);
        Updater.m1241setimpl(r5, Float.valueOf(f11), VectorComposeKt$Path$2$11.INSTANCE);
        Updater.m1241setimpl(r5, Float.valueOf(f12), VectorComposeKt$Path$2$12.INSTANCE);
        Updater.m1241setimpl(r5, Float.valueOf(f13), VectorComposeKt$Path$2$13.INSTANCE);
        Updater.m1241setimpl(r5, Float.valueOf(f14), VectorComposeKt$Path$2$14.INSTANCE);
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new VectorComposeKt$Path$3(list, defaultFillType, str2, brush3, f8, brush4, f9, f10, defaultStrokeLineCap, defaultStrokeLineJoin, f11, f12, f13, f14, i4, i5, i6));
        }
    }
}
