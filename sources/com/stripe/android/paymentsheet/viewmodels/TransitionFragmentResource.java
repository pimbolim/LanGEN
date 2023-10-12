package com.stripe.android.paymentsheet.viewmodels;

import androidx.test.espresso.IdlingResource;
import androidx.test.espresso.idling.CountingIdlingResource;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/stripe/android/paymentsheet/viewmodels/TransitionFragmentResource;", "", "()V", "Companion", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BaseSheetViewModel.kt */
public final class TransitionFragmentResource {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static CountingIdlingResource idlingResource;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0007R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/paymentsheet/viewmodels/TransitionFragmentResource$Companion;", "", "()V", "idlingResource", "Landroidx/test/espresso/idling/CountingIdlingResource;", "getIdlingResource", "()Landroidx/test/espresso/idling/CountingIdlingResource;", "setIdlingResource", "(Landroidx/test/espresso/idling/CountingIdlingResource;)V", "getSingleStepIdlingResource", "Landroidx/test/espresso/IdlingResource;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BaseSheetViewModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CountingIdlingResource getIdlingResource() {
            return TransitionFragmentResource.idlingResource;
        }

        public final void setIdlingResource(CountingIdlingResource countingIdlingResource) {
            TransitionFragmentResource.idlingResource = countingIdlingResource;
        }

        public final IdlingResource getSingleStepIdlingResource() {
            CountingIdlingResource countingIdlingResource;
            if (getIdlingResource() == null) {
                try {
                    Class.forName("androidx.test.espresso.Espresso");
                    countingIdlingResource = new CountingIdlingResource("transition");
                } catch (ClassNotFoundException unused) {
                    countingIdlingResource = null;
                }
                setIdlingResource(countingIdlingResource);
            }
            return getIdlingResource();
        }
    }
}
