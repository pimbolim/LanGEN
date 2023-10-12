package androidx.compose.ui.layout;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.MeasureBlocks;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a6\u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\bø\u0001\u0000¢\u0006\u0002\u0010\t\u001a\u0002\u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042-\u0010\n\u001a)\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000bj\u0002`\u0010¢\u0006\u0002\b\u00112-\u0010\u0012\u001a)\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000bj\u0002`\u0010¢\u0006\u0002\b\u00112-\u0010\u0013\u001a)\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000bj\u0002`\u0010¢\u0006\u0002\b\u00112-\u0010\u0014\u001a)\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000bj\u0002`\u0010¢\u0006\u0002\b\u00112\b\b\u0002\u0010\u0005\u001a\u00020\u00062-\u0010\u0015\u001a)\u0012\u0004\u0012\u00020\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\r\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u000bj\u0002`\u001a¢\u0006\u0002\b\u0011H\u0001ø\u0001\u0001¢\u0006\u0002\u0010\u001b\u001a \u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\b¢\u0006\u0002\u0010\u001c\u001a:\u0010\u001d\u001a\u00020\u001e2-\u0010\u0015\u001a)\u0012\u0004\u0012\u00020\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\r\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u000bj\u0002`\u001a¢\u0006\u0002\b\u0011H\u0001ø\u0001\u0001\u001a2\u0010\u001f\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010 \u001a4\u0010!\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#\u0012\u0004\u0012\u00020\u00010\"¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u00112\u0006\u0010\u0005\u001a\u00020\u0006H\u0001ø\u0001\u0001¢\u0006\u0002\u0010%\u001aö\u0001\u0010&\u001a\u00020\u001e2-\u0010\n\u001a)\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000bj\u0002`\u0010¢\u0006\u0002\b\u00112-\u0010\u0012\u001a)\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000bj\u0002`\u0010¢\u0006\u0002\b\u00112-\u0010\u0013\u001a)\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000bj\u0002`\u0010¢\u0006\u0002\b\u00112-\u0010\u0014\u001a)\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000bj\u0002`\u0010¢\u0006\u0002\b\u00112-\u0010\u0015\u001a)\u0012\u0004\u0012\u00020\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\r\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u000bj\u0002`\u001a¢\u0006\u0002\b\u0011H\u0001ø\u0001\u0001\u001aX\u0010'\u001a\u00020\u000f*\u00020(2)\u0010\u0015\u001a%\u0012\u0004\u0012\u00020\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\r\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u000b¢\u0006\u0002\b\u00112\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010*\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020,H\u0002ø\u0001\u0001\u001aX\u0010-\u001a\u00020\u000f*\u00020(2)\u0010\u0015\u001a%\u0012\u0004\u0012\u00020\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\r\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u000b¢\u0006\u0002\b\u00112\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010.\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020,H\u0002ø\u0001\u0001\u001aX\u0010/\u001a\u00020\u000f*\u00020(2)\u0010\u0015\u001a%\u0012\u0004\u0012\u00020\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\r\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u000b¢\u0006\u0002\b\u00112\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010*\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020,H\u0002ø\u0001\u0001\u001aX\u00100\u001a\u00020\u000f*\u00020(2)\u0010\u0015\u001a%\u0012\u0004\u0012\u00020\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\r\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u000b¢\u0006\u0002\b\u00112\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010.\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020,H\u0002ø\u0001\u0001\u0002\u000b\n\u0005\b20\u0001\n\u0002\b\u0019¨\u00061"}, d2 = {"Layout", "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "measurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/MeasurePolicy;Landroidx/compose/runtime/Composer;II)V", "minIntrinsicWidthMeasureBlock", "Lkotlin/Function3;", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "", "Landroidx/compose/ui/layout/IntrinsicMeasureBlock;", "Lkotlin/ExtensionFunctionType;", "minIntrinsicHeightMeasureBlock", "maxIntrinsicWidthMeasureBlock", "maxIntrinsicHeightMeasureBlock", "measureBlock", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureBlock;", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/MeasurePolicy;Landroidx/compose/runtime/Composer;II)V", "MeasuringIntrinsicsMeasureBlocks", "Landroidx/compose/ui/node/MeasureBlocks;", "MultiMeasureLayout", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/layout/MeasurePolicy;Landroidx/compose/runtime/Composer;II)V", "materializerOf", "Lkotlin/Function1;", "Landroidx/compose/runtime/SkippableUpdater;", "Landroidx/compose/ui/node/ComposeUiNode;", "(Landroidx/compose/ui/Modifier;)Lkotlin/jvm/functions/Function3;", "measureBlocksOf", "MeasuringMaxIntrinsicHeight", "Landroidx/compose/ui/unit/Density;", "measurables", "w", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "MeasuringMaxIntrinsicWidth", "h", "MeasuringMinIntrinsicHeight", "MeasuringMinIntrinsicWidth", "ui_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Layout.kt */
public final class LayoutKt {
    public static final void Layout(Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, MeasurePolicy measurePolicy, Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(function2, "content");
        Intrinsics.checkNotNullParameter(measurePolicy, "measurePolicy");
        composer.startReplaceableGroup(1376089394);
        ComposerKt.sourceInformation(composer, "C(Layout)P(!1,2)72@2847L7,73@2902L7,74@2961L7,75@2973L460:Layout.kt#80mrfh");
        if ((i2 & 2) != 0) {
            modifier = Modifier.Companion;
        }
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
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = materializerOf(modifier);
        int i3 = ((i << 9) & 7168) | 6;
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
        Composer r1 = Updater.m1234constructorimpl(composer);
        Updater.m1241setimpl(r1, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m1241setimpl(r1, density, ComposeUiNode.Companion.getSetDensity());
        Updater.m1241setimpl(r1, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
        Updater.m1241setimpl(r1, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
        composer.enableReusing();
        materializerOf.invoke(SkippableUpdater.m1225boximpl(SkippableUpdater.m1226constructorimpl(composer)), composer, Integer.valueOf((i3 >> 3) & 112));
        composer.startReplaceableGroup(2058660585);
        function2.invoke(composer, Integer.valueOf((i3 >> 9) & 14));
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
    }

    public static final void Layout(Modifier modifier, MeasurePolicy measurePolicy, Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(measurePolicy, "measurePolicy");
        composer.startReplaceableGroup(1376091099);
        ComposerKt.sourceInformation(composer, "C(Layout)P(1)116@4515L7,117@4570L7,118@4629L7,120@4702L439:Layout.kt#80mrfh");
        if ((i2 & 1) != 0) {
            modifier = Modifier.Companion;
        }
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
        Modifier materialize = ComposedModifierKt.materialize(composer, modifier);
        Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
        composer.startReplaceableGroup(1546164872);
        ComposerKt.sourceInformation(composer, "C(ReusableComposeNode):Composables.kt#9igjgp");
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(new LayoutKt$Layout$$inlined$ReusableComposeNode$1(constructor));
        } else {
            composer.useNode();
        }
        composer.disableReusing();
        Composer r0 = Updater.m1234constructorimpl(composer);
        Updater.m1241setimpl(r0, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m1241setimpl(r0, density, ComposeUiNode.Companion.getSetDensity());
        Updater.m1241setimpl(r0, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
        Updater.m1241setimpl(r0, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
        Updater.m1241setimpl(r0, materialize, ComposeUiNode.Companion.getSetModifier());
        composer.enableReusing();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }

    /* JADX WARNING: Removed duplicated region for block: B:64:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01f7  */
    /* JADX WARNING: Removed duplicated region for block: B:92:? A[RETURN, SYNTHETIC] */
    @kotlin.Deprecated(message = "This composable was deprecated. Please use the alternative Layout overloads instead.")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Layout(kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r17, kotlin.jvm.functions.Function3<? super androidx.compose.ui.layout.IntrinsicMeasureScope, ? super java.util.List<? extends androidx.compose.ui.layout.IntrinsicMeasurable>, ? super java.lang.Integer, java.lang.Integer> r18, kotlin.jvm.functions.Function3<? super androidx.compose.ui.layout.IntrinsicMeasureScope, ? super java.util.List<? extends androidx.compose.ui.layout.IntrinsicMeasurable>, ? super java.lang.Integer, java.lang.Integer> r19, kotlin.jvm.functions.Function3<? super androidx.compose.ui.layout.IntrinsicMeasureScope, ? super java.util.List<? extends androidx.compose.ui.layout.IntrinsicMeasurable>, ? super java.lang.Integer, java.lang.Integer> r20, kotlin.jvm.functions.Function3<? super androidx.compose.ui.layout.IntrinsicMeasureScope, ? super java.util.List<? extends androidx.compose.ui.layout.IntrinsicMeasurable>, ? super java.lang.Integer, java.lang.Integer> r21, androidx.compose.ui.Modifier r22, kotlin.jvm.functions.Function3<? super androidx.compose.ui.layout.MeasureScope, ? super java.util.List<? extends androidx.compose.ui.layout.Measurable>, ? super androidx.compose.ui.unit.Constraints, ? extends androidx.compose.ui.layout.MeasureResult> r23, androidx.compose.runtime.Composer r24, int r25, int r26) {
        /*
            r1 = r17
            r8 = r18
            r9 = r19
            r10 = r20
            r11 = r21
            r12 = r23
            r13 = r25
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "minIntrinsicWidthMeasureBlock"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "minIntrinsicHeightMeasureBlock"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "maxIntrinsicWidthMeasureBlock"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "maxIntrinsicHeightMeasureBlock"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "measureBlock"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = 1376092018(0x52057f72, float:1.43342207E11)
            r2 = r24
            androidx.compose.runtime.Composer r0 = r2.startRestartGroup(r0)
            java.lang.String r2 = "C(Layout)P(!1,5,4,2!1,6)173@6744L40:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r2)
            r2 = r26 & 1
            if (r2 == 0) goto L_0x0041
            r2 = r13 | 6
            goto L_0x0051
        L_0x0041:
            r2 = r13 & 14
            if (r2 != 0) goto L_0x0050
            boolean r2 = r0.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x004d
            r2 = 4
            goto L_0x004e
        L_0x004d:
            r2 = 2
        L_0x004e:
            r2 = r2 | r13
            goto L_0x0051
        L_0x0050:
            r2 = r13
        L_0x0051:
            r3 = r26 & 2
            if (r3 == 0) goto L_0x0058
            r2 = r2 | 48
            goto L_0x0068
        L_0x0058:
            r3 = r13 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0068
            boolean r3 = r0.changed((java.lang.Object) r8)
            if (r3 == 0) goto L_0x0065
            r3 = 32
            goto L_0x0067
        L_0x0065:
            r3 = 16
        L_0x0067:
            r2 = r2 | r3
        L_0x0068:
            r3 = r26 & 4
            if (r3 == 0) goto L_0x006f
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x007f
        L_0x006f:
            r3 = r13 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x007f
            boolean r3 = r0.changed((java.lang.Object) r9)
            if (r3 == 0) goto L_0x007c
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x007e
        L_0x007c:
            r3 = 128(0x80, float:1.794E-43)
        L_0x007e:
            r2 = r2 | r3
        L_0x007f:
            r3 = r26 & 8
            if (r3 == 0) goto L_0x0086
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x0096
        L_0x0086:
            r3 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r3 != 0) goto L_0x0096
            boolean r3 = r0.changed((java.lang.Object) r10)
            if (r3 == 0) goto L_0x0093
            r3 = 2048(0x800, float:2.87E-42)
            goto L_0x0095
        L_0x0093:
            r3 = 1024(0x400, float:1.435E-42)
        L_0x0095:
            r2 = r2 | r3
        L_0x0096:
            r3 = r26 & 16
            if (r3 == 0) goto L_0x009d
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00af
        L_0x009d:
            r3 = 57344(0xe000, float:8.0356E-41)
            r3 = r3 & r13
            if (r3 != 0) goto L_0x00af
            boolean r3 = r0.changed((java.lang.Object) r11)
            if (r3 == 0) goto L_0x00ac
            r3 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00ae
        L_0x00ac:
            r3 = 8192(0x2000, float:1.14794E-41)
        L_0x00ae:
            r2 = r2 | r3
        L_0x00af:
            r3 = r26 & 32
            if (r3 == 0) goto L_0x00b7
            r4 = 196608(0x30000, float:2.75506E-40)
            r2 = r2 | r4
            goto L_0x00cb
        L_0x00b7:
            r4 = 458752(0x70000, float:6.42848E-40)
            r4 = r4 & r13
            if (r4 != 0) goto L_0x00cb
            r4 = r22
            boolean r5 = r0.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x00c7
            r5 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c9
        L_0x00c7:
            r5 = 65536(0x10000, float:9.18355E-41)
        L_0x00c9:
            r2 = r2 | r5
            goto L_0x00cd
        L_0x00cb:
            r4 = r22
        L_0x00cd:
            r5 = r26 & 64
            if (r5 == 0) goto L_0x00d5
            r5 = 1572864(0x180000, float:2.204052E-39)
        L_0x00d3:
            r2 = r2 | r5
            goto L_0x00e6
        L_0x00d5:
            r5 = 3670016(0x380000, float:5.142788E-39)
            r5 = r5 & r13
            if (r5 != 0) goto L_0x00e6
            boolean r5 = r0.changed((java.lang.Object) r12)
            if (r5 == 0) goto L_0x00e3
            r5 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d3
        L_0x00e3:
            r5 = 524288(0x80000, float:7.34684E-40)
            goto L_0x00d3
        L_0x00e6:
            r14 = r2
            r2 = 2995931(0x2db6db, float:4.198194E-39)
            r2 = r2 & r14
            r5 = 599186(0x92492, float:8.39638E-40)
            r2 = r2 ^ r5
            if (r2 != 0) goto L_0x00fe
            boolean r2 = r0.getSkipping()
            if (r2 != 0) goto L_0x00f8
            goto L_0x00fe
        L_0x00f8:
            r0.skipToGroupEnd()
            r6 = r4
            goto L_0x01f0
        L_0x00fe:
            if (r3 == 0) goto L_0x0106
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            r15 = r2
            goto L_0x0107
        L_0x0106:
            r15 = r4
        L_0x0107:
            androidx.compose.ui.layout.LayoutKt$Layout$measurePolicy$1 r16 = new androidx.compose.ui.layout.LayoutKt$Layout$measurePolicy$1
            r2 = r16
            r3 = r23
            r4 = r18
            r5 = r19
            r6 = r20
            r7 = r21
            r2.<init>(r3, r4, r5, r6, r7)
            r2 = r14 & 14
            int r3 = r14 >> 12
            r3 = r3 & 112(0x70, float:1.57E-43)
            r2 = r2 | r3
            r3 = 1376089394(0x52057532, float:1.43299215E11)
            r0.startReplaceableGroup(r3)
            java.lang.String r3 = "C(Layout)P(!1,2)72@2847L7,73@2902L7,74@2961L7,75@2973L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r3)
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r4 = 103361330(0x6292b32, float:3.1817102E-35)
            java.lang.String r5 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r4, r5)
            java.lang.Object r3 = r0.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.Density r3 = (androidx.compose.ui.unit.Density) r3
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r4, r5)
            java.lang.Object r6 = r0.consume(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.LayoutDirection r6 = (androidx.compose.ui.unit.LayoutDirection) r6
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r4, r5)
            java.lang.Object r4 = r0.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.platform.ViewConfiguration r4 = (androidx.compose.ui.platform.ViewConfiguration) r4
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r5 = r5.getConstructor()
            kotlin.jvm.functions.Function3 r7 = materializerOf(r15)
            int r2 = r2 << 9
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | 6
            androidx.compose.runtime.Applier r14 = r0.getApplier()
            boolean r14 = r14 instanceof androidx.compose.runtime.Applier
            if (r14 != 0) goto L_0x0180
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0180:
            r0.startReusableNode()
            boolean r14 = r0.getInserting()
            if (r14 == 0) goto L_0x018d
            r0.createNode(r5)
            goto L_0x0190
        L_0x018d:
            r0.useNode()
        L_0x0190:
            r0.disableReusing()
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.Updater.m1234constructorimpl(r0)
            r14 = r16
            androidx.compose.ui.layout.MeasurePolicy r14 = (androidx.compose.ui.layout.MeasurePolicy) r14
            androidx.compose.ui.node.ComposeUiNode$Companion r16 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r16.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r5, r14, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetDensity()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r5, r3, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r5, r6, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r5, r4, r3)
            r0.enableReusing()
            androidx.compose.runtime.Composer r3 = androidx.compose.runtime.SkippableUpdater.m1226constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r3 = androidx.compose.runtime.SkippableUpdater.m1225boximpl(r3)
            int r4 = r2 >> 3
            r4 = r4 & 112(0x70, float:1.57E-43)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r7.invoke(r3, r0, r4)
            r3 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r3)
            int r2 = r2 >> 9
            r2 = r2 & 14
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.invoke(r0, r2)
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r6 = r15
        L_0x01f0:
            androidx.compose.runtime.ScopeUpdateScope r14 = r0.endRestartGroup()
            if (r14 != 0) goto L_0x01f7
            goto L_0x0212
        L_0x01f7:
            androidx.compose.ui.layout.LayoutKt$Layout$3 r15 = new androidx.compose.ui.layout.LayoutKt$Layout$3
            r0 = r15
            r1 = r17
            r2 = r18
            r3 = r19
            r4 = r20
            r5 = r21
            r7 = r23
            r8 = r25
            r9 = r26
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r15 = (kotlin.jvm.functions.Function2) r15
            r14.updateScope(r15)
        L_0x0212:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.layout.LayoutKt.Layout(kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    @Deprecated(message = "MeasureBlocks was deprecated. Please use MeasurePolicy and the Layout overloads using it instead.")
    public static final MeasureBlocks measureBlocksOf(Function3<? super IntrinsicMeasureScope, ? super List<? extends IntrinsicMeasurable>, ? super Integer, Integer> function3, Function3<? super IntrinsicMeasureScope, ? super List<? extends IntrinsicMeasurable>, ? super Integer, Integer> function32, Function3<? super IntrinsicMeasureScope, ? super List<? extends IntrinsicMeasurable>, ? super Integer, Integer> function33, Function3<? super IntrinsicMeasureScope, ? super List<? extends IntrinsicMeasurable>, ? super Integer, Integer> function34, Function3<? super MeasureScope, ? super List<? extends Measurable>, ? super Constraints, ? extends MeasureResult> function35) {
        Intrinsics.checkNotNullParameter(function3, "minIntrinsicWidthMeasureBlock");
        Intrinsics.checkNotNullParameter(function32, "minIntrinsicHeightMeasureBlock");
        Intrinsics.checkNotNullParameter(function33, "maxIntrinsicWidthMeasureBlock");
        Intrinsics.checkNotNullParameter(function34, "maxIntrinsicHeightMeasureBlock");
        Intrinsics.checkNotNullParameter(function35, "measureBlock");
        return new LayoutKt$measureBlocksOf$1(function35, function3, function32, function33, function34);
    }

    public static final Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf(Modifier modifier) {
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        return ComposableLambdaKt.composableLambdaInstance(-985542424, true, new LayoutKt$materializerOf$1(modifier));
    }

    @Deprecated(message = "This API is unsafe for UI performance at scale - using it incorrectly will lead to exponential performance issues. This API should be avoided whenever possible.")
    public static final void MultiMeasureLayout(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, MeasurePolicy measurePolicy, Composer composer, int i, int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(function2, "content");
        Intrinsics.checkNotNullParameter(measurePolicy, "measurePolicy");
        Composer startRestartGroup = composer.startRestartGroup(-850547527);
        ComposerKt.sourceInformation(startRestartGroup, "C(MultiMeasureLayout)P(2)238@9236L7,239@9291L7,240@9350L7,242@9363L545:Layout.kt#80mrfh");
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
        if ((i2 & 4) != 0) {
            i3 |= BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT;
        } else if ((i & 896) == 0) {
            i3 |= startRestartGroup.changed((Object) measurePolicy) ? 256 : 128;
        }
        if (((i3 & 731) ^ 146) != 0 || !startRestartGroup.getSkipping()) {
            if (i4 != 0) {
                modifier = Modifier.Companion;
            }
            Modifier materialize = ComposedModifierKt.materialize(startRestartGroup, modifier);
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
            Function0<LayoutNode> constructor$ui_release = LayoutNode.Companion.getConstructor$ui_release();
            int i5 = ((i3 << 3) & 896) | 6;
            startRestartGroup.startReplaceableGroup(1546167803);
            ComposerKt.sourceInformation(startRestartGroup, "C(ReusableComposeNode)P(1,2)347@12680L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor$ui_release);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer r4 = Updater.m1234constructorimpl(startRestartGroup);
            Updater.m1241setimpl(r4, materialize, ComposeUiNode.Companion.getSetModifier());
            Updater.m1241setimpl(r4, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1241setimpl(r4, density, ComposeUiNode.Companion.getSetDensity());
            Updater.m1241setimpl(r4, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1241setimpl(r4, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
            Updater.m1238initimpl(r4, LayoutKt$MultiMeasureLayout$1$1.INSTANCE);
            startRestartGroup.enableReusing();
            function2.invoke(startRestartGroup, Integer.valueOf((i5 >> 6) & 14));
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        Modifier modifier2 = modifier;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new LayoutKt$MultiMeasureLayout$2(modifier2, function2, measurePolicy, i, i2));
        }
    }

    @Deprecated(message = "MeasuringIntrinsicsMeasureBlocks was deprecated. Please use MeasurePolicy instead.")
    public static final MeasureBlocks MeasuringIntrinsicsMeasureBlocks(Function3<? super MeasureScope, ? super List<? extends Measurable>, ? super Constraints, ? extends MeasureResult> function3) {
        Intrinsics.checkNotNullParameter(function3, "measureBlock");
        return new LayoutKt$MeasuringIntrinsicsMeasureBlocks$1(function3);
    }

    /* access modifiers changed from: private */
    public static final int MeasuringMinIntrinsicWidth(Density density, Function3<? super MeasureScope, ? super List<? extends Measurable>, ? super Constraints, ? extends MeasureResult> function3, List<? extends IntrinsicMeasurable> list, int i, LayoutDirection layoutDirection) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(new DefaultIntrinsicMeasurable((IntrinsicMeasurable) list.get(i2), IntrinsicMinMax.Min, IntrinsicWidthHeight.Width));
        }
        long Constraints$default = ConstraintsKt.Constraints$default(0, 0, 0, i, 7, (Object) null);
        return ((MeasureResult) function3.invoke(new IntrinsicsMeasureScope(density, layoutDirection), arrayList, Constraints.m3791boximpl(Constraints$default))).getWidth();
    }

    /* access modifiers changed from: private */
    public static final int MeasuringMinIntrinsicHeight(Density density, Function3<? super MeasureScope, ? super List<? extends Measurable>, ? super Constraints, ? extends MeasureResult> function3, List<? extends IntrinsicMeasurable> list, int i, LayoutDirection layoutDirection) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(new DefaultIntrinsicMeasurable((IntrinsicMeasurable) list.get(i2), IntrinsicMinMax.Min, IntrinsicWidthHeight.Height));
        }
        long Constraints$default = ConstraintsKt.Constraints$default(0, i, 0, 0, 13, (Object) null);
        return ((MeasureResult) function3.invoke(new IntrinsicsMeasureScope(density, layoutDirection), arrayList, Constraints.m3791boximpl(Constraints$default))).getHeight();
    }

    /* access modifiers changed from: private */
    public static final int MeasuringMaxIntrinsicWidth(Density density, Function3<? super MeasureScope, ? super List<? extends Measurable>, ? super Constraints, ? extends MeasureResult> function3, List<? extends IntrinsicMeasurable> list, int i, LayoutDirection layoutDirection) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(new DefaultIntrinsicMeasurable((IntrinsicMeasurable) list.get(i2), IntrinsicMinMax.Max, IntrinsicWidthHeight.Width));
        }
        long Constraints$default = ConstraintsKt.Constraints$default(0, 0, 0, i, 7, (Object) null);
        return ((MeasureResult) function3.invoke(new IntrinsicsMeasureScope(density, layoutDirection), arrayList, Constraints.m3791boximpl(Constraints$default))).getWidth();
    }

    /* access modifiers changed from: private */
    public static final int MeasuringMaxIntrinsicHeight(Density density, Function3<? super MeasureScope, ? super List<? extends Measurable>, ? super Constraints, ? extends MeasureResult> function3, List<? extends IntrinsicMeasurable> list, int i, LayoutDirection layoutDirection) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(new DefaultIntrinsicMeasurable((IntrinsicMeasurable) list.get(i2), IntrinsicMinMax.Max, IntrinsicWidthHeight.Height));
        }
        long Constraints$default = ConstraintsKt.Constraints$default(0, i, 0, 0, 13, (Object) null);
        return ((MeasureResult) function3.invoke(new IntrinsicsMeasureScope(density, layoutDirection), arrayList, Constraints.m3791boximpl(Constraints$default))).getHeight();
    }
}
