package androidx.constraintlayout.compose;

import androidx.constraintlayout.core.state.RegistryCallback;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\nH\u0016J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\nH\u0016¨\u0006\u0015"}, d2 = {"androidx/constraintlayout/compose/EditableJSONLayout$initialization$callback$1", "Landroidx/constraintlayout/core/state/RegistryCallback;", "currentLayoutInformation", "", "currentMotionScene", "getLastModified", "", "onDimensions", "", "width", "", "height", "onNewMotionScene", "content", "onProgress", "progress", "", "setDrawDebug", "debugMode", "setLayoutInformationMode", "mode", "compose_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ConstraintLayout.kt */
public final class EditableJSONLayout$initialization$callback$1 implements RegistryCallback {
    final /* synthetic */ EditableJSONLayout this$0;

    EditableJSONLayout$initialization$callback$1(EditableJSONLayout editableJSONLayout) {
        this.this$0 = editableJSONLayout;
    }

    public void onNewMotionScene(String str) {
        if (str != null) {
            this.this$0.onNewContent(str);
        }
    }

    public void onProgress(float f) {
        this.this$0.onNewProgress(f);
    }

    public void onDimensions(int i, int i2) {
        this.this$0.onNewDimensions(i, i2);
    }

    public String currentMotionScene() {
        return this.this$0.currentContent;
    }

    public String currentLayoutInformation() {
        return this.this$0.layoutInformation;
    }

    public void setLayoutInformationMode(int i) {
        this.this$0.onLayoutInformation(i);
    }

    public long getLastModified() {
        return this.this$0.last;
    }

    public void setDrawDebug(int i) {
        this.this$0.onDrawDebug(i);
    }
}
