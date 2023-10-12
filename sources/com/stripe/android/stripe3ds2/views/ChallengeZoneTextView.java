package com.stripe.android.stripe3ds2.views;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.stripe.android.stripe3ds2.databinding.StripeChallengeZoneTextViewBinding;
import com.stripe.android.stripe3ds2.init.ui.TextBoxCustomization;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0013J\u0010\u0010\u0019\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010\u001c\u001a\u00020\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\u0013R\u0014\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001e"}, d2 = {"Lcom/stripe/android/stripe3ds2/views/ChallengeZoneTextView;", "Landroid/widget/LinearLayout;", "Lcom/stripe/android/stripe3ds2/views/FormField;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "infoLabel", "Lcom/google/android/material/textfield/TextInputLayout;", "getInfoLabel$3ds2sdk_release", "()Lcom/google/android/material/textfield/TextInputLayout;", "textEntryView", "Lcom/google/android/material/textfield/TextInputEditText;", "getTextEntryView$3ds2sdk_release", "()Lcom/google/android/material/textfield/TextInputEditText;", "userEntry", "", "getUserEntry", "()Ljava/lang/String;", "setText", "", "text", "setTextBoxCustomization", "textBoxCustomization", "Lcom/stripe/android/stripe3ds2/init/ui/TextBoxCustomization;", "setTextEntryLabel", "label", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChallengeZoneTextView.kt */
public final class ChallengeZoneTextView extends LinearLayout implements FormField {
    private final TextInputLayout infoLabel;
    private final TextInputEditText textEntryView;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ChallengeZoneTextView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ChallengeZoneTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChallengeZoneTextView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChallengeZoneTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        StripeChallengeZoneTextViewBinding inflate = StripeChallengeZoneTextViewBinding.inflate(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(\n            Lay…           true\n        )");
        TextInputLayout textInputLayout = inflate.label;
        Intrinsics.checkNotNullExpressionValue(textInputLayout, "viewBinding.label");
        this.infoLabel = textInputLayout;
        TextInputEditText textInputEditText = inflate.textEntry;
        Intrinsics.checkNotNullExpressionValue(textInputEditText, "viewBinding.textEntry");
        this.textEntryView = textInputEditText;
    }

    public final TextInputLayout getInfoLabel$3ds2sdk_release() {
        return this.infoLabel;
    }

    public final TextInputEditText getTextEntryView$3ds2sdk_release() {
        return this.textEntryView;
    }

    public String getUserEntry() {
        Editable text = this.textEntryView.getText();
        String obj = text == null ? null : text.toString();
        return obj == null ? "" : obj;
    }

    public final void setTextEntryLabel(String str) {
        this.infoLabel.setHint((CharSequence) str);
    }

    public final void setText(String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.textEntryView.setText(str);
    }

    public final void setTextBoxCustomization(TextBoxCustomization textBoxCustomization) {
        if (textBoxCustomization != null) {
            String textColor = textBoxCustomization.getTextColor();
            if (textColor != null) {
                getTextEntryView$3ds2sdk_release().setTextColor(Color.parseColor(textColor));
            }
            Integer valueOf = Integer.valueOf(textBoxCustomization.getTextFontSize());
            if (!(valueOf.intValue() > 0)) {
                valueOf = null;
            }
            if (valueOf != null) {
                getTextEntryView$3ds2sdk_release().setTextSize(2, (float) valueOf.intValue());
            }
            if (textBoxCustomization.getCornerRadius() >= 0) {
                float cornerRadius = (float) textBoxCustomization.getCornerRadius();
                this.infoLabel.setBoxCornerRadii(cornerRadius, cornerRadius, cornerRadius, cornerRadius);
            }
            String borderColor = textBoxCustomization.getBorderColor();
            if (borderColor != null) {
                getInfoLabel$3ds2sdk_release().setBoxBackgroundMode(2);
                getInfoLabel$3ds2sdk_release().setBoxStrokeColor(Color.parseColor(borderColor));
            }
            String hintTextColor = textBoxCustomization.getHintTextColor();
            if (hintTextColor != null) {
                getInfoLabel$3ds2sdk_release().setDefaultHintTextColor(ColorStateList.valueOf(Color.parseColor(hintTextColor)));
            }
        }
    }
}
