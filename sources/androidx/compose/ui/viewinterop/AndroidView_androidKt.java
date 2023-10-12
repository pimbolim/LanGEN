package androidx.compose.ui.viewinterop;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aK\u0010\u0007\u001a\u00020\u0003\"\b\b\u0000\u0010\b*\u00020\u00022\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H\b0\u00012\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u00030\u0001H\u0007¢\u0006\u0002\u0010\u000e\"\"\u0010\u0000\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"NoOpUpdate", "Lkotlin/Function1;", "Landroid/view/View;", "", "Lkotlin/ExtensionFunctionType;", "getNoOpUpdate", "()Lkotlin/jvm/functions/Function1;", "AndroidView", "T", "factory", "Landroid/content/Context;", "modifier", "Landroidx/compose/ui/Modifier;", "update", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "ui_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: AndroidView.android.kt */
public final class AndroidView_androidKt {
    private static final Function1<View, Unit> NoOpUpdate = AndroidView_androidKt$NoOpUpdate$1.INSTANCE;

    /* JADX WARNING: Removed duplicated region for block: B:24:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01ed  */
    /* JADX WARNING: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T extends android.view.View> void AndroidView(kotlin.jvm.functions.Function1<? super android.content.Context, ? extends T> r17, androidx.compose.ui.Modifier r18, kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r19, androidx.compose.runtime.Composer r20, int r21, int r22) {
        /*
            r7 = r17
            r8 = r21
            java.lang.String r0 = "factory"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = -88762640(0xfffffffffab596f0, float:-4.7143355E35)
            r1 = r20
            androidx.compose.runtime.Composer r9 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(AndroidView)75@3513L7,81@3929L7,82@3984L7,83@4018L28,84@4098L7,85@4125L23,86@4191L40,92@4607L7,93@4678L7,95@4691L1301,123@6035L439:AndroidView.android.kt#z33iqn"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r0)
            r0 = r22 & 1
            if (r0 == 0) goto L_0x001e
            r0 = r8 | 6
            goto L_0x002e
        L_0x001e:
            r0 = r8 & 14
            if (r0 != 0) goto L_0x002d
            boolean r0 = r9.changed((java.lang.Object) r7)
            if (r0 == 0) goto L_0x002a
            r0 = 4
            goto L_0x002b
        L_0x002a:
            r0 = 2
        L_0x002b:
            r0 = r0 | r8
            goto L_0x002e
        L_0x002d:
            r0 = r8
        L_0x002e:
            r1 = r22 & 2
            if (r1 == 0) goto L_0x0035
            r0 = r0 | 48
            goto L_0x0048
        L_0x0035:
            r2 = r8 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0048
            r2 = r18
            boolean r3 = r9.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x0044
            r3 = 32
            goto L_0x0046
        L_0x0044:
            r3 = 16
        L_0x0046:
            r0 = r0 | r3
            goto L_0x004a
        L_0x0048:
            r2 = r18
        L_0x004a:
            r3 = r22 & 4
            if (r3 == 0) goto L_0x0051
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0064
        L_0x0051:
            r4 = r8 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0064
            r4 = r19
            boolean r5 = r9.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0060
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x0062
        L_0x0060:
            r5 = 128(0x80, float:1.794E-43)
        L_0x0062:
            r0 = r0 | r5
            goto L_0x0066
        L_0x0064:
            r4 = r19
        L_0x0066:
            r0 = r0 & 731(0x2db, float:1.024E-42)
            r0 = r0 ^ 146(0x92, float:2.05E-43)
            if (r0 != 0) goto L_0x0079
            boolean r0 = r9.getSkipping()
            if (r0 != 0) goto L_0x0073
            goto L_0x0079
        L_0x0073:
            r9.skipToGroupEnd()
            r3 = r4
            goto L_0x01e6
        L_0x0079:
            if (r1 == 0) goto L_0x0081
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r10 = r0
            goto L_0x0082
        L_0x0081:
            r10 = r2
        L_0x0082:
            if (r3 == 0) goto L_0x0088
            kotlin.jvm.functions.Function1<android.view.View, kotlin.Unit> r0 = NoOpUpdate
            r11 = r0
            goto L_0x0089
        L_0x0088:
            r11 = r4
        L_0x0089:
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalContext()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 103361330(0x6292b32, float:3.1817102E-35)
            java.lang.String r2 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r1, r2)
            java.lang.Object r0 = r9.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r3 = r0
            android.content.Context r3 = (android.content.Context) r3
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$modifierWithSemantics$1 r0 = androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$modifierWithSemantics$1.INSTANCE
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r4 = 1
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics(r10, r4, r0)
            androidx.compose.ui.Modifier r12 = androidx.compose.ui.ComposedModifierKt.materialize(r9, r0)
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r1, r2)
            java.lang.Object r0 = r9.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r13 = r0
            androidx.compose.ui.unit.Density r13 = (androidx.compose.ui.unit.Density) r13
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r1, r2)
            java.lang.Object r0 = r9.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r14 = r0
            androidx.compose.ui.unit.LayoutDirection r14 = (androidx.compose.ui.unit.LayoutDirection) r14
            r0 = 0
            androidx.compose.runtime.CompositionContext r4 = androidx.compose.runtime.ComposablesKt.rememberCompositionContext(r9, r0)
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.runtime.saveable.SaveableStateRegistryKt.getLocalSaveableStateRegistry()
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r1, r2)
            java.lang.Object r5 = r9.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r15 = r5
            androidx.compose.runtime.saveable.SaveableStateRegistry r15 = (androidx.compose.runtime.saveable.SaveableStateRegistry) r15
            int r0 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r9, r0)
            java.lang.String r6 = java.lang.String.valueOf(r0)
            r0 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r9.startReplaceableGroup(r0)
            java.lang.String r0 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r0)
            java.lang.Object r0 = r9.rememberedValue()
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r0 != r5) goto L_0x0113
            androidx.compose.ui.node.Ref r0 = new androidx.compose.ui.node.Ref
            r0.<init>()
            r9.updateRememberedValue(r0)
        L_0x0113:
            r9.endReplaceableGroup()
            r5 = r0
            androidx.compose.ui.node.Ref r5 = (androidx.compose.ui.node.Ref) r5
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalLifecycleOwner()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r1, r2)
            java.lang.Object r0 = r9.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            androidx.lifecycle.LifecycleOwner r0 = (androidx.lifecycle.LifecycleOwner) r0
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner()
            r18 = r0
            r0 = r16
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r1, r2)
            java.lang.Object r0 = r9.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r2 = r0
            androidx.savedstate.SavedStateRegistryOwner r2 = (androidx.savedstate.SavedStateRegistryOwner) r2
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$1 r16 = new androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$1
            r1 = r18
            r0 = r16
            r7 = r1
            r1 = r3
            r3 = r2
            r2 = r4
            r4 = r3
            r3 = r17
            r8 = r4
            r4 = r15
            r18 = r5
            r5 = r6
            r20 = r10
            r10 = r6
            r6 = r18
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r0 = r16
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            r1 = -2103250935(0xffffffff82a2f009, float:-2.3941534E-37)
            r9.startReplaceableGroup(r1)
            java.lang.String r1 = "C(ComposeNode):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r1)
            androidx.compose.runtime.Applier r1 = r9.getApplier()
            boolean r1 = r1 instanceof androidx.compose.ui.node.UiApplier
            if (r1 != 0) goto L_0x0176
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0176:
            r9.startNode()
            boolean r1 = r9.getInserting()
            if (r1 == 0) goto L_0x018a
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1 r1 = new androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1
            r1.<init>(r0)
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            r9.createNode(r1)
            goto L_0x018d
        L_0x018a:
            r9.useNode()
        L_0x018d:
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.Updater.m1234constructorimpl(r9)
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$1 r1 = new androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$1
            r2 = r18
            r1.<init>(r2)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r0, r12, r1)
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$2 r1 = new androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$2
            r1.<init>(r2)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r0, r13, r1)
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$3 r1 = new androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$3
            r1.<init>(r2)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r0, r7, r1)
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$4 r1 = new androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$4
            r1.<init>(r2)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r0, r8, r1)
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$5 r1 = new androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$5
            r1.<init>(r2)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r0, r11, r1)
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$6 r1 = new androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$6
            r1.<init>(r2)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r0, r14, r1)
            r9.endNode()
            r9.endReplaceableGroup()
            if (r15 == 0) goto L_0x01e3
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$3 r0 = new androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$3
            r0.<init>(r15, r10, r2)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r1 = 8
            androidx.compose.runtime.EffectsKt.DisposableEffect(r15, r10, r0, r9, r1)
        L_0x01e3:
            r2 = r20
            r3 = r11
        L_0x01e6:
            androidx.compose.runtime.ScopeUpdateScope r6 = r9.endRestartGroup()
            if (r6 != 0) goto L_0x01ed
            goto L_0x01fe
        L_0x01ed:
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$4 r7 = new androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$4
            r0 = r7
            r1 = r17
            r4 = r21
            r5 = r22
            r0.<init>(r1, r2, r3, r4, r5)
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r6.updateScope(r7)
        L_0x01fe:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.viewinterop.AndroidView_androidKt.AndroidView(kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final Function1<View, Unit> getNoOpUpdate() {
        return NoOpUpdate;
    }
}
