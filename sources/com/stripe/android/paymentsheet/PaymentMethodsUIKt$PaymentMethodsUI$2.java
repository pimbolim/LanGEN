package com.stripe.android.paymentsheet;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.unit.Dp;
import com.stripe.android.paymentsheet.model.SupportedPaymentMethod;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentMethodsUI.kt */
final class PaymentMethodsUIKt$PaymentMethodsUI$2 extends Lambda implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ boolean $isEnabled;
    final /* synthetic */ Function1<SupportedPaymentMethod, Unit> $onItemSelectedListener;
    final /* synthetic */ List<SupportedPaymentMethod> $paymentMethods;
    final /* synthetic */ int $selectedIndex;
    final /* synthetic */ LazyListState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaymentMethodsUIKt$PaymentMethodsUI$2(List<? extends SupportedPaymentMethod> list, LazyListState lazyListState, int i, boolean z, int i2, Function1<? super SupportedPaymentMethod, Unit> function1) {
        super(3);
        this.$paymentMethods = list;
        this.$state = lazyListState;
        this.$selectedIndex = i;
        this.$isEnabled = z;
        this.$$dirty = i2;
        this.$onItemSelectedListener = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((BoxWithConstraintsScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer, int i) {
        int i2;
        BoxWithConstraintsScope boxWithConstraintsScope2 = boxWithConstraintsScope;
        Intrinsics.checkNotNullParameter(boxWithConstraintsScope2, "$this$BoxWithConstraints");
        if ((i & 14) == 0) {
            i2 = i | (composer.changed((Object) boxWithConstraintsScope2) ? 4 : 2);
        } else {
            Composer composer2 = composer;
            i2 = i;
        }
        if (((i2 & 91) ^ 18) != 0 || !composer.getSkipping()) {
            final float r7 = PaymentMethodsUIKt.m4396calculateViewWidthD5KLDUw(boxWithConstraintsScope.m392getMaxWidthD9Ej5fM(), this.$paymentMethods.size());
            Modifier testTag = TestTagKt.testTag(PaddingKt.m435paddingqDBjuR0$default(Modifier.Companion, Dp.m3859constructorimpl(17.0f), 0.0f, 0.0f, 0.0f, 14, (Object) null), PaymentMethodsUIKt.TEST_TAG_LIST);
            LazyListState lazyListState = this.$state;
            final List<SupportedPaymentMethod> list = this.$paymentMethods;
            final int i3 = this.$selectedIndex;
            final boolean z = this.$isEnabled;
            final int i4 = this.$$dirty;
            final Function1<SupportedPaymentMethod, Unit> function1 = this.$onItemSelectedListener;
            LazyDslKt.LazyRow(testTag, lazyListState, (PaddingValues) null, false, (Arrangement.Horizontal) null, (Alignment.Vertical) null, (FlingBehavior) null, new Function1<LazyListScope, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((LazyListScope) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(LazyListScope lazyListScope) {
                    Intrinsics.checkNotNullParameter(lazyListScope, "$this$LazyRow");
                    List<SupportedPaymentMethod> list = list;
                    lazyListScope.items(list.size(), (Function1<? super Integer, ? extends Object>) null, ComposableLambdaKt.composableLambdaInstance(-985537359, true, new PaymentMethodsUIKt$PaymentMethodsUI$2$1$invoke$$inlined$itemsIndexed$default$2(list, i3, r7, z, i4, function1, list)));
                }
            }, composer, 6, 124);
            return;
        }
        composer.skipToGroupEnd();
    }
}
