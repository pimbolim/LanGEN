package androidx.compose.ui.window;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
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

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a8\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0002\u0010\b\u001a*\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0007H\u0003¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Dialog", "", "onDismissRequest", "Lkotlin/Function0;", "properties", "Landroidx/compose/ui/window/DialogProperties;", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/DialogProperties;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "DialogLayout", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ui_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: AndroidDialog.android.kt */
public final class AndroidDialog_androidKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v5, resolved type: androidx.compose.ui.window.DialogWrapper} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v33, resolved type: androidx.compose.ui.window.DialogWrapper} */
    /* JADX WARNING: type inference failed for: r12v3 */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x008e, code lost:
        if ((r24 & 2) != 0) goto L_0x00a0;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0130  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Dialog(kotlin.jvm.functions.Function0<kotlin.Unit> r19, androidx.compose.ui.window.DialogProperties r20, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r21, androidx.compose.runtime.Composer r22, int r23, int r24) {
        /*
            r7 = r19
            r8 = r21
            r9 = r23
            java.lang.String r0 = "onDismissRequest"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r0 = 677739655(0x28657c87, float:1.2739056E-14)
            r1 = r22
            androidx.compose.runtime.Composer r6 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(Dialog)P(1,2)140@5658L7,141@5697L7,142@5752L7,143@5782L28,144@5837L29,145@5886L38,146@5942L616,167@6564L154,176@6724L193:AndroidDialog.android.kt#2oxthz"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r0)
            r0 = r24 & 1
            if (r0 == 0) goto L_0x0025
            r0 = r9 | 6
            goto L_0x0035
        L_0x0025:
            r0 = r9 & 14
            if (r0 != 0) goto L_0x0034
            boolean r0 = r6.changed((java.lang.Object) r7)
            if (r0 == 0) goto L_0x0031
            r0 = 4
            goto L_0x0032
        L_0x0031:
            r0 = 2
        L_0x0032:
            r0 = r0 | r9
            goto L_0x0035
        L_0x0034:
            r0 = r9
        L_0x0035:
            r1 = r9 & 112(0x70, float:1.57E-43)
            if (r1 != 0) goto L_0x004e
            r1 = r24 & 2
            if (r1 != 0) goto L_0x0048
            r1 = r20
            boolean r2 = r6.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x004a
            r2 = 32
            goto L_0x004c
        L_0x0048:
            r1 = r20
        L_0x004a:
            r2 = 16
        L_0x004c:
            r0 = r0 | r2
            goto L_0x0050
        L_0x004e:
            r1 = r20
        L_0x0050:
            r2 = r24 & 4
            if (r2 == 0) goto L_0x0057
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0067
        L_0x0057:
            r2 = r9 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x0067
            boolean r2 = r6.changed((java.lang.Object) r8)
            if (r2 == 0) goto L_0x0064
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x0066
        L_0x0064:
            r2 = 128(0x80, float:1.794E-43)
        L_0x0066:
            r0 = r0 | r2
        L_0x0067:
            r2 = r0 & 731(0x2db, float:1.024E-42)
            r2 = r2 ^ 146(0x92, float:2.05E-43)
            if (r2 != 0) goto L_0x007b
            boolean r2 = r6.getSkipping()
            if (r2 != 0) goto L_0x0074
            goto L_0x007b
        L_0x0074:
            r6.skipToGroupEnd()
            r2 = r1
            r13 = r6
            goto L_0x017c
        L_0x007b:
            r6.startDefaults()
            r2 = r9 & 1
            if (r2 == 0) goto L_0x0091
            boolean r2 = r6.getDefaultsInvalid()
            if (r2 == 0) goto L_0x0089
            goto L_0x0091
        L_0x0089:
            r6.skipToGroupEnd()
            r2 = r24 & 2
            if (r2 == 0) goto L_0x00a2
            goto L_0x00a0
        L_0x0091:
            r2 = r24 & 2
            if (r2 == 0) goto L_0x00a2
            androidx.compose.ui.window.DialogProperties r1 = new androidx.compose.ui.window.DialogProperties
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 7
            r15 = 0
            r10 = r1
            r10.<init>(r11, r12, r13, r14, r15)
        L_0x00a0:
            r0 = r0 & -113(0xffffffffffffff8f, float:NaN)
        L_0x00a2:
            r5 = r1
            r6.endDefaults()
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalView()
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            r2 = 103361330(0x6292b32, float:3.1817102E-35)
            java.lang.String r3 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r2, r3)
            java.lang.Object r1 = r6.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            r4 = r1
            android.view.View r4 = (android.view.View) r4
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r2, r3)
            java.lang.Object r1 = r6.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            androidx.compose.ui.unit.Density r1 = (androidx.compose.ui.unit.Density) r1
            androidx.compose.runtime.ProvidableCompositionLocal r10 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r10 = (androidx.compose.runtime.CompositionLocal) r10
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r2, r3)
            java.lang.Object r2 = r6.consume(r10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            r3 = r2
            androidx.compose.ui.unit.LayoutDirection r3 = (androidx.compose.ui.unit.LayoutDirection) r3
            r2 = 0
            androidx.compose.runtime.CompositionContext r15 = androidx.compose.runtime.ComposablesKt.rememberCompositionContext(r6, r2)
            int r0 = r0 >> 6
            r0 = r0 & 14
            androidx.compose.runtime.State r0 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r8, r6, r0)
            java.lang.Object[] r10 = new java.lang.Object[r2]
            r11 = 0
            r12 = 0
            androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$dialogId$1 r13 = androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$dialogId$1.INSTANCE
            kotlin.jvm.functions.Function0 r13 = (kotlin.jvm.functions.Function0) r13
            r16 = 3080(0xc08, float:4.316E-42)
            r17 = 6
            r14 = r6
            r18 = r15
            r15 = r16
            r16 = r17
            java.lang.Object r10 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r10, r11, (java.lang.String) r12, r13, (androidx.compose.runtime.Composer) r14, (int) r15, (int) r16)
            java.util.UUID r10 = (java.util.UUID) r10
            r11 = -3686552(0xffffffffffc7bf68, float:NaN)
            r6.startReplaceableGroup(r11)
            java.lang.String r11 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r11)
            boolean r11 = r6.changed((java.lang.Object) r4)
            boolean r12 = r6.changed((java.lang.Object) r1)
            r11 = r11 | r12
            java.lang.Object r12 = r6.rememberedValue()
            if (r11 != 0) goto L_0x0130
            androidx.compose.runtime.Composer$Companion r11 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r11 = r11.getEmpty()
            if (r12 != r11) goto L_0x012c
            goto L_0x0130
        L_0x012c:
            r15 = r3
            r14 = r5
            r13 = r6
            goto L_0x015f
        L_0x0130:
            androidx.compose.ui.window.DialogWrapper r12 = new androidx.compose.ui.window.DialogWrapper
            java.lang.String r11 = "dialogId"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r11)
            r11 = r0
            r0 = r12
            r13 = r1
            r1 = r19
            r14 = 0
            r2 = r5
            r15 = r3
            r3 = r4
            r4 = r15
            r14 = r5
            r5 = r13
            r13 = r6
            r6 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r0 = -985536145(0xffffffffc541e96f, float:-3102.5896)
            androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$dialog$1$1$1 r1 = new androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$dialog$1$1$1
            r1.<init>(r11)
            r2 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambdaInstance(r0, r2, r1)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r18
            r12.setContent(r1, r0)
            r13.updateRememberedValue(r12)
        L_0x015f:
            r13.endReplaceableGroup()
            androidx.compose.ui.window.DialogWrapper r12 = (androidx.compose.ui.window.DialogWrapper) r12
            androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$1 r0 = new androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$1
            r0.<init>(r12)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r1 = 8
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r12, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r0, (androidx.compose.runtime.Composer) r13, (int) r1)
            androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$2 r0 = new androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$2
            r0.<init>(r12, r7, r14, r15)
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            r1 = 0
            androidx.compose.runtime.EffectsKt.SideEffect(r0, r13, r1)
            r2 = r14
        L_0x017c:
            androidx.compose.runtime.ScopeUpdateScope r6 = r13.endRestartGroup()
            if (r6 != 0) goto L_0x0183
            goto L_0x0196
        L_0x0183:
            androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$3 r10 = new androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$3
            r0 = r10
            r1 = r19
            r3 = r21
            r4 = r23
            r5 = r24
            r0.<init>(r1, r2, r3, r4, r5)
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r6.updateScope(r10)
        L_0x0196:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.window.AndroidDialog_androidKt.Dialog(kotlin.jvm.functions.Function0, androidx.compose.ui.window.DialogProperties, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final void DialogLayout(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i, int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(2018494685);
        ComposerKt.sourceInformation(startRestartGroup, "C(DialogLayout)P(1)399@14965L455:AndroidDialog.android.kt#2oxthz");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (startRestartGroup.changed((Object) modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= startRestartGroup.changed((Object) function2) ? 32 : 16;
        }
        if (((i3 & 91) ^ 18) != 0 || !startRestartGroup.getSkipping()) {
            if (i4 != 0) {
                modifier = Modifier.Companion;
            }
            MeasurePolicy measurePolicy = AndroidDialog_androidKt$DialogLayout$1.INSTANCE;
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
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier);
            int i5 = (((((i3 << 3) & 112) | ((i3 >> 3) & 14)) << 9) & 7168) | 6;
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
            Updater.m1241setimpl(r4, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1241setimpl(r4, density, ComposeUiNode.Companion.getSetDensity());
            Updater.m1241setimpl(r4, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1241setimpl(r4, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m1225boximpl(SkippableUpdater.m1226constructorimpl(startRestartGroup)), startRestartGroup, Integer.valueOf((i5 >> 3) & 112));
            startRestartGroup.startReplaceableGroup(2058660585);
            function2.invoke(startRestartGroup, Integer.valueOf((i5 >> 9) & 14));
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AndroidDialog_androidKt$DialogLayout$2(modifier, function2, i, i2));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: Dialog$lambda-0  reason: not valid java name */
    public static final Function2<Composer, Integer, Unit> m4101Dialog$lambda0(State<? extends Function2<? super Composer, ? super Integer, Unit>> state) {
        return (Function2) state.getValue();
    }
}
