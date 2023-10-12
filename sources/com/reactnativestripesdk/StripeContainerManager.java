package com.reactnativestripesdk;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0007¨\u0006\u000e"}, d2 = {"Lcom/reactnativestripesdk/StripeContainerManager;", "Lcom/facebook/react/uimanager/ViewGroupManager;", "Lcom/reactnativestripesdk/StripeContainerView;", "()V", "createViewInstance", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "getName", "", "setKeyboardShouldPersistTaps", "", "view", "keyboardShouldPersistTaps", "", "stripe_stripe-react-native_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: StripeContainerManager.kt */
public final class StripeContainerManager extends ViewGroupManager<StripeContainerView> {
    public String getName() {
        return "StripeContainer";
    }

    @ReactProp(name = "keyboardShouldPersistTaps")
    public final void setKeyboardShouldPersistTaps(StripeContainerView stripeContainerView, boolean z) {
        Intrinsics.checkNotNullParameter(stripeContainerView, "view");
        stripeContainerView.setKeyboardShouldPersistTaps(z);
    }

    /* access modifiers changed from: protected */
    public StripeContainerView createViewInstance(ThemedReactContext themedReactContext) {
        Intrinsics.checkNotNullParameter(themedReactContext, "reactContext");
        return new StripeContainerView(themedReactContext);
    }
}
