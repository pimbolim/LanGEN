package com.stripe.android.stripe3ds2.views;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.stripe.android.stripe3ds2.databinding.StripeInformationZoneViewBinding;
import com.stripe.android.stripe3ds2.init.ui.LabelCustomization;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u00101\u001a\u000202J&\u00103\u001a\u0002022\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u0001052\n\b\u0002\u00107\u001a\u0004\u0018\u000108J&\u00109\u001a\u0002022\b\u0010:\u001a\u0004\u0018\u0001052\b\u0010;\u001a\u0004\u0018\u0001052\n\b\u0002\u00107\u001a\u0004\u0018\u000108J \u0010<\u001a\u0002022\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020>H\u0002R\u000e\u0010\t\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u00020\f8\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u00020\u00128\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u00020\u00178\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u00020\u00178\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u000e\u001a\u0004\b\u001d\u0010\u001aR\u001e\u0010\u001e\u001a\u00020\u00078\u0000@\u0000X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020$X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010%\u001a\u00020\f8\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u000e\u001a\u0004\b'\u0010\u0010R\u001c\u0010(\u001a\u00020\u00128\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010\u000e\u001a\u0004\b*\u0010\u0015R\u001c\u0010+\u001a\u00020\u00178\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010\u000e\u001a\u0004\b-\u0010\u001aR\u001c\u0010.\u001a\u00020\u00178\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b/\u0010\u000e\u001a\u0004\b0\u0010\u001a¨\u0006B"}, d2 = {"Lcom/stripe/android/stripe3ds2/views/InformationZoneView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animationDuration", "defaultColor", "expandArrow", "Landroidx/appcompat/widget/AppCompatImageView;", "getExpandArrow$3ds2sdk_release$annotations", "()V", "getExpandArrow$3ds2sdk_release", "()Landroidx/appcompat/widget/AppCompatImageView;", "expandContainer", "Landroid/widget/LinearLayout;", "getExpandContainer$3ds2sdk_release$annotations", "getExpandContainer$3ds2sdk_release", "()Landroid/widget/LinearLayout;", "expandLabel", "Lcom/stripe/android/stripe3ds2/views/ThreeDS2TextView;", "getExpandLabel$3ds2sdk_release$annotations", "getExpandLabel$3ds2sdk_release", "()Lcom/stripe/android/stripe3ds2/views/ThreeDS2TextView;", "expandText", "getExpandText$3ds2sdk_release$annotations", "getExpandText$3ds2sdk_release", "toggleColor", "getToggleColor$3ds2sdk_release", "()I", "setToggleColor$3ds2sdk_release", "(I)V", "viewBinding", "Lcom/stripe/android/stripe3ds2/databinding/StripeInformationZoneViewBinding;", "whyArrow", "getWhyArrow$3ds2sdk_release$annotations", "getWhyArrow$3ds2sdk_release", "whyContainer", "getWhyContainer$3ds2sdk_release$annotations", "getWhyContainer$3ds2sdk_release", "whyLabel", "getWhyLabel$3ds2sdk_release$annotations", "getWhyLabel$3ds2sdk_release", "whyText", "getWhyText$3ds2sdk_release$annotations", "getWhyText$3ds2sdk_release", "expandViews", "", "setExpandInfo", "expandInfoLabel", "", "expandInfoText", "labelCustomization", "Lcom/stripe/android/stripe3ds2/init/ui/LabelCustomization;", "setWhyInfo", "whyInfoLabel", "whyInfoText", "toggleView", "arrow", "Landroid/view/View;", "label", "Landroid/widget/TextView;", "detailsView", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: InformationZoneView.kt */
public final class InformationZoneView extends FrameLayout {
    private final int animationDuration;
    private int defaultColor;
    private final AppCompatImageView expandArrow;
    private final LinearLayout expandContainer;
    private final ThreeDS2TextView expandLabel;
    private final ThreeDS2TextView expandText;
    private int toggleColor;
    private final StripeInformationZoneViewBinding viewBinding;
    private final AppCompatImageView whyArrow;
    private final LinearLayout whyContainer;
    private final ThreeDS2TextView whyLabel;
    private final ThreeDS2TextView whyText;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public InformationZoneView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public InformationZoneView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static /* synthetic */ void getExpandArrow$3ds2sdk_release$annotations() {
    }

    public static /* synthetic */ void getExpandContainer$3ds2sdk_release$annotations() {
    }

    public static /* synthetic */ void getExpandLabel$3ds2sdk_release$annotations() {
    }

    public static /* synthetic */ void getExpandText$3ds2sdk_release$annotations() {
    }

    public static /* synthetic */ void getWhyArrow$3ds2sdk_release$annotations() {
    }

    public static /* synthetic */ void getWhyContainer$3ds2sdk_release$annotations() {
    }

    public static /* synthetic */ void getWhyLabel$3ds2sdk_release$annotations() {
    }

