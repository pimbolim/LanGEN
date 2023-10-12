package androidx.compose.material;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: OutlinedTextField.kt */
final class OutlinedTextFieldKt$OutlinedTextFieldLayout$1$1$1 extends Lambda implements Function1<Size, Unit> {
    final /* synthetic */ float $labelProgress;
    final /* synthetic */ MutableState<Size> $labelSize;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OutlinedTextFieldKt$OutlinedTextFieldLayout$1$1$1(float f, MutableState<Size> mutableState) {
        super(1);
        this.$labelProgress = f;
        this.$labelSize = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m1063invokeuvyYCjk(((Size) obj).m1427unboximpl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-uvyYCjk  reason: not valid java name */
    public final void m1063invokeuvyYCjk(long j) {
        float r0 = Size.m1422getWidthimpl(j) * this.$labelProgress;
        float r6 = Size.m1419getHeightimpl(j) * this.$labelProgress;
        boolean z = true;
        if (Size.m1422getWidthimpl(this.$labelSize.getValue().m1427unboximpl()) == r0) {
            if (Size.m1419getHeightimpl(this.$labelSize.getValue().m1427unboximpl()) != r6) {
                z = false;
            }
            if (z) {
                return;
            }
        }
        this.$labelSize.setValue(Size.m1410boximpl(SizeKt.Size(r0, r6)));
    }
}
