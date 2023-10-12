package androidx.compose.foundation;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "invoke", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* renamed from: androidx.compose.foundation.BorderKt$border-ziNgDLE$$inlined$debugInspectorInfo$1  reason: invalid class name */
/* compiled from: InspectableValue.kt */
public final class BorderKt$borderziNgDLE$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<InspectorInfo, Unit> {
    final /* synthetic */ Brush $brush$inlined;
    final /* synthetic */ Shape $shape$inlined;
    final /* synthetic */ float $width$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BorderKt$borderziNgDLE$$inlined$debugInspectorInfo$1(float f, Brush brush, Shape shape) {
        super(1);
        this.$width$inlined = f;
        this.$brush$inlined = brush;
        this.$shape$inlined = shape;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InspectorInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(InspectorInfo inspectorInfo) {
        Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
        inspectorInfo.setName("border");
        inspectorInfo.getProperties().set("width", Dp.m3857boximpl(this.$width$inlined));
        if (this.$brush$inlined instanceof SolidColor) {
            inspectorInfo.getProperties().set("color", Color.m1586boximpl(((SolidColor) this.$brush$inlined).m1898getValue0d7_KjU()));
            inspectorInfo.setValue(Color.m1586boximpl(((SolidColor) this.$brush$inlined).m1898getValue0d7_KjU()));
        } else {
            inspectorInfo.getProperties().set("brush", this.$brush$inlined);
        }
        inspectorInfo.getProperties().set("shape", this.$shape$inlined);
    }
}