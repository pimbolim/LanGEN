package androidx.compose.ui.node;

import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\r\u001a\u00020\u000eH\u0016R \u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\u000f"}, d2 = {"androidx/compose/ui/node/DelegatingLayoutNodeWrapper$measure$1$1", "Landroidx/compose/ui/layout/MeasureResult;", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "", "getAlignmentLines", "()Ljava/util/Map;", "height", "getHeight", "()I", "width", "getWidth", "placeChildren", "", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DelegatingLayoutNodeWrapper.kt */
public final class DelegatingLayoutNodeWrapper$measure$1$1 implements MeasureResult {
    final /* synthetic */ Placeable $placeable;
    private final Map<AlignmentLine, Integer> alignmentLines = MapsKt.emptyMap();
    private final int height;
    final /* synthetic */ DelegatingLayoutNodeWrapper<T> this$0;
    private final int width;

    DelegatingLayoutNodeWrapper$measure$1$1(DelegatingLayoutNodeWrapper<T> delegatingLayoutNodeWrapper, Placeable placeable) {
        this.this$0 = delegatingLayoutNodeWrapper;
        this.$placeable = placeable;
        this.width = delegatingLayoutNodeWrapper.getWrapped$ui_release().getMeasureResult().getWidth();
        this.height = delegatingLayoutNodeWrapper.getWrapped$ui_release().getMeasureResult().getHeight();
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public Map<AlignmentLine, Integer> getAlignmentLines() {
        return this.alignmentLines;
    }

    public void placeChildren() {
        Placeable.PlacementScope.Companion companion = Placeable.PlacementScope.Companion;
        Placeable placeable = this.$placeable;
        long r3 = this.this$0.m3172getApparentToRealOffsetnOccac();
        Placeable.PlacementScope.m3178place70tqf50$default(companion, placeable, IntOffsetKt.IntOffset(-IntOffset.m3977getXimpl(r3), -IntOffset.m3978getYimpl(r3)), 0.0f, 2, (Object) null);
    }
}
