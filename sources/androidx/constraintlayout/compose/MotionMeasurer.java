package androidx.constraintlayout.compose;

import android.graphics.Matrix;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.constraintlayout.core.state.Transition;
import androidx.constraintlayout.core.state.WidgetFrame;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.facebook.react.uimanager.ViewProps;
import com.stripe.android.stripe3ds2.transactions.MessageExtension;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\b\u0010\u000b\u001a\u00020\nH\u0016J4\u0010\f\u001a\u00020\n2\n\u0010\r\u001a\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0012\u0010\u0017\u001a\u00020\n2\n\u0010\r\u001a\u00060\u000ej\u0002`\u000fJ&\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0016\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bJ\u0006\u0010 \u001a\u00020\u0004J(\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#2\b\u0010\u0005\u001a\u0004\u0018\u00010%2\u0006\u0010\u0014\u001a\u00020\u0004J;\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u00162\u0006\u0010(\u001a\u00020#2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*2\u0006\u0010,\u001a\u00020-H\u0002ø\u0001\u0000ø\u0001\u0002¢\u0006\u0004\b.\u0010/Jc\u00100\u001a\u0002012\u0006\u0010,\u001a\u00020-2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020#2\u0006\u00105\u001a\u00020#2\b\u0010\u0005\u001a\u0004\u0018\u00010%2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*2\u0006\u0010'\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u00106\u001a\u000207ø\u0001\u0000ø\u0001\u0002¢\u0006\u0004\b8\u00109J\u0011\u0010:\u001a\u00020\n*\u00020;H\u0007¢\u0006\u0002\u0010<J1\u0010=\u001a\u00020\n*\u00020>2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u0019H\u0002ø\u0001\u0000ø\u0001\u0002¢\u0006\u0004\bD\u0010EJI\u0010F\u001a\u00020\n*\u00020>2\u0006\u0010G\u001a\u00020\u00042\u0006\u0010H\u001a\u00020\u00042\u0006\u0010I\u001a\u00020@2\u0006\u0010J\u001a\u00020@2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u0019H\u0002ø\u0001\u0000ø\u0001\u0002¢\u0006\u0004\bK\u0010LR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006M"}, d2 = {"Landroidx/constraintlayout/compose/MotionMeasurer;", "Landroidx/constraintlayout/compose/Measurer;", "()V", "motionProgress", "", "transition", "Landroidx/constraintlayout/core/state/Transition;", "getTransition", "()Landroidx/constraintlayout/core/state/Transition;", "clearConstraintSets", "", "computeLayoutResult", "encodeKeyFrames", "json", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "location", "", "types", "", "progress", "count", "", "encodeRoot", "getCustomColor", "Landroidx/compose/ui/graphics/Color;", "id", "", "name", "getCustomColor-WaAFU9c", "(Ljava/lang/String;Ljava/lang/String;)J", "getCustomFloat", "getProgress", "initWith", "start", "Landroidx/constraintlayout/compose/ConstraintSet;", "end", "Landroidx/constraintlayout/compose/Transition;", "measureConstraintSet", "optimizationLevel", "constraintSet", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measureConstraintSet--hBUhpc", "(ILandroidx/constraintlayout/compose/ConstraintSet;Ljava/util/List;J)V", "performInterpolationMeasure", "Landroidx/compose/ui/unit/IntSize;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "constraintSetStart", "constraintSetEnd", "measureScope", "Landroidx/compose/ui/layout/MeasureScope;", "performInterpolationMeasure-OQbXsTc", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/constraintlayout/compose/ConstraintSet;Landroidx/constraintlayout/compose/ConstraintSet;Landroidx/constraintlayout/compose/Transition;Ljava/util/List;IFLandroidx/compose/ui/layout/MeasureScope;)J", "drawDebug", "Landroidx/compose/foundation/layout/BoxScope;", "(Landroidx/compose/foundation/layout/BoxScope;Landroidx/compose/runtime/Composer;I)V", "drawFrame", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "frame", "Landroidx/constraintlayout/core/state/WidgetFrame;", "pathEffect", "Landroidx/compose/ui/graphics/PathEffect;", "color", "drawFrame-g2O1Hgs", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/constraintlayout/core/state/WidgetFrame;Landroidx/compose/ui/graphics/PathEffect;J)V", "drawFrameDebug", "parentWidth", "parentHeight", "startFrame", "endFrame", "drawFrameDebug-PE3pjmc", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFLandroidx/constraintlayout/core/state/WidgetFrame;Landroidx/constraintlayout/core/state/WidgetFrame;Landroidx/compose/ui/graphics/PathEffect;J)V", "compose_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: MotionLayout.kt */
public final class MotionMeasurer extends Measurer {
    private float motionProgress;
    private final Transition transition = new Transition();

    public final Transition getTransition() {
        return this.transition;
    }

    public final float getProgress() {
        return this.motionProgress;
    }

    /* renamed from: measureConstraintSet--hBUhpc  reason: not valid java name */
    private final void m4208measureConstraintSethBUhpc(int i, ConstraintSet constraintSet, List<? extends Measurable> list, long j) {
        Object obj;
        String str;
        String obj2;
        getState().reset();
        constraintSet.applyTo(getState(), list);
        getState().apply(getRoot());
        m4178applyRootSizeBRTryo0(j);
        getRoot().updateHierarchy();
        if (MotionLayoutKt.DEBUG) {
            getRoot().setDebugName("ConstraintLayout");
            ArrayList<ConstraintWidget> children = getRoot().getChildren();
            Intrinsics.checkNotNullExpressionValue(children, "root.children");
            for (ConstraintWidget constraintWidget : children) {
                Object companionWidget = constraintWidget.getCompanionWidget();
                Measurable measurable = companionWidget instanceof Measurable ? (Measurable) companionWidget : null;
                Object layoutId = measurable == null ? null : LayoutIdKt.getLayoutId(measurable);
                String str2 = "NOTAG";
                if (!(layoutId == null || (obj2 = layoutId.toString()) == null)) {
                    str2 = obj2;
                }
                constraintWidget.setDebugName(str2);
            }
        }
        ArrayList<ConstraintWidget> children2 = getRoot().getChildren();
        Intrinsics.checkNotNullExpressionValue(children2, "root.children");
        for (ConstraintWidget constraintWidget2 : children2) {
            Object companionWidget2 = constraintWidget2.getCompanionWidget();
            Measurable measurable2 = companionWidget2 instanceof Measurable ? (Measurable) companionWidget2 : null;
            if (measurable2 == null) {
                obj = null;
            } else {
                obj = LayoutIdKt.getLayoutId(measurable2);
            }
            if (obj == null) {
                obj = measurable2 == null ? null : ConstraintLayoutTagKt.getConstraintLayoutId(measurable2);
            }
            if (obj == null) {
                str = null;
            } else {
                str = obj.toString();
            }
            constraintWidget2.stringId = str;
        }
        getRoot().setOptimizationLevel(i);
        getRoot().measure(0, 0, 0, 0, 0, 0, 0, 0, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x009e, code lost:
        if (r2.intValue() != Integer.MIN_VALUE) goto L_0x00b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b2, code lost:
        if (r1 == false) goto L_0x020f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x01d7, code lost:
        if (r5.intValue() != r3) goto L_0x01d9;
     */
    /* renamed from: performInterpolationMeasure-OQbXsTc  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long m4210performInterpolationMeasureOQbXsTc(long r17, androidx.compose.ui.unit.LayoutDirection r19, androidx.constraintlayout.compose.ConstraintSet r20, androidx.constraintlayout.compose.ConstraintSet r21, androidx.constraintlayout.compose.Transition r22, java.util.List<? extends androidx.compose.ui.layout.Measurable> r23, int r24, float r25, androidx.compose.ui.layout.MeasureScope r26) {
        /*
            r16 = this;
            r6 = r16
            r0 = r19
            r7 = r22
            r8 = r25
            r1 = r26
            java.lang.String r2 = "layoutDirection"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            java.lang.String r2 = "constraintSetStart"
            r3 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r2)
            java.lang.String r2 = "constraintSetEnd"
            r9 = r21
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r2)
            java.lang.String r2 = "measurables"
            r10 = r23
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r2)
            java.lang.String r2 = "measureScope"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            r2 = r1
            androidx.compose.ui.unit.Density r2 = (androidx.compose.ui.unit.Density) r2
            r6.setDensity(r2)
            r6.setMeasureScope(r1)
            boolean r1 = androidx.compose.ui.unit.Constraints.m3801getHasFixedWidthimpl(r17)
            r11 = 1
            r12 = 0
            if (r1 == 0) goto L_0x004a
            androidx.constraintlayout.compose.State r1 = r16.getState()
            int r2 = androidx.compose.ui.unit.Constraints.m3803getMaxWidthimpl(r17)
            boolean r1 = r1.sameFixedWidth(r2)
            if (r1 != 0) goto L_0x004a
            r1 = 1
            goto L_0x004b
        L_0x004a:
            r1 = 0
        L_0x004b:
            boolean r2 = androidx.compose.ui.unit.Constraints.m3800getHasFixedHeightimpl(r17)
            if (r2 == 0) goto L_0x0060
            androidx.constraintlayout.compose.State r2 = r16.getState()
            int r4 = androidx.compose.ui.unit.Constraints.m3802getMaxHeightimpl(r17)
            boolean r2 = r2.sameFixedHeight(r4)
            if (r2 != 0) goto L_0x0060
            r1 = 1
        L_0x0060:
            float r2 = r6.motionProgress
            int r2 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r2 != 0) goto L_0x0068
            r2 = 1
            goto L_0x0069
        L_0x0068:
            r2 = 0
        L_0x0069:
            r13 = 0
            if (r2 == 0) goto L_0x00b4
            androidx.constraintlayout.compose.LayoutInformationReceiver r2 = r16.getLayoutInformationReceiver()
            if (r2 != 0) goto L_0x0074
            r2 = r13
            goto L_0x007c
        L_0x0074:
            int r2 = r2.getForcedWidth()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
        L_0x007c:
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r2 != 0) goto L_0x0081
            goto L_0x0087
        L_0x0081:
            int r2 = r2.intValue()
            if (r2 == r4) goto L_0x00a0
        L_0x0087:
            androidx.constraintlayout.compose.LayoutInformationReceiver r2 = r16.getLayoutInformationReceiver()
            if (r2 != 0) goto L_0x008f
            r2 = r13
            goto L_0x0097
        L_0x008f:
            int r2 = r2.getForcedHeight()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
        L_0x0097:
            if (r2 != 0) goto L_0x009a
            goto L_0x00b4
        L_0x009a:
            int r2 = r2.intValue()
            if (r2 != r4) goto L_0x00b4
        L_0x00a0:
            androidx.constraintlayout.core.state.Transition r2 = r6.transition
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x00b4
            java.util.Map r2 = r16.getFrameCache()
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x00b4
            if (r1 == 0) goto L_0x020f
        L_0x00b4:
            r6.motionProgress = r8
            if (r1 != 0) goto L_0x00ca
            androidx.constraintlayout.core.state.Transition r1 = r6.transition
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x00ca
            java.util.Map r1 = r16.getFrameCache()
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x015c
        L_0x00ca:
            androidx.constraintlayout.core.state.Transition r1 = r6.transition
            r1.clear()
            r16.resetMeasureState$compose_release()
            androidx.constraintlayout.compose.State r1 = r16.getState()
            r1.reset()
            androidx.constraintlayout.compose.State r1 = r16.getState()
            boolean r2 = androidx.compose.ui.unit.Constraints.m3801getHasFixedWidthimpl(r17)
            if (r2 == 0) goto L_0x00ec
            int r2 = androidx.compose.ui.unit.Constraints.m3803getMaxWidthimpl(r17)
            androidx.constraintlayout.core.state.Dimension r2 = androidx.constraintlayout.core.state.Dimension.Fixed((int) r2)
            goto L_0x00f8
        L_0x00ec:
            androidx.constraintlayout.core.state.Dimension r2 = androidx.constraintlayout.core.state.Dimension.Wrap()
            int r4 = androidx.compose.ui.unit.Constraints.m3805getMinWidthimpl(r17)
            androidx.constraintlayout.core.state.Dimension r2 = r2.min((int) r4)
        L_0x00f8:
            r1.width(r2)
            androidx.constraintlayout.compose.State r1 = r16.getState()
            boolean r2 = androidx.compose.ui.unit.Constraints.m3800getHasFixedHeightimpl(r17)
            if (r2 == 0) goto L_0x010e
            int r2 = androidx.compose.ui.unit.Constraints.m3802getMaxHeightimpl(r17)
            androidx.constraintlayout.core.state.Dimension r2 = androidx.constraintlayout.core.state.Dimension.Fixed((int) r2)
            goto L_0x011a
        L_0x010e:
            androidx.constraintlayout.core.state.Dimension r2 = androidx.constraintlayout.core.state.Dimension.Wrap()
            int r4 = androidx.compose.ui.unit.Constraints.m3804getMinHeightimpl(r17)
            androidx.constraintlayout.core.state.Dimension r2 = r2.min((int) r4)
        L_0x011a:
            r1.height(r2)
            androidx.constraintlayout.compose.State r1 = r16.getState()
            r14 = r17
            r1.m4212setRootIncomingConstraintsBRTryo0(r14)
            androidx.constraintlayout.compose.State r1 = r16.getState()
            r1.setLayoutDirection(r0)
            r0 = r16
            r1 = r24
            r2 = r20
            r3 = r23
            r4 = r17
            r0.m4208measureConstraintSethBUhpc(r1, r2, r3, r4)
            androidx.constraintlayout.core.state.Transition r0 = r6.transition
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r1 = r16.getRoot()
            r0.updateFrom(r1, r12)
            r0 = r16
            r1 = r24
            r2 = r21
            r0.m4208measureConstraintSethBUhpc(r1, r2, r3, r4)
            androidx.constraintlayout.core.state.Transition r0 = r6.transition
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r1 = r16.getRoot()
            r0.updateFrom(r1, r11)
            if (r7 == 0) goto L_0x015c
            androidx.constraintlayout.core.state.Transition r0 = r6.transition
            r7.applyTo(r0, r12)
        L_0x015c:
            androidx.constraintlayout.core.state.Transition r0 = r6.transition
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r1 = r16.getRoot()
            int r1 = r1.getWidth()
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r2 = r16.getRoot()
            int r2 = r2.getHeight()
            r0.interpolate(r1, r2, r8)
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r0 = r16.getRoot()
            java.util.ArrayList r0 = r0.getChildren()
            java.util.Iterator r0 = r0.iterator()
        L_0x017d:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x01fd
            java.lang.Object r1 = r0.next()
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r1
            java.lang.Object r2 = r1.getCompanionWidget()
            boolean r3 = r2 instanceof androidx.compose.ui.layout.Measurable
            if (r3 != 0) goto L_0x0192
            goto L_0x017d
        L_0x0192:
            androidx.constraintlayout.core.state.Transition r3 = r6.transition
            androidx.constraintlayout.core.state.WidgetFrame r1 = r3.getInterpolated((androidx.constraintlayout.core.widgets.ConstraintWidget) r1)
            if (r1 != 0) goto L_0x019b
            goto L_0x017d
        L_0x019b:
            java.util.Map r3 = r16.getPlaceables()
            java.lang.Object r3 = r3.get(r2)
            androidx.compose.ui.layout.Placeable r3 = (androidx.compose.ui.layout.Placeable) r3
            if (r3 != 0) goto L_0x01a9
            r4 = r13
            goto L_0x01b1
        L_0x01a9:
            int r4 = r3.getWidth()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        L_0x01b1:
            if (r3 != 0) goto L_0x01b5
            r5 = r13
            goto L_0x01bd
        L_0x01b5:
            int r5 = r3.getHeight()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
        L_0x01bd:
            if (r3 == 0) goto L_0x01d9
            int r3 = r1.width()
            if (r4 != 0) goto L_0x01c6
            goto L_0x01d9
        L_0x01c6:
            int r4 = r4.intValue()
            if (r4 != r3) goto L_0x01d9
            int r3 = r1.height()
            if (r5 != 0) goto L_0x01d3
            goto L_0x01d9
        L_0x01d3:
            int r4 = r5.intValue()
            if (r4 == r3) goto L_0x01f5
        L_0x01d9:
            r3 = r2
            androidx.compose.ui.layout.Measurable r3 = (androidx.compose.ui.layout.Measurable) r3
            androidx.compose.ui.unit.Constraints$Companion r4 = androidx.compose.ui.unit.Constraints.Companion
            int r5 = r1.width()
            int r7 = r1.height()
            long r4 = r4.m3811fixedJhjzzOo(r5, r7)
            androidx.compose.ui.layout.Placeable r3 = r3.m3151measureBRTryo0(r4)
            java.util.Map r4 = r16.getPlaceables()
            r4.put(r2, r3)
        L_0x01f5:
            java.util.Map r3 = r16.getFrameCache()
            r3.put(r2, r1)
            goto L_0x017d
        L_0x01fd:
            androidx.constraintlayout.compose.LayoutInformationReceiver r0 = r16.getLayoutInformationReceiver()
            if (r0 != 0) goto L_0x0204
            goto L_0x0208
        L_0x0204:
            androidx.constraintlayout.compose.LayoutInfoFlags r13 = r0.getLayoutInformationMode()
        L_0x0208:
            androidx.constraintlayout.compose.LayoutInfoFlags r0 = androidx.constraintlayout.compose.LayoutInfoFlags.BOUNDS
            if (r13 != r0) goto L_0x020f
            r16.computeLayoutResult()
        L_0x020f:
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r0 = r16.getRoot()
            int r0 = r0.getWidth()
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r1 = r16.getRoot()
            int r1 = r1.getHeight()
            long r0 = androidx.compose.ui.unit.IntSizeKt.IntSize(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.compose.MotionMeasurer.m4210performInterpolationMeasureOQbXsTc(long, androidx.compose.ui.unit.LayoutDirection, androidx.constraintlayout.compose.ConstraintSet, androidx.constraintlayout.compose.ConstraintSet, androidx.constraintlayout.compose.Transition, java.util.List, int, float, androidx.compose.ui.layout.MeasureScope):long");
    }

    private final void encodeKeyFrames(StringBuilder sb, float[] fArr, int[] iArr, int[] iArr2, int i) {
        if (i != 0) {
            sb.append("keyTypes : [");
            int i2 = 0;
            if (i > 0) {
                int i3 = 0;
                while (true) {
                    int i4 = i3 + 1;
                    int i5 = iArr[i3];
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(' ');
                    sb2.append(i5);
                    sb2.append(AbstractJsonLexerKt.COMMA);
                    sb.append(sb2.toString());
                    if (i4 >= i) {
                        break;
                    }
                    i3 = i4;
                }
            }
            sb.append("],\n");
            sb.append("keyPos : [");
            int i6 = i * 2;
            if (i6 > 0) {
                int i7 = 0;
                while (true) {
                    int i8 = i7 + 1;
                    float f = fArr[i7];
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(' ');
                    sb3.append(f);
                    sb3.append(AbstractJsonLexerKt.COMMA);
                    sb.append(sb3.toString());
                    if (i8 >= i6) {
                        break;
                    }
                    i7 = i8;
                }
            }
            sb.append("],\n ");
            sb.append("keyFrames : [");
            if (i > 0) {
                while (true) {
                    int i9 = i2 + 1;
                    int i10 = iArr2[i2];
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(' ');
                    sb4.append(i10);
                    sb4.append(AbstractJsonLexerKt.COMMA);
                    sb.append(sb4.toString());
                    if (i9 >= i) {
                        break;
                    }
                    i2 = i9;
                }
            }
            sb.append("],\n ");
        }
    }

    public final void encodeRoot(StringBuilder sb) {
        Intrinsics.checkNotNullParameter(sb, "json");
        sb.append("  root: {");
        sb.append("interpolated: { left:  0,");
        sb.append("  top:  0,");
        sb.append("  right:   " + getRoot().getWidth() + " ,");
        sb.append("  bottom:  " + getRoot().getHeight() + " ,");
        sb.append(" } }");
    }

    public void computeLayoutResult() {
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");
        encodeRoot(sb);
        int[] iArr = new int[50];
        int[] iArr2 = new int[50];
        float[] fArr = new float[100];
        Iterator<ConstraintWidget> it = getRoot().getChildren().iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            WidgetFrame start = this.transition.getStart(next.stringId);
            WidgetFrame end = this.transition.getEnd(next.stringId);
            WidgetFrame interpolated = this.transition.getInterpolated(next.stringId);
            float[] path = this.transition.getPath(next.stringId);
            int keyFrames = this.transition.getKeyFrames(next.stringId, fArr, iArr, iArr2);
            sb.append(' ' + next.stringId + ": {");
            sb.append(" interpolated : ");
            interpolated.serialize(sb, true);
            sb.append(", start : ");
            start.serialize(sb);
            sb.append(", end : ");
            end.serialize(sb);
            encodeKeyFrames(sb, fArr, iArr, iArr2, keyFrames);
            sb.append(" path : [");
            Intrinsics.checkNotNullExpressionValue(path, ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH);
            int i = 0;
            int length = path.length;
            while (i < length) {
                float f = path[i];
                i++;
                sb.append(' ' + f + " ,");
            }
            sb.append(" ] ");
            sb.append("}, ");
        }
        sb.append(" }");
        LayoutInformationReceiver layoutInformationReceiver = getLayoutInformationReceiver();
        if (layoutInformationReceiver != null) {
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "json.toString()");
            layoutInformationReceiver.setLayoutInformation(sb2);
        }
    }

    public final void drawDebug(BoxScope boxScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(boxScope, "<this>");
        Composer startRestartGroup = composer.startRestartGroup(436941497);
        ComposerKt.sourceInformation(startRestartGroup, "C(drawDebug)");
        CanvasKt.Canvas(boxScope.matchParentSize(Modifier.Companion), new MotionMeasurer$drawDebug$1(this), startRestartGroup, 0);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new MotionMeasurer$drawDebug$2(this, boxScope, i));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: drawFrameDebug-PE3pjmc  reason: not valid java name */
    public final void m4207drawFrameDebugPE3pjmc(DrawScope drawScope, float f, float f2, WidgetFrame widgetFrame, WidgetFrame widgetFrame2, PathEffect pathEffect, long j) {
        float f3 = f;
        float f4 = f2;
        WidgetFrame widgetFrame3 = widgetFrame;
        DrawScope drawScope2 = drawScope;
        PathEffect pathEffect2 = pathEffect;
        long j2 = j;
        m4206drawFrameg2O1Hgs(drawScope2, widgetFrame, pathEffect2, j2);
        m4206drawFrameg2O1Hgs(drawScope2, widgetFrame2, pathEffect2, j2);
        int numberKeyPositions = this.transition.getNumberKeyPositions(widgetFrame3);
        new MotionRenderDebug(23.0f).draw(AndroidCanvas_androidKt.getNativeCanvas(drawScope.getDrawContext().getCanvas()), this.transition.getMotion(widgetFrame3.widget.stringId), 1000, 1, (int) f3, (int) f4);
        if (numberKeyPositions != 0) {
            float[] fArr = new float[numberKeyPositions];
            float[] fArr2 = new float[numberKeyPositions];
            float[] fArr3 = new float[numberKeyPositions];
            this.transition.fillKeyPositions(widgetFrame3, fArr, fArr2, fArr3);
            widgetFrame.centerX();
            widgetFrame.centerY();
            int i = 0;
            int i2 = numberKeyPositions - 1;
            if (i2 >= 0) {
                while (true) {
                    int i3 = i + 1;
                    float f5 = fArr3[i] / 100.0f;
                    float f6 = ((float) 1) - f5;
                    float width = (((float) widgetFrame.width()) * f6) + (((float) widgetFrame2.width()) * f5);
                    float height = (f6 * ((float) widgetFrame.height())) + (f5 * ((float) widgetFrame2.height()));
                    float f7 = (fArr[i] * f3) + (width / 2.0f);
                    float f8 = (fArr2[i] * f4) + (height / 2.0f);
                    Path Path = AndroidPath_androidKt.Path();
                    Path.moveTo(f7 - 20.0f, f8);
                    Path.lineTo(f7, f8 + 20.0f);
                    Path.lineTo(f7 + 20.0f, f8);
                    Path.lineTo(f7, f8 - 20.0f);
                    Path.close();
                    DrawScope.DefaultImpls.m2108drawPathLG529CI$default(drawScope, Path, j, 1.0f, new Stroke(3.0f, 0.0f, 0, 0, (PathEffect) null, 30, (DefaultConstructorMarker) null), (ColorFilter) null, 0, 48, (Object) null);
                    if (i != i2) {
                        i = i3;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    /* renamed from: drawFrame-g2O1Hgs  reason: not valid java name */
    private final void m4206drawFrameg2O1Hgs(DrawScope drawScope, WidgetFrame widgetFrame, PathEffect pathEffect, long j) {
        WidgetFrame widgetFrame2 = widgetFrame;
        if (widgetFrame.isDefaultTransform()) {
            DrawScope.DefaultImpls.m2112drawRectnJ9OG0$default(drawScope, j, OffsetKt.Offset((float) widgetFrame2.left, (float) widgetFrame2.top), SizeKt.Size((float) widgetFrame.width(), (float) widgetFrame.height()), 0.0f, new Stroke(3.0f, 0.0f, 0, 0, pathEffect, 14, (DefaultConstructorMarker) null), (ColorFilter) null, 0, 104, (Object) null);
            return;
        }
        Matrix matrix = new Matrix();
        if (!Float.isNaN(widgetFrame2.rotationZ)) {
            matrix.preRotate(widgetFrame2.rotationZ, widgetFrame.centerX(), widgetFrame.centerY());
        }
        float f = 1.0f;
        float f2 = Float.isNaN(widgetFrame2.scaleX) ? 1.0f : widgetFrame2.scaleX;
        if (!Float.isNaN(widgetFrame2.scaleY)) {
            f = widgetFrame2.scaleY;
        }
        matrix.preScale(f2, f, widgetFrame.centerX(), widgetFrame.centerY());
        float[] fArr = {(float) widgetFrame2.left, (float) widgetFrame2.top, (float) widgetFrame2.right, (float) widgetFrame2.top, (float) widgetFrame2.right, (float) widgetFrame2.bottom, (float) widgetFrame2.left, (float) widgetFrame2.bottom};
        matrix.mapPoints(fArr);
        DrawScope drawScope2 = drawScope;
        long j2 = j;
        PathEffect pathEffect2 = pathEffect;
        DrawScope.DefaultImpls.m2104drawLineNGM6Ib0$default(drawScope2, j2, OffsetKt.Offset(fArr[0], fArr[1]), OffsetKt.Offset(fArr[2], fArr[3]), 3.0f, 0, pathEffect2, 0.0f, (ColorFilter) null, 0, 464, (Object) null);
        DrawScope.DefaultImpls.m2104drawLineNGM6Ib0$default(drawScope2, j2, OffsetKt.Offset(fArr[2], fArr[3]), OffsetKt.Offset(fArr[4], fArr[5]), 3.0f, 0, pathEffect2, 0.0f, (ColorFilter) null, 0, 464, (Object) null);
        DrawScope.DefaultImpls.m2104drawLineNGM6Ib0$default(drawScope2, j2, OffsetKt.Offset(fArr[4], fArr[5]), OffsetKt.Offset(fArr[6], fArr[7]), 3.0f, 0, pathEffect2, 0.0f, (ColorFilter) null, 0, 464, (Object) null);
        DrawScope.DefaultImpls.m2104drawLineNGM6Ib0$default(drawScope, j, OffsetKt.Offset(fArr[6], fArr[7]), OffsetKt.Offset(fArr[0], fArr[1]), 3.0f, 0, pathEffect, 0.0f, (ColorFilter) null, 0, 464, (Object) null);
    }

    /* renamed from: getCustomColor-WaAFU9c  reason: not valid java name */
    public final long m4209getCustomColorWaAFU9c(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, MessageExtension.FIELD_ID);
        Intrinsics.checkNotNullParameter(str2, "name");
        if (!this.transition.contains(str)) {
            return Color.Companion.m1622getBlack0d7_KjU();
        }
        this.transition.interpolate(getRoot().getWidth(), getRoot().getHeight(), this.motionProgress);
        return ColorKt.Color(this.transition.getInterpolated(str).getCustomColor(str2));
    }

    public final float getCustomFloat(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, MessageExtension.FIELD_ID);
        Intrinsics.checkNotNullParameter(str2, "name");
        if (!this.transition.contains(str)) {
            return 0.0f;
        }
        WidgetFrame start = this.transition.getStart(str);
        WidgetFrame end = this.transition.getEnd(str);
        float customFloat = start.getCustomFloat(str2);
        float customFloat2 = end.getCustomFloat(str2);
        float f = this.motionProgress;
        return ((1.0f - f) * customFloat) + (f * customFloat2);
    }

    public final void clearConstraintSets() {
        this.transition.clear();
        getFrameCache().clear();
    }

    public final void initWith(ConstraintSet constraintSet, ConstraintSet constraintSet2, Transition transition2, float f) {
        Intrinsics.checkNotNullParameter(constraintSet, ViewProps.START);
        Intrinsics.checkNotNullParameter(constraintSet2, ViewProps.END);
        clearConstraintSets();
        constraintSet.applyTo(this.transition, 0);
        constraintSet2.applyTo(this.transition, 1);
        this.transition.interpolate(0, 0, f);
        if (transition2 != null) {
            transition2.applyTo(this.transition, 0);
        }
    }
}
