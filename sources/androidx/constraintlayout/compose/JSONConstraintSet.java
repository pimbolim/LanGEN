package androidx.constraintlayout.compose;

import androidx.compose.ui.layout.Measurable;
import androidx.constraintlayout.compose.DerivedConstraintSet;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLKey;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParser;
import androidx.constraintlayout.core.parser.CLParsingException;
import androidx.constraintlayout.core.state.Transition;
import com.braintreepayments.api.models.PostalAddressParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0014\u0010\u001a\u001a\u00020\u000f2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0002J\u0018\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\rH\u0016R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Landroidx/constraintlayout/compose/JSONConstraintSet;", "Landroidx/constraintlayout/compose/EditableJSONLayout;", "Landroidx/constraintlayout/compose/DerivedConstraintSet;", "content", "", "overrideVariables", "extendFrom", "Landroidx/constraintlayout/compose/ConstraintSet;", "(Ljava/lang/String;Ljava/lang/String;Landroidx/constraintlayout/compose/ConstraintSet;)V", "getExtendFrom", "()Landroidx/constraintlayout/compose/ConstraintSet;", "overridedVariables", "Ljava/util/HashMap;", "", "applyLayoutVariables", "", "layoutVariables", "Landroidx/constraintlayout/compose/LayoutVariables;", "applyTo", "transition", "Landroidx/constraintlayout/core/state/Transition;", "type", "", "applyToState", "state", "Landroidx/constraintlayout/compose/State;", "emitDesignElements", "designElements", "Ljava/util/ArrayList;", "Landroidx/constraintlayout/compose/DesignElement;", "equals", "", "other", "", "override", "name", "value", "compose_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: JSONConstraintSet.kt */
public final class JSONConstraintSet extends EditableJSONLayout implements DerivedConstraintSet {
    private final ConstraintSet extendFrom;
    private final String overrideVariables;
    private final HashMap<String, Float> overridedVariables;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ JSONConstraintSet(String str, String str2, ConstraintSet constraintSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : constraintSet);
    }

    public void applyTo(State state, List<? extends Measurable> list) {
        DerivedConstraintSet.DefaultImpls.applyTo((DerivedConstraintSet) this, state, list);
    }

    public boolean isDirty(List<? extends Measurable> list) {
        return DerivedConstraintSet.DefaultImpls.isDirty(this, list);
    }

    public ConstraintSet getExtendFrom() {
        return this.extendFrom;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JSONConstraintSet(String str, String str2, ConstraintSet constraintSet) {
        super(str);
        Intrinsics.checkNotNullParameter(str, "content");
        this.extendFrom = constraintSet;
        this.overridedVariables = new HashMap<>();
        this.overrideVariables = str2;
        initialization();
    }

    public boolean equals(Object obj) {
        if (obj instanceof JSONConstraintSet) {
            return Intrinsics.areEqual((Object) getCurrentContent(), (Object) ((JSONConstraintSet) obj).getCurrentContent());
        }
        return false;
    }

    public void applyTo(Transition transition, int i) {
        Intrinsics.checkNotNullParameter(transition, "transition");
        applyLayoutVariables(new LayoutVariables());
        ConstraintSetParserKt.parseJSON(getCurrentContent(), transition, i);
    }

    public final void emitDesignElements(ArrayList<DesignElement> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "designElements");
        try {
            arrayList.clear();
            ConstraintSetParserKt.parseDesignElementsJSON(getCurrentContent(), arrayList);
        } catch (Exception unused) {
        }
    }

    public void applyToState(State state) {
        Intrinsics.checkNotNullParameter(state, PostalAddressParser.REGION_KEY);
        LayoutVariables layoutVariables = new LayoutVariables();
        applyLayoutVariables(layoutVariables);
        try {
            ConstraintSetParserKt.parseJSON(getCurrentContent(), state, layoutVariables);
        } catch (Exception unused) {
        }
    }

    public ConstraintSet override(String str, float f) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.overridedVariables.put(str, Float.valueOf(f));
        return this;
    }

    private final void applyLayoutVariables(LayoutVariables layoutVariables) {
        String str = this.overrideVariables;
        if (str != null) {
            try {
                CLObject parse = CLParser.parse(str);
                int i = 0;
                int size = parse.size() - 1;
                if (size >= 0) {
                    while (true) {
                        int i2 = i + 1;
                        CLElement cLElement = parse.get(i);
                        if (cLElement != null) {
                            CLKey cLKey = (CLKey) cLElement;
                            float f = cLKey.getValue().getFloat();
                            String content = cLKey.content();
                            Intrinsics.checkNotNullExpressionValue(content, "key.content()");
                            layoutVariables.putOverride(content, f);
                            if (i == size) {
                                break;
                            }
                            i = i2;
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.core.parser.CLKey");
                        }
                    }
                }
            } catch (CLParsingException e) {
                System.err.println(Intrinsics.stringPlus("exception: ", e));
            }
        }
        for (String next : this.overridedVariables.keySet()) {
            Intrinsics.checkNotNullExpressionValue(next, "name");
            Float f2 = this.overridedVariables.get(next);
            Intrinsics.checkNotNull(f2);
            layoutVariables.putOverride(next, f2.floatValue());
        }
    }
}
