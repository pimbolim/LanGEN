package io.invertase.firebase.notifications;

import android.content.Intent;
import com.facebook.react.HeadlessJsTaskService;
import com.facebook.react.jstasks.HeadlessJsTaskConfig;
import javax.annotation.Nullable;
import org.apache.commons.lang3.time.DateUtils;

public class RNFirebaseBackgroundNotificationActionsService extends HeadlessJsTaskService {
    /* access modifiers changed from: protected */
    @Nullable
    public HeadlessJsTaskConfig getTaskConfig(Intent intent) {
        if (RNFirebaseBackgroundNotificationActionReceiver.isBackgroundNotficationIntent(intent)) {
            return new HeadlessJsTaskConfig("RNFirebaseBackgroundNotificationAction", RNFirebaseBackgroundNotificationActionReceiver.toNotificationOpenMap(intent), DateUtils.MILLIS_PER_MINUTE, true);
        }
        return null;
    }
}
