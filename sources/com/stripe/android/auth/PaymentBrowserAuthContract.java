package com.stripe.android.auth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.Window;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.os.BundleKt;
import com.braintreepayments.api.internal.GraphQLConstants;
import com.stripe.android.core.exception.StripeException;
import com.stripe.android.model.Source;
import com.stripe.android.payments.DefaultReturnUrl;
import com.stripe.android.payments.PaymentFlowResult;
import com.stripe.android.payments.StripeBrowserLauncherActivity;
import com.stripe.android.stripe3ds2.init.ui.StripeToolbarCustomization;
import com.stripe.android.view.PaymentAuthWebViewActivity;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u0000 \u000f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u000e\u000fB\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0010"}, d2 = {"Lcom/stripe/android/auth/PaymentBrowserAuthContract;", "Landroidx/activity/result/contract/ActivityResultContract;", "Lcom/stripe/android/auth/PaymentBrowserAuthContract$Args;", "Lcom/stripe/android/payments/PaymentFlowResult$Unvalidated;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "parseResult", "resultCode", "", "intent", "Args", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentBrowserAuthContract.kt */
public final class PaymentBrowserAuthContract extends ActivityResultContract<Args, PaymentFlowResult.Unvalidated> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String EXTRA_ARGS = "extra_args";

    public Intent createIntent(Context context, Args args) {
        Class cls;
        Window window;
        Context context2 = context;
        Args args2 = args;
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(args2, GraphQLConstants.Keys.INPUT);
        boolean z = args2.hasDefaultReturnUrl$payments_core_release(DefaultReturnUrl.Companion.create(context2)) || args.isInstantApp();
        Bundle bundle = Args.copy$default(args, (String) null, 0, (String) null, (String) null, (String) null, false, (StripeToolbarCustomization) null, (String) null, false, false, (!(context2 instanceof Activity) || (window = ((Activity) context2).getWindow()) == null) ? null : Integer.valueOf(window.getStatusBarColor()), (String) null, false, 7167, (Object) null).toBundle();
        boolean z2 = z;
        if (z2) {
            cls = StripeBrowserLauncherActivity.class;
        } else if (!z2) {
            cls = PaymentAuthWebViewActivity.class;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        Intent intent = new Intent(context2, cls);
        intent.putExtras(bundle);
        return intent;
    }

    public PaymentFlowResult.Unvalidated parseResult(int i, Intent intent) {
        PaymentFlowResult.Unvalidated unvalidated = intent == null ? null : (PaymentFlowResult.Unvalidated) intent.getParcelableExtra(EXTRA_ARGS);
        return unvalidated == null ? new PaymentFlowResult.Unvalidated((String) null, 0, (StripeException) null, false, (String) null, (Source) null, (String) null, 127, (DefaultConstructorMarker) null) : unvalidated;
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u0000 G2\u00020\u0001:\u0001GB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\u0006\u0010\u0015\u001a\u00020\r¢\u0006\u0002\u0010\u0016J\t\u0010)\u001a\u00020\u0006HÆ\u0003J\t\u0010*\u001a\u00020\rHÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010#J\t\u0010,\u001a\u00020\u0006HÆ\u0003J\t\u0010-\u001a\u00020\rHÆ\u0003J\t\u0010.\u001a\u00020\bHÆ\u0003J\t\u0010/\u001a\u00020\u0006HÆ\u0003J\t\u00100\u001a\u00020\u0006HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u00102\u001a\u00020\rHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u00105\u001a\u00020\rHÆ\u0003J\u0001\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\rHÆ\u0001¢\u0006\u0002\u00107J\b\u00108\u001a\u00020\bH\u0016J\u0013\u00109\u001a\u00020\r2\b\u0010:\u001a\u0004\u0018\u00010;HÖ\u0003J\u0015\u0010<\u001a\u00020\r2\u0006\u0010=\u001a\u00020>H\u0000¢\u0006\u0002\b?J\t\u0010@\u001a\u00020\bHÖ\u0001J\u0006\u0010A\u001a\u00020BJ\t\u0010C\u001a\u00020\u0006HÖ\u0001J\u0018\u0010D\u001a\u00020E2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010F\u001a\u00020\bH\u0016R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0015\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u001aR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0011\u0010\u0014\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0011\u0010\u0012\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0011\u0010\u0011\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0015\u0010\u0013\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0018R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0018¨\u0006H"}, d2 = {"Lcom/stripe/android/auth/PaymentBrowserAuthContract$Args;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "objectId", "", "requestCode", "", "clientSecret", "url", "returnUrl", "enableLogging", "", "toolbarCustomization", "Lcom/stripe/android/stripe3ds2/init/ui/StripeToolbarCustomization;", "stripeAccountId", "shouldCancelSource", "shouldCancelIntentOnUserNavigation", "statusBarColor", "publishableKey", "isInstantApp", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/stripe/android/stripe3ds2/init/ui/StripeToolbarCustomization;Ljava/lang/String;ZZLjava/lang/Integer;Ljava/lang/String;Z)V", "getClientSecret", "()Ljava/lang/String;", "getEnableLogging", "()Z", "getObjectId", "getPublishableKey", "getRequestCode", "()I", "getReturnUrl", "getShouldCancelIntentOnUserNavigation", "getShouldCancelSource", "getStatusBarColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getStripeAccountId", "getToolbarCustomization", "()Lcom/stripe/android/stripe3ds2/init/ui/StripeToolbarCustomization;", "getUrl", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/stripe/android/stripe3ds2/init/ui/StripeToolbarCustomization;Ljava/lang/String;ZZLjava/lang/Integer;Ljava/lang/String;Z)Lcom/stripe/android/auth/PaymentBrowserAuthContract$Args;", "describeContents", "equals", "other", "", "hasDefaultReturnUrl", "defaultReturnUrl", "Lcom/stripe/android/payments/DefaultReturnUrl;", "hasDefaultReturnUrl$payments_core_release", "hashCode", "toBundle", "Landroid/os/Bundle;", "toString", "writeToParcel", "", "flags", "CREATOR", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentBrowserAuthContract.kt */
    public static final class Args implements Parcelable {
        public static final CREATOR CREATOR = new CREATOR((DefaultConstructorMarker) null);
        private final String clientSecret;
        private final boolean enableLogging;
        private final boolean isInstantApp;
        private final String objectId;
        private final String publishableKey;
        private final int requestCode;
        private final String returnUrl;
        private final boolean shouldCancelIntentOnUserNavigation;
        private final boolean shouldCancelSource;
        private final Integer statusBarColor;
        private final String stripeAccountId;
        private final StripeToolbarCustomization toolbarCustomization;
        private final String url;

        public static /* synthetic */ Args copy$default(Args args, String str, int i, String str2, String str3, String str4, boolean z, StripeToolbarCustomization stripeToolbarCustomization, String str5, boolean z2, boolean z3, Integer num, String str6, boolean z4, int i2, Object obj) {
            Args args2 = args;
            int i3 = i2;
            return args.copy((i3 & 1) != 0 ? args2.objectId : str, (i3 & 2) != 0 ? args2.requestCode : i, (i3 & 4) != 0 ? args2.clientSecret : str2, (i3 & 8) != 0 ? args2.url : str3, (i3 & 16) != 0 ? args2.returnUrl : str4, (i3 & 32) != 0 ? args2.enableLogging : z, (i3 & 64) != 0 ? args2.toolbarCustomization : stripeToolbarCustomization, (i3 & 128) != 0 ? args2.stripeAccountId : str5, (i3 & 256) != 0 ? args2.shouldCancelSource : z2, (i3 & 512) != 0 ? args2.shouldCancelIntentOnUserNavigation : z3, (i3 & 1024) != 0 ? args2.statusBarColor : num, (i3 & 2048) != 0 ? args2.publishableKey : str6, (i3 & 4096) != 0 ? args2.isInstantApp : z4);
        }

        public final String component1() {
            return this.objectId;
        }

        public final boolean component10() {
            return this.shouldCancelIntentOnUserNavigation;
        }

        public final Integer component11() {
            return this.statusBarColor;
        }

        public final String component12() {
            return this.publishableKey;
        }

        public final boolean component13() {
            return this.isInstantApp;
        }

        public final int component2() {
            return this.requestCode;
        }

        public final String component3() {
            return this.clientSecret;
        }

        public final String component4() {
            return this.url;
        }

        public final String component5() {
            return this.returnUrl;
        }

        public final boolean component6() {
            return this.enableLogging;
        }

        public final StripeToolbarCustomization component7() {
            return this.toolbarCustomization;
        }

        public final String component8() {
            return this.stripeAccountId;
        }

        public final boolean component9() {
            return this.shouldCancelSource;
        }

        public final Args copy(String str, int i, String str2, String str3, String str4, boolean z, StripeToolbarCustomization stripeToolbarCustomization, String str5, boolean z2, boolean z3, Integer num, String str6, boolean z4) {
            String str7 = str;
            Intrinsics.checkNotNullParameter(str7, "objectId");
            String str8 = str2;
            Intrinsics.checkNotNullParameter(str8, "clientSecret");
            String str9 = str3;
            Intrinsics.checkNotNullParameter(str9, "url");
            String str10 = str6;
            Intrinsics.checkNotNullParameter(str10, "publishableKey");
            return new Args(str7, i, str8, str9, str4, z, stripeToolbarCustomization, str5, z2, z3, num, str10, z4);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Args)) {
                return false;
            }
            Args args = (Args) obj;
            return Intrinsics.areEqual((Object) this.objectId, (Object) args.objectId) && this.requestCode == args.requestCode && Intrinsics.areEqual((Object) this.clientSecret, (Object) args.clientSecret) && Intrinsics.areEqual((Object) this.url, (Object) args.url) && Intrinsics.areEqual((Object) this.returnUrl, (Object) args.returnUrl) && this.enableLogging == args.enableLogging && Intrinsics.areEqual((Object) this.toolbarCustomization, (Object) args.toolbarCustomization) && Intrinsics.areEqual((Object) this.stripeAccountId, (Object) args.stripeAccountId) && this.shouldCancelSource == args.shouldCancelSource && this.shouldCancelIntentOnUserNavigation == args.shouldCancelIntentOnUserNavigation && Intrinsics.areEqual((Object) this.statusBarColor, (Object) args.statusBarColor) && Intrinsics.areEqual((Object) this.publishableKey, (Object) args.publishableKey) && this.isInstantApp == args.isInstantApp;
        }

        public int hashCode() {
            int hashCode = ((((((this.objectId.hashCode() * 31) + this.requestCode) * 31) + this.clientSecret.hashCode()) * 31) + this.url.hashCode()) * 31;
            String str = this.returnUrl;
            int i = 0;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            boolean z = this.enableLogging;
            boolean z2 = true;
            if (z) {
                z = true;
            }
            int i2 = (hashCode2 + (z ? 1 : 0)) * 31;
            StripeToolbarCustomization stripeToolbarCustomization = this.toolbarCustomization;
            int hashCode3 = (i2 + (stripeToolbarCustomization == null ? 0 : stripeToolbarCustomization.hashCode())) * 31;
            String str2 = this.stripeAccountId;
            int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
            boolean z3 = this.shouldCancelSource;
            if (z3) {
                z3 = true;
            }
            int i3 = (hashCode4 + (z3 ? 1 : 0)) * 31;
            boolean z4 = this.shouldCancelIntentOnUserNavigation;
            if (z4) {
                z4 = true;
            }
            int i4 = (i3 + (z4 ? 1 : 0)) * 31;
            Integer num = this.statusBarColor;
            if (num != null) {
                i = num.hashCode();
            }
            int hashCode5 = (((i4 + i) * 31) + this.publishableKey.hashCode()) * 31;
            boolean z5 = this.isInstantApp;
            if (!z5) {
                z2 = z5;
            }
            return hashCode5 + (z2 ? 1 : 0);
        }

        public String toString() {
            return "Args(objectId=" + this.objectId + ", requestCode=" + this.requestCode + ", clientSecret=" + this.clientSecret + ", url=" + this.url + ", returnUrl=" + this.returnUrl + ", enableLogging=" + this.enableLogging + ", toolbarCustomization=" + this.toolbarCustomization + ", stripeAccountId=" + this.stripeAccountId + ", shouldCancelSource=" + this.shouldCancelSource + ", shouldCancelIntentOnUserNavigation=" + this.shouldCancelIntentOnUserNavigation + ", statusBarColor=" + this.statusBarColor + ", publishableKey=" + this.publishableKey + ", isInstantApp=" + this.isInstantApp + ')';
        }

        public Args(String str, int i, String str2, String str3, String str4, boolean z, StripeToolbarCustomization stripeToolbarCustomization, String str5, boolean z2, boolean z3, Integer num, String str6, boolean z4) {
            Intrinsics.checkNotNullParameter(str, "objectId");
            Intrinsics.checkNotNullParameter(str2, "clientSecret");
            Intrinsics.checkNotNullParameter(str3, "url");
            Intrinsics.checkNotNullParameter(str6, "publishableKey");
            this.objectId = str;
            this.requestCode = i;
            this.clientSecret = str2;
            this.url = str3;
            this.returnUrl = str4;
            this.enableLogging = z;
            this.toolbarCustomization = stripeToolbarCustomization;
            this.stripeAccountId = str5;
            this.shouldCancelSource = z2;
            this.shouldCancelIntentOnUserNavigation = z3;
            this.statusBarColor = num;
            this.publishableKey = str6;
            this.isInstantApp = z4;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ Args(java.lang.String r18, int r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, boolean r23, com.stripe.android.stripe3ds2.init.ui.StripeToolbarCustomization r24, java.lang.String r25, boolean r26, boolean r27, java.lang.Integer r28, java.lang.String r29, boolean r30, int r31, kotlin.jvm.internal.DefaultConstructorMarker r32) {
            /*
                r17 = this;
                r0 = r31
                r1 = r0 & 16
                r2 = 0
                if (r1 == 0) goto L_0x0009
                r8 = r2
                goto L_0x000b
            L_0x0009:
                r8 = r22
            L_0x000b:
                r1 = r0 & 32
                r3 = 0
                if (r1 == 0) goto L_0x0012
                r9 = 0
                goto L_0x0014
            L_0x0012:
                r9 = r23
            L_0x0014:
                r1 = r0 & 64
                if (r1 == 0) goto L_0x001a
                r10 = r2
                goto L_0x001c
            L_0x001a:
                r10 = r24
            L_0x001c:
                r1 = r0 & 128(0x80, float:1.794E-43)
                if (r1 == 0) goto L_0x0022
                r11 = r2
                goto L_0x0024
            L_0x0022:
                r11 = r25
            L_0x0024:
                r1 = r0 & 256(0x100, float:3.59E-43)
                if (r1 == 0) goto L_0x002a
                r12 = 0
                goto L_0x002c
            L_0x002a:
                r12 = r26
            L_0x002c:
                r1 = r0 & 512(0x200, float:7.175E-43)
                if (r1 == 0) goto L_0x0033
                r1 = 1
                r13 = 1
                goto L_0x0035
            L_0x0033:
                r13 = r27
            L_0x0035:
                r0 = r0 & 1024(0x400, float:1.435E-42)
                if (r0 == 0) goto L_0x003b
                r14 = r2
                goto L_0x003d
            L_0x003b:
                r14 = r28
            L_0x003d:
                r3 = r17
                r4 = r18
                r5 = r19
                r6 = r20
                r7 = r21
                r15 = r29
                r16 = r30
                r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.auth.PaymentBrowserAuthContract.Args.<init>(java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, boolean, com.stripe.android.stripe3ds2.init.ui.StripeToolbarCustomization, java.lang.String, boolean, boolean, java.lang.Integer, java.lang.String, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public final String getObjectId() {
            return this.objectId;
        }

        public final int getRequestCode() {
            return this.requestCode;
        }

        public final String getClientSecret() {
            return this.clientSecret;
        }

        public final String getUrl() {
            return this.url;
        }

        public final String getReturnUrl() {
            return this.returnUrl;
        }

        public final boolean getEnableLogging() {
            return this.enableLogging;
        }

        public final StripeToolbarCustomization getToolbarCustomization() {
            return this.toolbarCustomization;
        }

        public final String getStripeAccountId() {
            return this.stripeAccountId;
        }

        public final boolean getShouldCancelSource() {
            return this.shouldCancelSource;
        }

        public final boolean getShouldCancelIntentOnUserNavigation() {
            return this.shouldCancelIntentOnUserNavigation;
        }

        public final Integer getStatusBarColor() {
            return this.statusBarColor;
        }

        public final String getPublishableKey() {
            return this.publishableKey;
        }

        public final boolean isInstantApp() {
            return this.isInstantApp;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public Args(android.os.Parcel r18) {
            /*
                r17 = this;
                r0 = r18
                java.lang.String r1 = "parcel"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
                java.lang.String r1 = r18.readString()
                java.lang.String r2 = ""
                if (r1 != 0) goto L_0x0011
                r4 = r2
                goto L_0x0012
            L_0x0011:
                r4 = r1
            L_0x0012:
                int r5 = r18.readInt()
                java.lang.String r1 = r18.readString()
                if (r1 != 0) goto L_0x001e
                r6 = r2
                goto L_0x001f
            L_0x001e:
                r6 = r1
            L_0x001f:
                java.lang.String r1 = r18.readString()
                if (r1 != 0) goto L_0x0027
                r7 = r2
                goto L_0x0028
            L_0x0027:
                r7 = r1
            L_0x0028:
                java.lang.String r8 = r18.readString()
                byte r1 = r18.readByte()
                r3 = 1
                r9 = 0
                if (r1 == 0) goto L_0x0036
                r1 = 1
                goto L_0x0037
            L_0x0036:
                r1 = 0
            L_0x0037:
                java.lang.Class<com.stripe.android.stripe3ds2.init.ui.StripeToolbarCustomization> r10 = com.stripe.android.stripe3ds2.init.ui.StripeToolbarCustomization.class
                java.lang.ClassLoader r10 = r10.getClassLoader()
                android.os.Parcelable r10 = r0.readParcelable(r10)
                com.stripe.android.stripe3ds2.init.ui.StripeToolbarCustomization r10 = (com.stripe.android.stripe3ds2.init.ui.StripeToolbarCustomization) r10
                java.lang.String r11 = r18.readString()
                byte r12 = r18.readByte()
                if (r12 == 0) goto L_0x004f
                r12 = 1
                goto L_0x0050
            L_0x004f:
                r12 = 0
            L_0x0050:
                byte r13 = r18.readByte()
                if (r13 == 0) goto L_0x0058
                r13 = 1
                goto L_0x0059
            L_0x0058:
                r13 = 0
            L_0x0059:
                java.lang.Class r14 = java.lang.Integer.TYPE
                java.lang.ClassLoader r14 = r14.getClassLoader()
                java.lang.Object r14 = r0.readValue(r14)
                boolean r15 = r14 instanceof java.lang.Integer
                if (r15 == 0) goto L_0x006a
                java.lang.Integer r14 = (java.lang.Integer) r14
                goto L_0x006b
            L_0x006a:
                r14 = 0
            L_0x006b:
                java.lang.String r15 = r18.readString()
                if (r15 != 0) goto L_0x0072
                r15 = r2
            L_0x0072:
                byte r0 = r18.readByte()
                if (r0 == 0) goto L_0x007b
                r16 = 1
                goto L_0x007d
            L_0x007b:
                r16 = 0
            L_0x007d:
                r3 = r17
                r9 = r1
                r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.auth.PaymentBrowserAuthContract.Args.<init>(android.os.Parcel):void");
        }

        public final boolean hasDefaultReturnUrl$payments_core_release(DefaultReturnUrl defaultReturnUrl) {
            Intrinsics.checkNotNullParameter(defaultReturnUrl, "defaultReturnUrl");
            return Intrinsics.areEqual((Object) this.returnUrl, (Object) defaultReturnUrl.getValue());
        }

        public final Bundle toBundle() {
            return BundleKt.bundleOf(TuplesKt.to(PaymentBrowserAuthContract.EXTRA_ARGS, this));
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.objectId);
            parcel.writeInt(this.requestCode);
            parcel.writeString(this.clientSecret);
            parcel.writeString(this.url);
            parcel.writeString(this.returnUrl);
            parcel.writeByte(this.enableLogging ? (byte) 1 : 0);
            parcel.writeParcelable(this.toolbarCustomization, i);
            parcel.writeString(this.stripeAccountId);
            parcel.writeByte(this.shouldCancelSource ? (byte) 1 : 0);
            parcel.writeByte(this.shouldCancelIntentOnUserNavigation ? (byte) 1 : 0);
            parcel.writeValue(this.statusBarColor);
            parcel.writeString(this.publishableKey);
            parcel.writeByte(this.isInstantApp ? (byte) 1 : 0);
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/stripe/android/auth/PaymentBrowserAuthContract$Args$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/stripe/android/auth/PaymentBrowserAuthContract$Args;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/stripe/android/auth/PaymentBrowserAuthContract$Args;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentBrowserAuthContract.kt */
        public static final class CREATOR implements Parcelable.Creator<Args> {
            public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private CREATOR() {
            }

            public Args createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Args(parcel);
            }

            public Args[] newArray(int i) {
                return new Args[i];
            }
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b\tR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/stripe/android/auth/PaymentBrowserAuthContract$Companion;", "", "()V", "EXTRA_ARGS", "", "parseArgs", "Lcom/stripe/android/auth/PaymentBrowserAuthContract$Args;", "intent", "Landroid/content/Intent;", "parseArgs$payments_core_release", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentBrowserAuthContract.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Args parseArgs$payments_core_release(Intent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            return (Args) intent.getParcelableExtra(PaymentBrowserAuthContract.EXTRA_ARGS);
        }
    }
}
