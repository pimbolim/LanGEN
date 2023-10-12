package androidx.constraintlayout.compose;

import android.util.Log;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.constraintlayout.core.state.Dimension;
import androidx.constraintlayout.core.state.WidgetFrame;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0011\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010C\u001a\u00020D2\b\u0010E\u001a\u0004\u0018\u00010*J\u001d\u0010F\u001a\u00020D2\u0006\u0010G\u001a\u00020HH\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bI\u0010JJ\b\u0010K\u001a\u00020DH\u0016J\r\u0010L\u001a\u00020DH\u0007¢\u0006\u0002\u0010MJ\b\u0010N\u001a\u00020DH\u0016J)\u0010O\u001a\u00020P2\b\u0010Q\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010R\u001a\u00020PH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bS\u0010TJ \u0010U\u001a\u00020\u00052\u0006\u0010V\u001a\u00020 2\u0006\u0010W\u001a\u00020 2\u0006\u0010X\u001a\u00020\u0005H\u0016J\u001c\u0010Y\u001a\u00020Z2\u0012\u0010[\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\\H\u0002J\u0018\u0010]\u001a\u00020D2\u0006\u0010^\u001a\u00020_2\u0006\u0010]\u001a\u00020`H\u0016JH\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020 2\u0006\u0010f\u001a\u00020 2\u0006\u0010g\u001a\u00020 2\u0006\u0010h\u001a\u00020b2\u0006\u0010i\u001a\u00020b2\u0006\u0010j\u001a\u00020 2\u0006\u0010k\u001a\u00020\u001dH\u0002J\u000e\u0010l\u001a\u00020D2\u0006\u0010m\u001a\u00020nJI\u0010o\u001a\u00020p2\u0006\u0010G\u001a\u00020H2\u0006\u0010q\u001a\u00020r2\u0006\u0010m\u001a\u00020n2\f\u0010s\u001a\b\u0012\u0004\u0012\u00020\u00180t2\u0006\u0010u\u001a\u00020 2\u0006\u0010/\u001a\u000200ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bv\u0010wJ\r\u0010x\u001a\u00020DH\u0000¢\u0006\u0002\byJ\u001f\u0010z\u001a\u00020D*\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010]\u001a\u00020`H\u0002¢\u0006\u0002\u0010{J\u0019\u0010|\u001a\u00020D*\u00020}2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007¢\u0006\u0002\u0010~J\u0019\u0010\u001a\u00020D*\u00030\u00012\f\u0010s\u001a\b\u0012\u0004\u0012\u00020\u00180tR\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0017X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R \u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u0017X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u000200X.¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R \u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u0002060\u0017X\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u001bR\u0014\u00108\u001a\u000209X\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u001b\u0010<\u001a\u00020=8DX\u0002¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\b>\u0010?R\u000e\u0010B\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0001"}, d2 = {"Landroidx/constraintlayout/compose/Measurer;", "Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measurer;", "Landroidx/constraintlayout/compose/DesignInfoProvider;", "()V", "computedLayoutResult", "", "density", "Landroidx/compose/ui/unit/Density;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "designElements", "Ljava/util/ArrayList;", "Landroidx/constraintlayout/compose/DesignElement;", "Lkotlin/collections/ArrayList;", "forcedScaleFactor", "", "getForcedScaleFactor", "()F", "setForcedScaleFactor", "(F)V", "frameCache", "", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/constraintlayout/core/state/WidgetFrame;", "getFrameCache", "()Ljava/util/Map;", "heightConstraintsHolder", "", "lastMeasures", "", "", "layoutCurrentHeight", "getLayoutCurrentHeight", "()I", "setLayoutCurrentHeight", "(I)V", "layoutCurrentWidth", "getLayoutCurrentWidth", "setLayoutCurrentWidth", "layoutInformationReceiver", "Landroidx/constraintlayout/compose/LayoutInformationReceiver;", "getLayoutInformationReceiver", "()Landroidx/constraintlayout/compose/LayoutInformationReceiver;", "setLayoutInformationReceiver", "(Landroidx/constraintlayout/compose/LayoutInformationReceiver;)V", "measureScope", "Landroidx/compose/ui/layout/MeasureScope;", "getMeasureScope", "()Landroidx/compose/ui/layout/MeasureScope;", "setMeasureScope", "(Landroidx/compose/ui/layout/MeasureScope;)V", "placeables", "Landroidx/compose/ui/layout/Placeable;", "getPlaceables", "root", "Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;", "getRoot", "()Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;", "state", "Landroidx/constraintlayout/compose/State;", "getState", "()Landroidx/constraintlayout/compose/State;", "state$delegate", "Lkotlin/Lazy;", "widthConstraintsHolder", "addLayoutInformationReceiver", "", "layoutReceiver", "applyRootSize", "constraints", "Landroidx/compose/ui/unit/Constraints;", "applyRootSize-BRTryo0", "(J)V", "computeLayoutResult", "createDesignElements", "(Landroidx/compose/runtime/Composer;I)V", "didMeasures", "getColor", "Landroidx/compose/ui/graphics/Color;", "str", "defaultColor", "getColor-wrIjXm8", "(Ljava/lang/String;J)J", "getDesignInfo", "startX", "startY", "args", "getTextStyle", "Landroidx/compose/ui/text/TextStyle;", "params", "Ljava/util/HashMap;", "measure", "constraintWidget", "Landroidx/constraintlayout/core/widgets/ConstraintWidget;", "Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;", "obtainConstraints", "", "dimensionBehaviour", "Landroidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour;", "dimension", "matchConstraintDefaultDimension", "measureStrategy", "otherDimensionResolved", "currentDimensionResolved", "rootMaxConstraint", "outConstraints", "parseDesignElements", "constraintSet", "Landroidx/constraintlayout/compose/ConstraintSet;", "performMeasure", "Landroidx/compose/ui/unit/IntSize;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "measurables", "", "optimizationLevel", "performMeasure-DjhGOtQ", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/constraintlayout/compose/ConstraintSet;Ljava/util/List;ILandroidx/compose/ui/layout/MeasureScope;)J", "resetMeasureState", "resetMeasureState$compose_release", "copyFrom", "([Ljava/lang/Integer;Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;)V", "drawDebugBounds", "Landroidx/compose/foundation/layout/BoxScope;", "(Landroidx/compose/foundation/layout/BoxScope;FLandroidx/compose/runtime/Composer;I)V", "performLayout", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "compose_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ConstraintLayout.kt */
public class Measurer implements BasicMeasure.Measurer, DesignInfoProvider {
    private String computedLayoutResult = "";
    protected Density density;
    private ArrayList<DesignElement> designElements;
    private float forcedScaleFactor;
    private final Map<Measurable, WidgetFrame> frameCache;
    private final int[] heightConstraintsHolder;
    private final Map<Measurable, Integer[]> lastMeasures;
    private int layoutCurrentHeight;
    private int layoutCurrentWidth;
    private LayoutInformationReceiver layoutInformationReceiver;
    protected MeasureScope measureScope;
    private final Map<Measurable, Placeable> placeables;
    private final ConstraintWidgetContainer root;
    private final Lazy state$delegate;
    private final int[] widthConstraintsHolder;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ConstraintLayout.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ConstraintWidget.DimensionBehaviour.values().length];
            iArr[ConstraintWidget.DimensionBehaviour.FIXED.ordinal()] = 1;
            iArr[ConstraintWidget.DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;
            iArr[ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 3;
            iArr[ConstraintWidget.DimensionBehaviour.MATCH_PARENT.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public void didMeasures() {
    }

    public Measurer() {
        ConstraintWidgetContainer constraintWidgetContainer = new ConstraintWidgetContainer(0, 0);
        constraintWidgetContainer.setMeasurer(this);
        Unit unit = Unit.INSTANCE;
        this.root = constraintWidgetContainer;
        this.placeables = new LinkedHashMap();
        this.lastMeasures = new LinkedHashMap();
        this.frameCache = new LinkedHashMap();
        this.state$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Measurer$state$2(this));
        this.widthConstraintsHolder = new int[2];
        this.heightConstraintsHolder = new int[2];
        this.forcedScaleFactor = Float.NaN;
        this.designElements = new ArrayList<>();
    }

    /* access modifiers changed from: protected */
    public final LayoutInformationReceiver getLayoutInformationReceiver() {
        return this.layoutInformationReceiver;
    }

    /* access modifiers changed from: protected */
    public final void setLayoutInformationReceiver(LayoutInformationReceiver layoutInformationReceiver2) {
        this.layoutInformationReceiver = layoutInformationReceiver2;
    }

    /* access modifiers changed from: protected */
    public final ConstraintWidgetContainer getRoot() {
        return this.root;
    }

    /* access modifiers changed from: protected */
    public final Map<Measurable, Placeable> getPlaceables() {
        return this.placeables;
    }

    /* access modifiers changed from: protected */
    public final Map<Measurable, WidgetFrame> getFrameCache() {
        return this.frameCache;
    }

    /* access modifiers changed from: protected */
    public final Density getDensity() {
        Density density2 = this.density;
        if (density2 != null) {
            return density2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("density");
        throw null;
    }

    /* access modifiers changed from: protected */
    public final void setDensity(Density density2) {
        Intrinsics.checkNotNullParameter(density2, "<set-?>");
        this.density = density2;
    }

    /* access modifiers changed from: protected */
    public final MeasureScope getMeasureScope() {
        MeasureScope measureScope2 = this.measureScope;
        if (measureScope2 != null) {
            return measureScope2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("measureScope");
        throw null;
    }

    /* access modifiers changed from: protected */
    public final void setMeasureScope(MeasureScope measureScope2) {
        Intrinsics.checkNotNullParameter(measureScope2, "<set-?>");
        this.measureScope = measureScope2;
    }

    /* access modifiers changed from: protected */
    public final State getState() {
        return (State) this.state$delegate.getValue();
    }

    public final float getForcedScaleFactor() {
        return this.forcedScaleFactor;
    }

    public final void setForcedScaleFactor(float f) {
        this.forcedScaleFactor = f;
    }

    public final int getLayoutCurrentWidth() {
        return this.layoutCurrentWidth;
    }

    public final void setLayoutCurrentWidth(int i) {
        this.layoutCurrentWidth = i;
    }

    public final int getLayoutCurrentHeight() {
        return this.layoutCurrentHeight;
    }

    public final void setLayoutCurrentHeight(int i) {
        this.layoutCurrentHeight = i;
    }

    public String getDesignInfo(int i, int i2, String str) {
        Intrinsics.checkNotNullParameter(str, "args");
        return ToolingUtilsKt.parseConstraintsToJson(this.root, getState(), i, i2);
    }

    public void measure(ConstraintWidget constraintWidget, BasicMeasure.Measure measure) {
        int i;
        int i2;
        boolean z;
        Integer num;
        Integer num2;
        Integer num3;
        ConstraintWidget constraintWidget2 = constraintWidget;
        BasicMeasure.Measure measure2 = measure;
        Intrinsics.checkNotNullParameter(constraintWidget2, "constraintWidget");
        Intrinsics.checkNotNullParameter(measure2, "measure");
        Object companionWidget = constraintWidget.getCompanionWidget();
        if (companionWidget instanceof Measurable) {
            if (ConstraintLayoutKt.DEBUG) {
                Log.d("CCL", "Measuring " + LayoutIdKt.getLayoutId((Measurable) companionWidget) + " with: " + ConstraintLayoutKt.toDebugString(constraintWidget) + 10 + ConstraintLayoutKt.toDebugString(measure));
            }
            Measurer measurer = this;
            Integer[] numArr = measurer.lastMeasures.get(companionWidget);
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = measure2.horizontalBehavior;
            Intrinsics.checkNotNullExpressionValue(dimensionBehaviour, "measure.horizontalBehavior");
            int i3 = measure2.horizontalDimension;
            int i4 = constraintWidget2.mMatchConstraintDefaultWidth;
            int i5 = measure2.measureStrategy;
            if (numArr == null || (num3 = numArr[1]) == null) {
                i = 0;
            } else {
                i = num3.intValue();
            }
            measurer.obtainConstraints(dimensionBehaviour, i3, i4, i5, i == constraintWidget.getHeight(), constraintWidget.isResolvedHorizontally(), Constraints.m3803getMaxWidthimpl(measurer.getState().m4211getRootIncomingConstraintsmsEJaDk()), measurer.widthConstraintsHolder);
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = measure2.verticalBehavior;
            Intrinsics.checkNotNullExpressionValue(dimensionBehaviour2, "measure.verticalBehavior");
            int i6 = measure2.verticalDimension;
            int i7 = constraintWidget2.mMatchConstraintDefaultHeight;
            int i8 = measure2.measureStrategy;
            if (numArr == null || (num2 = numArr[0]) == null) {
                i2 = 0;
            } else {
                i2 = num2.intValue();
            }
            measurer.obtainConstraints(dimensionBehaviour2, i6, i7, i8, i2 == constraintWidget.getWidth(), constraintWidget.isResolvedVertically(), Constraints.m3802getMaxHeightimpl(measurer.getState().m4211getRootIncomingConstraintsmsEJaDk()), measurer.heightConstraintsHolder);
            int[] iArr = measurer.widthConstraintsHolder;
            int i9 = iArr[0];
            int i10 = iArr[1];
            int[] iArr2 = measurer.heightConstraintsHolder;
            long Constraints = ConstraintsKt.Constraints(i9, i10, iArr2[0], iArr2[1]);
            Integer num4 = null;
            if (!(measure2.measureStrategy != BasicMeasure.Measure.TRY_GIVEN_DIMENSIONS && measure2.measureStrategy != BasicMeasure.Measure.USE_GIVEN_DIMENSIONS && measure2.horizontalBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget2.mMatchConstraintDefaultWidth == 0 && measure2.verticalBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget2.mMatchConstraintDefaultHeight == 0)) {
                if (ConstraintLayoutKt.DEBUG) {
                    Log.d("CCL", "Measuring " + LayoutIdKt.getLayoutId((Measurable) companionWidget) + " with " + Constraints.m3808toStringimpl(Constraints));
                }
                Measurable measurable = (Measurable) companionWidget;
                Placeable r5 = measurable.m3151measureBRTryo0(Constraints);
                getPlaceables().put(companionWidget, r5);
                constraintWidget2.setMeasureRequested(false);
                if (ConstraintLayoutKt.DEBUG) {
                    Log.d("CCL", LayoutIdKt.getLayoutId(measurable) + " is size " + r5.getWidth() + ' ' + r5.getHeight());
                }
                Comparable valueOf = Integer.valueOf(r5.getWidth());
                Integer valueOf2 = Integer.valueOf(constraintWidget2.mMatchConstraintMinWidth);
                if (!(valueOf2.intValue() > 0)) {
                    valueOf2 = null;
                }
                Comparable comparable = valueOf2;
                Integer valueOf3 = Integer.valueOf(constraintWidget2.mMatchConstraintMaxWidth);
                if (!(valueOf3.intValue() > 0)) {
                    valueOf3 = null;
                }
                int intValue = ((Number) RangesKt.coerceIn(valueOf, comparable, valueOf3)).intValue();
                Comparable valueOf4 = Integer.valueOf(r5.getHeight());
                Integer valueOf5 = Integer.valueOf(constraintWidget2.mMatchConstraintMinHeight);
                if (!(valueOf5.intValue() > 0)) {
                    valueOf5 = null;
                }
                Comparable comparable2 = valueOf5;
                Integer valueOf6 = Integer.valueOf(constraintWidget2.mMatchConstraintMaxHeight);
                if (!(valueOf6.intValue() > 0)) {
                    valueOf6 = null;
                }
                int intValue2 = ((Number) RangesKt.coerceIn(valueOf4, comparable2, valueOf6)).intValue();
                if (intValue != r5.getWidth()) {
                    Constraints = ConstraintsKt.Constraints(intValue, intValue, Constraints.m3804getMinHeightimpl(Constraints), Constraints.m3802getMaxHeightimpl(Constraints));
                    z = true;
                } else {
                    z = false;
                }
                if (intValue2 != r5.getHeight()) {
                    Constraints = ConstraintsKt.Constraints(Constraints.m3805getMinWidthimpl(Constraints), Constraints.m3803getMaxWidthimpl(Constraints), intValue2, intValue2);
                    z = true;
                }
                if (z) {
                    if (ConstraintLayoutKt.DEBUG) {
                        Log.d("CCL", "Remeasuring coerced " + LayoutIdKt.getLayoutId(measurable) + " with " + Constraints.m3808toStringimpl(Constraints));
                    }
                    getPlaceables().put(companionWidget, measurable.m3151measureBRTryo0(Constraints));
                    constraintWidget2.setMeasureRequested(false);
                }
            }
            boolean z2 = false;
            Placeable placeable = this.placeables.get(companionWidget);
            if (placeable == null) {
                num = null;
            } else {
                num = Integer.valueOf(placeable.getWidth());
            }
            measure2.measuredWidth = num == null ? constraintWidget.getWidth() : num.intValue();
            if (placeable != null) {
                num4 = Integer.valueOf(placeable.getHeight());
            }
            measure2.measuredHeight = num4 == null ? constraintWidget.getHeight() : num4.intValue();
            int i11 = (placeable == null || !getState().isBaselineNeeded$compose_release(constraintWidget2)) ? Integer.MIN_VALUE : placeable.get(AlignmentLineKt.getFirstBaseline());
            measure2.measuredHasBaseline = i11 != Integer.MIN_VALUE;
            measure2.measuredBaseline = i11;
            Map<Measurable, Integer[]> map = this.lastMeasures;
            Integer[] numArr2 = map.get(companionWidget);
            if (numArr2 == null) {
                numArr2 = new Integer[]{0, 0, Integer.MIN_VALUE};
                map.put(companionWidget, numArr2);
            }
            copyFrom(numArr2, measure2);
            if (!(measure2.measuredWidth == measure2.horizontalDimension && measure2.measuredHeight == measure2.verticalDimension)) {
                z2 = true;
            }
            measure2.measuredNeedsSolverPass = z2;
        }
    }

    public final void addLayoutInformationReceiver(LayoutInformationReceiver layoutInformationReceiver2) {
        this.layoutInformationReceiver = layoutInformationReceiver2;
        if (layoutInformationReceiver2 != null) {
            layoutInformationReceiver2.setLayoutInformation(this.computedLayoutResult);
        }
    }

    public void computeLayoutResult() {
        ConstraintWidget constraintWidget;
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");
        sb.append("  root: {");
        sb.append("interpolated: { left:  0,");
        sb.append("  top:  0,");
        sb.append("  right:   " + this.root.getWidth() + " ,");
        sb.append("  bottom:  " + this.root.getHeight() + " ,");
        sb.append(" } }");
        Iterator<ConstraintWidget> it = this.root.getChildren().iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            Object companionWidget = next.getCompanionWidget();
            if (companionWidget instanceof Measurable) {
                WidgetFrame widgetFrame = null;
                if (next.stringId == null) {
                    Measurable measurable = (Measurable) companionWidget;
                    Object layoutId = LayoutIdKt.getLayoutId(measurable);
                    if (layoutId == null) {
                        layoutId = ConstraintLayoutTagKt.getConstraintLayoutId(measurable);
                    }
                    if (layoutId == null) {
                        str = null;
                    } else {
                        str = layoutId.toString();
                    }
                    next.stringId = str;
                }
                WidgetFrame widgetFrame2 = this.frameCache.get(companionWidget);
                if (!(widgetFrame2 == null || (constraintWidget = widgetFrame2.widget) == null)) {
                    widgetFrame = constraintWidget.frame;
                }
                if (widgetFrame != null) {
                    sb.append(' ' + next.stringId + ": {");
                    sb.append(" interpolated : ");
                    widgetFrame.serialize(sb, true);
                    sb.append("}, ");
                }
            } else if (next instanceof Guideline) {
                sb.append(' ' + next.stringId + ": {");
                Guideline guideline = (Guideline) next;
                if (guideline.getOrientation() == 0) {
                    sb.append(" type: 'hGuideline', ");
                } else {
                    sb.append(" type: 'vGuideline', ");
                }
                sb.append(" interpolated: ");
                sb.append(" { left: " + guideline.getX() + ", top: " + guideline.getY() + ", right: " + (guideline.getX() + guideline.getWidth()) + ", bottom: " + (guideline.getY() + guideline.getHeight()) + " }");
                sb.append("}, ");
            }
        }
        sb.append(" }");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "json.toString()");
        this.computedLayoutResult = sb2;
        LayoutInformationReceiver layoutInformationReceiver2 = this.layoutInformationReceiver;
        if (layoutInformationReceiver2 != null) {
            layoutInformationReceiver2.setLayoutInformation(sb2);
        }
    }

    private final boolean obtainConstraints(ConstraintWidget.DimensionBehaviour dimensionBehaviour, int i, int i2, int i3, boolean z, boolean z2, int i4, int[] iArr) {
        int i5 = WhenMappings.$EnumSwitchMapping$0[dimensionBehaviour.ordinal()];
        if (i5 == 1) {
            iArr[0] = i;
            iArr[1] = i;
        } else if (i5 == 2) {
            iArr[0] = 0;
            iArr[1] = i4;
            return true;
        } else if (i5 == 3) {
            if (ConstraintLayoutKt.DEBUG) {
                Log.d("CCL", Intrinsics.stringPlus("Measure strategy ", Integer.valueOf(i3)));
                Log.d("CCL", Intrinsics.stringPlus("DW ", Integer.valueOf(i2)));
                Log.d("CCL", Intrinsics.stringPlus("ODR ", Boolean.valueOf(z)));
                Log.d("CCL", Intrinsics.stringPlus("IRH ", Boolean.valueOf(z2)));
            }
            boolean z3 = z2 || ((i3 == BasicMeasure.Measure.TRY_GIVEN_DIMENSIONS || i3 == BasicMeasure.Measure.USE_GIVEN_DIMENSIONS) && (i3 == BasicMeasure.Measure.USE_GIVEN_DIMENSIONS || i2 != 1 || z));
            if (ConstraintLayoutKt.DEBUG) {
                Log.d("CCL", Intrinsics.stringPlus("UD ", Boolean.valueOf(z3)));
            }
            iArr[0] = z3 ? i : 0;
            if (!z3) {
                i = i4;
            }
            iArr[1] = i;
            if (!z3) {
                return true;
            }
        } else if (i5 == 4) {
            iArr[0] = i4;
            iArr[1] = i4;
        } else {
            throw new IllegalStateException((dimensionBehaviour + " is not supported").toString());
        }
        return false;
    }

    private final void copyFrom(Integer[] numArr, BasicMeasure.Measure measure) {
        numArr[0] = Integer.valueOf(measure.measuredWidth);
        numArr[1] = Integer.valueOf(measure.measuredHeight);
        numArr[2] = Integer.valueOf(measure.measuredBaseline);
    }

    /* renamed from: performMeasure-DjhGOtQ  reason: not valid java name */
    public final long m4179performMeasureDjhGOtQ(long j, LayoutDirection layoutDirection, ConstraintSet constraintSet, List<? extends Measurable> list, int i, MeasureScope measureScope2) {
        Dimension dimension;
        Dimension dimension2;
        Integer num;
        Integer num2;
        String obj;
        LayoutDirection layoutDirection2 = layoutDirection;
        ConstraintSet constraintSet2 = constraintSet;
        List<? extends Measurable> list2 = list;
        MeasureScope measureScope3 = measureScope2;
        Intrinsics.checkNotNullParameter(layoutDirection2, "layoutDirection");
        Intrinsics.checkNotNullParameter(constraintSet2, "constraintSet");
        Intrinsics.checkNotNullParameter(list2, "measurables");
        Intrinsics.checkNotNullParameter(measureScope3, "measureScope");
        setDensity(measureScope3);
        setMeasureScope(measureScope3);
        State state = getState();
        if (Constraints.m3801getHasFixedWidthimpl(j)) {
            dimension = Dimension.Fixed(Constraints.m3803getMaxWidthimpl(j));
        } else {
            dimension = Dimension.Wrap().min(Constraints.m3805getMinWidthimpl(j));
        }
        state.width(dimension);
        State state2 = getState();
        if (Constraints.m3800getHasFixedHeightimpl(j)) {
            dimension2 = Dimension.Fixed(Constraints.m3802getMaxHeightimpl(j));
        } else {
            dimension2 = Dimension.Wrap().min(Constraints.m3804getMinHeightimpl(j));
        }
        state2.height(dimension2);
        getState().m4212setRootIncomingConstraintsBRTryo0(j);
        getState().setLayoutDirection(layoutDirection2);
        resetMeasureState$compose_release();
        if (constraintSet.isDirty(list)) {
            getState().reset();
            constraintSet2.applyTo(getState(), list2);
            ConstraintLayoutKt.buildMapping(getState(), list2);
            getState().apply(this.root);
        } else {
            ConstraintLayoutKt.buildMapping(getState(), list2);
        }
        m4178applyRootSizeBRTryo0(j);
        this.root.updateHierarchy();
        if (ConstraintLayoutKt.DEBUG) {
            this.root.setDebugName("ConstraintLayout");
            ArrayList<ConstraintWidget> children = this.root.getChildren();
            Intrinsics.checkNotNullExpressionValue(children, "root.children");
            for (ConstraintWidget constraintWidget : children) {
                Object companionWidget = constraintWidget.getCompanionWidget();
                Measurable measurable = companionWidget instanceof Measurable ? (Measurable) companionWidget : null;
                Object layoutId = measurable == null ? null : LayoutIdKt.getLayoutId(measurable);
                String str = "NOTAG";
                if (!(layoutId == null || (obj = layoutId.toString()) == null)) {
                    str = obj;
                }
                constraintWidget.setDebugName(str);
            }
            Log.d("CCL", Intrinsics.stringPlus("ConstraintLayout is asked to measure with ", Constraints.m3808toStringimpl(j)));
            Log.d("CCL", ConstraintLayoutKt.toDebugString((ConstraintWidget) this.root));
            Iterator<ConstraintWidget> it = this.root.getChildren().iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "child");
                Log.d("CCL", ConstraintLayoutKt.toDebugString(next));
            }
        }
        this.root.setOptimizationLevel(i);
        ConstraintWidgetContainer constraintWidgetContainer = this.root;
        constraintWidgetContainer.measure(constraintWidgetContainer.getOptimizationLevel(), 0, 0, 0, 0, 0, 0, 0, 0);
        Iterator<ConstraintWidget> it2 = this.root.getChildren().iterator();
        while (it2.hasNext()) {
            ConstraintWidget next2 = it2.next();
            Object companionWidget2 = next2.getCompanionWidget();
            if (companionWidget2 instanceof Measurable) {
                Placeable placeable = this.placeables.get(companionWidget2);
                if (placeable == null) {
                    num = null;
                } else {
                    num = Integer.valueOf(placeable.getWidth());
                }
                if (placeable == null) {
                    num2 = null;
                } else {
                    num2 = Integer.valueOf(placeable.getHeight());
                }
                int width = next2.getWidth();
                if (num != null && width == num.intValue()) {
                    int height = next2.getHeight();
                    if (num2 != null && height == num2.intValue()) {
                    }
                }
                if (ConstraintLayoutKt.DEBUG) {
                    Log.d("CCL", "Final measurement for " + LayoutIdKt.getLayoutId((Measurable) companionWidget2) + " to confirm size " + next2.getWidth() + ' ' + next2.getHeight());
                }
                getPlaceables().put(companionWidget2, ((Measurable) companionWidget2).m3151measureBRTryo0(Constraints.Companion.m3811fixedJhjzzOo(next2.getWidth(), next2.getHeight())));
            }
        }
        if (ConstraintLayoutKt.DEBUG) {
            Log.d("CCL", "ConstraintLayout is at the end " + this.root.getWidth() + ' ' + this.root.getHeight());
        }
        return IntSizeKt.IntSize(this.root.getWidth(), this.root.getHeight());
    }

    public final void resetMeasureState$compose_release() {
        this.placeables.clear();
        this.lastMeasures.clear();
        this.frameCache.clear();
    }

    /* access modifiers changed from: protected */
    /* renamed from: applyRootSize-BRTryo0  reason: not valid java name */
    public final void m4178applyRootSizeBRTryo0(long j) {
        this.root.setWidth(Constraints.m3803getMaxWidthimpl(j));
        this.root.setHeight(Constraints.m3802getMaxHeightimpl(j));
        this.forcedScaleFactor = Float.NaN;
        LayoutInformationReceiver layoutInformationReceiver2 = this.layoutInformationReceiver;
        Integer num = null;
        float f = 1.0f;
        if (layoutInformationReceiver2 != null) {
            Integer valueOf = layoutInformationReceiver2 == null ? null : Integer.valueOf(layoutInformationReceiver2.getForcedWidth());
            if (valueOf == null || valueOf.intValue() != Integer.MIN_VALUE) {
                LayoutInformationReceiver layoutInformationReceiver3 = this.layoutInformationReceiver;
                Intrinsics.checkNotNull(layoutInformationReceiver3);
                int forcedWidth = layoutInformationReceiver3.getForcedWidth();
                if (forcedWidth > this.root.getWidth()) {
                    this.forcedScaleFactor = ((float) this.root.getWidth()) / ((float) forcedWidth);
                } else {
                    this.forcedScaleFactor = 1.0f;
                }
                this.root.setWidth(forcedWidth);
            }
        }
        LayoutInformationReceiver layoutInformationReceiver4 = this.layoutInformationReceiver;
        if (layoutInformationReceiver4 != null) {
            if (layoutInformationReceiver4 != null) {
                num = Integer.valueOf(layoutInformationReceiver4.getForcedHeight());
            }
            if (num == null || num.intValue() != Integer.MIN_VALUE) {
                LayoutInformationReceiver layoutInformationReceiver5 = this.layoutInformationReceiver;
                Intrinsics.checkNotNull(layoutInformationReceiver5);
                int forcedHeight = layoutInformationReceiver5.getForcedHeight();
                if (Float.isNaN(this.forcedScaleFactor)) {
                    this.forcedScaleFactor = 1.0f;
                }
                if (forcedHeight > this.root.getHeight()) {
                    f = ((float) this.root.getHeight()) / ((float) forcedHeight);
                }
                if (f < this.forcedScaleFactor) {
                    this.forcedScaleFactor = f;
                }
                this.root.setHeight(forcedHeight);
            }
        }
        this.layoutCurrentWidth = this.root.getWidth();
        this.layoutCurrentHeight = this.root.getHeight();
    }

    public final void performLayout(Placeable.PlacementScope placementScope, List<? extends Measurable> list) {
        Intrinsics.checkNotNullParameter(placementScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        if (this.frameCache.isEmpty()) {
            Iterator<ConstraintWidget> it = this.root.getChildren().iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                Object companionWidget = next.getCompanionWidget();
                if (companionWidget instanceof Measurable) {
                    this.frameCache.put(companionWidget, new WidgetFrame(next.frame.update()));
                }
            }
        }
        int i = 0;
        int size = list.size() - 1;
        if (size >= 0) {
            while (true) {
                int i2 = i + 1;
                Measurable measurable = (Measurable) list.get(i);
                WidgetFrame widgetFrame = getFrameCache().get(measurable);
                if (widgetFrame != null) {
                    if (widgetFrame.isDefaultTransform()) {
                        WidgetFrame widgetFrame2 = getFrameCache().get(measurable);
                        Intrinsics.checkNotNull(widgetFrame2);
                        int i3 = widgetFrame2.left;
                        WidgetFrame widgetFrame3 = getFrameCache().get(measurable);
                        Intrinsics.checkNotNull(widgetFrame3);
                        int i4 = widgetFrame3.top;
                        Placeable placeable = getPlaceables().get(measurable);
                        if (placeable != null) {
                            Placeable.PlacementScope.m3178place70tqf50$default(placementScope, placeable, IntOffsetKt.IntOffset(i3, i4), 0.0f, 2, (Object) null);
                        }
                    } else {
                        Function1 measurer$performLayout$1$layerBlock$1 = new Measurer$performLayout$1$layerBlock$1(widgetFrame);
                        WidgetFrame widgetFrame4 = getFrameCache().get(measurable);
                        Intrinsics.checkNotNull(widgetFrame4);
                        int i5 = widgetFrame4.left;
                        WidgetFrame widgetFrame5 = getFrameCache().get(measurable);
                        Intrinsics.checkNotNull(widgetFrame5);
                        int i6 = widgetFrame5.top;
                        float f = Float.isNaN(widgetFrame.translationZ) ? 0.0f : widgetFrame.translationZ;
                        Placeable placeable2 = getPlaceables().get(measurable);
                        if (placeable2 != null) {
                            placementScope.placeWithLayer(placeable2, i5, i6, f, measurer$performLayout$1$layerBlock$1);
                        }
                    }
                    if (i2 > size) {
                        break;
                    }
                    i = i2;
                } else {
                    return;
                }
            }
        }
        LayoutInformationReceiver layoutInformationReceiver2 = this.layoutInformationReceiver;
        if ((layoutInformationReceiver2 == null ? null : layoutInformationReceiver2.getLayoutInformationMode()) == LayoutInfoFlags.BOUNDS) {
            computeLayoutResult();
        }
    }

    public final void drawDebugBounds(BoxScope boxScope, float f, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(boxScope, "<this>");
        Composer startRestartGroup = composer.startRestartGroup(-756996700);
        ComposerKt.sourceInformation(startRestartGroup, "C(drawDebugBounds)");
        CanvasKt.Canvas(boxScope.matchParentSize(Modifier.Companion), new Measurer$drawDebugBounds$1(this, f), startRestartGroup, 0);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Measurer$drawDebugBounds$2(this, boxScope, f, i));
        }
    }

    /* renamed from: getColor-wrIjXm8$default  reason: not valid java name */
    static /* synthetic */ long m4177getColorwrIjXm8$default(Measurer measurer, String str, long j, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                j = Color.Companion.m1622getBlack0d7_KjU();
            }
            return measurer.m4176getColorwrIjXm8(str, j);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getColor-wrIjXm8");
    }

    /* renamed from: getColor-wrIjXm8  reason: not valid java name */
    private final long m4176getColorwrIjXm8(String str, long j) {
        if (str != null && StringsKt.startsWith$default((CharSequence) str, '#', false, 2, (Object) null)) {
            String substring = str.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
            if (substring.length() == 6) {
                substring = Intrinsics.stringPlus("FF", substring);
            }
            try {
                return ColorKt.Color((int) Long.parseLong(substring, 16));
            } catch (Exception unused) {
            }
        }
        return j;
    }

    private final TextStyle getTextStyle(HashMap<String, String> hashMap) {
        HashMap<String, String> hashMap2 = hashMap;
        String str = hashMap2.get("size");
        long r2 = TextUnit.Companion.m4051getUnspecifiedXSAIIZE();
        if (str != null) {
            r2 = TextUnitKt.getSp(Float.parseFloat(str));
        }
        return new TextStyle(m4177getColorwrIjXm8$default(this, hashMap2.get("color"), 0, 2, (Object) null), r2, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 262140, (DefaultConstructorMarker) null);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void createDesignElements(androidx.compose.runtime.Composer r23, int r24) {
        /*
            r22 = this;
            r0 = r22
            r1 = -186577107(0xfffffffff4e10f2d, float:-1.4264827E32)
            r2 = r23
            androidx.compose.runtime.Composer r1 = r2.startRestartGroup(r1)
            java.lang.String r2 = "C(createDesignElements)"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r2)
            java.util.ArrayList<androidx.constraintlayout.compose.DesignElement> r2 = r0.designElements
            java.util.Iterator r21 = r2.iterator()
        L_0x0016:
            boolean r2 = r21.hasNext()
            if (r2 == 0) goto L_0x02dd
            java.lang.Object r2 = r21.next()
            androidx.constraintlayout.compose.DesignElement r2 = (androidx.constraintlayout.compose.DesignElement) r2
            java.lang.String r3 = r2.getId()
            androidx.constraintlayout.compose.DesignElements r4 = androidx.constraintlayout.compose.DesignElements.INSTANCE
            java.util.HashMap r4 = r4.getMap()
            java.lang.String r5 = r2.getType()
            java.lang.Object r4 = r4.get(r5)
            kotlin.jvm.functions.Function4 r4 = (kotlin.jvm.functions.Function4) r4
            if (r4 == 0) goto L_0x004f
            r5 = -186576910(0xfffffffff4e10ff2, float:-1.4265017E32)
            r1.startReplaceableGroup(r5)
            java.util.HashMap r2 = r2.getParams()
            r5 = 64
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r4.invoke(r3, r2, r1, r5)
            r1.endReplaceableGroup()
            goto L_0x0016
        L_0x004f:
            r4 = -186576844(0xfffffffff4e11034, float:-1.4265081E32)
            r1.startReplaceableGroup(r4)
            java.lang.String r4 = r2.getType()
            int r5 = r4.hashCode()
            r6 = 8
            java.lang.String r7 = "backgroundColor"
            r8 = 0
            java.lang.String r9 = "text"
            switch(r5) {
                case -1377687758: goto L_0x025b;
                case -1031434259: goto L_0x0214;
                case 97739: goto L_0x00df;
                case 3556653: goto L_0x009c;
                case 100313435: goto L_0x006a;
                default: goto L_0x0068;
            }
        L_0x0068:
            goto L_0x02cf
        L_0x006a:
            java.lang.String r2 = "image"
            boolean r2 = r4.equals(r2)
            if (r2 != 0) goto L_0x0074
            goto L_0x02cf
        L_0x0074:
            r2 = -186574977(0xfffffffff4e1177f, float:-1.4266887E32)
            r1.startReplaceableGroup(r2)
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            androidx.compose.ui.Modifier r4 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r2, r3)
            r2 = 17301567(0x108003f, float:2.4979432E-38)
            androidx.compose.ui.graphics.painter.Painter r2 = androidx.compose.ui.res.PainterResources_androidKt.painterResource(r2, r1, r8)
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r10 = 56
            r11 = 120(0x78, float:1.68E-43)
            java.lang.String r3 = "Placeholder Image"
            r9 = r1
            androidx.compose.foundation.ImageKt.Image((androidx.compose.ui.graphics.painter.Painter) r2, (java.lang.String) r3, (androidx.compose.ui.Modifier) r4, (androidx.compose.ui.Alignment) r5, (androidx.compose.ui.layout.ContentScale) r6, (float) r7, (androidx.compose.ui.graphics.ColorFilter) r8, (androidx.compose.runtime.Composer) r9, (int) r10, (int) r11)
            r1.endReplaceableGroup()
            goto L_0x02d8
        L_0x009c:
            boolean r4 = r4.equals(r9)
            if (r4 != 0) goto L_0x00a4
            goto L_0x02cf
        L_0x00a4:
            r4 = -186575591(0xfffffffff4e11519, float:-1.4266293E32)
            r1.startReplaceableGroup(r4)
            java.util.HashMap r4 = r2.getParams()
            java.lang.Object r4 = r4.get(r9)
            java.lang.String r4 = (java.lang.String) r4
            if (r4 != 0) goto L_0x00b7
            r4 = r9
        L_0x00b7:
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            androidx.compose.ui.Modifier r3 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r5, r3)
            java.util.HashMap r2 = r2.getParams()
            androidx.compose.ui.text.TextStyle r5 = r0.getTextStyle(r2)
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 32768(0x8000, float:4.5918E-41)
            r11 = 120(0x78, float:1.68E-43)
            r2 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r1
            androidx.compose.foundation.text.BasicTextKt.m628BasicTextBpD7jsM(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r1.endReplaceableGroup()
            goto L_0x02d8
        L_0x00df:
            java.lang.String r5 = "box"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x00e9
            goto L_0x02cf
        L_0x00e9:
            r4 = -186576210(0xfffffffff4e112ae, float:-1.4265694E32)
            r1.startReplaceableGroup(r4)
            java.util.HashMap r4 = r2.getParams()
            java.lang.Object r4 = r4.get(r9)
            java.lang.String r4 = (java.lang.String) r4
            if (r4 != 0) goto L_0x00fd
            java.lang.String r4 = ""
        L_0x00fd:
            java.util.HashMap r5 = r2.getParams()
            java.lang.Object r5 = r5.get(r7)
            java.lang.String r5 = (java.lang.String) r5
            androidx.compose.ui.graphics.Color$Companion r7 = androidx.compose.ui.graphics.Color.Companion
            long r9 = r7.m1628getLightGray0d7_KjU()
            long r12 = r0.m4176getColorwrIjXm8(r5, r9)
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            androidx.compose.ui.Modifier r11 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r5, r3)
            r14 = 0
            r15 = 2
            r16 = 0
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.BackgroundKt.m162backgroundbw27NRU$default(r11, r12, r14, r15, r16)
            r5 = -1990474327(0xffffffff895bc5a9, float:-2.6454105E-33)
            r1.startReplaceableGroup(r5)
            java.lang.String r5 = "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r5)
            androidx.compose.ui.Alignment$Companion r5 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r5 = r5.getTopStart()
            androidx.compose.ui.layout.MeasurePolicy r5 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r5, r8, r1, r8)
            r7 = 1376089335(0x520574f7, float:1.43298249E11)
            r1.startReplaceableGroup(r7)
            java.lang.String r7 = "C(Layout)P(!1,2)71@2788L7,72@2843L7,73@2855L389:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r7)
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            r9 = 103361330(0x6292b32, float:3.1817102E-35)
            java.lang.String r10 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r9, r10)
            java.lang.Object r7 = r1.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            androidx.compose.ui.unit.Density r7 = (androidx.compose.ui.unit.Density) r7
            androidx.compose.runtime.ProvidableCompositionLocal r11 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r1, r9, r10)
            java.lang.Object r9 = r1.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r1)
            androidx.compose.ui.unit.LayoutDirection r9 = (androidx.compose.ui.unit.LayoutDirection) r9
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r10 = r10.getConstructor()
            kotlin.jvm.functions.Function3 r3 = androidx.compose.ui.layout.LayoutKt.materializerOf(r3)
            androidx.compose.runtime.Applier r11 = r1.getApplier()
            boolean r11 = r11 instanceof androidx.compose.runtime.Applier
            if (r11 != 0) goto L_0x017f
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x017f:
            r1.startReusableNode()
            boolean r11 = r1.getInserting()
            if (r11 == 0) goto L_0x018c
            r1.createNode(r10)
            goto L_0x018f
        L_0x018c:
            r1.useNode()
        L_0x018f:
            r1.disableReusing()
            androidx.compose.runtime.Composer r10 = androidx.compose.runtime.Updater.m1234constructorimpl(r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r10, r5, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetDensity()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r10, r7, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r10, r9, r5)
            r1.enableReusing()
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.SkippableUpdater.m1226constructorimpl(r1)
            androidx.compose.runtime.SkippableUpdater r5 = androidx.compose.runtime.SkippableUpdater.m1225boximpl(r5)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r8)
            r3.invoke(r5, r1, r7)
            r3 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r1.startReplaceableGroup(r3)
            r3 = -1253629305(0xffffffffb5472287, float:-7.418352E-7)
            r1.startReplaceableGroup(r3)
            java.lang.String r3 = "C72@3384L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r3)
            androidx.compose.foundation.layout.BoxScopeInstance r3 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r3 = (androidx.compose.foundation.layout.BoxScope) r3
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            float r5 = (float) r6
            float r5 = androidx.compose.ui.unit.Dp.m3859constructorimpl(r5)
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.PaddingKt.m431padding3ABfNKs(r3, r5)
            java.util.HashMap r2 = r2.getParams()
            androidx.compose.ui.text.TextStyle r5 = r0.getTextStyle(r2)
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 32816(0x8030, float:4.5985E-41)
            r11 = 120(0x78, float:1.68E-43)
            r2 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r1
            androidx.compose.foundation.text.BasicTextKt.m628BasicTextBpD7jsM(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r1.endReplaceableGroup()
            r1.endReplaceableGroup()
            r1.endNode()
            r1.endReplaceableGroup()
            r1.endReplaceableGroup()
            r1.endReplaceableGroup()
            goto L_0x02d8
        L_0x0214:
            java.lang.String r5 = "textfield"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x021f
            goto L_0x02cf
        L_0x021f:
            r4 = -186575317(0xfffffffff4e1162b, float:-1.4266558E32)
            r1.startReplaceableGroup(r4)
            java.util.HashMap r2 = r2.getParams()
            java.lang.Object r2 = r2.get(r9)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 != 0) goto L_0x0232
            r2 = r9
        L_0x0232:
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            androidx.compose.ui.Modifier r4 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r4, r3)
            androidx.constraintlayout.compose.Measurer$createDesignElements$2 r3 = androidx.constraintlayout.compose.Measurer$createDesignElements$2.INSTANCE
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r18 = 0
            r19 = 0
            r20 = 32760(0x7ff8, float:4.5907E-41)
            r17 = r1
            androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField((java.lang.String) r2, (kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit>) r3, (androidx.compose.ui.Modifier) r4, (boolean) r5, (boolean) r6, (androidx.compose.ui.text.TextStyle) r7, (androidx.compose.foundation.text.KeyboardOptions) r8, (androidx.compose.foundation.text.KeyboardActions) r9, (boolean) r10, (int) r11, (androidx.compose.ui.text.input.VisualTransformation) r12, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit>) r13, (androidx.compose.foundation.interaction.MutableInteractionSource) r14, (androidx.compose.ui.graphics.Brush) r15, (kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r16, (androidx.compose.runtime.Composer) r17, (int) r18, (int) r19, (int) r20)
            r1.endReplaceableGroup()
            goto L_0x02d8
        L_0x025b:
            java.lang.String r5 = "button"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0265
            goto L_0x02cf
        L_0x0265:
            r4 = -186576772(0xfffffffff4e1107c, float:-1.4265151E32)
            r1.startReplaceableGroup(r4)
            java.util.HashMap r4 = r2.getParams()
            java.lang.Object r4 = r4.get(r9)
            java.lang.String r4 = (java.lang.String) r4
            if (r4 != 0) goto L_0x0278
            r4 = r9
        L_0x0278:
            java.util.HashMap r5 = r2.getParams()
            java.lang.Object r5 = r5.get(r7)
            java.lang.String r5 = (java.lang.String) r5
            androidx.compose.ui.graphics.Color$Companion r7 = androidx.compose.ui.graphics.Color.Companion
            long r7 = r7.m1628getLightGray0d7_KjU()
            long r10 = r0.m4176getColorwrIjXm8(r5, r7)
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            androidx.compose.ui.Modifier r3 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r5, r3)
            r5 = 20
            androidx.compose.foundation.shape.RoundedCornerShape r5 = androidx.compose.foundation.shape.RoundedCornerShapeKt.RoundedCornerShape((int) r5)
            androidx.compose.ui.graphics.Shape r5 = (androidx.compose.ui.graphics.Shape) r5
            androidx.compose.ui.Modifier r9 = androidx.compose.ui.draw.ClipKt.clip(r3, r5)
            r12 = 0
            r13 = 2
            r14 = 0
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.BackgroundKt.m162backgroundbw27NRU$default(r9, r10, r12, r13, r14)
            float r5 = (float) r6
            float r5 = androidx.compose.ui.unit.Dp.m3859constructorimpl(r5)
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.PaddingKt.m431padding3ABfNKs(r3, r5)
            java.util.HashMap r2 = r2.getParams()
            androidx.compose.ui.text.TextStyle r5 = r0.getTextStyle(r2)
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 32768(0x8000, float:4.5918E-41)
            r11 = 120(0x78, float:1.68E-43)
            r2 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r1
            androidx.compose.foundation.text.BasicTextKt.m628BasicTextBpD7jsM(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r1.endReplaceableGroup()
            goto L_0x02d8
        L_0x02cf:
            r2 = -186574652(0xfffffffff4e118c4, float:-1.4267201E32)
            r1.startReplaceableGroup(r2)
            r1.endReplaceableGroup()
        L_0x02d8:
            r1.endReplaceableGroup()
            goto L_0x0016
        L_0x02dd:
            androidx.compose.runtime.ScopeUpdateScope r1 = r1.endRestartGroup()
            if (r1 != 0) goto L_0x02e4
            goto L_0x02f0
        L_0x02e4:
            androidx.constraintlayout.compose.Measurer$createDesignElements$3 r2 = new androidx.constraintlayout.compose.Measurer$createDesignElements$3
            r3 = r24
            r2.<init>(r0, r3)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r1.updateScope(r2)
        L_0x02f0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.compose.Measurer.createDesignElements(androidx.compose.runtime.Composer, int):void");
    }

    public final void parseDesignElements(ConstraintSet constraintSet) {
        Intrinsics.checkNotNullParameter(constraintSet, "constraintSet");
        if (constraintSet instanceof JSONConstraintSet) {
            ((JSONConstraintSet) constraintSet).emitDesignElements(this.designElements);
        }
    }
}
