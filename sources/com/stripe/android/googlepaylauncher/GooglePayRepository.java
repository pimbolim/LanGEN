package com.stripe.android.googlepaylauncher;

import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bæ\u0001\u0018\u00002\u00020\u0001:\u0001\u0005J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/googlepaylauncher/GooglePayRepository;", "", "isReady", "Lkotlinx/coroutines/flow/Flow;", "", "Disabled", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GooglePayRepository.kt */
public interface GooglePayRepository {
    Flow<Boolean> isReady();

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/googlepaylauncher/GooglePayRepository$Disabled;", "Lcom/stripe/android/googlepaylauncher/GooglePayRepository;", "()V", "isReady", "Lkotlinx/coroutines/flow/Flow;", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GooglePayRepository.kt */
    public static final class Disabled implements GooglePayRepository {
        public static final int $stable = 0;
        public static final Disabled INSTANCE = new Disabled();

        private Disabled() {
        }

        public Flow<Boolean> isReady() {
            return FlowKt.flowOf(false);
        }
    }
}
