package com.stripe.android.networking;

import com.stripe.android.cards.Bin;
import com.stripe.android.core.exception.APIConnectionException;
import com.stripe.android.core.exception.APIException;
import com.stripe.android.core.exception.AuthenticationException;
import com.stripe.android.core.exception.InvalidRequestException;
import com.stripe.android.core.model.StripeFile;
import com.stripe.android.core.model.StripeFileParams;
import com.stripe.android.core.networking.ApiRequest;
import com.stripe.android.exception.CardException;
import com.stripe.android.model.BankConnectionsLinkedAccountSession;
import com.stripe.android.model.BankStatuses;
import com.stripe.android.model.CardMetadata;
import com.stripe.android.model.ConfirmPaymentIntentParams;
import com.stripe.android.model.ConfirmSetupIntentParams;
import com.stripe.android.model.ConsumerPaymentDetails;
import com.stripe.android.model.ConsumerSession;
import com.stripe.android.model.ConsumerSessionLookup;
import com.stripe.android.model.CreateLinkAccountSessionParams;
import com.stripe.android.model.Customer;
import com.stripe.android.model.ListPaymentMethodsParams;
import com.stripe.android.model.PaymentIntent;
import com.stripe.android.model.PaymentMethod;
import com.stripe.android.model.PaymentMethodCreateParams;
import com.stripe.android.model.RadarSession;
import com.stripe.android.model.SetupIntent;
import com.stripe.android.model.ShippingInformation;
import com.stripe.android.model.Source;
import com.stripe.android.model.SourceParams;
import com.stripe.android.model.Stripe3ds2AuthParams;
import com.stripe.android.model.Stripe3ds2AuthResult;
import com.stripe.android.model.StripeIntent;
import com.stripe.android.model.Token;
import com.stripe.android.model.TokenParams;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JK\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH @ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ3\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH§@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J3\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH§@ø\u0001\u0000¢\u0006\u0002\u0010\u0015JA\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH§@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ-\u0010\u001d\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\rH @ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J-\u0010!\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\rH @ø\u0001\u0000¢\u0006\u0004\b\"\u0010 J%\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH @ø\u0001\u0000¢\u0006\u0004\b%\u0010&J5\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u00062\b\u0010+\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\rH§@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J5\u0010,\u001a\u0004\u0018\u00010\u00112\u0006\u0010-\u001a\u00020.2\u0006\u0010\u001e\u001a\u00020\r2\u000e\b\u0002\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000600H @ø\u0001\u0000¢\u0006\u0004\b1\u00102J5\u00103\u001a\u0004\u0018\u00010\u00172\u0006\u00104\u001a\u0002052\u0006\u0010\u001e\u001a\u00020\r2\u000e\b\u0002\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000600H @ø\u0001\u0000¢\u0006\u0004\b6\u00107J=\u00108\u001a\u0004\u0018\u00010(2\u0006\u00109\u001a\u00020\u00062\u0006\u0010:\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u00062\b\u0010+\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\rH§@ø\u0001\u0000¢\u0006\u0002\u0010<J#\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\u0006\u0010\f\u001a\u00020\rH @ø\u0001\u0000¢\u0006\u0004\bA\u0010BJ-\u0010C\u001a\u0004\u0018\u00010D2\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010E\u001a\u00020F2\u0006\u0010\f\u001a\u00020\rH @ø\u0001\u0000¢\u0006\u0004\bG\u0010HJ#\u0010I\u001a\u0004\u0018\u00010\u001a2\u0006\u0010J\u001a\u00020K2\u0006\u0010\u001e\u001a\u00020\rH§@ø\u0001\u0000¢\u0006\u0002\u0010LJ\u001d\u0010M\u001a\u0004\u0018\u00010N2\u0006\u0010\f\u001a\u00020\rH @ø\u0001\u0000¢\u0006\u0004\bO\u0010PJ-\u0010Q\u001a\u0004\u0018\u00010D2\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010E\u001a\u00020F2\u0006\u0010\f\u001a\u00020\rH @ø\u0001\u0000¢\u0006\u0004\bR\u0010HJ%\u0010S\u001a\u0004\u0018\u00010\u00042\u0006\u0010T\u001a\u00020U2\u0006\u0010\u001e\u001a\u00020\rH @ø\u0001\u0000¢\u0006\u0004\bV\u0010WJ%\u0010X\u001a\u0004\u0018\u00010Y2\u0006\u0010Z\u001a\u00020[2\u0006\u0010\u001e\u001a\u00020\rH @ø\u0001\u0000¢\u0006\u0004\b\\\u0010]JC\u0010^\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH @ø\u0001\u0000¢\u0006\u0004\b_\u0010\u001cJ9\u0010`\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH§@ø\u0001\u0000¢\u0006\u0002\u0010aJ%\u0010b\u001a\u0004\u0018\u00010c2\u0006\u0010d\u001a\u00020e2\u0006\u0010\u001e\u001a\u00020\rH @ø\u0001\u0000¢\u0006\u0004\bf\u0010gJ\u001b\u0010h\u001a\u00020i2\u0006\u0010\u001e\u001a\u00020\rH @ø\u0001\u0000¢\u0006\u0004\bj\u0010PJ=\u0010k\u001a\b\u0012\u0004\u0012\u00020\u001a002\u0006\u0010l\u001a\u00020m2\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t2\u0006\u0010\f\u001a\u00020\rH§@ø\u0001\u0000¢\u0006\u0002\u0010nJ1\u0010o\u001a\u0004\u0018\u00010p2\u0006\u0010)\u001a\u00020\u00062\f\u0010q\u001a\b\u0012\u0004\u0012\u00020\u00060\t2\u0006\u0010\f\u001a\u00020\rH§@ø\u0001\u0000¢\u0006\u0002\u0010rJ-\u0010s\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020\u00062\b\u0010+\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\rH§@ø\u0001\u0000¢\u0006\u0002\u0010 J-\u0010t\u001a\u0004\u0018\u00010u2\u0006\u00109\u001a\u00020\u00062\b\u0010+\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\rH§@ø\u0001\u0000¢\u0006\u0002\u0010 J%\u0010v\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\rH¡@ø\u0001\u0000¢\u0006\u0004\bw\u0010&J3\u0010x\u001a\u0004\u0018\u00010y2\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t2\u0006\u0010\f\u001a\u00020\rH @ø\u0001\u0000¢\u0006\u0004\bz\u0010rJ5\u0010{\u001a\u0004\u0018\u00010\u00062\u0006\u0010|\u001a\u00020\u00062\u0006\u0010}\u001a\u00020\u00062\u0006\u0010~\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH @ø\u0001\u0000¢\u0006\u0004\b\u0010\u0015J'\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH @ø\u0001\u0000¢\u0006\u0005\b\u0001\u0010&J5\u0010\u0001\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\r2\u000e\b\u0002\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000600H§@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J/\u0010\u0001\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\r2\b\u0010\u0001\u001a\u00030\u0001H§@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J5\u0010\u0001\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\r2\u000e\b\u0002\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000600H§@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J/\u0010\u0001\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\r2\b\u0010\u0001\u001a\u00030\u0001H§@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J/\u0010\u0001\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\rH @ø\u0001\u0000¢\u0006\u0005\b\u0001\u0010 J7\u0010\u0001\u001a\u00030\u00012\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\r2\u000e\b\u0002\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000600H @ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001JH\u0010\u0001\u001a\u0004\u0018\u00010y2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t2\b\u0010\u0001\u001a\u00030\u00012\u0006\u0010\f\u001a\u00020\rH @ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001JM\u0010\u0001\u001a\u0004\u0018\u00010y2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH @ø\u0001\u0000¢\u0006\u0005\b\u0001\u0010\u000fJ*\u0010\u0001\u001a\u0004\u0018\u00010$2\b\u0010\u0001\u001a\u00030\u00012\u0006\u0010\f\u001a\u00020\rH @ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J9\u0010\u0001\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020\u00062\b\u0010\u0001\u001a\u00030\u00012\b\u0010+\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\rH§@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J?\u0010\u0001\u001a\u00030 \u00012\u0006\u0010|\u001a\u00020\u00062\u0007\u0010¡\u0001\u001a\u00020\u00062\u0006\u0010}\u001a\u00020\u00062\u0006\u0010~\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH @ø\u0001\u0000¢\u0006\u0005\b¢\u0001\u0010<J9\u0010£\u0001\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010¤\u0001\u001a\u00030¥\u00012\b\u0010¦\u0001\u001a\u00030¥\u00012\u0006\u0010\f\u001a\u00020\rH§@ø\u0001\u0000¢\u0006\u0003\u0010§\u0001J-\u0010£\u0001\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00062\u0007\u0010¨\u0001\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH§@ø\u0001\u0000¢\u0006\u0002\u0010 J9\u0010©\u0001\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010¤\u0001\u001a\u00030¥\u00012\b\u0010¦\u0001\u001a\u00030¥\u00012\u0006\u0010\f\u001a\u00020\rH§@ø\u0001\u0000¢\u0006\u0003\u0010§\u0001J-\u0010©\u0001\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0012\u001a\u00020\u00062\u0007\u0010¨\u0001\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH§@ø\u0001\u0000¢\u0006\u0002\u0010 \u0002\u0004\n\u0002\b\u0019¨\u0006ª\u0001"}, d2 = {"Lcom/stripe/android/networking/StripeRepository;", "", "()V", "addCustomerSource", "Lcom/stripe/android/model/Source;", "customerId", "", "publishableKey", "productUsageTokens", "", "sourceId", "sourceType", "requestOptions", "Lcom/stripe/android/core/networking/ApiRequest$Options;", "addCustomerSource$payments_core_release", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "attachLinkAccountSessionToPaymentIntent", "Lcom/stripe/android/model/PaymentIntent;", "clientSecret", "paymentIntentId", "linkAccountSessionId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "attachLinkAccountSessionToSetupIntent", "Lcom/stripe/android/model/SetupIntent;", "setupIntentId", "attachPaymentMethod", "Lcom/stripe/android/model/PaymentMethod;", "paymentMethodId", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;Ljava/lang/String;Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelPaymentIntentSource", "options", "cancelPaymentIntentSource$payments_core_release", "(Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelSetupIntentSource", "cancelSetupIntentSource$payments_core_release", "complete3ds2Auth", "Lcom/stripe/android/model/Stripe3ds2AuthResult;", "complete3ds2Auth$payments_core_release", "(Ljava/lang/String;Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmConsumerVerification", "Lcom/stripe/android/model/ConsumerSession;", "consumerSessionClientSecret", "verificationCode", "authSessionCookie", "confirmPaymentIntent", "confirmPaymentIntentParams", "Lcom/stripe/android/model/ConfirmPaymentIntentParams;", "expandFields", "", "confirmPaymentIntent$payments_core_release", "(Lcom/stripe/android/model/ConfirmPaymentIntentParams;Lcom/stripe/android/core/networking/ApiRequest$Options;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmSetupIntent", "confirmSetupIntentParams", "Lcom/stripe/android/model/ConfirmSetupIntentParams;", "confirmSetupIntent$payments_core_release", "(Lcom/stripe/android/model/ConfirmSetupIntentParams;Lcom/stripe/android/core/networking/ApiRequest$Options;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumerSignUp", "email", "phoneNumber", "country", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createFile", "Lcom/stripe/android/core/model/StripeFile;", "fileParams", "Lcom/stripe/android/core/model/StripeFileParams;", "createFile$payments_core_release", "(Lcom/stripe/android/core/model/StripeFileParams;Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createPaymentIntentLinkAccountSession", "Lcom/stripe/android/model/BankConnectionsLinkedAccountSession;", "params", "Lcom/stripe/android/model/CreateLinkAccountSessionParams;", "createPaymentIntentLinkAccountSession$payments_core_release", "(Ljava/lang/String;Lcom/stripe/android/model/CreateLinkAccountSessionParams;Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createPaymentMethod", "paymentMethodCreateParams", "Lcom/stripe/android/model/PaymentMethodCreateParams;", "(Lcom/stripe/android/model/PaymentMethodCreateParams;Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createRadarSession", "Lcom/stripe/android/model/RadarSession;", "createRadarSession$payments_core_release", "(Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createSetupIntentLinkAccountSession", "createSetupIntentLinkAccountSession$payments_core_release", "createSource", "sourceParams", "Lcom/stripe/android/model/SourceParams;", "createSource$payments_core_release", "(Lcom/stripe/android/model/SourceParams;Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createToken", "Lcom/stripe/android/model/Token;", "tokenParams", "Lcom/stripe/android/model/TokenParams;", "createToken$payments_core_release", "(Lcom/stripe/android/model/TokenParams;Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteCustomerSource", "deleteCustomerSource$payments_core_release", "detachPaymentMethod", "(Ljava/lang/String;Ljava/util/Set;Ljava/lang/String;Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCardMetadata", "Lcom/stripe/android/model/CardMetadata;", "bin", "Lcom/stripe/android/cards/Bin;", "getCardMetadata$payments_core_release", "(Lcom/stripe/android/cards/Bin;Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFpxBankStatus", "Lcom/stripe/android/model/BankStatuses;", "getFpxBankStatus$payments_core_release", "getPaymentMethods", "listPaymentMethodsParams", "Lcom/stripe/android/model/ListPaymentMethodsParams;", "(Lcom/stripe/android/model/ListPaymentMethodsParams;Ljava/lang/String;Ljava/util/Set;Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listPaymentDetails", "Lcom/stripe/android/model/ConsumerPaymentDetails;", "paymentMethodTypes", "(Ljava/lang/String;Ljava/util/Set;Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logoutConsumer", "lookupConsumerSession", "Lcom/stripe/android/model/ConsumerSessionLookup;", "refreshPaymentIntent", "refreshPaymentIntent$payments_core_release", "retrieveCustomer", "Lcom/stripe/android/model/Customer;", "retrieveCustomer$payments_core_release", "retrieveIssuingCardPin", "cardId", "verificationId", "userOneTimeCode", "retrieveIssuingCardPin$payments_core_release", "retrieveObject", "Lorg/json/JSONObject;", "url", "retrieveObject$payments_core_release", "retrievePaymentIntent", "(Ljava/lang/String;Lcom/stripe/android/core/networking/ApiRequest$Options;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "retrievePaymentIntentWithOrderedPaymentMethods", "locale", "Ljava/util/Locale;", "(Ljava/lang/String;Lcom/stripe/android/core/networking/ApiRequest$Options;Ljava/util/Locale;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "retrieveSetupIntent", "retrieveSetupIntentWithOrderedPaymentMethods", "retrieveSource", "retrieveSource$payments_core_release", "retrieveStripeIntent", "Lcom/stripe/android/model/StripeIntent;", "retrieveStripeIntent$payments_core_release", "setCustomerShippingInfo", "shippingInformation", "Lcom/stripe/android/model/ShippingInformation;", "setCustomerShippingInfo$payments_core_release", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;Lcom/stripe/android/model/ShippingInformation;Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setDefaultCustomerSource", "setDefaultCustomerSource$payments_core_release", "start3ds2Auth", "authParams", "Lcom/stripe/android/model/Stripe3ds2AuthParams;", "start3ds2Auth$payments_core_release", "(Lcom/stripe/android/model/Stripe3ds2AuthParams;Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startConsumerVerification", "(Ljava/lang/String;Ljava/util/Locale;Ljava/lang/String;Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateIssuingCardPin", "", "newPin", "updateIssuingCardPin$payments_core_release", "verifyPaymentIntentWithMicrodeposits", "firstAmount", "", "secondAmount", "(Ljava/lang/String;IILcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "descriptorCode", "verifySetupIntentWithMicrodeposits", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StripeRepository.kt */
public abstract class StripeRepository {
    public static final int $stable = 0;

    public abstract Object addCustomerSource$payments_core_release(String str, String str2, Set<String> set, String str3, String str4, ApiRequest.Options options, Continuation<? super Source> continuation) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException, CardException;

    public abstract Object attachLinkAccountSessionToPaymentIntent(String str, String str2, String str3, ApiRequest.Options options, Continuation<? super PaymentIntent> continuation);

    public abstract Object attachLinkAccountSessionToSetupIntent(String str, String str2, String str3, ApiRequest.Options options, Continuation<? super SetupIntent> continuation);

    public abstract Object attachPaymentMethod(String str, String str2, Set<String> set, String str3, ApiRequest.Options options, Continuation<? super PaymentMethod> continuation) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException, CardException;

    public abstract Object cancelPaymentIntentSource$payments_core_release(String str, String str2, ApiRequest.Options options, Continuation<? super PaymentIntent> continuation) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException;

    public abstract Object cancelSetupIntentSource$payments_core_release(String str, String str2, ApiRequest.Options options, Continuation<? super SetupIntent> continuation) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException;

    public abstract Object complete3ds2Auth$payments_core_release(String str, ApiRequest.Options options, Continuation<? super Stripe3ds2AuthResult> continuation);

    public abstract Object confirmConsumerVerification(String str, String str2, String str3, ApiRequest.Options options, Continuation<? super ConsumerSession> continuation);

    public abstract Object confirmPaymentIntent$payments_core_release(ConfirmPaymentIntentParams confirmPaymentIntentParams, ApiRequest.Options options, List<String> list, Continuation<? super PaymentIntent> continuation) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException;

    public abstract Object confirmSetupIntent$payments_core_release(ConfirmSetupIntentParams confirmSetupIntentParams, ApiRequest.Options options, List<String> list, Continuation<? super SetupIntent> continuation) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException;

    public abstract Object consumerSignUp(String str, String str2, String str3, String str4, ApiRequest.Options options, Continuation<? super ConsumerSession> continuation);

    public abstract Object createFile$payments_core_release(StripeFileParams stripeFileParams, ApiRequest.Options options, Continuation<? super StripeFile> continuation);

    public abstract Object createPaymentIntentLinkAccountSession$payments_core_release(String str, CreateLinkAccountSessionParams createLinkAccountSessionParams, ApiRequest.Options options, Continuation<? super BankConnectionsLinkedAccountSession> continuation);

    public abstract Object createPaymentMethod(PaymentMethodCreateParams paymentMethodCreateParams, ApiRequest.Options options, Continuation<? super PaymentMethod> continuation) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException;

    public abstract Object createRadarSession$payments_core_release(ApiRequest.Options options, Continuation<? super RadarSession> continuation);

    public abstract Object createSetupIntentLinkAccountSession$payments_core_release(String str, CreateLinkAccountSessionParams createLinkAccountSessionParams, ApiRequest.Options options, Continuation<? super BankConnectionsLinkedAccountSession> continuation);

    public abstract Object createSource$payments_core_release(SourceParams sourceParams, ApiRequest.Options options, Continuation<? super Source> continuation) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException;

    public abstract Object createToken$payments_core_release(TokenParams tokenParams, ApiRequest.Options options, Continuation<? super Token> continuation) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException, CardException;

    public abstract Object deleteCustomerSource$payments_core_release(String str, String str2, Set<String> set, String str3, ApiRequest.Options options, Continuation<? super Source> continuation) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException, CardException;

    public abstract Object detachPaymentMethod(String str, Set<String> set, String str2, ApiRequest.Options options, Continuation<? super PaymentMethod> continuation) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException, CardException;

    public abstract Object getCardMetadata$payments_core_release(Bin bin, ApiRequest.Options options, Continuation<? super CardMetadata> continuation);

    public abstract Object getFpxBankStatus$payments_core_release(ApiRequest.Options options, Continuation<? super BankStatuses> continuation);

    public abstract Object getPaymentMethods(ListPaymentMethodsParams listPaymentMethodsParams, String str, Set<String> set, ApiRequest.Options options, Continuation<? super List<PaymentMethod>> continuation) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException, CardException;

    public abstract Object listPaymentDetails(String str, Set<String> set, ApiRequest.Options options, Continuation<? super ConsumerPaymentDetails> continuation);

    public abstract Object logoutConsumer(String str, String str2, ApiRequest.Options options, Continuation<? super ConsumerSession> continuation);

    public abstract Object lookupConsumerSession(String str, String str2, ApiRequest.Options options, Continuation<? super ConsumerSessionLookup> continuation);

    public abstract Object refreshPaymentIntent$payments_core_release(String str, ApiRequest.Options options, Continuation<? super PaymentIntent> continuation) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException;

    public abstract Object retrieveCustomer$payments_core_release(String str, Set<String> set, ApiRequest.Options options, Continuation<? super Customer> continuation) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException, CardException;

    public abstract Object retrieveIssuingCardPin$payments_core_release(String str, String str2, String str3, ApiRequest.Options options, Continuation<? super String> continuation) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException, CardException, JSONException;

    public abstract Object retrieveObject$payments_core_release(String str, ApiRequest.Options options, Continuation<? super JSONObject> continuation);

    public abstract Object retrievePaymentIntent(String str, ApiRequest.Options options, List<String> list, Continuation<? super PaymentIntent> continuation) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException;

    public abstract Object retrievePaymentIntentWithOrderedPaymentMethods(String str, ApiRequest.Options options, Locale locale, Continuation<? super PaymentIntent> continuation) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException;

    public abstract Object retrieveSetupIntent(String str, ApiRequest.Options options, List<String> list, Continuation<? super SetupIntent> continuation) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException;

    public abstract Object retrieveSetupIntentWithOrderedPaymentMethods(String str, ApiRequest.Options options, Locale locale, Continuation<? super SetupIntent> continuation) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException;

    public abstract Object retrieveSource$payments_core_release(String str, String str2, ApiRequest.Options options, Continuation<? super Source> continuation) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException;

    public abstract Object retrieveStripeIntent$payments_core_release(String str, ApiRequest.Options options, List<String> list, Continuation<? super StripeIntent> continuation);

    public abstract Object setCustomerShippingInfo$payments_core_release(String str, String str2, Set<String> set, ShippingInformation shippingInformation, ApiRequest.Options options, Continuation<? super Customer> continuation) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException, CardException;

    public abstract Object setDefaultCustomerSource$payments_core_release(String str, String str2, Set<String> set, String str3, String str4, ApiRequest.Options options, Continuation<? super Customer> continuation) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException, CardException;

    public abstract Object start3ds2Auth$payments_core_release(Stripe3ds2AuthParams stripe3ds2AuthParams, ApiRequest.Options options, Continuation<? super Stripe3ds2AuthResult> continuation);

    public abstract Object startConsumerVerification(String str, Locale locale, String str2, ApiRequest.Options options, Continuation<? super ConsumerSession> continuation);

    public abstract Object updateIssuingCardPin$payments_core_release(String str, String str2, String str3, String str4, ApiRequest.Options options, Continuation<? super Unit> continuation) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException, CardException;

    public abstract Object verifyPaymentIntentWithMicrodeposits(String str, int i, int i2, ApiRequest.Options options, Continuation<? super PaymentIntent> continuation);

    public abstract Object verifyPaymentIntentWithMicrodeposits(String str, String str2, ApiRequest.Options options, Continuation<? super PaymentIntent> continuation);

    public abstract Object verifySetupIntentWithMicrodeposits(String str, int i, int i2, ApiRequest.Options options, Continuation<? super SetupIntent> continuation);

    public abstract Object verifySetupIntentWithMicrodeposits(String str, String str2, ApiRequest.Options options, Continuation<? super SetupIntent> continuation);

    public static /* synthetic */ Object retrieveStripeIntent$payments_core_release$default(StripeRepository stripeRepository, String str, ApiRequest.Options options, List list, Continuation continuation, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                list = CollectionsKt.emptyList();
            }
            return stripeRepository.retrieveStripeIntent$payments_core_release(str, options, list, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: retrieveStripeIntent");
    }

    public static /* synthetic */ Object confirmPaymentIntent$payments_core_release$default(StripeRepository stripeRepository, ConfirmPaymentIntentParams confirmPaymentIntentParams, ApiRequest.Options options, List list, Continuation continuation, int i, Object obj) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException {
        if (obj == null) {
            if ((i & 4) != 0) {
                list = CollectionsKt.emptyList();
            }
            return stripeRepository.confirmPaymentIntent$payments_core_release(confirmPaymentIntentParams, options, list, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: confirmPaymentIntent");
    }

    public static /* synthetic */ Object retrievePaymentIntent$default(StripeRepository stripeRepository, String str, ApiRequest.Options options, List list, Continuation continuation, int i, Object obj) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException {
        if (obj == null) {
            if ((i & 4) != 0) {
                list = CollectionsKt.emptyList();
            }
            return stripeRepository.retrievePaymentIntent(str, options, list, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: retrievePaymentIntent");
    }

    public static /* synthetic */ Object confirmSetupIntent$payments_core_release$default(StripeRepository stripeRepository, ConfirmSetupIntentParams confirmSetupIntentParams, ApiRequest.Options options, List list, Continuation continuation, int i, Object obj) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException {
        if (obj == null) {
            if ((i & 4) != 0) {
                list = CollectionsKt.emptyList();
            }
            return stripeRepository.confirmSetupIntent$payments_core_release(confirmSetupIntentParams, options, list, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: confirmSetupIntent");
    }

    public static /* synthetic */ Object retrieveSetupIntent$default(StripeRepository stripeRepository, String str, ApiRequest.Options options, List list, Continuation continuation, int i, Object obj) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException {
        if (obj == null) {
            if ((i & 4) != 0) {
                list = CollectionsKt.emptyList();
            }
            return stripeRepository.retrieveSetupIntent(str, options, list, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: retrieveSetupIntent");
    }
}
