package com.stripe.android.ui.core.elements;

import androidx.compose.ui.text.input.VisualTransformation;
import com.stripe.android.model.CardBrand;
import com.stripe.android.ui.core.forms.FormFieldEntry;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\tH\u0016J\u0010\u0010@\u001a\u00020>2\u0006\u0010A\u001a\u00020\u000fH\u0016J\u0010\u0010B\u001a\u00020>2\u0006\u0010C\u001a\u00020\u000fH\u0016R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0006X\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0013\u001a\u00020\u0014X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\f0\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001aR\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001aR\u001f\u0010)\u001a\u00020*X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b+\u0010\u0016R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00120\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001aR\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001aR\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001aR\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u001c\u00104\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001050\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u001aR\u001a\u00107\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u001aR\u0014\u00109\u001a\u00020:X\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006D"}, d2 = {"Lcom/stripe/android/ui/core/elements/CvcController;", "Lcom/stripe/android/ui/core/elements/TextFieldController;", "Lcom/stripe/android/ui/core/elements/SectionFieldErrorController;", "cvcTextFieldConfig", "Lcom/stripe/android/ui/core/elements/CvcConfig;", "cardBrandFlow", "Lkotlinx/coroutines/flow/Flow;", "Lcom/stripe/android/model/CardBrand;", "showOptionalLabel", "", "(Lcom/stripe/android/ui/core/elements/CvcConfig;Lkotlinx/coroutines/flow/Flow;Z)V", "_fieldState", "Lcom/stripe/android/ui/core/elements/TextFieldState;", "_fieldValue", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_hasFocus", "_label", "", "capitalization", "Landroidx/compose/ui/text/input/KeyboardCapitalization;", "getCapitalization-IUNYP9k", "()I", "I", "contentDescription", "getContentDescription", "()Lkotlinx/coroutines/flow/Flow;", "debugLabel", "getDebugLabel", "()Ljava/lang/String;", "error", "Lcom/stripe/android/ui/core/elements/FieldError;", "getError", "fieldState", "getFieldState", "fieldValue", "getFieldValue", "formFieldValue", "Lcom/stripe/android/ui/core/forms/FormFieldEntry;", "getFormFieldValue", "isComplete", "keyboardType", "Landroidx/compose/ui/text/input/KeyboardType;", "getKeyboardType-PjHm6EE", "label", "getLabel", "loading", "getLoading", "rawFieldValue", "getRawFieldValue", "getShowOptionalLabel", "()Z", "trailingIcon", "Lcom/stripe/android/ui/core/elements/TextFieldIcon;", "getTrailingIcon", "visibleError", "getVisibleError", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "getVisualTransformation", "()Landroidx/compose/ui/text/input/VisualTransformation;", "onFocusChange", "", "newHasFocus", "onRawValueChange", "rawValue", "onValueChange", "displayFormatted", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CvcController.kt */
public final class CvcController implements TextFieldController, SectionFieldErrorController {
    private final Flow<TextFieldState> _fieldState;
    private final MutableStateFlow<String> _fieldValue;
    private final MutableStateFlow<Boolean> _hasFocus;
    private final Flow<Integer> _label;
    private final int capitalization;
    private final Flow<String> contentDescription;
    /* access modifiers changed from: private */
    public final CvcConfig cvcTextFieldConfig;
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

    public CvcController(CvcConfig cvcConfig, Flow<? extends CardBrand> flow, boolean z) {
        Intrinsics.checkNotNullParameter(cvcConfig, "cvcTextFieldConfig");
        Intrinsics.checkNotNullParameter(flow, "cardBrandFlow");
        this.cvcTextFieldConfig = cvcConfig;
        this.showOptionalLabel = z;
        this.capitalization = cvcConfig.m4566getCapitalizationIUNYP9k();
        this.keyboardType = cvcConfig.m4567getKeyboardPjHm6EE();
        this.visualTransformation = cvcConfig.getVisualTransformation();
        Flow<Integer> cvcController$special$$inlined$map$1 = new CvcController$special$$inlined$map$1(flow);
        this._label = cvcController$special$$inlined$map$1;
        this.label = cvcController$special$$inlined$map$1;
        this.debugLabel = cvcConfig.getDebugLabel();
        MutableStateFlow<String> MutableStateFlow = StateFlowKt.MutableStateFlow("");
        this._fieldValue = MutableStateFlow;
        this.fieldValue = MutableStateFlow;
        this.rawFieldValue = new CvcController$special$$inlined$map$2(MutableStateFlow, this);
        this.contentDescription = new CvcController$special$$inlined$map$3(MutableStateFlow);
        Flow<TextFieldState> combine = FlowKt.combine(flow, MutableStateFlow, new CvcController$_fieldState$1(this, (Continuation<? super CvcController$_fieldState$1>) null));
        this._fieldState = combine;
        this.fieldState = combine;
        MutableStateFlow<Boolean> MutableStateFlow2 = StateFlowKt.MutableStateFlow(false);
        this._hasFocus = MutableStateFlow2;
        this.visibleError = FlowKt.combine(combine, MutableStateFlow2, new CvcController$visibleError$1((Continuation<? super CvcController$visibleError$1>) null));
        this.error = FlowKt.combine(getVisibleError(), combine, new CvcController$error$1((Continuation<? super CvcController$error$1>) null));
        this.isComplete = new CvcController$special$$inlined$map$4(combine);
        this.formFieldValue = FlowKt.combine(isComplete(), getRawFieldValue(), new CvcController$formFieldValue$1((Continuation<? super CvcController$formFieldValue$1>) null));
        this.trailingIcon = new CvcController$special$$inlined$map$5(flow);
        this.loading = StateFlowKt.MutableStateFlow(false);
        onValueChange("");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CvcController(CvcConfig cvcConfig, Flow flow, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(cvcConfig, flow, (i & 4) != 0 ? false : z);
    }

    public boolean getShowOptionalLabel() {
        return this.showOptionalLabel;
    }

    /* renamed from: getCapitalization-IUNYP9k  reason: not valid java name */
    public int m4568getCapitalizationIUNYP9k() {
        return this.capitalization;
    }

    /* renamed from: getKeyboardType-PjHm6EE  reason: not valid java name */
    public int m4569getKeyboardTypePjHm6EE() {
        return this.keyboardType;
    }

    public VisualTransformation getVisualTransformation() {
        return this.visualTransformation;
    }

    public Flow<Integer> getLabel() {
        return this.label;
    }

    public String getDebugLabel() {
        return this.debugLabel;
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

    public Flow<TextFieldState> getFieldState() {
        return this.fieldState;
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

    public Flow<TextFieldIcon> getTrailingIcon() {
        return this.trailingIcon;
    }

    public Flow<Boolean> getLoading() {
        return this.loading;
    }

    public void onValueChange(String str) {
        Intrinsics.checkNotNullParameter(str, "displayFormatted");
        this._fieldValue.setValue(this.cvcTextFieldConfig.filter(str));
    }

    public void onRawValueChange(String str) {
        Intrinsics.checkNotNullParameter(str, "rawValue");
        onValueChange(this.cvcTextFieldConfig.convertFromRaw(str));
    }

    public void onFocusChange(boolean z) {
        this._hasFocus.setValue(Boolean.valueOf(z));
    }
}
