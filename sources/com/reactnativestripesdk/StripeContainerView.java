package com.reactnativestripesdk;

import android.app.Activity;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.facebook.react.uimanager.ThemedReactContext;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/reactnativestripesdk/StripeContainerView;", "Landroid/widget/FrameLayout;", "context", "Lcom/facebook/react/uimanager/ThemedReactContext;", "(Lcom/facebook/react/uimanager/ThemedReactContext;)V", "keyboardShouldPersistTapsValue", "", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "setKeyboardShouldPersistTaps", "", "value", "stripe_stripe-react-native_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: StripeContainerView.kt */
public final class StripeContainerView extends FrameLayout {
    private final ThemedReactContext context;
    private boolean keyboardShouldPersistTapsValue = true;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StripeContainerView(ThemedReactContext themedReactContext) {
        super(themedReactContext);
        Intrinsics.checkNotNullParameter(themedReactContext, "context");
        this.context = themedReactContext;
        getRootView().setFocusable(true);
        getRootView().setFocusableInTouchMode(true);
        getRootView().setClickable(true);
    }

    public final void setKeyboardShouldPersistTaps(boolean z) {
        this.keyboardShouldPersistTapsValue = z;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Intrinsics.checkNotNull(motionEvent);
        if (motionEvent.getAction() == 0 && !this.keyboardShouldPersistTapsValue) {
            Activity currentActivity = this.context.getCurrentActivity();
            Intrinsics.checkNotNull(currentActivity);
            View currentFocus = currentActivity.getCurrentFocus();
            if (currentFocus instanceof EditText) {
                Rect rect = new Rect();
                EditText editText = (EditText) currentFocus;
                editText.getGlobalVisibleRect(rect);
                if (!rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                    Object systemService = this.context.getSystemService("input_method");
                    Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                    ((InputMethodManager) systemService).hideSoftInputFromWindow(editText.getWindowToken(), 0);
                    getRootView().requestFocus();
                }
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
