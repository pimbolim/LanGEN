package com.stripe.android.ui.core.elements;

import androidx.compose.ui.text.input.VisualTransformation;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001aH&J\u0010\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020\bH&R\u001b\u0010\u0002\u001a\u00020\u0003X¦\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\nR\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\nR\u001b\u0010\u0013\u001a\u00020\u0014X¦\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0005R\u0018\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\nR\u0018\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\nR\u0012\u0010\u001c\u001a\u00020\u001aX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\nR\u0018\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\nR\u0012\u0010$\u001a\u00020%X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006-"}, d2 = {"Lcom/stripe/android/ui/core/elements/TextFieldController;", "Lcom/stripe/android/ui/core/elements/InputController;", "capitalization", "Landroidx/compose/ui/text/input/KeyboardCapitalization;", "getCapitalization-IUNYP9k", "()I", "contentDescription", "Lkotlinx/coroutines/flow/Flow;", "", "getContentDescription", "()Lkotlinx/coroutines/flow/Flow;", "debugLabel", "getDebugLabel", "()Ljava/lang/String;", "fieldState", "Lcom/stripe/android/ui/core/elements/TextFieldState;", "getFieldState", "fieldValue", "getFieldValue", "keyboardType", "Landroidx/compose/ui/text/input/KeyboardType;", "getKeyboardType-PjHm6EE", "label", "", "getLabel", "loading", "", "getLoading", "showOptionalLabel", "getShowOptionalLabel", "()Z", "trailingIcon", "Lcom/stripe/android/ui/core/elements/TextFieldIcon;", "getTrailingIcon", "visibleError", "getVisibleError", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "getVisualTransformation", "()Landroidx/compose/ui/text/input/VisualTransformation;", "onFocusChange", "", "newHasFocus", "onValueChange", "displayFormatted", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextFieldController.kt */
public interface TextFieldController extends InputController {
    /* renamed from: getCapitalization-IUNYP9k  reason: not valid java name */
    int m4605getCapitalizationIUNYP9k();

    Flow<String> getContentDescription();

    String getDebugLabel();

    Flow<TextFieldState> getFieldState();

    Flow<String> getFieldValue();

    /* renamed from: getKeyboardType-PjHm6EE  reason: not valid java name */
    int m4606getKeyboardTypePjHm6EE();

    Flow<Integer> getLabel();

    Flow<Boolean> getLoading();

    boolean getShowOptionalLabel();

    Flow<TextFieldIcon> getTrailingIcon();

    Flow<Boolean> getVisibleError();

    VisualTransformation getVisualTransformation();

    void onFocusChange(boolean z);

    void onValueChange(String str);
}
