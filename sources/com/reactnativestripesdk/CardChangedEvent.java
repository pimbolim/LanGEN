package com.reactnativestripesdk;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.stripe.android.model.parsers.AccountRangeJsonParser;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.lang3.StringUtils;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0014B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0002\u0010\fJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0002R\u001c\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/reactnativestripesdk/CardChangedEvent;", "Lcom/facebook/react/uimanager/events/Event;", "viewTag", "", "cardDetails", "", "", "", "postalCodeEnabled", "", "complete", "dangerouslyGetFullCardDetails", "(ILjava/util/Map;ZZZ)V", "dispatch", "", "rctEventEmitter", "Lcom/facebook/react/uimanager/events/RCTEventEmitter;", "getEventName", "serializeEventData", "Lcom/facebook/react/bridge/WritableMap;", "Companion", "stripe_stripe-react-native_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CardChangedEvent.kt */
public final class CardChangedEvent extends Event<CardChangedEvent> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EVENT_NAME = "onCardChange";
    private final Map<String, Object> cardDetails;
    private final boolean complete;
    private final boolean dangerouslyGetFullCardDetails;
    private final boolean postalCodeEnabled;

    public String getEventName() {
        return EVENT_NAME;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CardChangedEvent(int i, Map<String, Object> map, boolean z, boolean z2, boolean z3) {
        super(i);
        Intrinsics.checkNotNullParameter(map, "cardDetails");
        this.cardDetails = map;
        this.postalCodeEnabled = z;
        this.complete = z2;
        this.dangerouslyGetFullCardDetails = z3;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        Intrinsics.checkNotNullParameter(rCTEventEmitter, "rctEventEmitter");
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), serializeEventData());
    }

    private final WritableMap serializeEventData() {
        Unit unit;
        Unit unit2;
        String obj;
        WritableMap createMap = Arguments.createMap();
        Object obj2 = this.cardDetails.get(AccountRangeJsonParser.FIELD_BRAND);
        String str = null;
        createMap.putString(AccountRangeJsonParser.FIELD_BRAND, obj2 == null ? null : obj2.toString());
        Object obj3 = this.cardDetails.get("last4");
        createMap.putString("last4", obj3 == null ? null : obj3.toString());
        Integer num = (Integer) this.cardDetails.get("expiryMonth");
        if (num == null) {
            unit = null;
        } else {
            createMap.putInt("expiryMonth", num.intValue());
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            CardChangedEvent cardChangedEvent = this;
            createMap.putNull("expiryMonth");
        }
        Integer num2 = (Integer) this.cardDetails.get("expiryYear");
        if (num2 == null) {
            unit2 = null;
        } else {
            createMap.putInt("expiryYear", num2.intValue());
            unit2 = Unit.INSTANCE;
        }
        if (unit2 == null) {
            CardChangedEvent cardChangedEvent2 = this;
            createMap.putNull("expiryYear");
        }
        createMap.putBoolean("complete", this.complete);
        Object obj4 = this.cardDetails.get("validNumber");
        createMap.putString("validNumber", obj4 == null ? null : obj4.toString());
        Object obj5 = this.cardDetails.get("validCVC");
        createMap.putString("validCVC", obj5 == null ? null : obj5.toString());
        Object obj6 = this.cardDetails.get("validExpiryDate");
        createMap.putString("validExpiryDate", obj6 == null ? null : obj6.toString());
        if (this.postalCodeEnabled) {
            Object obj7 = this.cardDetails.get("postalCode");
            createMap.putString("postalCode", obj7 == null ? null : obj7.toString());
        }
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

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/reactnativestripesdk/CardChangedEvent$Companion;", "", "()V", "EVENT_NAME", "", "stripe_stripe-react-native_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: CardChangedEvent.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
