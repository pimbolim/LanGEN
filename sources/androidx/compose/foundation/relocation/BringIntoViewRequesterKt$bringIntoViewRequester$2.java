package androidx.compose.foundation.relocation;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BringIntoViewRequester.kt */
final class BringIntoViewRequesterKt$bringIntoViewRequester$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ BringIntoViewRequester $bringIntoViewRequester;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BringIntoViewRequesterKt$bringIntoViewRequester$2(BringIntoViewRequester bringIntoViewRequester) {
        super(3);
        this.$bringIntoViewRequester = bringIntoViewRequester;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: androidx.compose.foundation.relocation.BringIntoViewData} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: androidx.compose.foundation.relocation.BringIntoViewData} */
    /* JADX WARNING: type inference failed for: r0v1 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.ui.Modifier invoke(androidx.compose.ui.Modifier r9, androidx.compose.runtime.Composer r10, int r11) {
        /*
            r8 = this;
            java.lang.String r11 = "$this$composed"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r11)
            r9 = -1614341944(0xffffffff9fc718c8, float:-8.4320775E-20)
            r10.startReplaceableGroup(r9)
            java.lang.String r9 = "C106@4758L65,118@5329L364:BringIntoViewRequester.kt#exjx5q"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r9)
            r9 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r10.startReplaceableGroup(r9)
            java.lang.String r11 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r11)
            java.lang.Object r0 = r10.rememberedValue()
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r0 != r1) goto L_0x0039
            androidx.compose.foundation.relocation.BringIntoViewData r0 = new androidx.compose.foundation.relocation.BringIntoViewData
            androidx.compose.foundation.relocation.BringRectangleOnScreenRequester r3 = new androidx.compose.foundation.relocation.BringRectangleOnScreenRequester
            r3.<init>()
            r4 = 0
            r5 = 0
            r6 = 6
            r7 = 0
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7)
            r10.updateRememberedValue(r0)
        L_0x0039:
            r10.endReplaceableGroup()
            androidx.compose.foundation.relocation.BringIntoViewData r0 = (androidx.compose.foundation.relocation.BringIntoViewData) r0
            r1 = -1614341844(0xffffffff9fc7192c, float:-8.432142E-20)
            r10.startReplaceableGroup(r1)
            java.lang.String r1 = "108@4896L218"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            androidx.compose.foundation.relocation.BringIntoViewRequester r1 = r8.$bringIntoViewRequester
            boolean r2 = r1 instanceof androidx.compose.foundation.relocation.BringIntoViewRequesterImpl
            if (r2 == 0) goto L_0x005a
            androidx.compose.foundation.relocation.BringIntoViewRequesterKt$bringIntoViewRequester$2$1 r2 = new androidx.compose.foundation.relocation.BringIntoViewRequesterKt$bringIntoViewRequester$2$1
            r2.<init>(r1, r0)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r3 = 0
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r1, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r2, (androidx.compose.runtime.Composer) r10, (int) r3)
        L_0x005a:
            r10.endReplaceableGroup()
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            androidx.compose.foundation.relocation.BringRectangleOnScreenRequester r2 = r0.getBringRectangleOnScreenRequester()
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.relocation.BringRectangleOnScreen_androidKt.bringRectangleOnScreenRequester(r1, r2)
            androidx.compose.foundation.relocation.BringIntoViewRequesterKt$bringIntoViewRequester$2$2 r2 = new androidx.compose.foundation.relocation.BringIntoViewRequesterKt$bringIntoViewRequester$2$2
            r2.<init>(r0)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.layout.OnGloballyPositionedModifierKt.onGloballyPositioned(r1, r2)
            r10.startReplaceableGroup(r9)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r11)
            java.lang.Object r9 = r10.rememberedValue()
            androidx.compose.runtime.Composer$Companion r11 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r11 = r11.getEmpty()
            if (r9 != r11) goto L_0x008e
            androidx.compose.foundation.relocation.BringIntoViewRequesterKt$bringIntoViewRequester$2$3$1 r9 = new androidx.compose.foundation.relocation.BringIntoViewRequesterKt$bringIntoViewRequester$2$3$1
            r9.<init>(r0)
            r10.updateRememberedValue(r9)
        L_0x008e:
            r10.endReplaceableGroup()
            androidx.compose.ui.Modifier r9 = (androidx.compose.ui.Modifier) r9
            androidx.compose.ui.Modifier r9 = r1.then(r9)
            r10.endReplaceableGroup()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.relocation.BringIntoViewRequesterKt$bringIntoViewRequester$2.invoke(androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int):androidx.compose.ui.Modifier");
    }
}
