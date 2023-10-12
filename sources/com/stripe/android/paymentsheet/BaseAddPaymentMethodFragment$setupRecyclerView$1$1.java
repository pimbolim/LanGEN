package com.stripe.android.paymentsheet;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import com.stripe.android.paymentsheet.model.SupportedPaymentMethod;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BaseAddPaymentMethodFragment.kt */
final class BaseAddPaymentMethodFragment$setupRecyclerView$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ SupportedPaymentMethod $initialSelectedItem;
    final /* synthetic */ List<SupportedPaymentMethod> $paymentMethods;
    final /* synthetic */ BaseAddPaymentMethodFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseAddPaymentMethodFragment$setupRecyclerView$1$1(BaseAddPaymentMethodFragment baseAddPaymentMethodFragment, SupportedPaymentMethod supportedPaymentMethod, List<? extends SupportedPaymentMethod> list) {
        super(2);
        this.this$0 = baseAddPaymentMethodFragment;
        this.$initialSelectedItem = supportedPaymentMethod;
        this.$paymentMethods = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.runtime.Composer r9, int r10) {
        /*
            r8 = this;
            r10 = r10 & 11
            r10 = r10 ^ 2
            if (r10 != 0) goto L_0x0012
            boolean r10 = r9.getSkipping()
            if (r10 != 0) goto L_0x000d
            goto L_0x0012
        L_0x000d:
            r9.skipToGroupEnd()
            goto L_0x0091
        L_0x0012:
            com.stripe.android.paymentsheet.BaseAddPaymentMethodFragment r10 = r8.this$0
            com.stripe.android.paymentsheet.viewmodels.BaseSheetViewModel r10 = r10.getSheetViewModel()
            androidx.lifecycle.LiveData r10 = r10.getProcessing()
            kotlinx.coroutines.flow.Flow r0 = androidx.lifecycle.FlowLiveDataConversions.asFlow(r10)
            r10 = 0
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r10)
            r2 = 0
            r4 = 56
            r5 = 2
            r3 = r9
            androidx.compose.runtime.State r10 = androidx.compose.runtime.SnapshotStateKt.collectAsState(r0, r1, r2, r3, r4, r5)
            com.stripe.android.paymentsheet.BaseAddPaymentMethodFragment r0 = r8.this$0
            com.stripe.android.paymentsheet.viewmodels.BaseSheetViewModel r0 = r0.getSheetViewModel()
            androidx.lifecycle.MutableLiveData r0 = r0.getAddFragmentSelectedLpm()
            androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
            kotlinx.coroutines.flow.Flow r1 = androidx.lifecycle.FlowLiveDataConversions.asFlow(r0)
            com.stripe.android.paymentsheet.model.SupportedPaymentMethod r2 = r8.$initialSelectedItem
            r3 = 0
            r5 = 72
            r6 = 2
            r4 = r9
            androidx.compose.runtime.State r0 = androidx.compose.runtime.SnapshotStateKt.collectAsState(r1, r2, r3, r4, r5, r6)
            java.util.List<com.stripe.android.paymentsheet.model.SupportedPaymentMethod> r1 = r8.$paymentMethods
            com.stripe.android.paymentsheet.model.SupportedPaymentMethod r0 = m4388invoke$lambda1(r0)
            int r3 = r1.indexOf(r0)
            boolean r10 = m4387invoke$lambda0(r10)
            r4 = r10 ^ 1
            java.util.List<com.stripe.android.paymentsheet.model.SupportedPaymentMethod> r2 = r8.$paymentMethods
            com.stripe.android.paymentsheet.BaseAddPaymentMethodFragment r10 = r8.this$0
            r0 = -3686930(0xffffffffffc7bdee, float:NaN)
            r9.startReplaceableGroup(r0)
            java.lang.String r0 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r0)
            boolean r0 = r9.changed((java.lang.Object) r10)
            java.lang.Object r1 = r9.rememberedValue()
            if (r0 != 0) goto L_0x007a
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r1 != r0) goto L_0x0085
        L_0x007a:
            com.stripe.android.paymentsheet.BaseAddPaymentMethodFragment$setupRecyclerView$1$1$1$1 r0 = new com.stripe.android.paymentsheet.BaseAddPaymentMethodFragment$setupRecyclerView$1$1$1$1
            r0.<init>(r10)
            r1 = r0
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r9.updateRememberedValue(r1)
        L_0x0085:
            r9.endReplaceableGroup()
            r5 = r1
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r7 = 8
            r6 = r9
            com.stripe.android.paymentsheet.PaymentMethodsUIKt.PaymentMethodsUI(r2, r3, r4, r5, r6, r7)
        L_0x0091:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.paymentsheet.BaseAddPaymentMethodFragment$setupRecyclerView$1$1.invoke(androidx.compose.runtime.Composer, int):void");
    }

    /* renamed from: invoke$lambda-0  reason: not valid java name */
    private static final boolean m4387invoke$lambda0(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* renamed from: invoke$lambda-1  reason: not valid java name */
    private static final SupportedPaymentMethod m4388invoke$lambda1(State<? extends SupportedPaymentMethod> state) {
        return (SupportedPaymentMethod) state.getValue();
    }
}
