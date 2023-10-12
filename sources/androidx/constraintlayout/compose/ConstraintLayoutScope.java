package androidx.constraintlayout.compose;

import androidx.compose.foundation.layout.LayoutScopeMarker;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.Density;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0016\u0017B\u0007\b\u0001¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\bJ\f\u0010\f\u001a\u00060\nR\u00020\u0000H\u0007J\b\u0010\r\u001a\u00020\u000eH\u0016J-\u0010\u000f\u001a\u00020\u0010*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\b2\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000e0\u0013¢\u0006\u0002\b\u0015H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0018\u00010\nR\u00020\u0000X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Landroidx/constraintlayout/compose/ConstraintLayoutScope;", "Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope;", "()V", "ChildrenStartIndex", "", "childId", "childrenRefs", "Ljava/util/ArrayList;", "Landroidx/constraintlayout/compose/ConstrainedLayoutReference;", "referencesObject", "Landroidx/constraintlayout/compose/ConstraintLayoutScope$ConstrainedLayoutReferences;", "createRef", "createRefs", "reset", "", "constrainAs", "Landroidx/compose/ui/Modifier;", "ref", "constrainBlock", "Lkotlin/Function1;", "Landroidx/constraintlayout/compose/ConstrainScope;", "Lkotlin/ExtensionFunctionType;", "ConstrainAsModifier", "ConstrainedLayoutReferences", "compose_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@LayoutScopeMarker
/* compiled from: ConstraintLayout.kt */
public final class ConstraintLayoutScope extends ConstraintLayoutBaseScope {
    public static final int $stable = 8;
    private final int ChildrenStartIndex;
    private int childId = this.ChildrenStartIndex;
    private final ArrayList<ConstrainedLayoutReference> childrenRefs = new ArrayList<>();
    private ConstrainedLayoutReferences referencesObject;

    public final ConstrainedLayoutReference createRef() {
        int i = this.childId;
        this.childId = i + 1;
        ConstrainedLayoutReference constrainedLayoutReference = (ConstrainedLayoutReference) CollectionsKt.getOrNull(this.childrenRefs, i);
        if (constrainedLayoutReference != null) {
            return constrainedLayoutReference;
        }
        ConstrainedLayoutReference constrainedLayoutReference2 = new ConstrainedLayoutReference(Integer.valueOf(this.childId));
        this.childrenRefs.add(constrainedLayoutReference2);
        return constrainedLayoutReference2;
    }

    public final ConstrainedLayoutReferences createRefs() {
        ConstrainedLayoutReferences constrainedLayoutReferences = this.referencesObject;
        if (constrainedLayoutReferences != null) {
            return constrainedLayoutReferences;
        }
        ConstrainedLayoutReferences constrainedLayoutReferences2 = new ConstrainedLayoutReferences(this);
        this.referencesObject = constrainedLayoutReferences2;
        return constrainedLayoutReferences2;
    }

