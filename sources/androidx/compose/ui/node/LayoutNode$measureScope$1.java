package androidx.compose.ui.node;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"androidx/compose/ui/node/LayoutNode$measureScope$1", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/unit/Density;", "density", "", "getDensity", "()F", "fontScale", "getFontScale", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LayoutNode.kt */
public final class LayoutNode$measureScope$1 implements MeasureScope, Density {
    final /* synthetic */ LayoutNode this$0;

    LayoutNode$measureScope$1(LayoutNode layoutNode) {
        this.this$0 = layoutNode;
    }

    public MeasureResult layout(int i, int i2, Map<AlignmentLine, Integer> map, Function1<? super Placeable.PlacementScope, Unit> function1) {
        return MeasureScope.DefaultImpls.layout(this, i, i2, map, function1);
    }

    /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
    public int m3289roundToPxR2X_6o(long j) {
        return MeasureScope.DefaultImpls.m3153roundToPxR2X_6o(this, j);
    }

    /* renamed from: roundToPx-0680j_4  reason: not valid java name */
    public int m3290roundToPx0680j_4(float f) {
        return MeasureScope.DefaultImpls.m3154roundToPx0680j_4(this, f);
    }

    /* renamed from: toDp-GaN1DYA  reason: not valid java name */
    public float m3291toDpGaN1DYA(long j) {
        return MeasureScope.DefaultImpls.m3155toDpGaN1DYA(this, j);
    }

    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    public float m3292toDpu2uoSUM(float f) {
        return MeasureScope.DefaultImpls.m3156toDpu2uoSUM((MeasureScope) this, f);
    }

    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    public float m3293toDpu2uoSUM(int i) {
        return MeasureScope.DefaultImpls.m3157toDpu2uoSUM((MeasureScope) this, i);
    }

    /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
    public long m3294toDpSizekrfVVM(long j) {
        return MeasureScope.DefaultImpls.m3158toDpSizekrfVVM(this, j);
    }

    /* renamed from: toPx--R2X_6o  reason: not valid java name */
    public float m3295toPxR2X_6o(long j) {
        return MeasureScope.DefaultImpls.m3159toPxR2X_6o(this, j);
    }

    /* renamed from: toPx-0680j_4  reason: not valid java name */
    public float m3296toPx0680j_4(float f) {
        return MeasureScope.DefaultImpls.m3160toPx0680j_4(this, f);
    }

    public Rect toRect(DpRect dpRect) {
        return MeasureScope.DefaultImpls.toRect(this, dpRect);
    }

    /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
    public long m3297toSizeXkaWNTQ(long j) {
        return MeasureScope.DefaultImpls.m3161toSizeXkaWNTQ(this, j);
    }

    /* renamed from: toSp-0xMU5do  reason: not valid java name */
    public long m3298toSp0xMU5do(float f) {
        return MeasureScope.DefaultImpls.m3162toSp0xMU5do(this, f);
    }

    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    public long m3299toSpkPz2Gy4(float f) {
        return MeasureScope.DefaultImpls.m3163toSpkPz2Gy4((MeasureScope) this, f);
    }

    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    public long m3300toSpkPz2Gy4(int i) {
        return MeasureScope.DefaultImpls.m3164toSpkPz2Gy4((MeasureScope) this, i);
    }

    public float getDensity() {
        return this.this$0.getDensity().getDensity();
    }

    public float getFontScale() {
        return this.this$0.getDensity().getFontScale();
    }

    public LayoutDirection getLayoutDirection() {
        return this.this$0.getLayoutDirection();
    }
}
