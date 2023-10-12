package androidx.constraintlayout.compose;

import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.parser.CLArray;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLKey;
import androidx.constraintlayout.core.parser.CLNumber;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParser;
import androidx.constraintlayout.core.parser.CLParsingException;
import androidx.constraintlayout.core.parser.CLString;
import androidx.constraintlayout.core.state.ConstraintReference;
import androidx.constraintlayout.core.state.Dimension;
import androidx.constraintlayout.core.state.State;
import androidx.constraintlayout.core.state.Transition;
import androidx.constraintlayout.core.state.helpers.BarrierReference;
import androidx.constraintlayout.core.state.helpers.Facade;
import androidx.constraintlayout.core.state.helpers.GuidelineReference;
import com.braintreepayments.api.models.PostalAddressParser;
import com.facebook.react.uimanager.ViewProps;
import com.nimbusds.jose.HeaderParameterNames;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

@Metadata(d1 = {"\u0000l\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\u001a\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0005H\u0000\u001a \u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a(\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0000\u001a\u0017\u0010\u0016\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0017\u001a\u00020\u0003H\u0002¢\u0006\u0002\u0010\u0018\u001a0\u0010\u0019\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0003H\u0002\u001a\u0018\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0000\u001a \u0010#\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0003H\u0002\u001a(\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00032\u0016\u0010&\u001a\u0012\u0012\u0004\u0012\u00020(0'j\b\u0012\u0004\u0012\u00020(`)H\u0000\u001a \u0010*\u001a\u00020+2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0002\u001a\u0010\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020\u0003H\u0002\u001a \u0010.\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"H\u0000\u001a \u0010/\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0000\u001a(\u00100\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\r2\u0006\u00101\u001a\u00020\u00032\u0006\u00102\u001a\u00020\u0005H\u0002\u001a\u0018\u00103\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0000\u001a \u00104\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\"H\u0000\u001a \u00105\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0013H\u0000\u001a \u00105\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00032\u0006\u00106\u001a\u0002072\u0006\u0010\f\u001a\u00020\u0011H\u0000\u001a\u0018\u00108\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u00052\u0006\u00106\u001a\u000207H\u0000\u001a\u0018\u0010:\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u00052\u0006\u00106\u001a\u000207H\u0000\u001a\u0018\u0010<\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u00052\u0006\u00106\u001a\u000207H\u0000\u001a\u0018\u0010>\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010%\u001a\u00020\u0003H\u0000\u001a\u0018\u0010?\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00052\u0006\u00106\u001a\u000207H\u0000\u001a\u0018\u0010@\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0000\u001a \u0010A\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"H\u0000\u001a(\u0010B\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"PARSER_DEBUG", "", "lookForType", "", "element", "Landroidx/constraintlayout/core/parser/CLObject;", "override", "", "baseJson", "name", "overrideValue", "parseBarrier", "state", "Landroidx/constraintlayout/compose/State;", "elementName", "parseChain", "orientation", "", "margins", "Landroidx/constraintlayout/compose/LayoutVariables;", "helper", "Landroidx/constraintlayout/core/parser/CLArray;", "parseColorString", "value", "(Ljava/lang/String;)Ljava/lang/Integer;", "parseConstraint", "layoutVariables", "reference", "Landroidx/constraintlayout/core/state/ConstraintReference;", "constraintName", "parseConstraintSets", "scene", "Landroidx/constraintlayout/compose/MotionScene;", "json", "", "parseCustomProperties", "parseDesignElementsJSON", "content", "list", "Ljava/util/ArrayList;", "Landroidx/constraintlayout/compose/DesignElement;", "Lkotlin/collections/ArrayList;", "parseDimension", "Landroidx/constraintlayout/core/state/Dimension;", "parseDimensionMode", "dimensionString", "parseGenerate", "parseGuideline", "parseGuidelineParams", "guidelineId", "params", "parseHeader", "parseHelpers", "parseJSON", "transition", "Landroidx/constraintlayout/core/state/Transition;", "parseKeyAttribute", "keyAttribute", "parseKeyCycle", "keyCycleData", "parseKeyPosition", "keyPosition", "parseMotionSceneJSON", "parseTransition", "parseTransitions", "parseVariables", "parseWidget", "compose_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* compiled from: ConstraintSetParser.kt */
public final class ConstraintSetParserKt {
    public static final boolean PARSER_DEBUG = false;

    public static final void parseTransition(CLObject cLObject, Transition transition) {
        boolean z;
        Intrinsics.checkNotNullParameter(cLObject, "json");
        Intrinsics.checkNotNullParameter(transition, "transition");
        String stringOrNull = cLObject.getStringOrNull(TypedValues.TransitionType.S_PATH_MOTION_ARC);
        TypedBundle typedBundle = new TypedBundle();
        boolean z2 = true;
        if (stringOrNull != null) {
            switch (stringOrNull.hashCode()) {
                case -1857024520:
                    if (stringOrNull.equals("startVertical")) {
                        typedBundle.add(509, 1);
                        break;
                    }
                    break;
                case -1007052250:
                    if (stringOrNull.equals("startHorizontal")) {
                        typedBundle.add(509, 2);
                        break;
                    }
                    break;
                case 3145837:
                    if (stringOrNull.equals("flip")) {
                        typedBundle.add(509, 3);
                        break;
                    }
                    break;
                case 3387192:
                    if (stringOrNull.equals(ViewProps.NONE)) {
                        typedBundle.add(509, 0);
                        break;
                    }
                    break;
            }
            z = true;
        } else {
            z = false;
        }
        String stringOrNull2 = cLObject.getStringOrNull("interpolator");
        if (stringOrNull2 != null) {
            typedBundle.add((int) TypedValues.TransitionType.TYPE_INTERPOLATOR, stringOrNull2);
            z = true;
        }
        float floatOrNaN = cLObject.getFloatOrNaN(TypedValues.TransitionType.S_STAGGERED);
        if (!Float.isNaN(floatOrNaN)) {
            typedBundle.add((int) TypedValues.TransitionType.TYPE_STAGGERED, floatOrNaN);
        } else {
            z2 = z;
        }
        if (z2) {
            transition.setTransitionProperties(typedBundle);
        }
        CLObject objectOrNull = cLObject.getObjectOrNull("KeyFrames");
        if (objectOrNull != null) {
            CLArray arrayOrNull = objectOrNull.getArrayOrNull("KeyPositions");
            if (arrayOrNull != null) {
                Iterator it = RangesKt.until(0, arrayOrNull.size()).iterator();
                while (it.hasNext()) {
                    CLElement cLElement = arrayOrNull.get(((IntIterator) it).nextInt());
                    if (cLElement instanceof CLObject) {
                        parseKeyPosition((CLObject) cLElement, transition);
                    }
                }
            }
            CLArray arrayOrNull2 = objectOrNull.getArrayOrNull(TypedValues.AttributesType.NAME);
            if (arrayOrNull2 != null) {
                Iterator it2 = RangesKt.until(0, arrayOrNull2.size()).iterator();
                while (it2.hasNext()) {
                    CLElement cLElement2 = arrayOrNull2.get(((IntIterator) it2).nextInt());
                    if (cLElement2 instanceof CLObject) {
                        parseKeyAttribute((CLObject) cLElement2, transition);
                    }
                }
            }
            CLArray arrayOrNull3 = objectOrNull.getArrayOrNull("KeyCycles");
            if (arrayOrNull3 != null) {
                Iterator it3 = RangesKt.until(0, arrayOrNull3.size()).iterator();
                while (it3.hasNext()) {
                    CLElement cLElement3 = arrayOrNull3.get(((IntIterator) it3).nextInt());
                    if (cLElement3 instanceof CLObject) {
                        parseKeyCycle((CLObject) cLElement3, transition);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x014a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void parseKeyPosition(androidx.constraintlayout.core.parser.CLObject r19, androidx.constraintlayout.core.state.Transition r20) {
        /*
            r0 = r19
            r1 = r20
            java.lang.String r2 = "keyPosition"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            java.lang.String r2 = "transition"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            androidx.constraintlayout.core.motion.utils.TypedBundle r2 = new androidx.constraintlayout.core.motion.utils.TypedBundle
            r2.<init>()
            java.lang.String r3 = "target"
            androidx.constraintlayout.core.parser.CLArray r3 = r0.getArray((java.lang.String) r3)
            java.lang.String r4 = "frames"
            androidx.constraintlayout.core.parser.CLArray r4 = r0.getArray((java.lang.String) r4)
            java.lang.String r5 = "percentX"
            androidx.constraintlayout.core.parser.CLArray r5 = r0.getArrayOrNull(r5)
            java.lang.String r6 = "percentY"
            androidx.constraintlayout.core.parser.CLArray r6 = r0.getArrayOrNull(r6)
            java.lang.String r7 = "percentWidth"
            androidx.constraintlayout.core.parser.CLArray r7 = r0.getArrayOrNull(r7)
            java.lang.String r8 = "percentHeight"
            androidx.constraintlayout.core.parser.CLArray r8 = r0.getArrayOrNull(r8)
            java.lang.String r9 = "pathMotionArc"
            java.lang.String r9 = r0.getStringOrNull((java.lang.String) r9)
            java.lang.String r10 = "transitionEasing"
            java.lang.String r10 = r0.getStringOrNull((java.lang.String) r10)
            java.lang.String r11 = "curveFit"
            java.lang.String r11 = r0.getStringOrNull((java.lang.String) r11)
            java.lang.String r12 = "type"
            java.lang.String r0 = r0.getStringOrNull((java.lang.String) r12)
            java.lang.String r12 = "parentRelative"
            if (r0 != 0) goto L_0x0058
            r0 = r12
        L_0x0058:
            if (r5 == 0) goto L_0x0065
            int r13 = r4.size()
            int r14 = r5.size()
            if (r13 == r14) goto L_0x0065
            return
        L_0x0065:
            if (r6 == 0) goto L_0x0072
            int r13 = r4.size()
            int r14 = r6.size()
            if (r13 == r14) goto L_0x0072
            return
        L_0x0072:
            int r13 = r3.size()
            r14 = 0
            kotlin.ranges.IntRange r13 = kotlin.ranges.RangesKt.until((int) r14, (int) r13)
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.util.Iterator r13 = r13.iterator()
        L_0x0081:
            boolean r15 = r13.hasNext()
            if (r15 == 0) goto L_0x0196
            r15 = r13
            kotlin.collections.IntIterator r15 = (kotlin.collections.IntIterator) r15
            int r15 = r15.nextInt()
            java.lang.String r15 = r3.getString((int) r15)
            r2.clear()
            int r14 = r0.hashCode()
            r17 = r3
            r3 = -1740452335(0xffffffff9842ce11, float:-2.517795E-24)
            r18 = r13
            r13 = 1
            if (r14 == r3) goto L_0x00be
            r3 = -960240988(0xffffffffc6c3e2a4, float:-25073.32)
            if (r14 == r3) goto L_0x00b7
            r3 = 1700994454(0x65631d96, float:6.7032685E22)
            if (r14 == r3) goto L_0x00ae
            goto L_0x00c6
        L_0x00ae:
            boolean r3 = r0.equals(r12)
            if (r3 != 0) goto L_0x00b5
            goto L_0x00c6
        L_0x00b5:
            r3 = 2
            goto L_0x00c7
        L_0x00b7:
            java.lang.String r3 = "deltaRelative"
            boolean r3 = r0.equals(r3)
            goto L_0x00c6
        L_0x00be:
            java.lang.String r3 = "pathRelative"
            boolean r3 = r0.equals(r3)
            if (r3 != 0) goto L_0x00ca
        L_0x00c6:
            r3 = 0
        L_0x00c7:
            r14 = 510(0x1fe, float:7.15E-43)
            goto L_0x00cc
        L_0x00ca:
            r3 = 1
            goto L_0x00c7
        L_0x00cc:
            r2.add((int) r14, (int) r3)
            if (r11 == 0) goto L_0x00ec
            java.lang.String r3 = "spline"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r3)
            r14 = 508(0x1fc, float:7.12E-43)
            if (r3 == 0) goto L_0x00e1
            r3 = 0
            r2.add((int) r14, (int) r3)
            goto L_0x00ec
        L_0x00e1:
            java.lang.String r3 = "linear"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x00ec
            r2.add((int) r14, (int) r13)
        L_0x00ec:
            r3 = 501(0x1f5, float:7.02E-43)
            r2.addIfNotNull(r3, r10)
            if (r9 == 0) goto L_0x0135
            int r3 = r9.hashCode()
            r14 = 509(0x1fd, float:7.13E-43)
            switch(r3) {
                case -1857024520: goto L_0x0128;
                case -1007052250: goto L_0x0119;
                case 3145837: goto L_0x010b;
                case 3387192: goto L_0x00fd;
                default: goto L_0x00fc;
            }
        L_0x00fc:
            goto L_0x0135
        L_0x00fd:
            java.lang.String r3 = "none"
            boolean r3 = r9.equals(r3)
            if (r3 != 0) goto L_0x0106
            goto L_0x0135
        L_0x0106:
            r3 = 0
            r2.add((int) r14, (int) r3)
            goto L_0x0135
        L_0x010b:
            java.lang.String r3 = "flip"
            boolean r3 = r9.equals(r3)
            if (r3 != 0) goto L_0x0114
            goto L_0x0135
        L_0x0114:
            r3 = 3
            r2.add((int) r14, (int) r3)
            goto L_0x0135
        L_0x0119:
            java.lang.String r3 = "startHorizontal"
            boolean r3 = r9.equals(r3)
            if (r3 != 0) goto L_0x0123
            goto L_0x0135
        L_0x0123:
            r3 = 2
            r2.add((int) r14, (int) r3)
            goto L_0x0135
        L_0x0128:
            java.lang.String r3 = "startVertical"
            boolean r3 = r9.equals(r3)
            if (r3 != 0) goto L_0x0132
            goto L_0x0135
        L_0x0132:
            r2.add((int) r14, (int) r13)
        L_0x0135:
            int r3 = r4.size()
            r13 = 0
            kotlin.ranges.IntRange r3 = kotlin.ranges.RangesKt.until((int) r13, (int) r3)
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r3 = r3.iterator()
        L_0x0144:
            boolean r14 = r3.hasNext()
            if (r14 == 0) goto L_0x018f
            r14 = r3
            kotlin.collections.IntIterator r14 = (kotlin.collections.IntIterator) r14
            int r14 = r14.nextInt()
            int r13 = r4.getInt((int) r14)
            r16 = r0
            r0 = 100
            r2.add((int) r0, (int) r13)
            if (r5 == 0) goto L_0x0167
            r0 = 506(0x1fa, float:7.09E-43)
            float r13 = r5.getFloat((int) r14)
            r2.add((int) r0, (float) r13)
        L_0x0167:
            if (r6 == 0) goto L_0x0172
            r0 = 507(0x1fb, float:7.1E-43)
            float r13 = r6.getFloat((int) r14)
            r2.add((int) r0, (float) r13)
        L_0x0172:
            if (r7 == 0) goto L_0x017d
            r0 = 503(0x1f7, float:7.05E-43)
            float r13 = r7.getFloat((int) r14)
            r2.add((int) r0, (float) r13)
        L_0x017d:
            if (r8 == 0) goto L_0x0188
            r0 = 504(0x1f8, float:7.06E-43)
            float r13 = r8.getFloat((int) r14)
            r2.add((int) r0, (float) r13)
        L_0x0188:
            r1.addKeyPosition(r15, r2)
            r0 = r16
            r13 = 0
            goto L_0x0144
        L_0x018f:
            r3 = r17
            r13 = r18
            r14 = 0
            goto L_0x0081
        L_0x0196:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.compose.ConstraintSetParserKt.parseKeyPosition(androidx.constraintlayout.core.parser.CLObject, androidx.constraintlayout.core.state.Transition):void");
    }

    public static final void parseKeyAttribute(CLObject cLObject, Transition transition) {
        CLArray arrayOrNull;
        CLObject cLObject2 = cLObject;
        Transition transition2 = transition;
        Intrinsics.checkNotNullParameter(cLObject2, "keyAttribute");
        Intrinsics.checkNotNullParameter(transition2, "transition");
        CLArray arrayOrNull2 = cLObject2.getArrayOrNull("target");
        if (arrayOrNull2 != null && (arrayOrNull = cLObject2.getArrayOrNull("frames")) != null) {
            String stringOrNull = cLObject2.getStringOrNull("transitionEasing");
            ArrayList arrayListOf = CollectionsKt.arrayListOf("scaleX", "scaleY", "translationX", "translationY", "translationZ", "rotationX", "rotationY", "rotationZ", "alpha");
            ArrayList arrayListOf2 = CollectionsKt.arrayListOf(311, 312, 304, 305, 306, 308, 309, 310, 303);
            ArrayList arrayList = new ArrayList();
            Iterator it = RangesKt.until(0, arrayOrNull.size()).iterator();
            while (it.hasNext()) {
                ((IntIterator) it).nextInt();
                arrayList.add(new TypedBundle());
            }
            int size = arrayListOf.size();
            if (size > 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    Object obj = arrayListOf.get(i);
                    Intrinsics.checkNotNullExpressionValue(obj, "attrNames[k]");
                    String str = (String) obj;
                    Object obj2 = arrayListOf2.get(i);
                    Intrinsics.checkNotNullExpressionValue(obj2, "attrIds[k]");
                    int intValue = ((Number) obj2).intValue();
                    CLArray arrayOrNull3 = cLObject2.getArrayOrNull(str);
                    if (arrayOrNull3 == null || arrayOrNull3.size() == arrayList.size()) {
                        if (arrayOrNull3 != null) {
                            Iterator it2 = RangesKt.until(0, arrayList.size()).iterator();
                            while (it2.hasNext()) {
                                int nextInt = ((IntIterator) it2).nextInt();
                                ((TypedBundle) arrayList.get(nextInt)).add(intValue, arrayOrNull3.getFloat(nextInt));
                            }
                        } else {
                            float floatOrNaN = cLObject2.getFloatOrNaN(str);
                            if (!Float.isNaN(floatOrNaN)) {
                                Iterator it3 = RangesKt.until(0, arrayList.size()).iterator();
                                while (it3.hasNext()) {
                                    ((TypedBundle) arrayList.get(((IntIterator) it3).nextInt())).add(intValue, floatOrNaN);
                                }
                            }
                        }
                        if (i2 >= size) {
                            break;
                        }
                        i = i2;
                    } else {
                        throw new CLParsingException("incorrect size for " + str + " array, not matching targets array!", cLObject2);
                    }
                }
            }
            String stringOrNull2 = cLObject2.getStringOrNull("curveFit");
            Iterator it4 = RangesKt.until(0, arrayOrNull2.size()).iterator();
            while (it4.hasNext()) {
                int nextInt2 = ((IntIterator) it4).nextInt();
                Iterator it5 = RangesKt.until(0, arrayList.size()).iterator();
                while (it5.hasNext()) {
                    int nextInt3 = ((IntIterator) it5).nextInt();
                    String string = arrayOrNull2.getString(nextInt2);
                    Object obj3 = arrayList.get(nextInt3);
                    Intrinsics.checkNotNullExpressionValue(obj3, "bundles[j]");
                    TypedBundle typedBundle = (TypedBundle) obj3;
                    if (stringOrNull2 != null) {
                        if (Intrinsics.areEqual((Object) stringOrNull2, (Object) "spline")) {
                            typedBundle.add((int) TypedValues.PositionType.TYPE_CURVE_FIT, 0);
                        } else if (Intrinsics.areEqual((Object) stringOrNull2, (Object) "linear")) {
                            typedBundle.add((int) TypedValues.PositionType.TYPE_CURVE_FIT, 1);
                            typedBundle.addIfNotNull(TypedValues.PositionType.TYPE_TRANSITION_EASING, stringOrNull);
                            typedBundle.add(100, arrayOrNull.getInt(nextInt3));
                            transition2.addKeyAttribute(string, typedBundle);
                        }
                    }
                    typedBundle.addIfNotNull(TypedValues.PositionType.TYPE_TRANSITION_EASING, stringOrNull);
                    typedBundle.add(100, arrayOrNull.getInt(nextInt3));
                    transition2.addKeyAttribute(string, typedBundle);
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x0227  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x022e  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0235  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x023a A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void parseKeyCycle(androidx.constraintlayout.core.parser.CLObject r18, androidx.constraintlayout.core.state.Transition r19) {
        /*
            r0 = r18
            r1 = r19
            java.lang.String r2 = "keyCycleData"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            java.lang.String r2 = "transition"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            java.lang.String r2 = "target"
            androidx.constraintlayout.core.parser.CLArray r2 = r0.getArray((java.lang.String) r2)
            java.lang.String r3 = "frames"
            androidx.constraintlayout.core.parser.CLArray r3 = r0.getArray((java.lang.String) r3)
            java.lang.String r4 = "transitionEasing"
            java.lang.String r4 = r0.getStringOrNull((java.lang.String) r4)
            java.lang.String r5 = "scaleX"
            java.lang.String r6 = "scaleY"
            java.lang.String r7 = "translationX"
            java.lang.String r8 = "translationY"
            java.lang.String r9 = "translationZ"
            java.lang.String r10 = "rotationX"
            java.lang.String r11 = "rotationY"
            java.lang.String r12 = "rotationZ"
            java.lang.String r13 = "alpha"
            java.lang.String r14 = "period"
            java.lang.String r15 = "offset"
            java.lang.String r16 = "phase"
            java.lang.String[] r5 = new java.lang.String[]{r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16}
            java.util.ArrayList r5 = kotlin.collections.CollectionsKt.arrayListOf(r5)
            r6 = 12
            java.lang.Integer[] r6 = new java.lang.Integer[r6]
            r7 = 311(0x137, float:4.36E-43)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r8 = 0
            r6[r8] = r7
            r7 = 312(0x138, float:4.37E-43)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r9 = 1
            r6[r9] = r7
            r7 = 304(0x130, float:4.26E-43)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r10 = 2
            r6[r10] = r7
            r7 = 305(0x131, float:4.27E-43)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r10 = 3
            r6[r10] = r7
            r7 = 306(0x132, float:4.29E-43)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r10 = 4
            r6[r10] = r7
            r7 = 308(0x134, float:4.32E-43)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r10 = 5
            r6[r10] = r7
            r7 = 309(0x135, float:4.33E-43)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r10 = 6
            r6[r10] = r7
            r7 = 310(0x136, float:4.34E-43)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r10 = 7
            r6[r10] = r7
            r7 = 403(0x193, float:5.65E-43)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r10 = 8
            r6[r10] = r7
            r7 = 423(0x1a7, float:5.93E-43)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r10 = 9
            r6[r10] = r7
            r7 = 424(0x1a8, float:5.94E-43)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r10 = 10
            r6[r10] = r7
            r7 = 425(0x1a9, float:5.96E-43)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r10 = 11
            r6[r10] = r7
            java.util.ArrayList r6 = kotlin.collections.CollectionsKt.arrayListOf(r6)
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            int r10 = r3.size()
            kotlin.ranges.IntRange r10 = kotlin.ranges.RangesKt.until((int) r8, (int) r10)
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.Iterator r10 = r10.iterator()
        L_0x00d1:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x00e6
            r11 = r10
            kotlin.collections.IntIterator r11 = (kotlin.collections.IntIterator) r11
            r11.nextInt()
            androidx.constraintlayout.core.motion.utils.TypedBundle r11 = new androidx.constraintlayout.core.motion.utils.TypedBundle
            r11.<init>()
            r7.add(r11)
            goto L_0x00d1
        L_0x00e6:
            int r10 = r5.size()
            int r10 = r10 - r9
            if (r10 < 0) goto L_0x019d
            r11 = 0
        L_0x00ee:
            int r12 = r11 + 1
            java.lang.Object r13 = r5.get(r11)
            java.lang.String r14 = "attrNames[k]"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r14)
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r14 = r6.get(r11)
            java.lang.String r15 = "attrIds[k]"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r15)
            java.lang.Number r14 = (java.lang.Number) r14
            int r14 = r14.intValue()
            androidx.constraintlayout.core.parser.CLArray r15 = r0.getArrayOrNull(r13)
            if (r15 == 0) goto L_0x0139
            int r9 = r15.size()
            int r8 = r7.size()
            if (r9 != r8) goto L_0x011b
            goto L_0x0139
        L_0x011b:
            androidx.constraintlayout.core.parser.CLParsingException r1 = new androidx.constraintlayout.core.parser.CLParsingException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "incorrect size for "
            r2.append(r3)
            r2.append(r13)
            java.lang.String r3 = " array, not matching targets array!"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            androidx.constraintlayout.core.parser.CLElement r0 = (androidx.constraintlayout.core.parser.CLElement) r0
            r1.<init>(r2, r0)
            throw r1
        L_0x0139:
            if (r15 == 0) goto L_0x0165
            int r8 = r7.size()
            r9 = 0
            kotlin.ranges.IntRange r8 = kotlin.ranges.RangesKt.until((int) r9, (int) r8)
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r8 = r8.iterator()
        L_0x014a:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x0195
            r9 = r8
            kotlin.collections.IntIterator r9 = (kotlin.collections.IntIterator) r9
            int r9 = r9.nextInt()
            java.lang.Object r13 = r7.get(r9)
            androidx.constraintlayout.core.motion.utils.TypedBundle r13 = (androidx.constraintlayout.core.motion.utils.TypedBundle) r13
            float r9 = r15.getFloat((int) r9)
            r13.add((int) r14, (float) r9)
            goto L_0x014a
        L_0x0165:
            float r8 = r0.getFloatOrNaN(r13)
            boolean r9 = java.lang.Float.isNaN(r8)
            if (r9 != 0) goto L_0x0195
            int r9 = r7.size()
            r13 = 0
            kotlin.ranges.IntRange r9 = kotlin.ranges.RangesKt.until((int) r13, (int) r9)
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.Iterator r9 = r9.iterator()
        L_0x017e:
            boolean r13 = r9.hasNext()
            if (r13 == 0) goto L_0x0195
            r13 = r9
            kotlin.collections.IntIterator r13 = (kotlin.collections.IntIterator) r13
            int r13 = r13.nextInt()
            java.lang.Object r13 = r7.get(r13)
            androidx.constraintlayout.core.motion.utils.TypedBundle r13 = (androidx.constraintlayout.core.motion.utils.TypedBundle) r13
            r13.add((int) r14, (float) r8)
            goto L_0x017e
        L_0x0195:
            if (r11 != r10) goto L_0x0198
            goto L_0x019d
        L_0x0198:
            r11 = r12
            r8 = 0
            r9 = 1
            goto L_0x00ee
        L_0x019d:
            java.lang.String r5 = "curveFit"
            java.lang.String r5 = r0.getStringOrNull((java.lang.String) r5)
            java.lang.String r6 = "easing"
            java.lang.String r6 = r0.getStringOrNull((java.lang.String) r6)
            java.lang.String r8 = "waveShape"
            java.lang.String r8 = r0.getStringOrNull((java.lang.String) r8)
            java.lang.String r9 = "customWave"
            java.lang.String r0 = r0.getStringOrNull((java.lang.String) r9)
            int r9 = r2.size()
            r10 = 0
            kotlin.ranges.IntRange r9 = kotlin.ranges.RangesKt.until((int) r10, (int) r9)
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.Iterator r9 = r9.iterator()
        L_0x01c5:
            boolean r11 = r9.hasNext()
            if (r11 == 0) goto L_0x024c
            r11 = r9
            kotlin.collections.IntIterator r11 = (kotlin.collections.IntIterator) r11
            int r11 = r11.nextInt()
            int r12 = r7.size()
            kotlin.ranges.IntRange r12 = kotlin.ranges.RangesKt.until((int) r10, (int) r12)
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.util.Iterator r10 = r12.iterator()
        L_0x01e0:
            boolean r12 = r10.hasNext()
            if (r12 == 0) goto L_0x0249
            r12 = r10
            kotlin.collections.IntIterator r12 = (kotlin.collections.IntIterator) r12
            int r12 = r12.nextInt()
            java.lang.String r13 = r2.getString((int) r11)
            java.lang.Object r14 = r7.get(r12)
            java.lang.String r15 = "bundles.get(j)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r15)
            androidx.constraintlayout.core.motion.utils.TypedBundle r14 = (androidx.constraintlayout.core.motion.utils.TypedBundle) r14
            if (r5 == 0) goto L_0x021d
            java.lang.String r15 = "spline"
            boolean r15 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r15)
            r17 = r2
            r2 = 401(0x191, float:5.62E-43)
            if (r15 == 0) goto L_0x0210
            r15 = 0
            r14.add((int) r2, (int) r15)
            goto L_0x021f
        L_0x0210:
            java.lang.String r15 = "linear"
            boolean r15 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r15)
            if (r15 == 0) goto L_0x021f
            r15 = 1
            r14.add((int) r2, (int) r15)
            goto L_0x0220
        L_0x021d:
            r17 = r2
        L_0x021f:
            r15 = 1
        L_0x0220:
            r2 = 501(0x1f5, float:7.02E-43)
            r14.addIfNotNull(r2, r4)
            if (r6 == 0) goto L_0x022c
            r2 = 420(0x1a4, float:5.89E-43)
            r14.add((int) r2, (java.lang.String) r6)
        L_0x022c:
            if (r8 == 0) goto L_0x0233
            r2 = 421(0x1a5, float:5.9E-43)
            r14.add((int) r2, (java.lang.String) r8)
        L_0x0233:
            if (r0 == 0) goto L_0x023a
            r2 = 422(0x1a6, float:5.91E-43)
            r14.add((int) r2, (java.lang.String) r0)
        L_0x023a:
            int r2 = r3.getInt((int) r12)
            r12 = 100
            r14.add((int) r12, (int) r2)
            r1.addKeyCycle(r13, r14)
            r2 = r17
            goto L_0x01e0
        L_0x0249:
            r10 = 0
            goto L_0x01c5
        L_0x024c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.compose.ConstraintSetParserKt.parseKeyCycle(androidx.constraintlayout.core.parser.CLObject, androidx.constraintlayout.core.state.Transition):void");
    }

    public static final void parseJSON(String str, Transition transition, int i) {
        CLObject objectOrNull;
        Intrinsics.checkNotNullParameter(str, "content");
        Intrinsics.checkNotNullParameter(transition, "transition");
        try {
            CLObject parse = CLParser.parse(str);
            ArrayList<String> names = parse.names();
            if (names != null) {
                Iterator it = RangesKt.until(0, names.size()).iterator();
                while (it.hasNext()) {
                    String str2 = names.get(((IntIterator) it).nextInt());
                    CLElement cLElement = parse.get(str2);
                    if ((cLElement instanceof CLObject) && (objectOrNull = ((CLObject) cLElement).getObjectOrNull("custom")) != null) {
                        ArrayList<String> names2 = objectOrNull.names();
                        if (names2 != null) {
                            Iterator it2 = RangesKt.until(0, names2.size()).iterator();
                            while (it2.hasNext()) {
                                String str3 = names2.get(((IntIterator) it2).nextInt());
                                CLElement cLElement2 = objectOrNull.get(str3);
                                if (cLElement2 instanceof CLNumber) {
                                    transition.addCustomFloat(i, str2, str3, cLElement2.getFloat());
                                } else if (cLElement2 instanceof CLString) {
                                    String content = cLElement2.content();
                                    Intrinsics.checkNotNullExpressionValue(content, "value.content()");
                                    Integer parseColorString = parseColorString(content);
                                    if (parseColorString != null) {
                                        transition.addCustomColor(i, str2, str3, parseColorString.intValue());
                                    }
                                }
                            }
                        } else {
                            return;
                        }
                    }
                }
            }
        } catch (CLParsingException e) {
            System.err.println(Intrinsics.stringPlus("Error parsing JSON ", e));
        }
    }

    public static final void parseMotionSceneJSON(MotionScene motionScene, String str) {
        Intrinsics.checkNotNullParameter(motionScene, "scene");
        Intrinsics.checkNotNullParameter(str, "content");
        try {
            CLObject parse = CLParser.parse(str);
            ArrayList<String> names = parse.names();
            if (names != null) {
                Iterator it = RangesKt.until(0, names.size()).iterator();
                while (it.hasNext()) {
                    String str2 = names.get(((IntIterator) it).nextInt());
                    CLElement cLElement = parse.get(str2);
                    if (str2 != null) {
                        int hashCode = str2.hashCode();
                        if (hashCode != -2137403731) {
                            if (hashCode != -241441378) {
                                if (hashCode == 1101852654) {
                                    if (str2.equals("ConstraintSets")) {
                                        Intrinsics.checkNotNullExpressionValue(cLElement, "element");
                                        parseConstraintSets(motionScene, cLElement);
                                    }
                                }
                            } else if (str2.equals(TypedValues.TransitionType.NAME)) {
                                Intrinsics.checkNotNullExpressionValue(cLElement, "element");
                                parseTransitions(motionScene, cLElement);
                            }
                        } else if (str2.equals("Header")) {
                            Intrinsics.checkNotNullExpressionValue(cLElement, "element");
                            parseHeader(motionScene, cLElement);
                        }
                    }
                }
            }
        } catch (CLParsingException e) {
            System.err.println(Intrinsics.stringPlus("Error parsing JSON ", e));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0027 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void parseConstraintSets(androidx.constraintlayout.compose.MotionScene r13, java.lang.Object r14) {
        /*
            java.lang.String r0 = "scene"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "json"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            boolean r0 = r14 instanceof androidx.constraintlayout.core.parser.CLObject
            if (r0 != 0) goto L_0x000f
            return
        L_0x000f:
            androidx.constraintlayout.core.parser.CLObject r14 = (androidx.constraintlayout.core.parser.CLObject) r14
            java.util.ArrayList r0 = r14.names()
            if (r0 != 0) goto L_0x0018
            return
        L_0x0018:
            int r1 = r0.size()
            r2 = 0
            kotlin.ranges.IntRange r1 = kotlin.ranges.RangesKt.until((int) r2, (int) r1)
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x0027:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x00c5
            r3 = r1
            kotlin.collections.IntIterator r3 = (kotlin.collections.IntIterator) r3
            int r3 = r3.nextInt()
            java.lang.Object r3 = r0.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            androidx.constraintlayout.core.parser.CLObject r4 = r14.getObject((java.lang.String) r3)
            java.lang.String r5 = "Extends"
            java.lang.String r5 = r4.getStringOrNull((java.lang.String) r5)
            r6 = 1
            java.lang.String r7 = "csName"
            if (r5 == 0) goto L_0x00b1
            r8 = r5
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            int r8 = r8.length()
            if (r8 <= 0) goto L_0x0054
            r8 = 1
            goto L_0x0055
        L_0x0054:
            r8 = 0
        L_0x0055:
            if (r8 == 0) goto L_0x00b1
            java.lang.String r5 = r13.getConstraintSet((java.lang.String) r5)
            if (r5 == 0) goto L_0x00b1
            androidx.constraintlayout.core.parser.CLObject r5 = androidx.constraintlayout.core.parser.CLParser.parse(r5)
            java.util.ArrayList r8 = r4.names()
            if (r8 == 0) goto L_0x00b1
            int r9 = r8.size()
            kotlin.ranges.IntRange r9 = kotlin.ranges.RangesKt.until((int) r2, (int) r9)
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.Iterator r9 = r9.iterator()
        L_0x0075:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x00a1
            r10 = r9
            kotlin.collections.IntIterator r10 = (kotlin.collections.IntIterator) r10
            int r10 = r10.nextInt()
            java.lang.Object r10 = r8.get(r10)
            java.lang.String r10 = (java.lang.String) r10
            androidx.constraintlayout.core.parser.CLElement r11 = r4.get((java.lang.String) r10)
            boolean r12 = r11 instanceof androidx.constraintlayout.core.parser.CLObject
            if (r12 == 0) goto L_0x0075
            java.lang.String r12 = "baseJson"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r12)
            java.lang.String r12 = "widgetOverrideName"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r12)
            androidx.constraintlayout.core.parser.CLObject r11 = (androidx.constraintlayout.core.parser.CLObject) r11
            override(r5, r10, r11)
            goto L_0x0075
        L_0x00a1:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r7)
            java.lang.String r5 = r5.toJSON()
            java.lang.String r8 = "baseJson.toJSON()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r8)
            r13.setConstraintSetContent(r3, r5)
            goto L_0x00b2
        L_0x00b1:
            r6 = 0
        L_0x00b2:
            if (r6 != 0) goto L_0x0027
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r7)
            java.lang.String r4 = r4.toJSON()
            java.lang.String r5 = "constraintSet.toJSON()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            r13.setConstraintSetContent(r3, r4)
            goto L_0x0027
        L_0x00c5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.compose.ConstraintSetParserKt.parseConstraintSets(androidx.constraintlayout.compose.MotionScene, java.lang.Object):void");
    }

    public static final void override(CLObject cLObject, String str, CLObject cLObject2) {
        Intrinsics.checkNotNullParameter(cLObject, "baseJson");
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(cLObject2, "overrideValue");
        if (!cLObject.has(str)) {
            cLObject.put(str, cLObject2);
            return;
        }
        CLObject object = cLObject.getObject(str);
        Iterator<String> it = cLObject2.names().iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next.equals("clear")) {
                CLArray array = cLObject2.getArray("clear");
                Iterator it2 = RangesKt.until(0, array.size()).iterator();
                while (it2.hasNext()) {
                    String stringOrNull = array.getStringOrNull(((IntIterator) it2).nextInt());
                    if (stringOrNull != null) {
                        int hashCode = stringOrNull.hashCode();
                        if (hashCode != -1727069561) {
                            if (hashCode != -1606703562) {
                                if (hashCode == 414334925 && stringOrNull.equals("dimensions")) {
                                    object.remove("width");
                                    object.remove("height");
                                }
                            } else if (stringOrNull.equals("constraints")) {
                                object.remove(ViewProps.START);
                                object.remove(ViewProps.END);
                                object.remove(ViewProps.TOP);
                                object.remove(ViewProps.BOTTOM);
                                object.remove("baseline");
                                object.remove("center");
                                object.remove("centerHorizontally");
                                object.remove("centerVertically");
                            }
                        } else if (stringOrNull.equals("transforms")) {
                            object.remove("visibility");
                            object.remove("alpha");
                            object.remove("pivotX");
                            object.remove("pivotY");
                            object.remove("rotationX");
                            object.remove("rotationY");
                            object.remove("rotationZ");
                            object.remove("scaleX");
                            object.remove("scaleY");
                            object.remove("translationX");
                            object.remove("translationY");
                        }
                        object.remove(stringOrNull);
                    }
                }
            } else {
                object.put(next, cLObject2.get(next));
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000f, code lost:
        r6 = (androidx.constraintlayout.core.parser.CLObject) r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void parseTransitions(androidx.constraintlayout.compose.MotionScene r5, java.lang.Object r6) {
        /*
            java.lang.String r0 = "scene"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "json"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            boolean r0 = r6 instanceof androidx.constraintlayout.core.parser.CLObject
            if (r0 != 0) goto L_0x000f
            return
        L_0x000f:
            androidx.constraintlayout.core.parser.CLObject r6 = (androidx.constraintlayout.core.parser.CLObject) r6
            java.util.ArrayList r0 = r6.names()
            if (r0 != 0) goto L_0x0018
            return
        L_0x0018:
            r1 = 0
            int r2 = r0.size()
            kotlin.ranges.IntRange r1 = kotlin.ranges.RangesKt.until((int) r1, (int) r2)
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x0027:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0050
            r2 = r1
            kotlin.collections.IntIterator r2 = (kotlin.collections.IntIterator) r2
            int r2 = r2.nextInt()
            java.lang.Object r2 = r0.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            androidx.constraintlayout.core.parser.CLObject r3 = r6.getObject((java.lang.String) r2)
            java.lang.String r4 = "elementName"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            java.lang.String r3 = r3.toJSON()
            java.lang.String r4 = "element.toJSON()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r5.setTransitionContent(r2, r3)
            goto L_0x0027
        L_0x0050:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.compose.ConstraintSetParserKt.parseTransitions(androidx.constraintlayout.compose.MotionScene, java.lang.Object):void");
    }

    public static final void parseHeader(MotionScene motionScene, Object obj) {
        String stringOrNull;
        Intrinsics.checkNotNullParameter(motionScene, "scene");
        Intrinsics.checkNotNullParameter(obj, "json");
        if ((obj instanceof CLObject) && (stringOrNull = ((CLObject) obj).getStringOrNull("export")) != null) {
            motionScene.setDebugName(stringOrNull);
        }
    }

    public static final void parseJSON(String str, State state, LayoutVariables layoutVariables) {
        Intrinsics.checkNotNullParameter(str, "content");
        Intrinsics.checkNotNullParameter(state, PostalAddressParser.REGION_KEY);
        Intrinsics.checkNotNullParameter(layoutVariables, "layoutVariables");
        try {
            CLObject parse = CLParser.parse(str);
            ArrayList<String> names = parse.names();
            if (names != null) {
                Iterator it = RangesKt.until(0, names.size()).iterator();
                while (it.hasNext()) {
                    String str2 = names.get(((IntIterator) it).nextInt());
                    CLElement cLElement = parse.get(str2);
                    if (str2 != null) {
                        int hashCode = str2.hashCode();
                        if (hashCode != -1824489883) {
                            if (hashCode != 1875016085) {
                                if (hashCode == 1921490263) {
                                    if (str2.equals("Variables")) {
                                        Intrinsics.checkNotNullExpressionValue(cLElement, "element");
                                        parseVariables(state, layoutVariables, cLElement);
                                    }
                                }
                            } else if (str2.equals("Generate")) {
                                Intrinsics.checkNotNullExpressionValue(cLElement, "element");
                                parseGenerate(state, layoutVariables, cLElement);
                            }
                        } else if (str2.equals("Helpers")) {
                            Intrinsics.checkNotNullExpressionValue(cLElement, "element");
                            parseHelpers(state, layoutVariables, cLElement);
                        }
                    }
                    if (cLElement instanceof CLObject) {
                        String lookForType = lookForType((CLObject) cLElement);
                        if (lookForType != null) {
                            int hashCode2 = lookForType.hashCode();
                            if (hashCode2 != -1785507558) {
                                if (hashCode2 != -333143113) {
                                    if (hashCode2 == 965681512) {
                                        if (lookForType.equals("hGuideline")) {
                                            Intrinsics.checkNotNullExpressionValue(str2, "elementName");
                                            parseGuidelineParams(0, state, str2, (CLObject) cLElement);
                                        }
                                    }
                                } else if (lookForType.equals("barrier")) {
                                    Intrinsics.checkNotNullExpressionValue(str2, "elementName");
                                    parseBarrier(state, str2, (CLObject) cLElement);
                                }
                            } else if (lookForType.equals("vGuideline")) {
                                Intrinsics.checkNotNullExpressionValue(str2, "elementName");
                                parseGuidelineParams(1, state, str2, (CLObject) cLElement);
                            }
                        } else {
                            Intrinsics.checkNotNullExpressionValue(str2, "elementName");
                            parseWidget(state, layoutVariables, str2, (CLObject) cLElement);
                        }
                    } else if (cLElement instanceof CLNumber) {
                        Intrinsics.checkNotNullExpressionValue(str2, "elementName");
                        layoutVariables.put(str2, ((CLNumber) cLElement).getInt());
                    }
                }
            }
        } catch (CLParsingException e) {
            System.err.println(Intrinsics.stringPlus("Error parsing JSON ", e));
        }
    }

    public static final void parseVariables(State state, LayoutVariables layoutVariables, Object obj) {
        CLObject cLObject;
        ArrayList<String> names;
        Intrinsics.checkNotNullParameter(state, PostalAddressParser.REGION_KEY);
        Intrinsics.checkNotNullParameter(layoutVariables, "layoutVariables");
        Intrinsics.checkNotNullParameter(obj, "json");
        if ((obj instanceof CLObject) && (names = cLObject.names()) != null) {
            Iterator it = RangesKt.until(0, names.size()).iterator();
            while (it.hasNext()) {
                String str = names.get(((IntIterator) it).nextInt());
                CLElement cLElement = (cLObject = (CLObject) obj).get(str);
                if (cLElement instanceof CLNumber) {
                    Intrinsics.checkNotNullExpressionValue(str, "elementName");
                    layoutVariables.put(str, ((CLNumber) cLElement).getInt());
                } else if (cLElement instanceof CLObject) {
                    CLObject cLObject2 = (CLObject) cLElement;
                    if (cLObject2.has(TypedValues.TransitionType.S_FROM) && cLObject2.has(TypedValues.TransitionType.S_TO)) {
                        CLElement cLElement2 = cLObject2.get(TypedValues.TransitionType.S_FROM);
                        Intrinsics.checkNotNullExpressionValue(cLElement2, "element[\"from\"]");
                        float f = layoutVariables.get(cLElement2);
                        CLElement cLElement3 = cLObject2.get(TypedValues.TransitionType.S_TO);
                        Intrinsics.checkNotNullExpressionValue(cLElement3, "element[\"to\"]");
                        float f2 = layoutVariables.get(cLElement3);
                        String stringOrNull = cLObject2.getStringOrNull("prefix");
                        String str2 = stringOrNull == null ? "" : stringOrNull;
                        String stringOrNull2 = cLObject2.getStringOrNull("postfix");
                        if (stringOrNull2 == null) {
                            stringOrNull2 = "";
                        }
                        Intrinsics.checkNotNullExpressionValue(str, "elementName");
                        layoutVariables.put(str, f, f2, 1.0f, str2, stringOrNull2);
                    } else if (cLObject2.has(TypedValues.TransitionType.S_FROM) && cLObject2.has("step")) {
                        CLElement cLElement4 = cLObject2.get(TypedValues.TransitionType.S_FROM);
                        Intrinsics.checkNotNullExpressionValue(cLElement4, "element[\"from\"]");
                        float f3 = layoutVariables.get(cLElement4);
                        CLElement cLElement5 = cLObject2.get("step");
                        Intrinsics.checkNotNullExpressionValue(cLElement5, "element[\"step\"]");
                        float f4 = layoutVariables.get(cLElement5);
                        Intrinsics.checkNotNullExpressionValue(str, "elementName");
                        layoutVariables.put(str, f3, f4);
                    } else if (cLObject2.has("ids")) {
                        CLArray array = cLObject2.getArray("ids");
                        ArrayList arrayList = new ArrayList();
                        int size = array.size();
                        if (size > 0) {
                            int i = 0;
                            while (true) {
                                int i2 = i + 1;
                                arrayList.add(array.getString(i));
                                if (i2 >= size) {
                                    break;
                                }
                                i = i2;
                            }
                        }
                        Intrinsics.checkNotNullExpressionValue(str, "elementName");
                        layoutVariables.put(str, (ArrayList<String>) arrayList);
                    } else if (cLObject2.has(HeaderParameterNames.AUTHENTICATION_TAG)) {
                        ArrayList<String> idsForTag = state.getIdsForTag(cLObject2.getString(HeaderParameterNames.AUTHENTICATION_TAG));
                        Intrinsics.checkNotNullExpressionValue(str, "elementName");
                        Intrinsics.checkNotNullExpressionValue(idsForTag, "arrayIds");
                        layoutVariables.put(str, idsForTag);
                    }
                }
            }
        }
    }

    public static final void parseDesignElementsJSON(String str, ArrayList<DesignElement> arrayList) {
        Iterator it;
        ArrayList<String> arrayList2;
        CLObject cLObject;
        ArrayList<DesignElement> arrayList3 = arrayList;
        Intrinsics.checkNotNullParameter(str, "content");
        Intrinsics.checkNotNullParameter(arrayList3, "list");
        CLObject parse = CLParser.parse(str);
        ArrayList<String> names = parse.names();
        if (names != null) {
            int i = 0;
            Iterator it2 = RangesKt.until(0, names.size()).iterator();
            while (it2.hasNext()) {
                String str2 = names.get(((IntIterator) it2).nextInt());
                CLElement cLElement = parse.get(str2);
                if (Intrinsics.areEqual((Object) str2, (Object) "Design")) {
                    Objects.requireNonNull(cLElement, "null cannot be cast to non-null type androidx.constraintlayout.core.parser.CLObject");
                    CLObject cLObject2 = (CLObject) cLElement;
                    ArrayList<String> names2 = cLObject2.names();
                    if (names2 != null) {
                        Iterator it3 = RangesKt.until(i, names2.size()).iterator();
                        while (it3.hasNext()) {
                            String str3 = names2.get(((IntIterator) it3).nextInt());
                            CLElement cLElement2 = cLObject2.get(str3);
                            Objects.requireNonNull(cLElement2, "null cannot be cast to non-null type androidx.constraintlayout.core.parser.CLObject");
                            CLObject cLObject3 = (CLObject) cLElement2;
                            System.out.printf("element found <" + str3 + Typography.greater, new Object[i]);
                            String stringOrNull = cLObject3.getStringOrNull("type");
                            if (stringOrNull != null) {
                                HashMap hashMap = new HashMap();
                                int size = cLObject3.size() - 1;
                                if (size >= 0) {
                                    int i2 = 0;
                                    while (true) {
                                        int i3 = i2 + 1;
                                        CLElement cLElement3 = cLObject3.get(i2);
                                        cLObject = parse;
                                        Objects.requireNonNull(cLElement3, "null cannot be cast to non-null type androidx.constraintlayout.core.parser.CLKey");
                                        CLKey cLKey = (CLKey) cLElement3;
                                        String content = cLKey.content();
                                        CLElement value = cLKey.getValue();
                                        String content2 = value == null ? null : value.content();
                                        arrayList2 = names;
                                        if (content2 != null) {
                                            it = it2;
                                            Intrinsics.checkNotNullExpressionValue(content, "paramName");
                                            hashMap.put(content, content2);
                                        } else {
                                            it = it2;
                                        }
                                        if (i2 == size) {
                                            break;
                                        }
                                        i2 = i3;
                                        parse = cLObject;
                                        names = arrayList2;
                                        it2 = it;
                                    }
                                } else {
                                    cLObject = parse;
                                    arrayList2 = names;
                                    it = it2;
                                }
                                Intrinsics.checkNotNullExpressionValue(str3, "elementName");
                                arrayList3.add(new DesignElement(str3, stringOrNull, hashMap));
                            } else {
                                cLObject = parse;
                                arrayList2 = names;
                                it = it2;
                            }
                            parse = cLObject;
                            names = arrayList2;
                            it2 = it;
                            i = 0;
                        }
                    } else {
                        return;
                    }
                }
                parse = parse;
                names = names;
                it2 = it2;
                i = 0;
            }
        }
    }

    public static final void parseHelpers(State state, LayoutVariables layoutVariables, Object obj) {
        String string;
        Intrinsics.checkNotNullParameter(state, PostalAddressParser.REGION_KEY);
        Intrinsics.checkNotNullParameter(layoutVariables, "layoutVariables");
        Intrinsics.checkNotNullParameter(obj, "element");
        if (obj instanceof CLArray) {
            CLArray cLArray = (CLArray) obj;
            Iterator it = RangesKt.until(0, cLArray.size()).iterator();
            while (it.hasNext()) {
                CLElement cLElement = cLArray.get(((IntIterator) it).nextInt());
                if (cLElement instanceof CLArray) {
                    CLArray cLArray2 = (CLArray) cLElement;
                    if (cLArray2.size() > 1 && (string = cLArray2.getString(0)) != null) {
                        switch (string.hashCode()) {
                            case -1785507558:
                                if (string.equals("vGuideline")) {
                                    parseGuideline(1, state, cLArray2);
                                    break;
                                } else {
                                    break;
                                }
                            case -1252464839:
                                if (string.equals("hChain")) {
                                    parseChain(0, state, layoutVariables, cLArray2);
                                    break;
                                } else {
                                    break;
                                }
                            case -851656725:
                                if (string.equals("vChain")) {
                                    parseChain(1, state, layoutVariables, cLArray2);
                                    break;
                                } else {
                                    break;
                                }
                            case 965681512:
                                if (string.equals("hGuideline")) {
                                    parseGuideline(0, state, cLArray2);
                                    break;
                                } else {
                                    break;
                                }
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0015, code lost:
        r8 = (androidx.constraintlayout.core.parser.CLObject) r8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void parseGenerate(androidx.constraintlayout.compose.State r6, androidx.constraintlayout.compose.LayoutVariables r7, java.lang.Object r8) {
        /*
            java.lang.String r0 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "layoutVariables"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "json"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            boolean r0 = r8 instanceof androidx.constraintlayout.core.parser.CLObject
            if (r0 != 0) goto L_0x0015
            return
        L_0x0015:
            androidx.constraintlayout.core.parser.CLObject r8 = (androidx.constraintlayout.core.parser.CLObject) r8
            java.util.ArrayList r0 = r8.names()
            if (r0 != 0) goto L_0x001e
            return
        L_0x001e:
            r1 = 0
            int r2 = r0.size()
            kotlin.ranges.IntRange r1 = kotlin.ranges.RangesKt.until((int) r1, (int) r2)
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x002d:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x006f
            r2 = r1
            kotlin.collections.IntIterator r2 = (kotlin.collections.IntIterator) r2
            int r2 = r2.nextInt()
            java.lang.Object r2 = r0.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            androidx.constraintlayout.core.parser.CLElement r3 = r8.get((java.lang.String) r2)
            java.lang.String r4 = "elementName"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            java.util.ArrayList r2 = r7.getList(r2)
            if (r2 == 0) goto L_0x002d
            boolean r4 = r3 instanceof androidx.constraintlayout.core.parser.CLObject
            if (r4 == 0) goto L_0x002d
            java.util.Iterator r2 = r2.iterator()
        L_0x0057:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x002d
            java.lang.Object r4 = r2.next()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r5 = "id"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            r5 = r3
            androidx.constraintlayout.core.parser.CLObject r5 = (androidx.constraintlayout.core.parser.CLObject) r5
            parseWidget(r6, r7, r4, r5)
            goto L_0x0057
        L_0x006f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.compose.ConstraintSetParserKt.parseGenerate(androidx.constraintlayout.compose.State, androidx.constraintlayout.compose.LayoutVariables, java.lang.Object):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00d6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void parseChain(int r7, androidx.constraintlayout.compose.State r8, androidx.constraintlayout.compose.LayoutVariables r9, androidx.constraintlayout.core.parser.CLArray r10) {
        /*
            java.lang.String r0 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "margins"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "helper"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            if (r7 != 0) goto L_0x0017
            androidx.constraintlayout.core.state.helpers.HorizontalChainReference r7 = r8.horizontalChain()
            goto L_0x001b
        L_0x0017:
            androidx.constraintlayout.core.state.helpers.VerticalChainReference r7 = r8.verticalChain()
        L_0x001b:
            androidx.constraintlayout.core.state.helpers.ChainReference r7 = (androidx.constraintlayout.core.state.helpers.ChainReference) r7
            r0 = 1
            androidx.constraintlayout.core.parser.CLElement r1 = r10.get((int) r0)
            boolean r2 = r1 instanceof androidx.constraintlayout.core.parser.CLArray
            if (r2 == 0) goto L_0x00fc
            androidx.constraintlayout.core.parser.CLArray r1 = (androidx.constraintlayout.core.parser.CLArray) r1
            int r2 = r1.size()
            if (r2 >= r0) goto L_0x0030
            goto L_0x00fc
        L_0x0030:
            int r2 = r1.size()
            r3 = 0
            kotlin.ranges.IntRange r2 = kotlin.ranges.RangesKt.until((int) r3, (int) r2)
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
        L_0x003f:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0058
            r4 = r2
            kotlin.collections.IntIterator r4 = (kotlin.collections.IntIterator) r4
            int r4 = r4.nextInt()
            java.lang.Object[] r5 = new java.lang.Object[r0]
            java.lang.String r4 = r1.getString((int) r4)
            r5[r3] = r4
            r7.add(r5)
            goto L_0x003f
        L_0x0058:
            int r1 = r10.size()
            r2 = 2
            if (r1 <= r2) goto L_0x00fc
            androidx.constraintlayout.core.parser.CLElement r10 = r10.get((int) r2)
            boolean r1 = r10 instanceof androidx.constraintlayout.core.parser.CLObject
            if (r1 != 0) goto L_0x0068
            return
        L_0x0068:
            androidx.constraintlayout.core.parser.CLObject r10 = (androidx.constraintlayout.core.parser.CLObject) r10
            java.util.ArrayList r1 = r10.names()
            if (r1 != 0) goto L_0x0071
            return
        L_0x0071:
            int r2 = r1.size()
            kotlin.ranges.IntRange r2 = kotlin.ranges.RangesKt.until((int) r3, (int) r2)
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
        L_0x007f:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x00fc
            r4 = r2
            kotlin.collections.IntIterator r4 = (kotlin.collections.IntIterator) r4
            int r4 = r4.nextInt()
            java.lang.Object r4 = r1.get(r4)
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r5 = "style"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r5)
            if (r5 == 0) goto L_0x00eb
            androidx.constraintlayout.core.parser.CLElement r4 = r10.get((java.lang.String) r4)
            boolean r5 = r4 instanceof androidx.constraintlayout.core.parser.CLArray
            if (r5 == 0) goto L_0x00be
            r5 = r4
            androidx.constraintlayout.core.parser.CLArray r5 = (androidx.constraintlayout.core.parser.CLArray) r5
            int r6 = r5.size()
            if (r6 <= r0) goto L_0x00be
            java.lang.String r4 = r5.getString((int) r3)
            java.lang.String r6 = "styleObject.getString(0)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r6)
            float r5 = r5.getFloat((int) r0)
            r7.bias((float) r5)
            goto L_0x00c8
        L_0x00be:
            java.lang.String r4 = r4.content()
            java.lang.String r5 = "styleObject.content()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
        L_0x00c8:
            java.lang.String r5 = "packed"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r5)
            if (r5 == 0) goto L_0x00d6
            androidx.constraintlayout.core.state.State$Chain r4 = androidx.constraintlayout.core.state.State.Chain.PACKED
            r7.style(r4)
            goto L_0x007f
        L_0x00d6:
            java.lang.String r5 = "spread_inside"
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 == 0) goto L_0x00e5
            androidx.constraintlayout.core.state.State$Chain r4 = androidx.constraintlayout.core.state.State.Chain.SPREAD_INSIDE
            r7.style(r4)
            goto L_0x007f
        L_0x00e5:
            androidx.constraintlayout.core.state.State$Chain r4 = androidx.constraintlayout.core.state.State.Chain.SPREAD
            r7.style(r4)
            goto L_0x007f
        L_0x00eb:
            java.lang.String r5 = "null cannot be cast to non-null type androidx.constraintlayout.core.state.ConstraintReference"
            java.util.Objects.requireNonNull(r7, r5)
            r5 = r7
            androidx.constraintlayout.core.state.ConstraintReference r5 = (androidx.constraintlayout.core.state.ConstraintReference) r5
            java.lang.String r6 = "constraintName"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r6)
            parseConstraint(r8, r9, r10, r5, r4)
            goto L_0x007f
        L_0x00fc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.compose.ConstraintSetParserKt.parseChain(int, androidx.constraintlayout.compose.State, androidx.constraintlayout.compose.LayoutVariables, androidx.constraintlayout.core.parser.CLArray):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0015, code lost:
        r3 = (androidx.constraintlayout.core.parser.CLObject) r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void parseGuideline(int r1, androidx.constraintlayout.compose.State r2, androidx.constraintlayout.core.parser.CLArray r3) {
        /*
            java.lang.String r0 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "helper"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = 1
            androidx.constraintlayout.core.parser.CLElement r3 = r3.get((int) r0)
            boolean r0 = r3 instanceof androidx.constraintlayout.core.parser.CLObject
            if (r0 != 0) goto L_0x0015
            return
        L_0x0015:
            androidx.constraintlayout.core.parser.CLObject r3 = (androidx.constraintlayout.core.parser.CLObject) r3
            java.lang.String r0 = "id"
            java.lang.String r0 = r3.getStringOrNull((java.lang.String) r0)
            if (r0 != 0) goto L_0x0020
            return
        L_0x0020:
            parseGuidelineParams(r1, r2, r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.compose.ConstraintSetParserKt.parseGuideline(int, androidx.constraintlayout.compose.State, androidx.constraintlayout.core.parser.CLArray):void");
    }

    private static final void parseGuidelineParams(int i, State state, String str, CLObject cLObject) {
        ArrayList<String> names = cLObject.names();
        if (names != null) {
            ConstraintReference constraints = state.constraints(str);
            if (i == 0) {
                state.horizontalGuideline(str);
            } else {
                state.verticalGuideline(str);
            }
            Facade facade = constraints.getFacade();
            Objects.requireNonNull(facade, "null cannot be cast to non-null type androidx.constraintlayout.core.state.helpers.GuidelineReference");
            GuidelineReference guidelineReference = (GuidelineReference) facade;
            Iterator it = RangesKt.until(0, names.size()).iterator();
            while (it.hasNext()) {
                String str2 = names.get(((IntIterator) it).nextInt());
                if (str2 != null) {
                    int hashCode = str2.hashCode();
                    if (hashCode != -678927291) {
                        if (hashCode != 100571) {
                            if (hashCode == 109757538 && str2.equals(ViewProps.START)) {
                                guidelineReference.start(Integer.valueOf(state.convertDimension(Dp.m3857boximpl(Dp.m3859constructorimpl(cLObject.getFloat(str2))))));
                            }
                        } else if (str2.equals(ViewProps.END)) {
                            guidelineReference.end(Integer.valueOf(state.convertDimension(Dp.m3857boximpl(Dp.m3859constructorimpl(cLObject.getFloat(str2))))));
                        }
                    } else if (str2.equals("percent")) {
                        guidelineReference.percent(cLObject.getFloat(str2));
                    }
                }
            }
        }
    }

    public static final void parseBarrier(State state, String str, CLObject cLObject) {
        String string;
        CLArray arrayOrNull;
        int size;
        Intrinsics.checkNotNullParameter(state, PostalAddressParser.REGION_KEY);
        Intrinsics.checkNotNullParameter(str, "elementName");
        Intrinsics.checkNotNullParameter(cLObject, "element");
        BarrierReference barrier = state.barrier(str, State.Direction.END);
        ArrayList<String> names = cLObject.names();
        if (names != null) {
            Iterator it = RangesKt.until(0, names.size()).iterator();
            while (it.hasNext()) {
                String str2 = names.get(((IntIterator) it).nextInt());
                if (str2 != null) {
                    int hashCode = str2.hashCode();
                    if (hashCode != -1081309778) {
                        if (hashCode == -962590849) {
                            if (str2.equals("direction") && (string = cLObject.getString(str2)) != null) {
                                switch (string.hashCode()) {
                                    case -1383228885:
                                        if (string.equals(ViewProps.BOTTOM)) {
                                            barrier.setBarrierDirection(State.Direction.BOTTOM);
                                            break;
                                        } else {
                                            break;
                                        }
                                    case 100571:
                                        if (string.equals(ViewProps.END)) {
                                            barrier.setBarrierDirection(State.Direction.END);
                                            break;
                                        } else {
                                            break;
                                        }
                                    case 115029:
                                        if (string.equals(ViewProps.TOP)) {
                                            barrier.setBarrierDirection(State.Direction.TOP);
                                            break;
                                        } else {
                                            break;
                                        }
                                    case 3317767:
                                        if (string.equals(ViewProps.LEFT)) {
                                            barrier.setBarrierDirection(State.Direction.LEFT);
                                            break;
                                        } else {
                                            break;
                                        }
                                    case 108511772:
                                        if (string.equals(ViewProps.RIGHT)) {
                                            barrier.setBarrierDirection(State.Direction.RIGHT);
                                            break;
                                        } else {
                                            break;
                                        }
                                    case 109757538:
                                        if (string.equals(ViewProps.START)) {
                                            barrier.setBarrierDirection(State.Direction.START);
                                            break;
                                        } else {
                                            break;
                                        }
                                }
                            }
                        } else if (hashCode == -567445985 && str2.equals("contains") && (arrayOrNull = cLObject.getArrayOrNull(str2)) != null && (size = arrayOrNull.size()) > 0) {
                            int i = 0;
                            while (true) {
                                int i2 = i + 1;
                                barrier.add(state.constraints(arrayOrNull.get(i).content()));
                                if (i2 < size) {
                                    i = i2;
                                }
                            }
                        }
                    } else if (str2.equals(ViewProps.MARGIN)) {
                        float floatOrNaN = cLObject.getFloatOrNaN(str2);
                        if (!Float.isNaN(floatOrNaN)) {
                            barrier.margin((int) floatOrNaN);
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void parseWidget(androidx.constraintlayout.compose.State r8, androidx.constraintlayout.compose.LayoutVariables r9, java.lang.String r10, androidx.constraintlayout.core.parser.CLObject r11) {
        /*
            java.lang.String r0 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "layoutVariables"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "elementName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "element"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            androidx.constraintlayout.core.state.ConstraintReference r10 = r8.constraints(r10)
            androidx.constraintlayout.core.state.Dimension r0 = r10.getWidth()
            if (r0 != 0) goto L_0x0026
            androidx.constraintlayout.core.state.Dimension r0 = androidx.constraintlayout.core.state.Dimension.Wrap()
            r10.setWidth(r0)
        L_0x0026:
            androidx.constraintlayout.core.state.Dimension r0 = r10.getHeight()
            if (r0 != 0) goto L_0x0033
            androidx.constraintlayout.core.state.Dimension r0 = androidx.constraintlayout.core.state.Dimension.Wrap()
            r10.setHeight(r0)
        L_0x0033:
            java.util.ArrayList r0 = r11.names()
            if (r0 != 0) goto L_0x003a
            return
        L_0x003a:
            int r1 = r0.size()
            r2 = 0
            kotlin.ranges.IntRange r1 = kotlin.ranges.RangesKt.until((int) r2, (int) r1)
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x0049:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0306
            r3 = r1
            kotlin.collections.IntIterator r3 = (kotlin.collections.IntIterator) r3
            int r3 = r3.nextInt()
            java.lang.Object r3 = r0.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r4 = "reference"
            if (r3 == 0) goto L_0x02f9
            int r5 = r3.hashCode()
            java.lang.String r6 = "parent"
            java.lang.String r7 = "element[constraintName]"
            switch(r5) {
                case -1448775240: goto L_0x02d3;
                case -1364013995: goto L_0x02a7;
                case -1349088399: goto L_0x0296;
                case -1249320806: goto L_0x027c;
                case -1249320805: goto L_0x0262;
                case -1249320804: goto L_0x0248;
                case -1225497657: goto L_0x022d;
                case -1225497656: goto L_0x0212;
                case -1225497655: goto L_0x01f7;
                case -1221029593: goto L_0x01e4;
                case -987906986: goto L_0x01ca;
                case -987906985: goto L_0x01b0;
                case -908189618: goto L_0x0196;
                case -908189617: goto L_0x017c;
                case -61505906: goto L_0x0161;
                case 92909918: goto L_0x0147;
                case 98116417: goto L_0x012d;
                case 111045711: goto L_0x0112;
                case 113126854: goto L_0x00fe;
                case 398344448: goto L_0x00e4;
                case 1404070310: goto L_0x00bd;
                case 1941332754: goto L_0x006d;
                default: goto L_0x006b;
            }
        L_0x006b:
            goto L_0x02f9
        L_0x006d:
            java.lang.String r5 = "visibility"
            boolean r5 = r3.equals(r5)
            if (r5 != 0) goto L_0x0078
            goto L_0x02f9
        L_0x0078:
            java.lang.String r3 = r11.getString((java.lang.String) r3)
            if (r3 == 0) goto L_0x0049
            int r4 = r3.hashCode()
            r5 = -1901805651(0xffffffff8ea4bfad, float:-4.06137E-30)
            if (r4 == r5) goto L_0x00af
            r5 = 3178655(0x30809f, float:4.454244E-39)
            if (r4 == r5) goto L_0x00a0
            r5 = 466743410(0x1bd1f072, float:3.4731534E-22)
            if (r4 == r5) goto L_0x0092
            goto L_0x0049
        L_0x0092:
            java.lang.String r4 = "visible"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x009c
            goto L_0x0049
        L_0x009c:
            r10.visibility(r2)
            goto L_0x0049
        L_0x00a0:
            java.lang.String r4 = "gone"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x00a9
            goto L_0x0049
        L_0x00a9:
            r3 = 8
            r10.visibility(r3)
            goto L_0x0049
        L_0x00af:
            java.lang.String r4 = "invisible"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x00b8
            goto L_0x0049
        L_0x00b8:
            r3 = 4
            r10.visibility(r3)
            goto L_0x0049
        L_0x00bd:
            java.lang.String r5 = "centerHorizontally"
            boolean r5 = r3.equals(r5)
            if (r5 != 0) goto L_0x00c7
            goto L_0x02f9
        L_0x00c7:
            java.lang.String r3 = r11.getString((java.lang.String) r3)
            boolean r4 = r3.equals(r6)
            if (r4 == 0) goto L_0x00d8
            java.lang.Integer r3 = androidx.constraintlayout.core.state.State.PARENT
            androidx.constraintlayout.core.state.ConstraintReference r3 = r8.constraints(r3)
            goto L_0x00dc
        L_0x00d8:
            androidx.constraintlayout.core.state.ConstraintReference r3 = r8.constraints(r3)
        L_0x00dc:
            r10.startToStart(r3)
            r10.endToEnd(r3)
            goto L_0x0049
        L_0x00e4:
            java.lang.String r5 = "hWeight"
            boolean r5 = r3.equals(r5)
            if (r5 != 0) goto L_0x00ee
            goto L_0x02f9
        L_0x00ee:
            androidx.constraintlayout.core.parser.CLElement r3 = r11.get((java.lang.String) r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r7)
            float r3 = r9.get(r3)
            r10.setHorizontalChainWeight(r3)
            goto L_0x0049
        L_0x00fe:
            java.lang.String r5 = "width"
            boolean r5 = r3.equals(r5)
            if (r5 != 0) goto L_0x0109
            goto L_0x02f9
        L_0x0109:
            androidx.constraintlayout.core.state.Dimension r3 = parseDimension(r11, r3, r8)
            r10.setWidth(r3)
            goto L_0x0049
        L_0x0112:
            java.lang.String r5 = "vBias"
            boolean r5 = r3.equals(r5)
            if (r5 != 0) goto L_0x011d
            goto L_0x02f9
        L_0x011d:
            androidx.constraintlayout.core.parser.CLElement r3 = r11.get((java.lang.String) r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r7)
            float r3 = r9.get(r3)
            r10.verticalBias(r3)
            goto L_0x0049
        L_0x012d:
            java.lang.String r5 = "hBias"
            boolean r5 = r3.equals(r5)
            if (r5 != 0) goto L_0x0137
            goto L_0x02f9
        L_0x0137:
            androidx.constraintlayout.core.parser.CLElement r3 = r11.get((java.lang.String) r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r7)
            float r3 = r9.get(r3)
            r10.horizontalBias(r3)
            goto L_0x0049
        L_0x0147:
            java.lang.String r5 = "alpha"
            boolean r5 = r3.equals(r5)
            if (r5 != 0) goto L_0x0151
            goto L_0x02f9
        L_0x0151:
            androidx.constraintlayout.core.parser.CLElement r3 = r11.get((java.lang.String) r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r7)
            float r3 = r9.get(r3)
            r10.alpha(r3)
            goto L_0x0049
        L_0x0161:
            java.lang.String r5 = "vWeight"
            boolean r5 = r3.equals(r5)
            if (r5 != 0) goto L_0x016c
            goto L_0x02f9
        L_0x016c:
            androidx.constraintlayout.core.parser.CLElement r3 = r11.get((java.lang.String) r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r7)
            float r3 = r9.get(r3)
            r10.setVerticalChainWeight(r3)
            goto L_0x0049
        L_0x017c:
            java.lang.String r5 = "scaleY"
            boolean r5 = r3.equals(r5)
            if (r5 != 0) goto L_0x0186
            goto L_0x02f9
        L_0x0186:
            androidx.constraintlayout.core.parser.CLElement r3 = r11.get((java.lang.String) r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r7)
            float r3 = r9.get(r3)
            r10.scaleY(r3)
            goto L_0x0049
        L_0x0196:
            java.lang.String r5 = "scaleX"
            boolean r5 = r3.equals(r5)
            if (r5 != 0) goto L_0x01a0
            goto L_0x02f9
        L_0x01a0:
            androidx.constraintlayout.core.parser.CLElement r3 = r11.get((java.lang.String) r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r7)
            float r3 = r9.get(r3)
            r10.scaleX(r3)
            goto L_0x0049
        L_0x01b0:
            java.lang.String r5 = "pivotY"
            boolean r5 = r3.equals(r5)
            if (r5 != 0) goto L_0x01ba
            goto L_0x02f9
        L_0x01ba:
            androidx.constraintlayout.core.parser.CLElement r3 = r11.get((java.lang.String) r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r7)
            float r3 = r9.get(r3)
            r10.pivotY(r3)
            goto L_0x0049
        L_0x01ca:
            java.lang.String r5 = "pivotX"
            boolean r5 = r3.equals(r5)
            if (r5 != 0) goto L_0x01d4
            goto L_0x02f9
        L_0x01d4:
            androidx.constraintlayout.core.parser.CLElement r3 = r11.get((java.lang.String) r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r7)
            float r3 = r9.get(r3)
            r10.pivotX(r3)
            goto L_0x0049
        L_0x01e4:
            java.lang.String r5 = "height"
            boolean r5 = r3.equals(r5)
            if (r5 != 0) goto L_0x01ee
            goto L_0x02f9
        L_0x01ee:
            androidx.constraintlayout.core.state.Dimension r3 = parseDimension(r11, r3, r8)
            r10.setHeight(r3)
            goto L_0x0049
        L_0x01f7:
            java.lang.String r5 = "translationZ"
            boolean r5 = r3.equals(r5)
            if (r5 != 0) goto L_0x0202
            goto L_0x02f9
        L_0x0202:
            androidx.constraintlayout.core.parser.CLElement r3 = r11.get((java.lang.String) r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r7)
            float r3 = r9.get(r3)
            r10.translationZ(r3)
            goto L_0x0049
        L_0x0212:
            java.lang.String r5 = "translationY"
            boolean r5 = r3.equals(r5)
            if (r5 != 0) goto L_0x021d
            goto L_0x02f9
        L_0x021d:
            androidx.constraintlayout.core.parser.CLElement r3 = r11.get((java.lang.String) r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r7)
            float r3 = r9.get(r3)
            r10.translationY(r3)
            goto L_0x0049
        L_0x022d:
            java.lang.String r5 = "translationX"
            boolean r5 = r3.equals(r5)
            if (r5 != 0) goto L_0x0238
            goto L_0x02f9
        L_0x0238:
            androidx.constraintlayout.core.parser.CLElement r3 = r11.get((java.lang.String) r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r7)
            float r3 = r9.get(r3)
            r10.translationX(r3)
            goto L_0x0049
        L_0x0248:
            java.lang.String r5 = "rotationZ"
            boolean r5 = r3.equals(r5)
            if (r5 != 0) goto L_0x0252
            goto L_0x02f9
        L_0x0252:
            androidx.constraintlayout.core.parser.CLElement r3 = r11.get((java.lang.String) r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r7)
            float r3 = r9.get(r3)
            r10.rotationZ(r3)
            goto L_0x0049
        L_0x0262:
            java.lang.String r5 = "rotationY"
            boolean r5 = r3.equals(r5)
            if (r5 != 0) goto L_0x026c
            goto L_0x02f9
        L_0x026c:
            androidx.constraintlayout.core.parser.CLElement r3 = r11.get((java.lang.String) r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r7)
            float r3 = r9.get(r3)
            r10.rotationY(r3)
            goto L_0x0049
        L_0x027c:
            java.lang.String r5 = "rotationX"
            boolean r5 = r3.equals(r5)
            if (r5 != 0) goto L_0x0286
            goto L_0x02f9
        L_0x0286:
            androidx.constraintlayout.core.parser.CLElement r3 = r11.get((java.lang.String) r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r7)
            float r3 = r9.get(r3)
            r10.rotationX(r3)
            goto L_0x0049
        L_0x0296:
            java.lang.String r5 = "custom"
            boolean r5 = r3.equals(r5)
            if (r5 != 0) goto L_0x029f
            goto L_0x02f9
        L_0x029f:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r4)
            parseCustomProperties(r11, r10, r3)
            goto L_0x0049
        L_0x02a7:
            java.lang.String r5 = "center"
            boolean r5 = r3.equals(r5)
            if (r5 != 0) goto L_0x02b0
            goto L_0x02f9
        L_0x02b0:
            java.lang.String r3 = r11.getString((java.lang.String) r3)
            boolean r4 = r3.equals(r6)
            if (r4 == 0) goto L_0x02c1
            java.lang.Integer r3 = androidx.constraintlayout.core.state.State.PARENT
            androidx.constraintlayout.core.state.ConstraintReference r3 = r8.constraints(r3)
            goto L_0x02c5
        L_0x02c1:
            androidx.constraintlayout.core.state.ConstraintReference r3 = r8.constraints(r3)
        L_0x02c5:
            r10.startToStart(r3)
            r10.endToEnd(r3)
            r10.topToTop(r3)
            r10.bottomToBottom(r3)
            goto L_0x0049
        L_0x02d3:
            java.lang.String r5 = "centerVertically"
            boolean r5 = r3.equals(r5)
            if (r5 != 0) goto L_0x02dc
            goto L_0x02f9
        L_0x02dc:
            java.lang.String r3 = r11.getString((java.lang.String) r3)
            boolean r4 = r3.equals(r6)
            if (r4 == 0) goto L_0x02ed
            java.lang.Integer r3 = androidx.constraintlayout.core.state.State.PARENT
            androidx.constraintlayout.core.state.ConstraintReference r3 = r8.constraints(r3)
            goto L_0x02f1
        L_0x02ed:
            androidx.constraintlayout.core.state.ConstraintReference r3 = r8.constraints(r3)
        L_0x02f1:
            r10.topToTop(r3)
            r10.bottomToBottom(r3)
            goto L_0x0049
        L_0x02f9:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r4)
            java.lang.String r4 = "constraintName"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            parseConstraint(r8, r9, r11, r10, r3)
            goto L_0x0049
        L_0x0306:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.compose.ConstraintSetParserKt.parseWidget(androidx.constraintlayout.compose.State, androidx.constraintlayout.compose.LayoutVariables, java.lang.String, androidx.constraintlayout.core.parser.CLObject):void");
    }

    private static final void parseCustomProperties(CLObject cLObject, ConstraintReference constraintReference, String str) {
        ArrayList<String> names;
        CLObject objectOrNull = cLObject.getObjectOrNull(str);
        if (objectOrNull != null && (names = objectOrNull.names()) != null) {
            Iterator it = RangesKt.until(0, names.size()).iterator();
            while (it.hasNext()) {
                String str2 = names.get(((IntIterator) it).nextInt());
                CLElement cLElement = objectOrNull.get(str2);
                if (cLElement instanceof CLNumber) {
                    constraintReference.addCustomFloat(str2, cLElement.getFloat());
                } else if (cLElement instanceof CLString) {
                    String content = cLElement.content();
                    Intrinsics.checkNotNullExpressionValue(content, "value.content()");
                    Integer parseColorString = parseColorString(content);
                    if (parseColorString != null) {
                        constraintReference.addCustomColor(str2, parseColorString.intValue());
                    }
                }
            }
        }
    }

    private static final void parseConstraint(State state, LayoutVariables layoutVariables, CLObject cLObject, ConstraintReference constraintReference, String str) {
        ConstraintReference constraintReference2;
        float f;
        float f2;
        ConstraintReference constraintReference3;
        State state2 = state;
        LayoutVariables layoutVariables2 = layoutVariables;
        CLObject cLObject2 = cLObject;
        ConstraintReference constraintReference4 = constraintReference;
        String str2 = str;
        CLArray arrayOrNull = cLObject2.getArrayOrNull(str2);
        if (arrayOrNull == null || arrayOrNull.size() <= 1) {
            String str3 = "reference.key";
            String str4 = "targetReference.key";
            String stringOrNull = cLObject2.getStringOrNull(str2);
            if (stringOrNull != null) {
                if (stringOrNull.equals("parent")) {
                    constraintReference2 = state2.constraints(State.PARENT);
                } else {
                    constraintReference2 = state2.constraints(stringOrNull);
                }
                switch (str.hashCode()) {
                    case -1720785339:
                        if (str2.equals("baseline")) {
                            Object key = constraintReference.getKey();
                            Intrinsics.checkNotNullExpressionValue(key, str3);
                            state2.baselineNeededFor$compose_release(key);
                            Object key2 = constraintReference2.getKey();
                            Intrinsics.checkNotNullExpressionValue(key2, str4);
                            state2.baselineNeededFor$compose_release(key2);
                            constraintReference4.baselineToBaseline(constraintReference2);
                            return;
                        }
                        return;
                    case -1383228885:
                        if (str2.equals(ViewProps.BOTTOM)) {
                            constraintReference4.bottomToBottom(constraintReference2);
                            return;
                        }
                        return;
                    case 100571:
                        if (str2.equals(ViewProps.END)) {
                            constraintReference4.endToEnd(constraintReference2);
                            return;
                        }
                        return;
                    case 115029:
                        if (str2.equals(ViewProps.TOP)) {
                            constraintReference4.topToTop(constraintReference2);
                            return;
                        }
                        return;
                    case 109757538:
                        if (str2.equals(ViewProps.START)) {
                            constraintReference4.startToStart(constraintReference2);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        } else {
            String string = arrayOrNull.getString(0);
            String stringOrNull2 = arrayOrNull.getStringOrNull(1);
            String str5 = "targetReference.key";
            String str6 = "reference.key";
            if (arrayOrNull.size() > 2) {
                CLElement orNull = arrayOrNull.getOrNull(2);
                Intrinsics.checkNotNull(orNull);
                f = (float) state2.convertDimension(Dp.m3857boximpl(Dp.m3859constructorimpl(layoutVariables2.get(orNull))));
            } else {
                f = 0.0f;
            }
            if (arrayOrNull.size() > 3) {
                CLElement orNull2 = arrayOrNull.getOrNull(3);
                Intrinsics.checkNotNull(orNull2);
                f2 = (float) state2.convertDimension(Dp.m3857boximpl(Dp.m3859constructorimpl(layoutVariables2.get(orNull2))));
            } else {
                f2 = 0.0f;
            }
            if (string.equals("parent")) {
                constraintReference3 = state2.constraints(State.PARENT);
            } else {
                constraintReference3 = state2.constraints(string);
            }
            float f3 = f2;
            switch (str.hashCode()) {
                case -1720785339:
                    if (str2.equals("baseline") && stringOrNull2 != null) {
                        int hashCode = stringOrNull2.hashCode();
                        if (hashCode != -1720785339) {
                            if (hashCode != -1383228885) {
                                if (hashCode == 115029 && stringOrNull2.equals(ViewProps.TOP)) {
                                    Object key3 = constraintReference.getKey();
                                    Intrinsics.checkNotNullExpressionValue(key3, str6);
                                    state2.baselineNeededFor$compose_release(key3);
                                    Object key4 = constraintReference3.getKey();
                                    Intrinsics.checkNotNullExpressionValue(key4, str5);
                                    state2.baselineNeededFor$compose_release(key4);
                                    constraintReference4.baselineToTop(constraintReference3);
                                    break;
                                }
                            } else {
                                String str7 = str5;
                                String str8 = str6;
                                if (stringOrNull2.equals(ViewProps.BOTTOM)) {
                                    Object key5 = constraintReference.getKey();
                                    Intrinsics.checkNotNullExpressionValue(key5, str8);
                                    state2.baselineNeededFor$compose_release(key5);
                                    Object key6 = constraintReference3.getKey();
                                    Intrinsics.checkNotNullExpressionValue(key6, str7);
                                    state2.baselineNeededFor$compose_release(key6);
                                    constraintReference4.baselineToBottom(constraintReference3);
                                    break;
                                }
                            }
                        } else {
                            String str9 = str5;
                            String str10 = str6;
                            if (stringOrNull2.equals("baseline")) {
                                Object key7 = constraintReference.getKey();
                                Intrinsics.checkNotNullExpressionValue(key7, str10);
                                state2.baselineNeededFor$compose_release(key7);
                                Object key8 = constraintReference3.getKey();
                                Intrinsics.checkNotNullExpressionValue(key8, str9);
                                state2.baselineNeededFor$compose_release(key8);
                                constraintReference4.baselineToBaseline(constraintReference3);
                                break;
                            }
                        }
                    }
                    break;
                case -1498085729:
                    if (str2.equals("circular")) {
                        CLElement cLElement = arrayOrNull.get(1);
                        Intrinsics.checkNotNullExpressionValue(cLElement, "constraint.get(1)");
                        constraintReference4.circularConstraint(constraintReference3, layoutVariables2.get(cLElement), 0.0f);
                        break;
                    }
                    break;
                case -1383228885:
                    if (str2.equals(ViewProps.BOTTOM)) {
                        if (!Intrinsics.areEqual((Object) stringOrNull2, (Object) ViewProps.TOP)) {
                            if (Intrinsics.areEqual((Object) stringOrNull2, (Object) ViewProps.BOTTOM)) {
                                constraintReference4.bottomToBottom(constraintReference3);
                                break;
                            }
                        } else {
                            constraintReference4.bottomToTop(constraintReference3);
                            break;
                        }
                    }
                    break;
                case 100571:
                    if (str2.equals(ViewProps.END)) {
                        if (!Intrinsics.areEqual((Object) stringOrNull2, (Object) ViewProps.START)) {
                            if (Intrinsics.areEqual((Object) stringOrNull2, (Object) ViewProps.END)) {
                                constraintReference4.endToEnd(constraintReference3);
                                break;
                            }
                        } else {
                            constraintReference4.endToStart(constraintReference3);
                            break;
                        }
                    }
                    break;
                case 115029:
                    if (str2.equals(ViewProps.TOP)) {
                        if (!Intrinsics.areEqual((Object) stringOrNull2, (Object) ViewProps.TOP)) {
                            if (Intrinsics.areEqual((Object) stringOrNull2, (Object) ViewProps.BOTTOM)) {
                                constraintReference4.topToBottom(constraintReference3);
                                break;
                            }
                        } else {
                            constraintReference4.topToTop(constraintReference3);
                            break;
                        }
                    }
                    break;
                case 3317767:
                    if (str2.equals(ViewProps.LEFT)) {
                        if (!Intrinsics.areEqual((Object) stringOrNull2, (Object) ViewProps.LEFT)) {
                            if (Intrinsics.areEqual((Object) stringOrNull2, (Object) ViewProps.RIGHT)) {
                                constraintReference4.leftToRight(constraintReference3);
                                break;
                            }
                        } else {
                            constraintReference4.leftToLeft(constraintReference3);
                            break;
                        }
                    }
                    break;
                case 108511772:
                    if (str2.equals(ViewProps.RIGHT)) {
                        if (!Intrinsics.areEqual((Object) stringOrNull2, (Object) ViewProps.LEFT)) {
                            if (Intrinsics.areEqual((Object) stringOrNull2, (Object) ViewProps.RIGHT)) {
                                constraintReference4.rightToRight(constraintReference3);
                                break;
                            }
                        } else {
                            constraintReference4.rightToLeft(constraintReference3);
                            break;
                        }
                    }
                    break;
                case 109757538:
                    if (str2.equals(ViewProps.START)) {
                        if (!Intrinsics.areEqual((Object) stringOrNull2, (Object) ViewProps.START)) {
                            if (Intrinsics.areEqual((Object) stringOrNull2, (Object) ViewProps.END)) {
                                constraintReference4.startToEnd(constraintReference3);
                                break;
                            }
                        } else {
                            constraintReference4.startToStart(constraintReference3);
                            break;
                        }
                    }
                    break;
            }
            constraintReference4.margin((Object) Float.valueOf(f)).marginGone((int) f3);
        }
    }

    private static final Dimension parseDimensionMode(String str) {
        Dimension Fixed = Dimension.Fixed(0);
        Intrinsics.checkNotNullExpressionValue(Fixed, "Fixed(0)");
        switch (str.hashCode()) {
            case -1460244870:
                if (str.equals("preferWrap")) {
                    Dimension Suggested = Dimension.Suggested(Dimension.WRAP_DIMENSION);
                    Intrinsics.checkNotNullExpressionValue(Suggested, "Suggested(WRAP_DIMENSION)");
                    return Suggested;
                }
                break;
            case -995424086:
                if (str.equals("parent")) {
                    Dimension Parent = Dimension.Parent();
                    Intrinsics.checkNotNullExpressionValue(Parent, "Parent()");
                    return Parent;
                }
                break;
            case -895684237:
                if (str.equals("spread")) {
                    Dimension Suggested2 = Dimension.Suggested(Dimension.SPREAD_DIMENSION);
                    Intrinsics.checkNotNullExpressionValue(Suggested2, "Suggested(SPREAD_DIMENSION)");
                    return Suggested2;
                }
                break;
            case 3657802:
                if (str.equals("wrap")) {
                    Dimension Wrap = Dimension.Wrap();
                    Intrinsics.checkNotNullExpressionValue(Wrap, "Wrap()");
                    return Wrap;
                }
                break;
        }
        CharSequence charSequence = str;
        if (StringsKt.endsWith$default(charSequence, '%', false, 2, (Object) null)) {
            Dimension suggested = Dimension.Percent(0, Float.parseFloat(StringsKt.substringBefore$default(str, '%', (String) null, 2, (Object) null)) / 100.0f).suggested(0);
            Intrinsics.checkNotNullExpressionValue(suggested, "Percent(0, percentValue).suggested(0)");
            return suggested;
        } else if (!StringsKt.contains$default(charSequence, (char) AbstractJsonLexerKt.COLON, false, 2, (Object) null)) {
            return Fixed;
        } else {
            Dimension suggested2 = Dimension.Ratio(str).suggested(Dimension.SPREAD_DIMENSION);
            Intrinsics.checkNotNullExpressionValue(suggested2, "Ratio(dimensionString).suggested(SPREAD_DIMENSION)");
            return suggested2;
        }
    }

    private static final Dimension parseDimension(CLObject cLObject, String str, State state) {
        CLElement cLElement = cLObject.get(str);
        Dimension Fixed = Dimension.Fixed(0);
        Intrinsics.checkNotNullExpressionValue(Fixed, "Fixed(0)");
        if (cLElement instanceof CLString) {
            String content = cLElement.content();
            Intrinsics.checkNotNullExpressionValue(content, "dimensionElement.content()");
            return parseDimensionMode(content);
        } else if (cLElement instanceof CLNumber) {
            Dimension Fixed2 = Dimension.Fixed(state.convertDimension(Dp.m3857boximpl(Dp.m3859constructorimpl(cLObject.getFloat(str)))));
            Intrinsics.checkNotNullExpressionValue(Fixed2, "Fixed(\n            state.convertDimension(\n                Dp(\n                    element.getFloat(constraintName)\n                )\n            )\n        )");
            return Fixed2;
        } else if (!(cLElement instanceof CLObject)) {
            return Fixed;
        } else {
            CLObject cLObject2 = (CLObject) cLElement;
            String stringOrNull = cLObject2.getStringOrNull("value");
            if (stringOrNull != null) {
                Fixed = parseDimensionMode(stringOrNull);
            }
            CLElement orNull = cLObject2.getOrNull("min");
            if (orNull != null) {
                if (orNull instanceof CLNumber) {
                    Fixed.min(state.convertDimension(Dp.m3857boximpl(Dp.m3859constructorimpl(orNull.getFloat()))));
                } else if (orNull instanceof CLString) {
                    Fixed.min(Dimension.WRAP_DIMENSION);
                }
            }
            CLElement orNull2 = cLObject2.getOrNull("max");
            if (orNull2 == null) {
                return Fixed;
            }
            if (orNull2 instanceof CLNumber) {
                Fixed.max(state.convertDimension(Dp.m3857boximpl(Dp.m3859constructorimpl(orNull2.getFloat()))));
                return Fixed;
            } else if (!(orNull2 instanceof CLString)) {
                return Fixed;
            } else {
                Fixed.max(Dimension.WRAP_DIMENSION);
                return Fixed;
            }
        }
    }

    private static final Integer parseColorString(String str) {
        if (!StringsKt.startsWith$default((CharSequence) str, '#', false, 2, (Object) null)) {
            return null;
        }
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        String substring = str.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
        if (substring.length() == 6) {
            substring = Intrinsics.stringPlus("FF", substring);
        }
        return Integer.valueOf((int) Long.parseLong(substring, 16));
    }

    public static final String lookForType(CLObject cLObject) {
        Intrinsics.checkNotNullParameter(cLObject, "element");
        ArrayList<String> names = cLObject.names();
        if (names == null) {
            return null;
        }
        Iterator it = RangesKt.until(0, names.size()).iterator();
        while (it.hasNext()) {
            if (names.get(((IntIterator) it).nextInt()).equals("type")) {
                return cLObject.getString("type");
            }
        }
        return null;
    }
}
