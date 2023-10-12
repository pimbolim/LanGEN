package androidx.compose.ui.node;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0014J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nH\u0016J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nH\u0016J\u001d\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nH\u0016J\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nH\u0016J\b\u0010\u001b\u001a\u00020\u0002H\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 H\u0016R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\""}, d2 = {"Landroidx/compose/ui/node/ModifiedLayoutNode;", "Landroidx/compose/ui/node/DelegatingLayoutNodeWrapper;", "Landroidx/compose/ui/layout/LayoutModifier;", "wrapped", "Landroidx/compose/ui/node/LayoutNodeWrapper;", "modifier", "(Landroidx/compose/ui/node/LayoutNodeWrapper;Landroidx/compose/ui/layout/LayoutModifier;)V", "modifierState", "Landroidx/compose/runtime/MutableState;", "calculateAlignmentLine", "", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "getWrappedByCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "maxIntrinsicHeight", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicHeight", "minIntrinsicWidth", "modifierFromState", "onModifierChanged", "", "performDraw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "Companion", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ModifiedLayoutNode.kt */
public final class ModifiedLayoutNode extends DelegatingLayoutNodeWrapper<LayoutModifier> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Paint modifierBoundsPaint;
    private MutableState<LayoutModifier> modifierState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ModifiedLayoutNode(LayoutNodeWrapper layoutNodeWrapper, LayoutModifier layoutModifier) {
        super(layoutNodeWrapper, layoutModifier);
        Intrinsics.checkNotNullParameter(layoutNodeWrapper, "wrapped");
        Intrinsics.checkNotNullParameter(layoutModifier, "modifier");
    }

    /* renamed from: measure-BRTryo0  reason: not valid java name */
    public Placeable m3360measureBRTryo0(long j) {
        LayoutNodeWrapper layoutNodeWrapper = this;
        layoutNodeWrapper.m3177setMeasurementConstraintsBRTryo0(j);
        setMeasureResult$ui_release(((LayoutModifier) getModifier()).m3149measure3p2s80s(getMeasureScope(), getWrapped$ui_release(), j));
        Placeable placeable = this;
        OwnedLayer layer = layoutNodeWrapper.getLayer();
        if (layer != null) {
            layer.m3370resizeozmzZPI(layoutNodeWrapper.m3173getMeasuredSizeYbymL2g());
        }
        return placeable;
    }

    public int minIntrinsicWidth(int i) {
        return modifierFromState().minIntrinsicWidth(getMeasureScope(), getWrapped$ui_release(), i);
    }

    public int maxIntrinsicWidth(int i) {
        return modifierFromState().maxIntrinsicWidth(getMeasureScope(), getWrapped$ui_release(), i);
    }

    public int minIntrinsicHeight(int i) {
        return modifierFromState().minIntrinsicHeight(getMeasureScope(), getWrapped$ui_release(), i);
    }

    public int maxIntrinsicHeight(int i) {
        return modifierFromState().maxIntrinsicHeight(getMeasureScope(), getWrapped$ui_release(), i);
    }

    private final LayoutModifier modifierFromState() {
        MutableState<LayoutModifier> mutableState = this.modifierState;
        if (mutableState == null) {
            mutableState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getModifier(), (SnapshotMutationPolicy) null, 2, (Object) null);
        }
        this.modifierState = mutableState;
        return mutableState.getValue();
    }

    public void onModifierChanged() {
        super.onModifierChanged();
        MutableState<LayoutModifier> mutableState = this.modifierState;
        if (mutableState != null) {
            mutableState.setValue(getModifier());
        }
    }

    public int calculateAlignmentLine(AlignmentLine alignmentLine) {
        int i;
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        if (getMeasureResult().getAlignmentLines().containsKey(alignmentLine)) {
            Integer num = getMeasureResult().getAlignmentLines().get(alignmentLine);
            if (num == null) {
                return Integer.MIN_VALUE;
            }
            return num.intValue();
        }
        int i2 = getWrapped$ui_release().get(alignmentLine);
        if (i2 == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        setShallowPlacing(true);
        m3246placeAtf8xVGno(m3343getPositionnOccac(), getZIndex(), getLayerBlock());
        setShallowPlacing(false);
        if (alignmentLine instanceof HorizontalAlignmentLine) {
            i = IntOffset.m3978getYimpl(getWrapped$ui_release().m3343getPositionnOccac());
        } else {
            i = IntOffset.m3977getXimpl(getWrapped$ui_release().m3343getPositionnOccac());
        }
        return i2 + i;
    }

    public void performDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        getWrapped$ui_release().draw(canvas);
        if (LayoutNodeKt.requireOwner(getLayoutNode$ui_release()).getShowLayoutBounds()) {
            drawBorder(canvas, modifierBoundsPaint);
        }
    }

    /* access modifiers changed from: protected */
    public LayoutCoordinates getWrappedByCoordinates() {
        return this;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/node/ModifiedLayoutNode$Companion;", "", "()V", "modifierBoundsPaint", "Landroidx/compose/ui/graphics/Paint;", "getModifierBoundsPaint", "()Landroidx/compose/ui/graphics/Paint;", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ModifiedLayoutNode.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Paint getModifierBoundsPaint() {
            return ModifiedLayoutNode.modifierBoundsPaint;
        }
    }

    static {
        Paint Paint = AndroidPaint_androidKt.Paint();
        Paint.m1803setColor8_81llA(Color.Companion.m1623getBlue0d7_KjU());
        Paint.setStrokeWidth(1.0f);
        Paint.m1807setStylek9PVt8s(PaintingStyle.Companion.m1816getStrokeTiuSbCo());
        modifierBoundsPaint = Paint;
    }
}
