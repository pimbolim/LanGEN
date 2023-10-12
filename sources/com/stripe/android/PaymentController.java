package com.stripe.android;

import android.content.Intent;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import com.stripe.android.core.exception.APIConnectionException;
import com.stripe.android.core.exception.APIException;
import com.stripe.android.core.exception.AuthenticationException;
import com.stripe.android.core.exception.InvalidRequestException;
import com.stripe.android.core.networking.ApiRequest;
import com.stripe.android.model.ConfirmPaymentIntentParams;
import com.stripe.android.model.ConfirmStripeIntentParams;
import com.stripe.android.model.Source;
import com.stripe.android.model.StripeIntent;
import com.stripe.android.model.WeChatPayNextAction;
import com.stripe.android.payments.PaymentFlowResult;
import com.stripe.android.view.AuthActivityStarterHost;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001:\u00017J)\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH¦@ø\u0001\u0000¢\u0006\u0002\u0010\nJ!\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH¦@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0019\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0011H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J)\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\b\u001a\u00020\tH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ\u001e\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!H&J\u001a\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J\u001a\u0010'\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J\u001a\u0010(\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J1\u0010)\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010*\u001a\u00020+2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010,\u001a\u00020-H¦@ø\u0001\u0000¢\u0006\u0002\u0010.J)\u0010/\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u00100\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH¦@ø\u0001\u0000¢\u0006\u0002\u00101J)\u00102\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u00103\u001a\u0002042\u0006\u0010\b\u001a\u00020\tH¦@ø\u0001\u0000¢\u0006\u0002\u00105J\b\u00106\u001a\u00020\u0017H&\u0002\u0004\n\u0002\b\u0019¨\u00068"}, d2 = {"Lcom/stripe/android/PaymentController;", "", "confirmAndAuthenticateAlipay", "Lcom/stripe/android/PaymentIntentResult;", "confirmPaymentIntentParams", "Lcom/stripe/android/model/ConfirmPaymentIntentParams;", "authenticator", "Lcom/stripe/android/AlipayAuthenticator;", "requestOptions", "Lcom/stripe/android/core/networking/ApiRequest$Options;", "(Lcom/stripe/android/model/ConfirmPaymentIntentParams;Lcom/stripe/android/AlipayAuthenticator;Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmWeChatPay", "Lcom/stripe/android/model/WeChatPayNextAction;", "(Lcom/stripe/android/model/ConfirmPaymentIntentParams;Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAuthenticateSourceResult", "Lcom/stripe/android/model/Source;", "data", "Landroid/content/Intent;", "(Landroid/content/Intent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPaymentIntentResult", "getSetupIntentResult", "Lcom/stripe/android/SetupIntentResult;", "handleNextAction", "", "host", "Lcom/stripe/android/view/AuthActivityStarterHost;", "stripeIntent", "Lcom/stripe/android/model/StripeIntent;", "(Lcom/stripe/android/view/AuthActivityStarterHost;Lcom/stripe/android/model/StripeIntent;Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerLaunchersWithActivityResultCaller", "activityResultCaller", "Landroidx/activity/result/ActivityResultCaller;", "activityResultCallback", "Landroidx/activity/result/ActivityResultCallback;", "Lcom/stripe/android/payments/PaymentFlowResult$Unvalidated;", "shouldHandlePaymentResult", "", "requestCode", "", "shouldHandleSetupResult", "shouldHandleSourceResult", "startAuth", "clientSecret", "", "type", "Lcom/stripe/android/PaymentController$StripeIntentType;", "(Lcom/stripe/android/view/AuthActivityStarterHost;Ljava/lang/String;Lcom/stripe/android/core/networking/ApiRequest$Options;Lcom/stripe/android/PaymentController$StripeIntentType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startAuthenticateSource", "source", "(Lcom/stripe/android/view/AuthActivityStarterHost;Lcom/stripe/android/model/Source;Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startConfirmAndAuth", "confirmStripeIntentParams", "Lcom/stripe/android/model/ConfirmStripeIntentParams;", "(Lcom/stripe/android/view/AuthActivityStarterHost;Lcom/stripe/android/model/ConfirmStripeIntentParams;Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unregisterLaunchers", "StripeIntentType", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentController.kt */
public interface PaymentController {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/PaymentController$StripeIntentType;", "", "(Ljava/lang/String;I)V", "PaymentIntent", "SetupIntent", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentController.kt */
    public enum StripeIntentType {
        PaymentIntent,
        SetupIntent
    }

    Object confirmAndAuthenticateAlipay(ConfirmPaymentIntentParams confirmPaymentIntentParams, AlipayAuthenticator alipayAuthenticator, ApiRequest.Options options, Continuation<? super PaymentIntentResult> continuation) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException, IllegalArgumentException;

    Object confirmWeChatPay(ConfirmPaymentIntentParams confirmPaymentIntentParams, ApiRequest.Options options, Continuation<? super WeChatPayNextAction> continuation) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException, IllegalArgumentException;

    Object getAuthenticateSourceResult(Intent intent, Continuation<? super Source> continuation) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException, IllegalArgumentException;

    Object getPaymentIntentResult(Intent intent, Continuation<? super PaymentIntentResult> continuation) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException, IllegalArgumentException;

    Object getSetupIntentResult(Intent intent, Continuation<? super SetupIntentResult> continuation) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException, IllegalArgumentException;

    Object handleNextAction(AuthActivityStarterHost authActivityStarterHost, StripeIntent stripeIntent, ApiRequest.Options options, Continuation<? super Unit> continuation);

    void registerLaunchersWithActivityResultCaller(ActivityResultCaller activityResultCaller, ActivityResultCallback<PaymentFlowResult.Unvalidated> activityResultCallback);

    boolean shouldHandlePaymentResult(int i, Intent intent);

    boolean shouldHandleSetupResult(int i, Intent intent);

    boolean shouldHandleSourceResult(int i, Intent intent);

    Object startAuth(AuthActivityStarterHost authActivityStarterHost, String str, ApiRequest.Options options, StripeIntentType stripeIntentType, Continuation<? super Unit> continuation);

    Object startAuthenticateSource(AuthActivityStarterHost authActivityStarterHost, Source source, ApiRequest.Options options, Continuation<? super Unit> continuation);

    Object startConfirmAndAuth(AuthActivityStarterHost authActivityStarterHost, ConfirmStripeIntentParams confirmStripeIntentParams, ApiRequest.Options options, Continuation<? super Unit> continuation);

    void unregisterLaunchers();
}
