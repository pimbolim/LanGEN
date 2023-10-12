package com.reactnativestripesdk;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.textinput.ReactTextInputShadowNode;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0005H\u0014J\u0014\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J$\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007J\u0018\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001aH\u0007J\u001a\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u001c\u001a\u00020\u0017H\u0007J\u0018\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001aH\u0007J\u001a\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010 \u001a\u00020\u0017H\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/reactnativestripesdk/CardFieldViewManager;", "Lcom/facebook/react/uimanager/SimpleViewManager;", "Lcom/reactnativestripesdk/CardFieldView;", "()V", "reactContextRef", "Lcom/facebook/react/uimanager/ThemedReactContext;", "createViewInstance", "reactContext", "getExportedCustomDirectEventTypeConstants", "", "", "", "getName", "onDropViewInstance", "", "view", "receiveCommand", "root", "commandId", "args", "Lcom/facebook/react/bridge/ReadableArray;", "setAutofocus", "autofocus", "", "setCardStyle", "cardStyle", "Lcom/facebook/react/bridge/ReadableMap;", "setDangerouslyGetFullCardDetails", "dangerouslyGetFullCardDetails", "setPlaceHolders", "placeholder", "setPostalCodeEnabled", "postalCodeEnabled", "stripe_stripe-react-native_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CardFieldViewManager.kt */
public final class CardFieldViewManager extends SimpleViewManager<CardFieldView> {
    private ThemedReactContext reactContextRef;

    public String getName() {
        return "CardField";
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        Map<String, Object> of = MapBuilder.of(CardFocusEvent.EVENT_NAME, MapBuilder.of("registrationName", "onFocusChange"), CardChangedEvent.EVENT_NAME, MapBuilder.of("registrationName", CardChangedEvent.EVENT_NAME));
        Intrinsics.checkNotNullExpressionValue(of, "of(\n      CardFocusEvent.EVENT_NAME, MapBuilder.of(\"registrationName\", \"onFocusChange\"),\n      CardChangedEvent.EVENT_NAME, MapBuilder.of(\"registrationName\", \"onCardChange\"))");
        return of;
    }

    public void receiveCommand(CardFieldView cardFieldView, String str, ReadableArray readableArray) {
        Intrinsics.checkNotNullParameter(cardFieldView, "root");
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != 3027047) {
                if (hashCode != 94746189) {
                    if (hashCode == 97604824 && str.equals("focus")) {
                        cardFieldView.requestFocusFromJS();
                    }
                } else if (str.equals("clear")) {
                    cardFieldView.requestClearFromJS();
                }
            } else if (str.equals("blur")) {
                cardFieldView.requestBlurFromJS();
            }
        }
    }

    public static /* synthetic */ void setDangerouslyGetFullCardDetails$default(CardFieldViewManager cardFieldViewManager, CardFieldView cardFieldView, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        cardFieldViewManager.setDangerouslyGetFullCardDetails(cardFieldView, z);
    }

    @ReactProp(name = "dangerouslyGetFullCardDetails")
    public final void setDangerouslyGetFullCardDetails(CardFieldView cardFieldView, boolean z) {
        Intrinsics.checkNotNullParameter(cardFieldView, "view");
        cardFieldView.setDangerouslyGetFullCardDetails(z);
    }

    public static /* synthetic */ void setPostalCodeEnabled$default(CardFieldViewManager cardFieldViewManager, CardFieldView cardFieldView, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        cardFieldViewManager.setPostalCodeEnabled(cardFieldView, z);
    }

    @ReactProp(name = "postalCodeEnabled")
    public final void setPostalCodeEnabled(CardFieldView cardFieldView, boolean z) {
        Intrinsics.checkNotNullParameter(cardFieldView, "view");
        cardFieldView.setPostalCodeEnabled(z);
    }

    public static /* synthetic */ void setAutofocus$default(CardFieldViewManager cardFieldViewManager, CardFieldView cardFieldView, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        cardFieldViewManager.setAutofocus(cardFieldView, z);
    }

    @ReactProp(name = "autofocus")
    public final void setAutofocus(CardFieldView cardFieldView, boolean z) {
        Intrinsics.checkNotNullParameter(cardFieldView, "view");
        cardFieldView.setAutofocus(z);
    }

    @ReactProp(name = "cardStyle")
    public final void setCardStyle(CardFieldView cardFieldView, ReadableMap readableMap) {
        Intrinsics.checkNotNullParameter(cardFieldView, "view");
        Intrinsics.checkNotNullParameter(readableMap, "cardStyle");
        cardFieldView.setCardStyle(readableMap);
    }

    @ReactProp(name = "placeholder")
    public final void setPlaceHolders(CardFieldView cardFieldView, ReadableMap readableMap) {
        Intrinsics.checkNotNullParameter(cardFieldView, "view");
        Intrinsics.checkNotNullParameter(readableMap, ReactTextInputShadowNode.PROP_PLACEHOLDER);
        cardFieldView.setPlaceHolders(readableMap);
    }

    /* access modifiers changed from: protected */
    public CardFieldView createViewInstance(ThemedReactContext themedReactContext) {
        Intrinsics.checkNotNullParameter(themedReactContext, "reactContext");
        StripeSdkModule stripeSdkModule = (StripeSdkModule) themedReactContext.getNativeModule(StripeSdkModule.class);
        CardFieldView cardFieldView = new CardFieldView(themedReactContext);
        this.reactContextRef = themedReactContext;
        if (stripeSdkModule != null) {
            stripeSdkModule.setCardFieldView(cardFieldView);
        }
        return cardFieldView;
    }

    public void onDropViewInstance(CardFieldView cardFieldView) {
        Intrinsics.checkNotNullParameter(cardFieldView, "view");
        super.onDropViewInstance(cardFieldView);
        ThemedReactContext themedReactContext = this.reactContextRef;
        StripeSdkModule stripeSdkModule = themedReactContext == null ? null : (StripeSdkModule) themedReactContext.getNativeModule(StripeSdkModule.class);
        if (stripeSdkModule != null) {
            stripeSdkModule.setCardFieldView((CardFieldView) null);
        }
        this.reactContextRef = null;
    }
}
