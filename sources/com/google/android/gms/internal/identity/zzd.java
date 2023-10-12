package com.google.android.gms.internal.identity;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.util.Log;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-identity@@17.0.1 */
public final class zzd extends zzf {
    private final int zza;
    /* access modifiers changed from: private */
    public Activity zzb;

    public zzd(int i, Activity activity) {
        this.zza = i;
        this.zzb = activity;
    }

    public final void zzc(int i, Bundle bundle) {
        PendingIntent createPendingResult;
        if (i == 1) {
            Intent intent = new Intent();
            intent.putExtras(bundle);
            Activity activity = this.zzb;
            if (activity != null && (createPendingResult = activity.createPendingResult(this.zza, intent, BasicMeasure.EXACTLY)) != null) {
                try {
                    createPendingResult.send(1);
                } catch (PendingIntent.CanceledException e) {
                    Log.w("AddressClientImpl", "Exception settng pending result", e);
                }
            }
        } else {
            ConnectionResult connectionResult = new ConnectionResult(i, bundle != null ? (PendingIntent) bundle.getParcelable("com.google.android.gms.identity.intents.EXTRA_PENDING_INTENT") : null);
            if (connectionResult.hasResolution()) {
                try {
                    connectionResult.startResolutionForResult((Activity) Preconditions.checkNotNull(this.zzb), this.zza);
                } catch (IntentSender.SendIntentException e2) {
                    Log.w("AddressClientImpl", "Exception starting pending intent", e2);
                }
            } else {
                try {
                    PendingIntent createPendingResult2 = ((Activity) Preconditions.checkNotNull(this.zzb)).createPendingResult(this.zza, new Intent(), BasicMeasure.EXACTLY);
                    if (createPendingResult2 != null) {
                        createPendingResult2.send(1);
                    }
                } catch (PendingIntent.CanceledException e3) {
                    Log.w("AddressClientImpl", "Exception setting pending result", e3);
                }
            }
        }
    }
}
