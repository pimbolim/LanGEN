package androidx.compose.ui.layout;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\b"}, d2 = {"Landroidx/compose/ui/layout/GraphicLayerInfo;", "", "layerId", "", "getLayerId", "()J", "ownerViewId", "getOwnerViewId", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GraphicLayerInfo.kt */
public interface GraphicLayerInfo {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GraphicLayerInfo.kt */
    public static final class DefaultImpls {
        public static long getOwnerViewId(GraphicLayerInfo graphicLayerInfo) {
            Intrinsics.checkNotNullParameter(graphicLayerInfo, "this");
            return 0;
        }
    }

    long getLayerId();

    long getOwnerViewId();
}
