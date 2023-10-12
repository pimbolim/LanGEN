package androidx.compose.foundation.lazy.list;

import androidx.compose.foundation.gestures.OverScrollController;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.layout.LazyMeasurePolicy;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u0018H\u0001¢\u0006\u0002\u0010\u0019\u001a=\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010%\u001a\u0001\u0010&\u001a\u00020'2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010.\u001a\u00020/H\u0003¢\u0006\u0002\u00100\u001a/\u00101\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020-0,2\u0006\u00102\u001a\u0002032\u0006\u0010\u001f\u001a\u00020 H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b4\u00105\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00066"}, d2 = {"LazyList", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "isVertical", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/LazyListScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/gestures/FlingBehavior;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "refreshOverScrollInfo", "overScrollController", "Landroidx/compose/foundation/gestures/OverScrollController;", "result", "Landroidx/compose/foundation/lazy/list/LazyListMeasureResult;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "totalHorizontalPadding", "", "totalVerticalPadding", "refreshOverScrollInfo-L1NQ6kE", "(Landroidx/compose/foundation/gestures/OverScrollController;Landroidx/compose/foundation/lazy/list/LazyListMeasureResult;JII)V", "rememberLazyListMeasurePolicy", "Landroidx/compose/foundation/lazy/layout/LazyMeasurePolicy;", "stateOfItemsProvider", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/lazy/list/LazyListItemsProvider;", "itemScope", "Landroidx/compose/ui/node/Ref;", "Landroidx/compose/foundation/lazy/list/LazyItemScopeImpl;", "placementAnimator", "Landroidx/compose/foundation/lazy/list/LazyListItemPlacementAnimator;", "(Landroidx/compose/runtime/State;Landroidx/compose/ui/node/Ref;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/gestures/OverScrollController;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/lazy/list/LazyListItemPlacementAnimator;Landroidx/compose/runtime/Composer;III)Landroidx/compose/foundation/lazy/layout/LazyMeasurePolicy;", "update", "density", "Landroidx/compose/ui/unit/Density;", "update-3p2s80s", "(Landroidx/compose/ui/node/Ref;Landroidx/compose/ui/unit/Density;J)V", "foundation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: LazyList.kt */
public final class LazyListKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: androidx.compose.foundation.lazy.list.LazyListItemPlacementAnimator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v11, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x017e  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x018a  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x037e  */
    /* JADX WARNING: Removed duplicated region for block: B:167:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0137  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void LazyList(androidx.compose.ui.Modifier r29, androidx.compose.foundation.lazy.LazyListState r30, androidx.compose.foundation.layout.PaddingValues r31, boolean r32, boolean r33, androidx.compose.foundation.gestures.FlingBehavior r34, androidx.compose.ui.Alignment.Horizontal r35, androidx.compose.foundation.layout.Arrangement.Vertical r36, androidx.compose.ui.Alignment.Vertical r37, androidx.compose.foundation.layout.Arrangement.Horizontal r38, kotlin.jvm.functions.Function1<? super androidx.compose.foundation.lazy.LazyListScope, kotlin.Unit> r39, androidx.compose.runtime.Composer r40, int r41, int r42, int r43) {
        /*
            r6 = r29
            r5 = r30
            r4 = r31
            r3 = r32
            r2 = r33
            r1 = r34
            r0 = r39
            r15 = r41
            r14 = r43
            java.lang.String r7 = "modifier"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r7)
            java.lang.String r7 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r7)
            java.lang.String r7 = "contentPadding"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r7)
            java.lang.String r7 = "flingBehavior"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r7)
            java.lang.String r7 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r7)
            r7 = 1557877152(0x5cdb51a0, float:4.9386214E17)
            r8 = r40
            androidx.compose.runtime.Composer r13 = r8.startRestartGroup(r7)
            java.lang.String r7 = "C(LazyList)P(6,8,1,7,5,2,3,10,9,4)77@3634L30,79@3710L18,81@3761L55,83@3834L24,84@3887L92,89@4053L339,104@4421L34,*105@4477L25,143@6188L30,112@4709L1515:LazyList.kt#77c2e6"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r7)
            r7 = r14 & 1
            if (r7 == 0) goto L_0x0041
            r7 = r15 | 6
            goto L_0x0051
        L_0x0041:
            r7 = r15 & 14
            if (r7 != 0) goto L_0x0050
            boolean r7 = r13.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x004d
            r7 = 4
            goto L_0x004e
        L_0x004d:
            r7 = 2
        L_0x004e:
            r7 = r7 | r15
            goto L_0x0051
        L_0x0050:
            r7 = r15
        L_0x0051:
            r10 = r14 & 2
            if (r10 == 0) goto L_0x0058
            r7 = r7 | 48
            goto L_0x0068
        L_0x0058:
            r10 = r15 & 112(0x70, float:1.57E-43)
            if (r10 != 0) goto L_0x0068
            boolean r10 = r13.changed((java.lang.Object) r5)
            if (r10 == 0) goto L_0x0065
            r10 = 32
            goto L_0x0067
        L_0x0065:
            r10 = 16
        L_0x0067:
            r7 = r7 | r10
        L_0x0068:
            r10 = r14 & 4
            if (r10 == 0) goto L_0x006f
            r7 = r7 | 384(0x180, float:5.38E-43)
            goto L_0x007f
        L_0x006f:
            r10 = r15 & 896(0x380, float:1.256E-42)
            if (r10 != 0) goto L_0x007f
            boolean r10 = r13.changed((java.lang.Object) r4)
            if (r10 == 0) goto L_0x007c
            r10 = 256(0x100, float:3.59E-43)
            goto L_0x007e
        L_0x007c:
            r10 = 128(0x80, float:1.794E-43)
        L_0x007e:
            r7 = r7 | r10
        L_0x007f:
            r10 = r14 & 8
            if (r10 == 0) goto L_0x0086
            r7 = r7 | 3072(0xc00, float:4.305E-42)
            goto L_0x0096
        L_0x0086:
            r10 = r15 & 7168(0x1c00, float:1.0045E-41)
            if (r10 != 0) goto L_0x0096
            boolean r10 = r13.changed((boolean) r3)
            if (r10 == 0) goto L_0x0093
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x0095
        L_0x0093:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x0095:
            r7 = r7 | r10
        L_0x0096:
            r10 = r14 & 16
            r11 = 57344(0xe000, float:8.0356E-41)
            if (r10 == 0) goto L_0x00a0
            r7 = r7 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00b0
        L_0x00a0:
            r10 = r15 & r11
            if (r10 != 0) goto L_0x00b0
            boolean r10 = r13.changed((boolean) r2)
            if (r10 == 0) goto L_0x00ad
            r10 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00af
        L_0x00ad:
            r10 = 8192(0x2000, float:1.14794E-41)
        L_0x00af:
            r7 = r7 | r10
        L_0x00b0:
            r10 = r14 & 32
            r12 = 458752(0x70000, float:6.42848E-40)
            if (r10 == 0) goto L_0x00ba
            r10 = 196608(0x30000, float:2.75506E-40)
        L_0x00b8:
            r7 = r7 | r10
            goto L_0x00ca
        L_0x00ba:
            r10 = r15 & r12
            if (r10 != 0) goto L_0x00ca
            boolean r10 = r13.changed((java.lang.Object) r1)
            if (r10 == 0) goto L_0x00c7
            r10 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b8
        L_0x00c7:
            r10 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00b8
        L_0x00ca:
            r10 = r14 & 64
            r16 = 3670016(0x380000, float:5.142788E-39)
            if (r10 == 0) goto L_0x00d7
            r17 = 1572864(0x180000, float:2.204052E-39)
            r7 = r7 | r17
            r8 = r35
            goto L_0x00ea
        L_0x00d7:
            r17 = r15 & r16
            r8 = r35
            if (r17 != 0) goto L_0x00ea
            boolean r17 = r13.changed((java.lang.Object) r8)
            if (r17 == 0) goto L_0x00e6
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e8
        L_0x00e6:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00e8:
            r7 = r7 | r17
        L_0x00ea:
            r12 = r14 & 128(0x80, float:1.794E-43)
            r18 = 29360128(0x1c00000, float:7.052966E-38)
            if (r12 == 0) goto L_0x00f7
            r19 = 12582912(0xc00000, float:1.7632415E-38)
            r7 = r7 | r19
            r11 = r36
            goto L_0x010a
        L_0x00f7:
            r19 = r15 & r18
            r11 = r36
            if (r19 != 0) goto L_0x010a
            boolean r20 = r13.changed((java.lang.Object) r11)
            if (r20 == 0) goto L_0x0106
            r20 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0108
        L_0x0106:
            r20 = 4194304(0x400000, float:5.877472E-39)
        L_0x0108:
            r7 = r7 | r20
        L_0x010a:
            r9 = r14 & 256(0x100, float:3.59E-43)
            r21 = 234881024(0xe000000, float:1.5777218E-30)
            if (r9 == 0) goto L_0x0117
            r22 = 100663296(0x6000000, float:2.4074124E-35)
            r7 = r7 | r22
            r1 = r37
            goto L_0x012a
        L_0x0117:
            r22 = r15 & r21
            r1 = r37
            if (r22 != 0) goto L_0x012a
            boolean r22 = r13.changed((java.lang.Object) r1)
            if (r22 == 0) goto L_0x0126
            r22 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0128
        L_0x0126:
            r22 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0128:
            r7 = r7 | r22
        L_0x012a:
            r1 = r14 & 512(0x200, float:7.175E-43)
            r22 = 1879048192(0x70000000, float:1.58456325E29)
            if (r1 == 0) goto L_0x0137
            r23 = 805306368(0x30000000, float:4.656613E-10)
            r7 = r7 | r23
            r3 = r38
            goto L_0x014a
        L_0x0137:
            r23 = r15 & r22
            r3 = r38
            if (r23 != 0) goto L_0x014a
            boolean r23 = r13.changed((java.lang.Object) r3)
            if (r23 == 0) goto L_0x0146
            r23 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0148
        L_0x0146:
            r23 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0148:
            r7 = r7 | r23
        L_0x014a:
            r3 = r14 & 1024(0x400, float:1.435E-42)
            if (r3 == 0) goto L_0x0151
            r3 = r42 | 6
            goto L_0x0163
        L_0x0151:
            r3 = r42 & 14
            if (r3 != 0) goto L_0x0161
            boolean r3 = r13.changed((java.lang.Object) r0)
            if (r3 == 0) goto L_0x015d
            r3 = 4
            goto L_0x015e
        L_0x015d:
            r3 = 2
        L_0x015e:
            r3 = r42 | r3
            goto L_0x0163
        L_0x0161:
            r3 = r42
        L_0x0163:
            r23 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r23 = r7 & r23
            r24 = 306783378(0x12492492, float:6.3469493E-28)
            r23 = r23 ^ r24
            if (r23 != 0) goto L_0x018a
            r23 = r3 & 11
            r20 = 2
            r20 = r23 ^ 2
            if (r20 != 0) goto L_0x018a
            boolean r20 = r13.getSkipping()
            if (r20 != 0) goto L_0x017e
            goto L_0x018a
        L_0x017e:
            r13.skipToGroupEnd()
            r9 = r37
            r10 = r38
            r7 = r8
            r8 = r11
            r2 = r13
            goto L_0x0377
        L_0x018a:
            r20 = 0
            if (r10 == 0) goto L_0x0191
            r23 = r20
            goto L_0x0193
        L_0x0191:
            r23 = r8
        L_0x0193:
            if (r12 == 0) goto L_0x0198
            r24 = r20
            goto L_0x019a
        L_0x0198:
            r24 = r11
        L_0x019a:
            if (r9 == 0) goto L_0x019f
            r25 = r20
            goto L_0x01a1
        L_0x019f:
            r25 = r37
        L_0x01a1:
            if (r1 == 0) goto L_0x01a6
            r26 = r20
            goto L_0x01a8
        L_0x01a6:
            r26 = r38
        L_0x01a8:
            r1 = 0
            androidx.compose.foundation.gestures.OverScrollController r27 = androidx.compose.foundation.gestures.AndroidOverScrollKt.rememberOverScrollController(r13, r1)
            r8 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r13.startReplaceableGroup(r8)
            java.lang.String r8 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r8)
            java.lang.Object r8 = r13.rememberedValue()
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r8 != r9) goto L_0x01cc
            androidx.compose.ui.node.Ref r8 = new androidx.compose.ui.node.Ref
            r8.<init>()
            r13.updateRememberedValue(r8)
        L_0x01cc:
            r13.endReplaceableGroup()
            androidx.compose.ui.node.Ref r8 = (androidx.compose.ui.node.Ref) r8
            int r9 = r7 >> 3
            r9 = r9 & 14
            int r3 = r3 << 3
            r3 = r3 & 112(0x70, float:1.57E-43)
            r3 = r3 | r9
            int r9 = androidx.compose.ui.node.Ref.$stable
            int r9 = r9 << 6
            r3 = r3 | r9
            androidx.compose.runtime.State r3 = androidx.compose.foundation.lazy.list.LazyListItemsProviderImplKt.rememberStateOfItemsProvider(r5, r0, r8, r13, r3)
            r9 = -723524056(0xffffffffd4dfe628, float:-7.6931127E12)
            r13.startReplaceableGroup(r9)
            java.lang.String r9 = "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r9)
            r9 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r13.startReplaceableGroup(r9)
            java.lang.String r9 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r9)
            java.lang.Object r9 = r13.rememberedValue()
            androidx.compose.runtime.Composer$Companion r10 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r10 = r10.getEmpty()
            if (r9 != r10) goto L_0x0216
            kotlin.coroutines.EmptyCoroutineContext r9 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlin.coroutines.CoroutineContext r9 = (kotlin.coroutines.CoroutineContext) r9
            kotlinx.coroutines.CoroutineScope r9 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r9, r13)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r10 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r10.<init>(r9)
            r13.updateRememberedValue(r10)
            r9 = r10
        L_0x0216:
            r13.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r9 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r9
            kotlinx.coroutines.CoroutineScope r12 = r9.getCoroutineScope()
            r13.endReplaceableGroup()
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r33)
            r10 = -3686552(0xffffffffffc7bf68, float:NaN)
            r13.startReplaceableGroup(r10)
            java.lang.String r10 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r10)
            boolean r10 = r13.changed((java.lang.Object) r5)
            boolean r9 = r13.changed((java.lang.Object) r9)
            r9 = r9 | r10
            java.lang.Object r10 = r13.rememberedValue()
            if (r9 != 0) goto L_0x0248
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r10 != r9) goto L_0x0250
        L_0x0248:
            androidx.compose.foundation.lazy.list.LazyListItemPlacementAnimator r10 = new androidx.compose.foundation.lazy.list.LazyListItemPlacementAnimator
            r10.<init>(r12, r2)
            r13.updateRememberedValue(r10)
        L_0x0250:
            r13.endReplaceableGroup()
            r11 = r10
            androidx.compose.foundation.lazy.list.LazyListItemPlacementAnimator r11 = (androidx.compose.foundation.lazy.list.LazyListItemPlacementAnimator) r11
            r5.setPlacementAnimator$foundation_release(r11)
            int r9 = androidx.compose.ui.node.Ref.$stable
            int r9 = r9 << 3
            int r10 = r7 << 3
            r1 = r10 & 896(0x380, float:1.256E-42)
            r1 = r1 | r9
            int r9 = r7 << 6
            r19 = 57344(0xe000, float:8.0356E-41)
            r19 = r9 & r19
            r1 = r1 | r19
            r17 = 458752(0x70000, float:6.42848E-40)
            r17 = r9 & r17
            r1 = r1 | r17
            r9 = r9 & r16
            r1 = r1 | r9
            r9 = r10 & r18
            r1 = r1 | r9
            r9 = r7 & r21
            r1 = r1 | r9
            r9 = r7 & r22
            r20 = r1 | r9
            int r1 = r7 >> 21
            r1 = r1 & 14
            r21 = r1 | 64
            r22 = 0
            r7 = r3
            r9 = r30
            r10 = r27
            r1 = r11
            r11 = r31
            r28 = r12
            r12 = r32
            r36 = r13
            r13 = r33
            r14 = r23
            r15 = r25
            r16 = r26
            r17 = r24
            r18 = r1
            r19 = r36
            androidx.compose.foundation.lazy.layout.LazyMeasurePolicy r17 = rememberLazyListMeasurePolicy(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            r15 = r36
            r1 = 0
            androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchPolicy r7 = androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchPolicyKt.rememberLazyLayoutPrefetchPolicy(r15, r1)
            r5.setPrefetchPolicy$foundation_release(r7)
            androidx.compose.foundation.lazy.layout.LazyLayoutState r14 = androidx.compose.foundation.lazy.layout.LazyLayoutStateKt.rememberLazyLayoutState(r15, r1)
            r5.setInnerState$foundation_release(r14)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            java.lang.Object r7 = r3.getValue()
            androidx.compose.foundation.lazy.list.LazyListItemsProvider r7 = (androidx.compose.foundation.lazy.list.LazyListItemsProvider) r7
            int r8 = r7.getItemsCount()
            if (r8 <= 0) goto L_0x02c8
            r5.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(r7)
        L_0x02c8:
            r0 = r29
            r7 = 0
            r1 = r3
            r13 = r2
            r2 = r30
            r12 = r3
            r3 = r28
            r4 = r33
            r5 = r32
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.lazy.list.LazySemanticsKt.lazyListSemantics(r0, r1, r2, r3, r4, r5)
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.ScrollKt.clipScrollableContainer(r0, r13)
            if (r13 == 0) goto L_0x02e3
            androidx.compose.foundation.gestures.Orientation r1 = androidx.compose.foundation.gestures.Orientation.Vertical
            goto L_0x02e5
        L_0x02e3:
            androidx.compose.foundation.gestures.Orientation r1 = androidx.compose.foundation.gestures.Orientation.Horizontal
        L_0x02e5:
            r9 = r1
            r1 = 1557879940(0x5cdb5c84, float:4.93957935E17)
            r15.startReplaceableGroup(r1)
            java.lang.String r1 = "*129@5610L7"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r1)
            r1 = r32 ^ 1
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r3 = 103361330(0x6292b32, float:3.1817102E-35)
            java.lang.String r4 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r3, r4)
            java.lang.Object r2 = r15.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r15)
            androidx.compose.ui.unit.LayoutDirection r3 = androidx.compose.ui.unit.LayoutDirection.Rtl
            if (r2 != r3) goto L_0x030e
            r2 = 1
            goto L_0x030f
        L_0x030e:
            r2 = 0
        L_0x030f:
            if (r2 == 0) goto L_0x0315
            if (r13 != 0) goto L_0x0315
            r1 = r1 ^ 1
        L_0x0315:
            r15.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = r30.getInternalInteractionSource$foundation_release()
            r8 = r30
            androidx.compose.foundation.gestures.ScrollableState r8 = (androidx.compose.foundation.gestures.ScrollableState) r8
            r11 = 0
            r3 = 8
            r16 = 0
            r7 = r0
            r10 = r27
            r0 = r12
            r12 = r1
            r13 = r34
            r1 = r14
            r14 = r2
            r2 = r15
            r15 = r3
            androidx.compose.ui.Modifier r9 = androidx.compose.foundation.gestures.ScrollableKt.scrollable$default(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchPolicy r11 = r30.getPrefetchPolicy$foundation_release()
            r3 = -3686930(0xffffffffffc7bdee, float:NaN)
            r2.startReplaceableGroup(r3)
            java.lang.String r3 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            boolean r3 = r2.changed((java.lang.Object) r0)
            java.lang.Object r4 = r2.rememberedValue()
            if (r3 != 0) goto L_0x0355
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r4 != r3) goto L_0x0360
        L_0x0355:
            androidx.compose.foundation.lazy.list.LazyListKt$LazyList$2$1 r3 = new androidx.compose.foundation.lazy.list.LazyListKt$LazyList$2$1
            r3.<init>(r0)
            r4 = r3
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            r2.updateRememberedValue(r4)
        L_0x0360:
            r2.endReplaceableGroup()
            r8 = r4
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            r14 = 0
            r15 = 0
            r10 = r1
            r12 = r17
            r13 = r2
            androidx.compose.foundation.lazy.layout.LazyLayoutKt.LazyLayout(r8, r9, r10, r11, r12, r13, r14, r15)
            r7 = r23
            r8 = r24
            r9 = r25
            r10 = r26
        L_0x0377:
            androidx.compose.runtime.ScopeUpdateScope r15 = r2.endRestartGroup()
            if (r15 != 0) goto L_0x037e
            goto L_0x03a0
        L_0x037e:
            androidx.compose.foundation.lazy.list.LazyListKt$LazyList$3 r16 = new androidx.compose.foundation.lazy.list.LazyListKt$LazyList$3
            r0 = r16
            r1 = r29
            r2 = r30
            r3 = r31
            r4 = r32
            r5 = r33
            r6 = r34
            r11 = r39
            r12 = r41
            r13 = r42
            r14 = r43
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r15.updateScope(r0)
        L_0x03a0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.list.LazyListKt.LazyList(androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.LazyListState, androidx.compose.foundation.layout.PaddingValues, boolean, boolean, androidx.compose.foundation.gestures.FlingBehavior, androidx.compose.ui.Alignment$Horizontal, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.ui.Alignment$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int, int):void");
    }

    private static final LazyMeasurePolicy rememberLazyListMeasurePolicy(State<? extends LazyListItemsProvider> state, Ref<LazyItemScopeImpl> ref, LazyListState lazyListState, OverScrollController overScrollController, PaddingValues paddingValues, boolean z, boolean z2, Alignment.Horizontal horizontal, Alignment.Vertical vertical, Arrangement.Horizontal horizontal2, Arrangement.Vertical vertical2, LazyListItemPlacementAnimator lazyListItemPlacementAnimator, Composer composer, int i, int i2, int i3) {
        Composer composer2 = composer;
        int i4 = i3;
        composer2.startReplaceableGroup(208079303);
        ComposerKt.sourceInformation(composer2, "C(rememberLazyListMeasurePolicy)P(9,4,8,5!1,7,3!1,10!1,11)173@7628L5234:LazyList.kt#77c2e6");
        Alignment.Horizontal horizontal3 = (i4 & 128) != 0 ? null : horizontal;
        Alignment.Vertical vertical3 = (i4 & 256) != 0 ? null : vertical;
        Arrangement.Horizontal horizontal4 = (i4 & 512) != 0 ? null : horizontal2;
        Arrangement.Vertical vertical4 = (i4 & 1024) != 0 ? null : vertical2;
        int i5 = 0;
        Object[] objArr = {lazyListState, overScrollController, paddingValues, Boolean.valueOf(z), Boolean.valueOf(z2), horizontal3, vertical3, horizontal4, vertical4, lazyListItemPlacementAnimator};
        composer2.startReplaceableGroup(-3685570);
        ComposerKt.sourceInformation(composer2, "C(remember)P(1):Composables.kt#9igjgp");
        boolean z3 = false;
        while (i5 < 10) {
            Object obj = objArr[i5];
            i5++;
            z3 |= composer2.changed(obj);
        }
        Object rememberedValue = composer.rememberedValue();
        if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new LazyListKt$rememberLazyListMeasurePolicy$1$1(z2, paddingValues, z, state, lazyListState, ref, vertical4, horizontal4, lazyListItemPlacementAnimator, horizontal3, vertical3, overScrollController);
            composer2.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        LazyMeasurePolicy lazyMeasurePolicy = (LazyMeasurePolicy) rememberedValue;
        composer.endReplaceableGroup();
        return lazyMeasurePolicy;
    }

    /* access modifiers changed from: private */
    /* renamed from: update-3p2s80s  reason: not valid java name */
    public static final void m559update3p2s80s(Ref<LazyItemScopeImpl> ref, Density density, long j) {
        LazyItemScopeImpl value = ref.getValue();
        if (value == null || !Intrinsics.areEqual((Object) value.getDensity(), (Object) density) || !Constraints.m3796equalsimpl0(value.m551getConstraintsmsEJaDk(), j)) {
            ref.setValue(new LazyItemScopeImpl(density, j, (DefaultConstructorMarker) null));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: refreshOverScrollInfo-L1NQ6kE  reason: not valid java name */
    public static final void m558refreshOverScrollInfoL1NQ6kE(OverScrollController overScrollController, LazyListMeasureResult lazyListMeasureResult, long j, int i, int i2) {
        boolean canScrollForward = lazyListMeasureResult.getCanScrollForward();
        LazyMeasuredItem firstVisibleItem = lazyListMeasureResult.getFirstVisibleItem();
        boolean z = false;
        boolean z2 = ((firstVisibleItem == null ? 0 : firstVisibleItem.getIndex()) == 0 && lazyListMeasureResult.getFirstVisibleItemScrollOffset() == 0) ? false : true;
        long Size = SizeKt.Size((float) ConstraintsKt.m3817constrainWidthK40F9xA(j, lazyListMeasureResult.getWidth() + i), (float) ConstraintsKt.m3816constrainHeightK40F9xA(j, lazyListMeasureResult.getHeight() + i2));
        if (canScrollForward || z2) {
            z = true;
        }
        overScrollController.m282refreshContainerInfoTmRCtEA(Size, z);
    }
}