    public static /* synthetic */ void getWhyText$3ds2sdk_release$annotations() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InformationZoneView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InformationZoneView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        StripeInformationZoneViewBinding inflate = StripeInformationZoneViewBinding.inflate(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(\n        LayoutI… this,\n        true\n    )");
        this.viewBinding = inflate;
        ThreeDS2TextView threeDS2TextView = inflate.whyLabel;
        Intrinsics.checkNotNullExpressionValue(threeDS2TextView, "viewBinding.whyLabel");
        this.whyLabel = threeDS2TextView;
        ThreeDS2TextView threeDS2TextView2 = inflate.whyText;
        Intrinsics.checkNotNullExpressionValue(threeDS2TextView2, "viewBinding.whyText");
        this.whyText = threeDS2TextView2;
        LinearLayout linearLayout = inflate.whyContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "viewBinding.whyContainer");
        this.whyContainer = linearLayout;
        AppCompatImageView appCompatImageView = inflate.whyArrow;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "viewBinding.whyArrow");
        this.whyArrow = appCompatImageView;
        ThreeDS2TextView threeDS2TextView3 = inflate.expandLabel;
        Intrinsics.checkNotNullExpressionValue(threeDS2TextView3, "viewBinding.expandLabel");
        this.expandLabel = threeDS2TextView3;
        ThreeDS2TextView threeDS2TextView4 = inflate.expandText;
        Intrinsics.checkNotNullExpressionValue(threeDS2TextView4, "viewBinding.expandText");
        this.expandText = threeDS2TextView4;
        LinearLayout linearLayout2 = inflate.expandContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "viewBinding.expandContainer");
        this.expandContainer = linearLayout2;
        AppCompatImageView appCompatImageView2 = inflate.expandArrow;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "viewBinding.expandArrow");
        this.expandArrow = appCompatImageView2;
        this.animationDuration = getResources().getInteger(17694720);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                InformationZoneView.m4462_init_$lambda0(InformationZoneView.this, view);
            }
        });
        linearLayout2.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                InformationZoneView.m4463_init_$lambda1(InformationZoneView.this, view);
            }
        });
    }

    public final ThreeDS2TextView getWhyLabel$3ds2sdk_release() {
        return this.whyLabel;
    }

    public final ThreeDS2TextView getWhyText$3ds2sdk_release() {
        return this.whyText;
    }

    public final LinearLayout getWhyContainer$3ds2sdk_release() {
        return this.whyContainer;
    }

    public final AppCompatImageView getWhyArrow$3ds2sdk_release() {
        return this.whyArrow;
    }

    public final ThreeDS2TextView getExpandLabel$3ds2sdk_release() {
        return this.expandLabel;
    }

    public final ThreeDS2TextView getExpandText$3ds2sdk_release() {
        return this.expandText;
    }

    public final LinearLayout getExpandContainer$3ds2sdk_release() {
        return this.expandContainer;
    }

    public final AppCompatImageView getExpandArrow$3ds2sdk_release() {
        return this.expandArrow;
    }

    public final int getToggleColor$3ds2sdk_release() {
        return this.toggleColor;
    }

    public final void setToggleColor$3ds2sdk_release(int i) {
        this.toggleColor = i;
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m4462_init_$lambda0(InformationZoneView informationZoneView, View view) {
        Intrinsics.checkNotNullParameter(informationZoneView, "this$0");
        informationZoneView.toggleView(informationZoneView.whyArrow, informationZoneView.whyLabel, informationZoneView.whyText);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m4463_init_$lambda1(InformationZoneView informationZoneView, View view) {
        Intrinsics.checkNotNullParameter(informationZoneView, "this$0");
        informationZoneView.toggleView(informationZoneView.expandArrow, informationZoneView.expandLabel, informationZoneView.expandText);
    }

    public static /* synthetic */ void setWhyInfo$default(InformationZoneView informationZoneView, String str, String str2, LabelCustomization labelCustomization, int i, Object obj) {
        if ((i & 4) != 0) {
            labelCustomization = null;
        }
        informationZoneView.setWhyInfo(str, str2, labelCustomization);
    }

    public final void setWhyInfo(String str, String str2, LabelCustomization labelCustomization) {
        CharSequence charSequence = str;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            this.whyLabel.setText(str, labelCustomization);
            this.whyContainer.setVisibility(0);
            this.whyText.setText(str2, labelCustomization);
        }
    }

    public static /* synthetic */ void setExpandInfo$default(InformationZoneView informationZoneView, String str, String str2, LabelCustomization labelCustomization, int i, Object obj) {
        if ((i & 4) != 0) {
            labelCustomization = null;
        }
        informationZoneView.setExpandInfo(str, str2, labelCustomization);
    }

    public final void setExpandInfo(String str, String str2, LabelCustomization labelCustomization) {
        CharSequence charSequence = str;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            this.expandLabel.setText(str, labelCustomization);
            this.expandContainer.setVisibility(0);
            this.expandText.setText(str2, labelCustomization);
        }
    }

    private final void toggleView(View view, TextView textView, View view2) {
        int i = 8;
        boolean z = view2.getVisibility() == 8;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "rotation", new float[]{(float) (z ? 180 : 0)});
        ofFloat.setDuration((long) this.animationDuration);
        ofFloat.start();
        textView.setEnabled(z);
        view.setEnabled(z);
        if (this.toggleColor != 0) {
            if (this.defaultColor == 0) {
                this.defaultColor = textView.getTextColors().getDefaultColor();
            }
            textView.setTextColor(z ? this.toggleColor : this.defaultColor);
        }
        if (z) {
            i = 0;
        }
        view2.setVisibility(i);
        if (z) {
            view2.postDelayed(new Runnable(view2) {
                public final /* synthetic */ View f$0;

                {
                    this.f$0 = r1;
                }

                public final void run() {
                    InformationZoneView.m4465toggleView$lambda2(this.f$0);
                }
            }, (long) this.animationDuration);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: toggleView$lambda-2  reason: not valid java name */
    public static final void m4465toggleView$lambda2(View view) {
        Intrinsics.checkNotNullParameter(view, "$detailsView");
        Rect rect = new Rect(0, 0, view.getWidth(), view.getHeight());
        view.getHitRect(rect);
        view.requestRectangleOnScreen(rect, false);
    }

    public final void expandViews() {
        this.expandArrow.setRotation(180.0f);
        this.whyArrow.setRotation(180.0f);
        this.expandText.setVisibility(0);
        this.whyText.setVisibility(0);
    }
}
