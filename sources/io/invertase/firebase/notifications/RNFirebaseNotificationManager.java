package io.invertase.firebase.notifications;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Color;
import android.media.AudioAttributes;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import io.invertase.firebase.Utils;
import io.invertase.firebase.messaging.BundleJSONConverter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class RNFirebaseNotificationManager {
    private static final String PREFERENCES_KEY = "RNFNotifications";
    static final String SCHEDULED_NOTIFICATION_EVENT = "notifications-scheduled-notification";
    private static final String TAG = "RNFNotificationManager";
    private AlarmManager alarmManager;
    private Context context;
    private NotificationManager notificationManager;
    private SharedPreferences preferences;
    private ReactApplicationContext reactContext;

    RNFirebaseNotificationManager(ReactApplicationContext reactApplicationContext) {
        this(reactApplicationContext.getApplicationContext());
        this.reactContext = reactApplicationContext;
    }

    RNFirebaseNotificationManager(Context context2) {
        this.alarmManager = (AlarmManager) context2.getSystemService(NotificationCompat.CATEGORY_ALARM);
        this.context = context2;
        this.notificationManager = (NotificationManager) context2.getSystemService("notification");
        this.preferences = context2.getSharedPreferences(PREFERENCES_KEY, 0);
    }

    static int getResourceId(Context context2, String str, String str2) {
        return context2.getResources().getIdentifier(str2, str, context2.getPackageName());
    }

    static Uri getSound(Context context2, String str) {
        if (str == null) {
            return null;
        }
        if (str.contains("://")) {
            return Uri.parse(str);
        }
        if (str.equalsIgnoreCase("default")) {
            return RingtoneManager.getDefaultUri(2);
        }
        int resourceId = getResourceId(context2, "raw", str);
        if (resourceId == 0) {
            resourceId = getResourceId(context2, "raw", str.substring(0, str.lastIndexOf(46)));
        }
        return Uri.parse("android.resource://" + context2.getPackageName() + "/" + resourceId);
    }

    /* access modifiers changed from: package-private */
    public void cancelAllNotifications(Promise promise) {
        try {
            for (String cancelAlarm : this.preferences.getAll().keySet()) {
                cancelAlarm(cancelAlarm);
            }
            this.preferences.edit().clear().apply();
            promise.resolve((Object) null);
        } catch (SecurityException e) {
            Log.e(TAG, e.getMessage());
            promise.reject("notification/cancel_notifications_error", "Could not cancel notifications", (Throwable) e);
        }
    }

    /* access modifiers changed from: package-private */
    public void cancelNotification(String str, Promise promise) {
        try {
            cancelAlarm(str);
            this.preferences.edit().remove(str).apply();
            promise.resolve((Object) null);
        } catch (SecurityException e) {
            Log.e(TAG, e.getMessage());
            promise.reject("notification/cancel_notification_error", "Could not cancel notifications", (Throwable) e);
        }
    }

    /* access modifiers changed from: package-private */
    public void createChannel(ReadableMap readableMap) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.notificationManager.createNotificationChannel(parseChannelMap(readableMap));
        }
    }

    /* access modifiers changed from: package-private */
    public void createChannelGroup(ReadableMap readableMap) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.notificationManager.createNotificationChannelGroup(parseChannelGroupMap(readableMap));
        }
    }

    /* access modifiers changed from: package-private */
    public void createChannelGroups(ReadableArray readableArray) {
        if (Build.VERSION.SDK_INT >= 26) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < readableArray.size(); i++) {
                arrayList.add(parseChannelGroupMap(readableArray.getMap(i)));
            }
            this.notificationManager.createNotificationChannelGroups(arrayList);
        }
    }

    /* access modifiers changed from: package-private */
    public void createChannels(ReadableArray readableArray) {
        if (Build.VERSION.SDK_INT >= 26) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < readableArray.size(); i++) {
                arrayList.add(parseChannelMap(readableArray.getMap(i)));
            }
            this.notificationManager.createNotificationChannels(arrayList);
        }
    }

    /* access modifiers changed from: package-private */
    public void deleteChannelGroup(String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.notificationManager.deleteNotificationChannelGroup(str);
        }
    }

    /* access modifiers changed from: package-private */
    public void deleteChannel(String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.notificationManager.deleteNotificationChannel(str);
        }
    }

    /* access modifiers changed from: package-private */
    public void displayNotification(ReadableMap readableMap, Promise promise) {
        displayNotification(Arguments.toBundle(readableMap), promise);
    }

    /* access modifiers changed from: package-private */
    public void displayScheduledNotification(Bundle bundle) {
        if (!bundle.getBundle("schedule").containsKey("repeated") || !bundle.getBundle("schedule").getBoolean("repeated")) {
            this.preferences.edit().remove(bundle.getString("notificationId")).apply();
        }
        if (Utils.isAppInForeground(this.context)) {
            Intent intent = new Intent(SCHEDULED_NOTIFICATION_EVENT);
            intent.putExtra("notification", bundle);
            LocalBroadcastManager.getInstance(this.context).sendBroadcast(intent);
            return;
        }
        displayNotification(bundle, (Promise) null);
    }

    /* access modifiers changed from: package-private */
    public WritableMap getChannel(String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            return createChannelMap(this.notificationManager.getNotificationChannel(str));
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public WritableArray getChannels() {
        if (Build.VERSION.SDK_INT >= 26) {
            return createChannelsArray(this.notificationManager.getNotificationChannels());
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public WritableMap getChannelGroup(String str) {
        if (Build.VERSION.SDK_INT >= 28) {
            return createChannelGroupMap(this.notificationManager.getNotificationChannelGroup(str));
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public WritableArray getChannelGroups() {
        if (Build.VERSION.SDK_INT >= 26) {
            return createChannelGroupsArray(this.notificationManager.getNotificationChannelGroups());
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public ArrayList<Bundle> getScheduledNotifications() {
        ArrayList<Bundle> arrayList = new ArrayList<>();
        Map<String, ?> all = this.preferences.getAll();
        for (String str : all.keySet()) {
            try {
                arrayList.add(BundleJSONConverter.convertToBundle(new JSONObject((String) all.get(str))));
            } catch (JSONException e) {
                Log.e(TAG, e.getMessage());
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public void removeAllDeliveredNotifications(Promise promise) {
        this.notificationManager.cancelAll();
        promise.resolve((Object) null);
    }

    /* access modifiers changed from: package-private */
    public void removeDeliveredNotification(String str, Promise promise) {
        this.notificationManager.cancel(str.hashCode());
        promise.resolve((Object) null);
    }

    /* access modifiers changed from: package-private */
    public void removeDeliveredNotificationsByTag(String str, Promise promise) {
        if (Build.VERSION.SDK_INT >= 23) {
            for (StatusBarNotification statusBarNotification : this.notificationManager.getActiveNotifications()) {
                if (str.equals(statusBarNotification.getTag())) {
                    this.notificationManager.cancel(statusBarNotification.getTag(), statusBarNotification.getId());
                }
            }
        }
        promise.resolve((Object) null);
    }

    /* access modifiers changed from: package-private */
    public void rescheduleNotifications() {
        Iterator<Bundle> it = getScheduledNotifications().iterator();
        while (it.hasNext()) {
            scheduleNotification(it.next(), (Promise) null);
        }
    }

    /* access modifiers changed from: package-private */
    public void scheduleNotification(ReadableMap readableMap, Promise promise) {
        scheduleNotification(Arguments.toBundle(readableMap), promise);
    }

    private void cancelAlarm(String str) {
        this.alarmManager.cancel(PendingIntent.getBroadcast(this.context, str.hashCode(), new Intent(this.context, RNFirebaseNotificationReceiver.class), 134217728));
    }

    private void displayNotification(Bundle bundle, Promise promise) {
        new DisplayNotificationTask(this.context, this.reactContext, this.notificationManager, bundle, promise).execute(new Void[0]);
    }

    private NotificationChannelGroup parseChannelGroupMap(ReadableMap readableMap) {
        if (Build.VERSION.SDK_INT < 26) {
            return null;
        }
        NotificationChannelGroup notificationChannelGroup = new NotificationChannelGroup(readableMap.getString("groupId"), readableMap.getString("name"));
        if (Build.VERSION.SDK_INT >= 28 && readableMap.hasKey("description")) {
            notificationChannelGroup.setDescription(readableMap.getString("description"));
        }
        return notificationChannelGroup;
    }

    private String getFileName(Uri uri) {
        String str = null;
        if (uri.getScheme() == "content") {
            Cursor query = this.reactContext.getContentResolver().query(uri, (String[]) null, (String) null, (String[]) null, (String) null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        str = query.getString(query.getColumnIndexOrThrow("_display_name"));
                    }
                } catch (Throwable th) {
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
        }
        if (str == null && (str = uri.getPath()) != null) {
            int lastIndexOf = str.lastIndexOf(47);
            if (lastIndexOf != -1) {
                str = str.substring(lastIndexOf + 1);
            } else {
                str = "default";
            }
        }
        if (str.equals("notification_sound")) {
            return "default";
        }
        return str;
    }

    private WritableArray createChannelsArray(List<NotificationChannel> list) {
        WritableArray createArray = Arguments.createArray();
        if (Build.VERSION.SDK_INT >= 26) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                createArray.pushMap(createChannelMap(list.get(i)));
            }
        }
        return createArray;
    }

    private WritableArray createChannelGroupsArray(List<NotificationChannelGroup> list) {
        WritableArray createArray = Arguments.createArray();
        if (Build.VERSION.SDK_INT >= 26) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                createArray.pushMap(createChannelGroupMap(list.get(i)));
            }
        }
        return createArray;
    }

    private WritableMap createChannelGroupMap(NotificationChannelGroup notificationChannelGroup) {
        WritableMap createMap = Arguments.createMap();
        if (Build.VERSION.SDK_INT >= 26) {
            createMap.putString("groupId", notificationChannelGroup.getId());
            createMap.putString("name", notificationChannelGroup.getName().toString());
            createMap.putArray("channels", createChannelsArray(notificationChannelGroup.getChannels()));
            if (Build.VERSION.SDK_INT >= 28) {
                createMap.putString("description", notificationChannelGroup.getDescription());
            }
        }
        return createMap;
    }

    private WritableMap createChannelMap(NotificationChannel notificationChannel) {
        if (notificationChannel == null) {
            return null;
        }
        WritableMap createMap = Arguments.createMap();
        if (Build.VERSION.SDK_INT >= 26) {
            createMap.putString("channelId", notificationChannel.getId());
            createMap.putString("name", notificationChannel.getName().toString());
            createMap.putInt("importance", notificationChannel.getImportance());
            createMap.putString("description", notificationChannel.getDescription());
            createMap.putBoolean("bypassDnd", notificationChannel.canBypassDnd());
            createMap.putString("group", notificationChannel.getGroup());
            createMap.putString("lightColor", String.format("#%06X", new Object[]{Integer.valueOf(16777215 & notificationChannel.getLightColor())}));
            createMap.putBoolean("lightsEnabled", notificationChannel.shouldShowLights());
            int lockscreenVisibility = notificationChannel.getLockscreenVisibility();
            if (lockscreenVisibility == -1000) {
                createMap.putNull("lockScreenVisibility");
            } else {
                createMap.putInt("lockScreenVisibility", lockscreenVisibility);
            }
            createMap.putBoolean("showBadge", notificationChannel.canShowBadge());
            createMap.putString("sound", getFileName(notificationChannel.getSound()));
            createMap.putBoolean("vibrationEnabled", notificationChannel.shouldVibrate());
            long[] vibrationPattern = notificationChannel.getVibrationPattern();
            WritableArray createArray = Arguments.createArray();
            if (vibrationPattern != null) {
                for (long j : vibrationPattern) {
                    createArray.pushDouble((double) j);
                }
            }
            createMap.putArray("vibrationPattern", createArray);
        }
        return createMap;
    }

    private NotificationChannel parseChannelMap(ReadableMap readableMap) {
        if (Build.VERSION.SDK_INT < 26) {
            return null;
        }
        NotificationChannel notificationChannel = new NotificationChannel(readableMap.getString("channelId"), readableMap.getString("name"), readableMap.getInt("importance"));
        if (readableMap.hasKey("bypassDnd")) {
            notificationChannel.setBypassDnd(readableMap.getBoolean("bypassDnd"));
        }
        if (readableMap.hasKey("description")) {
            notificationChannel.setDescription(readableMap.getString("description"));
        }
        if (readableMap.hasKey("group")) {
            notificationChannel.setGroup(readableMap.getString("group"));
        }
        if (readableMap.hasKey("lightColor")) {
            notificationChannel.setLightColor(Color.parseColor(readableMap.getString("lightColor")));
        }
        if (readableMap.hasKey("lightsEnabled")) {
            notificationChannel.enableLights(readableMap.getBoolean("lightsEnabled"));
        }
        if (readableMap.hasKey("lockScreenVisibility")) {
            notificationChannel.setLockscreenVisibility(readableMap.getInt("lockScreenVisibility"));
        }
        if (readableMap.hasKey("showBadge")) {
            notificationChannel.setShowBadge(readableMap.getBoolean("showBadge"));
        }
        if (readableMap.hasKey("sound")) {
            notificationChannel.setSound(getSound(this.context, readableMap.getString("sound")), (AudioAttributes) null);
        }
        if (readableMap.hasKey("vibrationEnabled")) {
            notificationChannel.enableVibration(readableMap.getBoolean("vibrationEnabled"));
        }
        if (readableMap.hasKey("vibrationPattern")) {
            ReadableArray array = readableMap.getArray("vibrationPattern");
            long[] jArr = new long[array.size()];
            for (int i = 0; i < array.size(); i++) {
                jArr[i] = (long) array.getDouble(i);
            }
            notificationChannel.setVibrationPattern(jArr);
        }
        return notificationChannel;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v25, resolved type: java.lang.Long} */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0158, code lost:
        r7 = java.lang.Long.valueOf(r11.getTimeInMillis());
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void scheduleNotification(android.os.Bundle r21, @javax.annotation.Nullable com.facebook.react.bridge.Promise r22) {
        /*
            r20 = this;
            r1 = r20
            r0 = r21
            r2 = r22
            java.lang.String r3 = "notificationId"
            boolean r4 = r0.containsKey(r3)
            java.lang.String r5 = "notification/schedule_notification_error"
            java.lang.String r6 = "RNFNotificationManager"
            if (r4 != 0) goto L_0x001e
            java.lang.String r0 = "Missing notificationId"
            if (r2 != 0) goto L_0x001a
            android.util.Log.e(r6, r0)
            goto L_0x001d
        L_0x001a:
            r2.reject((java.lang.String) r5, (java.lang.String) r0)
        L_0x001d:
            return
        L_0x001e:
            java.lang.String r4 = "schedule"
            boolean r7 = r0.containsKey(r4)
            java.lang.String r8 = "Missing schedule information"
            if (r7 != 0) goto L_0x0032
            if (r2 != 0) goto L_0x002e
            android.util.Log.e(r6, r8)
            goto L_0x0031
        L_0x002e:
            r2.reject((java.lang.String) r5, (java.lang.String) r8)
        L_0x0031:
            return
        L_0x0032:
            java.lang.String r3 = r0.getString(r3)
            android.os.Bundle r4 = r0.getBundle(r4)
            r9 = -1
            java.lang.Long r7 = java.lang.Long.valueOf(r9)
            java.lang.String r11 = "fireDate"
            java.lang.Object r11 = r4.get(r11)
            boolean r12 = r11 instanceof java.lang.Long
            if (r12 == 0) goto L_0x004e
            r7 = r11
            java.lang.Long r7 = (java.lang.Long) r7
            goto L_0x005c
        L_0x004e:
            boolean r12 = r11 instanceof java.lang.Double
            if (r12 == 0) goto L_0x005c
            java.lang.Double r11 = (java.lang.Double) r11
            long r11 = r11.longValue()
            java.lang.Long r7 = java.lang.Long.valueOf(r11)
        L_0x005c:
            long r11 = r7.longValue()
            int r13 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r13 != 0) goto L_0x0070
            if (r2 != 0) goto L_0x006a
            android.util.Log.e(r6, r8)
            goto L_0x006f
        L_0x006a:
            java.lang.String r0 = "Missing fireDate information"
            r2.reject((java.lang.String) r5, (java.lang.String) r0)
        L_0x006f:
            return
        L_0x0070:
            org.json.JSONObject r8 = io.invertase.firebase.messaging.BundleJSONConverter.convertToJSON(r21)     // Catch:{ JSONException -> 0x022a }
            android.content.SharedPreferences r9 = r1.preferences     // Catch:{ JSONException -> 0x022a }
            android.content.SharedPreferences$Editor r9 = r9.edit()     // Catch:{ JSONException -> 0x022a }
            java.lang.String r8 = r8.toString()     // Catch:{ JSONException -> 0x022a }
            android.content.SharedPreferences$Editor r8 = r9.putString(r3, r8)     // Catch:{ JSONException -> 0x022a }
            r8.apply()     // Catch:{ JSONException -> 0x022a }
            android.content.Intent r8 = new android.content.Intent
            android.content.Context r9 = r1.context
            java.lang.Class<io.invertase.firebase.notifications.RNFirebaseNotificationReceiver> r10 = io.invertase.firebase.notifications.RNFirebaseNotificationReceiver.class
            r8.<init>(r9, r10)
            r8.putExtras(r0)
            android.content.Context r0 = r1.context
            int r3 = r3.hashCode()
            r9 = 134217728(0x8000000, float:3.85186E-34)
            android.app.PendingIntent r0 = android.app.PendingIntent.getBroadcast(r0, r3, r8, r9)
            java.lang.String r3 = "repeatInterval"
            boolean r8 = r4.containsKey(r3)
            if (r8 == 0) goto L_0x01f4
            long r11 = r7.longValue()
            long r13 = java.lang.System.currentTimeMillis()
            java.lang.String r8 = "week"
            java.lang.String r15 = "hour"
            java.lang.String r9 = "day"
            java.lang.String r10 = "minute"
            r17 = -1
            r18 = r0
            int r19 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r19 >= 0) goto L_0x0161
            java.lang.String r11 = "Scheduled notification date is in the past, will adjust it to be in future"
            android.util.Log.w(r6, r11)
            java.util.Calendar r11 = java.util.Calendar.getInstance()
            java.util.Calendar r12 = java.util.Calendar.getInstance()
            long r13 = r7.longValue()
            r12.setTimeInMillis(r13)
            r7 = 13
            r13 = 13
            int r13 = r12.get(r13)
            r11.set(r7, r13)
            java.lang.String r7 = r4.getString(r3)
            r7.hashCode()
            int r13 = r7.hashCode()
            switch(r13) {
                case -1074026988: goto L_0x0107;
                case 99228: goto L_0x00fe;
                case 3208676: goto L_0x00f5;
                case 3645428: goto L_0x00ec;
                default: goto L_0x00ea;
            }
        L_0x00ea:
            r7 = -1
            goto L_0x010f
        L_0x00ec:
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L_0x00f3
            goto L_0x00ea
        L_0x00f3:
            r7 = 3
            goto L_0x010f
        L_0x00f5:
            boolean r7 = r7.equals(r15)
            if (r7 != 0) goto L_0x00fc
            goto L_0x00ea
        L_0x00fc:
            r7 = 2
            goto L_0x010f
        L_0x00fe:
            boolean r7 = r7.equals(r9)
            if (r7 != 0) goto L_0x0105
            goto L_0x00ea
        L_0x0105:
            r7 = 1
            goto L_0x010f
        L_0x0107:
            boolean r7 = r7.equals(r10)
            if (r7 != 0) goto L_0x010e
            goto L_0x00ea
        L_0x010e:
            r7 = 0
        L_0x010f:
            r13 = 5
            r14 = 11
            r0 = 12
            switch(r7) {
                case 0: goto L_0x0154;
                case 1: goto L_0x0141;
                case 2: goto L_0x0133;
                case 3: goto L_0x0119;
                default: goto L_0x0117;
            }
        L_0x0117:
            r7 = 1
            goto L_0x0158
        L_0x0119:
            int r7 = r12.get(r0)
            r11.set(r0, r7)
            int r0 = r12.get(r14)
            r11.set(r14, r0)
            int r0 = r12.get(r13)
            r11.set(r13, r0)
            r0 = 7
            r11.add(r13, r0)
            goto L_0x0117
        L_0x0133:
            int r7 = r12.get(r0)
            r11.set(r0, r7)
            r0 = 10
            r7 = 1
            r11.add(r0, r7)
            goto L_0x0158
        L_0x0141:
            int r7 = r12.get(r0)
            r11.set(r0, r7)
            int r0 = r12.get(r14)
            r11.set(r14, r0)
            r7 = 1
            r11.add(r13, r7)
            goto L_0x0158
        L_0x0154:
            r7 = 1
            r11.add(r0, r7)
        L_0x0158:
            long r11 = r11.getTimeInMillis()
            java.lang.Long r0 = java.lang.Long.valueOf(r11)
            r7 = r0
        L_0x0161:
            r0 = 1
            java.lang.String r3 = r4.getString(r3)
            r3.hashCode()
            int r11 = r3.hashCode()
            switch(r11) {
                case -1074026988: goto L_0x018d;
                case 99228: goto L_0x0184;
                case 3208676: goto L_0x017b;
                case 3645428: goto L_0x0172;
                default: goto L_0x0170;
            }
        L_0x0170:
            r10 = -1
            goto L_0x0195
        L_0x0172:
            boolean r0 = r3.equals(r8)
            if (r0 != 0) goto L_0x0179
            goto L_0x0170
        L_0x0179:
            r10 = 3
            goto L_0x0195
        L_0x017b:
            boolean r0 = r3.equals(r15)
            if (r0 != 0) goto L_0x0182
            goto L_0x0170
        L_0x0182:
            r10 = 2
            goto L_0x0195
        L_0x0184:
            boolean r3 = r3.equals(r9)
            if (r3 != 0) goto L_0x018b
            goto L_0x0170
        L_0x018b:
            r10 = 1
            goto L_0x0195
        L_0x018d:
            boolean r0 = r3.equals(r10)
            if (r0 != 0) goto L_0x0194
            goto L_0x0170
        L_0x0194:
            r10 = 0
        L_0x0195:
            switch(r10) {
                case 0: goto L_0x01cc;
                case 1: goto L_0x01c4;
                case 2: goto L_0x01bc;
                case 3: goto L_0x01b4;
                default: goto L_0x0198;
            }
        L_0x0198:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "Invalid interval: "
            r0.append(r3)
            java.lang.String r3 = "interval"
            java.lang.String r3 = r4.getString(r3)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            android.util.Log.e(r6, r0)
            r0 = 0
            goto L_0x01d3
        L_0x01b4:
            r3 = 604800000(0x240c8400, double:2.988109026E-315)
            java.lang.Long r0 = java.lang.Long.valueOf(r3)
            goto L_0x01d3
        L_0x01bc:
            r3 = 3600000(0x36ee80, double:1.7786363E-317)
            java.lang.Long r0 = java.lang.Long.valueOf(r3)
            goto L_0x01d3
        L_0x01c4:
            r3 = 86400000(0x5265c00, double:4.2687272E-316)
            java.lang.Long r0 = java.lang.Long.valueOf(r3)
            goto L_0x01d3
        L_0x01cc:
            r3 = 60000(0xea60, double:2.9644E-319)
            java.lang.Long r0 = java.lang.Long.valueOf(r3)
        L_0x01d3:
            if (r0 != 0) goto L_0x01e3
            if (r2 != 0) goto L_0x01dd
            java.lang.String r0 = "Invalid interval"
            android.util.Log.e(r6, r0)
            goto L_0x01e2
        L_0x01dd:
            java.lang.String r0 = "Invalid interval"
            r2.reject((java.lang.String) r5, (java.lang.String) r0)
        L_0x01e2:
            return
        L_0x01e3:
            android.app.AlarmManager r10 = r1.alarmManager
            r11 = 0
            long r12 = r7.longValue()
            long r14 = r0.longValue()
            r16 = r18
            r10.setRepeating(r11, r12, r14, r16)
            goto L_0x0223
        L_0x01f4:
            r18 = r0
            java.lang.String r0 = "exact"
            boolean r3 = r4.containsKey(r0)
            if (r3 == 0) goto L_0x0217
            boolean r0 = r4.getBoolean(r0)
            if (r0 == 0) goto L_0x0217
            int r0 = android.os.Build.VERSION.SDK_INT
            r3 = 19
            if (r0 < r3) goto L_0x0217
            android.app.AlarmManager r0 = r1.alarmManager
            long r3 = r7.longValue()
            r5 = r18
            r6 = 0
            r0.setExact(r6, r3, r5)
            goto L_0x0223
        L_0x0217:
            r5 = r18
            r6 = 0
            android.app.AlarmManager r0 = r1.alarmManager
            long r3 = r7.longValue()
            r0.set(r6, r3, r5)
        L_0x0223:
            if (r2 == 0) goto L_0x0229
            r0 = 0
            r2.resolve(r0)
        L_0x0229:
            return
        L_0x022a:
            r0 = move-exception
            java.lang.String r3 = "Failed to store notification"
            if (r2 != 0) goto L_0x0233
            android.util.Log.e(r6, r3)
            goto L_0x0236
        L_0x0233:
            r2.reject((java.lang.String) r5, (java.lang.String) r3, (java.lang.Throwable) r0)
        L_0x0236:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.invertase.firebase.notifications.RNFirebaseNotificationManager.scheduleNotification(android.os.Bundle, com.facebook.react.bridge.Promise):void");
    }
}
