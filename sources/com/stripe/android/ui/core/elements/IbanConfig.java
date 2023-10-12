package com.stripe.android.ui.core.elements;

import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.VisualTransformation;
import com.braintreepayments.api.internal.GraphQLConstants;
import com.stripe.android.ui.core.R;
import com.stripe.android.ui.core.elements.TextFieldStateConstants;
import java.math.BigInteger;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.CharRange;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001+B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\tH\u0016J\u0010\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\tH\u0016J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\tH\u0016J\u0010\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\tH\u0016J\u0010\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\tH\u0002R\u001f\u0010\u0003\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001f\u0010\f\u001a\u00020\rX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000e\u0010\u0006R\u0016\u0010\u000f\u001a\u00020\u00108\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0006R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0018X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006,"}, d2 = {"Lcom/stripe/android/ui/core/elements/IbanConfig;", "Lcom/stripe/android/ui/core/elements/TextFieldConfig;", "()V", "capitalization", "Landroidx/compose/ui/text/input/KeyboardCapitalization;", "getCapitalization-IUNYP9k", "()I", "I", "debugLabel", "", "getDebugLabel", "()Ljava/lang/String;", "keyboard", "Landroidx/compose/ui/text/input/KeyboardType;", "getKeyboard-PjHm6EE", "label", "", "getLabel", "loading", "Lkotlinx/coroutines/flow/StateFlow;", "", "getLoading", "()Lkotlinx/coroutines/flow/StateFlow;", "trailingIcon", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/stripe/android/ui/core/elements/TextFieldIcon;", "getTrailingIcon", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "getVisualTransformation", "()Landroidx/compose/ui/text/input/VisualTransformation;", "convertFromRaw", "rawValue", "convertToRaw", "displayName", "determineState", "Lcom/stripe/android/ui/core/elements/TextFieldState;", "input", "filter", "userTyped", "isIbanValid", "iban", "Companion", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IbanConfig.kt */
public final class IbanConfig implements TextFieldConfig {
    public static final int $stable = 8;
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    public static final int MAX_LENGTH = 34;
    @Deprecated
    public static final int MIN_LENGTH = 8;
    /* access modifiers changed from: private */
    @Deprecated
    public static final List<Character> VALID_INPUT_RANGES = CollectionsKt.plus(CollectionsKt.plus(new CharRange('0', '9'), new CharRange('a', 'z')), new CharRange('A', Matrix.MATRIX_TYPE_ZERO));
    private final int capitalization = KeyboardCapitalization.Companion.m3664getCharactersIUNYP9k();
    private final String debugLabel = "iban";
    private final int keyboard = KeyboardType.Companion.m3675getAsciiPjHm6EE();
    private final int label = R.string.iban;
    private final StateFlow<Boolean> loading = StateFlowKt.MutableStateFlow(false);
    private final MutableStateFlow<TextFieldIcon> trailingIcon = StateFlowKt.MutableStateFlow(new TextFieldIcon(R.drawable.stripe_ic_bank_generic, (Integer) null, true, 2, (DefaultConstructorMarker) null));
    private final VisualTransformation visualTransformation = IbanConfig$visualTransformation$1.INSTANCE;

    public String convertFromRaw(String str) {
        Intrinsics.checkNotNullParameter(str, "rawValue");
        return str;
    }

    public String convertToRaw(String str) {
        Intrinsics.checkNotNullParameter(str, "displayName");
        return str;
    }

    /* renamed from: getCapitalization-IUNYP9k  reason: not valid java name */
    public int m4585getCapitalizationIUNYP9k() {
        return this.capitalization;
    }

    public String getDebugLabel() {
        return this.debugLabel;
    }

    public int getLabel() {
        return this.label;
    }

    /* renamed from: getKeyboard-PjHm6EE  reason: not valid java name */
    public int m4586getKeyboardPjHm6EE() {
        return this.keyboard;
    }

    public MutableStateFlow<TextFieldIcon> getTrailingIcon() {
        return this.trailingIcon;
    }

    public StateFlow<Boolean> getLoading() {
        return this.loading;
    }

    public VisualTransformation getVisualTransformation() {
        return this.visualTransformation;
    }

    public TextFieldState determineState(String str) {
        boolean z;
        TextFieldStateConstants.Valid valid;
        Intrinsics.checkNotNullParameter(str, GraphQLConstants.Keys.INPUT);
        if (StringsKt.isBlank(str)) {
            return TextFieldStateConstants.Error.Blank.INSTANCE;
        }
        String upperCase = StringsKt.take(str, 2).toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        CharSequence charSequence = upperCase;
        int i = 0;
        while (true) {
            if (i >= charSequence.length()) {
                z = false;
                break;
            }
            char charAt = charSequence.charAt(i);
            i++;
            if (Character.isDigit(charAt)) {
                z = true;
                break;
            }
        }
        if (z) {
            return new TextFieldStateConstants.Error.Invalid(R.string.iban_invalid_start, (Object[]) null, 2, (DefaultConstructorMarker) null);
        }
        if (upperCase.length() < 2) {
            return new TextFieldStateConstants.Error.Incomplete(R.string.iban_incomplete);
        }
        String[] iSOCountries = Locale.getISOCountries();
        Intrinsics.checkNotNullExpressionValue(iSOCountries, "getISOCountries()");
        if (!ArraysKt.contains((T[]) (Object[]) iSOCountries, upperCase)) {
            return new TextFieldStateConstants.Error.Invalid(R.string.iban_invalid_country, new String[]{upperCase});
        } else if (str.length() < 8) {
            return new TextFieldStateConstants.Error.Incomplete(R.string.iban_incomplete);
        } else {
            if (!isIbanValid(str)) {
                return new TextFieldStateConstants.Error.Incomplete(R.string.iban_invalid);
            }
            if (str.length() == 34) {
                valid = TextFieldStateConstants.Valid.Full.INSTANCE;
            } else {
                valid = TextFieldStateConstants.Valid.Limitless.INSTANCE;
            }
            return valid;
        }
    }

    private final boolean isIbanValid(String str) {
        String upperCase = Intrinsics.stringPlus(StringsKt.takeLast(str, str.length() - 4), StringsKt.take(str, 4)).toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        return new BigInteger(new Regex("[A-Z]").replace((CharSequence) upperCase, (Function1<? super MatchResult, ? extends CharSequence>) IbanConfig$isIbanValid$1.INSTANCE)).mod(new BigInteger("97")).equals(BigInteger.ONE);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\f\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/ui/core/elements/IbanConfig$Companion;", "", "()V", "MAX_LENGTH", "", "MIN_LENGTH", "VALID_INPUT_RANGES", "", "", "getVALID_INPUT_RANGES", "()Ljava/util/List;", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IbanConfig.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<Character> getVALID_INPUT_RANGES() {
            return IbanConfig.VALID_INPUT_RANGES;
        }
    }

    public String filter(String str) {
        Intrinsics.checkNotNullParameter(str, "userTyped");
        CharSequence charSequence = str;
        Appendable sb = new StringBuilder();
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            char charAt = charSequence.charAt(i);
            if (VALID_INPUT_RANGES.contains(Character.valueOf(charAt))) {
                sb.append(charAt);
            }
            i = i2;
        }
        String sb2 = ((StringBuilder) sb).toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "filterTo(StringBuilder(), predicate).toString()");
        String upperCase = StringsKt.take(sb2, 34).toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        return upperCase;
    }
}
