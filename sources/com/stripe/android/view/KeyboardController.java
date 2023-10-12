package com.stripe.android.view;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/stripe/android/view/KeyboardController;", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "inputMethodManager", "Landroid/view/inputmethod/InputMethodManager;", "hide", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: KeyboardController.kt */
public final class KeyboardController {
    public static final int $stable = 8;
    private final Activity activity;
    private final InputMethodManager inputMethodManager;

    public KeyboardController(Activity activity2) {
        Intrinsics.checkNotNullParameter(activity2, "activity");
        this.activity = activity2;
        Object systemService = activity2.getSystemService("input_method");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        this.inputMethodManager = (InputMethodManager) systemService;
    }

    public final /* synthetic */ void hide() {
        if (this.inputMethodManager.isAcceptingText()) {
            InputMethodManager inputMethodManager2 = this.inputMethodManager;
            View currentFocus = this.activity.getCurrentFocus();
            inputMethodManager2.hideSoftInputFromWindow(currentFocus == null ? null : currentFocus.getWindowToken(), 0);
        }
    }
}
