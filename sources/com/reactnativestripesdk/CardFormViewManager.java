package com.reactnativestripesdk;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0005H\u0014J\u0014\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J$\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007J\u0018\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001aH\u0007J\u001a\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u001c\u001a\u00020\u0017H\u0007J\u001a\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u001e\u001a\u00020\u0017H\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/reactnativestripesdk/CardFormViewManager;", "Lcom/facebook/react/uimanager/SimpleViewManager;", "Lcom/reactnativestripesdk/CardFormView;", "()V", "reactContextRef", "Lcom/facebook/react/uimanager/ThemedReactContext;", "createViewInstance", "reactContext", "getExportedCustomDirectEventTypeConstants", "", "", "", "getName", "onDropViewInstance", "", "view", "receiveCommand", "root", "commandId", "args", "Lcom/facebook/react/bridge/ReadableArray;", "setAutofocus", "autofocus", "", "setCardStyle", "cardStyle", "Lcom/facebook/react/bridge/ReadableMap;", "setDangerouslyGetFullCardDetails", "dangerouslyGetFullCardDetails", "setPostalCodeEnabled", "postalCodeEnabled", "stripe_stripe-react-native_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CardFormViewManager.kt */
public final class CardFormViewManager extends SimpleViewManager<CardFormView> {
    private ThemedReactContext reactContextRef;

    public String getName() {
        return "CardForm";
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        Map<String, Object> of = MapBuilder.of(CardFocusEvent.EVENT_NAME, MapBuilder.of("registrationName", "onFocusChange"), CardFormCompleteEvent.EVENT_NAME, MapBuilder.of("registrationName", CardFormCompleteEvent.EVENT_NAME));
        Intrinsics.checkNotNullExpressionValue(of, "of(\n      CardFocusEvent.EVENT_NAME, MapBuilder.of(\"registrationName\", \"onFocusChange\"),\n      CardFormCompleteEvent.EVENT_NAME, MapBuilder.of(\"registrationName\", \"onFormComplete\"))");
        return of;
    }

    public void receiveCommand(CardFormView cardFormView, String str, ReadableArray readableArray) {
        Intrinsics.checkNotNullParameter(cardFormView, "root");
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != 3027047) {
                if (hashCode != 94746189) {
                    if (hashCode == 97604824 && str.equals("focus")) {
                        cardFormView.requestFocusFromJS();
                    }
                } else if (str.equals("clear")) {
                    cardFormView.requestClearFromJS();
                }
            } else if (str.equals("blur")) {
                cardFormView.requestBlurFromJS();
            }
        }
    }

    public static /* synthetic */ void setDangerouslyGetFullCardDetails$default(CardFormViewManager cardFormViewManager, CardFormView cardFormView, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        cardFormViewManager.setDangerouslyGetFullCardDetails(cardFormView, z);
    }

    @ReactProp(name = "dangerouslyGetFullCardDetails")
    public final void setDangerouslyGetFullCardDetails(CardFormView cardFormView, boolean z) {
        Intrinsics.checkNotNullParameter(cardFormView, "view");
        cardFormView.setDangerouslyGetFullCardDetails(z);
    }

    public static /* synthetic */ void setPostalCodeEnabled$default(CardFormViewManager cardFormViewManager, CardFormView cardFormView, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        cardFormViewManager.setPostalCodeEnabled(cardFormView, z);
    }

    @ReactProp(name = "postalCodeEnabled")
    public final void setPostalCodeEnabled(CardFormView cardFormView, boolean z) {
        Intrinsics.checkNotNullParameter(cardFormView, "view");
        cardFormView.setPostalCodeEnabled(z);
    }

    public static /* synthetic */ void setAutofocus$default(CardFormViewManager cardFormViewManager, CardFormView cardFormView, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        cardFormViewManager.setAutofocus(cardFormView, z);
    }

    @ReactProp(name = "autofocus")
    public final void setAutofocus(CardFormView cardFormView, boolean z) {
        Intrinsics.checkNotNullParameter(cardFormView, "view");
        cardFormView.setAutofocus(z);
    }

    @ReactProp(name = "cardStyle")
    public final void setCardStyle(CardFormView cardFormView, ReadableMap readableMap) {
        Intrinsics.checkNotNullParameter(cardFormView, "view");
        Intrinsics.checkNotNullParameter(readableMap, "cardStyle");
        cardFormView.setCardStyle(readableMap);
    }

    /* access modifiers changed from: protected */
    public CardFormView createViewInstance(ThemedReactContext themedReactContext) {
        Intrinsics.checkNotNullParameter(themedReactContext, "reactContext");
        StripeSdkModule stripeSdkModule = (StripeSdkModule) themedReactContext.getNativeModule(StripeSdkModule.class);
        CardFormView cardFormView = new CardFormView(themedReactContext);
        this.reactContextRef = themedReactContext;
        if (stripeSdkModule != null) {
            stripeSdkModule.setCardFormView(cardFormView);
        }
        return cardFormView;
    }

    public void onDropViewInstance(CardFormView cardFormView) {
        Intrinsics.checkNotNullParameter(cardFormView, "view");
        super.onDropViewInstance(cardFormView);
        ThemedReactContext themedReactContext = this.reactContextRef;
        StripeSdkModule stripeSdkModule = themedReactContext == null ? null : (StripeSdkModule) themedReactContext.getNativeModule(StripeSdkModule.class);
        if (stripeSdkModule != null) {
            stripeSdkModule.setCardFormView((CardFormView) null);
        }
        this.reactContextRef = null;
    }
}
