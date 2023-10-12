package com.google.android.gms.wallet;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-wallet@@19.1.0 */
public class AutoResolveHelper {
    public static final int RESULT_ERROR = 1;
    static long zza = SystemClock.elapsedRealtime();
    /* access modifiers changed from: private */
    public static final long zzb = TimeUnit.MINUTES.toMillis(10);

    private AutoResolveHelper() {
    }

    public static Status getStatusFromIntent(Intent intent) {
        if (intent == null) {
            return null;
        }
        return (Status) intent.getParcelableExtra("com.google.android.gms.common.api.AutoResolveHelper.status");
    }

    public static void putStatusIntoIntent(Intent intent, Status status) {
        if (status == null) {
            intent.removeExtra("com.google.android.gms.common.api.AutoResolveHelper.status");
        } else {
            intent.putExtra("com.google.android.gms.common.api.AutoResolveHelper.status", status);
        }
    }

    public static <TResult extends AutoResolvableResult> void resolveTask(Task<TResult> task, Activity activity, int i) {
        zzc zza2 = zzc.zza(task);
        FragmentTransaction beginTransaction = activity.getFragmentManager().beginTransaction();
        int i2 = zza2.zzc;
        Bundle bundle = new Bundle();
        bundle.putInt("resolveCallId", i2);
        bundle.putInt("requestCode", i);
        bundle.putLong("initializationElapsedRealtime", zza);
        zzd zzd = new zzd();
        zzd.setArguments(bundle);
        int i3 = zza2.zzc;
        StringBuilder sb = new StringBuilder(58);
        sb.append("com.google.android.gms.wallet.AutoResolveHelper");
        sb.append(i3);
        beginTransaction.add(zzd, sb.toString()).commit();
    }

    public static void zzd(Status status, Object obj, TaskCompletionSource taskCompletionSource) {
        if (status.isSuccess()) {
            taskCompletionSource.setResult(obj);
        } else {
            taskCompletionSource.setException(ApiExceptionUtil.fromStatus(status));
        }
    }

    /* access modifiers changed from: private */
    public static void zze(Activity activity, int i, int i2, Intent intent) {
        PendingIntent createPendingResult = activity.createPendingResult(i, intent, BasicMeasure.EXACTLY);
        if (createPendingResult != null) {
            try {
                createPendingResult.send(i2);
            } catch (PendingIntent.CanceledException e) {
                if (Log.isLoggable("AutoResolveHelper", 6)) {
                    Log.e("AutoResolveHelper", "Exception sending pending result", e);
                }
            }
        } else if (Log.isLoggable("AutoResolveHelper", 5)) {
            Log.w("AutoResolveHelper", "Null pending result returned when trying to deliver task result!");
        }
    }

    /* access modifiers changed from: private */
    public static void zzf(Activity activity, int i, Task task) {
        if (!activity.isFinishing()) {
            Exception exception = task.getException();
            if (exception instanceof ResolvableApiException) {
                try {
                    ((ResolvableApiException) exception).startResolutionForResult(activity, i);
                } catch (IntentSender.SendIntentException e) {
                    if (Log.isLoggable("AutoResolveHelper", 6)) {
                        Log.e("AutoResolveHelper", "Error starting pending intent!", e);
                    }
                }
            } else {
                Intent intent = new Intent();
                int i2 = 1;
                if (task.isSuccessful()) {
                    ((AutoResolvableResult) task.getResult()).putIntoIntent(intent);
                    i2 = -1;
                } else if (exception instanceof ApiException) {
                    ApiException apiException = (ApiException) exception;
                    putStatusIntoIntent(intent, new Status(apiException.getStatusCode(), apiException.getMessage(), (PendingIntent) null));
                } else {
                    if (Log.isLoggable("AutoResolveHelper", 6)) {
                        Log.e("AutoResolveHelper", "Unexpected non API exception!", exception);
                    }
                    putStatusIntoIntent(intent, new Status(8, "Unexpected non API exception when trying to deliver the task result to an activity!"));
                }
                zze(activity, i, i2, intent);
            }
        } else if (Log.isLoggable("AutoResolveHelper", 3)) {
            Log.d("AutoResolveHelper", "Ignoring task result for, Activity is finishing.");
        }
    }
}
