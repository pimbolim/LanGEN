package androidx.compose.ui.window;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.LayoutDirection;
import com.nimbusds.jose.HeaderParameterNames;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001aX\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00060\f¢\u0006\u0002\b\u0010H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012\u001aD\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00060\f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0015\u001a(\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00022\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00060\f¢\u0006\u0002\b\u0010H\u0001¢\u0006\u0002\u0010\u0018\u001a+\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001b2\u0013\b\b\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00060\f¢\u0006\u0002\b\u0010H\b¢\u0006\u0002\u0010\u001c\u001a\u001a\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0002\u001a\f\u0010\"\u001a\u00020\u001e*\u00020 H\u0000\u001a\f\u0010#\u001a\u00020$*\u00020%H\u0002\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006&"}, d2 = {"LocalPopupTestTag", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "", "getLocalPopupTestTag", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "Popup", "", "alignment", "Landroidx/compose/ui/Alignment;", "offset", "Landroidx/compose/ui/unit/IntOffset;", "onDismissRequest", "Lkotlin/Function0;", "properties", "Landroidx/compose/ui/window/PopupProperties;", "content", "Landroidx/compose/runtime/Composable;", "Popup-K5zGePQ", "(Landroidx/compose/ui/Alignment;JLkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "popupPositionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "PopupTestTag", "tag", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SimpleStack", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "isPopupLayout", "", "view", "Landroid/view/View;", "testTag", "isFlagSecureEnabled", "toIntBounds", "Landroidx/compose/ui/unit/IntRect;", "Landroid/graphics/Rect;", "ui_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: AndroidPopup.android.kt */
public final class AndroidPopup_androidKt {
    private static final ProvidableCompositionLocal<String> LocalPopupTestTag = CompositionLocalKt.compositionLocalOf$default((SnapshotMutationPolicy) null, AndroidPopup_androidKt$LocalPopupTestTag$1.INSTANCE, 1, (Object) null);

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0167  */
    /* JADX WARNING: Removed duplicated region for block: B:89:? A[RETURN, SYNTHETIC] */
    /* renamed from: Popup-K5zGePQ  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m4105PopupK5zGePQ(androidx.compose.ui.Alignment r23, long r24, kotlin.jvm.functions.Function0<kotlin.Unit> r26, androidx.compose.ui.window.PopupProperties r27, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, androidx.compose.runtime.Composer r29, int r30, int r31) {
        /*
            r7 = r28
            r8 = r30
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = 1064153512(0x3f6db1a8, float:0.92849207)
            r1 = r29
            androidx.compose.runtime.Composer r9 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(Popup)P(!1,2:c#ui.unit.IntOffset,3,4)189@8341L128,196@8475L165:AndroidPopup.android.kt#2oxthz"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r0)
            r0 = r31 & 1
            if (r0 == 0) goto L_0x0021
            r1 = r8 | 6
            r2 = r1
            r1 = r23
            goto L_0x0035
        L_0x0021:
            r1 = r8 & 14
            if (r1 != 0) goto L_0x0032
            r1 = r23
            boolean r2 = r9.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x002f
            r2 = 4
            goto L_0x0030
        L_0x002f:
            r2 = 2
        L_0x0030:
            r2 = r2 | r8
            goto L_0x0035
        L_0x0032:
            r1 = r23
            r2 = r8
        L_0x0035:
            r3 = r31 & 2
            if (r3 == 0) goto L_0x003c
            r2 = r2 | 48
            goto L_0x004f
        L_0x003c:
            r4 = r8 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x004f
            r4 = r24
            boolean r6 = r9.changed((long) r4)
            if (r6 == 0) goto L_0x004b
            r6 = 32
            goto L_0x004d
        L_0x004b:
            r6 = 16
        L_0x004d:
            r2 = r2 | r6
            goto L_0x0051
        L_0x004f:
            r4 = r24
        L_0x0051:
            r6 = r31 & 4
            if (r6 == 0) goto L_0x0058
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x006b
        L_0x0058:
            r10 = r8 & 896(0x380, float:1.256E-42)
            if (r10 != 0) goto L_0x006b
            r10 = r26
            boolean r11 = r9.changed((java.lang.Object) r10)
            if (r11 == 0) goto L_0x0067
            r11 = 256(0x100, float:3.59E-43)
            goto L_0x0069
        L_0x0067:
            r11 = 128(0x80, float:1.794E-43)
        L_0x0069:
            r2 = r2 | r11
            goto L_0x006d
        L_0x006b:
            r10 = r26
        L_0x006d:
            r11 = r8 & 7168(0x1c00, float:1.0045E-41)
            if (r11 != 0) goto L_0x0086
            r11 = r31 & 8
            if (r11 != 0) goto L_0x0080
            r11 = r27
            boolean r12 = r9.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x0082
            r12 = 2048(0x800, float:2.87E-42)
            goto L_0x0084
        L_0x0080:
            r11 = r27
        L_0x0082:
            r12 = 1024(0x400, float:1.435E-42)
        L_0x0084:
            r2 = r2 | r12
            goto L_0x0088
        L_0x0086:
            r11 = r27
        L_0x0088:
            r12 = r31 & 16
            if (r12 == 0) goto L_0x008f
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a1
        L_0x008f:
            r12 = 57344(0xe000, float:8.0356E-41)
            r12 = r12 & r8
            if (r12 != 0) goto L_0x00a1
            boolean r12 = r9.changed((java.lang.Object) r7)
            if (r12 == 0) goto L_0x009e
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a0
        L_0x009e:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x00a0:
            r2 = r2 | r12
        L_0x00a1:
            r12 = 46811(0xb6db, float:6.5596E-41)
            r12 = r12 & r2
            r12 = r12 ^ 9362(0x2492, float:1.3119E-41)
            if (r12 != 0) goto L_0x00b8
            boolean r12 = r9.getSkipping()
            if (r12 != 0) goto L_0x00b0
            goto L_0x00b8
        L_0x00b0:
            r9.skipToGroupEnd()
            r2 = r4
            r4 = r10
            r5 = r11
            goto L_0x0160
        L_0x00b8:
            r9.startDefaults()
            r12 = r8 & 1
            r13 = 0
            if (r12 == 0) goto L_0x00d5
            boolean r12 = r9.getDefaultsInvalid()
            if (r12 == 0) goto L_0x00c7
            goto L_0x00d5
        L_0x00c7:
            r9.skipToGroupEnd()
            r0 = r31 & 8
            if (r0 == 0) goto L_0x00d0
            r2 = r2 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x00d0:
            r14 = r10
            r15 = r11
            r10 = r1
            r11 = r4
            goto L_0x010f
        L_0x00d5:
            if (r0 == 0) goto L_0x00de
            androidx.compose.ui.Alignment$Companion r0 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r0 = r0.getTopStart()
            goto L_0x00df
        L_0x00de:
            r0 = r1
        L_0x00df:
            if (r3 == 0) goto L_0x00e7
            r1 = 0
            long r3 = androidx.compose.ui.unit.IntOffsetKt.IntOffset(r1, r1)
            goto L_0x00e8
        L_0x00e7:
            r3 = r4
        L_0x00e8:
            if (r6 == 0) goto L_0x00eb
            r10 = r13
        L_0x00eb:
            r1 = r31 & 8
            if (r1 == 0) goto L_0x010b
            androidx.compose.ui.window.PopupProperties r1 = new androidx.compose.ui.window.PopupProperties
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 63
            r22 = 0
            r14 = r1
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22)
            r2 = r2 & -7169(0xffffffffffffe3ff, float:NaN)
            r15 = r1
            r11 = r3
            r14 = r10
            r10 = r0
            goto L_0x010f
        L_0x010b:
            r14 = r10
            r15 = r11
            r10 = r0
            r11 = r3
        L_0x010f:
            r9.endDefaults()
            androidx.compose.ui.unit.IntOffset r0 = androidx.compose.ui.unit.IntOffset.m3968boximpl(r11)
            r1 = -3686552(0xffffffffffc7bf68, float:NaN)
            r9.startReplaceableGroup(r1)
            java.lang.String r1 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r1)
            boolean r1 = r9.changed((java.lang.Object) r10)
            boolean r0 = r9.changed((java.lang.Object) r0)
            r0 = r0 | r1
            java.lang.Object r1 = r9.rememberedValue()
            if (r0 != 0) goto L_0x0138
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r1 != r0) goto L_0x0140
        L_0x0138:
            androidx.compose.ui.window.AlignmentOffsetPositionProvider r1 = new androidx.compose.ui.window.AlignmentOffsetPositionProvider
            r1.<init>(r10, r11, r13)
            r9.updateRememberedValue(r1)
        L_0x0140:
            r9.endReplaceableGroup()
            androidx.compose.ui.window.AlignmentOffsetPositionProvider r1 = (androidx.compose.ui.window.AlignmentOffsetPositionProvider) r1
            r0 = r1
            androidx.compose.ui.window.PopupPositionProvider r0 = (androidx.compose.ui.window.PopupPositionProvider) r0
            int r1 = r2 >> 3
            r2 = r1 & 112(0x70, float:1.57E-43)
            r3 = r1 & 896(0x380, float:1.256E-42)
            r2 = r2 | r3
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r5 = r2 | r1
            r6 = 0
            r1 = r14
            r2 = r15
            r3 = r28
            r4 = r9
            Popup(r0, r1, r2, r3, r4, r5, r6)
            r1 = r10
            r2 = r11
            r4 = r14
            r5 = r15
        L_0x0160:
            androidx.compose.runtime.ScopeUpdateScope r9 = r9.endRestartGroup()
            if (r9 != 0) goto L_0x0167
            goto L_0x0178
        L_0x0167:
            androidx.compose.ui.window.AndroidPopup_androidKt$Popup$1 r10 = new androidx.compose.ui.window.AndroidPopup_androidKt$Popup$1
            r0 = r10
            r6 = r28
            r7 = r30
            r8 = r31
            r0.<init>(r1, r2, r4, r5, r6, r7, r8)
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r9.updateScope(r10)
        L_0x0178:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.window.AndroidPopup_androidKt.m4105PopupK5zGePQ(androidx.compose.ui.Alignment, long, kotlin.jvm.functions.Function0, androidx.compose.ui.window.PopupProperties, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01b4  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0266  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0272  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0276  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x02de  */
    /* JADX WARNING: Removed duplicated region for block: B:77:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Popup(androidx.compose.ui.window.PopupPositionProvider r28, kotlin.jvm.functions.Function0<kotlin.Unit> r29, androidx.compose.ui.window.PopupProperties r30, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r31, androidx.compose.runtime.Composer r32, int r33, int r34) {
        /*
            r11 = r28
            r12 = r31
            r13 = r33
            java.lang.String r0 = "popupPositionProvider"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = 1064154574(0x3f6db5ce, float:0.92855537)
            r1 = r32
            androidx.compose.runtime.Composer r14 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(Popup)P(2,1,3)223@9364L7,224@9403L7,225@9447L7,226@9502L7,227@9538L28,228@9593L29,229@9641L38,230@9702L944,258@10652L417,273@11075L229,282@11310L166,294@12039L153,304@12370L771:AndroidPopup.android.kt#2oxthz"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r0)
            r0 = r34 & 1
            if (r0 == 0) goto L_0x0025
            r0 = r13 | 6
            goto L_0x0035
        L_0x0025:
            r0 = r13 & 14
            if (r0 != 0) goto L_0x0034
            boolean r0 = r14.changed((java.lang.Object) r11)
            if (r0 == 0) goto L_0x0031
            r0 = 4
            goto L_0x0032
        L_0x0031:
            r0 = 2
        L_0x0032:
            r0 = r0 | r13
            goto L_0x0035
        L_0x0034:
            r0 = r13
        L_0x0035:
            r1 = r34 & 2
            if (r1 == 0) goto L_0x003c
            r0 = r0 | 48
            goto L_0x004f
        L_0x003c:
            r2 = r13 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x004f
            r2 = r29
            boolean r3 = r14.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x004b
            r3 = 32
            goto L_0x004d
        L_0x004b:
            r3 = 16
        L_0x004d:
            r0 = r0 | r3
            goto L_0x0051
        L_0x004f:
            r2 = r29
        L_0x0051:
            r3 = r13 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x006a
            r3 = r34 & 4
            if (r3 != 0) goto L_0x0064
            r3 = r30
            boolean r4 = r14.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0066
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x0068
        L_0x0064:
            r3 = r30
        L_0x0066:
            r4 = 128(0x80, float:1.794E-43)
        L_0x0068:
            r0 = r0 | r4
            goto L_0x006c
        L_0x006a:
            r3 = r30
        L_0x006c:
            r4 = r34 & 8
            if (r4 == 0) goto L_0x0073
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0083
        L_0x0073:
            r4 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x0083
            boolean r4 = r14.changed((java.lang.Object) r12)
            if (r4 == 0) goto L_0x0080
            r4 = 2048(0x800, float:2.87E-42)
            goto L_0x0082
        L_0x0080:
            r4 = 1024(0x400, float:1.435E-42)
        L_0x0082:
            r0 = r0 | r4
        L_0x0083:
            r4 = r0 & 5851(0x16db, float:8.199E-42)
            r4 = r4 ^ 1170(0x492, float:1.64E-42)
            if (r4 != 0) goto L_0x0095
            boolean r4 = r14.getSkipping()
            if (r4 != 0) goto L_0x0090
            goto L_0x0095
        L_0x0090:
            r14.skipToGroupEnd()
            goto L_0x02d7
        L_0x0095:
            r14.startDefaults()
            r4 = r13 & 1
            if (r4 == 0) goto L_0x00ad
            boolean r4 = r14.getDefaultsInvalid()
            if (r4 == 0) goto L_0x00a3
            goto L_0x00ad
        L_0x00a3:
            r14.skipToGroupEnd()
            r1 = r34 & 4
            if (r1 == 0) goto L_0x00d4
            r0 = r0 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x00d4
        L_0x00ad:
            if (r1 == 0) goto L_0x00b0
            r2 = 0
        L_0x00b0:
            r1 = r34 & 4
            if (r1 == 0) goto L_0x00d4
            androidx.compose.ui.window.PopupProperties r1 = new androidx.compose.ui.window.PopupProperties
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 63
            r24 = 0
            r16 = r1
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24)
            r0 = r0 & -897(0xfffffffffffffc7f, float:NaN)
            r18 = r0
            r17 = r1
            r16 = r2
            goto L_0x00da
        L_0x00d4:
            r18 = r0
            r16 = r2
            r17 = r3
        L_0x00da:
            r14.endDefaults()
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalView()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r10 = 103361330(0x6292b32, float:3.1817102E-35)
            java.lang.String r9 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r10, r9)
            java.lang.Object r0 = r14.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            r8 = r0
            android.view.View r8 = (android.view.View) r8
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r10, r9)
            java.lang.Object r0 = r14.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            r19 = r0
            androidx.compose.ui.unit.Density r19 = (androidx.compose.ui.unit.Density) r19
            androidx.compose.runtime.ProvidableCompositionLocal<java.lang.String> r0 = LocalPopupTestTag
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r10, r9)
            java.lang.Object r0 = r14.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            r20 = r0
            java.lang.String r20 = (java.lang.String) r20
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r10, r9)
            java.lang.Object r0 = r14.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.ui.unit.LayoutDirection r0 = (androidx.compose.ui.unit.LayoutDirection) r0
            r7 = 0
            androidx.compose.runtime.CompositionContext r6 = androidx.compose.runtime.ComposablesKt.rememberCompositionContext(r14, r7)
            int r1 = r18 >> 9
            r1 = r1 & 14
            androidx.compose.runtime.State r5 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r12, r14, r1)
            java.lang.Object[] r1 = new java.lang.Object[r7]
            r2 = 0
            r3 = 0
            androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupId$1 r4 = androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupId$1.INSTANCE
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            r21 = 3080(0xc08, float:4.316E-42)
            r22 = 6
            r15 = r5
            r5 = r14
            r25 = r6
            r6 = r21
            r7 = r22
            java.lang.Object r1 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r1, r2, (java.lang.String) r3, r4, (androidx.compose.runtime.Composer) r5, (int) r6, (int) r7)
            r7 = r1
            java.util.UUID r7 = (java.util.UUID) r7
            r1 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r14.startReplaceableGroup(r1)
            java.lang.String r1 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r1)
            java.lang.Object r1 = r14.rememberedValue()
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r1 != r2) goto L_0x01b4
            androidx.compose.ui.window.PopupLayout r6 = new androidx.compose.ui.window.PopupLayout
            java.lang.String r1 = "popupId"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r1)
            r21 = 0
            r22 = 128(0x80, float:1.794E-43)
            r23 = 0
            r5 = r0
            r0 = r6
            r1 = r16
            r2 = r17
            r3 = r20
            r4 = r8
            r8 = r5
            r5 = r19
            r26 = r6
            r6 = r28
            r29 = r8
            r8 = r21
            r27 = r9
            r9 = r22
            r12 = 103361330(0x6292b32, float:3.1817102E-35)
            r10 = r23
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r0 = -985541102(0xffffffffc541d612, float:-3101.3794)
            androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupLayout$1$1$1 r1 = new androidx.compose.ui.window.AndroidPopup_androidKt$Popup$popupLayout$1$1$1
            r2 = r26
            r1.<init>(r2, r15)
            r3 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambdaInstance(r0, r3, r1)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r25
            r2.setContent(r1, r0)
            r14.updateRememberedValue(r2)
            r1 = r2
            goto L_0x01bb
        L_0x01b4:
            r29 = r0
            r27 = r9
            r12 = 103361330(0x6292b32, float:3.1817102E-35)
        L_0x01bb:
            r14.endReplaceableGroup()
            androidx.compose.ui.window.PopupLayout r1 = (androidx.compose.ui.window.PopupLayout) r1
            androidx.compose.ui.window.AndroidPopup_androidKt$Popup$2 r0 = new androidx.compose.ui.window.AndroidPopup_androidKt$Popup$2
            r3 = r0
            r4 = r1
            r5 = r16
            r6 = r17
            r7 = r20
            r8 = r29
            r3.<init>(r4, r5, r6, r7, r8)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r2 = 8
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r1, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r0, (androidx.compose.runtime.Composer) r14, (int) r2)
            androidx.compose.ui.window.AndroidPopup_androidKt$Popup$3 r0 = new androidx.compose.ui.window.AndroidPopup_androidKt$Popup$3
            r3 = r0
            r3.<init>(r4, r5, r6, r7, r8)
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            r3 = 0
            androidx.compose.runtime.EffectsKt.SideEffect(r0, r14, r3)
            androidx.compose.ui.window.AndroidPopup_androidKt$Popup$4 r0 = new androidx.compose.ui.window.AndroidPopup_androidKt$Popup$4
            r0.<init>(r1, r11)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r4 = r18 & 14
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r11, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r0, (androidx.compose.runtime.Composer) r14, (int) r4)
            androidx.compose.ui.window.AndroidPopup_androidKt$Popup$5 r0 = new androidx.compose.ui.window.AndroidPopup_androidKt$Popup$5
            r4 = 0
            r0.<init>(r1, r4)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r1, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r0, (androidx.compose.runtime.Composer) r14, (int) r2)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            androidx.compose.ui.window.AndroidPopup_androidKt$Popup$7 r2 = new androidx.compose.ui.window.AndroidPopup_androidKt$Popup$7
            r2.<init>(r1)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.layout.OnGloballyPositionedModifierKt.onGloballyPositioned(r0, r2)
            androidx.compose.ui.window.AndroidPopup_androidKt$Popup$8 r2 = new androidx.compose.ui.window.AndroidPopup_androidKt$Popup$8
            r4 = r29
            r2.<init>(r1, r4)
            androidx.compose.ui.layout.MeasurePolicy r2 = (androidx.compose.ui.layout.MeasurePolicy) r2
            r1 = 1376089394(0x52057532, float:1.43299215E11)
            r14.startReplaceableGroup(r1)
            java.lang.String r1 = "C(Layout)P(!1,2)72@2847L7,73@2902L7,74@2961L7,75@2973L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r1)
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            r4 = r27
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r12, r4)
            java.lang.Object r1 = r14.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.ui.unit.Density r1 = (androidx.compose.ui.unit.Density) r1
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r12, r4)
            java.lang.Object r5 = r14.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.ui.unit.LayoutDirection r5 = (androidx.compose.ui.unit.LayoutDirection) r5
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r12, r4)
            java.lang.Object r4 = r14.consume(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.ui.platform.ViewConfiguration r4 = (androidx.compose.ui.platform.ViewConfiguration) r4
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r6 = r6.getConstructor()
            kotlin.jvm.functions.Function3 r0 = androidx.compose.ui.layout.LayoutKt.materializerOf(r0)
            androidx.compose.runtime.Applier r7 = r14.getApplier()
            boolean r7 = r7 instanceof androidx.compose.runtime.Applier
            if (r7 != 0) goto L_0x0269
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0269:
            r14.startReusableNode()
            boolean r7 = r14.getInserting()
            if (r7 == 0) goto L_0x0276
            r14.createNode(r6)
            goto L_0x0279
        L_0x0276:
            r14.useNode()
        L_0x0279:
            r14.disableReusing()
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.Updater.m1234constructorimpl(r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r6, r2, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetDensity()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r6, r1, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r6, r5, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r6, r4, r1)
            r14.enableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m1226constructorimpl(r14)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m1225boximpl(r1)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
            r0.invoke(r1, r14, r2)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r14.startReplaceableGroup(r0)
            r0 = 1097164583(0x41656727, float:14.337684)
            r14.startReplaceableGroup(r0)
            java.lang.String r0 = "C:AndroidPopup.android.kt#2oxthz"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r0)
            r14.endReplaceableGroup()
            r14.endReplaceableGroup()
            r14.endNode()
            r14.endReplaceableGroup()
            r2 = r16
            r3 = r17
        L_0x02d7:
            androidx.compose.runtime.ScopeUpdateScope r7 = r14.endRestartGroup()
            if (r7 != 0) goto L_0x02de
            goto L_0x02f1
        L_0x02de:
            androidx.compose.ui.window.AndroidPopup_androidKt$Popup$9 r8 = new androidx.compose.ui.window.AndroidPopup_androidKt$Popup$9
            r0 = r8
            r1 = r28
            r4 = r31
            r5 = r33
            r6 = r34
            r0.<init>(r1, r2, r3, r4, r5, r6)
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r7.updateScope(r8)
        L_0x02f1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.window.AndroidPopup_androidKt.Popup(androidx.compose.ui.window.PopupPositionProvider, kotlin.jvm.functions.Function0, androidx.compose.ui.window.PopupProperties, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final ProvidableCompositionLocal<String> getLocalPopupTestTag() {
        return LocalPopupTestTag;
    }

    public static final void PopupTestTag(String str, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(str, HeaderParameterNames.AUTHENTICATION_TAG);
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer startRestartGroup = composer.startRestartGroup(1275558854);
        ComposerKt.sourceInformation(startRestartGroup, "C(PopupTestTag)P(1)328@13516L75:AndroidPopup.android.kt#2oxthz");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed((Object) str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changed((Object) function2) ? 32 : 16;
        }
        if (((i2 & 91) ^ 18) != 0 || !startRestartGroup.getSkipping()) {
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{LocalPopupTestTag.provides(str)}, function2, startRestartGroup, (i2 & 112) | 8);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AndroidPopup_androidKt$PopupTestTag$1(str, function2, i));
        }
    }

    private static final void SimpleStack(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        composer.startReplaceableGroup(1560115737);
        ComposerKt.sourceInformation(composer, "C(SimpleStack)P(1)336@13854L979:AndroidPopup.android.kt#2oxthz");
        MeasurePolicy measurePolicy = AndroidPopup_androidKt$SimpleStack$1.INSTANCE;
        composer.startReplaceableGroup(1376089394);
        ComposerKt.sourceInformation(composer, "C(Layout)P(!1,2)72@2847L7,73@2902L7,74@2961L7,75@2973L460:Layout.kt#80mrfh");
        ComposerKt.sourceInformationMarkerStart(composer, 103361330, "C:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd(composer);
        Density density = (Density) consume;
        ComposerKt.sourceInformationMarkerStart(composer, 103361330, "C:CompositionLocal.kt#9igjgp");
        Object consume2 = composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ComposerKt.sourceInformationMarkerEnd(composer);
        LayoutDirection layoutDirection = (LayoutDirection) consume2;
        ComposerKt.sourceInformationMarkerStart(composer, 103361330, "C:CompositionLocal.kt#9igjgp");
        Object consume3 = composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposerKt.sourceInformationMarkerEnd(composer);
        ViewConfiguration viewConfiguration = (ViewConfiguration) consume3;
        Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier);
        int i2 = (((((i << 3) & 112) | ((i >> 3) & 14)) << 9) & 7168) | 6;
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        composer.disableReusing();
        Composer r3 = Updater.m1234constructorimpl(composer);
        Updater.m1241setimpl(r3, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m1241setimpl(r3, density, ComposeUiNode.Companion.getSetDensity());
        Updater.m1241setimpl(r3, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
        Updater.m1241setimpl(r3, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
        composer.enableReusing();
        materializerOf.invoke(SkippableUpdater.m1225boximpl(SkippableUpdater.m1226constructorimpl(composer)), composer, Integer.valueOf((i2 >> 3) & 112));
        composer.startReplaceableGroup(2058660585);
        function2.invoke(composer, Integer.valueOf((i2 >> 9) & 14));
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }

    public static final boolean isFlagSecureEnabled(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getRootView().getLayoutParams();
        WindowManager.LayoutParams layoutParams2 = layoutParams instanceof WindowManager.LayoutParams ? (WindowManager.LayoutParams) layoutParams : null;
        if (layoutParams2 == null || (layoutParams2.flags & 8192) == 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static final IntRect toIntBounds(Rect rect) {
        return new IntRect(rect.left, rect.top, rect.right, rect.bottom);
    }

    public static /* synthetic */ boolean isPopupLayout$default(View view, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        return isPopupLayout(view, str);
    }

    public static final boolean isPopupLayout(View view, String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        return (view instanceof PopupLayout) && (str == null || Intrinsics.areEqual((Object) str, (Object) ((PopupLayout) view).getTestTag()));
    }

    /* access modifiers changed from: private */
    /* renamed from: Popup$lambda-1  reason: not valid java name */
    public static final Function2<Composer, Integer, Unit> m4104Popup$lambda1(State<? extends Function2<? super Composer, ? super Integer, Unit>> state) {
        return (Function2) state.getValue();
    }
}
