package com.stripe.android.ui.core.elements;

import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.VisualTransformation;
import com.braintreepayments.api.internal.GraphQLConstants;
import com.stripe.android.ui.core.R;
import com.stripe.android.ui.core.elements.TextFieldStateConstants;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001+B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\tH\u0002J\u0010\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\tH\u0016J\u0010\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\tH\u0016J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\tH\u0016J\u0010\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020\tH\u0016R\u001f\u0010\u0003\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001f\u0010\f\u001a\u00020\rX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000e\u0010\u0006R\u0016\u0010\u000f\u001a\u00020\u00108\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0006R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0018X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006,"}, d2 = {"Lcom/stripe/android/ui/core/elements/EmailConfig;", "Lcom/stripe/android/ui/core/elements/TextFieldConfig;", "()V", "capitalization", "Landroidx/compose/ui/text/input/KeyboardCapitalization;", "getCapitalization-IUNYP9k", "()I", "I", "debugLabel", "", "getDebugLabel", "()Ljava/lang/String;", "keyboard", "Landroidx/compose/ui/text/input/KeyboardType;", "getKeyboard-PjHm6EE", "label", "", "getLabel", "loading", "Lkotlinx/coroutines/flow/StateFlow;", "", "getLoading", "()Lkotlinx/coroutines/flow/StateFlow;", "trailingIcon", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/stripe/android/ui/core/elements/TextFieldIcon;", "getTrailingIcon", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "getVisualTransformation", "()Landroidx/compose/ui/text/input/VisualTransformation;", "containsNameAndDomain", "str", "convertFromRaw", "rawValue", "convertToRaw", "displayName", "determineState", "Lcom/stripe/android/ui/core/elements/TextFieldState;", "input", "filter", "userTyped", "Companion", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EmailConfig.kt */
public final class EmailConfig implements TextFieldConfig {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Pattern PATTERN;
    private final int capitalization = KeyboardCapitalization.Companion.m3665getNoneIUNYP9k();
    private final String debugLabel = "email";
    private final int keyboard = KeyboardType.Companion.m3676getEmailPjHm6EE();
    private final int label = R.string.email;
    private final StateFlow<Boolean> loading = StateFlowKt.MutableStateFlow(false);
    private final MutableStateFlow<TextFieldIcon> trailingIcon = StateFlowKt.MutableStateFlow(null);
    private final VisualTransformation visualTransformation;

    public String convertFromRaw(String str) {
        Intrinsics.checkNotNullParameter(str, "rawValue");
        return str;
    }

    public String convertToRaw(String str) {
        Intrinsics.checkNotNullParameter(str, "displayName");
        return str;
    }

    public String filter(String str) {
        Intrinsics.checkNotNullParameter(str, "userTyped");
        return str;
    }

    /* renamed from: getCapitalization-IUNYP9k  reason: not valid java name */
    public int m4579getCapitalizationIUNYP9k() {
        return this.capitalization;
    }

    public String getDebugLabel() {
        return this.debugLabel;
    }

    public int getLabel() {
        return this.label;
    }

    /* renamed from: getKeyboard-PjHm6EE  reason: not valid java name */
    public int m4580getKeyboardPjHm6EE() {
        return this.keyboard;
    }

    public VisualTransformation getVisualTransformation() {
        return this.visualTransformation;
    }

    public MutableStateFlow<TextFieldIcon> getTrailingIcon() {
        return this.trailingIcon;
    }

    public StateFlow<Boolean> getLoading() {
        return this.loading;
    }

    public TextFieldState determineState(String str) {
        Intrinsics.checkNotNullParameter(str, GraphQLConstants.Keys.INPUT);
        CharSequence charSequence = str;
        if (charSequence.length() == 0) {
            return TextFieldStateConstants.Error.Blank.INSTANCE;
        }
        if (PATTERN.matcher(charSequence).matches()) {
            return TextFieldStateConstants.Valid.Limitless.INSTANCE;
        }
        if (containsNameAndDomain(str)) {
            return new TextFieldStateConstants.Error.Invalid(R.string.email_is_invalid, (Object[]) null, 2, (DefaultConstructorMarker) null);
        }
        return new TextFieldStateConstants.Error.Incomplete(R.string.email_is_invalid);
    }

    private final boolean containsNameAndDomain(String str) {
        CharSequence charSequence = str;
        return StringsKt.contains$default(charSequence, (CharSequence) "@", false, 2, (Object) null) && new Regex(".*@.*\\..+").matches(charSequence);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/ui/core/elements/EmailConfig$Companion;", "", "()V", "PATTERN", "Ljava/util/regex/Pattern;", "getPATTERN", "()Ljava/util/regex/Pattern;", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: EmailConfig.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Pattern getPATTERN() {
            return EmailConfig.PATTERN;
        }
    }

    static {
        Pattern compile = Pattern.compile("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+");
        Intrinsics.checkNotNullExpressionValue(compile, "compile(\n            \"[a…           \")+\"\n        )");
        PATTERN = compile;
    }
}