    public void reset() {
        super.reset();
        this.childId = this.ChildrenStartIndex;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0004\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004H\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u0002J\t\u0010\u0006\u001a\u00020\u0004H\u0002J\t\u0010\u0007\u001a\u00020\u0004H\u0002J\t\u0010\b\u001a\u00020\u0004H\u0002J\t\u0010\t\u001a\u00020\u0004H\u0002J\t\u0010\n\u001a\u00020\u0004H\u0002J\t\u0010\u000b\u001a\u00020\u0004H\u0002J\t\u0010\f\u001a\u00020\u0004H\u0002J\t\u0010\r\u001a\u00020\u0004H\u0002J\t\u0010\u000e\u001a\u00020\u0004H\u0002J\t\u0010\u000f\u001a\u00020\u0004H\u0002J\t\u0010\u0010\u001a\u00020\u0004H\u0002J\t\u0010\u0011\u001a\u00020\u0004H\u0002J\t\u0010\u0012\u001a\u00020\u0004H\u0002J\t\u0010\u0013\u001a\u00020\u0004H\u0002¨\u0006\u0014"}, d2 = {"Landroidx/constraintlayout/compose/ConstraintLayoutScope$ConstrainedLayoutReferences;", "", "(Landroidx/constraintlayout/compose/ConstraintLayoutScope;)V", "component1", "Landroidx/constraintlayout/compose/ConstrainedLayoutReference;", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "compose_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ConstraintLayout.kt */
    public final class ConstrainedLayoutReferences {
        final /* synthetic */ ConstraintLayoutScope this$0;

        public ConstrainedLayoutReferences(ConstraintLayoutScope constraintLayoutScope) {
            Intrinsics.checkNotNullParameter(constraintLayoutScope, "this$0");
            this.this$0 = constraintLayoutScope;
        }

        public final ConstrainedLayoutReference component1() {
            return this.this$0.createRef();
        }

        public final ConstrainedLayoutReference component2() {
            return this.this$0.createRef();
        }

        public final ConstrainedLayoutReference component3() {
            return this.this$0.createRef();
        }

        public final ConstrainedLayoutReference component4() {
            return this.this$0.createRef();
        }

        public final ConstrainedLayoutReference component5() {
            return this.this$0.createRef();
        }

        public final ConstrainedLayoutReference component6() {
            return this.this$0.createRef();
        }

        public final ConstrainedLayoutReference component7() {
            return this.this$0.createRef();
        }

        public final ConstrainedLayoutReference component8() {
            return this.this$0.createRef();
        }

        public final ConstrainedLayoutReference component9() {
            return this.this$0.createRef();
        }

        public final ConstrainedLayoutReference component10() {
            return this.this$0.createRef();
        }

        public final ConstrainedLayoutReference component11() {
            return this.this$0.createRef();
        }

        public final ConstrainedLayoutReference component12() {
            return this.this$0.createRef();
        }

        public final ConstrainedLayoutReference component13() {
            return this.this$0.createRef();
        }

        public final ConstrainedLayoutReference component14() {
            return this.this$0.createRef();
        }

        public final ConstrainedLayoutReference component15() {
            return this.this$0.createRef();
        }

        public final ConstrainedLayoutReference component16() {
            return this.this$0.createRef();
        }
    }

    public final Modifier constrainAs(Modifier modifier, ConstrainedLayoutReference constrainedLayoutReference, Function1<? super ConstrainScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(constrainedLayoutReference, "ref");
        Intrinsics.checkNotNullParameter(function1, "constrainBlock");
        return modifier.then(new ConstrainAsModifier(constrainedLayoutReference, function1));
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B&\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\t¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0016\u0010\u0011\u001a\u00020\u0012*\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u000eH\u0016R\u001f\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/constraintlayout/compose/ConstraintLayoutScope$ConstrainAsModifier;", "Landroidx/compose/ui/layout/ParentDataModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "ref", "Landroidx/constraintlayout/compose/ConstrainedLayoutReference;", "constrainBlock", "Lkotlin/Function1;", "Landroidx/constraintlayout/compose/ConstrainScope;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/constraintlayout/compose/ConstrainedLayoutReference;Lkotlin/jvm/functions/Function1;)V", "equals", "", "other", "", "hashCode", "", "modifyParentData", "Landroidx/constraintlayout/compose/ConstraintLayoutParentData;", "Landroidx/compose/ui/unit/Density;", "parentData", "compose_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ConstraintLayout.kt */
    private static final class ConstrainAsModifier extends InspectorValueInfo implements ParentDataModifier {
        private final Function1<ConstrainScope, Unit> constrainBlock;
        private final ConstrainedLayoutReference ref;

        public boolean all(Function1<? super Modifier.Element, Boolean> function1) {
            return ParentDataModifier.DefaultImpls.all(this, function1);
        }

        public boolean any(Function1<? super Modifier.Element, Boolean> function1) {
            return ParentDataModifier.DefaultImpls.any(this, function1);
        }

        public <R> R foldIn(R r, Function2<? super R, ? super Modifier.Element, ? extends R> function2) {
            return ParentDataModifier.DefaultImpls.foldIn(this, r, function2);
        }

        public <R> R foldOut(R r, Function2<? super Modifier.Element, ? super R, ? extends R> function2) {
            return ParentDataModifier.DefaultImpls.foldOut(this, r, function2);
        }

        public Modifier then(Modifier modifier) {
            return ParentDataModifier.DefaultImpls.then(this, modifier);
        }

        public ConstraintLayoutParentData modifyParentData(Density density, Object obj) {
            Intrinsics.checkNotNullParameter(density, "<this>");
            return new ConstraintLayoutParentData(this.ref, this.constrainBlock);
        }

        public int hashCode() {
            return this.constrainBlock.hashCode();
        }

        public boolean equals(Object obj) {
            Function1<ConstrainScope, Unit> function1 = this.constrainBlock;
            Function1<ConstrainScope, Unit> function12 = null;
            ConstrainAsModifier constrainAsModifier = obj instanceof ConstrainAsModifier ? (ConstrainAsModifier) obj : null;
            if (constrainAsModifier != null) {
                function12 = constrainAsModifier.constrainBlock;
            }
            return Intrinsics.areEqual((Object) function1, (Object) function12);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ConstrainAsModifier(ConstrainedLayoutReference constrainedLayoutReference, Function1<? super ConstrainScope, Unit> function1) {
            super(InspectableValueKt.isDebugInspectorInfoEnabled() ? new ConstraintLayoutScope$ConstrainAsModifier$special$$inlined$debugInspectorInfo$1(constrainedLayoutReference, function1) : InspectableValueKt.getNoInspectorInfo());
            Intrinsics.checkNotNullParameter(constrainedLayoutReference, "ref");
            Intrinsics.checkNotNullParameter(function1, "constrainBlock");
            this.ref = constrainedLayoutReference;
            this.constrainBlock = function1;
        }
    }
}
