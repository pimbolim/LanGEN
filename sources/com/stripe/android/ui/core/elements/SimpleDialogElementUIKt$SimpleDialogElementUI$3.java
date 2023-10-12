package com.stripe.android.ui.core.elements;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SimpleDialogElementUI.kt */
final class SimpleDialogElementUIKt$SimpleDialogElementUI$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ String $confirmText;
    final /* synthetic */ String $dismissText;
    final /* synthetic */ String $messageText;
    final /* synthetic */ Function0<Unit> $onConfirmListener;
    final /* synthetic */ Function0<Unit> $onDismissListener;
    final /* synthetic */ MutableState<Boolean> $openDialog;
    final /* synthetic */ String $titleText;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SimpleDialogElementUIKt$SimpleDialogElementUI$3(MutableState<Boolean> mutableState, int i, Function0<Unit> function0, String str, Function0<Unit> function02, String str2, String str3, String str4) {
        super(2);
        this.$openDialog = mutableState;
        this.$$dirty = i;
        this.$onConfirmListener = function0;
        this.$confirmText = str;
        this.$onDismissListener = function02;
        this.$dismissText = str2;
        this.$titleText = str3;
        this.$messageText = str4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.runtime.Composer r18, int r19) {
        /*
            r17 = this;
            r0 = r17
            r13 = r18
            r1 = r19 & 11
            r1 = r1 ^ 2
            if (r1 != 0) goto L_0x0016
            boolean r1 = r18.getSkipping()
            if (r1 != 0) goto L_0x0011
            goto L_0x0016
        L_0x0011:
            r18.skipToGroupEnd()
            goto L_0x00b3
        L_0x0016:
            androidx.compose.runtime.MutableState<java.lang.Boolean> r1 = r0.$openDialog
            r2 = -3686930(0xffffffffffc7bdee, float:NaN)
            r13.startReplaceableGroup(r2)
            java.lang.String r2 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r2)
            boolean r2 = r13.changed((java.lang.Object) r1)
            java.lang.Object r3 = r18.rememberedValue()
            if (r2 != 0) goto L_0x0035
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r3 != r2) goto L_0x0040
        L_0x0035:
            com.stripe.android.ui.core.elements.SimpleDialogElementUIKt$SimpleDialogElementUI$3$1$1 r2 = new com.stripe.android.ui.core.elements.SimpleDialogElementUIKt$SimpleDialogElementUI$3$1$1
            r2.<init>(r1)
            r3 = r2
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            r13.updateRememberedValue(r3)
        L_0x0040:
            r18.endReplaceableGroup()
            r1 = r3
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            r2 = -819895656(0xffffffffcf216298, float:-2.70759322E9)
            com.stripe.android.ui.core.elements.SimpleDialogElementUIKt$SimpleDialogElementUI$3$2 r3 = new com.stripe.android.ui.core.elements.SimpleDialogElementUIKt$SimpleDialogElementUI$3$2
            androidx.compose.runtime.MutableState<java.lang.Boolean> r4 = r0.$openDialog
            kotlin.jvm.functions.Function0<kotlin.Unit> r5 = r0.$onConfirmListener
            int r6 = r0.$$dirty
            java.lang.String r7 = r0.$confirmText
            r3.<init>(r4, r5, r6, r7)
            r4 = 1
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r13, r2, r4, r3)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r3 = 0
            r5 = -819895320(0xffffffffcf2163e8, float:-2.70767923E9)
            com.stripe.android.ui.core.elements.SimpleDialogElementUIKt$SimpleDialogElementUI$3$3 r6 = new com.stripe.android.ui.core.elements.SimpleDialogElementUIKt$SimpleDialogElementUI$3$3
            androidx.compose.runtime.MutableState<java.lang.Boolean> r7 = r0.$openDialog
            kotlin.jvm.functions.Function0<kotlin.Unit> r8 = r0.$onDismissListener
            int r9 = r0.$$dirty
            java.lang.String r10 = r0.$dismissText
            r6.<init>(r7, r8, r9, r10)
            androidx.compose.runtime.internal.ComposableLambda r5 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r13, r5, r4, r6)
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r6 = -819894825(0xffffffffcf2165d7, float:-2.70780595E9)
            com.stripe.android.ui.core.elements.SimpleDialogElementUIKt$SimpleDialogElementUI$3$4 r7 = new com.stripe.android.ui.core.elements.SimpleDialogElementUIKt$SimpleDialogElementUI$3$4
            java.lang.String r8 = r0.$titleText
            int r9 = r0.$$dirty
            r7.<init>(r8, r9)
            androidx.compose.runtime.internal.ComposableLambda r6 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r13, r6, r4, r7)
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            r7 = -819894980(0xffffffffcf21653c, float:-2.70776627E9)
            com.stripe.android.ui.core.elements.SimpleDialogElementUIKt$SimpleDialogElementUI$3$5 r8 = new com.stripe.android.ui.core.elements.SimpleDialogElementUIKt$SimpleDialogElementUI$3$5
            java.lang.String r9 = r0.$messageText
            int r10 = r0.$$dirty
            r8.<init>(r9, r10)
            androidx.compose.runtime.internal.ComposableLambda r4 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r13, r7, r4, r8)
            r7 = r4
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r8 = 0
            r9 = 0
            r11 = 0
            r14 = 0
            r15 = 224304(0x36c30, float:3.14317E-40)
            r16 = 964(0x3c4, float:1.351E-42)
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r9
            r10 = r11
            r12 = r14
            r13 = r18
            r14 = r15
            r15 = r16
            androidx.compose.material.AndroidAlertDialog_androidKt.m827AlertDialog6oU6zVQ(r1, r2, r3, r4, r5, r6, r7, r8, r10, r12, r13, r14, r15)
        L_0x00b3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.ui.core.elements.SimpleDialogElementUIKt$SimpleDialogElementUI$3.invoke(androidx.compose.runtime.Composer, int):void");
    }
}
