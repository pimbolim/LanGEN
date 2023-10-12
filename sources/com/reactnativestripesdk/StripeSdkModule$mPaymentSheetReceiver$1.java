package com.reactnativestripesdk;

import android.content.BroadcastReceiver;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/reactnativestripesdk/StripeSdkModule$mPaymentSheetReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "stripe_stripe-react-native_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: StripeSdkModule.kt */
public final class StripeSdkModule$mPaymentSheetReceiver$1 extends BroadcastReceiver {
    final /* synthetic */ StripeSdkModule this$0;

    StripeSdkModule$mPaymentSheetReceiver$1(StripeSdkModule stripeSdkModule) {
        this.this$0 = stripeSdkModule;
    }

    /* JADX WARNING: type inference failed for: r0v13, types: [com.stripe.android.paymentsheet.PaymentSheetResult] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onReceive(android.content.Context r6, android.content.Intent r7) {
        /*
            r5 = this;
            java.lang.String r6 = "intent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r6)
            java.lang.String r6 = r7.getAction()
            java.lang.String r0 = com.reactnativestripesdk.ConstantsKt.getON_PAYMENT_RESULT_ACTION()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r0)
            r0 = 0
            if (r6 == 0) goto L_0x00c2
            android.os.Bundle r6 = r7.getExtras()
            if (r6 != 0) goto L_0x001b
            goto L_0x0024
        L_0x001b:
            java.lang.String r7 = "paymentResult"
            android.os.Parcelable r6 = r6.getParcelable(r7)
            r0 = r6
            com.stripe.android.paymentsheet.PaymentSheetResult r0 = (com.stripe.android.paymentsheet.PaymentSheetResult) r0
        L_0x0024:
            boolean r6 = r0 instanceof com.stripe.android.paymentsheet.PaymentSheetResult.Canceled
            if (r6 == 0) goto L_0x0059
            java.lang.String r6 = "The payment has been canceled"
            com.reactnativestripesdk.StripeSdkModule r7 = r5.this$0
            com.facebook.react.bridge.Promise r7 = r7.confirmPaymentSheetPaymentPromise
            if (r7 != 0) goto L_0x0033
            goto L_0x0040
        L_0x0033:
            com.reactnativestripesdk.PaymentSheetErrorType r0 = com.reactnativestripesdk.PaymentSheetErrorType.Canceled
            java.lang.String r0 = r0.toString()
            com.facebook.react.bridge.WritableMap r0 = com.reactnativestripesdk.ErrorsKt.createError((java.lang.String) r0, (java.lang.String) r6)
            r7.resolve(r0)
        L_0x0040:
            com.reactnativestripesdk.StripeSdkModule r7 = r5.this$0
            com.facebook.react.bridge.Promise r7 = r7.presentPaymentSheetPromise
            if (r7 != 0) goto L_0x004a
            goto L_0x01a0
        L_0x004a:
            com.reactnativestripesdk.PaymentSheetErrorType r0 = com.reactnativestripesdk.PaymentSheetErrorType.Canceled
            java.lang.String r0 = r0.toString()
            com.facebook.react.bridge.WritableMap r6 = com.reactnativestripesdk.ErrorsKt.createError((java.lang.String) r0, (java.lang.String) r6)
            r7.resolve(r6)
            goto L_0x01a0
        L_0x0059:
            boolean r6 = r0 instanceof com.stripe.android.paymentsheet.PaymentSheetResult.Failed
            if (r6 == 0) goto L_0x0099
            com.reactnativestripesdk.StripeSdkModule r6 = r5.this$0
            com.facebook.react.bridge.Promise r6 = r6.confirmPaymentSheetPaymentPromise
            if (r6 != 0) goto L_0x0066
            goto L_0x007a
        L_0x0066:
            com.reactnativestripesdk.PaymentSheetErrorType r7 = com.reactnativestripesdk.PaymentSheetErrorType.Failed
            java.lang.String r7 = r7.toString()
            r1 = r0
            com.stripe.android.paymentsheet.PaymentSheetResult$Failed r1 = (com.stripe.android.paymentsheet.PaymentSheetResult.Failed) r1
            java.lang.Throwable r1 = r1.getError()
            com.facebook.react.bridge.WritableMap r7 = com.reactnativestripesdk.ErrorsKt.createError((java.lang.String) r7, (java.lang.Throwable) r1)
            r6.resolve(r7)
        L_0x007a:
            com.reactnativestripesdk.StripeSdkModule r6 = r5.this$0
            com.facebook.react.bridge.Promise r6 = r6.presentPaymentSheetPromise
            if (r6 != 0) goto L_0x0084
            goto L_0x01a0
        L_0x0084:
            com.reactnativestripesdk.PaymentSheetErrorType r7 = com.reactnativestripesdk.PaymentSheetErrorType.Failed
            java.lang.String r7 = r7.toString()
            com.stripe.android.paymentsheet.PaymentSheetResult$Failed r0 = (com.stripe.android.paymentsheet.PaymentSheetResult.Failed) r0
            java.lang.Throwable r0 = r0.getError()
            com.facebook.react.bridge.WritableMap r7 = com.reactnativestripesdk.ErrorsKt.createError((java.lang.String) r7, (java.lang.Throwable) r0)
            r6.resolve(r7)
            goto L_0x01a0
        L_0x0099:
            boolean r6 = r0 instanceof com.stripe.android.paymentsheet.PaymentSheetResult.Completed
            if (r6 == 0) goto L_0x01a0
            com.reactnativestripesdk.StripeSdkModule r6 = r5.this$0
            com.facebook.react.bridge.Promise r6 = r6.confirmPaymentSheetPaymentPromise
            if (r6 != 0) goto L_0x00a6
            goto L_0x00ae
        L_0x00a6:
            com.facebook.react.bridge.WritableNativeMap r7 = new com.facebook.react.bridge.WritableNativeMap
            r7.<init>()
            r6.resolve(r7)
        L_0x00ae:
            com.reactnativestripesdk.StripeSdkModule r6 = r5.this$0
            com.facebook.react.bridge.Promise r6 = r6.presentPaymentSheetPromise
            if (r6 != 0) goto L_0x00b8
            goto L_0x01a0
        L_0x00b8:
            com.facebook.react.bridge.WritableNativeMap r7 = new com.facebook.react.bridge.WritableNativeMap
            r7.<init>()
            r6.resolve(r7)
            goto L_0x01a0
        L_0x00c2:
            java.lang.String r6 = r7.getAction()
            java.lang.String r1 = com.reactnativestripesdk.ConstantsKt.getON_PAYMENT_OPTION_ACTION()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r1)
            java.lang.String r1 = "paymentOption"
            java.lang.String r2 = "image"
            java.lang.String r3 = "label"
            if (r6 == 0) goto L_0x0128
            android.os.Bundle r6 = r7.getExtras()
            if (r6 != 0) goto L_0x00de
            r6 = r0
            goto L_0x00e2
        L_0x00de:
            java.lang.String r6 = r6.getString(r3)
        L_0x00e2:
            android.os.Bundle r7 = r7.getExtras()
            if (r7 != 0) goto L_0x00ea
            r7 = r0
            goto L_0x00ee
        L_0x00ea:
            java.lang.String r7 = r7.getString(r2)
        L_0x00ee:
            if (r6 == 0) goto L_0x0110
            if (r7 == 0) goto L_0x0110
            com.facebook.react.bridge.WritableNativeMap r4 = new com.facebook.react.bridge.WritableNativeMap
            r4.<init>()
            com.facebook.react.bridge.WritableMap r4 = (com.facebook.react.bridge.WritableMap) r4
            r4.putString(r3, r6)
            r4.putString(r2, r7)
            com.reactnativestripesdk.StripeSdkModule r6 = r5.this$0
            com.facebook.react.bridge.Promise r6 = r6.presentPaymentSheetPromise
            if (r6 != 0) goto L_0x0108
            goto L_0x0121
        L_0x0108:
            com.facebook.react.bridge.WritableMap r7 = com.reactnativestripesdk.MappersKt.createResult(r1, r4)
            r6.resolve(r7)
            goto L_0x0121
        L_0x0110:
            com.reactnativestripesdk.StripeSdkModule r6 = r5.this$0
            com.facebook.react.bridge.Promise r6 = r6.presentPaymentSheetPromise
            if (r6 != 0) goto L_0x0119
            goto L_0x0121
        L_0x0119:
            com.facebook.react.bridge.WritableNativeMap r7 = new com.facebook.react.bridge.WritableNativeMap
            r7.<init>()
            r6.resolve(r7)
        L_0x0121:
            com.reactnativestripesdk.StripeSdkModule r6 = r5.this$0
            r6.presentPaymentSheetPromise = r0
            goto L_0x01a0
        L_0x0128:
            java.lang.String r6 = r7.getAction()
            java.lang.String r4 = com.reactnativestripesdk.ConstantsKt.getON_INIT_PAYMENT_SHEET()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r4)
            if (r6 == 0) goto L_0x0148
            com.reactnativestripesdk.StripeSdkModule r6 = r5.this$0
            com.facebook.react.bridge.Promise r6 = r6.initPaymentSheetPromise
            if (r6 != 0) goto L_0x013f
            goto L_0x01a0
        L_0x013f:
            com.facebook.react.bridge.WritableNativeMap r7 = new com.facebook.react.bridge.WritableNativeMap
            r7.<init>()
            r6.resolve(r7)
            goto L_0x01a0
        L_0x0148:
            java.lang.String r6 = r7.getAction()
            java.lang.String r4 = com.reactnativestripesdk.ConstantsKt.getON_CONFIGURE_FLOW_CONTROLLER()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r4)
            if (r6 == 0) goto L_0x01a0
            android.os.Bundle r6 = r7.getExtras()
            if (r6 != 0) goto L_0x015e
            r6 = r0
            goto L_0x0162
        L_0x015e:
            java.lang.String r6 = r6.getString(r3)
        L_0x0162:
            android.os.Bundle r7 = r7.getExtras()
            if (r7 != 0) goto L_0x0169
            goto L_0x016d
        L_0x0169:
            java.lang.String r0 = r7.getString(r2)
        L_0x016d:
            if (r6 == 0) goto L_0x018f
            if (r0 == 0) goto L_0x018f
            com.facebook.react.bridge.WritableNativeMap r7 = new com.facebook.react.bridge.WritableNativeMap
            r7.<init>()
            com.facebook.react.bridge.WritableMap r7 = (com.facebook.react.bridge.WritableMap) r7
            r7.putString(r3, r6)
            r7.putString(r2, r0)
            com.reactnativestripesdk.StripeSdkModule r6 = r5.this$0
            com.facebook.react.bridge.Promise r6 = r6.initPaymentSheetPromise
            if (r6 != 0) goto L_0x0187
            goto L_0x01a0
        L_0x0187:
            com.facebook.react.bridge.WritableMap r7 = com.reactnativestripesdk.MappersKt.createResult(r1, r7)
            r6.resolve(r7)
            goto L_0x01a0
        L_0x018f:
            com.reactnativestripesdk.StripeSdkModule r6 = r5.this$0
            com.facebook.react.bridge.Promise r6 = r6.initPaymentSheetPromise
            if (r6 != 0) goto L_0x0198
            goto L_0x01a0
        L_0x0198:
            com.facebook.react.bridge.WritableNativeMap r7 = new com.facebook.react.bridge.WritableNativeMap
            r7.<init>()
            r6.resolve(r7)
        L_0x01a0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativestripesdk.StripeSdkModule$mPaymentSheetReceiver$1.onReceive(android.content.Context, android.content.Intent):void");
    }
}
