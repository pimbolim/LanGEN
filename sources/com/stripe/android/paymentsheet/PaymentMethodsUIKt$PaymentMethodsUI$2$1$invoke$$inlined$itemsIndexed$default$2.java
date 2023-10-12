package com.stripe.android.paymentsheet;

import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.StringResources_androidKt;
import com.stripe.android.paymentsheet.model.SupportedPaymentMethod;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u000b¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "Landroidx/compose/foundation/lazy/LazyItemScope;", "it", "", "invoke", "(Landroidx/compose/foundation/lazy/LazyItemScope;ILandroidx/compose/runtime/Composer;I)V", "androidx/compose/foundation/lazy/LazyDslKt$itemsIndexed$2"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LazyDsl.kt */
public final class PaymentMethodsUIKt$PaymentMethodsUI$2$1$invoke$$inlined$itemsIndexed$default$2 extends Lambda implements Function4<LazyItemScope, Integer, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty$inlined;
    final /* synthetic */ boolean $isEnabled$inlined;
    final /* synthetic */ List $items;
    final /* synthetic */ Function1 $onItemSelectedListener$inlined;
    final /* synthetic */ List $paymentMethods$inlined;
    final /* synthetic */ int $selectedIndex$inlined;
    final /* synthetic */ float $viewWidth$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PaymentMethodsUIKt$PaymentMethodsUI$2$1$invoke$$inlined$itemsIndexed$default$2(List list, int i, float f, boolean z, int i2, Function1 function1, List list2) {
        super(4);
        this.$items = list;
        this.$selectedIndex$inlined = i;
        this.$viewWidth$inlined = f;
        this.$isEnabled$inlined = z;
        this.$$dirty$inlined = i2;
        this.$onItemSelectedListener$inlined = function1;
        this.$paymentMethods$inlined = list2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        invoke((LazyItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(LazyItemScope lazyItemScope, int i, Composer composer, int i2) {
        int i3;
        LazyItemScope lazyItemScope2 = lazyItemScope;
        int i4 = i;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(lazyItemScope, "$this$items");
        ComposerKt.sourceInformation(composer2, "C120@5624L26:LazyDsl.kt#428nma");
        if ((i2 & 14) == 0) {
            i3 = i2 | (composer2.changed((Object) lazyItemScope) ? 4 : 2);
        } else {
            i3 = i2;
        }
        if ((i2 & 112) == 0) {
            i3 |= composer2.changed(i4) ? 32 : 16;
        }
        if (((i3 & 731) ^ 146) != 0 || !composer.getSkipping()) {
            int i5 = (i3 & 112) | (i3 & 14);
            SupportedPaymentMethod supportedPaymentMethod = (SupportedPaymentMethod) this.$items.get(i4);
            boolean z = false;
            Modifier testTag = TestTagKt.testTag(Modifier.Companion, Intrinsics.stringPlus(PaymentMethodsUIKt.TEST_TAG_LIST, StringResources_androidKt.stringResource(supportedPaymentMethod.getDisplayNameResource(), composer2, 0)));
            int iconResource = supportedPaymentMethod.getIconResource();
            String stringResource = StringResources_androidKt.stringResource(supportedPaymentMethod.getDisplayNameResource(), composer2, 0);
            if (i4 == this.$selectedIndex$inlined) {
                z = true;
            }
            PaymentMethodsUIKt.m4395PaymentMethodUIZ3Oy47U(this.$viewWidth$inlined, iconResource, stringResource, z, this.$isEnabled$inlined, SupportedPaymentMethod.Companion.shouldTintOnSelection$paymentsheet_release(supportedPaymentMethod), i, testTag, new PaymentMethodsUIKt$PaymentMethodsUI$2$1$1$1(this.$onItemSelectedListener$inlined, this.$paymentMethods$inlined), composer, (57344 & (this.$$dirty$inlined << 6)) | ((i5 << 15) & 3670016), 0);
            return;
        }
        composer.skipToGroupEnd();
    }
}
