package com.stripe.android.ui.core.elements;

import android.content.Context;
import androidx.compose.ui.text.input.VisualTransformation;
import com.stripe.android.cards.CardAccountRangeRepository;
import com.stripe.android.cards.CardAccountRangeService;
import com.stripe.android.cards.CardNumber;
import com.stripe.android.cards.DefaultCardAccountRangeRepositoryFactory;
import com.stripe.android.cards.DefaultStaticCardAccountRanges;
import com.stripe.android.cards.StaticCardAccountRanges;
import com.stripe.android.model.CardBrand;
import com.stripe.android.ui.core.forms.FormFieldEntry;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0010\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020\u000fH\u0016J\u0010\u0010O\u001a\u00020M2\u0006\u0010P\u001a\u00020\u0016H\u0016J\u0010\u0010Q\u001a\u00020M2\u0006\u0010R\u001a\u00020\u0016H\u0016R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0015X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u00020\u00198\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001f\u0010\u001e\u001a\u00020\u001fX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00160\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010&R\u0014\u0010)\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u001c\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010-0\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010&R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010&R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020\u00160\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010&R\u001a\u00103\u001a\b\u0012\u0004\u0012\u0002040\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010&R\u001a\u00106\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010&R\u001f\u00107\u001a\u000208X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b9\u0010!R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u00020;0\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010&R\u001a\u0010=\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010&R\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00160\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010&R\u0014\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u001c\u0010C\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010D0\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010&R\u001a\u0010F\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010&R\u0014\u0010H\u001a\u00020IX\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010K\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006S"}, d2 = {"Lcom/stripe/android/ui/core/elements/CardNumberController;", "Lcom/stripe/android/ui/core/elements/TextFieldController;", "Lcom/stripe/android/ui/core/elements/SectionFieldErrorController;", "cardTextFieldConfig", "Lcom/stripe/android/ui/core/elements/CardNumberConfig;", "context", "Landroid/content/Context;", "(Lcom/stripe/android/ui/core/elements/CardNumberConfig;Landroid/content/Context;)V", "cardAccountRangeRepository", "Lcom/stripe/android/cards/CardAccountRangeRepository;", "workContext", "Lkotlin/coroutines/CoroutineContext;", "staticCardAccountRanges", "Lcom/stripe/android/cards/StaticCardAccountRanges;", "showOptionalLabel", "", "(Lcom/stripe/android/ui/core/elements/CardNumberConfig;Lcom/stripe/android/cards/CardAccountRangeRepository;Lkotlin/coroutines/CoroutineContext;Lcom/stripe/android/cards/StaticCardAccountRanges;Z)V", "_fieldState", "Lkotlinx/coroutines/flow/Flow;", "Lcom/stripe/android/ui/core/elements/TextFieldState;", "_fieldValue", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_hasFocus", "accountRangeService", "Lcom/stripe/android/cards/CardAccountRangeService;", "getAccountRangeService$annotations", "()V", "getAccountRangeService", "()Lcom/stripe/android/cards/CardAccountRangeService;", "capitalization", "Landroidx/compose/ui/text/input/KeyboardCapitalization;", "getCapitalization-IUNYP9k", "()I", "I", "cardBrandFlow", "Lcom/stripe/android/model/CardBrand;", "getCardBrandFlow$payments_ui_core_release", "()Lkotlinx/coroutines/flow/Flow;", "contentDescription", "getContentDescription", "debugLabel", "getDebugLabel", "()Ljava/lang/String;", "error", "Lcom/stripe/android/ui/core/elements/FieldError;", "getError", "fieldState", "getFieldState", "fieldValue", "getFieldValue", "formFieldValue", "Lcom/stripe/android/ui/core/forms/FormFieldEntry;", "getFormFieldValue", "isComplete", "keyboardType", "Landroidx/compose/ui/text/input/KeyboardType;", "getKeyboardType-PjHm6EE", "label", "", "getLabel", "loading", "getLoading", "rawFieldValue", "getRawFieldValue", "getShowOptionalLabel", "()Z", "trailingIcon", "Lcom/stripe/android/ui/core/elements/TextFieldIcon;", "getTrailingIcon", "visibleError", "getVisibleError", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "getVisualTransformation", "()Landroidx/compose/ui/text/input/VisualTransformation;", "onFocusChange", "", "newHasFocus", "onRawValueChange", "rawValue", "onValueChange", "displayFormatted", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CardNumberController.kt */
public final class CardNumberController implements TextFieldController, SectionFieldErrorController {
    private final Flow<TextFieldState> _fieldState;
    private final MutableStateFlow<String> _fieldValue;
    private final MutableStateFlow<Boolean> _hasFocus;
    private final CardAccountRangeService accountRangeService;
    private final int capitalization;
    private final Flow<CardBrand> cardBrandFlow;
    /* access modifiers changed from: private */
    public final CardNumberConfig cardTextFieldConfig;
    private final Flow<String> contentDescription;
    private final String debugLabel;
    private final Flow<FieldError> error;
    private final Flow<TextFieldState> fieldState;
    private final Flow<String> fieldValue;
    private final Flow<FormFieldEntry> formFieldValue;
    private final Flow<Boolean> isComplete;
    private final int keyboardType;
    private final Flow<Integer> label;
    private final Flow<Boolean> loading;
    private final Flow<String> rawFieldValue;
    private final boolean showOptionalLabel;
    private final Flow<TextFieldIcon> trailingIcon;
    private final Flow<Boolean> visibleError;
    private final VisualTransformation visualTransformation;

