package com.stripe.android.link.ui.verification;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: VerificationScreen.kt */
final class VerificationScreenKt$VerificationCodeInput$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ MutableState<String> $code$delegate;
    final /* synthetic */ Function1<String, Unit> $onCodeEntered;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VerificationScreenKt$VerificationCodeInput$1$1(MutableState<String> mutableState, Function1<? super String, Unit> function1, int i) {
        super(2);
        this.$code$delegate = mutableState;
        this.$onCodeEntered = function1;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.runtime.Composer r25, int r26) {
        /*
            r24 = this;
            r0 = r24
            r13 = r25
            r1 = r26 & 11
            r1 = r1 ^ 2
            if (r1 != 0) goto L_0x0016
            boolean r1 = r25.getSkipping()
            if (r1 != 0) goto L_0x0011
            goto L_0x0016
        L_0x0011:
            r25.skipToGroupEnd()
            goto L_0x00ab
        L_0x0016:
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r2 = 0
            r3 = 1
            r4 = 0
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r1, r2, r3, r4)
            androidx.compose.runtime.MutableState<java.lang.String> r1 = r0.$code$delegate
            java.lang.String r1 = com.stripe.android.link.ui.verification.VerificationScreenKt.m4348VerificationCodeInput$lambda3(r1)
            androidx.compose.material.MaterialTheme r2 = androidx.compose.material.MaterialTheme.INSTANCE
            r4 = 8
            androidx.compose.material.Shapes r2 = r2.getShapes(r13, r4)
            androidx.compose.foundation.shape.CornerBasedShape r18 = r2.getMedium()
            r2 = 0
            androidx.compose.material.TextFieldColors r19 = com.stripe.android.link.theme.ThemeKt.linkTextFieldColors(r13, r2)
            androidx.compose.foundation.text.KeyboardOptions r20 = new androidx.compose.foundation.text.KeyboardOptions
            r5 = 0
            r6 = 0
            androidx.compose.ui.text.input.KeyboardType$Companion r2 = androidx.compose.ui.text.input.KeyboardType.Companion
            int r7 = r2.m3677getNumberPjHm6EE()
            androidx.compose.ui.text.input.ImeAction$Companion r2 = androidx.compose.ui.text.input.ImeAction.Companion
            int r8 = r2.m3644getGoeUduSuo()
            r9 = 3
            r10 = 0
            r4 = r20
            r4.<init>(r5, r6, r7, r8, r9, r10)
            androidx.compose.runtime.MutableState<java.lang.String> r2 = r0.$code$delegate
            kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> r4 = r0.$onCodeEntered
            r5 = -3686552(0xffffffffffc7bf68, float:NaN)
            r13.startReplaceableGroup(r5)
            java.lang.String r5 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r5)
            boolean r5 = r13.changed((java.lang.Object) r2)
            boolean r6 = r13.changed((java.lang.Object) r4)
            r5 = r5 | r6
            java.lang.Object r6 = r25.rememberedValue()
            if (r5 != 0) goto L_0x0075
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r6 != r5) goto L_0x0080
        L_0x0075:
            com.stripe.android.link.ui.verification.VerificationScreenKt$VerificationCodeInput$1$1$1$1 r5 = new com.stripe.android.link.ui.verification.VerificationScreenKt$VerificationCodeInput$1$1$1$1
            r5.<init>(r4, r2)
            r6 = r5
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r13.updateRememberedValue(r6)
        L_0x0080:
            r25.endReplaceableGroup()
            r2 = r6
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r4 = 0
            r5 = 0
            r6 = 0
            com.stripe.android.link.ui.verification.ComposableSingletons$VerificationScreenKt r7 = com.stripe.android.link.ui.verification.ComposableSingletons$VerificationScreenKt.INSTANCE
            kotlin.jvm.functions.Function2 r7 = r7.m4347getLambda3$link_release()
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r14 = 0
            r15 = 1
            r16 = 0
            r17 = 0
            androidx.compose.ui.graphics.Shape r18 = (androidx.compose.ui.graphics.Shape) r18
            r21 = 1573248(0x180180, float:2.20459E-39)
            r22 = 24576(0x6000, float:3.4438E-41)
            r23 = 110520(0x1afb8, float:1.54872E-40)
            r13 = r20
            r20 = r25
            androidx.compose.material.TextFieldKt.TextField((java.lang.String) r1, (kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit>) r2, (androidx.compose.ui.Modifier) r3, (boolean) r4, (boolean) r5, (androidx.compose.ui.text.TextStyle) r6, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r7, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r8, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r9, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r10, (boolean) r11, (androidx.compose.ui.text.input.VisualTransformation) r12, (androidx.compose.foundation.text.KeyboardOptions) r13, (androidx.compose.foundation.text.KeyboardActions) r14, (boolean) r15, (int) r16, (androidx.compose.foundation.interaction.MutableInteractionSource) r17, (androidx.compose.ui.graphics.Shape) r18, (androidx.compose.material.TextFieldColors) r19, (androidx.compose.runtime.Composer) r20, (int) r21, (int) r22, (int) r23)
        L_0x00ab:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.link.ui.verification.VerificationScreenKt$VerificationCodeInput$1$1.invoke(androidx.compose.runtime.Composer, int):void");
    }
}
