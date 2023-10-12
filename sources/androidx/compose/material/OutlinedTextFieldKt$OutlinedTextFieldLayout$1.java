package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: OutlinedTextField.kt */
final class OutlinedTextFieldKt$OutlinedTextFieldLayout$1 extends Lambda implements Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ int $$dirty2;
    final /* synthetic */ Function2<Composer, Integer, Unit> $decoratedLabel;
    final /* synthetic */ Function3<Modifier, Composer, Integer, Unit> $decoratedPlaceholder;
    final /* synthetic */ long $indicatorColor;
    final /* synthetic */ float $indicatorWidth;
    final /* synthetic */ float $labelProgress;
    final /* synthetic */ MutableState<Size> $labelSize;
    final /* synthetic */ Function2<Composer, Integer, Unit> $leading;
    final /* synthetic */ long $leadingColor;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ boolean $singleLine;
    final /* synthetic */ Function2<Composer, Integer, Unit> $trailing;
    final /* synthetic */ long $trailingColor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OutlinedTextFieldKt$OutlinedTextFieldLayout$1(MutableState<Size> mutableState, Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, boolean z, long j, long j2, float f, int i, Shape shape, float f2, long j3, int i2, int i3) {
        super(3);
        this.$labelSize = mutableState;
        this.$decoratedPlaceholder = function3;
        this.$decoratedLabel = function2;
        this.$leading = function22;
        this.$trailing = function23;
        this.$singleLine = z;
        this.$leadingColor = j;
        this.$trailingColor = j2;
        this.$labelProgress = f;
        this.$$dirty1 = i;
        this.$shape = shape;
        this.$indicatorWidth = f2;
        this.$indicatorColor = j3;
        this.$$dirty = i2;
        this.$$dirty2 = i3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((Function2<? super Composer, ? super Integer, Unit>) (Function2) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        int i2;
        Function2<? super Composer, ? super Integer, Unit> function22 = function2;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(function22, "coreTextField");
        ComposerKt.sourceInformation(composer2, "C356@17643L388,349@17335L1021:OutlinedTextField.kt#jmzs0o");
        if ((i & 14) == 0) {
            i2 = i | (composer2.changed((Object) function22) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (((i2 & 91) ^ 18) != 0 || !composer.getSkipping()) {
            long r17 = this.$labelSize.getValue().m1427unboximpl();
            Function3<Modifier, Composer, Integer, Unit> function3 = this.$decoratedPlaceholder;
            Function2<Composer, Integer, Unit> function23 = this.$decoratedLabel;
            Function2<Composer, Integer, Unit> function24 = this.$leading;
            Function2<Composer, Integer, Unit> function25 = this.$trailing;
            boolean z = this.$singleLine;
            long j = this.$leadingColor;
            long j2 = this.$trailingColor;
            float f = this.$labelProgress;
            Float valueOf = Float.valueOf(f);
            MutableState<Size> mutableState = this.$labelSize;
            float f2 = this.$labelProgress;
            float f3 = f;
            composer2.startReplaceableGroup(-3686552);
            ComposerKt.sourceInformation(composer2, "C(remember)P(1,2):Composables.kt#9igjgp");
            boolean changed = composer2.changed((Object) valueOf) | composer2.changed((Object) mutableState);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new OutlinedTextFieldKt$OutlinedTextFieldLayout$1$1$1(f2, mutableState);
                composer2.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            Shape shape = this.$shape;
            long j3 = j2;
            float f4 = this.$indicatorWidth;
            long j4 = this.$indicatorColor;
            int i3 = i2 & 14;
            int i4 = this.$$dirty1;
            int i5 = i3 | ((i4 >> 3) & 112) | ((i4 >> 3) & 896) | ((i4 >> 3) & 7168) | (57344 & (i4 >> 3)) | (458752 & (this.$$dirty >> 9)) | (3670016 & i4) | (29360128 & i4) | (234881024 & i4);
            int i6 = this.$$dirty2;
            long j5 = j3;
            OutlinedTextFieldKt.m1051IconsWithTextFieldLayoutT2E5_Oc(function2, function3, function23, function24, function25, z, j, j5, f3, (Function1) rememberedValue, shape, f4, j4, r17, composer, i5, ((i4 >> 24) & 112) | ((i6 >> 9) & 14) | ((i6 << 6) & 896));
            return;
        }
        composer.skipToGroupEnd();
    }
}
