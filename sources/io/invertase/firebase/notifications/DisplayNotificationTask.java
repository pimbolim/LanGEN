package io.invertase.firebase.notifications;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.core.app.RemoteInput;
import com.adobe.xmp.options.PropertyOptions;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.bouncycastle.i18n.MessageBundle;
import org.bouncycastle.jcajce.util.AnnotatedPrivateKey;

public class DisplayNotificationTask extends AsyncTask<Void, Void, Void> {
    private static final String TAG = "DisplayNotificationTask";
    private final WeakReference<Context> contextWeakReference;
    private final Bundle notification;
    private final NotificationManager notificationManager;
    private final Promise promise;
    private final WeakReference<ReactApplicationContext> reactContextWeakReference;

    DisplayNotificationTask(Context context, ReactApplicationContext reactApplicationContext, NotificationManager notificationManager2, Bundle bundle, Promise promise2) {
        this.contextWeakReference = new WeakReference<>(context);
        this.reactContextWeakReference = new WeakReference<>(reactApplicationContext);
        this.promise = promise2;
        this.notification = bundle;
        this.notificationManager = notificationManager2;
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(Void voidR) {
        this.contextWeakReference.clear();
        this.reactContextWeakReference.clear();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(97:9|10|11|12|(5:13|14|15|16|17)|20|21|22|(1:24)|25|(1:27)|28|(1:30)|31|(1:33)|34|(1:36)|37|(1:39)|40|(3:44|45|46)|47|48|49|(10:51|52|(1:54)|55|(2:57|(1:59)(2:60|(1:62)))|63|(1:65)|66|(1:68)|69)|70|(5:72|(1:74)|75|(1:77)|78)|79|(1:81)|82|(1:84)|85|(2:89|90)|91|93|94|(1:96)|97|(3:99|(3:103|(2:106|104)|231)|107)|108|(1:110)|111|(3:115|116|117)|118|120|121|(1:123)|124|(1:128)|129|(1:131)|132|(1:134)|135|(1:137)|138|(1:140)|141|(1:143)|144|(3:148|(2:151|149)|232)|152|(1:154)|155|(1:157)|158|(1:160)|161|(3:165|166|167)|168|170|171|(1:173)|174|(2:176|(2:178|(1:180)(1:181)))|182|(1:184)|185|(1:187)|188|(1:190)|191|(1:193)|194|(4:198|(2:201|199)|233|202)|203|(1:205)|206|(1:208)|209|(3:211|(2:214|212)|234)|215|(1:217)(1:218)|219|(1:221)|222|(2:224|240)(1:238)) */
    /* JADX WARNING: Code restructure failed: missing block: B:225:0x0507, code lost:
        r0 = e;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x006f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00fc */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0217 A[Catch:{ Exception -> 0x0507 }] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0245 A[Catch:{ Exception -> 0x0507 }] */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x026b A[Catch:{ Exception -> 0x0507 }] */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x02a7 A[Catch:{ Exception -> 0x0507 }] */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x02b9 A[Catch:{ Exception -> 0x0507 }] */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x02d3 A[Catch:{ Exception -> 0x0507 }] */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x02e5 A[Catch:{ Exception -> 0x0507 }] */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x0309 A[Catch:{ Exception -> 0x0507 }, LOOP:1: B:149:0x0303->B:151:0x0309, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x031c A[Catch:{ Exception -> 0x0507 }] */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x0336 A[Catch:{ Exception -> 0x0507 }] */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x0366 A[Catch:{ Exception -> 0x0507 }] */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x038e A[Catch:{ Exception -> 0x0507 }] */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x03a0 A[Catch:{ Exception -> 0x0507 }] */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x03d9 A[Catch:{ Exception -> 0x0507 }] */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x03eb A[Catch:{ Exception -> 0x0507 }] */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x03fd A[Catch:{ Exception -> 0x0507 }] */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x0417 A[Catch:{ Exception -> 0x0507 }] */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x043e A[Catch:{ Exception -> 0x0507 }, LOOP:2: B:199:0x0438->B:201:0x043e, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x0459 A[Catch:{ Exception -> 0x0507 }] */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x0473 A[Catch:{ Exception -> 0x0507 }] */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x048d A[Catch:{ Exception -> 0x0507 }] */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x04be A[Catch:{ Exception -> 0x0507 }] */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x04c5 A[Catch:{ Exception -> 0x0507 }] */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x04eb A[Catch:{ Exception -> 0x0507 }] */
    /* JADX WARNING: Removed duplicated region for block: B:224:0x0502 A[Catch:{ Exception -> 0x0507 }] */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x0517  */
    /* JADX WARNING: Removed duplicated region for block: B:238:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:239:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0108 A[SYNTHETIC, Splitter:B:51:0x0108] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0163 A[Catch:{ Exception -> 0x0507 }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x019b A[Catch:{ Exception -> 0x0507 }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01a9 A[Catch:{ Exception -> 0x0507 }] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01d1 A[Catch:{ Exception -> 0x0507 }] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01e1 A[Catch:{ Exception -> 0x0507 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Void doInBackground(java.lang.Void... r24) {
        /*
            r23 = this;
            r1 = r23
            java.lang.String r0 = "group"
            java.lang.String r2 = "contentInfo"
            java.lang.String r3 = "colorized"
            java.lang.String r4 = "color"
            java.lang.String r5 = "category"
            java.lang.String r6 = "bigText"
            java.lang.String r7 = "bigPicture"
            java.lang.String r8 = "badgeIconType"
            java.lang.String r9 = "autoCancel"
            java.lang.String r10 = "title"
            java.lang.String r11 = "subtitle"
            java.lang.String r12 = "sound"
            java.lang.String r13 = "data"
            java.lang.String r14 = "body"
            java.lang.String r15 = "notification/display_notification_error"
            r24 = r0
            java.lang.String r0 = "progress"
            r16 = r0
            java.lang.String r0 = "defaults"
            r17 = r0
            java.lang.ref.WeakReference<android.content.Context> r0 = r1.contextWeakReference
            java.lang.Object r0 = r0.get()
            android.content.Context r0 = (android.content.Context) r0
            r18 = r2
            r2 = 0
            if (r0 != 0) goto L_0x0038
            return r2
        L_0x0038:
            java.lang.Class r2 = r1.getMainActivityClass(r0)     // Catch:{ Exception -> 0x0509 }
            if (r2 != 0) goto L_0x0049
            com.facebook.react.bridge.Promise r0 = r1.promise     // Catch:{ Exception -> 0x0509 }
            if (r0 == 0) goto L_0x0047
            java.lang.String r2 = "Could not find main activity class"
            r0.reject((java.lang.String) r15, (java.lang.String) r2)     // Catch:{ Exception -> 0x0509 }
        L_0x0047:
            r2 = 0
            return r2
        L_0x0049:
            r19 = r15
            android.os.Bundle r15 = r1.notification     // Catch:{ Exception -> 0x0507 }
            r20 = r2
            java.lang.String r2 = "android"
            android.os.Bundle r2 = r15.getBundle(r2)     // Catch:{ Exception -> 0x0507 }
            android.os.Bundle r15 = r1.notification     // Catch:{ Exception -> 0x0507 }
            r21 = r3
            java.lang.String r3 = "notificationId"
            java.lang.String r3 = r15.getString(r3)     // Catch:{ Exception -> 0x0507 }
            java.lang.String r15 = "channelId"
            java.lang.String r15 = r2.getString(r15)     // Catch:{ all -> 0x006d }
            r22 = r3
            androidx.core.app.NotificationCompat$Builder r3 = new androidx.core.app.NotificationCompat$Builder     // Catch:{ all -> 0x006f }
            r3.<init>((android.content.Context) r0, (java.lang.String) r15)     // Catch:{ all -> 0x006f }
            goto L_0x0074
        L_0x006d:
            r22 = r3
        L_0x006f:
            androidx.core.app.NotificationCompat$Builder r3 = new androidx.core.app.NotificationCompat$Builder     // Catch:{ Exception -> 0x0507 }
            r3.<init>(r0)     // Catch:{ Exception -> 0x0507 }
        L_0x0074:
            android.os.Bundle r15 = r1.notification     // Catch:{ Exception -> 0x0507 }
            boolean r15 = r15.containsKey(r14)     // Catch:{ Exception -> 0x0507 }
            if (r15 == 0) goto L_0x0086
            android.os.Bundle r15 = r1.notification     // Catch:{ Exception -> 0x0507 }
            java.lang.String r14 = r15.getString(r14)     // Catch:{ Exception -> 0x0507 }
            androidx.core.app.NotificationCompat$Builder r3 = r3.setContentText(r14)     // Catch:{ Exception -> 0x0507 }
        L_0x0086:
            android.os.Bundle r14 = r1.notification     // Catch:{ Exception -> 0x0507 }
            boolean r14 = r14.containsKey(r13)     // Catch:{ Exception -> 0x0507 }
            if (r14 == 0) goto L_0x0098
            android.os.Bundle r14 = r1.notification     // Catch:{ Exception -> 0x0507 }
            android.os.Bundle r13 = r14.getBundle(r13)     // Catch:{ Exception -> 0x0507 }
            androidx.core.app.NotificationCompat$Builder r3 = r3.setExtras(r13)     // Catch:{ Exception -> 0x0507 }
        L_0x0098:
            android.os.Bundle r13 = r1.notification     // Catch:{ Exception -> 0x0507 }
            boolean r13 = r13.containsKey(r12)     // Catch:{ Exception -> 0x0507 }
            if (r13 == 0) goto L_0x00ae
            android.os.Bundle r13 = r1.notification     // Catch:{ Exception -> 0x0507 }
            java.lang.String r12 = r13.getString(r12)     // Catch:{ Exception -> 0x0507 }
            android.net.Uri r12 = io.invertase.firebase.notifications.RNFirebaseNotificationManager.getSound(r0, r12)     // Catch:{ Exception -> 0x0507 }
            androidx.core.app.NotificationCompat$Builder r3 = r3.setSound(r12)     // Catch:{ Exception -> 0x0507 }
        L_0x00ae:
            android.os.Bundle r12 = r1.notification     // Catch:{ Exception -> 0x0507 }
            boolean r12 = r12.containsKey(r11)     // Catch:{ Exception -> 0x0507 }
            if (r12 == 0) goto L_0x00c0
            android.os.Bundle r12 = r1.notification     // Catch:{ Exception -> 0x0507 }
            java.lang.String r11 = r12.getString(r11)     // Catch:{ Exception -> 0x0507 }
            androidx.core.app.NotificationCompat$Builder r3 = r3.setSubText(r11)     // Catch:{ Exception -> 0x0507 }
        L_0x00c0:
            android.os.Bundle r11 = r1.notification     // Catch:{ Exception -> 0x0507 }
            boolean r11 = r11.containsKey(r10)     // Catch:{ Exception -> 0x0507 }
            if (r11 == 0) goto L_0x00d2
            android.os.Bundle r11 = r1.notification     // Catch:{ Exception -> 0x0507 }
            java.lang.String r10 = r11.getString(r10)     // Catch:{ Exception -> 0x0507 }
            androidx.core.app.NotificationCompat$Builder r3 = r3.setContentTitle(r10)     // Catch:{ Exception -> 0x0507 }
        L_0x00d2:
            boolean r10 = r2.containsKey(r9)     // Catch:{ Exception -> 0x0507 }
            if (r10 == 0) goto L_0x00e0
            boolean r9 = r2.getBoolean(r9)     // Catch:{ Exception -> 0x0507 }
            androidx.core.app.NotificationCompat$Builder r3 = r3.setAutoCancel(r9)     // Catch:{ Exception -> 0x0507 }
        L_0x00e0:
            boolean r9 = r2.containsKey(r8)     // Catch:{ Exception -> 0x0507 }
            r10 = 26
            if (r9 == 0) goto L_0x00fc
            int r9 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0507 }
            if (r9 < r10) goto L_0x00fc
            double r8 = r2.getDouble(r8)     // Catch:{ Exception -> 0x0507 }
            java.lang.Double r8 = java.lang.Double.valueOf(r8)     // Catch:{ Exception -> 0x0507 }
            int r8 = r8.intValue()     // Catch:{ all -> 0x00fc }
            androidx.core.app.NotificationCompat$Builder r3 = r3.setBadgeIconType(r8)     // Catch:{ all -> 0x00fc }
        L_0x00fc:
            boolean r8 = r2.containsKey(r7)     // Catch:{ Exception -> 0x0507 }
            java.lang.String r9 = "summaryText"
            java.lang.String r11 = "contentTitle"
            java.lang.String r12 = "largeIcon"
            if (r8 == 0) goto L_0x015d
            android.os.Bundle r7 = r2.getBundle(r7)     // Catch:{ Exception -> 0x0507 }
            androidx.core.app.NotificationCompat$BigPictureStyle r8 = new androidx.core.app.NotificationCompat$BigPictureStyle     // Catch:{ Exception -> 0x0507 }
            r8.<init>()     // Catch:{ Exception -> 0x0507 }
            java.lang.String r13 = "picture"
            java.lang.String r13 = r7.getString(r13)     // Catch:{ Exception -> 0x0507 }
            android.graphics.Bitmap r13 = r1.getBitmap(r13)     // Catch:{ Exception -> 0x0507 }
            if (r13 == 0) goto L_0x0121
            androidx.core.app.NotificationCompat$BigPictureStyle r8 = r8.bigPicture(r13)     // Catch:{ Exception -> 0x0507 }
        L_0x0121:
            boolean r13 = r7.containsKey(r12)     // Catch:{ Exception -> 0x0507 }
            if (r13 == 0) goto L_0x013d
            java.lang.String r13 = r7.getString(r12)     // Catch:{ Exception -> 0x0507 }
            if (r13 != 0) goto L_0x0133
            r14 = 0
            androidx.core.app.NotificationCompat$BigPictureStyle r8 = r8.bigLargeIcon(r14)     // Catch:{ Exception -> 0x0507 }
            goto L_0x013d
        L_0x0133:
            android.graphics.Bitmap r13 = r1.getBitmap(r13)     // Catch:{ Exception -> 0x0507 }
            if (r13 == 0) goto L_0x013d
            androidx.core.app.NotificationCompat$BigPictureStyle r8 = r8.bigLargeIcon(r13)     // Catch:{ Exception -> 0x0507 }
        L_0x013d:
            boolean r13 = r7.containsKey(r11)     // Catch:{ Exception -> 0x0507 }
            if (r13 == 0) goto L_0x014b
            java.lang.String r13 = r7.getString(r11)     // Catch:{ Exception -> 0x0507 }
            androidx.core.app.NotificationCompat$BigPictureStyle r8 = r8.setBigContentTitle(r13)     // Catch:{ Exception -> 0x0507 }
        L_0x014b:
            boolean r13 = r7.containsKey(r9)     // Catch:{ Exception -> 0x0507 }
            if (r13 == 0) goto L_0x0159
            java.lang.String r7 = r7.getString(r9)     // Catch:{ Exception -> 0x0507 }
            androidx.core.app.NotificationCompat$BigPictureStyle r8 = r8.setSummaryText(r7)     // Catch:{ Exception -> 0x0507 }
        L_0x0159:
            androidx.core.app.NotificationCompat$Builder r3 = r3.setStyle(r8)     // Catch:{ Exception -> 0x0507 }
        L_0x015d:
            boolean r7 = r2.containsKey(r6)     // Catch:{ Exception -> 0x0507 }
            if (r7 == 0) goto L_0x0195
            android.os.Bundle r6 = r2.getBundle(r6)     // Catch:{ Exception -> 0x0507 }
            androidx.core.app.NotificationCompat$BigTextStyle r7 = new androidx.core.app.NotificationCompat$BigTextStyle     // Catch:{ Exception -> 0x0507 }
            r7.<init>()     // Catch:{ Exception -> 0x0507 }
            java.lang.String r8 = "text"
            java.lang.String r8 = r6.getString(r8)     // Catch:{ Exception -> 0x0507 }
            r7.bigText(r8)     // Catch:{ Exception -> 0x0507 }
            boolean r8 = r6.containsKey(r11)     // Catch:{ Exception -> 0x0507 }
            if (r8 == 0) goto L_0x0183
            java.lang.String r8 = r6.getString(r11)     // Catch:{ Exception -> 0x0507 }
            androidx.core.app.NotificationCompat$BigTextStyle r7 = r7.setBigContentTitle(r8)     // Catch:{ Exception -> 0x0507 }
        L_0x0183:
            boolean r8 = r6.containsKey(r9)     // Catch:{ Exception -> 0x0507 }
            if (r8 == 0) goto L_0x0191
            java.lang.String r6 = r6.getString(r9)     // Catch:{ Exception -> 0x0507 }
            androidx.core.app.NotificationCompat$BigTextStyle r7 = r7.setSummaryText(r6)     // Catch:{ Exception -> 0x0507 }
        L_0x0191:
            androidx.core.app.NotificationCompat$Builder r3 = r3.setStyle(r7)     // Catch:{ Exception -> 0x0507 }
        L_0x0195:
            boolean r6 = r2.containsKey(r5)     // Catch:{ Exception -> 0x0507 }
            if (r6 == 0) goto L_0x01a3
            java.lang.String r5 = r2.getString(r5)     // Catch:{ Exception -> 0x0507 }
            androidx.core.app.NotificationCompat$Builder r3 = r3.setCategory(r5)     // Catch:{ Exception -> 0x0507 }
        L_0x01a3:
            boolean r5 = r2.containsKey(r4)     // Catch:{ Exception -> 0x0507 }
            if (r5 == 0) goto L_0x01b5
            java.lang.String r4 = r2.getString(r4)     // Catch:{ Exception -> 0x0507 }
            int r4 = android.graphics.Color.parseColor(r4)     // Catch:{ Exception -> 0x0507 }
            androidx.core.app.NotificationCompat$Builder r3 = r3.setColor(r4)     // Catch:{ Exception -> 0x0507 }
        L_0x01b5:
            r4 = r21
            boolean r5 = r2.containsKey(r4)     // Catch:{ Exception -> 0x0507 }
            if (r5 == 0) goto L_0x01c9
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0507 }
            if (r5 < r10) goto L_0x01c9
            boolean r4 = r2.getBoolean(r4)     // Catch:{ all -> 0x01c9 }
            androidx.core.app.NotificationCompat$Builder r3 = r3.setColorized(r4)     // Catch:{ all -> 0x01c9 }
        L_0x01c9:
            r4 = r18
            boolean r5 = r2.containsKey(r4)     // Catch:{ Exception -> 0x0507 }
            if (r5 == 0) goto L_0x01d9
            java.lang.String r4 = r2.getString(r4)     // Catch:{ Exception -> 0x0507 }
            androidx.core.app.NotificationCompat$Builder r3 = r3.setContentInfo(r4)     // Catch:{ Exception -> 0x0507 }
        L_0x01d9:
            r4 = r17
            boolean r5 = r2.containsKey(r4)     // Catch:{ Exception -> 0x0507 }
            if (r5 == 0) goto L_0x020f
            double r5 = r2.getDouble(r4)     // Catch:{ Exception -> 0x0507 }
            java.lang.Double r5 = java.lang.Double.valueOf(r5)     // Catch:{ Exception -> 0x0507 }
            int r5 = r5.intValue()     // Catch:{ Exception -> 0x0507 }
            if (r5 != 0) goto L_0x020b
            java.util.ArrayList r4 = r2.getIntegerArrayList(r4)     // Catch:{ Exception -> 0x0507 }
            if (r4 == 0) goto L_0x020b
            java.util.Iterator r4 = r4.iterator()     // Catch:{ Exception -> 0x0507 }
        L_0x01f9:
            boolean r6 = r4.hasNext()     // Catch:{ Exception -> 0x0507 }
            if (r6 == 0) goto L_0x020b
            java.lang.Object r6 = r4.next()     // Catch:{ Exception -> 0x0507 }
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ Exception -> 0x0507 }
            int r6 = r6.intValue()     // Catch:{ Exception -> 0x0507 }
            r5 = r5 | r6
            goto L_0x01f9
        L_0x020b:
            androidx.core.app.NotificationCompat$Builder r3 = r3.setDefaults(r5)     // Catch:{ Exception -> 0x0507 }
        L_0x020f:
            r4 = r24
            boolean r5 = r2.containsKey(r4)     // Catch:{ Exception -> 0x0507 }
            if (r5 == 0) goto L_0x021f
            java.lang.String r4 = r2.getString(r4)     // Catch:{ Exception -> 0x0507 }
            androidx.core.app.NotificationCompat$Builder r3 = r3.setGroup(r4)     // Catch:{ Exception -> 0x0507 }
        L_0x021f:
            java.lang.String r4 = "groupAlertBehaviour"
            boolean r4 = r2.containsKey(r4)     // Catch:{ Exception -> 0x0507 }
            if (r4 == 0) goto L_0x023d
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0507 }
            if (r4 < r10) goto L_0x023d
            java.lang.String r4 = "groupAlertBehaviour"
            double r4 = r2.getDouble(r4)     // Catch:{ Exception -> 0x0507 }
            java.lang.Double r4 = java.lang.Double.valueOf(r4)     // Catch:{ Exception -> 0x0507 }
            int r4 = r4.intValue()     // Catch:{ all -> 0x023d }
            androidx.core.app.NotificationCompat$Builder r3 = r3.setGroupAlertBehavior(r4)     // Catch:{ all -> 0x023d }
        L_0x023d:
            java.lang.String r4 = "groupSummary"
            boolean r4 = r2.containsKey(r4)     // Catch:{ Exception -> 0x0507 }
            if (r4 == 0) goto L_0x024f
            java.lang.String r4 = "groupSummary"
            boolean r4 = r2.getBoolean(r4)     // Catch:{ Exception -> 0x0507 }
            androidx.core.app.NotificationCompat$Builder r3 = r3.setGroupSummary(r4)     // Catch:{ Exception -> 0x0507 }
        L_0x024f:
            boolean r4 = r2.containsKey(r12)     // Catch:{ Exception -> 0x0507 }
            if (r4 == 0) goto L_0x0263
            java.lang.String r4 = r2.getString(r12)     // Catch:{ Exception -> 0x0507 }
            android.graphics.Bitmap r4 = r1.getBitmap(r4)     // Catch:{ Exception -> 0x0507 }
            if (r4 == 0) goto L_0x0263
            androidx.core.app.NotificationCompat$Builder r3 = r3.setLargeIcon(r4)     // Catch:{ Exception -> 0x0507 }
        L_0x0263:
            java.lang.String r4 = "lights"
            boolean r4 = r2.containsKey(r4)     // Catch:{ Exception -> 0x0507 }
            if (r4 == 0) goto L_0x029f
            java.lang.String r4 = "lights"
            android.os.Bundle r4 = r2.getBundle(r4)     // Catch:{ Exception -> 0x0507 }
            java.lang.String r5 = "argb"
            double r5 = r4.getDouble(r5)     // Catch:{ Exception -> 0x0507 }
            java.lang.Double r5 = java.lang.Double.valueOf(r5)     // Catch:{ Exception -> 0x0507 }
            java.lang.String r6 = "onMs"
            double r6 = r4.getDouble(r6)     // Catch:{ Exception -> 0x0507 }
            java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch:{ Exception -> 0x0507 }
            java.lang.String r7 = "offMs"
            double r7 = r4.getDouble(r7)     // Catch:{ Exception -> 0x0507 }
            java.lang.Double r4 = java.lang.Double.valueOf(r7)     // Catch:{ Exception -> 0x0507 }
            int r5 = r5.intValue()     // Catch:{ Exception -> 0x0507 }
            int r6 = r6.intValue()     // Catch:{ Exception -> 0x0507 }
            int r4 = r4.intValue()     // Catch:{ Exception -> 0x0507 }
            androidx.core.app.NotificationCompat$Builder r3 = r3.setLights(r5, r6, r4)     // Catch:{ Exception -> 0x0507 }
        L_0x029f:
            java.lang.String r4 = "localOnly"
            boolean r4 = r2.containsKey(r4)     // Catch:{ Exception -> 0x0507 }
            if (r4 == 0) goto L_0x02b1
            java.lang.String r4 = "localOnly"
            boolean r4 = r2.getBoolean(r4)     // Catch:{ Exception -> 0x0507 }
            androidx.core.app.NotificationCompat$Builder r3 = r3.setLocalOnly(r4)     // Catch:{ Exception -> 0x0507 }
        L_0x02b1:
            java.lang.String r4 = "number"
            boolean r4 = r2.containsKey(r4)     // Catch:{ Exception -> 0x0507 }
            if (r4 == 0) goto L_0x02cb
            java.lang.String r4 = "number"
            double r4 = r2.getDouble(r4)     // Catch:{ Exception -> 0x0507 }
            java.lang.Double r4 = java.lang.Double.valueOf(r4)     // Catch:{ Exception -> 0x0507 }
            int r4 = r4.intValue()     // Catch:{ Exception -> 0x0507 }
            androidx.core.app.NotificationCompat$Builder r3 = r3.setNumber(r4)     // Catch:{ Exception -> 0x0507 }
        L_0x02cb:
            java.lang.String r4 = "ongoing"
            boolean r4 = r2.containsKey(r4)     // Catch:{ Exception -> 0x0507 }
            if (r4 == 0) goto L_0x02dd
            java.lang.String r4 = "ongoing"
            boolean r4 = r2.getBoolean(r4)     // Catch:{ Exception -> 0x0507 }
            androidx.core.app.NotificationCompat$Builder r3 = r3.setOngoing(r4)     // Catch:{ Exception -> 0x0507 }
        L_0x02dd:
            java.lang.String r4 = "onlyAlertOnce"
            boolean r4 = r2.containsKey(r4)     // Catch:{ Exception -> 0x0507 }
            if (r4 == 0) goto L_0x02ef
            java.lang.String r4 = "onlyAlertOnce"
            boolean r4 = r2.getBoolean(r4)     // Catch:{ Exception -> 0x0507 }
            androidx.core.app.NotificationCompat$Builder r3 = r3.setOnlyAlertOnce(r4)     // Catch:{ Exception -> 0x0507 }
        L_0x02ef:
            java.lang.String r4 = "people"
            boolean r4 = r2.containsKey(r4)     // Catch:{ Exception -> 0x0507 }
            if (r4 == 0) goto L_0x0314
            java.lang.String r4 = "people"
            java.util.ArrayList r4 = r2.getStringArrayList(r4)     // Catch:{ Exception -> 0x0507 }
            if (r4 == 0) goto L_0x0314
            java.util.Iterator r4 = r4.iterator()     // Catch:{ Exception -> 0x0507 }
        L_0x0303:
            boolean r5 = r4.hasNext()     // Catch:{ Exception -> 0x0507 }
            if (r5 == 0) goto L_0x0314
            java.lang.Object r5 = r4.next()     // Catch:{ Exception -> 0x0507 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0507 }
            androidx.core.app.NotificationCompat$Builder r3 = r3.addPerson((java.lang.String) r5)     // Catch:{ Exception -> 0x0507 }
            goto L_0x0303
        L_0x0314:
            java.lang.String r4 = "priority"
            boolean r4 = r2.containsKey(r4)     // Catch:{ Exception -> 0x0507 }
            if (r4 == 0) goto L_0x032e
            java.lang.String r4 = "priority"
            double r4 = r2.getDouble(r4)     // Catch:{ Exception -> 0x0507 }
            java.lang.Double r4 = java.lang.Double.valueOf(r4)     // Catch:{ Exception -> 0x0507 }
            int r4 = r4.intValue()     // Catch:{ Exception -> 0x0507 }
            androidx.core.app.NotificationCompat$Builder r3 = r3.setPriority(r4)     // Catch:{ Exception -> 0x0507 }
        L_0x032e:
            r4 = r16
            boolean r5 = r2.containsKey(r4)     // Catch:{ Exception -> 0x0507 }
            if (r5 == 0) goto L_0x035e
            android.os.Bundle r5 = r2.getBundle(r4)     // Catch:{ Exception -> 0x0507 }
            java.lang.String r6 = "max"
            double r6 = r5.getDouble(r6)     // Catch:{ Exception -> 0x0507 }
            java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch:{ Exception -> 0x0507 }
            double r7 = r5.getDouble(r4)     // Catch:{ Exception -> 0x0507 }
            java.lang.Double r4 = java.lang.Double.valueOf(r7)     // Catch:{ Exception -> 0x0507 }
            int r6 = r6.intValue()     // Catch:{ Exception -> 0x0507 }
            int r4 = r4.intValue()     // Catch:{ Exception -> 0x0507 }
            java.lang.String r7 = "indeterminate"
            boolean r5 = r5.getBoolean(r7)     // Catch:{ Exception -> 0x0507 }
            androidx.core.app.NotificationCompat$Builder r3 = r3.setProgress(r6, r4, r5)     // Catch:{ Exception -> 0x0507 }
        L_0x035e:
            java.lang.String r4 = "remoteInputHistory"
            boolean r4 = r2.containsKey(r4)     // Catch:{ Exception -> 0x0507 }
            if (r4 == 0) goto L_0x0370
            java.lang.String r4 = "remoteInputHistory"
            java.lang.String[] r4 = r2.getStringArray(r4)     // Catch:{ Exception -> 0x0507 }
            androidx.core.app.NotificationCompat$Builder r3 = r3.setRemoteInputHistory(r4)     // Catch:{ Exception -> 0x0507 }
        L_0x0370:
            java.lang.String r4 = "shortcutId"
            boolean r4 = r2.containsKey(r4)     // Catch:{ Exception -> 0x0507 }
            if (r4 == 0) goto L_0x0386
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0507 }
            if (r4 < r10) goto L_0x0386
            java.lang.String r4 = "shortcutId"
            java.lang.String r4 = r2.getString(r4)     // Catch:{ all -> 0x0386 }
            androidx.core.app.NotificationCompat$Builder r3 = r3.setShortcutId(r4)     // Catch:{ all -> 0x0386 }
        L_0x0386:
            java.lang.String r4 = "showWhen"
            boolean r4 = r2.containsKey(r4)     // Catch:{ Exception -> 0x0507 }
            if (r4 == 0) goto L_0x0398
            java.lang.String r4 = "showWhen"
            boolean r4 = r2.getBoolean(r4)     // Catch:{ Exception -> 0x0507 }
            androidx.core.app.NotificationCompat$Builder r3 = r3.setShowWhen(r4)     // Catch:{ Exception -> 0x0507 }
        L_0x0398:
            java.lang.String r4 = "smallIcon"
            boolean r4 = r2.containsKey(r4)     // Catch:{ Exception -> 0x0507 }
            if (r4 == 0) goto L_0x03d1
            java.lang.String r4 = "smallIcon"
            android.os.Bundle r4 = r2.getBundle(r4)     // Catch:{ Exception -> 0x0507 }
            java.lang.String r5 = "icon"
            java.lang.String r5 = r4.getString(r5)     // Catch:{ Exception -> 0x0507 }
            int r5 = r1.getIcon(r5)     // Catch:{ Exception -> 0x0507 }
            if (r5 == 0) goto L_0x03d1
            java.lang.String r6 = "level"
            boolean r6 = r4.containsKey(r6)     // Catch:{ Exception -> 0x0507 }
            if (r6 == 0) goto L_0x03cd
            java.lang.String r6 = "level"
            double r6 = r4.getDouble(r6)     // Catch:{ Exception -> 0x0507 }
            java.lang.Double r4 = java.lang.Double.valueOf(r6)     // Catch:{ Exception -> 0x0507 }
            int r4 = r4.intValue()     // Catch:{ Exception -> 0x0507 }
            androidx.core.app.NotificationCompat$Builder r3 = r3.setSmallIcon(r5, r4)     // Catch:{ Exception -> 0x0507 }
            goto L_0x03d1
        L_0x03cd:
            androidx.core.app.NotificationCompat$Builder r3 = r3.setSmallIcon((int) r5)     // Catch:{ Exception -> 0x0507 }
        L_0x03d1:
            java.lang.String r4 = "sortKey"
            boolean r4 = r2.containsKey(r4)     // Catch:{ Exception -> 0x0507 }
            if (r4 == 0) goto L_0x03e3
            java.lang.String r4 = "sortKey"
            java.lang.String r4 = r2.getString(r4)     // Catch:{ Exception -> 0x0507 }
            androidx.core.app.NotificationCompat$Builder r3 = r3.setSortKey(r4)     // Catch:{ Exception -> 0x0507 }
        L_0x03e3:
            java.lang.String r4 = "ticker"
            boolean r4 = r2.containsKey(r4)     // Catch:{ Exception -> 0x0507 }
            if (r4 == 0) goto L_0x03f5
            java.lang.String r4 = "ticker"
            java.lang.String r4 = r2.getString(r4)     // Catch:{ Exception -> 0x0507 }
            androidx.core.app.NotificationCompat$Builder r3 = r3.setTicker(r4)     // Catch:{ Exception -> 0x0507 }
        L_0x03f5:
            java.lang.String r4 = "timeoutAfter"
            boolean r4 = r2.containsKey(r4)     // Catch:{ Exception -> 0x0507 }
            if (r4 == 0) goto L_0x040f
            java.lang.String r4 = "timeoutAfter"
            double r4 = r2.getDouble(r4)     // Catch:{ Exception -> 0x0507 }
            java.lang.Double r4 = java.lang.Double.valueOf(r4)     // Catch:{ Exception -> 0x0507 }
            long r4 = r4.longValue()     // Catch:{ Exception -> 0x0507 }
            androidx.core.app.NotificationCompat$Builder r3 = r3.setTimeoutAfter(r4)     // Catch:{ Exception -> 0x0507 }
        L_0x040f:
            java.lang.String r4 = "usesChronometer"
            boolean r4 = r2.containsKey(r4)     // Catch:{ Exception -> 0x0507 }
            if (r4 == 0) goto L_0x0421
            java.lang.String r4 = "usesChronometer"
            boolean r4 = r2.getBoolean(r4)     // Catch:{ Exception -> 0x0507 }
            androidx.core.app.NotificationCompat$Builder r3 = r3.setUsesChronometer(r4)     // Catch:{ Exception -> 0x0507 }
        L_0x0421:
            java.lang.String r4 = "vibrate"
            boolean r4 = r2.containsKey(r4)     // Catch:{ Exception -> 0x0507 }
            if (r4 == 0) goto L_0x0451
            java.lang.String r4 = "vibrate"
            java.util.ArrayList r4 = r2.getIntegerArrayList(r4)     // Catch:{ Exception -> 0x0507 }
            if (r4 == 0) goto L_0x0451
            int r5 = r4.size()     // Catch:{ Exception -> 0x0507 }
            long[] r5 = new long[r5]     // Catch:{ Exception -> 0x0507 }
            r6 = 0
        L_0x0438:
            int r7 = r4.size()     // Catch:{ Exception -> 0x0507 }
            if (r6 >= r7) goto L_0x044d
            java.lang.Object r7 = r4.get(r6)     // Catch:{ Exception -> 0x0507 }
            java.lang.Integer r7 = (java.lang.Integer) r7     // Catch:{ Exception -> 0x0507 }
            long r7 = r7.longValue()     // Catch:{ Exception -> 0x0507 }
            r5[r6] = r7     // Catch:{ Exception -> 0x0507 }
            int r6 = r6 + 1
            goto L_0x0438
        L_0x044d:
            androidx.core.app.NotificationCompat$Builder r3 = r3.setVibrate(r5)     // Catch:{ Exception -> 0x0507 }
        L_0x0451:
            java.lang.String r4 = "visibility"
            boolean r4 = r2.containsKey(r4)     // Catch:{ Exception -> 0x0507 }
            if (r4 == 0) goto L_0x046b
            java.lang.String r4 = "visibility"
            double r4 = r2.getDouble(r4)     // Catch:{ Exception -> 0x0507 }
            java.lang.Double r4 = java.lang.Double.valueOf(r4)     // Catch:{ Exception -> 0x0507 }
            int r4 = r4.intValue()     // Catch:{ Exception -> 0x0507 }
            androidx.core.app.NotificationCompat$Builder r3 = r3.setVisibility(r4)     // Catch:{ Exception -> 0x0507 }
        L_0x046b:
            java.lang.String r4 = "when"
            boolean r4 = r2.containsKey(r4)     // Catch:{ Exception -> 0x0507 }
            if (r4 == 0) goto L_0x0485
            java.lang.String r4 = "when"
            double r4 = r2.getDouble(r4)     // Catch:{ Exception -> 0x0507 }
            java.lang.Double r4 = java.lang.Double.valueOf(r4)     // Catch:{ Exception -> 0x0507 }
            long r4 = r4.longValue()     // Catch:{ Exception -> 0x0507 }
            androidx.core.app.NotificationCompat$Builder r3 = r3.setWhen(r4)     // Catch:{ Exception -> 0x0507 }
        L_0x0485:
            java.lang.String r4 = "actions"
            boolean r4 = r2.containsKey(r4)     // Catch:{ Exception -> 0x0507 }
            if (r4 == 0) goto L_0x04b4
            java.lang.String r4 = "actions"
            java.io.Serializable r4 = r2.getSerializable(r4)     // Catch:{ Exception -> 0x0507 }
            java.util.List r4 = (java.util.List) r4     // Catch:{ Exception -> 0x0507 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ Exception -> 0x0507 }
        L_0x0499:
            boolean r5 = r4.hasNext()     // Catch:{ Exception -> 0x0507 }
            if (r5 == 0) goto L_0x04b4
            java.lang.Object r5 = r4.next()     // Catch:{ Exception -> 0x0507 }
            android.os.Bundle r5 = (android.os.Bundle) r5     // Catch:{ Exception -> 0x0507 }
            android.os.Bundle r6 = r1.notification     // Catch:{ Exception -> 0x0507 }
            r7 = r20
            androidx.core.app.NotificationCompat$Action r5 = r1.createAction(r0, r5, r7, r6)     // Catch:{ Exception -> 0x0507 }
            androidx.core.app.NotificationCompat$Builder r3 = r3.addAction(r5)     // Catch:{ Exception -> 0x0507 }
            r20 = r7
            goto L_0x0499
        L_0x04b4:
            r7 = r20
            java.lang.String r4 = "tag"
            boolean r4 = r2.containsKey(r4)     // Catch:{ Exception -> 0x0507 }
            if (r4 == 0) goto L_0x04c5
            java.lang.String r4 = "tag"
            java.lang.String r4 = r2.getString(r4)     // Catch:{ Exception -> 0x0507 }
            goto L_0x04c6
        L_0x04c5:
            r4 = 0
        L_0x04c6:
            android.os.Bundle r5 = r1.notification     // Catch:{ Exception -> 0x0507 }
            java.lang.String r6 = "clickAction"
            java.lang.String r2 = r2.getString(r6)     // Catch:{ Exception -> 0x0507 }
            android.app.PendingIntent r0 = r1.createIntent(r0, r7, r5, r2)     // Catch:{ Exception -> 0x0507 }
            androidx.core.app.NotificationCompat$Builder r0 = r3.setContentIntent(r0)     // Catch:{ Exception -> 0x0507 }
            android.app.Notification r0 = r0.build()     // Catch:{ Exception -> 0x0507 }
            android.app.NotificationManager r2 = r1.notificationManager     // Catch:{ Exception -> 0x0507 }
            int r3 = r22.hashCode()     // Catch:{ Exception -> 0x0507 }
            r2.notify(r4, r3, r0)     // Catch:{ Exception -> 0x0507 }
            java.lang.ref.WeakReference<com.facebook.react.bridge.ReactApplicationContext> r0 = r1.reactContextWeakReference     // Catch:{ Exception -> 0x0507 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x0507 }
            if (r0 == 0) goto L_0x04fe
            java.lang.ref.WeakReference<com.facebook.react.bridge.ReactApplicationContext> r0 = r1.reactContextWeakReference     // Catch:{ Exception -> 0x0507 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x0507 }
            com.facebook.react.bridge.ReactContext r0 = (com.facebook.react.bridge.ReactContext) r0     // Catch:{ Exception -> 0x0507 }
            java.lang.String r2 = "notifications_notification_displayed"
            android.os.Bundle r3 = r1.notification     // Catch:{ Exception -> 0x0507 }
            com.facebook.react.bridge.WritableMap r3 = com.facebook.react.bridge.Arguments.fromBundle(r3)     // Catch:{ Exception -> 0x0507 }
            io.invertase.firebase.Utils.sendEvent(r0, r2, r3)     // Catch:{ Exception -> 0x0507 }
        L_0x04fe:
            com.facebook.react.bridge.Promise r0 = r1.promise     // Catch:{ Exception -> 0x0507 }
            if (r0 == 0) goto L_0x051e
            r2 = 0
            r0.resolve(r2)     // Catch:{ Exception -> 0x0507 }
            goto L_0x051e
        L_0x0507:
            r0 = move-exception
            goto L_0x050c
        L_0x0509:
            r0 = move-exception
            r19 = r15
        L_0x050c:
            java.lang.String r2 = "DisplayNotificationTask"
            java.lang.String r3 = "Failed to send notification"
            android.util.Log.e(r2, r3, r0)
            com.facebook.react.bridge.Promise r2 = r1.promise
            if (r2 == 0) goto L_0x051e
            java.lang.String r3 = "Could not send notification"
            r4 = r19
            r2.reject((java.lang.String) r4, (java.lang.String) r3, (java.lang.Throwable) r0)
        L_0x051e:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.invertase.firebase.notifications.DisplayNotificationTask.doInBackground(java.lang.Void[]):java.lang.Void");
    }

    private NotificationCompat.Action createAction(Context context, Bundle bundle, Class cls, Bundle bundle2) {
        PendingIntent pendingIntent;
        String string = bundle.getString("action");
        if (bundle.containsKey("showUserInterface") && bundle.getBoolean("showUserInterface")) {
            pendingIntent = createIntent(context, cls, bundle2, string);
        } else {
            pendingIntent = createBroadcastIntent(context, bundle2, string);
        }
        NotificationCompat.Action.Builder builder = new NotificationCompat.Action.Builder(getIcon(bundle.getString("icon")), (CharSequence) bundle.getString(MessageBundle.TITLE_ENTRY), pendingIntent);
        if (bundle.containsKey("allowGeneratedReplies")) {
            builder = builder.setAllowGeneratedReplies(bundle.getBoolean("allowGeneratedReplies"));
        }
        if (bundle.containsKey("remoteInputs")) {
            for (Bundle createRemoteInput : (List) bundle.getSerializable("remoteInputs")) {
                builder = builder.addRemoteInput(createRemoteInput(createRemoteInput));
            }
        }
        return builder.build();
    }

    private PendingIntent createIntent(Context context, Class cls, Bundle bundle, String str) {
        Intent intent = new Intent(context, cls);
        intent.addFlags(PropertyOptions.DELETE_EXISTING);
        intent.putExtras(bundle);
        if (str != null) {
            intent.setAction(str);
        }
        return PendingIntent.getActivity(context, bundle.getString("notificationId").hashCode(), intent, 134217728);
    }

    private PendingIntent createBroadcastIntent(Context context, Bundle bundle, String str) {
        String str2 = bundle.getString("notificationId") + str;
        Intent intent = new Intent(context, RNFirebaseBackgroundNotificationActionReceiver.class);
        intent.putExtra("action", str);
        intent.addFlags(PropertyOptions.DELETE_EXISTING);
        intent.putExtra("notification", bundle);
        intent.setAction("io.invertase.firebase.notifications.BackgroundAction");
        return PendingIntent.getBroadcast(context, str2.hashCode(), intent, 134217728);
    }

    private RemoteInput createRemoteInput(Bundle bundle) {
        RemoteInput.Builder builder = new RemoteInput.Builder(bundle.getString("resultKey"));
        if (bundle.containsKey("allowedDataTypes")) {
            for (Bundle bundle2 : (List) bundle.getSerializable("allowedDataTypes")) {
                builder.setAllowDataType(bundle2.getString("mimeType"), bundle2.getBoolean("allow"));
            }
        }
        if (bundle.containsKey("allowFreeFormInput")) {
            builder.setAllowFreeFormInput(bundle.getBoolean("allowFreeFormInput"));
        }
        if (bundle.containsKey("choices")) {
            ArrayList<String> stringArrayList = bundle.getStringArrayList("choices");
            builder.setChoices((CharSequence[]) stringArrayList.toArray(new String[stringArrayList.size()]));
        }
        if (bundle.containsKey(AnnotatedPrivateKey.LABEL)) {
            builder.setLabel(bundle.getString(AnnotatedPrivateKey.LABEL));
        }
        return builder.build();
    }

    private Bitmap getBitmap(String str) {
        if (str.startsWith("http://") || str.startsWith("https://")) {
            return getBitmapFromUrl(str);
        }
        if (str.startsWith("file://")) {
            return BitmapFactory.decodeFile(str.replace("file://", ""));
        }
        return BitmapFactory.decodeResource(((Context) this.contextWeakReference.get()).getResources(), getIcon(str));
    }

    private Bitmap getBitmapFromUrl(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            return BitmapFactory.decodeStream(httpURLConnection.getInputStream());
        } catch (IOException e) {
            Log.e(TAG, "Failed to get bitmap for url: " + str, e);
            return null;
        }
    }

    private int getIcon(String str) {
        int resourceId = RNFirebaseNotificationManager.getResourceId((Context) this.contextWeakReference.get(), "mipmap", str);
        return resourceId == 0 ? RNFirebaseNotificationManager.getResourceId((Context) this.contextWeakReference.get(), "drawable", str) : resourceId;
    }

    private Class getMainActivityClass(Context context) {
        try {
            return Class.forName(context.getPackageManager().getLaunchIntentForPackage(context.getPackageName()).getComponent().getClassName());
        } catch (ClassNotFoundException e) {
            Log.e(TAG, "Failed to get main activity class", e);
            return null;
        }
    }
}
