package com.reactnativestripesdk;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \r2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0014J\b\u0010\u000b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0014¨\u0006\u000e"}, d2 = {"Lcom/reactnativestripesdk/GooglePayButtonManager;", "Lcom/facebook/react/uimanager/SimpleViewManager;", "Lcom/reactnativestripesdk/GooglePayButtonView;", "()V", "buttonType", "", "view", "", "createViewInstance", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "getName", "onAfterUpdateTransaction", "Companion", "stripe_stripe-react-native_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: GooglePayButtonManager.kt */
public final class GooglePayButtonManager extends SimpleViewManager<GooglePayButtonView> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String REACT_CLASS = "GooglePayButton";

    public String getName() {
        return REACT_CLASS;
    }

    /* access modifiers changed from: protected */
    public void onAfterUpdateTransaction(GooglePayButtonView googlePayButtonView) {
        Intrinsics.checkNotNullParameter(googlePayButtonView, "view");
        super.onAfterUpdateTransaction(googlePayButtonView);
        googlePayButtonView.initialize();
    }

    @ReactProp(name = "buttonType")
    public final void buttonType(GooglePayButtonView googlePayButtonView, String str) {
        Intrinsics.checkNotNullParameter(googlePayButtonView, "view");
        Intrinsics.checkNotNullParameter(str, "buttonType");
        googlePayButtonView.setType(str);
    }

    /* access modifiers changed from: protected */
    public GooglePayButtonView createViewInstance(ThemedReactContext themedReactContext) {
        Intrinsics.checkNotNullParameter(themedReactContext, "reactContext");
        return new GooglePayButtonView(themedReactContext);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/reactnativestripesdk/GooglePayButtonManager$Companion;", "", "()V", "REACT_CLASS", "", "stripe_stripe-react-native_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: GooglePayButtonManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
