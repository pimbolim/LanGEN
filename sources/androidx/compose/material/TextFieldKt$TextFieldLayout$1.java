package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import com.nimbusds.jose.shaded.ow2asm.Opcodes;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextField.kt */
final class TextFieldKt$TextFieldLayout$1 extends Lambda implements Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ Function2<Composer, Integer, Unit> $decoratedLabel;
    final /* synthetic */ Function3<Modifier, Composer, Integer, Unit> $decoratedPlaceholder;
    final /* synthetic */ float $labelProgress;
    final /* synthetic */ Function2<Composer, Integer, Unit> $leading;
    final /* synthetic */ long $leadingColor;
    final /* synthetic */ boolean $singleLine;
    final /* synthetic */ Function2<Composer, Integer, Unit> $trailing;
    final /* synthetic */ long $trailingColor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldKt$TextFieldLayout$1(Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, boolean z, long j, long j2, float f, int i, int i2) {
        super(3);
        this.$decoratedLabel = function2;
        this.$decoratedPlaceholder = function3;
        this.$leading = function22;
        this.$trailing = function23;
        this.$singleLine = z;
        this.$leadingColor = j;
        this.$trailingColor = j2;
        this.$labelProgress = f;
        this.$$dirty1 = i;
        this.$$dirty = i2;
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
        ComposerKt.sourceInformation(composer2, "C368@17851L429:TextField.kt#jmzs0o");
        if ((i & 14) == 0) {
            i2 = i | (composer2.changed((Object) function22) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (((i2 & 91) ^ 18) != 0 || !composer.getSkipping()) {
            Function2<Composer, Integer, Unit> function23 = this.$decoratedLabel;
            Function3<Modifier, Composer, Integer, Unit> function3 = this.$decoratedPlaceholder;
            Function2<Composer, Integer, Unit> function24 = this.$leading;
            Function2<Composer, Integer, Unit> function25 = this.$trailing;
            boolean z = this.$singleLine;
            long j = this.$leadingColor;
            long j2 = this.$trailingColor;
            float f = this.$labelProgress;
            int i3 = this.$$dirty1;
            TextFieldKt.m1170IconsWithTextFieldLayoutSxpAMN0(function2, function23, function3, function24, function25, z, j, j2, f, composer, (i3 & 234881024) | (i2 & 14) | ((i3 >> 6) & 112) | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 >> 3) & 57344) | ((this.$$dirty >> 9) & Opcodes.ASM7) | (3670016 & i3) | (29360128 & i3));
            return;
        }
        composer.skipToGroupEnd();
    }
}
