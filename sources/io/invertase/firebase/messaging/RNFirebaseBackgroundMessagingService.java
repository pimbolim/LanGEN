package io.invertase.firebase.messaging;

import android.content.Intent;
import com.braintreepayments.api.internal.GraphQLConstants;
import com.facebook.react.HeadlessJsTaskService;
import com.facebook.react.jstasks.HeadlessJsTaskConfig;
import com.google.firebase.messaging.RemoteMessage;
import javax.annotation.Nullable;
import org.apache.commons.lang3.time.DateUtils;

public class RNFirebaseBackgroundMessagingService extends HeadlessJsTaskService {
    /* access modifiers changed from: protected */
    @Nullable
    public HeadlessJsTaskConfig getTaskConfig(Intent intent) {
        if (intent.getExtras() != null) {
            return new HeadlessJsTaskConfig("RNFirebaseBackgroundMessage", MessagingSerializer.parseRemoteMessage((RemoteMessage) intent.getParcelableExtra(GraphQLConstants.Keys.MESSAGE)), DateUtils.MILLIS_PER_MINUTE, false);
        }
        return null;
    }
}
