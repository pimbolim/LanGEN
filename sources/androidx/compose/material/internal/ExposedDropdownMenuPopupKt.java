package androidx.compose.material.internal;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
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
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a:\u0010\u0005\u001a\u00020\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0011\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\fH\u0001¢\u0006\u0002\u0010\r\u001a+\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0013\b\b\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\fH\b¢\u0006\u0002\u0010\u0011\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0012"}, d2 = {"LocalPopupTestTag", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "", "getLocalPopupTestTag", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "ExposedDropdownMenuPopup", "", "onDismissRequest", "Lkotlin/Function0;", "popupPositionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "SimpleStack", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ExposedDropdownMenuPopup.kt */
public final class ExposedDropdownMenuPopupKt {
    private static final ProvidableCompositionLocal<String> LocalPopupTestTag = CompositionLocalKt.compositionLocalOf$default((SnapshotMutationPolicy) null, ExposedDropdownMenuPopupKt$LocalPopupTestTag$1.INSTANCE, 1, (Object) null);

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: androidx.compose.material.internal.PopupLayout} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v36, resolved type: androidx.compose.material.internal.PopupLayout} */
    /* JADX WARNING: type inference failed for: r11v4 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void ExposedDropdownMenuPopup(kotlin.jvm.functions.Function0<kotlin.Unit> r23, androidx.compose.ui.window.PopupPositionProvider r24, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r25, androidx.compose.runtime.Composer r26, int r27, int r28) {
        /*
            r7 = r24
            r8 = r25
            r9 = r27
            java.lang.String r0 = "popupPositionProvider"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r0 = 741192042(0x2c2db16a, float:2.4683263E-12)
            r1 = r26
            androidx.compose.runtime.Composer r6 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(ExposedDropdownMenuPopup)P(1,2)81@3246L7,82@3285L7,83@3329L7,84@3384L7,85@3420L28,86@3475L29,87@3523L38,88@3584L907,115@4497L380,129@4883L192,137@5081L166,146@5425L647:ExposedDropdownMenuPopup.kt#mnwmf7"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r0)
            r0 = r28 & 1
            if (r0 == 0) goto L_0x0028
            r1 = r9 | 6
            r2 = r1
            r1 = r23
            goto L_0x003c
        L_0x0028:
            r1 = r9 & 14
            if (r1 != 0) goto L_0x0039
            r1 = r23
            boolean r2 = r6.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x0036
            r2 = 4
            goto L_0x0037
        L_0x0036:
            r2 = 2
        L_0x0037:
            r2 = r2 | r9
            goto L_0x003c
        L_0x0039:
            r1 = r23
            r2 = r9
        L_0x003c:
            r3 = r28 & 2
            if (r3 == 0) goto L_0x0043
            r2 = r2 | 48
            goto L_0x0053
        L_0x0043:
            r3 = r9 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0053
            boolean r3 = r6.changed((java.lang.Object) r7)
            if (r3 == 0) goto L_0x0050
            r3 = 32
            goto L_0x0052
        L_0x0050:
            r3 = 16
        L_0x0052:
            r2 = r2 | r3
        L_0x0053:
            r3 = r28 & 4
            if (r3 == 0) goto L_0x005a
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x006a
        L_0x005a:
            r3 = r9 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x006a
            boolean r3 = r6.changed((java.lang.Object) r8)
            if (r3 == 0) goto L_0x0067
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x0069
        L_0x0067:
            r3 = 128(0x80, float:1.794E-43)
        L_0x0069:
            r2 = r2 | r3
        L_0x006a:
            r5 = r2
            r2 = r5 & 731(0x2db, float:1.024E-42)
            r2 = r2 ^ 146(0x92, float:2.05E-43)
            if (r2 != 0) goto L_0x007e
            boolean r2 = r6.getSkipping()
            if (r2 != 0) goto L_0x0078
            goto L_0x007e
        L_0x0078:
            r6.skipToGroupEnd()
            r8 = r6
            goto L_0x0258
        L_0x007e:
            if (r0 == 0) goto L_0x0083
            r0 = 0
            r4 = r0
            goto L_0x0084
        L_0x0083:
            r4 = r1
        L_0x0084:
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalView()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r3 = 103361330(0x6292b32, float:3.1817102E-35)
            java.lang.String r2 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r3, r2)
            java.lang.Object r0 = r6.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            r17 = r0
            android.view.View r17 = (android.view.View) r17
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r3, r2)
            java.lang.Object r0 = r6.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            r18 = r0
            androidx.compose.ui.unit.Density r18 = (androidx.compose.ui.unit.Density) r18
            androidx.compose.runtime.ProvidableCompositionLocal<java.lang.String> r0 = LocalPopupTestTag
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r3, r2)
            java.lang.Object r0 = r6.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            r1 = r0
            java.lang.String r1 = (java.lang.String) r1
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r3, r2)
            java.lang.Object r0 = r6.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            androidx.compose.ui.unit.LayoutDirection r0 = (androidx.compose.ui.unit.LayoutDirection) r0
            r15 = 0
            androidx.compose.runtime.CompositionContext r14 = androidx.compose.runtime.ComposablesKt.rememberCompositionContext(r6, r15)
            int r10 = r5 >> 6
            r10 = r10 & 14
            androidx.compose.runtime.State r13 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r8, r6, r10)
            java.lang.Object[] r10 = new java.lang.Object[r15]
            r11 = 0
            r12 = 0
            androidx.compose.material.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$popupId$1 r16 = androidx.compose.material.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$popupId$1.INSTANCE
            kotlin.jvm.functions.Function0 r16 = (kotlin.jvm.functions.Function0) r16
            r19 = 3080(0xc08, float:4.316E-42)
            r20 = 6
            r21 = r13
            r13 = r16
            r22 = r14
            r14 = r6
            r15 = r19
            r16 = r20
            java.lang.Object r10 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r10, r11, (java.lang.String) r12, r13, (androidx.compose.runtime.Composer) r14, (int) r15, (int) r16)
            java.util.UUID r10 = (java.util.UUID) r10
            r11 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r6.startReplaceableGroup(r11)
            java.lang.String r11 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r11)
            java.lang.Object r11 = r6.rememberedValue()
            androidx.compose.runtime.Composer$Companion r12 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r12 = r12.getEmpty()
            if (r11 != r12) goto L_0x014d
            androidx.compose.material.internal.PopupLayout r11 = new androidx.compose.material.internal.PopupLayout
            java.lang.String r12 = "popupId"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r12)
            r12 = r0
            r0 = r11
            r13 = r1
            r1 = r4
            r14 = r2
            r2 = r13
            r15 = 103361330(0x6292b32, float:3.1817102E-35)
            r3 = r17
            r15 = r4
            r4 = r18
            r17 = r5
            r5 = r24
            r8 = r6
            r6 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r0 = -985530875(0xffffffffc541fe05, float:-3103.8762)
            androidx.compose.material.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$popupLayout$1$1$1 r1 = new androidx.compose.material.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$popupLayout$1$1$1
            r2 = r21
            r1.<init>(r11, r2)
            r2 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambdaInstance(r0, r2, r1)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r22
            r11.setContent(r1, r0)
            r8.updateRememberedValue(r11)
            goto L_0x0154
        L_0x014d:
            r12 = r0
            r13 = r1
            r14 = r2
            r15 = r4
            r17 = r5
            r8 = r6
        L_0x0154:
            r8.endReplaceableGroup()
            androidx.compose.material.internal.PopupLayout r11 = (androidx.compose.material.internal.PopupLayout) r11
            androidx.compose.material.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$1 r0 = new androidx.compose.material.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$1
            r0.<init>(r11, r15, r13, r12)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r1 = 8
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r11, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r0, (androidx.compose.runtime.Composer) r8, (int) r1)
            androidx.compose.material.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$2 r0 = new androidx.compose.material.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$2
            r0.<init>(r11, r15, r13, r12)
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            r1 = 0
            androidx.compose.runtime.EffectsKt.SideEffect(r0, r8, r1)
            androidx.compose.material.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$3 r0 = new androidx.compose.material.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$3
            r0.<init>(r11, r7)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            int r2 = r17 >> 3
            r2 = r2 & 14
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r7, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r0, (androidx.compose.runtime.Composer) r8, (int) r2)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            androidx.compose.material.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$5 r2 = new androidx.compose.material.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$5
            r2.<init>(r11)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.layout.OnGloballyPositionedModifierKt.onGloballyPositioned(r0, r2)
            androidx.compose.material.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$6 r2 = new androidx.compose.material.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$6
            r2.<init>(r11, r12)
            androidx.compose.ui.layout.MeasurePolicy r2 = (androidx.compose.ui.layout.MeasurePolicy) r2
            r3 = 1376089394(0x52057532, float:1.43299215E11)
            r8.startReplaceableGroup(r3)
            java.lang.String r3 = "C(Layout)P(!1,2)72@2847L7,73@2902L7,74@2961L7,75@2973L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r3)
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r4 = 103361330(0x6292b32, float:3.1817102E-35)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r4, r14)
            java.lang.Object r3 = r8.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.ui.unit.Density r3 = (androidx.compose.ui.unit.Density) r3
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r4, r14)
            java.lang.Object r5 = r8.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.ui.unit.LayoutDirection r5 = (androidx.compose.ui.unit.LayoutDirection) r5
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r4, r14)
            java.lang.Object r4 = r8.consume(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.ui.platform.ViewConfiguration r4 = (androidx.compose.ui.platform.ViewConfiguration) r4
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r6 = r6.getConstructor()
            kotlin.jvm.functions.Function3 r0 = androidx.compose.ui.layout.LayoutKt.materializerOf(r0)
            androidx.compose.runtime.Applier r10 = r8.getApplier()
            boolean r10 = r10 instanceof androidx.compose.runtime.Applier
            if (r10 != 0) goto L_0x01ed
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x01ed:
            r8.startReusableNode()
            boolean r10 = r8.getInserting()
            if (r10 == 0) goto L_0x01fa
            r8.createNode(r6)
            goto L_0x01fd
        L_0x01fa:
            r8.useNode()
        L_0x01fd:
            r8.disableReusing()
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.Updater.m1234constructorimpl(r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r10 = r10.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r6, r2, r10)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetDensity()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r6, r3, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r6, r5, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r6, r4, r2)
            r8.enableReusing()
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.SkippableUpdater.m1226constructorimpl(r8)
            androidx.compose.runtime.SkippableUpdater r2 = androidx.compose.runtime.SkippableUpdater.m1225boximpl(r2)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.invoke(r2, r8, r1)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r8.startReplaceableGroup(r0)
            r0 = 952323942(0x38c34f66, float:9.313114E-5)
            r8.startReplaceableGroup(r0)
            java.lang.String r0 = "C:ExposedDropdownMenuPopup.kt#mnwmf7"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r0)
            r8.endReplaceableGroup()
            r8.endReplaceableGroup()
            r8.endNode()
            r8.endReplaceableGroup()
            r1 = r15
        L_0x0258:
            androidx.compose.runtime.ScopeUpdateScope r6 = r8.endRestartGroup()
            if (r6 != 0) goto L_0x025f
            goto L_0x0272
        L_0x025f:
            androidx.compose.material.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$7 r8 = new androidx.compose.material.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$7
            r0 = r8
            r2 = r24
            r3 = r25
            r4 = r27
            r5 = r28
            r0.<init>(r1, r2, r3, r4, r5)
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r6.updateScope(r8)
        L_0x0272:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.internal.ExposedDropdownMenuPopupKt.ExposedDropdownMenuPopup(kotlin.jvm.functions.Function0, androidx.compose.ui.window.PopupPositionProvider, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final ProvidableCompositionLocal<String> getLocalPopupTestTag() {
        return LocalPopupTestTag;
    }

    private static final void SimpleStack(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        composer.startReplaceableGroup(-968745991);
        ComposerKt.sourceInformation(composer, "C(SimpleStack)P(1)175@6616L979:ExposedDropdownMenuPopup.kt#mnwmf7");
        MeasurePolicy measurePolicy = ExposedDropdownMenuPopupKt$SimpleStack$1.INSTANCE;
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

    /* access modifiers changed from: private */
    /* renamed from: ExposedDropdownMenuPopup$lambda-0  reason: not valid java name */
    public static final Function2<Composer, Integer, Unit> m1193ExposedDropdownMenuPopup$lambda0(State<? extends Function2<? super Composer, ? super Integer, Unit>> state) {
        return (Function2) state.getValue();
    }
}
