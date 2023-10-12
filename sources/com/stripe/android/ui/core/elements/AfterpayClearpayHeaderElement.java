package com.stripe.android.ui.core.elements;

import android.content.res.Resources;
import androidx.compose.ui.text.intl.Locale;
import com.brentvatne.react.ReactVideoView;
import com.stripe.android.paymentsheet.viewmodels.BaseSheetViewModel;
import com.stripe.android.ui.core.Amount;
import com.stripe.android.ui.core.CurrencyFormatter;
import com.stripe.android.ui.core.R;
import com.stripe.android.ui.core.forms.FormFieldEntry;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 $2\u00020\u0001:\u0001$B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÂ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J \u0010\u0019\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001d0\u001c0\u001b0\u001aH\u0016J\u000e\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020 J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u000eHÖ\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006%"}, d2 = {"Lcom/stripe/android/ui/core/elements/AfterpayClearpayHeaderElement;", "Lcom/stripe/android/ui/core/elements/FormElement;", "identifier", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "amount", "Lcom/stripe/android/ui/core/Amount;", "controller", "Lcom/stripe/android/ui/core/elements/Controller;", "(Lcom/stripe/android/ui/core/elements/IdentifierSpec;Lcom/stripe/android/ui/core/Amount;Lcom/stripe/android/ui/core/elements/Controller;)V", "getController", "()Lcom/stripe/android/ui/core/elements/Controller;", "getIdentifier", "()Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "infoUrl", "", "getInfoUrl", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "getFormFieldValueFlow", "Lkotlinx/coroutines/flow/Flow;", "", "Lkotlin/Pair;", "Lcom/stripe/android/ui/core/forms/FormFieldEntry;", "getLabel", "resources", "Landroid/content/res/Resources;", "hashCode", "", "toString", "Companion", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AfterpayClearpayHeaderElement.kt */
public final class AfterpayClearpayHeaderElement extends FormElement {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String url = "https://static-us.afterpay.com/javascript/modal/%s_rebrand_modal.html";
    private final Amount amount;
    private final Controller controller;
    private final IdentifierSpec identifier;
    private final String infoUrl;

    private final Amount component2() {
        return this.amount;
    }

    public static /* synthetic */ AfterpayClearpayHeaderElement copy$default(AfterpayClearpayHeaderElement afterpayClearpayHeaderElement, IdentifierSpec identifierSpec, Amount amount2, Controller controller2, int i, Object obj) {
        if ((i & 1) != 0) {
            identifierSpec = afterpayClearpayHeaderElement.getIdentifier();
        }
        if ((i & 2) != 0) {
            amount2 = afterpayClearpayHeaderElement.amount;
        }
        if ((i & 4) != 0) {
            controller2 = afterpayClearpayHeaderElement.getController();
        }
        return afterpayClearpayHeaderElement.copy(identifierSpec, amount2, controller2);
    }

    public final IdentifierSpec component1() {
        return getIdentifier();
    }

    public final Controller component3() {
        return getController();
    }

    public final AfterpayClearpayHeaderElement copy(IdentifierSpec identifierSpec, Amount amount2, Controller controller2) {
        Intrinsics.checkNotNullParameter(identifierSpec, ReactVideoView.EVENT_PROP_METADATA_IDENTIFIER);
        Intrinsics.checkNotNullParameter(amount2, BaseSheetViewModel.SAVE_AMOUNT);
        return new AfterpayClearpayHeaderElement(identifierSpec, amount2, controller2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AfterpayClearpayHeaderElement)) {
            return false;
        }
        AfterpayClearpayHeaderElement afterpayClearpayHeaderElement = (AfterpayClearpayHeaderElement) obj;
        return Intrinsics.areEqual((Object) getIdentifier(), (Object) afterpayClearpayHeaderElement.getIdentifier()) && Intrinsics.areEqual((Object) this.amount, (Object) afterpayClearpayHeaderElement.amount) && Intrinsics.areEqual((Object) getController(), (Object) afterpayClearpayHeaderElement.getController());
    }

    public int hashCode() {
        return (((getIdentifier().hashCode() * 31) + this.amount.hashCode()) * 31) + (getController() == null ? 0 : getController().hashCode());
    }

    public String toString() {
        return "AfterpayClearpayHeaderElement(identifier=" + getIdentifier() + ", amount=" + this.amount + ", controller=" + getController() + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AfterpayClearpayHeaderElement(IdentifierSpec identifierSpec, Amount amount2, Controller controller2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(identifierSpec, amount2, (i & 4) != 0 ? null : controller2);
    }

    public IdentifierSpec getIdentifier() {
        return this.identifier;
    }

    public Controller getController() {
        return this.controller;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AfterpayClearpayHeaderElement(IdentifierSpec identifierSpec, Amount amount2, Controller controller2) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(identifierSpec, ReactVideoView.EVENT_PROP_METADATA_IDENTIFIER);
        Intrinsics.checkNotNullParameter(amount2, BaseSheetViewModel.SAVE_AMOUNT);
        this.identifier = identifierSpec;
        this.amount = amount2;
        this.controller = controller2;
        String lowerCase = Locale.Companion.getCurrent().getRegion().toLowerCase(java.util.Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        String format = String.format(url, Arrays.copyOf(new Object[]{lowerCase}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        this.infoUrl = format;
    }

    public Flow<List<Pair<IdentifierSpec, FormFieldEntry>>> getFormFieldValueFlow() {
        return StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
    }

    public final String getInfoUrl() {
        return this.infoUrl;
    }

    public final String getLabel(Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        String string = resources.getString(R.string.afterpay_clearpay_message, new Object[]{CurrencyFormatter.Companion.format$default(CurrencyFormatter.Companion, this.amount.getValue() / ((long) 4), this.amount.getCurrencyCode(), (java.util.Locale) null, 4, (Object) null)});
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …e\n            )\n        )");
        return string;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/ui/core/elements/AfterpayClearpayHeaderElement$Companion;", "", "()V", "url", "", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AfterpayClearpayHeaderElement.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
