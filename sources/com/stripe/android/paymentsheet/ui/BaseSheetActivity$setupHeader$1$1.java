package com.stripe.android.paymentsheet.ui;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.livedata.LiveDataAdapterKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import com.stripe.android.ui.core.elements.H4TextKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\u000b¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "ResultType", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BaseSheetActivity.kt */
final class BaseSheetActivity$setupHeader$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ BaseSheetActivity<ResultType> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseSheetActivity$setupHeader$1$1(BaseSheetActivity<ResultType> baseSheetActivity) {
        super(2);
        this.this$0 = baseSheetActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if (((i & 11) ^ 2) != 0 || !composer.getSkipping()) {
            String str = (String) LiveDataAdapterKt.observeAsState(this.this$0.getViewModel().getHeaderText$paymentsheet_release(), composer, 8).getValue();
            if (str != null) {
                H4TextKt.H4Text(str, PaddingKt.m435paddingqDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, Dp.m3859constructorimpl((float) 2), 7, (Object) null), composer, 48, 0);
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
