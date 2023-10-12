package com.stripe.android.stripe3ds2.views;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import androidx.core.os.BundleKt;
import androidx.core.widget.CompoundButtonCompat;
import com.braintreepayments.api.models.PostalAddressParser;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.stripe.android.stripe3ds2.R;
import com.stripe.android.stripe3ds2.databinding.StripeChallengeZoneMultiSelectViewBinding;
import com.stripe.android.stripe3ds2.databinding.StripeChallengeZoneSingleSelectViewBinding;
import com.stripe.android.stripe3ds2.init.ui.ButtonCustomization;
import com.stripe.android.stripe3ds2.init.ui.LabelCustomization;
import com.stripe.android.stripe3ds2.transactions.ChallengeResponseData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 ;2\u00020\u00012\u00020\u0002:\u0001;B/\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ'\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020!2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020\nH\u0000¢\u0006\u0002\b-J\u0010\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0014J\b\u00102\u001a\u000201H\u0014J\u000e\u00103\u001a\u00020/2\u0006\u00104\u001a\u00020\bJ \u00105\u001a\u00020/2\u000e\u00106\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u00112\b\u0010*\u001a\u0004\u0018\u00010+J\u001a\u00107\u001a\u00020/2\b\u00108\u001a\u0004\u0018\u00010$2\b\u00109\u001a\u0004\u0018\u00010:R\u000e\u0010\f\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u00118F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u00118@X\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0014R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u00118F¢\u0006\u0006\u001a\u0004\b\"\u0010\u0014R\u0014\u0010#\u001a\u00020$8VX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006<"}, d2 = {"Lcom/stripe/android/stripe3ds2/views/ChallengeZoneSelectView;", "Landroid/widget/FrameLayout;", "Lcom/stripe/android/stripe3ds2/views/FormField;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "isSingleSelectMode", "", "(Landroid/content/Context;Landroid/util/AttributeSet;IZ)V", "buttonBottomMargin", "buttonLabelPadding", "buttonMinHeight", "buttonOffsetMargin", "checkBoxes", "", "Landroid/widget/CheckBox;", "getCheckBoxes", "()Ljava/util/List;", "infoLabel", "Lcom/stripe/android/stripe3ds2/views/ThreeDS2TextView;", "getInfoLabel$3ds2sdk_release", "()Lcom/stripe/android/stripe3ds2/views/ThreeDS2TextView;", "()Z", "selectGroup", "Landroid/widget/LinearLayout;", "getSelectGroup$3ds2sdk_release", "()Landroid/widget/LinearLayout;", "selectedIndexes", "getSelectedIndexes$3ds2sdk_release", "selectedOptions", "Lcom/stripe/android/stripe3ds2/transactions/ChallengeResponseData$ChallengeSelectOption;", "getSelectedOptions", "userEntry", "", "getUserEntry", "()Ljava/lang/String;", "buildButton", "Landroid/widget/CompoundButton;", "option", "buttonCustomization", "Lcom/stripe/android/stripe3ds2/init/ui/ButtonCustomization;", "lastButton", "buildButton$3ds2sdk_release", "onRestoreInstanceState", "", "state", "Landroid/os/Parcelable;", "onSaveInstanceState", "selectOption", "index", "setChallengeSelectOptions", "options", "setTextEntryLabel", "label", "labelCustomization", "Lcom/stripe/android/stripe3ds2/init/ui/LabelCustomization;", "Companion", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChallengeZoneSelectView.kt */
public final class ChallengeZoneSelectView extends FrameLayout implements FormField {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final String STATE_SELECTED_INDEXED = "state_selected_indexes";
    @Deprecated
    private static final String STATE_SUPER = "state_super";
    private final int buttonBottomMargin;
    private final int buttonLabelPadding;
    private final int buttonMinHeight;
    private final int buttonOffsetMargin;
    private final ThreeDS2TextView infoLabel;
    private final boolean isSingleSelectMode;
    private final LinearLayout selectGroup;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ChallengeZoneSelectView(Context context) {
        this(context, (AttributeSet) null, 0, false, 14, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ChallengeZoneSelectView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, false, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ChallengeZoneSelectView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, false, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChallengeZoneSelectView(Context context, AttributeSet attributeSet, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? false : z);
    }

    public final boolean isSingleSelectMode() {
        return this.isSingleSelectMode;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChallengeZoneSelectView(Context context, AttributeSet attributeSet, int i, boolean z) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.isSingleSelectMode = z;
        if (getId() == -1) {
            setId(R.id.stripe_3ds2_default_challenge_zone_select_view_id);
        }
        this.buttonBottomMargin = context.getResources().getDimensionPixelSize(R.dimen.stripe_3ds2_challenge_zone_select_button_vertical_margin);
        this.buttonLabelPadding = context.getResources().getDimensionPixelSize(R.dimen.stripe_3ds2_challenge_zone_select_button_label_padding);
        this.buttonOffsetMargin = context.getResources().getDimensionPixelSize(R.dimen.stripe_3ds2_challenge_zone_select_button_offset_margin);
        this.buttonMinHeight = context.getResources().getDimensionPixelSize(R.dimen.stripe_3ds2_challenge_zone_select_button_min_height);
        if (z) {
            StripeChallengeZoneSingleSelectViewBinding inflate = StripeChallengeZoneSingleSelectViewBinding.inflate(LayoutInflater.from(context), this, true);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(\n               …   true\n                )");
            ThreeDS2TextView threeDS2TextView = inflate.label;
            Intrinsics.checkNotNullExpressionValue(threeDS2TextView, "viewBinding.label");
            this.infoLabel = threeDS2TextView;
            RadioGroup radioGroup = inflate.selectGroup;
            Intrinsics.checkNotNullExpressionValue(radioGroup, "viewBinding.selectGroup");
            this.selectGroup = radioGroup;
            return;
        }
        StripeChallengeZoneMultiSelectViewBinding inflate2 = StripeChallengeZoneMultiSelectViewBinding.inflate(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate2, "inflate(\n               …   true\n                )");
        ThreeDS2TextView threeDS2TextView2 = inflate2.label;
        Intrinsics.checkNotNullExpressionValue(threeDS2TextView2, "viewBinding.label");
        this.infoLabel = threeDS2TextView2;
        LinearLayout linearLayout = inflate2.selectGroup;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "viewBinding.selectGroup");
        this.selectGroup = linearLayout;
    }

