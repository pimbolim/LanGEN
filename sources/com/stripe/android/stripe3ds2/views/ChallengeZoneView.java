package com.stripe.android.stripe3ds2.views;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.core.widget.CompoundButtonCompat;
import com.stripe.android.stripe3ds2.R;
import com.stripe.android.stripe3ds2.databinding.StripeChallengeZoneViewBinding;
import com.stripe.android.stripe3ds2.init.ui.ButtonCustomization;
import com.stripe.android.stripe3ds2.init.ui.LabelCustomization;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010+\u001a\u00020,2\u0006\u0010\t\u001a\u00020-J\u001c\u0010.\u001a\u00020,2\b\u0010/\u001a\u0004\u0018\u0001002\n\b\u0002\u00101\u001a\u0004\u0018\u000102J\u001c\u00103\u001a\u00020,2\b\u00104\u001a\u0004\u0018\u0001002\n\b\u0002\u00101\u001a\u0004\u0018\u000102J\u0010\u00105\u001a\u00020,2\b\b\u0001\u00106\u001a\u00020\u0007J\u0010\u00107\u001a\u00020,2\b\u00108\u001a\u0004\u0018\u000109J\u001c\u0010:\u001a\u00020,2\b\u0010;\u001a\u0004\u0018\u0001002\n\b\u0002\u0010<\u001a\u0004\u0018\u00010=J\u001c\u0010>\u001a\u00020,2\b\u0010?\u001a\u0004\u0018\u0001002\n\b\u0002\u0010<\u001a\u0004\u0018\u00010=J\u0010\u0010@\u001a\u00020,2\b\u00108\u001a\u0004\u0018\u000109J(\u0010A\u001a\u00020,2\b\u0010%\u001a\u0004\u0018\u0001002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\n\b\u0002\u0010<\u001a\u0004\u0018\u00010=R\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020 X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020\u001cX\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001eR\u0014\u0010%\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0014R\u0014\u0010'\u001a\u00020(8@X\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u0006B"}, d2 = {"Lcom/stripe/android/stripe3ds2/views/ChallengeZoneView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "challengeEntryView", "Landroid/widget/FrameLayout;", "getChallengeEntryView$3ds2sdk_release", "()Landroid/widget/FrameLayout;", "infoHeader", "Lcom/stripe/android/stripe3ds2/views/ThreeDS2HeaderTextView;", "getInfoHeader$3ds2sdk_release", "()Lcom/stripe/android/stripe3ds2/views/ThreeDS2HeaderTextView;", "infoTextView", "Lcom/stripe/android/stripe3ds2/views/ThreeDS2TextView;", "getInfoTextView$3ds2sdk_release", "()Lcom/stripe/android/stripe3ds2/views/ThreeDS2TextView;", "resendButton", "Lcom/stripe/android/stripe3ds2/views/ThreeDS2Button;", "getResendButton$3ds2sdk_release", "()Lcom/stripe/android/stripe3ds2/views/ThreeDS2Button;", "submitButton", "getSubmitButton$3ds2sdk_release", "whitelistNoRadioButton", "Landroid/widget/RadioButton;", "getWhitelistNoRadioButton$3ds2sdk_release", "()Landroid/widget/RadioButton;", "whitelistRadioGroup", "Landroid/widget/RadioGroup;", "getWhitelistRadioGroup$3ds2sdk_release", "()Landroid/widget/RadioGroup;", "whitelistYesRadioButton", "getWhitelistYesRadioButton$3ds2sdk_release", "whitelistingLabel", "getWhitelistingLabel$3ds2sdk_release", "whitelistingSelection", "", "getWhitelistingSelection$3ds2sdk_release", "()Z", "setChallengeEntryView", "", "Landroid/view/View;", "setInfoHeaderText", "headerText", "", "labelCustomization", "Lcom/stripe/android/stripe3ds2/init/ui/LabelCustomization;", "setInfoText", "infoText", "setInfoTextIndicator", "indicatorResId", "setResendButtonClickListener", "listener", "Landroid/view/View$OnClickListener;", "setResendButtonLabel", "resendButtonLabel", "buttonCustomization", "Lcom/stripe/android/stripe3ds2/init/ui/ButtonCustomization;", "setSubmitButton", "submitButtonLabel", "setSubmitButtonClickListener", "setWhitelistingLabel", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChallengeZoneView.kt */
public final class ChallengeZoneView extends LinearLayout {
    private final FrameLayout challengeEntryView;
    private final ThreeDS2HeaderTextView infoHeader;
    private final ThreeDS2TextView infoTextView;
    private final ThreeDS2Button resendButton;
    private final ThreeDS2Button submitButton;
    private final RadioButton whitelistNoRadioButton;
    private final RadioGroup whitelistRadioGroup;
    private final RadioButton whitelistYesRadioButton;
    private final ThreeDS2TextView whitelistingLabel;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ChallengeZoneView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ChallengeZoneView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChallengeZoneView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChallengeZoneView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        StripeChallengeZoneViewBinding inflate = StripeChallengeZoneViewBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(\n            Lay…           this\n        )");
        ThreeDS2HeaderTextView threeDS2HeaderTextView = inflate.czvHeader;
        Intrinsics.checkNotNullExpressionValue(threeDS2HeaderTextView, "viewBinding.czvHeader");
        this.infoHeader = threeDS2HeaderTextView;
        ThreeDS2TextView threeDS2TextView = inflate.czvInfo;
        Intrinsics.checkNotNullExpressionValue(threeDS2TextView, "viewBinding.czvInfo");
        this.infoTextView = threeDS2TextView;
        ThreeDS2Button threeDS2Button = inflate.czvSubmitButton;
        Intrinsics.checkNotNullExpressionValue(threeDS2Button, "viewBinding.czvSubmitButton");
        this.submitButton = threeDS2Button;
        ThreeDS2Button threeDS2Button2 = inflate.czvResendButton;
        Intrinsics.checkNotNullExpressionValue(threeDS2Button2, "viewBinding.czvResendButton");
        this.resendButton = threeDS2Button2;
        ThreeDS2TextView threeDS2TextView2 = inflate.czvWhitelistingLabel;
        Intrinsics.checkNotNullExpressionValue(threeDS2TextView2, "viewBinding.czvWhitelistingLabel");
        this.whitelistingLabel = threeDS2TextView2;
        RadioGroup radioGroup = inflate.czvWhitelistRadioGroup;
        Intrinsics.checkNotNullExpressionValue(radioGroup, "viewBinding.czvWhitelistRadioGroup");
        this.whitelistRadioGroup = radioGroup;
        FrameLayout frameLayout = inflate.czvEntryView;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "viewBinding.czvEntryView");
        this.challengeEntryView = frameLayout;
        RadioButton radioButton = inflate.czvWhitelistYesButton;
        Intrinsics.checkNotNullExpressionValue(radioButton, "viewBinding.czvWhitelistYesButton");
        this.whitelistYesRadioButton = radioButton;
        RadioButton radioButton2 = inflate.czvWhitelistNoButton;
        Intrinsics.checkNotNullExpressionValue(radioButton2, "viewBinding.czvWhitelistNoButton");
        this.whitelistNoRadioButton = radioButton2;
    }

    public final ThreeDS2HeaderTextView getInfoHeader$3ds2sdk_release() {
        return this.infoHeader;
    }

    public final ThreeDS2TextView getInfoTextView$3ds2sdk_release() {
        return this.infoTextView;
    }

    public final ThreeDS2Button getSubmitButton$3ds2sdk_release() {
        return this.submitButton;
    }

    public final ThreeDS2Button getResendButton$3ds2sdk_release() {
        return this.resendButton;
    }

    public final ThreeDS2TextView getWhitelistingLabel$3ds2sdk_release() {
        return this.whitelistingLabel;
    }

    public final RadioGroup getWhitelistRadioGroup$3ds2sdk_release() {
        return this.whitelistRadioGroup;
    }

    public final FrameLayout getChallengeEntryView$3ds2sdk_release() {
        return this.challengeEntryView;
    }

    public final RadioButton getWhitelistYesRadioButton$3ds2sdk_release() {
        return this.whitelistYesRadioButton;
    }

    public final RadioButton getWhitelistNoRadioButton$3ds2sdk_release() {
        return this.whitelistNoRadioButton;
    }

    public final boolean getWhitelistingSelection$3ds2sdk_release() {
        return this.whitelistRadioGroup.getCheckedRadioButtonId() == R.id.czv_whitelist_yes_button;
    }

    public static /* synthetic */ void setInfoHeaderText$default(ChallengeZoneView challengeZoneView, String str, LabelCustomization labelCustomization, int i, Object obj) {
        if ((i & 2) != 0) {
            labelCustomization = null;
        }
        challengeZoneView.setInfoHeaderText(str, labelCustomization);
    }

    public final void setInfoHeaderText(String str, LabelCustomization labelCustomization) {
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            this.infoHeader.setVisibility(8);
        } else {
            this.infoHeader.setText(str, labelCustomization);
        }
    }

    public static /* synthetic */ void setInfoText$default(ChallengeZoneView challengeZoneView, String str, LabelCustomization labelCustomization, int i, Object obj) {
        if ((i & 2) != 0) {
            labelCustomization = null;
        }
        challengeZoneView.setInfoText(str, labelCustomization);
    }

    public final void setInfoText(String str, LabelCustomization labelCustomization) {
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            this.infoTextView.setVisibility(8);
        } else {
            this.infoTextView.setText(str, labelCustomization);
        }
    }

    public final void setInfoTextIndicator(int i) {
        this.infoTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(i, 0, 0, 0);
    }

    public static /* synthetic */ void setSubmitButton$default(ChallengeZoneView challengeZoneView, String str, ButtonCustomization buttonCustomization, int i, Object obj) {
        if ((i & 2) != 0) {
            buttonCustomization = null;
        }
        challengeZoneView.setSubmitButton(str, buttonCustomization);
    }

    public final void setSubmitButton(String str, ButtonCustomization buttonCustomization) {
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            this.submitButton.setVisibility(8);
            return;
        }
        this.submitButton.setText(charSequence);
        this.submitButton.setButtonCustomization(buttonCustomization);
    }

    public final void setSubmitButtonClickListener(View.OnClickListener onClickListener) {
        this.submitButton.setOnClickListener(onClickListener);
    }

    public static /* synthetic */ void setResendButtonLabel$default(ChallengeZoneView challengeZoneView, String str, ButtonCustomization buttonCustomization, int i, Object obj) {
        if ((i & 2) != 0) {
            buttonCustomization = null;
        }
        challengeZoneView.setResendButtonLabel(str, buttonCustomization);
    }

    public final void setResendButtonLabel(String str, ButtonCustomization buttonCustomization) {
        CharSequence charSequence = str;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            this.resendButton.setVisibility(0);
            this.resendButton.setText(charSequence);
            this.resendButton.setButtonCustomization(buttonCustomization);
        }
    }

    public final void setResendButtonClickListener(View.OnClickListener onClickListener) {
        this.resendButton.setOnClickListener(onClickListener);
    }

    public static /* synthetic */ void setWhitelistingLabel$default(ChallengeZoneView challengeZoneView, String str, LabelCustomization labelCustomization, ButtonCustomization buttonCustomization, int i, Object obj) {
        if ((i & 2) != 0) {
            labelCustomization = null;
        }
        if ((i & 4) != 0) {
            buttonCustomization = null;
        }
        challengeZoneView.setWhitelistingLabel(str, labelCustomization, buttonCustomization);
    }

    public final void setWhitelistingLabel(String str, LabelCustomization labelCustomization, ButtonCustomization buttonCustomization) {
        CharSequence charSequence = str;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            this.whitelistingLabel.setText(str, labelCustomization);
            if (buttonCustomization != null) {
                Collection arrayList = new ArrayList();
                Iterator it = RangesKt.until(0, this.whitelistRadioGroup.getChildCount()).iterator();
                while (it.hasNext()) {
                    View childAt = getWhitelistRadioGroup$3ds2sdk_release().getChildAt(((IntIterator) it).nextInt());
                    RadioButton radioButton = childAt instanceof RadioButton ? (RadioButton) childAt : null;
                    if (radioButton != null) {
                        arrayList.add(radioButton);
                    }
                }
                for (RadioButton radioButton2 : (List) arrayList) {
                    CharSequence backgroundColor = buttonCustomization.getBackgroundColor();
                    if (!(backgroundColor == null || StringsKt.isBlank(backgroundColor))) {
                        CompoundButtonCompat.setButtonTintList(radioButton2, ColorStateList.valueOf(Color.parseColor(buttonCustomization.getBackgroundColor())));
                    }
                    CharSequence textColor = buttonCustomization.getTextColor();
                    if (!(textColor == null || StringsKt.isBlank(textColor))) {
                        radioButton2.setTextColor(Color.parseColor(buttonCustomization.getTextColor()));
                    }
                }
            }
            this.whitelistingLabel.setVisibility(0);
            this.whitelistRadioGroup.setVisibility(0);
        }
    }

    public final void setChallengeEntryView(View view) {
        Intrinsics.checkNotNullParameter(view, "challengeEntryView");
        this.challengeEntryView.addView(view);
    }
}
