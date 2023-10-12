package com.stripe.android.ui.core.elements;

import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.VisualTransformation;
import com.braintreepayments.api.internal.GraphQLConstants;
import com.stripe.android.ui.core.R;
import com.stripe.android.ui.core.elements.TextFieldStateConstants;
import com.stripe.android.view.BecsDebitBanks;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.CharRange;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001*B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\fH\u0016J\u0010\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\fH\u0016J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\fH\u0016J\u0010\u0010(\u001a\u00020\f2\u0006\u0010)\u001a\u00020\fH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0006\u001a\u00020\u0007X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\fXD¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001f\u0010\u000f\u001a\u00020\u0010X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u0011\u0010\tR\u0016\u0010\u0012\u001a\u00020\u00138\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\tR\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 \u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006+"}, d2 = {"Lcom/stripe/android/ui/core/elements/BsbConfig;", "Lcom/stripe/android/ui/core/elements/TextFieldConfig;", "banks", "", "Lcom/stripe/android/view/BecsDebitBanks$Bank;", "(Ljava/util/List;)V", "capitalization", "Landroidx/compose/ui/text/input/KeyboardCapitalization;", "getCapitalization-IUNYP9k", "()I", "I", "debugLabel", "", "getDebugLabel", "()Ljava/lang/String;", "keyboard", "Landroidx/compose/ui/text/input/KeyboardType;", "getKeyboard-PjHm6EE", "label", "", "getLabel", "loading", "Lkotlinx/coroutines/flow/StateFlow;", "", "getLoading", "()Lkotlinx/coroutines/flow/StateFlow;", "trailingIcon", "Lcom/stripe/android/ui/core/elements/TextFieldIcon;", "getTrailingIcon", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "getVisualTransformation", "()Landroidx/compose/ui/text/input/VisualTransformation;", "convertFromRaw", "rawValue", "convertToRaw", "displayName", "determineState", "Lcom/stripe/android/ui/core/elements/TextFieldState;", "input", "filter", "userTyped", "Companion", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BsbConfig.kt */
public final class BsbConfig implements TextFieldConfig {
    public static final int $stable = 8;
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    public static final int LENGTH = 6;
    /* access modifiers changed from: private */
    @Deprecated
    public static final CharRange VALID_INPUT_RANGES = new CharRange('0', '9');
    private final List<BecsDebitBanks.Bank> banks;
    private final int capitalization = KeyboardCapitalization.Companion.m3665getNoneIUNYP9k();
    private final String debugLabel = "bsb";
    private final int keyboard = KeyboardType.Companion.m3677getNumberPjHm6EE();
    private final int label = R.string.becs_widget_bsb;
    private final StateFlow<Boolean> loading = StateFlowKt.MutableStateFlow(false);
    private final StateFlow<TextFieldIcon> trailingIcon = StateFlowKt.MutableStateFlow(null);
    private final VisualTransformation visualTransformation = BsbConfig$visualTransformation$1.INSTANCE;

    public String convertFromRaw(String str) {
        Intrinsics.checkNotNullParameter(str, "rawValue");
        return str;
    }

    public String convertToRaw(String str) {
        Intrinsics.checkNotNullParameter(str, "displayName");
        return str;
    }

    public BsbConfig(List<BecsDebitBanks.Bank> list) {
        Intrinsics.checkNotNullParameter(list, "banks");
        this.banks = list;
    }

    /* renamed from: getCapitalization-IUNYP9k  reason: not valid java name */
    public int m4553getCapitalizationIUNYP9k() {
        return this.capitalization;
    }

    public String getDebugLabel() {
        return this.debugLabel;
    }

    public StateFlow<TextFieldIcon> getTrailingIcon() {
        return this.trailingIcon;
    }

    public StateFlow<Boolean> getLoading() {
        return this.loading;
    }

    public int getLabel() {
        return this.label;
    }

    /* renamed from: getKeyboard-PjHm6EE  reason: not valid java name */
    public int m4554getKeyboardPjHm6EE() {
        return this.keyboard;
    }

    public VisualTransformation getVisualTransformation() {
        return this.visualTransformation;
    }

    public TextFieldState determineState(String str) {
        Object obj;
        Intrinsics.checkNotNullParameter(str, GraphQLConstants.Keys.INPUT);
        if (StringsKt.isBlank(str)) {
            return TextFieldStateConstants.Error.Blank.INSTANCE;
        }
        if (str.length() < 6) {
            return new TextFieldStateConstants.Error.Incomplete(R.string.becs_widget_bsb_incomplete);
        }
        Iterator it = this.banks.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (StringsKt.startsWith$default(str, ((BecsDebitBanks.Bank) obj).getPrefix(), false, 2, (Object) null)) {
                break;
            }
        }
        if (((BecsDebitBanks.Bank) obj) == null || str.length() > 6) {
            return new TextFieldStateConstants.Error.Invalid(R.string.becs_widget_bsb_invalid, (Object[]) null, 2, (DefaultConstructorMarker) null);
        }
        return TextFieldStateConstants.Valid.Full.INSTANCE;
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stripe/android/ui/core/elements/BsbConfig$Companion;", "", "()V", "LENGTH", "", "VALID_INPUT_RANGES", "Lkotlin/ranges/CharRange;", "getVALID_INPUT_RANGES", "()Lkotlin/ranges/CharRange;", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BsbConfig.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CharRange getVALID_INPUT_RANGES() {
            return BsbConfig.VALID_INPUT_RANGES;
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
            if (VALID_INPUT_RANGES.contains(charAt)) {
                sb.append(charAt);
            }
            i = i2;
        }
        String sb2 = ((StringBuilder) sb).toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "filterTo(StringBuilder(), predicate).toString()");
        return StringsKt.take(sb2, 6);
    }
}
