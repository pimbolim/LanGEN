package com.stripe.android.connections.analytics;

import com.stripe.android.core.networking.AnalyticsEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001\u0019B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/stripe/android/connections/analytics/ConnectionsAnalyticsEvent;", "Lcom/stripe/android/core/networking/AnalyticsEvent;", "eventCode", "Lcom/stripe/android/connections/analytics/ConnectionsAnalyticsEvent$Code;", "additionalParams", "", "", "(Lcom/stripe/android/connections/analytics/ConnectionsAnalyticsEvent$Code;Ljava/util/Map;)V", "getAdditionalParams", "()Ljava/util/Map;", "getEventCode", "()Lcom/stripe/android/connections/analytics/ConnectionsAnalyticsEvent$Code;", "eventName", "getEventName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Code", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConnectionsAnalyticsEvent.kt */
public final class ConnectionsAnalyticsEvent implements AnalyticsEvent {
    private final Map<String, String> additionalParams;
    private final Code eventCode;
    private final String eventName;

    public static /* synthetic */ ConnectionsAnalyticsEvent copy$default(ConnectionsAnalyticsEvent connectionsAnalyticsEvent, Code code, Map<String, String> map, int i, Object obj) {
        if ((i & 1) != 0) {
            code = connectionsAnalyticsEvent.eventCode;
        }
        if ((i & 2) != 0) {
            map = connectionsAnalyticsEvent.additionalParams;
        }
        return connectionsAnalyticsEvent.copy(code, map);
    }

    public final Code component1() {
        return this.eventCode;
    }

    public final Map<String, String> component2() {
        return this.additionalParams;
    }

    public final ConnectionsAnalyticsEvent copy(Code code, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(code, "eventCode");
        Intrinsics.checkNotNullParameter(map, "additionalParams");
        return new ConnectionsAnalyticsEvent(code, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConnectionsAnalyticsEvent)) {
            return false;
        }
        ConnectionsAnalyticsEvent connectionsAnalyticsEvent = (ConnectionsAnalyticsEvent) obj;
        return this.eventCode == connectionsAnalyticsEvent.eventCode && Intrinsics.areEqual((Object) this.additionalParams, (Object) connectionsAnalyticsEvent.additionalParams);
    }

    public int hashCode() {
        return (this.eventCode.hashCode() * 31) + this.additionalParams.hashCode();
    }

    public String toString() {
        return "ConnectionsAnalyticsEvent(eventCode=" + this.eventCode + ", additionalParams=" + this.additionalParams + ')';
    }

    public ConnectionsAnalyticsEvent(Code code, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(code, "eventCode");
        Intrinsics.checkNotNullParameter(map, "additionalParams");
        this.eventCode = code;
        this.additionalParams = map;
        this.eventName = code.toString();
    }

    public final Code getEventCode() {
        return this.eventCode;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ConnectionsAnalyticsEvent(Code code, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(code, (i & 2) != 0 ? MapsKt.emptyMap() : map);
    }

    public final Map<String, String> getAdditionalParams() {
        return this.additionalParams;
    }

    public String getEventName() {
        return this.eventName;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/stripe/android/connections/analytics/ConnectionsAnalyticsEvent$Code;", "", "code", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getCode$connections_release", "()Ljava/lang/String;", "toString", "SheetPresented", "SheetClosed", "SheetFailed", "Companion", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConnectionsAnalyticsEvent.kt */
    public enum Code {
        SheetPresented("sheet.presented"),
        SheetClosed("sheet.closed"),
        SheetFailed("sheet.failed");
        
        private static final Companion Companion = null;
        @Deprecated
        private static final String PREFIX = "stripe_android.connections";
        private final String code;

        private Code(String str) {
            this.code = str;
        }

        public final String getCode$connections_release() {
            return this.code;
        }

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }

        public String toString() {
            return Intrinsics.stringPlus("stripe_android.connections.", this.code);
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/connections/analytics/ConnectionsAnalyticsEvent$Code$Companion;", "", "()V", "PREFIX", "", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: ConnectionsAnalyticsEvent.kt */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }
}
