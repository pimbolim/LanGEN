package androidx.constraintlayout.compose;

import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.constraintlayout.core.state.State;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.HelperWidget;
import com.braintreepayments.api.models.PostalAddressParser;
import com.facebook.react.uimanager.ViewProps;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000d\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\u001a.\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0018H\u0002\u001a\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001eH\u0002\u001a(\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\u0001H\u0000\u001a$\u0010$\u001a\n %*\u0004\u0018\u00010\u001e0\u001e*\u00020&2\u0006\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\u0001H\u0002\u001a\u0014\u0010'\u001a\u00020\u0018*\u00020&2\u0006\u0010 \u001a\u00020!H\u0002\u001a\u000e\u0010(\u001a\u00020\u0018*\u0004\u0018\u00010&H\u0002\u001aB\u0010)\u001a\u00020\u0013*\u00020\u001e2\u0006\u0010*\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180/2\u0006\u00100\u001a\u000201H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"5\u0010\b\u001a\u00020\u0004*\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00048@@@X\u0002¢\u0006\u0018\n\u0004\b\u0010\u0010\u0011\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u00062"}, d2 = {"CONSTRAINTS_JSON_VERSION", "", "DesignInfoDataKey", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "Landroidx/constraintlayout/compose/DesignInfoProvider;", "getDesignInfoDataKey", "()Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "<set-?>", "designInfoProvider", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "getDesignInfoProvider$annotations", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)V", "getDesignInfoProvider", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/constraintlayout/compose/DesignInfoProvider;", "setDesignInfoProvider", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/constraintlayout/compose/DesignInfoProvider;)V", "designInfoProvider$delegate", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "addReferencesIds", "", "helperWidget", "Landroidx/constraintlayout/core/widgets/HelperWidget;", "helperReferences", "", "", "root", "Landroidx/constraintlayout/core/widgets/ConstraintWidgetContainer;", "rootId", "createDesignInfoJson", "content", "Lorg/json/JSONObject;", "parseConstraintsToJson", "state", "Landroidx/constraintlayout/compose/State;", "startX", "startY", "boundsToJson", "kotlin.jvm.PlatformType", "Landroidx/constraintlayout/core/widgets/ConstraintWidget;", "getHelperId", "getRefId", "putViewIdToBoundsAndConstraints", "viewId", "boxJson", "isHelper", "", "isRoot", "", "constraintsInfoArray", "Lorg/json/JSONArray;", "compose_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* compiled from: ToolingUtils.kt */
public final class ToolingUtilsKt {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinPackage(ToolingUtilsKt.class, "compose_release"), "designInfoProvider", "getDesignInfoProvider(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/constraintlayout/compose/DesignInfoProvider;"))};
    private static final int CONSTRAINTS_JSON_VERSION = 1;
    private static final SemanticsPropertyKey<DesignInfoProvider> DesignInfoDataKey;
    private static final SemanticsPropertyKey designInfoProvider$delegate;

    public static /* synthetic */ void getDesignInfoProvider$annotations(SemanticsPropertyReceiver semanticsPropertyReceiver) {
    }

    public static final SemanticsPropertyKey<DesignInfoProvider> getDesignInfoDataKey() {
        return DesignInfoDataKey;
    }

    static {
        SemanticsPropertyKey<DesignInfoProvider> semanticsPropertyKey = new SemanticsPropertyKey<>("DesignInfoProvider", (Function2) null, 2, (DefaultConstructorMarker) null);
        DesignInfoDataKey = semanticsPropertyKey;
        designInfoProvider$delegate = semanticsPropertyKey;
    }

    public static final DesignInfoProvider getDesignInfoProvider(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        return (DesignInfoProvider) designInfoProvider$delegate.getValue(semanticsPropertyReceiver, $$delegatedProperties[0]);
    }

    public static final void setDesignInfoProvider(SemanticsPropertyReceiver semanticsPropertyReceiver, DesignInfoProvider designInfoProvider) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        Intrinsics.checkNotNullParameter(designInfoProvider, "<set-?>");
        designInfoProvider$delegate.setValue(semanticsPropertyReceiver, $$delegatedProperties[0], designInfoProvider);
    }

    public static final String parseConstraintsToJson(ConstraintWidgetContainer constraintWidgetContainer, State state, int i, int i2) {
        Iterator it;
        String str;
        ConstraintWidgetContainer constraintWidgetContainer2 = constraintWidgetContainer;
        State state2 = state;
        int i3 = i;
        int i4 = i2;
        Intrinsics.checkNotNullParameter(constraintWidgetContainer2, "root");
        Intrinsics.checkNotNullParameter(state2, PostalAddressParser.REGION_KEY);
        String valueOf = String.valueOf(State.PARENT);
        JSONObject jSONObject = new JSONObject();
        ArrayList<ConstraintWidget> children = constraintWidgetContainer.getChildren();
        Intrinsics.checkNotNullExpressionValue(children, "root.children");
        Iterator it2 = children.iterator();
        while (it2.hasNext()) {
            ConstraintWidget constraintWidget = (ConstraintWidget) it2.next();
            JSONArray jSONArray = new JSONArray();
            List arrayList = new ArrayList();
            boolean z = constraintWidget instanceof HelperWidget;
            String str2 = constraintWidget.stringId;
            if (z) {
                Objects.requireNonNull(constraintWidget, "null cannot be cast to non-null type androidx.constraintlayout.core.widgets.HelperWidget");
                addReferencesIds((HelperWidget) constraintWidget, arrayList, constraintWidgetContainer2, valueOf);
            }
            ArrayList<ConstraintAnchor> anchors = constraintWidget.getAnchors();
            Intrinsics.checkNotNullExpressionValue(anchors, "constraintWidget.anchors");
            for (ConstraintAnchor constraintAnchor : anchors) {
                if (constraintAnchor.isConnected()) {
                    ConstraintWidget owner = constraintAnchor.getTarget().getOwner();
                    it = it2;
                    boolean z2 = owner instanceof HelperWidget;
                    if (Intrinsics.areEqual((Object) constraintWidgetContainer2, (Object) owner)) {
                        str = valueOf;
                    } else if (z2) {
                        Intrinsics.checkNotNullExpressionValue(owner, "targetWidget");
                        str = getHelperId(owner, state2);
                    } else {
                        str = getRefId(owner);
                    }
                    JSONObject put = new JSONObject().put("originAnchor", constraintAnchor.getType());
                    ConstraintAnchor target = constraintAnchor.getTarget();
                    Intrinsics.checkNotNull(target);
                    jSONArray.put(put.put("targetAnchor", target.getType()).put("target", str).put(ViewProps.MARGIN, constraintAnchor.getMargin()));
                } else {
                    it = it2;
                }
                state2 = state;
                it2 = it;
            }
            Iterator it3 = it2;
            Intrinsics.checkNotNullExpressionValue(str2, "widgetId");
            Intrinsics.checkNotNullExpressionValue(constraintWidget, "constraintWidget");
            JSONObject boundsToJson = boundsToJson(constraintWidget, i3, i4);
            Intrinsics.checkNotNullExpressionValue(boundsToJson, "constraintWidget.boundsToJson(startX, startY)");
            putViewIdToBoundsAndConstraints(jSONObject, str2, boundsToJson, z, false, arrayList, jSONArray);
            state2 = state;
        }
        JSONObject boundsToJson2 = boundsToJson(constraintWidgetContainer2, i3, i4);
        Intrinsics.checkNotNullExpressionValue(boundsToJson2, "root.boundsToJson(startX, startY)");
        putViewIdToBoundsAndConstraints(jSONObject, valueOf, boundsToJson2, false, true, CollectionsKt.emptyList(), new JSONArray());
        return createDesignInfoJson(jSONObject);
    }

    private static final void addReferencesIds(HelperWidget helperWidget, List<String> list, ConstraintWidgetContainer constraintWidgetContainer, String str) {
        int i = helperWidget.mWidgetsCount;
        if (i > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                ConstraintWidget constraintWidget = helperWidget.mWidgets[i2];
                list.add(Intrinsics.areEqual((Object) constraintWidget, (Object) constraintWidgetContainer) ? str : getRefId(constraintWidget));
                if (i3 < i) {
                    i2 = i3;
                } else {
                    return;
                }
            }
        }
    }

    private static final String getHelperId(ConstraintWidget constraintWidget, State state) {
        return String.valueOf(state.getKeyId$compose_release((HelperWidget) constraintWidget));
    }

    private static final String getRefId(ConstraintWidget constraintWidget) {
        Object layoutId;
        String str = null;
        Object companionWidget = constraintWidget == null ? null : constraintWidget.getCompanionWidget();
        Measurable measurable = companionWidget instanceof Measurable ? (Measurable) companionWidget : null;
        String obj = (measurable == null || (layoutId = LayoutIdKt.getLayoutId(measurable)) == null) ? null : layoutId.toString();
        if (obj != null) {
            return obj;
        }
        if (constraintWidget != null) {
            str = constraintWidget.stringId;
        }
        return String.valueOf(str);
    }

    private static final String createDesignInfoJson(JSONObject jSONObject) {
        String jSONObject2 = new JSONObject().put("type", "CONSTRAINTS").put("version", 1).put("content", jSONObject).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject()\n    .put(\"type\", \"CONSTRAINTS\")\n    .put(\"version\", CONSTRAINTS_JSON_VERSION)\n    .put(\"content\", content).toString()");
        return jSONObject2;
    }

    private static final JSONObject boundsToJson(ConstraintWidget constraintWidget, int i, int i2) {
        return new JSONObject().put(ViewProps.LEFT, constraintWidget.getLeft() + i).put(ViewProps.TOP, constraintWidget.getTop() + i2).put(ViewProps.RIGHT, constraintWidget.getRight() + i).put(ViewProps.BOTTOM, constraintWidget.getBottom() + i2);
    }

    private static final void putViewIdToBoundsAndConstraints(JSONObject jSONObject, String str, JSONObject jSONObject2, boolean z, boolean z2, List<String> list, JSONArray jSONArray) {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("viewId", str);
        jSONObject3.put("box", jSONObject2);
        jSONObject3.put("isHelper", z);
        jSONObject3.put("isRoot", z2);
        JSONArray jSONArray2 = new JSONArray();
        for (Object put : list) {
            jSONArray2.put(put);
        }
        jSONObject3.put("helperReferences", jSONArray2);
        jSONObject3.put("constraints", jSONArray);
        jSONObject.put(str, jSONObject3);
    }
}
