package androidx.compose.foundation.text;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: MaxLinesHeightModifier.kt */
final class MaxLinesHeightModifierKt$maxLinesHeight$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ int $maxLines;
    final /* synthetic */ TextStyle $textStyle;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MaxLinesHeightModifierKt$maxLinesHeight$2(int i, TextStyle textStyle) {
        super(3);
        this.$maxLines = i;
        this.$textStyle = textStyle;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    public final Modifier invoke(Modifier modifier, Composer composer, int i) {
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer2.startReplaceableGroup(-1924217056);
        ComposerKt.sourceInformation(composer2, "C49@1714L7,50@1763L7,51@1818L7,55@1991L328,64@2350L390:MaxLinesHeightModifier.kt#423gt5");
        int i2 = this.$maxLines;
        int i3 = 0;
        if (!(i2 > 0)) {
            throw new IllegalArgumentException("maxLines must be greater than 0".toString());
        } else if (i2 == Integer.MAX_VALUE) {
            Modifier.Companion companion = Modifier.Companion;
            composer.endReplaceableGroup();
            return companion;
        } else {
            ComposerKt.sourceInformationMarkerStart(composer2, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume = composer2.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(composer);
            Density density = (Density) consume;
            ComposerKt.sourceInformationMarkerStart(composer2, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = composer2.consume(CompositionLocalsKt.getLocalFontLoader());
            ComposerKt.sourceInformationMarkerEnd(composer);
            Font.ResourceLoader resourceLoader = (Font.ResourceLoader) consume2;
            ComposerKt.sourceInformationMarkerStart(composer2, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(composer);
            LayoutDirection layoutDirection = (LayoutDirection) consume3;
            TextStyle textStyle = this.$textStyle;
            Object[] objArr = {density, resourceLoader, textStyle, layoutDirection};
            composer2.startReplaceableGroup(-3685570);
            ComposerKt.sourceInformation(composer2, "C(remember)P(1):Composables.kt#9igjgp");
            int i4 = 0;
            boolean z = false;
            while (i4 < 4) {
                Object obj = objArr[i4];
                i4++;
                z |= composer2.changed(obj);
            }
            Object rememberedValue = composer.rememberedValue();
            if (z || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = Integer.valueOf(IntSize.m4018getHeightimpl(TextFieldDelegateKt.computeSizeForDefaultText(TextStyleKt.resolveDefaults(textStyle, layoutDirection), density, resourceLoader, TextFieldDelegateKt.getEmptyTextReplacement(), 1)));
                composer2.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            int intValue = ((Number) rememberedValue).intValue();
            TextStyle textStyle2 = this.$textStyle;
            Object[] objArr2 = {density, resourceLoader, textStyle2, layoutDirection};
            composer2.startReplaceableGroup(-3685570);
            ComposerKt.sourceInformation(composer2, "C(remember)P(1):Composables.kt#9igjgp");
            boolean z2 = false;
            while (i3 < 4) {
                Object obj2 = objArr2[i3];
                i3++;
                z2 |= composer2.changed(obj2);
            }
            Object rememberedValue2 = composer.rememberedValue();
            if (z2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = Integer.valueOf(IntSize.m4018getHeightimpl(TextFieldDelegateKt.computeSizeForDefaultText(TextStyleKt.resolveDefaults(textStyle2, layoutDirection), density, resourceLoader, TextFieldDelegateKt.getEmptyTextReplacement() + 10 + TextFieldDelegateKt.getEmptyTextReplacement(), 2)));
                composer2.updateRememberedValue(rememberedValue2);
            }
            composer.endReplaceableGroup();
            Modifier r2 = SizeKt.m480heightInVpY3zN4$default(Modifier.Companion, 0.0f, density.m3825toDpu2uoSUM(intValue + ((((Number) rememberedValue2).intValue() - intValue) * (this.$maxLines - 1))), 1, (Object) null);
            composer.endReplaceableGroup();
            return r2;
        }
    }
}
