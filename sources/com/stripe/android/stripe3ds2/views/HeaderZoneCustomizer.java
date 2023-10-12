package com.stripe.android.stripe3ds2.views;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.fragment.app.FragmentActivity;
import com.stripe.android.stripe3ds2.R;
import com.stripe.android.stripe3ds2.init.ui.ButtonCustomization;
import com.stripe.android.stripe3ds2.init.ui.ToolbarCustomization;
import com.stripe.android.stripe3ds2.utils.CustomizeUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/stripe/android/stripe3ds2/views/HeaderZoneCustomizer;", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;)V", "customize", "Lcom/stripe/android/stripe3ds2/views/ThreeDS2Button;", "toolbarCustomization", "Lcom/stripe/android/stripe3ds2/init/ui/ToolbarCustomization;", "cancelButtonCustomization", "Lcom/stripe/android/stripe3ds2/init/ui/ButtonCustomization;", "Companion", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HeaderZoneCustomizer.kt */
public final class HeaderZoneCustomizer {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final FragmentActivity activity;

    public HeaderZoneCustomizer(FragmentActivity fragmentActivity) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        this.activity = fragmentActivity;
    }

    public static /* synthetic */ ThreeDS2Button customize$default(HeaderZoneCustomizer headerZoneCustomizer, ToolbarCustomization toolbarCustomization, ButtonCustomization buttonCustomization, int i, Object obj) {
        if ((i & 1) != 0) {
            toolbarCustomization = null;
        }
        if ((i & 2) != 0) {
            buttonCustomization = null;
        }
        return headerZoneCustomizer.customize(toolbarCustomization, buttonCustomization);
    }

    public final ThreeDS2Button customize(ToolbarCustomization toolbarCustomization, ButtonCustomization buttonCustomization) {
        ActionBar actionBar;
        String str;
        FragmentActivity fragmentActivity = this.activity;
        AppCompatActivity appCompatActivity = fragmentActivity instanceof AppCompatActivity ? (AppCompatActivity) fragmentActivity : null;
        if (appCompatActivity == null) {
            actionBar = null;
        } else {
            actionBar = appCompatActivity.getSupportActionBar();
        }
        if (actionBar == null) {
            return null;
        }
        ThreeDS2Button threeDS2Button = new ThreeDS2Button(new ContextThemeWrapper((Context) this.activity, R.style.Stripe3DS2ActionBarButton), (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        boolean z = false;
        threeDS2Button.setBackgroundTintList(ColorStateList.valueOf(0));
        threeDS2Button.setButtonCustomization(buttonCustomization);
        actionBar.setCustomView(threeDS2Button, new ActionBar.LayoutParams(-2, -2, 8388629));
        actionBar.setDisplayShowCustomEnabled(true);
        if (toolbarCustomization != null) {
            CharSequence buttonText = toolbarCustomization.getButtonText();
            if (!(buttonText == null || StringsKt.isBlank(buttonText))) {
                threeDS2Button.setText(toolbarCustomization.getButtonText());
            } else {
                threeDS2Button.setText(R.string.stripe_3ds2_hzv_cancel_label);
            }
            String backgroundColor = toolbarCustomization.getBackgroundColor();
            if (backgroundColor != null) {
                actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor(backgroundColor)));
                Companion.customizeStatusBar(appCompatActivity, toolbarCustomization);
            }
            CharSequence headerText = toolbarCustomization.getHeaderText();
            if (headerText == null || StringsKt.isBlank(headerText)) {
                z = true;
            }
            if (!z) {
                str = toolbarCustomization.getHeaderText();
                Intrinsics.checkNotNullExpressionValue(str, "{\n                toolba….headerText\n            }");
            } else {
                str = this.activity.getString(R.string.stripe_3ds2_hzv_header_label);
                Intrinsics.checkNotNullExpressionValue(str, "{\n                activi…ader_label)\n            }");
            }
            actionBar.setTitle((CharSequence) CustomizeUtils.INSTANCE.buildStyledText(this.activity, str, toolbarCustomization));
        } else {
            actionBar.setTitle(R.string.stripe_3ds2_hzv_header_label);
            threeDS2Button.setText(R.string.stripe_3ds2_hzv_cancel_label);
        }
        return threeDS2Button;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/stripe/android/stripe3ds2/views/HeaderZoneCustomizer$Companion;", "", "()V", "customizeStatusBar", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "toolbarCustomization", "Lcom/stripe/android/stripe3ds2/init/ui/ToolbarCustomization;", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HeaderZoneCustomizer.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void customizeStatusBar(AppCompatActivity appCompatActivity, ToolbarCustomization toolbarCustomization) {
            Intrinsics.checkNotNullParameter(appCompatActivity, "activity");
            Intrinsics.checkNotNullParameter(toolbarCustomization, "toolbarCustomization");
            if (toolbarCustomization.getStatusBarColor() != null) {
                CustomizeUtils.INSTANCE.setStatusBarColor(appCompatActivity, Color.parseColor(toolbarCustomization.getStatusBarColor()));
            } else if (toolbarCustomization.getBackgroundColor() != null) {
                CustomizeUtils.INSTANCE.setStatusBarColor(appCompatActivity, CustomizeUtils.INSTANCE.darken$3ds2sdk_release(Color.parseColor(toolbarCustomization.getBackgroundColor())));
            }
        }
    }
}
