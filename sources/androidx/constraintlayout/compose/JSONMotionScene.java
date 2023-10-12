package androidx.constraintlayout.compose;

import java.util.Collection;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\rH\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0004H\u0014J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\tH\u0014J\b\u0010\u0015\u001a\u00020\u0012H\u0016J\u0018\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u0018\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0016R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Landroidx/constraintlayout/compose/JSONMotionScene;", "Landroidx/constraintlayout/compose/EditableJSONLayout;", "Landroidx/constraintlayout/compose/MotionScene;", "content", "", "(Ljava/lang/String;)V", "constraintSetsContent", "Ljava/util/HashMap;", "forcedProgress", "", "transitionsContent", "getConstraintSet", "index", "", "name", "getForcedProgress", "getTransition", "onNewContent", "", "onNewProgress", "progress", "resetForcedProgress", "setConstraintSetContent", "setTransitionContent", "compose_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: MotionLayout.kt */
public final class JSONMotionScene extends EditableJSONLayout implements MotionScene {
    private final HashMap<String, String> constraintSetsContent = new HashMap<>();
    private float forcedProgress = Float.NaN;
    private final HashMap<String, String> transitionsContent = new HashMap<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JSONMotionScene(String str) {
        super(str);
        Intrinsics.checkNotNullParameter(str, "content");
        initialization();
    }

    public void setConstraintSetContent(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "content");
        this.constraintSetsContent.put(str, str2);
    }

    public void setTransitionContent(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "content");
        this.transitionsContent.put(str, str2);
    }

    public String getConstraintSet(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return this.constraintSetsContent.get(str);
    }

    public String getConstraintSet(int i) {
        Collection<String> values = this.constraintSetsContent.values();
        Intrinsics.checkNotNullExpressionValue(values, "constraintSetsContent.values");
        return (String) CollectionsKt.elementAtOrNull(values, i);
    }

    public String getTransition(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return this.transitionsContent.get(str);
    }

    public float getForcedProgress() {
        return this.forcedProgress;
    }

    public void resetForcedProgress() {
        this.forcedProgress = Float.NaN;
    }

    /* access modifiers changed from: protected */
    public void onNewContent(String str) {
        Intrinsics.checkNotNullParameter(str, "content");
        super.onNewContent(str);
        try {
            ConstraintSetParserKt.parseMotionSceneJSON(this, str);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: protected */
    public void onNewProgress(float f) {
        this.forcedProgress = f;
        signalUpdate();
    }
}
