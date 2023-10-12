package io.invertase.firebase.notifications;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.RemoteInput;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.google.firebase.messaging.RemoteMessage;
import com.nimbusds.jose.HeaderParameterNames;
import io.invertase.firebase.Utils;
import io.invertase.firebase.messaging.RNFirebaseMessagingService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;
import me.leolin.shortcutbadger.ShortcutBadger;
import org.bouncycastle.i18n.MessageBundle;

public class RNFirebaseNotifications extends ReactContextBaseJavaModule implements ActivityEventListener {
    private static final String BADGE_FILE = "BadgeCountFile";
    private static final String BADGE_KEY = "BadgeCount";
    private static final String TAG = "RNFirebaseNotifications";
    private RNFirebaseNotificationManager notificationManager;
    private SharedPreferences sharedPreferences = null;

    public String getName() {
        return TAG;
    }

    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
    }

    RNFirebaseNotifications(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        reactApplicationContext.addActivityEventListener(this);
        this.notificationManager = new RNFirebaseNotificationManager(reactApplicationContext);
        this.sharedPreferences = reactApplicationContext.getSharedPreferences(BADGE_FILE, 0);
        LocalBroadcastManager instance = LocalBroadcastManager.getInstance(reactApplicationContext);
        instance.registerReceiver(new RemoteNotificationReceiver(), new IntentFilter(RNFirebaseMessagingService.REMOTE_NOTIFICATION_EVENT));
        instance.registerReceiver(new ScheduledNotificationReceiver(), new IntentFilter("notifications-scheduled-notification"));
    }

    @ReactMethod
    public void cancelAllNotifications(Promise promise) {
        this.notificationManager.cancelAllNotifications(promise);
    }

    @ReactMethod
    public void cancelNotification(String str, Promise promise) {
        this.notificationManager.cancelNotification(str, promise);
    }

    @ReactMethod
    public void displayNotification(ReadableMap readableMap, Promise promise) {
        this.notificationManager.displayNotification(readableMap, promise);
    }

    @ReactMethod
    public void getBadge(Promise promise) {
        int i = this.sharedPreferences.getInt(BADGE_KEY, 0);
        Log.d(TAG, "Got badge count: " + i);
        promise.resolve(Integer.valueOf(i));
    }

    @ReactMethod
    public void getInitialNotification(Promise promise) {
        promise.resolve(getCurrentActivity() != null ? parseIntentForNotification(getCurrentActivity().getIntent()) : null);
    }

    @ReactMethod
    public void getScheduledNotifications(Promise promise) {
        ArrayList<Bundle> scheduledNotifications = this.notificationManager.getScheduledNotifications();
        WritableArray createArray = Arguments.createArray();
        Iterator<Bundle> it = scheduledNotifications.iterator();
        while (it.hasNext()) {
            createArray.pushMap(parseNotificationBundle(it.next()));
        }
        promise.resolve(createArray);
    }

    @ReactMethod
    public void removeAllDeliveredNotifications(Promise promise) {
        this.notificationManager.removeAllDeliveredNotifications(promise);
    }

    @ReactMethod
    public void removeDeliveredNotification(String str, Promise promise) {
        this.notificationManager.removeDeliveredNotification(str, promise);
    }

    @ReactMethod
    public void removeDeliveredNotificationsByTag(String str, Promise promise) {
        this.notificationManager.removeDeliveredNotificationsByTag(str, promise);
    }

    @ReactMethod
    public void setBadge(int i, Promise promise) {
        this.sharedPreferences.edit().putInt(BADGE_KEY, i).apply();
        if (i == 0) {
            Log.d(TAG, "Remove badge count");
            ShortcutBadger.removeCount(getReactApplicationContext());
        } else {
            Log.d(TAG, "Apply badge count: " + i);
            ShortcutBadger.applyCount(getReactApplicationContext(), i);
        }
        promise.resolve((Object) null);
    }

    @ReactMethod
    public void scheduleNotification(ReadableMap readableMap, Promise promise) {
        this.notificationManager.scheduleNotification(readableMap, promise);
    }

    @ReactMethod
    public void createChannel(ReadableMap readableMap, Promise promise) {
        try {
            this.notificationManager.createChannel(readableMap);
        } catch (Throwable unused) {
        }
        promise.resolve((Object) null);
    }

    @ReactMethod
    public void createChannelGroup(ReadableMap readableMap, Promise promise) {
        try {
            this.notificationManager.createChannelGroup(readableMap);
        } catch (Throwable unused) {
        }
        promise.resolve((Object) null);
    }

    @ReactMethod
    public void createChannelGroups(ReadableArray readableArray, Promise promise) {
        try {
            this.notificationManager.createChannelGroups(readableArray);
        } catch (Throwable unused) {
        }
        promise.resolve((Object) null);
    }

    @ReactMethod
    public void createChannels(ReadableArray readableArray, Promise promise) {
        try {
            this.notificationManager.createChannels(readableArray);
        } catch (Throwable unused) {
        }
        promise.resolve((Object) null);
    }

    @ReactMethod
    public void deleteChannelGroup(String str, Promise promise) {
        try {
            this.notificationManager.deleteChannelGroup(str);
            promise.resolve((Object) null);
        } catch (NullPointerException unused) {
            promise.reject("notifications/channel-group-not-found", "The requested NotificationChannelGroup does not exist, have you created it?");
        }
    }

    @ReactMethod
    public void deleteChannel(String str, Promise promise) {
        try {
            this.notificationManager.deleteChannel(str);
        } catch (Throwable unused) {
        }
        promise.resolve((Object) null);
    }

    @ReactMethod
    public void getChannel(String str, Promise promise) {
        try {
            promise.resolve(this.notificationManager.getChannel(str));
        } catch (Throwable unused) {
            promise.resolve((Object) null);
        }
    }

    @ReactMethod
    public void getChannels(Promise promise) {
        try {
            promise.resolve(this.notificationManager.getChannels());
        } catch (Throwable unused) {
            promise.resolve(Collections.emptyList());
        }
    }

    @ReactMethod
    public void getChannelGroup(String str, Promise promise) {
        try {
            promise.resolve(this.notificationManager.getChannelGroup(str));
        } catch (Throwable unused) {
            promise.resolve((Object) null);
        }
    }

    @ReactMethod
    public void getChannelGroups(Promise promise) {
        try {
            promise.resolve(this.notificationManager.getChannelGroups());
        } catch (Throwable unused) {
            promise.resolve(Collections.emptyList());
        }
    }

    public void onNewIntent(Intent intent) {
        WritableMap parseIntentForNotification = parseIntentForNotification(intent);
        if (parseIntentForNotification != null) {
            Utils.sendEvent(getReactApplicationContext(), "notifications_notification_opened", parseIntentForNotification);
        }
    }

    private WritableMap parseIntentForNotification(Intent intent) {
        WritableMap parseIntentForRemoteNotification = parseIntentForRemoteNotification(intent);
        return parseIntentForRemoteNotification == null ? parseIntentForLocalNotification(intent) : parseIntentForRemoteNotification;
    }

    private WritableMap parseIntentForLocalNotification(Intent intent) {
        if (intent.getExtras() == null || !intent.hasExtra("notificationId")) {
            return null;
        }
        WritableNativeMap makeNativeMap = Arguments.makeNativeMap(intent.getExtras());
        WritableMap createMap = Arguments.createMap();
        createMap.putString("action", intent.getAction());
        createMap.putMap("notification", makeNativeMap);
        Bundle resultsFromIntent = RemoteInput.getResultsFromIntent(intent);
        if (resultsFromIntent != null) {
            createMap.putMap("results", Arguments.makeNativeMap(resultsFromIntent));
        }
        return createMap;
    }

    private WritableMap parseIntentForRemoteNotification(Intent intent) {
        if (intent.getExtras() == null || !intent.hasExtra("google.message_id")) {
            return null;
        }
        Bundle extras = intent.getExtras();
        WritableMap createMap = Arguments.createMap();
        WritableMap createMap2 = Arguments.createMap();
        for (String str : extras.keySet()) {
            if (str.equals("google.message_id")) {
                createMap.putString("notificationId", extras.getString(str));
            } else if (!str.equals("collapse_key") && !str.equals(TypedValues.TransitionType.S_FROM) && !str.equals("google.sent_time") && !str.equals("google.ttl") && !str.equals("_fbSourceApplicationHasBeenSet")) {
                createMap2.putString(str, extras.getString(str));
            }
        }
        createMap.putMap("data", createMap2);
        WritableMap createMap3 = Arguments.createMap();
        createMap3.putString("action", intent.getAction());
        createMap3.putMap("notification", createMap);
        return createMap3;
    }

    /* access modifiers changed from: private */
    public WritableMap parseNotificationBundle(Bundle bundle) {
        return Arguments.makeNativeMap(bundle);
    }

    /* access modifiers changed from: private */
    public WritableMap parseRemoteMessage(RemoteMessage remoteMessage) {
        RemoteMessage.Notification notification = remoteMessage.getNotification();
        WritableMap createMap = Arguments.createMap();
        WritableMap createMap2 = Arguments.createMap();
        String notificationBody = getNotificationBody(notification);
        if (notificationBody != null) {
            createMap.putString("body", notificationBody);
        }
        if (remoteMessage.getData() != null) {
            for (Map.Entry next : remoteMessage.getData().entrySet()) {
                createMap2.putString((String) next.getKey(), (String) next.getValue());
            }
        }
        createMap.putMap("data", createMap2);
        if (remoteMessage.getMessageId() != null) {
            createMap.putString("notificationId", remoteMessage.getMessageId());
        }
        if (notification.getSound() != null) {
            createMap.putString("sound", notification.getSound());
        }
        String notificationTitle = getNotificationTitle(notification);
        if (notificationTitle != null) {
            createMap.putString(MessageBundle.TITLE_ENTRY, notificationTitle);
        }
        WritableMap createMap3 = Arguments.createMap();
        if (notification.getClickAction() != null) {
            createMap3.putString("clickAction", notification.getClickAction());
        }
        if (notification.getColor() != null) {
            createMap3.putString("color", notification.getColor());
        }
        if (notification.getIcon() != null) {
            WritableMap createMap4 = Arguments.createMap();
            createMap4.putString("icon", notification.getIcon());
            createMap3.putMap("smallIcon", createMap4);
        }
        if (notification.getImageUrl() != null) {
            String uri = notification.getImageUrl().toString();
            WritableMap createMap5 = Arguments.createMap();
            createMap5.putString("picture", uri);
            createMap5.putNull("largeIcon");
            createMap3.putMap("bigPicture", createMap5);
            createMap3.putString("largeIcon", uri);
        }
        if (notification.getTag() != null) {
            createMap3.putString("group", notification.getTag());
            createMap3.putString(HeaderParameterNames.AUTHENTICATION_TAG, notification.getTag());
        }
        if (notification.getChannelId() != null) {
            createMap3.putString("channelId", notification.getChannelId());
        }
        createMap.putMap("android", createMap3);
        return createMap;
    }

    @Nullable
    private String getNotificationBody(RemoteMessage.Notification notification) {
        String body = notification.getBody();
        String bodyLocalizationKey = notification.getBodyLocalizationKey();
        if (bodyLocalizationKey == null) {
            return body;
        }
        String[] bodyLocalizationArgs = notification.getBodyLocalizationArgs();
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        return reactApplicationContext.getResources().getString(Utils.getResId(reactApplicationContext, bodyLocalizationKey), (Object[]) bodyLocalizationArgs);
    }

    @Nullable
    private String getNotificationTitle(RemoteMessage.Notification notification) {
        String title = notification.getTitle();
        String titleLocalizationKey = notification.getTitleLocalizationKey();
        if (titleLocalizationKey == null) {
            return title;
        }
        String[] titleLocalizationArgs = notification.getTitleLocalizationArgs();
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        return reactApplicationContext.getResources().getString(Utils.getResId(reactApplicationContext, titleLocalizationKey), (Object[]) titleLocalizationArgs);
    }

    private class RemoteNotificationReceiver extends BroadcastReceiver {
        private RemoteNotificationReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if (RNFirebaseNotifications.this.getReactApplicationContext().hasActiveCatalystInstance()) {
                Log.d(RNFirebaseNotifications.TAG, "Received new remote notification");
                Utils.sendEvent(RNFirebaseNotifications.this.getReactApplicationContext(), "notifications_notification_received", RNFirebaseNotifications.this.parseRemoteMessage((RemoteMessage) intent.getParcelableExtra("notification")));
            }
        }
    }

    private class ScheduledNotificationReceiver extends BroadcastReceiver {
        private ScheduledNotificationReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if (RNFirebaseNotifications.this.getReactApplicationContext().hasActiveCatalystInstance()) {
                Log.d(RNFirebaseNotifications.TAG, "Received new scheduled notification");
                Utils.sendEvent(RNFirebaseNotifications.this.getReactApplicationContext(), "notifications_notification_received", RNFirebaseNotifications.this.parseNotificationBundle(intent.getBundleExtra("notification")));
            }
        }
    }
}
