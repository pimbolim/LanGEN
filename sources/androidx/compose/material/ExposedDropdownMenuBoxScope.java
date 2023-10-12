package androidx.compose.material;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;

@ExperimentalMaterialApi
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001JK\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\u0002\b\r¢\u0006\u0002\b\u000eH\u0017¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\t*\u00020\t2\b\b\u0002\u0010\u0011\u001a\u00020\u0005H&¨\u0006\u0012"}, d2 = {"Landroidx/compose/material/ExposedDropdownMenuBoxScope;", "", "ExposedDropdownMenu", "", "expanded", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "exposedDropdownSize", "matchTextFieldWidth", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ExposedDropdownMenu.kt */
public interface ExposedDropdownMenuBoxScope {
    void ExposedDropdownMenu(boolean z, Function0<Unit> function0, Modifier modifier, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i, int i2);

    Modifier exposedDropdownSize(Modifier modifier, boolean z);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ExposedDropdownMenu.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ Modifier exposedDropdownSize$default(ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, Modifier modifier, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = true;
                }
                return exposedDropdownMenuBoxScope.exposedDropdownSize(modifier, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: exposedDropdownSize");
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v0, resolved type: kotlin.jvm.functions.Function2} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0079  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x007c  */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x0090  */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x0093  */
        /* JADX WARNING: Removed duplicated region for block: B:56:0x00b5  */
        /* JADX WARNING: Removed duplicated region for block: B:57:0x00bb  */
        /* JADX WARNING: Removed duplicated region for block: B:79:0x01c1  */
        /* JADX WARNING: Removed duplicated region for block: B:81:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static void ExposedDropdownMenu(androidx.compose.material.ExposedDropdownMenuBoxScope r21, boolean r22, kotlin.jvm.functions.Function0<kotlin.Unit> r23, androidx.compose.ui.Modifier r24, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r25, androidx.compose.runtime.Composer r26, int r27, int r28) {
            /*
                r7 = r21
                r8 = r23
                r9 = r25
                r10 = r27
                java.lang.String r0 = "this"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
                java.lang.String r0 = "onDismissRequest"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
                java.lang.String r0 = "content"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
                r0 = -1421923601(0xffffffffab3f2aef, float:-6.7916414E-13)
                r1 = r26
                androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
                java.lang.String r0 = "C(ExposedDropdownMenu)P(1,3,2)244@9346L42,248@9548L51,249@9639L7,253@9786L139,257@9939L444:ExposedDropdownMenu.kt#jmzs0o"
                androidx.compose.runtime.ComposerKt.sourceInformation(r11, r0)
                r0 = r28 & 1
                r1 = 2
                if (r0 == 0) goto L_0x0030
                r0 = r10 | 6
                r12 = r22
                goto L_0x0042
            L_0x0030:
                r0 = r10 & 14
                r12 = r22
                if (r0 != 0) goto L_0x0041
                boolean r0 = r11.changed((boolean) r12)
                if (r0 == 0) goto L_0x003e
                r0 = 4
                goto L_0x003f
            L_0x003e:
                r0 = 2
            L_0x003f:
                r0 = r0 | r10
                goto L_0x0042
            L_0x0041:
                r0 = r10
            L_0x0042:
                r2 = r28 & 2
                if (r2 == 0) goto L_0x0049
                r0 = r0 | 48
                goto L_0x0059
            L_0x0049:
                r2 = r10 & 112(0x70, float:1.57E-43)
                if (r2 != 0) goto L_0x0059
                boolean r2 = r11.changed((java.lang.Object) r8)
                if (r2 == 0) goto L_0x0056
                r2 = 32
                goto L_0x0058
            L_0x0056:
                r2 = 16
            L_0x0058:
                r0 = r0 | r2
            L_0x0059:
                r2 = r28 & 4
                if (r2 == 0) goto L_0x0060
                r0 = r0 | 384(0x180, float:5.38E-43)
                goto L_0x0073
            L_0x0060:
                r3 = r10 & 896(0x380, float:1.256E-42)
                if (r3 != 0) goto L_0x0073
                r3 = r24
                boolean r4 = r11.changed((java.lang.Object) r3)
                if (r4 == 0) goto L_0x006f
                r4 = 256(0x100, float:3.59E-43)
                goto L_0x0071
            L_0x006f:
                r4 = 128(0x80, float:1.794E-43)
            L_0x0071:
                r0 = r0 | r4
                goto L_0x0075
            L_0x0073:
                r3 = r24
            L_0x0075:
                r4 = r28 & 8
                if (r4 == 0) goto L_0x007c
                r0 = r0 | 3072(0xc00, float:4.305E-42)
                goto L_0x008c
            L_0x007c:
                r4 = r10 & 7168(0x1c00, float:1.0045E-41)
                if (r4 != 0) goto L_0x008c
                boolean r4 = r11.changed((java.lang.Object) r9)
                if (r4 == 0) goto L_0x0089
                r4 = 2048(0x800, float:2.87E-42)
                goto L_0x008b
            L_0x0089:
                r4 = 1024(0x400, float:1.435E-42)
            L_0x008b:
                r0 = r0 | r4
            L_0x008c:
                r4 = r28 & 16
                if (r4 == 0) goto L_0x0093
                r0 = r0 | 24576(0x6000, float:3.4438E-41)
                goto L_0x00a5
            L_0x0093:
                r4 = 57344(0xe000, float:8.0356E-41)
                r4 = r4 & r10
                if (r4 != 0) goto L_0x00a5
                boolean r4 = r11.changed((java.lang.Object) r7)
                if (r4 == 0) goto L_0x00a2
                r4 = 16384(0x4000, float:2.2959E-41)
                goto L_0x00a4
            L_0x00a2:
                r4 = 8192(0x2000, float:1.14794E-41)
            L_0x00a4:
                r0 = r0 | r4
            L_0x00a5:
                r13 = r0
                r0 = 46811(0xb6db, float:6.5596E-41)
                r0 = r0 & r13
                r0 = r0 ^ 9362(0x2492, float:1.3119E-41)
                if (r0 != 0) goto L_0x00bb
                boolean r0 = r11.getSkipping()
                if (r0 != 0) goto L_0x00b5
                goto L_0x00bb
            L_0x00b5:
                r11.skipToGroupEnd()
                r4 = r3
                goto L_0x01ba
            L_0x00bb:
                if (r2 == 0) goto L_0x00c3
                androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
                androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
                r14 = r0
                goto L_0x00c4
            L_0x00c3:
                r14 = r3
            L_0x00c4:
                r0 = -3687241(0xffffffffffc7bcb7, float:NaN)
                r11.startReplaceableGroup(r0)
                java.lang.String r2 = "C(remember):Composables.kt#9igjgp"
                androidx.compose.runtime.ComposerKt.sourceInformation(r11, r2)
                java.lang.Object r3 = r11.rememberedValue()
                androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
                java.lang.Object r4 = r4.getEmpty()
                if (r3 != r4) goto L_0x00e8
                androidx.compose.animation.core.MutableTransitionState r3 = new androidx.compose.animation.core.MutableTransitionState
                r4 = 0
                java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
                r3.<init>(r4)
                r11.updateRememberedValue(r3)
            L_0x00e8:
                r11.endReplaceableGroup()
                androidx.compose.animation.core.MutableTransitionState r3 = (androidx.compose.animation.core.MutableTransitionState) r3
                java.lang.Boolean r4 = java.lang.Boolean.valueOf(r22)
                r3.setTargetState(r4)
                java.lang.Object r4 = r3.getCurrentState()
                java.lang.Boolean r4 = (java.lang.Boolean) r4
                boolean r4 = r4.booleanValue()
                if (r4 != 0) goto L_0x010c
                java.lang.Object r4 = r3.getTargetState()
                java.lang.Boolean r4 = (java.lang.Boolean) r4
                boolean r4 = r4.booleanValue()
                if (r4 == 0) goto L_0x01b9
            L_0x010c:
                r11.startReplaceableGroup(r0)
                androidx.compose.runtime.ComposerKt.sourceInformation(r11, r2)
                java.lang.Object r0 = r11.rememberedValue()
                androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
                java.lang.Object r2 = r2.getEmpty()
                if (r0 != r2) goto L_0x0130
                androidx.compose.ui.graphics.TransformOrigin$Companion r0 = androidx.compose.ui.graphics.TransformOrigin.Companion
                long r4 = r0.m1955getCenterSzJe1aQ()
                androidx.compose.ui.graphics.TransformOrigin r0 = androidx.compose.ui.graphics.TransformOrigin.m1942boximpl(r4)
                r2 = 0
                androidx.compose.runtime.MutableState r0 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r0, r2, r1, r2)
                r11.updateRememberedValue(r0)
            L_0x0130:
                r11.endReplaceableGroup()
                r2 = r0
                androidx.compose.runtime.MutableState r2 = (androidx.compose.runtime.MutableState) r2
                androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
                androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
                r1 = 103361330(0x6292b32, float:3.1817102E-35)
                java.lang.String r4 = "C:CompositionLocal.kt#9igjgp"
                androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r1, r4)
                java.lang.Object r0 = r11.consume(r0)
                androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
                r18 = r0
                androidx.compose.ui.unit.Density r18 = (androidx.compose.ui.unit.Density) r18
                androidx.compose.ui.unit.DpOffset$Companion r0 = androidx.compose.ui.unit.DpOffset.Companion
                long r16 = r0.m3930getZeroRKDOV3M()
                r0 = -3686930(0xffffffffffc7bdee, float:NaN)
                r11.startReplaceableGroup(r0)
                java.lang.String r0 = "C(remember)P(1):Composables.kt#9igjgp"
                androidx.compose.runtime.ComposerKt.sourceInformation(r11, r0)
                boolean r0 = r11.changed((java.lang.Object) r2)
                java.lang.Object r1 = r11.rememberedValue()
                if (r0 != 0) goto L_0x0172
                androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
                java.lang.Object r0 = r0.getEmpty()
                if (r1 != r0) goto L_0x017d
            L_0x0172:
                androidx.compose.material.ExposedDropdownMenuBoxScope$ExposedDropdownMenu$popupPositionProvider$1$1 r0 = new androidx.compose.material.ExposedDropdownMenuBoxScope$ExposedDropdownMenu$popupPositionProvider$1$1
                r0.<init>(r2)
                r1 = r0
                kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
                r11.updateRememberedValue(r1)
            L_0x017d:
                r11.endReplaceableGroup()
                r19 = r1
                kotlin.jvm.functions.Function2 r19 = (kotlin.jvm.functions.Function2) r19
                r20 = 0
                androidx.compose.material.DropdownMenuPositionProvider r0 = new androidx.compose.material.DropdownMenuPositionProvider
                r15 = r0
                r15.<init>(r16, r18, r19, r20)
                r15 = r0
                androidx.compose.ui.window.PopupPositionProvider r15 = (androidx.compose.ui.window.PopupPositionProvider) r15
                r6 = -819904032(0xffffffffcf2141e0, float:-2.70544896E9)
                androidx.compose.material.ExposedDropdownMenuBoxScope$ExposedDropdownMenu$1 r5 = new androidx.compose.material.ExposedDropdownMenuBoxScope$ExposedDropdownMenu$1
                r0 = r5
                r1 = r3
                r3 = r21
                r4 = r14
                r7 = r5
                r5 = r25
                r8 = -819904032(0xffffffffcf2141e0, float:-2.70544896E9)
                r6 = r13
                r0.<init>(r1, r2, r3, r4, r5, r6)
                r0 = 1
                androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r11, r8, r0, r7)
                r2 = r0
                kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
                int r0 = r13 >> 3
                r0 = r0 & 14
                r4 = r0 | 384(0x180, float:5.38E-43)
                r5 = 0
                r0 = r23
                r1 = r15
                r3 = r11
                androidx.compose.material.internal.ExposedDropdownMenuPopupKt.ExposedDropdownMenuPopup(r0, r1, r2, r3, r4, r5)
            L_0x01b9:
                r4 = r14
            L_0x01ba:
                androidx.compose.runtime.ScopeUpdateScope r8 = r11.endRestartGroup()
                if (r8 != 0) goto L_0x01c1
                goto L_0x01d8
            L_0x01c1:
                androidx.compose.material.ExposedDropdownMenuBoxScope$ExposedDropdownMenu$2 r11 = new androidx.compose.material.ExposedDropdownMenuBoxScope$ExposedDropdownMenu$2
                r0 = r11
                r1 = r21
                r2 = r22
                r3 = r23
                r5 = r25
                r6 = r27
                r7 = r28
                r0.<init>(r1, r2, r3, r4, r5, r6, r7)
                kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
                r8.updateScope(r11)
            L_0x01d8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ExposedDropdownMenuBoxScope.DefaultImpls.ExposedDropdownMenu(androidx.compose.material.ExposedDropdownMenuBoxScope, boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
        }
    }
}