    public final ThreeDS2TextView getInfoLabel$3ds2sdk_release() {
        return this.infoLabel;
    }

    public final LinearLayout getSelectGroup$3ds2sdk_release() {
        return this.selectGroup;
    }

    public String getUserEntry() {
        return CollectionsKt.joinToString$default(getSelectedOptions(), ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, ChallengeZoneSelectView$userEntry$1.INSTANCE, 30, (Object) null);
    }

    public final List<CheckBox> getCheckBoxes() {
        if (this.isSingleSelectMode) {
            return null;
        }
        Iterable until = RangesKt.until(0, this.selectGroup.getChildCount());
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
        Iterator it = until.iterator();
        while (it.hasNext()) {
            View childAt = getSelectGroup$3ds2sdk_release().getChildAt(((IntIterator) it).nextInt());
            Objects.requireNonNull(childAt, "null cannot be cast to non-null type android.widget.CheckBox");
            arrayList.add((CheckBox) childAt);
        }
        return (List) arrayList;
    }

    public final List<ChallengeResponseData.ChallengeSelectOption> getSelectedOptions() {
        Iterable<Number> selectedIndexes$3ds2sdk_release = getSelectedIndexes$3ds2sdk_release();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(selectedIndexes$3ds2sdk_release, 10));
        for (Number intValue : selectedIndexes$3ds2sdk_release) {
            Object tag = getSelectGroup$3ds2sdk_release().getChildAt(intValue.intValue()).getTag();
            Objects.requireNonNull(tag, "null cannot be cast to non-null type com.stripe.android.stripe3ds2.transactions.ChallengeResponseData.ChallengeSelectOption");
            arrayList.add((ChallengeResponseData.ChallengeSelectOption) tag);
        }
        return (List) arrayList;
    }

    public final List<Integer> getSelectedIndexes$3ds2sdk_release() {
        Integer num;
        Collection arrayList = new ArrayList();
        Iterator it = RangesKt.until(0, this.selectGroup.getChildCount()).iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            View childAt = getSelectGroup$3ds2sdk_release().getChildAt(nextInt);
            Objects.requireNonNull(childAt, "null cannot be cast to non-null type android.widget.CompoundButton");
            if (((CompoundButton) childAt).isChecked()) {
                num = Integer.valueOf(nextInt);
            } else {
                num = null;
            }
            if (num != null) {
                arrayList.add(num);
            }
        }
        List list = (List) arrayList;
        return CollectionsKt.take(list, this.isSingleSelectMode ? 1 : list.size());
    }

    public final CompoundButton buildButton$3ds2sdk_release(ChallengeResponseData.ChallengeSelectOption challengeSelectOption, ButtonCustomization buttonCustomization, boolean z) {
        CompoundButton compoundButton;
        Intrinsics.checkNotNullParameter(challengeSelectOption, "option");
        if (this.isSingleSelectMode) {
            compoundButton = new MaterialRadioButton(getContext());
        } else {
            compoundButton = new MaterialCheckBox(getContext());
        }
        if (buttonCustomization != null) {
            CharSequence backgroundColor = buttonCustomization.getBackgroundColor();
            boolean z2 = false;
            if (!(backgroundColor == null || StringsKt.isBlank(backgroundColor))) {
                CompoundButtonCompat.setButtonTintList(compoundButton, ColorStateList.valueOf(Color.parseColor(buttonCustomization.getBackgroundColor())));
            }
            CharSequence textColor = buttonCustomization.getTextColor();
            if (textColor == null || StringsKt.isBlank(textColor)) {
                z2 = true;
            }
            if (!z2) {
                compoundButton.setTextColor(Color.parseColor(buttonCustomization.getTextColor()));
            }
        }
        compoundButton.setId(View.generateViewId());
        compoundButton.setTag(challengeSelectOption);
        compoundButton.setText(challengeSelectOption.getText());
        compoundButton.setPadding(this.buttonLabelPadding, compoundButton.getPaddingTop(), compoundButton.getPaddingRight(), compoundButton.getPaddingBottom());
        compoundButton.setMinimumHeight(this.buttonMinHeight);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, -2);
        if (!z) {
            layoutParams.bottomMargin = this.buttonBottomMargin;
        }
        layoutParams.leftMargin = this.buttonOffsetMargin;
        compoundButton.setLayoutParams(layoutParams);
        return compoundButton;
    }

    public final void setChallengeSelectOptions(List<ChallengeResponseData.ChallengeSelectOption> list, ButtonCustomization buttonCustomization) {
        Integer valueOf = list == null ? null : Integer.valueOf(list.size());
        if (valueOf != null) {
            int intValue = valueOf.intValue();
            Iterator it = RangesKt.until(0, intValue).iterator();
            while (it.hasNext()) {
                int nextInt = ((IntIterator) it).nextInt();
                ChallengeResponseData.ChallengeSelectOption challengeSelectOption = list.get(nextInt);
                boolean z = true;
                if (nextInt != intValue - 1) {
                    z = false;
                }
                getSelectGroup$3ds2sdk_release().addView(buildButton$3ds2sdk_release(challengeSelectOption, buttonCustomization, z));
            }
        }
    }

    public final void setTextEntryLabel(String str, LabelCustomization labelCustomization) {
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            this.infoLabel.setVisibility(8);
        } else {
            this.infoLabel.setText(str, labelCustomization);
        }
    }

    public final void selectOption(int i) {
        View childAt = this.selectGroup.getChildAt(i);
        Objects.requireNonNull(childAt, "null cannot be cast to non-null type android.widget.CompoundButton");
        ((CompoundButton) childAt).setChecked(true);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        return BundleKt.bundleOf(TuplesKt.to(STATE_SUPER, super.onSaveInstanceState()), TuplesKt.to(STATE_SELECTED_INDEXED, new ArrayList(getSelectedIndexes$3ds2sdk_release())));
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        Intrinsics.checkNotNullParameter(parcelable, PostalAddressParser.REGION_KEY);
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            super.onRestoreInstanceState(bundle.getParcelable(STATE_SUPER));
            ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList(STATE_SELECTED_INDEXED);
            if (integerArrayList != null) {
                for (Integer num : integerArrayList) {
                    Intrinsics.checkNotNullExpressionValue(num, "it");
                    selectOption(num.intValue());
                }
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/stripe3ds2/views/ChallengeZoneSelectView$Companion;", "", "()V", "STATE_SELECTED_INDEXED", "", "STATE_SUPER", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ChallengeZoneSelectView.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
