package androidx.compose.material.ripple;

import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B&\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007ø\u0001\u0000¢\u0006\u0002\u0010\tJI\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0007H\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0012"}, d2 = {"Landroidx/compose/material/ripple/CommonRipple;", "Landroidx/compose/material/ripple/Ripple;", "bounded", "", "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/graphics/Color;", "(ZFLandroidx/compose/runtime/State;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "rememberUpdatedRippleInstance", "Landroidx/compose/material/ripple/RippleIndicationInstance;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "rippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "rememberUpdatedRippleInstance-942rkJo", "(Landroidx/compose/foundation/interaction/InteractionSource;ZFLandroidx/compose/runtime/State;Landroidx/compose/runtime/State;Landroidx/compose/runtime/Composer;I)Landroidx/compose/material/ripple/RippleIndicationInstance;", "material-ripple_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommonRipple.kt */
public final class CommonRipple extends Ripple {
    public /* synthetic */ CommonRipple(boolean z, float f, State state, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, f, state);
    }

    private CommonRipple(boolean z, float f, State<Color> state) {
        super(z, f, state, (DefaultConstructorMarker) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v13, resolved type: androidx.compose.material.ripple.CommonRippleIndicationInstance} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: androidx.compose.material.ripple.CommonRippleIndicationInstance} */
    /* JADX WARNING: type inference failed for: r13v10 */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x003a, code lost:
        if (r13 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x003c;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: rememberUpdatedRippleInstance-942rkJo  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.compose.material.ripple.RippleIndicationInstance m1201rememberUpdatedRippleInstance942rkJo(androidx.compose.foundation.interaction.InteractionSource r7, boolean r8, float r9, androidx.compose.runtime.State<androidx.compose.ui.graphics.Color> r10, androidx.compose.runtime.State<androidx.compose.material.ripple.RippleAlpha> r11, androidx.compose.runtime.Composer r12, int r13) {
        /*
            r6 = this;
            java.lang.String r13 = "interactionSource"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r13)
            java.lang.String r13 = "color"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r13)
            java.lang.String r13 = "rippleAlpha"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r13)
            r13 = -1999846261(0xffffffff88ccc48b, float:-1.232401E-33)
            r12.startReplaceableGroup(r13)
            java.lang.String r13 = "C(rememberUpdatedRippleInstance)P(2!1,3:c#ui.unit.Dp)53@1880L125:CommonRipple.kt#vhb33q"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r13)
            r13 = -3686552(0xffffffffffc7bf68, float:NaN)
            r12.startReplaceableGroup(r13)
            java.lang.String r13 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r13)
            boolean r7 = r12.changed((java.lang.Object) r7)
            boolean r13 = r12.changed((java.lang.Object) r6)
            r7 = r7 | r13
            java.lang.Object r13 = r12.rememberedValue()
            if (r7 != 0) goto L_0x003c
            androidx.compose.runtime.Composer$Companion r7 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r7.getEmpty()
            if (r13 != r7) goto L_0x004a
        L_0x003c:
            androidx.compose.material.ripple.CommonRippleIndicationInstance r13 = new androidx.compose.material.ripple.CommonRippleIndicationInstance
            r5 = 0
            r0 = r13
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r11
            r0.<init>(r1, r2, r3, r4, r5)
            r12.updateRememberedValue(r13)
        L_0x004a:
            r12.endReplaceableGroup()
            androidx.compose.material.ripple.CommonRippleIndicationInstance r13 = (androidx.compose.material.ripple.CommonRippleIndicationInstance) r13
            r12.endReplaceableGroup()
            androidx.compose.material.ripple.RippleIndicationInstance r13 = (androidx.compose.material.ripple.RippleIndicationInstance) r13
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ripple.CommonRipple.m1201rememberUpdatedRippleInstance942rkJo(androidx.compose.foundation.interaction.InteractionSource, boolean, float, androidx.compose.runtime.State, androidx.compose.runtime.State, androidx.compose.runtime.Composer, int):androidx.compose.material.ripple.RippleIndicationInstance");
    }
}
