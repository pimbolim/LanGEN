package com.stripe.android.paymentsheet;

import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import com.stripe.android.paymentsheet.model.SupportedPaymentMethod;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u001ak\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\u0017H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019\u001a?\u0010\u001a\u001a\u00020\t2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\t0\u0017H\u0001¢\u0006\u0002\u0010\u001f\u001a%\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\rH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010$\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0016\u0010\u0004\u001a\u00020\u00058\u0006XT¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006%"}, d2 = {"ADD_PM_DEFAULT_PADDING", "", "CARD_HORIZONTAL_PADDING", "PM_LIST_PADDING", "TEST_TAG_LIST", "", "getTEST_TAG_LIST$annotations", "()V", "PaymentMethodUI", "", "viewWidth", "Landroidx/compose/ui/unit/Dp;", "iconRes", "", "title", "isSelected", "", "isEnabled", "tintOnSelected", "itemIndex", "modifier", "Landroidx/compose/ui/Modifier;", "onItemSelectedListener", "Lkotlin/Function1;", "PaymentMethodUI-Z3Oy47U", "(FILjava/lang/String;ZZZILandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "PaymentMethodsUI", "paymentMethods", "", "Lcom/stripe/android/paymentsheet/model/SupportedPaymentMethod;", "selectedIndex", "(Ljava/util/List;IZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "calculateViewWidth", "maxWidth", "numberOfPaymentMethods", "calculateViewWidth-D5KLDUw", "(FI)F", "paymentsheet_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentMethodsUI.kt */
public final class PaymentMethodsUIKt {
    public static final float ADD_PM_DEFAULT_PADDING = 12.0f;
    public static final float CARD_HORIZONTAL_PADDING = 6.0f;
    public static final float PM_LIST_PADDING = 17.0f;
    public static final String TEST_TAG_LIST = "PaymentMethodsUITestTag";

    public static /* synthetic */ void getTEST_TAG_LIST$annotations() {
    }

    public static final void PaymentMethodsUI(List<? extends SupportedPaymentMethod> list, int i, boolean z, Function1<? super SupportedPaymentMethod, Unit> function1, Composer composer, int i2) {
        Intrinsics.checkNotNullParameter(list, "paymentMethods");
        Intrinsics.checkNotNullParameter(function1, "onItemSelectedListener");
        Composer startRestartGroup = composer.startRestartGroup(-72766774);
        startRestartGroup.startReplaceableGroup(-723524056);
        ComposerKt.sourceInformation(startRestartGroup, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
        startRestartGroup.startReplaceableGroup(-3687241);
        ComposerKt.sourceInformation(startRestartGroup, "C(remember):Composables.kt#9igjgp");
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
            startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
            rememberedValue = compositionScopedCoroutineScopeCanceller;
        }
        startRestartGroup.endReplaceableGroup();
        CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
        startRestartGroup.endReplaceableGroup();
        LazyListState rememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, startRestartGroup, 0, 3);
        EffectsKt.LaunchedEffect((Object) Boolean.valueOf(z), (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) new PaymentMethodsUIKt$PaymentMethodsUI$1(z, rememberLazyListState, coroutineScope, (Continuation<? super PaymentMethodsUIKt$PaymentMethodsUI$1>) null), startRestartGroup, (i2 >> 6) & 14);
        PaymentMethodsUIKt$PaymentMethodsUI$2 paymentMethodsUIKt$PaymentMethodsUI$2 = r1;
        PaymentMethodsUIKt$PaymentMethodsUI$2 paymentMethodsUIKt$PaymentMethodsUI$22 = new PaymentMethodsUIKt$PaymentMethodsUI$2(list, rememberLazyListState, i, z, i2, function1);
        BoxWithConstraintsKt.BoxWithConstraints((Modifier) null, (Alignment) null, false, ComposableLambdaKt.composableLambda(startRestartGroup, -819892560, true, paymentMethodsUIKt$PaymentMethodsUI$2), startRestartGroup, 3072, 7);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new PaymentMethodsUIKt$PaymentMethodsUI$3(list, i, z, function1, i2));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x01d5  */
    /* JADX WARNING: Removed duplicated region for block: B:113:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0126  */
    /* renamed from: PaymentMethodUI-Z3Oy47U  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m4395PaymentMethodUIZ3Oy47U(float r20, int r21, java.lang.String r22, boolean r23, boolean r24, boolean r25, int r26, androidx.compose.ui.Modifier r27, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> r28, androidx.compose.runtime.Composer r29, int r30, int r31) {
        /*
            r1 = r20
            r9 = r22
            r10 = r24
            r11 = r26
            r12 = r28
            r13 = r30
            r14 = r31
            java.lang.String r0 = "title"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "onItemSelectedListener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = -1803488087(0xffffffff9480f4a9, float:-1.3021198E-26)
            r2 = r29
            androidx.compose.runtime.Composer r0 = r2.startRestartGroup(r0)
            r2 = r14 & 1
            r3 = 2
            if (r2 == 0) goto L_0x0029
            r2 = r13 | 6
            goto L_0x0039
        L_0x0029:
            r2 = r13 & 14
            if (r2 != 0) goto L_0x0038
            boolean r2 = r0.changed((float) r1)
            if (r2 == 0) goto L_0x0035
            r2 = 4
            goto L_0x0036
        L_0x0035:
            r2 = 2
        L_0x0036:
            r2 = r2 | r13
            goto L_0x0039
        L_0x0038:
            r2 = r13
        L_0x0039:
            r4 = r14 & 2
            if (r4 == 0) goto L_0x0042
            r2 = r2 | 48
            r15 = r21
            goto L_0x0054
        L_0x0042:
            r4 = r13 & 112(0x70, float:1.57E-43)
            r15 = r21
            if (r4 != 0) goto L_0x0054
            boolean r4 = r0.changed((int) r15)
            if (r4 == 0) goto L_0x0051
            r4 = 32
            goto L_0x0053
        L_0x0051:
            r4 = 16
        L_0x0053:
            r2 = r2 | r4
        L_0x0054:
            r4 = r14 & 4
            if (r4 == 0) goto L_0x005b
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x006b
        L_0x005b:
            r4 = r13 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x006b
            boolean r4 = r0.changed((java.lang.Object) r9)
            if (r4 == 0) goto L_0x0068
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x006a
        L_0x0068:
            r4 = 128(0x80, float:1.794E-43)
        L_0x006a:
            r2 = r2 | r4
        L_0x006b:
            r4 = r14 & 8
            if (r4 == 0) goto L_0x0074
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            r8 = r23
            goto L_0x0086
        L_0x0074:
            r4 = r13 & 7168(0x1c00, float:1.0045E-41)
            r8 = r23
            if (r4 != 0) goto L_0x0086
            boolean r4 = r0.changed((boolean) r8)
            if (r4 == 0) goto L_0x0083
            r4 = 2048(0x800, float:2.87E-42)
            goto L_0x0085
        L_0x0083:
            r4 = 1024(0x400, float:1.435E-42)
        L_0x0085:
            r2 = r2 | r4
        L_0x0086:
            r4 = r14 & 16
            if (r4 == 0) goto L_0x008d
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009f
        L_0x008d:
            r4 = 57344(0xe000, float:8.0356E-41)
            r4 = r4 & r13
            if (r4 != 0) goto L_0x009f
            boolean r4 = r0.changed((boolean) r10)
            if (r4 == 0) goto L_0x009c
            r4 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009e
        L_0x009c:
            r4 = 8192(0x2000, float:1.14794E-41)
        L_0x009e:
            r2 = r2 | r4
        L_0x009f:
            r4 = r14 & 32
            if (r4 == 0) goto L_0x00a9
            r4 = 196608(0x30000, float:2.75506E-40)
            r2 = r2 | r4
            r7 = r25
            goto L_0x00bc
        L_0x00a9:
            r4 = 458752(0x70000, float:6.42848E-40)
            r4 = r4 & r13
            r7 = r25
            if (r4 != 0) goto L_0x00bc
            boolean r4 = r0.changed((boolean) r7)
            if (r4 == 0) goto L_0x00b9
            r4 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bb
        L_0x00b9:
            r4 = 65536(0x10000, float:9.18355E-41)
        L_0x00bb:
            r2 = r2 | r4
        L_0x00bc:
            r4 = r14 & 64
            if (r4 == 0) goto L_0x00c4
            r4 = 1572864(0x180000, float:2.204052E-39)
        L_0x00c2:
            r2 = r2 | r4
            goto L_0x00d5
        L_0x00c4:
            r4 = 3670016(0x380000, float:5.142788E-39)
            r4 = r4 & r13
            if (r4 != 0) goto L_0x00d5
            boolean r4 = r0.changed((int) r11)
            if (r4 == 0) goto L_0x00d2
            r4 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00c2
        L_0x00d2:
            r4 = 524288(0x80000, float:7.34684E-40)
            goto L_0x00c2
        L_0x00d5:
            r4 = r14 & 128(0x80, float:1.794E-43)
            if (r4 == 0) goto L_0x00dd
            r5 = 12582912(0xc00000, float:1.7632415E-38)
            r2 = r2 | r5
            goto L_0x00f1
        L_0x00dd:
            r5 = 29360128(0x1c00000, float:7.052966E-38)
            r5 = r5 & r13
            if (r5 != 0) goto L_0x00f1
            r5 = r27
            boolean r6 = r0.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x00ed
            r6 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ef
        L_0x00ed:
            r6 = 4194304(0x400000, float:5.877472E-39)
        L_0x00ef:
            r2 = r2 | r6
            goto L_0x00f3
        L_0x00f1:
            r5 = r27
        L_0x00f3:
            r6 = r14 & 256(0x100, float:3.59E-43)
            if (r6 == 0) goto L_0x00fb
            r6 = 100663296(0x6000000, float:2.4074124E-35)
        L_0x00f9:
            r2 = r2 | r6
            goto L_0x010c
        L_0x00fb:
            r6 = 234881024(0xe000000, float:1.5777218E-30)
            r6 = r6 & r13
            if (r6 != 0) goto L_0x010c
            boolean r6 = r0.changed((java.lang.Object) r12)
            if (r6 == 0) goto L_0x0109
            r6 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x00f9
        L_0x0109:
            r6 = 33554432(0x2000000, float:9.403955E-38)
            goto L_0x00f9
        L_0x010c:
            r16 = r2
            r2 = 191739611(0xb6db6db, float:4.5782105E-32)
            r2 = r16 & r2
            r6 = 38347922(0x2492492, float:1.4777643E-37)
            r2 = r2 ^ r6
            if (r2 != 0) goto L_0x0126
            boolean r2 = r0.getSkipping()
            if (r2 != 0) goto L_0x0120
            goto L_0x0126
        L_0x0120:
            r0.skipToGroupEnd()
            r8 = r5
            goto L_0x01ce
        L_0x0126:
            if (r4 == 0) goto L_0x012e
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            r6 = r2
            goto L_0x012f
        L_0x012e:
            r6 = r5
        L_0x012f:
            if (r10 == 0) goto L_0x0134
            r2 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0137
        L_0x0134:
            r2 = 1058642330(0x3f19999a, float:0.6)
        L_0x0137:
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.draw.AlphaKt.alpha(r6, r2)
            r4 = 60
            float r4 = (float) r4
            float r4 = androidx.compose.ui.unit.Dp.m3859constructorimpl(r4)
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m478height3ABfNKs(r2, r4)
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m497width3ABfNKs(r2, r1)
            r4 = 1086324736(0x40c00000, float:6.0)
            float r4 = androidx.compose.ui.unit.Dp.m3859constructorimpl(r4)
            r5 = 0
            r1 = 0
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.PaddingKt.m433paddingVpY3zN4$default(r2, r4, r5, r3, r1)
            r5 = 0
            java.lang.Integer r1 = java.lang.Integer.valueOf(r26)
            r3 = -3686552(0xffffffffffc7bf68, float:NaN)
            r0.startReplaceableGroup(r3)
            java.lang.String r3 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r3)
            boolean r3 = r0.changed((java.lang.Object) r12)
            boolean r1 = r0.changed((java.lang.Object) r1)
            r1 = r1 | r3
            java.lang.Object r3 = r0.rememberedValue()
            if (r1 != 0) goto L_0x017d
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r3 != r1) goto L_0x0188
        L_0x017d:
            com.stripe.android.paymentsheet.PaymentMethodsUIKt$PaymentMethodUI$1$1 r1 = new com.stripe.android.paymentsheet.PaymentMethodsUIKt$PaymentMethodUI$1$1
            r1.<init>(r12, r11)
            r3 = r1
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            r0.updateRememberedValue(r3)
        L_0x0188:
            r0.endReplaceableGroup()
            r1 = r3
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            r17 = 4
            r18 = 0
            r3 = r23
            r4 = r24
            r19 = r6
            r6 = r1
            r7 = r17
            r8 = r18
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.selection.SelectableKt.m579selectableXHw0xAI$default(r2, r3, r4, r5, r6, r7, r8)
            r8 = -819890320(0xffffffffcf217770, float:-2.70895923E9)
            com.stripe.android.paymentsheet.PaymentMethodsUIKt$PaymentMethodUI$2 r7 = new com.stripe.android.paymentsheet.PaymentMethodsUIKt$PaymentMethodUI$2
            r2 = r7
            r4 = r25
            r5 = r21
            r6 = r16
            r9 = r7
            r7 = r22
            r10 = -819890320(0xffffffffcf217770, float:-2.70895923E9)
            r8 = r24
            r2.<init>(r3, r4, r5, r6, r7, r8)
            r2 = 1
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r10, r2, r9)
            r4 = r2
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            int r2 = r16 >> 6
            r2 = r2 & 112(0x70, float:1.57E-43)
            r6 = r2 | 384(0x180, float:5.38E-43)
            r7 = 0
            r2 = r1
            r5 = r0
            com.stripe.android.ui.core.elements.SectionUIKt.SectionCard(r2, r3, r4, r5, r6, r7)
            r8 = r19
        L_0x01ce:
            androidx.compose.runtime.ScopeUpdateScope r10 = r0.endRestartGroup()
            if (r10 != 0) goto L_0x01d5
            goto L_0x01f8
        L_0x01d5:
            com.stripe.android.paymentsheet.PaymentMethodsUIKt$PaymentMethodUI$3 r16 = new com.stripe.android.paymentsheet.PaymentMethodsUIKt$PaymentMethodUI$3
            r0 = r16
            r1 = r20
            r2 = r21
            r3 = r22
            r4 = r23
            r5 = r24
            r6 = r25
            r7 = r26
            r9 = r28
            r12 = r10
            r10 = r30
            r11 = r31
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r12.updateScope(r0)
        L_0x01f8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.paymentsheet.PaymentMethodsUIKt.m4395PaymentMethodUIZ3Oy47U(float, int, java.lang.String, boolean, boolean, boolean, int, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: calculateViewWidth-D5KLDUw  reason: not valid java name */
    public static final float m4396calculateViewWidthD5KLDUw(float f, int i) {
        float r2 = Dp.m3859constructorimpl(f - Dp.m3859constructorimpl(Dp.m3859constructorimpl(17.0f) * ((float) 2)));
        float r0 = Dp.m3859constructorimpl(112.0f);
        float f2 = (float) i;
        if (Dp.m3858compareTo0680j_4(Dp.m3859constructorimpl(r0 * f2), r2) < 0) {
            return Dp.m3859constructorimpl(r2 / f2);
        }
        return Dp.m3859constructorimpl(r2 / ((float) ((int) (r2 / r0))));
    }
}
