package com.stripe.android.stripe3ds2.observability;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J\b\u0010\f\u001a\u00020\u0003H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0012\u0010\n\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005¨\u0006\r"}, d2 = {"Lcom/stripe/android/stripe3ds2/observability/SentryConfig;", "", "key", "", "getKey", "()Ljava/lang/String;", "projectId", "getProjectId", "secret", "getSecret", "version", "getVersion", "getTimestamp", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SentryConfig.kt */
public interface SentryConfig {
    String getKey();

    String getProjectId();

    String getSecret();

    String getTimestamp();

    String getVersion();
}
