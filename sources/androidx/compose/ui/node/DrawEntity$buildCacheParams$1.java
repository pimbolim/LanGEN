package androidx.compose.ui.node;

import androidx.compose.ui.draw.BuildDrawCacheParams;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001d\u0010\n\u001a\u00020\u000b8VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\f\u0010\r\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000e"}, d2 = {"androidx/compose/ui/node/DrawEntity$buildCacheParams$1", "Landroidx/compose/ui/draw/BuildDrawCacheParams;", "density", "Landroidx/compose/ui/unit/Density;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "()J", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DrawEntity.kt */
public final class DrawEntity$buildCacheParams$1 implements BuildDrawCacheParams {
    private final Density density;
    final /* synthetic */ DrawEntity this$0;

    DrawEntity$buildCacheParams$1(DrawEntity drawEntity) {
        this.this$0 = drawEntity;
        this.density = drawEntity.getLayoutNode().getDensity();
    }

    public Density getDensity() {
        return this.density;
    }

    public LayoutDirection getLayoutDirection() {
        return this.this$0.getLayoutNode().getLayoutDirection();
    }

    /* renamed from: getSize-NH-jbRc  reason: not valid java name */
    public long m3258getSizeNHjbRc() {
        return IntSizeKt.m4029toSizeozmzZPI(this.this$0.getLayoutNodeWrapper().m3344getSizeYbymL2g());
    }
}
