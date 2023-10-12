package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aá\u0002\u0010\u0003\u001a\u00020\u00042\u001c\u0010\u0005\u001a\u0018\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0002\b\b¢\u0006\u0002\b\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000f¢\u0006\u0002\b\b2\u0019\b\u0002\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0002\b\b2\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000f¢\u0006\u0002\b\b2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00012\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\u00012 \b\u0002\u0010\u001e\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006¢\u0006\u0002\b\b¢\u0006\u0002\b\t2\b\b\u0002\u0010\u001f\u001a\u00020\u00162\b\b\u0002\u0010 \u001a\u00020\u00182\b\b\u0002\u0010!\u001a\u00020\u00012\b\b\u0002\u0010\"\u001a\u00020\u001b2\b\b\u0002\u0010#\u001a\u00020\u001b2\b\b\u0002\u0010$\u001a\u00020\u001b2\b\b\u0002\u0010%\u001a\u00020\u001b2\b\b\u0002\u0010&\u001a\u00020\u001b2\u0017\u0010'\u001a\u0013\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0002\b\bH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010*\u001aw\u0010+\u001a\u00020\u00042\u0011\u0010,\u001a\r\u0012\u0004\u0012\u00020\u00040\u000f¢\u0006\u0002\b\b2\u0011\u0010-\u001a\r\u0012\u0004\u0012\u00020\u00040\u000f¢\u0006\u0002\b\b2\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00040\u000f¢\u0006\u0002\b\b2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00040\u000f¢\u0006\u0002\b\b2\f\u0010.\u001a\b\u0012\u0004\u0012\u0002000/2\u0006\u0010\u0013\u001a\u00020\u0014H\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b1\u00102\u001a+\u00103\u001a\u00020\r2\b\b\u0002\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u0002072\b\b\u0002\u00108\u001a\u00020\u0011H\u0007¢\u0006\u0002\u00109\u001a;\u0010:\u001a\u0002072\u0006\u0010;\u001a\u00020<2\u000e\b\u0002\u0010=\u001a\b\u0012\u0004\u0012\u0002000>2\u0014\b\u0002\u0010?\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\u00160\u0006H\u0007¢\u0006\u0002\u0010@\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006A"}, d2 = {"FabEndSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "BottomSheetScaffold", "", "sheetContent", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "scaffoldState", "Landroidx/compose/material/BottomSheetScaffoldState;", "topBar", "Lkotlin/Function0;", "snackbarHost", "Landroidx/compose/material/SnackbarHostState;", "floatingActionButton", "floatingActionButtonPosition", "Landroidx/compose/material/FabPosition;", "sheetGesturesEnabled", "", "sheetShape", "Landroidx/compose/ui/graphics/Shape;", "sheetElevation", "sheetBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "sheetContentColor", "sheetPeekHeight", "drawerContent", "drawerGesturesEnabled", "drawerShape", "drawerElevation", "drawerBackgroundColor", "drawerContentColor", "drawerScrimColor", "backgroundColor", "contentColor", "content", "Landroidx/compose/foundation/layout/PaddingValues;", "BottomSheetScaffold-bGncdBI", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/BottomSheetScaffoldState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;IZLandroidx/compose/ui/graphics/Shape;FJJFLkotlin/jvm/functions/Function3;ZLandroidx/compose/ui/graphics/Shape;FJJJJJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;IIII)V", "BottomSheetScaffoldStack", "body", "bottomSheet", "bottomSheetOffset", "Landroidx/compose/runtime/State;", "", "BottomSheetScaffoldStack-SlNgfk0", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/State;ILandroidx/compose/runtime/Composer;I)V", "rememberBottomSheetScaffoldState", "drawerState", "Landroidx/compose/material/DrawerState;", "bottomSheetState", "Landroidx/compose/material/BottomSheetState;", "snackbarHostState", "(Landroidx/compose/material/DrawerState;Landroidx/compose/material/BottomSheetState;Landroidx/compose/material/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BottomSheetScaffoldState;", "rememberBottomSheetState", "initialValue", "Landroidx/compose/material/BottomSheetValue;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "confirmStateChange", "(Landroidx/compose/material/BottomSheetValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BottomSheetState;", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: BottomSheetScaffold.kt */
public final class BottomSheetScaffoldKt {
    /* access modifiers changed from: private */
    public static final float FabEndSpacing = Dp.m3859constructorimpl((float) 16);

    @ExperimentalMaterialApi
    public static final BottomSheetState rememberBottomSheetState(BottomSheetValue bottomSheetValue, AnimationSpec<Float> animationSpec, Function1<? super BottomSheetValue, Boolean> function1, Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(bottomSheetValue, "initialValue");
        composer.startReplaceableGroup(1877845424);
        ComposerKt.sourceInformation(composer, "C(rememberBottomSheetState)P(2)156@5647L371:BottomSheetScaffold.kt#jmzs0o");
        AnimationSpec<Float> animationSpec2 = animationSpec;
        if ((i2 & 2) != 0) {
            animationSpec2 = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        Function1<? super BottomSheetValue, Boolean> function12 = function1;
        if ((i2 & 4) != 0) {
            function12 = BottomSheetScaffoldKt$rememberBottomSheetState$1.INSTANCE;
        }
        BottomSheetState bottomSheetState = (BottomSheetState) RememberSaveableKt.rememberSaveable(new Object[]{animationSpec2}, BottomSheetState.Companion.Saver(animationSpec2, function12), (String) null, new BottomSheetScaffoldKt$rememberBottomSheetState$2(bottomSheetValue, animationSpec2, function12), composer, 72, 4);
        composer.endReplaceableGroup();
        return bottomSheetState;
    }

    @ExperimentalMaterialApi
    public static final BottomSheetScaffoldState rememberBottomSheetScaffoldState(DrawerState drawerState, BottomSheetState bottomSheetState, SnackbarHostState snackbarHostState, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1807566285);
        ComposerKt.sourceInformation(composer, "C(rememberBottomSheetScaffoldState)P(1)196@6892L39,197@6974L52,198@7071L32,200@7145L248:BottomSheetScaffold.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            drawerState = DrawerKt.rememberDrawerState(DrawerValue.Closed, (Function1<? super DrawerValue, Boolean>) null, composer, 6, 2);
        }
        if ((i2 & 2) != 0) {
            bottomSheetState = rememberBottomSheetState(BottomSheetValue.Collapsed, (AnimationSpec<Float>) null, (Function1<? super BottomSheetValue, Boolean>) null, composer, 6, 6);
        }
        if ((i2 & 4) != 0) {
            composer.startReplaceableGroup(-3687241);
            ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new SnackbarHostState();
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            snackbarHostState = (SnackbarHostState) rememberedValue;
        }
        composer.startReplaceableGroup(-3686095);
        ComposerKt.sourceInformation(composer, "C(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean changed = composer.changed((Object) drawerState) | composer.changed((Object) bottomSheetState) | composer.changed((Object) snackbarHostState);
        Object rememberedValue2 = composer.rememberedValue();
        if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new BottomSheetScaffoldState(drawerState, bottomSheetState, snackbarHostState);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        BottomSheetScaffoldState bottomSheetScaffoldState = (BottomSheetScaffoldState) rememberedValue2;
        composer.endReplaceableGroup();
        return bottomSheetScaffoldState;
    }

    /* JADX WARNING: Removed duplicated region for block: B:109:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0180  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0188  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x019c  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x01a4  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x01a7  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x01c3  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x01c6  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x01e0  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x01e3  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x0204  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x021b  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0223  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x022a  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x0245  */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x0259  */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x0261  */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x0277  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x027f  */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x0293  */
    /* JADX WARNING: Removed duplicated region for block: B:210:0x029b  */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x02af  */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x02b6  */
    /* JADX WARNING: Removed duplicated region for block: B:227:0x02cc  */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x02d4  */
    /* JADX WARNING: Removed duplicated region for block: B:231:0x02d7  */
    /* JADX WARNING: Removed duplicated region for block: B:245:0x030a  */
    /* JADX WARNING: Removed duplicated region for block: B:246:0x0337  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:361:0x0689  */
    /* JADX WARNING: Removed duplicated region for block: B:363:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x014c  */
    @androidx.compose.material.ExperimentalMaterialApi
    /* renamed from: BottomSheetScaffold-bGncdBI  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m868BottomSheetScaffoldbGncdBI(kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r69, androidx.compose.ui.Modifier r70, androidx.compose.material.BottomSheetScaffoldState r71, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r72, kotlin.jvm.functions.Function3<? super androidx.compose.material.SnackbarHostState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r73, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r74, int r75, boolean r76, androidx.compose.ui.graphics.Shape r77, float r78, long r79, long r81, float r83, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r84, boolean r85, androidx.compose.ui.graphics.Shape r86, float r87, long r88, long r90, long r92, long r94, long r96, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.PaddingValues, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r98, androidx.compose.runtime.Composer r99, int r100, int r101, int r102, int r103) {
        /*
            r14 = r69
            r13 = r98
            r11 = r100
            r12 = r101
            r9 = r102
            r10 = r103
            java.lang.String r0 = "sheetContent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            r0 = 1207988588(0x4800716c, float:131525.69)
            r1 = r99
            androidx.compose.runtime.Composer r7 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(BottomSheetScaffold)P(15,12,13,22,21,10,11:c#material.FabPosition,18,20,17:c#ui.unit.Dp,14:c#ui.graphics.Color,16:c#ui.graphics.Color,19:c#ui.unit.Dp,4,7,9,6:c#ui.unit.Dp,3:c#ui.graphics.Color,5:c#ui.graphics.Color,8:c#ui.graphics.Color,0:c#ui.graphics.Color,2:c#ui.graphics.Color)261@10736L34,267@11105L6,269@11236L6,270@11283L37,274@11540L6,276@11655L6,277@11703L38,278@11788L10,279@11843L6,280@11888L32,283@11991L24,284@12020L3903:BottomSheetScaffold.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r0)
            r0 = r10 & 1
            if (r0 == 0) goto L_0x002c
            r0 = r11 | 6
            goto L_0x003c
        L_0x002c:
            r0 = r11 & 14
            if (r0 != 0) goto L_0x003b
            boolean r0 = r7.changed((java.lang.Object) r14)
            if (r0 == 0) goto L_0x0038
            r0 = 4
            goto L_0x0039
        L_0x0038:
            r0 = 2
        L_0x0039:
            r0 = r0 | r11
            goto L_0x003c
        L_0x003b:
            r0 = r11
        L_0x003c:
            r3 = r10 & 2
            if (r3 == 0) goto L_0x0043
            r0 = r0 | 48
            goto L_0x0056
        L_0x0043:
            r6 = r11 & 112(0x70, float:1.57E-43)
            if (r6 != 0) goto L_0x0056
            r6 = r70
            boolean r8 = r7.changed((java.lang.Object) r6)
            if (r8 == 0) goto L_0x0052
            r8 = 32
            goto L_0x0054
        L_0x0052:
            r8 = 16
        L_0x0054:
            r0 = r0 | r8
            goto L_0x0058
        L_0x0056:
            r6 = r70
        L_0x0058:
            r8 = r11 & 896(0x380, float:1.256E-42)
            r16 = 256(0x100, float:3.59E-43)
            if (r8 != 0) goto L_0x0074
            r8 = r10 & 4
            if (r8 != 0) goto L_0x006d
            r8 = r71
            boolean r17 = r7.changed((java.lang.Object) r8)
            if (r17 == 0) goto L_0x006f
            r17 = 256(0x100, float:3.59E-43)
            goto L_0x0071
        L_0x006d:
            r8 = r71
        L_0x006f:
            r17 = 128(0x80, float:1.794E-43)
        L_0x0071:
            r0 = r0 | r17
            goto L_0x0076
        L_0x0074:
            r8 = r71
        L_0x0076:
            r17 = r10 & 8
            r18 = 2048(0x800, float:2.87E-42)
            r19 = 1024(0x400, float:1.435E-42)
            if (r17 == 0) goto L_0x0081
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0095
        L_0x0081:
            r1 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r1 != 0) goto L_0x0095
            r1 = r72
            boolean r20 = r7.changed((java.lang.Object) r1)
            if (r20 == 0) goto L_0x0090
            r20 = 2048(0x800, float:2.87E-42)
            goto L_0x0092
        L_0x0090:
            r20 = 1024(0x400, float:1.435E-42)
        L_0x0092:
            r0 = r0 | r20
            goto L_0x0097
        L_0x0095:
            r1 = r72
        L_0x0097:
            r20 = r10 & 16
            r21 = 16384(0x4000, float:2.2959E-41)
            r22 = 8192(0x2000, float:1.14794E-41)
            if (r20 == 0) goto L_0x00a4
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            r15 = r73
            goto L_0x00ba
        L_0x00a4:
            r23 = 57344(0xe000, float:8.0356E-41)
            r23 = r11 & r23
            r15 = r73
            if (r23 != 0) goto L_0x00ba
            boolean r24 = r7.changed((java.lang.Object) r15)
            if (r24 == 0) goto L_0x00b6
            r24 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00b8
        L_0x00b6:
            r24 = 8192(0x2000, float:1.14794E-41)
        L_0x00b8:
            r0 = r0 | r24
        L_0x00ba:
            r24 = r10 & 32
            r25 = 131072(0x20000, float:1.83671E-40)
            if (r24 == 0) goto L_0x00c7
            r26 = 196608(0x30000, float:2.75506E-40)
            r0 = r0 | r26
            r6 = r74
            goto L_0x00dc
        L_0x00c7:
            r26 = 458752(0x70000, float:6.42848E-40)
            r26 = r11 & r26
            r6 = r74
            if (r26 != 0) goto L_0x00dc
            boolean r26 = r7.changed((java.lang.Object) r6)
            if (r26 == 0) goto L_0x00d8
            r26 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00da
        L_0x00d8:
            r26 = 65536(0x10000, float:9.18355E-41)
        L_0x00da:
            r0 = r0 | r26
        L_0x00dc:
            r26 = r10 & 64
            r27 = 1048576(0x100000, float:1.469368E-39)
            r28 = 524288(0x80000, float:7.34684E-40)
            if (r26 == 0) goto L_0x00eb
            r29 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r29
            r6 = r75
            goto L_0x0100
        L_0x00eb:
            r29 = 3670016(0x380000, float:5.142788E-39)
            r29 = r11 & r29
            r6 = r75
            if (r29 != 0) goto L_0x0100
            boolean r29 = r7.changed((int) r6)
            if (r29 == 0) goto L_0x00fc
            r29 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00fe
        L_0x00fc:
            r29 = 524288(0x80000, float:7.34684E-40)
        L_0x00fe:
            r0 = r0 | r29
        L_0x0100:
            r6 = r10 & 128(0x80, float:1.794E-43)
            if (r6 == 0) goto L_0x0109
            r29 = 12582912(0xc00000, float:1.7632415E-38)
            r0 = r0 | r29
            goto L_0x0121
        L_0x0109:
            r29 = 29360128(0x1c00000, float:7.052966E-38)
            r29 = r11 & r29
            if (r29 != 0) goto L_0x0121
            r29 = r6
            r6 = r76
            boolean r30 = r7.changed((boolean) r6)
            if (r30 == 0) goto L_0x011c
            r30 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x011e
        L_0x011c:
            r30 = 4194304(0x400000, float:5.877472E-39)
        L_0x011e:
            r0 = r0 | r30
            goto L_0x0125
        L_0x0121:
            r29 = r6
            r6 = r76
        L_0x0125:
            r30 = 234881024(0xe000000, float:1.5777218E-30)
            r30 = r11 & r30
            if (r30 != 0) goto L_0x0141
            r2 = r10 & 256(0x100, float:3.59E-43)
            if (r2 != 0) goto L_0x013a
            r2 = r77
            boolean r31 = r7.changed((java.lang.Object) r2)
            if (r31 == 0) goto L_0x013c
            r31 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x013e
        L_0x013a:
            r2 = r77
        L_0x013c:
            r31 = 33554432(0x2000000, float:9.403955E-38)
        L_0x013e:
            r0 = r0 | r31
            goto L_0x0143
        L_0x0141:
            r2 = r77
        L_0x0143:
            r6 = r10 & 512(0x200, float:7.175E-43)
            if (r6 == 0) goto L_0x014c
            r31 = 805306368(0x30000000, float:4.656613E-10)
            r0 = r0 | r31
            goto L_0x0164
        L_0x014c:
            r31 = 1879048192(0x70000000, float:1.58456325E29)
            r31 = r11 & r31
            if (r31 != 0) goto L_0x0164
            r31 = r6
            r6 = r78
            boolean r32 = r7.changed((float) r6)
            if (r32 == 0) goto L_0x015f
            r32 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0161
        L_0x015f:
            r32 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0161:
            r0 = r0 | r32
            goto L_0x0168
        L_0x0164:
            r31 = r6
            r6 = r78
        L_0x0168:
            r32 = r12 & 14
            if (r32 != 0) goto L_0x0180
            r4 = r10 & 1024(0x400, float:1.435E-42)
            r5 = r79
            if (r4 != 0) goto L_0x017b
            boolean r33 = r7.changed((long) r5)
            if (r33 == 0) goto L_0x017b
            r33 = 4
            goto L_0x017d
        L_0x017b:
            r33 = 2
        L_0x017d:
            r33 = r12 | r33
            goto L_0x0184
        L_0x0180:
            r5 = r79
            r33 = r12
        L_0x0184:
            r34 = r12 & 112(0x70, float:1.57E-43)
            if (r34 != 0) goto L_0x019c
            r4 = r10 & 2048(0x800, float:2.87E-42)
            r5 = r81
            if (r4 != 0) goto L_0x0197
            boolean r4 = r7.changed((long) r5)
            if (r4 == 0) goto L_0x0197
            r4 = 32
            goto L_0x0199
        L_0x0197:
            r4 = 16
        L_0x0199:
            r33 = r33 | r4
            goto L_0x019e
        L_0x019c:
            r5 = r81
        L_0x019e:
            r4 = r33
            r6 = r10 & 4096(0x1000, float:5.74E-42)
            if (r6 == 0) goto L_0x01a7
            r4 = r4 | 384(0x180, float:5.38E-43)
            goto L_0x01bb
        L_0x01a7:
            r5 = r12 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x01bb
            r5 = r83
            boolean r33 = r7.changed((float) r5)
            if (r33 == 0) goto L_0x01b6
            r33 = 256(0x100, float:3.59E-43)
            goto L_0x01b8
        L_0x01b6:
            r33 = 128(0x80, float:1.794E-43)
        L_0x01b8:
            r4 = r4 | r33
            goto L_0x01bd
        L_0x01bb:
            r5 = r83
        L_0x01bd:
            r33 = r6
            r6 = r10 & 8192(0x2000, float:1.14794E-41)
            if (r6 == 0) goto L_0x01c6
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x01d8
        L_0x01c6:
            r1 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r1 != 0) goto L_0x01d8
            r1 = r84
            boolean r35 = r7.changed((java.lang.Object) r1)
            if (r35 == 0) goto L_0x01d3
            goto L_0x01d5
        L_0x01d3:
            r18 = 1024(0x400, float:1.435E-42)
        L_0x01d5:
            r4 = r4 | r18
            goto L_0x01da
        L_0x01d8:
            r1 = r84
        L_0x01da:
            r18 = r6
            r6 = r10 & 16384(0x4000, float:2.2959E-41)
            if (r6 == 0) goto L_0x01e3
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            goto L_0x01fa
        L_0x01e3:
            r19 = 57344(0xe000, float:8.0356E-41)
            r19 = r12 & r19
            if (r19 != 0) goto L_0x01fa
            r19 = r6
            r6 = r85
            boolean r35 = r7.changed((boolean) r6)
            if (r35 == 0) goto L_0x01f5
            goto L_0x01f7
        L_0x01f5:
            r21 = 8192(0x2000, float:1.14794E-41)
        L_0x01f7:
            r4 = r4 | r21
            goto L_0x01fe
        L_0x01fa:
            r19 = r6
            r6 = r85
        L_0x01fe:
            r21 = 458752(0x70000, float:6.42848E-40)
            r21 = r12 & r21
            if (r21 != 0) goto L_0x021b
            r21 = 32768(0x8000, float:4.5918E-41)
            r21 = r10 & r21
            r6 = r86
            if (r21 != 0) goto L_0x0216
            boolean r21 = r7.changed((java.lang.Object) r6)
            if (r21 == 0) goto L_0x0216
            r21 = 131072(0x20000, float:1.83671E-40)
            goto L_0x0218
        L_0x0216:
            r21 = 65536(0x10000, float:9.18355E-41)
        L_0x0218:
            r4 = r4 | r21
            goto L_0x021d
        L_0x021b:
            r6 = r86
        L_0x021d:
            r21 = 65536(0x10000, float:9.18355E-41)
            r21 = r10 & r21
            if (r21 == 0) goto L_0x022a
            r22 = 1572864(0x180000, float:2.204052E-39)
            r4 = r4 | r22
            r6 = r87
            goto L_0x023f
        L_0x022a:
            r22 = 3670016(0x380000, float:5.142788E-39)
            r22 = r12 & r22
            r6 = r87
            if (r22 != 0) goto L_0x023f
            boolean r22 = r7.changed((float) r6)
            if (r22 == 0) goto L_0x023b
            r22 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x023d
        L_0x023b:
            r22 = 524288(0x80000, float:7.34684E-40)
        L_0x023d:
            r4 = r4 | r22
        L_0x023f:
            r22 = 29360128(0x1c00000, float:7.052966E-38)
            r22 = r12 & r22
            if (r22 != 0) goto L_0x0259
            r22 = r10 & r25
            r5 = r88
            if (r22 != 0) goto L_0x0254
            boolean r22 = r7.changed((long) r5)
            if (r22 == 0) goto L_0x0254
            r22 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0256
        L_0x0254:
            r22 = 4194304(0x400000, float:5.877472E-39)
        L_0x0256:
            r4 = r4 | r22
            goto L_0x025b
        L_0x0259:
            r5 = r88
        L_0x025b:
            r22 = 234881024(0xe000000, float:1.5777218E-30)
            r22 = r12 & r22
            if (r22 != 0) goto L_0x0277
            r22 = 262144(0x40000, float:3.67342E-40)
            r22 = r10 & r22
            r5 = r90
            if (r22 != 0) goto L_0x0272
            boolean r22 = r7.changed((long) r5)
            if (r22 == 0) goto L_0x0272
            r22 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0274
        L_0x0272:
            r22 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0274:
            r4 = r4 | r22
            goto L_0x0279
        L_0x0277:
            r5 = r90
        L_0x0279:
            r22 = 1879048192(0x70000000, float:1.58456325E29)
            r22 = r12 & r22
            if (r22 != 0) goto L_0x0293
            r22 = r10 & r28
            r5 = r92
            if (r22 != 0) goto L_0x028e
            boolean r22 = r7.changed((long) r5)
            if (r22 == 0) goto L_0x028e
            r22 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0290
        L_0x028e:
            r22 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0290:
            r4 = r4 | r22
            goto L_0x0295
        L_0x0293:
            r5 = r92
        L_0x0295:
            r22 = r4
            r4 = r9 & 14
            if (r4 != 0) goto L_0x02af
            r4 = r10 & r27
            r5 = r94
            if (r4 != 0) goto L_0x02aa
            boolean r4 = r7.changed((long) r5)
            if (r4 == 0) goto L_0x02aa
            r30 = 4
            goto L_0x02ac
        L_0x02aa:
            r30 = 2
        L_0x02ac:
            r4 = r9 | r30
            goto L_0x02b2
        L_0x02af:
            r5 = r94
            r4 = r9
        L_0x02b2:
            r30 = r9 & 112(0x70, float:1.57E-43)
            if (r30 != 0) goto L_0x02cc
            r30 = 2097152(0x200000, float:2.938736E-39)
            r30 = r10 & r30
            r5 = r96
            if (r30 != 0) goto L_0x02c7
            boolean r30 = r7.changed((long) r5)
            if (r30 == 0) goto L_0x02c7
            r32 = 32
            goto L_0x02c9
        L_0x02c7:
            r32 = 16
        L_0x02c9:
            r4 = r4 | r32
            goto L_0x02ce
        L_0x02cc:
            r5 = r96
        L_0x02ce:
            r30 = 4194304(0x400000, float:5.877472E-39)
            r30 = r10 & r30
            if (r30 == 0) goto L_0x02d7
            r4 = r4 | 384(0x180, float:5.38E-43)
            goto L_0x02e6
        L_0x02d7:
            r1 = r9 & 896(0x380, float:1.256E-42)
            if (r1 != 0) goto L_0x02e6
            boolean r1 = r7.changed((java.lang.Object) r13)
            if (r1 == 0) goto L_0x02e2
            goto L_0x02e4
        L_0x02e2:
            r16 = 128(0x80, float:1.794E-43)
        L_0x02e4:
            r4 = r4 | r16
        L_0x02e6:
            r1 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r1 = r1 & r0
            r16 = 306783378(0x12492492, float:6.3469493E-28)
            r1 = r1 ^ r16
            if (r1 != 0) goto L_0x0337
            r1 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r1 = r22 & r1
            r16 = 306783378(0x12492492, float:6.3469493E-28)
            r1 = r1 ^ r16
            if (r1 != 0) goto L_0x0337
            r1 = r4 & 731(0x2db, float:1.024E-42)
            r1 = r1 ^ 146(0x92, float:2.05E-43)
            if (r1 != 0) goto L_0x0337
            boolean r1 = r7.getSkipping()
            if (r1 != 0) goto L_0x030a
            goto L_0x0337
        L_0x030a:
            r7.skipToGroupEnd()
            r4 = r72
            r10 = r78
            r11 = r79
            r13 = r81
            r16 = r84
            r17 = r85
            r18 = r86
            r19 = r87
            r20 = r88
            r22 = r90
            r24 = r92
            r26 = r94
            r9 = r2
            r28 = r5
            r0 = r7
            r3 = r8
            r5 = r15
            r2 = r70
            r6 = r74
            r7 = r75
            r8 = r76
            r15 = r83
            goto L_0x0682
        L_0x0337:
            r7.startDefaults()
            r1 = r11 & 1
            r16 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r6 = 1
            if (r1 == 0) goto L_0x03f1
            boolean r1 = r7.getDefaultsInvalid()
            if (r1 == 0) goto L_0x034a
            goto L_0x03f1
        L_0x034a:
            r7.skipToGroupEnd()
            r1 = r10 & 4
            if (r1 == 0) goto L_0x0353
            r0 = r0 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0353:
            r1 = r10 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0359
            r0 = r0 & r16
        L_0x0359:
            r1 = r10 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x035f
            r22 = r22 & -15
        L_0x035f:
            r1 = r10 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0365
            r22 = r22 & -113(0xffffffffffffff8f, float:NaN)
        L_0x0365:
            r1 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r10
            if (r1 == 0) goto L_0x0370
            r1 = -458753(0xfffffffffff8ffff, float:NaN)
            r22 = r22 & r1
        L_0x0370:
            r1 = r10 & r25
            if (r1 == 0) goto L_0x0379
            r1 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r22 = r22 & r1
        L_0x0379:
            r1 = 262144(0x40000, float:3.67342E-40)
            r1 = r1 & r10
            if (r1 == 0) goto L_0x0380
            r22 = r22 & r16
        L_0x0380:
            r1 = r10 & r28
            if (r1 == 0) goto L_0x0389
            r1 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r22 = r22 & r1
        L_0x0389:
            r1 = r10 & r27
            if (r1 == 0) goto L_0x038f
            r4 = r4 & -15
        L_0x038f:
            r1 = 2097152(0x200000, float:2.938736E-39)
            r1 = r1 & r10
            if (r1 == 0) goto L_0x03c1
            r1 = r4 & -113(0xffffffffffffff8f, float:NaN)
            r34 = r70
            r36 = r72
            r38 = r74
            r39 = r75
            r40 = r76
            r42 = r78
            r43 = r79
            r45 = r81
            r47 = r83
            r48 = r84
            r49 = r85
            r50 = r86
            r51 = r87
            r52 = r88
            r54 = r90
            r56 = r92
            r58 = r94
            r60 = r96
            r62 = r0
            r32 = r1
            r41 = r2
            goto L_0x03eb
        L_0x03c1:
            r34 = r70
            r36 = r72
            r38 = r74
            r39 = r75
            r40 = r76
            r42 = r78
            r43 = r79
            r45 = r81
            r47 = r83
            r48 = r84
            r49 = r85
            r50 = r86
            r51 = r87
            r52 = r88
            r54 = r90
            r56 = r92
            r58 = r94
            r60 = r96
            r62 = r0
            r41 = r2
            r32 = r4
        L_0x03eb:
            r35 = r8
            r37 = r15
            goto L_0x05ad
        L_0x03f1:
            if (r3 == 0) goto L_0x03fa
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r23 = r1
            goto L_0x03fc
        L_0x03fa:
            r23 = r70
        L_0x03fc:
            r1 = r10 & 4
            if (r1 == 0) goto L_0x0423
            r1 = 0
            r3 = 0
            r5 = 0
            r8 = 0
            r30 = 7
            r2 = r3
            r3 = r5
            r32 = r4
            r4 = r7
            r5 = r8
            r8 = 1
            r68 = r31
            r31 = r18
            r18 = r29
            r29 = r33
            r33 = r19
            r19 = r68
            r6 = r30
            androidx.compose.material.BottomSheetScaffoldState r1 = rememberBottomSheetScaffoldState(r1, r2, r3, r4, r5, r6)
            r0 = r0 & -897(0xfffffffffffffc7f, float:NaN)
            r6 = 1
            goto L_0x0432
        L_0x0423:
            r32 = r4
            r68 = r31
            r31 = r18
            r18 = r29
            r29 = r33
            r33 = r19
            r19 = r68
            r1 = r8
        L_0x0432:
            if (r17 == 0) goto L_0x0436
            r2 = 0
            goto L_0x0438
        L_0x0436:
            r2 = r72
        L_0x0438:
            if (r20 == 0) goto L_0x0441
            androidx.compose.material.ComposableSingletons$BottomSheetScaffoldKt r3 = androidx.compose.material.ComposableSingletons$BottomSheetScaffoldKt.INSTANCE
            kotlin.jvm.functions.Function3 r3 = r3.m939getLambda1$material_release()
            r15 = r3
        L_0x0441:
            if (r24 == 0) goto L_0x0445
            r3 = 0
            goto L_0x0447
        L_0x0445:
            r3 = r74
        L_0x0447:
            if (r26 == 0) goto L_0x0450
            androidx.compose.material.FabPosition$Companion r4 = androidx.compose.material.FabPosition.Companion
            int r4 = r4.m1004getEnd5ygKITE()
            goto L_0x0452
        L_0x0450:
            r4 = r75
        L_0x0452:
            if (r18 == 0) goto L_0x0456
            r5 = 1
            goto L_0x0458
        L_0x0456:
            r5 = r76
        L_0x0458:
            r8 = r10 & 256(0x100, float:3.59E-43)
            r6 = 6
            if (r8 == 0) goto L_0x046c
            androidx.compose.material.MaterialTheme r8 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Shapes r8 = r8.getShapes(r7, r6)
            androidx.compose.foundation.shape.CornerBasedShape r8 = r8.getLarge()
            androidx.compose.ui.graphics.Shape r8 = (androidx.compose.ui.graphics.Shape) r8
            r0 = r0 & r16
            goto L_0x046e
        L_0x046c:
            r8 = r77
        L_0x046e:
            if (r19 == 0) goto L_0x0477
            androidx.compose.material.BottomSheetScaffoldDefaults r17 = androidx.compose.material.BottomSheetScaffoldDefaults.INSTANCE
            float r17 = r17.m866getSheetElevationD9Ej5fM()
            goto L_0x0479
        L_0x0477:
            r17 = r78
        L_0x0479:
            r6 = r10 & 1024(0x400, float:1.435E-42)
            if (r6 == 0) goto L_0x0491
            androidx.compose.material.MaterialTheme r6 = androidx.compose.material.MaterialTheme.INSTANCE
            r72 = r0
            r0 = 6
            androidx.compose.material.Colors r6 = r6.getColors(r7, r0)
            long r18 = r6.m918getSurface0d7_KjU()
            r22 = r22 & -15
            r99 = r1
            r0 = r18
            goto L_0x0497
        L_0x0491:
            r72 = r0
            r99 = r1
            r0 = r79
        L_0x0497:
            r6 = r10 & 2048(0x800, float:2.87E-42)
            if (r6 == 0) goto L_0x04a4
            r6 = r22 & 14
            long r18 = androidx.compose.material.ColorsKt.m932contentColorForek8zF_U(r0, r7, r6)
            r22 = r22 & -113(0xffffffffffffff8f, float:NaN)
            goto L_0x04a6
        L_0x04a4:
            r18 = r81
        L_0x04a6:
            if (r29 == 0) goto L_0x04af
            androidx.compose.material.BottomSheetScaffoldDefaults r6 = androidx.compose.material.BottomSheetScaffoldDefaults.INSTANCE
            float r6 = r6.m867getSheetPeekHeightD9Ej5fM()
            goto L_0x04b1
        L_0x04af:
            r6 = r83
        L_0x04b1:
            if (r31 == 0) goto L_0x04b6
            r20 = 0
            goto L_0x04b8
        L_0x04b6:
            r20 = r84
        L_0x04b8:
            if (r33 == 0) goto L_0x04bd
            r24 = 1
            goto L_0x04bf
        L_0x04bd:
            r24 = r85
        L_0x04bf:
            r26 = 32768(0x8000, float:4.5918E-41)
            r26 = r10 & r26
            r29 = r0
            if (r26 == 0) goto L_0x04db
            androidx.compose.material.MaterialTheme r0 = androidx.compose.material.MaterialTheme.INSTANCE
            r1 = 6
            androidx.compose.material.Shapes r0 = r0.getShapes(r7, r1)
            androidx.compose.foundation.shape.CornerBasedShape r0 = r0.getLarge()
            androidx.compose.ui.graphics.Shape r0 = (androidx.compose.ui.graphics.Shape) r0
            r1 = -458753(0xfffffffffff8ffff, float:NaN)
            r22 = r22 & r1
            goto L_0x04dd
        L_0x04db:
            r0 = r86
        L_0x04dd:
            if (r21 == 0) goto L_0x04e6
            androidx.compose.material.DrawerDefaults r1 = androidx.compose.material.DrawerDefaults.INSTANCE
            float r1 = r1.m959getElevationD9Ej5fM()
            goto L_0x04e8
        L_0x04e6:
            r1 = r87
        L_0x04e8:
            r21 = r10 & r25
            r73 = r0
            if (r21 == 0) goto L_0x0501
            androidx.compose.material.MaterialTheme r0 = androidx.compose.material.MaterialTheme.INSTANCE
            r74 = r1
            r1 = 6
            androidx.compose.material.Colors r0 = r0.getColors(r7, r1)
            long r0 = r0.m918getSurface0d7_KjU()
            r21 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r22 = r22 & r21
            goto L_0x0505
        L_0x0501:
            r74 = r1
            r0 = r88
        L_0x0505:
            r21 = 262144(0x40000, float:3.67342E-40)
            r21 = r10 & r21
            if (r21 == 0) goto L_0x0518
            int r21 = r22 >> 21
            r25 = r2
            r2 = r21 & 14
            long r33 = androidx.compose.material.ColorsKt.m932contentColorForek8zF_U(r0, r7, r2)
            r22 = r22 & r16
            goto L_0x051c
        L_0x0518:
            r25 = r2
            r33 = r90
        L_0x051c:
            r2 = r10 & r28
            if (r2 == 0) goto L_0x052f
            androidx.compose.material.DrawerDefaults r2 = androidx.compose.material.DrawerDefaults.INSTANCE
            r75 = r0
            r0 = 6
            long r1 = r2.getScrimColor(r7, r0)
            r16 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r22 = r22 & r16
            goto L_0x0534
        L_0x052f:
            r75 = r0
            r0 = 6
            r1 = r92
        L_0x0534:
            r16 = r10 & r27
            r77 = r1
            if (r16 == 0) goto L_0x0549
            androidx.compose.material.MaterialTheme r1 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r0 = r1.getColors(r7, r0)
            long r0 = r0.m907getBackground0d7_KjU()
            r2 = r32 & -15
            r32 = r2
            goto L_0x054b
        L_0x0549:
            r0 = r94
        L_0x054b:
            r2 = 2097152(0x200000, float:2.938736E-39)
            r2 = r2 & r10
            if (r2 == 0) goto L_0x0581
            r2 = r32 & 14
            long r26 = androidx.compose.material.ColorsKt.m932contentColorForek8zF_U(r0, r7, r2)
            r2 = r32 & -113(0xffffffffffffff8f, float:NaN)
            r62 = r72
            r50 = r73
            r51 = r74
            r52 = r75
            r56 = r77
            r35 = r99
            r58 = r0
            r32 = r2
            r38 = r3
            r39 = r4
            r40 = r5
            r47 = r6
            r41 = r8
            r37 = r15
            r42 = r17
            r45 = r18
            r48 = r20
            r49 = r24
            r36 = r25
            r60 = r26
            goto L_0x05a7
        L_0x0581:
            r62 = r72
            r50 = r73
            r51 = r74
            r52 = r75
            r56 = r77
            r60 = r96
            r35 = r99
            r58 = r0
            r38 = r3
            r39 = r4
            r40 = r5
            r47 = r6
            r41 = r8
            r37 = r15
            r42 = r17
            r45 = r18
            r48 = r20
            r49 = r24
            r36 = r25
        L_0x05a7:
            r43 = r29
            r54 = r33
            r34 = r23
        L_0x05ad:
            r7.endDefaults()
            r0 = -723524056(0xffffffffd4dfe628, float:-7.6931127E12)
            r7.startReplaceableGroup(r0)
            java.lang.String r0 = "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r0)
            r0 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r7.startReplaceableGroup(r0)
            java.lang.String r0 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r0)
            java.lang.Object r0 = r7.rememberedValue()
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r0 != r1) goto L_0x05e3
            kotlin.coroutines.EmptyCoroutineContext r0 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlin.coroutines.CoroutineContext r0 = (kotlin.coroutines.CoroutineContext) r0
            kotlinx.coroutines.CoroutineScope r0 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r0, r7)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r1 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r1.<init>(r0)
            r7.updateRememberedValue(r1)
            r0 = r1
        L_0x05e3:
            r7.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r0 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r0
            kotlinx.coroutines.CoroutineScope r15 = r0.getCoroutineScope()
            r7.endReplaceableGroup()
            r63 = 0
            r64 = 0
            r8 = -819902049(0xffffffffcf21499f, float:-2.70595661E9)
            androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1 r6 = new androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$1
            r0 = r6
            r1 = r35
            r2 = r40
            r3 = r48
            r4 = r49
            r5 = r50
            r65 = r6
            r6 = r51
            r66 = r7
            r7 = r52
            r9 = r54
            r11 = r56
            r13 = r22
            r14 = r47
            r16 = r39
            r17 = r62
            r18 = r58
            r20 = r60
            r22 = r32
            r23 = r36
            r24 = r98
            r25 = r41
            r26 = r43
            r28 = r45
            r30 = r42
            r31 = r69
            r32 = r38
            r33 = r37
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r9, r11, r13, r14, r15, r16, r17, r18, r20, r22, r23, r24, r25, r26, r28, r30, r31, r32, r33)
            r2 = r65
            r0 = r66
            r1 = -819902049(0xffffffffcf21499f, float:-2.70595661E9)
            r3 = 1
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r1, r3, r2)
            kotlin.jvm.functions.Function3 r1 = (kotlin.jvm.functions.Function3) r1
            int r2 = r62 >> 3
            r2 = r2 & 14
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            r3 = 6
            r70 = r34
            r71 = r63
            r72 = r64
            r73 = r1
            r74 = r0
            r75 = r2
            r76 = r3
            androidx.compose.foundation.layout.BoxWithConstraintsKt.BoxWithConstraints(r70, r71, r72, r73, r74, r75, r76)
            r2 = r34
            r3 = r35
            r4 = r36
            r5 = r37
            r6 = r38
            r7 = r39
            r8 = r40
            r9 = r41
            r10 = r42
            r11 = r43
            r13 = r45
            r15 = r47
            r16 = r48
            r17 = r49
            r18 = r50
            r19 = r51
            r20 = r52
            r22 = r54
            r24 = r56
            r26 = r58
            r28 = r60
        L_0x0682:
            androidx.compose.runtime.ScopeUpdateScope r1 = r0.endRestartGroup()
            if (r1 != 0) goto L_0x0689
            goto L_0x06a7
        L_0x0689:
            androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$2 r35 = new androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$2
            r0 = r35
            r67 = r1
            r1 = r69
            r30 = r98
            r31 = r100
            r32 = r101
            r33 = r102
            r34 = r103
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r13, r15, r16, r17, r18, r19, r20, r22, r24, r26, r28, r30, r31, r32, r33, r34)
            r0 = r35
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r67
            r1.updateScope(r0)
        L_0x06a7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BottomSheetScaffoldKt.m868BottomSheetScaffoldbGncdBI(kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, androidx.compose.material.BottomSheetScaffoldState, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, int, boolean, androidx.compose.ui.graphics.Shape, float, long, long, float, kotlin.jvm.functions.Function3, boolean, androidx.compose.ui.graphics.Shape, float, long, long, long, long, long, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: BottomSheetScaffoldStack-SlNgfk0  reason: not valid java name */
    public static final void m869BottomSheetScaffoldStackSlNgfk0(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, State<Float> state, int i, Composer composer, int i2) {
        int i3;
        Function2<? super Composer, ? super Integer, Unit> function25 = function2;
        Function2<? super Composer, ? super Integer, Unit> function26 = function22;
        Function2<? super Composer, ? super Integer, Unit> function27 = function23;
        Function2<? super Composer, ? super Integer, Unit> function28 = function24;
        State<Float> state2 = state;
        int i4 = i;
        int i5 = i2;
        Composer startRestartGroup = composer.startRestartGroup(1491542599);
        ComposerKt.sourceInformation(startRestartGroup, "C(BottomSheetScaffoldStack)P(!2,3,5!,4:c#material.FabPosition)390@16235L1315:BottomSheetScaffold.kt#jmzs0o");
        if ((i5 & 14) == 0) {
            i3 = (startRestartGroup.changed((Object) function25) ? 4 : 2) | i5;
        } else {
            i3 = i5;
        }
        if ((i5 & 112) == 0) {
            i3 |= startRestartGroup.changed((Object) function26) ? 32 : 16;
        }
        if ((i5 & 896) == 0) {
            i3 |= startRestartGroup.changed((Object) function27) ? 256 : 128;
        }
        if ((i5 & 7168) == 0) {
            i3 |= startRestartGroup.changed((Object) function28) ? 2048 : 1024;
        }
        if ((57344 & i5) == 0) {
            i3 |= startRestartGroup.changed((Object) state2) ? 16384 : 8192;
        }
        if ((458752 & i5) == 0) {
            i3 |= startRestartGroup.changed(i4) ? 131072 : 65536;
        }
        if (((374491 & i3) ^ 74898) != 0 || !startRestartGroup.getSkipping()) {
            MeasurePolicy bottomSheetScaffoldKt$BottomSheetScaffoldStack$2 = new BottomSheetScaffoldKt$BottomSheetScaffoldStack$2(state2, i4);
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
            Composer r13 = Updater.m1234constructorimpl(startRestartGroup);
            Updater.m1241setimpl(r13, bottomSheetScaffoldKt$BottomSheetScaffoldStack$2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1241setimpl(r13, density, ComposeUiNode.Companion.getSetDensity());
            Updater.m1241setimpl(r13, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1241setimpl(r13, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m1225boximpl(SkippableUpdater.m1226constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-526644304);
            ComposerKt.sourceInformation(startRestartGroup, "C392@16275L6,393@16294L13,394@16320L22,395@16355L14:BottomSheetScaffold.kt#jmzs0o");
            function25.invoke(startRestartGroup, Integer.valueOf(i3 & 14));
            function26.invoke(startRestartGroup, Integer.valueOf((i3 >> 3) & 14));
            function27.invoke(startRestartGroup, Integer.valueOf((i3 >> 6) & 14));
            function28.invoke(startRestartGroup, Integer.valueOf((i3 >> 9) & 14));
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new BottomSheetScaffoldKt$BottomSheetScaffoldStack$3(function2, function22, function23, function24, state, i, i2));
        }
    }
}
