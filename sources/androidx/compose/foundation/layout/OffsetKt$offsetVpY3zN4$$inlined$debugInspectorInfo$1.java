package androidx.compose.foundation.layout;

import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.nimbusds.jose.jwk.JWKParameterNames;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "invoke", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* renamed from: androidx.compose.foundation.layout.OffsetKt$offset-VpY3zN4$$inlined$debugInspectorInfo$1  reason: invalid class name */
/* compiled from: InspectableValue.kt */
public final class OffsetKt$offsetVpY3zN4$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<InspectorInfo, Unit> {
    final /* synthetic */ float $x$inlined;
    final /* synthetic */ float $y$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OffsetKt$offsetVpY3zN4$$inlined$debugInspectorInfo$1(float f, float f2) {
        super(1);
        this.$x$inlined = f;
        this.$y$inlined = f2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InspectorInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(InspectorInfo inspectorInfo) {
        Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
        inspectorInfo.setName(TypedValues.CycleType.S_WAVE_OFFSET);
        inspectorInfo.getProperties().set("x", Dp.m3857boximpl(this.$x$inlined));
        inspectorInfo.getProperties().set(JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE, Dp.m3857boximpl(this.$y$inlined));
    }
}