    public static /* synthetic */ void getAccountRangeService$annotations() {
    }

    public CardNumberController(CardNumberConfig cardNumberConfig, CardAccountRangeRepository cardAccountRangeRepository, CoroutineContext coroutineContext, StaticCardAccountRanges staticCardAccountRanges, boolean z) {
        Intrinsics.checkNotNullParameter(cardNumberConfig, "cardTextFieldConfig");
        Intrinsics.checkNotNullParameter(cardAccountRangeRepository, "cardAccountRangeRepository");
        Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
        Intrinsics.checkNotNullParameter(staticCardAccountRanges, "staticCardAccountRanges");
        this.cardTextFieldConfig = cardNumberConfig;
        this.showOptionalLabel = z;
        this.capitalization = cardNumberConfig.m4560getCapitalizationIUNYP9k();
        this.keyboardType = cardNumberConfig.m4561getKeyboardPjHm6EE();
        this.visualTransformation = cardNumberConfig.getVisualTransformation();
        this.debugLabel = cardNumberConfig.getDebugLabel();
        this.label = StateFlowKt.MutableStateFlow(Integer.valueOf(cardNumberConfig.getLabel()));
        MutableStateFlow<String> MutableStateFlow = StateFlowKt.MutableStateFlow("");
        this._fieldValue = MutableStateFlow;
        this.fieldValue = MutableStateFlow;
        this.rawFieldValue = new CardNumberController$special$$inlined$map$1(MutableStateFlow, this);
        this.contentDescription = MutableStateFlow;
        Flow<CardBrand> cardNumberController$special$$inlined$map$2 = new CardNumberController$special$$inlined$map$2(MutableStateFlow, this);
        this.cardBrandFlow = cardNumberController$special$$inlined$map$2;
        this.trailingIcon = new CardNumberController$special$$inlined$map$3(MutableStateFlow, this);
        Flow<TextFieldState> combine = FlowKt.combine(cardNumberController$special$$inlined$map$2, MutableStateFlow, new CardNumberController$_fieldState$1(this, (Continuation<? super CardNumberController$_fieldState$1>) null));
        this._fieldState = combine;
        this.fieldState = combine;
        MutableStateFlow<Boolean> MutableStateFlow2 = StateFlowKt.MutableStateFlow(false);
        this._hasFocus = MutableStateFlow2;
        CardAccountRangeService cardAccountRangeService = new CardAccountRangeService(cardAccountRangeRepository, coroutineContext, staticCardAccountRanges, new CardNumberController$accountRangeService$1(this));
        this.accountRangeService = cardAccountRangeService;
        this.loading = cardAccountRangeService.isLoading();
        this.visibleError = FlowKt.combine(combine, MutableStateFlow2, new CardNumberController$visibleError$1((Continuation<? super CardNumberController$visibleError$1>) null));
        this.error = FlowKt.combine(getVisibleError(), combine, new CardNumberController$error$1((Continuation<? super CardNumberController$error$1>) null));
        this.isComplete = new CardNumberController$special$$inlined$map$4(combine);
        this.formFieldValue = FlowKt.combine(isComplete(), getRawFieldValue(), new CardNumberController$formFieldValue$1((Continuation<? super CardNumberController$formFieldValue$1>) null));
        onValueChange("");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CardNumberController(CardNumberConfig cardNumberConfig, CardAccountRangeRepository cardAccountRangeRepository, CoroutineContext coroutineContext, StaticCardAccountRanges staticCardAccountRanges, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(cardNumberConfig, cardAccountRangeRepository, coroutineContext, (i & 8) != 0 ? new DefaultStaticCardAccountRanges() : staticCardAccountRanges, (i & 16) != 0 ? false : z);
    }

    public boolean getShowOptionalLabel() {
        return this.showOptionalLabel;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CardNumberController(CardNumberConfig cardNumberConfig, Context context) {
        this(cardNumberConfig, new DefaultCardAccountRangeRepositoryFactory(context).create(), Dispatchers.getIO(), (StaticCardAccountRanges) null, false, 24, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(cardNumberConfig, "cardTextFieldConfig");
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* renamed from: getCapitalization-IUNYP9k  reason: not valid java name */
    public int m4562getCapitalizationIUNYP9k() {
        return this.capitalization;
    }

    /* renamed from: getKeyboardType-PjHm6EE  reason: not valid java name */
    public int m4563getKeyboardTypePjHm6EE() {
        return this.keyboardType;
    }

    public VisualTransformation getVisualTransformation() {
        return this.visualTransformation;
    }

    public String getDebugLabel() {
        return this.debugLabel;
    }

    public Flow<Integer> getLabel() {
        return this.label;
    }

    public Flow<String> getFieldValue() {
        return this.fieldValue;
    }

    public Flow<String> getRawFieldValue() {
        return this.rawFieldValue;
    }

    public Flow<String> getContentDescription() {
        return this.contentDescription;
    }

    public final Flow<CardBrand> getCardBrandFlow$payments_ui_core_release() {
        return this.cardBrandFlow;
    }

    public Flow<TextFieldIcon> getTrailingIcon() {
        return this.trailingIcon;
    }

    public Flow<TextFieldState> getFieldState() {
        return this.fieldState;
    }

    public final CardAccountRangeService getAccountRangeService() {
        return this.accountRangeService;
    }

    public Flow<Boolean> getLoading() {
        return this.loading;
    }

    public Flow<Boolean> getVisibleError() {
        return this.visibleError;
    }

    public Flow<FieldError> getError() {
        return this.error;
    }

    public Flow<Boolean> isComplete() {
        return this.isComplete;
    }

    public Flow<FormFieldEntry> getFormFieldValue() {
        return this.formFieldValue;
    }

    public void onValueChange(String str) {
        Intrinsics.checkNotNullParameter(str, "displayFormatted");
        this._fieldValue.setValue(this.cardTextFieldConfig.filter(str));
        this.accountRangeService.onCardNumberChanged(new CardNumber.Unvalidated(str));
    }

    public void onRawValueChange(String str) {
        Intrinsics.checkNotNullParameter(str, "rawValue");
        onValueChange(this.cardTextFieldConfig.convertFromRaw(str));
    }

    public void onFocusChange(boolean z) {
        this._hasFocus.setValue(Boolean.valueOf(z));
    }
}
