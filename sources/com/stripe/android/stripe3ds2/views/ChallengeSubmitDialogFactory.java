package com.stripe.android.stripe3ds2.views;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.stripe.android.stripe3ds2.databinding.StripeChallengeSubmitDialogBinding;
import com.stripe.android.stripe3ds2.init.ui.UiCustomization;
import com.stripe.android.stripe3ds2.utils.CustomizeUtils;
import com.stripe.android.stripe3ds2.utils.Factory0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/stripe/android/stripe3ds2/views/ChallengeSubmitDialogFactory;", "Lcom/stripe/android/stripe3ds2/utils/Factory0;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "uiCustomization", "Lcom/stripe/android/stripe3ds2/init/ui/UiCustomization;", "(Landroid/content/Context;Lcom/stripe/android/stripe3ds2/init/ui/UiCustomization;)V", "create", "ChallengeSubmitDialog", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChallengeSubmitDialogFactory.kt */
public final class ChallengeSubmitDialogFactory implements Factory0<Dialog> {
    private final Context context;
    private final UiCustomization uiCustomization;

    public ChallengeSubmitDialogFactory(Context context2, UiCustomization uiCustomization2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(uiCustomization2, "uiCustomization");
        this.context = context2;
        this.uiCustomization = uiCustomization2;
    }

    public Dialog create() {
        return new ChallengeSubmitDialog(this.context, this.uiCustomization);
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/stripe/android/stripe3ds2/views/ChallengeSubmitDialogFactory$ChallengeSubmitDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "uiCustomization", "Lcom/stripe/android/stripe3ds2/init/ui/UiCustomization;", "(Landroid/content/Context;Lcom/stripe/android/stripe3ds2/init/ui/UiCustomization;)V", "viewBinding", "Lcom/stripe/android/stripe3ds2/databinding/StripeChallengeSubmitDialogBinding;", "getViewBinding", "()Lcom/stripe/android/stripe3ds2/databinding/StripeChallengeSubmitDialogBinding;", "viewBinding$delegate", "Lkotlin/Lazy;", "onStart", "", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ChallengeSubmitDialogFactory.kt */
    private static final class ChallengeSubmitDialog extends Dialog {
        private final UiCustomization uiCustomization;
        private final Lazy viewBinding$delegate = LazyKt.lazy(new ChallengeSubmitDialogFactory$ChallengeSubmitDialog$viewBinding$2(this));

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ChallengeSubmitDialog(Context context, UiCustomization uiCustomization2) {
            super(context);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(uiCustomization2, "uiCustomization");
            this.uiCustomization = uiCustomization2;
            setCancelable(false);
            Window window = getWindow();
            if (window != null) {
                window.clearFlags(2);
            }
            Window window2 = getWindow();
            if (window2 != null) {
                window2.setBackgroundDrawable(new ColorDrawable(0));
            }
        }

        private final StripeChallengeSubmitDialogBinding getViewBinding() {
            return (StripeChallengeSubmitDialogBinding) this.viewBinding$delegate.getValue();
        }

        /* access modifiers changed from: protected */
        public void onStart() {
            super.onStart();
            setContentView(getViewBinding().getRoot());
            CustomizeUtils customizeUtils = CustomizeUtils.INSTANCE;
            CircularProgressIndicator circularProgressIndicator = getViewBinding().progressBar;
            Intrinsics.checkNotNullExpressionValue(circularProgressIndicator, "viewBinding.progressBar");
            customizeUtils.applyProgressBarColor$3ds2sdk_release(circularProgressIndicator, this.uiCustomization);
        }
    }
}
