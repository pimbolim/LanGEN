package androidx.compose.foundation.text;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextFieldSize.kt */
final class TextFieldSizeKt$textFieldMinSize$1 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ TextStyle $style;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldSizeKt$textFieldMinSize$1(TextStyle textStyle) {
        super(3);
        this.$style = textStyle;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    public final Modifier invoke(Modifier modifier, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer.startReplaceableGroup(31601380);
        ComposerKt.sourceInformation(composer, "C35@1425L7,36@1474L7,37@1529L7,39@1561L75:TextFieldSize.kt#423gt5");
        ComposerKt.sourceInformationMarkerStart(composer, 103361330, "C:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd(composer);
        Density density = (Density) consume;
        ComposerKt.sourceInformationMarkerStart(composer, 103361330, "C:CompositionLocal.kt#9igjgp");
        Object consume2 = composer.consume(CompositionLocalsKt.getLocalFontLoader());
        ComposerKt.sourceInformationMarkerEnd(composer);
        Font.ResourceLoader resourceLoader = (Font.ResourceLoader) consume2;
        ComposerKt.sourceInformationMarkerStart(composer, 103361330, "C:CompositionLocal.kt#9igjgp");
        Object consume3 = composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ComposerKt.sourceInformationMarkerEnd(composer);
        LayoutDirection layoutDirection = (LayoutDirection) consume3;
        TextStyle textStyle = this.$style;
        composer.startReplaceableGroup(-3687241);
        ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new TextFieldSize(layoutDirection, density, resourceLoader, textStyle);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        final TextFieldSize textFieldSize = (TextFieldSize) rememberedValue;
        textFieldSize.update(layoutDirection, density, resourceLoader, this.$style);
        Modifier layout = LayoutModifierKt.layout(Modifier.Companion, new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return m724invoke3p2s80s((MeasureScope) obj, (Measurable) obj2, ((Constraints) obj3).m3809unboximpl());
            }

            /* renamed from: invoke-3p2s80s  reason: not valid java name */
            public final MeasureResult m724invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
                Measurable measurable2 = measurable;
                MeasureScope measureScope2 = measureScope;
                Intrinsics.checkNotNullParameter(measureScope2, "$this$layout");
                Intrinsics.checkNotNullParameter(measurable2, "measurable");
                SizeKt.m477defaultMinSizeVpY3zN4$default(Modifier.Companion, 0.0f, 0.0f, 3, (Object) null);
                long r3 = textFieldSize.m723getMinSizeYbymL2g();
                final Placeable r0 = measurable2.m3151measureBRTryo0(Constraints.m3794copyZbe2FdA$default(j, RangesKt.coerceIn(IntSize.m4019getWidthimpl(r3), Constraints.m3805getMinWidthimpl(j), Constraints.m3803getMaxWidthimpl(j)), 0, RangesKt.coerceIn(IntSize.m4018getHeightimpl(r3), Constraints.m3804getMinHeightimpl(j), Constraints.m3802getMaxHeightimpl(j)), 0, 10, (Object) null));
                return MeasureScope.DefaultImpls.layout$default(measureScope2, r0.getWidth(), r0.getHeight(), (Map) null, new Function1<Placeable.PlacementScope, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Placeable.PlacementScope) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Placeable.PlacementScope placementScope) {
                        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
                        Placeable.PlacementScope.placeRelative$default(placementScope, r0, 0, 0, 0.0f, 4, (Object) null);
                    }
                }, 4, (Object) null);
            }
        });
        composer.endReplaceableGroup();
        return layout;
    }
}
