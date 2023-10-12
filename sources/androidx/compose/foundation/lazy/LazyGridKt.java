package androidx.compose.foundation.lazy;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aX\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\u0011H\u0003¢\u0006\u0002\u0010\u0012\u001aB\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2#\u0010\u0014\u001a\u001f\u0012\u001b\u0012\u0019\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00010\u0017¢\u0006\u0002\b\u0018\u0012\u0004\u0012\u00020\u00030\u00160\u0015H\u0003¢\u0006\u0002\u0010\u0019\u001a`\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u001d\u001a\u0001\u0010\u001e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001f*\u00020\u00102\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0 20\b\n\u0010!\u001a*\u0012\u0004\u0012\u00020#\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020'\u0018\u00010\"¢\u0006\u0002\b\u001123\b\u0004\u0010(\u001a-\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u00010\"¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0011H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010*\u001a\u0001\u0010\u001e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001f*\u00020\u00102\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0\u001520\b\n\u0010!\u001a*\u0012\u0004\u0012\u00020#\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020'\u0018\u00010\"¢\u0006\u0002\b\u001123\b\u0004\u0010(\u001a-\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u00010\"¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0011H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010+\u001a½\u0001\u0010,\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001f*\u00020\u00102\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0 2E\b\n\u0010!\u001a?\u0012\u0004\u0012\u00020#\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(.\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020'\u0018\u00010-¢\u0006\u0002\b\u00112H\b\u0004\u0010(\u001aB\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(.\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u00010-¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0011H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010/\u001a½\u0001\u0010,\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001f*\u00020\u00102\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0\u00152E\b\n\u0010!\u001a?\u0012\u0004\u0012\u00020#\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(.\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020'\u0018\u00010-¢\u0006\u0002\b\u00112H\b\u0004\u0010(\u001aB\u0012\u0004\u0012\u00020)\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(.\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u00010-¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0011H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u00100\u0002\u000b\n\u0002\b\u0019\n\u0005\b20\u0001¨\u00061"}, d2 = {"FixedLazyGrid", "", "nColumns", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/LazyGridScope;", "Lkotlin/ExtensionFunctionType;", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "ItemRow", "rowContent", "", "Lkotlin/Pair;", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(ILandroidx/compose/foundation/layout/Arrangement$Horizontal;Ljava/util/List;Landroidx/compose/runtime/Composer;I)V", "LazyVerticalGrid", "cells", "Landroidx/compose/foundation/lazy/GridCells;", "(Landroidx/compose/foundation/lazy/GridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "items", "T", "", "spans", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/LazyGridItemSpanScope;", "Lkotlin/ParameterName;", "name", "item", "Landroidx/compose/foundation/lazy/GridItemSpan;", "itemContent", "Landroidx/compose/foundation/lazy/LazyItemScope;", "(Landroidx/compose/foundation/lazy/LazyGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function4;)V", "(Landroidx/compose/foundation/lazy/LazyGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function4;)V", "itemsIndexed", "Lkotlin/Function3;", "index", "(Landroidx/compose/foundation/lazy/LazyGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function5;)V", "(Landroidx/compose/foundation/lazy/LazyGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function5;)V", "foundation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: LazyGrid.kt */
public final class LazyGridKt {
    /* JADX WARNING: Removed duplicated region for block: B:107:0x016b  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x01ab  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0209  */
    /* JADX WARNING: Removed duplicated region for block: B:117:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00fe  */
    @androidx.compose.foundation.ExperimentalFoundationApi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void LazyVerticalGrid(androidx.compose.foundation.lazy.GridCells r24, androidx.compose.ui.Modifier r25, androidx.compose.foundation.lazy.LazyListState r26, androidx.compose.foundation.layout.PaddingValues r27, androidx.compose.foundation.layout.Arrangement.Vertical r28, androidx.compose.foundation.layout.Arrangement.Horizontal r29, kotlin.jvm.functions.Function1<? super androidx.compose.foundation.lazy.LazyGridScope, kotlin.Unit> r30, androidx.compose.runtime.Composer r31, int r32, int r33) {
        /*
            r8 = r24
            r7 = r30
            r6 = r32
            java.lang.String r0 = "cells"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = 409765954(0x186c8842, float:3.0571078E-24)
            r1 = r31
            androidx.compose.runtime.Composer r5 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(LazyVerticalGrid)P(!1,4,5,2,6,3)57@2492L23:LazyGrid.kt#428nma"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r0)
            r0 = r33 & 1
            if (r0 == 0) goto L_0x0025
            r0 = r6 | 6
            goto L_0x0035
        L_0x0025:
            r0 = r6 & 14
            if (r0 != 0) goto L_0x0034
            boolean r0 = r5.changed((java.lang.Object) r8)
            if (r0 == 0) goto L_0x0031
            r0 = 4
            goto L_0x0032
        L_0x0031:
            r0 = 2
        L_0x0032:
            r0 = r0 | r6
            goto L_0x0035
        L_0x0034:
            r0 = r6
        L_0x0035:
            r1 = r33 & 2
            if (r1 == 0) goto L_0x003c
            r0 = r0 | 48
            goto L_0x004f
        L_0x003c:
            r2 = r6 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x004f
            r2 = r25
            boolean r3 = r5.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x004b
            r3 = 32
            goto L_0x004d
        L_0x004b:
            r3 = 16
        L_0x004d:
            r0 = r0 | r3
            goto L_0x0051
        L_0x004f:
            r2 = r25
        L_0x0051:
            r3 = r6 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x006a
            r3 = r33 & 4
            if (r3 != 0) goto L_0x0064
            r3 = r26
            boolean r4 = r5.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0066
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x0068
        L_0x0064:
            r3 = r26
        L_0x0066:
            r4 = 128(0x80, float:1.794E-43)
        L_0x0068:
            r0 = r0 | r4
            goto L_0x006c
        L_0x006a:
            r3 = r26
        L_0x006c:
            r4 = r33 & 8
            if (r4 == 0) goto L_0x0073
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0086
        L_0x0073:
            r9 = r6 & 7168(0x1c00, float:1.0045E-41)
            if (r9 != 0) goto L_0x0086
            r9 = r27
            boolean r10 = r5.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x0082
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x0084
        L_0x0082:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x0084:
            r0 = r0 | r10
            goto L_0x0088
        L_0x0086:
            r9 = r27
        L_0x0088:
            r10 = r33 & 16
            r11 = 57344(0xe000, float:8.0356E-41)
            if (r10 == 0) goto L_0x0092
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a5
        L_0x0092:
            r12 = r6 & r11
            if (r12 != 0) goto L_0x00a5
            r12 = r28
            boolean r13 = r5.changed((java.lang.Object) r12)
            if (r13 == 0) goto L_0x00a1
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a3
        L_0x00a1:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x00a3:
            r0 = r0 | r13
            goto L_0x00a7
        L_0x00a5:
            r12 = r28
        L_0x00a7:
            r13 = r33 & 32
            r14 = 458752(0x70000, float:6.42848E-40)
            if (r13 == 0) goto L_0x00b1
            r15 = 196608(0x30000, float:2.75506E-40)
            r0 = r0 | r15
            goto L_0x00c5
        L_0x00b1:
            r15 = r6 & r14
            if (r15 != 0) goto L_0x00c5
            r15 = r29
            boolean r16 = r5.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00c0
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c2
        L_0x00c0:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00c2:
            r0 = r0 | r16
            goto L_0x00c7
        L_0x00c5:
            r15 = r29
        L_0x00c7:
            r16 = r33 & 64
            r17 = 3670016(0x380000, float:5.142788E-39)
            if (r16 == 0) goto L_0x00d2
            r16 = 1572864(0x180000, float:2.204052E-39)
        L_0x00cf:
            r0 = r0 | r16
            goto L_0x00e2
        L_0x00d2:
            r16 = r6 & r17
            if (r16 != 0) goto L_0x00e2
            boolean r16 = r5.changed((java.lang.Object) r7)
            if (r16 == 0) goto L_0x00df
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00cf
        L_0x00df:
            r16 = 524288(0x80000, float:7.34684E-40)
            goto L_0x00cf
        L_0x00e2:
            r16 = 2995931(0x2db6db, float:4.198194E-39)
            r16 = r0 & r16
            r18 = 599186(0x92492, float:8.39638E-40)
            r16 = r16 ^ r18
            if (r16 != 0) goto L_0x00fe
            boolean r16 = r5.getSkipping()
            if (r16 != 0) goto L_0x00f5
            goto L_0x00fe
        L_0x00f5:
            r5.skipToGroupEnd()
            r4 = r9
            r6 = r15
            r15 = r5
            r5 = r12
            goto L_0x0202
        L_0x00fe:
            r5.startDefaults()
            r16 = r6 & 1
            r14 = 3
            if (r16 == 0) goto L_0x0122
            boolean r16 = r5.getDefaultsInvalid()
            if (r16 == 0) goto L_0x010d
            goto L_0x0122
        L_0x010d:
            r5.skipToGroupEnd()
            r1 = r33 & 4
            if (r1 == 0) goto L_0x0116
            r0 = r0 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0116:
            r19 = r2
            r20 = r3
        L_0x011a:
            r21 = r9
            r22 = r12
            r23 = r15
        L_0x0120:
            r9 = r0
            goto L_0x0164
        L_0x0122:
            if (r1 == 0) goto L_0x0129
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x012a
        L_0x0129:
            r1 = r2
        L_0x012a:
            r2 = r33 & 4
            r11 = 0
            if (r2 == 0) goto L_0x0136
            androidx.compose.foundation.lazy.LazyListState r2 = androidx.compose.foundation.lazy.LazyListStateKt.rememberLazyListState(r11, r11, r5, r11, r14)
            r0 = r0 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x0137
        L_0x0136:
            r2 = r3
        L_0x0137:
            if (r4 == 0) goto L_0x0143
            float r3 = (float) r11
            float r3 = androidx.compose.ui.unit.Dp.m3859constructorimpl(r3)
            androidx.compose.foundation.layout.PaddingValues r3 = androidx.compose.foundation.layout.PaddingKt.m424PaddingValues0680j_4(r3)
            r9 = r3
        L_0x0143:
            if (r10 == 0) goto L_0x014c
            androidx.compose.foundation.layout.Arrangement r3 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r3 = r3.getTop()
            r12 = r3
        L_0x014c:
            if (r13 == 0) goto L_0x015f
            androidx.compose.foundation.layout.Arrangement r3 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Horizontal r3 = r3.getStart()
            r19 = r1
            r20 = r2
            r23 = r3
            r21 = r9
            r22 = r12
            goto L_0x0120
        L_0x015f:
            r19 = r1
            r20 = r2
            goto L_0x011a
        L_0x0164:
            r5.endDefaults()
            boolean r0 = r8 instanceof androidx.compose.foundation.lazy.GridCells.Fixed
            if (r0 == 0) goto L_0x01ab
            r0 = 409766381(0x186c89ed, float:3.057192E-24)
            r5.startReplaceableGroup(r0)
            java.lang.String r0 = "65@2813L341"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r0)
            r0 = r8
            androidx.compose.foundation.lazy.GridCells$Fixed r0 = (androidx.compose.foundation.lazy.GridCells.Fixed) r0
            int r0 = r0.getCount()
            r1 = r9 & 112(0x70, float:1.57E-43)
            r2 = r9 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            r2 = r9 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            r2 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r9
            r1 = r1 | r2
            r2 = 458752(0x70000, float:6.42848E-40)
            r2 = r2 & r9
            r1 = r1 | r2
            r2 = r9 & r17
            r17 = r1 | r2
            r18 = 0
            r9 = r0
            r10 = r19
            r11 = r20
            r12 = r21
            r13 = r22
            r14 = r23
            r15 = r30
            r16 = r5
            FixedLazyGrid(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r5.endReplaceableGroup()
            r15 = r5
            goto L_0x01f8
        L_0x01ab:
            boolean r0 = r8 instanceof androidx.compose.foundation.lazy.GridCells.Adaptive
            if (r0 == 0) goto L_0x01ee
            r0 = 409766768(0x186c8b70, float:3.0572683E-24)
            r5.startReplaceableGroup(r0)
            java.lang.String r0 = "75@3200L507"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r0)
            r10 = 0
            r11 = 0
            r12 = -819893688(0xffffffffcf216a48, float:-2.70809702E9)
            androidx.compose.foundation.lazy.LazyGridKt$LazyVerticalGrid$1 r13 = new androidx.compose.foundation.lazy.LazyGridKt$LazyVerticalGrid$1
            r0 = r13
            r1 = r24
            r2 = r20
            r3 = r21
            r4 = r22
            r15 = r5
            r5 = r23
            r6 = r30
            r7 = r9
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r0 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r15, r12, r0, r13)
            r4 = r0
            kotlin.jvm.functions.Function3 r4 = (kotlin.jvm.functions.Function3) r4
            int r0 = r9 >> 3
            r0 = r0 & 14
            r6 = r0 | 3072(0xc00, float:4.305E-42)
            r7 = 6
            r1 = r19
            r2 = r10
            r3 = r11
            r5 = r15
            androidx.compose.foundation.layout.BoxWithConstraintsKt.BoxWithConstraints(r1, r2, r3, r4, r5, r6, r7)
            r15.endReplaceableGroup()
            goto L_0x01f8
        L_0x01ee:
            r15 = r5
            r0 = 409767281(0x186c8d71, float:3.0573695E-24)
            r15.startReplaceableGroup(r0)
            r15.endReplaceableGroup()
        L_0x01f8:
            r2 = r19
            r3 = r20
            r4 = r21
            r5 = r22
            r6 = r23
        L_0x0202:
            androidx.compose.runtime.ScopeUpdateScope r10 = r15.endRestartGroup()
            if (r10 != 0) goto L_0x0209
            goto L_0x021c
        L_0x0209:
            androidx.compose.foundation.lazy.LazyGridKt$LazyVerticalGrid$2 r11 = new androidx.compose.foundation.lazy.LazyGridKt$LazyVerticalGrid$2
            r0 = r11
            r1 = r24
            r7 = r30
            r8 = r32
            r9 = r33
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r10.updateScope(r11)
        L_0x021c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyGridKt.LazyVerticalGrid(androidx.compose.foundation.lazy.GridCells, androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.LazyListState, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    public static /* synthetic */ void items$default(LazyGridScope lazyGridScope, List list, Function2 function2, Function4 function4, int i, Object obj) {
        Function2 function22 = null;
        if ((i & 2) != 0) {
            function2 = null;
        }
        Intrinsics.checkNotNullParameter(lazyGridScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "items");
        Intrinsics.checkNotNullParameter(function4, "itemContent");
        int size = list.size();
        if (function2 != null) {
            function22 = new LazyGridKt$items$1$1(function2, list);
        }
        lazyGridScope.items(size, function22, ComposableLambdaKt.composableLambdaInstance(-985536268, true, new LazyGridKt$items$2(function4, list)));
    }

    @ExperimentalFoundationApi
    public static final <T> void items(LazyGridScope lazyGridScope, List<? extends T> list, Function2<? super LazyGridItemSpanScope, ? super T, GridItemSpan> function2, Function4<? super LazyItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4) {
        Function2 function22;
        Intrinsics.checkNotNullParameter(lazyGridScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "items");
        Intrinsics.checkNotNullParameter(function4, "itemContent");
        int size = list.size();
        if (function2 == null) {
            function22 = null;
        } else {
            function22 = new LazyGridKt$items$1$1(function2, list);
        }
        lazyGridScope.items(size, function22, ComposableLambdaKt.composableLambdaInstance(-985536268, true, new LazyGridKt$items$2(function4, list)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyGridScope lazyGridScope, List list, Function3 function3, Function5 function5, int i, Object obj) {
        Function2 function2 = null;
        if ((i & 2) != 0) {
            function3 = null;
        }
        Intrinsics.checkNotNullParameter(lazyGridScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "items");
        Intrinsics.checkNotNullParameter(function5, "itemContent");
        int size = list.size();
        if (function3 != null) {
            function2 = new LazyGridKt$itemsIndexed$1$1(function3, list);
        }
        lazyGridScope.items(size, function2, ComposableLambdaKt.composableLambdaInstance(-985534995, true, new LazyGridKt$itemsIndexed$2(function5, list)));
    }

    @ExperimentalFoundationApi
    public static final <T> void itemsIndexed(LazyGridScope lazyGridScope, List<? extends T> list, Function3<? super LazyGridItemSpanScope, ? super Integer, ? super T, GridItemSpan> function3, Function5<? super LazyItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5) {
        Function2 function2;
        Intrinsics.checkNotNullParameter(lazyGridScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "items");
        Intrinsics.checkNotNullParameter(function5, "itemContent");
        int size = list.size();
        if (function3 == null) {
            function2 = null;
        } else {
            function2 = new LazyGridKt$itemsIndexed$1$1(function3, list);
        }
        lazyGridScope.items(size, function2, ComposableLambdaKt.composableLambdaInstance(-985534995, true, new LazyGridKt$itemsIndexed$2(function5, list)));
    }

    public static /* synthetic */ void items$default(LazyGridScope lazyGridScope, Object[] objArr, Function2 function2, Function4 function4, int i, Object obj) {
        Function2 function22 = null;
        if ((i & 2) != 0) {
            function2 = null;
        }
        Intrinsics.checkNotNullParameter(lazyGridScope, "<this>");
        Intrinsics.checkNotNullParameter(objArr, "items");
        Intrinsics.checkNotNullParameter(function4, "itemContent");
        int length = objArr.length;
        if (function2 != null) {
            function22 = new LazyGridKt$items$3$1(function2, objArr);
        }
        lazyGridScope.items(length, function22, ComposableLambdaKt.composableLambdaInstance(-985534956, true, new LazyGridKt$items$4(function4, objArr)));
    }

    @ExperimentalFoundationApi
    public static final <T> void items(LazyGridScope lazyGridScope, T[] tArr, Function2<? super LazyGridItemSpanScope, ? super T, GridItemSpan> function2, Function4<? super LazyItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4) {
        Function2 function22;
        Intrinsics.checkNotNullParameter(lazyGridScope, "<this>");
        Intrinsics.checkNotNullParameter(tArr, "items");
        Intrinsics.checkNotNullParameter(function4, "itemContent");
        int length = tArr.length;
        if (function2 == null) {
            function22 = null;
        } else {
            function22 = new LazyGridKt$items$3$1(function2, tArr);
        }
        lazyGridScope.items(length, function22, ComposableLambdaKt.composableLambdaInstance(-985534956, true, new LazyGridKt$items$4(function4, tArr)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyGridScope lazyGridScope, Object[] objArr, Function3 function3, Function5 function5, int i, Object obj) {
        Function2 function2 = null;
        if ((i & 2) != 0) {
            function3 = null;
        }
        Intrinsics.checkNotNullParameter(lazyGridScope, "<this>");
        Intrinsics.checkNotNullParameter(objArr, "items");
        Intrinsics.checkNotNullParameter(function5, "itemContent");
        int length = objArr.length;
        if (function3 != null) {
            function2 = new LazyGridKt$itemsIndexed$3$1(function3, objArr);
        }
        lazyGridScope.items(length, function2, ComposableLambdaKt.composableLambdaInstance(-985541871, true, new LazyGridKt$itemsIndexed$4(function5, objArr)));
    }

    @ExperimentalFoundationApi
    public static final <T> void itemsIndexed(LazyGridScope lazyGridScope, T[] tArr, Function3<? super LazyGridItemSpanScope, ? super Integer, ? super T, GridItemSpan> function3, Function5<? super LazyItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5) {
        Function2 function2;
        Intrinsics.checkNotNullParameter(lazyGridScope, "<this>");
        Intrinsics.checkNotNullParameter(tArr, "items");
        Intrinsics.checkNotNullParameter(function5, "itemContent");
        int length = tArr.length;
        if (function3 == null) {
            function2 = null;
        } else {
            function2 = new LazyGridKt$itemsIndexed$3$1(function3, tArr);
        }
        lazyGridScope.items(length, function2, ComposableLambdaKt.composableLambdaInstance(-985541871, true, new LazyGridKt$itemsIndexed$4(function5, tArr)));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: kotlin.jvm.functions.Function1} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0158  */
    /* JADX WARNING: Removed duplicated region for block: B:91:? A[RETURN, SYNTHETIC] */
    @androidx.compose.foundation.ExperimentalFoundationApi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void FixedLazyGrid(int r20, androidx.compose.ui.Modifier r21, androidx.compose.foundation.lazy.LazyListState r22, androidx.compose.foundation.layout.PaddingValues r23, androidx.compose.foundation.layout.Arrangement.Vertical r24, androidx.compose.foundation.layout.Arrangement.Horizontal r25, kotlin.jvm.functions.Function1<? super androidx.compose.foundation.lazy.LazyGridScope, kotlin.Unit> r26, androidx.compose.runtime.Composer r27, int r28, int r29) {
        /*
            r1 = r20
            r6 = r25
            r7 = r26
            r8 = r28
            r0 = -901999209(0xffffffffca3c9597, float:-3089765.8)
            r2 = r27
            androidx.compose.runtime.Composer r0 = r2.startRestartGroup(r0)
            java.lang.String r2 = "C(FixedLazyGrid)P(4,3,5,1,6,2)252@9308L736,247@9147L897:LazyGrid.kt#428nma"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r2)
            r2 = r29 & 1
            if (r2 == 0) goto L_0x001d
            r2 = r8 | 6
            goto L_0x002d
        L_0x001d:
            r2 = r8 & 14
            if (r2 != 0) goto L_0x002c
            boolean r2 = r0.changed((int) r1)
            if (r2 == 0) goto L_0x0029
            r2 = 4
            goto L_0x002a
        L_0x0029:
            r2 = 2
        L_0x002a:
            r2 = r2 | r8
            goto L_0x002d
        L_0x002c:
            r2 = r8
        L_0x002d:
            r3 = r29 & 2
            if (r3 == 0) goto L_0x0034
            r2 = r2 | 48
            goto L_0x0047
        L_0x0034:
            r4 = r8 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x0047
            r4 = r21
            boolean r5 = r0.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0043
            r5 = 32
            goto L_0x0045
        L_0x0043:
            r5 = 16
        L_0x0045:
            r2 = r2 | r5
            goto L_0x0049
        L_0x0047:
            r4 = r21
        L_0x0049:
            r5 = r29 & 4
            if (r5 == 0) goto L_0x0050
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0063
        L_0x0050:
            r5 = r8 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x0063
            r5 = r22
            boolean r9 = r0.changed((java.lang.Object) r5)
            if (r9 == 0) goto L_0x005f
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x0061
        L_0x005f:
            r9 = 128(0x80, float:1.794E-43)
        L_0x0061:
            r2 = r2 | r9
            goto L_0x0065
        L_0x0063:
            r5 = r22
        L_0x0065:
            r9 = r29 & 8
            if (r9 == 0) goto L_0x006e
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            r15 = r23
            goto L_0x0080
        L_0x006e:
            r9 = r8 & 7168(0x1c00, float:1.0045E-41)
            r15 = r23
            if (r9 != 0) goto L_0x0080
            boolean r9 = r0.changed((java.lang.Object) r15)
            if (r9 == 0) goto L_0x007d
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x007f
        L_0x007d:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x007f:
            r2 = r2 | r9
        L_0x0080:
            r9 = r29 & 16
            r10 = 57344(0xe000, float:8.0356E-41)
            if (r9 == 0) goto L_0x008c
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            r14 = r24
            goto L_0x009e
        L_0x008c:
            r9 = r8 & r10
            r14 = r24
            if (r9 != 0) goto L_0x009e
            boolean r9 = r0.changed((java.lang.Object) r14)
            if (r9 == 0) goto L_0x009b
            r9 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009d
        L_0x009b:
            r9 = 8192(0x2000, float:1.14794E-41)
        L_0x009d:
            r2 = r2 | r9
        L_0x009e:
            r9 = r29 & 32
            if (r9 == 0) goto L_0x00a6
            r9 = 196608(0x30000, float:2.75506E-40)
        L_0x00a4:
            r2 = r2 | r9
            goto L_0x00b7
        L_0x00a6:
            r9 = 458752(0x70000, float:6.42848E-40)
            r9 = r9 & r8
            if (r9 != 0) goto L_0x00b7
            boolean r9 = r0.changed((java.lang.Object) r6)
            if (r9 == 0) goto L_0x00b4
            r9 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00a4
        L_0x00b4:
            r9 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00a4
        L_0x00b7:
            r9 = r29 & 64
            if (r9 == 0) goto L_0x00bf
            r9 = 1572864(0x180000, float:2.204052E-39)
        L_0x00bd:
            r2 = r2 | r9
            goto L_0x00d0
        L_0x00bf:
            r9 = 3670016(0x380000, float:5.142788E-39)
            r9 = r9 & r8
            if (r9 != 0) goto L_0x00d0
            boolean r9 = r0.changed((java.lang.Object) r7)
            if (r9 == 0) goto L_0x00cd
            r9 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00bd
        L_0x00cd:
            r9 = 524288(0x80000, float:7.34684E-40)
            goto L_0x00bd
        L_0x00d0:
            r9 = 2995931(0x2db6db, float:4.198194E-39)
            r9 = r9 & r2
            r11 = 599186(0x92492, float:8.39638E-40)
            r9 = r9 ^ r11
            if (r9 != 0) goto L_0x00e7
            boolean r9 = r0.getSkipping()
            if (r9 != 0) goto L_0x00e1
            goto L_0x00e7
        L_0x00e1:
            r0.skipToGroupEnd()
            r2 = r4
            goto L_0x0151
        L_0x00e7:
            if (r3 == 0) goto L_0x00ee
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x00ef
        L_0x00ee:
            r3 = r4
        L_0x00ef:
            r12 = 0
            r4 = 0
            r16 = 0
            java.lang.Integer r9 = java.lang.Integer.valueOf(r20)
            r11 = -3686095(0xffffffffffc7c131, float:NaN)
            r0.startReplaceableGroup(r11)
            java.lang.String r11 = "C(remember)P(1,2,3):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r11)
            boolean r9 = r0.changed((java.lang.Object) r9)
            boolean r11 = r0.changed((java.lang.Object) r7)
            r9 = r9 | r11
            boolean r11 = r0.changed((java.lang.Object) r6)
            r9 = r9 | r11
            java.lang.Object r11 = r0.rememberedValue()
            if (r9 != 0) goto L_0x011e
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r11 != r9) goto L_0x0129
        L_0x011e:
            androidx.compose.foundation.lazy.LazyGridKt$FixedLazyGrid$1$1 r9 = new androidx.compose.foundation.lazy.LazyGridKt$FixedLazyGrid$1$1
            r9.<init>(r1, r7, r6, r2)
            r11 = r9
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            r0.updateRememberedValue(r11)
        L_0x0129:
            r0.endReplaceableGroup()
            r17 = r11
            kotlin.jvm.functions.Function1 r17 = (kotlin.jvm.functions.Function1) r17
            int r9 = r2 >> 3
            r11 = r9 & 14
            r13 = r9 & 112(0x70, float:1.57E-43)
            r11 = r11 | r13
            r9 = r9 & 896(0x380, float:1.256E-42)
            r9 = r9 | r11
            r2 = r2 & r10
            r18 = r9 | r2
            r19 = 104(0x68, float:1.46E-43)
            r9 = r3
            r10 = r22
            r11 = r23
            r13 = r24
            r14 = r4
            r15 = r16
            r16 = r17
            r17 = r0
            androidx.compose.foundation.lazy.LazyDslKt.LazyColumn(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            r2 = r3
        L_0x0151:
            androidx.compose.runtime.ScopeUpdateScope r10 = r0.endRestartGroup()
            if (r10 != 0) goto L_0x0158
            goto L_0x0173
        L_0x0158:
            androidx.compose.foundation.lazy.LazyGridKt$FixedLazyGrid$2 r11 = new androidx.compose.foundation.lazy.LazyGridKt$FixedLazyGrid$2
            r0 = r11
            r1 = r20
            r3 = r22
            r4 = r23
            r5 = r24
            r6 = r25
            r7 = r26
            r8 = r28
            r9 = r29
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r10.updateScope(r11)
        L_0x0173:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyGridKt.FixedLazyGrid(int, androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.LazyListState, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final void ItemRow(int i, Arrangement.Horizontal horizontal, List<? extends Pair<? extends Function2<? super Composer, ? super Integer, Unit>, Integer>> list, Composer composer, int i2) {
        Composer startRestartGroup = composer.startRestartGroup(-506699774);
        ComposerKt.sourceInformation(startRestartGroup, "C(ItemRow)P(1)445@17372L1257:LazyGrid.kt#428nma");
        MeasurePolicy lazyGridKt$ItemRow$2 = new LazyGridKt$ItemRow$2(list, horizontal, i);
        startRestartGroup.startReplaceableGroup(1376089394);
        ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)72@2847L7,73@2902L7,74@2961L7,75@2973L460:Layout.kt#80mrfh");
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
        Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        Density density = (Density) consume;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
        Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        LayoutDirection layoutDirection = (LayoutDirection) consume2;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
        Object consume3 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ViewConfiguration viewConfiguration = (ViewConfiguration) consume3;
        Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(Modifier.Companion);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
            startRestartGroup.createNode(constructor);
        } else {
            startRestartGroup.useNode();
        }
        startRestartGroup.disableReusing();
        Composer r4 = Updater.m1234constructorimpl(startRestartGroup);
        Updater.m1241setimpl(r4, lazyGridKt$ItemRow$2, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m1241setimpl(r4, density, ComposeUiNode.Companion.getSetDensity());
        Updater.m1241setimpl(r4, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
        Updater.m1241setimpl(r4, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
        startRestartGroup.enableReusing();
        materializerOf.invoke(SkippableUpdater.m1225boximpl(SkippableUpdater.m1226constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        startRestartGroup.startReplaceableGroup(-97970863);
        ComposerKt.sourceInformation(startRestartGroup, "C*447@17445L8:LazyGrid.kt#428nma");
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((Function2) ((Pair) list.get(i3)).getFirst()).invoke(startRestartGroup, 0);
        }
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new LazyGridKt$ItemRow$3(i, horizontal, list, i2));
        }
    }
}
