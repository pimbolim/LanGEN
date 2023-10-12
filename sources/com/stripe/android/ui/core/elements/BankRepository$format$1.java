package com.stripe.android.ui.core.elements;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.json.JsonBuilder;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/serialization/json/JsonBuilder;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BankRepository.kt */
final class BankRepository$format$1 extends Lambda implements Function1<JsonBuilder, Unit> {
    public static final BankRepository$format$1 INSTANCE = new BankRepository$format$1();

    BankRepository$format$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((JsonBuilder) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(JsonBuilder jsonBuilder) {
        Intrinsics.checkNotNullParameter(jsonBuilder, "$this$Json");
        jsonBuilder.setIgnoreUnknownKeys(true);
    }
}
