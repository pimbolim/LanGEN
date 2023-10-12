package com.stripe.android.networking;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.common.statfs.StatFsHelper;
import com.google.android.gms.wallet.WalletConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.henninghall.date_picker.props.LocaleProp;
import com.stripe.android.FraudDetectionDataRepository;
import com.stripe.android.StripeApiBeta;
import com.stripe.android.core.AppInfo;
import com.stripe.android.core.Logger;
import com.stripe.android.core.StripeError;
import com.stripe.android.core.exception.APIConnectionException;
import com.stripe.android.core.exception.APIException;
import com.stripe.android.core.exception.AuthenticationException;
import com.stripe.android.core.exception.InvalidRequestException;
import com.stripe.android.core.exception.PermissionException;
import com.stripe.android.core.exception.RateLimitException;
import com.stripe.android.core.model.parsers.StripeErrorJsonParser;
import com.stripe.android.core.networking.AnalyticsRequest;
import com.stripe.android.core.networking.AnalyticsRequestExecutor;
import com.stripe.android.core.networking.ApiRequest;
import com.stripe.android.core.networking.RequestId;
import com.stripe.android.core.networking.StripeNetworkClient;
import com.stripe.android.core.networking.StripeResponse;
import com.stripe.android.core.networking.StripeResponseKtxKt;
import com.stripe.android.exception.CardException;
import com.stripe.android.model.BankConnectionsLinkedAccountSession;
import com.stripe.android.model.ConfirmPaymentIntentParams;
import com.stripe.android.model.ConfirmSetupIntentParams;
import com.stripe.android.model.ConsumerPaymentDetails;
import com.stripe.android.model.ConsumerSession;
import com.stripe.android.model.ConsumerSessionLookup;
import com.stripe.android.model.CreateLinkAccountSessionParams;
import com.stripe.android.model.Customer;
import com.stripe.android.model.PaymentIntent;
import com.stripe.android.model.PaymentMethod;
import com.stripe.android.model.PaymentMethodCreateParams;
import com.stripe.android.model.PaymentMethodOptionsParams;
import com.stripe.android.model.SetupIntent;
import com.stripe.android.model.ShippingInformation;
import com.stripe.android.model.Source;
import com.stripe.android.model.SourceParams;
import com.stripe.android.model.Stripe3ds2AuthParams;
import com.stripe.android.model.Stripe3ds2AuthResult;
import com.stripe.android.model.StripeIntent;
import com.stripe.android.model.Token;
import com.stripe.android.model.TokenParams;
import com.stripe.android.model.parsers.BankConnectionsLinkAccountSessionJsonParser;
import com.stripe.android.model.parsers.ConsumerPaymentDetailsJsonParser;
import com.stripe.android.model.parsers.ConsumerSessionJsonParser;
import com.stripe.android.model.parsers.ConsumerSessionLookupJsonParser;
import com.stripe.android.model.parsers.CustomerJsonParser;
import com.stripe.android.model.parsers.PaymentIntentJsonParser;
import com.stripe.android.model.parsers.PaymentMethodJsonParser;
import com.stripe.android.model.parsers.PaymentMethodPreferenceForPaymentIntentJsonParser;
import com.stripe.android.model.parsers.PaymentMethodPreferenceForSetupIntentJsonParser;
import com.stripe.android.model.parsers.PaymentMethodPreferenceJsonParser;
import com.stripe.android.model.parsers.SetupIntentJsonParser;
import com.stripe.android.model.parsers.SourceJsonParser;
import com.stripe.android.model.parsers.Stripe3ds2AuthResultJsonParser;
import com.stripe.android.model.parsers.TokenJsonParser;
import com.stripe.android.networking.PaymentAnalyticsRequestFactory;
import com.stripe.android.stripe3ds2.transactions.MessageExtension;
import java.security.Security;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000À\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\b\u0000\u0018\u0000 \u00022\u00020\u0001:\u0004\u0002\u0002BQ\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0001\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b\u0012\u000e\b\u0001\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011B£\u0001\b\u0001\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\n\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0006¢\u0006\u0002\u0010\u001fJK\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010*\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020-H@ø\u0001\u0000¢\u0006\u0004\b.\u0010/J3\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u00062\u0006\u00104\u001a\u00020\u00062\u0006\u0010,\u001a\u00020-H@ø\u0001\u0000¢\u0006\u0002\u00105J3\u00106\u001a\u0004\u0018\u0001072\u0006\u00102\u001a\u00020\u00062\u0006\u00108\u001a\u00020\u00062\u0006\u00104\u001a\u00020\u00062\u0006\u0010,\u001a\u00020-H@ø\u0001\u0000¢\u0006\u0002\u00105JA\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010;\u001a\u00020\u00062\u0006\u0010,\u001a\u00020-H@ø\u0001\u0000¢\u0006\u0002\u0010<J$\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060>2\u000e\b\u0002\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0002J-\u0010@\u001a\u0004\u0018\u0001012\u0006\u00103\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u00062\u0006\u0010A\u001a\u00020-H@ø\u0001\u0000¢\u0006\u0004\bB\u0010CJ-\u0010D\u001a\u0004\u0018\u0001072\u0006\u00108\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u00062\u0006\u0010A\u001a\u00020-H@ø\u0001\u0000¢\u0006\u0004\bE\u0010CJ%\u0010F\u001a\u0004\u0018\u00010G2\u0006\u0010*\u001a\u00020\u00062\u0006\u0010,\u001a\u00020-H@ø\u0001\u0000¢\u0006\u0004\bH\u0010IJ5\u0010J\u001a\u0004\u0018\u00010K2\u0006\u0010L\u001a\u00020\u00062\u0006\u0010M\u001a\u00020\u00062\b\u0010N\u001a\u0004\u0018\u00010\u00062\u0006\u0010,\u001a\u00020-H@ø\u0001\u0000¢\u0006\u0002\u00105J3\u0010O\u001a\u0004\u0018\u0001012\u0006\u0010P\u001a\u00020Q2\u0006\u0010A\u001a\u00020-2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00060SH@ø\u0001\u0000¢\u0006\u0004\bT\u0010UJ1\u0010V\u001a\u0004\u0018\u0001012\u0006\u0010P\u001a\u00020Q2\u0006\u0010A\u001a\u00020-2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00060SH@ø\u0001\u0000¢\u0006\u0002\u0010UJ3\u0010W\u001a\u0004\u0018\u0001072\u0006\u0010X\u001a\u00020Y2\u0006\u0010A\u001a\u00020-2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00060SH@ø\u0001\u0000¢\u0006\u0004\bZ\u0010[J=\u0010\\\u001a\u0004\u0018\u00010K2\u0006\u0010]\u001a\u00020\u00062\u0006\u0010^\u001a\u00020\u00062\u0006\u0010_\u001a\u00020\u00062\b\u0010N\u001a\u0004\u0018\u00010\u00062\u0006\u0010,\u001a\u00020-H@ø\u0001\u0000¢\u0006\u0002\u0010`J*\u0010a\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020c0b2\u0006\u00102\u001a\u00020\u00062\f\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00060SH\u0002J#\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020g2\u0006\u0010,\u001a\u00020-H@ø\u0001\u0000¢\u0006\u0004\bh\u0010iJ-\u0010j\u001a\u0004\u0018\u00010k2\u0006\u00103\u001a\u00020\u00062\u0006\u0010l\u001a\u00020m2\u0006\u0010,\u001a\u00020-H@ø\u0001\u0000¢\u0006\u0004\bn\u0010oJ#\u0010p\u001a\u0004\u0018\u00010:2\u0006\u0010q\u001a\u00020r2\u0006\u0010A\u001a\u00020-H@ø\u0001\u0000¢\u0006\u0002\u0010sJ\u001d\u0010t\u001a\u0004\u0018\u00010u2\u0006\u0010,\u001a\u00020-H@ø\u0001\u0000¢\u0006\u0004\bv\u0010wJ-\u0010x\u001a\u0004\u0018\u00010k2\u0006\u00108\u001a\u00020\u00062\u0006\u0010l\u001a\u00020m2\u0006\u0010,\u001a\u00020-H@ø\u0001\u0000¢\u0006\u0004\by\u0010oJ%\u0010z\u001a\u0004\u0018\u00010'2\u0006\u0010{\u001a\u00020|2\u0006\u0010A\u001a\u00020-H@ø\u0001\u0000¢\u0006\u0004\b}\u0010~J*\u0010\u001a\u0005\u0018\u00010\u00012\b\u0010\u0001\u001a\u00030\u00012\u0006\u0010A\u001a\u00020-H@ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001JE\u0010\u0001\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010*\u001a\u00020\u00062\u0006\u0010,\u001a\u00020-H@ø\u0001\u0000¢\u0006\u0005\b\u0001\u0010<J;\u0010\u0001\u001a\u0004\u0018\u00010:2\u0006\u0010)\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010;\u001a\u00020\u00062\u0006\u0010,\u001a\u00020-H@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J\n\u0010\u0001\u001a\u00030\u0001H\u0002JM\u0010\u0001\u001a\u0005\u0018\u0001H\u0001\"\n\b\u0000\u0010\u0001*\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\u000f\u0010\u0001\u001a\n\u0012\u0005\u0012\u0003H\u00010\u00012\u000e\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010\u0005H@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J\u0019\u0010\u0001\u001a\u00030\u00012\u0007\u0010l\u001a\u00030\u0001H\u0001¢\u0006\u0003\b\u0001J\u0014\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0002J\n\u0010\u0001\u001a\u00030\u0001H\u0002J+\u0010\u0001\u001a\u0005\u0018\u00010\u00012\b\u0010\u0001\u001a\u00030\u00012\u0006\u0010A\u001a\u00020-H@ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010 \u0001J\u0017\u0010¡\u0001\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u0006H\u0001¢\u0006\u0003\b¢\u0001J\u001e\u0010£\u0001\u001a\u00030¤\u00012\u0006\u0010A\u001a\u00020-H@ø\u0001\u0000¢\u0006\u0005\b¥\u0001\u0010wJ\u0017\u0010¦\u0001\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u0006H\u0001¢\u0006\u0003\b§\u0001JA\u0010¨\u0001\u001a\b\u0012\u0004\u0012\u00020:0S2\b\u0010©\u0001\u001a\u00030ª\u00012\u0006\u0010)\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010,\u001a\u00020-H@ø\u0001\u0000¢\u0006\u0003\u0010«\u0001J\u0017\u0010¬\u0001\u001a\u00020\u00062\u0006\u00108\u001a\u00020\u0006H\u0001¢\u0006\u0003\b­\u0001J\u001a\u0010®\u0001\u001a\u00030\u00012\u000e\u0010¯\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060°\u0001H\u0002J5\u0010±\u0001\u001a\u0005\u0018\u00010²\u00012\u0006\u0010L\u001a\u00020\u00062\r\u0010³\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010,\u001a\u00020-H@ø\u0001\u0000¢\u0006\u0003\u0010´\u0001J.\u0010µ\u0001\u001a\u0004\u0018\u00010K2\u0006\u0010L\u001a\u00020\u00062\b\u0010N\u001a\u0004\u0018\u00010\u00062\u0006\u0010,\u001a\u00020-H@ø\u0001\u0000¢\u0006\u0002\u0010CJ/\u0010¶\u0001\u001a\u0005\u0018\u00010·\u00012\u0006\u0010]\u001a\u00020\u00062\b\u0010N\u001a\u0004\u0018\u00010\u00062\u0006\u0010,\u001a\u00020-H@ø\u0001\u0000¢\u0006\u0002\u0010CJ7\u0010¸\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060°\u00012\b\u0010\u0001\u001a\u00030\u00012\u000e\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010\u0005H@ø\u0001\u0000¢\u0006\u0006\b¹\u0001\u0010º\u0001JA\u0010»\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060°\u00012\b\u0010¼\u0001\u001a\u00030½\u00012\u0018\u0010\u0001\u001a\u0013\u0012\u0007\u0012\u0005\u0018\u00010¿\u0001\u0012\u0005\u0012\u00030\u00010¾\u0001H@ø\u0001\u0000¢\u0006\u0006\bÀ\u0001\u0010Á\u0001J?\u0010Â\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020c0b2\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020c0b2\b\u0010q\u001a\u0004\u0018\u00010r2\n\b\u0002\u0010{\u001a\u0004\u0018\u00010|H\u0002J'\u0010Ã\u0001\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u00020\u00062\u0006\u0010A\u001a\u00020-H@ø\u0001\u0000¢\u0006\u0005\bÄ\u0001\u0010IJ\u0014\u0010Å\u0001\u001a\u00030\u00012\b\u0010Æ\u0001\u001a\u00030\u0001H\u0002J7\u0010Ç\u0001\u001a\u0005\u0018\u00010È\u00012\u0006\u0010(\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010,\u001a\u00020-H@ø\u0001\u0000¢\u0006\u0006\bÉ\u0001\u0010´\u0001J:\u0010Ê\u0001\u001a\u0004\u0018\u00010\u00062\u0007\u0010Ë\u0001\u001a\u00020\u00062\u0007\u0010Ì\u0001\u001a\u00020\u00062\u0007\u0010Í\u0001\u001a\u00020\u00062\u0006\u0010,\u001a\u00020-H@ø\u0001\u0000¢\u0006\u0005\bÎ\u0001\u00105J'\u0010Ï\u0001\u001a\u00030Ð\u00012\u0007\u0010Ñ\u0001\u001a\u00020\u00062\u0006\u0010,\u001a\u00020-H@ø\u0001\u0000¢\u0006\u0005\bÒ\u0001\u0010IJ3\u0010Ó\u0001\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u00020\u00062\u0006\u0010A\u001a\u00020-2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00060SH@ø\u0001\u0000¢\u0006\u0003\u0010Ô\u0001J/\u0010Õ\u0001\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u00020\u00062\u0006\u0010A\u001a\u00020-2\b\u0010Ö\u0001\u001a\u00030×\u0001H@ø\u0001\u0000¢\u0006\u0003\u0010Ø\u0001J3\u0010Ù\u0001\u001a\u0004\u0018\u0001072\u0006\u00102\u001a\u00020\u00062\u0006\u0010A\u001a\u00020-2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00060SH@ø\u0001\u0000¢\u0006\u0003\u0010Ô\u0001J/\u0010Ú\u0001\u001a\u0004\u0018\u0001072\u0006\u00102\u001a\u00020\u00062\u0006\u0010A\u001a\u00020-2\b\u0010Ö\u0001\u001a\u00030×\u0001H@ø\u0001\u0000¢\u0006\u0003\u0010Ø\u0001J/\u0010Û\u0001\u001a\u0004\u0018\u00010'2\u0006\u0010*\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u00062\u0006\u0010A\u001a\u00020-H@ø\u0001\u0000¢\u0006\u0005\bÜ\u0001\u0010CJ5\u0010Ý\u0001\u001a\u00030Þ\u00012\u0006\u00102\u001a\u00020\u00062\u0006\u0010A\u001a\u00020-2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00060SH@ø\u0001\u0000¢\u0006\u0006\bß\u0001\u0010Ô\u0001JW\u0010à\u0001\u001a\u0005\u0018\u0001Há\u0001\"\n\b\u0000\u0010á\u0001*\u00030Þ\u00012\u0006\u00102\u001a\u00020\u00062\u0006\u0010A\u001a\u00020-2\b\u0010Ö\u0001\u001a\u00030×\u00012\u000f\u0010â\u0001\u001a\n\u0012\u0005\u0012\u0003Há\u00010ã\u00012\b\u0010ä\u0001\u001a\u00030\u0001H@ø\u0001\u0000¢\u0006\u0003\u0010å\u0001JI\u0010æ\u0001\u001a\u0005\u0018\u00010È\u00012\u0006\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\b\u0010ç\u0001\u001a\u00030è\u00012\u0006\u0010,\u001a\u00020-H@ø\u0001\u0000¢\u0006\u0006\bé\u0001\u0010ê\u0001JN\u0010ë\u0001\u001a\u0005\u0018\u00010È\u00012\u0006\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010*\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020-H@ø\u0001\u0000¢\u0006\u0005\bì\u0001\u0010/J*\u0010í\u0001\u001a\u0004\u0018\u00010G2\b\u0010î\u0001\u001a\u00030ï\u00012\u0006\u0010,\u001a\u00020-H@ø\u0001\u0000¢\u0006\u0006\bð\u0001\u0010ñ\u0001J9\u0010ò\u0001\u001a\u0004\u0018\u00010K2\u0006\u0010L\u001a\u00020\u00062\b\u0010Ö\u0001\u001a\u00030×\u00012\b\u0010N\u001a\u0004\u0018\u00010\u00062\u0006\u0010,\u001a\u00020-H@ø\u0001\u0000¢\u0006\u0003\u0010ó\u0001JB\u0010ô\u0001\u001a\u00030\u00012\u0007\u0010Ë\u0001\u001a\u00020\u00062\u0007\u0010õ\u0001\u001a\u00020\u00062\u0007\u0010Ì\u0001\u001a\u00020\u00062\u0007\u0010Í\u0001\u001a\u00020\u00062\u0006\u0010,\u001a\u00020-H@ø\u0001\u0000¢\u0006\u0005\bö\u0001\u0010`J9\u0010÷\u0001\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u00020\u00062\b\u0010ø\u0001\u001a\u00030ù\u00012\b\u0010ú\u0001\u001a\u00030ù\u00012\u0006\u0010,\u001a\u00020-H@ø\u0001\u0000¢\u0006\u0003\u0010û\u0001J-\u0010÷\u0001\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u00020\u00062\u0007\u0010ü\u0001\u001a\u00020\u00062\u0006\u0010,\u001a\u00020-H@ø\u0001\u0000¢\u0006\u0002\u0010CJ9\u0010ý\u0001\u001a\u0004\u0018\u0001072\u0006\u00102\u001a\u00020\u00062\b\u0010ø\u0001\u001a\u00030ù\u00012\b\u0010ú\u0001\u001a\u00030ù\u00012\u0006\u0010,\u001a\u00020-H@ø\u0001\u0000¢\u0006\u0003\u0010û\u0001J-\u0010ý\u0001\u001a\u0004\u0018\u0001072\u0006\u00102\u001a\u00020\u00062\u0007\u0010ü\u0001\u001a\u00020\u00062\u0006\u0010,\u001a\u00020-H@ø\u0001\u0000¢\u0006\u0002\u0010CJ\u001f\u0010þ\u0001\u001a\u00020Q*\u00020Q2\u0006\u0010A\u001a\u00020-H@ø\u0001\u0000¢\u0006\u0003\u0010ÿ\u0001R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\"\u001a\u0004\u0018\u00010#8BX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0002"}, d2 = {"Lcom/stripe/android/networking/StripeApiRepository;", "Lcom/stripe/android/networking/StripeRepository;", "appContext", "Landroid/content/Context;", "publishableKeyProvider", "Lkotlin/Function0;", "", "workContext", "Lkotlin/coroutines/CoroutineContext;", "productUsageTokens", "", "paymentAnalyticsRequestFactory", "Lcom/stripe/android/networking/PaymentAnalyticsRequestFactory;", "analyticsRequestExecutor", "Lcom/stripe/android/core/networking/AnalyticsRequestExecutor;", "logger", "Lcom/stripe/android/core/Logger;", "(Landroid/content/Context;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/CoroutineContext;Ljava/util/Set;Lcom/stripe/android/networking/PaymentAnalyticsRequestFactory;Lcom/stripe/android/core/networking/AnalyticsRequestExecutor;Lcom/stripe/android/core/Logger;)V", "context", "appInfo", "Lcom/stripe/android/core/AppInfo;", "stripeNetworkClient", "Lcom/stripe/android/core/networking/StripeNetworkClient;", "fraudDetectionDataRepository", "Lcom/stripe/android/FraudDetectionDataRepository;", "fraudDetectionDataParamsUtils", "Lcom/stripe/android/networking/FraudDetectionDataParamsUtils;", "betas", "Lcom/stripe/android/StripeApiBeta;", "apiVersion", "sdkVersion", "(Landroid/content/Context;Lkotlin/jvm/functions/Function0;Lcom/stripe/android/core/AppInfo;Lcom/stripe/android/core/Logger;Lkotlin/coroutines/CoroutineContext;Ljava/util/Set;Lcom/stripe/android/core/networking/StripeNetworkClient;Lcom/stripe/android/core/networking/AnalyticsRequestExecutor;Lcom/stripe/android/FraudDetectionDataRepository;Lcom/stripe/android/networking/PaymentAnalyticsRequestFactory;Lcom/stripe/android/networking/FraudDetectionDataParamsUtils;Ljava/util/Set;Ljava/lang/String;Ljava/lang/String;)V", "apiRequestFactory", "Lcom/stripe/android/core/networking/ApiRequest$Factory;", "fraudDetectionData", "Lcom/stripe/android/networking/FraudDetectionData;", "getFraudDetectionData", "()Lcom/stripe/android/networking/FraudDetectionData;", "addCustomerSource", "Lcom/stripe/android/model/Source;", "customerId", "publishableKey", "sourceId", "sourceType", "requestOptions", "Lcom/stripe/android/core/networking/ApiRequest$Options;", "addCustomerSource$payments_core_release", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "attachLinkAccountSessionToPaymentIntent", "Lcom/stripe/android/model/PaymentIntent;", "clientSecret", "paymentIntentId", "linkAccountSessionId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "attachLinkAccountSessionToSetupIntent", "Lcom/stripe/android/model/SetupIntent;", "setupIntentId", "attachPaymentMethod", "Lcom/stripe/android/model/PaymentMethod;", "paymentMethodId", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;Ljava/lang/String;Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildPaymentUserAgentPair", "Lkotlin/Pair;", "attribution", "cancelPaymentIntentSource", "options", "cancelPaymentIntentSource$payments_core_release", "(Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelSetupIntentSource", "cancelSetupIntentSource$payments_core_release", "complete3ds2Auth", "Lcom/stripe/android/model/Stripe3ds2AuthResult;", "complete3ds2Auth$payments_core_release", "(Ljava/lang/String;Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmConsumerVerification", "Lcom/stripe/android/model/ConsumerSession;", "consumerSessionClientSecret", "verificationCode", "authSessionCookie", "confirmPaymentIntent", "confirmPaymentIntentParams", "Lcom/stripe/android/model/ConfirmPaymentIntentParams;", "expandFields", "", "confirmPaymentIntent$payments_core_release", "(Lcom/stripe/android/model/ConfirmPaymentIntentParams;Lcom/stripe/android/core/networking/ApiRequest$Options;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmPaymentIntentInternal", "confirmSetupIntent", "confirmSetupIntentParams", "Lcom/stripe/android/model/ConfirmSetupIntentParams;", "confirmSetupIntent$payments_core_release", "(Lcom/stripe/android/model/ConfirmSetupIntentParams;Lcom/stripe/android/core/networking/ApiRequest$Options;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumerSignUp", "email", "phoneNumber", "country", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createClientSecretParam", "", "", "createFile", "Lcom/stripe/android/core/model/StripeFile;", "fileParams", "Lcom/stripe/android/core/model/StripeFileParams;", "createFile$payments_core_release", "(Lcom/stripe/android/core/model/StripeFileParams;Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createPaymentIntentLinkAccountSession", "Lcom/stripe/android/model/BankConnectionsLinkedAccountSession;", "params", "Lcom/stripe/android/model/CreateLinkAccountSessionParams;", "createPaymentIntentLinkAccountSession$payments_core_release", "(Ljava/lang/String;Lcom/stripe/android/model/CreateLinkAccountSessionParams;Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createPaymentMethod", "paymentMethodCreateParams", "Lcom/stripe/android/model/PaymentMethodCreateParams;", "(Lcom/stripe/android/model/PaymentMethodCreateParams;Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createRadarSession", "Lcom/stripe/android/model/RadarSession;", "createRadarSession$payments_core_release", "(Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createSetupIntentLinkAccountSession", "createSetupIntentLinkAccountSession$payments_core_release", "createSource", "sourceParams", "Lcom/stripe/android/model/SourceParams;", "createSource$payments_core_release", "(Lcom/stripe/android/model/SourceParams;Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createToken", "Lcom/stripe/android/model/Token;", "tokenParams", "Lcom/stripe/android/model/TokenParams;", "createToken$payments_core_release", "(Lcom/stripe/android/model/TokenParams;Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteCustomerSource", "deleteCustomerSource$payments_core_release", "detachPaymentMethod", "(Ljava/lang/String;Ljava/util/Set;Ljava/lang/String;Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "disableDnsCache", "Lcom/stripe/android/networking/StripeApiRepository$DnsCacheData;", "fetchStripeModel", "ModelType", "Lcom/stripe/android/core/model/StripeModel;", "apiRequest", "Lcom/stripe/android/core/networking/ApiRequest;", "jsonParser", "Lcom/stripe/android/core/model/parsers/ModelJsonParser;", "onResponse", "", "(Lcom/stripe/android/core/networking/ApiRequest;Lcom/stripe/android/core/model/parsers/ModelJsonParser;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fireAnalyticsRequest", "Lcom/stripe/android/core/networking/AnalyticsRequest;", "fireAnalyticsRequest$payments_core_release", "event", "Lcom/stripe/android/networking/PaymentAnalyticsEvent;", "fireFraudDetectionDataRequest", "getCardMetadata", "Lcom/stripe/android/model/CardMetadata;", "bin", "Lcom/stripe/android/cards/Bin;", "getCardMetadata$payments_core_release", "(Lcom/stripe/android/cards/Bin;Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDetachPaymentMethodUrl", "getDetachPaymentMethodUrl$payments_core_release", "getFpxBankStatus", "Lcom/stripe/android/model/BankStatuses;", "getFpxBankStatus$payments_core_release", "getPaymentIntentLinkAccountSessionUrl", "getPaymentIntentLinkAccountSessionUrl$payments_core_release", "getPaymentMethods", "listPaymentMethodsParams", "Lcom/stripe/android/model/ListPaymentMethodsParams;", "(Lcom/stripe/android/model/ListPaymentMethodsParams;Ljava/lang/String;Ljava/util/Set;Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSetupIntentLinkAccountSessionUrl", "getSetupIntentLinkAccountSessionUrl$payments_core_release", "handleApiError", "response", "Lcom/stripe/android/core/networking/StripeResponse;", "listPaymentDetails", "Lcom/stripe/android/model/ConsumerPaymentDetails;", "paymentMethodTypes", "(Ljava/lang/String;Ljava/util/Set;Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logoutConsumer", "lookupConsumerSession", "Lcom/stripe/android/model/ConsumerSessionLookup;", "makeApiRequest", "makeApiRequest$payments_core_release", "(Lcom/stripe/android/core/networking/ApiRequest;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "makeFileUploadRequest", "fileUploadRequest", "Lcom/stripe/android/core/networking/FileUploadRequest;", "Lkotlin/Function1;", "Lcom/stripe/android/core/networking/RequestId;", "makeFileUploadRequest$payments_core_release", "(Lcom/stripe/android/core/networking/FileUploadRequest;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "maybeAddPaymentUserAgent", "refreshPaymentIntent", "refreshPaymentIntent$payments_core_release", "resetDnsCache", "dnsCacheData", "retrieveCustomer", "Lcom/stripe/android/model/Customer;", "retrieveCustomer$payments_core_release", "retrieveIssuingCardPin", "cardId", "verificationId", "userOneTimeCode", "retrieveIssuingCardPin$payments_core_release", "retrieveObject", "Lorg/json/JSONObject;", "url", "retrieveObject$payments_core_release", "retrievePaymentIntent", "(Ljava/lang/String;Lcom/stripe/android/core/networking/ApiRequest$Options;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "retrievePaymentIntentWithOrderedPaymentMethods", "locale", "Ljava/util/Locale;", "(Ljava/lang/String;Lcom/stripe/android/core/networking/ApiRequest$Options;Ljava/util/Locale;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "retrieveSetupIntent", "retrieveSetupIntentWithOrderedPaymentMethods", "retrieveSource", "retrieveSource$payments_core_release", "retrieveStripeIntent", "Lcom/stripe/android/model/StripeIntent;", "retrieveStripeIntent$payments_core_release", "retrieveStripeIntentWithOrderedPaymentMethods", "T", "parser", "Lcom/stripe/android/model/parsers/PaymentMethodPreferenceJsonParser;", "analyticsEvent", "(Ljava/lang/String;Lcom/stripe/android/core/networking/ApiRequest$Options;Ljava/util/Locale;Lcom/stripe/android/model/parsers/PaymentMethodPreferenceJsonParser;Lcom/stripe/android/networking/PaymentAnalyticsEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setCustomerShippingInfo", "shippingInformation", "Lcom/stripe/android/model/ShippingInformation;", "setCustomerShippingInfo$payments_core_release", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;Lcom/stripe/android/model/ShippingInformation;Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setDefaultCustomerSource", "setDefaultCustomerSource$payments_core_release", "start3ds2Auth", "authParams", "Lcom/stripe/android/model/Stripe3ds2AuthParams;", "start3ds2Auth$payments_core_release", "(Lcom/stripe/android/model/Stripe3ds2AuthParams;Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startConsumerVerification", "(Ljava/lang/String;Ljava/util/Locale;Ljava/lang/String;Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateIssuingCardPin", "newPin", "updateIssuingCardPin$payments_core_release", "verifyPaymentIntentWithMicrodeposits", "firstAmount", "", "secondAmount", "(Ljava/lang/String;IILcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "descriptorCode", "verifySetupIntentWithMicrodeposits", "maybeForDashboard", "(Lcom/stripe/android/model/ConfirmPaymentIntentParams;Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "DnsCacheData", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StripeApiRepository.kt */
public final class StripeApiRepository extends StripeRepository {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String DNS_CACHE_TTL_PROPERTY_NAME = "networkaddress.cache.ttl";
    private static final String PAYMENT_USER_AGENT = "payment_user_agent";
    private final AnalyticsRequestExecutor analyticsRequestExecutor;
    private final ApiRequest.Factory apiRequestFactory;
    private final AppInfo appInfo;
    private final FraudDetectionDataParamsUtils fraudDetectionDataParamsUtils;
    private final FraudDetectionDataRepository fraudDetectionDataRepository;
    private final Logger logger;
    /* access modifiers changed from: private */
    public final PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory;
    private final Set<String> productUsageTokens;
    private final StripeNetworkClient stripeNetworkClient;
    private final CoroutineContext workContext;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StripeApiRepository(Context context, Function0<String> function0) {
        this(context, function0, (AppInfo) null, (Logger) null, (CoroutineContext) null, (Set) null, (StripeNetworkClient) null, (AnalyticsRequestExecutor) null, (FraudDetectionDataRepository) null, (PaymentAnalyticsRequestFactory) null, (FraudDetectionDataParamsUtils) null, (Set) null, (String) null, (String) null, 16380, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function0, "publishableKeyProvider");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StripeApiRepository(Context context, Function0<String> function0, AppInfo appInfo2) {
        this(context, function0, appInfo2, (Logger) null, (CoroutineContext) null, (Set) null, (StripeNetworkClient) null, (AnalyticsRequestExecutor) null, (FraudDetectionDataRepository) null, (PaymentAnalyticsRequestFactory) null, (FraudDetectionDataParamsUtils) null, (Set) null, (String) null, (String) null, 16376, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function0, "publishableKeyProvider");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StripeApiRepository(Context context, Function0<String> function0, AppInfo appInfo2, Logger logger2) {
        this(context, function0, appInfo2, logger2, (CoroutineContext) null, (Set) null, (StripeNetworkClient) null, (AnalyticsRequestExecutor) null, (FraudDetectionDataRepository) null, (PaymentAnalyticsRequestFactory) null, (FraudDetectionDataParamsUtils) null, (Set) null, (String) null, (String) null, 16368, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function0, "publishableKeyProvider");
        Intrinsics.checkNotNullParameter(logger2, "logger");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StripeApiRepository(Context context, Function0<String> function0, AppInfo appInfo2, Logger logger2, CoroutineContext coroutineContext) {
        this(context, function0, appInfo2, logger2, coroutineContext, (Set) null, (StripeNetworkClient) null, (AnalyticsRequestExecutor) null, (FraudDetectionDataRepository) null, (PaymentAnalyticsRequestFactory) null, (FraudDetectionDataParamsUtils) null, (Set) null, (String) null, (String) null, 16352, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function0, "publishableKeyProvider");
        Intrinsics.checkNotNullParameter(logger2, "logger");
        Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StripeApiRepository(Context context, Function0<String> function0, AppInfo appInfo2, Logger logger2, CoroutineContext coroutineContext, Set<String> set) {
        this(context, function0, appInfo2, logger2, coroutineContext, set, (StripeNetworkClient) null, (AnalyticsRequestExecutor) null, (FraudDetectionDataRepository) null, (PaymentAnalyticsRequestFactory) null, (FraudDetectionDataParamsUtils) null, (Set) null, (String) null, (String) null, 16320, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function0, "publishableKeyProvider");
        Intrinsics.checkNotNullParameter(logger2, "logger");
        Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
        Intrinsics.checkNotNullParameter(set, "productUsageTokens");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StripeApiRepository(Context context, Function0<String> function0, AppInfo appInfo2, Logger logger2, CoroutineContext coroutineContext, Set<String> set, StripeNetworkClient stripeNetworkClient2) {
        this(context, function0, appInfo2, logger2, coroutineContext, set, stripeNetworkClient2, (AnalyticsRequestExecutor) null, (FraudDetectionDataRepository) null, (PaymentAnalyticsRequestFactory) null, (FraudDetectionDataParamsUtils) null, (Set) null, (String) null, (String) null, 16256, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function0, "publishableKeyProvider");
        Intrinsics.checkNotNullParameter(logger2, "logger");
        Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
        Intrinsics.checkNotNullParameter(set, "productUsageTokens");
        Intrinsics.checkNotNullParameter(stripeNetworkClient2, "stripeNetworkClient");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StripeApiRepository(Context context, Function0<String> function0, AppInfo appInfo2, Logger logger2, CoroutineContext coroutineContext, Set<String> set, StripeNetworkClient stripeNetworkClient2, AnalyticsRequestExecutor analyticsRequestExecutor2) {
        this(context, function0, appInfo2, logger2, coroutineContext, set, stripeNetworkClient2, analyticsRequestExecutor2, (FraudDetectionDataRepository) null, (PaymentAnalyticsRequestFactory) null, (FraudDetectionDataParamsUtils) null, (Set) null, (String) null, (String) null, 16128, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function0, "publishableKeyProvider");
        Intrinsics.checkNotNullParameter(logger2, "logger");
        Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
        Intrinsics.checkNotNullParameter(set, "productUsageTokens");
        Intrinsics.checkNotNullParameter(stripeNetworkClient2, "stripeNetworkClient");
        Intrinsics.checkNotNullParameter(analyticsRequestExecutor2, "analyticsRequestExecutor");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StripeApiRepository(Context context, Function0<String> function0, AppInfo appInfo2, Logger logger2, CoroutineContext coroutineContext, Set<String> set, StripeNetworkClient stripeNetworkClient2, AnalyticsRequestExecutor analyticsRequestExecutor2, FraudDetectionDataRepository fraudDetectionDataRepository2) {
        this(context, function0, appInfo2, logger2, coroutineContext, set, stripeNetworkClient2, analyticsRequestExecutor2, fraudDetectionDataRepository2, (PaymentAnalyticsRequestFactory) null, (FraudDetectionDataParamsUtils) null, (Set) null, (String) null, (String) null, 15872, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function0, "publishableKeyProvider");
        Intrinsics.checkNotNullParameter(logger2, "logger");
        Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
        Intrinsics.checkNotNullParameter(set, "productUsageTokens");
        Intrinsics.checkNotNullParameter(stripeNetworkClient2, "stripeNetworkClient");
        Intrinsics.checkNotNullParameter(analyticsRequestExecutor2, "analyticsRequestExecutor");
        Intrinsics.checkNotNullParameter(fraudDetectionDataRepository2, "fraudDetectionDataRepository");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StripeApiRepository(Context context, Function0<String> function0, AppInfo appInfo2, Logger logger2, CoroutineContext coroutineContext, Set<String> set, StripeNetworkClient stripeNetworkClient2, AnalyticsRequestExecutor analyticsRequestExecutor2, FraudDetectionDataRepository fraudDetectionDataRepository2, PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory2) {
        this(context, function0, appInfo2, logger2, coroutineContext, set, stripeNetworkClient2, analyticsRequestExecutor2, fraudDetectionDataRepository2, paymentAnalyticsRequestFactory2, (FraudDetectionDataParamsUtils) null, (Set) null, (String) null, (String) null, 15360, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function0, "publishableKeyProvider");
        Intrinsics.checkNotNullParameter(logger2, "logger");
        Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
        Intrinsics.checkNotNullParameter(set, "productUsageTokens");
        Intrinsics.checkNotNullParameter(stripeNetworkClient2, "stripeNetworkClient");
        Intrinsics.checkNotNullParameter(analyticsRequestExecutor2, "analyticsRequestExecutor");
        Intrinsics.checkNotNullParameter(fraudDetectionDataRepository2, "fraudDetectionDataRepository");
        Intrinsics.checkNotNullParameter(paymentAnalyticsRequestFactory2, "paymentAnalyticsRequestFactory");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StripeApiRepository(Context context, Function0<String> function0, AppInfo appInfo2, Logger logger2, CoroutineContext coroutineContext, Set<String> set, StripeNetworkClient stripeNetworkClient2, AnalyticsRequestExecutor analyticsRequestExecutor2, FraudDetectionDataRepository fraudDetectionDataRepository2, PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory2, FraudDetectionDataParamsUtils fraudDetectionDataParamsUtils2) {
        this(context, function0, appInfo2, logger2, coroutineContext, set, stripeNetworkClient2, analyticsRequestExecutor2, fraudDetectionDataRepository2, paymentAnalyticsRequestFactory2, fraudDetectionDataParamsUtils2, (Set) null, (String) null, (String) null, 14336, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function0, "publishableKeyProvider");
        Intrinsics.checkNotNullParameter(logger2, "logger");
        Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
        Intrinsics.checkNotNullParameter(set, "productUsageTokens");
        Intrinsics.checkNotNullParameter(stripeNetworkClient2, "stripeNetworkClient");
        Intrinsics.checkNotNullParameter(analyticsRequestExecutor2, "analyticsRequestExecutor");
        Intrinsics.checkNotNullParameter(fraudDetectionDataRepository2, "fraudDetectionDataRepository");
        Intrinsics.checkNotNullParameter(paymentAnalyticsRequestFactory2, "paymentAnalyticsRequestFactory");
        Intrinsics.checkNotNullParameter(fraudDetectionDataParamsUtils2, "fraudDetectionDataParamsUtils");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StripeApiRepository(Context context, Function0<String> function0, AppInfo appInfo2, Logger logger2, CoroutineContext coroutineContext, Set<String> set, StripeNetworkClient stripeNetworkClient2, AnalyticsRequestExecutor analyticsRequestExecutor2, FraudDetectionDataRepository fraudDetectionDataRepository2, PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory2, FraudDetectionDataParamsUtils fraudDetectionDataParamsUtils2, Set<? extends StripeApiBeta> set2) {
        this(context, function0, appInfo2, logger2, coroutineContext, set, stripeNetworkClient2, analyticsRequestExecutor2, fraudDetectionDataRepository2, paymentAnalyticsRequestFactory2, fraudDetectionDataParamsUtils2, set2, (String) null, (String) null, 12288, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function0, "publishableKeyProvider");
        Intrinsics.checkNotNullParameter(logger2, "logger");
        Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
        Intrinsics.checkNotNullParameter(set, "productUsageTokens");
        Intrinsics.checkNotNullParameter(stripeNetworkClient2, "stripeNetworkClient");
        Intrinsics.checkNotNullParameter(analyticsRequestExecutor2, "analyticsRequestExecutor");
        Intrinsics.checkNotNullParameter(fraudDetectionDataRepository2, "fraudDetectionDataRepository");
        Intrinsics.checkNotNullParameter(paymentAnalyticsRequestFactory2, "paymentAnalyticsRequestFactory");
        Intrinsics.checkNotNullParameter(fraudDetectionDataParamsUtils2, "fraudDetectionDataParamsUtils");
        Intrinsics.checkNotNullParameter(set2, "betas");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StripeApiRepository(Context context, Function0<String> function0, AppInfo appInfo2, Logger logger2, CoroutineContext coroutineContext, Set<String> set, StripeNetworkClient stripeNetworkClient2, AnalyticsRequestExecutor analyticsRequestExecutor2, FraudDetectionDataRepository fraudDetectionDataRepository2, PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory2, FraudDetectionDataParamsUtils fraudDetectionDataParamsUtils2, Set<? extends StripeApiBeta> set2, String str) {
        this(context, function0, appInfo2, logger2, coroutineContext, set, stripeNetworkClient2, analyticsRequestExecutor2, fraudDetectionDataRepository2, paymentAnalyticsRequestFactory2, fraudDetectionDataParamsUtils2, set2, str, (String) null, 8192, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function0, "publishableKeyProvider");
        Intrinsics.checkNotNullParameter(logger2, "logger");
        Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
        Intrinsics.checkNotNullParameter(set, "productUsageTokens");
        Intrinsics.checkNotNullParameter(stripeNetworkClient2, "stripeNetworkClient");
        Intrinsics.checkNotNullParameter(analyticsRequestExecutor2, "analyticsRequestExecutor");
        Intrinsics.checkNotNullParameter(fraudDetectionDataRepository2, "fraudDetectionDataRepository");
        Intrinsics.checkNotNullParameter(paymentAnalyticsRequestFactory2, "paymentAnalyticsRequestFactory");
        Intrinsics.checkNotNullParameter(fraudDetectionDataParamsUtils2, "fraudDetectionDataParamsUtils");
        Intrinsics.checkNotNullParameter(set2, "betas");
        Intrinsics.checkNotNullParameter(str, "apiVersion");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ StripeApiRepository(android.content.Context r19, kotlin.jvm.functions.Function0 r20, com.stripe.android.core.AppInfo r21, com.stripe.android.core.Logger r22, kotlin.coroutines.CoroutineContext r23, java.util.Set r24, com.stripe.android.core.networking.StripeNetworkClient r25, com.stripe.android.core.networking.AnalyticsRequestExecutor r26, com.stripe.android.FraudDetectionDataRepository r27, com.stripe.android.networking.PaymentAnalyticsRequestFactory r28, com.stripe.android.networking.FraudDetectionDataParamsUtils r29, java.util.Set r30, java.lang.String r31, java.lang.String r32, int r33, kotlin.jvm.internal.DefaultConstructorMarker r34) {
        /*
            r18 = this;
            r1 = r19
            r0 = r33
            r2 = r0 & 4
            if (r2 == 0) goto L_0x0010
            com.stripe.android.Stripe$Companion r2 = com.stripe.android.Stripe.Companion
            com.stripe.android.core.AppInfo r2 = r2.getAppInfo()
            r3 = r2
            goto L_0x0012
        L_0x0010:
            r3 = r21
        L_0x0012:
            r2 = r0 & 8
            if (r2 == 0) goto L_0x001e
            com.stripe.android.core.Logger$Companion r2 = com.stripe.android.core.Logger.Companion
            com.stripe.android.core.Logger r2 = r2.noop()
            r12 = r2
            goto L_0x0020
        L_0x001e:
            r12 = r22
        L_0x0020:
            r2 = r0 & 16
            if (r2 == 0) goto L_0x002c
            kotlinx.coroutines.CoroutineDispatcher r2 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2
            r13 = r2
            goto L_0x002e
        L_0x002c:
            r13 = r23
        L_0x002e:
            r2 = r0 & 32
            if (r2 == 0) goto L_0x0038
            java.util.Set r2 = kotlin.collections.SetsKt.emptySet()
            r14 = r2
            goto L_0x003a
        L_0x0038:
            r14 = r24
        L_0x003a:
            r2 = r0 & 64
            if (r2 == 0) goto L_0x0050
            com.stripe.android.core.networking.DefaultStripeNetworkClient r2 = new com.stripe.android.core.networking.DefaultStripeNetworkClient
            r6 = 0
            r7 = 0
            r8 = 0
            r10 = 14
            r11 = 0
            r4 = r2
            r5 = r13
            r9 = r12
            r4.<init>(r5, r6, r7, r8, r9, r10, r11)
            com.stripe.android.core.networking.StripeNetworkClient r2 = (com.stripe.android.core.networking.StripeNetworkClient) r2
            r7 = r2
            goto L_0x0052
        L_0x0050:
            r7 = r25
        L_0x0052:
            r2 = r0 & 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x005f
            com.stripe.android.core.networking.DefaultAnalyticsRequestExecutor r2 = new com.stripe.android.core.networking.DefaultAnalyticsRequestExecutor
            r2.<init>(r12, r13)
            com.stripe.android.core.networking.AnalyticsRequestExecutor r2 = (com.stripe.android.core.networking.AnalyticsRequestExecutor) r2
            r8 = r2
            goto L_0x0061
        L_0x005f:
            r8 = r26
        L_0x0061:
            r2 = r0 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x006e
            com.stripe.android.DefaultFraudDetectionDataRepository r2 = new com.stripe.android.DefaultFraudDetectionDataRepository
            r2.<init>(r1, r13)
            com.stripe.android.FraudDetectionDataRepository r2 = (com.stripe.android.FraudDetectionDataRepository) r2
            r9 = r2
            goto L_0x0070
        L_0x006e:
            r9 = r27
        L_0x0070:
            r2 = r0 & 512(0x200, float:7.175E-43)
            if (r2 == 0) goto L_0x007d
            com.stripe.android.networking.PaymentAnalyticsRequestFactory r2 = new com.stripe.android.networking.PaymentAnalyticsRequestFactory
            r4 = r20
            r2.<init>((android.content.Context) r1, (kotlin.jvm.functions.Function0<java.lang.String>) r4, (java.util.Set<java.lang.String>) r14)
            r10 = r2
            goto L_0x0081
        L_0x007d:
            r4 = r20
            r10 = r28
        L_0x0081:
            r2 = r0 & 1024(0x400, float:1.435E-42)
            if (r2 == 0) goto L_0x008c
            com.stripe.android.networking.FraudDetectionDataParamsUtils r2 = new com.stripe.android.networking.FraudDetectionDataParamsUtils
            r2.<init>()
            r11 = r2
            goto L_0x008e
        L_0x008c:
            r11 = r29
        L_0x008e:
            r2 = r0 & 2048(0x800, float:2.87E-42)
            if (r2 == 0) goto L_0x0098
            java.util.Set r2 = kotlin.collections.SetsKt.emptySet()
            r15 = r2
            goto L_0x009a
        L_0x0098:
            r15 = r30
        L_0x009a:
            r2 = r0 & 4096(0x1000, float:5.74E-42)
            if (r2 == 0) goto L_0x00da
            r2 = r15
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r5 = new java.util.ArrayList
            r6 = 10
            int r6 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r2, r6)
            r5.<init>(r6)
            java.util.Collection r5 = (java.util.Collection) r5
            java.util.Iterator r2 = r2.iterator()
        L_0x00b2:
            boolean r6 = r2.hasNext()
            if (r6 == 0) goto L_0x00c6
            java.lang.Object r6 = r2.next()
            com.stripe.android.StripeApiBeta r6 = (com.stripe.android.StripeApiBeta) r6
            java.lang.String r6 = r6.getCode()
            r5.add(r6)
            goto L_0x00b2
        L_0x00c6:
            java.util.List r5 = (java.util.List) r5
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Set r2 = kotlin.collections.CollectionsKt.toSet(r5)
            com.stripe.android.core.ApiVersion r5 = new com.stripe.android.core.ApiVersion
            r5.<init>(r2)
            java.lang.String r2 = r5.getCode()
            r16 = r2
            goto L_0x00dc
        L_0x00da:
            r16 = r31
        L_0x00dc:
            r0 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x00e5
            java.lang.String r0 = "AndroidBindings/20.1.0"
            r17 = r0
            goto L_0x00e7
        L_0x00e5:
            r17 = r32
        L_0x00e7:
            r0 = r18
            r1 = r19
            r2 = r20
            r4 = r12
            r5 = r13
            r6 = r14
            r12 = r15
            r13 = r16
            r14 = r17
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.networking.StripeApiRepository.<init>(android.content.Context, kotlin.jvm.functions.Function0, com.stripe.android.core.AppInfo, com.stripe.android.core.Logger, kotlin.coroutines.CoroutineContext, java.util.Set, com.stripe.android.core.networking.StripeNetworkClient, com.stripe.android.core.networking.AnalyticsRequestExecutor, com.stripe.android.FraudDetectionDataRepository, com.stripe.android.networking.PaymentAnalyticsRequestFactory, com.stripe.android.networking.FraudDetectionDataParamsUtils, java.util.Set, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public StripeApiRepository(Context context, Function0<String> function0, AppInfo appInfo2, Logger logger2, CoroutineContext coroutineContext, Set<String> set, StripeNetworkClient stripeNetworkClient2, AnalyticsRequestExecutor analyticsRequestExecutor2, FraudDetectionDataRepository fraudDetectionDataRepository2, PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory2, FraudDetectionDataParamsUtils fraudDetectionDataParamsUtils2, Set<? extends StripeApiBeta> set2, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function0, "publishableKeyProvider");
        Intrinsics.checkNotNullParameter(logger2, "logger");
        Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
        Intrinsics.checkNotNullParameter(set, "productUsageTokens");
        Intrinsics.checkNotNullParameter(stripeNetworkClient2, "stripeNetworkClient");
        Intrinsics.checkNotNullParameter(analyticsRequestExecutor2, "analyticsRequestExecutor");
        Intrinsics.checkNotNullParameter(fraudDetectionDataRepository2, "fraudDetectionDataRepository");
        Intrinsics.checkNotNullParameter(paymentAnalyticsRequestFactory2, "paymentAnalyticsRequestFactory");
        Intrinsics.checkNotNullParameter(fraudDetectionDataParamsUtils2, "fraudDetectionDataParamsUtils");
        Intrinsics.checkNotNullParameter(set2, "betas");
        Intrinsics.checkNotNullParameter(str, "apiVersion");
        Intrinsics.checkNotNullParameter(str2, "sdkVersion");
        this.appInfo = appInfo2;
        this.logger = logger2;
        this.workContext = coroutineContext;
        this.productUsageTokens = set;
        this.stripeNetworkClient = stripeNetworkClient2;
        this.analyticsRequestExecutor = analyticsRequestExecutor2;
        this.fraudDetectionDataRepository = fraudDetectionDataRepository2;
        this.paymentAnalyticsRequestFactory = paymentAnalyticsRequestFactory2;
        this.fraudDetectionDataParamsUtils = fraudDetectionDataParamsUtils2;
        this.apiRequestFactory = new ApiRequest.Factory(appInfo2, str, str2);
        fireFraudDetectionDataRequest();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @javax.inject.Inject
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public StripeApiRepository(android.content.Context r18, @javax.inject.Named("publishableKey") kotlin.jvm.functions.Function0<java.lang.String> r19, @com.stripe.android.core.injection.IOContext kotlin.coroutines.CoroutineContext r20, @javax.inject.Named("productUsage") java.util.Set<java.lang.String> r21, com.stripe.android.networking.PaymentAnalyticsRequestFactory r22, com.stripe.android.core.networking.AnalyticsRequestExecutor r23, com.stripe.android.core.Logger r24) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            r5 = r20
            r6 = r21
            r10 = r22
            r8 = r23
            r4 = r24
            java.lang.String r3 = "appContext"
            r7 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r3)
            java.lang.String r3 = "publishableKeyProvider"
            r7 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r3)
            java.lang.String r3 = "workContext"
            r7 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r3)
            java.lang.String r3 = "productUsageTokens"
            r7 = r21
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r3)
            java.lang.String r3 = "paymentAnalyticsRequestFactory"
            r7 = r22
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r3)
            java.lang.String r3 = "analyticsRequestExecutor"
            r7 = r23
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r3)
            java.lang.String r3 = "logger"
            r7 = r24
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r3)
            r3 = 0
            r7 = 0
            r9 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 15684(0x3d44, float:2.1978E-41)
            r16 = 0
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.networking.StripeApiRepository.<init>(android.content.Context, kotlin.jvm.functions.Function0, kotlin.coroutines.CoroutineContext, java.util.Set, com.stripe.android.networking.PaymentAnalyticsRequestFactory, com.stripe.android.core.networking.AnalyticsRequestExecutor, com.stripe.android.core.Logger):void");
    }

    private final FraudDetectionData getFraudDetectionData() {
        return this.fraudDetectionDataRepository.getCached();
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object retrieveStripeIntent$payments_core_release(java.lang.String r6, com.stripe.android.core.networking.ApiRequest.Options r7, java.util.List<java.lang.String> r8, kotlin.coroutines.Continuation<? super com.stripe.android.model.StripeIntent> r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof com.stripe.android.networking.StripeApiRepository$retrieveStripeIntent$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.stripe.android.networking.StripeApiRepository$retrieveStripeIntent$1 r0 = (com.stripe.android.networking.StripeApiRepository$retrieveStripeIntent$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.stripe.android.networking.StripeApiRepository$retrieveStripeIntent$1 r0 = new com.stripe.android.networking.StripeApiRepository$retrieveStripeIntent$1
            r0.<init>(r5, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x006f
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x004d
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r9)
            com.stripe.android.model.PaymentIntent$ClientSecret$Companion r9 = com.stripe.android.model.PaymentIntent.ClientSecret.Companion
            boolean r9 = r9.isMatch(r6)
            if (r9 == 0) goto L_0x005e
            r0.label = r4
            java.lang.Object r9 = r5.retrievePaymentIntent(r6, r7, r8, r0)
            if (r9 != r1) goto L_0x004d
            return r1
        L_0x004d:
            if (r9 == 0) goto L_0x0052
            com.stripe.android.model.StripeIntent r9 = (com.stripe.android.model.StripeIntent) r9
            goto L_0x0073
        L_0x0052:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r7 = "Could not retrieve PaymentIntent."
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            throw r6
        L_0x005e:
            com.stripe.android.model.SetupIntent$ClientSecret$Companion r9 = com.stripe.android.model.SetupIntent.ClientSecret.Companion
            boolean r9 = r9.isMatch(r6)
            if (r9 == 0) goto L_0x0080
            r0.label = r3
            java.lang.Object r9 = r5.retrieveSetupIntent(r6, r7, r8, r0)
            if (r9 != r1) goto L_0x006f
            return r1
        L_0x006f:
            if (r9 == 0) goto L_0x0074
            com.stripe.android.model.StripeIntent r9 = (com.stripe.android.model.StripeIntent) r9
        L_0x0073:
            return r9
        L_0x0074:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r7 = "Could not retrieve SetupIntent."
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            throw r6
        L_0x0080:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "Invalid client secret."
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.networking.StripeApiRepository.retrieveStripeIntent$payments_core_release(java.lang.String, com.stripe.android.core.networking.ApiRequest$Options, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: java.util.List<java.lang.String>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006b A[PHI: r9 
      PHI: (r9v2 java.lang.Object) = (r9v5 java.lang.Object), (r9v1 java.lang.Object) binds: [B:19:0x0068, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object confirmPaymentIntent$payments_core_release(com.stripe.android.model.ConfirmPaymentIntentParams r6, com.stripe.android.core.networking.ApiRequest.Options r7, java.util.List<java.lang.String> r8, kotlin.coroutines.Continuation<? super com.stripe.android.model.PaymentIntent> r9) throws com.stripe.android.core.exception.AuthenticationException, com.stripe.android.core.exception.InvalidRequestException, com.stripe.android.core.exception.APIConnectionException, com.stripe.android.core.exception.APIException {
        /*
            r5 = this;
            boolean r0 = r9 instanceof com.stripe.android.networking.StripeApiRepository$confirmPaymentIntent$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.stripe.android.networking.StripeApiRepository$confirmPaymentIntent$1 r0 = (com.stripe.android.networking.StripeApiRepository$confirmPaymentIntent$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.stripe.android.networking.StripeApiRepository$confirmPaymentIntent$1 r0 = new com.stripe.android.networking.StripeApiRepository$confirmPaymentIntent$1
            r0.<init>(r5, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0046
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x006b
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0035:
            java.lang.Object r6 = r0.L$2
            com.stripe.android.networking.StripeApiRepository r6 = (com.stripe.android.networking.StripeApiRepository) r6
            java.lang.Object r7 = r0.L$1
            r8 = r7
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r7 = r0.L$0
            com.stripe.android.core.networking.ApiRequest$Options r7 = (com.stripe.android.core.networking.ApiRequest.Options) r7
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0059
        L_0x0046:
            kotlin.ResultKt.throwOnFailure(r9)
            r0.L$0 = r7
            r0.L$1 = r8
            r0.L$2 = r5
            r0.label = r4
            java.lang.Object r9 = r5.maybeForDashboard(r6, r7, r0)
            if (r9 != r1) goto L_0x0058
            return r1
        L_0x0058:
            r6 = r5
        L_0x0059:
            com.stripe.android.model.ConfirmPaymentIntentParams r9 = (com.stripe.android.model.ConfirmPaymentIntentParams) r9
            r2 = 0
            r0.L$0 = r2
            r0.L$1 = r2
            r0.L$2 = r2
            r0.label = r3
            java.lang.Object r9 = r6.confirmPaymentIntentInternal(r9, r7, r8, r0)
            if (r9 != r1) goto L_0x006b
            return r1
        L_0x006b:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.networking.StripeApiRepository.confirmPaymentIntent$payments_core_release(com.stripe.android.model.ConfirmPaymentIntentParams, com.stripe.android.core.networking.ApiRequest$Options, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Object confirmPaymentIntentInternal(ConfirmPaymentIntentParams confirmPaymentIntentParams, ApiRequest.Options options, List<String> list, Continuation<? super PaymentIntent> continuation) {
        FraudDetectionDataParamsUtils fraudDetectionDataParamsUtils2 = this.fraudDetectionDataParamsUtils;
        Map<String, Object> paramMap = confirmPaymentIntentParams.toParamMap();
        if (options.getApiKeyIsUserKey()) {
            paramMap = MapsKt.minus(paramMap, "client_secret");
        }
        Map<String, Object> maybeAddPaymentUserAgent = maybeAddPaymentUserAgent(paramMap, confirmPaymentIntentParams.getPaymentMethodCreateParams(), confirmPaymentIntentParams.getSourceParams());
        Companion companion = Companion;
        Map<String, ?> addFraudDetectionData$payments_core_release = fraudDetectionDataParamsUtils2.addFraudDetectionData$payments_core_release(MapsKt.plus(maybeAddPaymentUserAgent, (Map<String, Object>) companion.createExpandParam(list)), getFraudDetectionData());
        String confirmPaymentIntentUrl$payments_core_release = companion.getConfirmPaymentIntentUrl$payments_core_release(new PaymentIntent.ClientSecret(confirmPaymentIntentParams.getClientSecret()).getPaymentIntentId$payments_core_release());
        fireFraudDetectionDataRequest();
        return fetchStripeModel(this.apiRequestFactory.createPost(confirmPaymentIntentUrl$payments_core_release, options, addFraudDetectionData$payments_core_release), new PaymentIntentJsonParser(), new StripeApiRepository$confirmPaymentIntentInternal$2(confirmPaymentIntentParams, this), continuation);
    }

    public Object retrievePaymentIntent(String str, ApiRequest.Options options, List<String> list, Continuation<? super PaymentIntent> continuation) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException {
        Map<String, Object> map;
        String paymentIntentId$payments_core_release = new PaymentIntent.ClientSecret(str).getPaymentIntentId$payments_core_release();
        if (options.getApiKeyIsUserKey()) {
            map = Companion.createExpandParam(list);
        } else {
            map = createClientSecretParam(str, list);
        }
        fireFraudDetectionDataRequest();
        return fetchStripeModel(this.apiRequestFactory.createGet(Companion.getRetrievePaymentIntentUrl$payments_core_release(paymentIntentId$payments_core_release), options, map), new PaymentIntentJsonParser(), new StripeApiRepository$retrievePaymentIntent$2(this), continuation);
    }

    public Object refreshPaymentIntent$payments_core_release(String str, ApiRequest.Options options, Continuation<? super PaymentIntent> continuation) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException {
        String paymentIntentId$payments_core_release = new PaymentIntent.ClientSecret(str).getPaymentIntentId$payments_core_release();
        fireFraudDetectionDataRequest();
        return fetchStripeModel(this.apiRequestFactory.createPost(Companion.getRefreshPaymentIntentUrl$payments_core_release(paymentIntentId$payments_core_release), options, createClientSecretParam(str, CollectionsKt.emptyList())), new PaymentIntentJsonParser(), new StripeApiRepository$refreshPaymentIntent$2(this), continuation);
    }

    public Object retrievePaymentIntentWithOrderedPaymentMethods(String str, ApiRequest.Options options, Locale locale, Continuation<? super PaymentIntent> continuation) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException {
        return retrieveStripeIntentWithOrderedPaymentMethods(str, options, locale, new PaymentMethodPreferenceForPaymentIntentJsonParser(), PaymentAnalyticsEvent.PaymentIntentRetrieve, continuation);
    }

    public Object cancelPaymentIntentSource$payments_core_release(String str, String str2, ApiRequest.Options options, Continuation<? super PaymentIntent> continuation) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException {
        fireFraudDetectionDataRequest();
        return fetchStripeModel(this.apiRequestFactory.createPost(Companion.getCancelPaymentIntentSourceUrl$payments_core_release(str), options, MapsKt.mapOf(TuplesKt.to("source", str2))), new PaymentIntentJsonParser(), new StripeApiRepository$cancelPaymentIntentSource$2(this), continuation);
    }

    public Object confirmSetupIntent$payments_core_release(ConfirmSetupIntentParams confirmSetupIntentParams, ApiRequest.Options options, List<String> list, Continuation<? super SetupIntent> continuation) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException {
        String setupIntentId$payments_core_release = new SetupIntent.ClientSecret(confirmSetupIntentParams.getClientSecret()).getSetupIntentId$payments_core_release();
        fireFraudDetectionDataRequest();
        ApiRequest.Factory factory = this.apiRequestFactory;
        Companion companion = Companion;
        return fetchStripeModel(factory.createPost(companion.getConfirmSetupIntentUrl$payments_core_release(setupIntentId$payments_core_release), options, this.fraudDetectionDataParamsUtils.addFraudDetectionData$payments_core_release(MapsKt.plus(maybeAddPaymentUserAgent$default(this, confirmSetupIntentParams.toParamMap(), confirmSetupIntentParams.getPaymentMethodCreateParams$payments_core_release(), (SourceParams) null, 4, (Object) null), companion.createExpandParam(list)), getFraudDetectionData())), new SetupIntentJsonParser(), new StripeApiRepository$confirmSetupIntent$2(this, confirmSetupIntentParams), continuation);
    }

    public Object retrieveSetupIntent(String str, ApiRequest.Options options, List<String> list, Continuation<? super SetupIntent> continuation) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException {
        String setupIntentId$payments_core_release = new SetupIntent.ClientSecret(str).getSetupIntentId$payments_core_release();
        fireFraudDetectionDataRequest();
        return fetchStripeModel(this.apiRequestFactory.createGet(Companion.getRetrieveSetupIntentUrl$payments_core_release(setupIntentId$payments_core_release), options, createClientSecretParam(str, list)), new SetupIntentJsonParser(), new StripeApiRepository$retrieveSetupIntent$2(this), continuation);
    }

    public Object retrieveSetupIntentWithOrderedPaymentMethods(String str, ApiRequest.Options options, Locale locale, Continuation<? super SetupIntent> continuation) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException {
        return retrieveStripeIntentWithOrderedPaymentMethods(str, options, locale, new PaymentMethodPreferenceForSetupIntentJsonParser(), PaymentAnalyticsEvent.SetupIntentRetrieve, continuation);
    }

    public Object cancelSetupIntentSource$payments_core_release(String str, String str2, ApiRequest.Options options, Continuation<? super SetupIntent> continuation) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException {
        return fetchStripeModel(this.apiRequestFactory.createPost(Companion.getCancelSetupIntentSourceUrl$payments_core_release(str), options, MapsKt.mapOf(TuplesKt.to("source", str2))), new SetupIntentJsonParser(), new StripeApiRepository$cancelSetupIntentSource$2(this), continuation);
    }

    public Object createSource$payments_core_release(SourceParams sourceParams, ApiRequest.Options options, Continuation<? super Source> continuation) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException {
        fireFraudDetectionDataRequest();
        ApiRequest.Factory factory = this.apiRequestFactory;
        String sourcesUrl$payments_core_release = Companion.getSourcesUrl$payments_core_release();
        Map<K, V> plus = MapsKt.plus(sourceParams.toParamMap(), buildPaymentUserAgentPair(sourceParams.getAttribution$payments_core_release()));
        FraudDetectionData fraudDetectionData = getFraudDetectionData();
        Map<String, String> params = fraudDetectionData == null ? null : fraudDetectionData.getParams();
        if (params == null) {
            params = MapsKt.emptyMap();
        }
        return fetchStripeModel(factory.createPost(sourcesUrl$payments_core_release, options, MapsKt.plus(plus, (Map<K, V>) params)), new SourceJsonParser(), new StripeApiRepository$createSource$2(this, sourceParams), continuation);
    }

    public Object retrieveSource$payments_core_release(String str, String str2, ApiRequest.Options options, Continuation<? super Source> continuation) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException {
        return fetchStripeModel(this.apiRequestFactory.createGet(Companion.getRetrieveSourceApiUrl$payments_core_release(str), options, SourceParams.Companion.createRetrieveSourceParams(str2)), new SourceJsonParser(), new StripeApiRepository$retrieveSource$2(this), continuation);
    }

    public Object createPaymentMethod(PaymentMethodCreateParams paymentMethodCreateParams, ApiRequest.Options options, Continuation<? super PaymentMethod> continuation) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException {
        fireFraudDetectionDataRequest();
        ApiRequest.Factory factory = this.apiRequestFactory;
        String paymentMethodsUrl$payments_core_release = Companion.getPaymentMethodsUrl$payments_core_release();
        Map<K, V> plus = MapsKt.plus(paymentMethodCreateParams.toParamMap(), buildPaymentUserAgentPair(paymentMethodCreateParams.getAttribution$payments_core_release()));
        FraudDetectionData fraudDetectionData = getFraudDetectionData();
        Map<String, String> params = fraudDetectionData == null ? null : fraudDetectionData.getParams();
        if (params == null) {
            params = MapsKt.emptyMap();
        }
        return fetchStripeModel(factory.createPost(paymentMethodsUrl$payments_core_release, options, MapsKt.plus(plus, (Map<K, V>) params)), new PaymentMethodJsonParser(), new StripeApiRepository$createPaymentMethod$2(this, paymentMethodCreateParams), continuation);
    }

    public Object createToken$payments_core_release(TokenParams tokenParams, ApiRequest.Options options, Continuation<? super Token> continuation) throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException {
        fireFraudDetectionDataRequest();
        ApiRequest.Factory factory = this.apiRequestFactory;
        String tokensUrl$payments_core_release = Companion.getTokensUrl$payments_core_release();
        Map<K, V> plus = MapsKt.plus(tokenParams.toParamMap(), buildPaymentUserAgentPair(tokenParams.getAttribution()));
        FraudDetectionData fraudDetectionData = getFraudDetectionData();
        Map<String, String> params = fraudDetectionData == null ? null : fraudDetectionData.getParams();
        if (params == null) {
            params = MapsKt.emptyMap();
        }
        return fetchStripeModel(factory.createPost(tokensUrl$payments_core_release, options, MapsKt.plus(plus, (Map<K, V>) params)), new TokenJsonParser(), new StripeApiRepository$createToken$2(this, tokenParams), continuation);
    }

    public Object addCustomerSource$payments_core_release(String str, String str2, Set<String> set, String str3, String str4, ApiRequest.Options options, Continuation<? super Source> continuation) throws InvalidRequestException, APIConnectionException, APIException, AuthenticationException, CardException {
        return fetchStripeModel(this.apiRequestFactory.createPost(Companion.getAddCustomerSourceUrl$payments_core_release(str), options, MapsKt.mapOf(TuplesKt.to("source", str3))), new SourceJsonParser(), new StripeApiRepository$addCustomerSource$2(this, set, str4), continuation);
    }

    public Object deleteCustomerSource$payments_core_release(String str, String str2, Set<String> set, String str3, ApiRequest.Options options, Continuation<? super Source> continuation) throws InvalidRequestException, APIConnectionException, APIException, AuthenticationException, CardException {
        return fetchStripeModel(this.apiRequestFactory.createDelete(Companion.getDeleteCustomerSourceUrl$payments_core_release(str, str3), options), new SourceJsonParser(), new StripeApiRepository$deleteCustomerSource$2(this, set), continuation);
    }

    public Object attachPaymentMethod(String str, String str2, Set<String> set, String str3, ApiRequest.Options options, Continuation<? super PaymentMethod> continuation) throws InvalidRequestException, APIConnectionException, APIException, AuthenticationException, CardException {
        fireFraudDetectionDataRequest();
        return fetchStripeModel(this.apiRequestFactory.createPost(Companion.getAttachPaymentMethodUrl$payments_core_release(str3), options, MapsKt.mapOf(TuplesKt.to("customer", str))), new PaymentMethodJsonParser(), new StripeApiRepository$attachPaymentMethod$2(this, set), continuation);
    }

    public Object detachPaymentMethod(String str, Set<String> set, String str2, ApiRequest.Options options, Continuation<? super PaymentMethod> continuation) throws InvalidRequestException, APIConnectionException, APIException, AuthenticationException, CardException {
        return fetchStripeModel(ApiRequest.Factory.createPost$default(this.apiRequestFactory, getDetachPaymentMethodUrl$payments_core_release(str2), options, (Map) null, 4, (Object) null), new PaymentMethodJsonParser(), new StripeApiRepository$detachPaymentMethod$2(this, set), continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getPaymentMethods(com.stripe.android.model.ListPaymentMethodsParams r4, java.lang.String r5, java.util.Set<java.lang.String> r6, com.stripe.android.core.networking.ApiRequest.Options r7, kotlin.coroutines.Continuation<? super java.util.List<com.stripe.android.model.PaymentMethod>> r8) throws com.stripe.android.core.exception.InvalidRequestException, com.stripe.android.core.exception.APIConnectionException, com.stripe.android.core.exception.APIException, com.stripe.android.core.exception.AuthenticationException, com.stripe.android.exception.CardException {
        /*
            r3 = this;
            boolean r5 = r8 instanceof com.stripe.android.networking.StripeApiRepository$getPaymentMethods$1
            if (r5 == 0) goto L_0x0014
            r5 = r8
            com.stripe.android.networking.StripeApiRepository$getPaymentMethods$1 r5 = (com.stripe.android.networking.StripeApiRepository$getPaymentMethods$1) r5
            int r0 = r5.label
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0014
            int r8 = r5.label
            int r8 = r8 - r1
            r5.label = r8
            goto L_0x0019
        L_0x0014:
            com.stripe.android.networking.StripeApiRepository$getPaymentMethods$1 r5 = new com.stripe.android.networking.StripeApiRepository$getPaymentMethods$1
            r5.<init>(r3, r8)
        L_0x0019:
            java.lang.Object r8 = r5.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 1
            if (r1 == 0) goto L_0x0032
            if (r1 != r2) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x005c
        L_0x002a:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r8)
            com.stripe.android.core.networking.ApiRequest$Factory r8 = r3.apiRequestFactory
            com.stripe.android.networking.StripeApiRepository$Companion r1 = Companion
            java.lang.String r1 = r1.getPaymentMethodsUrl$payments_core_release()
            java.util.Map r4 = r4.toParamMap()
            com.stripe.android.core.networking.ApiRequest r4 = r8.createGet(r1, r7, r4)
            com.stripe.android.model.parsers.PaymentMethodsListJsonParser r7 = new com.stripe.android.model.parsers.PaymentMethodsListJsonParser
            r7.<init>()
            com.stripe.android.core.model.parsers.ModelJsonParser r7 = (com.stripe.android.core.model.parsers.ModelJsonParser) r7
            com.stripe.android.networking.StripeApiRepository$getPaymentMethods$paymentMethodsList$1 r8 = new com.stripe.android.networking.StripeApiRepository$getPaymentMethods$paymentMethodsList$1
            r8.<init>(r3, r6)
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            r5.label = r2
            java.lang.Object r8 = r3.fetchStripeModel(r4, r7, r8, r5)
            if (r8 != r0) goto L_0x005c
            return r0
        L_0x005c:
            com.stripe.android.model.PaymentMethodsList r8 = (com.stripe.android.model.PaymentMethodsList) r8
            if (r8 != 0) goto L_0x0062
            r4 = 0
            goto L_0x0066
        L_0x0062:
            java.util.List r4 = r8.getPaymentMethods()
        L_0x0066:
            if (r4 != 0) goto L_0x006c
            java.util.List r4 = kotlin.collections.CollectionsKt.emptyList()
        L_0x006c:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.networking.StripeApiRepository.getPaymentMethods(com.stripe.android.model.ListPaymentMethodsParams, java.lang.String, java.util.Set, com.stripe.android.core.networking.ApiRequest$Options, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object setDefaultCustomerSource$payments_core_release(String str, String str2, Set<String> set, String str3, String str4, ApiRequest.Options options, Continuation<? super Customer> continuation) throws InvalidRequestException, APIConnectionException, APIException, AuthenticationException, CardException {
        return fetchStripeModel(this.apiRequestFactory.createPost(Companion.getRetrieveCustomerUrl$payments_core_release(str), options, MapsKt.mapOf(TuplesKt.to("default_source", str3))), new CustomerJsonParser(), new StripeApiRepository$setDefaultCustomerSource$2(this, set, str4), continuation);
    }

    public Object setCustomerShippingInfo$payments_core_release(String str, String str2, Set<String> set, ShippingInformation shippingInformation, ApiRequest.Options options, Continuation<? super Customer> continuation) throws InvalidRequestException, APIConnectionException, APIException, AuthenticationException, CardException {
        return fetchStripeModel(this.apiRequestFactory.createPost(Companion.getRetrieveCustomerUrl$payments_core_release(str), options, MapsKt.mapOf(TuplesKt.to(FirebaseAnalytics.Param.SHIPPING, shippingInformation.toParamMap()))), new CustomerJsonParser(), new StripeApiRepository$setCustomerShippingInfo$2(this, set), continuation);
    }

    public Object retrieveCustomer$payments_core_release(String str, Set<String> set, ApiRequest.Options options, Continuation<? super Customer> continuation) throws InvalidRequestException, APIConnectionException, APIException, AuthenticationException, CardException {
        return fetchStripeModel(ApiRequest.Factory.createGet$default(this.apiRequestFactory, Companion.getRetrieveCustomerUrl$payments_core_release(str), options, (Map) null, 4, (Object) null), new CustomerJsonParser(), new StripeApiRepository$retrieveCustomer$2(this, set), continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x006a A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object retrieveIssuingCardPin$payments_core_release(java.lang.String r5, java.lang.String r6, java.lang.String r7, com.stripe.android.core.networking.ApiRequest.Options r8, kotlin.coroutines.Continuation<? super java.lang.String> r9) throws com.stripe.android.core.exception.InvalidRequestException, com.stripe.android.core.exception.APIConnectionException, com.stripe.android.core.exception.APIException, com.stripe.android.core.exception.AuthenticationException, com.stripe.android.exception.CardException, org.json.JSONException {
        /*
            r4 = this;
            boolean r0 = r9 instanceof com.stripe.android.networking.StripeApiRepository$retrieveIssuingCardPin$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.stripe.android.networking.StripeApiRepository$retrieveIssuingCardPin$1 r0 = (com.stripe.android.networking.StripeApiRepository$retrieveIssuingCardPin$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.stripe.android.networking.StripeApiRepository$retrieveIssuingCardPin$1 r0 = new com.stripe.android.networking.StripeApiRepository$retrieveIssuingCardPin$1
            r0.<init>(r4, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0066
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r9)
            com.stripe.android.core.networking.ApiRequest$Factory r9 = r4.apiRequestFactory
            com.stripe.android.networking.StripeApiRepository$Companion r2 = Companion
            java.lang.String r5 = r2.getIssuingCardPinUrl$payments_core_release(r5)
            java.util.Map r6 = r2.createVerificationParam(r6, r7)
            java.lang.String r7 = "verification"
            kotlin.Pair r6 = kotlin.TuplesKt.to(r7, r6)
            java.util.Map r6 = kotlin.collections.MapsKt.mapOf(r6)
            com.stripe.android.core.networking.ApiRequest r5 = r9.createGet(r5, r8, r6)
            com.stripe.android.model.parsers.IssuingCardPinJsonParser r6 = new com.stripe.android.model.parsers.IssuingCardPinJsonParser
            r6.<init>()
            com.stripe.android.core.model.parsers.ModelJsonParser r6 = (com.stripe.android.core.model.parsers.ModelJsonParser) r6
            com.stripe.android.networking.StripeApiRepository$retrieveIssuingCardPin$issuingCardPin$1 r7 = new com.stripe.android.networking.StripeApiRepository$retrieveIssuingCardPin$issuingCardPin$1
            r7.<init>(r4)
            kotlin.jvm.functions.Function0 r7 = (kotlin.jvm.functions.Function0) r7
            r0.label = r3
            java.lang.Object r9 = r4.fetchStripeModel(r5, r6, r7, r0)
            if (r9 != r1) goto L_0x0066
            return r1
        L_0x0066:
            com.stripe.android.model.IssuingCardPin r9 = (com.stripe.android.model.IssuingCardPin) r9
            if (r9 != 0) goto L_0x006c
            r5 = 0
            goto L_0x0070
        L_0x006c:
            java.lang.String r5 = r9.getPin()
        L_0x0070:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.networking.StripeApiRepository.retrieveIssuingCardPin$payments_core_release(java.lang.String, java.lang.String, java.lang.String, com.stripe.android.core.networking.ApiRequest$Options, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object updateIssuingCardPin$payments_core_release(String str, String str2, String str3, String str4, ApiRequest.Options options, Continuation<? super Unit> continuation) throws InvalidRequestException, APIConnectionException, APIException, AuthenticationException, CardException {
        ApiRequest.Factory factory = this.apiRequestFactory;
        Companion companion = Companion;
        Object makeApiRequest$payments_core_release = makeApiRequest$payments_core_release(factory.createPost(companion.getIssuingCardPinUrl$payments_core_release(str), options, MapsKt.mapOf(TuplesKt.to("verification", companion.createVerificationParam(str3, str4)), TuplesKt.to("pin", str2))), new StripeApiRepository$updateIssuingCardPin$2(this), continuation);
        return makeApiRequest$payments_core_release == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? makeApiRequest$payments_core_release : Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0079 A[Catch:{ all -> 0x008a }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x007e A[Catch:{ all -> 0x008a }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getFpxBankStatus$payments_core_release(com.stripe.android.core.networking.ApiRequest.Options r12, kotlin.coroutines.Continuation<? super com.stripe.android.model.BankStatuses> r13) {
        /*
            r11 = this;
            boolean r0 = r13 instanceof com.stripe.android.networking.StripeApiRepository$getFpxBankStatus$1
            if (r0 == 0) goto L_0x0014
            r0 = r13
            com.stripe.android.networking.StripeApiRepository$getFpxBankStatus$1 r0 = (com.stripe.android.networking.StripeApiRepository$getFpxBankStatus$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L_0x0019
        L_0x0014:
            com.stripe.android.networking.StripeApiRepository$getFpxBankStatus$1 r0 = new com.stripe.android.networking.StripeApiRepository$getFpxBankStatus$1
            r0.<init>(r11, r13)
        L_0x0019:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ all -> 0x008a }
            goto L_0x0075
        L_0x002a:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r13)
            kotlin.Result$Companion r13 = kotlin.Result.Companion     // Catch:{ all -> 0x008a }
            r13 = r11
            com.stripe.android.networking.StripeApiRepository r13 = (com.stripe.android.networking.StripeApiRepository) r13     // Catch:{ all -> 0x008a }
            com.stripe.android.core.networking.ApiRequest$Factory r2 = r13.apiRequestFactory     // Catch:{ all -> 0x008a }
            com.stripe.android.networking.StripeApiRepository$Companion r4 = Companion     // Catch:{ all -> 0x008a }
            java.lang.String r5 = "fpx/bank_statuses"
            java.lang.String r4 = r4.getApiUrl(r5)     // Catch:{ all -> 0x008a }
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 5
            r10 = 0
            r5 = r12
            com.stripe.android.core.networking.ApiRequest$Options r12 = com.stripe.android.core.networking.ApiRequest.Options.copy$default(r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x008a }
            java.lang.String r5 = "account_holder_type"
            java.lang.String r6 = "individual"
            kotlin.Pair r5 = kotlin.TuplesKt.to(r5, r6)     // Catch:{ all -> 0x008a }
            java.util.Map r5 = kotlin.collections.MapsKt.mapOf(r5)     // Catch:{ all -> 0x008a }
            com.stripe.android.core.networking.ApiRequest r12 = r2.createGet(r4, r12, r5)     // Catch:{ all -> 0x008a }
            com.stripe.android.model.parsers.FpxBankStatusesJsonParser r2 = new com.stripe.android.model.parsers.FpxBankStatusesJsonParser     // Catch:{ all -> 0x008a }
            r2.<init>()     // Catch:{ all -> 0x008a }
            com.stripe.android.core.model.parsers.ModelJsonParser r2 = (com.stripe.android.core.model.parsers.ModelJsonParser) r2     // Catch:{ all -> 0x008a }
            com.stripe.android.networking.StripeApiRepository$getFpxBankStatus$2$fpxBankStatuses$1 r4 = new com.stripe.android.networking.StripeApiRepository$getFpxBankStatus$2$fpxBankStatuses$1     // Catch:{ all -> 0x008a }
            r4.<init>(r13)     // Catch:{ all -> 0x008a }
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4     // Catch:{ all -> 0x008a }
            r0.label = r3     // Catch:{ all -> 0x008a }
            java.lang.Object r13 = r13.fetchStripeModel(r12, r2, r4, r0)     // Catch:{ all -> 0x008a }
            if (r13 != r1) goto L_0x0075
            return r1
        L_0x0075:
            com.stripe.android.model.BankStatuses r13 = (com.stripe.android.model.BankStatuses) r13     // Catch:{ all -> 0x008a }
            if (r13 == 0) goto L_0x007e
            java.lang.Object r12 = kotlin.Result.m4709constructorimpl(r13)     // Catch:{ all -> 0x008a }
            goto L_0x0095
        L_0x007e:
            java.lang.String r12 = "Required value was null."
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x008a }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x008a }
            r13.<init>(r12)     // Catch:{ all -> 0x008a }
            throw r13     // Catch:{ all -> 0x008a }
        L_0x008a:
            r12 = move-exception
            kotlin.Result$Companion r13 = kotlin.Result.Companion
            java.lang.Object r12 = kotlin.ResultKt.createFailure(r12)
            java.lang.Object r12 = kotlin.Result.m4709constructorimpl(r12)
        L_0x0095:
            com.stripe.android.model.BankStatuses r13 = new com.stripe.android.model.BankStatuses
            r0 = 0
            r13.<init>(r0, r3, r0)
            boolean r0 = kotlin.Result.m4715isFailureimpl(r12)
            if (r0 == 0) goto L_0x00a2
            r12 = r13
        L_0x00a2:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.networking.StripeApiRepository.getFpxBankStatus$payments_core_release(com.stripe.android.core.networking.ApiRequest$Options, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b4 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getCardMetadata$payments_core_release(com.stripe.android.cards.Bin r12, com.stripe.android.core.networking.ApiRequest.Options r13, kotlin.coroutines.Continuation<? super com.stripe.android.model.CardMetadata> r14) {
        /*
            r11 = this;
            boolean r0 = r14 instanceof com.stripe.android.networking.StripeApiRepository$getCardMetadata$1
            if (r0 == 0) goto L_0x0014
            r0 = r14
            com.stripe.android.networking.StripeApiRepository$getCardMetadata$1 r0 = (com.stripe.android.networking.StripeApiRepository$getCardMetadata$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L_0x0019
        L_0x0014:
            com.stripe.android.networking.StripeApiRepository$getCardMetadata$1 r0 = new com.stripe.android.networking.StripeApiRepository$getCardMetadata$1
            r0.<init>(r11, r14)
        L_0x0019:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0038
            if (r2 != r3) goto L_0x0030
            java.lang.Object r12 = r0.L$0
            com.stripe.android.networking.StripeApiRepository r12 = (com.stripe.android.networking.StripeApiRepository) r12
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ all -> 0x002e }
            goto L_0x008f
        L_0x002e:
            r13 = move-exception
            goto L_0x0098
        L_0x0030:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r14)
            kotlin.Result$Companion r14 = kotlin.Result.Companion     // Catch:{ all -> 0x0096 }
            r14 = r11
            com.stripe.android.networking.StripeApiRepository r14 = (com.stripe.android.networking.StripeApiRepository) r14     // Catch:{ all -> 0x0096 }
            com.stripe.android.core.networking.ApiRequest$Factory r2 = r14.apiRequestFactory     // Catch:{ all -> 0x0096 }
            com.stripe.android.networking.StripeApiRepository$Companion r4 = Companion     // Catch:{ all -> 0x0096 }
            java.lang.String r5 = "card-metadata"
            java.lang.String r4 = r4.getEdgeUrl(r5)     // Catch:{ all -> 0x0096 }
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 5
            r10 = 0
            r5 = r13
            com.stripe.android.core.networking.ApiRequest$Options r5 = com.stripe.android.core.networking.ApiRequest.Options.copy$default(r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x0096 }
            r6 = 2
            kotlin.Pair[] r6 = new kotlin.Pair[r6]     // Catch:{ all -> 0x0096 }
            r7 = 0
            java.lang.String r8 = "key"
            java.lang.String r13 = r13.getApiKey()     // Catch:{ all -> 0x0096 }
            kotlin.Pair r13 = kotlin.TuplesKt.to(r8, r13)     // Catch:{ all -> 0x0096 }
            r6[r7] = r13     // Catch:{ all -> 0x0096 }
            java.lang.String r13 = "bin_prefix"
            java.lang.String r7 = r12.getValue()     // Catch:{ all -> 0x0096 }
            kotlin.Pair r13 = kotlin.TuplesKt.to(r13, r7)     // Catch:{ all -> 0x0096 }
            r6[r3] = r13     // Catch:{ all -> 0x0096 }
            java.util.Map r13 = kotlin.collections.MapsKt.mapOf(r6)     // Catch:{ all -> 0x0096 }
            com.stripe.android.core.networking.ApiRequest r13 = r2.createGet(r4, r5, r13)     // Catch:{ all -> 0x0096 }
            com.stripe.android.model.parsers.CardMetadataJsonParser r2 = new com.stripe.android.model.parsers.CardMetadataJsonParser     // Catch:{ all -> 0x0096 }
            r2.<init>(r12)     // Catch:{ all -> 0x0096 }
            com.stripe.android.core.model.parsers.ModelJsonParser r2 = (com.stripe.android.core.model.parsers.ModelJsonParser) r2     // Catch:{ all -> 0x0096 }
            com.stripe.android.networking.StripeApiRepository$getCardMetadata$2$1 r12 = com.stripe.android.networking.StripeApiRepository$getCardMetadata$2$1.INSTANCE     // Catch:{ all -> 0x0096 }
            kotlin.jvm.functions.Function0 r12 = (kotlin.jvm.functions.Function0) r12     // Catch:{ all -> 0x0096 }
            r0.L$0 = r11     // Catch:{ all -> 0x0096 }
            r0.label = r3     // Catch:{ all -> 0x0096 }
            java.lang.Object r14 = r14.fetchStripeModel(r13, r2, r12, r0)     // Catch:{ all -> 0x0096 }
            if (r14 != r1) goto L_0x008e
            return r1
        L_0x008e:
            r12 = r11
        L_0x008f:
            com.stripe.android.model.CardMetadata r14 = (com.stripe.android.model.CardMetadata) r14     // Catch:{ all -> 0x002e }
            java.lang.Object r13 = kotlin.Result.m4709constructorimpl(r14)     // Catch:{ all -> 0x002e }
            goto L_0x00a2
        L_0x0096:
            r13 = move-exception
            r12 = r11
        L_0x0098:
            kotlin.Result$Companion r14 = kotlin.Result.Companion
            java.lang.Object r13 = kotlin.ResultKt.createFailure(r13)
            java.lang.Object r13 = kotlin.Result.m4709constructorimpl(r13)
        L_0x00a2:
            java.lang.Throwable r14 = kotlin.Result.m4712exceptionOrNullimpl(r13)
            if (r14 != 0) goto L_0x00a9
            goto L_0x00ae
        L_0x00a9:
            com.stripe.android.networking.PaymentAnalyticsEvent r14 = com.stripe.android.networking.PaymentAnalyticsEvent.CardMetadataLoadFailure
            r12.fireAnalyticsRequest(r14)
        L_0x00ae:
            boolean r12 = kotlin.Result.m4715isFailureimpl(r13)
            if (r12 == 0) goto L_0x00b5
            r13 = 0
        L_0x00b5:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.networking.StripeApiRepository.getCardMetadata$payments_core_release(com.stripe.android.cards.Bin, com.stripe.android.core.networking.ApiRequest$Options, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object start3ds2Auth$payments_core_release(Stripe3ds2AuthParams stripe3ds2AuthParams, ApiRequest.Options options, Continuation<? super Stripe3ds2AuthResult> continuation) {
        return fetchStripeModel(this.apiRequestFactory.createPost(Companion.getApiUrl("3ds2/authenticate"), options, stripe3ds2AuthParams.toParamMap()), new Stripe3ds2AuthResultJsonParser(), new StripeApiRepository$start3ds2Auth$2(this), continuation);
    }

    public Object complete3ds2Auth$payments_core_release(String str, ApiRequest.Options options, Continuation<? super Stripe3ds2AuthResult> continuation) {
        return fetchStripeModel(this.apiRequestFactory.createPost(Companion.getApiUrl("3ds2/challenge_complete"), options, MapsKt.mapOf(TuplesKt.to("source", str))), new Stripe3ds2AuthResultJsonParser(), StripeApiRepository$complete3ds2Auth$2.INSTANCE, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object createFile$payments_core_release(com.stripe.android.core.model.StripeFileParams r12, com.stripe.android.core.networking.ApiRequest.Options r13, kotlin.coroutines.Continuation<? super com.stripe.android.core.model.StripeFile> r14) {
        /*
            r11 = this;
            boolean r0 = r14 instanceof com.stripe.android.networking.StripeApiRepository$createFile$1
            if (r0 == 0) goto L_0x0014
            r0 = r14
            com.stripe.android.networking.StripeApiRepository$createFile$1 r0 = (com.stripe.android.networking.StripeApiRepository$createFile$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L_0x0019
        L_0x0014:
            com.stripe.android.networking.StripeApiRepository$createFile$1 r0 = new com.stripe.android.networking.StripeApiRepository$createFile$1
            r0.<init>(r11, r14)
        L_0x0019:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x0053
        L_0x002a:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r14)
            com.stripe.android.core.networking.FileUploadRequest r14 = new com.stripe.android.core.networking.FileUploadRequest
            com.stripe.android.core.AppInfo r7 = r11.appInfo
            r8 = 0
            r9 = 8
            r10 = 0
            r4 = r14
            r5 = r12
            r6 = r13
            r4.<init>(r5, r6, r7, r8, r9, r10)
            com.stripe.android.networking.StripeApiRepository$createFile$response$1 r12 = new com.stripe.android.networking.StripeApiRepository$createFile$response$1
            r12.<init>(r11)
            kotlin.jvm.functions.Function1 r12 = (kotlin.jvm.functions.Function1) r12
            r0.label = r3
            java.lang.Object r14 = r11.makeFileUploadRequest$payments_core_release(r14, r12, r0)
            if (r14 != r1) goto L_0x0053
            return r1
        L_0x0053:
            com.stripe.android.core.networking.StripeResponse r14 = (com.stripe.android.core.networking.StripeResponse) r14
            com.stripe.android.core.model.parsers.StripeFileJsonParser r12 = new com.stripe.android.core.model.parsers.StripeFileJsonParser
            r12.<init>()
            org.json.JSONObject r13 = com.stripe.android.core.networking.StripeResponseKtxKt.responseJson(r14)
            com.stripe.android.core.model.StripeFile r12 = r12.parse((org.json.JSONObject) r13)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.networking.StripeApiRepository.createFile$payments_core_release(com.stripe.android.core.model.StripeFileParams, com.stripe.android.core.networking.ApiRequest$Options, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object retrieveObject$payments_core_release(java.lang.String r11, com.stripe.android.core.networking.ApiRequest.Options r12, kotlin.coroutines.Continuation<? super org.json.JSONObject> r13) throws java.lang.IllegalArgumentException, com.stripe.android.core.exception.InvalidRequestException, com.stripe.android.core.exception.APIConnectionException, com.stripe.android.core.exception.APIException, com.stripe.android.exception.CardException, com.stripe.android.core.exception.AuthenticationException {
        /*
            r10 = this;
            boolean r0 = r13 instanceof com.stripe.android.networking.StripeApiRepository$retrieveObject$1
            if (r0 == 0) goto L_0x0014
            r0 = r13
            com.stripe.android.networking.StripeApiRepository$retrieveObject$1 r0 = (com.stripe.android.networking.StripeApiRepository$retrieveObject$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L_0x0019
        L_0x0014:
            com.stripe.android.networking.StripeApiRepository$retrieveObject$1 r0 = new com.stripe.android.networking.StripeApiRepository$retrieveObject$1
            r0.<init>(r10, r13)
        L_0x0019:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0058
        L_0x002a:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r13)
            com.stripe.android.utils.StripeUrlUtils r13 = com.stripe.android.utils.StripeUrlUtils.INSTANCE
            boolean r13 = r13.isStripeUrl$payments_core_release(r11)
            if (r13 == 0) goto L_0x005f
            com.stripe.android.core.networking.ApiRequest$Factory r4 = r10.apiRequestFactory
            r7 = 0
            r8 = 4
            r9 = 0
            r5 = r11
            r6 = r12
            com.stripe.android.core.networking.ApiRequest r11 = com.stripe.android.core.networking.ApiRequest.Factory.createGet$default(r4, r5, r6, r7, r8, r9)
            com.stripe.android.networking.StripeApiRepository$retrieveObject$response$1 r12 = new com.stripe.android.networking.StripeApiRepository$retrieveObject$response$1
            r12.<init>(r10)
            kotlin.jvm.functions.Function0 r12 = (kotlin.jvm.functions.Function0) r12
            r0.label = r3
            java.lang.Object r13 = r10.makeApiRequest$payments_core_release(r11, r12, r0)
            if (r13 != r1) goto L_0x0058
            return r1
        L_0x0058:
            com.stripe.android.core.networking.StripeResponse r13 = (com.stripe.android.core.networking.StripeResponse) r13
            org.json.JSONObject r11 = com.stripe.android.core.networking.StripeResponseKtxKt.responseJson(r13)
            return r11
        L_0x005f:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.String r13 = "Unrecognized domain: "
            java.lang.String r11 = kotlin.jvm.internal.Intrinsics.stringPlus(r13, r11)
            r12.<init>(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.networking.StripeApiRepository.retrieveObject$payments_core_release(java.lang.String, com.stripe.android.core.networking.ApiRequest$Options, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0066 A[SYNTHETIC, Splitter:B:26:0x0066] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006d A[Catch:{ all -> 0x0042 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00dd A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object createRadarSession$payments_core_release(com.stripe.android.core.networking.ApiRequest.Options r9, kotlin.coroutines.Continuation<? super com.stripe.android.model.RadarSession> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.stripe.android.networking.StripeApiRepository$createRadarSession$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            com.stripe.android.networking.StripeApiRepository$createRadarSession$1 r0 = (com.stripe.android.networking.StripeApiRepository$createRadarSession$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            com.stripe.android.networking.StripeApiRepository$createRadarSession$1 r0 = new com.stripe.android.networking.StripeApiRepository$createRadarSession$1
            r0.<init>(r8, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0044
            if (r2 == r4) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x00d1
        L_0x002e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0036:
            java.lang.Object r9 = r0.L$1
            com.stripe.android.core.networking.ApiRequest$Options r9 = (com.stripe.android.core.networking.ApiRequest.Options) r9
            java.lang.Object r2 = r0.L$0
            com.stripe.android.networking.StripeApiRepository r2 = (com.stripe.android.networking.StripeApiRepository) r2
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x0042 }
            goto L_0x0064
        L_0x0042:
            r10 = move-exception
            goto L_0x0087
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r10)
            kotlin.Result$Companion r10 = kotlin.Result.Companion     // Catch:{ all -> 0x0085 }
            r10 = r8
            com.stripe.android.networking.StripeApiRepository r10 = (com.stripe.android.networking.StripeApiRepository) r10     // Catch:{ all -> 0x0085 }
            com.stripe.android.Stripe$Companion r2 = com.stripe.android.Stripe.Companion     // Catch:{ all -> 0x0085 }
            boolean r2 = r2.getAdvancedFraudSignalsEnabled()     // Catch:{ all -> 0x0085 }
            if (r2 == 0) goto L_0x0079
            com.stripe.android.FraudDetectionDataRepository r10 = r10.fraudDetectionDataRepository     // Catch:{ all -> 0x0085 }
            r0.L$0 = r8     // Catch:{ all -> 0x0085 }
            r0.L$1 = r9     // Catch:{ all -> 0x0085 }
            r0.label = r4     // Catch:{ all -> 0x0085 }
            java.lang.Object r10 = r10.getLatest(r0)     // Catch:{ all -> 0x0085 }
            if (r10 != r1) goto L_0x0063
            return r1
        L_0x0063:
            r2 = r8
        L_0x0064:
            if (r10 == 0) goto L_0x006d
            com.stripe.android.networking.FraudDetectionData r10 = (com.stripe.android.networking.FraudDetectionData) r10     // Catch:{ all -> 0x0042 }
            java.lang.Object r10 = kotlin.Result.m4709constructorimpl(r10)     // Catch:{ all -> 0x0042 }
            goto L_0x0091
        L_0x006d:
            java.lang.String r10 = "Could not obtain fraud data required to create a Radar Session."
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0042 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x0042 }
            r5.<init>(r10)     // Catch:{ all -> 0x0042 }
            throw r5     // Catch:{ all -> 0x0042 }
        L_0x0079:
            java.lang.String r10 = "Stripe.advancedFraudSignalsEnabled must be set to 'true' to create a Radar Session."
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0085 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x0085 }
            r2.<init>(r10)     // Catch:{ all -> 0x0085 }
            throw r2     // Catch:{ all -> 0x0085 }
        L_0x0085:
            r10 = move-exception
            r2 = r8
        L_0x0087:
            kotlin.Result$Companion r5 = kotlin.Result.Companion
            java.lang.Object r10 = kotlin.ResultKt.createFailure(r10)
            java.lang.Object r10 = kotlin.Result.m4709constructorimpl(r10)
        L_0x0091:
            boolean r5 = kotlin.Result.m4716isSuccessimpl(r10)
            if (r5 == 0) goto L_0x00d3
            kotlin.Result$Companion r5 = kotlin.Result.Companion
            com.stripe.android.networking.FraudDetectionData r10 = (com.stripe.android.networking.FraudDetectionData) r10
            java.util.Map r10 = r10.getParams()
            r5 = 0
            kotlin.Pair r4 = buildPaymentUserAgentPair$default(r2, r5, r4, r5)
            java.util.Map r10 = kotlin.collections.MapsKt.plus(r10, r4)
            com.stripe.android.core.networking.ApiRequest$Factory r4 = r2.apiRequestFactory
            com.stripe.android.networking.StripeApiRepository$Companion r6 = Companion
            java.lang.String r7 = "radar/session"
            java.lang.String r6 = r6.getApiUrl(r7)
            com.stripe.android.core.networking.ApiRequest r9 = r4.createPost(r6, r9, r10)
            com.stripe.android.model.parsers.RadarSessionJsonParser r10 = new com.stripe.android.model.parsers.RadarSessionJsonParser
            r10.<init>()
            com.stripe.android.core.model.parsers.ModelJsonParser r10 = (com.stripe.android.core.model.parsers.ModelJsonParser) r10
            com.stripe.android.networking.StripeApiRepository$createRadarSession$3$1 r4 = new com.stripe.android.networking.StripeApiRepository$createRadarSession$3$1
            r4.<init>(r2)
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            r0.L$0 = r5
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r10 = r2.fetchStripeModel(r9, r10, r4, r0)
            if (r10 != r1) goto L_0x00d1
            return r1
        L_0x00d1:
            com.stripe.android.model.RadarSession r10 = (com.stripe.android.model.RadarSession) r10
        L_0x00d3:
            java.lang.Object r9 = kotlin.Result.m4709constructorimpl(r10)
            java.lang.Throwable r10 = kotlin.Result.m4712exceptionOrNullimpl(r9)
            if (r10 != 0) goto L_0x00de
            return r9
        L_0x00de:
            com.stripe.android.core.exception.StripeException$Companion r9 = com.stripe.android.core.exception.StripeException.Companion
            com.stripe.android.core.exception.StripeException r9 = r9.create(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.networking.StripeApiRepository.createRadarSession$payments_core_release(com.stripe.android.core.networking.ApiRequest$Options, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object lookupConsumerSession(String str, String str2, ApiRequest.Options options, Continuation<? super ConsumerSessionLookup> continuation) {
        Map map;
        ApiRequest.Factory factory = this.apiRequestFactory;
        String consumerSessionLookupUrl$payments_core_release = Companion.getConsumerSessionLookupUrl$payments_core_release();
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        Map mapOf = MapsKt.mapOf(TuplesKt.to("email_address", lowerCase));
        if (str2 == null) {
            map = null;
        } else {
            map = MapsKt.mapOf(TuplesKt.to("cookies", MapsKt.mapOf(TuplesKt.to("verification_session_client_secrets", CollectionsKt.listOf(str2)))));
        }
        if (map == null) {
            map = MapsKt.emptyMap();
        }
        return fetchStripeModel(factory.createPost(consumerSessionLookupUrl$payments_core_release, options, MapsKt.plus(mapOf, map)), new ConsumerSessionLookupJsonParser(), StripeApiRepository$lookupConsumerSession$3.INSTANCE, continuation);
    }

    public Object consumerSignUp(String str, String str2, String str3, String str4, ApiRequest.Options options, Continuation<? super ConsumerSession> continuation) {
        Map map;
        ApiRequest.Factory factory = this.apiRequestFactory;
        String consumerSignUpUrl$payments_core_release = Companion.getConsumerSignUpUrl$payments_core_release();
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        Map mapOf = MapsKt.mapOf(TuplesKt.to("email_address", lowerCase), TuplesKt.to("phone_number", str2), TuplesKt.to("country", str3));
        if (str4 == null) {
            map = null;
        } else {
            map = MapsKt.mapOf(TuplesKt.to("cookies", MapsKt.mapOf(TuplesKt.to("verification_session_client_secrets", CollectionsKt.listOf(str4)))));
        }
        if (map == null) {
            map = MapsKt.emptyMap();
        }
        return fetchStripeModel(factory.createPost(consumerSignUpUrl$payments_core_release, options, MapsKt.plus(mapOf, map)), new ConsumerSessionJsonParser(), StripeApiRepository$consumerSignUp$3.INSTANCE, continuation);
    }

    public Object startConsumerVerification(String str, Locale locale, String str2, ApiRequest.Options options, Continuation<? super ConsumerSession> continuation) {
        Map map;
        ApiRequest.Factory factory = this.apiRequestFactory;
        String startConsumerVerificationUrl$payments_core_release = Companion.getStartConsumerVerificationUrl$payments_core_release();
        Map mapOf = MapsKt.mapOf(TuplesKt.to("credentials", MapsKt.mapOf(TuplesKt.to("consumer_session_client_secret", str))), TuplesKt.to("type", "SMS"), TuplesKt.to(LocaleProp.name, locale.toLanguageTag()));
        if (str2 == null) {
            map = null;
        } else {
            map = MapsKt.mapOf(TuplesKt.to("cookies", MapsKt.mapOf(TuplesKt.to("verification_session_client_secrets", CollectionsKt.listOf(str2)))));
        }
        if (map == null) {
            map = MapsKt.emptyMap();
        }
        return fetchStripeModel(factory.createPost(startConsumerVerificationUrl$payments_core_release, options, MapsKt.plus(mapOf, map)), new ConsumerSessionJsonParser(), StripeApiRepository$startConsumerVerification$3.INSTANCE, continuation);
    }

    public Object confirmConsumerVerification(String str, String str2, String str3, ApiRequest.Options options, Continuation<? super ConsumerSession> continuation) {
        Map map;
        ApiRequest.Factory factory = this.apiRequestFactory;
        String confirmConsumerVerificationUrl$payments_core_release = Companion.getConfirmConsumerVerificationUrl$payments_core_release();
        Map mapOf = MapsKt.mapOf(TuplesKt.to("credentials", MapsKt.mapOf(TuplesKt.to("consumer_session_client_secret", str))), TuplesKt.to("type", "SMS"), TuplesKt.to(PaymentMethodOptionsParams.Blik.PARAM_CODE, str2), TuplesKt.to("client_type", "MOBILE_SDK"));
        if (str3 == null) {
            map = null;
        } else {
            map = MapsKt.mapOf(TuplesKt.to("cookies", MapsKt.mapOf(TuplesKt.to("verification_session_client_secrets", CollectionsKt.listOf(str3)))));
        }
        if (map == null) {
            map = MapsKt.emptyMap();
        }
        return fetchStripeModel(factory.createPost(confirmConsumerVerificationUrl$payments_core_release, options, MapsKt.plus(mapOf, map)), new ConsumerSessionJsonParser(), StripeApiRepository$confirmConsumerVerification$3.INSTANCE, continuation);
    }

    public Object logoutConsumer(String str, String str2, ApiRequest.Options options, Continuation<? super ConsumerSession> continuation) {
        Map map;
        ApiRequest.Factory factory = this.apiRequestFactory;
        String logoutConsumerUrl$payments_core_release = Companion.getLogoutConsumerUrl$payments_core_release();
        Map mapOf = MapsKt.mapOf(TuplesKt.to("credentials", MapsKt.mapOf(TuplesKt.to("consumer_session_client_secret", str))));
        if (str2 == null) {
            map = null;
        } else {
            map = MapsKt.mapOf(TuplesKt.to("cookies", MapsKt.mapOf(TuplesKt.to("verification_session_client_secrets", CollectionsKt.listOf(str2)))));
        }
        if (map == null) {
            map = MapsKt.emptyMap();
        }
        return fetchStripeModel(factory.createPost(logoutConsumerUrl$payments_core_release, options, MapsKt.plus(mapOf, map)), new ConsumerSessionJsonParser(), StripeApiRepository$logoutConsumer$3.INSTANCE, continuation);
    }

    public Object listPaymentDetails(String str, Set<String> set, ApiRequest.Options options, Continuation<? super ConsumerPaymentDetails> continuation) {
        return fetchStripeModel(this.apiRequestFactory.createGet(Companion.getConsumerPaymentDetailsUrl$payments_core_release(), options, MapsKt.mapOf(TuplesKt.to("credentials", MapsKt.mapOf(TuplesKt.to("consumer_session_client_secret", str))), TuplesKt.to("types", CollectionsKt.toList(set)))), new ConsumerPaymentDetailsJsonParser(), StripeApiRepository$listPaymentDetails$2.INSTANCE, continuation);
    }

    public Object createPaymentIntentLinkAccountSession$payments_core_release(String str, CreateLinkAccountSessionParams createLinkAccountSessionParams, ApiRequest.Options options, Continuation<? super BankConnectionsLinkedAccountSession> continuation) {
        return fetchStripeModel(this.apiRequestFactory.createPost(getPaymentIntentLinkAccountSessionUrl$payments_core_release(str), options, createLinkAccountSessionParams.toMap()), new BankConnectionsLinkAccountSessionJsonParser(), StripeApiRepository$createPaymentIntentLinkAccountSession$2.INSTANCE, continuation);
    }

    public Object createSetupIntentLinkAccountSession$payments_core_release(String str, CreateLinkAccountSessionParams createLinkAccountSessionParams, ApiRequest.Options options, Continuation<? super BankConnectionsLinkedAccountSession> continuation) {
        return fetchStripeModel(this.apiRequestFactory.createPost(getSetupIntentLinkAccountSessionUrl$payments_core_release(str), options, createLinkAccountSessionParams.toMap()), new BankConnectionsLinkAccountSessionJsonParser(), StripeApiRepository$createSetupIntentLinkAccountSession$2.INSTANCE, continuation);
    }

    public final /* synthetic */ String getPaymentIntentLinkAccountSessionUrl$payments_core_release(String str) {
        Intrinsics.checkNotNullParameter(str, "paymentIntentId");
        return Companion.getApiUrl("payment_intents/%s/link_account_sessions", str);
    }

    public final /* synthetic */ String getSetupIntentLinkAccountSessionUrl$payments_core_release(String str) {
        Intrinsics.checkNotNullParameter(str, "setupIntentId");
        return Companion.getApiUrl("setup_intents/%s/link_account_sessions", str);
    }

    public Object attachLinkAccountSessionToPaymentIntent(String str, String str2, String str3, ApiRequest.Options options, Continuation<? super PaymentIntent> continuation) {
        return fetchStripeModel(this.apiRequestFactory.createPost(Companion.getAttachLinkAccountSessionToPaymentIntentUrl$payments_core_release(str2, str3), options, MapsKt.mapOf(TuplesKt.to("client_secret", str))), new PaymentIntentJsonParser(), StripeApiRepository$attachLinkAccountSessionToPaymentIntent$2.INSTANCE, continuation);
    }

    public Object attachLinkAccountSessionToSetupIntent(String str, String str2, String str3, ApiRequest.Options options, Continuation<? super SetupIntent> continuation) {
        return fetchStripeModel(this.apiRequestFactory.createPost(Companion.getAttachLinkAccountSessionToSetupIntentUrl$payments_core_release(str2, str3), options, MapsKt.mapOf(TuplesKt.to("client_secret", str))), new SetupIntentJsonParser(), StripeApiRepository$attachLinkAccountSessionToSetupIntent$2.INSTANCE, continuation);
    }

    public Object verifyPaymentIntentWithMicrodeposits(String str, int i, int i2, ApiRequest.Options options, Continuation<? super PaymentIntent> continuation) {
        return fetchStripeModel(this.apiRequestFactory.createPost(Companion.getVerifyMicrodepositsOnPaymentIntentUrl$payments_core_release(new PaymentIntent.ClientSecret(str).getPaymentIntentId$payments_core_release()), options, MapsKt.mapOf(TuplesKt.to("client_secret", str), TuplesKt.to("amounts", CollectionsKt.listOf(Boxing.boxInt(i), Boxing.boxInt(i2))))), new PaymentIntentJsonParser(), StripeApiRepository$verifyPaymentIntentWithMicrodeposits$2.INSTANCE, continuation);
    }

    public Object verifyPaymentIntentWithMicrodeposits(String str, String str2, ApiRequest.Options options, Continuation<? super PaymentIntent> continuation) {
        return fetchStripeModel(this.apiRequestFactory.createPost(Companion.getVerifyMicrodepositsOnPaymentIntentUrl$payments_core_release(new PaymentIntent.ClientSecret(str).getPaymentIntentId$payments_core_release()), options, MapsKt.mapOf(TuplesKt.to("client_secret", str), TuplesKt.to("descriptor_code", str2))), new PaymentIntentJsonParser(), StripeApiRepository$verifyPaymentIntentWithMicrodeposits$4.INSTANCE, continuation);
    }

    public Object verifySetupIntentWithMicrodeposits(String str, int i, int i2, ApiRequest.Options options, Continuation<? super SetupIntent> continuation) {
        return fetchStripeModel(this.apiRequestFactory.createPost(Companion.getVerifyMicrodepositsOnSetupIntentUrl$payments_core_release(new SetupIntent.ClientSecret(str).getSetupIntentId$payments_core_release()), options, MapsKt.mapOf(TuplesKt.to("client_secret", str), TuplesKt.to("amounts", CollectionsKt.listOf(Boxing.boxInt(i), Boxing.boxInt(i2))))), new SetupIntentJsonParser(), StripeApiRepository$verifySetupIntentWithMicrodeposits$2.INSTANCE, continuation);
    }

    public Object verifySetupIntentWithMicrodeposits(String str, String str2, ApiRequest.Options options, Continuation<? super SetupIntent> continuation) {
        return fetchStripeModel(this.apiRequestFactory.createPost(Companion.getVerifyMicrodepositsOnSetupIntentUrl$payments_core_release(new SetupIntent.ClientSecret(str).getSetupIntentId$payments_core_release()), options, MapsKt.mapOf(TuplesKt.to("client_secret", str), TuplesKt.to("descriptor_code", str2))), new SetupIntentJsonParser(), StripeApiRepository$verifySetupIntentWithMicrodeposits$4.INSTANCE, continuation);
    }

    public final String getDetachPaymentMethodUrl$payments_core_release(String str) {
        Intrinsics.checkNotNullParameter(str, "paymentMethodId");
        return Companion.getApiUrl("payment_methods/%s/detach", str);
    }

    /* access modifiers changed from: private */
    public final <T extends StripeIntent> Object retrieveStripeIntentWithOrderedPaymentMethods(String str, ApiRequest.Options options, Locale locale, PaymentMethodPreferenceJsonParser<? extends T> paymentMethodPreferenceJsonParser, PaymentAnalyticsEvent paymentAnalyticsEvent, Continuation<? super T> continuation) {
        if (options.getApiKeyIsUserKey()) {
            return null;
        }
        fireFraudDetectionDataRequest();
        return fetchStripeModel(this.apiRequestFactory.createGet(Companion.getApiUrl("elements/sessions"), options, MapsKt.plus(createClientSecretParam(str, CollectionsKt.listOf("payment_method_preference." + paymentMethodPreferenceJsonParser.getStripeIntentFieldName() + ".payment_method")), (Map<String, Object>) MapsKt.mapOf(TuplesKt.to("type", paymentMethodPreferenceJsonParser.getStripeIntentFieldName()), TuplesKt.to(LocaleProp.name, locale.toLanguageTag())))), paymentMethodPreferenceJsonParser, new StripeApiRepository$retrieveStripeIntentWithOrderedPaymentMethods$2(this, paymentAnalyticsEvent), continuation);
    }

    private final void handleApiError(StripeResponse<String> stripeResponse) throws InvalidRequestException, AuthenticationException, CardException, APIException {
        RequestId requestId = stripeResponse.getRequestId();
        String value = requestId == null ? null : requestId.getValue();
        int code = stripeResponse.getCode();
        StripeError parse = new StripeErrorJsonParser().parse(StripeResponseKtxKt.responseJson(stripeResponse));
        if (code != 429) {
            switch (code) {
                case StatFsHelper.DEFAULT_DISK_YELLOW_LEVEL_IN_MB:
                case WalletConstants.ERROR_CODE_INVALID_PARAMETERS:
                    throw new InvalidRequestException(parse, value, code, (String) null, (Throwable) null, 24, (DefaultConstructorMarker) null);
                case TypedValues.CycleType.TYPE_CURVE_FIT:
                    throw new AuthenticationException(parse, value);
                case 402:
                    throw new CardException(parse, value);
                case TypedValues.CycleType.TYPE_ALPHA:
                    throw new PermissionException(parse, value);
                default:
                    throw new APIException(parse, value, code, (String) null, (Throwable) null, 24, (DefaultConstructorMarker) null);
            }
        } else {
            throw new RateLimitException(parse, value, (String) null, (Throwable) null, 12, (DefaultConstructorMarker) null);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: com.stripe.android.core.model.parsers.ModelJsonParser<? extends ModelType>} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <ModelType extends com.stripe.android.core.model.StripeModel> java.lang.Object fetchStripeModel(com.stripe.android.core.networking.ApiRequest r5, com.stripe.android.core.model.parsers.ModelJsonParser<? extends ModelType> r6, kotlin.jvm.functions.Function0<kotlin.Unit> r7, kotlin.coroutines.Continuation<? super ModelType> r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.stripe.android.networking.StripeApiRepository$fetchStripeModel$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.stripe.android.networking.StripeApiRepository$fetchStripeModel$1 r0 = (com.stripe.android.networking.StripeApiRepository$fetchStripeModel$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.stripe.android.networking.StripeApiRepository$fetchStripeModel$1 r0 = new com.stripe.android.networking.StripeApiRepository$fetchStripeModel$1
            r0.<init>(r4, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r5 = r0.L$0
            r6 = r5
            com.stripe.android.core.model.parsers.ModelJsonParser r6 = (com.stripe.android.core.model.parsers.ModelJsonParser) r6
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0045
        L_0x002f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r8)
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r8 = r4.makeApiRequest$payments_core_release(r5, r7, r0)
            if (r8 != r1) goto L_0x0045
            return r1
        L_0x0045:
            com.stripe.android.core.networking.StripeResponse r8 = (com.stripe.android.core.networking.StripeResponse) r8
            org.json.JSONObject r5 = com.stripe.android.core.networking.StripeResponseKtxKt.responseJson(r8)
            com.stripe.android.core.model.StripeModel r5 = r6.parse(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.networking.StripeApiRepository.fetchStripeModel(com.stripe.android.core.networking.ApiRequest, com.stripe.android.core.model.parsers.ModelJsonParser, kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object makeApiRequest$payments_core_release(com.stripe.android.core.networking.ApiRequest r7, kotlin.jvm.functions.Function0<kotlin.Unit> r8, kotlin.coroutines.Continuation<? super com.stripe.android.core.networking.StripeResponse<java.lang.String>> r9) throws com.stripe.android.core.exception.AuthenticationException, com.stripe.android.core.exception.InvalidRequestException, com.stripe.android.core.exception.APIConnectionException, com.stripe.android.exception.CardException, com.stripe.android.core.exception.APIException {
        /*
            r6 = this;
            boolean r0 = r9 instanceof com.stripe.android.networking.StripeApiRepository$makeApiRequest$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.stripe.android.networking.StripeApiRepository$makeApiRequest$1 r0 = (com.stripe.android.networking.StripeApiRepository$makeApiRequest$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.stripe.android.networking.StripeApiRepository$makeApiRequest$1 r0 = new com.stripe.android.networking.StripeApiRepository$makeApiRequest$1
            r0.<init>(r6, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x004e
            if (r2 != r3) goto L_0x0046
            java.lang.Object r7 = r0.L$3
            com.stripe.android.networking.StripeApiRepository$DnsCacheData r7 = (com.stripe.android.networking.StripeApiRepository.DnsCacheData) r7
            java.lang.Object r8 = r0.L$2
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            java.lang.Object r1 = r0.L$1
            com.stripe.android.core.networking.ApiRequest r1 = (com.stripe.android.core.networking.ApiRequest) r1
            java.lang.Object r0 = r0.L$0
            com.stripe.android.networking.StripeApiRepository r0 = (com.stripe.android.networking.StripeApiRepository) r0
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ all -> 0x003f }
            r5 = r9
            r9 = r7
            r7 = r1
            r1 = r0
            r0 = r5
            goto L_0x0071
        L_0x003f:
            r9 = move-exception
            r5 = r9
            r9 = r7
            r7 = r1
            r1 = r0
            r0 = r5
            goto L_0x007c
        L_0x0046:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x004e:
            kotlin.ResultKt.throwOnFailure(r9)
            com.stripe.android.networking.StripeApiRepository$DnsCacheData r9 = r6.disableDnsCache()
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch:{ all -> 0x007a }
            r2 = r6
            com.stripe.android.networking.StripeApiRepository r2 = (com.stripe.android.networking.StripeApiRepository) r2     // Catch:{ all -> 0x007a }
            com.stripe.android.core.networking.StripeNetworkClient r2 = r2.stripeNetworkClient     // Catch:{ all -> 0x007a }
            r4 = r7
            com.stripe.android.core.networking.StripeRequest r4 = (com.stripe.android.core.networking.StripeRequest) r4     // Catch:{ all -> 0x007a }
            r0.L$0 = r6     // Catch:{ all -> 0x007a }
            r0.L$1 = r7     // Catch:{ all -> 0x007a }
            r0.L$2 = r8     // Catch:{ all -> 0x007a }
            r0.L$3 = r9     // Catch:{ all -> 0x007a }
            r0.label = r3     // Catch:{ all -> 0x007a }
            java.lang.Object r0 = r2.executeRequest(r4, r0)     // Catch:{ all -> 0x007a }
            if (r0 != r1) goto L_0x0070
            return r1
        L_0x0070:
            r1 = r6
        L_0x0071:
            com.stripe.android.core.networking.StripeResponse r0 = (com.stripe.android.core.networking.StripeResponse) r0     // Catch:{ all -> 0x0078 }
            java.lang.Object r0 = kotlin.Result.m4709constructorimpl(r0)     // Catch:{ all -> 0x0078 }
            goto L_0x0086
        L_0x0078:
            r0 = move-exception
            goto L_0x007c
        L_0x007a:
            r0 = move-exception
            r1 = r6
        L_0x007c:
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m4709constructorimpl(r0)
        L_0x0086:
            r8.invoke()
            java.lang.Throwable r8 = kotlin.Result.m4712exceptionOrNullimpl(r0)
            if (r8 != 0) goto L_0x009e
            com.stripe.android.core.networking.StripeResponse r0 = (com.stripe.android.core.networking.StripeResponse) r0
            boolean r7 = r0.isError()
            if (r7 == 0) goto L_0x009a
            r1.handleApiError(r0)
        L_0x009a:
            r1.resetDnsCache(r9)
            return r0
        L_0x009e:
            boolean r9 = r8 instanceof java.io.IOException
            if (r9 == 0) goto L_0x00b1
            com.stripe.android.core.exception.APIConnectionException$Companion r9 = com.stripe.android.core.exception.APIConnectionException.Companion
            java.io.IOException r8 = (java.io.IOException) r8
            java.lang.String r7 = r7.getBaseUrl()
            com.stripe.android.core.exception.APIConnectionException r7 = r9.create(r8, r7)
            r8 = r7
            java.lang.Throwable r8 = (java.lang.Throwable) r8
        L_0x00b1:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.networking.StripeApiRepository.makeApiRequest$payments_core_release(com.stripe.android.core.networking.ApiRequest, kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object makeFileUploadRequest$payments_core_release(com.stripe.android.core.networking.FileUploadRequest r7, kotlin.jvm.functions.Function1<? super com.stripe.android.core.networking.RequestId, kotlin.Unit> r8, kotlin.coroutines.Continuation<? super com.stripe.android.core.networking.StripeResponse<java.lang.String>> r9) throws com.stripe.android.core.exception.AuthenticationException, com.stripe.android.core.exception.InvalidRequestException, com.stripe.android.core.exception.APIConnectionException, com.stripe.android.exception.CardException, com.stripe.android.core.exception.APIException {
        /*
            r6 = this;
            boolean r0 = r9 instanceof com.stripe.android.networking.StripeApiRepository$makeFileUploadRequest$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.stripe.android.networking.StripeApiRepository$makeFileUploadRequest$1 r0 = (com.stripe.android.networking.StripeApiRepository$makeFileUploadRequest$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.stripe.android.networking.StripeApiRepository$makeFileUploadRequest$1 r0 = new com.stripe.android.networking.StripeApiRepository$makeFileUploadRequest$1
            r0.<init>(r6, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x004e
            if (r2 != r3) goto L_0x0046
            java.lang.Object r7 = r0.L$3
            com.stripe.android.networking.StripeApiRepository$DnsCacheData r7 = (com.stripe.android.networking.StripeApiRepository.DnsCacheData) r7
            java.lang.Object r8 = r0.L$2
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            java.lang.Object r1 = r0.L$1
            com.stripe.android.core.networking.FileUploadRequest r1 = (com.stripe.android.core.networking.FileUploadRequest) r1
            java.lang.Object r0 = r0.L$0
            com.stripe.android.networking.StripeApiRepository r0 = (com.stripe.android.networking.StripeApiRepository) r0
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ all -> 0x003f }
            r5 = r9
            r9 = r7
            r7 = r1
            r1 = r0
            r0 = r5
            goto L_0x0071
        L_0x003f:
            r9 = move-exception
            r5 = r9
            r9 = r7
            r7 = r1
            r1 = r0
            r0 = r5
            goto L_0x007c
        L_0x0046:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x004e:
            kotlin.ResultKt.throwOnFailure(r9)
            com.stripe.android.networking.StripeApiRepository$DnsCacheData r9 = r6.disableDnsCache()
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch:{ all -> 0x007a }
            r2 = r6
            com.stripe.android.networking.StripeApiRepository r2 = (com.stripe.android.networking.StripeApiRepository) r2     // Catch:{ all -> 0x007a }
            com.stripe.android.core.networking.StripeNetworkClient r2 = r2.stripeNetworkClient     // Catch:{ all -> 0x007a }
            r4 = r7
            com.stripe.android.core.networking.StripeRequest r4 = (com.stripe.android.core.networking.StripeRequest) r4     // Catch:{ all -> 0x007a }
            r0.L$0 = r6     // Catch:{ all -> 0x007a }
            r0.L$1 = r7     // Catch:{ all -> 0x007a }
            r0.L$2 = r8     // Catch:{ all -> 0x007a }
            r0.L$3 = r9     // Catch:{ all -> 0x007a }
            r0.label = r3     // Catch:{ all -> 0x007a }
            java.lang.Object r0 = r2.executeRequest(r4, r0)     // Catch:{ all -> 0x007a }
            if (r0 != r1) goto L_0x0070
            return r1
        L_0x0070:
            r1 = r6
        L_0x0071:
            com.stripe.android.core.networking.StripeResponse r0 = (com.stripe.android.core.networking.StripeResponse) r0     // Catch:{ all -> 0x0078 }
            java.lang.Object r0 = kotlin.Result.m4709constructorimpl(r0)     // Catch:{ all -> 0x0078 }
            goto L_0x0086
        L_0x0078:
            r0 = move-exception
            goto L_0x007c
        L_0x007a:
            r0 = move-exception
            r1 = r6
        L_0x007c:
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m4709constructorimpl(r0)
        L_0x0086:
            boolean r2 = kotlin.Result.m4715isFailureimpl(r0)
            r3 = 0
            if (r2 == 0) goto L_0x008f
            r2 = r3
            goto L_0x0090
        L_0x008f:
            r2 = r0
        L_0x0090:
            com.stripe.android.core.networking.StripeResponse r2 = (com.stripe.android.core.networking.StripeResponse) r2
            if (r2 != 0) goto L_0x0095
            goto L_0x0099
        L_0x0095:
            com.stripe.android.core.networking.RequestId r3 = r2.getRequestId()
        L_0x0099:
            r8.invoke(r3)
            java.lang.Throwable r8 = kotlin.Result.m4712exceptionOrNullimpl(r0)
            if (r8 != 0) goto L_0x00b1
            com.stripe.android.core.networking.StripeResponse r0 = (com.stripe.android.core.networking.StripeResponse) r0
            boolean r7 = r0.isError()
            if (r7 == 0) goto L_0x00ad
            r1.handleApiError(r0)
        L_0x00ad:
            r1.resetDnsCache(r9)
            return r0
        L_0x00b1:
            boolean r9 = r8 instanceof java.io.IOException
            if (r9 == 0) goto L_0x00c4
            com.stripe.android.core.exception.APIConnectionException$Companion r9 = com.stripe.android.core.exception.APIConnectionException.Companion
            java.io.IOException r8 = (java.io.IOException) r8
            java.lang.String r7 = r7.getUrl()
            com.stripe.android.core.exception.APIConnectionException r7 = r9.create(r8, r7)
            r8 = r7
            java.lang.Throwable r8 = (java.lang.Throwable) r8
        L_0x00c4:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.networking.StripeApiRepository.makeFileUploadRequest$payments_core_release(com.stripe.android.core.networking.FileUploadRequest, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final DnsCacheData disableDnsCache() {
        DnsCacheData.Failure failure;
        try {
            Result.Companion companion = Result.Companion;
            StripeApiRepository stripeApiRepository = this;
            String property = Security.getProperty(DNS_CACHE_TTL_PROPERTY_NAME);
            Security.setProperty(DNS_CACHE_TTL_PROPERTY_NAME, "0");
            failure = Result.m4709constructorimpl(new DnsCacheData.Success(property));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            failure = Result.m4709constructorimpl(ResultKt.createFailure(th));
        }
        DnsCacheData.Failure failure2 = DnsCacheData.Failure.INSTANCE;
        if (Result.m4715isFailureimpl(failure)) {
            failure = failure2;
        }
        return (DnsCacheData) failure;
    }

    private final void resetDnsCache(DnsCacheData dnsCacheData) {
        if (dnsCacheData instanceof DnsCacheData.Success) {
            String originalDnsCacheTtl = ((DnsCacheData.Success) dnsCacheData).getOriginalDnsCacheTtl();
            if (originalDnsCacheTtl == null) {
                originalDnsCacheTtl = "-1";
            }
            Security.setProperty(DNS_CACHE_TTL_PROPERTY_NAME, originalDnsCacheTtl);
        }
    }

    private final void fireFraudDetectionDataRequest() {
        this.fraudDetectionDataRepository.refresh();
    }

    /* access modifiers changed from: private */
    public final void fireAnalyticsRequest(PaymentAnalyticsEvent paymentAnalyticsEvent) {
        fireAnalyticsRequest$payments_core_release(PaymentAnalyticsRequestFactory.createRequest$payments_core_release$default(this.paymentAnalyticsRequestFactory, paymentAnalyticsEvent, (Set) null, (String) null, (Token.Type) null, (PaymentAnalyticsRequestFactory.ThreeDS2UiType) null, 30, (Object) null));
    }

    public final void fireAnalyticsRequest$payments_core_release(AnalyticsRequest analyticsRequest) {
        Intrinsics.checkNotNullParameter(analyticsRequest, "params");
        this.analyticsRequestExecutor.executeAsync(analyticsRequest);
    }

    private final Map<String, Object> createClientSecretParam(String str, List<String> list) {
        return MapsKt.plus(MapsKt.mapOf(TuplesKt.to("client_secret", str)), Companion.createExpandParam(list));
    }

    static /* synthetic */ Pair buildPaymentUserAgentPair$default(StripeApiRepository stripeApiRepository, Set set, int i, Object obj) {
        if ((i & 1) != 0) {
            set = SetsKt.emptySet();
        }
        return stripeApiRepository.buildPaymentUserAgentPair(set);
    }

    private final Pair<String, String> buildPaymentUserAgentPair(Set<String> set) {
        return TuplesKt.to(PAYMENT_USER_AGENT, CollectionsKt.joinToString$default(SetsKt.plus(SetsKt.plus(SetsKt.setOf("stripe-android/20.1.0"), this.productUsageTokens), set), ";", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
    }

    static /* synthetic */ Map maybeAddPaymentUserAgent$default(StripeApiRepository stripeApiRepository, Map map, PaymentMethodCreateParams paymentMethodCreateParams, SourceParams sourceParams, int i, Object obj) {
        if ((i & 4) != 0) {
            sourceParams = null;
        }
        return stripeApiRepository.maybeAddPaymentUserAgent(map, paymentMethodCreateParams, sourceParams);
    }

    private final Map<String, Object> maybeAddPaymentUserAgent(Map<String, ? extends Object> map, PaymentMethodCreateParams paymentMethodCreateParams, SourceParams sourceParams) {
        Map<K, V> map2;
        Set set;
        Object obj = map.get("payment_method_data");
        Set<String> set2 = null;
        Map map3 = obj instanceof Map ? (Map) obj : null;
        if (map3 == null) {
            map2 = null;
        } else {
            if (paymentMethodCreateParams == null) {
                set = null;
            } else {
                set = paymentMethodCreateParams.getAttribution$payments_core_release();
            }
            if (set == null) {
                set = SetsKt.emptySet();
            }
            map2 = MapsKt.plus(map, TuplesKt.to("payment_method_data", MapsKt.plus(map3, buildPaymentUserAgentPair(set))));
        }
        if (map2 == null) {
            Object obj2 = map.get(ConfirmPaymentIntentParams.PARAM_SOURCE_DATA);
            Map map4 = obj2 instanceof Map ? (Map) obj2 : null;
            if (map4 == null) {
                return map;
            }
            if (sourceParams != null) {
                set2 = sourceParams.getAttribution$payments_core_release();
            }
            if (set2 == null) {
                set2 = SetsKt.emptySet();
            }
            map2 = MapsKt.plus(map, TuplesKt.to(ConfirmPaymentIntentParams.PARAM_SOURCE_DATA, MapsKt.plus(map4, buildPaymentUserAgentPair(set2))));
            if (map2 == null) {
                return map;
            }
        }
        return map2;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object maybeForDashboard(com.stripe.android.model.ConfirmPaymentIntentParams r5, com.stripe.android.core.networking.ApiRequest.Options r6, kotlin.coroutines.Continuation<? super com.stripe.android.model.ConfirmPaymentIntentParams> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.stripe.android.networking.StripeApiRepository$maybeForDashboard$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.stripe.android.networking.StripeApiRepository$maybeForDashboard$1 r0 = (com.stripe.android.networking.StripeApiRepository$maybeForDashboard$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.stripe.android.networking.StripeApiRepository$maybeForDashboard$1 r0 = new com.stripe.android.networking.StripeApiRepository$maybeForDashboard$1
            r0.<init>(r4, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r5 = r0.L$0
            com.stripe.android.model.ConfirmPaymentIntentParams r5 = (com.stripe.android.model.ConfirmPaymentIntentParams) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0055
        L_0x002e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r7)
            boolean r7 = r6.getApiKeyIsUserKey()
            if (r7 == 0) goto L_0x0076
            com.stripe.android.model.PaymentMethodCreateParams r7 = r5.getPaymentMethodCreateParams()
            if (r7 != 0) goto L_0x0046
            goto L_0x0076
        L_0x0046:
            com.stripe.android.model.PaymentMethodCreateParams r7 = r5.getPaymentMethodCreateParams()
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r7 = r4.createPaymentMethod(r7, r6, r0)
            if (r7 != r1) goto L_0x0055
            return r1
        L_0x0055:
            com.stripe.android.model.PaymentMethod r7 = (com.stripe.android.model.PaymentMethod) r7
            if (r7 != 0) goto L_0x005b
            r6 = 0
            goto L_0x005d
        L_0x005b:
            java.lang.String r6 = r7.id
        L_0x005d:
            if (r6 == 0) goto L_0x006a
            com.stripe.android.model.ConfirmPaymentIntentParams$Companion r7 = com.stripe.android.model.ConfirmPaymentIntentParams.Companion
            java.lang.String r5 = r5.getClientSecret()
            com.stripe.android.model.ConfirmPaymentIntentParams r5 = r7.createForDashboard$payments_core_release(r5, r6)
            return r5
        L_0x006a:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "Required value was null."
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        L_0x0076:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.networking.StripeApiRepository.maybeForDashboard(com.stripe.android.model.ConfirmPaymentIntentParams, com.stripe.android.core.networking.ApiRequest$Options, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/networking/StripeApiRepository$DnsCacheData;", "", "()V", "Failure", "Success", "Lcom/stripe/android/networking/StripeApiRepository$DnsCacheData$Success;", "Lcom/stripe/android/networking/StripeApiRepository$DnsCacheData$Failure;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StripeApiRepository.kt */
    private static abstract class DnsCacheData {
        public /* synthetic */ DnsCacheData(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private DnsCacheData() {
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/stripe/android/networking/StripeApiRepository$DnsCacheData$Success;", "Lcom/stripe/android/networking/StripeApiRepository$DnsCacheData;", "originalDnsCacheTtl", "", "(Ljava/lang/String;)V", "getOriginalDnsCacheTtl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: StripeApiRepository.kt */
        public static final class Success extends DnsCacheData {
            public static final int $stable = 0;
            private final String originalDnsCacheTtl;

            public static /* synthetic */ Success copy$default(Success success, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = success.originalDnsCacheTtl;
                }
                return success.copy(str);
            }

            public final String component1() {
                return this.originalDnsCacheTtl;
            }

            public final Success copy(String str) {
                return new Success(str);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Success) && Intrinsics.areEqual((Object) this.originalDnsCacheTtl, (Object) ((Success) obj).originalDnsCacheTtl);
            }

            public int hashCode() {
                String str = this.originalDnsCacheTtl;
                if (str == null) {
                    return 0;
                }
                return str.hashCode();
            }

            public String toString() {
                return "Success(originalDnsCacheTtl=" + this.originalDnsCacheTtl + ')';
            }

            public final String getOriginalDnsCacheTtl() {
                return this.originalDnsCacheTtl;
            }

            public Success(String str) {
                super((DefaultConstructorMarker) null);
                this.originalDnsCacheTtl = str;
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/stripe/android/networking/StripeApiRepository$DnsCacheData$Failure;", "Lcom/stripe/android/networking/StripeApiRepository$DnsCacheData;", "()V", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: StripeApiRepository.kt */
        public static final class Failure extends DnsCacheData {
            public static final int $stable = 0;
            public static final Failure INSTANCE = new Failure();

            private Failure() {
                super((DefaultConstructorMarker) null);
            }
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\b-\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001b0\u001a2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u001bH\u0002J$\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001a2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0004H\u0002J\u0015\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0004H\u0001¢\u0006\u0002\b\"J\u0010\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0004H\u0002J)\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u0012\u0010%\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010&\"\u00020\u0001H\u0002¢\u0006\u0002\u0010'J\u001d\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u0004H\u0001¢\u0006\u0002\b+J\u001d\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u0004H\u0001¢\u0006\u0002\b.J\u0015\u0010/\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u0004H\u0001¢\u0006\u0002\b1J\u0015\u00102\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u0004H\u0001¢\u0006\u0002\b3J\u0015\u00104\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u0004H\u0001¢\u0006\u0002\b5J\u0015\u00106\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u0004H\u0001¢\u0006\u0002\b7J\u0015\u00108\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u0004H\u0001¢\u0006\u0002\b9J\u001d\u0010:\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010;\u001a\u00020\u0004H\u0001¢\u0006\u0002\b<J\u0010\u0010=\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0004H\u0002J\u0015\u0010>\u001a\u00020\u00042\u0006\u0010?\u001a\u00020\u0004H\u0001¢\u0006\u0002\b@J\u0015\u0010A\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u0004H\u0001¢\u0006\u0002\bBJ\u0015\u0010C\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0004H\u0001¢\u0006\u0002\bDJ\u0015\u0010E\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u0004H\u0001¢\u0006\u0002\bFJ\u0015\u0010G\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u0004H\u0001¢\u0006\u0002\bHJ\u0015\u0010I\u001a\u00020\u00042\u0006\u0010;\u001a\u00020\u0004H\u0001¢\u0006\u0002\bJJ\u0015\u0010K\u001a\u00020\u00042\u0006\u0010L\u001a\u00020\u0004H\u0001¢\u0006\u0002\bMJ\u0015\u0010N\u001a\u00020\u00042\u0006\u0010O\u001a\u00020\u0004H\u0001¢\u0006\u0002\bPJ\u0015\u0010Q\u001a\u00020\u00042\u0006\u0010O\u001a\u00020\u0004H\u0001¢\u0006\u0002\bRR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00048@X\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00048@X\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00048@X\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u00048@X\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\bR\u0014\u0010\u000f\u001a\u00020\u00048@X\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\bR\u0014\u0010\u0011\u001a\u00020\u00048@X\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\bR\u0014\u0010\u0013\u001a\u00020\u00048@X\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\bR\u0014\u0010\u0015\u001a\u00020\u00048@X\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\bR\u0014\u0010\u0017\u001a\u00020\u00048@X\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\b¨\u0006S"}, d2 = {"Lcom/stripe/android/networking/StripeApiRepository$Companion;", "", "()V", "DNS_CACHE_TTL_PROPERTY_NAME", "", "PAYMENT_USER_AGENT", "confirmConsumerVerificationUrl", "getConfirmConsumerVerificationUrl$payments_core_release", "()Ljava/lang/String;", "consumerPaymentDetailsUrl", "getConsumerPaymentDetailsUrl$payments_core_release", "consumerSessionLookupUrl", "getConsumerSessionLookupUrl$payments_core_release", "consumerSignUpUrl", "getConsumerSignUpUrl$payments_core_release", "logoutConsumerUrl", "getLogoutConsumerUrl$payments_core_release", "paymentMethodsUrl", "getPaymentMethodsUrl$payments_core_release", "sourcesUrl", "getSourcesUrl$payments_core_release", "startConsumerVerificationUrl", "getStartConsumerVerificationUrl$payments_core_release", "tokensUrl", "getTokensUrl$payments_core_release", "createExpandParam", "", "", "expandFields", "createVerificationParam", "verificationId", "userOneTimeCode", "getAddCustomerSourceUrl", "customerId", "getAddCustomerSourceUrl$payments_core_release", "getApiUrl", "path", "args", "", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "getAttachLinkAccountSessionToPaymentIntentUrl", "paymentIntentId", "linkAccountSessionId", "getAttachLinkAccountSessionToPaymentIntentUrl$payments_core_release", "getAttachLinkAccountSessionToSetupIntentUrl", "setupIntentId", "getAttachLinkAccountSessionToSetupIntentUrl$payments_core_release", "getAttachPaymentMethodUrl", "paymentMethodId", "getAttachPaymentMethodUrl$payments_core_release", "getCancelPaymentIntentSourceUrl", "getCancelPaymentIntentSourceUrl$payments_core_release", "getCancelSetupIntentSourceUrl", "getCancelSetupIntentSourceUrl$payments_core_release", "getConfirmPaymentIntentUrl", "getConfirmPaymentIntentUrl$payments_core_release", "getConfirmSetupIntentUrl", "getConfirmSetupIntentUrl$payments_core_release", "getDeleteCustomerSourceUrl", "sourceId", "getDeleteCustomerSourceUrl$payments_core_release", "getEdgeUrl", "getIssuingCardPinUrl", "cardId", "getIssuingCardPinUrl$payments_core_release", "getRefreshPaymentIntentUrl", "getRefreshPaymentIntentUrl$payments_core_release", "getRetrieveCustomerUrl", "getRetrieveCustomerUrl$payments_core_release", "getRetrievePaymentIntentUrl", "getRetrievePaymentIntentUrl$payments_core_release", "getRetrieveSetupIntentUrl", "getRetrieveSetupIntentUrl$payments_core_release", "getRetrieveSourceApiUrl", "getRetrieveSourceApiUrl$payments_core_release", "getRetrieveTokenApiUrl", "tokenId", "getRetrieveTokenApiUrl$payments_core_release", "getVerifyMicrodepositsOnPaymentIntentUrl", "clientSecret", "getVerifyMicrodepositsOnPaymentIntentUrl$payments_core_release", "getVerifyMicrodepositsOnSetupIntentUrl", "getVerifyMicrodepositsOnSetupIntentUrl$payments_core_release", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StripeApiRepository.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final Map<String, String> createVerificationParam(String str, String str2) {
            return MapsKt.mapOf(TuplesKt.to(MessageExtension.FIELD_ID, str), TuplesKt.to("one_time_code", str2));
        }

        public final /* synthetic */ String getTokensUrl$payments_core_release() {
            return getApiUrl("tokens");
        }

        public final /* synthetic */ String getSourcesUrl$payments_core_release() {
            return getApiUrl("sources");
        }

        public final /* synthetic */ String getPaymentMethodsUrl$payments_core_release() {
            return getApiUrl("payment_methods");
        }

        public final /* synthetic */ String getConsumerSessionLookupUrl$payments_core_release() {
            return getApiUrl("consumers/sessions/lookup");
        }

        public final /* synthetic */ String getConsumerSignUpUrl$payments_core_release() {
            return getApiUrl("consumers/accounts/sign_up");
        }

        public final /* synthetic */ String getStartConsumerVerificationUrl$payments_core_release() {
            return getApiUrl("consumers/sessions/start_verification");
        }

        public final /* synthetic */ String getConfirmConsumerVerificationUrl$payments_core_release() {
            return getApiUrl("consumers/sessions/confirm_verification");
        }

        public final /* synthetic */ String getLogoutConsumerUrl$payments_core_release() {
            return getApiUrl("consumers/sessions/log_out");
        }

        public final /* synthetic */ String getConsumerPaymentDetailsUrl$payments_core_release() {
            return getApiUrl("consumers/payment_details");
        }

        public final /* synthetic */ String getRetrievePaymentIntentUrl$payments_core_release(String str) {
            Intrinsics.checkNotNullParameter(str, "paymentIntentId");
            return getApiUrl("payment_intents/%s", str);
        }

        public final /* synthetic */ String getRefreshPaymentIntentUrl$payments_core_release(String str) {
            Intrinsics.checkNotNullParameter(str, "paymentIntentId");
            return getApiUrl("payment_intents/%s/refresh", str);
        }

        public final /* synthetic */ String getConfirmPaymentIntentUrl$payments_core_release(String str) {
            Intrinsics.checkNotNullParameter(str, "paymentIntentId");
            return getApiUrl("payment_intents/%s/confirm", str);
        }

        public final /* synthetic */ String getCancelPaymentIntentSourceUrl$payments_core_release(String str) {
            Intrinsics.checkNotNullParameter(str, "paymentIntentId");
            return getApiUrl("payment_intents/%s/source_cancel", str);
        }

        public final /* synthetic */ String getRetrieveSetupIntentUrl$payments_core_release(String str) {
            Intrinsics.checkNotNullParameter(str, "setupIntentId");
            return getApiUrl("setup_intents/%s", str);
        }

        public final /* synthetic */ String getConfirmSetupIntentUrl$payments_core_release(String str) {
            Intrinsics.checkNotNullParameter(str, "setupIntentId");
            return getApiUrl("setup_intents/%s/confirm", str);
        }

        public final /* synthetic */ String getCancelSetupIntentSourceUrl$payments_core_release(String str) {
            Intrinsics.checkNotNullParameter(str, "setupIntentId");
            return getApiUrl("setup_intents/%s/source_cancel", str);
        }

        public final /* synthetic */ String getAddCustomerSourceUrl$payments_core_release(String str) {
            Intrinsics.checkNotNullParameter(str, "customerId");
            return getApiUrl("customers/%s/sources", str);
        }

        public final /* synthetic */ String getDeleteCustomerSourceUrl$payments_core_release(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "customerId");
            Intrinsics.checkNotNullParameter(str2, "sourceId");
            return getApiUrl("customers/%s/sources/%s", str, str2);
        }

        public final /* synthetic */ String getAttachPaymentMethodUrl$payments_core_release(String str) {
            Intrinsics.checkNotNullParameter(str, "paymentMethodId");
            return getApiUrl("payment_methods/%s/attach", str);
        }

        public final /* synthetic */ String getRetrieveCustomerUrl$payments_core_release(String str) {
            Intrinsics.checkNotNullParameter(str, "customerId");
            return getApiUrl("customers/%s", str);
        }

        public final /* synthetic */ String getRetrieveSourceApiUrl$payments_core_release(String str) {
            Intrinsics.checkNotNullParameter(str, "sourceId");
            return getApiUrl("sources/%s", str);
        }

        public final /* synthetic */ String getRetrieveTokenApiUrl$payments_core_release(String str) {
            Intrinsics.checkNotNullParameter(str, "tokenId");
            return getApiUrl("tokens/%s", str);
        }

        public final /* synthetic */ String getAttachLinkAccountSessionToPaymentIntentUrl$payments_core_release(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "paymentIntentId");
            Intrinsics.checkNotNullParameter(str2, "linkAccountSessionId");
            return getApiUrl("payment_intents/%s/link_account_sessions/%s/attach", str, str2);
        }

        public final /* synthetic */ String getAttachLinkAccountSessionToSetupIntentUrl$payments_core_release(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "setupIntentId");
            Intrinsics.checkNotNullParameter(str2, "linkAccountSessionId");
            return getApiUrl("setup_intents/%s/link_account_sessions/%s/attach", str, str2);
        }

        public final /* synthetic */ String getVerifyMicrodepositsOnPaymentIntentUrl$payments_core_release(String str) {
            Intrinsics.checkNotNullParameter(str, "clientSecret");
            return getApiUrl("payment_intents/%s/verify_microdeposits", str);
        }

        public final /* synthetic */ String getVerifyMicrodepositsOnSetupIntentUrl$payments_core_release(String str) {
            Intrinsics.checkNotNullParameter(str, "clientSecret");
            return getApiUrl("setup_intents/%s/verify_microdeposits", str);
        }

        public final /* synthetic */ String getIssuingCardPinUrl$payments_core_release(String str) {
            Intrinsics.checkNotNullParameter(str, "cardId");
            return getApiUrl("issuing/cards/%s/pin", str);
        }

        /* access modifiers changed from: private */
        public final String getApiUrl(String str, Object... objArr) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Locale locale = Locale.ENGLISH;
            Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
            String format = String.format(locale, str, Arrays.copyOf(copyOf, copyOf.length));
            Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
            return getApiUrl(format);
        }

        /* access modifiers changed from: private */
        public final String getApiUrl(String str) {
            return Intrinsics.stringPlus("https://api.stripe.com/v1/", str);
        }

        /* access modifiers changed from: private */
        public final String getEdgeUrl(String str) {
            return Intrinsics.stringPlus("https://api.stripe.com/edge-internal/", str);
        }

        /* access modifiers changed from: private */
        public final Map<String, List<String>> createExpandParam(List<String> list) {
            Map<String, List<String>> map = null;
            if (!(!list.isEmpty())) {
                list = null;
            }
            if (list != null) {
                map = MapsKt.mapOf(TuplesKt.to("expand", list));
            }
            return map == null ? MapsKt.emptyMap() : map;
        }
    }
}
