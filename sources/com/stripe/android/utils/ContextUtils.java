package com.stripe.android.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u0004*\u00020\u00058@X\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/stripe/android/utils/ContextUtils;", "", "()V", "packageInfo", "Landroid/content/pm/PackageInfo;", "Landroid/content/Context;", "getPackageInfo$payments_core_release", "(Landroid/content/Context;)Landroid/content/pm/PackageInfo;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ContextUtils.kt */
public final class ContextUtils {
    public static final ContextUtils INSTANCE = new ContextUtils();

    private ContextUtils() {
    }

    public final /* synthetic */ PackageInfo getPackageInfo$payments_core_release(Context context) {
        Object obj;
        Intrinsics.checkNotNullParameter(context, "<this>");
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m4709constructorimpl(context.getPackageManager().getPackageInfo(context.getPackageName(), 0));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m4709constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m4715isFailureimpl(obj)) {
            obj = null;
        }
        return (PackageInfo) obj;
    }
}
