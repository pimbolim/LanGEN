package io.invertase.firebase.messaging;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.google.firebase.messaging.RemoteMessage;
import com.stripe.android.stripe3ds2.transactions.ChallengeRequestData;
import java.util.Map;

public class MessagingSerializer {
    public static WritableMap parseRemoteMessage(RemoteMessage remoteMessage) {
        WritableMap createMap = Arguments.createMap();
        WritableMap createMap2 = Arguments.createMap();
        if (remoteMessage.getCollapseKey() != null) {
            createMap.putString("collapseKey", remoteMessage.getCollapseKey());
        }
        if (remoteMessage.getData() != null) {
            for (Map.Entry next : remoteMessage.getData().entrySet()) {
                createMap2.putString((String) next.getKey(), (String) next.getValue());
            }
        }
        createMap.putMap("data", createMap2);
        if (remoteMessage.getFrom() != null) {
            createMap.putString(TypedValues.TransitionType.S_FROM, remoteMessage.getFrom());
        }
        if (remoteMessage.getMessageId() != null) {
            createMap.putString("messageId", remoteMessage.getMessageId());
        }
        if (remoteMessage.getMessageType() != null) {
            createMap.putString(ChallengeRequestData.FIELD_MESSAGE_TYPE, remoteMessage.getMessageType());
        }
        createMap.putDouble("sentTime", (double) remoteMessage.getSentTime());
        if (remoteMessage.getTo() != null) {
            createMap.putString(TypedValues.TransitionType.S_TO, remoteMessage.getTo());
        }
        createMap.putDouble("ttl", (double) remoteMessage.getTtl());
        return createMap;
    }
}
