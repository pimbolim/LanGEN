package com.stripe.android.paymentsheet.ui;

import com.stripe.android.paymentsheet.R;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/stripe/android/paymentsheet/ui/AnimationConstants;", "", "()V", "FADE_IN", "", "getFADE_IN", "()I", "FADE_OUT", "getFADE_OUT", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AnimationConstants.kt */
public final class AnimationConstants {
    private static final int FADE_IN = R.anim.stripe_paymentsheet_transition_fade_in;
    private static final int FADE_OUT = R.anim.stripe_paymentsheet_transition_fade_out;
    public static final AnimationConstants INSTANCE = new AnimationConstants();

    private AnimationConstants() {
    }

    public final int getFADE_IN() {
        return FADE_IN;
    }

    public final int getFADE_OUT() {
        return FADE_OUT;
    }
}
