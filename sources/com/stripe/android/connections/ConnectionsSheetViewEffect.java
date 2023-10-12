package com.stripe.android.connections;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/connections/ConnectionsSheetViewEffect;", "", "()V", "FinishWithResult", "OpenAuthFlowWithUrl", "Lcom/stripe/android/connections/ConnectionsSheetViewEffect$OpenAuthFlowWithUrl;", "Lcom/stripe/android/connections/ConnectionsSheetViewEffect$FinishWithResult;", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConnectionsSheetState.kt */
public abstract class ConnectionsSheetViewEffect {
    public /* synthetic */ ConnectionsSheetViewEffect(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ConnectionsSheetViewEffect() {
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/stripe/android/connections/ConnectionsSheetViewEffect$OpenAuthFlowWithUrl;", "Lcom/stripe/android/connections/ConnectionsSheetViewEffect;", "url", "", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConnectionsSheetState.kt */
    public static final class OpenAuthFlowWithUrl extends ConnectionsSheetViewEffect {
        private final String url;

        public static /* synthetic */ OpenAuthFlowWithUrl copy$default(OpenAuthFlowWithUrl openAuthFlowWithUrl, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = openAuthFlowWithUrl.url;
            }
            return openAuthFlowWithUrl.copy(str);
        }

        public final String component1() {
            return this.url;
        }

        public final OpenAuthFlowWithUrl copy(String str) {
            Intrinsics.checkNotNullParameter(str, "url");
            return new OpenAuthFlowWithUrl(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OpenAuthFlowWithUrl) && Intrinsics.areEqual((Object) this.url, (Object) ((OpenAuthFlowWithUrl) obj).url);
        }

        public int hashCode() {
            return this.url.hashCode();
        }

        public String toString() {
            return "OpenAuthFlowWithUrl(url=" + this.url + ')';
        }

        public final String getUrl() {
            return this.url;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public OpenAuthFlowWithUrl(String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "url");
            this.url = str;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/stripe/android/connections/ConnectionsSheetViewEffect$FinishWithResult;", "Lcom/stripe/android/connections/ConnectionsSheetViewEffect;", "result", "Lcom/stripe/android/connections/ConnectionsSheetResult;", "(Lcom/stripe/android/connections/ConnectionsSheetResult;)V", "getResult", "()Lcom/stripe/android/connections/ConnectionsSheetResult;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConnectionsSheetState.kt */
    public static final class FinishWithResult extends ConnectionsSheetViewEffect {
        private final ConnectionsSheetResult result;

        public static /* synthetic */ FinishWithResult copy$default(FinishWithResult finishWithResult, ConnectionsSheetResult connectionsSheetResult, int i, Object obj) {
            if ((i & 1) != 0) {
                connectionsSheetResult = finishWithResult.result;
            }
            return finishWithResult.copy(connectionsSheetResult);
        }

        public final ConnectionsSheetResult component1() {
            return this.result;
        }

        public final FinishWithResult copy(ConnectionsSheetResult connectionsSheetResult) {
            Intrinsics.checkNotNullParameter(connectionsSheetResult, "result");
            return new FinishWithResult(connectionsSheetResult);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof FinishWithResult) && Intrinsics.areEqual((Object) this.result, (Object) ((FinishWithResult) obj).result);
        }

        public int hashCode() {
            return this.result.hashCode();
        }

        public String toString() {
            return "FinishWithResult(result=" + this.result + ')';
        }

        public final ConnectionsSheetResult getResult() {
            return this.result;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FinishWithResult(ConnectionsSheetResult connectionsSheetResult) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(connectionsSheetResult, "result");
            this.result = connectionsSheetResult;
        }
    }
}
