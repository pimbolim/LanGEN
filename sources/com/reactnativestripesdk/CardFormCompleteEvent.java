package com.reactnativestripesdk;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.stripe.android.model.parsers.AccountRangeJsonParser;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.lang3.StringUtils;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B3\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0002\u0010\fJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0002R\u001c\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/reactnativestripesdk/CardFormCompleteEvent;", "Lcom/facebook/react/uimanager/events/Event;", "Lcom/reactnativestripesdk/CardChangedEvent;", "viewTag", "", "cardDetails", "", "", "", "complete", "", "dangerouslyGetFullCardDetails", "(ILjava/util/Map;ZZ)V", "dispatch", "", "rctEventEmitter", "Lcom/facebook/react/uimanager/events/RCTEventEmitter;", "getEventName", "serializeEventData", "Lcom/facebook/react/bridge/WritableMap;", "Companion", "stripe_stripe-react-native_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CardFormCompleteEvent.kt */
public final class CardFormCompleteEvent extends Event<CardChangedEvent> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EVENT_NAME = "onFormComplete";
    private final Map<String, Object> cardDetails;
    private final boolean complete;
    private final boolean dangerouslyGetFullCardDetails;

    public String getEventName() {
        return EVENT_NAME;
    }

    public CardFormCompleteEvent(int i, Map<String, Object> map, boolean z, boolean z2) {
        super(i);
        this.cardDetails = map;
        this.complete = z;
        this.dangerouslyGetFullCardDetails = z2;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        Intrinsics.checkNotNullParameter(rCTEventEmitter, "rctEventEmitter");
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), serializeEventData());
    }

    private final WritableMap serializeEventData() {
        String obj;
        WritableMap createMap = Arguments.createMap();
        Map<String, Object> map = this.cardDetails;
        if (map == null) {
            Intrinsics.checkNotNullExpressionValue(createMap, "eventData");
            return createMap;
        }
        Object obj2 = map.get(AccountRangeJsonParser.FIELD_BRAND);
        String str = null;
        createMap.putString(AccountRangeJsonParser.FIELD_BRAND, obj2 == null ? null : obj2.toString());
        Object obj3 = this.cardDetails.get("last4");
        createMap.putString("last4", obj3 == null ? null : obj3.toString());
        Object obj4 = this.cardDetails.get("country");
        createMap.putString("country", obj4 == null ? null : obj4.toString());
        Object obj5 = this.cardDetails.get("expiryMonth");
        Objects.requireNonNull(obj5, "null cannot be cast to non-null type kotlin.Int");
        createMap.putInt("expiryMonth", ((Integer) obj5).intValue());
        Object obj6 = this.cardDetails.get("expiryYear");
        Objects.requireNonNull(obj6, "null cannot be cast to non-null type kotlin.Int");
        createMap.putInt("expiryYear", ((Integer) obj6).intValue());
        createMap.putBoolean("complete", this.complete);
        Object obj7 = this.cardDetails.get("postalCode");
        createMap.putString("postalCode", obj7 == null ? null : obj7.toString());
        if (this.dangerouslyGetFullCardDetails) {
            Object obj8 = this.cardDetails.get("number");
            if (!(obj8 == null || (obj = obj8.toString()) == null)) {
                str = StringsKt.replace$default(obj, StringUtils.SPACE, "", false, 4, (Object) null);
            }
            createMap.putString("number", str);
        }
        Intrinsics.checkNotNullExpressionValue(createMap, "eventData");
        return createMap;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/reactnativestripesdk/CardFormCompleteEvent$Companion;", "", "()V", "EVENT_NAME", "", "stripe_stripe-react-native_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: CardFormCompleteEvent.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
