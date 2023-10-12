package com.stripe.android.ui.core.elements;

import androidx.compose.ui.text.input.VisualTransformation;
import com.stripe.android.ui.core.elements.TextFieldStateConstants;
import com.stripe.android.ui.core.forms.FormFieldEntry;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0010\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u0006H\u0016J\u0010\u0010>\u001a\u00020<2\u0006\u0010?\u001a\u00020\bH\u0016J\u0010\u0010@\u001a\u00020<2\u0006\u0010A\u001a\u00020\bH\u0016R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bX\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u000f\u001a\u00020\u0010X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00060\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R\u001f\u0010&\u001a\u00020'X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b(\u0010\u0012R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0017R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00060\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0017R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020\b0\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0017R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001c\u00102\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001030\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u0017R\u001a\u00105\u001a\b\u0012\u0004\u0012\u00020\u00060\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u0017R\u0014\u00107\u001a\u000208X\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006B"}, d2 = {"Lcom/stripe/android/ui/core/elements/SimpleTextFieldController;", "Lcom/stripe/android/ui/core/elements/TextFieldController;", "Lcom/stripe/android/ui/core/elements/SectionFieldErrorController;", "textFieldConfig", "Lcom/stripe/android/ui/core/elements/TextFieldConfig;", "showOptionalLabel", "", "initialValue", "", "(Lcom/stripe/android/ui/core/elements/TextFieldConfig;ZLjava/lang/String;)V", "_fieldState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/stripe/android/ui/core/elements/TextFieldState;", "_fieldValue", "_hasFocus", "capitalization", "Landroidx/compose/ui/text/input/KeyboardCapitalization;", "getCapitalization-IUNYP9k", "()I", "I", "contentDescription", "Lkotlinx/coroutines/flow/Flow;", "getContentDescription", "()Lkotlinx/coroutines/flow/Flow;", "debugLabel", "getDebugLabel", "()Ljava/lang/String;", "error", "Lcom/stripe/android/ui/core/elements/FieldError;", "getError", "fieldState", "getFieldState", "fieldValue", "getFieldValue", "formFieldValue", "Lcom/stripe/android/ui/core/forms/FormFieldEntry;", "getFormFieldValue", "isComplete", "keyboardType", "Landroidx/compose/ui/text/input/KeyboardType;", "getKeyboardType-PjHm6EE", "label", "", "getLabel", "loading", "getLoading", "rawFieldValue", "getRawFieldValue", "getShowOptionalLabel", "()Z", "trailingIcon", "Lcom/stripe/android/ui/core/elements/TextFieldIcon;", "getTrailingIcon", "visibleError", "getVisibleError", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "getVisualTransformation", "()Landroidx/compose/ui/text/input/VisualTransformation;", "onFocusChange", "", "newHasFocus", "onRawValueChange", "rawValue", "onValueChange", "displayFormatted", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextFieldController.kt */
public final class SimpleTextFieldController implements TextFieldController, SectionFieldErrorController {
    public static final int $stable = 8;
    /* access modifiers changed from: private */
    public final MutableStateFlow<TextFieldState> _fieldState;
    private final MutableStateFlow<String> _fieldValue;
    private final MutableStateFlow<Boolean> _hasFocus;
    private final int capitalization;
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
    /* access modifiers changed from: private */
    public final TextFieldConfig textFieldConfig;
    private final Flow<TextFieldIcon> trailingIcon;
    private final Flow<Boolean> visibleError;
    private final VisualTransformation visualTransformation;

    public SimpleTextFieldController(TextFieldConfig textFieldConfig2, boolean z, String str) {
        Intrinsics.checkNotNullParameter(textFieldConfig2, "textFieldConfig");
        this.textFieldConfig = textFieldConfig2;
        this.showOptionalLabel = z;
        this.trailingIcon = textFieldConfig2.getTrailingIcon();
        this.capitalization = textFieldConfig2.m4603getCapitalizationIUNYP9k();
        this.keyboardType = textFieldConfig2.m4604getKeyboardPjHm6EE();
        VisualTransformation visualTransformation2 = textFieldConfig2.getVisualTransformation();
        this.visualTransformation = visualTransformation2 == null ? VisualTransformation.Companion.getNone() : visualTransformation2;
        this.label = StateFlowKt.MutableStateFlow(Integer.valueOf(textFieldConfig2.getLabel()));
        this.debugLabel = textFieldConfig2.getDebugLabel();
        MutableStateFlow<String> MutableStateFlow = StateFlowKt.MutableStateFlow("");
        this._fieldValue = MutableStateFlow;
        this.fieldValue = MutableStateFlow;
        this.rawFieldValue = new SimpleTextFieldController$special$$inlined$map$1(MutableStateFlow, this);
        this.contentDescription = MutableStateFlow;
        MutableStateFlow<TextFieldState> MutableStateFlow2 = StateFlowKt.MutableStateFlow(TextFieldStateConstants.Error.Blank.INSTANCE);
        this._fieldState = MutableStateFlow2;
        this.fieldState = MutableStateFlow2;
        this.loading = textFieldConfig2.getLoading();
        MutableStateFlow<Boolean> MutableStateFlow3 = StateFlowKt.MutableStateFlow(false);
        this._hasFocus = MutableStateFlow3;
        this.visibleError = FlowKt.combine(MutableStateFlow2, MutableStateFlow3, new SimpleTextFieldController$visibleError$1((Continuation<? super SimpleTextFieldController$visibleError$1>) null));
        this.error = new SimpleTextFieldController$special$$inlined$map$2(getVisibleError(), this);
        this.isComplete = new SimpleTextFieldController$special$$inlined$map$3(MutableStateFlow2, this);
        this.formFieldValue = FlowKt.combine(isComplete(), getRawFieldValue(), new SimpleTextFieldController$formFieldValue$1((Continuation<? super SimpleTextFieldController$formFieldValue$1>) null));
        if (str != null) {
            onRawValueChange(str);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SimpleTextFieldController(TextFieldConfig textFieldConfig2, boolean z, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(textFieldConfig2, (i & 2) != 0 ? false : z, (i & 4) != 0 ? null : str);
    }

    public boolean getShowOptionalLabel() {
        return this.showOptionalLabel;
    }

    public Flow<TextFieldIcon> getTrailingIcon() {
        return this.trailingIcon;
    }

    /* renamed from: getCapitalization-IUNYP9k  reason: not valid java name */
    public int m4595getCapitalizationIUNYP9k() {
        return this.capitalization;
    }

    /* renamed from: getKeyboardType-PjHm6EE  reason: not valid java name */
    public int m4596getKeyboardTypePjHm6EE() {
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
        this._fieldValue.setValue(this.textFieldConfig.filter(str));
        this._fieldState.setValue(this.textFieldConfig.determineState(this._fieldValue.getValue()));
    }

    public void onRawValueChange(String str) {
        Intrinsics.checkNotNullParameter(str, "rawValue");
        onValueChange(this.textFieldConfig.convertFromRaw(str));
    }

    public void onFocusChange(boolean z) {
        this._hasFocus.setValue(Boolean.valueOf(z));
    }
}
