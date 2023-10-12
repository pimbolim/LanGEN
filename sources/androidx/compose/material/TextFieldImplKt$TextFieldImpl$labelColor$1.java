package androidx.compose.material;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextFieldImpl.kt */
final class TextFieldImplKt$TextFieldImpl$labelColor$1 extends Lambda implements Function3<InputPhase, Composer, Integer, Color> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ TextFieldColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ boolean $isError;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldImplKt$TextFieldImpl$labelColor$1(TextFieldColors textFieldColors, boolean z, boolean z2, MutableInteractionSource mutableInteractionSource, int i, int i2) {
        super(3);
        this.$colors = textFieldColors;
        this.$enabled = z;
        this.$isError = z2;
        this.$interactionSource = mutableInteractionSource;
        this.$$dirty = i;
        this.$$dirty1 = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return Color.m1586boximpl(m1169invokeXeAY9LY((InputPhase) obj, (Composer) obj2, ((Number) obj3).intValue()));
    }

    /* renamed from: invoke-XeAY9LY  reason: not valid java name */
    public final long m1169invokeXeAY9LY(InputPhase inputPhase, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(inputPhase, "it");
        composer.startReplaceableGroup(-1061048422);
        ComposerKt.sourceInformation(composer, "C102@3985L273:TextFieldImpl.kt#jmzs0o");
        TextFieldColors textFieldColors = this.$colors;
        boolean z = this.$enabled;
        boolean z2 = inputPhase == InputPhase.UnfocusedEmpty ? false : this.$isError;
        int i2 = this.$$dirty1;
        long r0 = textFieldColors.labelColor(z, z2, this.$interactionSource, composer, ((this.$$dirty >> 3) & 14) | ((i2 >> 15) & 896) | ((i2 >> 18) & 7168)).getValue().m1606unboximpl();
        composer.endReplaceableGroup();
        return r0;
    }
}
