package com.reactnativestripesdk;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\tH\u0007J\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0007¨\u0006\u0013"}, d2 = {"Lcom/reactnativestripesdk/AuBECSDebitFormViewManager;", "Lcom/facebook/react/uimanager/SimpleViewManager;", "Lcom/reactnativestripesdk/AuBECSDebitFormView;", "()V", "createViewInstance", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "getExportedCustomDirectEventTypeConstants", "", "", "", "getName", "setCompanyName", "", "view", "name", "setFormStyle", "style", "Lcom/facebook/react/bridge/ReadableMap;", "stripe_stripe-react-native_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: AuBECSDebitFormViewManager.kt */
public final class AuBECSDebitFormViewManager extends SimpleViewManager<AuBECSDebitFormView> {
    public String getName() {
        return "AuBECSDebitForm";
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        Map<String, Object> of = MapBuilder.of(FormCompleteEvent.EVENT_NAME, MapBuilder.of("registrationName", FormCompleteEvent.EVENT_NAME));
        Intrinsics.checkNotNullExpressionValue(of, "of(\n      FormCompleteEvent.EVENT_NAME, MapBuilder.of(\"registrationName\", \"onCompleteAction\"))");
        return of;
    }

    @ReactProp(name = "companyName")
    public final void setCompanyName(AuBECSDebitFormView auBECSDebitFormView, String str) {
        Intrinsics.checkNotNullParameter(auBECSDebitFormView, "view");
        auBECSDebitFormView.setCompanyName(str);
    }

    @ReactProp(name = "formStyle")
    public final void setFormStyle(AuBECSDebitFormView auBECSDebitFormView, ReadableMap readableMap) {
        Intrinsics.checkNotNullParameter(auBECSDebitFormView, "view");
        Intrinsics.checkNotNullParameter(readableMap, "style");
        auBECSDebitFormView.setFormStyle(readableMap);
    }

    /* access modifiers changed from: protected */
    public AuBECSDebitFormView createViewInstance(ThemedReactContext themedReactContext) {
        Intrinsics.checkNotNullParameter(themedReactContext, "reactContext");
        return new AuBECSDebitFormView(themedReactContext);
    }
}
