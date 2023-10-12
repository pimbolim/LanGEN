package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt;
import org.bouncycastle.jcajce.util.AnnotatedPrivateKey;

@Metadata(d1 = {"\u0000p\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a[\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00042\u001c\u0010\u0010\u001a\u0018\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\t0\u0011¢\u0006\u0002\b\u0013¢\u0006\u0002\b\u0014H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001a=\u0010\u0017\u001a\u00020\t2\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\t0\u0019¢\u0006\u0002\b\u00132\u0013\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0019¢\u0006\u0002\b\u00132\u0006\u0010\u001b\u001a\u00020\u0002H\u0003¢\u0006\u0002\u0010\u001c\u001aU\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020!2&\u0010\u0010\u001a\"\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\t0\u0011¢\u0006\u0002\b\u0013H\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b%\u0010&\u001a\u0001\u0010'\u001a\u00020\t*\u00020\u00122\u0006\u0010 \u001a\u00020!2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\t0\u00192\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\t0\u0019¢\u0006\u0002\b\u00132\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010)\u001a\u00020!2\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0019¢\u0006\u0002\b\u00132\b\b\u0002\u0010*\u001a\u00020!2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020\r2\b\b\u0002\u0010.\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u00100\u001a)\u00101\u001a\u000202*\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b8\u00109\u001a9\u0010:\u001a\u000202*\u0002032\u0006\u0010;\u001a\u0002052\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u0010\u001b\u001a\u00020\u0002H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b<\u0010=\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0003\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u0006\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u0007\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006>"}, d2 = {"BottomNavigationAnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "BottomNavigationHeight", "Landroidx/compose/ui/unit/Dp;", "F", "BottomNavigationItemHorizontalPadding", "CombinedItemTextBaseline", "BottomNavigation", "", "modifier", "Landroidx/compose/ui/Modifier;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "BottomNavigation-PEIptTM", "(Landroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomNavigationItemBaselineLayout", "icon", "Lkotlin/Function0;", "label", "iconPositionAnimationProgress", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;FLandroidx/compose/runtime/Composer;I)V", "BottomNavigationTransition", "activeColor", "inactiveColor", "selected", "", "Lkotlin/ParameterName;", "name", "animationProgress", "BottomNavigationTransition-Klgx-Pg", "(JJZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "BottomNavigationItem", "onClick", "enabled", "alwaysShowLabel", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "selectedContentColor", "unselectedContentColor", "BottomNavigationItem-jY6E1Zs", "(Landroidx/compose/foundation/layout/RowScope;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;JJLandroidx/compose/runtime/Composer;III)V", "placeIcon", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "iconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placeIcon-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndIcon", "labelPlaceable", "placeLabelAndIcon-DIyivk0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JF)Landroidx/compose/ui/layout/MeasureResult;", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: BottomNavigation.kt */
public final class BottomNavigationKt {
    private static final TweenSpec<Float> BottomNavigationAnimationSpec = new TweenSpec(300, 0, EasingKt.getFastOutSlowInEasing(), 2, (DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final float BottomNavigationHeight = Dp.m3859constructorimpl((float) 56);
    private static final float BottomNavigationItemHorizontalPadding;
    private static final float CombinedItemTextBaseline;

    /* JADX WARNING: Removed duplicated region for block: B:45:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:87:? A[RETURN, SYNTHETIC] */
    /* renamed from: BottomNavigation-PEIptTM  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m855BottomNavigationPEIptTM(androidx.compose.ui.Modifier r23, long r24, long r26, float r28, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, androidx.compose.runtime.Composer r30, int r31, int r32) {
        /*
            r7 = r29
            r8 = r31
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = 1878899128(0x6ffdb9b8, float:1.5704846E29)
            r1 = r30
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(BottomNavigation)P(4,0:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.unit.Dp)91@4097L6,92@4146L32,96@4289L403:BottomNavigation.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            r1 = r32 & 1
            if (r1 == 0) goto L_0x0021
            r2 = r8 | 6
            r3 = r2
            r2 = r23
            goto L_0x0035
        L_0x0021:
            r2 = r8 & 14
            if (r2 != 0) goto L_0x0032
            r2 = r23
            boolean r3 = r0.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x002f
            r3 = 4
            goto L_0x0030
        L_0x002f:
            r3 = 2
        L_0x0030:
            r3 = r3 | r8
            goto L_0x0035
        L_0x0032:
            r2 = r23
            r3 = r8
        L_0x0035:
            r4 = r8 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x004e
            r4 = r32 & 2
            if (r4 != 0) goto L_0x0048
            r4 = r24
            boolean r6 = r0.changed((long) r4)
            if (r6 == 0) goto L_0x004a
            r6 = 32
            goto L_0x004c
        L_0x0048:
            r4 = r24
        L_0x004a:
            r6 = 16
        L_0x004c:
            r3 = r3 | r6
            goto L_0x0050
        L_0x004e:
            r4 = r24
        L_0x0050:
            r6 = r8 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x0067
            r6 = r32 & 4
            r9 = r26
            if (r6 != 0) goto L_0x0063
            boolean r6 = r0.changed((long) r9)
            if (r6 == 0) goto L_0x0063
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x0065
        L_0x0063:
            r6 = 128(0x80, float:1.794E-43)
        L_0x0065:
            r3 = r3 | r6
            goto L_0x0069
        L_0x0067:
            r9 = r26
        L_0x0069:
            r6 = r32 & 8
            if (r6 == 0) goto L_0x0070
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0083
        L_0x0070:
            r11 = r8 & 7168(0x1c00, float:1.0045E-41)
            if (r11 != 0) goto L_0x0083
            r11 = r28
            boolean r12 = r0.changed((float) r11)
            if (r12 == 0) goto L_0x007f
            r12 = 2048(0x800, float:2.87E-42)
            goto L_0x0081
        L_0x007f:
            r12 = 1024(0x400, float:1.435E-42)
        L_0x0081:
            r3 = r3 | r12
            goto L_0x0085
        L_0x0083:
            r11 = r28
        L_0x0085:
            r12 = r32 & 16
            if (r12 == 0) goto L_0x008c
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009e
        L_0x008c:
            r12 = 57344(0xe000, float:8.0356E-41)
            r12 = r12 & r8
            if (r12 != 0) goto L_0x009e
            boolean r12 = r0.changed((java.lang.Object) r7)
            if (r12 == 0) goto L_0x009b
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009d
        L_0x009b:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x009d:
            r3 = r3 | r12
        L_0x009e:
            r12 = 46811(0xb6db, float:6.5596E-41)
            r12 = r12 & r3
            r12 = r12 ^ 9362(0x2492, float:1.3119E-41)
            if (r12 != 0) goto L_0x00b6
            boolean r12 = r0.getSkipping()
            if (r12 != 0) goto L_0x00ad
            goto L_0x00b6
        L_0x00ad:
            r0.skipToGroupEnd()
            r1 = r2
            r2 = r4
            r4 = r9
            r6 = r11
            goto L_0x0147
        L_0x00b6:
            r0.startDefaults()
            r12 = r8 & 1
            r13 = 6
            if (r12 == 0) goto L_0x00dc
            boolean r12 = r0.getDefaultsInvalid()
            if (r12 == 0) goto L_0x00c5
            goto L_0x00dc
        L_0x00c5:
            r0.skipToGroupEnd()
            r1 = r32 & 2
            if (r1 == 0) goto L_0x00ce
            r3 = r3 & -113(0xffffffffffffff8f, float:NaN)
        L_0x00ce:
            r1 = r32 & 4
            if (r1 == 0) goto L_0x00d4
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00d4:
            r1 = r2
        L_0x00d5:
            r6 = r11
        L_0x00d6:
            r21 = r9
            r9 = r3
            r2 = r21
            goto L_0x010d
        L_0x00dc:
            if (r1 == 0) goto L_0x00e3
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x00e4
        L_0x00e3:
            r1 = r2
        L_0x00e4:
            r2 = r32 & 2
            if (r2 == 0) goto L_0x00f4
            androidx.compose.material.MaterialTheme r2 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r2 = r2.getColors(r0, r13)
            long r4 = androidx.compose.material.ColorsKt.getPrimarySurface(r2)
            r3 = r3 & -113(0xffffffffffffff8f, float:NaN)
        L_0x00f4:
            r2 = r32 & 4
            if (r2 == 0) goto L_0x0103
            int r2 = r3 >> 3
            r2 = r2 & 14
            long r9 = androidx.compose.material.ColorsKt.m932contentColorForek8zF_U(r4, r0, r2)
            r2 = r3 & -897(0xfffffffffffffc7f, float:NaN)
            r3 = r2
        L_0x0103:
            if (r6 == 0) goto L_0x00d5
            androidx.compose.material.BottomNavigationDefaults r2 = androidx.compose.material.BottomNavigationDefaults.INSTANCE
            float r2 = r2.m854getElevationD9Ej5fM()
            r6 = r2
            goto L_0x00d6
        L_0x010d:
            r0.endDefaults()
            r10 = 0
            r15 = 0
            r11 = -819890209(0xffffffffcf2177df, float:-2.70898765E9)
            androidx.compose.material.BottomNavigationKt$BottomNavigation$1 r12 = new androidx.compose.material.BottomNavigationKt$BottomNavigation$1
            r12.<init>(r7, r9)
            r14 = 1
            androidx.compose.runtime.internal.ComposableLambda r11 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r11, r14, r12)
            r17 = r11
            kotlin.jvm.functions.Function2 r17 = (kotlin.jvm.functions.Function2) r17
            r11 = 1572864(0x180000, float:2.204052E-39)
            r12 = r9 & 14
            r11 = r11 | r12
            int r12 = r9 << 3
            r14 = r12 & 896(0x380, float:1.256E-42)
            r11 = r11 | r14
            r12 = r12 & 7168(0x1c00, float:1.0045E-41)
            r11 = r11 | r12
            r12 = 458752(0x70000, float:6.42848E-40)
            int r9 = r9 << r13
            r9 = r9 & r12
            r19 = r11 | r9
            r20 = 18
            r9 = r1
            r11 = r4
            r13 = r2
            r16 = r6
            r18 = r0
            androidx.compose.material.SurfaceKt.m1125SurfaceFjzlyU((androidx.compose.ui.Modifier) r9, (androidx.compose.ui.graphics.Shape) r10, (long) r11, (long) r13, (androidx.compose.foundation.BorderStroke) r15, (float) r16, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r17, (androidx.compose.runtime.Composer) r18, (int) r19, (int) r20)
            r21 = r2
            r2 = r4
            r4 = r21
        L_0x0147:
            androidx.compose.runtime.ScopeUpdateScope r10 = r0.endRestartGroup()
            if (r10 != 0) goto L_0x014e
            goto L_0x015f
        L_0x014e:
            androidx.compose.material.BottomNavigationKt$BottomNavigation$2 r11 = new androidx.compose.material.BottomNavigationKt$BottomNavigation$2
            r0 = r11
            r7 = r29
            r8 = r31
            r9 = r32
            r0.<init>(r1, r2, r4, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r10.updateScope(r11)
        L_0x015f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BottomNavigationKt.m855BottomNavigationPEIptTM(androidx.compose.ui.Modifier, long, long, float, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0174  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0185  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x03df  */
    /* JADX WARNING: Removed duplicated region for block: B:171:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x012a  */
    /* renamed from: BottomNavigationItem-jY6E1Zs  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m856BottomNavigationItemjY6E1Zs(androidx.compose.foundation.layout.RowScope r23, boolean r24, kotlin.jvm.functions.Function0<kotlin.Unit> r25, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r26, androidx.compose.ui.Modifier r27, boolean r28, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, boolean r30, androidx.compose.foundation.interaction.MutableInteractionSource r31, long r32, long r34, androidx.compose.runtime.Composer r36, int r37, int r38, int r39) {
        /*
            r1 = r23
            r3 = r25
            r4 = r26
            r14 = r37
            r15 = r39
            java.lang.String r0 = "$this$BottomNavigationItem"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "icon"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r0 = -1966066185(0xffffffff8ad035f7, float:-2.0049971E-32)
            r2 = r36
            androidx.compose.runtime.Composer r0 = r2.startRestartGroup(r0)
            java.lang.String r2 = "C(BottomNavigationItem)P(7,6,2,5,1,4!2,8:c#ui.graphics.Color,9:c#ui.graphics.Color)154@7016L39,155@7109L7,156@7201L6,167@7704L61,169@7771L804:BottomNavigation.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r2)
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r15
            if (r2 == 0) goto L_0x002f
            r2 = r14 | 6
            goto L_0x003f
        L_0x002f:
            r2 = r14 & 14
            if (r2 != 0) goto L_0x003e
            boolean r2 = r0.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x003b
            r2 = 4
            goto L_0x003c
        L_0x003b:
            r2 = 2
        L_0x003c:
            r2 = r2 | r14
            goto L_0x003f
        L_0x003e:
            r2 = r14
        L_0x003f:
            r7 = r15 & 1
            if (r7 == 0) goto L_0x0046
            r2 = r2 | 48
            goto L_0x0059
        L_0x0046:
            r7 = r14 & 112(0x70, float:1.57E-43)
            if (r7 != 0) goto L_0x0059
            r7 = r24
            boolean r8 = r0.changed((boolean) r7)
            if (r8 == 0) goto L_0x0055
            r8 = 32
            goto L_0x0057
        L_0x0055:
            r8 = 16
        L_0x0057:
            r2 = r2 | r8
            goto L_0x005b
        L_0x0059:
            r7 = r24
        L_0x005b:
            r8 = r15 & 2
            if (r8 == 0) goto L_0x0062
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0072
        L_0x0062:
            r8 = r14 & 896(0x380, float:1.256E-42)
            if (r8 != 0) goto L_0x0072
            boolean r8 = r0.changed((java.lang.Object) r3)
            if (r8 == 0) goto L_0x006f
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x0071
        L_0x006f:
            r8 = 128(0x80, float:1.794E-43)
        L_0x0071:
            r2 = r2 | r8
        L_0x0072:
            r8 = r15 & 4
            if (r8 == 0) goto L_0x0079
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x0089
        L_0x0079:
            r8 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x0089
            boolean r8 = r0.changed((java.lang.Object) r4)
            if (r8 == 0) goto L_0x0086
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x0088
        L_0x0086:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x0088:
            r2 = r2 | r8
        L_0x0089:
            r8 = r15 & 8
            if (r8 == 0) goto L_0x0090
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a5
        L_0x0090:
            r9 = 57344(0xe000, float:8.0356E-41)
            r9 = r9 & r14
            if (r9 != 0) goto L_0x00a5
            r9 = r27
            boolean r10 = r0.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x00a1
            r10 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a3
        L_0x00a1:
            r10 = 8192(0x2000, float:1.14794E-41)
        L_0x00a3:
            r2 = r2 | r10
            goto L_0x00a7
        L_0x00a5:
            r9 = r27
        L_0x00a7:
            r10 = r15 & 16
            if (r10 == 0) goto L_0x00af
            r11 = 196608(0x30000, float:2.75506E-40)
            r2 = r2 | r11
            goto L_0x00c3
        L_0x00af:
            r11 = 458752(0x70000, float:6.42848E-40)
            r11 = r11 & r14
            if (r11 != 0) goto L_0x00c3
            r11 = r28
            boolean r12 = r0.changed((boolean) r11)
            if (r12 == 0) goto L_0x00bf
            r12 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c1
        L_0x00bf:
            r12 = 65536(0x10000, float:9.18355E-41)
        L_0x00c1:
            r2 = r2 | r12
            goto L_0x00c5
        L_0x00c3:
            r11 = r28
        L_0x00c5:
            r12 = r15 & 32
            if (r12 == 0) goto L_0x00cd
            r13 = 1572864(0x180000, float:2.204052E-39)
            r2 = r2 | r13
            goto L_0x00e2
        L_0x00cd:
            r13 = 3670016(0x380000, float:5.142788E-39)
            r13 = r13 & r14
            if (r13 != 0) goto L_0x00e2
            r13 = r29
            boolean r16 = r0.changed((java.lang.Object) r13)
            if (r16 == 0) goto L_0x00dd
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00df
        L_0x00dd:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00df:
            r2 = r2 | r16
            goto L_0x00e4
        L_0x00e2:
            r13 = r29
        L_0x00e4:
            r16 = r15 & 64
            if (r16 == 0) goto L_0x00ef
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            r2 = r2 | r17
            r5 = r30
            goto L_0x0104
        L_0x00ef:
            r17 = 29360128(0x1c00000, float:7.052966E-38)
            r17 = r14 & r17
            r5 = r30
            if (r17 != 0) goto L_0x0104
            boolean r17 = r0.changed((boolean) r5)
            if (r17 == 0) goto L_0x0100
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0102
        L_0x0100:
            r17 = 4194304(0x400000, float:5.877472E-39)
        L_0x0102:
            r2 = r2 | r17
        L_0x0104:
            r6 = r15 & 128(0x80, float:1.794E-43)
            if (r6 == 0) goto L_0x010f
            r18 = 100663296(0x6000000, float:2.4074124E-35)
            r2 = r2 | r18
            r1 = r31
            goto L_0x0124
        L_0x010f:
            r18 = 234881024(0xe000000, float:1.5777218E-30)
            r18 = r14 & r18
            r1 = r31
            if (r18 != 0) goto L_0x0124
            boolean r18 = r0.changed((java.lang.Object) r1)
            if (r18 == 0) goto L_0x0120
            r18 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0122
        L_0x0120:
            r18 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0122:
            r2 = r2 | r18
        L_0x0124:
            r18 = 1879048192(0x70000000, float:1.58456325E29)
            r18 = r14 & r18
            if (r18 != 0) goto L_0x013d
            r1 = r15 & 512(0x200, float:7.175E-43)
            r3 = r32
            if (r1 != 0) goto L_0x0139
            boolean r1 = r0.changed((long) r3)
            if (r1 == 0) goto L_0x0139
            r1 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x013b
        L_0x0139:
            r1 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x013b:
            r2 = r2 | r1
            goto L_0x013f
        L_0x013d:
            r3 = r32
        L_0x013f:
            r1 = r38 & 14
            if (r1 != 0) goto L_0x0155
            r1 = r15 & 1024(0x400, float:1.435E-42)
            r3 = r34
            if (r1 != 0) goto L_0x0151
            boolean r1 = r0.changed((long) r3)
            if (r1 == 0) goto L_0x0151
            r1 = 4
            goto L_0x0152
        L_0x0151:
            r1 = 2
        L_0x0152:
            r1 = r38 | r1
            goto L_0x0159
        L_0x0155:
            r3 = r34
            r1 = r38
        L_0x0159:
            r18 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r18 = r2 & r18
            r19 = 306783378(0x12492492, float:6.3469493E-28)
            r18 = r18 ^ r19
            if (r18 != 0) goto L_0x0185
            r18 = r1 & 11
            r17 = 2
            r17 = r18 ^ 2
            if (r17 != 0) goto L_0x0185
            boolean r17 = r0.getSkipping()
            if (r17 != 0) goto L_0x0174
            goto L_0x0185
        L_0x0174:
            r0.skipToGroupEnd()
            r7 = r26
            r8 = r5
            r5 = r9
            r6 = r11
            r19 = r13
            r9 = r31
            r10 = r32
            r12 = r3
            goto L_0x03d8
        L_0x0185:
            r0.startDefaults()
            r17 = r14 & 1
            r18 = 0
            r19 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            java.lang.String r3 = "C:CompositionLocal.kt#9igjgp"
            if (r17 == 0) goto L_0x01b2
            boolean r17 = r0.getDefaultsInvalid()
            if (r17 == 0) goto L_0x019a
            goto L_0x01b2
        L_0x019a:
            r0.skipToGroupEnd()
            r6 = r15 & 256(0x100, float:3.59E-43)
            if (r6 == 0) goto L_0x01a3
            r2 = r2 & r19
        L_0x01a3:
            r6 = r15 & 512(0x200, float:7.175E-43)
            if (r6 == 0) goto L_0x01a9
            r1 = r1 & -15
        L_0x01a9:
            r6 = r31
            r20 = r34
            r8 = r9
            r9 = r32
            goto L_0x0239
        L_0x01b2:
            if (r8 == 0) goto L_0x01b9
            androidx.compose.ui.Modifier$Companion r8 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r8 = (androidx.compose.ui.Modifier) r8
            goto L_0x01ba
        L_0x01b9:
            r8 = r9
        L_0x01ba:
            if (r10 == 0) goto L_0x01bd
            r11 = 1
        L_0x01bd:
            if (r12 == 0) goto L_0x01c1
            r13 = r18
        L_0x01c1:
            if (r16 == 0) goto L_0x01c4
            r5 = 1
        L_0x01c4:
            if (r6 == 0) goto L_0x01ea
            r6 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r0.startReplaceableGroup(r6)
            java.lang.String r6 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r6)
            java.lang.Object r6 = r0.rememberedValue()
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r6 != r9) goto L_0x01e4
            androidx.compose.foundation.interaction.MutableInteractionSource r6 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r0.updateRememberedValue(r6)
        L_0x01e4:
            r0.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r6 = (androidx.compose.foundation.interaction.MutableInteractionSource) r6
            goto L_0x01ec
        L_0x01ea:
            r6 = r31
        L_0x01ec:
            r9 = r15 & 256(0x100, float:3.59E-43)
            if (r9 == 0) goto L_0x020c
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.material.ContentColorKt.getLocalContentColor()
            androidx.compose.runtime.CompositionLocal r9 = (androidx.compose.runtime.CompositionLocal) r9
            r10 = 103361330(0x6292b32, float:3.1817102E-35)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r10, r3)
            java.lang.Object r9 = r0.consume(r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.graphics.Color r9 = (androidx.compose.ui.graphics.Color) r9
            long r9 = r9.m1606unboximpl()
            r2 = r2 & r19
            goto L_0x020e
        L_0x020c:
            r9 = r32
        L_0x020e:
            r12 = r15 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0237
            androidx.compose.material.ContentAlpha r12 = androidx.compose.material.ContentAlpha.INSTANCE
            r4 = 6
            float r12 = r12.getMedium(r0, r4)
            r4 = 0
            r17 = 0
            r19 = 0
            r20 = 14
            r21 = 0
            r27 = r9
            r29 = r12
            r30 = r4
            r31 = r17
            r32 = r19
            r33 = r20
            r34 = r21
            long r20 = androidx.compose.ui.graphics.Color.m1595copywmQWz5c$default(r27, r29, r30, r31, r32, r33, r34)
            r1 = r1 & -15
            goto L_0x0239
        L_0x0237:
            r20 = r34
        L_0x0239:
            r0.endDefaults()
            if (r13 != 0) goto L_0x023f
            goto L_0x0250
        L_0x023f:
            r4 = -985535172(0xffffffffc541ed3c, float:-3102.8271)
            androidx.compose.material.BottomNavigationKt$BottomNavigationItem$styledLabel$1$1 r12 = new androidx.compose.material.BottomNavigationKt$BottomNavigationItem$styledLabel$1$1
            r12.<init>(r13, r2)
            r7 = 1
            androidx.compose.runtime.internal.ComposableLambda r4 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambdaInstance(r4, r7, r12)
            r18 = r4
            kotlin.jvm.functions.Function2 r18 = (kotlin.jvm.functions.Function2) r18
        L_0x0250:
            r4 = r18
            r7 = 0
            int r12 = r2 >> 21
            r12 = r12 & 896(0x380, float:1.256E-42)
            r17 = 6
            r12 = r12 | 6
            r17 = 2
            r27 = r7
            r7 = 0
            r28 = r7
            r29 = r9
            r31 = r0
            r32 = r12
            r33 = r17
            androidx.compose.foundation.Indication r7 = androidx.compose.material.ripple.RippleKt.m1214rememberRipple9IZ8Weo(r27, r28, r29, r31, r32, r33)
            androidx.compose.ui.semantics.Role$Companion r12 = androidx.compose.ui.semantics.Role.Companion
            int r12 = r12.m3482getTabo7Vup1c()
            androidx.compose.ui.semantics.Role r12 = androidx.compose.ui.semantics.Role.m3470boximpl(r12)
            r27 = r8
            r28 = r24
            r29 = r6
            r30 = r7
            r31 = r11
            r32 = r12
            r33 = r25
            androidx.compose.ui.Modifier r7 = androidx.compose.foundation.selection.SelectableKt.m576selectableO2vRcR0(r27, r28, r29, r30, r31, r32, r33)
            r12 = 1065353216(0x3f800000, float:1.0)
            r17 = 0
            r18 = 2
            r19 = 0
            r27 = r23
            r28 = r7
            r29 = r12
            r30 = r17
            r31 = r18
            r32 = r19
            androidx.compose.ui.Modifier r7 = androidx.compose.foundation.layout.RowScope.DefaultImpls.weight$default(r27, r28, r29, r30, r31, r32)
            androidx.compose.ui.Alignment$Companion r12 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r12 = r12.getCenter()
            r35 = r6
            r6 = -1990474327(0xffffffff895bc5a9, float:-2.6454105E-33)
            r0.startReplaceableGroup(r6)
            java.lang.String r6 = "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r6)
            r6 = 0
            r17 = r8
            r8 = 6
            androidx.compose.ui.layout.MeasurePolicy r8 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r12, r6, r0, r8)
            r12 = 1376089394(0x52057532, float:1.43299215E11)
            r0.startReplaceableGroup(r12)
            java.lang.String r12 = "C(Layout)P(!1,2)72@2847L7,73@2902L7,74@2961L7,75@2973L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r12)
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r12 = (androidx.compose.runtime.CompositionLocal) r12
            r6 = 103361330(0x6292b32, float:3.1817102E-35)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r6, r3)
            java.lang.Object r12 = r0.consume(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.Density r12 = (androidx.compose.ui.unit.Density) r12
            androidx.compose.runtime.ProvidableCompositionLocal r18 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            r36 = r11
            r11 = r18
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r6, r3)
            java.lang.Object r11 = r0.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.LayoutDirection r11 = (androidx.compose.ui.unit.LayoutDirection) r11
            androidx.compose.runtime.ProvidableCompositionLocal r18 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            r19 = r13
            r13 = r18
            androidx.compose.runtime.CompositionLocal r13 = (androidx.compose.runtime.CompositionLocal) r13
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r6, r3)
            java.lang.Object r3 = r0.consume(r13)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.platform.ViewConfiguration r3 = (androidx.compose.ui.platform.ViewConfiguration) r3
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r6 = r6.getConstructor()
            kotlin.jvm.functions.Function3 r7 = androidx.compose.ui.layout.LayoutKt.materializerOf(r7)
            androidx.compose.runtime.Applier r13 = r0.getApplier()
            boolean r13 = r13 instanceof androidx.compose.runtime.Applier
            if (r13 != 0) goto L_0x031e
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x031e:
            r0.startReusableNode()
            boolean r13 = r0.getInserting()
            if (r13 == 0) goto L_0x032b
            r0.createNode(r6)
            goto L_0x032e
        L_0x032b:
            r0.useNode()
        L_0x032e:
            r0.disableReusing()
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.Updater.m1234constructorimpl(r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r13 = r13.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r6, r8, r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetDensity()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r6, r12, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r6, r11, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r6, r3, r8)
            r0.enableReusing()
            androidx.compose.runtime.Composer r3 = androidx.compose.runtime.SkippableUpdater.m1226constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r3 = androidx.compose.runtime.SkippableUpdater.m1225boximpl(r3)
            r6 = 0
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r7.invoke(r3, r0, r6)
            r3 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r3)
            r3 = -1253629305(0xffffffffb5472287, float:-7.418352E-7)
            r0.startReplaceableGroup(r3)
            java.lang.String r3 = "C72@3384L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r3)
            androidx.compose.foundation.layout.BoxScopeInstance r3 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r3 = (androidx.compose.foundation.layout.BoxScope) r3
            r3 = -1277963843(0xffffffffb3d3d1bd, float:-9.863604E-8)
            r0.startReplaceableGroup(r3)
            java.lang.String r3 = "C182@8148L421:BottomNavigation.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r3)
            r3 = -819902757(0xffffffffcf2146db, float:-2.70577536E9)
            androidx.compose.material.BottomNavigationKt$BottomNavigationItem$2$1 r6 = new androidx.compose.material.BottomNavigationKt$BottomNavigationItem$2$1
            r7 = r26
            r6.<init>(r5, r7, r4, r2)
            r4 = 1
            androidx.compose.runtime.internal.ComposableLambda r3 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r3, r4, r6)
            kotlin.jvm.functions.Function3 r3 = (kotlin.jvm.functions.Function3) r3
            int r4 = r2 >> 27
            r4 = r4 & 14
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            int r1 = r1 << 3
            r1 = r1 & 112(0x70, float:1.57E-43)
            r1 = r1 | r4
            int r2 = r2 << 3
            r2 = r2 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            r27 = r9
            r29 = r20
            r31 = r24
            r32 = r3
            r33 = r0
            r34 = r1
            m857BottomNavigationTransitionKlgxPg(r27, r29, r31, r32, r33, r34)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r6 = r36
            r8 = r5
            r10 = r9
            r5 = r17
            r12 = r20
            r9 = r35
        L_0x03d8:
            androidx.compose.runtime.ScopeUpdateScope r4 = r0.endRestartGroup()
            if (r4 != 0) goto L_0x03df
            goto L_0x0401
        L_0x03df:
            androidx.compose.material.BottomNavigationKt$BottomNavigationItem$3 r17 = new androidx.compose.material.BottomNavigationKt$BottomNavigationItem$3
            r0 = r17
            r1 = r23
            r2 = r24
            r3 = r25
            r22 = r4
            r4 = r26
            r7 = r19
            r14 = r37
            r15 = r38
            r16 = r39
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r14, r15, r16)
            r0 = r17
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r22
            r1.updateScope(r0)
        L_0x0401:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BottomNavigationKt.m856BottomNavigationItemjY6E1Zs(androidx.compose.foundation.layout.RowScope, boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, long, long, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: BottomNavigationTransition-Klgx-Pg  reason: not valid java name */
    public static final void m857BottomNavigationTransitionKlgxPg(long j, long j2, boolean z, Function3<? super Float, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i) {
        int i2;
        long j3 = j;
        long j4 = j2;
        boolean z2 = z;
        Function3<? super Float, ? super Composer, ? super Integer, Unit> function32 = function3;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(-601092451);
        ComposerKt.sourceInformation(startRestartGroup, "C(BottomNavigationTransition)P(0:c#ui.graphics.Color,2:c#ui.graphics.Color,3)227@9693L128,234@9896L181:BottomNavigation.kt#jmzs0o");
        if ((i3 & 14) == 0) {
            i2 = (startRestartGroup.changed(j3) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i3 & 112) == 0) {
            i2 |= startRestartGroup.changed(j4) ? 32 : 16;
        }
        if ((i3 & 896) == 0) {
            i2 |= startRestartGroup.changed(z2) ? 256 : 128;
        }
        if ((i3 & 7168) == 0) {
            i2 |= startRestartGroup.changed((Object) function32) ? 2048 : 1024;
        }
        int i4 = i2;
        if (((i4 & 5851) ^ 1170) != 0 || !startRestartGroup.getSkipping()) {
            State<Float> animateFloatAsState = AnimateAsStateKt.animateFloatAsState(z2 ? 1.0f : 0.0f, BottomNavigationAnimationSpec, 0.0f, (Function1<? super Float, Unit>) null, startRestartGroup, 48, 12);
            long r9 = ColorKt.m1648lerpjxsXWHM(j4, j3, m858BottomNavigationTransition_Klgx_Pg$lambda3(animateFloatAsState));
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m1586boximpl(Color.m1595copywmQWz5c$default(r9, 1.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null))), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1598getAlphaimpl(r9)))}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(startRestartGroup, -819904067, true, new BottomNavigationKt$BottomNavigationTransition$1(function32, i4, animateFloatAsState)), startRestartGroup, 56);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new BottomNavigationKt$BottomNavigationTransition$2(j, j2, z, function3, i));
        }
    }

    /* access modifiers changed from: private */
    public static final void BottomNavigationItemBaselineLayout(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, float f, Composer composer, int i) {
        int i2;
        Function2<? super Composer, ? super Integer, Unit> function23 = function2;
        Function2<? super Composer, ? super Integer, Unit> function24 = function22;
        float f2 = f;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(-1198312724);
        ComposerKt.sourceInformation(startRestartGroup, "C(BottomNavigationItemBaselineLayout)P(!1,2)259@10750L1203:BottomNavigation.kt#jmzs0o");
        if ((i3 & 14) == 0) {
            i2 = (startRestartGroup.changed((Object) function23) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i3 & 112) == 0) {
            i2 |= startRestartGroup.changed((Object) function24) ? 32 : 16;
        }
        if ((i3 & 896) == 0) {
            i2 |= startRestartGroup.changed(f2) ? 256 : 128;
        }
        if (((i2 & 731) ^ 146) != 0 || !startRestartGroup.getSkipping()) {
            MeasurePolicy bottomNavigationKt$BottomNavigationItemBaselineLayout$2 = new BottomNavigationKt$BottomNavigationItemBaselineLayout$2(function24, f2);
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
            Composer r6 = Updater.m1234constructorimpl(startRestartGroup);
            Updater.m1241setimpl(r6, bottomNavigationKt$BottomNavigationItemBaselineLayout$2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1241setimpl(r6, density, ComposeUiNode.Companion.getSetDensity());
            Updater.m1241setimpl(r6, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1241setimpl(r6, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m1225boximpl(SkippableUpdater.m1226constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(619997302);
            ComposerKt.sourceInformation(startRestartGroup, "C261@10780L41,263@10871L253:BottomNavigation.kt#jmzs0o");
            Modifier layoutId = LayoutIdKt.layoutId(Modifier.Companion, "icon");
            startRestartGroup.startReplaceableGroup(-1990474327);
            ComposerKt.sourceInformation(startRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(1376089394);
            ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)72@2847L7,73@2902L7,74@2961L7,75@2973L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume4 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Density density2 = (Density) consume4;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume5 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection2 = (LayoutDirection) consume5;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume6 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) consume6;
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(layoutId);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer r7 = Updater.m1234constructorimpl(startRestartGroup);
            Updater.m1241setimpl(r7, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1241setimpl(r7, density2, ComposeUiNode.Companion.getSetDensity());
            Updater.m1241setimpl(r7, layoutDirection2, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1241setimpl(r7, viewConfiguration2, ComposeUiNode.Companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf2.invoke(SkippableUpdater.m1225boximpl(SkippableUpdater.m1226constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-1253629305);
            ComposerKt.sourceInformation(startRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            startRestartGroup.startReplaceableGroup(-1517374536);
            ComposerKt.sourceInformation(startRestartGroup, "C261@10813L6:BottomNavigation.kt#jmzs0o");
            function23.invoke(startRestartGroup, Integer.valueOf(i2 & 14));
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            if (function24 != null) {
                Modifier r8 = PaddingKt.m433paddingVpY3zN4$default(AlphaKt.alpha(LayoutIdKt.layoutId(Modifier.Companion, AnnotatedPrivateKey.LABEL), f2), BottomNavigationItemHorizontalPadding, 0.0f, 2, (Object) null);
                startRestartGroup.startReplaceableGroup(-1990474327);
                ComposerKt.sourceInformation(startRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(1376089394);
                ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)72@2847L7,73@2902L7,74@2961L7,75@2973L460:Layout.kt#80mrfh");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
                Object consume7 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Density density3 = (Density) consume7;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
                Object consume8 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                LayoutDirection layoutDirection3 = (LayoutDirection) consume8;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
                Object consume9 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ViewConfiguration viewConfiguration3 = (ViewConfiguration) consume9;
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf3 = LayoutKt.materializerOf(r8);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor3);
                } else {
                    startRestartGroup.useNode();
                }
                startRestartGroup.disableReusing();
                Composer r13 = Updater.m1234constructorimpl(startRestartGroup);
                Updater.m1241setimpl(r13, rememberBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m1241setimpl(r13, density3, ComposeUiNode.Companion.getSetDensity());
                Updater.m1241setimpl(r13, layoutDirection3, ComposeUiNode.Companion.getSetLayoutDirection());
                Updater.m1241setimpl(r13, viewConfiguration3, ComposeUiNode.Companion.getSetViewConfiguration());
                startRestartGroup.enableReusing();
                materializerOf3.invoke(SkippableUpdater.m1225boximpl(SkippableUpdater.m1226constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                startRestartGroup.startReplaceableGroup(-1253629305);
                ComposerKt.sourceInformation(startRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
                BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                startRestartGroup.startReplaceableGroup(-1517374234);
                ComposerKt.sourceInformation(startRestartGroup, "C268@11115L7:BottomNavigation.kt#jmzs0o");
                function24.invoke(startRestartGroup, Integer.valueOf((i2 >> 3) & 14));
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            }
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new BottomNavigationKt$BottomNavigationItemBaselineLayout$3(function23, function24, f2, i3));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: placeIcon-3p2s80s  reason: not valid java name */
    public static final MeasureResult m863placeIcon3p2s80s(MeasureScope measureScope, Placeable placeable, long j) {
        int r2 = Constraints.m3802getMaxHeightimpl(j);
        return MeasureScope.DefaultImpls.layout$default(measureScope, placeable.getWidth(), r2, (Map) null, new BottomNavigationKt$placeIcon$1(placeable, (r2 - placeable.getHeight()) / 2), 4, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: placeLabelAndIcon-DIyivk0  reason: not valid java name */
    public static final MeasureResult m864placeLabelAndIconDIyivk0(MeasureScope measureScope, Placeable placeable, Placeable placeable2, long j, float f) {
        int r2 = Constraints.m3802getMaxHeightimpl(j);
        Placeable placeable3 = placeable;
        int i = placeable.get(AlignmentLineKt.getLastBaseline());
        MeasureScope measureScope2 = measureScope;
        int r3 = measureScope.m3822roundToPx0680j_4(CombinedItemTextBaseline);
        int i2 = (r2 - i) - r3;
        int height = (r2 - (r3 * 2)) - placeable2.getHeight();
        int max = Math.max(placeable.getWidth(), placeable2.getWidth());
        return MeasureScope.DefaultImpls.layout$default(measureScope, max, r2, (Map) null, new BottomNavigationKt$placeLabelAndIcon$1(f, placeable, (max - placeable.getWidth()) / 2, i2, MathKt.roundToInt(((float) (((r2 - placeable2.getHeight()) / 2) - height)) * (((float) 1) - f)), placeable2, (max - placeable2.getWidth()) / 2, height), 4, (Object) null);
    }

    static {
        float f = (float) 12;
        BottomNavigationItemHorizontalPadding = Dp.m3859constructorimpl(f);
        CombinedItemTextBaseline = Dp.m3859constructorimpl(f);
    }

    /* access modifiers changed from: private */
    /* renamed from: BottomNavigationTransition_Klgx_Pg$lambda-3  reason: not valid java name */
    public static final float m858BottomNavigationTransition_Klgx_Pg$lambda3(State<Float> state) {
        return state.getValue().floatValue();
    }
}
