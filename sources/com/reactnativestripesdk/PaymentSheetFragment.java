package com.reactnativestripesdk;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.stripe.android.paymentsheet.PaymentSheet;
import com.stripe.android.paymentsheet.PaymentSheetResult;
import com.stripe.android.paymentsheet.model.PaymentOption;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.jcajce.util.AnnotatedPrivateKey;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0006\u0010\u0010\u001a\u00020\u000fJ$\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0006\u0010\u001b\u001a\u00020\u000fR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/reactnativestripesdk/PaymentSheetFragment;", "Landroidx/fragment/app/Fragment;", "()V", "flowController", "Lcom/stripe/android/paymentsheet/PaymentSheet$FlowController;", "localBroadcastManager", "Landroidx/localbroadcastmanager/content/LocalBroadcastManager;", "paymentIntentClientSecret", "", "paymentSheet", "Lcom/stripe/android/paymentsheet/PaymentSheet;", "paymentSheetConfiguration", "Lcom/stripe/android/paymentsheet/PaymentSheet$Configuration;", "setupIntentClientSecret", "configureFlowController", "", "confirmPayment", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "present", "stripe_stripe-react-native_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: PaymentSheetFragment.kt */
public final class PaymentSheetFragment extends Fragment {
    private PaymentSheet.FlowController flowController;
    private LocalBroadcastManager localBroadcastManager;
    private String paymentIntentClientSecret;
    private PaymentSheet paymentSheet;
    private PaymentSheet.Configuration paymentSheetConfiguration;
    private String setupIntentClientSecret;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        LocalBroadcastManager instance = LocalBroadcastManager.getInstance(requireContext());
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance(requireContext())");
        this.localBroadcastManager = instance;
        FrameLayout frameLayout = new FrameLayout(requireActivity());
        frameLayout.setVisibility(8);
        return frameLayout;
    }

    /* JADX WARNING: Removed duplicated region for block: B:112:0x01b9  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x01cf  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x01e1  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x01e3  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x01f7  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x020a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onViewCreated(android.view.View r25, android.os.Bundle r26) {
        /*
            r24 = this;
            r0 = r24
            java.lang.String r1 = "view"
            r2 = r25
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)
            super.onViewCreated(r25, r26)
            android.os.Bundle r1 = r24.getArguments()
            if (r1 != 0) goto L_0x0014
            r1 = 0
            goto L_0x001a
        L_0x0014:
            java.lang.String r3 = "merchantDisplayName"
            java.lang.String r1 = r1.getString(r3)
        L_0x001a:
            java.lang.String r3 = ""
            if (r1 != 0) goto L_0x0020
            r5 = r3
            goto L_0x0021
        L_0x0020:
            r5 = r1
        L_0x0021:
            android.os.Bundle r1 = r24.getArguments()
            if (r1 != 0) goto L_0x0029
            r1 = 0
            goto L_0x002f
        L_0x0029:
            java.lang.String r4 = "customerId"
            java.lang.String r1 = r1.getString(r4)
        L_0x002f:
            if (r1 != 0) goto L_0x0032
            r1 = r3
        L_0x0032:
            android.os.Bundle r4 = r24.getArguments()
            if (r4 != 0) goto L_0x003a
            r4 = 0
            goto L_0x0040
        L_0x003a:
            java.lang.String r6 = "customerEphemeralKeySecret"
            java.lang.String r4 = r4.getString(r6)
        L_0x0040:
            if (r4 != 0) goto L_0x0043
            r4 = r3
        L_0x0043:
            android.os.Bundle r6 = r24.getArguments()
            if (r6 != 0) goto L_0x004b
            r6 = 0
            goto L_0x0051
        L_0x004b:
            java.lang.String r7 = "merchantCountryCode"
            java.lang.String r6 = r6.getString(r7)
        L_0x0051:
            if (r6 != 0) goto L_0x0054
            r6 = r3
        L_0x0054:
            android.os.Bundle r7 = r24.getArguments()
            if (r7 != 0) goto L_0x005c
            r7 = 0
            goto L_0x0062
        L_0x005c:
            java.lang.String r8 = "currencyCode"
            java.lang.String r7 = r7.getString(r8)
        L_0x0062:
            if (r7 != 0) goto L_0x0065
            r7 = r3
        L_0x0065:
            android.os.Bundle r8 = r24.getArguments()
            if (r8 != 0) goto L_0x006d
            r8 = 0
            goto L_0x0077
        L_0x006d:
            java.lang.String r9 = "googlePay"
            boolean r8 = r8.getBoolean(r9)
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)
        L_0x0077:
            android.os.Bundle r9 = r24.getArguments()
            if (r9 != 0) goto L_0x007f
            r9 = 0
            goto L_0x0089
        L_0x007f:
            java.lang.String r10 = "testEnv"
            boolean r9 = r9.getBoolean(r10)
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)
        L_0x0089:
            android.os.Bundle r10 = r24.getArguments()
            if (r10 != 0) goto L_0x0091
            r10 = 0
            goto L_0x009b
        L_0x0091:
            java.lang.String r11 = "allowsDelayedPaymentMethods"
            boolean r10 = r10.getBoolean(r11)
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r10)
        L_0x009b:
            android.os.Bundle r11 = r24.getArguments()
            if (r11 != 0) goto L_0x00a3
            r11 = 0
            goto L_0x00a9
        L_0x00a3:
            java.lang.String r12 = "primaryButtonColor"
            java.lang.String r11 = r11.getString(r12)
        L_0x00a9:
            if (r11 != 0) goto L_0x00ac
            r11 = r3
        L_0x00ac:
            android.os.Bundle r12 = r24.getArguments()
            if (r12 != 0) goto L_0x00b4
            r12 = 0
            goto L_0x00ba
        L_0x00b4:
            java.lang.String r13 = "defaultBillingDetails"
            android.os.Bundle r12 = r12.getBundle(r13)
        L_0x00ba:
            android.os.Bundle r13 = r24.getArguments()
            if (r13 != 0) goto L_0x00c2
            r13 = 0
            goto L_0x00c8
        L_0x00c2:
            java.lang.String r14 = "paymentIntentClientSecret"
            java.lang.String r13 = r13.getString(r14)
        L_0x00c8:
            if (r13 != 0) goto L_0x00cb
            r13 = r3
        L_0x00cb:
            r0.paymentIntentClientSecret = r13
            android.os.Bundle r13 = r24.getArguments()
            if (r13 != 0) goto L_0x00d5
            r13 = 0
            goto L_0x00db
        L_0x00d5:
            java.lang.String r14 = "setupIntentClientSecret"
            java.lang.String r13 = r13.getString(r14)
        L_0x00db:
            if (r13 != 0) goto L_0x00de
            goto L_0x00df
        L_0x00de:
            r3 = r13
        L_0x00df:
            r0.setupIntentClientSecret = r3
            com.reactnativestripesdk.-$$Lambda$PaymentSheetFragment$_wb7ruZTDL1MAopJAMQfG3HIkGg r3 = new com.reactnativestripesdk.-$$Lambda$PaymentSheetFragment$_wb7ruZTDL1MAopJAMQfG3HIkGg
            r3.<init>()
            com.reactnativestripesdk.-$$Lambda$PaymentSheetFragment$YIJCgHSK1CUPc5Eg7QP1kmXZC9Q r13 = new com.reactnativestripesdk.-$$Lambda$PaymentSheetFragment$YIJCgHSK1CUPc5Eg7QP1kmXZC9Q
            r13.<init>()
            r14 = r11
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            int r14 = r14.length()
            r16 = 1
            if (r14 <= 0) goto L_0x00f8
            r14 = 1
            goto L_0x00f9
        L_0x00f8:
            r14 = 0
        L_0x00f9:
            if (r14 == 0) goto L_0x0104
            int r11 = android.graphics.Color.parseColor(r11)
            android.content.res.ColorStateList r11 = android.content.res.ColorStateList.valueOf(r11)
            goto L_0x0105
        L_0x0104:
            r11 = 0
        L_0x0105:
            if (r12 == 0) goto L_0x017e
            java.lang.String r14 = "address"
            android.os.Bundle r14 = r12.getBundle(r14)
            com.stripe.android.paymentsheet.PaymentSheet$Address r15 = new com.stripe.android.paymentsheet.PaymentSheet$Address
            if (r14 != 0) goto L_0x0114
            r18 = 0
            goto L_0x011c
        L_0x0114:
            java.lang.String r2 = "city"
            java.lang.String r2 = r14.getString(r2)
            r18 = r2
        L_0x011c:
            if (r14 != 0) goto L_0x0121
            r19 = 0
            goto L_0x0129
        L_0x0121:
            java.lang.String r2 = "country"
            java.lang.String r2 = r14.getString(r2)
            r19 = r2
        L_0x0129:
            if (r14 != 0) goto L_0x012e
            r20 = 0
            goto L_0x0136
        L_0x012e:
            java.lang.String r2 = "line1"
            java.lang.String r2 = r14.getString(r2)
            r20 = r2
        L_0x0136:
            if (r14 != 0) goto L_0x013b
            r21 = 0
            goto L_0x0143
        L_0x013b:
            java.lang.String r2 = "line2"
            java.lang.String r2 = r14.getString(r2)
            r21 = r2
        L_0x0143:
            if (r14 != 0) goto L_0x0148
            r22 = 0
            goto L_0x0150
        L_0x0148:
            java.lang.String r2 = "postalCode"
            java.lang.String r2 = r14.getString(r2)
            r22 = r2
        L_0x0150:
            if (r14 != 0) goto L_0x0155
            r23 = 0
            goto L_0x015d
        L_0x0155:
            java.lang.String r2 = "state"
            java.lang.String r2 = r14.getString(r2)
            r23 = r2
        L_0x015d:
            r17 = r15
            r17.<init>(r18, r19, r20, r21, r22, r23)
            com.stripe.android.paymentsheet.PaymentSheet$BillingDetails r2 = new com.stripe.android.paymentsheet.PaymentSheet$BillingDetails
            java.lang.String r14 = "email"
            java.lang.String r14 = r12.getString(r14)
            r17 = r3
            java.lang.String r3 = "name"
            java.lang.String r3 = r12.getString(r3)
            r18 = r13
            java.lang.String r13 = "phone"
            java.lang.String r12 = r12.getString(r13)
            r2.<init>(r15, r14, r3, r12)
            goto L_0x0183
        L_0x017e:
            r17 = r3
            r18 = r13
            r2 = 0
        L_0x0183:
            if (r10 != 0) goto L_0x0187
            r10 = 0
            goto L_0x018c
        L_0x0187:
            boolean r3 = r10.booleanValue()
            r10 = r3
        L_0x018c:
            r3 = r1
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r3 = r3.length()
            if (r3 <= 0) goto L_0x0197
            r3 = 1
            goto L_0x0198
        L_0x0197:
            r3 = 0
        L_0x0198:
            if (r3 == 0) goto L_0x01ae
            r3 = r4
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r3 = r3.length()
            if (r3 <= 0) goto L_0x01a5
            r15 = 1
            goto L_0x01a6
        L_0x01a5:
            r15 = 0
        L_0x01a6:
            if (r15 == 0) goto L_0x01ae
            com.stripe.android.paymentsheet.PaymentSheet$CustomerConfiguration r3 = new com.stripe.android.paymentsheet.PaymentSheet$CustomerConfiguration
            r3.<init>(r1, r4)
            goto L_0x01af
        L_0x01ae:
            r3 = 0
        L_0x01af:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r16)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r1)
            if (r1 == 0) goto L_0x01cf
            com.stripe.android.paymentsheet.PaymentSheet$GooglePayConfiguration r1 = new com.stripe.android.paymentsheet.PaymentSheet$GooglePayConfiguration
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r16)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r4)
            if (r4 == 0) goto L_0x01c8
            com.stripe.android.paymentsheet.PaymentSheet$GooglePayConfiguration$Environment r4 = com.stripe.android.paymentsheet.PaymentSheet.GooglePayConfiguration.Environment.Test
            goto L_0x01ca
        L_0x01c8:
            com.stripe.android.paymentsheet.PaymentSheet$GooglePayConfiguration$Environment r4 = com.stripe.android.paymentsheet.PaymentSheet.GooglePayConfiguration.Environment.Production
        L_0x01ca:
            r1.<init>(r4, r6, r7)
            r7 = r1
            goto L_0x01d0
        L_0x01cf:
            r7 = 0
        L_0x01d0:
            com.stripe.android.paymentsheet.PaymentSheet$Configuration r1 = new com.stripe.android.paymentsheet.PaymentSheet$Configuration
            r4 = r1
            r6 = r3
            r8 = r11
            r9 = r2
            r4.<init>(r5, r6, r7, r8, r9, r10)
            r0.paymentSheetConfiguration = r1
            android.os.Bundle r1 = r24.getArguments()
            if (r1 != 0) goto L_0x01e3
            r1 = 0
            goto L_0x01ed
        L_0x01e3:
            java.lang.String r2 = "customFlow"
            boolean r1 = r1.getBoolean(r2)
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
        L_0x01ed:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r16)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 == 0) goto L_0x020a
            com.stripe.android.paymentsheet.PaymentSheet$FlowController$Companion r1 = com.stripe.android.paymentsheet.PaymentSheet.FlowController.Companion
            r2 = r0
            androidx.fragment.app.Fragment r2 = (androidx.fragment.app.Fragment) r2
            r3 = r17
            r4 = r18
            com.stripe.android.paymentsheet.PaymentSheet$FlowController r1 = r1.create((androidx.fragment.app.Fragment) r2, (com.stripe.android.paymentsheet.PaymentOptionCallback) r3, (com.stripe.android.paymentsheet.PaymentSheetResultCallback) r4)
            r0.flowController = r1
            r24.configureFlowController()
            goto L_0x0226
        L_0x020a:
            r4 = r18
            com.stripe.android.paymentsheet.PaymentSheet r1 = new com.stripe.android.paymentsheet.PaymentSheet
            r2 = r0
            androidx.fragment.app.Fragment r2 = (androidx.fragment.app.Fragment) r2
            r1.<init>((androidx.fragment.app.Fragment) r2, (com.stripe.android.paymentsheet.PaymentSheetResultCallback) r4)
            r0.paymentSheet = r1
            android.content.Intent r1 = new android.content.Intent
            java.lang.String r2 = com.reactnativestripesdk.ConstantsKt.getON_INIT_PAYMENT_SHEET()
            r1.<init>(r2)
            androidx.localbroadcastmanager.content.LocalBroadcastManager r2 = r0.localBroadcastManager
            if (r2 == 0) goto L_0x0227
            r2.sendBroadcast(r1)
        L_0x0226:
            return
        L_0x0227:
            java.lang.String r1 = "localBroadcastManager"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r1 = 0
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativestripesdk.PaymentSheetFragment.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-1  reason: not valid java name */
    public static final void m4278onViewCreated$lambda1(PaymentSheetFragment paymentSheetFragment, PaymentOption paymentOption) {
        Intrinsics.checkNotNullParameter(paymentSheetFragment, "this$0");
        Intent intent = new Intent(ConstantsKt.getON_PAYMENT_OPTION_ACTION());
        if (paymentOption != null) {
            String base64FromBitmap = PaymentSheetFragmentKt.getBase64FromBitmap(PaymentSheetFragmentKt.getBitmapFromVectorDrawable(paymentSheetFragment.getContext(), paymentOption.getDrawableResourceId()));
            intent.putExtra(AnnotatedPrivateKey.LABEL, paymentOption.getLabel());
            intent.putExtra("image", base64FromBitmap);
        }
        LocalBroadcastManager localBroadcastManager2 = paymentSheetFragment.localBroadcastManager;
        if (localBroadcastManager2 != null) {
            localBroadcastManager2.sendBroadcast(intent);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("localBroadcastManager");
            throw null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-2  reason: not valid java name */
    public static final void m4279onViewCreated$lambda2(PaymentSheetFragment paymentSheetFragment, PaymentSheetResult paymentSheetResult) {
        Intrinsics.checkNotNullParameter(paymentSheetFragment, "this$0");
        Intrinsics.checkNotNullParameter(paymentSheetResult, "paymentResult");
        Intent intent = new Intent(ConstantsKt.getON_PAYMENT_RESULT_ACTION());
        intent.putExtra("paymentResult", paymentSheetResult);
        LocalBroadcastManager localBroadcastManager2 = paymentSheetFragment.localBroadcastManager;
        if (localBroadcastManager2 != null) {
            localBroadcastManager2.sendBroadcast(intent);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("localBroadcastManager");
            throw null;
        }
    }

    public final void present() {
        PaymentSheet paymentSheet2;
        if (this.paymentSheet != null) {
            CharSequence charSequence = this.paymentIntentClientSecret;
            boolean z = false;
            if (!(charSequence == null || charSequence.length() == 0)) {
                PaymentSheet paymentSheet3 = this.paymentSheet;
                if (paymentSheet3 != null) {
                    String str = this.paymentIntentClientSecret;
                    Intrinsics.checkNotNull(str);
                    PaymentSheet.Configuration configuration = this.paymentSheetConfiguration;
                    if (configuration != null) {
                        paymentSheet3.presentWithPaymentIntent(str, configuration);
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("paymentSheetConfiguration");
                        throw null;
                    }
                }
            } else {
                CharSequence charSequence2 = this.setupIntentClientSecret;
                if (charSequence2 == null || charSequence2.length() == 0) {
                    z = true;
                }
                if (!z && (paymentSheet2 = this.paymentSheet) != null) {
                    String str2 = this.setupIntentClientSecret;
                    Intrinsics.checkNotNull(str2);
                    PaymentSheet.Configuration configuration2 = this.paymentSheetConfiguration;
                    if (configuration2 != null) {
                        paymentSheet2.presentWithSetupIntent(str2, configuration2);
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("paymentSheetConfiguration");
                        throw null;
                    }
                }
            }
        } else {
            PaymentSheet.FlowController flowController2 = this.flowController;
            if (flowController2 != null && flowController2 != null) {
                flowController2.presentPaymentOptions();
            }
        }
    }

    public final void confirmPayment() {
        PaymentSheet.FlowController flowController2 = this.flowController;
        if (flowController2 != null) {
            flowController2.confirm();
        }
    }

    private final void configureFlowController() {
        PaymentSheet.FlowController flowController2;
        $$Lambda$PaymentSheetFragment$aM_gzj09epDx4x5hnV8uBA6xkB0 r0 = new PaymentSheet.FlowController.ConfigCallback() {
            public final void onConfigured(boolean z, Throwable th) {
                PaymentSheetFragment.m4277configureFlowController$lambda4(PaymentSheetFragment.this, z, th);
            }
        };
        CharSequence charSequence = this.paymentIntentClientSecret;
        boolean z = false;
        if (!(charSequence == null || charSequence.length() == 0)) {
            PaymentSheet.FlowController flowController3 = this.flowController;
            if (flowController3 != null) {
                String str = this.paymentIntentClientSecret;
                Intrinsics.checkNotNull(str);
                PaymentSheet.Configuration configuration = this.paymentSheetConfiguration;
                if (configuration != null) {
                    flowController3.configureWithPaymentIntent(str, configuration, r0);
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("paymentSheetConfiguration");
                    throw null;
                }
            }
        } else {
            CharSequence charSequence2 = this.setupIntentClientSecret;
            if (charSequence2 == null || charSequence2.length() == 0) {
                z = true;
            }
            if (!z && (flowController2 = this.flowController) != null) {
                String str2 = this.setupIntentClientSecret;
                Intrinsics.checkNotNull(str2);
                PaymentSheet.Configuration configuration2 = this.paymentSheetConfiguration;
                if (configuration2 != null) {
                    flowController2.configureWithSetupIntent(str2, configuration2, r0);
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("paymentSheetConfiguration");
                    throw null;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: configureFlowController$lambda-4  reason: not valid java name */
    public static final void m4277configureFlowController$lambda4(PaymentSheetFragment paymentSheetFragment, boolean z, Throwable th) {
        Intrinsics.checkNotNullParameter(paymentSheetFragment, "this$0");
        PaymentSheet.FlowController flowController2 = paymentSheetFragment.flowController;
        PaymentOption paymentOption = flowController2 == null ? null : flowController2.getPaymentOption();
        Intent intent = new Intent(ConstantsKt.getON_CONFIGURE_FLOW_CONTROLLER());
        if (paymentOption != null) {
            String base64FromBitmap = PaymentSheetFragmentKt.getBase64FromBitmap(PaymentSheetFragmentKt.getBitmapFromVectorDrawable(paymentSheetFragment.getContext(), paymentOption.getDrawableResourceId()));
            intent.putExtra(AnnotatedPrivateKey.LABEL, paymentOption.getLabel());
            intent.putExtra("image", base64FromBitmap);
        }
        LocalBroadcastManager localBroadcastManager2 = paymentSheetFragment.localBroadcastManager;
        if (localBroadcastManager2 != null) {
            localBroadcastManager2.sendBroadcast(intent);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("localBroadcastManager");
            throw null;
        }
    }
}
