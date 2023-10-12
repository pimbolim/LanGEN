package com.reactnativestripesdk;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0004"}, d2 = {"hideSoftKeyboard", "", "Landroid/view/View;", "showSoftKeyboard", "stripe_stripe-react-native_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* compiled from: Extensions.kt */
public final class ExtensionsKt {
    public static final void showSoftKeyboard(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.post(new Runnable(view) {
            public final /* synthetic */ View f$0;

            {
                this.f$0 = r1;
            }

            public final void run() {
                ExtensionsKt.m4271showSoftKeyboard$lambda0(this.f$0);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: showSoftKeyboard$lambda-0  reason: not valid java name */
    public static final void m4271showSoftKeyboard$lambda0(View view) {
        InputMethodManager inputMethodManager;
        Intrinsics.checkNotNullParameter(view, "$this_showSoftKeyboard");
        if (view.requestFocus() && (inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method")) != null) {
            inputMethodManager.showSoftInput(view, 1);
        }
    }

    public static final void hideSoftKeyboard(View view) {
        InputMethodManager inputMethodManager;
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (view.requestFocus() && (inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method")) != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
