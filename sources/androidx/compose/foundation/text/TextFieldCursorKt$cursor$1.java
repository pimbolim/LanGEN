package androidx.compose.foundation.text;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextFieldCursor.kt */
final class TextFieldCursorKt$cursor$1 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ Brush $cursorBrush;
    final /* synthetic */ OffsetMapping $offsetMapping;
    final /* synthetic */ TextFieldState $state;
    final /* synthetic */ TextFieldValue $value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldCursorKt$cursor$1(Brush brush, TextFieldState textFieldState, TextFieldValue textFieldValue, OffsetMapping offsetMapping) {
        super(3);
        this.$cursorBrush = brush;
        this.$state = textFieldState;
        this.$value = textFieldValue;
        this.$offsetMapping = offsetMapping;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0054, code lost:
        if ((((androidx.compose.ui.graphics.SolidColor) r13).m1898getValue0d7_KjU() == androidx.compose.ui.graphics.Color.Companion.m1632getUnspecified0d7_KjU()) == false) goto L_0x0056;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.ui.Modifier invoke(androidx.compose.ui.Modifier r11, androidx.compose.runtime.Composer r12, int r13) {
        /*
            r10 = this;
            java.lang.String r13 = "$this$composed"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r13)
            r13 = -1201392955(0xffffffffb86432c5, float:-5.440672E-5)
            r12.startReplaceableGroup(r13)
            java.lang.String r13 = "C44@1689L27,47@1891L138:TextFieldCursor.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r13)
            r13 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r12.startReplaceableGroup(r13)
            java.lang.String r13 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r13)
            java.lang.Object r13 = r12.rememberedValue()
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            r1 = 0
            if (r13 != r0) goto L_0x0033
            r13 = 1065353216(0x3f800000, float:1.0)
            r0 = 0
            r2 = 2
            androidx.compose.animation.core.Animatable r13 = androidx.compose.animation.core.AnimatableKt.Animatable$default(r13, r0, r2, r1)
            r12.updateRememberedValue(r13)
        L_0x0033:
            r12.endReplaceableGroup()
            r3 = r13
            androidx.compose.animation.core.Animatable r3 = (androidx.compose.animation.core.Animatable) r3
            androidx.compose.ui.graphics.Brush r13 = r10.$cursorBrush
            boolean r0 = r13 instanceof androidx.compose.ui.graphics.SolidColor
            r2 = 0
            r4 = 1
            if (r0 == 0) goto L_0x0056
            androidx.compose.ui.graphics.SolidColor r13 = (androidx.compose.ui.graphics.SolidColor) r13
            long r5 = r13.m1898getValue0d7_KjU()
            androidx.compose.ui.graphics.Color$Companion r13 = androidx.compose.ui.graphics.Color.Companion
            long r7 = r13.m1632getUnspecified0d7_KjU()
            int r13 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r13 != 0) goto L_0x0053
            r13 = 1
            goto L_0x0054
        L_0x0053:
            r13 = 0
        L_0x0054:
            if (r13 != 0) goto L_0x0057
        L_0x0056:
            r2 = 1
        L_0x0057:
            androidx.compose.foundation.text.TextFieldState r13 = r10.$state
            boolean r13 = r13.getHasFocus()
            if (r13 == 0) goto L_0x00a1
            androidx.compose.ui.text.input.TextFieldValue r13 = r10.$value
            long r4 = r13.m3688getSelectiond9O1mEE()
            boolean r13 = androidx.compose.ui.text.TextRange.m3565getCollapsedimpl(r4)
            if (r13 == 0) goto L_0x00a1
            if (r2 == 0) goto L_0x00a1
            androidx.compose.ui.graphics.Brush r4 = r10.$cursorBrush
            androidx.compose.ui.text.input.TextFieldValue r13 = r10.$value
            androidx.compose.ui.text.AnnotatedString r5 = r13.getAnnotatedString()
            androidx.compose.ui.text.input.TextFieldValue r13 = r10.$value
            long r6 = r13.m3688getSelectiond9O1mEE()
            androidx.compose.ui.text.TextRange r6 = androidx.compose.ui.text.TextRange.m3559boximpl(r6)
            androidx.compose.foundation.text.TextFieldCursorKt$cursor$1$1 r13 = new androidx.compose.foundation.text.TextFieldCursorKt$cursor$1$1
            r13.<init>(r3, r1)
            r7 = r13
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r9 = 0
            r8 = r12
            androidx.compose.runtime.EffectsKt.LaunchedEffect(r4, r5, r6, r7, r8, r9)
            androidx.compose.foundation.text.TextFieldCursorKt$cursor$1$2 r13 = new androidx.compose.foundation.text.TextFieldCursorKt$cursor$1$2
            androidx.compose.ui.text.input.OffsetMapping r4 = r10.$offsetMapping
            androidx.compose.ui.text.input.TextFieldValue r5 = r10.$value
            androidx.compose.foundation.text.TextFieldState r6 = r10.$state
            androidx.compose.ui.graphics.Brush r7 = r10.$cursorBrush
            r2 = r13
            r2.<init>(r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function1 r13 = (kotlin.jvm.functions.Function1) r13
            androidx.compose.ui.Modifier r11 = androidx.compose.ui.draw.DrawModifierKt.drawWithContent(r11, r13)
            goto L_0x00a5
        L_0x00a1:
            androidx.compose.ui.Modifier$Companion r11 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r11 = (androidx.compose.ui.Modifier) r11
        L_0x00a5:
            r12.endReplaceableGroup()
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.TextFieldCursorKt$cursor$1.invoke(androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int):androidx.compose.ui.Modifier");
    }
}
