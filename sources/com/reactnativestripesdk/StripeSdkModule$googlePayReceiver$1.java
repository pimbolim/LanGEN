package com.reactnativestripesdk;

import android.content.BroadcastReceiver;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/reactnativestripesdk/StripeSdkModule$googlePayReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "stripe_stripe-react-native_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: StripeSdkModule.kt */
public final class StripeSdkModule$googlePayReceiver$1 extends BroadcastReceiver {
    final /* synthetic */ StripeSdkModule this$0;

    StripeSdkModule$googlePayReceiver$1(StripeSdkModule stripeSdkModule) {
        this.this$0 = stripeSdkModule;
    }

    /* JADX WARNING: type inference failed for: r7v21, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onReceive(android.content.Context r7, android.content.Intent r8) {
        /*
            r6 = this;
            java.lang.String r7 = "intent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r7)
            java.lang.String r7 = r8.getAction()
            java.lang.String r0 = com.reactnativestripesdk.ConstantsKt.getON_INIT_GOOGLE_PAY()
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r0)
            if (r7 == 0) goto L_0x004d
            android.os.Bundle r7 = r8.getExtras()
            if (r7 != 0) goto L_0x001b
            r7 = 0
            goto L_0x0021
        L_0x001b:
            java.lang.String r0 = "isReady"
            boolean r7 = r7.getBoolean(r0)
        L_0x0021:
            if (r7 == 0) goto L_0x0035
            com.reactnativestripesdk.StripeSdkModule r7 = r6.this$0
            com.facebook.react.bridge.Promise r7 = r7.initGooglePayPromise
            if (r7 != 0) goto L_0x002c
            goto L_0x004d
        L_0x002c:
            com.facebook.react.bridge.WritableNativeMap r0 = new com.facebook.react.bridge.WritableNativeMap
            r0.<init>()
            r7.resolve(r0)
            goto L_0x004d
        L_0x0035:
            com.reactnativestripesdk.StripeSdkModule r7 = r6.this$0
            com.facebook.react.bridge.Promise r7 = r7.initGooglePayPromise
            if (r7 != 0) goto L_0x003e
            goto L_0x004d
        L_0x003e:
            com.reactnativestripesdk.GooglePayErrorType r0 = com.reactnativestripesdk.GooglePayErrorType.Failed
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "Google Pay is not available on this device. You can use isGooglePaySupported to preemptively check for Google Pay support."
            com.facebook.react.bridge.WritableMap r0 = com.reactnativestripesdk.ErrorsKt.createError((java.lang.String) r0, (java.lang.String) r1)
            r7.resolve(r0)
        L_0x004d:
            java.lang.String r7 = r8.getAction()
            java.lang.String r0 = com.reactnativestripesdk.ConstantsKt.getON_GOOGLE_PAYMENT_METHOD_RESULT()
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r0)
            java.lang.String r0 = "Google Pay has been canceled"
            r1 = 0
            java.lang.String r2 = "paymentResult"
            java.lang.String r3 = "error"
            if (r7 == 0) goto L_0x00f5
            android.os.Bundle r7 = r8.getExtras()
            if (r7 != 0) goto L_0x0069
            goto L_0x006f
        L_0x0069:
            java.lang.String r7 = r7.getString(r3)
            if (r7 != 0) goto L_0x00de
        L_0x006f:
            android.os.Bundle r7 = r8.getExtras()
            if (r7 != 0) goto L_0x0077
            r7 = r1
            goto L_0x007d
        L_0x0077:
            android.os.Parcelable r7 = r7.getParcelable(r2)
            com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher$Result r7 = (com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher.Result) r7
        L_0x007d:
            boolean r4 = r7 instanceof com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher.Result.Completed
            if (r4 == 0) goto L_0x009e
            com.reactnativestripesdk.StripeSdkModule r4 = r6.this$0
            com.facebook.react.bridge.Promise r4 = r4.presentGooglePayPromise
            if (r4 != 0) goto L_0x008a
            goto L_0x00f5
        L_0x008a:
            com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher$Result$Completed r7 = (com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher.Result.Completed) r7
            com.stripe.android.model.PaymentMethod r7 = r7.getPaymentMethod()
            com.facebook.react.bridge.WritableMap r7 = com.reactnativestripesdk.MappersKt.mapFromPaymentMethod(r7)
            java.lang.String r5 = "paymentMethod"
            com.facebook.react.bridge.WritableMap r7 = com.reactnativestripesdk.MappersKt.createResult(r5, r7)
            r4.resolve(r7)
            goto L_0x00f5
        L_0x009e:
            com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher$Result$Canceled r4 = com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher.Result.Canceled.INSTANCE
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r4)
            if (r4 == 0) goto L_0x00bd
            com.reactnativestripesdk.StripeSdkModule r7 = r6.this$0
            com.facebook.react.bridge.Promise r7 = r7.presentGooglePayPromise
            if (r7 != 0) goto L_0x00af
            goto L_0x00f5
        L_0x00af:
            com.reactnativestripesdk.GooglePayErrorType r4 = com.reactnativestripesdk.GooglePayErrorType.Canceled
            java.lang.String r4 = r4.toString()
            com.facebook.react.bridge.WritableMap r4 = com.reactnativestripesdk.ErrorsKt.createError((java.lang.String) r4, (java.lang.String) r0)
            r7.resolve(r4)
            goto L_0x00f5
        L_0x00bd:
            boolean r4 = r7 instanceof com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher.Result.Failed
            if (r4 == 0) goto L_0x00f5
            com.reactnativestripesdk.StripeSdkModule r4 = r6.this$0
            com.facebook.react.bridge.Promise r4 = r4.presentGooglePayPromise
            if (r4 != 0) goto L_0x00ca
            goto L_0x00f5
        L_0x00ca:
            com.reactnativestripesdk.GooglePayErrorType r5 = com.reactnativestripesdk.GooglePayErrorType.Failed
            java.lang.String r5 = r5.toString()
            com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher$Result$Failed r7 = (com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher.Result.Failed) r7
            java.lang.Throwable r7 = r7.getError()
            com.facebook.react.bridge.WritableMap r7 = com.reactnativestripesdk.ErrorsKt.createError((java.lang.String) r5, (java.lang.Throwable) r7)
            r4.resolve(r7)
            goto L_0x00f5
        L_0x00de:
            com.reactnativestripesdk.StripeSdkModule r8 = r6.this$0
            com.facebook.react.bridge.Promise r8 = r8.presentGooglePayPromise
            if (r8 != 0) goto L_0x00e7
            goto L_0x00f4
        L_0x00e7:
            com.reactnativestripesdk.GooglePayErrorType r0 = com.reactnativestripesdk.GooglePayErrorType.Failed
            java.lang.String r0 = r0.toString()
            com.facebook.react.bridge.WritableMap r7 = com.reactnativestripesdk.ErrorsKt.createError((java.lang.String) r0, (java.lang.String) r7)
            r8.resolve(r7)
        L_0x00f4:
            return
        L_0x00f5:
            java.lang.String r7 = r8.getAction()
            java.lang.String r4 = com.reactnativestripesdk.ConstantsKt.getON_GOOGLE_PAY_RESULT()
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r4)
            if (r7 == 0) goto L_0x018e
            android.os.Bundle r7 = r8.getExtras()
            if (r7 != 0) goto L_0x010a
            goto L_0x0110
        L_0x010a:
            java.lang.String r7 = r7.getString(r3)
            if (r7 != 0) goto L_0x0178
        L_0x0110:
            android.os.Bundle r7 = r8.getExtras()
            if (r7 != 0) goto L_0x0117
            goto L_0x011e
        L_0x0117:
            android.os.Parcelable r7 = r7.getParcelable(r2)
            r1 = r7
            com.stripe.android.googlepaylauncher.GooglePayLauncher$Result r1 = (com.stripe.android.googlepaylauncher.GooglePayLauncher.Result) r1
        L_0x011e:
            com.stripe.android.googlepaylauncher.GooglePayLauncher$Result$Completed r7 = com.stripe.android.googlepaylauncher.GooglePayLauncher.Result.Completed.INSTANCE
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r7)
            if (r7 == 0) goto L_0x0138
            com.reactnativestripesdk.StripeSdkModule r7 = r6.this$0
            com.facebook.react.bridge.Promise r7 = r7.presentGooglePayPromise
            if (r7 != 0) goto L_0x012f
            goto L_0x018e
        L_0x012f:
            com.facebook.react.bridge.WritableNativeMap r8 = new com.facebook.react.bridge.WritableNativeMap
            r8.<init>()
            r7.resolve(r8)
            goto L_0x018e
        L_0x0138:
            com.stripe.android.googlepaylauncher.GooglePayLauncher$Result$Canceled r7 = com.stripe.android.googlepaylauncher.GooglePayLauncher.Result.Canceled.INSTANCE
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r7)
            if (r7 == 0) goto L_0x0157
            com.reactnativestripesdk.StripeSdkModule r7 = r6.this$0
            com.facebook.react.bridge.Promise r7 = r7.presentGooglePayPromise
            if (r7 != 0) goto L_0x0149
            goto L_0x018e
        L_0x0149:
            com.reactnativestripesdk.GooglePayErrorType r8 = com.reactnativestripesdk.GooglePayErrorType.Canceled
            java.lang.String r8 = r8.toString()
            com.facebook.react.bridge.WritableMap r8 = com.reactnativestripesdk.ErrorsKt.createError((java.lang.String) r8, (java.lang.String) r0)
            r7.resolve(r8)
            goto L_0x018e
        L_0x0157:
            boolean r7 = r1 instanceof com.stripe.android.googlepaylauncher.GooglePayLauncher.Result.Failed
            if (r7 == 0) goto L_0x018e
            com.reactnativestripesdk.StripeSdkModule r7 = r6.this$0
            com.facebook.react.bridge.Promise r7 = r7.presentGooglePayPromise
            if (r7 != 0) goto L_0x0164
            goto L_0x018e
        L_0x0164:
            com.reactnativestripesdk.GooglePayErrorType r8 = com.reactnativestripesdk.GooglePayErrorType.Failed
            java.lang.String r8 = r8.toString()
            com.stripe.android.googlepaylauncher.GooglePayLauncher$Result$Failed r1 = (com.stripe.android.googlepaylauncher.GooglePayLauncher.Result.Failed) r1
            java.lang.Throwable r0 = r1.getError()
            com.facebook.react.bridge.WritableMap r8 = com.reactnativestripesdk.ErrorsKt.createError((java.lang.String) r8, (java.lang.Throwable) r0)
            r7.resolve(r8)
            goto L_0x018e
        L_0x0178:
            com.reactnativestripesdk.StripeSdkModule r8 = r6.this$0
            com.facebook.react.bridge.Promise r8 = r8.presentGooglePayPromise
            if (r8 != 0) goto L_0x0181
            goto L_0x018e
        L_0x0181:
            com.reactnativestripesdk.GooglePayErrorType r0 = com.reactnativestripesdk.GooglePayErrorType.Failed
            java.lang.String r0 = r0.toString()
            com.facebook.react.bridge.WritableMap r7 = com.reactnativestripesdk.ErrorsKt.createError((java.lang.String) r0, (java.lang.String) r7)
            r8.resolve(r7)
        L_0x018e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativestripesdk.StripeSdkModule$googlePayReceiver$1.onReceive(android.content.Context, android.content.Intent):void");
    }
}
