package com.stripe.android.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import androidx.appcompat.R;
import androidx.core.content.ContextCompat;
import com.google.android.material.textfield.TextInputEditText;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\r\n\u0002\b\u0007\b\u0017\u0018\u00002\u00020\u0001:\u0005`abcdB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u000106H\u0016J\b\u0010:\u001a\u000208H\u0002J\n\u0010;\u001a\u0004\u0018\u00010&H\u0016J\u0010\u0010<\u001a\n =*\u0004\u0018\u00010&0&H\u0007J\u0018\u0010>\u001a\u00020.2\u0006\u0010?\u001a\u00020\u00072\u0006\u0010@\u001a\u00020AH\u0002J\b\u0010B\u001a\u000208H\u0002J\b\u0010C\u001a\u000208H\u0002J\u0012\u0010D\u001a\u0004\u0018\u00010E2\u0006\u0010F\u001a\u00020GH\u0016J\u0010\u0010H\u001a\u0002082\u0006\u0010I\u001a\u00020JH\u0016J\u0012\u0010K\u001a\u0002082\b\u0010L\u001a\u0004\u0018\u00010MH\u0016J\b\u0010N\u001a\u00020MH\u0016J\u0012\u0010O\u001a\u0002082\b\u00109\u001a\u0004\u0018\u000106H\u0016J\u0010\u0010P\u001a\u0002082\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010Q\u001a\u0002082\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010R\u001a\u0002082\b\b\u0001\u0010S\u001a\u00020\u0007J\u0010\u0010T\u001a\u0002082\b\u0010\u001c\u001a\u0004\u0018\u00010\nJ\u0010\u0010U\u001a\u0002082\b\u0010 \u001a\u0004\u0018\u00010!J\b\u0010V\u001a\u000208H\u0007J\u0010\u0010W\u001a\u0002082\b\u0010X\u001a\u0004\u0018\u00010&J\u0012\u0010Y\u001a\u0002082\b\u0010Z\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010Y\u001a\u0002082\u0006\u0010[\u001a\u00020\u0007H\u0016J\u0017\u0010\\\u001a\u0002082\b\u0010]\u001a\u0004\u0018\u00010^H\u0000¢\u0006\u0002\b_R\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@AX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u00078G¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\f\"\u0004\b\u001e\u0010\u001fR\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010#\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0004\n\u0002\u0010$R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\u00020\n8@X\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\fR\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020&0*8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010/\"\u0004\b0\u00101R$\u00102\u001a\u00020.2\u0006\u00102\u001a\u00020.@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010/\"\u0004\b4\u00101R\u0016\u00105\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000¨\u0006e"}, d2 = {"Lcom/stripe/android/view/StripeEditText;", "Lcom/google/android/material/textfield/TextInputEditText;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "accessibilityText", "", "getAccessibilityText", "()Ljava/lang/String;", "afterTextChangedListener", "Lcom/stripe/android/view/StripeEditText$AfterTextChangedListener;", "<set-?>", "Landroid/content/res/ColorStateList;", "defaultColorStateList", "getDefaultColorStateList$payments_core_release", "()Landroid/content/res/ColorStateList;", "setDefaultColorStateList$payments_core_release", "(Landroid/content/res/ColorStateList;)V", "defaultErrorColor", "defaultErrorColorInt", "getDefaultErrorColorInt", "()I", "deleteEmptyListener", "Lcom/stripe/android/view/StripeEditText$DeleteEmptyListener;", "errorMessage", "getErrorMessage$payments_core_release", "setErrorMessage$payments_core_release", "(Ljava/lang/String;)V", "errorMessageListener", "Lcom/stripe/android/view/StripeEditText$ErrorMessageListener;", "externalColorStateList", "externalErrorColor", "Ljava/lang/Integer;", "externalFocusChangeListener", "Landroid/view/View$OnFocusChangeListener;", "fieldText", "getFieldText$payments_core_release", "internalFocusChangeListeners", "", "getInternalFocusChangeListeners", "()Ljava/util/List;", "isLastKeyDelete", "", "()Z", "setLastKeyDelete", "(Z)V", "shouldShowError", "getShouldShowError", "setShouldShowError", "textWatchers", "Landroid/text/TextWatcher;", "addTextChangedListener", "", "watcher", "determineDefaultErrorColor", "getOnFocusChangeListener", "getParentOnFocusChangeListener", "kotlin.jvm.PlatformType", "isDeleteKey", "keyCode", "event", "Landroid/view/KeyEvent;", "listenForDeleteEmpty", "listenForTextChanges", "onCreateInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "onInitializeAccessibilityNodeInfo", "info", "Landroid/view/accessibility/AccessibilityNodeInfo;", "onRestoreInstanceState", "state", "Landroid/os/Parcelable;", "onSaveInstanceState", "removeTextChangedListener", "setAfterTextChangedListener", "setDeleteEmptyListener", "setErrorColor", "errorColor", "setErrorMessage", "setErrorMessageListener", "setNumberOnlyInputType", "setOnFocusChangeListener", "listener", "setTextColor", "colors", "color", "setTextSilent", "text", "", "setTextSilent$payments_core_release", "AfterTextChangedListener", "DeleteEmptyListener", "ErrorMessageListener", "SoftDeleteInputConnection", "StripeEditTextState", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StripeEditText.kt */
public class StripeEditText extends TextInputEditText {
    public static final int $stable = 8;
    private final String accessibilityText;
    /* access modifiers changed from: private */
    public AfterTextChangedListener afterTextChangedListener;
    private ColorStateList defaultColorStateList;
    private int defaultErrorColor;
    private DeleteEmptyListener deleteEmptyListener;
    private String errorMessage;
    private ErrorMessageListener errorMessageListener;
    private ColorStateList externalColorStateList;
    private Integer externalErrorColor;
    private View.OnFocusChangeListener externalFocusChangeListener;
    private final List<View.OnFocusChangeListener> internalFocusChangeListeners;
    private boolean isLastKeyDelete;
    private boolean shouldShowError;
    private List<TextWatcher> textWatchers;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/view/StripeEditText$AfterTextChangedListener;", "", "onTextChanged", "", "text", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StripeEditText.kt */
    public interface AfterTextChangedListener {
        void onTextChanged(String str);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/stripe/android/view/StripeEditText$DeleteEmptyListener;", "", "onDeleteEmpty", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StripeEditText.kt */
    public interface DeleteEmptyListener {
        void onDeleteEmpty();
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/view/StripeEditText$ErrorMessageListener;", "", "displayErrorMessage", "", "message", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StripeEditText.kt */
    public interface ErrorMessageListener {
        void displayErrorMessage(String str);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StripeEditText(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StripeEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StripeEditText(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? R.attr.editTextStyle : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StripeEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.textWatchers = new ArrayList();
        setMaxLines(1);
        listenForTextChanges();
        listenForDeleteEmpty();
        ColorStateList textColors = getTextColors();
        Intrinsics.checkNotNullExpressionValue(textColors, "textColors");
        this.defaultColorStateList = textColors;
        determineDefaultErrorColor();
        setOnFocusChangeListener((View.OnFocusChangeListener) null);
        this.internalFocusChangeListeners = new ArrayList();
    }

    /* access modifiers changed from: protected */
    public final boolean isLastKeyDelete() {
        return this.isLastKeyDelete;
    }

    /* access modifiers changed from: protected */
    public final void setLastKeyDelete(boolean z) {
        this.isLastKeyDelete = z;
    }

    public final ColorStateList getDefaultColorStateList$payments_core_release() {
        return this.defaultColorStateList;
    }

    public final void setDefaultColorStateList$payments_core_release(ColorStateList colorStateList) {
        Intrinsics.checkNotNullParameter(colorStateList, "<set-?>");
        this.defaultColorStateList = colorStateList;
    }

    public final boolean getShouldShowError() {
        return this.shouldShowError;
    }

    public final void setShouldShowError(boolean z) {
        ErrorMessageListener errorMessageListener2;
        String str = this.errorMessage;
        if (!(str == null || (errorMessageListener2 = this.errorMessageListener) == null)) {
            if (!z) {
                str = null;
            }
            errorMessageListener2.displayErrorMessage(str);
        }
        if (this.shouldShowError != z) {
            if (z) {
                Integer num = this.externalErrorColor;
                super.setTextColor(num == null ? this.defaultErrorColor : num.intValue());
            } else {
                ColorStateList colorStateList = this.externalColorStateList;
                if (colorStateList == null) {
                    colorStateList = this.defaultColorStateList;
                }
                super.setTextColor(colorStateList);
            }
            refreshDrawableState();
        }
        this.shouldShowError = z;
    }

    public final String getErrorMessage$payments_core_release() {
        return this.errorMessage;
    }

    public final void setErrorMessage$payments_core_release(String str) {
        this.errorMessage = str;
    }

    public final String getFieldText$payments_core_release() {
        Editable text = getText();
        String obj = text == null ? null : text.toString();
        return obj == null ? "" : obj;
    }

    public final int getDefaultErrorColorInt() {
        determineDefaultErrorColor();
        return this.defaultErrorColor;
    }

    public final List<View.OnFocusChangeListener> getInternalFocusChangeListeners() {
        return this.internalFocusChangeListeners;
    }

    /* access modifiers changed from: protected */
    public String getAccessibilityText() {
        return this.accessibilityText;
    }

    public void setTextColor(ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        this.externalColorStateList = getTextColors();
    }

    public void setTextColor(int i) {
        setTextColor(ColorStateList.valueOf(i));
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        SoftDeleteInputConnection softDeleteInputConnection;
        Intrinsics.checkNotNullParameter(editorInfo, "outAttrs");
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (onCreateInputConnection == null) {
            softDeleteInputConnection = null;
        } else {
            softDeleteInputConnection = new SoftDeleteInputConnection(onCreateInputConnection, true, this.deleteEmptyListener);
        }
        return softDeleteInputConnection;
    }

    public final void setAfterTextChangedListener(AfterTextChangedListener afterTextChangedListener2) {
        this.afterTextChangedListener = afterTextChangedListener2;
    }

    public final void setDeleteEmptyListener(DeleteEmptyListener deleteEmptyListener2) {
        this.deleteEmptyListener = deleteEmptyListener2;
    }

    public final void setErrorMessageListener(ErrorMessageListener errorMessageListener2) {
        this.errorMessageListener = errorMessageListener2;
    }

    public final void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public final void setErrorColor(int i) {
        this.externalErrorColor = Integer.valueOf(i);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        Intrinsics.checkNotNullParameter(accessibilityNodeInfo, "info");
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setContentInvalid(this.shouldShowError);
        String accessibilityText2 = getAccessibilityText();
        if (accessibilityText2 != null) {
            accessibilityNodeInfo.setText(accessibilityText2);
        }
        String str = this.errorMessage;
        if (!getShouldShowError()) {
            str = null;
        }
        accessibilityNodeInfo.setError(str);
    }

    private final void determineDefaultErrorColor() {
        int i;
        Context context = getContext();
        if (StripeColorUtils.Companion.isColorDark(this.defaultColorStateList.getDefaultColor())) {
            i = com.stripe.android.R.color.stripe_error_text_light_theme;
        } else {
            i = com.stripe.android.R.color.stripe_error_text_dark_theme;
        }
        this.defaultErrorColor = ContextCompat.getColor(context, i);
    }

    private final void listenForTextChanges() {
        addTextChangedListener(new StripeEditText$listenForTextChanges$$inlined$doAfterTextChanged$1(this));
    }

    private final void listenForDeleteEmpty() {
        setOnKeyListener(new View.OnKeyListener() {
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                return StripeEditText.m4689listenForDeleteEmpty$lambda6(StripeEditText.this, view, i, keyEvent);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: listenForDeleteEmpty$lambda-6  reason: not valid java name */
    public static final boolean m4689listenForDeleteEmpty$lambda6(StripeEditText stripeEditText, View view, int i, KeyEvent keyEvent) {
        DeleteEmptyListener deleteEmptyListener2;
        Intrinsics.checkNotNullParameter(stripeEditText, "this$0");
        Intrinsics.checkNotNullExpressionValue(keyEvent, "event");
        boolean isDeleteKey = stripeEditText.isDeleteKey(i, keyEvent);
        stripeEditText.isLastKeyDelete = isDeleteKey;
        if (!isDeleteKey || stripeEditText.length() != 0 || (deleteEmptyListener2 = stripeEditText.deleteEmptyListener) == null) {
            return false;
        }
        deleteEmptyListener2.onDeleteEmpty();
        return false;
    }

    private final boolean isDeleteKey(int i, KeyEvent keyEvent) {
        return i == 67 && keyEvent.getAction() == 0;
    }

    public Parcelable onSaveInstanceState() {
        return new StripeEditTextState(super.onSaveInstanceState(), this.errorMessage, this.shouldShowError);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        Objects.requireNonNull(parcelable, "null cannot be cast to non-null type com.stripe.android.view.StripeEditText.StripeEditTextState");
        StripeEditTextState stripeEditTextState = (StripeEditTextState) parcelable;
        super.onRestoreInstanceState(stripeEditTextState.getSuperState());
        setErrorMessage$payments_core_release(stripeEditTextState.getErrorMessage());
        setShouldShowError(stripeEditTextState.getShouldShowError());
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/stripe/android/view/StripeEditText$SoftDeleteInputConnection;", "Landroid/view/inputmethod/InputConnectionWrapper;", "target", "Landroid/view/inputmethod/InputConnection;", "mutable", "", "deleteEmptyListener", "Lcom/stripe/android/view/StripeEditText$DeleteEmptyListener;", "(Landroid/view/inputmethod/InputConnection;ZLcom/stripe/android/view/StripeEditText$DeleteEmptyListener;)V", "deleteSurroundingText", "beforeLength", "", "afterLength", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StripeEditText.kt */
    private static final class SoftDeleteInputConnection extends InputConnectionWrapper {
        private final DeleteEmptyListener deleteEmptyListener;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SoftDeleteInputConnection(InputConnection inputConnection, boolean z, DeleteEmptyListener deleteEmptyListener2) {
            super(inputConnection, z);
            Intrinsics.checkNotNullParameter(inputConnection, "target");
            this.deleteEmptyListener = deleteEmptyListener2;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0013, code lost:
            if ((r2.length() == 0) == true) goto L_0x0015;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean deleteSurroundingText(int r4, int r5) {
            /*
                r3 = this;
                r0 = 1
                r1 = 0
                java.lang.CharSequence r2 = r3.getTextBeforeCursor(r0, r1)
                if (r2 != 0) goto L_0x000a
            L_0x0008:
                r0 = 0
                goto L_0x0015
            L_0x000a:
                int r2 = r2.length()
                if (r2 != 0) goto L_0x0012
                r2 = 1
                goto L_0x0013
            L_0x0012:
                r2 = 0
            L_0x0013:
                if (r2 != r0) goto L_0x0008
            L_0x0015:
                if (r0 == 0) goto L_0x001f
                com.stripe.android.view.StripeEditText$DeleteEmptyListener r0 = r3.deleteEmptyListener
                if (r0 != 0) goto L_0x001c
                goto L_0x001f
            L_0x001c:
                r0.onDeleteEmpty()
            L_0x001f:
                boolean r4 = super.deleteSurroundingText(r4, r5)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.view.StripeEditText.SoftDeleteInputConnection.deleteSurroundingText(int, int):boolean");
        }
    }

    public final void setOnFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        super.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                StripeEditText.m4690setOnFocusChangeListener$lambda9(StripeEditText.this, view, z);
            }
        });
        this.externalFocusChangeListener = onFocusChangeListener;
    }

    /* access modifiers changed from: private */
    /* renamed from: setOnFocusChangeListener$lambda-9  reason: not valid java name */
    public static final void m4690setOnFocusChangeListener$lambda9(StripeEditText stripeEditText, View view, boolean z) {
        Intrinsics.checkNotNullParameter(stripeEditText, "this$0");
        for (View.OnFocusChangeListener onFocusChange : stripeEditText.internalFocusChangeListeners) {
            onFocusChange.onFocusChange(view, z);
        }
        View.OnFocusChangeListener onFocusChangeListener = stripeEditText.externalFocusChangeListener;
        if (onFocusChangeListener != null) {
            onFocusChangeListener.onFocusChange(view, z);
        }
    }

    public View.OnFocusChangeListener getOnFocusChangeListener() {
        return this.externalFocusChangeListener;
    }

    public final View.OnFocusChangeListener getParentOnFocusChangeListener() {
        return super.getOnFocusChangeListener();
    }

    public void addTextChangedListener(TextWatcher textWatcher) {
        List<TextWatcher> list;
        super.addTextChangedListener(textWatcher);
        if (textWatcher != null && (list = this.textWatchers) != null) {
            list.add(textWatcher);
        }
    }

    public void removeTextChangedListener(TextWatcher textWatcher) {
        List<TextWatcher> list;
        super.removeTextChangedListener(textWatcher);
        if (textWatcher != null && (list = this.textWatchers) != null) {
            list.remove(textWatcher);
        }
    }

    public final void setTextSilent$payments_core_release(CharSequence charSequence) {
        List<TextWatcher> list = this.textWatchers;
        if (list != null) {
            for (TextWatcher removeTextChangedListener : list) {
                super.removeTextChangedListener(removeTextChangedListener);
            }
        }
        setText(charSequence);
        List<TextWatcher> list2 = this.textWatchers;
        if (list2 != null) {
            for (TextWatcher addTextChangedListener : list2) {
                super.addTextChangedListener(addTextChangedListener);
            }
        }
    }

    public final void setNumberOnlyInputType() {
        Typeface typeface = getTypeface();
        setInputType(18);
        setTypeface(typeface);
        setTransformationMethod(HideReturnsTransformationMethod.getInstance());
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0013HÖ\u0001R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/stripe/android/view/StripeEditText$StripeEditTextState;", "Landroid/os/Parcelable;", "superState", "errorMessage", "", "shouldShowError", "", "(Landroid/os/Parcelable;Ljava/lang/String;Z)V", "getErrorMessage", "()Ljava/lang/String;", "getShouldShowError", "()Z", "getSuperState", "()Landroid/os/Parcelable;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StripeEditText.kt */
    public static final class StripeEditTextState implements Parcelable {
        public static final Parcelable.Creator<StripeEditTextState> CREATOR = new Creator();
        private final String errorMessage;
        private final boolean shouldShowError;
        private final Parcelable superState;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: StripeEditText.kt */
        public static final class Creator implements Parcelable.Creator<StripeEditTextState> {
            public final StripeEditTextState createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new StripeEditTextState(parcel.readParcelable(StripeEditTextState.class.getClassLoader()), parcel.readString(), parcel.readInt() != 0);
            }

            public final StripeEditTextState[] newArray(int i) {
                return new StripeEditTextState[i];
            }
        }

        public static /* synthetic */ StripeEditTextState copy$default(StripeEditTextState stripeEditTextState, Parcelable parcelable, String str, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                parcelable = stripeEditTextState.superState;
            }
            if ((i & 2) != 0) {
                str = stripeEditTextState.errorMessage;
            }
            if ((i & 4) != 0) {
                z = stripeEditTextState.shouldShowError;
            }
            return stripeEditTextState.copy(parcelable, str, z);
        }

        public final Parcelable component1() {
            return this.superState;
        }

        public final String component2() {
            return this.errorMessage;
        }

        public final boolean component3() {
            return this.shouldShowError;
        }

        public final StripeEditTextState copy(Parcelable parcelable, String str, boolean z) {
            return new StripeEditTextState(parcelable, str, z);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof StripeEditTextState)) {
                return false;
            }
            StripeEditTextState stripeEditTextState = (StripeEditTextState) obj;
            return Intrinsics.areEqual((Object) this.superState, (Object) stripeEditTextState.superState) && Intrinsics.areEqual((Object) this.errorMessage, (Object) stripeEditTextState.errorMessage) && this.shouldShowError == stripeEditTextState.shouldShowError;
        }

        public int hashCode() {
            Parcelable parcelable = this.superState;
            int i = 0;
            int hashCode = (parcelable == null ? 0 : parcelable.hashCode()) * 31;
            String str = this.errorMessage;
            if (str != null) {
                i = str.hashCode();
            }
            int i2 = (hashCode + i) * 31;
            boolean z = this.shouldShowError;
            if (z) {
                z = true;
            }
            return i2 + (z ? 1 : 0);
        }

        public String toString() {
            return "StripeEditTextState(superState=" + this.superState + ", errorMessage=" + this.errorMessage + ", shouldShowError=" + this.shouldShowError + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeParcelable(this.superState, i);
            parcel.writeString(this.errorMessage);
            parcel.writeInt(this.shouldShowError ? 1 : 0);
        }

        public StripeEditTextState(Parcelable parcelable, String str, boolean z) {
            this.superState = parcelable;
            this.errorMessage = str;
            this.shouldShowError = z;
        }

        public final Parcelable getSuperState() {
            return this.superState;
        }

        public final String getErrorMessage() {
            return this.errorMessage;
        }

        public final boolean getShouldShowError() {
            return this.shouldShowError;
        }
    }
}
