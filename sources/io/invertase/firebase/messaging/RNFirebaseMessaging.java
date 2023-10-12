package io.invertase.firebase.messaging;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationManagerCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.braintreepayments.api.internal.GraphQLConstants;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.RemoteMessage;
import com.stripe.android.stripe3ds2.transactions.ChallengeRequestData;
import io.invertase.firebase.Utils;
import java.io.IOException;
import javax.annotation.Nonnull;

public class RNFirebaseMessaging extends ReactContextBaseJavaModule {
    private static final String TAG = "RNFirebaseMessaging";

    public String getName() {
        return TAG;
    }

    RNFirebaseMessaging(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        LocalBroadcastManager instance = LocalBroadcastManager.getInstance(reactApplicationContext);
        instance.registerReceiver(new MessageReceiver(), new IntentFilter(RNFirebaseMessagingService.MESSAGE_EVENT));
        instance.registerReceiver(new RefreshTokenReceiver(), new IntentFilter(RNFirebaseMessagingService.NEW_TOKEN_EVENT));
    }

    @ReactMethod
    public void getToken(Promise promise) {
        try {
            promise.resolve(FirebaseInstanceId.getInstance().getToken(FirebaseApp.getInstance().getOptions().getGcmSenderId(), FirebaseMessaging.INSTANCE_ID_SCOPE));
        } catch (Throwable th) {
            th.printStackTrace();
            promise.reject("messaging/fcm-token-error", th.getMessage());
        }
    }

    @ReactMethod
    public void deleteToken(Promise promise) {
        try {
            FirebaseInstanceId.getInstance().deleteToken(FirebaseApp.getInstance().getOptions().getGcmSenderId(), FirebaseMessaging.INSTANCE_ID_SCOPE);
            promise.resolve((Object) null);
        } catch (Throwable th) {
            th.printStackTrace();
            promise.reject("messaging/fcm-token-error", th.getMessage());
        }
    }

    @ReactMethod
    public void requestPermission(Promise promise) {
        promise.resolve((Object) null);
    }

    @ReactMethod
    public void hasPermission(Promise promise) {
        promise.resolve(Boolean.valueOf(NotificationManagerCompat.from(getReactApplicationContext()).areNotificationsEnabled()));
    }

    @ReactMethod
    public void sendMessage(ReadableMap readableMap, Promise promise) {
        if (!readableMap.hasKey(TypedValues.TransitionType.S_TO)) {
            promise.reject("messaging/invalid-message", "The supplied message is missing a 'to' field");
            return;
        }
        RemoteMessage.Builder builder = new RemoteMessage.Builder(readableMap.getString(TypedValues.TransitionType.S_TO));
        if (readableMap.hasKey("collapseKey")) {
            builder = builder.setCollapseKey(readableMap.getString("collapseKey"));
        }
        if (readableMap.hasKey("messageId")) {
            builder = builder.setMessageId(readableMap.getString("messageId"));
        }
        if (readableMap.hasKey(ChallengeRequestData.FIELD_MESSAGE_TYPE)) {
            builder = builder.setMessageType(readableMap.getString(ChallengeRequestData.FIELD_MESSAGE_TYPE));
        }
        if (readableMap.hasKey("ttl")) {
            builder = builder.setTtl(readableMap.getInt("ttl"));
        }
        if (readableMap.hasKey("data")) {
            ReadableMap map = readableMap.getMap("data");
            ReadableMapKeySetIterator keySetIterator = map.keySetIterator();
            while (keySetIterator.hasNextKey()) {
                String nextKey = keySetIterator.nextKey();
                builder = builder.addData(nextKey, map.getString(nextKey));
            }
        }
        FirebaseMessaging.getInstance().send(builder.build());
        promise.resolve((Object) null);
    }

    @ReactMethod
    public void subscribeToTopic(String str, final Promise promise) {
        FirebaseMessaging.getInstance().subscribeToTopic(str).addOnCompleteListener(new OnCompleteListener<Void>() {
            public void onComplete(@Nonnull Task<Void> task) {
                if (task.isSuccessful()) {
                    Log.d(RNFirebaseMessaging.TAG, "subscribeToTopic:onComplete:success");
                    promise.resolve((Object) null);
                    return;
                }
                Exception exception = task.getException();
                Log.e(RNFirebaseMessaging.TAG, "subscribeToTopic:onComplete:failure", exception);
                promise.reject((Throwable) exception);
            }
        });
    }

    @ReactMethod
    public void unsubscribeFromTopic(String str, final Promise promise) {
        FirebaseMessaging.getInstance().unsubscribeFromTopic(str).addOnCompleteListener(new OnCompleteListener<Void>() {
            public void onComplete(@Nonnull Task<Void> task) {
                if (task.isSuccessful()) {
                    Log.d(RNFirebaseMessaging.TAG, "unsubscribeFromTopic:onComplete:success");
                    promise.resolve((Object) null);
                    return;
                }
                Exception exception = task.getException();
                Log.e(RNFirebaseMessaging.TAG, "unsubscribeFromTopic:onComplete:failure", exception);
                promise.reject((Throwable) exception);
            }
        });
    }

    private class MessageReceiver extends BroadcastReceiver {
        private MessageReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if (RNFirebaseMessaging.this.getReactApplicationContext().hasActiveCatalystInstance()) {
                Log.d(RNFirebaseMessaging.TAG, "Received new message");
                Utils.sendEvent(RNFirebaseMessaging.this.getReactApplicationContext(), "messaging_message_received", MessagingSerializer.parseRemoteMessage((RemoteMessage) intent.getParcelableExtra(GraphQLConstants.Keys.MESSAGE)));
            }
        }
    }

    private class RefreshTokenReceiver extends BroadcastReceiver {
        private RefreshTokenReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if (RNFirebaseMessaging.this.getReactApplicationContext().hasActiveCatalystInstance()) {
                Log.d(RNFirebaseMessaging.TAG, "Received new messaging token.");
                new Thread(new Runnable() {
                    public void run() {
                        String str;
                        try {
                            str = FirebaseInstanceId.getInstance().getToken(FirebaseApp.getInstance().getOptions().getGcmSenderId(), FirebaseMessaging.INSTANCE_ID_SCOPE);
                        } catch (IOException e) {
                            Log.d(RNFirebaseMessaging.TAG, "onNewToken error", e);
                            str = null;
                        }
                        if (str != null) {
                            Log.d(RNFirebaseMessaging.TAG, "Sending new messaging token event.");
                            Utils.sendEvent(RNFirebaseMessaging.this.getReactApplicationContext(), "messaging_token_refreshed", str);
                        }
                    }
                }).start();
            }
        }
    }
}
