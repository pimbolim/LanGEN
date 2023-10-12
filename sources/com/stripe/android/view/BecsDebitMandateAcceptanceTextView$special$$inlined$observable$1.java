package com.stripe.android.view;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\b¨\u0006\t¸\u0006\u0000"}, d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Delegates.kt */
public final class BecsDebitMandateAcceptanceTextView$special$$inlined$observable$1 extends ObservableProperty<String> {
    final /* synthetic */ Object $initialValue;
    final /* synthetic */ BecsDebitMandateAcceptanceTextView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BecsDebitMandateAcceptanceTextView$special$$inlined$observable$1(Object obj, BecsDebitMandateAcceptanceTextView becsDebitMandateAcceptanceTextView) {
        super(obj);
        this.$initialValue = obj;
        this.this$0 = becsDebitMandateAcceptanceTextView;
    }

    /* access modifiers changed from: protected */
    public void afterChange(KProperty<?> kProperty, String str, String str2) {
        CharSequence charSequence;
        CharSequence create;
        Intrinsics.checkNotNullParameter(kProperty, "property");
        String str3 = str2;
        String str4 = str;
        BecsDebitMandateAcceptanceTextView becsDebitMandateAcceptanceTextView = this.this$0;
        if (!(!StringsKt.isBlank(str3))) {
            str3 = null;
        }
        if (str3 != null && (create = this.this$0.factory.create(str3)) != null) {
            charSequence = create;
        }
        becsDebitMandateAcceptanceTextView.setText(charSequence);
    }
}
